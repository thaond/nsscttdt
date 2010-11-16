package com.nss.portlet.adv.service.persistence;

public class QuangCaoUtil {
    private static QuangCaoPersistence _persistence;

    public static void cacheResult(com.nss.portlet.adv.model.QuangCao quangCao) {
        getPersistence().cacheResult(quangCao);
    }

    public static void cacheResult(
        java.util.List<com.nss.portlet.adv.model.QuangCao> quangCaos) {
        getPersistence().cacheResult(quangCaos);
    }

    public static void clearCache() {
        getPersistence().clearCache();
    }

    public static com.nss.portlet.adv.model.QuangCao create(long maQuangCao) {
        return getPersistence().create(maQuangCao);
    }

    public static com.nss.portlet.adv.model.QuangCao remove(long maQuangCao)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.adv.NoSuchQuangCaoException {
        return getPersistence().remove(maQuangCao);
    }

    public static com.nss.portlet.adv.model.QuangCao remove(
        com.nss.portlet.adv.model.QuangCao quangCao)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(quangCao);
    }

    /**
     * @deprecated Use <code>update(QuangCao quangCao, boolean merge)</code>.
     */
    public static com.nss.portlet.adv.model.QuangCao update(
        com.nss.portlet.adv.model.QuangCao quangCao)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(quangCao);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                quangCao the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when quangCao is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public static com.nss.portlet.adv.model.QuangCao update(
        com.nss.portlet.adv.model.QuangCao quangCao, boolean merge)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(quangCao, merge);
    }

    public static com.nss.portlet.adv.model.QuangCao updateImpl(
        com.nss.portlet.adv.model.QuangCao quangCao, boolean merge)
        throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(quangCao, merge);
    }

    public static com.nss.portlet.adv.model.QuangCao findByPrimaryKey(
        long maQuangCao)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.adv.NoSuchQuangCaoException {
        return getPersistence().findByPrimaryKey(maQuangCao);
    }

    public static com.nss.portlet.adv.model.QuangCao fetchByPrimaryKey(
        long maQuangCao) throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(maQuangCao);
    }

    public static java.util.List<com.nss.portlet.adv.model.QuangCao> findByActive(
        int active) throws com.liferay.portal.SystemException {
        return getPersistence().findByActive(active);
    }

    public static java.util.List<com.nss.portlet.adv.model.QuangCao> findByActive(
        int active, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByActive(active, start, end);
    }

    public static java.util.List<com.nss.portlet.adv.model.QuangCao> findByActive(
        int active, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByActive(active, start, end, obc);
    }

    public static com.nss.portlet.adv.model.QuangCao findByActive_First(
        int active, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.adv.NoSuchQuangCaoException {
        return getPersistence().findByActive_First(active, obc);
    }

    public static com.nss.portlet.adv.model.QuangCao findByActive_Last(
        int active, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.adv.NoSuchQuangCaoException {
        return getPersistence().findByActive_Last(active, obc);
    }

    public static com.nss.portlet.adv.model.QuangCao[] findByActive_PrevAndNext(
        long maQuangCao, int active,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.adv.NoSuchQuangCaoException {
        return getPersistence().findByActive_PrevAndNext(maQuangCao, active, obc);
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

    public static java.util.List<com.nss.portlet.adv.model.QuangCao> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.nss.portlet.adv.model.QuangCao> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.nss.portlet.adv.model.QuangCao> findAll(
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

    public static QuangCaoPersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(QuangCaoPersistence persistence) {
        _persistence = persistence;
    }
}
