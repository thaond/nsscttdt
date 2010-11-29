<%@ include file="/html/portlet/nss/managementworkflowjournal/init.jsp" %>
<%@page import="com.nss.portlet.managementworkflowjournal.search.ManagementWorkflowJournalDisplayTerms"%>
<%@page import="com.nss.portlet.managementworkflowjournal.search.ManagementWorkflowJournalSearch"%>
<%@page import="javax.portlet.PortletURL"%>
<%
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action", "/nss/managementworkflowjournal/view");
%>

<script type="text/javascript">
	function searchDocumentWorkflow(url) {		
		document.<portlet:namespace />fm.method = "post";
		submitForm(document.<portlet:namespace />fm, url);
	
	}
</script>

<%
	ManagementWorkflowJournalSearch managementWorkflowJournalSearch = (ManagementWorkflowJournalSearch) request.getAttribute("liferay-ui:search:searchContainer");
	ManagementWorkflowJournalDisplayTerms displayTerms = (ManagementWorkflowJournalDisplayTerms) managementWorkflowJournalSearch.getDisplayTerms();
	
%>

<liferay-ui:search-toggle displayTerms="<%= displayTerms %>" id="toogle_id_documentworkflow" >
	<table class="documentworkflow-table" cellspacing="0" width="100%">
			<tr>
				<td width="7%"><liferay-ui:message key="workflow-name" />:&nbsp;</td>
				<td width="30%">
					<input style="width: 95%" name="<portlet:namespace/><%= ManagementWorkflowJournalDisplayTerms.WORKFLOW_NAME %>" size="20" type="text" value="<%= HtmlUtil.escape(displayTerms.getWorkflowName()) %>" />
				</td>
				<td align="right" width="5%"><liferay-ui:message key="description" />:&nbsp;</td>
				<td align="left">
					<input style="width: 95%" name="<portlet:namespace/><%= ManagementWorkflowJournalDisplayTerms.VERSION %>" size="20" type="text" value="<%= HtmlUtil.escape(String.valueOf(displayTerms.getVersion())) %>" />
				</td>
			</tr>
		</table>	
	</liferay-ui:search-toggle>
	<br/>
	<input type="button" onclick="searchDocumentWorkflow('<%= portletURL.toString()  %>')" name="<portlet:namespace/>search" value="<liferay-ui:message key="search"/>"/>
	<br/>
	<br/>