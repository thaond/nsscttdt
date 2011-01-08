<%@ include file="/html/portlet/ext/documentrecordtype/init.jsp" %>

<%@page import="javax.portlet.PortletURL"%>


<%@page import="com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType"%>
<%@page import="com.sgs.portlet.documentrecordtype.search.PmlEdmDocumentRecordTypeSearch"%>
<%@page import="com.sgs.portlet.documentrecordtype.search.PmlEdmDocumentRecordTypeDisplayTerms"%>

<%
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action", "/sgs/documentrecordtype/view");
%>


<script type="text/javascript">
	function searchPmlEdmDocumentRecordType(url) {		
		document.<portlet:namespace />fm.method = "post";
		submitForm(document.<portlet:namespace />fm, url);
	
	}
</script>

<%
	PmlEdmDocumentRecordTypeSearch documentRecordTypeSearch = (PmlEdmDocumentRecordTypeSearch) request.getAttribute("liferay-ui:search:searchContainer");
	PmlEdmDocumentRecordTypeDisplayTerms displayTerms = (PmlEdmDocumentRecordTypeDisplayTerms) documentRecordTypeSearch.getDisplayTerms();
%>

<liferay-ui:search-toggle displayTerms="<%= displayTerms %>" id="toogle_id_pmledmdocumentRecordtype" >
	<table cellspacing="0" width="100%">
		<tr>
			<td width="8%"><label><liferay-ui:message key="recordtype.code" />:&nbsp;</label></td>
			<td width="25%">
				<input name="<portlet:namespace/><%=PmlEdmDocumentRecordTypeDisplayTerms.PMLEDMDOCUMENTRECORDTYPE_CODE %>" style="width: 90%" type="text" value="<%= HtmlUtil.escape(displayTerms.getPmlEdmDocumentRecordTypeCode()) %>" />
			</td>
			
			<td width="15%"><label><liferay-ui:message key="ten-loai-so-cong-van" />:&nbsp;</label></td>
			<td >
				<input name="<portlet:namespace/><%=PmlEdmDocumentRecordTypeDisplayTerms.PMLEDMDOCUMENTRECORDTYPE_NAME %>" style="width: 90%" type="text" value="<%= HtmlUtil.escape(displayTerms.getPmlEdmDocumentRecordTypeName()) %>" />
			</td>
		</tr>
		
	</table>	
</liferay-ui:search-toggle>
<br/>
<input type="button" class="button-width" onclick="searchPmlEdmDocumentRecordType('<%= portletURL.toString()  %>')" name="<portlet:namespace/>search" value="<liferay-ui:message key="search"/>"/>
