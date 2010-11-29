<%@ include file="/html/portlet/nss/loai_van_ban/init.jsp" %>

<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.util.List"%>

<%@page import="com.nss.portlet.loai_van_ban.search.LoaiVanBanSearch"%>
<%@page import="com.nss.portlet.loai_van_ban.search.LoaiVanBanSearchTerms"%>
<%@page import="com.nss.portlet.loai_van_ban.model.LoaiVanBan"%>
<%@page import="com.nss.portlet.loai_van_ban.service.LoaiVanBanLocalServiceUtil"%>

<liferay-util:include page="/html/portlet/nss/loai_van_ban/js/loaivanban-js.jsp"></liferay-util:include>

<%
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action", "/nss/loai_van_ban/view");

%>

<form action="<%= portletURL.toString() %>"  method="post" name="<portlet:namespace />fm" >

	<%
		LoaiVanBanSearch searchContainer = new LoaiVanBanSearch(renderRequest, portletURL);
		LoaiVanBanSearchTerms searchTerms = (LoaiVanBanSearchTerms)searchContainer.getSearchTerms();
	%>
	<div class="commom-form">
	<div class="parent-title"><liferay-ui:message key="javax.portlet.title.NSS_LOAI_VAN_BAN" /></div>
	<liferay-ui:search-form
		page="/html/portlet/nss/loai_van_ban/search_form.jsp"
		searchContainer="<%= searchContainer %>" />
		<%
			PortletURL addURL = renderResponse.createRenderURL();
			addURL.setWindowState(WindowState.NORMAL);
			addURL.setParameter("struts_action", "/nss/loai_van_ban/view");
			addURL.setParameter("tabs", "add");
			addURL.setParameter("redirect", searchContainer.getIteratorURL().toString());
		%>
	<a href="<%= addURL.toString() %>"><span><input class="button-width" type="button" value='<liferay-ui:message key="them-moi"/>' /></span></a>
	<br><br>
	<%
		List<LoaiVanBan> results = null;
		int total = 0;
		
		if (searchTerms.isAdvancedSearch()) {
			results = LoaiVanBanLocalServiceUtil.findTEN_MOTA(searchTerms.getTenLoaiVanBan(), searchTerms.getMoTa(),
					searchTerms.isAndOperator(),searchContainer.getStart(), searchContainer.getEnd(), searchContainer.getOrderByComparator());
			
			total = LoaiVanBanLocalServiceUtil.countByTEN_MOTA(searchTerms.getTenLoaiVanBan(), searchTerms.getMoTa(),
						searchTerms.isAndOperator());
		} else {
			results = LoaiVanBanLocalServiceUtil.findByKeywords(searchTerms.getKeywords(),searchContainer.getStart(), searchContainer.getEnd(), 
						searchContainer.getOrderByComparator());
			total = LoaiVanBanLocalServiceUtil.countByKeywords(searchTerms.getKeywords());
		}
		
		searchContainer.setResults(results);
		searchContainer.setTotal(total);
		
		portletURL.setParameter(searchContainer.getCurParam(), String.valueOf(searchContainer.getCurValue()));
	%>
	<%
	
		List resultRows = searchContainer.getResultRows();
		ResultRow row = null;
		LoaiVanBan loaiVanBan = null;
		long maLoaiVanBan = 0;
		String update = "";
		String deleteAction = "";
		String active = "";
		
		for ( int i=0; i < results.size(); i++) {
			loaiVanBan = results.get(i);
			maLoaiVanBan = loaiVanBan.getMaLoaiVanBan();
			
			loaiVanBan = loaiVanBan.toEscapedModel();
			row = new ResultRow(loaiVanBan, maLoaiVanBan, i);
			
			//STT
			row.addText(String.valueOf(i + 1));
			
			//ten linh vuc van ban
			row.addText(loaiVanBan.getTenLoaiVanBan());
			
			// mo ta
			row.addText(loaiVanBan.getDescription());
			
			//active 
			//URL active
			PortletURL rowURLActive= renderResponse.createActionURL();
			rowURLActive.setWindowState(WindowState.NORMAL);
			rowURLActive.setParameter("struts_action","/nss/loai_van_ban/view");
			rowURLActive.setParameter(Constants.CMD,Constants.LOCK);
			rowURLActive.setParameter("maLoaiVanBan", String.valueOf(maLoaiVanBan));
			rowURLActive.setParameter("redirect", searchContainer.getIteratorURL().toString());
			
			if (1 == loaiVanBan.getActive()) {
				active = "<a href='"+ rowURLActive.toString()+"'><img src='/html/images/checked.gif' />&nbsp;</a>";
			} else if (0 == loaiVanBan.getActive()){
				active = "<a href='"+ rowURLActive.toString()+"'><img src='/html/images/unchecked.gif' />&nbsp;</a>";
			}
			row.addText(active);
			
			// edit
			//URL update
			PortletURL rowURLEdit = renderResponse.createActionURL();
			rowURLEdit.setWindowState(WindowState.NORMAL);
			rowURLEdit.setParameter(Constants.CMD,Constants.EDIT);
			rowURLEdit.setParameter("struts_action","/nss/loai_van_ban/view");
			rowURLEdit.setParameter("maLoaiVanBan", String.valueOf(maLoaiVanBan));
			rowURLEdit.setParameter("redirect", searchContainer.getIteratorURL().toString());
			rowURLEdit.setParameter("tabs", "add");
			
			update = "<a href='"+ rowURLEdit.toString()+"'><img src='/html/images/edit.png' />&nbsp;</a>";
			
			row.addText(update);
			
			// delete
			//URL delete
			PortletURL rowURLDelete = renderResponse.createActionURL();
			rowURLDelete.setWindowState(WindowState.NORMAL);
			rowURLDelete.setParameter("struts_action","/nss/loai_van_ban/view");
			rowURLDelete.setParameter(Constants.CMD,Constants.DELETE);
			rowURLDelete.setParameter("maLoaiVanBan", String.valueOf(maLoaiVanBan));
			
			deleteAction = "<a  href='javascript: ;'  onclick=deleteLoaiVanBan('"+ rowURLDelete.toString() +"')><u>"+ "<img src='/html/images/delete.png'/>" +"</u></a>";
			
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

