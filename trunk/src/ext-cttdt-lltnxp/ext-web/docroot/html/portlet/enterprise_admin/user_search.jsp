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

<%@ include file="/html/portlet/enterprise_admin/init.jsp" %>

<%
String strutsAction = ParamUtil.getString(request, "struts_action");

UserSearch searchContainer = (UserSearch)request.getAttribute("liferay-ui:search:searchContainer");

UserDisplayTerms displayTerms = (UserDisplayTerms)searchContainer.getDisplayTerms();
%>

<liferay-ui:search-toggle id="toggle_id_enterprise_admin_user_search"	displayTerms="<%= displayTerms %>">
	<table cellspacing="0" width="100%">
	<tr>
		<td width="7%">
			<liferay-ui:message key="first-name" />&nbsp;:
		</td>
		<td>
			<input name="<portlet:namespace /><%= displayTerms.FIRST_NAME %>" style="width: 85%" type="text" value="<%= HtmlUtil.escape(displayTerms.getFirstName()) %>" />
		</td>
		<td width="9%">
			<liferay-ui:message key="middle-name" />&nbsp;:
		</td>
		<td width="35%">
			<input name="<portlet:namespace /><%= displayTerms.MIDDLE_NAME %>" style="width: 85%" type="text" value="<%= HtmlUtil.escape(displayTerms.getMiddleName()) %>" />
		</td>
		<td width="9%">
			<liferay-ui:message key="last-name" />&nbsp;:
		</td>
		<td width="15%">
			<input name="<portlet:namespace /><%= displayTerms.LAST_NAME %>" style="width: 92%" type="text" value="<%= HtmlUtil.escape(displayTerms.getLastName()) %>" />
		</td>
	</tr>
	<tr>
		<td>
			<liferay-ui:message key="screen-name" />&nbsp;:
		</td>
		<td>
			<input name="<portlet:namespace /><%= displayTerms.SCREEN_NAME %>" style="width: 85%" type="text" value="<%= HtmlUtil.escape(displayTerms.getScreenName()) %>" />
		</td>
		<td>
			<liferay-ui:message key="email-address" />&nbsp;:
		</td>
		<td>
			<input name="<portlet:namespace /><%= displayTerms.EMAIL_ADDRESS %>" style="width: 85%" type="text" value="<%= HtmlUtil.escape(displayTerms.getEmailAddress()) %>" />
		</td>

		<c:choose>
			<c:when test="<%= portletName.equals(PortletKeys.ENTERPRISE_ADMIN) || portletName.equals(PortletKeys.ORGANIZATION_ADMIN) %>">
				<td>
					<liferay-ui:message key="active" />&nbsp;:
				</td>
			</c:when>
			<c:otherwise>
				<td></td>
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test="<%= portletName.equals(PortletKeys.ENTERPRISE_ADMIN) || portletName.equals(PortletKeys.ORGANIZATION_ADMIN) %>">
				<td>
					<select name="<portlet:namespace /><%= displayTerms.ACTIVE %>" style="width: 97%">
						<option <%= displayTerms.isActive() ? "selected" : "" %> value="1"><liferay-ui:message key="yes" /></option>
						<option <%= !displayTerms.isActive() ? "selected" : "" %> value="0"><liferay-ui:message key="no" /></option>
					</select>
				</td>
			</c:when>
			<c:otherwise>
				<td></td>
			</c:otherwise>
		</c:choose>
	</tr>
</table>
</liferay-ui:search-toggle>

<br />
<input type="submit" value="<liferay-ui:message key="search-users" />" />
<c:if test='<%= (portletName.equals(PortletKeys.ENTERPRISE_ADMIN) && (Validator.isNull(strutsAction) || strutsAction.equals("/enterprise_admin/view"))) ||
		(portletName.equals(PortletKeys.ORGANIZATION_ADMIN) && (Validator.isNull(strutsAction) || strutsAction.equals("/organization_admin/view"))) %>'>
		<c:if test="<%= (portletName.equals(PortletKeys.ENTERPRISE_ADMIN) && PortalPermissionUtil.contains(permissionChecker, ActionKeys.ADD_USER)) ||
						(portletName.equals(PortletKeys.ORGANIZATION_ADMIN) && OrganizationPermissionUtil.contains(permissionChecker, displayTerms.getOrganizationId(), ActionKeys.ADD_USER)) %>">
<input type="button" value="<liferay-ui:message key="add-user" />" onClick="<portlet:namespace />addUser();" />
	</c:if>
</c:if>

<script type="text/javascript">
	function <portlet:namespace />addUser() {
		var url = '<portlet:renderURL windowState="<%= WindowState.NORMAL.toString() %>"><portlet:param name="struts_action" value="/enterprise_admin/edit_user" /></portlet:renderURL>';

		if (toggle_id_enterprise_admin_user_searchcurClickValue == 'basic') {
			url += '&<portlet:namespace />redirect=' + encodeURIComponent(document.<portlet:namespace />fm.<portlet:namespace />usersRedirect.value);
			url += '&<portlet:namespace /><%= displayTerms.SCREEN_NAME %>=' + document.<portlet:namespace />fm.<portlet:namespace /><%= displayTerms.KEYWORDS %>.value;

			submitForm(document.hrefFm, url);
		}
		else {
			document.<portlet:namespace />fm.method = 'post';
			document.<portlet:namespace />fm.<portlet:namespace />redirect.value = document.<portlet:namespace />fm.<portlet:namespace />usersRedirect.value;
			submitForm(document.<portlet:namespace />fm, url);
		}
	}

	<c:if test="<%= windowState.equals(WindowState.NORMAL) %>">
		Liferay.Util.focusFormField(document.<portlet:namespace />fm.<portlet:namespace /><%= displayTerms.FIRST_NAME %>);
		Liferay.Util.focusFormField(document.<portlet:namespace />fm.<portlet:namespace /><%= displayTerms.KEYWORDS %>);
	</c:if>
</script>