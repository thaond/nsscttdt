<%@ include file="/html/portlet/nss/loai_van_ban/init.jsp" %>

<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.nss.portlet.loai_van_ban.search.LoaiVanBanSearch"%>
<%@page import="com.nss.portlet.loai_van_ban.search.LoaiVanBanDisplayTerms"%>

<%
	LoaiVanBanSearch searchContainer = (LoaiVanBanSearch)request.getAttribute("liferay-ui:search:searchContainer");
	LoaiVanBanDisplayTerms displayTerms = (LoaiVanBanDisplayTerms)searchContainer.getDisplayTerms();
%>

<liferay-ui:search-toggle displayTerms="<%=displayTerms%>" id="toogle_id_loaivanban" >
<table cellspacing="0" width="100%">
		<tr>
			<td width="15%">
				<liferay-ui:message key="ten-loai-van-ban"/>:&nbsp;
			</td>
		 	<td width="20%">
				<input name="<portlet:namespace/><%=LoaiVanBanDisplayTerms.TEN_LOAI_VB %>" style="width: 90%" type="text" value="<%= HtmlUtil.escape(displayTerms.getTenLoaiVanBan()) %>" />
			</td>
			<td width="8%">
				<liferay-ui:message key="description"/>:&nbsp;
			</td>
			<td>
				<input name="<portlet:namespace/><%=LoaiVanBanDisplayTerms.MO_TA %>" style="width: 90%" type="text" value="<%= HtmlUtil.escape(displayTerms.getMoTa()) %>" />
			</td>
		</tr>
</table>	
</liferay-ui:search-toggle>
<br/>
<input type="submit" class="button-width" name="<portlet:namespace/>search" value="<liferay-ui:message key="search"/>"/>
