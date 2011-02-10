package com.ext.portlet.meetingcalendar.service.impl;

import com.ext.portlet.meetingcalendar.model.PmlScreenCalendarHeight;
import com.ext.portlet.meetingcalendar.service.PmlScreenCalendarHeightLocalServiceUtil;
import com.ext.portlet.meetingcalendar.service.base.PmlScreenCalendarHeightServiceBaseImpl;


public class PmlScreenCalendarHeightServiceImpl
    extends PmlScreenCalendarHeightServiceBaseImpl {
	public PmlScreenCalendarHeight getScreenCalendarHeigth() {
		try {
			PmlScreenCalendarHeight pmlScreenCalendarHeight = PmlScreenCalendarHeightLocalServiceUtil.getPmlScreenCalendarHeights(-1,-1).get(0);
			return pmlScreenCalendarHeight;
		} catch (Exception e) {
			return null;
		}
	}
}
