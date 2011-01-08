<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.sgs.portlet.pcccdocumentreceiptprocess.dto.DocumentReceiptLogNode"%>
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
<%@page import="com.liferay.portal.NoSuchUserException"%>

<%@page import="com.sgs.portlet.onedoor.service.persistence.PmlDepartmentsLeaderUtil"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>

<%@page import="com.sgs.portlet.pmluser.service.persistence.PmlUserUtil"%>
<%@page import="com.sgs.portlet.document.service.persistence.PmlDocumentReceiptLogUtil"%>

<%@page import="com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptExtend"%>
<%@page import="com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentReceiptExtendUtil"%>

<%@page import="com.sgs.portlet.pmluser.model.PmlUser"%>
<%@page import="com.sgs.portlet.department.service.persistence.DepartmentUtil"%>

<%@page import="com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptProcessType"%>
<%@page import="com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentReceiptProcessTypeUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="com.ext.portlet.processtype.service.ProcessTypeLocalServiceUtil"%>
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

<%@page import="com.sgs.portlet.document.model.PmlEdmDocumentRelation"%>
<%@page import="com.sgs.portlet.document.service.persistence.PmlEdmDocumentRelationUtil"%>
<%@page import="com.sgs.portlet.pmlissuingplace.service.persistence.PmlEdmIssuingPlaceUtil"%>


<%@page import="com.sgs.portlet.pcccdocumentreceiptprocess.action.DetailAction"%>
<%@page import="com.ext.portal.security.permission.ActionKeysExt"%>

<liferay-util:include page="/html/portlet/ext/onedoorpccc/js/pccc-onedoorreceipt.jsp"></liferay-util:include>

<link type="text/css" rel="stylesheet"	href="/html/css/calendar-system.css" />
<link type="text/css" rel="stylesheet" href="/html/portlet/ext/pcccdocumentreceiptprocess/css/letter.css" />

<script type="text/javascript" src="/html/js/calendar.js"></script>
<script type="text/javascript" src="/html/js/calendar-setup.js"></script>
<script type="text/javascript" src="/html/js/calendar-en.js"></script>
<script type='text/javascript' src='/html/js/liferay/tr.js'></script>


