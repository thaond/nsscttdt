
<%@page import="com.liferay.portal.kernel.util.CalendarUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.CalendarFactoryUtil"%>
<%@ include file="/html/portlet/init.jsp" %>
<%@ include file="/html/common/init.jsp" %>

<%@ page import="com.liferay.portlet.calendar.EventDurationException" %>
<%@ page import="com.liferay.portlet.calendar.EventEndDateException" %>
<%@ page import="com.liferay.portlet.calendar.EventStartDateException" %>
<%@ page import="com.liferay.portlet.calendar.EventTitleException" %>
<%@ page import="com.liferay.portlet.calendar.NoSuchEventException" %>
<%@ page import="com.liferay.portlet.calendar.model.CalEvent" %>
<%@ page import="com.liferay.portlet.calendar.model.impl.CalEventImpl" %>
<%@ page import="com.liferay.portlet.calendar.service.CalEventServiceUtil"%>
<%@ page import="com.liferay.portlet.calendar.service.CalEventLocalServiceUtil" %>
<%@ page import="com.liferay.portlet.calendar.service.permission.CalEventPermission" %>
<%@ page import="com.liferay.portlet.calendar.util.CalUtil" %>

<%@ page import="com.ext.portlet.meetingcalendar.DuplicateRoomException"%>
<%@ page import="com.ext.portlet.meetingcalendar.ContentCalendarNullException"%>
<%@ page import="com.ext.portlet.meetingcalendar.model.MeetingCalendar"%>
<%@ page import="com.ext.portlet.meetingcalendar.model.MeetingCalComponent"%>
<%@ page import="com.ext.portlet.meetingcalendar.model.MeetingDetailWeek"%>
<%@ page import="com.ext.portlet.meetingcalendar.model.impl.MeetingCalendarImpl"%>
<%@ page import="com.ext.portlet.meetingcalendar.search.MeetingCalendarDisplayTerms"%>
<%@ page import="com.ext.portlet.meetingcalendar.search.MeetingCalendarSearch"%>
<%@ page import="com.ext.portlet.meetingcalendar.search.MeetingCalendarSearchTerms"%>
<%@ page import="com.ext.portlet.meetingcalendar.service.MeetingCalendarLocalServiceUtil"%>
<%@ page import="com.ext.portlet.meetingcalendar.service.MeetingCalendarServiceUtil"%>
<%@ page import="com.ext.portlet.meetingcalendar.service.MeetingCalComponentLocalServiceUtil"%>
<%@ page import="com.ext.portlet.meetingcalendar.service.MeetingDetailWeekLocalServiceUtil"%>
<%@ page import="com.ext.portlet.meetingcalendar.action.ActionUtil"%>
<%@ page import="com.ext.portlet.meetingcalendar.action.MeetingCalendarKey"%>
<%@ page import="com.ext.portlet.meetingcalendar.util.comparator.EventTimeComparator" %>

<%@ page import="com.liferay.portal.NoSuchOrganizationException" %>
<%@ page import="com.liferay.portal.service.OrganizationLocalServiceUtil"%>
<%@ page import="com.liferay.portlet.enterpriseadmin.search.OrganizationDisplayTerms" %>
<%@ page import="com.liferay.portlet.enterpriseadmin.search.OrganizationPasswordPolicyChecker" %>
<%@ page import="com.liferay.portlet.enterpriseadmin.search.OrganizationRoleChecker" %>
<%@ page import="com.liferay.portlet.enterpriseadmin.search.OrganizationSearch" %>
<%@ page import="com.liferay.portlet.enterpriseadmin.search.OrganizationSearchTerms" %>
<%@ page import="com.liferay.portlet.enterpriseadmin.util.EnterpriseAdminUtil" %>

<%@ page import="com.liferay.portal.kernel.util.Time"%>
<%@ page import="com.liferay.portal.kernel.cal.DayAndPosition" %>
<%@ page import="com.liferay.portal.kernel.util.Constants"%>
<%@ page import="com.liferay.util.SystemProperties"%>
<%@ page import="com.liferay.portal.kernel.dao.search.DisplayTerms"%>
<%@ page import="com.liferay.portal.kernel.util.Validator"%>
<%@ page import="com.liferay.portal.kernel.util.TimeZoneUtil"%>
<%@ page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@ page import="com.liferay.portal.model.User"%>
<%@ page import="com.liferay.portal.util.WebKeys"%>
<%@ page import="com.ext.portal.util.WebKeysExt"%>
<%@ page import="com.ext.portal.util.PortletKeysExt"%>
<%@ page import="com.liferay.portal.theme.PortletDisplay"%>

<%@ page import="javax.portlet.ActionRequest"%>
<%@ page import="javax.portlet.ActionResponse"%>
<%@ page import="javax.portlet.PortletConfig"%>
<%@ page import="javax.portlet.RenderRequest"%>
<%@ page import="javax.portlet.RenderResponse"%>
<%@ page import="javax.portlet.WindowState"%>

