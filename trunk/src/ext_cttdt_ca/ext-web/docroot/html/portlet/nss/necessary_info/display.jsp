<%@ include file="/html/portlet/nss/necessary_info/init.jsp" %>

<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.util.List"%>

<%@page import="com.nss.portlet.necessary_info.search.ThongTinCanThietSearch"%>
<%@page import="com.nss.portlet.necessary_info.search.ThongTinCanThietSearchTerms"%>
<%@page import="com.nss.portlet.necessary_info.service.ThongTinCanThietLocalServiceUtil"%>
<%@page import="com.nss.portlet.necessary_info.model.ThongTinCanThiet"%>

<liferay-util:include page="/html/portlet/nss/necessary_info/js/thongtincanthiet-js.jsp"></liferay-util:include>

<%
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action", "/nss/necessary_info/view");

%>

<form action="<%= portletURL.toString() %>"  method="post" name="<portlet:namespace />fm" >
	<div class="titlecategr" style="margin-bottom: 15px;"><h4><p><liferay-ui:message key="javax.portlet.title.NSS_NECESSARY_INFO" /></p></h4></div>
	<%
		ThongTinCanThietSearch searchContainer = new ThongTinCanThietSearch(renderRequest, portletURL);
		ThongTinCanThietSearchTerms searchTerms = (ThongTinCanThietSearchTerms)searchContainer.getSearchTerms();
	%>
	
	<liferay-ui:search-form
		page="/html/portlet/nss/necessary_info/search_form.jsp"
		searchContainer="<%= searchContainer %>" />
		<%
			PortletURL addURL = renderResponse.createRenderURL();
			addURL.setWindowState(WindowState.NORMAL);
			addURL.setParameter("struts_action", "/nss/necessary_info/view");
			addURL.setParameter("tabs", "add");
			addURL.setParameter("redirect", searchContainer.getIteratorURL().toString());
		%>
	<a href="<%= addURL.toString() %>"><span><input class="button-width" type="button" value='<liferay-ui:message key="them-moi"/>' /></span></a>
	<br><br>
	<%
		List<ThongTinCanThiet> results = null;
		int total = 0;
		
		if (searchTerms.isAdvancedSearch()) {
			results = ThongTinCanThietLocalServiceUtil.search(searchTerms.getTenThongTinCanThiet(), searchTerms.getMoTa(), searchTerms.isAndOperator(),
						searchContainer.getStart(), searchContainer.getEnd(), searchContainer.getOrderByComparator());
			total = ThongTinCanThietLocalServiceUtil.searchCount(searchTerms.getTenThongTinCanThiet(), searchTerms.getMoTa(), searchTerms.isAndOperator());
		} else {
			results = ThongTinCanThietLocalServiceUtil.findByKeywords(searchTerms.getKeywords(),searchContainer.getStart(), searchContainer.getEnd(),
						searchContainer.getOrderByComparator());
			total = ThongTinCanThietLocalServiceUtil.countByKeywords(searchTerms.getKeywords());
		}
		
		searchContainer.setResults(results);
		searchContainer.setTotal(total);
		
		portletURL.setParameter(searchContainer.getCurParam(), String.valueOf(searchContainer.getCurValue()));
	%>
	<%
	
		List resultRows = searchContainer.getResultRows();
		ResultRow row = null;
		ThongTinCanThiet thongTinCanThiet = null;
		long maThongTinCanThiet = 0;
		String update = "";
		String deleteAction = "";
		String active = "";
		
		for ( int i=0; i < results.size(); i++) {
			thongTinCanThiet = results.get(i);
			maThongTinCanThiet = thongTinCanThiet.getMaThongTinCanThiet();
			
			thongTinCanThiet = thongTinCanThiet.toEscapedModel();
			row = new ResultRow(thongTinCanThiet, maThongTinCanThiet, i);
			
			//STT
			row.addText(String.valueOf(i + 1));
			
			//ten linh vuc van ban
			row.addText(thongTinCanThiet.getTenThongTinCanThiet());
			
			// hinh anh
			if (0 == thongTinCanThiet.getImageId_liferay()) {
				row.addText("");
			} else {
				row.addText("<img style='width: 120px; height: auto;' src='"+  themeDisplay.getPathImage()+ "/necessary_info?img_id="+ thongTinCanThiet.getImageId_liferay() +"' />");
			}
			
			// mo ta
			row.addText(thongTinCanThiet.getMoTaThongTinCanThiet());
			
			// thu tu
			row.addText(String.valueOf(thongTinCanThiet.getThuTuThongTin()));
			
			// target
			row.addText(thongTinCanThiet.getTarget());
			
			//active 
			//URL active
			PortletURL rowURLActive= renderResponse.createActionURL();
			rowURLActive.setWindowState(WindowState.NORMAL);
			rowURLActive.setParameter("struts_action","/nss/necessary_info/view");
			rowURLActive.setParameter(Constants.CMD,Constants.LOCK);
			rowURLActive.setParameter("maThongTinCanThiet", String.valueOf(maThongTinCanThiet));
			rowURLActive.setParameter("redirect", searchContainer.getIteratorURL().toString());
			
			if (1 == thongTinCanThiet.getActive()) {
				active = "<a href='"+ rowURLActive.toString()+"'><img src='/html/images/checked.gif' />&nbsp;</a>";
			} else if (0 == thongTinCanThiet.getActive()){
				active = "<a href='"+ rowURLActive.toString()+"'><img src='/html/images/unchecked.gif' />&nbsp;</a>";
			}
			row.addText(active);
			
			// edit
			//URL update
			PortletURL rowURLEdit = renderResponse.createActionURL();
			rowURLEdit.setWindowState(WindowState.NORMAL);
			rowURLEdit.setParameter(Constants.CMD,Constants.EDIT);
			rowURLEdit.setParameter("struts_action","/nss/necessary_info/view");
			rowURLEdit.setParameter("maThongTinCanThiet", String.valueOf(maThongTinCanThiet));
			rowURLEdit.setParameter("redirect", searchContainer.getIteratorURL().toString());
			rowURLEdit.setParameter("tabs", "edit");
			
			update = "<a href='"+ rowURLEdit.toString()+"'><img src='/html/images/edit.gif' />&nbsp;</a>";
			
			row.addText(update);
			
			// delete
			//URL delete
			PortletURL rowURLDelete = renderResponse.createActionURL();
			rowURLDelete.setWindowState(WindowState.NORMAL);
			rowURLDelete.setParameter("struts_action","/nss/necessary_info/view");
			rowURLDelete.setParameter(Constants.CMD,Constants.DELETE);
			rowURLDelete.setParameter("maThongTinCanThiet", String.valueOf(maThongTinCanThiet));
			
			deleteAction = "<a  href='javascript: ;'  onclick=deleteThongTinCanThiet('"+ rowURLDelete.toString() +"')><u>"+ "<img src='/html/images/xoa.gif'/>" +"</u></a>";
			
			row.addText(deleteAction);
			
			resultRows.add(row);
		}
		
	%>
	<liferay-ui:search-iterator searchContainer="<%=searchContainer %>" />
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