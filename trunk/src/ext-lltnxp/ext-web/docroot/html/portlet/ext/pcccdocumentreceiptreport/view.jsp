<%@ include file="/html/portlet/ext/pcccdocumentreceiptreport/init.jsp" %>
<%@ include file="/html/portlet/ext/pcccdocumentreceiptreport/js/pcccdocumentreceiptreport.jsp" %>
<%@ include file="/html/portlet/ext/pcccdocumentreceiptreport/page_iterator/init_search.jsp" %>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Date"%>
<%@page import="com.sgs.portlet.pcccdocumentreceiptreport.dto.TinhHinhThuLyCongVanDTO"%>
<%@page import="com.sgs.portlet.pcccdocumentreceiptreport.search.DocumentReportSearch"%>
<%@page import="com.sgs.portlet.pcccdocumentreceiptreport.search.DocumentReportSearchTerms"%>
<%@page import="com.sgs.portlet.department.service.DepartmentLocalServiceUtil"%>
<%@page import="com.sgs.portlet.pmluser.service.PmlUserLocalServiceUtil"%>
<%@page import="com.sgs.portlet.department.model.Department"%>
<%@page import="com.sgs.portlet.pmluser.model.PmlUser"%>
<%@page import="com.sgs.portlet.department.service.persistence.DepartmentUtil"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.liferay.portal.service.UserLocalServiceUtil"%>
<script type='text/javascript' src='/html/js/liferay/tr.js'></script>
<portlet:actionURL var="xemBaoCao">
	<portlet:param name="struts_action" value="/sgs/pcccdocumentreceiptreport/view" />
	<portlet:param name="view" value="yes" />
</portlet:actionURL>

<portlet:actionURL var="inBaoCaoXuatExcel">
	<portlet:param name="struts_action" value="/sgs/pcccdocumentreceiptreport/view" />
</portlet:actionURL>

<script type="text/javascript">
function <portlet:namespace />addActionFrom(reportType) {
	var action = "<%= inBaoCaoXuatExcel %>&<portlet:namespace />reportType=" + reportType;
	document.getElementsByName("<portlet:namespace />frmReport")[0].setAttribute("action", action);
}
function <portlet:namespace />setActionFrom() {
	document.getElementsByName("<portlet:namespace />frmReport")[0].setAttribute("action", "");
}
</script>

<%
	String departmentId = (renderRequest.getAttribute("departmentId") == null) ? "toancoquan" : (String) renderRequest.getAttribute("departmentId");
	String tenPhongBan = (renderRequest.getAttribute("attTenCoQuanPhongBanChuyenVien") == null) ? "" : (String) renderRequest.getAttribute("attTenCoQuanPhongBanChuyenVien");
	//String tenPhongBan = (renderRequest.getAttribute("tenPhongBan") == null) ? "" : (String) renderRequest.getAttribute("tenPhongBan");
	tenPhongBan = tenPhongBan.replaceAll("CV:", "Ng\u01B0\u1EDDi x\u1EED l\u00FD:");

//minh update 20100517
	String departmentIdParam = ParamUtil.getString(renderRequest, "departmentId");
	if (!"".equals(departmentIdParam)) {
		departmentId = departmentIdParam;
	}
	long userId = (renderRequest.getAttribute("userId") == null) ? 0 : (Long) renderRequest.getAttribute("userId");
	long userIdParam = ParamUtil.getLong(renderRequest, "userId");
	if (0 != userIdParam) {
		userId = userIdParam;
	}
	String fromDate = renderRequest.getAttribute("fromDate").toString();
	String from_DateParam = ParamUtil.getString(renderRequest, "fromDate");
	if (!"".equals(from_DateParam)) {
		fromDate = from_DateParam;
	}
	String toDate = renderRequest.getAttribute("toDate").toString();
	String to_DatePram = ParamUtil.getString(renderRequest,"toDate");
	if (!"".equals(to_DatePram)) {
		toDate = to_DatePram;
	}
//end minh update 20100517	

	// phmphuc update 22/09/2010
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action","/sgs/pcccdocumentreceiptreport/view");
	portletURL.setParameter("view","yes");
	// end phmphuc update
%>

<form name="<portlet:namespace />frmReport" action="<%= xemBaoCao %>" method="post" onsubmit="return <portlet:namespace/>checkForm(this);">
<div class="title_categ"><liferay-ui:message key="tieu-thuc-lap-bao-cao"/></div>
<div class="boxcontent">
<%
	DocumentReportSearch documentReportSearch = new DocumentReportSearch(renderRequest, portletURL);
	DocumentReportSearchTerms searchTerms = (DocumentReportSearchTerms)documentReportSearch.getSearchTerms();
%>
<liferay-ui:search-form
	page="/html/portlet/ext/pcccdocumentreceiptreport/search.jsp"
	searchContainer="<%= documentReportSearch %>" />

