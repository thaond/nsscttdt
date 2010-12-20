package com.nss.portlet.journal.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;


public interface JournalArticleResourcePersistence extends BasePersistence {
    public void cacheResult(
        com.nss.portlet.journal.model.JournalArticleResource journalArticleResource);

    public void cacheResult(
        java.util.List<com.nss.portlet.journal.model.JournalArticleResource> journalArticleResources);

    public void clearCache();

    public com.nss.portlet.journal.model.JournalArticleResource create(
        long resourcePrimKey);

    public com.nss.portlet.journal.model.JournalArticleResource remove(
        long resourcePrimKey)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchArticleResourceException;

    public com.nss.portlet.journal.model.JournalArticleResource remove(
        com.nss.portlet.journal.model.JournalArticleResource journalArticleResource)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(JournalArticleResource journalArticleResource, boolean merge)</code>.
     */
    public com.nss.portlet.journal.model.JournalArticleResource update(
        com.nss.portlet.journal.model.JournalArticleResource journalArticleResource)
        throws com.liferay.portal.SystemException;

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
    public com.nss.portlet.journal.model.JournalArticleResource update(
        com.nss.portlet.journal.model.JournalArticleResource journalArticleResource,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.nss.portlet.journal.model.JournalArticleResource updateImpl(
        com.nss.portlet.journal.model.JournalArticleResource journalArticleResource,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.nss.portlet.journal.model.JournalArticleResource findByPrimaryKey(
        long resourcePrimKey)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchArticleResourceException;

    public com.nss.portlet.journal.model.JournalArticleResource fetchByPrimaryKey(
        long resourcePrimKey) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.journal.model.JournalArticleResource> findByGroupId(
        long groupId) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.journal.model.JournalArticleResource> findByGroupId(
        long groupId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.journal.model.JournalArticleResource> findByGroupId(
        long groupId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.journal.model.JournalArticleResource findByGroupId_First(
        long groupId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchArticleResourceException;

    public com.nss.portlet.journal.model.JournalArticleResource findByGroupId_Last(
        long groupId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchArticleResourceException;

    public com.nss.portlet.journal.model.JournalArticleResource[] findByGroupId_PrevAndNext(
        long resourcePrimKey, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchArticleResourceException;

    public com.nss.portlet.journal.model.JournalArticleResource findByG_A(
        long groupId, java.lang.String articleId)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchArticleResourceException;

    public com.nss.portlet.journal.model.JournalArticleResource fetchByG_A(
        long groupId, java.lang.String articleId)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.journal.model.JournalArticleResource fetchByG_A(
        long groupId, java.lang.String articleId, boolean retrieveFromCache)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.journal.model.JournalArticleResource> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.journal.model.JournalArticleResource> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.journal.model.JournalArticleResource> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeByGroupId(long groupId)
        throws com.liferay.portal.SystemException;

    public void removeByG_A(long groupId, java.lang.String articleId)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchArticleResourceException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countByGroupId(long groupId)
        throws com.liferay.portal.SystemException;

    public int countByG_A(long groupId, java.lang.String articleId)
        throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;
}
