<%@ include file="/html/portlet/nss/position/init.jsp" %>

<%@page import="javax.portlet.PortletURL"%>
<%@page import="javax.portlet.WindowState"%>

<%@page import="com.nss.portlet.position.model.Position"%>
<%@page import="com.nss.portlet.position.PositionCodeSameCodeException"%>
<%@page import="com.nss.portlet.position.service.PositionLocalServiceUtil"%>

<script type="text/javascript">
function checkformPosition( form )
{
   if (form.positionCode.value.trim() == "" || null == form.positionCode.value.trim()) {
	   alert("<liferay-ui:message key='nhap-ma'/>");
	   form.positionCode.focus();
	   return false ;
  }
  else if (form.positionName.value.trim() == "" || null == form.positionName.value.trim()) {
	   alert("<liferay-ui:message key='vui-long-nhap-ten'/>");
	   form.positionName.focus();
	   return false ;
  }
   return true ;
}
</script>

<%
	String redirect = ParamUtil.getString(renderRequest, "redirect");

	PortletURL portletURL = renderResponse.createActionURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action", "/nss/position/view");
	
	String positionFlag = request.getAttribute("positionFlag") == null ? "" : String.valueOf(request.getAttribute("positionFlag"));
	
	String positionId = ParamUtil.getString(request, "positionId");
	String positionCode = "";
	String positionName = "";
	String description = "";
	Boolean active = true;
	
	if (positionFlag.equals("fail")) { // Them that bai
		positionCode = ParamUtil.getString(request, "positionCode");
		positionName = ParamUtil.getString(request, "positionName");
		description = ParamUtil.getString(request, "description");
		active = ParamUtil.getBoolean(request, "active");
	}
	
	Position position = null;
	try {
		position = PositionLocalServiceUtil.getPosition(positionId);
	} catch (Exception e) {}
%>


<form action="<%= portletURL.toString() %>" method="post" onSubmit="return checkformPosition(this);" enctype="multipart/form-data" name="<portlet:namespace />fm">
	<div class="commom-form">	
	<liferay-ui:error exception="<%= PositionCodeSameCodeException.class %>" message="ma-chuc-vu-khong-duoc-trung" />
<%

	if (positionId.equals("") || null == position) {
%>
<div class="parent-title"><liferay-ui:message key="add_new" /></div>
<table width="100%" cellspacing="0">
	<tr>
		<td width="15%"><label><liferay-ui:message key="code." /><font color="red">(*)</font>:</label></td>
		<td>
			<input style="width: 50%" type="text" name="<portlet:namespace />positionCode" id="positionCode" value="<%= positionCode %>"/>
		</td>		

		
	</tr>
	<tr>
		<td><label> <liferay-ui:message key="name." /><font color="red">(*)</font>:</label></td>
		
		<td>
			<input style="width: 50%" type="text" name="<portlet:namespace />positionName" id="positionName" value="<%= positionName %>"/>
		</td>
		

	</tr>
	<tr valign="top">
		<td><label> <liferay-ui:message key="description" />:</label></td>
		
		<td>
			<textarea style="width: 99%" name="<portlet:namespace />description" id="description" rows="5"><%= description %></textarea>
		</td>
		

	</tr>
	<tr>
		<td><label><liferay-ui:message key="active" />:</label></td>
		<td>
			<input name="<portlet:namespace />active" type="checkbox" id="active" checked="checked" value="<%= active %>"/>
		</td>
		

	</tr>
		<tr>
			<td></td>
			<td colspan="2">
				<input style="margin-left: 0;" name="<portlet:namespace /><%= Constants.CMD %>"	type="hidden" value="<%= Constants.ADD %>" />
				<input style="margin-left: 0;" type="submit" name="button" id="button" value='<liferay-ui:message key="luu" />' /> 
				<input type="reset" name="reset" id="reset" value='<liferay-ui:message key="reset" />' /> 
				<span onclick="javascript:submitForm(document.hrefFm,'<%= redirect %>');">
					<input type="button" value='<liferay-ui:message key="back"/>' />
				</span>
			</td>
		</tr>
</table>
<%
	} else {
%> 
<div class="parent-title"><liferay-ui:message key="cap-nhat"/></div>
<input type="hidden" name="<portlet:namespace />positionId" value="<%= positionId %>" />

<table width="100%" cellspacing="0">
	<tr>
		<td width="15%"><label> <liferay-ui:message key="code." /><font color="red">(*)</font>:</label></td>
		<td>
			<input type="text" style="width: 50%" name="<portlet:namespace />positionCode" id="positionCode" value="<%= position.getPositionCode() %>"/>
		</td>
		

	</tr>
	<tr>
		<td><label> <liferay-ui:message key="name." /><font color="red">(*)</font>:</label></td>
		<td>
			<input type="text" style="width: 50%" name="<portlet:namespace />positionName" id="positionName" value="<%= position.getPositionName() %>" />
		</td>
	

	</tr>
	<tr valign="top">
		<td><label><liferay-ui:message key="description" />:</label></td>
		
		<td>
			<textarea name="<portlet:namespace />description" style="width: 99%" id="description" rows="5"><%= position.getDescription() %>
			</textarea>
		</td>
		

	</tr>
	<tr>
		<td><label><liferay-ui:message key="active." />:</label></td>
		
		<td>
			<input name="<portlet:namespace />active" type="checkbox" id="active" <%= position.getActive().equals("1") ? "checked=checked" : "" %> />
		</td>
			

	</tr>
	<tr>
		<td></td>
			<td colspan="2">
				<input style="margin-left: 0;" name="<portlet:namespace /><%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" /> 
				<input style="margin-left: 0;" type="submit" name="button" id="button" value='<liferay-ui:message key="update" />' /> 
				<input  type="reset" name="reset" id="reset" value='<liferay-ui:message key="reset" />' /> 
				<span onclick="javascript:submitForm(document.hrefFm,'<%= redirect %>');">
					<input type="button" value='<liferay-ui:message key="back"/>' />
				</span>
			</td>
		</tr>
</table>

<%
	} 
%>
</div>
</form>
