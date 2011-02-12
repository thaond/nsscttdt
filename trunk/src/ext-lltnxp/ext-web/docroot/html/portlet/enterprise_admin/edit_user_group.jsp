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
String redirect = ParamUtil.getString(request, "redirect");

UserGroup userGroup = (UserGroup)request.getAttribute(WebKeys.USER_GROUP);

long userGroupId = BeanParamUtil.getLong(userGroup, request, "userGroupId");
%>

<script type="text/javascript">
	function <portlet:namespace />saveUserGroup() {
		document.<portlet:namespace />fm.<portlet:namespace /><%= Constants.CMD %>.value = "<%= userGroup == null ? Constants.ADD : Constants.UPDATE %>";
		submitForm(document.<portlet:namespace />fm, "<portlet:actionURL windowState="<%= WindowState.NORMAL.toString() %>"><portlet:param name="struts_action" value="/enterprise_admin/edit_user_group" /></portlet:actionURL>");
	}
</script>

<form method="post" name="<portlet:namespace />fm" onSubmit="<portlet:namespace />saveUserGroup(); return false;">
<div class="title_categ"><liferay-ui:message key="Quan-tri-he-thong-nhom-nguoi-dung"/></div>
<div class="boxcontent">
<input name="<portlet:namespace /><%= Constants.CMD %>" type="hidden" value="" />
<input name="<portlet:namespace />redirect" type="hidden" value="<%= HtmlUtil.escape(redirect) %>" />
<input name="<portlet:namespace />userGroupId" type="hidden" value="<%= userGroupId %>" />

<liferay-ui:tabs names="user-groups" backURL="<%= redirect %>"/>
<div class="boxcontent_Tab">
<liferay-ui:error exception="<%= DuplicateUserGroupException.class %>" message="please-enter-a-unique-name" />
<liferay-ui:error exception="<%= RequiredUserGroupException.class %>" message="this-is-a-required-user-group" />
<liferay-ui:error exception="<%= UserGroupNameException.class %>" message="please-enter-a-valid-name" />
<table cellspacing="0" width="100%">
	<c:if test="<%= userGroup != null %>">
	<tr>
		<td width="15%">
			<liferay-ui:message key="old-name" />&nbsp;:
		</td>
		<td>
			<%= userGroup.getName() %>
		</td>
	</tr>
</c:if>

<tr>
	<td>
		<%= LanguageUtil.get(pageContext, ((userGroup != null) ? "new-name" : "name")) %>
	</td>
	<td>
		<liferay-ui:input-field model="<%= UserGroup.class %>" bean="<%= userGroup %>" field="name" />&nbsp;:
	</td>
</tr>
<tr>
	<td>
		<liferay-ui:message key="description" />&nbsp;:
	</td>
	<td>
		<liferay-ui:input-field model="<%= UserGroup.class %>" bean="<%= userGroup %>" field="description" />
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

<c:if test="<%= windowState.equals(WindowState.NORMAL) %>">
	<script type="text/javascript">
		Liferay.Util.focusFormField(document.<portlet:namespace />fm.<portlet:namespace />name);
	</script>
</c:if>