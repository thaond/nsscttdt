<%@ include file="/html/portlet/nss/nss_don_vi_thu_tuc/init.jsp" %>

<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>

<%@page import="com.nss.portlet.nss_don_vi_thu_tuc.search.DonViThuTucSearch"%>
<%@page import="com.nss.portlet.nss_don_vi_thu_tuc.search.DonViThuTucDisplayTerms"%>

<%
	DonViThuTucSearch searchContainer = (DonViThuTucSearch)request.getAttribute("liferay-ui:search:searchContainer");
	DonViThuTucDisplayTerms displayTerms = (DonViThuTucDisplayTerms)searchContainer.getDisplayTerms();
%>

<liferay-ui:search-toggle displayTerms="<%=displayTerms%>" id="toogle_id_donvithutuc" >
<table cellspacing="0" width="100%">
		<tr>
			<td width="15%">
				<liferay-ui:message key="ten-don-vi-thu-tuc"/>:&nbsp;
			</td>
			
		 	<td width="20%">
				<input name="<portlet:namespace/><%=DonViThuTucDisplayTerms.TEN_DON_VI_THU_TUC %>" style="width: 90%;" type="text" value="<%= HtmlUtil.escape(displayTerms.getTenDonViThuTuc()) %>" />
			</td>
			<td width="10%">
				<liferay-ui:message key="description"/>:&nbsp;
			</td>
			
			<td >
				<input name="<portlet:namespace/><%=DonViThuTucDisplayTerms.MO_TA %>" style="width: 90%;" type="text" value="<%= HtmlUtil.escape(displayTerms.getMoTa()) %>" />
			</td>
		</tr>
	</table>	
</liferay-ui:search-toggle>
<br/>
<input type="submit" class="button-width" name="<portlet:namespace/>search" value="<liferay-ui:message key="search"/>"/>
