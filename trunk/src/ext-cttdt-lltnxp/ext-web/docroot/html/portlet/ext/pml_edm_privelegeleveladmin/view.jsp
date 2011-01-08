<%@ include file="/html/portlet/ext/pml_edm_privelegeleveladmin/init.jsp" %>

<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="java.util.List"%>

<%@page import="com.sgs.portlet.document.receipt.model.PmlEdmPrivilegeLevel"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@page import="com.sgs.portlet.pml_edm_privelegeleveladmin.search.PmlEDMPrivelegelevelAdminSearch"%>
<%@page import="com.sgs.portlet.pml_edm_privelegeleveladmin.search.PmlEDMPrivelegelevelAdminSearchTerms"%>

<%@page import="com.sgs.portlet.document.receipt.service.PmlEdmPrivilegeLevelLocalServiceUtil"%>
<%@page import="com.sgs.portlet.pml_edm_privelegeleveladmin.search.PmlEDMPrivelegelevelAdminDisplayTerms"%>

<liferay-util:include page="/html/portlet/ext/pml_edm_privelegeleveladmin/js/privelegeLevel.jsp"></liferay-util:include>
<script type="text/javascript">
	function addPmlEDMPrivelegelevelAdmin(url) {	
		var valueName =  document.getElementById("<portlet:namespace/>name").value;
		if (valueName.trim () == "" ) {
			alert('<liferay-ui:message key="vui-long-nhap-ten"/>');
			document.getElementById("<portlet:namespace/>name").focus();
		} else {
			document.<portlet:namespace />fm.method = "post";
			submitForm(document.<portlet:namespace />fm, url);
		}
	
	}
</script>

