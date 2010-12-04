package com.nss.portlet.holidaymanagement.service.persistence;

public class PmlHolidayUtil {
    private static PmlHolidayPersistence _persistence;

    public static void cacheResult(
        com.nss.portlet.holidaymanagement.model.PmlHoliday pmlHoliday) {
        getPersistence().cacheResult(pmlHoliday);
    }

    public static void cacheResult(
        java.util.List<com.nss.portlet.holidaymanagement.model.PmlHoliday> pmlHolidaies) {
        getPersistence().cacheResult(pmlHolidaies);
    }

    public static void clearCache() {
        getPersistence().clearCache();
    }

    public static com.nss.portlet.holidaymanagement.model.PmlHoliday create(
        long holidayId) {
        return getPersistence().create(holidayId);
    }

    public static com.nss.portlet.holidaymanagement.model.PmlHoliday remove(
        long holidayId)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.holidaymanagement.NoSuchPmlHolidayException {
        return getPersistence().remove(holidayId);
    }

    public static com.nss.portlet.holidaymanagement.model.PmlHoliday remove(
        com.nss.portlet.holidaymanagement.model.PmlHoliday pmlHoliday)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(pmlHoliday);
    }

    /**
     * @deprecated Use <code>update(PmlHoliday pmlHoliday, boolean merge)</code>.
     */
    public static com.nss.portlet.holidaymanagement.model.PmlHoliday update(
        com.nss.portlet.holidaymanagement.model.PmlHoliday pmlHoliday)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(pmlHoliday);
    }

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
    public static com.nss.portlet.holidaymanagement.model.PmlHoliday update(
        com.nss.portlet.holidaymanagement.model.PmlHoliday pmlHoliday,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().update(pmlHoliday, merge);
    }

    public static com.nss.portlet.holidaymanagement.model.PmlHoliday updateImpl(
        com.nss.portlet.holidaymanagement.model.PmlHoliday pmlHoliday,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(pmlHoliday, merge);
    }

    public static com.nss.portlet.holidaymanagement.model.PmlHoliday findByPrimaryKey(
        long holidayId)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.holidaymanagement.NoSuchPmlHolidayException {
        return getPersistence().findByPrimaryKey(holidayId);
    }

    public static com.nss.portlet.holidaymanagement.model.PmlHoliday fetchByPrimaryKey(
        long holidayId) throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(holidayId);
    }

    public static java.util.List<com.nss.portlet.holidaymanagement.model.PmlHoliday> findByHoliday_Type(
        java.lang.String holiday_type)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByHoliday_Type(holiday_type);
    }

    public static java.util.List<com.nss.portlet.holidaymanagement.model.PmlHoliday> findByHoliday_Type(
        java.lang.String holiday_type, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByHoliday_Type(holiday_type, start, end);
    }

    public static java.util.List<com.nss.portlet.holidaymanagement.model.PmlHoliday> findByHoliday_Type(
        java.lang.String holiday_type, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByHoliday_Type(holiday_type, start, end, obc);
    }

    public static com.nss.portlet.holidaymanagement.model.PmlHoliday findByHoliday_Type_First(
        java.lang.String holiday_type,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.holidaymanagement.NoSuchPmlHolidayException {
        return getPersistence().findByHoliday_Type_First(holiday_type, obc);
    }

    public static com.nss.portlet.holidaymanagement.model.PmlHoliday findByHoliday_Type_Last(
        java.lang.String holiday_type,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.holidaymanagement.NoSuchPmlHolidayException {
        return getPersistence().findByHoliday_Type_Last(holiday_type, obc);
    }

    public static com.nss.portlet.holidaymanagement.model.PmlHoliday[] findByHoliday_Type_PrevAndNext(
        long holidayId, java.lang.String holiday_type,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.holidaymanagement.NoSuchPmlHolidayException {
        return getPersistence()
                   .findByHoliday_Type_PrevAndNext(holidayId, holiday_type, obc);
    }

    public static java.util.List<com.nss.portlet.holidaymanagement.model.PmlHoliday> findByHoliday_Value(
        java.lang.String holiday_value)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByHoliday_Value(holiday_value);
    }

    public static java.util.List<com.nss.portlet.holidaymanagement.model.PmlHoliday> findByHoliday_Value(
        java.lang.String holiday_value, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByHoliday_Value(holiday_value, start, end);
    }

    public static java.util.List<com.nss.portlet.holidaymanagement.model.PmlHoliday> findByHoliday_Value(
        java.lang.String holiday_value, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByHoliday_Value(holiday_value, start, end, obc);
    }

    public static com.nss.portlet.holidaymanagement.model.PmlHoliday findByHoliday_Value_First(
        java.lang.String holiday_value,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.holidaymanagement.NoSuchPmlHolidayException {
        return getPersistence().findByHoliday_Value_First(holiday_value, obc);
    }

    public static com.nss.portlet.holidaymanagement.model.PmlHoliday findByHoliday_Value_Last(
        java.lang.String holiday_value,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.holidaymanagement.NoSuchPmlHolidayException {
        return getPersistence().findByHoliday_Value_Last(holiday_value, obc);
    }

    public static com.nss.portlet.holidaymanagement.model.PmlHoliday[] findByHoliday_Value_PrevAndNext(
        long holidayId, java.lang.String holiday_value,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.holidaymanagement.NoSuchPmlHolidayException {
        return getPersistence()
                   .findByHoliday_Value_PrevAndNext(holidayId, holiday_value,
            obc);
    }

    public static java.util.List<com.nss.portlet.holidaymanagement.model.PmlHoliday> findByFrom_Date(
        java.util.Date from_date) throws com.liferay.portal.SystemException {
        return getPersistence().findByFrom_Date(from_date);
    }

    public static java.util.List<com.nss.portlet.holidaymanagement.model.PmlHoliday> findByFrom_Date(
        java.util.Date from_date, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByFrom_Date(from_date, start, end);
    }

    public static java.util.List<com.nss.portlet.holidaymanagement.model.PmlHoliday> findByFrom_Date(
        java.util.Date from_date, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByFrom_Date(from_date, start, end, obc);
    }

    public static com.nss.portlet.holidaymanagement.model.PmlHoliday findByFrom_Date_First(
        java.util.Date from_date,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.holidaymanagement.NoSuchPmlHolidayException {
        return getPersistence().findByFrom_Date_First(from_date, obc);
    }

    public static com.nss.portlet.holidaymanagement.model.PmlHoliday findByFrom_Date_Last(
        java.util.Date from_date,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.holidaymanagement.NoSuchPmlHolidayException {
        return getPersistence().findByFrom_Date_Last(from_date, obc);
    }

    public static com.nss.portlet.holidaymanagement.model.PmlHoliday[] findByFrom_Date_PrevAndNext(
        long holidayId, java.util.Date from_date,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.holidaymanagement.NoSuchPmlHolidayException {
        return getPersistence()
                   .findByFrom_Date_PrevAndNext(holidayId, from_date, obc);
    }

    public static java.util.List<com.nss.portlet.holidaymanagement.model.PmlHoliday> findByTo_Date(
        java.util.Date to_date) throws com.liferay.portal.SystemException {
        return getPersistence().findByTo_Date(to_date);
    }

    public static java.util.List<com.nss.portlet.holidaymanagement.model.PmlHoliday> findByTo_Date(
        java.util.Date to_date, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByTo_Date(to_date, start, end);
    }

    public static java.util.List<com.nss.portlet.holidaymanagement.model.PmlHoliday> findByTo_Date(
        java.util.Date to_date, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByTo_Date(to_date, start, end, obc);
    }

    public static com.nss.portlet.holidaymanagement.model.PmlHoliday findByTo_Date_First(
        java.util.Date to_date,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.holidaymanagement.NoSuchPmlHolidayException {
        return getPersistence().findByTo_Date_First(to_date, obc);
    }

    public static com.nss.portlet.holidaymanagement.model.PmlHoliday findByTo_Date_Last(
        java.util.Date to_date,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.holidaymanagement.NoSuchPmlHolidayException {
        return getPersistence().findByTo_Date_Last(to_date, obc);
    }

    public static com.nss.portlet.holidaymanagement.model.PmlHoliday[] findByTo_Date_PrevAndNext(
        long holidayId, java.util.Date to_date,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.holidaymanagement.NoSuchPmlHolidayException {
        return getPersistence()
                   .findByTo_Date_PrevAndNext(holidayId, to_date, obc);
    }

    public static java.util.List<com.nss.portlet.holidaymanagement.model.PmlHoliday> findByFromDate_ToDate(
        java.util.Date from_date, java.util.Date to_date)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByFromDate_ToDate(from_date, to_date);
    }

    public static java.util.List<com.nss.portlet.holidaymanagement.model.PmlHoliday> findByFromDate_ToDate(
        java.util.Date from_date, java.util.Date to_date, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByFromDate_ToDate(from_date, to_date, start, end);
    }

    public static java.util.List<com.nss.portlet.holidaymanagement.model.PmlHoliday> findByFromDate_ToDate(
        java.util.Date from_date, java.util.Date to_date, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByFromDate_ToDate(from_date, to_date, start, end, obc);
    }

    public static com.nss.portlet.holidaymanagement.model.PmlHoliday findByFromDate_ToDate_First(
        java.util.Date from_date, java.util.Date to_date,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.holidaymanagement.NoSuchPmlHolidayException {
        return getPersistence()
                   .findByFromDate_ToDate_First(from_date, to_date, obc);
    }

    public static com.nss.portlet.holidaymanagement.model.PmlHoliday findByFromDate_ToDate_Last(
        java.util.Date from_date, java.util.Date to_date,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.holidaymanagement.NoSuchPmlHolidayException {
        return getPersistence()
                   .findByFromDate_ToDate_Last(from_date, to_date, obc);
    }

    public static com.nss.portlet.holidaymanagement.model.PmlHoliday[] findByFromDate_ToDate_PrevAndNext(
        long holidayId, java.util.Date from_date, java.util.Date to_date,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.holidaymanagement.NoSuchPmlHolidayException {
        return getPersistence()
                   .findByFromDate_ToDate_PrevAndNext(holidayId, from_date,
            to_date, obc);
    }

    public static java.util.List<com.nss.portlet.holidaymanagement.model.PmlHoliday> findByHolidayType_HolidayValue(
        java.lang.String holiday_type, java.lang.String holiday_value)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByHolidayType_HolidayValue(holiday_type, holiday_value);
    }

    public static java.util.List<com.nss.portlet.holidaymanagement.model.PmlHoliday> findByHolidayType_HolidayValue(
        java.lang.String holiday_type, java.lang.String holiday_value,
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByHolidayType_HolidayValue(holiday_type, holiday_value,
            start, end);
    }

    public static java.util.List<com.nss.portlet.holidaymanagement.model.PmlHoliday> findByHolidayType_HolidayValue(
        java.lang.String holiday_type, java.lang.String holiday_value,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByHolidayType_HolidayValue(holiday_type, holiday_value,
            start, end, obc);
    }

    public static com.nss.portlet.holidaymanagement.model.PmlHoliday findByHolidayType_HolidayValue_First(
        java.lang.String holiday_type, java.lang.String holiday_value,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.holidaymanagement.NoSuchPmlHolidayException {
        return getPersistence()
                   .findByHolidayType_HolidayValue_First(holiday_type,
            holiday_value, obc);
    }

    public static com.nss.portlet.holidaymanagement.model.PmlHoliday findByHolidayType_HolidayValue_Last(
        java.lang.String holiday_type, java.lang.String holiday_value,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.holidaymanagement.NoSuchPmlHolidayException {
        return getPersistence()
                   .findByHolidayType_HolidayValue_Last(holiday_type,
            holiday_value, obc);
    }

    public static com.nss.portlet.holidaymanagement.model.PmlHoliday[] findByHolidayType_HolidayValue_PrevAndNext(
        long holidayId, java.lang.String holiday_type,
        java.lang.String holiday_value,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.holidaymanagement.NoSuchPmlHolidayException {
        return getPersistence()
                   .findByHolidayType_HolidayValue_PrevAndNext(holidayId,
            holiday_type, holiday_value, obc);
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

    public static java.util.List<com.nss.portlet.holidaymanagement.model.PmlHoliday> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.nss.portlet.holidaymanagement.model.PmlHoliday> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.nss.portlet.holidaymanagement.model.PmlHoliday> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end, obc);
    }

    public static void removeByHoliday_Type(java.lang.String holiday_type)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByHoliday_Type(holiday_type);
    }

    public static void removeByHoliday_Value(java.lang.String holiday_value)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByHoliday_Value(holiday_value);
    }

    public static void removeByFrom_Date(java.util.Date from_date)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByFrom_Date(from_date);
    }

    public static void removeByTo_Date(java.util.Date to_date)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByTo_Date(to_date);
    }

    public static void removeByFromDate_ToDate(java.util.Date from_date,
        java.util.Date to_date) throws com.liferay.portal.SystemException {
        getPersistence().removeByFromDate_ToDate(from_date, to_date);
    }

    public static void removeByHolidayType_HolidayValue(
        java.lang.String holiday_type, java.lang.String holiday_value)
        throws com.liferay.portal.SystemException {
        getPersistence()
            .removeByHolidayType_HolidayValue(holiday_type, holiday_value);
    }

    public static void removeAll() throws com.liferay.portal.SystemException {
        getPersistence().removeAll();
    }

    public static int countByHoliday_Type(java.lang.String holiday_type)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByHoliday_Type(holiday_type);
    }

    public static int countByHoliday_Value(java.lang.String holiday_value)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByHoliday_Value(holiday_value);
    }

    public static int countByFrom_Date(java.util.Date from_date)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByFrom_Date(from_date);
    }

    public static int countByTo_Date(java.util.Date to_date)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByTo_Date(to_date);
    }

    public static int countByFromDate_ToDate(java.util.Date from_date,
        java.util.Date to_date) throws com.liferay.portal.SystemException {
        return getPersistence().countByFromDate_ToDate(from_date, to_date);
    }

    public static int countByHolidayType_HolidayValue(
        java.lang.String holiday_type, java.lang.String holiday_value)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .countByHolidayType_HolidayValue(holiday_type, holiday_value);
    }

    public static int countAll() throws com.liferay.portal.SystemException {
        return getPersistence().countAll();
    }

    public static PmlHolidayPersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(PmlHolidayPersistence persistence) {
        _persistence = persistence;
    }
}
