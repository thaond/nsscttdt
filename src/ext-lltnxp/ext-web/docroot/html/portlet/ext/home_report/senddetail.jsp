<%@ include file="/html/portlet/ext/home_report/init.jsp" %>

<%@page import="com.sgs.portlet.document.workflow.DocumentReceiptPortletAction"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.sgs.portlet.department.model.Department"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.sgs.portlet.document.send.dto.DocumentSendDTO"%>
<%@page import="com.sgs.portlet.document.receipt.dto.PmlEdmDocumentReceiptDTO"%>
<%@page import="com.sgs.portlet.pcccdocumentsend.dto.DocumentSendLogDTO"%>
<%@page import="com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>

<%@page import="com.sgs.portlet.document.model.PmlEdmDocumentRelation"%>
<%@page import="com.sgs.portlet.document.service.persistence.PmlEdmDocumentRelationUtil"%>
<%@page import="com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentReceiptUtil"%>
<%@page import="com.sgs.portlet.pmlissuingplace.service.persistence.PmlEdmIssuingPlaceUtil"%>
<%@page import="com.sgs.portlet.document.send.model.PmlEdmDocumentSend"%>
<%@page import="com.sgs.portlet.document.send.service.persistence.PmlEdmDocumentSendUtil"%>
<%@page import="com.sgs.portlet.pmluser.model.PmlUser"%>
<%@page import="com.sgs.portlet.pmluser.service.persistence.PmlUserUtil"%>
<%@page import="com.sgs.portlet.department.service.persistence.DepartmentUtil"%>

<script type='text/javascript' src='/html/js/liferay/tr.js'></script>
<%
	DocumentSendDTO sendDTO = (DocumentSendDTO) renderRequest.getAttribute("documentDTO");
	if (sendDTO == null) {
		System.out.println("Khong xac dinh duoc doi tuong!");
		return;
	}
	
	PmlEdmDocumentReceipt receiptDTO = (PmlEdmDocumentReceipt) renderRequest.getAttribute("documentReceipt");
	String department = (String) renderRequest.getAttribute("department");
	String hienTrang = ParamUtil.getString(renderRequest, "hienTrang", "dangXuLy");
	String soCongVanDiHientai = (String) renderRequest.getAttribute("soCongVanDiHientai");
	
	String redirectDetail = ParamUtil.getString(renderRequest, "redirectDetail");
%>

