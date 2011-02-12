<%@ include file="/html/portlet/ext/pcccdocumentreceiptprocess/init.jsp" %>
<%@ include file="/html/portlet/ext/pcccdocumentreceiptprocess/page_iterator/init_search.jsp" %>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="javax.portlet.PortletSession"%>
<%@page import="com.sgs.portlet.document.model.PmlDocumentReceiptLog"%>
<%@page import="com.sgs.portlet.document.service.persistence.PmlDocumentReceiptLogUtil"%>
<%@page import="com.sgs.portlet.document.model.impl.PmlDocumentReceiptLogImpl"%><liferay-util:include page="/html/portlet/ext/pcccdocumentreceiptprocess/js/quanlycongvan.jsp"></liferay-util:include>
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
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.liferay.portal.service.UserLocalServiceUtil"%><div style="display: inherit;"> 
<script type='text/javascript' src='/html/js/liferay/tr.js'></script>
<%
	//yenlt update 20101022
	boolean timkiemtheotieuchi = ParamUtil.getBoolean(renderRequest, "timkiemtheotieuchi", false);
	String soVanBanDen = ParamUtil.getString(renderRequest, "sovanbanden" , "");
	String soHieuGoc = ParamUtil.getString(renderRequest, "sohieugoc", "");
	int loaiSoVB = ParamUtil.getInteger(renderRequest, "loaisocongvan", 0);
	String issuingplaceId = ParamUtil.getString(renderRequest, "issuingplaceId", "");
	String noiphathanh = ParamUtil.getString(renderRequest, "noiphathanh", "");
	String trichyeu = ParamUtil.getString(renderRequest, "trichyeu", "");
	
	String tuNgay = ParamUtil.getString(renderRequest, "tungay", "");
	String denNgay = ParamUtil.getString(renderRequest, "dengay", "");
	
	List<PmlEdmDocumentReceipt> results = renderRequest.getAttribute("results") == null ? new ArrayList<PmlEdmDocumentReceipt>()
			: (List<PmlEdmDocumentReceipt>)renderRequest.getAttribute("results");
	int total1 = (Integer)renderRequest.getAttribute("total1") == null ? 0 : (Integer)renderRequest.getAttribute("total1");

	// end yenlt update 20101022
	
	// phmphuc them 12/11/2010 - lay danh sach log tuong ung voi receipt
	List<PmlDocumentReceiptLog> resultsLog = renderRequest.getAttribute("resultLogs") == null ? new ArrayList<PmlDocumentReceiptLog>()
			: (List<PmlDocumentReceiptLog>)renderRequest.getAttribute("resultLogs");
	// end phmphuc update 12/11/2010

	long userIdXLT = renderRequest.getAttribute("userIdXLT") == null ? 0 : (Long) renderRequest.getAttribute("userIdXLT");
	long statusId = renderRequest.getAttribute("statusId") == null ? 0 : (Long) renderRequest.getAttribute("statusId");
	boolean vtxulythayldb = renderRequest.getAttribute("vtxulythayldb") == null ? false : (Boolean) renderRequest.getAttribute("vtxulythayldb");
	boolean vtxulythayldvp = renderRequest.getAttribute("vtxulythayldvp") == null ? false : (Boolean) renderRequest.getAttribute("vtxulythayldvp");
	
	String surrogateprocess = ParamUtil.getString(renderRequest, "surrogateprocess");
	String backURL = ParamUtil.getString(renderRequest, "backtolist");
	
	PortletURL portletURLRedirect = renderResponse.createRenderURL();
	portletURLRedirect.setWindowState(LiferayWindowState.NORMAL);
	portletURLRedirect.setParameter("struts_action", "/sgs/pcccdocumentreceiptprocess/viewxlt");
	portletURLRedirect.setParameter("vtxulythayldb", String.valueOf(vtxulythayldb));
	portletURLRedirect.setParameter("vtxulythayldvp", String.valueOf(vtxulythayldvp));
	portletURLRedirect.setParameter("statusId", String.valueOf(statusId));
	portletURLRedirect.setParameter("userIdXLT", String.valueOf(userIdXLT));
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
	// end yenlt update 20101022
	
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(LiferayWindowState.EXCLUSIVE);	
	portletURL.setParameter("struts_action", "/sgs/pcccdocumentreceiptprocess/xulythayld");
	portletURL.setParameter("statusId", String.valueOf(statusId));
	portletURL.setParameter("userIdXLT", String.valueOf(userIdXLT));
	if (vtxulythayldb) {
		portletURL.setParameter("vtxulythayldb",  String.valueOf(vtxulythayldb));
	}
	
	if (vtxulythayldvp) {
		portletURL.setParameter("vtxulythayldvp",  String.valueOf(vtxulythayldvp));
	}
	
	
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
	
