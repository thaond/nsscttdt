
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
// DuyDuong add
String showAdvance = "false";

String redirect = ParamUtil.getString(request, "redirect");

CalEvent event = (CalEvent)request.getAttribute(WebKeys.CALENDAR_EVENT);
MeetingCalendar  mcalendar = (MeetingCalendar)request.getAttribute(MeetingCalendarKey.MEETING_CALENDAR);
MeetingCalComponent mcalComp = (MeetingCalComponent)request.getAttribute(MeetingCalendarKey.MEETING_CALENDAR_COMPONENT);
long eventId = BeanParamUtil.getLong(event, request, "eventId");
long mcalId = BeanParamUtil.getLong(mcalendar, request, "mcalId");
boolean repeatWeek = BeanParamUtil.getBoolean(mcalendar, request, "repeatWeek");

boolean morning = BeanParamUtil.getBoolean(mcalendar, request, "morning");
boolean afternoon = BeanParamUtil.getBoolean(mcalendar, request, "afternoon");
boolean evening = BeanParamUtil.getBoolean(mcalendar, request, "evening");
boolean prior = BeanParamUtil.getBoolean(mcalendar, request, "prior");

Calendar startDate = CalendarUtil.roundByMinutes((Calendar)selCal.clone(), 15);

if (event != null) {
	if (!event.isTimeZoneSensitive()) {
		startDate = CalendarFactoryUtil.getCalendar();
	}

	startDate.setTime(event.getStartDate());
}

Calendar endDate = (Calendar)curCal.clone();

endDate.add(Calendar.YEAR, 1);

if (event != null) {
	if (!event.isTimeZoneSensitive()) {
		endDate = CalendarFactoryUtil.getCalendar();
	}

	if (event.getEndDate() != null) {
		endDate.setTime(event.getEndDate());
	}
}

String durationHour = String.valueOf(BeanParamUtil.getInteger(event, request, "durationHour", 1));
String durationMinute = String.valueOf(BeanParamUtil.getInteger(event, request, "durationMinute"));
String type = BeanParamUtil.getString(event, request, "type", "lich");
String place = BeanParamUtil.getString(mcalendar, request, "place");
boolean repeating = BeanParamUtil.getBoolean(event, request, "repeating");
String title_cal = BeanParamUtil.getString(event, request, "title");
if(title_cal.equals(MeetingCalendarKey.KHONG_CO_CHU_TRI)){
	title_cal = StringPool.BLANK;
}
Recurrence recurrence = null;

int recurrenceType = ParamUtil.getInteger(request, "recurrenceType", Recurrence.NO_RECURRENCE);
String recurrenceTypeParam = ParamUtil.getString(request, "recurrenceType");
if (Validator.isNull(recurrenceTypeParam) && (event != null)) {
	if (event.getRepeating()) {
		recurrence = event.getRecurrenceObj();
		recurrenceType = recurrence.getFrequency();
	}
}

int dailyType = ParamUtil.getInteger(request, "dailyType");
String dailyTypeParam = ParamUtil.getString(request, "dailyType");
if (Validator.isNull(dailyTypeParam) && (event != null)) {
	if ((event.getRepeating()) && (recurrence != null)) {
		if (recurrence.getByDay() != null) {
			dailyType = 1;
		}
	}
}

int dailyInterval = ParamUtil.getInteger(request, "dailyInterval", 1);
String dailyIntervalParam = ParamUtil.getString(request, "dailyInterval");
if (Validator.isNull(dailyIntervalParam) && (event != null)) {
	if ((event.getRepeating()) && (recurrence != null)) {
		dailyInterval = recurrence.getInterval();
	}
}

int weeklyInterval = ParamUtil.getInteger(request, "weeklyInterval", 1);
String weeklyIntervalParam = ParamUtil.getString(request, "weeklyInterval");
if (Validator.isNull(weeklyIntervalParam) && (event != null)) {
	if ((event.getRepeating()) && (recurrence != null)) {
		weeklyInterval = recurrence.getInterval();
	}
}

