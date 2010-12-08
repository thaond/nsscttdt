<%@ include file="/html/portlet/nss/necessary_info/init.jsp" %>

<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.nss.portlet.necessary_info.search.ThongTinCanThietSearch"%>
<%@page import="com.nss.portlet.necessary_info.search.ThongTinCanThietDisplayTerms"%>

<%
	ThongTinCanThietSearch searchContainer = (ThongTinCanThietSearch)request.getAttribute("liferay-ui:search:searchContainer");
	ThongTinCanThietDisplayTerms displayTerms = (ThongTinCanThietDisplayTerms)searchContainer.getDisplayTerms();
%>

<liferay-ui:search-toggle displayTerms="<%=displayTerms%>" id="toogle_id_thongtinlienquan" >

	<table width="100%" cellspacing="0">
		<tr>
			<td width="20%">
				<liferay-ui:message key="ten-thong-tin-can-thiet"/>:&nbsp;
			</td>
			
		 	<td width="25%">
				<input name="<portlet:namespace/><%=ThongTinCanThietDisplayTerms.TEN_THONG_TIN_CAN_THIET %>" style="width: 90%" type="text" value="<%= HtmlUtil.escape(displayTerms.getTenThongTinCanThiet()) %>" />
			</td>
			
			<td width="10%">
				<liferay-ui:message key="description"/>:&nbsp;
			</td>
			
			<td>
				<input name="<portlet:namespace/><%=ThongTinCanThietDisplayTerms.MO_TA %>" style="width: 90%" type="text" value="<%= HtmlUtil.escape(displayTerms.getMoTa()) %>" />
			</td>
		</tr>
		
	</table>	
</liferay-ui:search-toggle>
<br>
<input type="submit" class="button-width" name="<portlet:namespace/>search" value="<liferay-ui:message key="search"/>"/>
