
<%@page import="com.sgs.liferay.jbpm.component.TaskAction"%>
<%@page import="com.sgs.liferay.jbpm.component.StrutsTaskAction"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="java.util.Collection"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.nss.workflow.JournalLiferayPortletAction"%>
<%
	String redirectWF = ParamUtil.getString(renderRequest, "redirect");	

	java.util.List<StrutsTaskAction> taskActions = (java.util.List<StrutsTaskAction>) renderRequest.getAttribute("taskActions");
	
	if (taskActions != null) {
		for (int j = 0; j < taskActions.size(); j++) {	
			int temp = j;
			for (int i = temp; i < taskActions.size(); i++) {
				if (taskActions.get(j).getTaskActionName().compareTo(taskActions.get(i).getTaskActionName())> 0) {				
					java.util.Collections.swap(taskActions, j, i);
				}
			}
		}
	} else {
		taskActions = new ArrayList<StrutsTaskAction>();
	}
	
%>

<% for (int i = 0; i < taskActions.size(); i++) {
		StrutsTaskAction taskAction = taskActions.get(i);
		
%>

<c:if test="<%= ! TaskAction.NONE_FORM.equals(taskAction.getForm())%>">
	<portlet:renderURL var="form" windowState="<%= WindowState.NORMAL.toString() %>">
		<portlet:param name="struts_action" value="<%=taskAction.getStrutsAction()%>" />
		<portlet:param name='<%=com.sgs.liferay.jbpm.util.Constants.WORKFLOW_PARAM_PREFIX + "resourcePrimey"%>' value='<%= ParamUtil.getString(renderRequest,"resourcePrimey","") %>' />
		<portlet:param name='<%=com.sgs.liferay.jbpm.util.Constants.WORKFLOW_PARAM_PREFIX + "taskId"%>' value='<%= String.valueOf(taskAction.getTaskInstanceId())%>' />
		<portlet:param 	name="<%=com.sgs.liferay.jbpm.util.Constants.WORKFLOW_RENDER%>" value="true" />
		<portlet:param name="redirect" value="<%= redirectWF %>" />
		<portlet:param name="groupId" value="<%= String.valueOf(groupId) %>" />
		<portlet:param name="articleId" value="<%= articleId %>" />
		<portlet:param name="version" value="<%= String.valueOf(version) %>" />
		<portlet:param name="articleURL" value='<portlet:renderURL windowState="<%= WindowState.NORMAL.toString() %>"><portlet:param name="struts_action" value="/nss/journal/edit_article" /></portlet:renderURL>' />
	</portlet:renderURL>
	
	<span onclick="javascript:submitForm(document.hrefFm,'<%= form%>');">
		<input class="button" type="button" value='<liferay-ui:message key="<%=taskAction.getTaskActionName()%>" />'/>
	</span>
</c:if>

<c:if test="<%= TaskAction.NONE_FORM.equals(taskAction.getForm())%>">
	
	<portlet:actionURL var="form"  windowState="<%= LiferayWindowState.NORMAL.toString() %>">
		<portlet:param name="struts_action" value="<%=taskAction.getStrutsAction()%>" />
		
		<portlet:param name='<%=com.sgs.liferay.jbpm.util.Constants.WORKFLOW_PARAM_PREFIX + "resourcePrimey"%>'
			value='<%=ParamUtil.getString(renderRequest,"resourcePrimey","") %>' />
		
		<portlet:param name='<%=com.sgs.liferay.jbpm.util.Constants.WORKFLOW_PARAM_PREFIX + "taskId"%>'
			value='<%= String.valueOf(taskAction.getTaskInstanceId())%>' />
			
		<portlet:param name='<%=com.sgs.liferay.jbpm.util.Constants.WORKFLOW_PARAM_PREFIX + "transition"%>'
			value="<%=taskAction.getTransition()%>" />
			
		<portlet:param name="<%=com.sgs.liferay.jbpm.util.Constants.WORKFLOW_ACTION%>" value="true" />
		
		<portlet:param name="<%=com.sgs.liferay.jbpm.util.Constants.WORKFLOW_ACTION_NAME%>" 
		value='<%=JournalLiferayPortletAction.COMMAND_PREFIX + "." + taskAction.getTaskActionName()%>' />
		
		<portlet:param name="redirect" value="<%= redirectWF %>" />
		<portlet:param name="groupId" value="<%= String.valueOf(groupId) %>" />
		<portlet:param name="articleId" value="<%= articleId %>" />
		<portlet:param name="version" value="<%= String.valueOf(version) %>" />
	</portlet:actionURL>
	<%	
	if ("xoatin".equalsIgnoreCase(taskAction.getTaskActionName())  )  {%>
	
	<span id="xoahoso" >
		<input class="button" onclick="resultSaveDodument();" type="button" value='<liferay-ui:message key="<%=taskAction.getTaskActionName()%>" />'/>
		</span>
		<script type="text/javascript">
			function resultSaveDodument(){				
					if (confirm('<%= UnicodeLanguageUtil.get(pageContext, "are-you-sure-you-want-to-delete-this-journal-article") %>')) {
						javascript:submitForm(document.hrefFm, '<%= form%>');
					}
					else {
						document.getElementById('xoahoso').click = "#";
						
					}
			}
			</script>
	<%}	else {%>
	<span onclick="javascript:submitForm(document.hrefFm,'<%=form%>');">
		<input class="button" type="button" value='<liferay-ui:message key="<%=taskAction.getTaskActionName()%>" />'/>
	</span>
	<%} %>
</c:if>
<%}%>