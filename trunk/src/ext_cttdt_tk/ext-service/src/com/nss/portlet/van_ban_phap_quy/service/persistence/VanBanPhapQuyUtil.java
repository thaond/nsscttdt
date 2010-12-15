package com.nss.portlet.van_ban_phap_quy.service.persistence;

public class VanBanPhapQuyUtil {
    private static VanBanPhapQuyPersistence _persistence;

    public static void cacheResult(
        com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy vanBanPhapQuy) {
        getPersistence().cacheResult(vanBanPhapQuy);
    }

    public static void cacheResult(
        java.util.List<com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy> vanBanPhapQuies) {
        getPersistence().cacheResult(vanBanPhapQuies);
    }

    public static void clearCache() {
        getPersistence().clearCache();
    }

    public static com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy create(
        long maVanBanPhapQuy) {
        return getPersistence().create(maVanBanPhapQuy);
    }

    public static com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy remove(
        long maVanBanPhapQuy)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.van_ban_phap_quy.NoSuchVanBanPhapQuyException {
        return getPersistence().remove(maVanBanPhapQuy);
    }

    public static com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy remove(
        com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy vanBanPhapQuy)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(vanBanPhapQuy);
    }

    /**
     * @deprecated Use <code>update(VanBanPhapQuy vanBanPhapQuy, boolean merge)</code>.
     */
    public static com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy update(
        com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy vanBanPhapQuy)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(vanBanPhapQuy);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                vanBanPhapQuy the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when vanBanPhapQuy is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public static com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy update(
        com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy vanBanPhapQuy,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().update(vanBanPhapQuy, merge);
    }

    public static com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy updateImpl(
        com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy vanBanPhapQuy,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(vanBanPhapQuy, merge);
    }

    public static com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy findByPrimaryKey(
        long maVanBanPhapQuy)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.van_ban_phap_quy.NoSuchVanBanPhapQuyException {
        return getPersistence().findByPrimaryKey(maVanBanPhapQuy);
    }

    public static com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy fetchByPrimaryKey(
        long maVanBanPhapQuy) throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(maVanBanPhapQuy);
    }

    public static java.util.List<com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy> findByActive(
        int active) throws com.liferay.portal.SystemException {
        return getPersistence().findByActive(active);
    }

    public static java.util.List<com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy> findByActive(
        int active, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByActive(active, start, end);
    }

    public static java.util.List<com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy> findByActive(
        int active, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByActive(active, start, end, obc);
    }

    public static com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy findByActive_First(
        int active, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.van_ban_phap_quy.NoSuchVanBanPhapQuyException {
        return getPersistence().findByActive_First(active, obc);
    }

    public static com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy findByActive_Last(
        int active, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.van_ban_phap_quy.NoSuchVanBanPhapQuyException {
        return getPersistence().findByActive_Last(active, obc);
    }

    public static com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy[] findByActive_PrevAndNext(
        long maVanBanPhapQuy, int active,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.van_ban_phap_quy.NoSuchVanBanPhapQuyException {
        return getPersistence()
                   .findByActive_PrevAndNext(maVanBanPhapQuy, active, obc);
    }

    public static java.util.List<com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy> findByMaLoaiVanBan(
        long maLoaiVanBan) throws com.liferay.portal.SystemException {
        return getPersistence().findByMaLoaiVanBan(maLoaiVanBan);
    }

    public static java.util.List<com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy> findByMaLoaiVanBan(
        long maLoaiVanBan, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByMaLoaiVanBan(maLoaiVanBan, start, end);
    }

    public static java.util.List<com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy> findByMaLoaiVanBan(
        long maLoaiVanBan, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByMaLoaiVanBan(maLoaiVanBan, start, end, obc);
    }

    public static com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy findByMaLoaiVanBan_First(
        long maLoaiVanBan, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.van_ban_phap_quy.NoSuchVanBanPhapQuyException {
        return getPersistence().findByMaLoaiVanBan_First(maLoaiVanBan, obc);
    }

    public static com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy findByMaLoaiVanBan_Last(
        long maLoaiVanBan, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.van_ban_phap_quy.NoSuchVanBanPhapQuyException {
        return getPersistence().findByMaLoaiVanBan_Last(maLoaiVanBan, obc);
    }

    public static com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy[] findByMaLoaiVanBan_PrevAndNext(
        long maVanBanPhapQuy, long maLoaiVanBan,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.van_ban_phap_quy.NoSuchVanBanPhapQuyException {
        return getPersistence()
                   .findByMaLoaiVanBan_PrevAndNext(maVanBanPhapQuy,
            maLoaiVanBan, obc);
    }

    public static java.util.List<com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy> findByMaLinhVucVanBan(
        long maLinhVucVanBan) throws com.liferay.portal.SystemException {
        return getPersistence().findByMaLinhVucVanBan(maLinhVucVanBan);
    }

    public static java.util.List<com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy> findByMaLinhVucVanBan(
        long maLinhVucVanBan, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByMaLinhVucVanBan(maLinhVucVanBan, start, end);
    }

    public static java.util.List<com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy> findByMaLinhVucVanBan(
        long maLinhVucVanBan, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByMaLinhVucVanBan(maLinhVucVanBan, start, end, obc);
    }

    public static com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy findByMaLinhVucVanBan_First(
        long maLinhVucVanBan,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.van_ban_phap_quy.NoSuchVanBanPhapQuyException {
        return getPersistence().findByMaLinhVucVanBan_First(maLinhVucVanBan, obc);
    }

    public static com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy findByMaLinhVucVanBan_Last(
        long maLinhVucVanBan,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.van_ban_phap_quy.NoSuchVanBanPhapQuyException {
        return getPersistence().findByMaLinhVucVanBan_Last(maLinhVucVanBan, obc);
    }

    public static com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy[] findByMaLinhVucVanBan_PrevAndNext(
        long maVanBanPhapQuy, long maLinhVucVanBan,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.van_ban_phap_quy.NoSuchVanBanPhapQuyException {
        return getPersistence()
                   .findByMaLinhVucVanBan_PrevAndNext(maVanBanPhapQuy,
            maLinhVucVanBan, obc);
    }

    public static java.util.List<com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy> findByMaCoQuanBanHanh(
        long maCoQuanBanHanh) throws com.liferay.portal.SystemException {
        return getPersistence().findByMaCoQuanBanHanh(maCoQuanBanHanh);
    }

    public static java.util.List<com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy> findByMaCoQuanBanHanh(
        long maCoQuanBanHanh, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByMaCoQuanBanHanh(maCoQuanBanHanh, start, end);
    }

    public static java.util.List<com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy> findByMaCoQuanBanHanh(
        long maCoQuanBanHanh, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByMaCoQuanBanHanh(maCoQuanBanHanh, start, end, obc);
    }

    public static com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy findByMaCoQuanBanHanh_First(
        long maCoQuanBanHanh,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.van_ban_phap_quy.NoSuchVanBanPhapQuyException {
        return getPersistence().findByMaCoQuanBanHanh_First(maCoQuanBanHanh, obc);
    }

    public static com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy findByMaCoQuanBanHanh_Last(
        long maCoQuanBanHanh,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.van_ban_phap_quy.NoSuchVanBanPhapQuyException {
        return getPersistence().findByMaCoQuanBanHanh_Last(maCoQuanBanHanh, obc);
    }

    public static com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy[] findByMaCoQuanBanHanh_PrevAndNext(
        long maVanBanPhapQuy, long maCoQuanBanHanh,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.van_ban_phap_quy.NoSuchVanBanPhapQuyException {
        return getPersistence()
                   .findByMaCoQuanBanHanh_PrevAndNext(maVanBanPhapQuy,
            maCoQuanBanHanh, obc);
    }

    public static java.util.List<com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy> findByCompanyid(
        long companyid) throws com.liferay.portal.SystemException {
        return getPersistence().findByCompanyid(companyid);
    }

    public static java.util.List<com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy> findByCompanyid(
        long companyid, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByCompanyid(companyid, start, end);
    }

    public static java.util.List<com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy> findByCompanyid(
        long companyid, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByCompanyid(companyid, start, end, obc);
    }

    public static com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy findByCompanyid_First(
        long companyid, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.van_ban_phap_quy.NoSuchVanBanPhapQuyException {
        return getPersistence().findByCompanyid_First(companyid, obc);
    }

    public static com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy findByCompanyid_Last(
        long companyid, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.van_ban_phap_quy.NoSuchVanBanPhapQuyException {
        return getPersistence().findByCompanyid_Last(companyid, obc);
    }

    public static com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy[] findByCompanyid_PrevAndNext(
        long maVanBanPhapQuy, long companyid,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.van_ban_phap_quy.NoSuchVanBanPhapQuyException {
        return getPersistence()
                   .findByCompanyid_PrevAndNext(maVanBanPhapQuy, companyid, obc);
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

    public static java.util.List<com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end, obc);
    }

    public static void removeByActive(int active)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByActive(active);
    }

    public static void removeByMaLoaiVanBan(long maLoaiVanBan)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByMaLoaiVanBan(maLoaiVanBan);
    }

    public static void removeByMaLinhVucVanBan(long maLinhVucVanBan)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByMaLinhVucVanBan(maLinhVucVanBan);
    }

    public static void removeByMaCoQuanBanHanh(long maCoQuanBanHanh)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByMaCoQuanBanHanh(maCoQuanBanHanh);
    }

    public static void removeByCompanyid(long companyid)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByCompanyid(companyid);
    }

    public static void removeAll() throws com.liferay.portal.SystemException {
        getPersistence().removeAll();
    }

    public static int countByActive(int active)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByActive(active);
    }

    public static int countByMaLoaiVanBan(long maLoaiVanBan)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByMaLoaiVanBan(maLoaiVanBan);
    }

    public static int countByMaLinhVucVanBan(long maLinhVucVanBan)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByMaLinhVucVanBan(maLinhVucVanBan);
    }

    public static int countByMaCoQuanBanHanh(long maCoQuanBanHanh)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByMaCoQuanBanHanh(maCoQuanBanHanh);
    }

    public static int countByCompanyid(long companyid)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByCompanyid(companyid);
    }

    public static int countAll() throws com.liferay.portal.SystemException {
        return getPersistence().countAll();
    }

    public static VanBanPhapQuyPersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(VanBanPhapQuyPersistence persistence) {
        _persistence = persistence;
    }
}
