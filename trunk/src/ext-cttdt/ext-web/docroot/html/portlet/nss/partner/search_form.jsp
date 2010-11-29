<%@ include file="/html/portlet/nss/partner/init.jsp" %>
<%@page import="com.nss.portlet.partner.search.PartnerSearch"%>
<%@page import="com.nss.portlet.partner.search.PartnerDisplayTerms"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>

<%
	PartnerSearch searchContainer = (PartnerSearch)request.getAttribute("liferay-ui:search:searchContainer");
	PartnerDisplayTerms displayTerms = (PartnerDisplayTerms)searchContainer.getDisplayTerms();
%>

<liferay-ui:search-toggle displayTerms="<%= displayTerms %>" id="toogle_id_loaivanban" >
<table cellspacing="0" width="100%">
		<tr>
			<td width="15%">
				<liferay-ui:message key="ten-partner"/>:&nbsp;
			</td>
			
		 	<td width="20%">
				<input name="<portlet:namespace/><%= PartnerDisplayTerms.TEN_PARTNER %>" style="width: 90%;" type="text" value="<%= HtmlUtil.escape(displayTerms.getTenPartner()) %>" />
			</td>
			<td width="10%">
				<liferay-ui:message key="description"/>:&nbsp;
			</td>
			
			<td >
				<input name="<portlet:namespace/><%= PartnerDisplayTerms.MO_TA_PARTNER %>" style="width: 90%;" type="text" value="<%= HtmlUtil.escape(displayTerms.getMoTaPartner()) %>" />
			</td>
		</tr>
	</table>	
</liferay-ui:search-toggle>
<br>
<input type="submit" class="button-width" name="<portlet:namespace/>search" value="<liferay-ui:message key="search"/>"/>
