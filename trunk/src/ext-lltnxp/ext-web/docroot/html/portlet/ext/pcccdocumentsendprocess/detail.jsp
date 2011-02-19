<%@page import="com.sgs.portlet.document.model.PmlDocumentSendLog"%>
<%@page import="com.sgs.portlet.pcccdocumentsendprocess.dto.DocumentSendLogNode"%>
<%@ include file="/html/portlet/ext/pcccdocumentsend/init.jsp" %>

<%@page import="com.sgs.portlet.document.model.PmlEdmDocumentRelation"%>
<%@page import="com.sgs.portlet.document.service.persistence.PmlEdmDocumentRelationUtil"%>
<%@page import="com.sgs.portlet.pmluser.model.PmlUser"%>
<%@page import="com.sgs.portlet.pmluser.service.persistence.PmlUserUtil"%>
<%@page import="com.sgs.portlet.department.service.persistence.DepartmentUtil"%>

<%@page import="com.sgs.portlet.document.send.model.PmlEdmDocumentSend"%>
<%@page import="com.sgs.portlet.document.send.service.persistence.PmlEdmDocumentSendUtil"%>

<%@page import="com.sgs.portlet.pmlissuingplace.service.persistence.PmlEdmIssuingPlaceUtil"%>
<%@page import="com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentReceiptUtil"%>

<liferay-util:include page="/html/portlet/ext/pcccdocumentsend/js/pccc-documentsend.jsp">
</liferay-util:include>

<%---
<link type="text/css" rel="stylesheet" href="/html/portlet/ext/onedoorpcccprocess/css/style.css" />
---%>
<link type="text/css" rel="stylesheet"	href="/html/css/calendar-system.css" />
<link type="text/css" rel="stylesheet" href="/html/portlet/ext/pcccdocumentsendprocess/css/letter.css" />
<%@page import="com.sgs.portlet.document.workflow.DocumentReceiptPortletAction"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.sgs.portlet.department.model.Department"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.sgs.portlet.document.send.dto.DocumentSendDTO"%>
<%@page import="com.sgs.portlet.document.receipt.dto.PmlEdmDocumentReceiptDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.sgs.portlet.pcccdocumentsend.dto.DocumentSendLogDTO"%>
<%@page import="com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<script type="text/javascript" src="/html/js/calendar.js"></script>
<script type="text/javascript" src="/html/js/calendar-setup.js"></script>
<script type="text/javascript" src="/html/js/calendar-en.js"></script>
<script type='text/javascript' src='/html/js/liferay/tr.js'></script>
<script type="text/javascript" >

window.onload = function () {
	changeDocumentRecordType();
}

</script>

<%
	DocumentSendDTO sendDTO = (DocumentSendDTO) renderRequest.getAttribute("documentDTO");
	// xuancong add start
	if (sendDTO == null) {
		System.out.println("Khong xac dinh duoc doi tuong!");
		return;
	}
	// xuancong add end
	PmlEdmDocumentReceipt receiptDTO = (PmlEdmDocumentReceipt) renderRequest.getAttribute("documentReceipt");
	String department = (String) renderRequest.getAttribute("department");
	String hienTrang = ParamUtil.getString(renderRequest, "hienTrang", "dangXuLy");
	String soCongVanDiHientai = (String) renderRequest.getAttribute("soCongVanDiHientai");
	//thoind add
	String tabChung = ParamUtil.getString(renderRequest, "tabChung");
	// phmphuc update 07/08/2010
	String statusId = ParamUtil.getString(renderRequest, "statusId");
	String redirect = ParamUtil.getString(renderRequest, "redirect") + "&tabChung=" + tabChung ;//+ "&statusId=" + statusId;
	// phmphuc end update 07/08/2010
	
	// Canh
	DocumentSendLogNode root = (DocumentSendLogNode) renderRequest.getAttribute("workflow_tree");
	// End of Canh
	
%>
<form action="" enctype="multipart/form-data" onsubmit="return validateCVDDocReceipt()" method="post">
<div class="boxcont">
<div class="leftportal">
    <div class="title_categ"><liferay-ui:message key="pccc-XL-quatrinhluanchuyencongvanden"/></div>
    <div class="boxcontent-luanchuyen">
		<!-- Khoi tao cay luan chuyen -->
			<div id="<portlet:namespace/>workflow_tree">
				<ul class="jstree-no-icons">
			<%if (root != null) {
				%>
					<%=getHtml(root) %>
				<%
			}%>
				</ul>
			
			</div>
	</div>
