package com.nss.portlet.loai_van_ban.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;


public interface LoaiVanBanPersistence extends BasePersistence {
    public void cacheResult(
        com.nss.portlet.loai_van_ban.model.LoaiVanBan loaiVanBan);

    public void cacheResult(
        java.util.List<com.nss.portlet.loai_van_ban.model.LoaiVanBan> loaiVanBans);

    public void clearCache();

    public com.nss.portlet.loai_van_ban.model.LoaiVanBan create(
        long maLoaiVanBan);

    public com.nss.portlet.loai_van_ban.model.LoaiVanBan remove(
        long maLoaiVanBan)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.loai_van_ban.NoSuchLoaiVanBanException;

    public com.nss.portlet.loai_van_ban.model.LoaiVanBan remove(
        com.nss.portlet.loai_van_ban.model.LoaiVanBan loaiVanBan)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(LoaiVanBan loaiVanBan, boolean merge)</code>.
     */
    public com.nss.portlet.loai_van_ban.model.LoaiVanBan update(
        com.nss.portlet.loai_van_ban.model.LoaiVanBan loaiVanBan)
        throws com.liferay.portal.SystemException;

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                loaiVanBan the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when loaiVanBan is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public com.nss.portlet.loai_van_ban.model.LoaiVanBan update(
        com.nss.portlet.loai_van_ban.model.LoaiVanBan loaiVanBan, boolean merge)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.loai_van_ban.model.LoaiVanBan updateImpl(
        com.nss.portlet.loai_van_ban.model.LoaiVanBan loaiVanBan, boolean merge)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.loai_van_ban.model.LoaiVanBan findByPrimaryKey(
        long maLoaiVanBan)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.loai_van_ban.NoSuchLoaiVanBanException;

    public com.nss.portlet.loai_van_ban.model.LoaiVanBan fetchByPrimaryKey(
        long maLoaiVanBan) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.loai_van_ban.model.LoaiVanBan> findByActive(
        int active) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.loai_van_ban.model.LoaiVanBan> findByActive(
        int active, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.loai_van_ban.model.LoaiVanBan> findByActive(
        int active, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.loai_van_ban.model.LoaiVanBan findByActive_First(
        int active, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.loai_van_ban.NoSuchLoaiVanBanException;

    public com.nss.portlet.loai_van_ban.model.LoaiVanBan findByActive_Last(
        int active, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.loai_van_ban.NoSuchLoaiVanBanException;

    public com.nss.portlet.loai_van_ban.model.LoaiVanBan[] findByActive_PrevAndNext(
        long maLoaiVanBan, int active,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.loai_van_ban.NoSuchLoaiVanBanException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.loai_van_ban.model.LoaiVanBan> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.loai_van_ban.model.LoaiVanBan> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.loai_van_ban.model.LoaiVanBan> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeByActive(int active)
        throws com.liferay.portal.SystemException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countByActive(int active)
        throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;
}
