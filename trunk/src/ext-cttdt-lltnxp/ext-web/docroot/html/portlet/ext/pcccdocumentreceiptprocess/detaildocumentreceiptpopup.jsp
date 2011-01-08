<%@ include file="/html/common/init.jsp" %>

<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.Comparator"%>
<%@page import="com.sgs.portlet.document.model.PmlDocumentReceiptLog"%>
<%@page import="com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt"%>
<%@page import="com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentReceiptUtil"%>
<%@page import="com.ext.portlet.processtype.model.ProcessType"%>
<%@page import="com.ext.portlet.processtype.service.persistence.ProcessTypeUtil"%>
<%@page import="com.sgs.portlet.document.service.persistence.PmlDocumentReceiptLogUtil"%>
<%@page import="com.sgs.portlet.pmluser.service.persistence.PmlUserUtil"%>
<%@page import="com.sgs.portlet.pmluser.model.PmlUser"%>
<%@page import="com.sgs.portlet.department.service.persistence.DepartmentUtil"%>

<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.sgs.portlet.pmllevelsend.service.persistence.PmlEdmLevelSendUtil"%>
<%@page import="com.sgs.portlet.pmlissuingplace.service.persistence.PmlEdmIssuingPlaceUtil"%>
<%@page import="com.sgs.portlet.document.receipt.model.PmlEdmDocumentType"%>
<%@page import="com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentTypeUtil"%>
<%@page import="com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentRecordTypeUtil"%>
<%@page import="com.sgs.portlet.document.receipt.service.persistence.PmlEdmConfidentialLevelUtil"%>
<%@page import="com.sgs.portlet.document.receipt.service.persistence.PmlEdmPrivilegeLevelUtil"%>
<%@page import="com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec"%>
<%@page import="com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV"%>
<%@page import="com.sgs.portlet.pml_ho_so_cong_viec.service.persistence.PmlChiTietHSCVUtil"%>
<%@page import="com.sgs.portlet.pml_ho_so_cong_viec.service.persistence.PmlHoSoCongViecUtil"%>
<%@page import="com.ext.portlet.saveprocesstype.model.SaveProcessType"%>
<%@page import="com.ext.portlet.saveprocesstype.service.persistence.SaveProcessTypeUtil"%>
<%@page import="com.sgs.portlet.document.receipt.model.impl.PmlEdmDocumentReceiptImpl"%>
<%@page import="com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile"%>
<%@page import="com.sgs.portlet.document.receipt.service.persistence.PmlEdmAttachedFileUtil"%>

<%@page import="java.util.ArrayList"%><head>
	<link type="text/css" rel="stylesheet" href="/html/portlet/ext/pcccdocumentreceiptprocess/css/letter.css" />
	<link type="text/css" rel="stylesheet" href="/html/css/changeColorRow.css" />
	<link type="text/css" rel="stylesheet" href="/html/themes/sgs-portal-skin/css/base.css" />
	<link type="text/css" rel="stylesheet" href="/html/themes/sgs-portal-skin/css/forms.css" />
</head>

