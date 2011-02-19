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

<%@page import="com.liferay.portal.NoSuchUserException"%>
<%@page import="com.sgs.portlet.document.workflow.DocumentReceiptPortletAction"%>
<%@page import="com.sgs.portlet.document.receipt.dto.PmlEdmDocumentReceiptDTO"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt"%>
<%@page import="com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentReceiptUtil"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.liferay.portal.service.persistence.UserUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.sgs.portlet.document.receipt.service.PmlEdmDocumentReceiptLocalServiceUtil"%>
<%@page import="com.sgs.portlet.document.service.persistence.PmlDocumentReceiptLogUtil"%>

<%@page import="com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptExtend"%>
<%@page import="com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentReceiptExtendUtil"%>

<%@page import="com.sgs.portlet.pmluser.model.PmlUser"%>
<%@page import="com.sgs.portlet.pmluser.service.persistence.PmlUserUtil"%>
<%@page import="com.sgs.portlet.department.service.persistence.DepartmentUtil"%>

<%@page import="com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptProcessType"%>
<%@page import="com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentReceiptProcessTypeUtil"%>
<%@page import="com.ext.portlet.processtype.model.ProcessType"%>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="com.ext.portlet.processtype.service.ProcessTypeLocalServiceUtil"%>

<%@page import="com.sgs.portlet.document.model.PmlEdmDocumentRelation"%>
<%@page import="com.sgs.portlet.document.service.persistence.PmlEdmDocumentRelationUtil"%>


<%@page import="com.sgs.portlet.pmlissuingplace.service.persistence.PmlEdmIssuingPlaceUtil"%><link type="text/css" rel="stylesheet" href="/html/portlet/ext/pcccdocumentreceiptprocess/css/letter.css" />
<script type="text/javascript" src="/html/js/calendar.js"></script>
<script type="text/javascript" src="/html/js/calendar-setup.js"></script>
<script type="text/javascript" src="/html/js/calendar-en.js"></script>

<link type="text/css" rel="stylesheet"	href="/html/css/calendar-system.css" />

<%
	PmlEdmDocumentReceiptDTO documentDTO = 
		(PmlEdmDocumentReceiptDTO)renderRequest.getAttribute("documentDTO");
		
	long documentReceiptId = documentDTO.getDocumentReceiptId();
	//long documentReceiptId = ParamUtil.getLong(request, "documentReceiptId");
	
	int currentPage = Integer.parseInt(request.getAttribute("currentPage").toString());
	int currentLimit = Integer.parseInt(request.getAttribute("currentLimit").toString());
	String documentRecordTypeId = (String) renderRequest.getAttribute("documentRecordTypeId");
	long idHoSoCongViec = ParamUtil.getLong(request, "idHoSoCongViec");
	
	String daysProcessDeparmentMain = (String) renderRequest.getAttribute("daysProcessDeparmentMain");
	String expireDateProcess = (String) renderRequest.getAttribute("expireDateProcess");
	String mainProcessName = (String) renderRequest.getAttribute("mainProcessName");
	String mainDepartmentName = (String) renderRequest.getAttribute("mainDepartmentName");
	String processInformation = (String) renderRequest.getAttribute("processInformation");
	String hienTrang = ParamUtil.getString(renderRequest, "hienTrang", "dangXuLy");
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy -HH:mm");
	SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
