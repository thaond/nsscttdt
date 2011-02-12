<%@ include file="/html/portlet/ext/field/init.jsp" %>

<script type="text/javascript">
function <portlet:namespace />validateForm(form){
	var fieldCode = form._fieldCode.value;
	var fieldName = form._fieldName.value;
	var description = form._description.value;

	if (fieldCode == null || fieldCode == ""){
		alert('<bean:message key="sgs_field_empty_fieldCode"/>');
		return false;
	}
	else if (fieldCode.length > 20) {
		alert('<bean:message key="sgs_field_fieldCode_lenght"/>');
		return false;
	}
	else if (fieldName.length > 200) {
		alert('<bean:message key="sgs_field_fieldName_lenght"/>');
		return false;
	}
	else if (description.length > 4000){
		alert('<bean:message key="sgs_field_fieldDescription_lenght"/>');
		return false;
	}
	return true;
}
</script>

<jsp:useBean id="field" class="com.sgs.portlet.field.form.FieldForm" scope="request" />
<jsp:useBean id="listDepartments" class="java.util.ArrayList" scope="request" />

<portlet:actionURL var="edit_process_field">
	<portlet:param name="struts_action" value="/sgs/field/view" />
	<portlet:param name="cmd" value="edit_process" />
</portlet:actionURL>

<form action="<%=edit_process_field %>" method="post" onsubmit="return <portlet:namespace />validateForm(this);">
<div style="height: 480px; background-color: #EEEEEE">
<table width="100%" border="0" bgcolor="#EEEEEE" >
<tr><td align="left"  style="cursor:pointer">
                    <a onclick="window.history.back()"> 
						<img alt="Back" src="/sgs-portal-skin/images/custom/back.png" border="0">                       
						<bean:message key="TaggsContent.DisplayFullContent.Back" />
						</a>
					</td> </tr>
                  </table>
                 
<table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-add" bgcolor="#EEEEEE">
<tr><td class="blank-height-20"></td></tr>
<tr>
	<td><input type="hidden" name="_fieldId" value="<%=field.get_fieldId() %>" class="form-text-200" readonly="readonly" /></td>
</tr><tr height="10"></tr>
<tr>
	<td align="right"><bean:message key="sgs_field_fieldCode"/>&nbsp;<font color="#ff0000" class="validate">(*)</font>:</td>
	<td><input type="text" name="_fieldCode" value="<%=field.get_fieldCode() %>" class="form-text-200" /></td>
</tr><tr height="10"></tr>
<tr>
	<td align="right"><bean:message key="sgs_field_fieldName"/>:&nbsp;</td>
	<td><input type="text" name="_fieldName" value="<%=field.get_fieldName() %>" class="form-text-200" /></td>
</tr><tr height="10"></tr>
<tr>
	<td align="right"><bean:message key="sgs_field_description"/>:&nbsp;</td>
	<td><textarea name="_description" class="form-textarea"><%=field.get_description() %></textarea></td>
</tr><tr height="10"></tr>
<tr>
	<td align="right"><bean:message key="department_name"/>:&nbsp;</td>
	<td>
		<select name="_departmentsId">
			<logic:iterate id="department" name="listDepartments" type="com.sgs.portlet.department.model.Department"	indexId="i">

						<OPTION id="optionID" value="<%= department.getDepartmentsId()%>" ><%= department.getDepartmentsName()%></OPTION>

			</logic:iterate>
		</select>
	</td>
</tr><tr height="10"></tr>
<tr>
	<td align="right"><bean:message key="sgs_field_active"/>:</td>
	<td><input type="checkbox" name="_active" id="active" value="1" <% if(field.get_active().equals("1")) { %>checked="checked"<% } %> /></td>
</tr><tr height="10"></tr>
<tr>
	<td></td>
	<td>
		<input style="margin-left: 0;" type="submit" value='<bean:message key="sgs_field_save"/>' />&nbsp;&nbsp;
		<html:link action="/sgs/field/view"><input class="button-width" type="reset" value='<bean:message key="sgs_field_reset"/>' /></html:link>
	</td>
</tr>
</table>
</div>
</form>