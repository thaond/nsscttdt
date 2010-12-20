package com.ext.portlet.meetingcalendar.model.impl;

import com.ext.portlet.meetingcalendar.model.MeetingCalendar;
import com.liferay.portal.util.PropsUtil;
import com.ext.portlet.meetingcalendar.action.MeetingCalendarKey;

public class MeetingCalendarImpl extends MeetingCalendarModelImpl
    implements MeetingCalendar {
	public static final String[] TYPES =
		PropsUtil.getArray(MeetingCalendarKey.EXT_MEETINGCALENDAR_TYPES);
	public static final String[] ROOMS =
		PropsUtil.getArray(MeetingCalendarKey.EXT_MEETINGCALENDAR_ROOMS);
    public MeetingCalendarImpl() {
    }
}