boolean weeklyPosSu = _getWeeklyDayPos(request, Calendar.SUNDAY, event, recurrence);
boolean weeklyPosMo = _getWeeklyDayPos(request, Calendar.MONDAY, event, recurrence);
boolean weeklyPosTu = _getWeeklyDayPos(request, Calendar.TUESDAY, event, recurrence);
boolean weeklyPosWe = _getWeeklyDayPos(request, Calendar.WEDNESDAY, event, recurrence);
boolean weeklyPosTh = _getWeeklyDayPos(request, Calendar.THURSDAY, event, recurrence);
boolean weeklyPosFr = _getWeeklyDayPos(request, Calendar.FRIDAY, event, recurrence);
boolean weeklyPosSa = _getWeeklyDayPos(request, Calendar.SATURDAY, event, recurrence);

int monthlyType = ParamUtil.getInteger(request, "monthlyType");
String monthlyTypeParam = ParamUtil.getString(request, "monthlyType");
if (Validator.isNull(monthlyTypeParam) && (event != null)) {
	if ((event.getRepeating()) && (recurrence != null)) {
		if (recurrence.getByMonthDay() == null) {
			monthlyType = 1;
		}
	}
}

int monthlyDay0 = ParamUtil.getInteger(request, "monthlyDay0", 15);
String monthlyDay0Param = ParamUtil.getString(request, "monthlyDay0");
if (Validator.isNull(monthlyDay0Param) && (event != null)) {
	if ((event.getRepeating()) && (recurrence != null)) {
		if (recurrence.getByMonthDay() != null) {
			monthlyDay0 = recurrence.getByMonthDay()[0];
		}
	}
}

int monthlyInterval0 = ParamUtil.getInteger(request, "monthlyInterval0", 1);
String monthlyInterval0Param = ParamUtil.getString(request, "monthlyInterval0");
if (Validator.isNull(monthlyInterval0Param) && (event != null)) {
	if ((event.getRepeating()) && (recurrence != null)) {
		monthlyInterval0 = recurrence.getInterval();
	}
}

int monthlyPos = ParamUtil.getInteger(request, "monthlyPos", 1);
String monthlyPosParam = ParamUtil.getString(request, "monthlyPos");
if (Validator.isNull(monthlyPosParam) && (event != null)) {
	if ((event.getRepeating()) && (recurrence != null)) {
		if (recurrence.getByMonth() != null) {
			monthlyPos = recurrence.getByMonth()[0];
		}
		else if (recurrence.getByDay() != null) {
			monthlyPos = recurrence.getByDay()[0].getDayPosition();
		}
	}
}

int monthlyDay1 = ParamUtil.getInteger(request, "monthlyDay1", Calendar.SUNDAY);
String monthlyDay1Param = ParamUtil.getString(request, "monthlyDay1");
if (Validator.isNull(monthlyDay1Param) && (event != null)) {
	if ((event.getRepeating()) && (recurrence != null)) {
		if (recurrence.getByMonth() != null) {
			monthlyDay1 = -1;
		}
		else if (recurrence.getByDay() != null) {
			monthlyDay1 = recurrence.getByDay()[0].getDayOfWeek();
		}
	}
}

int monthlyInterval1 = ParamUtil.getInteger(request, "monthlyInterval1", 1);
String monthlyInterval1Param = ParamUtil.getString(request, "monthlyInterval1");
if (Validator.isNull(monthlyInterval1Param) && (event != null)) {
	if ((event.getRepeating()) && (recurrence != null)) {
		monthlyInterval1 = recurrence.getInterval();
	}
}

int yearlyType = ParamUtil.getInteger(request, "yearlyType");
String yearlyTypeParam = ParamUtil.getString(request, "yearlyType");
if (Validator.isNull(yearlyTypeParam) && (event != null)) {
	if ((event.getRepeating()) && (recurrence != null)) {
		if (recurrence.getByMonth() != null) {
			yearlyType = 1;
		}
	}
}

