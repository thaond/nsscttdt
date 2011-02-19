<%@ include file="/html/portlet/ext/pcccdocumentreceiptprocess/js/changeselectboxvalue.jsp" %>
<%@page import="javax.portlet.RenderRequest"%>
<%@page import="com.sgs.portlet.document.send.model.PmlEdmDocumentSend"%>
<%@page import="com.sgs.portlet.document.send.service.persistence.PmlEdmDocumentSendUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portlet.PortletURLImpl"%>
<%@page import="javax.portlet.PortletRequest"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.sgs.portlet.document.service.persistence.PmlStateProcessUtil"%>
<%@page import="com.sgs.portlet.document.model.PmlDocumentReceiptLog"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.Comparator"%>
<%@page import="com.sgs.portlet.document.receipt.model.PmlFileStatusStateProcess"%>
<%@page import="com.sgs.portlet.document.receipt.service.persistence.PmlFileStatusStateProcessUtil"%>
<%@page import="com.sgs.portlet.document.receipt.service.PmlEdmDocumentReceiptLocalServiceUtil"%>
<%@page import="com.sgs.portlet.document.workflow.DocumentReceiptPortletAction"%>
<%@page import="com.sgs.portlet.document.receipt.dto.PmlEdmDocumentReceiptDTO"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt"%>
<%@page import="com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentReceiptUtil"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.ext.portlet.processtype.model.ProcessType"%>
<%@page import="com.ext.portlet.processtype.service.persistence.ProcessTypeUtil"%>
<%@page import="com.liferay.portal.service.persistence.UserUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.sgs.portlet.pmllevelsend.service.persistence.PmlEdmLevelSendUtil"%>
<%@page import="com.sgs.portlet.pmlissuingplace.service.persistence.PmlEdmIssuingPlaceUtil"%>
<%@page import="com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentTypeUtil"%>
<%@page import="com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentRecordTypeUtil"%>
<%@page import="com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType"%>
<%@page import="com.sgs.portlet.document.receipt.service.persistence.PmlEdmConfidentialLevelUtil"%>
<%@page import="com.sgs.portlet.document.receipt.service.persistence.PmlEdmPrivilegeLevelUtil"%>
<%@page import="com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV"%>
<%@page import="com.sgs.portlet.pml_ho_so_cong_viec.service.persistence.PmlChiTietHSCVUtil"%>
<%@page import="com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec"%>
<%@page import="com.sgs.portlet.pml_ho_so_cong_viec.service.persistence.PmlHoSoCongViecUtil"%>
<%@page import="com.ext.portlet.saveprocesstype.model.SaveProcessType"%>
<%@page import="com.ext.portlet.saveprocesstype.service.persistence.SaveProcessTypeUtil"%>
<%@page import="com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile"%>
<%@page import="com.sgs.portlet.document.receipt.service.persistence.PmlEdmAttachedFileUtil"%>
<%@page import="com.sgs.portlet.document.receipt.model.impl.PmlEdmDocumentReceiptImpl"%>
<%@page import="com.sgs.portlet.document.service.persistence.PmlDocumentReceiptLogUtil"%>
<%@page import="com.liferay.portal.NoSuchUserException"%>

<%@page import="com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptExtend"%>
<%@page import="com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentReceiptExtendUtil"%>
<%@page import="com.sgs.portlet.pmluser.model.PmlUser"%>
<%@page import="com.sgs.portlet.pmluser.service.persistence.PmlUserUtil"%>
<%@page import="com.sgs.portlet.department.service.persistence.DepartmentUtil"%>

<%@page import="com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptProcessType"%>
<%@page import="com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentReceiptProcessTypeUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="com.ext.portlet.processtype.service.ProcessTypeLocalServiceUtil"%>

<%@page import="com.sgs.portlet.document.model.PmlEdmDocumentRelation"%>
<%@page import="com.sgs.portlet.document.service.persistence.PmlEdmDocumentRelationUtil"%>

