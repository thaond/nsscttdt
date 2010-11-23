package com.nss.portlet.linh_vuc_van_ban.service.persistence;

public class LinhVucVanBanUtil {
    private static LinhVucVanBanPersistence _persistence;

    public static void cacheResult(
        com.nss.portlet.linh_vuc_van_ban.model.LinhVucVanBan linhVucVanBan) {
        getPersistence().cacheResult(linhVucVanBan);
    }

    public static void cacheResult(
        java.util.List<com.nss.portlet.linh_vuc_van_ban.model.LinhVucVanBan> linhVucVanBans) {
        getPersistence().cacheResult(linhVucVanBans);
    }

    public static void clearCache() {
        getPersistence().clearCache();
    }

    public static com.nss.portlet.linh_vuc_van_ban.model.LinhVucVanBan create(
        long maLinhVucVanBan) {
        return getPersistence().create(maLinhVucVanBan);
    }

    public static com.nss.portlet.linh_vuc_van_ban.model.LinhVucVanBan remove(
        long maLinhVucVanBan)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.linh_vuc_van_ban.NoSuchLinhVucVanBanException {
        return getPersistence().remove(maLinhVucVanBan);
    }

    public static com.nss.portlet.linh_vuc_van_ban.model.LinhVucVanBan remove(
        com.nss.portlet.linh_vuc_van_ban.model.LinhVucVanBan linhVucVanBan)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(linhVucVanBan);
    }

    /**
     * @deprecated Use <code>update(LinhVucVanBan linhVucVanBan, boolean merge)</code>.
     */
    public static com.nss.portlet.linh_vuc_van_ban.model.LinhVucVanBan update(
        com.nss.portlet.linh_vuc_van_ban.model.LinhVucVanBan linhVucVanBan)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(linhVucVanBan);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                linhVucVanBan the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when linhVucVanBan is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public static com.nss.portlet.linh_vuc_van_ban.model.LinhVucVanBan update(
        com.nss.portlet.linh_vuc_van_ban.model.LinhVucVanBan linhVucVanBan,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().update(linhVucVanBan, merge);
    }

    public static com.nss.portlet.linh_vuc_van_ban.model.LinhVucVanBan updateImpl(
        com.nss.portlet.linh_vuc_van_ban.model.LinhVucVanBan linhVucVanBan,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(linhVucVanBan, merge);
    }

    public static com.nss.portlet.linh_vuc_van_ban.model.LinhVucVanBan findByPrimaryKey(
        long maLinhVucVanBan)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.linh_vuc_van_ban.NoSuchLinhVucVanBanException {
        return getPersistence().findByPrimaryKey(maLinhVucVanBan);
    }

    public static com.nss.portlet.linh_vuc_van_ban.model.LinhVucVanBan fetchByPrimaryKey(
        long maLinhVucVanBan) throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(maLinhVucVanBan);
    }

    public static java.util.List<com.nss.portlet.linh_vuc_van_ban.model.LinhVucVanBan> findByParentId(
        long parentid) throws com.liferay.portal.SystemException {
        return getPersistence().findByParentId(parentid);
    }

    public static java.util.List<com.nss.portlet.linh_vuc_van_ban.model.LinhVucVanBan> findByParentId(
        long parentid, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByParentId(parentid, start, end);
    }

    public static java.util.List<com.nss.portlet.linh_vuc_van_ban.model.LinhVucVanBan> findByParentId(
        long parentid, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByParentId(parentid, start, end, obc);
    }

    public static com.nss.portlet.linh_vuc_van_ban.model.LinhVucVanBan findByParentId_First(
        long parentid, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.linh_vuc_van_ban.NoSuchLinhVucVanBanException {
        return getPersistence().findByParentId_First(parentid, obc);
    }

    public static com.nss.portlet.linh_vuc_van_ban.model.LinhVucVanBan findByParentId_Last(
        long parentid, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.linh_vuc_van_ban.NoSuchLinhVucVanBanException {
        return getPersistence().findByParentId_Last(parentid, obc);
    }

    public static com.nss.portlet.linh_vuc_van_ban.model.LinhVucVanBan[] findByParentId_PrevAndNext(
        long maLinhVucVanBan, long parentid,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.linh_vuc_van_ban.NoSuchLinhVucVanBanException {
        return getPersistence()
                   .findByParentId_PrevAndNext(maLinhVucVanBan, parentid, obc);
    }

    public static java.util.List<com.nss.portlet.linh_vuc_van_ban.model.LinhVucVanBan> findByActive(
        int active) throws com.liferay.portal.SystemException {
        return getPersistence().findByActive(active);
    }

    public static java.util.List<com.nss.portlet.linh_vuc_van_ban.model.LinhVucVanBan> findByActive(
        int active, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByActive(active, start, end);
    }

    public static java.util.List<com.nss.portlet.linh_vuc_van_ban.model.LinhVucVanBan> findByActive(
        int active, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByActive(active, start, end, obc);
    }

    public static com.nss.portlet.linh_vuc_van_ban.model.LinhVucVanBan findByActive_First(
        int active, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.linh_vuc_van_ban.NoSuchLinhVucVanBanException {
        return getPersistence().findByActive_First(active, obc);
    }

    public static com.nss.portlet.linh_vuc_van_ban.model.LinhVucVanBan findByActive_Last(
        int active, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.linh_vuc_van_ban.NoSuchLinhVucVanBanException {
        return getPersistence().findByActive_Last(active, obc);
    }

    public static com.nss.portlet.linh_vuc_van_ban.model.LinhVucVanBan[] findByActive_PrevAndNext(
        long maLinhVucVanBan, int active,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.linh_vuc_van_ban.NoSuchLinhVucVanBanException {
        return getPersistence()
                   .findByActive_PrevAndNext(maLinhVucVanBan, active, obc);
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

    public static java.util.List<com.nss.portlet.linh_vuc_van_ban.model.LinhVucVanBan> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.nss.portlet.linh_vuc_van_ban.model.LinhVucVanBan> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.nss.portlet.linh_vuc_van_ban.model.LinhVucVanBan> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end, obc);
    }

    public static void removeByParentId(long parentid)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByParentId(parentid);
    }

    public static void removeByActive(int active)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByActive(active);
    }

    public static void removeAll() throws com.liferay.portal.SystemException {
        getPersistence().removeAll();
    }

    public static int countByParentId(long parentid)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByParentId(parentid);
    }

    public static int countByActive(int active)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByActive(active);
    }

    public static int countAll() throws com.liferay.portal.SystemException {
        return getPersistence().countAll();
    }

    public static LinhVucVanBanPersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(LinhVucVanBanPersistence persistence) {
        _persistence = persistence;
    }
}
