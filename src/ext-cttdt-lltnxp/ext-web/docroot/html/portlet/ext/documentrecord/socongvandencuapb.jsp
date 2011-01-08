<%@ include file="/html/portlet/ext/documentrecord/init.jsp" %>

<%@page import="javax.portlet.WindowState"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>

<%@page import="com.sgs.portlet.documentrecord.search.DocumentRecordPBSearch"%>
<%@page import="com.sgs.portlet.documentrecord.search.DocumentRecordPBDisplayTerms"%>
<%@page import="com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo"%>
<%@page import="com.sgs.portlet.document.receipt.service.PmlEdmDocumentRecordToLocalServiceUtil"%>
<%@page import="com.sgs.portlet.department.model.Department"%>
<%@page import="com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentRecordTypeUtil"%>
<%@page import="com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType"%>
<%@page import="com.sgs.portlet.department.service.persistence.DepartmentUtil"%>
<%@page import="com.sgs.portlet.document.receipt.PmlEdmDocumentRecordToCanNotDeleteException"%>

<script type="text/javascript">

	function deleteDocumentRecordPB(url) {		
		if (confirm("<liferay-ui:message key='sgs_field_deleteMessage'/>" )) {
			document.<portlet:namespace />fm.method = "post";
			submitForm(document.<portlet:namespace />fm, url);
		}
	}

</script>

<%
	tabCVDens = ParamUtil.getString(renderRequest, "tabCVDens","phongban");
	tabs = ParamUtil.getString(renderRequest, "tabs","socongvanden");
	
	PortletURL portletURLPB = renderResponse.createRenderURL();

	portletURLPB.setWindowState(WindowState.NORMAL);
	portletURLPB.setParameter("struts_action", "/sgs/documentrecord/view");
	portletURLPB.setParameter("tabCVDens",tabCVDens);
	portletURLPB.setParameter("tabs",tabs);
	
	String pbURLString = portletURLPB.toString();
%>

<form action="<%= pbURLString %>" method="post" name="<portlet:namespace/>fm">
	<input name="<portlet:namespace />documentRecordToURL" type="hidden" value="<%= pbURLString %>" />
	<liferay-ui:error exception="<%= PmlEdmDocumentRecordToCanNotDeleteException.class %>" message="can-not-delete-pml-do-quan-trong" />
<%
	DocumentRecordPBSearch recordSearchPB = new DocumentRecordPBSearch(renderRequest, portletURLPB);
	DocumentRecordPBDisplayTerms searchTermsPB = (DocumentRecordPBDisplayTerms)recordSearchPB.getSearchTerms();
%>
	<liferay-ui:search-form
		page="/html/portlet/ext/documentrecord/socongvandenpb_search.jsp"
		searchContainer="<%= recordSearchPB %>" />
		
<%
	// URL add
	PortletURL addDepartmentURL = renderResponse.createRenderURL();
	addDepartmentURL.setWindowState(WindowState.NORMAL);
	addDepartmentURL.setParameter("struts_action", "/sgs/documentrecord/addscvden");
	addDepartmentURL.setParameter(Constants.CMD,Constants.ADD);
	addDepartmentURL.setParameter("typeAgen", "department");
	addDepartmentURL.setParameter("tabCVDens", tabCVDens);
	addDepartmentURL.setParameter("tabs", tabs);
	addDepartmentURL.setParameter("redirect", recordSearchPB.getIteratorURL().toString());
%>
	<span onclick="javascript:submitForm(document.hrefFm,'<%= addDepartmentURL %>');">
		<input type="button" name="<portlet:namespace/>add" value="<liferay-ui:message key='add-so-cong-van-den'/>">
	</span>
	
<%
	int totalPB = 0;
	List<PmlEdmDocumentRecordTo> resultsPB = new ArrayList<PmlEdmDocumentRecordTo>();
	
	if (searchTermsPB.isAdvancedSearch()) {
		resultsPB = PmlEdmDocumentRecordToLocalServiceUtil.searchSoCongVanDenPB(searchTermsPB.getLoaiSoCV(), searchTermsPB.getSoPB(),searchTermsPB.isAndOperator(),
								recordSearchPB.getStart(), recordSearchPB.getEnd(), recordSearchPB.getOrderByComparator());
	} else {
		resultsPB = PmlEdmDocumentRecordToLocalServiceUtil.searchSoCongVanDenPB(searchTermsPB.getKeywords(),recordSearchPB.getStart(), 
								recordSearchPB.getEnd(), recordSearchPB.getOrderByComparator());
	}
	recordSearchPB.setResults(resultsPB);
	
	if (searchTermsPB.isAdvancedSearch()) {
		totalPB = PmlEdmDocumentRecordToLocalServiceUtil.searchCountSoCongVanDenPB(searchTermsPB.getLoaiSoCV(), searchTermsPB.getSoPB(),searchTermsPB.isAndOperator());
	} else {
		totalPB = PmlEdmDocumentRecordToLocalServiceUtil.searchCountSoCongVanDenPB(searchTermsPB.getKeywords());
	}
	recordSearchPB.setTotal(totalPB);
	
	portletURLPB.setParameter(recordSearchPB.getCurParam(), String.valueOf(recordSearchPB.getCurValue()));

