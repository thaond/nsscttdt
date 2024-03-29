<%@ include file="/html/portlet/ext/pcccdocumentreceiptprocess/init.jsp" %>
<%--liferay-util:include page="/html/portlet/ext/pcccdocumentreceiptprocess/js/pccc-docreceiptprocess.jsp"></liferay-util:include --%>

<liferay-util:include page="/html/portlet/ext/pcccdocumentsend/js/pccc-documentsend.jsp"></liferay-util:include>
<!-- <script type='text/javascript' src='/html/js/liferay/localdata.js'></script>-->
<script type='text/javascript' src='/html/js/liferay/jquery.js'></script>
<script type='text/javascript' src='/html/js/liferay/jquery.autocomplete.js'></script>
<link rel="stylesheet" type="text/css" href="/html/css/main.css" />
<link rel="stylesheet" type="text/css" href="/html/css/jquery.autocomplete.css" />
<%@page import="com.sgs.portlet.document.workflow.DocumentReceiptPortletAction"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.sgs.portlet.department.model.Department"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt"%>
<script type='text/javascript' src='/html/js/liferay/tr.js'></script>
<script type="text/javascript" >

function validateWriteDoc(){
	fileUpload();	
	
	var messageError="";
	var nguoikycvdtn = document.getElementById('signer');	
	var socongvancvdtn = document.getElementById('socongvancvdtn');	
	var loaicongvancvdtn = document.getElementById('loaicongvancvdtn');
	var trichyeucvdtn = document.getElementById('trichyeucvdtn');

	if (socongvancvdtn.value.trim() == "") {
		messageError = "<liferay-ui:message key='vui-long-nhap-so-cong-van-den'/>\n";
	    alert(messageError);
	    socongvancvdtn.focus();
		return false;
	}	
	if (loaicongvancvdtn.value.trim() == "") {
		messageError = "<liferay-ui:message key='vui-long-nhap-loai-cong-van-den'/>\n";
	    alert(messageError);
	    loaicongvancvdtn.focus();
		return false;
	}	

	if (nguoikycvdtn.value.trim() == "") {
		messageError = "<liferay-ui:message key='vui-long-nhap-thong-tin-nguoi-ky'/>\n";
	    alert(messageError);
	    nguoikycvdtn.focus();
		return false;
	}


	if (trichyeucvdtn.value.trim() == "") {
		messageError = "<liferay-ui:message key='doc-r5-alert'/>\n";
	    alert(messageError);
	    trichyeucvdtn.focus();
		return false;
	}	

	if (checkFileUpload() == false) {
		return false;
	}		
	else{
		return true;
	}
	
}

function fileUpload() {
	var listNameRow = "";
	var valueNameFile ="";
	var tileFile ="";
	for(i = 0; i < incstt; i++) {
		if(document.getElementById('namefile'+ i)) {			
			listNameRow += "namefile" + i + "_";
			valueNameFile += document.getElementById('namefile'+ i).value +"/";
		}

		if (document.getElementById('titlefile'+ i)) {
			tileFile += document.getElementById('titlefile'+ i).value + "#";	
		}
	}
	document.getElementById('nameFieldRow').value = listNameRow;
	document.getElementById('nameFiles').value = valueNameFile;
	document.getElementById('titleFiles').value = tileFile;
		
}


function checkFileUpload() {
	for(i = incstt -1 ; i >= 0; i--) {
		if(document.getElementById('namefile'+ i)) {			
			var valueNameFile1 = document.getElementById('namefile'+ i).value;
			var fileTitle = document.getElementById('titlefile'+ i);
			var type = valueNameFile1.substring(valueNameFile1.lastIndexOf(".") + 1);
			if (valueNameFile1 == "") {
				alert("<liferay-ui:message key='pccc-vuilongchontaptindinhkem'/>");
				fileTitle.focus();
				return false;
			}
				
			if("html" == type || "htm" == type || "doc" == type || "docx" == type || "xls" == type || "xlsx" == type || "jpg" == type || "pmp" == type || "pdf" == type) {
				return true;
			}
			else {
				alert("<liferay-ui:message key='pccc-saidinhdang'/>");
				fileTitle.focus();
				return false;
			}
		}
	}
	return true;
}

window.onload = function () {
	changeDocumentRecordType();
	document.getElementById('btn_receiveplace').focus();
}

