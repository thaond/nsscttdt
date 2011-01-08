package com.ext.portlet.meetingcalendar.service.impl;

import com.ext.portlet.meetingcalendar.action.MeetingCalendarKey;
import com.ext.portlet.meetingcalendar.service.base.MeetingCalendarServiceBaseImpl;
import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.service.permission.PortletPermissionUtil;
import com.liferay.portlet.calendar.model.CalEvent;
import com.liferay.portlet.calendar.service.permission.CalEventPermission;
import com.liferay.portal.kernel.cal.TZSRecurrence;

public class MeetingCalendarServiceImpl extends MeetingCalendarServiceBaseImpl {
	
	public CalEvent addEvent(
			long plid, String title, String description, int startDateMonth,
			int startDateDay, int startDateYear, int startDateHour,
			int startDateMinute, int endDateMonth, int endDateDay,
			int endDateYear, int durationHour, int durationMinute,
			boolean allDay, boolean timeZoneSensitive, String type,
			boolean repeating, TZSRecurrence recurrence, String remindBy,
			int firstReminder, int secondReminder, 
			String[] communityPermissions, String[] guestPermissions, 
			boolean morning, boolean afternoon, boolean evening, boolean prior)
		throws PortalException, SystemException {
		
		PortletPermissionUtil.check(
			getPermissionChecker(), plid, MeetingCalendarKey.PORTLET_MEETING_CALENDAR,
			ActionKeys.ADD_EVENT);
		
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
		
		/*
		return calEventLocalService.addEvent(
			getUserId(), title, description, startDateMonth, startDateDay,
			startDateYear, startDateHour, startDateMinute, endDateMonth,
			endDateDay, endDateYear, durationHour, durationMinute, allDay,
			timeZoneSensitive, type, repeating, recurrence, remindBy,
			firstReminder, secondReminder, serviceContext);
		*/
		return calEventLocalService.addEvent(
				getUserId(), plid, title, description, startDateMonth, startDateDay,
				startDateYear, startDateHour, startDateMinute, endDateMonth,
				endDateDay, endDateYear, durationHour, durationMinute, allDay,
				timeZoneSensitive, type, repeating, recurrence, remindBy,
				firstReminder, secondReminder, communityPermissions,
				guestPermissions);
	}
	
	public CalEvent addEvent(
			long plid, long userId, String title, String description, int startDateMonth,
			int startDateDay, int startDateYear, int startDateHour,
			int startDateMinute, int endDateMonth, int endDateDay,
			int endDateYear, int durationHour, int durationMinute,
			boolean allDay, boolean timeZoneSensitive, String type,
			boolean repeating, TZSRecurrence recurrence, String remindBy,
			int firstReminder, int secondReminder,
			String[] communityPermissions, String[] guestPermissions, 
			boolean morning, boolean afternoon, boolean evening, boolean prior)
		throws PortalException, SystemException {
		
		/*
		PortletPermissionUtil.check(
			getPermissionChecker(), plid, MeetingCalendarKey.PORTLET_MEETING_CALENDAR,
			ActionKeys.ADD_EVENT);
		*/
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
		/*
		return calEventLocalService.addEvent(
			userId, title, description, startDateMonth, startDateDay,
			startDateYear, startDateHour, startDateMinute, endDateMonth,
			endDateDay, endDateYear, durationHour, durationMinute, allDay,
			timeZoneSensitive, type, repeating, recurrence, remindBy,
			firstReminder, secondReminder, serviceContext);
		*/
		return calEventLocalService.addEvent(
				getUserId(), plid, title, description, startDateMonth, startDateDay,
				startDateYear, startDateHour, startDateMinute, endDateMonth,
				endDateDay, endDateYear, durationHour, durationMinute, allDay,
				timeZoneSensitive, type, repeating, recurrence, remindBy,
				firstReminder, secondReminder, communityPermissions,
				guestPermissions);
	}
	
	public void deleteEvent(long plid,long eventId)
		throws PortalException, SystemException {
	
		if(PortletPermissionUtil.contains(getPermissionChecker(), plid, MeetingCalendarKey.PORTLET_MEETING_CALENDAR, ActionKeys.DELETE)){
			calEventLocalService.deleteEvent(eventId);
		}
		else{
			CalEventPermission.check(
				getPermissionChecker(), eventId, ActionKeys.DELETE);
		
			calEventLocalService.deleteEvent(eventId);
		}
	}
	
	public CalEvent getEvent(long eventId)
		throws PortalException, SystemException {
		
		return calEventLocalService.getEvent(eventId);
	}
	
	public CalEvent updateEvent(
			long eventId, String title, String description,
			int startDateMonth, int startDateDay, int startDateYear,
			int startDateHour, int startDateMinute, int endDateMonth,
			int endDateDay, int endDateYear, int durationHour,
			int durationMinute, boolean allDay, boolean timeZoneSensitive,
			String type, boolean repeating, TZSRecurrence recurrence,
			String remindBy, int firstReminder, int secondReminder,
			boolean morning, boolean afternoon, boolean evening, boolean prior)
		throws PortalException, SystemException {

		CalEventPermission.check(
			getPermissionChecker(), eventId, ActionKeys.UPDATE);
		
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
		
		/*
		return calEventLocalService.updateEvent(
			getUserId(), eventId, title, description, startDateMonth,
			startDateDay, startDateYear, startDateHour, startDateMinute,
			endDateMonth, endDateDay, endDateYear, durationHour, durationMinute,
			allDay, timeZoneSensitive, type, repeating, recurrence, remindBy,
			firstReminder, secondReminder, serviceContext);
		*/
		return calEventLocalService.updateEvent(
				getUserId(), eventId, title, description, startDateMonth,
				startDateDay, startDateYear, startDateHour, startDateMinute,
				endDateMonth, endDateDay, endDateYear, durationHour, durationMinute,
				allDay, timeZoneSensitive, type, repeating, recurrence, remindBy,
				firstReminder, secondReminder);
	}
	
	public CalEvent updateEvent(
			long plid, long eventId, String title, String description,
			int startDateMonth, int startDateDay, int startDateYear,
			int startDateHour, int startDateMinute, int endDateMonth,
			int endDateDay, int endDateYear, int durationHour,
			int durationMinute, boolean allDay, boolean timeZoneSensitive,
			String type, boolean repeating, TZSRecurrence recurrence,
			String remindBy, int firstReminder, int secondReminder,
			boolean morning, boolean afternoon, boolean evening, boolean prior)
		throws PortalException, SystemException {
		
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
		if(PortletPermissionUtil.contains(getPermissionChecker(), plid, MeetingCalendarKey.PORTLET_MEETING_CALENDAR, ActionKeys.UPDATE)){
			
			return calEventLocalService.updateEvent(
				getUserId(), eventId, title, description, startDateMonth,
				startDateDay, startDateYear, startDateHour, startDateMinute,
				endDateMonth, endDateDay, endDateYear, durationHour, durationMinute,
				allDay, timeZoneSensitive, type, repeating, recurrence, remindBy,
				firstReminder, secondReminder);
		}
		else{
			CalEventPermission.check(
				getPermissionChecker(), eventId, ActionKeys.UPDATE);
	
			return calEventLocalService.updateEvent(
				getUserId(), eventId, title, description, startDateMonth,
				startDateDay, startDateYear, startDateHour, startDateMinute,
				endDateMonth, endDateDay, endDateYear, durationHour, durationMinute,
				allDay, timeZoneSensitive, type, repeating, recurrence, remindBy,
				firstReminder, secondReminder);
		}
	}
}