%>
<%
 	List resultRowsPB = recordSearchPB.getResultRows();
	ResultRow rowPB = null;
	PmlEdmDocumentRecordTo documentRecordToPB = null;
	String update = "";
	String delete = "";
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	
	for (int i=0; i< resultsPB.size(); i++) {
		documentRecordToPB = resultsPB.get(i);
		documentRecordToPB = documentRecordToPB.toEscapedModel();
		rowPB =  new ResultRow(documentRecordToPB, documentRecordToPB.getDocumentRecordToId(), i);
		
		PmlEdmDocumentRecordType documentRecordType = null;
		Department department = null;
		
		//URL update
		PortletURL rowURLEditPB = renderResponse.createRenderURL();
		rowURLEditPB.setWindowState(WindowState.NORMAL);
		rowURLEditPB.setParameter("struts_action","/sgs/documentrecord/addscvden");
		rowURLEditPB.setParameter(Constants.CMD,Constants.EDIT);
		rowURLEditPB.setParameter("documentRecordToId",String.valueOf(documentRecordToPB.getDocumentRecordToId()));
		rowURLEditPB.setParameter("redirect", recordSearchPB.getIteratorURL().toString());
		rowURLEditPB.setParameter("tabCVDens",tabCVDens);
		rowURLEditPB.setParameter("tabs",tabs);
		rowURLEditPB.setParameter("typeAgen","department");
		
		//URL delete
		PortletURL rowURLDeletePB = renderResponse.createActionURL();
		rowURLDeletePB.setWindowState(WindowState.NORMAL);
		rowURLDeletePB.setParameter("struts_action","/sgs/documentrecord/addscvden");
		rowURLDeletePB.setParameter(Constants.CMD,Constants.DELETE);
		rowURLDeletePB.setParameter("documentRecordToId",String.valueOf(documentRecordToPB.getDocumentRecordToId()));
		rowURLDeletePB.setParameter("redirect", recordSearchPB.getIteratorURL().toString());
		rowURLDeletePB.setParameter("tabCVDens",tabCVDens);
		rowURLDeletePB.setParameter("tabs",tabs);
		
		update = "<a href='"+ rowURLEditPB.toString()+"'><img src='/html/images/edit.png' />&nbsp;</a>";
		delete = "<a  href='javascript: ;' onclick=deleteDocumentRecordPB('"+ rowURLDeletePB.toString() +"')><u>"+ "<img src='/html/images/delete.png'/>" +"</u></a>";
		
		//stt
		rowPB.addText(String.valueOf(i+1));
		
		//loai cong van
		try {
			documentRecordType = PmlEdmDocumentRecordTypeUtil.fetchByPrimaryKey(documentRecordToPB.getDocumentRecordTypeId());
		} catch (Exception e) {
			
		}
		
		if ( null!=  documentRecordType) {
			rowPB.addText(documentRecordType.getDocumentRecordTypeName());
		} else {
			rowPB.addText("");
		}
		
		//cong van cua phong ban
		try {
			department = DepartmentUtil.fetchByPrimaryKey(documentRecordToPB.getDepartmentsId());
		} catch (Exception e) {
			
		}
		
		if ( null!=  department) {
			rowPB.addText(department.getDepartmentsName());
		} else {
			rowPB.addText("");
		}
		
		//ngay tao
		if ( null != documentRecordToPB.getDateCreate()) {
			rowPB.addText(dateFormat.format(documentRecordToPB.getDateCreate()));
		} else {
			rowPB.addText("");
		}
		
		// nam
		rowPB.addText(documentRecordToPB.getYearInUse());
		
		// so hien tai
		rowPB.addText(String.valueOf(documentRecordToPB.getCurrentRecord()));
		
		//edit
		rowPB.addText(update);
		
		//delete
		rowPB.addText(delete);
		
		resultRowsPB.add(rowPB);
	}
%>
<liferay-ui:search-iterator searchContainer="<%=recordSearchPB %>" />
</form>