%>

<%
	/* yenlt close 20101022
	PcccDocumentReceiptProcessSearch searchContainerList = new PcccDocumentReceiptProcessSearch(renderRequest, portletURL);
	List<String> headerNames1 = searchContainerList.getHeaderNames();
	PcccDocumentReceiptProcessSearchTerms searchTerms = (PcccDocumentReceiptProcessSearchTerms) searchContainerList.getSearchTerms();
	List<Long> listXLT = new ArrayList<Long>();
	listXLT.add(userIdXLT);
	
	int total1 = 0;
	List<PmlEdmDocumentReceipt> results = null;

	// Lay tong so cong van
	total1 = PmlEdmDocumentReceiptLocalServiceUtil.countByDocumentReceipt_Users(listXLT,  String.valueOf(searchTerms.getCapgui()), String.valueOf(searchTerms.getLoaisocongvan())); 

	// Lay danh sach doi tuong PmlEdmDocumentReceipt
	results = PmlEdmDocumentReceiptLocalServiceUtil.findByDocumentReceipt_Users(listXLT, String.valueOf(searchTerms.getCapgui()), String.valueOf(searchTerms.getLoaisocongvan()),
				searchContainerList.getStart(), searchContainerList.getEnd(), searchContainerList.getOrderByComparator());

	searchContainerList.setTotal(total1);
	portletURL.setParameter(searchContainerList.getCurParam(), String.valueOf(searchContainerList.getCurValue()));
	yenlt close 20101022 */
%>	
	<input type="hidden" name="<portlet:namespace />timkiemtheotieuchi" value="<%= String.valueOf(timkiemtheotieuchi) %>">