<%
	PmlEdmDocumentReceiptDTO documentDTO = 
		(PmlEdmDocumentReceiptDTO)renderRequest.getAttribute("documentDTO");

	//int currentPage = Integer.parseInt(request.getAttribute("currentPage").toString());
	//int currentLimit = Integer.parseInt(request.getAttribute("currentLimit").toString());
	String documentRecordTypeId = (String) renderRequest.getAttribute("documentRecordTypeId");
	
	String daysProcessDeparmentMain = (String) renderRequest.getAttribute("daysProcessDeparmentMain");
	String expireDateProcess = (String) renderRequest.getAttribute("expireDateProcess");
	String mainProcessName = (String) renderRequest.getAttribute("mainProcessName");
	String mainDepartmentName = (String) renderRequest.getAttribute("mainDepartmentName");
	String processInformation = (String) renderRequest.getAttribute("processInformation");
	String hienTrang = ParamUtil.getString(renderRequest, "hienTrang", "dangXuLy");//yenlt update 13/04/2010
	String soCongVanDenHientai = (String) renderRequest.getAttribute("soCongVanDenHientai");
	//minh update 20100416
	String tabChung = ParamUtil.getString(renderRequest, "tabChung");
	String cachThucXuLy = ParamUtil.getString(renderRequest, "cachThucXuLy", "-1");
	String redirect = ParamUtil.getString(renderRequest, "redirect")+ "&tabChung="+tabChung +"&cachThucXuLy="+cachThucXuLy;
	// end minh update 20100416
	
	// phmphuc add 18/11/2010
	long documentReceiptId = documentDTO.getDocumentReceiptId();
	long userId = PortalUtil.getUserId(renderRequest);
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy -HH:mm");
	SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
	// end phmphuc 18/11/2010
	// yenlt update 20101126
	boolean isVanThu = (Boolean) renderRequest.getAttribute("isVanThu") == null ? false : (Boolean) renderRequest.getAttribute("isVanThu");
	boolean vtxulythayldb  = ParamUtil.getBoolean(renderRequest, "vtxulythayldb");
	boolean vtxulythayldvp  = ParamUtil.getBoolean(renderRequest, "vtxulythayldvp");
	long userIdXLT = ParamUtil.getLong(renderRequest, "userIdXLT");
	boolean timkiemcvdendetail = ParamUtil.getBoolean(renderRequest, "timkiemcvdendetail", false);
	if (vtxulythayldb || vtxulythayldvp) {
		userId = userIdXLT;
	}
	List<PmlDocumentReceiptLog> pmlDocumentReceiptLogList = new ArrayList<PmlDocumentReceiptLog>();
	List<PmlDocumentReceiptLog> documentReceiptLogListTemp = new ArrayList<PmlDocumentReceiptLog>();
	// Canh
	DocumentReceiptLogNode root = (DocumentReceiptLogNode) renderRequest.getAttribute("workflow_tree");
	// End of Canh
	
	if (timkiemcvdendetail || vtxulythayldb || vtxulythayldvp) {
		pmlDocumentReceiptLogList = (List<PmlDocumentReceiptLog>)renderRequest.getAttribute("pmlDocumentReceiptLogList") == null ? new ArrayList<PmlDocumentReceiptLog>()
				: (List<PmlDocumentReceiptLog>)renderRequest.getAttribute("pmlDocumentReceiptLogList");
	} else {
		if (PortletPermissionUtil.contains(permissionChecker, plid, "SGS_PCCCDOCUMENTRECEIPTPROCESS_INSTANCE_HKH8", ActionKeysExt.CHUYENVIENREPORT)
				&& !PortletPermissionUtil.contains(permissionChecker, plid, "SGS_PCCCDOCUMENTRECEIPTPROCESS_INSTANCE_HKH8", ActionKeysExt.BAOCAOCHOPHONG)
				&& !isVanThu){
			pmlDocumentReceiptLogList = DetailAction.getTrinhTuLuanChuyenVBChuyenVien(documentReceiptId, userId);// yenlt update 20101026
		} else {
			pmlDocumentReceiptLogList = (List<PmlDocumentReceiptLog>)renderRequest.getAttribute("pmlDocumentReceiptLogList") == null ? new ArrayList<PmlDocumentReceiptLog>()
					: (List<PmlDocumentReceiptLog>)renderRequest.getAttribute("pmlDocumentReceiptLogList");
		}
	}
	
	// end yenlt update 20101126
	
%>

