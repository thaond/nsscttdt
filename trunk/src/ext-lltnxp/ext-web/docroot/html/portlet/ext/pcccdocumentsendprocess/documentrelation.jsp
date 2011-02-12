<%@ include file="/html/portlet/ext/pcccdocumentsendprocess/init.jsp"%>

<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="com.liferay.portal.kernel.dao.search.DisplayTerms"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt"%>
<%@page import="com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentReceiptUtil"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.sgs.portlet.document.model.PmlEdmDocumentRelation"%>

<%@page import="com.sgs.portlet.document.service.persistence.PmlEdmDocumentRelationUtil"%>
<%@page import="com.sgs.portlet.pmlissuingplace.service.persistence.PmlEdmIssuingPlaceUtil"%>
<%@page import="com.sgs.portlet.document.send.model.PmlEdmDocumentSend"%>
<%@page import="com.sgs.portlet.document.send.service.persistence.PmlEdmDocumentSendUtil"%>
<%@page import="com.sgs.portlet.pmluser.model.PmlUser"%>
<%@page import="com.sgs.portlet.pmluser.service.persistence.PmlUserUtil"%>
<%@page import="com.sgs.portlet.department.service.persistence.DepartmentUtil"%>
<%@page import="com.liferay.portal.kernel.language.UnicodeLanguageUtil"%>
<%@page import="com.sgs.portlet.pcccdocumentreceiptprocess.search.PmlEdmDocumentRelationReceiptSearch"%>
<%@page import="com.sgs.portlet.pcccdocumentreceiptprocess.search.PmlEdmDocumentRelationReceiptDisplayTerms"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="java.util.Calendar"%>
<%@page import="com.sgs.portlet.pcccdocumentreceiptprocess.search.PmlEdmDocumentRelationReceiptSearchTerms"%>
<%@page import="com.sgs.portlet.document.receipt.service.PmlEdmDocumentReceiptLocalServiceUtil"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.portal.kernel.search.Sort"%>
<%@page import="com.liferay.portal.kernel.dao.search.RowChecker"%>
<%@page import="com.sgs.portlet.pcccdocumentsendprocess.search.PmlEdmDocumentRelationSendSearch"%>
<%@page import="com.sgs.portlet.pcccdocumentsendprocess.search.PmlEdmDocumentRelationSendDisplayTerms"%>
<%@page import="com.sgs.portlet.document.send.service.PmlEdmDocumentSendLocalServiceUtil"%><head>
	<link type="text/css" rel="stylesheet" href="/html/css/changeColorRow.css" />
	<link type="text/css" rel="stylesheet" href="/html/css/calendar-system.css" />
</head>
<script type="text/javascript" src="/html/js/calendar.js"></script>
<script type="text/javascript" src="/html/js/calendar-setup.js"></script>
<script type="text/javascript" src="/html/js/calendar-en.js"></script>
<script type="text/javascript" src="/html/js/_libJS/_libJS.js"></script>

<%
	String detailBackURL = ParamUtil.getString(request, "detailBackURL");

	String tabexist = ParamUtil.getString(request, "tabexist"); // Tab lien ket da ton tai
	if (tabexist.equals("")) {
		tabexist = "cvdi";
	}
	String tabnew = ParamUtil.getString(request, "tabnew"); // Tab lien ket moi
	if (tabnew.equals("")) {
		tabnew = "cvdi";
	}

	long documentId = ParamUtil.getLong(request, "documentId"); // Ma so van ban

	// Tao URL de tim kiem
	PortletURL portletURL = renderResponse.createActionURL();
	portletURL.setWindowState(WindowState.MAXIMIZED);
	portletURL.setParameter("struts_action", "/sgs/pcccdocumentsendprocess/documentrelation");
	portletURL.setParameter("documentId", String.valueOf(documentId));
	portletURL.setParameter("detailBackURL", detailBackURL);
	portletURL.setParameter("tabexist", tabexist);
	portletURL.setParameter("tabnew", tabnew);
	
	// Khai bao cac bien de luu tru du lieu
	String cmd = ParamUtil.getString(request, Constants.CMD); // Luu hanh dong tren form
	
	// ***** Tao phan dien ta cho lien ket van ban start *****
	String linkDesc = ""; // Dien ta lien ket van ban
	try {
		PmlEdmDocumentSend tmpDocSend = PmlEdmDocumentSendUtil.findByPrimaryKey(documentId);
		// Lay ten nguoi soan thao
		String creatorName = "";
		if (tmpDocSend.getEditorId() > 0) {
			try {
				PmlUser creator = PmlUserUtil.findByPrimaryKey(tmpDocSend.getEditorId());
				creatorName = creator.getLastName() + " " + creator.getMiddleName() + " " + creator.getFirstName();
			}
			catch (Exception ex) {
				System.out.println("Khong doc duoc nguoi dung:" + String.valueOf(tmpDocSend.getEditorId()));
			}
		}
		linkDesc += LanguageUtil.get(pageContext, "link-for-document-send") + ". ";
		linkDesc += LanguageUtil.get(pageContext, "receipt.creator") + ": " + creatorName + ". ";
		linkDesc += LanguageUtil.get(pageContext, "receipt.briftcontent") + ": " + tmpDocSend.getBriefContent() + ". ";
	}
	catch (Exception ex) {
		System.out.println("Khong doc duoc van ban di so:" + String.valueOf(documentId));
	}
	// ***** Tao phan dien ta cho lien ket van ban end *****
	SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
