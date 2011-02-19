<%@ include file="/html/portlet/ext/onedoorpcccprocess/init.jsp" %>
<%@ include file="/html/portlet/ext/onedoorpccc/js/pccc-onedoorreceipt.jsp" %>
<%@ include file="/html/portlet/ext/onedoorpcccprocess/js/onedoorpcccprocess-js.jsp" %>

<%@page import="com.sgs.portlet.onedoorpccc.model.PmlFilePCCC"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile"%>
<%@page import="java.util.List"%>
<%@page import="com.sgs.portlet.onedoorpccc.model.PmlPaintDocument"%>
<%@page import="com.sgs.portlet.onedoorpccc.model.impl.PmlFilePCCCAttachedFileImpl"%>
<%@page import="com.sgs.portlet.document.model.PmlProcessDispose" %>
<%@page import="com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile"%>
<%@page import="com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile"%>
<%@page import="com.sgs.portlet.onedoor.service.persistence.PmlFileTypeAttachedFileUtil"%>
<%@page import="com.sgs.portlet.onedoor.model.PmlFileAttachedFile"%>
<%@page import="com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile"%>
<%@page import="com.sgs.portlet.filetype.model.PmlFileType"%>
<%@page import="com.sgs.portlet.filetype.service.PmlFileTypeLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.liferay.portal.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.service.persistence.UserUtil"%>

<link type="text/css" rel="stylesheet" href="/html/portlet/ext/onedoorpcccprocess/css/style.css" />
<link type="text/css" rel="stylesheet" href="/html/css/changeColorRow.css" />
<%
	
	PmlFilePCCC filePCCC = (PmlFilePCCC) renderRequest.getAttribute("filePCCC"); 
	PmlOneDoorReceiveFile pmlFile = (PmlOneDoorReceiveFile) renderRequest.getAttribute("pmlFile");
	int paintDocumentSize = ((List<PmlPaintDocument>) renderRequest.getAttribute("paintDocuments")).size();
	List<PmlFileAttachedFile> attachFile = ((List<PmlFileAttachedFile>) renderRequest.getAttribute("attachFiles"));
	List<PmlFilePCCCAttachedFile> filePCCCAttachedFileList = (List<PmlFilePCCCAttachedFile>) renderRequest.getAttribute("filePCCCAttachedFiles");
	// yenlt 24052010
	String isDelegate = ParamUtil.getString(renderRequest, "isDelegate");
	String processValue = ParamUtil.getString(renderRequest, "processValue");
	// end yenlt 24052010
%>

<portlet:actionURL var="update">
	<portlet:param name="struts_action" value="/sgs/onedoorpcccprocess/update"/>
	<portlet:param name="fileId" value="<%=pmlFile.getFileId() %>"/>
</portlet:actionURL>

<form action="<%= update %>" enctype="multipart/form-data" name="frm_001_HS_001_ThemMoiHoSo"  method="post" onSubmit="return validateDocProcess()">
<input type="hidden" name="isDelegate" value="<%= isDelegate %>" > <!-- yenlt 24052010 -->
<div class="title_categ"><liferay-ui:message key="cap-nhat-thong-tin"/></div>
<div class="boxcontent">
<fieldset class="filnoborder_div">
	<ul>
		<li style="width: 49.6%; margin-right: 0.8%">
		<fieldset class="filborder">
		<legend class="laborder"><liferay-ui:message key="pccc-TN-thongtinhoso"/></legend>
		<table cellspacing="0" width="100%" class="bor_rgh">
			<tr>
			<td class="td0-left"><label><liferay-ui:message key='pccc-TN-loaihoso'/></label> 
			<font color="#FF0000" size="1">(*)</font>:</td>
			<td>
<%
	String fileTypeId = pmlFile.getFileTypeId();
	PmlFileType fileType = PmlFileTypeLocalServiceUtil.getPmlFileType(fileTypeId);
	String fileTypeName = fileType.getFileTypeName();
