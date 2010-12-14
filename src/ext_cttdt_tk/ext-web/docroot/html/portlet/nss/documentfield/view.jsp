<%@ include file="/html/portlet/nss/documentfield/init.jsp" %>

<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>

<%@page import="com.nss.portlet.documentfield.FieldCanNotDeleteException"%>
<%@page import="java.util.List"%>
<%@page import="com.nss.portlet.documentfield.model.PmlField"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.nss.portlet.documentfield.service.PmlFieldLocalServiceUtil"%>
<%@page import="com.nss.portlet.documentfield.search.PmlFieldSearchTerms"%>
<%@page import="com.nss.portlet.department.service.DepartmentLocalServiceUtil"%>
<%@page import="com.nss.portlet.documentfield.search.PmlFieldSearch"%>

<script type="text/javascript">

function deleteField(url) {		
	if (confirm("<liferay-ui:message key='sgs_field_deleteMessage'/>" )) {
		document.<portlet:namespace />fm.method = "post";
		submitForm(document.<portlet:namespace />fm, url);
	}
}

</script>

<%
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action", "/nss/documentfield/view");
%>

<form action="<%= portletURL.toString() %>"  method="post" name="<portlet:namespace />fm" onSubmit="submitForm(this); return false;">
	<input name="<portlet:namespace />fieldURL" type="hidden" value="<%= portletURL.toString() %>" />
	<liferay-ui:error exception="<%= FieldCanNotDeleteException.class %>" message="can-not-delete-field" />
	<div class="commom-form">
	<div class="parent-title"><liferay-ui:message key="javax.portlet.title.NSS_DOCUMENTFIELD"/></div>
	<%
		PmlFieldSearch fieldSearch = new PmlFieldSearch(renderRequest, portletURL);
		PmlFieldSearchTerms searchTerms = (PmlFieldSearchTerms)fieldSearch.getSearchTerms();
	%>
	
	<liferay-ui:search-form
		page="/html/portlet/nss/documentfield/search_form.jsp"
		searchContainer="<%= fieldSearch %>" />
	
	     
	<%
		List<PmlField> results = new ArrayList<PmlField>();
		int total = 0;
		
		if (searchTerms.isAdvancedSearch()) {
			results = PmlFieldLocalServiceUtil.search(searchTerms.getMaPhanLoai(), 
					searchTerms.getTenPhanLoai(), searchTerms.isAndOperator(), fieldSearch.getStart(), 
					fieldSearch.getEnd(), fieldSearch.getOrderByComparator());
			
			total = PmlFieldLocalServiceUtil.searchCount(searchTerms.getMaPhanLoai(),
					searchTerms.getTenPhanLoai(), searchTerms.isAndOperator());
		}
		else {
			results = PmlFieldLocalServiceUtil.search(searchTerms.getKeywords(), fieldSearch.getStart(),
					fieldSearch.getEnd(), fieldSearch.getOrderByComparator());
			
			total = PmlFieldLocalServiceUtil.searchCount(searchTerms.getKeywords());
		}
		
		fieldSearch.setTotal(total);
		
		fieldSearch.setResults(results);
		
		portletURL.setParameter(fieldSearch.getCurParam(), String.valueOf(fieldSearch.getCurValue()));
	%>
	
	<portlet:renderURL var="add" >
		<portlet:param name="struts_action" value="/nss/documentfield/add"/>
		<portlet:param name="redirect" value="<%= fieldSearch.getIteratorURL().toString() %>"/>
	</portlet:renderURL>
		
	<span onclick="javascript:submitForm(document.hrefFm,'<%= add %>');" ><input class="button-width" type="button" value='<liferay-ui:message key="them-moi" />' ></span>
	<br><br>  
	
	<%
		List resultRows = fieldSearch.getResultRows();
	
		ResultRow row = null;	
		PmlField field = null;
		String fieldId = "";	
		String departmentName = "";
		
		String editURL = "";
		String deleteURL = "";
		for (int i = 0; i < results.size(); i ++) {
			field = results.get(i);
			fieldId = field.getFieldId();
			
			row = new ResultRow(field, fieldId, i);
			
			// STT
			row.addText(String.valueOf(i + 1));
			
			
			// ma phan loai
			row.addText(field.getFieldCode());
			
			// ten phan loai
			row.addText(field.getFieldName());
			
			// don vi phu trach
			try {
				departmentName = DepartmentLocalServiceUtil.getDepartment(field.getDepartmentsId()).getDepartmentsName();
			} catch (Exception e) {
				
			}
			row.addText(departmentName);
			
			// mo ta
			
			row.addText(field.getDescription());
			
			// sua		
			
			PortletURL rowURLEdit = renderResponse.createRenderURL();
			rowURLEdit.setWindowState(WindowState.NORMAL);
			rowURLEdit.setParameter("struts_action", "/nss/documentfield/edit");
			rowURLEdit.setParameter(Constants.CMD, Constants.EDIT);
			rowURLEdit.setParameter("fieldId", String.valueOf(fieldId));
			rowURLEdit.setParameter("redirect",  fieldSearch.getIteratorURL().toString());
			editURL = "<a  href='" + rowURLEdit.toString() + "'><u>" + "<img src='/html/images/edit.png'/>" + "</u></a>";
			
			row.addText(editURL);
			
			// xoa		
			PortletURL rowURLDelete = renderResponse.createActionURL();
			rowURLDelete.setWindowState(WindowState.NORMAL);
			rowURLDelete.setParameter("struts_action", "/nss/documentfield/view");
			rowURLDelete.setParameter(Constants.CMD, Constants.DELETE);
			rowURLDelete.setParameter("fieldId", String.valueOf(fieldId));
			rowURLDelete.setParameter("redirect",  fieldSearch.getIteratorURL().toString());
			
			deleteURL = "<a  href='javascript: ;'  onclick=deleteField('"+ rowURLDelete.toString() +"')><u>"+ "<img src='/html/images/delete.png'/>" +"</u></a>";
			
			row.addText(deleteURL);
			
			resultRows.add(row);
		}
		
	%>
	
	<liferay-ui:search-iterator searchContainer="<%= fieldSearch %>" />
</div>
</form>


