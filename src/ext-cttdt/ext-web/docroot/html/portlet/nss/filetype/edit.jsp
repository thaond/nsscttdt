<%@ include file="/html/portlet/nss/filetype/init.jsp" %>

<%@page import="com.liferay.portal.kernel.util.Constants"%>

<%@page import="java.util.List"%>
<%@page import="com.nss.portlet.documentfield.model.PmlField"%>
<%@page import="com.nss.portlet.documentfield.service.PmlFieldLocalServiceUtil"%>
<%@page import="com.nss.portlet.filetype.model.PmlFileType"%>
<%@page import="com.nss.portlet.filetype.service.PmlFileTypeLocalServiceUtil"%>
<%@page import="com.nss.portlet.filetype.FileTypeCodeSameCodeException"%>

<%@ include file="/html/portlet/nss/filetype/js/filetype_add_edit_js.jsp" %>

<%
	String redirect = renderRequest.getParameter("redirect");

	String fileTypeId = ParamUtil.getString(request, "fileTypeId");
	PmlFileType filetype = null;
	try {
		filetype = PmlFileTypeLocalServiceUtil.getPmlFileType(fileTypeId);
	} catch (Exception e) { }
	
%>

<portlet:actionURL var="edit_process_filetype">
	<portlet:param name="struts_action" value="/nss/filetype/view" />
	<portlet:param name="<%= Constants.CMD %>" value="<%= Constants.UPDATE %>" />	
	<portlet:param name="redirect" value="<%=redirect %>"/>
	<portlet:param name="fileTypeId" value="<%= filetype.getFileTypeId() %>"/>
</portlet:actionURL>


<form action="<%= edit_process_filetype %>" method="post" onsubmit="return <portlet:namespace />validateForm(this);" enctype="multipart/form-data">
<div class="title_categ"><liferay-ui:message key="cap-nhat"/></div>
<liferay-ui:error exception="<%= FileTypeCodeSameCodeException.class %>" message="ma-loai-ho-so-khong-duoc-trung" />
 <div class="boxcontent">
	<table cellspacing="0" width="100%">
		<tr>
			<td width="20%"><label><liferay-ui:message key="sgs_filetype_filetypeCode"/>&nbsp;<font color="red">(*)</font>:</label></td>
			<td><input type="text" name="_fileTypeCode" value="<%=filetype.getFileTypeCode() %>" 
						style="width: 50%" id="fileTypeCode"/></td>
		</tr>
		<tr>
			<td ><label><liferay-ui:message key="sgs_filetype_filetypeName"/>&nbsp;<font color="red">(*)</font>:</label></td>
			<td><input type="text" name="_fileTypeName" value="<%=filetype.getFileTypeName() %>" style="width: 50%" /></td>
		</tr>
		
		
		<tr>
			<td ><label><liferay-ui:message key="sgs_filetype_fieldid"/>:&nbsp;</label></td>
			<td>
				<select name="_fieldId" style="width: 96%">
					<logic:iterate id="field" name="listField" type="com.nss.portlet.documentfield.model.PmlField"	indexId="i">
						<option id="optionID" <%= filetype.getFieldId().equals(field.getFieldId()) ? "selected" : "" %> value="<%= field.getFieldId()%>" ><%= field.getFieldName()%></option>
					</logic:iterate>
				</select>
			</td>
		</tr>
	
		
		<tr>
			<td ><label><liferay-ui:message key="sgs_filetype_templateid"/>:&nbsp;</label></td>
			<td>
				<select name="_templateId" style="width: 96%">
					<logic:iterate id="template" name="listTemplate" type="com.nss.portlet.generatetemplateid.model.IdTemplate"	indexId="i">
						<option id="optionID" <%= filetype.getTemplateId().equals(template.getTemplateId()) ? "selected" : "" %> value="<%= template.getTemplateId()%>" ><%= template.getDescription()%></option>
					</logic:iterate>
				</select>
			</td>
		</tr>
		
		
		<tr>
			<td ><label><liferay-ui:message key="sgs_filetype_processTime"/>&nbsp;<font color="red">(*)</font>:</label></td>
			<td><input type="text" name="_processTime" value="<%=filetype.getProcessTime() %>" style="width: 50%"/></td>
		</tr>
		
		
		<tr valign="top">
			<td ><label><liferay-ui:message key="description"/>:</label></td>
			<td><textarea style="width: 95%" name="_description" class="form-textarea" rows="5"><%=filetype.getDescription() %></textarea></td>
		</tr>
		
		
		<tr>
			<td ><label><liferay-ui:message key="active."/>:</label></td>
			<td><input type="checkbox" name="_active" id="active" value="1" <% if(filetype.getActive().equals("1")) { %>checked="checked"<% } %> /></td>
		</tr>
		
		
		<tr>
			<td ><label><liferay-ui:message key="sgs_filetype_current_receipt_number"/>:&nbsp;</label></td>
			<td><input type="text" name="_currentReceiptNumber" value="<%=filetype.getCurrentReceiptNumber() %>" style="width: 50%"/></td>
		</tr>
		
		
		<tr>
			<td ><label><liferay-ui:message key="sgs_filetype_receipt_template"/>:&nbsp;</label></td>
			<td><input type="text" name="_receiptTemplate" value="<%=filetype.getReceiptTemplate() %>" style="width: 95%"/></td>
		</tr>
		<tr>
			<td></td>
				<td>
					<input type="submit" style="margin-left: 0;" value='<liferay-ui:message key="update"/>' />
					<!-- html:link action="/nss/filetype/view" -->
					<input class="button-width" type="reset" value='<liferay-ui:message key="reset"/>' />
					<!-- /html:link -->
					<span onclick="javascript:submitForm(document.hrefFm,'<%= redirect %>');"><input  class="button" type="button"	value='<liferay-ui:message key="back"/>' /></span>
				</td>
			</tr>
	</table>

</div>
</form>