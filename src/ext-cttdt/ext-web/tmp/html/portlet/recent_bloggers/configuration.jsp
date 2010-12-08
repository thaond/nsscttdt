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

<%@ include file="/html/portlet/recent_bloggers/init.jsp" %>

<%
String organizationName = StringPool.BLANK;

Organization organization = null;

if (organizationId > 0) {
	organization = OrganizationLocalServiceUtil.getOrganization(organizationId);

	organizationName = organization.getName();
}
%>

<script type="text/javascript">
	function <portlet:namespace />removeOrganization() {
		document.<portlet:namespace />fm.<portlet:namespace />organizationId.value = "";

		var nameEl = document.getElementById("<portlet:namespace />organizationName");

		nameEl.innerHTML = "";

		document.getElementById("<portlet:namespace />removeOrganizationButton").disabled = true;
	}

	function <portlet:namespace />selectOrganization(organizationId, name) {
		document.<portlet:namespace />fm.<portlet:namespace />organizationId.value = organizationId;

		var nameEl = document.getElementById("<portlet:namespace />organizationName");

		nameEl.innerHTML = name + "&nbsp;";

		document.getElementById("<portlet:namespace />removeOrganizationButton").disabled = false;
	}
</script>

<form action="<liferay-portlet:actionURL portletConfiguration="true" />" method="post" name="<portlet:namespace />fm">
<input name="<portlet:namespace /><%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />
<input name="<portlet:namespace />organizationId" type="hidden" value="<%= organizationId %>" />

<table class="lfr-table">
<tr>
	<td>
		<liferay-ui:message key="selection-method" />
	</td>
	<td>
		<select id="<portlet:namespace />selectionMethod" name="<portlet:namespace />selectionMethod">
			<option <%= (selectionMethod.equals("users")) ? "selected" : "" %> value="users"><liferay-ui:message key="users" /></option>
			<option <%= (selectionMethod.equals("scope")) ? "selected" : "" %> value="scope"><liferay-ui:message key="scope" /></option>
		</select>
	</td>
</tr>
<tr id="<portlet:namespace />organization">
	<td>
		<liferay-ui:message key="organization" />
	</td>
	<td>
		<span id="<portlet:namespace />organizationName"><%= HtmlUtil.escape(organizationName) %></span>

		<input type="button" value="<liferay-ui:message key="select" />" onClick="var organizationWindow = window.open('<portlet:renderURL windowState="<%= LiferayWindowState.POP_UP.toString() %>"><portlet:param name="struts_action" value="/portlet_configuration/select_organization" /><portlet:param name="tabs1" value="organizations" /></portlet:renderURL>', 'organization', 'directories=no,height=640,location=no,menubar=no,resizable=yes,scrollbars=yes,status=no,toolbar=no,width=680'); void(''); organizationWindow.focus();" />

		<input <%= (organizationId <= 0) ? "disabled" : "" %> id="<portlet:namespace />removeOrganizationButton" type="button" value="<liferay-ui:message key="remove" />" onClick="<portlet:namespace />removeOrganization();">
	</td>
</tr>
<tr>
	<td>
		<liferay-ui:message key="display-style" />
	</td>
	<td>
		<select name="<portlet:namespace />displayStyle">
			<option <%= (displayStyle.equals("user-name-and-image")) ? "selected" : "" %> value="user-name-and-image"><liferay-ui:message key="user-name-and-image" /></option>
			<option <%= (displayStyle.equals("user-name")) ? "selected" : "" %> value="user-name"><liferay-ui:message key="user-name" /></option>
		</select>
	</td>
</tr>
<tr>
	<td>
		<liferay-ui:message key="maximum-bloggers-to-display" />
	</td>
	<td>
		<select name="<portlet:namespace />max">
			<option <%= max == 1 ? "selected" : "" %> value="1">1</option>
			<option <%= max == 2 ? "selected" : "" %> value="2">2</option>
			<option <%= max == 3 ? "selected" : "" %> value="3">3</option>
			<option <%= max == 4 ? "selected" : "" %> value="4">4</option>
			<option <%= max == 5 ? "selected" : "" %> value="5">5</option>
			<option <%= max == 10 ? "selected" : "" %> value="10">10</option>
			<option <%= max == 15 ? "selected" : "" %> value="15">15</option>
			<option <%= max == 20 ? "selected" : "" %> value="20">20</option>
			<option <%= max == 25 ? "selected" : "" %> value="25">25</option>
			<option <%= max == 30 ? "selected" : "" %> value="30">30</option>
			<option <%= max == 40 ? "selected" : "" %> value="40">40</option>
			<option <%= max == 50 ? "selected" : "" %> value="50">50</option>
			<option <%= max == 60 ? "selected" : "" %> value="60">60</option>
			<option <%= max == 70 ? "selected" : "" %> value="70">70</option>
			<option <%= max == 80 ? "selected" : "" %> value="80">80</option>
			<option <%= max == 90 ? "selected" : "" %> value="90">90</option>
			<option <%= max == 100 ? "selected" : "" %> value="100">100</option>
		</select>
	</td>
</tr>
</table>

<br />

<input type="button" value="<liferay-ui:message key="save" />" onClick="submitForm(document.<portlet:namespace />fm);" />

</form>

<script type="text/javascript">
	jQuery(
		function() {
			var selectionMethod = jQuery('#<portlet:namespace />selectionMethod');

			function showHiddenFields() {
				var organization = jQuery('#<portlet:namespace />organization');

				if (selectionMethod.val() == 'users') {
					organization.show();
				}
				else {
					organization.hide();
				}
			}

			showHiddenFields();

			selectionMethod.change(
				function(event) {
					showHiddenFields();
				}
			);
		}
	);
</script>