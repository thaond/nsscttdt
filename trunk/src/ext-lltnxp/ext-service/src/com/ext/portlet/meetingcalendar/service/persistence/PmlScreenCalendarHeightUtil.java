package com.ext.portlet.meetingcalendar.service.persistence;

public class PmlScreenCalendarHeightUtil {
    private static PmlScreenCalendarHeightPersistence _persistence;

    public static com.ext.portlet.meetingcalendar.model.PmlScreenCalendarHeight create(
        long screenCalendarHeightId) {
        return getPersistence().create(screenCalendarHeightId);
    }

    public static com.ext.portlet.meetingcalendar.model.PmlScreenCalendarHeight remove(
        long screenCalendarHeightId)
        throws com.ext.portlet.meetingcalendar.NoSuchPmlScreenCalendarHeightException,
            com.liferay.portal.SystemException {
        return getPersistence().remove(screenCalendarHeightId);
    }

    public static com.ext.portlet.meetingcalendar.model.PmlScreenCalendarHeight remove(
        com.ext.portlet.meetingcalendar.model.PmlScreenCalendarHeight pmlScreenCalendarHeight)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(pmlScreenCalendarHeight);
    }

    /**
     * @deprecated Use <code>update(PmlScreenCalendarHeight pmlScreenCalendarHeight, boolean merge)</code>.
     */
    public static com.ext.portlet.meetingcalendar.model.PmlScreenCalendarHeight update(
        com.ext.portlet.meetingcalendar.model.PmlScreenCalendarHeight pmlScreenCalendarHeight)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(pmlScreenCalendarHeight);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlScreenCalendarHeight the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlScreenCalendarHeight is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public static com.ext.portlet.meetingcalendar.model.PmlScreenCalendarHeight update(
        com.ext.portlet.meetingcalendar.model.PmlScreenCalendarHeight pmlScreenCalendarHeight,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().update(pmlScreenCalendarHeight, merge);
    }

    public static com.ext.portlet.meetingcalendar.model.PmlScreenCalendarHeight updateImpl(
        com.ext.portlet.meetingcalendar.model.PmlScreenCalendarHeight pmlScreenCalendarHeight,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(pmlScreenCalendarHeight, merge);
    }

    public static com.ext.portlet.meetingcalendar.model.PmlScreenCalendarHeight findByPrimaryKey(
        long screenCalendarHeightId)
        throws com.ext.portlet.meetingcalendar.NoSuchPmlScreenCalendarHeightException,
            com.liferay.portal.SystemException {
        return getPersistence().findByPrimaryKey(screenCalendarHeightId);
    }

    public static com.ext.portlet.meetingcalendar.model.PmlScreenCalendarHeight fetchByPrimaryKey(
        long screenCalendarHeightId) throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(screenCalendarHeightId);
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

    public static java.util.List<com.ext.portlet.meetingcalendar.model.PmlScreenCalendarHeight> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.ext.portlet.meetingcalendar.model.PmlScreenCalendarHeight> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.ext.portlet.meetingcalendar.model.PmlScreenCalendarHeight> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end, obc);
    }

    public static void removeAll() throws com.liferay.portal.SystemException {
        getPersistence().removeAll();
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

    public static PmlScreenCalendarHeightPersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(PmlScreenCalendarHeightPersistence persistence) {
        _persistence = persistence;
    }
}
