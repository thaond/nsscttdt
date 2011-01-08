<%@ include file="/html/portlet/ext/districtmanagement/init.jsp"%>
<%@page import="com.sgs.portlet.districtmanagement.search.DistrictSearch"%>
<%@page import="com.sgs.portlet.districtmanagement.search.DistrictDisplayTerms"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%
	DistrictSearch districtSearch = (DistrictSearch)request.getAttribute("liferay-ui:search:searchContainer");
	DistrictDisplayTerms displayTerms = (DistrictDisplayTerms)districtSearch.getDisplayTerms();
%>

<liferay-ui:search-toggle displayTerms="<%=displayTerms%>" id="toogle_id_nation" >
	<table cellspacing="0" width="100%">
		<tr>
			<td align="right" width="3%">
				<liferay-ui:message key="code."/>&nbsp;:
			</td>
			
		 	<td width="15%">
				<input name="<portlet:namespace/><%=displayTerms.MA %>" style="width: 95%" type="text" value="<%= HtmlUtil.escape(displayTerms.getMa()) %>" />
			</td>
			
			<td align="right" width="4%">
				<liferay-ui:message key="name."/>&nbsp;:
			</td>
			
			<td width="25%">
				<input name="<portlet:namespace/><%=displayTerms.TEN %>" style="width: 95%" type="text" value="<%= HtmlUtil.escape(displayTerms.getTen()) %>" />
			</td>
			
			<td align="right" width="5%">
				<liferay-ui:message key="description."/>&nbsp;:
			</td>
			
			<td>
				<input name="<portlet:namespace/><%=displayTerms.MOTA %>" style="width: 98%" type="text" value="<%= HtmlUtil.escape(displayTerms.getMota()) %>" />
			</td>
		</tr>
		
				
	</table>	
</liferay-ui:search-toggle>
<br/>
<input type="submit" name="<portlet:namespace/>search" value="<liferay-ui:message key="search"/>"/>