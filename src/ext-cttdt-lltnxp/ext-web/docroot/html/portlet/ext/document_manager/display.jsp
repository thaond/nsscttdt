<%@ include file="/html/portlet/ext/document_manager/init.jsp" %>

<%@page import="java.io.File"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="javax.portlet.PortletURL"%>

<%@page import="com.liferay.portal.kernel.search.Sort"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>

<%@page import="com.sgs.portlet.document_manager.model.AttactFileDocument"%>
<%@page import="com.sgs.portlet.document_manager.service.DocumentManagerLocalServiceUtil"%>
<%@page import="com.sgs.portlet.document_manager.model.DocumentManager"%>
<%@page import="com.sgs.portlet.document_manager.search.DocumentManagerSearchTerms"%>
<%@page import="com.sgs.portlet.document_manager.search.DocumentManagerDisplayTerms"%>
<%@page import="com.sgs.portlet.document_manager.search.DocumentManagerSearch"%>

<%
	String tabs1 = ParamUtil.getString(renderRequest, "tabs1", "DocumentSend");
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action", "/sgs/document_manager/view");
	portletURL.setParameter("tabs1", tabs1);
	String portletURLString = portletURL.toString();
	request.setAttribute("portletURL", portletURL);
	
	String error_delete_document_manager = (String) request.getAttribute("error_delete_document_manager");
	String documentManagerSelect = (String) request.getAttribute("documentManagerId");
	long documentManagerIdRequest = 0;
	if(documentManagerSelect != null){
		try{
			 documentManagerIdRequest = Long.parseLong(documentManagerSelect);
		}catch(Exception e){
			
		}
	}
	
	DocumentManagerSearch documentManagerSearch = new DocumentManagerSearch(renderRequest, portletURL);
	DocumentManagerDisplayTerms displayTerms = (DocumentManagerDisplayTerms)documentManagerSearch.getDisplayTerms();
	DocumentManagerSearchTerms searchTerms = (DocumentManagerSearchTerms) documentManagerSearch.getSearchTerms();
	
	String orderByCol = ParamUtil.getString(renderRequest, "orderByCol", DocumentManagerDisplayTerms.DOCUMENTMANAGERCODE);
	int sortType = Sort.STRING_TYPE;
	String orderByType = documentManagerSearch.getOrderByType().toLowerCase();
	
	boolean reverse = false;
	if (orderByType.equals("desc")) {
		reverse = true;
	} 
	
	int count = 0;
	List<DocumentManager> listDocumentManager = new ArrayList<DocumentManager>();
	count = DocumentManagerLocalServiceUtil.countDocumentManager(searchTerms.getDocumentManagerCode(), searchTerms.getDocumentManagerDescription(), searchTerms.getDocumentManagerTitle(), searchTerms.isAndOperator());
	listDocumentManager = DocumentManagerLocalServiceUtil.findDocumentManager(searchTerms.getDocumentManagerCode(), searchTerms.getDocumentManagerDescription(), searchTerms.getDocumentManagerTitle(),
						documentManagerSearch.getStart(), documentManagerSearch.getEnd(), searchTerms.isAndOperator(), documentManagerSearch.getOrderByComparator());
			
	List<DocumentManager> tempDocumentSend = new ArrayList<DocumentManager>();
	List<DocumentManager> tempDocumentReceived = new ArrayList<DocumentManager>();
	if(documentManagerIdRequest != 0){
		for(DocumentManager documentManager : listDocumentManager){
			String documentStyle = documentManager.getDocumentManagerStyle();
			if(documentManager.getDocumentManagerId() == documentManagerIdRequest){
				if(documentStyle.equals("send")){
					tempDocumentSend.add(documentManager);
				}else if(documentStyle.equals("received")){
					tempDocumentReceived.add(documentManager);
				}
			}
		}
	}
	
	List<DocumentManager> tempList = new ArrayList<DocumentManager>();
	for(DocumentManager dm : listDocumentManager){
		String documentStyle = dm.getDocumentManagerStyle();
			
	}
		
	List<ResultRow> resultRows = documentManagerSearch.getResultRows();
	ResultRow row = null;
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
	List<AttactFileDocument> attactFileDocuments = new ArrayList<AttactFileDocument>();
	DocumentManager documentManager = null;
	long documentManagerId = 0;
	String dateNow = "";
	String linkDocumentFile = "";
%>

<% if(error_delete_document_manager != null){ %>
	<div style="color: red"><liferay-ui:message key="not-delete-document-manager"/></div>
<%} %>

<liferay-ui:tabs names="DocumentSend,DocumentReceived" url="<%= portletURLString %>" />
	
