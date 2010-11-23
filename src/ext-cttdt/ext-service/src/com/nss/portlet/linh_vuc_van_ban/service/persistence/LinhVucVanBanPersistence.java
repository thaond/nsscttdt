package com.nss.portlet.linh_vuc_van_ban.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;


public interface LinhVucVanBanPersistence extends BasePersistence {
    public void cacheResult(
        com.nss.portlet.linh_vuc_van_ban.model.LinhVucVanBan linhVucVanBan);

    public void cacheResult(
        java.util.List<com.nss.portlet.linh_vuc_van_ban.model.LinhVucVanBan> linhVucVanBans);

    public void clearCache();

    public com.nss.portlet.linh_vuc_van_ban.model.LinhVucVanBan create(
        long maLinhVucVanBan);

    public com.nss.portlet.linh_vuc_van_ban.model.LinhVucVanBan remove(
        long maLinhVucVanBan)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.linh_vuc_van_ban.NoSuchLinhVucVanBanException;

    public com.nss.portlet.linh_vuc_van_ban.model.LinhVucVanBan remove(
        com.nss.portlet.linh_vuc_van_ban.model.LinhVucVanBan linhVucVanBan)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(LinhVucVanBan linhVucVanBan, boolean merge)</code>.
     */
    public com.nss.portlet.linh_vuc_van_ban.model.LinhVucVanBan update(
        com.nss.portlet.linh_vuc_van_ban.model.LinhVucVanBan linhVucVanBan)
        throws com.liferay.portal.SystemException;

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                linhVucVanBan the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when linhVucVanBan is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public com.nss.portlet.linh_vuc_van_ban.model.LinhVucVanBan update(
        com.nss.portlet.linh_vuc_van_ban.model.LinhVucVanBan linhVucVanBan,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.nss.portlet.linh_vuc_van_ban.model.LinhVucVanBan updateImpl(
        com.nss.portlet.linh_vuc_van_ban.model.LinhVucVanBan linhVucVanBan,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.nss.portlet.linh_vuc_van_ban.model.LinhVucVanBan findByPrimaryKey(
        long maLinhVucVanBan)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.linh_vuc_van_ban.NoSuchLinhVucVanBanException;

    public com.nss.portlet.linh_vuc_van_ban.model.LinhVucVanBan fetchByPrimaryKey(
        long maLinhVucVanBan) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.linh_vuc_van_ban.model.LinhVucVanBan> findByParentId(
        long parentid) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.linh_vuc_van_ban.model.LinhVucVanBan> findByParentId(
        long parentid, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.linh_vuc_van_ban.model.LinhVucVanBan> findByParentId(
        long parentid, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.linh_vuc_van_ban.model.LinhVucVanBan findByParentId_First(
        long parentid, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.linh_vuc_van_ban.NoSuchLinhVucVanBanException;

    public com.nss.portlet.linh_vuc_van_ban.model.LinhVucVanBan findByParentId_Last(
        long parentid, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.linh_vuc_van_ban.NoSuchLinhVucVanBanException;

    public com.nss.portlet.linh_vuc_van_ban.model.LinhVucVanBan[] findByParentId_PrevAndNext(
        long maLinhVucVanBan, long parentid,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.linh_vuc_van_ban.NoSuchLinhVucVanBanException;

    public java.util.List<com.nss.portlet.linh_vuc_van_ban.model.LinhVucVanBan> findByActive(
        int active) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.linh_vuc_van_ban.model.LinhVucVanBan> findByActive(
        int active, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.linh_vuc_van_ban.model.LinhVucVanBan> findByActive(
        int active, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.linh_vuc_van_ban.model.LinhVucVanBan findByActive_First(
        int active, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.linh_vuc_van_ban.NoSuchLinhVucVanBanException;

    public com.nss.portlet.linh_vuc_van_ban.model.LinhVucVanBan findByActive_Last(
        int active, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.linh_vuc_van_ban.NoSuchLinhVucVanBanException;

    public com.nss.portlet.linh_vuc_van_ban.model.LinhVucVanBan[] findByActive_PrevAndNext(
        long maLinhVucVanBan, int active,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.linh_vuc_van_ban.NoSuchLinhVucVanBanException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.linh_vuc_van_ban.model.LinhVucVanBan> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.linh_vuc_van_ban.model.LinhVucVanBan> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.linh_vuc_van_ban.model.LinhVucVanBan> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeByParentId(long parentid)
        throws com.liferay.portal.SystemException;

    public void removeByActive(int active)
        throws com.liferay.portal.SystemException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countByParentId(long parentid)
        throws com.liferay.portal.SystemException;

    public int countByActive(int active)
        throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;
}
