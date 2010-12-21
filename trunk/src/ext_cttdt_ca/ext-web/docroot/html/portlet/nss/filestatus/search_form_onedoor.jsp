<%@ include file="/html/portlet/nss/filestatus/init.jsp" %>
<%@page import="com.nss.portlet.filestatus.search.PmlFileStatusSearch"%>
<%@page import="com.nss.portlet.filestatus.search.PmlFileStatusDisplayTerms"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>

<%
	PmlFileStatusSearch searchContainerOnedoor = (PmlFileStatusSearch)request.getAttribute("liferay-ui:search:searchContainer");
	PmlFileStatusDisplayTerms displayTermsOnedoor = (PmlFileStatusDisplayTerms)searchContainerOnedoor.getDisplayTerms();
%>

<liferay-ui:search-toggle displayTerms="<%=displayTermsOnedoor%>" id="toogle_id_pmlFileStatus_search" >
	<table width="100%" cellspacing="0">
		<tr>
			<td width="11%" align="right">
				<liferay-ui:message key="ma-trang-thai"/>&nbsp;:
			</td>
			<td width="15%">
				<input name="<portlet:namespace/><%=PmlFileStatusDisplayTerms.FILESTATUS_CODE %>" style="width: 90%" type="text" value="<%= HtmlUtil.escape(displayTermsOnedoor.getFilestatuscode()) %>" />
			</td>
			
			<td align="right" width="12%">
				<liferay-ui:message key="ten-trang-thai"/>&nbsp;:
			</td>
			<td >
				<input name="<portlet:namespace/><%=PmlFileStatusDisplayTerms.FILESTATUS_NAME %>" style="width: 98%" type="text" value="<%= HtmlUtil.escape(displayTermsOnedoor.getFilestatusname()) %>" />
			</td>
			
		</tr>
	</table>	
</liferay-ui:search-toggle>
<br/>
<input type="submit" name="<portlet:namespace/>search" value="<liferay-ui:message key="search"/>"/>