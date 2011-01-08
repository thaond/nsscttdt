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

<portlet:actionURL var="add_process_field">
	<portlet:param name="struts_action" value="/sgs/field/view" />
	<portlet:param name="cmd" value="add_process" />
</portlet:actionURL>

<jsp:useBean id="listDepartments" class="java.util.ArrayList" scope="request" />

<form  action="<%=add_process_field %>" method="post" onsubmit="return <portlet:namespace />validateForm(this);">
<table width="100%" cellspacing="0">
<tr><td align="left"  style="cursor:pointer">
        <a onclick="window.history.back()"> 
			<img alt="Back" src="/sgs-portal-skin/images/custom/back.png" border="0">                       
			<bean:message key="TaggsContent.DisplayFullContent.Back" />
		</a>
	</td> 
</tr>
</table>

<table cellspacing="0" width="100%" >
<tr><td class="blank-height-20"></td></tr>
<tr>
	<td  align="right"><bean:message key="sgs_field_fieldCode"/>&nbsp;<font class="validate">(*)</font>:</td>
	<td><input type="text" name="_fieldCode" value="" class="form-text-200" /></td>
</tr><tr height="10"></tr>
<tr>
	<td align="right"><bean:message key="sgs_field_fieldName"/>&nbsp;<font class="validate">:</font></td>
	<td><input type="text" name="_fieldName" value="" class="form-text-200" /></td>
</tr><tr height="10"></tr>
<tr>
	<td align="right"><bean:message key="sgs_field_description"/>:</td>
	<td><textarea name="_description" class="form-textarea" rows="4" style="width: 40%"></textarea></td>
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
	<td><input type="checkbox" name="_active" id="active" value="1" /></td>
</tr><tr height="10"></tr>
<tr>
	<td></td>
	<td>
		<input style="margin-left: 0;" type="submit" value='<bean:message key="sgs_field_save"/>' />&nbsp;&nbsp;
		<html:link action="/sgs/field/view"><input class="button-width" type="reset" value='<bean:message key="sgs_field_reset"/>' /></html:link>
	</td>
</tr>
</table>

</form>