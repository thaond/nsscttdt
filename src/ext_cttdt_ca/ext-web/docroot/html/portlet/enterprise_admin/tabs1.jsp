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

<%@ include file="/html/portlet/enterprise_admin/init.jsp" %>

<%
PortletURL tabs1URL = renderResponse.createRenderURL();

tabs1URL.setWindowState(WindowState.NORMAL);

tabs1URL.setParameter("struts_action", "/enterprise_admin/view");

String tabs1Names = "users,organizations,user-groups";

String tabs1Values = tabs1Names;

if (!filterManageableOrganizations) {
	if (windowState.equals(WindowState.NORMAL)) {
		tabs1Names += ",roles,password-policies,settings,monitoring,plugins";
	}
	else {
		tabs1Names += ",roles,&raquo;";
	}

	tabs1Values = tabs1Names;
}

String backURL = ParamUtil.getString(request, "backURL");
%>
<div class="parent-title"><liferay-ui:message key="Enterprise_admin"/></div>
<liferay-ui:tabs
	names="<%= tabs1Names %>"
	tabsValues="<%= tabs1Values %>"
	url="<%= tabs1URL.toString() %>"
	backURL="<%= backURL %>"
/>