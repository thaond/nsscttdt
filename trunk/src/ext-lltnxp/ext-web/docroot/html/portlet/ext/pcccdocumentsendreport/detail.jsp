<%@ include file="/html/portlet/ext/pcccdocumentsend/init.jsp" %>
<%@ include file="/html/portlet/ext/pcccdocumentsend/js/pccc-documentsend.jsp" %>
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
<%@page import="com.sgs.portlet.document.send.model.PmlEdmDocumentSend"%>
<%@page import="com.sgs.portlet.document.send.service.persistence.PmlEdmDocumentSendUtil"%>
<%@page import="com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentTypeUtil"%>
<%@page import="com.sgs.portlet.document.receipt.service.persistence.PmlEdmConfidentialLevelUtil"%>
<%@page import="com.liferay.portal.service.persistence.UserUtil"%>
<%@page import="com.sgs.portlet.document.receipt.service.persistence.PmlEdmPrivilegeLevelUtil"%>
<%@page import="com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV"%>
<%@page import="com.sgs.portlet.pml_ho_so_cong_viec.service.persistence.PmlChiTietHSCVUtil"%>
<%@page import="com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec"%>
<%@page import="com.sgs.portlet.pml_ho_so_cong_viec.service.persistence.PmlHoSoCongViecUtil"%>
<%@page import="com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentRecordTypeUtil"%>
<%@page import="com.sgs.portlet.document.receipt.model.PmlEdmDocumentType"%>
<%@page import="com.sgs.portlet.department.service.persistence.DepartmentUtil"%>
<%@page import="com.sgs.portlet.pmluser.service.persistence.PmlUserUtil"%>
<%@page import="com.sgs.portlet.pmluser.model.PmlUser"%>
<%@page import="com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile"%>
<%@page import="com.sgs.portlet.document.receipt.service.persistence.PmlEdmAttachedFileUtil"%>
<%@page import="com.sgs.portlet.document.send.model.impl.PmlEdmDocumentSendImpl"%>
<%@page import="com.sgs.portlet.document.send.model.PmlEdmAnswerDetail"%>
<%@page import="com.sgs.portlet.document.send.service.persistence.PmlEdmAnswerDetailUtil"%>
<%@page import="com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentReceiptUtil"%>
<%@page import="com.sgs.portlet.document.model.PmlDocumentSendLog"%>
<%@page import="com.sgs.portlet.document.service.persistence.PmlDocumentSendLogUtil"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.Comparator"%>

<%@page import="com.sgs.portlet.document.model.PmlEdmDocumentRelation"%>
<%@page import="com.sgs.portlet.document.service.persistence.PmlEdmDocumentRelationUtil"%>
<%@page import="com.sgs.portlet.pmlissuingplace.service.persistence.PmlEdmIssuingPlaceUtil"%>

<link type="text/css" rel="stylesheet" href="/html/css/calendar-system.css" />
<link type="text/css" rel="stylesheet" href="/html/portlet/ext/pcccdocumentsendprocess/css/letter.css" />
<script type='text/javascript' src='/html/js/liferay/tr.js'></script>
<%
	long docSendId = ParamUtil.getLong(renderRequest, "docSendId");
	String redirect = ParamUtil.getString(renderRequest, "redirect");
	PmlEdmDocumentSend docSendItem = null;
	try {
		docSendItem = PmlEdmDocumentSendUtil.findByPrimaryKey(docSendId);
	}
	catch (Exception ex) {
		// Khong doc duoc van ban
		System.out.println("Khong doc duoc van ban di: " + docSendId);
		return;
	}
	SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
%>

