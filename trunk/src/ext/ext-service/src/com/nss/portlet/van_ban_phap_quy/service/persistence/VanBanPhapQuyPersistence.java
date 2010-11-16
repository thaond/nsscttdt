package com.nss.portlet.van_ban_phap_quy.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;


public interface VanBanPhapQuyPersistence extends BasePersistence {
    public void cacheResult(
        com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy vanBanPhapQuy);

    public void cacheResult(
        java.util.List<com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy> vanBanPhapQuies);

    public void clearCache();

    public com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy create(
        long maVanBanPhapQuy);

    public com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy remove(
        long maVanBanPhapQuy)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.van_ban_phap_quy.NoSuchVanBanPhapQuyException;

    public com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy remove(
        com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy vanBanPhapQuy)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(VanBanPhapQuy vanBanPhapQuy, boolean merge)</code>.
     */
    public com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy update(
        com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy vanBanPhapQuy)
        throws com.liferay.portal.SystemException;

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                vanBanPhapQuy the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when vanBanPhapQuy is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy update(
        com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy vanBanPhapQuy,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy updateImpl(
        com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy vanBanPhapQuy,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy findByPrimaryKey(
        long maVanBanPhapQuy)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.van_ban_phap_quy.NoSuchVanBanPhapQuyException;

    public com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy fetchByPrimaryKey(
        long maVanBanPhapQuy) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy> findByActive(
        int active) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy> findByActive(
        int active, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy> findByActive(
        int active, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy findByActive_First(
        int active, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.van_ban_phap_quy.NoSuchVanBanPhapQuyException;

    public com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy findByActive_Last(
        int active, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.van_ban_phap_quy.NoSuchVanBanPhapQuyException;

    public com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy[] findByActive_PrevAndNext(
        long maVanBanPhapQuy, int active,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.van_ban_phap_quy.NoSuchVanBanPhapQuyException;

    public java.util.List<com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy> findByMaLoaiVanBan(
        long maLoaiVanBan) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy> findByMaLoaiVanBan(
        long maLoaiVanBan, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy> findByMaLoaiVanBan(
        long maLoaiVanBan, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy findByMaLoaiVanBan_First(
        long maLoaiVanBan, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.van_ban_phap_quy.NoSuchVanBanPhapQuyException;

    public com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy findByMaLoaiVanBan_Last(
        long maLoaiVanBan, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.van_ban_phap_quy.NoSuchVanBanPhapQuyException;

    public com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy[] findByMaLoaiVanBan_PrevAndNext(
        long maVanBanPhapQuy, long maLoaiVanBan,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.van_ban_phap_quy.NoSuchVanBanPhapQuyException;

    public java.util.List<com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy> findByMaLinhVucVanBan(
        long maLinhVucVanBan) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy> findByMaLinhVucVanBan(
        long maLinhVucVanBan, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy> findByMaLinhVucVanBan(
        long maLinhVucVanBan, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy findByMaLinhVucVanBan_First(
        long maLinhVucVanBan,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.van_ban_phap_quy.NoSuchVanBanPhapQuyException;

    public com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy findByMaLinhVucVanBan_Last(
        long maLinhVucVanBan,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.van_ban_phap_quy.NoSuchVanBanPhapQuyException;

    public com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy[] findByMaLinhVucVanBan_PrevAndNext(
        long maVanBanPhapQuy, long maLinhVucVanBan,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.van_ban_phap_quy.NoSuchVanBanPhapQuyException;

    public java.util.List<com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy> findByMaCoQuanBanHanh(
        long maCoQuanBanHanh) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy> findByMaCoQuanBanHanh(
        long maCoQuanBanHanh, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy> findByMaCoQuanBanHanh(
        long maCoQuanBanHanh, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy findByMaCoQuanBanHanh_First(
        long maCoQuanBanHanh,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.van_ban_phap_quy.NoSuchVanBanPhapQuyException;

    public com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy findByMaCoQuanBanHanh_Last(
        long maCoQuanBanHanh,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.van_ban_phap_quy.NoSuchVanBanPhapQuyException;

    public com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy[] findByMaCoQuanBanHanh_PrevAndNext(
        long maVanBanPhapQuy, long maCoQuanBanHanh,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.van_ban_phap_quy.NoSuchVanBanPhapQuyException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeByActive(int active)
        throws com.liferay.portal.SystemException;

    public void removeByMaLoaiVanBan(long maLoaiVanBan)
        throws com.liferay.portal.SystemException;

    public void removeByMaLinhVucVanBan(long maLinhVucVanBan)
        throws com.liferay.portal.SystemException;

    public void removeByMaCoQuanBanHanh(long maCoQuanBanHanh)
        throws com.liferay.portal.SystemException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countByActive(int active)
        throws com.liferay.portal.SystemException;

    public int countByMaLoaiVanBan(long maLoaiVanBan)
        throws com.liferay.portal.SystemException;

    public int countByMaLinhVucVanBan(long maLinhVucVanBan)
        throws com.liferay.portal.SystemException;

    public int countByMaCoQuanBanHanh(long maCoQuanBanHanh)
        throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;
}