<%
	String attView = request.getAttribute("attView")!= null ? request.getAttribute("attView").toString() : "no";
	if(attView.equals("yes") || "yes".equals(ParamUtil.getString(renderRequest,"attView"))) {
%>

<div class="contain-title-report">
	<h2 class="report-title-HS"><liferay-ui:message key="tinhhinhthulycongvan.title" /></h2>
	<h4>(<%= tenPhongBan %>)</h4>
	<h5 class="description-report-title">
	(<liferay-ui:message key="tinhhinhthulycongvan.tungay" /> <%= fromDate %> <liferay-ui:message key="tinhhinhthulycongvan.denngay" /> <%= toDate %>)
	</h5>
</div>

<%
	// khoi tao cac bien trong csdl va dto
	List listResults = null;
	int total1 = 0;
	
	TinhHinhThuLyCongVanDTO dto = new TinhHinhThuLyCongVanDTO();
	
	// Dem so luong dong trong recordset hien thi va lay thong tin doi tuong theo tung loai thong ke
	if(departmentId.equals("tatcaphongban")) { // Toan co quan
		listResults = new ArrayList<Department>();
		listResults.addAll(DepartmentLocalServiceUtil.findDepartmentsByDepartmentParentId(
					documentReportSearch.getStart(), documentReportSearch.getEnd()));
		total1 = DepartmentLocalServiceUtil.countTinhHinhThuLyCongVanPhongBan();
	} 
	else if(userId == 1) { // Tat ca chuyen vien
		listResults = new ArrayList<PmlUser>();
		listResults.addAll(PmlUserLocalServiceUtil.findUserListByDepartmentId(departmentId, 
					documentReportSearch.getStart(), documentReportSearch.getEnd(), null));
		total1 = PmlUserLocalServiceUtil.countTinhHinhThuLyCongVanChuyenVien(departmentId);
	} 
	else { // Tung phong ban
		listResults = new ArrayList<TinhHinhThuLyCongVanDTO>();
		listResults.add(dto);
		total1 = 1;
	}
	
	documentReportSearch.setTotal(total1);
	portletURL.setParameter(documentReportSearch.getCurParam(), String.valueOf(documentReportSearch.getCurValue()));
	
	List resultRows1 = documentReportSearch.getResultRows();
	ResultRow row1 = null;
	
	List<TinhHinhThuLyCongVanDTO> dtoDets = null;
	List<TinhHinhThuLyCongVanDTO> dtoForTCs = null;
		if(departmentId.equals("toancoquan")) { // Toan co quan
		dtoDets = com.sgs.portlet.pcccdocumentreceiptreport.action.ViewAction.getTinhHinhThuLyCongVanToanCoQuan(
				searchTerms.getLoaiCongVan(), searchTerms.getNhomCongVan(), searchTerms.getDoMat(), new SimpleDateFormat("dd/MM/yyyy").parse(searchTerms.getFromDate()), 
				new SimpleDateFormat("dd/MM/yyyy").parse(searchTerms.getToDate()));
	} 
	else if(departmentId.equals("tatcaphongban")) { // Tat ca phong ban
		dtoDets = com.sgs.portlet.pcccdocumentreceiptreport.action.ViewAction.getTinhHinhThuLyCongVanTatCaPhongBan("",
				searchTerms.getLoaiCongVan(), searchTerms.getNhomCongVan(), searchTerms.getDoMat(), new SimpleDateFormat("dd/MM/yyyy").parse(searchTerms.getFromDate()), 
				new SimpleDateFormat("dd/MM/yyyy").parse(searchTerms.getToDate()), documentReportSearch.getStart(), documentReportSearch.getEnd());
		dtoForTCs = dtoDets;
	} 
	else { // Tung phong ban
			if (userId == 0) { // Chon chuyen vien
			dtoDets = com.sgs.portlet.pcccdocumentreceiptreport.action.ViewAction.
						getTinhHinhThuLyCongVanTatCaChuyenVienPhongBan(searchTerms.getLoaiCongVan(), searchTerms.getDepartmentId(), searchTerms.getNhomCongVan(),  searchTerms.getDoMat(), 
					new SimpleDateFormat("dd/MM/yyyy").parse(searchTerms.getFromDate()), new SimpleDateFormat("dd/MM/yyyy").parse(searchTerms.getToDate()));
		} 
		else if (userId == 1) { // Tat ca chuyen vien
			dtoDets = com.sgs.portlet.pcccdocumentreceiptreport.action.ViewAction.
						getTinhHinhThuLyCongVanChuyenVienPhongBan("", searchTerms.getLoaiCongVan(), searchTerms.getDepartmentId(), searchTerms.getNhomCongVan(),  searchTerms.getDoMat(), 
						new SimpleDateFormat("dd/MM/yyyy").parse(searchTerms.getFromDate()), new SimpleDateFormat("dd/MM/yyyy").parse(searchTerms.getToDate()),
						documentReportSearch.getStart(), documentReportSearch.getEnd());
			dtoForTCs = dtoDets;
		} 
		else { // Chuyen vien
			dtoDets = com.sgs.portlet.pcccdocumentreceiptreport.action.ViewAction.
						getTinhHinhThuLyCongVanChuyenVien(searchTerms.getLoaiCongVan(), searchTerms.getDepartmentId(), searchTerms.getUserId(), searchTerms.getNhomCongVan(),  searchTerms.getDoMat(), 
					new SimpleDateFormat("dd/MM/yyyy").parse(searchTerms.getFromDate()), new SimpleDateFormat("dd/MM/yyyy").parse(searchTerms.getToDate()));
			}
		}
	for (int i = 0; i < listResults.size(); i ++) {
		dto = dtoDets.get(i);
		
		// phmphuc update 22/09/2010
		if(departmentId.equals("tatcaphongban")) { // Toan co quan
			row1 = new ResultRow((Department)listResults.get(i), ((Department)listResults.get(i)).getDepartmentsId(), i);
		} 
		else if(userId == 1) { // Tat ca chuyen vien
			row1 = new ResultRow((PmlUser)listResults.get(i), ((PmlUser)listResults.get(i)).getUserId(), i);
		} 
		else { // Tung phong ban
			row1 = new ResultRow(dto, i, i);
		}
		// end phmphuc update
		
		// ton dau ky URL
		PortletURL tonDauKyURL = renderResponse.createRenderURL();
		tonDauKyURL.setParameter("struts_action", "/sgs/pcccdocumentreceiptreport/pcccdocumentreceiptviewlist");
		tonDauKyURL.setParameter("action", "tondauky");
		
		if (departmentId.equals("tatcaphongban")) {
			tonDauKyURL.setParameter("row", ((Department)(listResults.get(i))).getDepartmentsId());
			tonDauKyURL.setParameter("userIdRow", "");
		} else if(userId == 1) {
			tonDauKyURL.setParameter("row", "");
			tonDauKyURL.setParameter("userIdRow", String.valueOf(((PmlUser)(listResults.get(i))).getUserId()));
		}
		
		tonDauKyURL.setParameter("loaiCongVan", searchTerms.getLoaiCongVan());
		tonDauKyURL.setParameter("departmentId", searchTerms.getDepartmentId());
		tonDauKyURL.setParameter("userId", String.valueOf(searchTerms.getUserId()));
		tonDauKyURL.setParameter("nhomCongVan", String.valueOf(searchTerms.getNhomCongVan()));
		tonDauKyURL.setParameter("doMat", searchTerms.getDoMat());
		tonDauKyURL.setParameter("fromDate", searchTerms.getFromDate());
		tonDauKyURL.setParameter("toDate", searchTerms.getToDate());
		tonDauKyURL.setParameter("radioTenPhongBan", String.valueOf(searchTerms.isRadioTenPhongBan())); //yenlt update 28062010
		tonDauKyURL.setParameter("radioTenChuyenVien", String.valueOf(searchTerms.isRadioTenChuyenVien())); //yenlt update 28062010
		tonDauKyURL.setParameter("curVal", String.valueOf(documentReportSearch.getCurValue()));
		tonDauKyURL.setParameter("redirect", documentReportSearch.getIteratorURL().toString() + "&attView=yes" );
		
		// nhan trong ky URL
		PortletURL nhanTrongKyURL = renderResponse.createRenderURL();
		nhanTrongKyURL.setParameter("struts_action", "/sgs/pcccdocumentreceiptreport/pcccdocumentreceiptviewlist");
		nhanTrongKyURL.setParameter("action", "nhantrongky");
		
		if (departmentId.equals("tatcaphongban")) {
			nhanTrongKyURL.setParameter("row", ((Department)(listResults.get(i))).getDepartmentsId());
			nhanTrongKyURL.setParameter("userIdRow", "");
		} else if(userId == 1) {
			nhanTrongKyURL.setParameter("row", "");
			nhanTrongKyURL.setParameter("userIdRow", String.valueOf(((PmlUser)(listResults.get(i))).getUserId()));
		}
		
		nhanTrongKyURL.setParameter("loaiCongVan", searchTerms.getLoaiCongVan());
		nhanTrongKyURL.setParameter("departmentId", searchTerms.getDepartmentId());
		nhanTrongKyURL.setParameter("userId", String.valueOf(searchTerms.getUserId()));
		nhanTrongKyURL.setParameter("nhomCongVan", String.valueOf(searchTerms.getNhomCongVan()));
		nhanTrongKyURL.setParameter("doMat", searchTerms.getDoMat());
		nhanTrongKyURL.setParameter("fromDate", searchTerms.getFromDate());
		nhanTrongKyURL.setParameter("toDate", searchTerms.getToDate());
		nhanTrongKyURL.setParameter("curVal", String.valueOf(documentReportSearch.getCurValue()));
		nhanTrongKyURL.setParameter("radioTenPhongBan", String.valueOf(searchTerms.isRadioTenPhongBan())); //yenlt update 28062010
		nhanTrongKyURL.setParameter("radioTenChuyenVien", String.valueOf(searchTerms.isRadioTenChuyenVien())); //yenlt update 28062010

		
		// chua nhan URL
		PortletURL chuaNhanURL = renderResponse.createRenderURL();
		chuaNhanURL.setParameter("struts_action", "/sgs/pcccdocumentreceiptreport/pcccdocumentreceiptviewlist");
		chuaNhanURL.setParameter("action", "chuanhan");
		
		if (departmentId.equals("tatcaphongban")) {
			chuaNhanURL.setParameter("row", ((Department)(listResults.get(i))).getDepartmentsId());
			chuaNhanURL.setParameter("userIdRow", "");
		} else if(userId == 1) {
			chuaNhanURL.setParameter("row", "");
			chuaNhanURL.setParameter("userIdRow", String.valueOf(((PmlUser)(listResults.get(i))).getUserId()));
		}
		
		chuaNhanURL.setParameter("loaiCongVan", searchTerms.getLoaiCongVan());
		chuaNhanURL.setParameter("departmentId", searchTerms.getDepartmentId());
		chuaNhanURL.setParameter("userId", String.valueOf(searchTerms.getUserId()));
		chuaNhanURL.setParameter("nhomCongVan", String.valueOf(searchTerms.getNhomCongVan()));
		chuaNhanURL.setParameter("doMat", searchTerms.getDoMat());
		chuaNhanURL.setParameter("fromDate", searchTerms.getFromDate());
		chuaNhanURL.setParameter("toDate", searchTerms.getToDate());
		chuaNhanURL.setParameter("radioTenPhongBan", String.valueOf(searchTerms.isRadioTenPhongBan())); //yenlt update 28062010
		chuaNhanURL.setParameter("radioTenChuyenVien", String.valueOf(searchTerms.isRadioTenChuyenVien())); //yenlt update 28062010
		chuaNhanURL.setParameter("curVal", String.valueOf(documentReportSearch.getCurValue()));
		chuaNhanURL.setParameter("redirect", documentReportSearch.getIteratorURL().toString()+ "&attView=yes" );
		
		// da giai quyet dung han URL
		PortletURL dungHanURL = renderResponse.createRenderURL();
		dungHanURL.setParameter("struts_action", "/sgs/pcccdocumentreceiptreport/pcccdocumentreceiptviewlist");
		dungHanURL.setParameter("action", "dunghan");

		if (departmentId.equals("tatcaphongban")) {
			dungHanURL.setParameter("row", ((Department)(listResults.get(i))).getDepartmentsId());
			dungHanURL.setParameter("userIdRow", "");
		} else if(userId == 1) {
			dungHanURL.setParameter("row", "");
			dungHanURL.setParameter("userIdRow", String.valueOf(((PmlUser)(listResults.get(i))).getUserId()));
		}
		
		dungHanURL.setParameter("loaiCongVan", searchTerms.getLoaiCongVan());
		dungHanURL.setParameter("departmentId", searchTerms.getDepartmentId());
		dungHanURL.setParameter("userId", String.valueOf(searchTerms.getUserId()));
		dungHanURL.setParameter("nhomCongVan", String.valueOf(searchTerms.getNhomCongVan()));
		dungHanURL.setParameter("doMat", searchTerms.getDoMat());
		dungHanURL.setParameter("fromDate", searchTerms.getFromDate());
		dungHanURL.setParameter("toDate", searchTerms.getToDate());
		dungHanURL.setParameter("radioTenPhongBan", String.valueOf(searchTerms.isRadioTenPhongBan())); //yenlt update 28062010
		dungHanURL.setParameter("radioTenChuyenVien", String.valueOf(searchTerms.isRadioTenChuyenVien())); //yenlt update 28062010
		dungHanURL.setParameter("curVal", String.valueOf(documentReportSearch.getCurValue()));
		dungHanURL.setParameter("redirect", documentReportSearch.getIteratorURL().toString()+ "&attView=yes" );
		
		// da giai quyet tre han URL
		PortletURL treHanURL = renderResponse.createRenderURL();
		treHanURL.setParameter("struts_action", "/sgs/pcccdocumentreceiptreport/pcccdocumentreceiptviewlist");
		treHanURL.setParameter("action", "trehan");

		if (departmentId.equals("tatcaphongban")) {
			treHanURL.setParameter("row", ((Department)(listResults.get(i))).getDepartmentsId());
			treHanURL.setParameter("userIdRow", "");
		} else if(userId == 1) {
			treHanURL.setParameter("row", "");
			treHanURL.setParameter("userIdRow", String.valueOf(((PmlUser)(listResults.get(i))).getUserId()));
		}
		
		treHanURL.setParameter("loaiCongVan", searchTerms.getLoaiCongVan());
		treHanURL.setParameter("departmentId", searchTerms.getDepartmentId());
		treHanURL.setParameter("userId", String.valueOf(searchTerms.getUserId()));
		treHanURL.setParameter("nhomCongVan", String.valueOf(searchTerms.getNhomCongVan()));
		treHanURL.setParameter("doMat", searchTerms.getDoMat());
		treHanURL.setParameter("fromDate", searchTerms.getFromDate());
		treHanURL.setParameter("toDate", searchTerms.getToDate());
		treHanURL.setParameter("radioTenPhongBan", String.valueOf(searchTerms.isRadioTenPhongBan())); //yenlt update 28062010
		treHanURL.setParameter("radioTenChuyenVien", String.valueOf(searchTerms.isRadioTenChuyenVien())); //yenlt update 28062010
		treHanURL.setParameter("curVal", String.valueOf(documentReportSearch.getCurValue()));
		treHanURL.setParameter("redirect", documentReportSearch.getIteratorURL().toString()+ "&attView=yes" );
		
		// tong da giai quyet URL
		PortletURL tongDaGiaiQuyetURL = renderResponse.createRenderURL();
		tongDaGiaiQuyetURL.setParameter("struts_action", "/sgs/pcccdocumentreceiptreport/pcccdocumentreceiptviewlist");
		tongDaGiaiQuyetURL.setParameter("action", "tongdagiaiquyet");

		if (departmentId.equals("tatcaphongban")) {
			tongDaGiaiQuyetURL.setParameter("row", ((Department)(listResults.get(i))).getDepartmentsId());
			tongDaGiaiQuyetURL.setParameter("userIdRow", "");
		} else if(userId == 1) {
			tongDaGiaiQuyetURL.setParameter("row", "");
			tongDaGiaiQuyetURL.setParameter("userIdRow", String.valueOf(((PmlUser)(listResults.get(i))).getUserId()));
		}
		
		tongDaGiaiQuyetURL.setParameter("loaiCongVan", searchTerms.getLoaiCongVan());
		tongDaGiaiQuyetURL.setParameter("departmentId", searchTerms.getDepartmentId());
		tongDaGiaiQuyetURL.setParameter("userId", String.valueOf(searchTerms.getUserId()));
		tongDaGiaiQuyetURL.setParameter("nhomCongVan", String.valueOf(searchTerms.getNhomCongVan()));
		tongDaGiaiQuyetURL.setParameter("doMat", searchTerms.getDoMat());
		tongDaGiaiQuyetURL.setParameter("fromDate", searchTerms.getFromDate());
		tongDaGiaiQuyetURL.setParameter("toDate", searchTerms.getToDate());
		tongDaGiaiQuyetURL.setParameter("radioTenPhongBan", String.valueOf(searchTerms.isRadioTenPhongBan())); //yenlt update 28062010
		tongDaGiaiQuyetURL.setParameter("radioTenChuyenVien", String.valueOf(searchTerms.isRadioTenChuyenVien())); //yenlt update 28062010
		tongDaGiaiQuyetURL.setParameter("curVal", String.valueOf(documentReportSearch.getCurValue()));
		tongDaGiaiQuyetURL.setParameter("redirect", documentReportSearch.getIteratorURL().toString()+ "&attView=yes" );
		
		// dang giai quyet trong quy dinh URL
		PortletURL trongQuyDinhURL = renderResponse.createRenderURL();
		trongQuyDinhURL.setParameter("struts_action", "/sgs/pcccdocumentreceiptreport/pcccdocumentreceiptviewlist");
		trongQuyDinhURL.setParameter("action", "trongquidinh");

		if (departmentId.equals("tatcaphongban")) {
			trongQuyDinhURL.setParameter("row", ((Department)(listResults.get(i))).getDepartmentsId());
			trongQuyDinhURL.setParameter("userIdRow", "");
		} else if(userId == 1) {
			trongQuyDinhURL.setParameter("row", "");
			trongQuyDinhURL.setParameter("userIdRow", String.valueOf(((PmlUser)(listResults.get(i))).getUserId()));
		}
		
		trongQuyDinhURL.setParameter("loaiCongVan", searchTerms.getLoaiCongVan());
		trongQuyDinhURL.setParameter("departmentId", searchTerms.getDepartmentId());
		trongQuyDinhURL.setParameter("userId", String.valueOf(searchTerms.getUserId()));
		trongQuyDinhURL.setParameter("nhomCongVan", String.valueOf(searchTerms.getNhomCongVan()));
		trongQuyDinhURL.setParameter("doMat", searchTerms.getDoMat());
		trongQuyDinhURL.setParameter("fromDate", searchTerms.getFromDate());
		trongQuyDinhURL.setParameter("toDate", searchTerms.getToDate());
		trongQuyDinhURL.setParameter("radioTenPhongBan", String.valueOf(searchTerms.isRadioTenPhongBan())); //yenlt update 28062010
		trongQuyDinhURL.setParameter("radioTenChuyenVien", String.valueOf(searchTerms.isRadioTenChuyenVien())); //yenlt update 28062010
		trongQuyDinhURL.setParameter("curVal", String.valueOf(documentReportSearch.getCurValue()));
		trongQuyDinhURL.setParameter("redirect", documentReportSearch.getIteratorURL().toString()+ "&attView=yes" );
		
		// dang giai quyet qua quy dinh URL
		PortletURL quaQuyDinhURL = renderResponse.createRenderURL();
		quaQuyDinhURL.setParameter("struts_action", "/sgs/pcccdocumentreceiptreport/pcccdocumentreceiptviewlist");
		quaQuyDinhURL.setParameter("action", "quaquydinh");

		if (departmentId.equals("tatcaphongban")) {
			quaQuyDinhURL.setParameter("row", ((Department)(listResults.get(i))).getDepartmentsId());
			quaQuyDinhURL.setParameter("userIdRow", "");
		} else if(userId == 1) {
			quaQuyDinhURL.setParameter("row", "");
			quaQuyDinhURL.setParameter("userIdRow", String.valueOf(((PmlUser)(listResults.get(i))).getUserId()));
		}
		
		quaQuyDinhURL.setParameter("loaiCongVan", searchTerms.getLoaiCongVan());
		quaQuyDinhURL.setParameter("departmentId", searchTerms.getDepartmentId());
		quaQuyDinhURL.setParameter("userId", String.valueOf(searchTerms.getUserId()));
		quaQuyDinhURL.setParameter("nhomCongVan", String.valueOf(searchTerms.getNhomCongVan()));
		quaQuyDinhURL.setParameter("doMat", searchTerms.getDoMat());
		quaQuyDinhURL.setParameter("fromDate", searchTerms.getFromDate());
		quaQuyDinhURL.setParameter("toDate", searchTerms.getToDate());
		quaQuyDinhURL.setParameter("radioTenPhongBan", String.valueOf(searchTerms.isRadioTenPhongBan())); //yenlt update 28062010
		quaQuyDinhURL.setParameter("radioTenChuyenVien", String.valueOf(searchTerms.isRadioTenChuyenVien())); //yenlt update 28062010
		quaQuyDinhURL.setParameter("curVal", String.valueOf(documentReportSearch.getCurValue()));
		quaQuyDinhURL.setParameter("redirect", documentReportSearch.getIteratorURL().toString()+ "&attView=yes" );
		
		// tong dang giai quyet URL
		PortletURL tongDangGiaiQuyetURL = renderResponse.createRenderURL();
		tongDangGiaiQuyetURL.setParameter("struts_action", "/sgs/pcccdocumentreceiptreport/pcccdocumentreceiptviewlist");
		tongDangGiaiQuyetURL.setParameter("action", "tongdanggiaiquyet");

		if (departmentId.equals("tatcaphongban")) {
			tongDangGiaiQuyetURL.setParameter("row", ((Department)(listResults.get(i))).getDepartmentsId());
			tongDangGiaiQuyetURL.setParameter("userIdRow", "");
		} else if(userId == 1) {
			tongDangGiaiQuyetURL.setParameter("row", "");
			tongDangGiaiQuyetURL.setParameter("userIdRow", String.valueOf(((PmlUser)(listResults.get(i))).getUserId()));
		}
		
		tongDangGiaiQuyetURL.setParameter("loaiCongVan", searchTerms.getLoaiCongVan());
		tongDangGiaiQuyetURL.setParameter("departmentId", searchTerms.getDepartmentId());
		tongDangGiaiQuyetURL.setParameter("userId", String.valueOf(searchTerms.getUserId()));
		tongDangGiaiQuyetURL.setParameter("nhomCongVan", String.valueOf(searchTerms.getNhomCongVan()));
		tongDangGiaiQuyetURL.setParameter("doMat", searchTerms.getDoMat());
		tongDangGiaiQuyetURL.setParameter("fromDate", searchTerms.getFromDate());
		tongDangGiaiQuyetURL.setParameter("toDate", searchTerms.getToDate());
		tongDangGiaiQuyetURL.setParameter("radioTenPhongBan", String.valueOf(searchTerms.isRadioTenPhongBan())); //yenlt update 28062010
		tongDangGiaiQuyetURL.setParameter("radioTenChuyenVien", String.valueOf(searchTerms.isRadioTenChuyenVien())); //yenlt update 28062010
		tongDangGiaiQuyetURL.setParameter("curVal", String.valueOf(documentReportSearch.getCurValue()));
		tongDangGiaiQuyetURL.setParameter("redirect", documentReportSearch.getIteratorURL().toString()+ "&attView=yes" );
		
		// set param
		// STT
		row1.addText(dto.getStt());
		// phong ban
		row1.addText(dto.getTen());
		// ton dau ky
		if (dto.getTonDauKy() > 0) {
			row1.addText(String.valueOf(dto.getTonDauKy()), tonDauKyURL.toString());
		} else {
			row1.addText(String.valueOf(dto.getTonDauKy()));
		}
		// nhan dau ky
		if (dto.getNhanTrongKy() > 0) {
			row1.addText(String.valueOf(dto.getNhanTrongKy()), nhanTrongKyURL.toString());
		} else {
			row1.addText(String.valueOf(dto.getNhanTrongKy()));
		}
		// chua nhan
		if (dto.getChuaNhan() > 0) {
			row1.addText(String.valueOf(dto.getChuaNhan()), chuaNhanURL.toString());
		} else {
			row1.addText(String.valueOf(dto.getChuaNhan()));
		}
		// da giai quyet dung han
		if (dto.getDungHan() > 0) {
			row1.addText(String.valueOf(dto.getDungHan()), dungHanURL.toString());
		} else {
			row1.addText(String.valueOf(dto.getDungHan()));
		}
		// da giai quyet tre han
		if (dto.getTreHan() > 0) {
			row1.addText(String.valueOf(dto.getTreHan()), treHanURL.toString());
		} else {
			row1.addText(String.valueOf(dto.getTreHan()));
		}
		// tong da giai quyet
		if (dto.getTongDaGiaiQuyet() > 0) {
			row1.addText(String.valueOf(dto.getTongDaGiaiQuyet()), tongDaGiaiQuyetURL.toString());
		} else {
			row1.addText(String.valueOf(dto.getTongDaGiaiQuyet()));
		}
		// dang giai quyet trong quy dinh
		if (dto.getTrongQuiDinh() > 0) {
			row1.addText(String.valueOf(dto.getTrongQuiDinh()), trongQuyDinhURL.toString());
		} else {
			row1.addText(String.valueOf(dto.getTrongQuiDinh()));
		}
		// dang giai quyet qua quy dinh
		if (dto.getQuaQuiDinh() > 0) {
			row1.addText(String.valueOf(dto.getQuaQuiDinh()), quaQuyDinhURL.toString());
		} else {
			row1.addText(String.valueOf(dto.getQuaQuiDinh()));
		}
		// tong dang giai quyet
		if (dto.getTongDangGiaiQuyet() > 0) {
			row1.addText(String.valueOf(dto.getTongDangGiaiQuyet()), tongDangGiaiQuyetURL.toString());
		} else {
			row1.addText(String.valueOf(dto.getTongDangGiaiQuyet()));
		}
		// ty le giai quyet dung han
		row1.addText(dto.getTyLeGiaiQuyetDungHan());
		
		resultRows1.add(row1);
	}
	
	// danh cho bien tong cong
	List<TinhHinhThuLyCongVanDTO> dtoList = new ArrayList<TinhHinhThuLyCongVanDTO>();
	TinhHinhThuLyCongVanDTO tongCong = new TinhHinhThuLyCongVanDTO();
		
	if (departmentId.equals("tatcaphongban") || userId == 1) {
		if (documentReportSearch.getResultEnd() == total1) {
		
			Date fromDateView = new SimpleDateFormat("dd/MM/yyyy").parse(fromDate);
			Date toDateView = new SimpleDateFormat("dd/MM/yyyy").parse(toDate);
			
			dtoList = dtoForTCs;
			
			tongCong = dtoList.get(dtoList.size() - 1);
			
			row1 = new ResultRow(tongCong, 0, 0);
			
			// ton dau ky URL
			PortletURL tongCong_tonDauKyURL = renderResponse.createRenderURL();
			tongCong_tonDauKyURL.setParameter("struts_action", "/sgs/pcccdocumentreceiptreport/pcccdocumentreceiptviewlist");
			tongCong_tonDauKyURL.setParameter("action", "tondauky");
			
			if (departmentId.equals("tatcaphongban")) {
				tongCong_tonDauKyURL.setParameter("row", "tatcaphongban");
				tongCong_tonDauKyURL.setParameter("userIdRow", "");
			} else if(userId == 1) {
				tongCong_tonDauKyURL.setParameter("row", "");
				tongCong_tonDauKyURL.setParameter("userIdRow", "tatcachuyenvien");
			}
			
			tongCong_tonDauKyURL.setParameter("loaiCongVan", searchTerms.getLoaiCongVan());
			tongCong_tonDauKyURL.setParameter("departmentId", searchTerms.getDepartmentId());
			tongCong_tonDauKyURL.setParameter("userId", String.valueOf(searchTerms.getUserId()));
			tongCong_tonDauKyURL.setParameter("nhomCongVan", String.valueOf(searchTerms.getNhomCongVan()));
			tongCong_tonDauKyURL.setParameter("fromDate", searchTerms.getFromDate());
			tongCong_tonDauKyURL.setParameter("toDate", searchTerms.getToDate());
			tongCong_tonDauKyURL.setParameter("radioTenPhongBan", String.valueOf(searchTerms.isRadioTenPhongBan())); //yenlt update 28062010
			tongCong_tonDauKyURL.setParameter("radioTenChuyenVien", String.valueOf(searchTerms.isRadioTenChuyenVien())); //yenlt update 28062010
			tongCong_tonDauKyURL.setParameter("curVal", String.valueOf(documentReportSearch.getCurValue()));
			tongCong_tonDauKyURL.setParameter("redirect", documentReportSearch.getIteratorURL().toString() + "&attView=yes" );
			
			// nhan trong ky URL
			PortletURL tongCong_nhanTrongKyURL = renderResponse.createRenderURL();
			tongCong_nhanTrongKyURL.setParameter("struts_action", "/sgs/pcccdocumentreceiptreport/pcccdocumentreceiptviewlist");
			tongCong_nhanTrongKyURL.setParameter("action", "nhantrongky");
			
			if (departmentId.equals("tatcaphongban")) {
				tongCong_nhanTrongKyURL.setParameter("row", "tatcaphongban");
				tongCong_nhanTrongKyURL.setParameter("userIdRow", "");
			} else if(userId == 1) {
				tongCong_nhanTrongKyURL.setParameter("row", "");
				tongCong_nhanTrongKyURL.setParameter("userIdRow", "tatcachuyenvien");
			}
			
			tongCong_nhanTrongKyURL.setParameter("loaiCongVan", searchTerms.getLoaiCongVan());
			tongCong_nhanTrongKyURL.setParameter("departmentId", searchTerms.getDepartmentId());
			tongCong_nhanTrongKyURL.setParameter("userId", String.valueOf(searchTerms.getUserId()));
			tongCong_nhanTrongKyURL.setParameter("nhomCongVan", String.valueOf(searchTerms.getNhomCongVan()));
			tongCong_nhanTrongKyURL.setParameter("fromDate", searchTerms.getFromDate());
			tongCong_nhanTrongKyURL.setParameter("toDate", searchTerms.getToDate());
			tongCong_nhanTrongKyURL.setParameter("radioTenPhongBan", String.valueOf(searchTerms.isRadioTenPhongBan())); //yenlt update 28062010
			tongCong_nhanTrongKyURL.setParameter("radioTenChuyenVien", String.valueOf(searchTerms.isRadioTenChuyenVien())); //yenlt update 28062010
			tongCong_nhanTrongKyURL.setParameter("curVal", String.valueOf(documentReportSearch.getCurValue()));
			tongCong_nhanTrongKyURL.setParameter("redirect", documentReportSearch.getIteratorURL().toString()+ "&attView=yes" );
			
			// chua nhan URL
			PortletURL tongCong_chuaNhanURL = renderResponse.createRenderURL();
			tongCong_chuaNhanURL.setParameter("struts_action", "/sgs/pcccdocumentreceiptreport/pcccdocumentreceiptviewlist");
			tongCong_chuaNhanURL.setParameter("action", "chuanhan");
			
			if (departmentId.equals("tatcaphongban")) {
				tongCong_chuaNhanURL.setParameter("row", "tatcaphongban");
				tongCong_chuaNhanURL.setParameter("userIdRow", "");
			} else if(userId == 1) {
				tongCong_chuaNhanURL.setParameter("row", "");
				tongCong_chuaNhanURL.setParameter("userIdRow", "tatcachuyenvien");
			}
			
			tongCong_chuaNhanURL.setParameter("loaiCongVan", searchTerms.getLoaiCongVan());
			tongCong_chuaNhanURL.setParameter("departmentId", searchTerms.getDepartmentId());
			tongCong_chuaNhanURL.setParameter("userId", String.valueOf(searchTerms.getUserId()));
			tongCong_chuaNhanURL.setParameter("nhomCongVan", String.valueOf(searchTerms.getNhomCongVan()));
			tongCong_chuaNhanURL.setParameter("fromDate", searchTerms.getFromDate());
			tongCong_chuaNhanURL.setParameter("toDate", searchTerms.getToDate());
			tongCong_chuaNhanURL.setParameter("radioTenPhongBan", String.valueOf(searchTerms.isRadioTenPhongBan())); //yenlt update 28062010
			tongCong_chuaNhanURL.setParameter("radioTenChuyenVien", String.valueOf(searchTerms.isRadioTenChuyenVien())); //yenlt update 28062010
			tongCong_chuaNhanURL.setParameter("curVal", String.valueOf(documentReportSearch.getCurValue()));
			tongCong_chuaNhanURL.setParameter("redirect", documentReportSearch.getIteratorURL().toString()+ "&attView=yes" );
			
			// da giai quyet dung han URL
			PortletURL tongCong_dungHanURL = renderResponse.createRenderURL();
			tongCong_dungHanURL.setParameter("struts_action", "/sgs/pcccdocumentreceiptreport/pcccdocumentreceiptviewlist");
			tongCong_dungHanURL.setParameter("action", "dunghan");
			
			if (departmentId.equals("tatcaphongban")) {
				tongCong_dungHanURL.setParameter("row", "tatcaphongban");
				tongCong_dungHanURL.setParameter("userIdRow", "");
			} else if(userId == 1) {
				tongCong_dungHanURL.setParameter("row", "");
				tongCong_dungHanURL.setParameter("userIdRow", "tatcachuyenvien");
			}
			
			tongCong_dungHanURL.setParameter("loaiCongVan", searchTerms.getLoaiCongVan());
			tongCong_dungHanURL.setParameter("departmentId", searchTerms.getDepartmentId());
			tongCong_dungHanURL.setParameter("userId", String.valueOf(searchTerms.getUserId()));
			tongCong_dungHanURL.setParameter("nhomCongVan", String.valueOf(searchTerms.getNhomCongVan()));
			tongCong_dungHanURL.setParameter("fromDate", searchTerms.getFromDate());
			tongCong_dungHanURL.setParameter("toDate", searchTerms.getToDate());
			tongCong_dungHanURL.setParameter("radioTenPhongBan", String.valueOf(searchTerms.isRadioTenPhongBan())); //yenlt update 28062010
			tongCong_dungHanURL.setParameter("radioTenChuyenVien", String.valueOf(searchTerms.isRadioTenChuyenVien())); //yenlt update 28062010
			tongCong_dungHanURL.setParameter("curVal", String.valueOf(documentReportSearch.getCurValue()));
			tongCong_dungHanURL.setParameter("redirect", documentReportSearch.getIteratorURL().toString()+ "&attView=yes" );
			
			// da giai quyet tre han URL
			PortletURL tongCong_treHanURL = renderResponse.createRenderURL();
			tongCong_treHanURL.setParameter("struts_action", "/sgs/pcccdocumentreceiptreport/pcccdocumentreceiptviewlist");
			tongCong_treHanURL.setParameter("action", "trehan");
			
			if (departmentId.equals("tatcaphongban")) {
				tongCong_treHanURL.setParameter("row", "tatcaphongban");
				tongCong_treHanURL.setParameter("userIdRow", "");
			} else if(userId == 1) {
				tongCong_treHanURL.setParameter("row", "");
				tongCong_treHanURL.setParameter("userIdRow", "tatcachuyenvien");
			}
			
			tongCong_treHanURL.setParameter("loaiCongVan", searchTerms.getLoaiCongVan());
			tongCong_treHanURL.setParameter("departmentId", searchTerms.getDepartmentId());
			tongCong_treHanURL.setParameter("userId", String.valueOf(searchTerms.getUserId()));
			tongCong_treHanURL.setParameter("nhomCongVan", String.valueOf(searchTerms.getNhomCongVan()));
			tongCong_treHanURL.setParameter("fromDate", searchTerms.getFromDate());
			tongCong_treHanURL.setParameter("toDate", searchTerms.getToDate());
			tongCong_treHanURL.setParameter("radioTenPhongBan", String.valueOf(searchTerms.isRadioTenPhongBan())); //yenlt update 28062010
			tongCong_treHanURL.setParameter("radioTenChuyenVien", String.valueOf(searchTerms.isRadioTenChuyenVien())); //yenlt update 28062010
			tongCong_treHanURL.setParameter("curVal", String.valueOf(documentReportSearch.getCurValue()));
			tongCong_treHanURL.setParameter("redirect", documentReportSearch.getIteratorURL().toString()+ "&attView=yes" );
			
			// tong da giai quyet URL
			PortletURL tongCong_tongDaGiaiQuyetURL = renderResponse.createRenderURL();
			tongCong_tongDaGiaiQuyetURL.setParameter("struts_action", "/sgs/pcccdocumentreceiptreport/pcccdocumentreceiptviewlist");
			tongCong_tongDaGiaiQuyetURL.setParameter("action", "tongdagiaiquyet");
			
			if (departmentId.equals("tatcaphongban")) {
				tongCong_tongDaGiaiQuyetURL.setParameter("row", "tatcaphongban");
				tongCong_tongDaGiaiQuyetURL.setParameter("userIdRow", "");
			} else if(userId == 1) {
				tongCong_tongDaGiaiQuyetURL.setParameter("row", "");
				tongCong_tongDaGiaiQuyetURL.setParameter("userIdRow", "tatcachuyenvien");
			}
			
			tongCong_tongDaGiaiQuyetURL.setParameter("loaiCongVan", searchTerms.getLoaiCongVan());
			tongCong_tongDaGiaiQuyetURL.setParameter("departmentId", searchTerms.getDepartmentId());
			tongCong_tongDaGiaiQuyetURL.setParameter("userId", String.valueOf(searchTerms.getUserId()));
			tongCong_tongDaGiaiQuyetURL.setParameter("nhomCongVan", String.valueOf(searchTerms.getNhomCongVan()));
			tongCong_tongDaGiaiQuyetURL.setParameter("fromDate", searchTerms.getFromDate());
			tongCong_tongDaGiaiQuyetURL.setParameter("toDate", searchTerms.getToDate());
			tongCong_tongDaGiaiQuyetURL.setParameter("radioTenPhongBan", String.valueOf(searchTerms.isRadioTenPhongBan())); //yenlt update 28062010
			tongCong_tongDaGiaiQuyetURL.setParameter("radioTenChuyenVien", String.valueOf(searchTerms.isRadioTenChuyenVien())); //yenlt update 28062010
			tongCong_tongDaGiaiQuyetURL.setParameter("curVal", String.valueOf(documentReportSearch.getCurValue()));
			tongCong_tongDaGiaiQuyetURL.setParameter("redirect", documentReportSearch.getIteratorURL().toString()+ "&attView=yes" );
			
			// dang giai quyet trong quy dinh URL
			PortletURL tongCong_trongQuyDinhURL = renderResponse.createRenderURL();
			tongCong_trongQuyDinhURL.setParameter("struts_action", "/sgs/pcccdocumentreceiptreport/pcccdocumentreceiptviewlist");
			tongCong_trongQuyDinhURL.setParameter("action", "trongquidinh");
			
			if (departmentId.equals("tatcaphongban")) {
				tongCong_trongQuyDinhURL.setParameter("row", "tatcaphongban");
				tongCong_trongQuyDinhURL.setParameter("userIdRow", "");
			} else if(userId == 1) {
				tongCong_trongQuyDinhURL.setParameter("row", "");
				tongCong_trongQuyDinhURL.setParameter("userIdRow", "tatcachuyenvien");
			}
			
			tongCong_trongQuyDinhURL.setParameter("loaiCongVan", searchTerms.getLoaiCongVan());
			tongCong_trongQuyDinhURL.setParameter("departmentId", searchTerms.getDepartmentId());
			tongCong_trongQuyDinhURL.setParameter("userId", String.valueOf(searchTerms.getUserId()));
			tongCong_trongQuyDinhURL.setParameter("nhomCongVan", String.valueOf(searchTerms.getNhomCongVan()));
			tongCong_trongQuyDinhURL.setParameter("fromDate", searchTerms.getFromDate());
			tongCong_trongQuyDinhURL.setParameter("toDate", searchTerms.getToDate());
			tongCong_trongQuyDinhURL.setParameter("radioTenPhongBan", String.valueOf(searchTerms.isRadioTenPhongBan())); //yenlt update 28062010
			tongCong_trongQuyDinhURL.setParameter("radioTenChuyenVien", String.valueOf(searchTerms.isRadioTenChuyenVien())); //yenlt update 28062010
			tongCong_trongQuyDinhURL.setParameter("curVal", String.valueOf(documentReportSearch.getCurValue()));
			tongCong_trongQuyDinhURL.setParameter("redirect", documentReportSearch.getIteratorURL().toString()+ "&attView=yes" );
			
			// dang giai quyet qua quy dinh URL
			PortletURL tongCong_quaQuyDinhURL = renderResponse.createRenderURL();
			tongCong_quaQuyDinhURL.setParameter("struts_action", "/sgs/pcccdocumentreceiptreport/pcccdocumentreceiptviewlist");
			tongCong_quaQuyDinhURL.setParameter("action", "quaquydinh");
			
			if (departmentId.equals("tatcaphongban")) {
				tongCong_quaQuyDinhURL.setParameter("row", "tatcaphongban");
				tongCong_quaQuyDinhURL.setParameter("userIdRow", "");
			} else if(userId == 1) {
				tongCong_quaQuyDinhURL.setParameter("row", "");
				tongCong_quaQuyDinhURL.setParameter("userIdRow", "tatcachuyenvien");
			}
			
			tongCong_quaQuyDinhURL.setParameter("loaiCongVan", searchTerms.getLoaiCongVan());
			tongCong_quaQuyDinhURL.setParameter("departmentId", searchTerms.getDepartmentId());
			tongCong_quaQuyDinhURL.setParameter("userId", String.valueOf(searchTerms.getUserId()));
			tongCong_quaQuyDinhURL.setParameter("nhomCongVan", String.valueOf(searchTerms.getNhomCongVan()));
			tongCong_quaQuyDinhURL.setParameter("fromDate", searchTerms.getFromDate());
			tongCong_quaQuyDinhURL.setParameter("toDate", searchTerms.getToDate());
			tongCong_quaQuyDinhURL.setParameter("radioTenPhongBan", String.valueOf(searchTerms.isRadioTenPhongBan())); //yenlt update 28062010
			tongCong_quaQuyDinhURL.setParameter("radioTenChuyenVien", String.valueOf(searchTerms.isRadioTenChuyenVien())); //yenlt update 28062010
			tongCong_quaQuyDinhURL.setParameter("curVal", String.valueOf(documentReportSearch.getCurValue()));
			tongCong_quaQuyDinhURL.setParameter("redirect", documentReportSearch.getIteratorURL().toString()+ "&attView=yes" );
			
			// tong dang giai quyet URL
			PortletURL tongCong_tongDangGiaiQuyetURL = renderResponse.createRenderURL();
			tongCong_tongDangGiaiQuyetURL.setParameter("struts_action", "/sgs/pcccdocumentreceiptreport/pcccdocumentreceiptviewlist");
			tongCong_tongDangGiaiQuyetURL.setParameter("action", "tongdanggiaiquyet");
			
			if (departmentId.equals("tatcaphongban")) {
				tongCong_tongDangGiaiQuyetURL.setParameter("row", "tatcaphongban");
				tongCong_tongDangGiaiQuyetURL.setParameter("userIdRow", "");
			} else if(userId == 1) {
				tongCong_tongDangGiaiQuyetURL.setParameter("row", "");
				tongCong_tongDangGiaiQuyetURL.setParameter("userIdRow", "tatcachuyenvien");
			}
			
			tongCong_tongDangGiaiQuyetURL.setParameter("loaiCongVan", searchTerms.getLoaiCongVan());
			tongCong_tongDangGiaiQuyetURL.setParameter("departmentId", searchTerms.getDepartmentId());
			tongCong_tongDangGiaiQuyetURL.setParameter("userId", String.valueOf(searchTerms.getUserId()));
			tongCong_tongDangGiaiQuyetURL.setParameter("nhomCongVan", String.valueOf(searchTerms.getNhomCongVan()));
			tongCong_tongDangGiaiQuyetURL.setParameter("fromDate", searchTerms.getFromDate());
			tongCong_tongDangGiaiQuyetURL.setParameter("toDate", searchTerms.getToDate());
			tongCong_tongDangGiaiQuyetURL.setParameter("radioTenPhongBan", String.valueOf(searchTerms.isRadioTenPhongBan())); //yenlt update 28062010
			tongCong_tongDangGiaiQuyetURL.setParameter("radioTenChuyenVien", String.valueOf(searchTerms.isRadioTenChuyenVien())); //yenlt update 28062010
			tongCong_tongDangGiaiQuyetURL.setParameter("curVal", String.valueOf(documentReportSearch.getCurValue()));
			tongCong_tongDangGiaiQuyetURL.setParameter("redirect", documentReportSearch.getIteratorURL().toString()+ "&attView=yes" );
	
			// set param
			row1.addText(tongCong.getStt());
			row1.addText("<b>" + tongCong.getTen() + "</b>");
			if (tongCong.getTonDauKy() > 0) {
				row1.addText(String.valueOf(tongCong.getTonDauKy()), tongCong_tonDauKyURL.toString());
			}
			else {
				row1.addText(String.valueOf(tongCong.getTonDauKy()));
			}
			if (tongCong.getNhanTrongKy() > 0) {
				row1.addText(String.valueOf(tongCong.getNhanTrongKy()), tongCong_nhanTrongKyURL.toString());
			}
			else {
				row1.addText(String.valueOf(tongCong.getNhanTrongKy()));
			}
			if (tongCong.getChuaNhan() > 0) {
				row1.addText(String.valueOf(tongCong.getChuaNhan()), tongCong_chuaNhanURL.toString());
			}
			else {
				row1.addText(String.valueOf(tongCong.getChuaNhan()));
			}
			if (tongCong.getDungHan() > 0) {
				row1.addText(String.valueOf(tongCong.getDungHan()), tongCong_dungHanURL.toString());
			}
			else {
				row1.addText(String.valueOf(tongCong.getDungHan()));
			}
			if (tongCong.getTreHan() > 0) {
				row1.addText(String.valueOf(tongCong.getTreHan()), tongCong_treHanURL.toString());
			}
			else {
				row1.addText(String.valueOf(tongCong.getTreHan()));
			}
			if (tongCong.getTongDaGiaiQuyet() > 0) {
				row1.addText(String.valueOf(tongCong.getTongDaGiaiQuyet()), tongCong_tongDaGiaiQuyetURL.toString());
			}
			else {
				row1.addText(String.valueOf(tongCong.getTongDaGiaiQuyet()));
			}
			if (tongCong.getTrongQuiDinh() > 0) {
				row1.addText(String.valueOf(tongCong.getTrongQuiDinh()), tongCong_trongQuyDinhURL.toString());
			}
			else {
				row1.addText(String.valueOf(tongCong.getTrongQuiDinh()));
			}
			if (tongCong.getQuaQuiDinh() > 0) {
				row1.addText(String.valueOf(tongCong.getQuaQuiDinh()), tongCong_quaQuyDinhURL.toString());
			}
			else {
				row1.addText(String.valueOf(tongCong.getQuaQuiDinh()));
			}
			if (tongCong.getTongDangGiaiQuyet() > 0) {
				row1.addText(String.valueOf(tongCong.getTongDangGiaiQuyet()), tongCong_tongDangGiaiQuyetURL.toString());
			}
			else {
				row1.addText(String.valueOf(tongCong.getTongDangGiaiQuyet()));
			}
			row1.addText(tongCong.getTyLeGiaiQuyetDungHan());
	
			resultRows1.add(row1);
		}
	}
%>

<%
	SearchContainer searchContainer = (SearchContainer)request.getAttribute("liferay-ui:search:searchContainer");
	boolean paginate = true;
	int start = searchContainer.getStart();
	int end = searchContainer.getEnd();
	int total = searchContainer.getTotal();
	List resultRows = searchContainer.getResultRows();
	List<String> headerNames = searchContainer.getHeaderNames();
	Map orderableHeaders = searchContainer.getOrderableHeaders();
	String emptyResultsMessage = searchContainer.getEmptyResultsMessage();
	RowChecker rowChecker = searchContainer.getRowChecker();
	
	if (end > total) {
		end = total;
	}
	
	if (rowChecker != null) {
		if (headerNames != null) {
			headerNames.add(0, rowChecker.getAllRowsCheckBox());
		}
	}
	
	if (resultRows.isEmpty() && (headerNames == null)) {
		headerNames = new ArrayList<String>();
	
		headerNames.add(StringPool.BLANK);
	}
%>

	<c:if test="<%= (resultRows.size() > 0) || ((resultRows.size() == 0) && (emptyResultsMessage != null)) %>">
		<c:if test="<%= paginate %>">
			<div  class="taglib-search-iterator-page-iterator-top">	
				<liferay-ui:search-paginator searchContainer="<%= searchContainer %>" />
			</div>
		</c:if>
		<div class="results-grid">
			<table class="taglib-search-iterator" cellspacing="0">
				<tr class="portlet-section-header results-header">
					<td rowspan="2" align="center"><liferay-ui:message key="tinhhinhthulycongvan.stt" /></td>
					<td rowspan="2" align="center">
					<%
					// phmphuc update 17/05/2010
						/*String attTenCoQuanPhongBanChuyenVien = (renderRequest.getAttribute("attTenCoQuanPhongBanChuyenVien") == null) ? "toancoquan" : 
																(String) renderRequest.getAttribute("attTenCoQuanPhongBanChuyenVien");*/
						//String attTenCoQuanPhongBanChuyenVien = "toancoquan";//request.getAttribute("attTenCoQuanPhongBanChuyenVien").toString();
						//if(attTenCoQuanPhongBanChuyenVien.equals("toancoquan")) {
						if (departmentId.equals("toancoquan")) {
						%>
							<liferay-ui:message key="tinhhinhthulycongvan.toancoquan" />
						<%
						//} else if(attTenCoQuanPhongBanChuyenVien.equals("tenphongban")) {
						} else if (departmentId.equals("tatcaphongban") || userId == 0) {
						%>
							<liferay-ui:message key="tinhhinhthulycongvan.tenphongban" />
						<%
						} else {
						%>
							 <liferay-ui:message key="tinhhinhthulycongvan.tenchuyenvien" />
						<%
						}
					%>
					</td>
					<td rowspan="2" align="center"><liferay-ui:message key="tinhhinhthulycongvan.tondauky" /></td>
					<td rowspan="2" align="center"><liferay-ui:message key="tinhhinhthulycongvan.nhantrongky" /></td>
					<td rowspan="2" align="center"><liferay-ui:message key="tinhhinhthulycongvan-chuanhan" /></td>
					<td colspan="3" align="center"><liferay-ui:message key="tinhhinhthulycongvan.dagiaiquyet" /></td>
					<td colspan="3" align="center"><liferay-ui:message key="tinhhinhthulycongvan.danggiaiquyet" /></td>
					<td rowspan="2" align="center"><liferay-ui:message key="tinhhinhthulycongvan.tylephantramgiaiquyetdunghan" /></td>
				</tr>
				
				<tr class="portlet-section-header results-header">
					<td align="center"><liferay-ui:message key="tinhhinhthulycongvan.dunghan" /></td>
					<td align="center"><liferay-ui:message key="tinhhinhthulycongvan.trehan" /></td>
					<td align="center"><liferay-ui:message key="tinhhinhthulycongvan.tong" /></td>
					<td align="center"><liferay-ui:message key="tinhhinhthulycongvan.trongquidinh" /></td>
					<td align="center"><liferay-ui:message key="tinhhinhthulycongvan.quaquidinh" /></td>
					<td align="center"><liferay-ui:message key="tinhhinhthulycongvan.tong" /></td>
				</tr>

		<%
			boolean allRowsIsChecked = true;
	
			for (int i = 0; i < resultRows.size(); i++) {
				ResultRow row = (ResultRow)resultRows.get(i);
	
				String className = "portlet-section-alternate results-row alt";
				String classHoverName = "portlet-section-alternate-hover results-row alt hover";
	
				if (MathUtil.isEven(i)) {
					className = "portlet-section-body results-row";
					classHoverName = "portlet-section-body-hover results-row hover";
				}
	
				if (Validator.isNotNull(row.getClassName())) {
					className += " " + row.getClassName();
				}
	
				if (Validator.isNotNull(row.getClassHoverName())) {
					classHoverName += " " + row.getClassHoverName();
				}
	
				if (row.isRestricted()) {
					className += " restricted";
					classHoverName += " restricted";
				}
	
				row.setClassName(className);
				row.setClassHoverName(classHoverName);
	
				request.setAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW, row);
	
				List entries = row.getEntries();
	
				if (rowChecker != null) {
					boolean rowIsChecked = rowChecker.isChecked(row.getObject());
	
					if (!rowIsChecked) {
						allRowsIsChecked = false;
					}
	
					row.addText(0, rowChecker.getAlign(), rowChecker.getValign(), rowChecker.getColspan(), rowChecker.getRowCheckBox(rowIsChecked, row.getPrimaryKey()));
				}
			%>
	
				<tr class="<%= className %>"
					onmouseover="onMouseOverTr(this);" onmouseout="onMouseOutTr(this);"
					<c:if test="<%= searchContainer.isHover() %>">
						onmouseover="this.className = '<%= classHoverName %>';" onmouseout="this.className = '<%= className %>';"
					</c:if>
				>
	
				<%
				for (int j = 0; j < entries.size(); j++) {
					SearchEntry entry = (SearchEntry)entries.get(j);
	
					entry.setIndex(j);
	
					request.setAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW_ENTRY, entry);
				%>
	
					<td align="center" class="col-<%= j + 1 %><%= row.isBold() ? " taglib-search-iterator-highlighted" : "" %>" colspan="<%= entry.getColspan() %>" valign="<%= entry.getValign() %>">
	
						<%
						entry.print(pageContext);
						%>
	
					</td>
	
				<%
				}
				%>
	
				</tr>
	
			<%
			}
			%>
				
			</table>
				
		</div>
		
		<c:if test="<%= (resultRows.size() > 10) && paginate %>">
			<div class="taglib-search-iterator-page-iterator-bottom">
				<liferay-ui:search-paginator searchContainer="<%= searchContainer %>" />
			</div>
		</c:if>
		
	</c:if>	
	
	<%} %>



	<div id="table-button" align="right">
		<input type="button" value='<liferay-ui:message key="tinhhinhthulycongvan.inbaocao" />' onclick="<portlet:namespace />addActionFrom('word');<portlet:namespace />frmReport.submit();<portlet:namespace />setActionFrom();" />
	</div>		
</div>
</form>
<%
	// minh update 20100517
	//if (!"".equals(ParamUtil.getString(renderRequest, "loaiCongVan")) && "yes".equals(ParamUtil.getString(renderRequest,"attView"))) {
%>
<!-- portlet:actionURL var="xemBaoCaoBack"-->
	<!-- portlet:param name="struts_action" value="/sgs/pcccdocumentreceiptreport/view" /-->
	<!-- portlet:param name="attView" value="no" /-->
<!-- /portlet:actionURL-->
	<!-- script type="text/javascript"-->
		<!-- submitForm(document.<!portlet:namespace />frmReport, "<!%= xemBaoCao %>"); -->
	<!--/script-->
<%
	//}
	// end minh update 20100517
%>	