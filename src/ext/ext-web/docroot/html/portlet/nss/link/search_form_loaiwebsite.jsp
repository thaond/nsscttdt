<%@ include file="/html/portlet/nss/link/init.jsp" %>

<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>

<%@page import="com.nss.portlet.link.searchLoaiWebsite.LoaiWebsiteSearch"%>
<%@page import="com.nss.portlet.link.searchLoaiWebsite.LoaiWebsiteDisplayTerms"%>

<%
	LoaiWebsiteSearch loaiWebsiteSearch = (LoaiWebsiteSearch)request.getAttribute("liferay-ui:search:searchContainer");
	LoaiWebsiteDisplayTerms loaiWebsiteDisplayTerms = (LoaiWebsiteDisplayTerms)loaiWebsiteSearch.getDisplayTerms();
%>

<liferay-ui:search-toggle displayTerms="<%=loaiWebsiteDisplayTerms%>" id="toogle_id_loaivanban" >

	<table class="loaivanban-table">
		<tr>
			<td align="right">
				<liferay-ui:message key="ten-loai-website"/>:&nbsp;
			</td>
			
		 	<td align="left">
				<input name="<portlet:namespace/><%=loaiWebsiteDisplayTerms.TEN_LOAI_WEBSITE%>" size="20" type="text" value="<%= HtmlUtil.escape(loaiWebsiteDisplayTerms.getTenLoaiWebsite()) %>" />
			</td>
			
			<td align="right">
				<liferay-ui:message key="description"/>:&nbsp;
			</td>
			
			<td align="left">
				<input name="<portlet:namespace/><%=loaiWebsiteDisplayTerms.MO_TA_LOAI %>" size="20" type="text" value="<%= HtmlUtil.escape(loaiWebsiteDisplayTerms.getMoTaLoai()) %>" />
			</td>
		</tr>
		
	</table>	
</liferay-ui:search-toggle>
<br/>
	&nbsp;&nbsp;&nbsp;<input type="submit" class="button-width" name="<portlet:namespace/>searchLoaiWebsite" value="<liferay-ui:message key="search"/>"/>