</script>
<script type="text/javascript">
	var noiNhan;
	var nguoiKy;
	
	dwr.engine.beginBatch();
		documentSendUtilClient.getIssuingPlaceName( function (data){
			if (data.length > 0) {
				noiNhan = [data.length];
				for ( var i = 0; i < data.length; i++) {
					noiNhan[i] = data[i] + "";			
				}
				return noiNhan;
			}
		});
		// vu close code 20110217
		//documentSendUtilClient.getSignerName( function (data){
			//if (data.length > 0) {
				//nguoiKy = [data.length];
				//for ( var i = 0; i < data.length; i++) {
					//nguoiKy[i] = data[i] + "";			
				//}
				//return nguoiKy;
			//}
			
		//});
		// end vu close code 20110217
		
	// vu update 20110217  chon nguoi ki van ban se hien thi them chuc vu
		documentSendUtilClient.getSigner( function (data){
			if (data.length > 0) {
				nguoiKy = [data.length];
				for ( var i = 0; i < data.length; i++) {
					nguoiKy[i] = data[i].userName + "";					
				}
				return nguoiKy;
			}
			
		});
				
	// end vu update 20110212	
		
	dwr.engine.endBatch({
	  async:false
	});
	
	// vu update 20110217  chon nguoi ki van ban se hien thi them chuc vu
		function chucVu(){
		var signer = document.getElementById('signer').value;
		var chucVu = "";
		dwr.engine.beginBatch();
		documentSendUtilClient.getSigner( function (data){
			if (data.length > 0) {				
				for ( var i = 0; i < data.length; i++) {
					if(data[i].userName == signer){		
						chucVu = data[i].position;
						break;
					}						
				}				
			}
			
		});
		dwr.engine.endBatch({
			  async:false
			});
		document.getElementById('position').value = chucVu;
		
	}
	// end vu update 20112017
	
	$().ready(function() {
		jQuerythoind("#receiveplace").autocomplete(noiNhan, {
			multiple: true,
			multipleSeparator: '; ',
			minChars: 0,
			matchContains: true,
			autoFill: true}
			);
		$jq("#signer").autocomplete({
			source: nguoiKy,
			select: function(even, ui){
				setTimeout('chucVu()',150);	
			}
			});
	});
</script>
<portlet:actionURL var="add">
	<portlet:param name="struts_action" value="/sgs/pcccdocumentreceiptprocess/writeDocument" />
</portlet:actionURL>
<form action="<%=add %>" name="<portlet:namespace/>fm" enctype="multipart/form-data" onsubmit="return validateWriteDoc()" method="post" class="table-border-pml">
	<%
		User nguoiTaoCV = (User) renderRequest.getAttribute("user");
		String tenNguoiTaoCV = nguoiTaoCV.getLastName() + " " + nguoiTaoCV.getMiddleName() + " " + nguoiTaoCV.getFirstName();
	%>
	<input type="hidden" id="userIdLogin" value="<%= String.valueOf(nguoiTaoCV.getUserId()) %>">
<div class="title_categ"><liferay-ui:message key="soan-cong-van-di"/></div>
<div class="boxcontent">

<table width="100%" cellspacing="0">
<tr>
	<td width="16%"><div align="left"><label><liferay-ui:message key="receipt.docrectype"/><font color="#FF0000" size="1">(*)</font>&nbsp;:</label></div></td>
    <td>
    	<select name="<portlet:namespace/>documentRecordTypeId" id="socongvancvdtn" style="width:60%" onchange="changeDocumentRecordType()">
	   	<logic:iterate id="pmlEdmDocumentRecordType" name="pmlEdmDocumentRecordTypeList" type="com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType" scope="request">
    	<option value="<%= pmlEdmDocumentRecordType.getDocumentRecordTypeId() %>"> <%= pmlEdmDocumentRecordType.getDocumentRecordTypeName() %> </option>
    	</logic:iterate>
    	</select>
    	<liferay-ui:message key="so-cua-phong"/><input id="soVanBanCuaPhong" name="<portlet:namespace/>soVanBanCuaPhong" type="checkbox" onclick="loadDocumentRecordType()"/>
    <td ><label><liferay-ui:message key="receipt.doctype"/> <font color="red">(*)</font> &nbsp;:</label></td>
    <td>
   	<select name="<portlet:namespace/>documentTypeId" id="loaicongvancvdtn" style="width:99%" >
    </select>
	</td>
