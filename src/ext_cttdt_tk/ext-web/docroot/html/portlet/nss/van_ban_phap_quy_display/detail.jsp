<%@ include file="/html/portlet/nss/van_ban_phap_quy_display/init.jsp" %>

<%@page import="java.util.List"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.io.File"%>

<%@page import="com.nss.portlet.van_ban_phap_quy.model.FileDinhKem"%>
<%@page import="com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy"%>
<%@page import="com.nss.portlet.van_ban_phap_quy_display.searchfiledinhkem.FileDinhKemSearch"%>
<%@page import="com.nss.portlet.van_ban_phap_quy.service.FileDinhKemLocalServiceUtil"%>
<%@page import="com.nss.portlet.co_quan_ban_hanh.model.CoQuanBanHanh"%>
<%@page import="com.nss.portlet.co_quan_ban_hanh.service.CoQuanBanHanhLocalServiceUtil"%>

<%
	SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	String redirect = renderRequest.getParameter("redirect");
	VanBanPhapQuy vanBanPhapQuy = (VanBanPhapQuy) renderRequest.getAttribute("vanBanPhapQuy");
	CoQuanBanHanh coQuanBanHanh = null;
	String tenCoQuanBanHanh = "";
	if (null != vanBanPhapQuy) {
		try {
			coQuanBanHanh = CoQuanBanHanhLocalServiceUtil.getCoQuanBanHanh(vanBanPhapQuy.getMaCoQuanBanHanh());
			tenCoQuanBanHanh = coQuanBanHanh.getTenCoQuanBanHanh();
		} catch (Exception e) {}
	}
	PortletURL portletURL = renderResponse.createActionURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action", "/nss/van_ban_phap_quy_display/view" );
	portletURL.setParameter("redirect", redirect);

%>

<form action="<%= portletURL.toString() %>"  enctype="multipart/form-data" method="post" name="<portlet:namespace />fm" >
	<div class="commom-form">
	<div class="parent-title"><liferay-ui:message key="van-ban-phap-quy"/></div>
	<table width="100%" border="0" class="common-table">
		
		<tr>
			<td>
			<label><liferay-ui:message key="ky-hieu-van-ban" /></label>
			</td>
			<td><%= vanBanPhapQuy.getKyHieuVanBan() %></td>
			<td>&nbsp;</td>
			
			<td>
			<label><liferay-ui:message key="nguoi-ky" /></label>
			</td>
			<td><%= vanBanPhapQuy.getNguoiKy() %></td>
			<td>&nbsp;</td>
		</tr>
		
		
		<tr>
			<td>
			<label><liferay-ui:message key="ngay-ky" /></label>
			</td>
			<td><%= vanBanPhapQuy.getNgayKy() == null ? "" : df.format(vanBanPhapQuy.getNgayKy()) %></td>
			<td>&nbsp;</td>
			
			<td>
			<label><liferay-ui:message key="ngay-ban-hanh" /></label>
			</td>
			<td><%= vanBanPhapQuy.getNgayBanHanh() == null ? "" : df.format(vanBanPhapQuy.getNgayBanHanh()) %></td>
			<td>&nbsp;</td>
		</tr>
		
		
		<tr>
			<td>
			<label><liferay-ui:message key="ngay-co-hieu-luc" /></label>
			</td>
			<td><%= vanBanPhapQuy.getNgayCoHieuLuc() == null ? "" : df.format(vanBanPhapQuy.getNgayCoHieuLuc()) %></td>
			<td>&nbsp;</td>
			
			<td>
			<label><liferay-ui:message key="ngay-het-hieu-luc" /></label>
			</td>
			<td><%= vanBanPhapQuy.getNgayHetHieuLuc() == null ? "" : df.format(vanBanPhapQuy.getNgayHetHieuLuc()) %></td>
			<td>&nbsp;</td>
		</tr>
		

		<tr>
			<td>
			<label><liferay-ui:message key="nguon" /></label>
			</td>
			<td><%= vanBanPhapQuy.getNguon()%></td>
			<td>&nbsp;</td>
			
			<td>
			<label><liferay-ui:message key="co-quan-ban-hanh" /></label>
			</td>
			<td><%= tenCoQuanBanHanh %></td>
			<td>&nbsp;</td>
		</tr>
		

		<tr>
			<td>
			<label><liferay-ui:message key="noi-dung" /></label>
			</td>
			<td><%= vanBanPhapQuy.getNoiDung()%></td>
			<td>&nbsp;</td>
		</tr>
		
	</table>
	<br/>
	<div id="div-head-title"><liferay-ui:message key="van-ban-di-kem"/></div>
	<%
		FileDinhKemSearch fileDinhKemSearch = new FileDinhKemSearch(renderRequest, portletURL);
		
		List<FileDinhKem> results = FileDinhKemLocalServiceUtil.findFileDinhKem(vanBanPhapQuy.getMaVanBanPhapQuy(),
										fileDinhKemSearch.getStart(), fileDinhKemSearch.getEnd());
		int total = FileDinhKemLocalServiceUtil.countFileDinhKem(vanBanPhapQuy.getMaVanBanPhapQuy());
		fileDinhKemSearch.setResults(results);
		fileDinhKemSearch.setTotal(total);
		
		portletURL.setParameter(fileDinhKemSearch.getCurParam(), String.valueOf(fileDinhKemSearch.getCurValue()));
		
		List resultRow = fileDinhKemSearch.getResultRows();
		ResultRow row = null;
		FileDinhKem fileDinhKem = null;
		
		for (int i=0; i < results.size(); i++) {
			fileDinhKem = results.get(i);
			fileDinhKem = fileDinhKem.toEscapedModel();
			
			row = new ResultRow(fileDinhKem, fileDinhKem.getMaFileDinhKem(), i);
			
			// stt
			row.addText(String.valueOf(i + 1));
			
			// ten file
			String fileDownLoad = "";
			String patthFile = getServletContext().getRealPath("")+ fileDinhKem.getDuongDan();
			File file = new File(patthFile);
			if (file.exists()) {
				fileDownLoad = "<a href='" + fileDinhKem.getDuongDan()+ "'>"+ fileDinhKem.getTenFile() + "</a>";
			} else {
				fileDownLoad = fileDinhKem.getTenFile()+ "<img src='/html/images/fileDeleted.jpg' />";
			}
			row.addText(fileDownLoad);
			
			// mo ta
			row.addText(fileDinhKem.getMoTa());
			
			// kich thuoc
			String kichThuoc = String.valueOf(fileDinhKem.getKichThuoc())+ " kb";
			row.addText(kichThuoc);
			
			resultRow.add(row);
		}
	%>
	<liferay-ui:search-iterator searchContainer="<%= fileDinhKemSearch %>" />
	<span onclick="javascript:submitForm(document.hrefFm,'<%= redirect %>');">
		<input class="button-width" type="button"	value='<liferay-ui:message key="back"/>' />
	</span>
	</div>
</form>
