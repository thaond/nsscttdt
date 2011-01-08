<%@ include file="/html/portlet/ext/pcccdocumentreceipt/init.jsp" %>

<liferay-portlet:actionURL var="form" portletConfiguration="true"></liferay-portlet:actionURL>
<%

PortletPreferences prefs = renderRequest.getPreferences();

String portletResource = ParamUtil.getString(request, "portletResource");

if (Validator.isNotNull(portletResource)) {
	prefs = PortletPreferencesFactoryUtil.getPortletSetup(request, portletResource);
}

boolean privateDocument = PrefsParamUtil.getBoolean(prefs, request, "privateDocument",false);

%>

<form action="<%=form %>" method="post">
	<table style="width: 100%; margin-top: 10px; margin-bottom: 5px">
		<tr>
			<td nowrap="nowrap" width="20%">
			 	<div style="padding-left: 3px;"><liferay-ui:message key="document-private" />: <div>
			</td>
			<td align="left">
			 	<input name="<portlet:namespace/>privateDocument" type="checkbox" size="5" <%=  privateDocument == true ? "checked": ""  %>  />
			</td>
		</tr>
	</table>
	
	
	<table>
		<tr>
			<td>
				<div style="padding-left: 5px">
					<input type="submit" value='<liferay-ui:message key="save" />'/>
				</div>
			</td>
		</tr>
	</table>

</form>