%>
<form method="post" >
<div class="title_categ"><liferay-ui:message key="pccc-TN-thongtinchitiet"/></div>
<div class="boxcontent">
<fieldset class="filborder">
<legend class="laborder"><liferay-ui:message key="pccc-Chitiethoso"/></legend>
<table width="100%" cellspacing="0">
	<tr>	  
	    <td class="td-left"  width="20%"><label><liferay-ui:message key="pccc-cvdtn-capgoi"/>: </label></td>
	    <td class="td-right" width="30%"><%=documentDTO.getLevelSendName() != null ? documentDTO.getLevelSendName() : "" %></td>
	    <td class="td-left" width="20%"><label><liferay-ui:message key="pccc-cvdtn-noiphathanh"/>: </label></td>
	    <td class="td-right"><%=documentDTO.getIssuingPlaceName() != null ? documentDTO.getIssuingPlaceName() : "" %></td>
	</tr>
	<tr>
	    <td class="td-left"><label><liferay-ui:message key="pccc-cvdtn-sohieu"/>: </label></td>
		<td class="td-right"><%=documentDTO.getDocumentReference() != null ? documentDTO.getDocumentReference() : "" %></td>
	    <td class="td-left"><label><liferay-ui:message key="pccc-cvdtn-loaicongvan"/>:</label></td>
	    <td class="td-right" ><%=documentDTO.getDocumentTypeName() != null ? documentDTO.getDocumentTypeName() : "" %></td>
	</tr>
	<tr>
		<td class="td-left"><label><liferay-ui:message key="pccc-cvdtn-socongvan"/>: </label></td>
		<td class="td-right"><%=documentRecordTypeId != null ? documentRecordTypeId  : "" %></td>
		<td class="td-left"><label><liferay-ui:message key="pccc-cvdtn-soCVden"/>: </label></td>
		<td class="td-right"><%=documentDTO.getNumberDocumentReceipt() != null ? documentDTO.getNumberDocumentReceipt() : "" %></td>
	</tr>
	<tr>
		<td class="td-left"><label><liferay-ui:message key="pccc-cvdtn-nguoiky"/>:</label></td>
		<td class="td-right"><%=documentDTO.getSigner() != null ? documentDTO.getSigner() : "" %></td>
		<td class="td-left"><label><liferay-ui:message key="pccc-cvdtn-ngayden"/>:</label></td>
		<td class="td-right"><%=documentDTO.getDateArrive() != null ? new java.text.SimpleDateFormat("dd/MM/yyyy").format(documentDTO.getDateArrive()) : "" %>
		<liferay-ui:message key='hour' />:<%=documentDTO.getThoigiannhancvden() != null ? documentDTO.getThoigiannhancvden() : "" %>
		</td>
	</tr>
	<tr>
		<td class="td-left" ><label><liferay-ui:message key="pccc-cvdtn-ngayphathanh"/>:</label></td>
		<td class="td-right"><%=documentDTO.getIsuuingDate() != null ? new java.text.SimpleDateFormat("dd/MM/yyyy").format(documentDTO.getIsuuingDate()) : "" %></td>
		<td class="td-left"><label><liferay-ui:message key="pccc-cvdtn-domat"/>:</label></td>
		<td class="td-right"><%=documentDTO.getConfidentialLevelName() != null ? documentDTO.getConfidentialLevelName() : "" %></td>
	</tr>
	<tr>
		<td class="td-left"><label><liferay-ui:message key="pccc-cvdtn-dokhan"/>:</label></td>
		<td class="td-right"><%=documentDTO.getPrivilegeLevel() %></td>
		<td class="td-left" ><label><liferay-ui:message key="pccc-cvdtn-socongvandiphucdap"/>: </label></td>
	    <td class="td-right">
	    	<%
	    		if (! "".equals(documentDTO.getSocongvandiphucdap()) && documentDTO.getSocongvandiphucdap() != null ) {
	    			List<PmlEdmDocumentSend> pmlEdmDocumentSendList = new ArrayList<PmlEdmDocumentSend>();
	    			try {
	    				pmlEdmDocumentSendList = PmlEdmDocumentSendUtil.findByDocumentReference(documentDTO.getSocongvandiphucdap());
	    			} catch (Exception e){}
	    			
	    			if (pmlEdmDocumentSendList.size() > 0) {
	    			
	    				PortletURL detail_DocumentSend = new PortletURLImpl(request, "SGS_PCCCDOCUMENTSENDPROCESS", 33011, PortletRequest.RENDER_PHASE);
	    				detail_DocumentSend.setParameter("struts_action", "/sgs/pml_ho_so_cong_viec/detail");
	    				detail_DocumentSend.setParameter("documentSendId", String.valueOf(pmlEdmDocumentSendList.get(0).getDocumentSendId()));
	    				detail_DocumentSend.setParameter(com.sgs.liferay.jbpm.util.Constants.WORKFLOW_RENDER, "false");
	    	%>
	    			<a href="<%= detail_DocumentSend %>"><%= documentDTO.getSocongvandiphucdap()%></a>
	    	<%		}
	    		}
	    	%>
	    </td>
	</tr>
	<tr>
		<td class="td-left" valign="top"><label><liferay-ui:message key="pccc-cvdtn-hosocongviec"/>:</label></td>
		 <td class="td-right">
			 <div class="cvd-filedinhkem" style="width: 99%;background-color: white;">
				 <logic:iterate id="pmlHoSoCongViec" name="pmlHoSoCongViecList" indexId="i" type="com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec"  >
						<div style="padding: 3px 0;color: #00baef"><span id="stt">- &nbsp;</span><%= pmlHoSoCongViec.getTieuDe() %></div>
		        </logic:iterate>
			 </div>	 
		 </td>
	    <td valign="top" class="td-left"><label><liferay-ui:message key="pccc-cvdtn-toanvan"/>:</label></td>
	    <td class="td-right">
	    	<logic:iterate id="attachedFile" name="attachedFiles" indexId="i" type="com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile" scope="request" >
	    	<a href="<%=attachedFile.getPath() %>"><%=!"".equals(attachedFile.getTitle()) ? attachedFile.getTitle() : attachedFile.getAttachedFileName() %><br /></a>
	    	</logic:iterate>
	    </td>
	</tr>
	<tr>
		<td class="td-left"><label><liferay-ui:message key="pccc-TN-tongsongayxuly"/>:</label></td>
		<td class="td-right">
		<% if (daysProcessDeparmentMain != null && !"0".equals(daysProcessDeparmentMain)){ %>
			<%=daysProcessDeparmentMain %> <liferay-ui:message key="ngay"/>
		<%} %>
		
		</td>
		<td class="td-left"><label><liferay-ui:message key="pccc-TN-ngayhethanxuly"/>:</label></td>
		<td class="td-right"><%=(expireDateProcess != null) ? expireDateProcess : "" %></td>
	</tr>
	<tr>
		<td class="td-left"><label><liferay-ui:message key="pccc-TN-phongbanthulychinh"/>:</label></td>
		<td class="td-right"><%=mainDepartmentName %></td>
		<td class="td-left"><label><liferay-ui:message key="pccc-TN-nguoithulychinh"/>:</label></td>
		<td class="td-right"><%=mainProcessName %></td>
	</tr>
	<tr>
		<td class="td-left"><label><liferay-ui:message key="pccc-TN-ykienphanphoi"/>:</label></td>
		<td class="td-right"><%=processInformation %></td>
		<!--<td class="td-left" width="15%"><label><liferay-ui:message key="pccc-TN-trangthaigannhat"/>:</label></td>
		
		<td class="td-right"><liferay-ui:message key="<!%=documentDTO.getState() %>"/></td>
		-->
	</tr>
	<tr>
		<td valign="top" class="td-left"><label><liferay-ui:message key="pccc-cvdtn-trichyeu"/>:</label></td>
		<td  colspan="3" class="td-right"><textarea  class="textarea-display" onMouseover="this.style.backgroundColor='white';" readonly="" rows="5" style="width: 98%"><%=documentDTO.getBriefContent() %></textarea></td>
	</tr>
