package com.ext.portlet.meetingcalendar.service.persistence;

public class MeetingDetailWeekUtil {
    private static MeetingDetailWeekPersistence _persistence;

    public static void cacheResult(
        com.ext.portlet.meetingcalendar.model.MeetingDetailWeek meetingDetailWeek) {
        getPersistence().cacheResult(meetingDetailWeek);
    }

    public static void cacheResult(
        java.util.List<com.ext.portlet.meetingcalendar.model.MeetingDetailWeek> meetingDetailWeeks) {
        getPersistence().cacheResult(meetingDetailWeeks);
    }

    public static void clearCache() {
        getPersistence().clearCache();
    }

    public static com.ext.portlet.meetingcalendar.model.MeetingDetailWeek create(
        long mdweekId) {
        return getPersistence().create(mdweekId);
    }

    public static com.ext.portlet.meetingcalendar.model.MeetingDetailWeek remove(
        long mdweekId)
        throws com.ext.portlet.meetingcalendar.NoSuchMeetingDetailWeekException,
            com.liferay.portal.SystemException {
        return getPersistence().remove(mdweekId);
    }

    public static com.ext.portlet.meetingcalendar.model.MeetingDetailWeek remove(
        com.ext.portlet.meetingcalendar.model.MeetingDetailWeek meetingDetailWeek)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(meetingDetailWeek);
    }

    /**
     * @deprecated Use <code>update(MeetingDetailWeek meetingDetailWeek, boolean merge)</code>.
     */
    public static com.ext.portlet.meetingcalendar.model.MeetingDetailWeek update(
        com.ext.portlet.meetingcalendar.model.MeetingDetailWeek meetingDetailWeek)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(meetingDetailWeek);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                meetingDetailWeek the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when meetingDetailWeek is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public static com.ext.portlet.meetingcalendar.model.MeetingDetailWeek update(
        com.ext.portlet.meetingcalendar.model.MeetingDetailWeek meetingDetailWeek,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().update(meetingDetailWeek, merge);
    }

    public static com.ext.portlet.meetingcalendar.model.MeetingDetailWeek updateImpl(
        com.ext.portlet.meetingcalendar.model.MeetingDetailWeek meetingDetailWeek,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(meetingDetailWeek, merge);
    }

    public static com.ext.portlet.meetingcalendar.model.MeetingDetailWeek findByPrimaryKey(
        long mdweekId)
        throws com.ext.portlet.meetingcalendar.NoSuchMeetingDetailWeekException,
            com.liferay.portal.SystemException {
        return getPersistence().findByPrimaryKey(mdweekId);
    }

    public static com.ext.portlet.meetingcalendar.model.MeetingDetailWeek fetchByPrimaryKey(
        long mdweekId) throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(mdweekId);
    }

    public static com.ext.portlet.meetingcalendar.model.MeetingDetailWeek findBymdweekId(
        long mdweekId)
        throws com.ext.portlet.meetingcalendar.NoSuchMeetingDetailWeekException,
            com.liferay.portal.SystemException {
        return getPersistence().findBymdweekId(mdweekId);
    }

    public static com.ext.portlet.meetingcalendar.model.MeetingDetailWeek fetchBymdweekId(
        long mdweekId) throws com.liferay.portal.SystemException {
        return getPersistence().fetchBymdweekId(mdweekId);
    }

    public static com.ext.portlet.meetingcalendar.model.MeetingDetailWeek fetchBymdweekId(
        long mdweekId, boolean retrieveFromCache)
        throws com.liferay.portal.SystemException {
        return getPersistence().fetchBymdweekId(mdweekId, retrieveFromCache);
    }

    public static com.ext.portlet.meetingcalendar.model.MeetingDetailWeek findByW_Y(
        int week, int year)
        throws com.ext.portlet.meetingcalendar.NoSuchMeetingDetailWeekException,
            com.liferay.portal.SystemException {
        return getPersistence().findByW_Y(week, year);
    }

    public static com.ext.portlet.meetingcalendar.model.MeetingDetailWeek fetchByW_Y(
        int week, int year) throws com.liferay.portal.SystemException {
        return getPersistence().fetchByW_Y(week, year);
    }

    public static com.ext.portlet.meetingcalendar.model.MeetingDetailWeek fetchByW_Y(
        int week, int year, boolean retrieveFromCache)
        throws com.liferay.portal.SystemException {
        return getPersistence().fetchByW_Y(week, year, retrieveFromCache);
    }

    public static java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    public static java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    public static java.util.List<com.ext.portlet.meetingcalendar.model.MeetingDetailWeek> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.ext.portlet.meetingcalendar.model.MeetingDetailWeek> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.ext.portlet.meetingcalendar.model.MeetingDetailWeek> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end, obc);
    }

    public static void removeBymdweekId(long mdweekId)
        throws com.ext.portlet.meetingcalendar.NoSuchMeetingDetailWeekException,
            com.liferay.portal.SystemException {
        getPersistence().removeBymdweekId(mdweekId);
    }

    public static void removeByW_Y(int week, int year)
        throws com.ext.portlet.meetingcalendar.NoSuchMeetingDetailWeekException,
            com.liferay.portal.SystemException {
        getPersistence().removeByW_Y(week, year);
    }

    public static void removeAll() throws com.liferay.portal.SystemException {
        getPersistence().removeAll();
    }

    public static int countBymdweekId(long mdweekId)
        throws com.liferay.portal.SystemException {
        return getPersistence().countBymdweekId(mdweekId);
    }

    public static int countByW_Y(int week, int year)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByW_Y(week, year);
    }

    public static int countAll() throws com.liferay.portal.SystemException {
        return getPersistence().countAll();
    }

    public static MeetingDetailWeekPersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(MeetingDetailWeekPersistence persistence) {
        _persistence = persistence;
    }
}