<%
	// Lay ma so van ban den tu trang truoc truyen qua
	long documentReceiptId = ParamUtil.getLong(request, "documentReceiptId");
	// Kiem tra ma so truoc khi xuat du lieu
	PmlEdmDocumentReceipt docRecItem = null;
	try {
		docRecItem = PmlEdmDocumentReceiptUtil.findByPrimaryKey(documentReceiptId);
	}
	catch (Exception ex) {
		out.println(LanguageUtil.get(pageContext, "no-determine-item-need-manipulate") + ". ");
		out.println(LanguageUtil.get(pageContext, "please-contact-with-administrator-about-this-error"));
		return;
	}

	// ***** Lay ra cac thuoc tinh de xuat ra form start *****
	String levelSendName = ""; // Ten cap gui van ban
	if (docRecItem.getLevelSendId() > 0) {
		try {
			levelSendName = PmlEdmLevelSendUtil.findByPrimaryKey(
					docRecItem.getLevelSendId()).getLevelSendName();
		}
		catch (Exception ex) {
			System.out.println("Khong lay duoc cap gui co ma so:" + String.valueOf(
					docRecItem.getLevelSendId()));
		}
	}
	String issuingPlaceName = ""; // Ten noi phat hanh
	if (docRecItem.getIssuingPlaceId().trim().length() > 0) {
		try {
			issuingPlaceName = PmlEdmIssuingPlaceUtil.findByPrimaryKey(
					docRecItem.getIssuingPlaceId()).getIssuingPlaceName();
		}
		catch (Exception ex) {
			System.out.println("Khong lay duoc don vi co ma so:" + docRecItem.getIssuingPlaceId());
		}
	}
	else {
		issuingPlaceName = docRecItem.getIssuingPlaceOtherName();
	}
	String documentTypeName = ""; // Ten loai van ban
	String documentRecordTypeName = ""; // Ten so van ban
	if (docRecItem.getDocumentTypeId() > 0) {
		try {
			PmlEdmDocumentType docTypeItem = PmlEdmDocumentTypeUtil.findByPrimaryKey(
					docRecItem.getDocumentTypeId());
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
					docRecItem.getDocumentTypeId()));
		}
	}
	String confidentialLevelName = ""; // Ten do mat
	if (docRecItem.getConfidentialLevelId().trim().length() > 0) {
		try {
			confidentialLevelName = PmlEdmConfidentialLevelUtil.findByPrimaryKey(
					docRecItem.getConfidentialLevelId()).getConfidentialLevelName();
		}
		catch (Exception ex) {
			System.out.println("Khong lay duoc do mat co ma so:" + docRecItem.getConfidentialLevelId());
		}
	}
	String privilegeLevelName = ""; // Ten do khan
	if (docRecItem.getPrivilegeLevelId().trim().length() > 0) {
		try {
			privilegeLevelName = PmlEdmPrivilegeLevelUtil.findByPrimaryKey(
					docRecItem.getPrivilegeLevelId()).getPrivilegeLevelName();
		}
		catch (Exception ex) {
			System.out.println("Khong lay duoc do khan co ma so:" + docRecItem.getPrivilegeLevelId());
		}
	}
	// ***** Lay ra cac thuoc tinh de xuat ra form end *****
	
	// ***** Lay danh sach ho so cong viec start *****
	List<PmlHoSoCongViec> pmlHoSoCongViecList = new ArrayList<PmlHoSoCongViec>();
	List<PmlChiTietHSCV> chiTietHSCVs = PmlChiTietHSCVUtil.findByIdCongVanDen(documentReceiptId);
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
	
	// ***** Lay danh sach cach thuc xu ly start *****
	List<ProcessType> processTypes = new ArrayList<ProcessType>();
	boolean hasProcessType = false;
	List<SaveProcessType> savePTs = SaveProcessTypeUtil.findByDocId(documentReceiptId);
	if (!savePTs.isEmpty()) {
		for (int idxSPT = 0; idxSPT < savePTs.size(); idxSPT ++) {
			try {
				ProcessType pTypeItem = ProcessTypeUtil.findByPrimaryKey(
						savePTs.get(idxSPT).getFlagProcessType());
				processTypes.add(pTypeItem);
			}
			catch (Exception ex) {
				System.out.println("Khong lay duoc cach thuc xu ly co ma so:" + String.valueOf(
						savePTs.get(idxSPT).getFlagProcessType()));
			}
		}
	}
	if (!processTypes.isEmpty()) {
		hasProcessType = true;
	}
	// ***** Lay danh sach cach thuc xu ly end *****
	
	// ***** Lay danh sach tap tin dinh kem start *****
	List<PmlEdmAttachedFile> attachedFiles = PmlEdmAttachedFileUtil.findByObjectContentId_ObjectType(
			documentReceiptId, new PmlEdmDocumentReceiptImpl().getClass().getName());
	// ***** Lay danh sach tap tin dinh kem end *****
	
	// ***** Lay phong ban va nguoi xu ly chinh start *****
	String mainDepartmentName = ""; // Phong xu ly chinh
	String mainProcessName = ""; // Nguoi xu ly chinh
	if (docRecItem.getMainDepartmentProcessId().trim().length() > 0) {
		try {
			mainDepartmentName = DepartmentUtil.findByPrimaryKey(
					docRecItem.getMainDepartmentProcessId()).getDepartmentsName();
		}
		catch (Exception ex) {
			System.out.println("Khong lay duoc phong ban co ma so:" + docRecItem.getMainDepartmentProcessId());
		}
	}
	if (docRecItem.getMainUserProcessId() > 0) {
		try {
			PmlUser mainUserPro = PmlUserUtil.findByPrimaryKey(docRecItem.getMainUserProcessId());
			mainProcessName = mainUserPro.getLastName() + " " + mainUserPro.getMiddleName() + " " 
				+ mainUserPro.getFirstName();
		}
		catch (Exception ex) {
			System.out.println("Khong lay duoc phong ban co ma so:" + String.valueOf(
					docRecItem.getMainDepartmentProcessId()));
		}
	}
	// ***** Lay phong ban va nguoi xu ly chinh end *****
	
	// ***** Lay ra danh sach log cua van ban va sap xep tang dan theo transition_ start *****
	List<PmlDocumentReceiptLog> pmlDocumentReceiptLogList = 
		PmlDocumentReceiptLogUtil.findByDocumentReceiptId(documentReceiptId);
	if (!pmlDocumentReceiptLogList.isEmpty()) {
		Collections.sort(pmlDocumentReceiptLogList, new Comparator<PmlDocumentReceiptLog>() {
			public int compare(PmlDocumentReceiptLog obj1, PmlDocumentReceiptLog obj2) {
				return (obj1.getTransition_() - obj2.getTransition_());
			}
		});
	}
	// ***** Lay ra danh sach log cua van ban va sap xep tang dan theo transition_ end *****
	SimpleDateFormat sdf = new SimpleDateFormat("hh'h' mm - dd/MM/yyyy");
	SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
