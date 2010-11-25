<%@ include file="/html/portlet/nss/nss_don_vi_thu_tuc/init.jsp" %>

<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.util.List"%>

<%@page import="com.nss.portlet.nss_don_vi_thu_tuc.search.DonViThuTucSearch"%>
<%@page import="com.nss.portlet.nss_don_vi_thu_tuc.search.DonViThuTucSearchTerms"%>
<%@page import="com.nss.portlet.nss_don_vi_thu_tuc.model.DonViThuTuc"%>
<%@page import="com.nss.portlet.nss_don_vi_thu_tuc.service.DonViThuTucLocalServiceUtil"%>


<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%><liferay-util:include page="/html/portlet/nss/nss_don_vi_thu_tuc/js/donvithutuc-js.jsp"></liferay-util:include>

<%
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action", "/nss/nss_don_vi_thu_tuc/view");

%>

<form action="<%= portletURL.toString() %>"  method="post" name="<portlet:namespace />fm" >

	<%
		DonViThuTucSearch searchContainer = new DonViThuTucSearch(renderRequest, portletURL);
		DonViThuTucSearchTerms searchTerms = (DonViThuTucSearchTerms)searchContainer.getSearchTerms();
	%>
	<div class="commom-form">
	<div class="parent-title"><liferay-ui:message key="javax.portlet.title.NSS_NSS_DON_VI_THU_TUC" /></div>
	<liferay-ui:search-form
		page="/html/portlet/nss/nss_don_vi_thu_tuc/search_form.jsp"
		searchContainer="<%= searchContainer %>" />
	<div id="separator"></div>
		<%
			PortletURL addURL = renderResponse.createRenderURL();
			addURL.setWindowState(WindowState.NORMAL);
			addURL.setParameter("struts_action", "/nss/nss_don_vi_thu_tuc/view");
			addURL.setParameter("tabs", "add");
			addURL.setParameter("redirect", searchContainer.getIteratorURL().toString());
		%>
	<br/>
	<a href="<%= addURL.toString() %>"><span><input class="button-width" type="button" value='<liferay-ui:message key="them-moi"/>' /></span></a>
	<br/><br/>
	<%
		List<DonViThuTuc> results = null;
		int total = 0;
		
		if (searchTerms.isAdvancedSearch()) {
			results = DonViThuTucLocalServiceUtil.findTEN_MOTA(searchTerms.getTenDonViThuTuc(), searchTerms.getMoTa(),
					searchTerms.isAndOperator(),searchContainer.getStart(), searchContainer.getEnd(), searchContainer.getOrderByComparator());
			
			total = DonViThuTucLocalServiceUtil.countByTEN_MOTA(searchTerms.getTenDonViThuTuc(), searchTerms.getMoTa(),
						searchTerms.isAndOperator());
		} else {
			results = DonViThuTucLocalServiceUtil.findByKeywords(searchTerms.getKeywords(),searchContainer.getStart(), searchContainer.getEnd(), 
						searchContainer.getOrderByComparator());
			total = DonViThuTucLocalServiceUtil.countByKeywords(searchTerms.getKeywords());
		}
		
		searchContainer.setResults(results);
		searchContainer.setTotal(total);
		
		portletURL.setParameter(searchContainer.getCurParam(), String.valueOf(searchContainer.getCurValue()));
	%>
	<%
	
		List resultRows = searchContainer.getResultRows();
		ResultRow row = null;
		DonViThuTuc donViThuTuc = null;
		long maDonViThuTuc = 0;
		String update = "";
		String deleteAction = "";
		String active = "";
		
		for ( int i=0; i < results.size(); i++) {
			donViThuTuc = results.get(i);
			maDonViThuTuc = donViThuTuc.getMaDonViThuTuc();
			
			donViThuTuc = donViThuTuc.toEscapedModel();
			row = new ResultRow(donViThuTuc, maDonViThuTuc, i);
			
			//STT
			row.addText(String.valueOf(i + 1));
			
			//ten thu tuc
			row.addText(donViThuTuc.getTenDonViThuTuc());
			
			// cap don vi
			String capDonVi = "";
			if (donViThuTuc.getCapDonVi() == 1){
				capDonVi = LanguageUtil.get(pageContext,"cap-thanh-pho");
				
			}
			else if (donViThuTuc.getCapDonVi() == 2){
				capDonVi = LanguageUtil.get(pageContext,"cap-quan-huyen");
			}
			else {
				capDonVi = LanguageUtil.get(pageContext,"cap-phuong-xa");
			}
			row.addText(capDonVi);
			
			// mo ta
			row.addText(donViThuTuc.getDescription());
			
			//active 
			//URL active
			PortletURL rowURLActive= renderResponse.createActionURL();
			rowURLActive.setWindowState(WindowState.NORMAL);
			rowURLActive.setParameter("struts_action", "/nss/nss_don_vi_thu_tuc/view");
			rowURLActive.setParameter(Constants.CMD, Constants.LOCK);
			rowURLActive.setParameter("maDonViThuTuc", String.valueOf(maDonViThuTuc));
			rowURLActive.setParameter("redirect", searchContainer.getIteratorURL().toString());
			
			if (1 == donViThuTuc.getActive()) {
				active = "<a href='"+ rowURLActive.toString()+"'><img src='/html/images/checked.gif' />&nbsp;</a>";
			} else if (0 == donViThuTuc.getActive()){
				active = "<a href='"+ rowURLActive.toString()+"'><img src='/html/images/unchecked.gif' />&nbsp;</a>";
			}
			row.addText(active);
			
			// edit
			//URL update
			PortletURL rowURLEdit = renderResponse.createActionURL();
			rowURLEdit.setWindowState(WindowState.NORMAL);
			rowURLEdit.setParameter(Constants.CMD,Constants.EDIT);
			rowURLEdit.setParameter("struts_action", "/nss/nss_don_vi_thu_tuc/view");
			rowURLEdit.setParameter("maDonViThuTuc", String.valueOf(maDonViThuTuc));
			rowURLEdit.setParameter("redirect", searchContainer.getIteratorURL().toString());
			rowURLEdit.setParameter("tabs", "add");
			
			update = "<a href='"+ rowURLEdit.toString()+"'><img src='/html/images/edit.png' />&nbsp;</a>";
			
			row.addText(update);
			
			// delete
			//URL delete
			PortletURL rowURLDelete = renderResponse.createActionURL();
			rowURLDelete.setWindowState(WindowState.NORMAL);
			rowURLDelete.setParameter("struts_action", "/nss/nss_don_vi_thu_tuc/view");
			rowURLDelete.setParameter(Constants.CMD, Constants.DELETE);
			rowURLDelete.setParameter("maDonViThuTuc", String.valueOf(maDonViThuTuc));
			
			deleteAction = "<a href='javascript: ;' onclick=deleteDonViThuTuc('"+ rowURLDelete.toString() +"')><u>"+ "<img src='/html/images/delete.png'/>" +"</u></a>";
			
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

