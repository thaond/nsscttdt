<%@ include file="/html/portlet/ext/pcccdocumentsend/init.jsp" %>
<liferay-util:include page="/html/portlet/ext/pcccdocumentsendprocess/js/pccc-documentsend.jsp"></liferay-util:include>
<link type="text/css" rel="stylesheet" href="/html/portlet/ext/pcccdocumentsendprocess/css/letter.css" />
<%@page import="com.sgs.portlet.document.workflow.DocumentReceiptPortletAction"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.sgs.portlet.department.model.Department"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.sgs.portlet.document.workflow.DocumentSendPortletAction"%>
<%@page import="com.sgs.portlet.position.model.Position"%>
<%@page import="com.sgs.portlet.document.send.dto.DocumentSendDTO"%>
<script type="text/javascript"	src="/html/js/calendar.js"></script>
<script type="text/javascript"	src="/html/js/calendar-setup.js"></script>
<script type="text/javascript"	src="/html/js/calendar-en.js"></script>
<script type='text/javascript' src='/html/js/liferay/localdata.js'></script>
<script type='text/javascript' src='/html/js/liferay/jquery.js'></script>
<script type='text/javascript' src='/html/js/liferay/jquery.autocomplete.js'></script>
<link rel="stylesheet" type="text/css" href="/html/css/main.css" />
<link rel="stylesheet" type="text/css" href="/html/css/jquery.autocomplete.css" />
<script type="text/javascript" >
window.onload = function () {
	//document.getElementById('sohieucvdtn').focus();
	changeDocumentRecordTypeUpdate();	
}
</script>

<script type="text/javascript">
$().ready(function() {
	jQuerythoind("#receiveplace").autocomplete(noiNhan, {
		multiple: true,
		minChars: 0,
		matchContains: true,
		autoFill: true}
		);
	jQuerythoind("#signer").autocomplete(nguoiKy, {		
		minChars: 0,
		autoFill: true});	
});
</script>
<link type="text/css" rel="stylesheet"	href="/html/css/calendar-system.css" />
<%
	DocumentSendDTO documentDTO = (DocumentSendDTO) renderRequest.getAttribute("documentDTO");
	String departmentName = (String) renderRequest.getAttribute("departmentName");
	int countHSCVChoice = Integer.parseInt(renderRequest.getAttribute("countHSCVChoice").toString());
	String redirect = ParamUtil.getString(renderRequest, "redirect");	
%>

<portlet:actionURL var="update">
	<portlet:param name="struts_action" value="/sgs/pcccdocumentsendprocess/updatesearch" />
	<portlet:param name="documentSendId" value='<%="" + documentDTO.getDocumentSendId() %>'/>
</portlet:actionURL>

