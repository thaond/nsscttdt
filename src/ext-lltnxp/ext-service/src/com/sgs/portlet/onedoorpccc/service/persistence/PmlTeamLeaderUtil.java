package com.sgs.portlet.onedoorpccc.service.persistence;

public class PmlTeamLeaderUtil {
    private static PmlTeamLeaderPersistence _persistence;

    public static com.sgs.portlet.onedoorpccc.model.PmlTeamLeader create(
        long teamId) {
        return getPersistence().create(teamId);
    }

    public static com.sgs.portlet.onedoorpccc.model.PmlTeamLeader remove(
        long teamId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchPmlTeamLeaderException {
        return getPersistence().remove(teamId);
    }

    public static com.sgs.portlet.onedoorpccc.model.PmlTeamLeader remove(
        com.sgs.portlet.onedoorpccc.model.PmlTeamLeader pmlTeamLeader)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(pmlTeamLeader);
    }

    /**
     * @deprecated Use <code>update(PmlTeamLeader pmlTeamLeader, boolean merge)</code>.
     */
    public static com.sgs.portlet.onedoorpccc.model.PmlTeamLeader update(
        com.sgs.portlet.onedoorpccc.model.PmlTeamLeader pmlTeamLeader)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(pmlTeamLeader);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlTeamLeader the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlTeamLeader is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public static com.sgs.portlet.onedoorpccc.model.PmlTeamLeader update(
        com.sgs.portlet.onedoorpccc.model.PmlTeamLeader pmlTeamLeader,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().update(pmlTeamLeader, merge);
    }

    public static com.sgs.portlet.onedoorpccc.model.PmlTeamLeader updateImpl(
        com.sgs.portlet.onedoorpccc.model.PmlTeamLeader pmlTeamLeader,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(pmlTeamLeader, merge);
    }

    public static com.sgs.portlet.onedoorpccc.model.PmlTeamLeader findByPrimaryKey(
        long teamId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchPmlTeamLeaderException {
        return getPersistence().findByPrimaryKey(teamId);
    }

    public static com.sgs.portlet.onedoorpccc.model.PmlTeamLeader fetchByPrimaryKey(
        long teamId) throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(teamId);
    }

    public static java.util.List<com.sgs.portlet.onedoorpccc.model.PmlTeamLeader> findByUserId(
        long userId) throws com.liferay.portal.SystemException {
        return getPersistence().findByUserId(userId);
    }

    public static java.util.List<com.sgs.portlet.onedoorpccc.model.PmlTeamLeader> findByUserId(
        long userId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByUserId(userId, start, end);
    }

    public static java.util.List<com.sgs.portlet.onedoorpccc.model.PmlTeamLeader> findByUserId(
        long userId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByUserId(userId, start, end, obc);
    }

    public static com.sgs.portlet.onedoorpccc.model.PmlTeamLeader findByUserId_First(
        long userId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchPmlTeamLeaderException {
        return getPersistence().findByUserId_First(userId, obc);
    }

    public static com.sgs.portlet.onedoorpccc.model.PmlTeamLeader findByUserId_Last(
        long userId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchPmlTeamLeaderException {
        return getPersistence().findByUserId_Last(userId, obc);
    }

    public static com.sgs.portlet.onedoorpccc.model.PmlTeamLeader[] findByUserId_PrevAndNext(
        long teamId, long userId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchPmlTeamLeaderException {
        return getPersistence().findByUserId_PrevAndNext(teamId, userId, obc);
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

    public static java.util.List<com.sgs.portlet.onedoorpccc.model.PmlTeamLeader> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.sgs.portlet.onedoorpccc.model.PmlTeamLeader> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.sgs.portlet.onedoorpccc.model.PmlTeamLeader> findAll(
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

    public static PmlTeamLeaderPersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(PmlTeamLeaderPersistence persistence) {
        _persistence = persistence;
    }
}
