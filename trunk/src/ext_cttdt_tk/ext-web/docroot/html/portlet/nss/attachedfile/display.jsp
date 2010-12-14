<%@ include file="/html/portlet/nss/attachedfile/init.jsp" %>

<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>

<%@page import="com.nss.portlet.attachedfile.AttachedFileCanNotDeleteException"%>
<%@page import="com.nss.portlet.attachedfile.search.AttachedfileSearch"%>
<%@page import="com.nss.portlet.attachedfile.search.AttachedfileSearchTerms"%>


<%@page import="com.nss.portlet.attachedfile.model.AttachedFile"%>
<%@page import="com.nss.portlet.attachedfile.service.AttachedFileLocalServiceUtil"%><script type="text/javascript">

	function deleteAttachedFile(url) {		
		if (confirm("<liferay-ui:message key='sgs_field_deleteMessage'/>" )) {
			document.<portlet:namespace />fm.method = "post";
			submitForm(document.<portlet:namespace />fm, url);
		}
	}

</script>

<%
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action", "/nss/attachedfile/view");
%>

<form action="<%= portletURL.toString() %>" method="post" name="<portlet:namespace />fm">
	<input name="<portlet:namespace />attachedFileURL" type="hidden" value="<%= portletURL.toString() %>" />
	<div class="commom-form">
	<div class="parent-title"><liferay-ui:message key="attached-file"/></div>
	<liferay-ui:error exception="<%= AttachedFileCanNotDeleteException.class %>" message="can-not-delete-pml-do-quan-trong" />
	
	<%
		AttachedfileSearch attachedfileSearch = new AttachedfileSearch(renderRequest, portletURL);
		AttachedfileSearchTerms searchTerms = (AttachedfileSearchTerms)attachedfileSearch.getSearchTerms();
	%>
	
	<liferay-ui:search-form
		page="/html/portlet/nss/attachedfile/search_form.jsp"
		searchContainer="<%= attachedfileSearch %>" />

	<portlet:renderURL var="add">
		<portlet:param name="struts_action" value="/nss/attachedfile/view" />
		<portlet:param name="tabs1" value="add_edit" />
		<portlet:param name="redirect" value="<%= attachedfileSearch.getIteratorURL().toString() %>" />
	</portlet:renderURL>

	<span onclick="javascript:submitForm(document.hrefFm, '<%= add%>')"><input type="button" class="button-width" value='<liferay-ui:message key="add_new"/>' /></span>
	<br/><br/>	
	<%
		List<AttachedFile> results = null;
		int total = 0;
		
		if (searchTerms.isAdvancedSearch()) {
			results = AttachedFileLocalServiceUtil.search(searchTerms.getMa(), searchTerms.getTen(),searchTerms.isAndOperator(),
														attachedfileSearch.getStart(), attachedfileSearch.getEnd(), attachedfileSearch.getOrderByComparator());
		} else {
			results = AttachedFileLocalServiceUtil.search(searchTerms.getKeywords(),attachedfileSearch.getStart(), attachedfileSearch.getEnd(),
															attachedfileSearch.getOrderByComparator());
		}
		attachedfileSearch.setResults(results);
		
		if (searchTerms.isAdvancedSearch()) {
			total =  AttachedFileLocalServiceUtil.searchCount(searchTerms.getMa(), searchTerms.getTen(),searchTerms.isAndOperator());
		} else {
			total = AttachedFileLocalServiceUtil.searchCount(searchTerms.getKeywords());
		}
		attachedfileSearch.setTotal(total);
		
		portletURL.setParameter(attachedfileSearch.getCurParam(), String.valueOf(attachedfileSearch.getCurValue()));
	%>
	
	<%
		List resultRows = attachedfileSearch.getResultRows();
		ResultRow row = null;
		AttachedFile attachedFile = null;
		String active = "";
		String update = "";
		String delete = "";
		
		for ( int i=0; i<results.size(); i++) {
			attachedFile = results.get(i);
			row = new ResultRow( attachedFile, attachedFile.getAttachedFileId(), i);
			
			//URL update
			PortletURL rowURLEdit = renderResponse.createRenderURL();
			rowURLEdit.setWindowState(WindowState.NORMAL);
			//rowURLEdit.setParameter(Constants.CMD,Constants.EDIT);
			rowURLEdit.setParameter("struts_action","/nss/attachedfile/view");
			rowURLEdit.setParameter("attachedFileId",attachedFile.getAttachedFileId());
			rowURLEdit.setParameter("tabs1","add_edit");
			rowURLEdit.setParameter("redirect", attachedfileSearch.getIteratorURL().toString());
	
			//URL delete
			PortletURL rowURLDelete = renderResponse.createActionURL();
			rowURLDelete.setWindowState(WindowState.NORMAL);
			rowURLDelete.setParameter("struts_action","/nss/attachedfile/view");
			rowURLDelete.setParameter(Constants.CMD,Constants.DELETE);
			rowURLDelete.setParameter("attachedFileId",attachedFile.getAttachedFileId());
			rowURLDelete.setParameter("redirect", attachedfileSearch.getIteratorURL().toString());
			
			//URL lock
			PortletURL rowURLActive= renderResponse.createActionURL();
			rowURLActive.setWindowState(WindowState.NORMAL);
			rowURLActive.setParameter("struts_action","/nss/attachedfile/view");
			rowURLActive.setParameter(Constants.CMD,Constants.LOCK);
			rowURLActive.setParameter("attachedFileId",attachedFile.getAttachedFileId());
			rowURLActive.setParameter("redirect", attachedfileSearch.getIteratorURL().toString());
			
			update = "<a href='"+ rowURLEdit.toString()+"'><img src='/html/images/edit.png' />&nbsp;</a>";
			delete = "<a  href='javascript: ;'  onclick=deleteAttachedFile('"+ rowURLDelete.toString() +"')><u>"+ "<img src='/html/images/delete.png'/>" +"</u></a>";
			
			if ("1".equals(attachedFile.getActive())) {
				active = "<a href='"+ rowURLActive.toString()+"'><img src='/html/images/checked.gif' />&nbsp;</a>";
			} else {
				active = "<a href='"+ rowURLActive.toString()+"'><img src='/html/images/unchecked.gif' />&nbsp;</a>";
			}
			
			//STT
			row.addText(String.valueOf(i+1));
			//Ma
			row.addText(attachedFile.getAttachedFileCode());
			//Ten ho so dinh kem
			row.addText(attachedFile.getAttachedFileName());
			//mota
			row.addText(attachedFile.getDescription());
			//active
			row.addText(active);
			//update
			row.addText(update);
			//delete
			row.addText(delete);
			
			resultRows.add(row);
		}
		
	%>
	
	<liferay-ui:search-iterator searchContainer="<%=attachedfileSearch %>" />
</div>	
</form>
