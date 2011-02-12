<%@ include file="/html/portlet/ext/organizationexternal/init.jsp" %>

<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>

<%
	OrganizationExternalSearch externalSearch = (OrganizationExternalSearch)request.getAttribute("liferay-ui:search:searchContainer");
	OrganizationExternalDisplayTerms displayTerms = (OrganizationExternalDisplayTerms)externalSearch.getDisplayTerms();
%>

<liferay-ui:search-toggle displayTerms="<%= displayTerms %>" id="toogle_id_orgexternal" >
	<table width="100%" cellspacing="0">
  		<tr>
   			<td width="10%" >
				<liferay-ui:message key="ma-to-chuc"/>&nbsp;:
			</td>
			
		 	<td width="40%">
				<input name="<portlet:namespace/><%= OrganizationExternalDisplayTerms.MA %>" style="width: 90%" type="text" 
						value="<%= HtmlUtil.escape(displayTerms.getMa()) %>" />
			</td>
			
			<td width="10%" >
				<liferay-ui:message key="ten-to-chuc"/>&nbsp;:
			</td>
			
			<td >
				<input name="<portlet:namespace/><%= OrganizationExternalDisplayTerms.TEN %>" style="width: 90%" type="text" 
						value="<%= HtmlUtil.escape(displayTerms.getTen()) %>" />
			</td>
		</tr>
		
	</table>	
</liferay-ui:search-toggle>
<br/>
<input type="submit" name="<portlet:namespace/>search" value="<liferay-ui:message key="search"/>"/>
