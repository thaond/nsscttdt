<%@ include file ="/html/portlet/ext/pcccdocumentreceiptprocess/init.jsp" %>
<%@page import="com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec"%>
<%@page import="com.sgs.portlet.pml_ho_so_cong_viec.service.persistence.PmlHoSoCongViecUtil"%>
<%-- <liferay-util:include page="/html/portlet/ext/pcccdocumentreceipt/js/pccc-docreceipt.jsp"></liferay-util:include> --%>
<liferay-util:include page="/html/portlet/ext/pcccdocumentreceiptprocess/js/pccc-docreceiptprocess.jsp"></liferay-util:include>
<link type="text/css" rel="stylesheet" href="/html/css/calendar-system.css" />
<link type="text/css" rel="stylesheet" href="/html/portlet/ext/pcccdocumentreceiptprocess/css/letter.css" />
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@page import="com.sgs.portlet.document.workflow.DocumentReceiptPortletAction"%>
<%@page import="com.sgs.portlet.document.receipt.dto.PmlEdmDocumentReceiptDTO"%>
<%@page import="com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace"%>
<%@page import="com.sgs.portlet.document.receipt.model.PmlEdmPrivilegeLevel"%>
<%@page import="java.util.List"%>
<%@page import="com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<script type='text/javascript' src='/html/js/liferay/socongvanphucdap.js'></script>
<script type='text/javascript' src='/html/js/liferay/jquery.js'></script>
<script type='text/javascript' src='/html/js/liferay/jquery.autocomplete.js'></script>
<link rel="stylesheet" type="text/css" href="/html/css/main.css" />
<link rel="stylesheet" type="text/css" href="/html/css/jquery.autocomplete.css" />
<script type="text/javascript" src="/html/js/calendar.js"></script>
<script type="text/javascript" src="/html/js/calendar-setup.js"></script>
<script type="text/javascript" src="/html/js/calendar-en.js"></script>
<script type="text/javascript">

function setStrAttatchedFile(id) {
	document.getElementById('str_attachedFile').value += id + "/";
}

window.onload = function () {
	//xuancong close checkonchangBR3();
	if (document.getElementById('ngayphathanhcvdtn') != null) {
		callCalendar('ngayphathanhcvdtn','cal-button-issuingDate');
	}
	if (document.getElementById('ngaydencvdtn') != null) {
		callCalendar('ngaydencvdtn','cal-button-dateArrive');
	}
}
</script>
<script type="text/javascript">
$().ready(function() {

	jQuerythoind("#socongvandiphucdap").autocomplete(danhsachsocongvan, {
		minChars: 0,
		autoFill: true}
		);
		
});

</script>

<%
boolean documentRecordTypeCode = PrefsParamUtil.getBoolean(prefs, request, "documentRecordTypeCode",false);
boolean documentTypeCode = PrefsParamUtil.getBoolean(prefs, request, "documentTypeCode",false);
String textAdd = PrefsParamUtil.getString(prefs, request, "textAdd","");
textAdd = textAdd.trim();
boolean departmentCode = PrefsParamUtil.getBoolean(prefs, request, "departmentCode",false);
boolean useYear = PrefsParamUtil.getBoolean(prefs, request, "useYear",false);
%>

<%
	PmlEdmDocumentReceiptDTO documentReceiptDTO = (PmlEdmDocumentReceiptDTO) request.getAttribute("documentReceiptDTO");
	List<PmlEdmAttachedFile> attachFiles = (List<PmlEdmAttachedFile>) renderRequest.getAttribute("attachFiles");
	int currentPage = Integer.parseInt(request.getAttribute("currentPage").toString());
	int currentLimit = Integer.parseInt(request.getAttribute("currentLimit").toString());
	int countHSCVChoice = Integer.parseInt(renderRequest.getAttribute("countHSCVChoice").toString());
	String redirect = ParamUtil.getString(renderRequest, "redirect");
	boolean hasChooseOptIss = false; // Da chon duoc don vi gui tu combo box
	
	String documentRecordTypeId = renderRequest.getAttribute("documentRecordTypeId") != null ? (String) (renderRequest.getAttribute("documentRecordTypeId")): "0" ;
%>

<portlet:actionURL var="update">
	<portlet:param name="struts_action" value="/sgs/pcccdocumentreceiptprocess/updatesearch" />
	<portlet:param name="documentReceiptId" value='<%="" + documentReceiptDTO.getDocumentReceiptId() %>'/>
	<portlet:param name="workflowAction" value="true"/>
	<portlet:param name="workflowActionName" value='<%=DocumentReceiptPortletAction.COMMAND_PREFIX + ".AddDocumentReceiptCommand"%>'/>
