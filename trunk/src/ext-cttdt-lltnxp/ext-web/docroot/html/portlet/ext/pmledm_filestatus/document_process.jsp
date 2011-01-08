<%@ include file="/html/portlet/ext/pmledm_filestatus/init.jsp" %>
<%@page import="javax.portlet.WindowState"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portlet.PortletURLImpl"%>
<%@page import="javax.portlet.PortletRequest"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.sgs.portlet.pmledm_filestatus.search.PmlFileStatusSearch"%>
<%@page import="com.sgs.portlet.pmledm_filestatus.search.PmlFileStatusSearchTerms"%>
<%@page import="com.sgs.portlet.document.service.PmlFileStatusLocalServiceUtil"%>
<%@page import="com.sgs.portlet.document.model.PmlFileStatus"%>
<%@page import="com.sgs.portlet.document.PmlFileStatusCanNotDeleteException"%>

<script type="text/javascript">

	function deleteDocumentProcess(url) {		
		if (confirm("<liferay-ui:message key='sgs_field_deleteMessage'/>" )) {
			document.<portlet:namespace />fm.method = "post";
			submitForm(document.<portlet:namespace />fm, url);
		}
	}

</script>
<%
	String tabsDocument = (String)renderRequest.getAttribute("tabs");
	PortletURL doccumentURL = renderResponse.createRenderURL();
	doccumentURL.setWindowState(WindowState.NORMAL);
	doccumentURL.setParameter("struts_action", "/sgs/pmledm_filestatus/view");
	
	doccumentURL.setParameter("tabs", tabsDocument);	
	String doccumentURLString = doccumentURL.toString();
%>