%>

<form>
<div class="boxcontent">
<fieldset class="filborder">
	<label class="laborder"><liferay-ui:message key="pccc-TN-thongtinchitiet"/></label>
			<table width="100%" cellspacing="0">
				<tr>
					<td class="td-left" width="18%"><label><liferay-ui:message key="pccc-cvdtn-capgoi"/>: </label></td>
					<td class="td-right" width="32%"><%= levelSendName %></td>
					<td class="td-left" width="18%"><label><liferay-ui:message key="pccc-cvdtn-noiphathanh"/>: </label></td>
					<td class="td-right"><%= issuingPlaceName %></td>
				</tr>
				<tr>
					<td class="td-left"><label><liferay-ui:message key="pccc-cvdtn-sohieu"/>: </label></td>
					<td class="td-right"><%= docRecItem.getDocumentReference() %></td>
					<td class="td-left" ><label><liferay-ui:message key="pccc-cvdtn-ngayphathanh"/>:</label></td>
					<td class="td-right"><%= docRecItem.getIssuingDate() != null ? sd.format(docRecItem.getIssuingDate()) : "" %></td>
				</tr>
				<tr>
					<td class="td-left"><label><liferay-ui:message key="pccc-cvdtn-socongvan"/>: </label></td>
					<td class="td-right"><%= documentRecordTypeName %></td>
					<td class="td-left"><label><liferay-ui:message key="pccc-cvdtn-loaicongvan"/>:</label></td>
					<td class="td-right" ><%= documentTypeName %></td>
				</tr>
				<tr>
					<td class="td-left"><label><liferay-ui:message key="pccc-cvdtn-soCVden"/>: </label></td>
					<td class="td-right"><%= docRecItem.getNumberDocumentReceipt() %></td>
					<td class="td-left"><label><liferay-ui:message key="pccc-cvdtn-ngayden"/>:</label></td>
					<td class="td-right">
						<%= docRecItem.getDateArrive() != null ? sd.format(docRecItem.getDateArrive()) : "" %>
						<liferay-ui:message key='hour' />:&nbsp;
						<%= docRecItem.getThoigiannhancvden() %>
					</td>
				</tr>
				<tr>
					<td class="td-left"><label><liferay-ui:message key="pccc-cvdtn-domat"/>:</label></td>
					<td class="td-right"><%= privilegeLevelName %></td>
					<td class="td-left"><label><liferay-ui:message key="pccc-cvdtn-dokhan"/>:</label></td>
					<td class="td-right" colspan="3"><%= confidentialLevelName %></td>
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
					<td class="td-left" valign="top"><label><liferay-ui:message key="cach-thuc-xu-ly"/>:</label></td>
					<td class="td-right">
						<div class="cvd-filedinhkem" style="width: 99%;background-color: white;">
							<%
							if (!processTypes.isEmpty()) {
								for (int idxPT = 0; idxPT < processTypes.size(); idxPT ++) {
									out.println("<div><-&nbsp;" + processTypes.get(idxPT).getName() + "</div><br>");
								}
							}
			
							// Doc thong tin cach thuc xu ly cua van ban neu khong xac dinh duoc cach thuc xu ly tu danh muc
							if (hasProcessType == false) {
								String proTypeDesc = ""; // Dien giai cach thuc xu ly
			
								String curDocType = docRecItem.getDocumentType();
								if (curDocType.equals("1")) { // Luu
									proTypeDesc = "L\u01b0u.";
								} 
								else if (curDocType.equals("2")) {
									proTypeDesc = "B\u00e1o c\u00e1o.";
								} 
								else if (curDocType.equals("3")) {
									proTypeDesc = "So\u1EA1n v\u0103n b\u1ea3n tr\u1EA3 l\u1EDDi.";
								}
								out.println(proTypeDesc);
							}
							%>
						</div>
					</td>
				</tr>
				<tr height="100px">
					<td valign="top" class="td-left"><label><liferay-ui:message key="pccc-cvdtn-trichyeu"/>:</label></td>
					<td colspan="3" valign="middle" class="td-right">
						<textarea class="textarea-display" onMouseover="this.style.backgroundColor='white';" readonly="readonly" rows="3" style="width: 99%"><%= docRecItem.getBriefContent() %></textarea>
					</td>
				</tr>
				<tr>
					<td valign="top" class="td-left"><label><liferay-ui:message key="pccc-cvdtn-toanvan"/>:</label></td>
					<td colspan="3" class="td-right">
						<%
						if (!attachedFiles.isEmpty()) {
							for (int idxAF = 0; idxAF < attachedFiles.size(); idxAF ++) {
								PmlEdmAttachedFile attFileItem = attachedFiles.get(idxAF);
								attFileItem.setAttachedFileName(attFileItem.getAttachedFileName().substring(
										com.ext.portlet.util.Constants.NUMBER_REFIX_ATTACHEDFILE));
						%>
							<a href="<%= attFileItem.getPath() %>"><u><%= !"".equals(attFileItem.getTitle()) ? attFileItem.getTitle() : attFileItem.getAttachedFileName() %><br /></u></a>
						<%
							}
						}
						%>
					</td>
				</tr>
				<tr>
					<td class="td-left"><label><liferay-ui:message key="pccc-TN-phongbanthulychinh"/>:</label></td>
					<td class="td-right"><%= mainDepartmentName %></td>
					<td class="td-left"><label><liferay-ui:message key="pccc-TN-nguoithulychinh"/>:</label></td>
					<td class="td-right"><%= mainProcessName %></td>
				</tr>
			</table>
