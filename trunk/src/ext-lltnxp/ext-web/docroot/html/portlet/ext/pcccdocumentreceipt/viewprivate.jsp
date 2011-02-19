<%@ include file="/html/portlet/ext/pcccdocumentreceipt/init.jsp" %>

<%@ include file="/html/portlet/ext/pcccdocumentreceipt/js/pccc-docreceipt.jsp" %>
<%@page import="com.sgs.portlet.document.workflow.DocumentReceiptPortletAction"%>
<%@page import="com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec"%>
<%@page import="com.sgs.portlet.pml_ho_so_cong_viec.service.persistence.PmlHoSoCongViecUtil"%>
<script type='text/javascript' src='/html/js/liferay/socongvanphucdap.js'></script>
<script type="text/javascript"	src="/html/js/calendar.js"></script>
<script type="text/javascript"	src="/html/js/calendar-setup.js"></script>
<script type="text/javascript"	src="/html/js/calendar-en.js"></script>
<script type='text/javascript' src='/html/js/liferay/tr.js'></script>
<script type="text/javascript">

window.onload = function () {
	changeLevelSend();
	//changeDocumentRecordType(); // phmphuc close 11/11/2010 thay the bang function ben duoi
	getDocumentRecordByDocTypeId();
	doStop();
	document.getElementById('capgoicvdtn').focus();

	if (document.getElementById('ngayphathanhcvdtn') != null) {
		callCalendar('ngayphathanhcvdtn','cal-button-issuingDate');
	}

	if (document.getElementById('ngaydencvdtn') != null) {
		callCalendar('ngaydencvdtn','cal-button-dateArrive');
	}
}
</script>
<link type="text/css" rel="stylesheet"	href="/html/css/calendar-system.css" />

<portlet:actionURL var="addprivatedocument">
	<portlet:param name="struts_action" value="/sgs/pcccdocumentreceipt/view" />
	<portlet:param name="<%=Constants.CMD %>" value="<%Constants.ADD %>"/>
</portlet:actionURL>