</portlet:actionURL>

<form autocomplete="off" action="<%=update %>" enctype="multipart/form-data" onsubmit="return validateCVDDocReceipt()" method="post">
<input type="hidden" id="isBookDocumentRecord"  value="">
<input type="hidden" name="str_attachedFile" id="str_attachedFile" value=""/>
<input type="hidden" name="<portlet:namespace/>str_fileattachedfiletodelete" id="str_fileattachedfiletodelete" value="" />
<input type="hidden" name="<portlet:namespace/>nameFieldRow" id="nameFieldRow" value="" />
<input type="hidden" name="<portlet:namespace/>nameFiles" id="nameFiles" value="" />
<input type="hidden" name="<portlet:namespace/>titleFiles" id="titleFiles" value="" />
<input type="hidden" name="<portlet:namespace/>userId" id="userId" value='<%= renderRequest.getAttribute("userId").toString()  %>' />

<input type="hidden" id="soCVdencvdtnHidden" value="<%= documentReceiptDTO.getNumberDocumentReceipt() %>"/>
<input type="hidden" id="loaicongvancvdtnHidden" value="<%= documentReceiptDTO.getDocumentTypeId() %>"/>

<input id="<portlet:namespace/>documentRecordTypeCode"  type="hidden"" value="<%=  HtmlUtil.escape(String.valueOf(documentRecordTypeCode))%>"  />
<input id="<portlet:namespace/>documentTypeCode"  type="hidden"" value="<%=   HtmlUtil.escape(String.valueOf(documentTypeCode))%>"  />
<input id="<portlet:namespace/>textAdd"  type="hidden"" value="<%=  HtmlUtil.escape(textAdd)%>"  />
<input id="<portlet:namespace/>departmentCode"  type="hidden"" value="<%=  HtmlUtil.escape(String.valueOf(departmentCode))%>"  />
<input id="<portlet:namespace/>useYear"  type="hidden"" value="<%=  HtmlUtil.escape(String.valueOf(useYear))%>"  />

<input type="hidden" name="<portlet:namespace/>documentRecordTypeIdHidden" id="<portlet:namespace/>documentRecordTypeIdHidden" value="<%= documentRecordTypeId%>"/>
	
