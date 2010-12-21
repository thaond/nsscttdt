package com.nss.portlet.media_library.service.persistence;

public class MediaLibraryUtil {
    private static MediaLibraryPersistence _persistence;

    public static void cacheResult(
        com.nss.portlet.media_library.model.MediaLibrary mediaLibrary) {
        getPersistence().cacheResult(mediaLibrary);
    }

    public static void cacheResult(
        java.util.List<com.nss.portlet.media_library.model.MediaLibrary> mediaLibraries) {
        getPersistence().cacheResult(mediaLibraries);
    }

    public static void clearCache() {
        getPersistence().clearCache();
    }

    public static com.nss.portlet.media_library.model.MediaLibrary create(
        long maMediaLibrary) {
        return getPersistence().create(maMediaLibrary);
    }

    public static com.nss.portlet.media_library.model.MediaLibrary remove(
        long maMediaLibrary)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.media_library.NoSuchMediaLibraryException {
        return getPersistence().remove(maMediaLibrary);
    }

    public static com.nss.portlet.media_library.model.MediaLibrary remove(
        com.nss.portlet.media_library.model.MediaLibrary mediaLibrary)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(mediaLibrary);
    }

    /**
     * @deprecated Use <code>update(MediaLibrary mediaLibrary, boolean merge)</code>.
     */
    public static com.nss.portlet.media_library.model.MediaLibrary update(
        com.nss.portlet.media_library.model.MediaLibrary mediaLibrary)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(mediaLibrary);
    }

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
    public static com.nss.portlet.media_library.model.MediaLibrary update(
        com.nss.portlet.media_library.model.MediaLibrary mediaLibrary,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().update(mediaLibrary, merge);
    }

    public static com.nss.portlet.media_library.model.MediaLibrary updateImpl(
        com.nss.portlet.media_library.model.MediaLibrary mediaLibrary,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(mediaLibrary, merge);
    }

    public static com.nss.portlet.media_library.model.MediaLibrary findByPrimaryKey(
        long maMediaLibrary)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.media_library.NoSuchMediaLibraryException {
        return getPersistence().findByPrimaryKey(maMediaLibrary);
    }

    public static com.nss.portlet.media_library.model.MediaLibrary fetchByPrimaryKey(
        long maMediaLibrary) throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(maMediaLibrary);
    }

    public static java.util.List<com.nss.portlet.media_library.model.MediaLibrary> findByActive(
        boolean active) throws com.liferay.portal.SystemException {
        return getPersistence().findByActive(active);
    }

    public static java.util.List<com.nss.portlet.media_library.model.MediaLibrary> findByActive(
        boolean active, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByActive(active, start, end);
    }

    public static java.util.List<com.nss.portlet.media_library.model.MediaLibrary> findByActive(
        boolean active, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByActive(active, start, end, obc);
    }

    public static com.nss.portlet.media_library.model.MediaLibrary findByActive_First(
        boolean active, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.media_library.NoSuchMediaLibraryException {
        return getPersistence().findByActive_First(active, obc);
    }

    public static com.nss.portlet.media_library.model.MediaLibrary findByActive_Last(
        boolean active, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.media_library.NoSuchMediaLibraryException {
        return getPersistence().findByActive_Last(active, obc);
    }

    public static com.nss.portlet.media_library.model.MediaLibrary[] findByActive_PrevAndNext(
        long maMediaLibrary, boolean active,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.media_library.NoSuchMediaLibraryException {
        return getPersistence()
                   .findByActive_PrevAndNext(maMediaLibrary, active, obc);
    }

    public static java.util.List<com.nss.portlet.media_library.model.MediaLibrary> findByMaMediaChuDe_Active(
        long maMediaChuDe, boolean active)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByMaMediaChuDe_Active(maMediaChuDe, active);
    }

    public static java.util.List<com.nss.portlet.media_library.model.MediaLibrary> findByMaMediaChuDe_Active(
        long maMediaChuDe, boolean active, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByMaMediaChuDe_Active(maMediaChuDe, active, start, end);
    }

    public static java.util.List<com.nss.portlet.media_library.model.MediaLibrary> findByMaMediaChuDe_Active(
        long maMediaChuDe, boolean active, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByMaMediaChuDe_Active(maMediaChuDe, active, start, end,
            obc);
    }

    public static com.nss.portlet.media_library.model.MediaLibrary findByMaMediaChuDe_Active_First(
        long maMediaChuDe, boolean active,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.media_library.NoSuchMediaLibraryException {
        return getPersistence()
                   .findByMaMediaChuDe_Active_First(maMediaChuDe, active, obc);
    }

    public static com.nss.portlet.media_library.model.MediaLibrary findByMaMediaChuDe_Active_Last(
        long maMediaChuDe, boolean active,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.media_library.NoSuchMediaLibraryException {
        return getPersistence()
                   .findByMaMediaChuDe_Active_Last(maMediaChuDe, active, obc);
    }

    public static com.nss.portlet.media_library.model.MediaLibrary[] findByMaMediaChuDe_Active_PrevAndNext(
        long maMediaLibrary, long maMediaChuDe, boolean active,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.media_library.NoSuchMediaLibraryException {
        return getPersistence()
                   .findByMaMediaChuDe_Active_PrevAndNext(maMediaLibrary,
            maMediaChuDe, active, obc);
    }

    public static java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    public static java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    public static java.util.List<com.nss.portlet.media_library.model.MediaLibrary> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.nss.portlet.media_library.model.MediaLibrary> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.nss.portlet.media_library.model.MediaLibrary> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end, obc);
    }

    public static void removeByActive(boolean active)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByActive(active);
    }

    public static void removeByMaMediaChuDe_Active(long maMediaChuDe,
        boolean active) throws com.liferay.portal.SystemException {
        getPersistence().removeByMaMediaChuDe_Active(maMediaChuDe, active);
    }

    public static void removeAll() throws com.liferay.portal.SystemException {
        getPersistence().removeAll();
    }

    public static int countByActive(boolean active)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByActive(active);
    }

    public static int countByMaMediaChuDe_Active(long maMediaChuDe,
        boolean active) throws com.liferay.portal.SystemException {
        return getPersistence().countByMaMediaChuDe_Active(maMediaChuDe, active);
    }

    public static int countAll() throws com.liferay.portal.SystemException {
        return getPersistence().countAll();
    }

    public static MediaLibraryPersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(MediaLibraryPersistence persistence) {
        _persistence = persistence;
    }
}
