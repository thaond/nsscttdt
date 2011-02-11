package com.sgs.portlet.holiday_calendar.service.persistence;

public class HolidayCalendarUtil {
    private static HolidayCalendarPersistence _persistence;

    public static com.sgs.portlet.holiday_calendar.model.HolidayCalendar create(
        long holidayCalendarId) {
        return getPersistence().create(holidayCalendarId);
    }

    public static com.sgs.portlet.holiday_calendar.model.HolidayCalendar remove(
        long holidayCalendarId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.holiday_calendar.NoSuchException {
        return getPersistence().remove(holidayCalendarId);
    }

    public static com.sgs.portlet.holiday_calendar.model.HolidayCalendar remove(
        com.sgs.portlet.holiday_calendar.model.HolidayCalendar holidayCalendar)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(holidayCalendar);
    }

    /**
     * @deprecated Use <code>update(HolidayCalendar holidayCalendar, boolean merge)</code>.
     */
    public static com.sgs.portlet.holiday_calendar.model.HolidayCalendar update(
        com.sgs.portlet.holiday_calendar.model.HolidayCalendar holidayCalendar)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(holidayCalendar);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                holidayCalendar the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when holidayCalendar is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public static com.sgs.portlet.holiday_calendar.model.HolidayCalendar update(
        com.sgs.portlet.holiday_calendar.model.HolidayCalendar holidayCalendar,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().update(holidayCalendar, merge);
    }

    public static com.sgs.portlet.holiday_calendar.model.HolidayCalendar updateImpl(
        com.sgs.portlet.holiday_calendar.model.HolidayCalendar holidayCalendar,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(holidayCalendar, merge);
    }

    public static com.sgs.portlet.holiday_calendar.model.HolidayCalendar findByPrimaryKey(
        long holidayCalendarId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.holiday_calendar.NoSuchException {
        return getPersistence().findByPrimaryKey(holidayCalendarId);
    }

    public static com.sgs.portlet.holiday_calendar.model.HolidayCalendar fetchByPrimaryKey(
        long holidayCalendarId) throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(holidayCalendarId);
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

    public static java.util.List<com.sgs.portlet.holiday_calendar.model.HolidayCalendar> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.sgs.portlet.holiday_calendar.model.HolidayCalendar> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.sgs.portlet.holiday_calendar.model.HolidayCalendar> findAll(
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

    public static java.util.List<com.sgs.portlet.holiday_calendar.model.AttactFileHoliday> getAttactFileHolidaies(
        long pk) throws com.liferay.portal.SystemException {
        return getPersistence().getAttactFileHolidaies(pk);
    }

    public static java.util.List<com.sgs.portlet.holiday_calendar.model.AttactFileHoliday> getAttactFileHolidaies(
        long pk, int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().getAttactFileHolidaies(pk, start, end);
    }

    public static java.util.List<com.sgs.portlet.holiday_calendar.model.AttactFileHoliday> getAttactFileHolidaies(
        long pk, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().getAttactFileHolidaies(pk, start, end, obc);
    }

    public static int getAttactFileHolidaiesSize(long pk)
        throws com.liferay.portal.SystemException {
        return getPersistence().getAttactFileHolidaiesSize(pk);
    }

    public static boolean containsAttactFileHoliday(long pk,
        long attactFileHolidayPK) throws com.liferay.portal.SystemException {
        return getPersistence()
                   .containsAttactFileHoliday(pk, attactFileHolidayPK);
    }

    public static boolean containsAttactFileHolidaies(long pk)
        throws com.liferay.portal.SystemException {
        return getPersistence().containsAttactFileHolidaies(pk);
    }

    public static void registerListener(
        com.liferay.portal.model.ModelListener listener) {
        getPersistence().registerListener(listener);
    }

    public static void unregisterListener(
        com.liferay.portal.model.ModelListener listener) {
        getPersistence().unregisterListener(listener);
    }

    public static HolidayCalendarPersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(HolidayCalendarPersistence persistence) {
        _persistence = persistence;
    }
}
