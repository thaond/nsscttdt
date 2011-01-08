<%@page import="java.util.ArrayList"%>
<%@ include file ="/html/portlet/ext/pcccdocumentreceiptprocess/init.jsp" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@page import="com.sgs.portlet.document.workflow.DocumentReceiptPortletAction"%>
<%@page import="com.sgs.portlet.document.receipt.dto.PmlEdmDocumentReceiptDTO"%>
<%@page import="com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace"%>
<%@page import="com.sgs.portlet.document.receipt.model.PmlEdmPrivilegeLevel"%>
<%@page import="com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile"%>
<%@page import="com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec"%>
<%@page import="com.sgs.portlet.pml_ho_so_cong_viec.service.persistence.PmlHoSoCongViecUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat"%>

<liferay-util:include page="/html/portlet/ext/pcccdocumentreceiptprocess/js/pccc-docreceiptprocess.jsp"></liferay-util:include>
<link type="text/css" rel="stylesheet" href="/html/css/calendar-system.css" />
<link type="text/css" rel="stylesheet" href="/html/portlet/ext/pcccdocumentreceiptprocess/css/letter.css" />
<link rel="stylesheet" type="text/css" href="/html/css/main.css" />
<link rel="stylesheet" type="text/css" href="/html/css/jquery.autocomplete.css" />

<script type='text/javascript' src='/html/js/liferay/socongvanphucdap.js'></script>
<script type='text/javascript' src='/html/js/liferay/jquery.js'></script>
<script type='text/javascript' src='/html/js/liferay/jquery.autocomplete.js'></script>

<script type="text/javascript" src="/html/js/calendar.js"></script>
<script type="text/javascript" src="/html/js/calendar-setup.js"></script>
<script type="text/javascript" src="/html/js/calendar-en.js"></script>
<script type='text/javascript' src='/html/js/liferay/tr.js'></script>
<script type="text/javascript">

function setStrAttatchedFile(id) {
	document.getElementById('str_attachedFile').value += id + "/";
}

