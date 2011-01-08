package com.ext.portlet.meetingcalendar.action;
import com.liferay.documentlibrary.service.DLLocalServiceUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.ext.portlet.meetingcalendar.DuplicateRoomException;
import com.ext.portlet.meetingcalendar.model.MeetingCalendar;
import com.ext.portlet.meetingcalendar.service.MeetingCalendarLocalServiceUtil;
import com.ext.portlet.meetingcalendar.service.MeetingCalendarServiceUtil;
import com.ext.portlet.meetingcalendar.service.MeetingCalComponentLocalServiceUtil;
import com.liferay.portal.PortalException;
import com.liferay.portal.kernel.cal.DayAndPosition;
import com.liferay.portal.kernel.cal.Duration;
import com.liferay.portal.kernel.cal.Recurrence;
import com.liferay.portal.kernel.cal.TZSRecurrence;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.CalendarFactoryUtil;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.TimeZoneUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CompanyConstants;
import com.liferay.portal.model.Layout;
import com.liferay.portal.model.User;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.struts.ActionConstants;
import com.liferay.portal.struts.PortletAction;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portal.util.WebKeys;
import com.liferay.portlet.ActionResponseImpl;
import com.liferay.portlet.calendar.EventDurationException;
import com.liferay.portlet.calendar.EventEndDateException;
import com.liferay.portlet.calendar.EventStartDateException;
import com.liferay.portlet.calendar.EventTitleException;
import com.liferay.portlet.calendar.NoSuchEventException;
import com.liferay.portlet.calendar.model.CalEvent;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ObjectValuePair;
import com.liferay.util.servlet.ServletResponseUtil;
import com.liferay.portal.kernel.util.GetterUtil;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.io.File;
import java.io.InputStream;

import javax.portlet.PortletRequest;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * <a href="EditMeetingCalendarAction.java.html"><b><i>View Source</i></b></a>
 *
 * @author DUYDUONG
 *
 */
public class EditMeetingCalendarAction extends PortletAction {

	public void processAction(
			ActionMapping mapping, ActionForm form, PortletConfig portletConfig,
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		String cmd = ParamUtil.getString(actionRequest, Constants.CMD);

		try {
			if (cmd.equals(Constants.ADD) || cmd.equals(Constants.UPDATE)) {
				updateEvent(actionRequest, actionResponse);
			}
			else if (cmd.equals(Constants.DELETE)) {
				deleteEvent(actionRequest);
			}else if(cmd.equals("APPROVE_CALENDAR")){
				approveMCal(actionRequest,actionResponse);
			}
			else if(cmd.equals(Constants.CANCEL)){
				cancelEvent(actionRequest);
			}
			else if(cmd.equals("DOWNLOAD")){
				long mcalId = ParamUtil.getLong(actionRequest, "MCalId");
				String fileName = ParamUtil.getString(actionRequest, "attachment");

				HttpServletResponse httpRes =
					((ActionResponseImpl)actionResponse).getHttpServletResponse();

				getFile(mcalId, fileName, httpRes);

				setForward(actionRequest, ActionConstants.COMMON_NULL);
			}
			
			sendRedirect(actionRequest, actionResponse);
		}
		catch (Exception e) {
			if (e instanceof NoSuchEventException ||
				e instanceof PrincipalException) {

				SessionErrors.add(actionRequest, e.getClass().getName());

				setForward(actionRequest, "portlet.ext.meeting_calendar.error");
			}
			else if (e instanceof EventDurationException ||
					 e instanceof EventEndDateException ||
					 e instanceof EventStartDateException ||
					 e instanceof EventTitleException||
					 e instanceof DuplicateRoomException
					 ) {

				SessionErrors.add(actionRequest, e.getClass().getName());
			}
			else {
				throw e;
			}
		}
	}
	
	protected long[] getLongArray(PortletRequest portletRequest, String name) {
		String value = portletRequest.getParameter(name);

		if (value == null) {
			return null;
		}

		return StringUtil.split(GetterUtil.getString(value), 0L);
	}
	
