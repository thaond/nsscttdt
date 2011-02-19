<%@ include file="/html/portlet/ext/pcccdocumentsend/init.jsp" %>

<%@page import="com.sgs.portlet.document.send.model.PmlEdmDocumentSend"%>
<%@page import="com.sgs.portlet.document.send.service.persistence.PmlEdmDocumentSendUtil"%>

<%@ include file="/html/portlet/ext/pcccdocumentsendprocess/js/pccc-documentsend.jsp" %>

<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.sgs.portlet.document.workflow.DocumentReceiptPortletAction"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.sgs.portlet.department.model.Department"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.sgs.portlet.document.workflow.DocumentSendPortletAction"%>
<%@page import="com.sgs.portlet.position.model.Position"%>
<%@page import="com.sgs.portlet.document.send.dto.DocumentSendDTO"%>


<%@page import="com.sgs.portlet.pmluser.service.PmlUserLocalServiceUtil"%>

<script type="text/javascript" src="/html/js/calendar.js"></script>
<script type="text/javascript" src="/html/js/calendar-setup.js"></script>
<script type="text/javascript" src="/html/js/calendar-en.js"></script>
<script type='text/javascript' src='/html/js/liferay/localdata.js'></script>
<script type='text/javascript' src='/html/js/liferay/jquery.js'></script>
<script type='text/javascript' src='/html/js/liferay/jquery.autocomplete.js'></script>

<link type="text/css" rel="stylesheet" href="/html/portlet/ext/pcccdocumentsendprocess/css/letter.css" />
<link rel="stylesheet" type="text/css" href="/html/css/main.css" />
<link rel="stylesheet" type="text/css" href="/html/css/jquery.autocomplete.css" />

<script type="text/javascript" >
window.onload = function () {
	//document.getElementById('sohieucvdtn').focus();
	//changeDocumentRecordTypeUpdate();
	//getDocumentRecordByDocTypeIdPhatHanh();
}
</script>
<!-- vu close code 20110215 
<script type="text/javascript">
$().ready(function() {
	jQuerythoind("#receiveplace").autocomplete(noiNhan, {
		multiple: true,
		multipleSeparator: '; ',
		minChars: 0,
		matchContains: true,
		autoFill: true}
		);
	jQuerythoind("#signer").autocomplete(nguoiKy, {		
		minChars: 0,
		autoFill: true});	
});
</script>
  end vu close code 20110215-->   
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
	// vu update 20110215  chon nguoi ki van ban se hien thi them chuc vu
		documentSendUtilClient.getSigner( function (data){
			if (data.length > 0) {
				nguoiKy = [data.length];
				for ( var i = 0; i < data.length; i++) {
					nguoiKy[i] = data[i].userName + "";					
				}
				return nguoiKy;
			}
			
		});
				
	// end vu update 20110215	
		
	dwr.engine.endBatch({
	  async:false
	});
	
	// vu update 20110215  chon nguoi ki van ban se hien thi them chuc vu
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
	// end vu update 20112015
	
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
   
<link type="text/css" rel="stylesheet"	href="/html/css/calendar-system.css" />
<%
	DocumentSendDTO documentDTO = (DocumentSendDTO) renderRequest.getAttribute("documentDTO");
	String departmentName = (String) renderRequest.getAttribute("departmentName");
	String departmentsId = (String) renderRequest.getAttribute("departmentsId");
	int countHSCVChoice = Integer.parseInt(renderRequest.getAttribute("countHSCVChoice").toString());
	String redirect = ParamUtil.getString(renderRequest, "redirect");	
	
	long creatorId = 0;
	PmlEdmDocumentSend pmlDocSend = PmlEdmDocumentSendUtil.findByPrimaryKey(documentDTO.getDocumentSendId());
	if(pmlDocSend != null) {
		creatorId = pmlDocSend.getEditorId();
	}
%>