<form method="post">
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
<div class="title_categ"><liferay-ui:message key="pccc-TN-thongtinchitiet"/></div>
    <div class="boxcontent">
	<table width="100%" cellspacing="0" class="detail_xl">
		<tr>	  
		    <td class="td-left" width="18%"><label><liferay-ui:message key="pccc-cvdtn-capgoi"/>: </label></td>
		    <td class="td-right" width="32%"><%=documentDTO.getLevelSendName() != null ? documentDTO.getLevelSendName() : "" %></td>
		    <td class="td-left" width="18%"><label><liferay-ui:message key="pccc-cvdtn-noiphathanh"/>: </label></td>
		    <td class="td-right"><%=documentDTO.getIssuingPlaceName() != null ? documentDTO.getIssuingPlaceName() : "" %></td>
		</tr>
		<tr>
		    <%-- phmphuc close: da chuyen xuong dong duoi
		    <td class="td-left"><label><liferay-ui:message key="pccc-cvdtn-sohieu"/>: </label></td>
			<td class="td-right"><%=documentDTO.getDocumentReference() != null ? documentDTO.getDocumentReference() : "" %></td>
			--%>
		    <td class="td-left"><label><liferay-ui:message key="pccc-cvdtn-loaicongvan"/>:</label></td>
		    <td class="td-right" ><%=documentDTO.getDocumentTypeName() != null ? documentDTO.getDocumentTypeName() : "" %></td>
		    <td class="td-left"><label><liferay-ui:message key="don-vi-sao-y"/>:</label></td>
		    <td class="td-right" ><%=documentDTO.getDonViSaoY() != null ? documentDTO.getDonViSaoY() : "" %></td>
		</tr>
		<tr>
			<%-- phmphuc close: khi them moi ko co So van ban
			<td class="td-left"><label><liferay-ui:message key="pccc-cvdtn-socongvan"/>: </label></td>
			<td class="td-right"><%=documentRecordTypeId != null ? documentRecordTypeId  : "" %></td>
			--%>
			<td class="td-left"><label><liferay-ui:message key="pccc-cvdtn-soCVden"/>: </label></td>
			<td class="td-right"><%=documentDTO.getNumberDocumentReceipt() != null ? documentDTO.getNumberDocumentReceipt() : "" %></td>
			<td class="td-left"><label><liferay-ui:message key="pccc-cvdtn-sohieu"/>: </label></td>
			<td class="td-right"><%=documentDTO.getDocumentReference() != null ? documentDTO.getDocumentReference() : "" %></td>
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
			<td class="td-right"><%=documentDTO.getPrivilegeLevel()!= null ? documentDTO.getPrivilegeLevel() : ""%></td>
			<td class="td-left" valign="top"><label><liferay-ui:message key="cach-thuc-xu-ly"/>:</label></td>
				<td class="td-right">
					<%
					boolean hasProType = false; // Co cach thuc xu ly chon tu danh muc
					%>
							<div class="cvd-filedinhkem" style="width: 99%;background-color: white;">
								<logic:iterate id="listprocesstype_doc" name="listprocesstype_doc" type="com.ext.portlet.processtype.model.ProcessType" scope="request" indexId="j" >
									 <span id="stt" style="padding: 3px 0;display: block;">- &nbsp;<%= listprocesstype_doc.getName()%></span>
							<!-- <!%
							hasProType = true;
							%>-->
						</logic:iterate>
						<%
						// Doc thong tin cach thuc xu ly cua van ban neu khong xac dinh duoc cach thuc xu ly tu danh muc
						//if (hasProType == false) {
						//	String proTypeDesc = ""; // Dien giai cach thuc xu ly
						//	PmlEdmDocumentReceipt curDoc = PmlEdmDocumentReceiptUtil.findByPrimaryKey(documentDTO.getDocumentReceiptId());
						//	if (curDoc != null) {
						//		String curDocType = curDoc.getDocumentType();
						//		if (curDocType.equals("1")) { // Luu
						//			proTypeDesc = "L\u01b0u.";
						//		} else if (curDocType.equals("2")) {
						//			proTypeDesc = "B\u00e1o c\u00e1o.";
						//		} else if (curDocType.equals("3")) {
						//			proTypeDesc = "So\u1EA1n v\u0103n b\u1ea3n tr\u1EA3 l\u1EDDi.";
						//		}
						//	}
						//	out.println(proTypeDesc);
						//}
						%>
					</div>	 
				</td>
			<%---
			<%
				String congvancongcong = "1".equals(documentDTO.getIsPublic()) ? "pccc-cvdtn-lacongvancongcong" : "pccc-cvdtn-lacongvannoibo";
			%>
			<td class="td-right" colspan="2"><liferay-ui:message key="<%=congvancongcong %>"/></td>
			---%>
		</tr>
		<tr>
			<td class="td-left" valign="top"><label><liferay-ui:message key="pccc-cvdtn-hosocongviec"/>:</label></td>
			 <td class="td-right">
				 <div class="cvd-filedinhkem" style="width: 99%;background-color: white;">
					 <logic:iterate id="pmlHoSoCongViec" name="pmlHoSoCongViecList" indexId="i" type="com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec"  >
							<span style="padding: 3px 0;display: block;" id="stt">- &nbsp;<%= pmlHoSoCongViec.getTieuDe() %></span>
			        </logic:iterate>
				 </div>	 
			 </td>
				<td class="td-left">
					<label><liferay-ui:message key="pccc-cvdtn-socongvandiphucdap"/>: </label></td>
		    <td class="td-right">
		    	<%
		    		if (! "".equals(documentDTO.getSocongvandiphucdap()) && documentDTO.getSocongvandiphucdap() != null ) {
		    			List<PmlEdmDocumentSend> pmlEdmDocumentSendList = new ArrayList<PmlEdmDocumentSend>();
		    			try {
		    				pmlEdmDocumentSendList = PmlEdmDocumentSendUtil.findByDocumentReference(documentDTO.getSocongvandiphucdap());
		    			} catch (Exception e){}
		    			
		    			if (pmlEdmDocumentSendList.size() > 0) {
		    			
		    				PortletURL detail_DocumentSend = new PortletURLImpl(request, "SGS_PCCCDOCUMENTSENDPROCESS", 33011, PortletRequest.RENDER_PHASE);
		    				detail_DocumentSend.setParameter("struts_action", "/sgs/pcccdocumentsendprocess/detail");
		    				detail_DocumentSend.setParameter("documentSendId", String.valueOf(pmlEdmDocumentSendList.get(0).getDocumentSendId()));
		    				detail_DocumentSend.setParameter(com.sgs.liferay.jbpm.util.Constants.WORKFLOW_RENDER, "false");
		    				
		    	%>
		    			
		    	
		    			<a href="<%= detail_DocumentSend %>"><u><%= documentDTO.getSocongvandiphucdap()%></u></a>
		    	<%		}
		    		}
		    	%>
		    </td>
		</tr>
		<tr>
			<td class="td-left"><label><liferay-ui:message key="pccc-TN-tongsongayxuly"/>:</label></td>
			<td class="td-right"><font style="color: #FF5A00;">
				<%
					if (daysProcessDeparmentMain != null && !"0".equals(daysProcessDeparmentMain)) { 
				%>
						<%= daysProcessDeparmentMain %> <liferay-ui:message key="ngay"/>
				<%
					} else {
						out.println("Kh\u00f4ng gi\u1EDBi h\u1ea1n.");
					}
				%>
			</font>
			</td>
			<td class="td-left"><label><liferay-ui:message key="pccc-TN-ngayhethanxuly"/>:</label></td>
				<%--- xuancong close start
			<td class="td-right"><%=(expireDateProcess != null) ? expireDateProcess : "" %></td>
				xuancong close end ---%>
				<td class="td-right"><font style="color: #FF5A00;"><%=(expireDateProcess != null && expireDateProcess.trim().length() > 0) ? expireDateProcess : "Kh\u00f4ng gi\u1EDBi h\u1ea1n." %></font></td>
				
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
			<td class="td-left" ><label><liferay-ui:message key="pccc-TN-trangthaigannhat"/>:</label></td>
			<%
			// minh update 20100323
				//String nameSate = documentDTO.getState();
				
				//try {
				//			nameSate = PmlStateProcessUtil.findByPrimaryKey(Long.parseLong(documentDTO.getState())).getStateProcessName();
				//}catch (Exception e) {
				//		nameSate = null;
				//}
			
				
				PmlEdmDocumentReceipt documentReceipt = null;
				long statusId = ParamUtil.getLong(renderRequest, "statusId");
				long stateProcessId = ParamUtil.getLong(renderRequest, "stateProcessId");
				// phmphuc update 17/04/2010
				List<PmlFileStatusStateProcess> fileStatusStateProcessList = null;
				PmlFileStatusStateProcess fileStatusStateProcess = null;
				try {
					fileStatusStateProcess = PmlFileStatusStateProcessUtil.findByFileStatus_StateProcess(statusId, stateProcessId).get(0);
				} catch (Exception e) {
					documentReceipt = PmlEdmDocumentReceiptLocalServiceUtil.getPmlEdmDocumentReceipt(documentDTO.getDocumentReceiptId());
				//	fileStatusStateProcess = PmlFileStatusStateProcessUtil.findByStateProcessId(documentReceipt.getStatusId()).get(0);
					fileStatusStateProcessList = PmlFileStatusStateProcessUtil.findByStateProcessId(documentReceipt.getStatusId());
					if (0 != fileStatusStateProcessList.size()) {
						fileStatusStateProcess = fileStatusStateProcessList.get(0);
					}
				}
				// end
					
				if (fileStatusStateProcess != null) {
					
				%>
					<td class="td-right"><%= fileStatusStateProcess.getDescription() %></td>
				<%	
				} else if (documentReceipt != null && documentReceipt.getDateHoanThanh() != null ) {
				%>
					<td class="td-right"><liferay-ui:message key="cv-hoanthanh"/></td>
				<%	
				} else {
				%>
						<td class="td-right"></td>
				<%	
				}
			// end minh update 20100323
			%>
		</tr>
		<tr  valign="top">
		    <td class="td-left"><label><liferay-ui:message key="pccc-cvdtn-toanvan"/>:</label></td>
		    <td class="td-right">
		    	<logic:iterate id="attachedFile" name="attachedFiles" indexId="i" type="com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile" scope="request" >
		    	<a href="<%=attachedFile.getPath() %>"><%=!"".equals(attachedFile.getTitle()) ? attachedFile.getTitle() : attachedFile.getAttachedFileName() %><br /></a>
		    	</logic:iterate>
		    </td>
		    <td class="td-left"></td>
			<td class="td-right"></td>
		</tr>
		
		<tr valign="top">
				<td valign="top" class="td-left"><label><liferay-ui:message key="pccc-cvdtn-trichyeu"/>:</label></td>
				<td colspan="3" class="td-right"><textarea class="textarea-display" onMouseover="this.style.backgroundColor='white';" readonly="" rows="5" style="width: 95%"><%=documentDTO.getBriefContent()!= null ? documentDTO.getBriefContent() : ""%></textarea></td>
			</tr>
