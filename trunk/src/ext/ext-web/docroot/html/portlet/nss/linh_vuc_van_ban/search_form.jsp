<%@ include file="/html/portlet/nss/linh_vuc_van_ban/init.jsp" %>

<%@page import="com.nss.portlet.linh_vuc_van_ban.search.LinhVucVanBanDisplayTerms"%>
<%@page import="com.nss.portlet.linh_vuc_van_ban.search.LinhVucVanBanSearch"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>

<%
	LinhVucVanBanSearch searchContainer = (LinhVucVanBanSearch)request.getAttribute("liferay-ui:search:searchContainer");
	LinhVucVanBanDisplayTerms displayTerms = (LinhVucVanBanDisplayTerms)searchContainer.getDisplayTerms();
%>


<liferay-ui:search-toggle displayTerms="<%=displayTerms%>" id="toogle_id_linhvucvanban" >
	<table class="linhvucvanban-table">
		<tr>
			<td align="right">
				<liferay-ui:message key="ten-linh-vuc-van-ban"/>:&nbsp;
			</td>
			
		 	<td align="left">
				<input name="<portlet:namespace/><%=LinhVucVanBanDisplayTerms.TEN_LINH_VUC_VB %>" size="20" type="text" value="<%= HtmlUtil.escape(displayTerms.getTenLinhVucVanBan()) %>" />
			</td>
			
			<td align="right">
				<liferay-ui:message key="description"/>:&nbsp;
			</td>
			
			<td align="left">
				<input name="<portlet:namespace/><%=LinhVucVanBanDisplayTerms.MO_TA %>" size="20" type="text" value="<%= HtmlUtil.escape(displayTerms.getMoTa()) %>" />
			</td>
		</tr>
		
	</table>	
</liferay-ui:search-toggle>
<br/>
	&nbsp;&nbsp;&nbsp;<input type="submit" class="button-width" name="<portlet:namespace/>search" value="<liferay-ui:message key="search"/>"/>
