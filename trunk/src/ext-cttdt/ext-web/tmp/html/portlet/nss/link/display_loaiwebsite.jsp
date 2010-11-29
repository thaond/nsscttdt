<%@ include file="/html/portlet/nss/link/init.jsp" %>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.nss.portlet.link.searchLoaiWebsite.LoaiWebsiteSearch"%>
<%@page import="com.nss.portlet.link.searchLoaiWebsite.LoaiWebsiteSearchTerms"%>
<%@page import="com.nss.portlet.link.model.LoaiWebsite"%>
<%@page import="com.nss.portlet.link.service.LoaiWebsiteLocalServiceUtil"%>
<liferay-util:include page="/html/portlet/nss/link/js/lienketwebsiste-js.jsp"></liferay-util:include>

<%
	String tabLoai = ParamUtil.getString(request, "tabLoai","display_loai");
	String tabs = ParamUtil.getString(renderRequest,"tabs","view_loaiWebsite");
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action", "/nss/link/view");
	portletURL.setParameter("tabLoai", tabLoai);
	portletURL.setParameter("tabs", tabs);

%>

<form action="<%= portletURL.toString() %>"  method="post" name="<portlet:namespace />fm" >
	<%
		LoaiWebsiteSearch loaiWebsiteSearch = new LoaiWebsiteSearch(renderRequest, portletURL);
		LoaiWebsiteSearchTerms loaiWebsiteSearchTerms = (LoaiWebsiteSearchTerms)loaiWebsiteSearch.getSearchTerms();
	%>
	<liferay-ui:search-form page="/html/portlet/nss/link/search_form_loaiwebsite.jsp" searchContainer="<%= loaiWebsiteSearch %>" />
		<%
			PortletURL addURL = renderResponse.createRenderURL();
			addURL.setWindowState(WindowState.NORMAL);
			addURL.setParameter("struts_action", "/nss/link/viewloaiwebsite");
			addURL.setParameter("tabLoai", "add_loai");
			addURL.setParameter("tabs", tabs);
			addURL.setParameter("redirect", loaiWebsiteSearch.getIteratorURL().toString());
		%>
	<a href="<%= addURL.toString() %>"><span><input class="button-width" type="button" value='<liferay-ui:message key="them-moi"/>' /></span></a>
	<br><br>
	
	<%
		List<LoaiWebsite> results = null;
		int total = 0;
		
		if (loaiWebsiteSearchTerms.isAdvancedSearch()) {
			results = LoaiWebsiteLocalServiceUtil.findLoaiWebsite(loaiWebsiteSearchTerms.getTenLoaiWebsite(), loaiWebsiteSearchTerms.getMoTaLoai(),
					loaiWebsiteSearchTerms.isAndOperator(),loaiWebsiteSearch.getStart(), loaiWebsiteSearch.getEnd(), loaiWebsiteSearch.getOrderByComparator());
			
			total = LoaiWebsiteLocalServiceUtil.countLoaiWebsite(loaiWebsiteSearchTerms.getTenLoaiWebsite(), loaiWebsiteSearchTerms.getMoTaLoai(),
						loaiWebsiteSearchTerms.isAndOperator());
		} else {
			results = LoaiWebsiteLocalServiceUtil.findLoaiWebsiteByKeywords(loaiWebsiteSearchTerms.getKeywords(), loaiWebsiteSearch.getStart(), loaiWebsiteSearch.getEnd(), 
						loaiWebsiteSearch.getOrderByComparator());
			total = LoaiWebsiteLocalServiceUtil.countLoaiWebsiteByKeywords(loaiWebsiteSearchTerms.getKeywords());
		}
		
		loaiWebsiteSearch.setResults(results);
		loaiWebsiteSearch.setTotal(total);
		
		portletURL.setParameter(loaiWebsiteSearch.getCurParam(), String.valueOf(loaiWebsiteSearch.getCurValue()));
	%>
	<%
		List resultRows = loaiWebsiteSearch.getResultRows();
		ResultRow row = null;
		LoaiWebsite loaiWebsite = null;
		long maLoaiWebsite = 0;
		String update = "";
		String deleteAction = "";
		String active = "";
		
		for ( int i=0; i < results.size(); i++) {
			loaiWebsite = results.get(i);
			maLoaiWebsite = loaiWebsite.getMaLoaiWebsite();
			
			loaiWebsite = loaiWebsite.toEscapedModel();
			
			row = new ResultRow(loaiWebsite, maLoaiWebsite, i);
			
			// STT
			row.addText(String.valueOf(i + 1));
			
			// ten loai website
			row.addText(loaiWebsite.getTenLoaiWebsite());
			
			// mo ta
			row.addText(loaiWebsite.getMoTaLoaiWebsite());
			
			//active 
			//URL active
			PortletURL rowURLActive= renderResponse.createActionURL();
			rowURLActive.setWindowState(WindowState.NORMAL);
			rowURLActive.setParameter("struts_action","/nss/link/viewloaiwebsite");
			rowURLActive.setParameter(Constants.CMD,Constants.LOCK);
			rowURLActive.setParameter("maLoaiWebsite", String.valueOf(maLoaiWebsite));
			rowURLActive.setParameter("tabLoai", "display_loai");
			rowURLActive.setParameter("tabs", tabs);
			rowURLActive.setParameter("redirect", loaiWebsiteSearch.getIteratorURL().toString());
			
			if (1 == loaiWebsite.getActive()) {
				active = "<a href='"+ rowURLActive.toString()+"'><img src='/html/images/checked.gif' />&nbsp;</a>";
			} else if (0 == loaiWebsite.getActive()){
				active = "<a href='"+ rowURLActive.toString()+"'><img src='/html/images/unchecked.gif' />&nbsp;</a>";
			}
			row.addText(active);
			
			// edit
			//URL update
			PortletURL rowURLEdit = renderResponse.createActionURL();
			rowURLEdit.setWindowState(WindowState.NORMAL);
			rowURLEdit.setParameter(Constants.CMD,Constants.EDIT);
			rowURLEdit.setParameter("struts_action","/nss/link/viewloaiwebsite");
			rowURLEdit.setParameter("maLoaiWebsite", String.valueOf(maLoaiWebsite));
			rowURLEdit.setParameter("redirect", loaiWebsiteSearch.getIteratorURL().toString());
			rowURLEdit.setParameter("tabLoai", "add_loai");
			rowURLEdit.setParameter("tabs", tabs);
			
			update = "<a href='"+ rowURLEdit.toString()+"'><img src='/html/images/edit.png' />&nbsp;</a>";
			
			row.addText(update);
			
			// delete
			//URL delete
			PortletURL rowURLDelete = renderResponse.createActionURL();
			rowURLDelete.setWindowState(WindowState.NORMAL);
			rowURLDelete.setParameter("struts_action","/nss/link/viewloaiwebsite");
			rowURLDelete.setParameter(Constants.CMD,Constants.DELETE);
			rowURLDelete.setParameter("maLoaiWebsite", String.valueOf(maLoaiWebsite));
			rowURLDelete.setParameter("tabLoai", "display_loai");
			rowURLDelete.setParameter("tabs", tabs);
			
			deleteAction = "<a  href='javascript: ;'  onclick=deleteLoaiWebsite('"+ rowURLDelete.toString() +"')><u>"+ "<img src='/html/images/delete.png'/>" +"</u></a>";
			
			row.addText(deleteAction);
			
			resultRows.add(row);
		}
	%>
	
<liferay-ui:search-iterator searchContainer="<%= loaiWebsiteSearch %>" />
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