<%@ include file="/html/portlet/ext/pcccdocumentreceiptprocess/init.jsp" %>

<%@ include file="/html/portlet/ext/pcccdocumentreceiptprocess/page_iterator/init_search.jsp" %>
<%@page import="com.sgs.portlet.document.service.PmlStateProcessLocalServiceUtil"%>
<%@page import="com.sgs.portlet.pmllevelsend.service.PmlEdmLevelSendLocalServiceUtil"%>
<%@page import="com.sgs.portlet.document.receipt.service.PmlEdmDocumentTypeLocalServiceUtil"%>
<%@page import="com.sgs.portlet.pmlissuingplace.service.PmlEdmIssuingPlaceLocalServiceUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.sgs.portlet.pcccdocumentreceiptprocess.search.PcccDocumentReceiptProcessSearch"%>
<%@page import="com.sgs.portlet.document.receipt.service.PmlEdmDocumentReceiptLocalServiceUtil"%>
<%@page import="java.util.Map"%>
<%@page import="com.liferay.portal.kernel.dao.search.RowChecker"%>
<%@page import="javax.portlet.PortletRequest"%>
<%@page import="javax.portlet.PortletResponse"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="java.util.List"%>
<%@page import="com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt"%>
<%@page import="com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentTypeUtil"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.sgs.portlet.pcccdocumentreceiptprocess.search.PcccDocumentReceiptProcessSearchTerms"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.sgs.portlet.document.receipt.model.PmlEdmDocumentType"%>
<%@page import="com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace"%>
<%@page import="com.sgs.portlet.pmlissuingplace.service.persistence.PmlEdmIssuingPlaceUtil"%>
<%@page import="com.sgs.portlet.pmllevelsend.model.PmlEdmLevelSend"%>
<%@page import="com.sgs.portlet.pmllevelsend.service.persistence.PmlEdmLevelSendUtil"%>
<%@page import="com.sgs.portlet.pcccdocumentreceiptprocess.search.PcccDocumentReceiptProcessSearchDisplayTerms"%>
<%@page import="com.sgs.portlet.document.workflow.DocumentReceiptLiferayWorkflowService"%>
<%@page import="com.sgs.portlet.document.service.persistence.PmlStateProcessUtil"%>
<%@page import="com.sgs.portlet.document.model.PmlStateProcess"%>
<%@page import="com.sgs.portlet.document.receipt.model.PmlFileStatusStateProcess"%>
<%@page import="com.sgs.portlet.document.receipt.service.persistence.PmlFileStatusStateProcessUtil"%>
<%@page import="com.sgs.portlet.document.model.PmlDocumentReceiptLog"%>
<%@page import="com.sgs.portlet.document.service.persistence.PmlDocumentReceiptLogUtil"%>
<%@page import="com.sgs.portlet.document.model.impl.PmlDocumentReceiptLogImpl"%>
<%@page import="java.util.Date"%>
<%@page import="com.sgs.portlet.document.util.DataReportUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.ext.portal.security.permission.ActionKeysExt"%>

<%@page import="com.sgs.portlet.document.model.PmlFileStatus"%>
<%@page import="com.sgs.portlet.document.service.PmlFileStatusLocalServiceUtil"%>

<%@page import="java.util.Comparator"%>
<%@page import="java.util.Collections"%>
<%@page import="com.liferay.util.portlet.PortletProps"%>

<script type='text/javascript' src='/html/js/liferay/tr.js'></script>

<div style="display: inherit;"> 
<%
// minh update 20110119
long statusIdDangXuLy = ParamUtil.getLong(renderRequest, "statusIdDangXuLy");	
// end minh update 20110119

