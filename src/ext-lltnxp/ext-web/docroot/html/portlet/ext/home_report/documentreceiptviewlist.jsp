<%@page import="java.util.Map"%>
<%@page import="com.liferay.portal.kernel.dao.search.RowChecker"%>
<%@ include file="/html/portlet/ext/home_report/init.jsp" %>
<%@ include file="/html/portlet/ext/home_report/page_iterator/init_search.jsp" %>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@page import="com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt"%>
<%@page import="com.sgs.portlet.document.receipt.service.PmlEdmDocumentReceiptLocalServiceUtil"%>
<%@page import="com.sgs.portlet.pmllevelsend.model.PmlEdmLevelSend"%>
<%@page import="com.sgs.portlet.pmllevelsend.service.PmlEdmLevelSendLocalServiceUtil"%>
<%@page import="com.sgs.portlet.document.receipt.model.PmlEdmDocumentType"%>
<%@page import="com.sgs.portlet.document.receipt.service.PmlEdmDocumentTypeLocalServiceUtil"%>
<%@page import="com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace"%>
<%@page import="com.sgs.portlet.pmlissuingplace.service.PmlEdmIssuingPlaceLocalServiceUtil"%>
<%@page import="com.ext.portlet.processtype.model.ProcessType"%>
<%@page import="com.ext.portlet.processtype.service.ProcessTypeLocalServiceUtil"%>
<%@page import="com.sgs.portlet.document.model.PmlDocumentReceiptLog"%>
<%@page import="com.sgs.portlet.document.service.persistence.PmlDocumentReceiptLogUtil"%>
<%@page import="com.sgs.portlet.pmluser.model.PmlUser"%>
<%@page import="com.sgs.portlet.pmluser.service.PmlUserLocalServiceUtil"%>
<liferay-util:include page="/html/portlet/ext/home_report/js/quanlyvanban_report.jsp"></liferay-util:include>
<script type='text/javascript' src='/html/js/liferay/tr.js'></script>

<%
	String departmentId = ParamUtil.getString(renderRequest, "departmentId");
	long userId = ParamUtil.getLong(renderRequest, "userId");
	
	String loaiThongKe = ParamUtil.getString(renderRequest, "loaiThongKe");
	String from_Date = ParamUtil.getString(renderRequest, "fromDate");
	String to_Date = ParamUtil.getString(renderRequest, "toDate");	
	
	Date fromDate = null;
	Date toDate = null;
	SimpleDateFormat dmy =  new SimpleDateFormat("dd/MM/yyyy");
	
	if (!"".equals(from_Date) || !"".equals(to_Date)) {
		fromDate = dmy.parse(from_Date);
		toDate = dmy.parse(to_Date);
		
	} else {
		fromDate = dmy.parse(dmy.format(new Date()));
		toDate = dmy.parse(dmy.format(new Date()));
	}
	
	String action = ParamUtil.getString(renderRequest, "action");
	String rowSelect = ParamUtil.getString(renderRequest, "row");
	
	String tenChuyenVien = (renderRequest.getAttribute("tenChuyenVien") == null) ? "" : (String) renderRequest.getAttribute("tenChuyenVien");
	tenChuyenVien = tenChuyenVien.replaceAll("CV:", "Ng\u01B0\u1EDDi x\u1EED l\u00FD:");
	String tenAction = (renderRequest.getAttribute("tenAction") == null) ? "" : (String) renderRequest.getAttribute("tenAction");
	tenAction = tenAction.toLowerCase();
%>

<portlet:actionURL var="baoCaoDetail">
	<portlet:param name="struts_action" value="/sgs/home_report/documentreceiptviewlist" />
</portlet:actionURL>

<div id="<portlet:namespace/>listdocument" class="listdocument-cv" >	

<div class="title_categ"><liferay-ui:message key="tinhhinhthulycongvan.title" /></div>
<div class="boxcontent documentreceiptviewlist">

<form action="<%= baoCaoDetail %>" name="<portlet:namespace />frm" id="<portlet:namespace/>fm" method="post">			
<fieldset>

