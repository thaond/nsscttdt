<%@ include file="/html/portlet/init.jsp" %>
<%@page import="java.util.Date"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.sgs.liferay.jbpm.component.TaskAction"%>
<%@page import="com.sgs.liferay.jbpm.component.StrutsTaskAction"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.nss.workflow.JournalLiferayPortletAction"%>

<%
	StrutsTaskAction taskAction = (StrutsTaskAction) renderRequest.getAttribute(com.sgs.liferay.jbpm.util.Constants.WORKFLOW_TASK_ACTION);
	String redirect = ParamUtil.getString(renderRequest, "redirect");	
	long resourcePrimey = ParamUtil.getLong(renderRequest, com.sgs.liferay.jbpm.util.Constants.WORKFLOW_PARAM_PREFIX + "resourcePrimey", 0); 
	
	if (taskAction != null) {
%>

<input type="hidden" name="<portlet:namespace/>struts_action" value="<%=taskAction.getStrutsAction() %>">
<input type="hidden" name="<portlet:namespace/>redirect" value="<%=redirect%>">
<input type="hidden" name="<portlet:namespace/>resourcePrimey" value='<%= String.valueOf(resourcePrimey) %>'>
<input type="hidden" name="<portlet:namespace/><%=com.sgs.liferay.jbpm.util.Constants.WORKFLOW_ACTION%>" value="true">
<input type="hidden" name="<portlet:namespace/><%=com.sgs.liferay.jbpm.util.Constants.WORKFLOW_ACTION_NAME%>" value='<%= JournalLiferayPortletAction.COMMAND_PREFIX + "." + taskAction.getTaskActionName()%>'>
<input type="hidden" name='<portlet:namespace/><%=com.sgs.liferay.jbpm.util.Constants.WORKFLOW_PARAM_PREFIX + "transition"%>' value="<%=taskAction.getTransition()%>">
<input type="hidden" name='<portlet:namespace/><%=com.sgs.liferay.jbpm.util.Constants.WORKFLOW_PARAM_PREFIX + "taskId"%>' value='<%="" + taskAction.getTaskInstanceId()%>'>
<input type="submit"  value="<%=LanguageUtil.get(pageContext, taskAction.getTaskActionName())%>">

<% } %>