package com.nss.portlet.managementworkflowjournal.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;


public interface WorkflowJournalArticlePersistence extends BasePersistence {
    public void cacheResult(
        com.nss.portlet.managementworkflowjournal.model.WorkflowJournalArticle workflowJournalArticle);

    public void cacheResult(
        java.util.List<com.nss.portlet.managementworkflowjournal.model.WorkflowJournalArticle> workflowJournalArticles);

    public void clearCache();

    public com.nss.portlet.managementworkflowjournal.model.WorkflowJournalArticle create(
        long workflowJournalArticleId);

    public com.nss.portlet.managementworkflowjournal.model.WorkflowJournalArticle remove(
        long workflowJournalArticleId)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.managementworkflowjournal.NoSuchWorkflowJournalArticleException;

    public com.nss.portlet.managementworkflowjournal.model.WorkflowJournalArticle remove(
        com.nss.portlet.managementworkflowjournal.model.WorkflowJournalArticle workflowJournalArticle)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(WorkflowJournalArticle workflowJournalArticle, boolean merge)</code>.
     */
    public com.nss.portlet.managementworkflowjournal.model.WorkflowJournalArticle update(
        com.nss.portlet.managementworkflowjournal.model.WorkflowJournalArticle workflowJournalArticle)
        throws com.liferay.portal.SystemException;

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
    public com.nss.portlet.managementworkflowjournal.model.WorkflowJournalArticle update(
        com.nss.portlet.managementworkflowjournal.model.WorkflowJournalArticle workflowJournalArticle,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.nss.portlet.managementworkflowjournal.model.WorkflowJournalArticle updateImpl(
        com.nss.portlet.managementworkflowjournal.model.WorkflowJournalArticle workflowJournalArticle,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.nss.portlet.managementworkflowjournal.model.WorkflowJournalArticle findByPrimaryKey(
        long workflowJournalArticleId)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.managementworkflowjournal.NoSuchWorkflowJournalArticleException;

    public com.nss.portlet.managementworkflowjournal.model.WorkflowJournalArticle fetchByPrimaryKey(
        long workflowJournalArticleId)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.managementworkflowjournal.model.WorkflowJournalArticle findByResourcePrimkey(
        long resourcePrimkey)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.managementworkflowjournal.NoSuchWorkflowJournalArticleException;

    public com.nss.portlet.managementworkflowjournal.model.WorkflowJournalArticle fetchByResourcePrimkey(
        long resourcePrimkey) throws com.liferay.portal.SystemException;

    public com.nss.portlet.managementworkflowjournal.model.WorkflowJournalArticle fetchByResourcePrimkey(
        long resourcePrimkey, boolean retrieveFromCache)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.managementworkflowjournal.model.WorkflowJournalArticle findByProcessInstanceId(
        long processInstanceId)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.managementworkflowjournal.NoSuchWorkflowJournalArticleException;

    public com.nss.portlet.managementworkflowjournal.model.WorkflowJournalArticle fetchByProcessInstanceId(
        long processInstanceId) throws com.liferay.portal.SystemException;

    public com.nss.portlet.managementworkflowjournal.model.WorkflowJournalArticle fetchByProcessInstanceId(
        long processInstanceId, boolean retrieveFromCache)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.managementworkflowjournal.model.WorkflowJournalArticle> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.managementworkflowjournal.model.WorkflowJournalArticle> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.managementworkflowjournal.model.WorkflowJournalArticle> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeByResourcePrimkey(long resourcePrimkey)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.managementworkflowjournal.NoSuchWorkflowJournalArticleException;

    public void removeByProcessInstanceId(long processInstanceId)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.managementworkflowjournal.NoSuchWorkflowJournalArticleException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countByResourcePrimkey(long resourcePrimkey)
        throws com.liferay.portal.SystemException;

    public int countByProcessInstanceId(long processInstanceId)
        throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;
}
