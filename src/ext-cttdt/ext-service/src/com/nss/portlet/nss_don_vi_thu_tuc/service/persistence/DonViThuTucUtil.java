package com.nss.portlet.nss_don_vi_thu_tuc.service.persistence;

public class DonViThuTucUtil {
    private static DonViThuTucPersistence _persistence;

    public static void cacheResult(
        com.nss.portlet.nss_don_vi_thu_tuc.model.DonViThuTuc donViThuTuc) {
        getPersistence().cacheResult(donViThuTuc);
    }

    public static void cacheResult(
        java.util.List<com.nss.portlet.nss_don_vi_thu_tuc.model.DonViThuTuc> donViThuTucs) {
        getPersistence().cacheResult(donViThuTucs);
    }

    public static void clearCache() {
        getPersistence().clearCache();
    }

    public static com.nss.portlet.nss_don_vi_thu_tuc.model.DonViThuTuc create(
        long maDonViThuTuc) {
        return getPersistence().create(maDonViThuTuc);
    }

    public static com.nss.portlet.nss_don_vi_thu_tuc.model.DonViThuTuc remove(
        long maDonViThuTuc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.nss_don_vi_thu_tuc.NoSuchDonViThuTucException {
        return getPersistence().remove(maDonViThuTuc);
    }

    public static com.nss.portlet.nss_don_vi_thu_tuc.model.DonViThuTuc remove(
        com.nss.portlet.nss_don_vi_thu_tuc.model.DonViThuTuc donViThuTuc)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(donViThuTuc);
    }

    /**
     * @deprecated Use <code>update(DonViThuTuc donViThuTuc, boolean merge)</code>.
     */
    public static com.nss.portlet.nss_don_vi_thu_tuc.model.DonViThuTuc update(
        com.nss.portlet.nss_don_vi_thu_tuc.model.DonViThuTuc donViThuTuc)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(donViThuTuc);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                donViThuTuc the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when donViThuTuc is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public static com.nss.portlet.nss_don_vi_thu_tuc.model.DonViThuTuc update(
        com.nss.portlet.nss_don_vi_thu_tuc.model.DonViThuTuc donViThuTuc,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().update(donViThuTuc, merge);
    }

    public static com.nss.portlet.nss_don_vi_thu_tuc.model.DonViThuTuc updateImpl(
        com.nss.portlet.nss_don_vi_thu_tuc.model.DonViThuTuc donViThuTuc,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(donViThuTuc, merge);
    }

    public static com.nss.portlet.nss_don_vi_thu_tuc.model.DonViThuTuc findByPrimaryKey(
        long maDonViThuTuc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.nss_don_vi_thu_tuc.NoSuchDonViThuTucException {
        return getPersistence().findByPrimaryKey(maDonViThuTuc);
    }

    public static com.nss.portlet.nss_don_vi_thu_tuc.model.DonViThuTuc fetchByPrimaryKey(
        long maDonViThuTuc) throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(maDonViThuTuc);
    }

    public static java.util.List<com.nss.portlet.nss_don_vi_thu_tuc.model.DonViThuTuc> findByActive(
        int active) throws com.liferay.portal.SystemException {
        return getPersistence().findByActive(active);
    }

    public static java.util.List<com.nss.portlet.nss_don_vi_thu_tuc.model.DonViThuTuc> findByActive(
        int active, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByActive(active, start, end);
    }

    public static java.util.List<com.nss.portlet.nss_don_vi_thu_tuc.model.DonViThuTuc> findByActive(
        int active, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByActive(active, start, end, obc);
    }