%>
				<input type="text" id="fileTypeIdName"  name="<portlet:namespace />fileType" style="width: 98%" value="<%=fileTypeName %>" readonly="readonly">
			</td>
		</tr>
		<tr>
			<td class="td0-left"><label><liferay-ui:message key='pccc-TN-sobiennhan'/></label><font color="#FF0000" size="1">(*)</font>:</td>
			<td>
				<input type="text"  id="numberReceipt" name="numberReceipt" style="width:98%" value="<%=pmlFile.getNumberReceipt() %>" readonly="readonly">					
			</td>
		</tr>
		<tr>
			<td class="td0-left"><label><liferay-ui:message key='pccc-TN-tenhoso'/></label> <font color="#FF0000" size="1">(*)</font>: </td>
			<td>
				<input id="fileName" name="fileName" type="text" value="<%=filePCCC.getFileName() %>" style="width:98%" maxlength="100">					
			</td>
		</tr>
		<tr>
			<td class="td0-left"><label><liferay-ui:message key='pccc-TN-nguoigiaohoso'/></label><font color="#FF0000" size="1">(*)</font>: </td>
			<td>
				<input id="applicationName" name="applicantName" type="text" value="<%=pmlFile.getApplicantName() %>" style="width:98%">					
			</td>
		</tr>
		<tr>
			<td class="td0-left"><label><liferay-ui:message key='pccc-TN-daidiendonvi'/></label>:</td>
			<td>
				<input id="applicantRepresentation" name="applicantRepresentation" type="text" style="width:98%" value="<%=filePCCC.getApplicantRepresentation() %>" maxlength="200">											
			</td>
		</tr>
		<tr>
			<td class="td0-left"><label><liferay-ui:message key='pccc-TN-diachi' /></label>:</td>
			<td><input id="permanentAddress"
				name="<portlet:namespace />permanentAddress" type="text"
						style="width: 98%" value="<%=pmlFile.getPermanentAddress() %>"></td>
							</tr>
		<tr>
			<td class="td0-left"><label><liferay-ui:message key='pccc-TN-dienthoai'/></label>:</td>
			<td>
				<input maxlength="15"  id="applicantTelephone" name="applicantTelephone" type="text" style="width:98%" value="<%=filePCCC.getApplicantTelephone() %>" />
			</td>
		</tr>
		<tr>
			<td class="td0-left"><label><liferay-ui:message key='pccc-TN-nguoinhan'/></label>:</td>
			<td>
				<input id="receiverUnit" name="receiveOfUnit" type="text" style="width:98%" value="<%=filePCCC.getReceiveOfUnit() %>" maxlength="100">					
			</td>
		</tr>
		<tr style="display: none">
			<td class="td0-left"><label><liferay-ui:message key='pccc-TN-daidiendonvi'/></label>:</td>
			<td>
				<input id="receiverRepresentation" name="receiverRepresentation" type="text" style="width:98%" value="<%=filePCCC.getReceiverRepresentation() %>" maxlength="200">											
			</td>
		</tr>
		<tr>
			<td class="td0-left"><label><liferay-ui:message key='pccc-TN-dienthoai'/></label>:</td>
			<td>
				<input maxlength="15" id="receiverTelephone" name="receiverTelephone" type="text" style="width:98%" value="<%=filePCCC.getReceiverTelephone() %>"/>
			</td>
		</tr>
		</table>
		</fieldset>
		
		<fieldset class="filborder">
		<legend class="laborder"><liferay-ui:message key="pccc-TN-hosothietke" /></legend>
		<table cellspacing="0" width="100%" class="bor_rgh">
			<tr>
			<td class="td0-left"><label><liferay-ui:message key='pccc-TN-congtrinh'/></label>:</td>
			<td >
			<input id="projectName" name="projectName" type="text" style="width:98%" value="<%=filePCCC.getProjectName() %>" maxlength="100">					
			</td>
		</tr>
		<tr>
			<td class="td0-left"><label><liferay-ui:message key='pccc-TN-hangmuc'/></label>:</td>
			<td>
				<input id="applicantCategory" name="applicantCategory" type="text" style="width:98%" value="<%=filePCCC.getApplicantCategory() %>" maxlength="200">					
			</td>
		</tr>
		<tr>
			<td class="td0-left"><label><liferay-ui:message key='pccc-TN-diadiemxaydung'/></label>:</td>
			<td>
				<input id="addressBuilder" name="addressBuilder" type="text" style="width:98%" value="<%=filePCCC.getAddressBuilder() %>" maxlength="200">					
			</td>
		</tr>
		<tr>
			<td class="td0-left"><label><liferay-ui:message key='pccc-TN-chudautu'/></label> <font color="#FF0000" size="1">(*)</font>: </td>
			<td>
				<input id="investor" name="investor" type="text" style="width:98%" value="<%=filePCCC.getInvestor() %>" maxlength="100">					
			</td>
		</tr>
		<tr>
			<td class="td0-left"><label><liferay-ui:message key='pccc-TN-donvithietke'/></label>:</td>
			<td>
				<input id="designCop" name="designCop" type="text" style="width:98%" value="<%=filePCCC.getDesignCop() %>" maxlength="200">
			</td>
		</tr>
		<tr>
			<td class="td0-left"><label><liferay-ui:message key='pccc-TN-sobohoso'/></label>:</td>
			<td>
				<input id="txt_DocNum" name="fileNumber" type="text" style="width:98%" maxlength="30" value="<%=filePCCC.getFileNumber() %>">
			</td>
		</tr>
		</table>
		</fieldset>
		</li>
		<li style="width: 49.6%;">
		<fieldset class="filborder">
		<legend class="laborder"><liferay-ui:message key="pccc-TN-thongtinquanly" /></legend>
		<table cellspacing="0" width="100%" class="bor_rgh">
			<tr>
				<td class="td0-left"><label><liferay-ui:message key='pccc-TN-thoigiannophoso'/></label> <font color="#FF0000" size="1">(*)</font>:</td>
				<td >
					<!-- minh update 20100524 -->				
					<!-- input id="applicantTime" name="ap plicantTime" type="text" class="width-input-tn" value='<%=pmlFile.getApplicationDate() != null ? new java.text.SimpleDateFormat("hh:mm:ss").format(pmlFile.getApplicationDate()) : "" %>' readonly="readonly"-->
					<input id="applicantTime" name="ap plicantTime" type="text" class="width-input-tn" value="<%= filePCCC.getApplicantTime()%>" readonly="readonly">
					<!-- end minh upate 20100524 -->
				</td>
			</tr>
			<tr>
				<td class="td0-left"><label><liferay-ui:message key='pccc-TN-ngaynophoso'/></label> <font color="#FF0000" size="1">(*)</font>:</td>
				<td>
					<input id="applicationDate" name="applicationDate" type="text" class="width-input-tn" value='<%=pmlFile.getApplicationDate() != null ? new java.text.SimpleDateFormat("dd/MM/yyyy").format(pmlFile.getApplicationDate()) : "" %>' readonly="readonly">
				</td>
			</tr>
			<tr>
				<td class="td0-left"><label><liferay-ui:message key='pccc-TN-ngayhentrakhach'/></label> <font color="#FF0000" size="1">(*)</font>:</td>
				<td>
					<input type="text" class="width-input-tn" id="expectedReturningDate" name="expectedReturningDate" readonly="readonly" value='<%=pmlFile.getExpectedReturningDate() != null ? new java.text.SimpleDateFormat("dd/MM/yyyy").format(pmlFile.getExpectedReturningDate()) : "" %>'>
				</td>
			</tr>
			<tr>
				<td class="td0-left"><label><liferay-ui:message key='pccc-TN-nguoinhaplieu'/> </label><font color="#FF0000" size="1">(*)</font>:</td>
