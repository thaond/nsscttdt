<%@ include file="/html/portlet/enterprise_admin/init.jsp" %>

<%
themeDisplay.setIncludeServiceJs(true);

String redirect = ParamUtil.getString(request, "redirect");

Address address = (Address)request.getAttribute(WebKeys.ADDRESS);

long addressId = BeanParamUtil.getLong(address, request, "addressId");

String className = ParamUtil.getString(request, "className");
long classPK = BeanParamUtil.getLong(address, request, "classPK");

long regionId = BeanParamUtil.getLong(address, request, "regionId");
long countryId = BeanParamUtil.getLong(address, request, "countryId");
int typeId = BeanParamUtil.getInteger(address, request, "typeId");
%>

<script type="text/javascript">
	function <portlet:namespace />saveAddress() {
		document.<portlet:namespace />fm.<portlet:namespace /><%= Constants.CMD %>.value = "<%= address == null ? Constants.ADD : Constants.UPDATE %>";
		submitForm(document.<portlet:namespace />fm);
	}
</script>

<form action="<portlet:actionURL windowState="<%= WindowState.NORMAL.toString() %>"><portlet:param name="struts_action" value="/enterprise_admin/edit_address" /></portlet:actionURL>" method="post" name="<portlet:namespace />fm" onSubmit="<portlet:namespace />saveAddress(); return false;">
<div class="title_categ"><liferay-ui:message key="Chinh-sua-dia-chi"/></div>
<div class="boxcontent">
<input name="<portlet:namespace /><%= Constants.CMD %>" type="hidden" value="" />
<input name="<portlet:namespace />redirect" type="hidden" value="<%= HtmlUtil.escape(redirect) %>" />
<input name="<portlet:namespace />addressId" type="hidden" value="<%= addressId %>" />
<input name="<portlet:namespace />className" type="hidden" value="<%= HtmlUtil.escape(className) %>" />
<input name="<portlet:namespace />classPK" type="hidden" value="<%= classPK %>" />

<liferay-ui:tabs names="address" backURL="<%= redirect %>"/>
<div class="boxcontent_Tab">
<liferay-ui:error exception="<%= AddressCityException.class %>" message="please-enter-a-valid-city" />
<liferay-ui:error exception="<%= AddressStreetException.class %>" message="please-enter-a-valid-street" />
<liferay-ui:error exception="<%= AddressZipException.class %>" message="please-enter-a-valid-zip" />
<liferay-ui:error exception="<%= NoSuchCountryException.class %>" message="please-select-a-country" />
<liferay-ui:error exception="<%= NoSuchRegionException.class %>" message="please-select-a-region" />
<liferay-ui:error exception="<%= NoSuchListTypeException.class %>" message="please-select-a-type" />
<table cellspacing="0" width="100%">
		<tr>
			<td width="15%">
				<liferay-ui:message key="street1" />&nbsp;:
			</td>
			<td width="35%">
				<liferay-ui:input-field model="<%= Address.class %>" bean="<%= address %>" field="street1" />
			</td>
			<td width="15%">
				<liferay-ui:message key="street2" />&nbsp;:
			</td>
			<td>
				<liferay-ui:input-field model="<%= Address.class %>" bean="<%= address %>" field="street2" />
			</td>
		</tr>
		<tr>
			<td>
				<liferay-ui:message key="street3" />&nbsp;:
			</td>
			<td>
				<liferay-ui:input-field model="<%= Address.class %>" bean="<%= address %>" field="street3" />
			</td>
			<td>
				<liferay-ui:message key="city" />&nbsp;:
			</td>
			<td>
				<liferay-ui:input-field model="<%= Address.class %>" bean="<%= address %>" field="city" />
			</td>
		</tr>
		<tr>
			<td>
				<liferay-ui:message key="zip" />&nbsp;:
			</td>
			<td>
				<liferay-ui:input-field model="<%= Address.class %>" bean="<%= address %>" field="zip" />
			</td>
			<td>
				<liferay-ui:message key="country" />&nbsp;:
			</td>
			<td>
				<select  style="width: 158px" id="<portlet:namespace />countryId" name="<portlet:namespace />countryId"></select>
			</td>
		</tr>
		<tr>
			<td>
				<liferay-ui:message key="region" />&nbsp;:
			</td>
			<td>
				<select style="width: 158px" id="<portlet:namespace />regionId" name="<portlet:namespace />regionId"></select>
			</td>
			<td>
				<liferay-ui:message key="type" />&nbsp;:
			</td>
			<td>
				<select name="<portlet:namespace />typeId"  style="width: 158px">
					<option value=""></option>

					<%
					List addressTypes = ListTypeServiceUtil.getListTypes(className + ListTypeImpl.ADDRESS);

					for (int i = 0; i < addressTypes.size(); i++) {
						ListType suffix = (ListType)addressTypes.get(i);
					%>

						<option <%= suffix.getListTypeId() == typeId ? "selected" : "" %> value="<%= String.valueOf(suffix.getListTypeId()) %>"><%= LanguageUtil.get(pageContext, suffix.getName()) %></option>

					<%
					}
					%>

				</select>
			</td>
		</tr>
		<tr>
			<td>
				<liferay-ui:message key="mailing" />&nbsp;:
			</td>
			<td>
				<liferay-ui:input-field model="<%= Address.class %>" bean="<%= address %>" field="mailing" />
			</td>
			<td>
				<liferay-ui:message key="primary" />&nbsp;:
			</td>
			<td>
				<liferay-ui:input-field model="<%= Address.class %>" bean="<%= address %>" field="primary" />
			</td>
		</tr>
		<tr>
			<td></td>
			<td colspan="3">
				<input style="margin-left: 0;" type="submit" value="<liferay-ui:message key="save" />" />
				<input type="button" value="<liferay-ui:message key="cancel" />" onClick="location.href = '<%= HtmlUtil.escape(redirect) %>';" />
			</td>
		</tr>
		</table>
</div>
</div>
</form>
<script type="text/javascript">
	<c:if test="<%= windowState.equals(WindowState.NORMAL) %>">
		Liferay.Util.focusFormField(document.<portlet:namespace />fm.<portlet:namespace />street1);
	</c:if>

	new Liferay.DynamicSelect(
		[
			{
				select: "<portlet:namespace />countryId",
				selectId: "countryId",
				selectDesc: "name",
				selectVal: "<%= countryId %>",
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
				select: "<portlet:namespace />regionId",
				selectId: "regionId",
				selectDesc: "name",
				selectVal: "<%= regionId %>",
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
</script>