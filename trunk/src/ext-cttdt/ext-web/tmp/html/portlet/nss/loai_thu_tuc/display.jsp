<%@ include file="/html/portlet/nss/loai_thu_tuc/init.jsp" %>

<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.util.List"%>



<%@page import="com.nss.portlet.loai_thu_tuc.search.LoaiThuTucHanhChinhSearch"%>
<%@page import="com.nss.portlet.loai_thu_tuc.search.LoaiThuTucHanhChinhSearchTerms"%>
<%@page import="com.nss.portlet.loai_thu_tuc.model.LoaiThuTucHanhChinh"%>
<%@page import="com.nss.portlet.loai_thu_tuc.service.LoaiThuTucHanhChinhLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%><liferay-util:include page="/html/portlet/nss/loai_thu_tuc/js/loaithutuchanhchinh-js.jsp"></liferay-util:include>

<%
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action", "/nss/loai_thu_tuc/view");

%>

<form action="<%= portletURL.toString() %>"  method="post" name="<portlet:namespace />fm" >

	<%
		LoaiThuTucHanhChinhSearch searchContainer = new LoaiThuTucHanhChinhSearch(renderRequest, portletURL);
		LoaiThuTucHanhChinhSearchTerms searchTerms = (LoaiThuTucHanhChinhSearchTerms)searchContainer.getSearchTerms();
	%>
	<div class="commom-form">
	<div class="parent-title"><liferay-ui:message key="javax.portlet.title.NSS_LOAI_THU_TUC" /></div>
	<liferay-ui:search-form
		page="/html/portlet/nss/loai_thu_tuc/search_form.jsp"
		searchContainer="<%= searchContainer %>" />
	<div id="separator"></div>
	
		<%
			PortletURL addURL = renderResponse.createRenderURL();
			addURL.setWindowState(WindowState.NORMAL);
			addURL.setParameter("struts_action", "/nss/loai_thu_tuc/view");
			addURL.setParameter("tabs", "add");
			addURL.setParameter("redirect", searchContainer.getIteratorURL().toString());
		%>
	<br/>
	<span onclick="javascript:submitForm(document.hrefFm,'<%= addURL.toString() %>');">
	<input type="button" value='<liferay-ui:message key="them-moi"/>' /></span>
	<br/><br/>
	<%
		List<LoaiThuTucHanhChinh> results = null;
		int total = 0;
		
		if (searchTerms.isAdvancedSearch()) {
			results = LoaiThuTucHanhChinhLocalServiceUtil.search(searchTerms.getTenLoaiThuTucHanhChinh(), searchTerms.getMoTa(), searchTerms.isAndOperator(),
						searchContainer.getStart(), searchContainer.getEnd(), searchContainer.getOrderByComparator());
			total = LoaiThuTucHanhChinhLocalServiceUtil.searchCount(searchTerms.getTenLoaiThuTucHanhChinh(), searchTerms.getMoTa(), searchTerms.isAndOperator());
		} else {
			results = LoaiThuTucHanhChinhLocalServiceUtil.findByKeywords(searchTerms.getKeywords(),searchContainer.getStart(), searchContainer.getEnd(),
						searchContainer.getOrderByComparator());
			total = LoaiThuTucHanhChinhLocalServiceUtil.countByKeywords(searchTerms.getKeywords());
		}
		
		searchContainer.setResults(results);
		searchContainer.setTotal(total);
		
		portletURL.setParameter(searchContainer.getCurParam(), String.valueOf(searchContainer.getCurValue()));
	%>
	<%
	
		List resultRows = searchContainer.getResultRows();
		ResultRow row = null;
		LoaiThuTucHanhChinh loaiThuTucHanhChinh = null;
		long maLoaiThuTucHanhChinh = 0;
		String update = "";
		String deleteAction = "";
		String active = "";
		
		for ( int i=0; i < results.size(); i++) {
			loaiThuTucHanhChinh = results.get(i);
			maLoaiThuTucHanhChinh = loaiThuTucHanhChinh.getMaLoaiThuTucHanhChinh();
			
			loaiThuTucHanhChinh = loaiThuTucHanhChinh.toEscapedModel();
			row = new ResultRow(loaiThuTucHanhChinh, maLoaiThuTucHanhChinh, i);
			
			//STT
			row.addText(String.valueOf(i + 1));
			
			//ten loai thu tuc hanh chinh
			row.addText(loaiThuTucHanhChinh.getTenLoaiThuTucHanhChinh());
			
			// mo ta
			row.addText(loaiThuTucHanhChinh.getDescription());
			
			//active 
			//URL active
			PortletURL rowURLActive= renderResponse.createActionURL();
			rowURLActive.setWindowState(WindowState.NORMAL);
			rowURLActive.setParameter("struts_action","/nss/loai_thu_tuc/view");
			rowURLActive.setParameter(Constants.CMD,Constants.LOCK);
			rowURLActive.setParameter("maLoaiThuTucHanhChinh", String.valueOf(maLoaiThuTucHanhChinh));
			rowURLActive.setParameter("redirect", searchContainer.getIteratorURL().toString());
			
			if (1 == loaiThuTucHanhChinh.getActive()) {
				active = "<a href='"+ rowURLActive.toString()+"'><img src='/html/images/checked.gif' />&nbsp;</a>";
			} else if (0 == loaiThuTucHanhChinh.getActive()){
				active = "<a href='"+ rowURLActive.toString()+"'><img src='/html/images/unchecked.gif' />&nbsp;</a>";
			}
			row.addText(active);
			
			// edit
			//URL update
			PortletURL rowURLEdit = renderResponse.createActionURL();
			rowURLEdit.setWindowState(WindowState.NORMAL);
			rowURLEdit.setParameter(Constants.CMD,Constants.EDIT);
			rowURLEdit.setParameter("struts_action","/nss/loai_thu_tuc/view");
			rowURLEdit.setParameter("maLoaiThuTucHanhChinh", String.valueOf(maLoaiThuTucHanhChinh));
			rowURLEdit.setParameter("redirect", searchContainer.getIteratorURL().toString());
			rowURLEdit.setParameter("tabs", "edit");
			
			update = "<a href='"+ rowURLEdit.toString()+"'><img src='/html/images/edit.png' />&nbsp;</a>";
			
			row.addText(update);
			
			// delete
			//URL delete
			PortletURL rowURLDelete = renderResponse.createActionURL();
			rowURLDelete.setWindowState(WindowState.NORMAL);
			rowURLDelete.setParameter("struts_action","/nss/loai_thu_tuc/view");
			rowURLDelete.setParameter(Constants.CMD,Constants.DELETE);
			rowURLDelete.setParameter("maLoaiThuTucHanhChinh", String.valueOf(maLoaiThuTucHanhChinh));
			
			deleteAction = "<a  href='javascript: ;'  onclick=deleteLoaiThuTucHanhChinh('"+ rowURLDelete.toString() +"')><u>"+ "<img src='/html/images/delete.png'/>" +"</u></a>";
			
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