<%
	//User receiverUser = UserLocalServiceUtil.getUserById(pmlFile.getReceiverId());
	//String receiver = receiverUser.getLastName() + " " + receiverUser.getMiddleName() + " " + receiverUser.getFirstName() ;
	User receiverUser = null;
	String receiver = "";
	try {
		receiverUser = UserLocalServiceUtil.getUserById(pmlFile.getReceiverId());
		receiver = receiverUser.getLastName() + " " + receiverUser.getMiddleName() + " " + receiverUser.getFirstName();
	}
	catch (Exception ex) {}
%>
				<td>
					<input id="receiver" name="receiver" type="text" class="width-input-tn" value="<%=receiver %>" readonly />
				</td>
			</tr>
			<tr>
				<td class="td0-left"><label><liferay-ui:message key='pccc-TN-ngaynhaplieu'/> </label><font color="#FF0000" size="1">(*)</font>:</td>
				<td>
					<input id="inputDataDate" name="inputDataDate" type="text" class="width-input-tn" value='<%=filePCCC.getInputDataDate() != null ? new java.text.SimpleDateFormat("dd/MM/yyyy").format(filePCCC.getInputDataDate()) : "" %>' readonly="readonly">
				</td>
			</tr>
			<tr valign="top">
				<td class="td0-left"><label><liferay-ui:message key='pccc-TN-ghichu'/></label>:</td>
				<td>
					<textarea style="width: 95%" id="noteinformationManagement" name="noteinformationManagement" class="width-input-tn" rows="4"><%=filePCCC.getNoteInformationManagement() %></textarea>
				</td>
			</tr>				  				  				  				  				  
			</table>
			</fieldset>
			
			<fieldset class="filborder">
			<legend class="laborder"><liferay-ui:message key="pccc-TN-thongtinthamkhao" /></legend>
			<table cellspacing="0" width="100%" class="bor_rgh">
			<tr>
				<td class="td0-left"><label><liferay-ui:message key='pccc-TN-tongsogioxuly'/></label>:</td>
				<td >
					<input id="totalHour" name="totalHour" type="text" style="width:80%" readonly="readonly" value="<%=filePCCC.getTotalHour() %>"/>
					<span>&nbsp;<liferay-ui:message key='pccc-TN-gio'/> </span>
				</td>
			</tr>
			</table>
			</fieldset>	
			<fieldset class="filborder">
			<legend class="laborder"><liferay-ui:message key="pccc-TN-ketluanvehosothamduyet" /></legend>
			<table cellspacing="0" width="100%" class="bor_rgh">
			<tr>
				<td valign="top" class="td0-left"><label><liferay-ui:message key='pccc-TN-ketluan'/></label>:</td>
				<td>
					<textarea style="width: 95%" id="conclusion" name="conclusion" class="width-input-tn" rows="4" ><%=filePCCC.getConclusion() %></textarea>
				</td>
			</tr>
			</table>
			</fieldset>
			
			<fieldset class="filborder">
			<legend class="laborder"><liferay-ui:message key="pccc-TN-dinhkemtaptin" /></legend>
			<input type="hidden" name="<portlet:namespace/>str_fileattachedfile" id="str_fileattachedfile" value="" />
			<table cellspacing="0" width="100%" class="bor_rgh">