// yenlt update 20101022
	String soVanBanDen = ParamUtil.getString(renderRequest, "sovanbanden", "");
	String soHieuGoc = ParamUtil.getString(renderRequest, "sohieugoc", "");
	int loaiSoVB = ParamUtil.getInteger(renderRequest, "loaisocongvan", 0);
	String issuingplaceId = ParamUtil.getString(renderRequest, "issuingplaceId", "");
	String noiphathanh = ParamUtil.getString(renderRequest, "noiphathanh", "");
	String trichyeu = ParamUtil.getString(renderRequest, "trichyeu", "");
	
	String tuNgay = ParamUtil.getString(renderRequest, "tungay", "");
	String denNgay = ParamUtil.getString(renderRequest, "denngay", "");
	String ngayhethan = ParamUtil.getString(renderRequest, "ngayhethan", "");
	
	boolean timkiemtheotieuchi = ParamUtil.getBoolean(renderRequest, "timkiemtheotieuchi", false);
	// end yenlt update 20101022
	String  tabChung = ParamUtil.getString(renderRequest,"tabChung");
	long statusId = renderRequest.getAttribute("statusId") == null ? 0 : (Long) renderRequest.getAttribute("statusId");
	
	String hienTrang = renderRequest.getAttribute("hienTrang") == null ? "dangXuLy" : (String) renderRequest.getAttribute("hienTrang");
	boolean isExpired = renderRequest.getAttribute("isExpired") == null ? false : (Boolean) renderRequest.getAttribute("isExpired");
	int year = renderRequest.getAttribute("year") == null ? new Date().getYear() + 1900 : (Integer) renderRequest.getAttribute("year");
	String nguoiXuLy = renderRequest.getAttribute( "nguoiXuLy") == null ? "xuLyChung" : (String) renderRequest.getAttribute( "nguoiXuLy") ; //yenlt update 09/04/2010
	String cachThucXuLy = ParamUtil.getString(renderRequest, "cachThucXuLy", "-1");
	List<PmlEdmDocumentReceipt> results = renderRequest.getAttribute("results") == null ? new ArrayList<PmlEdmDocumentReceipt>()
			: (List<PmlEdmDocumentReceipt>)renderRequest.getAttribute("results");
	int total1 = (Integer)renderRequest.getAttribute("total1") == null ? 0 : (Integer)renderRequest.getAttribute("total1");
	
	// phmphuc them 12/11/2010 - lay danh sach log tuong ung voi receipt
	List<PmlDocumentReceiptLog> resultsLog = renderRequest.getAttribute("resultLogs") == null ? new ArrayList<PmlDocumentReceiptLog>()
			: (List<PmlDocumentReceiptLog>)renderRequest.getAttribute("resultLogs");
	// end phmphuc update 12/11/2010

	List<Long> userIdList = new ArrayList<Long>();
	 
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(LiferayWindowState.EXCLUSIVE);	
	portletURL.setParameter("struts_action", "/sgs/pcccdocumentreceiptprocess/list");
	
	if (renderRequest.getAttribute("userIdList") != null) {
		userIdList = (List<Long>) renderRequest.getAttribute("userIdList");
		for(int i = 0; i < userIdList.size() ; i++) {			
			portletURL.setParameter(String.valueOf(userIdList.get(i)),  String.valueOf(userIdList.get(i)));
		}	
	}
	portletURL.setParameter("statusId", String.valueOf(statusId));
	portletURL.setParameter("hienTrang", hienTrang);
	portletURL.setParameter("isExpired", String.valueOf(isExpired));
	portletURL.setParameter("nguoiXuLy", nguoiXuLy);
	portletURL.setParameter("year", String.valueOf(year));
	portletURL.setParameter("tabChung", tabChung);
	
	
	pageContext.setAttribute("portletURL", portletURL);
	String portletURLString = portletURL.toString();
	request.setAttribute("view.jsp-portletURL", portletURL);
	request.setAttribute("view.jsp-portletURLString", portletURLString);
	
	PcccDocumentReceiptProcessSearch searchContainer = new PcccDocumentReceiptProcessSearch(renderRequest, portletURL);
	searchContainer = renderRequest.getAttribute("searchContainerList") != null ? (PcccDocumentReceiptProcessSearch)renderRequest.getAttribute("searchContainerList")
				:  new PcccDocumentReceiptProcessSearch(renderRequest, portletURL);
	
	PcccDocumentReceiptProcessSearchTerms searchTerms = (PcccDocumentReceiptProcessSearchTerms)searchContainer.getSearchTerms();
	searchContainer.setTotal(total1);
	searchContainer.setResults(results);
	portletURL.setParameter(searchContainer.getCurParam(), String.valueOf(searchContainer.getCurValue()));
	
	//yenlt 20101118
	PmlFileStatus fileStatus = null;
	fileStatus = PmlFileStatusLocalServiceUtil.getPmlFileStatus(statusId);
	String fileStatusCode = "";
	fileStatusCode = fileStatus.getFileStatusCode();
	// end yenlt 20101118
	
	// phmphuc add 09/11/2010 - in nhieu phieu chuyen
	if ((PortletPermissionUtil.contains(permissionChecker, plid, "SGS_PCCCDOCUMENTRECEIPTPROCESS_INSTANCE_HKH8", ActionKeysExt.TIEPNHANCV) == true) ||
		(PortletPermissionUtil.contains(permissionChecker, plid, "SGS_PCCCDOCUMENTRECEIPTPROCESS_INSTANCE_HKH8", ActionKeysExt.XLTHAYBGD) == true) ||
		(PortletPermissionUtil.contains(permissionChecker, plid, "SGS_PCCCDOCUMENTRECEIPTPROCESS_INSTANCE_HKH8", ActionKeysExt.GIAMDOCREPORT) == true) ||
		(PortletPermissionUtil.contains(permissionChecker, plid, "SGS_PCCCDOCUMENTRECEIPTPROCESS_INSTANCE_HKH8", ActionKeysExt.TRUONGPHONGREPORT) == true) || 
		"CVDEN_VANTHU_DANGXULY_CHUNG_vuatiepnhan".equalsIgnoreCase(fileStatusCode)) {
		
		searchContainer.setRowChecker(new RowChecker(renderResponse));
	}
	// end phmphuc add 09/11/2010
%>
	<input type="hidden" name="<portlet:namespace />changeCVP" />
	<input type="hidden" name="<portlet:namespace />documentReceiptIdList" />
	
	<input type="hidden" name="statusId" value="<%= statusId %>" id="<portlet:namespace/>hiddenStatus">
	<input type="hidden" name="isExpired" value="<%= String.valueOf(isExpired) %>" id="<portlet:namespace/>hiddenIsExpired">
	<input type="hidden" name="hienTrang" value="<%= hienTrang %>" id="<portlet:namespace/>hienTrang">
	<input type="hidden" name="nguoiXuLy" value="<%= nguoiXuLy %>" id="nguoiXuLy">
	<input type="hidden" name="cachThucXuLy" value="<%= cachThucXuLy %>" id="cachThucXuLy">
	<input type="hidden" name="year" value="<%= String.valueOf(year) %>" id="year">
	<input type="hidden" name="timkiemtheotieuchi" value="<%= String.valueOf(timkiemtheotieuchi) %>">