</tr>
<tr>
	<td width="16%"><liferay-ui:message key="receipt.creator"/>&nbsp;:</td>
	<td width="34%"><input style="width:88%" type="text" readonly="readonly" name="<portlet:namespace/>editorId" id="nguoitaocvdtn" value="<%= tenNguoiTaoCV %>"></td>
	<td ><label><liferay-ui:message key="receipt.department"/>&nbsp;:</label></td>
    <td><input style="width:98%" type="text" readonly="readonly" name="<portlet:namespace/>department" id="dept" value='<%= ((Department) renderRequest.getAttribute("department")).getDepartmentsName() %>'></td>
   
</tr>
<tr>
    <td ><label><liferay-ui:message key="receipt.confidentallevelid"/> <font color="red">(*)</font> &nbsp;:</label></td>
    <td>
    <select  name="<portlet:namespace/>confidentialLevelId" id="domatcvdtn" style="width:90%">
    	<logic:iterate id="pmlEdmConfidentialLevel" name="pmlEdmConfidentialLevelList" type="com.sgs.portlet.document.receipt.model.PmlEdmConfidentialLevel" scope="request">
	    <option value="<%= pmlEdmConfidentialLevel.getConfidentialLevelId() %>"> <%= pmlEdmConfidentialLevel.getConfidentialLevelName() %> </option>
		</logic:iterate>
    </select>
    </td>
    <td ><label><liferay-ui:message key="receipt.previlegenlevelid"/> <font color="red">(*)</font> &nbsp;:</label></td>
    <td>
    <select name="<portlet:namespace/>privilegenLevelId" id="dokhancvdtn" style="width:99%">
		<logic:iterate id="pmlEdmPrivilegeLevel" name="pmlEdmPrivilegeLevelList" type="com.sgs.portlet.document.receipt.model.PmlEdmPrivilegeLevel" scope="request">
		<option value="<%= pmlEdmPrivilegeLevel.getPrivilegeLevelId() %>"> <%= pmlEdmPrivilegeLevel.getPrivilegeLevelName() %> </option>
	   	</logic:iterate>
	</select>
    </td>
</tr>
<tr>
    <td ><label><liferay-ui:message key="receipt.signer"/>:</label></td>
    <td>
	   	<input style="width:72.5%" type="text" name="<portlet:namespace/>signerName" id="signer" onchange="chucVu();">
	   	<input type="hidden" id="signerId"  name="<portlet:namespace />signerId" >	
		<span style="cursor: pointer">
		<input id="btn_signer" type="button" value="..."  onclick="mypopupSigner()" style="width: 15%">
		</span>
    </td>
    <td><div align="left"><label><liferay-ui:message key="receipt.position"/>&nbsp;:</label></div></td>
	<td><input style="width: 98%" type="text" maxlength="50" name="<portlet:namespace/>position" id="position" ></td>
	    
</tr>
<tr>
	<td>
		<div align="left">
			<label><liferay-ui:message key="receipt.docid"/>&nbsp;:</label>
		</div>
	</td>
	<td>
		<input style="width: 88%" type="text" maxlength="45" name="<portlet:namespace/>documentSendCode" id="docid" >
	</td>
	<td>
		<div align="left">
			<label><liferay-ui:message key="pccc-cvdtn-canphucdap"/>&nbsp;:</label>
		</div>
	</td>
    <td width="40%" >
    	<input name="<portlet:namespace />ishasdoc" type="checkbox" id="ishasdoc" />
    </td>
</tr>
<tr>
	
	<td ><label><liferay-ui:message key="receipt.receiveplace"/> &nbsp;:</label></td>
    <td>
    	<input style="width:72.5%" type="text" name="<portlet:namespace/>receivingPlace" id="receiveplace">
    	<input type="hidden" id="issuingPlaceId"  name="<portlet:namespace />issuingPlaceId" style="width: 35%">
   		<span style="cursor: pointer">
		<input  id="btn_receiveplace" type="button" value="..."  onclick="mypopupIssuingplace()" style="width: 15%">
   		</span>
    </td>
	<td>
		<div align="left">
			<label><liferay-ui:message key="receipt.page"/>&nbsp;:</label>
		</div>
	</td>
	<td>
		<input type="text" style="width: 98%" maxlength="50" name="<portlet:namespace/>numberPage" id="page" >
	</td>
