<%@ include file="/html/portlet/nss/nss_don_vi_thu_tuc/init.jsp" %>

<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>

<%@page import="com.nss.portlet.nss_don_vi_thu_tuc.search.DonViThuTucSearch"%>
<%@page import="com.nss.portlet.nss_don_vi_thu_tuc.search.DonViThuTucDisplayTerms"%>

<%
	DonViThuTucSearch searchContainer = (DonViThuTucSearch)request.getAttribute("liferay-ui:search:searchContainer");
	DonViThuTucDisplayTerms displayTerms = (DonViThuTucDisplayTerms)searchContainer.getDisplayTerms();
%>

<liferay-ui:search-toggle displayTerms="<%=displayTerms%>" id="toogle_id_donvithutuc" >

	<table class="donvithutuc-table">
		<tr>
			<td align="right">
				<liferay-ui:message key="ten-don-vi-thu-tuc"/>:&nbsp;
			</td>
			
		 	<td align="left">
				<input name="<portlet:namespace/><%=displayTerms.TEN_DON_VI_THU_TUC %>" size="20" type="text" value="<%= HtmlUtil.escape(displayTerms.getTenDonViThuTuc()) %>" />
			</td>
			
			<td width="30px"></td>
			
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