<%	
	PortletURL portletURLRedirect = renderResponse.createRenderURL();
	//portletURLRedirect.setWindowState(LiferayWindowState.EXCLUSIVE);
	portletURLRedirect.setWindowState(WindowState.NORMAL);
	portletURLRedirect.setParameter("struts_action", "/sgs/pcccdocumentreceiptprocess/view");
	portletURLRedirect.setParameter("hienTrang", hienTrang);
	portletURLRedirect.setParameter("nguoiXuLy", nguoiXuLy);
	portletURLRedirect.setParameter("isExpired", String.valueOf(isExpired));
	portletURLRedirect.setParameter("year", String.valueOf(year));
	portletURLRedirect.setParameter("statusId", String.valueOf(statusId));
	// yenlt update 20101022
	portletURLRedirect.setParameter("timkiemtheotieuchi", String.valueOf(timkiemtheotieuchi));
	portletURLRedirect.setParameter("sovanbanden", soVanBanDen);
	portletURLRedirect.setParameter("sohieugoc", soHieuGoc);
	portletURLRedirect.setParameter("loaisocongvan", String.valueOf(loaiSoVB));
	portletURLRedirect.setParameter("issuingplaceId", issuingplaceId);
	portletURLRedirect.setParameter("noiphathanh", noiphathanh);
	portletURLRedirect.setParameter("trichyeu", trichyeu);
	portletURLRedirect.setParameter("tungay", tuNgay);
	portletURLRedirect.setParameter("denngay", denNgay);
	portletURLRedirect.setParameter("ngayhethan", ngayhethan);
	// end yenlt update 20101022
	
	List resultRows1 = searchContainer.getResultRows();
	// xuancong: lay ma so trang thai, cap gui, loai van ban, noi phat hanh ra list
	List<Long> stateProcIdsFromSC = new ArrayList<Long>(); // List ma so trang thai tu search container
	List<Long> stateProcIdsMap = new ArrayList<Long>(); // List ma so trang thai mapping
	List<Integer> levelSendIdsFromSC = new ArrayList<Integer>(); // List ma so don vi gui tu search container
	List<Integer> levelSendIdsMap = new ArrayList<Integer>(); // List ma so don vi gui mapping
	List<Long> docTypeIdsFromSC = new ArrayList<Long>(); // List ma so loai van ban tu search container
	List<Long> docTypeIdsMap = new ArrayList<Long>(); // List ma so loai van ban mapping
	List<String> issuingPlaceIdsFromSC = new ArrayList<String>(); // List ma so don vi phat hanh tu search container
	List<String> issuingPlaceIdsMap = new ArrayList<String>(); // List ma so don vi phat hanh mapping
	
	for (int idx = 0; idx < results.size(); idx++) {
		PmlEdmDocumentReceipt docRecItem = (PmlEdmDocumentReceipt) results.get(idx);
		if (stateProcIdsFromSC.indexOf(docRecItem.getStatusId()) < 0) {
			stateProcIdsFromSC.add(docRecItem.getStatusId()); // Ma so trang thai
		}
		if (levelSendIdsFromSC.indexOf(docRecItem.getLevelSendId()) < 0) {
			levelSendIdsFromSC.add(docRecItem.getLevelSendId());
		}
		if (docTypeIdsFromSC.indexOf(docRecItem.getDocumentTypeId()) < 0) {
			docTypeIdsFromSC.add(docRecItem.getDocumentTypeId());
		}
		if (docRecItem.getIssuingPlaceId().trim().length() > 0 
				&& issuingPlaceIdsFromSC.indexOf(docRecItem.getIssuingPlaceId()) < 0) {
			issuingPlaceIdsFromSC.add(docRecItem.getIssuingPlaceId());
		} // end if
	}

	// Doc cac doi tuong ra list va luu ma so cua chung vao list tuong ung
	// Trang thai
	List<PmlStateProcess> stateProcessFromSC = PmlStateProcessLocalServiceUtil.findByStateProcessIds(stateProcIdsFromSC);
	if (stateProcessFromSC != null && !stateProcessFromSC.isEmpty()) {
		// Doc ma so trang thai ra list mapping
		for (int idxTmp = 0; idxTmp < stateProcessFromSC.size(); idxTmp++) {
			PmlStateProcess tmpObj = (PmlStateProcess) stateProcessFromSC.get(idxTmp);
			stateProcIdsMap.add(tmpObj.getStateProcessId());
		}
	}
	
	// Don vi gui
	List<PmlEdmLevelSend> levelSendFromSC = PmlEdmLevelSendLocalServiceUtil.findByLevelSendIds(levelSendIdsFromSC);
	if (levelSendFromSC != null && !levelSendFromSC.isEmpty()) {
		// Doc ma so don vi gui ra list mapping
		for (int idxTmp = 0; idxTmp < levelSendFromSC.size(); idxTmp++) {
			PmlEdmLevelSend tmpObj = (PmlEdmLevelSend) levelSendFromSC.get(idxTmp);
			levelSendIdsMap.add(tmpObj.getLevelSendId());
		}
	}

	// Loai van ban
	List<PmlEdmDocumentType> docTypeFromSC = PmlEdmDocumentTypeLocalServiceUtil.findByDocumentTypeIds(docTypeIdsFromSC);
	if (docTypeFromSC != null && !docTypeFromSC.isEmpty()) {
		// Doc ma so loai van ban ra list mapping
		for (int idxTmp = 0; idxTmp < docTypeFromSC.size(); idxTmp++) {
			PmlEdmDocumentType tmpObj = (PmlEdmDocumentType) docTypeFromSC.get(idxTmp);
			docTypeIdsMap.add(tmpObj.getDocumentTypeId());
		}
	}

	// Don vi phat hanh
	List<PmlEdmIssuingPlace> issuingPlaceFromSC = PmlEdmIssuingPlaceLocalServiceUtil.findByIssuingPlaceIds(issuingPlaceIdsFromSC);
	if (issuingPlaceFromSC != null && !issuingPlaceFromSC.isEmpty()) {
		// Doc ma so don vi phat hanh ra list mapping
		for (int idxTmp = 0; idxTmp < issuingPlaceFromSC.size(); idxTmp++) {
			PmlEdmIssuingPlace tmpObj = (PmlEdmIssuingPlace) issuingPlaceFromSC.get(idxTmp);
			issuingPlaceIdsMap.add(tmpObj.getIssuingPlaceId());
		}
	}
	long userId = PortalUtil.getUserId(PortalUtil.getHttpServletRequest(renderRequest)); //yenlt update 20101119
	for (int i = 0; i < results.size(); i ++) {
		PmlEdmDocumentReceipt pmlEdmDocumentReceipt = (PmlEdmDocumentReceipt) results.get(i);
		long documentReceiptId = pmlEdmDocumentReceipt.getDocumentReceiptId(); // phmphuc udpate 01/12/2010
		ResultRow row1 = new ResultRow(pmlEdmDocumentReceipt, documentReceiptId, i);
		
		PmlDocumentReceiptLog documentReceiptLog = null;
		try {
			documentReceiptLog =  PmlDocumentReceiptLogUtil.findByDocumentReceiptId_Processor_Receivedate_StateProcessIdAfter(
					documentReceiptId, userIdList.get(0) , null , 0).get(0);
		} catch (Exception e) {	
			if (!userIdList.isEmpty()) {
				try {
					documentReceiptLog = PmlDocumentReceiptLogUtil.findByDocumentReceiptId_Processor_StateProcessIdAfter(
							documentReceiptId, userIdList.get(0) , 0).get(0);
				} catch (Exception ex) {
					try {					
						documentReceiptLog = PmlDocumentReceiptLogUtil.findByDocumentReceiptId_Processor(
								documentReceiptId, userIdList.get(0)).get(0);	
					} catch (Exception e2) {
						documentReceiptLog = new PmlDocumentReceiptLogImpl();
					}
				}
			}
		}
		
		//PortletURL rowURL = new PortletURLImpl(request, "SGS_PCCCDOCUMENTRECEIPTPROCESS_INSTANCE_56nj", 33008, PortletRequest.RENDER_PHASE);
		PortletURL rowURL = new PortletURLImpl(request, "SGS_PCCCDOCUMENTRECEIPTPROCESS_INSTANCE_HKH8", 89385, PortletRequest.RENDER_PHASE);
		rowURL.setWindowState(WindowState.NORMAL);
		rowURL.setParameter("struts_action", "/sgs/pcccdocumentreceiptprocess/detail");
		rowURL.setParameter("documentReceiptId", String.valueOf(documentReceiptId));
		rowURL.setParameter(com.sgs.liferay.jbpm.util.Constants.WORKFLOW_RENDER, "true");				
		// minh update 20110119
		rowURL.setParameter("redirect", portletURLRedirect.toString()+"&statusId="+String.valueOf(statusId)+"&hienTrang="+hienTrang + "&"+ searchContainer.getCurParam() +"="+ searchContainer.getCurValue() +"&statusIdDangXuLy=" + String.valueOf(statusIdDangXuLy));
		// end minh update 20110119
		rowURL.setParameter("statusId", String.valueOf(statusId));	
		// minh update 20110119
		rowURL.setParameter("statusIdDangXuLy", String.valueOf(statusIdDangXuLy));	
		// end minh update 20110119
		rowURL.setParameter("tabChung", tabChung);	
		rowURL.setParameter("hienTrang", hienTrang);
		rowURL.setParameter("cachThucXuLy", cachThucXuLy);
		
		// yenlt update chuc nang rut lai 20101119
		boolean rutLai = false;
		List<PmlDocumentReceiptLog> logReturnList = new ArrayList<PmlDocumentReceiptLog>();
		logReturnList = PmlDocumentReceiptLogUtil.findByDocumentReceiptId_Processor(documentReceiptId, userId);
		long receiverIdBack = -1;
		if (logReturnList.size() == 1 && logReturnList.get(0).getType_() == 0) {// quy trinh chinh moi co rut lai
			PmlDocumentReceiptLog logBack = logReturnList.get(0);
			if (logBack.getDateProcess() != null) { // TH da gui VB
				if (logBack.getReceiveDate() != null) {// nguoi duoc gui da nhan
					rutLai = false;
				} else {// nguoi duoc gui chua nhan VB
					rutLai = true;
					receiverIdBack = logBack.getReceiver();
				}
			} else {// TH chua gui VB
				rutLai = false;
			}
		} else if (logReturnList.size() > 1) {
			List<PmlDocumentReceiptLog> logList = new ArrayList<PmlDocumentReceiptLog>();
			Collections.sort(logReturnList, new Comparator<PmlDocumentReceiptLog>() {
				public int compare(PmlDocumentReceiptLog o1, PmlDocumentReceiptLog o2) {
					int sort = o2.getTransition_()- o1.getTransition_();
					return sort;
				}
			});
			Date dateProcess = null;
			
			if (logReturnList.get(0).getDateProcessTime() != null) {
				dateProcess = logReturnList.get(0).getDateProcessTime();
			}
			
			for (PmlDocumentReceiptLog logReturnTemp : logReturnList) {
				if (logReturnTemp.getDateProcessTime()!= null && logReturnTemp.getDateProcessTime().equals(dateProcess)) {
					if (logReturnTemp.getReceiveDate() == null) {
						rutLai = true;
						logList.add(logReturnTemp);
					} else {
						rutLai = false;
						break;
					}
				}
				continue;
			}
			if (rutLai) {
				PmlDocumentReceiptLog logTransition = logList.get(logList.size() -1);
				PmlDocumentReceiptLog logReceiverBack = PmlDocumentReceiptLogUtil.
						findByDocumentReceiptId_Transition(documentReceiptId, logTransition.getTransition_()).get(0);
				receiverIdBack = logReceiverBack.getReceiver();
			}
		}
		rowURL.setParameter("rutLai", String.valueOf(rutLai));
		rowURL.setParameter("receiverId", String.valueOf(userId));
		rowURL.setParameter("receiverIdBack", String.valueOf(receiverIdBack));
		// end
		if (documentReceiptLog != null) {
			rowURL.setParameter("stateProcessId", String.valueOf(documentReceiptLog.getStateProcessIdBefore()));
		}
		
		// phmphuc them 17/09/2010
		List<PmlDocumentReceiptLog> pmlDocumentReceiptLogList = null;
		String expireDateProcess = "";
		long numberDateRemain = 1000;
		StringBuilder icon = new StringBuilder();
		try {
			// pmlDocumentReceiptLogList = PmlDocumentReceiptLogUtil.findByDocumentReceiptId(documentReceiptId);
			pmlDocumentReceiptLogList = PmlDocumentReceiptLogUtil.findByDocumentReceiptId_Receiver(documentReceiptId, userId);
			for (int t = 0; t < pmlDocumentReceiptLogList.size(); t ++) {
				if (pmlDocumentReceiptLogList.get(t).getExpiredDate() != null) {
					
					int result =  pmlDocumentReceiptLogList.get(t).getNumDateProcess();	
					numberDateRemain = result - (new Date().getTime() - pmlDocumentReceiptLogList.get(t).getExpiredDate().getTime()) / (24 * 60 * 60 * 1000);
					
					SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
					expireDateProcess = dateFormat.format(pmlDocumentReceiptLogList.get(t).getExpiredDate());
					break;
				}
			}
		} catch (Exception e) { }
		
		// flag
		if(numberDateRemain == 1 || numberDateRemain == 0) {
			icon.append("<img title=\"" + LanguageUtil.get(pageContext,"sap-den-han")+ "\"");
			icon.append(" border=\"0\" src=\"/html/images/pink.gif\"");
			icon.append(" height=\"18px\" width=\"18px\"");
			icon.append(" >");
		}
		else if(numberDateRemain > 1 || numberDateRemain == 1000) {
			icon.append("<img title=\"" + LanguageUtil.get(pageContext,"con-han")+ "\"");
			icon.append(" border=\"0\" src=\"/html/images/blue.gif\"");
			icon.append(" height=\"18px\" width=\"18px\"");
			icon.append(" >");
		}
		else if(numberDateRemain < 0){
			icon.append("<img title=\"" + LanguageUtil.get(pageContext,"tre-han")+ "\"");
			icon.append(" border=\"0\" src=\"/html/images/red.gif\"");
			icon.append(" height=\"18px\" width=\"18px\"");
			icon.append(" >");
		}
		else {
			icon.append("<img title=\"" + LanguageUtil.get(pageContext,"con-han")+ "\"");
			icon.append(" border=\"0\" src=\"/html/images/blue.gif\"");
			icon.append(" height=\"18px\" width=\"18px\"");
			icon.append(" >");
		}
		
		// STT
		if (hienTrang.equals("dangXuLy")) {
			row1.addText((i+1) + ". " + icon.toString());
		} else {
			row1.addText((i+1)+ ".");
		}
		
		// Cap gui
		int levelSendId = pmlEdmDocumentReceipt.getLevelSendId();
		PmlEdmLevelSend pmlEdmLevelSend = null;
		
		try {
			// Doc tu List thay cho doc database
			if (levelSendIdsMap.indexOf(levelSendId) >= 0) {
				pmlEdmLevelSend = (PmlEdmLevelSend) levelSendFromSC.get(levelSendIdsMap.indexOf(levelSendId));
			} // end if
		} catch (Exception e) {
			pmlEdmLevelSend = null;
		}
		
		if (pmlEdmLevelSend != null) {					
			row1.addText(pmlEdmLevelSend.getLevelSendName());
				} else {
			row1.addText("");
		}
		
		// Loai cong van 
		long documentTypeId = pmlEdmDocumentReceipt.getDocumentTypeId();
		PmlEdmDocumentType pmlEdmDocumentType = null;
		try {
			// Doc tu List thay cho doc database
			if (docTypeIdsMap.indexOf(documentTypeId) >= 0) {
				pmlEdmDocumentType = (PmlEdmDocumentType) docTypeFromSC.get(docTypeIdsMap.indexOf(documentTypeId));
			} // end if
		} catch (Exception e) {
			pmlEdmDocumentType = null;
		}
		
		if (pmlEdmDocumentType != null) {
			row1.addText(pmlEdmDocumentType.getDocumentTypeName());
				} else {
			row1.addText("");
		}
		
		// So cong van den
		row1.addText(pmlEdmDocumentReceipt.getNumberDocumentReceipt(), rowURL);
		
		// So hieu
		row1.addText(pmlEdmDocumentReceipt.getDocumentReference(), rowURL);
		
		// Ngay den	
		row1.addText(pmlEdmDocumentReceipt.getDateArrive() != null ? new java.text.SimpleDateFormat("dd/MM/yyyy").format(pmlEdmDocumentReceipt.getDateArrive()) : "");
		
		// Noi phat hanh
		String issuingPlaceId = pmlEdmDocumentReceipt.getIssuingPlaceId();
		
		PmlEdmIssuingPlace pmlEdmIssuingPlace = null;
		String noiPhatHanh = "";
		try {
			// Doc tu list thay cho doc database
			if (issuingPlaceIdsMap.indexOf(issuingPlaceId) >= 0) {
				pmlEdmIssuingPlace = issuingPlaceFromSC.get(issuingPlaceIdsMap.indexOf(issuingPlaceId));
			}
		} catch (Exception e) {
			pmlEdmIssuingPlace = null;
		}
		
		if (pmlEdmIssuingPlace != null) {
			noiPhatHanh = pmlEdmIssuingPlace.getIssuingPlaceName();
		} else {
			noiPhatHanh = pmlEdmDocumentReceipt.getIssuingPlaceOtherName();
		}
		
		if (pmlEdmDocumentReceipt.getDonViSaoY() != null && !pmlEdmDocumentReceipt.getDonViSaoY().equals("")) {
			noiPhatHanh += " (" + PortletProps.get("don-vi-sao-y") + ": " + pmlEdmDocumentReceipt.getDonViSaoY() + ")";
		}
		row1.addText(noiPhatHanh);
		
		// Trich yeu
		row1.addText(pmlEdmDocumentReceipt.getBriefContent());
		PmlFileStatusStateProcess fileStatusStateProcess = null;
		if (documentReceiptLog != null) {
			try {
				fileStatusStateProcess = PmlFileStatusStateProcessUtil.findByFileStatus_StateProcess(statusId, documentReceiptLog.getStateProcessIdBefore()).get(0);
			} catch (Exception e) {
				fileStatusStateProcess = null;
			}
		}
		
		// phmphuc them 12/11/2010 - yeu cau xu ly
		String processInfomation = "";
		try {
			processInfomation = resultsLog.get(i).getProcessInfomation();
		} catch (Exception e) { }
		row1.addText(processInfomation);
		// end phmphuc add 12/11/2010
		
		String procTypeDesc = ""; // Dien giai cach thuc xu ly
		if (pmlEdmDocumentReceipt.getDocumentType().trim().equals("1")) { // VB luu tham khao
			procTypeDesc = " (VB l\u01B0u tham kh\u1EA3o)";
		} // end if
		else if (pmlEdmDocumentReceipt.getDocumentType().trim().equals("2")) { // VB bao cao
			procTypeDesc = " (VB b\u00E1o c\u00E1o)";
		} // end if
		else if (pmlEdmDocumentReceipt.getDocumentType().trim().equals("3")) { // VB can soan vb tra loi
			procTypeDesc = " (VB ph\u1EA3i so\u1EA1n VB tr\u1EA3 l\u1EDDi)";
		}
		
		if (fileStatusStateProcess != null) {
			if (fileStatusStateProcess.getDescription().trim().length() > 0) {
				if (procTypeDesc.length() > 0) {
					row1.addText(fileStatusStateProcess.getDescription().trim() + "<br />" + procTypeDesc);
				} // end if
				else {
					row1.addText(fileStatusStateProcess.getDescription().trim());
				} // end else
			} // end if
			else {
				row1.addText("");
			} // end else
		} else {
			row1.addText("" + procTypeDesc);
		}
		
		// phmphuc them 01/12/2010
		// thoi han xu ly
		if (hienTrang.equals("dangXuLy")) {
			StringBuilder ngayHetHan = new StringBuilder();
			if (numberDateRemain < 0) {
				ngayHetHan.append("<span class=\"fontColorRed\"> ");
			} else {
				ngayHetHan.append("<span> ");
			}
			ngayHetHan.append(expireDateProcess);
			ngayHetHan.append(" </span>");
			
			row1.addText(ngayHetHan.toString());
		}
		// end phmphuc them 01/12/2010
	
		resultRows1.add(row1);
	}
	
	//SearchContainer searchContainer = (SearchContainer)request.getAttribute("liferay-ui:search:searchContainer");
	
	boolean paginate = true;
	int start = searchContainer.getStart();
	int end = searchContainer.getEnd();
	int total = searchContainer.getTotal();
	List resultRows = searchContainer.getResultRows();
	List<String> headerNames = searchContainer.getHeaderNames();
	Map orderableHeaders = searchContainer.getOrderableHeaders();
	String emptyResultsMessage = searchContainer.getEmptyResultsMessage();
	RowChecker rowChecker = searchContainer.getRowChecker();
	
	if (end > total) {
		end = total;
	}
	
	if (rowChecker != null) {
		if (headerNames != null) {
			headerNames.add(0, rowChecker.getAllRowsCheckBox());
		}
	}
	
	// phmphuc update 23/11/2010 - neu hien trang khong la dang xu ly thi khong cho hien thi cot thong bao flag
	if (hienTrang.equals("dangXuLy")) {
		headerNames.add("document_timeprocess");
	}
	// end phmphuc update 23/11/2010
	
	if (resultRows.isEmpty() && (headerNames == null)) {
		headerNames = new ArrayList<String>();
		headerNames.add(StringPool.BLANK);
	}
