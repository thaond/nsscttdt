<%@ include file="/html/portlet/ext/congvandidahoanthanh/init.jsp" %>

<%@page import="com.sgs.portlet.congvandidahoanthanh.search.CVDiDaHoanThanhSearch"%>
<%@page import="com.sgs.portlet.congvandidahoanthanh.search.CVDiDaHoanThanhSearchTerms"%>


<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.sgs.portlet.document.send.model.PmlEdmDocumentSend"%>
<%@page import="com.sgs.portlet.document.send.service.PmlEdmDocumentSendLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@page import="com.sgs.portlet.document.receipt.model.PmlEdmDocumentType"%>
<%@page import="com.sgs.portlet.document.receipt.service.PmlEdmDocumentTypeLocalServiceUtil"%>
<%@page import="com.sgs.portlet.pcccdocumentreceiptreport.util.TinhHinhThuLyCongVanDWRUtil"%>

<portlet:actionURL var="report">
	<portlet:param name="struts_action" value="/sgs/congvandidahoanthanh/view" />
</portlet:actionURL>

<div id="divparent">
<form name="<portlet:namespace />frmReport" action="<%= report %>" method="post" >
<div id="div-head-title"><liferay-ui:message key="cong-van-di-da-hoan-thanh"/></div>
<%
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(WindowState.MAXIMIZED);
	portletURL.setParameter("struts_action", "/sgs/congvandidahoanthanh/view");
	
	CVDiDaHoanThanhSearch cvDiDaHoanThanhSearch = new CVDiDaHoanThanhSearch(renderRequest, portletURL);
	CVDiDaHoanThanhSearchTerms searchTerms = (CVDiDaHoanThanhSearchTerms)cvDiDaHoanThanhSearch.getSearchTerms();
	
	int[] loaiSoCongVanChecked = (int[]) renderRequest.getAttribute("loaiSoCongVanChecked");
	int length = loaiSoCongVanChecked.length;
	
	String listLoaiSoCongVanChecked = "";
	for (int i = 0; i < length; i++) {
		
		if (i < length - 1) {
			listLoaiSoCongVanChecked +=  String.valueOf(loaiSoCongVanChecked[i]).concat(",") ;
			continue;
		}
		listLoaiSoCongVanChecked +=  String.valueOf(loaiSoCongVanChecked[i]);
	}
%>

<liferay-ui:search-form
	page="/html/portlet/ext/congvandidahoanthanh/search.jsp"
	searchContainer="<%= cvDiDaHoanThanhSearch %>" />

<%
	if (length != 0) {
%>

<br />
<div align="center">
	<font class="report-title-HS"><liferay-ui:message key="baocaotonghopcongvandahoanthanh" /><br/><liferay-ui:message key="congvandi" /></font><br/>
	<font class="description-report-title">
	(<liferay-ui:message key="tinhhinhthulycongvan.tungay" /> 
	<%= HtmlUtil.escape(searchTerms.getFromDate()) %> 
	<liferay-ui:message key="tinhhinhthulycongvan.denngay" /> 
	<%= HtmlUtil.escape(searchTerms.getToDate()) %>)
	</font>
</div>
<br />

<%
		List<PmlEdmDocumentSend> pmlEdmDocumentSendList = new ArrayList<PmlEdmDocumentSend>();
		int total = 0;
		
		try {
			pmlEdmDocumentSendList = PmlEdmDocumentSendLocalServiceUtil.getListPmlEdmDocumentSendByLoaiSoCV
											(listLoaiSoCongVanChecked, searchTerms.getFromDate(), searchTerms.getToDate(), 
											cvDiDaHoanThanhSearch.getStart(), cvDiDaHoanThanhSearch.getEnd(), cvDiDaHoanThanhSearch.getOrderByComparator());
			total = PmlEdmDocumentSendLocalServiceUtil.countListPmlEdmDocumentSendByLoaiSoCV(listLoaiSoCongVanChecked, searchTerms.getFromDate(), searchTerms.getToDate());
		} catch (Exception e) { }
		
		cvDiDaHoanThanhSearch.setTotal(total);
		cvDiDaHoanThanhSearch.setResults(pmlEdmDocumentSendList);
		portletURL.setParameter(cvDiDaHoanThanhSearch.getCurParam(), String.valueOf(cvDiDaHoanThanhSearch.getCurValue()));
		
		List resultRows = cvDiDaHoanThanhSearch.getResultRows();
		ResultRow row = null;
		
		PmlEdmDocumentSend cvdi = null;
		
		if (pmlEdmDocumentSendList.size() != 0) {			
			for (int j = 0; j < pmlEdmDocumentSendList.size(); j ++) {
				cvdi = pmlEdmDocumentSendList.get(j);
				
				row = new ResultRow(cvdi, cvdi.getDocumentSendId(), j);
				
				// stt
				row.addText((j + 1) + ".");
				// ngay phat hanh
				row.addText(new SimpleDateFormat("dd-MM-yyyy").format(cvdi.getIssuingDate()));
				// noi dung
				row.addText(cvdi.getBriefContent());
				// loai cong van
				PmlEdmDocumentType pmlEdmDocumentType = null;
				try {
					pmlEdmDocumentType = PmlEdmDocumentTypeLocalServiceUtil.getPmlEdmDocumentType(cvdi.getDocumentTypeId());
				} catch (Exception e) {	}
				if (pmlEdmDocumentType != null) {
					row.addText(pmlEdmDocumentType.getDocumentTypeName());
				} else {
					row.addText("");
				}
				// nguoi soan van ban
				String tenNguoiSoanVB = "";
				try {
					tenNguoiSoanVB = TinhHinhThuLyCongVanDWRUtil.getFullName(cvdi.getEditorId());
				} catch (Exception e) {	}
				if (tenNguoiSoanVB != null) {
					row.addText(tenNguoiSoanVB);
				} else {
					row.addText("");
				}
				// nguoi ky van ban
				row.addText(cvdi.getSignerName());
				// noi nhan
				row.addText(cvdi.getReceivingPlace());
				// nguoi theo doi
				row.addText("");
				// ghi chu
				row.addText("");
				
				resultRows.add(row);
			}
		}
 %> 

<liferay-ui:search-iterator searchContainer="<%=cvDiDaHoanThanhSearch %>" />
		  
 <% } %>

<table id="table-button">
	<tr><td>
		<input class="button-width" type="submit" value='<liferay-ui:message key="tinhhinhthulycongvan.inbaocao" />' onclick="<portlet:namespace />setActionFrom('<portlet:namespace />report=true');<portlet:namespace />frmReport.submit();" />
	</td></tr>
</table>

</form>
</div>