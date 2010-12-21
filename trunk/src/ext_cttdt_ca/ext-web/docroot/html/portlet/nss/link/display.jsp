<%@ include file="/html/portlet/nss/link/init.jsp" %>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.nss.portlet.link.model.LienKetWebsite"%>
<%@page import="com.nss.portlet.link.search.LienKetWebsiteSearchTerms"%>
<%@page import="com.nss.portlet.link.service.LienKetWebsiteLocalServiceUtil"%>
<%@page import="com.nss.portlet.link.search.LienKetWebsiteSearch"%>
<%@page import="com.nss.portlet.link.model.LoaiWebsite"%>
<%@page import="com.nss.portlet.link.service.LoaiWebsiteLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.Base64"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="java.io.OutputStream"%>
<%@page import="javax.portlet.PortletSession"%>
<%@page import="java.io.File"%>
<%@page import="com.liferay.portal.kernel.upload.UploadPortletRequest"%>
<liferay-util:include page="/html/portlet/nss/link/js/lienketwebsiste-js.jsp"></liferay-util:include>
<%
	String tabDisplay = ParamUtil.getString(request, "tabDisplay","display_link");
	String tabs = ParamUtil.getString(renderRequest,"tabs","view_link");
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action", "/nss/link/view");
	portletURL.setParameter("tabDisplay", tabDisplay);
	portletURL.setParameter("tabs", tabs);
%>

