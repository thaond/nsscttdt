package com.nss.portlet.van_ban_phap_quy.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;


public interface FileDinhKemPersistence extends BasePersistence {
    public void cacheResult(
        com.nss.portlet.van_ban_phap_quy.model.FileDinhKem fileDinhKem);

    public void cacheResult(
        java.util.List<com.nss.portlet.van_ban_phap_quy.model.FileDinhKem> fileDinhKems);

    public void clearCache();

    public com.nss.portlet.van_ban_phap_quy.model.FileDinhKem create(
        long maFileDinhKem);

    public com.nss.portlet.van_ban_phap_quy.model.FileDinhKem remove(
        long maFileDinhKem)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.van_ban_phap_quy.NoSuchFileDinhKemException;

    public com.nss.portlet.van_ban_phap_quy.model.FileDinhKem remove(
        com.nss.portlet.van_ban_phap_quy.model.FileDinhKem fileDinhKem)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(FileDinhKem fileDinhKem, boolean merge)</code>.
     */
    public com.nss.portlet.van_ban_phap_quy.model.FileDinhKem update(
        com.nss.portlet.van_ban_phap_quy.model.FileDinhKem fileDinhKem)
        throws com.liferay.portal.SystemException;

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
    public com.nss.portlet.van_ban_phap_quy.model.FileDinhKem update(
        com.nss.portlet.van_ban_phap_quy.model.FileDinhKem fileDinhKem,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.nss.portlet.van_ban_phap_quy.model.FileDinhKem updateImpl(
        com.nss.portlet.van_ban_phap_quy.model.FileDinhKem fileDinhKem,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.nss.portlet.van_ban_phap_quy.model.FileDinhKem findByPrimaryKey(
        long maFileDinhKem)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.van_ban_phap_quy.NoSuchFileDinhKemException;

    public com.nss.portlet.van_ban_phap_quy.model.FileDinhKem fetchByPrimaryKey(
        long maFileDinhKem) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.van_ban_phap_quy.model.FileDinhKem> findBymaVanBanPhapQuy_PhienBan(
        long maVanBanPhapQuy, int phienBan)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.van_ban_phap_quy.model.FileDinhKem> findBymaVanBanPhapQuy_PhienBan(
        long maVanBanPhapQuy, int phienBan, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.van_ban_phap_quy.model.FileDinhKem> findBymaVanBanPhapQuy_PhienBan(
        long maVanBanPhapQuy, int phienBan, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.van_ban_phap_quy.model.FileDinhKem findBymaVanBanPhapQuy_PhienBan_First(
        long maVanBanPhapQuy, int phienBan,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.van_ban_phap_quy.NoSuchFileDinhKemException;

    public com.nss.portlet.van_ban_phap_quy.model.FileDinhKem findBymaVanBanPhapQuy_PhienBan_Last(
        long maVanBanPhapQuy, int phienBan,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.van_ban_phap_quy.NoSuchFileDinhKemException;

    public com.nss.portlet.van_ban_phap_quy.model.FileDinhKem[] findBymaVanBanPhapQuy_PhienBan_PrevAndNext(
        long maFileDinhKem, long maVanBanPhapQuy, int phienBan,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.van_ban_phap_quy.NoSuchFileDinhKemException;

    public java.util.List<com.nss.portlet.van_ban_phap_quy.model.FileDinhKem> findBymaVanBanPhapQuy(
        long maVanBanPhapQuy) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.van_ban_phap_quy.model.FileDinhKem> findBymaVanBanPhapQuy(
        long maVanBanPhapQuy, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.van_ban_phap_quy.model.FileDinhKem> findBymaVanBanPhapQuy(
        long maVanBanPhapQuy, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.van_ban_phap_quy.model.FileDinhKem findBymaVanBanPhapQuy_First(
        long maVanBanPhapQuy,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.van_ban_phap_quy.NoSuchFileDinhKemException;

    public com.nss.portlet.van_ban_phap_quy.model.FileDinhKem findBymaVanBanPhapQuy_Last(
        long maVanBanPhapQuy,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.van_ban_phap_quy.NoSuchFileDinhKemException;

    public com.nss.portlet.van_ban_phap_quy.model.FileDinhKem[] findBymaVanBanPhapQuy_PrevAndNext(
        long maFileDinhKem, long maVanBanPhapQuy,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.van_ban_phap_quy.NoSuchFileDinhKemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.van_ban_phap_quy.model.FileDinhKem> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.van_ban_phap_quy.model.FileDinhKem> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.van_ban_phap_quy.model.FileDinhKem> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeBymaVanBanPhapQuy_PhienBan(long maVanBanPhapQuy,
        int phienBan) throws com.liferay.portal.SystemException;

    public void removeBymaVanBanPhapQuy(long maVanBanPhapQuy)
        throws com.liferay.portal.SystemException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countBymaVanBanPhapQuy_PhienBan(long maVanBanPhapQuy,
        int phienBan) throws com.liferay.portal.SystemException;

    public int countBymaVanBanPhapQuy(long maVanBanPhapQuy)
        throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;
}
