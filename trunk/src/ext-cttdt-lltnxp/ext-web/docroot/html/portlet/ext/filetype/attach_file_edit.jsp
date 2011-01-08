<%@ include file="/html/portlet/ext/filetype/init.jsp" %>

<%@page import="com.liferay.portal.kernel.util.Constants"%>

<%@page import="com.sgs.portlet.filetype.model.PmlFileType"%>
<%@page import="com.sgs.portlet.attachedfile.model.AttachedFile"%>
<%@page import="com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile"%>
<%@page import="com.sgs.portlet.filetype.service.persistence.PmlFileTypeUtil"%>
<%@page import="com.sgs.portlet.attachedfile.service.persistence.AttachedFileUtil"%>

<%
	String redirect = ParamUtil.getString(renderRequest, "redirect");

	PmlFileTypeAttachedFile pmlFileTypeAttachedFile = (request.getAttribute("fileTypeAttachFile") == null) ? null : (PmlFileTypeAttachedFile) request.getAttribute("fileTypeAttachFile");
	String fileTypeId = (request.getAttribute("fileTypeId") == null) ? "" : request.getAttribute("fileTypeId").toString();
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
<portlet:actionURL var="edit_process_filetype">
	<portlet:param name="struts_action" value="/sgs/filetype/view" />
	<portlet:param name="<%= Constants.CMD %>" value="EDIT_ATTACH_FILE" />
	<portlet:param name="tab" value="attach_file"/>
	<portlet:param name="pmlFileTypeAttachedFileId" value="<%= pmlFileTypeAttachedFile.getFiletypeAttachedFileId() %>"/>
	<portlet:param name="fileTypeId" value="<%= fileTypeId %>" />	
	<portlet:param name="redirectAttFile" value="<%= rowURLAttFile.toString() %>"/>
</portlet:actionURL>

<jsp:useBean id="fileTypeList" class="java.util.ArrayList" scope="request" />
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
<form action="<%=edit_process_filetype %>" method="post" class="table-border-pml" onsubmit="return <portlet:namespace />checkForm(this);">
	<input name="<portlet:namespace />fileTypeURL" type="hidden" value="<%= rowURLAttFile.toString() %>" /> 
	<div class="title_categ"><liferay-ui:message key="cap-nhat-thong-tin"/></div>
	 <div class="boxcontent">
	<table cellspacing="0" width="100%">
		<tr>
			<td width="20%"><label><bean:message key="sgs_filetype_filetypeName"/>:</label></td>
			<td>
				<input style="width: 95%" name="fileTypeId" value="<%= PmlFileTypeUtil.findByPrimaryKey(pmlFileTypeAttachedFile.getFileTypeId()).getFileTypeName() %>" disabled="disabled"/>
			</td>
		</tr>
		
		<tr>
			<td ><label><liferay-ui:message	key='sgs_onedoor_attached_file_name' />:</label></td>
			<td>
				<input style="width: 50%" name="attachedFileId" value="<%= AttachedFileUtil.findByPrimaryKey(pmlFileTypeAttachedFile.getAttachedFileId()).getAttachedFileName() %>" disabled="disabled"/>
			</td>
		</tr>
		
		<tr>
			<td ><label><liferay-ui:message key='sgs_onedoor_copy' />:</label></td>
			<td>
				<input style="width: 50%" type="text" name="copy" value="<%= pmlFileTypeAttachedFile.getCopy_() %>" id="copy"/>
			</td>
		</tr>
		
		<tr>
			<td ><label><liferay-ui:message key='sgs_onedoor_original' />:</label></td>
			<td>
				<input style="width: 95%" type="text" name="original" value="<%= pmlFileTypeAttachedFile.getOriginal() %>" id="original">
			</td>
		</tr>
		
		<tr valign="top">
			<td ><label><liferay-ui:message key='sgs_onedoor_note' />:</label></td>
			<td><textarea name="note" style="width: 95%" rows="5"><%= pmlFileTypeAttachedFile.getNote() %></textarea></td>
		
		</tr>
			<tr>
			<td></td>
				<td>
					<input style="margin-left: 0" type="submit" value='<bean:message key="update"/>' />&nbsp;&nbsp;
					<html:link action="/sgs/filetype/view"><input  type="button" value='<bean:message key="reset"/>' /></html:link>
					<span onclick="javascript:submitForm(document.hrefFm,'<%= rowURLAttFile.toString() %>');" ><input  type="button"	value='<liferay-ui:message key="back"/>' /></span>
				</td>
			</tr>
	</table>
</div>
</form>