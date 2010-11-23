package com.nss.portlet.link.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;


public interface LoaiWebsitePersistence extends BasePersistence {
    public void cacheResult(com.nss.portlet.link.model.LoaiWebsite loaiWebsite);

    public void cacheResult(
        java.util.List<com.nss.portlet.link.model.LoaiWebsite> loaiWebsites);

    public void clearCache();

    public com.nss.portlet.link.model.LoaiWebsite create(long maLoaiWebsite);

    public com.nss.portlet.link.model.LoaiWebsite remove(long maLoaiWebsite)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.link.NoSuchLoaiWebsiteException;

    public com.nss.portlet.link.model.LoaiWebsite remove(
        com.nss.portlet.link.model.LoaiWebsite loaiWebsite)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(LoaiWebsite loaiWebsite, boolean merge)</code>.
     */
    public com.nss.portlet.link.model.LoaiWebsite update(
        com.nss.portlet.link.model.LoaiWebsite loaiWebsite)
        throws com.liferay.portal.SystemException;

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                loaiWebsite the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when loaiWebsite is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public com.nss.portlet.link.model.LoaiWebsite update(
        com.nss.portlet.link.model.LoaiWebsite loaiWebsite, boolean merge)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.link.model.LoaiWebsite updateImpl(
        com.nss.portlet.link.model.LoaiWebsite loaiWebsite, boolean merge)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.link.model.LoaiWebsite findByPrimaryKey(
        long maLoaiWebsite)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.link.NoSuchLoaiWebsiteException;

    public com.nss.portlet.link.model.LoaiWebsite fetchByPrimaryKey(
        long maLoaiWebsite) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.link.model.LoaiWebsite> findByActive(
        int active) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.link.model.LoaiWebsite> findByActive(
        int active, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.link.model.LoaiWebsite> findByActive(
        int active, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.link.model.LoaiWebsite findByActive_First(
        int active, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.link.NoSuchLoaiWebsiteException;

    public com.nss.portlet.link.model.LoaiWebsite findByActive_Last(
        int active, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.link.NoSuchLoaiWebsiteException;

    public com.nss.portlet.link.model.LoaiWebsite[] findByActive_PrevAndNext(
        long maLoaiWebsite, int active,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.link.NoSuchLoaiWebsiteException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.link.model.LoaiWebsite> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.link.model.LoaiWebsite> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.link.model.LoaiWebsite> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeByActive(int active)
        throws com.liferay.portal.SystemException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countByActive(int active)
        throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;
}