</fieldset>
<br>
<fieldset class="filborder">
	<label class="laborder"><liferay-ui:message key="pccc-XL-quatrinhluanchuyencongvanden"/></label>
	<div class="Scrollbarauto">
		<table class="taglib-search-iterator table-pml" cellspacing="0" width="100%">	
							<tr class="portlet-section-header results-header" >
								<td width="35px" align="center"><liferay-ui:message key="pccc-TN-stt"/></td>
								<td width="20%"><liferay-ui:message key="pccc-XL-donvicanhangui"/></td>
								<td width="10%" align="center"><liferay-ui:message key="pccc-XL-ngaygui"/></td>
								<td width="35%"><liferay-ui:message key="pccc-XL-yeucauxuly"/></td>
								<td width="20%"><liferay-ui:message key="pccc-XL-donvicanhannhan"/></td>
								<td align="center"><liferay-ui:message key="pccc-DSHS-ngaynhan"/></td>						
							</tr>
							<%
							for (int k = 0; k < (pmlDocumentReceiptLogList.isEmpty() ? 0 : pmlDocumentReceiptLogList.size()); k++) {
								PmlDocumentReceiptLog pmlDocumentReceiptLog = pmlDocumentReceiptLogList.get(k);
								PmlUser nguoiGui = null;
								String processerName = "";
								if (pmlDocumentReceiptLog.getProcesser() != 0) {
									try {
										nguoiGui = PmlUserUtil.findByPrimaryKey(pmlDocumentReceiptLog.getProcesser());
										processerName = nguoiGui.getLastName() + " " + nguoiGui.getMiddleName() + " " + nguoiGui.getFirstName();
									}
									catch (Exception ex) {
										System.out.println("Khong lay duoc nguoi dung co ma so:" + String.valueOf(
												pmlDocumentReceiptLog.getProcesser()));
									}
								}
								
								PmlUser nguoiNhan = null;
								String tenNguoiNhan = "";
								if (pmlDocumentReceiptLog.getReceiver() != 0) {
									try {
										nguoiNhan = PmlUserUtil.findByPrimaryKey(pmlDocumentReceiptLog.getReceiver());
										tenNguoiNhan = nguoiNhan.getLastName() + " " + nguoiNhan.getMiddleName() + " " + nguoiNhan.getFirstName();
									}
									catch (Exception ex) {
										System.out.println("Khong lay duoc nguoi dung co ma so:" + String.valueOf(
												pmlDocumentReceiptLog.getReceiver()));
									}
								}
								
								String ngayGui = "";
								String ngayNhan = "";
								if (pmlDocumentReceiptLog.getDateProcess() != null && pmlDocumentReceiptLog.getDateProcessTime() == null) {
									ngayGui = sd.format(pmlDocumentReceiptLog.getDateProcess());
							 	} 
								if (pmlDocumentReceiptLog.getDateProcessTime() != null) { 
									ngayGui = sdf.format(pmlDocumentReceiptLog.getDateProcessTime());
							 	} 
								if (pmlDocumentReceiptLog.getReceiveDate() != null && pmlDocumentReceiptLog.getReceiveDateTime() == null) {
							 		ngayNhan = sd.format(pmlDocumentReceiptLog.getReceiveDate());
							 	} 
								if (pmlDocumentReceiptLog.getReceiveDateTime() != null) {
							 		ngayNhan = sdf.format(pmlDocumentReceiptLog.getReceiveDateTime());
							 	}
							%>
								<tr class="<%= (k % 2) == 0 ? "results-row" : "tr_two results-row" %>">
									<td align="center"><%= k + 1 %>.</td>
									<td><%= processerName %></td>
									<td align="center"><%= ngayGui %></td>
									<td><%= pmlDocumentReceiptLog.getProcessInfomation() %></td>
									<td><%= tenNguoiNhan %></td>
									<td align="center"><%= ngayNhan %></td>
								</tr>
							<%
							}
							%>
						</table>
		</div>
</fieldset>
<br>
<div>
		<input type="button" value="<liferay-ui:message key='close' />" onclick="window.close();">
</div>
</div>
</form>
