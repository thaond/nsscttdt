<%@ include file="/html/portlet/ext/home_report/init.jsp" %>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>

<liferay-util:include page="/html/portlet/ext/home_report/js/quanlyvanban_report.jsp"></liferay-util:include>
<div id="<portlet:namespace/>listdocument" class="listdocument-cv"></div>

<%
	String departmentId = ParamUtil.getString(renderRequest, "departmentId");
	long userId = ParamUtil.getLong(renderRequest, "userId");
	String loaiThongKe = ParamUtil.getString(renderRequest, "loaiThongKe");
	
	String fromDate = ParamUtil.getString(renderRequest, "fromDate");
	String toDate = ParamUtil.getString(renderRequest,"toDate");
	
	String action = ParamUtil.getString(renderRequest, "action");
	String row = ParamUtil.getString(renderRequest, "row");
	String redirect = ParamUtil.getString(renderRequest,"redirect");
%>

<%
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(LiferayWindowState.EXCLUSIVE);
	
	if ("congvanden".equals(loaiThongKe)) {
		portletURL.setParameter("struts_action", "/sgs/home_report/documentreceiptviewlist");
	} else if ("congvandi".equals(loaiThongKe)) {
		portletURL.setParameter("struts_action", "/sgs/home_report/documentsendviewlist");
	}
	
	portletURL.setParameter(HomeReportDisplayTerms.DEPARTMENTID, departmentId);
	portletURL.setParameter(HomeReportDisplayTerms.USERID, String.valueOf(userId));
	portletURL.setParameter(HomeReportDisplayTerms.LOAITHONGKE , loaiThongKe);
	portletURL.setParameter(HomeReportDisplayTerms.FROMDATE, fromDate);
	portletURL.setParameter(HomeReportDisplayTerms.TODATE, toDate);
	portletURL.setParameter("action", action);
	portletURL.setParameter("row", row);
	portletURL.setParameter("curVal", ParamUtil.getString(renderRequest, "curVal"));
	portletURL.setParameter("redirect", redirect);
%>

<script type="text/javascript">
	viewListDocumentReport('<%= portletURL.toString() %>');
</script >