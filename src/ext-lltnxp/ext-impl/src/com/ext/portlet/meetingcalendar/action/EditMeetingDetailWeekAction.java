package com.ext.portlet.meetingcalendar.action;
import com.ext.portlet.meetingcalendar.NoSuchMeetingDetailWeekException;
import com.ext.portlet.meetingcalendar.FocusException;
import com.ext.portlet.meetingcalendar.model.MeetingDetailWeek;
import com.ext.portlet.meetingcalendar.service.MeetingDetailWeekLocalServiceUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.CalendarFactoryUtil;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.TimeZoneUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.struts.PortletAction;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.ext.portlet.meetingcalendar.action.ActionUtil;

import java.util.TimeZone;
import java.util.Calendar;
import java.util.Locale;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import com.ext.portlet.meetingcalendar.DuplicateFocusException;
/**
 * <a href="EditMeetingDetailWeekAction.java.html"><b><i>View Source</i></b></a>
 *
 * @author HAI TRIEU
 *
 */
public class EditMeetingDetailWeekAction extends PortletAction {

	public void processAction(
			ActionMapping mapping, ActionForm form, PortletConfig portletConfig,
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		String cmd = ParamUtil.getString(actionRequest, Constants.CMD);

		try {
			if (cmd.equals(Constants.ADD) || cmd.equals(Constants.UPDATE)) {
				updateMeetingDetailWeek(actionRequest);
			}
			/*
			if (cmd.equals(Constants.EDIT)) {
				ActionUtil.getMeetingDetailWeek(actionRequest);
			}
			*/
			else if (cmd.equals(Constants.DELETE)) {
				deleteMeetingDetailWeek(actionRequest);
			}		
			if (Validator.isNotNull(cmd)) {
				String redirect = ParamUtil.getString(
					actionRequest, "redirect");

				sendRedirect(actionRequest, actionResponse, redirect);
			}
		}
		catch (Exception e) {
			if (e instanceof NoSuchMeetingDetailWeekException ||
				e instanceof PrincipalException) {

				SessionErrors.add(actionRequest, e.getClass().getName());

				setForward(actionRequest, "portlet.ext.meeting_calendar.error");
			}
			// Truong hop hieu chinh hoac them moi
			else if	(e instanceof FocusException ||
					e instanceof DuplicateFocusException){
				actionRequest.setAttribute("MeetingDetailWeekAUFlag", "fail");
				SessionErrors.add(actionRequest, e.getClass().getName());
			}
			else {
				throw e;
			}
		}
	}
	
	public ActionForward render(
			ActionMapping mapping, ActionForm form, PortletConfig portletConfig,
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws Exception {
		String cmd = ParamUtil.getString(renderRequest, Constants.CMD);

		try {
			
			if (cmd.equals(Constants.EDIT)) {
				ActionUtil.getMeetingDetailWeek(renderRequest);
			}
			
		}
		catch (Exception e) {
			if (e instanceof NoSuchMeetingDetailWeekException ||
				e instanceof PrincipalException) {

				SessionErrors.add(renderRequest, e.getClass().getName());

				return mapping.findForward("portlet.ext.meeting_calendar.error");
			}
			else {
				throw e;
			}
		}

		return mapping.findForward(
			getForward(renderRequest, "portlet.ext.meeting_calendar.edit_focus_week"));
	}

	protected MeetingDetailWeek updateMeetingDetailWeek(ActionRequest actionRequest)
		throws Exception {	
		
		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(
												actionRequest);
		Locale locale = null;
		TimeZone timeZone = null;
		/*
		if (timeZoneSensitive) {
			User user = PortalUtil.getUser(actionRequest);

			locale = user.getLocale();
			timeZone = user.getTimeZone();
		}
		else {
		*/
			locale = LocaleUtil.getDefault();
			timeZone = TimeZoneUtil.getDefault();
		//}
		Calendar selCal = CalendarFactoryUtil.getCalendar(timeZone, locale);
		
		Calendar cal = (Calendar)selCal.clone();
		//int weekOfYear = cal.get(Calendar.WEEK_OF_YEAR);
		//int year = cal.get(Calendar.YEAR);
		int weekOfYear = ParamUtil.getInteger(uploadRequest, "week", 0);
		int year = ParamUtil.getInteger(uploadRequest, "year", 0);
		
		long userId = ParamUtil.getLong(uploadRequest, "userId", 0);
		String focus = ParamUtil.getString(uploadRequest, "focus");
		String note = ParamUtil.getString(uploadRequest, "note");
		if (!note.equals("") & note != null){
			note = note.replaceAll("\n", "<br/>");
		}
		String receive = ParamUtil.getString(uploadRequest, "receive");
		
		if (!receive.equals("") & receive != null){
			receive = receive.replaceAll("\n", "<br/>");
		}
		
		String cmd = ParamUtil.getString(uploadRequest, Constants.CMD);
		MeetingDetailWeek meetingDetailWeek = null;
		long mdweekId = ParamUtil.getLong(uploadRequest,"mdweekId", 0);
		
		if (cmd.equals(Constants.ADD)) {
			//Add
			meetingDetailWeek = MeetingDetailWeekLocalServiceUtil.addMeetingDetailWeek(userId, focus, note, receive, weekOfYear, year);
		}
		else
			{
			//Update
			meetingDetailWeek = MeetingDetailWeekLocalServiceUtil.updateMeetingDetailWeek(mdweekId, userId, focus, note, receive, weekOfYear, year);
		}
		return meetingDetailWeek;
		
	}
	
	protected void deleteMeetingDetailWeek(ActionRequest actionRequest)
		throws Exception {
		long mdweekId = ParamUtil.getLong(actionRequest,"actionRequest", 0);
		if(mdweekId >0)
		{
			MeetingDetailWeekLocalServiceUtil.deleteMeetingDetailWeek(mdweekId);
		}
	}
}