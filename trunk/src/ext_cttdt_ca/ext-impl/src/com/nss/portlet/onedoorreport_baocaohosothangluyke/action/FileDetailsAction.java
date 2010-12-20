package com.nss.portlet.onedoorreport_baocaohosothangluyke.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletSession;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.WindowState;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.export.JExcelApiExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sourceforge.rtf.StringUtils;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.struts.PortletAction;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.servlet.ServletResponseUtil;
import com.nss.portlet.department.model.Department;
import com.nss.portlet.department.model.PmlUser;
import com.nss.portlet.department.service.DepartmentLocalServiceUtil;
import com.nss.portlet.department.service.PmlUserLocalServiceUtil;
import com.nss.portlet.filetype.model.PmlFileType;
import com.nss.portlet.filetype.service.PmlFileTypeLocalServiceUtil;
import com.nss.portlet.onedoor.model.PmlFilePCCC;
import com.nss.portlet.onedoor.model.PmlFileStatusStateProcess;
import com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile;
import com.nss.portlet.onedoor.model.PmlProcessDispose;
import com.nss.portlet.onedoor.service.PmlFilePCCCLocalServiceUtil;
import com.nss.portlet.onedoor.service.PmlFileStatusStateProcessLocalServiceUtil;
import com.nss.portlet.onedoor.service.PmlOneDoorReceiveFileLocalServiceUtil;
import com.nss.portlet.onedoor.service.PmlProcessDisposeLocalServiceUtil;
import com.nss.portlet.onedoor.util.BaoCaoHoSo_FileDetailUtil;
import com.nss.portlet.onedoorprocess.dto.PmlFilePcccDTO;
import com.nss.portlet.onedoorreport_baocaohosothangluyke.searchfiledetail.PmlOneDoorReceiveFileSearch;
import com.nss.workflowonedoor.OneDoorProcessLiferayWorkflowService;

public class FileDetailsAction extends PortletAction {
	
	@Override
	public void processAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
		String report = ParamUtil.getString(req, "actionReport");
		String reportType = ParamUtil.getString(req, "reportType");
		
		// lay gia tri de xuat file
		String action = ParamUtil.getString(req, "action", "");
		String departmentId = ParamUtil.getString(req, "departmentId");
		String fileTypeId = ParamUtil.getString(req, "fileTypeId", "");
		
		String stringFromDate = ParamUtil.getString(req, "fromDate");
		String stringToDate = ParamUtil.getString(req, "toDate");
		SimpleDateFormat sF = new SimpleDateFormat("dd/MM/yyyy");
		if (Validator.isNull(stringFromDate)) {
			stringFromDate = sF.format(new Date());
		}
		
		if (Validator.isNull(stringToDate)) {
			stringToDate = sF.format(new Date());
		}
		
		Date fromDate =sF.parse(stringFromDate);
		Date toDate = sF.parse(stringToDate);
		
		// dieu kien loc
		String type = ParamUtil.getString(req, "type", "");
		String valueType = ParamUtil.getString(req, "valueType", "");
		String beginDateParam = ParamUtil.getString(req,"beginDate", "");
		String endDateParam = ParamUtil.getString(req,"endDate","");
		String fileTypeFilter = ParamUtil.getString(req,"fileTypeFilter", "");
		String sort = ParamUtil.getString(req,"sort","");
		boolean loadData = ParamUtil.getBoolean(req, "loadData", false);
		
		if (!"".equals(valueType)) {
			fileTypeFilter = "";
			beginDateParam = "";
			endDateParam = "";
		}
		
		if (!"".equals(beginDateParam) && !"".equals(endDateParam)   ) {
			valueType = beginDateParam +"_" + endDateParam;
			fileTypeFilter = "";
		} 
		
		if (!"".equals(fileTypeFilter)) {
			valueType = fileTypeFilter;
			beginDateParam = "";
			endDateParam = "";
		}
		
		PortletSession session = req.getPortletSession(true);
		List<String> valueTypeList = (List<String>) session.getAttribute("keyWordList", PortletSession.APPLICATION_SCOPE);
		List<String> typeList = (List<String>) session.getAttribute("typeFilterList", PortletSession.APPLICATION_SCOPE);
		
		if (!report.equals("report")) {
			if (!loadData) {
				if ("".equals(type)&& !"sort".equals(sort)) {
					valueTypeList = new ArrayList<String>();
					typeList = new ArrayList<String>();
				}
				
				if (valueTypeList == null) {
					valueTypeList = new ArrayList<String>();
					if (!"".equals(type)) {
						valueTypeList.add(valueType);
					}
				} else {
					if (!"".equals(type)) {
						valueTypeList.add(valueType);
					}
				}
		
				if (typeList == null) {
					typeList = new ArrayList<String>();
					if (!"".equals(type)) {
						typeList.add(type);
					}
				} else {
					if (!"".equals(type)) {
						typeList.add(type);
					}	
				}
				
				session.setAttribute("keyWordList", valueTypeList,PortletSession.APPLICATION_SCOPE);
				session.setAttribute("typeFilterList", typeList,PortletSession.APPLICATION_SCOPE);
			}
		}
		
