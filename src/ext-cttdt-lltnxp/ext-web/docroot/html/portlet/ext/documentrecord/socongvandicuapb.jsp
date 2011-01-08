<%@ include file="/html/portlet/ext/documentrecord/init.jsp" %>

<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="java.text.SimpleDateFormat"%>

<%@page import="com.sgs.portlet.documentrecord.search.BookRecordPBSearch"%>
<%@page import="com.sgs.portlet.documentrecord.search.BookRecordPBDisplayTerms"%>
<%@page import="com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend"%>
<%@page import="com.sgs.portlet.document.send.service.PmlEdmBookDocumentSendLocalServiceUtil"%>
<%@page import="com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType"%>
<%@page import="com.sgs.portlet.department.model.Department"%>
<%@page import="com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentRecordTypeUtil"%>
<%@page import="com.sgs.portlet.department.service.persistence.DepartmentUtil"%>
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
	tabCVDi = ParamUtil.getString(renderRequest, "tabCVDi","phongban");
	tabs = ParamUtil.getString(renderRequest, "tabs","socongvandi");
	
	PortletURL portletURLPBBook = renderResponse.createRenderURL();

	portletURLPBBook.setWindowState(WindowState.NORMAL);
	portletURLPBBook.setParameter("struts_action", "/sgs/documentrecord/view");
	portletURLPBBook.setParameter("tabCVDi",tabCVDi);
	portletURLPBBook.setParameter("tabs",tabs);
	String pbURLBookString = portletURLPBBook.toString();
%>
<form action="<%= pbURLBookString %>" method="post" name="<portlet:namespace/>fm">
	<input name="<portlet:namespace />bookRecordURL" type="hidden" value="<%= pbURLBookString %>" />
	<liferay-ui:error exception="<%= PmlEdmBookDocumentSendCanNotDeleteException.class %>" message="can-not-delete-pml-do-quan-trong" />
<%
	BookRecordPBSearch recordSearchPB = new BookRecordPBSearch(renderRequest, portletURLPBBook);
	BookRecordPBDisplayTerms searchTermsPB = (BookRecordPBDisplayTerms)recordSearchPB.getSearchTerms();
%>
	<liferay-ui:search-form
			page="/html/portlet/ext/documentrecord/socongvandipb_search.jsp"
			searchContainer="<%= recordSearchPB %>" />

<%
	// URL add
	PortletURL addDepartmentURL = renderResponse.createRenderURL();
	addDepartmentURL.setWindowState(WindowState.NORMAL);
	addDepartmentURL.setParameter("struts_action", "/sgs/documentrecord/addscvdi");
	addDepartmentURL.setParameter(Constants.CMD, Constants.ADD);
	addDepartmentURL.setParameter("typeAgenCVDi", "department");
	addDepartmentURL.setParameter("tabCVDi", tabCVDi);
	addDepartmentURL.setParameter("tabs", tabs);
	addDepartmentURL.setParameter("redirect", recordSearchPB.getIteratorURL().toString());
%>
	<span onclick="javascript:submitForm(document.hrefFm,'<%= addDepartmentURL %>');">
		<input type="button" name="<portlet:namespace/>add" value="<liferay-ui:message key='add-so-cong-van-di'/>">
	</span>
	
<%
	int totalPB = 0;
	List<PmlEdmBookDocumentSend> resultsPB = new ArrayList<PmlEdmBookDocumentSend>();
	if (searchTermsPB.isAdvancedSearch()) {
		resultsPB = PmlEdmBookDocumentSendLocalServiceUtil.searchSoCongVanDiPB(searchTermsPB.getLoaiSoCV(), searchTermsPB.getSoPB(),searchTermsPB.isAndOperator(),
								recordSearchPB.getStart(), recordSearchPB.getEnd(), recordSearchPB.getOrderByComparator());
	} else {
		resultsPB = PmlEdmBookDocumentSendLocalServiceUtil.searchSoCongVanDiPB(searchTermsPB.getKeywords(),recordSearchPB.getStart(), 
								recordSearchPB.getEnd(), recordSearchPB.getOrderByComparator());
	}
	recordSearchPB.setResults(resultsPB);
	
	if (searchTermsPB.isAdvancedSearch()) {
		totalPB = PmlEdmBookDocumentSendLocalServiceUtil.searchCountSoCongVanDiPB(searchTermsPB.getLoaiSoCV(), searchTermsPB.getSoPB(),searchTermsPB.isAndOperator());
	} else {
		totalPB = PmlEdmBookDocumentSendLocalServiceUtil.searchCountSoCongVanDiPB(searchTermsPB.getKeywords());
	}
	recordSearchPB.setTotal(totalPB);
	
	portletURLPBBook.setParameter(recordSearchPB.getCurParam(), String.valueOf(recordSearchPB.getCurValue()));
