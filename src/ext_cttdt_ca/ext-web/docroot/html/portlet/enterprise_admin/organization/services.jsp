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
Organization organization = (Organization)request.getAttribute(WebKeys.ORGANIZATION);

long organizationId = (organization != null) ? organization.getOrganizationId() : 0;

List<OrgLabor> orgLabors = Collections.EMPTY_LIST;

int[] orgLaborsIndexes = null;

String orgLaborsIndexesParam = ParamUtil.getString(renderRequest, "orgLaborsIndexes");

if (Validator.isNotNull(orgLaborsIndexesParam)) {
	orgLabors = new ArrayList<OrgLabor>();

	orgLaborsIndexes = StringUtil.split(orgLaborsIndexesParam, 0);

	for (int orgLaborsIndex : orgLaborsIndexes) {
		OrgLabor orgLabor = new OrgLaborImpl();

		orgLabor.setSunOpen(-1);
		orgLabor.setSunClose(-1);
		orgLabor.setMonOpen(-1);
		orgLabor.setMonClose(-1);
		orgLabor.setTueOpen(-1);
		orgLabor.setTueClose(-1);
		orgLabor.setWedOpen(-1);
		orgLabor.setWedClose(-1);
		orgLabor.setThuOpen(-1);
		orgLabor.setThuClose(-1);
		orgLabor.setFriOpen(-1);
		orgLabor.setFriClose(-1);
		orgLabor.setSatOpen(-1);
		orgLabor.setSatClose(-1);

		orgLabors.add(orgLabor);
	}
}
else {
	if (organizationId > 0) {
		orgLabors = OrgLaborServiceUtil.getOrgLabors(organizationId);

		orgLaborsIndexes = new int[orgLabors.size()];

		for (int i = 0; i < orgLabors.size() ; i++) {
			orgLaborsIndexes[i] = i;
		}
	}

	if (orgLabors.isEmpty()) {
		orgLabors = new ArrayList<OrgLabor>();

		OrgLabor orgLabor = new OrgLaborImpl();

		orgLabor.setSunOpen(-1);
		orgLabor.setSunClose(-1);
		orgLabor.setMonOpen(-1);
		orgLabor.setMonClose(-1);
		orgLabor.setTueOpen(-1);
		orgLabor.setTueClose(-1);
		orgLabor.setWedOpen(-1);
		orgLabor.setWedClose(-1);
		orgLabor.setThuOpen(-1);
		orgLabor.setThuClose(-1);
		orgLabor.setFriOpen(-1);
		orgLabor.setFriClose(-1);
		orgLabor.setSatOpen(-1);
		orgLabor.setSatClose(-1);

		orgLabors.add(orgLabor);

		orgLaborsIndexes = new int[]{0};
	}

	if (orgLaborsIndexes == null) {
		orgLaborsIndexes = new int[0];
	}
}

DateFormat timeFormat = new SimpleDateFormat("HH:mm", locale);
%>

<liferay-ui:error-marker key="errorSection" value="services" />

<h3><liferay-ui:message key="services" /></h3>

<liferay-ui:error key="<%= NoSuchListTypeException.class.getName() + Organization.class.getName() + ListTypeImpl.ORGANIZATION_SERVICE %>" message="please-select-a-type" />

