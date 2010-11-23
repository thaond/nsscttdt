package com.liferay.portlet.messageboards.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;


public interface MBDiscussionPersistence extends BasePersistence {
    public void cacheResult(
        com.liferay.portlet.messageboards.model.MBDiscussion mbDiscussion);

    public void cacheResult(
        java.util.List<com.liferay.portlet.messageboards.model.MBDiscussion> mbDiscussions);

    public void clearCache();

    public com.liferay.portlet.messageboards.model.MBDiscussion create(
        long discussionId);

    public com.liferay.portlet.messageboards.model.MBDiscussion remove(
        long discussionId)
        throws com.liferay.portal.SystemException,
            com.liferay.portlet.messageboards.NoSuchDiscussionException;

    public com.liferay.portlet.messageboards.model.MBDiscussion remove(
        com.liferay.portlet.messageboards.model.MBDiscussion mbDiscussion)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(MBDiscussion mbDiscussion, boolean merge)</code>.
     */
    public com.liferay.portlet.messageboards.model.MBDiscussion update(
        com.liferay.portlet.messageboards.model.MBDiscussion mbDiscussion)
        throws com.liferay.portal.SystemException;

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                mbDiscussion the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when mbDiscussion is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public com.liferay.portlet.messageboards.model.MBDiscussion update(
        com.liferay.portlet.messageboards.model.MBDiscussion mbDiscussion,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.liferay.portlet.messageboards.model.MBDiscussion updateImpl(
        com.liferay.portlet.messageboards.model.MBDiscussion mbDiscussion,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.liferay.portlet.messageboards.model.MBDiscussion findByPrimaryKey(
        long discussionId)
        throws com.liferay.portal.SystemException,
            com.liferay.portlet.messageboards.NoSuchDiscussionException;

    public com.liferay.portlet.messageboards.model.MBDiscussion fetchByPrimaryKey(
        long discussionId) throws com.liferay.portal.SystemException;

    public java.util.List<com.liferay.portlet.messageboards.model.MBDiscussion> findByClassNameId(
        long classNameId) throws com.liferay.portal.SystemException;

    public java.util.List<com.liferay.portlet.messageboards.model.MBDiscussion> findByClassNameId(
        long classNameId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.liferay.portlet.messageboards.model.MBDiscussion> findByClassNameId(
        long classNameId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.liferay.portlet.messageboards.model.MBDiscussion findByClassNameId_First(
        long classNameId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.liferay.portlet.messageboards.NoSuchDiscussionException;

    public com.liferay.portlet.messageboards.model.MBDiscussion findByClassNameId_Last(
        long classNameId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.liferay.portlet.messageboards.NoSuchDiscussionException;

    public com.liferay.portlet.messageboards.model.MBDiscussion[] findByClassNameId_PrevAndNext(
        long discussionId, long classNameId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.liferay.portlet.messageboards.NoSuchDiscussionException;

    public com.liferay.portlet.messageboards.model.MBDiscussion findByThreadId(
        long threadId)
        throws com.liferay.portal.SystemException,
            com.liferay.portlet.messageboards.NoSuchDiscussionException;

    public com.liferay.portlet.messageboards.model.MBDiscussion fetchByThreadId(
        long threadId) throws com.liferay.portal.SystemException;

    public com.liferay.portlet.messageboards.model.MBDiscussion fetchByThreadId(
        long threadId, boolean retrieveFromCache)
        throws com.liferay.portal.SystemException;

    public com.liferay.portlet.messageboards.model.MBDiscussion findByC_C(
        long classNameId, long classPK)
        throws com.liferay.portal.SystemException,
            com.liferay.portlet.messageboards.NoSuchDiscussionException;

    public com.liferay.portlet.messageboards.model.MBDiscussion fetchByC_C(
        long classNameId, long classPK)
        throws com.liferay.portal.SystemException;

    public com.liferay.portlet.messageboards.model.MBDiscussion fetchByC_C(
        long classNameId, long classPK, boolean retrieveFromCache)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.liferay.portlet.messageboards.model.MBDiscussion> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.liferay.portlet.messageboards.model.MBDiscussion> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.liferay.portlet.messageboards.model.MBDiscussion> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeByClassNameId(long classNameId)
        throws com.liferay.portal.SystemException;

    public void removeByThreadId(long threadId)
        throws com.liferay.portal.SystemException,
            com.liferay.portlet.messageboards.NoSuchDiscussionException;

    public void removeByC_C(long classNameId, long classPK)
        throws com.liferay.portal.SystemException,
            com.liferay.portlet.messageboards.NoSuchDiscussionException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countByClassNameId(long classNameId)
        throws com.liferay.portal.SystemException;

    public int countByThreadId(long threadId)
        throws com.liferay.portal.SystemException;

    public int countByC_C(long classNameId, long classPK)
        throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;
}
