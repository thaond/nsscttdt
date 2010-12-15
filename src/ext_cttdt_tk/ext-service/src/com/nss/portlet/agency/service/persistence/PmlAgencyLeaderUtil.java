package com.nss.portlet.agency.service.persistence;

public class PmlAgencyLeaderUtil {
    private static PmlAgencyLeaderPersistence _persistence;

    public static void cacheResult(
        com.nss.portlet.agency.model.PmlAgencyLeader pmlAgencyLeader) {
        getPersistence().cacheResult(pmlAgencyLeader);
    }

    public static void cacheResult(
        java.util.List<com.nss.portlet.agency.model.PmlAgencyLeader> pmlAgencyLeaders) {
        getPersistence().cacheResult(pmlAgencyLeaders);
    }

    public static void clearCache() {
        getPersistence().clearCache();
    }

    public static com.nss.portlet.agency.model.PmlAgencyLeader create(
        java.lang.String agencyId) {
        return getPersistence().create(agencyId);
    }

    public static com.nss.portlet.agency.model.PmlAgencyLeader remove(
        java.lang.String agencyId)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.agency.NoSuchPmlAgencyLeaderException {
        return getPersistence().remove(agencyId);
    }

    public static com.nss.portlet.agency.model.PmlAgencyLeader remove(
        com.nss.portlet.agency.model.PmlAgencyLeader pmlAgencyLeader)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(pmlAgencyLeader);
    }

    /**
     * @deprecated Use <code>update(PmlAgencyLeader pmlAgencyLeader, boolean merge)</code>.
     */
    public static com.nss.portlet.agency.model.PmlAgencyLeader update(
        com.nss.portlet.agency.model.PmlAgencyLeader pmlAgencyLeader)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(pmlAgencyLeader);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlAgencyLeader the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlAgencyLeader is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public static com.nss.portlet.agency.model.PmlAgencyLeader update(
        com.nss.portlet.agency.model.PmlAgencyLeader pmlAgencyLeader,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().update(pmlAgencyLeader, merge);
    }

    public static com.nss.portlet.agency.model.PmlAgencyLeader updateImpl(
        com.nss.portlet.agency.model.PmlAgencyLeader pmlAgencyLeader,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(pmlAgencyLeader, merge);
    }

    public static com.nss.portlet.agency.model.PmlAgencyLeader findByPrimaryKey(
        java.lang.String agencyId)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.agency.NoSuchPmlAgencyLeaderException {
        return getPersistence().findByPrimaryKey(agencyId);
    }

    public static com.nss.portlet.agency.model.PmlAgencyLeader fetchByPrimaryKey(
        java.lang.String agencyId) throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(agencyId);
    }

    public static java.util.List<com.nss.portlet.agency.model.PmlAgencyLeader> findByUserId(
        long userId) throws com.liferay.portal.SystemException {
        return getPersistence().findByUserId(userId);
    }

    public static java.util.List<com.nss.portlet.agency.model.PmlAgencyLeader> findByUserId(
        long userId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByUserId(userId, start, end);
    }

    public static java.util.List<com.nss.portlet.agency.model.PmlAgencyLeader> findByUserId(
        long userId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByUserId(userId, start, end, obc);
    }

    public static com.nss.portlet.agency.model.PmlAgencyLeader findByUserId_First(
        long userId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.agency.NoSuchPmlAgencyLeaderException {
        return getPersistence().findByUserId_First(userId, obc);
    }

    public static com.nss.portlet.agency.model.PmlAgencyLeader findByUserId_Last(
        long userId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.agency.NoSuchPmlAgencyLeaderException {
        return getPersistence().findByUserId_Last(userId, obc);
    }

    public static com.nss.portlet.agency.model.PmlAgencyLeader[] findByUserId_PrevAndNext(
        java.lang.String agencyId, long userId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.agency.NoSuchPmlAgencyLeaderException {
        return getPersistence().findByUserId_PrevAndNext(agencyId, userId, obc);
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

    public static java.util.List<com.nss.portlet.agency.model.PmlAgencyLeader> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.nss.portlet.agency.model.PmlAgencyLeader> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.nss.portlet.agency.model.PmlAgencyLeader> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end, obc);
    }

    public static void removeByUserId(long userId)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByUserId(userId);
    }

    public static void removeAll() throws com.liferay.portal.SystemException {
        getPersistence().removeAll();
    }

    public static int countByUserId(long userId)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByUserId(userId);
    }

    public static int countAll() throws com.liferay.portal.SystemException {
        return getPersistence().countAll();
    }

    public static PmlAgencyLeaderPersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(PmlAgencyLeaderPersistence persistence) {
        _persistence = persistence;
    }
}
