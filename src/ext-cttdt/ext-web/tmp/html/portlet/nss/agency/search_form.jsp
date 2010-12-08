<%@ include file="/html/portlet/nss/agency/init.jsp" %>
<%@page import="com.nss.portlet.agency.search.AgencyDisplayTerms"%>
<%@page import="com.nss.portlet.agency.search.AgencySearch"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%
	AgencySearch agencySearch = (AgencySearch)request.getAttribute("liferay-ui:search:searchContainer");
	AgencyDisplayTerms displayTerms = (AgencyDisplayTerms)agencySearch.getDisplayTerms();
%>
<liferay-ui:search-toggle displayTerms="<%=displayTerms%>" id="toogle_id_agency" >
	<table class="agency-table" cellspacing="0" width="100%">
		<tr>
		 	<td width="3%" align="right"><liferay-ui:message key="ho"/>:</td>
			<td width="12%">
				<input name="<portlet:namespace/><%=AgencyDisplayTerms.HO %>" type="text" value="<%= HtmlUtil.escape(displayTerms.getHo()) %>" />
			</td>
			<td width="3%" align="right">
				<liferay-ui:message key="ten"/>:
			</td>
			<td width="12%">
				<input name="<portlet:namespace/><%=AgencyDisplayTerms.TEN %>" type="text" value="<%= HtmlUtil.escape(displayTerms.getTen()) %>" />
			</td>
		</tr>
		<tr>
			<td width="3%" align="right">
				<liferay-ui:message key="agency.code"/>:
			</td>
			<td width="12%">
				<input name="<portlet:namespace/><%=AgencyDisplayTerms.MA %>" type="text" value="<%= HtmlUtil.escape(displayTerms.getMa()) %>" />
			</td>
			<td width="10%" align="right">
				<liferay-ui:message key="ten-co-quan"/>:
			</td>
			<td>
				<input name="<portlet:namespace/><%=AgencyDisplayTerms.TENCOQUAN %>" type="text" value="<%= HtmlUtil.escape(displayTerms.getTenCoQuan()) %>" />
			</td>
		</tr>	
	</table>	
</liferay-ui:search-toggle>
<br/>
	<input type="submit" name="<portlet:namespace/>search" value="<liferay-ui:message key="search"/>"/>
