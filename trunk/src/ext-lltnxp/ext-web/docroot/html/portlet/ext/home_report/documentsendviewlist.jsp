<%@ include file="/html/portlet/ext/home_report/init.jsp" %>
<%@ include file="/html/portlet/ext/home_report/page_iterator/init_search.jsp" %>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@page import="com.sgs.portlet.document.send.model.PmlEdmDocumentSend"%>
<%@page import="com.sgs.portlet.document.send.service.PmlEdmDocumentSendLocalServiceUtil"%>
<%@page import="com.sgs.portlet.document.receipt.model.PmlEdmDocumentType"%>
<%@page import="com.sgs.portlet.document.receipt.service.PmlEdmDocumentTypeLocalServiceUtil"%>
<%@page import="com.sgs.portlet.pmluser.model.PmlUser"%>
<%@page import="com.sgs.portlet.pmluser.service.PmlUserLocalServiceUtil"%>
<%@page import="com.sgs.portlet.document.receipt.model.PmlFileStatusStateProcess"%>
<%@page import="com.sgs.portlet.document.receipt.service.persistence.PmlFileStatusStateProcessUtil"%>
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
	<portlet:param name="struts_action" value="/sgs/home_report/documentsendviewlist" />
</portlet:actionURL>

<div id="<portlet:namespace/>listdocument" class="listdocument-cv" >	

<div class="title_categ"><liferay-ui:message key="tinhhinhthulycongvan.title" /></div>
<div class="boxcontent">

<form action="<%= baoCaoDetail %>" name="<portlet:namespace />frm" id="<portlet:namespace/>fm" method="post">			
<fieldset>

<%
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(LiferayWindowState.EXCLUSIVE);	
	portletURL.setParameter("struts_action", "/sgs/home_report/documentsendviewlist");
	portletURL.setParameter(DocumentSendViewListDisplayTerms.DEPARTMENTID, departmentId);
	portletURL.setParameter(DocumentSendViewListDisplayTerms.USERID, String.valueOf(userId));
	portletURL.setParameter(DocumentSendViewListDisplayTerms.LOAITHONGKE , loaiThongKe);
	portletURL.setParameter(DocumentSendViewListDisplayTerms.FROMDATE, from_Date);
	portletURL.setParameter(DocumentSendViewListDisplayTerms.TODATE, to_Date);	
	portletURL.setParameter("action", action);	
	portletURL.setParameter("row", String.valueOf(rowSelect));	
	
	pageContext.setAttribute("portletURL", portletURL);
	String portletURLString = portletURL.toString();
	request.setAttribute("view.jsp-portletURL", portletURL);
	request.setAttribute("view.jsp-portletURLString", portletURLString);
	
	DocumentSendViewListSearch searchContainerList = new DocumentSendViewListSearch(renderRequest, portletURL);
	DocumentSendViewListSearchTerms searchTerms = (DocumentSendViewListSearchTerms)searchContainerList.getSearchTerms();
	
	List<String> headerNames1 = searchContainerList.getHeaderNames();
%>

<!-- tieu de danh sach van ban duoc chon  -->
<div class="contain-title-report">
	<h2 class="report-title-HS"><liferay-ui:message key="report-danhsachvanbandi" /> <%= tenAction %></h2>
	<h4 class="description-report-title"><%= tenChuyenVien %></h4><br/>
	<h5>(<liferay-ui:message key="tinhhinhthulycongvan.tungay" /> <%= from_Date %> <liferay-ui:message key="tinhhinhthulycongvan.denngay" /> <%= to_Date %>)</h5>
</div>
<!-- end -->

<div style="display: none;">
	<liferay-ui:search-form	page="/html/portlet/ext/home_report/list_filter_send.jsp" searchContainer="<%= searchContainerList %>" >
	</liferay-ui:search-form>
</div>
	
