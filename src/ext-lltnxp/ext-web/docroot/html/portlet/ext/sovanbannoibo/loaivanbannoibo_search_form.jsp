<%@ include file="/html/portlet/ext/sovanbannoibo/init.jsp"%>
<%@page import="com.sgs.portlet.sovanbannoibo.search.LoaiVanBanNoiBoDisplayTerms"%>
<%@page import="com.sgs.portlet.sovanbannoibo.search.LoaiVanBanNoiBoSearch"%>

<%
	LoaiVanBanNoiBoSearch loaivanbannoiboSearch = (LoaiVanBanNoiBoSearch) request.getAttribute("liferay-ui:search:searchContainer");
	LoaiVanBanNoiBoDisplayTerms displayTerms = (LoaiVanBanNoiBoDisplayTerms) loaivanbannoiboSearch.getDisplayTerms();
%>

<liferay-ui:search-toggle displayTerms="<%= displayTerms %>" id="toogle_id_loaivanbannoibo">
	<table cellspacing="0" width="100%">
		<tr>
			<td width="20%"><liferay-ui:message key="ky-hieu-loai-van-ban-noi-bo" />&nbsp;:</td>
			<td><input name="<portlet:namespace/><%=LoaiVanBanNoiBoDisplayTerms.KYHIEULOAIVANBANNOIBO%>"
				style="width: 80%" type="text" value="<%=HtmlUtil.escape(displayTerms.getKyHieuLoaiVanBanNoiBo())%>" />
			</td>
	
			<td><liferay-ui:message key="ten-loai-van-ban-noi-bo" />&nbsp;:</td>
			<td><input name="<portlet:namespace/><%=LoaiVanBanNoiBoDisplayTerms.TENLOAIVANBANNOIBO%>"
				style="width: 80%" type="text" value="<%=HtmlUtil.escape(displayTerms.getTenLoaiVanBanNoiBo())%>" />
			</td>
		</tr>
	</table>
</liferay-ui:search-toggle>

<br>
<input type="submit" style="margin-left: 20%" name="<portlet:namespace/>search" value="<liferay-ui:message key="search"/>" />
	
