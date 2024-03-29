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

Phone phone = (Phone)request.getAttribute(WebKeys.PHONE);

long phoneId = BeanParamUtil.getLong(phone, request, "phoneId");

String className = ParamUtil.getString(request, "className");
long classPK = BeanParamUtil.getLong(phone, request, "classPK");

int typeId = BeanParamUtil.getInteger(phone, request, "typeId");
%>

<script type="text/javascript">
	function <portlet:namespace />savePhone() {
		document.<portlet:namespace />fm.<portlet:namespace /><%= Constants.CMD %>.value = "<%= phone == null ? Constants.ADD : Constants.UPDATE %>";
		submitForm(document.<portlet:namespace />fm);
	}
</script>

<form action="<portlet:actionURL windowState="<%= WindowState.NORMAL.toString() %>"><portlet:param name="struts_action" value="/enterprise_admin/edit_phone" /></portlet:actionURL>" method="post" name="<portlet:namespace />fm" onSubmit="<portlet:namespace />savePhone(); return false;">
<div class="title_categ"><liferay-ui:message key="Chinh-sua-so-dien-thoai"/></div>
<div class="boxcontent">
<input name="<portlet:namespace /><%= Constants.CMD %>" type="hidden" value="" />
<input name="<portlet:namespace />redirect" type="hidden" value="<%= HtmlUtil.escape(redirect) %>" />
<input name="<portlet:namespace />phoneId" type="hidden" value="<%= String.valueOf(phoneId) %>" />
<input name="<portlet:namespace />className" type="hidden" value="<%= HtmlUtil.escape(className) %>" />
<input name="<portlet:namespace />classPK" type="hidden" value="<%= classPK %>" />

<liferay-ui:tabs names="phone-number" backURL="<%= redirect %>"/>
<div class="boxcontent_Tab">
<liferay-ui:error exception="<%= NoSuchListTypeException.class %>" message="please-select-a-type" />
<liferay-ui:error exception="<%= PhoneNumberException.class %>" message="please-enter-a-valid-phone-number" />
<table cellspacing="0" width="100%">
<tr>
	<td width="5%">
		<liferay-ui:message key="number" />&nbsp;:
	</td>
	<td width="10%">
		<liferay-ui:input-field model="<%= Phone.class %>" bean="<%= phone %>" field="number" />
	</td>
	<td width="10%">
		<liferay-ui:message key="extension" />&nbsp;:
	</td>
	<td width="10%">
		<liferay-ui:input-field model="<%= Phone.class %>" bean="<%= phone %>" field="extension" />
	</td>
	<td width="5%">
		<liferay-ui:message key="type" />&nbsp;:
	</td>
	<td width="20%">
		<select name="<portlet:namespace />typeId">
			<option value=""></option>

			<%
			List phoneTypes = ListTypeServiceUtil.getListTypes(className + ListTypeImpl.PHONE);

			for (int i = 0; i < phoneTypes.size(); i++) {
				ListType suffix = (ListType)phoneTypes.get(i);
			%>

				<option <%= suffix.getListTypeId() == typeId ? "selected" : "" %> value="<%= String.valueOf(suffix.getListTypeId()) %>"><%= LanguageUtil.get(pageContext, suffix.getName()) %></option>

			<%
			}
			%>

		</select>
	</td>
	<td width="10%">
		<liferay-ui:message key="primary" />&nbsp;:
	</td>
	<td width="10%">
		<liferay-ui:input-field model="<%= Phone.class %>" bean="<%= phone %>" field="primary" />
	</td>
	<td>
		<input type="submit" value="<liferay-ui:message key="save" />" />
		<input type="button" value="<liferay-ui:message key="cancel" />" onClick="location.href = '<%= HtmlUtil.escape(redirect) %>';" />
	</td>
</tr>
</table>
</div>
</div>
</form>

<c:if test="<%= windowState.equals(WindowState.NORMAL) %>">
	<script type="text/javascript">
		Liferay.Util.focusFormField(document.<portlet:namespace />fm.<portlet:namespace />number);
	</script>
</c:if>