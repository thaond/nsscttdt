<%@ include file="/html/portlet/ext/onedoorpcccprocess/init.jsp"%>
<%@page import="com.sgs.liferay.jbpm.component.TaskAction"%>
<%@page import="com.sgs.portlet.onedoor.workflow.OneDoorProcessPortletAction"%>
<%@page import="com.sgs.liferay.jbpm.component.StrutsTaskAction"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="java.util.Collection"%>
<%@page import="java.util.ArrayList"%>

<%
	
	String sort = ParamUtil.getString(renderRequest, "sort");
	boolean loadData = ParamUtil.getBoolean(renderRequest, "loadData");
	String processValue = ParamUtil.getString(renderRequest, "processValue");
	String type = ParamUtil.getString(renderRequest, "type");
	String valueType = ParamUtil.getString(renderRequest, "valueType");
	String beginDateParam = ParamUtil.getString(renderRequest, "beginDateParam");
	String endDateParam = ParamUtil.getString(renderRequest, "endDateParam");	
	String fileTypeFilter = ParamUtil.getString(renderRequest, "fileTypeFilter");
	String isDelegate = ParamUtil.getString(renderRequest,"isDelegate");
	
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

<%@page import="com.liferay.portal.kernel.util.ParamUtil"%><c:if test="<%= ! TaskAction.NONE_FORM.equals(taskAction.getForm())%>">
	<portlet:renderURL var="form" windowState="<%= LiferayWindowState.NORMAL.toString() %>">
		<portlet:param name="struts_action" value="<%=taskAction.getStrutsAction()%>" />
		<portlet:param name="fileId" value='<%=(String) renderRequest.getParameter("fileId") %>' />
		<portlet:param name="taskId" value='<%=taskAction.getTaskInstanceId() +""%>' />
		<portlet:param 	name="<%=com.sgs.liferay.jbpm.util.Constants.WORKFLOW_RENDER%>"
			value="true" />
		<!-- yenlt update 24052010 -->
		<portlet:param name="sort" value='<%= sort %>' />
		<portlet:param name="loadData" value='<%= String.valueOf(loadData) %>' />
		<portlet:param name="processValue" value='<%= processValue %>' />
		<portlet:param name="type" value='<%= type %>' />
		<portlet:param name="valueType" value='<%= valueType %>' />
		<portlet:param name="beginDateParam" value='<%= beginDateParam %>' />
		<portlet:param name="endDateParam" value='<%= endDateParam %>' />
		<portlet:param name="fileTypeFilter" value='<%= fileTypeFilter %>' />
		<portlet:param name="isDelegate" value='<%= isDelegate %>' />
		<!-- end yenlt 24052010 -->
	</portlet:renderURL>
	
	<span onclick="javascript:submitForm(document.hrefFm,'<%=form%>');">
		<input class="button" type="button" value='<liferay-ui:message key="<%=taskAction.getTaskActionName()%>" />'/>
	</span>
</c:if>

<c:if test="<%= TaskAction.NONE_FORM.equals(taskAction.getForm())%>">
	
	<portlet:renderURL var="redirect" windowState="<%= LiferayWindowState.NORMAL.toString() %>">
		<portlet:param name="struts_action" value="/sgs/onedoorpcccprocess/view" />
		<!-- yenlt update 24052010 -->
		<portlet:param name="sort" value='<%= sort %>' />
		<portlet:param name="loadData" value='<%= String.valueOf(loadData) %>' />
		<portlet:param name="processValue" value='<%= processValue %>' />
		<portlet:param name="type" value='<%= type %>' />
		<portlet:param name="valueType" value='<%= valueType %>' />
		<portlet:param name="beginDateParam" value='<%= beginDateParam %>' />
		<portlet:param name="endDateParam" value='<%= endDateParam %>' />
		<portlet:param name="fileTypeFilter" value='<%= fileTypeFilter %>' />
		<portlet:param name="isDelegate" value='<%= isDelegate %>' />
		<!-- end yenlt 24052010 -->	
	</portlet:renderURL>
	
	<portlet:actionURL var="form">
		<portlet:param name="struts_action" value="<%=taskAction.getStrutsAction()%>" />
		<portlet:param name="<%=com.sgs.liferay.jbpm.util.Constants.WORKFLOW_PARAM_PREFIX + "fileId"%>"
			value='<%=(String) renderRequest.getParameter("fileId") %>' />
		<!-- yenlt update 24052010 -->
		<portlet:param name="sort" value='<%= sort %>' />
		<portlet:param name="loadData" value='<%= String.valueOf(loadData) %>' />
		<portlet:param name="processValue" value='<%= processValue %>' />
		<portlet:param name="type" value='<%= type %>' />
		<portlet:param name="valueType" value='<%= valueType %>' />
		<portlet:param name="beginDateParam" value='<%= beginDateParam %>' />
		<portlet:param name="endDateParam" value='<%= endDateParam %>' />
		<portlet:param name="fileTypeFilter" value='<%= fileTypeFilter %>' />
		<portlet:param name="isDelegate" value='<%= isDelegate %>' />
		<!-- end yenlt 24052010 -->
		<portlet:param name="<%=com.sgs.liferay.jbpm.util.Constants.WORKFLOW_PARAM_PREFIX + "taskId"%>"
			value='<%=taskAction.getTaskInstanceId() + ""%>' />
		<portlet:param name="<%=com.sgs.liferay.jbpm.util.Constants.WORKFLOW_PARAM_PREFIX + "transition"%>"
			value="<%=taskAction.getTransition()%>" />
		<portlet:param name="<%=com.sgs.liferay.jbpm.util.Constants.WORKFLOW_ACTION%>" value="true" />
		<portlet:param name="<%=com.sgs.liferay.jbpm.util.Constants.WORKFLOW_ACTION_NAME%>" value='<%=OneDoorProcessPortletAction.COMMAND_PREFIX + "." + taskAction.getTaskActionName()%>' />
		<portlet:param name="redirect" value="<%=redirect %>" />
	</portlet:actionURL>
	<%	
	if ("xoahoso".equalsIgnoreCase(taskAction.getTaskActionName())  )  {%>
	
	<span id="xoahoso" >
		<input class="button" onclick="resultSaveDodument();" type="button" value='<liferay-ui:message key="<%=taskAction.getTaskActionName()%>" />'/>
		</span>
		<script type="text/javascript">
			function resultSaveDodument(){				
					if (confirm('<%= UnicodeLanguageUtil.get(pageContext, "are-you-sure-you-want-to-delete-this-file") %>')) {
						javascript:submitForm(document.hrefFm, '<%=form%>');
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