window.onload = function () {
	//xuancong close checkonchangBR3();
	
	// phmphuc open 12/07/2010
	checkonchangBR3(); // neu chon noi phat hanh thi Khac phai disabled
	//getDocumentRecordByDocTypeId();

	// load tat ca danh sach noi phat hanh khi khong chon cap goi
	var capgoicvdtn = document.getElementById('capgoicvdtn');
	if (capgoicvdtn.value == -1) {
		changeLevelSend();
	}
	
	doStop();
	// end
	
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
	PmlEdmDocumentReceiptDTO documentReceiptDTO = (PmlEdmDocumentReceiptDTO) request.getAttribute("documentReceiptDTO");

	List<PmlEdmAttachedFile> attachFiles = (List<PmlEdmAttachedFile>) renderRequest.getAttribute("attachFiles");
	
	int countHSCVChoice = Integer.parseInt(renderRequest.getAttribute("countHSCVChoice").toString());
	boolean hasChooseOptIss = false; // Da chon duoc don vi gui tu combo box
	String redirect = ParamUtil.getString(renderRequest, "redirect"); // yenlt update 10082010
	
	// lay gia tri
	String numberDocumentReceipt = documentReceiptDTO.getNumberDocumentReceipt();
	String phanSo = "";
	String phanMoRong = "";
	if (numberDocumentReceipt != null) {
		String[] numberArr = numberDocumentReceipt.split("/");
		phanSo = numberArr[0];
		phanMoRong = "/" + numberArr[1];
	}
%>

<portlet:actionURL var="update">
	<portlet:param name="struts_action" value="/sgs/pcccdocumentreceiptprocess/update" />
	<portlet:param name="documentReceiptId" value='<%="" + documentReceiptDTO.getDocumentReceiptId() %>'/>
	<portlet:param name="workflowAction" value="true"/>
	<portlet:param name="workflowActionName" value='<%=DocumentReceiptPortletAction.COMMAND_PREFIX + ".AddDocumentReceiptCommand"%>'/>
</portlet:actionURL>

<form autocomplete="off" action="<%=update %>" name="<portlet:namespace/>fm" enctype="multipart/form-data" onsubmit="return validateCVDDocReceipt()" method="post">
<input type="hidden" id="isBookDocumentRecord"  value="">
<input type="hidden" name="str_attachedFile" id="str_attachedFile" value=""/>
<input type="hidden" name="<portlet:namespace/>str_fileattachedfiletodelete" id="str_fileattachedfiletodelete" value="" />
<input type="hidden" name="<portlet:namespace/>nameFieldRow" id="nameFieldRow" value="" />
<input type="hidden" name="<portlet:namespace/>nameFiles" id="nameFiles" value="" />
<input type="hidden" name="<portlet:namespace/>titleFiles" id="titleFiles" value="" />
<input type="hidden" name="<portlet:namespace/>userId" id="userId" value='<%= renderRequest.getAttribute("userId").toString()  %>' />
<div class="title_categ"><liferay-ui:message key="pccc-cvdtn-suacongvan"/></div>
<div class="boxcontent">	
<input type="hidden" id="documentreceiptid" value="<%= documentReceiptDTO.getDocumentReceiptId() %>"/>
<input type="hidden" id="phansohidden" value="<%= phanSo %>"/>
<input type="hidden" id="sohieucvdtnhidden" value="<%= documentReceiptDTO.getDocumentReference() %>"/>
<table width="100%" cellspacing="0">
	<tr>
  		<td><liferay-ui:message key="pccc-cvdtn-soCVden"/>&nbsp;:</td>
		<td>
			<div id="div1" style="display: inline;">
				<input type="text" name="<portlet:namespace/>numberDocumentReceipt" id="soCVdencvdtn" 
						value='<%= numberDocumentReceipt != null ? numberDocumentReceipt : "" %>' 
						style="width:60%" readonly="readonly">
			</div>

			<div id="div2" style="display: none;">
				<input type="text" name="<portlet:namespace/>phanSo" id="phanso" style="width:30%" value="<%= phanSo %>" onblur="checkNumberDocumentReceipt();">
				<input type="text" name="<portlet:namespace/>phanMoRong" id="phanmorong" style="width:30%" value="<%= phanMoRong %>" readonly="readonly">
			</div>
			
			&nbsp;&nbsp;&nbsp;<liferay-ui:message key="auto"/>
			<input type="checkbox" name="<portlet:namespace/>editnumber" id="editnumber" checked="checked" onclick="editNumberDocumentReceipt()">
		</td>
		
		<td><liferay-ui:message key="pccc-cvdtn-sohieu"/><font color="red">(*)</font>&nbsp;:</td>
		<td><input type="text" name="<portlet:namespace/>documentReference" id="sohieucvdtn" style="width:93%" maxlength="50"
					value="<%= documentReceiptDTO.getDocumentReference() != null ? documentReceiptDTO.getDocumentReference() : "" %>">
		</td>
  	</tr>
  	
  	<tr>
	    <td width="18%"><div align="left"><label><liferay-ui:message key="pccc-cvdtn-loaicongvan"/>:</label></div></td>
		<td width="32%">
	    	<select name="<portlet:namespace/>documentTypeId" id="loaicongvancvdtn" style="width:96%">
	    		<logic:iterate id="documentType" name="documentTypes" type="com.sgs.portlet.document.receipt.model.PmlEdmDocumentType" scope="request">
			    	<option <%= documentReceiptDTO.getDocumentTypeName().equals(documentType.getDocumentTypeName()) ? "selected" : ""%> 
			    			value="<%= documentType.getDocumentTypeId() %>"><%=documentType.getDocumentTypeName() %></option>
     			</logic:iterate>
	    	</select>
		</td>
		<td><liferay-ui:message key="don-vi-sao-y"/>&nbsp;:</td>
		<td><input type="text" name="<portlet:namespace/>donvisaoy" id="donvisaoy" style="width:93%" value="<%= documentReceiptDTO.getDonViSaoY() %>"></td>
  	</tr>
	
	<tr>
		<td ><liferay-ui:message key="pccc-cvdtn-capgoi"/>&nbsp;:</td>
	    <td>
	      	<select name="<portlet:namespace/>levelSendId" id="capgoicvdtn" style="width:96%" onchange="changeLevelSend()">
		        <option value="-1"><liferay-ui:message key="nochoose" /></option>
		        <logic:iterate id="pmlEdmLevelSend" name="pmlEdmLevelSendList" type="com.sgs.portlet.pmllevelsend.model.PmlEdmLevelSend" scope="request">
		      		<option <%= documentReceiptDTO.getLevelSendName().equals(pmlEdmLevelSend.getLevelSendName()) ? "selected" : "" %> 
		      				value="<%= pmlEdmLevelSend.getLevelSendId() %>"> <%= pmlEdmLevelSend.getLevelSendName() %> 
		      		</option>
		      	</logic:iterate>
	      	</select>
	    </td>

		<td ><liferay-ui:message key="pccc-cvdtn-noiphathanh"/><font color="red">(*)</font>&nbsp;:</td>
		<td>
			<div>
				<select onchange="checkonchangBR3()" name='<portlet:namespace/>issuingPlaceId' id='noiphathanhcvdtn' style='width:97%' >
			    	<option value=""><liferay-ui:message key="nochoose" /></option>
					<logic:iterate id="issuingPlace" name="issuingPlaces" type="com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace" scope="request">
						<option <%= documentReceiptDTO.getIssuingPlaceName().equals(issuingPlace.getIssuingPlaceName()) ? "selected" : "" %> 
							value="<%= issuingPlace.getIssuingPlaceId() %>"><%= issuingPlace.getIssuingPlaceName() %>
						</option>
				      	<%
				      		if (documentReceiptDTO.getIssuingPlaceName().equals(issuingPlace.getIssuingPlaceName())) {
				      			hasChooseOptIss = true;
				      		}
			      		%>
					</logic:iterate>
			    </select>
			</div>
	    </td>
  	</tr>
	
	<tr>
		<td></td>
		<td></td>
		<td><liferay-ui:message key="pccc-cvdtn-khac"/>&nbsp;:</td>
   	 	<td><input type="text" name="<portlet:namespace/>issuingPlaceName" id="khaccvdtn" style="width:93%" maxlength="200"
   	 			value='<%= documentReceiptDTO.getIssuingPlaceName() != null && hasChooseOptIss == false ? documentReceiptDTO.getIssuingPlaceName() : "" %>'>
   	 	</td>
	</tr>
	
	<tr>
		<td ><liferay-ui:message key="pccc-cvdtn-ngayphathanh"/>:</td>
	    <td align="left">
	    	<input style="width: 35%;" type="text" name="<portlet:namespace/>issuingDate" id="ngayphathanhcvdtn" 
	    		value='<%= documentReceiptDTO.getIsuuingDate() != null ? new SimpleDateFormat("dd/MM/yyyy").format(documentReceiptDTO.getIsuuingDate()) : "" %>' >
			<span style="cursor: pointer"><img align="top" id="cal-button-issuingDate" src="/html/images/cal.gif" onclick="callCalendar('ngayphathanhcvdtn','cal-button-issuingDate')"/></span>
	    </td>
		<td><liferay-ui:message key="pccc-cvdtn-ngayden"/>:</td>
		<td align="left">
 			<input style="width: 65px;" type="text" name="<portlet:namespace/>dateArrive" id="ngaydencvdtn" style="width: 80px"
	    		value='<%= documentReceiptDTO.getDateArrive() != null ? new SimpleDateFormat("dd/MM/yyyy").format(documentReceiptDTO.getDateArrive()) : "" %>' >
			<span style="cursor: pointer"><img align="top" id="cal-button-dateArrive" src="/html/images/cal.gif" onclick="callCalendar('ngaydencvdtn','cal-button-dateArrive')"/></span>
		   	<label><liferay-ui:message key="hour"/>:</label>
			<input readonly="readonly" type="text" name="dateArriveTime" id="dateArriveTime" style="width: 50px" value='<%= documentReceiptDTO.getThoigiannhancvden() != null ? documentReceiptDTO.getThoigiannhancvden() : "" %>'>
			<liferay-ui:message key="edit"/>
			<input type="checkbox" id="edittime" unchecked onclick="doStop()">  
		</td>
  	</tr>
	
	<tr valign="top">
  		<td valign="top">
		   	<liferay-ui:message key="pccc-cvdtn-trichyeu"/><font color="red">(*)</font> &nbsp;:
		 </td>
		 <td colspan="3" valign="top">
		   	<textarea name="<portlet:namespace/>briefContent" id="trichyeucvdtn"  rows="2" style="width:98.9%"><%= documentReceiptDTO.getBriefContent() %></textarea>
		 </td>
  	</tr>	
  <tr>
  
  <tr>
    <td><liferay-ui:message key="pccc-cvdtn-nguoiky"/><font color="red">(*)</font> &nbsp;:</td>
	<td>
		<input type="text" name="<portlet:namespace/>signer" id="nguoikycvdtn" value='<%= documentReceiptDTO.getSigner() != null ? documentReceiptDTO.getSigner() : ""%>'>
	</td>
	<td><liferay-ui:message key="pccc-cvdtn-domat"/>&nbsp;:</td>
		<td>
			<select name="<portlet:namespace/>confidentialLevelId" id="domatcvdtn" style="width:96%">
				<logic:iterate id="pmlEdmConfidentialLevel" name="pmlEdmConfidentialLevelList" type="com.sgs.portlet.document.receipt.model.PmlEdmConfidentialLevel" scope="request">
		      		<option <%= documentReceiptDTO.getConfidentialLevelName().equals(pmlEdmConfidentialLevel.getConfidentialLevelName()) ? "selected" : "" %> 
		      			value="<%= pmlEdmConfidentialLevel.getConfidentialLevelId()%>"> <%= pmlEdmConfidentialLevel.getConfidentialLevelName() %> 
		      		</option>
		     	</logic:iterate>
		 	</select>
		</td>
  	</tr>
	
	<tr>
		<td><liferay-ui:message key="pccc-cvdtn-dokhan"/>&nbsp;:</td>
		<td>
			<select name="<portlet:namespace/>privilegenLevelId" id="dokhancvdtn" style="width:98%">
				<logic:iterate id="pmlEdmPrivilegeLevel" name="pmlEdmPrivilegeLevelList" type="com.sgs.portlet.document.receipt.model.PmlEdmPrivilegeLevel" scope="request">
			    	<option <%= documentReceiptDTO.getPrivilegeLevel().equals(pmlEdmPrivilegeLevel.getPrivilegeLevelName()) ? "selected" : "" %> 
			    		value="<%= pmlEdmPrivilegeLevel.getPrivilegeLevelId()%>"> <%= pmlEdmPrivilegeLevel.getPrivilegeLevelName() %> 
			    	</option>
		    	</logic:iterate>
			</select>
		</td>
  		<td ><liferay-ui:message key="pccc-cvdtn-socongvandiphucdap"/>&nbsp;:</td>
		<td >
   			<input type="text" name="<portlet:namespace/>socongvandiphucdap" 
	    		value="<%= documentReceiptDTO.getSocongvandiphucdap()%>" id="socongvandiphucdap" style="width:92%" onchange="checkReponseNumberDocument(this.value)">
	    	<div id="cohaykhongsocongvandiphucdap"></div> 	      	
		</td>
   	</tr>
	
	<tr>
 		<td><liferay-ui:message key="pccc-cvdtn-hosocongviec"/>&nbsp;:</td>
 		<td colspan="3">
 			<div class="cvd-filedinhkem table-border-pml" style="width: 100%;">
	      		<table class="taglib-search-iterator table-pml" cellspacing="0" width="100%">
					<%
						String rowAllName = "checkallbox";
						String formName = renderResponse.getNamespace() + "fm";
						String rowName = renderResponse.getNamespace() + "HSCV";
					
						StringBuilder rowAllNameChecked = new StringBuilder();
						rowAllNameChecked.append("<input name=\"");
						rowAllNameChecked.append(rowAllName);
						rowAllNameChecked.append("\" type=\"checkbox\" ");
						rowAllNameChecked.append("onClick=\"Liferay.Util.checkAll(");
						rowAllNameChecked.append(formName);
						rowAllNameChecked.append(", '");
						rowAllNameChecked.append(rowName);
						rowAllNameChecked.append("', this");
						rowAllNameChecked.append(");\">");
						List<PmlHoSoCongViec> pmlHSCVs = renderRequest.getAttribute("pmlHoSoCongViecList") != null ? (List<PmlHoSoCongViec>) renderRequest.getAttribute("pmlHoSoCongViecList") : new ArrayList<PmlHoSoCongViec>();
						
					%>
					<tr class="portlet-section-header results-header" >
						<td align="center" style="width: 45px"><img src="/html/images/grippy.png" />&nbsp;<%= rowAllNameChecked.toString() %></td>
						<td width="35px" align="center">STT</td>
						<td ><liferay-ui:message key="pml_tieude"/></td>
					</tr>
					
					
					<logic:iterate id="pmlHoSoCongViec" name="pmlHoSoCongViecList" indexId="i" type="com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec"  >	
					
					<tr class="${((i % 2)==0)? 'results-row':'tr_two results-row'}" onmouseover='onMouseOverTr(this);' onmouseout='onMouseOutTr(this);'>
						<td align="center" >
							<img src="/html/images/grippy.png" />&nbsp;<input onClick="Liferay.Util.checkAllBox(<%= formName%>, '<%=  rowName %>', <%= rowAllName %>);" name="<portlet:namespace />HSCV" value='<%= pmlHoSoCongViec.getIdHoSoCongViec()  %>' <%= (i < countHSCVChoice ? " checked" : "" ) %>  type="checkbox"   />
						</td>
						<td align="center"><%= i + 1 %>.</td>
						<td ><%= pmlHoSoCongViec.getTieuDe() %></td>					
					</tr>
					</logic:iterate>
					
					<c:if test="<%= (countHSCVChoice == pmlHSCVs.size()) %>">
						<script type="text/javascript">
							document.<portlet:namespace />fm.checkallbox.checked = true;
						</script>
					</c:if>
					
				</table>
	        </div>
 		</td>
 	</tr>
 	
 	<tr style="display: none;">
 		<td>&nbsp;:</td>
 		<td>
 			<input name="<portlet:namespace/>isPublic" type="radio" id="RadioGroup1_0" value="1" <%= documentReceiptDTO.getIsPublic().equals("1") ? "checked" : "" %> >&nbsp;
		    	<liferay-ui:message key="pccc-cvdtn-congvancongcong"/> 
 		</td>
 		<td><input type="radio" name="<portlet:namespace/>isPublic" value="0" <%= documentReceiptDTO.getIsPublic().equals("0") ? "checked" : "" %> id="RadioGroup1_1">&nbsp;
				<liferay-ui:message key="pccc-cvdtn-congvannoibo"/>
		</td>
 		<td></td> 	
 	</tr>
</table>

<%
	if (!attachFiles.isEmpty()) {
%>

<fieldset class="filborder">
		<label class="laborder"><liferay-ui:message key="pcccdocumentsend-taptindinhkem"/></label>
		<table id="recentFile" class="taglib-search-iterator table-pml" cellspacing="0" width="100%">
			<tr class="portlet-section-header results-header">
				<td width="35px" align="center"><liferay-ui:message key="pccc-TN-stt"/></td>
				<td width="30%"><liferay-ui:message key="pccc-DRP-tengoi" /></td>
				<td width="40%"><liferay-ui:message key="pccc-TN-tentaptin" /></td>
			    <td align="center"><liferay-ui:message key="pccc-DRP-ngayluu" /></td>
				<td width="15%" align="center"><liferay-ui:message key="pccc-DRP-thaotac" /></td>
			</tr>
					
			<logic:iterate id="attachFile" name="attachFiles" indexId="i" type="com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile" scope="request">
				<tr class="<%= (i % 2) == 0 ? "results-row" : "tr_two results-row" %>" onmouseover='onMouseOverTr(this);' onmouseout='onMouseOutTr(this);'>
					<td align="center"><%= ++i %></td>
				 	<td><a href="#" onclick="getHostName(this,'<%= attachFile.getPath()%>' )"><%= !"".equals(attachFile.getTitle()) ? attachFile.getTitle() : attachFile.getAttachedFileName() %></a></td>
				  	<td><a href="#" onclick="getHostName(this,'<%= attachFile.getPath()%>' )"><%= attachFile.getAttachedFileName().substring(14) %></a></td>
				  	<td align="center"><%= attachFile.getDateCreated() != null ? new java.text.SimpleDateFormat("dd/MM/yyyy").format(attachFile.getDateCreated()) : "" %></td>
				  	<td align="center"><input style="width: 90%;margin-left: 0;" type="button" value='<liferay-ui:message key="delete"/>' onclick="deleteRowFileUpload(this, '<%=attachFile.getAttachedFileId() %>');" ></td>
				</tr>
			</logic:iterate>
		</table>
</fieldset>
<%
	} 
%>
<fieldset class="filborder">
		<label class="laborder"><liferay-ui:message key="pccc-cvdtn-toanvan"/></label>
		<table id="addfileupload" class="taglib-search-iterator table-pml" cellspacing="0" width="100%">
		<tr class="portlet-section-header results-header" >
			<td width="" ><liferay-ui:message key="document_attached_file_title" /></td>
			<td width="50%" ><liferay-ui:message key="document_attached_file_name" /></td>
			<td width="15%" align="center"><input style="width: 90%;margin-left: 0;" type="button" value='<liferay-ui:message key="document_more_file" />' onclick="uploadReceiptfile()"></td>
		</tr>
		</table>
</fieldset>
	
<!--  yenlt close start 10082010 -->
	<!--portlet:renderURL var="redirect" -->
		<!--portlet:param name="struts_action" value="/sgs/pcccdocumentreceiptprocess/view"/ -->
		<!--portlet:param name="page" value='</%="" + currentPage %>'/ -->
		<!--portlet:param name="limit" value='</%="" + currentLimit %>'/ -->
	<!--/portlet:renderURL -->
	
<input type="hidden" name="<portlet:namespace/>redirect" value="<%=redirect %>" />
<div align="right" id="table-button">
			<!--input type="hidden" name="page" value="</%=String.valueOf(currentPage) %>"/ -->
			<!--input type="hidden" name="limit" value="</%=String.valueOf(currentLimit) %>"/ -->
			<input class="button-width" type="submit"  value='<liferay-ui:message key="pccc-cvdtn-luu" />'>
			<input class="button-width" type="button" onclick="window.history.back()" value='<liferay-ui:message key="back" />'>
</div>
</div>
</form>