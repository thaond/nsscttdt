<%@ include file="/html/portlet/init.jsp" %>

<%@ page import="com.liferay.portal.kernel.search.SearchEngineUtil" %>
<%@ page import="com.liferay.portal.kernel.cal.DayAndPosition" %>
<%@ page import="com.liferay.portlet.calendar.EventDurationException" %>
<%@ page import="com.liferay.portlet.calendar.EventEndDateException" %>
<%@ page import="com.liferay.portlet.calendar.EventStartDateException" %>
<%@ page import="com.liferay.portlet.calendar.EventTitleException" %>
<%@ page import="com.liferay.portlet.calendar.NoSuchEventException" %>
<%@ page import="com.liferay.portlet.calendar.model.CalEvent" %>
<%@ page import="com.liferay.portlet.calendar.model.impl.CalEventImpl" %>
<%@ page import="com.liferay.portlet.calendar.service.CalEventLocalServiceUtil" %>
<%@ page import="com.liferay.portlet.calendar.service.permission.CalEventPermission" %>
<%@ page import="com.liferay.portlet.calendar.util.CalUtil" %>
<%@ page import="com.ext.portlet.meetingcalendar.util.comparator.EventTimeComparator" %>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.ext.portlet.meetingcalendar.action.MeetingCalendarKey"%>
<%@page import="com.liferay.portlet.calendar.model.CalEvent"%>
<%@page import="com.ext.portlet.meetingcalendar.model.MeetingCalendar"%>
<%@page import="com.ext.portlet.meetingcalendar.model.impl.MeetingCalendarImpl"%>
<%@page import="com.ext.portlet.meetingcalendar.service.MeetingCalendarLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="com.sun.corba.se.impl.orbutil.closure.Constant"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.ext.portlet.meetingcalendar.action.MeetingCalendarKey"%>
<%@page import="com.liferay.portlet.calendar.service.CalEventServiceUtil"%>
<%@page import="com.liferay.portlet.calendar.service.impl.CalEventLocalServiceImpl"%>
<%@page import="com.liferay.portlet.calendar.service.CalEventLocalServiceUtil"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Date"%>
<%@page import="com.liferay.portal.kernel.util.Time"%>
<%@page import="java.util.Calendar"%>

<%@page import="com.ext.portlet.meetingcalendar.action.ActionUtil"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.TimeZone"%>
<%@page import="com.liferay.util.SystemProperties"%>
<%@page import="com.liferay.portal.kernel.util.TimeZoneUtil"%>
<%@page import="com.liferay.portlet.calendar.util.CalUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.liferay.portal.util.WebKeys"%>
<%@page import="com.ext.portlet.meetingcalendar.search.MeetingCalendarDisplayTerms"%>
<%@page import="com.ext.portlet.meetingcalendar.search.MeetingCalendarSearch"%>
<%@page import="com.ext.portlet.meetingcalendar.search.MeetingCalendarSearchTerms"%>
<%@page import="com.liferay.portal.kernel.dao.search.DisplayTerms"%>

<%---
<%@page import="com.ext.portlet.meetingcalendarview.service.permission.MeetingCalViewPermission"%>
<%@page import="com.ext.portlet.meetingcalendarview.util.MeetingCalViewKey"%>
<%@page import="com.ext.portlet.meetingcalendarview.service.MeetingCalViewLocalServiceUtil"%>
<%@page import="com.ext.portlet.meetingcalendarview.service.MeetingCalViewEmergencyLocalServiceUtil"%>
<%@page import="com.ext.portlet.meetingcalendarview.model.MeetingCalView"%>
<%@page import="com.ext.portlet.meetingcalendarview.model.MeetingCalViewEmergency"%>
<%@page import="com.ext.portlet.meetingcalendarview.ContentException"%>
<%@page import="com.ext.portlet.meetingcalendarview.StartDateException"%>
<%@page import="com.ext.portlet.meetingcalendarview.EndDateException"%>
---%>
<%@page import="java.sql.Timestamp"%>
<%@page import="com.liferay.portal.service.UserLocalServiceUtil"%>
<style type="text/css">
.titleCal {
	color:#FFFFFF;
	font-family:Arial;
	font-size:13pt;
	font-weight:bold;
}

