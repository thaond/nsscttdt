<%@ include file="/html/portlet/ext/home_document/init.jsp" %>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>

<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portlet.PortletURLImpl"%>
<%@page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>
<%@page import="com.liferay.portal.service.permission.PortletPermissionUtil"%>
<%@page import="com.ext.portal.security.permission.ActionKeysExt"%>

<%@page import="com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt"%>
<%@page import="com.sgs.portlet.document.receipt.service.PmlEdmDocumentReceiptLocalServiceUtil"%>
<%@page import="com.sgs.portlet.document.send.service.PmlEdmDocumentSendLocalServiceUtil"%>

<%@page import="com.sgs.portlet.document.model.PmlFileStatus"%>
<%@page import="com.sgs.portlet.document.service.persistence.PmlFileStatusUtil"%>


<!-- Phan danh cho thong tin van ban -->

<%
	String fileStatusCodeCVDen = "";
	String fileStatusCodeCVDi = "";
	if ((PortletPermissionUtil.contains(permissionChecker, plid, "SGS_HOME_DOCUMENT", ActionKeysExt.TIEPNHANCV) == true)) {
		fileStatusCodeCVDen = "CVDEN_VANTHU_DANGXULY_CHUNG_dangxuly";
		fileStatusCodeCVDi = "CVDI_VANTHU_DANGXULY_CHUNG_dangxuly";
	}
	else {
		fileStatusCodeCVDen = "CVDEN_TRUONGPHONG_DANGXULY_CHUNG_dangxuly";
		fileStatusCodeCVDi = "CVDI_TRUONGPHONG_DANGXULY_CHUNG_dangxuly";
	}
	
	PmlFileStatus fileStatusCVDen = PmlFileStatusUtil.findByFileStatusCode(fileStatusCodeCVDen).get(0);
	//System.out.println(fileStatusCodeCVDen + " aaa " + fileStatusCVDen.getFileStatusName() + "  bbb  " + fileStatusCVDen.getFileStatusId());
	PmlFileStatus fileStatusCVDi = PmlFileStatusUtil.findByFileStatusCode(fileStatusCodeCVDi).get(0);
	
	// Duong dan den danh sach cong van den dung han
	PortletURL details_cvden_dunghan = new PortletURLImpl(request, "SGS_PCCCDOCUMENTRECEIPTPROCESS_INSTANCE_HKH8", 89385, PortletRequest.RENDER_PHASE);
	details_cvden_dunghan.setParameter("struts_action", "/sgs/pcccdocumentreceiptprocess/view");
	details_cvden_dunghan.setParameter("statusId", fileStatusCVDen.getFileStatusId() + "");
	details_cvden_dunghan.setParameter("cachThucXuLy", "-1");
	
	// Chua xac dinh cach thuc xu ly
	PortletURL details_cvden_dunghan_chuaxdctxl = new PortletURLImpl(request, "SGS_PCCCDOCUMENTRECEIPTPROCESS_INSTANCE_HKH8", 89385, PortletRequest.RENDER_PHASE);
	details_cvden_dunghan_chuaxdctxl.setParameter("struts_action", "/sgs/pcccdocumentreceiptprocess/view");
	details_cvden_dunghan_chuaxdctxl.setParameter("statusId", fileStatusCVDen.getFileStatusId() + "");
	details_cvden_dunghan_chuaxdctxl.setParameter("cachThucXuLy", "");
	
	// Luu tham khao
	PortletURL details_cvden_dunghan_luuthamkhao = new PortletURLImpl(request, "SGS_PCCCDOCUMENTRECEIPTPROCESS_INSTANCE_HKH8", 89385, PortletRequest.RENDER_PHASE);
	details_cvden_dunghan_luuthamkhao.setParameter("struts_action", "/sgs/pcccdocumentreceiptprocess/view");
	details_cvden_dunghan_luuthamkhao.setParameter("statusId", fileStatusCVDen.getFileStatusId() + "");
	details_cvden_dunghan_luuthamkhao.setParameter("cachThucXuLy", "1");
	
	// Bao cao
	PortletURL details_cvden_dunghan_baocao = new PortletURLImpl(request, "SGS_PCCCDOCUMENTRECEIPTPROCESS_INSTANCE_HKH8", 89385, PortletRequest.RENDER_PHASE);
	details_cvden_dunghan_baocao.setParameter("struts_action", "/sgs/pcccdocumentreceiptprocess/view");
	details_cvden_dunghan_baocao.setParameter("statusId", fileStatusCVDen.getFileStatusId() + "");
	details_cvden_dunghan_baocao.setParameter("cachThucXuLy", "2");
	
	// Phai soan vb tra loi
	PortletURL details_cvden_dunghan_phaisoanvbtl = new PortletURLImpl(request, "SGS_PCCCDOCUMENTRECEIPTPROCESS_INSTANCE_HKH8", 89385, PortletRequest.RENDER_PHASE);
	details_cvden_dunghan_phaisoanvbtl.setParameter("struts_action", "/sgs/pcccdocumentreceiptprocess/view");
	details_cvden_dunghan_phaisoanvbtl.setParameter("statusId", fileStatusCVDen.getFileStatusId() + "");
	details_cvden_dunghan_phaisoanvbtl.setParameter("cachThucXuLy", "3");
	
	// Duong dan den danh sach cong van den tre han
  	PortletURL details_cvden_trehan = new PortletURLImpl(request, "SGS_PCCCDOCUMENTRECEIPTPROCESS_INSTANCE_HKH8", 89385, PortletRequest.RENDER_PHASE);
  	details_cvden_trehan.setParameter("struts_action", "/sgs/pcccdocumentreceiptprocess/view");
  	details_cvden_trehan.setParameter("statusId", fileStatusCVDen.getFileStatusId() + "");
  	details_cvden_trehan.setParameter("isExpired", "true");

  	// Duong dan den danh sach cong van di dung han
  	PortletURL details_cvdi_dunghan = new PortletURLImpl(request, "SGS_PCCCDOCUMENTSENDPROCESS", 89655, PortletRequest.RENDER_PHASE);
  	details_cvdi_dunghan.setParameter("struts_action", "/sgs/pcccdocumentsendprocess/view");
  	details_cvdi_dunghan.setParameter("statusId", fileStatusCVDi.getFileStatusId() + "");

  	// Duong dan den danh sach cong van di tre han
  	PortletURL details_cvdi_trehan = new PortletURLImpl(request, "SGS_PCCCDOCUMENTSENDPROCESS", 89655, PortletRequest.RENDER_PHASE);
  	details_cvdi_trehan.setParameter("struts_action", "/sgs/pcccdocumentsendprocess/view");
  	details_cvdi_trehan.setParameter("statusId", fileStatusCVDi.getFileStatusId() + "");
  	details_cvdi_trehan.setParameter("isExpired", "true");
	
	// Dem so luong cong van den va di theo trang thai
	List<Long> uesrList = new ArrayList<Long>();
	uesrList.add(PortalUtil.getUserId(renderRequest));
	int quantityOfDocRecNeedProcess = PmlEdmDocumentReceiptLocalServiceUtil.countByDocumentReceipt_Users_Status_DangXuLy(uesrList, fileStatusCVDen.getFileStatusId(), "0", "0");							
	int quantityOfDocRecExpireOfUser = PmlEdmDocumentReceiptLocalServiceUtil.countByDocumentReceipt_Users_Status_DangXuLy_TreHan(uesrList ,fileStatusCVDen.getFileStatusId(), "0", "0");
	int quantityOfDocSendNeedProcess = PmlEdmDocumentSendLocalServiceUtil.countByDocumentSend_Users_Status_DangXuLy(uesrList, fileStatusCVDi.getFileStatusId(), "0", "tatca");
	int quantityOfDocSendExpireOfUser = PmlEdmDocumentSendLocalServiceUtil.countByDocumentSend_Users_Status_DangXuLy_TreHan(uesrList, fileStatusCVDi.getFileStatusId(), "0", "tatca");
	
	// Tinh v/ban den can xu ly chia theo cach thuc xu ly
	List<PmlEdmDocumentReceipt> lstDocRecNeedPro = PmlEdmDocumentReceiptLocalServiceUtil.findByDocumentReceipt_Users_Status_DangXuLy(uesrList, fileStatusCVDen.getFileStatusId(), "0", "0", QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	int quanOfDocRecNeedProOnlyView = 0; // V/ban den can xu ly chi doc
	int quanOfDocRecNeedProMakeReport = 0; // V/ban den can xu ly phai bao cao
	int quanOfDocRecNeedProMakeReply = 0; // V/ban den can xu ly phai tao v/ban di tra loi
	int quanOfDocRecNeedProNoDefPro = 0; // V/ban den can xu ly chua xac dinh cach thuc xu ly

	if (!lstDocRecNeedPro.isEmpty()) { // Chi thuc hien khi co danh sach v/ban den can xu ly
		for (int idxDRNP = 0; idxDRNP < lstDocRecNeedPro.size(); idxDRNP ++) {
			PmlEdmDocumentReceipt DRNPItem = (PmlEdmDocumentReceipt) lstDocRecNeedPro.get(idxDRNP);
			if (DRNPItem.getDocumentType().equalsIgnoreCase("1")) { // Chi doc
				quanOfDocRecNeedProOnlyView ++;
			}
			else if (DRNPItem.getDocumentType().equalsIgnoreCase("2")) { // Bao cao
				quanOfDocRecNeedProMakeReport ++;
			}
			else if (DRNPItem.getDocumentType().equalsIgnoreCase("3")) { // Soan v/ban tra loi
				quanOfDocRecNeedProMakeReply ++;
			}
			else {
				quanOfDocRecNeedProNoDefPro ++;
			}
		}
	}
%>

<%-- nhac viec --%>
<div class="title_categ">
		<liferay-ui:message key="nhac-viec"/>
	</div>

	<div class="boxcontent intleft">
		<!-- van ban den -->
		<% 	if (quantityOfDocRecNeedProcess > 0) { %>
				<label>
					<a href="<%= details_cvden_dunghan.toString() %>">
				<liferay-ui:message key="cong-van-den" /> &nbsp; <%= quantityOfDocRecNeedProcess %> &nbsp;
				</a>
		</label>
		<% 	} else { %>
		<label>
				<liferay-ui:message key="cong-van-den" />
		</label>
		<% 	} %>
		
		
		<% 	if (quantityOfDocRecNeedProcess <= 0) { %>
				<ul class="ind_ul">
					<li>
						<liferay-ui:message key="now-you-have-not-any-receive-document-need-process" />
					</li>
				</ul>
		<% 	} else { %>
				<ul class="ind_ul">
				
					<c:if test="<%= quanOfDocRecNeedProOnlyView > 0 %>">
						<li>
							<a href="<%= details_cvden_dunghan_luuthamkhao.toString() %>">
								<%= quanOfDocRecNeedProOnlyView + "&nbsp;l\u01B0u tham kh\u1ea3o" %>
							</a> 
						</li>
					</c:if>
					
					<c:if test="<%= quanOfDocRecNeedProMakeReport > 0 %>">
						<li>
							<a href="<%= details_cvden_dunghan_baocao.toString() %>">
								<%= quanOfDocRecNeedProMakeReport + "&nbsp;b\u00E1o c\u00E1o" %>
							</a> 
						</li>
					</c:if>
					
					<c:if test="<%= quanOfDocRecNeedProMakeReply > 0 %>">
						<li>
							<a href="<%= details_cvden_dunghan_phaisoanvbtl.toString() %>">
								<%= quanOfDocRecNeedProMakeReply + "&nbsp;so\u1EA1n v\u0103n b\u1ea3n tr\u1EA3 l\u1EDDi" %>
							</a> 
						</li>
					</c:if>
					
					<c:if test="<%= quanOfDocRecNeedProNoDefPro > 0 %>">
						<li>
							<a href="<%= details_cvden_dunghan_chuaxdctxl.toString() %>">
								<%= quanOfDocRecNeedProNoDefPro + "&nbsp;ch\u01b0a ph\u00E2n c\u00f4ng x\u1eed l\u00fd" %>
							</a> 
						</li>
					</c:if>
					<!--thoind close
					<li>
						<a href="<!%= details_cvden_dunghan.toString() %>">
							<!%= quantityOfDocRecNeedProcess %>&nbsp;
							<liferay-ui:message key="od-no-need-process"/>
						</a> 
					</li>
					-->
				</ul>
			<% 	} %>
	
		<!-- Cong van di -->
		
		<% 	if (quantityOfDocSendNeedProcess > 0) { %>
				<label>
					<a href="<%= details_cvdi_dunghan.toString() %>">
						<liferay-ui:message key="cong-van-di" /> &nbsp; <%= quantityOfDocSendNeedProcess %> &nbsp;
					</a>
				</label>
		<% 	} else { %>
		<label>
			<liferay-ui:message key="cong-van-di" />
		</label>
		<% 	} %>
				
		<% 	if (quantityOfDocSendNeedProcess <= 0) { %>
				<ul class="ind_ul">
					<li>
						<liferay-ui:message key="now-you-have-not-any-send-document-need-process" />
					</li>
				</ul>
		<% 	} else { %>
				<ul class="ind_ul">
					<li>
						 <a href="<%= details_cvdi_dunghan.toString() %>">
						 	<%= quantityOfDocSendNeedProcess %>&nbsp;
						 	<liferay-ui:message key="od-no-need-process"/>
						 </a>
					</li>
					<c:if test="<%= quantityOfDocSendExpireOfUser > 0 %>">
						<li>
							<a href="<%= details_cvdi_trehan.toString() %>">
								<%= quantityOfDocSendExpireOfUser %>&nbsp;
								<liferay-ui:message key="late-od-process"/>
							</a>
						</li>
					</c:if>
				</ul>
		<% } %>
	</div>