%>

<c:if test="<%= (resultRows.size() > 0) || ((resultRows.size() == 0) && (emptyResultsMessage != null)) %>">
		<c:if test="<%= paginate %>">
		
			<div  class="taglib-search-iterator-page-iterator-top">	
				<div style="display: none;">		
					<liferay-ui:search-paginator searchContainer="<%= searchContainer %>" />
				</div>	
				<%@ include file="/html/portlet/ext/pcccdocumentreceiptprocess/page_iterator/page.jsp" %>
			</div>
			
		</c:if>
	
		<div class="results-grid">
			<table class="taglib-search-iterator" cellspacing="0" width="100%">
			<tr class="portlet-section-header results-header">
	
			<%
			for (int i = 0; (headerNames != null) && (i < headerNames.size()); i++) {
				String headerName = headerNames.get(i);
	
				String orderKey = null;
				String orderByType = null;
				boolean orderCurrentHeader = false;
	
				if (orderableHeaders != null) {
					orderKey = (String)orderableHeaders.get(headerName);
	
					if (orderKey != null) {
						orderByType = searchContainer.getOrderByType();
	
						if (orderKey.equals(searchContainer.getOrderByCol())) {
							orderCurrentHeader = true;
						}
					} // end if
				}
	
				if (orderCurrentHeader) {
					if (orderByType.equals("asc")) {
						orderByType = "desc";
					} else {
						orderByType = "asc";
					}
				}
			%>
	
				<th class="col-<%= i + 1 %>"	
					<c:if test="<%= (rowChecker != null) && (headerNames.size() == 2) && (i == 1) %>">
						width="95%"
					</c:if>
				>
					
					<c:if test="<%= orderKey != null %>">
					
						<a onclick='viewListDocument("<%= 
							//minh 20100424
							//portletURLString
							//+ "&" + PcccDocumentReceiptProcessSearchDisplayTerms.CAPGUI + "=" + searchTerms.getCapgui() + "&" + PcccDocumentReceiptProcessSearchDisplayTerms.LOAISOCONGVAN + "=" + searchTerms.getLoaisocongvan()
							searchContainer.getIteratorURL().toString() + "&" + PcccDocumentReceiptProcessSearchDisplayTerms.CAPGUI + "=" + searchTerms.getCapgui() 
							+ "&" + PcccDocumentReceiptProcessSearchDisplayTerms.LOAISOCONGVAN + "=" + searchTerms.getLoaisocongvan()
							%>&<%= namespace %>orderByCol=<%= orderKey %>&<%= namespace %>orderByType=<%= orderByType %>")'>
					</c:if>
	
					<c:if test="<%= orderCurrentHeader %>">
						<i>
					</c:if>
	
					<%
					String headerNameValue = LanguageUtil.get(pageContext, headerName);
					%>
	
					<c:choose>
						<c:when test="<%= headerNameValue.equals(StringPool.BLANK) %>">
							<%= StringPool.NBSP %>
						</c:when>
						<c:otherwise>													
							<%= headerNameValue %> 	
							<%
							if ((PortletPermissionUtil.contains(permissionChecker, plid, "SGS_PCCCDOCUMENTRECEIPTPROCESS_INSTANCE_HKH8", ActionKeysExt.TIEPNHANCV) == true) ||
								(PortletPermissionUtil.contains(permissionChecker, plid, "SGS_PCCCDOCUMENTRECEIPTPROCESS_INSTANCE_HKH8", ActionKeysExt.XLTHAYBGD) == true) ||
								(PortletPermissionUtil.contains(permissionChecker, plid, "SGS_PCCCDOCUMENTRECEIPTPROCESS_INSTANCE_HKH8", ActionKeysExt.GIAMDOCREPORT) == true) ||
								(PortletPermissionUtil.contains(permissionChecker, plid, "SGS_PCCCDOCUMENTRECEIPTPROCESS_INSTANCE_HKH8", ActionKeysExt.TRUONGPHONGREPORT) == true)) {
							%>
								<c:if test="<%= i == 2 %>">
									<br/>
									<liferay-util:include page="/html/portlet/ext/pcccdocumentreceiptprocess/list_filter.jsp" />
								</c:if>
								<c:if test="<%= i == 3 %>">
									<br/>
									<liferay-util:include page="/html/portlet/ext/pcccdocumentreceiptprocess/list_filter_documentrecordtype.jsp" />
								</c:if>
							<% } else { %>
								<c:if test="<%= i == 1 %>">
									<br/>
									<liferay-util:include page="/html/portlet/ext/pcccdocumentreceiptprocess/list_filter.jsp" />
								</c:if>
								<c:if test="<%= i == 2 %>">
									<br/>
									<liferay-util:include page="/html/portlet/ext/pcccdocumentreceiptprocess/list_filter_documentrecordtype.jsp" />
								</c:if>
							<% } %>
						</c:otherwise>
					</c:choose>
					
					<c:if test="<%= orderCurrentHeader %>">
						</i>
					</c:if>
	
					<c:if test="<%= orderKey != null %>">
						</a>
					</c:if>
				</th>
	
			<%
			}
			%>
	
			</tr>
	
			<c:if test="<%= (resultRows.size() == 0) && (emptyResultsMessage != null) %>">
				<tr class="portlet-section-body results-row">
					<td align="center" colspan="<%= headerNames.size() %>">
						<%= LanguageUtil.get(pageContext, emptyResultsMessage) %>
					</td>
				</tr>
			</c:if>
	
			<%
			boolean allRowsIsChecked = true;
	
			for (int i = 0; i < resultRows.size(); i++) {
				ResultRow row = (ResultRow)resultRows.get(i);
	
				String className = "portlet-section-alternate results-row alt";
				String classHoverName = "portlet-section-alternate-hover results-row alt hover";
	
				if (MathUtil.isEven(i)) {
					className = "portlet-section-body results-row";
					classHoverName = "portlet-section-body-hover results-row hover";
				}
	
				if (Validator.isNotNull(row.getClassName())) {
					className += " " + row.getClassName();
				}
	
				if (Validator.isNotNull(row.getClassHoverName())) {
					classHoverName += " " + row.getClassHoverName();
				}
	
				if (row.isRestricted()) {
					className += " restricted";
					classHoverName += " restricted";
				}
	
				row.setClassName(className);
				row.setClassHoverName(classHoverName);
	
				request.setAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW, row);
	
				List entries = row.getEntries();
	
				if (rowChecker != null) {
					boolean rowIsChecked = rowChecker.isChecked(row.getObject());
	
					if (!rowIsChecked) {
						allRowsIsChecked = false;
					}
	
					row.addText(0, rowChecker.getAlign(), rowChecker.getValign(), rowChecker.getColspan(), rowChecker.getRowCheckBox(rowIsChecked, row.getPrimaryKey()));
				}
			%>
	
				<tr class="<%= className %>"
					onmouseover="onMouseOverTr(this);" onmouseout="onMouseOutTr(this);"
				>
	
				<%
				for (int j = 0; j < entries.size(); j++) {
					SearchEntry entry = (SearchEntry)entries.get(j);
	
					entry.setIndex(j);
	
					request.setAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW_ENTRY, entry);
				%>
	
					<td align="<%= entry.getAlign() %>" class="col-<%= j + 1 %><%= row.isBold() ? " taglib-search-iterator-highlighted" : "" %>" colspan="<%= entry.getColspan() %>" valign="<%= entry.getValign() %>">
						<% entry.print(pageContext);%>
					</td>
				<%
				}
				%>
				</tr>
	
			<%
			}
			%>
	
			</table>
		</div>
	
		<c:if test="<%= (resultRows.size() > 10) && paginate %>">
			<div class="taglib-search-iterator-page-iterator-bottom">
				<div style="display: none;">			
					<liferay-ui:search-paginator searchContainer="<%= searchContainer %>" />
				</div>	
				<%@ include file="/html/portlet/ext/pcccdocumentreceiptprocess/page_iterator/page.jsp" %>
			</div>
		</c:if>
	
		<c:if test="<%= (rowChecker != null) && (resultRows.size() > 0) && Validator.isNotNull(rowChecker.getAllRowsId()) && allRowsIsChecked %>">
			<script type="text/javascript">
				document.<%= rowChecker.getFormName() %>.<%= rowChecker.getAllRowsId() %>.checked = true;
			</script>
		</c:if>
	</c:if>