<%@ page import="java.util.Iterator"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.util.Calendar"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.TimeZone"%>
<%@page import="com.ext.portlet.meetingcalendar.FocusException"%>
<%@page import="com.ext.portlet.meetingcalendar.DuplicateFocusException"%>
<%@page import="com.sun.corba.se.impl.orbutil.closure.Constant"%>
<%@ page import="java.rmi.RemoteException" %>

<%@page import="com.ext.portlet.meetingcalendar.service.CarResourceServiceUtil"%>
<%@page import="com.ext.portlet.meetingcalendar.model.CarResource"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.ext.portlet.meetingcalendar.service.RoomResourceServiceUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ext.portlet.meetingcalendar.model.RoomResource"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.bean.BeanParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.CalendarUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portlet.calendar.model.CalEvent"%>
<%@page import="com.ext.portlet.meetingcalendar.model.MeetingCalendar"%>
<%@page import="com.ext.portlet.meetingcalendar.action.MeetingCalendarKey"%>
<%@page import="com.ext.portlet.meetingcalendar.model.MeetingCalComponent"%>
<%@page import="java.util.Calendar"%>
<%@page import="com.liferay.portal.kernel.util.CalendarFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portlet.calendar.model.impl.CalEventImpl"%>
<%@page import="com.liferay.portal.kernel.util.Time"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.liferay.portal.util.WebKeys"%>

<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>

<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jstl/sql_rt" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jstl/xml_rt" prefix="x" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-bean-el" prefix="bean-el" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-html-el" prefix="html-el" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-logic-el" prefix="logic-el" %>
<%@ taglib uri="http://struts.apache.org/tags-nested" prefix="nested" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles-el" prefix="tiles-el" %>

<portlet:defineObjects/>
<liferay-theme:defineObjects />
<script type='text/javascript' src='/dwr/engine.js'></script>
<script type='text/javascript' src='/dwr/util.js'></script>
<script type="text/javascript" src="/html/js/liferay/ext_service_unpacked.js"></script>
<script type="text/javascript" src="/dwr/interface/pmlUserUtilClient.js"></script>
<style type="text/css">
.separator{
border-top: 2px dotted #BFBFBF;
}

.meeting_calendar_bg{
background:transparent url(/html/portlet/ext/meeting_calendar/bg.gif);
}

.book_table tr td{
padding:0 5px 5px;
}

.repeat{
cursor:pointer;
font-weight:bold;
font-size:12px;
padding-left:5px;
}

.print-button{
font-weight:bold;
font-size:12px;
text-decoration: none;
}

.search_table{
background-color:#DBE8FA;
}

.search_table tr td{
padding:0 5px 5px;
}

.gach-do{
border-top: 2px solid red;
margin-left:12px;
margin-right:12px;
}

.titleCal {
	color:#FFFFFF;
	font-family:Arial;
	font-size:13pt;
	font-weight:bold;
	line-height:25px;
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

.nameContent {
	color:#1D4D77;
	font-family:Arial;
	font-size:10pt;
	font-weight:bold;
}

td.showDragHandle {
	background-repeat: no-repeat;
	background-position: center center;
	cursor: move;
}

.tDnD_whileDrag {
	background-color: #eee;
	border: red 1px solid;
}

.textinfoCal {
	color:black;
	font-family:Arial;
	font-size:10pt;
}
.focusWeek {
	color:#1D4D77;
	font-family:Arial;
	font-size:10pt;
	font-weight:bold;
}
</style>
<%
PortletPreferences prefs = renderRequest.getPreferences();

String portletResource = ParamUtil.getString(request, "portletResource");
PortalPreferences portalPrefs = PortletPreferencesFactoryUtil.getPortalPreferences(request);

if (Validator.isNotNull(portletResource)) {
	prefs = PortletPreferencesFactoryUtil.getPortletSetup(request, portletResource);
}

//String tabs1Names = "register-calendar,approved-calendar,calendar-release";
String tabs1Names = "calendar-release";

String[] tabs1NamesArray = StringUtil.split(tabs1Names);

String tabs1Default = prefs.getValue("tabs1-default", "calendar-release");
String tabs2Default = prefs.getValue("tabs2-default", "focus-week");
String summaryTabOrientation = prefs.getValue("summary-tab-orientation", "horizontal");
boolean summaryTabShowMiniMonth = GetterUtil.getBoolean(prefs.getValue("summary-tab-show-mini-month", "true"));
boolean summaryTabShowTodaysEvents = GetterUtil.getBoolean(prefs.getValue("summary-tab-show-todays-events", "true"));

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

boolean filterManageableOrganizations = true;
if (portletName.equals(PortletKeys.MY_ACCOUNT)) {
	filterManageableOrganizations = false;
}
else if (permissionChecker.isCompanyAdmin()) {
	filterManageableOrganizations = false;
}
%>