<%@ include file="/html/portlet/nss/link/init.jsp" %>
<%@page import="com.nss.portlet.link.search.LienKetWebsiteSearch"%>
<%@page import="com.nss.portlet.link.search.LienKetWebsiteDisplayTerms"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%
	LienKetWebsiteSearch searchContainer = (LienKetWebsiteSearch)request.getAttribute("liferay-ui:search:searchContainer");
	LienKetWebsiteDisplayTerms displayTerms = (LienKetWebsiteDisplayTerms)searchContainer.getDisplayTerms();
%>

<liferay-ui:search-toggle displayTerms="<%=displayTerms%>" id="toogle_id_loaivanban" >
<table cellspacing="0" width="100%">
		<tr>
			<td width="15%">
				<liferay-ui:message key="ten-website"/>:&nbsp;
			</td>
			
		 	<td  width="20%">
				<input name="<portlet:namespace/><%=LienKetWebsiteDisplayTerms.TEN_WEBSITE%>" style="width: 90%;" type="text" value="<%= HtmlUtil.escape(displayTerms.getTenWebsite()) %>" />
			</td>
			
			<td  width="10%">
				<liferay-ui:message key="description"/>:&nbsp;
			</td>
			
			<td >
				<input name="<portlet:namespace/><%=LienKetWebsiteDisplayTerms.MO_TA %>" style="width: 90%;" type="text" value="<%= HtmlUtil.escape(displayTerms.getMoTa()) %>" />
			</td>
		</tr>
		
	</table>	
</liferay-ui:search-toggle>
<br/>
<input type="submit" class="button-width" name="<portlet:namespace/>search" value="<liferay-ui:message key="search"/>"/>
