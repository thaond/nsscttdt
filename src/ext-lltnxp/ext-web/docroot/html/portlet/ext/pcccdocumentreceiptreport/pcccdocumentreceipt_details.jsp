<%@ include file="/html/portlet/ext/pcccdocumentreceiptreport/init.jsp" %>
<%@ include file="/html/portlet/ext/pcccdocumentreceiptreport/page_iterator/init_search.jsp" %>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.sgs.portlet.pcccdocumentreceiptreport.search.DocumentDetailSearch"%>
<%@page import="com.sgs.portlet.pcccdocumentreceiptreport.search.DocumentDetailSearchTerms"%>
<%@page import="com.sgs.portlet.pcccdocumentreceiptreport.search.DocumentDetailDisplayTerms"%>

<%@page import="com.sgs.portlet.pcccdocumentreceiptreport.dto.PCCCDocumentListDTO"%>
<%@page import="com.sgs.portlet.pcccdocumentreceiptreport.action.PCCCDocumentReceiptDetailsAction"%>

<%@page import="com.sgs.portlet.document.model.PmlDocumentReceiptLog"%>
<%@page import="com.sgs.portlet.document.service.persistence.PmlDocumentReceiptLogUtil"%>
<%@page import="com.sgs.portlet.pcccdocumentreceiptreport.util.TinhHinhThuLyCongVanDWRUtil"%>

<%@page import="com.sgs.portlet.pmluser.model.PmlUser"%>
<%@page import="com.sgs.portlet.pmluser.service.persistence.PmlUserUtil"%>
<liferay-util:include page="/html/portlet/ext/pcccdocumentreceiptreport/js/pcccdocumentreceiptreport.jsp"></liferay-util:include>
<liferay-util:include page="/html/portlet/ext/pcccdocumentreceiptreport/js/quanlycongvan_report.jsp"></liferay-util:include>

<link type="text/css" rel="stylesheet" href="/html/portlet/ext/pcccdocumentreceiptreport/css/letter.css" />

<script type='text/javascript' src='/html/js/liferay/tr.js'></script>
<%
	String departmentId = ParamUtil.getString(renderRequest, "departmentId");
	long userId = ParamUtil.getLong(renderRequest, "userId");
	
	int documentRecordTypeId = ParamUtil.getInteger(renderRequest, "nhomCongVan");
	String loaiCongVan = ParamUtil.getString(renderRequest, "loaiCongVan");
	String doMat = ParamUtil.getString(renderRequest, "doMat");
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
	<portlet:param name="struts_action" value="/sgs/pcccdocumentreceiptreport/pcccdocumentreceiptdetails" />
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
	<portlet:param name="struts_action" value="/sgs/pcccdocumentreceiptreport/pcccdocumentreceiptdetails" />
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

<div id="<portlet:namespace/>listdocument" class="listdocument-cv" >	
<div class="title_categ"><liferay-ui:message key="bao-cao-thong-ke"/></div>
<div class="boxcontent pcccdocumentreceiptdetails">
<form action="<%= baoCaoDetail %>" name="<portlet:namespace />frm" id="<portlet:namespace/>fm" method="post">			
<fieldset>