</div>
<div class="rightportal">
<div class="title_categ"><liferay-ui:message key="pcccdocumentsend-chitiet"/></div>
 <div class="boxcontent">
<table width="100%" cellspacing="0" class="detail_xl">
<tr>
		
		<td class="td-left" width="18%"><liferay-ui:message key="receipt.docrectype"/>&nbsp;:</td>
		<td class="td-right" width="32%"><%=sendDTO.getDocumentRecord() %></td>
		<td class="td-left" width="18%"><label><liferay-ui:message key="pccc-cvdtn-socongvandencuaphong"/><label></td>
		<td class="td-right"><%= soCongVanDiHientai %></td>
	</tr>
	<tr>
		<td class="td-left"><label><liferay-ui:message key="receipt.senddate"/>:</label></td>
		<%--- xuancong close
		<td class="td-right"><%= (null != sendDTO.getIssuingDate() ? new SimpleDateFormat("dd/MM/yyyy").format(sendDTO.getSendDate()):"") %></td>
		---%>
		<td class="td-right"><%= (null != sendDTO.getIssuingDate() ? new SimpleDateFormat("dd/MM/yyyy").format(sendDTO.getIssuingDate()) : "") %></td>
	    <td class="td-left"><label><liferay-ui:message key="receipt.doctype"/>:</label></td>
	    <td class="td-right"><%=sendDTO.getDocumentType() %></td>
	</tr>
	<tr>
		<td class="td-left"><label><liferay-ui:message key="receipt.issuingdate"/>:</label></td>
		<td class="td-right"><%= (null != sendDTO.getIssuingDate() ? new SimpleDateFormat("dd/MM/yyyy").format(sendDTO.getIssuingDate()): "") %></td>
		<td class="td-left"><label><liferay-ui:message key="receipt.confidentallevelid"/>:</label></td>
		<td class="td-right"><%=sendDTO.getConfidentialLevel() %></td>
</tr>
<tr>
		<td class="td-left"><label><liferay-ui:message key="nguoi-soan"/>:</label></td>
		<td class="td-right"><%=sendDTO.getEditor() %></td>
		<td class="td-left"><label><liferay-ui:message key="receipt.previlegenlevelid"/>:</label></td>
		<td class="td-right"><%=sendDTO.getPrivilegel() %></td>
</tr>
<tr>
		<td class="td-left" valign="top"><label><liferay-ui:message key="pccc-cvdtn-hosocongviec"/>:</label></td>
	 	<td class="td-right">
		 <div class="cvd-filedinhkem" style="width: 99%;background-color: white;">
			 <logic:iterate id="pmlHoSoCongViec" name="pmlHoSoCongViecList" indexId="i" type="com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec"  >
				<span id="stt">- &nbsp;</span><%= pmlHoSoCongViec.getTieuDe() %><br>
				
	        </logic:iterate>
		 </div>	 
	 	</td>
		<td class="td-left" >
			<liferay-ui:message key="receipt.department"/>&nbsp;:
		</td>
	    <td class="td-right"><%=department %></td>
	</tr>

	<tr>
		<td valign="top" class="td-left">
			<label><liferay-ui:message key="receipt.signer"/>:</label></td>
		<td class="td-right"><%=sendDTO.getSigner() %></td>
		<td class="td-left"><liferay-ui:message key="receipt.position"/></td>
		<td class="td-right"><%=sendDTO.getPosition() %></td>
</tr>

<tr>
	<td valign="top" class="td-left">
			<label><liferay-ui:message key="receipt.docid"/>:</label></td>
	<td class="td-right"><%=sendDTO.getDocumentSendCode() %></td>
	<td valign="top" class="td-left"><label><liferay-ui:message key="receipt.page"/>:</label></td>
	<td class="td-right"><%=sendDTO.getNumberPage() %></td>
	
	
	
</tr>
<tr>
	<td class="td-left"><label><liferay-ui:message key="receipt.receiveplace"/>:</label></td>
	<td class="td-right"><%=sendDTO.getReceivingPlace() %></td>
	<td class="td-left">
			<label><liferay-ui:message key="pccc-cvdtn-cocongvanphucdap"/>:</label></td>
	<td class="td-right">
		<%
			if (sendDTO.isIscongvanphucdap()) {
				%>
				<liferay-ui:message key='pccc-cvdtn-co'/>
			<% 
			}
			else {
				%>
				<liferay-ui:message key='pccc-cvdtn-khong'/>
				<%
			}
			
		%> 
	</td>	
