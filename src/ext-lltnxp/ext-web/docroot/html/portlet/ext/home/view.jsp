<%@ page contentType="text/html; charset=UTF-8" language="java"
	import="java.sql.*" errorPage=""%>
<%@ include file="/html/portlet/ext/home/init.jsp" %>
<%@page import="com.sgs.portlet.document.send.service.PmlEdmDocumentSendLocalService"%>
<%@page import="com.sgs.portlet.document.send.service.PmlEdmDocumentSendLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>
<%@page import="com.sgs.portlet.pmluser.service.PmlUserLocalServiceUtil"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt"%>
<%@page import="com.sgs.portlet.document.receipt.service.PmlEdmDocumentReceiptLocalServiceUtil"%>
<%@page import="com.sgs.portlet.pmluser.model.PmlUser"%>
<%@page import="com.sgs.portlet.pmluser.service.persistence.PmlUserUtil"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.sgs.portlet.document.model.PmlFileStatus"%>
<%@page import="com.sgs.portlet.document.service.persistence.PmlFileStatusUtil"%>
<%@page import="com.liferay.portal.service.permission.PortletPermissionUtil"%>
<%@page import="com.ext.portal.security.permission.ActionKeysExt"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.sgs.portlet.onedoor.service.PmlOneDoorReceiveFileLocalServiceUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.model.User"%>
<%
	String oneDoor = (String) renderRequest.getAttribute("oneDoor");
	String document = (String) renderRequest.getAttribute("document");
	String news = (String) renderRequest.getAttribute("news");
	String calendar = (String) renderRequest.getAttribute("calendar");
