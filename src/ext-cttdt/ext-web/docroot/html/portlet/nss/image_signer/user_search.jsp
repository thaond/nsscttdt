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
	<table cellspacing="0" width="100%">
			<tr>
				<td width="5%"><liferay-ui:message key="first-name" />:</td>
			<td width="20%"><input
				name="<portlet:namespace /><%=UserDisplayTerms.FIRSTNAME%>" style="width: 95%"
				type="text"
				value="<%=HtmlUtil.escape(displayTerms.getFirstName())%>" /></td>
			<td width="10%"><liferay-ui:message key="middle-name" />:</td>
			<td width="30%"><input
				name="<portlet:namespace /><%=UserDisplayTerms.MIDDLENAME%>" style="width: 95%"
				type="text"
				value="<%=HtmlUtil.escape(displayTerms.getMiddleName())%>" /></td>
			<td width="5%"><liferay-ui:message key="last-name" />:</td>
			<td><input
				name="<portlet:namespace /><%=UserDisplayTerms.LASTNAME%>" style="width: 95%"
				type="text" value="<%=HtmlUtil.escape(displayTerms.getLastName())%>" />
			</td>
		</tr>
	</table>
</liferay-ui:search-toggle>
