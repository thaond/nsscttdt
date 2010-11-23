package com.nss.portlet.linh_vuc_thu_tuc.service.persistence;

public class LinhVucThuTucHanhChinhUtil {
    private static LinhVucThuTucHanhChinhPersistence _persistence;

    public static void cacheResult(
        com.nss.portlet.linh_vuc_thu_tuc.model.LinhVucThuTucHanhChinh linhVucThuTucHanhChinh) {
        getPersistence().cacheResult(linhVucThuTucHanhChinh);
    }

    public static void cacheResult(
        java.util.List<com.nss.portlet.linh_vuc_thu_tuc.model.LinhVucThuTucHanhChinh> linhVucThuTucHanhChinhs) {
        getPersistence().cacheResult(linhVucThuTucHanhChinhs);
    }

    public static void clearCache() {
        getPersistence().clearCache();
    }

    public static com.nss.portlet.linh_vuc_thu_tuc.model.LinhVucThuTucHanhChinh create(
        long maLinhVucThuTucHanhChinh) {
        return getPersistence().create(maLinhVucThuTucHanhChinh);
    }

    public static com.nss.portlet.linh_vuc_thu_tuc.model.LinhVucThuTucHanhChinh remove(
        long maLinhVucThuTucHanhChinh)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.linh_vuc_thu_tuc.NoSuchLinhVucThuTucHanhChinhException {
        return getPersistence().remove(maLinhVucThuTucHanhChinh);
    }

