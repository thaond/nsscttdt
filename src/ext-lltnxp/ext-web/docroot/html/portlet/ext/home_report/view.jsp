<%@ include file="/html/portlet/ext/home_report/init.jsp" %>
<%@ include file="/html/portlet/ext/home_report/js/homereportjs.jsp" %>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@page import="com.sgs.portlet.pmluser.model.PmlUser"%>
<%@page import="com.sgs.portlet.pmluser.service.PmlUserLocalServiceUtil"%>
<%@page import="com.sgs.portlet.document.receipt.service.PmlEdmDocumentReceiptLocalServiceUtil"%>
<%@page import="com.sgs.portlet.document.send.service.PmlEdmDocumentSendLocalServiceUtil"%>

<%
	// user login
	long userId = (renderRequest.getAttribute("userId") == null) ? 0 : (Long) renderRequest.getAttribute("userId");
	String departmentId = (renderRequest.getAttribute("departmentId").equals("")) ? "chonphongban" : (String) renderRequest.getAttribute("departmentId");
	
	// user select
	long userIdChoice = (renderRequest.getAttribute("userIdChoice") == null) ? 0 : (Long) renderRequest.getAttribute("userIdChoice");
	String departmentIdChoice = (renderRequest.getAttribute("departmentIdChoice").equals("")) ? "chonphongban" : (String) renderRequest.getAttribute("departmentIdChoice");
	
	String loaiThongKe = (renderRequest.getAttribute("loaiThongKe").equals("")) ? "congvanden" : (String) renderRequest.getAttribute("loaiThongKe");
	
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	
	Calendar calendar = Calendar.getInstance();
	String fromDateTemp = "01" + "/" + (calendar.get(Calendar.MONTH)+1) + "/" + calendar.get(Calendar.YEAR);
	String fromDate = (renderRequest.getAttribute("fromDate").equals("")) ? fromDateTemp : (String) renderRequest.getAttribute("fromDate");
	String toDate = (renderRequest.getAttribute("toDate").equals("")) ? dateFormat.format(new Date()) : (String) renderRequest.getAttribute("toDate");
	
	long userTemp = 0;
	String departmentTemp ="";
	
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action", "/sgs/home_report/view");
	
	if (PortletPermissionUtil.contains(permissionChecker, plid, "SGS_HOME_REPORT", ActionKeysExt.CHUYENVIEN)		
		&& !(PortletPermissionUtil.contains(permissionChecker, plid, "SGS_HOME_REPORT", ActionKeysExt.GIAMDOC))
				&& !(PortletPermissionUtil.contains(permissionChecker, plid, "SGS_HOME_REPORT", ActionKeysExt.TRUONGPHONG))) {
			
			portletURL.setParameter(HomeReportDisplayTerms.USERID, String.valueOf(userId));	
			portletURL.setParameter(HomeReportDisplayTerms.DEPARTMENTID, departmentId);
			userTemp = userId;
			departmentTemp = departmentId;
		
	} else if (PortletPermissionUtil.contains(permissionChecker, plid, "SGS_HOME_REPORT", ActionKeysExt.TRUONGPHONG)
		&& !(PortletPermissionUtil.contains(permissionChecker, plid, "SGS_HOME_REPORT", ActionKeysExt.GIAMDOC))) {	
			portletURL.setParameter(HomeReportDisplayTerms.USERID, "0");	
			portletURL.setParameter(HomeReportDisplayTerms.DEPARTMENTID, departmentId);
			userTemp = userIdChoice;
			departmentTemp = departmentId;
		
	} else if (PortletPermissionUtil.contains(permissionChecker, plid, "SGS_HOME_REPORT", ActionKeysExt.GIAMDOC)) {
		portletURL.setParameter(HomeReportDisplayTerms.USERID, "0");
		portletURL.setParameter(HomeReportDisplayTerms.DEPARTMENTID, departmentIdChoice);
		userTemp = userIdChoice;
		departmentTemp = departmentIdChoice;
	}
	
	portletURL.setParameter(HomeReportDisplayTerms.LOAITHONGKE, loaiThongKe);
	portletURL.setParameter(HomeReportDisplayTerms.FROMDATE, fromDate);
	portletURL.setParameter(HomeReportDisplayTerms.TODATE, toDate);
%>

