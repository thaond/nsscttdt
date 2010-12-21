<%@ include file="/html/portlet/nss/generatetemplateid/init.jsp" %>

<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>

<%@page import="com.nss.portlet.generatetemplateid.search.GenerateTemplateIdDisplayTerms"%>
<%@page import="com.nss.portlet.generatetemplateid.search.GenerateTemplateIdSearch"%>
<%
	GenerateTemplateIdSearch generateTemplateIdSearch = (GenerateTemplateIdSearch)request.getAttribute("liferay-ui:search:searchContainer");
	GenerateTemplateIdDisplayTerms displayTerms = (GenerateTemplateIdDisplayTerms)generateTemplateIdSearch.getDisplayTerms();
%>

<liferay-ui:search-toggle displayTerms="<%=displayTerms%>" id="toogle_id_idtemplate" >
	<table class="idtemplate-table" cellspacing="0">
		<tr>
			<td align="right">
				<liferay-ui:message key="dinh-dang"/>:
			</td>
			<td>
				<input name="<portlet:namespace/><%=GenerateTemplateIdDisplayTerms.DINHDANG %>" type="text" value="<%= HtmlUtil.escape(displayTerms.getDinhDang()) %>" />
			</td>
			<td align="right">
				<liferay-ui:message key="description"/>:
			</td>
			
			<td>
				<input name="<portlet:namespace/><%=GenerateTemplateIdDisplayTerms.MOTA %>" type="text" value="<%= HtmlUtil.escape(displayTerms.getMoTa()) %>" />
			</td>
		</tr>
	</table>	
</liferay-ui:search-toggle>
<br/>
<input type="submit" name="<portlet:namespace/>search" value="<liferay-ui:message key="search"/>"/>