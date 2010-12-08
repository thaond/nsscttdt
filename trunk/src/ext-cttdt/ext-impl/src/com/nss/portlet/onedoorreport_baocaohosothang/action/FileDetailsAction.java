package com.nss.portlet.onedoorreport_baocaohosothang.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.struts.PortletAction;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.servlet.ServletResponseUtil;
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
import com.nss.portlet.onedoorreport_baocaohosothang.searchfiledetail.PmlOneDoorReceiveFileSearch;
import com.nss.workflowonedoor.OneDoorProcessLiferayWorkflowService;

public class FileDetailsAction extends PortletAction {
	
	@Override
	public void processAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
		String report = ParamUtil.getString(req, "action");
		String reportType = ParamUtil.getString(req, "reportType");
		
		// lay gia tri de xuat file
		String columeName = ParamUtil.getString(req, "columeName", "");
		String fileTypeId = ParamUtil.getString(req, "fileTypeId", "");
		
		List<PmlFileType> listFileType = new ArrayList<PmlFileType>();
		try {
			listFileType.add(PmlFileTypeLocalServiceUtil.getPmlFileType(fileTypeId));
		} catch (Exception e) {
			listFileType = new ArrayList<PmlFileType>();
		}
		
		String stringFromDate = ParamUtil.getString(req, "fromDate");
		String stringToDate = ParamUtil.getString(req, "toDate");
		SimpleDateFormat sF = new SimpleDateFormat("dd/MM/yyyy");
		if (Validator.isNull(stringFromDate)) {
			stringFromDate = sF.format(new Date());
		}
		
		if (Validator.isNull(stringToDate)) {
			stringToDate = sF.format(new Date());
		}
		
		Date fromDate = sF.parse(stringFromDate);
		Date toDate = sF.parse(stringToDate);
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String toDay = df.format(toDate);
		String fromDay = df.format(fromDate);
		
		// dieu kien loc
		String type = ParamUtil.getString(req, "type", "");
		String valueType = ParamUtil.getString(req, "valueType", "");				
		String beginDateParam = ParamUtil.getString(req, "beginDate", "");
		String endDateParam = ParamUtil.getString(req, "endDate","");
		String fileTypeFilter = ParamUtil.getString(req, "fileTypeFilter", "");
		String sort = ParamUtil.getString(req, "sort", "");
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
		
