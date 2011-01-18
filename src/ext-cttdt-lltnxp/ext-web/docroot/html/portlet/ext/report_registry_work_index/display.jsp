<%@ include file="/html/portlet/ext/report_registry_work_index/init.jsp" %>

<%@page import="java.io.File"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="javax.portlet.PortletURL"%>

<%@page import="com.liferay.portal.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.liferay.portal.kernel.search.Sort"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>

<%@page import="com.sgs.portlet.report_registry_work.service.ResultProgramLocalServiceUtil"%>
<%@page import="com.sgs.portlet.report_registry_work.model.ResultProgram"%>
<%@page import="com.sgs.portlet.report_registry_work.service.ReportRegistryLocalServiceUtil"%>
<%@page import="com.sgs.portlet.report_registry_work.model.ReportRegistry"%>
<%@page import="com.sgs.portlet.report_registry_work_index.search.ReportRegistryIndexSearchTerms"%>
<%@page import="com.sgs.portlet.report_registry_work_index.search.ReportRegistryIndexDisplayTerms"%>
<%@page import="com.sgs.portlet.report_registry_work_index.search.ReportRegistryIndexSearch"%>
<%@page import="com.sgs.portlet.report_registry_work.service.DepartmentLocalServiceUtil"%>
<%@page import="com.sgs.portlet.report_registry_work.model.Department"%>
<%@page import="com.sgs.portlet.report_registry_work_index.search.DepartmentIndexSearchTerms"%>
<%@page import="com.sgs.portlet.report_registry_work_index.search.DepartmentIndexDisplayTerms"%>
<%@page import="com.sgs.portlet.report_registry_work_index.search.DepartmentIndexSearch"%>


<%
	String tabs1 = ParamUtil.getString(renderRequest, "tabs1", "Department");
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action", "/sgs/report_registry_work_index/view");
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
%>

<% if(error_delete_department != null){ %>
	<div style="color: red"><liferay-ui:message key="not-delete-department"/></div>
<%} %>

<liferay-ui:tabs names="Department,Report-Registry" url="<%= portletURLString %>" />
	
<c:choose>
	<c:when test='<%=tabs1.equals("Department") %>'>
		<form action="<%= portletURL.toString() %>"  method="post">
    	<%
			DepartmentIndexSearch departmentSearch = new DepartmentIndexSearch(renderRequest, portletURL);
    		DepartmentIndexDisplayTerms displayTerms = (DepartmentIndexDisplayTerms)departmentSearch.getDisplayTerms();
    		DepartmentIndexSearchTerms searchTerms = (DepartmentIndexSearchTerms) departmentSearch.getSearchTerms();
    		
	   		String orderByCol = ParamUtil.getString(renderRequest, "orderByCol", DepartmentIndexDisplayTerms.DEPARTMENTCODE);
    		int sortType = Sort.STRING_TYPE;
    		String orderByType = departmentSearch.getOrderByType().toLowerCase();
    		
    		boolean reverse = false;
    		if (orderByType.equals("desc")) {
    			reverse = true;
    		} 
		%>
		<div class="separator"></div>
		<liferay-ui:search-form	page="/html/portlet/ext/report_registry_work_index/department_search_form.jsp" searchContainer="<%= departmentSearch %>" />
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
						
						resultRows.add(row);
					}
			%>
		
				<liferay-ui:search-iterator searchContainer="<%= departmentSearch %>" />
		</form>
	</c:when>
		
	<c:when test='<%=tabs1.equals("Report-Registry") %>'>
		<form action="<%= portletURL.toString() %>"  method="post" name="<portlet:namespace />fm">
    	<%
			ReportRegistryIndexSearch reportRegistrySearch = new ReportRegistryIndexSearch(renderRequest, portletURL);
    		ReportRegistryIndexDisplayTerms displayTerms = (ReportRegistryIndexDisplayTerms)reportRegistrySearch.getDisplayTerms();
    		ReportRegistryIndexSearchTerms searchTerms = (ReportRegistryIndexSearchTerms) reportRegistrySearch.getSearchTerms();
    		
	   		String orderByCol = ParamUtil.getString(renderRequest, "orderByCol", ReportRegistryIndexDisplayTerms.REPORTREGISTRYCODE);
    		int sortType = Sort.STRING_TYPE;
    		String orderByType = reportRegistrySearch.getOrderByType().toLowerCase();
    		
    		boolean reverse = false;
    		if (orderByType.equals("desc")) {
    			reverse = true;
    		} 
		%>
		<div class="separator"></div>
		<liferay-ui:search-form	page="/html/portlet/ext/report_registry_work_index/report_registry_search_form.jsp" searchContainer="<%= reportRegistrySearch %>" />
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
					
					DateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
					Date dFrom = null;
					Date dTo = null;
					if(dateFrom != null && !dateFrom.equals("")){
						dFrom = simpleDateFormat.parse(dateFrom);	
					}
					if(dateTo != null && !dateTo.equals("")){
						dTo = simpleDateFormat.parse(dateTo);	
						dTo.setDate(dTo.getDate() + 1);
					}
					
					List<ReportRegistry> tempDate = new ArrayList<ReportRegistry>();
					for(ReportRegistry reportRegistry : listReportRegistry){
						Date dateCreate = reportRegistry.getReportDate(); 
						if(dFrom == null){
							if(dTo == null){
								tempDate.add(reportRegistry);
							}else if(dateCreate.before(dTo)){
								tempDate.add(reportRegistry);
							}
						}else if(dTo == null){
							if(dateCreate.after(dFrom)){
								tempDate.add(reportRegistry);
							}
						}else if(dTo != null){
							if(dateCreate.after(dFrom) && dateCreate.before(dTo)){
								tempDate.add(reportRegistry);
							}
						}
					}
					listReportRegistry = tempDate;
					
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
							String dateNow = simpleDateFormat.format(reportRegistry.getReportDate());
							row.addText(dateNow);
						}else{
							row.addText("");
						}
						
						resultRows.add(row);
					}
			%>
		
				<liferay-ui:search-iterator searchContainer="<%= reportRegistrySearch %>" />
		</form>
	</c:when>
</c:choose>

<script type="text/javascript">
	function sendSelect(){
		submitForm(document.<portlet:namespace/>fm,
			"<portlet:actionURL windowState="<%=WindowState.NORMAL.toString()%>">
			<portlet:param name="struts_action" value="/sgs/report_registry_work_index/view" />
			<portlet:param name="tabs1" value="Report-Registry" />
			<portlet:param name="varAction" value="reportregistry" />
			<portlet:param name="<%=Constants.CMD%>" value="SELECT" />
			</portlet:actionURL>");
	}
</script>
