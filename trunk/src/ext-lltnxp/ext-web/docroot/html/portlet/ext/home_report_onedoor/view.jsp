<%@ include file="/html/portlet/ext/home_report_onedoor/init.jsp" %>
<%@ include file="/html/portlet/ext/home_report_onedoor/js/homereportonedoorjs.jsp" %>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@page import="com.sgs.portlet.pmluser.model.PmlUser"%>
<%@page import="com.sgs.portlet.pmluser.service.PmlUserLocalServiceUtil"%>
<%@page import="com.sgs.portlet.onedoor.service.PmlOneDoorReceiveFileLocalServiceUtil"%>

<%
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action", "/sgs/home_report_onedoor/view");
	
	HomeReportOnedoorSearch homeReportOnedoorSearch = new HomeReportOnedoorSearch(renderRequest, portletURL);
	HomeReportOnedoorSearchTerms searchTerms = (HomeReportOnedoorSearchTerms) homeReportOnedoorSearch.getSearchTerms();
	
	portletURL.setParameter(HomeReportOnedoorDisplayTerms.FROMDATE, searchTerms.getFromDate());
	portletURL.setParameter(HomeReportOnedoorDisplayTerms.TODATE, searchTerms.getToDate());
	
	// convert date
	SimpleDateFormat sF1 = new SimpleDateFormat("dd/MM/yyyy");
	SimpleDateFormat sF2 = new SimpleDateFormat("yyyy-MM-dd");

	String fromDate = sF2.format(sF1.parse(searchTerms.getFromDate()));
	String toDate = sF2.format(sF1.parse(searchTerms.getToDate()));
	
%>

<form name="<portlet:namespace />fmReport" method="post">
<!-- <div class="title_allbos"><liferay-ui:message key="tong-hop-tinh-hinh-xu-ly-ho-so"/></div> -->
<div class="title_categ"><liferay-ui:message key="tong-hop-xu-ly-ho-so-theo-chuyen-vien" /></div>
<div class="boxcontent">
	<liferay-ui:search-form
		page="/html/portlet/ext/home_report_onedoor/home_report_onedoor_search.jsp"
		searchContainer="<%= homeReportOnedoorSearch %>" />
		
<%
	long userId = PortalUtil.getUserId(renderRequest);
	String departmentId = "";	
	try {
		departmentId = PmlUserLocalServiceUtil.getPmlUser(userId).getDepartmentsId(); 
	} catch (Exception e) { }
	
	List<PmlUser> results = PmlUserLocalServiceUtil.searchByDep(departmentId, homeReportOnedoorSearch.getStart(), 
													homeReportOnedoorSearch.getEnd(), homeReportOnedoorSearch.getOrderByComparator());
	int total = PmlUserLocalServiceUtil.searchCountByDep(departmentId);
	
	homeReportOnedoorSearch.setResults(results);
	homeReportOnedoorSearch.setTotal(total);
	portletURL.setParameter(homeReportOnedoorSearch.getCurParam(), String.valueOf(homeReportOnedoorSearch.getCurValue()));
	
	List resultRows = homeReportOnedoorSearch.getResultRows();
	ResultRow row = null;
	
	List<Long> userList = new ArrayList<Long>();
	
	for (int i = 0; i < results.size(); i ++) {
		long userid = results.get(i).getUserId();
		
		userList.add(userid);
		
		row = new ResultRow(results.get(i), userid, i);
		
		row.addText("center", "", (i+1) + ".");
		
		// ho va ten chuyen vien
		String userName = "";
		try {
			userName = PmlUserLocalServiceUtil.getFullName(userid);
		} catch (Exception e) { }
		row.addText("<b>" + userName + "</b>");
		
		int tonThangTruoc = PmlOneDoorReceiveFileLocalServiceUtil.countSoLuongHoSoTonTruoc(userList, fromDate, toDate);
		int nhanTrongThang = PmlOneDoorReceiveFileLocalServiceUtil.countSoLuongHoSoNhanTrongThang(userList, fromDate, toDate);
		int daXuLy = PmlOneDoorReceiveFileLocalServiceUtil.countSoLuongHoSoDaXuLy(userList, fromDate, toDate);
		int conTon = PmlOneDoorReceiveFileLocalServiceUtil.countSoLuongHoSoConTon(userList, fromDate, toDate);
		
		
		row.addText("left", "", tonThangTruoc+"");
		row.addText("left", "", nhanTrongThang+"");
		row.addText("left", "", daXuLy+"");
		row.addText("left", "", conTon+"");
		
		resultRows.add(row);
		
		userList = new ArrayList<Long>();
	}
%>

<liferay-ui:search-iterator searchContainer="<%= homeReportOnedoorSearch %>" />
</div>		
</form>