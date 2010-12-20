package com.nss.portlet.loai_thu_tuc.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;


public interface LoaiThuTucHanhChinhPersistence extends BasePersistence {
    public void cacheResult(
        com.nss.portlet.loai_thu_tuc.model.LoaiThuTucHanhChinh loaiThuTucHanhChinh);

    public void cacheResult(
        java.util.List<com.nss.portlet.loai_thu_tuc.model.LoaiThuTucHanhChinh> loaiThuTucHanhChinhs);

    public void clearCache();

    public com.nss.portlet.loai_thu_tuc.model.LoaiThuTucHanhChinh create(
        long maLoaiThuTucHanhChinh);

    public com.nss.portlet.loai_thu_tuc.model.LoaiThuTucHanhChinh remove(
        long maLoaiThuTucHanhChinh)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.loai_thu_tuc.NoSuchLoaiThuTucHanhChinhException;

    public com.nss.portlet.loai_thu_tuc.model.LoaiThuTucHanhChinh remove(
        com.nss.portlet.loai_thu_tuc.model.LoaiThuTucHanhChinh loaiThuTucHanhChinh)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(LoaiThuTucHanhChinh loaiThuTucHanhChinh, boolean merge)</code>.
     */
    public com.nss.portlet.loai_thu_tuc.model.LoaiThuTucHanhChinh update(
        com.nss.portlet.loai_thu_tuc.model.LoaiThuTucHanhChinh loaiThuTucHanhChinh)
        throws com.liferay.portal.SystemException;

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
    public com.nss.portlet.loai_thu_tuc.model.LoaiThuTucHanhChinh update(
        com.nss.portlet.loai_thu_tuc.model.LoaiThuTucHanhChinh loaiThuTucHanhChinh,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.nss.portlet.loai_thu_tuc.model.LoaiThuTucHanhChinh updateImpl(
        com.nss.portlet.loai_thu_tuc.model.LoaiThuTucHanhChinh loaiThuTucHanhChinh,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.nss.portlet.loai_thu_tuc.model.LoaiThuTucHanhChinh findByPrimaryKey(
        long maLoaiThuTucHanhChinh)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.loai_thu_tuc.NoSuchLoaiThuTucHanhChinhException;

    public com.nss.portlet.loai_thu_tuc.model.LoaiThuTucHanhChinh fetchByPrimaryKey(
        long maLoaiThuTucHanhChinh) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.loai_thu_tuc.model.LoaiThuTucHanhChinh> findByActive(
        int active) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.loai_thu_tuc.model.LoaiThuTucHanhChinh> findByActive(
        int active, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.loai_thu_tuc.model.LoaiThuTucHanhChinh> findByActive(
        int active, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.loai_thu_tuc.model.LoaiThuTucHanhChinh findByActive_First(
        int active, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.loai_thu_tuc.NoSuchLoaiThuTucHanhChinhException;

    public com.nss.portlet.loai_thu_tuc.model.LoaiThuTucHanhChinh findByActive_Last(
        int active, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.loai_thu_tuc.NoSuchLoaiThuTucHanhChinhException;

    public com.nss.portlet.loai_thu_tuc.model.LoaiThuTucHanhChinh[] findByActive_PrevAndNext(
        long maLoaiThuTucHanhChinh, int active,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.loai_thu_tuc.NoSuchLoaiThuTucHanhChinhException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.loai_thu_tuc.model.LoaiThuTucHanhChinh> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.loai_thu_tuc.model.LoaiThuTucHanhChinh> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.loai_thu_tuc.model.LoaiThuTucHanhChinh> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeByActive(int active)
        throws com.liferay.portal.SystemException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countByActive(int active)
        throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;
}
