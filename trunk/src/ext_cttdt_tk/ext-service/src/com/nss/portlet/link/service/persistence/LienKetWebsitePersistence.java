package com.nss.portlet.link.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;


public interface LienKetWebsitePersistence extends BasePersistence {
    public void cacheResult(
        com.nss.portlet.link.model.LienKetWebsite lienKetWebsite);

    public void cacheResult(
        java.util.List<com.nss.portlet.link.model.LienKetWebsite> lienKetWebsites);

    public void clearCache();

    public com.nss.portlet.link.model.LienKetWebsite create(long maWebsite);

    public com.nss.portlet.link.model.LienKetWebsite remove(long maWebsite)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.link.NoSuchLienKetWebsiteException;

    public com.nss.portlet.link.model.LienKetWebsite remove(
        com.nss.portlet.link.model.LienKetWebsite lienKetWebsite)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(LienKetWebsite lienKetWebsite, boolean merge)</code>.
     */
    public com.nss.portlet.link.model.LienKetWebsite update(
        com.nss.portlet.link.model.LienKetWebsite lienKetWebsite)
        throws com.liferay.portal.SystemException;

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                lienKetWebsite the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when lienKetWebsite is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public com.nss.portlet.link.model.LienKetWebsite update(
        com.nss.portlet.link.model.LienKetWebsite lienKetWebsite, boolean merge)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.link.model.LienKetWebsite updateImpl(
        com.nss.portlet.link.model.LienKetWebsite lienKetWebsite, boolean merge)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.link.model.LienKetWebsite findByPrimaryKey(
        long maWebsite)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.link.NoSuchLienKetWebsiteException;

    public com.nss.portlet.link.model.LienKetWebsite fetchByPrimaryKey(
        long maWebsite) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.link.model.LienKetWebsite> findByLoaiWebsiteId(
        long loaiWebsite) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.link.model.LienKetWebsite> findByLoaiWebsiteId(
        long loaiWebsite, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.link.model.LienKetWebsite> findByLoaiWebsiteId(
        long loaiWebsite, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.link.model.LienKetWebsite findByLoaiWebsiteId_First(
        long loaiWebsite, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.link.NoSuchLienKetWebsiteException;

    public com.nss.portlet.link.model.LienKetWebsite findByLoaiWebsiteId_Last(
        long loaiWebsite, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.link.NoSuchLienKetWebsiteException;

    public com.nss.portlet.link.model.LienKetWebsite[] findByLoaiWebsiteId_PrevAndNext(
        long maWebsite, long loaiWebsite,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.link.NoSuchLienKetWebsiteException;

    public java.util.List<com.nss.portlet.link.model.LienKetWebsite> findByActive(
        int active) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.link.model.LienKetWebsite> findByActive(
        int active, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.link.model.LienKetWebsite> findByActive(
        int active, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.link.model.LienKetWebsite findByActive_First(
        int active, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.link.NoSuchLienKetWebsiteException;

    public com.nss.portlet.link.model.LienKetWebsite findByActive_Last(
        int active, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.link.NoSuchLienKetWebsiteException;

    public com.nss.portlet.link.model.LienKetWebsite[] findByActive_PrevAndNext(
        long maWebsite, int active,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.link.NoSuchLienKetWebsiteException;

    public java.util.List<com.nss.portlet.link.model.LienKetWebsite> findByLoaiWebsiteId_Active(
        long loaiWebsite, int active) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.link.model.LienKetWebsite> findByLoaiWebsiteId_Active(
        long loaiWebsite, int active, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.link.model.LienKetWebsite> findByLoaiWebsiteId_Active(
        long loaiWebsite, int active, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.link.model.LienKetWebsite findByLoaiWebsiteId_Active_First(
        long loaiWebsite, int active,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.link.NoSuchLienKetWebsiteException;

    public com.nss.portlet.link.model.LienKetWebsite findByLoaiWebsiteId_Active_Last(
        long loaiWebsite, int active,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.link.NoSuchLienKetWebsiteException;

    public com.nss.portlet.link.model.LienKetWebsite[] findByLoaiWebsiteId_Active_PrevAndNext(
        long maWebsite, long loaiWebsite, int active,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.link.NoSuchLienKetWebsiteException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.link.model.LienKetWebsite> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.link.model.LienKetWebsite> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.link.model.LienKetWebsite> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeByLoaiWebsiteId(long loaiWebsite)
        throws com.liferay.portal.SystemException;

    public void removeByActive(int active)
        throws com.liferay.portal.SystemException;

    public void removeByLoaiWebsiteId_Active(long loaiWebsite, int active)
        throws com.liferay.portal.SystemException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countByLoaiWebsiteId(long loaiWebsite)
        throws com.liferay.portal.SystemException;

    public int countByActive(int active)
        throws com.liferay.portal.SystemException;

    public int countByLoaiWebsiteId_Active(long loaiWebsite, int active)
        throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;
}
