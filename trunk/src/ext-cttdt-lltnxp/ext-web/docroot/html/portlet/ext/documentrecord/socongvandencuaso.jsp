<%@ include file="/html/portlet/ext/documentrecord/init.jsp" %>
<%@page import="javax.portlet.WindowState"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.util.portlet.PortletProps"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>

<%@page import="com.sgs.portlet.documentrecord.search.DocumentRecordSearch"%>
<%@page import="com.sgs.portlet.documentrecord.search.DocumentRecordSearchTerms"%>
<%@page import="com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo"%>
<%@page import="com.sgs.portlet.document.receipt.service.PmlEdmDocumentRecordToLocalServiceUtil"%>
<%@page import="com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType"%>
<%@page import="com.sgs.portlet.agency.model.Agency"%>
<%@page import="com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentRecordTypeUtil"%>
<%@page import="com.sgs.portlet.agency.service.persistence.AgencyUtil"%>
<%@page import="com.sgs.portlet.document.receipt.PmlEdmDocumentRecordToCanNotDeleteException"%>

<script type="text/javascript">

	function deleteDocumentRecordSo(url) {		
		if (confirm("<liferay-ui:message key='sgs_field_deleteMessage'/>" )) {
			document.<portlet:namespace />fm.method = "post";
			submitForm(document.<portlet:namespace />fm, url);
		}
	}

</script>

<%
	tabCVDens = ParamUtil.getString(renderRequest, "tabCVDens","so");
	tabs = ParamUtil.getString(renderRequest, "tabs","socongvanden");
	PortletURL portletURLSo = renderResponse.createRenderURL();

	portletURLSo.setWindowState(WindowState.NORMAL);
	portletURLSo.setParameter("struts_action", "/sgs/documentrecord/view");
	portletURLSo.setParameter("tabCVDens",tabCVDens);
	portletURLSo.setParameter("tabs",tabs);
	
	String soURLString = portletURLSo.toString();
%>

<form action="<%= soURLString %>" method="post" name="<portlet:namespace/>fm">
	<input name="<portlet:namespace />documentRecordToURL" type="hidden" value="<%= soURLString %>" />
	<liferay-ui:error exception="<%= PmlEdmDocumentRecordToCanNotDeleteException.class %>" message="can-not-delete-pml-do-quan-trong" />

<%
	DocumentRecordSearch recordSearch = new DocumentRecordSearch(renderRequest, portletURLSo);
	DocumentRecordSearchTerms searchTerms = (DocumentRecordSearchTerms)recordSearch.getSearchTerms();
%>
	<liferay-ui:search-form
		page="/html/portlet/ext/documentrecord/socongvanden_search.jsp"
		searchContainer="<%= recordSearch %>" />
<%
	// URL add
	PortletURL addAgencyURL = renderResponse.createRenderURL();
	addAgencyURL.setWindowState(WindowState.NORMAL);
	addAgencyURL.setParameter("struts_action", "/sgs/documentrecord/addscvden");
	addAgencyURL.setParameter(Constants.CMD,Constants.ADD);
	addAgencyURL.setParameter("typeAgen", "agency");
	addAgencyURL.setParameter("tabCVDens", tabCVDens);
	addAgencyURL.setParameter("tabs", tabs);
	addAgencyURL.setParameter("redirect", recordSearch.getIteratorURL().toString());
%>
	<span onclick="javascript:submitForm(document.hrefFm,'<%= addAgencyURL %>');">
		<input type="button" name="<portlet:namespace/>add" value="<liferay-ui:message key='add-so-cong-van-den'/>">
	</span>
<%
	int total = 0;
	List<PmlEdmDocumentRecordTo> results = new ArrayList<PmlEdmDocumentRecordTo>();
	
	if (searchTerms.isAdvancedSearch()) {
		results = PmlEdmDocumentRecordToLocalServiceUtil.searchSoCongVanDenSo(searchTerms.getLoaiSoCV(), searchTerms.getSoPB(),searchTerms.isAndOperator(),
								recordSearch.getStart(), recordSearch.getEnd(), recordSearch.getOrderByComparator());
	} else {
		results = PmlEdmDocumentRecordToLocalServiceUtil.searchSoCongVanDenSo(searchTerms.getKeywords(),recordSearch.getStart(), 
								recordSearch.getEnd(), recordSearch.getOrderByComparator());
	}
	recordSearch.setResults(results);
	
	if (searchTerms.isAdvancedSearch()) {
		total = PmlEdmDocumentRecordToLocalServiceUtil.searchCountSoCongVanDenSo(searchTerms.getLoaiSoCV(), searchTerms.getSoPB(),searchTerms.isAndOperator());
	} else {
		total = PmlEdmDocumentRecordToLocalServiceUtil.searchCountSoCongVanDenSo(searchTerms.getKeywords());
	}
	recordSearch.setTotal(total);
	
	portletURLSo.setParameter(recordSearch.getCurParam(), String.valueOf(recordSearch.getCurValue()));