<div class="title_categ"><liferay-ui:message key="pccc-cvdtn-suacongvan"/></div>
<div class="boxcontent">
<table width="100%" cellspacing="0">
	<tr>
		<td ><div align="left"><label><liferay-ui:message key="pccc-cvdtn-socongvan"/>&nbsp;:</label></div></td>
		<td>
			<select name="<portlet:namespace/>documentRecordTypeId" id="socongvancvdtn" style="width:92.5%" onchange="changeDocumentRecordType()">
				<logic:iterate id="pmlEdmDocumentRecordType" name="pmlEdmDocumentRecordTypeList" type="com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType" scope="request">
		      	<option <%=Integer.parseInt((String)renderRequest.getAttribute("documentRecordTypeId")) == pmlEdmDocumentRecordType.getDocumentRecordTypeId() ? "selected" : "" %> value="<%= pmlEdmDocumentRecordType.getDocumentRecordTypeId() %>"> <%= pmlEdmDocumentRecordType.getDocumentRecordTypeName() %> </option>
		     	</logic:iterate>
			</select>
		</td>
		<td ><div align="left"><label><liferay-ui:message key="pccc-cvdtn-loaicongvan"/>&nbsp;:</label></div></td>
		<td>
			<select name="<portlet:namespace/>documentTypeId" id="loaicongvancvdtn" style="width:92.5%" onchange="changeDocumentType()">
				<logic:iterate id="documentType" name="documentTypes" type="com.sgs.portlet.document.receipt.model.PmlEdmDocumentType" scope="request">
			    	<option <%=documentReceiptDTO.getDocumentTypeName().equals(documentType.getDocumentTypeName()) ? "selected" : ""%> value="<%=documentType.getDocumentTypeId() %>"><%=documentType.getDocumentTypeName() %></option>
			    </logic:iterate>
		   	</select>
	    </td>
	</tr>
	<tr>
		<td ><div align="left"><label><liferay-ui:message key="pccc-cvdtn-soCVden"/>:</label></div></td>
    	<td><input style="width:90%" type="text" readonly name="<portlet:namespace/>numberDocumentReceipt" id="soCVdencvdtn" maxlength="50" style="width:60%" value='<%=documentReceiptDTO.getNumberDocumentReceipt() != null ? documentReceiptDTO.getNumberDocumentReceipt() : "" %>'></td>
    	<td ><div align="left"><label><liferay-ui:message key="pccc-cvdtn-sohieu"/>&nbsp;: </div></td>
    	<td><input style="width:90%" type="text" name="<portlet:namespace/>documentReference" id="sohieucvdtn" maxlength="50" style="width:99%" value='<%=documentReceiptDTO.getDocumentReference() != null ? documentReceiptDTO.getDocumentReference() : "" %>'></td>
	</tr>

	<tr>
		<td width="18%" ><div align="left"><label><liferay-ui:message key="pccc-cvdtn-capgoi"/>&nbsp;:</label></div></td>
	    <td width="35%">
		    <select name="<portlet:namespace/>levelSendId" id="capgoicvdtn" style="width:92.5%" onchange="changeLevelSend()">
			    <logic:iterate id="pmlEdmLevelSend" name="pmlEdmLevelSendList" type="com.sgs.portlet.pmllevelsend.model.PmlEdmLevelSend" scope="request">
		      		<option <%= documentReceiptDTO.getLevelSendName().equals(pmlEdmLevelSend.getLevelSendName()) ? "selected" : "" %> value="<%= pmlEdmLevelSend.getLevelSendId() %>"> <%= pmlEdmLevelSend.getLevelSendName() %> </option>
		      	</logic:iterate>
		    </select>
	    </td>
	    <td width="13%" ><div align="left"><label><liferay-ui:message key="pccc-cvdtn-noiphathanh"/>&nbsp;:</label></div></td>
	    <td>
		    <select onchange="checkonchangBR3()" name='<portlet:namespace/>issuingPlaceId' id='noiphathanhcvdtn' style="width:92.5%" >
		    	<option value=""><liferay-ui:message key="nochoose" /></option>
					<logic:iterate id="issuingPlace" name="issuingPlaces" type="com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace" scope="request">
				<option <%=documentReceiptDTO.getIssuingPlaceName().equals(issuingPlace.getIssuingPlaceName()) ? "selected" : "" %> value="<%=issuingPlace.getIssuingPlaceId() %>"><%=issuingPlace.getIssuingPlaceName() %></option>
			      		<%
			      		if (documentReceiptDTO.getIssuingPlaceName().equals(issuingPlace.getIssuingPlaceName())) {
			      			hasChooseOptIss = true;
			      		}
			      		%>
				</logic:iterate>
		    </select>
	    </td>
	</tr>

	<tr>
		<td><liferay-ui:message key="don-vi-sao-y"/>&nbsp;:</td>
		<td><input type="text" name="<portlet:namespace/>donvisaoy" id="donvisaoy" style="width:90%" value="<%= documentReceiptDTO.getDonViSaoY() %>"></td>
    	<td ><div align="left"><label><liferay-ui:message key="pccc-cvdtn-khac"/>&nbsp;:</label></div></td>
		<td><input style="width:90%" type="text" name="<portlet:namespace/>issuingPlaceName" id="khaccvdtn" maxlength="200" style="width:60%" value='<%=documentReceiptDTO.getIssuingPlaceName() != null && hasChooseOptIss == false ? documentReceiptDTO.getIssuingPlaceName() : "" %>'></td>
	</tr>

	<tr>
		<td ><div align="left"><label><liferay-ui:message key="pccc-cvdtn-ngayphathanh"/>&nbsp;:</label></div></td>
		<td>
			<input style="width:81%" type="text" name="<portlet:namespace/>issuingDate" id="ngayphathanhcvdtn" maxlength="10" value='<%=documentReceiptDTO.getIsuuingDate() != null ? new java.text.SimpleDateFormat("dd/MM/yyyy").format(documentReceiptDTO.getIsuuingDate()) : "" %>' >
			<span style="cursor: pointer"><img align="top" id="cal-button-issuingDate" src="/html/images/cal.gif" onclick="callCalendar('ngayphathanhcvdtn','cal-button-issuingDate')"/></span>
		</td>
	    <td >
	    	<div align="left"><label><liferay-ui:message key="pccc-cvdtn-ngayden"/>&nbsp;:</label></div></td>
	    <td>
	    	<input style="width:75px" type="text" name="<portlet:namespace/>dateArrive" id="ngaydencvdtn" maxlength="10" value='<%=documentReceiptDTO.getDateArrive() != null ? new java.text.SimpleDateFormat("dd/MM/yyyy").format(documentReceiptDTO.getDateArrive()) : "" %>' >
			<span style="cursor: pointer"><img align="top" id="cal-button-dateArrive" src="/html/images/cal.gif" onclick="callCalendar('ngaydencvdtn','cal-button-dateArrive')"/></span>
			<input style="width:50px" type="text" name="dateArriveTime" id="dateArriveTime" size=13 value='<%=documentReceiptDTO.getThoigiannhancvden() != null ? documentReceiptDTO.getThoigiannhancvden() : "" %>'><label><liferay-ui:message key="hour"/>:</label><span style="color:gray;font-size: 9px">(HH:MM:SS)</span>
	    </td>
	</tr>
	
	<tr valign="top">
		<td><div align="left"><label><liferay-ui:message key="pccc-cvdtn-trichyeu"/>&nbsp;:</label></div></td>
   		<td colspan="3">
    		<textarea name="<portlet:namespace/>briefContent" id="trichyeucvdtn" rows="5" style="width:95.5%"><%=documentReceiptDTO.getBriefContent() %></textarea>
    	</td>
	</tr>

	<tr>
		<td ><div align="left"><label><liferay-ui:message key="pccc-cvdtn-nguoiky"/>&nbsp;: </div></td>
    	<td><input style="width:90%" type="text" name="<portlet:namespace/>signer" id="nguoikycvdtn" maxlength="54" style="width:99%" value='<%=documentReceiptDTO.getSigner() != null ? documentReceiptDTO.getSigner() : ""%>'></td>
		<td>
			<div align="left">
				<label><liferay-ui:message key="pccc-cvdtn-socongvandiphucdap"/>&nbsp;:</label>
			</div>
		</td>
		<td >
	    	<input type="text" name="<portlet:namespace/>socongvandiphucdap" value="<%= documentReceiptDTO.getSocongvandiphucdap()%>" id="socongvandiphucdap" style="width:90%" maxlength="20">
	    </td>
	</tr>
	
	<tr>
		<td ><div align="left"><label><liferay-ui:message key="pccc-cvdtn-dokhan"/>&nbsp;:</label></div></td>
	    <td>
			<select name="<portlet:namespace/>privilegenLevelId" id="dokhancvdtn" style="width:92.5%">
			   	<logic:iterate id="pmlEdmPrivilegeLevel" name="pmlEdmPrivilegeLevelList" type="com.sgs.portlet.document.receipt.model.PmlEdmPrivilegeLevel" scope="request">
		    	<option <%=documentReceiptDTO.getPrivilegeLevel().equals(pmlEdmPrivilegeLevel.getPrivilegeLevelName()) ? "selected" : "" %> value="<%= pmlEdmPrivilegeLevel.getPrivilegeLevelId()%>"> <%= pmlEdmPrivilegeLevel.getPrivilegeLevelName() %> </option>
		    	</logic:iterate>
			</select>
		</td>
		<td ><div align="left"><label><liferay-ui:message key="pccc-cvdtn-domat"/>&nbsp;:</label></div></td>
		<td>
			<select name="<portlet:namespace/>confidentialLevelId" id="domatcvdtn" style="width:92.5%">
				<logic:iterate id="pmlEdmConfidentialLevel" name="pmlEdmConfidentialLevelList" type="com.sgs.portlet.document.receipt.model.PmlEdmConfidentialLevel" scope="request">
		      	<option <%=documentReceiptDTO.getConfidentialLevelName().equals(pmlEdmConfidentialLevel.getConfidentialLevelName()) ? "selected" : "" %> value="<%= pmlEdmConfidentialLevel.getConfidentialLevelId()%>"> <%= pmlEdmConfidentialLevel.getConfidentialLevelName() %> </option>
		     	</logic:iterate>
		 	</select>
	    </td>	    
	</tr>
		
	<tr valign="top">
	    <td>
	    	<div align="left">
	    		<label><liferay-ui:message key="pccc-cvdtn-hosocongviec"/>&nbsp;:</label>
	    	</div>
    	</td>
	    <td colspan="3">
	   	 	<div class="cvd-filedinhkem table-border-pml" style="width: 96.5%;">
	   	 	<table class="taglib-search-iterator table-pml" cellspacing="0" width="100%">
				<tr class="portlet-section-header results-header" >
					<td align="center" style="width: 45px">	##</td>
					<td width="35px" align="center">STT</td>
					<td ><liferay-ui:message key="pccc-TN-loaihoso"/></td>
				</tr>
		      	<logic:iterate id="pmlHoSoCongViec" name="pmlHoSoCongViecList" indexId="i" type="com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec"  >
				<tr class="${((i % 2)==0)? 'results-row':'tr_two results-row'}">
						<td align="center">
							<img src="/html/images/grippy.png" />&nbsp;<input name="<portlet:namespace />HSCV" value='<%= pmlHoSoCongViec.getIdHoSoCongViec()  %>' <%= (i < countHSCVChoice ? " checked" : "" ) %>  type="checkbox"   />
						</td>
						<td align="center"><%= i + 1 %>.</td>
						<td ><%= pmlHoSoCongViec.getTieuDe() %></td>					
					</tr>
		        </logic:iterate>
		        </table>
	        </div>
    	</td>
	</tr>

	<tr style="display: none;">
		<td></td>
	  	<td style="padding-left: 3px;">
	  		<div>
				<input name="<portlet:namespace/>isPublic" type="radio" id="RadioGroup1_0" value="1" <%=documentReceiptDTO.getIsPublic().equals("1") ? "checked" : "" %> >&nbsp;
		    	<liferay-ui:message key="pccc-cvdtn-congvancongcong"/>  		
	  		</div>
	  	</td>
	  	<td >
		    <div style="text-align: right; padding-right: 3px;">
				<input type="radio" name="<portlet:namespace/>isPublic" value="0" <%=documentReceiptDTO.getIsPublic().equals("0") ? "checked" : "" %> id="RadioGroup1_1">&nbsp;
				<liferay-ui:message key="pccc-cvdtn-congvannoibo"/>
			</div>
		</td>
		<td></td>
	</tr>
