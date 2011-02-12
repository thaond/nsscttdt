<%@page import="com.ext.portal.util.PortletKeysExt" %>
<%@page import="com.ext.portal.util.WebKeysExt"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="com.sgs.portlet.pml_edm_docconfuser.service.PmlEdmDocConfUserLocalServiceUtil"%>
<%@page import="com.sgs.portlet.pml_edm_docconfuser.model.PmlEdmDocConfUser"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.sgs.portlet.department.model.Department"%>
<%@page import="com.sgs.portlet.department.service.DepartmentLocalServiceUtil"%>
<%@ include file="/html/portlet/ext/pml_edm_docconfuser/init.jsp" %>

<%
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action", "/sgs/pml_edm_docconfuser/view");

	// Get the list of all user
	long companyId = themeDisplay.getCompanyId(); 
	List<com.liferay.portal.model.User> users = PmlEdmDocConfUserLocalServiceUtil.getUserByCompany(companyId);
	ArrayList<Long> userIds = new ArrayList<Long>();
	ArrayList<String> userNames = new ArrayList<String>();
	for (int idx = 0; idx < (users != null ? users.size() : 0); idx++) {
		com.liferay.portal.model.User userTmp = (com.liferay.portal.model.User) users.get(idx);
		userIds.add(userTmp.getUserId());
		userNames.add(userTmp.getLastName() + " " + userTmp.getMiddleName() + " " + userTmp.getFirstName());
	}
	
	// Get the list of all department
	List<Department> departments = DepartmentLocalServiceUtil.findAll();
	ArrayList<String> departmentIds = new ArrayList<String>();
	ArrayList<String> departmentNames = new ArrayList<String>();
	for (int idx = 0; idx < (departments == null ? 0 : departments.size()); idx++) {
		Department departmentTmp = (Department) departments.get(idx);
		departmentIds.add(departmentTmp.getDepartmentsId());
		departmentNames.add(departmentTmp.getDepartmentsName());
	}
	
	List<String> headerNames = new ArrayList<String>();
	// Add header column
	//headerNames.add("order-no");
	headerNames.add("STT");
	headerNames.add("user-name");
	headerNames.add("view-all");
	headerNames.add("view-document-of-department");
	headerNames.add(StringPool.BLANK);
	headerNames.add(StringPool.BLANK);

	SearchContainer searchContainer = new SearchContainer(renderRequest, new DisplayTerms(renderRequest), new DisplayTerms(renderRequest), SearchContainer.DEFAULT_CUR_PARAM, SearchContainer.DEFAULT_DELTA, portletURL, headerNames, "have-no-items"); 

	int total = PmlEdmDocConfUserLocalServiceUtil.countAll();
	searchContainer.setTotal(total);
	
	List results = PmlEdmDocConfUserLocalServiceUtil.findAll(searchContainer.getStart(), searchContainer.getEnd(), null);
	searchContainer.setResults(results);
	
	List resultRows = searchContainer.getResultRows();
	
	for (int idx = 0; idx < (results == null ? 0 : results.size()); idx++) {
		// Get item
		PmlEdmDocConfUser docConfUserItem = (PmlEdmDocConfUser) results.get(idx);
		
		ResultRow row = new ResultRow(docConfUserItem, docConfUserItem.getDcuId(), idx);
		
		PortletURL rowURL = renderResponse.createRenderURL();

		rowURL.setWindowState(WindowState.NORMAL);
	
		rowURL.setParameter("struts_action", "/sgs/pml_edm_docconfuser/edit");
		rowURL.setParameter("redirect", currentURL );
		rowURL.setParameter("dcuId", String.valueOf(docConfUserItem.getDcuId()));
		
		// Order no
		row.addText(String.valueOf(idx + 1));
		
		// User name
		String userNameAdd = "";
		if (userIds.contains(docConfUserItem.getUserId())) {
			userNameAdd = String.valueOf(userNames.get(userIds.indexOf(docConfUserItem.getUserId())));
		}
		row.addText(userNameAdd);
		
		// View all
		row.addText(String.valueOf(docConfUserItem.getViewAllDoc()));
		
		// View document of department
		String departmentNameAdd = "";
		if (docConfUserItem.getViewAllDoc() == false && 
		!docConfUserItem.getViewDepDoc().trim().equals("")) {
			String[] arrViewDepDoc = docConfUserItem.getViewDepDoc().split(",");
			for (int idxDCU = 0; idxDCU < arrViewDepDoc.length; idxDCU++) {
				if (departmentIds.contains(arrViewDepDoc[idxDCU])) {
					departmentNameAdd+= (departmentNameAdd.equals("") ? "" : "<br />") + departmentNames.get(departmentIds.indexOf(arrViewDepDoc[idxDCU]));
				}				
			}
		}
		row.addText(departmentNameAdd);
		
		// Sua
		rowURL.setParameter(Constants.CMD, Constants.EDIT);
		row.addText("center", "middle", "<img src='/html/images/edit.png' border='0' title='Edit' />", rowURL);

		// Xoa
		StringBuilder sm = new StringBuilder();
	
		sm.append("<img title=\"Delete\"");
		sm.append(" border=\"0\" src=\"/html/images/delete.png\" onClick=\"deleteDocConfUser('");
		sm.append(String.valueOf(docConfUserItem.getDcuId()));
		sm.append("')\" >");
		row.addText("center", "middle", sm.toString());

		// Add row
		resultRows.add(row);
	}
%>

<script type="text/javascript">
	function <portlet:namespace />addDocConfUser() {
		var url = '<portlet:renderURL windowState="<%= WindowState.NORMAL.toString() %>"><portlet:param name="struts_action" value="/sgs/pml_edm_docconfuser/edit" /><portlet:param name="redirect" value="<%= currentURL %>" /></portlet:renderURL>';

		document.<portlet:namespace />fm.method = 'post';
		submitForm(document.<portlet:namespace />fm, url);
	}

	function deleteDocConfUser(delId) {
		if (confirm('<%= UnicodeLanguageUtil.get(pageContext, "are-you-sure-you-want-to-delete-the-selected-item") %>')) {
			document.<portlet:namespace />fm.<portlet:namespace /><%= Constants.CMD %>.value = "<%= Constants.DELETE %>";
			document.<portlet:namespace />fm.<portlet:namespace />delDCUId.value = delId;
			submitForm(document.<portlet:namespace />fm, "<portlet:actionURL windowState="<%= WindowState.NORMAL.toString() %>"><portlet:param name="struts_action" value="/sgs/pml_edm_docconfuser/edit" /><portlet:param name="redirect" value="<%= currentURL %>" /></portlet:actionURL>");
		}
	}
</script>

<form action="<%= portletURL.toString() %>" method="post" name="<portlet:namespace />fm" onSubmit="submitForm(this); return false;">
	<div class="title_categ"><liferay-ui:message key="doc-conf-user"/></div>
	<div class="boxcontent">
	<input name="<portlet:namespace /><%= Constants.CMD %>" type="hidden" />
	<input name="<portlet:namespace />delDCUId" type="hidden" />
	<input type="button" value="<liferay-ui:message key="add-config" />" onclick="<portlet:namespace />addDocConfUser();" />
	<div class="separator"><!-- --></div>
	<liferay-ui:search-iterator searchContainer="<%= searchContainer %>" />
	<div class="separator"><!-- --></div>
	<div align="right">
		<input type="button" value="<liferay-ui:message key="add-config" />" onclick="<portlet:namespace />addDocConfUser();" />
	</div>
</div>
</form>