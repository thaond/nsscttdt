package com.nss.portlet.thu_tuc_hanh_chinh.service.persistence;

public class FileDinhKemTTHCUtil {
    private static FileDinhKemTTHCPersistence _persistence;

    public static void cacheResult(
        com.nss.portlet.thu_tuc_hanh_chinh.model.FileDinhKemTTHC fileDinhKemTTHC) {
        getPersistence().cacheResult(fileDinhKemTTHC);
    }

    public static void cacheResult(
        java.util.List<com.nss.portlet.thu_tuc_hanh_chinh.model.FileDinhKemTTHC> fileDinhKemTTHCs) {
        getPersistence().cacheResult(fileDinhKemTTHCs);
    }

    public static void clearCache() {
        getPersistence().clearCache();
    }

    public static com.nss.portlet.thu_tuc_hanh_chinh.model.FileDinhKemTTHC create(
        long maFileDinhKemTTHC) {
        return getPersistence().create(maFileDinhKemTTHC);
    }

    public static com.nss.portlet.thu_tuc_hanh_chinh.model.FileDinhKemTTHC remove(
        long maFileDinhKemTTHC)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.thu_tuc_hanh_chinh.NoSuchFileDinhKemTTHCException {
        return getPersistence().remove(maFileDinhKemTTHC);
    }

    public static com.nss.portlet.thu_tuc_hanh_chinh.model.FileDinhKemTTHC remove(
        com.nss.portlet.thu_tuc_hanh_chinh.model.FileDinhKemTTHC fileDinhKemTTHC)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(fileDinhKemTTHC);
    }

    /**
     * @deprecated Use <code>update(FileDinhKemTTHC fileDinhKemTTHC, boolean merge)</code>.
     */
    public static com.nss.portlet.thu_tuc_hanh_chinh.model.FileDinhKemTTHC update(
        com.nss.portlet.thu_tuc_hanh_chinh.model.FileDinhKemTTHC fileDinhKemTTHC)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(fileDinhKemTTHC);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                fileDinhKemTTHC the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when fileDinhKemTTHC is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public static com.nss.portlet.thu_tuc_hanh_chinh.model.FileDinhKemTTHC update(
        com.nss.portlet.thu_tuc_hanh_chinh.model.FileDinhKemTTHC fileDinhKemTTHC,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().update(fileDinhKemTTHC, merge);
    }

    public static com.nss.portlet.thu_tuc_hanh_chinh.model.FileDinhKemTTHC updateImpl(
        com.nss.portlet.thu_tuc_hanh_chinh.model.FileDinhKemTTHC fileDinhKemTTHC,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(fileDinhKemTTHC, merge);
    }

    public static com.nss.portlet.thu_tuc_hanh_chinh.model.FileDinhKemTTHC findByPrimaryKey(
        long maFileDinhKemTTHC)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.thu_tuc_hanh_chinh.NoSuchFileDinhKemTTHCException {
        return getPersistence().findByPrimaryKey(maFileDinhKemTTHC);
    }

    public static com.nss.portlet.thu_tuc_hanh_chinh.model.FileDinhKemTTHC fetchByPrimaryKey(
        long maFileDinhKemTTHC) throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(maFileDinhKemTTHC);
    }

    public static java.util.List<com.nss.portlet.thu_tuc_hanh_chinh.model.FileDinhKemTTHC> findByMaThuTucHanhChinh(
        long maThuTucHanhChinh) throws com.liferay.portal.SystemException {
        return getPersistence().findByMaThuTucHanhChinh(maThuTucHanhChinh);
    }

    public static java.util.List<com.nss.portlet.thu_tuc_hanh_chinh.model.FileDinhKemTTHC> findByMaThuTucHanhChinh(
        long maThuTucHanhChinh, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByMaThuTucHanhChinh(maThuTucHanhChinh, start, end);
    }

    public static java.util.List<com.nss.portlet.thu_tuc_hanh_chinh.model.FileDinhKemTTHC> findByMaThuTucHanhChinh(
        long maThuTucHanhChinh, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByMaThuTucHanhChinh(maThuTucHanhChinh, start, end, obc);
    }

    public static com.nss.portlet.thu_tuc_hanh_chinh.model.FileDinhKemTTHC findByMaThuTucHanhChinh_First(
        long maThuTucHanhChinh,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.thu_tuc_hanh_chinh.NoSuchFileDinhKemTTHCException {
        return getPersistence()
                   .findByMaThuTucHanhChinh_First(maThuTucHanhChinh, obc);
    }

    public static com.nss.portlet.thu_tuc_hanh_chinh.model.FileDinhKemTTHC findByMaThuTucHanhChinh_Last(
        long maThuTucHanhChinh,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.thu_tuc_hanh_chinh.NoSuchFileDinhKemTTHCException {
        return getPersistence()
                   .findByMaThuTucHanhChinh_Last(maThuTucHanhChinh, obc);
    }

    public static com.nss.portlet.thu_tuc_hanh_chinh.model.FileDinhKemTTHC[] findByMaThuTucHanhChinh_PrevAndNext(
        long maFileDinhKemTTHC, long maThuTucHanhChinh,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.thu_tuc_hanh_chinh.NoSuchFileDinhKemTTHCException {
        return getPersistence()
                   .findByMaThuTucHanhChinh_PrevAndNext(maFileDinhKemTTHC,
            maThuTucHanhChinh, obc);
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

    public static java.util.List<com.nss.portlet.thu_tuc_hanh_chinh.model.FileDinhKemTTHC> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.nss.portlet.thu_tuc_hanh_chinh.model.FileDinhKemTTHC> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.nss.portlet.thu_tuc_hanh_chinh.model.FileDinhKemTTHC> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end, obc);
    }

    public static void removeByMaThuTucHanhChinh(long maThuTucHanhChinh)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByMaThuTucHanhChinh(maThuTucHanhChinh);
    }

    public static void removeAll() throws com.liferay.portal.SystemException {
        getPersistence().removeAll();
    }

    public static int countByMaThuTucHanhChinh(long maThuTucHanhChinh)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByMaThuTucHanhChinh(maThuTucHanhChinh);
    }

    public static int countAll() throws com.liferay.portal.SystemException {
        return getPersistence().countAll();
    }

    public static FileDinhKemTTHCPersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(FileDinhKemTTHCPersistence persistence) {
        _persistence = persistence;
    }
}