<liferay-util:include page="/html/portlet/ext/onedoorpccc/js/pccc-onedoorreceipt.jsp"></liferay-util:include>
<link type="text/css" rel="stylesheet"	href="/html/css/calendar-system.css" />
<link type="text/css" rel="stylesheet" href="/html/portlet/ext/pcccdocumentreceiptprocess/css/letter.css" />

<script type="text/javascript" src="/html/js/calendar.js"></script>
<script type="text/javascript" src="/html/js/calendar-setup.js"></script>
<script type="text/javascript" src="/html/js/calendar-en.js"></script>
<script type='text/javascript' src='/html/js/liferay/tr.js'></script>

<%
	long docRecId = ParamUtil.getLong(renderRequest, "docRecId");
	String redirect = ParamUtil.getString(renderRequest, "redirect");
	PmlEdmDocumentReceipt docRecItem = null;
	try {
		docRecItem = PmlEdmDocumentReceiptUtil.findByPrimaryKey(docRecId);
	}
	catch (Exception ex) {
		// Khong doc duoc van ban
		System.out.println("Khong doc duoc van ban den: " + docRecId);
		return;
	}
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy -HH:mm");
	SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
%>

<form method="post">
<div class="title_categ"><liferay-ui:message key="pccc-TN-thongtinchitiet"/></div>
<div class="boxcontent">

