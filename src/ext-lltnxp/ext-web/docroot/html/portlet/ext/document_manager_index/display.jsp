<%@ include file="/html/portlet/ext/document_manager_index/init.jsp" %>

<%@page import="java.io.File"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="javax.portlet.PortletURL"%>

<%@page import="com.liferay.portal.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.liferay.portal.kernel.search.Sort"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>

<%@page import="com.sgs.portlet.document_manager.model.AttactFileDocument"%>
<%@page import="com.sgs.portlet.document_manager.model.DocumentManager"%>
<%@page import="com.sgs.portlet.document_manager.service.DocumentManagerLocalServiceUtil"%>
<%@page import="com.sgs.portlet.document_manager_index.search.DocumentManagerIndexSearchTerms"%>
<%@page import="com.sgs.portlet.document_manager_index.search.DocumentManagerIndexDisplayTerms"%>
<%@page import="com.sgs.portlet.document_manager_index.search.DocumentManagerIndexSearch"%>



<%
	String tabs1 = ParamUtil.getString(renderRequest, "tabs1", "DocumentSend");
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action", "/sgs/document_manager_index/view");
	portletURL.setParameter("tabs1", tabs1);
	String portletURLString = portletURL.toString();
	request.setAttribute("portletURL", portletURL);
	
	String error_delete_document_manager_index = (String) request.getAttribute("error_delete_document_manager");
	
	ResultRow row = null;
	List<ResultRow> resultRows = null;
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
	List<AttactFileDocument> attactFileDocuments = new ArrayList<AttactFileDocument>();
	DocumentManager documentManager = null;
	long documentManagerId = 0;
	String dateNow = "";
	//String dateFrom = (String) request.getAttribute("dateFrom");
	//String dateTo= (String) request.getAttribute("dateTo");
	
	String documentManagerCodesString = "";
	String documentManagerCategorysString = "";
%>

