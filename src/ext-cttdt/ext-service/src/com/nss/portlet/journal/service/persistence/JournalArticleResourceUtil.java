package com.nss.portlet.journal.service.persistence;

public class JournalArticleResourceUtil {
    private static JournalArticleResourcePersistence _persistence;

    public static void cacheResult(
        com.nss.portlet.journal.model.JournalArticleResource journalArticleResource) {
        getPersistence().cacheResult(journalArticleResource);
    }

    public static void cacheResult(
        java.util.List<com.nss.portlet.journal.model.JournalArticleResource> journalArticleResources) {
        getPersistence().cacheResult(journalArticleResources);
    }

    public static void clearCache() {
        getPersistence().clearCache();
    }

    public static com.nss.portlet.journal.model.JournalArticleResource create(
        long resourcePrimKey) {
        return getPersistence().create(resourcePrimKey);
    }

    public static com.nss.portlet.journal.model.JournalArticleResource remove(
        long resourcePrimKey)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchArticleResourceException {
        return getPersistence().remove(resourcePrimKey);
    }

    public static com.nss.portlet.journal.model.JournalArticleResource remove(
        com.nss.portlet.journal.model.JournalArticleResource journalArticleResource)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(journalArticleResource);
    }

    /**
     * @deprecated Use <code>update(JournalArticleResource journalArticleResource, boolean merge)</code>.
     */
    public static com.nss.portlet.journal.model.JournalArticleResource update(
        com.nss.portlet.journal.model.JournalArticleResource journalArticleResource)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(journalArticleResource);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                journalArticleResource the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when journalArticleResource is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public static com.nss.portlet.journal.model.JournalArticleResource update(
        com.nss.portlet.journal.model.JournalArticleResource journalArticleResource,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().update(journalArticleResource, merge);
    }

    public static com.nss.portlet.journal.model.JournalArticleResource updateImpl(
        com.nss.portlet.journal.model.JournalArticleResource journalArticleResource,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(journalArticleResource, merge);
    }

    public static com.nss.portlet.journal.model.JournalArticleResource findByPrimaryKey(
        long resourcePrimKey)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchArticleResourceException {
        return getPersistence().findByPrimaryKey(resourcePrimKey);
    }

    public static com.nss.portlet.journal.model.JournalArticleResource fetchByPrimaryKey(
        long resourcePrimKey) throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(resourcePrimKey);
    }

    public static java.util.List<com.nss.portlet.journal.model.JournalArticleResource> findByGroupId(
        long groupId) throws com.liferay.portal.SystemException {
        return getPersistence().findByGroupId(groupId);
    }

    public static java.util.List<com.nss.portlet.journal.model.JournalArticleResource> findByGroupId(
        long groupId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByGroupId(groupId, start, end);
    }

    public static java.util.List<com.nss.portlet.journal.model.JournalArticleResource> findByGroupId(
        long groupId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByGroupId(groupId, start, end, obc);
    }

    public static com.nss.portlet.journal.model.JournalArticleResource findByGroupId_First(
        long groupId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchArticleResourceException {
        return getPersistence().findByGroupId_First(groupId, obc);
    }

    public static com.nss.portlet.journal.model.JournalArticleResource findByGroupId_Last(
        long groupId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchArticleResourceException {
        return getPersistence().findByGroupId_Last(groupId, obc);
    }

    public static com.nss.portlet.journal.model.JournalArticleResource[] findByGroupId_PrevAndNext(
        long resourcePrimKey, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchArticleResourceException {
        return getPersistence()
                   .findByGroupId_PrevAndNext(resourcePrimKey, groupId, obc);
    }

    public static com.nss.portlet.journal.model.JournalArticleResource findByG_A(
        long groupId, java.lang.String articleId)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchArticleResourceException {
        return getPersistence().findByG_A(groupId, articleId);
    }

    public static com.nss.portlet.journal.model.JournalArticleResource fetchByG_A(
        long groupId, java.lang.String articleId)
        throws com.liferay.portal.SystemException {
        return getPersistence().fetchByG_A(groupId, articleId);
    }

    public static com.nss.portlet.journal.model.JournalArticleResource fetchByG_A(
        long groupId, java.lang.String articleId, boolean retrieveFromCache)
        throws com.liferay.portal.SystemException {
        return getPersistence().fetchByG_A(groupId, articleId, retrieveFromCache);
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

    public static java.util.List<com.nss.portlet.journal.model.JournalArticleResource> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.nss.portlet.journal.model.JournalArticleResource> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.nss.portlet.journal.model.JournalArticleResource> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end, obc);
    }

    public static void removeByGroupId(long groupId)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByGroupId(groupId);
    }

    public static void removeByG_A(long groupId, java.lang.String articleId)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchArticleResourceException {
        getPersistence().removeByG_A(groupId, articleId);
    }

    public static void removeAll() throws com.liferay.portal.SystemException {
        getPersistence().removeAll();
    }

    public static int countByGroupId(long groupId)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByGroupId(groupId);
    }

    public static int countByG_A(long groupId, java.lang.String articleId)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByG_A(groupId, articleId);
    }

    public static int countAll() throws com.liferay.portal.SystemException {
        return getPersistence().countAll();
    }

    public static JournalArticleResourcePersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(JournalArticleResourcePersistence persistence) {
        _persistence = persistence;
    }
}
