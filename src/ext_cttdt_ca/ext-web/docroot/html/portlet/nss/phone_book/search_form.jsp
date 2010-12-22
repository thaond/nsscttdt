<%@ include file="/html/portlet/nss/phone_book/init.jsp"%>

<%@page	import="com.nss.portlet.phone_book.search.ContactBookDisplayTerms"%>
<%@page import="com.nss.portlet.phone_book.search.ContactBookSearch"%>

<%
	ContactBookSearch contactBookSearch = (ContactBookSearch) request
			.getAttribute("liferay-ui:search:searchContainer");
	ContactBookDisplayTerms displayTerms = (ContactBookDisplayTerms) contactBookSearch
			.getDisplayTerms();
%>

<liferay-ui:search-toggle displayTerms="<%= displayTerms %>" id="toogle_id_phone_book">
	<table cellspacing="0" width="100%">
		<tr>
			<td><liferay-ui:message key="contact-code" />&nbsp;</td>
			<td><input id="<portlet:namespace/>contactBookCodeAutoComplete" name="<portlet:namespace/><%=ContactBookDisplayTerms.CODE%>" 
				style="width: 90%" type="text" value="<%=HtmlUtil.escape(displayTerms.getContactBookCode())%>" />
			</td>

			<td><liferay-ui:message key="contact-name" />&nbsp;</td>
			<td><input id="<portlet:namespace/>contactBookNameAutoComplete"	name="<portlet:namespace/><%=ContactBookDisplayTerms.NAME%>" 
				style="width: 90%" type="text" value="<%=HtmlUtil.escape(displayTerms.getContactBookName())%>" />
			</td>
			
			<td><liferay-ui:message key="contact-description" />&nbsp;</td>
			<td><input id="<portlet:namespace/>contactBookDescriptionAutoComplete" name="<portlet:namespace/><%=ContactBookDisplayTerms.DESCRIPTION%>"
				style="width: 90%" type="text" value="<%=HtmlUtil.escape(displayTerms.getContactDescription())%>" />
			</td>
		</tr>
	</table>
</liferay-ui:search-toggle>

<br><br>
<input type="submit" class="button-width" name="<portlet:namespace/>search" value="<liferay-ui:message key="search"/>" />

