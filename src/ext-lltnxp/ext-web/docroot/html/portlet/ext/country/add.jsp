<%@ include file="/html/portlet/ext/country/init.jsp"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%
	String redirect = renderRequest.getParameter("redirect");
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setParameter("struts_action", "/sgs/country/view" );
	portletURL.setParameter("redirect", redirect);
%>

<form action="<%=portletURL.toString()%>" method="post" onSubmit="return checkformCountry(this);"
	name="<portlet:namespace />fm">
<%
	Country country = (Country) renderRequest.getAttribute("country");
%> <%
 	if (Validator.isNull(country) || country.getCountryId().equals("")) {
 %>
<div class="title_categ"><liferay-ui:message key="add_new"/></div>
<div class="boxcontent">
<table width="100%" cellspacing="0">
	<tr>
		<td width="15%">
		<label><liferay-ui:message key="countryCode" />&nbsp;:</label>
		</td>
		<td><input type="text" name="<portlet:namespace />countryCode" style="width: 50%" id="countryCode" /></td>
		
	</tr>
     
	<tr>
		<td>
		<label><liferay-ui:message key="countryName" />&nbsp;:</label>
		</td>
		<td><input style="width: 50%" type="text" name="<portlet:namespace />countryName" id="countryName" /></td>
		
	</tr>
      
	<tr valign="top">
		<td>
		<label><liferay-ui:message key="description" />&nbsp;:</label>
		</td>
		<td><textarea name="<portlet:namespace />description" id="description" style="width: 98%" rows="5"></textarea></td>
		
	</tr>
      
	<tr>
		<td>
		<label><liferay-ui:message key="active" />&nbsp;:</label>
		</td>
		<td><input name="<portlet:namespace />active" type="checkbox"	id="active" checked="checked" /></td>
		<td></td>
	</tr>
	<tr>
		<td></td>
			<td>
			<input name="<portlet:namespace /><%=Constants.CMD%>" type="hidden" value="<%=Constants.ADD%>" /> 
			<input type="submit" style="margin-left: 0" name="button" id="button" value='<liferay-ui:message key="add_new" />' />
		<portlet:renderURL var="cancelAdd">
			<portlet:param name="<%=Constants.CMD%>"
				value="<%=Constants.CANCEL%>" />
		</portlet:renderURL> <a href="<%=cancelAdd %>"><input type="button" class="button"
			value='<liferay-ui:message key="reset" />' /></a>
    		<span onclick="javascript:submitForm(document.hrefFm,'<%= redirect %>');"><input class="button-width" type="button"	value='<liferay-ui:message key="back"/>' /></span>
		 </td>
		</tr>
</table>
</div>
<%
	}
	else {
%> 
<input type="hidden" name="<portlet:namespace/>countryId" value="<%=country.getCountryId()%>" id="countryId" />
<div class="title_categ"><liferay-ui:message key="cap-nhat-thong-tin"/></div>
<div class="boxcontent">
<table width="100%" cellspacing="0">
	<tr>
	<td width="15%"><label>	<liferay-ui:message key="countryId" />&nbsp;:</label>    </td>
    <td>
    	<input type="text" style="width: 50%"  name="<portlet:namespace />countryId" id="countryId" readonly="readonly"  value="<%=country.getCountryId() %>"/>
    </td>
    
  </tr> 
	<tr>
		<td>
		<label><liferay-ui:message key="countryCode" />&nbsp;:</label>
		</td>
		<td><input type="text" name="<portlet:namespace />countryCode" style="width: 50%" id="countryCode" value="<%=country.getCountryCode()%>" /></td>
		
	</tr> 
	<tr>
		<td>
		<label><liferay-ui:message key="countryName" />&nbsp;:</label>
		</td>
		<td><input type="text" name="<portlet:namespace />countryName" id="countryName" style="width: 50%" value="<%=country.getCountryName()%>" /></td>
		
	</tr> 
	<tr valign="top">
		<td>
		<label><liferay-ui:message key="description" />&nbsp;:</label>
		</td>
		<td><textarea name="<portlet:namespace />description" class="input-pml"
			id="description" style="width: 98%" rows="5"><%=country.getDescription()%></textarea></td>
		
	</tr> 
	<tr>
		<td>
		<label><liferay-ui:message key="active" />&nbsp;:</label>
		</td>
		<td><input name="<portlet:namespace />active" type="checkbox"
			id="active"
			<%=country.getActive().equals("1")
					? "checked=checked" : ""%> /></td>
	</tr> 
	<tr>
		<td></td>
			<td>
			<input name="<portlet:namespace /><%=Constants.CMD%>" type="hidden" value="<%=Constants.UPDATE%>" />	
			<input type="submit" style="margin-left: 0"	name="button" id="button" value='<liferay-ui:message key="update" />' />
			<portlet:renderURL var="cancelUpdate"><portlet:param name="<%=Constants.CMD%>" value="<%=Constants.CANCEL%>" />
			</portlet:renderURL>
			<a href="<%=cancelUpdate %>"><input type="button" class="button" value='<liferay-ui:message key="reset" />' /></a>
    		<span onclick="javascript:submitForm(document.hrefFm,'<%= redirect %>');"><input class="button-width" type="button"	value='<liferay-ui:message key="back"/>' /></span>
		 </td>
		</tr>
</table>
</div>
<%
	}
%>
</form>
