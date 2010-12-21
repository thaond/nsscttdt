package com.nss.portlet.managementworkflowjournal.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;


public interface LogWorkflowJournalArticlePersistence extends BasePersistence {
    public void cacheResult(
        com.nss.portlet.managementworkflowjournal.model.LogWorkflowJournalArticle logWorkflowJournalArticle);

    public void cacheResult(
        java.util.List<com.nss.portlet.managementworkflowjournal.model.LogWorkflowJournalArticle> logWorkflowJournalArticles);

    public void clearCache();

    public com.nss.portlet.managementworkflowjournal.model.LogWorkflowJournalArticle create(
        long logWorkflowJournalArticleId);

    public com.nss.portlet.managementworkflowjournal.model.LogWorkflowJournalArticle remove(
        long logWorkflowJournalArticleId)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.managementworkflowjournal.NoSuchLogWorkflowJournalArticleException;

    public com.nss.portlet.managementworkflowjournal.model.LogWorkflowJournalArticle remove(
        com.nss.portlet.managementworkflowjournal.model.LogWorkflowJournalArticle logWorkflowJournalArticle)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(LogWorkflowJournalArticle logWorkflowJournalArticle, boolean merge)</code>.
     */
    public com.nss.portlet.managementworkflowjournal.model.LogWorkflowJournalArticle update(
        com.nss.portlet.managementworkflowjournal.model.LogWorkflowJournalArticle logWorkflowJournalArticle)
        throws com.liferay.portal.SystemException;

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
    public com.nss.portlet.managementworkflowjournal.model.LogWorkflowJournalArticle update(
        com.nss.portlet.managementworkflowjournal.model.LogWorkflowJournalArticle logWorkflowJournalArticle,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.nss.portlet.managementworkflowjournal.model.LogWorkflowJournalArticle updateImpl(
        com.nss.portlet.managementworkflowjournal.model.LogWorkflowJournalArticle logWorkflowJournalArticle,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.nss.portlet.managementworkflowjournal.model.LogWorkflowJournalArticle findByPrimaryKey(
        long logWorkflowJournalArticleId)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.managementworkflowjournal.NoSuchLogWorkflowJournalArticleException;

    public com.nss.portlet.managementworkflowjournal.model.LogWorkflowJournalArticle fetchByPrimaryKey(
        long logWorkflowJournalArticleId)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.managementworkflowjournal.model.LogWorkflowJournalArticle> findByResourcePrimkey(
        long resourcePrimkey) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.managementworkflowjournal.model.LogWorkflowJournalArticle> findByResourcePrimkey(
        long resourcePrimkey, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.managementworkflowjournal.model.LogWorkflowJournalArticle> findByResourcePrimkey(
        long resourcePrimkey, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.managementworkflowjournal.model.LogWorkflowJournalArticle findByResourcePrimkey_First(
        long resourcePrimkey,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.managementworkflowjournal.NoSuchLogWorkflowJournalArticleException;

    public com.nss.portlet.managementworkflowjournal.model.LogWorkflowJournalArticle findByResourcePrimkey_Last(
        long resourcePrimkey,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.managementworkflowjournal.NoSuchLogWorkflowJournalArticleException;

    public com.nss.portlet.managementworkflowjournal.model.LogWorkflowJournalArticle[] findByResourcePrimkey_PrevAndNext(
        long logWorkflowJournalArticleId, long resourcePrimkey,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.managementworkflowjournal.NoSuchLogWorkflowJournalArticleException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.managementworkflowjournal.model.LogWorkflowJournalArticle> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.managementworkflowjournal.model.LogWorkflowJournalArticle> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.managementworkflowjournal.model.LogWorkflowJournalArticle> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeByResourcePrimkey(long resourcePrimkey)
        throws com.liferay.portal.SystemException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countByResourcePrimkey(long resourcePrimkey)
        throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;
}
