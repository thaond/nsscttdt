package com.nss.portlet.managementworkflowjournal.service.persistence;

public class WorkflowJournalArticleUtil {
    private static WorkflowJournalArticlePersistence _persistence;

    public static void cacheResult(
        com.nss.portlet.managementworkflowjournal.model.WorkflowJournalArticle workflowJournalArticle) {
        getPersistence().cacheResult(workflowJournalArticle);
    }

    public static void cacheResult(
        java.util.List<com.nss.portlet.managementworkflowjournal.model.WorkflowJournalArticle> workflowJournalArticles) {
        getPersistence().cacheResult(workflowJournalArticles);
    }

    public static void clearCache() {
        getPersistence().clearCache();
    }

    public static com.nss.portlet.managementworkflowjournal.model.WorkflowJournalArticle create(
        long workflowJournalArticleId) {
        return getPersistence().create(workflowJournalArticleId);
    }

    public static com.nss.portlet.managementworkflowjournal.model.WorkflowJournalArticle remove(
        long workflowJournalArticleId)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.managementworkflowjournal.NoSuchWorkflowJournalArticleException {
        return getPersistence().remove(workflowJournalArticleId);
    }

    public static com.nss.portlet.managementworkflowjournal.model.WorkflowJournalArticle remove(
        com.nss.portlet.managementworkflowjournal.model.WorkflowJournalArticle workflowJournalArticle)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(workflowJournalArticle);
    }

    /**
     * @deprecated Use <code>update(WorkflowJournalArticle workflowJournalArticle, boolean merge)</code>.
     */
    public static com.nss.portlet.managementworkflowjournal.model.WorkflowJournalArticle update(
        com.nss.portlet.managementworkflowjournal.model.WorkflowJournalArticle workflowJournalArticle)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(workflowJournalArticle);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                workflowJournalArticle the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when workflowJournalArticle is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public static com.nss.portlet.managementworkflowjournal.model.WorkflowJournalArticle update(
        com.nss.portlet.managementworkflowjournal.model.WorkflowJournalArticle workflowJournalArticle,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().update(workflowJournalArticle, merge);
    }

    public static com.nss.portlet.managementworkflowjournal.model.WorkflowJournalArticle updateImpl(
        com.nss.portlet.managementworkflowjournal.model.WorkflowJournalArticle workflowJournalArticle,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(workflowJournalArticle, merge);
    }

    public static com.nss.portlet.managementworkflowjournal.model.WorkflowJournalArticle findByPrimaryKey(
        long workflowJournalArticleId)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.managementworkflowjournal.NoSuchWorkflowJournalArticleException {
        return getPersistence().findByPrimaryKey(workflowJournalArticleId);
    }

    public static com.nss.portlet.managementworkflowjournal.model.WorkflowJournalArticle fetchByPrimaryKey(
        long workflowJournalArticleId)
        throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(workflowJournalArticleId);
    }

    public static com.nss.portlet.managementworkflowjournal.model.WorkflowJournalArticle findByResourcePrimkey(
        long resourcePrimkey)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.managementworkflowjournal.NoSuchWorkflowJournalArticleException {
        return getPersistence().findByResourcePrimkey(resourcePrimkey);
    }

    public static com.nss.portlet.managementworkflowjournal.model.WorkflowJournalArticle fetchByResourcePrimkey(
        long resourcePrimkey) throws com.liferay.portal.SystemException {
        return getPersistence().fetchByResourcePrimkey(resourcePrimkey);
    }

    public static com.nss.portlet.managementworkflowjournal.model.WorkflowJournalArticle fetchByResourcePrimkey(
        long resourcePrimkey, boolean retrieveFromCache)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .fetchByResourcePrimkey(resourcePrimkey, retrieveFromCache);
    }

    public static com.nss.portlet.managementworkflowjournal.model.WorkflowJournalArticle findByProcessInstanceId(
        long processInstanceId)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.managementworkflowjournal.NoSuchWorkflowJournalArticleException {
        return getPersistence().findByProcessInstanceId(processInstanceId);
    }

    public static com.nss.portlet.managementworkflowjournal.model.WorkflowJournalArticle fetchByProcessInstanceId(
        long processInstanceId) throws com.liferay.portal.SystemException {
        return getPersistence().fetchByProcessInstanceId(processInstanceId);
    }

    public static com.nss.portlet.managementworkflowjournal.model.WorkflowJournalArticle fetchByProcessInstanceId(
        long processInstanceId, boolean retrieveFromCache)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .fetchByProcessInstanceId(processInstanceId,
            retrieveFromCache);
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

    public static java.util.List<com.nss.portlet.managementworkflowjournal.model.WorkflowJournalArticle> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.nss.portlet.managementworkflowjournal.model.WorkflowJournalArticle> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.nss.portlet.managementworkflowjournal.model.WorkflowJournalArticle> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end, obc);
    }

    public static void removeByResourcePrimkey(long resourcePrimkey)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.managementworkflowjournal.NoSuchWorkflowJournalArticleException {
        getPersistence().removeByResourcePrimkey(resourcePrimkey);
    }

    public static void removeByProcessInstanceId(long processInstanceId)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.managementworkflowjournal.NoSuchWorkflowJournalArticleException {
        getPersistence().removeByProcessInstanceId(processInstanceId);
    }

    public static void removeAll() throws com.liferay.portal.SystemException {
        getPersistence().removeAll();
    }

    public static int countByResourcePrimkey(long resourcePrimkey)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByResourcePrimkey(resourcePrimkey);
    }

    public static int countByProcessInstanceId(long processInstanceId)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByProcessInstanceId(processInstanceId);
    }

    public static int countAll() throws com.liferay.portal.SystemException {
        return getPersistence().countAll();
    }

    public static WorkflowJournalArticlePersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(WorkflowJournalArticlePersistence persistence) {
        _persistence = persistence;
    }
}
