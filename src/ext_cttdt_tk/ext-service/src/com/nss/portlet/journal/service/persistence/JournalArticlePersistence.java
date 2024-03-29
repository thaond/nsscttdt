package com.nss.portlet.journal.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;


public interface JournalArticlePersistence extends BasePersistence {
    public void cacheResult(
        com.nss.portlet.journal.model.JournalArticle journalArticle);

    public void cacheResult(
        java.util.List<com.nss.portlet.journal.model.JournalArticle> journalArticles);

    public void clearCache();

    public com.nss.portlet.journal.model.JournalArticle create(long id);

    public com.nss.portlet.journal.model.JournalArticle remove(long id)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchArticleException;

    public com.nss.portlet.journal.model.JournalArticle remove(
        com.nss.portlet.journal.model.JournalArticle journalArticle)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(JournalArticle journalArticle, boolean merge)</code>.
     */
    public com.nss.portlet.journal.model.JournalArticle update(
        com.nss.portlet.journal.model.JournalArticle journalArticle)
        throws com.liferay.portal.SystemException;

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                journalArticle the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when journalArticle is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public com.nss.portlet.journal.model.JournalArticle update(
        com.nss.portlet.journal.model.JournalArticle journalArticle,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.nss.portlet.journal.model.JournalArticle updateImpl(
        com.nss.portlet.journal.model.JournalArticle journalArticle,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.nss.portlet.journal.model.JournalArticle findByPrimaryKey(
        long id)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchArticleException;

    public com.nss.portlet.journal.model.JournalArticle fetchByPrimaryKey(
        long id) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.journal.model.JournalArticle> findByUuid(
        java.lang.String uuid) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.journal.model.JournalArticle> findByUuid(
        java.lang.String uuid, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.journal.model.JournalArticle> findByUuid(
        java.lang.String uuid, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.journal.model.JournalArticle findByUuid_First(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchArticleException;

    public com.nss.portlet.journal.model.JournalArticle findByUuid_Last(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchArticleException;

    public com.nss.portlet.journal.model.JournalArticle[] findByUuid_PrevAndNext(
        long id, java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchArticleException;

    public com.nss.portlet.journal.model.JournalArticle findByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchArticleException;

    public com.nss.portlet.journal.model.JournalArticle fetchByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.journal.model.JournalArticle fetchByUUID_G(
        java.lang.String uuid, long groupId, boolean retrieveFromCache)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.journal.model.JournalArticle> findByGroupId(
        long groupId) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.journal.model.JournalArticle> findByGroupId(
        long groupId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.journal.model.JournalArticle> findByGroupId(
        long groupId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.journal.model.JournalArticle findByGroupId_First(
        long groupId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchArticleException;

    public com.nss.portlet.journal.model.JournalArticle findByGroupId_Last(
        long groupId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchArticleException;

    public com.nss.portlet.journal.model.JournalArticle[] findByGroupId_PrevAndNext(
        long id, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchArticleException;

    public java.util.List<com.nss.portlet.journal.model.JournalArticle> findByCompanyId(
        long companyId) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.journal.model.JournalArticle> findByCompanyId(
        long companyId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.journal.model.JournalArticle> findByCompanyId(
        long companyId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.journal.model.JournalArticle findByCompanyId_First(
        long companyId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchArticleException;

    public com.nss.portlet.journal.model.JournalArticle findByCompanyId_Last(
        long companyId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchArticleException;

    public com.nss.portlet.journal.model.JournalArticle[] findByCompanyId_PrevAndNext(
        long id, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchArticleException;

    public java.util.List<com.nss.portlet.journal.model.JournalArticle> findBySmallImageId(
        long smallImageId) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.journal.model.JournalArticle> findBySmallImageId(
        long smallImageId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.journal.model.JournalArticle> findBySmallImageId(
        long smallImageId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.journal.model.JournalArticle findBySmallImageId_First(
        long smallImageId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchArticleException;

    public com.nss.portlet.journal.model.JournalArticle findBySmallImageId_Last(
        long smallImageId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchArticleException;

    public com.nss.portlet.journal.model.JournalArticle[] findBySmallImageId_PrevAndNext(
        long id, long smallImageId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchArticleException;

    public java.util.List<com.nss.portlet.journal.model.JournalArticle> findByR_A(
        long resourcePrimKey, boolean approved)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.journal.model.JournalArticle> findByR_A(
        long resourcePrimKey, boolean approved, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.journal.model.JournalArticle> findByR_A(
        long resourcePrimKey, boolean approved, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.journal.model.JournalArticle findByR_A_First(
        long resourcePrimKey, boolean approved,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchArticleException;

    public com.nss.portlet.journal.model.JournalArticle findByR_A_Last(
        long resourcePrimKey, boolean approved,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchArticleException;

    public com.nss.portlet.journal.model.JournalArticle[] findByR_A_PrevAndNext(
        long id, long resourcePrimKey, boolean approved,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchArticleException;

    public java.util.List<com.nss.portlet.journal.model.JournalArticle> findByG_A(
        long groupId, java.lang.String articleId)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.journal.model.JournalArticle> findByG_A(
        long groupId, java.lang.String articleId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.journal.model.JournalArticle> findByG_A(
        long groupId, java.lang.String articleId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.journal.model.JournalArticle findByG_A_First(
        long groupId, java.lang.String articleId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchArticleException;

    public com.nss.portlet.journal.model.JournalArticle findByG_A_Last(
        long groupId, java.lang.String articleId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchArticleException;

    public com.nss.portlet.journal.model.JournalArticle[] findByG_A_PrevAndNext(
        long id, long groupId, java.lang.String articleId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchArticleException;

    public java.util.List<com.nss.portlet.journal.model.JournalArticle> findByG_S(
        long groupId, java.lang.String structureId)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.journal.model.JournalArticle> findByG_S(
        long groupId, java.lang.String structureId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.journal.model.JournalArticle> findByG_S(
        long groupId, java.lang.String structureId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.journal.model.JournalArticle findByG_S_First(
        long groupId, java.lang.String structureId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchArticleException;

    public com.nss.portlet.journal.model.JournalArticle findByG_S_Last(
        long groupId, java.lang.String structureId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchArticleException;

    public com.nss.portlet.journal.model.JournalArticle[] findByG_S_PrevAndNext(
        long id, long groupId, java.lang.String structureId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchArticleException;

    public java.util.List<com.nss.portlet.journal.model.JournalArticle> findByG_T(
        long groupId, java.lang.String templateId)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.journal.model.JournalArticle> findByG_T(
        long groupId, java.lang.String templateId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.journal.model.JournalArticle> findByG_T(
        long groupId, java.lang.String templateId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.journal.model.JournalArticle findByG_T_First(
        long groupId, java.lang.String templateId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchArticleException;

    public com.nss.portlet.journal.model.JournalArticle findByG_T_Last(
        long groupId, java.lang.String templateId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchArticleException;

    public com.nss.portlet.journal.model.JournalArticle[] findByG_T_PrevAndNext(
        long id, long groupId, java.lang.String templateId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchArticleException;

    public java.util.List<com.nss.portlet.journal.model.JournalArticle> findByG_UT(
        long groupId, java.lang.String urlTitle)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.journal.model.JournalArticle> findByG_UT(
        long groupId, java.lang.String urlTitle, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.journal.model.JournalArticle> findByG_UT(
        long groupId, java.lang.String urlTitle, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.journal.model.JournalArticle findByG_UT_First(
        long groupId, java.lang.String urlTitle,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchArticleException;

    public com.nss.portlet.journal.model.JournalArticle findByG_UT_Last(
        long groupId, java.lang.String urlTitle,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchArticleException;

    public com.nss.portlet.journal.model.JournalArticle[] findByG_UT_PrevAndNext(
        long id, long groupId, java.lang.String urlTitle,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchArticleException;

    public com.nss.portlet.journal.model.JournalArticle findByG_A_V(
        long groupId, java.lang.String articleId, double version)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchArticleException;

    public com.nss.portlet.journal.model.JournalArticle fetchByG_A_V(
        long groupId, java.lang.String articleId, double version)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.journal.model.JournalArticle fetchByG_A_V(
        long groupId, java.lang.String articleId, double version,
        boolean retrieveFromCache) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.journal.model.JournalArticle> findByG_A_A(
        long groupId, java.lang.String articleId, boolean approved)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.journal.model.JournalArticle> findByG_A_A(
        long groupId, java.lang.String articleId, boolean approved, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.journal.model.JournalArticle> findByG_A_A(
        long groupId, java.lang.String articleId, boolean approved, int start,
        int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.journal.model.JournalArticle findByG_A_A_First(
        long groupId, java.lang.String articleId, boolean approved,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchArticleException;

    public com.nss.portlet.journal.model.JournalArticle findByG_A_A_Last(
        long groupId, java.lang.String articleId, boolean approved,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchArticleException;

    public com.nss.portlet.journal.model.JournalArticle[] findByG_A_A_PrevAndNext(
        long id, long groupId, java.lang.String articleId, boolean approved,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchArticleException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.journal.model.JournalArticle> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.journal.model.JournalArticle> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.journal.model.JournalArticle> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeByUuid(java.lang.String uuid)
        throws com.liferay.portal.SystemException;

    public void removeByUUID_G(java.lang.String uuid, long groupId)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchArticleException;

    public void removeByGroupId(long groupId)
        throws com.liferay.portal.SystemException;

    public void removeByCompanyId(long companyId)
        throws com.liferay.portal.SystemException;

    public void removeBySmallImageId(long smallImageId)
        throws com.liferay.portal.SystemException;

    public void removeByR_A(long resourcePrimKey, boolean approved)
        throws com.liferay.portal.SystemException;

    public void removeByG_A(long groupId, java.lang.String articleId)
        throws com.liferay.portal.SystemException;

    public void removeByG_S(long groupId, java.lang.String structureId)
        throws com.liferay.portal.SystemException;

    public void removeByG_T(long groupId, java.lang.String templateId)
        throws com.liferay.portal.SystemException;

    public void removeByG_UT(long groupId, java.lang.String urlTitle)
        throws com.liferay.portal.SystemException;

    public void removeByG_A_V(long groupId, java.lang.String articleId,
        double version)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchArticleException;

    public void removeByG_A_A(long groupId, java.lang.String articleId,
        boolean approved) throws com.liferay.portal.SystemException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countByUuid(java.lang.String uuid)
        throws com.liferay.portal.SystemException;

    public int countByUUID_G(java.lang.String uuid, long groupId)
        throws com.liferay.portal.SystemException;

    public int countByGroupId(long groupId)
        throws com.liferay.portal.SystemException;

    public int countByCompanyId(long companyId)
        throws com.liferay.portal.SystemException;

    public int countBySmallImageId(long smallImageId)
        throws com.liferay.portal.SystemException;

    public int countByR_A(long resourcePrimKey, boolean approved)
        throws com.liferay.portal.SystemException;

    public int countByG_A(long groupId, java.lang.String articleId)
        throws com.liferay.portal.SystemException;

    public int countByG_S(long groupId, java.lang.String structureId)
        throws com.liferay.portal.SystemException;

    public int countByG_T(long groupId, java.lang.String templateId)
        throws com.liferay.portal.SystemException;

    public int countByG_UT(long groupId, java.lang.String urlTitle)
        throws com.liferay.portal.SystemException;

    public int countByG_A_V(long groupId, java.lang.String articleId,
        double version) throws com.liferay.portal.SystemException;

    public int countByG_A_A(long groupId, java.lang.String articleId,
        boolean approved) throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;
}
