<%@ include file="/html/portlet/nss/partner/init.jsp" %>

<%@page import="com.nss.portlet.partner.search.PartnerSearch"%>
<%@page import="com.nss.portlet.partner.search.PartnerDisplayTerms"%>

<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>

<%
	PartnerSearch searchContainer = (PartnerSearch)request.getAttribute("liferay-ui:search:searchContainer");
	PartnerDisplayTerms displayTerms = (PartnerDisplayTerms)searchContainer.getDisplayTerms();
%>

<liferay-ui:search-toggle displayTerms="<%= displayTerms %>" id="toogle_id_loaivanban" >

	<table class="loaivanban-table">
		<tr>
			<td align="right">
				<liferay-ui:message key="ten-partner"/>:&nbsp;&nbsp;
			</td>
			
		 	<td align="left">
				<input name="<portlet:namespace/><%= PartnerDisplayTerms.TEN_PARTNER %>" size="30" type="text" value="<%= HtmlUtil.escape(displayTerms.getTenPartner()) %>" />
			</td>
			
			<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
			
			<td colspan="2" align="right">
				<liferay-ui:message key="description"/>:&nbsp;&nbsp;
			</td>
			
			<td align="left">
				<input name="<portlet:namespace/><%= PartnerDisplayTerms.MO_TA_PARTNER %>" size="30" type="text" value="<%= HtmlUtil.escape(displayTerms.getMoTaPartner()) %>" />
			</td>
		</tr>
		
	</table>	
</liferay-ui:search-toggle>
<br/>
	&nbsp;&nbsp;&nbsp;<input type="submit" class="button-width" name="<portlet:namespace/>search" value="<liferay-ui:message key="search"/>"/>
