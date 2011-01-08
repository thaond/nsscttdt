package com.ext.portlet.meetingcalendar.service.persistence;

public class MeetingCalComponentFinderUtil {
    private static MeetingCalComponentFinder _finder;

    public static java.util.List<com.ext.portlet.meetingcalendar.model.MeetingCalComponent> findByG_SD(
        long groupId, java.util.Date startDateGT, java.util.Date startDateLT)
        throws com.liferay.portal.SystemException {
        return getFinder().findByG_SD(groupId, startDateGT, startDateLT);
    }

    public static MeetingCalComponentFinder getFinder() {
        return _finder;
    }

    public void setFinder(MeetingCalComponentFinder finder) {
        _finder = finder;
    }
}
