<%@ include file="/html/portlet/ext/pcccdocumentreceiptprocess/js/changeselectboxvalue.jsp" %>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.sgs.portlet.document.receipt.util.DocumentReceiptUtil"%>

<script type="text/javascript" src="/html/js/calendar.js"></script>
<script type="text/javascript" src="/html/js/calendar-setup.js"></script>
<script type="text/javascript"	src="/html/js/calendar-en.js"></script>
<link type="text/css" rel="stylesheet"	href="/html/css/calendar-system.css" />

<portlet:actionURL var="form">
</portlet:actionURL>
<%
	User loginUser = PortalUtil.getUser(renderRequest);
	String loginName = loginUser.getLastName() + " " + loginUser.getMiddleName() + " " + loginUser.getFirstName();
%>
<form name="<portlet:namespace />form>" action="<%=form%>" enctype="multipart/form-data" method="post" onsubmit="return fileUpload();">
<div class="title_categ"><liferay-ui:message key="document_process" /> - <liferay-ui:message key="thongtingopy" /></div>
<div class="boxcontent">
<table width="100%" cellspacing="0">
  <tr>
    <td width="15%"><liferay-ui:message key="document_processor" />&nbsp;:</td>
    <td width="35%"><input name="processor" style="width: 90%" readonly="readonly" type="text" value="<%= loginName %>"/></td>
    <td width="15%"><liferay-ui:message key="date" />&nbsp;:</td>
    <td>
    	<input type="text" style="width: 80%" readonly="readonly" name="<portlet:namespace/>expectedReturningDate" id="expectedReturningDate" value='<%=DocumentReceiptUtil.formatDate(new Date(), "dd/MM/yyyy") %>'>
		<img align="top" id="cal-button-expectedReturningDate" src="/html/images/cal.gif" onclick="callCalendar('expectedReturningDate','cal-button-expectedReturningDate')"/></td>
  </tr>
  <tr>
    <td><liferay-ui:message key = "content-process" />&nbsp;:</td>
    <td colspan="3">
    	<textarea name="<portlet:namespace/>processInformation" id="processInformation" style="width: 96%" rows="5"></textarea>    
    </td>

  </tr>
</table>
<fieldset class="filborder">
	<label class="laborder"><liferay-ui:message key="document_attached_file" /></label>
		<table id="attFile" class="taglib-search-iterator table-pml" cellspacing="0" width="100%">	
			<tr class="portlet-section-header results-header" >	
			   	<td><liferay-ui:message key="document_attached_file_title" /></td>
			    <td width="50%"><liferay-ui:message key="document_attached_file_name" /></td>
			    <td width="15%" align="center"><input style="width: 90%" type="button" value='<liferay-ui:message key="document_more_file" />' onclick="insDocumentReceiptRow()"></td>
		   </tr>
		 </table>
		 <input type="hidden" name="<portlet:namespace/>manyFile" id="manyFile" value="" />
		 <input type="hidden" name="<portlet:namespace/>valueManyFile" id="valueManyFile" value="" />
		 <input type="hidden" name="<portlet:namespace/>titleManyFile" id="titleManyFile" value="" />
</fieldset>

<div align="right" id="table-button">
      <liferay-util:include page="/html/portlet/ext/pcccdocumentreceiptprocess/common/taskAction.jsp"></liferay-util:include>
      <input type="button" onclick="window.history.back()" name="back" id="back" value='<liferay-ui:message key="citymanagement.button-back" />'>    
</div>
</div>
</form>