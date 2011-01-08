<%@ include file="/html/portlet/ext/nation/init.jsp" %>
<%@page import="com.sgs.portlet.nation.search.NationSearch"%>
<%@page import="com.sgs.portlet.nation.search.NationDisplayTerms"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%
	NationSearch nationSearch = (NationSearch)request.getAttribute("liferay-ui:search:searchContainer");
	NationDisplayTerms displayTerms = (NationDisplayTerms)nationSearch.getDisplayTerms();
%>

<liferay-ui:search-toggle displayTerms="<%=displayTerms%>" id="toogle_id_nation" >
	<table cellspacing="0" width="100%">
		<tr>
			<td width="5%">
				<liferay-ui:message key="code."/>&nbsp;:
			</td>
			
		 	<td width="15%">
				<input name="<portlet:namespace/><%=NationDisplayTerms.MA %>" style="width: 90%" type="text" value="<%= HtmlUtil.escape(displayTerms.getMa()) %>" />
			</td>
			
			<td width="5%">
				<liferay-ui:message key="name."/>&nbsp;:
			</td>
			
			<td width="15%">
				<input name="<portlet:namespace/><%=NationDisplayTerms.TEN %>" style="width: 90%" type="text" value="<%= HtmlUtil.escape(displayTerms.getTen()) %>" />
			</td>
			
			<td width="7%">
				<liferay-ui:message key="description."/>&nbsp;:
			</td>
			
			<td >
				<input name="<portlet:namespace/><%=NationDisplayTerms.MOTA %>" style="width: 90%" type="text" value="<%= HtmlUtil.escape(displayTerms.getMota()) %>" />
			</td>
		</tr>
		
				
	</table>	
</liferay-ui:search-toggle>
<br/>
<input type="submit" name="<portlet:namespace/>search" value="<liferay-ui:message key="search"/>"/>