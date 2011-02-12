<%@page import="java.util.Date"%>
<%@ include file="/html/portlet/ext/pcccdocumentsendprocess/init.jsp"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.sgs.liferay.jbpm.component.TaskAction"%>
<%@page import="com.sgs.liferay.jbpm.component.StrutsTaskAction"%>
<%@page import="com.sgs.portlet.document.workflow.DocumentSendPortletAction"%>

<%
	StrutsTaskAction taskAction = (StrutsTaskAction) renderRequest.getAttribute(com.sgs.liferay.jbpm.util.Constants.WORKFLOW_TASK_ACTION);
	//minh update 20100304
	String redirectTT = ParamUtil.getString(renderRequest, "redirect");
	//end
	// yenlt update 11082010
	long userIdXLT = ParamUtil.getLong(renderRequest, "userIdXLT");
	// end yenlt
%>
<!-- minh update 20100303 -->
<!-- portlet:renderURL var="redirect"-->
	<!--portlet:param name="struts_action"
		value="/sgs/pcccdocumentsendprocess/view" /-->
<!-- /portlet:renderURL-->
<!-- end -->

<input type="hidden" name="<portlet:namespace/>struts_action" value="<%=taskAction.getStrutsAction() %>">
<!-- minh update 20100303 -->
<!-- input type="hidden" name="<portlet:namespace/>redirect" value="<1%=redirect%>"-->
<input type="hidden" name="<portlet:namespace/>redirect" value="<%=redirectTT%>">
<!-- end -->
<input type="hidden" name="<portlet:namespace/>userIdXLT" value="<%= String.valueOf(userIdXLT) %>"> <!-- yenlt update 12082010 -->
<input type="hidden" name="<portlet:namespace/>documentSendId" value='<%= renderRequest.getParameter("documentSendId") %>'>
<input type="hidden" name="<portlet:namespace/><%=com.sgs.liferay.jbpm.util.Constants.WORKFLOW_ACTION%>" value="true">
<input type="hidden" name="<portlet:namespace/><%=com.sgs.liferay.jbpm.util.Constants.WORKFLOW_ACTION_NAME%>" value='<%=DocumentSendPortletAction.COMMAND_PREFIX + "." + taskAction.getTaskActionName()%>'>
<input type="hidden" name='<portlet:namespace/><%=com.sgs.liferay.jbpm.util.Constants.WORKFLOW_PARAM_PREFIX + "transition"%>' value="<%=taskAction.getTransition()%>">
<input type="hidden" name='<portlet:namespace/><%=com.sgs.liferay.jbpm.util.Constants.WORKFLOW_PARAM_PREFIX + "taskId"%>' value='<%="" + taskAction.getTaskInstanceId()%>'>
<input type="submit"  value="<%=LanguageUtil.get(pageContext, taskAction.getTaskActionName())%>">