<form method="post">
<div class="title_categ"><liferay-ui:message key="pcccdocumentsend-chitiet"/></div>
<div class="boxcontent">
<table width="100%" cellspacing="0">
		<tr>
			<td class="td-left" width="18%"><label><liferay-ui:message key="receipt.senddate"/>&nbsp;:</label></td>
			<td class="td-right" width="32%">
				<%= (docSendItem.getIssuingDate() != null ? format.format(docSendItem.getIssuingDate()) : "") %>
			</td>
		    <td class="td-left" width="18%"><label><liferay-ui:message key="receipt.doctype"/>&nbsp;:</label></td>
		    <td class="td-right">
		    	<%
		    	String docTypeName = "";
		    	String docRecTypeName = "";
		    	try {
		    		PmlEdmDocumentType docTypeItem = PmlEdmDocumentTypeUtil.findByPrimaryKey(docSendItem.getDocumentTypeId());
		    		docTypeName = docTypeItem.getDocumentTypeName();
		    		docRecTypeName = PmlEdmDocumentRecordTypeUtil.findByPrimaryKey(docTypeItem.getDocumentRecordTypeId()).getDocumentRecordTypeName();
		    	}
		    	catch (Exception ex) { }
		    	out.println(docTypeName);
		    	%>
		    </td>
		</tr>
		<tr>
			<td class="td-left"><label><liferay-ui:message key="receipt.issuingdate"/>&nbsp;:</label></td>
			<td class="td-right">
				<%= docSendItem.getIssuingDate() != null ? format.format(docSendItem.getIssuingDate()) : "" %>
			</td>
			<td class="td-left"><label><liferay-ui:message key="receipt.confidentallevelid"/>&nbsp;:</label></td>
			<td class="td-right">
				<%
				String confName = "";
				try {
					confName = PmlEdmConfidentialLevelUtil.findByPrimaryKey(docSendItem.getConfidentialLevelId()).getConfidentialLevelName();
				}
				catch (Exception ex) { }
				out.println(confName);
				%>
			</td>
		</tr>
		<tr>
			<td class="td-left"><label><liferay-ui:message key="receipt.creator"/>&nbsp;:</label></td>
			<td class="td-right">
				<%
				String creatorName = "";
				try {
					User creator = UserUtil.findByPrimaryKey(docSendItem.getEditorId());
					creatorName = creator.getLastName() + " " + creator.getMiddleName() + " " + creator.getFirstName();
				}
				catch (Exception ex) { }
				out.println(creatorName);
				%>
			</td>
			<td class="td-left"><label><liferay-ui:message key="receipt.previlegenlevelid"/>&nbsp;:</label></td>
			<td class="td-right">
				<%
				String privLevName = "";
				try {
					privLevName = PmlEdmPrivilegeLevelUtil.findByPrimaryKey(docSendItem.getPrivilegeLevelId()).getPrivilegeLevelName();
				}
				catch (Exception ex) { }
				out.println(privLevName);
				%>
			</td>
		</tr>
		<tr>
			<td class="td-left" valign="top"><label><liferay-ui:message key="pccc-cvdtn-hosocongviec"/>&nbsp;:</label></td>
		 	<td class="td-right">
				<div class="cvd-filedinhkem" style="width: 99%;background-color: white;">
			        <%
			        List<PmlChiTietHSCV> cTHSCVs = PmlChiTietHSCVUtil.findByIdCongVanDi(docSendId);
			        if (!cTHSCVs.isEmpty()) {
			        	try {
			        		for (int idx = 0; idx < cTHSCVs.size(); idx ++) {
			        			PmlChiTietHSCV cTHSCVItem = (PmlChiTietHSCV) cTHSCVs.get(idx);
			        			PmlHoSoCongViec hSCVItem = PmlHoSoCongViecUtil.findByPrimaryKey(cTHSCVItem.getIdHoSoCongViec());
			        %>
			        				<div>-&nbsp;<%= hSCVItem.getTieuDe() %></div><br>
			        <%
			        		}
			        	}
			        	catch (Exception ex) {
			        		// Do nothing
			        	}
			        }
			        %>
			 	</div>	 
		 	</td>
			<td class="td-left">
				<label><liferay-ui:message key="receipt.docrectype"/>&nbsp;:</label>
			</td>
		    <td class="td-right" width="35%">
		    	<%= docRecTypeName %>
		    </td>
		</tr>
		<tr>
			<td class="td-left"><label><liferay-ui:message key="receipt.department"/>&nbsp;:</label></td>
			<td class="td-right">
				<%
				String depName = "";
				try {
					PmlUser pmlUC = PmlUserUtil.findByPrimaryKey(docSendItem.getEditorId());
					depName = DepartmentUtil.findByPrimaryKey(pmlUC.getDepartmentsId()).getDepartmentsName();
				}
				catch (Exception ex) { }
				out.println(depName);
				%>
			</td>
			<td class="td-left" rowspan="4" valign="top">
				<label><liferay-ui:message key="receipt.briftcontent"/>&nbsp;:</label></td>
		    <td rowspan="4" class="td-right">
		    	<textarea class="textarea-display" readonly="readonly" rows="3" style="width: 99%"><%= docSendItem.getBriefContent() %></textarea>
		    </td>
		</tr>
		<tr>
			<td class="td-left"><label><liferay-ui:message key="receipt.receiveplace"/>&nbsp;:</label></td>
			<td class="td-right"><%= docSendItem.getReceivingPlace() %></td>
		</tr>
		<tr>
			<td valign="top" class="td-left">
				<label><liferay-ui:message key="receipt.signer"/>&nbsp;:</label></td>
			<td class="td-right"><%= docSendItem.getSignerName() %></td>
		</tr>
		<tr>
			<td valign="top" class="td-left">
					<label><liferay-ui:message key="receipt.position"/>&nbsp;:</label></td>
			<td class="td-right"><%= docSendItem.getPosition() %></td>
		</tr>
		<tr>
			<td valign="top" class="td-left">
					<label><liferay-ui:message key="receipt.docid"/>&nbsp;:</label></td>
			<td class="td-right"><%= docSendItem.getDocumentSendCode() %></td>
			<td class="td-left">
				<label><liferay-ui:message key="receipt.attachedfiles"/>&nbsp;:</label></td>
			<td class="td-right">
		    	<%
		    	List<PmlEdmAttachedFile> attFiles = PmlEdmAttachedFileUtil.findByObjectContentId_ObjectType(
		    			docSendId, new PmlEdmDocumentSendImpl().getClass().getName());
		    	if (!attFiles.isEmpty()) {
		    		for (int idx = 0; idx < attFiles.size(); idx ++) {
		    			PmlEdmAttachedFile attFileItem = (PmlEdmAttachedFile) attFiles.get(idx);
		    	%>
					    <a href="<%= attFileItem.getPath() %>"><%= attFileItem.getTitle().length() > 0 ? attFileItem.getTitle() : attFileItem.getAttachedFileName().substring(com.ext.portlet.util.Constants.NUMBER_REFIX_ATTACHEDFILE) %><br /></a>
		    	<%
		    		}
		    	}
				%>
			</td>
		</tr>
		<tr>
			<td valign="top" class="td-left"><label><liferay-ui:message key="receipt.page"/>&nbsp;:</label></td>
			<td class="td-right"><%= docSendItem.getNumberPage() %></td>
			<td class="td-left">
				<label><liferay-ui:message key="pccc-cvdtn-cocongvanphucdap"/>:</label></td>
			<td class="td-right">
				<%
				if (docSendItem.isIscongvanphucdap()) {
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
<%
	PmlEdmDocumentReceipt docRecRep = null;
	try {
		PmlEdmAnswerDetail ansDetItem = PmlEdmAnswerDetailUtil.findByDocumentSendId(docSendId).get(0);
		docRecRep = PmlEdmDocumentReceiptUtil.findByPrimaryKey(ansDetItem.getDocumentReceiptId());
	}
	catch (Exception ex) { }
  	if (docRecRep != null) {
%>
<br>
<fieldset class="filborder">
<legend class="laborder"><liferay-ui:message key="pcccdocumentsend-traloichocongvanden"/></legend>
<table cellspacing="0" width="100%">
			<tr>
				<td class="td-left" width="18%">
					<label><liferay-ui:message key="pcccdocumentsend-sohieucongvanden"/></label></td>
		    	<td class="td-right" width="32%"><%= docRecRep.getDocumentReference() %></td>
			    <td class="td-left" width="18%">
			    	<label><liferay-ui:message key="pcccdocumentsend-socongvannoibo"/></label></td>
		    	<td class="td-right"><%= docRecRep.getNumberLocalDocumentReceipt()%></td>
			</tr>
			<tr valign="top">
				<td class="td-left">
					<label><liferay-ui:message key="pcccdocumentsend-trichyeu"/></label></td>
				<td class="td-right" colspan="3"><%= docRecRep.getBriefContent() %></td>
			</tr>
</table>
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
					<td align="center" width="35px"><liferay-ui:message key="pccc-TN-stt"/></td>
					<td style="width: 20%"><liferay-ui:message key="pcccdocumentsend-donvicanhangui"/></td>
					<td align="center"><liferay-ui:message key="pccc-XL-ngaygui"/></td>
					<td style="width: 35%"><liferay-ui:message key="pcccdocumentsend-yeucauxuly"/></td>
					<td style="width: 20%"><liferay-ui:message key="pcccdocumentsend-donvicanhannhan"/></td>
					<td align="center"><liferay-ui:message key="pccc-TN-ngaynhan"/></td>						
				</tr>
				<%
					List<PmlDocumentSendLog> sendLogs = PmlDocumentSendLogUtil.findByDocumentSendId(docSendId);
					if (!sendLogs.isEmpty()) {
						// Sap xep thu tu luan chuyen van ban tang dan theo thoi gian
						Collections.sort(sendLogs, new Comparator<PmlDocumentSendLog>() {
							public int compare(PmlDocumentSendLog obj1, PmlDocumentSendLog obj2) {   
								if (obj1.getTransition_() < obj2.getTransition_()) return -1;
								if (obj1.getTransition_() == obj2.getTransition_()) return 0;
								return 1;
							}                                        
						});

						for (int i =  0; i < sendLogs.size(); i++) {
							PmlDocumentSendLog sendLogItem = (PmlDocumentSendLog) sendLogs.get(i);
				%>
							<tr class="<%=(i % 2) == 0 ? "results-row" : "tr_two results-row" %>" onmouseover="onMouseOverTr(this);" onmouseout="onMouseOutTr(this);">
								<td align="center"><%= i + 1 %>.</td>
								<td>
									<%
									String processorName = "";
									try {
										User processor = UserUtil.findByPrimaryKey(sendLogItem.getProcesser());
										processorName = processor.getLastName() + " " + processor.getMiddleName() + " " + processor.getFirstName();
									}
									catch (Exception ex) {}
									out.println(processorName);
									%>
								</td>
								<td align="center"><%= sendLogItem.getDateProcess() != null ? format.format(sendLogItem.getDateProcess()) : "" %></td>
								<td><%= sendLogItem.getProcessInfomation() %></td>
								<td>
									<%
									String receiverName = "";
									try {
										User receiver = UserUtil.findByPrimaryKey(sendLogItem.getReceiver());
										receiverName = receiver.getLastName() + " " + receiver.getMiddleName() + " " + receiver.getFirstName();
									}
									catch (Exception ex) {}
									out.println(receiverName);
									%>
								</td>
								<td align="center"><%= sendLogItem.getReceiveDate() != null ? format.format(sendLogItem.getReceiveDate()) : "" %></td>
							</tr>
				<%
						}
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
List<PmlEdmDocumentRelation> docRelations = PmlEdmDocumentRelationUtil.findByDocLeftId_LeftIsReceipt(docSendId, false);
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
docRelations = PmlEdmDocumentRelationUtil.findByDocRightId_RightIsReceipt(docSendId, false);
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
	<div align="center" style="margin-top: 2px;">
		<fieldset style="width: 99%;">
			<div id="div-head-title"><liferay-ui:message key="link-document-exist" /></div>
			<%
			if (!docRecIdsRelation.isEmpty()) {
			%>
			<table cellpadding="0" cellspacing="0" width="100%" class="tab-doc-process-list-base">
				<tr style="height: 28px" class="title-tran-header">
					<td class="td-stt-pml" colspan="4" align="left"><liferay-ui:message key="cvden" /></td>
				</tr>
				<tr style="height: 28px" class="title-tran-header">
					<td width="15%" class="td-stt-pml"><liferay-ui:message key="pccc-cvdtn-sohieu" /></td>
					<td width="10%" class="td-stt-pml"><liferay-ui:message key="pccc-cvdtn-soCVden" /></td>
					<td width="30%" class="td-stt-pml"><liferay-ui:message key="pccc-cvdtn-noiphathanh" /></td>
					<td class="td-stt-pml"><liferay-ui:message key="pccc-cvdtn-trichyeu" /></td>
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
							<tr style="height: 25px; text-align: left;" class="<%= (k % 2) == 1 ? "rowOne" : "rowTwo" %>">
								<td style="padding-left: 5px">
									<a href="##" onclick="<portlet:namespace />viewDocRecDetailPopup('<%= tmpDocReceipt.getDocumentReceiptId() %>')">
										<%= tmpDocReceipt.getDocumentReference() %>
									</a>
								</td>
								<td style="padding-left: 5px"><%= tmpDocReceipt.getNumberDocumentReceipt() %></td>
								<td style="padding-left: 5px"><%= noiPHDesc %></td>
								<td style="padding-left: 5px"><%= tmpDocReceipt.getBriefContent() %></td>
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
			<table cellpadding="0" cellspacing="0" width="100%" class="tab-doc-process-list-base">
				<tr style="height: 28px" class="title-tran-header">
					<td class="td-stt-pml" colspan="4" align="left"><liferay-ui:message key="cvdi" /></td>
				</tr>
				<tr style="height: 28px" class="title-tran-header">
					<td width="15%" class="td-stt-pml"><liferay-ui:message key="receipt.creator" /></td>
					<td width="20%" class="td-stt-pml"><liferay-ui:message key="receipt.department" /></td>
					<td width="25%" class="td-stt-pml"><liferay-ui:message key="receipt.receiveplace" /></td>
					<td class="td-stt-pml"><liferay-ui:message key="receipt.briftcontent" /></td>
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
							<tr style="height: 25px; text-align: left;" class="<%= (k % 2) == 1 ? "rowOne" : "rowTwo" %>">
								<td style="padding-left: 5px">
									<a href="##" onclick="<portlet:namespace />viewSendRecDetailPopup('<%= tmpDocSend.getDocumentSendId() %>')">
										<%= nguoiSTDesc %>
									</a>
								</td>
								<td style="padding-left: 5px"><%= phongSTDesc %></td>
								<td style="padding-left: 5px"><%= tmpDocSend.getReceivingPlace() %></td>
								<td style="padding-left: 5px"><%= tmpDocSend.getBriefContent() %></td>
							</tr>
				<%
						}
					}
				%>
			</table>
			<% } %>
		</fieldset>
	</div>
</c:if>
<!-- end phmphuc update lien ket van ban 22/11/2010 -->

<div align="right" id="table-button">
			<%---
			<span onclick="javascript:submitForm(document.hrefFm,'<%= redirect %>');" >
				<input class="button-width" type="button" value='<liferay-ui:message key="back" />'>
			</span>
			---%>
			<span onclick="javascript: history.go(-1);" >
				<input type="button" value='<liferay-ui:message key="back" />'>
			</span>
</div>
</div>
</form>  

<script type="text/javascript">
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