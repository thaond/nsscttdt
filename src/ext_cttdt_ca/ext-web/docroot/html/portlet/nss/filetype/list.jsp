<%@ include file="/html/portlet/nss/filetype/init.jsp" %>

<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>

<%@page import="com.nss.portlet.filetype.FileTypeCanNotDeleteException"%>
<%@page import="com.nss.portlet.filetype.search.FileTypeSearch"%>
<%@page import="com.nss.portlet.filetype.search.FileTypeSearchTerms"%>
<%@page import="java.util.List"%>
<%@page import="com.nss.portlet.filetype.model.PmlFileType"%>
<%@page import="com.nss.portlet.filetype.service.PmlFileTypeLocalServiceUtil"%>
<%@page import="com.nss.portlet.documentfield.service.PmlFieldLocalServiceUtil"%>

<script type="text/javascript">

	function deleteFileType(url) {		
		if (confirm("<liferay-ui:message key='sgs_field_deleteMessage'/>" )) {
			document.<portlet:namespace />fm.method = "post";
			submitForm(document.<portlet:namespace />fm, url);
		}
	}

</script>

<%
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action", "/nss/filetype/view");
%>

<form action="<%= portletURL.toString() %>"  method="post" name="<portlet:namespace />fm" onSubmit="submitForm(this); return false;">
<div class="commom-form">
<div class="parent-title"><liferay-ui:message key="javax.portlet.title.NSS_FILETYPE"/></div>
	<input name="<portlet:namespace />fileTypeURL" type="hidden" value="<%= portletURL.toString() %>" />
	<liferay-ui:error exception="<%= FileTypeCanNotDeleteException.class %>" message="can-not-delete-pml-do-quan-trong" />
	<%
		FileTypeSearch fileTypeSearch = new FileTypeSearch(renderRequest, portletURL);
		FileTypeSearchTerms searchTerms = (FileTypeSearchTerms)fileTypeSearch.getSearchTerms();
	%>
	
	<liferay-ui:search-form
		page="/html/portlet/nss/filetype/search_form_filetype.jsp"
		searchContainer="<%= fileTypeSearch %>" />
	
	     
	<%
		List<PmlFileType> results = new ArrayList<PmlFileType>();
		int total = 0;
		
		if (searchTerms.isAdvancedSearch()) {
			results = PmlFileTypeLocalServiceUtil.search(searchTerms.getFileTypeCode(), 
					searchTerms.getFileTypeName(), searchTerms.isAndOperator(), fileTypeSearch.getStart(), 
					fileTypeSearch.getEnd(), fileTypeSearch.getOrderByComparator());
			
			total = PmlFileTypeLocalServiceUtil.searchCount(searchTerms.getFileTypeCode(),
					searchTerms.getFileTypeName(), searchTerms.isAndOperator());
		}
		else {
			results = PmlFileTypeLocalServiceUtil.search(searchTerms.getKeywords(), fileTypeSearch.getStart(),
					fileTypeSearch.getEnd(), fileTypeSearch.getOrderByComparator());
			
			total = PmlFileTypeLocalServiceUtil.searchCount(searchTerms.getKeywords());
		}
		
		fileTypeSearch.setTotal(total);
		
		fileTypeSearch.setResults(results);
		
		portletURL.setParameter(fileTypeSearch.getCurParam(), String.valueOf(fileTypeSearch.getCurValue()));
	%>
	
	<portlet:renderURL var="add_filetype">
		<portlet:param name="struts_action" value="/nss/filetype/view" />
		<portlet:param name="tab" value="add" />
		<portlet:param name="<%= Constants.CMD %>" value="<%= Constants.ADD %>" />
		<portlet:param name="redirect" value="<%= fileTypeSearch.getIteratorURL().toString() %>"/>
	</portlet:renderURL>
		
	<span onclick="javascript:submitForm(document.hrefFm,'<%= add_filetype %>');" ><input class="button-width" type="button" value='<liferay-ui:message key="add_new" />'/></span>
	<br/><br/>
	<div id="separator"></div>
	
	<%
		List resultRows = fileTypeSearch.getResultRows();
	
		ResultRow row = null;	
		PmlFileType fileType = null;
		String fileTypeId = "";	
		String pmlFieldName = "";
		String active = "";
		String attFileURL = "";
		String editURL = "";
		String deleteURL = "";
		for (int i = 0; i < results.size(); i ++) {
			fileType = results.get(i);
			fileTypeId = fileType.getFileTypeId();
			
			row = new ResultRow(fileType, fileTypeId, i);
			
			// STT
			row.addText(String.valueOf(i + 1));
			
			
			// ma loai ho so
			
			row.addText(fileType.getFileTypeCode());
			
			// ten loai ho so
			row.addText(fileType.getFileTypeName());
			
			// linh vuc 
			try {
				pmlFieldName = PmlFieldLocalServiceUtil.getPmlField(fileType.getFieldId()).getFieldName();
			} catch (Exception e) {
				
			}
			row.addText(pmlFieldName);
			
			// ban mau
			row.addText(fileType.getTemplateId());
			
			// thoi gian xu ly		
			row.addText(fileType.getProcessTime());
			
			// mo ta 
			row.addText(fileType.getDescription());
			
			//URL active
			PortletURL rowURLActive= renderResponse.createActionURL();
			rowURLActive.setWindowState(WindowState.NORMAL);
			rowURLActive.setParameter("struts_action","/nss/filetype/view");
			rowURLActive.setParameter(Constants.CMD,Constants.LOCK);
			rowURLActive.setParameter("fileTypeId", fileTypeId);
			rowURLActive.setParameter("redirect",  fileTypeSearch.getIteratorURL().toString());
			
			if ("1".equals(fileType.getActive())) {
				active = "<a href='"+ rowURLActive.toString()+"'><img src='/html/images/checked.gif' />&nbsp;</a>";
			} else {
				active = "<a href='"+ rowURLActive.toString()+"'><img src='/html/images/unchecked.gif' />&nbsp;</a>";
			}
			
			row.addText(active);
			
			// so bien nhan hien tai
			row.addText(fileType.getCurrentReceiptNumber());
			
			// mau bien nhan
			row.addText(fileType.getReceiptTemplate());
			
			// ho so dinh kem
			PortletURL rowURLAttFile = renderResponse.createRenderURL();
			rowURLAttFile.setWindowState(WindowState.NORMAL);
			rowURLAttFile.setParameter("struts_action", "/nss/filetype/view");
			rowURLAttFile.setParameter(Constants.CMD,"VIEW_ATTACH_FILE");
			rowURLAttFile.setParameter("tab", "attach_file");
			rowURLAttFile.setParameter("fileTypeId", fileTypeId);
			rowURLAttFile.setParameter("redirect",  fileTypeSearch.getIteratorURL().toString());
			attFileURL = "<a  href='" + rowURLAttFile.toString() + "'><u>" + "<img src='/html/themes/nss_cttdt/images/cttdt/iconAttachFile.gif' title='" + LanguageUtil.get(pageContext, "pccc-TN-hosodinhkem") + "'/></u></a>";
			
			row.addText(attFileURL);
			
			// sua	
			
			PortletURL rowURLEdit = renderResponse.createRenderURL();
			rowURLEdit.setWindowState(WindowState.NORMAL);
			rowURLEdit.setParameter("struts_action", "/nss/filetype/view");
			rowURLEdit.setParameter(Constants.CMD, Constants.EDIT);
			rowURLEdit.setParameter("tab", "edit");
			rowURLEdit.setParameter("fileTypeId", fileTypeId);
			rowURLEdit.setParameter("redirect",  fileTypeSearch.getIteratorURL().toString());
			editURL = "<a  href='" + rowURLEdit.toString() + "'><u>" + "<img src='/html/images/edit.png'/>" + "</u></a>";
			
			row.addText(editURL);
			
			// xoa		
			PortletURL rowURLDelete = renderResponse.createActionURL();
			rowURLDelete.setWindowState(WindowState.NORMAL);
			rowURLDelete.setParameter("struts_action", "/nss/filetype/view");
			rowURLDelete.setParameter(Constants.CMD, Constants.DELETE);
			rowURLDelete.setParameter("fileTypeId", fileTypeId);
			rowURLDelete.setParameter("redirect",  fileTypeSearch.getIteratorURL().toString());
			
			deleteURL = "<a  href='javascript: ;'  onclick=deleteFileType('"+ rowURLDelete.toString() +"')><u>"+ "<img src='/html/images/delete.png'/>" +"</u></a>";
			
			row.addText(deleteURL);
			
			resultRows.add(row);
		}
		
	%>
	
	<liferay-ui:search-iterator searchContainer="<%= fileTypeSearch %>" />
</div>
</form>