    public static com.nss.portlet.linh_vuc_thu_tuc.model.LinhVucThuTucHanhChinh remove(
        com.nss.portlet.linh_vuc_thu_tuc.model.LinhVucThuTucHanhChinh linhVucThuTucHanhChinh)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(linhVucThuTucHanhChinh);
    }

    /**
     * @deprecated Use <code>update(LinhVucThuTucHanhChinh linhVucThuTucHanhChinh, boolean merge)</code>.
     */
    public static com.nss.portlet.linh_vuc_thu_tuc.model.LinhVucThuTucHanhChinh update(
        com.nss.portlet.linh_vuc_thu_tuc.model.LinhVucThuTucHanhChinh linhVucThuTucHanhChinh)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(linhVucThuTucHanhChinh);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                linhVucThuTucHanhChinh the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when linhVucThuTucHanhChinh is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public static com.nss.portlet.linh_vuc_thu_tuc.model.LinhVucThuTucHanhChinh update(
        com.nss.portlet.linh_vuc_thu_tuc.model.LinhVucThuTucHanhChinh linhVucThuTucHanhChinh,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().update(linhVucThuTucHanhChinh, merge);
    }

    public static com.nss.portlet.linh_vuc_thu_tuc.model.LinhVucThuTucHanhChinh updateImpl(
        com.nss.portlet.linh_vuc_thu_tuc.model.LinhVucThuTucHanhChinh linhVucThuTucHanhChinh,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(linhVucThuTucHanhChinh, merge);
    }

    public static com.nss.portlet.linh_vuc_thu_tuc.model.LinhVucThuTucHanhChinh findByPrimaryKey(
        long maLinhVucThuTucHanhChinh)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.linh_vuc_thu_tuc.NoSuchLinhVucThuTucHanhChinhException {
        return getPersistence().findByPrimaryKey(maLinhVucThuTucHanhChinh);
    }

    public static com.nss.portlet.linh_vuc_thu_tuc.model.LinhVucThuTucHanhChinh fetchByPrimaryKey(
        long maLinhVucThuTucHanhChinh)
        throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(maLinhVucThuTucHanhChinh);
    }

    public static java.util.List<com.nss.portlet.linh_vuc_thu_tuc.model.LinhVucThuTucHanhChinh> findByActive(
        int active) throws com.liferay.portal.SystemException {
        return getPersistence().findByActive(active);
    }

    public static java.util.List<com.nss.portlet.linh_vuc_thu_tuc.model.LinhVucThuTucHanhChinh> findByActive(
        int active, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByActive(active, start, end);
    }

    public static java.util.List<com.nss.portlet.linh_vuc_thu_tuc.model.LinhVucThuTucHanhChinh> findByActive(
        int active, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByActive(active, start, end, obc);
    }

    public static com.nss.portlet.linh_vuc_thu_tuc.model.LinhVucThuTucHanhChinh findByActive_First(
        int active, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.linh_vuc_thu_tuc.NoSuchLinhVucThuTucHanhChinhException {
        return getPersistence().findByActive_First(active, obc);
    }

    public static com.nss.portlet.linh_vuc_thu_tuc.model.LinhVucThuTucHanhChinh findByActive_Last(
        int active, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.linh_vuc_thu_tuc.NoSuchLinhVucThuTucHanhChinhException {
        return getPersistence().findByActive_Last(active, obc);
    }

    public static com.nss.portlet.linh_vuc_thu_tuc.model.LinhVucThuTucHanhChinh[] findByActive_PrevAndNext(
        long maLinhVucThuTucHanhChinh, int active,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.linh_vuc_thu_tuc.NoSuchLinhVucThuTucHanhChinhException {
        return getPersistence()
                   .findByActive_PrevAndNext(maLinhVucThuTucHanhChinh, active,
            obc);
    }

    public static java.util.List<com.nss.portlet.linh_vuc_thu_tuc.model.LinhVucThuTucHanhChinh> findByMaLoaiThuTucHanhChinh(
        long maLoaiThuTucHanhChinh) throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByMaLoaiThuTucHanhChinh(maLoaiThuTucHanhChinh);
    }

    public static java.util.List<com.nss.portlet.linh_vuc_thu_tuc.model.LinhVucThuTucHanhChinh> findByMaLoaiThuTucHanhChinh(
        long maLoaiThuTucHanhChinh, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByMaLoaiThuTucHanhChinh(maLoaiThuTucHanhChinh, start,
            end);
    }

    public static java.util.List<com.nss.portlet.linh_vuc_thu_tuc.model.LinhVucThuTucHanhChinh> findByMaLoaiThuTucHanhChinh(
        long maLoaiThuTucHanhChinh, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByMaLoaiThuTucHanhChinh(maLoaiThuTucHanhChinh, start,
            end, obc);
    }

    public static com.nss.portlet.linh_vuc_thu_tuc.model.LinhVucThuTucHanhChinh findByMaLoaiThuTucHanhChinh_First(
        long maLoaiThuTucHanhChinh,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.linh_vuc_thu_tuc.NoSuchLinhVucThuTucHanhChinhException {
        return getPersistence()
                   .findByMaLoaiThuTucHanhChinh_First(maLoaiThuTucHanhChinh, obc);
    }

    public static com.nss.portlet.linh_vuc_thu_tuc.model.LinhVucThuTucHanhChinh findByMaLoaiThuTucHanhChinh_Last(
        long maLoaiThuTucHanhChinh,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.linh_vuc_thu_tuc.NoSuchLinhVucThuTucHanhChinhException {
        return getPersistence()
                   .findByMaLoaiThuTucHanhChinh_Last(maLoaiThuTucHanhChinh, obc);
    }

    public static com.nss.portlet.linh_vuc_thu_tuc.model.LinhVucThuTucHanhChinh[] findByMaLoaiThuTucHanhChinh_PrevAndNext(
        long maLinhVucThuTucHanhChinh, long maLoaiThuTucHanhChinh,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.linh_vuc_thu_tuc.NoSuchLinhVucThuTucHanhChinhException {
        return getPersistence()
                   .findByMaLoaiThuTucHanhChinh_PrevAndNext(maLinhVucThuTucHanhChinh,
            maLoaiThuTucHanhChinh, obc);
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

    public static java.util.List<com.nss.portlet.linh_vuc_thu_tuc.model.LinhVucThuTucHanhChinh> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.nss.portlet.linh_vuc_thu_tuc.model.LinhVucThuTucHanhChinh> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.nss.portlet.linh_vuc_thu_tuc.model.LinhVucThuTucHanhChinh> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end, obc);
    }

    public static void removeByActive(int active)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByActive(active);
    }

    public static void removeByMaLoaiThuTucHanhChinh(long maLoaiThuTucHanhChinh)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByMaLoaiThuTucHanhChinh(maLoaiThuTucHanhChinh);
    }

    public static void removeAll() throws com.liferay.portal.SystemException {
        getPersistence().removeAll();
    }

    public static int countByActive(int active)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByActive(active);
    }

    public static int countByMaLoaiThuTucHanhChinh(long maLoaiThuTucHanhChinh)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .countByMaLoaiThuTucHanhChinh(maLoaiThuTucHanhChinh);
    }

    public static int countAll() throws com.liferay.portal.SystemException {
        return getPersistence().countAll();
    }

    public static LinhVucThuTucHanhChinhPersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(LinhVucThuTucHanhChinhPersistence persistence) {
        _persistence = persistence;
    }
}
