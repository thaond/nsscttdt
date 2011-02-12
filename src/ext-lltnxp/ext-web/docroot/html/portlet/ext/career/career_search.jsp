<%@ include file="/html/portlet/ext/career/init.jsp" %>
<%@page import="com.sgs.portlet.career.search.CareerSearch"%>
<%@page import="com.sgs.portlet.career.search.CareerDisplayTerms"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>

<%
	CareerSearch careerSearch = (CareerSearch)request.getAttribute("liferay-ui:search:searchContainer");
	CareerDisplayTerms displayTerms = (CareerDisplayTerms)careerSearch.getDisplayTerms();
%>

<liferay-ui:search-toggle displayTerms="<%=displayTerms%>" id="toogle_id_career" >
	<table width="100%" cellspacing="0">
  	<tr>
   			<td width="3%" align="right">
				<liferay-ui:message key="code."/>:&nbsp;
			</td>
			
		 	<td width="15%">
				<input name="<portlet:namespace/><%=CareerDisplayTerms.MA %>" style="width: 90%" type="text" value="<%= HtmlUtil.escape(displayTerms.getMa()) %>" />
			</td>
			
			<td width="3%" align="right">
				<liferay-ui:message key="name."/>:&nbsp;
			</td>
			
			<td width="25%">
				<input name="<portlet:namespace/><%=CareerDisplayTerms.TEN %>" style="width: 90%" type="text" value="<%= HtmlUtil.escape(displayTerms.getTen()) %>" />
			</td>
			
			<td width="5%" align="right">
				<liferay-ui:message key="description."/>:&nbsp;
			</td>
			
			<td>
				<input name="<portlet:namespace/><%=CareerDisplayTerms.MOTA%>" style="width: 98%" type="text" value="<%= HtmlUtil.escape(displayTerms.getMota()) %>" />
			</td>
		</tr>
		
	</table>	
</liferay-ui:search-toggle>
<br/>
<input type="submit" name="<portlet:namespace/>search" value="<liferay-ui:message key="search"/>"/>