</tr>
<tr valign="top">
		<td class="td-left">
			<label><liferay-ui:message key="receipt.attachedfiles"/>:</label></td>
		<td class="td-right">
		<logic:iterate id="attachedFile" name="attachedFiles" indexId="i" type="com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile" scope="request" >
				<%---
			<u><a href="<%=attachedFile.getPath() %>"><%=(attachedFile.getAttachedFileName()).substring(14) %></a></u> <br/>
				---%>
				<a href="<%=attachedFile.getPath() %>" style="text-decoration:none;"><%=(attachedFile.getTitle())%></a><br/> 
			</logic:iterate>
		</td>
		<td class="td-left"></td>
		<td class="td-right"></td>
</tr>
<tr valign="top">
		<td class="td-left">
			<label><liferay-ui:message key="receipt.briftcontent"/>:</label></td>
	    <td class="td-right" colspan="3">
	    	<textarea class="textarea-display" onMouseover="this.style.backgroundColor='white';" readonly="" rows="5" style="width: 97%"><%=sendDTO.getBriefContent() %></textarea>
	    </td>
</tr>
</table>
<%
  	if (receiptDTO != null) {
%>
<br>
<fieldset class="filborder">
<legend class="laborder"><liferay-ui:message key="pcccdocumentsend-traloichocongvanden"/></legend>
<table cellspacing="0" width="100%">
<tr valign="top">
	<td  class="td-left" width="18%">
			<label><liferay-ui:message key="pcccdocumentsend-sohieucongvanden"/></label></td>
    <td class="td-right" width="32%"><%=receiptDTO.getDocumentReference() %></td>
    <td  class="td-left" width="18%">
	    	<label><liferay-ui:message key="pcccdocumentsend-socongvannoibo"/></label></td>
    <td class="td-right"><%=receiptDTO.getNumberLocalDocumentReceipt()%></td>
	</tr>
<tr>
	<td  class="td-left">
			<label><liferay-ui:message key="pcccdocumentsend-trichyeu"/></label></td>
	<td class="td-right"><%=receiptDTO.getBriefContent() %></td>
    <td  class="td-left">
	    	<label><liferay-ui:message key="pcccdocumentsend-taptindinhkem"/></label></td>
    <td class="td-right">
	    <logic:iterate id="attachedFileReceiver" name="attachedFileReceivers" indexId="j" type="com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile" scope="request" >
	    	<u><a href="<%=attachedFileReceiver.getPath() %>"><%= attachedFileReceiver.getTitle() %></a></u> <br/>
		</logic:iterate>
    </td>
</tr>
</table>
</fieldset>
<%
	} 
%>
<br/>
<fieldset class="filborder">
<legend class="laborder"><liferay-ui:message key="pccc-XL-quatrinhluanchuyencongvanden"/></legend>
<div class="Scrollbarauto">
<table class="taglib-search-iterator table-pml" cellspacing="0" width="100%">	
	<tr class="portlet-section-header results-header" >
		<td align="center" width="35px"><liferay-ui:message key="pccc-TN-stt"/></td>
		<td style="width: 20%"><liferay-ui:message key="pcccdocumentsend-donvicanhangui"/></td>
		<td align="center"><liferay-ui:message key="pccc-XL-ngaygui"/></td>
		<td style="width: 35%"><liferay-ui:message key="pcccdocumentsend-yeucauxuly"/></td>
		<td style="width: 20%"><liferay-ui:message key="pcccdocumentsend-donvicanhannhan"/></td>
		<td align="center"><liferay-ui:message key="pccc-TN-ngaynhan"/></td>						
	</tr>
	<%
		List<DocumentSendLogDTO> pmlDocumentSendLogList = (List<DocumentSendLogDTO>)renderRequest.getAttribute("pmlDocumentSendLogList");
			for (int i =  0; i < pmlDocumentSendLogList.size(); i++) {
			DocumentSendLogDTO pmlDocumentSendLog = pmlDocumentSendLogList.get(i);
	%>
	<tr class="<%=(i % 2) == 0 ? "results-row" : "tr_two results-row" %>" onmouseover="onMouseOverTr(this);" onmouseout="onMouseOutTr(this);">
					<td align="center"><%= i+1%>.</td>
					<td><%=pmlDocumentSendLog.getProcessor() %></td>
					<td align="center"><%=pmlDocumentSendLog.getDateProcess() != null ? new SimpleDateFormat("dd/MM/yyyy").format(pmlDocumentSendLog.getDateProcess()) : ""%></td>
					<td><%=pmlDocumentSendLog.getProcessInformation() %></td>
					<td><%=pmlDocumentSendLog.getReceiver() %></td>
					<td align="center"><%=pmlDocumentSendLog.getReceiverDate() != null ? new SimpleDateFormat("dd/MM/yyyy").format(pmlDocumentSendLog.getReceiverDate()) : "" %></td>
	</tr>
	<%
			}
	%>	