</table>


<fieldset class="filborder">
	<label class="laborder"><liferay-ui:message key="pccc-XL-quatrinhluanchuyencongvanden"/></label>
	<div class="Scrollbarauto">
	<table class="taglib-search-iterator table-pml" cellspacing="0" width="100%">	
		<tr class="portlet-section-header results-header" >
			<td align="center" width="35px"><liferay-ui:message key="pccc-TN-stt"/></td>
			<td width="20%"><liferay-ui:message key="pccc-XL-donvicanhangui"/></td>
			<td align="center" width="11%"><liferay-ui:message key="pccc-XL-ngaygui"/></td>
			<td width="35%"><liferay-ui:message key="pccc-XL-yeucauxuly"/></td>
			<td width="20%"><liferay-ui:message key="pccc-XL-donvicanhannhan"/></td>
			<td align="center"><liferay-ui:message key="pccc-DSHS-ngaynhan"/></td>						
		</tr>	
		<!-- yenlt update 20101126 -->
		<!-- logic:iterate id="pmlDocumentReceiptLog" name="pmlDocumentReceiptLogList" type="com.sgs.portlet.document.model.PmlDocumentReceiptLog" indexId="k"-->
		<% for (int k = 0; k < pmlDocumentReceiptLogList.size(); k++) {
			PmlDocumentReceiptLog pmlDocumentReceiptLog = pmlDocumentReceiptLogList.get(k);
			User nguoiGui = null;
			User nguoiXLT = null;
			String processerName = "";
			String directProcesserName = "";
			if (pmlDocumentReceiptLog.getProcesser() != 0) {
				try {
					nguoiGui = UserUtil.findByPrimaryKey(pmlDocumentReceiptLog.getProcesser());
					processerName = getFullName(nguoiGui);
				}
				catch (Exception ex) {
					if (ex instanceof NoSuchUserException) {
						processerName = String.valueOf(pmlDocumentReceiptLog.getProcesser());
					}
				}
				try {
					if (pmlDocumentReceiptLog.getDirectProcesserId() > 0 && pmlDocumentReceiptLog.getProcesser() != pmlDocumentReceiptLog.getDirectProcesserId()) {
						nguoiXLT = UserUtil.findByPrimaryKey(pmlDocumentReceiptLog.getDirectProcesserId());
						directProcesserName = getFullName(nguoiXLT);
						}
					} catch (Exception e) {
						
					}
				}
			
			
			User nguoiNhan = null;
			String tenNguoiNhan = "";
			if (pmlDocumentReceiptLog.getReceiver() != 0) {
				try {
				nguoiNhan = UserUtil.findByPrimaryKey(pmlDocumentReceiptLog.getReceiver());
				tenNguoiNhan = getFullName(nguoiNhan);
			}
				catch (Exception ex) {
					if (ex instanceof NoSuchUserException) {
						tenNguoiNhan = String.valueOf(pmlDocumentReceiptLog.getReceiver());
					}
				}
			}
			
			// yenlt update 20101126
			String ngayGui = "&nbsp;";
			String ngayNhan = "&nbsp;";
			if (pmlDocumentReceiptLog.getDateProcess() != null && pmlDocumentReceiptLog.getDateProcessTime() == null) {
				ngayGui = sd.format(pmlDocumentReceiptLog.getDateProcess());
		 	} if (pmlDocumentReceiptLog.getDateProcessTime() != null) { 
				ngayGui = sdf.format(pmlDocumentReceiptLog.getDateProcessTime());
		 	} if (pmlDocumentReceiptLog.getReceiveDate() != null && pmlDocumentReceiptLog.getReceiveDateTime() == null) {
		 		ngayNhan = sd.format(pmlDocumentReceiptLog.getReceiveDate());
		 	} if (pmlDocumentReceiptLog.getReceiveDateTime() != null) {
		 		ngayNhan = sdf.format(pmlDocumentReceiptLog.getReceiveDateTime());
		 	}
		%>
			<tr class="<%=(k % 2) == 0 ? "results-row" : "tr_two results-row" %>" onmouseover="onMouseOverTr(this);" onmouseout="onMouseOutTr(this);">
				<td align="center" width="35px"><%=k+1 %>.</td>
				<td width="20%"><%=directProcesserName.length() > 0 ? processerName + "<br/><small>(" + LanguageUtil.get(pageContext, "uy-quyen-xu-ly") + ": " + directProcesserName + ")</small>" : processerName %></td>
				<td align="center" width="11%"><%= ngayGui %></td>
				<td width="35%"><%=pmlDocumentReceiptLog.getProcessInfomation().equals("") ? "&nbsp;" : pmlDocumentReceiptLog.getProcessInfomation() %></td>
				<td width="20%"><%=pmlDocumentReceiptLog.getReceiver() != 0 ? tenNguoiNhan : "&nbsp;"%></td>
				<td align="center"><%= ngayNhan %></td>
			</tr>
			<% } %>
		<!-- /logic:iterate-->
		<!-- end yenlt update 20101126 -->
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
	<label class="laborder"><liferay-ui:message key="information-extend-process-document-receipt"/></label>
	<div class="Scrollbarauto">
	<table class="taglib-search-iterator table-pml" cellspacing="0" width="100%">	
		<tr class="portlet-section-header results-header" >
								<td width="35px" rowspan="2" align="center"><liferay-ui:message key="STT"/></td>
								<td width="10%" rowspan="2" align="center"><liferay-ui:message key="date-start-process"/></td>
								<td width="18%" colspan="2"><liferay-ui:message key="before-extend"/></td>
								<td width="18%" colspan="2"><liferay-ui:message key="after-extend"/></td>
								<td rowspan="2"><liferay-ui:message key="reason-extend"/></td>
								<td width="10%" rowspan="2"><liferay-ui:message key="person-extend"/></td>						
								<td width="15%" rowspan="2"><liferay-ui:message key="department-extend"/></td>						
							</tr>
							<tr class="portlet-section-header results-header" >
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
									User tmpUser = UserUtil.findByPrimaryKey(dREItem.getExtendUserId());
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
} // end phmphuc update 18/11/2010
%>

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
	<label class="laborder"><liferay-ui:message key="pccc-XL-thongtinthaydoicachthucxuly"/></label>
		<div class="Scrollbarauto">
		<table class="taglib-search-iterator table-pml" cellspacing="0" width="100%">	
							<tr class="portlet-section-header results-header" >
							<td width="35px" align="center"><liferay-ui:message key="pccc-TN-stt"/></td>
							<td width="15%"><liferay-ui:message key="person-processtype"/></td>
							<td align="center"><liferay-ui:message key="date-start-processtype"/></td>
							<td width="20%"><liferay-ui:message key="processtype-before"/></td>
							<td width="35%"><liferay-ui:message key="reason-processtype"/></td>
							<td width="25%"><liferay-ui:message key="processtype-after"/></td>
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

