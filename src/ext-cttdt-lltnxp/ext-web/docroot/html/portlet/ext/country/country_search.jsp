<%@ include file="/html/portlet/ext/country/init.jsp"%>
<%@page import="com.sgs.portlet.country.search.CountrySearch"%>
<%@page import="com.sgs.portlet.country.search.CountryDisplayTerms"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%
	CountrySearch countrySearch = (CountrySearch)request.getAttribute("liferay-ui:search:searchContainer");
	CountryDisplayTerms displayTerms = (CountryDisplayTerms)countrySearch.getDisplayTerms();
%>

<liferay-ui:search-toggle displayTerms="<%=displayTerms%>" id="toogle_id_country" >
	<table cellspacing="0" width="100%">
		<tr>
		</tr>
		<tr>
			<td  width="5%">
				<liferay-ui:message key="code."/>:&nbsp;
			</td>
			
		 	<td width="15%">
				<input name="<portlet:namespace/><%=CountryDisplayTerms.MA %>" style="width: 90%" type="text" value="<%= HtmlUtil.escape(displayTerms.getMa()) %>" />
			</td>
			
			<td width="5%">
				<liferay-ui:message key="name."/>:&nbsp;
			</td>
			
			<td width="15%">
				<input name="<portlet:namespace/><%=CountryDisplayTerms.TEN %>" style="width: 90%" type="text" value="<%= HtmlUtil.escape(displayTerms.getTen()) %>" />
			</td>
			
			<td width="5%">
				<liferay-ui:message key="description."/>:&nbsp;
			</td>
			
			<td>
				<input name="<portlet:namespace/><%=CountryDisplayTerms.MOTA %>" style="width: 90%" type="text" value="<%= HtmlUtil.escape(displayTerms.getMota()) %>" />
			</td>
		</tr>
		
				
	</table>	
</liferay-ui:search-toggle>
<br/>
<input type="submit" name="<portlet:namespace/>search" value="<liferay-ui:message key="search"/>"/>