%>
<%@ include file="/html/_css/index.css"%>
<!-- truongsonsoft start 20090826 -->
<%@ include file="/html/_css/index.css"%>
<%
	User loginUser = (User) renderRequest.getAttribute("loginUser");
	String firstLogin = (String) renderRequest.getPortletSession().getAttribute("firstLogin", PortletSession.APPLICATION_SCOPE);
	if (loginUser != null && firstLogin == null ) {
		PortletSession session1 = renderRequest.getPortletSession();
		session1.setAttribute("firstLogin", "firstLogin", PortletSession.APPLICATION_SCOPE);
%>

	<%@page import="javax.portlet.PortletSession"%>
<%}%>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><liferay-ui:message key='doc-create-news'/></title>
<%--- Phan danh cho thong tin cong van ---%>
									<%
										//String fileStatusCode = "CVDEN_VANTHU_DANGXULY_CHUNG_dangxuly";
									
										String fileStatusCodeCVDen = "";
										String fileStatusCodeCVDi = "";
										if ((PortletPermissionUtil.contains(permissionChecker, plid, "SGS_HOME", ActionKeysExt.TIEPNHANCV) == true) ||
												(PortletPermissionUtil.contains(permissionChecker, plid, "SGS_HOME", ActionKeysExt.XLTHAYBGD) == true)) {
											fileStatusCodeCVDen = "CVDEN_VANTHU_DANGXULY_CHUNG_dangxuly";
											fileStatusCodeCVDi = "CVDI_VANTHU_DANGXULY_CHUNG_dangxuly";
										}
										else {
											fileStatusCodeCVDen = "CVDEN_TRUONGPHONG_DANGXULY_CHUNG_dangxuly";
											fileStatusCodeCVDi = "CVDI_TRUONGPHONG_DANGXULY_CHUNG_dangxuly";
										}
									
										PmlFileStatus fileStatusCVDen = PmlFileStatusUtil.findByFileStatusCode(fileStatusCodeCVDen).get(0);
										PmlFileStatus fileStatusCVDi = PmlFileStatusUtil.findByFileStatusCode(fileStatusCodeCVDi).get(0);
							// Duong dan den danh sach cong van den dung han
										PortletURL details_cvden_dunghan = new PortletURLImpl(request, "SGS_PCCCDOCUMENTRECEIPTPROCESS_INSTANCE_56nj", 89385, PortletRequest.RENDER_PHASE);
										details_cvden_dunghan.setParameter("struts_action", "/sgs/pcccdocumentreceiptprocess/view");
										details_cvden_dunghan.setParameter("statusId", fileStatusCVDen.getFileStatusId() + "");
										details_cvden_dunghan.setParameter("cachThucXuLy", "-1");
										// xuancong add start, them cac duong link chi tiet theo tung cach thuc xu ly
										// Chua xac dinh cach thuc xu ly
								// phmphuc update 20/08/2010 - khoi tao bien details_cvden_dunghan_chuaxdctxl
										// PortletURL details_cvden_dunghan_chuaxdctxl = details_cvden_dunghan;
										PortletURL details_cvden_dunghan_chuaxdctxl = new PortletURLImpl(request, "SGS_PCCCDOCUMENTRECEIPTPROCESS_INSTANCE_56nj", 89385, PortletRequest.RENDER_PHASE);
										details_cvden_dunghan_chuaxdctxl.setParameter("struts_action", "/sgs/pcccdocumentreceiptprocess/view");
										details_cvden_dunghan_chuaxdctxl.setParameter("statusId", fileStatusCVDen.getFileStatusId() + "");
								// phmphuc end update 20/08/2010
								// minh update 20100417	
										details_cvden_dunghan_chuaxdctxl.setParameter("cachThucXuLy", ""); // phmphuc open 02/08/2010
										//details_cvden_dunghan_chuaxdctxl.setParameter("cachThucXuLy", "-1");
								// end	minh update 20100417	
										// Luu tham khao
								// minh update 20100417		
										//PortletURL details_cvden_dunghan_luuthamkhao = details_cvden_dunghan;
										PortletURL details_cvden_dunghan_luuthamkhao = new PortletURLImpl(request, "SGS_PCCCDOCUMENTRECEIPTPROCESS_INSTANCE_56nj", 89385, PortletRequest.RENDER_PHASE);
										details_cvden_dunghan_luuthamkhao.setParameter("struts_action", "/sgs/pcccdocumentreceiptprocess/view");
										details_cvden_dunghan_luuthamkhao.setParameter("statusId", fileStatusCVDen.getFileStatusId() + "");
										details_cvden_dunghan_luuthamkhao.setParameter("cachThucXuLy", "1");
								// end	minh update 20100417			
										// Bao cao
								// minh update 20100417									
										//PortletURL details_cvden_dunghan_baocao = details_cvden_dunghan;
										PortletURL details_cvden_dunghan_baocao = new PortletURLImpl(request, "SGS_PCCCDOCUMENTRECEIPTPROCESS_INSTANCE_56nj", 89385, PortletRequest.RENDER_PHASE);
										details_cvden_dunghan_baocao.setParameter("struts_action", "/sgs/pcccdocumentreceiptprocess/view");
										details_cvden_dunghan_baocao.setParameter("statusId", fileStatusCVDen.getFileStatusId() + "");
										details_cvden_dunghan_baocao.setParameter("cachThucXuLy", "2");
								// end	minh update 20100417		
										// Phai soan vb tra loi
								// minh update 20100417	
										//PortletURL details_cvden_dunghan_phaisoanvbtl = details_cvden_dunghan;
										PortletURL details_cvden_dunghan_phaisoanvbtl = new PortletURLImpl(request, "SGS_PCCCDOCUMENTRECEIPTPROCESS_INSTANCE_56nj", 89385, PortletRequest.RENDER_PHASE);
										details_cvden_dunghan_baocao.setParameter("struts_action", "/sgs/pcccdocumentreceiptprocess/view");
										details_cvden_dunghan_baocao.setParameter("statusId", fileStatusCVDen.getFileStatusId() + "");
										details_cvden_dunghan_phaisoanvbtl.setParameter("cachThucXuLy", "3");
								// end	minh update 20100417		
							// Duong dan den danh sach cong van den tre han
									  	PortletURL details_cvden_trehan = new PortletURLImpl(request, "SGS_PCCCDOCUMENTRECEIPTPROCESS_INSTANCE_56nj", 89385, PortletRequest.RENDER_PHASE);
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
							
						//minh update 20100105
							//int quantityOfDocRecNeedProcess = PmlEdmDocumentReceiptLocalServiceUtil.countDocRecNeedProcess(PortalUtil.getUserId(renderRequest));
							//int quantityOfDocRecExpireOfUser = PmlEdmDocumentReceiptLocalServiceUtil.countTreHanDangXuLyChuyenVien_CVDen(PortalUtil.getUserId(renderRequest),0, null, null);
							List<Long> uesrList = new ArrayList<Long>();
							uesrList.add(PortalUtil.getUserId(renderRequest));
							int quantityOfDocRecNeedProcess = PmlEdmDocumentReceiptLocalServiceUtil.countByDocumentReceipt_Users_Status_DangXuLy(uesrList, fileStatusCVDen.getFileStatusId(), "0", "0");							
							int quantityOfDocRecExpireOfUser = PmlEdmDocumentReceiptLocalServiceUtil.countByDocumentReceipt_Users_Status_DangXuLy_TreHan(uesrList ,fileStatusCVDen.getFileStatusId(), "0", "0");
							//int quantityOfDocSendNeedProcess = PmlEdmDocumentSendLocalServiceUtil.countDocSendNeedProcess(PortalUtil.getUserId(renderRequest));
							//int quantityOfDocSendExpireOfUser = PmlEdmDocumentReceiptLocalServiceUtil.countTreHanDangXuLyChuyenVien_CVDi(PortalUtil.getUserId(renderRequest),0, null, null);
							int quantityOfDocSendNeedProcess = PmlEdmDocumentSendLocalServiceUtil.countByDocumentSend_Users_Status_DangXuLy(uesrList, fileStatusCVDi.getFileStatusId(), "0", "tatca");
							int quantityOfDocSendExpireOfUser = PmlEdmDocumentSendLocalServiceUtil.countByDocumentSend_Users_Status_DangXuLy_TreHan(uesrList, fileStatusCVDi.getFileStatusId(), "0", "tatca");
						//end
