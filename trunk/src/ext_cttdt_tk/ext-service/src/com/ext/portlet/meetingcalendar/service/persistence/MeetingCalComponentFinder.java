package com.ext.portlet.meetingcalendar.service.persistence;

public interface MeetingCalComponentFinder {
    public java.util.List<com.ext.portlet.meetingcalendar.model.MeetingCalComponent> findByG_SD(
        long groupId, java.util.Date startDateGT, java.util.Date startDateLT)
        throws com.liferay.portal.SystemException;
}
