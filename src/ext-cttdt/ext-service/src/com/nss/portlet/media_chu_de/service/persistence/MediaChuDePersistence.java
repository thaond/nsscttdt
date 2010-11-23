package com.nss.portlet.media_chu_de.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;


public interface MediaChuDePersistence extends BasePersistence {
    public void cacheResult(
        com.nss.portlet.media_chu_de.model.MediaChuDe mediaChuDe);

    public void cacheResult(
        java.util.List<com.nss.portlet.media_chu_de.model.MediaChuDe> mediaChuDes);

    public void clearCache();

    public com.nss.portlet.media_chu_de.model.MediaChuDe create(
        long maMediaChuDe);

    public com.nss.portlet.media_chu_de.model.MediaChuDe remove(
        long maMediaChuDe)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.media_chu_de.NoSuchMediaChuDeException;

    public com.nss.portlet.media_chu_de.model.MediaChuDe remove(
        com.nss.portlet.media_chu_de.model.MediaChuDe mediaChuDe)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(MediaChuDe mediaChuDe, boolean merge)</code>.
     */
    public com.nss.portlet.media_chu_de.model.MediaChuDe update(
        com.nss.portlet.media_chu_de.model.MediaChuDe mediaChuDe)
        throws com.liferay.portal.SystemException;

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                mediaChuDe the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when mediaChuDe is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public com.nss.portlet.media_chu_de.model.MediaChuDe update(
        com.nss.portlet.media_chu_de.model.MediaChuDe mediaChuDe, boolean merge)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.media_chu_de.model.MediaChuDe updateImpl(
        com.nss.portlet.media_chu_de.model.MediaChuDe mediaChuDe, boolean merge)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.media_chu_de.model.MediaChuDe findByPrimaryKey(
        long maMediaChuDe)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.media_chu_de.NoSuchMediaChuDeException;

    public com.nss.portlet.media_chu_de.model.MediaChuDe fetchByPrimaryKey(
        long maMediaChuDe) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.media_chu_de.model.MediaChuDe> findByActive(
        boolean active) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.media_chu_de.model.MediaChuDe> findByActive(
        boolean active, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.media_chu_de.model.MediaChuDe> findByActive(
        boolean active, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.media_chu_de.model.MediaChuDe findByActive_First(
        boolean active, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.media_chu_de.NoSuchMediaChuDeException;

    public com.nss.portlet.media_chu_de.model.MediaChuDe findByActive_Last(
        boolean active, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.media_chu_de.NoSuchMediaChuDeException;

    public com.nss.portlet.media_chu_de.model.MediaChuDe[] findByActive_PrevAndNext(
        long maMediaChuDe, boolean active,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.media_chu_de.NoSuchMediaChuDeException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.media_chu_de.model.MediaChuDe> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.media_chu_de.model.MediaChuDe> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.media_chu_de.model.MediaChuDe> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeByActive(boolean active)
        throws com.liferay.portal.SystemException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countByActive(boolean active)
        throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;
}
