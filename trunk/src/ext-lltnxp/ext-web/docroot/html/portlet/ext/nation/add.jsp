<%@ include file="/html/portlet/ext/nation/init.jsp" %>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.sgs.portlet.country.model.Country"%>
<%@page import="javax.portlet.PortletURL"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />


<%
	String redirect = renderRequest.getParameter("redirect");
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setParameter("struts_action", "/sgs/nation/view" );
	portletURL.setParameter("redirect", redirect);
	
%>

<form action="<%= portletURL.toString() %>" method="post" onsubmit="return checkformNation(this);"
	name="<portlet:namespace />fm">
<%
	Nation nation = (Nation)renderRequest.getAttribute("nation");
	List listCountry = (List)renderRequest.getAttribute("listCountry");
%>
<%
if (nation == null || nation.getNationId().equals("")) {
%>
<div class="title_categ"><liferay-ui:message key="add_new"/></div>
<div class="boxcontent">
<table width="100%" cellspacing="0">
  <tr>
    <td width="10%">
    	<label>
    		<liferay-ui:message key="code." /><font size="1"  color="#ff0000">(*)</font>&nbsp;:
    	</label>
    </td>
    <td>
    	<input style="width: 20%" type="text" name="<portlet:namespace />nationCode" id="nationCode" />
    </td>
  </tr>
  <tr>
    <td>
    	<label>
    		<liferay-ui:message key="name." /><font size="1"  color="#ff0000">(*)</font>&nbsp;:
    	</label>
    </td>
    <td>
         <input style="width: 20%" type="text" name="<portlet:namespace />nationName" id="nationName" />
    </td>
  </tr>
  <tr>
    <td>
    	<label>
    		<liferay-ui:message key="country." />&nbsp;:
    	</label>
    </td>
    <td>
    	<select style="width: 21%" name="<portlet:namespace />countryId">
    	<%
    		for (int i = 0; i < listCountry.size(); i++) {
    			Country country = (Country)listCountry.get(i);
    	%>
    			<option value="<%=country.getCountryId() %>"><%=country.getCountryName() %></option>
    	<%
    		}
    	%>
    	</select>
    </td>
  </tr>
  <tr valign="top">
    <td>
    	<label>
    		<liferay-ui:message key="description." />&nbsp;:
    	</label>
    </td>
    <td>
    	<textarea style="width: 95%;" name="<portlet:namespace />description" id="description"  rows="5"></textarea>    </td>
  </tr>
  <tr>
    <td><label><liferay-ui:message key="active." />&nbsp;:</label></td>
    <td>
           <input  name="<portlet:namespace />active" type="checkbox" id="active" />   </td>
  </tr>
	<tr>
		<td></td>
			<td>
			<input name="<portlet:namespace /><%= Constants.CMD %>" type="hidden" value="<%= Constants.ADD %>" />
    		<input style="margin-left: 0" type="submit" name="button" id="button" value='<liferay-ui:message key="add_new" />' /> 
    		<input type="reset" name="reset" id="reset" value='<liferay-ui:message key="reset" />' />
    		<span onclick="javascript:submitForm(document.hrefFm,'<%= redirect %>');"><input class="button-width" type="button"	value='<liferay-ui:message key="back"/>' /></span>
		 </td>
		</tr>
</table>
</div>
<%
} else {
%>
<input type="hidden" name="<portlet:namespace />nationId" value="<%= nation.getNationId() %>" />
<div class="title_categ"><liferay-ui:message key="cap-nhat-thong-tin"/></div>
 <div class="boxcontent">
<table width="100%" cellspacing="0">
  <tr>
    <td width="8%">
    	<label>
    		<liferay-ui:message key="code." />&nbsp;:
    	</label>
    </td>
    <td>
    	<input type="text" style="width: 20%"  name="<portlet:namespace />nationCode"   id="nationCode" value="<%=nation.getNationCode() %>"/>
    </td>
  </tr>
  <tr>
    <td>
    	<label>
    		<liferay-ui:message key="name." />&nbsp;:
    	</label>
    </td>
    <td>
         <input type="text" style="width: 20%"	name="<portlet:namespace />nationName" 	id="nationName" value="<%=nation.getNationName() %>"/>
    </td>
  </tr>
  <tr>
    <td>
    	<label>
    		<liferay-ui:message key="country." />&nbsp;:
    	</label>
    </td>
    <td>
         <select style="width: 21%" name="<portlet:namespace />countryId">
    	<%
    		for (int i = 0; i < listCountry.size(); i++) {
    			Country country = (Country)listCountry.get(i);
    	%>
    			<option value="<%=country.getCountryId() %>"><%=country.getCountryName() %></option>
    	<%
    		}
    	%>
    	</select>
    </td>
  </tr>
  <tr valign="top">
    <td>
    	<label>
    		<liferay-ui:message key="description." />&nbsp;:
    	</label>
    </td>
    <td>
    	<textarea style="width: 95%;" name="<portlet:namespace />description"  id="description"  rows="5"><%=nation.getDescription() %></textarea>    
    </td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td><label><liferay-ui:message key="active." />&nbsp;:</label></td>
    <td>
           <input name="<portlet:namespace />active" 
           		  type="checkbox" 
           		  id="active" 
           		  <%=nation.getActive().equals("1") ? "checked=checked":""%>/>   
    </td>
    <td></td>
  </tr>
	<tr>
		<td></td>
			<td>
			<input name="<portlet:namespace /><%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />
    		<input style="margin-left: 0" type="submit" name="button" id="button" value='<liferay-ui:message key="update" />' /> 
    		<input type="reset" name="reset" id="reset" value='<liferay-ui:message key="reset" />' />
    		<span onclick="javascript:submitForm(document.hrefFm,'<%= redirect %>');"><input type="button"	value='<liferay-ui:message key="back"/>' /></span>
		 </td>
		</tr>
</table>
</div>
<%} %>
</form>