%>
<%
 	List resultRows = recordSearch.getResultRows();
	ResultRow row = null;
	PmlEdmDocumentRecordTo documentRecordTo = null;
	String update = "";
	String delete = "";
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	
	for (int i=0; i< results.size(); i++) {
		documentRecordTo = results.get(i);
		documentRecordTo = documentRecordTo.toEscapedModel();
		row =  new ResultRow(documentRecordTo, documentRecordTo.getDocumentRecordToId(), i);
		
		PmlEdmDocumentRecordType documentRecordType = null;
		Agency agency = null;
		
		//URL update
		PortletURL rowURLEdit = renderResponse.createRenderURL();
		rowURLEdit.setWindowState(WindowState.NORMAL);
		rowURLEdit.setParameter("struts_action","/sgs/documentrecord/addscvden");
		rowURLEdit.setParameter(Constants.CMD,Constants.EDIT);
		rowURLEdit.setParameter("documentRecordToId",String.valueOf(documentRecordTo.getDocumentRecordToId()));
		rowURLEdit.setParameter("redirect", recordSearch.getIteratorURL().toString());
		rowURLEdit.setParameter("tabCVDens",tabCVDens);
		rowURLEdit.setParameter("tabs",tabs);
		rowURLEdit.setParameter("typeAgen","agency");
		
		//URL delete
		PortletURL rowURLDelete = renderResponse.createActionURL();
		rowURLDelete.setWindowState(WindowState.NORMAL);
		rowURLDelete.setParameter("struts_action","/sgs/documentrecord/addscvden");
		rowURLDelete.setParameter(Constants.CMD,Constants.DELETE);
		rowURLDelete.setParameter("documentRecordToId",String.valueOf(documentRecordTo.getDocumentRecordToId()));
		rowURLDelete.setParameter("redirect", recordSearch.getIteratorURL().toString());
		rowURLDelete.setParameter("tabCVDens",tabCVDens);
		rowURLDelete.setParameter("tabs",tabs);
		
		update = "<a href='"+ rowURLEdit.toString()+"'><img src='/html/images/edit.png' />&nbsp;</a>";
		delete = "<a  href='javascript: ;' onclick=deleteDocumentRecordSo('"+ rowURLDelete.toString() +"')><u>"+ "<img src='/html/images/delete.png'/>" +"</u></a>";
		
		//stt
		row.addText(String.valueOf(i+1));
		
		//loai cong van
		try {
			documentRecordType = PmlEdmDocumentRecordTypeUtil.fetchByPrimaryKey(documentRecordTo.getDocumentRecordTypeId());
		} catch (Exception e) {
			
		}
		
		if ( null!=  documentRecordType) {
			row.addText(documentRecordType.getDocumentRecordTypeName());
		} else {
			row.addText("");
		}
		
		//cong van cua so
		try {
			agency = AgencyUtil.fetchByPrimaryKey(documentRecordTo.getAgencyId());
		} catch (Exception e) {
			
		}
		
		if ( null!=  agency) {
			row.addText(agency.getAgencyName());
		} else {
			row.addText("");
		}
		
		//ngay tao
		if ( null != documentRecordTo.getDateCreate()) {
			row.addText(dateFormat.format(documentRecordTo.getDateCreate()));
		} else {
			row.addText("");
		}
		
		// nam
		row.addText(documentRecordTo.getYearInUse());
		
		// so hien tai
		row.addText(String.valueOf(documentRecordTo.getCurrentRecord()));
		
		//edit
		row.addText(update);
		
		//delete
		row.addText(delete);
		
		resultRows.add(row);
	}
%>
<liferay-ui:search-iterator searchContainer="<%=recordSearch %>" />
</form>
