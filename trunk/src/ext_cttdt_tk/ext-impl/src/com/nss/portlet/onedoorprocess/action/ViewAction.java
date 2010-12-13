package com.nss.portlet.onedoorprocess.action;

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
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
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

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.servlet.ServletResponseUtil;
import com.nss.portlet.filetype.model.PmlFileType;
import com.nss.portlet.filetype.service.PmlFileTypeLocalServiceUtil;
import com.nss.portlet.onedoor.model.PmlFilePCCC;
import com.nss.portlet.onedoor.model.PmlFileStatusStateProcess;
import com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile;
import com.nss.portlet.onedoor.model.PmlProcessDispose;
import com.nss.portlet.onedoor.model.PmlStateProcess;
import com.nss.portlet.onedoor.service.PmlFilePCCCLocalServiceUtil;
import com.nss.portlet.onedoor.service.PmlFileStatusStateProcessLocalServiceUtil;
import com.nss.portlet.onedoor.service.PmlOneDoorReceiveFileLocalServiceUtil;
import com.nss.portlet.onedoor.service.PmlStateProcessLocalServiceUtil;
import com.nss.portlet.onedoorprocess.SearchIsDelegated.PmlOneDoorReceiveFileSearchIsDelegated;
import com.nss.portlet.onedoorprocess.dto.PmlFilePcccDTO;
import com.nss.portlet.onedoorprocess.search.PmlOneDoorReceiveFileSearch;
import com.nss.portlet.onedoorprocess.searchDelegated.PmlOneDoorReceiveFileSearchDelegated;
import com.nss.portlet.onedoorprocess.util.ReportFileByUserUtil;
import com.nss.workflowonedoor.OneDoorProcessLiferayWorkflowService;
import com.nss.workflowonedoor.OneDoorProcessPortletAction;
import com.nss.workflowonedoor.util.DelegateConstants;

public class ViewAction extends OneDoorProcessPortletAction {

	public static final String SO_FILE_CHUA_NHAN = "sofilechuanhan";
	public static final String SO_FILE_CAN_XU_LY = "sofilecanxuly";
	public static final String SO_FILE_DA_QUA_HAN = "sofiledaquahan";
	public static final String SO_FILE_CHO_BO_SUNG = "sofilechobosung";
	
	@Override
	public void processStrutsAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
		
		String action = ParamUtil.getString(req, "action");
		String reportType = ParamUtil.getString(req, "reportType");
		
		long userId = PortalUtil.getUserId(req);
		
		String type = ParamUtil.getString(req, "type", "");
		String valueType = ParamUtil.getString(req, "valueType", "");		
		
		String beginDateParam = ParamUtil.getString(req,"beginDate", "");
		String endDateParam = ParamUtil.getString(req,"endDate","");
		
		String fileTypeFilter = ParamUtil.getString(req,"fileTypeFilter", "");
		
		// Dieu kien thong ke tu trang chu
		String status = ParamUtil.getString(req, "processValue", "");
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String toDate = df.format(sdf.parse(sdf.format(new Date())));
		
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
		
		session.setAttribute("keyWordList", valueTypeList, PortletSession.APPLICATION_SCOPE);
		session.setAttribute("typeFilterList", typeList, PortletSession.APPLICATION_SCOPE);
		