int yearlyMonth0 = ParamUtil.getInteger(request, "yearlyMonth0", Calendar.JANUARY);
String yearlyMonth0Param = ParamUtil.getString(request, "yearlyMonth0");
if (Validator.isNull(yearlyMonth0Param) && (event != null)) {
	if ((event.getRepeating()) && (recurrence != null)) {
		if (recurrence.getByMonth() == null) {
			yearlyMonth0 = recurrence.getDtStart().get(Calendar.MONTH);
		}
	}
}

int yearlyDay0 = ParamUtil.getInteger(request, "yearlyDay0", 15);
String yearlyDay0Param = ParamUtil.getString(request, "yearlyDay0");
if (Validator.isNull(yearlyDay0Param) && (event != null)) {
	if ((event.getRepeating()) && (recurrence != null)) {
		if (recurrence.getByMonth() == null) {
			yearlyDay0 = recurrence.getDtStart().get(Calendar.DATE);
		}
	}
}

int yearlyInterval0 = ParamUtil.getInteger(request, "yearlyInterval0", 1);
String yearlyInterval0Param = ParamUtil.getString(request, "yearlyInterval0");
if (Validator.isNull(yearlyInterval0Param) && (event != null)) {
	if ((event.getRepeating()) && (recurrence != null)) {
		yearlyInterval0 = recurrence.getInterval();
	}
}

int yearlyPos = ParamUtil.getInteger(request, "yearlyPos", 1);
String yearlyPosParam = ParamUtil.getString(request, "yearlyPos");
if (Validator.isNull(yearlyPosParam) && (event != null)) {
	if ((event.getRepeating()) && (recurrence != null)) {
		if (recurrence.getByMonth() != null) {
			yearlyPos = recurrence.getByMonth()[0];
		}
		else if (recurrence.getByDay() != null) {
			yearlyPos = recurrence.getByDay()[0].getDayPosition();
		}
	}
}

int yearlyDay1 = ParamUtil.getInteger(request, "yearlyDay1", Calendar.SUNDAY);
String yearlyDay1Param = ParamUtil.getString(request, "yearlyDay1");
if (Validator.isNull(yearlyDay1Param) && (event != null)) {
	if ((event.getRepeating()) && (recurrence != null)) {
		if (recurrence.getByMonth() != null) {
			yearlyDay1 = -1;
		}
		else if (recurrence.getByDay() != null) {
			yearlyDay1 = recurrence.getByDay()[0].getDayOfWeek();
		}
	}
}

int yearlyMonth1 = ParamUtil.getInteger(request, "yearlyMonth1", Calendar.JANUARY);
String yearlyMonth1Param = ParamUtil.getString(request, "yearlyMonth1");
if (Validator.isNull(yearlyMonth1Param) && (event != null)) {
	if ((event.getRepeating()) && (recurrence != null)) {
		if (recurrence.getByMonth() != null) {
			yearlyMonth1 = recurrence.getByMonth()[0];
		}
	}
}

int yearlyInterval1 = ParamUtil.getInteger(request, "yearlyInterval1", 1);
String yearlyInterval1Param = ParamUtil.getString(request, "yearlyInterval1");
if (Validator.isNull(yearlyInterval1Param) && (event != null)) {
	if ((event.getRepeating()) && (recurrence != null)) {
		yearlyInterval1 = recurrence.getInterval();
	}
}

int endDateType = ParamUtil.getInteger(request, "endDateType");
String endDateTypeParam = ParamUtil.getString(request, "endDateType");
if (Validator.isNull(endDateTypeParam) && (event != null)) {
	if ((event.getRepeating()) && (recurrence != null)) {
		if (recurrence.getUntil() != null) {
			endDateType = 2;
		}
		else if (recurrence.getOccurrence() > 0) {
			endDateType = 1;
		}
	}
}

int endDateOccurrence = ParamUtil.getInteger(request, "endDateOccurrence", 10);
String endDateOccurrenceParam = ParamUtil.getString(request, "endDateOccurrence");
if (Validator.isNull(endDateOccurrenceParam) && (event != null)) {
	if ((event.getRepeating()) && (recurrence != null)) {
		endDateOccurrence = recurrence.getOccurrence();
	}
}

