package com.ext.portlet.meetingcalendar.service.persistence;

public class RoomResourceUtil {
    private static RoomResourcePersistence _persistence;

    public static com.ext.portlet.meetingcalendar.model.RoomResource create(
        long roomId) {
        return getPersistence().create(roomId);
    }

    public static com.ext.portlet.meetingcalendar.model.RoomResource remove(
        long roomId)
        throws com.ext.portlet.meetingcalendar.NoSuchRoomResourceException,
            com.liferay.portal.SystemException {
        return getPersistence().remove(roomId);
    }

    public static com.ext.portlet.meetingcalendar.model.RoomResource remove(
        com.ext.portlet.meetingcalendar.model.RoomResource roomResource)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(roomResource);
    }

    /**
     * @deprecated Use <code>update(RoomResource roomResource, boolean merge)</code>.
     */
    public static com.ext.portlet.meetingcalendar.model.RoomResource update(
        com.ext.portlet.meetingcalendar.model.RoomResource roomResource)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(roomResource);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                roomResource the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when roomResource is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public static com.ext.portlet.meetingcalendar.model.RoomResource update(
        com.ext.portlet.meetingcalendar.model.RoomResource roomResource,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().update(roomResource, merge);
    }

    public static com.ext.portlet.meetingcalendar.model.RoomResource updateImpl(
        com.ext.portlet.meetingcalendar.model.RoomResource roomResource,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(roomResource, merge);
    }

    public static com.ext.portlet.meetingcalendar.model.RoomResource findByPrimaryKey(
        long roomId)
        throws com.ext.portlet.meetingcalendar.NoSuchRoomResourceException,
            com.liferay.portal.SystemException {
        return getPersistence().findByPrimaryKey(roomId);
    }

    public static com.ext.portlet.meetingcalendar.model.RoomResource fetchByPrimaryKey(
        long roomId) throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(roomId);
    }

    public static com.ext.portlet.meetingcalendar.model.RoomResource findByN_C(
        java.lang.String roomName, long companyId)
        throws com.ext.portlet.meetingcalendar.NoSuchRoomResourceException,
            com.liferay.portal.SystemException {
        return getPersistence().findByN_C(roomName, companyId);
    }

    public static com.ext.portlet.meetingcalendar.model.RoomResource fetchByN_C(
        java.lang.String roomName, long companyId)
        throws com.liferay.portal.SystemException {
        return getPersistence().fetchByN_C(roomName, companyId);
    }

    public static java.util.List<com.ext.portlet.meetingcalendar.model.RoomResource> findByCompanyId(
        long companyId) throws com.liferay.portal.SystemException {
        return getPersistence().findByCompanyId(companyId);
    }

    public static java.util.List<com.ext.portlet.meetingcalendar.model.RoomResource> findByCompanyId(
        long companyId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByCompanyId(companyId, start, end);
    }

    public static java.util.List<com.ext.portlet.meetingcalendar.model.RoomResource> findByCompanyId(
        long companyId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByCompanyId(companyId, start, end, obc);
    }

    public static com.ext.portlet.meetingcalendar.model.RoomResource findByCompanyId_First(
        long companyId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.ext.portlet.meetingcalendar.NoSuchRoomResourceException,
            com.liferay.portal.SystemException {
        return getPersistence().findByCompanyId_First(companyId, obc);
    }

    public static com.ext.portlet.meetingcalendar.model.RoomResource findByCompanyId_Last(
        long companyId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.ext.portlet.meetingcalendar.NoSuchRoomResourceException,
            com.liferay.portal.SystemException {
        return getPersistence().findByCompanyId_Last(companyId, obc);
    }

    public static com.ext.portlet.meetingcalendar.model.RoomResource[] findByCompanyId_PrevAndNext(
        long roomId, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.ext.portlet.meetingcalendar.NoSuchRoomResourceException,
            com.liferay.portal.SystemException {
        return getPersistence()
                   .findByCompanyId_PrevAndNext(roomId, companyId, obc);
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

    public static java.util.List<com.ext.portlet.meetingcalendar.model.RoomResource> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.ext.portlet.meetingcalendar.model.RoomResource> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.ext.portlet.meetingcalendar.model.RoomResource> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end, obc);
    }

    public static void removeByN_C(java.lang.String roomName, long companyId)
        throws com.ext.portlet.meetingcalendar.NoSuchRoomResourceException,
            com.liferay.portal.SystemException {
        getPersistence().removeByN_C(roomName, companyId);
    }

    public static void removeByCompanyId(long companyId)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByCompanyId(companyId);
    }

    public static void removeAll() throws com.liferay.portal.SystemException {
        getPersistence().removeAll();
    }

    public static int countByN_C(java.lang.String roomName, long companyId)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByN_C(roomName, companyId);
    }

    public static int countByCompanyId(long companyId)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByCompanyId(companyId);
    }

    public static int countAll() throws com.liferay.portal.SystemException {
        return getPersistence().countAll();
    }

    public static void registerListener(
        com.liferay.portal.model.ModelListener listener) {
        getPersistence().registerListener(listener);
    }

    public static void unregisterListener(
        com.liferay.portal.model.ModelListener listener) {
        getPersistence().unregisterListener(listener);
    }

    public static RoomResourcePersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(RoomResourcePersistence persistence) {
        _persistence = persistence;
    }
}