<form name="<portlet:namespace/>fm" method="post" action="<%=doccumentURLString%>" >
<div class="boxcontent_Tab">
	<input name="<portlet:namespace />documentStatusURL" type="hidden" value="<%= doccumentURLString %>" />
	<liferay-ui:error exception="<%= PmlFileStatusCanNotDeleteException.class %>" message="can-not-delete-pml-do-quan-trong" />
		<input name="<portlet:namespace />redirect" type="hidden" value="<%= doccumentURLString %>" />
		
		<%
			PmlFileStatusSearch searchContainerDocument = new PmlFileStatusSearch(renderRequest,doccumentURL);
		%>
		
		<liferay-ui:search-form page="/html/portlet/ext/pmledm_filestatus/search_form.jsp"
		searchContainer="<%= searchContainerDocument %>" />
		
		<%
			// URL add
			PortletURL addfilestatusURL = renderResponse.createRenderURL();
			addfilestatusURL.setWindowState(WindowState.NORMAL);
			addfilestatusURL.setParameter("struts_action", "/sgs/pmledm_filestatus/add_filestatus_document");
			addfilestatusURL.setParameter("tabs", tabsDocument);
			addfilestatusURL.setParameter("tabDisplayDocument", "add");
			addfilestatusURL.setParameter("redirect", searchContainerDocument.getIteratorURL().toString());
			String addfilestatusString = addfilestatusURL.toString();
		%>
		
		<span onclick="javascript:submitForm(document.hrefFm,'<%= addfilestatusString %>');">
			<input class="button-width" type="button" name="<portlet:namespace/>them" value="<liferay-ui:message key="add_new"/>"/>
		</span>
		
		<div class="separator"></div>
		<%
			PmlFileStatusSearchTerms searchTerms = (PmlFileStatusSearchTerms)searchContainerDocument.getSearchTerms();
		
			int totalDocument = 0;
			
			if(searchTerms.isAdvancedSearch()){
				totalDocument = PmlFileStatusLocalServiceUtil.searchCountCV( searchTerms.getFilestatuscode(), searchTerms.getFilestatusname(),
						searchTerms.isAndOperator());
			}
			else{
				totalDocument = PmlFileStatusLocalServiceUtil.searchCountCV(searchTerms.getKeywords());
			}
			
			searchContainerDocument.setTotal(totalDocument);
			
			List resultsDocument = null;
			
			if(searchTerms.isAdvancedSearch()){
				resultsDocument = PmlFileStatusLocalServiceUtil.searchCV(searchTerms.getFilestatuscode(), searchTerms.getFilestatusname(),
						searchTerms.isAndOperator(), searchContainerDocument.getStart(), searchContainerDocument.getEnd(), searchContainerDocument.getOrderByComparator());
			}
			else{
				resultsDocument = PmlFileStatusLocalServiceUtil.searchCV(searchTerms.getKeywords(),searchContainerDocument.getStart(),
						searchContainerDocument.getEnd(),searchContainerDocument.getOrderByComparator());
			}
			
			searchContainerDocument.setResults(resultsDocument);
			
			doccumentURL.setParameter(searchContainerDocument.getCurParam(), String.valueOf(searchContainerDocument.getCurValue()));
		%>
	
		<%
			PmlFileStatus fileStatusDocument = null;
			List resultRows = searchContainerDocument.getResultRows();
			ResultRow row = null;
			String stt = "";
			String filestatuscode = "";
			String filestatusname = "";
			String description = "";
			String action = "";
			String update= "";
			String delete = "";
			
			for(int i=0; i<resultsDocument.size();i++){
				fileStatusDocument = (PmlFileStatus)resultsDocument.get(i);
				fileStatusDocument.toEscapedModel();
				row = new ResultRow(fileStatusDocument, fileStatusDocument.getFileStatusId(),i);
				stt = i+1+".";
				
				// URL Stateprocess
				PortletURL rowURLDocument = renderResponse.createRenderURL();
				rowURLDocument.setWindowState(WindowState.NORMAL);
				rowURLDocument.setParameter("struts_action","/sgs/pmledm_filestatus/display_stateprocess_document");
				rowURLDocument.setParameter("fileStatusId",String.valueOf(fileStatusDocument.getFileStatusId()));
				rowURLDocument.setParameter("redirect", searchContainerDocument.getIteratorURL().toString());
				rowURLDocument.setParameter("tabs",tabsDocument);
				
				// URL update
				PortletURL rowURLEdit = renderResponse.createRenderURL();
				rowURLEdit.setWindowState(WindowState.NORMAL);
				rowURLEdit.setParameter("struts_action","/sgs/pmledm_filestatus/edit_filestatus_document");
				rowURLEdit.setParameter(Constants.CMD,Constants.UPDATE);
				rowURLEdit.setParameter("fileStatusId",String.valueOf(fileStatusDocument.getFileStatusId()));
				rowURLEdit.setParameter("redirect", searchContainerDocument.getIteratorURL().toString());
				rowURLEdit.setParameter("tabs",tabsDocument);
				rowURLEdit.setParameter("tabDisplayDocument","edit");
				
				// URL delete
				PortletURL rowURLDelete = renderResponse.createActionURL();
				rowURLDelete.setWindowState(WindowState.NORMAL);
				rowURLDelete.setParameter("struts_action","/sgs/pmledm_filestatus/edit_filestatus_document");
				rowURLDelete.setParameter(Constants.CMD,Constants.DELETE);
				rowURLDelete.setParameter("fileStatusId",String.valueOf(fileStatusDocument.getFileStatusId()));
				rowURLDelete.setParameter("redirect", searchContainerDocument.getIteratorURL().toString());
				rowURLDelete.setParameter("tabs",tabsDocument);
				
				filestatuscode = fileStatusDocument.getFileStatusCode();
				filestatusname = fileStatusDocument.getFileStatusName();
				description = fileStatusDocument.getDescription();
				action = fileStatusDocument.getFileStatusName();
				
				update = "<a href='"+ rowURLEdit.toString()+"'><img src='/html/images/edit.png' />&nbsp;</a>";
				delete =  "<a  href='javascript: ;' onclick=deleteDocumentProcess('"+ rowURLDelete.toString() +"')><u>"+ "<img src='/html/images/delete.png'/>" +"</u></a>";
				
				row.addText(stt);
				row.addText(filestatuscode);
				row.addText(filestatusname);
				row.addText(description);
				row.addText(action, rowURLDocument);
				row.addText(update);
				row.addText(delete);
				
				resultRows.add(row);
			}
		%>
			<liferay-ui:search-iterator searchContainer="<%=searchContainerDocument %>" />
</div>
</form>
