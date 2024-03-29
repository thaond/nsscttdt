package com.nss.portlet.journal.service.persistence;

public class JournalFeedUtil {
    private static JournalFeedPersistence _persistence;

    public static void cacheResult(
        com.nss.portlet.journal.model.JournalFeed journalFeed) {
        getPersistence().cacheResult(journalFeed);
    }

    public static void cacheResult(
        java.util.List<com.nss.portlet.journal.model.JournalFeed> journalFeeds) {
        getPersistence().cacheResult(journalFeeds);
    }

    public static void clearCache() {
        getPersistence().clearCache();
    }

    public static com.nss.portlet.journal.model.JournalFeed create(long id) {
        return getPersistence().create(id);
    }

    public static com.nss.portlet.journal.model.JournalFeed remove(long id)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchFeedException {
        return getPersistence().remove(id);
    }

    public static com.nss.portlet.journal.model.JournalFeed remove(
        com.nss.portlet.journal.model.JournalFeed journalFeed)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(journalFeed);
    }

    /**
     * @deprecated Use <code>update(JournalFeed journalFeed, boolean merge)</code>.
     */
    public static com.nss.portlet.journal.model.JournalFeed update(
        com.nss.portlet.journal.model.JournalFeed journalFeed)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(journalFeed);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                journalFeed the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when journalFeed is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public static com.nss.portlet.journal.model.JournalFeed update(
        com.nss.portlet.journal.model.JournalFeed journalFeed, boolean merge)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(journalFeed, merge);
    }

    public static com.nss.portlet.journal.model.JournalFeed updateImpl(
        com.nss.portlet.journal.model.JournalFeed journalFeed, boolean merge)
        throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(journalFeed, merge);
    }

    public static com.nss.portlet.journal.model.JournalFeed findByPrimaryKey(
        long id)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchFeedException {
        return getPersistence().findByPrimaryKey(id);
    }

    public static com.nss.portlet.journal.model.JournalFeed fetchByPrimaryKey(
        long id) throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(id);
    }

    public static java.util.List<com.nss.portlet.journal.model.JournalFeed> findByUuid(
        java.lang.String uuid) throws com.liferay.portal.SystemException {
        return getPersistence().findByUuid(uuid);
    }

    public static java.util.List<com.nss.portlet.journal.model.JournalFeed> findByUuid(
        java.lang.String uuid, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByUuid(uuid, start, end);
    }

    public static java.util.List<com.nss.portlet.journal.model.JournalFeed> findByUuid(
        java.lang.String uuid, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByUuid(uuid, start, end, obc);
    }

    public static com.nss.portlet.journal.model.JournalFeed findByUuid_First(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchFeedException {
        return getPersistence().findByUuid_First(uuid, obc);
    }

    public static com.nss.portlet.journal.model.JournalFeed findByUuid_Last(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchFeedException {
        return getPersistence().findByUuid_Last(uuid, obc);
    }

    public static com.nss.portlet.journal.model.JournalFeed[] findByUuid_PrevAndNext(
        long id, java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchFeedException {
        return getPersistence().findByUuid_PrevAndNext(id, uuid, obc);
    }

    public static com.nss.portlet.journal.model.JournalFeed findByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchFeedException {
        return getPersistence().findByUUID_G(uuid, groupId);
    }

    public static com.nss.portlet.journal.model.JournalFeed fetchByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.SystemException {
        return getPersistence().fetchByUUID_G(uuid, groupId);
    }

    public static com.nss.portlet.journal.model.JournalFeed fetchByUUID_G(
        java.lang.String uuid, long groupId, boolean retrieveFromCache)
        throws com.liferay.portal.SystemException {
        return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
    }

    public static java.util.List<com.nss.portlet.journal.model.JournalFeed> findByGroupId(
        long groupId) throws com.liferay.portal.SystemException {
        return getPersistence().findByGroupId(groupId);
    }

    public static java.util.List<com.nss.portlet.journal.model.JournalFeed> findByGroupId(
        long groupId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByGroupId(groupId, start, end);
    }

    public static java.util.List<com.nss.portlet.journal.model.JournalFeed> findByGroupId(
        long groupId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByGroupId(groupId, start, end, obc);
    }

    public static com.nss.portlet.journal.model.JournalFeed findByGroupId_First(
        long groupId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchFeedException {
        return getPersistence().findByGroupId_First(groupId, obc);
    }

    public static com.nss.portlet.journal.model.JournalFeed findByGroupId_Last(
        long groupId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchFeedException {
        return getPersistence().findByGroupId_Last(groupId, obc);
    }

    public static com.nss.portlet.journal.model.JournalFeed[] findByGroupId_PrevAndNext(
        long id, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchFeedException {
        return getPersistence().findByGroupId_PrevAndNext(id, groupId, obc);
    }

    public static com.nss.portlet.journal.model.JournalFeed findByG_F(
        long groupId, java.lang.String feedId)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchFeedException {
        return getPersistence().findByG_F(groupId, feedId);
    }

    public static com.nss.portlet.journal.model.JournalFeed fetchByG_F(
        long groupId, java.lang.String feedId)
        throws com.liferay.portal.SystemException {
        return getPersistence().fetchByG_F(groupId, feedId);
    }

    public static com.nss.portlet.journal.model.JournalFeed fetchByG_F(
        long groupId, java.lang.String feedId, boolean retrieveFromCache)
        throws com.liferay.portal.SystemException {
        return getPersistence().fetchByG_F(groupId, feedId, retrieveFromCache);
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

    public static java.util.List<com.nss.portlet.journal.model.JournalFeed> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.nss.portlet.journal.model.JournalFeed> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.nss.portlet.journal.model.JournalFeed> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end, obc);
    }

    public static void removeByUuid(java.lang.String uuid)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByUuid(uuid);
    }

    public static void removeByUUID_G(java.lang.String uuid, long groupId)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchFeedException {
        getPersistence().removeByUUID_G(uuid, groupId);
    }

    public static void removeByGroupId(long groupId)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByGroupId(groupId);
    }

    public static void removeByG_F(long groupId, java.lang.String feedId)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchFeedException {
        getPersistence().removeByG_F(groupId, feedId);
    }

    public static void removeAll() throws com.liferay.portal.SystemException {
        getPersistence().removeAll();
    }

    public static int countByUuid(java.lang.String uuid)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByUuid(uuid);
    }

    public static int countByUUID_G(java.lang.String uuid, long groupId)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByUUID_G(uuid, groupId);
    }

    public static int countByGroupId(long groupId)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByGroupId(groupId);
    }

    public static int countByG_F(long groupId, java.lang.String feedId)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByG_F(groupId, feedId);
    }

    public static int countAll() throws com.liferay.portal.SystemException {
        return getPersistence().countAll();
    }

    public static JournalFeedPersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(JournalFeedPersistence persistence) {
        _persistence = persistence;
    }
}
