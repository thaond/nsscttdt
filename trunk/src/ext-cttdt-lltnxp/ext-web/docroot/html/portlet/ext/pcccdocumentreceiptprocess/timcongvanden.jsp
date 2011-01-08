<%@ include file="/html/portlet/ext/pcccdocumentreceipt/init.jsp" %>
<%@page import="com.sgs.portlet.pml_edm_docconfuser.model.PmlEdmDocConfUser"%>
<%@page import="com.sgs.portlet.pml_edm_docconfuser.service.PmlEdmDocConfUserLocalServiceUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.StringTokenizer"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.sgs.portlet.document.receipt.search.PmlEdmDocumentReceiptSearch"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.sgs.portlet.document.receipt.search.PmlEdmDocumentReceiptSearchTerms"%>
<%@page import="com.sgs.portlet.document.receipt.service.PmlEdmDocumentReceiptLocalServiceUtil"%>
<%@page import="java.util.Date"%>
<%@page import="com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@page import="com.liferay.portal.RequiredRoleException"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.sgs.portlet.pmlissuingplace.service.persistence.PmlEdmIssuingPlaceUtil"%>
<%@page import="com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentTypeUtil"%>
<%@page import="com.liferay.portlet.PortletURLImpl"%>
<%@page import="com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile"%>
<%@page import="com.sgs.portlet.document.receipt.service.persistence.PmlEdmAttachedFileUtil"%>
<%@page import="com.sgs.portlet.document.receipt.model.impl.PmlEdmDocumentReceiptImpl"%>
<%@page import="com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace"%>
<%@page import="com.liferay.portal.kernel.search.Hits"%>
<%@page import="com.sgs.portlet.document.receipt.search.PmlEdmDocumentReceiptDisplayTerms"%>
<%@page import="com.sgs.portlet.document.service.persistence.PmlDocumentReceiptLogUtil"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="java.text.DateFormat"%>
<%@page import="com.liferay.portal.kernel.search.Document"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.liferay.portal.kernel.search.Field"%>
<%@page import="com.sgs.portlet.document.send.model.PmlEdmDocumentSend"%>
<%@page import="com.sgs.portlet.document.send.service.PmlEdmDocumentSendLocalServiceUtil"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.search.Sort"%>
<%@page import="com.liferay.portal.service.permission.PortletPermissionUtil"%>
<%@page import="com.ext.portal.security.permission.ActionKeysExt"%>
<%@page import="com.sgs.portlet.document.receipt.model.PmlEdmConfidentialLevel"%>
<%@page import="com.sgs.portlet.document.receipt.service.persistence.PmlEdmConfidentialLevelUtil"%>

<script type="text/javascript">

	function deleteDocumentReceipt(url) {		
		if (confirm("<liferay-ui:message key='sgs_field_deleteMessage'/>" )) {
			document.<portlet:namespace />fm.method = "post";
			submitForm(document.<portlet:namespace />fm, url);
		}
	}

</script>
<%
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action", "/sgs/pcccdocumentreceiptprocess/search");
	portletURL.setParameter("search", "true");
	portletURL.setParameter("receiptFlag", "true");
	pageContext.setAttribute("portletURL", portletURL);
	String portletURLString = portletURL.toString();
	request.setAttribute("view.jsp-portletURL", portletURL);
	request.setAttribute("view.jsp-portletURLString", portletURLString);
%>

<form action="<%= portletURLString %>" method="post" name="<portlet:namespace />fm" onsubmit="return validateFormSearch()">
	<liferay-portlet:renderURLParams varImpl="portletURL" />
	<input name="<portlet:namespace />redirect" type="hidden" value="<%= portletURLString %>" />
	<input name="<portlet:namespace />tabs" type="hidden" value="<%= HtmlUtil.escape(tabs) %>" />

<%
	portletURL = (PortletURL) request.getAttribute("view.jsp-portletURL");