		if (action.equals("report")) {
			if (reportType.equals("word")) {
				reportFileByUser(req, res, reportType, userId, status, toDate, typeList, valueTypeList);
			} else if (reportType.equals("excel")) {
				reportFileByUserExcel(req, res, reportType, userId, status, toDate, typeList, valueTypeList);
			}
		}
	}
	
	private void reportFileByUser(PortletRequest req, PortletResponse res, String reportType,
			  long userId, String status, String toDate, List<String> typeList, List<String> valueTypeList) throws Exception {

		HttpServletRequest request = PortalUtil.getHttpServletRequest(req);
		HttpServletResponse response = PortalUtil.getHttpServletResponse(res);
		
		ReportFileByUserUtil rtfUtil = new ReportFileByUserUtil(request
										.getSession().getServletContext().getRealPath("reports"),
										getResults(userId, status, toDate, typeList, valueTypeList, reportType));
		InputStream in = rtfUtil.run(request.getSession().getServletContext()
										.getRealPath("reports/ReportFileByUser.rtf"));
		ServletResponseUtil.sendFile(response, "report.rtf", in, "application/rtf");
	}
	
	
	@SuppressWarnings("unchecked")
	private void reportFileByUserExcel(ActionRequest req, ActionResponse res,
			String reportType, long userId, String status, String toDate, 
			List<String> typeList, List<String> valueTypeList) throws Exception {
			
		ServletContext context = PortalUtil.getHttpServletRequest(req)
					.getSession().getServletContext();
		HttpServletResponse response = PortalUtil.getHttpServletResponse(res);
		JRExporter exporter = null;

		JasperDesign subDesign1 = JRXmlLoader.load(context
				.getRealPath("reports/ReportFileByUser_subreport1.jrxml"));
		JasperReport subJasperReport1 = JasperCompileManager
				.compileReport(subDesign1);
		JasperDesign subDesign2 = JRXmlLoader.load(context
				.getRealPath("reports/ReportFileByUser_subreport2.jrxml"));
		JasperReport subJasperReport2 = JasperCompileManager
				.compileReport(subDesign2);
		JasperDesign subDesign3 = JRXmlLoader.load(context
				.getRealPath("reports/ReportFileByUser_subreport3.jrxml"));
		JasperReport subJasperReport3 = JasperCompileManager
				.compileReport(subDesign3);

		Map subMap1 = new HashMap();
		Map subMap2 = new HashMap();
		Map subMap3 = new HashMap();

		Map<String, List<PmlFilePcccDTO>> reportData = getResults(userId, status, toDate, typeList, valueTypeList, reportType);

		JRBeanCollectionDataSource dataSource1 = new JRBeanCollectionDataSource(
				reportData.get(DelegateConstants.OWNER));
		JRBeanCollectionDataSource dataSource2 = new JRBeanCollectionDataSource(
				reportData.get(DelegateConstants.DELEGATED));
		JRBeanCollectionDataSource dataSource3 = new JRBeanCollectionDataSource(
				reportData.get(DelegateConstants.IS_DELEGATED));

		JasperCompileManager.compileReportToFile(context
				.getRealPath("reports/ReportFileByUser.jrxml"), context
				.getRealPath("reports/ReportFileByUser.jasper"));

		Map map = new HashMap();
		map.put("dataSource1", dataSource1);
		map.put("dataSource2", dataSource2);
		map.put("dataSource3", dataSource3);

		map.put("subReport1", subJasperReport1);
		map.put("subReport2", subJasperReport2);
		map.put("subReport3", subJasperReport3);

		map.put("subMap1", subMap1);
		map.put("subMap2", subMap2);
		map.put("subMap3", subMap3);

		JREmptyDataSource dataSource = new JREmptyDataSource();

		JasperFillManager.fillReportToFile(context
				.getRealPath("reports/ReportFileByUser.jasper"), context
				.getRealPath("reports/ReportFileByUser.jrprint"), map,
				dataSource);
		File srcFile = new File(context
				.getRealPath("reports/ReportFileByUser.jrprint"));
		File desFile = null;

		JasperPrint jasperPrint = (JasperPrint) JRLoader.loadObject(srcFile);
		desFile = File.createTempFile(jasperPrint.getName(), ".xls");

		exporter = new JExcelApiExporter();
		exporter.setParameter(JRXlsExporterParameter.JASPER_PRINT, jasperPrint);
		exporter.setParameter(JRXlsExporterParameter.OUTPUT_FILE_NAME, desFile
				.toString());
		exporter.exportReport();

		InputStream in = new FileInputStream(desFile);
		ServletResponseUtil.sendFile(response, "report.xls", in,
				"application/vnd.ms-excel");
		
	}
	
		
	private Map<String, List<PmlFilePcccDTO>> getResults(long userId, String status, String toDate, 
							List<String> typeList, List<String> valueTypeList, String reportType) throws Exception {
		
		List<PmlOneDoorReceiveFile> ownerList = new ArrayList<PmlOneDoorReceiveFile>();
		List<PmlOneDoorReceiveFile> isDelegatedList = new ArrayList<PmlOneDoorReceiveFile>();
		List<PmlOneDoorReceiveFile> delegatedList = new ArrayList<PmlOneDoorReceiveFile>();
		
		
		if (SO_FILE_CHUA_NHAN.equals(status)) {	
			ownerList = PmlOneDoorReceiveFileLocalServiceUtil.getListFileChuaNhanChuaHoanThanh(userId, typeList, valueTypeList, -1, -1, null);
			
		} else if (SO_FILE_CAN_XU_LY.equals(status)) {
			ownerList = PmlOneDoorReceiveFileLocalServiceUtil.getListFileCanXuLyTrongNgay(userId, toDate, typeList, valueTypeList, -1, -1, null);
			
		} else if (SO_FILE_DA_QUA_HAN.equals(status)) {
			ownerList = PmlOneDoorReceiveFileLocalServiceUtil.getListFileQuaHanISOChuaHoanThanh(userId, toDate, typeList, valueTypeList, -1, -1, null);
				
		} else if (SO_FILE_CHO_BO_SUNG.equals(status)) {
			ownerList = PmlOneDoorReceiveFileLocalServiceUtil.getListFileChoBoSungChuaHoanThanh(userId, typeList, valueTypeList, -1, -1, null);
			
		} else {
			 ownerList = PmlOneDoorReceiveFileLocalServiceUtil.getListFileNeedProcess(userId, typeList, valueTypeList, -1, -1, null);
		}
		
		delegatedList = PmlOneDoorReceiveFileLocalServiceUtil.getListFileDelegated(userId, typeList, valueTypeList, null);
		isDelegatedList = PmlOneDoorReceiveFileLocalServiceUtil.getListFileIsDelegated(userId, typeList, valueTypeList, null);
		
		List<PmlFilePcccDTO> ownerListDTO = getPmlFilePcccDTOReport(ownerList, reportType);
		List<PmlFilePcccDTO> isDelegatedListDTO = getPmlFilePcccDTOReport(isDelegatedList, reportType);
		List<PmlFilePcccDTO> delegatedListDTO = getPmlFilePcccDTOReport(delegatedList, reportType);
		
		Map<String, List<PmlFilePcccDTO>> mapReport = new HashMap<String, List<PmlFilePcccDTO>>();
		mapReport.put(DelegateConstants.OWNER, ownerListDTO);
		mapReport.put(DelegateConstants.IS_DELEGATED, isDelegatedListDTO);
		mapReport.put(DelegateConstants.DELEGATED, delegatedListDTO);
		
		return mapReport;
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
				filePcccDTO.setStt(String.valueOf(result.size() + 1));
				
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
				
				PmlProcessDispose log = getProcessDipose(file.getFileId());
				if (log != null) {
					// ngay chuyen
					filePcccDTO.setSendDateReport(df.format(log.getSendDate()));
					
					// ngay nhan
					filePcccDTO.setReceiveDateReport(log.getReceiveDate() != null ? df.format(log.getReceiveDate()) : "");
					
					// ngay het han
					filePcccDTO.setExpireDateReport(df.format(log.getExpiredDate()));
					
					// trang thai ho so
					PmlStateProcess status = PmlStateProcessLocalServiceUtil.getPmlStateProcess(log.getStateProcessIdBefore());
					try {					
						PmlFileStatusStateProcess fileStatusStateProcess = PmlFileStatusStateProcessLocalServiceUtil.findByStateProcessId(status.getStateProcessId()).get(0);
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


	@SuppressWarnings("unchecked")
	@Override
	public ActionForward renderStruts(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
		
		// dung de forward tro lai trang search
		String dataForSearch = ParamUtil.getString(req, "dataForSearch", "");
		
		//trieu add 20091203
//		try {
//			//get all PmlEdmLevelSend
//			List<PmlEdmLevelSend> pmlEdmLevelSendList = PmlEdmLevelSendUtil.findAll();
//			if (pmlEdmLevelSendList == null) {
//				req.setAttribute("pmlEdmLevelSendList",new ArrayList<PmlEdmLevelSend>() );
//			}
//			req.setAttribute("pmlEdmLevelSendList",pmlEdmLevelSendList);
//		} catch (Exception e) {
//			System.out.println("ERROR: "+ e.getMessage());
//			e.printStackTrace();
//		}
		// go back
		String transitionBack = ParamUtil.getString(req, "transitionBack", "");
		req.setAttribute("transitionBack", transitionBack);
		
		// get current user
		long userId = PortalUtil.getUserId(req);		

		// get value filter
		String type = ParamUtil.getString(req, "type", "");
		String valueType = ParamUtil.getString(req, "valueType", "");		
		
		String beginDateParam = ParamUtil.getString(req,"beginDate", "");
		String endDateParam = ParamUtil.getString(req,"endDate","");
		
		String fileTypeFilter = ParamUtil.getString(req,"fileTypeFilter", "");
		
		String sort = ParamUtil.getString(req,"sort","");
		// Dieu kien thong ke tu trang chu
		String status = ParamUtil.getString(req, "processValue", "");
		String isDelegate = ParamUtil.getString(req, "isDelegate", "");
		// load du lieu tiep theo
		int lastMsgId = ParamUtil.getInteger(req, "last_msg_id", 0);
		boolean loadData = ParamUtil.getBoolean(req, "loadData", false);
		
		// Dieu kien sort cua danh sach can xu ly
		PortletURL portletURL = res.createRenderURL();
		portletURL.setWindowState(WindowState.NORMAL);
		portletURL.setParameter("struts_action", "/nss/onedoorprocess/view");
		portletURL.setParameter("type", type);
		portletURL.setParameter("valueType", valueType);
		portletURL.setParameter("beginDateParam", beginDateParam);
		portletURL.setParameter("endDateParam", endDateParam);
		portletURL.setParameter("fileTypeFilter", fileTypeFilter);
		PmlOneDoorReceiveFileSearch searchContainer = new PmlOneDoorReceiveFileSearch(req, portletURL);
		
		// yenlt 07052010
		// Dieu kien sort cua danh sach xu ly chua nhan
		PortletURL portletURLChuaNhan = res.createRenderURL();
		portletURLChuaNhan.setWindowState(WindowState.NORMAL);
		portletURLChuaNhan.setParameter("struts_action", "/nss/onedoorprocess/view");
		portletURLChuaNhan.setParameter("processValue", "sofilechuanhan");
		portletURLChuaNhan.setParameter("type", type);
		portletURLChuaNhan.setParameter("valueType", valueType);
		portletURLChuaNhan.setParameter("beginDateParam", beginDateParam);
		portletURLChuaNhan.setParameter("endDateParam", endDateParam);
		portletURLChuaNhan.setParameter("fileTypeFilter", fileTypeFilter);
		PmlOneDoorReceiveFileSearch searchContainerChuaNhan = new PmlOneDoorReceiveFileSearch(req, portletURLChuaNhan);
		
		// Dieu kien sort cua danh sach can xu ly trong ngay
		PortletURL portletURLCanXLTrongNgay = res.createRenderURL();
		portletURLCanXLTrongNgay.setWindowState(WindowState.NORMAL);
		portletURLCanXLTrongNgay.setParameter("struts_action", "/nss/onedoorprocess/view");
		portletURLCanXLTrongNgay.setParameter("processValue", "sofilecanxuly");
		portletURLCanXLTrongNgay.setParameter("type", type);
		portletURLCanXLTrongNgay.setParameter("valueType", valueType);
		portletURLCanXLTrongNgay.setParameter("beginDateParam", beginDateParam);
		portletURLCanXLTrongNgay.setParameter("endDateParam", endDateParam);
		portletURLCanXLTrongNgay.setParameter("fileTypeFilter", fileTypeFilter);
		PmlOneDoorReceiveFileSearch searchContainerCanXLTrongNgay = new PmlOneDoorReceiveFileSearch(req, portletURLCanXLTrongNgay);
		
		// Dieu kien sort cua danh sach xu ly tre han
		PortletURL portletURLTreHan = res.createRenderURL();
		portletURLTreHan.setWindowState(WindowState.NORMAL);
		portletURLTreHan.setParameter("struts_action", "/nss/onedoorprocess/view");
		portletURLTreHan.setParameter("processValue", "sofiledaquahan");
		portletURLTreHan.setParameter("type", type);
		portletURLTreHan.setParameter("valueType", valueType);
		portletURLTreHan.setParameter("beginDateParam", beginDateParam);
		portletURLTreHan.setParameter("endDateParam", endDateParam);
		portletURLTreHan.setParameter("fileTypeFilter", fileTypeFilter);
		PmlOneDoorReceiveFileSearch searchContainerTrehan = new PmlOneDoorReceiveFileSearch(req, portletURLTreHan);
		
		// Dieu kien sort cua danh sach cho bo sung
		PortletURL portletURLBoSung = res.createRenderURL();
		portletURLBoSung.setWindowState(WindowState.NORMAL);
		portletURLBoSung.setParameter("struts_action", "/nss/onedoorprocess/view");
		portletURLBoSung.setParameter("processValue", "sofilechobosung");
		portletURLBoSung.setParameter("type", type);
		portletURLBoSung.setParameter("valueType", valueType);
		portletURLBoSung.setParameter("beginDateParam", beginDateParam);
		portletURLBoSung.setParameter("endDateParam", endDateParam);
		portletURLBoSung.setParameter("fileTypeFilter", fileTypeFilter);
		PmlOneDoorReceiveFileSearch searchContainerBoSung = new PmlOneDoorReceiveFileSearch(req, portletURLBoSung);
		
		// Dieu kien sort cua danh sach da uy quyen
		PortletURL portletURLDelegated = res.createRenderURL();
		portletURLDelegated.setWindowState(WindowState.NORMAL);
		portletURLDelegated.setParameter("struts_action", "/nss/onedoorprocess/view");
		portletURLDelegated.setParameter("type", type);
		portletURLDelegated.setParameter("valueType", valueType);
		portletURLDelegated.setParameter("beginDateParam", beginDateParam);
		portletURLDelegated.setParameter("endDateParam", endDateParam);
		portletURLDelegated.setParameter("fileTypeFilter", fileTypeFilter);
		PmlOneDoorReceiveFileSearchDelegated searchContainerDelegated = new PmlOneDoorReceiveFileSearchDelegated(req, portletURLDelegated);
		
		// Dieu kien sort cua danh sach duoc uy quyen
		PortletURL portletURLIsDelegated = res.createRenderURL();
		portletURLIsDelegated.setWindowState(WindowState.NORMAL);
		portletURLIsDelegated.setParameter("struts_action", "/nss/onedoorprocess/view");
		portletURLIsDelegated.setParameter("type", type);
		portletURLIsDelegated.setParameter("valueType", valueType);
		portletURLIsDelegated.setParameter("beginDateParam", beginDateParam);
		portletURLIsDelegated.setParameter("endDateParam", endDateParam);
		portletURLIsDelegated.setParameter("fileTypeFilter", fileTypeFilter);
		PmlOneDoorReceiveFileSearchIsDelegated searchContainerIsDelegated = new PmlOneDoorReceiveFileSearchIsDelegated(req, portletURLIsDelegated);
		
		
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
		List<PmlFilePcccDTO> listFileDTO = new ArrayList<PmlFilePcccDTO>();
		List<PmlFilePcccDTO> isDelegatedListDTO = new ArrayList<PmlFilePcccDTO>();
		List<PmlFilePcccDTO> delegatedListDTO = new ArrayList<PmlFilePcccDTO>();
				
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String toDate = df.format(sdf.parse(sdf.format(date)));
		
		if (SO_FILE_CHUA_NHAN.equals(status)) {	
			listFileDTO = getPmlFilePcccDTO(PmlOneDoorReceiveFileLocalServiceUtil.getListFileChuaNhanChuaHoanThanh(userId, typeList, valueTypeList, lastMsgId, lastMsgId + 20, searchContainerChuaNhan.getOrderByComparator()));
			
		} else if (SO_FILE_CAN_XU_LY.equals(status)) {
			listFileDTO = getPmlFilePcccDTO(PmlOneDoorReceiveFileLocalServiceUtil.getListFileCanXuLyTrongNgay(userId, toDate, typeList, valueTypeList, lastMsgId, lastMsgId + 20, searchContainerCanXLTrongNgay.getOrderByComparator()));
			
		} else if (SO_FILE_DA_QUA_HAN.equals(status)) {
			listFileDTO = getPmlFilePcccDTO(PmlOneDoorReceiveFileLocalServiceUtil.getListFileQuaHanISOChuaHoanThanh(userId, toDate, typeList, valueTypeList, lastMsgId, lastMsgId + 20, searchContainerTrehan.getOrderByComparator()));
				
		} else if (SO_FILE_CHO_BO_SUNG.equals(status)) {
			listFileDTO = getPmlFilePcccDTO(PmlOneDoorReceiveFileLocalServiceUtil.getListFileChoBoSungChuaHoanThanh(userId, typeList, valueTypeList, lastMsgId, lastMsgId + 20, searchContainerBoSung.getOrderByComparator()));
			
		 } else {
			listFileDTO = getPmlFilePcccDTO(PmlOneDoorReceiveFileLocalServiceUtil.getListFileNeedProcess(userId, typeList, valueTypeList, lastMsgId, lastMsgId + 20, searchContainer.getOrderByComparator()));
		}
		
		delegatedListDTO = getPmlFilePcccDTO(PmlOneDoorReceiveFileLocalServiceUtil.getListFileDelegated(userId, typeList, valueTypeList, searchContainerDelegated.getOrderByComparator()));
		isDelegatedListDTO = getPmlFilePcccDTO(PmlOneDoorReceiveFileLocalServiceUtil.getListFileIsDelegated(userId, typeList, valueTypeList, searchContainerIsDelegated.getOrderByComparator()));
		
		// phan loc theo loai ho so
		List<PmlFileType> fileTypeList = new ArrayList<PmlFileType>();
		try {
			fileTypeList = PmlFileTypeLocalServiceUtil.getPmlFileTypes(-1, -1);
		} catch (Exception e) {
			fileTypeList = new ArrayList<PmlFileType>();
			System.out.println("ERROR: Get List FileType: "+ e.getMessage());
		}
		
		req.setAttribute("dataForSearch", dataForSearch);
		req.setAttribute("sort", sort);
		req.setAttribute("loadData", loadData);
		
		req.setAttribute("processValue", status);
		req.setAttribute("isDelegate", isDelegate);
		req.setAttribute("lastMsgId", lastMsgId);
		req.setAttribute("fileTypeList", fileTypeList);
		req.setAttribute("fileTypeFilter", fileTypeFilter);
		req.setAttribute("pmlOneDoorReceiveFileSearch", searchContainer);
		req.setAttribute("pmlOneDoorReceiveFileSearchDelegated", searchContainerDelegated);
		req.setAttribute("pmlOneDoorReceiveFileSearchIsDelegated", searchContainerIsDelegated);
		
		req.setAttribute("type", type);
		req.setAttribute("valueType", valueType);
		req.setAttribute("beginDateParam", beginDateParam);
		req.setAttribute("endDateParam", endDateParam);
		
		req.setAttribute("ownerList", listFileDTO);
		req.setAttribute("isDelegatedList", isDelegatedListDTO);
		req.setAttribute("delegatedList", delegatedListDTO);
		return mapping.findForward("portlet.nss.onedoorprocess.view");
	}
	
//	@Override
//	public ActionForward renderStruts(ActionMapping mapping, ActionForm form,
//			PortletConfig config, RenderRequest req, RenderResponse res)
//			throws Exception {
//		//trieu add 20091203
//		try {
//			//get all PmlEdmLevelSend
//			List<PmlEdmLevelSend> pmlEdmLevelSendList = PmlEdmLevelSendUtil.findAll();
//			if (pmlEdmLevelSendList == null) {
//				req.setAttribute("pmlEdmLevelSendList",new ArrayList<PmlEdmLevelSend>() );
//			}
//			req.setAttribute("pmlEdmLevelSendList",pmlEdmLevelSendList);
//		} catch (Exception e) {
//			System.out.println("ERROR: "+ e.getMessage());
//			e.printStackTrace();
//		}
//		//minh add 16/07/2009
//		//List<PmlStateProcess>  pmlStateProcessList = ((OneDoorProcessLiferayWorkflowService) super.getLiferayWorkflowService()).getStateOfFileWithUser(PortalUtil.getUserId(req));
//		
//		//req.setAttribute("fileStateList", pmlStateProcessList);
//		//end add
//		
//		long userId = PortalUtil.getUserId(req);
//		
//		PortletPreferences prefs = req.getPreferences();
//
//		String portletResource = ParamUtil.getString(req, "portletResource");
//
//		if (Validator.isNotNull(portletResource)) {
//			prefs = PortletPreferencesFactoryUtil.getPortletSetup(req,portletResource);
//		}
//
//		int isProcess = GetterUtil.getInteger(prefs.getValue("isProcess",StringPool.BLANK));
//		String showStatus = GetterUtil.getString(prefs.getValue("showStatus",StringPool.BLANK));
//		
//		String status = ParamUtil.getString(req, "processValue", "");
//
//		int ip = ParamUtil.getInteger(req, "isProcess", 0);
//		if (ip == 1) {
//			isProcess = ip;
//		}
//		
//		req.setAttribute("showStatus", showStatus);
//		req.setAttribute("isProcess", String.valueOf(isProcess));
//		String transitionBack = ParamUtil.getString(req, "transitionBack", "");
//		req.setAttribute("transitionBack", transitionBack);
//
//		String type = ParamUtil.getString(req, "type", "");
//		String valueType = ParamUtil.getString(req, "valueType", "");
//		
//		//minh add
//		
//		String fileStateFilter = ParamUtil.getString(req, "fileStateFilter", "");
//		
//		if (!"".equalsIgnoreCase(fileStateFilter)) {
//			valueType = String.valueOf(fileStateFilter);
//		}
//		
//		String beginDateParam = ParamUtil.getString(req,"beginDate", "");
//		String endDateParam = ParamUtil.getString(req,"endDate","");
//		
//		if (!"".equals(beginDateParam) && !"".equals(endDateParam)   ) {
//			valueType = beginDateParam +"_" + endDateParam;
//		}
//		
//		//end add
//		
//		List<PmlFilePcccDTO> listFileDTO = new ArrayList<PmlFilePcccDTO>();
//		List<PmlFilePcccDTO> isDelegatedListDTO = new ArrayList<PmlFilePcccDTO>();
//		List<PmlFilePcccDTO> delegatedListDTO = new ArrayList<PmlFilePcccDTO>();
//		//yenlt 26/03/2010
//		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//		Date date = new Date();
//		String toDate = df.format(sdf.parse(sdf.format(date)));
//		//end
//		
//		
//		if ("all".equals(showStatus)) {
//			
//			if (isProcess == 1) {
//				if (Constants.SO_FILE_CHUA_NHAN.equals(status)) {
//					/* Yenlt 26/02/2010 close start
//					List<PmlOneDoorReceiveFile> fileList = PmlUserLocalServiceUtil.getListFileChuaNhan(userId, now);
//					Yenlt close end */
//					
//					// Yenlt update 26/02/2010
//					List<PmlOneDoorReceiveFile> fileList = PmlOneDoorReceiveFileLocalServiceUtil.getListFileChuaNhanChuaHoanThanh(userId);
//					//end
//					listFileDTO = getPmlFilePcccDTO(fileList);
//				} else if (Constants.SO_FILE_CAN_XU_LY.equals(status)) {
//					List<PmlOneDoorReceiveFile> fileList = new ArrayList<PmlOneDoorReceiveFile>();
//					
//					/* Yenlt 26/02/2010 close start
//					List<PmlOneDoorReceiveFile> tonTruoc = PmlUserLocalServiceUtil.getListFileTonTruoc(userId, now);
//					List<PmlOneDoorReceiveFile> daNhan = PmlUserLocalServiceUtil.getListFileDaNhan(userId, now);
//					List<PmlOneDoorReceiveFile> chuaNhan = PmlUserLocalServiceUtil.getListFileChuaNhan(userId, now);
//					if (tonTruoc != null) {
//						fileList.addAll(tonTruoc);
//					}
//					
//					if (daNhan != null) {
//						fileList.addAll(daNhan);
//					}
//					
//					if (chuaNhan != null) {
//						fileList.addAll(chuaNhan);
//					}
//					Yenlt close end */
//					
//					List<Long> userIds = new ArrayList<Long>();
//					userIds.add(userId);
//					
//					fileList = PmlOneDoorReceiveFileLocalServiceUtil.getListFileCanXuLy(userId, toDate);
////					fileList = PmlOneDoorReceiveFileLocalServiceUtil.getListFileCanXuLy(userIds, toDate);
//
//					listFileDTO = getPmlFilePcccDTO(fileList);
//				} else if (Constants.SO_FILE_DA_QUA_HAN.equals(status)) {
//					/* Yenlt 26/02/2010 close start
//					List<PmlOneDoorReceiveFile> fileList = PmlUserLocalServiceUtil.getListFileQuaHanISO(userId, now);
//					Yenlt close end */
//					List<PmlOneDoorReceiveFile> fileList = PmlOneDoorReceiveFileLocalServiceUtil.getListFileQuaHanISOChuaHoanThanh(userId, toDate);//Yenlt update 26/02/2010
//					listFileDTO = getPmlFilePcccDTO(fileList);
//				
//				} else if (Constants.SO_FILE_CHO_BO_SUNG.equals(status)) {
//					/* Yenlt 26/02/2010 close start
//					List<PmlOneDoorReceiveFile> fileList = PmlUserLocalServiceUtil.getListFileDangChoBoSung(userId, now);
//					Yenlt close end */
//					List<PmlOneDoorReceiveFile> fileList = PmlOneDoorReceiveFileLocalServiceUtil.getListFileChoBoSungChuaHoanThanh(userId);//Yenlt update 26/02/2010
//					listFileDTO = getPmlFilePcccDTO(fileList);
//				}
//
//				List<PmlOneDoorReceiveFile> ownerList = new ArrayList<PmlOneDoorReceiveFile>();
//				List<PmlOneDoorReceiveFile> isDelegatedList = new ArrayList<PmlOneDoorReceiveFile>();
//				List<PmlOneDoorReceiveFile> delegatedList = new ArrayList<PmlOneDoorReceiveFile>();
//				
//				Map<String, List<PmlOneDoorReceiveFile>> map = filterMapFileByUser(req);
//				if (map != null) {
//					ownerList = map.get(DelegateConstants.OWNER);
//					isDelegatedList = map.get(DelegateConstants.IS_DELEGATED);
//					delegatedList = map.get(DelegateConstants.DELEGATED);
//				}
//				//Yenlt
////				List<PmlFilePcccDTO> listMap = getPmlFilePcccDTO(ownerList);
////				for ( int t=0; t < listMap.size(); t++) {
////					System.out.println(" map "+ t+ " = "+listMap.get(t).getFileId() );
////					listFileDTO.add(listMap.get(t));
////					
////				}
//				//end
//				
////				listFileDTO = getPmlFilePcccDTO(ownerList);
////				long userId = 0;
////				try {
////					userId = PortalUtil.getUserId((RenderRequest) req);
////				} catch (Exception e) {
////					userId = PortalUtil.getUserId((ActionRequest) req);
////				}
//				listFileDTO = getPmlFilePcccDTO(PmlOneDoorReceiveFileLocalServiceUtil.getListFileNeedProcess(userId, new ArrayList<String>(), new ArrayList<String>()));
//				
//				isDelegatedListDTO = getPmlFilePcccDTO(isDelegatedList);
//				delegatedListDTO = getPmlFilePcccDTO(delegatedList);
//
//			} 
//			
//			else {
//				List<PmlOneDoorReceiveFile> ownerList = new ArrayList<PmlOneDoorReceiveFile>();
//				ownerList = filterFileByUser(req, type, valueType);
//				listFileDTO = getPmlFilePcccDTO(ownerList);
//			}
//		} 
//		
//		else {
//			List<String> processState = new ArrayList<String>();
//			processState.add(showStatus);
//			List<PmlOneDoorReceiveFile> listFile = ((OneDoorProcessLiferayWorkflowService) super.getLiferayWorkflowService())
//					.getListPmlFilesByUserWithSate(userId, type, valueType,	processState);
//			listFileDTO = getPmlFilePcccDTO(listFile);
//		}
//		
//		String cmd = ParamUtil.getString(req, com.liferay.portal.kernel.util.Constants.CMD, "");
//		String list = ParamUtil.getString(req, "list", "");
//		// phmphuc update 20/04/2010
//		listFileDTO = sortListFileDTO(listFileDTO, "mahoso", 0);
//		delegatedListDTO = sortListFileDTO(delegatedListDTO, "mahoso", 0);
//		isDelegatedListDTO = sortListFileDTO(isDelegatedListDTO, "mahoso", 0);
//		// end
//		
//		if ("sort".equals(cmd)) {
//			if ("ownerList".equals(list)) {
//				String sortBy = ParamUtil.getString(req, "sortBy","");
//				int flag = ParamUtil.getInteger(req, "ownerFlag", 0);
//				if (flag == 0) {
//					flag = 1;
//				}
//				else {
//					flag = 0;
//				}
//				listFileDTO = sortListFileDTO(listFileDTO, sortBy, flag);
//				req.setAttribute("ownerFlag", flag);
//			}
//			
//			if ("delegatedList".equals(list)) {
//				String sortBy = ParamUtil.getString(req, "sortBy","");
//				int flag = ParamUtil.getInteger(req, "delegateFlag", 0);
//				if (flag == 0) {
//					flag = 1;
//				}
//				else {
//					flag = 0;
//				}
//				delegatedListDTO = sortListFileDTO(delegatedListDTO, sortBy, flag);
//				req.setAttribute("delegateFlag", flag);
//			}
//			
//			if ("isDelegatedList".equals(list)) {
//				String sortBy = ParamUtil.getString(req, "sortBy","");
//				int flag = ParamUtil.getInteger(req, "isDelegateFlag", 0);
//				if (flag == 0) {
//					flag = 1;
//				}
//				else {
//					flag = 0;
//				}
//				isDelegatedListDTO = sortListFileDTO(isDelegatedListDTO, sortBy, flag);
//				req.setAttribute("isDelegateFlag", flag);
//			}
//			
//		}
//	
//		req.setAttribute("type", type);
//		req.setAttribute("valueType", valueType);
//		
//		req.setAttribute("beginDateParam", beginDateParam);
//		req.setAttribute("endDateParam", endDateParam);
//		req.setAttribute("fileStateFilter",fileStateFilter);
//		
//		req.setAttribute("ownerList", listFileDTO);
//		req.setAttribute("isDelegatedList", isDelegatedListDTO);
//		req.setAttribute("delegatedList", delegatedListDTO);
//		return mapping.findForward("portlet.sgs.onedoorpcccprocess.view");
//
//	}

//	private Map<String, List<PmlOneDoorReceiveFile>> filterMapFileByUser(
//			PortletRequest req) throws Exception {
//
//		// HttpServletRequest request = PortalUtil.getHttpServletRequest(req);
//
//		String type = ParamUtil.getString(req, "type", "");
//		String valueType = ParamUtil.getString(req, "valueType", "");
//		
//		//minh add 16/07/2009
//		String fileStateFilter = ParamUtil.getString(req, "fileStateFilter", "");
//		
//		if (!"".equalsIgnoreCase(fileStateFilter)) {
//			valueType = String.valueOf(fileStateFilter);
//		}
//		
//		String beginDateParam = ParamUtil.getString(req,"beginDate", "");
//		String endDateParam = ParamUtil.getString(req,"endDate","");
//		
//		if (!"".equals(beginDateParam) && !"".equals(endDateParam)   ) {
//			valueType = beginDateParam +"_" + endDateParam;
//		}
//		
//		
//		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//		Date beginDate = null;
//		Date endDate = null;
//		//end add
//		
//		long userId = 0;
//		try {
//			userId = PortalUtil.getUserId((RenderRequest) req);
//		} catch (Exception e) {
//			userId = PortalUtil.getUserId((ActionRequest) req);
//		}
//
//		// long userId = PortalUtil.getUserId((RenderRequest) req);
//
//		Map<String, List<PmlOneDoorReceiveFile>> map = new HashMap<String, List<PmlOneDoorReceiveFile>>();
//
//		// set type to request
//		req.setAttribute("type", type);
//		req.setAttribute("valueType", valueType);
//
//		PortletSession session = req.getPortletSession();
//		List<String> valueTypeList = (List<String>) session.getAttribute(
//				"keyWordList", PortletSession.APPLICATION_SCOPE);
//		List<String> typeList = (List<String>) session.getAttribute(
//				"typeFilterList", PortletSession.APPLICATION_SCOPE);
//		
//		if (valueTypeList == null) {
//			valueTypeList = new ArrayList<String>();
//			valueTypeList.add(valueType);
//
//		}
//
//		else {
//			valueTypeList.add(valueType);
//		}
//
//		if (typeList == null) {
//			typeList = new ArrayList<String>();
//			typeList.add(type);
//		}
//
//		else {
//			typeList.add(type);
//		}
//
//		
//		if ("".equals(type) || type == null) {
//			map = ((OneDoorProcessLiferayWorkflowService) super
//					.getLiferayWorkflowService()).getPmlFileMapByUserId(userId,
//					type, valueType);
//
//			valueTypeList = new ArrayList<String>();
//			typeList = new ArrayList<String>();
//			
//			
//			session.setAttribute("keyWordList", valueTypeList,PortletSession.APPLICATION_SCOPE);
//			session.setAttribute("typeFilterList", typeList,PortletSession.APPLICATION_SCOPE);
//		} else {
//			Map<String, List<PmlOneDoorReceiveFile>> mapTemp = new HashMap<String, List<PmlOneDoorReceiveFile>>();			
//			mapTemp = ((OneDoorProcessLiferayWorkflowService) super.getLiferayWorkflowService()).getPmlFileMapByUserId(userId,	typeList.get(0), valueTypeList.get(0));
//			
//			List<PmlOneDoorReceiveFile> ownerList = mapTemp.get(DelegateConstants.OWNER);
//			List<PmlOneDoorReceiveFile> isDelegatedList = mapTemp.get(DelegateConstants.IS_DELEGATED);
//			List<PmlOneDoorReceiveFile> delegatedList = mapTemp.get(DelegateConstants.DELEGATED);
//
//			if (ownerList == null) {
//				ownerList = new ArrayList<PmlOneDoorReceiveFile>();
//			}
//			if (isDelegatedList == null) {
//				isDelegatedList = new ArrayList<PmlOneDoorReceiveFile>();
//			}
//			if (delegatedList == null) {
//				delegatedList = new ArrayList<PmlOneDoorReceiveFile>();
//			}
//
//			for (int i = 1; i < valueTypeList.size(); i++) {
//				List<PmlOneDoorReceiveFile> ownerListTemp = new ArrayList<PmlOneDoorReceiveFile>();
//				List<PmlOneDoorReceiveFile> isDelegatedListTemp = new ArrayList<PmlOneDoorReceiveFile>();
//				List<PmlOneDoorReceiveFile> delegatedListTemp = new ArrayList<PmlOneDoorReceiveFile>();
//				
//				if (ownerList.size() > 0) {
//					for (PmlOneDoorReceiveFile pmlOwnerOneDoorReceiveFile : ownerList) {
//						if ("mahoso".equalsIgnoreCase(typeList.get(i))) {
//							String numberReceiptToUpperCase = pmlOwnerOneDoorReceiveFile.getNumberReceipt().toUpperCase();
//							String valueTypeToUpperCase = valueTypeList.get(i).toUpperCase();
//							
//							if (numberReceiptToUpperCase.contains(valueTypeToUpperCase)) {
//								ownerListTemp.add(pmlOwnerOneDoorReceiveFile);
//							}
//						} 
//						
//						else if ("tenhoso".equalsIgnoreCase(typeList.get(i))) {
//							String fileId = pmlOwnerOneDoorReceiveFile.getFileId();
//							PmlFilePCCC filePCCC = PmlFilePCCCLocalServiceUtil.getPmlFilePCCC(fileId);
//							String numberReceiptToUpperCase = filePCCC.getFileName().toUpperCase();
//							String valueTypeToUpperCase = valueTypeList.get(i).toUpperCase();
//							
//							if (numberReceiptToUpperCase.contains(valueTypeToUpperCase)) {
//								ownerListTemp.add(pmlOwnerOneDoorReceiveFile);
//							}
//						}
//						
//						// ADD UPDATE
//						else if ("loaihoso".equals(typeList.get(i))) {
//							String fileTypeId = pmlOwnerOneDoorReceiveFile.getFileTypeId();
//							
//							PmlFileType pmlFileType = null;
//							try{
//								pmlFileType = PmlFileTypeUtil.findByPrimaryKey(fileTypeId);
//							}catch (Exception e) {}
//							
//							if (pmlFileType != null) {
//								if (pmlFileType.getFileTypeName().toUpperCase(new Locale("vi")).contains(valueTypeList.get(i).toUpperCase(new Locale("vi")))) {
//									ownerListTemp.add(pmlOwnerOneDoorReceiveFile);
//								}
//							}
//						}
//						else if ("trangthaihoso".equals(typeList.get(i))) {
//							String fileId = pmlOwnerOneDoorReceiveFile.getFileId();
//							
//							String fileState = ((OneDoorProcessLiferayWorkflowService) getLiferayWorkflowService()).getState(fileId);							
//							if (fileState.equalsIgnoreCase(valueTypeList.get(i))){
//								ownerListTemp.add(pmlOwnerOneDoorReceiveFile);
//							}
//							
//						}
//						
//						else if ("ngaygui".equals(typeList.get(i))) {
//							
//							PmlProcessDispose pmlProcessDispose = getProcessDipose(pmlOwnerOneDoorReceiveFile.getFileId());
//							
//							if (pmlProcessDispose.getSendDate() == null){
//								ownerListTemp.add(pmlOwnerOneDoorReceiveFile);
//							}
//							
//							else {
//								if (!"".equals(valueTypeList.get(i))) {
//									beginDate =	dateFormat.parse(valueTypeList.get(i).split("_")[0]);
//									endDate =	dateFormat.parse(valueTypeList.get(i).split("_")[1]);
//									Date sendDate = dateFormat.parse(dateFormat.format(pmlProcessDispose.getSendDate()));
//									
//									if ((beginDate.before(sendDate) || beginDate.equals(sendDate))
//										&& (sendDate.before(endDate) || sendDate.equals(endDate))){ 
//										
//										ownerListTemp.add(pmlOwnerOneDoorReceiveFile);
//									}
//								}
//							}
//						}
//						
//						else if ("ngaynhan".equals(typeList.get(i))) {
//							
//							PmlProcessDispose pmlProcessDispose = getProcessDipose(pmlOwnerOneDoorReceiveFile.getFileId());
//							
//							if (pmlProcessDispose.getReceiveDate() == null){
//								ownerListTemp.add(pmlOwnerOneDoorReceiveFile);
//							}
//							
//							else {
//								if (!"".equals(valueTypeList.get(i))) {
//									beginDate =	dateFormat.parse(valueTypeList.get(i).split("_")[0]);
//									endDate =	dateFormat.parse(valueTypeList.get(i).split("_")[1]);
//									Date receiveDate = dateFormat.parse(dateFormat.format(pmlProcessDispose.getReceiveDate()));
//									
//									if ((beginDate.before(receiveDate) || beginDate.equals(receiveDate))
//										&& (receiveDate.before(endDate) || receiveDate.equals(endDate))){ 
//										
//										ownerListTemp.add(pmlOwnerOneDoorReceiveFile);
//									}
//								}
//							}
//						}
//						
//						else if ("ngayhethan".equals(typeList.get(i))) {
//							
//							PmlProcessDispose pmlProcessDispose = getProcessDipose(pmlOwnerOneDoorReceiveFile.getFileId());
//							
//							if (pmlProcessDispose.getExpiredDate() == null){
//								ownerListTemp.add(pmlOwnerOneDoorReceiveFile);
//							}
//							
//							else {
//								if (!"".equals(valueTypeList.get(i))) {
//									beginDate =	dateFormat.parse(valueTypeList.get(i).split("_")[0]);
//									endDate =	dateFormat.parse(valueTypeList.get(i).split("_")[1]);
//									Date expiredDate = dateFormat.parse(dateFormat.format(pmlProcessDispose.getExpiredDate()));
//									
//									if ((beginDate.before(expiredDate) || beginDate.equals(expiredDate))
//										&& (expiredDate.before(endDate) || expiredDate.equals(endDate))){ 
//										
//										ownerListTemp.add(pmlOwnerOneDoorReceiveFile);
//									}
//								}
//							}
//						}
//						
//						else if ("ngayhentrakhach".equals(typeList.get(i))) {
//							if (!"".equals(valueTypeList.get(i))) {
//								beginDate =	dateFormat.parse(valueTypeList.get(i).split("_")[0]);
//								endDate =	dateFormat.parse(valueTypeList.get(i).split("_")[1]);
//								
//							
//								Date expectedReturningDate = dateFormat.parse(dateFormat.format(pmlOwnerOneDoorReceiveFile.getExpectedReturningDate()));
//								
//								if ((beginDate.before(expectedReturningDate) || beginDate.equals(expectedReturningDate))
//										&& (expectedReturningDate.before(endDate) || expectedReturningDate.equals(endDate))){ 
//										
//									ownerListTemp.add(pmlOwnerOneDoorReceiveFile);
//								}
//							}
//						}
//						
//						//END EDD UPDATE
//						
//					}
//				}
//				ownerList = ownerListTemp;
//
//// PHAN DS HS DUOC UY QUYEN				
//				if (isDelegatedList.size() > 0) {
//					for (PmlOneDoorReceiveFile pmlIsDelegatedOneDoorReceiveFile : isDelegatedList) {
//						if ("mahoso".equalsIgnoreCase(typeList.get(i))) {
//							String numberReceiptToUpperCase = pmlIsDelegatedOneDoorReceiveFile.getNumberReceipt().toUpperCase();
//							String valueTypeToUpperCase = valueTypeList.get(i).toUpperCase();
//							
//							if (numberReceiptToUpperCase.contains(valueTypeToUpperCase)) {
//								isDelegatedListTemp.add(pmlIsDelegatedOneDoorReceiveFile);
//							}
//						}
//
//						if ("tenhoso".equalsIgnoreCase(typeList.get(i))) {
//							String fileId = pmlIsDelegatedOneDoorReceiveFile.getFileId();
//							PmlFilePCCC filePCCC = PmlFilePCCCLocalServiceUtil.getPmlFilePCCC(fileId);
//							String numberReceiptToUpperCase = filePCCC.getFileName().toUpperCase();
//							String valueTypeToUpperCase = valueTypeList.get(i).toUpperCase();
//							
//							if (numberReceiptToUpperCase.contains(valueTypeToUpperCase)) {
//								isDelegatedListTemp.add(pmlIsDelegatedOneDoorReceiveFile);
//							}
//						}
//						// minh add 16-07-2009
//						
//						else if ("loaihoso".equals(typeList.get(i))) {
//							String fileTypeId = pmlIsDelegatedOneDoorReceiveFile.getFileTypeId();
//							
//							PmlFileType pmlFileType = null;
//							try{
//								pmlFileType = PmlFileTypeUtil.findByPrimaryKey(fileTypeId);
//							}catch (Exception e) {}
//							
//							if (pmlFileType != null) {
//								if (pmlFileType.getFileTypeName().toUpperCase(new Locale("vi")).contains(valueTypeList.get(i).toUpperCase(new Locale("vi")))) {
//									isDelegatedListTemp.add(pmlIsDelegatedOneDoorReceiveFile);
//								}
//							}
//						}
//						else if ("trangthaihoso".equals(typeList.get(i))) {
//							String fileId = pmlIsDelegatedOneDoorReceiveFile.getFileId();
//							
//							String fileState = ((OneDoorProcessLiferayWorkflowService) getLiferayWorkflowService()).getState(fileId);							
//							if (fileState.equalsIgnoreCase(valueTypeList.get(i))){
//								isDelegatedListTemp.add(pmlIsDelegatedOneDoorReceiveFile);
//							}
//							
//						}
//						
//						else if ("ngaygui".equals(typeList.get(i))) {
//							
//							PmlProcessDispose pmlProcessDispose = getProcessDipose(pmlIsDelegatedOneDoorReceiveFile.getFileId());
//							
//							if (pmlProcessDispose.getSendDate() == null){
//								isDelegatedListTemp.add(pmlIsDelegatedOneDoorReceiveFile);
//							}
//							
//							else {
//								if (!"".equals(valueTypeList.get(i))) {
//									beginDate =	dateFormat.parse(valueTypeList.get(i).split("_")[0]);
//									endDate =	dateFormat.parse(valueTypeList.get(i).split("_")[1]);
//									Date sendDate = dateFormat.parse(dateFormat.format(pmlProcessDispose.getSendDate()));
//								
//								if ((beginDate.before(sendDate) || beginDate.equals(sendDate))
//									&& (sendDate.before(endDate) || sendDate.equals(endDate))){ 
//									
//									isDelegatedListTemp.add(pmlIsDelegatedOneDoorReceiveFile);
//									}
//								}
//							}
//						}
//						
//						else if ("ngaynhan".equals(typeList.get(i))) {
//						
//							
//							PmlProcessDispose pmlProcessDispose = getProcessDipose(pmlIsDelegatedOneDoorReceiveFile.getFileId());
//							
//							if (pmlProcessDispose.getReceiveDate() == null){
//								isDelegatedListTemp.add(pmlIsDelegatedOneDoorReceiveFile);
//							}
//							
//							else {
//								if (!"".equals(valueTypeList.get(i))) {
//									beginDate =	dateFormat.parse(valueTypeList.get(i).split("_")[0]);
//									endDate =	dateFormat.parse(valueTypeList.get(i).split("_")[1]);
//									Date receiveDate = dateFormat.parse(dateFormat.format(pmlProcessDispose.getReceiveDate()));
//								
//									if ((beginDate.before(receiveDate) || beginDate.equals(receiveDate))
//											&& (receiveDate.before(endDate) || receiveDate.equals(endDate))){ 
//									
//										isDelegatedListTemp.add(pmlIsDelegatedOneDoorReceiveFile);
//									}
//								}
//							}
//						}
//						
//						else if ("ngayhethan".equals(typeList.get(i))) {
//							
//							PmlProcessDispose pmlProcessDispose = getProcessDipose(pmlIsDelegatedOneDoorReceiveFile.getFileId());
//							
//							if (pmlProcessDispose.getExpiredDate() == null){
//								isDelegatedListTemp.add(pmlIsDelegatedOneDoorReceiveFile);
//							}
//							
//							else {
//								if (!"".equals(valueTypeList.get(i))) {
//									beginDate =	dateFormat.parse(valueTypeList.get(i).split("_")[0]);
//									endDate =	dateFormat.parse(valueTypeList.get(i).split("_")[1]);
//									Date expiredDate = dateFormat.parse(dateFormat.format(pmlProcessDispose.getExpiredDate()));
//								
//									if ((beginDate.before(expiredDate) || beginDate.equals(expiredDate))
//										&& (expiredDate.before(endDate) || expiredDate.equals(endDate))){ 
//										
//										isDelegatedListTemp.add(pmlIsDelegatedOneDoorReceiveFile);
//									}
//								}
//							}
//						}
//						
//						else if ("ngayhentrakhach".equals(typeList.get(i))) {
//							if (!"".equals(valueTypeList.get(i))) {
//								beginDate =	dateFormat.parse(valueTypeList.get(i).split("_")[0]);
//								endDate =	dateFormat.parse(valueTypeList.get(i).split("_")[1]);
//								Date expectedReturningDate = dateFormat.parse(dateFormat.format(pmlIsDelegatedOneDoorReceiveFile.getExpectedReturningDate()));
//								
//								if ((beginDate.before(expectedReturningDate) || beginDate.equals(expectedReturningDate))
//										&& (expectedReturningDate.before(endDate) || expectedReturningDate.equals(endDate))){ 
//										
//									isDelegatedListTemp.add(pmlIsDelegatedOneDoorReceiveFile);
//								}
//							}
//						}
//						
//						//END EDD UPDATE
//						
//					}
//				}
//				isDelegatedList = isDelegatedListTemp;
//// PHAN DS HS UY QUYEN
//				if (delegatedList.size() > 0) {
//					for (PmlOneDoorReceiveFile pmlDelegateOneDoorReceiveFile : delegatedList) {
//						if ("mahoso".equalsIgnoreCase(typeList.get(i))) {
//							String numberReceiptToUpperCase = pmlDelegateOneDoorReceiveFile.getNumberReceipt().toUpperCase(new Locale("vi"));
//							String valueTypeToUpperCase = valueTypeList.get(i).toUpperCase(new Locale("vi"));
//							
//							if (numberReceiptToUpperCase.contains(valueTypeToUpperCase)) {
//								delegatedListTemp.add(pmlDelegateOneDoorReceiveFile);
//							}
//						}
//						
//						if ("tenhoso".equalsIgnoreCase(typeList.get(i))) {
//							String fileId = pmlDelegateOneDoorReceiveFile.getFileId();
//							PmlFilePCCC filePCCC = PmlFilePCCCLocalServiceUtil.getPmlFilePCCC(fileId);
//							String numberReceiptToUpperCase = filePCCC.getFileName().toUpperCase(new Locale("vi"));
//							String valueTypeToUpperCase = valueTypeList.get(i).toUpperCase(new Locale("vi"));
//							
//							if (numberReceiptToUpperCase.contains(valueTypeToUpperCase)) {
//								delegatedListTemp.add(pmlDelegateOneDoorReceiveFile);
//							}
//						}
//						
//						// minh add 16-07-2009
//						
//						// ADD UPDATE
//						else if ("loaihoso".equals(typeList.get(i))) {
//							String fileTypeId = pmlDelegateOneDoorReceiveFile.getFileTypeId();
//							
//							PmlFileType pmlFileType = null;
//							try{
//								pmlFileType = PmlFileTypeUtil.findByPrimaryKey(fileTypeId);
//							}catch (Exception e) {}
//							
//							if (pmlFileType != null) {
//								if (pmlFileType.getFileTypeName().toUpperCase(new Locale("vi")).contains(valueTypeList.get(i).toUpperCase(new Locale("vi")))) {
//									delegatedListTemp.add(pmlDelegateOneDoorReceiveFile);
//								}
//							}
//						}
//						else if ("trangthaihoso".equals(typeList.get(i))) {
//							String fileId = pmlDelegateOneDoorReceiveFile.getFileId();
//							
//							String fileState = ((OneDoorProcessLiferayWorkflowService) getLiferayWorkflowService()).getState(fileId);								
//							if (fileState.equalsIgnoreCase(valueTypeList.get(i))){
//								delegatedListTemp.add(pmlDelegateOneDoorReceiveFile);
//							}
//							
//						}
//						
//						else if ("ngaygui".equals(typeList.get(i))) {
//							
//							PmlProcessDispose pmlProcessDispose = getProcessDipose(pmlDelegateOneDoorReceiveFile.getFileId());
//							
//							if (pmlProcessDispose.getSendDate() == null){
//								delegatedListTemp.add(pmlDelegateOneDoorReceiveFile);
//							}
//							
//							else {
//								if (!"".equals(valueTypeList.get(i))) {
//									beginDate =	dateFormat.parse(valueTypeList.get(i).split("_")[0]);
//									endDate =	dateFormat.parse(valueTypeList.get(i).split("_")[1]);
//									Date sendDate = dateFormat.parse(dateFormat.format(pmlProcessDispose.getSendDate()));
//									
//									if ((beginDate.before(sendDate) || beginDate.equals(sendDate))
//										&& (sendDate.before(endDate) || sendDate.equals(endDate))){ 
//										
//										delegatedListTemp.add(pmlDelegateOneDoorReceiveFile);
//									}
//								}
//							}
//						}
//						
//						else if ("ngaynhan".equals(typeList.get(i))) {
//														
//							PmlProcessDispose pmlProcessDispose = getProcessDipose(pmlDelegateOneDoorReceiveFile.getFileId());
//							
//							if (pmlProcessDispose.getReceiveDate() == null){
//								delegatedListTemp.add(pmlDelegateOneDoorReceiveFile);
//							}
//							
//							else {
//								if (!"".equals(valueTypeList.get(i))) {
//									beginDate =	dateFormat.parse(valueTypeList.get(i).split("_")[0]);
//									endDate =	dateFormat.parse(valueTypeList.get(i).split("_")[1]);
//									Date receiveDate = dateFormat.parse(dateFormat.format(pmlProcessDispose.getReceiveDate()));
//									
//									if ((beginDate.before(receiveDate) || beginDate.equals(receiveDate))
//										&& (receiveDate.before(endDate) || receiveDate.equals(endDate))){ 
//										
//										delegatedListTemp.add(pmlDelegateOneDoorReceiveFile);
//									}
//								}
//							}
//						}
//						
//						else if ("ngayhethan".equals(typeList.get(i))) {
//							
//							PmlProcessDispose pmlProcessDispose = getProcessDipose(pmlDelegateOneDoorReceiveFile.getFileId());
//							
//							if (pmlProcessDispose.getExpiredDate() == null){
//								delegatedListTemp.add(pmlDelegateOneDoorReceiveFile);
//							}
//							
//							else {
//								if (!"".equals(valueTypeList.get(i))) {
//									beginDate =	dateFormat.parse(valueTypeList.get(i).split("_")[0]);
//									endDate =	dateFormat.parse(valueTypeList.get(i).split("_")[1]);
//									Date expiredDate = dateFormat.parse(dateFormat.format(pmlProcessDispose.getExpiredDate()));
//									
//									if ((beginDate.before(expiredDate) || beginDate.equals(expiredDate))
//										&& (expiredDate.before(endDate) || expiredDate.equals(endDate))){ 
//										
//										delegatedListTemp.add(pmlDelegateOneDoorReceiveFile);
//									}
//								}
//							}
//						}
//						
//						else if ("ngayhentrakhach".equals(typeList.get(i))) {
//							if (!"".equals(valueTypeList.get(i))) {
//								beginDate =	dateFormat.parse(valueTypeList.get(i).split("_")[0]);
//								endDate =	dateFormat.parse(valueTypeList.get(i).split("_")[1]);
//								Date expectedReturningDate = dateFormat.parse(dateFormat.format(pmlDelegateOneDoorReceiveFile.getExpectedReturningDate()));
//								
//								if ((beginDate.before(expectedReturningDate) || beginDate.equals(expectedReturningDate))
//										&& (expectedReturningDate.before(endDate) || expectedReturningDate.equals(endDate))){ 
//										
//									delegatedListTemp.add(pmlDelegateOneDoorReceiveFile);
//								}
//							}
//						}
//						
//						//END EDD UPDATE
//						
//					}
//				}
//				delegatedList = delegatedListTemp;
//			}
//
//			map.put(DelegateConstants.OWNER, ownerList);
//			map.put(DelegateConstants.IS_DELEGATED, isDelegatedList);
//			map.put(DelegateConstants.DELEGATED, delegatedList);
//
//			session.setAttribute("keyWordList", valueTypeList, PortletSession.APPLICATION_SCOPE);
//			session.setAttribute("typeFilterList", typeList, PortletSession.APPLICATION_SCOPE);
//		}
//		return map;
//	}

	private List<PmlFilePcccDTO> getPmlFilePcccDTO(
			List<PmlOneDoorReceiveFile> list) throws Exception {

		List<PmlFilePcccDTO> result = new ArrayList<PmlFilePcccDTO>();

		if (list == null) {
			return result;
		}
		
		for (PmlOneDoorReceiveFile file : list) {
			PmlFilePcccDTO filePcccDTO = new PmlFilePcccDTO();

			// gan gia tri hien thi voi file
			filePcccDTO.setApplicationDate(file.getApplicationDate());
			filePcccDTO.setExpectedReturingDate(file.getExpectedReturningDate());
			filePcccDTO.setFileId(file.getFileId());
			filePcccDTO.setNumberReceipt(file.getNumberReceipt());
			
			// gan gia tri hien thi voi filePCCC
			PmlFilePCCC filePCCC = PmlFilePCCCLocalServiceUtil.getPmlFilePCCC(file
					.getFileId());
			
			filePcccDTO.setFileName(filePCCC.getFileName());

			// gan gia tri hien thi voi fileType
			PmlFileType fileType = null;
			try {
				fileType = PmlFileTypeLocalServiceUtil.getPmlFileType(file.getFileTypeId());
				filePcccDTO.setFiletype(fileType.getFileTypeName());
			}catch (Exception e) {
				filePcccDTO.setFiletype("");
			}

			PmlProcessDispose log = null;
			try {
				log = getProcessDipose(file.getFileId());
			} catch (Exception e) { }
			
			if (log != null) {
				
				filePcccDTO.setSendDate(log.getSendDate());
				filePcccDTO.setReceiveDate(log.getReceiveDate());
				filePcccDTO.setExpireDate(log.getExpiredDate());
				
				//Yenlt update 17/03/2010
				PmlStateProcess status = PmlStateProcessLocalServiceUtil.getPmlStateProcess(log.getStateProcessIdBefore());
				try {					
					PmlFileStatusStateProcess fileStatusStateProcess = PmlFileStatusStateProcessLocalServiceUtil.findByStateProcessId(status.getStateProcessId()).get(0);
					filePcccDTO.setStatus(fileStatusStateProcess.getDescription()); // status
				} catch (Exception e) {
					filePcccDTO.setStatus("");
				}
				//end
			}
			
			result.add(filePcccDTO);
		}
		return result;
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

	/**
	 * lay danh sach theo doi cua user
	 * 
	 * @param req
	 * @param valueType
	 * @param reportType
	 * @return
	 */
//	private List<PmlOneDoorReceiveFile> filterFileByUser(RenderRequest req,
//			String type, String valueType) {
//		List<PmlOneDoorReceiveFile> files = new ArrayList<PmlOneDoorReceiveFile>();
//		try {
//			long userId = PortalUtil.getUserId(req);
//			if ((type != null && "".equals(type.trim()))
//					|| (valueType != null && "".equals(valueType.trim()))) {
//				type = null;
//				valueType = null;
//			}
//
//			List<PmlUserFileType> userFileType = PmlUserFileTypeUtil
//					.findByUserId(userId);
//
//			if (userFileType == null) {
//				return null;
//			}
//
//			for (int i = 0; i < userFileType.size(); i++) {
//				PmlUserFileType pmlUserFileType = userFileType.get(i);
//				String fileTypeId = pmlUserFileType.getFileTypeId();
//				List<PmlOneDoorReceiveFile> f = new ArrayList<PmlOneDoorReceiveFile>();
//				if ("all".equals(type) || valueType == null) {
//					f = PmlOneDoorReceiveFileUtil.findByFileTypeId(fileTypeId);
//				}
//				if (Constants.FILE_CODE.equals(type) && valueType != null) {
//
//					f = PmlOneDoorReceiveFileUtil.findByFileType_NumberReceipt(
//							fileTypeId, "%" + type + "%");
//				}
//
//				if (Constants.FILE_NAME.equals(type) && valueType != null) {
//					List<PmlOneDoorReceiveFile> fs = null;
//					fs = PmlOneDoorReceiveFileUtil.findByFileTypeId(fileTypeId);
//					if (fs == null) {
//						return null;
//					}
//
//					for (int j = 0; j < fs.size(); j++) {
//						PmlOneDoorReceiveFile file = fs.get(j);
//						if (file != null) {
//							try {
//								PmlFilePCCC pcccFile = PmlFilePCCCUtil
//										.findByPrimaryKey(file.getFileId());
//								if (pcccFile.getFileName().indexOf(valueType) > -1) {
//									f.add(file);
//								}
//							} catch (NoSuchException e) {
//								e.printStackTrace();
//							}
//						}
//					}
//				}
//
//				if (f != null) {
//					files.addAll(f);
//				}
//
//			}
//
//			// set type to request
//			if (type != null) {
//				req.setAttribute("type", type);
//			}
//
//			// valueType to request.
//			if (valueType != null) {
//				req.setAttribute("valueType", valueType);
//			}
//		} catch (SystemException e) {
//			e.printStackTrace();
//		}
//
//		return files;
//	}

//	private List<PmlFilePcccDTO> getPmlFilePcccDTOReport(
//			List<PmlOneDoorReceiveFile> list, String reportType)
//			throws Exception {
//
//		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
//
//		List<PmlFilePcccDTO> result = new ArrayList<PmlFilePcccDTO>();
//
//		if (list == null) {
//			return result;
//		}
//		for (PmlOneDoorReceiveFile file : list) {
//			PmlFilePcccDTO filePcccDTO = new PmlFilePcccDTO();
//
//			// gan gia tri hien thi voi file
//			filePcccDTO.setStt(String.valueOf(result.size() + 1));//Yenlt update 09/03/2010
//			if (reportType.equals("word")) {
//				filePcccDTO.setApplicantName(StringUtils.convertToRTF(file
//						.getApplicantName()));
//			} else if (reportType.equals("excel")) {
//				filePcccDTO.setApplicantName(file.getApplicantName());
//			}
//			filePcccDTO.setApplicationDate(file.getApplicationDate());
//			filePcccDTO.setAuthourisedLetter(file.getAuthorisedLetter());
//			filePcccDTO.setBriefContent(file.getBriefContent());
//			filePcccDTO.setContactInformation(file.getContactInfomation());
//			filePcccDTO.setDateCreate(file.getDateCreated());
//			filePcccDTO.setExpectedReturingDateReport(df.format(file
//					.getExpectedReturningDate()));
//			filePcccDTO.setFileId(file.getFileId());
//			filePcccDTO.setGender(file.getGender());
//			filePcccDTO.setIdNumber(file.getIdNumber());
//			filePcccDTO.setIssuingDate(file.getIssuingDate());
//			filePcccDTO.setIssuingPlace(file.getIssuingPlace());
//			filePcccDTO.setNumberReceipt(file.getNumberReceipt());
//			filePcccDTO.setOrganization(file.getOrganization());
//			filePcccDTO.setOtherContent(file.getOtherContent());
//			filePcccDTO.setPermanentAddress(file.getPermanentAddress());
//			filePcccDTO.setReceiver(file.getReceiver());
//			filePcccDTO.setSolvingTime(file.getSolvingTime());
//			filePcccDTO.setTelephone(file.getTelephone());
//			// phmphuc update 20/04/2010
//			filePcccDTO.setGeneralorderno(file.getGeneralorderno());
//			// end
//
//			// gan gia tri hien thi voi filePCCC
//			PmlFilePCCC filePCCC = PmlFilePCCCUtil.findByPrimaryKey(file
//					.getFileId());
//			filePcccDTO.setAddressBuilder(filePCCC.getAddressBuilder());
//			filePcccDTO.setApplicantCategory(filePCCC.getApplicantCategory());
//			filePcccDTO.setApplicantRepresentation(filePCCC
//					.getApplicantRepresentation());
//			filePcccDTO.setApplicantTelephone(filePCCC.getApplicantTelephone());
//			filePcccDTO.setConclusion(filePCCC.getConclusion());
//			filePcccDTO.setDesignCop(filePCCC.getDesignCop());
//			if (reportType.equals("word")) {
//				filePcccDTO.setFileName(StringUtils.convertToRTF(filePCCC
//						.getFileName()));
//			} else if (reportType.equals("excel")) {
//				filePcccDTO.setFileName(filePCCC.getFileName());
//			}
//			filePcccDTO.setFileNumber(filePCCC.getFileNumber());
//			filePcccDTO.setInputDataDateReport(df.format(filePCCC
//					.getInputDataDate()));
//			filePcccDTO.setInvestor(filePCCC.getInvestor());
//			filePcccDTO.setNoteInformationManagement(filePCCC
//					.getNoteInformationManagement());
//			filePcccDTO.setProjectname(filePCCC.getProjectName());
//			filePcccDTO.setReceiverRepresentation(filePCCC
//					.getReceiverRepresentation());
//			filePcccDTO.setReceiverTelephone(filePCCC.getReceiverTelephone());
//
//			// gan gia tri hien thi voi fileType
//			PmlFileType fileType = PmlFileTypeUtil.findByPrimaryKey(file
//					.getFileTypeId());
//			if (reportType.equals("word")) {
//				filePcccDTO.setFiletype(StringUtils.convertToRTF(fileType
//						.getFileTypeName()));
//			} else if (reportType.equals("excel")) {
//				filePcccDTO.setFiletype(fileType.getFileTypeName());
//			}
//			PmlProcessDispose log = getProcessDipose(file.getFileId());
//			if (log != null) {
//				filePcccDTO.setSendDateReport(df.format(log.getSendDate()));
//				filePcccDTO
//						.setReceiveDateReport(log.getReceiveDate() != null ? df
//								.format(log.getReceiveDate()) : "");
//				filePcccDTO
//						.setExpireDateReport(df.format(log.getExpiredDate()));
//				PmlStateProcess status = PmlStateProcessUtil
//						.findByPrimaryKey(log.getStateProcessIdBefore());
//				if (reportType.equals("word")) {
//					filePcccDTO.setStatus(StringUtils.convertToRTF(status
//							.getStateProcessName()));
//				} else if (reportType.equals("excel")) {
//					filePcccDTO.setStatus(status.getStateProcessName());
//				}
//			}
//			result.add(filePcccDTO);
//		}
//		return result;
//	}

//
//	private void reportFileByUser(PortletRequest req, PortletResponse res,
//			String type) throws Exception {
//
//		HttpServletRequest request = PortalUtil.getHttpServletRequest(req);
//		HttpServletResponse response = PortalUtil.getHttpServletResponse(res);
//
//		ReportFileByUserUtil rtfUtil = new ReportFileByUserUtil(request
//				.getSession().getServletContext().getRealPath("reports"),
//				filterMapFileByUserReport(req, type));
//		InputStream in = rtfUtil.run(request.getSession().getServletContext()
//				.getRealPath("reports/ReportFileByUser.rtf"));
//		ServletResponseUtil.sendFile(response, "report.rtf", in,
//				"application/rtf");
//	}
	
	
	
	
//
//	private void reportFileByUserExcel(PortletRequest req, PortletResponse res,
//			String reportType) throws Exception {
//		ServletContext context = PortalUtil.getHttpServletRequest(req)
//				.getSession().getServletContext();
//		HttpServletResponse response = PortalUtil.getHttpServletResponse(res);
//		JRExporter exporter = null;
//
//		JasperDesign subDesign1 = JRXmlLoader.load(context
//				.getRealPath("reports/ReportFileByUser_subreport1.jrxml"));
//		JasperReport subJasperReport1 = JasperCompileManager
//				.compileReport(subDesign1);
//		JasperDesign subDesign2 = JRXmlLoader.load(context
//				.getRealPath("reports/ReportFileByUser_subreport2.jrxml"));
//		JasperReport subJasperReport2 = JasperCompileManager
//				.compileReport(subDesign2);
//		JasperDesign subDesign3 = JRXmlLoader.load(context
//				.getRealPath("reports/ReportFileByUser_subreport3.jrxml"));
//		JasperReport subJasperReport3 = JasperCompileManager
//				.compileReport(subDesign3);
//
//		Map subMap1 = new HashMap();
//		Map subMap2 = new HashMap();
//		Map subMap3 = new HashMap();
//
//		Map<String, List<PmlFilePcccDTO>> reportData = filterMapFileByUserReport(
//				req, reportType);
//
//		JRBeanCollectionDataSource dataSource1 = new JRBeanCollectionDataSource(
//				reportData.get(DelegateConstants.OWNER));
//		JRBeanCollectionDataSource dataSource2 = new JRBeanCollectionDataSource(
//				reportData.get(DelegateConstants.IS_DELEGATED));
//		JRBeanCollectionDataSource dataSource3 = new JRBeanCollectionDataSource(
//				reportData.get(DelegateConstants.DELEGATED));
//
//		JasperCompileManager.compileReportToFile(context
//				.getRealPath("reports/ReportFileByUser.jrxml"), context
//				.getRealPath("reports/ReportFileByUser.jasper"));
//
//		Map map = new HashMap();
//		map.put("dataSource1", dataSource1);
//		map.put("dataSource2", dataSource2);
//		map.put("dataSource3", dataSource3);
//
//		map.put("subReport1", subJasperReport1);
//		map.put("subReport2", subJasperReport2);
//		map.put("subReport3", subJasperReport3);
//
//		map.put("subMap1", subMap1);
//		map.put("subMap2", subMap2);
//		map.put("subMap3", subMap3);
//
//		JREmptyDataSource dataSource = new JREmptyDataSource();
//
//		JasperFillManager.fillReportToFile(context
//				.getRealPath("reports/ReportFileByUser.jasper"), context
//				.getRealPath("reports/ReportFileByUser.jrprint"), map,
//				dataSource);
//		File srcFile = new File(context
//				.getRealPath("reports/ReportFileByUser.jrprint"));
//		File desFile = null;
//
//		JasperPrint jasperPrint = (JasperPrint) JRLoader.loadObject(srcFile);
//		desFile = File.createTempFile(jasperPrint.getName(), ".xls");
//
//		exporter = new JExcelApiExporter();
//		exporter.setParameter(JRXlsExporterParameter.JASPER_PRINT, jasperPrint);
//		exporter.setParameter(JRXlsExporterParameter.OUTPUT_FILE_NAME, desFile
//				.toString());
//		exporter.exportReport();
//
//		InputStream in = new FileInputStream(desFile);
//		ServletResponseUtil.sendFile(response, "report.xls", in,
//				"application/vnd.ms-excel");
//	}
	
	/*
	 * by triltm
	 */
//	private List<PmlFilePcccDTO> sortListFileDTO(
//			List<PmlFilePcccDTO> listFileDTO, String sortBy, int flag) {
//
//		Collator viCollator = Collator.getInstance(new Locale("vi"));
//		String str1 = "";
//		String str2 = "";
//		// phmphuc update 20/04/2010
//		long in1 = 0;
//		long in2 = 0;
//		// end
//		Date date1 = null;
//		Date date2 = null;
//		for (int i = 0; i < listFileDTO.size(); i++) {
//			for (int j = i + 1; j < listFileDTO.size(); j++) {
//				if ("mahoso".equals(sortBy)) {
//					// phmphuc update 20/04/2010
////					str1 = listFileDTO.get(i).getNumberReceipt();
////					str2 = listFileDTO.get(j).getNumberReceipt();
//					in1 = listFileDTO.get(i).getGeneralorderno();
//					in2 = listFileDTO.get(j).getGeneralorderno();
//					// end
//				}
//				
//				if ("tenhoso".equals(sortBy)) {
//					str1 = listFileDTO.get(i).getFileName();
//					str2 = listFileDTO.get(j).getFileName();
//				}
//				
//				if ("loaihoso".equals(sortBy)) {
//					str1 = listFileDTO.get(i).getFiletype();
//					str2 = listFileDTO.get(j).getFiletype();
//				}
//				
//				if ("trangthaihoso".equals(sortBy)) {
//					str1 = listFileDTO.get(i).getStatus();
//					str2 = listFileDTO.get(j).getStatus();
//				}
//				
//				if ("ngayguihoso".equals(sortBy)) {
//					date1 = listFileDTO.get(i).getSendDate();
//					date2 = listFileDTO.get(j).getSendDate();
//					str1 = getStringFromDate(date1);
//					str2 = getStringFromDate(date2);
//				}
//				
//				if ("ngaynhanhoso".equals(sortBy)) {
//					date1 = listFileDTO.get(i).getReceiveDate();
//					date2 = listFileDTO.get(j).getReceiveDate();
//					str1 = getStringFromDate(date1);
//					str2 = getStringFromDate(date2);
//				}
//				
//				if ("ngayhethanhoso".equals(sortBy)) {
//					date1 = listFileDTO.get(i).getExpireDate();
//					date2 = listFileDTO.get(j).getExpireDate();
//					str1 = getStringFromDate(date1);
//					str2 = getStringFromDate(date2);
//				}
//				
//				if ("ngayhentrahoso".equals(sortBy)) {
//					date1 = listFileDTO.get(i).getExpectedReturingDate();
//					date2 = listFileDTO.get(j).getExpectedReturingDate();
//					str1 = getStringFromDate(date1);
//					str2 = getStringFromDate(date2);
//				}
//				
//				if (flag == 0) {
//					if ((viCollator.compare(str1, str2) < 0) || (in1 < in2)) {
//						Collections.swap(listFileDTO, i, j);
//					}
//				}
//				else {
//					if ((viCollator.compare(str1, str2) > 0) || (in1 > in2)) {
//						Collections.swap(listFileDTO, i, j);
//					}
//				}
//			}
//		}
//		return listFileDTO;
//	}

//	private String getStringFromDate (Date d) {
//		String result = "";
//		String year = "";
//		String month = "";
//		String date = "";
//		
//		//YENLT 22/03/2010
//		if ( null == d ) {
//			return result;
//		}
//		//end
//		int yearInt = d.getYear() + 1900;
//		int monthInt = d.getMonth() + 1;
//		int dateInt = d.getDate();
//		if (null != d) {
//			d = new Date();
//		}
//		
//		year = String.valueOf(yearInt);
//		
//		if (monthInt < 10) {
//			month = "0" + monthInt;
//		}
//		else {
//			month = String.valueOf(monthInt);
//		}
//		
//		if (dateInt < 10) {
//			date = "0" + dateInt;
//		}
//		else {
//			date = String.valueOf(dateInt);
//		}
//		
//		result = year + "/" + month + "/" + date;
//		return result;
//	}
}