<%
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(LiferayWindowState.EXCLUSIVE);	
	portletURL.setParameter("struts_action", "/sgs/pcccdocumentreceiptreport/pcccdocumentreceiptdetails");
	portletURL.setParameter(DocumentDetailDisplayTerms.DEPARTMENTID, departmentId);
	portletURL.setParameter(DocumentDetailDisplayTerms.USERID, String.valueOf(userId));
	portletURL.setParameter(DocumentDetailDisplayTerms.LOAICONGVAN , loaiCongVan);
	portletURL.setParameter(DocumentDetailDisplayTerms.DOMAT , doMat);
	portletURL.setParameter(DocumentDetailDisplayTerms.FROMDATE, from_Date);
	portletURL.setParameter(DocumentDetailDisplayTerms.TODATE, to_Date);	
	portletURL.setParameter("action", action);	
	portletURL.setParameter("row", String.valueOf(rowDS));	
	portletURL.setParameter("userIdRow", userIdRow);	
	portletURL.setParameter("radioTenChuyenVien", String.valueOf(radioTenChuyenVien));	//yenlt update 28062010
	portletURL.setParameter("radioTenPhongBan", String.valueOf(radioTenPhongBan));	//yenlt update 28062010
	pageContext.setAttribute("portletURL", portletURL);
	String portletURLString = portletURL.toString();
	request.setAttribute("view.jsp-portletURL", portletURL);
	request.setAttribute("view.jsp-portletURLString", portletURLString);
	
	DocumentDetailSearch searchContainerList = new DocumentDetailSearch(renderRequest, portletURL);
	DocumentDetailSearchTerms searchTerms = (DocumentDetailSearchTerms)searchContainerList.getSearchTerms();
	List<String> headerNames1 = searchContainerList.getHeaderNames();
%>

<input type="hidden" name="<portlet:namespace/>orderByCol" value="<%= searchContainerList.getOrderByCol() %>"/>
<input type="hidden" name="<portlet:namespace/>orderByType" value="<%= searchContainerList.getOrderByType() %>"/>

<!-- tieu de danh sach van ban duoc chon  -->
<div align="center" class="contain-title-report">
	<h2 class="report-title-HS"><liferay-ui:message key="tinhhinhthulycongvan.title" /></h2>
	<h4>(<%= tenPhongBan %>) </h4>
	<h4><liferay-ui:message key="report-danhsachvanbanden" /> <%= tenAction %> <liferay-ui:message key="report-phanmemloi" /></h4>
	<h5 class="description-report-title">
	(<liferay-ui:message key="tinhhinhthulycongvan.tungay" /> <%= from_Date %> <liferay-ui:message key="tinhhinhthulycongvan.denngay" /> <%= to_Date %>)
	</h5>
</div>
<!-- end -->

<div style="display: none;">
	<liferay-ui:search-form	page="/html/portlet/ext/pcccdocumentreceiptreport/list_filter_documentrecordtype.jsp" searchContainer="<%= searchContainerList %>" >
	</liferay-ui:search-form>
</div>

