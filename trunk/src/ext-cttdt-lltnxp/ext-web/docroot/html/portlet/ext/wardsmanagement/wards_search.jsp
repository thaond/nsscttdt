<%@ include file="/html/portlet/ext/wardsmanagement/init.jsp" %>
<%@page import="com.sgs.portlet.wardsmanagement.search.WardSearch"%>
<%@page import="com.sgs.portlet.wardsmanagement.search.WardDisplayTerms"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%
	WardSearch wardSearch = (WardSearch)request.getAttribute("liferay-ui:search:searchContainer");
	WardDisplayTerms displayTerms = (WardDisplayTerms)wardSearch.getDisplayTerms();
%>

<liferay-ui:search-toggle displayTerms="<%=displayTerms%>" id="toogle_id_ward" >
	<table cellspacing="0" width="100%">
		<tr>
			<td align="right" width="12%">
				<liferay-ui:message key="wardsmanagement.code"/>&nbsp;:
			</td>
			
		 	<td width="10%">
				<input name="<portlet:namespace/><%=WardDisplayTerms.MA %>" style="width: 90%" type="text" value="<%= HtmlUtil.escape(displayTerms.getMa()) %>" />
			</td>
			
			<td align="right" width="12%">
				<liferay-ui:message key="wardsmanagement.name"/>&nbsp;:
			</td>
			
			<td width="25%">
				<input name="<portlet:namespace/><%=WardDisplayTerms.TEN %>" style="width: 90%" type="text" value="<%= HtmlUtil.escape(displayTerms.getTen()) %>" />
			</td>
			
			<td align="right" width="6%">
				<liferay-ui:message key="wardsmanagement.description"/>&nbsp;:
			</td>
			
			<td>
				<input name="<portlet:namespace/><%=WardDisplayTerms.MOTA %>" style="width: 98%" type="text" value="<%= HtmlUtil.escape(displayTerms.getMota()) %>" />
			</td>
		</tr>
		
				
	</table>	
</liferay-ui:search-toggle>
<br/>
<input type="submit" class="button-width" name="<portlet:namespace/>search" value="<liferay-ui:message key="search"/>"/>