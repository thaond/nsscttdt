<%@ include file="/html/portlet/ext/generatetemplateid/init.jsp" %>

<%@page import="com.sgs.portlet.generatetemplateid.search.GenerateTemplateIdDisplayTerms"%>
<%@page import="com.sgs.portlet.generatetemplateid.search.GenerateTemplateIdSearch"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%
	GenerateTemplateIdSearch generateTemplateIdSearch = (GenerateTemplateIdSearch)request.getAttribute("liferay-ui:search:searchContainer");
	GenerateTemplateIdDisplayTerms displayTerms = (GenerateTemplateIdDisplayTerms)generateTemplateIdSearch.getDisplayTerms();
%>

<liferay-ui:search-toggle displayTerms="<%=displayTerms%>" id="toogle_id_idtemplate" >
	<table class="idtemplate-table" cellspacing="0">
		<tr>
			<td width="8%" align="right">
				<liferay-ui:message key="format."/>:
			</td>
			<td width="15%">
				<input name="<portlet:namespace/><%=GenerateTemplateIdDisplayTerms.DINHDANG %>" style="width: 90%" type="text" value="<%= HtmlUtil.escape(displayTerms.getDinhDang()) %>" />
			</td>
			<td width="5%" align="right">
				<liferay-ui:message key="description."/>:
			</td>
			
			<td>
				<input name="<portlet:namespace/><%=GenerateTemplateIdDisplayTerms.MOTA %>" style="width: 90%" type="text" value="<%= HtmlUtil.escape(displayTerms.getMoTa()) %>" />
			</td>
		</tr>
	</table>	
</liferay-ui:search-toggle>
<br/>
<input type="submit" name="<portlet:namespace/>search" value="<liferay-ui:message key="search"/>"/>