    public static com.nss.portlet.nss_don_vi_thu_tuc.model.DonViThuTuc findByActive_First(
        int active, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.nss_don_vi_thu_tuc.NoSuchDonViThuTucException {
        return getPersistence().findByActive_First(active, obc);
    }

    public static com.nss.portlet.nss_don_vi_thu_tuc.model.DonViThuTuc findByActive_Last(
        int active, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.nss_don_vi_thu_tuc.NoSuchDonViThuTucException {
        return getPersistence().findByActive_Last(active, obc);
    }

    public static com.nss.portlet.nss_don_vi_thu_tuc.model.DonViThuTuc[] findByActive_PrevAndNext(
        long maDonViThuTuc, int active,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.nss_don_vi_thu_tuc.NoSuchDonViThuTucException {
        return getPersistence()
                   .findByActive_PrevAndNext(maDonViThuTuc, active, obc);
    }

    public static java.util.List<com.nss.portlet.nss_don_vi_thu_tuc.model.DonViThuTuc> findByCapDonVi(
        int capDonVi) throws com.liferay.portal.SystemException {
        return getPersistence().findByCapDonVi(capDonVi);
    }

    public static java.util.List<com.nss.portlet.nss_don_vi_thu_tuc.model.DonViThuTuc> findByCapDonVi(
        int capDonVi, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByCapDonVi(capDonVi, start, end);
    }

    public static java.util.List<com.nss.portlet.nss_don_vi_thu_tuc.model.DonViThuTuc> findByCapDonVi(
        int capDonVi, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByCapDonVi(capDonVi, start, end, obc);
    }

    public static com.nss.portlet.nss_don_vi_thu_tuc.model.DonViThuTuc findByCapDonVi_First(
        int capDonVi, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.nss_don_vi_thu_tuc.NoSuchDonViThuTucException {
        return getPersistence().findByCapDonVi_First(capDonVi, obc);
    }

    public static com.nss.portlet.nss_don_vi_thu_tuc.model.DonViThuTuc findByCapDonVi_Last(
        int capDonVi, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.nss_don_vi_thu_tuc.NoSuchDonViThuTucException {
        return getPersistence().findByCapDonVi_Last(capDonVi, obc);
    }

    public static com.nss.portlet.nss_don_vi_thu_tuc.model.DonViThuTuc[] findByCapDonVi_PrevAndNext(
        long maDonViThuTuc, int capDonVi,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.nss_don_vi_thu_tuc.NoSuchDonViThuTucException {
        return getPersistence()
                   .findByCapDonVi_PrevAndNext(maDonViThuTuc, capDonVi, obc);
    }

    public static java.util.List<com.nss.portlet.nss_don_vi_thu_tuc.model.DonViThuTuc> findByCapDonVi_Active(
        int capDonVi, int active) throws com.liferay.portal.SystemException {
        return getPersistence().findByCapDonVi_Active(capDonVi, active);
    }

    public static java.util.List<com.nss.portlet.nss_don_vi_thu_tuc.model.DonViThuTuc> findByCapDonVi_Active(
        int capDonVi, int active, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByCapDonVi_Active(capDonVi, active, start, end);
    }

    public static java.util.List<com.nss.portlet.nss_don_vi_thu_tuc.model.DonViThuTuc> findByCapDonVi_Active(
        int capDonVi, int active, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByCapDonVi_Active(capDonVi, active, start, end, obc);
    }

    public static com.nss.portlet.nss_don_vi_thu_tuc.model.DonViThuTuc findByCapDonVi_Active_First(
        int capDonVi, int active,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.nss_don_vi_thu_tuc.NoSuchDonViThuTucException {
        return getPersistence()
                   .findByCapDonVi_Active_First(capDonVi, active, obc);
    }

    public static com.nss.portlet.nss_don_vi_thu_tuc.model.DonViThuTuc findByCapDonVi_Active_Last(
        int capDonVi, int active,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.nss_don_vi_thu_tuc.NoSuchDonViThuTucException {
        return getPersistence().findByCapDonVi_Active_Last(capDonVi, active, obc);
    }

    public static com.nss.portlet.nss_don_vi_thu_tuc.model.DonViThuTuc[] findByCapDonVi_Active_PrevAndNext(
        long maDonViThuTuc, int capDonVi, int active,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.nss_don_vi_thu_tuc.NoSuchDonViThuTucException {
        return getPersistence()
                   .findByCapDonVi_Active_PrevAndNext(maDonViThuTuc, capDonVi,
            active, obc);
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

    public static java.util.List<com.nss.portlet.nss_don_vi_thu_tuc.model.DonViThuTuc> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.nss.portlet.nss_don_vi_thu_tuc.model.DonViThuTuc> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.nss.portlet.nss_don_vi_thu_tuc.model.DonViThuTuc> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end, obc);
    }

    public static void removeByActive(int active)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByActive(active);
    }

    public static void removeByCapDonVi(int capDonVi)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByCapDonVi(capDonVi);
    }

    public static void removeByCapDonVi_Active(int capDonVi, int active)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByCapDonVi_Active(capDonVi, active);
    }

    public static void removeAll() throws com.liferay.portal.SystemException {
        getPersistence().removeAll();
    }

    public static int countByActive(int active)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByActive(active);
    }

    public static int countByCapDonVi(int capDonVi)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByCapDonVi(capDonVi);
    }

    public static int countByCapDonVi_Active(int capDonVi, int active)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByCapDonVi_Active(capDonVi, active);
    }

    public static int countAll() throws com.liferay.portal.SystemException {
        return getPersistence().countAll();
    }

    public static DonViThuTucPersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(DonViThuTucPersistence persistence) {
        _persistence = persistence;
    }
}
