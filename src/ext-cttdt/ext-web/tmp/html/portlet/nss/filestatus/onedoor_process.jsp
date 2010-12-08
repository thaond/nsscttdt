<%@ include file="/html/portlet/nss/filestatus/init.jsp" %>
<%@page import="javax.portlet.WindowState"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portlet.PortletURLImpl"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.nss.portlet.filestatus.search.PmlFileStatusSearch"%>
<%@page import="com.nss.portlet.filestatus.search.PmlFileStatusSearchTerms"%>
<%@page import="com.nss.portlet.onedoor.service.PmlFileStatusLocalServiceUtil"%>
<%@page import="com.nss.portlet.onedoor.model.PmlFileStatus"%>
<%@page import="com.nss.portlet.onedoor.PmlFileStatusCanNotDeleteException"%>

<script type="text/javascript">
function deleteOneDoorProcess(url) {		
		if (confirm("<liferay-ui:message key='sgs_field_deleteMessage'/>" )) {
			document.<portlet:namespace />fm.method = "post";
			submitForm(document.<portlet:namespace />fm, url);
		}
	}

</script>

<%
	String tabsOnedoor = (String)renderRequest.getAttribute("tabs");

	PortletURL onedoorURL = renderResponse.createRenderURL();

	onedoorURL.setWindowState(WindowState.NORMAL);
	onedoorURL.setParameter("struts_action", "/nss/filestatus/view");
	onedoorURL.setParameter("tabs", tabsOnedoor);
	String onedoorURLString = onedoorURL.toString();
