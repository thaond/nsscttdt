<%@ include file="/html/portlet/nss/thu_tuc_hanh_chinh_display/init.jsp" %>

<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="com.liferay.portal.kernel.search.Hits"%>
<%@page import="com.liferay.portal.kernel.search.Sort"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.liferay.portal.kernel.search.Field"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="java.util.ArrayList"%>

<%@page import="com.nss.portlet.thu_tuc_hanh_chinh.model.ThuTucHanhChinh"%>
<%@page import="com.nss.portlet.thu_tuc_hanh_chinh.service.ThuTucHanhChinhLocalServiceUtil"%>
<%@page import="com.nss.portlet.nss_don_vi_thu_tuc.model.DonViThuTuc"%>
<%@page import="com.nss.portlet.nss_don_vi_thu_tuc.service.DonViThuTucLocalServiceUtil"%>
<%@page import="com.nss.portlet.thu_tuc_hanh_chinh.model.FileDinhKemTTHC"%>
<%@page import="com.nss.portlet.thu_tuc_hanh_chinh.service.FileDinhKemTTHCLocalServiceUtil"%>
<%@page import="com.nss.portlet.thu_tuc_hanh_chinh_display.search.ThucTucHanhChinhDisplaySearch"%>
<%@page import="com.nss.portlet.thu_tuc_hanh_chinh_display.search.ThucTucHanhChinhDisplaySearchTerms"%>
<%@page import="com.nss.portlet.thu_tuc_hanh_chinh_display.search.ThucTucHanhChinhDisplayDisplayTerms"%>

<liferay-util:include page="/html/portlet/nss/thu_tuc_hanh_chinh/js/thutuchanhchinh-js.jsp"></liferay-util:include>

<style type="text/css">
.shownew-2 input[type="text"] {
	background-image: none !important;
	width: 220px;
	padding: 2px;
	border: 1px solid #dedede;
	font-size: 8.5pt;
}
.shownew-2 input[type="text"]:hover {
	border: 1px solid #14B9FB;
}
.shownew-2 input[type="text"]:focus {
	border: 1px solid #14B9FB;
}
.shownew-2 select {
	background-image: none !important;
	padding: 0;
	border: 1px solid #dedede;
	font-size: 8.5pt;
}
.shownew-2 select:hover {
	border: 1px solid #14B9FB;
}
.shownew-2 input[type="submit"] {
	padding: 3px 10px 3px 10px;
}



/*
.results-header {
	background: #fefefe url(/html/images/bg_title.jpg) left top repeat-x;
	border-bottom: 1px solid #dedede;
}

.ui-autocomplete-over, .results-row.hover td {
	background: #e5e5e5;
}
*/
</style>

<%
	List<DonViThuTuc> capThanhPhoList = (List<DonViThuTuc>)renderRequest.getAttribute("capThanhPhoList") == null ? new ArrayList<DonViThuTuc>() : (List<DonViThuTuc>)renderRequest.getAttribute("capThanhPhoList");
	List<DonViThuTuc> capQuanHuyenList = (List<DonViThuTuc>)renderRequest.getAttribute("capQuanHuyenList") == null ? new ArrayList<DonViThuTuc>() : (List<DonViThuTuc>)renderRequest.getAttribute("capQuanHuyenList");
	List<DonViThuTuc> capPhuongXaList = (List<DonViThuTuc>)renderRequest.getAttribute("capPhuongXaList") == null ? new ArrayList<DonViThuTuc>() : (List<DonViThuTuc>)renderRequest.getAttribute("capPhuongXaList");

	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action", "/nss/thu_tuc_hanh_chinh_display/view");
	
	String portletURLString = portletURL.toString();
	renderRequest.setAttribute("portletURLString", portletURLString);