<portlet:actionURL var="update">
	<portlet:param name="struts_action" value="/sgs/pcccdocumentsendprocess/updatesearch" />
	<portlet:param name="documentSendId" value='<%="" + documentDTO.getDocumentSendId() %>'/>
</portlet:actionURL>

<input type="hidden" id="documentSendId" value="<%= documentDTO.getDocumentSendId() %>"/>
<input type="hidden" id="departmentsId"  value="<%= departmentsId %>">

<input type="hidden" name="<portlet:namespace/>userId" id="userIdCreator" value="<%= String.valueOf(creatorId) %>" />
<input id="<portlet:namespace/>documentRecordTypeCode"  type="hidden"" value="<%=  HtmlUtil.escape(String.valueOf(documentRecordTypeCode))%>"  />
<input id="<portlet:namespace/>documentTypeCode"  type="hidden"" value="<%=   HtmlUtil.escape(String.valueOf(documentTypeCode))%>"  />
<input id="<portlet:namespace/>textAdd"  type="hidden"" value="<%=  HtmlUtil.escape(textAdd)%>"  />
<input id="<portlet:namespace/>departmentCode"  type="hidden"" value="<%=  HtmlUtil.escape(String.valueOf(departmentCode))%>"  />
<input id="<portlet:namespace/>useYear"  type="hidden"" value="<%=  HtmlUtil.escape(String.valueOf(useYear))%>"  />
<input type="hidden" id="<portlet:namespace/>documentRecordTypeIdHidden" value="<%= String.valueOf(documentDTO.getDocumentRecordTypeId()) %>"/>

