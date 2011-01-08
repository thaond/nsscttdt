<%@ include file="/html/portlet/ext/filetype/init.jsp"%>
<%@page import="javax.portlet.PortletURL"%>

<%@page import="com.sgs.portlet.filetype.model.PmlFileType"%>
<%@page import="com.sgs.portlet.attachedfile.model.AttachedFile"%>
<%@page import="com.sgs.portlet.filetype.service.persistence.PmlFileTypeUtil"%>

<%
	String redirect = ParamUtil.getString(renderRequest, "redirect");
	String fileTypeId = (request.getAttribute("fileTypeId") == null) ? ""
			: request.getAttribute("fileTypeId").toString();
%>

<%				
	
		PortletURL rowURLAttFile = renderResponse.createRenderURL();
		rowURLAttFile.setWindowState(WindowState.NORMAL);
		rowURLAttFile.setParameter("struts_action", "/sgs/filetype/view");
		rowURLAttFile.setParameter(Constants.CMD,"VIEW_ATTACH_FILE");
		rowURLAttFile.setParameter("tab", "attach_file");
		rowURLAttFile.setParameter("fileTypeId", fileTypeId);
		rowURLAttFile.setParameter("redirect", redirect);
		
%>


<portlet:actionURL var="add_process_filetype">
	<portlet:param name="struts_action" value="/sgs/filetype/view" />
	<portlet:param name="<%= Constants.CMD %>" value="ADD_ATTACH_FILE" />
	<portlet:param name="tab" value="attach_file" />
	<portlet:param name="fileTypeId" value="<%= fileTypeId%>" />
	<portlet:param name="redirectAttFile" value="<%= rowURLAttFile.toString() %>"/>
</portlet:actionURL>

<jsp:useBean id="attachedFileList" class="java.util.ArrayList" scope="request" />

<script type="text/javascript">
	
	function <portlet:namespace />checkForm(form){
		var result = true;
		var original = form.original.value;
		var copy = form.copy.value;
		
		if (original == '') {
			alert('Please enter a value for original');
			result = false;
		} 
		
		if (copy == '') {
			alert('Please enter a value for copy');
			result = false;
		}
		
		if (isNaN(original) == true && isNaN(copy) == true) {
			if (parseInt(original) < 0) {
				alert('Please enter a positive number for original');
				result = false;
			}
			
			if (parseInt(copy) < 0) {
				alert('Please enter a positive number for copy');
				result = false;
			}  
		}
		return result;

	}
</script>

<form action="<%= add_process_filetype %>" method="post" onsubmit="return <portlet:namespace />checkForm(this);">
	<input name="<portlet:namespace />fileTypeURL" type="hidden" value="<%= rowURLAttFile.toString() %>" />
<div class="title_categ"><liferay-ui:message key="add_new"/></div>
<div class="boxcontent">
<table cellspacing="0" width="100%">
		<tr>
			<td width="20%"><label><bean:message key="sgs_filetype_filetypeName"/>:</label></td>
			<td><input style="width: 95%" type="text" name="fileTypeId" value="<%=PmlFileTypeUtil.findByPrimaryKey(fileTypeId).getFileTypeName()%>"
					disabled="disabled" /></td>
			</tr>
			<tr>
				<td ><label><liferay-ui:message	key='sgs_onedoor_attached_file_name' />:</label></td>
				<td><select name="selectedAttachedFile" style="width: 96%">
					<%
						for (int i = 0; i < attachedFileList.size(); i++) {
							AttachedFile attachedFile = (AttachedFile) attachedFileList
									.get(i);
					%>
					<option value="<%=attachedFile.getAttachedFileId()%>"><liferay-ui:message
						key="<%=attachedFile.getAttachedFileName()%>" /></option>
					<%
						}
					%>
				</select></td>
			</tr>
			<tr>
				<td ><label><liferay-ui:message key='sgs_onedoor_copy' />:</label></td>
				<td><input style="width: 50%" type="text" name="copy" id="copy"/></td>
			</tr>
			<tr>
				<td ><label><liferay-ui:message key='sgs_onedoor_original' />:</label></td>
				<td><input style="width: 50%" type="text" name="original" id="original"></td>
			</tr>
			<tr>
				<td ><label><liferay-ui:message key='sgs_onedoor_note' />:</label></td>
				<td><textarea name="note" style="width: 95%" rows="5"></textarea></td>
			</tr>
			<tr>
				<td></td>
				<td>
					<input type="submit" style="margin-left: 0"
						value='<bean:message key="add_new"/>' />
						
					<html:link action="/sgs/filetype/view">
						<input  type="button" value='<bean:message key="reset"/>' />
					</html:link>
	
					<span onclick="javascript:submitForm(document.hrefFm,'<%= rowURLAttFile.toString() %>');" ><input type="button"	value='<liferay-ui:message key="back"/>' /></span>
				</td>
			</tr>
	</table>
</div>
</form>