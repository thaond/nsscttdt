<%@ include file="/html/portlet/nss/partner/init.jsp" %>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.nss.portlet.partner.search.PartnerSearch"%>
<%@page import="com.nss.portlet.partner.search.PartnerSearchTerms"%>
<%@page import="com.nss.portlet.partner.model.Partner"%>
<%@page import="com.nss.portlet.partner.service.PartnerLocalServiceUtil"%>
<liferay-util:include page="/html/portlet/nss/partner/js/partner-js.jsp"></liferay-util:include>
<%
	String tabDisplay = ParamUtil.getString(request, "tabDisplay", "display_partner");
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action", "/nss/partner/view");
	portletURL.setParameter("tabDisplay", tabDisplay);
%>

<form action="<%= portletURL.toString() %>"  method="post" name="<portlet:namespace />fm" >

	<%
		PartnerSearch searchContainer = new PartnerSearch(renderRequest, portletURL);
		PartnerSearchTerms searchTerms = (PartnerSearchTerms)searchContainer.getSearchTerms();
	%>
	<div class="parent-title"><liferay-ui:message key="javax.portlet.title.NSS_PARTNER" /></div>
	<liferay-ui:search-form page="/html/portlet/nss/partner/search_form.jsp" searchContainer="<%= searchContainer %>" />
		<%
			PortletURL addURL = renderResponse.createRenderURL();
			addURL.setWindowState(WindowState.NORMAL);
			addURL.setParameter("struts_action", "/nss/partner/view");
			addURL.setParameter("tabDisplay", "add_partner");
			addURL.setParameter("redirect", searchContainer.getIteratorURL().toString());
		%>
	<a href="<%= addURL.toString() %>"><span><input class="button-width" type="button" value='<liferay-ui:message key="them-moi"/>' /></span></a>
	<br><br>
	
	<%
		List<Partner> results = null;
		int total = 0;
		
		if (searchTerms.isAdvancedSearch()) {
			results = PartnerLocalServiceUtil.findTEN_MOTA(searchTerms.getTenPartner(), searchTerms.getMoTaPartner(),
					searchTerms.isAndOperator(), searchContainer.getStart(), searchContainer.getEnd(), searchContainer.getOrderByComparator());
			
			total = PartnerLocalServiceUtil.countByTEN_MOTA(searchTerms.getTenPartner(), searchTerms.getMoTaPartner(),
					searchTerms.isAndOperator());
		} 
		else {
			results = PartnerLocalServiceUtil.findByKeywords(searchTerms.getKeywords(), searchContainer.getStart(), searchContainer.getEnd(), 
					searchContainer.getOrderByComparator());
			total = PartnerLocalServiceUtil.countByKeywords(searchTerms.getKeywords());
		}
		
		searchContainer.setResults(results);
		searchContainer.setTotal(total);
		
		portletURL.setParameter(searchContainer.getCurParam(), String.valueOf(searchContainer.getCurValue()));
	%>
	
	<%
		List resultRows = searchContainer.getResultRows();
		ResultRow row = null;
		Partner partner = null;
		long maPartner = 0;
		String update = "";
		String deleteAction = "";
		String active = "";
		byte[] imageDb = null;
		for (int i = 0; i < results.size(); i++) {
			partner = results.get(i);
			maPartner = partner.getMaPartner();
			
			partner = partner.toEscapedModel();
			row = new ResultRow(partner, maPartner, i);
			
			//STT
			row.addText((i + 1) + ".");
			
			//ten partner
			row.addText(partner.getTenPartner());
			
			// hinh anh
			if ("".equals(partner.getImageId_liferay())) {
				row.addText("");
			} else {
				row.addText("<img style='width: 100px; height: auto;' src='"+  themeDisplay.getPathImage()+ "/partner?img_id="+ partner.getImageId_liferay() +"' />");
			}
			
			// mo ta partner
			row.addText(partner.getMoTaPartner());
						
			// thu tu
			row.addText(String.valueOf(partner.getThuTuPartner()));
			
			// target
			row.addText(partner.getTarget());
			
			//active URL active
			PortletURL rowURLActive= renderResponse.createActionURL();
			rowURLActive.setWindowState(WindowState.NORMAL);
			rowURLActive.setParameter("struts_action", "/nss/partner/view");
			rowURLActive.setParameter(Constants.CMD, Constants.LOCK);
			rowURLActive.setParameter("mapartner", String.valueOf(maPartner));
			rowURLActive.setParameter("tabDisplay", "display_partner");
			rowURLActive.setParameter("redirect", searchContainer.getIteratorURL().toString());
			
			if (1 == partner.getActive()) {
				active = "<a href='"+ rowURLActive.toString()+"'><img src='/html/images/checked.gif' />&nbsp;</a>";
			} else if (0 == partner.getActive()){
				active = "<a href='"+ rowURLActive.toString()+"'><img src='/html/images/unchecked.gif' />&nbsp;</a>";
			}
			row.addText(active);
			
			// edit URL update
			PortletURL rowURLEdit = renderResponse.createActionURL();
			rowURLEdit.setWindowState(WindowState.NORMAL);
			rowURLEdit.setParameter(Constants.CMD, Constants.EDIT);
			rowURLEdit.setParameter("struts_action", "/nss/partner/view");
			rowURLEdit.setParameter("mapartner", String.valueOf(maPartner));
			rowURLEdit.setParameter("redirect", searchContainer.getIteratorURL().toString());
			rowURLEdit.setParameter("tabDisplay", "add_partner");
			
			update = "<a href='"+ rowURLEdit.toString()+"'><img src='/html/images/edit.png' />&nbsp;</a>";
			
			row.addText(update);
			
			// delete URL delete
			PortletURL rowURLDelete = renderResponse.createActionURL();
			rowURLDelete.setWindowState(WindowState.NORMAL);
			rowURLDelete.setParameter("struts_action", "/nss/partner/view");
			rowURLDelete.setParameter(Constants.CMD, Constants.DELETE);
			rowURLDelete.setParameter("mapartner", String.valueOf(maPartner));
			rowURLDelete.setParameter("tabDisplay", "display_partner");
			
			deleteAction = "<a href='javascript: ;' onclick=deletePartner('"+ rowURLDelete.toString() +"')><u>"+ "<img src='/html/images/delete.png'/>" +"</u></a>";
			
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