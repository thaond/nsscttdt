<%@ include file="/html/common/init.jsp" %>

<%@page import="com.sgs.portlet.document.send.model.PmlEdmDocumentSend"%>
<%@page import="com.sgs.portlet.document.send.service.persistence.PmlEdmDocumentSendUtil"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.sgs.portlet.document.receipt.model.PmlEdmDocumentType"%>
<%@page import="com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentTypeUtil"%>
<%@page import="com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentRecordTypeUtil"%>
<%@page import="com.sgs.portlet.document.receipt.service.persistence.PmlEdmConfidentialLevelUtil"%>
<%@page import="com.sgs.portlet.document.receipt.service.persistence.PmlEdmPrivilegeLevelUtil"%>
<%@page import="com.sgs.portlet.pmluser.model.PmlUser"%>
<%@page import="com.sgs.portlet.pmluser.service.persistence.PmlUserUtil"%>
<%@page import="java.util.List"%>
<%@page import="com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec"%>
<%@page import="com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV"%>
<%@page import="com.sgs.portlet.pml_ho_so_cong_viec.service.persistence.PmlChiTietHSCVUtil"%>
<%@page import="com.sgs.portlet.pml_ho_so_cong_viec.service.persistence.PmlHoSoCongViecUtil"%>
<%@page import="com.sgs.portlet.department.service.persistence.DepartmentUtil"%>
<%@page import="com.sgs.portlet.document.send.service.persistence.PmlEdmAnswerDetailUtil"%>
<%@page import="com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt"%>
<%@page import="com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentReceiptUtil"%>
<%@page import="com.sgs.portlet.document.model.PmlDocumentSendLog"%>
<%@page import="com.sgs.portlet.document.service.persistence.PmlDocumentSendLogUtil"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.Comparator"%>
<%@page import="java.util.ArrayList"%>
<head>
	<link type="text/css" rel="stylesheet" href="/html/portlet/ext/pcccdocumentsendprocess/css/letter.css" />
	<link type="text/css" rel="stylesheet" href="/html/css/changeColorRow.css" />
	<link type="text/css" rel="stylesheet" href="/html/themes/sgs-portal-skin/css/base.css" />
	<link type="text/css" rel="stylesheet" href="/html/themes/sgs-portal-skin/css/forms.css" />
</head>

