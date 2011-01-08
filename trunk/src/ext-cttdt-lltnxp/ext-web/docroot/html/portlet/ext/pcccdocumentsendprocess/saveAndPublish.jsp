<%@ include file="/html/portlet/ext/pcccdocumentsend/init.jsp" %>
<%@ include file="/html/portlet/ext/pcccdocumentsendprocess/js/pccc-documentsend.jsp" %>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.sgs.portlet.document.send.service.persistence.PmlEdmDocumentSendUtil"%>
<%@page import="com.sgs.portlet.document.send.model.PmlEdmDocumentSend"%>
<%@page import="com.sgs.portlet.document.workflow.DocumentReceiptPortletAction"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.sgs.portlet.department.model.Department"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.sgs.portlet.document.workflow.DocumentSendPortletAction"%>
<%@page import="com.sgs.portlet.position.model.Position"%>
<%@page import="com.sgs.portlet.document.send.dto.DocumentSendDTO"%>
<%@page import="com.sgs.portlet.organizationexternal.model.OrganizationExternal"%>
<%@page import="com.sgs.portlet.organizationexternal.service.OrganizationExternalLocalServiceUtil"%>
<%@page import="com.sgs.portlet.organizationexternal.service.persistence.OrganizationExternalUtil"%>
<%@page import="com.sgs.portlet.document.send.PmlEdmDocumentSendCanNotPublishException"%>

<!-- <script type='text/javascript' src='/html/js/liferay/localdata.js'></script>-->
<script type='text/javascript' src='/html/js/liferay/jquery.js'></script>
<script type='text/javascript' src='/html/js/liferay/jquery.autocomplete.js'></script>

<link rel="stylesheet" type="text/css" href="/html/css/main.css" />
<link rel="stylesheet" type="text/css" href="/html/css/jquery.autocomplete.css" />
<link type="text/css" rel="stylesheet"	href="/html/css/calendar-system.css" />
<link type="text/css" rel="stylesheet" href="/html/portlet/ext/pcccdocumentsendprocess/css/letter.css" />

