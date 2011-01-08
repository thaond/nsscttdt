<%@ include file="/html/portlet/ext/pcccdocumentsendprocess/init.jsp"%>
<%@page import="com.sgs.liferay.jbpm.component.StrutsTaskAction"%>
<%@page import="com.sgs.portlet.document.workflow.DocumentSendPortletAction"%>
<%@page import="com.sgs.liferay.jbpm.component.TaskAction"%>
<%@page import="com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt"%>
<%
	java.util.List<StrutsTaskAction> taskActions = (java.util.List) renderRequest.getAttribute("taskActions");
	PmlEdmDocumentReceipt receiptDTO = (PmlEdmDocumentReceipt) renderRequest.getAttribute("documentReceipt");
if (taskActions != null) {
	for (int j = 0; j < taskActions.size(); j++) {	
		int temp = j;
		for (int i = temp; i < taskActions.size(); i++) {
			if (taskActions.get(j).getTaskActionName().compareTo(taskActions.get(i).getTaskActionName())> 0) {				
				java.util.Collections.swap(taskActions, j, i);
			}
		}
	}
	// minh update 20100303
	String tabChung = ParamUtil.getString(renderRequest, "tabChung");
	String redirectWf = ParamUtil.getString(renderRequest, "redirect")+ "&tabChung="+tabChung;
	// end
	long userIdXLT = ParamUtil.getLong(renderRequest, "userIdXLT"); // yenlt 11082010
	
	//yenlt update rut lai vb di 20101119
	boolean rutLai = ParamUtil.getBoolean(renderRequest, "rutLai", false);
	long receiverIdBack = ParamUtil.getLong(renderRequest, "receiverIdBack");
	java.util.List<StrutsTaskAction> taskActionList = new ArrayList<StrutsTaskAction>();
	StrutsTaskAction taskActionRutLai = null;
	for (int t = 0; t < taskActions.size(); t++) {
		StrutsTaskAction taskActionTemp = taskActions.get(t);
		if ("rutlai".equals(taskActionTemp.getTaskActionName())) {
			taskActionRutLai = taskActionTemp;
			break;
		}
	}
	
	if (rutLai) {
		if (null != taskActionRutLai) {
			taskActionList.add(taskActionRutLai);
		}
	} else {
		taskActions.remove(taskActionRutLai);
		taskActionList = taskActions;
	}
	for (int i = 0; i < taskActionList.size(); i++) {
		StrutsTaskAction taskAction = taskActionList.get(i);
	// end yenlt update 20101119
%>

<c:if test="<%= ! TaskAction.NONE_FORM.equals(taskAction.getForm())%>">
	<portlet:renderURL var="form">
		<portlet:param name="struts_action" value="<%=taskAction.getStrutsAction()%>" />
		<portlet:param name="documentSendId"
			value='<%= renderRequest.getParameter("documentSendId") %>' />
		<portlet:param name="taskId"
			value='<%=taskAction.getTaskInstanceId() +""%>' />
		<portlet:param
			name="<%=com.sgs.liferay.jbpm.util.Constants.WORKFLOW_RENDER%>"
			value="true" />
		<!-- minh update 20100304 -->		
		<portlet:param name="redirect" value="<%= redirectWf%>" />
		<!-- end -->
		<portlet:param name="userIdXLT" value="<%= String.valueOf(userIdXLT) %>" /><!--  yenlt update 12082010 -->	
	</portlet:renderURL>
	<span onclick="javascript:submitForm(document.hrefFm,'<%=form%>');">
			<input class="button" type="button" value='<liferay-ui:message	key="<%=taskAction.getTaskActionName()%>" />' />
	</span>
	
</c:if>

<c:if test="<%= TaskAction.NONE_FORM.equals(taskAction.getForm())%>">
	<!-- minh update 20100304 -->
	<!-- portlet:renderURL var="redirect"-->
		<!--portlet:param name="struts_action"
			value="/sgs/pcccdocumentsendprocess/view" /-->
	<!--/portlet:renderURL-->
	<!-- end -->
	<portlet:actionURL var="form">
		<portlet:param name="struts_action" value="<%=taskAction.getStrutsAction()%>" />
		<portlet:param name="documentSendId"
			value='<%= renderRequest.getParameter("documentSendId") %>' />
		<portlet:param name='<%=com.sgs.liferay.jbpm.util.Constants.WORKFLOW_PARAM_PREFIX + "taskId"%>'
			value='<%=taskAction.getTaskInstanceId() + ""%>' />
		<portlet:param name='<%=com.sgs.liferay.jbpm.util.Constants.WORKFLOW_PARAM_PREFIX + "transition"%>'
			value="<%=taskAction.getTransition()%>" />
		<portlet:param name="<%=com.sgs.liferay.jbpm.util.Constants.WORKFLOW_ACTION%>" value="true" />
		<portlet:param name="<%=com.sgs.liferay.jbpm.util.Constants.WORKFLOW_ACTION_NAME%>" value='<%=DocumentSendPortletAction.COMMAND_PREFIX + "." + taskAction.getTaskActionName()%>' />
		<!-- minh update 20100304 -->
		<!-- portlet:param name="redirect" value="<1%=redirect%>" /-->		
		<portlet:param name="redirect" value="<%= redirectWf%>" />
		<!-- end -->
		<portlet:param name="userIdXLT" value="<%= String.valueOf(userIdXLT) %>" /><!--  yenlt update 12082010 -->
		<!-- yenlt update 20101119 -->
		<% if (rutLai) { %>
			<portlet:param name="rutLai" value="<%= String.valueOf(rutLai) %>" />
			<portlet:param name="receiverIdBack" value="<%= String.valueOf(receiverIdBack) %>" />
		<% } %>
		<!-- edn yenlt update 20101119 -->
	</portlet:actionURL>
	
	<%	
	if ("xoacongvan".equalsIgnoreCase(taskAction.getTaskActionName()) )  {%>
	<c:if test="<%= receiptDTO == null %>">
	<a id= "xoacongvan"  href="javascript:submitForm(document.hrefFm, '<%=form%>');">
		<input onclick="resultSaveDodument()" type="button" value='<liferay-ui:message	key="<%=taskAction.getTaskActionName()%>" />'>
			
		</input>
		</a>
		<script type="text/javascript">
			function resultSaveDodument(){		
				
					if (confirm('<%= UnicodeLanguageUtil.get(pageContext, "are-you-sure-you-want-to-delete-this-document") %>')) {
						document.getElementById('xoacongvan').href = "javascript:submitForm(document.hrefFm,"+ "'<%=form%>');"
					}
					
					else {
						document.getElementById('xoacongvan').href = "#";
						
					}
				
			}
			</script>
	</c:if>
	<%}	else {	%>
	
		<span onclick="javascript:submitForm(document.hrefFm,'<%=form%>');">
			<input type="button" value='<liferay-ui:message	key="<%=taskAction.getTaskActionName()%>" />' />
		</span>
	<%} %>
</c:if>
<%}
}
%>