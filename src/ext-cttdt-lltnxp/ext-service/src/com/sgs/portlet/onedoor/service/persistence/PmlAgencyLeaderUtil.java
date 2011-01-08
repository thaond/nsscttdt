package com.sgs.portlet.onedoor.service.persistence;

public class PmlAgencyLeaderUtil {
    private static PmlAgencyLeaderPersistence _persistence;

    public static com.sgs.portlet.onedoor.model.PmlAgencyLeader create(
        java.lang.String agencyId) {
        return getPersistence().create(agencyId);
    }

    public static com.sgs.portlet.onedoor.model.PmlAgencyLeader remove(
        java.lang.String agencyId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlAgencyLeaderException {
        return getPersistence().remove(agencyId);
    }

    public static com.sgs.portlet.onedoor.model.PmlAgencyLeader remove(
        com.sgs.portlet.onedoor.model.PmlAgencyLeader pmlAgencyLeader)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(pmlAgencyLeader);
    }

    /**
     * @deprecated Use <code>update(PmlAgencyLeader pmlAgencyLeader, boolean merge)</code>.
     */
    public static com.sgs.portlet.onedoor.model.PmlAgencyLeader update(
        com.sgs.portlet.onedoor.model.PmlAgencyLeader pmlAgencyLeader)
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
    public static com.sgs.portlet.onedoor.model.PmlAgencyLeader update(
        com.sgs.portlet.onedoor.model.PmlAgencyLeader pmlAgencyLeader,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().update(pmlAgencyLeader, merge);
    }

    public static com.sgs.portlet.onedoor.model.PmlAgencyLeader updateImpl(
        com.sgs.portlet.onedoor.model.PmlAgencyLeader pmlAgencyLeader,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(pmlAgencyLeader, merge);
    }

    public static com.sgs.portlet.onedoor.model.PmlAgencyLeader findByPrimaryKey(
        java.lang.String agencyId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlAgencyLeaderException {
        return getPersistence().findByPrimaryKey(agencyId);
    }

    public static com.sgs.portlet.onedoor.model.PmlAgencyLeader fetchByPrimaryKey(
        java.lang.String agencyId) throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(agencyId);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlAgencyLeader> findByUserId(
        long userId) throws com.liferay.portal.SystemException {
        return getPersistence().findByUserId(userId);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlAgencyLeader> findByUserId(
        long userId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByUserId(userId, start, end);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlAgencyLeader> findByUserId(
        long userId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByUserId(userId, start, end, obc);
    }

    public static com.sgs.portlet.onedoor.model.PmlAgencyLeader findByUserId_First(
        long userId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlAgencyLeaderException {
        return getPersistence().findByUserId_First(userId, obc);
    }

    public static com.sgs.portlet.onedoor.model.PmlAgencyLeader findByUserId_Last(
        long userId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlAgencyLeaderException {
        return getPersistence().findByUserId_Last(userId, obc);
    }

    public static com.sgs.portlet.onedoor.model.PmlAgencyLeader[] findByUserId_PrevAndNext(
        java.lang.String agencyId, long userId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlAgencyLeaderException {
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

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlAgencyLeader> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlAgencyLeader> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlAgencyLeader> findAll(
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

    public static void registerListener(
        com.liferay.portal.model.ModelListener listener) {
        getPersistence().registerListener(listener);
    }

    public static void unregisterListener(
        com.liferay.portal.model.ModelListener listener) {
        getPersistence().unregisterListener(listener);
    }

    public static PmlAgencyLeaderPersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(PmlAgencyLeaderPersistence persistence) {
        _persistence = persistence;
    }
}