// xuancong add start -- Tinh v/ban den can xu ly chia theo cach thuc xu ly
							List<PmlEdmDocumentReceipt> lstDocRecNeedPro = PmlEdmDocumentReceiptLocalServiceUtil.findByDocumentReceipt_Users_Status_DangXuLy(uesrList, fileStatusCVDen.getFileStatusId(), "0", "0", QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
							int quanOfDocRecNeedProOnlyView = 0; // V/ban den can xu ly chi doc
							int quanOfDocRecNeedProMakeReport = 0; // V/ban den can xu ly phai bao cao
							int quanOfDocRecNeedProMakeReply = 0; // V/ban den can xu ly phai tao v/ban di tra loi
							int quanOfDocRecNeedProNoDefPro = 0; // V/ban den can xu ly chua xac dinh cach thuc xu ly
							String detailDRNP = ""; // Chuoi chi tiet
							if (!lstDocRecNeedPro.isEmpty()) { // Chi thuc hien khi co danh sach v/ban den can xu ly
								for (int idxDRNP = 0; idxDRNP < lstDocRecNeedPro.size(); idxDRNP++) {
									PmlEdmDocumentReceipt DRNPItem = (PmlEdmDocumentReceipt) lstDocRecNeedPro.get(idxDRNP);
									if (DRNPItem.getDocumentType().equalsIgnoreCase("1")) { // Chi doc
										quanOfDocRecNeedProOnlyView ++;
									} // end if
									else if (DRNPItem.getDocumentType().equalsIgnoreCase("2")) { // Bao cao
										quanOfDocRecNeedProMakeReport ++;
									} // end if
									else if (DRNPItem.getDocumentType().equalsIgnoreCase("3")) { // Soan v/ban tra loi
										quanOfDocRecNeedProMakeReply ++;
									} // end if
									else {
										quanOfDocRecNeedProNoDefPro ++;
									} // end else
								} // end for
								if (quanOfDocRecNeedProOnlyView > 0) {
									detailDRNP += String.valueOf(quanOfDocRecNeedProOnlyView) + "&nbsp;l\u01B0u tham kh\u1ea3o"; 
								} // end if
								if (quanOfDocRecNeedProMakeReport > 0) {
									if (!detailDRNP.equals("")) {
										detailDRNP += "&nbsp;";
									} // end if
									detailDRNP += String.valueOf(quanOfDocRecNeedProMakeReport) + "&nbsp;b\u00E1o c\u00E1o"; 
								} // end if
								if (quanOfDocRecNeedProMakeReply > 0) {
									if (!detailDRNP.equals("")) {
										detailDRNP += "&nbsp;";
									} // end if
									detailDRNP += String.valueOf(quanOfDocRecNeedProMakeReply) + "&nbsp;so\u1EA1n v\u0103n b\u1ea3n tr\u1EA3 l\u1EDDi"; 
								} // end if
								if (quanOfDocRecNeedProNoDefPro > 0) {
									if (!detailDRNP.equals("")) {
										detailDRNP += "&nbsp;";
									} // end if
									detailDRNP += String.valueOf(quanOfDocRecNeedProNoDefPro) + "&nbsp;ch\u01b0a ph\u00E2n c\u00f4ng x\u1eed l\u00fd"; 
								} // end if
								if (!detailDRNP.equals("")) {
									detailDRNP = "&nbsp;(" + detailDRNP + ")";
								}
							} // end if
							// xuancong add end
						%>
								<div class="title_categ">
										<liferay-ui:message key="nhac-viec"/>
								</div>
										<%--- Cong van den ---%>
										 <div class="boxcontent intleft">
										
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
										
										<%
										if (quantityOfDocRecNeedProcess <= 0) {
										%>
											<ul class="ind_ul">
												<li>
													<liferay-ui:message key="now-you-have-not-any-receive-document-need-process" />
												</li>
											</ul>
										<%
										}
										else {
										%>
											<ul class="ind_ul">
												<li>
													
													<c:if test="<%= quanOfDocRecNeedProOnlyView > 0 %>">
														<a href="<%= details_cvden_dunghan_luuthamkhao.toString() %>">
															<%= (String.valueOf(quanOfDocRecNeedProOnlyView) + "&nbsp;l\u01B0u tham kh\u1ea3o&nbsp;") %>
														</a>
													</c:if>
													<c:if test="<%= quanOfDocRecNeedProMakeReport > 0 %>">
														<a href="<%= details_cvden_dunghan_baocao.toString() %>">
															<%= (String.valueOf(quanOfDocRecNeedProMakeReport) + "&nbsp;b\u00E1o c\u00E1o&nbsp;") %>
														</a>
													</c:if>
													<c:if test="<%= quanOfDocRecNeedProMakeReply > 0 %>">
														<a href="<%= details_cvden_dunghan_phaisoanvbtl.toString() %>">
															<%= (String.valueOf(quanOfDocRecNeedProMakeReply) + "&nbsp;so\u1EA1n v\u0103n b\u1ea3n tr\u1EA3 l\u1EDDi&nbsp;") %>
														</a>
													</c:if>
													<c:if test="<%= quanOfDocRecNeedProNoDefPro > 0 %>">
														<a href="<%= details_cvden_dunghan_chuaxdctxl.toString() %>">
															<%= (String.valueOf(quanOfDocRecNeedProNoDefPro) + "&nbsp;ch\u01b0a ph\u00E2n c\u00f4ng x\u1eed l\u00fd&nbsp;") %>
														</a>
													</c:if>
													
												</li>
												<c:if test="<%= quantityOfDocRecExpireOfUser > 0 %>">
													<li>
														<a href="<%= details_cvden_trehan.toString() %>">
															<%= quantityOfDocRecExpireOfUser %>&nbsp;
															<liferay-ui:message key="late-od-process"/>
														</a>
													</li>
												</c:if>
											</ul>
										<%
										}
										%>
										<%--- Cong van di ---%>
										
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
				
										<%
										if (quantityOfDocSendNeedProcess <= 0) {
										%>
											<ul class="ind_ul">
												<li>
													<liferay-ui:message key="now-you-have-not-any-send-document-need-process" />
												</li>
											</ul>
										<%
										}
										else {
										%>
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
										<%
										}
										%>
							</div>
						<!-- Phan danh cho thong tin ho so -->
						<%
							// Duong dan den danh sach ho so chua nhan
										PortletURL sofilechuanhan = new PortletURLImpl(request, "SGS_ONEDOORPCCCPROCESS", 89356, PortletRequest.RENDER_PHASE);
										sofilechuanhan.setParameter("struts_action", "/sgs/onedoorpcccprocess/view");
										sofilechuanhan.setParameter("processValue", "sofilechuanhan");
										sofilechuanhan.setPortletMode(PortletMode.VIEW);
										sofilechuanhan.setWindowState(WindowState.NORMAL);
							// Duong dan den danh sach ho so can xu ly						
										PortletURL sofilecanxuly = new PortletURLImpl(request, "SGS_ONEDOORPCCCPROCESS", 89356, PortletRequest.RENDER_PHASE);
										sofilecanxuly.setParameter("struts_action", "/sgs/onedoorpcccprocess/view");
										sofilecanxuly.setParameter("processValue", "sofilecanxuly");
										sofilecanxuly.setPortletMode(PortletMode.VIEW);
										sofilecanxuly.setWindowState(WindowState.NORMAL);
							// Duong dan den ho so qua han
										PortletURL sofiledaquahan = new PortletURLImpl(request, "SGS_ONEDOORPCCCPROCESS", 89356, PortletRequest.RENDER_PHASE);
										sofiledaquahan.setParameter("struts_action", "/sgs/onedoorpcccprocess/view");
										sofiledaquahan.setParameter("processValue", "sofiledaquahan");
										sofiledaquahan.setPortletMode(PortletMode.VIEW);
										sofiledaquahan.setWindowState(WindowState.NORMAL);
							// Duong dan den ho so can bo sung
										PortletURL sofilechobosung = new PortletURLImpl(request, "SGS_ONEDOORPCCCPROCESS", 89356, PortletRequest.RENDER_PHASE);
										sofilechobosung.setParameter("struts_action", "/sgs/onedoorpcccprocess/view");
										sofilechobosung.setParameter("processValue", "sofilechobosung");
										sofilechobosung.setPortletMode(PortletMode.VIEW);
										sofilechobosung.setWindowState(WindowState.NORMAL);
							// Duong dan den tong so file can xu ly
										PortletURL tongsofile = new PortletURLImpl(request, "SGS_ONEDOORPCCCPROCESS", 89356, PortletRequest.RENDER_PHASE);
										tongsofile.setParameter("struts_action", "/sgs/onedoorpcccprocess/view");
										tongsofile.setPortletMode(PortletMode.VIEW);
										tongsofile.setWindowState(WindowState.NORMAL);
							/* yenlt close start 26/03/2010   
							int quantityOfRecordNotReceiveYet = PmlUserLocalServiceUtil.countFileChuaNhan(PortalUtil.getUserId(renderRequest), new Date());
							int quantityOfRecordReceived = PmlUserLocalServiceUtil.countFileDaNhan(PortalUtil.getUserId(renderRequest), new Date());
							int quantityOfRecordExpireISO = PmlUserLocalServiceUtil.countFileQuaHanISO(PortalUtil.getUserId(renderRequest), new Date());
							// Con thieu so luong ho so can bo sung
							 yenlt close end*/
							 
							//Yenlt update 26/03/2010
							List<String> typeList =  new ArrayList<String>();
							List<String> valueTypeList = new ArrayList<String>();
							SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
							DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
							Date date = new Date();
							String toDate = df.format(sdf.parse(sdf.format(date)));
							long userId = PortalUtil.getUserId(renderRequest);
							int quantityOfRecordNotReceiveYet = PmlOneDoorReceiveFileLocalServiceUtil.getListFileChuaNhanChuaHoanThanh(userId, typeList, valueTypeList, -1, -1, null).size(); 
							int quantityOfRecordExpireISO = PmlOneDoorReceiveFileLocalServiceUtil.getListFileQuaHanISOChuaHoanThanh(userId, toDate, typeList, valueTypeList, -1, -1, null).size();
							int quantityOfRecordSupplement = PmlOneDoorReceiveFileLocalServiceUtil.getListFileChoBoSungChuaHoanThanh(userId, typeList, valueTypeList, -1, -1, null).size();
							int quantityOfRecordProcess = PmlOneDoorReceiveFileLocalServiceUtil.getListFileCanXuLyTrongNgay(userId, toDate, typeList, valueTypeList, -1, -1, null).size();
							int sumOfRecordProcess = PmlOneDoorReceiveFileLocalServiceUtil.getListFileNeedProcess(userId, typeList, valueTypeList, -1, -1, null).size();
							//end 
						%>
								<div class="title_categ">
										<liferay-ui:message key="situation-process-record"/>
								</div>
								<div class="boxcontent">
										<%
										if (quantityOfRecordNotReceiveYet == 0 && 
												quantityOfRecordExpireISO == 0 &&
												quantityOfRecordSupplement == 0 &&
												quantityOfRecordProcess == 0 &&
												sumOfRecordProcess == 0) {
										%>
											<ul class="ind_ul">
												<li>
													<liferay-ui:message key="now-you-have-not-any-record-need-process" />
												</li>
											</ul>
										<%
										}
										else {
										%>
											<label>
												<liferay-ui:message key="now-you-have" />
											</label>
											<ul class="ind_ul">
												<c:if test="<%= quantityOfRecordNotReceiveYet > 0 %>">
													<li>
														<a href="<%= sofilechuanhan.toString() %>">
															<%= quantityOfRecordNotReceiveYet %>&nbsp;
															<liferay-ui:message key="record-not-receive" />
														</a> 
													</li>
												</c:if>
												<!--  yenlt close 02/04/2010
													<c:if test="</%= quantityOfRecordReceived > 0 %>">
														<li>
															<a href="</%= sofilecanxuly.toString() %>">
																</%= quantityOfRecordReceived %>&nbsp;
																<liferay-ui:message key="record-process-in-day" />
															</a>
														</li>
													</c:if>
													 -->
													 <!-- Yenlt update 02/04/2010 -->
													<c:if test="<%= quantityOfRecordProcess > 0 %>">
														<li>
															<a href="<%= sofilecanxuly.toString() %>">
																<%= quantityOfRecordProcess %>&nbsp;
																<liferay-ui:message key="record-process-in-day" />
															</a>
														</li>
													</c:if>
													<!-- end yenlt -->
													<c:if test="<%= quantityOfRecordExpireISO > 0 %>">
														<li>
															<a href="<%= sofiledaquahan.toString() %>">
																<%= quantityOfRecordExpireISO %>&nbsp;
																<liferay-ui:message key="late-record-process" />
															</a>
														</li>
													</c:if>
													<!-- Yenlt update 23/03/2010 -->
													<c:if test="<%= quantityOfRecordSupplement > 0 %>">
														<li>
															<a href="<%= sofilechobosung.toString() %>">
																<%= quantityOfRecordSupplement %>&nbsp;
																<liferay-ui:message key="doc-expect-complete" />
															</a>
														</li>
													</c:if>
													<!-- end yenlt -->
													<!-- Yenlt update 24052010 -->
													<c:if test="<%= sumOfRecordProcess > 0 %>">
														<li>
															<a href="<%= tongsofile.toString() %>">
																<%= sumOfRecordProcess %>&nbsp;
																<liferay-ui:message key="record-need-process" />
															</a>
														</li>
													</c:if>
													<!-- end yenlt 24052010-->
												<%---
												<a href="<%= sofilechobosung.toString() %>"><liferay-ui:message key="doc-expect-complete"/> :</a>
												---%>
											</ul>
										<%
										}
										%>
							</div>
	
<script language="javascript">
	/* hàm x? lý re chu?t vào nút Lich */
 function over_Lich() {
		var Id_lich = window.document.getElementById("<portlet:namespace />Id_lich");
		Id_lich.src = "http://" + window.location.host + "/html/_img/index/Left001002_o.png";
      }
	/* hàm x? lý re chu?t ra nút Lich */
function out_Lich() {    
		var Id_lich = window.document.getElementById("<portlet:namespace />Id_lich");
		Id_lich.src = "/html/_img/index/Left001002.png";
	}	
	/* hàm x? lý re chu?t vào nút Tin tuc */
	function over_TinTuc(ID) {            
		var Id_TinTuc = window.document.getElementById("<portlet:namespace />Id_TinTuc");
		Id_TinTuc.src = "http://" + window.location.host + "/html/_img/index/Left002002_o.png";
	}
	/* hàm x? lý re chu?t ra nút Tin tuc */
function out_TinTuc(ID) {            
		var Id_TinTuc = window.document.getElementById("<portlet:namespace />Id_TinTuc");
		Id_TinTuc.src = "http://" + window.location.host + "/html/_img/index/Left002002.png";
	}
function over_Doc() {
		var Id_OD = window.document.getElementById("<portlet:namespace />Id_OD");
		Id_OD.src = "http://" + window.location.host + "/html/_img/index/Left002003_o.png";
	}
function out_Doc() {
		var Id_OD = window.document.getElementById("<portlet:namespace />Id_OD");
		Id_OD.src = "http://" + window.location.host + "/html/_img/index/Left002003.png";
	}
	/* hàm x? lý re chu?t vào nút Ho so */
function over_Record(ID) {            
		var Id_Record = window.document.getElementById("<portlet:namespace />Id_Record");
		Id_Record.src = "http://" + window.location.host + "/html/_img/index/Left002004_o.png";
	}
	/* hàm x? lý re chu?t ra nút Ho so */
	function out_Record(ID) {            
		var Id_Record = window.document.getElementById("<portlet:namespace />Id_Record");
		Id_Record.src = "http://" + window.location.host + "/html/_img/index/Left002004.png";
	}
</script>