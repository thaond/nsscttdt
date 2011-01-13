<%@page import="java.util.Date"%>
<%@page import="java.text.DateFormat"%>
<%@ include file="/html/portlet/ext/report_registry_work/init.jsp" %>

<%@page import="java.io.File"%>
<%@page import="com.sgs.portlet.report_registry_work.service.ResultProgramLocalServiceUtil"%>
<%@page import="com.sgs.portlet.report_registry_work.model.ResultProgram"%>
<%@page import="com.liferay.portal.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.sgs.portlet.report_registry_work.service.ReportRegistryLocalServiceUtil"%>
<%@page import="com.sgs.portlet.report_registry_work.model.ReportRegistry"%>
<%@page import="com.sgs.portlet.report_registry_work.search.ReportRegistrySearchTerms"%>
<%@page import="com.sgs.portlet.report_registry_work.search.ReportRegistryDisplayTerms"%>
<%@page import="com.sgs.portlet.report_registry_work.search.ReportRegistrySearch"%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="javax.portlet.PortletURL"%>

<%@page import="com.liferay.portal.kernel.search.Sort"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>

<%@page import="com.sgs.portlet.report_registry_work.service.DepartmentLocalServiceUtil"%>
<%@page import="com.sgs.portlet.report_registry_work.model.Department"%>
<%@page import="com.sgs.portlet.report_registry_work.search.DepartmentSearchTerms"%>
<%@page import="com.sgs.portlet.report_registry_work.search.DepartmentDisplayTerms"%>
<%@page import="com.sgs.portlet.report_registry_work.search.DepartmentSearch"%>


<%
	String tabs1 = ParamUtil.getString(renderRequest, "tabs1", "Department");
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action", "/sgs/report_registry_work/view");
	portletURL.setParameter("tabs1", tabs1);
	String portletURLString = portletURL.toString();
	request.setAttribute("portletURL", portletURL);
	
	String error_delete_department = (String) request.getAttribute("error_delete_department");
	String departmentSelect = (String) request.getAttribute("departmentId");
	long departmentIdRequest = 0;
	if(departmentSelect != null){
		try{
			 departmentIdRequest = Long.parseLong(departmentSelect);
		}catch(Exception e){
			
		}
	}
	String dateFrom = (String) request.getAttribute("dateFrom");
	String dateTo= (String) request.getAttribute("dateTo");
	long dateFromComparator = 0;
	long dateToComparator = 0;
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
	if(dateFrom != null && !dateFrom.equals("")){
		Date dFrom = simpleDateFormat.parse(dateFrom);	
		dateFromComparator = dFrom.getTime();
	}
	if(dateTo != null && !dateTo.equals("")){
		Date dTo = simpleDateFormat.parse(dateTo);	
		dateToComparator = dTo.getTime();
	}
	System.out.println("dateFromComparator "+dateFromComparator);
	System.out.println("dateToComparator "+dateToComparator);
%>

<% if(error_delete_department != null){ %>
	<div style="color: red"><liferay-ui:message key="not-delete-department"/></div>
<%} %>

<liferay-ui:tabs names="Department,Report-Registry" url="<%= portletURLString %>" />
	
