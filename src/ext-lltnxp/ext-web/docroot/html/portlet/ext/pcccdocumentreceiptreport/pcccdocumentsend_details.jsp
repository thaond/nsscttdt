<%@ include file="/html/portlet/ext/pcccdocumentreceiptreport/init.jsp" %>
<%@ include file="/html/portlet/ext/pcccdocumentreceiptreport/page_iterator/init_search.jsp" %>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.portlet.PortletURLImpl"%>

<%@page import="com.sgs.portlet.pcccdocumentreceiptreport.search.DocumentReportSendSearch"%>
<%@page import="com.sgs.portlet.pcccdocumentreceiptreport.search.DocumentReportSendSearchTerms"%>
<%@page import="com.sgs.portlet.pcccdocumentreceiptreport.search.DocumentReportSendDisplayTerms"%>

<%@page import="com.sgs.portlet.pcccdocumentreceiptreport.dto.PCCCDocumentListDTO"%>
<%@page import="com.sgs.portlet.pcccdocumentreceiptreport.action.PCCCDocumentSendDetailsAction"%>

<liferay-util:include page="/html/portlet/ext/pcccdocumentreceiptreport/js/pcccdocumentreceiptreport.jsp"></liferay-util:include>
<liferay-util:include page="/html/portlet/ext/pcccdocumentreceiptreport/js/quanlycongvan_report.jsp"></liferay-util:include>
<link type="text/css" rel="stylesheet" href="/html/portlet/ext/pcccdocumentreceiptprocess/css/letter.css" />
<script type='text/javascript' src='/html/js/liferay/tr.js'></script>
<%
	String departmentId = ParamUtil.getString(renderRequest, "departmentId");
	long userId = ParamUtil.getLong(renderRequest, "userId");
	
	int documentRecordTypeId = ParamUtil.getInteger(renderRequest, "nhomCongVan");
	String loaiCongVan = ParamUtil.getString(renderRequest, "loaiCongVan");
	String doMat = ParamUtil.getString(renderRequest, "doMat");
	String from_Date = ParamUtil.getString(renderRequest, "fromDate");
	String to_Date = ParamUtil.getString(renderRequest,"toDate");
	
	Date fromDate = null;
	Date toDate = null;
	SimpleDateFormat dmy =  new SimpleDateFormat("dd/MM/yyyy");
	
	if (!"".equals(from_Date) || !"".equals(to_Date)) {
		fromDate = new SimpleDateFormat("dd/MM/yyyy").parse(from_Date);
		toDate = new SimpleDateFormat("dd/MM/yyyy").parse(to_Date);
	} else {
		
		fromDate = new SimpleDateFormat("dd/MM/yyyy").parse(  new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
		toDate = new SimpleDateFormat("dd/MM/yyyy").parse( new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
	}
	
	String action = ParamUtil.getString(renderRequest,"action");
	String rowDS = ParamUtil.getString(renderRequest, "row");
	String userIdRow = ParamUtil.getString(renderRequest, "userIdRow");
	
	String tenPhongBan = (renderRequest.getAttribute("tenPhongBan") == null) ? "" : (String) renderRequest.getAttribute("tenPhongBan");
	tenPhongBan = tenPhongBan.replaceAll("CV:", "Ng\u01B0\u1EDDi x\u1EED l\u00FD:");
	
	String tenAction = (renderRequest.getAttribute("tenAction") == null) ? "" : (String) renderRequest.getAttribute("tenAction");
	tenAction = tenAction.toLowerCase();
	//yenlt update 28062010
	boolean radioTenPhongBan = ParamUtil.getBoolean(renderRequest, "radioTenPhongBan");
	boolean radioTenChuyenVien = ParamUtil.getBoolean(renderRequest, "radioTenChuyenVien");
	//end yenlt 28062010
%>

<portlet:actionURL var="inBaoCao">
	<portlet:param name="struts_action" value="/sgs/pcccdocumentreceiptreport/pcccdocumentsenddetails" />
	<portlet:param name="<%= Constants.CMD %>" value="printReport" />
	<portlet:param name="departmentId" value="<%= departmentId %>" />
	<portlet:param name="userId" value="<%= String.valueOf(userId) %>" />
	<portlet:param name="nhomCongVan" value="<%= String.valueOf(documentRecordTypeId) %>" />
	<portlet:param name="loaiCongVan" value="<%= loaiCongVan %>" />
	<portlet:param name="doMat" value="<%= doMat %>" />
	<portlet:param name="fromDate" value="<%= dmy.format(fromDate) %>" />
	<portlet:param name="toDate" value="<%= dmy.format(toDate)  %>" />
	<portlet:param name="action" value="<%= action %>" />
	<portlet:param name="row" value="<%= rowDS %>" />
	<portlet:param name="userIdRow" value="<%= userIdRow %>" />
</portlet:actionURL>

<portlet:actionURL var="baoCaoDetail">
	<portlet:param name="struts_action" value="/sgs/pcccdocumentreceiptreport/pcccdocumentsenddetails" />
</portlet:actionURL>

<script type="text/javascript">
function <portlet:namespace />addActionReport(reportType) {
	var action = "<%= inBaoCao %>&<portlet:namespace />reportType=" + reportType;
	document.getElementsByName("<portlet:namespace />frm")[0].setAttribute("action", action);
}

function <portlet:namespace />setActionReport() {
	document.getElementsByName("<portlet:namespace />frm")[0].setAttribute("action", "");
}
</script>


<div id="<portlet:namespace/>listdocument" >	
<div class="title_categ"><liferay-ui:message key="bao-cao-thong-ke"/></div>
<div class="boxcontent pcccdocumentsenddetails">
<form action="<%= baoCaoDetail %>" name="<portlet:namespace />frm" id="<portlet:namespace/>fm" method="post">	
<fieldset>
<%
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(LiferayWindowState.EXCLUSIVE);	
	portletURL.setParameter("struts_action", "/sgs/pcccdocumentreceiptreport/pcccdocumentsenddetails");
	
	portletURL.setParameter(DocumentReportSendDisplayTerms.DEPARTMENTID, departmentId);
	portletURL.setParameter(DocumentReportSendDisplayTerms.USERID, String.valueOf(userId));
	portletURL.setParameter(DocumentReportSendDisplayTerms.LOAICONGVAN , loaiCongVan);
	portletURL.setParameter(DocumentReportSendDisplayTerms.DOMAT , doMat);
	portletURL.setParameter(DocumentReportSendDisplayTerms.FROMDATE, from_Date);
	portletURL.setParameter(DocumentReportSendDisplayTerms.TODATE, to_Date);	
	
	portletURL.setParameter("action", action);	
	portletURL.setParameter("row", String.valueOf(rowDS));	
	portletURL.setParameter("userIdRow", userIdRow);
	
	portletURL.setParameter("radioTenChuyenVien", String.valueOf(radioTenChuyenVien));	//yenlt update 28062010
	portletURL.setParameter("radioTenPhongBan", String.valueOf(radioTenPhongBan));	//yenlt update 28062010
	
	pageContext.setAttribute("portletURL", portletURL);
	String portletURLString = portletURL.toString();
	request.setAttribute("view.jsp-portletURL", portletURL);
	request.setAttribute("view.jsp-portletURLString", portletURLString);
	
	DocumentReportSendSearch searchContainerList = new DocumentReportSendSearch(renderRequest, portletURL);
	DocumentReportSendSearchTerms searchTerms = (DocumentReportSendSearchTerms)searchContainerList.getSearchTerms();
	
	List<String> headerNames1 = searchContainerList.getHeaderNames();
%>

<input type="hidden" name="<portlet:namespace/>orderByCol" value="<%= searchContainerList.getOrderByCol() %>"/>
<input type="hidden" name="<portlet:namespace/>orderByType" value="<%= searchContainerList.getOrderByType() %>"/>

<!-- tieu de danh sach van ban duoc chon  -->
<div class="contain-title-report">
	<h2 class="report-title-HS"><liferay-ui:message key="tinhhinhthulycongvan.title" /></h2>
	<h4>(<%= tenPhongBan %>) </h4>
	<h4><liferay-ui:message key="report-danhsachvanbandi" /> <%= tenAction %> <liferay-ui:message key="report-phanmemloi" /></h4>
	<h5 class="description-report-title">
	(<liferay-ui:message key="tinhhinhthulycongvan.tungay" /> <%= from_Date %> <liferay-ui:message key="tinhhinhthulycongvan.denngay" /> <%= to_Date %>)
	</h5>
</div>
<!-- end -->

<div style="display: none;">
	<liferay-ui:search-form	page="/html/portlet/ext/pcccdocumentreceiptreport/list_filter_send.jsp" searchContainer="<%= searchContainerList %>" >
	</liferay-ui:search-form>
</div>
	
<%
	List<PCCCDocumentListDTO> list = PCCCDocumentSendDetailsAction.getDocumentListDTOReport("", searchTerms.getNhomCongVan(),
										searchTerms.getLoaisocongvan(), searchTerms.getDepartmentId(), searchTerms.getUserId(), 
										searchTerms.getDoMat(), fromDate, toDate, action, rowDS, userIdRow,
										searchContainerList.getStart(), searchContainerList.getEnd(), searchContainerList.getOrderByComparator());
	int total1 = PCCCDocumentSendDetailsAction.countDocumentListDTOReport(searchTerms.getNhomCongVan(),
										searchTerms.getLoaisocongvan(), searchTerms.getDepartmentId(), searchTerms.getUserId(), 
										searchTerms.getDoMat(), fromDate, toDate, action, rowDS, userIdRow);
	
	searchContainerList.setTotal(total1);
	searchContainerList.setResults(list);
	portletURL.setParameter(searchContainerList.getCurParam(), String.valueOf(searchContainerList.getCurValue()));
 	
	List resultRows1 = searchContainerList.getResultRows();
	ResultRow row1 = null;
	
	PCCCDocumentListDTO dto = null;
	long documentSendId = 0;

	for (int i = 0; i < list.size(); i ++) {
		dto = (PCCCDocumentListDTO)list.get(i);
		documentSendId = dto.getDocumentId();
		
		PortletURL details = renderResponse.createRenderURL();
		details.setWindowState(LiferayWindowState.NORMAL);	
		details.setParameter("struts_action", "/sgs/pcccdocumentreceiptreport/detailsend");
		details.setParameter("documentSendId", String.valueOf(documentSendId));
		searchContainerList.getIteratorURL().setWindowState(LiferayWindowState.NORMAL);
		details.setParameter("redirectDetail", searchContainerList.getIteratorURL().toString());
		details.setParameter("radioTenChuyenVien", String.valueOf(radioTenChuyenVien));	//yenlt update 28062010
		details.setParameter("radioTenPhongBan", String.valueOf(radioTenPhongBan));//yenlt update 28062010
		
		row1 = new ResultRow(dto, documentSendId, i);
		
		// STT
		row1.addText((i+1) + ".");
		
		// chi tiet van ban
		row1.addText("Chi ti\u1ebft", details);
		
		// loai van ban
		row1.addText(dto.getLoaiVB());
		
		// nguoi tao
		row1.addText(dto.getNguoiTao());

		// nguoi ky van ban
		row1.addText(dto.getNguoiKyVB());
		
		// noi nhan
		row1.addText(dto.getNoiNhan());
		
		// trich yeu
		row1.addText(dto.getTrichYeu());
		
		// do mat
		row1.addText(dto.getDoMat());
		
		// nguoi xu ly
		row1.addText(dto.getNguoiXuLy());
		
		/* phmphuc close 27/10/2010
		// trang thai
		PmlFileStatusStateProcess stateProcess = null;
		try {
			stateProcess = PmlFileStatusStateProcessUtil.findByStateProcessId(documentSend.getStatusId()).get(0);
		} catch (Exception e) {}
		if (stateProcess != null) {
			row1.addText(stateProcess.getDescription());
		} else {
			row1.addText("");
		}*/
		
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
				<%@ include file="/html/portlet/ext/pcccdocumentreceiptreport/page_iterator/page.jsp" %>
			</div>
			
		</c:if>
	
		<div class="results-grid ">
			<table class="taglib-search-iterator" cellspacing="0"  width="100%">
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
						<a onclick='viewListDocumentReport("<%= portletURLString + "&" + DocumentReportSendDisplayTerms.LOAISOCONGVAN + "=" + searchTerms.getLoaisocongvan()%>&<%= namespace %>orderByCol=<%= orderKey %>&<%= namespace %>orderByType=<%= orderByType %>")'>
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
								<br/>
								<liferay-util:include page="/html/portlet/ext/pcccdocumentreceiptreport/list_filter_send.jsp" />
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
				<%@ include file="/html/portlet/ext/pcccdocumentreceiptreport/page_iterator/page.jsp" %>
			</div>
		</c:if>
	
		<c:if test="<%= (rowChecker != null) && (resultRows.size() > 0) && Validator.isNotNull(rowChecker.getAllRowsId()) && allRowsIsChecked %>">
			<script type="text/javascript">
				document.<%= rowChecker.getFormName() %>.<%= rowChecker.getAllRowsId() %>.checked = true;
			</script>
		</c:if>
	</c:if>
	
</fieldset>

<%
	PortletURL portletURLRedirect = renderResponse.createRenderURL();
	portletURLRedirect.setWindowState(LiferayWindowState.NORMAL);
	portletURLRedirect.setParameter("struts_action", "/sgs/pcccdocumentreceiptreport/view");	
	portletURLRedirect.setParameter(DocumentReportSendDisplayTerms.DEPARTMENTID, departmentId);
	portletURLRedirect.setParameter(DocumentReportSendDisplayTerms.USERID, String.valueOf(userId));
	portletURLRedirect.setParameter(DocumentReportSendDisplayTerms.NHOMCONGVAN, String.valueOf(documentRecordTypeId));
	portletURLRedirect.setParameter(DocumentReportSendDisplayTerms.LOAICONGVAN , loaiCongVan);
	portletURLRedirect.setParameter(DocumentReportSendDisplayTerms.DOMAT , doMat);
	portletURLRedirect.setParameter(DocumentReportSendDisplayTerms.FROMDATE, from_Date);
	portletURLRedirect.setParameter(DocumentReportSendDisplayTerms.TODATE, to_Date);	
	portletURLRedirect.setParameter("action", action);	
	portletURLRedirect.setParameter("row", String.valueOf(rowDS));	
	portletURLRedirect.setParameter("attView", "yes");	
	portletURLRedirect.setParameter("radioTenChuyenVien", String.valueOf(radioTenChuyenVien));	//yenlt update 28062010
	portletURLRedirect.setParameter("radioTenPhongBan", String.valueOf(radioTenPhongBan));	//yenlt update 28062010
	portletURLRedirect.setParameter("cur", ParamUtil.getString(renderRequest, "curVal"));
%>

<%
	int loaiSoCongVan = ((DocumentReportSendDisplayTerms) searchContainer.getDisplayTerms()).getLoaisocongvan();
	String printReportWord = "word&".concat(renderResponse.getNamespace()).
		concat(DocumentReportSendDisplayTerms.NHOMCONGVAN).concat("=").concat(String.valueOf(documentRecordTypeId));
	String printReportExcel = "excel&".concat(renderResponse.getNamespace()).
		concat(DocumentReportSendDisplayTerms.NHOMCONGVAN).concat("=").concat(String.valueOf(documentRecordTypeId));
%>
<div id="table-button" align="right">
			<input type="button" value='<liferay-ui:message key="xuat-word" />' onclick="<portlet:namespace />addActionReport('<%= printReportWord %>');<portlet:namespace />frm.submit();<portlet:namespace />setActionReport();" />
			<input type="button" value='<liferay-ui:message key="xuat-excel" />' onclick="<portlet:namespace />addActionReport('<%= printReportExcel %>');<portlet:namespace />frm.submit();<portlet:namespace />setActionReport();" />
			<span onclick="javascript:submitForm(document.hrefFm,'<%= portletURLRedirect.toString() %>');" >
				<input type="button" value='<liferay-ui:message key="back"/>'>
			</span>
</div>
</form>
</div>
