package com.sgs.portlet.holiday_calendar.service.persistence;

public class AttactFileHolidayUtil {
    private static AttactFileHolidayPersistence _persistence;

    public static com.sgs.portlet.holiday_calendar.model.AttactFileHoliday create(
        long attactFileHolidayId) {
        return getPersistence().create(attactFileHolidayId);
    }

    public static com.sgs.portlet.holiday_calendar.model.AttactFileHoliday remove(
        long attactFileHolidayId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.holiday_calendar.NoSuchAttactFileHolidayException {
        return getPersistence().remove(attactFileHolidayId);
    }

    public static com.sgs.portlet.holiday_calendar.model.AttactFileHoliday remove(
        com.sgs.portlet.holiday_calendar.model.AttactFileHoliday attactFileHoliday)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(attactFileHoliday);
    }

    /**
     * @deprecated Use <code>update(AttactFileHoliday attactFileHoliday, boolean merge)</code>.
     */
    public static com.sgs.portlet.holiday_calendar.model.AttactFileHoliday update(
        com.sgs.portlet.holiday_calendar.model.AttactFileHoliday attactFileHoliday)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(attactFileHoliday);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                attactFileHoliday the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when attactFileHoliday is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public static com.sgs.portlet.holiday_calendar.model.AttactFileHoliday update(
        com.sgs.portlet.holiday_calendar.model.AttactFileHoliday attactFileHoliday,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().update(attactFileHoliday, merge);
    }

    public static com.sgs.portlet.holiday_calendar.model.AttactFileHoliday updateImpl(
        com.sgs.portlet.holiday_calendar.model.AttactFileHoliday attactFileHoliday,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(attactFileHoliday, merge);
    }

    public static com.sgs.portlet.holiday_calendar.model.AttactFileHoliday findByPrimaryKey(
        long attactFileHolidayId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.holiday_calendar.NoSuchAttactFileHolidayException {
        return getPersistence().findByPrimaryKey(attactFileHolidayId);
    }

    public static com.sgs.portlet.holiday_calendar.model.AttactFileHoliday fetchByPrimaryKey(
        long attactFileHolidayId) throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(attactFileHolidayId);
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

    public static java.util.List<com.sgs.portlet.holiday_calendar.model.AttactFileHoliday> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.sgs.portlet.holiday_calendar.model.AttactFileHoliday> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.sgs.portlet.holiday_calendar.model.AttactFileHoliday> findAll(
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

    public static AttactFileHolidayPersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(AttactFileHolidayPersistence persistence) {
        _persistence = persistence;
    }
}
