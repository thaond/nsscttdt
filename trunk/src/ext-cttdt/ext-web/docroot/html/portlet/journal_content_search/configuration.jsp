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

<%@ include file="/html/portlet/journal_content_search/init.jsp" %>

<form action="<liferay-portlet:actionURL portletConfiguration="true" />" method="post" name="<portlet:namespace />fm">
<input name="<portlet:namespace /><%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />

<liferay-ui:message key="define-the-behavior-of-this-search" />

<br /><br />

<table class="lfr-table">
<tr>
	<td>
		<liferay-ui:message key="web-content-type" />
	</td>
	<td>
		<select name="<portlet:namespace />type">
			<option value=""></option>

			<%
			for (int i = 0; i < JournalArticleImpl.TYPES.length; i++) {
			%>

				<option <%= type.equals(JournalArticleImpl.TYPES[i]) ? "selected" : "" %> value="<%= JournalArticleImpl.TYPES[i] %>"><%= LanguageUtil.get(pageContext, JournalArticleImpl.TYPES[i]) %></option>

			<%
			}
			%>

		</select>
	</td>
</tr>
</table>

<br />

<liferay-ui:message key="only-show-results-for-web-content-listed-in-a-web-content-display-portlet" />

<input <%= showListed ? "checked" : "" %> name="<portlet:namespace />showListed" type="checkbox" onClick="document.<portlet:namespace />fm.<portlet:namespace />targetPortletId.disabled = this.checked;" />

<br /><br />

<table class="lfr-table">
<tr>
	<td>
		<liferay-ui:message key="target-portlet-id" />
	</td>
	<td>
		<input class="lfr-input-text" <%= showListed ? "disabled" : "" %> name="<portlet:namespace />targetPortletId" type="text" value="<%= targetPortletId %>" />
	</td>
</tr>
<!-- Tu update 20101122 -->
<tr >
	<td style="padding-top: 10px;">
		<liferay-ui:message key="Cai-Dat-Tim-Kiem" />
	</td>
	<td style="padding-top: 10px;">
		<input <%= b1 ? "checked" : "" %> type="radio" name="<portlet:namespace />c_search_type" value="all" > <liferay-ui:message key="Tat-Ca" /><br>
		<input <%= b2 ? "checked" : "" %> type="radio" name="<portlet:namespace />c_search_type" value="sign"> <liferay-ui:message key="Bai-Da-Ky" /><br>
		<input <%= b3 ? "checked" : "" %> type="radio" name="<portlet:namespace />c_search_type" value="changesign" > <liferay-ui:message key="Bai-Ky-Bi-Doi" /><br>
		<input <%= b4 ? "checked" : "" %> type="radio" name="<portlet:namespace />c_search_type" value="notsign" > <liferay-ui:message key="Bai-Chua-Ky" /><br>
	</td>
</tr>
<!-- end Tu update -->
</table>
<br />

<input type="button" value="<liferay-ui:message key="save" />" onClick="submitForm(document.<portlet:namespace />fm);" />

</form>