<%
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(LiferayWindowState.EXCLUSIVE);	
	portletURL.setParameter("struts_action", "/sgs/home_report/documentreceiptviewlist");
	portletURL.setParameter(DocumentReceiptViewListDisplayTerms.DEPARTMENTID, departmentId);
	portletURL.setParameter(DocumentReceiptViewListDisplayTerms.USERID, String.valueOf(userId));
	portletURL.setParameter(DocumentReceiptViewListDisplayTerms.LOAITHONGKE , loaiThongKe);
	portletURL.setParameter(DocumentReceiptViewListDisplayTerms.FROMDATE, from_Date);
	portletURL.setParameter(DocumentReceiptViewListDisplayTerms.TODATE, to_Date);	
	portletURL.setParameter("action", action);	
	portletURL.setParameter("row", String.valueOf(rowSelect));	
	
	pageContext.setAttribute("portletURL", portletURL);
	String portletURLString = portletURL.toString();
	request.setAttribute("view.jsp-portletURL", portletURL);
	request.setAttribute("view.jsp-portletURLString", portletURLString);
	
	DocumentReceiptViewListSearch searchContainerList = new DocumentReceiptViewListSearch(renderRequest, portletURL);
	DocumentReceiptViewListSearchTerms searchTerms = (DocumentReceiptViewListSearchTerms)searchContainerList.getSearchTerms();
	
	List<String> headerNames1 = searchContainerList.getHeaderNames();
%>

<!-- tieu de danh sach van ban duoc chon  -->
<div class="contain-title-report">
	<h2 class="report-title-HS"><liferay-ui:message key="report-danhsachvanbanden" /> <%= tenAction %></h2>
	<h4 class="description-report-title"><%= tenChuyenVien %></h4>
	<h5>(<liferay-ui:message key="tinhhinhthulycongvan.tungay" /> <%= from_Date %> <liferay-ui:message key="tinhhinhthulycongvan.denngay" /> <%= to_Date %>)</h5>
</div>
<!-- end -->

<div style="display: none;">
	<liferay-ui:search-form	page="/html/portlet/ext/home_report/list_filter_documentrecordtype.jsp" searchContainer="<%= searchContainerList %>" >
	</liferay-ui:search-form>
</div>