		// xuat file
		if (report.equals("report")) {
			if (reportType.equals("word")) {
				reportFileByUser(req, res, reportType, getResult(action, departmentId, fileTypeId, fromDate, toDate, typeList, valueTypeList));
			} else if (reportType.equals("excel")) {
				reportFileByUserExcel(req, res, reportType, getResult(action, departmentId, fileTypeId, fromDate, toDate, typeList, valueTypeList));
			}
		}
	}
	
	/*
	 *  danh sach co duoc tu trang view
	 */
	private List<PmlOneDoorReceiveFile> getResult(String action, String departmentId,
							String fileTypeId, Date fromDate, Date toDate,
							List<String> typeList, List<String> valueTypeList) throws SystemException {
		
		List<PmlOneDoorReceiveFile> listResults = new ArrayList<PmlOneDoorReceiveFile>();
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String toDay = df.format(toDate);
		String fromDay = df.format(fromDate);
		
		List<Department> pmlDepartmentList = DepartmentLocalServiceUtil.getDepartments(-1, -1);
		List<Long> allUserList = new ArrayList<Long>();
		for(int i = 0; i < pmlDepartmentList.size(); i ++) {
			List<PmlUser> pmlUserList = null;
			try {
				pmlUserList = PmlUserLocalServiceUtil.findByDepartmentsId(pmlDepartmentList.get(i).getDepartmentsId());
			} catch (Exception e) {
				pmlUserList = new ArrayList<PmlUser>();
			}
			for (int j = 0; j < pmlUserList.size(); j++) {
				allUserList.add(pmlUserList.get(j).getUserId());
			}
		}
		
		// Lay danh sach user thuoc pmlDepartmentId
		List<PmlUser> pmlUserList = null;
		try {
			pmlUserList = PmlUserLocalServiceUtil.findByDepartmentsId(departmentId);
		} catch (Exception e) {
			pmlUserList = new ArrayList<PmlUser>();
		}
		List<Long> longList = new ArrayList<Long>();
		for (int i = 0; i < pmlUserList.size(); i++) {
			longList.add(pmlUserList.get(i).getUserId());
		}
		
		String startDateOfYear = "";
		if (null != toDate) {
			String[] date = toDay.split("-");
			startDateOfYear = "01/01/"+date[0];
		}
		
		// tinh toan cho fileType trong mot departmetn cu the
		if (action.equals("tenloaihoso")) {
			if ((!"".equals(fileTypeId)) && (!"".equals(departmentId))) { // fileTypeId
				listResults = PmlOneDoorReceiveFileLocalServiceUtil.getListHSNhanTrongNamThangLuyKe("", longList, fileTypeId, startDateOfYear, toDay, typeList, valueTypeList, -1, -1, null);
			} 
			else if (("".equals(fileTypeId)) && (!"".equals(departmentId))) { // departmentId
				listResults = PmlOneDoorReceiveFileLocalServiceUtil.getListHSNhanTrongNamThangLuyKe(departmentId, longList, "", startDateOfYear, toDay, typeList, valueTypeList, -1, -1, null);
			} 
		}
		
		else if (action.equals("tondauky")) { 
			if ((!"".equals(fileTypeId)) && (!"".equals(departmentId))) { // fileTypeId
				listResults = PmlOneDoorReceiveFileLocalServiceUtil.getListTonDauKyThangLuyKe("", longList, fileTypeId, fromDay, toDay, typeList, valueTypeList, -1, -1, null);
			}
			else if (("".equals(fileTypeId)) && (!"".equals(departmentId))) { // departmentId
				listResults = PmlOneDoorReceiveFileLocalServiceUtil.getListTonDauKyThangLuyKe(departmentId, longList, "", fromDay, toDay, typeList, valueTypeList, -1, -1, null);
			}
			else if (("".equals(fileTypeId)) && ("".equals(departmentId))) { // total
				listResults = PmlOneDoorReceiveFileLocalServiceUtil.getListTonDauKyThangLuyKe("", allUserList, "", fromDay, toDay, typeList, valueTypeList, -1, -1, null);
			}
		} 
		
		else if (action.equals("trongthanghosonhan")) {
			if ((!"".equals(fileTypeId)) && (!"".equals(departmentId))) {
				listResults = PmlOneDoorReceiveFileLocalServiceUtil.getListHSNhanTrongThangThangLuyKe("", longList, fileTypeId, fromDay, toDay, typeList, valueTypeList, -1, -1, null);
			} 
			else if (("".equals(fileTypeId)) && (!"".equals(departmentId))) {
				listResults = PmlOneDoorReceiveFileLocalServiceUtil.getListHSNhanTrongThangThangLuyKe(departmentId, longList, "", fromDay, toDay, typeList, valueTypeList, -1, -1, null);
			} 
			else if (("".equals(fileTypeId)) && ("".equals(departmentId))) {
				listResults = PmlOneDoorReceiveFileLocalServiceUtil.getListHSNhanTrongThangThangLuyKe("", allUserList, "", fromDay, toDay, typeList, valueTypeList, -1, -1, null);
			}
		} 
		
		else if (action.equals("tongcong")) {
			if ((!"".equals(fileTypeId)) && (!"".equals(departmentId))) {
				listResults = PmlOneDoorReceiveFileLocalServiceUtil.getListTongHSNhanThangLuyKe("", longList, fileTypeId, fromDay, toDay, typeList, valueTypeList, -1, -1, null);
			} 
			else if (("".equals(fileTypeId)) && (!"".equals(departmentId))) {
				listResults = PmlOneDoorReceiveFileLocalServiceUtil.getListTongHSNhanThangLuyKe(departmentId, longList, "", fromDay, toDay, typeList, valueTypeList, -1, -1, null);
			} 
			else if (("".equals(fileTypeId)) && ("".equals(departmentId))) {
				listResults = PmlOneDoorReceiveFileLocalServiceUtil.getListTongHSNhanThangLuyKe("", allUserList, "", fromDay, toDay, typeList, valueTypeList, -1, -1, null);
			}
		} 
		
		else if (action.equals("trongnamhosonhan")) {
			if ((!"".equals(fileTypeId)) && (!"".equals(departmentId))) {
				listResults = PmlOneDoorReceiveFileLocalServiceUtil.getListHSNhanTrongNamThangLuyKe("", longList, fileTypeId, startDateOfYear, toDay, typeList, valueTypeList, -1, -1, null);
			}
			else if (("".equals(fileTypeId)) && (!"".equals(departmentId))) {
				listResults = PmlOneDoorReceiveFileLocalServiceUtil.getListHSNhanTrongNamThangLuyKe(departmentId, longList, "", startDateOfYear, toDay, typeList, valueTypeList, -1, -1, null);
			}
			else if (("".equals(fileTypeId)) && ("".equals(departmentId))) {
				listResults = PmlOneDoorReceiveFileLocalServiceUtil.getListHSNhanTrongNamThangLuyKe("", allUserList, "", startDateOfYear, toDay, typeList, valueTypeList, -1, -1, null);
			}
		} 
		
		else if (action.equals("trongthanghosogiaiquyet")) {
			if ((!"".equals(fileTypeId)) && (!"".equals(departmentId))) {
				listResults = PmlOneDoorReceiveFileLocalServiceUtil.getListHSGiaiQuyetTrongThangLuyKe("", longList, fileTypeId, fromDay, toDay, typeList, valueTypeList, -1, -1, null);
			} 
			else if (("".equals(fileTypeId)) && (!"".equals(departmentId))) {
				listResults = PmlOneDoorReceiveFileLocalServiceUtil.getListHSGiaiQuyetTrongThangLuyKe(departmentId, longList, "", fromDay, toDay, typeList, valueTypeList, -1, -1, null);
			} 
			else if (("".equals(fileTypeId)) && ("".equals(departmentId))) {
				listResults = PmlOneDoorReceiveFileLocalServiceUtil.getListHSGiaiQuyetTrongThangLuyKe("", allUserList, "", fromDay, toDay, typeList, valueTypeList, -1, -1, null);
			}
		}
		
		else if (action.equals("trongnamhosogiaiquyet")) {
			if ((!"".equals(fileTypeId)) && (!"".equals(departmentId))) {
				listResults = PmlOneDoorReceiveFileLocalServiceUtil.getListHSGiaiQuyetTrongNamLuyKe("", longList, fileTypeId, startDateOfYear, toDay, typeList, valueTypeList, -1, -1, null);
			} 
			else if (("".equals(fileTypeId)) && (!"".equals(departmentId))) {
				listResults = PmlOneDoorReceiveFileLocalServiceUtil.getListHSGiaiQuyetTrongNamLuyKe(departmentId, longList, "", startDateOfYear, toDay, typeList, valueTypeList, -1, -1, null);
			} 
			else if (("".equals(fileTypeId)) && ("".equals(departmentId))) {
				listResults = PmlOneDoorReceiveFileLocalServiceUtil.getListHSGiaiQuyetTrongNamLuyKe("", allUserList, "", startDateOfYear, toDay, typeList, valueTypeList, -1, -1, null);
			}
		} 
		
		else if (action.equals("hosoton")) {
			
			if ((!"".equals(fileTypeId)) && (!"".equals(departmentId))) {
				listResults = PmlOneDoorReceiveFileLocalServiceUtil.getListHSTonDenNgayBCThangLuyKe("", longList, fileTypeId, toDay, typeList, valueTypeList, -1, -1, null);
			} 
			else if (("".equals(fileTypeId)) && (!"".equals(departmentId))) {
				listResults = PmlOneDoorReceiveFileLocalServiceUtil.getListHSTonDenNgayBCThangLuyKe(departmentId, longList, "", toDay, typeList, valueTypeList, -1, -1, null);
			}
			else if (("".equals(fileTypeId)) && ("".equals(departmentId))) {
				listResults = PmlOneDoorReceiveFileLocalServiceUtil.getListHSTonDenNgayBCThangLuyKe("", allUserList, "", toDay, typeList, valueTypeList, -1, -1, null);
			}
		}
		
		return listResults;
	}
	
	/*
	 * xuat ra file word
	 */
	private void reportFileByUser(ActionRequest req, ActionResponse res,
			String reportType, List<PmlOneDoorReceiveFile> listResults) throws Exception {
		
		HttpServletRequest request = PortalUtil.getHttpServletRequest(req);
		HttpServletResponse response = PortalUtil.getHttpServletResponse(res);
		String path = request.getSession().getServletContext().getRealPath("reports");
		BaoCaoHoSo_FileDetailUtil rtfUtil = new BaoCaoHoSo_FileDetailUtil(path, getPmlFilePcccDTOReport(listResults, reportType));
		InputStream in = rtfUtil.run(request.getSession().getServletContext().getRealPath("reports/ReportFileByUserFileDetail.rtf"));
		ServletResponseUtil.sendFile(response, "report.rtf", in, "application/rtf");
	}
	
	
	/*
	 * xuat file excel
	 */
	private void reportFileByUserExcel(ActionRequest req, ActionResponse res,
			String reportType, List<PmlOneDoorReceiveFile> listResults) throws Exception {
			
		ServletContext context = PortalUtil.getHttpServletRequest(req).getSession().getServletContext();
		HttpServletResponse response = PortalUtil.getHttpServletResponse(res);
		JRExporter exporter = null;
		
		JasperDesign subDesign1 = JRXmlLoader.load(context.getRealPath("reports/ReportFileByUserFileDetail_subreport.jrxml"));
		JasperReport subJasperReport1 = JasperCompileManager.compileReport(subDesign1);
		
		Map subMap1 = new HashMap();
		
		JRBeanCollectionDataSource dataSource1 = new JRBeanCollectionDataSource(getPmlFilePcccDTOReport(listResults, reportType));
		
		JasperCompileManager.compileReportToFile(context.getRealPath("reports/ReportFileByUserFileDetail.jrxml"), 
												context.getRealPath("reports/ReportFileByUserFileDetail.jasper"));
		
		Map map = new HashMap();
		map.put("dataSource1", dataSource1);
		map.put("subReport1", subJasperReport1);
		map.put("subMap1", subMap1);
		
		JREmptyDataSource dataSource = new JREmptyDataSource();
		
		JasperFillManager.fillReportToFile(context.getRealPath("reports/ReportFileByUserFileDetail.jasper"),
											context.getRealPath("reports/ReportFileByUserFileDetail.jrprint"), map, dataSource);
		
		File srcFile = new File(context.getRealPath("reports/ReportFileByUserFileDetail.jrprint"));
		File desFile = null;
		
		JasperPrint jasperPrint = (JasperPrint) JRLoader.loadObject(srcFile);
		desFile = File.createTempFile(jasperPrint.getName(), ".xls");
		
		exporter = new JExcelApiExporter();
		exporter.setParameter(JRXlsExporterParameter.JASPER_PRINT, jasperPrint);
		exporter.setParameter(JRXlsExporterParameter.OUTPUT_FILE_NAME, desFile.toString());
		exporter.exportReport();
		
		InputStream in = new FileInputStream(desFile);
		ServletResponseUtil.sendFile(response, "ReportFileByUserFileDetail.xls", in, "application/vnd.ms-excel");
	}
	
	private List<PmlFilePcccDTO> getPmlFilePcccDTOReport(List<PmlOneDoorReceiveFile> list, String reportType)throws Exception {

		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		
		List<PmlFilePcccDTO> result = new ArrayList<PmlFilePcccDTO>();
		
		if (list == null) {
			list = new ArrayList<PmlOneDoorReceiveFile>();
		}
		
		if (list.size() == 0) {
			PmlFilePcccDTO filePcccDTO = new PmlFilePcccDTO();
			
			filePcccDTO.setStt("");
			filePcccDTO.setFileId("");
			filePcccDTO.setFileName("");
			filePcccDTO.setFiletype("");
			filePcccDTO.setReceiveDateReport("");
			filePcccDTO.setStatus("");
			filePcccDTO.setExpectedReturingDateReport("");
			
			result.add(filePcccDTO);
		} else {
			// sap xep theo ma ho so
			Collections.sort(list, new Comparator<PmlOneDoorReceiveFile>() {
				public int compare(PmlOneDoorReceiveFile o1, PmlOneDoorReceiveFile o2) {
					return o2.getFileId().compareTo (o1.getFileId());
				}
			});
			
			for (PmlOneDoorReceiveFile file : list) {
				PmlFilePcccDTO filePcccDTO = new PmlFilePcccDTO();
				
				// stt
				filePcccDTO.setStt((result.size() + 1) + ".");
				
				// ma ho so
				filePcccDTO.setFileId(file.getFileId());
				
				// ten ho so
				PmlFilePCCC filePCCC = PmlFilePCCCLocalServiceUtil.getPmlFilePCCC(file.getFileId());
				if (reportType.equals("word")) {
					filePcccDTO.setFileName(StringUtils.convertToRTF(filePCCC.getFileName()));
				} else if (reportType.equals("excel")) {
					filePcccDTO.setFileName(filePCCC.getFileName());
				}
				
				// loai ho so
				PmlFileType fileType = PmlFileTypeLocalServiceUtil.getPmlFileType(file.getFileTypeId());
				if (reportType.equals("word")) {
					filePcccDTO.setFiletype(StringUtils.convertToRTF(fileType.getFileTypeName()));
				} else if (reportType.equals("excel")) {
					filePcccDTO.setFiletype(fileType.getFileTypeName());
				}
				
				PmlProcessDispose log = null;
				try {
					log = getProcessDipose(file.getFileId());
				} catch (Exception e) {
				}
				
				if (log != null) {
					// ngay nhan
					filePcccDTO.setReceiveDateReport(log.getReceiveDate() != null ? df.format(log.getReceiveDate()) : "");
					
					// trang thai ho so
					PmlFileStatusStateProcess fileStatusStateProcess = null;
					try {
						fileStatusStateProcess = PmlFileStatusStateProcessLocalServiceUtil.findByStateProcessId(log.getStateProcessIdBefore()).get(0);
						if (reportType.equals("word")) {
							filePcccDTO.setStatus(StringUtils.convertToRTF(fileStatusStateProcess.getDescription()));
						} else if (reportType.equals("excel")) {
							filePcccDTO.setStatus(fileStatusStateProcess.getDescription());
						}
					} catch (Exception e) {
						filePcccDTO.setStatus("");
					}
				}
				
				// ngay hen tra khach
				filePcccDTO.setExpectedReturingDateReport(df.format(file.getExpectedReturningDate()));
				
				result.add(filePcccDTO);
			}
		}
		
		return result;
	}
	
	@Override
	public ActionForward render(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
		if (getForward(req) != null && !getForward(req).equals("")) {
			return mapping.findForward(getForward(req)); // Use forward set in processAction if available
		} else {
				
			String report = ParamUtil.getString(req, "actionReport");
			
			List<PmlFilePcccDTO> pmlFilePcccList = new ArrayList<PmlFilePcccDTO>();
			
			String action = ParamUtil.getString(req, "action", "");
			String departmentId = ParamUtil.getString(req, "departmentId");
			String fileTypeId = ParamUtil.getString(req, "fileTypeId", "");
			
			String stringFromDate = ParamUtil.getString(req, "fromDate");
			String stringToDate = ParamUtil.getString(req, "toDate");
			SimpleDateFormat sF = new SimpleDateFormat("dd/MM/yyyy");
			if (Validator.isNull(stringFromDate)) {
				stringFromDate = sF.format(new Date());
			}
			
			if (Validator.isNull(stringToDate)) {
				stringToDate = sF.format(new Date());
			}
			
			Date fromDate =sF.parse(stringFromDate);
			Date toDate = sF.parse(stringToDate);
			
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			String toDay = df.format(toDate);
			String fromDay = df.format(fromDate);
			String redirect = ParamUtil.getString(req, "redirect");
			
			String type = ParamUtil.getString(req, "type", "");
			String valueType = ParamUtil.getString(req, "valueType", "");
			String beginDateParam = ParamUtil.getString(req,"beginDate", "");
			String endDateParam = ParamUtil.getString(req,"endDate","");
			
			String fileTypeFilter = ParamUtil.getString(req,"fileTypeFilter", "");
			String sort = ParamUtil.getString(req,"sort","");
			int lastMsgId = ParamUtil.getInteger(req, "last_msg_id", 0);
			boolean loadData = ParamUtil.getBoolean(req, "loadData", false);
			
			if (!"".equals(valueType)) {
				fileTypeFilter = "";
				beginDateParam = "";
				endDateParam = "";
			}
			
			if (!"".equals(beginDateParam) && !"".equals(endDateParam)   ) {
				valueType = beginDateParam +"_" + endDateParam;
				fileTypeFilter = "";
			} 
			
			if (!"".equals(fileTypeFilter)) {
				valueType = fileTypeFilter;
				beginDateParam = "";
				endDateParam = "";
			}
			
			PortletSession session = req.getPortletSession(true);
			List<String> valueTypeList = (List<String>) session.getAttribute("keyWordList", PortletSession.APPLICATION_SCOPE);
			List<String> typeList = (List<String>) session.getAttribute("typeFilterList", PortletSession.APPLICATION_SCOPE);
			
			if (!report.equals("report")) {
				if (!loadData) {
					if ("".equals(type)&& !"sort".equals(sort)) {
						valueTypeList = new ArrayList<String>();
						typeList = new ArrayList<String>();
					}
					
					if (valueTypeList == null) {
						valueTypeList = new ArrayList<String>();
						if (!"".equals(type)) {
							valueTypeList.add(valueType);
						}
					} else {
						if (!"".equals(type)) {
							valueTypeList.add(valueType);
						}
					}
			
					if (typeList == null) {
						typeList = new ArrayList<String>();
						if (!"".equals(type)) {
							typeList.add(type);
						}
					} else {
						if (!"".equals(type)) {
							typeList.add(type);
						}	
					}
					
					session.setAttribute("keyWordList", valueTypeList,PortletSession.APPLICATION_SCOPE);
					session.setAttribute("typeFilterList", typeList,PortletSession.APPLICATION_SCOPE);
				}
			}
			
			PortletURL portletURL = res.createRenderURL();
			portletURL.setWindowState(WindowState.NORMAL);
			portletURL.setParameter("struts_action", "/nss/onedoorreport_baocaohosothangluyke/filedetails");
			portletURL.setParameter("type", type);
			portletURL.setParameter("valueType", valueType);
			portletURL.setParameter("beginDateParam", beginDateParam);
			portletURL.setParameter("endDateParam", endDateParam);
			portletURL.setParameter("fileTypeFilter", fileTypeFilter);
			
			portletURL.setParameter("action", action);
			portletURL.setParameter("departmentId", departmentId);
			portletURL.setParameter("fileTypeId", fileTypeId);
			portletURL.setParameter("fromDate", stringFromDate);
			portletURL.setParameter("toDate", stringToDate);
			portletURL.setParameter("redirect", redirect);
			PmlOneDoorReceiveFileSearch searchContainer = new PmlOneDoorReceiveFileSearch(req, portletURL);
			
			List<Department> pmlDepartmentList = DepartmentLocalServiceUtil.getDepartments(-1, -1);
			List<Long> allUserList = new ArrayList<Long>();
			for(int i = 0; i < pmlDepartmentList.size(); i ++) {
				List<PmlUser> pmlUserList = null;
				try {
					pmlUserList = PmlUserLocalServiceUtil.findByDepartmentsId(pmlDepartmentList.get(i).getDepartmentsId());
				} catch (Exception e) {
					pmlUserList = new ArrayList<PmlUser>();
				}
				for (int j = 0; j < pmlUserList.size(); j++) {
					allUserList.add(pmlUserList.get(j).getUserId());
				}
			}
			List<PmlOneDoorReceiveFile> pmlOneDoorReceiveFileList = new ArrayList<PmlOneDoorReceiveFile>();
			// Lay danh sach user thuoc pmlDepartmentId
			List<PmlUser> pmlUserList = null;
			try {
				pmlUserList = PmlUserLocalServiceUtil.findByDepartmentsId(departmentId);
			} catch (Exception e) {
				pmlUserList = new ArrayList<PmlUser>();
			}
			List<Long> longList = new ArrayList<Long>();
			for (int i = 0; i < pmlUserList.size(); i++) {
				longList.add(pmlUserList.get(i).getUserId());
			}
			
			String startDateOfYear = "";
			if (null != toDate) {
				String[] date = toDay.split("-");
				// Ngay dau tien cua nam bao cao (ex: 01/01/2000)
				startDateOfYear = "01/01/"+date[0];
			}
			// tinh toan cho fileType trong mot departmetn cu the
			if (action.equals("tenloaihoso")) {
				pmlFilePcccList = new ArrayList<PmlFilePcccDTO>(); //yenlt 20/03/2010
				if ((!"".equals(fileTypeId)) && (!"".equals(departmentId))) { // fileTypeId
					pmlOneDoorReceiveFileList = PmlOneDoorReceiveFileLocalServiceUtil.getListHSNhanTrongNamThangLuyKe("", longList, fileTypeId, startDateOfYear, toDay, typeList, valueTypeList, lastMsgId, lastMsgId + 20, searchContainer.getOrderByComparator());
					
				} else if (("".equals(fileTypeId)) && (!"".equals(departmentId))) { // departmentId
					pmlOneDoorReceiveFileList = PmlOneDoorReceiveFileLocalServiceUtil.getListHSNhanTrongNamThangLuyKe(departmentId, longList, "", startDateOfYear, toDay, typeList, valueTypeList, lastMsgId, lastMsgId + 20, searchContainer.getOrderByComparator());
				} 
			} else if (action.equals("tondauky")) { 
				if ((!"".equals(fileTypeId)) && (!"".equals(departmentId))) { // fileTypeId
					pmlOneDoorReceiveFileList = PmlOneDoorReceiveFileLocalServiceUtil.getListTonDauKyThangLuyKe("", longList, fileTypeId, fromDay, toDay, typeList, valueTypeList, lastMsgId, lastMsgId + 20, searchContainer.getOrderByComparator());
					
				} else if (("".equals(fileTypeId)) && (!"".equals(departmentId))) { // departmentId
					pmlOneDoorReceiveFileList = PmlOneDoorReceiveFileLocalServiceUtil.getListTonDauKyThangLuyKe(departmentId, longList, "", fromDay, toDay, typeList, valueTypeList, lastMsgId, lastMsgId + 20, searchContainer.getOrderByComparator());
					
				} else if (("".equals(fileTypeId)) && ("".equals(departmentId))) { // total
					pmlOneDoorReceiveFileList = PmlOneDoorReceiveFileLocalServiceUtil.getListTonDauKyThangLuyKe("",allUserList, "", fromDay, toDay, typeList, valueTypeList, lastMsgId, lastMsgId + 20, searchContainer.getOrderByComparator());
				}
			} else if (action.equals("trongthanghosonhan")) {
				if ((!"".equals(fileTypeId)) && (!"".equals(departmentId))) {
					pmlOneDoorReceiveFileList = PmlOneDoorReceiveFileLocalServiceUtil.getListHSNhanTrongThangThangLuyKe("", longList, fileTypeId, fromDay, toDay, typeList, valueTypeList, lastMsgId, lastMsgId + 20 , searchContainer.getOrderByComparator());
					
				} else if (("".equals(fileTypeId)) && (!"".equals(departmentId))) {
					pmlOneDoorReceiveFileList = PmlOneDoorReceiveFileLocalServiceUtil.getListHSNhanTrongThangThangLuyKe(departmentId, longList, "", fromDay, toDay, typeList, valueTypeList, lastMsgId, lastMsgId + 20 , searchContainer.getOrderByComparator());
					
				} else if (("".equals(fileTypeId)) && ("".equals(departmentId))) {
					pmlOneDoorReceiveFileList = PmlOneDoorReceiveFileLocalServiceUtil.getListHSNhanTrongThangThangLuyKe("", allUserList, "", fromDay, toDay, typeList, valueTypeList, lastMsgId, lastMsgId + 20 , searchContainer.getOrderByComparator());
				}
			} else if (action.equals("tongcong")) {
				if ((!"".equals(fileTypeId)) && (!"".equals(departmentId))) {
					pmlOneDoorReceiveFileList = PmlOneDoorReceiveFileLocalServiceUtil.getListTongHSNhanThangLuyKe("", longList, fileTypeId, fromDay, toDay, typeList, valueTypeList, lastMsgId, lastMsgId + 20, searchContainer.getOrderByComparator());
					
				} else if (("".equals(fileTypeId)) && (!"".equals(departmentId))) {
					pmlOneDoorReceiveFileList = PmlOneDoorReceiveFileLocalServiceUtil.getListTongHSNhanThangLuyKe(departmentId, longList, "", fromDay, toDay, typeList, valueTypeList, lastMsgId, lastMsgId + 20, searchContainer.getOrderByComparator());
					
				} else if (("".equals(fileTypeId)) && ("".equals(departmentId))) {
					pmlOneDoorReceiveFileList = PmlOneDoorReceiveFileLocalServiceUtil.getListTongHSNhanThangLuyKe("", allUserList, "", fromDay, toDay, typeList, valueTypeList, lastMsgId, lastMsgId + 20, searchContainer.getOrderByComparator());
				}
			} else if (action.equals("trongnamhosonhan")) {
				if ((!"".equals(fileTypeId)) && (!"".equals(departmentId))) {
					pmlOneDoorReceiveFileList = PmlOneDoorReceiveFileLocalServiceUtil.getListHSNhanTrongNamThangLuyKe("", longList, fileTypeId, startDateOfYear, toDay, typeList, valueTypeList, lastMsgId, lastMsgId + 20, searchContainer.getOrderByComparator());
					
				} else if (("".equals(fileTypeId)) && (!"".equals(departmentId))) {
					pmlOneDoorReceiveFileList = PmlOneDoorReceiveFileLocalServiceUtil.getListHSNhanTrongNamThangLuyKe(departmentId, longList, "", startDateOfYear, toDay, typeList, valueTypeList, lastMsgId, lastMsgId + 20, searchContainer.getOrderByComparator());
					
				} else if (("".equals(fileTypeId)) && ("".equals(departmentId))) {
					pmlOneDoorReceiveFileList = PmlOneDoorReceiveFileLocalServiceUtil.getListHSNhanTrongNamThangLuyKe("", allUserList, "", startDateOfYear, toDay, typeList, valueTypeList, lastMsgId, lastMsgId + 20, searchContainer.getOrderByComparator());
				}
			} else if (action.equals("trongthanghosogiaiquyet")) {
				if ((!"".equals(fileTypeId)) && (!"".equals(departmentId))) {
					pmlOneDoorReceiveFileList = PmlOneDoorReceiveFileLocalServiceUtil.getListHSGiaiQuyetTrongThangLuyKe("", longList, fileTypeId, fromDay, toDay, typeList, valueTypeList, lastMsgId, lastMsgId + 20, searchContainer.getOrderByComparator());
					
				} else if (("".equals(fileTypeId)) && (!"".equals(departmentId))) {
					pmlOneDoorReceiveFileList = PmlOneDoorReceiveFileLocalServiceUtil.getListHSGiaiQuyetTrongThangLuyKe(departmentId, longList, "", fromDay, toDay, typeList, valueTypeList, lastMsgId, lastMsgId + 20, searchContainer.getOrderByComparator());
					
				} else if (("".equals(fileTypeId)) && ("".equals(departmentId))) {
					pmlOneDoorReceiveFileList = PmlOneDoorReceiveFileLocalServiceUtil.getListHSGiaiQuyetTrongThangLuyKe("", allUserList, "", fromDay, toDay, typeList, valueTypeList, lastMsgId, lastMsgId + 20, searchContainer.getOrderByComparator());
				}
			} else if (action.equals("trongnamhosogiaiquyet")) {
				if ((!"".equals(fileTypeId)) && (!"".equals(departmentId))) {
					pmlOneDoorReceiveFileList = PmlOneDoorReceiveFileLocalServiceUtil.getListHSGiaiQuyetTrongNamLuyKe("", longList, fileTypeId, startDateOfYear, toDay, typeList, valueTypeList, lastMsgId, lastMsgId + 20, searchContainer.getOrderByComparator());
					
				} else if (("".equals(fileTypeId)) && (!"".equals(departmentId))) {
					pmlOneDoorReceiveFileList = PmlOneDoorReceiveFileLocalServiceUtil.getListHSGiaiQuyetTrongNamLuyKe(departmentId, longList, "", startDateOfYear, toDay, typeList, valueTypeList, lastMsgId, lastMsgId + 20, searchContainer.getOrderByComparator());
					
				} else if (("".equals(fileTypeId)) && ("".equals(departmentId))) {
					pmlOneDoorReceiveFileList = PmlOneDoorReceiveFileLocalServiceUtil.getListHSGiaiQuyetTrongNamLuyKe("", allUserList, "", startDateOfYear, toDay, typeList, valueTypeList, lastMsgId, lastMsgId + 20, searchContainer.getOrderByComparator());
				}
			} else if (action.equals("hosoton")) {
				pmlFilePcccList = new ArrayList<PmlFilePcccDTO>(); //yenlt 20/03/2010
				
				if ((!"".equals(fileTypeId)) && (!"".equals(departmentId))) {
					pmlOneDoorReceiveFileList = PmlOneDoorReceiveFileLocalServiceUtil.getListHSTonDenNgayBCThangLuyKe("", longList, fileTypeId, toDay, typeList, valueTypeList, lastMsgId, lastMsgId + 20, searchContainer.getOrderByComparator());
					
				} else if (("".equals(fileTypeId)) && (!"".equals(departmentId))) {
					pmlOneDoorReceiveFileList = PmlOneDoorReceiveFileLocalServiceUtil.getListHSTonDenNgayBCThangLuyKe(departmentId, longList, "", toDay, typeList, valueTypeList, lastMsgId, lastMsgId + 20, searchContainer.getOrderByComparator());
					
				} else if (("".equals(fileTypeId)) && ("".equals(departmentId))) {
					pmlOneDoorReceiveFileList = PmlOneDoorReceiveFileLocalServiceUtil.getListHSTonDenNgayBCThangLuyKe("", allUserList, "", toDay, typeList, valueTypeList, lastMsgId, lastMsgId + 20, searchContainer.getOrderByComparator());
				}
			}
			
			pmlFilePcccList = add2DTO(pmlOneDoorReceiveFileList);
			// phan loc theo loai ho so
			List<PmlFileType> fileTypeList = new ArrayList<PmlFileType>();
			try {
				fileTypeList = PmlFileTypeLocalServiceUtil.findAll();
			} catch (Exception e) {
				fileTypeList = new ArrayList<PmlFileType>();
				System.out.println("ERROR: Get List FileType: "+ e.getMessage());
			}
			
			req.setAttribute("fileTypeList", fileTypeList);
			
			req.setAttribute("fromDate", stringFromDate);
			req.setAttribute("toDate", stringToDate);
			req.setAttribute("departmentId", departmentId);
			req.setAttribute("fileTypeId", fileTypeId);
			req.setAttribute("action", action);
			
			req.setAttribute("lastMsgId", lastMsgId);
			req.setAttribute("fileTypeList", fileTypeList);
			req.setAttribute("fileTypeFilter", fileTypeFilter);
			req.setAttribute("pmlOneDoorReceiveFileSearch", searchContainer);
			
			req.setAttribute("type", type);
			req.setAttribute("valueType", valueType);
			req.setAttribute("beginDateParam", beginDateParam);
			req.setAttribute("endDateParam", endDateParam);
			
			req.setAttribute("pmlFilePcccList", pmlFilePcccList);
			
			return mapping.findForward("portlet.nss.onedoorreport_baocaohosothangluyke.filedetails");
		}
	}
	
	private List<PmlFilePcccDTO> add2DTO(Collection<PmlOneDoorReceiveFile> pmlOneDoorReceiveFileList){
		List<PmlFilePcccDTO> pmlFilePcccDTOList = new ArrayList<PmlFilePcccDTO>(); 
		
		for (PmlOneDoorReceiveFile pmlOneDoorReceiveFile : pmlOneDoorReceiveFileList) {
			PmlFilePcccDTO dto = new PmlFilePcccDTO();
			PmlOneDoorReceiveFile file = null;
		
			PmlProcessDispose log = null;
			
			
			try {
				file = PmlOneDoorReceiveFileLocalServiceUtil.getPmlOneDoorReceiveFile(pmlOneDoorReceiveFile.getFileId());
			} catch (PortalException e2) {
				e2.printStackTrace();
			} catch (SystemException e2) {
				e2.printStackTrace();
			}
			if ( null!= file) {
					dto.setFileId(file.getFileId());
					try {
						dto.setFileName(PmlFilePCCCLocalServiceUtil.getPmlFilePCCC(file.getFileId()).getFileName());
						dto.setFiletype(PmlFileTypeLocalServiceUtil.getPmlFileType(file.getFileTypeId()).getFileTypeName());
						dto.setApplicationDate(file.getApplicationDate());
						dto.setExpectedReturingDate(file.getExpectedReturningDate());
						dto.setNumberReceipt(file.getNumberReceipt());
					} catch (PortalException e) {
						e.printStackTrace();
					} catch (SystemException e) {
						e.printStackTrace();
					}
			}
			
			try {
				log = getProcessDipose(pmlOneDoorReceiveFile.getFileId());
			} catch (Exception e) {
			}
			if (log != null) {
				dto.setSendDate(log.getSendDate());
				dto.setReceiveDate(log.getReceiveDate());
				dto.setExpireDate(log.getExpiredDate());
				PmlFileStatusStateProcess fileStatusStateProcess = null;
				try {
					fileStatusStateProcess = PmlFileStatusStateProcessLocalServiceUtil.findByStateProcessId(log.getStateProcessIdBefore()).get(0);
				} catch (Exception e) {
					try {
						fileStatusStateProcess = PmlFileStatusStateProcessLocalServiceUtil.findByStateProcessId(log.getStateProcessIdAfter()).get(0);
					} catch (Exception e1) {
						System.out.println("ERROR: in add2DTO: "+e1.getMessage());
						fileStatusStateProcess = null;
					}
				}
				
				if ( null != fileStatusStateProcess) {
					dto.setStatus(fileStatusStateProcess.getDescription());
				} else {
					dto.setStatus("");
				}
				
			} else {
				List<PmlProcessDispose> logList = new ArrayList<PmlProcessDispose>();
				try {
					logList = PmlProcessDisposeLocalServiceUtil.findByFileId(pmlOneDoorReceiveFile.getFileId());
				} catch (Exception e) {
					System.out.println("ERROR: in add2DTO: " + e.getMessage());
				}
				
				if ( logList.size() != 0) {
					List<PmlProcessDispose> listTemp = new ArrayList<PmlProcessDispose>();
					try {
						listTemp = PmlProcessDisposeLocalServiceUtil.findByFileId_Transition(pmlOneDoorReceiveFile.getFileId(), logList.size());
					} catch (Exception e) {
					}
					if (listTemp.size() > 0) {
						log =listTemp.get(0);
						List<PmlFileStatusStateProcess> list = new ArrayList<PmlFileStatusStateProcess>();
						if ( null != log) {
							dto.setSendDate(log.getSendDate());
							dto.setReceiveDate(log.getReceiveDate());
							dto.setExpireDate(log.getExpiredDate());
							try {
								list = PmlFileStatusStateProcessLocalServiceUtil
								.findByStateProcessId(log.getStateProcessIdAfter());
							} catch (SystemException e) {
							}
							
							if ( list.size() != 0) {
								dto.setStatus(list.get(0).getDescription());
							} else {
								dto.setStatus("");
							}
						}
					}
				}
			}
			pmlFilePcccDTOList.add(dto);
		}
		return pmlFilePcccDTOList;
	}

	/**
	 * lay log moi nhat cua ho so
	 * 
	 * @param fileId
	 * @return
	 */
	private PmlProcessDispose getProcessDipose(String fileId) {
		OneDoorProcessLiferayWorkflowService service = new OneDoorProcessLiferayWorkflowService();
		PmlProcessDispose log = service.getCurrentLogFromFileId(fileId);
		return log;
	}
}