</tr>
<tr>
	 <td  valign="top"><div align="left"><label><liferay-ui:message key="receipt.briftcontent"/><font color="#FF0000" size="1">(*)</font>:</label></div></td>
	<td colspan="3"><textarea name="<portlet:namespace/>briefContent" id="trichyeucvdtn" rows="2" style="width:98%"></textarea></td>
</tr>

<tr>
    <td>
    	<div align="left">
    		<label><liferay-ui:message key="pccc-cvdtn-hosocongviec"/>&nbsp;:</label>
    	</div>
    </td>
    <td colspan="3">
     <div class="cvd-filedinhkem table-border-pml" style="width: 99.3%;">
      	
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
							
			%>
			<tr class="portlet-section-header results-header" >
				<td align="center" style="width: 40px"><img src="/html/images/grippy.png" />&nbsp;<%= rowAllNameChecked.toString() %></td>
				<td align="center" style="width: 40px">STT</td>
				<td ><liferay-ui:message key="pml_tieude"/></td>
			</tr>
			<logic:iterate id="pmlHoSoCongViec" name="pmlHoSoCongViecList" indexId="i" type="com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec"  >
			<tr class='<%=(i % 2) == 0 ? "results-row" : "tr_two results-row" %>' onmouseover='onMouseOverTr(this);' onmouseout='onMouseOutTr(this);'>
				<td align="center">
					<img src="/html/images/grippy.png" />&nbsp;<input onClick="Liferay.Util.checkAllBox(<%= formName%>, '<%=  rowName %>', <%= rowAllName %>);" name="<portlet:namespace />HSCV" value="<%= pmlHoSoCongViec.getIdHoSoCongViec()  %>" type="checkbox"   />
				</td>
				<td align="center"><%= i + 1 %>.</td>
				<td><%= pmlHoSoCongViec.getTieuDe() %></td>
			</tr>
			</logic:iterate>
			</table>
       </div>
    </td>      
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
	<input type="hidden" name="<portlet:namespace/>receiverId" id="userId" value="<%=PortalUtil.getUserId(renderRequest) %>" />
</table>
</fieldset>

<br>
<fieldset class="filborder">
<legend class="laborder"><liferay-ui:message key="receipt.answer"/></legend>
<table cellspacing="0" width="100%">	
<tr>
	<td width="16%"><label><liferay-ui:message key="receipt.comingdocid"/>&nbsp;:</label></td>
	<td width="34%"><%= ((PmlEdmDocumentReceipt)renderRequest.getAttribute("pmlEdmDocumentReceipt")).getDocumentReference() %></td>
	<td width="16%"><liferay-ui:message key="receipt.internalid"/>&nbsp;:</td>
	<td ><%= ((PmlEdmDocumentReceipt)renderRequest.getAttribute("pmlEdmDocumentReceipt")).getNumberDocumentReceipt() %></td>
	<%-- //.getNumberLocalDocumentReceipt() --%>
</tr>
<tr>
	<td><label><liferay-ui:message key="document_attached_file"/>&nbsp;:</label></td>
	<td>
	<logic:iterate id="pmlEdmAttachedFile" name="pmlEdmAttachedFileList" type="com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile" scope="request">
	<a href="<%= pmlEdmAttachedFile.getPath() %>"><bean:write name="pmlEdmAttachedFile" property="title"/></a><br/>
	</logic:iterate>
	</td>
	<td></td>
	<td></td>
</tr>
<tr valign="top">
	<td><liferay-ui:message key="receipt.desc"/>&nbsp;:</td>
	<td colspan="3"><textarea class="textarea-display" readonly="" rows="5" style="width: 98%"><%= ((PmlEdmDocumentReceipt)renderRequest.getAttribute("pmlEdmDocumentReceipt")).getBriefContent() %></textarea></td>

</tr>
</table>
</fieldset>
<br>
<div align="right" id="table-button">
		<liferay-util:include page="/html/portlet/ext/pcccdocumentreceiptprocess/common/taskAction.jsp"></liferay-util:include>
		<input type="reset" value='<liferay-ui:message key="reset" />'>
		<input type="button" onclick="window.history.back()" value='<liferay-ui:message key="back" />'>
</div>
</div>
</form> 