<form action="<%= portletURL.toString() %>"  method="post" name="<portlet:namespace />fm" >
	<%
		LienKetWebsiteSearch searchContainer = new LienKetWebsiteSearch(renderRequest, portletURL);
		LienKetWebsiteSearchTerms searchTerms = (LienKetWebsiteSearchTerms)searchContainer.getSearchTerms();
	%>
	<liferay-ui:search-form page="/html/portlet/nss/link/search_form.jsp" searchContainer="<%= searchContainer %>" />
		<%
			PortletURL addURL = renderResponse.createRenderURL();
			addURL.setWindowState(WindowState.NORMAL);
			addURL.setParameter("struts_action", "/nss/link/view");
			addURL.setParameter("tabDisplay", "add_link");
			addURL.setParameter("tabs", tabs);
			addURL.setParameter("redirect", searchContainer.getIteratorURL().toString());
		%>
	<a href="<%= addURL.toString() %>"><span><input class="button-width" type="button" value='<liferay-ui:message key="them-moi"/>' /></span></a>
	<br><br>
	<%
		List<LienKetWebsite> results = null;
		int total = 0;
		
		if (searchTerms.isAdvancedSearch()) {
			results = LienKetWebsiteLocalServiceUtil.findTEN_MOTA(searchTerms.getTenWebsite(), searchTerms.getMoTa(),
					searchTerms.isAndOperator(),searchContainer.getStart(), searchContainer.getEnd(), searchContainer.getOrderByComparator());
			
			total = LienKetWebsiteLocalServiceUtil.countByTEN_MOTA(searchTerms.getTenWebsite(), searchTerms.getMoTa(),
						searchTerms.isAndOperator());
		} else {
			results = LienKetWebsiteLocalServiceUtil.findByKeywords(searchTerms.getKeywords(),searchContainer.getStart(), searchContainer.getEnd(), 
						searchContainer.getOrderByComparator());
			total = LienKetWebsiteLocalServiceUtil.countByKeywords(searchTerms.getKeywords());
		}
		
		searchContainer.setResults(results);
		searchContainer.setTotal(total);
		
		portletURL.setParameter(searchContainer.getCurParam(), String.valueOf(searchContainer.getCurValue()));
	%>
	<%
	
		List resultRows = searchContainer.getResultRows();
		ResultRow row = null;
		LienKetWebsite lienKetWebsite = null;
		LoaiWebsite loaiWebsite = null;
		long maWebsite = 0;
		String update = "";
		String deleteAction = "";
		String active = "";
		byte[] imageDb = null;
		for ( int i=0; i < results.size(); i++) {
			lienKetWebsite = results.get(i);
			maWebsite = lienKetWebsite.getMaWebsite();
			
			lienKetWebsite = lienKetWebsite.toEscapedModel();
			row = new ResultRow(lienKetWebsite, maWebsite, i);
			
			//STT
			row.addText(String.valueOf(i + 1));
			
			//ten website
			row.addText(lienKetWebsite.getTenWebsite());
			
			// hinh anh
			if (0 == lienKetWebsite.getImageId_liferay()) {
				row.addText("");
			} else {
				row.addText("<img style='width: 100px;height: auto;' src='"+  themeDisplay.getPathImage()+ "/link?img_id="+ lienKetWebsite.getImageId_liferay() +"' />");
			}
			
			// mo ta
			row.addText(lienKetWebsite.getMoTaWebsite());
			
			// loai web site
			String tenLoaiWebsite = "";
			try {
				loaiWebsite = LoaiWebsiteLocalServiceUtil.getLoaiWebsite(lienKetWebsite.getLoaiWebsite());
				tenLoaiWebsite = loaiWebsite.getTenLoaiWebsite();
			} catch (Exception e) {
				tenLoaiWebsite = "";
			}
			row.addText(tenLoaiWebsite);
			
			// thu tu
			row.addText(String.valueOf(lienKetWebsite.getThuTuWebsite()));
			
			// target
			row.addText(lienKetWebsite.getTarget());
			
			//active 
			//URL active
			PortletURL rowURLActive= renderResponse.createActionURL();
			rowURLActive.setWindowState(WindowState.NORMAL);
			rowURLActive.setParameter("struts_action","/nss/link/view");
			rowURLActive.setParameter(Constants.CMD,Constants.LOCK);
			rowURLActive.setParameter("maWebsite", String.valueOf(maWebsite));
			rowURLActive.setParameter("tabDisplay", "display_link");
			rowURLActive.setParameter("tabs", tabs);
			rowURLActive.setParameter("redirect", searchContainer.getIteratorURL().toString());
			
			if (1 == lienKetWebsite.getActive()) {
				active = "<a href='"+ rowURLActive.toString()+"'><img src='/html/images/checked.gif' />&nbsp;</a>";
			} else if (0 == lienKetWebsite.getActive()){
				active = "<a href='"+ rowURLActive.toString()+"'><img src='/html/images/unchecked.gif' />&nbsp;</a>";
			}
			row.addText(active);
			
			// edit
			//URL update
			PortletURL rowURLEdit = renderResponse.createActionURL();
			rowURLEdit.setWindowState(WindowState.NORMAL);
			rowURLEdit.setParameter(Constants.CMD,Constants.EDIT);
			rowURLEdit.setParameter("struts_action","/nss/link/view");
			rowURLEdit.setParameter("maWebsite", String.valueOf(maWebsite));
			rowURLEdit.setParameter("redirect", searchContainer.getIteratorURL().toString());
			rowURLEdit.setParameter("tabDisplay", "add_link");
			rowURLEdit.setParameter("tabs", tabs);
			
			update = "<a href='"+ rowURLEdit.toString()+"'><img src='/html/images/edit.png' />&nbsp;</a>";
			
			row.addText(update);
			
			// delete
			//URL delete
			PortletURL rowURLDelete = renderResponse.createActionURL();
			rowURLDelete.setWindowState(WindowState.NORMAL);
			rowURLDelete.setParameter("struts_action","/nss/link/view");
			rowURLDelete.setParameter(Constants.CMD,Constants.DELETE);
			rowURLDelete.setParameter("maWebsite", String.valueOf(maWebsite));
			rowURLDelete.setParameter("tabDisplay", "display_link");
			rowURLDelete.setParameter("tabs", tabs);
			
			deleteAction = "<a  href='javascript: ;'  onclick=deleteLienKetWebsite('"+ rowURLDelete.toString() +"')><u>"+ "<img src='/html/images/delete.png'/>" +"</u></a>";
			
			row.addText(deleteAction);
			
			resultRows.add(row);
		}
		
	%>
	<liferay-ui:search-iterator searchContainer="<%=searchContainer %>" />
	<img src='/html/portlet/nss/link/displayimage.jsp'/>
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