<%
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action", "/sgs/pml_edm_privelegeleveladmin/view");
	
	
%>
	<form action="<%= portletURL.toString() %>"  method="post" name="<portlet:namespace />fm" onSubmit="submitForm(this); return false;">
	<input name="<portlet:namespace />levelAdmin" type="hidden" value="<%= portletURL.toString() %>" />
		<div class="title_categ"><liferay-ui:message key="privelegelevel-admin"/></div>
	<div class="boxcontent privilegelevel">
	<liferay-ui:error exception="<%= PmlEdmPrivilegeLevelCanNotDeleteException.class %>" message="can-not-delete-pml-tinh-chat" />
	<%
		PmlEDMPrivelegelevelAdminSearch pEDMPAdminSearch   = new PmlEDMPrivelegelevelAdminSearch(renderRequest, portletURL);
		PmlEDMPrivelegelevelAdminSearchTerms searchTerms = (PmlEDMPrivelegelevelAdminSearchTerms) pEDMPAdminSearch.getSearchTerms();

	%>
	<label><liferay-ui:message key="pml_edm_privilege_level_name"/><font color="#FF0000" size="1">(*)</font>:&nbsp;</label>
	<input name="<%= renderResponse.getNamespace() %><%= PmlEDMPrivelegelevelAdminSearchTerms.PRIVILEGELEVEL_NAME %>" id="<portlet:namespace/>name" style="width:53%;" type="text" value="<%= HtmlUtil.escape(searchTerms.getPrivilegelevelName()) %>" />
	<input type="submit" class="button-width"  name="<portlet:namespace/>search" value="<liferay-ui:message key="search"/>"/>
	
	<portlet:actionURL var="add">
		<portlet:param name="<%=Constants.ACTION %>" value="<%=Constants.ADD %>"/>
		<portlet:param name="struts_action" value="/sgs/pml_edm_privelegeleveladmin/view" />
		<portlet:param name="redirect" value="<%= pEDMPAdminSearch.getIteratorURL().toString() %>" />
	</portlet:actionURL>
	
	
	<input class="button-width" onclick="addPmlEDMPrivelegelevelAdmin('<%= add %>')" id="addButton" type="button" value='<liferay-ui:message key="add_new"/>' />	
	<div id="separator"></div>
	
	<%
		
		int total = PmlEdmPrivilegeLevelLocalServiceUtil.searchCount(searchTerms.getPrivilegelevelName());
		List<PmlEdmPrivilegeLevel> privilegeLevels = PmlEdmPrivilegeLevelLocalServiceUtil.
			search(searchTerms.getPrivilegelevelName(), pEDMPAdminSearch.getStart(), 
					pEDMPAdminSearch.getEnd(), pEDMPAdminSearch.getOrderByComparator() );
	
	
		List<PmlEdmPrivilegeLevel> results = privilegeLevels;
		
		pEDMPAdminSearch.setTotal(total);
		
		pEDMPAdminSearch.setResults(results);
		
		portletURL.setParameter(pEDMPAdminSearch.getCurParam(), String.valueOf(pEDMPAdminSearch.getCurValue()));
	
		List resultRows = pEDMPAdminSearch.getResultRows();
	
		PmlEdmPrivilegeLevel pmlEdmPrivilegeLevel  = null;
		
		ResultRow row = null;	
		
		String pmlEdmPrivilegeLevelId  = "";
		
		
		for (int i = 0; i < results.size(); i ++) {
			pmlEdmPrivilegeLevel = results.get(i);
			pmlEdmPrivilegeLevelId = pmlEdmPrivilegeLevel.getPrivilegeLevelId();
			
			row = new ResultRow(pmlEdmPrivilegeLevel, pmlEdmPrivilegeLevelId, i);
			
			// STT
			row.addText(String.valueOf(i + 1));
			
			
			// ma do khan 
			
			row.addText(pmlEdmPrivilegeLevel.getPrivilegeLevelId());
			
			// ten do khan
			StringBuilder pmlEdmPrivilegeLevelName = new StringBuilder();
			
			pmlEdmPrivilegeLevelName.append("<div id=\"");
			pmlEdmPrivilegeLevelName.append("name".concat(pmlEdmPrivilegeLevelId));
			pmlEdmPrivilegeLevelName.append("\">");
			pmlEdmPrivilegeLevelName.append(pmlEdmPrivilegeLevel.getPrivilegeLevelName());
			pmlEdmPrivilegeLevelName.append("</div>");		
			pmlEdmPrivilegeLevelName.append("<div id=\"");
			pmlEdmPrivilegeLevelName.append("editName".concat(pmlEdmPrivilegeLevelId));
			pmlEdmPrivilegeLevelName.append("\" style=\"display: none;\" >");
			pmlEdmPrivilegeLevelName.append("<input name=\"");
			pmlEdmPrivilegeLevelName.append("privilegeLevelName_".concat(pmlEdmPrivilegeLevelId));
			pmlEdmPrivilegeLevelName.append("\" style=\"width: 90%\"");
			pmlEdmPrivilegeLevelName.append(" id=\"");
			pmlEdmPrivilegeLevelName.append("hidden".concat(pmlEdmPrivilegeLevelId));
			pmlEdmPrivilegeLevelName.append("\" type=\"text\"");
			pmlEdmPrivilegeLevelName.append(" value=\"");
			pmlEdmPrivilegeLevelName.append(pmlEdmPrivilegeLevel.getPrivilegeLevelName());
			pmlEdmPrivilegeLevelName.append("\" /> </div>");
						
			row.addText(pmlEdmPrivilegeLevelName.toString());
			
			
			// sua  hoac xoa
			PortletURL deleteURL = renderResponse.createActionURL();
			deleteURL.setParameter(Constants.ACTION, Constants.DELETE);
			deleteURL.setParameter("privilegeLevelId", pmlEdmPrivilegeLevelId);
			deleteURL.setParameter("struts_action", "/sgs/pml_edm_privelegeleveladmin/view");
			deleteURL.setParameter("redirect",  pEDMPAdminSearch.getIteratorURL().toString());
			
			PortletURL updateURL = renderResponse.createActionURL();
			updateURL.setParameter(Constants.ACTION, Constants.UPDATE);
			updateURL.setParameter("privilegeLevelId", pmlEdmPrivilegeLevelId);
			updateURL.setParameter("struts_action", "/sgs/pml_edm_privelegeleveladmin/view");
			updateURL.setParameter("redirect",  pEDMPAdminSearch.getIteratorURL().toString());
			
			StringBuilder editOrDelete = new StringBuilder();
			
			editOrDelete.append("<div id=\"");
			editOrDelete.append("current".concat(pmlEdmPrivilegeLevelId));
			editOrDelete.append("\">");
			editOrDelete.append("<img class=\"image-edit\" src=\"/html/images/edit.png\"");
			editOrDelete.append(" value='");
			editOrDelete.append(LanguageUtil.get(pageContext,"recordtype.edit" ));
			editOrDelete.append("' onclick=\"editPriveledLevel('");
			editOrDelete.append(pmlEdmPrivilegeLevelId);
			editOrDelete.append("'); \"/>");
			
			editOrDelete.append("<img class=\"image-delete\" src=\"/html/images/delete.png\"");
			editOrDelete.append(" value='");
			editOrDelete.append(LanguageUtil.get(pageContext,"delete" ));
			editOrDelete.append("' onclick=\"deletePriveledLevel('");
			editOrDelete.append(pmlEdmPrivilegeLevelId);
			editOrDelete.append("','");
			editOrDelete.append(deleteURL.toString());			
			editOrDelete.append("');\"/>");			
			editOrDelete.append("</div>");
			
			
			editOrDelete.append("<div id=\"");
			editOrDelete.append("edit".concat(pmlEdmPrivilegeLevelId));
			editOrDelete.append("\" style=\"display: none;\" >");
			editOrDelete.append("<img class=\"image-update\" src=\"/html/images/image-save.png\"");
			editOrDelete.append(" value='");
			editOrDelete.append(LanguageUtil.get(pageContext,"document_save" ));
			editOrDelete.append("' onclick=\"updatePrivilegeLevel('");
			editOrDelete.append(pmlEdmPrivilegeLevelId);
			editOrDelete.append("', '");
			editOrDelete.append(updateURL.toString());	
			editOrDelete.append("');\"/>");
			
			editOrDelete.append("<img class=\"image-cancel\" src=\"/html/images/image-cancel.png\"");
			editOrDelete.append(" value='");
			editOrDelete.append(LanguageUtil.get(pageContext,"documentRecordType.huy" ));
			editOrDelete.append("' onclick=\"cancel('");
			editOrDelete.append(pmlEdmPrivilegeLevelId);
			editOrDelete.append("');\"/>");			
			editOrDelete.append("</div>");
			  
			row.addText(editOrDelete.toString());			
			
			resultRows.add(row);
		}
		
	%>
	
		<liferay-ui:search-iterator searchContainer="<%= pEDMPAdminSearch %>" />
		</fieldset>
</div>
</form>

