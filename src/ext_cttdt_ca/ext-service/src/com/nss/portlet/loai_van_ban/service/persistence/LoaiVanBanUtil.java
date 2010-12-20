package com.nss.portlet.loai_van_ban.service.persistence;

public class LoaiVanBanUtil {
    private static LoaiVanBanPersistence _persistence;

    public static void cacheResult(
        com.nss.portlet.loai_van_ban.model.LoaiVanBan loaiVanBan) {
        getPersistence().cacheResult(loaiVanBan);
    }

    public static void cacheResult(
        java.util.List<com.nss.portlet.loai_van_ban.model.LoaiVanBan> loaiVanBans) {
        getPersistence().cacheResult(loaiVanBans);
    }

    public static void clearCache() {
        getPersistence().clearCache();
    }

    public static com.nss.portlet.loai_van_ban.model.LoaiVanBan create(
        long maLoaiVanBan) {
        return getPersistence().create(maLoaiVanBan);
    }

    public static com.nss.portlet.loai_van_ban.model.LoaiVanBan remove(
        long maLoaiVanBan)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.loai_van_ban.NoSuchLoaiVanBanException {
        return getPersistence().remove(maLoaiVanBan);
    }

    public static com.nss.portlet.loai_van_ban.model.LoaiVanBan remove(
        com.nss.portlet.loai_van_ban.model.LoaiVanBan loaiVanBan)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(loaiVanBan);
    }

    /**
     * @deprecated Use <code>update(LoaiVanBan loaiVanBan, boolean merge)</code>.
     */
    public static com.nss.portlet.loai_van_ban.model.LoaiVanBan update(
        com.nss.portlet.loai_van_ban.model.LoaiVanBan loaiVanBan)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(loaiVanBan);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                loaiVanBan the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when loaiVanBan is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public static com.nss.portlet.loai_van_ban.model.LoaiVanBan update(
        com.nss.portlet.loai_van_ban.model.LoaiVanBan loaiVanBan, boolean merge)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(loaiVanBan, merge);
    }

    public static com.nss.portlet.loai_van_ban.model.LoaiVanBan updateImpl(
        com.nss.portlet.loai_van_ban.model.LoaiVanBan loaiVanBan, boolean merge)
        throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(loaiVanBan, merge);
    }

    public static com.nss.portlet.loai_van_ban.model.LoaiVanBan findByPrimaryKey(
        long maLoaiVanBan)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.loai_van_ban.NoSuchLoaiVanBanException {
        return getPersistence().findByPrimaryKey(maLoaiVanBan);
    }

    public static com.nss.portlet.loai_van_ban.model.LoaiVanBan fetchByPrimaryKey(
        long maLoaiVanBan) throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(maLoaiVanBan);
    }

    public static java.util.List<com.nss.portlet.loai_van_ban.model.LoaiVanBan> findByActive(
        int active) throws com.liferay.portal.SystemException {
        return getPersistence().findByActive(active);
    }

    public static java.util.List<com.nss.portlet.loai_van_ban.model.LoaiVanBan> findByActive(
        int active, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByActive(active, start, end);
    }

    public static java.util.List<com.nss.portlet.loai_van_ban.model.LoaiVanBan> findByActive(
        int active, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByActive(active, start, end, obc);
    }

    public static com.nss.portlet.loai_van_ban.model.LoaiVanBan findByActive_First(
        int active, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.loai_van_ban.NoSuchLoaiVanBanException {
        return getPersistence().findByActive_First(active, obc);
    }

    public static com.nss.portlet.loai_van_ban.model.LoaiVanBan findByActive_Last(
        int active, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.loai_van_ban.NoSuchLoaiVanBanException {
        return getPersistence().findByActive_Last(active, obc);
    }

    public static com.nss.portlet.loai_van_ban.model.LoaiVanBan[] findByActive_PrevAndNext(
        long maLoaiVanBan, int active,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.loai_van_ban.NoSuchLoaiVanBanException {
        return getPersistence()
                   .findByActive_PrevAndNext(maLoaiVanBan, active, obc);
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

    public static java.util.List<com.nss.portlet.loai_van_ban.model.LoaiVanBan> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.nss.portlet.loai_van_ban.model.LoaiVanBan> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.nss.portlet.loai_van_ban.model.LoaiVanBan> findAll(
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

    public static LoaiVanBanPersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(LoaiVanBanPersistence persistence) {
        _persistence = persistence;
    }
}
