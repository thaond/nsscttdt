<%@ include file="/html/portlet/nss/filetype/init.jsp" %>
<%@page import="javax.portlet.PortletURL"%>

<%@page import="com.nss.portlet.attachedfile.model.AttachedFile"%>
<%@page import="com.nss.portlet.filetype.service.PmlFileTypeLocalServiceUtil"%>

<%@ include file="/html/portlet/nss/filetype/js/attached_file_js.jsp" %>
<%
	String redirect = ParamUtil.getString(renderRequest, "redirect");
	String fileTypeId = (request.getAttribute("fileTypeId") == null) ? ""
			: request.getAttribute("fileTypeId").toString();
	
	PortletURL rowURLAttFile = renderResponse.createRenderURL();
	rowURLAttFile.setWindowState(WindowState.NORMAL);
	rowURLAttFile.setParameter("struts_action", "/nss/filetype/view");
	rowURLAttFile.setParameter(Constants.CMD,"VIEW_ATTACH_FILE");
	rowURLAttFile.setParameter("tab", "attach_file");
	rowURLAttFile.setParameter("fileTypeId", fileTypeId);
	rowURLAttFile.setParameter("redirect", redirect);
		
%>

<portlet:actionURL var="add_process_filetype">
	<portlet:param name="struts_action" value="/nss/filetype/view" />
	<portlet:param name="<%= Constants.CMD %>" value="ADD_ATTACH_FILE" />
	<portlet:param name="tab" value="attach_file" />
	<portlet:param name="fileTypeId" value="<%= fileTypeId%>" />
	<portlet:param name="redirectAttFile" value="<%= rowURLAttFile.toString() %>"/>
</portlet:actionURL>

<jsp:useBean id="attachedFileList" class="java.util.ArrayList" scope="request" />

<form action="<%= add_process_filetype %>" method="post" onsubmit="return <portlet:namespace />checkForm(this);">
	<input name="<portlet:namespace />fileTypeURL" type="hidden" value="<%= rowURLAttFile.toString() %>" />
<div class="title_categ"><liferay-ui:message key="add_new"/></div>
<div class="boxcontent">
<table cellspacing="0" width="100%">
		<tr>
			<td width="20%"><label><bean:message key="sgs_filetype_filetypeName"/>:</label></td>
			<td><input style="width: 95%" type="text" name="fileTypeId" value="<%=PmlFileTypeLocalServiceUtil.getPmlFileType(fileTypeId).getFileTypeName()%>"
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
				<td ><label><liferay-ui:message key='sgs_onedoor_copy' /><font color="red">(*)</font>:</label></td>
				<td><input style="width: 50%" type="text" name="copy" id="copy"/></td>
			</tr>
			<tr>
				<td ><label><liferay-ui:message key='sgs_onedoor_original' /><font color="red">(*)</font>:</label></td>
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
						
					<!-- html:link action="/nss/filetype/view" -->
						<input type="reset" value='<bean:message key="reset"/>' />
					<!-- /html:link -->
	
					<span onclick="javascript:submitForm(document.hrefFm,'<%= rowURLAttFile.toString() %>');" ><input type="button"	value='<liferay-ui:message key="back"/>' /></span>
				</td>
			</tr>
	</table>
</div>
</form>