<%@ include file="/html/portlet/nss/filetype/init.jsp" %>

<%@ include file="/html/portlet/nss/filetype/js/filetype_add_edit_js.jsp" %>

<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>

<%@page import="com.nss.portlet.filetype.FileTypeCodeSameCodeException"%>

<%
	String redirect = renderRequest.getParameter("redirect");
	String fileTypeFlag = request.getAttribute("fileTypeFlag") == null ? "" : String.valueOf(request.getAttribute("fileTypeFlag"));
	String fileTypeCode = "";
	String fileTypeName = "";
	String fieldId = "";
	String processTime = "";
	String description = "";
	Boolean active = true;
	String currentReceiptNumber = "";
	String receiptTemplate = "";
	String templateId = "";
	if (fileTypeFlag.equals("fail")) { // Them that bai
		fileTypeCode = ParamUtil.getString(request, "_fileTypeCode");
		fileTypeName = ParamUtil.getString(request, "_fileTypeName");
		fieldId = ParamUtil.getString(request, "_fieldId");
		processTime = ParamUtil.getString(request, "_processTime");
		description = ParamUtil.getString(request, "_description");
		active = ParamUtil.getBoolean(request, "_active");
		currentReceiptNumber = ParamUtil.getString(request, "_currentReceiptNumber");
		receiptTemplate = ParamUtil.getString(request, "_receiptTemplate");
		templateId = ParamUtil.getString(request, "_templateId");
	}
%>

<portlet:actionURL var="add_process_filetype">
	<portlet:param name="struts_action" value="/nss/filetype/view" />
	<portlet:param name="<%= Constants.CMD %>" value="<%= Constants.ADD %>" />
	<portlet:param name="redirect" value="<%= redirect %>"/>
</portlet:actionURL>

<form action="<%=add_process_filetype %>" method="post" onsubmit="return <portlet:namespace />validateForm(this);" class="table-border-pml" enctype="multipart/form-data">
<div class="commom-form">
<div class="parent-title"><liferay-ui:message key="add_new"/></div>
<liferay-ui:error exception="<%= FileTypeCodeSameCodeException.class %>" message="ma-loai-ho-so-khong-duoc-trung" />
<table cellspacing="0" width="100%">
		<tr>
			<td width="20%"><label><liferay-ui:message key="sgs_filetype_filetypeCode" />&nbsp;<font color="red">(*)</font>:</label></td>
			<td><input style="width: 50%" type="text" name="_fileTypeCode" id="fileTypeCode" value="<%= fileTypeCode %>"/></td>
		</tr>
		<tr>
			<td ><label><liferay-ui:message key="sgs_filetype_filetypeName"/>&nbsp;<font color="red">(*)</font>:</label></td>
			<td><input style="width: 50%" type="text" name="_fileTypeName" value="<%= fileTypeName %>"/></td>
		</tr>
		<tr>
			<td ><label><liferay-ui:message key="sgs_filetype_fieldid"/>:&nbsp;</label></td>
			<td>
				<select name="_fieldId" style="width: 96%">
					<logic:iterate id="field" name="listField" type="com.nss.portlet.documentfield.model.PmlField" indexId="i">
						<option id="optionID" value="<%= field.getFieldId()%>" 
								<% if(field.getFieldId().equals(fieldId)) { %> selected="selected" <% } %>>
								<%= field.getFieldName()%>
						</option>
					</logic:iterate>
				</select>
			</td>
		</tr>

		<tr>
			<td ><label><liferay-ui:message key="sgs_filetype_templateid"/>:&nbsp;</label></td>
			<td>
				<select name="_templateId" style="width: 96%">
					<logic:iterate id="template" name="listTemplate" type="com.nss.portlet.generatetemplateid.model.IdTemplate"	indexId="i">
						<option id="optionID" value="<%= template.getTemplateId()%>"
								<% if(String.valueOf(template.getTemplateId()).equals(templateId)) { %> selected="selected"<% } %>>
								<%= template.getDescription()%>
						</option>
					</logic:iterate>
				</select>
			</td>
		</tr>

		<tr>
			<td ><label><liferay-ui:message key="sgs_filetype_processTime"/>&nbsp;<font color="red">(*)</font>:</label></td>
			<td><input style="width: 50%" type="text" name="_processTime" value="<%= processTime %>" maxlength="10"/></td>
		</tr>

		<tr valign="top">
			<td ><label><liferay-ui:message key="description"/>:</label></td>
			<td><textarea style="width: 95%" name="_description" rows="5"><%= description %></textarea></td>
		</tr>

		<tr>
			<td ><label><liferay-ui:message key="active."/>:</label></td>
			<td><input type="checkbox" name="_active" id="active" checked="checked" value="<%= active %>"/></td>
		</tr>

		<tr>
			<td ><label><liferay-ui:message key="sgs_filetype_current_receipt_number"/>:&nbsp;</label></td>
			<td><input style="width: 50%" type="text" name="_currentReceiptNumber" value="<%= currentReceiptNumber %>"/></td>
		</tr>

		<tr>
			<td ><label><liferay-ui:message key="sgs_filetype_receipt_template"/>:</label></td>
			<td><input style="width: 95%" type="text" name="_receiptTemplate" value="<%= receiptTemplate %>"/></td>
		</tr>
		<tr>
			<td></td>
				<td>
					<input style="margin-left: 0;" type="submit" value='<liferay-ui:message key="luu"/>' />
					<!-- html:link action="/nss/filetype/view" -->
						<input class="button" type="reset" value='<liferay-ui:message key="reset"/>' />
					<!-- /html:link -->
					<span onclick="javascript:submitForm(document.hrefFm,'<%= redirect %>');"><input class="button" type="button" value='<liferay-ui:message key="back"/>' /></span>
				</td>
			</tr>
	</table>

</div>
</form>