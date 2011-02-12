<%@ include file="/html/portlet/ext/issuingplace/init.jsp" %>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.sgs.portlet.issuingplace.search.IssuingPlaceSearch"%>
<%@page import="com.sgs.portlet.issuingplace.search.IssuingPlaceDisplayTerms"%>

<%
	IssuingPlaceSearch issuingPlaceSearch = (IssuingPlaceSearch)request.getAttribute("liferay-ui:search:searchContainer");
	IssuingPlaceDisplayTerms displayTerms = (IssuingPlaceDisplayTerms)issuingPlaceSearch.getDisplayTerms();
%>

<liferay-ui:search-toggle displayTerms="<%=displayTerms%>" id="toogle_id_issuing" >
	<table class="issuing-table" width="100%" cellspacing="0">
		<tr>
		 	<td width="8%"><liferay-ui:message key="recordtype.code"/>&nbsp;:</td>
		 	<td width="25%">
				<input name="<portlet:namespace/><%=IssuingPlaceDisplayTerms.MA %>" style="width: 90%" type="text" value="<%= HtmlUtil.escape(displayTerms.getCode()) %>" />
			</td>
			<td width="15%" >
				<liferay-ui:message key="issuing-place-ten-don-vi-lien-quan"/>&nbsp;:
			</td>
			<td>
				<input name="<portlet:namespace/><%=IssuingPlaceDisplayTerms.NAME %>" style="width: 95%" type="text" value="<%= HtmlUtil.escape(displayTerms.getName()) %>" />
			</td>
		</tr>
</table>	
</liferay-ui:search-toggle>
<br/>
<input type="submit" name="<portlet:namespace/>search" value="<liferay-ui:message key="search"/>"/>
