<%@ include file="/html/portlet/nss/van_ban_phap_quy_display/init.jsp" %>

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
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="java.io.File"%>

<%@page import="com.nss.portlet.van_ban_phap_quy_display.search.VanBanPhapQuySearch"%>
<%@page import="com.nss.portlet.van_ban_phap_quy_display.search.VanBanPhapQuyDisplayTerms"%>
<%@page import="com.nss.portlet.van_ban_phap_quy.service.VanBanPhapQuyLocalServiceUtil"%>
<%@page import="com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy"%>
<%@page import="com.nss.portlet.van_ban_phap_quy.model.FileDinhKem"%>
<%@page import="com.nss.portlet.van_ban_phap_quy.service.FileDinhKemLocalServiceUtil"%>
<%@page import="com.nss.portlet.loai_van_ban.model.LoaiVanBan"%>
<%@page import="com.nss.portlet.linh_vuc_van_ban.model.LinhVucVanBan"%>
<%@page import="com.nss.portlet.co_quan_ban_hanh.model.CoQuanBanHanh"%>

<%
	List<CoQuanBanHanh> coQuanBanHanhList = (List<CoQuanBanHanh>)renderRequest.getAttribute("coQuanBanHanhList") == null ? new ArrayList<CoQuanBanHanh>() : (List<CoQuanBanHanh>)renderRequest.getAttribute("coQuanBanHanhList");
	List<LoaiVanBan> loaiVBList = (List<LoaiVanBan>)renderRequest.getAttribute("loaiVBList") == null ? new ArrayList<LoaiVanBan>() : (List<LoaiVanBan>)renderRequest.getAttribute("loaiVBList");
	List<LinhVucVanBan> linhVucVBList = (List<LinhVucVanBan>)renderRequest.getAttribute("linhVucVBList") == null ? new ArrayList<LinhVucVanBan>() : (List<LinhVucVanBan>)renderRequest.getAttribute("linhVucVBList");
	PortletURL portletURLDisplay = renderResponse.createRenderURL();
	portletURLDisplay.setWindowState(WindowState.NORMAL);
	portletURLDisplay.setParameter("struts_action", "/nss/van_ban_phap_quy_display/view");
	String portletURLDisplayString = portletURLDisplay.toString();
	renderRequest.setAttribute("portletURLDisplayString", portletURLDisplayString);