<form name="<portlet:namespace />fmReport" method="post">
<div class="title_categ"><liferay-ui:message key="tong-hop-tinh-hinh-xu-ly-van-ban"/></div>
<div class="boxcontent homereport">
<%
	HomeReportSearch homeReportSearch = new HomeReportSearch(renderRequest, portletURL);
	HomeReportSearchTerms searchTerms = (HomeReportSearchTerms) homeReportSearch.getSearchTerms();
%>
	
	<liferay-ui:search-form
		page="/html/portlet/ext/home_report/search.jsp"
		searchContainer="<%= homeReportSearch %>" />
		
<%
	List<PmlUser> results = new ArrayList<PmlUser>();
	int total = 0;
	
	if (userTemp != 0) {
		try {
			PmlUser userSelect = PmlUserLocalServiceUtil.getPmlUser(userTemp);
			results.add(userSelect);
			total = 1;
		} catch (Exception e) { }
	}
	else {
		results = PmlUserLocalServiceUtil.findUserListByDepartmentId(departmentTemp, 
											homeReportSearch.getStart(), homeReportSearch.getEnd(), homeReportSearch.getOrderByComparator());
		total = PmlUserLocalServiceUtil.countUserListByDepartmentId(departmentTemp);
	}
	
	homeReportSearch.setResults(results);
	homeReportSearch.setTotal(total);
	portletURL.setParameter(homeReportSearch.getCurParam(), String.valueOf(homeReportSearch.getCurValue()));
	
	List resultRows = homeReportSearch.getResultRows();
	ResultRow row = null;
	
	for (int i = 0; i < results.size(); i ++) {
		PmlUser pmlUser = results.get(i);
		long userid = pmlUser.getUserId();
		row = new ResultRow(pmlUser, userid, i);
		
		// ton thang truoc URL
		PortletURL tonThangTruocURL = renderResponse.createRenderURL();
		tonThangTruocURL.setParameter("struts_action", "/sgs/home_report/homereportviewlist");
		tonThangTruocURL.setParameter("action", "tonthangtruoc");
		tonThangTruocURL.setParameter("row", userid+"");
		tonThangTruocURL.setParameter("loaiThongKe", loaiThongKe);
		tonThangTruocURL.setParameter("departmentId", departmentTemp);
		tonThangTruocURL.setParameter("userId", userTemp+"");
		tonThangTruocURL.setParameter("fromDate", fromDate);
		tonThangTruocURL.setParameter("toDate", toDate);
		tonThangTruocURL.setParameter("curVal", String.valueOf(homeReportSearch.getCurValue()));
		tonThangTruocURL.setParameter("redirect", homeReportSearch.getIteratorURL().toString());
		
		// nhan thong thang URL
		PortletURL nhanTrongThangURL = renderResponse.createRenderURL();
		nhanTrongThangURL.setParameter("struts_action", "/sgs/home_report/homereportviewlist");
		nhanTrongThangURL.setParameter("action", "nhantrongthang");
		nhanTrongThangURL.setParameter("row", userid+"");
		nhanTrongThangURL.setParameter("loaiThongKe", loaiThongKe);
		nhanTrongThangURL.setParameter("departmentId", departmentTemp);
		nhanTrongThangURL.setParameter("userId", userTemp+"");
		nhanTrongThangURL.setParameter("fromDate", fromDate);
		nhanTrongThangURL.setParameter("toDate", toDate);
		nhanTrongThangURL.setParameter("curVal", String.valueOf(homeReportSearch.getCurValue()));
		nhanTrongThangURL.setParameter("redirect", homeReportSearch.getIteratorURL().toString());
		
		// da xu ly URL
		PortletURL daXuLyURL = renderResponse.createRenderURL();
		daXuLyURL.setParameter("struts_action", "/sgs/home_report/homereportviewlist");
		daXuLyURL.setParameter("action", "daxuly");
		daXuLyURL.setParameter("row", userid+"");
		daXuLyURL.setParameter("loaiThongKe", loaiThongKe);
		daXuLyURL.setParameter("departmentId", departmentTemp);
		daXuLyURL.setParameter("userId", userTemp+"");
		daXuLyURL.setParameter("fromDate", fromDate);
		daXuLyURL.setParameter("toDate", toDate);
		daXuLyURL.setParameter("curVal", String.valueOf(homeReportSearch.getCurValue()));
		daXuLyURL.setParameter("redirect", homeReportSearch.getIteratorURL().toString());
		
		// con ton URL
		PortletURL conTonURL = renderResponse.createRenderURL();
		conTonURL.setParameter("struts_action", "/sgs/home_report/homereportviewlist");
		conTonURL.setParameter("action", "conton");
		conTonURL.setParameter("row", userid+"");
		conTonURL.setParameter("loaiThongKe", loaiThongKe);
		conTonURL.setParameter("departmentId", departmentTemp);
		conTonURL.setParameter("userId", userTemp+"");
		conTonURL.setParameter("fromDate", fromDate);
		conTonURL.setParameter("toDate", toDate);
		conTonURL.setParameter("curVal", String.valueOf(homeReportSearch.getCurValue()));
		conTonURL.setParameter("redirect", homeReportSearch.getIteratorURL().toString());
		
		// ho va ten chuyen vien
		row.addText("center", "", (i+1) + ".");
		
		String userName = HomeReportDWRUtil.getFullName(userid);
		row.addText("<b>" + userName + "</b>");
		
		int tonThangTruoc = 0;
		int daNhan = 0;
		int chuaNhan = 0;
		int nhanTrongThang = 0;
		int daXuLy = 0;
		int conTon = 0;
		
		if (loaiThongKe.equals("congvanden")) {
			tonThangTruoc = PmlEdmDocumentReceiptLocalServiceUtil.countTonDauKyChuyenVien_CVDen(userid, 0, 0, 0, "",
									dateFormat.parse(fromDate), dateFormat.parse(toDate));
			
			daNhan = PmlEdmDocumentReceiptLocalServiceUtil.countNhanTrongKyChuyenVien_CVDen(userid, 0, 0, 0, "",
									dateFormat.parse(fromDate), dateFormat.parse(toDate));
			chuaNhan = PmlEdmDocumentReceiptLocalServiceUtil.countChuaNhanChuyenVien_CVDen(userid, 0, 0, 0, "",
									dateFormat.parse(fromDate), dateFormat.parse(toDate));
			nhanTrongThang = daNhan + chuaNhan;
			
			daXuLy = PmlEdmDocumentReceiptLocalServiceUtil.countTongDaXuLyChuyenVien_CVDen(userid, 0, 0, 0, "",
									dateFormat.parse(fromDate), dateFormat.parse(toDate));
			
			conTon = PmlEdmDocumentReceiptLocalServiceUtil.countTongDangXuLyChuyenVien_CVDen(userid, 0, 0, 0, "",
									dateFormat.parse(fromDate), dateFormat.parse(toDate));
		}
		else if (loaiThongKe.equals("congvandi")) {
			tonThangTruoc = PmlEdmDocumentSendLocalServiceUtil.countTonDauKyChuyenVien_CVDi(userid, 0, 0, "",
									dateFormat.parse(fromDate), dateFormat.parse(toDate));
			
			daNhan = PmlEdmDocumentSendLocalServiceUtil.countNhanTrongKyChuyenVien_CVDi(userid, 0, 0, "",
									dateFormat.parse(fromDate), dateFormat.parse(toDate));
			chuaNhan = PmlEdmDocumentSendLocalServiceUtil.countChuaNhanChuyenVien_CVDi(userid, 0, 0, "",
									dateFormat.parse(fromDate), dateFormat.parse(toDate));
			nhanTrongThang = daNhan + chuaNhan;
			
			daXuLy = PmlEdmDocumentSendLocalServiceUtil.countTongDaXuLyChuyenVien_CVDi(userid, 0, 0, "",
									dateFormat.parse(fromDate), dateFormat.parse(toDate));
			
			conTon = PmlEdmDocumentSendLocalServiceUtil.countTongDangXuLyChuyenVien_CVDi(userid, 0, 0, "",
									dateFormat.parse(fromDate), dateFormat.parse(toDate));
		}
		
		if (tonThangTruoc > 0) {
			row.addText("center", "", tonThangTruoc+"", tonThangTruocURL.toString());
		} else {
			row.addText("center", "", tonThangTruoc+"");
		}
		
		if (nhanTrongThang > 0) {
			row.addText("center", "", nhanTrongThang+"", nhanTrongThangURL.toString());
		} else {
			row.addText("center", "", nhanTrongThang+"");
		}
		
		if (daXuLy > 0) {
			row.addText("center", "", daXuLy+"", daXuLyURL.toString());
		} else {
			row.addText("center", "", daXuLy+"");
		}
		
		if (conTon > 0) {
			row.addText("center", "", conTon+"", conTonURL.toString());
		} else {
			row.addText("center", "", conTon+"");
		}
		
		resultRows.add(row);
	}
%>

<liferay-ui:search-iterator searchContainer="<%= homeReportSearch %>" />
</div>
</form>
