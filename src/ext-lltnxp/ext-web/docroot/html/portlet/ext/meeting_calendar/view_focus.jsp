
<%@page import="com.ext.portlet.meetingcalendar.service.MeetingDetailWeekLocalServiceUtil"%><%
	// Hai Trieu
	// Add: 20091019
 %>
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
<%@ include file="/html/portlet/ext/meeting_calendar/init.jsp" %>
<style>
	<%@ include file="/html/portlet/ext/style.css" %>
</style>

<%
	String tabs1 = ParamUtil.getString(request, "tabs1", tabs1Default);
	String redirect = ParamUtil.getString(request, "redirect");
	String originalRedirect = ParamUtil.getString(request, "originalRedirect", StringPool.BLANK);
	
	if (originalRedirect.equals(StringPool.BLANK)) {
		originalRedirect = redirect;
	}
	else {
		redirect = originalRedirect;
	}
	
	String tabs1_ = ParamUtil.getString(request, "tabs1", tabs2Default);
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action", "/ext/meeting_calendar/view_focus_week");	
	portletURL.setParameter("tabs1", "focus-week");
	portletURL.setParameter("redirect", currentURL);

	String cmd = ParamUtil.getString(request, Constants.CMD);
	// Object properties
	long userId = themeDisplay.getUserId();
	long mdweekId = 0;
	String focus = "";
	String note = "";
	String receive = "";
	int week = 0;
	int year = 0;
	
	Calendar cal = (Calendar)selCal.clone();
	int firstDayOfWeek = cal.get(Calendar.DAY_OF_WEEK) - 2;

	DateFormat dateFormatDayOfWeek = new SimpleDateFormat("E", locale);
	DateFormat dateFormatMonthAndDay = new SimpleDateFormat("M/d", locale);
	week = cal.get(Calendar.WEEK_OF_YEAR);
	year = cal.get(Calendar.YEAR);
	MeetingDetailWeek meetingDetailWeekes = MeetingDetailWeekLocalServiceUtil.getWeekYear(week, year);
	if (meetingDetailWeekes != null) {
		mdweekId = meetingDetailWeekes.getMdweekId();
		userId = meetingDetailWeekes.getUserId();
		focus = meetingDetailWeekes.getFocus();
		note = meetingDetailWeekes.getNote();
		receive = meetingDetailWeekes.getReceive();		
		week = meetingDetailWeekes.getWeek();
		year = meetingDetailWeekes.getYear();
	}
	
boolean checkUser = PortletPermissionUtil.contains(permissionChecker, plid.longValue(), portletDisplay.getId(), MeetingCalendarKey.APPROVE_CALENDAR);
if(tabs1_.equals("focus-week")){
	checkUser = true;
}	
%>

<form action="<%= portletURL.toString() %>" method="post" enctype="multipart/form-data" name="<portlet:namespace />fm" onSubmit="submitForm(this); return false;" class="meeting_calendar_bg">
<div class="title_categ"><liferay-ui:message key="lich-tuan" /></div>
<div class="boxcontent">
<input name="<portlet:namespace /><%= Constants.CMD %>" type="hidden" value="" />
<input name="<portlet:namespace />redirect" type="hidden" value="<%= HtmlUtil.escape(redirect) %>" />
<input name="<portlet:namespace />tabs1" type="hidden" value="<%= tabs1_ %>" />
<input name="<portlet:namespace />mdweekId" type="hidden" value="<%= mdweekId %>" />
<input name="<portlet:namespace />userId" type="hidden" value="<%= userId %>" />
<input name="<portlet:namespace />week" type="hidden" value="<%= week %>" />
<input name="<portlet:namespace />year" type="hidden" value="<%= year %>" />