<form autocomplete="off" action="<%= update %>" enctype="multipart/form-data" method="post" onsubmit="return checkUpdateform()">
<div class="title_categ"><liferay-ui:message key="pccc-cvdtn-suacongvan"/></div>
<div class="boxcontent">
<table width="100%" cellspacing="0">
	<tr>
	<td width="18%" ><liferay-ui:message key="receipt.creator"/>&nbsp;:</td>
    <td width="35%">
	    <input style="width: 90%" type="text" readonly="readonly" name="<portlet:namespace/>editorId" id="nguoitaocvdtn" value="<%=documentDTO.getEditor() %>">
    </td>
    <td width="15%" ><liferay-ui:message key="receipt.docrectype"/><font color="#FF0000" size="1">(*)</font>&nbsp;:</td>
    <td>
    	<select style="width: 99%" name="<portlet:namespace/>documentRecordTypeId" id="socongvancvdtn" onchange="changeDocumentRecordTypeUpdate()">
		        <logic:iterate id="pmlEdmDocumentRecordType" name="pmlEdmDocumentRecordTypeList" type="com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType" scope="request">
		      		<option <%=pmlEdmDocumentRecordType.getDocumentRecordTypeName().equals(documentDTO.getDocumentRecord()) ? "selected" : "" %> value="<%= pmlEdmDocumentRecordType.getDocumentRecordTypeId() %>"> <%= pmlEdmDocumentRecordType.getDocumentRecordTypeName() %> </option>
		      	</logic:iterate>
		</select>  
    </td>
	</tr>		
	<tr>
		<td><div align="left"><label><liferay-ui:message key="receipt.department"/>:</label></div></td>
		<td>
			<input style="width: 90%" type="text" readonly="readonly" name="<portlet:namespace/>department" id="dept" value='<%= departmentName != null ? departmentName : "" %>'>
		</td>	
		<td>
			<div align="left"><label><liferay-ui:message key="receipt.doctype"/><font color="#FF0000" size="1">(*)</font>:</label></div>
		</td>
		<td>
			<select name="<portlet:namespace/>documentTypeId" id="loaicongvancvdtn" style="width:99%" onchange="changeDocumentType()">
		    </select>
		</td>
	</tr>		
	<tr>
		<td><div align="left"><label><liferay-ui:message key="receipt.docref"/>:</label></div></td>
		<td>
	   		<input type="text" style="width:90%" name="<portlet:namespace/>documentReference" id="sohieucvdtn" value="<%= documentDTO.getDocumentReference()%>">    
		</td>      
		<!-- xuancong close start     
		<td colspan="2">&nbsp;</td>
		xuancong close end -->
		<td><div align="left"><label><liferay-ui:message key="receipt.issuingdate"/>:</label></div></td>
		<td>
			<%
			if (documentDTO.getIssuingDate() != null) {
			%>
				<input type="text" name="<portlet:namespace />issuingDate" id="ngaybanhanhcvdtn" value='<%=new java.text.SimpleDateFormat("dd/MM/yyyy").format(documentDTO.getIssuingDate()) %>' style="width:35">
			   	<span style="cursor: pointer"><img align="top" id="cal-button-dateArrive" src="/html/images/cal.gif" onclick="callCalendar('ngaybanhanhcvdtn','cal-button-dateArrive')"/></span>
		   	<%
			} else {
			%>
				<span>Ch\u01b0a ph\u00e1t h\u00e0nh</span>
			<%	
			}
		   	%>
		</td>
	</tr>
	<tr>
		<td>
			<div align="left"><label><liferay-ui:message key="receipt.receiveplace"/><font color="#FF0000" size="1">(*)</font>:</label></div>
		</td>
		<td>
			<div>
				<input type="text" name="<portlet:namespace/>receivingPlace" id="receiveplace" style="width: 79%" value='<%=documentDTO.getReceivingPlace() != null ? documentDTO.getReceivingPlace() : "" %>'>
			    <input type="hidden" id="issuingPlaceId" name="<portlet:namespace />issuingPlaceId">
			   	<span style="cursor: pointer">
			   		<input id="btn_receiveplace" type="button" value="..."  onclick="mypopupIssuingplace()" style="width: 10%">
			   	</span>
			</div>
		</td>		
		<td>
			<div align="left">
				<label>
					<liferay-ui:message key="receipt.confidentallevelid"/><font color="#FF0000" size="1">(*)</font>:
				</label>
			</div>
		</td>
		<td>
			<select name="<portlet:namespace/>confidentialLevelId" id="domatcvdtn" style="width:99%">
			    <logic:iterate id="pmlEdmConfidentialLevel" name="pmlEdmConfidentialLevelList" type="com.sgs.portlet.document.receipt.model.PmlEdmConfidentialLevel" scope="request">
					<option <%=documentDTO.getConfidentialLevel().equals(pmlEdmConfidentialLevel.getConfidentialLevelName()) ? "selected" : "" %> value="<%= pmlEdmConfidentialLevel.getConfidentialLevelId() %>"> <%= pmlEdmConfidentialLevel.getConfidentialLevelName() %> </option>
				</logic:iterate>
			</select>
		</td>
	</tr>		
	<tr>
		<td><div align="left"><label><liferay-ui:message key="receipt.signer"/>:</label></div></td>
		<td>
			<div>
				<input style="width: 79%" type="text" name="<portlet:namespace/>signerName" id="signer" value='<%=documentDTO.getSigner() != null ? documentDTO.getSigner() : "" %>' >	
				<input style="6%" type="hidden" id="signerId"  name="<portlet:namespace />signerId" >
				<span style="cursor: pointer">
				<input  id="btn_signer" type="button" value="..."  onclick="mypopupSigner()" style="width: 10%">
				</span>
			</div>
		</td>		
		<td>
			<div align="left"><label><liferay-ui:message key="receipt.previlegenlevelid"/><font color="#FF0000" size="1">(*)</font>:</label></div>
		</td>
		<td>
			<select name="<portlet:namespace/>privilegenLevelId" id="dokhancvdtn" style="width:99%">
				<logic:iterate id="pmlEdmPrivilegeLevel" name="pmlEdmPrivilegeLevelList" type="com.sgs.portlet.document.receipt.model.PmlEdmPrivilegeLevel" scope="request">
					<option <%=documentDTO.getPrivilegel().equals(pmlEdmPrivilegeLevel.getPrivilegeLevelName()) ? "selected" : "" %> value="<%= pmlEdmPrivilegeLevel.getPrivilegeLevelId() %>"> <%= pmlEdmPrivilegeLevel.getPrivilegeLevelName() %> </option>
				</logic:iterate>
			</select>
		</td>
	</tr>		
	<tr>
		<td><div align="left"><label><liferay-ui:message key="receipt.position"/>:</label></div></td>
		<td>
			<input style="width: 90%" type="text" maxlength="50" name="<portlet:namespace/>position" id="position" value='<%=documentDTO.getPosition() != null ? documentDTO.getPosition() : "" %>'>
		</td>		
		<td><div align="left"><label><liferay-ui:message key="pccc-cvdtn-cocongvanphucdap"/>:</label></div></td>
	    <td align="left">
	    <input name="<portlet:namespace />ishasdoc" <%= (documentDTO.isIscongvanphucdap()? "checked='checked'" : "") %> type="checkbox" id="ishasdoc" />
	    </td>
	</tr>		
	<tr>
		<td><div align="left"><label><liferay-ui:message key="receipt.docid"/>:</label></div></td>
		<td>
			<input style="width: 90%" type="text" maxlength="45" name="<portlet:namespace/>documentSendCode" id="docid" value='<%=documentDTO.getDocumentSendCode() != null ? documentDTO.getDocumentSendCode() : "" %>' >
			</td>	
		<td><div align="left"><label><liferay-ui:message key="receipt.page"/>:</label></div></td>
		<td>
			<input style="width: 96.5%" type="text" maxlength="50" name="<portlet:namespace/>numberPage" id="page" value='<%=(!"".equals(documentDTO.getNumberPage()) || !"0".equals(documentDTO.getNumberPage())) ? documentDTO.getNumberPage() : "" %>' >
		</td>
	</tr>
	<tr>
		<td valign="top"><div align="left"><label><liferay-ui:message key="receipt.briftcontent"/><font color="#FF0000" size="1">(*)</font>:</label></div></td>
		<td colspan="3"><textarea name="<portlet:namespace/>briefContent" id="trichyeucvdtn" rows="5" style="width:98%"><%= documentDTO.getBriefContent() %></textarea></td>
	</tr>
	<tr>
	    <td valign="top"><div align="left"><label><liferay-ui:message key="pccc-cvdtn-hosocongviec"/>:</label></div></td>
	    <td colspan="3">
	     	<div class="cvd-filedinhkem table-border-pml" style="width: 99%;">
	     	<table class="taglib-search-iterator table-pml" cellspacing="0" width="100%">
			<tr class="portlet-section-header results-header" >
				<td align="center" style="width: 45px">	##</td>
				<td width="35px" align="center">STT</td>
				<td ><liferay-ui:message key="pccc-TN-loaihoso"/></td>
			</tr>
		      	<logic:iterate id="pmlHoSoCongViec" name="pmlHoSoCongViecList" indexId="i" type="com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec"  >
						<tr class="${((i % 2)==0)? 'results-row':'tr_two results-row'}">
							<td align="center">
								<img src="/html/images/grippy.png" />&nbsp;
								<input name="<portlet:namespace />HSCV" value="<%= pmlHoSoCongViec.getIdHoSoCongViec()  %>" <%= (i < countHSCVChoice? "checked" : "") %>  type="checkbox"   />
							</td>
							<td align="center"><%= i + 1 %>.</td>
							<td ><%= pmlHoSoCongViec.getTieuDe() %></td>
						</tr>
				</logic:iterate>
					</table>
	        </div>
	    </td>	      
		
	</tr>	