%>

<div class="boxcontent">
<form action="<%= portletURL.toString() %>" enctype="multipart/form-data" method="post" name="<portlet:namespace />fm">
	<input type="hidden" name="<portlet:namespace /><%= Constants.CMD %>" />
	<input type="hidden" name="<portlet:namespace />documentId" value="<%= documentId %>" />
	<input type="hidden" name="<portlet:namespace />delDocReceiptIds" />
	<input type="hidden" name="<portlet:namespace />delDocSendIds" />
	<input type="hidden" name="<portlet:namespace />addDocReceiptIds" />
	<input type="hidden" name="<portlet:namespace />addDocSendIds" />
	<input type="hidden" name="<portlet:namespace />detailBackURL" value="<%= HtmlUtil.escape(detailBackURL) %>" />

	<fieldset class="filborder">
	<label class="laborder"><liferay-ui:message key="link-document-exist"/></label>
		<div style="text-align: left;">
			<span>
				<label><%= linkDesc %></label>
			</span>
		</div>
		<div class="separator"><!-- --></div>
		<liferay-ui:tabs
			names="cvden,cvdi"
			param="tabexist"
			url="<%= portletURL.toString() %>"
			value="<%= tabexist %>"
		/>
		<div class="boxcontent_Tab">
		<%
		// Lay danh sach van ban den va van ban di lien quan den van ban den
		List<Long> relDocReceiptIds = new ArrayList<Long>();
		List<Long> relDocSendIds = new ArrayList<Long>();
		// Lay danh sach lien ket co left la van ban dang xet
		List<PmlEdmDocumentRelation> relDocLefts = 
			PmlEdmDocumentRelationUtil.findByDocLeftId_LeftIsReceipt(documentId, false);
		if (!relDocLefts.isEmpty()) {
			// Duyet danh sach de lay ra ma so
			for (int idxDL = 0; idxDL < relDocLefts.size(); idxDL ++) {
				PmlEdmDocumentRelation tmpDR = relDocLefts.get(idxDL);
				if (tmpDR.getRightIsReceipt() == true && !relDocReceiptIds.contains(tmpDR.getDocRightId())) { 
					// Van ban den
					relDocReceiptIds.add(tmpDR.getDocRightId());
				}
				else if (tmpDR.getRightIsReceipt() == false && !relDocSendIds.contains(tmpDR.getDocRightId())) {
					// Van ban di
					relDocSendIds.add(tmpDR.getDocRightId());
				}
			}
		}
		// Lay danh sach lien ket co right la van ban dang xet
		List<PmlEdmDocumentRelation> relDocRights = 
			PmlEdmDocumentRelationUtil.findByDocRightId_RightIsReceipt(documentId, false);
		if (!relDocRights.isEmpty()) {
			// Duyet danh sach de lay ma so
			for (int idxDR = 0; idxDR < relDocRights.size(); idxDR ++) {
				PmlEdmDocumentRelation tmpDR = relDocRights.get(idxDR);
				if (tmpDR.getLeftIsReceipt() == true && !relDocReceiptIds.contains(tmpDR.getDocLeftId())) {
					// Van ban den
					relDocReceiptIds.add(tmpDR.getDocLeftId());
				}
				else if (tmpDR.getLeftIsReceipt() == false && !relDocSendIds.contains(tmpDR.getDocLeftId())) {
					// Van ban di
					relDocSendIds.add(tmpDR.getDocLeftId());
				}
			}
		}
		%>
		<c:choose>
			<c:when test='<%= tabexist.equals("cvden") %>'>
				<table class="taglib-search-iterator table-pml" cellspacing="0" width="100%">	
				<tr class="portlet-section-header results-header" >
						<td width="5%"><liferay-ui:message key="delete" /></td>
						<td width="15%"><liferay-ui:message key="pccc-cvdtn-sohieu" /></td>
						<td width="10%"><liferay-ui:message key="pccc-cvdtn-soCVden" /></td>
						<td width="30%"><liferay-ui:message key="pccc-cvdtn-noiphathanh" /></td>
						<td><liferay-ui:message key="pccc-cvdtn-trichyeu" /></td>
					</tr>
					<%
					// Duyet danh sach relDocReceiptIds de xuat ra tr trong table
					if (!relDocReceiptIds.isEmpty()) {
						int k = 0;
						for (int idxDR = 0; idxDR < relDocReceiptIds.size(); idxDR ++) {
							PmlEdmDocumentReceipt tmpDocReceipt = null;
							try {
								tmpDocReceipt = PmlEdmDocumentReceiptUtil.findByPrimaryKey(relDocReceiptIds.get(idxDR));
								k ++;
							}
							catch (Exception ex) {
								System.out.println("Khong doc duoc van ban den so:" + String.valueOf(relDocReceiptIds.get(idxDR)));
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
									<td style="text-align: center;">
										<input type="checkbox" name="<portlet:namespace />chkDocReceiptExist" value="<%= tmpDocReceipt.getDocumentReceiptId() %>" title="<%= LanguageUtil.get(pageContext, "select-to-delete") %>" />
									</td>
									<td><%= tmpDocReceipt.getDocumentReference() %></td>
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
			</c:when>
			<c:when test='<%= tabexist.equals("cvdi") %>'>
				<table class="taglib-search-iterator table-pml" cellspacing="0" width="100%">	
				<tr class="portlet-section-header results-header" >
						<td width="5%"><liferay-ui:message key="delete" /></td>
						<td width="15%"><liferay-ui:message key="receipt.creator" /></td>
						<td width="20%"><liferay-ui:message key="receipt.department" /></td>
						<td width="25%"><liferay-ui:message key="receipt.receiveplace" /></td>
						<td><liferay-ui:message key="receipt.briftcontent" /></td>
					</tr>
					<%
					// Duyet danh sach relDocSendIds de xuat ra tr trong table
					if (!relDocSendIds.isEmpty()) {
						int k = 0;
						for (int idxDS = 0; idxDS < relDocSendIds.size(); idxDS ++) {
							PmlEdmDocumentSend tmpDocSend = null;
							try {
								tmpDocSend = PmlEdmDocumentSendUtil.findByPrimaryKey(relDocSendIds.get(idxDS));
								k ++;
							}
							catch (Exception ex) {
								System.out.println("Khong doc duoc van ban di so:" + String.valueOf(relDocSendIds.get(idxDS)));
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
									<td >
										<input type="checkbox" name="<portlet:namespace />chkDocSendExist" value="<%= tmpDocSend.getDocumentSendId() %>" title="<%= LanguageUtil.get(pageContext, "select-to-delete") %>" />
									</td>
									<td><%= nguoiSTDesc %></td>
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
			</c:when>
		</c:choose>		
		</div>
</fieldset>
		
<fieldset class="filborder">
	<label class="laborder"><liferay-ui:message key="create-link-document-new"/></label>
			<liferay-ui:tabs
				names="cvden,cvdi"
				param="tabnew"
				url="<%= portletURL.toString() %>"
				value="<%= tabnew %>"
			/>
			<div class="boxcontent_Tab">
			<c:choose>
				<c:when test='<%= tabnew.equals("cvden") %>'>
					<%
					String ngayPHFrom = "01/01/" + String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
					String ngayPHTo = "31/12/" + String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
					
					PmlEdmDocumentRelationReceiptSearch searchContainerReceipt = 
						new PmlEdmDocumentRelationReceiptSearch(renderRequest, portletURL);
					searchContainerReceipt.setRowChecker(new RowChecker(renderResponse, "center", "middle", 1, "fm", "chkReceiptAll", "chkReceiptItem"));
					
					PmlEdmDocumentRelationReceiptDisplayTerms displayTermReceipt = 
						(PmlEdmDocumentRelationReceiptDisplayTerms) searchContainerReceipt.getDisplayTerms();

					if (displayTermReceipt.getNgayPhatHanhTu().length() == 10) {
						ngayPHFrom = displayTermReceipt.getNgayPhatHanhTu();
					}
					if (displayTermReceipt.getNgayPhatHanhDen().length() == 10) {
						ngayPHTo = displayTermReceipt.getNgayPhatHanhDen();
					}
					
					int totalReceipt = 
						PmlEdmDocumentReceiptLocalServiceUtil.countBySD_SNB_ND_NPH_TY_noRelation(user.getCompanyId(), 
								(displayTermReceipt.getSoHieuGoc().length() > 0) ? displayTermReceipt.getSoHieuGoc() + "*" : "", 
								(displayTermReceipt.getSoNoiBo().length() > 0) ? displayTermReceipt.getSoNoiBo() + "*" : "", 
								format.parse(ngayPHFrom), format.parse(ngayPHTo), 
								displayTermReceipt.getNoiPhatHanh(), displayTermReceipt.getTrichYeu(), relDocReceiptIds);

					searchContainerReceipt.setTotal(totalReceipt);

					List<Long> resultReceipts = 
						PmlEdmDocumentReceiptLocalServiceUtil.searchBySD_SNB_ND_NPH_TY_noRelation(user.getCompanyId(), 
								(displayTermReceipt.getSoHieuGoc().length() > 0) ? displayTermReceipt.getSoHieuGoc() + "*" : "", 
								(displayTermReceipt.getSoNoiBo().length() > 0) ? displayTermReceipt.getSoNoiBo() + "*" : "", 
								format.parse(ngayPHFrom), format.parse(ngayPHTo), 
								displayTermReceipt.getNoiPhatHanh(), displayTermReceipt.getTrichYeu(), relDocReceiptIds, 
								"", Sort.STRING_TYPE, false, searchContainerReceipt.getStart(), searchContainerReceipt.getEnd());

					searchContainerReceipt.setResults(resultReceipts);
					List resultRowReceipts = searchContainerReceipt.getResultRows();
					for (int idxR = 0; idxR < (!resultReceipts.isEmpty() ? resultReceipts.size() : 0); idxR ++) {
						PmlEdmDocumentReceipt docRecItem = null;
						try {
							docRecItem = PmlEdmDocumentReceiptUtil.findByPrimaryKey(resultReceipts.get(idxR)).toEscapedModel();
							
							ResultRow rowReceipt = new ResultRow((Long)resultReceipts.get(idxR) , resultReceipts.get(idxR), idxR);
							// Stt
							rowReceipt.addText(String.valueOf(idxR + 1));

							// So hieu goc
							rowReceipt.addText(docRecItem.getDocumentReference());

							// So noi bo
							rowReceipt.addText(docRecItem.getNumberDocumentReceipt());

							// Noi ban hanh
							String issPlaceDesc = "";
							if (docRecItem.getIssuingPlaceId().trim().length() > 0) {
								try {
									issPlaceDesc = PmlEdmIssuingPlaceUtil.findByPrimaryKey(docRecItem.getIssuingPlaceId()).getIssuingPlaceName();
								}
								catch (Exception ex) {
									// Do nothing
								}
							}
							else {
								issPlaceDesc = docRecItem.getIssuingPlaceOtherName();
							}
							rowReceipt.addText(issPlaceDesc);
							
							// Trich yeu
							rowReceipt.addText(docRecItem.getBriefContent());
							
							// Add result row
							resultRowReceipts.add(rowReceipt);
							
						}
						catch (Exception ex) {
							System.out.println("Khong doc duoc van ban den so:" + String.valueOf(resultReceipts.get(idxR)));
						}
					}
					%>
					<table class="lfr-table qlcv-table-general" cellspacing="0" width="100%">
						<tr class="qlcv-tr-general">
							<td class="qlcv-td-title-general" width="15%">
								<liferay-ui:message key="pccc-cvdtn-sohieu" />:<br />
								<input name="<portlet:namespace /><%= displayTermReceipt.SOHIEUGOC %>" class="qlcv-form-field" type="text" value="<%= HtmlUtil.escape(displayTermReceipt.getSoHieuGoc()) %>" />
							</td>
							<td class="qlcv-td-title-general" width="15%">
								<liferay-ui:message key="pccc-cvdtn-soCVden" />:<br />
								<input name="<portlet:namespace /><%= displayTermReceipt.SONOIBO %>" class="qlcv-form-field" type="text" value="<%= HtmlUtil.escape(displayTermReceipt.getSoNoiBo()) %>" />
							</td>
							<td class="qlcv-td-title-general" width="20%">
								<liferay-ui:message key="pccc-cvdtn-noiphathanh" />:<br />
								<input name="<portlet:namespace /><%= displayTermReceipt.NOIPHATHANH %>" class="qlcv-form-field" type="text" value="<%= HtmlUtil.escape(displayTermReceipt.getNoiPhatHanh()) %>" />
							</td>
							<td class="qlcv-td-title-general" width="20%">
								<liferay-ui:message key="pccc-cvdtn-trichyeu" />:<br />
								<input name="<portlet:namespace /><%= displayTermReceipt.TRICHYEU %>" class="qlcv-form-field" type="text" value="<%= HtmlUtil.escape(displayTermReceipt.getTrichYeu()) %>" />
							</td>
							<td class="qlcv-td-title-general">
								<liferay-ui:message key="pccc-cvdtn-ngayden" />:<br />
								<input style="width: 80px;" type="text" name="<portlet:namespace/><%= displayTermReceipt.NGAYPHATHANHTU %>" id="ngayPHFrom" value="<%= ngayPHFrom %>">
								<img id="cal-ngayPHFrom" src="/html/images/cal.gif" onclick="callCalendar('ngayPHFrom', 'cal-ngayPHFrom')"/>
								&nbsp;
								<input style="width: 80px;" type="text" name="<portlet:namespace/><%= displayTermReceipt.NGAYPHATHANHDEN %>" id="ngayPHTo" value="<%= ngayPHTo %>">
								<img id="cal-ngayPHTo" src="/html/images/cal.gif" onclick="callCalendar('ngayPHTo', 'cal-ngayPHTo')"/>
							</td>
						</tr>
					</table>
					
					<br />
					
					<div style="text-align: left;">
						<input type="button" value='<liferay-ui:message key="search" />' onClick="<portlet:namespace />searchDocReceipt();" />
					</div>
					<div class="separator"><!-- --></div>
					<liferay-ui:search-iterator searchContainer="<%= searchContainerReceipt %>" />
				</c:when>
				<c:when test='<%= tabnew.equals("cvdi") %>'>
					<%
					PmlEdmDocumentRelationSendSearch searchContainerSend = 
						new PmlEdmDocumentRelationSendSearch(renderRequest, portletURL);
					searchContainerSend.setRowChecker(new RowChecker(renderResponse, "center", "middle", 1, "fm", "chkSendAll", "chkSendItem"));
					
					PmlEdmDocumentRelationSendDisplayTerms displayTermSend = 
						(PmlEdmDocumentRelationSendDisplayTerms) searchContainerSend.getDisplayTerms();

					int totalSend = 
						PmlEdmDocumentSendLocalServiceUtil.countBySPH_PST_NN_TY_noRelation(user.getCompanyId(), 
								(displayTermSend.getSoPhatHanh().length() > 0) ? displayTermSend.getSoPhatHanh() + "*" : "", 
								displayTermSend.getPhongSoanThao(),
								displayTermSend.getNoiNhan(), displayTermSend.getTrichYeu(), relDocSendIds);

					List<Long> resultSends = 
						PmlEdmDocumentSendLocalServiceUtil.searchBySPH_PST_NN_TY_noRelation(user.getCompanyId(), 
								(displayTermSend.getSoPhatHanh().length() > 0) ? displayTermSend.getSoPhatHanh() + "*" : "", 
								displayTermSend.getPhongSoanThao(),
								displayTermSend.getNoiNhan(), displayTermSend.getTrichYeu(), relDocSendIds,  
								"", Sort.STRING_TYPE, false, searchContainerSend.getStart(), searchContainerSend.getEnd()); 

					

					searchContainerSend.setTotal(totalSend);
					searchContainerSend.setResults(resultSends);
					List resultRowSends = searchContainerSend.getResultRows();
					for (int idxS = 0; idxS < (!resultSends.isEmpty() ? resultSends.size() : 0); idxS ++) {
						PmlEdmDocumentSend docSendItem = null;
						try {
							docSendItem = PmlEdmDocumentSendUtil.findByPrimaryKey(resultSends.get(idxS)).toEscapedModel();
							// Lay ten nguoi soan thao va phong soan thao
							String nguoiSTSC = "";
							String phongSTSC = "";
							if (docSendItem.getEditorId() > 0) {
								try {
									PmlUser tmpUserSC = PmlUserUtil.findByPrimaryKey(docSendItem.getEditorId());
									nguoiSTSC = tmpUserSC.getLastName() + " " + tmpUserSC.getMiddleName() + " " + tmpUserSC.getFirstName();
									phongSTSC = DepartmentUtil.findByPrimaryKey(tmpUserSC.getDepartmentsId()).getDepartmentsName();
								}
								catch (Exception ex) {
									System.out.println("Co loi khi lay nguoi dung va phong ban cua nguoi dung:" + docSendItem.getEditorId());
								}
							}
							
							ResultRow rowSend = new ResultRow((Long)resultSends.get(idxS) , resultSends.get(idxS), idxS);
							// Stt
							rowSend.addText(String.valueOf(idxS + 1));

							// So phat hanh
							rowSend.addText(docSendItem.getDocumentReference());

							// Nguoi soan thao
							rowSend.addText(nguoiSTSC);

							// Phong soan thao
							rowSend.addText(phongSTSC);

							// Noi nhan
							rowSend.addText(docSendItem.getReceivingPlace());
							
							// Trich yeu
							rowSend.addText(docSendItem.getBriefContent());
							
							// Add result row
							resultRowSends.add(rowSend);
							
						}
						catch (Exception ex) {
							System.out.println("Khong doc duoc van ban di so:" + String.valueOf(resultSends.get(idxS)));
						}
					}
					%>
					<table class="lfr-table qlcv-table-general" cellspacing="0" width="100%">
						<tr class="qlcv-tr-general">
							<td class="qlcv-td-title-general" width="20%">
								<liferay-ui:message key="so-phat-hanh" />:<br />
								<input name="<portlet:namespace /><%= displayTermSend.SOPHATHANH %>" class="qlcv-form-field" type="text" value="<%= HtmlUtil.escape(displayTermSend.getSoPhatHanh()) %>" />
							</td>
							<td class="qlcv-td-title-general" width="25%">
								<liferay-ui:message key="phong-soan-thao" />:<br />
								<input name="<portlet:namespace /><%= displayTermSend.PHONGSOANTHAO %>" class="qlcv-form-field" type="text" value="<%= HtmlUtil.escape(displayTermSend.getPhongSoanThao()) %>" />
							</td>
							<td class="qlcv-td-title-general" width="25%">
								<liferay-ui:message key="noi-nhan" />:<br />
								<input name="<portlet:namespace /><%= displayTermSend.NOINHAN %>" class="qlcv-form-field" type="text" value="<%= HtmlUtil.escape(displayTermSend.getNoiNhan()) %>" />
							</td>
							<td class="qlcv-td-title-general">
								<liferay-ui:message key="trich-yeu" />:<br />
								<input name="<portlet:namespace /><%= displayTermSend.TRICHYEU %>" class="qlcv-form-field" type="text" value="<%= HtmlUtil.escape(displayTermSend.getTrichYeu()) %>" />
							</td>
						</tr>
					</table>
					
					<br />
					
					<div style="text-align: left;">
						<input type="button" value='<liferay-ui:message key="search" />' onClick="<portlet:namespace />searchDocSend();" />
					</div>
					<div class="separator"><!-- --></div>
					<liferay-ui:search-iterator searchContainer="<%= searchContainerSend %>" />
				</c:when>
			</c:choose>
			</div>
</fieldset>
<div id="table-button">
				<input class="button" type="button" value='<liferay-ui:message key="delete-link-document-old" />' onclick="<portlet:namespace />deleteLinkDocExist();" />
				<input class="button" type="button" value='<liferay-ui:message key="add-link-document-new" />' onclick="<portlet:namespace />addNewLinkDoc();" />
				<input class="button" type="button" value='<liferay-ui:message key="back" />' onclick="location.href='<%= detailBackURL %>'" />
</div>
</form>
</div>

<script language="javascript">
	/**
	 * Kiem tra ngay phat hanh phai nhap de tim kiem van ban den
	 */
	function <portlet:namespace />checkForSearchReceipt() {
		var examObj = null; // Doi tuong dung de kiem tra
		var ngayPHFrom = document.getElementById("ngayPHFrom");
		var ngayPHTo = document.getElementById("ngayPHTo");
		// Kiem tra ngay bat dau phai nhap theo dinh dang
		if (ngayPHFrom != null && !isDate(ngayPHFrom.value)) {
			alert("<liferay-ui:message key='please-check-date-follow-format-ddmmyyyy' />");
			ngayPHFrom.select();
			if (ngayPHFrom.disabled == false && ngayPHFrom.readOnly == false) ngayPHFrom.focus();
			return false;
		}
		// Kiem tra ngay ket thuc phai nhap theo dinh dang
		if (ngayPHTo != null && !isDate(ngayPHTo.value)) {
			alert("<liferay-ui:message key='please-check-date-follow-format-ddmmyyyy' />");
			ngayPHTo.select();
			if (ngayPHTo.disabled == false && ngayPHTo.readOnly == false) ngayPHTo.focus();
			return false;
		}
		// Kiem tra ngay bat dau va ngay ket thuc phu hop voi nhau
		if (ngayPHFrom != null && ngayPHTo != null) {
			if (compare2Date(ngayPHFrom.value, ngayPHTo.value) > 0) {
				alert("<liferay-ui:message key='date-start-cannot-greater-than-date-end' />");
				ngayPHFrom.select();
				if (ngayPHFrom.disabled == false && ngayPHFrom.readOnly == false) ngayPHFrom.focus();
				return false;
			}
		}
		return true;
	}
	/**
	 * Tim van ban den, kiem tra ngay phat hanh phai co
	 */
	function <portlet:namespace />searchDocReceipt() {
		// Goi ham kiem tra ngay
		if (<portlet:namespace />checkForSearchReceipt() == false) return;
		// Submit form
		document.<portlet:namespace />fm.submit();
	}
	/**
	 * Tim van ban di
	 */
	function <portlet:namespace />searchDocSend() {
		// Submit form (render URL)
		document.<portlet:namespace />fm.submit();
	}
	/*
	 * Lay danh sach ma so van ban can xoa lien ket va luu vao hidden
	 */
	function <portlet:namespace />getDelDocLinkId() {
		// Lay cac ma so van ban den can xoa lien ket de luu vao hidden
		var delDocReceiptIds = ""; // Danh sach ma so van ban den can xoa
		var chkDelRecArr = [];
		if (_getBrowserName() == "firefox" || _getBrowserName() == "chrome") {
			chkDelRecArr = document.getElementsByName("<portlet:namespace />chkDocReceiptExist");
		}
		else if (_getBrowserName() == "msie") { // IE
			var allTags = document.getElementsByTagName("input");
			for (i = 0; i < allTags.length; i ++) {
				if (allTags[i].type == "checkbox" && allTags[i].name == "<portlet:namespace />chkDocReceiptExist") {
					chkDelRecArr.push(allTags[i]);
				}
			}
		}
		for (var idx = 0; idx < chkDelRecArr.length; idx ++) {
			if (chkDelRecArr[idx].checked == true) {
				if (delDocReceiptIds != "") {
					delDocReceiptIds += ":";
				}
				delDocReceiptIds += chkDelRecArr[idx].value;
			}
		}
		document.<portlet:namespace />fm.<portlet:namespace />delDocReceiptIds.value = delDocReceiptIds;
		// Lay cac ma so van ban di can xoa lien ket de luu vao hidden
		var delDocSendIds = ""; // Danh sach ma so van ban di can xoa
		var chkDelSendArr = [];
		if (_getBrowserName() == "firefox" || _getBrowserName() == "chrome") {
			chkDelSendArr = document.getElementsByName("<portlet:namespace />chkDocSendExist");
		}
		else if (_getBrowserName() == "msie") { // IE
			var allTags = document.getElementsByTagName("input");
			for (i = 0; i < allTags.length; i ++) {
				if (allTags[i].type == "checkbox" && allTags[i].name == "<portlet:namespace />chkDocSendExist") {
					chkDelSendArr.push(allTags[i]);
				}
			}
		}
		for (idx = 0; idx < chkDelSendArr.length; idx ++) {
			if (chkDelSendArr[idx].checked == true) {
				if (delDocSendIds != "") {
					delDocSendIds += ":";
				}
				delDocSendIds += chkDelSendArr[idx].value;
			}
		}
		document.<portlet:namespace />fm.<portlet:namespace />delDocSendIds.value = delDocSendIds;
	}
	/**
	 * Kiem tra co lien ket van ban den hoac di duoc chon truoc khi xoa
	 */
	function <portlet:namespace />checkForDelLink() {
		var delDocReceiptIds = document.<portlet:namespace />fm.<portlet:namespace />delDocReceiptIds;
		var delDocSendIds = document.<portlet:namespace />fm.<portlet:namespace />delDocSendIds;
		if (delDocReceiptIds.value == "" && delDocSendIds.value == "") {
			alert("<liferay-ui:message key='please-select-link-document-before-delete' />");
			return false;
		}
		return true;
	}
	/**
	 * Xoa lien ket da ton tai
	 */
	function <portlet:namespace />deleteLinkDocExist() {
		// Goi ham lay ma so can xoa va luu vao hidden
		<portlet:namespace />getDelDocLinkId();
		// Kiem tra co lien ket can xoa truoc khi xoa
		if (<portlet:namespace />checkForDelLink() == false) return;
		// Submit form
		if (confirm("<liferay-ui:message key='you-want-delete-links-document' />")) {
			document.<portlet:namespace />fm.<portlet:namespace /><%= Constants.CMD %>.value = "<%= Constants.DELETE %>";
			document.<portlet:namespace />fm.submit();
		}
	}
	/*
	 * Lay danh sach ma so van ban can them lien ket va luu vao hidden
	 */
	function <portlet:namespace />getAddDocLinkId() {
		// Lay cac ma so van ban den can them lien ket de luu vao hidden
		var addDocReceiptIds = ""; // Danh sach ma so van ban den can them lien ket
		var chkAddRecArr = []; // Mang cac checkbox van ban den can them lien ket
		if (_getBrowserName() == "firefox" || _getBrowserName() == "chrome") {
			chkAddRecArr = document.getElementsByName("<portlet:namespace />chkReceiptItem");
		}
		else if (_getBrowserName() == "msie") { // IE
			var allTags = document.getElementsByTagName("input");
			for (i = 0; i < allTags.length; i ++) {
				if (allTags[i].type == "checkbox" && allTags[i].name == "<portlet:namespace />chkReceiptItem") {
					chkAddRecArr.push(allTags[i]);
				}
			}
		}
		for (var idx = 0; idx < chkAddRecArr.length; idx ++) {
			if (chkAddRecArr[idx].checked == true) {
				if (addDocReceiptIds != "") {
					addDocReceiptIds += ":";
				}
				addDocReceiptIds += chkAddRecArr[idx].value;
			}
		}
		document.<portlet:namespace />fm.<portlet:namespace />addDocReceiptIds.value = addDocReceiptIds;
		// Lay cac ma so van ban di can them lien ket de luu vao hidden
		var addDocSendIds = ""; // Danh sach ma so van ban di can them lien ket
		var chkAddSendArr = []; // Mang cac checkbox de chon van ban di can them lien ket 
		if (_getBrowserName() == "firefox" || _getBrowserName() == "chrome") {
			chkAddSendArr = document.getElementsByName("<portlet:namespace />chkSendItem");
		}
		else if (_getBrowserName() == "msie") { // IE
			var allTags = document.getElementsByTagName("input");
			for (i = 0; i < allTags.length; i ++) {
				if (allTags[i].type == "checkbox" && allTags[i].name == "<portlet:namespace />chkSendItem") {
					chkAddSendArr.push(allTags[i]);
				}
			}
		}
		for (idx = 0; idx < chkAddSendArr.length; idx ++) {
			if (chkAddSendArr[idx].checked == true) {
				if (addDocSendIds != "") {
					addDocSendIds += ":";
				}
				addDocSendIds += chkAddSendArr[idx].value;
			}
		}
		document.<portlet:namespace />fm.<portlet:namespace />addDocSendIds.value = addDocSendIds;
	}
	/**
	 * Kiem tra co lien ket van ban den hoac di duoc chon truoc khi them
	 */
	function <portlet:namespace />checkForAddLink() {
		var addDocReceiptIds = document.<portlet:namespace />fm.<portlet:namespace />addDocReceiptIds;
		var addDocSendIds = document.<portlet:namespace />fm.<portlet:namespace />addDocSendIds;
		if (addDocReceiptIds.value == "" && addDocSendIds.value == "") {
			alert("<liferay-ui:message key='please-select-link-document-before-add' />");
			return false;
		}
		return true;
	}
	/**
	 * Them lien ket van ban moi
	 */
	function <portlet:namespace />addNewLinkDoc() {
		// Goi ham lay danh sach ma so van ban can them lien ket va luu vao hidden
		<portlet:namespace />getAddDocLinkId();
		// Kiem tra co lien ket duoc chon truoc khi them
		if (<portlet:namespace />checkForAddLink() == false) return;
		// Submit form
		document.<portlet:namespace />fm.<portlet:namespace /><%= Constants.CMD %>.value = "<%= Constants.ADD %>";
		document.<portlet:namespace />fm.submit();
	}
</script>
