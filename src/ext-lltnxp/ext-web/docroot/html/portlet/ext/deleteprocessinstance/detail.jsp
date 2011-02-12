<%@ include file="/html/portlet/ext/deleteprocessinstance/init.jsp" %>

<link type="text/css" rel="stylesheet"	href="/html/css/calendar-system.css" />
<link type="text/css" rel="stylesheet" href="/html/portlet/ext/pcccdocumentsendprocess/css/letter.css" />

<%@page import="com.sgs.portlet.document.workflow.DocumentReceiptPortletAction"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.sgs.portlet.department.model.Department"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.sgs.portlet.document.send.dto.DocumentSendDTO"%>
<%@page import="com.sgs.portlet.document.receipt.dto.PmlEdmDocumentReceiptDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.sgs.portlet.pcccdocumentsend.dto.DocumentSendLogDTO"%>
<%@page import="com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>

<%
	DocumentSendDTO sendDTO = (DocumentSendDTO) renderRequest.getAttribute("documentDTO");
	if (sendDTO == null) {
		System.out.println("Khong xac dinh duoc doi tuong!");
		return;
	}
	PmlEdmDocumentReceipt receiptDTO = (PmlEdmDocumentReceipt) renderRequest.getAttribute("documentReceipt");
	String department = (String) renderRequest.getAttribute("department");
	String soCongVanDiHientai = (String) renderRequest.getAttribute("soCongVanDiHientai");
	String redirect = ParamUtil.getString(renderRequest, "redirect");
	
