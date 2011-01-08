<%@ include file="/html/portlet/ext/wardsmanagement/init.jsp" %>
<script type="text/javascript">
function <portlet:namespace />checkForm(form) {
	if(form.wardsCode.value == "") {
		alert("<liferay-ui:message key='vui-long-nhap-ma'/>");
		form.wardsCode.focus();
		return false;
	}
	if(form.wardsName.value == "") {
		alert("<liferay-ui:message key='vui-long-nhap-ten'/>");
		form.wardsName.focus();
		return false;
	}
	if(form.districtId.value == 0) {
		alert("<liferay-ui:message key='chon-quan-huyen'/>");
		form.districtId.focus();
		return false;
	}
	else {
		return true;
	}
}
</script>

<jsp:useBean id="listDistrict" class="java.util.ArrayList" scope="request" />
<jsp:useBean id="wardsForm" class="com.sgs.portlet.wardsmanagement.form.WardsForm" scope="request" />
<%
	String redirect = renderRequest.getParameter("redirect");
%>
<portlet:renderURL var="edit_process_wards">
	<portlet:param name="struts_action" value="/sgs/wardsmanagement/view" />
	<portlet:param name="cmd" value="edit_process" />
	<portlet:param name="redirect" value="<%= redirect %>" />
</portlet:renderURL>

<form action="<%=edit_process_wards %>" method="post" onsubmit="return <portlet:namespace />checkForm(this);" class="table-border-pml">
<div class="title_categ"><liferay-ui:message key="cap-nhat-thong-tin"/></div>
<div class="boxcontent">
<table cellspacing="0" width="100%">
<tr>
	<td width="15%"><label><liferay-ui:message key="wardsmanagement.id" />&nbsp;:<font class="validate">(*)</font></label></td>
	<td><input type="text" name="wardsId" value="<%=wardsForm.getWardsId() %>" style="width: 50%" readonly="readonly" /></td>
</tr>
<tr>
	<td><label><liferay-ui:message key="wardsmanagement.code" />&nbsp;:<font class="validate">(*)</font></label></td>
	<td><input type="text" name="wardsCode" value="<%=wardsForm.getWardsCode() %>" style="width: 50%" /></td>
</tr>
<tr>
	<td><label><liferay-ui:message key="wardsmanagement.name" />&nbsp;:<font class="validate">(*)</font></label></td>
	<td><input type="text" name="wardsName" value="<%=wardsForm.getWardsName() %>" style="width: 50%" /></td>
</tr>
<tr>
	<td><label><liferay-ui:message key="wardsmanagement.district-id" />&nbsp;:<font class="validate">(*)</font></label></td>
	<td>
		<select name="districtId" style="width: 96%">
			<option value="0">[<liferay-ui:message key="select" />]</option>
		<logic:iterate id="district" name="listDistrict" 
			type="com.sgs.portlet.districtmanagement.model.District" 
			indexId="i">
		
			<option value="<%=district.getDistrictId() %>" <% if(district.getDistrictId().equals(wardsForm.getDistrictId())) { %>selected="selected"<% } %>><%=district.getDistrictName() %></option>
			
		</logic:iterate>
		</select>
	</td>
</tr>
<tr valign="top">
	<td><label><liferay-ui:message key="wardsmanagement.description" /></label></td>
	<td><textarea name="description" style="width: 95%" rows="5"><%=wardsForm.getDescription() %></textarea></td>
</tr>
<tr>
	<td><label><liferay-ui:message key="wardsmanagement.active" /></label></td>
	<td><input type="checkbox" name="active" id="active" value="1" <% if(wardsForm.getActive() == 1) { %>checked="checked"<% } %> /></td>
</tr>
<tr>
	<td></td>
			<td>
			<input style="margin-left: 0" type="submit" name="button" id="button" value='<liferay-ui:message key="update" />' /> 
    		<input type="reset" name="reset" id="reset" value='<liferay-ui:message key="reset" />' />
			<span onclick="javascript:submitForm(document.hrefFm,'<%= redirect %>');"><input type="button"	value='<liferay-ui:message key="back"/>' /></span>
			</td>
		</tr>
</table>
</div>
</form>