</table>
</div>

</fieldset>

<!-- phmphuc add lien ket vb 22/11/2010 -->
<%
// Lay danh sach ma so van ban den va di lien quan den van ban hien tai
List<Long> docRecIdsRelation = new ArrayList<Long>(); // Danh sach ma so van ban den lien quan
List<Long> docSendIdsRelation = new ArrayList<Long>(); // Danh sach ma so van ban di lien quan
// Lay danh sach van ban lien quan A relation B co A la van ban dang xet
List<PmlEdmDocumentRelation> docRelations = PmlEdmDocumentRelationUtil.findByDocLeftId_LeftIsReceipt(
		sendDTO.getDocumentSendId(), false);
PmlEdmDocumentRelation relItem = null;
for (int idxR = 0; idxR < (docRelations.isEmpty() ? 0 : docRelations.size()); idxR ++) {
	relItem = docRelations.get(idxR);
	if (relItem.getRightIsReceipt() == true) { // B la van ban den
		if (!docRecIdsRelation.contains(relItem.getDocRightId())) { // Chua co trong danh sach
			docRecIdsRelation.add(relItem.getDocRightId());
		}
	}
	else { // B la van ban di
		if (!docSendIdsRelation.contains(relItem.getDocRightId())) { // Chua co trong danh sach
			docSendIdsRelation.add(relItem.getDocRightId());
		}
	}
}
// Lay danh sach van ban lien quan B relation A co B la van ban dang xet
docRelations = PmlEdmDocumentRelationUtil.findByDocRightId_RightIsReceipt(
		sendDTO.getDocumentSendId(), false);