<%
	List<PmlEdmDocumentSend> list = new ArrayList<PmlEdmDocumentSend>();
	int total1 = 0;
	long userSelect = Long.parseLong(rowSelect);
	
	if (action.equals("tonthangtruoc")) {
		list = PmlEdmDocumentSendLocalServiceUtil.listTonDauKyChuyenVien_CVDi
						(userSelect, 0, searchTerms.getLoaisocongvan(), "", fromDate, toDate, 
						searchContainerList.getStart(), searchContainerList.getEnd(), searchContainerList.getOrderByComparator());
		total1 = PmlEdmDocumentSendLocalServiceUtil.countTonDauKyChuyenVien_CVDi
						(userSelect, 0, searchTerms.getLoaisocongvan(), "", fromDate, toDate);
	} 
	else if (action.equals("nhantrongthang")) {
		list = PmlEdmDocumentSendLocalServiceUtil.listNhanTrongThangChuyenVien_CVDi
						(userSelect, 0, searchTerms.getLoaisocongvan(), fromDate, toDate, 
						searchContainerList.getStart(), searchContainerList.getEnd(), searchContainerList.getOrderByComparator());
		total1 = PmlEdmDocumentSendLocalServiceUtil.countNhanTrongThangChuyenVien_CVDi
						(userSelect, 0, searchTerms.getLoaisocongvan(), fromDate, toDate);
	} 
	else if (action.equals("daxuly")) {
		list = PmlEdmDocumentSendLocalServiceUtil.listTongDaXuLyChuyenVien_CVDi
						(userSelect, 0, searchTerms.getLoaisocongvan(), "", fromDate, toDate, 
						searchContainerList.getStart(), searchContainerList.getEnd(), searchContainerList.getOrderByComparator());
		total1 = PmlEdmDocumentSendLocalServiceUtil.countTongDaXuLyChuyenVien_CVDi
						(userSelect, 0, searchTerms.getLoaisocongvan(), "", fromDate, toDate);
	} 
	else if (action.equals("conton")) {
		list = PmlEdmDocumentSendLocalServiceUtil.listTongDangXuLyChuyenVien_CVDi
						(userSelect, 0, searchTerms.getLoaisocongvan(), "", fromDate, toDate, 
						searchContainerList.getStart(), searchContainerList.getEnd(), searchContainerList.getOrderByComparator());
		total1 = PmlEdmDocumentSendLocalServiceUtil.countTongDangXuLyChuyenVien_CVDi
						(userSelect, 0, searchTerms.getLoaisocongvan(), "", fromDate, toDate);
	} 
	
	searchContainerList.setTotal(total1);
	portletURL.setParameter(searchContainerList.getCurParam(), String.valueOf(searchContainerList.getCurValue()));
 	
	List resultRows1 = searchContainerList.getResultRows();
	ResultRow row1 = null;
	
	PmlEdmDocumentSend documentSend = null;
	long documentSendId = 0;
	PmlEdmDocumentType documentType = null;
	PmlFileStatusStateProcess stateProcess = null;

	for (int i = 0; i < list.size(); i ++) {

		documentSend = (PmlEdmDocumentSend)list.get(i);
		documentSendId = documentSend.getDocumentSendId();
		
		PortletURL details = renderResponse.createRenderURL();
		details.setWindowState(LiferayWindowState.NORMAL);	
		details.setParameter("struts_action", "/sgs/home_report/senddetail");
		details.setParameter("documentSendId", String.valueOf(documentSendId));
		searchContainerList.getIteratorURL().setWindowState(LiferayWindowState.NORMAL);
		details.setParameter("redirectDetail", searchContainerList.getIteratorURL().toString());
		
		row1 = new ResultRow(documentSend, documentSend.getDocumentSendId(), i);
		// STT
		row1.addText((i+1) + ".");
		
		// loai cong van
		try {
			documentType = PmlEdmDocumentTypeLocalServiceUtil.getPmlEdmDocumentType(documentSend.getDocumentTypeId());
			row1.addText(documentType.getDocumentTypeName());
		} catch (Exception e) {
			row1.addText("");
		}
		
		// chi tiet van ban
		row1.addText("Chi ti\u1ebft", details);
		
		// nguoi tao
		long editorId = documentSend.getEditorId();
		try {
			row1.addText(HomeReportDWRUtil.getFullName(editorId));
		} catch (Exception e) {
			row1.addText("");
		}
		
		// nguoi ky van ban
		row1.addText(documentSend.getSignerName());
		
		// noi nhan
		row1.addText(documentSend.getReceivingPlace());
		
		// trich yeu
		row1.addText(documentSend.getBriefContent());
		
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
	
				<td class="col-<%= i + 1 %>"	
					<c:if test="<%= (rowChecker != null) && (headerNames.size() == 2) && (i == 1) %>">
						width="95%"
					</c:if>
				>
					
					<c:if test="<%= orderKey != null %>">
						<a onclick='viewListDocumentReport("<%= portletURLString + "&" + DocumentSendViewListDisplayTerms.LOAISOCONGVAN + "=" + searchTerms.getLoaisocongvan()%>
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
							<c:if test="<%= i == 1 %>">
								<br/>
								<liferay-util:include page="/html/portlet/ext/home_report/list_filter_send.jsp" />
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
		
	portletURLRedirect.setParameter(DocumentSendViewListDisplayTerms.DEPARTMENTID, departmentId);
	portletURLRedirect.setParameter(DocumentSendViewListDisplayTerms.USERID, String.valueOf(userId));
	portletURLRedirect.setParameter(DocumentSendViewListDisplayTerms.LOAITHONGKE, loaiThongKe);
	portletURLRedirect.setParameter(DocumentSendViewListDisplayTerms.FROMDATE, from_Date);
	portletURLRedirect.setParameter(DocumentSendViewListDisplayTerms.TODATE, to_Date);
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
