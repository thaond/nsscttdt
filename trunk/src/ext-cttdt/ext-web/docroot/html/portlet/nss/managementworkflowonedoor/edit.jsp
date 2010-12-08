<%@ include file="/html/portlet/nss/managementworkflowonedoor/init.jsp" %>

<jsp:useBean id="listdepartments" class="java.util.ArrayList" scope="request" />
<jsp:useBean id="listfiletype" class="java.util.ArrayList" scope="request" />
<jsp:useBean id="workflowform" class="com.nss.portlet.managementworkflowonedoor.form.PmlWorkFlowForm" scope="request" />

<portlet:actionURL var="edit_process_workflow_admin">
	<portlet:param name="struts_action" value="/sgs/workflow_admin/view" />
	<portlet:param name="cmd" value="edit_process" />
</portlet:actionURL>
	
<form action="<%=edit_process_workflow_admin %>" method="post" onsubmit="return <portlet:namespace />validateForm(this);">
	<table width="100%" cellspacing="0">
		<tr>
		<td align="left" style="cursor:pointer">
	        <a onclick="window.history.back()"> 
	        <img alt="Back" src="/sgs-portal-skin/images/custom/back.png" border="0">                       
			<bean:message key="TaggsContent.DisplayFullContent.Back" />
			</a>
		</td> 
		</tr>
	</table>

	<br>

	<table cellspacing="0" width="100%">
	<tr>
		<td><input type="hidden" name="_workflowId" value="<%=workflowform.get_workflowId() %>"  readonly="readonly" /></td>
	</tr>
	<tr>
		<td width="20%"><bean:message key="sgs_filetype_filetypeName"/>&nbsp;:</td>
		<td>
			<select name="_fileTypeId" style="width: 96%">
				<logic:iterate id="workflow" name="listfiletype" type="com.sgs.portlet.onedoor.model.PmlFileType"	indexId="i">
	
							<OPTION id="optionID" value="<%= workflow.getFileTypeId()%>" ><%= workflow.getFileTypeName()%></OPTION>
	
				</logic:iterate>
			</select>
		</td>
	</tr>
	<tr>
		<td><bean:message key="sgs_onedoor_workflowadmin_workflow"/>&nbsp;:</td>
		<td>
			<input style="width: 95%" type="file" name="<portlet:namespace />theFile" id="theFile"/>
		</td>
	</tr>
	
	<tr>
		<td></td>
		<td>
			<input type="submit" value='Save' />
			
		</td>
	</tr>
	</table>
</form>
