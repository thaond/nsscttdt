<%@ include file="/html/portlet/ext/districtmanagement/init.jsp" %>
<%@ include file="/html/portlet/ext/districtmanagement/js/district_js.jsp" %>
<%@page import="com.sgs.portlet.districtmanagement.DistrictCodeSameCodeException"%>
<%@page import="com.sgs.portlet.citymanagement.model.City"%>
<%
	String redirect = renderRequest.getParameter("redirect");
	String districtFlag = request.getAttribute("districtFlag") == null ? "" : String.valueOf(request.getAttribute("districtFlag"));
	String districtCode = "";
	String districtName = "";
	String cityID = "";
	String description = "";
	Boolean active = true;
	if (districtFlag.equals("fail")) { // Them that bai
		districtCode = ParamUtil.getString(request, "districtCode");
		districtName = ParamUtil.getString(request, "districtName");
		cityID = ParamUtil.getString(request, "cityID");
		description = ParamUtil.getString(request, "description");
		active = ParamUtil.getBoolean(request, "active");
	}
%>

<portlet:actionURL var="add_process_district">
	<portlet:param name="struts_action" value="/sgs/districtmanagement/view" />
	<portlet:param name="cmd" value="add_process" />
	<portlet:param name="redirect" value="<%= redirect %>" />
</portlet:actionURL>

<form action="<%= add_process_district %>" method="post" onsubmit="return <portlet:namespace />checkForm(this);" enctype="multipart/form-data">
<div class="title_categ"><liferay-ui:message key="districtmanagement.button-add"/></div>
<div class="boxcontent">
<liferay-ui:error exception="<%= DistrictCodeSameCodeException.class %>" message="ma-quan-huyen-khong-duoc-trung" />
<table cellspacing="0" width="100%">
<tr>
	<td width="20%"><label><liferay-ui:message key="districtmanagement.code" />&nbsp;:<font class="validate">(*)</font></label></td>
	<td><input type="text" name="districtCode" value="<%= districtCode %>" style="width: 50%" id="districtCode"/></td>
</tr>

<tr>
	<td><label><liferay-ui:message key="districtmanagement.name" />&nbsp;:<font class="validate">(*)</font></label></td>
	<td><input type="text" name="districtName" value="<%= districtName %>" style="width: 95%" /></td>
</tr>

<tr>
	<td><label><liferay-ui:message key="districtmanagement.city-id" />&nbsp;:<font class="validate">(*)</font></label></td>
	<td>
		<select name="cityID" style="width: 96%">
			<option value="0">[<liferay-ui:message key="select" />]</option>
			
			<logic:iterate id="city" name="listCity" type="com.sgs.portlet.citymanagement.model.City" indexId="i">
				<option value="<%=city.getCityID() %>" <% if(city.getCityID().equals(cityID)) { %>selected="selected"<% } %>><%=city.getCityName() %></option>
			</logic:iterate>
		</select>
	</td>
</tr>

<tr valign="top">
	<td><label><liferay-ui:message key="districtmanagement.description" />&nbsp;:</label></td>
	<td><textarea name="description" style="width: 95%" rows="5"><%= description %></textarea></td>
</tr>

<tr>
	<td><label><liferay-ui:message key="districtmanagement.active" />&nbsp;:</label></td>
	<td><input type="checkbox" name="active" id="active" checked="checked" value="<%= active %>"/></td>
</tr>
<tr>
	<td></td>
			<td>
			<input style="margin-left: 0" type="submit" value='<liferay-ui:message key="add_new" />' />
			<input type="reset" value='<liferay-ui:message key="reset" />' />
			<span onclick="javascript:submitForm(document.hrefFm,'<%= redirect %>');">
				<input type="button"	value='<liferay-ui:message key="back"/>' />
			</span>
		 </td>
		</tr>
</table>
</div>
</form>