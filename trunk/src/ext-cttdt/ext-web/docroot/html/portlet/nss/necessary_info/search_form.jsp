<%@ include file="/html/portlet/nss/necessary_info/init.jsp" %>

<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.nss.portlet.necessary_info.search.ThongTinCanThietSearch"%>
<%@page import="com.nss.portlet.necessary_info.search.ThongTinCanThietDisplayTerms"%>

<%
	ThongTinCanThietSearch searchContainer = (ThongTinCanThietSearch)request.getAttribute("liferay-ui:search:searchContainer");
	ThongTinCanThietDisplayTerms displayTerms = (ThongTinCanThietDisplayTerms)searchContainer.getDisplayTerms();
%>

<liferay-ui:search-toggle displayTerms="<%=displayTerms%>" id="toogle_id_thongtinlienquan" >

	<table class="thongtinlienquan-table">
		<tr>
			<td align="right">
				<liferay-ui:message key="ten-thong-tin-can-thiet"/>:&nbsp;
			</td>
			
		 	<td align="left">
				<input name="<portlet:namespace/><%=ThongTinCanThietDisplayTerms.TEN_THONG_TIN_CAN_THIET %>" size="20" type="text" value="<%= HtmlUtil.escape(displayTerms.getTenThongTinCanThiet()) %>" />
			</td>
			
			<td align="right">
				<liferay-ui:message key="description"/>:&nbsp;
			</td>
			
			<td align="left">
				<input name="<portlet:namespace/><%=ThongTinCanThietDisplayTerms.MO_TA %>" size="20" type="text" value="<%= HtmlUtil.escape(displayTerms.getMoTa()) %>" />
			</td>
		</tr>
		
	</table>	
</liferay-ui:search-toggle>
<br/>
	&nbsp;&nbsp;&nbsp;<input type="submit" class="button-width" name="<portlet:namespace/>search" value="<liferay-ui:message key="search"/>"/>
