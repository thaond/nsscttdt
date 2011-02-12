<%@ include file="/html/portlet/ext/country/init.jsp"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="com.sgs.portlet.country.search.CountrySearch"%>
<%@page import="com.sgs.portlet.country.search.CountrySearchTerms"%>
<%@page import="com.sgs.portlet.country.service.CountryLocalServiceUtil"%>
<%@page import="javax.portlet.PortletURL"%><body>
<script type="text/javascript">
	function deleteCountry(url) {		
		if (confirm("<liferay-ui:message key='sgs_field_deleteMessage'/>" )) {
			document.<portlet:namespace />fm.method = "post";
			submitForm(document.<portlet:namespace />fm, url);
		}
	}

</script>

<%
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action", "/sgs/country/view" );
%>

<form action="<%=portletURL.toString()%>" method="post" name="<portlet:namespace />fm">
<div class="title_categ"><liferay-ui:message key="country."/></div>
 <div class="boxcontent">
	<%
		CountrySearch countrySearch = new CountrySearch(renderRequest, portletURL);
		CountrySearchTerms searchTerms = (CountrySearchTerms)countrySearch.getSearchTerms();
	%>
	
	
	<liferay-ui:search-form
			page="/html/portlet/ext/country/country_search.jsp"
			searchContainer="<%= countrySearch %>" />
		
		<%
			//URL add
			PortletURL rowURLAdd = renderResponse.createRenderURL();
			rowURLAdd.setWindowState(WindowState.NORMAL);
			rowURLAdd.setParameter("struts_action","/sgs/country/view");
			rowURLAdd.setParameter("tabs1","add");
			rowURLAdd.setParameter("redirect",countrySearch.getIteratorURL().toString());
		%>
		
		<span onclick="javascript:submitForm(document.hrefFm,'<%= rowURLAdd.toString() %>');"><input class="button-width" type="button" value='<liferay-ui:message key="add_new"/>' /></span> 
		<br/><br/>
	<%
		int total = 0;
		
		if (searchTerms.isAdvancedSearch()) {
			total = CountryLocalServiceUtil.countByTEN_MA_MOTA_QUOCGIA(searchTerms.getMa(), searchTerms.getTen(), searchTerms.getMota(), searchTerms.isAndOperator());
		} else {
			total = CountryLocalServiceUtil.countByKeywords(searchTerms.getKeywords());
			
		}
		
		List<Country> results = null;
		if (searchTerms.isAdvancedSearch()) {
			results = CountryLocalServiceUtil.findTEN_MA_MOTA_QUOCGIA(searchTerms.getMa(), searchTerms.getTen(), searchTerms.getMota(), searchTerms.isAndOperator(),
					countrySearch.getStart(), countrySearch.getEnd(), countrySearch.getOrderByComparator());
		} else {
			results = CountryLocalServiceUtil.findByKeywords(searchTerms.getKeywords(),countrySearch.getStart(), countrySearch.getEnd(), countrySearch.getOrderByComparator());
			
		}
		
		countrySearch.setTotal(total);
		countrySearch.setResults(results);
		portletURL.setParameter(countrySearch.getCurParam(), String.valueOf(countrySearch.getCurValue()));
	%>
	
	<%
		List resultRows = countrySearch.getResultRows();
		ResultRow row = null;
		Country country1 = null;
		String update = "";
		String deleteAction = "";
		String active = "";
	
		
		for (int i=0; i < results.size(); i++) {
			country1 =  results.get(i);
			String countryId = country1.getCountryId();
			
			row = new ResultRow(country1, countryId, i);
			
			//URL update
			PortletURL rowURLEdit = renderResponse.createActionURL();
			rowURLEdit.setWindowState(WindowState.NORMAL);
			rowURLEdit.setParameter(Constants.CMD,Constants.EDIT);
			rowURLEdit.setParameter("struts_action","/sgs/country/view");
			rowURLEdit.setParameter("tabs1","add");
			rowURLEdit.setParameter("countryId",countryId);
			rowURLEdit.setParameter("redirect",countrySearch.getIteratorURL().toString());
	
			//URL delete
			PortletURL rowURLDelete = renderResponse.createActionURL();
			rowURLDelete.setWindowState(WindowState.NORMAL);
			rowURLDelete.setParameter("struts_action","/sgs/country/view");
			rowURLDelete.setParameter(Constants.CMD,Constants.DELETE);
			rowURLDelete.setParameter("countryId",countryId);
			rowURLDelete.setParameter("redirect",countrySearch.getIteratorURL().toString());
			
			//URL active
			PortletURL rowURLActive= renderResponse.createActionURL();
			rowURLActive.setWindowState(WindowState.NORMAL);
			rowURLActive.setParameter("struts_action","/sgs/country/view");
			rowURLActive.setParameter(Constants.CMD,Constants.LOCK);
			rowURLActive.setParameter("countryId",countryId);
			rowURLActive.setParameter("redirect",countrySearch.getIteratorURL().toString());
			
			update = "<a href='"+ rowURLEdit.toString()+"'><img src='/html/images/edit.png' />&nbsp;</a>";
			deleteAction = "<a  href='javascript: ;'  onclick=deleteCountry('"+ rowURLDelete.toString() +"')><u>"+ "<img src='/html/images/delete.png'/>" +"</u></a>";
			
			if ("1".equals(country1.getActive())) {
				active = "<a href='"+ rowURLActive.toString()+"'><img src='/html/images/checked.gif' />&nbsp;</a>";
			} else {
				active = "<a href='"+ rowURLActive.toString()+"'><img src='/html/images/unchecked.gif' />&nbsp;</a>";
			}
			
			
			//STT
			row.addText(String.valueOf(i+1));
			
			// ma
			row.addText(country1.getCountryCode());
			
			//ten
			row.addText(country1.getCountryName());
			
			// mo ta
			row.addText(country1.getDescription());
			
			//hoat dong
			row.addText(active);
			
			//sua
			row.addText(update);
			
			//xoa
			row.addText(deleteAction);
			
			resultRows.add(row);
		}
	%>
	<liferay-ui:search-iterator searchContainer="<%=countrySearch %>" />
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
