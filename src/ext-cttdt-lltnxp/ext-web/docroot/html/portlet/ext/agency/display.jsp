<%@page import="com.ext.portal.util.ConstantsExt"%>
<%@ include file="/html/portlet/ext/agency/init.jsp" %>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.liferay.portal.NoSuchUserException"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.sgs.portlet.agency.search.AgencySearch"%>
<%@page import="com.sgs.portlet.agency.search.AgencySearchTerms"%>
<%@page import="com.sgs.portlet.agency.service.AgencyLocalServiceUtil"%>
<%@page import="com.sgs.portlet.onedoor.model.PmlAgencyLeader"%>
<%@page import="com.sgs.portlet.agency.service.AgencyLocalServiceUtil"%>
<%@page import="com.sgs.portlet.onedoor.NoSuchPmlAgencyLeaderException"%>
<%@page import="com.liferay.portal.service.UserLocalServiceUtil"%>
<%@page import="com.sgs.portlet.onedoor.service.PmlAgencyLeaderLocalServiceUtil"%>
<%@page import="com.sgs.portlet.agency.AgencyCanNotDeleteException"%>

<script type="text/javascript">
	function deleteAgency(url) {		
		if (confirm("<liferay-ui:message key='sgs_field_deleteMessage'/>" )) {
			document.<portlet:namespace />fm.method = "post";
			submitForm(document.<portlet:namespace />fm, url);
		}
	}

</script>