<liferay-util:include page="/html/portlet/ext/meeting_calendar/tabs1.jsp" />
<div class="boxcontent_Tab">
<script type="text/javascript">
	function <portlet:namespace />addFocus() {
		var url = '<liferay-portlet:renderURL windowState="<%= WindowState.MAXIMIZED.toString() %>"><portlet:param name="tabs1" value="focus-week" /><portlet:param name="struts_action" value="/ext/meeting_calendar/edit_focus_week" /><portlet:param name="week" value="<%= String.valueOf(week)%>" /><portlet:param name="year" value="<%= String.valueOf(year)%>" /><portlet:param name="redirect" value="<%= currentURL %>" /></liferay-portlet:renderURL>';		

		document.<portlet:namespace />fm.method = 'post';
		submitForm(document.<portlet:namespace />fm, url);
	}
	
	function <portlet:namespace />editFocus(mdweekId) {
		if (mdweekId == null || mdweekId == 0) {
			alert('<liferay-ui:message key="doituong_khong_tontai" />');
				return;
		}
		var url = '<liferay-portlet:renderURL windowState="<%= WindowState.MAXIMIZED.toString() %>"><portlet:param name="tabs1" value="focus-week" /><portlet:param name="struts_action" value="/ext/meeting_calendar/edit_focus_week" /><portlet:param name="week" value="<%= String.valueOf(week)%>" /><portlet:param name="year" value="<%= String.valueOf(year)%>" /><portlet:param name="mdweekId" value="<%= String.valueOf(mdweekId)%>" /><portlet:param name="<%= Constants.CMD%>" value="<%= Constants.EDIT%>" /><portlet:param name="redirect" value="<%= currentURL %>" /></liferay-portlet:renderURL>';		

		document.<portlet:namespace />fm.method = 'post';
		submitForm(document.<portlet:namespace />fm, url);
	}

</script>

<table cellspacing="0" width="100%">
<tr>
	<td style="text-align: center;" class="td-left" colspan="2">

				<%
				cal.add(Calendar.DATE, -7);
				%>
				<a href="<%= portletURL.toString() %>&<portlet:namespace />month=<%= cal.get(Calendar.MONTH) %>&<portlet:namespace />day=<%= cal.get(Calendar.DATE) %>&<portlet:namespace />year=<%= cal.get(Calendar.YEAR) %>">
				<img align="top" border="0" src="/html/portlet/ext/meeting_calendar/Prev_Button.gif" />
				</a>&nbsp;&nbsp;
				
				<%
					cal.add(Calendar.DATE, 7);
					
					cal.add(Calendar.DATE, -firstDayOfWeek);
				%>
				<b><liferay-ui:message key="from-date" />&nbsp;
				<%= dateFormatDate.format(Time.getDate(cal)) %> 
				<liferay-ui:message key="to-date" />&nbsp;
				<%
				cal.add(Calendar.DATE, 6);
				%>

				<%= dateFormatDate.format(Time.getDate(cal)) %>
				</b>
				
				<%
				cal.add(Calendar.DATE, 1);
				%>
				&nbsp;&nbsp;
				<a href="<%= portletURL.toString() %>&<portlet:namespace />month=<%= cal.get(Calendar.MONTH) %>&<portlet:namespace />day=<%= cal.get(Calendar.DATE) %>&<portlet:namespace />year=<%= cal.get(Calendar.YEAR) %>">
				<img align="top" border="0" src="/html/portlet/ext/meeting_calendar/Next_Button.gif" />
				</a>
			</td>
</tr>
<tr>
			<td class="td-left" valign="top" width="10%"><liferay-ui:message key ="trong-tam"/> :</td>
			<td><%= focus %></td>
		</tr>
			
<tr>
				<td class="td-left" valign="top"><liferay-ui:message key ="luu-y"/> :</td>
				<td><%= note %></td>
			</tr>
<tr>
				<td class="td-left" valign="top"><liferay-ui:message key ="noi-nhan"/> :</td>
				<td><%= receive%></td>								
			</tr>
<tr>
	<td></td>
	<td >	
		<c:choose>
			<c:when test='<%= checkUser && PortletPermissionUtil.contains(permissionChecker, plid.longValue(), portletDisplay.getId(), MeetingCalendarKey.APPROVE_CALENDAR) %>'>
				<input type="button" value='<liferay-ui:message key="add" />'  onClick="<portlet:namespace />addFocus()" name="<portlet:namespace />add" />
				<input type="button" value='<liferay-ui:message key="edit" />' onClick="<portlet:namespace />editFocus(<%= mdweekId %>)" name="<portlet:namespace />edit"/>
				<input type="button" value='<liferay-ui:message key="back" />' onClick="location.href = '<%= HtmlUtil.escape(redirect) %>';" />
			</c:when>
			<c:otherwise>
				<input type="button" value='<liferay-ui:message key="back" />' onClick="location.href = '<%= HtmlUtil.escape(redirect) %>';" />
			</c:otherwise>
		</c:choose>
	</td>
	</tr>
</table>
</div>
</div>
</form>
<c:if test="<%= windowState.equals(WindowState.MAXIMIZED) %>">
	<script type="text/javascript">
		Liferay.Util.focusFormField(document.<portlet:namespace />fm.<portlet:namespace />add);
	</script>
</c:if>		
