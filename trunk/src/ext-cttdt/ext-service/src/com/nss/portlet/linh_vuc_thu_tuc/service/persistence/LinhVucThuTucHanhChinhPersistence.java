package com.nss.portlet.linh_vuc_thu_tuc.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;


public interface LinhVucThuTucHanhChinhPersistence extends BasePersistence {
    public void cacheResult(
        com.nss.portlet.linh_vuc_thu_tuc.model.LinhVucThuTucHanhChinh linhVucThuTucHanhChinh);

    public void cacheResult(
        java.util.List<com.nss.portlet.linh_vuc_thu_tuc.model.LinhVucThuTucHanhChinh> linhVucThuTucHanhChinhs);

    public void clearCache();

    public com.nss.portlet.linh_vuc_thu_tuc.model.LinhVucThuTucHanhChinh create(
        long maLinhVucThuTucHanhChinh);

    public com.nss.portlet.linh_vuc_thu_tuc.model.LinhVucThuTucHanhChinh remove(
        long maLinhVucThuTucHanhChinh)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.linh_vuc_thu_tuc.NoSuchLinhVucThuTucHanhChinhException;

    public com.nss.portlet.linh_vuc_thu_tuc.model.LinhVucThuTucHanhChinh remove(
        com.nss.portlet.linh_vuc_thu_tuc.model.LinhVucThuTucHanhChinh linhVucThuTucHanhChinh)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(LinhVucThuTucHanhChinh linhVucThuTucHanhChinh, boolean merge)</code>.
     */
    public com.nss.portlet.linh_vuc_thu_tuc.model.LinhVucThuTucHanhChinh update(
        com.nss.portlet.linh_vuc_thu_tuc.model.LinhVucThuTucHanhChinh linhVucThuTucHanhChinh)
        throws com.liferay.portal.SystemException;

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
    public com.nss.portlet.linh_vuc_thu_tuc.model.LinhVucThuTucHanhChinh update(
        com.nss.portlet.linh_vuc_thu_tuc.model.LinhVucThuTucHanhChinh linhVucThuTucHanhChinh,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.nss.portlet.linh_vuc_thu_tuc.model.LinhVucThuTucHanhChinh updateImpl(
        com.nss.portlet.linh_vuc_thu_tuc.model.LinhVucThuTucHanhChinh linhVucThuTucHanhChinh,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.nss.portlet.linh_vuc_thu_tuc.model.LinhVucThuTucHanhChinh findByPrimaryKey(
        long maLinhVucThuTucHanhChinh)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.linh_vuc_thu_tuc.NoSuchLinhVucThuTucHanhChinhException;

    public com.nss.portlet.linh_vuc_thu_tuc.model.LinhVucThuTucHanhChinh fetchByPrimaryKey(
        long maLinhVucThuTucHanhChinh)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.linh_vuc_thu_tuc.model.LinhVucThuTucHanhChinh> findByActive(
        int active) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.linh_vuc_thu_tuc.model.LinhVucThuTucHanhChinh> findByActive(
        int active, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.linh_vuc_thu_tuc.model.LinhVucThuTucHanhChinh> findByActive(
        int active, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.linh_vuc_thu_tuc.model.LinhVucThuTucHanhChinh findByActive_First(
        int active, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.linh_vuc_thu_tuc.NoSuchLinhVucThuTucHanhChinhException;

    public com.nss.portlet.linh_vuc_thu_tuc.model.LinhVucThuTucHanhChinh findByActive_Last(
        int active, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.linh_vuc_thu_tuc.NoSuchLinhVucThuTucHanhChinhException;

    public com.nss.portlet.linh_vuc_thu_tuc.model.LinhVucThuTucHanhChinh[] findByActive_PrevAndNext(
        long maLinhVucThuTucHanhChinh, int active,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.linh_vuc_thu_tuc.NoSuchLinhVucThuTucHanhChinhException;

    public java.util.List<com.nss.portlet.linh_vuc_thu_tuc.model.LinhVucThuTucHanhChinh> findByMaLoaiThuTucHanhChinh(
        long maLoaiThuTucHanhChinh) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.linh_vuc_thu_tuc.model.LinhVucThuTucHanhChinh> findByMaLoaiThuTucHanhChinh(
        long maLoaiThuTucHanhChinh, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.linh_vuc_thu_tuc.model.LinhVucThuTucHanhChinh> findByMaLoaiThuTucHanhChinh(
        long maLoaiThuTucHanhChinh, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.linh_vuc_thu_tuc.model.LinhVucThuTucHanhChinh findByMaLoaiThuTucHanhChinh_First(
        long maLoaiThuTucHanhChinh,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.linh_vuc_thu_tuc.NoSuchLinhVucThuTucHanhChinhException;

    public com.nss.portlet.linh_vuc_thu_tuc.model.LinhVucThuTucHanhChinh findByMaLoaiThuTucHanhChinh_Last(
        long maLoaiThuTucHanhChinh,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.linh_vuc_thu_tuc.NoSuchLinhVucThuTucHanhChinhException;

    public com.nss.portlet.linh_vuc_thu_tuc.model.LinhVucThuTucHanhChinh[] findByMaLoaiThuTucHanhChinh_PrevAndNext(
        long maLinhVucThuTucHanhChinh, long maLoaiThuTucHanhChinh,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.linh_vuc_thu_tuc.NoSuchLinhVucThuTucHanhChinhException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.linh_vuc_thu_tuc.model.LinhVucThuTucHanhChinh> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.linh_vuc_thu_tuc.model.LinhVucThuTucHanhChinh> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.linh_vuc_thu_tuc.model.LinhVucThuTucHanhChinh> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeByActive(int active)
        throws com.liferay.portal.SystemException;

    public void removeByMaLoaiThuTucHanhChinh(long maLoaiThuTucHanhChinh)
        throws com.liferay.portal.SystemException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countByActive(int active)
        throws com.liferay.portal.SystemException;

    public int countByMaLoaiThuTucHanhChinh(long maLoaiThuTucHanhChinh)
        throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;
}