<%		
	List resultRows1 = searchContainer.getResultRows();
	
	for (int i = 0; i < results.size(); i ++) {
		PmlEdmDocumentReceipt pmlEdmDocumentReceipt = (PmlEdmDocumentReceipt) results.get(i);
		
		ResultRow row1 = new ResultRow(pmlEdmDocumentReceipt, pmlEdmDocumentReceipt.getDocumentReceiptId(), i);		
		// minh update 20100323
		//String stateProcess = "";		
		PmlDocumentReceiptLog documentReceiptLog = null;
		try {
			documentReceiptLog =  PmlDocumentReceiptLogUtil.findByDocumentReceiptId_Processor_Receivedate_StateProcessIdAfter(
					pmlEdmDocumentReceipt.getDocumentReceiptId(), userIdXLT , null , 0).get(0);
			//stateProcess = new DocumentReceiptLiferayWorkflowService().getCurrentStateOfDocumentReceipt(pmlEdmDocumentReceipt.getDocumentReceiptId(), listXLT.get(0)); 
		} catch (Exception e) {
			// xuancong close vi bao loi index out of range
			//documentReceiptLog =  PmlDocumentReceiptLogUtil.findByDocumentReceiptId_Processor_StateProcessIdAfter(
			//		pmlEdmDocumentReceipt.getDocumentReceiptId(), userIdXLT , 0).get(0);
			List<PmlDocumentReceiptLog> lstDocRecExc = PmlDocumentReceiptLogUtil.findByDocumentReceiptId_Processor_StateProcessIdAfter(
					pmlEdmDocumentReceipt.getDocumentReceiptId(), userIdXLT , 0);
			if (!lstDocRecExc.isEmpty()) {
				documentReceiptLog = (PmlDocumentReceiptLog) lstDocRecExc.get(0);
			} // end if
		}
		// end minh update 20100323
		
//		PortletURL rowURL = new PortletURLImpl(request, "SGS_PCCCDOCUMENTRECEIPTPROCESS_INSTANCE_56nj", 33008, PortletRequest.RENDER_PHASE);
		PortletURL rowURL = new PortletURLImpl(request, "SGS_PCCCDOCUMENTRECEIPTPROCESS_INSTANCE_HKH8", 89385, PortletRequest.RENDER_PHASE);//  yenlt close & update 20101022
		rowURL.setWindowState(WindowState.NORMAL);
		rowURL.setParameter("struts_action", "/sgs/pcccdocumentreceiptprocess/detail");
		rowURL.setParameter("redirect", portletURLRedirect.toString());
		if (vtxulythayldb) {
			rowURL.setParameter("vtxulythayldb",  String.valueOf(vtxulythayldb));
		}
		
		if (vtxulythayldvp) {
			rowURL.setParameter("vtxulythayldvp",  String.valueOf(vtxulythayldvp));
		}
		
		rowURL.setParameter("statusId", String.valueOf(statusId));
		
		rowURL.setParameter("documentReceiptId", String.valueOf(pmlEdmDocumentReceipt.getDocumentReceiptId()));
		rowURL.setParameter(com.sgs.liferay.jbpm.util.Constants.WORKFLOW_RENDER, "true");				
		rowURL.setParameter("userIdXLT", String.valueOf(userIdXLT));
		// minh update 20100323
		//rowURL.setParameter("stateProcessId", String.valueOf(stateProcess));
		//xuancong close vi co truong hop documentReceiptLog null rowURL.setParameter("stateProcessId", String.valueOf(documentReceiptLog.getStateProcessIdBefore()));
		if (documentReceiptLog != null) {
		rowURL.setParameter("stateProcessId", String.valueOf(documentReceiptLog.getStateProcessIdBefore()));
		} // end if
		else {
			rowURL.setParameter("stateProcessId", "0");
		}
		// end minh update 20100323
		
		// phmphuc update 08/12/2010 - hien thi co cho xu ly thay
		List<PmlDocumentReceiptLog> pmlDocumentReceiptLogList = null;
		String expireDateProcess = "";
		long numberDateRemain = 1000;
		StringBuilder icon = new StringBuilder();
		try {
			// pmlDocumentReceiptLogList = PmlDocumentReceiptLogUtil.findByDocumentReceiptId(pmlEdmDocumentReceipt.getDocumentReceiptId());
			pmlDocumentReceiptLogList = PmlDocumentReceiptLogUtil.findByDocumentReceiptId_Receiver(pmlEdmDocumentReceipt.getDocumentReceiptId(), userIdXLT);
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
		// end phmphuc update 08/12/2010
		
		// STT
		row1.addText((i+1) + ". " + icon.toString());
		
		// Cap gui
		int levelSendId = pmlEdmDocumentReceipt.getLevelSendId();
		PmlEdmLevelSend pmlEdmLevelSend = null;
		
		try {
			pmlEdmLevelSend = PmlEdmLevelSendUtil.findByPrimaryKey(levelSendId);
		} catch (Exception e) {
			pmlEdmLevelSend = null;
		}
		
		if (pmlEdmLevelSend != null) {					
			row1.addText(pmlEdmLevelSend.getLevelSendName());
		}
		else {
			row1.addText("");
		}
		
		// Loai cong van 
		long documentTypeId = pmlEdmDocumentReceipt.getDocumentTypeId();
		
		PmlEdmDocumentType pmlEdmDocumentType = null;
		
		try {
			pmlEdmDocumentType = PmlEdmDocumentTypeUtil.findByPrimaryKey(documentTypeId) ;
		} catch (Exception e) {
			pmlEdmDocumentType = null;
		}
		
		if (pmlEdmDocumentType != null) {
			row1.addText(pmlEdmDocumentType.getDocumentTypeName());
		}
		else {
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
		
		try {
			pmlEdmIssuingPlace = PmlEdmIssuingPlaceUtil.findByPrimaryKey(issuingPlaceId);
		} catch (Exception e) {
			pmlEdmIssuingPlace = null;
		}
		
		if (pmlEdmIssuingPlace != null) {
			row1.addText(pmlEdmIssuingPlace.getIssuingPlaceName());
		}
		else {
			row1.addText(pmlEdmDocumentReceipt.getIssuingPlaceOtherName());					
		}
		
		// Trich yeu
		row1.addText(pmlEdmDocumentReceipt.getBriefContent());
		
		// phmphuc them 12/11/2010 - yeu cau xu ly
		String processInfomation = "";
		try {
			processInfomation = resultsLog.get(i).getProcessInfomation();
		} catch (Exception e) { }
		row1.addText(processInfomation);
		// end phmphuc add 12/11/2010
		
		// Trang thai
		// minh update 20100324
		//PmlStateProcess pmlStateProcess = null;
		
		//try {
		//	pmlStateProcess = PmlStateProcessUtil.findByStateProcessCode(stateProcess).get(0);
		//} catch (Exception e) {
		//	pmlStateProcess = null; 
		//}
	
		PmlFileStatusStateProcess fileStatusStateProcess = null;
		
		//if (pmlStateProcess != null) {
		if (documentReceiptLog != null) {
			try {
				//fileStatusStateProcess = PmlFileStatusStateProcessUtil.findByFileStatus_StateProcess(statusId, pmlStateProcess.getStateProcessId()).get(0);
				fileStatusStateProcess = PmlFileStatusStateProcessUtil.findByFileStatus_StateProcess(statusId, documentReceiptLog.getStateProcessIdBefore()).get(0);
			} catch (Exception e) {
				fileStatusStateProcess = null;
			}
		}
		// end minh update 20100324
		// xuancong add start, them cach thuc xu ly vao phia duoi trang thai theo dang (cachthucxuly)
		String procTypeDesc = ""; // Dien giai cach thuc xu ly
		if (pmlEdmDocumentReceipt.getDocumentType().trim().equals("1")) { // VB luu tham khao
			procTypeDesc = "(VB l\u01B0u tham kh\u1EA3o)";
		} // end if
		else if (pmlEdmDocumentReceipt.getDocumentType().trim().equals("2")) { // VB bao cao
			procTypeDesc = "(VB b\u00E1o c\u00E1o)";
		} // end if
		else if (pmlEdmDocumentReceipt.getDocumentType().trim().equals("3")) { // VB can soan vb tra loi
			procTypeDesc = "(VB ph\u1EA3i so\u1EA1n VB tr\u1EA3 l\u1EDDi)";
		}

		if (fileStatusStateProcess != null) {
			//xuancong close row1.addText(fileStatusStateProcess.getDescription() );
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
		} 
		else {
			// xuancong close row1.addText("");
			row1.addText("" + procTypeDesc);
		}
		
		// phmphuc them 08/12/2010
		// thoi han xu ly
		StringBuilder ngayHetHan = new StringBuilder();
		if (numberDateRemain < 0) {
			ngayHetHan.append("<span class=\"fontColorRed\"> ");
		} else {
			ngayHetHan.append("<span> ");
		}
		ngayHetHan.append(expireDateProcess);
		ngayHetHan.append(" </span>");
		
		row1.addText(ngayHetHan.toString());
		// end phmphuc them 08/12/2010
	
		resultRows1.add(row1);
	}
	
%>	

<%
	//SearchContainer searchContainer = (SearchContainer)request.getAttribute("liferay-ui:search:searchContainer"); // yenlt close 20101022
	
	//boolean paginate = GetterUtil.getBoolean((String)request.getAttribute("liferay-ui:search-iterator:paginate"));
	boolean paginate = true;
	int start = searchContainer.getStart();
	int end = searchContainer.getEnd();
	int total = searchContainer.getTotal();
	List resultRows = searchContainer.getResultRows();
	List<String> headerNames = searchContainer.getHeaderNames();
	Map orderableHeaders = searchContainer.getOrderableHeaders();
	String emptyResultsMessage = searchContainer.getEmptyResultsMessage();
	RowChecker rowChecker = searchContainer.getRowChecker();
	
	headerNames.add("document_timeprocess");
	
	if (end > total) {
		end = total;
	}
	
	if (rowChecker != null) {
		if (headerNames != null) {
			headerNames.add(0, rowChecker.getAllRowsCheckBox());
		}
	}
	
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
					}
				}
	
				if (orderCurrentHeader) {
					if (orderByType.equals("asc")) {
						orderByType = "desc";
					}
					else {
						orderByType = "asc";
					}
				}
			%>
	
				<td class="col-<%= i + 1 %>"	
					<c:if test="<%= (rowChecker != null) && (headerNames.size() == 2) && (i == 1) %>">
						width="95%"
					</c:if>
				>
					
					<c:if test="<%= orderKey != null %>">
					
						<a onclick='viewListDocumentXLT("<%= portletURLString + "&" + PcccDocumentReceiptProcessSearchDisplayTerms.CAPGUI + "=" + searchTerms.getCapgui() + "&" + PcccDocumentReceiptProcessSearchDisplayTerms.LOAISOCONGVAN + "=" + searchTerms.getLoaisocongvan()%>&<%= namespace %>orderByCol=<%= orderKey %>&<%= namespace %>orderByType=<%= orderByType %>")'>
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
							<c:if test="<%= i== 1 %>">
								<br/>
								<liferay-util:include page="/html/portlet/ext/pcccdocumentreceiptprocess/list_filter.jsp" />
							</c:if>
								
							<c:if test="<%= i== 2 %>">
								<br/>
								<liferay-util:include page="/html/portlet/ext/pcccdocumentreceiptprocess/list_filter_documentrecordtype.jsp" />
							</c:if>
						</c:otherwise>
					</c:choose>
					
					
							
					<c:if test="<%= orderCurrentHeader %>">
						</i>
					</c:if>
	
					<c:if test="<%= orderKey != null %>">
						</a>
					</c:if>
				</td>
	
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
					onmouseover='onMouseOverTr(this);' onmouseout='onMouseOutTr(this);'
					<c:if test="<%= searchContainer.isHover() %>">
						onmouseover="this.className = '<%= classHoverName %>';" onmouseout="this.className = '<%= className %>';"
					</c:if>
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
