<%@ include file="/html/portlet/nss/link/init.jsp" %>

<%@page import="com.nss.portlet.link.search.LienKetWebsiteSearch"%>
<%@page import="com.nss.portlet.link.search.LienKetWebsiteDisplayTerms"%>

<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>

<%
	LienKetWebsiteSearch searchContainer = (LienKetWebsiteSearch)request.getAttribute("liferay-ui:search:searchContainer");
	LienKetWebsiteDisplayTerms displayTerms = (LienKetWebsiteDisplayTerms)searchContainer.getDisplayTerms();
%>

<liferay-ui:search-toggle displayTerms="<%=displayTerms%>" id="toogle_id_loaivanban" >

	<table class="loaivanban-table">
		<tr>
			<td align="right">
				<liferay-ui:message key="ten-website"/>:&nbsp;
			</td>
			
		 	<td align="left">
				<input name="<portlet:namespace/><%=LienKetWebsiteDisplayTerms.TEN_WEBSITE%>" size="20" type="text" value="<%= HtmlUtil.escape(displayTerms.getTenWebsite()) %>" />
			</td>
			
			<td align="right">
				<liferay-ui:message key="description"/>:&nbsp;
			</td>
			
			<td align="left">
				<input name="<portlet:namespace/><%=LienKetWebsiteDisplayTerms.MO_TA %>" size="20" type="text" value="<%= HtmlUtil.escape(displayTerms.getMoTa()) %>" />
			</td>
		</tr>
		
	</table>	
</liferay-ui:search-toggle>
<br/>
	&nbsp;&nbsp;&nbsp;<input type="submit" class="button-width" name="<portlet:namespace/>search" value="<liferay-ui:message key="search"/>"/>
