<%@page import="com.sgs.portlet.report_registry_work.search.DepartmentSearchTerms"%>
<%@page import="com.sgs.portlet.report_registry_work.search.DepartmentDisplayTerms"%>
<%@page import="com.sgs.portlet.report_registry_work.search.DepartmentSearch"%>
<%@ include file="/html/portlet/ext/report_registry_work/init.jsp" %>

<%
	String tabs1 = ParamUtil.getString(renderRequest, "tabs1", "Department");
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action", "/sgs/report_registry_work/view");
	portletURL.setParameter("tabs1", tabs1);
	String portletURLString = portletURL.toString();
	request.setAttribute("portletURL", portletURL);
%>

<liferay-ui:tabs names="Department,Report-Registry" url="<%= portletURLString %>" />
	
	<c:choose>
		<c:when test='<%=tabs1.equals("Department") %>'>
		<portlet:renderURL var="add_department">
			<portlet:param name="struts_action" value="/sgs/report_registry_work/view" />
		</portlet:renderURL>
			<a href="<%=add_department%>"><span><input type="button" value="<liferay-ui:message key='Add-Department' />" /></span></a>
			<form action="<%= portletURL.toString() %>"  method="post" name="<portlet:namespace />fm" >
    	<%
			DepartmentSearch departmentSearch = new DepartmentSearch(renderRequest, portletURL);
    		DepartmentDisplayTerms displayTerms = (DepartmentDisplayTerms)departmentSearch.getDisplayTerms();
    		DepartmentSearchTerms searchTerms = (DepartmentSearchTerms) departmentSearch.getSearchTerms();
    		
	   		String orderByCol = ParamUtil.getString(renderRequest, "orderByCol", DepartmentDisplayTerms.DEPARTMENTNAME);
    		int sortType = Sort.STRING_TYPE;
    		String orderByType = departmentSearch.getOrderByType().toLowerCase();
    		
    		boolean reverse = false;
    		if (orderByType.equals("desc")) {
    			reverse = true;
    		} 
		%>
	<div class="commom-form">
		<div class="titlecategr" style="margin-bottom: 15px;"><h4><p><liferay-ui:message key="sgs-report-registry-work" /></p></h4></div>
		<liferay-ui:search-form	page="/html/portlet/sgs/report_registry_work/department_search_form.jsp" searchContainer="<%= departmentSearch %>" />
			<%
				PortletURL addURL = renderResponse.createRenderURL();
				addURL.setWindowState(WindowState.NORMAL);
				addURL.setParameter("struts_action", "/sgs/report-registry-work/view");
				addURL.setParameter("redirect", departmentSearch.getIteratorURL().toString());
			%>
		<a href="<%= addURL.toString() %>"><span><input class="button-width" type="button" value='<liferay-ui:message key="Add-Department"/>' /></span></a>
		<br><br>
		
				<%
				int count = 0;
				List<ContactBook> listContactBook = new ArrayList<ContactBook>();
				
					if (!displayTerms.isAdvancedSearch()) {
						count = ContactBookLocalServiceUtil.countByKeyword(searchTerms.getKeywords());
						listContactBook = ContactBookLocalServiceUtil.findByKeyword(searchTerms.getKeywords(),contactBookSearch.getStart(),
									contactBookSearch.getEnd(),searchTerms.isAndOperator(),contactBookSearch.getOrderByComparator());
					} else {
						count = ContactBookLocalServiceUtil.countContactBook(searchTerms.getContactBookCode(),searchTerms.getContactBookName(),searchTerms.getContactDescription(),searchTerms.isAndOperator());
						listContactBook = ContactBookLocalServiceUtil.findContactBook(searchTerms.getContactBookCode(),searchTerms.getContactBookName(),searchTerms.getContactDescription(),
									contactBookSearch.getStart(), contactBookSearch.getEnd(),searchTerms.isAndOperator(),contactBookSearch.getOrderByComparator());
					}
					
					ContactBook contactBook = null;
					long contactBookId = 0;
					
					contactBookSearch.setTotal(count);
					contactBookSearch.setResults(listContactBook);
					portletURL.setParameter(contactBookSearch.getCurParam(), String.valueOf(contactBookSearch.getCurValue()));
					
					List<ResultRow> resultRows = contactBookSearch.getResultRows();
					ResultRow row = null;
					
					String update = "";
					String deleteAction = "";
					String active = "";
					
					for(int i = 0; i < listContactBook.size(); i++){
						contactBook = listContactBook.get(i);
						contactBookId = contactBook.getContactBookId();
						row = new ResultRow(contactBook, contactBookId, i);
						// STT
						row.addText(String.valueOf(i + 1));
						
						// code
						//URL detail
						PortletURL rowURLDetail= renderResponse.createActionURL();
						rowURLDetail.setWindowState(WindowState.NORMAL);
						rowURLDetail.setParameter("struts_action","/nss/phone_book/view");
						rowURLDetail.setParameter(Constants.CMD,"DETAIL");
						rowURLDetail.setParameter("contactBookId", String.valueOf(contactBookId));
						rowURLDetail.setParameter("redirect", contactBookSearch.getIteratorURL().toString());
						rowURLDetail.setParameter("tabs", "detail");
						
						row.addText(contactBook.getContactBookCode(), rowURLDetail.toString());
						
						// name
						row.addText(contactBook.getContactBookName(), rowURLDetail.toString());
						
						// mo ta 
						row.addText(contactBook.getContactDescription(), rowURLDetail.toString());
						
						//active 
						//URL active
						PortletURL rowURLActive= renderResponse.createActionURL();
						rowURLActive.setWindowState(WindowState.NORMAL);
						rowURLActive.setParameter("struts_action","/nss/phone_book/view");
						rowURLActive.setParameter(Constants.CMD,Constants.LOCK);
						rowURLActive.setParameter("contactBookId", String.valueOf(contactBookId));
						rowURLActive.setParameter("redirect", contactBookSearch.getIteratorURL().toString());
						
						if (true == contactBook.getContactActive()) {
							active = "<a href='"+ rowURLActive.toString()+"'><img src='/html/images/checked.gif' />&nbsp;</a>";
						} else if (false == contactBook.getContactActive()){
							active = "<a href='"+ rowURLActive.toString()+"'><img src='/html/images/unchecked.gif' />&nbsp;</a>";
						}
						row.addText(active);
						
						// edit
						//URL update
						PortletURL rowURLEdit = renderResponse.createActionURL();
						rowURLEdit.setWindowState(WindowState.NORMAL);
						rowURLEdit.setParameter(Constants.CMD,Constants.EDIT);
						rowURLEdit.setParameter("struts_action","/nss/phone_book/view");
						rowURLEdit.setParameter("contactBookId", String.valueOf(contactBookId));
						rowURLEdit.setParameter("redirect", contactBookSearch.getIteratorURL().toString());
						rowURLEdit.setParameter("tabs", "edit");
						
						update = "<a href='"+ rowURLEdit.toString()+"'><img src='/html/images/edit.png' />&nbsp;</a>";
						
						row.addText(update);
						
						// delete
						//URL delete
						PortletURL rowURLDelete = renderResponse.createActionURL();
						rowURLDelete.setWindowState(WindowState.NORMAL);
						rowURLDelete.setParameter("struts_action","/nss/phone_book/view");
						rowURLDelete.setParameter(Constants.CMD,Constants.DELETE);
						rowURLDelete.setParameter("contactBookId", String.valueOf(contactBookId));
						rowURLDelete.setParameter("redirect", contactBookSearch.getIteratorURL().toString());
						
						deleteAction = "<a  href='javascript: ;' onclick=deleteContactBook('"+ rowURLDelete.toString() +"')><u>"+ "<img src='/html/images/delete.png'/>" +"</u></a>";
						
						row.addText(deleteAction);
						
						resultRows.add(row);
					}
			%>
		
		<liferay-ui:search-iterator searchContainer="<%= contactBookSearch %>" />
	</div>
</form>
		</c:when>
		<c:when test='<%=tabs1.equals("Report-Registry") %>'>
		<portlet:renderURL var="add_report_registry">
			<portlet:param name="struts_action" value="/sgs/report_registry_work/view" />
		</portlet:renderURL>
			<a href="<%=add_report_registry%>"><span><input type="button"
				value="<liferay-ui:message key='Add-Report-Registry' />" /></span></a>
		</c:when>
	</c:choose>