for (int idxR = 0; idxR < (docRelations.isEmpty() ? 0 : docRelations.size()); idxR ++) {
	relItem = docRelations.get(idxR);
	if (relItem.getLeftIsReceipt() == true) { // A la van ban den
		if (!docRecIdsRelation.contains(relItem.getDocLeftId())) { // Chua co trong danh sach
			docRecIdsRelation.add(relItem.getDocLeftId());
		}
	}
	else { // A la van ban di
		if (!docSendIdsRelation.contains(relItem.getDocLeftId())) { // Chua co trong danh sach
			docSendIdsRelation.add(relItem.getDocLeftId());
		}
	}
}
%>
<c:if test="<%= !docRecIdsRelation.isEmpty() || !docSendIdsRelation.isEmpty() %>">
<fieldset class="filborder">
<legend class="laborder"><liferay-ui:message key="link-document-exist"/></legend>
<div class="Scrollbarauto">

			<%
			if (!docRecIdsRelation.isEmpty()) {
			%>
			<table class="taglib-search-iterator table-pml" cellspacing="0" width="100%">	
				<tr class="portlet-section-header results-header" >
					<td colspan="4"><liferay-ui:message key="cvden" /></td>
				</tr>
				<tr class="portlet-section-header results-header" >
					<td width="15%"><liferay-ui:message key="pccc-cvdtn-sohieu" /></td>
					<td width="10%"><liferay-ui:message key="pccc-cvdtn-soCVden" /></td>
					<td width="30%"><liferay-ui:message key="pccc-cvdtn-noiphathanh" /></td>
					<td><liferay-ui:message key="pccc-cvdtn-trichyeu" /></td>
				</tr>
				<%
				// Duyet danh sach relDocReceiptIds de xuat ra tr trong table
					int k = 0;
					for (int idxDR = 0; idxDR < docRecIdsRelation.size(); idxDR ++) {
						PmlEdmDocumentReceipt tmpDocReceipt = null;
						try {
							tmpDocReceipt = PmlEdmDocumentReceiptUtil.findByPrimaryKey(docRecIdsRelation.get(idxDR));
							k ++;
						}
						catch (Exception ex) {
							System.out.println("Khong doc duoc van ban den so:" + String.valueOf(docRecIdsRelation.get(idxDR)));
						}
						if (tmpDocReceipt != null) {
							// Lay ten noi phat hanh
							String noiPHDesc = "";
							if (tmpDocReceipt.getIssuingPlaceId().trim().length() > 0) {
								// Lay theo ma so
								try {
									noiPHDesc = PmlEdmIssuingPlaceUtil.findByPrimaryKey(
											tmpDocReceipt.getIssuingPlaceId()).getIssuingPlaceName();
								}
								catch (Exception ex) {
									System.out.println("Khong lay duoc noi PH co ma so:" + tmpDocReceipt.getIssuingPlaceId());
								}
							}
							else {
								// Lay theo ten
								noiPHDesc = tmpDocReceipt.getIssuingPlaceOtherName();
							}
				%>
							<tr class="<%= (k % 2) == 1 ? "results-row" : "tr_two results-row" %>">
								<td>
									<a href="##" onclick="<portlet:namespace />viewDocRecDetailPopup('<%= tmpDocReceipt.getDocumentReceiptId() %>')">
										<%= tmpDocReceipt.getDocumentReference() %>
									</a>
								</td>
								<td><%= tmpDocReceipt.getNumberDocumentReceipt() %></td>
								<td><%= noiPHDesc %></td>
								<td><%= tmpDocReceipt.getBriefContent() %></td>
							</tr>
				<%
						}
		  			}
				%>
			</table>
			<% } %>
			
			<div class="separator"><!-- --></div>
			<%
			if (!docSendIdsRelation.isEmpty()) {
			%>
			<table class="taglib-search-iterator table-pml" cellspacing="0" width="100%">	
				<tr class="portlet-section-header results-header" >
					<td colspan="4"><liferay-ui:message key="cvdi" /></td>
				</tr>
				<tr class="portlet-section-header results-header" >
					<td width="15%"><liferay-ui:message key="nguoi-soan" /></td>
					<td width="20%"><liferay-ui:message key="receipt.department" /></td>
					<td width="25%"><liferay-ui:message key="receipt.receiveplace" /></td>
					<td><liferay-ui:message key="receipt.briftcontent" /></td>
				</tr>
				<%
				// Duyet danh sach relDocSendIds de xuat ra tr trong table
					int k = 0;
					for (int idxDS = 0; idxDS < docSendIdsRelation.size(); idxDS ++) {
						PmlEdmDocumentSend tmpDocSend = null;
						try {
							tmpDocSend = PmlEdmDocumentSendUtil.findByPrimaryKey(docRecIdsRelation.get(idxDS));
							k ++;
						}
						catch (Exception ex) {
							System.out.println("Khong doc duoc van ban di so:" + String.valueOf(docSendIdsRelation.get(idxDS)));
						}
						if (tmpDocSend != null) {
							// Lay ten nguoi soan thao, phong soan thao
							String nguoiSTDesc = "";
							String phongSTDesc = "";
							if (tmpDocSend.getEditorId() > 0) {
								try {
									PmlUser tmpUser = PmlUserUtil.findByPrimaryKey(tmpDocSend.getEditorId());
									nguoiSTDesc = tmpUser.getLastName() + " " + tmpUser.getMiddleName() + " " + tmpUser.getFirstName();
									phongSTDesc = DepartmentUtil.findByPrimaryKey(tmpUser.getDepartmentsId()).getDepartmentsName();
								}
								catch (Exception ex) {
									System.out.println("Khong lay duoc nguoi dung, phong ban co ma so nguoi dung:" + String.valueOf(tmpDocSend.getEditorId()));
								}
							}
				%>
							<tr class="<%= (k % 2) == 1 ? "results-row" : "tr_two results-row" %>">
								<td>
									<a href="##" onclick="<portlet:namespace />viewSendRecDetailPopup('<%= tmpDocSend.getDocumentSendId() %>')">
										<%= nguoiSTDesc %>
									</a>
								</td>
								<td><%= phongSTDesc %></td>
								<td><%= tmpDocSend.getReceivingPlace() %></td>
								<td><%= tmpDocSend.getBriefContent() %></td>
							</tr>
				<%
						}
					}
				%>
			</table>
			<% } %>
		</div>
</fieldset>
</c:if>
<!-- end phmphuc update lien ket van ban 22/11/2010 -->

