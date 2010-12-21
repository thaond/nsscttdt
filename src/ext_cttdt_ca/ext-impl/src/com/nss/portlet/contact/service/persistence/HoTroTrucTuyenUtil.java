package com.nss.portlet.contact.service.persistence;

public class HoTroTrucTuyenUtil {
    private static HoTroTrucTuyenPersistence _persistence;

    public static void cacheResult(
        com.nss.portlet.contact.model.HoTroTrucTuyen hoTroTrucTuyen) {
        getPersistence().cacheResult(hoTroTrucTuyen);
    }

    public static void cacheResult(
        java.util.List<com.nss.portlet.contact.model.HoTroTrucTuyen> hoTroTrucTuyens) {
        getPersistence().cacheResult(hoTroTrucTuyens);
    }

    public static void clearCache() {
        getPersistence().clearCache();
    }

    public static com.nss.portlet.contact.model.HoTroTrucTuyen create(
        int maHoTroTrucTuyen) {
        return getPersistence().create(maHoTroTrucTuyen);
    }

    public static com.nss.portlet.contact.model.HoTroTrucTuyen remove(
        int maHoTroTrucTuyen)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.contact.NoSuchHoTroTrucTuyenException {
        return getPersistence().remove(maHoTroTrucTuyen);
    }

    public static com.nss.portlet.contact.model.HoTroTrucTuyen remove(
        com.nss.portlet.contact.model.HoTroTrucTuyen hoTroTrucTuyen)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(hoTroTrucTuyen);
    }

    /**
     * @deprecated Use <code>update(HoTroTrucTuyen hoTroTrucTuyen, boolean merge)</code>.
     */
    public static com.nss.portlet.contact.model.HoTroTrucTuyen update(
        com.nss.portlet.contact.model.HoTroTrucTuyen hoTroTrucTuyen)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(hoTroTrucTuyen);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                hoTroTrucTuyen the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when hoTroTrucTuyen is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public static com.nss.portlet.contact.model.HoTroTrucTuyen update(
        com.nss.portlet.contact.model.HoTroTrucTuyen hoTroTrucTuyen,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().update(hoTroTrucTuyen, merge);
    }

    public static com.nss.portlet.contact.model.HoTroTrucTuyen updateImpl(
        com.nss.portlet.contact.model.HoTroTrucTuyen hoTroTrucTuyen,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(hoTroTrucTuyen, merge);
    }

    public static com.nss.portlet.contact.model.HoTroTrucTuyen findByPrimaryKey(
        int maHoTroTrucTuyen)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.contact.NoSuchHoTroTrucTuyenException {
        return getPersistence().findByPrimaryKey(maHoTroTrucTuyen);
    }

    public static com.nss.portlet.contact.model.HoTroTrucTuyen fetchByPrimaryKey(
        int maHoTroTrucTuyen) throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(maHoTroTrucTuyen);
    }

    public static java.util.List<com.nss.portlet.contact.model.HoTroTrucTuyen> findByActive(
        int active) throws com.liferay.portal.SystemException {
        return getPersistence().findByActive(active);
    }

    public static java.util.List<com.nss.portlet.contact.model.HoTroTrucTuyen> findByActive(
        int active, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByActive(active, start, end);
    }

    public static java.util.List<com.nss.portlet.contact.model.HoTroTrucTuyen> findByActive(
        int active, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByActive(active, start, end, obc);
    }

    public static com.nss.portlet.contact.model.HoTroTrucTuyen findByActive_First(
        int active, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.contact.NoSuchHoTroTrucTuyenException {
        return getPersistence().findByActive_First(active, obc);
    }

    public static com.nss.portlet.contact.model.HoTroTrucTuyen findByActive_Last(
        int active, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.contact.NoSuchHoTroTrucTuyenException {
        return getPersistence().findByActive_Last(active, obc);
    }

    public static com.nss.portlet.contact.model.HoTroTrucTuyen[] findByActive_PrevAndNext(
        int maHoTroTrucTuyen, int active,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.contact.NoSuchHoTroTrucTuyenException {
        return getPersistence()
                   .findByActive_PrevAndNext(maHoTroTrucTuyen, active, obc);
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

    public static java.util.List<com.nss.portlet.contact.model.HoTroTrucTuyen> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.nss.portlet.contact.model.HoTroTrucTuyen> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.nss.portlet.contact.model.HoTroTrucTuyen> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end, obc);
    }

    public static void removeByActive(int active)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByActive(active);
    }

    public static void removeAll() throws com.liferay.portal.SystemException {
        getPersistence().removeAll();
    }

    public static int countByActive(int active)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByActive(active);
    }

    public static int countAll() throws com.liferay.portal.SystemException {
        return getPersistence().countAll();
    }

    public static HoTroTrucTuyenPersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(HoTroTrucTuyenPersistence persistence) {
        _persistence = persistence;
    }
}
