<%@ include file="/html/portlet/ext/documentrecord/init.jsp" %>

<%@page import="javax.portlet.PortletURL"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="java.text.SimpleDateFormat"%>

<%@page import="com.sgs.portlet.documentrecord.search.BookRecordSearch"%>
<%@page import="com.sgs.portlet.documentrecord.search.BookRecordDisplayTerms"%>
<%@page import="com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend"%>
<%@page import="com.sgs.portlet.document.send.service.PmlEdmBookDocumentSendLocalServiceUtil"%>
<%@page import="com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType"%>
<%@page import="com.sgs.portlet.agency.model.Agency"%>
<%@page import="com.sgs.portlet.document.send.PmlEdmBookDocumentSendCanNotDeleteException"%>

<script type="text/javascript">

	function deleteBookRecordPB(url) {		
		if (confirm("<liferay-ui:message key='sgs_field_deleteMessage'/>" )) {
			document.<portlet:namespace />fm.method = "post";
			submitForm(document.<portlet:namespace />fm, url);
		}
	}

</script>

<%
	tabCVDi = ParamUtil.getString(renderRequest, "tabCVDi","so");
	tabs = ParamUtil.getString(renderRequest, "tabs","socongvandi");
	
	PortletURL portletURLSoBook = renderResponse.createRenderURL();

	portletURLSoBook.setWindowState(WindowState.NORMAL);
	portletURLSoBook.setParameter("struts_action", "/sgs/documentrecord/view");
	portletURLSoBook.setParameter("tabCVDi",tabCVDi);
	portletURLSoBook.setParameter("tabs",tabs);
	
	String soURLStringBook = portletURLSoBook.toString();
%>
<form action="<%= soURLStringBook %>" method="post" name="<portlet:namespace/>fm">
	<input name="<portlet:namespace />bookRecordURL" type="hidden" value="<%= soURLStringBook %>" />
	<liferay-ui:error exception="<%= PmlEdmBookDocumentSendCanNotDeleteException.class %>" message="can-not-delete-pml-do-quan-trong" />
<%
	BookRecordSearch recordSearch = new BookRecordSearch(renderRequest, portletURLSoBook);
	BookRecordDisplayTerms searchTerms = (BookRecordDisplayTerms)recordSearch.getSearchTerms();
%>
	<liferay-ui:search-form
		page="/html/portlet/ext/documentrecord/socongvandi_search.jsp"
		searchContainer="<%= recordSearch %>" />
<%
	// URL add
	PortletURL addAgencyURL = renderResponse.createRenderURL();
	addAgencyURL.setWindowState(WindowState.NORMAL);
	addAgencyURL.setParameter("struts_action", "/sgs/documentrecord/addscvdi");
	addAgencyURL.setParameter(Constants.CMD, Constants.ADD);
	addAgencyURL.setParameter("typeAgenCVDi", "agency");
	addAgencyURL.setParameter("tabCVDi", tabCVDi);
	addAgencyURL.setParameter("tabs", tabs);
	addAgencyURL.setParameter("redirect", recordSearch.getIteratorURL().toString());
%>
	<span onclick="javascript:submitForm(document.hrefFm,'<%= addAgencyURL %>');">
		<input type="button" name="<portlet:namespace/>add" value="<liferay-ui:message key='add-so-cong-van-di'/>">
	</span>
<%
	int total = 0;
	List<PmlEdmBookDocumentSend> results = new ArrayList<PmlEdmBookDocumentSend>();
	
	if (searchTerms.isAdvancedSearch()) {
		results = PmlEdmBookDocumentSendLocalServiceUtil.searchSoCongVanDiSo(searchTerms.getLoaiSoCV(), searchTerms.getSoPB(),searchTerms.isAndOperator(),
								recordSearch.getStart(), recordSearch.getEnd(), recordSearch.getOrderByComparator());
	} else {
		results = PmlEdmBookDocumentSendLocalServiceUtil.searchSoCongVanDiSo(searchTerms.getKeywords(),recordSearch.getStart(), 
								recordSearch.getEnd(), recordSearch.getOrderByComparator());
	}
	recordSearch.setResults(results);
	
	if (searchTerms.isAdvancedSearch()) {
		total = PmlEdmBookDocumentSendLocalServiceUtil.searchCountSoCongVanDiSo(searchTerms.getLoaiSoCV(), searchTerms.getSoPB(),searchTerms.isAndOperator());
	} else {
		total = PmlEdmBookDocumentSendLocalServiceUtil.searchCountSoCongVanDiSo(searchTerms.getKeywords());
	}
	recordSearch.setTotal(total);
	
	portletURLSoBook.setParameter(recordSearch.getCurParam(), String.valueOf(recordSearch.getCurValue()));

