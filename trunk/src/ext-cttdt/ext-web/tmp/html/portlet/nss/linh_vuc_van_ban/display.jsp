<%@ include file="/html/portlet/nss/linh_vuc_van_ban/init.jsp" %>

<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>

<%@page import="com.nss.portlet.linh_vuc_van_ban.search.LinhVucVanBanSearch"%>
<%@page import="com.nss.portlet.linh_vuc_van_ban.search.LinhVucVanBanSearchTerms"%>
<%@page import="com.nss.portlet.linh_vuc_van_ban.model.LinhVucVanBan"%>
<%@page import="com.nss.portlet.linh_vuc_van_ban.service.LinhVucVanBanLocalServiceUtil"%>

<liferay-util:include page="/html/portlet/nss/linh_vuc_van_ban/js/linhvucvanban-js.jsp"></liferay-util:include>

<portlet:renderURL var="add">
	<portlet:param name="struts_action" value="/nss/linh_vuc_van_ban/view" />
	<portlet:param name="tabs" value="add" />
</portlet:renderURL>

<%
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action", "/nss/linh_vuc_van_ban/view");

%>

<form action="<%= portletURL.toString() %>"  method="post" name="<portlet:namespace />fm" >

	<%
		LinhVucVanBanSearch searchContainer = new LinhVucVanBanSearch(renderRequest, portletURL);
		LinhVucVanBanSearchTerms searchTerms = (LinhVucVanBanSearchTerms)searchContainer.getSearchTerms();
		
	%>
	<div class="commom-form">
	<div class="parent-title"><liferay-ui:message key="javax.portlet.title.NSS_LINH_VUC_VAN_BAN" /></div>		
	<liferay-ui:search-form
		page="/html/portlet/nss/linh_vuc_van_ban/search_form.jsp"
		searchContainer="<%= searchContainer %>" />
	<div id="separator"></div>
		<%
			PortletURL addURL = renderResponse.createRenderURL();
			addURL.setWindowState(WindowState.NORMAL);
			addURL.setParameter("struts_action", "/nss/linh_vuc_van_ban/view");
			addURL.setParameter("tabs", "add");
			addURL.setParameter("redirect", searchContainer.getIteratorURL().toString());
		%>
	<br/>
	<a href="<%= addURL.toString() %>"><span><input class="button-width" type="button" value='<liferay-ui:message key="them-moi"/>' /></span></a>
	<br/>
	<%
		List<LinhVucVanBan> results = null;
		int total = 0;
		
		if (searchTerms.isAdvancedSearch()) {
			results = LinhVucVanBanLocalServiceUtil.findTEN_MOTA(searchTerms.getTenLinhVucVanBan(), searchTerms.getMoTa(),
					searchTerms.isAndOperator(),searchContainer.getStart(), searchContainer.getEnd(), searchContainer.getOrderByComparator());
			
			total = LinhVucVanBanLocalServiceUtil.countByTEN_MOTA(searchTerms.getTenLinhVucVanBan(), searchTerms.getMoTa(),
						searchTerms.isAndOperator());
		} else {
			results = LinhVucVanBanLocalServiceUtil.findByKeywords(searchTerms.getKeywords(),searchContainer.getStart(), searchContainer.getEnd(), 
						searchContainer.getOrderByComparator());
			total = LinhVucVanBanLocalServiceUtil.countByKeywords(searchTerms.getKeywords());
		}
		
		searchContainer.setResults(results);
		searchContainer.setTotal(total);
		
		portletURL.setParameter(searchContainer.getCurParam(), String.valueOf(searchContainer.getCurValue()));
	%>
	<%
	
		List resultRows = searchContainer.getResultRows();
		ResultRow row = null;
		LinhVucVanBan linhVucVanBan = null;
		long maLinhVucVanBan = 0;
		String update = "";
		String deleteAction = "";
		String active = "";
		
		for ( int i=0; i < results.size(); i++) {
			linhVucVanBan = results.get(i);
			maLinhVucVanBan = linhVucVanBan.getMaLinhVucVanBan();
			
			linhVucVanBan = linhVucVanBan.toEscapedModel();
			row = new ResultRow(linhVucVanBan, maLinhVucVanBan, i);
			
			//STT
			row.addText(String.valueOf(i + 1));
			
			//ten linh vuc van ban
			row.addText(linhVucVanBan.getTenLinhVucVanBan());
			
			// mo ta
			row.addText(linhVucVanBan.getDescription());
			
			//active
			//URL active
			PortletURL rowURLActive= renderResponse.createActionURL();
			rowURLActive.setWindowState(WindowState.NORMAL);
			rowURLActive.setParameter("struts_action","/nss/linh_vuc_van_ban/view");
			rowURLActive.setParameter(Constants.CMD,Constants.LOCK);
			rowURLActive.setParameter("maLinhVucVanBan", String.valueOf(maLinhVucVanBan));
			rowURLActive.setParameter("redirect", searchContainer.getIteratorURL().toString());
			
			if (1 == linhVucVanBan.getActive()) {
				active = "<a href='"+ rowURLActive.toString()+"'><img src='/html/images/checked.gif' />&nbsp;</a>";
			} else if (0 == linhVucVanBan.getActive()){
				active = "<a href='"+ rowURLActive.toString()+"'><img src='/html/images/unchecked.gif' />&nbsp;</a>";
			}
			row.addText(active);
			
			// edit
			//URL update
			PortletURL rowURLEdit = renderResponse.createActionURL();
			rowURLEdit.setWindowState(WindowState.NORMAL);
			rowURLEdit.setParameter(Constants.CMD,Constants.EDIT);
			rowURLEdit.setParameter("struts_action","/nss/linh_vuc_van_ban/view");
			rowURLEdit.setParameter("maLinhVucVanBan", String.valueOf(maLinhVucVanBan));
			rowURLEdit.setParameter("redirect", searchContainer.getIteratorURL().toString());
			rowURLEdit.setParameter("tabs", "add");
			
			update = "<a href='"+ rowURLEdit.toString()+"'><img src='/html/images/edit.png' />&nbsp;</a>";
			
			row.addText(update);
			
			// delete
			//URL delete
			PortletURL rowURLDelete = renderResponse.createActionURL();
			rowURLDelete.setWindowState(WindowState.NORMAL);
			rowURLDelete.setParameter("struts_action","/nss/linh_vuc_van_ban/view");
			rowURLDelete.setParameter(Constants.CMD,Constants.DELETE);
			rowURLDelete.setParameter("maLinhVucVanBan", String.valueOf(maLinhVucVanBan));
			
			deleteAction = "<a  href='javascript: ;'  onclick=deleteLinhVucVanBan('"+ rowURLDelete.toString() +"')><u>"+ "<img src='/html/images/delete.png'/>" +"</u></a>";
			
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
