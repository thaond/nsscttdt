<%@ include file="/html/portlet/ext/districtmanagement/init.jsp" %>

<%@page import="com.sgs.portlet.districtmanagement.search.DistrictSearch"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.sgs.portlet.districtmanagement.search.DistrictSearchTerms"%>
<%@page import="com.sgs.portlet.districtmanagement.service.DistrictLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@page import="com.sgs.portlet.districtmanagement.model.District"%>
<%@page import="com.sgs.portlet.citymanagement.model.City"%>
<%@page import="com.sgs.portlet.citymanagement.service.CityLocalServiceUtil"%>
<%@page import="com.sgs.portlet.districtmanagement.DistrictCanNotDeleteException"%>

<script type="text/javascript">

	function deleteDistrict(url) {		
		if (confirm("<liferay-ui:message key='sgs_field_deleteMessage'/>" )) {
			document.<portlet:namespace />fm.method = "post";
			submitForm(document.<portlet:namespace />fm, url);
		}
	}

</script>

<%
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action", "/sgs/districtmanagement/view" );
%>
<form action="<%=portletURL.toString() %>" method="post" name="<portlet:namespace />fm">
<div class="title_categ"><liferay-ui:message key="districtmanagement.head"/></div>
<div class="boxcontent">
	<input name="<portlet:namespace />districtURL" type="hidden" value="<%= portletURL.toString() %>" />
	<liferay-ui:error exception="<%= DistrictCanNotDeleteException.class %>" message="can-not-delete-pml-do-quan-trong" />

	<%
		DistrictSearch districtSearch = new DistrictSearch(renderRequest, portletURL);
		DistrictSearchTerms searchTerms = (DistrictSearchTerms)districtSearch.getSearchTerms();
	%>	
		
	<liferay-ui:search-form
			page="/html/portlet/ext/districtmanagement/district_search.jsp"
			searchContainer="<%= districtSearch %>" />
		
		<%
		//URL add
		PortletURL rowURLAdd = renderResponse.createRenderURL();
		rowURLAdd.setWindowState(WindowState.NORMAL);
		rowURLAdd.setParameter("struts_action","/sgs/districtmanagement/view");
		rowURLAdd.setParameter("cmd","add");
		rowURLAdd.setParameter("tab","add");
		rowURLAdd.setParameter("redirect",districtSearch.getIteratorURL().toString());
		%>
		
		<span onclick="javascript:submitForm(document.hrefFm,'<%= rowURLAdd.toString() %>');"><input class="button-width" type="button" value='<liferay-ui:message key="add_new"/>' /></span> 
		<br/><br/>
	
	<%
	
		int total = 0;
		
		if (searchTerms.isAdvancedSearch()) {
			total = DistrictLocalServiceUtil.countByTEN_MA_MOTA_QUAN(searchTerms.getMa(), searchTerms.getTen(), searchTerms.getMota(), searchTerms.isAndOperator());
		} else {
			total = DistrictLocalServiceUtil.countByKeywords(searchTerms.getKeywords());
			
		}
		
		List<District> results = null;
		if (searchTerms.isAdvancedSearch()) {
			results = DistrictLocalServiceUtil.findTEN_MA_MOTA_QUAN(searchTerms.getMa(), searchTerms.getTen(), searchTerms.getMota(), searchTerms.isAndOperator(),
					districtSearch.getStart(), districtSearch.getEnd(), districtSearch.getOrderByComparator());
		} else {
			results = DistrictLocalServiceUtil.findByKeywords(searchTerms.getKeywords(),districtSearch.getStart(), districtSearch.getEnd(), districtSearch.getOrderByComparator());
			
		}
		
		districtSearch.setTotal(total);
		districtSearch.setResults(results);
		portletURL.setParameter(districtSearch.getCurParam(), String.valueOf(districtSearch.getCurValue()));
	%>
	
	<%
		List resultRows = districtSearch.getResultRows();
		ResultRow row = null;
		District district = null;
		City city = null;
		String update = "";
		String deleteAction = "";
		String active = "";
	
		
		for (int i=0; i < results.size(); i++) {
			district =  results.get(i);
			String districtId = district.getDistrictId();
			String cityName = "";
			
			row = new ResultRow(district, districtId, i);
			
			//URL update
			PortletURL rowURLEdit = renderResponse.createRenderURL();
			rowURLEdit.setWindowState(WindowState.NORMAL);
			rowURLEdit.setParameter(Constants.CMD,Constants.EDIT);
			rowURLEdit.setParameter("struts_action","/sgs/districtmanagement/view");
			rowURLEdit.setParameter("tab","edit");
			rowURLEdit.setParameter("cmd","edit");
			rowURLEdit.setParameter("districtId",districtId);
			rowURLEdit.setParameter("redirect",districtSearch.getIteratorURL().toString());
	
			//URL delete
			PortletURL rowURLDelete = renderResponse.createActionURL();
			rowURLDelete.setWindowState(WindowState.NORMAL);
			rowURLDelete.setParameter("struts_action","/sgs/districtmanagement/view");
			rowURLDelete.setParameter(Constants.CMD,Constants.DELETE);
			rowURLDelete.setParameter("cmd","delete");
			rowURLDelete.setParameter("districtId",districtId);
			rowURLDelete.setParameter("redirect",districtSearch.getIteratorURL().toString());
			
			//URL active
			PortletURL rowURLActive= renderResponse.createActionURL();
			rowURLActive.setWindowState(WindowState.NORMAL);
			rowURLActive.setParameter("struts_action","/sgs/districtmanagement/view");
			rowURLActive.setParameter(Constants.CMD,Constants.LOCK);
			rowURLActive.setParameter("cmd","active");
			rowURLActive.setParameter("districtId",districtId);
			rowURLActive.setParameter("redirect",districtSearch.getIteratorURL().toString());
			
			update = "<a href='"+ rowURLEdit.toString()+"'><img src='/html/images/edit.png' />&nbsp;</a>";
			deleteAction = "<a  href='javascript: ;'  onclick=deleteDistrict('"+ rowURLDelete.toString() +"')><u>"+ "<img src='/html/images/delete.png'/>" +"</u></a>";
			
			if ("1".equals(district.getActive())) {
				active = "<a href='"+ rowURLActive.toString()+"'><img src='/html/images/checked.gif' />&nbsp;</a>";
			} else {
				active = "<a href='"+ rowURLActive.toString()+"'><img src='/html/images/unchecked.gif' />&nbsp;</a>";
			}
			
			
			//STT
			row.addText(String.valueOf(i+1));
			
			// ma
			row.addText(district.getDistrictCode());
			
			//ten
			row.addText(district.getDistrictName());
			
			// mo ta
			row.addText(district.getDescription());
			
			//tinh/ TP
			try {
				city = CityLocalServiceUtil.getCity(district.getCityID());
			} catch (Exception e) {}
			
			if (null != city) {
				cityName = city.getCityName();
			}
			row.addText(cityName);
			
			//hoat dong
			row.addText(active);
			
			//sua
			row.addText(update);
			
			//xoa
			row.addText(deleteAction);
			
			resultRows.add(row);
		}
	%>
	<liferay-ui:search-iterator searchContainer="<%=districtSearch %>" />
</div>
</form>
	