%>
<div id="divparent">
<form action="" enctype="multipart/form-data" method="post">
<div id="div-head-title"><liferay-ui:message key="pcccdocumentsend-chitiet"/></div>
<fieldset>	
<legend class="legend-noborder"><liferay-ui:message key="pcccdocumentsend-chitiet"/></legend>
<table width="100%" cellpadding="0" cellspacing="0">
<tr>
	<td width="15%" class="td-left"><label><liferay-ui:message key="pccc-cvdtn-socongvandencuaphong"/><label></td>
		<td width="35%" class="td-right"><%= soCongVanDiHientai %></td>
		<td width="15%" class="td-left"></td>
		<td width="35%" class="td-left"></td>
	</tr>
	<tr>
		<td class="td-left"><label><liferay-ui:message key="receipt.senddate"/>:</label></td>
		<td class="td-right"><%= (null != sendDTO.getIssuingDate() ? new SimpleDateFormat("dd/MM/yyyy").format(sendDTO.getIssuingDate()) : "") %></td>
	    <td class="td-left"><label><liferay-ui:message key="receipt.doctype"/>:</label></td>
	    <td class="td-right"><%=sendDTO.getDocumentType() %></td>
	</tr>
	<tr>
		<td class="td-left"><label><liferay-ui:message key="receipt.issuingdate"/>:</label></td>
		<td class="td-right"><%= (null != sendDTO.getIssuingDate() ? new SimpleDateFormat("dd/MM/yyyy").format(sendDTO.getIssuingDate()): "") %></td>
		<td class="td-left"><label><liferay-ui:message key="receipt.confidentallevelid"/>:</label></td>
		<td class="td-right"><%=sendDTO.getConfidentialLevel() %></td>
	</tr>
	<tr>
		<td class="td-left"><label><liferay-ui:message key="receipt.creator"/>:</label></td>
		<td class="td-right"><%=sendDTO.getEditor() %></td>
		<td class="td-left"><label><liferay-ui:message key="receipt.previlegenlevelid"/>:</label></td>
		<td class="td-right"><%=sendDTO.getPrivilegel() %></td>
	</tr>
	<tr>
		<td class="td-left" valign="top"><label><liferay-ui:message key="pccc-cvdtn-hosocongviec"/>:</label></td>
	 <td class="td-right">
		 <div class="cvd-filedinhkem" style="width: 99%;background-color: white;">
			 <logic:iterate id="pmlHoSoCongViec" name="pmlHoSoCongViecList" indexId="i" type="com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec"  >
				<table >
				<tr>			
					<td class="td-right"><span id="stt">- &nbsp;</span><%= pmlHoSoCongViec.getTieuDe() %></td>
				</tr>
				</table>
	        </logic:iterate>
		 </div>	 
	 </td>
	<td class="td-left" width="15%" nowrap="nowrap">
			<label><liferay-ui:message key="receipt.docrectype"/>:</label>
	</td>
	    <td class="td-right" width="35%"><%=sendDTO.getDocumentRecord() %></td>
	</tr>
	<tr>
		<td class="td-left"><label><liferay-ui:message key="receipt.department"/>:</label></td>
	<td class="td-right"><%=department %></td>
		<td class="td-left" rowspan="4" valign="top">
			<label><liferay-ui:message key="receipt.briftcontent"/>:</label></td>
	    <td rowspan="4" class="td-right">
	    	<textarea class="textarea-display" onMouseover="this.style.backgroundColor='white';" readonly="" rows="6"><%=sendDTO.getBriefContent() %></textarea>
	    </td>
	</tr>
	<tr>
		<td class="td-left"><label><liferay-ui:message key="receipt.receiveplace"/>:</label></td>
	<td class="td-right"><%=sendDTO.getReceivingPlace() %></td>
		<td></td>
		<td></td>
	</tr>
	<tr>
		<td valign="top" class="td-left">
			<label><liferay-ui:message key="receipt.signer"/>:</label></td>
		<td class="td-right"><%=sendDTO.getSigner() %></td>
		<td></td>
		<td></td>
	</tr>
	<tr>
		<td valign="top" class="td-left">
				<label><liferay-ui:message key="receipt.position"/>:</label></td>
		<td class="td-right"><%=sendDTO.getPosition() %></td>
		<td></td>
		<td></td>
	</tr>
	<tr>
		<td valign="top" class="td-left">
				<label><liferay-ui:message key="receipt.docid"/>:</label></td>
		<td class="td-right"><%=sendDTO.getDocumentSendCode() %></td>
			<td class="td-left">
				<label><liferay-ui:message key="receipt.attachedfiles"/>:</label></td>
		<td class="td-right">
			<logic:iterate id="attachedFile" name="attachedFiles" indexId="i" type="com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile" scope="request" >
				<u><a href="<%=attachedFile.getPath() %>" style="text-decoration:none;"><%=(attachedFile.getTitle())%></a></u> <br/> 
			</logic:iterate>
		</td>
	</tr>
	<tr>
		<td valign="top" class="td-left"><label><liferay-ui:message key="receipt.page"/>:</label></td>
	<td class="td-right"><%=sendDTO.getNumberPage() %></td>
		<td class="td-left">
			<label><liferay-ui:message key="pccc-cvdtn-cocongvanphucdap"/>:</label></td>
	<td class="td-right">
		<%
			if (sendDTO.isIscongvanphucdap()) {
				%>
				<liferay-ui:message key='pccc-cvdtn-co'/>
			<% 
			}
			else {
				%>
				<liferay-ui:message key='pccc-cvdtn-khong'/>
				<%
			}
			
		%> 
	</td>	