<div align="right" id="table-button">
	<%
	   	if ("dangXuLy".equals(hienTrang)) {
	%>
	 	<liferay-util:include page="/html/portlet/ext/pcccdocumentsendprocess/common/workflowAction.jsp"></liferay-util:include>
	<%
   	} else { //yenlt update 20101119 == vb rut lai
		boolean rutLai = ParamUtil.getBoolean(renderRequest, "rutLai", false);
		if (rutLai) {
	%>
		<input type="hidden" name="rutLai" value="<%= String.valueOf(rutLai) %>">
		<liferay-util:include page="/html/portlet/ext/pcccdocumentsendprocess/common/workflowAction.jsp"></liferay-util:include>
	<%
		} 
  	}// end yenlt update 20101119
	%>
		<span onclick="javascript:submitForm(document.hrefFm,'<%= redirect %>');" >
			<input class="button-width" type="button" value='<liferay-ui:message key="back" />'>
	</span>
</div>
</div>
</div>
</div>
</form>  

<script language="javascript">
	function <portlet:namespace />viewDocRecDetailPopup(docId) {   
		var posX = screen.width / 7;
		var posY = screen.height / 5;
		var heightPopup = 510;
		var widthPopup = 800;
	  	var host = location.host;
	  	var path = "http://" + host + "/html/portlet/ext/pcccdocumentreceiptprocess/detaildocumentreceiptpopup.jsp?documentReceiptId=" + docId;
	  	var objPop = window.open (path, "objPop", "status=1,scrollbars=1,width=" + widthPopup + "px ,height=" + heightPopup + "px");
	  
	  	objPop.moveTo(posX , posY);
	}

	function <portlet:namespace />viewSendRecDetailPopup(docId) {   
		var posX = screen.width / 7;
		var posY = screen.height / 5;
		//var heightPopup = 4 * posY;
		var heightPopup = 510;
		var widthPopup = 800;
	  	var host = location.host;
	  	var path = "http://" + host + "/html/portlet/ext/pcccdocumentsendprocess/detaildocumentsendpopup.jsp?documentSendId=" + docId;
	  	var objPop = window.open (path, "objPop", "directories=no,location=no,menubar=no,scrollbars=yes,status=no,toolbar=no,width=" + widthPopup + "px ,height=" + heightPopup + "px");
	  
	  	objPop.moveTo(posX , posY);
	}
	$jq(function(){
		$jq("#<portlet:namespace/>workflow_tree").jstree({
			"core" : { "initially_open" : [ "_opened" ] },
			"themes" : {
				"theme" : "classic",
				"dots" : true,
				"icons" : false
			},
			"plugins" : [ "themes", "html_data" ]
		});
		jQuery(".ttip").tooltip({bodyHandler: function(){			
			return jQuery("#" + jQuery(this).attr('tname')).html();
		}});
	});
</script>
<%!
public String getHtml(DocumentSendLogNode root) {
	PmlDocumentSendLog receiptLog = root.getReceiptLog();
	StringBuilder sb = new StringBuilder();
	if (receiptLog.getReceiver() < 1) {
		return sb.toString();
	}
	sb.append("<li id='_opened' class='");
	if (receiptLog.getType_() == 0) {
		sb.append("primary_branch");
	} else {
		sb.append("secondary_branch");
	}
	if (root.isCurrentNodeWF()) {
		sb.append(" current_node");
	}
	sb.append("'><a title='' class='ttip' tname='");
	sb.append(root.getParent() != null ? receiptLog.getPrimaryKey() : "");
	sb.append("'>");
	sb.append(root.getProcesserName());
	sb.append("</a>");
	if (root.getParent() != null) {
		sb.append("<div id='");
		sb.append(receiptLog.getPrimaryKey());
		sb.append("' style='display: none;'>");
		sb.append(root.getInformation());
		sb.append("</div>");
	}
	List<DocumentSendLogNode> children = root.getChildren();
	if (children.size() > 0) {
		sb.append("<ul>");
		for (DocumentSendLogNode child : children) {
			sb.append(getHtml(child));
		}
		sb.append("</ul>");
	}
	sb.append("</li>");
	return sb.toString();
}

public String getFullName(User user) {
	
	StringBuilder sb = new StringBuilder();
	if (user == null) {
		return sb.toString();
	} else {
		sb.append(user.getLastName());
		sb.append(" ");
		sb.append(user.getMiddleName());
		sb.append(" ");
		sb.append(user.getFirstName());
		return sb.toString();
	}
}
%>