%>

	<liferay-ui:error exception="<%= RequiredRoleException.class %>" message="you-cannot-delete-a-system-role" />

<%
	PmlEdmDocumentReceiptSearch searchContainer = new PmlEdmDocumentReceiptSearch(renderRequest, portletURL);
	
	List<String> headerNames = searchContainer.getHeaderNames();
	
	//Canh update
	Map<String, String> orderableHeaders = new HashMap<String, String>();
	orderableHeaders.put("documentreceipt-search-socvden", PmlEdmDocumentReceiptDisplayTerms.SO_CV_DEN);
	orderableHeaders.put("documentreceipt-search-sovaoso", PmlEdmDocumentReceiptDisplayTerms.SO_VAO_SO);
	orderableHeaders.put("documentreceipt-search-nguoiky", PmlEdmDocumentReceiptDisplayTerms.NGUOI_KY_ORDER);
	
	searchContainer.setOrderableHeaders(orderableHeaders);
	
	//xuancong close String orderByCol = ParamUtil.getString(renderRequest, "orderByCol", "ngayDen");
	// Mac dinh sap xep theo sovaoso
	String orderByCol = ParamUtil.getString(renderRequest, "orderByCol", PmlEdmDocumentReceiptDisplayTerms.SO_VAO_SO);
	//end of Canh
	int sortType = Sort.STRING_TYPE; // Sap xep mac dinh

	String orderByType = searchContainer.getOrderByType().toLowerCase();
	boolean reverse = false;
	if (orderByType.equals("desc")) {
		reverse = true;
	} // end if

	// Thuc hien viec include file timcongvanden_filter.jsp
%>
<liferay-ui:search-form	
	page="/html/portlet/ext/pcccdocumentreceiptprocess/timcongvanden_filter.jsp"
	searchContainer="<%= searchContainer %>" ></liferay-ui:search-form>

