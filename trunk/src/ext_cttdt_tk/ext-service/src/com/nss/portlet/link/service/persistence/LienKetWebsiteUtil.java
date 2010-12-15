package com.nss.portlet.link.service.persistence;

public class LienKetWebsiteUtil {
    private static LienKetWebsitePersistence _persistence;

    public static void cacheResult(
        com.nss.portlet.link.model.LienKetWebsite lienKetWebsite) {
        getPersistence().cacheResult(lienKetWebsite);
    }

    public static void cacheResult(
        java.util.List<com.nss.portlet.link.model.LienKetWebsite> lienKetWebsites) {
        getPersistence().cacheResult(lienKetWebsites);
    }

    public static void clearCache() {
        getPersistence().clearCache();
    }

    public static com.nss.portlet.link.model.LienKetWebsite create(
        long maWebsite) {
        return getPersistence().create(maWebsite);
    }

    public static com.nss.portlet.link.model.LienKetWebsite remove(
        long maWebsite)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.link.NoSuchLienKetWebsiteException {
        return getPersistence().remove(maWebsite);
    }

    public static com.nss.portlet.link.model.LienKetWebsite remove(
        com.nss.portlet.link.model.LienKetWebsite lienKetWebsite)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(lienKetWebsite);
    }

    /**
     * @deprecated Use <code>update(LienKetWebsite lienKetWebsite, boolean merge)</code>.
     */
    public static com.nss.portlet.link.model.LienKetWebsite update(
        com.nss.portlet.link.model.LienKetWebsite lienKetWebsite)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(lienKetWebsite);
    }

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
    public static com.nss.portlet.link.model.LienKetWebsite update(
        com.nss.portlet.link.model.LienKetWebsite lienKetWebsite, boolean merge)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(lienKetWebsite, merge);
    }

    public static com.nss.portlet.link.model.LienKetWebsite updateImpl(
        com.nss.portlet.link.model.LienKetWebsite lienKetWebsite, boolean merge)
        throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(lienKetWebsite, merge);
    }

    public static com.nss.portlet.link.model.LienKetWebsite findByPrimaryKey(
        long maWebsite)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.link.NoSuchLienKetWebsiteException {
        return getPersistence().findByPrimaryKey(maWebsite);
    }

    public static com.nss.portlet.link.model.LienKetWebsite fetchByPrimaryKey(
        long maWebsite) throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(maWebsite);
    }

    public static java.util.List<com.nss.portlet.link.model.LienKetWebsite> findByLoaiWebsiteId(
        long loaiWebsite) throws com.liferay.portal.SystemException {
        return getPersistence().findByLoaiWebsiteId(loaiWebsite);
    }

    public static java.util.List<com.nss.portlet.link.model.LienKetWebsite> findByLoaiWebsiteId(
        long loaiWebsite, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByLoaiWebsiteId(loaiWebsite, start, end);
    }

    public static java.util.List<com.nss.portlet.link.model.LienKetWebsite> findByLoaiWebsiteId(
        long loaiWebsite, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByLoaiWebsiteId(loaiWebsite, start, end, obc);
    }

    public static com.nss.portlet.link.model.LienKetWebsite findByLoaiWebsiteId_First(
        long loaiWebsite, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.link.NoSuchLienKetWebsiteException {
        return getPersistence().findByLoaiWebsiteId_First(loaiWebsite, obc);
    }

    public static com.nss.portlet.link.model.LienKetWebsite findByLoaiWebsiteId_Last(
        long loaiWebsite, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.link.NoSuchLienKetWebsiteException {
        return getPersistence().findByLoaiWebsiteId_Last(loaiWebsite, obc);
    }

    public static com.nss.portlet.link.model.LienKetWebsite[] findByLoaiWebsiteId_PrevAndNext(
        long maWebsite, long loaiWebsite,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.link.NoSuchLienKetWebsiteException {
        return getPersistence()
                   .findByLoaiWebsiteId_PrevAndNext(maWebsite, loaiWebsite, obc);
    }

    public static java.util.List<com.nss.portlet.link.model.LienKetWebsite> findByActive(
        int active) throws com.liferay.portal.SystemException {
        return getPersistence().findByActive(active);
    }

    public static java.util.List<com.nss.portlet.link.model.LienKetWebsite> findByActive(
        int active, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByActive(active, start, end);
    }

    public static java.util.List<com.nss.portlet.link.model.LienKetWebsite> findByActive(
        int active, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByActive(active, start, end, obc);
    }

    public static com.nss.portlet.link.model.LienKetWebsite findByActive_First(
        int active, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.link.NoSuchLienKetWebsiteException {
        return getPersistence().findByActive_First(active, obc);
    }

    public static com.nss.portlet.link.model.LienKetWebsite findByActive_Last(
        int active, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.link.NoSuchLienKetWebsiteException {
        return getPersistence().findByActive_Last(active, obc);
    }

    public static com.nss.portlet.link.model.LienKetWebsite[] findByActive_PrevAndNext(
        long maWebsite, int active,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.link.NoSuchLienKetWebsiteException {
        return getPersistence().findByActive_PrevAndNext(maWebsite, active, obc);
    }

    public static java.util.List<com.nss.portlet.link.model.LienKetWebsite> findByLoaiWebsiteId_Active(
        long loaiWebsite, int active) throws com.liferay.portal.SystemException {
        return getPersistence().findByLoaiWebsiteId_Active(loaiWebsite, active);
    }

    public static java.util.List<com.nss.portlet.link.model.LienKetWebsite> findByLoaiWebsiteId_Active(
        long loaiWebsite, int active, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByLoaiWebsiteId_Active(loaiWebsite, active, start, end);
    }

    public static java.util.List<com.nss.portlet.link.model.LienKetWebsite> findByLoaiWebsiteId_Active(
        long loaiWebsite, int active, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByLoaiWebsiteId_Active(loaiWebsite, active, start, end,
            obc);
    }

    public static com.nss.portlet.link.model.LienKetWebsite findByLoaiWebsiteId_Active_First(
        long loaiWebsite, int active,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.link.NoSuchLienKetWebsiteException {
        return getPersistence()
                   .findByLoaiWebsiteId_Active_First(loaiWebsite, active, obc);
    }

    public static com.nss.portlet.link.model.LienKetWebsite findByLoaiWebsiteId_Active_Last(
        long loaiWebsite, int active,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.link.NoSuchLienKetWebsiteException {
        return getPersistence()
                   .findByLoaiWebsiteId_Active_Last(loaiWebsite, active, obc);
    }

    public static com.nss.portlet.link.model.LienKetWebsite[] findByLoaiWebsiteId_Active_PrevAndNext(
        long maWebsite, long loaiWebsite, int active,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.link.NoSuchLienKetWebsiteException {
        return getPersistence()
                   .findByLoaiWebsiteId_Active_PrevAndNext(maWebsite,
            loaiWebsite, active, obc);
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

    public static java.util.List<com.nss.portlet.link.model.LienKetWebsite> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.nss.portlet.link.model.LienKetWebsite> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.nss.portlet.link.model.LienKetWebsite> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end, obc);
    }

    public static void removeByLoaiWebsiteId(long loaiWebsite)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByLoaiWebsiteId(loaiWebsite);
    }

    public static void removeByActive(int active)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByActive(active);
    }

    public static void removeByLoaiWebsiteId_Active(long loaiWebsite, int active)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByLoaiWebsiteId_Active(loaiWebsite, active);
    }

    public static void removeAll() throws com.liferay.portal.SystemException {
        getPersistence().removeAll();
    }

    public static int countByLoaiWebsiteId(long loaiWebsite)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByLoaiWebsiteId(loaiWebsite);
    }

    public static int countByActive(int active)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByActive(active);
    }

    public static int countByLoaiWebsiteId_Active(long loaiWebsite, int active)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByLoaiWebsiteId_Active(loaiWebsite, active);
    }

    public static int countAll() throws com.liferay.portal.SystemException {
        return getPersistence().countAll();
    }

    public static LienKetWebsitePersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(LienKetWebsitePersistence persistence) {
        _persistence = persistence;
    }
}
