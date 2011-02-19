<%@ include file="/html/portlet/ext/sovanbannoibo/init.jsp"%>

<%@page import="com.sgs.portlet.sovanbannoibo.search.SoVanBanNoiBoDisplayTerms"%>
<%@page import="com.sgs.portlet.sovanbannoibo.search.SoVanBanNoiBoSearch"%>

<%
	SoVanBanNoiBoSearch soVanBanNoiBoSearch = (SoVanBanNoiBoSearch) request.getAttribute("liferay-ui:search:searchContainer");
	SoVanBanNoiBoDisplayTerms displayTerms = (SoVanBanNoiBoDisplayTerms) soVanBanNoiBoSearch.getDisplayTerms();
%>

<liferay-ui:search-toggle displayTerms="<%= displayTerms %>" id="toogle_id_sovanbannoibo">
	<table cellspacing="0" width="100%">
		<tr>
			<td width="20%"><liferay-ui:message key="ma-so-van-ban-noi-bo" />&nbsp;:</td>
			<td><input name="<portlet:namespace/><%=SoVanBanNoiBoDisplayTerms.MASOVANBANNOIBO%>"
				style="width: 80%" type="text" value="<%=HtmlUtil.escape(displayTerms.getMaSoVanBanNoiBo())%>" />
			</td>
	
			<td><liferay-ui:message key="ten-so-van-ban-noi-bo" />&nbsp;:</td>
			<td><input name="<portlet:namespace/><%=SoVanBanNoiBoDisplayTerms.TENSOVANBANNOIBO%>"
				style="width: 80%" type="text" value="<%=HtmlUtil.escape(displayTerms.getTenSoVanBanNoiBo())%>" />
			</td>
		</tr>
	</table>
</liferay-ui:search-toggle>

<br>
<input type="submit" style="margin-left: 20%" name="<portlet:namespace/>search" value="<liferay-ui:message key="search"/>" />
	
