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

<%@ include file="/html/portlet/message_boards/init.jsp" %>

<%
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

Object[] objArray = (Object[])row.getObject();

MBCategory category = (MBCategory)objArray[0];
Set<Long> categorySubscriptionClassPKs = (Set<Long>)objArray[1];
%>

<liferay-ui:icon-menu>
	<c:if test="<%= MBCategoryPermission.contains(permissionChecker, category, ActionKeys.UPDATE) %>">
		<portlet:renderURL var="editURL">
			<portlet:param name="struts_action" value="/message_boards/edit_category" />
			<portlet:param name="redirect" value="<%= currentURL %>" />
			<portlet:param name="categoryId" value="<%= String.valueOf(category.getCategoryId()) %>" />
		</portlet:renderURL>

		<liferay-ui:icon image="edit" url="<%= editURL %>" />
	</c:if>

	<c:if test="<%= MBCategoryPermission.contains(permissionChecker, category, ActionKeys.PERMISSIONS) %>">
		<liferay-security:permissionsURL
			modelResource="<%= MBCategory.class.getName() %>"
			modelResourceDescription="<%= category.getName() %>"
			resourcePrimKey="<%= String.valueOf(category.getCategoryId()) %>"
			var="permissionsURL"
		/>

		<liferay-ui:icon image="permissions" url="<%= permissionsURL %>" />
	</c:if>

	<liferay-ui:icon image="rss" url='<%= themeDisplay.getPortalURL() + themeDisplay.getPathMain() + "/message_boards/rss?p_l_id=" + plid + "&categoryId=" + category.getCategoryId() + rssURLParams %>' method="get" target="_blank" />

	<c:if test="<%= MBCategoryPermission.contains(permissionChecker, category, ActionKeys.SUBSCRIBE) %>">
		<c:choose>
			<c:when test="<%= (categorySubscriptionClassPKs != null) && categorySubscriptionClassPKs.contains(category.getCategoryId()) %>">
				<portlet:actionURL var="unsubscribeURL">
					<portlet:param name="struts_action" value="/message_boards/edit_category" />
					<portlet:param name="<%= Constants.CMD %>" value="<%= Constants.UNSUBSCRIBE %>" />
					<portlet:param name="redirect" value="<%= currentURL %>" />
					<portlet:param name="categoryId" value="<%= String.valueOf(category.getCategoryId()) %>" />
				</portlet:actionURL>

				<liferay-ui:icon image="unsubscribe" url="<%= unsubscribeURL %>" />
			</c:when>
			<c:otherwise>
				<portlet:actionURL var="subscribeURL">
					<portlet:param name="struts_action" value="/message_boards/edit_category" />
					<portlet:param name="<%= Constants.CMD %>" value="<%= Constants.SUBSCRIBE %>" />
					<portlet:param name="redirect" value="<%= currentURL %>" />
					<portlet:param name="categoryId" value="<%= String.valueOf(category.getCategoryId()) %>" />
				</portlet:actionURL>

				<liferay-ui:icon image="subscribe" url="<%= subscribeURL %>" />
			</c:otherwise>
		</c:choose>
	</c:if>

	<c:if test="<%= MBCategoryPermission.contains(permissionChecker, category, ActionKeys.DELETE) %>">
		<portlet:actionURL var="deleteURL">
			<portlet:param name="struts_action" value="/message_boards/edit_category" />
			<portlet:param name="<%= Constants.CMD %>" value="<%= Constants.DELETE %>" />
			<portlet:param name="redirect" value="<%= currentURL %>" />
			<portlet:param name="categoryId" value="<%= String.valueOf(category.getCategoryId()) %>" />
		</portlet:actionURL>

		<liferay-ui:icon-delete url="<%= deleteURL %>" />
	</c:if>
</liferay-ui:icon-menu>