<%@ include file="/html/portlet/ext/onedoorpcccreport_baocaohosothangluyke/init.jsp" %>
<!-- %@ include file="/html/portlet/ext/onedoorpcccreport_baocaohosothangluyke/page_iterator/init_search.jsp" %-->

<%@page import="com.sgs.portlet.onedoorpcccreport.dto.LoaiHoSoDTO"%>
<%@page import="com.sgs.portlet.onedoorpcccreport.dto.BaoCaoHoSoThangLuyKeDTO"%>
<%@page import="com.sgs.portlet.onedoorpcccreport_baocaohosothangluyke.search.BaoCaoHoSoLuyKeSearch"%>
<%@page import="com.sgs.portlet.onedoorpcccreport_baocaohosothangluyke.search.BaoCaoHoSoLuyKeSearchTerms"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="java.util.List"%>
<%@page import="com.sgs.portlet.department.model.Department"%>
<%@page import="com.sgs.portlet.department.service.DepartmentLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.sgs.portlet.department.model.impl.DepartmentImpl"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>

<%@page import="com.liferay.portal.kernel.util.OrderByComparator"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.sgs.portlet.onedoor.service.PmlOneDoorReceiveFileLocalServiceUtil"%>
<%@page import="com.sgs.portlet.filetype.model.PmlFileType"%>
<%@page import="com.sgs.portlet.filetype.service.PmlFileTypeLocalServiceUtil"%>


<%@page import="com.sgs.portlet.pmluser.model.PmlUser"%>
<%@page import="com.sgs.portlet.pmluser.service.persistence.PmlUserUtil"%><liferay-util:include page="/html/portlet/ext/onedoorpcccreport_baocaohosothangluyke/js/onedoorpcccreport_baocaohosothangluyke-js.jsp"></liferay-util:include>

<portlet:actionURL var="report">
	<portlet:param name="struts_action" value="/sgs/onedoorpcccreport_baocaohosothangluyke/view" />
</portlet:actionURL>


<script type="text/javascript">
function <portlet:namespace />setActionFrom(param) {
	var action = "<%=report%>"; 
	if (param != "xembaocao") {
		action = action + "&" + param;
	}
	
	document.getElementsByName("<portlet:namespace />frmReport")[0].setAttribute("action", action);
}
</script>

<%
	//List<BaoCaoHoSoThangLuyKeDTO> baoCaoHoSoThangLuyKeList = (List<BaoCaoHoSoThangLuyKeDTO>)renderRequest.getAttribute("baoCaoHoSoThangLuyKeList")== null ? new ArrayList<BaoCaoHoSoThangLuyKeDTO>(): (List<BaoCaoHoSoThangLuyKeDTO>)renderRequest.getAttribute("baoCaoHoSoThangLuyKeList");
	//BaoCaoHoSoThangLuyKeDTO totalDTO = (BaoCaoHoSoThangLuyKeDTO) renderRequest.getAttribute("totalDTO");

	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action", "/sgs/onedoorpcccreport_baocaohosothangluyke/view" );
%>

<%
	BaoCaoHoSoLuyKeSearch baoCaoHoSoLuyKeSearch = new BaoCaoHoSoLuyKeSearch(renderRequest, portletURL);
	BaoCaoHoSoLuyKeSearchTerms searchTerms = (BaoCaoHoSoLuyKeSearchTerms)baoCaoHoSoLuyKeSearch.getSearchTerms();
		
%>
	
