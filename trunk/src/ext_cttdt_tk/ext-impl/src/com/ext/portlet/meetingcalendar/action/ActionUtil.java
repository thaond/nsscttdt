package com.ext.portlet.meetingcalendar.action;

import com.ext.portal.util.WebKeysExt;
import com.ext.portlet.meetingcalendar.model.MeetingCalendar;
import com.ext.portlet.meetingcalendar.model.MeetingCalComponent;
import com.ext.portlet.meetingcalendar.model.MeetingDetailWeek;
import com.ext.portlet.meetingcalendar.service.MeetingCalendarServiceUtil;
import com.ext.portlet.meetingcalendar.service.MeetingCalendarLocalServiceUtil;
import com.ext.portlet.meetingcalendar.service.MeetingCalComponentLocalServiceUtil;
import com.ext.portlet.meetingcalendar.service.MeetingDetailWeekLocalServiceUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portal.util.WebKeys;
import com.liferay.portlet.calendar.model.CalEvent;

import javax.portlet.ActionRequest;
import javax.portlet.RenderRequest;

import javax.servlet.http.HttpServletRequest;

/**
 * <a href="ActionUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Dao Duy Duong
 * @author Hai Trieu
 *
 */
public class ActionUtil {

	public static void getEvent(ActionRequest actionRequest) throws Exception {
		HttpServletRequest request = PortalUtil.getHttpServletRequest(
			actionRequest);

		getEvent(request);
	}

	public static void getEvent(RenderRequest renderRequest) throws Exception {
		HttpServletRequest request = PortalUtil.getHttpServletRequest(
			renderRequest);

		getEvent(request);
	}

	public static void getEvent(HttpServletRequest request) throws Exception {
		long eventId = ParamUtil.getLong(request, "eventId");
		CalEvent event = null;
		MeetingCalendar mcalendar = null;
		MeetingCalComponent mcalComp = null;
		if (eventId > 0) {
			event = MeetingCalendarServiceUtil.getEvent(eventId);
			mcalendar = MeetingCalendarLocalServiceUtil.getMeetingCalendar(eventId);
			mcalComp = MeetingCalComponentLocalServiceUtil.getBymcalId(eventId);
		}
		request.setAttribute(MeetingCalendarKey.MEETING_CALENDAR, mcalendar);
		request.setAttribute(MeetingCalendarKey.MEETING_CALENDAR_COMPONENT, mcalComp);
		request.setAttribute(WebKeys.CALENDAR_EVENT, event);
	}
	// Trieu add
	
	public static void getMeetingDetailWeek(ActionRequest actionRequest)
	throws Exception {

		HttpServletRequest request = PortalUtil.getHttpServletRequest(
			actionRequest);
	
		getMeetingDetailWeek(request);
	}
	
	public static void getMeetingDetailWeek(RenderRequest renderRequest)
		throws Exception {
	
		HttpServletRequest request = PortalUtil.getHttpServletRequest(
			renderRequest);
	
		getMeetingDetailWeek(request);
	}
	
	public static void getMeetingDetailWeek(HttpServletRequest request) 
	throws Exception {
		long mdweekId = ParamUtil.getLong(request, "mdweekId");
		
		MeetingDetailWeek meetingDetailWeek = null;
	
		if (Validator.isNotNull(mdweekId)) {
			meetingDetailWeek = MeetingDetailWeekLocalServiceUtil.getMeetingDetailWeek(mdweekId);
		}
	
		request.setAttribute(WebKeysExt.MEETINGDETAILWEEK, meetingDetailWeek);
		request.setAttribute("mdweekId", mdweekId);
	}
	public static java.util.Date getCurrentDate(){
		return new java.util.Date();
	}
	
}