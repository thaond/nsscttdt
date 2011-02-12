<%@ include file="/html/portlet/ext/report_registry_work/init.jsp"%>

<%@page
	import="com.sgs.portlet.report_registry_work.search.ReportRegistryDisplayTerms"%>
<%@page
	import="com.sgs.portlet.report_registry_work.search.ReportRegistrySearch"%>
<%@page
	import="com.sgs.portlet.report_registry_work.service.DepartmentLocalServiceUtil"%>
<%@page import="com.sgs.portlet.report_registry_work.model.Department"%>
<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>

<script type="text/javascript" src="/html/js/calendar.js"></script>
<script type="text/javascript" src="/html/js/calendar-setup.js"></script>
<script type="text/javascript" src="/html/js/calendar-en.js"></script>
<script type="text/javascript" src="/html/js/dateFormat.js"></script>
<link type="text/css" rel="stylesheet"
	href="/html/css/calendar-system.css" />

<style type="text/css">
.blank-width-10 {
	width: 10px;
}
</style>

<%
	ReportRegistrySearch reportRegistrySearch = (ReportRegistrySearch) request
			.getAttribute("liferay-ui:search:searchContainer");
	ReportRegistryDisplayTerms displayTerms = (ReportRegistryDisplayTerms) reportRegistrySearch
			.getDisplayTerms();

	List<Department> departments = DepartmentLocalServiceUtil
			.getDepartments(-1, -1);
	String departmentSelect = (String) request
			.getAttribute("departmentId");
	long departmentIdRequest = 0;
	if (departmentSelect != null) {
		try {
			departmentIdRequest = Long.parseLong(departmentSelect);
		} catch (Exception e) {

		}
	}
	String dateFrom = (String) request.getAttribute("dateFrom");
	String dateTo = (String) request.getAttribute("dateTo");
%>

<table cellspacing="0" width="100%">
	<tr>
		<td><liferay-ui:message key="report-registry-code" />&nbsp;</td>
		<td><input
			name="<portlet:namespace/><%=ReportRegistryDisplayTerms.REPORTREGISTRYCODE%>"
			style="width: 95%" type="text"
			value="<%=HtmlUtil.escape(displayTerms.getReportRegistryCode())%>" />
		</td>
		<td class="blank-width-10">
		<td><liferay-ui:message key="result-work" />&nbsp;</td>
		<td><input
			name="<portlet:namespace/><%=ReportRegistryDisplayTerms.RESULTWORK%>"
			style="width: 95%" type="text"
			value="<%=HtmlUtil.escape(displayTerms.getResultWork())%>" /></td>
		<td class="blank-width-10">
		<td><liferay-ui:message key="program-work" />&nbsp;</td>
		<td><input
			name="<portlet:namespace/><%=ReportRegistryDisplayTerms.PROGRAMWORK%>"
			style="width: 95%" type="text"
			value="<%=HtmlUtil.escape(displayTerms.getProgramWork())%>" /></td>
	</tr>
	<tr>
		<td><liferay-ui:message key="user-create" />&nbsp;</td>
		<td><input
			name="<portlet:namespace/><%=ReportRegistryDisplayTerms.USERCREATE%>"
			style="width: 95%" type="text"
			value="<%=HtmlUtil.escape(displayTerms.getUserCreate())%>" /></td>
		<td class="blank-width-10">
		<td><liferay-ui:message key="date-from" />&nbsp;</td>
		<td><input name="<portlet:namespace />dateFrom"
			value="<%=(dateFrom != null) ? dateFrom : ""%>"
			id="<portlet:namespace />cal_from_date" size="12" type="text"
			value="" style="width: 80px" maxlength="10"
			onFocus="javascript:vDateType='3'"
			onKeyUp="DateFormat(this,this.value,event,false,'3')" /> <img
			align="top" src="/html/images/cal.gif" style="cursor: pointer;"
			id="cal-button-FromDate"
			onmouseover="callCalendar('<portlet:namespace/>cal_from_date','cal-button-FromDate')" />
		</td>
		<td class="blank-width-10">
		<td><liferay-ui:message key="date-to" />&nbsp;</td>
		<td><input name="<portlet:namespace />dateTo"
			value="<%=(dateTo != null) ? dateTo : ""%>"
			id="<portlet:namespace />cal_to_date" size="12" type="text" value=""
			style="width: 81px" maxlength="10" onFocus="javascript:vDateType='3'"
			onKeyUp="DateFormat(this,this.value,event,false,'3')" /> <img
			align="top" src="/html/images/cal.gif" id="cal-button-ToDate"
			style="cursor: pointer;"
			onmouseover="callCalendar('<portlet:namespace/>cal_to_date','cal-button-ToDate')" />
		</td>
	</tr>
	<tr>
		<td><liferay-ui:message key="department-work" />&nbsp;</td>
		<td><select
			name="<portlet:namespace/><%=ReportRegistryDisplayTerms.DEPARTMENT%>"
			style="width: 140px;">
			<option onclick="sendSelect()" value=""><liferay-ui:message
				key="select-department" /></option>
			<%
				if (departments.size() > 0) {
			%>
			<%
				for (int i = 0; i < departments.size(); i++) {
			%>
			<option onclick="sendSelect()"
				value="<%=departments.get(i).getDepartmentId()%>"
				<%=(departmentIdRequest == departments.get(i)
							.getDepartmentId()) ? "selected" : ""%>><%=departments.get(i).getDepartmentName()%></option>
			<%
				}
			%>
			<%
				}
			%>
		</select></td>
	</tr>
</table>

<br>
<br>
<input type="submit" class="button-width"
	name="<portlet:namespace/>search" onclick="return checkDate();"
	value="<liferay-ui:message key="search"/>" />