<fieldset class="filnoborder_div">
<table cellspacing="0" width="100%" class="bor_rgh">
			<tr>
				<td class="td-left" width="20%"><liferay-ui:message key="pccc-cvdtn-capgoi"/>&nbsp;:</td>
				<td class="td-right" width="30%">
					<%
			    	String levelSendName = "";
			    	try {
			    		levelSendName = PmlEdmLevelSendUtil.findByPrimaryKey(docRecItem.getLevelSendId()).getLevelSendName();
			    	}
			    	catch (Exception ex) {
			    		// Do nothing
			    	}
			    	out.println(levelSendName);
			    	%>
	    		</td>
	    		<td class="td-left" width="20%"><liferay-ui:message key="pccc-cvdtn-noiphathanh"/>&nbsp;:</td>
				<td class="td-right">
					<%
			    	String issPlaceName = "";
			    	if (docRecItem.getIssuingPlaceId().length() > 0) {
			    		try {
			    			issPlaceName = PmlEdmIssuingPlaceUtil.findByPrimaryKey(docRecItem.getIssuingPlaceId()).getIssuingPlaceName();
			    		}
			    		catch (Exception ex) {
			    			// Do nothing
			    		}
			    	} // end if
			    	else {
			    		issPlaceName = docRecItem.getIssuingPlaceOtherName();
			    	}
			    	out.println(issPlaceName);
			    	%>
	    		</td>
			</tr>
			<tr>
				<td class="td-left"><liferay-ui:message key="pccc-cvdtn-sohieu"/>&nbsp;:</td>
				<td class="td-right">
					<%= docRecItem.getDocumentReference() %>
	    		</td>
	    		<td class="td-left"><liferay-ui:message key="pccc-cvdtn-soCVden"/>&nbsp;:</td>
				<td class="td-right">
					<%= docRecItem.getNumberDocumentReceipt() %>
	    		</td>
			</tr>
			
			<tr>
				<td class="td-left"><liferay-ui:message key="pccc-cvdtn-loaicongvan"/>&nbsp;:</td>
				<td class="td-right">
					<%
			    	String docTypeName = "";
					String docRecTypeName = "";
			    	try {
			    		docTypeName = PmlEdmDocumentTypeUtil.findByPrimaryKey(docRecItem.getDocumentTypeId()).getDocumentTypeName();
			    		PmlEdmDocumentRecordType docRecTypeItem = PmlEdmDocumentRecordTypeUtil.findByPrimaryKey((int)
			    				PmlEdmDocumentTypeUtil.findByPrimaryKey(docRecItem.getDocumentTypeId()).getPrimaryKey());
			    		docRecTypeName = docRecTypeItem.getDocumentRecordTypeName();
			    	}
			    	catch (Exception ex) {
			    		// Do nothing
			    	}
			    	out.println(docTypeName);
					%>
	    		</td>
	    		<td class="td-left"><liferay-ui:message key="pccc-cvdtn-socongvan"/>&nbsp;:</td>
				<td class="td-right">
					<%= docRecTypeName %>
	    		</td>
			</tr>
			<tr>
				<td class="td-left"><liferay-ui:message key="pccc-cvdtn-nguoiky"/>&nbsp;:</td>
				<td class="td-right">
					<%= docRecItem.getSigner() %>
	    		</td>
	    		<td class="td-left"><liferay-ui:message key="cach-thuc-xu-ly"/>&nbsp;:</td>
				<td class="td-right">
					<%
						List<SaveProcessType> savePTs = SaveProcessTypeUtil.findByDocId(docRecId);
						boolean hasProType = false; // Co cach thuc xu ly chon tu danh muc
						if (!savePTs.isEmpty()) {
							try {
								for (int idx = 0; idx < savePTs.size(); idx ++) {
									SaveProcessType savePTItem = (SaveProcessType) savePTs.get(idx);
									ProcessType pTItem = ProcessTypeUtil.findByPrimaryKey(savePTItem.getFlagProcessType());
									hasProType = true;
						%>
										<div style="padding: 3px 0;color: #00baef">-&nbsp;<%= pTItem.getName() %></div>
						<%
								}
							}
							catch (Exception ex) {
								// Do nothing
							}
						}
						// Doc thong tin cach thuc xu ly cua van ban neu khong xac dinh duoc cach thuc xu ly tu danh muc
						if (hasProType == false) {
							String proTypeDesc = ""; // Dien giai cach thuc xu ly
							if (docRecItem.getDocumentType().equals("1")) { // Luu
								proTypeDesc = "L\u01b0u.";
							} 
							else if (docRecItem.getDocumentType().equals("2")) {
								proTypeDesc = "B\u00e1o c\u00e1o.";
							} 
							else if (docRecItem.getDocumentType().equals("3")) {
								proTypeDesc = "So\u1EA1n v\u0103n b\u1ea3n tr\u1EA3 l\u1EDDi.";
							}
							out.println(proTypeDesc);
						}
						%>
				</td>
			</tr>
			<tr>
				<td class="td-left"><liferay-ui:message key="pccc-cvdtn-ngayphathanh"/>&nbsp;:</td>
				<td class="td-right">
					<%= docRecItem.getIssuingDate() != null ? format.format(docRecItem.getIssuingDate()) : "" %>
	    		</td>
	    		<td class="td-left"><liferay-ui:message key="pccc-cvdtn-ngayden"/>&nbsp;:</td>
				<td class="td-right">
					<%= docRecItem.getDateArrive() != null ? format.format(docRecItem.getDateArrive()) : "" %>
					<liferay-ui:message key='hour' />:&nbsp;<%= docRecItem.getThoigiannhancvden() %>
	    		</td>
			</tr>
			<tr>
				<td class="td-left"><liferay-ui:message key="pccc-cvdtn-domat"/>&nbsp;:</td>
				<td class="td-right">
					<%
					String confLevName = "";
					try {
						confLevName = PmlEdmConfidentialLevelUtil.findByPrimaryKey(docRecItem.getConfidentialLevelId()).getConfidentialLevelName();
					}
					catch (Exception ex) {
						// Do nothing
					}
					out.println(confLevName);
					%>
	    		</td>
				<td class="td-left"><liferay-ui:message key="pccc-cvdtn-dokhan"/>&nbsp;:</td>
				<td class="td-right">
					<%
					String privLevName = "";
					try {
						privLevName = PmlEdmPrivilegeLevelUtil.findByPrimaryKey(docRecItem.getPrivilegeLevelId()).getPrivilegeLevelName();
					}
					catch (Exception ex) {
						// Do nothing
					}
					out.println(privLevName);
					%>
	    		</td>
			</tr>
			<tr>
				<td class="td-left"><liferay-ui:message key="pccc-cvdtn-socongvandiphucdap"/>&nbsp;:</td>
				<td class="td-right">
					<%= docRecItem.getSocongvandiphucdap() %>
	    		</td>
	    		<td class="td-left"><liferay-ui:message key="pccc-cvdtn-toanvan"/>&nbsp;:</td>
				<td class="td-right">
					<%
				    	List<PmlEdmAttachedFile> attFiles = PmlEdmAttachedFileUtil.findByObjectContentId_ObjectType(
				    			docRecId, new PmlEdmDocumentReceiptImpl().getClass().getName());
				    	if (!attFiles.isEmpty()) {
				    		for (int idx = 0; idx < attFiles.size(); idx ++) {
				    			PmlEdmAttachedFile attFileItem = (PmlEdmAttachedFile) attFiles.get(idx);
				    	%>
							    	<a href="<%= attFileItem.getPath() %>"><%= attFileItem.getTitle().length() > 0 ? attFileItem.getTitle() : attFileItem.getAttachedFileName().substring(com.ext.portlet.util.Constants.NUMBER_REFIX_ATTACHEDFILE) %></a><br>
				    	<%
				    		}
				    	}
						%>
				</td>
			</tr>
			<tr>
				<td class="td-left"><liferay-ui:message key="pccc-cvdtn-hosocongviec"/>&nbsp;:</td>
				<td class="td-right" colspan="3">
					<div class="cvd-filedinhkem" style="width: 99%; background-color: white;">
				        <%
				        List<PmlChiTietHSCV> cTHSCVs = PmlChiTietHSCVUtil.findByIdCongVanDen(docRecId);
				        if (!cTHSCVs.isEmpty()) {
				        	try {
				        		for (int idx = 0; idx < cTHSCVs.size(); idx ++) {
				        			PmlChiTietHSCV cTHSCVItem = (PmlChiTietHSCV) cTHSCVs.get(idx);
				        			PmlHoSoCongViec hSCVItem = PmlHoSoCongViecUtil.findByPrimaryKey(cTHSCVItem.getIdHoSoCongViec());
				        %>
				        				<div style="padding: 3px 0;color: #00baef">-&nbsp;<%= hSCVItem.getTieuDe() %></div>
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
			</tr>
			<tr valign="top">
				<td class="td-left"><liferay-ui:message key="pccc-cvdtn-trichyeu"/>&nbsp;:</td>
				<td class="td-right" colspan="3">
					<textarea class="textarea-display" readonly="" rows="3" style="width: 98%;"><%= docRecItem.getBriefContent() %></textarea>
			    </td>
			</tr>
	</table>
	<br>
	<fieldset class="filborder">
		<legend class="laborder"><liferay-ui:message key="pccc-XL-quatrinhluanchuyencongvanden"/></legend>
		<div class="Scrollbarauto">
		<table class="taglib-search-iterator table-pml" cellspacing="0" width="100%">	
					<tr class="portlet-section-header results-header" >
							<td width="35px" align="center"><liferay-ui:message key="pccc-TN-stt"/></td>
							<td width="20%"><liferay-ui:message key="pccc-XL-donvicanhangui"/></td>
							<td align="center"><liferay-ui:message key="pccc-XL-ngaygui"/></td>
							<td width="40%"><liferay-ui:message key="pccc-XL-yeucauxuly"/></td>
							<td width="20%"><liferay-ui:message key="pccc-XL-donvicanhannhan"/></td>
							<td align="center"><liferay-ui:message key="pccc-DSHS-ngaynhan"/></td>						
						</tr>
						<%
						List<PmlDocumentReceiptLog> docRecLogs = PmlDocumentReceiptLogUtil.findByDocumentReceiptId(docRecId);
						// Sap xep thu tu luan chuyen van ban tang dan theo thoi gian
						if (!docRecLogs.isEmpty()) {
							Collections.sort(docRecLogs, new Comparator<PmlDocumentReceiptLog>() {
								public int compare(PmlDocumentReceiptLog obj1, PmlDocumentReceiptLog obj2) {   
									if (obj1.getTransition_() < obj2.getTransition_()) return -1;
									if (obj1.getTransition_() == obj2.getTransition_()) return 0;
									return 1;
								}                                        
							});
						} // end if
						
						// Xuat chi tiet luan chuyen
						if (!docRecLogs.isEmpty()) {
							for (int idx = 0; idx < docRecLogs.size(); idx ++) {
								PmlDocumentReceiptLog docRecLogItem = (PmlDocumentReceiptLog) docRecLogs.get(idx);
								User nguoiGui = null;
								String processerName = "";
								if (docRecLogItem.getProcesser() != 0) {
									try {
										nguoiGui = UserUtil.findByPrimaryKey(docRecLogItem.getProcesser());
										processerName = nguoiGui.getLastName() + " " + nguoiGui.getMiddleName() + " " + nguoiGui.getFirstName();
									}
									catch (Exception ex) {
										if (ex instanceof NoSuchUserException) {
											processerName = String.valueOf(docRecLogItem.getProcesser());
										}
									}
								}
								
								User nguoiNhan = null;
								String tenNguoiNhan = "";
								if (docRecLogItem.getReceiver() != 0) {
									try {
										nguoiNhan = UserUtil.findByPrimaryKey(docRecLogItem.getReceiver());
										tenNguoiNhan = nguoiNhan.getLastName() + " " + nguoiNhan.getMiddleName() + " " + nguoiNhan.getFirstName();
									}
									catch (Exception ex) {
										if (ex instanceof NoSuchUserException) {
											tenNguoiNhan = String.valueOf(docRecLogItem.getReceiver());
										}
									}
								}
						%>
								<tr class="<%= (idx % 2) == 0 ? "results-row" : "tr_two results-row" %>" onmouseover="onMouseOverTr(this);" onmouseout="onMouseOutTr(this);">
									<td align="center"><%= idx + 1 %>.</td>
									<td ><%= processerName %></td>
									<td align="center"><%= docRecLogItem.getDateProcess() != null ? format.format(docRecLogItem.getDateProcess()) : "" %></td>
									<td ><%= docRecLogItem.getProcessInfomation() %></td>
									<td ><%= tenNguoiNhan %></td>
									<td align="center"><%= docRecLogItem.getReceiveDate() != null ? format.format(docRecLogItem.getReceiveDate()) : "" %></td>
								</tr>
						<%
							} // end for
						} // end if
						%>	
					</table>
				</div>
		</fieldset>
</fieldset>
<br>
<!-- phmphuc updat 18/11/2010
hien thi chi tiet phan gia han thoi gian xu ly vb -->
<%
List<PmlEdmDocumentReceiptExtend> dREs = PmlEdmDocumentReceiptExtendUtil.findByDocumentReceiptId(docRecId);
if (!dREs.isEmpty()) {
%>
<fieldset class="filborder">
		<legend class="laborder"><liferay-ui:message key="information-extend-process-document-receipt"/></legend>
		<div class="Scrollbarauto">
		<table class="taglib-search-iterator table-pml" cellspacing="0" width="100%">	
					<tr class="portlet-section-header results-header" >
								<td width="35px" rowspan="2" align="center"><liferay-ui:message key="STT"/></td>
								<td width="10%" rowspan="2" align="center"><liferay-ui:message key="date-start-process"/></td>
								<td width="18%" colspan="2" align="center"><liferay-ui:message key="before-extend"/></td>
								<td width="18%" colspan="2" align="center"><liferay-ui:message key="after-extend"/></td>
								<td rowspan="2"><liferay-ui:message key="reason-extend"/></td>
								<td width="10%" rowspan="2"><liferay-ui:message key="person-extend"/></td>						
								<td width="15%" rowspan="2"><liferay-ui:message key="department-extend"/></td>						
							</tr>
							<tr class="portlet-section-header results-header">
								<td width="8%" align="center"><liferay-ui:message key="number-day-process"/></td>
								<td width="10%" align="center"> <liferay-ui:message key="limit-date"/></td>
								<td width="8%" align="center"><liferay-ui:message key="number-day-process"/></td>
								<td width="10%" align="center"><liferay-ui:message key="limit-date"/></td>
							</tr>
							<%
							for (int k = 0; k < dREs.size(); k++) {
								PmlEdmDocumentReceiptExtend dREItem = dREs.get(k);
								String personExtendName = ""; // Ten nguoi gia han
								String depExtendName = "";
								try {
									PmlUser tmpUser = PmlUserUtil.findByPrimaryKey(dREItem.getExtendUserId());
									personExtendName = tmpUser.getLastName() + " " + tmpUser.getMiddleName() + " " + tmpUser.getFirstName();
								}
								catch (Exception ex) {}
								try {
									depExtendName = DepartmentUtil.findByPrimaryKey(dREItem.getExtendDepartmentId()).getDepartmentsName();
								}
								catch (Exception ex) {}
							%>
								<tr class="<%= (k % 2) == 0 ? "results-row" : "tr_two results-row" %>">
									<td align="center"><%= k + 1 %>.</td>
									<td align="center">
										<%= (dREItem.getStartProcessDate() != null) ? format.format(dREItem.getStartProcessDate()) : "" %>
									</td>
									<td align="center"><%= dREItem.getNumDayProcessBef() %></td>
									<td align="center">
										<%= (dREItem.getLimitDateBef() != null) ? format.format(dREItem.getLimitDateBef()) : "" %>
									</td>
									<td align="center"><%= dREItem.getNumDayProcessAft() %></td>
									<td align="center">
										<%= (dREItem.getLimitDateAft() != null) ? format.format(dREItem.getLimitDateAft()) : "" %>
									</td>
									<td><%= dREItem.getExtendReason() %></td>
									<td><%= personExtendName %></td>
									<td><%= depExtendName %></td>
								</tr>
							<%
							}
							%>
						</table>
					</div>
</fieldset>
<%	
}
%>
<!-- end hien thi chi tiet phan gia han thoi gian xu ly -->

<!-- phmphuc add 19/11/2010
Doc ds thay doi cach thuc xu ly -->
<% 
	List<PmlEdmDocumentReceiptProcessType> docProcessTypeList = new ArrayList<PmlEdmDocumentReceiptProcessType>();
	try {
		docProcessTypeList = PmlEdmDocumentReceiptProcessTypeUtil.findByDocumentReceiptId(docRecId);
	} catch (Exception e) {
		docProcessTypeList = new ArrayList<PmlEdmDocumentReceiptProcessType>();
	}
	
	if (!docProcessTypeList.isEmpty()) {
%>
<br>
<fieldset class="filborder">
		<legend class="laborder"><liferay-ui:message key="pccc-XL-thongtinthaydoicachthucxuly"/></legend>
		<div class="Scrollbarauto">
		<table class="taglib-search-iterator table-pml" cellspacing="0" width="100%">	
					<tr class="portlet-section-header results-header" >
							<td width="35px" align="center"><liferay-ui:message key="pccc-TN-stt"/></td>
							<td width="15%"><liferay-ui:message key="person-processtype"/></td>
							<td width="15%" align="center"><liferay-ui:message key="date-start-processtype"/></td>
							<td width="20%"><liferay-ui:message key="processtype-before"/></td>
							<td width="37%"><liferay-ui:message key="reason-processtype"/></td>
							<td><liferay-ui:message key="processtype-after"/></td>
						</tr>
						<%
							PmlUser nguoiSua = null;
							String tenNguoiSua = "";
							String ngaySua = "";
							ProcessType processType = null;
							
							for (int k = 0 ; k < docProcessTypeList.size(); k++) {
								PmlEdmDocumentReceiptProcessType docProcessType = docProcessTypeList.get(k);
								nguoiSua = PmlUserUtil.findByPrimaryKey(docProcessType.getProcesserId());
								tenNguoiSua = nguoiSua.getLastName() + " " + nguoiSua.getMiddleName() + " " + nguoiSua.getFirstName();
								
								if (docProcessType.getDateEdit() != null) { 
									ngaySua = sdf.format(docProcessType.getDateEdit());
							 	}
								
								String[] processTypeIdBefore = StringUtil.split(docProcessType.getProcessTypeIdBefore(), ",");
								String[] processTypeIdAfter = StringUtil.split(docProcessType.getProcessTypeIdAfter(), ",");
								String processTypeBefore = "";
								String processTypeAfter = "";
								for (int i = 0; i < processTypeIdBefore.length; i++) {
									try {
										processType = ProcessTypeLocalServiceUtil.getProcessType(Long.parseLong(processTypeIdBefore[i]));
										processTypeBefore += processType.getName();
										if (i < processTypeIdBefore.length -1) {
											processTypeBefore += ", ";
										}
									} catch (Exception e) {
										processTypeBefore += "";
									}
								}
								
								for (int i = 0; i < processTypeIdAfter.length; i++) {
									try {
										processType = ProcessTypeLocalServiceUtil.getProcessType(Long.parseLong(processTypeIdAfter[i]));
										processTypeAfter += processType.getName();
										if (i < processTypeIdAfter.length -1) {
											processTypeAfter += ", ";
										}
									} catch (Exception e) {
										processTypeAfter += "";
									}
								}
						%>
								<tr class="<%=(k % 2) == 0 ? "results-row" : "tr_two results-row" %>">
									<td align="center"><%=k+1 %>.</td>
									<td align="center"><%= tenNguoiSua%></td>
									<td align="center"><%= ngaySua %></td>
									<td><%= processTypeBefore %></td>
									<td><%= docProcessType.getProcessTypeReason() %></td>
									<td><%= processTypeAfter %></td>
								</tr>
						<%
							}
						%>
					</table>
		</div>
	</fieldset>
<% } %>
<!-- end update ds thay doi cach thuc xu ly 19/11/2010-->

<!-- phmphuc add lien ket vb 22/11/2010 -->
<%
// Lay danh sach ma so van ban den va di lien quan den van ban hien tai
List<Long> docRecIdsRelation = new ArrayList<Long>(); // Danh sach ma so van ban den lien quan
List<Long> docSendIdsRelation = new ArrayList<Long>(); // Danh sach ma so van ban di lien quan

// Lay danh sach van ban lien quan A relation B co A la van ban dang xet
List<PmlEdmDocumentRelation> docRelations = PmlEdmDocumentRelationUtil.findByDocLeftId_LeftIsReceipt(docRecId, true);
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
docRelations = PmlEdmDocumentRelationUtil.findByDocRightId_RightIsReceipt(docRecId, true);
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
		<table class="taglib-search-iterator table-pml" cellspacing="0" width="100%">	
				
				<%
				if (!docRecIdsRelation.isEmpty()) {
				%>
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
				}
			%>
			</table>
			<div class="separator"><!-- --></div>
			<table class="taglib-search-iterator table-pml" cellspacing="0" width="100%">
				<%
				if (!docSendIdsRelation.isEmpty()) {
				%>
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
							tmpDocSend = PmlEdmDocumentSendUtil.findByPrimaryKey(docSendIdsRelation.get(idxDS));
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
				}
				%>
			</table>
		</div>
</fieldset>
</c:if>
<!-- end phmphuc update lien ket van ban 22/11/2010 -->

<div align="right" id="table-button">
		<%---
		<span onclick="javascript:submitForm(document.hrefFm,'<%= redirect %>');" >
			<input class="button-width" type="button" value='<liferay-ui:message key="back" />'>
		</span>
		---%>
		<span onclick="javascript: history.go(-1);" >
			<input class="button-width" type="button" value='<liferay-ui:message key="back" />'>
		</span>
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
</script>