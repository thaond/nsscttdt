<%@ include file="/html/portlet/ext/pcccdocumentreceiptprocess/init.jsp"%>

<%@page import="java.util.Collection"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.sgs.liferay.jbpm.component.TaskAction"%>
<%@page import="com.sgs.liferay.jbpm.component.StrutsTaskAction"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.language.UnicodeLanguageUtil"%>

<%@page import="com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt"%>
<%@page import="com.sgs.portlet.document.workflow.DocumentReceiptPortletAction"%>
<%@page import="com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentReceiptUtil"%>

<%
	String hienTrang = ParamUtil.getString(renderRequest, "hienTrang", "dangXuLy");
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
	
	PmlEdmDocumentReceipt  documentReceipt  =  PmlEdmDocumentReceiptUtil.findByPrimaryKey(Long.parseLong(renderRequest.getParameter("documentReceiptId")));
	String documentReceiptType =  documentReceipt.getDocumentType();
	// minh update 20100303
	// minh update 20100416
	String tabChung = ParamUtil.getString(renderRequest, "tabChung");
	String cachThucXuLy = ParamUtil.getString(renderRequest, "cachThucXuLy", "-1");
	String redirectWf = "";
	if (!"vbquamang".equals(hienTrang)) {
		redirectWf = ParamUtil.getString(renderRequest, "redirect")+ "&tabChung="+tabChung +"&cachThucXuLy="+cachThucXuLy;
	} else {
		PortletURL redirectURL = renderResponse.createRenderURL();
		redirectURL.setWindowState(WindowState.NORMAL);
		redirectURL.setParameter("struts_action", "/sgs/pcccdocumentreceiptprocess/view");
		redirectURL.setParameter("hienTrang", hienTrang);
		redirectURL.setParameter("tabChung", tabChung);
		redirectWf = redirectURL.toString();
	}
	// end minh update 20100416
	long userIdXLT = ParamUtil.getLong(renderRequest, "userIdXLT");
	// end
	long documentReceiptIdTemp = ParamUtil.getLong(renderRequest, "documentReceiptIdTemp", 0); // yenlt update 20101101
	//yenlt update vb rut lai 20101119
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
		StrutsTaskAction taskAction = taskActionList.get(i); // end yenlt 20101119
%>

<c:if test="<%= ! TaskAction.NONE_FORM.equals(taskAction.getForm())%>">
	<portlet:renderURL var="form" windowState="<%= LiferayWindowState.NORMAL.toString() %>">
		<portlet:param name="struts_action" value="<%=taskAction.getStrutsAction()%>" />
		<portlet:param name="documentReceiptId"
			value='<%=(String) renderRequest.getParameter("documentReceiptId") %>' />
		<portlet:param name="taskId"
			value='<%=taskAction.getTaskInstanceId() +""%>' />
		<portlet:param
			name="<%=com.sgs.liferay.jbpm.util.Constants.WORKFLOW_RENDER%>"
			value="true" />
		<!-- minh update 20100303 -->
		<!-- portlet:param name="redirect" value="<1%=redirect%>" /-->		
		<portlet:param name="redirect" value="<%= redirectWf%>" />
		<portlet:param name="userIdXLT" value="<%= String.valueOf(userIdXLT) %>" />
		<!-- end -->
		<portlet:param name="documentReceiptIdTemp" value="<%= String.valueOf(documentReceiptIdTemp) %>" /> <!-- yenlt update 20101101 -->
	</portlet:renderURL>
	
	
	<%
	
	if (("1".equalsIgnoreCase(documentReceiptType))&& ("soancongvandi".equalsIgnoreCase(taskAction.getTaskActionName())|| "congvanbaocao".equalsIgnoreCase(taskAction.getTaskActionName())  ) ) {
		
	}
	else if (("2".equalsIgnoreCase(documentReceiptType))&& ("soancongvandi".equalsIgnoreCase(taskAction.getTaskActionName())|| "congvanluu".equalsIgnoreCase(taskAction.getTaskActionName())  ) ) {
		
	}
	
	else if (("3".equalsIgnoreCase(documentReceiptType))&& ("congvanbaocao".equalsIgnoreCase(taskAction.getTaskActionName())|| "congvanluu".equalsIgnoreCase(taskAction.getTaskActionName())  ) ) {
		
	}
	
	else {
	%>
	<span onclick="javascript:submitForm(document.hrefFm,'<%=form%>');">
		<input class="button" type="button" value='<liferay-ui:message	key="<%=taskAction.getTaskActionName()%>" />'/>
	</span>
	
	<%} %>
</c:if>

