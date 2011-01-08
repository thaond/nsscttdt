<%@page import="com.sgs.portlet.pmluser.service.persistence.PmlUserUtil"%>
<%@page import="com.sgs.portlet.department.service.persistence.DepartmentUtil"%>
<%@ include file="/html/portlet/ext/pcccdocumentsend/init.jsp" %>
<%@ include file="/html/portlet/ext/pcccdocumentsend/js/pccc-documentsend.jsp" %>
<!-- <script type='text/javascript' src='/html/js/liferay/localdata.js'></script>-->
<script type='text/javascript' src='/html/js/liferay/jquery.js'></script>
<script type='text/javascript' src='/html/js/liferay/jquery.autocomplete.js'></script>
<link rel="stylesheet" type="text/css" href="/html/css/main.css" />
<link rel="stylesheet" type="text/css" href="/html/css/jquery.autocomplete.css" />
<%@page import="com.sgs.portlet.document.workflow.DocumentReceiptPortletAction"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.sgs.portlet.department.model.Department"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.sgs.portlet.document.workflow.DocumentSendPortletAction"%>
<%@page import="com.sgs.portlet.position.model.Position"%>
<script type='text/javascript' src='/html/js/liferay/tr.js'></script>
<script type="text/javascript" >
window.onload = function () {
	//changeDocumentRecordType(); // phmphuc close 11/11/2010 thay the bang function ben duoi
	getDocumentRecordByDocTypeId();
	//getIssuingPlaceName();
	//document.getElementById('sohieucvdtn').focus();	
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
		jQuerythoind("#signer").autocomplete(nguoiKy, {		
			minChars: 0,
			matchContains: true,
			autoFill: true});
		jQuerythoind("#receiveplace").autocomplete(noiNhan, {
			multiple: true,
			minChars: 0,
			matchContains: true,
			autoFill: true}
			);
	});
</script>
<portlet:actionURL var="add">
	<portlet:param name="struts_action" value="/sgs/pcccdocumentsend/view" />
	<portlet:param name="workflowAction" value="true"/>
	<portlet:param name="workflowActionName" value='<%=DocumentSendPortletAction.COMMAND_PREFIX + ".AddDocumentSendCommand"%>'/>
</portlet:actionURL>

