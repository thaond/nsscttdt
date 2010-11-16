<%@ include file="/html/portlet/nss/thu_tuc_hanh_chinh/init.jsp" %>

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

<%@page import="com.nss.portlet.thu_tuc_hanh_chinh.search.ThuTucHanhChinhSearch"%>
<%@page import="com.nss.portlet.thu_tuc_hanh_chinh.search.ThuTucHanhChinhSearchTerms"%>
<%@page import="com.nss.portlet.thu_tuc_hanh_chinh.model.ThuTucHanhChinh"%>
<%@page import="com.nss.portlet.thu_tuc_hanh_chinh.service.ThuTucHanhChinhLocalServiceUtil"%>
<%@page import="com.nss.portlet.nss_don_vi_thu_tuc.model.DonViThuTuc"%>
<%@page import="com.nss.portlet.nss_don_vi_thu_tuc.service.DonViThuTucLocalServiceUtil"%>
<%@page import="com.nss.portlet.thu_tuc_hanh_chinh.model.FileDinhKemTTHC"%>
<%@page import="com.nss.portlet.thu_tuc_hanh_chinh.service.FileDinhKemTTHCLocalServiceUtil"%>


<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%><liferay-util:include page="/html/portlet/nss/thu_tuc_hanh_chinh/js/thutuchanhchinh-js.jsp"></liferay-util:include>

	<%
		PortletURL portletURL = renderResponse.createRenderURL();
		portletURL.setWindowState(WindowState.NORMAL);
		portletURL.setParameter("struts_action", "/nss/thu_tuc_hanh_chinh/view");
	%> 
	<div id="separator"></div>
    <form action="<%= portletURL.toString() %>"  method="post" name="<portlet:namespace />fm" >
    	<%
	    	ThuTucHanhChinhSearch searchContainer = new ThuTucHanhChinhSearch(renderRequest, portletURL);
	    	ThuTucHanhChinhSearchTerms searchTerms = (ThuTucHanhChinhSearchTerms)searchContainer.getSearchTerms();
    		
		%>
		<div class="commom-form">
		<div class="parent-title"><liferay-ui:message key="thu-tuc-hanh-chinh" /></div>
			<liferay-ui:search-form
				page="/html/portlet/nss/thu_tuc_hanh_chinh/search_form.jsp"
				searchContainer="<%= searchContainer %>" />
			
			<div id="separator"></div>
			<%
				PortletURL addURL = renderResponse.createRenderURL();
				addURL.setWindowState(WindowState.NORMAL);
				addURL.setParameter("struts_action", "/nss/thu_tuc_hanh_chinh/view");
				addURL.setParameter("tabs", "add");
				addURL.setParameter("redirect", searchContainer.getIteratorURL().toString());
			
			%>
			<br/>
			<div style="padding-top: 5px;padding-bottom: 10px;">
				<a href="<%= addURL.toString() %>"><span><input class="button-width" type="button" value='<liferay-ui:message key="them-moi"/>' /></span></a>
			</div>
			<%
				List<ThuTucHanhChinh> results = null;
				int total = 0;
				
				results = ThuTucHanhChinhLocalServiceUtil.search(searchTerms.getTenThuTucHanhChinh(), searchTerms.getLinhVucThuTuc(), searchTerms.getCapDonViThuTuc(),
							searchTerms.getDonViThuTuc(), searchTerms.isAndOperator(), searchContainer.getStart(), searchContainer.getEnd(), searchContainer.getOrderByComparator());
				total = ThuTucHanhChinhLocalServiceUtil.searchCount(searchTerms.getTenThuTucHanhChinh(), searchTerms.getLinhVucThuTuc(), searchTerms.getCapDonViThuTuc(),
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
				String update = "";
				String deleteAction = "";
				String active = "";
				
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
					rowURLDetail.setParameter("struts_action","/nss/thu_tuc_hanh_chinh/view");
					rowURLDetail.setParameter(Constants.CMD,"DETAIL");
					rowURLDetail.setParameter("maThuTucHanhChinh", String.valueOf(maThuTucHanhChinh));
					rowURLDetail.setParameter("redirect", searchContainer.getIteratorURL().toString());
					rowURLDetail.setParameter("tabs", "detail");
					
					String tenThuTucHanhChinh = "";
					tenThuTucHanhChinh = thuTucHanhChinh.getTenThuTucHanhChinh();
					
					if (!"".equals(thuTucHanhChinh.getDiaChiLienHe())) {
						tenThuTucHanhChinh += " <br/> " + LanguageUtil.get(pageContext,"dia-chi-lien-he") + ": " +  thuTucHanhChinh.getDiaChiLienHe();
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
					
					//active 
					//URL active
					PortletURL rowURLActive= renderResponse.createActionURL();
					rowURLActive.setWindowState(WindowState.NORMAL);
					rowURLActive.setParameter("struts_action","/nss/thu_tuc_hanh_chinh/view");
					rowURLActive.setParameter(Constants.CMD,Constants.LOCK);
					rowURLActive.setParameter("maThuTucHanhChinh", String.valueOf(maThuTucHanhChinh));
					rowURLActive.setParameter("redirect", searchContainer.getIteratorURL().toString());
					
					if (1 == thuTucHanhChinh.getActive()) {
						active = "<a href='"+ rowURLActive.toString()+"'><img src='/html/images/checked.gif' />&nbsp;</a>";
					} else if (0 == thuTucHanhChinh.getActive()){
						active = "<a href='"+ rowURLActive.toString()+"'><img src='/html/images/unchecked.gif' />&nbsp;</a>";
					}
					row.addText(active);
					
					// edit
					//URL update
					PortletURL rowURLEdit = renderResponse.createActionURL();
					rowURLEdit.setWindowState(WindowState.NORMAL);
					rowURLEdit.setParameter(Constants.CMD,Constants.EDIT);
					rowURLEdit.setParameter("struts_action","/nss/thu_tuc_hanh_chinh/view");
					rowURLEdit.setParameter("maThuTucHanhChinh", String.valueOf(maThuTucHanhChinh));
					rowURLEdit.setParameter("redirect", searchContainer.getIteratorURL().toString());
					rowURLEdit.setParameter("tabs", "edit");
					
					update = "<a href='"+ rowURLEdit.toString()+"'><img src='/html/images/edit.png' />&nbsp;</a>";
					
					row.addText(update);
					
					// delete
					//URL delete
					PortletURL rowURLDelete = renderResponse.createActionURL();
					rowURLDelete.setWindowState(WindowState.NORMAL);
					rowURLDelete.setParameter("struts_action","/nss/thu_tuc_hanh_chinh/view");
					rowURLDelete.setParameter(Constants.CMD,Constants.DELETE);
					rowURLDelete.setParameter("maThuTucHanhChinh", String.valueOf(maThuTucHanhChinh));
					rowURLDelete.setParameter("redirect", searchContainer.getIteratorURL().toString());
					
					deleteAction = "<a  href='javascript: ;' onclick=deleteThuTucHanhChinh('"+ rowURLDelete.toString() +"')><u>"+ "<img src='/html/images/delete.png'/>" +"</u></a>";
					
					row.addText(deleteAction);
					
					resultRows.add(row);
				}
			%>
			
			
			<liferay-ui:search-iterator searchContainer="<%= searchContainer %>" />
		</div>
    </form>
    	
<% 
boolean delete = (Boolean)renderRequest.getAttribute("delete") == null ? true : (Boolean)renderRequest.getAttribute("delete");
if (!delete) {
%>
	<script type="text/javascript" >	
		alert("<liferay-ui:message key='khong-the-xoa-dong-nay-vi-co-rang-buoc'/>");
	</script>
<%	
}
%>