<%@ include file="/html/portlet/nss/linh_vuc_thu_tuc/init.jsp" %>

<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.util.List"%>

<%@page import="com.nss.portlet.linh_vuc_thu_tuc.search.LinhVucThuTucHanhChinhSearch"%>
<%@page import="com.nss.portlet.linh_vuc_thu_tuc.search.LinhVucThuTucHanhChinhSearchTerms"%>
<%@page import="com.nss.portlet.linh_vuc_thu_tuc.service.LinhVucThuTucHanhChinhLocalServiceUtil"%>
<%@page import="com.nss.portlet.linh_vuc_thu_tuc.model.LinhVucThuTucHanhChinh"%>

<%@page import="com.nss.portlet.loai_thu_tuc.model.LoaiThuTucHanhChinh"%>
<%@page import="com.nss.portlet.loai_thu_tuc.service.LoaiThuTucHanhChinhLocalServiceUtil"%>

<liferay-util:include page="/html/portlet/nss/linh_vuc_thu_tuc/js/linhvucthutuc-js.jsp"></liferay-util:include>

<%
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action", "/nss/linh_vuc_thu_tuc/view");

%>

<form action="<%= portletURL.toString() %>"  method="post" name="<portlet:namespace />fm" >
	<div class="commom-form">
	<div class="parent-title"><liferay-ui:message key="javax.portlet.title.NSS_LINH_VUC_THU_TUC" /></div>
	<%
		LinhVucThuTucHanhChinhSearch searchContainer = new LinhVucThuTucHanhChinhSearch(renderRequest, portletURL);
		LinhVucThuTucHanhChinhSearchTerms searchTerms = (LinhVucThuTucHanhChinhSearchTerms)searchContainer.getSearchTerms();
	%>
	
	<liferay-ui:search-form
		page="/html/portlet/nss/linh_vuc_thu_tuc/search_form.jsp"
		searchContainer="<%= searchContainer %>" />
	<div id="separator"></div>
	
	<%
		// URL add
		PortletURL addURL = renderResponse.createRenderURL();
		addURL.setWindowState(WindowState.NORMAL);
		addURL.setParameter("struts_action", "/nss/linh_vuc_thu_tuc/view");
		addURL.setParameter("tabs", "add");
		addURL.setParameter("redirect", searchContainer.getIteratorURL().toString());
	%>
	
	<br/>
	<a href="<%= addURL.toString() %>"><span><input class="button-width" type="button" value='<liferay-ui:message key="them-moi"/>' /></span></a>
	<br/>
	
	<%
		List<LinhVucThuTucHanhChinh> results = null;
		int total = 0;
		
		if (searchTerms.isAdvancedSearch()) {
			results = LinhVucThuTucHanhChinhLocalServiceUtil.findTEN_MOTA(searchTerms.getTenLinhVucThuTuc(), searchTerms.getMoTa(),
					searchTerms.isAndOperator(),searchContainer.getStart(), searchContainer.getEnd(), searchContainer.getOrderByComparator());
			
			total = LinhVucThuTucHanhChinhLocalServiceUtil.countByTEN_MOTA(searchTerms.getTenLinhVucThuTuc(), searchTerms.getMoTa(),
						searchTerms.isAndOperator());
		} else {
			results = LinhVucThuTucHanhChinhLocalServiceUtil.findByKeywords(searchTerms.getKeywords(),searchContainer.getStart(), searchContainer.getEnd(), 
						searchContainer.getOrderByComparator());
			total = LinhVucThuTucHanhChinhLocalServiceUtil.countByKeywords(searchTerms.getKeywords());
		}
		
		searchContainer.setResults(results);
		searchContainer.setTotal(total);
		
		portletURL.setParameter(searchContainer.getCurParam(), String.valueOf(searchContainer.getCurValue()));
	%>
	<%
	
		List resultRows = searchContainer.getResultRows();
		ResultRow row = null;
		LinhVucThuTucHanhChinh linhVucThuTuc = null;
		long maLinhVucThuTucHanhChinh = 0;
		String update = "";
		String deleteAction = "";
		String active = "";
		
		for ( int i=0; i < results.size(); i++) {
			linhVucThuTuc = results.get(i);
			maLinhVucThuTucHanhChinh = linhVucThuTuc.getMaLinhVucThuTucHanhChinh();
			
			linhVucThuTuc = linhVucThuTuc.toEscapedModel();
			row = new ResultRow(linhVucThuTuc, maLinhVucThuTucHanhChinh, i);
			
			// STT
			row.addText(String.valueOf(i + 1));
			
			// ten linh vuc thu tuc
			row.addText(linhVucThuTuc.getTenLinhVucThuTucHanhChinh());
			
			// loai thu tuc
			LoaiThuTucHanhChinh loaiThuTucHanhChinh = null;
			String loaiThuTucHanhChinhName = "";
			long maLoaiThuTucHanhChinh = linhVucThuTuc.getMaLoaiThuTucHanhChinh();
			try {
				loaiThuTucHanhChinh = LoaiThuTucHanhChinhLocalServiceUtil.getLoaiThuTucHanhChinh(maLoaiThuTucHanhChinh);
				loaiThuTucHanhChinhName = loaiThuTucHanhChinh.getTenLoaiThuTucHanhChinh();
			} catch (Exception e) { }
			row.addText(loaiThuTucHanhChinhName);
			
			// mo ta
			row.addText(linhVucThuTuc.getDescription());
			
			//active 
			//URL active
			PortletURL rowURLActive= renderResponse.createActionURL();
			rowURLActive.setWindowState(WindowState.NORMAL);
			rowURLActive.setParameter("struts_action", "/nss/linh_vuc_thu_tuc/view");
			rowURLActive.setParameter(Constants.CMD, Constants.LOCK);
			rowURLActive.setParameter("maLinhVucThuTucHanhChinh", String.valueOf(maLinhVucThuTucHanhChinh));
			rowURLActive.setParameter("redirect", searchContainer.getIteratorURL().toString());
			
			if (1 == linhVucThuTuc.getActive()) {
				active = "<a href='"+ rowURLActive.toString()+"'><img src='/html/images/checked.gif' />&nbsp;</a>";
			} else if (0 == linhVucThuTuc.getActive()){
				active = "<a href='"+ rowURLActive.toString()+"'><img src='/html/images/unchecked.gif' />&nbsp;</a>";
			}
			row.addText(active);
			
			// edit
			//URL update
			PortletURL rowURLEdit = renderResponse.createActionURL();
			rowURLEdit.setWindowState(WindowState.NORMAL);
			rowURLEdit.setParameter(Constants.CMD, Constants.EDIT);
			rowURLEdit.setParameter("struts_action", "/nss/linh_vuc_thu_tuc/view");
			rowURLEdit.setParameter("maLinhVucThuTucHanhChinh", String.valueOf(maLinhVucThuTucHanhChinh));
			rowURLEdit.setParameter("redirect", searchContainer.getIteratorURL().toString());
			rowURLEdit.setParameter("tabs", "edit");
			
			update = "<a href='"+ rowURLEdit.toString()+"'><img src='/html/images/edit.png' />&nbsp;</a>";
			
			row.addText(update);
			
			// delete
			//URL delete
			PortletURL rowURLDelete = renderResponse.createActionURL();
			rowURLDelete.setWindowState(WindowState.NORMAL);
			rowURLDelete.setParameter("struts_action", "/nss/linh_vuc_thu_tuc/view");
			rowURLDelete.setParameter(Constants.CMD, Constants.DELETE);
			rowURLDelete.setParameter("maLinhVucThuTucHanhChinh", String.valueOf(maLinhVucThuTucHanhChinh));
			
			deleteAction = "<a href='javascript: ;' onclick=deleteLinhVucThuTucHanhChinh('"+ rowURLDelete.toString() +"')><u>"+ "<img src='/html/images/delete.png'/>" +"</u></a>";
			
			row.addText(deleteAction);
			
			resultRows.add(row);
		}
		
	%>
	<liferay-ui:search-iterator searchContainer="<%=searchContainer %>" />
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