%>
	<form name="<portlet:namespace/>fm"  action="<%=onedoorURLString%>" method="post">
	 <div class="boxcontent_Tab">
		<input name="<portlet:namespace />ondoorStatusURL" type="hidden" value="<%= onedoorURLString %>" />
		<liferay-ui:error exception="<%= PmlFileStatusCanNotDeleteException.class %>" message="can-not-delete-pml-do-quan-trong" />
		<input name="<portlet:namespace />redirect" type="hidden" value="<%= onedoorURLString %>" />
		<%
			PmlFileStatusSearch searchContainerOnedoor = new PmlFileStatusSearch(renderRequest,onedoorURL);
			List<String> headernamesOnedoor = searchContainerOnedoor.getHeaderNames();
		
		%>
		
		<liferay-ui:search-form page="/html/portlet/nss/filestatus/search_form_onedoor.jsp"
		searchContainer="<%= searchContainerOnedoor %>" />
		
		<%
			// URL add
			PortletURL addfilestatusOnedoorURL = renderResponse.createRenderURL();
			addfilestatusOnedoorURL.setWindowState(WindowState.NORMAL);
			addfilestatusOnedoorURL.setParameter("struts_action", "/nss/filestatus/add_filestatus_onedoor");
			addfilestatusOnedoorURL.setParameter("tabs", tabsOnedoor);
			addfilestatusOnedoorURL.setParameter("tabDisplayOnedoor", "add");
			addfilestatusOnedoorURL.setParameter("redirect", searchContainerOnedoor.getIteratorURL().toString());
			String addfilestatusStringOnedoor = addfilestatusOnedoorURL.toString();
		%>
		<span onclick="javascript:submitForm(document.hrefFm,'<%= addfilestatusStringOnedoor %>');">
			<input class="button-width" type="button" name="<portlet:namespace/>them" value="<liferay-ui:message key="add_new"/>"/>
		</span>
		
		<div class="separator"></div>
		<%
			PmlFileStatusSearchTerms searchTermsOnedoor = (PmlFileStatusSearchTerms)searchContainerOnedoor.getSearchTerms();
			int totalOnedoor = 0;
			
			if(searchTermsOnedoor.isAdvancedSearch()){
				totalOnedoor = PmlFileStatusLocalServiceUtil.searchCountMC(searchTermsOnedoor.getFilestatuscode(),
						searchTermsOnedoor.getFilestatusname(),searchTermsOnedoor.isAndOperator());
			}
			else{
				totalOnedoor = PmlFileStatusLocalServiceUtil.searchCountMC(searchTermsOnedoor.getKeywords());
			}
			
			searchContainerOnedoor.setTotal(totalOnedoor);
			
			List resultsOnedoor = null;
			
			if(searchTermsOnedoor.isAdvancedSearch()){
				resultsOnedoor = PmlFileStatusLocalServiceUtil.searchMC(searchTermsOnedoor.getFilestatuscode(),searchTermsOnedoor.getFilestatusname(),
						searchTermsOnedoor.isAndOperator(),searchContainerOnedoor.getStart(),searchContainerOnedoor.getEnd(),searchContainerOnedoor.getOrderByComparator());
			}
			else{
				resultsOnedoor = PmlFileStatusLocalServiceUtil.searchMC(searchTermsOnedoor.getKeywords(),searchContainerOnedoor.getStart(),
						searchContainerOnedoor.getEnd(),searchContainerOnedoor.getOrderByComparator());
			}
			
			searchContainerOnedoor.setResults(resultsOnedoor);
			
			onedoorURL.setParameter(searchContainerOnedoor.getCurParam(), String.valueOf(searchContainerOnedoor.getCurValue()));
		%>
		
		<%
			PmlFileStatus fileStatusOnedoor = null;
			List resultRowsOnedoor = searchContainerOnedoor.getResultRows();
			ResultRow rowOnedoor = null;
			
			String stt = "";
			String filestatuscode = "";
			String filestatusname = "";
			String description = "";
			String action = "";
			String update= "";
			String delete = "";
			
			for(int i=0; i<resultsOnedoor.size();i++){
				fileStatusOnedoor = (PmlFileStatus)resultsOnedoor.get(i);
				fileStatusOnedoor.toEscapedModel();
				rowOnedoor = new ResultRow(fileStatusOnedoor, fileStatusOnedoor.getFileStatusId(),i);
				
				stt = i+1+".";
				
				PortletURL rowURLOnedoor = renderResponse.createRenderURL();
				rowURLOnedoor.setWindowState(WindowState.NORMAL);
				rowURLOnedoor.setParameter("struts_action","/nss/filestatus/display_stateprocess_onedoor");
				rowURLOnedoor.setParameter("fileStatusId",String.valueOf(fileStatusOnedoor.getFileStatusId()));
				rowURLOnedoor.setParameter("tabs",tabsOnedoor);
				rowURLOnedoor.setParameter("redirect",searchContainerOnedoor.getIteratorURL().toString());
				
				
				//URL update
				PortletURL rowURLEdit = renderResponse.createRenderURL();
				rowURLEdit.setWindowState(WindowState.NORMAL);
				rowURLEdit.setParameter("struts_action","/nss/filestatus/edit_filestatus_onedoor");
				rowURLEdit.setParameter(Constants.CMD,Constants.UPDATE);
				rowURLEdit.setParameter("fileStatusId",String.valueOf(fileStatusOnedoor.getFileStatusId()));
				rowURLEdit.setParameter("redirect", searchContainerOnedoor.getIteratorURL().toString());
				rowURLEdit.setParameter("tabs",tabsOnedoor);
				rowURLEdit.setParameter("tabDisplayOnedoor", "edit");
				
				//URL delete
				PortletURL rowURLDelete = renderResponse.createActionURL();
				rowURLDelete.setWindowState(WindowState.NORMAL);
				rowURLDelete.setParameter("struts_action","/nss/filestatus/edit_filestatus_onedoor");
				rowURLDelete.setParameter(Constants.CMD,Constants.DELETE);
				rowURLDelete.setParameter("fileStatusId",String.valueOf(fileStatusOnedoor.getFileStatusId()));
				rowURLDelete.setParameter("redirect", searchContainerOnedoor.getIteratorURL().toString());
				rowURLDelete.setParameter("tabs",tabsOnedoor);
				
				filestatuscode = fileStatusOnedoor.getFileStatusCode();
				filestatusname = fileStatusOnedoor.getFileStatusName();
				description = fileStatusOnedoor.getDescription();
				action = fileStatusOnedoor.getFileStatusName();
				
				update = "<a href='"+ rowURLEdit.toString()+"'><img src='/html/images/edit.png' />&nbsp;</a>";
				delete = "<a  href='javascript: ;' onclick=deleteOneDoorProcess('"+ rowURLDelete.toString() +"')><u>"+ "<img src='/html/images/delete.png'/>" +"</u></a>";
				
				rowOnedoor.addText(stt);
				rowOnedoor.addText(filestatuscode);
				rowOnedoor.addText(filestatusname);
				rowOnedoor.addText(description);
				rowOnedoor.addText(action,rowURLOnedoor );
				rowOnedoor.addText(update);
				rowOnedoor.addText(delete);
				
				resultRowsOnedoor.add(rowOnedoor);
			}
		%>
			<liferay-ui:search-iterator searchContainer="<%=searchContainerOnedoor %>" />
</div>
</form>
