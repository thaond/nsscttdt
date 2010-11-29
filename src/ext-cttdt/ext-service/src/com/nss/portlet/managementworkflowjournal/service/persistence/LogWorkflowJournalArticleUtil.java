package com.nss.portlet.managementworkflowjournal.service.persistence;

public class LogWorkflowJournalArticleUtil {
    private static LogWorkflowJournalArticlePersistence _persistence;

    public static void cacheResult(
        com.nss.portlet.managementworkflowjournal.model.LogWorkflowJournalArticle logWorkflowJournalArticle) {
        getPersistence().cacheResult(logWorkflowJournalArticle);
    }

    public static void cacheResult(
        java.util.List<com.nss.portlet.managementworkflowjournal.model.LogWorkflowJournalArticle> logWorkflowJournalArticles) {
        getPersistence().cacheResult(logWorkflowJournalArticles);
    }

    public static void clearCache() {
        getPersistence().clearCache();
    }

    public static com.nss.portlet.managementworkflowjournal.model.LogWorkflowJournalArticle create(
        long logWorkflowJournalArticleId) {
        return getPersistence().create(logWorkflowJournalArticleId);
    }

    public static com.nss.portlet.managementworkflowjournal.model.LogWorkflowJournalArticle remove(
        long logWorkflowJournalArticleId)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.managementworkflowjournal.NoSuchLogWorkflowJournalArticleException {
        return getPersistence().remove(logWorkflowJournalArticleId);
    }

    public static com.nss.portlet.managementworkflowjournal.model.LogWorkflowJournalArticle remove(
        com.nss.portlet.managementworkflowjournal.model.LogWorkflowJournalArticle logWorkflowJournalArticle)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(logWorkflowJournalArticle);
    }

    /**
     * @deprecated Use <code>update(LogWorkflowJournalArticle logWorkflowJournalArticle, boolean merge)</code>.
     */
    public static com.nss.portlet.managementworkflowjournal.model.LogWorkflowJournalArticle update(
        com.nss.portlet.managementworkflowjournal.model.LogWorkflowJournalArticle logWorkflowJournalArticle)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(logWorkflowJournalArticle);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                logWorkflowJournalArticle the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when logWorkflowJournalArticle is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public static com.nss.portlet.managementworkflowjournal.model.LogWorkflowJournalArticle update(
        com.nss.portlet.managementworkflowjournal.model.LogWorkflowJournalArticle logWorkflowJournalArticle,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().update(logWorkflowJournalArticle, merge);
    }

    public static com.nss.portlet.managementworkflowjournal.model.LogWorkflowJournalArticle updateImpl(
        com.nss.portlet.managementworkflowjournal.model.LogWorkflowJournalArticle logWorkflowJournalArticle,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(logWorkflowJournalArticle, merge);
    }

    public static com.nss.portlet.managementworkflowjournal.model.LogWorkflowJournalArticle findByPrimaryKey(
        long logWorkflowJournalArticleId)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.managementworkflowjournal.NoSuchLogWorkflowJournalArticleException {
        return getPersistence().findByPrimaryKey(logWorkflowJournalArticleId);
    }

    public static com.nss.portlet.managementworkflowjournal.model.LogWorkflowJournalArticle fetchByPrimaryKey(
        long logWorkflowJournalArticleId)
        throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(logWorkflowJournalArticleId);
    }

    public static java.util.List<com.nss.portlet.managementworkflowjournal.model.LogWorkflowJournalArticle> findByResourcePrimkey(
        long resourcePrimkey) throws com.liferay.portal.SystemException {
        return getPersistence().findByResourcePrimkey(resourcePrimkey);
    }

    public static java.util.List<com.nss.portlet.managementworkflowjournal.model.LogWorkflowJournalArticle> findByResourcePrimkey(
        long resourcePrimkey, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByResourcePrimkey(resourcePrimkey, start, end);
    }

    public static java.util.List<com.nss.portlet.managementworkflowjournal.model.LogWorkflowJournalArticle> findByResourcePrimkey(
        long resourcePrimkey, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByResourcePrimkey(resourcePrimkey, start, end, obc);
    }

    public static com.nss.portlet.managementworkflowjournal.model.LogWorkflowJournalArticle findByResourcePrimkey_First(
        long resourcePrimkey,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.managementworkflowjournal.NoSuchLogWorkflowJournalArticleException {
        return getPersistence().findByResourcePrimkey_First(resourcePrimkey, obc);
    }

    public static com.nss.portlet.managementworkflowjournal.model.LogWorkflowJournalArticle findByResourcePrimkey_Last(
        long resourcePrimkey,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.managementworkflowjournal.NoSuchLogWorkflowJournalArticleException {
        return getPersistence().findByResourcePrimkey_Last(resourcePrimkey, obc);
    }

    public static com.nss.portlet.managementworkflowjournal.model.LogWorkflowJournalArticle[] findByResourcePrimkey_PrevAndNext(
        long logWorkflowJournalArticleId, long resourcePrimkey,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.managementworkflowjournal.NoSuchLogWorkflowJournalArticleException {
        return getPersistence()
                   .findByResourcePrimkey_PrevAndNext(logWorkflowJournalArticleId,
            resourcePrimkey, obc);
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

    public static java.util.List<com.nss.portlet.managementworkflowjournal.model.LogWorkflowJournalArticle> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.nss.portlet.managementworkflowjournal.model.LogWorkflowJournalArticle> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.nss.portlet.managementworkflowjournal.model.LogWorkflowJournalArticle> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end, obc);
    }

    public static void removeByResourcePrimkey(long resourcePrimkey)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByResourcePrimkey(resourcePrimkey);
    }

    public static void removeAll() throws com.liferay.portal.SystemException {
        getPersistence().removeAll();
    }

    public static int countByResourcePrimkey(long resourcePrimkey)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByResourcePrimkey(resourcePrimkey);
    }

    public static int countAll() throws com.liferay.portal.SystemException {
        return getPersistence().countAll();
    }

    public static LogWorkflowJournalArticlePersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(LogWorkflowJournalArticlePersistence persistence) {
        _persistence = persistence;
    }
}
