<%@ include file="/html/portlet/ext/districtmanagement/init.jsp" %>
<%@page import="com.sgs.portlet.districtmanagement.model.District"%>
<%@page import="com.sgs.portlet.districtmanagement.service.DistrictLocalServiceUtil"%>
<%@page import="com.sgs.portlet.districtmanagement.DistrictCodeSameCodeException"%>
<%@ include file="/html/portlet/ext/districtmanagement/js/district_js.jsp" %>
<%
	//District district = (District)renderRequest.getAttribute("district");
	String redirect = renderRequest.getParameter("redirect");
	String districtId = ParamUtil.getString(request, "districtId");
	District district = null;
	try {
		district = DistrictLocalServiceUtil.getDistrict(districtId);
	} catch (Exception e) { }
%>


<portlet:actionURL var="edit_process_district">
	<portlet:param name="struts_action" value="/sgs/districtmanagement/view" />
	<portlet:param name="cmd" value="edit_process" />
	<portlet:param name="districtId" value='<%= district.getDistrictId() %>' />
	<portlet:param name="redirect" value='<%=redirect %>' />
</portlet:actionURL>

<form action="<%=edit_process_district %>" method="post" onsubmit="return <portlet:namespace />checkForm(this);" enctype="multipart/form-data">
<div class="title_categ"><liferay-ui:message key="cap-nhat-thong-tin"/></div>
<div class="boxcontent">
<liferay-ui:error exception="<%= DistrictCodeSameCodeException.class %>" message="ma-quan-huyen-khong-duoc-trung" />
<table cellspacing="0"  width="100%">

<tr>
	<td width="20%"><label><liferay-ui:message key="districtmanagement.code" />&nbsp;:<font class="validate">(*)</font></label></td>
	<td><input type="text" name="districtCode" value="<%=district.getDistrictCode() %>" style="width: 50%" id="districtCode"/></td>
</tr>

<tr>
	<td><label><liferay-ui:message key="districtmanagement.name" />&nbsp;:<font class="validate">(*)</font></label></td>
	<td><input type="text" name="districtName" value="<%=district.getDistrictName() %>" style="width: 95%" /></td>
</tr>

<tr>
	<td><label><liferay-ui:message key="districtmanagement.city-id" />&nbsp;:<font class="validate">(*)</font></label></td>
	<td>
		<select name="cityID" style="width: 96%">
			<option value="0">[<liferay-ui:message key="select" />]</option>
		<logic:iterate id="city" name="listCity" 
			type="com.sgs.portlet.citymanagement.model.City" 
			indexId="i">
		
			<option value="<%=city.getCityID() %>" <% if(city.getCityID().equals(district.getCityID())) { %>selected="selected"<% } %>><%=city.getCityName() %></option>
			
		</logic:iterate>
		</select>
	</td>
</tr>

<tr valign="top">
	<td><label><liferay-ui:message key="districtmanagement.description" />&nbsp;:</label></td>
	<td><textarea style="width: 95%" name="description" rows="5"><%=district.getDescription() %></textarea></td>
</tr>

<tr>
	<td><label><liferay-ui:message key="districtmanagement.active" />&nbsp;:</label></td>
	<td><input type="checkbox" name="active" id="active" <%= district.getActive().equals("1")? "checked=checked" : "" %> /></td>
</tr>

<tr>
	<td></td>
	<td>
		<input style="margin-left: 0" type="submit" value='<liferay-ui:message key="update" />' />
		<input type="reset" value='<liferay-ui:message key="reset" />' />
		<span onclick="javascript:submitForm(document.hrefFm,'<%= redirect %>');"><input type="button"	value='<liferay-ui:message key="back"/>' /></span>
	</td>
</tr>
</table>
</div>
</form>