<%
	if (filePCCCAttachedFileList == null || filePCCCAttachedFileList.size() == 0) {
%><!--
			<tr>
			 
				<td><b><liferay-ui:message key="pccc-TN-khongcohosodinhkem"/></b></td>
				<td></td>
				
			</tr>
			 -->
<%
	} else {
%>
			<tr valign="top">
				<td width="40px"><div align="center"><liferay-ui:message key="pccc-TN-stt"/></div></td>
				<td><div align="left"><liferay-ui:message key="pccc-TN-tentaptin"/></div></td>
				<td></td>
			</tr>
			</table>
			<table id="tblFileUpload" cellspacing="0" width="100%" class="bor_rgh">
			<logic:iterate id="filePCCCAttachedFile" name="filePCCCAttachedFiles" type="com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile" indexId="p">
			<tr>
				<td width="35px" ><div align="center"><%=p + 1 %></div></td>
				<td ><div align="left"><a href="#" onclick="getHostName(this,'<%= filePCCCAttachedFile.getPath()%>' )"><%=filePCCCAttachedFile.getAttachedFileName() %></a></div></td>
				<td><input type="button" value='<liferay-ui:message key="delete" />' onclick="deleteRowFileUpload(this, '<%= filePCCCAttachedFile.getAttachedFileId() %>')" ></td>
			</tr>
			</logic:iterate>
<%
	}
%>
			</table>
			<table id="attFile" align="center" cellpadding="2" width="100%">
			<tr>
				<td align="left"><input type="button" value='<liferay-ui:message key="pccc-TN-themtaptin" />' onclick="insDocumentReceiptRow()"></td>
			</tr>
			</table>
			<input type="hidden" name="<portlet:namespace/>manyFile" id="manyFile" value="" />
		 	<input type="hidden" name="<portlet:namespace/>valueManyFile" id="valueManyFile" value=""/>
			</fieldset>
		</li>
	</ul>
	<ul>
		<li style="width: 100%">
		<fieldset class="filborder">
		<legend class="laborder"><liferay-ui:message key="pccc-TN-hosodinhkem" /></legend>
		<input type="hidden" id="str_attachedfile" name="<portlet:namespace />str_attachedfile" value="" />
		<table class="taglib-search-iterator table-pml" cellspacing="0" width="100%">	
			<tr class="portlet-section-header results-header" >
				<td width='35px'  align="center"><liferay-ui:message key='sgs_onedoor_no.'/></td>
				<td width='3%'  align="center">##</td>
				<td width='50%'><liferay-ui:message key='sgs_onedoor_attached_file_name'/></td>
				<td align="center"><liferay-ui:message key='sgs_onedoor_original'/></td>
				<td align="center"><liferay-ui:message key='sgs_onedoor_copy'/></td>
				<td width="25%"><liferay-ui:message key='sgs_onedoor_note'/></td>
			</tr>