//minh close String remindBy = BeanParamUtil.getString(event, request, "remindBy", CalEventImpl.REMIND_BY_EMAIL);
int remindBy = BeanParamUtil.getInteger(event, request, "remindBy", CalEventImpl.REMIND_BY_EMAIL);
int firstReminder = BeanParamUtil.getInteger(event, request, "firstReminder", (int)Time.MINUTE * 15);
int secondReminder = BeanParamUtil.getInteger(event, request, "secondReminder", (int)Time.MINUTE * 5);

//Trieu add20091023
String description = "";
if (eventId > 0){
	event = CalEventLocalServiceUtil.getCalEvent(eventId);
	if (event !=null){
		description = event.getDescription();
	}	
}
String editorParam = "description"; // ten truong luu du lieu
String editorContent = description;
%>

<script type="text/javascript">
	
	function <portlet:namespace />saveEvent() {
		<portlet:namespace />changeFormat();
		document.<portlet:namespace />fm.<portlet:namespace /><%= Constants.CMD %>.value = "<%= event == null ? Constants.ADD : Constants.UPDATE %>";
		document.<portlet:namespace />fm.<portlet:namespace />orgIds.value = Liferay.Util.listCheckedExcept(document.<portlet:namespace />fm, "chkItems");
		
		var is2 = 0;
		if(document.<portlet:namespace />fm.<portlet:namespace />allDayCheckbox.checked){
			is2++;
		}
		if(document.<portlet:namespace />fm.<portlet:namespace />morningCheckbox.checked){
			is2++;
		}
		if(document.<portlet:namespace />fm.<portlet:namespace />afternoonCheckbox.checked){
			is2++;
		}
		
		//if(document.<portlet:namespace />fm.<portlet:namespace />eveningCheckbox.checked){
		//	is2++;
		//}
		
		if(is2>1){
			alert('<liferay-ui:message key="chi-chon-1-diem" />');
			document.<portlet:namespace />fm.<portlet:namespace />allDayCheckbox.focus();
		}
		else{
			submitForm(document.<portlet:namespace />fm);
		}
	}
	
	function <portlet:namespace />showHideAdvance(objShowHide) {
		if(objShowHide && objShowHide!=""){
			var obj = window.document.getElementById(objShowHide + "");
			if (obj && obj.style) {
				if (obj.style.display == "block") {
					obj.style.display = "none";
					document.<portlet:namespace />fm.<portlet:namespace />showPortletSearch.value = "false";
				}
				else {
					obj.style.display = "block";
					document.<portlet:namespace />fm.<portlet:namespace />showPortletSearch.value = "true";
				}
			}
		}
	}
	
function <portlet:namespace />initEditor(){
		return "<%= UnicodeFormatter.toString(editorContent)%>";
	}
	
	function <portlet:namespace />changeFormat() {
		if (window.<portlet:namespace />editor) {
			document.<portlet:namespace />fm.<portlet:namespace /><%=editorParam%>.value = window.<portlet:namespace />editor.getHTML();	
		}
	}
</script>

<form action="<portlet:actionURL windowState="<%= WindowState.NORMAL.toString() %>"><portlet:param name="struts_action" value="/ext/meeting_calendar/edit_event" /></portlet:actionURL>" method="post" enctype="multipart/form-data" name="<portlet:namespace />fm" onSubmit="<portlet:namespace />saveEvent(); return false;" class="meeting_calendar_bg">
<div class="boxcom">
<div class="titlecategr"><h4><p><liferay-ui:message key="nss-lich-cong-tac-tuan"/></p></h4></div>
<br /><br />
<input name="<portlet:namespace /><%= Constants.CMD %>" type="hidden" value="" />
<input name="<portlet:namespace />redirect" type="hidden" value="<%= HtmlUtil.escape(redirect) %>" />
<input name="<portlet:namespace />eventId" type="hidden" value="<%= eventId %>" />
<input name="<portlet:namespace />mcalId" type="hidden" value="<%= mcalId %>" />
<input name="<portlet:namespace />orgIds" type="hidden" value="" />
<input name="<portlet:namespace />timeZoneSensitive" type="hidden" value="true" />
<input name="<portlet:namespace />recurrenceType" type="hidden" value="<%= Recurrence.NO_RECURRENCE%>" />
<input name="<portlet:namespace />repeatWeek" type="hidden" value="<%= repeatWeek%>" />
<liferay-util:include page="/html/portlet/ext/meeting_calendar/tabs1.jsp" />
<div class="borderendTab">
<liferay-ui:error exception="<%= EventDurationException.class %>" message="please-enter-a-longer-duration" />
<liferay-ui:error exception="<%= EventStartDateException.class %>" message="please-enter-a-valid-start-date" />
<liferay-ui:error exception="<%= DuplicateRoomException.class %>" message="khong-the-hop-tai-2-dia-diem" />
<liferay-ui:error exception="<%= EventEndDateException.class %>" message="please-enter-a-valid-end-date" />

