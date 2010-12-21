package com.nss.portlet.thu_tuc_hanh_chinh.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;


public interface FileDinhKemTTHCPersistence extends BasePersistence {
    public void cacheResult(
        com.nss.portlet.thu_tuc_hanh_chinh.model.FileDinhKemTTHC fileDinhKemTTHC);

    public void cacheResult(
        java.util.List<com.nss.portlet.thu_tuc_hanh_chinh.model.FileDinhKemTTHC> fileDinhKemTTHCs);

    public void clearCache();

    public com.nss.portlet.thu_tuc_hanh_chinh.model.FileDinhKemTTHC create(
        long maFileDinhKemTTHC);

    public com.nss.portlet.thu_tuc_hanh_chinh.model.FileDinhKemTTHC remove(
        long maFileDinhKemTTHC)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.thu_tuc_hanh_chinh.NoSuchFileDinhKemTTHCException;

    public com.nss.portlet.thu_tuc_hanh_chinh.model.FileDinhKemTTHC remove(
        com.nss.portlet.thu_tuc_hanh_chinh.model.FileDinhKemTTHC fileDinhKemTTHC)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(FileDinhKemTTHC fileDinhKemTTHC, boolean merge)</code>.
     */
    public com.nss.portlet.thu_tuc_hanh_chinh.model.FileDinhKemTTHC update(
        com.nss.portlet.thu_tuc_hanh_chinh.model.FileDinhKemTTHC fileDinhKemTTHC)
        throws com.liferay.portal.SystemException;

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
    public com.nss.portlet.thu_tuc_hanh_chinh.model.FileDinhKemTTHC update(
        com.nss.portlet.thu_tuc_hanh_chinh.model.FileDinhKemTTHC fileDinhKemTTHC,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.nss.portlet.thu_tuc_hanh_chinh.model.FileDinhKemTTHC updateImpl(
        com.nss.portlet.thu_tuc_hanh_chinh.model.FileDinhKemTTHC fileDinhKemTTHC,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.nss.portlet.thu_tuc_hanh_chinh.model.FileDinhKemTTHC findByPrimaryKey(
        long maFileDinhKemTTHC)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.thu_tuc_hanh_chinh.NoSuchFileDinhKemTTHCException;

    public com.nss.portlet.thu_tuc_hanh_chinh.model.FileDinhKemTTHC fetchByPrimaryKey(
        long maFileDinhKemTTHC) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.thu_tuc_hanh_chinh.model.FileDinhKemTTHC> findByMaThuTucHanhChinh(
        long maThuTucHanhChinh) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.thu_tuc_hanh_chinh.model.FileDinhKemTTHC> findByMaThuTucHanhChinh(
        long maThuTucHanhChinh, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.thu_tuc_hanh_chinh.model.FileDinhKemTTHC> findByMaThuTucHanhChinh(
        long maThuTucHanhChinh, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.thu_tuc_hanh_chinh.model.FileDinhKemTTHC findByMaThuTucHanhChinh_First(
        long maThuTucHanhChinh,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.thu_tuc_hanh_chinh.NoSuchFileDinhKemTTHCException;

    public com.nss.portlet.thu_tuc_hanh_chinh.model.FileDinhKemTTHC findByMaThuTucHanhChinh_Last(
        long maThuTucHanhChinh,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.thu_tuc_hanh_chinh.NoSuchFileDinhKemTTHCException;

    public com.nss.portlet.thu_tuc_hanh_chinh.model.FileDinhKemTTHC[] findByMaThuTucHanhChinh_PrevAndNext(
        long maFileDinhKemTTHC, long maThuTucHanhChinh,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.thu_tuc_hanh_chinh.NoSuchFileDinhKemTTHCException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.thu_tuc_hanh_chinh.model.FileDinhKemTTHC> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.thu_tuc_hanh_chinh.model.FileDinhKemTTHC> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.thu_tuc_hanh_chinh.model.FileDinhKemTTHC> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeByMaThuTucHanhChinh(long maThuTucHanhChinh)
        throws com.liferay.portal.SystemException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countByMaThuTucHanhChinh(long maThuTucHanhChinh)
        throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;
}
