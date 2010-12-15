package com.nss.portlet.thong_tin_lien_quan.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;


public interface ThongTinLienQuanPersistence extends BasePersistence {
    public void cacheResult(
        com.nss.portlet.thong_tin_lien_quan.model.ThongTinLienQuan thongTinLienQuan);

    public void cacheResult(
        java.util.List<com.nss.portlet.thong_tin_lien_quan.model.ThongTinLienQuan> thongTinLienQuans);

    public void clearCache();

    public com.nss.portlet.thong_tin_lien_quan.model.ThongTinLienQuan create(
        long maThongTinLienQuan);

    public com.nss.portlet.thong_tin_lien_quan.model.ThongTinLienQuan remove(
        long maThongTinLienQuan)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.thong_tin_lien_quan.NoSuchThongTinLienQuanException;

    public com.nss.portlet.thong_tin_lien_quan.model.ThongTinLienQuan remove(
        com.nss.portlet.thong_tin_lien_quan.model.ThongTinLienQuan thongTinLienQuan)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(ThongTinLienQuan thongTinLienQuan, boolean merge)</code>.
     */
    public com.nss.portlet.thong_tin_lien_quan.model.ThongTinLienQuan update(
        com.nss.portlet.thong_tin_lien_quan.model.ThongTinLienQuan thongTinLienQuan)
        throws com.liferay.portal.SystemException;

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                thongTinLienQuan the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when thongTinLienQuan is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public com.nss.portlet.thong_tin_lien_quan.model.ThongTinLienQuan update(
        com.nss.portlet.thong_tin_lien_quan.model.ThongTinLienQuan thongTinLienQuan,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.nss.portlet.thong_tin_lien_quan.model.ThongTinLienQuan updateImpl(
        com.nss.portlet.thong_tin_lien_quan.model.ThongTinLienQuan thongTinLienQuan,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.nss.portlet.thong_tin_lien_quan.model.ThongTinLienQuan findByPrimaryKey(
        long maThongTinLienQuan)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.thong_tin_lien_quan.NoSuchThongTinLienQuanException;

    public com.nss.portlet.thong_tin_lien_quan.model.ThongTinLienQuan fetchByPrimaryKey(
        long maThongTinLienQuan) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.thong_tin_lien_quan.model.ThongTinLienQuan> findByActive(
        int active) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.thong_tin_lien_quan.model.ThongTinLienQuan> findByActive(
        int active, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.thong_tin_lien_quan.model.ThongTinLienQuan> findByActive(
        int active, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.thong_tin_lien_quan.model.ThongTinLienQuan findByActive_First(
        int active, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.thong_tin_lien_quan.NoSuchThongTinLienQuanException;

    public com.nss.portlet.thong_tin_lien_quan.model.ThongTinLienQuan findByActive_Last(
        int active, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.thong_tin_lien_quan.NoSuchThongTinLienQuanException;

    public com.nss.portlet.thong_tin_lien_quan.model.ThongTinLienQuan[] findByActive_PrevAndNext(
        long maThongTinLienQuan, int active,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.thong_tin_lien_quan.NoSuchThongTinLienQuanException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.thong_tin_lien_quan.model.ThongTinLienQuan> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.thong_tin_lien_quan.model.ThongTinLienQuan> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.thong_tin_lien_quan.model.ThongTinLienQuan> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeByActive(int active)
        throws com.liferay.portal.SystemException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countByActive(int active)
        throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;
}
