package com.liferay.portlet.messageboards.service.persistence;

public class MBBanUtil {
    private static MBBanPersistence _persistence;

    public static void cacheResult(
        com.liferay.portlet.messageboards.model.MBBan mbBan) {
        getPersistence().cacheResult(mbBan);
    }

    public static void cacheResult(
        java.util.List<com.liferay.portlet.messageboards.model.MBBan> mbBans) {
        getPersistence().cacheResult(mbBans);
    }

    public static void clearCache() {
        getPersistence().clearCache();
    }

    public static com.liferay.portlet.messageboards.model.MBBan create(
        long banId) {
        return getPersistence().create(banId);
    }

    public static com.liferay.portlet.messageboards.model.MBBan remove(
        long banId)
        throws com.liferay.portal.SystemException,
            com.liferay.portlet.messageboards.NoSuchBanException {
        return getPersistence().remove(banId);
    }

    public static com.liferay.portlet.messageboards.model.MBBan remove(
        com.liferay.portlet.messageboards.model.MBBan mbBan)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(mbBan);
    }

    /**
     * @deprecated Use <code>update(MBBan mbBan, boolean merge)</code>.
     */
    public static com.liferay.portlet.messageboards.model.MBBan update(
        com.liferay.portlet.messageboards.model.MBBan mbBan)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(mbBan);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                mbBan the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when mbBan is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public static com.liferay.portlet.messageboards.model.MBBan update(
        com.liferay.portlet.messageboards.model.MBBan mbBan, boolean merge)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(mbBan, merge);
    }

    public static com.liferay.portlet.messageboards.model.MBBan updateImpl(
        com.liferay.portlet.messageboards.model.MBBan mbBan, boolean merge)
        throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(mbBan, merge);
    }

    public static com.liferay.portlet.messageboards.model.MBBan findByPrimaryKey(
        long banId)
        throws com.liferay.portal.SystemException,
            com.liferay.portlet.messageboards.NoSuchBanException {
        return getPersistence().findByPrimaryKey(banId);
    }

    public static com.liferay.portlet.messageboards.model.MBBan fetchByPrimaryKey(
        long banId) throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(banId);
    }

    public static java.util.List<com.liferay.portlet.messageboards.model.MBBan> findByGroupId(
        long groupId) throws com.liferay.portal.SystemException {
        return getPersistence().findByGroupId(groupId);
    }

    public static java.util.List<com.liferay.portlet.messageboards.model.MBBan> findByGroupId(
        long groupId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByGroupId(groupId, start, end);
    }

    public static java.util.List<com.liferay.portlet.messageboards.model.MBBan> findByGroupId(
        long groupId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByGroupId(groupId, start, end, obc);
    }

    public static com.liferay.portlet.messageboards.model.MBBan findByGroupId_First(
        long groupId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.liferay.portlet.messageboards.NoSuchBanException {
        return getPersistence().findByGroupId_First(groupId, obc);
    }

    public static com.liferay.portlet.messageboards.model.MBBan findByGroupId_Last(
        long groupId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.liferay.portlet.messageboards.NoSuchBanException {
        return getPersistence().findByGroupId_Last(groupId, obc);
    }

    public static com.liferay.portlet.messageboards.model.MBBan[] findByGroupId_PrevAndNext(
        long banId, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.liferay.portlet.messageboards.NoSuchBanException {
        return getPersistence().findByGroupId_PrevAndNext(banId, groupId, obc);
    }

    public static java.util.List<com.liferay.portlet.messageboards.model.MBBan> findByUserId(
        long userId) throws com.liferay.portal.SystemException {
        return getPersistence().findByUserId(userId);
    }

    public static java.util.List<com.liferay.portlet.messageboards.model.MBBan> findByUserId(
        long userId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByUserId(userId, start, end);
    }

    public static java.util.List<com.liferay.portlet.messageboards.model.MBBan> findByUserId(
        long userId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByUserId(userId, start, end, obc);
    }

    public static com.liferay.portlet.messageboards.model.MBBan findByUserId_First(
        long userId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.liferay.portlet.messageboards.NoSuchBanException {
        return getPersistence().findByUserId_First(userId, obc);
    }

    public static com.liferay.portlet.messageboards.model.MBBan findByUserId_Last(
        long userId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.liferay.portlet.messageboards.NoSuchBanException {
        return getPersistence().findByUserId_Last(userId, obc);
    }

    public static com.liferay.portlet.messageboards.model.MBBan[] findByUserId_PrevAndNext(
        long banId, long userId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.liferay.portlet.messageboards.NoSuchBanException {
        return getPersistence().findByUserId_PrevAndNext(banId, userId, obc);
    }

    public static java.util.List<com.liferay.portlet.messageboards.model.MBBan> findByBanUserId(
        long banUserId) throws com.liferay.portal.SystemException {
        return getPersistence().findByBanUserId(banUserId);
    }

    public static java.util.List<com.liferay.portlet.messageboards.model.MBBan> findByBanUserId(
        long banUserId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByBanUserId(banUserId, start, end);
    }

    public static java.util.List<com.liferay.portlet.messageboards.model.MBBan> findByBanUserId(
        long banUserId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByBanUserId(banUserId, start, end, obc);
    }

    public static com.liferay.portlet.messageboards.model.MBBan findByBanUserId_First(
        long banUserId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.liferay.portlet.messageboards.NoSuchBanException {
        return getPersistence().findByBanUserId_First(banUserId, obc);
    }

    public static com.liferay.portlet.messageboards.model.MBBan findByBanUserId_Last(
        long banUserId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.liferay.portlet.messageboards.NoSuchBanException {
        return getPersistence().findByBanUserId_Last(banUserId, obc);
    }

    public static com.liferay.portlet.messageboards.model.MBBan[] findByBanUserId_PrevAndNext(
        long banId, long banUserId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.liferay.portlet.messageboards.NoSuchBanException {
        return getPersistence()
                   .findByBanUserId_PrevAndNext(banId, banUserId, obc);
    }

    public static com.liferay.portlet.messageboards.model.MBBan findByG_B(
        long groupId, long banUserId)
        throws com.liferay.portal.SystemException,
            com.liferay.portlet.messageboards.NoSuchBanException {
        return getPersistence().findByG_B(groupId, banUserId);
    }

    public static com.liferay.portlet.messageboards.model.MBBan fetchByG_B(
        long groupId, long banUserId) throws com.liferay.portal.SystemException {
        return getPersistence().fetchByG_B(groupId, banUserId);
    }

    public static com.liferay.portlet.messageboards.model.MBBan fetchByG_B(
        long groupId, long banUserId, boolean retrieveFromCache)
        throws com.liferay.portal.SystemException {
        return getPersistence().fetchByG_B(groupId, banUserId, retrieveFromCache);
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

    public static java.util.List<com.liferay.portlet.messageboards.model.MBBan> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.liferay.portlet.messageboards.model.MBBan> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.liferay.portlet.messageboards.model.MBBan> findAll(
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

    public static void removeByBanUserId(long banUserId)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByBanUserId(banUserId);
    }

    public static void removeByG_B(long groupId, long banUserId)
        throws com.liferay.portal.SystemException,
            com.liferay.portlet.messageboards.NoSuchBanException {
        getPersistence().removeByG_B(groupId, banUserId);
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

    public static int countByBanUserId(long banUserId)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByBanUserId(banUserId);
    }

    public static int countByG_B(long groupId, long banUserId)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByG_B(groupId, banUserId);
    }

    public static int countAll() throws com.liferay.portal.SystemException {
        return getPersistence().countAll();
    }

    public static MBBanPersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(MBBanPersistence persistence) {
        _persistence = persistence;
    }
}