</table>
<br>
<fieldset class="filborder">
<label class="laborder"><liferay-ui:message key="pccc-documentsent-filevanbandidinhkem"/></label>
<table id="addfileupload_NoUpload" class="taglib-search-iterator table-pml" cellspacing="0" width="100%">
<tr class="portlet-section-header results-header">
		<td width="35px" align="center"><div><liferay-ui:message key="sgs_onedoor_no."/></div></td>
		<td width="30%"><div><liferay-ui:message key="document_attached_file_title" /></div></td>
		<td width="40%"><div><liferay-ui:message key="document_attached_file_name" /></div></td>
		<td><div><liferay-ui:message key="document_attached_file_view" /></div></td>
	</tr>	
	<logic:iterate id="attachedFile" name="attachedFiles" indexId="i" type="com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile" scope="request" >
		<tr class="<%=(i % 2) == 0 ? "results-row" : "tr_two results-row" %>">
			<td><%=i + 1 %></td>
			<td ><a href="<%=attachedFile.getPath() %>"><u><%=attachedFile.getTitle() %></u></a></td>
			<td><a href="<%=attachedFile.getPath() %>"><u><%=attachedFile.getAttachedFileName().substring(14) %></u></a></td>
			<td><input type="checkbox" <%= (attachedFile.getDisplayOrHidden() == true ? "checked" : "") %> name="<portlet:namespace/>document_attached_file_view_active" value="<%= String.valueOf(attachedFile.getAttachedFileId()) %>" /></td>
		</tr>
	</logic:iterate>
