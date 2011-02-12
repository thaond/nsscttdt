<%@ include file="/html/portlet/ext/documentprocessmanagement/init.jsp" %>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.sgs.portlet.documentprocessmanagement.search.DocumentWorkflowSearch"%>
<%@page import="com.sgs.portlet.documentprocessmanagement.search.DocumentWorkflowDisplayTerms"%>
<%
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action", "/sgs/documentprocessmanagement/view");
%>

<script type="text/javascript">
	function searchDocumentWorkflow(url) {		
		document.<portlet:namespace />fm.method = "post";
		submitForm(document.<portlet:namespace />fm, url);
	
	}
</script>

<%
DocumentWorkflowSearch documentWorkflowSearch = (DocumentWorkflowSearch) request.getAttribute("liferay-ui:search:searchContainer");
DocumentWorkflowDisplayTerms displayTerms = (DocumentWorkflowDisplayTerms) documentWorkflowSearch.getDisplayTerms();
%>

<liferay-ui:search-toggle displayTerms="<%= displayTerms %>" id="toogle_id_documentworkflow" >
<table class="documentworkflow-table" cellspacing="0" width="100%">
		<tr>
			<td width="7%"><liferay-ui:message key="sgs_onedoor_workflowadmin_workflow" />:&nbsp;</td>
			<td width="30%">
				<input style="width: 95%" name="<portlet:namespace/><%=DocumentWorkflowDisplayTerms.DOCUMENTWORKFLOWNAME %>" size="20" type="text" value="<%= HtmlUtil.escape(displayTerms.getDocumentWorkflowName()) %>" />
			</td>
			<td align="right" width="5%"><liferay-ui:message key="description" />:&nbsp;</td>
			<td align="left">
				<input style="width: 95%" name="<portlet:namespace/><%=DocumentWorkflowDisplayTerms.DESCRIPTION %>" size="20" type="text" value="<%= HtmlUtil.escape(displayTerms.getDescription()) %>" />
			</td>
		</tr>
	</table>	
</liferay-ui:search-toggle>
<br/>
<input type="button" onclick="searchDocumentWorkflow('<%= portletURL.toString()  %>')" name="<portlet:namespace/>search" value="<liferay-ui:message key="search"/>"/>
