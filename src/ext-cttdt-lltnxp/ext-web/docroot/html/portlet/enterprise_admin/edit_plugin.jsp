<%@ include file="/html/portlet/enterprise_admin/init.jsp" %>
<%
String redirect = ParamUtil.getString(request, "redirect");

String moduleId = ParamUtil.getString(request, "moduleId");
String pluginId = ParamUtil.getString(request, "pluginId");
String pluginType = ParamUtil.getString(request, "pluginType");

PluginSetting pluginSetting = PluginSettingLocalServiceUtil.getPluginSetting(company.getCompanyId(), pluginId, pluginType);

boolean active = pluginSetting.isActive();
String[] rolesArray = pluginSetting.getRolesArray();

if (pluginType.equals(Plugin.TYPE_PORTLET)) {
	String portletId = pluginId;

	Portlet portlet = PortletLocalServiceUtil.getPortletById(company.getCompanyId(), portletId);

	active = portlet.isActive();
	rolesArray = portlet.getRolesArray();
}
%>

<script type="text/javascript">
	function <portlet:namespace />savePlugin() {
		submitForm(document.<portlet:namespace />fm);
	}
</script>

<form action="<portlet:actionURL windowState="<%= WindowState.NORMAL.toString() %>"><portlet:param name="struts_action" value="/enterprise_admin/edit_plugin" /></portlet:actionURL>" method="post" name="<portlet:namespace />fm" onSubmit="<portlet:namespace />savePlugin(); return false;">
<div class="title_categ"><liferay-ui:message key="Chinh-sua-Plugin"/></div>
<div class="boxcontent">
<input name="<portlet:namespace />redirect" type="hidden" value="<%= HtmlUtil.escape(redirect) %>" />
<input name="<portlet:namespace />pluginId" type="hidden" value="<%= HtmlUtil.escape(pluginId) %>" />
<input name="<portlet:namespace />pluginType" type="hidden" value="<%= HtmlUtil.escape(pluginType) %>" />

<liferay-ui:tabs names="plugin" backURL="<%= redirect %>"/>
<div class="boxcontent_Tab">
<table cellspacing="0" width="100%">
<tr>
	<td>
		<liferay-ui:message key="module-id" />&nbsp;:
	</td>
	<td>
		<%= moduleId %>
	</td>
</tr>
<tr>
	<td>
		<liferay-ui:message key="plugin-id" />&nbsp;:
	</td>
	<td>
		<%= HtmlUtil.escape(pluginId) %>
	</td>
</tr>
<tr>
	<td>
		<liferay-ui:message key="active" />&nbsp;:
	</td>
	<td>
		<liferay-ui:input-checkbox param="active" defaultValue="<%= active %>" disabled="<%= pluginId.equals(PortletKeys.ENTERPRISE_ADMIN) %>" />
	</td>
</tr>
<tr>
	<td colspan="2">
	<liferay-ui:message key="enter-one-role-name-per-line-a-user-must-belong-to-one-of-these-roles-in-order-to-add-this-plugin-to-a-page" />&nbsp;:
	</td>
</tr>
<tr>
	<td colspan="2">
		<textarea style="width: 99%" rows="5" name="<portlet:namespace />roles"><%= StringUtil.merge(rolesArray, "\n") %></textarea>
	</td>
</tr>
<tr>
	<td></td>
	<td>
		<input style="margin-left: 0;" type="submit" value="<liferay-ui:message key="save" />" />
		<input type="button" value="<liferay-ui:message key="cancel" />" onClick="location.href = '<%= HtmlUtil.escape(redirect) %>';" />
	</td>
</tr>
</table>
</div>
</div>
</form>