		if (!report.equals("report")){
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
		
		if (report.equals("report")) {
			if (reportType.equals("word")) {
				reportFileByUser(req, res, reportType, getResult(columeName, listFileType, fromDay, toDay, typeList, valueTypeList));
			} else if (reportType.equals("excel")) {
				reportFileByUserExcel(req, res, reportType, getResult(columeName, listFileType, fromDay, toDay, typeList, valueTypeList));
			}
		}
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
	/*
	 *  danh sach co duoc tu trang view - theo columnName
	 */
	private List<PmlOneDoorReceiveFile> getResult(String columeName,
			List<PmlFileType> listFileType, String fromDay, String toDay,
			List<String> typeList, List<String> valueTypeList) throws SystemException {
		
		List<PmlOneDoorReceiveFile> listResults = new ArrayList<PmlOneDoorReceiveFile>();
		
		if (!Validator.isNull(columeName)) {
			if (columeName.equals("tensanpham")) {
				listResults = PmlOneDoorReceiveFileLocalServiceUtil.getSoLuongHSNhanTrongThang(listFileType, fromDay, toDay, typeList, valueTypeList, -1, -1, null);
			
			} else if (columeName.equals("tondauky")) {
				listResults = PmlOneDoorReceiveFileLocalServiceUtil.getSoLuongHSTonBCThang(listFileType, fromDay, typeList, valueTypeList, -1, -1, null);

			} else if (columeName.equals("nhantrongthang")) {
				listResults = PmlOneDoorReceiveFileLocalServiceUtil.getSoLuongHSNhanTrongThang(listFileType, fromDay, toDay, typeList, valueTypeList, -1, -1, null);
			
			} else if (columeName.equals("tongcong")) {
				listResults = PmlOneDoorReceiveFileLocalServiceUtil.getSoLuongTongHS(listFileType, fromDay, toDay, typeList, valueTypeList, -1, -1, null);
			
			} else if (columeName.equals("sodunghan")) {
				listResults = PmlOneDoorReceiveFileLocalServiceUtil.getSoHSHoanThanhDungHan(listFileType, fromDay, toDay, typeList, valueTypeList, -1, -1, null);
			
			} else if (columeName.equals("sotrehan")) {
				listResults = PmlOneDoorReceiveFileLocalServiceUtil.getSoHSHoanThanhTreHan(listFileType, fromDay, toDay, typeList, valueTypeList, -1, -1, null);
			
			} else if (columeName.equals("tronghan")) {
				listResults = PmlOneDoorReceiveFileLocalServiceUtil.getSoHSDangThuLyDungHan(listFileType, fromDay, toDay, typeList, valueTypeList, -1, -1, null);
			
			} else if (columeName.equals("datrehan")) {
				listResults = PmlOneDoorReceiveFileLocalServiceUtil.getSoHSDangThuLyTreHan(listFileType, fromDay, toDay, typeList, valueTypeList, -1, -1, null);
			
			} else if (columeName.equals("chinhsuabosung")) {
				listResults = PmlOneDoorReceiveFileLocalServiceUtil.getSoHSChoBoSung(listFileType, fromDay, toDay, typeList, valueTypeList, -1, -1, null);
			}
		}
		
		return listResults;
	}
	
	private List<PmlFilePcccDTO> getPmlFilePcccDTOReport(List<PmlOneDoorReceiveFile> list, String reportType)
	throws Exception {

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
				
				String report = ParamUtil.getString(req, "action");
				
				String columeName = ParamUtil.getString(req, "columeName", "");
				String fileTypeId = ParamUtil.getString(req, "fileTypeId", "");
				
				List<PmlFileType> listFileType = new ArrayList<PmlFileType>();
				try {
					listFileType.add(PmlFileTypeLocalServiceUtil.getPmlFileType(fileTypeId));
				} catch (Exception e) {
					listFileType = new ArrayList<PmlFileType>();
				}
				String stringFromDate = ParamUtil.getString(req, "fromDate");
				String stringToDate = ParamUtil.getString(req, "toDate");
				SimpleDateFormat sF = new SimpleDateFormat("dd/MM/yyyy");
				if (Validator.isNull(stringFromDate)) {
					stringFromDate = sF.format(new Date());
				}
				
				if (Validator.isNull(stringToDate)) {
					stringToDate = sF.format(new Date());
				}
				
				Date fromDate = sF.parse(stringFromDate);
				Date toDate = sF.parse(stringToDate);
				
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				String toDay = df.format(toDate);
				String fromDay = df.format(fromDate);
				
				String redirect = ParamUtil.getString(req, "redirect");
				
				String type = ParamUtil.getString(req, "type", "");
				String valueType = ParamUtil.getString(req, "valueType", "");				
				String beginDateParam = ParamUtil.getString(req, "beginDate", "");
				String endDateParam = ParamUtil.getString(req, "endDate","");
				
				String fileTypeFilter = ParamUtil.getString(req, "fileTypeFilter", "");
				String sort = ParamUtil.getString(req, "sort", "");
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
				
				if (!report.equals("report")){
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
				portletURL.setParameter("struts_action", "/nss/onedoorreport_baocaohosothang/filedetails");
				
				portletURL.setParameter("type", type);
				portletURL.setParameter("valueType", valueType);
				portletURL.setParameter("beginDateParam", beginDateParam);
				portletURL.setParameter("endDateParam", endDateParam);
				portletURL.setParameter("fileTypeFilter", fileTypeFilter);
				
				portletURL.setParameter("columeName", columeName);
				portletURL.setParameter("fileTypeId", fileTypeId);
				portletURL.setParameter("fromDate", stringFromDate);
				portletURL.setParameter("toDate", stringToDate);
				portletURL.setParameter("redirect", redirect);
				
				PmlOneDoorReceiveFileSearch searchContainer = new PmlOneDoorReceiveFileSearch(req, portletURL);
				
				List<PmlFilePcccDTO> pmlFilePcccList = new ArrayList<PmlFilePcccDTO>();
				pmlFilePcccList = getPmlFilePcccList(columeName, fromDay, toDay, listFileType, typeList, valueTypeList, lastMsgId, lastMsgId + 20, searchContainer.getOrderByComparator());
				
				// phan loc theo loai ho so
				List<PmlFileType> fileTypeList = new ArrayList<PmlFileType>();
				try {
					fileTypeList = PmlFileTypeLocalServiceUtil.findAll();
				} catch (Exception e) {
					fileTypeList = new ArrayList<PmlFileType>();
					System.out.println("ERROR: Get List FileType: "+ e.getMessage());
				}
				
				req.setAttribute("fromDate", stringFromDate);
				req.setAttribute("toDate", stringToDate);
				req.setAttribute("fileTypeId", fileTypeId);
				req.setAttribute("columeName", columeName);
				
				req.setAttribute("lastMsgId", lastMsgId);
				req.setAttribute("fileTypeList", fileTypeList);
				req.setAttribute("fileTypeFilter", fileTypeFilter);
				req.setAttribute("pmlOneDoorReceiveFileSearch", searchContainer);
				
				req.setAttribute("type", type);
				req.setAttribute("valueType", valueType);
				req.setAttribute("beginDateParam", beginDateParam);
				req.setAttribute("endDateParam", endDateParam);
				
				req.setAttribute("pmlFilePcccList",pmlFilePcccList);
				return mapping.findForward("portlet.nss.onedoorreport_baocaohosothang.filedetails");
			}
	}
	
	private List<PmlFilePcccDTO> getPmlFilePcccList(String columeName, String fromDate, String toDate, List<PmlFileType> listFileType, List<String> typeList, List<String> valueTypeList, int start, int end, OrderByComparator obc) throws Exception {
		
		List<PmlFilePcccDTO> listDTO = new ArrayList<PmlFilePcccDTO>();
		List<PmlOneDoorReceiveFile> fileList = new ArrayList<PmlOneDoorReceiveFile>();
		
		if (!Validator.isNull(columeName)) {
			
			if (columeName.equals("tensanpham")) {
				fileList = PmlOneDoorReceiveFileLocalServiceUtil.getSoLuongHSNhanTrongThang(listFileType, fromDate, toDate, typeList, valueTypeList, start, end, obc);
			
			} else if (columeName.equals("tondauky")) {
				fileList = PmlOneDoorReceiveFileLocalServiceUtil.getSoLuongHSTonBCThang(listFileType, fromDate, typeList, valueTypeList, start, end, obc);
			
			} else if (columeName.equals("nhantrongthang")) {
				fileList = PmlOneDoorReceiveFileLocalServiceUtil.getSoLuongHSNhanTrongThang(listFileType, fromDate, toDate, typeList, valueTypeList, start, end, obc);
			
			} else if (columeName.equals("tongcong")) {
				fileList = PmlOneDoorReceiveFileLocalServiceUtil.getSoLuongTongHS(listFileType, fromDate, toDate, typeList, valueTypeList, start, end, obc);
			
			} else if (columeName.equals("sodunghan")) {
				fileList = PmlOneDoorReceiveFileLocalServiceUtil.getSoHSHoanThanhDungHan(listFileType, fromDate, toDate, typeList, valueTypeList, start, end, obc);
			
			} else if (columeName.equals("sotrehan")) {
				fileList = PmlOneDoorReceiveFileLocalServiceUtil.getSoHSHoanThanhTreHan(listFileType, fromDate, toDate, typeList, valueTypeList, start, end, obc);
			
			} else if (columeName.equals("tronghan")) {
				fileList = PmlOneDoorReceiveFileLocalServiceUtil.getSoHSDangThuLyDungHan(listFileType, fromDate, toDate, typeList, valueTypeList, start, end, obc);
			
			} else if (columeName.equals("datrehan")) {
				fileList = PmlOneDoorReceiveFileLocalServiceUtil.getSoHSDangThuLyTreHan(listFileType, fromDate, toDate, typeList, valueTypeList, start, end, obc);
			
			} else if (columeName.equals("chinhsuabosung")) {
				fileList = PmlOneDoorReceiveFileLocalServiceUtil.getSoHSChoBoSung(listFileType, fromDate, toDate, typeList, valueTypeList, start, end, obc);
			
			}
			listDTO = getListPmlFilePcccDTO(fileList);
		}

		return listDTO;
	}
	
	private List<PmlFilePcccDTO> getListPmlFilePcccDTO(List<PmlOneDoorReceiveFile> pmlOneDoorReceiveFileList){
		List<PmlFilePcccDTO> listDTO = new ArrayList<PmlFilePcccDTO>();
		PmlFilePCCC filePCCC = null;
		PmlFileType fileType = null;
		for (PmlOneDoorReceiveFile pmlOneDoorReceiveFile : pmlOneDoorReceiveFileList) { 
			PmlFilePcccDTO pmlFilePcccDTO = new PmlFilePcccDTO();
			String fileId = pmlOneDoorReceiveFile.getFileId();
			
			pmlFilePcccDTO.setFileId(fileId);
			try {
				filePCCC = PmlFilePCCCLocalServiceUtil.getPmlFilePCCC(fileId);
				pmlFilePcccDTO.setFileName(filePCCC.getFileName());
			} catch (Exception e1) {
				pmlFilePcccDTO.setFileName("");
			}
			try {
				fileType = PmlFileTypeLocalServiceUtil.getPmlFileType(pmlOneDoorReceiveFile.getFileTypeId());
				pmlFilePcccDTO.setFiletype(fileType.getFileTypeName());
			} catch (Exception e1) {
				pmlFilePcccDTO.setFiletype("");

			}
			
			pmlFilePcccDTO.setApplicationDate(pmlOneDoorReceiveFile.getApplicationDate());
			pmlFilePcccDTO.setExpectedReturingDate(pmlOneDoorReceiveFile.getExpectedReturningDate());
			pmlFilePcccDTO.setNumberReceipt(pmlOneDoorReceiveFile.getNumberReceipt());
			
			PmlProcessDispose log = null;
			try {
				log = getProcessDipose(fileId);
			} catch (Exception e) {
			}
			if (log != null) {
				pmlFilePcccDTO.setSendDate(log.getSendDate());
				pmlFilePcccDTO.setReceiveDate(log.getReceiveDate());
				pmlFilePcccDTO.setExpireDate(log.getExpiredDate());
				PmlFileStatusStateProcess fileStatusStateProcess = null;
				try {
					fileStatusStateProcess = PmlFileStatusStateProcessLocalServiceUtil.findByStateProcessId(log.getStateProcessIdBefore()).get(0);
				} catch (Exception e) {
				}
				if ( null!= fileStatusStateProcess) {
					pmlFilePcccDTO.setStatus(fileStatusStateProcess.getDescription());
				} else {
					pmlFilePcccDTO.setStatus("");
				}
			} else {
				List<PmlProcessDispose> logList = new ArrayList<PmlProcessDispose>();
				try {
					logList = PmlProcessDisposeLocalServiceUtil.findByFileId(fileId);
				} catch (SystemException e) {
					e.printStackTrace();
				}
				
				if ( logList.size() != 0) {
					try {
						log = PmlProcessDisposeLocalServiceUtil.findByFileId_Transition(fileId, logList.size()).get(0);
						List<PmlFileStatusStateProcess> list = new ArrayList<PmlFileStatusStateProcess>();
						pmlFilePcccDTO.setSendDate(log.getSendDate());
						pmlFilePcccDTO.setReceiveDate(log.getReceiveDate());
						pmlFilePcccDTO.setExpireDate(log.getExpiredDate());
						try {
							list = PmlFileStatusStateProcessLocalServiceUtil
							.findByStateProcessId(log.getStateProcessIdAfter());
						} catch (SystemException e) {
						}
						if ( list.size() != 0) {
							pmlFilePcccDTO.setStatus(list.get(0).getDescription());
						} else {
							pmlFilePcccDTO.setStatus("");
						}
					} catch (Exception e) {
						pmlFilePcccDTO.setSendDate(null);
						pmlFilePcccDTO.setReceiveDate(null);
						pmlFilePcccDTO.setExpireDate(null);
					}
				}
			}
			
			listDTO.add(pmlFilePcccDTO);
		}
		return listDTO;
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