<%
	List<PCCCDocumentListDTO> list = PCCCDocumentReceiptDetailsAction.getDocumentListDTOReport("", searchTerms.getNhomCongVan(),
											searchTerms.getCapgui(), searchTerms.getLoaisocongvan(), searchTerms.getDepartmentId(),
											searchTerms.getUserId(), searchTerms.getDoMat(), fromDate, toDate, action, rowDS, userIdRow,
											searchContainerList.getStart(), searchContainerList.getEnd(), searchContainerList.getOrderByComparator());
	int total1 = PCCCDocumentReceiptDetailsAction.countDocumentListDTOReport(searchTerms.getNhomCongVan(), searchTerms.getCapgui(), 
											searchTerms.getLoaisocongvan(), searchTerms.getDepartmentId(), searchTerms.getUserId(), 
											searchTerms.getDoMat(), fromDate, toDate, action, rowDS, userIdRow);
	
	searchContainerList.setTotal(total1);
	searchContainerList.setResults(list);
	portletURL.setParameter(searchContainerList.getCurParam(), String.valueOf(searchContainerList.getCurValue()));
	
	List resultRows1 = searchContainerList.getResultRows();
	ResultRow row1 = null;
	
	PCCCDocumentListDTO dto = null;
	long documentReceiptId = 0;
	
	List<PmlDocumentReceiptLog> listLog = new ArrayList<PmlDocumentReceiptLog>();
	PmlDocumentReceiptLog documentReceiptLog = null;
	
	for (int i = 0; i < list.size(); i ++) {
		dto = (PCCCDocumentListDTO)list.get(i);
		documentReceiptId = dto.getDocumentId();
		
		PortletURL details = renderResponse.createRenderURL();
		details.setWindowState(LiferayWindowState.NORMAL);	
		details.setParameter("struts_action", "/sgs/pcccdocumentreceiptreport/details");
		details.setParameter("documentReceiptId", String.valueOf(documentReceiptId));
		searchContainerList.getIteratorURL().setWindowState(LiferayWindowState.NORMAL);
		details.setParameter("redirectDetail", searchContainerList.getIteratorURL().toString());
		details.setParameter("radioTenChuyenVien", String.valueOf(radioTenChuyenVien));	//yenlt update 28062010
		details.setParameter("radioTenPhongBan", String.valueOf(radioTenPhongBan));//yenlt update 28062010
		
		row1 = new ResultRow(dto, documentReceiptId, i);
		
		// STT
		row1.addText((i+1) + ".");
		
		// so den theo so
		row1.addText(dto.getSoDenTheoSo(), details);
		
		// so ky hieu goc
		row1.addText(dto.getSoKyHieuGoc(), details);
		
		// loai vb
		row1.addText(dto.getLoaiVB());
		
		// ngay nhan
		row1.addText(dto.getNgayNhan());
		
		// ngay phat hanh
		row1.addText(dto.getNgayPhatHanh(), details);
		
		// noi phat hanh
		row1.addText(dto.getNoiPhatHanh());
		
		// trich yeu
		row1.addText(dto.getTrichYeu());
		
		// do mat
		row1.addText(dto.getDoMat());
		
		// nguoi xu ly
		row1.addText(dto.getNguoiXuLy());
		
		
		// ds chuyen vien dang giu van ban
		/*
		long pmlUserId = 0;
		String userName = "";
		String userXuLy = "";
		try {
			listLog = PmlDocumentReceiptLogUtil.findByDocumentReceiptId(documentReceiptId);
			for (int j = 0; j < listLog.size(); j ++) {
				documentReceiptLog = listLog.get(j);
				if (documentReceiptLog.getDateProcess() == null) {
					pmlUserId = documentReceiptLog.getProcesser();
					userName = TinhHinhThuLyCongVanDWRUtil.getFullName(pmlUserId);
					if (documentReceiptLog.getType_() == 0) {
						userXuLy += "<font color='red'>- " + userName + "</font><br/>";
					} else {
						userXuLy += "- " + userName + "<br/>";
					}
				}
			}
		} catch (Exception e) { }
		//row1.addText(userXuLy);
		
		/* phmphuc close 11/06/2010 
		// nguoi xu ly chinh - phong ban cua nguoi xu ly chinh
		long nguoiXuLyChinhId = documentReceipt.getMainUserProcessId();
		User nguoiXuLyChinh = null;
		PmlUser chuyenVienPB = null;
		String tenNguoiXuLyChinh = "";
		String phongBan = "";
		Department department = null;
		try {
			nguoiXuLyChinh = UserLocalServiceUtil.getUser(nguoiXuLyChinhId);
			tenNguoiXuLyChinh = nguoiXuLyChinh.getLastName() + " " + nguoiXuLyChinh.getMiddleName() + " " + nguoiXuLyChinh.getFirstName();
			
			chuyenVienPB = PmlUserUtil.findByPrimaryKey(nguoiXuLyChinhId);
			phongBan = chuyenVienPB.getDepartmentsId();
			department = DepartmentUtil.findByPrimaryKey(phongBan);
			row1.addText(tenNguoiXuLyChinh + "<br />" + "(" + department.getDepartmentsName() + ")");
		} catch (Exception e) { 
			row1.addText(tenNguoiXuLyChinh);
		} */
		
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
	
		<div class="results-grid">
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
					<% 
						//String = DocumentReceiptDisplayTerms.DEPARTMENTID 
					%>					
						<a onclick='viewListDocumentReport("<%= portletURLString + "&" + DocumentDetailDisplayTerms.CAPGUI + "=" + searchTerms.getCapgui() + "&" + DocumentDetailDisplayTerms.LOAISOCONGVAN + "=" + searchTerms.getLoaisocongvan()%>&<%= namespace %>orderByCol=<%= orderKey %>&<%= namespace %>orderByType=<%= orderByType %>")'>
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
							<c:if test="<%= i == 3 %>">
								<liferay-util:include page="/html/portlet/ext/pcccdocumentreceiptreport/list_filter_documentrecordtype.jsp" />
							</c:if>
							<%--
							<c:if test="<%= i == 1 %>">
								<liferay-util:include page="/html/portlet/ext/pcccdocumentreceiptreport/list_filter.jsp" />
							</c:if>	
							--%>
							<c:if test="<%= i == headerNames.size() - 1 %>">
								<br/><font color="red"> <liferay-ui:message key="note-nguoixylychinh" /> </font>
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
</form>

<%
	PortletURL portletURLRedirect = renderResponse.createRenderURL();
	portletURLRedirect.setWindowState(LiferayWindowState.NORMAL);
	portletURLRedirect.setParameter("struts_action", "/sgs/pcccdocumentreceiptreport/view");	
		
	portletURLRedirect.setParameter(DocumentDetailDisplayTerms.DEPARTMENTID, departmentId);
	portletURLRedirect.setParameter(DocumentDetailDisplayTerms.USERID, String.valueOf(userId));
	portletURLRedirect.setParameter(DocumentDetailDisplayTerms.NHOMCONGVAN, String.valueOf(documentRecordTypeId));
	portletURLRedirect.setParameter(DocumentDetailDisplayTerms.LOAICONGVAN , loaiCongVan);
	portletURLRedirect.setParameter(DocumentDetailDisplayTerms.DOMAT , doMat);
	portletURLRedirect.setParameter(DocumentDetailDisplayTerms.FROMDATE, from_Date);
	portletURLRedirect.setParameter(DocumentDetailDisplayTerms.TODATE, to_Date);
	portletURLRedirect.setParameter("action", action);
	portletURLRedirect.setParameter("row", String.valueOf(rowDS));	
	portletURLRedirect.setParameter("attView", "yes");	
	portletURLRedirect.setParameter("radioTenChuyenVien", String.valueOf(radioTenChuyenVien));	//yenlt update 28062010
	portletURLRedirect.setParameter("radioTenPhongBan", String.valueOf(radioTenPhongBan));	//yenlt update 28062010
	portletURLRedirect.setParameter("cur", ParamUtil.getString(renderRequest, "curVal"));

%>
<%
	int capGuiId = ((DocumentDetailDisplayTerms) searchContainer.getDisplayTerms()).getCapgui();
	int loaiSoCongVan = ((DocumentDetailDisplayTerms) searchContainer.getDisplayTerms()).getLoaisocongvan();
	
	String printReportWord = "word&".concat(renderResponse.getNamespace()).
		concat(DocumentDetailDisplayTerms.CAPGUI).concat("=").concat(String.valueOf(capGuiId)).
		concat("&").concat(renderResponse.getNamespace()).
		concat(DocumentDetailDisplayTerms.LOAISOCONGVAN).concat("=").concat(String.valueOf(loaiSoCongVan));
	
	String printReportExcel = "excel&".concat(renderResponse.getNamespace()).
		concat(DocumentDetailDisplayTerms.CAPGUI).concat("=").concat(String.valueOf(capGuiId)).
		concat("&").concat(renderResponse.getNamespace()).
		concat(DocumentDetailDisplayTerms.LOAISOCONGVAN).concat("=").concat(String.valueOf(loaiSoCongVan));
	
%>
<div id="table-button" align="right">
			<input type="button" value='<liferay-ui:message key="xuat-word" />' onclick="<portlet:namespace />addActionReport('<%= printReportWord %>');<portlet:namespace />frm.submit();<portlet:namespace />setActionReport();" />
			<input type="button" value='<liferay-ui:message key="xuat-excel" />' onclick="<portlet:namespace />addActionReport('<%= printReportExcel %>');<portlet:namespace />frm.submit();<portlet:namespace />setActionReport();" />
			<span onclick="javascript:submitForm(document.hrefFm,'<%= portletURLRedirect.toString() %>');" >
				<input type="button" value='<liferay-ui:message key="back"/>'>
			</span>
</div>
</div>
</div>