<fieldset class="block-labels">

	<%
	Calendar cal = CalendarFactoryUtil.getCalendar();
	String[] days = CalendarUtil.getDays(locale);
	String[] paramPrefixes = {"sun", "mon", "tue", "wed", "thu", "fri", "sat"};

	for (int i = 0; i < orgLaborsIndexes.length; i++) {
		int orgLaborsIndex = orgLaborsIndexes[i];

		OrgLabor orgLabor = orgLabors.get(i);

		int[] openArray = new int[paramPrefixes.length];

		for (int j = 0; j < paramPrefixes.length; j++) {
			openArray[j] = ParamUtil.getInteger(request, paramPrefixes[j] + "Open" + orgLaborsIndex, BeanPropertiesUtil.getInteger(orgLabor, paramPrefixes[j] + "Open", -1));
		}

		int[] closeArray = new int[paramPrefixes.length];

		for (int j = 0; j < paramPrefixes.length; j++) {
			closeArray[j] = ParamUtil.getInteger(request, paramPrefixes[j] + "Close" + orgLaborsIndex, BeanPropertiesUtil.getInteger(orgLabor, paramPrefixes[j] + "Close", -1));
		}
	%>

		<div class="lfr-form-row">
			<div class="row-fields">

				<%
				String fieldParam = "orgLaborId" + orgLaborsIndex;
				%>

				<input id="<portlet:namespace /><%= fieldParam %>" name="<portlet:namespace /><%= fieldParam %>" type="hidden" value="" />


				<%
				fieldParam = "orgLaborTypeId" + orgLaborsIndex;
				%>

				<div class="ctrl-holder">
					<label class="inline-label" for="<portlet:namespace /><%= fieldParam %>"><liferay-ui:message key="type" /></label>

					<select id="<portlet:namespace /><%= fieldParam %>" name="<portlet:namespace /><%= fieldParam %>">

					<%
					List<ListType> orgLaborTypes = ListTypeServiceUtil.getListTypes(ListTypeImpl.ORGANIZATION_SERVICE);

					for (ListType suffix : orgLaborTypes) {
					%>

						<option <%= (suffix.getListTypeId() == orgLabor.getTypeId()) ? "selected" : "" %> value="<%= suffix.getListTypeId() %>"><liferay-ui:message key="<%= suffix.getName() %>" /></option>

					<%
					}
					%>

					</select>
				</div>

				<table class="org-labor-table">
				<tr>
					<td></td>

					<%
					for (String day : days) {
					%>

						<th>
							<label><%= day %></label>
						</th>

					<%
					}
					%>

				</tr>
				<tr>
					<td>
						<label><liferay-ui:message key="open" /></label>
					</td>

					<%
					for (int j = 0; j < days.length; j++) {
						String curParam = paramPrefixes[j];
						int curOpen = openArray[j];
					%>

						<td>
							<select name="<portlet:namespace /><%= curParam %>Open<%= orgLaborsIndex %>">
								<option value="-1"></option>

								<%
								cal.set(Calendar.HOUR_OF_DAY, 0);
								cal.set(Calendar.MINUTE, 0);
								cal.set(Calendar.SECOND, 0);
								cal.set(Calendar.MILLISECOND, 0);

								int today = cal.get(Calendar.DATE);

								while (cal.get(Calendar.DATE) == today) {
									String timeOfDayDisplay = timeFormat.format(cal.getTime());
									int timeOfDayValue = GetterUtil.getInteger(StringUtil.replace(timeOfDayDisplay, StringPool.COLON, StringPool.BLANK));

									cal.add(Calendar.MINUTE, 30);
								%>

									<option <%= (curOpen == timeOfDayValue) ? "selected" : "" %> value="<%= timeOfDayValue %>"><%= timeOfDayDisplay %></option>

								<%
								}
								%>

							</select>
						</td>

					<%
					}
					%>

				</tr>
				<tr>
					<td>
						<label><liferay-ui:message key="close" /></label>
					</td>

					<%
					for (int j = 0; j < days.length; j++) {
						String curParam = paramPrefixes[j];
						int curClose = closeArray[j];
					%>

						<td>
							<select name="<portlet:namespace /><%= curParam %>Close<%= orgLaborsIndex %>">
								<option value="-1"></option>

								<%
								cal.set(Calendar.HOUR_OF_DAY, 0);
								cal.set(Calendar.MINUTE, 0);
								cal.set(Calendar.SECOND, 0);
								cal.set(Calendar.MILLISECOND, 0);

								int today = cal.get(Calendar.DATE);

								while (cal.get(Calendar.DATE) == today) {
									String timeOfDayDisplay = timeFormat.format(cal.getTime());
									int timeOfDayValue = GetterUtil.getInteger(StringUtil.replace(timeOfDayDisplay, StringPool.COLON, StringPool.BLANK));

									cal.add(Calendar.MINUTE, 30);
								%>

									<option <%= (curClose == timeOfDayValue) ? "selected" : "" %> value="<%= timeOfDayValue %>"><%= timeOfDayDisplay %></option>

								<%
								}
								%>

							</select>
						</td>

					<%
					}
					%>

				</tr>
				</table>
			</div>
		</div>

	<%
	}
	%>

</fieldset>

<script type="text/javascript">
	jQuery(
		function () {
			new Liferay.AutoFields(
				{
					container: '#services > fieldset',
					baseRows: '#services > fieldset .lfr-form-row',
					fieldIndexes: '<portlet:namespace />orgLaborsIndexes'
				}
			);
		}
	);
</script>