<%@page import="com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentReceiptUtil"%>
<%@page import="com.sgs.portlet.pmluser.service.PmlUserLocalServiceUtil"%>
<%@page import="com.sgs.portlet.pmluser.model.PmlUser"%>
<%@page import="com.sgs.portlet.pmluser.service.persistence.PmlUserUtil"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="org.apache.commons.collections.ListUtils"%>
<%@page import="javax.portlet.PortletRequest"%>
<%@page import="com.liferay.portlet.PortletURLImpl"%>
<%@page import="com.ext.portal.security.permission.ActionKeysExt"%>
<%@page import="com.liferay.portal.service.permission.PortletPermissionUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.sgs.portlet.document.receipt.model.impl.PmlEdmDocumentReceiptImpl"%>
<%@page import="com.sgs.portlet.document.receipt.service.persistence.PmlEdmAttachedFileUtil"%>
<%@page import="com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile"%>
<%@page import="com.sgs.portlet.pmlissuingplace.service.persistence.PmlEdmIssuingPlaceUtil"%>
<%@page import="com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace"%>
<%@page import="com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentTypeUtil"%>
<%@page import="com.sgs.portlet.doccumentprivate.search.DocumentPrivateSearchTearms"%>
<%@page import="com.sgs.portlet.doccumentprivate.search.DocumentPrivateSearch"%>
<%@include file="/html/portlet/sgs/doccumentprivate/init.jsp" %>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.sgs.portlet.document.receipt.service.PmlEdmDocumentReceiptLocalServiceUtil"%>
<%@page import="com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt"%>
<%@page import="java.util.List"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<link type="text/css" rel="stylesheet" href="/html/portlet/ext/pcccdocumentreceiptprocess/css/letter.css" />
<script type="text/javascript"	src="/html/js/calendar.js"></script>
<script type="text/javascript"	src="/html/js/calendar-setup.js"></script>
<script type="text/javascript"	src="/html/js/calendar-en.js"></script>
<link type="text/css" rel="stylesheet"	href="/html/css/calendar-system.css" />



<%
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setParameter("struts_action", "/sgs/doccumentprivate/search");
	portletURL.setParameter("flag", "flag");
	String portletURLString = portletURL.toString();
%>

