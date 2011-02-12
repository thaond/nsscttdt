<%@ include file="/html/portlet/ext/pcccdocumentrecordto/init.jsp" %>
<%@page import="java.util.List"%>
<%@page import="com.sgs.portlet.document.receipt.model.PmlEdmDocumentType"%>
<%@page import="com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentTypeUtil"%>
<%@page import="com.sgs.portlet.pcccdocumentrecordto.search.DocumentRecordToSearchTerms"%>
<%@page import="com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.sgs.portlet.pmlissuingplace.service.persistence.PmlEdmIssuingPlaceUtil"%>
<%@page import="com.sgs.portlet.pcccdocumentrecordto.search.DocumentRecordToSearch"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.sgs.portlet.pml_edm_docconfuser.model.PmlEdmDocConfUser"%>
<%@page import="com.sgs.portlet.pml_edm_docconfuser.service.PmlEdmDocConfUserLocalServiceUtil"%>
<%@page import="com.sgs.portlet.pmluser.model.PmlUser"%>
<%@page import="com.sgs.portlet.pmluser.service.PmlUserLocalServiceUtil"%>
<%@page import="java.util.StringTokenizer"%>
<%@page import="com.sgs.portlet.document.service.persistence.PmlDocumentReceiptLogUtil"%>
<%@page import="com.sgs.portlet.document.receipt.model.PmlEdmConfidentialLevel"%>
<%@page import="com.sgs.portlet.document.receipt.service.persistence.PmlEdmConfidentialLevelUtil"%>

<portlet:actionURL var="filter">
	<portlet:param name="struts_action" value="/sgs/pcccdocumentrecordto/view" />
</portlet:actionURL>

<portlet:actionURL var="inBaoCaoXuatExcel">
	<portlet:param name="struts_action" value="/sgs/pcccdocumentrecordto/view" />
	<portlet:param name="cmd" value="report" />
</portlet:actionURL>

<script type="text/javascript">
	function <portlet:namespace />addActionFrom(reportType) {
		var action = "<%= inBaoCaoXuatExcel %>&<portlet:namespace />reportType=" + reportType;
		document.getElementsByName("<portlet:namespace />fm")[0].setAttribute("action", action);
	}
	function <portlet:namespace />setActionFrom() {
		document.getElementsByName("<portlet:namespace />fm")[0].setAttribute("action", "");
}
</script>
<%
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action", "/sgs/pcccdocumentrecordto/view");

	DocumentRecordToSearch searchContainer = new DocumentRecordToSearch(renderRequest, portletURL);
%>

<form name="<portlet:namespace />fm" action="<%= filter %>" method="post">
<div class="title_categ"><liferay-ui:message key="so-van-ban-den-cua-phong"/></div>
<div class="boxcontent">
	<%@ include file="/html/portlet/ext/pcccdocumentrecordto/docrecordto_search.jsp" %>

	<%
	SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
	DocumentRecordToSearchTerms searchTerms = (DocumentRecordToSearchTerms)searchContainer.getSearchTerms();
	%>

	<%@ include file="/html/portlet/ext/pcccdocumentrecordto/docrecordto_search_results.jspf" %>

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
			PmlUser curUser = PmlUserLocalServiceUtil.findByUserId(userId);
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
	for (int idx = 0; idx < results.size(); idx ++) {
		arlDocId.add(((PmlEdmDocumentReceipt) results.get(idx)).getDocumentReceiptId());
	}

	// Get ArrayList DepId for docId
	ArrayList<String> arlDepIdForDocIdList = PmlEdmDocConfUserLocalServiceUtil.getDepIdListForRecDocIdList(arlDocId);
	
	List resultRows = searchContainer.getResultRows();

	for (int idx = 0; idx < results.size(); idx++) {
		PmlEdmDocumentReceipt docRecItem = (PmlEdmDocumentReceipt)results.get(idx);

		docRecItem = docRecItem.toEscapedModel();

		ResultRow row = new ResultRow(docRecItem, docRecItem.getDocumentReceiptId(), idx);

		PortletURL rowURL = renderResponse.createRenderURL();

		rowURL.setWindowState(WindowState.NORMAL);

		rowURL.setParameter("struts_action", "/sgs/pcccdocumentrecordto/detail");
		rowURL.setParameter("redirect", currentURL);
		rowURL.setParameter("docRecId", String.valueOf(docRecItem.getDocumentReceiptId()));
		
		boolean showDetail = false;
		
		// Neu van ban nay khong mat thi cho xem
		if (confNoLimitViewDetailIds != null && !confNoLimitViewDetailIds.isEmpty() && 
				docRecItem.getConfidentialLevelId().length() > 0 && 
				confNoLimitViewDetailIds.contains(docRecItem.getConfidentialLevelId())) {
			showDetail = true;
		}
		else if (docRecItem.getConfidentialLevelId().length() > 0) {
			if (confNoNeedHaveProcessIds != null && !confNoNeedHaveProcessIds.isEmpty() && 
					confNoNeedHaveProcessIds.contains(docRecItem.getConfidentialLevelId())) {
		String viewDepIdDetail = arlDepIdForDocIdList.get(arlDocId.indexOf(docRecItem.getDocumentReceiptId()));
		if (viewAllDoc == true) {
			showDetail = true;
		}
		else {
			String[] arrViewDepIdDetail = viewDepIdDetail.split(",");
			for (int j = 0; j < arrViewDepIdDetail.length; j++) {
				if (arlViewDepDoc.contains(arrViewDepIdDetail[j])) {
					showDetail = true;
					break;
				}
			}
		}
			}
		}
		// Cho phep nguoi dung xem duoc chi tiet nhung van ban do minh xu ly
		if (showDetail == false) {
			if (!PmlDocumentReceiptLogUtil.findByDocumentReceiptId_Processor(docRecItem.getDocumentReceiptId(), userId).isEmpty()) {
				showDetail = true;
			}
			else if (!PmlDocumentReceiptLogUtil.findByDocumentReceiptId_Receiver(docRecItem.getDocumentReceiptId(), userId).isEmpty()) {
				showDetail = true;
			}
		}

		// Stt
		row.addText(String.valueOf(idx + 1));

		// So noi bo
		if (showDetail == true) {
			row.addText(docRecItem.getNumberDocumentReceipt(), rowURL);
		}
		else {
			row.addText(docRecItem.getNumberDocumentReceipt());
		}

		// So hieu goc
		if (showDetail == true) {
			row.addText(docRecItem.getDocumentReference(), rowURL);
		}
		else {
			row.addText(docRecItem.getDocumentReference());
		}

		// Loai van ban
		String docTypeName = "";
		if (docRecItem.getDocumentTypeId() > 0) {
			try {
				docTypeName = PmlEdmDocumentTypeUtil.findByPrimaryKey(docRecItem.getDocumentTypeId()).getDocumentTypeName();
			}
			catch (Exception ex) {
				// Do nothing
			}
		}
		row.addText(docTypeName);
		
		// Ngay van ban den
		if (docRecItem.getDateArrive() != null) {
			row.addText(String.valueOf(format.format(docRecItem.getDateArrive())));
					}
		else {
			row.addText("");
		}

		// Ngay ban hanh
		if (docRecItem.getIssuingDate() != null) {
			row.addText(String.valueOf(format.format(docRecItem.getIssuingDate())));
		}
		else {
			row.addText("");
		}

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
		row.addText(issPlaceDesc);
		
		// Trich yeu
		row.addText(docRecItem.getBriefContent());
		
		// Add result row
		resultRows.add(row);
	}
	%>

	<liferay-ui:search-iterator searchContainer="<%= searchContainer %>" />
</div>
</form>