<table cellspacing="0" width="100%">
		<tr>
			<td width="15%" class="td-left">
				<liferay-ui:message key="start-date" />&nbsp;:
			</td>
			<td class="td-right">
				<liferay-ui:input-field model="<%= CalEvent.class %>" bean="<%= event %>" field="startDate" defaultValue="<%= startDate %>" />
			</td>
		</tr>
		<tr style="display:none;">
			<td class="td-left">
				<liferay-ui:message key="duration" />&nbsp;:
			</td>
			
			<td class="td-right">
				<select name="<portlet:namespace />durationHour">
					<option <%= (durationHour.equals("0")) ? "selected" : "" %> value="0">0</option>
					<option <%= (durationHour.equals("1")) ? "selected" : "" %> value="1">1</option>
					<option <%= (durationHour.equals("2")) ? "selected" : "" %> value="2">2</option>
					<option <%= (durationHour.equals("3")) ? "selected" : "" %> value="3">3</option>
					<option <%= (durationHour.equals("4")) ? "selected" : "" %> value="4">4</option>
					<option <%= (durationHour.equals("5")) ? "selected" : "" %> value="5">5</option>
					<option <%= (durationHour.equals("6")) ? "selected" : "" %> value="6">6</option>
					<option <%= (durationHour.equals("7")) ? "selected" : "" %> value="7">7</option>
					<option <%= (durationHour.equals("8")) ? "selected" : "" %> value="8">8</option>
				</select>

				<liferay-ui:message key="hours" />

				<select name="<portlet:namespace />durationMinute">
					<option <%= (durationMinute.equals("00")) ? "selected" : "" %> value="00">:00</option>
					<option <%= (durationMinute.equals("15")) ? "selected" : "" %> value="15">:15</option>
					<option <%= (durationMinute.equals("30")) ? "selected" : "" %> value="30">:30</option>
					<option <%= (durationMinute.equals("45")) ? "selected" : "" %> value="45">:45</option>
				</select>

				<liferay-ui:message key="minutes" />
			</td>
		</tr>
		<tr>
			<td class="td-left">
			</td>
			<td class="td-right">
				<liferay-ui:message key="all-day" />&nbsp;<liferay-ui:input-checkbox param="allDay" defaultValue="<%= event == null ? false : event.isAllDay() %>" />
				<liferay-ui:message key="buoi-sang" />&nbsp;<liferay-ui:input-checkbox param="morning" defaultValue="<%= morning %>" />
				<liferay-ui:message key="buoi-chieu" />&nbsp;<liferay-ui:input-checkbox param="afternoon" defaultValue="<%= afternoon %>" />
			</td>
		</tr>
		<c:choose>
			<c:when test='<%= portletGroupId.longValue() == 14%>'>
				<tr>
					<td class="td-left">
						<liferay-ui:message key="type" />&nbsp;:
					</td>
					<td class="td-right">
						<select name="<portlet:namespace />type">
							<%
							for (int i = 0; i < MeetingCalendarImpl.TYPES.length; i++) {
							%>
								<option <%= type.equals(MeetingCalendarImpl.TYPES[i]) ? "selected" : "" %> value="<%= MeetingCalendarImpl.TYPES[i] %>"><%= LanguageUtil.get(pageContext, MeetingCalendarImpl.TYPES[i]) %></option>
							<%
							}
							%>
						</select>
					</td>
				</tr>
			</c:when>
			<c:otherwise>
				<input name="<portlet:namespace />type" type="hidden" value="<%= type %>" />
			</c:otherwise>
		</c:choose>
		
		<tr>
			<td class="td-left">
				<liferay-ui:message key="sponsor" />&nbsp;:
			</td>
			<td class="td-right">
				<input name="<portlet:namespace />title" type="text" size=20 value="<%= title_cal %>" style="width:500px" />
				
			</td>
		</tr>
		<tr>
			<td valign="top" class="td-left">
				<liferay-ui:message key="content" />&nbsp;:
			</td>
			<td class="td-right">
				<liferay-ui:input-editor/>
				<input name="<portlet:namespace /><%=editorParam %>" type="hidden"/>
			</td>
		</tr>
		<tr>
			<td class="td-left">
				<liferay-ui:message key="room" />&nbsp;:
			</td>
			<td class="td-right">
				<%
				if(portletGroupId.longValue() == 14){
				%>
				<select name="<portlet:namespace />place">
					<option value="" selected >--- <%= LanguageUtil.get(pageContext, "room-different")%> ---</option><%
					for (int i = 0; i < MeetingCalendarImpl.ROOMS.length; i++) {
				%>
						<option <%= place.equals(MeetingCalendarImpl.ROOMS[i]) ? "selected" : "" %> value="<%= MeetingCalendarImpl.ROOMS[i] %>"><%= LanguageUtil.get(pageContext, MeetingCalendarImpl.ROOMS[i]) %></option>
				<%
					}
				%>
				</select>
				<%
				}
				else{
				%>
				<input name="<portlet:namespace />place" type="hidden" value="" />
				<%
				}
				%>
				<!--<liferay-ui:message key="or-enter-room-name" />:--> 
				
				<liferay-ui:input-field model="<%= MeetingCalendar.class %>" bean="<%= mcalendar %>" field="place_diff" />
			</td>
		</tr>
		<tr>
			<td class="td-left">
				<liferay-ui:message key="note" />&nbsp;:
			</td>
			<td class="td-right">
				<liferay-ui:input-field model="<%= MeetingCalendar.class %>" bean="<%= mcalendar %>" field="note" />
			</td>
		</tr>
		<tr style="display: none;">
			<td class="td-left"><liferay-ui:message key="file-upload" /></td>
			<td class="td-right">
				<input style="width: 100%;" id="uploadFile" name="<portlet:namespace />uploadMCal" type="file" onkeypress="return false;" />
			</td>
		</tr>
		<tr>
			<td valign="top" class="td-left">
				<liferay-ui:message key="component" />&nbsp;:
			</td>
			<td class="td-right">
				<liferay-ui:input-field model="<%= MeetingCalendar.class %>" bean="<%= mcalendar %>" field="component" />
			</td>
		</tr>
		<tr>
			<td class="td-left">
				<liferay-ui:message key="prior" />&nbsp;:
			</td>
			<td class="td-right">
				<liferay-ui:input-checkbox param="prior" defaultValue="<%= prior %>" />
			</td>
		</tr>
		<tr>
			<td></td>
			<td>
				<input type="submit" value="<liferay-ui:message key="save" />" />
				<input type="button" value="<liferay-ui:message key="cancel" />" onClick="location.href = '<%= HtmlUtil.escape(redirect) %>';" />
			</td>
		</tr>
		<!-- lap lai default ko su dung -->
		<tr>
			<td>
			</td>
			<td>
				<div id="repeatLiferay" class="div" style="display:none;">				
				<input <%= (endDateType == 2) ? "checked" : "" %> name="<portlet:namespace />endDateType" type="radio" value="2"> <liferay-ui:message key="end-by" />
				<liferay-ui:input-field model="<%= CalEvent.class %>" bean="<%= event %>" field="endDate" defaultValue="<%= endDate %>" />
				</div>
			</td>
		</tr>
	<tr>
	<%
	if(portletGroupId.longValue() == 14){
	%>
	<td valign="top">
		<%
		
		List<Organization> orgList = new ArrayList();
		long[] listorgIds = null;
		if(mcalComp!=null){
			String groupIds = mcalComp.getGroupIds();		
			
			String[] listgroupId = groupIds.split(",");
			listorgIds = new long[listgroupId.length];
			
			for(int i=0; i<listgroupId.length; i++){
				Group group = null;
				try{
					group = GroupLocalServiceUtil.getGroup(Long.valueOf(listgroupId[i]));
				}
				catch(Exception e){
				}
				if(group!=null){
					Organization org = OrganizationLocalServiceUtil.getOrganization(group.getClassPK());
					listorgIds[i] = org.getOrganizationId();
					orgList.add(org);
				}
			}
		}
		else{
			listorgIds = new long[0];
		}
		PortletURL portletURL = renderResponse.createRenderURL();
		OrganizationSearch searchContainerOrg = new OrganizationSearch(renderRequest, portletURL);
		LinkedHashMap organizationParams = new LinkedHashMap();
		long parentOrganizationId = OrganizationConstants.DEFAULT_PARENT_ORGANIZATION_ID;
		
		//List parentresults = OrganizationLocalServiceUtil.search(company.getCompanyId(), parentOrganizationId, searchTermsOrg.getName(), searchTermsOrg.getType(), searchTermsOrg.getStreet(), searchTermsOrg.getCity(), searchTermsOrg.getZip(), searchTermsOrg.getRegionIdObj(), searchTermsOrg.getCountryIdObj(), organizationParams, searchTermsOrg.isAndOperator(), searchContainerOrg.getStart(), searchContainerOrg.getEnd(), searchContainerOrg.getOrderByComparator());
		List parentresults = OrganizationLocalServiceUtil.search(company.getCompanyId(), parentOrganizationId, null, null, null, null, null, null, null, organizationParams, true, -1, -1, searchContainerOrg.getOrderByComparator());
//minh close 20101116		List parentresults = OrganizationLocalServiceUtil.search(company.getCompanyId(), parentOrganizationId, null, -1, null, null, null, null, null, organizationParams, true, -1, -1, searchContainerOrg.getOrderByComparator());
		%>
		<span style="align:center;color:#0033FF;font-size:16px;"><b><liferay-ui:message key="don-vi-nhan-lich"/></b></span>
		<br />
		<%
		for (int i = 0; i < parentresults.size(); i++) {
			Organization parentcurOrganization = (Organization) parentresults.get(i);
			List results = OrganizationLocalServiceUtil.search(company.getCompanyId(), parentcurOrganization.getOrganizationId(), null, null, null, null, null, null, null, organizationParams, true, -1, -1, searchContainerOrg.getOrderByComparator());
//minh close 20101116		List results = OrganizationLocalServiceUtil.search(company.getCompanyId(), parentcurOrganization.getOrganizationId(), null, -1, null, null, null, null, null, organizationParams, true, -1, -1, searchContainerOrg.getOrderByComparator());
			Organization curOrganization = null;
			String randomNamespace = PwdGenerator.getPassword(PwdGenerator.KEY3, 4);
		%>
			<%---
			<liferay-ui:panel-container id='<%= portletDisplay.getNamespace() + parentcurOrganization.getOrganizationId() %>' persistState="<%= true %>" extended="<%= Boolean.FALSE %>" cssClass="journal-extras">
			<liferay-ui:panel id="2_2" title="<%= parentcurOrganization.getName() %>" defaultState="openned" persistState="<%= true %>" extended="<%= false %>">
			---%>				
			<div class="div_content_scroll_popup">
				<table border="0" class="table_popup" align="left" style="margin: 1px;" width="100%">
							<tr>
								<td>
									<input type="checkbox" id="chkItems" name="chkItems" onclick="Liferay.Util.checkAll(<portlet:namespace />fm,'<%=randomNamespace%>chkItem',this);">
								</td>
								<td>
									<liferay-ui:message key="all"/>
								</td>
							</tr>
					<%
					if (results != null) {
						String nametr = "tr_le";
						String nametd = "td_le";
						Iterator itrresults = results.iterator();
						int j = 0;
						boolean checked = false;
						while (itrresults.hasNext()) {
							//docAreaItem = (HQ_TB_Ext_DocArea) itrDocAreas.next();
							curOrganization = (Organization) itrresults.next();
							if(listorgIds.length > 0){
								for(int t=0; t<listorgIds.length; t++){
									if(curOrganization.getOrganizationId() == listorgIds[t]){
										checked = true;
										break;
									}
								}
							}
							++j;
							if (j % 2 == 0) {
								nametr = "tr_chan";
								nametd = "td_chan";
							}	
					%>
							<tr class="<%= nametr %>" style="cursor: pointer;">
								<td class="<%= nametd %>">
									<input type="checkbox" <%= checked == true ? "checked" : ""%> value="<%= curOrganization.getOrganizationId()%>" id="<%= curOrganization.getOrganizationId()%>" name="<%=randomNamespace%>chkItem">
								</td>
								<td class="<%= nametd %>" <%= checked == true ? "style=\"font-weight:bold\"" : ""%> onclick="<portlet:namespace />selectRowDA(<%= curOrganization.getOrganizationId()%>);">
									<%= curOrganization.getName()%>
								</td>
							</tr>
					<%
							nametr = "tr_le";
							nametd = "td_le";
							checked = false;
						}
					}
					%>			
				</table>
			</div>

			<br />
			<%
		}
		%>
	</td>
	<%
	}
	%>