</table>
</fieldset>
<br>
<fieldset class="filborder">
<label class="laborder"><liferay-ui:message key="pccc-documentsent-filevanbandidinhkem" /></label>
<table id="addfileupload" cellpadding="0" class="taglib-search-iterator table-pml" cellspacing="0" width="100%">
<tr class="portlet-section-header results-header">
		<td ><liferay-ui:message key="document_attached_file_title" /></td>
		<td width="50%"><liferay-ui:message key="document_attached_file_name" /></td>
		<td width="15%" align="center"><input style="width: 90%" type="button" value='<liferay-ui:message key="document_more_file" />' onclick="uploadReceiptfile()"></td>
	</tr>
</table>
</fieldset>

<input type="hidden" name="<portlet:namespace/>redirect" value="<%= redirect %>" />	
<input type="hidden" name="<portlet:namespace/>nameFieldRow" id="nameFieldRow" value="" />
<input type="hidden" name="<portlet:namespace/>nameFiles" id="nameFiles" value="" />
<input type="hidden" name="<portlet:namespace/>titleFiles" id="titleFiles" value="" />
<br/>
<div align="right" id="table-button">
			<input type="submit"  value='<liferay-ui:message key="pccc-cvdtn-luu" />'>
			<input type="reset" value='<liferay-ui:message key="reset" />'>
			<input type="button" onclick="window.history.back()" value='<liferay-ui:message key="back" />'>	
</div>
</div>
</form>