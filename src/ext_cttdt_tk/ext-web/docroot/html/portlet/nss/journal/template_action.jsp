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

<%@ include file="/html/portlet/nss/journal/init.jsp" %>

<%
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

JournalTemplate template = (JournalTemplate)row.getObject();
%>

<liferay-ui:icon-menu>
	<c:if test="<%= JournalTemplatePermission.contains(permissionChecker, template, ActionKeys.UPDATE) %>">
		<portlet:renderURL windowState="<%= WindowState.NORMAL.toString() %>" var="editeTemplateURL">
			<portlet:param name="struts_action" value="/nss/journal/edit_template" />
			<portlet:param name="redirect" value="<%= currentURL %>" />
			<portlet:param name="groupId" value="<%= String.valueOf(template.getGroupId()) %>" />
			<portlet:param name="templateId" value="<%= template.getTemplateId() %>" />
		</portlet:renderURL>

		<liferay-ui:icon image="edit" url="<%= editeTemplateURL %>" />
	</c:if>

	<c:if test="<%= JournalTemplatePermission.contains(permissionChecker, template, ActionKeys.PERMISSIONS) %>">
		<liferay-security:permissionsURL
			modelResource="<%= JournalTemplate.class.getName() %>"
			modelResourceDescription="<%= template.getName() %>"
			resourcePrimKey="<%= String.valueOf(template.getId()) %>"
			var="permissionsTemplateURL"
		/>

		<liferay-ui:icon image="permissions" url="<%= permissionsTemplateURL %>" />
	</c:if>

	<c:if test="<%= JournalPermission.contains(permissionChecker, scopeGroupId, ActionKeys.ADD_TEMPLATE) %>">
		<portlet:renderURL var="copyURL">
			<portlet:param name="struts_action" value="/nss/journal/copy_template" />
			<portlet:param name="redirect" value="<%= currentURL %>" />
			<portlet:param name="groupId" value="<%= String.valueOf(template.getGroupId()) %>" />
			<portlet:param name="oldTemplateId" value="<%= template.getTemplateId() %>" />
		</portlet:renderURL>

		<liferay-ui:icon image="copy" url="<%= copyURL.toString() %>" />
	</c:if>

	<c:if test="<%= Validator.isNotNull(template.getStructureId()) %>">
		<c:if test="<%= JournalPermission.contains(permissionChecker, scopeGroupId, ActionKeys.ADD_ARTICLE) %>">
			<portlet:renderURL windowState="<%= WindowState.NORMAL.toString() %>" var="addArticleURL">
				<portlet:param name="struts_action" value="/nss/journal/edit_article" />
				<portlet:param name="redirect" value="<%= currentURL %>" />
				<portlet:param name="groupId" value="<%= String.valueOf(template.getGroupId()) %>" />
				<portlet:param name="structureId" value="<%= template.getStructureId() %>" />
				<portlet:param name="templateId" value="<%= template.getTemplateId() %>" />
			</portlet:renderURL>

			<liferay-ui:icon image="add_article" message="add-web-content" url="<%= addArticleURL %>" />
		</c:if>

		<portlet:renderURL windowState="<%= WindowState.NORMAL.toString() %>" var="viewArticlesURL">
			<portlet:param name="struts_action" value="/nss/journal/view" />
			<portlet:param name="tabs1" value="web-content" />
			<portlet:param name="groupId" value="<%= String.valueOf(template.getGroupId()) %>" />
			<portlet:param name="templateId" value="<%= template.getTemplateId() %>" />
		</portlet:renderURL>

		<liferay-ui:icon image="view_articles" message="view-web-content" url="<%= viewArticlesURL %>" />

		<portlet:renderURL windowState="<%= WindowState.NORMAL.toString() %>" var="editStructureURL">
			<portlet:param name="struts_action" value="/nss/journal/edit_structure" />
			<portlet:param name="redirect" value="<%= currentURL %>" />
			<portlet:param name="groupId" value="<%= String.valueOf(template.getGroupId()) %>" />
			<portlet:param name="structureId" value="<%= template.getStructureId() %>" />
		</portlet:renderURL>

		<liferay-ui:icon image="view_structures" message="edit-structure" url="<%= editStructureURL %>" />
	</c:if>

	<c:if test="<%= JournalTemplatePermission.contains(permissionChecker, template, ActionKeys.DELETE) %>">
		<portlet:actionURL windowState="<%= WindowState.NORMAL.toString() %>" var="deleteTemplateURL">
			<portlet:param name="struts_action" value="/nss/journal/edit_template" />
			<portlet:param name="<%= Constants.CMD %>" value="<%= Constants.DELETE %>" />
			<portlet:param name="redirect" value="<%= currentURL %>" />
			<portlet:param name="groupId" value="<%= String.valueOf(template.getGroupId()) %>" />
			<portlet:param name="deleteTemplateIds" value="<%= template.getTemplateId() %>" />
		</portlet:actionURL>

		<liferay-ui:icon-delete url="<%= deleteTemplateURL %>" />
	</c:if>
</liferay-ui:icon-menu>