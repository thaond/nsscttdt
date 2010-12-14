<%@ include file="/html/portlet/nss/thu_tuc_hanh_chinh/init.jsp" %>

<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.util.List"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>

<%@page import="com.nss.portlet.linh_vuc_thu_tuc.model.LinhVucThuTucHanhChinh"%>
<%@page import="com.nss.portlet.nss_don_vi_thu_tuc.model.DonViThuTuc"%>
<%@page import="com.nss.portlet.thu_tuc_hanh_chinh.model.ThuTucHanhChinh"%>
<%@page import="com.nss.portlet.thu_tuc_hanh_chinh.model.FileDinhKemTTHC"%>
<%@page import="com.nss.portlet.linh_vuc_thu_tuc.service.LinhVucThuTucHanhChinhLocalServiceUtil"%>
<%@page import="com.nss.portlet.nss_don_vi_thu_tuc.service.DonViThuTucLocalServiceUtil"%>
<%@page import="com.nss.portlet.thu_tuc_hanh_chinh.searchFileTTHC.FileDinhKemTTHCSearch"%>
<%@page import="com.nss.portlet.thu_tuc_hanh_chinh.searchFileTTHC.FileDinhKemTTHCSearchTerms"%>
<%@page import="com.nss.portlet.thu_tuc_hanh_chinh.service.FileDinhKemTTHCLocalServiceUtil"%>

<%
	String redirect = renderRequest.getParameter("redirect");
	ThuTucHanhChinh thuTucHanhChinh = (ThuTucHanhChinh)renderRequest.getAttribute("thuTucHanhChinh");
	LinhVucThuTucHanhChinh linhVucThuTucHanhChinh = null;
	DonViThuTuc donViThuTuc = null;
	if (null != thuTucHanhChinh) {
		try {
			linhVucThuTucHanhChinh = LinhVucThuTucHanhChinhLocalServiceUtil.getLinhVucThuTucHanhChinh(thuTucHanhChinh.getMaLinhVucThuTucHanhChinh());
			donViThuTuc = DonViThuTucLocalServiceUtil.getDonViThuTuc(thuTucHanhChinh.getMaDonViThuTucHanhChinh());
		} catch (Exception e) {}
		
	}
	PortletURL portletURL = renderResponse.createActionURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action", "/nss/thu_tuc_hanh_chinh/view" );
	portletURL.setParameter("redirect", redirect);
%>

<form action="<%= portletURL.toString() %>"  enctype="multipart/form-data" method="post" name="<portlet:namespace />fm" >
<div class="parent-title">	<liferay-ui:message key="thu-tuc-hanh-chinh" /></div>
	<table width="100%" cellspacing="0">
		<tr>
			<td width="20%">
				<label><liferay-ui:message key="ten-thu-tuc-hanh-chinh" /></label>:
			</td>
			<td><%= thuTucHanhChinh.getTenThuTucHanhChinh() %></td>
		</tr>
		<tr>
			<td>
				<label><liferay-ui:message key="dia-chi-lien-he" /></label>:
			</td>
			<td><%= thuTucHanhChinh.getDiaChiLienHe() %></td>
		</tr>
		
		<tr>
			<td>
				<label><liferay-ui:message key="linh-vuc" /></label>:
			</td>
		    <td>
		    <%= linhVucThuTucHanhChinh.getTenLinhVucThuTucHanhChinh()%>
		    </td>
		</tr>
		<tr>
			<td>
				<label><liferay-ui:message key="co-quan-thuc-hien" /></label>:
			</td>
		    <td >
		    <%= donViThuTuc.getTenDonViThuTuc()%>
		    </td>
		</tr>
	</table>
	<br/>
	<fieldset class="filborder">
	<label class="laborder"><liferay-ui:message key="van-ban-di-kem"/></label>
	<%
		FileDinhKemTTHCSearch fileDinhKemTTHCSearch = new FileDinhKemTTHCSearch(renderRequest, portletURL);
		
		List<FileDinhKemTTHC> results = null;
		int total = 0;
		
		results = FileDinhKemTTHCLocalServiceUtil.search(thuTucHanhChinh.getMaThuTucHanhChinh(), fileDinhKemTTHCSearch.getStart(), fileDinhKemTTHCSearch.getEnd());
		total = FileDinhKemTTHCLocalServiceUtil.searchCount(thuTucHanhChinh.getMaThuTucHanhChinh());
		
		fileDinhKemTTHCSearch.setResults(results);
		fileDinhKemTTHCSearch.setTotal(total);
		
		portletURL.setParameter(fileDinhKemTTHCSearch.getCurParam(), String.valueOf(fileDinhKemTTHCSearch.getCurValue()));
		List resultRow = fileDinhKemTTHCSearch.getResultRows();
		ResultRow row = null;
		FileDinhKemTTHC fileDinhKemTTHC = null;
		
		for (int i=0; i < results.size(); i++) {
			fileDinhKemTTHC = results.get(i);
			
			row = new ResultRow(fileDinhKemTTHC, fileDinhKemTTHC.getMaFileDinhKemTTHC(), i);
			
			// STT
			row.addText(String.valueOf(i+1));
			
			// ten
			String fileDownLoad = "";
			fileDownLoad = "<a href='" + fileDinhKemTTHC.getDuongDan()+ "'>"+ fileDinhKemTTHC.getTenFile() + "</a>";
			row.addText(fileDownLoad);
			
			// mo ta
			row.addText(fileDinhKemTTHC.getMoTa());
			
			// kich thuoc
			row.addText(fileDinhKemTTHC.getKichThuoc() + " kb");
			resultRow.add(row);
		}
	%>
	<liferay-ui:search-iterator searchContainer="<%= fileDinhKemTTHCSearch %>" />
	</fieldset>
	<span onclick="javascript:submitForm(document.hrefFm,'<%= redirect %>');">
		<input class="button-width" type="button" value='<liferay-ui:message key="back"/>' />
	</span>
</form>
	