%>
<%
 	List resultRowsPB = recordSearchPB.getResultRows();
	ResultRow rowPB = null;
	PmlEdmBookDocumentSend bookDocumentSend = null;
	String update = "";
	String delete = "";
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	
	for (int i=0; i< resultsPB.size(); i++) {
		bookDocumentSend = resultsPB.get(i);
		bookDocumentSend = bookDocumentSend.toEscapedModel();
		rowPB =  new ResultRow(bookDocumentSend, bookDocumentSend.getBookDocumentSendId(), i);
		
		PmlEdmDocumentRecordType documentRecordType = null;
		Department department = null;
		
		//URL update
		PortletURL rowURLEdit = renderResponse.createRenderURL();
		rowURLEdit.setWindowState(WindowState.NORMAL);
		rowURLEdit.setParameter("struts_action","/sgs/documentrecord/addscvdi");
		rowURLEdit.setParameter(Constants.CMD,Constants.EDIT);
		rowURLEdit.setParameter("bookRecordSendId",String.valueOf(bookDocumentSend.getBookDocumentSendId()));
		rowURLEdit.setParameter("redirect", recordSearchPB.getIteratorURL().toString());
		rowURLEdit.setParameter("tabCVDi",tabCVDi);
		rowURLEdit.setParameter("tabs",tabs);
		rowURLEdit.setParameter("typeAgenCVDi","department");
		
		//URL delete
		PortletURL rowURLDelete = renderResponse.createActionURL();
		rowURLDelete.setWindowState(WindowState.NORMAL);
		rowURLDelete.setParameter("struts_action","/sgs/documentrecord/addscvdi");
		rowURLDelete.setParameter(Constants.CMD, Constants.DELETE);
		rowURLDelete.setParameter("bookRecordSendId",String.valueOf(bookDocumentSend.getBookDocumentSendId()));
		rowURLDelete.setParameter("redirect", recordSearchPB.getIteratorURL().toString());
		rowURLDelete.setParameter("tabCVDi",tabCVDi);
		rowURLDelete.setParameter("tabs",tabs);
		
		update = "<a href='"+ rowURLEdit.toString()+"'><img src='/html/images/edit.png' />&nbsp;</a>";
		delete = "<a  href='javascript: ;' onclick=deleteBookRecordPB('"+ rowURLDelete.toString() +"')><u>"+ "<img src='/html/images/delete.png'/>" +"</u></a>";
		
		//stt
		rowPB.addText(String.valueOf(i+1));
		
		//loai cong van
		try {
			documentRecordType = PmlEdmDocumentRecordTypeUtil.fetchByPrimaryKey(bookDocumentSend.getDocumentRecordTypeId());
		} catch (Exception e) {
			
		}
		
		if ( null!=  documentRecordType) {
			rowPB.addText(documentRecordType.getDocumentRecordTypeName());
		} else {
			rowPB.addText("");
		}
		
		//cong van cua phong ban
		try {
			department = DepartmentUtil.fetchByPrimaryKey(bookDocumentSend.getDepartmentsId());
		} catch (Exception e) {
			
		}
		
		if ( null!=  department) {
			rowPB.addText(department.getDepartmentsName());
		} else {
			rowPB.addText("");
		}
		
		//ngay tao
		if ( null != bookDocumentSend.getDateCreated()) {
			rowPB.addText(dateFormat.format(bookDocumentSend.getDateCreated()));
		} else {
			rowPB.addText("");
		}
		
		// nam
		rowPB.addText(bookDocumentSend.getYearInUse());
		
		// so hien tai
		rowPB.addText(String.valueOf(bookDocumentSend.getCurrentRecord()));
		
		//edit
		rowPB.addText(update);
		
		//delete
		rowPB.addText(delete);
		
		resultRowsPB.add(rowPB);
	}
%>
	<liferay-ui:search-iterator searchContainer="<%=recordSearchPB %>" />
</form>
</div>
