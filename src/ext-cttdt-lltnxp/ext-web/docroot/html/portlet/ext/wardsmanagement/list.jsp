<%@ include file="/html/portlet/ext/wardsmanagement/init.jsp" %>


<%@page import="com.sgs.portlet.districtmanagement.model.District"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="javax.portlet.WindowState"%>


<%@page import="com.sgs.portlet.wardsmanagement.search.WardSearch"%>
<%@page import="com.sgs.portlet.wardsmanagement.search.WardSearchTerms"%>
<%@page import="com.sgs.portlet.wardsmanagement.model.Wards"%>
<%@page import="com.sgs.portlet.wardsmanagement.service.WardsLocalServiceUtil"%>
<%@page import="com.sgs.portlet.districtmanagement.service.DistrictLocalServiceUtil"%>

<script type="text/javascript">

	function deleteWards(url) {		
		if (confirm("<liferay-ui:message key='sgs_field_deleteMessage'/>" )) {
			document.<portlet:namespace />fm.method = "post";
			submitForm(document.<portlet:namespace />fm, url);
		}
	}

</script>

<%
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action", "/sgs/wardsmanagement/view" );
%>

<form action="<%= portletURL.toString() %>" method="post" name="<portlet:namespace />fm">
<div class="title_categ"><liferay-ui:message key="wards-management"/></div>
<div class="boxcontent">
	<%
	 	WardSearch wardSearch = new WardSearch(renderRequest, portletURL);
		WardSearchTerms searchTerms = (WardSearchTerms)wardSearch.getSearchTerms();
	%>
	
	<liferay-ui:search-form
			page="/html/portlet/ext/wardsmanagement/wards_search.jsp"
			searchContainer="<%= wardSearch %>" />
		<%
		//URL add
		PortletURL rowURLAdd = renderResponse.createRenderURL();
		rowURLAdd.setWindowState(WindowState.NORMAL);
		rowURLAdd.setParameter("cmd","add");
		rowURLAdd.setParameter("struts_action","/sgs/wardsmanagement/view");
		rowURLAdd.setParameter("tab","add");
		rowURLAdd.setParameter("redirect",wardSearch.getIteratorURL().toString());
		%>
		
		<span onclick="javascript:submitForm(document.hrefFm,'<%= rowURLAdd.toString() %>');"><input class="button-width" type="button" value='<liferay-ui:message key="add_new"/>' /></span>
		<br/><br/>
	<%
		int total = 0;
		
		if (searchTerms.isAdvancedSearch()) {
			total = WardsLocalServiceUtil.countByTEN_MA_MOTA_PHUONG(searchTerms.getMa(), searchTerms.getTen(), searchTerms.getMota(), searchTerms.isAndOperator());
		} else {
			total = WardsLocalServiceUtil.countByKeywords(searchTerms.getKeywords());
			
		}
		
		List<Wards> results = null;
		if (searchTerms.isAdvancedSearch()) {
			results = WardsLocalServiceUtil.findTEN_MA_MOTA_PHUONG(searchTerms.getMa(), searchTerms.getTen(), searchTerms.getMota(), searchTerms.isAndOperator(),
					wardSearch.getStart(), wardSearch.getEnd(), wardSearch.getOrderByComparator());
		} else {
			results = WardsLocalServiceUtil.findByKeywords(searchTerms.getKeywords(),wardSearch.getStart(), wardSearch.getEnd(), wardSearch.getOrderByComparator());
			
		}
		
		wardSearch.setTotal(total);
		wardSearch.setResults(results);
		portletURL.setParameter(wardSearch.getCurParam(), String.valueOf(wardSearch.getCurValue()));
	%>
	
	<%
		List resultRows = wardSearch.getResultRows();
		ResultRow row = null;
		Wards wards = null;
		District district = null;
		String update = "";
		String deleteAction = "";
		String active = "";
	
		
		for (int i=0; i < results.size(); i++) {
			wards =  results.get(i);
			String wardsId = wards.getWardsId();
			String tenQuan = "";
			row = new ResultRow(wards, wardsId, i);
			
			
			//URL update
			PortletURL rowURLEdit = renderResponse.createRenderURL();
			rowURLEdit.setWindowState(WindowState.NORMAL);
			rowURLEdit.setParameter("cmd","edit");
			rowURLEdit.setParameter("struts_action","/sgs/wardsmanagement/view");
			rowURLEdit.setParameter("tab","edit");
			rowURLEdit.setParameter("wardsId",wardsId);
			rowURLEdit.setParameter("redirect",wardSearch.getIteratorURL().toString());
	
			//URL delete
			PortletURL rowURLDelete = renderResponse.createActionURL();
			rowURLDelete.setWindowState(WindowState.NORMAL);
			rowURLDelete.setParameter("struts_action","/sgs/wardsmanagement/view");
			rowURLDelete.setParameter("cmd","delete");
			rowURLDelete.setParameter("wardsId",wardsId);
			rowURLDelete.setParameter("redirect",wardSearch.getIteratorURL().toString());
			
			//URL active
			PortletURL rowURLActive= renderResponse.createRenderURL();
			rowURLActive.setWindowState(WindowState.NORMAL);
			rowURLActive.setParameter("struts_action","/sgs/wardsmanagement/view");
			rowURLActive.setParameter("cmd","active");
			rowURLActive.setParameter("wardsId",wardsId);
			rowURLActive.setParameter("redirect",wardSearch.getIteratorURL().toString());
			
			update = "<a href='"+ rowURLEdit.toString()+"'><img src='/html/images/edit.png' />&nbsp;</a>";
			deleteAction = "<a  href='javascript: ;'  onclick=deleteWards('"+ rowURLDelete.toString() +"')><u>"+ "<img src='/html/images/delete.png'/>" +"</u></a>";
			
			if ("1".equals(wards.getActive())) {
				active = "<a href='"+ rowURLActive.toString()+"'><img src='/html/images/checked.gif' />&nbsp;</a>";
			} else {
				active = "<a href='"+ rowURLActive.toString()+"'><img src='/html/images/unchecked.gif' />&nbsp;</a>";
			}
			
			
			//STT
			row.addText(String.valueOf(i+1));
			
			// ma
			row.addText(wards.getWardsCode());
			
			//ten
			row.addText(wards.getWardsName());
			
			// mo ta
			row.addText(wards.getDescription());
			
			// quan
			try {
				district = DistrictLocalServiceUtil.getDistrict(wards.getDistrictId());
			} catch (Exception e) {}
			
			if ( null != district ) {
				tenQuan = district.getDistrictName();
			}
			row.addText(tenQuan);
			
			//hoat dong
			row.addText(active);
			
			//sua
			row.addText(update);
			
			//xoa
			row.addText(deleteAction);
			
			resultRows.add(row);
		}
	%>
	<liferay-ui:search-iterator searchContainer="<%=wardSearch %>" />
</div>
</form>
<% 
Boolean delete = ParamUtil.getBoolean(renderRequest,"delete",true);
if (delete != null && !delete) {
%>
	<script type="text/javascript" >	
			alert("<liferay-ui:message key='khong-the-xoa-dong-nay-vi-co-ren-buoc'/>");
	</script>
<%	
}
%>
