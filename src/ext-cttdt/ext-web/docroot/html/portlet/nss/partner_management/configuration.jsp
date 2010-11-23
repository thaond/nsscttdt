<%@ include file="/html/portlet/nss/partner_management/init.jsp" %>

<%
	String redirect = ParamUtil.getString(request, "redirect");
	PortletURL configurationActionURL = renderResponse.createActionURL();

	configurationActionURL.setParameter("struts_action", "/portlet_configuration/edit_configuration");
	configurationActionURL.setParameter("redirect", redirect);
	configurationActionURL.setParameter("backURL", redirect);
	configurationActionURL.setParameter("portletResource", portletResource);
%>

<form action="<%= configurationActionURL.toString() %>" method="post" name="<portlet:namespace />fm">
	
	<div id="div-head-title"><liferay-ui:message key="cau-hinh"/></div>
	<br />
	
	<table width="100%" border="0" class="lfr-table">
		<tr>
			<td>
			<label><liferay-ui:message key="nss-kieu-hien-thi" /></label>
			</td>
			<td align="left">
				<select name="<portlet:namespace />displayStyle" id="<portlet:namespace/>displayStyle">
					<option <%= displayStylePartner.equals("select") ? "selected" : "" %> value="select"><liferay-ui:message key="select-display" /></option>
					<option <%= displayStylePartner.equals("image") ? "selected" : "" %> value="image"><liferay-ui:message key="image-display" /></option>
					<option <%= displayStylePartner.equals("horizontal") ? "selected" : "" %> value="horizontal"><liferay-ui:message key="trai-phai" /></option>
					<option <%= displayStylePartner.equals("vertical") ? "selected" : "" %> value="vertical"><liferay-ui:message key="len-xuong" /></option>
		    	</select>
		    </td>
			<td>&nbsp;</td>
		</tr>
	    <tr height="10"></tr>
	    
	</table>

	<input type="submit" class="button" name="button" id="button" value='<liferay-ui:message key="save" />' />
	<input type="button" value="<liferay-ui:message key="cancel" />" onClick="location.href = '<%= HtmlUtil.escape(redirect) %>';" />
</form>