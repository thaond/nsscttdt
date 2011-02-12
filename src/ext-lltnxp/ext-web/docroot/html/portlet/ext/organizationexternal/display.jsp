<%@ include file="/html/portlet/ext/organizationexternal/init.jsp" %>


<%@page import="javax.portlet.WindowState"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>

<%@page import="com.sgs.portlet.organizationexternal.service.OrganizationExternalLocalServiceUtil"%>
<%@page import="com.sgs.portlet.organizationexternal.model.OrganizationExternal"%>

<script type="text/javascript">
	function deleteOrgExternal(url) {		
		if (confirm("<liferay-ui:message key='sgs_field_deleteMessage'/>" )) {
			document.<portlet:namespace />fm.method = "post";
			submitForm(document.<portlet:namespace />fm, url);
		}
	}
</script>

<%
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action", "/sgs/organizationexternal/view");
%>

<form action="<%= portletURL.toString() %>" method="post" name="<portlet:namespace />fm">
<div class="title_categ"><liferay-ui:message key="to-chuc-lien-thong"/></div>
<div class="boxcontent">
	
	<%
		OrganizationExternalSearch externalSearch = new OrganizationExternalSearch(renderRequest, portletURL);
		OrganizationExternalSearchTerms searchTerms = (OrganizationExternalSearchTerms)externalSearch.getSearchTerms();
	%>
	
	<liferay-ui:search-form
		page="/html/portlet/ext/organizationexternal/org_external_search.jsp"
		searchContainer="<%= externalSearch %>" />
		
	<%
		//URL add
		PortletURL rowURLAdd = renderResponse.createRenderURL();
		rowURLAdd.setWindowState(WindowState.NORMAL);
		rowURLAdd.setParameter("struts_action", "/sgs/organizationexternal/view");
		rowURLAdd.setParameter("tab", "add");
		rowURLAdd.setParameter("redirect", externalSearch.getIteratorURL().toString());
	%>
	
	<span onclick="javascript:submitForm(document.hrefFm,'<%= rowURLAdd.toString() %>');">
	<input class="button-width" type="button" value='<liferay-ui:message key="add_new"/>' /></span> 
	<br/><br/>
		
	<%
		List<OrganizationExternal> results = null;
		int total = 0;
		
		if (searchTerms.isAdvancedSearch()) {
			results = OrganizationExternalLocalServiceUtil.findTEN_MA_DONVILIENTHONG(searchTerms.getMa(), searchTerms.getTen(), searchTerms.isAndOperator(), 
													externalSearch.getStart(), externalSearch.getEnd(), externalSearch.getOrderByComparator());
			total = OrganizationExternalLocalServiceUtil.countByTEN_MA_DONVILIENTHONG(searchTerms.getMa(), searchTerms.getTen(), searchTerms.isAndOperator());
		} 
		else {
			results = OrganizationExternalLocalServiceUtil.findByKeywords(searchTerms.getKeywords(), 
													externalSearch.getStart(), externalSearch.getEnd(), externalSearch.getOrderByComparator());
			total = OrganizationExternalLocalServiceUtil.countByKeywords(searchTerms.getKeywords());
		}
			
		externalSearch.setTotal(total);
		externalSearch.setResults(results);
		
		portletURL.setParameter(externalSearch.getCurParam(), String.valueOf(externalSearch.getCurValue()));
	%>
	
	<%
		List resultRows = externalSearch.getResultRows();
		ResultRow row = null;
		OrganizationExternal orgExternal = null;
		String update = "";
		String deleteAction = "";
		
		for ( int i=0; i< results.size(); i++) {
			orgExternal = results.get(i);
			long orgExternalId = orgExternal.getOrgExternalId();
			
			row = new ResultRow(orgExternal, orgExternalId, i);
			
			//URL update
			PortletURL rowURLEdit = renderResponse.createActionURL();
			rowURLEdit.setWindowState(WindowState.NORMAL);
			rowURLEdit.setParameter(Constants.CMD, Constants.EDIT);
			rowURLEdit.setParameter("struts_action", "/sgs/organizationexternal/view");
			rowURLEdit.setParameter("tab", "add");
			rowURLEdit.setParameter("orgExternalId", orgExternalId+"");
			rowURLEdit.setParameter("redirect", externalSearch.getIteratorURL().toString());
	
			//URL delete
			PortletURL rowURLDelete = renderResponse.createActionURL();
			rowURLDelete.setWindowState(WindowState.NORMAL);
			rowURLDelete.setParameter("struts_action", "/sgs/organizationexternal/view");
			rowURLDelete.setParameter(Constants.CMD, Constants.DELETE);
			rowURLDelete.setParameter("orgExternalId", orgExternalId+"");
			rowURLDelete.setParameter("redirect", externalSearch.getIteratorURL().toString());
			
			update = "<a href='"+ rowURLEdit.toString()+"'><img src='/html/images/edit.png' />&nbsp;</a>";
			deleteAction = "<a href='javascript: ;'  onclick=deleteOrgExternal('" + rowURLDelete.toString() + "')><u>" 
								+ "<img src='/html/images/delete.png'/>" +"</u></a>";
			
			// STT
			row.addText((i+1) + ".");
			
			// ma 
			row.addText("center", "", orgExternal.getOrgExternalCode());
			
			// ten 
			row.addText(orgExternal.getOrgExternalName());
			
			// la don vi lien thong
			if (orgExternal.getIsOwnerOrg() == true) {
				row.addText("<img src='/html/images/checked.gif' />");
			}
			else {
				row.addText("<img src='/html/images/unchecked.gif' />");
			}
			
			// update
			row.addText(update);
			
			// delete
			row.addText(deleteAction);
			
			resultRows.add(row);
		}
	%>

	<liferay-ui:search-iterator searchContainer="<%= externalSearch %>" />
	
</div>
</form>

<% 
	Boolean delete = ParamUtil.getBoolean(renderRequest, "delete", true);
	if (delete != null && !delete) {
	%>
		<script type="text/javascript" >	
				alert("<liferay-ui:message key='khong-the-xoa-dong-nay-vi-co-rang-buoc'/>");
		</script>
	<%	
	}
%>
