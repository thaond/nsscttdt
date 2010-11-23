<%@ include file="/html/portlet/nss/adv/init.jsp" %>

<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.nss.portlet.adv.search.QuangCaoSearch"%>
<%@page import="com.nss.portlet.adv.search.QuangCaoDisplayTerms"%>

<%
	QuangCaoSearch searchContainer = (QuangCaoSearch)request.getAttribute("liferay-ui:search:searchContainer");
	QuangCaoDisplayTerms displayTerms = (QuangCaoDisplayTerms)searchContainer.getDisplayTerms();
%>

<liferay-ui:search-toggle displayTerms="<%=displayTerms%>" id="toogle_id_quangcao" >

	<table class="quangcao-table">
		<tr>
			<td align="right">
				<liferay-ui:message key="ten-quang-cao"/>:&nbsp;
			</td>
			
		 	<td align="left">
				<input name="<portlet:namespace/><%=displayTerms.TEN_QUANG_CAO %>" size="20" type="text" value="<%= HtmlUtil.escape(displayTerms.getTenQuangCao()) %>" />
			</td>
			
			<td align="right">
				<liferay-ui:message key="description"/>:&nbsp;
			</td>
			
			<td align="left">
				<input name="<portlet:namespace/><%=displayTerms.MO_TA %>" size="20" type="text" value="<%= HtmlUtil.escape(displayTerms.getMoTa()) %>" />
			</td>
		</tr>
		
	</table>	
</liferay-ui:search-toggle>
<br/>
	&nbsp;&nbsp;&nbsp;<input type="submit" class="button-width" name="<portlet:namespace/>search" value="<liferay-ui:message key="search"/>"/>
