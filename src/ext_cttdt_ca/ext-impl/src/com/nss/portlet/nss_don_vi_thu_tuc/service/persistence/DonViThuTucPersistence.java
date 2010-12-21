package com.nss.portlet.nss_don_vi_thu_tuc.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;


public interface DonViThuTucPersistence extends BasePersistence {
    public void cacheResult(
        com.nss.portlet.nss_don_vi_thu_tuc.model.DonViThuTuc donViThuTuc);

    public void cacheResult(
        java.util.List<com.nss.portlet.nss_don_vi_thu_tuc.model.DonViThuTuc> donViThuTucs);

    public void clearCache();

    public com.nss.portlet.nss_don_vi_thu_tuc.model.DonViThuTuc create(
        long maDonViThuTuc);

    public com.nss.portlet.nss_don_vi_thu_tuc.model.DonViThuTuc remove(
        long maDonViThuTuc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.nss_don_vi_thu_tuc.NoSuchDonViThuTucException;

    public com.nss.portlet.nss_don_vi_thu_tuc.model.DonViThuTuc remove(
        com.nss.portlet.nss_don_vi_thu_tuc.model.DonViThuTuc donViThuTuc)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(DonViThuTuc donViThuTuc, boolean merge)</code>.
     */
    public com.nss.portlet.nss_don_vi_thu_tuc.model.DonViThuTuc update(
        com.nss.portlet.nss_don_vi_thu_tuc.model.DonViThuTuc donViThuTuc)
        throws com.liferay.portal.SystemException;

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
    public com.nss.portlet.nss_don_vi_thu_tuc.model.DonViThuTuc update(
        com.nss.portlet.nss_don_vi_thu_tuc.model.DonViThuTuc donViThuTuc,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.nss.portlet.nss_don_vi_thu_tuc.model.DonViThuTuc updateImpl(
        com.nss.portlet.nss_don_vi_thu_tuc.model.DonViThuTuc donViThuTuc,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.nss.portlet.nss_don_vi_thu_tuc.model.DonViThuTuc findByPrimaryKey(
        long maDonViThuTuc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.nss_don_vi_thu_tuc.NoSuchDonViThuTucException;

    public com.nss.portlet.nss_don_vi_thu_tuc.model.DonViThuTuc fetchByPrimaryKey(
        long maDonViThuTuc) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.nss_don_vi_thu_tuc.model.DonViThuTuc> findByActive(
        int active) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.nss_don_vi_thu_tuc.model.DonViThuTuc> findByActive(
        int active, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.nss_don_vi_thu_tuc.model.DonViThuTuc> findByActive(
        int active, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.nss_don_vi_thu_tuc.model.DonViThuTuc findByActive_First(
        int active, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.nss_don_vi_thu_tuc.NoSuchDonViThuTucException;

    public com.nss.portlet.nss_don_vi_thu_tuc.model.DonViThuTuc findByActive_Last(
        int active, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.nss_don_vi_thu_tuc.NoSuchDonViThuTucException;

    public com.nss.portlet.nss_don_vi_thu_tuc.model.DonViThuTuc[] findByActive_PrevAndNext(
        long maDonViThuTuc, int active,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.nss_don_vi_thu_tuc.NoSuchDonViThuTucException;

    public java.util.List<com.nss.portlet.nss_don_vi_thu_tuc.model.DonViThuTuc> findByCapDonVi(
        int capDonVi) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.nss_don_vi_thu_tuc.model.DonViThuTuc> findByCapDonVi(
        int capDonVi, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.nss_don_vi_thu_tuc.model.DonViThuTuc> findByCapDonVi(
        int capDonVi, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.nss_don_vi_thu_tuc.model.DonViThuTuc findByCapDonVi_First(
        int capDonVi, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.nss_don_vi_thu_tuc.NoSuchDonViThuTucException;

    public com.nss.portlet.nss_don_vi_thu_tuc.model.DonViThuTuc findByCapDonVi_Last(
        int capDonVi, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.nss_don_vi_thu_tuc.NoSuchDonViThuTucException;

    public com.nss.portlet.nss_don_vi_thu_tuc.model.DonViThuTuc[] findByCapDonVi_PrevAndNext(
        long maDonViThuTuc, int capDonVi,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.nss_don_vi_thu_tuc.NoSuchDonViThuTucException;

    public java.util.List<com.nss.portlet.nss_don_vi_thu_tuc.model.DonViThuTuc> findByCapDonVi_Active(
        int capDonVi, int active) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.nss_don_vi_thu_tuc.model.DonViThuTuc> findByCapDonVi_Active(
        int capDonVi, int active, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.nss_don_vi_thu_tuc.model.DonViThuTuc> findByCapDonVi_Active(
        int capDonVi, int active, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.nss_don_vi_thu_tuc.model.DonViThuTuc findByCapDonVi_Active_First(
        int capDonVi, int active,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.nss_don_vi_thu_tuc.NoSuchDonViThuTucException;

    public com.nss.portlet.nss_don_vi_thu_tuc.model.DonViThuTuc findByCapDonVi_Active_Last(
        int capDonVi, int active,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.nss_don_vi_thu_tuc.NoSuchDonViThuTucException;

    public com.nss.portlet.nss_don_vi_thu_tuc.model.DonViThuTuc[] findByCapDonVi_Active_PrevAndNext(
        long maDonViThuTuc, int capDonVi, int active,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.nss_don_vi_thu_tuc.NoSuchDonViThuTucException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.nss_don_vi_thu_tuc.model.DonViThuTuc> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.nss_don_vi_thu_tuc.model.DonViThuTuc> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.nss_don_vi_thu_tuc.model.DonViThuTuc> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeByActive(int active)
        throws com.liferay.portal.SystemException;

    public void removeByCapDonVi(int capDonVi)
        throws com.liferay.portal.SystemException;

    public void removeByCapDonVi_Active(int capDonVi, int active)
        throws com.liferay.portal.SystemException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countByActive(int active)
        throws com.liferay.portal.SystemException;

    public int countByCapDonVi(int capDonVi)
        throws com.liferay.portal.SystemException;

    public int countByCapDonVi_Active(int capDonVi, int active)
        throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;
}
