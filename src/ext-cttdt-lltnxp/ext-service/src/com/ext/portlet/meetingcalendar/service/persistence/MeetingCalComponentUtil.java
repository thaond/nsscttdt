package com.ext.portlet.meetingcalendar.service.persistence;

public class MeetingCalComponentUtil {
    private static MeetingCalComponentPersistence _persistence;

    public static com.ext.portlet.meetingcalendar.model.MeetingCalComponent create(
        long mcalId) {
        return getPersistence().create(mcalId);
    }

    public static com.ext.portlet.meetingcalendar.model.MeetingCalComponent remove(
        long mcalId)
        throws com.ext.portlet.meetingcalendar.NoSuchComponentException,
            com.liferay.portal.SystemException {
        return getPersistence().remove(mcalId);
    }

    public static com.ext.portlet.meetingcalendar.model.MeetingCalComponent remove(
        com.ext.portlet.meetingcalendar.model.MeetingCalComponent meetingCalComponent)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(meetingCalComponent);
    }

    /**
     * @deprecated Use <code>update(MeetingCalComponent meetingCalComponent, boolean merge)</code>.
     */
    public static com.ext.portlet.meetingcalendar.model.MeetingCalComponent update(
        com.ext.portlet.meetingcalendar.model.MeetingCalComponent meetingCalComponent)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(meetingCalComponent);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                meetingCalComponent the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when meetingCalComponent is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public static com.ext.portlet.meetingcalendar.model.MeetingCalComponent update(
        com.ext.portlet.meetingcalendar.model.MeetingCalComponent meetingCalComponent,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().update(meetingCalComponent, merge);
    }

    public static com.ext.portlet.meetingcalendar.model.MeetingCalComponent updateImpl(
        com.ext.portlet.meetingcalendar.model.MeetingCalComponent meetingCalComponent,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(meetingCalComponent, merge);
    }

    public static com.ext.portlet.meetingcalendar.model.MeetingCalComponent findByPrimaryKey(
        long mcalId)
        throws com.ext.portlet.meetingcalendar.NoSuchComponentException,
            com.liferay.portal.SystemException {
        return getPersistence().findByPrimaryKey(mcalId);
    }

    public static com.ext.portlet.meetingcalendar.model.MeetingCalComponent fetchByPrimaryKey(
        long mcalId) throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(mcalId);
    }

    public static com.ext.portlet.meetingcalendar.model.MeetingCalComponent findBymcalId(
        long mcalId)
        throws com.ext.portlet.meetingcalendar.NoSuchComponentException,
            com.liferay.portal.SystemException {
        return getPersistence().findBymcalId(mcalId);
    }

    public static com.ext.portlet.meetingcalendar.model.MeetingCalComponent fetchBymcalId(
        long mcalId) throws com.liferay.portal.SystemException {
        return getPersistence().fetchBymcalId(mcalId);
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

    public static java.util.List<com.ext.portlet.meetingcalendar.model.MeetingCalComponent> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.ext.portlet.meetingcalendar.model.MeetingCalComponent> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.ext.portlet.meetingcalendar.model.MeetingCalComponent> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end, obc);
    }

    public static void removeBymcalId(long mcalId)
        throws com.ext.portlet.meetingcalendar.NoSuchComponentException,
            com.liferay.portal.SystemException {
        getPersistence().removeBymcalId(mcalId);
    }

    public static void removeAll() throws com.liferay.portal.SystemException {
        getPersistence().removeAll();
    }

    public static int countBymcalId(long mcalId)
        throws com.liferay.portal.SystemException {
        return getPersistence().countBymcalId(mcalId);
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

    public static MeetingCalComponentPersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(MeetingCalComponentPersistence persistence) {
        _persistence = persistence;
    }
}