%>
<div id="boxcontainer-vbpq">
<div id="bttomcontainer-vbpq">
<div id="container-vbpq">
  
	<div id="main">
    <div id="leftmenu">
    <div id="topmnl">
    <div id="vbpq">
    <ul>
    <h2><liferay-ui:message key="cap-thanh-pho" /></h2>
    	<%
    		for (int i = 0; i < capThanhPhoList.size(); i++) {
    			DonViThuTuc donViThanhPho = capThanhPhoList.get(i);
    			String urlThanhPho = portletURLString +
    				"&" + ThucTucHanhChinhDisplayDisplayTerms.CAP_DON_VI_THU_TUC + "=1" +
    				"&" + ThucTucHanhChinhDisplayDisplayTerms.DON_VI_THU_TUC + "=" + donViThanhPho.getMaDonViThuTuc();
    	%>
        	<li><a href="<%= urlThanhPho %>"><%= donViThanhPho.getTenDonViThuTuc() %></a></li>
        <%
    		}
        %>
    </ul>
    <ul>
    <h2><liferay-ui:message key="cap-quan-huyen" /></h2>
        <%
    		for (int i = 0; i < capQuanHuyenList.size(); i++) {
    			DonViThuTuc donViQuanHuyen = capQuanHuyenList.get(i);
    			String urlQuanHuyen = portletURLString +
	    			"&" + ThucTucHanhChinhDisplayDisplayTerms.CAP_DON_VI_THU_TUC + "=2" +
	    			"&" + ThucTucHanhChinhDisplayDisplayTerms.DON_VI_THU_TUC + "=" + donViQuanHuyen.getMaDonViThuTuc();
    	%>
        	<li><a href="<%= urlQuanHuyen %>"><%= donViQuanHuyen.getTenDonViThuTuc() %></a></li>
        <%
    		}
        %>
    </ul>
    <ul>
    <h2><liferay-ui:message key="cap-phuong-xa" /></h2>
        <%
    		for (int i = 0; i < capPhuongXaList.size(); i++) {
    			DonViThuTuc donViPhuongXa = capPhuongXaList.get(i);
    			String urlPhuongXa = portletURLString +
    				"&" + ThucTucHanhChinhDisplayDisplayTerms.CAP_DON_VI_THU_TUC + "=3" +
    				"&" + ThucTucHanhChinhDisplayDisplayTerms.DON_VI_THU_TUC + "=" + donViPhuongXa.getMaDonViThuTuc();
    	%>
        	<li><a href="<%= urlPhuongXa %>"><%= donViPhuongXa.getTenDonViThuTuc() %></a></li>
        <%
    		}
        %>
    </ul>
    <ul>
    </div>
    </div>
    </div>
    
    <div id="centermain-vbpq">
    		
	<div id="separator"></div>
    <form action="<%= portletURL.toString() %>"  method="post" name="<portlet:namespace />fm" >
    <div class="commom-form">
    	<%
	    	ThucTucHanhChinhDisplaySearch searchContainer = new ThucTucHanhChinhDisplaySearch(renderRequest, portletURL);
    		ThucTucHanhChinhDisplaySearchTerms searchTerms = (ThucTucHanhChinhDisplaySearchTerms)searchContainer.getSearchTerms();
    		
		%>
		
		<liferay-ui:search-form
			page="/html/portlet/nss/thu_tuc_hanh_chinh_display/search_form.jsp"
			searchContainer="<%= searchContainer %>" />
		
		<div id="separator"></div>
		
		<%
			List<ThuTucHanhChinh> results = null;
			int total = 0;
			
			results = ThuTucHanhChinhLocalServiceUtil.search(searchTerms.getTenThuTucHanhChinh(), searchTerms.getLinhVucThuTuc(),  searchTerms.getCapDonViThuTuc(),
						searchTerms.getDonViThuTuc(), searchTerms.isAndOperator(), searchContainer.getStart(), searchContainer.getEnd(), searchContainer.getOrderByComparator());
			total = ThuTucHanhChinhLocalServiceUtil.searchCount(searchTerms.getTenThuTucHanhChinh(), searchTerms.getLinhVucThuTuc(),  searchTerms.getCapDonViThuTuc(),
						searchTerms.getDonViThuTuc(), searchTerms.isAndOperator());
			
			searchContainer.setResults(results);
			searchContainer.setTotal(total);
			
			portletURL.setParameter(searchContainer.getCurParam(), String.valueOf(searchContainer.getCurValue()));
			List resultRows = searchContainer.getResultRows();
			
			ResultRow row = null;	
			ThuTucHanhChinh thuTucHanhChinh = null;
			DonViThuTuc donViThuTuc = null;
			long maThuTucHanhChinh = 0;
			List<FileDinhKemTTHC> fileDinhKemList = new ArrayList<FileDinhKemTTHC>();
			
			for (int i = 0; i < results.size(); i ++) {
				thuTucHanhChinh = results.get(i);
				maThuTucHanhChinh = thuTucHanhChinh.getMaThuTucHanhChinh();
				
				row = new ResultRow(thuTucHanhChinh, maThuTucHanhChinh, i);
				
				// STT
				row.addText(String.valueOf(i+1));
				
				// ten thu tuc hanh chinh
				//URL detail
				PortletURL rowURLDetail= renderResponse.createActionURL();
				rowURLDetail.setWindowState(WindowState.NORMAL);
				rowURLDetail.setParameter("struts_action","/nss/thu_tuc_hanh_chinh_display/view");
				rowURLDetail.setParameter(Constants.CMD,"DETAIL");
				rowURLDetail.setParameter("maThuTucHanhChinh", String.valueOf(maThuTucHanhChinh));
				rowURLDetail.setParameter("redirect", searchContainer.getIteratorURL().toString());
				rowURLDetail.setParameter("tabs", "detail");
				
				String tenThuTucHanhChinh = "";
				tenThuTucHanhChinh = thuTucHanhChinh.getTenThuTucHanhChinh();
				
				if (!"".equals(thuTucHanhChinh.getDiaChiLienHe())) {
					tenThuTucHanhChinh += " <br/> " + thuTucHanhChinh.getDiaChiLienHe();
				}
				row.addText(tenThuTucHanhChinh, rowURLDetail.toString());
				
				// don vi thuc hien
				String tenDonViThucHien = "";
				try {
					donViThuTuc = DonViThuTucLocalServiceUtil.getDonViThuTuc(thuTucHanhChinh.getMaDonViThuTucHanhChinh());
					tenDonViThucHien = donViThuTuc.getTenDonViThuTuc();
				} catch (Exception e){
					tenDonViThucHien = "";
				}
				row.addText(tenDonViThucHien);
				
				// download
				String download = "";
				
				fileDinhKemList = FileDinhKemTTHCLocalServiceUtil.findByMaThuTucHanhChinh(thuTucHanhChinh.getMaThuTucHanhChinh());
				String fileDinhKemPath = ""; 
				if (fileDinhKemList.size() > 0) {
					FileDinhKemTTHC fileDinhKem = null;
					if (fileDinhKemList.size() == 1) {
						fileDinhKem = fileDinhKemList.get(0);
						fileDinhKemPath = fileDinhKem.getDuongDan();
						download = "<a href='" + fileDinhKemPath+ "'>" + "<img src='/html/images/icon_download.png' title='" + fileDinhKem.getTenFile() + "'></a>";
					} else {
						download = "<img src='/html/images/fulldownload.png'>";
					}
				} else {
					download = "";
				}
				
				row.addText(download);	
				
				resultRows.add(row);
			}
		%>
		
		<liferay-ui:search-iterator searchContainer="<%= searchContainer %>" />
		</div>
    </form>
    </div>
    	
 </div>
</div>
</div>  
</div>

