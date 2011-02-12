<%@ include file="/html/portlet/ext/holiday_calendar/init.jsp"%>
<%@ include
	file="/html/portlet/ext/holiday_calendar/js/holiday_calendar.jsp"%>

<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page
	import="com.sgs.portlet.holiday_calendar.search.HolidayCalendarDisplayTerms"%>
<%@page
	import="com.sgs.portlet.holiday_calendar.search.HolidayCalendarSearch"%>

<script type="text/javascript" src="/html/js/calendar.js"></script>
<script type="text/javascript" src="/html/js/calendar-setup.js"></script>
<script type="text/javascript" src="/html/js/calendar-en.js"></script>
<script type="text/javascript" src="/html/js/dateFormat.js"></script>
<link type="text/css" rel="stylesheet"
	href="/html/css/calendar-system.css" />

<%
	HolidayCalendarSearch holidayCalendarSearch = (HolidayCalendarSearch) request
			.getAttribute("liferay-ui:search:searchContainer");
	HolidayCalendarDisplayTerms displayTerms = (HolidayCalendarDisplayTerms) holidayCalendarSearch
			.getDisplayTerms();
	String dateFrom = (String) request.getAttribute("dateFrom");
	String dateTo = (String) request.getAttribute("dateTo");
%>

<table cellspacing="0" width="100%">
	<tr>
		<td width="20%"><liferay-ui:message key="holiday-calendar-code" />&nbsp;:</td>
		<td><input
			name="<portlet:namespace/><%=HolidayCalendarDisplayTerms.HOLIDAYCALENDARCODE%>"
			style="width: 80%" type="text"
			value="<%=HtmlUtil.escape(displayTerms.getHolidayCalendarCode())%>" />
		</td>

		<td><liferay-ui:message key="holiday-calendar-title" />&nbsp;:</td>
		<td><input
			name="<portlet:namespace/><%=HolidayCalendarDisplayTerms.HOLIDAYCALENDARTITLE%>"
			style="width: 80%" type="text"
			value="<%=HtmlUtil.escape(displayTerms.getHolidayCalendarTitle())%>" />
		</td>
	</tr>
	<tr>
		<td><liferay-ui:message key="date-from" />&nbsp;:</td>
		<td><input name="<portlet:namespace />dateFrom"
			value="<%=(dateFrom != null) ? dateFrom : ""%>"
			id="<portlet:namespace />cal_from_date" size="12" type="text"
			value="" style="width: 100px" maxlength="10"
			onFocus="javascript:vDateType='3'"
			onKeyUp="DateFormat(this,this.value,event,false,'3')" /> <img
			align="top" src="/html/images/cal.gif" style="cursor: pointer;"
			id="cal-button-FromDate"
			onmouseover="callCalendar('<portlet:namespace/>cal_from_date','cal-button-FromDate')" />
		</td>

		<td><liferay-ui:message key="date-to" />&nbsp;:</td>
		<td><input name="<portlet:namespace />dateTo"
			value="<%=(dateTo != null) ? dateTo : ""%>"
			id="<portlet:namespace />cal_to_date" size="12" type="text" value=""
			style="width: 100px" maxlength="10"
			onFocus="javascript:vDateType='3'"
			onKeyUp="DateFormat(this,this.value,event,false,'3')" /> <img
			align="top" src="/html/images/cal.gif" id="cal-button-ToDate"
			style="cursor: pointer;"
			onmouseover="callCalendar('<portlet:namespace/>cal_to_date','cal-button-ToDate')" />
		</td>
	</tr>
		
</table>
<br>
<input type="submit" style="margin-left: 20%"
	name="<portlet:namespace/>search" onclick="return checkDate();"
	value="<liferay-ui:message key="search"/>" />
	
