<%@ include file="/html/portlet/ext/pmluser/init.jsp" %>

<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.sgs.portlet.pmluser.search.PmlUserSearch"%>
<%@page import="com.sgs.portlet.pmluser.search.PmlUserSearchTerms"%>
<%@page import="com.sgs.portlet.pmluser.model.PmlUser"%>
<%@page import="com.sgs.portlet.pmluser.service.PmlUserLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.liferay.portal.service.UserLocalServiceUtil"%>
<%@page import="com.sgs.portlet.position.model.Position"%>
<%@page import="com.sgs.portlet.position.service.PositionLocalServiceUtil"%>
<%@page import="com.sgs.portlet.department.model.Department"%>
<%@page import="com.sgs.portlet.department.service.DepartmentLocalServiceUtil"%>
<%@page import="com.ext.portal.util.ConstantsExt"%>
<script type="text/javascript">

	function deletePmlUser(url) {		
		if (confirm("<liferay-ui:message key='are-you-sure-you-want-to-delete-user'/>" )) {
			document.<portlet:namespace />fm.method = "post";
			submitForm(document.<portlet:namespace />fm, url);
		}
	}

</script>

<%
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action", "/sgs/pmluser/view");
%>
	<form action="<%= portletURL.toString() %>"  method="get" name="<portlet:namespace />fm" onSubmit="submitForm(this); return false;">
	<div class="title_categ"><liferay-ui:message key="pml-user"/></div>
	
	<%
		PmlUserSearch pmlUserSearch = new PmlUserSearch(renderRequest, portletURL);
		PmlUserSearchTerms searchTerms = (PmlUserSearchTerms)pmlUserSearch.getSearchTerms();
	%>
	<div class="boxcontent">
	<liferay-ui:search-form
		page="/html/portlet/ext/pmluser/search_form.jsp"
		searchContainer="<%= pmlUserSearch %>" />
	
	     
	<%
		List<PmlUser> results = new ArrayList<PmlUser>();
		int total = 0;
		
		if (searchTerms.isAdvancedSearch()) {
			results = PmlUserLocalServiceUtil.search(searchTerms.getTenGoi(), 
						searchTerms.getHo(), searchTerms.getLot(),
						searchTerms.getTen(), searchTerms.getChucVu(),
						searchTerms.isAndOperator(), pmlUserSearch.getStart(), 
						pmlUserSearch.getEnd(), pmlUserSearch.getOrderByComparator());
			
			total = PmlUserLocalServiceUtil.searchCount(searchTerms.getTenGoi(), 
						searchTerms.getHo(), searchTerms.getLot(),
						searchTerms.getTen(), searchTerms.getChucVu(),
						searchTerms.isAndOperator());
		}
		else {
			results = PmlUserLocalServiceUtil.search(searchTerms.getKeywords(), pmlUserSearch.getStart(),
					pmlUserSearch.getEnd(), pmlUserSearch.getOrderByComparator());
			
			total = PmlUserLocalServiceUtil.searchCount(searchTerms.getKeywords());
		}
		
		pmlUserSearch.setTotal(total);
		
		pmlUserSearch.setResults(results);
		
		portletURL.setParameter(pmlUserSearch.getCurParam(), String.valueOf(pmlUserSearch.getCurValue()));
	%>
	
	<%-- xuancong close start
	<portlet:renderURL var="add_pmluser">
		<portlet:param name="struts_action" value="/sgs/pmluser/view"/>
		<portlet:param name="tab" value="add"/>
		<portlet:param name="<%= Constants.CMD %>" value="<%= Constants.ADD %>"/>
		<portlet:param name="redirect" value="<%= pmlUserSearch.getIteratorURL().toString() %>"/>
	</portlet:renderURL>
		
	<span onclick="javascript:submitForm(document.hrefFm,'<%= add_pmluser %>');" ><input type="button" value='<liferay-ui:message key="add_new" />'/></span>
	xuancong close end --%>
	<portlet:actionURL var="synchronizeURL">
		<portlet:param name="struts_action" value="/sgs/pmluser/view" />
		<portlet:param name="tab" value="list" />
		<portlet:param name="<%= Constants.CMD %>" value="<%= ConstantsExt.SYNCHRONIZE %>" />
	</portlet:actionURL>
		
	<span onclick="javascript:submitForm(document.hrefFm, '<%= synchronizeURL %>');" ><input type="button" value='<liferay-ui:message key="synchronize-user" />' /></span>
	<br /> 
	
	<div id="separator"></div>
	
	<%
		List resultRows = pmlUserSearch.getResultRows();
	
		ResultRow row = null;
		PmlUser pmlUser = null;
		long pmlUserId = 0;
		
		User userP = null;
		String screenName = "";
		String fullName = "";
		String email = "";
		Position position = null;
		String positionName = "";
		Department department = null;
		String departmentName = "";
		String editURL = "";
		String deleteURL = "";
		for (int i = 0; i < results.size(); i ++) {
			pmlUser = (PmlUser) results.get(i);
			pmlUserId = pmlUser.getUserId();
			
			row = new ResultRow(pmlUser, pmlUserId, i);
			
			// STT
			row.addText(String.valueOf(i + 1));		
			
			// ten goi
			try {
				userP = UserLocalServiceUtil.getUser(pmlUser.getUserId());
				screenName = userP.getScreenName();
				fullName = userP.getLastName().concat(" ").concat(userP.getMiddleName()).concat(" ").concat(userP.getFirstName());
				email = userP.getEmailAddress();
			} catch (Exception e) {
				
			}
			row.addText(screenName);
			
			// ten day du
			row.addText(fullName);
			
			// email
			
			row.addText(email);
			
			// chuc vu
			try {
				position = PositionLocalServiceUtil.getPosition(pmlUser.getPositionId());
				positionName = position.getPositionName();
			} catch (Exception e) {
				
			}
			row.addText(positionName);
			positionName = "";
			// phong ban 
			
			try {
				department = DepartmentLocalServiceUtil.getDepartment(pmlUser.getDepartmentsId());
				departmentName = department.getDepartmentsName();
			} catch (Exception e) {
				
			}
			row.addText(departmentName);
			
			// vu vupdate 31122010 can phai gang lai departmentName 
			departmentName  = "";
			// end update
			
			// mo ta 
			row.addText(pmlUser.getNote());
			
			
			// sua		
			PortletURL rowURLEdit = renderResponse.createRenderURL();
			rowURLEdit.setWindowState(WindowState.NORMAL);
			rowURLEdit.setParameter("struts_action", "/sgs/pmluser/view");
			rowURLEdit.setParameter(Constants.CMD, Constants.EDIT);
			rowURLEdit.setParameter("tab", "edit");
			rowURLEdit.setParameter("pmlUserId", String.valueOf(pmlUserId));
			rowURLEdit.setParameter("redirect",  pmlUserSearch.getIteratorURL().toString());
			editURL = "<a  href='" + rowURLEdit.toString() + "'><u>" + "<img src='/html/images/edit.png'/>" + "</u></a>";
			
			row.addText(editURL);
			
			// xoa		
			PortletURL rowURLDelete = renderResponse.createActionURL();
			rowURLDelete.setWindowState(WindowState.NORMAL);
			rowURLDelete.setParameter("struts_action", "/sgs/pmluser/view");
			rowURLDelete.setParameter(Constants.CMD, Constants.DELETE);
			rowURLDelete.setParameter("pmlUserId", String.valueOf(pmlUserId));
			rowURLDelete.setParameter("redirect", pmlUserSearch.getIteratorURL().toString());
			
			deleteURL = "<a  href='javascript: ;'  onclick=deletePmlUser('"+ rowURLDelete.toString() +"')><u>"+ "<img src='/html/images/delete.png'/>" +"</u></a>";
			
			if (pmlUser.getActive() == false) {
				row.addText(deleteURL);
			}
			else {
				row.addText("");
			}
			
			resultRows.add(row);
		}
		
	%>
	<liferay-ui:search-iterator searchContainer="<%= pmlUserSearch %>" />
</div>
</form>
<% 
boolean delete = ParamUtil.getBoolean(renderRequest, "delete", true);
if (!delete) {
%>
	<script type="text/javascript" >	
			alert("<liferay-ui:message key='khong-the-xoa-dong-nay-vi-co-ren-buoc'/>");
	</script>
<%	
}
%>
