package com.ext.portlet.meetingcalendar.service.persistence;

public interface MeetingCalendarFinder {
    public int countBySD_D_S_C(java.util.Date startDateGT,
        java.util.Date startDateLT, java.lang.String description,
        java.lang.String sponsor, java.lang.String component,
        boolean andOperator) throws com.liferay.portal.SystemException;

    public int countBySD_D_S_C_S(java.util.Date startDateGT,
        java.util.Date startDateLT, java.lang.String description,
        java.lang.String sponsor, java.lang.String component, int state,
        boolean andOperator) throws com.liferay.portal.SystemException;

    public java.util.List<com.liferay.portlet.calendar.model.CalEvent> findBySD_D_S_C(
        java.util.Date startDateGT, java.util.Date startDateLT,
        java.lang.String description, java.lang.String sponsor,
        java.lang.String component, boolean andOperator, int begin, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.liferay.portlet.calendar.model.CalEvent> findBySD_D_S_C_S(
        java.util.Date startDateGT, java.util.Date startDateLT,
        java.lang.String description, java.lang.String sponsor,
        java.lang.String component, int state, boolean andOperator, int begin,
        int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.ext.portlet.meetingcalendar.model.MeetingCalendar> findByG_SD(
        long groupId, java.util.Date startDateGT, java.util.Date startDateLT,
        java.lang.String eventType) throws com.liferay.portal.SystemException;
}