%>
<%
 	List resultRows = recordSearch.getResultRows();
	ResultRow row = null;
	PmlEdmBookDocumentSend bookDocumentSend = null;
	String update = "";
	String delete = "";
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	
	for (int i=0; i< results.size(); i++) {
		bookDocumentSend = results.get(i);
		bookDocumentSend = bookDocumentSend.toEscapedModel();
		row =  new ResultRow(bookDocumentSend, bookDocumentSend.getBookDocumentSendId(), i);
		
		PmlEdmDocumentRecordType documentRecordType = null;
		Agency agency = null;
		
		//URL update
		PortletURL rowURLEdit = renderResponse.createRenderURL();
		rowURLEdit.setWindowState(WindowState.NORMAL);
		rowURLEdit.setParameter("struts_action","/sgs/documentrecord/addscvdi");
		rowURLEdit.setParameter(Constants.CMD,Constants.EDIT);
		rowURLEdit.setParameter("bookRecordSendId",String.valueOf(bookDocumentSend.getBookDocumentSendId()));
		rowURLEdit.setParameter("redirect", recordSearch.getIteratorURL().toString());
		rowURLEdit.setParameter("tabCVDi",tabCVDi);
		rowURLEdit.setParameter("tabs",tabs);
		rowURLEdit.setParameter("typeAgenCVDi","agency");
		
		//URL delete
		PortletURL rowURLDelete = renderResponse.createActionURL();
		rowURLDelete.setWindowState(WindowState.NORMAL);
		rowURLDelete.setParameter("struts_action","/sgs/documentrecord/addscvdi");
		rowURLDelete.setParameter(Constants.CMD,Constants.DELETE);
		rowURLDelete.setParameter("bookRecordSendId",String.valueOf(bookDocumentSend.getBookDocumentSendId()));
		rowURLDelete.setParameter("redirect", recordSearch.getIteratorURL().toString());
		rowURLDelete.setParameter("tabCVDi",tabCVDi);
		rowURLDelete.setParameter("tabs",tabs);
		
		update = "<a href='"+ rowURLEdit.toString()+"'><img src='/html/images/edit.png' />&nbsp;</a>";
		delete = "<a  href='javascript: ;' onclick=deleteBookRecordPB('"+ rowURLDelete.toString() +"')><u>"+ "<img src='/html/images/delete.png'/>" +"</u></a>";
		
		//stt
		row.addText(String.valueOf(i+1));
		
		//loai cong van
		try {
			documentRecordType = PmlEdmDocumentRecordTypeUtil.fetchByPrimaryKey(bookDocumentSend.getDocumentRecordTypeId());
		} catch (Exception e) {
			
		}
		
		if ( null!=  documentRecordType) {
			row.addText(documentRecordType.getDocumentRecordTypeName());
		} else {
			row.addText("");
		}
		
		//cong van cua so
		try {
			agency = AgencyUtil.fetchByPrimaryKey(bookDocumentSend.getAgencyId());
		} catch (Exception e) {
			
		}
		
		if ( null!=  agency) {
			row.addText(agency.getAgencyName());
		} else {
			row.addText("");
		}
		
		//ngay tao
		if ( null != bookDocumentSend.getDateCreated()) {
			row.addText(dateFormat.format(bookDocumentSend.getDateCreated()));
		} else {
			row.addText("");
		}
		
		// nam
		row.addText(bookDocumentSend.getYearInUse());
		
		// so hien tai
		row.addText(String.valueOf(bookDocumentSend.getCurrentRecord()));
				//edit
		row.addText(update);
		
		//delete
		row.addText(delete);
		
		resultRows.add(row);
	}
%>
<liferay-ui:search-iterator searchContainer="<%=recordSearch %>" />
</form>
