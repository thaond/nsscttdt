<%@page import="com.nss.portlet.phone_book.search.DetailBookDisplayTerms"%>
<%@page import="com.nss.portlet.phone_book.search.DetailBookSearch"%>
<%@ include file="/html/portlet/nss/phone_book/init.jsp"%>

<%
	DetailBookSearch detailBookSearch = (DetailBookSearch) request.getAttribute("liferay-ui:search:searchContainer");
	DetailBookDisplayTerms displayTerms = (DetailBookDisplayTerms) detailBookSearch.getDisplayTerms();
%>

<liferay-ui:search-toggle displayTerms="<%= displayTerms %>"
	id="toogle_id_phone_book_detail">
	<table cellspacing="0" width="100%">
		<tr>
			<td><liferay-ui:message key="detail-code" />:&nbsp;</td>
			<td width="20%"><input id="<portlet:namespace/>detailBookCodeAutoComplete" name="<portlet:namespace/><%=DetailBookDisplayTerms.CODE%>"
				style="width: 90%" type="text" value="<%=HtmlUtil.escape(displayTerms.getDetailBookCode())%>" />
			</td>

			<td><liferay-ui:message key="detail-name" />:&nbsp;</td>
			<td width="20%"><input id="<portlet:namespace/>detailBookNameAutoComplete" name="<portlet:namespace/><%=DetailBookDisplayTerms.NAME%>"
				style="width: 90%" type="text" value="<%=HtmlUtil.escape(displayTerms.getDetailBookName())%>" />
			</td>
			<td><liferay-ui:message key="detail-description" />:&nbsp;</td>
			<td width="20%"><input id="<portlet:namespace/>detailBookDescriptionAutoComplete" name="<portlet:namespace/><%=DetailBookDisplayTerms.DESCRIPTION%>"
				style="width: 90%" type="text" value="<%=HtmlUtil.escape(displayTerms.getDetailDescription())%>" />
			</td>
		</tr>
		<tr>
			<td><liferay-ui:message key="detail-zip" />:&nbsp;</td>
			<td width="20%"><input id="<portlet:namespace/>detailBookZipAutoComplete" name="<portlet:namespace/><%=DetailBookDisplayTerms.ZIP%>"
				style="width: 90%" type="text" value="<%=HtmlUtil.escape(displayTerms.getZip())%>" />
			</td>
			<td><liferay-ui:message key="detail-internal" />:&nbsp;</td>
			<td width="20%"><input id="<portlet:namespace/>detailBookInternalAutoComplete" name="<portlet:namespace/><%=DetailBookDisplayTerms.INTERNAL%>"
				style="width: 90%" type="text" value="<%=HtmlUtil.escape(displayTerms.getInternal())%>" />
			</td>
			<td><liferay-ui:message key="detail-home" />:&nbsp;</td>
			<td width="20%"><input id="<portlet:namespace/>detailBookHomeAutoComplete" name="<portlet:namespace/><%=DetailBookDisplayTerms.HOME%>"
				style="width: 90%" type="text" value="<%=HtmlUtil.escape(displayTerms.getHome())%>" />
			</td>
			<td><liferay-ui:message key="detail-mobile" />:&nbsp;</td>
			<td width="20%"><input id="<portlet:namespace/>detailBookMobileAutoComplete" name="<portlet:namespace/><%=DetailBookDisplayTerms.MOBILE%>"
				style="width: 90%" type="text" value="<%=HtmlUtil.escape(displayTerms.getMobile())%>" />
			</td>
		</tr>
	</table>
</liferay-ui:search-toggle>
<br><br>
<input type="submit" class="button-width" name="<portlet:namespace/>search" value="<liferay-ui:message key="search"/>" />

