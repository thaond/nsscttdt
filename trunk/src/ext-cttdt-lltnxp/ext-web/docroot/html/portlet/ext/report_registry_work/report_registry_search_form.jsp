<%@ include file="/html/portlet/ext/report_registry_work/init.jsp" %>

<%@page import="com.sgs.portlet.report_registry_work.search.ReportRegistryDisplayTerms"%>
<%@page import="com.sgs.portlet.report_registry_work.search.ReportRegistrySearch"%>
<%@page import="com.sgs.portlet.report_registry_work.service.DepartmentLocalServiceUtil"%>
<%@page import="com.sgs.portlet.report_registry_work.model.Department"%>
<%@page import="java.util.List"%>

<script type="text/javascript"	src="/html/js/calendar.js"></script>
<script type="text/javascript"	src="/html/js/calendar-setup.js"></script>
<script type="text/javascript"	src="/html/js/calendar-en.js"></script>
<script type="text/javascript"	src="/html/js/dateFormat.js"></script>
<link type="text/css" rel="stylesheet"	href="/html/css/calendar-system.css" />


<%
	ReportRegistrySearch reportRegistrySearch = (ReportRegistrySearch) request.getAttribute("liferay-ui:search:searchContainer");
	ReportRegistryDisplayTerms displayTerms = (ReportRegistryDisplayTerms) reportRegistrySearch.getDisplayTerms();
	
	List<Department> departments = DepartmentLocalServiceUtil.getDepartments(-1,-1);
	String departmentSelect = (String) request.getAttribute("departmentId");
	long departmentIdRequest = 0;
	if(departmentSelect != null){
		try{
			 departmentIdRequest = Long.parseLong(departmentSelect);
			 System.out.println("vvvvvvvvvvvvvvvvvvvv "+departmentIdRequest);
		}catch(Exception e){
			
		}
	}
%>

	<table cellspacing="0" width="100%">
		<tr>
			<td><liferay-ui:message key="report-registry-code" />&nbsp;</td>
			<td><input name="<portlet:namespace/><%=ReportRegistryDisplayTerms.REPORTREGISTRYCODE%>" 
				style="width: 90%" type="text" value="<%=HtmlUtil.escape(displayTerms.getReportRegistryCode())%>" />
			</td>

			<td><liferay-ui:message key="result-work" />&nbsp;</td>
			<td><input name="<portlet:namespace/><%=ReportRegistryDisplayTerms.RESULTWORK%>" 
				style="width: 90%" type="text" value="<%=HtmlUtil.escape(displayTerms.getResultWork())%>" />
			</td>
			
			<td><liferay-ui:message key="program-work" />&nbsp;</td>
			<td><input name="<portlet:namespace/><%=ReportRegistryDisplayTerms.PROGRAMWORK%>"
				style="width: 90%" type="text" value="<%=HtmlUtil.escape(displayTerms.getProgramWork())%>" />
			</td>
		</tr>
		<tr>
			<td><liferay-ui:message key="user-create" />&nbsp;</td>
			<td><input name="<portlet:namespace/>userCreate" style="width: 90%" type="text" value="" /></td>

			<td><liferay-ui:message key="date-from" />&nbsp;</td>
			<td>
				<input name="<portlet:namespace />dateFrom" id="<portlet:namespace />cal_from_date" size="12" type="text" value="" style="width: 125px" maxlength="10" onFocus="javascript:vDateType='3'" onKeyUp="DateFormat(this,this.value,event,false,'3')"/>
				<img align="top" src="/html/images/cal.gif" style="cursor: pointer;" id="cal-button-FromDate" onClick="callCalendar('<portlet:namespace/>cal_from_date','cal-button-FromDate')" />
			</td>
			
			<td><liferay-ui:message key="date-to" />&nbsp;</td>
			<td>
				<input name="<portlet:namespace />dateTo" id="<portlet:namespace />cal_to_date" size="12" type="text" value="" style="width: 125px" maxlength="10" onFocus="javascript:vDateType='3'" onKeyUp="DateFormat(this,this.value,event,false,'3')"/>
				<img align="top" src="/html/images/cal.gif" id="cal-button-ToDate" style="cursor: pointer;" onClick="callCalendar('<portlet:namespace/>cal_to_date','cal-button-ToDate')" />
			</td>
		</tr>
		<tr>
			<td><liferay-ui:message key="department-work" />&nbsp;</td>
			<td>
				<select name="<portlet:namespace/>department">
					<option value=""><liferay-ui:message key="select-department" /></option>
					<% if(departments.size() >0 ){ %>
						<% for(int i = 0; i < departments.size(); i++){ %>
					<option onclick="sendSelect()" value="<%=departments.get(i).getDepartmentId()%>" <%= (departmentIdRequest == departments.get(i).getDepartmentId()) ? "selected" : "" %>><%=departments.get(i).getDepartmentName()%></option>		
						<%} %> 
					<%} %> 
				</select>
			</td>
		</tr>
	</table>

<br><br>
<input type="submit" class="button-width" name="<portlet:namespace/>search" value="<liferay-ui:message key="search"/>" />

<script type="text/javascript">
	function sendSelect(){
		submitForm(document.<portlet:namespace/>fm,
			"<portlet:actionURL windowState="<%=WindowState.NORMAL.toString()%>">
			<portlet:param name="struts_action" value="/sgs/report_registry_work/view" />
			<portlet:param name="tabs1" value="Report-Registry" />
			<portlet:param name="varAction" value="reportregistry" />
			<portlet:param name="<%=Constants.CMD%>" value="SELECT" />
			</portlet:actionURL>");
	}
</script>