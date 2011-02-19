<%@ include file="/html/portlet/ext/document_manager/init.jsp" %>
<%@ include file="/html/portlet/ext/document_manager/js/document_manager.jsp" %>

<%@page import="com.sgs.portlet.document_manager.service.DocumentManagerLocalServiceUtil"%>
<%@page import="com.sgs.portlet.document_manager.model.DocumentManager"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>

<%
	String redirect = ParamUtil.getString(request,"redirect");
	String tabs1 = ParamUtil.getString(request, "tabs1" ,"DocumentSend");
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action", "/sgs/document_manager/view");
	portletURL.setParameter("tabs1", tabs1);
	String portletURLString = portletURL.toString();
	
	List<DocumentManager> documentManagers = DocumentManagerLocalServiceUtil.getDocumentManagers(-1,-1);
	String documentManagerCode = (String) request.getAttribute("documentManagerCode");
	String documentManagerCategory = (String) request.getAttribute("documentManagerCategory");
	String documentManagerDescription = (String) request.getAttribute("documentManagerCategory");
	String documentManagerStyle = (String) request.getAttribute("documentManagerStyle");
	String duplicateDocumentManagerCode = (String) request.getAttribute("duplicate_document_manager_code");
%>

<% if(duplicateDocumentManagerCode != null){ %>
	<div style="color: red"><liferay-ui:message key="not-add-document-manager"/></div>
<%} %>

<liferay-ui:tabs names="DocumentSend,DocumentReceived" url="<%= portletURLString %>" />

<div class="separator"></div>

<portlet:actionURL var="add_document_manager">
	<portlet:param name="struts_action" value="/sgs/document_manager/view" />
	<portlet:param name="varAction" value="documentManagerSend" />
	<portlet:param name="tabs1" value="DocumentSend" />
	<portlet:param name="<%=Constants.CMD %>" value="<%=Constants.ADD %>" />
	<portlet:param name="redirect" value="<%=redirect %>" />
</portlet:actionURL>

<form action="<%=add_document_manager%>" enctype="multipart/form-data" method="post" name="<portlet:namespace/>fm">
<table>
	<tr>
		<td><liferay-ui:message key="document-manager-code" /></td>
		<td><input type="text" size="50" name="<portlet:namespace/>documentManagerCode" value="<%= (documentManagerCode != null) ? documentManagerCode : "" %>"></td>
	</tr>
	<tr>
		<td><liferay-ui:message key="document-manager-category" /></td>
		<td><input type="text" size="50" name="<portlet:namespace/>documentManagerCategory" value="<%= (documentManagerCategory != null) ? documentManagerCategory : "" %>"></td>
	</tr>
	<tr>
		<td><liferay-ui:message key="document-manager-style" /></td>
		<td>
		<input type="radio" name="<portlet:namespace/>documentManagerStyle" checked="checked" value="send"> <liferay-ui:message key="document-manager-send" />
		<input type="radio" name="<portlet:namespace/>documentManagerStyle" value="received" <%=(documentManagerStyle != null && documentManagerStyle.equals("received")) ? "checked" : ""  %>> <liferay-ui:message key="document-manager-received" />
		</td>
	</tr>
	<tr>
		<td><liferay-ui:message key="document-manager-description" /></td>
		<td><textarea name="<portlet:namespace/>documentManagerDescription" style="width: 100%"><%= (documentManagerDescription != null) ? documentManagerDescription : "" %></textarea></td>
	</tr>
</table>	
<div class="separator"></div>
<fieldset class="filborder">
		<legend class="laborder"><liferay-ui:message key="document-manager-send"/></legend>
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

<input type="submit" value='<liferay-ui:message key="add-document-manager"/>' onclick="return checkValidate()">
<a href="<%=redirect %>"><input type="button" value='<liferay-ui:message key="back"/>'></a>
</form>