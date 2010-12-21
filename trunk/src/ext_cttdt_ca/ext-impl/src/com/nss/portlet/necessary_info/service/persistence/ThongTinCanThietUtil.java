package com.nss.portlet.necessary_info.service.persistence;

public class ThongTinCanThietUtil {
    private static ThongTinCanThietPersistence _persistence;

    public static void cacheResult(
        com.nss.portlet.necessary_info.model.ThongTinCanThiet thongTinCanThiet) {
        getPersistence().cacheResult(thongTinCanThiet);
    }

    public static void cacheResult(
        java.util.List<com.nss.portlet.necessary_info.model.ThongTinCanThiet> thongTinCanThiets) {
        getPersistence().cacheResult(thongTinCanThiets);
    }

    public static void clearCache() {
        getPersistence().clearCache();
    }

    public static com.nss.portlet.necessary_info.model.ThongTinCanThiet create(
        long maThongTinCanThiet) {
        return getPersistence().create(maThongTinCanThiet);
    }

    public static com.nss.portlet.necessary_info.model.ThongTinCanThiet remove(
        long maThongTinCanThiet)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.necessary_info.NoSuchThongTinCanThietException {
        return getPersistence().remove(maThongTinCanThiet);
    }

    public static com.nss.portlet.necessary_info.model.ThongTinCanThiet remove(
        com.nss.portlet.necessary_info.model.ThongTinCanThiet thongTinCanThiet)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(thongTinCanThiet);
    }

    /**
     * @deprecated Use <code>update(ThongTinCanThiet thongTinCanThiet, boolean merge)</code>.
     */
    public static com.nss.portlet.necessary_info.model.ThongTinCanThiet update(
        com.nss.portlet.necessary_info.model.ThongTinCanThiet thongTinCanThiet)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(thongTinCanThiet);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                thongTinCanThiet the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when thongTinCanThiet is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public static com.nss.portlet.necessary_info.model.ThongTinCanThiet update(
        com.nss.portlet.necessary_info.model.ThongTinCanThiet thongTinCanThiet,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().update(thongTinCanThiet, merge);
    }

    public static com.nss.portlet.necessary_info.model.ThongTinCanThiet updateImpl(
        com.nss.portlet.necessary_info.model.ThongTinCanThiet thongTinCanThiet,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(thongTinCanThiet, merge);
    }

    public static com.nss.portlet.necessary_info.model.ThongTinCanThiet findByPrimaryKey(
        long maThongTinCanThiet)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.necessary_info.NoSuchThongTinCanThietException {
        return getPersistence().findByPrimaryKey(maThongTinCanThiet);
    }

    public static com.nss.portlet.necessary_info.model.ThongTinCanThiet fetchByPrimaryKey(
        long maThongTinCanThiet) throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(maThongTinCanThiet);
    }

    public static java.util.List<com.nss.portlet.necessary_info.model.ThongTinCanThiet> findByActive(
        int active) throws com.liferay.portal.SystemException {
        return getPersistence().findByActive(active);
    }

    public static java.util.List<com.nss.portlet.necessary_info.model.ThongTinCanThiet> findByActive(
        int active, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByActive(active, start, end);
    }

    public static java.util.List<com.nss.portlet.necessary_info.model.ThongTinCanThiet> findByActive(
        int active, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByActive(active, start, end, obc);
    }

    public static com.nss.portlet.necessary_info.model.ThongTinCanThiet findByActive_First(
        int active, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.necessary_info.NoSuchThongTinCanThietException {
        return getPersistence().findByActive_First(active, obc);
    }

    public static com.nss.portlet.necessary_info.model.ThongTinCanThiet findByActive_Last(
        int active, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.necessary_info.NoSuchThongTinCanThietException {
        return getPersistence().findByActive_Last(active, obc);
    }

    public static com.nss.portlet.necessary_info.model.ThongTinCanThiet[] findByActive_PrevAndNext(
        long maThongTinCanThiet, int active,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.necessary_info.NoSuchThongTinCanThietException {
        return getPersistence()
                   .findByActive_PrevAndNext(maThongTinCanThiet, active, obc);
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

    public static java.util.List<com.nss.portlet.necessary_info.model.ThongTinCanThiet> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.nss.portlet.necessary_info.model.ThongTinCanThiet> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.nss.portlet.necessary_info.model.ThongTinCanThiet> findAll(
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

    public static ThongTinCanThietPersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(ThongTinCanThietPersistence persistence) {
        _persistence = persistence;
    }
}
