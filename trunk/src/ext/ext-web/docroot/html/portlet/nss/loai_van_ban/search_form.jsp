<%@ include file="/html/portlet/nss/loai_van_ban/init.jsp" %>

<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.nss.portlet.loai_van_ban.search.LoaiVanBanSearch"%>
<%@page import="com.nss.portlet.loai_van_ban.search.LoaiVanBanDisplayTerms"%>

<%
	LoaiVanBanSearch searchContainer = (LoaiVanBanSearch)request.getAttribute("liferay-ui:search:searchContainer");
	LoaiVanBanDisplayTerms displayTerms = (LoaiVanBanDisplayTerms)searchContainer.getDisplayTerms();
%>

<liferay-ui:search-toggle displayTerms="<%=displayTerms%>" id="toogle_id_loaivanban" >

	<table class="loaivanban-table">
		<tr>
			<td align="right">
				<liferay-ui:message key="ten-loai-van-ban"/>:&nbsp;
			</td>
			
		 	<td align="left">
				<input name="<portlet:namespace/><%=displayTerms.TEN_LOAI_VB %>" size="20" type="text" value="<%= HtmlUtil.escape(displayTerms.getTenLoaiVanBan()) %>" />
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