<%
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action", "/sgs/agency/view");
%>

	<form action="<%= portletURL.toString() %>" method="post" name="<portlet:namespace />fm">
	<div class="title_categ"><liferay-ui:message key="agency"/></div>
		<liferay-ui:error exception="<%= AgencyCanNotDeleteException.class %>" message="can-not-delete-pml-do-quan-trong" />
		
	<%
		AgencySearch agencySearch = new AgencySearch(renderRequest,portletURL);
		AgencySearchTerms searchTerms = (AgencySearchTerms)agencySearch.getSearchTerms();
	%>
	<div class="boxcontent">
		<liferay-ui:search-form	page="/html/portlet/ext/agency/search_form.jsp"	searchContainer="<%= agencySearch %>" />	
		<portlet:renderURL var="add">
			<portlet:param name="struts_action" value="/sgs/agency/view" />
			<portlet:param name="tabs1" value="add" />
			<portlet:param name="redirect" value="<%= agencySearch.getIteratorURL().toString()%>" />
	</portlet:renderURL>
		
		<span onclick="javascript:submitForm(document.hrefFm,'<%= add %>');"><input  type="button" value='<liferay-ui:message key="add_new"/>' /></span> 
		<br/><br/>
	<%
	
		List<Agency> results = null;
		int total = 0;
		
		if (searchTerms.isAdvancedSearch()) {
			results = AgencyLocalServiceUtil.search(searchTerms.getHo(), searchTerms.getTen(),searchTerms.getMa(), searchTerms.getTenCoQuan(),
													searchTerms.isAndOperator(),agencySearch.getStart(), agencySearch.getEnd(), agencySearch.getOrderByComparator());
		} else {
			results = AgencyLocalServiceUtil.search(searchTerms.getKeywords(),agencySearch.getStart(), agencySearch.getEnd(), agencySearch.getOrderByComparator());
		}
		
		agencySearch.setResults(results);
		
		
		if (searchTerms.isAdvancedSearch()) {
			total = AgencyLocalServiceUtil.searchCount(searchTerms.getHo(), searchTerms.getTen(),searchTerms.getMa(), searchTerms.getTenCoQuan(),
														searchTerms.isAndOperator());
		} else {
			total = AgencyLocalServiceUtil.searchCount(searchTerms.getKeywords());
			
		}
		
		agencySearch.setTotal(total);
		
		portletURL.setParameter(agencySearch.getCurParam(), String.valueOf(agencySearch.getCurValue()));
	%>
	
	<%
		List resultRows = agencySearch.getResultRows();
		ResultRow row = null;
		Agency agency = null;
		PmlAgencyLeader pmlAgencyLeader = null;
		User userAgency = null;
		String userFullName = "";
		String update = "";
		String deleteAction = "";
		String active = "";
	
		for (int i = 0; i < results.size(); i++) {
			agency = results.get(i);
			
			row = new ResultRow(agency, agency.getAgencyId(), i);
			
			//STT
			row.addText(String.valueOf(i+1));
			
			//Ten lanh dao
			try {
				pmlAgencyLeader = PmlAgencyLeaderLocalServiceUtil.getPmlAgencyLeader(agency.getAgencyId());
			} catch (NoSuchPmlAgencyLeaderException e) {
				pmlAgencyLeader = null;
			}
			
			if (null!= pmlAgencyLeader) {
				try {
					userAgency = UserLocalServiceUtil.getUser(pmlAgencyLeader.getUserId());
				} catch(NoSuchUserException e){
					userAgency = null;
				}
				
				if (null!= userAgency) {
					userFullName = userAgency.getLastName()+" "+ userAgency.getMiddleName()+" "+ userAgency.getFirstName();
					row.addText(userFullName);
				} else {
					row.addText("");
				}
			} else {
				row.addText("");
			}
			//URL update
			PortletURL rowURLEdit = renderResponse.createRenderURL();
			rowURLEdit.setWindowState(WindowState.NORMAL);
			rowURLEdit.setParameter(Constants.CMD,Constants.EDIT);
			rowURLEdit.setParameter("struts_action","/sgs/agency/view");
			rowURLEdit.setParameter("agencyId",agency.getAgencyId());
			rowURLEdit.setParameter("tabs1","add");
			rowURLEdit.setParameter("userAgencyId", String.valueOf(userAgency.getUserId()));
			rowURLEdit.setParameter("redirect", agencySearch.getIteratorURL().toString());		
	
			//URL delete
			PortletURL rowURLDelete = renderResponse.createActionURL();
			rowURLDelete.setWindowState(WindowState.NORMAL);
			rowURLDelete.setParameter("struts_action","/sgs/agency/view");
			rowURLDelete.setParameter(Constants.CMD,Constants.DELETE);
			rowURLDelete.setParameter("agencyId",agency.getAgencyId());
			rowURLDelete.setParameter("redirect", agencySearch.getIteratorURL().toString());
			
			//URL lock
			PortletURL rowURLActive= renderResponse.createActionURL();
			rowURLActive.setWindowState(WindowState.NORMAL);
			rowURLActive.setParameter("struts_action","/sgs/agency/view");
			rowURLActive.setParameter(Constants.CMD,Constants.LOCK);
			rowURLActive.setParameter("agencyId",agency.getAgencyId());
			rowURLActive.setParameter("redirect", agencySearch.getIteratorURL().toString());
			
			update = "<a href='"+ rowURLEdit.toString()+"'><img src='/html/images/edit.png' />&nbsp;</a>";
			deleteAction = "<a  href='javascript: ;'  onclick=deleteAgency('"+ rowURLDelete.toString() +"')><u>"+ "<img src='/html/images/delete.png'/>" +"</u></a>";
			
			if ("1".equals(agency.getActive())) {
				active = "<a href='"+ rowURLActive.toString()+"'><img src='/html/images/checked.gif' />&nbsp;</a>";
			} else {
				active = "<a href='"+ rowURLActive.toString()+"'><img src='/html/images/unchecked.gif' />&nbsp;</a>";
			}
			
			//Ma co quan
			row.addText(agency.getAgencyCode());
			//Ten co quan
			row.addText(agency.getAgencyName());
			//mo ta
			row.addText(agency.getDescription());
			//hoat dong
			row.addText(active);
			//edit
			row.addText(update);
			//delete
			row.addText(deleteAction);
			
			resultRows.add(row);
	}
	%>
		<liferay-ui:search-iterator searchContainer="<%=agencySearch %>" />
		</div>
	</form>