<%
	List<PmlEdmDocumentReceipt> list = new ArrayList<PmlEdmDocumentReceipt>();
	int total1 = 0;
	long userSelect = Long.parseLong(rowSelect);
	
	if (action.equals("tonthangtruoc")) {
		list = PmlEdmDocumentReceiptLocalServiceUtil.listTonDauKyChuyenVien_CVDen
						(userSelect, 0, searchTerms.getCapgui(), searchTerms.getLoaisocongvan(), "", fromDate, toDate, 
						searchContainerList.getStart(), searchContainerList.getEnd(), searchContainerList.getOrderByComparator());
		total1 = PmlEdmDocumentReceiptLocalServiceUtil.countTonDauKyChuyenVien_CVDen
						(userSelect, 0, searchTerms.getCapgui(), searchTerms.getLoaisocongvan(), "", fromDate, toDate);
	} 
	else if (action.equals("nhantrongthang")) {
		list = PmlEdmDocumentReceiptLocalServiceUtil.listNhanTrongThangChuyenVien_CVDen
						(userSelect, 0, searchTerms.getCapgui(), searchTerms.getLoaisocongvan(), fromDate, toDate, 
						searchContainerList.getStart(), searchContainerList.getEnd(), searchContainerList.getOrderByComparator());
		total1 = PmlEdmDocumentReceiptLocalServiceUtil.countNhanTrongThangChuyenVien_CVDen
						(userSelect, 0, searchTerms.getCapgui(), searchTerms.getLoaisocongvan(), fromDate, toDate);
	} 
	else if (action.equals("daxuly")) {
		list = PmlEdmDocumentReceiptLocalServiceUtil.listTongDaXuLyChuyenVien_CVDen
						(userSelect, 0, searchTerms.getCapgui(), searchTerms.getLoaisocongvan(), "", fromDate, toDate, 
						searchContainerList.getStart(), searchContainerList.getEnd(), searchContainerList.getOrderByComparator());
		total1 = PmlEdmDocumentReceiptLocalServiceUtil.countTongDaXuLyChuyenVien_CVDen
						(userSelect, 0, searchTerms.getCapgui(), searchTerms.getLoaisocongvan(), "", fromDate, toDate);
	} 
	else if (action.equals("conton")) {
		list = PmlEdmDocumentReceiptLocalServiceUtil.listTongDangXuLyChuyenVien_CVDen
						(userSelect, 0, searchTerms.getCapgui(), searchTerms.getLoaisocongvan(), "", fromDate, toDate, 
						searchContainerList.getStart(), searchContainerList.getEnd(), searchContainerList.getOrderByComparator());
		total1 = PmlEdmDocumentReceiptLocalServiceUtil.countTongDangXuLyChuyenVien_CVDen
						(userSelect, 0, searchTerms.getCapgui(), searchTerms.getLoaisocongvan(), "", fromDate, toDate);
	} 
			
	searchContainerList.setTotal(total1);
	portletURL.setParameter(searchContainerList.getCurParam(), String.valueOf(searchContainerList.getCurValue()));
 	
	List resultRows1 = searchContainerList.getResultRows();
	ResultRow row1 = null;
	
	PmlEdmDocumentReceipt documentReceipt = null;
	long documentReceiptId = 0;
	
	PmlEdmLevelSend levelSend = null;
	PmlEdmDocumentType documentType = null;
	PmlEdmIssuingPlace issuingPlace = null;
	
	List<ProcessType> listProcessType = new ArrayList<ProcessType>();
	List<PmlDocumentReceiptLog> listLog = new ArrayList<PmlDocumentReceiptLog>();
	PmlDocumentReceiptLog documentReceiptLog = null;

	for (int i = 0; i < list.size(); i ++) {
		
		String cachThucXuLy = "";
		long pmlUserId = 0;
		String userXuLy = "";
		
		documentReceipt = (PmlEdmDocumentReceipt)list.get(i);
		documentReceiptId = documentReceipt.getDocumentReceiptId();
		
		PortletURL details = renderResponse.createRenderURL();
		details.setWindowState(LiferayWindowState.NORMAL);	
		details.setParameter("struts_action", "/sgs/home_report/receiptdetail");
		details.setParameter("documentReceiptId", String.valueOf(documentReceiptId));
		searchContainerList.getIteratorURL().setWindowState(LiferayWindowState.NORMAL);
		details.setParameter("redirectDetail", searchContainerList.getIteratorURL().toString());
		
		row1 = new ResultRow(documentReceipt, documentReceiptId, i);
		// STT
		row1.addText((i+1) + ".");
		
		// cap gui
		try {
			levelSend = PmlEdmLevelSendLocalServiceUtil.getPmlEdmLevelSend(documentReceipt.getLevelSendId());
		} catch (Exception e) {}
		if (levelSend != null) {
			row1.addText(levelSend.getLevelSendName());
		} else {
			row1.addText("");
		}
		
		// loai cong van
		try {
			documentType = PmlEdmDocumentTypeLocalServiceUtil.getPmlEdmDocumentType(documentReceipt.getDocumentTypeId());
			row1.addText(documentType.getDocumentTypeName());
		} catch (Exception e) {
			row1.addText("");
		}
		
		// so van ban den
		row1.addText(documentReceipt.getNumberDocumentReceipt(), details);
		
		// so hieu
		row1.addText(documentReceipt.getDocumentReference(), details);
		
		// ngay den
		if (documentReceipt.getDateArrive() != null) {
			row1.addText(dmy.format(documentReceipt.getDateArrive()), details);
		}
		else {
			row1.addText("");
		}
		
		// noi phat hanh
		try {
			issuingPlace = PmlEdmIssuingPlaceLocalServiceUtil.getPmlEdmIssuingPlace(documentReceipt.getIssuingPlaceId());
			row1.addText(issuingPlace.getIssuingPlaceName());
		} catch (Exception e ) {
			row1.addText(documentReceipt.getIssuingPlaceOtherName());
		}
		
		// trich yeu
		row1.addText(documentReceipt.getBriefContent());
		
		// cach thuc xu ly
		try {
			listProcessType = ProcessTypeLocalServiceUtil.getListProcessType(documentReceiptId);
			for (int j = 0; j < listProcessType.size(); j ++) {
				cachThucXuLy = listProcessType.get(j).getName() + "<br />";
			}
		} catch (Exception e) { }
		row1.addText(cachThucXuLy);
		
		// chuyen vien dang xu ly van ban
		try {
			listLog = PmlDocumentReceiptLogUtil.findByDocumentReceiptId(documentReceiptId);
			for (int j = 0; j < listLog.size(); j ++) {
				documentReceiptLog = listLog.get(j);
				if (documentReceiptLog.getDateProcess() == null) {
					pmlUserId = documentReceiptLog.getProcesser();
					try {
						userXuLy += "- " + HomeReportDWRUtil.getFullName(pmlUserId) + "<br/>";
					} catch (Exception e1) { }
				}
			}
		} catch (Exception e) { }
		row1.addText(userXuLy);
		
		resultRows1.add(row1);
	}
	
	SearchContainer searchContainer = (SearchContainer)request.getAttribute("liferay-ui:search:searchContainer");
	
	boolean paginate = true;
	int start = searchContainer.getStart();
	int end = searchContainer.getEnd();
	int total = searchContainer.getTotal();
	List resultRows = searchContainer.getResultRows();
	List<String> headerNames = searchContainer.getHeaderNames();
	Map orderableHeaders = searchContainer.getOrderableHeaders();
	String emptyResultsMessage = searchContainer.getEmptyResultsMessage();
	RowChecker rowChecker = searchContainer.getRowChecker();
	searchContainer.getIteratorURL().setWindowState(LiferayWindowState.EXCLUSIVE);
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
				<%@ include file="/html/portlet/ext/home_report/page_iterator/page.jsp" %>
			</div>
			
		</c:if>
	
		<div class="results-grid">
			<table class="taglib-search-iterator" cellspacing="0">
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
	
				<td class="col-<%= i + 1 %>"	
					<c:if test="<%= (rowChecker != null) && (headerNames.size() == 2) && (i == 1) %>">
						width="95%"
					</c:if>
				>
					
					<c:if test="<%= orderKey != null %>">
					<% 
						//String = DocumentReceiptDisplayTerms.DEPARTMENTID 
					%>					
						<a onclick='viewListDocumentReport("<%= portletURLString + "&" + DocumentReceiptViewListDisplayTerms.CAPGUI + "=" + searchTerms.getCapgui() + 
																		"&" + DocumentReceiptViewListDisplayTerms.LOAISOCONGVAN + "=" + searchTerms.getLoaisocongvan()%>
																		&<%= namespace %>orderByCol=<%= orderKey %>
																		&<%= namespace %>orderByType=<%= orderByType %>")'>
					</c:if>
	
					<c:if test="<%= orderCurrentHeader %>" />
	
					<%
					String headerNameValue = LanguageUtil.get(pageContext, headerName);
					%>
	
					<c:choose>
						<c:when test="<%= headerNameValue.equals(StringPool.BLANK) %>">
							<%= StringPool.NBSP %>
						</c:when>
						<c:otherwise>													
							<%= headerNameValue %> 	
							<c:if test="<%= i == 2 %>">
								<liferay-util:include page="/html/portlet/ext/home_report/list_filter_documentrecordtype.jsp" />
							</c:if>
							<c:if test="<%= i == 1 %>">
								<liferay-util:include page="/html/portlet/ext/home_report/list_filter.jsp" />
							</c:if>	
						
						</c:otherwise>
					</c:choose>
					
					<c:if test="<%= orderCurrentHeader %>" />
	
					<c:if test="<%= orderKey != null %>" />
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
					onmouseover="onMouseOverTr(this);" onmouseout="onMouseOutTr(this);"
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
				<%@ include file="/html/portlet/ext/home_report/page_iterator/page.jsp" %>
			</div>
		</c:if>
	
		<c:if test="<%= (rowChecker != null) && (resultRows.size() > 0) && Validator.isNotNull(rowChecker.getAllRowsId()) && allRowsIsChecked %>">
			<script type="text/javascript">
				document.<%= rowChecker.getFormName() %>.<%= rowChecker.getAllRowsId() %>.checked = true;
			</script>
		</c:if>
	</c:if>
