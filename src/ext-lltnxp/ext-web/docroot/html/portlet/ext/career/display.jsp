<%@ include file="/html/portlet/ext/career/init.jsp" %>

<%@page import="com.sgs.portlet.career.search.CareerSearch"%>
<%@page import="com.sgs.portlet.career.search.CareerSearchTerms"%>
<%@page import="com.sgs.portlet.career.service.CareerLocalServiceUtil"%>
<%@page import="javax.portlet.PortletURL"%>

<script type="text/javascript">

	function deleteCareer(url) {		
		if (confirm("<liferay-ui:message key='sgs_field_deleteMessage'/>" )) {
			document.<portlet:namespace />fm.method = "post";
			submitForm(document.<portlet:namespace />fm, url);
		}
	}

</script>

<%
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action","/sgs/career/view");
%>
<form action="<%= portletURL.toString() %>" method="post" name="<portlet:namespace />fm">
<div class="title_categ"><liferay-ui:message key="carrer.nganhnghe"/></div>
<div class="boxcontent">
	<%
		CareerSearch careerSearch = new CareerSearch(renderRequest, portletURL);
		CareerSearchTerms searchTerms = (CareerSearchTerms)careerSearch.getSearchTerms();
	%>
	
		<liferay-ui:search-form
			page="/html/portlet/ext/career/career_search.jsp"
			searchContainer="<%= careerSearch %>" />
			
		<%
			//URL add
			PortletURL rowURLAdd = renderResponse.createRenderURL();
			rowURLAdd.setWindowState(WindowState.NORMAL);
			rowURLAdd.setParameter("struts_action","/sgs/career/view");
			rowURLAdd.setParameter("tab","add");
			rowURLAdd.setParameter("redirect",careerSearch.getIteratorURL().toString());
		%>
		
		<span onclick="javascript:submitForm(document.hrefFm,'<%= rowURLAdd.toString() %>');"><input class="button-width" type="button" value='<liferay-ui:message key="add_new"/>' /></span> 
		<br/><br/>
		<%
		
		int total = 0;
		
		if (searchTerms.isAdvancedSearch()) {
			total = CareerLocalServiceUtil.countByTEN_MA_NGHENGHIEP(searchTerms.getMa(), searchTerms.getTen(), searchTerms.getMota(),searchTerms.isAndOperator());
		} else {
			total = CareerLocalServiceUtil.countByKeywords(searchTerms.getKeywords());
			
		}
		
		careerSearch.setTotal(total);
		
		List<Career> results = null;
		
		if (searchTerms.isAdvancedSearch()) {
			results = CareerLocalServiceUtil.findTEN_MA_NGHENGHIEP(searchTerms.getMa(), searchTerms.getTen(), searchTerms.getMota(),searchTerms.isAndOperator(),
						careerSearch.getStart(), careerSearch.getEnd(), careerSearch.getOrderByComparator());
		} else {
			results = CareerLocalServiceUtil.findByKeywords(searchTerms.getKeywords(),careerSearch.getStart(), careerSearch.getEnd(), careerSearch.getOrderByComparator());
		}
		
		careerSearch.setResults(results);
		
		portletURL.setParameter(careerSearch.getCurParam(), String.valueOf(careerSearch.getCurValue()));
	%>
	<%
	
		List resultRows = careerSearch.getResultRows();
		ResultRow row = null;
		Career career = null;
		String update = "";
		String active = "";
		String deleteAction = "";
		
		for ( int i=0; i< results.size(); i++) {
			career = results.get(i);
			String careerId = career.getCareerId();
			
			row = new ResultRow(career, careerId, i);
			
			//URL update
			PortletURL rowURLEdit = renderResponse.createActionURL();
			rowURLEdit.setWindowState(WindowState.NORMAL);
			rowURLEdit.setParameter(Constants.CMD,Constants.EDIT);
			rowURLEdit.setParameter("struts_action","/sgs/career/view");
			rowURLEdit.setParameter("tab","add");
			rowURLEdit.setParameter("careerId",careerId);
			rowURLEdit.setParameter("redirect", careerSearch.getIteratorURL().toString());
	
			//URL delete
			PortletURL rowURLDelete = renderResponse.createActionURL();
			rowURLDelete.setWindowState(WindowState.NORMAL);
			rowURLDelete.setParameter("struts_action","/sgs/career/view");
			rowURLDelete.setParameter(Constants.CMD,Constants.DELETE);
			rowURLDelete.setParameter("careerId",careerId);
			rowURLDelete.setParameter("redirect", careerSearch.getIteratorURL().toString());
			
			//URL lock
			PortletURL rowURLActive= renderResponse.createActionURL();
			rowURLActive.setWindowState(WindowState.NORMAL);
			rowURLActive.setParameter("struts_action","/sgs/career/view");
			rowURLActive.setParameter(Constants.CMD,Constants.LOCK);
			rowURLActive.setParameter("careerId",careerId);
			rowURLActive.setParameter("redirect", careerSearch.getIteratorURL().toString());
			
			update = "<a href='"+ rowURLEdit.toString()+"'><img src='/html/images/edit.png' />&nbsp;</a>";
			deleteAction = "<a  href='javascript: ;'  onclick=deleteCareer('"+ rowURLDelete.toString() +"')><u>"+ "<img src='/html/images/delete.png'/>" +"</u></a>";

			if ("1".equals(career.getActive())) {
				active = "<a href='"+ rowURLActive.toString()+"'><img src='/html/images/checked.gif' />&nbsp;</a>";
			} else {
				active = "<a href='"+ rowURLActive.toString()+"'><img src='/html/images/unchecked.gif' />&nbsp;</a>";
			}
			
			// STT
			row.addText(String.valueOf(i+1));
			
			// ma 
			row.addText(career.getCareerCode());
			
			// ten 
			row.addText(career.getCareerName());
			
			// mota 
			row.addText(career.getDescription());
			
			// active
			row.addText(active);
			
			// update
			row.addText(update);
			
			// delete
			row.addText(deleteAction);
			
			resultRows.add(row);
		}
	%>
<liferay-ui:search-iterator searchContainer="<%=careerSearch %>" />
</div>
</form>
<% 
Boolean delete = ParamUtil.getBoolean(renderRequest, "delete", true);
if (delete != null && !delete) {
%>
	<script type="text/javascript" >	
			alert("<liferay-ui:message key='khong-the-xoa-dong-nay-vi-co-ren-buoc'/>");
	</script>
<%	
}
%>


<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="javax.portlet.WindowState"%>