<form autocomplete="off" action="<%= update %>" enctype="multipart/form-data" method="post" onsubmit="return checkUpdateform()">
<input type="hidden" id="<portlet:namespace/>nguoitaocvdtnHidden" value="<%= String.valueOf(creatorId) %>">
<div class="title_categ"><liferay-ui:message key="pccc-cvdtn-suacongvan"/></div>
<div class="boxcontent">
<table width="100%" cellspacing="0">
	<%--
	<tr>
		<td colspan="2" align="left">
			<label><liferay-ui:message key="vb-phat-hanh-cua-giam-doc"/>:</label>&nbsp;
	   		<input type="checkbox" name="<portlet:namespace/>numOfDirector" id="numofdirector" onchange="changeSoHieuVBPublic();"
	   			<%= documentDTO.getNumOfDirector() == true ? "checked" : "" %>>
		</td>
	</tr>
	--%>
	
	<tr>
		<td width="18%"><div align="left"><label><liferay-ui:message key="receipt.docref"/><font color="#FF0000" size="1">(*)</font>:</label></div></td>
		<td width="35%">
	   		<input type="text" maxlength="30" style="width:90%" name="<portlet:namespace/>documentReference" id="sohieucvdtn"
	   				 	value="<%= documentDTO.getDocumentReference() %>" readonly="readonly">    
	   		<%--
	   		<input type="text" name="<portlet:namespace/>phanMoRong" id="phanmorong" value="<%= documentDTO.getPhanMoRong() %>" 
	   					onblur="kiemTraSoVaKyHieuVB();" readonly="readonly">
	   		--%>
	   		<input type="hidden" id="sohieuHidden" value="<%= String.valueOf(documentDTO.getSoHieuVB()) %>">    
	   		<input type="hidden" id="phanmorongHidden" value="<%= documentDTO.getPhanMoRong() %>">    
	   		<input type="hidden" id="loaiVBHidden" value="<%= documentDTO.getDocumentTypeId() %>">
	   		<input type="hidden" id="loaiSoVBHidden" value="<%= documentDTO.getDocumentRecordTypeId() %>">
		</td>
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
		<td width="18%"><div align="left"><label><liferay-ui:message key="receipt.docrectype"/></label><font color="#FF0000" size="1">(*)</font>:</div></td>
		 <td >
			<select style="width: 50%" name="<portlet:namespace/>documentRecordTypeId" id="socongvancvdtn" onchange="changeDocumentRecordType()">
		        <logic:iterate id="pmlEdmDocumentRecordType" name="pmlEdmDocumentRecordTypeList" type="com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType" scope="request">
		      		<option <%=pmlEdmDocumentRecordType.getDocumentRecordTypeName().equals(documentDTO.getDocumentRecord()) ? "selected" : "" %> value="<%= pmlEdmDocumentRecordType.getDocumentRecordTypeId() %>"> <%= pmlEdmDocumentRecordType.getDocumentRecordTypeName() %> </option>
		      	</logic:iterate>
			</select>    	   
			<liferay-ui:message key="so-cua-phong"/><input id="<portlet:namespace/>soVanBanCuaPhong" name="<portlet:namespace/>soVanBanCuaPhong" type="checkbox" <%= documentDTO.isDocOfDepartment()? "checked":" " %> onclick="loadDocumentRecordTypeUpdate()" disabled="disabled"/>      	      	   	
	    </td>	
	    <td><div align="left"><label><liferay-ui:message key="receipt.doctype"/><font color="#FF0000" size="1">(*)</font>:</label></div></td>
	    <td>
		    <select name="<portlet:namespace/>documentTypeId" id="loaicongvancvdtn" style="width:99%" onchange="changeDocumentTypeSend()">
		    	<logic:iterate id="documentType" name="pmlEdmDocumentTypeList" type="com.sgs.portlet.document.receipt.model.PmlEdmDocumentType" scope="request">
	      			<option <%= documentDTO.getDocumentTypeId() == documentType.getDocumentTypeId() ? "selected" : ""%> 
	      					value="<%=documentType.getDocumentTypeId() %>"><%=documentType.getDocumentTypeName() %></option>
	      		</logic:iterate>
		    </select>
	    </td>
	</tr>
	
	<tr>
		<%-- phmphuc close and change 12/02/2011
		<td width="18%" ><liferay-ui:message key="nguoi-soan"/>&nbsp;:</td>
	    <td width="35%">
			<input style="width: 79%" type="text" name="<portlet:namespace/>creatorName" id="creator" value='<%=documentDTO.getEditor() != null ? documentDTO.getEditor() : "" %>' >	
			<input type="hidden" id="creatorIdSP" name="<portlet:namespace />creatorId">
			<span style="cursor: pointer">
				<input id="btn_creator" type="button" value="..."  onclick="mypopupCreator()" style="width: 10%">
			</span>
	    </td>
	    --%>
	    <td><div align="left"><label><liferay-ui:message key="phong-ban-soan"/>:</label></div></td>  
		<td>
			<select name="<portlet:namespace/>department" id="dept" style="width: 95%" onchange="getUsersByChangeDepartment();">
				<logic:iterate id="depart" name="departmentList" type="com.sgs.portlet.department.model.Department" scope="request">
					<option <%= depart.getDepartmentsId().equals(departmentsId) ? "selected" : ""%>
						value="<%= depart.getDepartmentsId() %>"> <%= depart.getDepartmentsName() %> </option>
				</logic:iterate>
			</select>
		</td>
	    <td><div align="left"><label><liferay-ui:message key="receipt.confidentallevelid"/><font color="#FF0000" size="1">(*)</font>:</label></div></td>
		<td>
			<select name="<portlet:namespace/>confidentialLevelId" id="domatcvdtn" style="width:99%">
			    <logic:iterate id="pmlEdmConfidentialLevel" name="pmlEdmConfidentialLevelList" type="com.sgs.portlet.document.receipt.model.PmlEdmConfidentialLevel" scope="request">
					<option <%=documentDTO.getConfidentialLevel().equals(pmlEdmConfidentialLevel.getConfidentialLevelName()) ? "selected" : "" %> value="<%= pmlEdmConfidentialLevel.getConfidentialLevelId() %>"> <%= pmlEdmConfidentialLevel.getConfidentialLevelName() %> </option>
				</logic:iterate>
			</select>
		</td>
	</tr>
	
	<tr>
		<%-- phmphuc close and change 12/02/2011
		<td><div align="left"><label><liferay-ui:message key="receipt.department"/>:</label></div></td>
		<td>
			<input style="width: 90%" type="text" name="<portlet:namespace/>department" id="dept" value='<%= departmentName != null ? departmentName : "" %>'>
		</td>
		--%>
		<td><div align="left"><label><liferay-ui:message key="nguoi-soan"/>:</label></div></td>
		<td>
			<select name="<portlet:namespace/>creatorName" id="creator" style="width: 95%">
				<logic:iterate id="pmluser" name="userList" type="com.sgs.portlet.pmluser.model.PmlUser" scope="request">
					<option <%= pmluser.getUserId() == creatorId ? "selected" : ""%>
						value="<%= pmluser.getUserId() %>"> <%= PmlUserLocalServiceUtil.getFullName(pmluser.getUserId()) %> </option>
				</logic:iterate>
			</select>
			<input style="6%" type="hidden" id="creatorIdSP" name="<portlet:namespace />creatorId" value='<%=creatorId %>'>
		</td>
		<td><div align="left"><label><liferay-ui:message key="receipt.previlegenlevelid"/><font color="#FF0000" size="1">(*)</font>:</label></div></td>
		<td>
			<select name="<portlet:namespace/>privilegenLevelId" id="dokhancvdtn" style="width:99%">
				<logic:iterate id="pmlEdmPrivilegeLevel" name="pmlEdmPrivilegeLevelList" type="com.sgs.portlet.document.receipt.model.PmlEdmPrivilegeLevel" scope="request">
					<option <%=documentDTO.getPrivilegel().equals(pmlEdmPrivilegeLevel.getPrivilegeLevelName()) ? "selected" : "" %> value="<%= pmlEdmPrivilegeLevel.getPrivilegeLevelId() %>"> <%= pmlEdmPrivilegeLevel.getPrivilegeLevelName() %> </option>
				</logic:iterate>
			</select>
		</td>
	</tr>
	
	<tr>
		<td><div align="left"><label><liferay-ui:message key="receipt.receiveplace"/><font color="#FF0000" size="1">(*)</font>:</label></div></td>
		<td>
			<div>
				<input type="text" name="<portlet:namespace/>receivingPlace" id="receiveplace" style="width: 79%" value='<%=documentDTO.getReceivingPlace() != null ? documentDTO.getReceivingPlace() : "" %>'>
			    <input type="hidden" id="issuingPlaceId" name="<portlet:namespace />issuingPlaceId">
			   	<span style="cursor: pointer">
			   		<input id="btn_receiveplace" type="button" value="..."  onclick="mypopupIssuingplace()" style="width: 10%">
			   	</span>
			</div>
		</td>
		<td><div align="left"><label><liferay-ui:message key="receipt.docid"/>:</label></div></td>
		<td>
			<input style="width: 96%" type="text" maxlength="45" name="<portlet:namespace/>documentSendCode" id="docid" value='<%=documentDTO.getDocumentSendCode() != null ? documentDTO.getDocumentSendCode() : "" %>' >
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
		<td><div align="left"><label><liferay-ui:message key="receipt.page"/>:</label></div></td>
		<td>
			<input style="width: 96%" type="text" maxlength="50" name="<portlet:namespace/>numberPage" id="page" value='<%=(!"".equals(documentDTO.getNumberPage()) || !"0".equals(documentDTO.getNumberPage())) ? documentDTO.getNumberPage() : "" %>' >
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
<legend class="laborder"><liferay-ui:message key="pccc-documentsent-filevanbandidinhkem"/></legend>
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
<legend class="laborder"><liferay-ui:message key="pccc-documentsent-filevanbandidinhkem" /></legend>
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