<form autocomplete="off" name="fname" action="<%=addprivatedocument %>" enctype="multipart/form-data"  method="post">
<input name="<portlet:namespace/>privateDocument" type="hidden" value="<%= String.valueOf(privateDocument) %>"/>
<div class="title_categ"><liferay-ui:message key="nhap-thong-tin-cong-van-den"/></div>
<div class="boxcontent">
<table width="100%" cellspacing="0">
  <tr>
		<td width="18%"><div align="left"><label><liferay-ui:message key="pccc-cvdtn-loaicongvan"/>:</label></div></td>
		<td width="32%">
	    	<select name="<portlet:namespace/>documentTypeId" id="loaicongvancvdtn" style="width:96%" onchange="getDocumentRecordByDocTypeId();">
	    		<logic:iterate id="pmlEdmDocumentType" name="pmlEdmDocumentTypeListReceipt" type="com.sgs.portlet.document.receipt.model.PmlEdmDocumentType" scope="request">
	     				<option value="<%= pmlEdmDocumentType.getDocumentTypeId() %>"> <%= pmlEdmDocumentType.getDocumentTypeName() %> </option>
	  			  	</logic:iterate>
	    	</select>
		</td>
		<td><div align="left"><label><liferay-ui:message key="pccc-cvdtn-socongvan"/>:</label></div></td>
		<td>
			<select name="<portlet:namespace/>documentRecordToId" id="socongvancvdtn" style="width:96%" ></select>
	    </td>
  </tr>
  <tr>
		<td><liferay-ui:message key="pccc-cvdtn-soCVden"/>&nbsp;:</td>
		<td><input type="text" name="<portlet:namespace/>numberDocumentReceipt" id="soCVdencvdtn" style="width:93%" readonly="readonly"></td>
		<td><liferay-ui:message key="pccc-cvdtn-ngayden"/>:</td>
	    <td align="left">
    		<input style="width: 65px;" type="text" name="<portlet:namespace/>dateArrive" id="ngaydencvdtn"  value='<%=new java.text.SimpleDateFormat("dd/MM/yyyy").format( new Date().getTime()) %>'  maxlength="10" onblur="getGeneralNumberDocumentReceipt();">
	   		<div id="calendarImage" style="display: none;"><img id="cal-button-dateArrive" src="/html/images/cal.gif" onclick="callCalendar('ngaydencvdtn','cal-button-dateArrive')"/></div>
    		<span style="color:#ccc;font-size: 9px">(dd/mm/yyyy)</span>
		   	<label><liferay-ui:message key="hour"/>:</label>
		   	<input style="width: 50px;" readonly="readonly" type="text" name="dateArriveTime" id="dateArriveTime" value="">
	 	  	<liferay-ui:message key="edit"/>
	 	  	<input type="checkbox" id="edittime" unchecked onclick="doStop()">   
		</td>
  </tr>
  <tr>
	<td ><liferay-ui:message key="pccc-cvdtn-capgoi"/>&nbsp;:</td>
	    <td>
	      <select name="<portlet:namespace/>levelSendId" id="capgoicvdtn" style="width:96%" onchange="changeLevelSend()">
					<option value="-1"><liferay-ui:message key="nochoose" /></option>
	       <logic:iterate id="pmlEdmLevelSend" name="pmlEdmLevelSendList" type="com.sgs.portlet.pmllevelsend.model.PmlEdmLevelSend" scope="request">
	      	<option value="<%= pmlEdmLevelSend.getLevelSendId() %>"> <%= pmlEdmLevelSend.getLevelSendName() %> </option>
	      </logic:iterate>
	      </select>
	    </td>

		<td ><liferay-ui:message key="pccc-cvdtn-noiphathanh"/>&nbsp;:</td>
		<td>
			<div>
				<select onchange="checkonchangBR3()" name='<portlet:namespace/>issuingPlaceId' id='noiphathanhcvdtn' style='width:71.5%' >
						<option value=""><liferay-ui:message key="nochoose" /></option>
				</select>
				<input style="width:24%" type="button" value="<liferay-ui:message key='add-edit' />" onclick="addEditRelUnitPop()" >
			</div>
	    </td>
  </tr>
  <tr>
	<td><liferay-ui:message key="pccc-cvdtn-sohieu"/>nbsp;:</td>
		<td>
			<input type="text" name="<portlet:namespace/>documentReference" id="sohieucvdtn" style="width:93%" maxlength="50" onblur="lostFocusDocRef()">
		</td>
		
		<td width="15%"><liferay-ui:message key="pccc-cvdtn-khac"/>&nbsp;:</td>
   	 	<td><input type="text" name="<portlet:namespace/>issuingPlaceName" id="khaccvdtn" style="width:95%" maxlength="200"></td>
	
  </tr>
  <tr>

		<td ><liferay-ui:message key="pccc-cvdtn-ngayphathanh"/>:</td>
	    <td align="left">
	    	<input style="width: 35%;" type="text" name="<portlet:namespace/>issuingDate" id="ngayphathanhcvdtn" value='<%=new java.text.SimpleDateFormat("dd/MM/yyyy").format( new Date().getTime()) %>'>
	    	<img align="top" style="cursor: pointer" id="cal-button-issuingDate" src="/html/images/cal.gif" onclick="callCalendar('ngayphathanhcvdtn','cal-button-issuingDate')"/>
	    </td>
		
	<td><liferay-ui:message key="pccc-cvdtn-nguoiky"/>&nbsp;:</td>
		<td>
				<input type="text" name="<portlet:namespace/>signer" id="nguoikycvdtn" style="width:72%">
				<input type="hidden" name="hidSignerList" id="hidSignerList">
				<div style="position: relative; top: 0px; left: 0px; display: none; z-index: 65535;" id="divSignerContain" onclick="this.style.display='none';">
				<div id="divSignerList" style="z-index: 65535; position: absolute; top: 0px; left: 0px; background-color:#FFFFFF; border:solid 1px #003366; padding:5px 5px 5px 5px; width: 200px; height: 100px; overflow: auto;">
				</div>
				</div>
				<input type="button" style="width: 21%;" value="<liferay-ui:message key='choose' />" onclick="selectSigner()">
		</td>
  </tr>
  <tr>
	  <td><liferay-ui:message key="pccc-cvdtn-domat"/>&nbsp;:</td>
			<td>
				<select name="<portlet:namespace/>confidentialLevelId" id="domatcvdtn" style="width:96%">
					<logic:iterate id="pmlEdmConfidentialLevel" name="pmlEdmConfidentialLevelList" type="com.sgs.portlet.document.receipt.model.PmlEdmConfidentialLevel" scope="request">
						<option value="<%= pmlEdmConfidentialLevel.getConfidentialLevelId()%>"> <%= pmlEdmConfidentialLevel.getConfidentialLevelName() %> </option>
					 </logic:iterate>
				</select>
			</td>
			<td><liferay-ui:message key="pccc-cvdtn-dokhan"/>&nbsp;:</td>
			<td>
				 <select name="<portlet:namespace/>privilegenLevelId" id="dokhancvdtn" style="width:98%">
					<logic:iterate id="pmlEdmPrivilegeLevel" name="pmlEdmPrivilegeLevelList" type="com.sgs.portlet.document.receipt.model.PmlEdmPrivilegeLevel" scope="request">
						<option value="<%= pmlEdmPrivilegeLevel.getPrivilegeLevelId()%>"> <%= pmlEdmPrivilegeLevel.getPrivilegeLevelName() %> </option>
					 </logic:iterate>
				 </select>
			</td>
   </tr>
   <tr>
	<td >
     	<liferay-ui:message key="pccc-cvdtn-socongvandiphucdap"/>&nbsp;:
	</td>
	<td  >
	   	<input type="text" name="<portlet:namespace/>socongvandiphucdap" id="socongvandiphucdap" style="width:93%" maxlength="20" onchange="checkReponseNumberDocument(this.value)">
	   	<div id="cohaykhongsocongvandiphucdap"></div>   	      	
	 </td>
	<td></td>
	<td></td>
  </tr>
  <tr valign="top">
  		<td valign="top">
		   	<liferay-ui:message key="pccc-cvdtn-trichyeu"/>&nbsp;:
		 </td>
		 <td colspan="3" valign="top">
		   	<textarea name="<portlet:namespace/>briefContent" id="trichyeucvdtn" rows="2" style="width:98.9%"></textarea>
		 </td>
  	</tr>	
	<tr>
	
	<%
		String rowAllName = "checkallbox";
		String formName = "fname";
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
  		<td valign="top"><liferay-ui:message key="pccc-cvdtn-hosocongviec"/>&nbsp;:</td>
	    <td colspan="3">
	      <div class="cvd-filedinhkem table-border-pml" style="width: 100%" class="Scrollbarauto">
	      	<table class="taglib-search-iterator table-pml" cellspacing="0" width="100%">	
				<tr class="portlet-section-header results-header" >
					<td align="center" width="35px"><img src="/html/images/grippy.png" />&nbsp;<%= rowAllNameChecked.toString() %></td>
					<td width="45px" align="center">STT</td>
					<td ><liferay-ui:message key="pml_tieude"/></td>
				</tr>
	      	<%
			List<PmlHoSoCongViec> pmlHoSoCongViecList = PmlHoSoCongViecUtil.findAll();
			int pmlHoSoCongViecSize = pmlHoSoCongViecList.size();
			for (int i = 0; i < pmlHoSoCongViecSize; i ++) {
				PmlHoSoCongViec pmlHoSoCongViec = pmlHoSoCongViecList.get(i);
			%>
			
				<tr  class='<%=(i % 2) == 0 ? "results-row" : "tr_two results-row" %>' onmouseover='onMouseOverTr(this);' onmouseout='onMouseOutTr(this);'>
						<td width="35px" align="center">
							<img src="/html/images/grippy.png" />&nbsp;<input onClick="Liferay.Util.checkAllBox(<%= formName%>, '<%=  rowName %>', <%= rowAllName %>);" name="<portlet:namespace />HSCV" value="<%= pmlHoSoCongViec.getIdHoSoCongViec()  %>" type="checkbox"   />
						</td>
						<td width="45px" align="center"><%= i + 1 %>.</td>
						<td><%= pmlHoSoCongViec.getTieuDe() %></td>					
				</tr>
			
				<%
			}
			%>
		</table>
	     </div>
	    </td>

  </tr>
  <tr style="display: none;">
		 <td>&nbsp;</td>
		  <td>
		     <input name="<portlet:namespace/>isPublic" type="radio" id="RadioGroup1_0" value="1" >
		 	 <liferay-ui:message key="pccc-cvdtn-congvancongcong"/>
		  </td>
		  <td colspan="2"> 
		  	<label>
		      <input type="radio" name="<portlet:namespace/>isPublic" value="0" id="RadioGroup1_1" checked>
		       <liferay-ui:message key="pccc-cvdtn-congvannoibo"/>
		    </label>
		  </td>
  </tr>
  </table>

