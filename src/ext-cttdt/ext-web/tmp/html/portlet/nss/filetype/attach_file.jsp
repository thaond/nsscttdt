<%@ include file="/html/portlet/nss/filetype/init.jsp" %>

<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>

<%@page import="java.util.List"%>
<%@page import="com.nss.portlet.filetype.model.PmlFileTypeAttachedFile"%>
<%@page import="com.nss.portlet.filetype.search.FileTypeAttFileSearch"%>

<script type="text/javascript">

	function deletePmlFileTypeAttachedFile(url) {	
		if (confirm("<liferay-ui:message key='sgs_field_deleteMessage'/>" )) {
			document.<portlet:namespace />fm.method = "post";
			submitForm(document.<portlet:namespace />fm, url);
		}
	}

</script>

<%

	String redirect = ParamUtil.getString(renderRequest, "redirect");
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action", "/nss/filetype/view");
	
	List<PmlFileTypeAttachedFile> pmlFileTypeAttachedFileList = (List<PmlFileTypeAttachedFile>) renderRequest.getAttribute("pmlFileTypeAttachedFileList");
	String fileTypeId = (String) renderRequest.getAttribute("fileTypeId");
%>

<form action="<%= portletURL.toString() %>"  method="get" name="<portlet:namespace />fm" onSubmit="submitForm(this); return false;">
<div class="commom-form">
<div class="parent-title"><liferay-ui:message key="attached-file"/></div>
<%
	FileTypeAttFileSearch  attFileSearch = new FileTypeAttFileSearch(renderRequest, portletURL);

	List<PmlFileTypeAttachedFile> results = pmlFileTypeAttachedFileList;
	
	attFileSearch.setTotal(results.size());
	
	attFileSearch.setResults(results);
	
	portletURL.setParameter(attFileSearch.getCurParam(), String.valueOf(attFileSearch.getCurValue()));
%>


<%
	List resultRows = attFileSearch.getResultRows();
	PmlFileTypeAttachedFile attachedFile = null;
	ResultRow row = null;	
	String attachedFileId  = "";
	String editURL = "";
	String deleteURL = "";
	for (int i = 0; i < results.size(); i ++) {
		attachedFile = results.get(i);
		attachedFileId = attachedFile.getFiletypeAttachedFileId();
		
		row = new ResultRow(attachedFile, attachedFileId, i);
		
		// STT
		row.addText(String.valueOf(i + 1));
		
		
		// ten file attach
		row.addText(attachedFile.getAttachedFileName());
		
		// ban chinh
		row.addText(String.valueOf(attachedFile.getOriginal()));
		
		// ban sao 
		row.addText(String.valueOf(attachedFile.getCopy_()));
		
		// ghi chu
		row.addText(attachedFile.getNote());		
		
		// sua		
		PortletURL rowURLEdit = renderResponse.createRenderURL();
		rowURLEdit.setWindowState(WindowState.NORMAL);
		rowURLEdit.setParameter("struts_action", "/nss/filetype/view");
		rowURLEdit.setParameter(Constants.CMD, "EDIT_ATTACHFILE");
		rowURLEdit.setParameter("tab", "edit_attachfile");
		rowURLEdit.setParameter("fileTypeAttachFileId", attachedFileId);
		rowURLEdit.setParameter("fileTypeId", fileTypeId);
		rowURLEdit.setParameter("redirect",  redirect);
		editURL = "<a  href='" + rowURLEdit.toString() + "'><u>" + "<img src='/html/images/edit.png'/>" + "</u></a>";
		
		row.addText(editURL);
		
		// xoa		
		PortletURL rowURLDelete = renderResponse.createActionURL();
		rowURLDelete.setWindowState(WindowState.NORMAL);
		rowURLDelete.setParameter("struts_action", "/nss/filetype/view");
		rowURLDelete.setParameter(Constants.CMD, "DELETE_ATTACH_FILE");	
		rowURLDelete.setParameter("action", "VIEW_ATTACH_FILE");	
		rowURLDelete.setParameter("tab", "attach_file");
		rowURLDelete.setParameter("fileTypeAttachFileId", attachedFileId);
		rowURLDelete.setParameter("fileTypeId", fileTypeId);		
		rowURLDelete.setParameter("redirect", redirect);		
	
		deleteURL = "<a  href='javascript: ;'  onclick=deletePmlFileTypeAttachedFile('"+ rowURLDelete.toString() +"')><u>"+ "<img src='/html/images/delete.png'/>" +"</u></a>";
		
		row.addText(deleteURL);
		
		resultRows.add(row);
	}
	
%>

<liferay-ui:search-iterator searchContainer="<%= attFileSearch %>" />

	<portlet:renderURL var="add_attachfile">
		<portlet:param name="struts_action" value="/nss/filetype/view" />
		<portlet:param name="<%= Constants.CMD %>" value="ADD_ATTACHFILE" />
		<portlet:param name="tab" value="add_attachfile" />
		<portlet:param name="fileTypeId" value="<%= fileTypeId %>" />
		<portlet:param name="redirect" value="<%= redirect %>" />	
	</portlet:renderURL>
	<div id="table-button" align="right">
		<span onclick="javascript:submitForm(document.hrefFm,'<%= add_attachfile %>');" ><input type="button" class="button-width" value='<liferay-ui:message key="add_new" />'/></span>
		<span onclick="javascript:submitForm(document.hrefFm,'<%= redirect %>');" ><input class="button-width" type="button"	value='<liferay-ui:message key="back"/>' /></span>
	</div>
</div>
</form>