</div>
<%
	int capGuiId = ((PcccDocumentReceiptProcessSearchDisplayTerms) searchContainer.getDisplayTerms()).getCapgui();
	int loaiSoCongVanId = ((PcccDocumentReceiptProcessSearchDisplayTerms) searchContainer.getDisplayTerms()).getLoaisocongvan();
	
	String paramReport = "word&".concat(renderResponse.getNamespace()).
		concat(PcccDocumentReceiptProcessSearchDisplayTerms.CAPGUI).
		concat("=").
		concat(String.valueOf(capGuiId)).
		concat("&").
		concat(renderResponse.getNamespace()).
		concat(PcccDocumentReceiptProcessSearchDisplayTerms.LOAISOCONGVAN).
		concat("=").concat(String.valueOf(loaiSoCongVanId));
	
	PortletURL inPhieuChuyenURL = renderResponse.createRenderURL();
	inPhieuChuyenURL.setWindowState(LiferayWindowState.POP_UP);
//	inPhieuChuyenURL.setParameter("struts_action", "/sgs/pcccdocumentreceiptprocess/inphieuchuyen");
	inPhieuChuyenURL.setParameter("struts_action", "/sgs/pcccdocumentreceiptprocess/indsphieuchuyen");
	
%>
<div align="right" id="table-button">
	<%
		if ((PortletPermissionUtil.contains(permissionChecker, plid, "SGS_PCCCDOCUMENTRECEIPTPROCESS_INSTANCE_HKH8", ActionKeysExt.TIEPNHANCV) == true) ||
			(PortletPermissionUtil.contains(permissionChecker, plid, "SGS_PCCCDOCUMENTRECEIPTPROCESS_INSTANCE_HKH8", ActionKeysExt.XLTHAYBGD) == true) ||
			(PortletPermissionUtil.contains(permissionChecker, plid, "SGS_PCCCDOCUMENTRECEIPTPROCESS_INSTANCE_HKH8", ActionKeysExt.GIAMDOCREPORT) == true) ||
			(PortletPermissionUtil.contains(permissionChecker, plid, "SGS_PCCCDOCUMENTRECEIPTPROCESS_INSTANCE_HKH8", ActionKeysExt.TRUONGPHONGREPORT) == true)) {
	%>
			
		<input type="button" class="button-width" value='<liferay-ui:message key="in-phieu-chuyen"/>' 
				onclick="<portlet:namespace />inDSPhieuChuyen('<%= inPhieuChuyenURL.toString() %>');"/>
	<%
		}
		if ("CVDEN_VANTHU_DANGXULY_CHUNG_vuatiepnhan".equalsIgnoreCase(fileStatusCode)) {
			PortletURL transCVP = renderResponse.createRenderURL();
			transCVP.setWindowState(LiferayWindowState.NORMAL);
			transCVP.setParameter("struts_action", "/sgs/pcccdocumentreceiptprocess/transcvp");
			transCVP.setParameter("redirect", portletURLRedirect.toString());
			transCVP.setParameter("dsVBDen", "true");
	%>
			<input type="button" class="button-width" value='<liferay-ui:message key="chuyenchanhvanphong"/>' 
					onclick="<portlet:namespace />addTransFrom('<%= transCVP.toString() %>');"/>
	<%
		}
	%>
	<input type="button" value='<liferay-ui:message key="print"/>' onclick="<portlet:namespace />addReportActionFrom('<%= paramReport %>');"/>
</div>