<%@ include file="/html/portlet/ext/filetype/init.jsp" %>
<%@page import="com.liferay.portal.kernel.util.Constants"%>

<%@page import="com.sgs.portlet.filetype.model.PmlFileType"%>
<%@page import="com.sgs.portlet.filetype.service.PmlFileTypeLocalServiceUtil"%>
<%@page import="com.sgs.portlet.filetype.FileTypeCodeSameCodeException"%>

<%@ include file="/html/portlet/ext/filetype/js/filetype.jsp" %>

<%
	String redirect = renderRequest.getParameter("redirect");

	String fileTypeId = ParamUtil.getString(request, "fileTypeId");
	PmlFileType filetype = null;
	try {
		filetype = PmlFileTypeLocalServiceUtil.getPmlFileType(fileTypeId);
	} catch (Exception e) { }
%>

<portlet:actionURL var="edit_process_filetype">
	<portlet:param name="struts_action" value="/sgs/filetype/view" />
	<portlet:param name="<%= Constants.CMD %>" value="<%= Constants.UPDATE %>" />	
	<portlet:param name="redirect" value="<%=redirect %>"/>
	<portlet:param name="fileTypeId" value="<%= filetype.getFileTypeId() %>"/>
</portlet:actionURL>


<form action="<%= edit_process_filetype %>" method="post" onsubmit="return <portlet:namespace />validateForm(this);" enctype="multipart/form-data">
<div class="title_categ"><liferay-ui:message key="cap-nhat-thong-tin"/></div>
<liferay-ui:error exception="<%= FileTypeCodeSameCodeException.class %>" message="ma-loai-ho-so-khong-duoc-trung" />
 <div class="boxcontent">
	<table cellspacing="0" width="100%">
		<tr>
			<td width="20%"><label><bean:message key="sgs_filetype_filetypeCode"/>&nbsp;<font color="red">(*)</font>:</label></td>
			<td><input type="text" name="_fileTypeCode" value="<%=filetype.getFileTypeCode() %>" 
						style="width: 50%" id="fileTypeCode"/></td>
		</tr>
		<tr>
			<td ><label><bean:message key="sgs_filetype_filetypeName"/>&nbsp;<font color="red">(*)</font>:</label></td>
			<td><input type="text" name="_fileTypeName" value="<%=filetype.getFileTypeName() %>" style="width: 50%" /></td>
		</tr>
		
		
		<tr>
			<td ><label><bean:message key="sgs_filetype_fieldid"/>:&nbsp;</label></td>
			<td>
				<select name="_fieldId" style="width: 96%">
					<logic:iterate id="field" name="listField" type="com.sgs.portlet.field.model.PmlField"	indexId="i">
						<OPTION id="optionID" <%= filetype.getFieldId().equals(field.getFieldId()) ? "selected" : "" %> value="<%= field.getFieldId()%>" ><%= field.getFieldName()%></OPTION>
					</logic:iterate>
				</select>
			</td>
		</tr>
	
		
		<tr>
			<td ><label><bean:message key="sgs_filetype_templateid"/>:&nbsp;</label></td>
			<td>
				<select name="_templateId" style="width: 96%">
					<logic:iterate id="template" name="listTemplate" type="com.sgs.portlet.generatetemplateid.model.IdTemplate"	indexId="i">
						<OPTION id="optionID" <%= filetype.getTemplateId().equals(template.getTemplateId()) ? "selected" : "" %> value="<%= template.getTemplateId()%>" ><%= template.getDescription()%></OPTION>
					</logic:iterate>
				</select>
			</td>
		</tr>
		
		
		<tr>
			<td ><label><bean:message key="sgs_filetype_processTime"/>&nbsp;<font color="red">(*)</font>:</label></td>
			<td><input type="text" name="_processTime" value="<%=filetype.getProcessTime() %>" style="width: 50%"/></td>
		</tr>
		
		
		<tr valign="top">
			<td ><label><bean:message key="sgs_field_description"/>:</label></td>
			<td><textarea style="width: 95%" name="_description" class="form-textarea" rows="5"><%=filetype.getDescription() %></textarea></td>
		</tr>
		
		
		<tr>
			<td ><label><bean:message key="sgs_field_active"/>:</label></td>
			<td><input type="checkbox" name="_active" id="active" value="1" <% if(filetype.getActive().equals("1")) { %>checked="checked"<% } %> /></td>
		</tr>
		
		
		<tr>
			<td ><label><bean:message key="sgs_filetype_current_receipt_number"/>:&nbsp;</label></td>
			<td><input type="text" name="_currentReceiptNumber" value="<%=filetype.getCurrentReceiptNumber() %>" style="width: 50%"/></td>
		</tr>
		
		
		<tr>
			<td ><label><bean:message key="sgs_filetype_receipt_template"/>:&nbsp;</label></td>
			<td><input type="text" name="_receiptTemplate" value="<%=filetype.getReceiptTemplate() %>" style="width: 95%"/></td>
		</tr>
		<tr>
			<td></td>
				<td>
					<input type="submit" style="margin-left: 0;" value='<bean:message key="update"/>' />
					<html:link action="/sgs/filetype/view"><input class="button-width" type="button" value='<bean:message key="reset"/>' /></html:link>
					<span onclick="javascript:submitForm(document.hrefFm,'<%= redirect %>');"><input  class="button" type="button"	value='<liferay-ui:message key="back"/>' /></span>
				</td>
			</tr>
	</table>

</div>
</form>