<form action="<%=portletURLString%>" method="post" name="<portlet:namespace />fm">
	<input type="hidden" name="<portlet:namespace/>listUserId">
	<div class="boxcontent">
		<%
		DocumentPrivateSearch searchContainer = new DocumentPrivateSearch(renderRequest, portletURL);
		DocumentPrivateSearchTearms searchTearms = (DocumentPrivateSearchTearms) searchContainer.getSearchTerms();
		List headerNames = searchContainer.getHeaderNames();
		String departmentProcessId = "";
		long userId = 0;
		String listUserId = "";
		try {
			userId = PortalUtil.getUserId(renderRequest);
			PmlUser pmlUserLogin = PmlUserLocalServiceUtil.getPmlUser(userId);
			departmentProcessId = pmlUserLogin.getDepartmentsId();
			
			List<PmlUser> pmlUsers = PmlUserUtil.findByDepartmentsId(pmlUserLogin.getDepartmentsId());
			
			for (PmlUser pmlUser : pmlUsers) {
				listUserId += String.valueOf(pmlUser.getUserId()).concat(",");
			}
			listUserId = listUserId.substring(0, listUserId.length() - 1);
			if (searchTearms.getListUserId() == null || "".equals(searchTearms.getListUserId())) {
				renderRequest.setAttribute("listUserId", listUserId);
			} else {
				listUserId = searchTearms.getListUserId();
				renderRequest.setAttribute("listUserId", searchTearms.getListUserId());
			}
			
			
			
		} catch (Exception e) {}
		%>
		<liferay-ui:search-form	
			page="/html/portlet/sgs/doccumentprivate/search.jsp"
		searchContainer="<%= searchContainer %>"></liferay-ui:search-form>
		
		
		<%
		if(renderRequest.getAttribute("flag")!= null){	
		int total = PmlEdmDocumentReceiptLocalServiceUtil.countBy_isPublic_mainDepartmentProcessId_Date("", departmentProcessId, searchTearms.getTuNgay(), searchTearms.getDenNgay(), listUserId);
		searchContainer.setTotal(total);
		
		List<PmlEdmDocumentReceipt> result = PmlEdmDocumentReceiptLocalServiceUtil.findBy_isPublic_mainDepartmentProcessId_Date("", departmentProcessId, searchTearms.getTuNgay(), searchTearms.getDenNgay(), listUserId, 
														searchContainer.getStart(), searchContainer.getEnd(),  searchContainer.getOrderByComparator());
		searchContainer.setResults(result);
		
		
		%>
		<%
			PortletURL rowURL = renderResponse.createRenderURL();
			rowURL.setParameter("struts_action", "/sgs/doccumentprivate/detail");
					
			PortletURL rowDelURL_ = renderResponse.createActionURL();
			rowDelURL_.setParameter("struts_action", "/sgs/doccumentprivate/search");
			rowDelURL_.setParameter("delete", "delete");
			rowDelURL_.setParameter("companyId", String.valueOf(user.getCompanyId()));
			
			
			String toanVanURL = "";	
			List<PmlEdmAttachedFile> attachedFiles = null;
			String ngayPhatHanh = "";
			String issuingPlaceId = "";
			PmlEdmIssuingPlace pmlEdmIssuingPlace = null;
			List resultRows = searchContainer.getResultRows();
				for (int i = 0; i < result.size(); i++) {
					PmlEdmDocumentReceipt pmlEdmDocumentReceipt = (PmlEdmDocumentReceipt) result.get(i);
					pmlEdmDocumentReceipt = pmlEdmDocumentReceipt.toEscapedModel();
					ResultRow row = new ResultRow(pmlEdmDocumentReceipt, pmlEdmDocumentReceipt.getDocumentReceiptId(), i);
					
					rowURL.setParameter("documentReceiptId", String.valueOf(pmlEdmDocumentReceipt.getDocumentReceiptId()));
					rowURL.setParameter("redirect", searchContainer.getIteratorURL().toString());
					
					rowDelURL_.setParameter("documentReceiptId", String.valueOf(pmlEdmDocumentReceipt.getDocumentReceiptId()));
					
					
					// STT
					row.addText ((i + 1) + "");
					
					// So van ban den
					row.addText(pmlEdmDocumentReceipt.getDocumentReference(), rowURL);
					
					// So vao so
					row.addText(pmlEdmDocumentReceipt.getNumberDocumentReceipt(), rowURL);
					
					//Loai van ban
					
					try{
						row.addText(PmlEdmDocumentTypeUtil.findByPrimaryKey(pmlEdmDocumentReceipt.getDocumentTypeId()).getDocumentTypeName());	
					} catch(Exception e) {
						row.addText("");
					}
					
					// Lay noi phat hanh
					
					issuingPlaceId = pmlEdmDocumentReceipt.getIssuingPlaceId();
					
					if(issuingPlaceId.equals("")){
						row.addText(pmlEdmDocumentReceipt.getIssuingPlaceOtherName());
					}
					else{
						
						try{
							pmlEdmIssuingPlace = PmlEdmIssuingPlaceUtil.findByPrimaryKey(issuingPlaceId);
							row.addText(pmlEdmIssuingPlace.getIssuingPlaceName());
						} catch(Exception e){
							row.addText("");
						}
					}
					
					
					// Ngay den
					ngayPhatHanh = "";
					if(pmlEdmDocumentReceipt.getIssuingDate() != null){
						ngayPhatHanh = new SimpleDateFormat("dd/MM/yyyy").format(pmlEdmDocumentReceipt.getIssuingDate());
					}
					row.addText(ngayPhatHanh);
					
					// Trich yeu
					row.addText(pmlEdmDocumentReceipt.getBriefContent());
					
					// Nguoi ky
					row.addText(pmlEdmDocumentReceipt.getSigner(), rowURL);
					
					// Toan van
					
					attachedFiles = null;
					try {
						attachedFiles = PmlEdmAttachedFileUtil.findByObjectContentId_ObjectType(pmlEdmDocumentReceipt.getDocumentReceiptId(), 
																new PmlEdmDocumentReceiptImpl().getClass().getName());
					} catch (Exception e) {
						attachedFiles = new  ArrayList<PmlEdmAttachedFile> ();
					}
		
					
					toanVanURL = "";
					for (int j = 0; j < attachedFiles.size(); j ++) {
						PmlEdmAttachedFile attachedFile = attachedFiles.get(j);
						// Chi hien thi hinh download va title cua hinh
						if (toanVanURL.length() > 0) {
							toanVanURL += "<br />";
						}
						toanVanURL += "<a href=\"" + attachedFile.getPath() + "\"><img src='/html/images/icon_download.png' title='" + (attachedFile.getTitle().trim().length() > 0 ? attachedFile.getTitle() : attachedFile.getAttachedFileName()) + "'></a>";
					}
					row.addText(toanVanURL);
					
					// Edit
					String editImage = "<img src='/html/images/edit.png'>";
					row.addText(editImage, "");
		
					// Delete
					row.addText("<a href='javascript:' onclick=deleteDocumentRecept('" +rowDelURL_ .toString()+"')><img src='/html/images/xoa.gif'></a>");
					
					
					resultRows.add(row);
					
					}
		%>
		
		<liferay-ui:search-iterator  searchContainer="<%= searchContainer %>" />
	</div>
	
	<% } %>
		<script type="text/javascript">
			function deleteDocumentRecept(url){
				if(confirm("<liferay-ui:message key='sgs_field_deleteMessage'/>")){
					document.<portlet:namespace />fm.method = "post";
					submitForm(document.<portlet:namespace/>fm, url);
				}
			}
		</script>

</form>