</table>
</fieldset>

<fieldset class="filborder">
<label class="laborder"><liferay-ui:message key="pccc-XL-quatrinhluanchuyencongvanden"/></label>
<div class="Scrollbarauto">
	<table class="taglib-search-iterator table-pml" cellspacing="0" width="100%">	
		<tr class="portlet-section-header results-header" >
			<td width="35px"><div align="center"><liferay-ui:message key="pccc-TN-stt"/></div></td>
			<td width="20%"><div ><liferay-ui:message key="pccc-XL-donvicanhangui"/></div></td>
			<td ><div align="center"><liferay-ui:message key="pccc-XL-ngaygui"/></div></td>
			<td width="35%"><div ><liferay-ui:message key="pccc-XL-yeucauxuly"/></div></td>
			<td width="20%"><div ><liferay-ui:message key="pccc-XL-donvicanhannhan"/></div></td>
			<td ><div align="center"><liferay-ui:message key="pccc-DSHS-ngaynhan"/></div></td>						
		</tr>
		<logic:iterate id="pmlDocumentReceiptLog" name="pmlDocumentReceiptLogList" type="com.sgs.portlet.document.model.PmlDocumentReceiptLog" indexId="k">
			<tr class="<%=(k % 2) == 0 ? "results-row" : "tr_two results-row" %>">
			<%
				User nguoiGui = null;
				String processerName = "";
				if (pmlDocumentReceiptLog.getProcesser() != 0) {
					try {
						nguoiGui = UserUtil.findByPrimaryKey(pmlDocumentReceiptLog.getProcesser());
						processerName = nguoiGui.getLastName() + " " + nguoiGui.getMiddleName() + " " + nguoiGui.getFirstName();
					}
					catch (Exception ex) {
						if (ex instanceof NoSuchUserException) {
							processerName = String.valueOf(pmlDocumentReceiptLog.getProcesser());
						}
					}
				}
				
				User nguoiNhan = null;
				String tenNguoiNhan = "";
				if (pmlDocumentReceiptLog.getReceiver() != 0) {
					try {
						nguoiNhan = UserUtil.findByPrimaryKey(pmlDocumentReceiptLog.getReceiver());
						tenNguoiNhan = nguoiNhan.getLastName() + " " + nguoiNhan.getMiddleName() + " " + nguoiNhan.getFirstName();
					}
					catch (Exception ex) {
						if (ex instanceof NoSuchUserException) {
							tenNguoiNhan = String.valueOf(pmlDocumentReceiptLog.getReceiver());
						}
					}
				}
			%>
				<td align="center"><%= k + 1 %>.</td>
				<td ><%=pmlDocumentReceiptLog.getProcesser() != 0 ? processerName : ""%></td>
				<td align="center"><%=pmlDocumentReceiptLog.getDateProcess() != null ? new SimpleDateFormat("dd/MM/yyyy").format(pmlDocumentReceiptLog.getDateProcess()) : "" %></td>
				<td ><%=pmlDocumentReceiptLog.getProcessInfomation() %></td>
				<td ><%=pmlDocumentReceiptLog.getReceiver() != 0 ? tenNguoiNhan : ""%></td>
				<td align="center"><%=pmlDocumentReceiptLog.getReceiveDate() != null ? new SimpleDateFormat("dd/MM/yyyy").format(pmlDocumentReceiptLog.getReceiveDate()) : "" %></td>
			</tr>
		</logic:iterate>
	</table>