</tr>
</table>
<%
  	if (receiptDTO != null) {
%>
<fieldset>
<legend class="legend-noborder"><liferay-ui:message key="pcccdocumentsend-traloichocongvanden"/></legend>
<div>
<table  style="border:solid 1px #F4F4F4;" >
<tr>
		<td valign="top" class="td-left" width="35%">
			<label><liferay-ui:message key="pcccdocumentsend-sohieucongvanden"/></label></td>
    <td class="td-right"><%=receiptDTO.getDocumentReference() %></td>
	</tr>
	<tr>
	    <td valign="top" class="td-left">
	    	<label><liferay-ui:message key="pcccdocumentsend-socongvannoibo"/></label></td>
    <td class="td-right"><%=receiptDTO.getNumberLocalDocumentReceipt()%></td>
	</tr>
	<tr>
		<td valign="top" class="td-left">
			<label><liferay-ui:message key="pcccdocumentsend-trichyeu"/></label></td>
	<td class="td-right"><%=receiptDTO.getBriefContent() %></td>
	</tr>
	<tr>
	    <td valign="top" class="td-left">
	    	<label><liferay-ui:message key="pcccdocumentsend-taptindinhkem"/></label></td>
    <td class="td-right">
	    <logic:iterate id="attachedFileReceiver" name="attachedFileReceivers" indexId="j" type="com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile" scope="request" >
	    	<u><a href="<%=attachedFileReceiver.getPath() %>"><%= attachedFileReceiver.getTitle() %></a></u> <br/>
		</logic:iterate>
    </td>
</tr>
</table>
</div>
</fieldset>
<%
	} 
%>
<br/>
<fieldset>
<legend class="legend-noborder"><liferay-ui:message key="pcccdocumentsend-quatrinhluanchuyencongvanden"/></legend>
<div>
<table cellpadding="0" cellspacing="0" border="0" width="100%">
<tr>
	<td>
	<table cellpadding="0" cellspacing="0" width="100%" class="tab-doc-process-list-base">
	<tr height="28px" align="center" valign="middle" class="title-tran-header">
		<td style="width: 4%" class="td-stt-pml"><liferay-ui:message key="pccc-TN-stt"/></td>
		<td style="width: 20%" class="td-stt-pml"><liferay-ui:message key="pcccdocumentsend-donvicanhangui"/></td>
		<td style="width: 15%" class="td-stt-pml"><liferay-ui:message key="pccc-XL-ngaygui"/></td>
		<td style="width: 26%" class="td-stt-pml"><liferay-ui:message key="pcccdocumentsend-yeucauxuly"/></td>
		<td style="width: 20%" class="td-stt-pml"><liferay-ui:message key="pcccdocumentsend-donvicanhannhan"/></td>
		<td style="width: 15%" class="td-stt-pml"><liferay-ui:message key="pccc-TN-ngaynhan"/></td>						
	</tr>
	<%
		List<DocumentSendLogDTO> pmlDocumentSendLogList = (List<DocumentSendLogDTO>)renderRequest.getAttribute("pmlDocumentSendLogList");
			for (int i =  0; i < pmlDocumentSendLogList.size(); i++) {
			DocumentSendLogDTO pmlDocumentSendLog = pmlDocumentSendLogList.get(i);
	%>
	<tr style="height: 25px" class="<%=(i % 2) == 0 ? "rowOne" : "rowTwo" %>">
					<td style="text-align: right;"><%= i+1%>.</td>
					<td><%=pmlDocumentSendLog.getProcessor() %></td>
					<td><%=pmlDocumentSendLog.getDateProcess() != null ? new SimpleDateFormat("dd/MM/yyyy").format(pmlDocumentSendLog.getDateProcess()) : ""%></td>
					<td><%=pmlDocumentSendLog.getProcessInformation() %></td>
					<td><%=pmlDocumentSendLog.getReceiver() %></td>
					<td><%=pmlDocumentSendLog.getReceiverDate() != null ? new SimpleDateFormat("dd/MM/yyyy").format(pmlDocumentSendLog.getReceiverDate()) : "" %></td>
	</tr>
	<%
			}
	%>	
	</table>
	</td>
</tr>
</table>
</div>
</fieldset>
</fieldset>
	<table id="table-button">
	<tr>
		<td>
			<span onclick="javascript:submitForm(document.hrefFm,'<%= redirect %>');" >
				<input class="button-width" type="button" value='<liferay-ui:message key="back" />'>
			</span>
		</td>
	</tr>
	</table>
</form>  
</div>