<%
	List<PmlFileTypeAttachedFile> pmlFileTypeAttachedFileList = PmlFileTypeAttachedFileUtil.findByFileTypeId(pmlFile.getFileTypeId());
	int pmlFileTypeAttachedFileSize = pmlFileTypeAttachedFileList.size();
	for(int index = 0; index < pmlFileTypeAttachedFileSize; index ++) {
		PmlFileTypeAttachedFile pmlFileTypeAttachedFile = pmlFileTypeAttachedFileList.get(index);
		String _checked = "";
		String _original = pmlFileTypeAttachedFile.getOriginal() + "";
		String _copy = pmlFileTypeAttachedFile.getCopy_() + "";
		String _note = "";
		String attachedFileId = "";
		int attachFileSize = attachFile.size();
		for(int i = 0; i < attachFileSize; i ++) {
			if(pmlFileTypeAttachedFile.getAttachedFileId().equals(attachFile.get(i).getAttachedFileId())) {
				_checked = "checked";
				_original = attachFile.get(i).getOriginal() + "";
				_copy = attachFile.get(i).getCopy_() + "";
				_note = attachFile.get(i).getNote();
				attachedFileId = attachFile.get(i).getFileAttachedFileId();
%>
<script type="text/javascript">
	document.getElementById('str_attachedfile').value += "<%= attachedFileId %>,<%= pmlFileTypeAttachedFile.getAttachedFileId() %>,name_<%= pmlFileTypeAttachedFile.getAttachedFileId() %>,banchinh_<%= pmlFileTypeAttachedFile.getAttachedFileId() %>,banphu_<%= pmlFileTypeAttachedFile.getAttachedFileId() %>,ghichu_<%= pmlFileTypeAttachedFile.getAttachedFileId() %>/";
</script>
<%
				break;
			}
		}
%>
		<tr class="${((index % 2)==0)? 'results-row':'tr_two results-row'}">
			<td align="center" ><%=(index + 1) %>.</td>
			<td  align="center"><input type="checkbox" name="<portlet:namespace />selectFile_<%= pmlFileTypeAttachedFile.getAttachedFileId() %>" value="1" <%= _checked %> onclick="setStrAttachedFile(this.checked, '<%= attachedFileId %>', '<%= pmlFileTypeAttachedFile.getAttachedFileId() %>','name_<%= pmlFileTypeAttachedFile.getAttachedFileId() %>','banchinh_<%= pmlFileTypeAttachedFile.getAttachedFileId() %>','banphu_<%= pmlFileTypeAttachedFile.getAttachedFileId() %>','ghichu_<%= pmlFileTypeAttachedFile.getAttachedFileId() %>')" /></td>
			<td ><%=pmlFileTypeAttachedFile.getAttachedFileName() %>
				<input size="5" type="hidden" name="<portlet:namespace />name_<%=pmlFileTypeAttachedFile.getAttachedFileId() %>" value="<%=pmlFileTypeAttachedFile.getAttachedFileName() %>" />
			</td>
			<td  align="center"><input size="5"  id="original" type="text" name="<portlet:namespace />banchinh_<%=pmlFileTypeAttachedFile.getAttachedFileId() %>" value="<%=_original %>" /></td>
			<td  align="center"><input size="5"  id="copy" type="text" name="<portlet:namespace />banphu_<%=pmlFileTypeAttachedFile.getAttachedFileId() %>" value="<%=_copy %>" /></td>
			<td><input type="text" name="<portlet:namespace />ghichu_<%=pmlFileTypeAttachedFile.getAttachedFileId() %>" rows="1" style="width: 200px" value="<%=_note %>" /></td>
		</tr>
<%
	}