<%
	// Lay ma so van ban di tu trang truoc truyen qua
	long documentSendId = ParamUtil.getLong(request, "documentSendId");
	// Kiem tra ma so truoc khi xuat du lieu
	PmlEdmDocumentSend docSendItem = null;
	try {
		docSendItem = PmlEdmDocumentSendUtil.findByPrimaryKey(documentSendId);
	}
	catch (Exception ex) {
		out.println(LanguageUtil.get(pageContext, "no-determine-item-need-manipulate") + ". ");
		out.println(LanguageUtil.get(pageContext, "please-contact-with-administrator-about-this-error"));
		return;
	}
	
	// ***** Lay ra cac thuoc tinh de xuat ra form start *****
	String documentTypeName = ""; // Ten loai van ban
	String documentRecordTypeName = ""; // Ten so van ban
	if (docSendItem.getDocumentTypeId() > 0) {
		try {
			PmlEdmDocumentType docTypeItem = PmlEdmDocumentTypeUtil.findByPrimaryKey(
					docSendItem.getDocumentTypeId());
			documentTypeName = docTypeItem.getDocumentTypeName();
			if (docTypeItem.getDocumentRecordTypeId() > 0) {
				try {
					documentRecordTypeName = PmlEdmDocumentRecordTypeUtil.findByPrimaryKey(
							docTypeItem.getDocumentRecordTypeId()).getDocumentRecordTypeName();
				}
				catch (Exception e) {
					System.out.println("Khong lay duoc so van ban co ma so:" + String.valueOf(
							docTypeItem.getDocumentRecordTypeId()));
				}
			}
		}
		catch (Exception ex) {
			System.out.println("Khong lay duoc loai van ban co ma so:" + String.valueOf(
					docSendItem.getDocumentTypeId()));
		}
	}
	String confidentialLevelName = ""; // Ten do mat
	if (docSendItem.getConfidentialLevelId().trim().length() > 0) {
		try {
			confidentialLevelName = PmlEdmConfidentialLevelUtil.findByPrimaryKey(
					docSendItem.getConfidentialLevelId()).getConfidentialLevelName();
		}
		catch (Exception ex) {
			System.out.println("Khong lay duoc do mat co ma so:" + docSendItem.getConfidentialLevelId());
		}
	}
	String privilegeLevelName = ""; // Ten do khan
	if (docSendItem.getPrivilegeLevelId().trim().length() > 0) {
		try {
			privilegeLevelName = PmlEdmPrivilegeLevelUtil.findByPrimaryKey(
					docSendItem.getPrivilegeLevelId()).getPrivilegeLevelName();
		}
		catch (Exception ex) {
			System.out.println("Khong lay duoc do khan co ma so:" + docSendItem.getPrivilegeLevelId());
		}
	}
	String editorName = ""; // Ten nguoi soan thao
	String departmentName = ""; // Ten phong soan thao
	if (docSendItem.getEditorId() > 0) {
		try {
			PmlUser editor = PmlUserUtil.findByPrimaryKey(docSendItem.getEditorId());
			editorName = editor.getLastName() + " " + editor.getMiddleName() + " " + editor.getFirstName();
			if (editor.getDepartmentsId().trim().length() > 0) {
				try {
					departmentName = DepartmentUtil.findByPrimaryKey(
							editor.getDepartmentsId()).getDepartmentsName();
				}
				catch (Exception ex) {
					System.out.println("Khong lay duoc phong ban co ma so:" + editor.getDepartmentsId());
				}
			}
		}
		catch (Exception ex) {
			System.out.println("Khong lay duoc nguoi dung co ma so:" + String.valueOf(
					docSendItem.getEditorId()));
		}
	}
	// ***** Lay ra cac thuoc tinh de xuat ra form end *****

	// ***** Lay danh sach ho so cong viec start *****
	List<PmlHoSoCongViec> pmlHoSoCongViecList = new ArrayList<PmlHoSoCongViec>();
	List<PmlChiTietHSCV> chiTietHSCVs = PmlChiTietHSCVUtil.findByIdCongVanDi(documentSendId);
	if (!chiTietHSCVs.isEmpty()) {
		for (int idxCT = 0; idxCT < chiTietHSCVs.size(); idxCT ++) {
			try {
				PmlHoSoCongViec hSCVItem = PmlHoSoCongViecUtil.findByPrimaryKey(
						chiTietHSCVs.get(idxCT).getIdHoSoCongViec());
				pmlHoSoCongViecList.add(hSCVItem);
			}
			catch (Exception ex) {
				System.out.println("Khong lay duoc ho so cong viec co ma so:" + String.valueOf(
						chiTietHSCVs.get(idxCT).getIdHoSoCongViec()));
			}
		}
	}
	// ***** Lay danh sach ho so cong viec end *****
	
	// ***** Lay ra van ban den ma van ban di nay phuc dap cho no start *****
	long documentReceiptId = 0;
	PmlEdmDocumentReceipt docRecItem = null;
	try {
		documentReceiptId = PmlEdmAnswerDetailUtil.findByDocumentSendId(
				documentSendId).get(0).getDocumentReceiptId();
		docRecItem = PmlEdmDocumentReceiptUtil.findByPrimaryKey(documentReceiptId);
	}
	catch (Exception ex) {}
	// ***** Lay ra van ban den ma van ban di nay phuc dap cho no end *****

	// ***** Lay ra danh sach log cua van ban va sap xep tang dan theo transition_ start *****
	List<PmlDocumentSendLog> pmlDocumentSendLogList = 
		PmlDocumentSendLogUtil.findByDocumentSendId(documentSendId);
	if (!pmlDocumentSendLogList.isEmpty()) {
		Collections.sort(pmlDocumentSendLogList, new Comparator<PmlDocumentSendLog>() {
			public int compare(PmlDocumentSendLog obj1, PmlDocumentSendLog obj2) {
				return (obj1.getTransition_() - obj2.getTransition_());
			}
		});
	}
	// ***** Lay ra danh sach log cua van ban va sap xep tang dan theo transition_ end *****
%>

