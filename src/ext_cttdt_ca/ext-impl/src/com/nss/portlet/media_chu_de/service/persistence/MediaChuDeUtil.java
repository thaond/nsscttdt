package com.nss.portlet.media_chu_de.service.persistence;

public class MediaChuDeUtil {
    private static MediaChuDePersistence _persistence;

    public static void cacheResult(
        com.nss.portlet.media_chu_de.model.MediaChuDe mediaChuDe) {
        getPersistence().cacheResult(mediaChuDe);
    }

    public static void cacheResult(
        java.util.List<com.nss.portlet.media_chu_de.model.MediaChuDe> mediaChuDes) {
        getPersistence().cacheResult(mediaChuDes);
    }

    public static void clearCache() {
        getPersistence().clearCache();
    }

    public static com.nss.portlet.media_chu_de.model.MediaChuDe create(
        long maMediaChuDe) {
        return getPersistence().create(maMediaChuDe);
    }

    public static com.nss.portlet.media_chu_de.model.MediaChuDe remove(
        long maMediaChuDe)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.media_chu_de.NoSuchMediaChuDeException {
        return getPersistence().remove(maMediaChuDe);
    }

    public static com.nss.portlet.media_chu_de.model.MediaChuDe remove(
        com.nss.portlet.media_chu_de.model.MediaChuDe mediaChuDe)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(mediaChuDe);
    }

    /**
     * @deprecated Use <code>update(MediaChuDe mediaChuDe, boolean merge)</code>.
     */
    public static com.nss.portlet.media_chu_de.model.MediaChuDe update(
        com.nss.portlet.media_chu_de.model.MediaChuDe mediaChuDe)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(mediaChuDe);
    }

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
    public static com.nss.portlet.media_chu_de.model.MediaChuDe update(
        com.nss.portlet.media_chu_de.model.MediaChuDe mediaChuDe, boolean merge)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(mediaChuDe, merge);
    }

    public static com.nss.portlet.media_chu_de.model.MediaChuDe updateImpl(
        com.nss.portlet.media_chu_de.model.MediaChuDe mediaChuDe, boolean merge)
        throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(mediaChuDe, merge);
    }

    public static com.nss.portlet.media_chu_de.model.MediaChuDe findByPrimaryKey(
        long maMediaChuDe)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.media_chu_de.NoSuchMediaChuDeException {
        return getPersistence().findByPrimaryKey(maMediaChuDe);
    }

    public static com.nss.portlet.media_chu_de.model.MediaChuDe fetchByPrimaryKey(
        long maMediaChuDe) throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(maMediaChuDe);
    }

    public static java.util.List<com.nss.portlet.media_chu_de.model.MediaChuDe> findByActive(
        boolean active) throws com.liferay.portal.SystemException {
        return getPersistence().findByActive(active);
    }

    public static java.util.List<com.nss.portlet.media_chu_de.model.MediaChuDe> findByActive(
        boolean active, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByActive(active, start, end);
    }

    public static java.util.List<com.nss.portlet.media_chu_de.model.MediaChuDe> findByActive(
        boolean active, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByActive(active, start, end, obc);
    }

    public static com.nss.portlet.media_chu_de.model.MediaChuDe findByActive_First(
        boolean active, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.media_chu_de.NoSuchMediaChuDeException {
        return getPersistence().findByActive_First(active, obc);
    }

    public static com.nss.portlet.media_chu_de.model.MediaChuDe findByActive_Last(
        boolean active, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.media_chu_de.NoSuchMediaChuDeException {
        return getPersistence().findByActive_Last(active, obc);
    }

    public static com.nss.portlet.media_chu_de.model.MediaChuDe[] findByActive_PrevAndNext(
        long maMediaChuDe, boolean active,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.media_chu_de.NoSuchMediaChuDeException {
        return getPersistence()
                   .findByActive_PrevAndNext(maMediaChuDe, active, obc);
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

    public static java.util.List<com.nss.portlet.media_chu_de.model.MediaChuDe> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.nss.portlet.media_chu_de.model.MediaChuDe> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.nss.portlet.media_chu_de.model.MediaChuDe> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end, obc);
    }

    public static void removeByActive(boolean active)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByActive(active);
    }

    public static void removeAll() throws com.liferay.portal.SystemException {
        getPersistence().removeAll();
    }

    public static int countByActive(boolean active)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByActive(active);
    }

    public static int countAll() throws com.liferay.portal.SystemException {
        return getPersistence().countAll();
    }

    public static MediaChuDePersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(MediaChuDePersistence persistence) {
        _persistence = persistence;
    }
}