<%
	String documentReference = (String) renderRequest.getAttribute("documentReference");
	User editor = (User) renderRequest.getAttribute("user");
	String username = editor.getLastName() + " " + editor.getMiddleName() + " " + editor.getFirstName();
	// vu update 31122010
	if(renderRequest.getAttribute("pmlEdmDocumentTypeListSend") != null){
		// end update vu
%>
		<form autocomplete="off" name="formdocumentsend" action="<%=add %>" enctype="multipart/form-data" onsubmit="return validateSendDocReceipt()" method="post">
		<div class="title_categ"><liferay-ui:message key="soan-cong-van-di"/></div>
		<div class="boxcontent">
		
		<table width="100%" cellspacing="0">
		<tr>
			<td width="16%"><div align="left"><label><liferay-ui:message key="receipt.creator"/>&nbsp;:</label></div></td>
			<td width="34%"><input style="width: 90%" type="text" maxlength="50" readonly="readonly" name="<portlet:namespace/>editorId" id="nguoitaocvdtn" value="<%= username %>"></td>
		    <%-- phmphuc close: thay doi thu tu dua loai VB ra truoc So VB
		    <td width="16%"><div align="left"><label><liferay-ui:message key="receipt.docrectype"/><font color="#FF0000" size="1">(*)</font>&nbsp;:</label></div></td>
		    <td>
				<select name="<portlet:namespace/>documentRecordTypeId" id="socongvancvdtn" style="width:99%" onchange="changeDocumentRecordType()">
		        	<logic:iterate id="pmlEdmDocumentRecordType" name="pmlEdmDocumentRecordTypeList" type="com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType" scope="request">
		      			<option value="<%= pmlEdmDocumentRecordType.getDocumentRecordTypeId() %>"> <%= pmlEdmDocumentRecordType.getDocumentRecordTypeName() %> </option>
		      		</logic:iterate>
		      	</select>    	      	
		    	<script language="javascript">
		    		// Mac dinh chon so cong van
		    		var objDRType = document.getElementById("socongvancvdtn");
		    		if (objDRType != null) {
		    			objDRType.value = "2";
		    		} // end if 
		    	</script>
		    </td>
		    --%>
		    <td width="16%"><div align="left"><label><liferay-ui:message key="receipt.doctype"/><font color="#FF0000" size="1">(*)</font>:</label></div></td>
		    <td>
			    <select name="<portlet:namespace/>documentTypeId" id="loaicongvancvdtn" style="width:99%"  onchange="getDocumentRecordByDocTypeId();">
			    	<logic:iterate id="pmlEdmDocumentType" name="pmlEdmDocumentTypeListSend" type="com.sgs.portlet.document.receipt.model.PmlEdmDocumentType" scope="request">
		      			<option value="<%= pmlEdmDocumentType.getDocumentTypeId() %>"> <%= pmlEdmDocumentType.getDocumentTypeName() %> </option>
		      		</logic:iterate>
			    </select>
		    </td>
		    <!-- end phmphuc update 11/11/2010 -->
		</tr>
		
		<tr>
			<td><div align="left"><label><liferay-ui:message key="receipt.department"/>&nbsp;:</label></div></td>
			<td><input style="width: 90%" type="text" maxlength="50" readonly="readonly" name="<portlet:namespace/>department" id="dept" value='<%= ((Department) renderRequest.getAttribute("department")).getDepartmentsName() %>'></td>
		    <%-- phmphuc close: thay doi thu tu dua loai VB ra truoc So VB
		    <td><div align="left"><label><liferay-ui:message key="receipt.doctype"/><font color="#FF0000" size="1">(*)</font>&nbsp;:</label></div></td>
		    <td>
		    	<select name="<portlet:namespace/>documentTypeId" id="loaicongvancvdtn" style="width:99%" >
			    </select>
		    </td>
		    --%>
		    
		    <td width="16%"><div align="left"><label><liferay-ui:message key="receipt.docrectype"/><font color="#FF0000" size="1">(*)</font>&nbsp;:</label></div></td>
		    <td>
				<select name="<portlet:namespace/>documentRecordTypeId" id="socongvancvdtn" style="width:99%">
		      	</select>    	      	
		    </td>
		    <!-- end phmphuc update 11/11/2010 -->
		</tr>
		
		<tr>
			<td><div align="left"><label><liferay-ui:message key="receipt.receiveplace"/>&nbsp;:</label></div></td>
			<td>		
				<input style="width:72.5%" type="text" name="<portlet:namespace/>receivingPlace" id="receiveplace"  >
				
			    <input type="hidden" id="issuingPlaceId"  name="<portlet:namespace />issuingPlaceId">
			   	<input  id="btn_receiveplace" type="button" value="..." onclick="mypopupIssuingplace()" style="width: 15%">
			
			</td>
		
			<td><div align="left"><label><liferay-ui:message key="receipt.confidentallevelid"/><font color="#FF0000" size="1">(*)</font>&nbsp;:</label></div></td>
			<td>
				<select name="<portlet:namespace/>confidentialLevelId" id="domatcvdtn" style="width:99%">
			    	<logic:iterate id="pmlEdmConfidentialLevel" name="pmlEdmConfidentialLevelList" type="com.sgs.portlet.document.receipt.model.PmlEdmConfidentialLevel" scope="request">
						<option value="<%= pmlEdmConfidentialLevel.getConfidentialLevelId() %>"> <%= pmlEdmConfidentialLevel.getConfidentialLevelName() %> </option>
					</logic:iterate>
				</select>
			</td>
		</tr>
			  
		<tr>
			<td><div align="left"><label><liferay-ui:message key="receipt.signer"/>&nbsp;:</label></div></td>
			<td>
			
				<input type="text" name="<portlet:namespace/>signerName" id="signer" style="width: 72.5%" >	
				<input type="hidden" id="signerId"  name="<portlet:namespace />signerId" >
				<input  id="btn_signer" type="button" value="..."  onclick="mypopupSigner()" style="width: 15%">
			
			</td>
				    
			<td><div align="left"><label><liferay-ui:message key="receipt.previlegenlevelid"/><font color="#FF0000" size="1">(*)</font>&nbsp;:</label></div></td>
			<td>
				<select name="<portlet:namespace/>privilegenLevelId" id="dokhancvdtn" style="width:99%">
			    	<logic:iterate id="pmlEdmPrivilegeLevel" name="pmlEdmPrivilegeLevelList" type="com.sgs.portlet.document.receipt.model.PmlEdmPrivilegeLevel" scope="request">
						<option value="<%= pmlEdmPrivilegeLevel.getPrivilegeLevelId() %>"> <%= pmlEdmPrivilegeLevel.getPrivilegeLevelName() %> </option>
					</logic:iterate>
				</select>
			</td>
		</tr>
		
		<tr>
			<td>
				<div align="left">
					<label><liferay-ui:message key="receipt.position"/>&nbsp;:</label>
				</div>
			</td>
			
			<td><input style="width: 90%" type="text" maxlength="50" name="<portlet:namespace/>position" id="position" ></td>
			    
			<td>
				<div align="left">
					<label><liferay-ui:message key="pccc-cvdtn-canphucdap"/>&nbsp;:</label>
				</div>
			</td>
		    <td>
		    	<input  name="<portlet:namespace />ishasdoc" type="checkbox" id="ishasdoc" />
		    </td>
		</tr>
		
		<tr>
			<td>
				<div align="left">
					<label><liferay-ui:message key="receipt.docid"/>&nbsp;:</label>
				</div>
			</td>
			<td>
				<input style="width: 90%" type="text" maxlength="45" name="<portlet:namespace/>documentSendCode" id="docid" >
			</td>
			<td>
				<div align="left">
					<label><liferay-ui:message key="receipt.page"/>&nbsp;:</label>
				</div>
			</td>
			<td>
				<input type="text" style="width: 95%" maxlength="50" name="<portlet:namespace/>numberPage" id="page" >
			</td>
		</tr>
		<tr>
			<td valign="top"><div align="left"><label><liferay-ui:message key="receipt.briftcontent"/><font color="#FF0000" size="1">(*)</font>&nbsp;:</label></div></td>
			<td colspan="3"><textarea name="<portlet:namespace/>briefContent" id="trichyeucvdtn" rows="2" style="width:98%"></textarea></td>
		</tr>
		
		<tr>
		    <td valign="top">
		    	<div align="left">
		    		<label><liferay-ui:message key="pccc-cvdtn-hosocongviec"/>&nbsp;:</label>
		    	</div>
		    </td>
		    <td colspan="3">
		     <div class="cvd-filedinhkem table-border-pml" style="width: 99.3%;">      	
					<table class="taglib-search-iterator table-pml" cellspacing="0" width="100%">	
					
					<%
						String rowAllName = "checkallbox";
						String formName = "formdocumentsend";
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
					
					<tr class="results-header-Scrollbar" >
						<td align="center" width="35px"><img src="/html/images/grippy.png" />&nbsp;<%= rowAllNameChecked.toString() %></td>
						<td align="center" width="35px">STT</td>
						<td ><liferay-ui:message key="pml_tieude"/></td>
					</tr>
					</table>
					<div class="Scrollbarauto">
					<table cellspacing="0" width="100%" class="taglib_Scrollbar table-pml">		
					<logic:iterate id="pmlHoSoCongViec" name="pmlHoSoCongViecList" indexId="i" type="com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec"  >
						<tr class="<%=(i % 2) == 0 ? "results-row" : "tr_two results-row" %>" onmouseover="onMouseOverTr(this);" onmouseout="onMouseOutTr(this);">
						<td align="center" width="35px">
							<img src="/html/images/grippy.png" />&nbsp;<input onClick="Liferay.Util.checkAllBox(<%= formName%>, '<%=  rowName %>', <%= rowAllName %>);" name="<portlet:namespace />HSCV" value="<%= pmlHoSoCongViec.getIdHoSoCongViec()  %>" type="checkbox"   />
						</td>
						<td align="center" width="35px"><%= i + 1 %>.</td>
						<td ><%= pmlHoSoCongViec.getTieuDe() %></td>
					</tr>
					</logic:iterate>
					</table>
		        </div>
		       </div>
		    </td>
		</tr>
		</table>
		<br>
		<fieldset class="filborder">
		<label class="laborder"><liferay-ui:message key="pccc-documentsent-filevanbandidinhkem" /></label>
		<table id="addfileupload" class="taglib-search-iterator table-pml" cellspacing="0" width="100%">	
			<tr class="portlet-section-header results-header" >
			<td><liferay-ui:message key="document_attached_file_title" /></td>
			<td width="50%"><liferay-ui:message key="document_attached_file_name" /></td>
			<td width="15%" align="center"><input style="width: 90%" type="button" value='<liferay-ui:message key="document_more_file" />' onclick="uploadReceiptfile()"></td>
		</tr>
		</table>
		</fieldset>
		
		<input type="hidden" maxlength="30" name="<portlet:namespace/>documentReference" id="sohieucvdtn" value="<%= documentReference%>" >
		<input type="hidden" name="<portlet:namespace/>sendDate" id="ngayguicvdtn" value='<%=new java.text.SimpleDateFormat("dd/MM/yyyy").format( new Date().getTime()) %>' style="width:35">
		<input type="hidden" name="<portlet:namespace/>issuingDate" id="ngaybanhanhcvdtn" value='<%=new java.text.SimpleDateFormat("dd/MM/yyyy").format( new Date().getTime()) %>' style="width:35">
		<input type="hidden" name="<portlet:namespace/>nameFieldRow" id="nameFieldRow" value="" />
		<input type="hidden" name="<portlet:namespace/>nameFiles" id="nameFiles" value="" />
		<input type="hidden" name="<portlet:namespace/>titleFiles" id="titleFiles" value="" />
		<input type="hidden" name="<portlet:namespace/>userId" id="userId" value="<%=PortalUtil.getUserId(renderRequest) %>" />
		<input type="hidden" id="isBookDocumentRecord"  value=""> 
		
		<div align="right" id="table-button">
			<%
				PortletURL currentURL = new PortletURLImpl(request, "SGS_PCCCDOCUMENTSENDPROCESS", 89655, PortletRequest.RENDER_PHASE);
				currentURL.setParameter("struts_action", "/sgs/pcccdocumentsendprocess/view");
				currentURL.setPortletMode(PortletMode.VIEW);
				currentURL.setWindowState(WindowState.NORMAL);
				%> 
				<input id="redirect" name="<portlet:namespace/>redirect" type="hidden">
				<input type="button" value='<liferay-ui:message key="pccc-cvdtn-xlcv"/>' name="xuly" onclick='return processButtonSend("<%=currentURL.toString() %>")'>
				
				<input type="submit"  value='<liferay-ui:message key="pccc-cvdtn-luu" />'>
				<input type="reset" value='<liferay-ui:message key="reset" />'>
				<input type="button" onclick="window.history.back()" value='<liferay-ui:message key="back" />'>	
		</div>
		</div>
		</form>
 <%} else {%>
 			<%-- vu update 31112010 --%>
			<liferay-ui:message key="pccc-cvdtn-chua-cau-hinh-phong-ban"/>
 			<%-- end vu  --%>
 <%}%>
<%
	// phmphuc update 21/09/2010
//	String message = (String) renderRequest.getPortletSession().getAttribute("message",PortletSession.APPLICATION_SCOPE);
	String message = (String) renderRequest.getAttribute("message");
	if ("success".equals(message)) {
%>
		<script type="text/javascript" >
			alert("<liferay-ui:message key='pccc-TN-themmoicongvanthanhcong'/>");
		</script>
		
<% }// if ("fail".equals(message)) {%>

		<!-- <script type="text/javascript" >
			alert("<liferay-ui:message key='pccc-TN-themmoicongvanthanhcong'/>");
		</script> -->
		
<% //}
	//renderRequest.getPortletSession().setAttribute("message",null,PortletSession.APPLICATION_SCOPE);
	// end phmphuc update
%>