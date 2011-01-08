<%@ include file="/html/portlet/ext/workflow_admin/init.jsp" %>
<script type="text/javascript">
function <portlet:namespace />check_filetype_upload() {
	
	var fileName =	document.getElementById("theFile").value;
	var type = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();

	if (fileName == "") {
		alert("<liferay-ui:message key='pccc-vuilongchontaptindinhkem'/>");
		return false;
	}
	var typeArr = ["xml"];
	
	for (var i = 0; i < typeArr.length; i++){
		if (typeArr[i] == type) {
			document.getElementById("nameFile").value = fileName.substring(0, fileName.length - 4);			
			return true;
		} else {
			alert("<liferay-ui:message key='sgs_chooseFileUpload'/>");
			return false;
		}
	}
	
}


</script>

<portlet:actionURL var="add_process_workflow_admin">
	<portlet:param name="struts_action" value="/sgs/workflow_admin/view" />
	<portlet:param name="cmd" value="add_process" />
</portlet:actionURL>
<jsp:useBean id="listfiletype" class="java.util.ArrayList" scope="request" />

<portlet:renderURL var="back">
	<portlet:param name="struts_action"	value="/sgs/workflow_admin/view" />			
</portlet:renderURL>
	
<form action="<%=add_process_workflow_admin %>" enctype="multipart/form-data" method="post" onsubmit="return <portlet:namespace />check_filetype_upload();">
<input type="hidden" name="<portlet:namespace />nameFile" id="nameFile"/>
	<table width="100%" cellspacing="0">
	<tr>
		<td width="20%"><bean:message key="sgs_filetype_filetypeName"/>&nbsp;:</td>
		<td><select id="_fileTypeId" name="_fileTypeId" style="width: 96%">
				<logic:iterate id="workflow" name="listfiletype" type="com.sgs.portlet.filetype.model.PmlFileType"	indexId="i" >
							<option id="optionID" value="<%= workflow.getFileTypeId()%>" ><%= workflow.getFileTypeName()%></option>
				</logic:iterate>
			</select>
		</td>
	</tr>
	<tr>
		<td><bean:message key="sgs_fileName"/>&nbsp;:</td>
		<td>
			<input style="width: 95%" type="file" name="<portlet:namespace />theFile" id="theFile"/>
		</td>
	</tr>
	<tr>
		<td></td>
		<td>
			<input style="margin-left: 0;" type="submit" value='<liferay-ui:message key="save"/>' />
			<input type="reset" value='<liferay-ui:message key="reset"/>' />
			<input onclick="window.history.back()" type="button"	value='<liferay-ui:message key="back"/>' />
		</td>
	</tr>
	</table>
</form>
