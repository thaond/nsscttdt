package com.nss.portlet.thu_tuc_hanh_chinh.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;


public interface ThuTucHanhChinhPersistence extends BasePersistence {
    public void cacheResult(
        com.nss.portlet.thu_tuc_hanh_chinh.model.ThuTucHanhChinh thuTucHanhChinh);

    public void cacheResult(
        java.util.List<com.nss.portlet.thu_tuc_hanh_chinh.model.ThuTucHanhChinh> thuTucHanhChinhs);

    public void clearCache();

    public com.nss.portlet.thu_tuc_hanh_chinh.model.ThuTucHanhChinh create(
        long maThuTucHanhChinh);

    public com.nss.portlet.thu_tuc_hanh_chinh.model.ThuTucHanhChinh remove(
        long maThuTucHanhChinh)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.thu_tuc_hanh_chinh.NoSuchThuTucHanhChinhException;

    public com.nss.portlet.thu_tuc_hanh_chinh.model.ThuTucHanhChinh remove(
        com.nss.portlet.thu_tuc_hanh_chinh.model.ThuTucHanhChinh thuTucHanhChinh)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(ThuTucHanhChinh thuTucHanhChinh, boolean merge)</code>.
     */
    public com.nss.portlet.thu_tuc_hanh_chinh.model.ThuTucHanhChinh update(
        com.nss.portlet.thu_tuc_hanh_chinh.model.ThuTucHanhChinh thuTucHanhChinh)
        throws com.liferay.portal.SystemException;

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
    public com.nss.portlet.thu_tuc_hanh_chinh.model.ThuTucHanhChinh update(
        com.nss.portlet.thu_tuc_hanh_chinh.model.ThuTucHanhChinh thuTucHanhChinh,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.nss.portlet.thu_tuc_hanh_chinh.model.ThuTucHanhChinh updateImpl(
        com.nss.portlet.thu_tuc_hanh_chinh.model.ThuTucHanhChinh thuTucHanhChinh,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.nss.portlet.thu_tuc_hanh_chinh.model.ThuTucHanhChinh findByPrimaryKey(
        long maThuTucHanhChinh)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.thu_tuc_hanh_chinh.NoSuchThuTucHanhChinhException;

    public com.nss.portlet.thu_tuc_hanh_chinh.model.ThuTucHanhChinh fetchByPrimaryKey(
        long maThuTucHanhChinh) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.thu_tuc_hanh_chinh.model.ThuTucHanhChinh> findByActive(
        int active) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.thu_tuc_hanh_chinh.model.ThuTucHanhChinh> findByActive(
        int active, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.thu_tuc_hanh_chinh.model.ThuTucHanhChinh> findByActive(
        int active, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.thu_tuc_hanh_chinh.model.ThuTucHanhChinh findByActive_First(
        int active, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.thu_tuc_hanh_chinh.NoSuchThuTucHanhChinhException;

    public com.nss.portlet.thu_tuc_hanh_chinh.model.ThuTucHanhChinh findByActive_Last(
        int active, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.thu_tuc_hanh_chinh.NoSuchThuTucHanhChinhException;

    public com.nss.portlet.thu_tuc_hanh_chinh.model.ThuTucHanhChinh[] findByActive_PrevAndNext(
        long maThuTucHanhChinh, int active,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.thu_tuc_hanh_chinh.NoSuchThuTucHanhChinhException;

    public java.util.List<com.nss.portlet.thu_tuc_hanh_chinh.model.ThuTucHanhChinh> findByMaLinhVucThuTucHanhChinh(
        long maLinhVucThuTucHanhChinh)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.thu_tuc_hanh_chinh.model.ThuTucHanhChinh> findByMaLinhVucThuTucHanhChinh(
        long maLinhVucThuTucHanhChinh, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.thu_tuc_hanh_chinh.model.ThuTucHanhChinh> findByMaLinhVucThuTucHanhChinh(
        long maLinhVucThuTucHanhChinh, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.thu_tuc_hanh_chinh.model.ThuTucHanhChinh findByMaLinhVucThuTucHanhChinh_First(
        long maLinhVucThuTucHanhChinh,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.thu_tuc_hanh_chinh.NoSuchThuTucHanhChinhException;

    public com.nss.portlet.thu_tuc_hanh_chinh.model.ThuTucHanhChinh findByMaLinhVucThuTucHanhChinh_Last(
        long maLinhVucThuTucHanhChinh,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.thu_tuc_hanh_chinh.NoSuchThuTucHanhChinhException;

    public com.nss.portlet.thu_tuc_hanh_chinh.model.ThuTucHanhChinh[] findByMaLinhVucThuTucHanhChinh_PrevAndNext(
        long maThuTucHanhChinh, long maLinhVucThuTucHanhChinh,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.thu_tuc_hanh_chinh.NoSuchThuTucHanhChinhException;

    public java.util.List<com.nss.portlet.thu_tuc_hanh_chinh.model.ThuTucHanhChinh> findByMaDonViThuTucHanhChinh(
        long maDonViThuTucHanhChinh) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.thu_tuc_hanh_chinh.model.ThuTucHanhChinh> findByMaDonViThuTucHanhChinh(
        long maDonViThuTucHanhChinh, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.thu_tuc_hanh_chinh.model.ThuTucHanhChinh> findByMaDonViThuTucHanhChinh(
        long maDonViThuTucHanhChinh, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.thu_tuc_hanh_chinh.model.ThuTucHanhChinh findByMaDonViThuTucHanhChinh_First(
        long maDonViThuTucHanhChinh,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.thu_tuc_hanh_chinh.NoSuchThuTucHanhChinhException;

    public com.nss.portlet.thu_tuc_hanh_chinh.model.ThuTucHanhChinh findByMaDonViThuTucHanhChinh_Last(
        long maDonViThuTucHanhChinh,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.thu_tuc_hanh_chinh.NoSuchThuTucHanhChinhException;

    public com.nss.portlet.thu_tuc_hanh_chinh.model.ThuTucHanhChinh[] findByMaDonViThuTucHanhChinh_PrevAndNext(
        long maThuTucHanhChinh, long maDonViThuTucHanhChinh,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.thu_tuc_hanh_chinh.NoSuchThuTucHanhChinhException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.thu_tuc_hanh_chinh.model.ThuTucHanhChinh> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.thu_tuc_hanh_chinh.model.ThuTucHanhChinh> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.thu_tuc_hanh_chinh.model.ThuTucHanhChinh> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeByActive(int active)
        throws com.liferay.portal.SystemException;

    public void removeByMaLinhVucThuTucHanhChinh(long maLinhVucThuTucHanhChinh)
        throws com.liferay.portal.SystemException;

    public void removeByMaDonViThuTucHanhChinh(long maDonViThuTucHanhChinh)
        throws com.liferay.portal.SystemException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countByActive(int active)
        throws com.liferay.portal.SystemException;

    public int countByMaLinhVucThuTucHanhChinh(long maLinhVucThuTucHanhChinh)
        throws com.liferay.portal.SystemException;

    public int countByMaDonViThuTucHanhChinh(long maDonViThuTucHanhChinh)
        throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;
}
