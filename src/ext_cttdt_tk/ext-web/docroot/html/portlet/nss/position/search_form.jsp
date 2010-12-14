<%@ include file="/html/portlet/nss/position/init.jsp" %>

<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.nss.portlet.position.search.PositionSearch"%>
<%@page import="com.nss.portlet.position.search.PositionDisplayTerms"%>

<%
	PositionSearch positionSearch = (PositionSearch) request.getAttribute("liferay-ui:search:searchContainer");
	PositionDisplayTerms displayTerms = (PositionDisplayTerms) positionSearch.getDisplayTerms();
%>

<liferay-ui:search-toggle displayTerms="<%= displayTerms %>" id="toogle_id_position" >
	<table cellspacing="0" width="100%">
		<tr>
			<td width="3%" align="right"><liferay-ui:message key="code." />:&nbsp;</td>
			<td  width="12%">
				<input name="<portlet:namespace/><%=PositionDisplayTerms.MA %>" type="text" value="<%= HtmlUtil.escape(displayTerms.getMa()) %>" />
			</td>
			
			<td width="3%" align="right"><liferay-ui:message key="name." />:&nbsp;</td>
			<td  width="12%">
				<input name="<portlet:namespace/><%=PositionDisplayTerms.TEN %>" type="text" value="<%= HtmlUtil.escape(displayTerms.getTen()) %>" />
			</td>
			
			<td  width="10%"align="right" ><liferay-ui:message key="description" />:&nbsp;</td>
			<td>
				<input name="<portlet:namespace/><%=PositionDisplayTerms.MOTA %>" type="text" value="<%= HtmlUtil.escape(displayTerms.getMoTa()) %>" />
			</td>
			
		</tr>
		
	</table>	
</liferay-ui:search-toggle>
<br/>
<input class="button-width" type="submit" name="<portlet:namespace/>search" value="<liferay-ui:message key="search"/>"/>



