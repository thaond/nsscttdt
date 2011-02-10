package com.sgs.portlet.onedoorpcccprocess.action;

/**
 * @author triltm
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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

import com.liferay.portal.kernel.portlet.LiferayWindowState;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.servlet.ServletResponseUtil;
import com.sgs.portlet.document.model.PmlProcessDispose;
import com.sgs.portlet.document.model.PmlStateProcess;
import com.sgs.portlet.document.receipt.model.PmlFileStatusStateProcess;
import com.sgs.portlet.document.receipt.service.persistence.PmlFileStatusStateProcessUtil;
import com.sgs.portlet.document.service.persistence.PmlStateProcessUtil;
import com.sgs.portlet.filetype.model.PmlFileType;
import com.sgs.portlet.filetype.service.persistence.PmlFileTypeUtil;
import com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile;
import com.sgs.portlet.onedoor.service.PmlOneDoorReceiveFileLocalServiceUtil;
import com.sgs.portlet.onedoor.workflow.OneDoorProcessLiferayWorkflowService;
import com.sgs.portlet.onedoor.workflow.OneDoorProcessPortletAction;
import com.sgs.portlet.onedoorpccc.dto.PmlFilePcccDTO;
import com.sgs.portlet.onedoorpccc.model.PmlFilePCCC;
import com.sgs.portlet.onedoorpccc.service.persistence.PmlFilePCCCUtil;
import com.sgs.portlet.onedoorpcccprocess.searchresult.PmlOneDoorReceiveFileSearchResult;
import com.sgs.portlet.onedoorpcccprocess.util.ReportFileByUserUtil;

@SuppressWarnings("unchecked")
public class SearchResultAction extends OneDoorProcessPortletAction {

	@Override
	@SuppressWarnings("unused")
	public void processStrutsAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
		
		String action = ParamUtil.getString(req, "action");
		String reportType = ParamUtil.getString(req, "reportType");
		
		// get current user
		
		String type = ParamUtil.getString(req, "type", "");
		String valueType = ParamUtil.getString(req, "valueType", "");		
		
		String beginDateParam = ParamUtil.getString(req,"beginDate", "");
		String endDateParam = ParamUtil.getString(req,"endDate","");
		
		String fileTypeFilter = ParamUtil.getString(req,"fileTypeFilter", "");
		
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
		
		if ("".equals(type)) {
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
		
		// lay du lieu tu form search (popup menu)
		String dataForSearch = ParamUtil.getString(req, "dataForSearch", "");
		
		//get data
		String numberReceipt = "";
		String fileName = "";
		String applicantName = "";
		String address = "";
		String telephone = "";
		
		String email = "";
		long fileStatus = 0;
		
		String fileType = "";
		String tuNgayTiepNhan = "";
		String denNgayTiepNhan = "";
		String tuNgayHenTra = "";
		String denNgayHenTra = ""; 
		String tuNgayHSHoanThanh = "";
		String denNgayHSHoanThanh = "";
		String tuNgayHSTraThuc = "";
		String denNgayHSTraThuc = "";
		
		if (!"".equals(dataForSearch)) {
			
			String[] dataForSearchArray = dataForSearch.split("_", -1);
			
			numberReceipt = dataForSearchArray[0];
			fileName = dataForSearchArray[1];
			applicantName = dataForSearchArray[2];
			address = dataForSearchArray[3];
			telephone = dataForSearchArray[4];
			
			email = dataForSearchArray[5];
			if (!"".equals(dataForSearchArray[6])) {
				fileStatus = Long.parseLong(dataForSearchArray[6]);
			}
			
			fileType = dataForSearchArray[7];
			
			tuNgayTiepNhan = dataForSearchArray[8];
			denNgayTiepNhan = dataForSearchArray[9];
			
			tuNgayHenTra = dataForSearchArray[10];
			denNgayHenTra = dataForSearchArray[11];
			
			tuNgayHSHoanThanh = dataForSearchArray[12];
			denNgayHSHoanThanh = dataForSearchArray[13];
			
			tuNgayHSTraThuc = dataForSearchArray[14];
			denNgayHSTraThuc = dataForSearchArray[15];
			
			List<PmlOneDoorReceiveFile> listResults = PmlOneDoorReceiveFileLocalServiceUtil.search(
					numberReceipt, fileName, applicantName, address, 
					telephone, fileType, tuNgayTiepNhan, denNgayTiepNhan, 
					tuNgayHenTra, denNgayHenTra, tuNgayHSHoanThanh, 
					denNgayHSHoanThanh, tuNgayHSTraThuc, denNgayHSTraThuc, 
					typeList, valueTypeList, -1, -1,  null);
			
			if (action.equals("report")) {
				if (reportType.equals("word")) {
					reportFileByUser(req, res, reportType, listResults);
				} else if (reportType.equals("excel")) {
					reportFileByUserExcel(req, res, reportType, listResults);
				}
			}
		}
	}

	
	private void reportFileByUser(ActionRequest req, ActionResponse res,
			String reportType, List<PmlOneDoorReceiveFile> listResults) throws Exception {
		
		HttpServletRequest request = PortalUtil.getHttpServletRequest(req);
		HttpServletResponse response = PortalUtil.getHttpServletResponse(res);

		ReportFileByUserUtil rtfUtil = new ReportFileByUserUtil(request.getSession().getServletContext().getRealPath("reports"),
																getPmlFilePcccDTOReport(listResults, reportType));
		InputStream in = rtfUtil.run(request.getSession().getServletContext().getRealPath("reports/ReportFileByUserSearch.rtf"));
		ServletResponseUtil.sendFile(response, "report.rtf", in, "application/rtf");
	}
	
	
	private void reportFileByUserExcel(ActionRequest req, ActionResponse res,
			String reportType, List<PmlOneDoorReceiveFile> listResults) throws Exception {
			
		ServletContext context = PortalUtil.getHttpServletRequest(req).getSession().getServletContext();
		HttpServletResponse response = PortalUtil.getHttpServletResponse(res);
		JRExporter exporter = null;
		
		JasperDesign subDesign1 = JRXmlLoader.load(context.getRealPath("reports/ReportFileByUserSearch_subreport.jrxml"));
		JasperReport subJasperReport1 = JasperCompileManager.compileReport(subDesign1);
		
		Map subMap1 = new HashMap();
		
		JRBeanCollectionDataSource dataSource1 = new JRBeanCollectionDataSource(getPmlFilePcccDTOReport(listResults, reportType));
		
		JasperCompileManager.compileReportToFile(context.getRealPath("reports/ReportFileByUserSearch.jrxml"), 
												context.getRealPath("reports/ReportFileByUserSearch.jasper"));
		
		Map map = new HashMap();
		map.put("dataSource1", dataSource1);
		map.put("subReport1", subJasperReport1);
		map.put("subMap1", subMap1);
		
		JREmptyDataSource dataSource = new JREmptyDataSource();
		
		JasperFillManager.fillReportToFile(context.getRealPath("reports/ReportFileByUserSearch.jasper"),
											context.getRealPath("reports/ReportFileByUserSearch.jrprint"), map, dataSource);
		
		File srcFile = new File(context.getRealPath("reports/ReportFileByUserSearch.jrprint"));
		File desFile = null;
		
		JasperPrint jasperPrint = (JasperPrint) JRLoader.loadObject(srcFile);
		desFile = File.createTempFile(jasperPrint.getName(), ".xls");
		
		exporter = new JExcelApiExporter();
		exporter.setParameter(JRXlsExporterParameter.JASPER_PRINT, jasperPrint);
		exporter.setParameter(JRXlsExporterParameter.OUTPUT_FILE_NAME, desFile.toString());
		exporter.exportReport();
		
		InputStream in = new FileInputStream(desFile);
		ServletResponseUtil.sendFile(response, "report.xls", in, "application/vnd.ms-excel");
	}

	
	private List<PmlFilePcccDTO> getPmlFilePcccDTOReport(
			List<PmlOneDoorReceiveFile> list, String reportType)
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
			filePcccDTO.setSendDateReport("");
			filePcccDTO.setReceiveDateReport("");
			filePcccDTO.setExpireDateReport("");
			filePcccDTO.setStatus("");
			filePcccDTO.setInputDataDateReport("");
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
				PmlFilePCCC filePCCC = PmlFilePCCCUtil.findByPrimaryKey(file.getFileId());
				if (reportType.equals("word")) {
					filePcccDTO.setFileName(StringUtils.convertToRTF(filePCCC.getFileName()));
				} else if (reportType.equals("excel")) {
					filePcccDTO.setFileName(filePCCC.getFileName());
				}
				
				// loai ho so
				PmlFileType fileType = PmlFileTypeUtil.findByPrimaryKey(file
						.getFileTypeId());
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
					// ngay chuyen
					filePcccDTO.setSendDateReport(df.format(log.getSendDate()));
					
					// ngay nhan
					filePcccDTO.setReceiveDateReport(log.getReceiveDate() != null ? df.format(log.getReceiveDate()) : "");
					
					// ngay het han
					filePcccDTO.setExpireDateReport(df.format(log.getExpiredDate()));
					
					// trang thai ho so
					PmlStateProcess status = PmlStateProcessUtil.findByPrimaryKey(log.getStateProcessIdBefore());
					try {					
						PmlFileStatusStateProcess fileStatusStateProcess = PmlFileStatusStateProcessUtil.findByStateProcessId(status.getStateProcessId()).get(0);
						if (reportType.equals("word")) {
							filePcccDTO.setStatus(StringUtils.convertToRTF(fileStatusStateProcess.getDescription()));
						} else if (reportType.equals("excel")) {
							filePcccDTO.setStatus(fileStatusStateProcess.getDescription());
						}
					} catch (Exception e) {
						filePcccDTO.setStatus("");
					}
				}
				
				// ngay nhap lieu ho so
				filePcccDTO.setInputDataDateReport(df.format(filePCCC.getInputDataDate()));
				
				// ngay hen tra khach
				filePcccDTO.setExpectedReturingDateReport(df.format(file.getExpectedReturningDate()));
				
				result.add(filePcccDTO);
			}
		}
		
		return result;
	}


	@Override
	public ActionForward renderStruts(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {

		List<PmlOneDoorReceiveFile> receiveFiles = filterPmlOneDoorReceiveFiles(
				req, res);

		List<PmlFilePcccDTO> receiveFilesDTO = getPmlFilePcccDTO(receiveFiles);

		req.setAttribute("receiveFilesDTO", receiveFilesDTO);
		return mapping
				.findForward("portlet.sgs.onedoorpcccprocess.searchresult");
	}

	private List<PmlFilePcccDTO> getPmlFilePcccDTO(
			List<PmlOneDoorReceiveFile> list) throws Exception {

		List<PmlFilePcccDTO> result = new ArrayList<PmlFilePcccDTO>();

		if (list == null) {
			return result;
		}

		for (PmlOneDoorReceiveFile file : list) {
			PmlFilePcccDTO filePcccDTO = new PmlFilePcccDTO();
			filePcccDTO.setApplicationDate(file.getApplicationDate());

			filePcccDTO.setExpectedReturingDate(file.getExpectedReturningDate());
			filePcccDTO.setFileId(file.getFileId());
			filePcccDTO.setNumberReceipt(file.getNumberReceipt());

			// gan gia tri hien thi voi filePCCC
			PmlFilePCCC filePCCC = PmlFilePCCCUtil.findByPrimaryKey(file.getFileId());
			filePcccDTO.setFileName(filePCCC.getFileName());

			// gan gia tri hien thi voi fileType
			PmlFileType fileType = null;
			try {
				fileType = PmlFileTypeUtil.findByPrimaryKey(file
						.getFileTypeId());
				filePcccDTO.setFiletype(fileType.getFileTypeName());
			} catch (Exception e) {
				filePcccDTO.setFiletype("");
			}

			PmlProcessDispose log = null;
			try {
				log = getProcessDipose(file.getFileId());
			} catch (Exception e) {
			}

			if (log != null) {
				// Yenlt update 17/03/2010
				PmlStateProcess status = PmlStateProcessUtil
						.findByPrimaryKey(log.getStateProcessIdBefore());
				try {
					PmlFileStatusStateProcess fileStatusStateProcess = PmlFileStatusStateProcessUtil
							.findByStateProcessId(status.getStateProcessId())
							.get(0);
					filePcccDTO.setStatus(fileStatusStateProcess
							.getDescription()); // status
				} catch (Exception e) {
					filePcccDTO.setStatus("");
				}
				// end
			}

			result.add(filePcccDTO);
		}
		return result;
	}

	private PmlProcessDispose getProcessDipose(String fileId) {
		OneDoorProcessLiferayWorkflowService service = new OneDoorProcessLiferayWorkflowService();
		PmlProcessDispose log = service.getCurrentLogFromFileId(fileId);
		return log;
	}

	@SuppressWarnings("unused")
	private List<PmlOneDoorReceiveFile> filterPmlOneDoorReceiveFiles(
			RenderRequest req, RenderResponse res) throws Exception {

		List<PmlOneDoorReceiveFile> results = new ArrayList<PmlOneDoorReceiveFile>();

		// get value filter
		String type = ParamUtil.getString(req, "type", "");
		String valueType = ParamUtil.getString(req, "valueType", "");

		String beginDateParam = ParamUtil.getString(req, "beginDate", "");
		String endDateParam = ParamUtil.getString(req, "endDate", "");

		String fileTypeFilter = ParamUtil.getString(req, "fileTypeFilter", "");

		String sort = ParamUtil.getString(req, "sort", "");

		// load du lieu tiep theo
		int lastMsgId = ParamUtil.getInteger(req, "last_msg_id", 0);
		boolean loadData = ParamUtil.getBoolean(req, "loadData", false);

		String dataForSearch = ParamUtil.getString(req, "dataForSearch", "");
		// Dieu kien sort cua danh sach can xu ly
		PortletURL portletURL = res.createRenderURL();
		portletURL.setWindowState(LiferayWindowState.EXCLUSIVE);
		portletURL.setParameter("struts_action",
				"/sgs/onedoorpcccprocess/searchresult");
		portletURL.setParameter("type", type);
		portletURL.setParameter("valueType", valueType);
		portletURL.setParameter("beginDateParam", beginDateParam);
		portletURL.setParameter("endDateParam", endDateParam);
		portletURL.setParameter("fileTypeFilter", fileTypeFilter);
		portletURL.setParameter("dataForSearch", dataForSearch);

		PmlOneDoorReceiveFileSearchResult searchContainer = new PmlOneDoorReceiveFileSearchResult(
				req, portletURL);

		if (!"".equals(valueType)) {
			fileTypeFilter = "";
			beginDateParam = "";
			endDateParam = "";
		}

		if (!"".equals(beginDateParam) && !"".equals(endDateParam)) {
			valueType = beginDateParam + "_" + endDateParam;
			fileTypeFilter = "";
		}

		if (!"".equals(fileTypeFilter)) {
			valueType = fileTypeFilter;
			beginDateParam = "";
			endDateParam = "";
		}

		PortletSession session = req.getPortletSession(true);
		List<String> valueTypeList = (List<String>) session.getAttribute("keyWordListSearch", PortletSession.APPLICATION_SCOPE);
		List<String> typeList = (List<String>) session.getAttribute("typeFilterListSearch", PortletSession.APPLICATION_SCOPE);

		if (!loadData) {
			if ("".equals(type) && !"sort".equals(sort)) {
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

			session.setAttribute("keyWordListSearch", valueTypeList,
					PortletSession.APPLICATION_SCOPE);
			session.setAttribute("typeFilterListSearch", typeList,
					PortletSession.APPLICATION_SCOPE);
		}

		// get data
		String numberReceipt = "";
		String fileName = "";
		String applicantName = "";
		String address = "";
		String telephone = "";

		String email = "";
		long fileStatus = 0;

		String fileType = "";
		String tuNgayTiepNhan = "";
		String denNgayTiepNhan = "";
		String tuNgayHenTra = "";
		String denNgayHenTra = "";
		String tuNgayHSHoanThanh = "";
		String denNgayHSHoanThanh = "";
		String tuNgayHSTraThuc = "";
		String denNgayHSTraThuc = "";

		if (!"".equals(dataForSearch)) {

			String[] dataForSearchArray = dataForSearch.split("_", -1);

			numberReceipt = dataForSearchArray[0];
			fileName = dataForSearchArray[1];
			applicantName = dataForSearchArray[2];
			address = dataForSearchArray[3];
			telephone = dataForSearchArray[4];

			email = dataForSearchArray[5];
			if (!"".equals(dataForSearchArray[6])) {
				fileStatus = Long.parseLong(dataForSearchArray[6]);
			}

			fileType = dataForSearchArray[7];

			tuNgayTiepNhan = dataForSearchArray[8];
			denNgayTiepNhan = dataForSearchArray[9];

			tuNgayHenTra = dataForSearchArray[10];
			denNgayHenTra = dataForSearchArray[11];

			tuNgayHSHoanThanh = dataForSearchArray[12];
			denNgayHSHoanThanh = dataForSearchArray[13];

			tuNgayHSTraThuc = dataForSearchArray[14];
			denNgayHSTraThuc = dataForSearchArray[15];

			// results = PmlFilePCCCLocalServiceUtil.filter(list, fileId,
			// fileName,
			// applicantName, address, telephone, email, fileStatus, fileType,
			// receiveFromDate, receiveToDate, expectedReturningFromDate,
			// expextedReturningToDate, inputDataFromDate, inputDataToDate,
			// exactReturningFromDate, exactReturningToDate);

		}

		results = PmlOneDoorReceiveFileLocalServiceUtil.search(numberReceipt,
				fileName, applicantName, address, telephone, fileType,
				tuNgayTiepNhan, denNgayTiepNhan, tuNgayHenTra, denNgayHenTra,
				tuNgayHSHoanThanh, denNgayHSHoanThanh, tuNgayHSTraThuc,
				denNgayHSTraThuc, typeList, valueTypeList, lastMsgId,
				lastMsgId + 20, searchContainer.getOrderByComparator());

		// phan loc theo loai ho so
		List<PmlFileType> fileTypeList = new ArrayList<PmlFileType>();
		try {
			fileTypeList = PmlFileTypeUtil.findAll();
		} catch (Exception e) {
			fileTypeList = new ArrayList<PmlFileType>();
			System.out.println("ERROR: Get List FileType: " + e.getMessage());
		}

		req.setAttribute("dataForSearch", dataForSearch);
		req.setAttribute("lastMsgId", lastMsgId);

		req.setAttribute("fileTypeList", fileTypeList);
		req.setAttribute("fileTypeFilter", fileTypeFilter);
		req.setAttribute("pmlOneDoorReceiveFileSearch", searchContainer);

		req.setAttribute("type", type);
		req.setAttribute("valueType", valueType);

		req.setAttribute("beginDateParam", beginDateParam);
		req.setAttribute("endDateParam", endDateParam);

		return results;
	}

}
