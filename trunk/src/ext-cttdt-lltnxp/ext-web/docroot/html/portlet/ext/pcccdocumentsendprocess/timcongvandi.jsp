<%@ include file="/html/portlet/ext/pcccdocumentsend/init.jsp" %>

<%@page import="com.sgs.portlet.pml_edm_docconfuser.model.PmlEdmDocConfUser"%>
<%@page import="com.sgs.portlet.pml_edm_docconfuser.service.PmlEdmDocConfUserLocalServiceUtil"%>
<%@page import="java.util.StringTokenizer"%>
<%@page import="com.liferay.portal.RequiredRoleException"%>

<%@page import="com.sgs.portlet.document.receipt.searchdocumentsend.PmlEdmDocumentSendSearch"%>
<%@page import="com.sgs.portlet.document.send.service.PmlEdmDocumentSendLocalServiceUtil"%>
<%@page import="com.sgs.portlet.document.send.model.PmlEdmDocumentSend"%>
<%@page import="com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentTypeUtil"%>
<%@page import="com.sgs.portlet.document.receipt.model.PmlEdmDocumentType"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.liferay.portal.service.persistence.UserUtil"%>
<%@page import="com.sgs.portlet.pmluser.service.persistence.PmlUserUtil"%>
<%@page import="com.sgs.portlet.pmluser.model.PmlUser"%>
<%@page import="com.sgs.portlet.department.model.Department"%>
<%@page import="com.sgs.portlet.department.service.persistence.DepartmentUtil"%>
<%@page import="com.sgs.portlet.pmlissuingplace.service.persistence.PmlEdmIssuingPlaceUtil"%>
<%@page import="com.sgs.portlet.document.receipt.searchdocumentsend.PmlEdmDocumentSendSearchTerms"%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.DateFormat"%>

<%@page import="com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.sgs.portlet.document.receipt.service.persistence.PmlEdmAttachedFileUtil"%>
<%@page import="com.liferay.portal.kernel.search.Hits"%>
<%@page import="com.sgs.portlet.document.receipt.searchdocumentsend.PmlEdmDocumentSendDisplayTerms"%>
<%@page import="com.liferay.portal.kernel.search.Field"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portlet.PortletURLImpl"%>
<%@page import="javax.portlet.PortletRequest"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.search.Sort"%>
<%@page import="com.liferay.portal.service.permission.PortletPermissionUtil"%>
<%@page import="com.ext.portal.security.permission.ActionKeysExt"%>
<%@page import="com.sgs.portlet.document.service.persistence.PmlDocumentSendLogUtil"%>
<%@page import="com.sgs.portlet.pmluser.service.PmlUserLocalServiceUtil"%>

<script type="text/javascript">

	function deleteDocumentSend(url) {		
		if (confirm("<liferay-ui:message key='sgs_field_deleteMessage'/>" )) {
			document.<portlet:namespace />fm.method = "post";
			submitForm(document.<portlet:namespace />fm, url);
		}
	}

</script>

<%

	PortletURL portletURLSend = renderResponse.createRenderURL();
	
	portletURLSend.setWindowState(WindowState.NORMAL);
	
	portletURLSend.setParameter("struts_action", "/sgs/pcccdocumentsendprocess/search");
	portletURLSend.setParameter("search", "false");
	portletURLSend.setParameter("sendFlag", "true");
	
	String portletURLStringSend = portletURLSend.toString();
%>

<form  action="<%= portletURLStringSend %>" method="post" name="<portlet:namespace />fm" onSubmit="return validateFormSearchCVDI();">
	<input name="<portlet:namespace />tabs" type="hidden" value="<%= HtmlUtil.escape(tabs) %>" />
<%
	//portletURL = (PortletURL) request.getAttribute("view.jsp-portletURL");

	PmlEdmDocumentSendSearch searchContainerSend = new PmlEdmDocumentSendSearch(renderRequest, portletURLSend);
	List<String> headerNamesSend = searchContainerSend.getHeaderNames();

	//Canh update
	List<String> headerNames = searchContainerSend.getHeaderNames();
	//xuancong close headerNames.add(5,"nguoi-ky");
	// Them vao vi tri thu 6
	//xuancong close, dua vao trong file java headerNames.add(6, "nguoi-ky");
	
	Map<String, String> orderableHeaders = new HashMap<String, String>();
	orderableHeaders.put("so-phat-hanh", PmlEdmDocumentSendDisplayTerms.SO_PHAT_HANH);
	orderableHeaders.put("ngay-phat-hanh", "ngayPhatHanh");
	orderableHeaders.put("nguoi-ky", PmlEdmDocumentSendDisplayTerms.NGUOI_KY);
	
	searchContainerSend.setOrderableHeaders(orderableHeaders);
	
	//xuancong close String orderByCol = ParamUtil.getString(renderRequest, "orderByCol", "ngayPhatHanh");
	// Mac dinh sap xep theo sophathanh
	String orderByCol = ParamUtil.getString(renderRequest, "orderByCol", PmlEdmDocumentSendDisplayTerms.SO_PHAT_HANH);
	//end of Canh
	int sortType = Sort.STRING_TYPE; // Sap xep mac dinh

	String orderByType = searchContainerSend.getOrderByType().toLowerCase();
	boolean reverse = false;
	if (orderByType.equals("desc")) {
		reverse = true;
	} // end if

	// De thuc hien viec include file search.jsp
