<%@ include file="/html/portlet/nss/filetype/init.jsp" %>

<%@page import="javax.portlet.PortletURL"%>

<%@page import="com.nss.portlet.filetype.search.FileTypeSearch"%>
<%@page import="com.nss.portlet.filetype.search.FileTypeDisplayTerms"%>
<%
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action", "/nss/filetype/view");
%>


<script type="text/javascript">
	function searchFileType(url) {		
		document.<portlet:namespace />fm.method = "post";
		submitForm(document.<portlet:namespace />fm, url);
	}
</script>

<%
	FileTypeSearch fileTypeSearch = (FileTypeSearch) request.getAttribute("liferay-ui:search:searchContainer");
	FileTypeDisplayTerms displayTerms = (FileTypeDisplayTerms) fileTypeSearch.getDisplayTerms();
%>

<liferay-ui:search-toggle displayTerms="<%= displayTerms %>" id="toogle_id_fileType" >
	<table cellspacing="0" width="100%">
		<tr>
			<td><liferay-ui:message key="sgs_filetype_filetypeCode" />:&nbsp;</td>
			<td>
				<input name="<portlet:namespace/><%=FileTypeDisplayTerms.FILETYPE_CODE %>" type="text" value="<%= HtmlUtil.escape(displayTerms.getFileTypeCode()) %>" />
			</td>
			
			<td><liferay-ui:message key="sgs_filetype_filetypeName" />:&nbsp;</td>
			<td>
				<input name="<portlet:namespace/><%=FileTypeDisplayTerms.FILETYPE_NAME %>" type="text" value="<%= HtmlUtil.escape(displayTerms.getFileTypeName()) %>" />
			</td>
		</tr>
		
	</table>	
</liferay-ui:search-toggle>
<br/>
<input type="button" class="button-width" onclick="searchFileType('<%= portletURL.toString()  %>')" name="<portlet:namespace/>search" value="<liferay-ui:message key="search"/>"/>
