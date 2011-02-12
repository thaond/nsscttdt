<%@ include file="/html/portlet/ext/citymanagement/init.jsp" %>
<%@page import="com.sgs.portlet.citymanagement.search.CitySearch"%>
<%@page import="com.sgs.portlet.citymanagement.search.CityDisplayTerms"%>
<%
	CitySearch citySearch = (CitySearch)request.getAttribute("liferay-ui:search:searchContainer");
	CityDisplayTerms displayTerms = (CityDisplayTerms)citySearch.getDisplayTerms();
%>

<liferay-ui:search-toggle displayTerms="<%=displayTerms%>" id="toogle_id_city" >
	<table width="100%" cellspacing="0">
		<tr> 
			<td align="right" width="15%">
				<liferay-ui:message key="citymanagement.code"/>:&nbsp;
			</td>
			
			<td width="15%">
				<input name="<portlet:namespace/><%=CityDisplayTerms.MA %>" style="width: 95%" type="text" value="<%= HtmlUtil.escape(displayTerms.getMa()) %>" />
			</td>
			
			<td align="right" width="16%">
				<liferay-ui:message key="citymanagement.name"/>:&nbsp;
			</td>
			
			<td>
				<input name="<portlet:namespace/><%=CityDisplayTerms.TEN %>" style="width: 98%" type="text" value="<%= HtmlUtil.escape(displayTerms.getTen()) %>" />
			</td>
		</tr>
		
	</table>	
</liferay-ui:search-toggle>
<br/>
<input type="submit" name="<portlet:namespace/>search" value="<liferay-ui:message key="search"/>"/>
