package com.nss.portlet.van_ban_phap_quy.service.persistence;

public class FileDinhKemUtil {
    private static FileDinhKemPersistence _persistence;

    public static void cacheResult(
        com.nss.portlet.van_ban_phap_quy.model.FileDinhKem fileDinhKem) {
        getPersistence().cacheResult(fileDinhKem);
    }

    public static void cacheResult(
        java.util.List<com.nss.portlet.van_ban_phap_quy.model.FileDinhKem> fileDinhKems) {
        getPersistence().cacheResult(fileDinhKems);
    }

    public static void clearCache() {
        getPersistence().clearCache();
    }

    public static com.nss.portlet.van_ban_phap_quy.model.FileDinhKem create(
        long maFileDinhKem) {
        return getPersistence().create(maFileDinhKem);
    }

    public static com.nss.portlet.van_ban_phap_quy.model.FileDinhKem remove(
        long maFileDinhKem)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.van_ban_phap_quy.NoSuchFileDinhKemException {
        return getPersistence().remove(maFileDinhKem);
    }

    public static com.nss.portlet.van_ban_phap_quy.model.FileDinhKem remove(
        com.nss.portlet.van_ban_phap_quy.model.FileDinhKem fileDinhKem)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(fileDinhKem);
    }

    /**
     * @deprecated Use <code>update(FileDinhKem fileDinhKem, boolean merge)</code>.
     */
    public static com.nss.portlet.van_ban_phap_quy.model.FileDinhKem update(
        com.nss.portlet.van_ban_phap_quy.model.FileDinhKem fileDinhKem)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(fileDinhKem);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                fileDinhKem the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when fileDinhKem is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public static com.nss.portlet.van_ban_phap_quy.model.FileDinhKem update(
        com.nss.portlet.van_ban_phap_quy.model.FileDinhKem fileDinhKem,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().update(fileDinhKem, merge);
    }

    public static com.nss.portlet.van_ban_phap_quy.model.FileDinhKem updateImpl(
        com.nss.portlet.van_ban_phap_quy.model.FileDinhKem fileDinhKem,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(fileDinhKem, merge);
    }

    public static com.nss.portlet.van_ban_phap_quy.model.FileDinhKem findByPrimaryKey(
        long maFileDinhKem)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.van_ban_phap_quy.NoSuchFileDinhKemException {
        return getPersistence().findByPrimaryKey(maFileDinhKem);
    }

    public static com.nss.portlet.van_ban_phap_quy.model.FileDinhKem fetchByPrimaryKey(
        long maFileDinhKem) throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(maFileDinhKem);
    }

    public static java.util.List<com.nss.portlet.van_ban_phap_quy.model.FileDinhKem> findBymaVanBanPhapQuy_PhienBan(
        long maVanBanPhapQuy, int phienBan)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findBymaVanBanPhapQuy_PhienBan(maVanBanPhapQuy, phienBan);
    }

    public static java.util.List<com.nss.portlet.van_ban_phap_quy.model.FileDinhKem> findBymaVanBanPhapQuy_PhienBan(
        long maVanBanPhapQuy, int phienBan, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findBymaVanBanPhapQuy_PhienBan(maVanBanPhapQuy, phienBan,
            start, end);
    }

    public static java.util.List<com.nss.portlet.van_ban_phap_quy.model.FileDinhKem> findBymaVanBanPhapQuy_PhienBan(
        long maVanBanPhapQuy, int phienBan, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findBymaVanBanPhapQuy_PhienBan(maVanBanPhapQuy, phienBan,
            start, end, obc);
    }

    public static com.nss.portlet.van_ban_phap_quy.model.FileDinhKem findBymaVanBanPhapQuy_PhienBan_First(
        long maVanBanPhapQuy, int phienBan,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.van_ban_phap_quy.NoSuchFileDinhKemException {
        return getPersistence()
                   .findBymaVanBanPhapQuy_PhienBan_First(maVanBanPhapQuy,
            phienBan, obc);
    }

    public static com.nss.portlet.van_ban_phap_quy.model.FileDinhKem findBymaVanBanPhapQuy_PhienBan_Last(
        long maVanBanPhapQuy, int phienBan,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.van_ban_phap_quy.NoSuchFileDinhKemException {
        return getPersistence()
                   .findBymaVanBanPhapQuy_PhienBan_Last(maVanBanPhapQuy,
            phienBan, obc);
    }

    public static com.nss.portlet.van_ban_phap_quy.model.FileDinhKem[] findBymaVanBanPhapQuy_PhienBan_PrevAndNext(
        long maFileDinhKem, long maVanBanPhapQuy, int phienBan,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.van_ban_phap_quy.NoSuchFileDinhKemException {
        return getPersistence()
                   .findBymaVanBanPhapQuy_PhienBan_PrevAndNext(maFileDinhKem,
            maVanBanPhapQuy, phienBan, obc);
    }

    public static java.util.List<com.nss.portlet.van_ban_phap_quy.model.FileDinhKem> findBymaVanBanPhapQuy(
        long maVanBanPhapQuy) throws com.liferay.portal.SystemException {
        return getPersistence().findBymaVanBanPhapQuy(maVanBanPhapQuy);
    }

    public static java.util.List<com.nss.portlet.van_ban_phap_quy.model.FileDinhKem> findBymaVanBanPhapQuy(
        long maVanBanPhapQuy, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findBymaVanBanPhapQuy(maVanBanPhapQuy, start, end);
    }

    public static java.util.List<com.nss.portlet.van_ban_phap_quy.model.FileDinhKem> findBymaVanBanPhapQuy(
        long maVanBanPhapQuy, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findBymaVanBanPhapQuy(maVanBanPhapQuy, start, end, obc);
    }

    public static com.nss.portlet.van_ban_phap_quy.model.FileDinhKem findBymaVanBanPhapQuy_First(
        long maVanBanPhapQuy,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.van_ban_phap_quy.NoSuchFileDinhKemException {
        return getPersistence().findBymaVanBanPhapQuy_First(maVanBanPhapQuy, obc);
    }

    public static com.nss.portlet.van_ban_phap_quy.model.FileDinhKem findBymaVanBanPhapQuy_Last(
        long maVanBanPhapQuy,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.van_ban_phap_quy.NoSuchFileDinhKemException {
        return getPersistence().findBymaVanBanPhapQuy_Last(maVanBanPhapQuy, obc);
    }

    public static com.nss.portlet.van_ban_phap_quy.model.FileDinhKem[] findBymaVanBanPhapQuy_PrevAndNext(
        long maFileDinhKem, long maVanBanPhapQuy,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.van_ban_phap_quy.NoSuchFileDinhKemException {
        return getPersistence()
                   .findBymaVanBanPhapQuy_PrevAndNext(maFileDinhKem,
            maVanBanPhapQuy, obc);
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

    public static java.util.List<com.nss.portlet.van_ban_phap_quy.model.FileDinhKem> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.nss.portlet.van_ban_phap_quy.model.FileDinhKem> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.nss.portlet.van_ban_phap_quy.model.FileDinhKem> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end, obc);
    }

    public static void removeBymaVanBanPhapQuy_PhienBan(long maVanBanPhapQuy,
        int phienBan) throws com.liferay.portal.SystemException {
        getPersistence()
            .removeBymaVanBanPhapQuy_PhienBan(maVanBanPhapQuy, phienBan);
    }

    public static void removeBymaVanBanPhapQuy(long maVanBanPhapQuy)
        throws com.liferay.portal.SystemException {
        getPersistence().removeBymaVanBanPhapQuy(maVanBanPhapQuy);
    }

    public static void removeAll() throws com.liferay.portal.SystemException {
        getPersistence().removeAll();
    }

    public static int countBymaVanBanPhapQuy_PhienBan(long maVanBanPhapQuy,
        int phienBan) throws com.liferay.portal.SystemException {
        return getPersistence()
                   .countBymaVanBanPhapQuy_PhienBan(maVanBanPhapQuy, phienBan);
    }

    public static int countBymaVanBanPhapQuy(long maVanBanPhapQuy)
        throws com.liferay.portal.SystemException {
        return getPersistence().countBymaVanBanPhapQuy(maVanBanPhapQuy);
    }

    public static int countAll() throws com.liferay.portal.SystemException {
        return getPersistence().countAll();
    }

    public static FileDinhKemPersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(FileDinhKemPersistence persistence) {
        _persistence = persistence;
    }
}