<c:if test="<%= TaskAction.NONE_FORM.equals(taskAction.getForm())%>">
	<portlet:actionURL var="form">
		<portlet:param name="struts_action" value="<%=taskAction.getStrutsAction()%>" />
		<portlet:param name='<%=com.sgs.liferay.jbpm.util.Constants.WORKFLOW_PARAM_PREFIX + "documentReceiptId"%>'
			value='<%=(String) renderRequest.getParameter("documentReceiptId") %>' />
		<portlet:param name="documentReceiptId"	value='<%=(String) renderRequest.getParameter("documentReceiptId") %>' />	
		<portlet:param name="<%=com.sgs.liferay.jbpm.util.Constants.WORKFLOW_PARAM_PREFIX + "taskId"%>"
			value='<%=taskAction.getTaskInstanceId() + ""%>' />
		<portlet:param name='<%=com.sgs.liferay.jbpm.util.Constants.WORKFLOW_PARAM_PREFIX + "transition"%>'
			value="<%=taskAction.getTransition()%>" />
		<portlet:param name="<%=com.sgs.liferay.jbpm.util.Constants.WORKFLOW_ACTION%>" value="true" />
		<portlet:param name="<%=com.sgs.liferay.jbpm.util.Constants.WORKFLOW_ACTION_NAME%>" value='<%=DocumentReceiptPortletAction.COMMAND_PREFIX + "." + taskAction.getTaskActionName()%>' />
		<!-- minh update 20100303 -->
		<!-- portlet:param name="redirect" value="<1%=redirect%>" /-->		
		<portlet:param name="redirect" value="<%= redirectWf%>" />
		<portlet:param name="userIdXLT" value="<%= String.valueOf(userIdXLT) %>" />
		<!-- end -->	
		<% if (rutLai) { %>
			<portlet:param name="rutLai" value="<%= String.valueOf(rutLai) %>" />
			<portlet:param name="receiverIdBack" value="<%= String.valueOf(receiverIdBack) %>" />
		<% } %>
	</portlet:actionURL>
	
	<%	
	if ("xoacongvan".equalsIgnoreCase(taskAction.getTaskActionName())  )  {%>
	
	<span id= "xoacongvan">
		<input class="button" onclick="resultSaveDodument('<%= documentReceiptType%>')" type="button" value='<liferay-ui:message	key="<%=taskAction.getTaskActionName()%>" />'/>
		</span>
		<script type="text/javascript">
			function resultSaveDodument(documentType){					
				
					if (confirm('<%= UnicodeLanguageUtil.get(pageContext, "are-you-sure-you-want-to-delete-this-document") %>')) {
						javascript:submitForm(document.hrefFm, '<%=form%>');
					}
			}
			</script>
	
	<%}	
	
	else if (("1".equalsIgnoreCase(documentReceiptType))&& ("soancongvandi".equalsIgnoreCase(taskAction.getTaskActionName())|| "congvanbaocao".equalsIgnoreCase(taskAction.getTaskActionName())  ) ) {
		
	}
	else if (("2".equalsIgnoreCase(documentReceiptType))&& ("soancongvandi".equalsIgnoreCase(taskAction.getTaskActionName())|| "congvanluu".equalsIgnoreCase(taskAction.getTaskActionName())  ) ) {
		
	}
	
	else if (("3".equalsIgnoreCase(documentReceiptType))&& ("congvanbaocao".equalsIgnoreCase(taskAction.getTaskActionName())|| "congvanluu".equalsIgnoreCase(taskAction.getTaskActionName())  ) ) {
		
	}
	
	else {
		
		
		if ("1".equalsIgnoreCase(documentReceiptType) && "congvanluu".equalsIgnoreCase(taskAction.getTaskActionName())) {
		%>	
			<span id= "congvanluu">
			<input class="button" onclick="resultSaveDodument('<%= documentReceiptType%>')" type="button" value='<liferay-ui:message	key="<%=taskAction.getTaskActionName()%>" />'/>
			</span>
			<script type="text/javascript">
				function resultSaveDodument(documentType){					
					//if ("1".equalsIgnoreCase(documentType) && "congvanluu".equalsIgnoreCase(taskAction.getTaskActionName())) {
						if (confirm('<%= UnicodeLanguageUtil.get(pageContext, "are-you-sure-you-want-to-save-this-document") %>')) {
							javascript:submitForm(document.hrefFm, '<%=form%>');
						}
						
						
					}
					
				</script>
	<%	}else {  
	%>
		<span id= "congvan"  onclick="javascript:submitForm(document.hrefFm, '<%=form%>');">
			<input class="button" type="button" value='<liferay-ui:message key="<%=taskAction.getTaskActionName()%>" />'/>
		</span>
	<%}} %>
</c:if>
<%}
}
%>

