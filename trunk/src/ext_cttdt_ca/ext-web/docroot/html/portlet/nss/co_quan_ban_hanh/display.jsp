<%@ include file="/html/portlet/nss/co_quan_ban_hanh/init.jsp" %>

<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.util.List"%>

<%@page import="com.nss.portlet.co_quan_ban_hanh.search.CoQuanBanHanhSearch"%>
<%@page import="com.nss.portlet.co_quan_ban_hanh.search.CoQuanBanHanhSearchTerms"%>
<%@page import="com.nss.portlet.co_quan_ban_hanh.model.CoQuanBanHanh"%>
<%@page import="com.nss.portlet.co_quan_ban_hanh.service.CoQuanBanHanhLocalServiceUtil"%>

<liferay-util:include page="/html/portlet/nss/co_quan_ban_hanh/js/coquanbanhanh-js.jsp"></liferay-util:include>

<%
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action", "/nss/co_quan_ban_hanh/view");

%>

<form action="<%= portletURL.toString() %>"  method="post" name="<portlet:namespace />fm" >

	<%
		CoQuanBanHanhSearch searchContainer = new CoQuanBanHanhSearch(renderRequest, portletURL);
		CoQuanBanHanhSearchTerms searchTerms = (CoQuanBanHanhSearchTerms)searchContainer.getSearchTerms();
	%>
	<div class="commom-form">
	<div class="parent-title"><liferay-ui:message key="javax.portlet.title.NSS_CO_QUAN_BAN_HANH" /></div>
	<liferay-ui:search-form
		page="/html/portlet/nss/co_quan_ban_hanh/search_form.jsp"
		searchContainer="<%= searchContainer %>" />
		<%
			PortletURL addURL = renderResponse.createRenderURL();
			addURL.setWindowState(WindowState.NORMAL);
			addURL.setParameter("struts_action", "/nss/co_quan_ban_hanh/view");
			addURL.setParameter("tabs", "add");
			addURL.setParameter("redirect", searchContainer.getIteratorURL().toString());
		%>
	<a href="<%= addURL.toString() %>"><span><input class="button-width" type="button" value='<liferay-ui:message key="them-moi"/>' /></span></a>
	<br><br>
	<%
		List<CoQuanBanHanh> results = null;
		int total = 0;
		
		if (searchTerms.isAdvancedSearch()) {
			results = CoQuanBanHanhLocalServiceUtil.search(searchTerms.getTenCoQuanBanHanh(), searchTerms.getMoTa(),
					searchTerms.isAndOperator(),searchContainer.getStart(), searchContainer.getEnd(), searchContainer.getOrderByComparator());
			
			total = CoQuanBanHanhLocalServiceUtil.searchCount(searchTerms.getTenCoQuanBanHanh(), searchTerms.getMoTa(),
						searchTerms.isAndOperator());
		} else {
			results = CoQuanBanHanhLocalServiceUtil.findByKeywords(searchTerms.getKeywords(),searchContainer.getStart(), searchContainer.getEnd(), 
						searchContainer.getOrderByComparator());
			total = CoQuanBanHanhLocalServiceUtil.countByKeywords(searchTerms.getKeywords());
		}
		
		searchContainer.setResults(results);
		searchContainer.setTotal(total);
		
		portletURL.setParameter(searchContainer.getCurParam(), String.valueOf(searchContainer.getCurValue()));
	%>
	<%
	
		List resultRows = searchContainer.getResultRows();
		ResultRow row = null;
		CoQuanBanHanh coQuanBanHanh = null;
		long maCoQuanBanHanh = 0;
		String update = "";
		String deleteAction = "";
		String active = "";
		
		for ( int i=0; i < results.size(); i++) {
			coQuanBanHanh = results.get(i);
			maCoQuanBanHanh = coQuanBanHanh.getMaCoQuanBanHanh();
			
			coQuanBanHanh = coQuanBanHanh.toEscapedModel();
			row = new ResultRow(coQuanBanHanh, maCoQuanBanHanh, i);
			
			//STT
			row.addText(String.valueOf(i + 1));
			
			//ten linh vuc van ban
			row.addText(coQuanBanHanh.getTenCoQuanBanHanh());
			
			// mo ta
			row.addText(coQuanBanHanh.getDescription());
			
			//active 
			//URL active
			PortletURL rowURLActive= renderResponse.createActionURL();
			rowURLActive.setWindowState(WindowState.NORMAL);
			rowURLActive.setParameter("struts_action","/nss/co_quan_ban_hanh/view");
			rowURLActive.setParameter(Constants.CMD,Constants.LOCK);
			rowURLActive.setParameter("maCoQuanBanHanh", String.valueOf(maCoQuanBanHanh));
			rowURLActive.setParameter("redirect", searchContainer.getIteratorURL().toString());
			
			if (1 == coQuanBanHanh.getActive()) {
				active = "<a href='"+ rowURLActive.toString()+"'><img src='/html/images/checked.gif' />&nbsp;</a>";
			} else if (0 == coQuanBanHanh.getActive()){
				active = "<a href='"+ rowURLActive.toString()+"'><img src='/html/images/unchecked.gif' />&nbsp;</a>";
			}
			row.addText(active);
			
			// edit
			//URL update
			PortletURL rowURLEdit = renderResponse.createActionURL();
			rowURLEdit.setWindowState(WindowState.NORMAL);
			rowURLEdit.setParameter(Constants.CMD,Constants.EDIT);
			rowURLEdit.setParameter("struts_action","/nss/co_quan_ban_hanh/view");
			rowURLEdit.setParameter("maCoQuanBanHanh", String.valueOf(maCoQuanBanHanh));
			rowURLEdit.setParameter("redirect", searchContainer.getIteratorURL().toString());
			rowURLEdit.setParameter("tabs", "edit");
			
			update = "<a href='"+ rowURLEdit.toString()+"'><img src='/html/images/edit.png' />&nbsp;</a>";
			
			row.addText(update);
			
			// delete
			//URL delete
			PortletURL rowURLDelete = renderResponse.createActionURL();
			rowURLDelete.setWindowState(WindowState.NORMAL);
			rowURLDelete.setParameter("struts_action","/nss/co_quan_ban_hanh/view");
			rowURLDelete.setParameter(Constants.CMD,Constants.DELETE);
			rowURLDelete.setParameter("maCoQuanBanHanh", String.valueOf(maCoQuanBanHanh));
			
			deleteAction = "<a  href='javascript: ;'  onclick=deleteCoQuanBanHanh('"+ rowURLDelete.toString() +"')><u>"+ "<img src='/html/images/delete.png'/>" +"</u></a>";
			
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

