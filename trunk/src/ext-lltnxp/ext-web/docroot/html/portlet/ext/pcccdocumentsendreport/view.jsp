<%@ include file="/html/portlet/ext/pcccdocumentsendreport/init.jsp" %>

<%@page import="java.util.List"%>
<%@page import="com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentTypeUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.sgs.portlet.pcccdocumentsendreport.search.DocSendReportSearch"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.sgs.portlet.pcccdocumentsendreport.search.DocSendReportSearchTerms"%>
<%@page import="com.sgs.portlet.document.send.service.PmlEdmDocumentSendLocalServiceUtil"%>
<%@page import="com.sgs.portlet.document.send.model.PmlEdmDocumentSend"%>
<%@page import="com.sgs.portlet.pml_edm_docconfuser.model.PmlEdmDocConfUser"%>
<%@page import="com.sgs.portlet.pml_edm_docconfuser.service.PmlEdmDocConfUserLocalServiceUtil"%>
<%@page import="com.sgs.portlet.pmluser.service.PmlUserLocalServiceUtil"%>
<%@page import="java.util.StringTokenizer"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@page import="com.sgs.portlet.document.service.persistence.PmlDocumentSendLogUtil"%>


<%@page import="com.sgs.portlet.department.service.DepartmentLocalServiceUtil"%><portlet:actionURL var="filter">
	<portlet:param name="struts_action" value="/sgs/pcccdocumentsendreport/view" />
</portlet:actionURL>

<portlet:actionURL var="inBaoCaoXuatExcel">
	<portlet:param name="struts_action" value="/sgs/pcccdocumentsendreport/view" />
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
	portletURL.setParameter("struts_action", "/sgs/pcccdocumentsendreport/view");

	DocSendReportSearch searchContainer = new DocSendReportSearch(renderRequest, portletURL);
%>

<form name="<portlet:namespace />fm" action="<%= filter %>" method="post">
<div class="title_categ"><liferay-ui:message key="so-van-ban-di-cua-phong"/></div>
<div class="boxcontent">
<%@ include file="/html/portlet/ext/pcccdocumentsendreport/docsendreport_search.jsp" %>

<input type="hidden" name="orderByCol" value="<%= searchContainer.getOrderByCol() %>"/>
<input type="hidden" name="orderByType" value="<%= searchContainer.getOrderByType() %>"/>

<%
	SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
	DocSendReportSearchTerms searchTerms = (DocSendReportSearchTerms)searchContainer.getSearchTerms();

	int total = PmlEdmDocumentSendLocalServiceUtil.countByVBDi_SoVBDiCuaPhong(searchTerms.getSoPH(), searchTerms.getNgayPHMonth(), 
				searchTerms.getNgayPHYear(), searchTerms.getPhongST(), searchTerms.getNoiNhan(), searchTerms.getLoaiVB(), 
				searchTerms.getNguoiKy(), searchTerms.getNguoiST(), searchTerms.getTrichYeu(), searchTerms.getVanBanPH()); 
	
	List<PmlEdmDocumentSend> results = PmlEdmDocumentSendLocalServiceUtil.findByVBDi_SoVBDiCuaPhong(searchTerms.getSoPH(), 
				searchTerms.getNgayPHMonth(), searchTerms.getNgayPHYear(), searchTerms.getPhongST(), searchTerms.getNoiNhan(), 
				searchTerms.getLoaiVB(), searchTerms.getNguoiKy(), searchTerms.getNguoiST(), searchTerms.getTrichYeu(), 
				searchTerms.getVanBanPH(), searchContainer.getStart(), searchContainer.getEnd(), searchContainer.getOrderByComparator());

	searchContainer.setTotal(total);
	searchContainer.setResults(results);
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
		} 
		else {
			viewDepDoc = dcuCur.getViewDepDoc();
			// Gan them phong ban cua nguoi dung vao danh sach nay
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
	}
	// Get ArrayList of document
	ArrayList<Long> arlDocId = new ArrayList<Long>();
	for (int idx = 0; idx < results.size(); idx ++) {
		arlDocId.add(((PmlEdmDocumentSend) results.get(idx)).getDocumentSendId());
	}
	// Get ArrayList DepId for docId
	ArrayList<String> arlDepIdForDocIdList = PmlEdmDocConfUserLocalServiceUtil.getDepIdListForSenDocIdList(arlDocId);
	
	List resultRows = searchContainer.getResultRows();
	PmlUser editor = null;
	Department department = null;

	for (int idx = 0; idx < results.size(); idx++) {
		PmlEdmDocumentSend docSendItem = (PmlEdmDocumentSend)results.get(idx);

		docSendItem = docSendItem.toEscapedModel();

		ResultRow row = new ResultRow(docSendItem, docSendItem.getDocumentSendId(), idx);

		PortletURL rowURL = renderResponse.createRenderURL();
		rowURL.setWindowState(WindowState.NORMAL);
		rowURL.setParameter("struts_action", "/sgs/pcccdocumentsendreport/detail");
		rowURL.setParameter("redirect", currentURL);
		rowURL.setParameter("docSendId", String.valueOf(docSendItem.getDocumentSendId()));
		
		boolean showDetail = false;
		
		String viewDepIdDetail = arlDepIdForDocIdList.get(arlDocId.indexOf(docSendItem.getDocumentSendId()));
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
		// Cho phep chuyen vien xem nhung van ban di ma ho co tham gia xu ly
		if (showDetail == false) {
			if (!PmlDocumentSendLogUtil.findByDocumentSendId_Processor(docSendItem.getDocumentSendId(), userId).isEmpty()) {
				showDetail = true;
			} // end if 
			else if (!PmlDocumentSendLogUtil.findByDocumentSendId_Receiver(docSendItem.getDocumentSendId(), userId).isEmpty()) {
				showDetail = true;
			}
		} // end if

		// Stt
		row.addText(String.valueOf(idx + 1));

		// So phat hanh
		if (showDetail == true) {
			row.addText(docSendItem.getDocumentReference(), rowURL);
		}
		else {
			row.addText(docSendItem.getDocumentReference());
		}
		
		// Loai van ban
		String docTypeName = "";
		if (docSendItem.getDocumentTypeId() > 0) {
			try {
				docTypeName = PmlEdmDocumentTypeUtil.findByPrimaryKey(docSendItem.getDocumentTypeId()).getDocumentTypeName();
			}
			catch (Exception ex) {
				// Do nothing
			}
		}
		row.addText(docTypeName);
		
		// Ngay phat hanh
		if (docSendItem.getIssuingDate() != null) {
			row.addText(String.valueOf(format.format(docSendItem.getIssuingDate())));
		}
		else {
			row.addText("");
		}

		// Trich yeu
		row.addText(docSendItem.getBriefContent());
		
		// Don vi soan thao
		String departmentName = "";
		try {
			editor = PmlUserLocalServiceUtil.getPmlUser(docSendItem.getEditorId());
			department = DepartmentLocalServiceUtil.getDepartment(editor.getDepartmentsId());
			departmentName = department.getDepartmentsName();
		}
		catch (Exception ex) {}
		row.addText(departmentName);
		
		// Add result row
		resultRows.add(row);
	}
	%>

	<liferay-ui:search-iterator searchContainer="<%= searchContainer %>" />
</div>
</form>