<form name="<portlet:namespace />frmReport" action="<%= report %>" method="post" onsubmit="return <portlet:namespace/>checkForm(this);">
<div class="title_categ"><liferay-ui:message key="bao-cao-ho-so-luy-ke"/></div>
<div class="boxcontent">

	<liferay-ui:search-form
			page="/html/portlet/ext/onedoorpcccreport_baocaohosothangluyke/baocaohosoluyke_search.jsp"
			searchContainer="<%= baoCaoHoSoLuyKeSearch %>" />
		
	<%
		SimpleDateFormat sF1 = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sF2 = new SimpleDateFormat("yyyy-MM-dd");
	
		String fromDate = searchTerms.getFromDate();
		String toDate = searchTerms.getToDate();
		
		if (Validator.isNull(toDate)) {
			toDate = sF1.format(new Date());;
		}
		
		String[] arrToDate = toDate.split("/");
		if (Validator.isNull(fromDate)) {
			fromDate = "01/" + arrToDate[1] + "/" + arrToDate[2];
		}
		
		fromDate = sF2.format(sF1.parse(fromDate));
		toDate = sF2.format(sF1.parse(toDate));
		
		String startDateOfYear = "01/01/"+arrToDate[2];
		
		List<String> typeList = new ArrayList<String>();
		List<String> valueTypeList = new ArrayList<String>();
		int start1 = baoCaoHoSoLuyKeSearch.getStart();
		int end1 = baoCaoHoSoLuyKeSearch.getEnd();
		OrderByComparator obc = null;	
	
		List<Department> departmentList = DepartmentLocalServiceUtil.findDepartments("tatca", start1, end1, baoCaoHoSoLuyKeSearch.getOrderByComparator());
		int total1 = DepartmentLocalServiceUtil.countDepartments("tatca");
		
		baoCaoHoSoLuyKeSearch.setResults(departmentList);
		baoCaoHoSoLuyKeSearch.setTotal(total1);
		
		portletURL.setParameter(baoCaoHoSoLuyKeSearch.getCurParam(),String.valueOf(baoCaoHoSoLuyKeSearch.getCurValue()));
	%>
	
	<%
		List<BaoCaoHoSoThangLuyKeDTO> baoCaoHoSoThangLuyKeList = new ArrayList<BaoCaoHoSoThangLuyKeDTO>();
		
		// Lay ra danh sach Phong co trong he thong
		//List<PmlDepartment> pmlDepartmentList = PmlDepartmentLocalServiceUtil.getPmlDepartments(-1, -1);
		
		List<PmlFileType> pmlFileTypeList = PmlFileTypeLocalServiceUtil.getPmlFileTypes(-1, -1);
		List<Long> allUserList = new ArrayList<Long>();
		int dsize = departmentList.size();
		
		for(int index = 0; index < dsize; index++) {
			List<LoaiHoSoDTO> loaiHoSoList = new ArrayList<LoaiHoSoDTO>();
			
			// set cac truong cho phong ban
			String tenPhongBan = "";
			int phongBanTonDauKy = 0;
			int phongBanTrongThangHoSoNhan = 0;
			int phongBanTongCong = 0;
			int phongBanTrongNamHoSoNhan = 0;
			int phongBanTrongThangHoSoGiaiQuyet = 0;
			int phongBanTrongNamHoSoGiaiQuyet = 0;
			int phongBanHoSoTon = 0;
			String ghiChuPhong = "";
			
			// Lay ra tung Phong de xu ly
			Department department = departmentList.get(index);
			String departmentId = department.getDepartmentsId();
			
			tenPhongBan = department.getDepartmentsName();
			ghiChuPhong = department.getDescription();
	
			// Lay danh sach user thuoc departmentId
			List<PmlUser> pmlUserList = null;
			try {
				pmlUserList = PmlUserUtil.findByDepartmentsId(departmentId);
			} catch (Exception e) {
				pmlUserList = new ArrayList<PmlUser>();
			}
			List<Long> longList = new ArrayList<Long>();
			for (int i = 0; i < pmlUserList.size(); i++) {
				longList.add(pmlUserList.get(i).getUserId());
				allUserList.add(pmlUserList.get(i).getUserId());
			}
			for(int i = 0; i <  pmlFileTypeList.size(); i ++) {
				PmlFileType pmlFileType = pmlFileTypeList.get(i);
				String pmlFileTypeId = pmlFileType.getFileTypeId();
	
				String tenLoaiHoSo = pmlFileType.getFileTypeName();
				
				int tonDauKy = PmlOneDoorReceiveFileLocalServiceUtil.getListTonDauKyThangLuyKe("", longList, pmlFileTypeId, fromDate, toDate, typeList, valueTypeList, -1, -1 , obc).size();
				int trongThangHoSoNhan = PmlOneDoorReceiveFileLocalServiceUtil.getListHSNhanTrongThangThangLuyKe("",longList, pmlFileTypeId, fromDate, toDate, typeList, valueTypeList,-1, -1 , obc).size();
				int tongCong = PmlOneDoorReceiveFileLocalServiceUtil.getListTongHSNhanThangLuyKe("",longList, pmlFileTypeId, fromDate, toDate, typeList, valueTypeList, -1, -1 , obc).size();
				int trongNamHoSoNhan = PmlOneDoorReceiveFileLocalServiceUtil.getListHSNhanTrongNamThangLuyKe("", longList, pmlFileTypeId, startDateOfYear, toDate, typeList, valueTypeList, -1, -1 , obc).size();
				int trongThangHoSoGiaiQuyet = PmlOneDoorReceiveFileLocalServiceUtil.getListHSGiaiQuyetTrongThangLuyKe("", longList, pmlFileTypeId, fromDate, toDate, typeList, valueTypeList, -1, -1 , obc).size();
				int trongNamHoSoGiaiQuyet = PmlOneDoorReceiveFileLocalServiceUtil.getListHSGiaiQuyetTrongNamLuyKe("", longList, pmlFileTypeId, startDateOfYear, toDate, typeList, valueTypeList, -1, -1 , obc).size();
				int hoSoTon = PmlOneDoorReceiveFileLocalServiceUtil.getListHSTonDenNgayBCThangLuyKe("", longList, pmlFileTypeId, toDate, typeList, valueTypeList, -1, -1 , obc).size();
			
				String ghiChuLoaiHoSo = "";
				
				LoaiHoSoDTO loaiHoSoDTO = new LoaiHoSoDTO();
				loaiHoSoDTO.setFileTypeId(pmlFileTypeId);
				loaiHoSoDTO.setTenLoaiHoSo(tenLoaiHoSo);
				loaiHoSoDTO.setTonDauKy(tonDauKy);
				loaiHoSoDTO.setTrongThangHoSoNhan(trongThangHoSoNhan);
				loaiHoSoDTO.setTongCong(tongCong);
				loaiHoSoDTO.setTrongNamHoSoNhan(trongNamHoSoNhan);
				loaiHoSoDTO.setTrongThangHoSoGiaiQuyet(trongThangHoSoGiaiQuyet);
				loaiHoSoDTO.setTrongNamHoSoGiaiQuyet(trongNamHoSoGiaiQuyet);
				loaiHoSoDTO.setHoSoTon(hoSoTon);
				loaiHoSoDTO.setGhiChu(ghiChuLoaiHoSo);
				
				if ((tongCong > 0) || (trongNamHoSoNhan > 0) || (trongThangHoSoGiaiQuyet > 0) || (trongNamHoSoGiaiQuyet > 0) || (hoSoTon > 0)) {
					loaiHoSoDTO.setHasFile(true);
					loaiHoSoList.add(loaiHoSoDTO);
				}
				
			}	
			phongBanTonDauKy = PmlOneDoorReceiveFileLocalServiceUtil.getListTonDauKyThangLuyKe(departmentId, longList, "", fromDate, toDate, typeList, valueTypeList, -1, -1  , obc).size();
			phongBanTrongThangHoSoNhan = PmlOneDoorReceiveFileLocalServiceUtil.getListHSNhanTrongThangThangLuyKe(departmentId,longList, "", fromDate, toDate, typeList, valueTypeList, -1, -1  , obc).size();
			phongBanTongCong = PmlOneDoorReceiveFileLocalServiceUtil.getListTongHSNhanThangLuyKe(departmentId,longList, "", fromDate, toDate, typeList, valueTypeList, -1, -1  , obc).size();
			phongBanTrongNamHoSoNhan = PmlOneDoorReceiveFileLocalServiceUtil.getListHSNhanTrongNamThangLuyKe(departmentId, longList, "", startDateOfYear, toDate, typeList, valueTypeList, -1, -1  , obc).size();
			phongBanTrongThangHoSoGiaiQuyet = PmlOneDoorReceiveFileLocalServiceUtil.getListHSGiaiQuyetTrongThangLuyKe(departmentId, longList, "", fromDate, toDate, typeList, valueTypeList, -1, -1  , obc).size();
			phongBanTrongNamHoSoGiaiQuyet = PmlOneDoorReceiveFileLocalServiceUtil.getListHSGiaiQuyetTrongNamLuyKe(departmentId, longList, "", startDateOfYear, toDate, typeList, valueTypeList, -1, -1  , obc).size();
			phongBanHoSoTon = PmlOneDoorReceiveFileLocalServiceUtil.getListHSTonDenNgayBCThangLuyKe(departmentId, longList, "", toDate, typeList, valueTypeList, -1, -1  , obc).size();
			
			BaoCaoHoSoThangLuyKeDTO baoCaoHoSoThangLuyKeDTO = new BaoCaoHoSoThangLuyKeDTO(); 
			baoCaoHoSoThangLuyKeDTO.setDepartmentId(departmentId);
			baoCaoHoSoThangLuyKeDTO.setTenPhongBan(tenPhongBan);
			baoCaoHoSoThangLuyKeDTO.setTonDauKy(phongBanTonDauKy);
			baoCaoHoSoThangLuyKeDTO.setTrongThangHoSoNhan(phongBanTrongThangHoSoNhan);
			baoCaoHoSoThangLuyKeDTO.setTongCong(phongBanTongCong);
			baoCaoHoSoThangLuyKeDTO.setTrongNamHoSoNhan(phongBanTrongNamHoSoNhan);
			baoCaoHoSoThangLuyKeDTO.setTrongThangHoSoGiaiQuyet(phongBanTrongThangHoSoGiaiQuyet);
			baoCaoHoSoThangLuyKeDTO.setTrongNamHoSoGiaiQuyet(phongBanTrongNamHoSoGiaiQuyet);
			baoCaoHoSoThangLuyKeDTO.setHoSoTon(phongBanHoSoTon);
			baoCaoHoSoThangLuyKeDTO.setGhiChu(ghiChuPhong);
			
			baoCaoHoSoThangLuyKeDTO.setLoaiHoSoList(loaiHoSoList);
			
			if ((phongBanTongCong > 0) || (phongBanTrongNamHoSoNhan > 0) || (phongBanTrongThangHoSoGiaiQuyet > 0) || (phongBanTrongNamHoSoGiaiQuyet > 0) || (phongBanHoSoTon > 0)) {
				baoCaoHoSoThangLuyKeDTO.setHasFile(true);
			}
				baoCaoHoSoThangLuyKeList.add(baoCaoHoSoThangLuyKeDTO);
	}	
	
		// Tong cong
		int totalTonDauKy = PmlOneDoorReceiveFileLocalServiceUtil.getListTonDauKyThangLuyKe("", allUserList, "", fromDate, toDate, typeList, valueTypeList, -1, -1  , obc).size();
		int totalTrongThangHoSoNhan = PmlOneDoorReceiveFileLocalServiceUtil.getListHSNhanTrongThangThangLuyKe("",allUserList, "", fromDate, toDate, typeList, valueTypeList, -1, -1  , obc).size();
		int totalTongCong = PmlOneDoorReceiveFileLocalServiceUtil.getListTongHSNhanThangLuyKe("",allUserList, "", fromDate, toDate, typeList, valueTypeList, -1, -1  , obc).size();
		int totalTrongNamHoSoNhan = PmlOneDoorReceiveFileLocalServiceUtil.getListHSNhanTrongNamThangLuyKe("", allUserList, "", startDateOfYear, toDate, typeList, valueTypeList, -1, -1  , obc).size();
		int totalTrongThangHoSoGiaiQuyet = PmlOneDoorReceiveFileLocalServiceUtil.getListHSGiaiQuyetTrongThangLuyKe("", allUserList, "", fromDate, toDate, typeList, valueTypeList, -1, -1  , obc).size();
		int totalTrongNamHoSoGiaiQuyet = PmlOneDoorReceiveFileLocalServiceUtil.getListHSGiaiQuyetTrongNamLuyKe("", allUserList, "", startDateOfYear, toDate, typeList, valueTypeList, -1, -1  , obc).size();
		int totalHoSoTon = PmlOneDoorReceiveFileLocalServiceUtil.getListHSTonDenNgayBCThangLuyKe("", allUserList, "", toDate, typeList, valueTypeList, -1, -1  , obc).size();
		
		BaoCaoHoSoThangLuyKeDTO totalDTO = new BaoCaoHoSoThangLuyKeDTO(); 
		totalDTO.setTonDauKy(totalTonDauKy);
		totalDTO.setTrongThangHoSoNhan(totalTrongThangHoSoNhan);
		totalDTO.setTongCong(totalTongCong);
		totalDTO.setTrongNamHoSoNhan(totalTrongNamHoSoNhan);
		totalDTO.setTrongThangHoSoGiaiQuyet(totalTrongThangHoSoGiaiQuyet);
		totalDTO.setTrongNamHoSoGiaiQuyet(totalTrongNamHoSoGiaiQuyet);
		totalDTO.setHoSoTon(totalHoSoTon);
		
		if ((totalTongCong > 0) || (totalTrongNamHoSoNhan > 0) || (totalTrongThangHoSoGiaiQuyet > 0) || (totalTrongNamHoSoGiaiQuyet > 0) || (totalHoSoTon > 0)) {
			totalDTO.setHasFile(true);
		}
		
		//baoCaoHoSoThangLuyKeList.add(totalDTO);
	%>
	
	<%
		List resultRows1 = baoCaoHoSoLuyKeSearch.getResultRows();
		ResultRow row = null;
		Department department = null;
		String departmentId = "";
		BaoCaoHoSoThangLuyKeDTO baoCaoHoSoThangLuyKeDTO = null;
		
		if ( departmentList.size() > 0) {
			for ( int i=0; i < baoCaoHoSoThangLuyKeList.size(); i++) {
				department = departmentList.get(i);
				department = department.toEscapedModel();
				departmentId = department.getDepartmentsId();
				
				baoCaoHoSoThangLuyKeDTO = baoCaoHoSoThangLuyKeList.get(i);
				
				row = new ResultRow(department, departmentId, i);
				
				//ten phong ban URL
				PortletURL tenPBURL = renderResponse.createRenderURL();
				tenPBURL.setParameter("struts_action","/sgs/onedoorpcccreport_baocaohosothangluyke/filedetails");
				tenPBURL.setParameter("action", "tenloaihoso");
				tenPBURL.setParameter("departmentId", baoCaoHoSoThangLuyKeDTO.getDepartmentId());
				tenPBURL.setParameter("fromDate", searchTerms.getFromDate());
				tenPBURL.setParameter("toDate", searchTerms.getToDate());
				tenPBURL.setParameter("redirect", baoCaoHoSoLuyKeSearch.getIteratorURL().toString());
				
				// ton dau ky URL
				PortletURL tonDauKyURL = renderResponse.createRenderURL();
				tonDauKyURL.setParameter("struts_action","/sgs/onedoorpcccreport_baocaohosothangluyke/filedetails");
				tonDauKyURL.setParameter("action", "tondauky");
				tonDauKyURL.setParameter("departmentId", baoCaoHoSoThangLuyKeDTO.getDepartmentId());
				tonDauKyURL.setParameter("fromDate", searchTerms.getFromDate());
				tonDauKyURL.setParameter("toDate", searchTerms.getToDate());
				tonDauKyURL.setParameter("redirect", baoCaoHoSoLuyKeSearch.getIteratorURL().toString());
				
				// trong thang ho so nhan URL
				PortletURL hsNhanTrongThangURL = renderResponse.createRenderURL();
				hsNhanTrongThangURL.setParameter("struts_action","/sgs/onedoorpcccreport_baocaohosothangluyke/filedetails");
				hsNhanTrongThangURL.setParameter("action", "trongthanghosonhan");
				hsNhanTrongThangURL.setParameter("departmentId", baoCaoHoSoThangLuyKeDTO.getDepartmentId());
				hsNhanTrongThangURL.setParameter("fromDate", searchTerms.getFromDate());
				hsNhanTrongThangURL.setParameter("toDate", searchTerms.getToDate());
				hsNhanTrongThangURL.setParameter("redirect", baoCaoHoSoLuyKeSearch.getIteratorURL().toString());
				
				// tong cong URL
				PortletURL tongCongURL = renderResponse.createRenderURL();
				tongCongURL.setParameter("struts_action","/sgs/onedoorpcccreport_baocaohosothangluyke/filedetails");
				tongCongURL.setParameter("action", "tongcong");
				tongCongURL.setParameter("departmentId", baoCaoHoSoThangLuyKeDTO.getDepartmentId());
				tongCongURL.setParameter("fromDate", searchTerms.getFromDate());
				tongCongURL.setParameter("toDate", searchTerms.getToDate());
				tongCongURL.setParameter("redirect", baoCaoHoSoLuyKeSearch.getIteratorURL().toString());
				
				// ho so tiep nhan trong nam URL
				PortletURL hsNhanTrongNamURL = renderResponse.createRenderURL();
				hsNhanTrongNamURL.setParameter("struts_action","/sgs/onedoorpcccreport_baocaohosothangluyke/filedetails");
				hsNhanTrongNamURL.setParameter("action", "trongnamhosonhan");
				hsNhanTrongNamURL.setParameter("departmentId", baoCaoHoSoThangLuyKeDTO.getDepartmentId());
				hsNhanTrongNamURL.setParameter("fromDate", searchTerms.getFromDate());
				hsNhanTrongNamURL.setParameter("toDate", searchTerms.getToDate());
				hsNhanTrongNamURL.setParameter("redirect", baoCaoHoSoLuyKeSearch.getIteratorURL().toString());
				
				// ho so giai quyet trong thang URL
				PortletURL giaiQuyetTrongThangURL = renderResponse.createRenderURL();
				giaiQuyetTrongThangURL.setParameter("struts_action","/sgs/onedoorpcccreport_baocaohosothangluyke/filedetails");
				giaiQuyetTrongThangURL.setParameter("action", "trongthanghosogiaiquyet");
				giaiQuyetTrongThangURL.setParameter("departmentId", baoCaoHoSoThangLuyKeDTO.getDepartmentId());
				giaiQuyetTrongThangURL.setParameter("fromDate", searchTerms.getFromDate());
				giaiQuyetTrongThangURL.setParameter("toDate", searchTerms.getToDate());
				giaiQuyetTrongThangURL.setParameter("redirect", baoCaoHoSoLuyKeSearch.getIteratorURL().toString());
				
				// ho so giai quyet trong nam URL
				PortletURL giaiQuyetTrongNamURL = renderResponse.createRenderURL();
				giaiQuyetTrongNamURL.setParameter("struts_action","/sgs/onedoorpcccreport_baocaohosothangluyke/filedetails");
				giaiQuyetTrongNamURL.setParameter("action", "trongnamhosogiaiquyet");
				giaiQuyetTrongNamURL.setParameter("departmentId", baoCaoHoSoThangLuyKeDTO.getDepartmentId());
				giaiQuyetTrongNamURL.setParameter("fromDate", searchTerms.getFromDate());
				giaiQuyetTrongNamURL.setParameter("toDate", searchTerms.getToDate());
				giaiQuyetTrongNamURL.setParameter("redirect", baoCaoHoSoLuyKeSearch.getIteratorURL().toString());
				
				// ho so ton URL
				PortletURL hsTonURL = renderResponse.createRenderURL();
				hsTonURL.setParameter("struts_action","/sgs/onedoorpcccreport_baocaohosothangluyke/filedetails");
				hsTonURL.setParameter("action", "hosoton");
				hsTonURL.setParameter("departmentId", baoCaoHoSoThangLuyKeDTO.getDepartmentId());
				hsTonURL.setParameter("fromDate", searchTerms.getFromDate());
				hsTonURL.setParameter("toDate", searchTerms.getToDate());
				hsTonURL.setParameter("redirect", baoCaoHoSoLuyKeSearch.getIteratorURL().toString());
				
				
				//dien giai
				if (baoCaoHoSoThangLuyKeDTO.isHasFile() == true) {
					row.addText(" - "+baoCaoHoSoThangLuyKeDTO.getTenPhongBan(), tenPBURL.toString());
				} else {
					row.addText(" - "+baoCaoHoSoThangLuyKeDTO.getTenPhongBan());
				}
				
				// ton dau ky
				if (baoCaoHoSoThangLuyKeDTO.getTonDauKy() > 0) {
					row.addText(String.valueOf(baoCaoHoSoThangLuyKeDTO.getTonDauKy()), tonDauKyURL.toString());
				} else {
					row.addText(String.valueOf(baoCaoHoSoThangLuyKeDTO.getTonDauKy()));
				}
				
				// trong thang
				if (baoCaoHoSoThangLuyKeDTO.getTrongThangHoSoNhan() > 0) {
					row.addText(String.valueOf(baoCaoHoSoThangLuyKeDTO.getTrongThangHoSoNhan()), hsNhanTrongThangURL.toString());
				} else {
					row.addText(String.valueOf(baoCaoHoSoThangLuyKeDTO.getTrongThangHoSoNhan()));
				}
				
				// tong cong
				if (baoCaoHoSoThangLuyKeDTO.getTongCong() > 0) {
					row.addText(String.valueOf(baoCaoHoSoThangLuyKeDTO.getTongCong()), tongCongURL.toString());
				} else {
					row.addText(String.valueOf(baoCaoHoSoThangLuyKeDTO.getTongCong()));
				}
				
				// ho so tiep nhan trong nam
				if (baoCaoHoSoThangLuyKeDTO.getTrongNamHoSoNhan() > 0) {
					row.addText(String.valueOf(baoCaoHoSoThangLuyKeDTO.getTrongNamHoSoNhan()), hsNhanTrongNamURL.toString());
				} else {
					row.addText(String.valueOf(baoCaoHoSoThangLuyKeDTO.getTrongNamHoSoNhan()));
				}
				
				// ho so giai quyet trong thang
				if (baoCaoHoSoThangLuyKeDTO.getTrongThangHoSoGiaiQuyet() > 0) {
					row.addText(String.valueOf(baoCaoHoSoThangLuyKeDTO.getTrongThangHoSoGiaiQuyet()), giaiQuyetTrongThangURL.toString());
				} else {
					row.addText(String.valueOf(baoCaoHoSoThangLuyKeDTO.getTrongThangHoSoGiaiQuyet()));
				}
				
				// ho so giai quyet trong nam
				if (baoCaoHoSoThangLuyKeDTO.getTrongNamHoSoGiaiQuyet() > 0) {
					row.addText(String.valueOf(baoCaoHoSoThangLuyKeDTO.getTrongNamHoSoGiaiQuyet()), giaiQuyetTrongNamURL.toString());
				} else {
					row.addText(String.valueOf(baoCaoHoSoThangLuyKeDTO.getTrongNamHoSoGiaiQuyet()));
				}
				
				// ho so ton
				if (baoCaoHoSoThangLuyKeDTO.getHoSoTon() > 0) {
					row.addText(String.valueOf(baoCaoHoSoThangLuyKeDTO.getHoSoTon()), hsTonURL.toString());
				} else {
					row.addText(String.valueOf(baoCaoHoSoThangLuyKeDTO.getHoSoTon()));
				}
				
				// ghi chu
				row.addText(baoCaoHoSoThangLuyKeDTO.getGhiChu());
				
				resultRows1.add(row);
				
				// add loai ho so thuoc tung phong ban
				int loaiHoSoSize = baoCaoHoSoThangLuyKeDTO.getLoaiHoSoList().size();
				for(int index = 0; index < loaiHoSoSize; index ++) {
					
					row = new ResultRow( new DepartmentImpl(), departmentId, index);
					
					LoaiHoSoDTO loaiHoSoDTO = baoCaoHoSoThangLuyKeDTO.getLoaiHoSoList().get(index);
					
					//ten loai ho so URL
					PortletURL tenLoaiHSURL = renderResponse.createRenderURL();
					tenLoaiHSURL.setParameter("struts_action","/sgs/onedoorpcccreport_baocaohosothangluyke/filedetails");
					tenLoaiHSURL.setParameter("action", "tenloaihoso");
					tenLoaiHSURL.setParameter("departmentId", baoCaoHoSoThangLuyKeDTO.getDepartmentId());
					tenLoaiHSURL.setParameter("fileTypeId", loaiHoSoDTO.getFileTypeId());
					tenLoaiHSURL.setParameter("fromDate", searchTerms.getFromDate());
					tenLoaiHSURL.setParameter("toDate", searchTerms.getToDate());
					tenLoaiHSURL.setParameter("redirect", baoCaoHoSoLuyKeSearch.getIteratorURL().toString());
					
					// ton dau ky URL
					PortletURL tonDauKyHSURL = renderResponse.createRenderURL();
					tonDauKyHSURL.setParameter("struts_action","/sgs/onedoorpcccreport_baocaohosothangluyke/filedetails");
					tonDauKyHSURL.setParameter("action", "tondauky");
					tonDauKyHSURL.setParameter("departmentId", baoCaoHoSoThangLuyKeDTO.getDepartmentId());
					tonDauKyHSURL.setParameter("fileTypeId", loaiHoSoDTO.getFileTypeId());
					tonDauKyHSURL.setParameter("fromDate", searchTerms.getFromDate());
					tonDauKyHSURL.setParameter("toDate", searchTerms.getToDate());
					tonDauKyHSURL.setParameter("redirect", baoCaoHoSoLuyKeSearch.getIteratorURL().toString());
					
					// trong thang ho so nhan URL
					PortletURL hsNhanTrongThangHSURL = renderResponse.createRenderURL();
					hsNhanTrongThangHSURL.setParameter("struts_action","/sgs/onedoorpcccreport_baocaohosothangluyke/filedetails");
					hsNhanTrongThangHSURL.setParameter("action", "trongthanghosonhan");
					hsNhanTrongThangHSURL.setParameter("departmentId", baoCaoHoSoThangLuyKeDTO.getDepartmentId());
					hsNhanTrongThangHSURL.setParameter("fileTypeId", loaiHoSoDTO.getFileTypeId());
					hsNhanTrongThangHSURL.setParameter("fromDate", searchTerms.getFromDate());
					hsNhanTrongThangHSURL.setParameter("toDate", searchTerms.getToDate());
					hsNhanTrongThangHSURL.setParameter("redirect", baoCaoHoSoLuyKeSearch.getIteratorURL().toString());
					
					// tong cong URL
					PortletURL tongCongHSURL = renderResponse.createRenderURL();
					tongCongHSURL.setParameter("struts_action","/sgs/onedoorpcccreport_baocaohosothangluyke/filedetails");
					tongCongHSURL.setParameter("action", "tongcong");
					tongCongHSURL.setParameter("departmentId", baoCaoHoSoThangLuyKeDTO.getDepartmentId());
					tongCongHSURL.setParameter("fileTypeId", loaiHoSoDTO.getFileTypeId());
					tongCongHSURL.setParameter("fromDate", searchTerms.getFromDate());
					tongCongHSURL.setParameter("toDate", searchTerms.getToDate());
					tongCongHSURL.setParameter("redirect", baoCaoHoSoLuyKeSearch.getIteratorURL().toString());
					
					// ho so tiep nhan trong nam URL
					PortletURL hsNhanTrongNamHSURL = renderResponse.createRenderURL();
					hsNhanTrongNamHSURL.setParameter("struts_action","/sgs/onedoorpcccreport_baocaohosothangluyke/filedetails");
					hsNhanTrongNamHSURL.setParameter("action", "trongnamhosonhan");
					hsNhanTrongNamHSURL.setParameter("departmentId", baoCaoHoSoThangLuyKeDTO.getDepartmentId());
					hsNhanTrongNamHSURL.setParameter("fileTypeId", loaiHoSoDTO.getFileTypeId());
					hsNhanTrongNamHSURL.setParameter("fromDate", searchTerms.getFromDate());
					hsNhanTrongNamHSURL.setParameter("toDate", searchTerms.getToDate());
					hsNhanTrongNamHSURL.setParameter("redirect", baoCaoHoSoLuyKeSearch.getIteratorURL().toString());
					
					// ho so giai quyet trong thang URL
					PortletURL giaiQuyetTrongThangHSURL = renderResponse.createRenderURL();
					giaiQuyetTrongThangHSURL.setParameter("struts_action","/sgs/onedoorpcccreport_baocaohosothangluyke/filedetails");
					giaiQuyetTrongThangHSURL.setParameter("action", "trongthanghosogiaiquyet");
					giaiQuyetTrongThangHSURL.setParameter("departmentId", baoCaoHoSoThangLuyKeDTO.getDepartmentId());
					giaiQuyetTrongThangHSURL.setParameter("fileTypeId", loaiHoSoDTO.getFileTypeId());
					giaiQuyetTrongThangHSURL.setParameter("fromDate", searchTerms.getFromDate());
					giaiQuyetTrongThangHSURL.setParameter("toDate", searchTerms.getToDate());
					giaiQuyetTrongThangHSURL.setParameter("redirect", baoCaoHoSoLuyKeSearch.getIteratorURL().toString());
					
					// ho so giai quyet trong nam URL
					PortletURL giaiQuyetTrongNamHSURL = renderResponse.createRenderURL();
					giaiQuyetTrongNamHSURL.setParameter("struts_action","/sgs/onedoorpcccreport_baocaohosothangluyke/filedetails");
					giaiQuyetTrongNamHSURL.setParameter("action", "trongnamhosogiaiquyet");
					giaiQuyetTrongNamHSURL.setParameter("departmentId", baoCaoHoSoThangLuyKeDTO.getDepartmentId());
					giaiQuyetTrongNamHSURL.setParameter("fileTypeId", loaiHoSoDTO.getFileTypeId());
					giaiQuyetTrongNamHSURL.setParameter("fromDate", searchTerms.getFromDate());
					giaiQuyetTrongNamHSURL.setParameter("toDate", searchTerms.getToDate());
					giaiQuyetTrongNamHSURL.setParameter("redirect", baoCaoHoSoLuyKeSearch.getIteratorURL().toString());
					
					// ho so ton URL
					PortletURL hsTonHSURL = renderResponse.createRenderURL();
					hsTonHSURL.setParameter("struts_action","/sgs/onedoorpcccreport_baocaohosothangluyke/filedetails");
					hsTonHSURL.setParameter("action", "hosoton");
					hsTonHSURL.setParameter("departmentId", baoCaoHoSoThangLuyKeDTO.getDepartmentId());
					hsTonHSURL.setParameter("fileTypeId", loaiHoSoDTO.getFileTypeId());
					hsTonHSURL.setParameter("fromDate", searchTerms.getFromDate());
					hsTonHSURL.setParameter("toDate", searchTerms.getToDate());
					hsTonHSURL.setParameter("redirect", baoCaoHoSoLuyKeSearch.getIteratorURL().toString());
					
					if (loaiHoSoDTO.isHasFile() == true) {
						row.addText(index+1 +"/ "+loaiHoSoDTO.getTenLoaiHoSo(),tenLoaiHSURL.toString());
					} else {
						row.addText(loaiHoSoDTO.getTenLoaiHoSo());
					}
					
					if (loaiHoSoDTO.getTonDauKy() > 0) {
						row.addText(String.valueOf(loaiHoSoDTO.getTonDauKy()), tonDauKyHSURL.toString());
					} else {
						row.addText(String.valueOf(loaiHoSoDTO.getTonDauKy()));
					}
					
					if (loaiHoSoDTO.getTrongThangHoSoNhan() > 0) {
						row.addText(String.valueOf(loaiHoSoDTO.getTrongThangHoSoNhan()), hsNhanTrongThangHSURL.toString());
					} else {
						row.addText(String.valueOf(loaiHoSoDTO.getTrongThangHoSoNhan()));
					}
					
					if (loaiHoSoDTO.getTongCong() > 0) {
						row.addText(String.valueOf(loaiHoSoDTO.getTongCong()), tongCongHSURL.toString());
					} else {
						row.addText(String.valueOf(loaiHoSoDTO.getTongCong()));
					}
					
					if (loaiHoSoDTO.getTrongNamHoSoNhan() > 0) {
						row.addText(String.valueOf(loaiHoSoDTO.getTrongNamHoSoNhan()), hsNhanTrongNamHSURL.toString());
					} else {
						row.addText(String.valueOf(loaiHoSoDTO.getTrongNamHoSoNhan()));
					}
					
					if (loaiHoSoDTO.getTrongThangHoSoGiaiQuyet() > 0) {
						row.addText(String.valueOf(loaiHoSoDTO.getTrongThangHoSoGiaiQuyet()), giaiQuyetTrongThangHSURL.toString());
					} else {
						row.addText(String.valueOf(loaiHoSoDTO.getTrongThangHoSoGiaiQuyet()));
					}
					
					if (loaiHoSoDTO.getTrongNamHoSoGiaiQuyet() > 0) {
						row.addText(String.valueOf(loaiHoSoDTO.getTrongNamHoSoGiaiQuyet()), giaiQuyetTrongNamHSURL.toString());
					} else {
						row.addText(String.valueOf(loaiHoSoDTO.getTrongNamHoSoGiaiQuyet()));
					}
					
					if (loaiHoSoDTO.getHoSoTon() > 0) {
						row.addText(String.valueOf(loaiHoSoDTO.getHoSoTon()), hsTonHSURL.toString());
					} else {
						row.addText(String.valueOf(loaiHoSoDTO.getHoSoTon()));
					}
					
					row.addText(loaiHoSoDTO.getGhiChu());
					
					resultRows1.add(row);
				}
			}
		}
		
		
		// add tong cong
		//if (baoCaoHoSoLuyKeSearch.getResultEnd() == total1) {
			row = new ResultRow( new DepartmentImpl(), departmentId, 0);
			
			// ton dau ky URL
			PortletURL tongTonDauKyURL = renderResponse.createRenderURL();
			tongTonDauKyURL.setParameter("struts_action","/sgs/onedoorpcccreport_baocaohosothangluyke/filedetails");
			tongTonDauKyURL.setParameter("action", "tondauky");
			tongTonDauKyURL.setParameter("fromDate", searchTerms.getFromDate());
			tongTonDauKyURL.setParameter("toDate", searchTerms.getToDate());
			tongTonDauKyURL.setParameter("redirect", baoCaoHoSoLuyKeSearch.getIteratorURL().toString());
			// trong thang ho so nhan URL
			PortletURL tonghsNhanTrongThangURL = renderResponse.createRenderURL();
			tonghsNhanTrongThangURL.setParameter("struts_action","/sgs/onedoorpcccreport_baocaohosothangluyke/filedetails");
			tonghsNhanTrongThangURL.setParameter("action", "trongthanghosonhan");
			tonghsNhanTrongThangURL.setParameter("fromDate", searchTerms.getFromDate());
			tonghsNhanTrongThangURL.setParameter("toDate", searchTerms.getToDate());
			tonghsNhanTrongThangURL.setParameter("redirect", baoCaoHoSoLuyKeSearch.getIteratorURL().toString());
			// tong cong URL
			PortletURL tongTongCongURL = renderResponse.createRenderURL();
			tongTongCongURL.setParameter("struts_action","/sgs/onedoorpcccreport_baocaohosothangluyke/filedetails");
			tongTongCongURL.setParameter("action", "tongcong");
			tongTongCongURL.setParameter("fromDate", searchTerms.getFromDate());
			tongTongCongURL.setParameter("toDate", searchTerms.getToDate());
			tongTongCongURL.setParameter("redirect", baoCaoHoSoLuyKeSearch.getIteratorURL().toString());
			// ho so tiep nhan trong nam URL
			PortletURL tonghsNhanTrongNamURL = renderResponse.createRenderURL();
			tonghsNhanTrongNamURL.setParameter("struts_action","/sgs/onedoorpcccreport_baocaohosothangluyke/filedetails");
			tonghsNhanTrongNamURL.setParameter("action", "trongnamhosonhan");
			tonghsNhanTrongNamURL.setParameter("fromDate", searchTerms.getFromDate());
			tonghsNhanTrongNamURL.setParameter("toDate", searchTerms.getToDate());
			tonghsNhanTrongNamURL.setParameter("redirect", baoCaoHoSoLuyKeSearch.getIteratorURL().toString());
			// ho so giai quyet trong thang URL
			PortletURL tongGiaiQuyetTrongThangURL = renderResponse.createRenderURL();
			tongGiaiQuyetTrongThangURL.setParameter("struts_action","/sgs/onedoorpcccreport_baocaohosothangluyke/filedetails");
			tongGiaiQuyetTrongThangURL.setParameter("action", "trongthanghosogiaiquyet");
			tongGiaiQuyetTrongThangURL.setParameter("fromDate", searchTerms.getFromDate());
			tongGiaiQuyetTrongThangURL.setParameter("toDate", searchTerms.getToDate());
			tongGiaiQuyetTrongThangURL.setParameter("redirect", baoCaoHoSoLuyKeSearch.getIteratorURL().toString());
			// ho so giai quyet trong nam URL
			PortletURL tongGiaiQuyetTrongNamURL = renderResponse.createRenderURL();
			tongGiaiQuyetTrongNamURL.setParameter("struts_action","/sgs/onedoorpcccreport_baocaohosothangluyke/filedetails");
			tongGiaiQuyetTrongNamURL.setParameter("action", "trongnamhosogiaiquyet");
			tongGiaiQuyetTrongNamURL.setParameter("fromDate", searchTerms.getFromDate());
			tongGiaiQuyetTrongNamURL.setParameter("toDate", searchTerms.getToDate());
			tongGiaiQuyetTrongNamURL.setParameter("redirect", baoCaoHoSoLuyKeSearch.getIteratorURL().toString());
			// ho so ton URL
			PortletURL tonghsTonURL = renderResponse.createRenderURL();
			tonghsTonURL.setParameter("struts_action","/sgs/onedoorpcccreport_baocaohosothangluyke/filedetails");
			tonghsTonURL.setParameter("action", "hosoton");
			tonghsTonURL.setParameter("fromDate", searchTerms.getFromDate());
			tonghsTonURL.setParameter("toDate", searchTerms.getToDate());
			tonghsTonURL.setParameter("redirect", baoCaoHoSoLuyKeSearch.getIteratorURL().toString());
			//dien giai
			row.addText(LanguageUtil.get(pageContext,"onedoorpcccreport-tongcong"));
			
			if (totalDTO.getTonDauKy() > 0) {
				row.addText(String.valueOf(totalDTO.getTonDauKy()),tongTonDauKyURL.toString());
			} else {
				row.addText(String.valueOf(totalDTO.getTonDauKy()));
			}
			
			if (totalDTO.getTrongThangHoSoNhan() > 0) {
				row.addText(String.valueOf(totalDTO.getTrongThangHoSoNhan()),tonghsNhanTrongThangURL.toString());
			} else {
				row.addText(String.valueOf(totalDTO.getTrongThangHoSoNhan()));
			}
			
			if (totalDTO.getTongCong() > 0) {
				row.addText(String.valueOf(totalDTO.getTongCong()),tongTongCongURL.toString());
			} else {
				row.addText(String.valueOf(totalDTO.getTongCong()));
			}
			
			if (totalDTO.getTrongNamHoSoNhan() > 0) {
				row.addText(String.valueOf(totalDTO.getTrongNamHoSoNhan()),tonghsNhanTrongNamURL.toString());
			} else {
				row.addText(String.valueOf(totalDTO.getTrongNamHoSoNhan()));
			}
			
			if (totalDTO.getTrongThangHoSoGiaiQuyet() > 0) {
				row.addText(String.valueOf(totalDTO.getTrongThangHoSoGiaiQuyet()),tongGiaiQuyetTrongThangURL.toString());
			} else {
				row.addText(String.valueOf(totalDTO.getTrongThangHoSoGiaiQuyet()));
			}
			
			if (totalDTO.getTrongNamHoSoGiaiQuyet() > 0) {
				row.addText(String.valueOf(totalDTO.getTrongNamHoSoGiaiQuyet()),tongGiaiQuyetTrongNamURL.toString());
			} else {
				row.addText(String.valueOf(totalDTO.getTrongNamHoSoGiaiQuyet()));
			}
			
			if (totalDTO.getHoSoTon() > 0) {
				row.addText(String.valueOf(totalDTO.getHoSoTon()),tonghsTonURL.toString());
			} else {
				row.addText(String.valueOf(totalDTO.getHoSoTon()));
			}
			
			row.addText("");
			
			resultRows1.add(row);
			
		//}
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
			<table class="taglib-search-iterator" cellspacing="0" width="100%"> 
				<tr class="portlet-section-header results-header">
					<td rowspan="2"><b><liferay-ui:message key="onedoorpcccreport-diengiai" /></b></td>
					<td colspan="3" ><align="center"b><liferay-ui:message key="onedoorpcccreport-hosonhan" /></b></td>
					<td rowspan="2" width="6%" align="center"><b><liferay-ui:message key="onedoorpcccreport-hosotiepnhantrongnam" /></b></td>
					<td colspan="2" align="center"><b><liferay-ui:message key="onedoorpcccreport-hosogiaiquyet" /></b></td>
					<td rowspan="2" width="6%" align="center"><b><liferay-ui:message key="onedoorpcccreport-hosoton" /></b></td>
					<td rowspan="2" width="15%"><b><liferay-ui:message key="onedoorpcccreport-ghichu" /></b></td>
				</tr>
				<tr class="portlet-section-header results-header">
					<td width="5%" align="center"><b><liferay-ui:message key="onedoorpcccreport-tondauky" /></b></td>
					<td width="5%" align="center"><b><liferay-ui:message key="onedoorpcccreport-trongthang" /></b></td>
					<td width="5%" align="center"><b><liferay-ui:message key="onedoorpcccreport-tongcong" /></b></td>
					<td width="5%" align="center"><b><liferay-ui:message key="onedoorpcccreport-trongthang" /></b></td>
					<td width="5%" align="center"><b><liferay-ui:message key="onedoorpcccreport-trongnam" /></b></td>
				</tr>
			
			<%
			boolean allRowsIsChecked = true;
	
			for (int i = 0; i < resultRows.size(); i++) {
				ResultRow row1 = (ResultRow)resultRows.get(i);
	
				String className = "portlet-section-alternate results-row alt";
				String classHoverName = "portlet-section-alternate-hover results-row alt hover";
	
				if (MathUtil.isEven(i)) {
					className = "portlet-section-body results-row";
					classHoverName = "portlet-section-body-hover results-row hover";
				}
	
				if (Validator.isNotNull(row1.getClassName())) {
					className += " " + row1.getClassName();
				}
	
				if (Validator.isNotNull(row1.getClassHoverName())) {
					classHoverName += " " + row1.getClassHoverName();
				}
	
				if (row1.isRestricted()) {
					className += " restricted";
					classHoverName += " restricted";
				}
	
				row1.setClassName(className);
				row1.setClassHoverName(classHoverName);
	
				request.setAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW, row1);
	
				List entries = row1.getEntries();
	
				if (rowChecker != null) {
					boolean rowIsChecked = rowChecker.isChecked(row1.getObject());
	
					if (!rowIsChecked) {
						allRowsIsChecked = false;
					}
	
					row1.addText(0, rowChecker.getAlign(), rowChecker.getValign(), rowChecker.getColspan(), rowChecker.getRowCheckBox(rowIsChecked, row1.getPrimaryKey()));
				}
			%>
	
				<tr class="<%= className %>"
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
	
					<td align="<%= entry.getAlign() %>" class="rpt_lk-<%= j + 1 %><%= row.isBold() ? " taglib-search-iterator-highlighted" : "" %>" colspan="<%= entry.getColspan() %>" valign="<%= entry.getValign() %>">
	
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
<div id="table-button" align="right">
		<input class="button-width" type="submit" value='<liferay-ui:message key="onedoorpcccreport-xuattaptin" />' onclick="<portlet:namespace />setActionFrom('<portlet:namespace />report=true');<portlet:namespace />frmReport.submit();" />
</div>
</div>
</form>
				