	protected void getFile(
			long mcalId, String fileName, HttpServletResponse res)
		throws Exception {

		InputStream is = null;

		try {
			MeetingCalendar mCal = MeetingCalendarLocalServiceUtil.getMCalById(mcalId);

			is = DLLocalServiceUtil.getFileAsStream(
					mCal.getCompanyId(), CompanyConstants.SYSTEM,
					"MCALFolder" + "/" + String.valueOf(mCal.getMcalId()) + "/" + fileName);

			String contentType = MimeTypesUtil.getContentType(fileName);

			ServletResponseUtil.sendFile(res, fileName, is, contentType);
			
			//MeetingCalendarLocalServiceUtil.updateDownloadCount(mCal);
			
		}
		finally {
			ServletResponseUtil.cleanUp(is);
		}
	}
	
	public ActionForward render(
			ActionMapping mapping, ActionForm form, PortletConfig portletConfig,
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws Exception {

		try {
			ActionUtil.getEvent(renderRequest);
		}
		catch (Exception e) {
			if (e instanceof NoSuchEventException ||
				e instanceof PrincipalException) {

				SessionErrors.add(renderRequest, e.getClass().getName());

				return mapping.findForward("portlet.ext.meeting_calendar.error");
			}
			else {
				throw e;
			}
		}

		return mapping.findForward(
			getForward(renderRequest, "portlet.ext.meeting_calendar.edit_event"));
	}

	protected void addWeeklyDayPos(
		ActionRequest actionRequest, List<DayAndPosition> list, int day) {

		if (ParamUtil.getBoolean(actionRequest, "weeklyDayPos" + day)) {
			list.add(new DayAndPosition(day, 0));
		}
	}

	protected void deleteEvent(ActionRequest actionRequest) throws Exception {
		long eventId = ParamUtil.getLong(actionRequest, "eventId");
		Layout layout = (Layout)actionRequest.getAttribute(WebKeys.LAYOUT);
		
		MeetingCalendarServiceUtil.deleteEvent(layout.getPlid(), eventId);
		MeetingCalendarLocalServiceUtil.deleteMCal(eventId);
		MeetingCalComponentLocalServiceUtil.deleteMCalComponent(eventId);
	}
	
	protected void cancelEvent(ActionRequest actionRequest) throws Exception {
		long eventId = ParamUtil.getLong(actionRequest, "eventId");
		
		MeetingCalendarLocalServiceUtil.cancelMCal(eventId);
	}
	
	protected void updateEvent(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		Layout layout = (Layout)actionRequest.getAttribute(WebKeys.LAYOUT);

		long eventId = ParamUtil.getLong(actionRequest, "eventId");

		String title = ParamUtil.getString(actionRequest, "title");
		
		if(Validator.isNull(title) || title.equals(StringPool.BLANK)){
			title = MeetingCalendarKey.KHONG_CO_CHU_TRI;
		}
		
		String description = ParamUtil.getString(actionRequest, "description");
		/*Duy Duong close start 21/12/2008
		if(Validator.isNull(description)){
			throw new ContentCalendarNullException();
		}
		*/
		
		int startDateMonth = ParamUtil.getInteger(
			actionRequest, "startDateMonth");
		int startDateDay = ParamUtil.getInteger(actionRequest, "startDateDay");
		int startDateYear = ParamUtil.getInteger(
			actionRequest, "startDateYear");
		int startDateHour = ParamUtil.getInteger(
			actionRequest, "startDateHour");
		int startDateMinute = ParamUtil.getInteger(
			actionRequest, "startDateMinute");
		int startDateAmPm = ParamUtil.getInteger(
			actionRequest, "startDateAmPm");

		if (startDateAmPm == Calendar.PM) {
			startDateHour += 12;
		}

		int durationHour = ParamUtil.getInteger(actionRequest, "durationHour");
		int durationMinute = ParamUtil.getInteger(
			actionRequest, "durationMinute");
		boolean allDay = ParamUtil.getBoolean(actionRequest, "allDay");
		boolean timeZoneSensitive = ParamUtil.getBoolean(
			actionRequest, "timeZoneSensitive");
		String type = ParamUtil.getString(actionRequest, "type");

		int endDateMonth = ParamUtil.getInteger(actionRequest, "endDateMonth");
		int endDateDay = ParamUtil.getInteger(actionRequest, "endDateDay");
		int endDateYear = ParamUtil.getInteger(actionRequest, "endDateYear");

		boolean repeating = false;

		int recurrenceType = ParamUtil.getInteger(
			actionRequest, "recurrenceType");

		if (recurrenceType != Recurrence.NO_RECURRENCE) {
			repeating = true;
		}

		Locale locale = null;
		TimeZone timeZone = null;

		if (timeZoneSensitive) {
			User user = PortalUtil.getUser(actionRequest);

			locale = user.getLocale();
			timeZone = user.getTimeZone();
		}
		else {
			locale = LocaleUtil.getDefault();
			timeZone = TimeZoneUtil.getDefault();
		}
		
		Calendar startDate = CalendarFactoryUtil.getCalendar(timeZone, locale);

		startDate.set(Calendar.MONTH, startDateMonth);
		startDate.set(Calendar.DATE, startDateDay);
		startDate.set(Calendar.YEAR, startDateYear);
		startDate.set(Calendar.HOUR_OF_DAY, startDateHour);
		startDate.set(Calendar.MINUTE, startDateMinute);
		startDate.set(Calendar.SECOND, 0);
		startDate.set(Calendar.MILLISECOND, 0);

		if (allDay) {
			startDate.set(Calendar.HOUR_OF_DAY, 0);
			startDate.set(Calendar.MINUTE, 0);
			startDate.set(Calendar.SECOND, 0);
			startDate.set(Calendar.MILLISECOND, 0);

			durationHour = 24;
			durationMinute = 0;
		}

		TZSRecurrence recurrence = null;

		if (repeating) {
			Calendar recStartCal = null;

			if (timeZoneSensitive) {
				recStartCal = CalendarFactoryUtil.getCalendar();

				recStartCal.setTime(startDate.getTime());
			}
			else {
				recStartCal = (Calendar)startDate.clone();
			}

			recurrence = new TZSRecurrence(
				recStartCal, new Duration(1, 0, 0, 0), recurrenceType);

			recurrence.setWeekStart(Calendar.SUNDAY);

			if (recurrenceType == Recurrence.DAILY) {
				int dailyType = ParamUtil.getInteger(
					actionRequest, "dailyType");

				if (dailyType == 0) {
					int dailyInterval = ParamUtil.getInteger(
						actionRequest, "dailyInterval", 1);

					recurrence.setInterval(dailyInterval);
				}
				else {
					DayAndPosition[] dayPos = {
						new DayAndPosition(Calendar.MONDAY, 0),
						new DayAndPosition(Calendar.TUESDAY, 0),
						new DayAndPosition(Calendar.WEDNESDAY, 0),
						new DayAndPosition(Calendar.THURSDAY, 0),
						new DayAndPosition(Calendar.FRIDAY, 0)};

					recurrence.setByDay(dayPos);
				}
			}
			else if (recurrenceType == Recurrence.WEEKLY) {
				int weeklyInterval = ParamUtil.getInteger(
					actionRequest, "weeklyInterval", 1);

				recurrence.setInterval(weeklyInterval);

				List<DayAndPosition> dayPos = new ArrayList<DayAndPosition>();

				addWeeklyDayPos(actionRequest, dayPos, Calendar.SUNDAY);
				addWeeklyDayPos(actionRequest, dayPos, Calendar.MONDAY);
				addWeeklyDayPos(actionRequest, dayPos, Calendar.TUESDAY);
				addWeeklyDayPos(actionRequest, dayPos, Calendar.WEDNESDAY);
				addWeeklyDayPos(actionRequest, dayPos, Calendar.THURSDAY);
				addWeeklyDayPos(actionRequest, dayPos, Calendar.FRIDAY);
				addWeeklyDayPos(actionRequest, dayPos, Calendar.SATURDAY);

				if (dayPos.size() == 0) {
					dayPos.add(new DayAndPosition(Calendar.MONDAY, 0));
				}

				recurrence.setByDay(dayPos.toArray(new DayAndPosition[0]));
			}
			else if (recurrenceType == Recurrence.MONTHLY) {
				int monthlyType = ParamUtil.getInteger(
					actionRequest, "monthlyType");

				if (monthlyType == 0) {
					int monthlyDay = ParamUtil.getInteger(
						actionRequest, "monthlyDay0");

					recurrence.setByMonthDay(new int[] {monthlyDay});

					int monthlyInterval = ParamUtil.getInteger(
						actionRequest, "monthlyInterval0", 1);

					recurrence.setInterval(monthlyInterval);
				}
				else {
					int monthlyPos = ParamUtil.getInteger(
						actionRequest, "monthlyPos");
					int monthlyDay = ParamUtil.getInteger(
						actionRequest, "monthlyDay1");

					DayAndPosition[] dayPos = {
						new DayAndPosition(monthlyDay, monthlyPos)};

					recurrence.setByDay(dayPos);

					int monthlyInterval = ParamUtil.getInteger(
						actionRequest, "monthlyInterval1", 1);

					recurrence.setInterval(monthlyInterval);
				}
			}
			else if (recurrenceType == Recurrence.YEARLY) {
				int yearlyType = ParamUtil.getInteger(
					actionRequest, "yearlyType");

				if (yearlyType == 0) {
					int yearlyMonth = ParamUtil.getInteger(
						actionRequest, "yearlyMonth0");
					int yearlyDay = ParamUtil.getInteger(
						actionRequest, "yearlyDay0");

					recurrence.setByMonth(new int[] {yearlyMonth});
					recurrence.setByMonthDay(new int[] {yearlyDay});

					int yearlyInterval = ParamUtil.getInteger(
						actionRequest, "yearlyInterval0", 1);

					recurrence.setInterval(yearlyInterval);
				}
				else {
					int yearlyPos = ParamUtil.getInteger(
						actionRequest, "yearlyPos");
					int yearlyDay = ParamUtil.getInteger(
						actionRequest, "yearlyDay1");
					int yearlyMonth = ParamUtil.getInteger(
						actionRequest, "yearlyMonth1");

					DayAndPosition[] dayPos = {
						new DayAndPosition(yearlyDay, yearlyPos)};

					recurrence.setByDay(dayPos);

					recurrence.setByMonth(new int[] {yearlyMonth});

					int yearlyInterval = ParamUtil.getInteger(
						actionRequest, "yearlyInterval1", 1);

					recurrence.setInterval(yearlyInterval);
				}
			}

			int endDateType = ParamUtil.getInteger(
				actionRequest, "endDateType");

			if (endDateType == 1) {
				int endDateOccurrence = ParamUtil.getInteger(
					actionRequest, "endDateOccurrence");

				recurrence.setOccurrence(endDateOccurrence);
			}
			else if (endDateType == 2) {
				Calendar recEndCal = null;

				if (timeZoneSensitive) {
					recEndCal = CalendarFactoryUtil.getCalendar();

					recEndCal.setTime(startDate.getTime());
				}
				else {
					recEndCal = (Calendar)startDate.clone();
				}

				recEndCal.set(Calendar.MONTH, endDateMonth);
				recEndCal.set(Calendar.DATE, endDateDay);
				recEndCal.set(Calendar.YEAR, endDateYear);

				recurrence.setUntil(recEndCal);
			}
		}

		//int remindBy = 0;//ParamUtil.getString(actionRequest, "remindBy");
		String remindBy = ParamUtil.getString(actionRequest, "remindBy");
		
		//huynh phuoc add start 27/20/2008
		String place  = ParamUtil.getString(actionRequest, "place");
		String place_diff  = ParamUtil.getString(actionRequest, "place_diff");
		String note  = ParamUtil.getString(actionRequest, "note");
		String component  = ParamUtil.getString(actionRequest, "component");
		//Duy Duong close:validate(place, place_diff);
		//huynh phuoc add end 27/20/2008
//Hai Trieu add 20091023
		//validate(description, place, place_diff);
		validate(place, place_diff);
		int firstReminder = ParamUtil.getInteger(
			actionRequest, "firstReminder");
		int secondReminder = ParamUtil.getInteger(
			actionRequest, "secondReminder");

		boolean repeatWeek = ParamUtil.getBoolean(actionRequest, "repeatWeek");
		boolean morning  = ParamUtil.getBoolean(actionRequest, "morning");
		boolean afternoon  = ParamUtil.getBoolean(actionRequest, "afternoon");
		boolean evening  = ParamUtil.getBoolean(actionRequest, "evening");
		boolean prior  = ParamUtil.getBoolean(actionRequest, "prior");
		if (morning){
			startDateHour = 8;
			startDateMinute = 0;
			
			durationHour = 4;
			durationMinute = 0;
		}
		else if(afternoon){
			startDateHour = 13;
			startDateMinute = 0;
			
			durationHour = 4;
			durationMinute = 0;
		}
		else if(evening){
			startDateHour = 17;
			startDateMinute = 0;
			
			durationHour = 4;
			durationMinute = 0;
		}
		startDate.set(Calendar.HOUR_OF_DAY, startDateHour);
		startDate.set(Calendar.MINUTE, startDateMinute);
		
		// upload fie
		UploadPortletRequest uploadReq = 
			PortalUtil.getUploadPortletRequest(actionRequest);
		
		File fileItem = uploadReq.getFile("uploadMCal");
		String fileName = uploadReq.getFileName("uploadMCal");
		byte[] bytes = FileUtil.getBytes(fileItem);
		ObjectValuePair<String, byte[]> file = new ObjectValuePair<String, byte[]>(null, null);
		if (bytes != null && bytes.length > 0) file = new ObjectValuePair<String, byte[]> (fileName, bytes);
		/*
		ServiceContext serviceContext = ServiceContextFactory.getInstance(
				CalEvent.class.getName(), actionRequest);
		*/
	
		// lay danh sach cac org
		/*long[] listOrgIds = getLongArray(
			actionRequest, "organizationsSearchContainerPrimaryKeys");*/
		String[] orgIds = StringUtil.split(ParamUtil.getString(actionRequest, "orgIds"));
		String strorgIds = "";
		for(int i=0; i< orgIds.length; i++){
			if(!orgIds[i].equals("on")){
				if(i == orgIds.length-1){
					strorgIds = strorgIds + orgIds[i];
				}
				else{
					strorgIds = strorgIds + orgIds[i] + ",";
				}
			}
		}
		String[] liststrorgIds = StringUtil.split(strorgIds);
		String[] communityPermissions = actionRequest.getParameterValues("communityPermissions");
		String[] guestPermissions = actionRequest.getParameterValues("guestPermissions");
		
		if (eventId <= 0) {

			// Add event
			
			CalEvent calEvent = null;
			calEvent = MeetingCalendarServiceUtil.addEvent(
				layout.getPlid(), title, description, startDateMonth,
				startDateDay, startDateYear, startDateHour, startDateMinute,
				endDateMonth, endDateDay, endDateYear, durationHour,
				durationMinute, allDay, timeZoneSensitive, type, repeating,
				recurrence, remindBy, firstReminder, secondReminder,
				communityPermissions, guestPermissions, morning, afternoon, evening, prior);
			
			MeetingCalendarLocalServiceUtil.addMCal(place,place_diff, component, note, calEvent, repeatWeek, file, fileName, morning, afternoon, evening, prior);
			MeetingCalComponentLocalServiceUtil.addMCalComponent(calEvent.getEventId(), liststrorgIds, startDate.getTime());
			
		}
		else {

			// Update event
			CalEvent oldEvent = MeetingCalendarServiceUtil.getEvent(eventId);
			MeetingCalendar oldMCal = MeetingCalendarLocalServiceUtil.getMeetingCalendar(eventId);
			User user = PortalUtil.getUser(actionRequest);
			
			if(startDate.getTime().equals(oldEvent.getStartDate()) ){
				// Update event cua user khac
				MeetingCalendarServiceUtil.updateEvent(
						layout.getPlid(), eventId, title, description, startDateMonth, startDateDay,
						startDateYear, startDateHour, startDateMinute, endDateMonth,
						endDateDay, endDateYear, durationHour, durationMinute,
						allDay, timeZoneSensitive, type, repeating, recurrence,
						remindBy, firstReminder, secondReminder, 
						morning, afternoon, evening, prior);
				
				/*CalEventLocalServiceUtil.updateEvent(
						layout.getPlid(), eventId, title, description, startDateMonth, startDateDay,
						startDateYear, startDateHour, startDateMinute, endDateMonth,
						endDateDay, endDateYear, durationHour, durationMinute,
						allDay, timeZoneSensitive, type, repeating, recurrence,
						remindBy, firstReminder, secondReminder);*/
				
				MeetingCalendarLocalServiceUtil.updateMCal(eventId, place, place_diff, component, note, repeatWeek, file, morning, afternoon, evening, prior);
				MeetingCalComponentLocalServiceUtil.updateMCalComponent(eventId, liststrorgIds, startDate.getTime());
				
			}
			else{
				if(oldMCal.getState() == MeetingCalendarKey.DA_DUYET){
					// Doi hop
					CalEvent calEvent = null;
					calEvent = MeetingCalendarServiceUtil.addEvent(
						layout.getPlid(), title, description, startDateMonth,
						startDateDay, startDateYear, startDateHour, startDateMinute,
						endDateMonth, endDateDay, endDateYear, durationHour,
						durationMinute, allDay, timeZoneSensitive, type, repeating,
						recurrence, remindBy, firstReminder, secondReminder,
						communityPermissions, guestPermissions, 
						morning, afternoon, evening, prior);
					MeetingCalendarLocalServiceUtil.addMCal(place,place_diff, component, note, calEvent, MeetingCalendarKey.DA_DUYET, repeatWeek, file, fileName, morning, afternoon, evening, prior);
					MeetingCalendarLocalServiceUtil.moveMCal(oldEvent.getEventId(),calEvent.getEventId());
					MeetingCalComponentLocalServiceUtil.addMCalComponent(calEvent.getEventId(), liststrorgIds, startDate.getTime());
					
				}
				else{
					if(oldMCal.getUserId() == user.getUserId()){
						// Update event cua user
						MeetingCalendarServiceUtil.updateEvent(
								layout.getPlid(), eventId, title, description, startDateMonth, startDateDay,
								startDateYear, startDateHour, startDateMinute, endDateMonth,
								endDateDay, endDateYear, durationHour, durationMinute,
								allDay, timeZoneSensitive, type, repeating, recurrence,
								remindBy, firstReminder, secondReminder, 
								morning, afternoon, evening, prior);
						MeetingCalendarLocalServiceUtil.updateMCal(eventId, place, place_diff, component, note, repeatWeek, file, morning, afternoon, evening, prior);
						MeetingCalComponentLocalServiceUtil.updateMCalComponent(eventId, liststrorgIds, startDate.getTime());
						
					}
					else{
						// Update event and approved
						MeetingCalendarServiceUtil.updateEvent(
								layout.getPlid(), eventId, title, description, startDateMonth, startDateDay,
								startDateYear, startDateHour, startDateMinute, endDateMonth,
								endDateDay, endDateYear, durationHour, durationMinute,
								allDay, timeZoneSensitive, type, repeating, recurrence,
								remindBy, firstReminder, secondReminder, 
								morning, afternoon, evening, prior);
						MeetingCalendarLocalServiceUtil.updateMCal(eventId, place, place_diff, component, note, MeetingCalendarKey.DA_DUYET, repeatWeek, file, morning, afternoon, evening, prior);
						MeetingCalComponentLocalServiceUtil.updateMCalComponent(eventId, liststrorgIds, startDate.getTime());
						
					}
				}
			}
		}
		PortletURL portletURL =
			((ActionResponseImpl)actionResponse).createRenderURL();

		portletURL.setParameter(
			"struts_action", "/ext/meeting_calendar/week_view");
		portletURL.setParameter(
			"tabs1", "approved-calendar");

		actionResponse.sendRedirect(portletURL.toString());
	}
	
	protected void approveMCal(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		long mcalId = ParamUtil.getLong(actionRequest, "mcalId");
		User user = PortalUtil.getUser(actionRequest);
		MeetingCalendarLocalServiceUtil.approveMCal(user.getUserId(), mcalId);
		
		PortletURL portletURL =
			((ActionResponseImpl)actionResponse).createRenderURL();
		portletURL.setParameter("struts_action", "/ext/meeting_calendar/view");
		actionResponse.sendRedirect(portletURL.toString());
		
	}
	/*Duy Duong close start 21/12/2008
	protected void validate(String place, String place_diff) throws PortalException{
		if((Validator.isNotNull(place) && Validator.isNotNull(place_diff))||
		   (Validator.isNull(place) && Validator.isNull(place_diff)) ){
			throw new DuplicateRoomException();
		}
	}
	*/
	protected void validate(String place, String place_diff) throws PortalException{
		if(Validator.isNotNull(place) && Validator.isNotNull(place_diff)){
			throw new DuplicateRoomException();
		}
	}
}