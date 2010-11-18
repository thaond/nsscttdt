package com.ext.portlet.meetingcalendar.service.persistence;

public class MeetingCalendarFinderUtil {
    private static MeetingCalendarFinder _finder;

    public static int countBySD_D_S_C(java.util.Date startDateGT,
        java.util.Date startDateLT, java.lang.String description,
        java.lang.String sponsor, java.lang.String component,
        boolean andOperator) throws com.liferay.portal.SystemException {
        return getFinder()
                   .countBySD_D_S_C(startDateGT, startDateLT, description,
            sponsor, component, andOperator);
    }

    public static int countBySD_D_S_C_S(java.util.Date startDateGT,
        java.util.Date startDateLT, java.lang.String description,
        java.lang.String sponsor, java.lang.String component, int state,
        boolean andOperator) throws com.liferay.portal.SystemException {
        return getFinder()
                   .countBySD_D_S_C_S(startDateGT, startDateLT, description,
            sponsor, component, state, andOperator);
    }

    public static java.util.List<com.liferay.portlet.calendar.model.CalEvent> findBySD_D_S_C(
        java.util.Date startDateGT, java.util.Date startDateLT,
        java.lang.String description, java.lang.String sponsor,
        java.lang.String component, boolean andOperator, int begin, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .findBySD_D_S_C(startDateGT, startDateLT, description,
            sponsor, component, andOperator, begin, end, obc);
    }

    public static java.util.List<com.liferay.portlet.calendar.model.CalEvent> findBySD_D_S_C_S(
        java.util.Date startDateGT, java.util.Date startDateLT,
        java.lang.String description, java.lang.String sponsor,
        java.lang.String component, int state, boolean andOperator, int begin,
        int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .findBySD_D_S_C_S(startDateGT, startDateLT, description,
            sponsor, component, state, andOperator, begin, end, obc);
    }

    public static java.util.List<com.ext.portlet.meetingcalendar.model.MeetingCalendar> findByG_SD(
        long groupId, java.util.Date startDateGT, java.util.Date startDateLT,
        java.lang.String eventType) throws com.liferay.portal.SystemException {
        return getFinder()
                   .findByG_SD(groupId, startDateGT, startDateLT, eventType);
    }

    public static MeetingCalendarFinder getFinder() {
        return _finder;
    }

    public void setFinder(MeetingCalendarFinder finder) {
        _finder = finder;
    }
}