</table>


<%
	if (!attachFiles.isEmpty()) {
%>
<fieldset class="filborder">
<legend class="laborder"><liferay-ui:message key="pcccdocumentsend-taptindinhkem"/></legend>
<table id="recentFile" class="taglib-search-iterator table-pml" cellspacing="0" width="100%">
<tr class="portlet-section-header results-header">
	<td width="35px" align="center"><div align="center"><liferay-ui:message key="pccc-TN-stt"/></div></td>
	<td width="30%"><div ><liferay-ui:message key="pccc-DRP-tengoi" /></div></td>
	<td width="40%"><div ><liferay-ui:message key="pccc-TN-tentaptin" /></div></td>
    <td ><div align="center"><liferay-ui:message key="pccc-DRP-ngayluu" /></div></td>
	<td width="10%"><div align="center"><liferay-ui:message key="pccc-DRP-thaotac" /></div></td>
</tr>
<logic:iterate id="attachFile" name="attachFiles" indexId="i" type="com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile" scope="request">
<tr class="<%=(i % 2) == 0 ? "results-row" : "tr_two results-row" %>">
	<td align="center"><div><%= ++i %></div></td>
 	<td><div><a href="#" onclick="getHostName(this,'<%= attachFile.getPath()%>' )"><%=!"".equals(attachFile.getTitle()) ? attachFile.getTitle() : attachFile.getAttachedFileName() %></a></div></td>
  	<td><div><a href="#" onclick="getHostName(this,'<%= attachFile.getPath()%>' )"><%=attachFile.getAttachedFileName().substring(14) %></a></div></td>
  	<td  align="center"><div><%=attachFile.getDateCreated() != null ? new java.text.SimpleDateFormat("dd/MM/yyyy").format(attachFile.getDateCreated()) : "" %></div></td>
  	<td  align="center"><input  type="button" value='<liferay-ui:message key="delete"/>' onclick="deleteRowFileUpload(this, '<%=attachFile.getAttachedFileId() %>');" ></td>
</tr>
</logic:iterate>
</table>
</fieldset>
<%
	} 
%>
<fieldset class="filborder">
<legend class="laborder"><liferay-ui:message key="pccc-cvdtn-toanvan"/></legend>
<table id="addfileupload" class="taglib-search-iterator table-pml" cellspacing="0" width="100%">
<tr class="portlet-section-header results-header" >
	<td ><liferay-ui:message key="document_attached_file_title" /></td>
	<td width="50%" ><liferay-ui:message key="document_attached_file_name" /></td>
	<td width="15%" align="center"><input style="width: 90%" type="button" value='<liferay-ui:message key="document_more_file" />' onclick="uploadReceiptfile()"></td>
</tr>
</table>
</fieldset>
	
<input type="hidden" name="<portlet:namespace/>redirect" value="<%=redirect %>" />
<div align="right" id="table-button">
		<input type="hidden" name="page" value="<%=String.valueOf(currentPage) %>"/>
		<input type="hidden" name="limit" value="<%=String.valueOf(currentLimit) %>"/>
		<input class="button-width" type="submit"  value='<liferay-ui:message key="pccc-cvdtn-luu" />'>
		<input class="button-width" type="button" onclick="window.history.back()" value='<liferay-ui:message key="back" />'>
</div>
</div>
</form>