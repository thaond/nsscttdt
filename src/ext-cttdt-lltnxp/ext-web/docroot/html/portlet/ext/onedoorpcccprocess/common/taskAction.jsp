<%@ include file="/html/portlet/ext/onedoorpcccprocess/init.jsp"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.sgs.liferay.jbpm.component.TaskAction"%>
<%@page import="com.sgs.portlet.onedoor.workflow.OneDoorProcessPortletAction"%>
<%@page import="com.sgs.liferay.jbpm.component.StrutsTaskAction"%>

<%
	//minh update 20100524
	String sort = ParamUtil.getString(renderRequest, "sort");
	boolean loadData = ParamUtil.getBoolean(renderRequest, "loadData");
	String processValue = ParamUtil.getString(renderRequest, "processValue");
	String type = ParamUtil.getString(renderRequest, "type");
	String valueType = ParamUtil.getString(renderRequest, "valueType");
	String beginDateParam = ParamUtil.getString(renderRequest, "beginDateParam");
	String endDateParam = ParamUtil.getString(renderRequest, "endDateParam");	
	String fileTypeFilter = ParamUtil.getString(renderRequest, "fileTypeFilter");
	// end minh update 20100524

	StrutsTaskAction taskAction = (StrutsTaskAction) renderRequest.getAttribute(com.sgs.liferay.jbpm.util.Constants.WORKFLOW_TASK_ACTION);
%>

<portlet:renderURL var="redirect">
	<portlet:param name="struts_action" value="/sgs/onedoorpcccprocess/view" />
	<!-- minh update 20100524 -->
	<portlet:param name="sort" value='<%= sort %>' />
	<portlet:param name="loadData" value='<%= String.valueOf(loadData) %>' />
	<portlet:param name="processValue" value='<%= processValue %>' />
	<portlet:param name="type" value='<%= type %>' />
	<portlet:param name="valueType" value='<%= valueType %>' />
	<portlet:param name="beginDateParam" value='<%= beginDateParam %>' />
	<portlet:param name="endDateParam" value='<%= endDateParam %>' />
	<portlet:param name="fileTypeFilter" value='<%= fileTypeFilter %>' />
	<!-- end minh update 20100524 -->
</portlet:renderURL>

<input type="hidden" name='<portlet:namespace/><%=com.sgs.liferay.jbpm.util.Constants.WORKFLOW_PARAM_PREFIX + "fileId"%>' value='<%= renderRequest.getParameter("fileId") %>' />
<input type="hidden" name="<portlet:namespace/>struts_action" value="<%=taskAction.getStrutsAction() %>"/>
<input type="hidden" name="<portlet:namespace/>redirect" value="<%=redirect %>"/>
<input type="hidden" name="<portlet:namespace/><%=com.sgs.liferay.jbpm.util.Constants.WORKFLOW_ACTION%>" value="true"/>
<input type="hidden" name="<portlet:namespace/><%=com.sgs.liferay.jbpm.util.Constants.WORKFLOW_ACTION_NAME%>" value='<%=OneDoorProcessPortletAction.COMMAND_PREFIX + "." + taskAction.getTaskActionName()%>'/>
<input type="hidden" name='<portlet:namespace/><%=com.sgs.liferay.jbpm.util.Constants.WORKFLOW_PARAM_PREFIX + "transition"%>' value="<%=taskAction.getTransition()%>"/>
<input type="hidden" name='<portlet:namespace/><%=com.sgs.liferay.jbpm.util.Constants.WORKFLOW_PARAM_PREFIX + "taskId"%>' value='<%="" + taskAction.getTaskInstanceId()%>'/>
<input class="button-width" type="submit"  value="<%=LanguageUtil.get(pageContext, taskAction.getTaskActionName())%>"/>