<%
//try { // yenlt close 31052010
	//xuancong close if (Boolean.valueOf(renderRequest.getAttribute("receiptFlag").toString()) == true) {
	if (renderRequest.getAttribute("receiptFlag") != null && 
			Boolean.valueOf(renderRequest.getAttribute("receiptFlag").toString()) == true) {
		//PmlEdmDocumentReceiptSearchTerms searchTerms = (PmlEdmDocumentReceiptSearchTerms) searchContainer.getSearchTerms();
		
		// Phuong thuc tra ve tong so record tim duoc trong csdl
		//int total = PmlEdmDocumentReceiptLocalServiceUtil.countByS_L_N_S_N_T_D_D_S_T(searchTerms.getSoCVDen(), searchTerms.getSoVaoSo(), searchTerms.getTuNgay(), searchTerms.getDenNgay(),
		//								searchTerms.getSoHSCV(), searchTerms.getLoaiCV(), searchTerms.getNoiPhatHanh(), searchTerms.getTrangThai(), searchTerms.getNguoiKy(), searchTerms.getTrichYeu());
	
		//searchContainer.setTotal(total);
	
		// Phuong thuc tra ve danh sach doi tuong Customer
		//List results = PmlEdmDocumentReceiptLocalServiceUtil.findByS_L_N_S_N_T_D_D_S_T(searchTerms.getSoCVDen(), searchTerms.getSoVaoSo(), searchTerms.getTuNgay(), searchTerms.getDenNgay(),
		//								searchTerms.getSoHSCV(), searchTerms.getLoaiCV(), searchTerms.getNoiPhatHanh(), searchTerms.getTrangThai(), searchTerms.getNguoiKy(), searchTerms.getTrichYeu(),
		//								searchContainer.getStart(), searchContainer.getEnd(), searchContainer.getOrderByComparator());
	
		//searchContainer.setResults(results);
		//canh update
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		PmlEdmDocumentReceiptDisplayTerms displayTerms = (PmlEdmDocumentReceiptDisplayTerms)searchContainer.getDisplayTerms();
		
		//xuancong close Hits hits = PmlEdmDocumentReceiptLocalServiceUtil.search(user.getCompanyId(), displayTerms.getSoCVDen(), displayTerms.getSoVaoSo(), df.parse(displayTerms.getTuNgay()), df.parse(displayTerms.getDenNgay()), displayTerms.getSoHSCV(), displayTerms.getLoaiCV(), displayTerms.getNoiPhatHanh(), displayTerms.getTrangThai(), displayTerms.getNguoiKy(), displayTerms.getTrichYeu(), "", orderByCol, Sort.STRING_TYPE, searchContainer.getStart(), searchContainer.getEnd());
		//xuancong close Hits hits = PmlEdmDocumentReceiptLocalServiceUtil.search(user.getCompanyId(), displayTerms.getSoCVDen(), displayTerms.getSoVaoSo(), df.parse(displayTerms.getTuNgay()), df.parse(displayTerms.getDenNgay()), displayTerms.getSoHSCV(), displayTerms.getLoaiCV(), displayTerms.getNoiPhatHanh(), displayTerms.getTrangThai(), displayTerms.getNguoiKy(), displayTerms.getTrichYeu(), "", orderByCol, Sort.STRING_TYPE, reverse, searchContainer.getStart(), searchContainer.getEnd());
		// Them dau * vao de tim theo so neu nguoi dung co nhap
		Hits hits = PmlEdmDocumentReceiptLocalServiceUtil.search(user.getCompanyId(), 
				displayTerms.getSoCVDen().trim().length() == 0 ? "" : (displayTerms.getSoCVDen() + "*"), 
				displayTerms.getSoVaoSo().trim().length() == 0 ? "" : (displayTerms.getSoVaoSo() + "*"), df.parse(displayTerms.getTuNgay()), df.parse(displayTerms.getDenNgay()), displayTerms.getSoHSCV(), displayTerms.getLoaiCV(), displayTerms.getNoiPhatHanh(), displayTerms.getTrangThai(), displayTerms.getNguoiKy(), displayTerms.getTrichYeu(), "", orderByCol, Sort.STRING_TYPE, reverse, searchContainer.getStart(), searchContainer.getEnd());
		//xuancong close System.out.println(user.getCompanyId() + ", CVDen: " +  displayTerms.getSoCVDen() + ",SoVaoSo:  " +  displayTerms.getSoVaoSo() + ",tuNgay: " +  df.parse(displayTerms.getTuNgay()) + ",DenNgay: " +  df.parse(displayTerms.getDenNgay()) + ",SoHSCV: " +  displayTerms.getSoHSCV() + ",LoaiCV: " +  displayTerms.getLoaiCV() + ",NoiPhatHanh: " +  displayTerms.getNoiPhatHanh() + ",TrangThai: " +  displayTerms.getTrangThai() + ",NguoiKy: " +  displayTerms.getNguoiKy() + ",TrichYeu " +  displayTerms.getTrichYeu());
		searchContainer.setTotal(hits.getLength());
		// end of canh
		//thoi start
		//if (!PortletPermissionUtil.contains(permissionChecker, plid, "SGS_PCCCDOCUMENTRECEIPTPROCESS_INSTANCE_56nj", ActionKeysExt.TIEPNHANCV)
			//	|| 
		if(!PortletPermissionUtil.contains(permissionChecker, plid, "SGS_PCCCDOCUMENTRECEIPTPROCESS_INSTANCE_HKH8", ActionKeysExt.TIEPNHANCV)) {					
			//xuancong close cot edit chuyen sang thu 1 searchContainer.getHeaderNames().remove(1);
			searchContainer.getHeaderNames().remove(10); // Cot delete
			searchContainer.getHeaderNames().remove(9); // Cot edit
			searchContainer.setHeaderNames(searchContainer.getHeaderNames());
		}
		//end
		portletURL.setParameter(searchContainer.getCurParam(), String.valueOf(searchContainer.getCurValue()));
	%>

		<input name="<portlet:namespace />customerRedirect" type="hidden" value="<%= portletURL.toString() %>" />
	
		<div class="separator"><!-- --></div>
	
	<%
		// Doc do mat va luu thanh 3 list: khong gioi han xem, phai tham gia xu ly va khong can tham gia xu ly
		List<String> confNoLimitViewDetailIds = new ArrayList<String>();
		List<String> confNoNeedHaveProcessIds = new ArrayList<String>();
		List<PmlEdmConfidentialLevel> confLevels = PmlEdmConfidentialLevelUtil.findAll();
		if (confLevels != null && !confLevels.isEmpty()) {
			// Duyet do mat
			for (int idxCL = 0; idxCL < confLevels.size(); idxCL++) {
				PmlEdmConfidentialLevel confLevelItem = (PmlEdmConfidentialLevel) confLevels.get(idxCL);
				if (confLevelItem.getLimitViewDetail() == false) { // Khong gioi han xem chi tiet
					confNoLimitViewDetailIds.add(confLevelItem.getPrimaryKey());
				}
				else {
					if (confLevelItem.getHaveProcess() == false) { // Xem chi tiet cua van ban theo phong
						confNoNeedHaveProcessIds.add(confLevelItem.getPrimaryKey());
					}
				}
			}
		}
	
		long userId = user.getUserId();
		boolean viewAllDoc = false; // Xem toan bo cong van
		String viewDepDoc = ""; // Danh sach phong ban ma nguoi dung duoc theo doi
		ArrayList<String> arlViewDepDoc = new ArrayList<String>();

		// Cau hinh cho nguoi dung hien hanh
		PmlEdmDocConfUser dcuCur = PmlEdmDocConfUserLocalServiceUtil.findByUserId(userId);
		if (dcuCur != null) {
			if (dcuCur.getViewAllDoc() == true) {
				viewAllDoc = true;
			}
			else {
				viewDepDoc = dcuCur.getViewDepDoc();
			}
		}
		if (viewAllDoc == false) {
				// Gan them phong ban cua nguoi dung vao danh sach nay
			// Dong nghia nguoi dung co the xem duoc nhung van ban den chuyen cho phong cua minh
				com.sgs.portlet.pmluser.model.PmlUser curUser = 
				com.sgs.portlet.pmluser.service.PmlUserLocalServiceUtil.findByUserId(userId);
				String curDep = curUser.getDepartmentsId();
				if (!curDep.equals("")) {
					if (!viewDepDoc.equals("")) {
						viewDepDoc+= ",";
					}
					viewDepDoc+= curDep;
				} 
	
				// Parse viewDepDoc to ArrayList
				StringTokenizer tokenViewDepDoc = new StringTokenizer(viewDepDoc, ",");
				while (tokenViewDepDoc.hasMoreTokens()) {
					arlViewDepDoc.add(String.valueOf(tokenViewDepDoc.nextElement()));
				}
			}

		// Get ArrayList of document
		ArrayList<Long> arlDocId = new ArrayList<Long>();
		for (int i = 0; i < hits.getDocs().length; i ++) {
			Document document = hits.doc(i);
			Long documentReceiptId = GetterUtil.getLong(document.get(Field.ENTRY_CLASS_PK));
			arlDocId.add(documentReceiptId);
		}
		// Get ArrayList DepId for docId
		ArrayList<String> arlDepIdForDocIdList = PmlEdmDocConfUserLocalServiceUtil.getDepIdListForRecDocIdList(arlDocId);
		
		List resultRows = searchContainer.getResultRows();
		PmlEdmDocumentReceipt pmlEdmDocumentReceipt = null; // yenlt update 31052010
		
		for (int i = 0; i < hits.getDocs().length; i ++) {
			boolean showDetail = false;
			Document document = hits.doc(i);
			Long documentReceiptId = GetterUtil.getLong(document.get(Field.ENTRY_CLASS_PK));
			// yenlt update 31052010
			//PmlEdmDocumentReceipt pmlEdmDocumentReceipt = PmlEdmDocumentReceiptLocalServiceUtil.getPmlEdmDocumentReceipt(documentReceiptId); // yenlt close 31052010
			
			try {
				pmlEdmDocumentReceipt = PmlEdmDocumentReceiptLocalServiceUtil.getPmlEdmDocumentReceipt(documentReceiptId);
			} catch (Exception e) {}
			// chi hien thi voi isPublic == 1
			if (null != pmlEdmDocumentReceipt && "1".equals(pmlEdmDocumentReceipt.getIsPublic())) { // end yenlt 31052010
				// Neu van ban nay khong mat thi cho xem
				if (confNoLimitViewDetailIds != null && !confNoLimitViewDetailIds.isEmpty() && 
						pmlEdmDocumentReceipt.getConfidentialLevelId().length() > 0 && 
						confNoLimitViewDetailIds.contains(pmlEdmDocumentReceipt.getConfidentialLevelId())) {
					showDetail = true;
				}
				else if (pmlEdmDocumentReceipt.getConfidentialLevelId().length() > 0) {
					if (confNoNeedHaveProcessIds != null && !confNoNeedHaveProcessIds.isEmpty() && 
							confNoNeedHaveProcessIds.contains(pmlEdmDocumentReceipt.getConfidentialLevelId())) {
				String viewDepIdDetail = arlDepIdForDocIdList.get(arlDocId.indexOf(pmlEdmDocumentReceipt.getDocumentReceiptId()));
				if (viewAllDoc == true) {
					showDetail = true;
				}
				else {
					String[] arrViewDepIdDetail = viewDepIdDetail.split(",");
					for (int idx = 0; idx < arrViewDepIdDetail.length; idx++) {
						if (arlViewDepDoc.contains(arrViewDepIdDetail[idx])) {
							showDetail = true;
							break;
						}
					}
				}
					}
				}
				// Cho phep nguoi dung xem duoc chi tiet nhung van ban do minh xu ly
				if (showDetail == false) {
					if (!PmlDocumentReceiptLogUtil.findByDocumentReceiptId_Processor(pmlEdmDocumentReceipt.getDocumentReceiptId(), userId).isEmpty()) {
						showDetail = true;
					}
					else if (!PmlDocumentReceiptLogUtil.findByDocumentReceiptId_Receiver(pmlEdmDocumentReceipt.getDocumentReceiptId(), userId).isEmpty()) {
						showDetail = true;
					}
				}
		
				//pmlEdmDocumentReceiptSearchDTO = pmlEdmDocumentReceiptSearchDTO.toEscapedModel();
		
				ResultRow row = new ResultRow(pmlEdmDocumentReceipt, pmlEdmDocumentReceipt.getDocumentReceiptId(), i);
		
				//PortletURL rowURL = new PortletURLImpl(request, "SGS_PCCCDOCUMENTRECEIPTPROCESS_INSTANCE_56nj", 33008, PortletRequest.RENDER_PHASE);
				PortletURL rowURL = new PortletURLImpl(request, "SGS_PCCCDOCUMENTRECEIPTPROCESS_INSTANCE_HKH8", 89385, PortletRequest.RENDER_PHASE);
				//rowURL = renderResponse.createRenderURL();
				//rowURL.setWindowState(WindowState.NORMAL);
				rowURL.setParameter("struts_action", "/sgs/pcccdocumentreceiptprocess/detail");
				rowURL.setParameter("documentReceiptId", String.valueOf(pmlEdmDocumentReceipt.getDocumentReceiptId()));
				rowURL.setParameter("redirect", searchContainer.getIteratorURL().toString());
				rowURL.setParameter("roleId", String.valueOf(pmlEdmDocumentReceipt.getDocumentReceiptId()));
				rowURL.setParameter("timkiemcvdendetail", String.valueOf(true));
		
				//edit thoi add cho van thu start
				//ResultRow row_ = new ResultRow(pmlEdmDocumentReceipt, pmlEdmDocumentReceipt.getDocumentReceiptId(), i);
				
				//PortletURL rowURL_ = new PortletURLImpl(request, "SGS_PCCCDOCUMENTRECEIPTPROCESS_INSTANCE_56nj", 33008, PortletRequest.RENDER_PHASE);
				PortletURL rowURL_ = new PortletURLImpl(request, "SGS_PCCCDOCUMENTRECEIPTPROCESS_INSTANCE_HKH8", 89385, PortletRequest.RENDER_PHASE);
				rowURL_.setParameter("struts_action", "/sgs/pcccdocumentreceiptprocess/updatesearch");
				rowURL_.setParameter("documentReceiptId", String.valueOf(pmlEdmDocumentReceipt.getDocumentReceiptId()));
				rowURL_.setParameter("redirect", searchContainer.getIteratorURL().toString());
				rowURL_.setParameter("roleId", String.valueOf(pmlEdmDocumentReceipt.getDocumentReceiptId()));
				String editImage = "<img src='/html/images/edit.png'>";
				//end
	
				// Them chuc nang cho phep xoa van ban start 
				PortletURL rowDelURL_ = renderResponse.createRenderURL();
				rowDelURL_.setParameter("struts_action", "/sgs/pcccdocumentreceiptprocess/deletefromsearch");
				rowDelURL_.setParameter("documentReceiptId", String.valueOf(pmlEdmDocumentReceipt.getDocumentReceiptId()));
				rowDelURL_.setParameter("companyId", String.valueOf(user.getCompanyId()));
				//String delImg = "<img src='/html/images/xoa.gif'>";
				String delImg = "<a  href='javascript: ;'  onclick=deleteDocumentReceipt('"+ rowDelURL_.toString() +"')><u>"+ "<img src='/html/images/xoa.gif'/>" +"</u></a>";
				// Them chuc nang cho phep xoa van ban end 
	
				// STT
				row.addText ((i + 1) + "");
				
				// So van ban den
				if (showDetail == true) {
					row.addText(pmlEdmDocumentReceipt.getDocumentReference(), rowURL);
				}
				else {
					row.addText(pmlEdmDocumentReceipt.getDocumentReference());
				}
				
				// So vao so
				if (showDetail == true) {
					row.addText(pmlEdmDocumentReceipt.getNumberDocumentReceipt(), rowURL);
				}
				else {
					row.addText(pmlEdmDocumentReceipt.getNumberDocumentReceipt());
				}
				
				// Loai cong van
				// minh update 20091215 [ new loai cong van khong ton tai ]
				String documentTypeName = "";
				
				try {
					documentTypeName = PmlEdmDocumentTypeUtil.findByPrimaryKey(pmlEdmDocumentReceipt.getDocumentTypeId()).getDocumentTypeName();
				} catch (Exception e) {
					documentTypeName = "";
				}
				
				row.addText(documentTypeName);
				//end
				
				// Lay noi phat hanh
				String noiPhatHanh = "";
				String issuingPlaceId = pmlEdmDocumentReceipt.getIssuingPlaceId();
				
				if (issuingPlaceId.equals("")) {
					noiPhatHanh = pmlEdmDocumentReceipt.getIssuingPlaceOtherName();
				}
				else {
					PmlEdmIssuingPlace pmlEdmIssuingPlace = null;
					try {
						pmlEdmIssuingPlace = PmlEdmIssuingPlaceUtil.findByPrimaryKey(issuingPlaceId);
					} catch (Exception e){
						pmlEdmIssuingPlace = null;
					}
					
					if (pmlEdmIssuingPlace != null) {
						noiPhatHanh = pmlEdmIssuingPlace.getIssuingPlaceName();
					}
				}
				
				row.addText(noiPhatHanh);
				
				// Ngay den
				//xuancong close row.addText(new SimpleDateFormat("dd/MM/yyyy").format(pmlEdmDocumentReceipt.getDateArrive()));
				// Lay ngay phat hanh thay cho ngay den
				String ngayPhatHanh = "";
				if (null != pmlEdmDocumentReceipt.getIssuingDate()) {
					ngayPhatHanh = new SimpleDateFormat("dd/MM/yyyy").format(pmlEdmDocumentReceipt.getIssuingDate());
				}
				row.addText(ngayPhatHanh);
				
				// Trich yeu
				row.addText(pmlEdmDocumentReceipt.getBriefContent());
				
				// Nguoi ky
				row.addText(pmlEdmDocumentReceipt.getSigner());
				
				// Toan van
				
				// minh update 20091215 [new khong ton tai nhung file dinh kem voi cong van nay]
				List<PmlEdmAttachedFile> attachedFiles = null;
				try {
					attachedFiles = PmlEdmAttachedFileUtil.findByObjectContentId_ObjectType(pmlEdmDocumentReceipt.getDocumentReceiptId(), 
															new PmlEdmDocumentReceiptImpl().getClass().getName());
				} catch (Exception e) {
					attachedFiles = new  ArrayList<PmlEdmAttachedFile> ();
				}
				// end
				
				String toanVanURL = "";
				for (int j = 0; j < attachedFiles.size(); j ++) {
					PmlEdmAttachedFile attachedFile = attachedFiles.get(j);
					//xuancong close toanVanURL += "<a href=\"" + attachedFile.getPath() + "\"> <img src='/html/images/icon_download.jpg'>&nbsp;" + (!attachedFile.getTitle().equals("") ? attachedFile.getTitle() : attachedFile.getAttachedFileName()) + "</a><br />";
					// Chi hien thi hinh download va title cua hinh
					if (toanVanURL.length() > 0) {
						toanVanURL += "<br />";
					}
					toanVanURL += "<a href=\"" + attachedFile.getPath() + "\"><img src='/html/images/icon_download.png' title='" + (attachedFile.getTitle().trim().length() > 0 ? attachedFile.getTitle() : attachedFile.getAttachedFileName()) + "'></a>";
				}
				row.addText(toanVanURL);
		
				// Edit
				if(PortletPermissionUtil.contains(permissionChecker, plid, "SGS_PCCCDOCUMENTRECEIPTPROCESS_INSTANCE_56nj", ActionKeysExt.TIEPNHANCV)
					|| PortletPermissionUtil.contains(permissionChecker, plid, "SGS_PCCCDOCUMENTRECEIPTPROCESS_INSTANCE_HKH8", ActionKeysExt.TIEPNHANCV)){					
					row.addText(editImage, rowURL_);
				}
	
				// Delete
				if(PortletPermissionUtil.contains(permissionChecker, plid, "SGS_PCCCDOCUMENTRECEIPTPROCESS_INSTANCE_56nj", ActionKeysExt.TIEPNHANCV)					
					|| PortletPermissionUtil.contains(permissionChecker, plid, "SGS_PCCCDOCUMENTRECEIPTPROCESS_INSTANCE_HKH8", ActionKeysExt.TIEPNHANCV)){					
//					row.addText(delImg, rowDelURL_);
					row.addText(delImg);
				}
		
				resultRows.add(row);
			}// yenlt 31052010
		}
		%>
	
		<liferay-ui:search-iterator searchContainer="<%= searchContainer %>" />
<%
	}
/*  yenlt close 31052010
} catch(Exception e) {
e.printStackTrace();
}
yenlt close end 31052010 */
%>
	
</form>