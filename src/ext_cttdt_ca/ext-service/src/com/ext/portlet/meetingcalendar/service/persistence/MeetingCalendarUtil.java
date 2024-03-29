package com.ext.portlet.meetingcalendar.service.persistence;

public class MeetingCalendarUtil {
    private static MeetingCalendarPersistence _persistence;

    public static void cacheResult(
        com.ext.portlet.meetingcalendar.model.MeetingCalendar meetingCalendar) {
        getPersistence().cacheResult(meetingCalendar);
    }

    public static void cacheResult(
        java.util.List<com.ext.portlet.meetingcalendar.model.MeetingCalendar> meetingCalendars) {
        getPersistence().cacheResult(meetingCalendars);
    }

    public static void clearCache() {
        getPersistence().clearCache();
    }

    public static com.ext.portlet.meetingcalendar.model.MeetingCalendar create(
        long mcalId) {
        return getPersistence().create(mcalId);
    }

    public static com.ext.portlet.meetingcalendar.model.MeetingCalendar remove(
        long mcalId)
        throws com.ext.portlet.meetingcalendar.NoSuchendarException,
            com.liferay.portal.SystemException {
        return getPersistence().remove(mcalId);
    }

    public static com.ext.portlet.meetingcalendar.model.MeetingCalendar remove(
        com.ext.portlet.meetingcalendar.model.MeetingCalendar meetingCalendar)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(meetingCalendar);
    }

    /**
     * @deprecated Use <code>update(MeetingCalendar meetingCalendar, boolean merge)</code>.
     */
    public static com.ext.portlet.meetingcalendar.model.MeetingCalendar update(
        com.ext.portlet.meetingcalendar.model.MeetingCalendar meetingCalendar)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(meetingCalendar);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                meetingCalendar the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when meetingCalendar is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public static com.ext.portlet.meetingcalendar.model.MeetingCalendar update(
        com.ext.portlet.meetingcalendar.model.MeetingCalendar meetingCalendar,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().update(meetingCalendar, merge);
    }

    public static com.ext.portlet.meetingcalendar.model.MeetingCalendar updateImpl(
        com.ext.portlet.meetingcalendar.model.MeetingCalendar meetingCalendar,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(meetingCalendar, merge);
    }

    public static com.ext.portlet.meetingcalendar.model.MeetingCalendar findByPrimaryKey(
        long mcalId)
        throws com.ext.portlet.meetingcalendar.NoSuchendarException,
            com.liferay.portal.SystemException {
        return getPersistence().findByPrimaryKey(mcalId);
    }

    public static com.ext.portlet.meetingcalendar.model.MeetingCalendar fetchByPrimaryKey(
        long mcalId) throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(mcalId);
    }

    public static java.util.List<com.ext.portlet.meetingcalendar.model.MeetingCalendar> findByUuid(
        java.lang.String uuid) throws com.liferay.portal.SystemException {
        return getPersistence().findByUuid(uuid);
    }

    public static java.util.List<com.ext.portlet.meetingcalendar.model.MeetingCalendar> findByUuid(
        java.lang.String uuid, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByUuid(uuid, start, end);
    }

    public static java.util.List<com.ext.portlet.meetingcalendar.model.MeetingCalendar> findByUuid(
        java.lang.String uuid, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByUuid(uuid, start, end, obc);
    }

    public static com.ext.portlet.meetingcalendar.model.MeetingCalendar findByUuid_First(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.ext.portlet.meetingcalendar.NoSuchendarException,
            com.liferay.portal.SystemException {
        return getPersistence().findByUuid_First(uuid, obc);
    }

    public static com.ext.portlet.meetingcalendar.model.MeetingCalendar findByUuid_Last(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.ext.portlet.meetingcalendar.NoSuchendarException,
            com.liferay.portal.SystemException {
        return getPersistence().findByUuid_Last(uuid, obc);
    }

    public static com.ext.portlet.meetingcalendar.model.MeetingCalendar[] findByUuid_PrevAndNext(
        long mcalId, java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.ext.portlet.meetingcalendar.NoSuchendarException,
            com.liferay.portal.SystemException {
        return getPersistence().findByUuid_PrevAndNext(mcalId, uuid, obc);
    }

    public static com.ext.portlet.meetingcalendar.model.MeetingCalendar findByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.ext.portlet.meetingcalendar.NoSuchendarException,
            com.liferay.portal.SystemException {
        return getPersistence().findByUUID_G(uuid, groupId);
    }

    public static com.ext.portlet.meetingcalendar.model.MeetingCalendar fetchByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.SystemException {
        return getPersistence().fetchByUUID_G(uuid, groupId);
    }

    public static com.ext.portlet.meetingcalendar.model.MeetingCalendar fetchByUUID_G(
        java.lang.String uuid, long groupId, boolean retrieveFromCache)
        throws com.liferay.portal.SystemException {
        return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
    }

    public static java.util.List<com.ext.portlet.meetingcalendar.model.MeetingCalendar> findByGroupId(
        long groupId) throws com.liferay.portal.SystemException {
        return getPersistence().findByGroupId(groupId);
    }

    public static java.util.List<com.ext.portlet.meetingcalendar.model.MeetingCalendar> findByGroupId(
        long groupId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByGroupId(groupId, start, end);
    }

    public static java.util.List<com.ext.portlet.meetingcalendar.model.MeetingCalendar> findByGroupId(
        long groupId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByGroupId(groupId, start, end, obc);
    }

    public static com.ext.portlet.meetingcalendar.model.MeetingCalendar findByGroupId_First(
        long groupId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.ext.portlet.meetingcalendar.NoSuchendarException,
            com.liferay.portal.SystemException {
        return getPersistence().findByGroupId_First(groupId, obc);
    }

    public static com.ext.portlet.meetingcalendar.model.MeetingCalendar findByGroupId_Last(
        long groupId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.ext.portlet.meetingcalendar.NoSuchendarException,
            com.liferay.portal.SystemException {
        return getPersistence().findByGroupId_Last(groupId, obc);
    }

    public static com.ext.portlet.meetingcalendar.model.MeetingCalendar[] findByGroupId_PrevAndNext(
        long mcalId, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.ext.portlet.meetingcalendar.NoSuchendarException,
            com.liferay.portal.SystemException {
        return getPersistence().findByGroupId_PrevAndNext(mcalId, groupId, obc);
    }

    public static java.util.List<com.ext.portlet.meetingcalendar.model.MeetingCalendar> findByG_State(
        long groupId, int state) throws com.liferay.portal.SystemException {
        return getPersistence().findByG_State(groupId, state);
    }

    public static java.util.List<com.ext.portlet.meetingcalendar.model.MeetingCalendar> findByG_State(
        long groupId, int state, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByG_State(groupId, state, start, end);
    }

    public static java.util.List<com.ext.portlet.meetingcalendar.model.MeetingCalendar> findByG_State(
        long groupId, int state, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByG_State(groupId, state, start, end, obc);
    }

    public static com.ext.portlet.meetingcalendar.model.MeetingCalendar findByG_State_First(
        long groupId, int state,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.ext.portlet.meetingcalendar.NoSuchendarException,
            com.liferay.portal.SystemException {
        return getPersistence().findByG_State_First(groupId, state, obc);
    }

    public static com.ext.portlet.meetingcalendar.model.MeetingCalendar findByG_State_Last(
        long groupId, int state,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.ext.portlet.meetingcalendar.NoSuchendarException,
            com.liferay.portal.SystemException {
        return getPersistence().findByG_State_Last(groupId, state, obc);
    }

    public static com.ext.portlet.meetingcalendar.model.MeetingCalendar[] findByG_State_PrevAndNext(
        long mcalId, long groupId, int state,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.ext.portlet.meetingcalendar.NoSuchendarException,
            com.liferay.portal.SystemException {
        return getPersistence()
                   .findByG_State_PrevAndNext(mcalId, groupId, state, obc);
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

    public static java.util.List<com.ext.portlet.meetingcalendar.model.MeetingCalendar> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.ext.portlet.meetingcalendar.model.MeetingCalendar> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.ext.portlet.meetingcalendar.model.MeetingCalendar> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end, obc);
    }

    public static void removeByUuid(java.lang.String uuid)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByUuid(uuid);
    }

    public static void removeByUUID_G(java.lang.String uuid, long groupId)
        throws com.ext.portlet.meetingcalendar.NoSuchendarException,
            com.liferay.portal.SystemException {
        getPersistence().removeByUUID_G(uuid, groupId);
    }

    public static void removeByGroupId(long groupId)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByGroupId(groupId);
    }

    public static void removeByG_State(long groupId, int state)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByG_State(groupId, state);
    }

    public static void removeAll() throws com.liferay.portal.SystemException {
        getPersistence().removeAll();
    }

    public static int countByUuid(java.lang.String uuid)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByUuid(uuid);
    }

    public static int countByUUID_G(java.lang.String uuid, long groupId)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByUUID_G(uuid, groupId);
    }

    public static int countByGroupId(long groupId)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByGroupId(groupId);
    }

    public static int countByG_State(long groupId, int state)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByG_State(groupId, state);
    }

    public static int countAll() throws com.liferay.portal.SystemException {
        return getPersistence().countAll();
    }

    public static MeetingCalendarPersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(MeetingCalendarPersistence persistence) {
        _persistence = persistence;
    }
}
