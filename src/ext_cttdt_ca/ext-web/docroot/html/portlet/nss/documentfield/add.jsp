<%@ include file="/html/portlet/nss/documentfield/init.jsp" %>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>

<%@page import="com.nss.portlet.documentfield.FieldCodeSameCodeException"%>
<%@page import="com.nss.portlet.department.model.Department"%>
<%
	String redirect = ParamUtil.getString(renderRequest, "redirect");

	List<Department> listDepartment = request.getAttribute("listDepartment") == null ? new ArrayList<Department>() : (List<Department>)request.getAttribute("listDepartment");
	
	String fieldFlag = request.getAttribute("fieldFlag") == null ? "" : String.valueOf(request.getAttribute("fieldFlag"));
	
	String code = "";
	String name = "";
	String departmentId = "";
	String description = "";
	
	if (fieldFlag.equals("fail")) { // Them that bai
		listDepartment = request.getAttribute("listDepartment") == null ? new ArrayList<Department>() : 
						(List<Department>)request.getAttribute("listDepartment");
		code = ParamUtil.getString(request, "code");
		name = ParamUtil.getString(request, "name");
		departmentId = ParamUtil.getString(request, "departmentId");
		description = ParamUtil.getString(request, "description");
	}
%>

<portlet:actionURL var="add">
	<portlet:param name="struts_action" value="/nss/documentfield/add"/>
	<portlet:param name="redirect" value="<%=redirect %>"/>
</portlet:actionURL>


<script type="text/javascript" >
 
function validateForm()
{
	var code = document.getElementById("code");
	var name = document.getElementById("name");
	var department = document.getElementById("department");
	if (code.value.trim() == "") { 
		alert("<liferay-ui:message key='nhapmaphanloai'/> \n");
		code.focus();
		return false;
	}
	if (name.value.trim() == "" ) {
		alert("<liferay-ui:message key='nhaptenphanloai'/> \n");
		name.focus();
		return false;
	}
	if (department.value.trim() == "" ) {
		alert("<liferay-ui:message key='nhapphongban'/>");
		department.focus();
		return false;
	}
	else{
		return true;
	}
} 
</script>

<form action="<%= add %>" method="post" onsubmit="return validateForm();" enctype="multipart/form-data">
<div class="commom-form">
<div class="parent-title"><liferay-ui:message key="field-them-linh-vuc-ho-so"/></div>
<liferay-ui:error exception="<%= FieldCodeSameCodeException.class %>" message="ma-linh-vuc-ho-so-khong-duoc-trung" />
	<table cellspacing="0" width="100%">
		<tr>
			<td width="15%" ><label><liferay-ui:message key='field.code'/>&nbsp;: <font color="#FF0000">(*)</font>:</label></td>
			<td >
				<input type="text" id="code" name="<portlet:namespace/>code" style="width:50%" value="<%= code %>"/>	
			</td>
		</tr>
		<tr>
			<td><label><liferay-ui:message key='field.name'/>&nbsp;: <font color="#FF0000">(*)</font> : </label></td>
			<td>
				<input id="name"  name="<portlet:namespace />name" type="text" style="width:50%" value="<%= name %>">					
			</td>
		</tr>
		<tr>
			<td><label><liferay-ui:message key='field.department'/>&nbsp;: <font color="#FF0000">(*)</font>:</label></td>
			<td>
				<select style="width: 96%" id="department" name="<portlet:namespace />departmentId">
					<option value="">[<liferay-ui:message key='chonphongban'/>]</option>
					<logic:iterate id="department" name="listDepartment" indexId="i" type="com.nss.portlet.department.model.Department" scope="request" >
					<option value="<%=department.getDepartmentsId() %>" <% if(department.getDepartmentsId().equals(departmentId)) { %>selected="selected"<% } %>><%=department.getDepartmentsName() %></option>
					</logic:iterate>
				</select>
			</td>
		</tr>
		<tr>
			<td valign="top"><label><liferay-ui:message key="description"/>&nbsp;:</label></td>
			<td><textarea name="<portlet:namespace />description" style="width:95%" rows="5" ><%= description %></textarea></td>
		</tr>
		<tr>
			<td></td>
			<td>
				<input style="margin-left: 0;" type='submit'  name='addfieldbtn' value='<liferay-ui:message key="luu"/>' />
				<input  type="reset" value='<liferay-ui:message key="reset"/>'>
				<span onclick="javascript:submitForm(document.hrefFm,'<%= redirect %>');"><input class="button-width" type="button" value='<liferay-ui:message key="back"/>' ></span>
			</td>
		</tr>
	</table>
</div>
</form>