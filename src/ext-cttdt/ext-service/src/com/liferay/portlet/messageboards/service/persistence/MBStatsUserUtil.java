package com.liferay.portlet.messageboards.service.persistence;

public class MBStatsUserUtil {
    private static MBStatsUserPersistence _persistence;

    public static void cacheResult(
        com.liferay.portlet.messageboards.model.MBStatsUser mbStatsUser) {
        getPersistence().cacheResult(mbStatsUser);
    }

    public static void cacheResult(
        java.util.List<com.liferay.portlet.messageboards.model.MBStatsUser> mbStatsUsers) {
        getPersistence().cacheResult(mbStatsUsers);
    }

    public static void clearCache() {
        getPersistence().clearCache();
    }

    public static com.liferay.portlet.messageboards.model.MBStatsUser create(
        long statsUserId) {
        return getPersistence().create(statsUserId);
    }

    public static com.liferay.portlet.messageboards.model.MBStatsUser remove(
        long statsUserId)
        throws com.liferay.portal.SystemException,
            com.liferay.portlet.messageboards.NoSuchStatsUserException {
        return getPersistence().remove(statsUserId);
    }

    public static com.liferay.portlet.messageboards.model.MBStatsUser remove(
        com.liferay.portlet.messageboards.model.MBStatsUser mbStatsUser)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(mbStatsUser);
    }

    /**
     * @deprecated Use <code>update(MBStatsUser mbStatsUser, boolean merge)</code>.
     */
    public static com.liferay.portlet.messageboards.model.MBStatsUser update(
        com.liferay.portlet.messageboards.model.MBStatsUser mbStatsUser)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(mbStatsUser);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                mbStatsUser the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when mbStatsUser is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public static com.liferay.portlet.messageboards.model.MBStatsUser update(
        com.liferay.portlet.messageboards.model.MBStatsUser mbStatsUser,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().update(mbStatsUser, merge);
    }

    public static com.liferay.portlet.messageboards.model.MBStatsUser updateImpl(
        com.liferay.portlet.messageboards.model.MBStatsUser mbStatsUser,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(mbStatsUser, merge);
    }

    public static com.liferay.portlet.messageboards.model.MBStatsUser findByPrimaryKey(
        long statsUserId)
        throws com.liferay.portal.SystemException,
            com.liferay.portlet.messageboards.NoSuchStatsUserException {
        return getPersistence().findByPrimaryKey(statsUserId);
    }

    public static com.liferay.portlet.messageboards.model.MBStatsUser fetchByPrimaryKey(
        long statsUserId) throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(statsUserId);
    }

    public static java.util.List<com.liferay.portlet.messageboards.model.MBStatsUser> findByGroupId(
        long groupId) throws com.liferay.portal.SystemException {
        return getPersistence().findByGroupId(groupId);
    }

    public static java.util.List<com.liferay.portlet.messageboards.model.MBStatsUser> findByGroupId(
        long groupId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByGroupId(groupId, start, end);
    }

    public static java.util.List<com.liferay.portlet.messageboards.model.MBStatsUser> findByGroupId(
        long groupId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByGroupId(groupId, start, end, obc);
    }

    public static com.liferay.portlet.messageboards.model.MBStatsUser findByGroupId_First(
        long groupId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.liferay.portlet.messageboards.NoSuchStatsUserException {
        return getPersistence().findByGroupId_First(groupId, obc);
    }

    public static com.liferay.portlet.messageboards.model.MBStatsUser findByGroupId_Last(
        long groupId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.liferay.portlet.messageboards.NoSuchStatsUserException {
        return getPersistence().findByGroupId_Last(groupId, obc);
    }

    public static com.liferay.portlet.messageboards.model.MBStatsUser[] findByGroupId_PrevAndNext(
        long statsUserId, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.liferay.portlet.messageboards.NoSuchStatsUserException {
        return getPersistence()
                   .findByGroupId_PrevAndNext(statsUserId, groupId, obc);
    }

    public static java.util.List<com.liferay.portlet.messageboards.model.MBStatsUser> findByUserId(
        long userId) throws com.liferay.portal.SystemException {
        return getPersistence().findByUserId(userId);
    }

    public static java.util.List<com.liferay.portlet.messageboards.model.MBStatsUser> findByUserId(
        long userId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByUserId(userId, start, end);
    }

    public static java.util.List<com.liferay.portlet.messageboards.model.MBStatsUser> findByUserId(
        long userId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByUserId(userId, start, end, obc);
    }

    public static com.liferay.portlet.messageboards.model.MBStatsUser findByUserId_First(
        long userId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.liferay.portlet.messageboards.NoSuchStatsUserException {
        return getPersistence().findByUserId_First(userId, obc);
    }

    public static com.liferay.portlet.messageboards.model.MBStatsUser findByUserId_Last(
        long userId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.liferay.portlet.messageboards.NoSuchStatsUserException {
        return getPersistence().findByUserId_Last(userId, obc);
    }

    public static com.liferay.portlet.messageboards.model.MBStatsUser[] findByUserId_PrevAndNext(
        long statsUserId, long userId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.liferay.portlet.messageboards.NoSuchStatsUserException {
        return getPersistence()
                   .findByUserId_PrevAndNext(statsUserId, userId, obc);
    }

    public static com.liferay.portlet.messageboards.model.MBStatsUser findByG_U(
        long groupId, long userId)
        throws com.liferay.portal.SystemException,
            com.liferay.portlet.messageboards.NoSuchStatsUserException {
        return getPersistence().findByG_U(groupId, userId);
    }

    public static com.liferay.portlet.messageboards.model.MBStatsUser fetchByG_U(
        long groupId, long userId) throws com.liferay.portal.SystemException {
        return getPersistence().fetchByG_U(groupId, userId);
    }

    public static com.liferay.portlet.messageboards.model.MBStatsUser fetchByG_U(
        long groupId, long userId, boolean retrieveFromCache)
        throws com.liferay.portal.SystemException {
        return getPersistence().fetchByG_U(groupId, userId, retrieveFromCache);
    }

    public static java.util.List<com.liferay.portlet.messageboards.model.MBStatsUser> findByG_M(
        long groupId, int messageCount)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByG_M(groupId, messageCount);
    }

    public static java.util.List<com.liferay.portlet.messageboards.model.MBStatsUser> findByG_M(
        long groupId, int messageCount, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByG_M(groupId, messageCount, start, end);
    }

    public static java.util.List<com.liferay.portlet.messageboards.model.MBStatsUser> findByG_M(
        long groupId, int messageCount, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByG_M(groupId, messageCount, start, end, obc);
    }

    public static com.liferay.portlet.messageboards.model.MBStatsUser findByG_M_First(
        long groupId, int messageCount,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.liferay.portlet.messageboards.NoSuchStatsUserException {
        return getPersistence().findByG_M_First(groupId, messageCount, obc);
    }

    public static com.liferay.portlet.messageboards.model.MBStatsUser findByG_M_Last(
        long groupId, int messageCount,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.liferay.portlet.messageboards.NoSuchStatsUserException {
        return getPersistence().findByG_M_Last(groupId, messageCount, obc);
    }

    public static com.liferay.portlet.messageboards.model.MBStatsUser[] findByG_M_PrevAndNext(
        long statsUserId, long groupId, int messageCount,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.liferay.portlet.messageboards.NoSuchStatsUserException {
        return getPersistence()
                   .findByG_M_PrevAndNext(statsUserId, groupId, messageCount,
            obc);
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

    public static java.util.List<com.liferay.portlet.messageboards.model.MBStatsUser> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.liferay.portlet.messageboards.model.MBStatsUser> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.liferay.portlet.messageboards.model.MBStatsUser> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end, obc);
    }

    public static void removeByGroupId(long groupId)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByGroupId(groupId);
    }

    public static void removeByUserId(long userId)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByUserId(userId);
    }

    public static void removeByG_U(long groupId, long userId)
        throws com.liferay.portal.SystemException,
            com.liferay.portlet.messageboards.NoSuchStatsUserException {
        getPersistence().removeByG_U(groupId, userId);
    }

    public static void removeByG_M(long groupId, int messageCount)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByG_M(groupId, messageCount);
    }

    public static void removeAll() throws com.liferay.portal.SystemException {
        getPersistence().removeAll();
    }

    public static int countByGroupId(long groupId)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByGroupId(groupId);
    }

    public static int countByUserId(long userId)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByUserId(userId);
    }

    public static int countByG_U(long groupId, long userId)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByG_U(groupId, userId);
    }

    public static int countByG_M(long groupId, int messageCount)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByG_M(groupId, messageCount);
    }

    public static int countAll() throws com.liferay.portal.SystemException {
        return getPersistence().countAll();
    }

    public static MBStatsUserPersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(MBStatsUserPersistence persistence) {
        _persistence = persistence;
    }
}