<!-- phmphuc add lien ket vb 19/11/2010 -->
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
	<label class="laborder"><liferay-ui:message key="link-document-exist"/></label>
		<div class="Scrollbarauto">
			<%
			if (!docRecIdsRelation.isEmpty()) {
			%>
			<table class="taglib-search-iterator table-pml" cellspacing="0" width="100%">	
				<tr class="portlet-section-header results-header" >
					<td colspan="4"><liferay-ui:message key="cvden" /></td>
				</tr>
				<tr class="portlet-section-header results-header">
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
			
			<br>
			<%
			if (!docSendIdsRelation.isEmpty()) {
			%>
			<table class="taglib-search-iterator table-pml" cellspacing="0" width="100%">	
				<tr class="portlet-section-header results-header" >
					<td colspan="4"><liferay-ui:message key="cvdi" /></td>
				</tr>
				<tr class="portlet-section-header results-header">
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
							<tr  class="<%= (k % 2) == 1 ? "results-row" : "tr_two results-row" %>">
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
<!-- end phmphuc update lien ket van ban 19/11/2010 -->

<div align="right" id="table-button">
	<%
		if ("dangXuLy".equals(hienTrang)) {
	%>
			<liferay-util:include page="/html/portlet/ext/pcccdocumentreceiptprocess/common/workflowAction.jsp"></liferay-util:include>
		
		<%
			// ********** Phan xu ly xuat hien nut gia han, lien ket van ban hay khong start **********
			// Xuat hien nut Gia han khi nguoi dung la nguoi xu ly chinh cua van ban 
			// hoac nguoi dung la LD cua phong xu ly chinh (duoc chuyen van ban den theo luong chinh)
			// Buoc luan chuyen cua nguoi dung dang xu ly phai co gioi han thoi gian
			boolean showExtend = false; // Hien thi nut Gia han
			boolean showProcessType = false; // Hien thi nua chinh sua cach thuc xu ly VB
			boolean showDocLink = false; // Hien thi nut Lien ket VB, la nguoi xu ly chinh
				
			// Lay ra van ban den dang xu ly
			PmlEdmDocumentReceipt curDocRec = null;
			// Xac dinh ma so dong log ma nguoi dung dang xu ly
			long curDocRecLogId = 0;
			String mainDepartmentProcessId = "";
			long mainUserProcessId = 0;
			try {
				curDocRec = PmlEdmDocumentReceiptUtil.findByPrimaryKey(documentReceiptId);
				mainDepartmentProcessId = curDocRec.getMainDepartmentProcessId().trim();
				mainUserProcessId = curDocRec.getMainUserProcessId();
			} catch (Exception ex) {}
			
			// Lay ma so phong ban cua nguoi dung
			String curDepartmentId = "";
			try {
				curDepartmentId = PmlUserUtil.findByPrimaryKey(userId).getDepartmentsId();
			} catch (Exception ex) { }
			
			// Kiem tra phong cua nguoi dung dung la phong xu ly chinh cua van ban thi moi thao tac
			if (mainDepartmentProcessId.length() > 0 && mainDepartmentProcessId.equalsIgnoreCase(curDepartmentId)) {
				if (mainUserProcessId == 0) {
					// Chua xac dinh nguoi xu ly chinh. Nguoi dung la LD phong thi moi duoc gia han
					if (PmlDepartmentsLeaderUtil.countByDepartmentsId_UserId(curDepartmentId, userId) > 0) {
						showExtend = true;
						showProcessType = true;
					}
				}
				else { // Da xac dinh nguoi xu ly chinh
					// Nguoi dung phai la nguoi xu ly chinh thi moi duoc gia han va lien ket van ban
					if (mainUserProcessId == userId) {
						showExtend = true;
						showProcessType = true;
						showDocLink = true;
					}
				}
			}
			
			if (showExtend == true) {
				showExtend = false; // Tiep tuc kiem tra
				// Lay ra toan bo cac dong log do nguoi dung la processer, neu dong log lon nhat chua hoan thanh 
				// co type_ la 0 thi hop le de hien nut Gia han
				List<PmlDocumentReceiptLog> curDocRecLogProcs = PmlDocumentReceiptLogUtil.findByDocumentReceiptId(documentReceiptId);
				if (!curDocRecLogProcs.isEmpty()) {
					// Sap xep giam dan theo transition
					Collections.sort(curDocRecLogProcs, new Comparator<PmlDocumentReceiptLog>() {
						public int compare(PmlDocumentReceiptLog o1, PmlDocumentReceiptLog o2) {
							return o1.getTransition_() - o2.getTransition_();
						}
					});
					// Duyet danh sach de lay ra log do nguoi dung xu ly, chua xu ly va thuoc qui trinh chinh
					for (int idxDRLP = curDocRecLogProcs.size() - 1; idxDRLP > 0; idxDRLP --) {
						PmlDocumentReceiptLog dRL1 = curDocRecLogProcs.get(idxDRLP);
						if (dRL1.getDateProcess() != null || dRL1.getType_() > 0 || dRL1.getProcesser() != userId) {
							// Da xu ly hoac khong phai qui trinh chinh hoac khong phai do nguoi dung xu ly
							continue;
						}
						// Phan xu ly danh cho nguoi dung xu ly thuoc qui trinh chinh
						// Duyet cac dong log truoc de lay dong phu hop
						for (int idxRe = idxDRLP - 1; idxRe >= 0; idxRe --) {
							PmlDocumentReceiptLog dRL2 = curDocRecLogProcs.get(idxRe);
							if (dRL1.getStateProcessIdBefore() == dRL2.getStateProcessIdAfter() && 
									dRL2.getType_() == 0 && dRL1.getProcesser() == dRL2.getReceiver() &&
									(dRL2.getExpiredDate() != null || dRL2.getNumDateProcess() > 0)) {
								// Buoc truoc cua qui trinh
								curDocRecLogId = dRL2.getDocumentReceiptLogId();
								break;
							}
						}
						// Thoat khoi vong lap neu da xac dinh duoc ma so buoc chuyen truoc do
						if (curDocRecLogId > 0) {
							showExtend = true;
							break;
						}
					}
				}
			}
			if (showExtend == true) { // Du dieu kien hien nut gia han
			%>
				<portlet:renderURL var="extendProcessTime"  windowState="<%= LiferayWindowState.POP_UP.toString() %>">
					<portlet:param name="struts_action" value="/sgs/pcccdocumentreceiptprocess/viewextend" />
					<portlet:param name="documentReceiptId" value="<%= String.valueOf(documentReceiptId) %>" />
					<portlet:param name="docRecLogId" value="<%= String.valueOf(curDocRecLogId) %>" />
				</portlet:renderURL>
				
				<span onclick="var extWin = window.open('<%= extendProcessTime %>', 'extendwin', 'directories=no,height=400,location=no,menubar=no,resizable=yes,scrollbars=yes,status=no,toolbar=no,width=800'); void(''); extWin.focus();">
					<input class="button-width" type="button" value="<liferay-ui:message key="extend-process" />">
				</span>
			<%
			} 
			// hien nut chinh sua cach thuc xu ly
			if (showProcessType == true) {
			%>
				<portlet:renderURL var="edit_processtype" windowState="<%= LiferayWindowState.POP_UP.toString() %>">
					<portlet:param name="struts_action" value="/sgs/pcccdocumentreceiptprocess/editprocesstype" />
					<portlet:param name="documentReceiptId" value="<%= String.valueOf(documentReceiptId) %>" />
					<portlet:param name="docRecLogId" value="<%= String.valueOf(curDocRecLogId) %>" />
				</portlet:renderURL>
						
				<span onclick="var extWin = window.open('<%= edit_processtype %>', 'mywindow', 'directories=no,height=400,location=no,menubar=no,resizable=yes,scrollbars=yes,status=no,toolbar=no,width=720'); void(''); extWin.focus();">
					<input class="button-width" type="button" value="<liferay-ui:message key="process-type" />">
				</span>
			<%
			}
			if (showDocLink == true) { // Du dieu kien hien nut lien ket van ban
				// Tao lien ket den trang van ban lien quan
				PortletURL linkDocURL = renderResponse.createRenderURL();
				linkDocURL.setWindowState(WindowState.NORMAL);
				linkDocURL.setParameter("struts_action", "/sgs/pcccdocumentreceiptprocess/documentrelation");
				linkDocURL.setParameter("documentId", String.valueOf(documentReceiptId));
				linkDocURL.setParameter("detailBackURL", PortalUtil.getCurrentURL(request));
			%>
				<span onclick="javascript:submitForm(document.hrefFm,'<%= linkDocURL %>');">
					<input class="button-width" type="button" value='<liferay-ui:message key="link-document"/>' >
				</span>
			<%
			}
		} 
		else { 
			//yenlt update 20101119 == vb rut lai
			boolean rutLai = ParamUtil.getBoolean(renderRequest, "rutLai");
			if (rutLai) {
		%>
				<input type="hidden" name="rutLai" value="<%= String.valueOf(rutLai) %>">
				<liferay-util:include page="/html/portlet/ext/pcccdocumentreceiptprocess/common/workflowAction.jsp"></liferay-util:include>
	
		<%
		// end yenlt update 20101119
			}
		}
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
<a>

</a>
<%!
public String getHtml(DocumentReceiptLogNode root) {
	PmlDocumentReceiptLog receiptLog = root.getReceiptLog();
	StringBuilder sb = new StringBuilder();
	if (receiptLog.getReceiver() == 0) {
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
	List<DocumentReceiptLogNode> children = root.getChildren();
	if (children.size() > 0) {
		sb.append("<ul>");
		for (DocumentReceiptLogNode child : children) {
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
