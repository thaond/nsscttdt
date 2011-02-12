<%@ include file="/html/portlet/ext/pmledm_filestatus/init.jsp" %>
<%@page import="com.sgs.portlet.pmledm_filestatus.search.PmlFileStatusSearch"%>
<%@page import="com.sgs.portlet.pmledm_filestatus.search.PmlFileStatusDisplayTerms"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>

<%
	PmlFileStatusSearch searchContainerDocument = (PmlFileStatusSearch)request.getAttribute("liferay-ui:search:searchContainer");
	PmlFileStatusDisplayTerms displayTermsDocument = (PmlFileStatusDisplayTerms)searchContainerDocument.getDisplayTerms();
%>

<liferay-ui:search-toggle displayTerms="<%=displayTermsDocument%>" id="toogle_id_pmlFileStatus" >
	<table cellspacing="0" width="100%">
		<tr>
			<td width="11%" align="right">
				<liferay-ui:message key="ma-trang-thai"/>&nbsp;:
			</td>
			<td width="25%">
				<input name="<portlet:namespace/><%=PmlFileStatusDisplayTerms.FILESTATUS_CODE %>" style="width: 90%" type="text" value="<%= HtmlUtil.escape(displayTermsDocument.getFilestatuscode()) %>" />
			</td>
			
			<td width="11%" align="right">
				<liferay-ui:message key="ten-trang-thai"/>&nbsp;:
			</td>
			<td>
				<input name="<portlet:namespace/><%=PmlFileStatusDisplayTerms.FILESTATUS_NAME %>" style="width: 98%" type="text" value="<%= HtmlUtil.escape(displayTermsDocument.getFilestatusname()) %>" />
			</td>
		</tr>
	</table>	
</liferay-ui:search-toggle>
<br>
<input type="submit" name="<portlet:namespace/>search" value="<liferay-ui:message key="search"/>"/>