%>
<liferay-ui:search-form
	page="/html/portlet/ext/pcccdocumentsendprocess/timcongvandi_filter.jsp"
	searchContainer="<%= searchContainerSend %>" />

<%
//try { // yenlt close 25052010
	//xuancong close if (Boolean.valueOf(renderRequest.getAttribute("sendFlag").toString()) == true) {
	if (renderRequest.getAttribute("sendFlag") != null && 
			Boolean.valueOf(renderRequest.getAttribute("sendFlag").toString()) == true) {
		PmlEdmDocumentSendSearchTerms searchTermsSend = (PmlEdmDocumentSendSearchTerms) searchContainerSend.getSearchTerms();
		PmlEdmDocumentSendDisplayTerms displayTerms = (PmlEdmDocumentSendDisplayTerms)searchContainerSend.getDisplayTerms();
		
		DateFormat df1 = new SimpleDateFormat("dd/MM/yyyy");
		DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd");
		String tuNgay = "";
		String denNgay = "";
		Date fromDate = new Date();
		
		if (!"".equals(displayTerms.getTuNgay())) {
			fromDate = df1.parse(displayTerms.getTuNgay());
			tuNgay = df2.format(fromDate);
			
		}
		Date toDate = new Date();
		if (!"".equals(displayTerms.getDenNgay())) {
			toDate = df1.parse(displayTerms.getDenNgay());
			denNgay = df2.format(toDate);
		}
		
		//int totalSend = PmlEdmDocumentSendLocalServiceUtil.countByS_L_T_P_N_N_TN_DN_S_T(searchTermsSend.getSoPhatHanh(),searchTermsSend.getLoaiCongVan() ,searchTermsSend.getTraLoiCongVanSo(), searchTermsSend.getPhongSoanThao(), searchTermsSend.getNoiNhan(), searchTermsSend.getNguoiKy(), tuNgay,denNgay,searchTermsSend.getSoHSCV(), searchTermsSend.getTrichYeu());
	
		//searchContainerSend.setTotal(totalSend);
	
		// Phuong thuc tra ve danh sach doi tuong Customer
		//List resultsSend = PmlEdmDocumentSendLocalServiceUtil.findByS_L_T_P_N_N_TN_DN_S_T(searchTermsSend.getSoPhatHanh(),searchTermsSend.getLoaiCongVan() ,searchTermsSend.getTraLoiCongVanSo(), searchTermsSend.getPhongSoanThao(), searchTermsSend.getNoiNhan(), searchTermsSend.getNguoiKy(), tuNgay,denNgay,searchTermsSend.getSoHSCV(), searchTermsSend.getTrichYeu(), searchContainerSend.getStart(), searchContainerSend.getEnd(), searchContainerSend.getOrderByComparator());
	
		//searchContainerSend.setResults(resultsSend);
		
		//canh update
		//xuancong close Hits hits = PmlEdmDocumentSendLocalServiceUtil.search(user.getCompanyId(), displayTerms.getSoPhatHanh(), displayTerms.getLoaiCongVan(), displayTerms.getTraLoiCongVanSo(), displayTerms.getPhongSoanThao(), displayTerms.getNoiNhan(), displayTerms.getNguoiKy(), fromDate, toDate, displayTerms.getSoHSCV(), displayTerms.getTrichYeu(), "", orderByCol, Sort.STRING_TYPE, searchContainerSend.getStart(), searchContainerSend.getEnd());
		//xuancong close Hits hits = PmlEdmDocumentSendLocalServiceUtil.search(user.getCompanyId(), displayTerms.getSoPhatHanh(), displayTerms.getLoaiCongVan(), displayTerms.getTraLoiCongVanSo(), displayTerms.getPhongSoanThao(), displayTerms.getNoiNhan(), displayTerms.getNguoiKy(), fromDate, toDate, displayTerms.getSoHSCV(), displayTerms.getTrichYeu(), "", orderByCol, sortType, reverse, searchContainerSend.getStart(), searchContainerSend.getEnd());
		// Them dau * vao de tim theo so neu nguoi dung co nhap
		//Hits hits = PmlEdmDocumentSendLocalServiceUtil.search(user.getCompanyId(), 
		//		displayTerms.getSoPhatHanh().trim().length() == 0 ? "" : (displayTerms.getSoPhatHanh() + "*"), 
		//		displayTerms.getLoaiCongVan(), displayTerms.getTraLoiCongVanSo(), displayTerms.getPhongSoanThao(), displayTerms.getNoiNhan(), displayTerms.getNguoiKy(), fromDate, toDate, displayTerms.getSoHSCV(), displayTerms.getTrichYeu(), "", orderByCol, sortType, reverse, searchContainerSend.getStart(), searchContainerSend.getEnd());
		// Them tim theo nguoi soan thao, bo tim theo van ban tra loi so
		Hits hits = PmlEdmDocumentSendLocalServiceUtil.timKiemVBDi(user.getCompanyId(), displayTerms.getNumOfDirector(),
				displayTerms.getSoPhatHanh().trim().length() == 0 ? "" : (displayTerms.getSoPhatHanh() + "*"), 
				displayTerms.getLoaiCongVan(), "", displayTerms.getPhongSoanThao(), displayTerms.getNoiNhan(), displayTerms.getNguoiKy(), 
				fromDate, toDate, displayTerms.getSoHSCV(), displayTerms.getTrichYeu(), "", displayTerms.getNguoiSoanThao(), 
				orderByCol, sortType, reverse, searchContainerSend.getStart(), searchContainerSend.getEnd());
		int total = 0;
		total = hits.getLength();
		searchContainerSend.setTotal(total);
		//end of canh
		
		//thoi start
		if(!PortletPermissionUtil.contains(permissionChecker, plid, "SGS_PCCCDOCUMENTSENDPROCESS", ActionKeysExt.TIEPNHANCV)){					
			//xuancong close, cot edit khong con o vi tri 2 searchContainerSend.getHeaderNames().remove(1);
			searchContainerSend.getHeaderNames().remove(10); // Cot delete
			searchContainerSend.getHeaderNames().remove(9); // Cot edit
			searchContainerSend.setHeaderNames(searchContainerSend.getHeaderNames());
		}
		//end
		
		portletURLSend.setParameter(searchContainerSend.getCurParam(), String.valueOf(searchContainerSend.getCurValue()));
%>
	
	<div class="separator"><!-- --></div>

<%
		long userId = user.getUserId();
		boolean viewAllDoc = false; // Xem toan bo cong van
		String viewDepDoc = ""; // Danh sach phong ban ma nguoi dung duoc theo doi
		ArrayList<String> arlViewDepDoc = new ArrayList<String>();
	
		// Cau hinh cho nguoi dung hien hanh
		PmlEdmDocConfUser dcuCur = PmlEdmDocConfUserLocalServiceUtil.findByUserId(userId);
		if (dcuCur != null) {
			if (dcuCur.getViewAllDoc() == true) {
				viewAllDoc = true;
			} else {
				viewDepDoc = dcuCur.getViewDepDoc();
				// Gan them phong ban cua nguoi dung vao danh sach nay
				PmlUser curUser = 
				PmlUserLocalServiceUtil.findByUserId(userId);
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
		}
		// Get ArrayList of document
		ArrayList<Long> arlDocId = new ArrayList<Long>();
		for (int i = 0; i < hits.getDocs().length; i ++) {
			Long documentSendId = GetterUtil.getLong(hits.doc(i).get(Field.ENTRY_CLASS_PK));
			arlDocId.add(documentSendId);
		}
		// Get ArrayList DepId for docId
		ArrayList<String> arlDepIdForDocIdList = PmlEdmDocConfUserLocalServiceUtil.getDepIdListForSenDocIdList(arlDocId);
	
		List resultRowsSend = searchContainerSend.getResultRows();
	
		PmlEdmDocumentSend pmlEdmDocumentSend = null; // yenlt 25052010
		for (int i = 0; i < hits.getDocs().length; i ++) {
			boolean showDetail = false;
			Long documentSendId = GetterUtil.getLong(hits.doc(i).get(Field.ENTRY_CLASS_PK));
			 // yenlt 25052010
			//PmlEdmDocumentSend pmlEdmDocumentSend = PmlEdmDocumentSendLocalServiceUtil.getPmlEdmDocumentSend(documentSendId);
			try {
				pmlEdmDocumentSend = PmlEdmDocumentSendLocalServiceUtil.getPmlEdmDocumentSend(documentSendId);
			} catch (Exception e) {}
			
			if ( null!= pmlEdmDocumentSend) { // end yenlt 25052010

				String viewDepIdDetail = arlDepIdForDocIdList.get(arlDocId.indexOf(pmlEdmDocumentSend.getDocumentSendId()));
				if (viewAllDoc == true) {
					showDetail = true;
				} else {
					String[] arrViewDepIdDetail = viewDepIdDetail.split(",");
					for (int idx = 0; idx < arrViewDepIdDetail.length; idx++) {
						if (arlViewDepDoc.contains(arrViewDepIdDetail[idx])) {
							showDetail = true;
							break;
						}
					}
				}
				// xuancong add
				// Cho phep chuyen vien xem nhung van ban di ma ho co tham gia xu ly
				if (showDetail == false) {
					if (!PmlDocumentSendLogUtil.findByDocumentSendId_Processor(pmlEdmDocumentSend.getDocumentSendId(), userId).isEmpty()) {
						showDetail = true;
					} // end if 
					else if (!PmlDocumentSendLogUtil.findByDocumentSendId_Receiver(pmlEdmDocumentSend.getDocumentSendId(), userId).isEmpty()) {
						showDetail = true;
					}
				} // end if
		
				pmlEdmDocumentSend = pmlEdmDocumentSend.toEscapedModel();
		
				ResultRow rowSend = new ResultRow(pmlEdmDocumentSend, pmlEdmDocumentSend.getDocumentSendId(), i);
		
				PortletURL rowURLSend = new PortletURLImpl(request, "SGS_PCCCDOCUMENTSENDPROCESS", 89655, PortletRequest.RENDER_PHASE);	
				rowURLSend.setParameter("struts_action", "/sgs/pcccdocumentsendprocess/detail");
				rowURLSend.setParameter("redirect", searchContainerSend.getIteratorURL().toString());
				rowURLSend.setParameter("documentSendId", String.valueOf(pmlEdmDocumentSend.getDocumentSendId()));
				
				//edit thoi add cho van thu start
				//ResultRow rowSend_ = new ResultRow(pmlEdmDocumentSend, pmlEdmDocumentSend.getDocumentSendId(), i);
				
				PortletURL rowURL_ = new PortletURLImpl(request, "SGS_PCCCDOCUMENTSENDPROCESS", 89655, PortletRequest.RENDER_PHASE);
				rowURL_.setParameter("struts_action", "/sgs/pcccdocumentsendprocess/updatesearch");
				rowURL_.setParameter("documentSendId", String.valueOf(pmlEdmDocumentSend.getDocumentSendId()));
				rowURL_.setParameter("redirect", searchContainerSend.getIteratorURL().toString());
				rowURL_.setParameter("roleId", String.valueOf(pmlEdmDocumentSend.getDocumentSendId()));
				String updateURL = rowURL_.toString();
				String editImage_ = "<img src='/html/images/edit.png'>";
				//end
				
				// Them URL delete start 
				PortletURL rowDelURL_ = renderResponse.createRenderURL();
				rowDelURL_.setParameter("struts_action", "/sgs/pcccdocumentsendprocess/deletefromsearch");
				rowDelURL_.setParameter("documentSendId", String.valueOf(pmlEdmDocumentSend.getDocumentSendId()));
				//String delImg = "<img src='/html/images/xoa.gif'>";
				String delImg = "<a  href='javascript: ;'  onclick=deleteDocumentSend('"+ rowDelURL_.toString() +"')><u>"+ "<img src='/html/images/xoa.gif'/>" +"</u></a>";
				// Them URL delete end 
	
				// STT
				rowSend.addText(String.valueOf(i + 1));
				
				// So phat hanh
				if (showDetail == true) {
					rowSend.addText(pmlEdmDocumentSend.getDocumentReference(), rowURLSend);
				} else {
					rowSend.addText(pmlEdmDocumentSend.getDocumentReference());
				}
				
				// ngay phat hanh
				if (showDetail == true) {
					if (pmlEdmDocumentSend.getIssuingDate() != null) {
						rowSend.addText(new SimpleDateFormat("dd/MM/yyyy").format(pmlEdmDocumentSend.getIssuingDate()), rowURLSend);
					} else {
						rowSend.addText("", rowURLSend);
					}
				} else {
					if (pmlEdmDocumentSend.getIssuingDate() != null) {
						rowSend.addText(new SimpleDateFormat("dd/MM/yyyy").format(pmlEdmDocumentSend.getIssuingDate()));
					} else {
						rowSend.addText("", rowURLSend);
					}
				}
				
				// trich yeu
				rowSend.addText(pmlEdmDocumentSend.getBriefContent());
				
				// loai cong van
				long pmlDocumentTypeId = pmlEdmDocumentSend.getDocumentTypeId();
				String nameDocumentType = "";
				try {
					PmlEdmDocumentType pmlEdmDocumentType = PmlEdmDocumentTypeUtil.findByPrimaryKey(pmlDocumentTypeId);
					nameDocumentType = pmlEdmDocumentType.getDocumentTypeName();
				} catch (Exception ex){}
				
				rowSend.addText(nameDocumentType);
				
				//Nguoi ky
				rowSend.addText(pmlEdmDocumentSend.getSignerName());
				
				// phong soan thao
				String editorName = "";
				String nameDepartment = "";
				long editorId = pmlEdmDocumentSend.getEditorId();
				
				try {
					PmlUser userSend = PmlUserUtil.findByPrimaryKey(editorId);
					editorName = userSend.getLastName() + " " + userSend.getMiddleName() + " " + userSend.getFirstName();
				nameDepartment = DepartmentUtil.findByPrimaryKey(userSend.getDepartmentsId()).getDepartmentsName();
				} catch (Exception ex){}
				
				if (nameDepartment.length() > 0) {
					if (editorName.length() > 0) {
						rowSend.addText(nameDepartment + " (" + editorName + ")");
					}
					else {
				rowSend.addText(nameDepartment);
					}
				}
				else {
					rowSend.addText("");
				}
				
				// noi nhan cong van
				String noiPhatHanh = ""; 
				
				try {
					String issuePlaceId = pmlEdmDocumentSend.getReceivingPlace();
					noiPhatHanh = PmlEdmIssuingPlaceUtil.findByPrimaryKey(issuePlaceId).getIssuingPlaceName();
				} catch (Exception ex){}
				
				if (noiPhatHanh.equals("")) {
					noiPhatHanh = pmlEdmDocumentSend.getReceivingPlace();
				}		
				
				rowSend.addText(noiPhatHanh);
				
				// Toan van
				List<PmlEdmAttachedFile> pmlEdmAttachedFileList = new ArrayList<PmlEdmAttachedFile>();
				String toanVan = "";
				try {
					pmlEdmAttachedFileList = PmlEdmAttachedFileUtil.findByObjectContentId(pmlEdmDocumentSend.getDocumentSendId());
				} catch (Exception ex) {}
				
				for (int j = 0; j < pmlEdmAttachedFileList.size(); j++ ) {
					//xuancong close toanVan += "<a href='"+ pmlEdmAttachedFileList.get(j).getPath() +"'><u><img src='/html/images/icon_download.png'>&nbsp;" + pmlEdmAttachedFileList.get(j).getAttachedFileName().substring(14, pmlEdmAttachedFileList.get(j).getAttachedFileName().length()) + "</u></a> <br/>";
					// Chi hien icon download va title cua hinh
					if (toanVan.trim().length() > 0) {
						toanVan += "<br />";
					}
					toanVan += "<a href='"+ pmlEdmAttachedFileList.get(j).getPath() +"'><img src='/html/images/icon_download.png' title='" + pmlEdmAttachedFileList.get(j).getAttachedFileName().substring(14, pmlEdmAttachedFileList.get(j).getAttachedFileName().length()) + "'></a>";
				}
				
				rowSend.addText(toanVan);
		
				// Edit
				if(PortletPermissionUtil.contains(permissionChecker, plid, "SGS_PCCCDOCUMENTSENDPROCESS", ActionKeysExt.TIEPNHANCV)){					
					rowSend.addText(editImage_, rowURL_);
				}
				
				// Delete
				if(PortletPermissionUtil.contains(permissionChecker, plid, "SGS_PCCCDOCUMENTSENDPROCESS", ActionKeysExt.TIEPNHANCV)){					
					rowSend.addText(delImg, rowDelURL_);
				}
		
				resultRowsSend.add(rowSend);
			}// yenlt 25052010
		}
	%>

	<liferay-ui:search-iterator searchContainer="<%= searchContainerSend %>" />
<%
	}
	/*yenlt close 25052010
} catch (Exception e) {
	e.printStackTrace();
}
 end yenlt */
%>
	
</form>