<fieldset class="filborder">
		<legend class="laborder"><liferay-ui:message key="pccc-cvdtn-toanvan"/></legend>
		<table id="addfileupload" class="taglib-search-iterator table-pml" cellspacing="0" width="100%">	
			<tr class="portlet-section-header results-header" >
		   		<td><liferay-ui:message key="document_attached_file_title" /></td>
		    	<td width="50%"><liferay-ui:message key="document_attached_file_name" /></td>
				<td width="15%" align="center"><input style="width: 80%" type="button" value='<liferay-ui:message key="document_more_file" />' onclick="uploadReceiptfile()"></td>
			</tr>
		</table>
		
		 <input type="hidden" name="<portlet:namespace/>nameFieldRow" id="nameFieldRow" value="" />
		 <input type="hidden" name="<portlet:namespace/>nameFiles" id="nameFiles" value="" />
		 <input type="hidden" name="<portlet:namespace/>titleFiles" id="titleFiles" value="" />
		 <input type="hidden" name="<portlet:namespace/>userId" id="userId" value='<%= renderRequest.getAttribute("userId").toString()  %>' />
</fieldset>
<div align="right" id="table-button">
	<input id="redirect" name="<portlet:namespace/>redirect" type="hidden">
	<input type="submit"  value='<liferay-ui:message key="pccc-cvdtn-luu" />'>
	<input type="reset" value='<liferay-ui:message key="reset" />' onclick="changeDocumentRecordType()">
	<input type="button" onclick="window.history.back()" value='<liferay-ui:message key="back" />'>
</div>
<input type="hidden" id="isBookDocumentRecord"  value="">   
</div>    
</form>
<% 
	String message = (String) renderRequest.getAttribute("message");
	if ("success".equals(message)) {
%>
<script type="text/javascript" >
	alert("<liferay-ui:message key='pccc-TN-themmoicongvanthanhcong'/>");
</script>


<%
	}
%>



