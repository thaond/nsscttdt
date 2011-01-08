<%@ include file="/html/portlet/ext/home/init.jsp" %>
<div class="separator"><!-- --></div>
<%
	PortletPreferences prefs = renderRequest.getPreferences();
	
	String portletResource = ParamUtil.getString(renderRequest, "portletResource");
	
	if (Validator.isNotNull(portletResource)) {
		prefs = PortletPreferencesFactoryUtil.getPortletSetup(renderRequest, portletResource);
	}
	
	String oneDoor = GetterUtil.getString(prefs.getValue("oneDoor", ""));
	String document = GetterUtil.getString(prefs.getValue("document", ""));
	String news = GetterUtil.getString(prefs.getValue("news", ""));
	String calendar = GetterUtil.getString(prefs.getValue("calendar", ""));
%>
<form action="<liferay-portlet:actionURL portletConfiguration="true" />" method="post" name="<portlet:namespace />fm">
	<table>
	<tr>
		<td>
			<liferay-ui:message key="home-one-door" />
		</td>
		<td>
			<INPUT TYPE="text" NAME="<portlet:namespace/>oneDoor" VALUE="<%=oneDoor %>">
		</td>
	</tr>
	<tr>
		<td>
			<liferay-ui:message key="home-document" />
		</td>
		<td>
			<INPUT TYPE="text" NAME="<portlet:namespace/>document" VALUE="<%=document %>">
		</td>
	</tr>
	<tr>
		<td>
			<liferay-ui:message key="home-news" />
		</td>
		<td>
			<INPUT TYPE="text" NAME="<portlet:namespace/>news" VALUE="<%=news %>">
		</td>
	</tr>
	<tr>
		<td>
			<liferay-ui:message key="home-calendar" />
		</td>
		<td>
			<INPUT TYPE="text" NAME="<portlet:namespace/>calendar" VALUE="<%=calendar %>">
		</td>
	</tr>
	</table>
<input type="submit" value='<liferay-ui:message key="save" />' />

</form>