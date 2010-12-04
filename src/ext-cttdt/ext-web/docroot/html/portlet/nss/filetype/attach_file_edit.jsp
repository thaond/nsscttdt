<%@ include file="/html/portlet/nss/filetype/init.jsp" %>

<%@page import="com.liferay.portal.kernel.util.Constants"%>

<%@page import="com.nss.portlet.filetype.model.PmlFileTypeAttachedFile"%>
<%@page import="com.nss.portlet.filetype.service.PmlFileTypeLocalServiceUtil"%>
<%@page import="com.nss.portlet.attachedfile.service.AttachedFileLocalServiceUtil"%>

<%@ include file="/html/portlet/nss/filetype/js/attached_file_js.jsp" %>

<%
	String redirect = ParamUtil.getString(renderRequest, "redirect");

	PmlFileTypeAttachedFile pmlFileTypeAttachedFile = (request.getAttribute("fileTypeAttachFile") == null) ? null : (PmlFileTypeAttachedFile) request.getAttribute("fileTypeAttachFile");
	String fileTypeId = (request.getAttribute("fileTypeId") == null) ? "" : request.getAttribute("fileTypeId").toString();

	PortletURL rowURLAttFile = renderResponse.createRenderURL();
	rowURLAttFile.setWindowState(WindowState.NORMAL);
	rowURLAttFile.setParameter("struts_action", "/nss/filetype/view");
	rowURLAttFile.setParameter(Constants.CMD,"VIEW_ATTACH_FILE");
	rowURLAttFile.setParameter("tab", "attach_file");
	rowURLAttFile.setParameter("fileTypeId", fileTypeId);
	rowURLAttFile.setParameter("redirect", redirect);
		
%>

<portlet:actionURL var="edit_process_filetype">
	<portlet:param name="struts_action" value="/nss/filetype/view" />
	<portlet:param name="<%= Constants.CMD %>" value="EDIT_ATTACH_FILE" />
	<portlet:param name="tab" value="attach_file"/>
	<portlet:param name="pmlFileTypeAttachedFileId" value="<%= pmlFileTypeAttachedFile.getFiletypeAttachedFileId() %>"/>
	<portlet:param name="fileTypeId" value="<%= fileTypeId %>" />	
	<portlet:param name="redirectAttFile" value="<%= rowURLAttFile.toString() %>"/>
</portlet:actionURL>

<form action="<%=edit_process_filetype %>" method="post" class="table-border-pml" onsubmit="return <portlet:namespace />checkForm(this);">
	<input name="<portlet:namespace />fileTypeURL" type="hidden" value="<%= rowURLAttFile.toString() %>" /> 
	<div class="commom-form">
	<div class="parent-title"><liferay-ui:message key="cap-nhat"/></div>
	<table cellspacing="0" width="100%">
		<tr>
			<td width="20%"><label><bean:message key="sgs_filetype_filetypeName"/>:</label></td>
			<td>
				<input style="width: 95%" name="fileTypeId" value="<%= PmlFileTypeLocalServiceUtil.getPmlFileType(pmlFileTypeAttachedFile.getFileTypeId()).getFileTypeName() %>" disabled="disabled"/>
			</td>
		</tr>
		
		<tr>
			<td ><label><liferay-ui:message	key='sgs_onedoor_attached_file_name' />:</label></td>
			<td>
				<input style="width: 50%" name="attachedFileId" value="<%= AttachedFileLocalServiceUtil.getAttachedFile(pmlFileTypeAttachedFile.getAttachedFileId()).getAttachedFileName() %>" disabled="disabled"/>
			</td>
		</tr>
		
		<tr>
			<td ><label><liferay-ui:message key='sgs_onedoor_copy' /><font color="red">(*)</font>:</label></td>
			<td>
				<input style="width: 50%" type="text" name="copy" value="<%= pmlFileTypeAttachedFile.getCopy_() %>" id="copy"/>
			</td>
		</tr>
		
		<tr>
			<td ><label><liferay-ui:message key='sgs_onedoor_original' /><font color="red">(*)</font>:</label></td>
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
					<html:link action="/nss/filetype/view"><input  type="button" value='<bean:message key="reset"/>' /></html:link>
					<span onclick="javascript:submitForm(document.hrefFm,'<%= rowURLAttFile.toString() %>');" ><input  type="button"	value='<liferay-ui:message key="back"/>' /></span>
				</td>
			</tr>
	</table>
</div>
</form>