<% if(error_delete_document_manager_index != null){ %>
	<div style="color: red"><liferay-ui:message key="not-delete-document-manager"/></div>
<%} %>
<div class="title_categ"><liferay-ui:message key="document_manager"/></div>
<div class="boxcontent">
<liferay-ui:tabs names="DocumentSend,DocumentReceived" url="<%= portletURLString %>" />
<div class="boxcontent_Tab">	
<c:choose>
	<c:when test='<%=tabs1.equals("DocumentSend") %>'>
		<form action="<%= portletURL.toString() %>"  method="post" name="<portlet:namespace />fm">
    	<div class="separator"></div>
    	<%
    	DocumentManagerIndexSearch documentManagerIndexSearch = new DocumentManagerIndexSearch(renderRequest, portletURL);
    	DocumentManagerIndexDisplayTerms displayTerms = (DocumentManagerIndexDisplayTerms)documentManagerIndexSearch.getDisplayTerms();
    	DocumentManagerIndexSearchTerms searchTerms = (DocumentManagerIndexSearchTerms) documentManagerIndexSearch.getSearchTerms();
    	
    	String orderByCol = ParamUtil.getString(renderRequest, "orderByCol", DocumentManagerIndexDisplayTerms.DOCUMENTMANAGERCODE);
    	int sortType = Sort.STRING_TYPE;
    	String orderByType = documentManagerIndexSearch.getOrderByType().toLowerCase();
    	
    	boolean reverse = false;
    	if (orderByType.equals("desc")) {
    		reverse = true;
    	} 
    	%>
		<liferay-ui:search-form	page="/html/portlet/ext/document_manager_index/document_manager_index_search_form.jsp" searchContainer="<%= documentManagerIndexSearch %>" />
		<div class="separator"></div>
				<%
				int count = DocumentManagerLocalServiceUtil.countDocumentManagerTest(searchTerms.getDocumentManagerCode(), searchTerms.getDocumentManagerCategory(), searchTerms.getDocumentManagerDescription(), searchTerms.getDocumentManagerTitle(),"send", searchTerms.getDateFrom(), searchTerms.getDateTo(), searchTerms.isAndOperator());
				List<DocumentManager> listDocumentManager = DocumentManagerLocalServiceUtil.findDocumentManagerTest(searchTerms.getDocumentManagerCode(), searchTerms.getDocumentManagerCategory(), searchTerms.getDocumentManagerDescription(), searchTerms.getDocumentManagerTitle(),"send", searchTerms.getDateFrom(), searchTerms.getDateTo(),
						documentManagerIndexSearch.getStart(), documentManagerIndexSearch.getEnd(), searchTerms.isAndOperator(), documentManagerIndexSearch.getOrderByComparator());

				for(DocumentManager dmAuto : listDocumentManager){
					documentManagerCodesString += dmAuto.getDocumentManagerCode() + "/";
					documentManagerCategorysString += dmAuto.getDocumentManagerCategory() + "/";
				}
				
				documentManagerIndexSearch.setTotal(count);
				documentManagerIndexSearch.setResults(listDocumentManager);
				portletURL.setParameter(documentManagerIndexSearch.getCurParam(), String.valueOf(documentManagerIndexSearch.getCurValue()));
				resultRows = documentManagerIndexSearch.getResultRows();
					
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
							try{
								dateNow = simpleDateFormat.format(documentManager.getDocumentManagerDateCreate());
							}catch(Exception e){
							}
							row.addText(dateNow);
						}else{
							row.addText("");
						}
						
						// category
						row.addText(documentManager.getDocumentManagerCategory());
						
						// description
						row.addText(documentManager.getDocumentManagerDescription());
						
						// title download
						String linkDocumentFile = "";
						for(AttactFileDocument attactFileDocument : attactFileDocuments){
							String title = attactFileDocument.getAttactFileDocumentPath();
								if(!attactFileDocument.getAttactFileDocumentTitle().equals("")){
									linkDocumentFile += "<a href =" + attactFileDocument.getAttactFileDocumentPath() + ">" +attactFileDocument.getAttactFileDocumentTitle().subSequence(0,attactFileDocument.getAttactFileDocumentTitle().indexOf("_")) + "</a>" + "<br>";
							}
						}
						row.addText(linkDocumentFile);
						
						resultRows.add(row);
					}
			%>
		
				<liferay-ui:search-iterator searchContainer="<%= documentManagerIndexSearch %>" />
		</form>
	</c:when>
		
	<c:when test='<%=tabs1.equals("DocumentReceived") %>'>
		<form action="<%= portletURL.toString() %>"  method="post" name="<portlet:namespace />fm">
    	<div class="separator"></div>
    	<%
    	DocumentManagerIndexSearch documentManagerIndexSearch = new DocumentManagerIndexSearch(renderRequest, portletURL);
    	DocumentManagerIndexDisplayTerms displayTerms = (DocumentManagerIndexDisplayTerms)documentManagerIndexSearch.getDisplayTerms();
    	DocumentManagerIndexSearchTerms searchTerms = (DocumentManagerIndexSearchTerms) documentManagerIndexSearch.getSearchTerms();
    	
    	String orderByCol = ParamUtil.getString(renderRequest, "orderByCol", DocumentManagerIndexDisplayTerms.DOCUMENTMANAGERCODE);
    	int sortType = Sort.STRING_TYPE;
    	String orderByType = documentManagerIndexSearch.getOrderByType().toLowerCase();
    	
    	boolean reverse = false;
    	if (orderByType.equals("desc")) {
    		reverse = true;
    	} 
    	%>
		<liferay-ui:search-form	page="/html/portlet/ext/document_manager_index/document_manager_index_search_form.jsp" searchContainer="<%= documentManagerIndexSearch %>" />
		<div class="separator"></div>
				<%
				int count = DocumentManagerLocalServiceUtil.countDocumentManagerTest(searchTerms.getDocumentManagerCode(), searchTerms.getDocumentManagerCategory(), searchTerms.getDocumentManagerDescription(), searchTerms.getDocumentManagerTitle(),"received", searchTerms.getDateFrom(), searchTerms.getDateTo(), searchTerms.isAndOperator());
				List<DocumentManager> listDocumentManager = DocumentManagerLocalServiceUtil.findDocumentManagerTest(searchTerms.getDocumentManagerCode(), searchTerms.getDocumentManagerCategory(), searchTerms.getDocumentManagerDescription(), searchTerms.getDocumentManagerTitle(),"received", searchTerms.getDateFrom(), searchTerms.getDateTo(),
						documentManagerIndexSearch.getStart(), documentManagerIndexSearch.getEnd(), searchTerms.isAndOperator(), documentManagerIndexSearch.getOrderByComparator());

				for(DocumentManager dmAuto : listDocumentManager){
					documentManagerCodesString += dmAuto.getDocumentManagerCode() + "/";
					documentManagerCategorysString += dmAuto.getDocumentManagerCategory() + "/";
				}
				
				documentManagerIndexSearch.setTotal(count);
				documentManagerIndexSearch.setResults(listDocumentManager);
				portletURL.setParameter(documentManagerIndexSearch.getCurParam(), String.valueOf(documentManagerIndexSearch.getCurValue()));
				resultRows = documentManagerIndexSearch.getResultRows();
					
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
							try{
								dateNow = simpleDateFormat.format(documentManager.getDocumentManagerDateCreate());
							}catch(Exception e){
							}
							row.addText(dateNow);
						}else{
							row.addText("");
						}
						
						// category
						row.addText(documentManager.getDocumentManagerCategory());
						
						// description
						row.addText(documentManager.getDocumentManagerDescription());
						
						// title download
						String linkDocumentFile = "";
						for(AttactFileDocument attactFileDocument : attactFileDocuments){
							String title = attactFileDocument.getAttactFileDocumentPath();
								if(!attactFileDocument.getAttactFileDocumentTitle().equals("")){
									linkDocumentFile += "<a href =" + attactFileDocument.getAttactFileDocumentPath() + ">" +attactFileDocument.getAttactFileDocumentTitle().subSequence(0,attactFileDocument.getAttactFileDocumentTitle().indexOf("_")) + "</a>" + "<br>";
							}
						}
						row.addText(linkDocumentFile);
						
						resultRows.add(row);
					}
			%>
		
				<liferay-ui:search-iterator searchContainer="<%= documentManagerIndexSearch %>" />
		</form>
	</c:when>
</c:choose>
</div>
</div>

<script type="text/javascript">
	var myCode =  "<%= documentManagerCodesString %>".split("/");
	var myCategory =  "<%= documentManagerCategorysString %>".split("/");

	jQuery("#<portlet:namespace/>documentManagerCodeAutoComplete").autocomplete({
		data : myCode
	});
	jQuery("#<portlet:namespace/>documentManagerCategoryAutoComplete").autocomplete({
		data : myCategory
	});
</script> 