</div>
</fieldset>

<!-- phmphuc add 18/11/2010
 Doc danh sach gia han (neu co) de xuat ra trang chi tiet -->
<%
List<PmlEdmDocumentReceiptExtend> dREs = PmlEdmDocumentReceiptExtendUtil.findByDocumentReceiptId(documentReceiptId);
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
								<td width="10%" align="center"><liferay-ui:message key="limit-date"/></td>
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
								<tr class="<%= (k % 2) == 0 ? "results-row" : "tr_two results-row"%>">
									<td align="center"><%= k + 1 %>.</td>
									<td align="center">
										<%= (dREItem.getStartProcessDate() != null) ? sd.format(dREItem.getStartProcessDate()) : "" %>
									</td>
									<td align="center"><%= dREItem.getNumDayProcessBef() %></td>
									<td align="center">
										<%= (dREItem.getLimitDateBef() != null) ? sd.format(dREItem.getLimitDateBef()) : "" %>
									</td>
									<td align="center"><%= dREItem.getNumDayProcessAft() %></td>
									<td align="center">
										<%= (dREItem.getLimitDateAft() != null) ? sd.format(dREItem.getLimitDateAft()) : "" %>
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
		docProcessTypeList = PmlEdmDocumentReceiptProcessTypeUtil.findByDocumentReceiptId(documentReceiptId);
	} catch (Exception e) {
		docProcessTypeList = new ArrayList<PmlEdmDocumentReceiptProcessType>();
	}
	
	if (!docProcessTypeList.isEmpty()) {
%>
<fieldset class="filborder">
<legend class="laborder"><liferay-ui:message key="pccc-XL-thongtinthaydoicachthucxuly"/></legend>
<div class="Scrollbarauto">
	<table class="taglib-search-iterator table-pml" cellspacing="0" width="100%">	
		<tr class="portlet-section-header results-header" >
							<td width="35px" align="center"><liferay-ui:message key="pccc-TN-stt"/></td>
							<td width="15%"><liferay-ui:message key="person-processtype"/></td>
							<td width="15%" align="center"><liferay-ui:message key="date-start-processtype"/></td>
							<td width="20%"><liferay-ui:message key="processtype-before"/></td>
							<td width="35%"><liferay-ui:message key="reason-processtype"/></td>
							<td ><liferay-ui:message key="processtype-after"/></td>
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
									<td><%= tenNguoiSua%></td>
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
List<PmlEdmDocumentRelation> docRelations = PmlEdmDocumentRelationUtil.findByDocLeftId_LeftIsReceipt(documentDTO.getDocumentReceiptId(), true);
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
docRelations = PmlEdmDocumentRelationUtil.findByDocRightId_RightIsReceipt(documentDTO.getDocumentReceiptId(), true);
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
					<td colspan="4" align="left"><liferay-ui:message key="cvdi" /></td>
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
							<tr class="<%= (k % 2) == 1 ? "results-row" : "tr_two results-row"%>">
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

<div id ="table-button" align="right">
	<%
		if ("dangXuLy".equals(hienTrang)) {
	%>
	<liferay-util:include page="/html/portlet/ext/pcccdocumentreceiptprocess/common/workflowAction.jsp"></liferay-util:include>
	<%
		}
	%>
		<input type="hidden" name="page" value="<%=String.valueOf(currentPage) %>"/>
		<input type="hidden" name="limit" value="<%=String.valueOf(currentLimit) %>"/>
		<portlet:renderURL var="back">
			<portlet:param name="struts_action"	value="/sgs/pml_ho_so_cong_viec/viewdetail" />
			<portlet:param name="page" value="<%=String.valueOf(currentPage) %>" />
			<portlet:param name="limit" value="<%=String.valueOf(currentLimit) %>" />
			<portlet:param name="idHoSoCongViec" value="<%=String.valueOf(idHoSoCongViec) %>" />
			<portlet:param name="transitionBack" value="transitionBack" />
			
		</portlet:renderURL>
		<span onclick="javascript:submitForm(document.hrefFm,'<%= back %>');" >
			<input class="button-width" type="button" value='<liferay-ui:message key="back" />'>
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