<c:choose>
	<c:when test='<%=tabs1.equals("DocumentSend") %>'>
		<form action="<%= portletURL.toString() %>"  method="post" name="<portlet:namespace />fm" >
		<div class="separator"></div>
		<liferay-ui:search-form	page="/html/portlet/ext/document_manager/document_manager_search_form.jsp" searchContainer="<%= documentManagerSearch %>" />
			<%
				PortletURL addURL = renderResponse.createRenderURL();
				addURL.setWindowState(WindowState.NORMAL);
				addURL.setParameter("struts_action", "/sgs/document_manager/view");
				addURL.setParameter("tab", "add_report_registry");
				addURL.setParameter("tabs1", "DocumentReceived");
				addURL.setParameter("redirect", documentManagerSearch.getIteratorURL().toString());
			%>
		<a href="<%= addURL.toString() %>"><span><input class="button-width" type="button" value='<liferay-ui:message key="add-DocumentReceived"/>' /></span></a>
		<div class="separator"></div>
				<%
					count = tempDocumentSend.size();
					documentManagerSearch.setTotal(count);
					documentManagerSearch.setResults(tempDocumentSend);
					portletURL.setParameter(documentManagerSearch.getCurParam(), String.valueOf(documentManagerSearch.getCurValue()));
					
					for(int i = 0; i < listDocumentManager.size(); i++){
						documentManager = listDocumentManager.get(i);
						documentManagerId = documentManager.getDocumentManagerId();
						attactFileDocuments = DocumentManagerLocalServiceUtil.getAttactFileDocuments(documentManagerId);
						
						row = new ResultRow(documentManager, documentManagerId, i);
						// STT
						row.addText(String.valueOf(i + 1));
						
						//code
						row.addText(documentManager.getDocumentManagerCode());
						
						//date create
						if(documentManager.getDocumentManagerDateCreate() != null){
							dateNow = simpleDateFormat.format(documentManager.getDocumentManagerDateCreate());
							row.addText(dateNow);
						}else{
							row.addText("");
						}
						
						// description
						row.addText(documentManager.getDocumentManagerDescription());
						
						// title download
						for(AttactFileDocument attactFileDocument : attactFileDocuments){
							String title = attactFileDocument.getAttactFileDocumentPath();
								if(!attactFileDocument.getAttactFileDocumentTitle().equals("")){
									linkDocumentFile += "<a href =" + attactFileDocument.getAttactFileDocumentPath() + ">" +attactFileDocument.getAttactFileDocumentTitle().subSequence(0,attactFileDocument.getAttactFileDocumentTitle().indexOf("_")) + "</a>" + "<br>";
							}
						}
						row.addText(linkDocumentFile);
						
						// edit
						PortletURL rowURLEdit = renderResponse.createActionURL();
						rowURLEdit.setWindowState(WindowState.NORMAL);
						rowURLEdit.setParameter(Constants.CMD,Constants.EDIT);
						rowURLEdit.setParameter("struts_action","/sgs/document_manager/view");
						rowURLEdit.setParameter("documentManagerId", String.valueOf(documentManagerId));
						rowURLEdit.setParameter("varAction","documentManager");
						rowURLEdit.setParameter("redirect", documentManagerSearch.getIteratorURL().toString());
						rowURLEdit.setParameter("tab", "edit_report_registry");
						rowURLEdit.setParameter("tabs1","DocumentReceived");
						
						String updateAction = "<a href='"+ rowURLEdit.toString()+"'><img src='/html/images/edit.png' />&nbsp;</a>";
						
						row.addText(updateAction);
						
						// delete
						PortletURL rowURLDelete = renderResponse.createActionURL();
						rowURLDelete.setWindowState(WindowState.NORMAL);
						rowURLDelete.setParameter("struts_action","/sgs/document_manager/view");
						rowURLDelete.setParameter(Constants.CMD,Constants.DELETE);
						rowURLDelete.setParameter("varAction","documentManager");
						rowURLDelete.setParameter("tabs1","DocumentReceived");
						rowURLDelete.setParameter("documentManagerId", String.valueOf(documentManagerId));
						
						String deleteAction = "<a  href='javascript: ;' onclick=deleteConfirm('"+ rowURLDelete.toString() +"')><u>"+ "<img src='/html/images/delete.png'/>" +"</u></a>";
						
						row.addText(deleteAction);
						
						resultRows.add(row);
					}
			%>
		
				<liferay-ui:search-iterator searchContainer="<%= documentManagerSearch %>" />
		</form>
	</c:when>
		
	<c:when test='<%=tabs1.equals("DocumentReceived") %>'>
		<form action="<%= portletURL.toString() %>"  method="post" name="<portlet:namespace />fm" >
		<div class="separator"></div>
		<liferay-ui:search-form	page="/html/portlet/ext/document_manager/document_manager_search_form.jsp" searchContainer="<%= documentManagerSearch %>" />
			<%
				PortletURL addURL = renderResponse.createRenderURL();
				addURL.setWindowState(WindowState.NORMAL);
				addURL.setParameter("struts_action", "/sgs/document_manager/view");
				addURL.setParameter("tab", "add_report_registry");
				addURL.setParameter("tabs1", "DocumentReceived");
				addURL.setParameter("redirect", documentManagerSearch.getIteratorURL().toString());
			%>
		<a href="<%= addURL.toString() %>"><span><input class="button-width" type="button" value='<liferay-ui:message key="add-DocumentReceived"/>' /></span></a>
		<div class="separator"></div>
				<%
					count = tempDocumentReceived.size();
					documentManagerSearch.setTotal(count);
					documentManagerSearch.setResults(tempDocumentReceived);
					portletURL.setParameter(documentManagerSearch.getCurParam(), String.valueOf(documentManagerSearch.getCurValue()));
					
					for(int i = 0; i < listDocumentManager.size(); i++){
						documentManager = listDocumentManager.get(i);
						documentManagerId = documentManager.getDocumentManagerId();
						attactFileDocuments = DocumentManagerLocalServiceUtil.getAttactFileDocuments(documentManagerId);
						
						row = new ResultRow(documentManager, documentManagerId, i);
						// STT
						row.addText(String.valueOf(i + 1));
						
						//code
						row.addText(documentManager.getDocumentManagerCode());
						
						//date create
						if(documentManager.getDocumentManagerDateCreate() != null){
							dateNow = simpleDateFormat.format(documentManager.getDocumentManagerDateCreate());
							row.addText(dateNow);
						}else{
							row.addText("");
						}
						
						// description
						row.addText(documentManager.getDocumentManagerDescription());
						
						// title download
						for(AttactFileDocument attactFileDocument : attactFileDocuments){
							String title = attactFileDocument.getAttactFileDocumentPath();
								if(!attactFileDocument.getAttactFileDocumentTitle().equals("")){
									linkDocumentFile += "<a href =" + attactFileDocument.getAttactFileDocumentPath() + ">" +attactFileDocument.getAttactFileDocumentTitle().subSequence(0,attactFileDocument.getAttactFileDocumentTitle().indexOf("_")) + "</a>" + "<br>";
							}
						}
						row.addText(linkDocumentFile);
						
						// edit
						PortletURL rowURLEdit = renderResponse.createActionURL();
						rowURLEdit.setWindowState(WindowState.NORMAL);
						rowURLEdit.setParameter(Constants.CMD,Constants.EDIT);
						rowURLEdit.setParameter("struts_action","/sgs/document_manager/view");
						rowURLEdit.setParameter("documentManagerId", String.valueOf(documentManagerId));
						rowURLEdit.setParameter("varAction","documentManager");
						rowURLEdit.setParameter("redirect", documentManagerSearch.getIteratorURL().toString());
						rowURLEdit.setParameter("tab", "edit_report_registry");
						rowURLEdit.setParameter("tabs1","DocumentReceived");
						
						String updateAction = "<a href='"+ rowURLEdit.toString()+"'><img src='/html/images/edit.png' />&nbsp;</a>";
						
						row.addText(updateAction);
						
						// delete
						PortletURL rowURLDelete = renderResponse.createActionURL();
						rowURLDelete.setWindowState(WindowState.NORMAL);
						rowURLDelete.setParameter("struts_action","/sgs/document_manager/view");
						rowURLDelete.setParameter(Constants.CMD,Constants.DELETE);
						rowURLDelete.setParameter("varAction","documentManager");
						rowURLDelete.setParameter("tabs1","DocumentReceived");
						rowURLDelete.setParameter("documentManagerId", String.valueOf(documentManagerId));
						
						String deleteAction = "<a  href='javascript: ;' onclick=deleteConfirm('"+ rowURLDelete.toString() +"')><u>"+ "<img src='/html/images/delete.png'/>" +"</u></a>";
						
						row.addText(deleteAction);
						
						resultRows.add(row);
					}
			%>
		
				<liferay-ui:search-iterator searchContainer="<%= documentManagerSearch %>" />
		</form>
	</c:when>
</c:choose>

<script type="text/javascript">
	function deleteConfirm(url) {
		if (confirm("<liferay-ui:message key='ban-co-that-su-muon-xoa'/>")) {
			location.href = url;
		}
	}
</script> 