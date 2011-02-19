<%@ include file="/html/portlet/ext/pcccdocumentsend//init.jsp" %>
<%@ include file="/html/portlet/ext/pcccdocumentsend/js/pccc-documentsend.jsp" %>
<%@page import="com.sgs.portlet.document.workflow.DocumentReceiptPortletAction"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.sgs.portlet.department.model.Department"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.sgs.portlet.document.workflow.DocumentSendPortletAction"%>
<%@page import="com.sgs.portlet.position.model.Position"%>
<link type="text/css" rel="stylesheet"	href="/html/css/calendar-system.css" />
<script type="text/javascript" src="/html/js/calendar.js"></script>
<script type="text/javascript"	src="/html/js/calendar-setup.js"></script>
<script type="text/javascript"	src="/html/js/calendar-en.js"></script>
<script type="text/javascript" >
window.onload = function () {
	changeDocumentRecordType();
	document.getElementById('sohieucvdtn').focus();	
}
</script>
<portlet:actionURL var="add">
	<portlet:param name="struts_action" value="/sgs/pcccdocumentsend/view" />
	<portlet:param name="workflowAction" value="true"/>
	<portlet:param name="workflowActionName" value='<%=DocumentSendPortletAction.COMMAND_PREFIX + ".AddDocumentSendCommand"%>'/>
</portlet:actionURL>

<form action="<%=add %>" enctype="multipart/form-data" onsubmit="return validateSendDocReceipt()" method="post">
<div class="title_categ"><liferay-ui:message key="receipt.summary"/></div>
<div class="boxcontent">
<table width="100%" cellspacing="0">
<tr>
    <td width="16%"><div align="left"><liferay-ui:message key="receipt.docref"/><font color="#FF0000" size="1">(*)</font>&nbsp;:</div></td>
    <td width="34%">
   	 	<input type="text" style="width:90%" maxlength="30" name="<portlet:namespace/>documentReference" id="sohieucvdtn" >    
    </td>
      
    <td width="16%"><div align="left"><liferay-ui:message key="receipt.docrectype"/><font color="#FF0000" size="1">(*)</font>&nbsp;:</div></td>
    
    <td>
		<select name="<portlet:namespace/>documentRecordTypeId" id="socongvancvdtn" style="width:61%" onchange="changeDocumentRecordType()">
        	<logic:iterate id="pmlEdmDocumentRecordType" name="pmlEdmDocumentRecordTypeList" type="com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType" scope="request">
      			<option value="<%= pmlEdmDocumentRecordType.getDocumentRecordTypeId() %>"> <%= pmlEdmDocumentRecordType.getDocumentRecordTypeName() %> </option>
      		</logic:iterate>
      	</select>    	      	
    </td>
  </tr>
  <tr>
    <td ><div align="left"><liferay-ui:message key="receipt.senddate"/> &nbsp;: </div></td>
    <td>
   		<input  type="text" name="<portlet:namespace/>sendDate" id="ngayguicvdtn" value='<%=new java.text.SimpleDateFormat("dd/MM/yyyy").format( new Date().getTime()) %>' style="width:80%">
	    <span style="cursor: pointer"><img align="top" id="cal-button-issuingDate" src="/html/images/cal.gif" onclick="callCalendar('ngayphathanhcvdtn','cal-button-issuingDate')"/></span>
    </td>
    
    <td><div align="left"><liferay-ui:message key="receipt.doctype"/><font color="#FF0000" size="1">(*)</font>&nbsp;:</div></td>
    <td>
    	<select name="<portlet:namespace/>documentTypeId" id="loaicongvancvdtn" style="width:99%" >	    	
	    </select>
    </td>
  </tr>
	  <tr>
	    <td><div align="left"><liferay-ui:message key="receipt.issuingdate"/>&nbsp;:</div></td>
	    <td>
	    	<input type="text" name="<portlet:namespace/>issuingDate" id="ngaybanhanhcvdtn" value='<%=new java.text.SimpleDateFormat("dd/MM/yyyy").format( new Date().getTime()) %>' style="width:80%">
	   		<span style="cursor: pointer"><img align="top" id="cal-button-dateArrive" src="/html/images/cal.gif" onclick="callCalendar('ngaydencvdtn','cal-button-dateArrive')"/></span>
	     </td>
	    <td><div align="left"><liferay-ui:message key="receipt.confidentallevelid"/><font color="#FF0000" size="1">(*)</font>&nbsp;:</div></td>
	    <td>
	    	<select name="<portlet:namespace/>confidentialLevelId" id="domatcvdtn" style="width:99%">
	      		<logic:iterate id="pmlEdmConfidentialLevel" name="pmlEdmConfidentialLevelList" type="com.sgs.portlet.document.receipt.model.PmlEdmConfidentialLevel" scope="request">
			      	<option value="<%= pmlEdmConfidentialLevel.getConfidentialLevelId() %>"> <%= pmlEdmConfidentialLevel.getConfidentialLevelName() %> </option>
			    </logic:iterate>
	    	</select>
	    </td>
	  </tr>
	  <tr>
		    <td><div align="left"><liferay-ui:message key="receipt.creator"/>: </div></td>
		    <td><input style="width:90%" type="text" maxlength="50" readonly="readonly" name="<portlet:namespace/>editorId" id="nguoitaocvdtn" value='<%= ((User) renderRequest.getAttribute("user")).getScreenName() %>'></td>
		    
		    <td><div align="left"><liferay-ui:message key="receipt.previlegenlevelid"/><font color="#FF0000" size="1">(*)</font>&nbsp;:</div></td>
		    <td>
		    	<select name="<portlet:namespace/>privilegenLevelId" id="dokhancvdtn" style="width:99%">
	        		<logic:iterate id="pmlEdmPrivilegeLevel" name="pmlEdmPrivilegeLevelList" type="com.sgs.portlet.document.receipt.model.PmlEdmPrivilegeLevel" scope="request">
			      		<option value="<%= pmlEdmPrivilegeLevel.getPrivilegeLevelId() %>"> <%= pmlEdmPrivilegeLevel.getPrivilegeLevelName() %> </option>
			      	</logic:iterate>
	     	 	</select>
		    </td>
		  </tr>
	  <tr>
	    <td><div align="left"><liferay-ui:message key="receipt.department"/>:</div></td>
	    <td><input style="width:90%" type="text" maxlength="50" readonly="readonly" name="<portlet:namespace/>department" id="dept" value='<%= ((Department) renderRequest.getAttribute("department")).getDepartmentsName() %>'>  
	    </td>
	    <td><liferay-ui:message key="receipt.position"/></td>
	    <td><input type="text" style="width:95%" maxlength="50" name="<portlet:namespace/>position" id="position" ></td>
  </tr>
  <tr>
	    <td><div align="left"><liferay-ui:message key="receipt.receiveplace"/><font color="#FF0000" size="1">(*)</font>&nbsp;:</div></td>
	    <td>
	    	<input type="text" name="<portlet:namespace/>receivingPlace" id="receiveplace"  style="width:72.5%">
	    	<input type="hidden" id="issuingPlaceId"  name="<portlet:namespace />issuingPlaceId" style="width: 15%">
	   		<span style="cursor: pointer">
	   			<input id="btn_receiveplace" type="button" value="..."  onclick="mypopupIssuingplace()" style="width:15%">
	   		</span>
	    </td>
	    <td><liferay-ui:message key="receipt.signer"/></td>
		<td>
			<input type="text" name="<portlet:namespace/>signerName" id="signer" style="width:73%%">	
		   	 <input type="hidden" id="signerId"  name="<portlet:namespace />signerId" >
		   	 <span style="cursor: pointer">
		   			<input  id="btn_signer" type="button" value="..."  onclick="mypopupSigner()" style="width:15%">
	   		 </span>			  
		</td>    
  </tr>
   <tr>
	    <td valign="top"><div align="left"><liferay-ui:message key="receipt.docid"/>:</div></td>
	    <td><input type="text" maxlength="45" name="<portlet:namespace/>documentSendCode" id="docid" style="width:90%">
	    </td>
	     <td><liferay-ui:message key="receipt.page"/></td>
	    <td>
	    	<input style="width:95%" type="text" maxlength="50" name="<portlet:namespace/>numberPage" id="page" >
	    </td>
  </tr>
  <tr>
	    <td valign="top"><div align="left"><liferay-ui:message key="receipt.issuingnum"/>:</div></td>
	    <td><input type="text" style="width:95%" maxlength="30" name="<portlet:namespace/>numberPublist" id="issuingnum" ></td>
	    <td></td>
	    <td></td>
  </tr>
  <tr>
	    <td><div align="left"><liferay-ui:message key="receipt.briftcontent"/><font color="#FF0000" size="1">(*)</font>&nbsp;:</div></td>
	    <td colspan="3"><textarea name="<portlet:namespace/>briefContent" id="trichyeucvdtn" rows="5" style="width:98%"></textarea></td>
  </tr>
