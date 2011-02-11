package com.sgs.portlet.holiday_calendar.service.persistence;

public interface HolidayCalendarPersistence {
    public com.sgs.portlet.holiday_calendar.model.HolidayCalendar create(
        long holidayCalendarId);

    public com.sgs.portlet.holiday_calendar.model.HolidayCalendar remove(
        long holidayCalendarId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.holiday_calendar.NoSuchException;

    public com.sgs.portlet.holiday_calendar.model.HolidayCalendar remove(
        com.sgs.portlet.holiday_calendar.model.HolidayCalendar holidayCalendar)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(HolidayCalendar holidayCalendar, boolean merge)</code>.
     */
    public com.sgs.portlet.holiday_calendar.model.HolidayCalendar update(
        com.sgs.portlet.holiday_calendar.model.HolidayCalendar holidayCalendar)
        throws com.liferay.portal.SystemException;

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
    public com.sgs.portlet.holiday_calendar.model.HolidayCalendar update(
        com.sgs.portlet.holiday_calendar.model.HolidayCalendar holidayCalendar,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.holiday_calendar.model.HolidayCalendar updateImpl(
        com.sgs.portlet.holiday_calendar.model.HolidayCalendar holidayCalendar,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.holiday_calendar.model.HolidayCalendar findByPrimaryKey(
        long holidayCalendarId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.holiday_calendar.NoSuchException;

    public com.sgs.portlet.holiday_calendar.model.HolidayCalendar fetchByPrimaryKey(
        long holidayCalendarId) throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.holiday_calendar.model.HolidayCalendar> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.holiday_calendar.model.HolidayCalendar> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.holiday_calendar.model.HolidayCalendar> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.holiday_calendar.model.AttactFileHoliday> getAttactFileHolidaies(
        long pk) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.holiday_calendar.model.AttactFileHoliday> getAttactFileHolidaies(
        long pk, int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.holiday_calendar.model.AttactFileHoliday> getAttactFileHolidaies(
        long pk, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public int getAttactFileHolidaiesSize(long pk)
        throws com.liferay.portal.SystemException;

    public boolean containsAttactFileHoliday(long pk, long attactFileHolidayPK)
        throws com.liferay.portal.SystemException;

    public boolean containsAttactFileHolidaies(long pk)
        throws com.liferay.portal.SystemException;

    public void registerListener(
        com.liferay.portal.model.ModelListener listener);

    public void unregisterListener(
        com.liferay.portal.model.ModelListener listener);
}