<div class="title_categ"><liferay-ui:message key="pcccdocumentsend-chitiet"/></div>
<div class="boxcontent">
<form action="" id="<portlet:namespace/>fm" name="<portlet:namespace/>fm"  method="post" >
		<fieldset class="filborder">
			<legend class="laborder"><liferay-ui:message key="pccc-Chitiethoso"/></legend>
			<table width="100%" cellspacing="0">
					<tr>
						<td width="18%" class="td-left"><label><liferay-ui:message key="pccc-cvdtn-socongvandencuaphong"/><label></td>
						<td width="32%" class="td-right"><%= soCongVanDiHientai %></td>
						<td width="18%" class="td-left"></td>
						<td  class="td-rigth"></td>
					</tr>
					<tr>
						<td class="td-left"><label><liferay-ui:message key="receipt.senddate"/>:</label></td>
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
						<td class="td-left"><label><liferay-ui:message key="receipt.creator"/>:</label></td>
						<td class="td-right"><%=sendDTO.getEditor() %></td>
						<td class="td-left"><label><liferay-ui:message key="receipt.previlegenlevelid"/>:</label></td>
						<td class="td-right"><%=sendDTO.getPrivilegel() %></td>
					</tr>
					
					<tr>
						<td class="td-left" valign="top"><label><liferay-ui:message key="pccc-cvdtn-hosocongviec"/>:</label></td>
						<td class="td-right">
							<div class="cvd-filedinhkem" style="width: 99%;background-color: white;">
								<logic:iterate id="pmlHoSoCongViec" name="pmlHoSoCongViecList" indexId="i" type="com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec"  >
									<span id="stt">- &nbsp;</span><%= pmlHoSoCongViec.getTieuDe() %><br/>
						        </logic:iterate>
							 </div>	 
						</td>
						<td class="td-left" >
							<label><liferay-ui:message key="receipt.docrectype"/>:</label>
						</td>
						<td class="td-right" ><%=sendDTO.getDocumentRecord() %></td>
					</tr>
					
					<tr>
						<td class="td-left"><label><liferay-ui:message key="receipt.department"/>:</label></td>
						<td class="td-right"><%=department %></td>
						<td class="td-left" rowspan="4" valign="top">
							<label><liferay-ui:message key="receipt.briftcontent"/>:</label></td>
					    <td class="td-right">
					    	<textarea class="textarea-display" onMouseover="this.style.backgroundColor='white';" readonly="" rows="6"><%=sendDTO.getBriefContent() %></textarea>
					    </td>
					</tr>
					
					<tr>
						<td class="td-left"><label><liferay-ui:message key="receipt.receiveplace"/>:</label></td>
						<td class="td-right"><%=sendDTO.getReceivingPlace() %></td>
						<td></td>
						<td></td>
					</tr>
					
					<tr>
						<td valign="top" class="td-left"><label><liferay-ui:message key="receipt.signer"/>:</label></td>
						<td class="td-right"><%=sendDTO.getSigner() %></td>
						<td></td>
						<td></td>
					</tr>
					
					<tr>
						<td valign="top" class="td-left"><label><liferay-ui:message key="receipt.position"/>:</label></td>
						<td class="td-right"><%=sendDTO.getPosition() %></td>
						<td></td>
						<td></td>
					</tr>
					
					<tr>
						<td valign="top" class="td-left"><label><liferay-ui:message key="receipt.docid"/>:</label></td>
						<td class="td-right"><%=sendDTO.getDocumentSendCode() %></td>
						<td class="td-left"><label><liferay-ui:message key="receipt.attachedfiles"/>:</label></td>
						<td class="td-right">
							<logic:iterate id="attachedFile" name="attachedFiles" indexId="i" type="com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile" scope="request" >
								<u><a href="<%=attachedFile.getPath() %>" style="text-decoration:none;"><%=(attachedFile.getTitle())%></a></u> <br/> 
							</logic:iterate>
						</td>
					</tr>
					
					<tr>
						<td valign="top" class="td-left"><label><liferay-ui:message key="receipt.page"/>:</label></td>
						<td class="td-right"><%=sendDTO.getNumberPage() %></td>
						<td class="td-left"><label><liferay-ui:message key="pccc-cvdtn-cocongvanphucdap"/>:</label></td>
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
				</table>
			</fieldset>
			
			<br/>
		<%
		  	if (receiptDTO != null) {
		%>
		
			<fieldset class="filborder">
				<legend class="laborder"><liferay-ui:message key="pcccdocumentsend-traloichocongvanden"/></legend>
				<div class="Scrollbarauto">
					<table cellspacing="0" width="100%">	
						<tr>
							<td class="td-left" width="18%"><label><liferay-ui:message key="pcccdocumentsend-sohieucongvanden"/>&nbsp;:</label></td>
						    <td class="td-right" width="32%"><%=receiptDTO.getDocumentReference() %></td>
						    <td class="td-left" width="18%"><label><liferay-ui:message key="pcccdocumentsend-socongvannoibo"/>&nbsp;:</label></td>
					    	<td class="td-right"><%=receiptDTO.getNumberLocalDocumentReceipt()%></td>
						</tr>
						
						<tr>
							<td class="td-left"><label><liferay-ui:message key="pcccdocumentsend-trichyeu"/>&nbsp;:</label></td>
							<td class="td-right"><%=receiptDTO.getBriefContent() %></td>
						    <td class="td-left"><label><liferay-ui:message key="pcccdocumentsend-taptindinhkem"/>&nbsp;:</label></td>
					    	<td class="td-right">
							   	<logic:iterate id="attachedFileReceiver" name="attachedFileReceivers" indexId="j" type="com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile" scope="request" >
							    	<a href="<%=attachedFileReceiver.getPath() %>"><%= attachedFileReceiver.getTitle() %></a> <br/>
								</logic:iterate>
					   		</td>
						</tr>
					</table>
				</div>
			</fieldset>
			<%
				} 
			%>
			<br/>
			
			<fieldset class="filborder">
				<legend class="laborder"><liferay-ui:message key="pcccdocumentsend-quatrinhluanchuyencongvanden"/></legend>
					<div class="Scrollbarauto">
					<table class="taglib-search-iterator table-pml" cellspacing="0" width="100%">	
								<tr class="portlet-section-header results-header" >
									<td width="35px" align="center"><liferay-ui:message key="pccc-TN-stt"/></td>
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
List<PmlEdmDocumentRelation> docRelations = PmlEdmDocumentRelationUtil.findByDocLeftId_LeftIsReceipt(sendDTO.getDocumentSendId(), false);
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
docRelations = PmlEdmDocumentRelationUtil.findByDocRightId_RightIsReceipt(sendDTO.getDocumentSendId(), false);
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
					<td width="15%"><liferay-ui:message key="receipt.creator" /></td>
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
<div id="table-button" align="right">
	<span onclick="back();" > <input class="button-width" type="button" value='<liferay-ui:message key="back" />'> </span>
</div>
</form>  
</div>
<script type="text/javascript">
	function back() {
		document.getElementById('<portlet:namespace/>fm').action = "<%= redirectDetail %>";
		document.getElementById('<portlet:namespace/>fm').submit();
	}

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
</script>
