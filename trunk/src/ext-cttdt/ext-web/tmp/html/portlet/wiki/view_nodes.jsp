<%
/**
 * Copyright (c) 2000-2009 Liferay, Inc. All rights reserved.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
%>

<%@ include file="/html/portlet/wiki/init.jsp" %>

<%
PortletURL portletURL = renderResponse.createRenderURL();

portletURL.setParameter("struts_action", "/wiki/view_nodes");

List<String> headerNames = new ArrayList<String>();

headerNames.add("node");
headerNames.add("num-of-pages");
headerNames.add("last-post-date");
headerNames.add(StringPool.BLANK);

SearchContainer searchContainer = new SearchContainer(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, SearchContainer.DEFAULT_DELTA, portletURL, headerNames, null);

int total = WikiNodeLocalServiceUtil.getNodesCount(scopeGroupId);

searchContainer.setTotal(total);

List results = WikiNodeLocalServiceUtil.getNodes(scopeGroupId, searchContainer.getStart(), searchContainer.getEnd());

searchContainer.setResults(results);
%>

<liferay-portlet:renderURL varImpl="searchURL"><portlet:param name="struts_action" value="/wiki/search" /></liferay-portlet:renderURL>

<form action="<%= searchURL %>" method="get" name="<portlet:namespace />fm">
<input name="<portlet:namespace />redirect" type="hidden" value="<%= HtmlUtil.escape(currentURL) %>" />

<%
List resultRows = searchContainer.getResultRows();

for (int i = 0; i < results.size(); i++) {
	WikiNode node = (WikiNode)results.get(i);

	ResultRow row = new ResultRow(node, node.getNodeId(), i);

	PortletURL rowURL = renderResponse.createRenderURL();

	rowURL.setParameter("struts_action", "/wiki/view");
	//rowURL.setParameter("redirect", currentURL);
	rowURL.setParameter("nodeName", String.valueOf(node.getName()));
	rowURL.setParameter("title", WikiPageImpl.FRONT_PAGE);

	// Name

	row.addText(node.getName(), rowURL);

	// Number of pages

	int pagesCount = WikiPageLocalServiceUtil.getPagesCount(node.getNodeId(), true);

	row.addText(String.valueOf(pagesCount), rowURL);

	// Last post date

	if (node.getLastPostDate() == null) {
		row.addText(LanguageUtil.get(pageContext, "never"), rowURL);
	}
	else {
		row.addText(dateFormatDateTime.format(node.getLastPostDate()), rowURL);
	}

	// Action

	row.addJSP("right", SearchEntry.DEFAULT_VALIGN, "/html/portlet/wiki/node_action.jsp");

	// Add result row

	resultRows.add(row);
}

boolean showAddNodeButton = WikiPermission.contains(permissionChecker, scopeGroupId, ActionKeys.ADD_NODE);
boolean showPermissionsButton = GroupPermissionUtil.contains(permissionChecker, scopeGroupId, ActionKeys.PERMISSIONS);
%>

<c:if test="<%= showAddNodeButton || showPermissionsButton %>">
	<div>
		<c:if test="<%= showAddNodeButton %>">
			<input type="button" value="<liferay-ui:message key="add-wiki" />" onClick="location.href = '<portlet:renderURL><portlet:param name="struts_action" value="/wiki/edit_node" /><portlet:param name="redirect" value="<%= currentURL %>" /></portlet:renderURL>';" />
		</c:if>

		<c:if test="<%= showPermissionsButton %>">
			<liferay-security:permissionsURL
				modelResource="com.liferay.portlet.wiki"
				modelResourceDescription="<%= HtmlUtil.escape(themeDisplay.getScopeGroupName()) %>"
				resourcePrimKey="<%= String.valueOf(scopeGroupId) %>"
				var="permissionsURL"
			/>

			<input type="button" value="<liferay-ui:message key="permissions" />" onClick="location.href = '<%= permissionsURL %>';" />
		</c:if>
	</div>

	<br />
</c:if>

<liferay-ui:search-iterator searchContainer="<%= searchContainer %>" />

</form>

<c:if test="<%= windowState.equals(WindowState.MAXIMIZED) %>">
	<script type="text/javascript">
		Liferay.Util.focusFormField(document.<portlet:namespace />fm.<portlet:namespace />keywords);
	</script>
</c:if>