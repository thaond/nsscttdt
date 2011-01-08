<%@page import="java.util.Date"%>
<%@ include file="/html/portlet/ext/pcccdocumentreceiptprocess/init.jsp" %>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.sgs.liferay.jbpm.component.TaskAction"%>
<%@page import="com.sgs.portlet.document.workflow.DocumentReceiptPortletAction"%>
<%@page import="com.sgs.liferay.jbpm.component.StrutsTaskAction"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>

<%
	StrutsTaskAction taskAction = (StrutsTaskAction) renderRequest.getAttribute(com.sgs.liferay.jbpm.util.Constants.WORKFLOW_TASK_ACTION);

	// minh update 20100303
	String redirectTT = ParamUtil.getString(renderRequest, "redirect");	
	long userIdXLT = ParamUtil.getLong(renderRequest, "userIdXLT");
	//end
	long documentReceiptIdTemp = ParamUtil.getLong(renderRequest, "documentReceiptIdTemp", 0); // yenlt update 20101101
	// yenlt 20101118
	boolean changeCVP = ParamUtil.getBoolean(renderRequest, "changeCVP", false);
	String documentReceiptIdList  = ParamUtil.getString(renderRequest, "documentReceiptIdList");
	// yenlt 20101118
%>
<!-- minh update 20100303 -->
<!-- input type="hidden" name="<portlet:namespace/>redirect" value="<1%= redirect %>"-->
<input type="hidden" name="<portlet:namespace/>redirect" value="<%= redirectTT %>">
<input type="hidden" name="<portlet:namespace/>userIdXLT" value="<%= String.valueOf(userIdXLT) %>">
<input type="hidden" name="<portlet:namespace/><%=com.sgs.liferay.jbpm.util.Constants.WORKFLOW_ACTION%>" value="true">
<!-- end -->
<% 
	if (false == changeCVP) {
%>
<input type="hidden" name='<portlet:namespace/><%=com.sgs.liferay.jbpm.util.Constants.WORKFLOW_PARAM_PREFIX + "documentReceiptId"%>' value='<%= renderRequest.getParameter("documentReceiptId") %>' />
<input type="hidden" name="<portlet:namespace/>documentReceiptId" value='<%= renderRequest.getParameter("documentReceiptId") %>' />
<input type="hidden" name="<portlet:namespace/>struts_action" value="<%=taskAction.getStrutsAction() %>">
<input type="hidden" name="<portlet:namespace/><%=com.sgs.liferay.jbpm.util.Constants.WORKFLOW_ACTION_NAME%>" value='<%=DocumentReceiptPortletAction.COMMAND_PREFIX + "." + taskAction.getTaskActionName()%>'>
<input type="hidden" name='<portlet:namespace/><%=com.sgs.liferay.jbpm.util.Constants.WORKFLOW_PARAM_PREFIX + "transition"%>' value="<%=taskAction.getTransition()%>">

<input type="hidden" name='<portlet:namespace/><%=com.sgs.liferay.jbpm.util.Constants.WORKFLOW_PARAM_PREFIX + "taskId"%>' value='<%="" + taskAction.getTaskInstanceId()%>'>
<input type="hidden" name="<portlet:namespace/>documentReceiptIdTemp" value="<%= String.valueOf(documentReceiptIdTemp) %>"> <!-- yenlt update 20101101 -->
<input class="button" type="submit"  value="<%=LanguageUtil.get(pageContext, taskAction.getTaskActionName())%>">
<%
	} else {
%>
<input type="hidden" name="<portlet:namespace/>struts_action" value="/sgs/pcccdocumentreceiptprocess/transcvp">
<input type="hidden" name="<portlet:namespace/>documentReceiptIdList" value='<%= documentReceiptIdList %>' />
<input type="hidden" name="<portlet:namespace/>changeCVP" value='<%= String.valueOf(true) %>' />
<input type="hidden" name="<portlet:namespace/><%=com.sgs.liferay.jbpm.util.Constants.WORKFLOW_ACTION %>" value='<%= String.valueOf(true) %>' />
<input type="hidden" name="<portlet:namespace/><%=com.sgs.liferay.jbpm.util.Constants.WORKFLOW_ACTION_NAME %>" value='<%= DocumentReceiptPortletAction.COMMAND_PREFIX + "." + "chuyenchanhvanphong" %>' />
<input type="hidden" name='<portlet:namespace/><%=com.sgs.liferay.jbpm.util.Constants.WORKFLOW_PARAM_PREFIX + "transition"%>' value= "chanhvanphong">
<input class="button" type="submit" value='<liferay-ui:message key="chuyenchanhvanphong"/>'>
<%
	}
%>