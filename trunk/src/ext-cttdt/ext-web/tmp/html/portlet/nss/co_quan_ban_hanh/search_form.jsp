<%@ include file="/html/portlet/nss/co_quan_ban_hanh/init.jsp" %>

<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.nss.portlet.co_quan_ban_hanh.search.CoQuanBanHanhSearch"%>
<%@page import="com.nss.portlet.co_quan_ban_hanh.search.CoQuanBanHanhDisplayTerms"%>

<%
	CoQuanBanHanhSearch searchContainer = (CoQuanBanHanhSearch)request.getAttribute("liferay-ui:search:searchContainer");
	CoQuanBanHanhDisplayTerms displayTerms = (CoQuanBanHanhDisplayTerms)searchContainer.getDisplayTerms();
%>


<liferay-ui:search-toggle displayTerms="<%=displayTerms%>" id="toogle_id_coquanbanhanh" >

	<table class="coquanbanhanh-table">
		<tr>
			<td align="right">
				<liferay-ui:message key="ten-co-quan-ban-hanh"/>:&nbsp;
			</td>
			
		 	<td align="left">
				<input name="<portlet:namespace/><%=CoQuanBanHanhDisplayTerms.TEN_CO_QUAN_BAN_HANH %>" size="20" type="text" value="<%= HtmlUtil.escape(displayTerms.getTenCoQuanBanHanh()) %>" />
			</td>
			
			<td align="right">
				<liferay-ui:message key="description"/>:&nbsp;
			</td>
			
			<td align="left">
				<input name="<portlet:namespace/><%=CoQuanBanHanhDisplayTerms.MO_TA %>" size="20" type="text" value="<%= HtmlUtil.escape(displayTerms.getMoTa()) %>" />
			</td>
		</tr>
		
	</table>	
</liferay-ui:search-toggle>
<br/>
	&nbsp;&nbsp;&nbsp;<input type="submit" class="button-width" name="<portlet:namespace/>search" value="<liferay-ui:message key="search"/>"/>
