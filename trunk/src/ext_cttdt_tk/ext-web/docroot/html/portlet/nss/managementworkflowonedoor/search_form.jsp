<%@ include file="/html/portlet/nss/managementworkflowonedoor/init.jsp" %>
<%@page import="com.nss.portlet.managementworkflowonedoor.search.OneDoorWorkflowDisplayTerms"%>
<%@page import="com.nss.portlet.managementworkflowonedoor.search.OneDoorWorkflowSearch"%>
<%@page import="javax.portlet.PortletURL"%>

<%
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action", "/nss/managementworkflowonedoor/view");
%>


<script type="text/javascript">
	function searchOneDoorWorkflow(url) {		
		document.<portlet:namespace />fm.method = "post";
		submitForm(document.<portlet:namespace />fm, url);
	
	}
</script>

<%
	OneDoorWorkflowSearch oneDoorWorkflowSearch = (OneDoorWorkflowSearch) request.getAttribute("liferay-ui:search:searchContainer");
	OneDoorWorkflowDisplayTerms displayTerms = (OneDoorWorkflowDisplayTerms) oneDoorWorkflowSearch.getDisplayTerms();
%>

<liferay-ui:search-toggle displayTerms="<%= displayTerms %>" id="toogle_id_onedoorworkflow" >
	<table cellspacing="0" width="100%">
	
		<tr>
			<td align="right" width="12%"><liferay-ui:message key="sgs_filetype_filetypeName" />:&nbsp;</td>
			<td width="30%">
				<input name="<portlet:namespace/><%=OneDoorWorkflowDisplayTerms.FILETYPENAME %>" style="width: 90%" type="text" value="<%= HtmlUtil.escape(displayTerms.getFileTypeName()) %>" />
			</td>
			
			<td align="right" width="7%"><liferay-ui:message key="name_workflow_onedoor" />:&nbsp;</td>
			<td>
				<input name="<portlet:namespace/><%=OneDoorWorkflowDisplayTerms.WORKFLOWNAME %>" style="width: 98%" type="text" value="<%= HtmlUtil.escape(displayTerms.getWorkflowName()) %>" />
			</td>
		</tr>
		
	</table>	
</liferay-ui:search-toggle>
<br/>
<input type="button" onclick="searchOneDoorWorkflow('<%= portletURL.toString()  %>')" name="<portlet:namespace/>search" value="<liferay-ui:message key="search"/>"/>

<br/>
<br/>
