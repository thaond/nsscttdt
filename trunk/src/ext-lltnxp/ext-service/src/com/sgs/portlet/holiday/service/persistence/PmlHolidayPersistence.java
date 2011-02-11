package com.sgs.portlet.holiday.service.persistence;

public interface PmlHolidayPersistence {
    public com.sgs.portlet.holiday.model.PmlHoliday create(long holidayId);

    public com.sgs.portlet.holiday.model.PmlHoliday remove(long holidayId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.holiday.NoSuchException;

    public com.sgs.portlet.holiday.model.PmlHoliday remove(
        com.sgs.portlet.holiday.model.PmlHoliday pmlHoliday)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(PmlHoliday pmlHoliday, boolean merge)</code>.
     */
    public com.sgs.portlet.holiday.model.PmlHoliday update(
        com.sgs.portlet.holiday.model.PmlHoliday pmlHoliday)
        throws com.liferay.portal.SystemException;

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlHoliday the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlHoliday is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public com.sgs.portlet.holiday.model.PmlHoliday update(
        com.sgs.portlet.holiday.model.PmlHoliday pmlHoliday, boolean merge)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.holiday.model.PmlHoliday updateImpl(
        com.sgs.portlet.holiday.model.PmlHoliday pmlHoliday, boolean merge)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.holiday.model.PmlHoliday findByPrimaryKey(
        long holidayId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.holiday.NoSuchException;

    public com.sgs.portlet.holiday.model.PmlHoliday fetchByPrimaryKey(
        long holidayId) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.holiday.model.PmlHoliday> findByHoliday_Type(
        java.lang.String holiday_type)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.holiday.model.PmlHoliday> findByHoliday_Type(
        java.lang.String holiday_type, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.holiday.model.PmlHoliday> findByHoliday_Type(
        java.lang.String holiday_type, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.holiday.model.PmlHoliday findByHoliday_Type_First(
        java.lang.String holiday_type,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.holiday.NoSuchException;

    public com.sgs.portlet.holiday.model.PmlHoliday findByHoliday_Type_Last(
        java.lang.String holiday_type,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.holiday.NoSuchException;

    public com.sgs.portlet.holiday.model.PmlHoliday[] findByHoliday_Type_PrevAndNext(
        long holidayId, java.lang.String holiday_type,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.holiday.NoSuchException;

    public java.util.List<com.sgs.portlet.holiday.model.PmlHoliday> findByHoliday_Value(
        java.lang.String holiday_value)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.holiday.model.PmlHoliday> findByHoliday_Value(
        java.lang.String holiday_value, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.holiday.model.PmlHoliday> findByHoliday_Value(
        java.lang.String holiday_value, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.holiday.model.PmlHoliday findByHoliday_Value_First(
        java.lang.String holiday_value,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.holiday.NoSuchException;

    public com.sgs.portlet.holiday.model.PmlHoliday findByHoliday_Value_Last(
        java.lang.String holiday_value,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.holiday.NoSuchException;

    public com.sgs.portlet.holiday.model.PmlHoliday[] findByHoliday_Value_PrevAndNext(
        long holidayId, java.lang.String holiday_value,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.holiday.NoSuchException;

    public java.util.List<com.sgs.portlet.holiday.model.PmlHoliday> findByFrom_Date(
        java.util.Date from_date) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.holiday.model.PmlHoliday> findByFrom_Date(
        java.util.Date from_date, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.holiday.model.PmlHoliday> findByFrom_Date(
        java.util.Date from_date, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.holiday.model.PmlHoliday findByFrom_Date_First(
        java.util.Date from_date,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.holiday.NoSuchException;

    public com.sgs.portlet.holiday.model.PmlHoliday findByFrom_Date_Last(
        java.util.Date from_date,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.holiday.NoSuchException;

    public com.sgs.portlet.holiday.model.PmlHoliday[] findByFrom_Date_PrevAndNext(
        long holidayId, java.util.Date from_date,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.holiday.NoSuchException;

    public java.util.List<com.sgs.portlet.holiday.model.PmlHoliday> findByTo_Date(
        java.util.Date to_date) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.holiday.model.PmlHoliday> findByTo_Date(
        java.util.Date to_date, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.holiday.model.PmlHoliday> findByTo_Date(
        java.util.Date to_date, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.holiday.model.PmlHoliday findByTo_Date_First(
        java.util.Date to_date,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.holiday.NoSuchException;

    public com.sgs.portlet.holiday.model.PmlHoliday findByTo_Date_Last(
        java.util.Date to_date,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.holiday.NoSuchException;

    public com.sgs.portlet.holiday.model.PmlHoliday[] findByTo_Date_PrevAndNext(
        long holidayId, java.util.Date to_date,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.holiday.NoSuchException;

    public java.util.List<com.sgs.portlet.holiday.model.PmlHoliday> findByFromDate_ToDate(
        java.util.Date from_date, java.util.Date to_date)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.holiday.model.PmlHoliday> findByFromDate_ToDate(
        java.util.Date from_date, java.util.Date to_date, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.holiday.model.PmlHoliday> findByFromDate_ToDate(
        java.util.Date from_date, java.util.Date to_date, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.holiday.model.PmlHoliday findByFromDate_ToDate_First(
        java.util.Date from_date, java.util.Date to_date,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.holiday.NoSuchException;

    public com.sgs.portlet.holiday.model.PmlHoliday findByFromDate_ToDate_Last(
        java.util.Date from_date, java.util.Date to_date,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.holiday.NoSuchException;

    public com.sgs.portlet.holiday.model.PmlHoliday[] findByFromDate_ToDate_PrevAndNext(
        long holidayId, java.util.Date from_date, java.util.Date to_date,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.holiday.NoSuchException;

    public java.util.List<com.sgs.portlet.holiday.model.PmlHoliday> findByHolidayType_HolidayValue(
        java.lang.String holiday_type, java.lang.String holiday_value)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.holiday.model.PmlHoliday> findByHolidayType_HolidayValue(
        java.lang.String holiday_type, java.lang.String holiday_value,
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.holiday.model.PmlHoliday> findByHolidayType_HolidayValue(
        java.lang.String holiday_type, java.lang.String holiday_value,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.holiday.model.PmlHoliday findByHolidayType_HolidayValue_First(
        java.lang.String holiday_type, java.lang.String holiday_value,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.holiday.NoSuchException;

    public com.sgs.portlet.holiday.model.PmlHoliday findByHolidayType_HolidayValue_Last(
        java.lang.String holiday_type, java.lang.String holiday_value,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.holiday.NoSuchException;

    public com.sgs.portlet.holiday.model.PmlHoliday[] findByHolidayType_HolidayValue_PrevAndNext(
        long holidayId, java.lang.String holiday_type,
        java.lang.String holiday_value,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.holiday.NoSuchException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.holiday.model.PmlHoliday> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.holiday.model.PmlHoliday> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.holiday.model.PmlHoliday> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeByHoliday_Type(java.lang.String holiday_type)
        throws com.liferay.portal.SystemException;

    public void removeByHoliday_Value(java.lang.String holiday_value)
        throws com.liferay.portal.SystemException;

    public void removeByFrom_Date(java.util.Date from_date)
        throws com.liferay.portal.SystemException;

    public void removeByTo_Date(java.util.Date to_date)
        throws com.liferay.portal.SystemException;

    public void removeByFromDate_ToDate(java.util.Date from_date,
        java.util.Date to_date) throws com.liferay.portal.SystemException;

    public void removeByHolidayType_HolidayValue(
        java.lang.String holiday_type, java.lang.String holiday_value)
        throws com.liferay.portal.SystemException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countByHoliday_Type(java.lang.String holiday_type)
        throws com.liferay.portal.SystemException;

    public int countByHoliday_Value(java.lang.String holiday_value)
        throws com.liferay.portal.SystemException;

    public int countByFrom_Date(java.util.Date from_date)
        throws com.liferay.portal.SystemException;

    public int countByTo_Date(java.util.Date to_date)
        throws com.liferay.portal.SystemException;

    public int countByFromDate_ToDate(java.util.Date from_date,
        java.util.Date to_date) throws com.liferay.portal.SystemException;

    public int countByHolidayType_HolidayValue(java.lang.String holiday_type,
        java.lang.String holiday_value)
        throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;

    public void registerListener(
        com.liferay.portal.model.ModelListener listener);

    public void unregisterListener(
        com.liferay.portal.model.ModelListener listener);
}
