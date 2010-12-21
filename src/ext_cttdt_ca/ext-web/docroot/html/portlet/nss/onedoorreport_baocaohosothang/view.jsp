<%@ include file="/html/portlet/nss/onedoorreport_baocaohosothang/init.jsp" %>

<%@page import="java.util.List"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>

<%@page import="com.nss.portlet.onedoorreport_baocaohosothang.search.BaoCaoHoSoThangSearch"%>
<%@page import="com.nss.portlet.onedoorreport_baocaohosothang.search.BaoCaoHoSoThangSearchTerms"%>
<%@page import="com.nss.portlet.filetype.model.PmlFileType"%>
<%@page import="com.nss.portlet.filetype.service.PmlFileTypeLocalServiceUtil"%>
<%@page import="com.nss.portlet.onedoor.dto.BaoCaoHoSoThangDTO"%>
<%@page import="com.nss.portlet.onedoor.service.PmlOneDoorReceiveFileLocalServiceUtil"%>
<%@page import="com.nss.portlet.onedoorreport_baocaohosothang.action.ViewAction"%>
<%@page import="com.nss.portlet.filetype.model.impl.PmlFileTypeImpl"%>

<liferay-util:include page="/html/portlet/nss/onedoorreport_baocaohosothang/js/onedoorreport_baocaohosothang-js.jsp"></liferay-util:include>

<link type="text/css" rel="stylesheet" href="/html/css/changeColorRow.css" />
<link type="text/css" rel="stylesheet" href="/html/portlet/ext/onedoorreport_baocaohosothang/css/ex.css" />

<portlet:actionURL var="report">
	<portlet:param name="struts_action" value="/nss/onedoorreport_baocaohosothang/view" />
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
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action", "/nss/onedoorreport_baocaohosothang/view" );
%>
	