%>
		</table>
		<input type="hidden" id="str_paintdocumnet" name="<portlet:namespace />str_paintdocumnet" value="" />
		<br>
		<!-- <table class="taglib-search-iterator table-pml" cellspacing="0" width="100%">-->
		<table id="tbl_DocDrawing" cellspacing="0" width="100%" class="taglib-search-iterator table-pml">
			<tr class="portlet-section-header results-header" >
				<td width="4%"><liferay-ui:message key="pccc-TN-stt"/></td>
				<td width="43%"><liferay-ui:message key="pccc-TN-tentailieubanve"/></td>
				<td width="8%"><liferay-ui:message key="pccc-TN-soluong"/></td>
				<td width="39%"><liferay-ui:message key="pccc-TN-ghichu"/></td>
				<td></td>
			</tr>
			<logic:iterate id="paintDocument" name="paintDocuments" indexId="i" type="com.sgs.portlet.onedoorpccc.model.PmlPaintDocument" scope="request"  >
				<tr class="${((index % 2)==0)? 'results-row':'tr_two results-row'}">
					<td align="center" id="sttbv"><div name="sttbv"><%=++i %>.</div></td>
					<td ><input style="width: 95%" type="text" id="tentailieubanve_<%= paintDocument.getPaintDocumentId() %>" name="<portlet:namespace />tentailieubanve_<%= paintDocument.getPaintDocumentId() %>" value="<%=paintDocument.getPaintDocumentName() %>" /></td>
					<td align="center"><input style="width: 80%"  type="text" id="soluong_<%= paintDocument.getPaintDocumentId() %>" name="<portlet:namespace />soluong_<%= paintDocument.getPaintDocumentId() %>" value="<%=paintDocument.getQuantity() %>" /></td>
					<td align="center"><input style="width: 95%" type="text" name="<portlet:namespace />ghichu_<%= paintDocument.getPaintDocumentId() %>" value="<%=paintDocument.getNote() %>" /></td>
					<td><input type="button" value='<liferay-ui:message key="delete"/>' onclick="deleteEditMainRow(this, <%= paintDocument.getPaintDocumentId() %>)" /></td>
				</tr>
				<script type="text/javascript">
					setStrPaintDocumnet('<%= paintDocument.getPaintDocumentId() %>', 'tentailieubanve_<%= paintDocument.getPaintDocumentId() %>', 'soluong_<%= paintDocument.getPaintDocumentId() %>', 'ghichu_<%= paintDocument.getPaintDocumentId() %>');
				</script>
			</logic:iterate>
			
		</table>
		<div align="right" style="padding-top: 15px;">
			<input type="button" value='<liferay-ui:message key='pccc-TN-themdulieu'/>' onclick="addRowEdit(stt.value);setStrPaintDocumnet('', 'tentailieubanve_' + stt.value, 'soluong_' + stt.value, 'ghichu_' + stt.value)" />
		</div>
		<!-- <br>-->
		<input type="hidden" id="stt" value="<%= paintDocumentSize %>" />
		
		<!-- <table id="tbl_DocDrawing" cellspacing="0" width="100%" >
			<tr class="portlet-section-header results-header" >
				<td width="4%"><liferay-ui:message key="pccc-TN-stt"/></td>
				<td width="43%"><liferay-ui:message key="pccc-TN-tentailieubanve"/></td>
				<td width="8%"><liferay-ui:message key="pccc-TN-soluong"/></td>
				<td width="39%"><liferay-ui:message key="pccc-TN-ghichu"/></td>
				<td></td>
			</tr>
		</table>
		<div align="right" style="padding-top: 15px;">
			<input type="button" value='<liferay-ui:message key='pccc-TN-themdulieu'/>' onclick="addRowEdit(stt.value);setStrPaintDocumnet('', 'tentailieubanve_' + stt.value, 'soluong_' + stt.value, 'ghichu_' + stt.value)" />
		</div>-->
		</fieldset>
		</li>
	</ul>
	<ul>
		<li style="width: 100%">
		<fieldset class="filborder">
		<legend class="laborder"><liferay-ui:message key="pccc-TN-trinhtuxuly" /></legend>
					<table class="taglib-search-iterator table-pml" cellspacing="0" width="100%">	
					<tr class="portlet-section-header results-header" >
							<td width="35px" align="center"><liferay-ui:message key="pccc-TN-stt"/></td>
							<td width="20%"><liferay-ui:message key="pccc-XL-nguoigui"/></td>
							<td align="center"><liferay-ui:message key="pccc-XL-ngaygui"/></td>
							<td width="20%"><liferay-ui:message key="pccc-XL-nguoiNhan"/></td>
							<td align="center"><liferay-ui:message key="pccc-DSHS-ngaynhan"/></td>
							<td width="35%"><liferay-ui:message key="pccc-TN-noidungxuly"/></td>						
						</tr>
					<logic:iterate id="processDispose" name="processDisposeList" type="com.sgs.portlet.document.model.PmlProcessDispose" indexId="k">
					<%	
						//User nguoiGui = processDispose.getProcesser() != 0 ? UserUtil.findByPrimaryKey(processDispose.getProcesser()) : null;
						//String tenNguoiGui = nguoiGui != null ? nguoiGui.getLastName() + " " + nguoiGui.getMiddleName() + " " + nguoiGui.getFirstName() : "";
						User nguoiGui = null;
						String tenNguoiGui = "";
						try {
							nguoiGui = UserUtil.findByPrimaryKey(processDispose.getProcesser());
							tenNguoiGui = nguoiGui.getLastName() + " " + nguoiGui.getMiddleName() + " " + nguoiGui.getFirstName();
						}
						catch (Exception ex) {}
						
						//User nguoiNhan = processDispose.getReceiver() != 0 ? UserUtil.findByPrimaryKey(processDispose.getReceiver()) : null;
						//String tenNguoiNhan = nguoiNhan != null ? nguoiNhan.getLastName() + " " + nguoiNhan.getMiddleName() + " " + nguoiNhan.getFirstName() : "";;
						User nguoiNhan = null;
						String tenNguoiNhan = "";
						try {
							nguoiNhan = UserUtil.findByPrimaryKey(processDispose.getReceiver());
							tenNguoiNhan = nguoiNhan.getLastName() + " " + nguoiNhan.getMiddleName() + " " + nguoiNhan.getFirstName();
						}
						catch (Exception ex) {}
					%>
						<tr class="${((k % 2)==0)? 'results-row':'tr_two results-row'}">
							<td align="center"><%=k+1 %>.</td>
							<td width="20%"><%= tenNguoiGui%></div></td>
							<td align="center"><%=processDispose.getDateProcess() != null ? new SimpleDateFormat("dd/MM/yyyy").format(processDispose.getDateProcess()) : "" %></td>
							<td width="20%"><%=tenNguoiNhan%></div></td>
							<td align="center"><%=processDispose.getReceiveDate() != null ? new SimpleDateFormat("dd/MM/yyyy").format(processDispose.getReceiveDate()) : "" %></td>
							<td width="35%"><%=processDispose.getProcessInfomation() %></div></td>
						</tr>
					</logic:iterate>
					</table>
			</fieldset>
		</li>
	</ul>

			<portlet:renderURL var="redirect">
				<portlet:param name="struts_action" value="/sgs/onedoorpcccprocess/view"/>
			</portlet:renderURL>
			
			<portlet:renderURL var="back">
				<portlet:param name="struts_action"	value="/sgs/onedoorpcccprocess/view" />
				<portlet:param name="transitionBack" value="transitionBack" />
				<portlet:param name='<%= com.sgs.liferay.jbpm.util.Constants.WORKFLOW_PARAM_PREFIX + "fileId" %>' value='<%= ParamUtil.getString(renderRequest, "fileId") %>' />
				<portlet:param name="isDelegate" value="<%= isDelegate %>" />
				<portlet:param name="processValue" value="<%= processValue %>" /> 
		 	</portlet:renderURL> 
<div id ="table-button" align="right" >
				<input type="hidden" id="listAttachFileId" name="<portlet:namespace />listAttachFileId" value=""/>
				<input style="margin-top: 15px;" type="hidden" name="<portlet:namespace/>redirect" value="<%=redirect %>">
				<input style="margin-top: 15px;" class="button" type="submit" value='<liferay-ui:message key="pccc-TN-luuhoso"/>' name="luu">	 
	     		<span onclick="javascript:submitForm(document.hrefFm,'<%= back %>');" ><input style="margin-top: 15px;" class="button" type="button" value='<liferay-ui:message key="back"/>'></span>      
</div>
</fieldset>
</div>
</form>