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
themeDisplay.setIncludeServiceJs(true);

OrganizationSearch searchContainer = (OrganizationSearch)request.getAttribute("liferay-ui:search:searchContainer");

OrganizationDisplayTerms displayTerms = (OrganizationDisplayTerms)searchContainer.getDisplayTerms();
%>

<liferay-ui:search-toggle
	id="toggle_id_enterprise_admin_organization_search"
	displayTerms="<%= displayTerms %>"
>
	<table cellspacing="0" width="100%">
	<tr>
		<td width="5%">
			<liferay-ui:message key="name" />&nbsp;:
		</td>
		<td width="20%">
			<input name="<portlet:namespace /><%= displayTerms.NAME %>" style="width: 90%" type="text" value="<%= HtmlUtil.escape(displayTerms.getName()) %>" />
		</td>
		<td width="8%">
			<liferay-ui:message key="street" />&nbsp;:
		</td>
		<td width="20%">
			<input name="<portlet:namespace /><%= displayTerms.STREET %>" style="width: 90%" type="text" value="<%= HtmlUtil.escape(displayTerms.getStreet()) %>" />
		</td>
		<td width="10%">
			<liferay-ui:message key="city" />&nbsp;:
		</td>
		<td width="20%">
			<input name="<portlet:namespace /><%= displayTerms.CITY %>" style="width: 90%" type="text" value="<%= HtmlUtil.escape(displayTerms.getCity()) %>" />
		</td>
		<td width="8%">
			<liferay-ui:message key="zip" />&nbsp;:
		</td>
		<td>
			<input name="<portlet:namespace /><%= displayTerms.ZIP %>" style="width: 90%" type="text" value="<%= HtmlUtil.escape(displayTerms.getZip()) %>" />
		</td>
	</tr>
	<tr>
		<td>
			<liferay-ui:message key="type" />&nbsp;:
		</td>
		<td>
			<select name="<portlet:namespace /><%= displayTerms.TYPE %>" style="width: 95%">
				<option <%= (displayTerms.getType() == OrganizationConstants.ANY_TYPE) ? "selected" : "" %> value="<%= OrganizationConstants.ANY_TYPE %>"><liferay-ui:message key="any" /></option>
				<option <%= (displayTerms.getType() == OrganizationConstants.TYPE_REGULAR) ? "selected" : "" %> value="<%= OrganizationConstants.TYPE_REGULAR %>"><liferay-ui:message key="regular" /></option>
				<option <%= (displayTerms.getType() == OrganizationConstants.TYPE_LOCATION) ? "selected" : "" %> value="<%= OrganizationConstants.TYPE_LOCATION %>"><liferay-ui:message key="location" /></option>
			</select>
		</td>
		<td>
			<liferay-ui:message key="country" />&nbsp;:
		</td>
		<td>
			<select style="width: 95%" id="<portlet:namespace /><%= displayTerms.COUNTRY_ID %>" name="<portlet:namespace /><%= displayTerms.COUNTRY_ID %>"></select>
		</td>
		<td>
			<liferay-ui:message key="region" />&nbsp;:
		</td>
		<td>
			<select style="width: 95%" id="<portlet:namespace /><%= displayTerms.REGION_ID %>" name="<portlet:namespace /><%= displayTerms.REGION_ID %>"></select>
		</td>
		<td colspan="2"></td>
	</tr>
	</table>
	
</liferay-ui:search-toggle>
<div class="separator"><!-- --></div>
	<input type="submit" value="<liferay-ui:message key="search-organizations" />" />
	<%
	boolean showButtons = false;

	if (portletName.equals(PortletKeys.ENTERPRISE_ADMIN) && !windowState.equals(LiferayWindowState.POP_UP)) {
		showButtons = true;
	}
	%>

	<c:if test="<%= showButtons %>">
		<c:if test="<%= PortalPermissionUtil.contains(permissionChecker, ActionKeys.ADD_ORGANIZATION) %>">
			<input type="button" value="<liferay-ui:message key="add-organization" />" onClick="<portlet:namespace />addOrganization();" />
		</c:if>
	</c:if>

<%
Organization organization = null;

if (displayTerms.getParentOrganizationId() > 0) {
	try {
		organization = OrganizationLocalServiceUtil.getOrganization(displayTerms.getParentOrganizationId());
	}
	catch (NoSuchOrganizationException nsoe) {
	}
}
%>

<c:if test="<%= organization != null %>">
	<input name="<portlet:namespace /><%= UserDisplayTerms.ORGANIZATION_ID %>" type="hidden" value="<%= organization.getOrganizationId() %>" />
	<liferay-ui:message key="filter-by-organization" />: <%= organization.getName() %><br />
</c:if>

<script type="text/javascript">
	function <portlet:namespace />addOrganization() {
		var url = '<portlet:renderURL windowState="<%= WindowState.NORMAL.toString() %>"><portlet:param name="struts_action" value="/enterprise_admin/edit_organization" /></portlet:renderURL>';

		if (toggle_id_enterprise_admin_organization_searchcurClickValue == 'basic') {
			url += '&<portlet:namespace />redirect=' + encodeURIComponent(document.<portlet:namespace />fm.<portlet:namespace />organizationsRedirect.value);

			<c:if test="<%= organization != null %>">
				url += '&<portlet:namespace />parentOrganizationId=<%= organization.getOrganizationId() %>';
			</c:if>

			url += '&<portlet:namespace /><%= displayTerms.NAME %>=' + document.<portlet:namespace />fm.<portlet:namespace /><%= displayTerms.KEYWORDS %>.value;

			submitForm(document.hrefFm, url);
		}
		else {
			<c:if test="<%= organization != null %>">
				url += '&<portlet:namespace />parentOrganizationId=<%= organization.getOrganizationId() %>';
			</c:if>

			document.<portlet:namespace />fm.method = 'post';
			document.<portlet:namespace />fm.<portlet:namespace />redirect.value = document.<portlet:namespace />fm.<portlet:namespace />organizationsRedirect.value;
			submitForm(document.<portlet:namespace />fm, url);
		}
	}

	new Liferay.DynamicSelect(
		[
			{
				select: '<portlet:namespace /><%= displayTerms.COUNTRY_ID %>',
				selectId: 'countryId',
				selectDesc: 'name',
				selectVal: '<%= displayTerms.getCountryId() %>',
				selectData: function(callback) {
					Liferay.Service.Portal.Country.getCountries(
						{
							active: true
						},
						callback
					);
				}
			},
			{
				select: '<portlet:namespace /><%= displayTerms.REGION_ID %>',
				selectId: 'regionId',
				selectDesc: 'name',
				selectVal: '<%= displayTerms.getRegionId() %>',
				selectData: function(callback, selectKey) {
					Liferay.Service.Portal.Region.getRegions(
						{
							countryId: selectKey,
							active: true
						},
						callback
					);
				}
			}
		]
	);

	<c:if test="<%= windowState.equals(WindowState.NORMAL) %>">
		Liferay.Util.focusFormField(document.<portlet:namespace />fm.<portlet:namespace /><%= displayTerms.NAME %>);
		Liferay.Util.focusFormField(document.<portlet:namespace />fm.<portlet:namespace /><%= displayTerms.KEYWORDS %>);
	</c:if>
</script>