<c:choose>
	<c:when test='<%=tabs1.equals("Department") %>'>
		<form action="<%= portletURL.toString() %>"  method="post">
    	<%
			DepartmentSearch departmentSearch = new DepartmentSearch(renderRequest, portletURL);
    		DepartmentDisplayTerms displayTerms = (DepartmentDisplayTerms)departmentSearch.getDisplayTerms();
    		DepartmentSearchTerms searchTerms = (DepartmentSearchTerms) departmentSearch.getSearchTerms();
    		
	   		String orderByCol = ParamUtil.getString(renderRequest, "orderByCol", DepartmentDisplayTerms.DEPARTMENTCODE);
    		int sortType = Sort.STRING_TYPE;
    		String orderByType = departmentSearch.getOrderByType().toLowerCase();
    		
    		boolean reverse = false;
    		if (orderByType.equals("desc")) {
    			reverse = true;
    		} 
		%>
		<div class="separator"></div>
		<liferay-ui:search-form	page="/html/portlet/ext/report_registry_work/department_search_form.jsp" searchContainer="<%= departmentSearch %>" />
			<%
				PortletURL addURL = renderResponse.createRenderURL();
				addURL.setWindowState(WindowState.NORMAL);
				addURL.setParameter("struts_action", "/sgs/report_registry_work/view");
				addURL.setParameter("tab", "add_department");
				addURL.setParameter("redirect", departmentSearch.getIteratorURL().toString());
			%>
		<a href="<%= addURL.toString() %>"><span><input class="button-width" type="button" value='<liferay-ui:message key="add-department"/>' /></span></a>
		<div class="separator"></div>
				<%
				int count = 0;
				List<Department> listDepartment = new ArrayList<Department>();
				
					if (!displayTerms.isAdvancedSearch()) {
						count = DepartmentLocalServiceUtil.countByKeyword(searchTerms.getKeywords());
						listDepartment = DepartmentLocalServiceUtil.findByKeyword(searchTerms.getKeywords(),departmentSearch.getStart(),
									departmentSearch.getEnd(),departmentSearch.getOrderByComparator());
					} else {
						count = DepartmentLocalServiceUtil.countDepartment(searchTerms.getDepartmentCode(),searchTerms.getDepartmentName(),searchTerms.getDepartmentDescription(),searchTerms.isAndOperator());
						listDepartment = DepartmentLocalServiceUtil.findDepartment(searchTerms.getDepartmentCode(),searchTerms.getDepartmentName(),searchTerms.getDepartmentDescription(),
									departmentSearch.getStart(), departmentSearch.getEnd(),searchTerms.isAndOperator(),departmentSearch.getOrderByComparator());
					}
					
					departmentSearch.setTotal(count);
					departmentSearch.setResults(listDepartment);
					portletURL.setParameter(departmentSearch.getCurParam(), String.valueOf(departmentSearch.getCurValue()));
					
					List<ResultRow> resultRows = departmentSearch.getResultRows();
					ResultRow row = null;
					
					for(int i = 0; i < listDepartment.size(); i++){
						Department department = listDepartment.get(i);
						long departmentId = department.getDepartmentId();
						row = new ResultRow(department, departmentId, i);
						// STT
						row.addText(String.valueOf(i + 1));
						
						//code
						row.addText(department.getDepartmentCode());
						
						// name
						row.addText(department.getDepartmentName());
						
						// mo ta 
						row.addText(department.getDepartmentDescription());
						
						// edit
						//URL update
						PortletURL rowURLEdit = renderResponse.createActionURL();
						rowURLEdit.setWindowState(WindowState.NORMAL);
						rowURLEdit.setParameter(Constants.CMD,Constants.EDIT);
						rowURLEdit.setParameter("struts_action","/sgs/report_registry_work/view");
						rowURLEdit.setParameter("departmentId", String.valueOf(departmentId));
						rowURLEdit.setParameter("varAction","department");
						rowURLEdit.setParameter("redirect", departmentSearch.getIteratorURL().toString());
						rowURLEdit.setParameter("tab", "edit_department");
						
						String updateAction = "<a href='"+ rowURLEdit.toString()+"'><img src='/html/images/edit.png' />&nbsp;</a>";
						
						row.addText(updateAction);
						
						// delete
						//URL delete
						PortletURL rowURLDelete = renderResponse.createActionURL();
						rowURLDelete.setWindowState(WindowState.NORMAL);
						rowURLDelete.setParameter("struts_action","/sgs/report_registry_work/view");
						rowURLDelete.setParameter(Constants.CMD,Constants.DELETE);
						rowURLDelete.setParameter("varAction","department");
						rowURLDelete.setParameter("departmentId", String.valueOf(departmentId));
						
						String deleteAction = "<a  href='javascript: ;' onclick=deleteConfirm('"+ rowURLDelete.toString() +"')><u>"+ "<img src='/html/images/delete.png'/>" +"</u></a>";
						
						row.addText(deleteAction);
						
						resultRows.add(row);
					}
			%>
		
				<liferay-ui:search-iterator searchContainer="<%= departmentSearch %>" />
		</form>
	</c:when>
		
	<c:when test='<%=tabs1.equals("Report-Registry") %>'>
		<form action="<%= portletURL.toString() %>"  method="post" name="<portlet:namespace />fm" >
    	<%
			ReportRegistrySearch reportRegistrySearch = new ReportRegistrySearch(renderRequest, portletURL);
    		ReportRegistryDisplayTerms displayTerms = (ReportRegistryDisplayTerms)reportRegistrySearch.getDisplayTerms();
    		ReportRegistrySearchTerms searchTerms = (ReportRegistrySearchTerms) reportRegistrySearch.getSearchTerms();
    		
	   		String orderByCol = ParamUtil.getString(renderRequest, "orderByCol", ReportRegistryDisplayTerms.REPORTREGISTRYCODE);
    		int sortType = Sort.STRING_TYPE;
    		String orderByType = reportRegistrySearch.getOrderByType().toLowerCase();
    		
    		boolean reverse = false;
    		if (orderByType.equals("desc")) {
    			reverse = true;
    		} 
		%>
		<div class="separator"></div>
		<liferay-ui:search-form	page="/html/portlet/ext/report_registry_work/report_registry_search_form.jsp" searchContainer="<%= reportRegistrySearch %>" />
			<%
				PortletURL addURL = renderResponse.createRenderURL();
				addURL.setWindowState(WindowState.NORMAL);
				addURL.setParameter("struts_action", "/sgs/report_registry_work/view");
				addURL.setParameter("tab", "add_report_registry");
				addURL.setParameter("tabs1", "Report-Registry");
				addURL.setParameter("redirect", reportRegistrySearch.getIteratorURL().toString());
			%>
		<a href="<%= addURL.toString() %>"><span><input class="button-width" type="button" value='<liferay-ui:message key="add-report-registry"/>' /></span></a>
		<div class="separator"></div>
				<%
				int count = 0;
				List<ReportRegistry> listReportRegistry = new ArrayList<ReportRegistry>();
				count = ReportRegistryLocalServiceUtil.countReportRegistry(searchTerms.getReportRegistryCode(), searchTerms.getUserCreate(), searchTerms.getResultWork(), searchTerms.getProgramWork(), searchTerms.getDepartment(), searchTerms.isAndOperator());
				listReportRegistry = ReportRegistryLocalServiceUtil.findReportRegistry(searchTerms.getReportRegistryCode(), searchTerms.getUserCreate(), searchTerms.getResultWork(), searchTerms.getProgramWork(), searchTerms.getDepartment(),
									reportRegistrySearch.getStart(), reportRegistrySearch.getEnd(), searchTerms.isAndOperator(), reportRegistrySearch.getOrderByComparator());
						
					List<ReportRegistry> temp = new ArrayList<ReportRegistry>();
					if(departmentIdRequest != 0){
						for(ReportRegistry reportRegistry : listReportRegistry){
							if(reportRegistry.getDepartmentId() == departmentIdRequest){
								temp.add(reportRegistry);
							}
						}
						listReportRegistry = temp;
					}
					count = listReportRegistry.size();
					reportRegistrySearch.setTotal(count);
					reportRegistrySearch.setResults(listReportRegistry);
					portletURL.setParameter(reportRegistrySearch.getCurParam(), String.valueOf(reportRegistrySearch.getCurValue()));
					
					List<ResultRow> resultRows = reportRegistrySearch.getResultRows();
					ResultRow row = null;
					
					for(int i = 0; i < listReportRegistry.size(); i++){
						ReportRegistry reportRegistry = listReportRegistry.get(i);
						long reportRegistryId = reportRegistry.getReportRegistryId();
						List<ResultProgram> resultPrograms = ReportRegistryLocalServiceUtil.getResultPrograms(reportRegistryId);
						
						row = new ResultRow(reportRegistry, reportRegistryId, i);
						// STT
						row.addText(String.valueOf(i + 1));
						
						//code
						row.addText(reportRegistry.getReportRegistryCode());
						
						//user create
						long userId = reportRegistry.getUserId();
						String username = "";
						if(userId != 0){
							try{
								User userCreate = UserLocalServiceUtil.getUser(userId);
								username = userCreate.getScreenName();
							}catch(Exception e){
							}
						}
						row.addText(username);
						
						String linkResultWork = "";
						String linkProgramWork = "";
						
						for(ResultProgram resultProgram : resultPrograms){
							String title = resultProgram.getResultProgramPath();
							if(resultProgram.getResultProgramCheck().equals("resultwork")){
								if(!resultProgram.getResultProgramTitle().equals("")){
									linkResultWork += "<a href =" + resultProgram.getResultProgramPath() + ">" +resultProgram.getResultProgramTitle().subSequence(0,resultProgram.getResultProgramTitle().indexOf("_")) + "</a>" + "<br>";
								}
							}else if(resultProgram.getResultProgramCheck().equals("programwork")){
								if(!resultProgram.getResultProgramTitle().equals("")){
									linkProgramWork += "<a href =" + resultProgram.getResultProgramPath() + ">" + resultProgram.getResultProgramTitle().subSequence(0,resultProgram.getResultProgramTitle().indexOf("_")) + "</a>" + "<br>";
								}
							}
						}
						
						// resultwork
						row.addText(linkResultWork);
						
						// programwork
						row.addText(linkProgramWork);
						
						// date
						if(reportRegistry.getReportDate() != null){
							Date dateCreate = reportRegistry.getReportDate();
							System.out.println("dateCreate "+dateCreate.getTime());
							String dateNow = simpleDateFormat.format(dateCreate);
							row.addText(dateNow);
						}else{
							row.addText("");
						}
						
						// edit
						//URL update
						PortletURL rowURLEdit = renderResponse.createActionURL();
						rowURLEdit.setWindowState(WindowState.NORMAL);
						rowURLEdit.setParameter(Constants.CMD,Constants.EDIT);
						rowURLEdit.setParameter("struts_action","/sgs/report_registry_work/view");
						rowURLEdit.setParameter("reportRegistryId", String.valueOf(reportRegistryId));
						rowURLEdit.setParameter("varAction","reportregistry");
						rowURLEdit.setParameter("redirect", reportRegistrySearch.getIteratorURL().toString());
						rowURLEdit.setParameter("tab", "edit_report_registry");
						rowURLEdit.setParameter("tabs1","Report-Registry");
						
						String updateAction = "<a href='"+ rowURLEdit.toString()+"'><img src='/html/images/edit.png' />&nbsp;</a>";
						
						row.addText(updateAction);
						
						// delete
						//URL delete
						PortletURL rowURLDelete = renderResponse.createActionURL();
						rowURLDelete.setWindowState(WindowState.NORMAL);
						rowURLDelete.setParameter("struts_action","/sgs/report_registry_work/view");
						rowURLDelete.setParameter(Constants.CMD,Constants.DELETE);
						rowURLDelete.setParameter("varAction","reportregistry");
						rowURLDelete.setParameter("tabs1","Report-Registry");
						rowURLDelete.setParameter("reportRegistryId", String.valueOf(reportRegistryId));
						
						String deleteAction = "<a  href='javascript: ;' onclick=deleteConfirm('"+ rowURLDelete.toString() +"')><u>"+ "<img src='/html/images/delete.png'/>" +"</u></a>";
						
						row.addText(deleteAction);
						
						resultRows.add(row);
					}
			%>
		
				<liferay-ui:search-iterator searchContainer="<%= reportRegistrySearch %>" />
		</form>
	</c:when>
</c:choose>

<script type="text/javascript">
	function deleteConfirm(url) {
		if (confirm("<liferay-ui:message key='ban-co-that-su-muon-xoa'/>")) {
			location.href = url;
		}
	}
</script> 