<form name="<portlet:namespace />frmReport" action="<%= report %>" method="post" onsubmit="return <portlet:namespace/>checkForm(this);">
	<div class="commom-form">
	<div class="parent-title"><liferay-ui:message key="bao-cao-ho-so-thang"/></div>

	<%
		BaoCaoHoSoThangSearch baoCaoHoSoThangSearch = new BaoCaoHoSoThangSearch(renderRequest, portletURL);
		BaoCaoHoSoThangSearchTerms searchTerms = (BaoCaoHoSoThangSearchTerms)baoCaoHoSoThangSearch.getSearchTerms();
	%>
	<liferay-ui:search-form
			page="/html/portlet/nss/onedoorreport_baocaohosothang/baocaohosothang_search.jsp"
			searchContainer="<%= baoCaoHoSoThangSearch %>" />
	<%
		
		List<PmlFileType> pmlFileTypeList = PmlFileTypeLocalServiceUtil.search(baoCaoHoSoThangSearch.getStart(), baoCaoHoSoThangSearch.getEnd(), baoCaoHoSoThangSearch.getOrderByComparator());
		int total1 = PmlFileTypeLocalServiceUtil.getPmlFileTypesCount();
		baoCaoHoSoThangSearch.setResults(pmlFileTypeList);
		baoCaoHoSoThangSearch.setTotal(total1);
		portletURL.setParameter(baoCaoHoSoThangSearch.getCurParam(),String.valueOf(baoCaoHoSoThangSearch.getCurValue()));
		
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
		
		List<String> typeList = new ArrayList<String>();
		List<String> valueTypeList = new ArrayList<String>();
		int start1 = baoCaoHoSoThangSearch.getStart();
		int end1 = baoCaoHoSoThangSearch.getEnd();
		OrderByComparator obc = null;
		
		List<BaoCaoHoSoThangDTO> baoCaoHoSoThangList = new ArrayList<BaoCaoHoSoThangDTO>();
		
		int tongTonDauKy = 0;
		int tongHoSoNhanTrongThang = 0;
		int tongTongCong = 0;
		int tongSoDungHan = 0;
		int tongSoTreHan = 0;
		int tongTrongHan = 0;
		int tongDaTreHan = 0;
		int tongChinhSuaBoSung = 0;
		String tongTyLeHoSoDungHan = "";
		
		int pmlFileTypeSize = pmlFileTypeList.size();
		for(int index = 0; index < pmlFileTypeList.size(); index ++) {
			
			// Lay ra tung FileType de xu ly
			PmlFileType pmlFileType = pmlFileTypeList.get(index);
			String pmlFileTypeId = pmlFileType.getFileTypeId();
			List<PmlFileType> listFileTypeIndex = new ArrayList<PmlFileType>();
			listFileTypeIndex.add(pmlFileType);
			
			int stt = index + 1;
			String tenSanPham = pmlFileType.getFileTypeName();
			
			int tonDauKy = PmlOneDoorReceiveFileLocalServiceUtil.getSoLuongHSTonBCThang(listFileTypeIndex, fromDate, typeList, valueTypeList, -1, -1 , obc).size();
			int hoSoNhanTrongThang = PmlOneDoorReceiveFileLocalServiceUtil.getSoLuongHSNhanTrongThang(listFileTypeIndex, fromDate, toDate, typeList, valueTypeList, -1, -1 , obc).size();
			int tongCong = PmlOneDoorReceiveFileLocalServiceUtil.getSoLuongTongHS(listFileTypeIndex, fromDate, toDate, typeList, valueTypeList, -1, -1 , obc).size();
			int soDungHan = PmlOneDoorReceiveFileLocalServiceUtil.getSoHSHoanThanhDungHan(listFileTypeIndex, fromDate, toDate, typeList, valueTypeList, -1, -1 , obc).size();
			int soTreHan = PmlOneDoorReceiveFileLocalServiceUtil.getSoHSHoanThanhTreHan(listFileTypeIndex, fromDate, toDate, typeList, valueTypeList, -1, -1 , obc).size();
			int trongHan = PmlOneDoorReceiveFileLocalServiceUtil.getSoHSDangThuLyDungHan(listFileTypeIndex, fromDate, toDate, typeList, valueTypeList, -1, -1 , obc).size();
			int daTreHan = PmlOneDoorReceiveFileLocalServiceUtil.getSoHSDangThuLyTreHan(listFileTypeIndex,fromDate, toDate, typeList, valueTypeList, -1, -1 , obc).size();
			int chinhSuaBoSung = PmlOneDoorReceiveFileLocalServiceUtil.getSoHSChoBoSung(listFileTypeIndex, fromDate, toDate, typeList, valueTypeList, -1, -1 , obc).size();
			
			// Cach tinh: [(hoan thanh dung han + ton trong han + ton chinh sua, bo sung) / tong ho so can xu ly trong thang]*100%
			String tyLeHoSoDungHan = "-";

			if (tongCong > 0) {
				int tongBaLoaiHoSo = soDungHan+trongHan+chinhSuaBoSung;
				
				if ((tongBaLoaiHoSo == 0) || (tongBaLoaiHoSo == tongCong)) {
					int tyLeChan = (tongBaLoaiHoSo / tongCong) * 100;
					tyLeHoSoDungHan = tyLeChan +"%";
				} else {
					tyLeHoSoDungHan = ViewAction.Round(((float)tongBaLoaiHoSo / tongCong)* 100,2)+ "%";
				}
			} else {
				tyLeHoSoDungHan = "/";
			}
			
			BaoCaoHoSoThangDTO baoCaoHoSoThangDTO = new BaoCaoHoSoThangDTO();
			baoCaoHoSoThangDTO.setFileTypeId(pmlFileTypeId);
			baoCaoHoSoThangDTO.setStt(stt);
			baoCaoHoSoThangDTO.setTenSanPham(tenSanPham);
			baoCaoHoSoThangDTO.setTonDauKy(tonDauKy);
			baoCaoHoSoThangDTO.setHoSoNhanTrongThang(hoSoNhanTrongThang);
			baoCaoHoSoThangDTO.setTongCong(tongCong);
			baoCaoHoSoThangDTO.setSoDungHan(soDungHan);
			baoCaoHoSoThangDTO.setSoTreHan(soTreHan);
			baoCaoHoSoThangDTO.setTrongHan(trongHan);
			baoCaoHoSoThangDTO.setDaTreHan(daTreHan);
			baoCaoHoSoThangDTO.setChinhSuaBoSung(chinhSuaBoSung);
			baoCaoHoSoThangDTO.setTyLeHoSoDungHan(tyLeHoSoDungHan);
			
			baoCaoHoSoThangList.add(baoCaoHoSoThangDTO);
			
		}
		//tinh tong
		List<PmlFileType> pmlFileTypeListTotal = PmlFileTypeLocalServiceUtil.getPmlFileTypes(-1, -1);
		
		tongTonDauKy = PmlOneDoorReceiveFileLocalServiceUtil.getSoLuongHSTonBCThang(pmlFileTypeListTotal, fromDate, typeList, valueTypeList, -1, -1 , obc).size();
		tongHoSoNhanTrongThang = PmlOneDoorReceiveFileLocalServiceUtil.getSoLuongHSNhanTrongThang(pmlFileTypeListTotal, fromDate, toDate, typeList, valueTypeList, -1, -1 , obc).size();
		tongTongCong = PmlOneDoorReceiveFileLocalServiceUtil.getSoLuongTongHS(pmlFileTypeListTotal, fromDate, toDate, typeList, valueTypeList, -1, -1 , obc).size();
		tongSoDungHan = PmlOneDoorReceiveFileLocalServiceUtil.getSoHSHoanThanhDungHan(pmlFileTypeListTotal, fromDate, toDate, typeList, valueTypeList, -1, -1 , obc).size();
		tongSoTreHan = PmlOneDoorReceiveFileLocalServiceUtil.getSoHSHoanThanhTreHan(pmlFileTypeListTotal, fromDate, toDate, typeList, valueTypeList, -1, -1 , obc).size();
		tongTrongHan = PmlOneDoorReceiveFileLocalServiceUtil.getSoHSDangThuLyDungHan(pmlFileTypeListTotal, fromDate, toDate, typeList, valueTypeList, -1, -1 , obc).size();
		tongDaTreHan= PmlOneDoorReceiveFileLocalServiceUtil.getSoHSDangThuLyTreHan(pmlFileTypeListTotal, fromDate, toDate, typeList, valueTypeList, -1, -1 , obc).size();
		tongChinhSuaBoSung = PmlOneDoorReceiveFileLocalServiceUtil.getSoHSChoBoSung(pmlFileTypeListTotal, fromDate, toDate, typeList, valueTypeList, -1, -1 , obc).size();
		
		BaoCaoHoSoThangDTO tongCongDTO = new BaoCaoHoSoThangDTO();
		tongCongDTO.setFileTypeId("all");
		tongCongDTO.setStt(pmlFileTypeSize + 1);
		tongCongDTO.setTenSanPham("");
		tongCongDTO.setTonDauKy(tongTonDauKy);
		tongCongDTO.setHoSoNhanTrongThang(tongHoSoNhanTrongThang);
		tongCongDTO.setTongCong(tongTongCong);
		tongCongDTO.setSoDungHan(tongSoDungHan);
		tongCongDTO.setSoTreHan(tongSoTreHan);
		tongCongDTO.setTrongHan(tongTrongHan);
		tongCongDTO.setDaTreHan(tongDaTreHan);
		tongCongDTO.setChinhSuaBoSung(tongChinhSuaBoSung);
		tongCongDTO.setTyLeHoSoDungHan("-");
		if (tongTongCong > 0) {
			int total = tongSoDungHan + tongTrongHan + tongChinhSuaBoSung;
			
			if ((total == 0) || (total == tongTongCong)) {
				int tongTyLeChan = (total / tongTongCong) * 100;
				tongTyLeHoSoDungHan = tongTyLeChan +"%";
			} else {
				tongTyLeHoSoDungHan = ViewAction.Round(((float)total / tongTongCong)* 100,2)+ "%";	
			}
		} else { 
			tongTyLeHoSoDungHan = "/";
		}
		tongCongDTO.setTyLeHoSoDungHan(tongTyLeHoSoDungHan);
	%>
	
	<%
		List resultRows1 = baoCaoHoSoThangSearch.getResultRows();
		ResultRow row1 = null;
		PmlFileType pmlFileType = null;
		String fileTypeId = "";
		BaoCaoHoSoThangDTO baoCaoHoSoThangDTO = null;
		
		if (pmlFileTypeList.size() > 0 ){
			for ( int i=0; i< baoCaoHoSoThangList.size(); i++) {

				pmlFileType = pmlFileTypeList.get(i);
				pmlFileType = pmlFileType.toEscapedModel();
				fileTypeId =  pmlFileType.getFileTypeId();
				
				baoCaoHoSoThangDTO = baoCaoHoSoThangList.get(i);
				
				row1 = new ResultRow(pmlFileType,fileTypeId, i);
				
				// ten san pham URL
				PortletURL tenSanPhamURL = renderResponse.createRenderURL();
				tenSanPhamURL.setParameter("struts_action","/nss/onedoorreport_baocaohosothang/filedetails");
				tenSanPhamURL.setParameter("columeName", "tensanpham");
				tenSanPhamURL.setParameter("fileTypeId",baoCaoHoSoThangDTO.getFileTypeId());
				tenSanPhamURL.setParameter("fromDate", searchTerms.getFromDate());
				tenSanPhamURL.setParameter("toDate", searchTerms.getToDate());
				tenSanPhamURL.setParameter("redirect", baoCaoHoSoThangSearch.getIteratorURL().toString());
				// ton dau ky URL
				PortletURL tonDauKyURL = renderResponse.createRenderURL();
				tonDauKyURL.setParameter("struts_action","/nss/onedoorreport_baocaohosothang/filedetails");
				tonDauKyURL.setParameter("columeName", "tondauky");
				tonDauKyURL.setParameter("fileTypeId",baoCaoHoSoThangDTO.getFileTypeId());
				tonDauKyURL.setParameter("fromDate", searchTerms.getFromDate());
				tonDauKyURL.setParameter("toDate", searchTerms.getToDate());
				tonDauKyURL.setParameter("redirect", baoCaoHoSoThangSearch.getIteratorURL().toString());
				// ho so nhan trong thang URL
				PortletURL nhanTrongThangURL = renderResponse.createRenderURL();
				nhanTrongThangURL.setParameter("struts_action","/nss/onedoorreport_baocaohosothang/filedetails");
				nhanTrongThangURL.setParameter("columeName", "nhantrongthang");
				nhanTrongThangURL.setParameter("fileTypeId",baoCaoHoSoThangDTO.getFileTypeId());
				nhanTrongThangURL.setParameter("fromDate", searchTerms.getFromDate());
				nhanTrongThangURL.setParameter("toDate", searchTerms.getToDate());
	                        nhanTrongThangURL.setParameter("redirect", baoCaoHoSoThangSearch.getIteratorURL().toString());
				
				// tong cong URL
				PortletURL tongCongURL = renderResponse.createRenderURL();
				tongCongURL.setParameter("struts_action","/nss/onedoorreport_baocaohosothang/filedetails");
				tongCongURL.setParameter("columeName", "tongcong");
				tongCongURL.setParameter("fileTypeId",baoCaoHoSoThangDTO.getFileTypeId());
				tongCongURL.setParameter("fromDate", searchTerms.getFromDate());
				tongCongURL.setParameter("toDate", searchTerms.getToDate());
				tongCongURL.setParameter("redirect", baoCaoHoSoThangSearch.getIteratorURL().toString());
				// so dung han URL
				PortletURL soDungHanURL = renderResponse.createRenderURL();
				soDungHanURL.setParameter("struts_action","/nss/onedoorreport_baocaohosothang/filedetails");
				soDungHanURL.setParameter("columeName", "sodunghan");
				soDungHanURL.setParameter("fileTypeId",baoCaoHoSoThangDTO.getFileTypeId());
				soDungHanURL.setParameter("fromDate", searchTerms.getFromDate());
				soDungHanURL.setParameter("toDate", searchTerms.getToDate());
				soDungHanURL.setParameter("redirect", baoCaoHoSoThangSearch.getIteratorURL().toString());
				// so tre han URL
				PortletURL soTreHanURL = renderResponse.createRenderURL();
				soTreHanURL.setParameter("struts_action","/nss/onedoorreport_baocaohosothang/filedetails");
				soTreHanURL.setParameter("columeName", "sotrehan");
				soTreHanURL.setParameter("fileTypeId",baoCaoHoSoThangDTO.getFileTypeId());
				soTreHanURL.setParameter("fromDate", searchTerms.getFromDate());
				soTreHanURL.setParameter("toDate", searchTerms.getToDate());
				soTreHanURL.setParameter("redirect", baoCaoHoSoThangSearch.getIteratorURL().toString());
				// trong han URL
				PortletURL trongHanURL = renderResponse.createRenderURL();
				trongHanURL.setParameter("struts_action","/nss/onedoorreport_baocaohosothang/filedetails");
				trongHanURL.setParameter("columeName", "tronghan");
				trongHanURL.setParameter("fileTypeId",baoCaoHoSoThangDTO.getFileTypeId());
				trongHanURL.setParameter("fromDate", searchTerms.getFromDate());
				trongHanURL.setParameter("toDate", searchTerms.getToDate());
				trongHanURL.setParameter("redirect", baoCaoHoSoThangSearch.getIteratorURL().toString());
				// da tre han URL
				PortletURL daTreHanURL = renderResponse.createRenderURL();
				daTreHanURL.setParameter("struts_action","/nss/onedoorreport_baocaohosothang/filedetails");
				daTreHanURL.setParameter("columeName", "datrehan");
				daTreHanURL.setParameter("fileTypeId",baoCaoHoSoThangDTO.getFileTypeId());
				daTreHanURL.setParameter("fromDate", searchTerms.getFromDate());
				daTreHanURL.setParameter("toDate", searchTerms.getToDate());
				daTreHanURL.setParameter("redirect", baoCaoHoSoThangSearch.getIteratorURL().toString());
				// chinh sua bo sung URL
				PortletURL chinhSuaBoSungURL = renderResponse.createRenderURL();
				chinhSuaBoSungURL.setParameter("struts_action","/nss/onedoorreport_baocaohosothang/filedetails");
				chinhSuaBoSungURL.setParameter("columeName", "chinhsuabosung");
				chinhSuaBoSungURL.setParameter("fileTypeId",baoCaoHoSoThangDTO.getFileTypeId());
				chinhSuaBoSungURL.setParameter("fromDate", searchTerms.getFromDate());
				chinhSuaBoSungURL.setParameter("toDate", searchTerms.getToDate());
				chinhSuaBoSungURL.setParameter("redirect", baoCaoHoSoThangSearch.getIteratorURL().toString());
				// STT
				row1.addText(String.valueOf(i+1));
				
				// ten san pham
				if(baoCaoHoSoThangDTO.isHasFile() == true && baoCaoHoSoThangDTO.getHoSoNhanTrongThang() > 0) { 
					row1.addText(baoCaoHoSoThangDTO.getTenSanPham(), tenSanPhamURL.toString());
				} else { 
					row1.addText(baoCaoHoSoThangDTO.getTenSanPham());
				}
				
				// ton dau ky
				if(baoCaoHoSoThangDTO.getTonDauKy() > 0) { 
					row1.addText(String.valueOf(baoCaoHoSoThangDTO.getTonDauKy()), tonDauKyURL.toString() );
				} else { 
					row1.addText(String.valueOf(baoCaoHoSoThangDTO.getTonDauKy()));
				}
				
				// ho so nhan trong thang
				if(baoCaoHoSoThangDTO.getHoSoNhanTrongThang() > 0) { 
					row1.addText(String.valueOf(baoCaoHoSoThangDTO.getHoSoNhanTrongThang()), nhanTrongThangURL.toString() );
				} else { 
					row1.addText(String.valueOf(baoCaoHoSoThangDTO.getHoSoNhanTrongThang()));
				}
				
				// tong cong
				if(baoCaoHoSoThangDTO.getTongCong() > 0) { 
					row1.addText(String.valueOf(baoCaoHoSoThangDTO.getTongCong()), tongCongURL.toString() );
				} else { 
					row1.addText(String.valueOf(baoCaoHoSoThangDTO.getTongCong()));
				}
				
				// so dung han
				if(baoCaoHoSoThangDTO.getSoDungHan() > 0) { 
					row1.addText(String.valueOf(baoCaoHoSoThangDTO.getSoDungHan()), soDungHanURL.toString() );
				} else { 
					row1.addText(String.valueOf(baoCaoHoSoThangDTO.getSoDungHan()));
				}
				
				// so tre han
				if(baoCaoHoSoThangDTO.getSoTreHan() > 0) { 
					row1.addText(String.valueOf(baoCaoHoSoThangDTO.getSoTreHan()), soTreHanURL.toString());
				} else { 
					row1.addText(String.valueOf(baoCaoHoSoThangDTO.getSoTreHan()));
				}
				
				// trong han
				if(baoCaoHoSoThangDTO.getTrongHan() > 0) { 
					row1.addText(String.valueOf(baoCaoHoSoThangDTO.getTrongHan()), trongHanURL.toString());
				} else { 
					row1.addText(String.valueOf(baoCaoHoSoThangDTO.getTrongHan()));
				}
				
				// da tre han
				if(baoCaoHoSoThangDTO.getDaTreHan() > 0) { 
					row1.addText(String.valueOf(baoCaoHoSoThangDTO.getDaTreHan()), daTreHanURL.toString());
				} else { 
					row1.addText(String.valueOf(baoCaoHoSoThangDTO.getDaTreHan()));
				}
				
				// chinh sua bo sung
				if(baoCaoHoSoThangDTO.getChinhSuaBoSung() > 0) { 
					row1.addText(String.valueOf(baoCaoHoSoThangDTO.getChinhSuaBoSung()), chinhSuaBoSungURL.toString());
				} else { 
					row1.addText(String.valueOf(baoCaoHoSoThangDTO.getChinhSuaBoSung()));
				}
				
				// ty le ho so dung han
				row1.addText(String.valueOf(baoCaoHoSoThangDTO.getTyLeHoSoDungHan()));
				
				resultRows1.add(row1);
			
			}
		}
		//add gia tri tong cong
		if ( baoCaoHoSoThangSearch.getResultEnd() == total1) {
			row1 = new ResultRow( new PmlFileTypeImpl(), fileTypeId, 0);
			
			row1.addText("");
			row1.addText(LanguageUtil.get(pageContext,"onedoorpcccreport-tongcong"));
			row1.addText(String.valueOf(tongCongDTO.getTonDauKy()));
			row1.addText(String.valueOf(tongCongDTO.getHoSoNhanTrongThang()));
			row1.addText(String.valueOf(tongCongDTO.getTongCong()));
			row1.addText(String.valueOf(tongCongDTO.getSoDungHan()));
			row1.addText(String.valueOf(tongCongDTO.getSoTreHan()));
			row1.addText(String.valueOf(tongCongDTO.getTrongHan()));
			row1.addText(String.valueOf(tongCongDTO.getDaTreHan()));
			row1.addText(String.valueOf(tongCongDTO.getChinhSuaBoSung()));
			row1.addText(String.valueOf(tongCongDTO.getTyLeHoSoDungHan()));
			
			resultRows1.add(row1);
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
			<div class="taglib-search-iterator-page-iterator-top">	
					<liferay-ui:search-paginator searchContainer="<%= searchContainer %>" />
			</div>
		</c:if>
	<div class="results-grid">
			<table class="taglib-search-iterator" cellspacing="0" width="100%">
				<tr class="portlet-section-header results-header">
					<td rowspan="3" width="3%" align="center"><liferay-ui:message key="STT" /></b></td>
					<td rowspan="3"><liferay-ui:message key="onedoorpcccreport-tensanpham" /></td>
					<td colspan="8" align="center"><liferay-ui:message key="onedoorpcccreport-noidungthongke" /></td>
					<td rowspan="3" width="7%" align="center"><liferay-ui:message key="onedoorpcccreport-tylehosodunghan" /></td>
				</tr>
				<tr class="portlet-section-header results-header">
					<td rowspan="2" width="5%" align="center"><liferay-ui:message key="onedoorpcccreport-tondauky" /></td>
					<td rowspan="2" width="5%" align="center"><liferay-ui:message key="onedoorpcccreport-hosonhantrongthang" /></td>
					<td rowspan="2" width="5%" align="center"><liferay-ui:message key="onedoorpcccreport-tongcong" /></td>
					<td colspan="2" align="center"><liferay-ui:message key="onedoorpcccreport-soluonghosohoanthanh" /></td>
					<td colspan="3" align="center"><liferay-ui:message key="onedoorpcccreport-soluonghosodangthuly" /></td>
				</tr>
				<tr class="portlet-section-header results-header">
					<td width="5%" align="center"><liferay-ui:message key="onedoorpcccreport-sodunghan" /></td>
					<td width="5%" align="center"><liferay-ui:message key="onedoorpcccreport-sotrehan" /></td>
					<td width="5%" align="center"><liferay-ui:message key="onedoorpcccreport-tronghan" /></td>
					<td width="5%" align="center"><liferay-ui:message key="onedoorpcccreport-datrehan" /></td>
					<td width="5%" align="center"><liferay-ui:message key="onedoorpcccreport-chinhsuabosung" /></td>
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
	
					<td align="<%= entry.getAlign() %>" class="col-<%= j + 1 %><%= row.isBold() ? " taglib-search-iterator-highlighted" : "" %>" colspan="<%= entry.getColspan() %>" valign="<%= entry.getValign() %>">
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