<script type="text/javascript" src="/html/js/calendar.js"></script>
<script type="text/javascript" src="/html/js/calendar-setup.js"></script>
<script type="text/javascript" src="/html/js/calendar-en.js"></script>
<script type='text/javascript' src='/html/js/liferay/tr.js'></script>
<script type="text/javascript" >
window.onload = function () {
	//changeDocumentRecordType(); // phmphuc close 01/12/2010 thay the bang function ben duoi
	getDocumentRecordByDocTypeId();
	document.getElementById('sohieucvdtn').focus();	
	if (document.getElementById('ngayguicvdtn') != null) {
		callCalendar('ngayguicvdtn','cal-button-issuingDate');
	}
	if (document.getElementById('ngaybanhanhcvdtn') != null) {
		callCalendar('ngaybanhanhcvdtn','cal-button-dateArrive');
	}
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
		
		documentSendUtilClient.getSignerName( function (data){
			if (data.length > 0) {
				nguoiKy = [data.length];
				for ( var i = 0; i < data.length; i++) {
					nguoiKy[i] = data[i] + "";			
				}
				return nguoiKy;
			}
			
		});
		
	dwr.engine.endBatch({
	  async:false
	});
	
	$().ready(function() {
		jQuerythoind("#receiveplace").autocomplete(noiNhan, {
			multiple: true,
			minChars: 0,
			matchContains: true,
			autoFill: true}
			);
		jQuerythoind("#signer").autocomplete(nguoiKy, {		
			minChars: 0,
			matchContains: true,
			autoFill: true});
	});
</script>
<portlet:actionURL var="saveAndPublish">
</portlet:actionURL>

<%
	List<OrganizationExternal> orgExtList = new ArrayList<OrganizationExternal>();
	try {
		orgExtList = OrganizationExternalLocalServiceUtil.getOrganizationExternals(-1,-1);
	} catch (Exception e) {
		orgExtList = new ArrayList<OrganizationExternal>();
	}
	DocumentSendDTO documentDTO = (DocumentSendDTO) renderRequest.getAttribute("documentDTO");
	String departmentName = (String) renderRequest.getAttribute("departmentName");
	String departmentsId = (String) renderRequest.getAttribute("departmentsId");
	
	long creatorId = 0;
	PmlEdmDocumentSend pmlDocSend = PmlEdmDocumentSendUtil.findByPrimaryKey(documentDTO.getDocumentSendId());
	if(pmlDocSend != null) {
		creatorId = pmlDocSend.getEditorId();
	}
%>
<form action="<%=saveAndPublish%>" enctype="multipart/form-data" onsubmit="return validateFormEdit()" method="post">
<liferay-ui:error exception="<%= PmlEdmDocumentSendCanNotPublishException.class %>" message="can-not-publish-documentsend" />
<input type="hidden" name="<portlet:namespace/>nameFieldRow" id="nameFieldRow" value="" />
<input type="hidden" name="<portlet:namespace/>nameFiles" id="nameFiles" value="" />
<input type="hidden" name="<portlet:namespace/>isPublish" id="<portlet:namespace/>isPublish" value="" />
<input type="hidden" name="<portlet:namespace/>titleFiles" id="titleFiles" value="" />
<input type="hidden" name="<portlet:namespace/>userId" id="userId" value="<%=PortalUtil.getUserId(renderRequest) %>" />
<input type="hidden" id="isBookDocumentSend"  value="">
<input type="hidden" id="departmentsId"  value="<%= departmentsId %>">
<div class="title_categ"><liferay-ui:message key="cho-so-va-phat-hanh"/></div>
<div class="boxcontent">
	<table width="100%" cellspacing="0">
		<tr>
			<td colspan="2" align="left">
				<label><liferay-ui:message key="vb-phat-hanh-cua-giam-doc"/>:</label>&nbsp;
		   		<input type="checkbox" name="<portlet:namespace/>numOfDirector" id="numofdirector" onchange="changeSoHieuVBPublic();">
			</td>
		</tr>
		
		<tr>
			<td width="18%"><div align="left"><label><liferay-ui:message key="receipt.docref"/><font color="#FF0000" size="1">(*)</font>:</label></div></td>
			<td width="32%">
				<%-- phmphuc close and change by under code 08/11/2010 
		   		<input type="text" maxlength="30" style="width:92%" name="<portlet:namespace/>documentReference" id="sohieucvdtn" value="<%= documentDTO.getDocumentReference()%>">    
		   		--%>
		   		<input type="text" maxlength="10" style="width:25%" name="<portlet:namespace/>documentReference" id="sohieucvdtn" value="<%= documentDTO.getSoHieuVB() %>">    
		   		<input type="text" name="<portlet:namespace/>phanMoRong" id="phanmorong" value="<%= documentDTO.getPhanMoRong() %>" readonly="readonly">
		   		<!-- end phmphuc update 08/11/2010 --> 
			</td>
			
			<!-- phmphuc close and change 01/12/2010 - dua loai van ban len tren so van ban, dong thoi load so van ban theo loai van ban -->
			<%--
			<td width="18%" ><div align="left"><label><liferay-ui:message key="receipt.docrectype"/><font color="#FF0000" size="1">(*)</font>:</label></div></td>
			<td >
				<select name="<portlet:namespace/>documentRecordTypeId" id="socongvancvdtn" style="width:99%" onchange="changeDocumentRecordType()">
		        	<logic:iterate id="pmlEdmDocumentRecordType" name="pmlEdmDocumentRecordTypeList" type="com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType" scope="request">
		      			<option <%=pmlEdmDocumentRecordType.getDocumentRecordTypeName().equals(documentDTO.getDocumentRecord()) ? "selected" : "" %> value="<%= pmlEdmDocumentRecordType.getDocumentRecordTypeId() %>"> <%= pmlEdmDocumentRecordType.getDocumentRecordTypeName() %> </option>
		      		</logic:iterate>
		      	</select>    	      	
			</td>
			--%>
		    <td width="18%"><div align="left"><label><liferay-ui:message key="receipt.doctype"/><font color="#FF0000" size="1">(*)</font>:</label></div></td>
		    <td>
			    <select name="<portlet:namespace/>documentTypeId" id="loaicongvancvdtn" style="width:99%" onchange="getDocumentRecordByDocTypeId();">
			    	<logic:iterate id="documentType" name="pmlEdmDocumentTypeList" type="com.sgs.portlet.document.receipt.model.PmlEdmDocumentType" scope="request">
		      			<option <%= documentDTO.getDocumentType().equals(documentType.getDocumentTypeName()) ? "selected" : ""%> 
		      					value="<%=documentType.getDocumentTypeId() %>"><%=documentType.getDocumentTypeName() %></option>
		      		</logic:iterate>
			    </select>
		    </td>
			<!-- end phmphuc update 01/12/2010 -->
		</tr>
		
		<tr>
			<td ><div align="left"><label><liferay-ui:message key="receipt.senddate"/> :</label> </div></td>
			<td>
		   		<input type="text" name="<portlet:namespace/>sendDate" id="ngayguicvdtn" value='<%=new java.text.SimpleDateFormat("dd/MM/yyyy").format(new Date()) %>' style="width:82%">
			    <span style="cursor: pointer"><img align="top" id="cal-button-issuingDate" src="/html/images/cal.gif" onclick="callCalendar('ngayphathanhcvdtn','cal-button-issuingDate')"/></span>
			</td>
			<%-- phmphuc close and change 01/12/2010 
			<td><div align="left"><label><liferay-ui:message key="receipt.doctype"/><font color="#FF0000" size="1">(*)</font>:</label></div></td>
			<td>
		    	<select name="<portlet:namespace/>documentTypeId" id="loaicongvancvdtn" style="width:99%" >
			    </select>
		    </td>
		    --%>
		    <td><div align="left"><label><liferay-ui:message key="receipt.docrectype"/><font color="#FF0000" size="1">(*)</font>:</label></div></td>
		    <td>
				<select name="<portlet:namespace/>documentRecordToId" id="socongvancvdtn" style="width:99%" ></select>
		    </td>
		</tr>
		<tr>
			<td><div align="left"><label><liferay-ui:message key="receipt.issuingdate"/>:</label></div></td>
			<td>
				<input type="text" name="<portlet:namespace/>issuingDate" id="ngaybanhanhcvdtn" value='<%=new java.text.SimpleDateFormat("dd/MM/yyyy").format(new Date()) %>' style="width:82%">
			   	<span style="cursor: pointer"><img align="top" id="cal-button-dateArrive" src="/html/images/cal.gif" onclick="callCalendar('ngaydencvdtn','cal-button-dateArrive')"/></span>
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
			<td><div align="left"><label><liferay-ui:message key="receipt.creator"/>:</label></div></td>
			<td>
				<input style="width: 79%" type="text" name="<portlet:namespace/>creatorName" id="creator" value='<%=documentDTO.getEditor() != null ? documentDTO.getEditor() : "" %>' >	
				<input style="6%" type="hidden" id="creatorIdSP"  name="<portlet:namespace />creatorId" value='<%=creatorId %>'>
				<span style="cursor: pointer">
					<input  id="btn_creator" type="button" value="..."  onclick="mypopupCreator()" style="width: 10%">
				</span>
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
			<td><div align="left"><label><liferay-ui:message key="receipt.department"/>:</label></div></td>
			<td><input style="width: 92%" type="text" maxlength="50" name="<portlet:namespace/>department" id="dept" value='<%=departmentName != null ? departmentName : "" %>'></td>
			   
			<td><label><liferay-ui:message key="receipt.docid"/>:</label></td>
			<td>
				<input style="width: 95.5%" type="text" maxlength="45" name="<portlet:namespace/>documentSendCode" id="docid" value='<%=documentDTO.getDocumentSendCode() != null ? documentDTO.getDocumentSendCode() : "" %>' >
			</td> 
			
		</tr>
		<tr>
			<td width="10%" nowrap="nowrap"><label><liferay-ui:message key="receipt.receiveplace"/><font color="#FF0000" size="1">(*)</font>:</label></td>
			<td>
				<input type="text" name="<portlet:namespace/>receivingPlace" id="receiveplace" style="width: 79%" value='<%=documentDTO.getReceivingPlace() != null ? documentDTO.getReceivingPlace() : "" %>'>
		    	<input type="hidden" id="issuingPlaceId" name="<portlet:namespace />issuingPlaceId">
		   		<span style="cursor: pointer">
		   			<input  id="btn_receiveplace" type="button" value="..."  onclick="mypopupIssuingplace()" style="width: 10%">
		   		</span>
			</td>
			<td><label><liferay-ui:message key="receipt.page"/>:</label></td>
			<td>
				<input style="width: 95.5%" type="text" maxlength="50" name="<portlet:namespace/>numberPage" id="page" value='<%=(!"".equals(documentDTO.getNumberPage()) || !"0".equals(documentDTO.getNumberPage())) ? documentDTO.getNumberPage() : "" %>' >
			</td>
		</tr>
	
		<tr>
			<td><label><liferay-ui:message key="receipt.signer"/>:</label></td>
			<td>
					<input style="width: 79%" type="text" name="<portlet:namespace/>signerName" id="signer" value='<%=documentDTO.getSigner() != null ? documentDTO.getSigner() : "" %>' >	
					<input style="6%" type="hidden" id="signerId"  name="<portlet:namespace />signerId" >
					<span style="cursor: pointer">
						<input  id="btn_signer" type="button" value="..."  onclick="mypopupSigner()" style="width: 10%">
					</span>
			</td>
			<td valign="top"><div align="left"><label><liferay-ui:message key="receipt.issuingnum"/>:</label></div></td>
			<td>
				<input type="text" style="width: 95.5%" maxlength="30" name="<portlet:namespace/>numberPublist" id="issuingnum" >
			</td>
		</tr>
	
		<tr>
			<td><div align="left"><label><liferay-ui:message key="receipt.position"/>:</label></div></td>
			<td ><input style="width: 92%" type="text" maxlength="50" name="<portlet:namespace/>position" id="position" value='<%=documentDTO.getPosition() != null ? documentDTO.getPosition() : "" %>'></td>
			<td colspan="2"></td>
		</tr>
		<tr>
			<td><div align="left"><label><liferay-ui:message key="receipt.briftcontent"/><font color="#FF0000" size="1">(*)</font>:</label></div></td>
			<td colspan="3"><textarea  name="<portlet:namespace/>briefContent" id="trichyeucvdtn" rows="2" style="width:98.8%"><%=documentDTO.getBriefContent() != null ? documentDTO.getBriefContent() : "" %></textarea></td>
		</tr>
	
		<tr>
			<td >
			</td>
			<td>
				<input type="radio" name="publishOrLocal" value="" onclick="unChooseOrgExternal()" checked="checked">&nbsp;&nbsp;
				<liferay-ui:message key="org-local"/>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" name="publishOrLocal" value="" onclick="chooseOrgExternal()">&nbsp;&nbsp;
				<liferay-ui:message key="org-publish"/>
			</td>
			<td colspan="2">
		</tr>
	</table>

	<div id="divorgexternal" style="display: none;">
		<liferay-ui:tabs names="org-publish" param="publish" url="" value=""></liferay-ui:tabs>
		<div class="boxcontent_Tab">
				<table class="taglib-search-iterator table-pml" cellspacing="0" width="100%">	
					<tr class="portlet-section-header results-header" >
						<td align="center" width="40px"><liferay-ui:message key="select"/></td>
						<td ><liferay-ui:message key="org-ext"/></td>
					</tr>
					<% for (int k = 0; k < orgExtList.size(); k++) { 
						OrganizationExternal orgExt = orgExtList.get(k);
					%>
					<tr class="${((k % 2) == 0) ? 'results-row' : 'tr_two results-row'}" onclick="clickCheckBoxORG(event,this)" onmouseover='onMouseOverTr(this);' onmouseout='onMouseOutTr(this);'>
						<td align="center" id="<%= k%>">
							<input type="checkbox" onclick="clickCheckBoxORG(event,this)" name="<portlet:namespace/>orgExternalId" id="orgExternalId<%= k%>" value="<%= orgExt.getOrgExternalId() %>" />
						</td>
						<td ><%= orgExt.getOrgExternalCode() + "_" + orgExt.getOrgExternalName()%></td>
					</tr>
					<% } %>
				</table>
				<input type="hidden" name="<portlet:namespace/>orgExternalIdHidden" id="<portlet:namespace/>orgExternalIdHidden" value="<%= orgExtList.size()%>">
		</div>
	</div>

	<!-- minh update -->
	<fieldset class="filborder">
	<legend class="laborder"><liferay-ui:message key="pccc-documentsent-filevanbandidinhkem" /></legend>
		<table id="addfileupload_NoUpload" cellpadding="0" cellspacing="0" width="100%" class="taglib-search-iterator table-pml">
			<tr class="portlet-section-header results-header">
				<td width="40px" align="center"><div><liferay-ui:message key="sgs_onedoor_no."/></div></td>
				<td width="40%"><div><liferay-ui:message key="document_attached_file_title" /></div></td>
				<td ><div><liferay-ui:message key="document_attached_file_name" /></div></td>
			</tr>
		
			<logic:iterate id="attachedFile" name="attachedFiles" indexId="i" type="com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile" scope="request" >
				<tr style="height: 25px" class="<%=(i % 2) == 0 ?  "results-row" : "tr_two results-row" %>" onmouseover='onMouseOverTr(this);' onmouseout='onMouseOutTr(this);'>
					<td align="center"><%=i + 1 %></td>
					<td ><a href="<%=attachedFile.getPath() %>"><u><%=attachedFile.getTitle() %></u></a></td>
					<td ><a href="<%=attachedFile.getPath() %>"><u><%=attachedFile.getAttachedFileName().substring(14) %></u></a></td>
				</tr>
			</logic:iterate>
		</table>
	</fieldset>
	<!-- end update -->

	<fieldset class="filborder">
		<legend class="laborder"><liferay-ui:message key="document_attached_file" /></legend>
		<table id="addfileupload" cellpadding="0" cellspacing="0" width="100%" align="center" class="taglib-search-iterator table-pml">
			<tr class="portlet-section-header results-header">
				<td width="50%"><liferay-ui:message key="document_attached_file_title" /></td>
				<td width="35%"><liferay-ui:message key="document_attached_file_name" /></td>
				<td align="center"><input style="width: 90%" type="button" value='<liferay-ui:message key="document_more_file" />' onclick="uploadReceiptfile()"></td>
			</tr>
		</table>
	
	</fieldset>
	
	<div align="right" id="table-button">
				<liferay-util:include page="/html/portlet/ext/pcccdocumentsendprocess/common/taskAction.jsp"></liferay-util:include>
				<input type="reset" value='<liferay-ui:message key="reset" />' onclick="unChooseOrgExternal()">
				<input type="button" onclick="window.history.back()" value='<liferay-ui:message key="back" />'>
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

</html>