%>
<div id="main">
    <div id="leftmenu">
    <div id="topmnl">
    <div id="vbpq" class="menuolder">
	    <ul>
	    	<h2><liferay-ui:message key="co-quan-ban-hanh" /></h2>
	    	<%
	    		for (int i = 0; i < coQuanBanHanhList.size(); i ++) {
	    			CoQuanBanHanh coQuanBanHanh = (CoQuanBanHanh) coQuanBanHanhList.get(i);
	    	%>
		        <li><a href="<%= portletURLDisplayString + "&" + renderResponse.getNamespace() + VanBanPhapQuyDisplayTerms.MA_CO_QUAN_BAN_HANH + "=" + coQuanBanHanh.getMaCoQuanBanHanh() %>"><%= coQuanBanHanh.getTenCoQuanBanHanh() %></a></li>
	        <%
	    		}
	        %>
	    </ul>
	    <ul>
	    	<h2><liferay-ui:message key="loai-van-ban" /></h2>
	    	<%
		    	for (int i = 0; i < loaiVBList.size(); i ++) {
					LoaiVanBan loaiVB = (LoaiVanBan) loaiVBList.get(i);
	    	%>
		        <li><a href="<%= portletURLDisplayString + "&" + renderResponse.getNamespace() + VanBanPhapQuyDisplayTerms.MA_LOAI_VAN_BAN + "=" + loaiVB.getMaLoaiVanBan() %>"><%= loaiVB.getTenLoaiVanBan() %></a></li>
	        <%
	    		}
	        %>
	    </ul>
	    <ul>
	    	<h2><liferay-ui:message key="linh-vuc-van-ban" /></h2>
		    <%
			    for (int i = 0; i < linhVucVBList.size(); i ++) {
					LinhVucVanBan linhVucVB = (LinhVucVanBan) linhVucVBList.get(i);
		    %>
		        <li><a href="<%= portletURLDisplayString + "&" + renderResponse.getNamespace() + VanBanPhapQuyDisplayTerms.MA_LINH_VUC_VAN_BAN + "=" + linhVucVB.getMaLinhVucVanBan() %>"><%= linhVucVB.getTenLinhVucVanBan() %></a></li>
	        <%
	    		}
	        %>
	    </ul>
       </div>
    </div>
    </div>
    
    <div id="centermain-vbpq">
	    <form action="<%= portletURLDisplay.toString() %>"  method="post" name="<portlet:namespace />fm">
    	<div class="commom-form">
    		<div class="parent-title"><liferay-ui:message key="nss-van-ban-phap-quy" /></div>
	    	<%
				VanBanPhapQuySearch vanBanPhapQuySearchDisplay = new VanBanPhapQuySearch(renderRequest, portletURLDisplay);
	    		VanBanPhapQuyDisplayTerms displayTermsDisplay = (VanBanPhapQuyDisplayTerms)vanBanPhapQuySearchDisplay.getDisplayTerms();
	    		
	    		String orderByCol = ParamUtil.getString(renderRequest, "orderByCol", VanBanPhapQuyDisplayTerms.KY_HIEU_VAN_BAN);
	    		int sortType = Sort.STRING_TYPE;
	    		String orderByType = vanBanPhapQuySearchDisplay.getOrderByType().toLowerCase();
	    		boolean reverse = false;
	    		if (orderByType.equals("desc")) {
	    			reverse = true;
	    		}
	    		
			%>
		
			<liferay-ui:search-form
				page="/html/portlet/nss/van_ban_phap_quy_display/search_form.jsp"
				searchContainer="<%= vanBanPhapQuySearchDisplay %>" />
				
			<%
			
				DateFormat df1 = new SimpleDateFormat("dd/MM/yyyy");
				DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd");
				String tuNgay = "";
				String denNgay = "";
				Date fromDate = new Date();
				if (!"".equals(displayTermsDisplay.getTuNgay())) {
					fromDate = df1.parse(displayTermsDisplay.getTuNgay());
					tuNgay = df2.format(fromDate);
					
				}
				
				Date toDate = new Date();
				if (!"".equals(displayTermsDisplay.getDenNgay())) {
					toDate = df1.parse(displayTermsDisplay.getDenNgay());
					denNgay = df2.format(toDate);
				}
				
				try {
					Hits hits = null;
					
					if (!displayTermsDisplay.isAdvancedSearch()) {
						if ("".equals(displayTermsDisplay.getKeywords())) {
							hits = VanBanPhapQuyLocalServiceUtil.searchDisplay(user.getCompanyId(), 
									displayTermsDisplay.getMaLoaiVanBan(), 
									displayTermsDisplay.getMaLinhVucVanBan(), 
									displayTermsDisplay.getMaCoQuanBanHanh(),
									orderByCol, sortType, reverse, vanBanPhapQuySearchDisplay.getStart(), vanBanPhapQuySearchDisplay.getEnd());
								
						} else {
							hits = VanBanPhapQuyLocalServiceUtil.search(user.getCompanyId(), displayTermsDisplay.getKeywords(),
										orderByCol, sortType, reverse, vanBanPhapQuySearchDisplay.getStart(), vanBanPhapQuySearchDisplay.getEnd());
						}
					}
					else {
						if ("".equals(displayTermsDisplay.getKyHieuVanBan()) && "".equals(displayTermsDisplay.getTomTat()) && "".equals(displayTermsDisplay.getTomTat())) {
							hits = VanBanPhapQuyLocalServiceUtil.searchDisplay(user.getCompanyId(), 
									displayTermsDisplay.getMaLoaiVanBan(), 
									displayTermsDisplay.getMaLinhVucVanBan(), 
									displayTermsDisplay.getMaCoQuanBanHanh(),
									orderByCol, sortType, reverse, vanBanPhapQuySearchDisplay.getStart(), vanBanPhapQuySearchDisplay.getEnd());
							
						} else {
							hits = VanBanPhapQuyLocalServiceUtil.search(user.getCompanyId(), 
									displayTermsDisplay.getKyHieuVanBan().trim().length() == 0 ? "" : (displayTermsDisplay.getKyHieuVanBan() + "*"),
											displayTermsDisplay.getTomTat().trim().length() == 0 ? "" : (displayTermsDisplay.getTomTat() + "*"),
											displayTermsDisplay.getNguoiKy().trim().length() == 0 ? "" : (displayTermsDisplay.getNguoiKy() + "*"),
											displayTermsDisplay.getMaLoaiVanBan(), 
											displayTermsDisplay.getMaLinhVucVanBan(), 
											displayTermsDisplay.getMaCoQuanBanHanh(),
											fromDate, toDate, orderByCol, sortType, reverse, vanBanPhapQuySearchDisplay.getStart(), vanBanPhapQuySearchDisplay.getEnd());
						}
					}
					int total = 0;
					total = hits.getLength();
					vanBanPhapQuySearchDisplay.setTotal(total);
					portletURLDisplay.setParameter(vanBanPhapQuySearchDisplay.getCurParam(), String.valueOf(vanBanPhapQuySearchDisplay.getCurValue()));
				
					List resultRows = vanBanPhapQuySearchDisplay.getResultRows();
				
					ResultRow row = null;	
					VanBanPhapQuy vanBanPhapQuy = null;
					
					int maVanBanPhapQuy = 0;
					SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
					String ngayBanhanh = "";
					List<FileDinhKem> fileDinhKemList = new ArrayList<FileDinhKem>();
					FileDinhKem fileDinhKem = null;
					String update = "";
					String deleteAction = "";
					String active = "";
					
					for (int i = 0; i < hits.getDocs().length; i ++) {
						maVanBanPhapQuy = GetterUtil.getInteger(hits.doc(i).get(Field.ENTRY_CLASS_PK));
						vanBanPhapQuy  = VanBanPhapQuyLocalServiceUtil.getVanBanPhapQuy(maVanBanPhapQuy);
						vanBanPhapQuy = vanBanPhapQuy.toEscapedModel();
							
						row = new ResultRow(vanBanPhapQuy, vanBanPhapQuy.getMaVanBanPhapQuy(), i);
						
						// STT
						row.addText(String.valueOf(i + 1));
						
						// ky hieu van ban
						//URL detail
						PortletURL rowURLDetail= renderResponse.createActionURL();
						rowURLDetail.setWindowState(WindowState.NORMAL);
						rowURLDetail.setParameter("struts_action","/nss/van_ban_phap_quy_display/view");
						rowURLDetail.setParameter(Constants.CMD,"DETAIL");
						rowURLDetail.setParameter("maVanBanPhapQuy", String.valueOf(maVanBanPhapQuy));
						rowURLDetail.setParameter("redirect", vanBanPhapQuySearchDisplay.getIteratorURL().toString());
						rowURLDetail.setParameter("tabs", "detail");
						
						row.addText(vanBanPhapQuy.getKyHieuVanBan(), rowURLDetail.toString());
						
						// ngay ban hanh
						Date date = vanBanPhapQuy.getNgayBanHanh();
						if (date != null) {
							ngayBanhanh = simpleDateFormat.format(date);
						}
						row.addText(ngayBanhanh);
						
						// mo ta 
						row.addText(vanBanPhapQuy.getTomTat(), rowURLDetail.toString());
						
						// download	
						fileDinhKemList = FileDinhKemLocalServiceUtil.getListFileDinhKemByMaVanBanPhapQuy(vanBanPhapQuy.getMaVanBanPhapQuy());
						String download = "";
						String fileDinhKemPath = ""; 
						if (fileDinhKemList.size() > 0) {
							if (fileDinhKemList.size() == 1) {
								fileDinhKem = fileDinhKemList.get(0);
								fileDinhKemPath = fileDinhKem.getDuongDan();
								String patthFile = getServletContext().getRealPath("")+ fileDinhKemPath;
								File file = new File(patthFile);
								if (file.exists()) {
									download = "<a href='" + fileDinhKemPath+ "'>" + "<img src='/html/images/icon_download.png' title='" + LanguageUtil.get(pageContext, "van-ban-di-kem") + "'></a>";
								} else {
									download = "";
								}
							} else {
								download = "<img src='/html/images/fulldownload.png' title='" + LanguageUtil.get(pageContext, "van-ban-di-kem") + "'>";
							}
						} else {
							download = "";
						}
						row.addText(download);			
						 
						resultRows.add(row);
					}	
				} catch (Exception e) {}
				
			%>
		
		<liferay-ui:search-iterator searchContainer="<%= vanBanPhapQuySearchDisplay %>" />
			
	    </div>
	    </form>
    </div>
    	
 </div>
