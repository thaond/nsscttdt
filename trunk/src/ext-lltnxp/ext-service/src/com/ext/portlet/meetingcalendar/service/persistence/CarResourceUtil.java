package com.ext.portlet.meetingcalendar.service.persistence;

public class CarResourceUtil {
    private static CarResourcePersistence _persistence;

    public static com.ext.portlet.meetingcalendar.model.CarResource create(
        long carId) {
        return getPersistence().create(carId);
    }

    public static com.ext.portlet.meetingcalendar.model.CarResource remove(
        long carId)
        throws com.ext.portlet.meetingcalendar.NoSuchCarResourceException,
            com.liferay.portal.SystemException {
        return getPersistence().remove(carId);
    }

    public static com.ext.portlet.meetingcalendar.model.CarResource remove(
        com.ext.portlet.meetingcalendar.model.CarResource carResource)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(carResource);
    }

    /**
     * @deprecated Use <code>update(CarResource carResource, boolean merge)</code>.
     */
    public static com.ext.portlet.meetingcalendar.model.CarResource update(
        com.ext.portlet.meetingcalendar.model.CarResource carResource)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(carResource);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                carResource the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when carResource is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public static com.ext.portlet.meetingcalendar.model.CarResource update(
        com.ext.portlet.meetingcalendar.model.CarResource carResource,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().update(carResource, merge);
    }

    public static com.ext.portlet.meetingcalendar.model.CarResource updateImpl(
        com.ext.portlet.meetingcalendar.model.CarResource carResource,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(carResource, merge);
    }

    public static com.ext.portlet.meetingcalendar.model.CarResource findByPrimaryKey(
        long carId)
        throws com.ext.portlet.meetingcalendar.NoSuchCarResourceException,
            com.liferay.portal.SystemException {
        return getPersistence().findByPrimaryKey(carId);
    }

    public static com.ext.portlet.meetingcalendar.model.CarResource fetchByPrimaryKey(
        long carId) throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(carId);
    }

    public static com.ext.portlet.meetingcalendar.model.CarResource findByC_C(
        java.lang.String carCode, long companyId)
        throws com.ext.portlet.meetingcalendar.NoSuchCarResourceException,
            com.liferay.portal.SystemException {
        return getPersistence().findByC_C(carCode, companyId);
    }

    public static com.ext.portlet.meetingcalendar.model.CarResource fetchByC_C(
        java.lang.String carCode, long companyId)
        throws com.liferay.portal.SystemException {
        return getPersistence().fetchByC_C(carCode, companyId);
    }

    public static java.util.List<com.ext.portlet.meetingcalendar.model.CarResource> findByCompanyId(
        long companyId) throws com.liferay.portal.SystemException {
        return getPersistence().findByCompanyId(companyId);
    }

    public static java.util.List<com.ext.portlet.meetingcalendar.model.CarResource> findByCompanyId(
        long companyId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByCompanyId(companyId, start, end);
    }

    public static java.util.List<com.ext.portlet.meetingcalendar.model.CarResource> findByCompanyId(
        long companyId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByCompanyId(companyId, start, end, obc);
    }

    public static com.ext.portlet.meetingcalendar.model.CarResource findByCompanyId_First(
        long companyId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.ext.portlet.meetingcalendar.NoSuchCarResourceException,
            com.liferay.portal.SystemException {
        return getPersistence().findByCompanyId_First(companyId, obc);
    }

    public static com.ext.portlet.meetingcalendar.model.CarResource findByCompanyId_Last(
        long companyId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.ext.portlet.meetingcalendar.NoSuchCarResourceException,
            com.liferay.portal.SystemException {
        return getPersistence().findByCompanyId_Last(companyId, obc);
    }

    public static com.ext.portlet.meetingcalendar.model.CarResource[] findByCompanyId_PrevAndNext(
        long carId, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.ext.portlet.meetingcalendar.NoSuchCarResourceException,
            com.liferay.portal.SystemException {
        return getPersistence()
                   .findByCompanyId_PrevAndNext(carId, companyId, obc);
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

    public static java.util.List<com.ext.portlet.meetingcalendar.model.CarResource> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.ext.portlet.meetingcalendar.model.CarResource> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.ext.portlet.meetingcalendar.model.CarResource> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end, obc);
    }

    public static void removeByC_C(java.lang.String carCode, long companyId)
        throws com.ext.portlet.meetingcalendar.NoSuchCarResourceException,
            com.liferay.portal.SystemException {
        getPersistence().removeByC_C(carCode, companyId);
    }

    public static void removeByCompanyId(long companyId)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByCompanyId(companyId);
    }

    public static void removeAll() throws com.liferay.portal.SystemException {
        getPersistence().removeAll();
    }

    public static int countByC_C(java.lang.String carCode, long companyId)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByC_C(carCode, companyId);
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

    public static CarResourcePersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(CarResourcePersistence persistence) {
        _persistence = persistence;
    }
}
