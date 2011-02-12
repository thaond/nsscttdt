<%@page import="java.util.List"%>
<%@page import="com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec"%>
<%@page import="java.util.ArrayList"%>
<%@ include file="/html/portlet/ext/pcccdocumentsend/init.jsp" %>

<%@page import="com.sgs.portlet.document.receipt.model.PmlEdmDocumentType"%>
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
<!-- <script type='text/javascript' src='/html/js/liferay/localdata.js'></script>-->
<script type='text/javascript' src='/html/js/liferay/jquery.js'></script>
<script type='text/javascript' src='/html/js/liferay/jquery.autocomplete.js'></script>
<link rel="stylesheet" type="text/css" href="/html/css/main.css" />
<link rel="stylesheet" type="text/css" href="/html/css/jquery.autocomplete.css" />
<script type='text/javascript' src='/html/js/liferay/tr.js'></script>
<script type="text/javascript" >
window.onload = function () {
	//document.getElementById('sohieucvdtn').focus();
	//changeDocumentRecordTypeUpdate();
	//getDocumentRecordByDocTypeId();	
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


<link type="text/css" rel="stylesheet"	href="/html/css/calendar-system.css" />

<%
	DocumentSendDTO documentDTO = (DocumentSendDTO) renderRequest.getAttribute("documentDTO");
	String departmentName = (String) renderRequest.getAttribute("departmentName");
	
	int countHSCVChoice = Integer.parseInt(renderRequest.getAttribute("countHSCVChoice").toString());
	String redirect = ParamUtil.getString(renderRequest, "redirect"); // yenlt update 10082010
	
	// phmphuc add 19/11/2010
	// Hien nut lien ket van ban neu nhu nguoi dung la nguoi xu ly chinh cua van ban
	long userLogin = PortalUtil.getUserId(renderRequest);
	long editorId = (Long) renderRequest.getAttribute("editorId");
	
	boolean showDocLink = false;
	if (editorId == userLogin) {
		showDocLink = true;
	}
	// end phmphuc update 19/11/2010
%>

<portlet:actionURL var="update">
	<portlet:param name="struts_action" value="/sgs/pcccdocumentsendprocess/update" />
	<portlet:param name="documentSendId" value='<%="" + documentDTO.getDocumentSendId() %>'/>
</portlet:actionURL>

<form autocomplete="off" name="<portlet:namespace/>fm" action="<%=update %>" enctype="multipart/form-data" method="post" onsubmit="return checkUpdateform()">
<div class="title_categ"><liferay-ui:message key="pccc-cvdtn-suacongvan"/></div>
<div class="boxcontent">
<table width="100%" cellspacing="0">

<tr>
	<td width="16%"><div align="left"><label><liferay-ui:message key="receipt.creator"/></label>:</div> </td>
	<td width="34%"><input style="width: 90%" type="text" maxlength="50" readonly="readonly" name="<portlet:namespace/>editorId" id="nguoitaocvdtn" value="<%=documentDTO.getEditor() %>"></td>
		
	<td width="16%"><div align="left"><label><liferay-ui:message key="receipt.docrectype"/></label><font color="#FF0000" size="1">(*)</font>:</div></td>
    <td >
		<select style="width: 99%" name="<portlet:namespace/>documentRecordTypeId" id="socongvancvdtn" onchange="changeDocumentRecordTypeUpdate()">
	        <logic:iterate id="pmlEdmDocumentRecordType" name="pmlEdmDocumentRecordTypeList" type="com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType" scope="request">
	      		<option <%=pmlEdmDocumentRecordType.getDocumentRecordTypeName().equals(documentDTO.getDocumentRecord()) ? "selected" : "" %> value="<%= pmlEdmDocumentRecordType.getDocumentRecordTypeId() %>"> <%= pmlEdmDocumentRecordType.getDocumentRecordTypeName() %> </option>
	      	</logic:iterate>
		</select>    	      	
    </td>
    <%-- 
	<td width="16%"><div align="left"><label><liferay-ui:message key="receipt.doctype"/></label><font color="#FF0000" size="1">(*)</font>:</div></td>
	<td>
	    <select style="width: 99%" name="<portlet:namespace/>documentTypeId" id="loaicongvancvdtn" style="width:99%" onchange="getDocumentRecordByDocTypeId();">
    		<logic:iterate id="documentType" name="pmlEdmDocumentTypeList" type="com.sgs.portlet.document.receipt.model.PmlEdmDocumentType" scope="request">
		    	<option <%= documentDTO.getDocumentType().equals(documentType.getDocumentTypeName()) ? "selected" : ""%> value="<%=documentType.getDocumentTypeId() %>"><%=documentType.getDocumentTypeName() %></option>
    			</logic:iterate>
    	</select>
	</td>
    --%>
</tr>
	
<tr>
	<td ><div align="left"><label><liferay-ui:message key="receipt.department"/></label>:</div></td>
	<td><input style="width: 90%" type="text" maxlength="50" readonly="readonly" name="<portlet:namespace/>department" id="dept" value='<%=departmentName != null ? departmentName : "" %>'></td>
	
	<td ><div align="left"><label><liferay-ui:message key="receipt.doctype"/></label><font color="#FF0000" size="1">(*)</font>:</div></td>
	<td>
		<select name="<portlet:namespace/>documentTypeId" id="loaicongvancvdtn" style="width:99%">
    		<logic:iterate id="documentType" name="pmlEdmDocumentTypeList" type="com.sgs.portlet.document.receipt.model.PmlEdmDocumentType" scope="request">
		    	<option <%= documentDTO.getDocumentType().equals(documentType.getDocumentTypeName()) ? "selected" : ""%> 
		    			value="<%= documentType.getDocumentTypeId() %>"><%=documentType.getDocumentTypeName() %></option>
    		</logic:iterate>
	    </select>
	</td>
	
	<%-- 
	<td ><div align="left"><label><liferay-ui:message key="receipt.docrectype"/></label><font color="#FF0000" size="1">(*)</font>:</div></td>
    <td>
		<select style="width: 99%" name="<portlet:namespace/>documentRecordTypeId" id="socongvancvdtn">
		</select>    	      	
    </td>
	--%>
</tr>
	
<tr>
	<td><div align="left"><label><liferay-ui:message key="receipt.receiveplace"/></label><font color="#FF0000" size="1">(*)</font>:</div></td>
	<td >
		<input style="width:72.5%" type="text" name="<portlet:namespace/>receivingPlace" id="receiveplace" value='<%=documentDTO.getReceivingPlace() != null ? documentDTO.getReceivingPlace() : "" %>'>
	    <input type="hidden" id="issuingPlaceId" name="<portlet:namespace />issuingPlaceId">
	   	<input  id="btn_receiveplace" type="button" value="..."  onclick="mypopupIssuingplace()" style="width: 15%">
	</td>
	
	<td ><div align="left"><label><liferay-ui:message key="receipt.confidentallevelid"/></label><font color="#FF0000" size="1">(*)</font>:</div></td>
	<td>
		<select name="<portlet:namespace/>confidentialLevelId" id="domatcvdtn" style="width:99%">
		    <logic:iterate id="pmlEdmConfidentialLevel" name="pmlEdmConfidentialLevelList" type="com.sgs.portlet.document.receipt.model.PmlEdmConfidentialLevel" scope="request">
				<option <%=documentDTO.getConfidentialLevel().equals(pmlEdmConfidentialLevel.getConfidentialLevelName()) ? "selected" : "" %> value="<%= pmlEdmConfidentialLevel.getConfidentialLevelId() %>"> <%= pmlEdmConfidentialLevel.getConfidentialLevelName() %> </option>
			</logic:iterate>
		</select>
	</td>
</tr>
	
<tr>
	<td><div align="left"><label><liferay-ui:message key="receipt.signer"/></label>:</div></td>
	<td >
		<input style="width: 72.5%" type="text" name="<portlet:namespace/>signerName" id="signer" value='<%=documentDTO.getSigner() != null ? documentDTO.getSigner() : "" %>' >	
		<input  type="hidden" id="signerId"  name="<portlet:namespace />signerId" >
		<input  id="btn_signer" type="button" value="..."  onclick="mypopupSigner()" style="width: 15%">
	</td>
	
	<td ><div align="left"><label><liferay-ui:message key="receipt.previlegenlevelid"/></label><font color="#FF0000" size="1">(*)</font>:</div></td>
	<td>
		<select name="<portlet:namespace/>privilegenLevelId" id="dokhancvdtn" style="width:99%">
			<logic:iterate id="pmlEdmPrivilegeLevel" name="pmlEdmPrivilegeLevelList" type="com.sgs.portlet.document.receipt.model.PmlEdmPrivilegeLevel" scope="request">
				<option <%=documentDTO.getPrivilegel().equals(pmlEdmPrivilegeLevel.getPrivilegeLevelName()) ? "selected" : "" %> value="<%= pmlEdmPrivilegeLevel.getPrivilegeLevelId() %>"> <%= pmlEdmPrivilegeLevel.getPrivilegeLevelName() %> </option>
			</logic:iterate>
		   </select>
	</td>
</tr>
	
<tr>
	<td >
		<div align="left">
			<label><liferay-ui:message key="receipt.position"/></label>:
		</div>
	</td>
	<td>
		<input style="width: 90%" type="text" maxlength="50" name="<portlet:namespace/>position" id="position" value='<%=documentDTO.getPosition() != null ? documentDTO.getPosition() : "" %>'>
	</td>
	
	<td >
		<div align="left">
			<label><liferay-ui:message key="pccc-cvdtn-cocongvanphucdap"/>:</label>
	 	</div>
	</td>
	
    <td >
   		<input name="<portlet:namespace />ishasdoc" <%= (documentDTO.isIscongvanphucdap()? "checked='checked'" : "") %> type="checkbox" id="ishasdoc" />
    </td>
</tr>
	
<tr>
	<td>
		<div align="left">
			<label><liferay-ui:message key="receipt.docid"/></label>:
		</div>
	</td>
	<td><input style="width: 90%" type="text" maxlength="45" name="<portlet:namespace/>documentSendCode" id="docid" value='<%=documentDTO.getDocumentSendCode() != null ? documentDTO.getDocumentSendCode() : "" %>' ></td>

	<td>
		<div align="left">
			<label><liferay-ui:message key="receipt.page"/></label>:
		</div>	
	</td>
	<td><input style="width: 95%" type="text" maxlength="50" name="<portlet:namespace/>numberPage" id="page" value='<%=(!"".equals(documentDTO.getNumberPage()) || !"0".equals(documentDTO.getNumberPage())) ? documentDTO.getNumberPage() : "" %>' ></td>
</tr>

<tr>
	<td valign="top"><div align="left"><label><liferay-ui:message key="receipt.briftcontent"/><font color="#FF0000" size="1">(*)</font>:</label></div></td>
	 <td  colspan="3"><textarea name="<portlet:namespace/>briefContent" id="trichyeucvdtn" rows="2" style="width:98%"><%= documentDTO.getBriefContent() %></textarea></td>
</tr>
<tr>
    <td  valign="top">
    	<div align="left">
   	 		<label><liferay-ui:message key="pccc-cvdtn-hosocongviec"/></label>:
   	 	</div>
   	 </td>
	   <td colspan="3">
		     <div class="cvd-filedinhkem table-border-pml" style="width: 99.3%;">
		     
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
						
		     	<table class="taglib-search-iterator table-pml" cellspacing="0" width="100%">	
		    		<tr class="portlet-section-header results-header" >
						<td align="center" style="width: 40px"><img src="/html/images/grippy.png" />&nbsp;<%= rowAllNameChecked.toString() %></td>
						<td align="center" style="width: 40px">STT</td>
						<td ><liferay-ui:message key="pml_tieude"/></td>
					</tr>
		      		<logic:iterate id="pmlHoSoCongViec" name="pmlHoSoCongViecList" indexId="i" type="com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec"  >
						<tr  class="<%=(i % 2) == 0 ? "results-row" : "tr_two results-row" %>" onmouseover='onMouseOverTr(this);' onmouseout='onMouseOutTr(this);'>
							<td align="center">
								<img src="/html/images/grippy.png" />&nbsp;<input onClick="Liferay.Util.checkAllBox(<%= formName%>, '<%=  rowName %>', <%= rowAllName %>);" name="<portlet:namespace />HSCV" value="<%= pmlHoSoCongViec.getIdHoSoCongViec()  %>" <%= (i < countHSCVChoice? "checked" : "") %>  type="checkbox"   />
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
</table>

<fieldset class="filborder">
<legend style="background-color:#F9FFFF;color:#004571;font-weight:bold;padding-bottom:8px;padding-left:15px;padding-right:15px;padding-top:8px;text-transform:capitalize;top:-20px;">
<liferay-ui:message key="pccc-documentsent-filevanbandidinhkem" /></legend>
	<table class="taglib-search-iterator table-pml" cellspacing="0" width="100%">	
	<tr class="portlet-section-header results-header" >
		<td width="4%" align="center"><div><liferay-ui:message key="sgs_onedoor_no."/></div></td>
		<td width="30%"><div><liferay-ui:message key="document_attached_file_title" /></div></td>
		<td width="46%"><div><liferay-ui:message key="document_attached_file_name" /></div></td>
		<td ><div><liferay-ui:message key="document_attached_file_view" /></div></td>
	</tr>
	
	<logic:iterate id="attachedFile" name="attachedFiles" indexId="i" type="com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile" scope="request" >
	<tr class="<%=(i % 2) == 0 ? "results-row" : "tr_two results-row" %>" onmouseover='onMouseOverTr(this);' onmouseout='onMouseOutTr(this);'>
		<td ><%=i + 1 %></td>
		<td ><a href="<%=attachedFile.getPath() %>"><u><%=attachedFile.getTitle() %></u></a></td>
		<td ><a href="<%=attachedFile.getPath() %>"><u><%=attachedFile.getAttachedFileName().substring(14) %></u></a></td>
		<td ><input type="checkbox" <%= (attachedFile.getDisplayOrHidden() == true ? "checked" : "") %> name="<portlet:namespace/>document_attached_file_view_active" value="<%= String.valueOf(attachedFile.getAttachedFileId()) %>" /></td>
	</tr>
	</logic:iterate>
	
	</table>
</fieldset>

<fieldset class="filborder">
<legend style="background-color:#F9FFFF;color:#004571;font-weight:bold;padding-bottom:8px;padding-left:15px;padding-right:15px;padding-top:8px;text-transform:capitalize;top:-20px;">
<liferay-ui:message key="pccc-documentsent-add-filevanbandidinhkem" /></legend>
<table id="addfileupload" class="taglib-search-iterator table-pml" cellspacing="0" width="100%">
<tr class="portlet-section-header results-header" >
	<td ><liferay-ui:message key="document_attached_file_title" /></td>
	<td width="50%"><liferay-ui:message key="document_attached_file_name" /></td>
	<td width="15%" align="center"><input type="button" value='<liferay-ui:message key="document_more_file" />' onclick="uploadReceiptfile()"></td>
</tr>
</table>

</fieldset>

<!-- portlet:renderURL var="redirect" -->
	<!-- portlet:param name="struts_action" value="/sgs/pcccdocumentsendprocess/view"/ -->
<!-- /portlet:renderURL -->
	<input type="hidden" name="<portlet:namespace/>redirect" value="<%=redirect%>" />	
	<input type="hidden" name="<portlet:namespace/>nameFieldRow" id="nameFieldRow" value="" />
	<input type="hidden" name="<portlet:namespace/>nameFiles" id="nameFiles" value="" />
	<input type="hidden" name="<portlet:namespace/>titleFiles" id="titleFiles" value="" />
	<div align="right" id="table-button">
		<input  type="submit"  value='<liferay-ui:message key="save" />'>
		<input  type="reset" value='<liferay-ui:message key="reset" />'>
		<!-- phmphuc add 19/11/2010 - Hien nut lien ket van ban -->
		<%
		if (showDocLink == true) { // Du dieu kien hien nut lien ket van ban
			// Tao lien ket den trang van ban lien quan
			PortletURL linkDocURL = renderResponse.createRenderURL();
			linkDocURL.setWindowState(WindowState.MAXIMIZED);
			linkDocURL.setParameter("struts_action", "/sgs/pcccdocumentsendprocess/documentrelation");
			linkDocURL.setParameter("documentId", String.valueOf(documentDTO.getDocumentSendId()));
			linkDocURL.setParameter("detailBackURL", PortalUtil.getCurrentURL(request));
		%>
			<input class="button-width" type="button" value='<liferay-ui:message key="link-document" />' onclick="javascript:submitForm(document.hrefFm,'<%= linkDocURL %>');">
		<%
		}
		%>
		<!-- end hien thi nut lien ket van ban 19/11/2010 -->
		<input type="button" onclick="window.history.back()" value='<liferay-ui:message key="back" />'>	
	</div>
</div>
</form>