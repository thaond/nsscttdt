<%@ include file="/html/portlet/ext/document_manager/init.jsp" %>
<%@ include file="/html/portlet/ext/document_manager/js/document_manager.jsp" %>

<%@page import="javax.portlet.WindowState"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>

<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.sgs.portlet.document_manager.service.DocumentManagerLocalServiceUtil"%>
<%@page import="com.sgs.portlet.document_manager.model.AttactFileDocument"%>
<%@page import="com.sgs.portlet.document_manager.model.DocumentManager"%>

<%
	String redirect = ParamUtil.getString(request,"redirect");
	String tabs1 = ParamUtil.getString(request, "tabs1" ,"DocumentSend");
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action", "/sgs/document_manager/view");
	portletURL.setParameter("tabs1", tabs1);
	String portletURLString = portletURL.toString();
	
	DocumentManager documentManager = (DocumentManager) request.getAttribute("documentManager");
	List<AttactFileDocument> attactFileDocuments = new ArrayList<AttactFileDocument>();
	if(documentManager != null){
		attactFileDocuments = DocumentManagerLocalServiceUtil.getAttactFileDocuments(documentManager.getDocumentManagerId());
	}
	String linkAttactFile = "";
	
%>

<liferay-ui:tabs names="DocumentSend,DocumentReceived" url="<%= portletURLString %>" />

<div class="separator"></div>

<portlet:actionURL var="edit_document_manager">
	<portlet:param name="struts_action" value="/sgs/document_manager/view" />
	<portlet:param name="varAction" value="documentManagerSend" />
	<portlet:param name="tabs1" value="DocumentSend" />
	<portlet:param name="<%=Constants.CMD %>" value="<%=Constants.UPDATE %>" />
	<portlet:param name="redirect" value="<%=redirect %>" />
</portlet:actionURL>

<% if(documentManager != null){ %>
<form action="<%=edit_document_manager%>" enctype="multipart/form-data" method="post" name="<portlet:namespace/>fm">
<input type="hidden" name="<portlet:namespace/>documentManagerId" value="<%=documentManager.getDocumentManagerId()%>">
<input type="hidden" name="<portlet:namespace/>attactFileDocumentId" value="">
<table>
	<tr>
		<td><liferay-ui:message key="document-manager-code" /></td>
		<td><input type="text" size="50" name="<portlet:namespace/>documentManagerCode" value="<%= documentManager.getDocumentManagerCode() %>"></td>
	</tr>
	<tr>
		<td><liferay-ui:message key="document-manager-category" /></td>
		<td><input type="text" size="50" name="<portlet:namespace/>documentManagerCategory" value="<%= documentManager.getDocumentManagerCategory() %>"></td>
	</tr>
	<tr>
		<td><liferay-ui:message key="document-manager-style" /></td>
		<td>
		<input type="radio" name="<portlet:namespace/>documentManagerStyle" checked="checked" value="send"> <liferay-ui:message key="document-manager-send" />
		<input type="radio" name="<portlet:namespace/>documentManagerStyle" value="received" <%=(documentManager.getDocumentManagerStyle().equals("received")) ? "checked" : ""  %>> <liferay-ui:message key="document-manager-received" />
		</td>
	</tr>
	<tr>
		<td><liferay-ui:message key="document-manager-description" /></td>
		<td><textarea name="<portlet:namespace/>documentManagerDescription" style="width: 100%"><%= documentManager.getDocumentManagerDescription() %></textarea></td>
	</tr>
</table>		

<fieldset class="filborder">
		<label class="laborder"><liferay-ui:message key="document-manager-send"/></label>
		<% 	for(AttactFileDocument attactFileDocument : attactFileDocuments){
			String path = attactFileDocument.getAttactFileDocumentPath();
			String title = (String)attactFileDocument.getAttactFileDocumentTitle().subSequence(0,attactFileDocument.getAttactFileDocumentTitle().indexOf("_"));
			long attactFileDocumentId = attactFileDocument.getAttactFileDocumentId();
			String deleteAction = "<a  href='javascript: ;' onclick=deleteConfirm('"+ attactFileDocumentId +"')><u>"+ "<img src='/html/images/delete.png'/>" +"</u></a>";
				if(!attactFileDocument.getAttactFileDocumentTitle().equals("")){
					linkAttactFile = "<a href =" + path + ">" + title + "</a>" + deleteAction;
				}
		%>
			<%=linkAttactFile %>
		<% }%>
		<table id="addfileupload" class="taglib-search-iterator table-pml" cellspacing="0" width="100%">	
			<tr class="portlet-section-header results-header" >
		   		<td><liferay-ui:message key="document-title-name-file" /></td>
		    	<td width="50%"><liferay-ui:message key="document-manager-name-file" /></td>
				<td width="15%" align="center"><input type="button" value='<liferay-ui:message key="add-document-manager-file" />' onclick="uploadResultFile()"></td>
			</tr>
		</table>
		
		 <input type="hidden" name="<portlet:namespace/>nameFieldRow" id="nameFieldRow" value="" />
		 <input type="hidden" name="<portlet:namespace/>nameFiles" id="nameFiles" value="" />
		 <input type="hidden" name="<portlet:namespace/>titleFiles" id="titleFiles" value="" />
</fieldset>

<br>

<input type="submit" value='<liferay-ui:message key="edit-document-manager"/>' onclick="return checkValidate()">
<a href="<%=redirect %>>"><input type="button" value='<liferay-ui:message key="back"/>'></a>
</form>
<%} %>


<script type="text/javascript">
	function deleteConfirm(attactFileDocumentId) {
		document.<portlet:namespace/>fm.<portlet:namespace/>attactFileDocumentId.value = attactFileDocumentId;
		if (confirm("<liferay-ui:message key='ban-co-that-su-muon-xoa'/>")) {
			sendDelete();
		}
	}
	function sendDelete(){
		submitForm(document.<portlet:namespace/>fm,
			"<portlet:actionURL windowState="<%=WindowState.NORMAL.toString()%>">
			<portlet:param name="struts_action" value="/sgs/document_manager/view" />
			<portlet:param name="tabs1" value="DocumentSend" />
			<portlet:param name="varAction" value="attactFileDocument" />
			<portlet:param name="tab" value="edit_document_manager" />
			<portlet:param name="redirect" value="<%=redirect%>" />
			<portlet:param name="documentManagerId" value="<%=String.valueOf(documentManager.getDocumentManagerId())%>" />
			<portlet:param name="<%=Constants.CMD%>" value="<%=Constants.DELETE%>" />
			</portlet:actionURL>");
	}
</script>
