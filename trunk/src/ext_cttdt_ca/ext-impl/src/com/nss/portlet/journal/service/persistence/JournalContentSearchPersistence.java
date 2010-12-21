package com.nss.portlet.journal.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;


public interface JournalContentSearchPersistence extends BasePersistence {
    public void cacheResult(
        com.nss.portlet.journal.model.JournalContentSearch journalContentSearch);

    public void cacheResult(
        java.util.List<com.nss.portlet.journal.model.JournalContentSearch> journalContentSearchs);

    public void clearCache();

    public com.nss.portlet.journal.model.JournalContentSearch create(
        long contentSearchId);

    public com.nss.portlet.journal.model.JournalContentSearch remove(
        long contentSearchId)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchContentSearchException;

    public com.nss.portlet.journal.model.JournalContentSearch remove(
        com.nss.portlet.journal.model.JournalContentSearch journalContentSearch)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(JournalContentSearch journalContentSearch, boolean merge)</code>.
     */
    public com.nss.portlet.journal.model.JournalContentSearch update(
        com.nss.portlet.journal.model.JournalContentSearch journalContentSearch)
        throws com.liferay.portal.SystemException;

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                journalContentSearch the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when journalContentSearch is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public com.nss.portlet.journal.model.JournalContentSearch update(
        com.nss.portlet.journal.model.JournalContentSearch journalContentSearch,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.nss.portlet.journal.model.JournalContentSearch updateImpl(
        com.nss.portlet.journal.model.JournalContentSearch journalContentSearch,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.nss.portlet.journal.model.JournalContentSearch findByPrimaryKey(
        long contentSearchId)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchContentSearchException;

    public com.nss.portlet.journal.model.JournalContentSearch fetchByPrimaryKey(
        long contentSearchId) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.journal.model.JournalContentSearch> findByG_P(
        long groupId, boolean privateLayout)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.journal.model.JournalContentSearch> findByG_P(
        long groupId, boolean privateLayout, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.journal.model.JournalContentSearch> findByG_P(
        long groupId, boolean privateLayout, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.journal.model.JournalContentSearch findByG_P_First(
        long groupId, boolean privateLayout,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchContentSearchException;

    public com.nss.portlet.journal.model.JournalContentSearch findByG_P_Last(
        long groupId, boolean privateLayout,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchContentSearchException;

    public com.nss.portlet.journal.model.JournalContentSearch[] findByG_P_PrevAndNext(
        long contentSearchId, long groupId, boolean privateLayout,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchContentSearchException;

    public java.util.List<com.nss.portlet.journal.model.JournalContentSearch> findByG_A(
        long groupId, java.lang.String articleId)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.journal.model.JournalContentSearch> findByG_A(
        long groupId, java.lang.String articleId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.journal.model.JournalContentSearch> findByG_A(
        long groupId, java.lang.String articleId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.journal.model.JournalContentSearch findByG_A_First(
        long groupId, java.lang.String articleId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchContentSearchException;

    public com.nss.portlet.journal.model.JournalContentSearch findByG_A_Last(
        long groupId, java.lang.String articleId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchContentSearchException;

    public com.nss.portlet.journal.model.JournalContentSearch[] findByG_A_PrevAndNext(
        long contentSearchId, long groupId, java.lang.String articleId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchContentSearchException;

    public java.util.List<com.nss.portlet.journal.model.JournalContentSearch> findByG_P_L(
        long groupId, boolean privateLayout, long layoutId)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.journal.model.JournalContentSearch> findByG_P_L(
        long groupId, boolean privateLayout, long layoutId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.journal.model.JournalContentSearch> findByG_P_L(
        long groupId, boolean privateLayout, long layoutId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.journal.model.JournalContentSearch findByG_P_L_First(
        long groupId, boolean privateLayout, long layoutId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchContentSearchException;

    public com.nss.portlet.journal.model.JournalContentSearch findByG_P_L_Last(
        long groupId, boolean privateLayout, long layoutId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchContentSearchException;

    public com.nss.portlet.journal.model.JournalContentSearch[] findByG_P_L_PrevAndNext(
        long contentSearchId, long groupId, boolean privateLayout,
        long layoutId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchContentSearchException;

    public java.util.List<com.nss.portlet.journal.model.JournalContentSearch> findByG_P_A(
        long groupId, boolean privateLayout, java.lang.String articleId)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.journal.model.JournalContentSearch> findByG_P_A(
        long groupId, boolean privateLayout, java.lang.String articleId,
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.journal.model.JournalContentSearch> findByG_P_A(
        long groupId, boolean privateLayout, java.lang.String articleId,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.journal.model.JournalContentSearch findByG_P_A_First(
        long groupId, boolean privateLayout, java.lang.String articleId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchContentSearchException;

    public com.nss.portlet.journal.model.JournalContentSearch findByG_P_A_Last(
        long groupId, boolean privateLayout, java.lang.String articleId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchContentSearchException;

    public com.nss.portlet.journal.model.JournalContentSearch[] findByG_P_A_PrevAndNext(
        long contentSearchId, long groupId, boolean privateLayout,
        java.lang.String articleId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchContentSearchException;

    public java.util.List<com.nss.portlet.journal.model.JournalContentSearch> findByG_P_L_P(
        long groupId, boolean privateLayout, long layoutId,
        java.lang.String portletId) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.journal.model.JournalContentSearch> findByG_P_L_P(
        long groupId, boolean privateLayout, long layoutId,
        java.lang.String portletId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.journal.model.JournalContentSearch> findByG_P_L_P(
        long groupId, boolean privateLayout, long layoutId,
        java.lang.String portletId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.journal.model.JournalContentSearch findByG_P_L_P_First(
        long groupId, boolean privateLayout, long layoutId,
        java.lang.String portletId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchContentSearchException;

    public com.nss.portlet.journal.model.JournalContentSearch findByG_P_L_P_Last(
        long groupId, boolean privateLayout, long layoutId,
        java.lang.String portletId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchContentSearchException;

    public com.nss.portlet.journal.model.JournalContentSearch[] findByG_P_L_P_PrevAndNext(
        long contentSearchId, long groupId, boolean privateLayout,
        long layoutId, java.lang.String portletId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchContentSearchException;

    public com.nss.portlet.journal.model.JournalContentSearch findByG_P_L_P_A(
        long groupId, boolean privateLayout, long layoutId,
        java.lang.String portletId, java.lang.String articleId)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchContentSearchException;

    public com.nss.portlet.journal.model.JournalContentSearch fetchByG_P_L_P_A(
        long groupId, boolean privateLayout, long layoutId,
        java.lang.String portletId, java.lang.String articleId)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.journal.model.JournalContentSearch fetchByG_P_L_P_A(
        long groupId, boolean privateLayout, long layoutId,
        java.lang.String portletId, java.lang.String articleId,
        boolean retrieveFromCache) throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.journal.model.JournalContentSearch> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.journal.model.JournalContentSearch> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.journal.model.JournalContentSearch> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeByG_P(long groupId, boolean privateLayout)
        throws com.liferay.portal.SystemException;

    public void removeByG_A(long groupId, java.lang.String articleId)
        throws com.liferay.portal.SystemException;

    public void removeByG_P_L(long groupId, boolean privateLayout, long layoutId)
        throws com.liferay.portal.SystemException;

    public void removeByG_P_A(long groupId, boolean privateLayout,
        java.lang.String articleId) throws com.liferay.portal.SystemException;

    public void removeByG_P_L_P(long groupId, boolean privateLayout,
        long layoutId, java.lang.String portletId)
        throws com.liferay.portal.SystemException;

    public void removeByG_P_L_P_A(long groupId, boolean privateLayout,
        long layoutId, java.lang.String portletId, java.lang.String articleId)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchContentSearchException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countByG_P(long groupId, boolean privateLayout)
        throws com.liferay.portal.SystemException;

    public int countByG_A(long groupId, java.lang.String articleId)
        throws com.liferay.portal.SystemException;

    public int countByG_P_L(long groupId, boolean privateLayout, long layoutId)
        throws com.liferay.portal.SystemException;

    public int countByG_P_A(long groupId, boolean privateLayout,
        java.lang.String articleId) throws com.liferay.portal.SystemException;

    public int countByG_P_L_P(long groupId, boolean privateLayout,
        long layoutId, java.lang.String portletId)
        throws com.liferay.portal.SystemException;

    public int countByG_P_L_P_A(long groupId, boolean privateLayout,
        long layoutId, java.lang.String portletId, java.lang.String articleId)
        throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;
}
