package com.sgs.portlet.holiday_calendar.service.persistence;

public interface AttactFileHolidayPersistence {
    public com.sgs.portlet.holiday_calendar.model.AttactFileHoliday create(
        long attactFileHolidayId);

    public com.sgs.portlet.holiday_calendar.model.AttactFileHoliday remove(
        long attactFileHolidayId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.holiday_calendar.NoSuchAttactFileHolidayException;

    public com.sgs.portlet.holiday_calendar.model.AttactFileHoliday remove(
        com.sgs.portlet.holiday_calendar.model.AttactFileHoliday attactFileHoliday)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(AttactFileHoliday attactFileHoliday, boolean merge)</code>.
     */
    public com.sgs.portlet.holiday_calendar.model.AttactFileHoliday update(
        com.sgs.portlet.holiday_calendar.model.AttactFileHoliday attactFileHoliday)
        throws com.liferay.portal.SystemException;

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
    public com.sgs.portlet.holiday_calendar.model.AttactFileHoliday update(
        com.sgs.portlet.holiday_calendar.model.AttactFileHoliday attactFileHoliday,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.holiday_calendar.model.AttactFileHoliday updateImpl(
        com.sgs.portlet.holiday_calendar.model.AttactFileHoliday attactFileHoliday,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.holiday_calendar.model.AttactFileHoliday findByPrimaryKey(
        long attactFileHolidayId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.holiday_calendar.NoSuchAttactFileHolidayException;

    public com.sgs.portlet.holiday_calendar.model.AttactFileHoliday fetchByPrimaryKey(
        long attactFileHolidayId) throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.holiday_calendar.model.AttactFileHoliday> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.holiday_calendar.model.AttactFileHoliday> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.holiday_calendar.model.AttactFileHoliday> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;

    public void registerListener(
        com.liferay.portal.model.ModelListener listener);

    public void unregisterListener(
        com.liferay.portal.model.ModelListener listener);
}