<form method="post">
<div class="boxcontent">
<fieldset class="filborder">
	<label class="laborder"><liferay-ui:message key="pccc-TN-thongtinchitiet"/></label>
			<table width="100%" cellspacing="0">
				<tr>
					<td class="td-left" width="18%"><label><liferay-ui:message key="receipt.senddate"/>:</label></td>
					<td class="td-right" width="32%">
						<%= null != docSendItem.getIssuingDate() ? new SimpleDateFormat("dd/MM/yyyy").format(docSendItem.getIssuingDate()) : "" %>
					</td>
				    <td class="td-left" width="18%"><label><liferay-ui:message key="receipt.doctype"/>:</label></td>
				    <td class="td-right"><%= documentTypeName %></td>
				</tr>
				<tr>
					<td class="td-left"><label><liferay-ui:message key="receipt.issuingdate"/>:</label></td>
					<td class="td-right">
						<%= (null != docSendItem.getIssuingDate() ? new SimpleDateFormat("dd/MM/yyyy").format(docSendItem.getIssuingDate()) : "") %>
					</td>
					<td class="td-left"><label><liferay-ui:message key="receipt.confidentallevelid"/>:</label></td>
					<td class="td-right"><%= confidentialLevelName %></td>
				</tr>
				<tr>
					<td class="td-left"><label><liferay-ui:message key="receipt.creator"/>:</label></td>
					<td class="td-right"><%= editorName %></td>
					<td class="td-left"><label><liferay-ui:message key="receipt.previlegenlevelid"/>:</label></td>
					<td class="td-right"><%= privilegeLevelName %></td>
				</tr>
				<tr>
					<td class="td-left" valign="top"><label><liferay-ui:message key="pccc-cvdtn-hosocongviec"/>:</label></td>
					<td class="td-right">
						<div class="cvd-filedinhkem" style="width: 99%;background-color: white;">
							<c:if test="<%= !pmlHoSoCongViecList.isEmpty() %>">
								<%
								for (int idxHSCV = 0; idxHSCV < pmlHoSoCongViecList.size(); idxHSCV ++) {
									out.println("<div>-&nbsp;" + pmlHoSoCongViecList.get(idxHSCV).getTieuDe() + "</div><br>");
								}
								%>
							</c:if>
						</div>
					</td>
					<td class="td-left">
						<label><liferay-ui:message key="receipt.docrectype"/>:</label>
					</td>
					<td class="td-right"><%= documentRecordTypeName %></td>
				</tr>
				<tr>
					<td class="td-left"><label><liferay-ui:message key="receipt.department"/>:</label></td>
					<td class="td-right"><%= departmentName %></td>
					<td class="td-left" rowspan="4" valign="top">
						<label><liferay-ui:message key="receipt.briftcontent"/>:</label></td>
				    <td rowspan="4" class="td-right">
				    	<%= docSendItem.getBriefContent() %>
				    </td>
				</tr>
				<tr>
					<td class="td-left"><label><liferay-ui:message key="receipt.receiveplace"/>:</label></td>
					<td class="td-right"><%= docSendItem.getReceivingPlace() %></td>
				</tr>
				<tr>
					<td valign="top" class="td-left">
						<label><liferay-ui:message key="receipt.signer"/>:</label></td>
					<td class="td-right"><%= docSendItem.getSignerName() %></td>
				</tr>
				<tr>
					<td valign="top" class="td-left">
						<label><liferay-ui:message key="receipt.position"/>:</label></td>
					<td class="td-right"><%= docSendItem.getPosition() %></td>
				</tr>
				<tr>
					<td valign="top" class="td-left"><label><liferay-ui:message key="receipt.page"/>:</label></td>
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
</fieldset>
	<%
 	if (docRecItem != null) {
	%>
<fieldset class="filborder">
	<label class="laborder"><liferay-ui:message key="pcccdocumentsend-traloichocongvanden"/></label>
		<table cellspacing="0" width="100%">	
					<tr>
						<td valign="top" class="td-left" width="35%">
							<label><liferay-ui:message key="pcccdocumentsend-sohieucongvanden"/></label>
						</td>
						<td class="td-right"><%= docRecItem.getDocumentReference() %></td>
					</tr>
					<tr>
					    <td valign="top" class="td-left">
					    	<label><liferay-ui:message key="pcccdocumentsend-socongvannoibo"/></label></td>
				    	<td class="td-right"><%= docRecItem.getNumberLocalDocumentReceipt()%></td>
					</tr>
					<tr>
						<td valign="top" class="td-left">
							<label><liferay-ui:message key="pcccdocumentsend-trichyeu"/></label></td>
						<td class="td-right"><%= docRecItem.getBriefContent() %></td>
					</tr>
	</table>
</fieldset>
	<%
	} 
	%>

