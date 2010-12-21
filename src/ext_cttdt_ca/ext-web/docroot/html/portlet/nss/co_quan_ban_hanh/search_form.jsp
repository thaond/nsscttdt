<%@ include file="/html/portlet/nss/co_quan_ban_hanh/init.jsp" %>

<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.nss.portlet.co_quan_ban_hanh.search.CoQuanBanHanhSearch"%>
<%@page import="com.nss.portlet.co_quan_ban_hanh.search.CoQuanBanHanhDisplayTerms"%>

<%
	CoQuanBanHanhSearch searchContainer = (CoQuanBanHanhSearch)request.getAttribute("liferay-ui:search:searchContainer");
	CoQuanBanHanhDisplayTerms displayTerms = (CoQuanBanHanhDisplayTerms)searchContainer.getDisplayTerms();
%>


<liferay-ui:search-toggle displayTerms="<%=displayTerms%>" id="toogle_id_coquanbanhanh" >
<table cellspacing="0" width="100%">
		<tr>
			<td width="20%">
				<liferay-ui:message key="ten-co-quan-ban-hanh"/>:&nbsp;
			</td>
			
		 	<td width="20%">
				<input name="<portlet:namespace/><%=CoQuanBanHanhDisplayTerms.TEN_CO_QUAN_BAN_HANH %>" style="width: 90%" type="text" value="<%= HtmlUtil.escape(displayTerms.getTenCoQuanBanHanh()) %>" />
			</td>
			
			<td width="10%">
				<liferay-ui:message key="description"/>:&nbsp;
			</td>
			
			<td >
				<input name="<portlet:namespace/><%=CoQuanBanHanhDisplayTerms.MO_TA %>" style="width: 90%" type="text" value="<%= HtmlUtil.escape(displayTerms.getMoTa()) %>" />
			</td>
		</tr>
		
	</table>	
</liferay-ui:search-toggle>
<br/>
<input type="submit" class="button-width" name="<portlet:namespace/>search" value="<liferay-ui:message key="search"/>"/>
