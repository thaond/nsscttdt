<%
/**
 * Copyright (c) 2000-2008 Liferay, Inc. All rights reserved.
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

<%@ include file="/html/portlet/portlet_configuration/init.jsp" %>

<%
String redirect = ParamUtil.getString(request, "redirect");
String returnToFullPageURL = ParamUtil.getString(request, "returnToFullPageURL");

String portletResource = ParamUtil.getString(request, "portletResource");

Portlet selPortlet = PortletLocalServiceUtil.getPortletById(company.getCompanyId(), portletResource);

PortletURL portletURL = renderResponse.createActionURL();
%>

<liferay-util:include page="/html/portlet/portlet_configuration/tabs1.jsp">
	<liferay-util:param name="tabs1" value="setup" />
</liferay-util:include>

<liferay-util:include page="/html/portlet/portlet_configuration/tabs2.jsp">
	<liferay-util:param name="tabs2" value="archived" />
</liferay-util:include>

<liferay-ui:error exception="<%= NoSuchPortletItemException.class %>" message="the-setup-could-not-be-found" />
<liferay-ui:error exception="<%= PortletItemNameException.class %>" message="please-enter-a-valid-setup-name" />

<form action="<portlet:actionURL windowState="<%= WindowState.MAXIMIZED.toString() %>"><portlet:param name="struts_action" value="/portlet_configuration/edit_archived_setups" /><portlet:param name="<%= Constants.CMD %>" value="<%= Constants.SAVE %>" /></portlet:actionURL>" method="post" name="<portlet:namespace />fm">
<input name="<portlet:namespace /><%= Constants.CMD %>" type="hidden" value="" />
<input name="<portlet:namespace />redirect" type="hidden" value="<%= HtmlUtil.escape(currentURL) %>" />
<input name="<portlet:namespace />returnToFullPageURL" type="hidden" value="<%= HtmlUtil.escape(returnToFullPageURL) %>" />
<input name="<portlet:namespace />portletResource" type="hidden" value="<%= HtmlUtil.escape(portletResource) %>">

<%
List<String> headerNames = new ArrayList<String>();

headerNames.add("name");
headerNames.add("user");
headerNames.add("modified-date");
headerNames.add(StringPool.BLANK);

SearchContainer searchContainer = new SearchContainer(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, SearchContainer.DEFAULT_DELTA, portletURL, headerNames, "there-are-no-archived-setups");

List archivedSetups = PortletItemLocalServiceUtil.getPortletItems(layout.getGroupId(), selPortlet.getRootPortletId(), com.liferay.portal.model.PortletPreferences.class.getName());

int total = archivedSetups.size();

List results = ListUtil.subList(archivedSetups, searchContainer.getStart(), searchContainer.getEnd());

searchContainer.setResults(results);

List resultRows = searchContainer.getResultRows();

for (int i = 0; i < results.size(); i++) {
	PortletItem portletItem = (PortletItem)results.get(i);

	ResultRow row = new ResultRow(new Object[] {portletItem, portletResource}, portletItem.getName(), i);

	// Name

	row.addText(portletItem.getName());

	// User

	row.addText(PortalUtil.getUserName(portletItem.getUserId(), portletItem.getUserName()));

	// Date

	row.addText(dateFormatDateTime.format(portletItem.getModifiedDate()));

	// Action

	row.addJSP("right", SearchEntry.DEFAULT_VALIGN, "/html/portlet/portlet_configuration/archived_setup_action.jsp");

	// Add result row

	resultRows.add(row);
}
%>

<liferay-ui:search-iterator searchContainer="<%= searchContainer %>" />

<div class="separator"><!-- --></div>

<liferay-ui:message key="archive-name-for-current-setup" />

<input name="<portlet:namespace />name" size="20" type="text">

<input type="submit" value="<liferay-ui:message key="save" />" />

</form>