</tr>
</table>
</div>
</div>
</form>

<script type="text/javascript">
	
	function <portlet:namespace />saveFileCalendar() {
		var actionId = "" + document.<portlet:namespace />fm.<portlet:namespace	/>idAction.value;
		document.<portlet:namespace />fm.<portlet:namespace /><%= Constants.CMD%>.value = "<%=Constants.UPDATE%>";
		var checkValue = document.getElementById("ckbActive");
		
		if(actionId == "" || actionId == "0"){
			var url = '<liferay-portlet:actionURL windowState="<%=WindowState.NORMAL.toString()%>"><portlet:param name="struts_action" value="/ext/iereport/addnew" /></liferay-portlet:actionURL>';
			var checkValue = document.getElementById("ckbActive");
			if(checkValue.checked == true){
				document.<portlet:namespace />fm.<portlet:namespace />forwardCheckValue.value = 1;
			}
			else document.<portlet:namespace />fm.<portlet:namespace />forwardCheckValue.value = 0;
		}
		
		else{
			var url = '<liferay-portlet:actionURL windowState="<%=WindowState.NORMAL.toString()%>"><portlet:param name="struts_action" value="/ext/iereport/updateaction" /></liferay-portlet:actionURL>';
			if(actionId != "" && actionId != "0"){
				if(checkValue.checked == true){
					document.<portlet:namespace />fm.<portlet:namespace />forwardCheckValue.value = 1;
				}
				else {
					document.<portlet:namespace />fm.<portlet:namespace />forwardCheckValue.value = 0; 
				}	
			}
		}
		submitForm(document.<portlet:namespace />fm, url);
	}
	
	function <portlet:namespace />selectRowDA(idx) {
		if(idx && idx!=""){
			var objItem = document.getElementById("" + idx);
			if (objItem && objItem.type == "checkbox") {
				objItem.checked = !objItem.checked;
			}
			return;
		}
	};
	

</script>

<%!
private boolean _getWeeklyDayPos(HttpServletRequest req, int day, CalEvent event, Recurrence recurrence) {
	boolean weeklyPos = ParamUtil.getBoolean(req, "weeklyDayPos" + day);

	String weeklyPosParam = ParamUtil.getString(req, "weeklyDayPos" + day);

	if (Validator.isNull(weeklyPosParam) && (event != null)) {
		if ((event.getRepeating()) && (recurrence != null)) {
			DayAndPosition[] dayPositions = recurrence.getByDay();

			if (dayPositions != null) {
				for (int i = 0; i < dayPositions.length; i++) {
					if (dayPositions[i].getDayOfWeek() == day) {
						return true;
					}
				}
			}
		}
	}

	return weeklyPos;
}
%>