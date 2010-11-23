package com.nss.portlet.co_quan_ban_hanh.service.persistence;

public class CoQuanBanHanhUtil {
    private static CoQuanBanHanhPersistence _persistence;

    public static void cacheResult(
        com.nss.portlet.co_quan_ban_hanh.model.CoQuanBanHanh coQuanBanHanh) {
        getPersistence().cacheResult(coQuanBanHanh);
    }

    public static void cacheResult(
        java.util.List<com.nss.portlet.co_quan_ban_hanh.model.CoQuanBanHanh> coQuanBanHanhs) {
        getPersistence().cacheResult(coQuanBanHanhs);
    }

    public static void clearCache() {
        getPersistence().clearCache();
    }

    public static com.nss.portlet.co_quan_ban_hanh.model.CoQuanBanHanh create(
        long maCoQuanBanHanh) {
        return getPersistence().create(maCoQuanBanHanh);
    }

    public static com.nss.portlet.co_quan_ban_hanh.model.CoQuanBanHanh remove(
        long maCoQuanBanHanh)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.co_quan_ban_hanh.NoSuchCoQuanBanHanhException {
        return getPersistence().remove(maCoQuanBanHanh);
    }

    public static com.nss.portlet.co_quan_ban_hanh.model.CoQuanBanHanh remove(
        com.nss.portlet.co_quan_ban_hanh.model.CoQuanBanHanh coQuanBanHanh)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(coQuanBanHanh);
    }

    /**
     * @deprecated Use <code>update(CoQuanBanHanh coQuanBanHanh, boolean merge)</code>.
     */
    public static com.nss.portlet.co_quan_ban_hanh.model.CoQuanBanHanh update(
        com.nss.portlet.co_quan_ban_hanh.model.CoQuanBanHanh coQuanBanHanh)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(coQuanBanHanh);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                coQuanBanHanh the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when coQuanBanHanh is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public static com.nss.portlet.co_quan_ban_hanh.model.CoQuanBanHanh update(
        com.nss.portlet.co_quan_ban_hanh.model.CoQuanBanHanh coQuanBanHanh,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().update(coQuanBanHanh, merge);
    }

    public static com.nss.portlet.co_quan_ban_hanh.model.CoQuanBanHanh updateImpl(
        com.nss.portlet.co_quan_ban_hanh.model.CoQuanBanHanh coQuanBanHanh,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(coQuanBanHanh, merge);
    }

    public static com.nss.portlet.co_quan_ban_hanh.model.CoQuanBanHanh findByPrimaryKey(
        long maCoQuanBanHanh)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.co_quan_ban_hanh.NoSuchCoQuanBanHanhException {
        return getPersistence().findByPrimaryKey(maCoQuanBanHanh);
    }

    public static com.nss.portlet.co_quan_ban_hanh.model.CoQuanBanHanh fetchByPrimaryKey(
        long maCoQuanBanHanh) throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(maCoQuanBanHanh);
    }

    public static java.util.List<com.nss.portlet.co_quan_ban_hanh.model.CoQuanBanHanh> findByActive(
        int active) throws com.liferay.portal.SystemException {
        return getPersistence().findByActive(active);
    }

    public static java.util.List<com.nss.portlet.co_quan_ban_hanh.model.CoQuanBanHanh> findByActive(
        int active, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByActive(active, start, end);
    }

    public static java.util.List<com.nss.portlet.co_quan_ban_hanh.model.CoQuanBanHanh> findByActive(
        int active, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByActive(active, start, end, obc);
    }

    public static com.nss.portlet.co_quan_ban_hanh.model.CoQuanBanHanh findByActive_First(
        int active, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.co_quan_ban_hanh.NoSuchCoQuanBanHanhException {
        return getPersistence().findByActive_First(active, obc);
    }

    public static com.nss.portlet.co_quan_ban_hanh.model.CoQuanBanHanh findByActive_Last(
        int active, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.co_quan_ban_hanh.NoSuchCoQuanBanHanhException {
        return getPersistence().findByActive_Last(active, obc);
    }

    public static com.nss.portlet.co_quan_ban_hanh.model.CoQuanBanHanh[] findByActive_PrevAndNext(
        long maCoQuanBanHanh, int active,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.co_quan_ban_hanh.NoSuchCoQuanBanHanhException {
        return getPersistence()
                   .findByActive_PrevAndNext(maCoQuanBanHanh, active, obc);
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

    public static java.util.List<com.nss.portlet.co_quan_ban_hanh.model.CoQuanBanHanh> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.nss.portlet.co_quan_ban_hanh.model.CoQuanBanHanh> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.nss.portlet.co_quan_ban_hanh.model.CoQuanBanHanh> findAll(
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

    public static CoQuanBanHanhPersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(CoQuanBanHanhPersistence persistence) {
        _persistence = persistence;
    }
}