<fieldset class="filborder">
	<label class="laborder"><liferay-ui:message key="pcccdocumentsend-quatrinhluanchuyencongvanden"/></label>
	<div class="Scrollbarauto">
		<table class="taglib-search-iterator table-pml" cellspacing="0" width="100%">	
				<tr class="portlet-section-header results-header" >
					<td width="35px" align="center"><liferay-ui:message key="pccc-TN-stt"/></td>
					<td width="20%"><liferay-ui:message key="pcccdocumentsend-donvicanhangui"/></td>
					<td width="11%" align="center"><liferay-ui:message key="pccc-XL-ngaygui"/></td>
					<td width="35%"><liferay-ui:message key="pcccdocumentsend-yeucauxuly"/></td>
					<td width="20%"><liferay-ui:message key="pcccdocumentsend-donvicanhannhan"/></td>
					<td align="center"><liferay-ui:message key="pccc-TN-ngaynhan"/></td>						
				</tr>
				<%
				for (int i =  0; i < (pmlDocumentSendLogList.isEmpty() ? 0 : pmlDocumentSendLogList.size()); i++) {
					PmlDocumentSendLog pmlDocumentSendLog = pmlDocumentSendLogList.get(i);
					PmlUser nguoiGui = null;
					String processerName = "";
					if (pmlDocumentSendLog.getProcesser() != 0) {
						try {
							nguoiGui = PmlUserUtil.findByPrimaryKey(pmlDocumentSendLog.getProcesser());
							processerName = nguoiGui.getLastName() + " " + nguoiGui.getMiddleName() + " " + nguoiGui.getFirstName();
						}
						catch (Exception ex) {
							System.out.println("Khong lay duoc nguoi dung co ma so:" + String.valueOf(
									pmlDocumentSendLog.getProcesser()));
						}
					}
					
					PmlUser nguoiNhan = null;
					String receiverName = "";
					if (pmlDocumentSendLog.getReceiver() != 0) {
						try {
							nguoiNhan = PmlUserUtil.findByPrimaryKey(pmlDocumentSendLog.getReceiver());
							receiverName = nguoiNhan.getLastName() + " " + nguoiNhan.getMiddleName() + " " + nguoiNhan.getFirstName();
						}
						catch (Exception ex) {
							System.out.println("Khong lay duoc nguoi dung co ma so:" + String.valueOf(
									pmlDocumentSendLog.getReceiver()));
						}
					}
					// yenlt update 20101102
					SimpleDateFormat sdf = new SimpleDateFormat("hh'h' mm - dd/MM/yyyy");
					SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
					String ngayGui = "";
					String ngayNhan = "";
					if (pmlDocumentSendLog.getDateProcess() != null) {
						ngayGui = sd.format(pmlDocumentSendLog.getDateProcess());
				 	} if (pmlDocumentSendLog.getDateProcessTime() != null) { 
						ngayGui = sdf.format(pmlDocumentSendLog.getDateProcessTime());
				 	} if (pmlDocumentSendLog.getReceiveDate() != null) {
				 		ngayNhan = sd.format(pmlDocumentSendLog.getReceiveDate());
				 	} if (pmlDocumentSendLog.getReceiveDateTime() != null) {
				 		ngayNhan = sdf.format(pmlDocumentSendLog.getReceiveDateTime());
				 	}
				%>
					<tr class="<%= (i % 2) == 0 ? "results-row" : "tr_two results-row" %>">
						<td align="center"><%= i + 1 %>.</td>
						<td><%= processerName %></td>
						<td align="center"><%= ngayGui %></td>
						<td><%= pmlDocumentSendLog.getProcessInfomation() %></td>
						<td><%= receiverName %></td>
						<td align="center"><%= ngayNhan%></td>
					</tr>
				<%
				}
				%>	
		</table>
	</div>
</fieldset>
<div align="right" style="margin-top: 2px; padding: 5px;">
		<input type="button" value="<liferay-ui:message key='close' />" onclick="window.close();">
</div>
</div>
</form>  