</table>

<br>
<fieldset class="filborder">
<legend class="laborder"><liferay-ui:message key="document_attached_file" /></legend>
<table id="addfileupload" class="taglib-search-iterator table-pml" cellspacing="0" width="100%">	
	<tr class="portlet-section-header results-header" >
		   	<td ><liferay-ui:message key="document_attached_file_title" /></td>
		    <td width="50%"><liferay-ui:message key="document_attached_file_name" /></td>
		    <td width="15%" align="center"><input style="width: 90%" type="button" value='<liferay-ui:message key="document_more_file" />' onclick="uploadReceiptfile()"></td>
		    
	</tr>
		 
		 <input type="hidden" name="<portlet:namespace/>nameFieldRow" id="nameFieldRow" value="" />
		 <input type="hidden" name="<portlet:namespace/>nameFiles" id="nameFiles" value="" />
		 <input type="hidden" name="<portlet:namespace/>titleFiles" id="titleFiles" value="" />
		 <input type="hidden" name="<portlet:namespace/>userId" id="userId" value="<%=PortalUtil.getUserId(renderRequest) %>" />
</table>
</fieldset>
	
	<portlet:renderURL var="redirect">
		<portlet:param name="struts_action" value="/sgs/pcccdocumentsend/view"/>
	</portlet:renderURL>
	<input type="hidden" name="<portlet:namespace/>redirect" value="<%=redirect%>" />	
	<br/>
<div align="right">
		    	
		        <input type="submit"  value='<liferay-ui:message key="pccc-cvdtn-luu" />'>
		        <input type="reset" value='<liferay-ui:message key="receipt.cancel" />'>
		        <input type="button" onclick="window.history.back()" value='<liferay-ui:message key="pccc-cvdtn-trove" />'>	
</div>
   
</div>  
</form>
<%
	String message = (String) renderRequest.getAttribute("message");
	if ("true".equals(message)) {
%>
		<script type="text/javascript" >
			alert("<liferay-ui:message key='pccc-TN-themmoicongvanthanhcong'/>");
		</script>
<%
	} else if ("false".equals(message)) {
%>
		<script type="text/javascript" >
			alert("<liferay-ui:message key='pccc-TN-themmoicongvanthanhcong'/>");
		</script>
<%
	}
%>