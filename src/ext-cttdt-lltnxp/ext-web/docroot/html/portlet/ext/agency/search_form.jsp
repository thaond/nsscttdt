<%@ include file="/html/portlet/ext/agency/init.jsp" %>
<%@page import="com.sgs.portlet.agency.search.AgencyDisplayTerms"%>
<%@page import="com.sgs.portlet.agency.search.AgencySearch"%>
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
				<input name="<portlet:namespace/><%=AgencyDisplayTerms.HO %>" style="width: 85%" type="text" value="<%= HtmlUtil.escape(displayTerms.getHo()) %>" />
			</td>
			<td width="3%" align="right">
				<liferay-ui:message key="ten"/>:
			</td>
			<td width="12%">
				<input name="<portlet:namespace/><%=AgencyDisplayTerms.TEN %>" style="width: 85%" type="text" value="<%= HtmlUtil.escape(displayTerms.getTen()) %>" />
			</td>
			<td width="3%" align="right">
				<liferay-ui:message key="agency.code"/>:
			</td>
			<td width="12%">
				<input name="<portlet:namespace/><%=AgencyDisplayTerms.MA %>" style="width: 85%" type="text" value="<%= HtmlUtil.escape(displayTerms.getMa()) %>" />
			</td>
			<td width="10%" align="right">
				<liferay-ui:message key="ten-co-quan"/>:
			</td>
			<td>
				<input name="<portlet:namespace/><%=AgencyDisplayTerms.TENCOQUAN %>" style="width: 95%" type="text" value="<%= HtmlUtil.escape(displayTerms.getTenCoQuan()) %>" />
			</td>
			
		</tr>
	</table>	
</liferay-ui:search-toggle>
<br/>
	<input type="submit" name="<portlet:namespace/>search" value="<liferay-ui:message key="search"/>"/>