.nameCal {
	color:#1D4D77;
	font-family:Arial;
	font-size:10pt;
	font-weight:bold;
	background-color: #d0d064;
}
.nameCal_RE {
	color:#1D4D77;
	font-family:Arial;
	font-size:10pt;
	font-weight:bold;
}
.nameCal_OLD {
	color:#1D4D77;
	font-family:Arial;
	font-size:10pt;
	font-weight:bold;
	background-color: #DBE8FA;
}
.textinfoCal {
	color:#1D4D77;
	font-family:Arial;
	font-size:10pt;
}

.nameContent {
	color:#1D4D77;
	font-family:Arial;
	font-size:10pt;
	font-weight:bold;
}
.font_ngay {
 	color:#FD5400;
	font-size:22px;
    font-family:\"Times New Roman\", Times, serif;
	font-weight:bold;
}
.font_time {
	font-family:\"Times New Roman\", Times, serif;
	font-size: 40px;
	color: #FF0000;
	font-weight:bold;
	text-decoration:underline;
	line-height: 50px;
	padding-left: 10px;
}
.font_content{
	font-family:\"Times New Roman\", Times, serif;
	font-size: 60px;
	color: #FF3398;
	font-weight:bold;
	line-height: 65px;
	padding-left: 20px;
}

.font_content1{
	font-family:\"Times New Roman\", Times, serif;
	font-size: 50px;
	color: #0000FF;
	font-weight:bold;
	line-height: 60px;
	padding-left: 10px;
}

.font_gretting{
    font-family:\"Times New Roman\", Times, serif;
	color:#FD5400;
	font-size:25px;
	font-weight:bold;
	line-height:30px;
}
</style>
<%
PortletPreferences prefs = renderRequest.getPreferences();
String portletResource = ParamUtil.getString(request, "portletResource");

if (Validator.isNotNull(portletResource)) {
	prefs = PortletPreferencesFactoryUtil.getPortletSetup(request, portletResource);
}
String tabs1Names = "lich-ngay";
String[] tabs1NamesArray = StringUtil.split(tabs1Names);
String tabs1Default = prefs.getValue("tabs1-default", "lich-ngay");

long groupId = portletGroupId.longValue();
long companyId = company.getCompanyId();

String monthParam = request.getParameter("month");
String dayParam = request.getParameter("day");
String yearParam = request.getParameter("year");

Calendar selCal = CalendarFactoryUtil.getCalendar(timeZone, locale);

try {
	selCal.set(Calendar.YEAR, Integer.parseInt(yearParam));
}
catch (NumberFormatException nfe) {
}

try {
	if (dayParam != null) {
		selCal.set(Calendar.DATE, 1);
	}

	selCal.set(Calendar.MONTH, Integer.parseInt(monthParam));
}
catch (NumberFormatException nfe) {
}

try {
	int maxDayOfMonth = selCal.getActualMaximum(Calendar.DATE);

	int dayParamInt = Integer.parseInt(dayParam);

	if (dayParamInt > maxDayOfMonth) {
		dayParamInt = maxDayOfMonth;
	}

	selCal.set(Calendar.DATE, dayParamInt);
}
catch (NumberFormatException nfe) {
}

int selMonth = selCal.get(Calendar.MONTH);
int selDay = selCal.get(Calendar.DATE);
int selYear = selCal.get(Calendar.YEAR);

Calendar curCal = CalendarFactoryUtil.getCalendar(timeZone, locale);

int curMonth = curCal.get(Calendar.MONTH);
int curDay = curCal.get(Calendar.DATE);
int curYear = curCal.get(Calendar.YEAR);

int[] monthIds = CalendarUtil.getMonthIds();
String[] months = CalendarUtil.getMonths(locale);

String[] days = CalendarUtil.getDays(locale);

DateFormat dateFormatDate = DateFormats.getDate(locale);
DateFormat dateFormatDateTime = DateFormats.getDateTime(locale);
DateFormat dateFormatTime = DateFormats.getTime(locale);
DateFormat dateFormatISO8601 = DateUtil.getISO8601Format();
DateFormat dateFormatDayOfWeek = new SimpleDateFormat("E", locale);
DateFormat dateFormatMonthAndDay = new SimpleDateFormat("M/d", locale);
%>