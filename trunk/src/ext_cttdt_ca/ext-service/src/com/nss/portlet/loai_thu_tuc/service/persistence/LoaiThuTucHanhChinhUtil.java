package com.nss.portlet.loai_thu_tuc.service.persistence;

public class LoaiThuTucHanhChinhUtil {
    private static LoaiThuTucHanhChinhPersistence _persistence;

    public static void cacheResult(
        com.nss.portlet.loai_thu_tuc.model.LoaiThuTucHanhChinh loaiThuTucHanhChinh) {
        getPersistence().cacheResult(loaiThuTucHanhChinh);
    }

    public static void cacheResult(
        java.util.List<com.nss.portlet.loai_thu_tuc.model.LoaiThuTucHanhChinh> loaiThuTucHanhChinhs) {
        getPersistence().cacheResult(loaiThuTucHanhChinhs);
    }

    public static void clearCache() {
        getPersistence().clearCache();
    }

    public static com.nss.portlet.loai_thu_tuc.model.LoaiThuTucHanhChinh create(
        long maLoaiThuTucHanhChinh) {
        return getPersistence().create(maLoaiThuTucHanhChinh);
    }

    public static com.nss.portlet.loai_thu_tuc.model.LoaiThuTucHanhChinh remove(
        long maLoaiThuTucHanhChinh)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.loai_thu_tuc.NoSuchLoaiThuTucHanhChinhException {
        return getPersistence().remove(maLoaiThuTucHanhChinh);
    }

    public static com.nss.portlet.loai_thu_tuc.model.LoaiThuTucHanhChinh remove(
        com.nss.portlet.loai_thu_tuc.model.LoaiThuTucHanhChinh loaiThuTucHanhChinh)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(loaiThuTucHanhChinh);
    }

    /**
     * @deprecated Use <code>update(LoaiThuTucHanhChinh loaiThuTucHanhChinh, boolean merge)</code>.
     */
    public static com.nss.portlet.loai_thu_tuc.model.LoaiThuTucHanhChinh update(
        com.nss.portlet.loai_thu_tuc.model.LoaiThuTucHanhChinh loaiThuTucHanhChinh)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(loaiThuTucHanhChinh);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                loaiThuTucHanhChinh the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when loaiThuTucHanhChinh is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public static com.nss.portlet.loai_thu_tuc.model.LoaiThuTucHanhChinh update(
        com.nss.portlet.loai_thu_tuc.model.LoaiThuTucHanhChinh loaiThuTucHanhChinh,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().update(loaiThuTucHanhChinh, merge);
    }

    public static com.nss.portlet.loai_thu_tuc.model.LoaiThuTucHanhChinh updateImpl(
        com.nss.portlet.loai_thu_tuc.model.LoaiThuTucHanhChinh loaiThuTucHanhChinh,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(loaiThuTucHanhChinh, merge);
    }

    public static com.nss.portlet.loai_thu_tuc.model.LoaiThuTucHanhChinh findByPrimaryKey(
        long maLoaiThuTucHanhChinh)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.loai_thu_tuc.NoSuchLoaiThuTucHanhChinhException {
        return getPersistence().findByPrimaryKey(maLoaiThuTucHanhChinh);
    }

    public static com.nss.portlet.loai_thu_tuc.model.LoaiThuTucHanhChinh fetchByPrimaryKey(
        long maLoaiThuTucHanhChinh) throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(maLoaiThuTucHanhChinh);
    }

    public static java.util.List<com.nss.portlet.loai_thu_tuc.model.LoaiThuTucHanhChinh> findByActive(
        int active) throws com.liferay.portal.SystemException {
        return getPersistence().findByActive(active);
    }

    public static java.util.List<com.nss.portlet.loai_thu_tuc.model.LoaiThuTucHanhChinh> findByActive(
        int active, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByActive(active, start, end);
    }

    public static java.util.List<com.nss.portlet.loai_thu_tuc.model.LoaiThuTucHanhChinh> findByActive(
        int active, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByActive(active, start, end, obc);
    }

    public static com.nss.portlet.loai_thu_tuc.model.LoaiThuTucHanhChinh findByActive_First(
        int active, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.loai_thu_tuc.NoSuchLoaiThuTucHanhChinhException {
        return getPersistence().findByActive_First(active, obc);
    }

    public static com.nss.portlet.loai_thu_tuc.model.LoaiThuTucHanhChinh findByActive_Last(
        int active, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.loai_thu_tuc.NoSuchLoaiThuTucHanhChinhException {
        return getPersistence().findByActive_Last(active, obc);
    }

    public static com.nss.portlet.loai_thu_tuc.model.LoaiThuTucHanhChinh[] findByActive_PrevAndNext(
        long maLoaiThuTucHanhChinh, int active,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.loai_thu_tuc.NoSuchLoaiThuTucHanhChinhException {
        return getPersistence()
                   .findByActive_PrevAndNext(maLoaiThuTucHanhChinh, active, obc);
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

    public static java.util.List<com.nss.portlet.loai_thu_tuc.model.LoaiThuTucHanhChinh> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.nss.portlet.loai_thu_tuc.model.LoaiThuTucHanhChinh> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.nss.portlet.loai_thu_tuc.model.LoaiThuTucHanhChinh> findAll(
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

    public static LoaiThuTucHanhChinhPersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(LoaiThuTucHanhChinhPersistence persistence) {
        _persistence = persistence;
    }
}
