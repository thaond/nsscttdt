<%@ include file="/html/portlet/ext/signer/init.jsp" %>

<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.sgs.portlet.signer.search.UserSearch"%>
<%@page import="com.sgs.portlet.signer.search.UserDisplayTerms"%>
<%
	UserSearch searchContainerAfter = (UserSearch)request.getAttribute("liferay-ui:search:searchContainer");
	UserDisplayTerms displayTermsAfter = (UserDisplayTerms) searchContainerAfter.getDisplayTerms();
%>

<liferay-ui:search-toggle displayTerms="<%=displayTermsAfter%>" id="toogle_id_signer_search" >
	<table cellspacing="0" width="100%">
		<tr>
			<td width="5%">
				<liferay-ui:message key="ho"/>&nbsp;:
			</td>
			<td width="20%">
				<input name="<portlet:namespace/><%=UserDisplayTerms.LASTNAME %>" style="width: 90%" type="text" value="<%= HtmlUtil.escape(displayTermsAfter.getLastName()) %>" />
			</td>
			<td width="5%">
				<liferay-ui:message key="ten"/>&nbsp;:
			</td>
			<td>
				<input name="<portlet:namespace/><%=UserDisplayTerms.FIRSTNAME %>" style="width: 90%" type="text" value="<%= HtmlUtil.escape(displayTermsAfter.getFirstName()) %>" />
			</td>
			
		</tr>
	</table>	
</liferay-ui:search-toggle>
<br/>
<input type="submit" name="<portlet:namespace/>search" value="<liferay-ui:message key="search"/>"/>