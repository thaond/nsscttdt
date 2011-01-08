<%@ include file="/html/portlet/ext/nation/init.jsp" %>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.sgs.portlet.nation.search.NationSearch"%>
<%@page import="com.sgs.portlet.nation.search.NationSearchTerms"%>
<%@page import="com.sgs.portlet.nation.service.NationLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@page import="com.sgs.portlet.country.model.Country"%>
<%@page import="com.sgs.portlet.country.service.CountryLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>

<script type="text/javascript">

	function deleteNation(url) {		
		if (confirm("<liferay-ui:message key='sgs_field_deleteMessage'/>" )) {
			document.<portlet:namespace />fm.method = "post";
			submitForm(document.<portlet:namespace />fm, url);
		}
	}

</script>
<%
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action", "/sgs/nation/view" );
%>


<form action="<%= portletURL.toString() %>" method="post"	name="<portlet:namespace />fm">
<div class="title_categ"><liferay-ui:message key="dantoc."/></div>
 <div class="boxcontent">
	<%
		NationSearch nationSearch = new NationSearch(renderRequest, portletURL);
		NationSearchTerms searchTerms = (NationSearchTerms)nationSearch.getSearchTerms();
	%>
	
		<liferay-ui:search-form
			page="/html/portlet/ext/nation/nation_search.jsp"
			searchContainer="<%= nationSearch %>" />
		
		<%
		//URL add
		PortletURL rowURLAdd = renderResponse.createRenderURL();
		rowURLAdd.setWindowState(WindowState.NORMAL);
		rowURLAdd.setParameter("struts_action","/sgs/nation/view");
		rowURLAdd.setParameter("tabs1","add");
		rowURLAdd.setParameter("redirect",nationSearch.getIteratorURL().toString());
		%>
		
		<span onclick="javascript:submitForm(document.hrefFm,'<%= rowURLAdd.toString() %>');"><input class="button-width" type="button" value='<liferay-ui:message key="add_new"/>' /></span>
		<br/><br/>
	<%
		int total = 0;
		
		if (searchTerms.isAdvancedSearch()) {
			total = NationLocalServiceUtil.countByTEN_MA_MOTA_QUOCGIA(searchTerms.getMa(), searchTerms.getTen(), searchTerms.getMota(), searchTerms.isAndOperator());
		} else {
			total = NationLocalServiceUtil.countByKeywords(searchTerms.getKeywords());
			
		}
		
		List<Nation> results = null;
		if (searchTerms.isAdvancedSearch()) {
			results = NationLocalServiceUtil.findTEN_MA_MOTA_QUOCGIA(searchTerms.getMa(), searchTerms.getTen(), searchTerms.getMota(), searchTerms.isAndOperator(),
					nationSearch.getStart(), nationSearch.getEnd(), nationSearch.getOrderByComparator());
		} else {
			results = NationLocalServiceUtil.findByKeywords(searchTerms.getKeywords(),nationSearch.getStart(), nationSearch.getEnd(), nationSearch.getOrderByComparator());
			
		}
		
		nationSearch.setTotal(total);
		nationSearch.setResults(results);
		portletURL.setParameter(nationSearch.getCurParam(), String.valueOf(nationSearch.getCurValue()));
	%>
	
	<%
		List resultRows = nationSearch.getResultRows();
		ResultRow row = null;
		Nation nation = null;
		Country country1 = null;
		String update = "";
		String deleteAction = "";
		String active = "";
	
		
		for (int i=0; i < results.size(); i++) {
			nation =  results.get(i);
			String nationId = nation.getNationId();
			String quocGia = "";
			
			row = new ResultRow(nation, nationId, i);
			
			//URL update
			PortletURL rowURLEdit = renderResponse.createRenderURL();
			rowURLEdit.setWindowState(WindowState.NORMAL);
			rowURLEdit.setParameter(Constants.CMD,Constants.EDIT);
			rowURLEdit.setParameter("struts_action","/sgs/nation/view");
			rowURLEdit.setParameter("tabs1","add");
			rowURLEdit.setParameter("nationId",nationId);
			rowURLEdit.setParameter("redirect",nationSearch.getIteratorURL().toString());
	
			//URL delete
			PortletURL rowURLDelete = renderResponse.createActionURL();
			rowURLDelete.setWindowState(WindowState.NORMAL);
			rowURLDelete.setParameter("struts_action","/sgs/nation/view");
			rowURLDelete.setParameter(Constants.CMD,Constants.DELETE);
			rowURLDelete.setParameter("nationId",nationId);
			rowURLDelete.setParameter("redirect",nationSearch.getIteratorURL().toString());
			
			//URL active
			PortletURL rowURLActive= renderResponse.createRenderURL();
			rowURLActive.setWindowState(WindowState.NORMAL);
			rowURLActive.setParameter("struts_action","/sgs/nation/view");
			rowURLActive.setParameter(Constants.CMD,Constants.LOCK);
			rowURLActive.setParameter("nationId",nationId);
			rowURLActive.setParameter("redirect",nationSearch.getIteratorURL().toString());
			
			update = "<a href='"+ rowURLEdit.toString()+"'><img src='/html/images/edit.png' />&nbsp;</a>";
			deleteAction = "<a  href='javascript: ;'  onclick=deleteNation('"+ rowURLDelete.toString() +"')><u>"+ "<img src='/html/images/delete.png'/>" +"</u></a>";
			
			if ("1".equals(nation.getActive())) {
				active = "<a href='"+ rowURLActive.toString()+"'><img src='/html/images/checked.gif' />&nbsp;</a>";
			} else {
				active = "<a href='"+ rowURLActive.toString()+"'><img src='/html/images/unchecked.gif' />&nbsp;</a>";
			}
			
			
			//STT
			row.addText(String.valueOf(i+1));
			
			// ma
			row.addText(nation.getNationCode());
			
			//ten
			row.addText(nation.getNationName());
			
			// quoc gia
			try {
				country1 = CountryLocalServiceUtil.getCountry(nation.getCountryId());
			} catch (Exception e) {}
			
			if ( null != country1) {
				quocGia = country1.getCountryName();
			}
			row.addText(quocGia);
			
			// mo ta
			row.addText(nation.getDescription());
			
			//hoat dong
			row.addText(active);
			
			//sua
			row.addText(update);
			
			//xoa
			row.addText(deleteAction);
			
			resultRows.add(row);
		}
	%>
	<liferay-ui:search-iterator searchContainer="<%=nationSearch %>" />
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

