<%@ include file="/html/portlet/ext/documenttype/init.jsp" %>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.sgs.portlet.documenttype.search.PmlEdmDocumentTypeSearch"%>
<%@page import="com.sgs.portlet.documenttype.search.PmlEdmDocumentTypeDisplayTerms"%>

<%
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action", "/sgs/documenttype/view");
%>


<script type="text/javascript">
	function searchPmlEdmDocumentType(url) {		
		document.<portlet:namespace />fm.method = "post";
		submitForm(document.<portlet:namespace />fm, url);
	
	}
</script>

<%
	PmlEdmDocumentTypeSearch documentTypeSearch = (PmlEdmDocumentTypeSearch) request.getAttribute("liferay-ui:search:searchContainer");
	PmlEdmDocumentTypeDisplayTerms displayTerms = (PmlEdmDocumentTypeDisplayTerms) documentTypeSearch.getDisplayTerms();
%>

<liferay-ui:search-toggle displayTerms="<%= displayTerms %>" id="toogle_id_pmledmdocumenttype" >
	<table cellspacing="0" width="100%">
	
		<tr>
			<td width="15%"><label><liferay-ui:message key="ten-loai-cong-van" />:&nbsp;</label></td>
			<td width="35%">
				<input name="<portlet:namespace/><%=PmlEdmDocumentTypeDisplayTerms.PMLEDMDOCUMENTTYPE_NAME %>" style="width: 90%" type="text" value="<%= HtmlUtil.escape(displayTerms.getPmlEdmDocumentTypeName()) %>" />
			</td>
			
			<td width="15%"><label><liferay-ui:message key="ten-loai-so-cong-van" />:&nbsp;</label></td>
			<td >
				<input name="<portlet:namespace/><%=PmlEdmDocumentTypeDisplayTerms.PMLEDMDOCUMENTTYPE_DOCUMENTRECORDTYPENAME %>" style="width: 90%" type="text" value="<%= HtmlUtil.escape(displayTerms.getPmlEdmDocumentRecordTypeName()) %>" />
			</td>
		</tr>
		
	</table>	
</liferay-ui:search-toggle>
<br/>
<input type="button" class="button-width" onclick="searchPmlEdmDocumentType('<%= portletURL.toString()  %>')" name="<portlet:namespace/>search" value="<liferay-ui:message key="search"/>"/>
