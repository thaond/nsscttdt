<%@ include file="/html/portlet/nss/link/init.jsp" %>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.nss.portlet.link.searchLoaiWebsite.LoaiWebsiteSearch"%>
<%@page import="com.nss.portlet.link.searchLoaiWebsite.LoaiWebsiteDisplayTerms"%>
<%
	LoaiWebsiteSearch loaiWebsiteSearch = (LoaiWebsiteSearch)request.getAttribute("liferay-ui:search:searchContainer");
	LoaiWebsiteDisplayTerms loaiWebsiteDisplayTerms = (LoaiWebsiteDisplayTerms)loaiWebsiteSearch.getDisplayTerms();
%>

<liferay-ui:search-toggle displayTerms="<%=loaiWebsiteDisplayTerms%>" id="toogle_id_loaivanban" >
<table cellspacing="0" width="100%">
		<tr>
			<td width="15%">
				<liferay-ui:message key="ten-loai-website"/>:&nbsp;
			</td>
			
		 	<td width="20%">
				<input name="<portlet:namespace/><%=LoaiWebsiteDisplayTerms.TEN_LOAI_WEBSITE%>" style="width: 90%;" type="text" value="<%= HtmlUtil.escape(loaiWebsiteDisplayTerms.getTenLoaiWebsite()) %>" />
			</td>
			
			<td width="10%">
				<liferay-ui:message key="description"/>:&nbsp;
			</td>
			
			<td >
				<input name="<portlet:namespace/><%=LoaiWebsiteDisplayTerms.MO_TA_LOAI %>" style="width: 90%;" type="text" value="<%= HtmlUtil.escape(loaiWebsiteDisplayTerms.getMoTaLoai()) %>" />
			</td>
		</tr>
	</table>	
</liferay-ui:search-toggle>
<br>
<input type="submit" class="button-width" name="<portlet:namespace/>searchLoaiWebsite" value="<liferay-ui:message key="search"/>"/>
