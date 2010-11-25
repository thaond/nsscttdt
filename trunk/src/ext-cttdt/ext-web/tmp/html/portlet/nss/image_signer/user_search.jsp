<%@page import="com.nss.portlet.image_signer.search.UserDisplayTerms"%>
<%@page import="com.nss.portlet.image_signer.search.UserSearch"%>
<%@ include file="/html/portlet/nss/image_signer/init.jsp"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%
	UserSearch searchContainer = (UserSearch) request
			.getAttribute("liferay-ui:search:searchContainer");
	UserDisplayTerms displayTerms = (UserDisplayTerms) searchContainer
			.getDisplayTerms();
%>

<liferay-ui:search-toggle id="toggle_id_journal_article_search"
	displayTerms="<%= displayTerms %>" buttonLabel="search">
	<table class="lfr-table">
		<tr>
			<td><liferay-ui:message key="first-name" /></td>
			<td><liferay-ui:message key="middle-name" /></td>
			<td><liferay-ui:message key="last-name" /></td>
		</tr>
		<tr>
			<td><input
				name="<portlet:namespace /><%=UserDisplayTerms.FIRSTNAME%>" size="20"
				type="text"
				value="<%=HtmlUtil.escape(displayTerms.getFirstName())%>" /></td>
			<td><input
				name="<portlet:namespace /><%=UserDisplayTerms.MIDDLENAME%>" size="20"
				type="text"
				value="<%=HtmlUtil.escape(displayTerms.getMiddleName())%>" /></td>
			<td><input
				name="<portlet:namespace /><%=UserDisplayTerms.LASTNAME%>" size="20"
				type="text" value="<%=HtmlUtil.escape(displayTerms.getLastName())%>" />
			</td>
		</tr>
	</table>
</liferay-ui:search-toggle>
