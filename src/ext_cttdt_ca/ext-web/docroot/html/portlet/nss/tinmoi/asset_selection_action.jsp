<%@ include file="/html/portlet/nss/tinmoi/init.jsp" %>

<%
String redirect = ParamUtil.getString(request, "backURL");

redirect = ParamUtil.getString(request, "redirect");

ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

Document assetDoc = (Document)row.getObject();

Element root = assetDoc.getRootElement();

int assetOrder = GetterUtil.getInteger(root.elementText("asset-order"));
boolean last = GetterUtil.getBoolean(root.elementText("last"));
%>

<c:choose>
	<c:when test="<%= (assetOrder == 0) && last %>">
	</c:when>
	<c:when test="<%= (assetOrder > 0) && !last %>">

		<%
		String taglibDownURL = "javascript: " + renderResponse.getNamespace() + "moveSelectionDown('" + assetOrder + "')";
		%>

		<liferay-ui:icon src='<%= themeDisplay.getPathThemeImages() + "/arrows/02_down.png" %>' message="down" url="<%= taglibDownURL %>" />

		<%
		String taglibUpURL = "javascript: " + renderResponse.getNamespace() + "moveSelectionUp('" + assetOrder + "')";
		%>

		<liferay-ui:icon src='<%= themeDisplay.getPathThemeImages() + "/arrows/02_up.png" %>' message="up" url="<%= taglibUpURL %>" />
	</c:when>
	<c:when test="<%= assetOrder == 0 %>">

		<%
		String taglibDownURL = "javascript: " + renderResponse.getNamespace() + "moveSelectionDown('" + assetOrder + "')";
		%>

		<liferay-ui:icon src='<%= themeDisplay.getPathThemeImages() + "/arrows/02_down.png" %>' message="down" url="<%= taglibDownURL %>" />
	</c:when>
	<c:when test="<%= last %>">

		<%
		String taglibUpURL = "javascript: " + renderResponse.getNamespace() + "moveSelectionUp('" + assetOrder + "')";
		%>

		<liferay-ui:icon src='<%= themeDisplay.getPathThemeImages() + "/arrows/02_up.png" %>' message="up" url="<%= taglibUpURL %>" />
	</c:when>
</c:choose>

<liferay-portlet:actionURL portletConfiguration="true" windowState="<%= WindowState.MAXIMIZED.toString() %>" var="deleteURL">
	<portlet:param name="<%= Constants.CMD %>" value="remove-selection" />
	<portlet:param name="redirect" value="<%= redirect %>" />
	<portlet:param name="assetOrder" value="<%= String.valueOf(assetOrder) %>" />
</liferay-portlet:actionURL>

<liferay-ui:icon-delete url="<%= deleteURL %>" />