package com.nss.portlet.media_library.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;


public interface MediaLibraryPersistence extends BasePersistence {
    public void cacheResult(
        com.nss.portlet.media_library.model.MediaLibrary mediaLibrary);

    public void cacheResult(
        java.util.List<com.nss.portlet.media_library.model.MediaLibrary> mediaLibraries);

    public void clearCache();

    public com.nss.portlet.media_library.model.MediaLibrary create(
        long maMediaLibrary);

    public com.nss.portlet.media_library.model.MediaLibrary remove(
        long maMediaLibrary)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.media_library.NoSuchMediaLibraryException;

    public com.nss.portlet.media_library.model.MediaLibrary remove(
        com.nss.portlet.media_library.model.MediaLibrary mediaLibrary)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(MediaLibrary mediaLibrary, boolean merge)</code>.
     */
    public com.nss.portlet.media_library.model.MediaLibrary update(
        com.nss.portlet.media_library.model.MediaLibrary mediaLibrary)
        throws com.liferay.portal.SystemException;

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                mediaLibrary the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when mediaLibrary is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public com.nss.portlet.media_library.model.MediaLibrary update(
        com.nss.portlet.media_library.model.MediaLibrary mediaLibrary,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.nss.portlet.media_library.model.MediaLibrary updateImpl(
        com.nss.portlet.media_library.model.MediaLibrary mediaLibrary,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.nss.portlet.media_library.model.MediaLibrary findByPrimaryKey(
        long maMediaLibrary)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.media_library.NoSuchMediaLibraryException;

    public com.nss.portlet.media_library.model.MediaLibrary fetchByPrimaryKey(
        long maMediaLibrary) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.media_library.model.MediaLibrary> findByActive(
        boolean active) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.media_library.model.MediaLibrary> findByActive(
        boolean active, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.media_library.model.MediaLibrary> findByActive(
        boolean active, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.media_library.model.MediaLibrary findByActive_First(
        boolean active, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.media_library.NoSuchMediaLibraryException;

    public com.nss.portlet.media_library.model.MediaLibrary findByActive_Last(
        boolean active, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.media_library.NoSuchMediaLibraryException;

    public com.nss.portlet.media_library.model.MediaLibrary[] findByActive_PrevAndNext(
        long maMediaLibrary, boolean active,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.media_library.NoSuchMediaLibraryException;

    public java.util.List<com.nss.portlet.media_library.model.MediaLibrary> findByMaMediaChuDe_Active(
        long maMediaChuDe, boolean active)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.media_library.model.MediaLibrary> findByMaMediaChuDe_Active(
        long maMediaChuDe, boolean active, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.media_library.model.MediaLibrary> findByMaMediaChuDe_Active(
        long maMediaChuDe, boolean active, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.media_library.model.MediaLibrary findByMaMediaChuDe_Active_First(
        long maMediaChuDe, boolean active,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.media_library.NoSuchMediaLibraryException;

    public com.nss.portlet.media_library.model.MediaLibrary findByMaMediaChuDe_Active_Last(
        long maMediaChuDe, boolean active,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.media_library.NoSuchMediaLibraryException;

    public com.nss.portlet.media_library.model.MediaLibrary[] findByMaMediaChuDe_Active_PrevAndNext(
        long maMediaLibrary, long maMediaChuDe, boolean active,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.media_library.NoSuchMediaLibraryException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.media_library.model.MediaLibrary> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.media_library.model.MediaLibrary> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.media_library.model.MediaLibrary> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeByActive(boolean active)
        throws com.liferay.portal.SystemException;

    public void removeByMaMediaChuDe_Active(long maMediaChuDe, boolean active)
        throws com.liferay.portal.SystemException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countByActive(boolean active)
        throws com.liferay.portal.SystemException;

    public int countByMaMediaChuDe_Active(long maMediaChuDe, boolean active)
        throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;
}
