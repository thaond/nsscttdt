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

<%@ include file="/html/portlet/software_catalog/init.jsp" %>

<%
String redirect = ParamUtil.getString(request, "redirect");

SCFrameworkVersion frameworkVersion = (SCFrameworkVersion)request.getAttribute(WebKeys.SOFTWARE_CATALOG_FRAMEWORK_VERSION);

long frameworkVersionId = BeanParamUtil.getLong(frameworkVersion, request, "frameworkVersionId");
%>

<script type="text/javascript">
	function <portlet:namespace />saveFrameworkVersion() {
		document.<portlet:namespace />fm.<portlet:namespace /><%= Constants.CMD %>.value = "<%= frameworkVersion == null ? Constants.ADD : Constants.UPDATE %>";
		submitForm(document.<portlet:namespace />fm);
	}
</script>

<form action="<portlet:actionURL windowState="<%= WindowState.NORMAL.toString() %>"><portlet:param name="struts_action" value="/software_catalog/edit_framework_version" /></portlet:actionURL>" method="post" name="<portlet:namespace />fm" onSubmit="<portlet:namespace />saveFrameworkVersion(); return false;">
<input name="<portlet:namespace /><%= Constants.CMD %>" type="hidden" value="" />
<input name="<portlet:namespace />redirect" type="hidden" value="<%= HtmlUtil.escape(redirect) %>" />
<input name="<portlet:namespace />frameworkVersionId" type="hidden" value="<%= frameworkVersionId %>" />
<div class="titlecategr_pages"><h4><p><liferay-ui:message key="quan-tri-danh-muc-phan-mem" /></p></h4></div>

<liferay-ui:tabs
	names="framework-version"
	backURL="<%= redirect %>"
/>

<liferay-ui:error exception="<%= FrameworkVersionNameException.class %>" message="please-enter-a-valid-name" />
<div class="borderendTab">
<table cellspacing="0" width="100%">
<tr>
	<td width="20%">
		<liferay-ui:message key="name" />:
	</td>
	<td>
		<liferay-ui:input-field model="<%= SCFrameworkVersion.class %>" bean="<%= frameworkVersion %>" field="name" />
	</td>
</tr>
<tr>
	<td>
		<liferay-ui:message key="url" />:
	</td>
	<td>
		<liferay-ui:input-field model="<%= SCFrameworkVersion.class %>" bean="<%= frameworkVersion %>" field="url" />
	</td>
</tr>
<tr>
	<td>
		<liferay-ui:message key="active" />:
	</td>
	<td>
		<liferay-ui:input-field model="<%= SCFrameworkVersion.class %>" bean="<%= frameworkVersion %>" field="active" defaultValue="<%= Boolean.TRUE %>" />
	</td>
</tr>

<c:if test="<%= frameworkVersion == null %>">
	
	<tr>
		<td>
			<liferay-ui:message key="permissions" />:
		</td>
		<td>
			<liferay-ui:input-permissions
				modelName="<%= SCFrameworkVersion.class.getName() %>"
			/>
		</td>
	</tr>
</c:if>
<tr>
		<td>
		</td>
		<td>
			<input type="submit" value="<liferay-ui:message key="save" />" />
			<input type="button" value="<liferay-ui:message key="cancel" />" onClick="location.href = '<%= HtmlUtil.escape(redirect) %>';" />
		</td>
	</tr>
</table>
</div>
</form>

<c:if test="<%= windowState.equals(WindowState.NORMAL) %>">
	<script type="text/javascript">
		Liferay.Util.focusFormField(document.<portlet:namespace />fm.<portlet:namespace />name);
	</script>
</c:if>