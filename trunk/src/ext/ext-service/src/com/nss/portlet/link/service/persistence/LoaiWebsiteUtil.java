package com.nss.portlet.link.service.persistence;

public class LoaiWebsiteUtil {
    private static LoaiWebsitePersistence _persistence;

    public static void cacheResult(
        com.nss.portlet.link.model.LoaiWebsite loaiWebsite) {
        getPersistence().cacheResult(loaiWebsite);
    }

    public static void cacheResult(
        java.util.List<com.nss.portlet.link.model.LoaiWebsite> loaiWebsites) {
        getPersistence().cacheResult(loaiWebsites);
    }

    public static void clearCache() {
        getPersistence().clearCache();
    }

    public static com.nss.portlet.link.model.LoaiWebsite create(
        long maLoaiWebsite) {
        return getPersistence().create(maLoaiWebsite);
    }

    public static com.nss.portlet.link.model.LoaiWebsite remove(
        long maLoaiWebsite)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.link.NoSuchLoaiWebsiteException {
        return getPersistence().remove(maLoaiWebsite);
    }

    public static com.nss.portlet.link.model.LoaiWebsite remove(
        com.nss.portlet.link.model.LoaiWebsite loaiWebsite)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(loaiWebsite);
    }

    /**
     * @deprecated Use <code>update(LoaiWebsite loaiWebsite, boolean merge)</code>.
     */
    public static com.nss.portlet.link.model.LoaiWebsite update(
        com.nss.portlet.link.model.LoaiWebsite loaiWebsite)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(loaiWebsite);
    }

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
    public static com.nss.portlet.link.model.LoaiWebsite update(
        com.nss.portlet.link.model.LoaiWebsite loaiWebsite, boolean merge)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(loaiWebsite, merge);
    }

    public static com.nss.portlet.link.model.LoaiWebsite updateImpl(
        com.nss.portlet.link.model.LoaiWebsite loaiWebsite, boolean merge)
        throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(loaiWebsite, merge);
    }

    public static com.nss.portlet.link.model.LoaiWebsite findByPrimaryKey(
        long maLoaiWebsite)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.link.NoSuchLoaiWebsiteException {
        return getPersistence().findByPrimaryKey(maLoaiWebsite);
    }

    public static com.nss.portlet.link.model.LoaiWebsite fetchByPrimaryKey(
        long maLoaiWebsite) throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(maLoaiWebsite);
    }

    public static java.util.List<com.nss.portlet.link.model.LoaiWebsite> findByActive(
        int active) throws com.liferay.portal.SystemException {
        return getPersistence().findByActive(active);
    }

    public static java.util.List<com.nss.portlet.link.model.LoaiWebsite> findByActive(
        int active, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByActive(active, start, end);
    }

    public static java.util.List<com.nss.portlet.link.model.LoaiWebsite> findByActive(
        int active, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByActive(active, start, end, obc);
    }

    public static com.nss.portlet.link.model.LoaiWebsite findByActive_First(
        int active, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.link.NoSuchLoaiWebsiteException {
        return getPersistence().findByActive_First(active, obc);
    }

    public static com.nss.portlet.link.model.LoaiWebsite findByActive_Last(
        int active, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.link.NoSuchLoaiWebsiteException {
        return getPersistence().findByActive_Last(active, obc);
    }

    public static com.nss.portlet.link.model.LoaiWebsite[] findByActive_PrevAndNext(
        long maLoaiWebsite, int active,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.link.NoSuchLoaiWebsiteException {
        return getPersistence()
                   .findByActive_PrevAndNext(maLoaiWebsite, active, obc);
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

    public static java.util.List<com.nss.portlet.link.model.LoaiWebsite> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.nss.portlet.link.model.LoaiWebsite> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.nss.portlet.link.model.LoaiWebsite> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end, obc);
    }

    public static void removeByActive(int active)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByActive(active);
    }

    public static void removeAll() throws com.liferay.portal.SystemException {
        getPersistence().removeAll();
    }

    public static int countByActive(int active)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByActive(active);
    }

    public static int countAll() throws com.liferay.portal.SystemException {
        return getPersistence().countAll();
    }

    public static LoaiWebsitePersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(LoaiWebsitePersistence persistence) {
        _persistence = persistence;
    }
}
