<%@ include file="/html/portlet/ext/pcccdocumentreceiptreport/init.jsp" %>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.sgs.portlet.pcccdocumentreceiptreport.search.DocumentDetailDisplayTerms"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<liferay-util:include page="/html/portlet/ext/pcccdocumentreceiptreport/js/quanlycongvan_report.jsp"></liferay-util:include>
<div id="<portlet:namespace/>listdocument" class="listdocument-cv"></div>
<%
	String departmentId = ParamUtil.getString(renderRequest, "departmentId");
	long userId = ParamUtil.getLong(renderRequest, "userId");
	
	int documentRecordTypeId = ParamUtil.getInteger(renderRequest, "nhomCongVan");
	String loaiCongVan = ParamUtil.getString(renderRequest, "loaiCongVan");
	String doMat = ParamUtil.getString(renderRequest, "doMat");
	String from_Date = ParamUtil.getString(renderRequest, "fromDate");
	String to_Date = ParamUtil.getString(renderRequest,"toDate");
	String redirect = ParamUtil.getString(renderRequest,"redirect");
	
	Date fromDate = null;
	Date toDate = null;
	if (!"".equals(from_Date) || !"".equals(to_Date)) {
		fromDate = new SimpleDateFormat("dd/MM/yyyy").parse(from_Date);
		toDate = new SimpleDateFormat("dd/MM/yyyy").parse(to_Date);
	} else {
		
		fromDate = new SimpleDateFormat("dd/MM/yyyy").parse(  new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
		toDate = new SimpleDateFormat("dd/MM/yyyy").parse( new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
	}
	
	String action = ParamUtil.getString(renderRequest, "action");
	String rowDS = ParamUtil.getString(renderRequest, "row");
	String userIdRow = ParamUtil.getString(renderRequest, "userIdRow");
	//yenlt update 28062010
	boolean radioTenPhongBan = ParamUtil.getBoolean(renderRequest, "radioTenPhongBan");
	boolean radioTenChuyenVien = ParamUtil.getBoolean(renderRequest, "radioTenChuyenVien");
	//end yenlt update 28062010
%>
<%
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(LiferayWindowState.EXCLUSIVE);
	if ("congvanden".equals(loaiCongVan)) {
		portletURL.setParameter("struts_action", "/sgs/pcccdocumentreceiptreport/pcccdocumentreceiptdetails");
	} else {
		portletURL.setParameter("struts_action", "/sgs/pcccdocumentreceiptreport/pcccdocumentsenddetails");
	}
	
	portletURL.setParameter(DocumentDetailDisplayTerms.DEPARTMENTID, departmentId);
	portletURL.setParameter(DocumentDetailDisplayTerms.USERID, String.valueOf(userId));
	portletURL.setParameter(DocumentDetailDisplayTerms.NHOMCONGVAN, String.valueOf(documentRecordTypeId));
	portletURL.setParameter(DocumentDetailDisplayTerms.LOAICONGVAN , loaiCongVan);
	portletURL.setParameter(DocumentDetailDisplayTerms.DOMAT , doMat);
	portletURL.setParameter(DocumentDetailDisplayTerms.FROMDATE, from_Date);
	portletURL.setParameter(DocumentDetailDisplayTerms.TODATE, to_Date);
	portletURL.setParameter("radioTenChuyenVien", String.valueOf(radioTenChuyenVien)); //yenlt update 28062010
	portletURL.setParameter("radioTenPhongBan", String.valueOf(radioTenPhongBan)); //yenlt update 28062010
	portletURL.setParameter("redirect", redirect);
	portletURL.setParameter("action", action);
	portletURL.setParameter("row", rowDS);
	portletURL.setParameter("userIdRow", userIdRow);
	portletURL.setParameter("curVal", ParamUtil.getString(renderRequest, "curVal"));
%>

<script type="text/javascript">
	viewListDocumentReport('<%= portletURL.toString() %>');
</script >