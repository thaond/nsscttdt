package com.nss.portlet.thong_tin_lien_quan.service.persistence;

public class ThongTinLienQuanUtil {
    private static ThongTinLienQuanPersistence _persistence;

    public static void cacheResult(
        com.nss.portlet.thong_tin_lien_quan.model.ThongTinLienQuan thongTinLienQuan) {
        getPersistence().cacheResult(thongTinLienQuan);
    }

    public static void cacheResult(
        java.util.List<com.nss.portlet.thong_tin_lien_quan.model.ThongTinLienQuan> thongTinLienQuans) {
        getPersistence().cacheResult(thongTinLienQuans);
    }

    public static void clearCache() {
        getPersistence().clearCache();
    }

    public static com.nss.portlet.thong_tin_lien_quan.model.ThongTinLienQuan create(
        long maThongTinLienQuan) {
        return getPersistence().create(maThongTinLienQuan);
    }

    public static com.nss.portlet.thong_tin_lien_quan.model.ThongTinLienQuan remove(
        long maThongTinLienQuan)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.thong_tin_lien_quan.NoSuchThongTinLienQuanException {
        return getPersistence().remove(maThongTinLienQuan);
    }

    public static com.nss.portlet.thong_tin_lien_quan.model.ThongTinLienQuan remove(
        com.nss.portlet.thong_tin_lien_quan.model.ThongTinLienQuan thongTinLienQuan)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(thongTinLienQuan);
    }

    /**
     * @deprecated Use <code>update(ThongTinLienQuan thongTinLienQuan, boolean merge)</code>.
     */
    public static com.nss.portlet.thong_tin_lien_quan.model.ThongTinLienQuan update(
        com.nss.portlet.thong_tin_lien_quan.model.ThongTinLienQuan thongTinLienQuan)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(thongTinLienQuan);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                thongTinLienQuan the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when thongTinLienQuan is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public static com.nss.portlet.thong_tin_lien_quan.model.ThongTinLienQuan update(
        com.nss.portlet.thong_tin_lien_quan.model.ThongTinLienQuan thongTinLienQuan,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().update(thongTinLienQuan, merge);
    }

    public static com.nss.portlet.thong_tin_lien_quan.model.ThongTinLienQuan updateImpl(
        com.nss.portlet.thong_tin_lien_quan.model.ThongTinLienQuan thongTinLienQuan,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(thongTinLienQuan, merge);
    }

    public static com.nss.portlet.thong_tin_lien_quan.model.ThongTinLienQuan findByPrimaryKey(
        long maThongTinLienQuan)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.thong_tin_lien_quan.NoSuchThongTinLienQuanException {
        return getPersistence().findByPrimaryKey(maThongTinLienQuan);
    }

    public static com.nss.portlet.thong_tin_lien_quan.model.ThongTinLienQuan fetchByPrimaryKey(
        long maThongTinLienQuan) throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(maThongTinLienQuan);
    }

    public static java.util.List<com.nss.portlet.thong_tin_lien_quan.model.ThongTinLienQuan> findByActive(
        int active) throws com.liferay.portal.SystemException {
        return getPersistence().findByActive(active);
    }

    public static java.util.List<com.nss.portlet.thong_tin_lien_quan.model.ThongTinLienQuan> findByActive(
        int active, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByActive(active, start, end);
    }

    public static java.util.List<com.nss.portlet.thong_tin_lien_quan.model.ThongTinLienQuan> findByActive(
        int active, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByActive(active, start, end, obc);
    }

    public static com.nss.portlet.thong_tin_lien_quan.model.ThongTinLienQuan findByActive_First(
        int active, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.thong_tin_lien_quan.NoSuchThongTinLienQuanException {
        return getPersistence().findByActive_First(active, obc);
    }

    public static com.nss.portlet.thong_tin_lien_quan.model.ThongTinLienQuan findByActive_Last(
        int active, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.thong_tin_lien_quan.NoSuchThongTinLienQuanException {
        return getPersistence().findByActive_Last(active, obc);
    }

    public static com.nss.portlet.thong_tin_lien_quan.model.ThongTinLienQuan[] findByActive_PrevAndNext(
        long maThongTinLienQuan, int active,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.thong_tin_lien_quan.NoSuchThongTinLienQuanException {
        return getPersistence()
                   .findByActive_PrevAndNext(maThongTinLienQuan, active, obc);
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

    public static java.util.List<com.nss.portlet.thong_tin_lien_quan.model.ThongTinLienQuan> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.nss.portlet.thong_tin_lien_quan.model.ThongTinLienQuan> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.nss.portlet.thong_tin_lien_quan.model.ThongTinLienQuan> findAll(
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

    public static ThongTinLienQuanPersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(ThongTinLienQuanPersistence persistence) {
        _persistence = persistence;
    }
}