</fieldset>
</form>

<%
	PortletURL portletURLRedirect = renderResponse.createRenderURL();
	portletURLRedirect.setWindowState(LiferayWindowState.NORMAL);
	portletURLRedirect.setParameter("struts_action", "/sgs/home_report/view");	
		
	portletURLRedirect.setParameter(DocumentReceiptViewListDisplayTerms.DEPARTMENTID, departmentId);
	portletURLRedirect.setParameter(DocumentReceiptViewListDisplayTerms.USERID, String.valueOf(userId));
	portletURLRedirect.setParameter(DocumentReceiptViewListDisplayTerms.LOAITHONGKE, loaiThongKe);
	portletURLRedirect.setParameter(DocumentReceiptViewListDisplayTerms.FROMDATE, from_Date);
	portletURLRedirect.setParameter(DocumentReceiptViewListDisplayTerms.TODATE, to_Date);
	portletURLRedirect.setParameter("action", action);
	portletURLRedirect.setParameter("row", rowSelect);	
	portletURLRedirect.setParameter("cur", ParamUtil.getString(renderRequest, "curVal"));
%>

<div id="table-button" align="right">
	<span onclick="javascript:submitForm(document.hrefFm,'<%= portletURLRedirect.toString()%>');" >
		<input type="button" value='<liferay-ui:message key="back"/>'>
	</span>
</div>

</div>
</div>
