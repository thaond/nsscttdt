package com.nss.portlet.thu_tuc_hanh_chinh.service.persistence;

public class ThuTucHanhChinhUtil {
    private static ThuTucHanhChinhPersistence _persistence;

    public static void cacheResult(
        com.nss.portlet.thu_tuc_hanh_chinh.model.ThuTucHanhChinh thuTucHanhChinh) {
        getPersistence().cacheResult(thuTucHanhChinh);
    }

    public static void cacheResult(
        java.util.List<com.nss.portlet.thu_tuc_hanh_chinh.model.ThuTucHanhChinh> thuTucHanhChinhs) {
        getPersistence().cacheResult(thuTucHanhChinhs);
    }

    public static void clearCache() {
        getPersistence().clearCache();
    }

    public static com.nss.portlet.thu_tuc_hanh_chinh.model.ThuTucHanhChinh create(
        long maThuTucHanhChinh) {
        return getPersistence().create(maThuTucHanhChinh);
    }

    public static com.nss.portlet.thu_tuc_hanh_chinh.model.ThuTucHanhChinh remove(
        long maThuTucHanhChinh)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.thu_tuc_hanh_chinh.NoSuchThuTucHanhChinhException {
        return getPersistence().remove(maThuTucHanhChinh);
    }

    public static com.nss.portlet.thu_tuc_hanh_chinh.model.ThuTucHanhChinh remove(
        com.nss.portlet.thu_tuc_hanh_chinh.model.ThuTucHanhChinh thuTucHanhChinh)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(thuTucHanhChinh);
    }

    /**
     * @deprecated Use <code>update(ThuTucHanhChinh thuTucHanhChinh, boolean merge)</code>.
     */
    public static com.nss.portlet.thu_tuc_hanh_chinh.model.ThuTucHanhChinh update(
        com.nss.portlet.thu_tuc_hanh_chinh.model.ThuTucHanhChinh thuTucHanhChinh)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(thuTucHanhChinh);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                thuTucHanhChinh the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when thuTucHanhChinh is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public static com.nss.portlet.thu_tuc_hanh_chinh.model.ThuTucHanhChinh update(
        com.nss.portlet.thu_tuc_hanh_chinh.model.ThuTucHanhChinh thuTucHanhChinh,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().update(thuTucHanhChinh, merge);
    }

    public static com.nss.portlet.thu_tuc_hanh_chinh.model.ThuTucHanhChinh updateImpl(
        com.nss.portlet.thu_tuc_hanh_chinh.model.ThuTucHanhChinh thuTucHanhChinh,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(thuTucHanhChinh, merge);
    }

    public static com.nss.portlet.thu_tuc_hanh_chinh.model.ThuTucHanhChinh findByPrimaryKey(
        long maThuTucHanhChinh)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.thu_tuc_hanh_chinh.NoSuchThuTucHanhChinhException {
        return getPersistence().findByPrimaryKey(maThuTucHanhChinh);
    }

    public static com.nss.portlet.thu_tuc_hanh_chinh.model.ThuTucHanhChinh fetchByPrimaryKey(
        long maThuTucHanhChinh) throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(maThuTucHanhChinh);
    }

    public static java.util.List<com.nss.portlet.thu_tuc_hanh_chinh.model.ThuTucHanhChinh> findByActive(
        int active) throws com.liferay.portal.SystemException {
        return getPersistence().findByActive(active);
    }

    public static java.util.List<com.nss.portlet.thu_tuc_hanh_chinh.model.ThuTucHanhChinh> findByActive(
        int active, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByActive(active, start, end);
    }

    public static java.util.List<com.nss.portlet.thu_tuc_hanh_chinh.model.ThuTucHanhChinh> findByActive(
        int active, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByActive(active, start, end, obc);
    }

    public static com.nss.portlet.thu_tuc_hanh_chinh.model.ThuTucHanhChinh findByActive_First(
        int active, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.thu_tuc_hanh_chinh.NoSuchThuTucHanhChinhException {
        return getPersistence().findByActive_First(active, obc);
    }

    public static com.nss.portlet.thu_tuc_hanh_chinh.model.ThuTucHanhChinh findByActive_Last(
        int active, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.thu_tuc_hanh_chinh.NoSuchThuTucHanhChinhException {
        return getPersistence().findByActive_Last(active, obc);
    }

    public static com.nss.portlet.thu_tuc_hanh_chinh.model.ThuTucHanhChinh[] findByActive_PrevAndNext(
        long maThuTucHanhChinh, int active,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.thu_tuc_hanh_chinh.NoSuchThuTucHanhChinhException {
        return getPersistence()
                   .findByActive_PrevAndNext(maThuTucHanhChinh, active, obc);
    }

    public static java.util.List<com.nss.portlet.thu_tuc_hanh_chinh.model.ThuTucHanhChinh> findByMaLinhVucThuTucHanhChinh(
        long maLinhVucThuTucHanhChinh)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByMaLinhVucThuTucHanhChinh(maLinhVucThuTucHanhChinh);
    }

    public static java.util.List<com.nss.portlet.thu_tuc_hanh_chinh.model.ThuTucHanhChinh> findByMaLinhVucThuTucHanhChinh(
        long maLinhVucThuTucHanhChinh, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByMaLinhVucThuTucHanhChinh(maLinhVucThuTucHanhChinh,
            start, end);
    }

    public static java.util.List<com.nss.portlet.thu_tuc_hanh_chinh.model.ThuTucHanhChinh> findByMaLinhVucThuTucHanhChinh(
        long maLinhVucThuTucHanhChinh, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByMaLinhVucThuTucHanhChinh(maLinhVucThuTucHanhChinh,
            start, end, obc);
    }

    public static com.nss.portlet.thu_tuc_hanh_chinh.model.ThuTucHanhChinh findByMaLinhVucThuTucHanhChinh_First(
        long maLinhVucThuTucHanhChinh,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.thu_tuc_hanh_chinh.NoSuchThuTucHanhChinhException {
        return getPersistence()
                   .findByMaLinhVucThuTucHanhChinh_First(maLinhVucThuTucHanhChinh,
            obc);
    }

    public static com.nss.portlet.thu_tuc_hanh_chinh.model.ThuTucHanhChinh findByMaLinhVucThuTucHanhChinh_Last(
        long maLinhVucThuTucHanhChinh,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.thu_tuc_hanh_chinh.NoSuchThuTucHanhChinhException {
        return getPersistence()
                   .findByMaLinhVucThuTucHanhChinh_Last(maLinhVucThuTucHanhChinh,
            obc);
    }

    public static com.nss.portlet.thu_tuc_hanh_chinh.model.ThuTucHanhChinh[] findByMaLinhVucThuTucHanhChinh_PrevAndNext(
        long maThuTucHanhChinh, long maLinhVucThuTucHanhChinh,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.thu_tuc_hanh_chinh.NoSuchThuTucHanhChinhException {
        return getPersistence()
                   .findByMaLinhVucThuTucHanhChinh_PrevAndNext(maThuTucHanhChinh,
            maLinhVucThuTucHanhChinh, obc);
    }

    public static java.util.List<com.nss.portlet.thu_tuc_hanh_chinh.model.ThuTucHanhChinh> findByMaDonViThuTucHanhChinh(
        long maDonViThuTucHanhChinh) throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByMaDonViThuTucHanhChinh(maDonViThuTucHanhChinh);
    }

    public static java.util.List<com.nss.portlet.thu_tuc_hanh_chinh.model.ThuTucHanhChinh> findByMaDonViThuTucHanhChinh(
        long maDonViThuTucHanhChinh, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByMaDonViThuTucHanhChinh(maDonViThuTucHanhChinh, start,
            end);
    }

    public static java.util.List<com.nss.portlet.thu_tuc_hanh_chinh.model.ThuTucHanhChinh> findByMaDonViThuTucHanhChinh(
        long maDonViThuTucHanhChinh, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByMaDonViThuTucHanhChinh(maDonViThuTucHanhChinh, start,
            end, obc);
    }

    public static com.nss.portlet.thu_tuc_hanh_chinh.model.ThuTucHanhChinh findByMaDonViThuTucHanhChinh_First(
        long maDonViThuTucHanhChinh,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.thu_tuc_hanh_chinh.NoSuchThuTucHanhChinhException {
        return getPersistence()
                   .findByMaDonViThuTucHanhChinh_First(maDonViThuTucHanhChinh,
            obc);
    }

    public static com.nss.portlet.thu_tuc_hanh_chinh.model.ThuTucHanhChinh findByMaDonViThuTucHanhChinh_Last(
        long maDonViThuTucHanhChinh,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.thu_tuc_hanh_chinh.NoSuchThuTucHanhChinhException {
        return getPersistence()
                   .findByMaDonViThuTucHanhChinh_Last(maDonViThuTucHanhChinh,
            obc);
    }

    public static com.nss.portlet.thu_tuc_hanh_chinh.model.ThuTucHanhChinh[] findByMaDonViThuTucHanhChinh_PrevAndNext(
        long maThuTucHanhChinh, long maDonViThuTucHanhChinh,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.thu_tuc_hanh_chinh.NoSuchThuTucHanhChinhException {
        return getPersistence()
                   .findByMaDonViThuTucHanhChinh_PrevAndNext(maThuTucHanhChinh,
            maDonViThuTucHanhChinh, obc);
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

    public static java.util.List<com.nss.portlet.thu_tuc_hanh_chinh.model.ThuTucHanhChinh> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.nss.portlet.thu_tuc_hanh_chinh.model.ThuTucHanhChinh> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.nss.portlet.thu_tuc_hanh_chinh.model.ThuTucHanhChinh> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end, obc);
    }

    public static void removeByActive(int active)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByActive(active);
    }

    public static void removeByMaLinhVucThuTucHanhChinh(
        long maLinhVucThuTucHanhChinh)
        throws com.liferay.portal.SystemException {
        getPersistence()
            .removeByMaLinhVucThuTucHanhChinh(maLinhVucThuTucHanhChinh);
    }

    public static void removeByMaDonViThuTucHanhChinh(
        long maDonViThuTucHanhChinh) throws com.liferay.portal.SystemException {
        getPersistence().removeByMaDonViThuTucHanhChinh(maDonViThuTucHanhChinh);
    }

    public static void removeAll() throws com.liferay.portal.SystemException {
        getPersistence().removeAll();
    }

    public static int countByActive(int active)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByActive(active);
    }

    public static int countByMaLinhVucThuTucHanhChinh(
        long maLinhVucThuTucHanhChinh)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .countByMaLinhVucThuTucHanhChinh(maLinhVucThuTucHanhChinh);
    }

    public static int countByMaDonViThuTucHanhChinh(long maDonViThuTucHanhChinh)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .countByMaDonViThuTucHanhChinh(maDonViThuTucHanhChinh);
    }

    public static int countAll() throws com.liferay.portal.SystemException {
        return getPersistence().countAll();
    }

    public static ThuTucHanhChinhPersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(ThuTucHanhChinhPersistence persistence) {
        _persistence = persistence;
    }
}
