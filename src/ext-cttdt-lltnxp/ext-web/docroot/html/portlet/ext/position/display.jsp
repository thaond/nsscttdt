<%@ include file="/html/portlet/ext/position/init.jsp" %>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.sgs.portlet.position.search.PositionSearch"%>
<%@page import="com.sgs.portlet.position.search.PositionSearchTerms"%>
<%@page import="com.sgs.portlet.position.model.Position"%>
<%@page import="com.sgs.portlet.position.service.PositionLocalServiceUtil"%>
<%@page import="com.sgs.portlet.position.PositionCanNotDeleteException"%>
<script type="text/javascript">
	function deletePosition(url) {		
		if (confirm("<liferay-ui:message key='sgs_field_deleteMessage'/>" )) {
			document.<portlet:namespace />fm.method = "post";
			submitForm(document.<portlet:namespace />fm, url);
		}
	}
</script>

<%
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action", "/sgs/position/view");
%>
	<form action="<%= portletURL.toString() %>" method="post" name="<portlet:namespace />fm">
	<liferay-ui:error exception="<%= PositionCanNotDeleteException.class %>" message="can-not-delete-pml-do-quan-trong" />
	<div class="title_categ"><liferay-ui:message key="position"/></div>
	<div class="boxcontent">
	<%
		PositionSearch positionSearch = new PositionSearch(renderRequest, portletURL);
		PositionSearchTerms searchTerms = (PositionSearchTerms)positionSearch.getSearchTerms();
	%>
	
		<liferay-ui:search-form	page="/html/portlet/ext/position/search_form.jsp" searchContainer="<%= positionSearch %>" />	
		<portlet:renderURL var="add">
			<portlet:param name="struts_action" value="/sgs/position/view" />
			<portlet:param name="tabs1" value="add" />
			<portlet:param name="redirect" value="<%= positionSearch.getIteratorURL().toString()%>" />
		</portlet:renderURL>
		<span onclick="javascript:submitForm(document.hrefFm,'<%= add %>');"><input  type="button" value='<liferay-ui:message key="add_new"/>' /></span>		
		
	<%
		List<Position> results = new ArrayList<Position>();
		int total = 0;		
		if (searchTerms.isAdvancedSearch()) {
			results = PositionLocalServiceUtil.find_CODE_NAME_DESCRIPTION(searchTerms.getMa(), searchTerms.getTen(), searchTerms.getMoTa(), 
							searchTerms.isAndOperator(), positionSearch.getStart(), positionSearch.getEnd(), positionSearch.getOrderByComparator());
			total = PositionLocalServiceUtil.count_CODE_NAME_DESCRIPTION(searchTerms.getMa(), searchTerms.getTen(), searchTerms.getMoTa(), searchTerms.isAndOperator());
		}
		else {
			results = PositionLocalServiceUtil.findByKeywords(searchTerms.getKeywords(), positionSearch.getStart(), positionSearch.getEnd(), positionSearch.getOrderByComparator());
			total = PositionLocalServiceUtil.countByKeywords(searchTerms.getKeywords());
		}	
		positionSearch.setTotal(total);		
		positionSearch.setResults(results);		
		portletURL.setParameter(positionSearch.getCurParam(), String.valueOf(positionSearch.getCurValue()));
	%>	
	<div id="separator"></div>
	
	<%
		List resultRows = positionSearch.getResultRows();
		ResultRow row = null;
		Position position = null;
		String positionId = null;		
		String active = "";
		String update = "";
		String delete = "";
		
		for (int i = 0; i < results.size(); i ++) {
			position = results.get(i);
			positionId = position.getPositionId();
			
			row= new ResultRow(position, positionId, i);
			
			// set gia tri cho tung dong position
			row.addText(String.valueOf(i + 1));
			row.addText(position.getPositionCode());
			row.addText(position.getPositionName());
			row.addText(position.getDescription());
			
			// URL active
			PortletURL rowURLActive= renderResponse.createActionURL();
			rowURLActive.setWindowState(WindowState.NORMAL);
			rowURLActive.setParameter("struts_action", "/sgs/position/view");
			rowURLActive.setParameter(Constants.CMD, Constants.LOCK);
			rowURLActive.setParameter("positionId", positionId);
			rowURLActive.setParameter("redirect", positionSearch.getIteratorURL().toString());
			
			// URL edit
			PortletURL rowURLEdit = renderResponse.createRenderURL();
			rowURLEdit.setWindowState(WindowState.NORMAL);
			rowURLEdit.setParameter(Constants.CMD, Constants.EDIT);
			rowURLEdit.setParameter("struts_action", "/sgs/position/view");
			rowURLEdit.setParameter("positionId", positionId);
			rowURLEdit.setParameter("tabs1", "add");
			rowURLEdit.setParameter("redirect", positionSearch.getIteratorURL().toString());
	
			//URL delete
			PortletURL rowURLDelete = renderResponse.createActionURL();
			rowURLDelete.setWindowState(WindowState.NORMAL);
			rowURLDelete.setParameter("struts_action", "/sgs/position/view");
			rowURLDelete.setParameter(Constants.CMD, Constants.DELETE);
			rowURLDelete.setParameter("positionId", positionId);
			rowURLDelete.setParameter("redirect", positionSearch.getIteratorURL().toString());
			
			update = "<a href='" + rowURLEdit.toString() + "'><img src='/html/images/edit.png' />&nbsp;</a>";
			delete = "<a  href='javascript: ;'  onclick=deletePosition('"+ rowURLDelete.toString() +"')><u>"+ "<img src='/html/images/delete.png'/>" +"</u></a>";
			
			if ("1".equals(position.getActive())) {
				active = "<a href='"+ rowURLActive.toString()+"'><img src='/html/images/checked.gif' />&nbsp;</a>";
			} else {
				active = "<a href='"+ rowURLActive.toString()+"'><img src='/html/images/unchecked.gif' />&nbsp;</a>";
			}
			
			// add action
			row.addText(active);
			row.addText(update);
			row.addText(delete);
			
			resultRows.add(row);
		}
		
	%>
	
	<liferay-ui:search-iterator searchContainer="<%=positionSearch %>" />
</div>	
</form>


