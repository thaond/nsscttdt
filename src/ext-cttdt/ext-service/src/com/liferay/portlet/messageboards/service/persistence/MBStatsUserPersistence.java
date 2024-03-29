package com.liferay.portlet.messageboards.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;


public interface MBStatsUserPersistence extends BasePersistence {
    public void cacheResult(
        com.liferay.portlet.messageboards.model.MBStatsUser mbStatsUser);

    public void cacheResult(
        java.util.List<com.liferay.portlet.messageboards.model.MBStatsUser> mbStatsUsers);

    public void clearCache();

    public com.liferay.portlet.messageboards.model.MBStatsUser create(
        long statsUserId);

    public com.liferay.portlet.messageboards.model.MBStatsUser remove(
        long statsUserId)
        throws com.liferay.portal.SystemException,
            com.liferay.portlet.messageboards.NoSuchStatsUserException;

    public com.liferay.portlet.messageboards.model.MBStatsUser remove(
        com.liferay.portlet.messageboards.model.MBStatsUser mbStatsUser)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(MBStatsUser mbStatsUser, boolean merge)</code>.
     */
    public com.liferay.portlet.messageboards.model.MBStatsUser update(
        com.liferay.portlet.messageboards.model.MBStatsUser mbStatsUser)
        throws com.liferay.portal.SystemException;

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                mbStatsUser the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when mbStatsUser is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public com.liferay.portlet.messageboards.model.MBStatsUser update(
        com.liferay.portlet.messageboards.model.MBStatsUser mbStatsUser,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.liferay.portlet.messageboards.model.MBStatsUser updateImpl(
        com.liferay.portlet.messageboards.model.MBStatsUser mbStatsUser,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.liferay.portlet.messageboards.model.MBStatsUser findByPrimaryKey(
        long statsUserId)
        throws com.liferay.portal.SystemException,
            com.liferay.portlet.messageboards.NoSuchStatsUserException;

    public com.liferay.portlet.messageboards.model.MBStatsUser fetchByPrimaryKey(
        long statsUserId) throws com.liferay.portal.SystemException;

    public java.util.List<com.liferay.portlet.messageboards.model.MBStatsUser> findByGroupId(
        long groupId) throws com.liferay.portal.SystemException;

    public java.util.List<com.liferay.portlet.messageboards.model.MBStatsUser> findByGroupId(
        long groupId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.liferay.portlet.messageboards.model.MBStatsUser> findByGroupId(
        long groupId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.liferay.portlet.messageboards.model.MBStatsUser findByGroupId_First(
        long groupId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.liferay.portlet.messageboards.NoSuchStatsUserException;

    public com.liferay.portlet.messageboards.model.MBStatsUser findByGroupId_Last(
        long groupId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.liferay.portlet.messageboards.NoSuchStatsUserException;

    public com.liferay.portlet.messageboards.model.MBStatsUser[] findByGroupId_PrevAndNext(
        long statsUserId, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.liferay.portlet.messageboards.NoSuchStatsUserException;

    public java.util.List<com.liferay.portlet.messageboards.model.MBStatsUser> findByUserId(
        long userId) throws com.liferay.portal.SystemException;

    public java.util.List<com.liferay.portlet.messageboards.model.MBStatsUser> findByUserId(
        long userId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.liferay.portlet.messageboards.model.MBStatsUser> findByUserId(
        long userId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.liferay.portlet.messageboards.model.MBStatsUser findByUserId_First(
        long userId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.liferay.portlet.messageboards.NoSuchStatsUserException;

    public com.liferay.portlet.messageboards.model.MBStatsUser findByUserId_Last(
        long userId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.liferay.portlet.messageboards.NoSuchStatsUserException;

    public com.liferay.portlet.messageboards.model.MBStatsUser[] findByUserId_PrevAndNext(
        long statsUserId, long userId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.liferay.portlet.messageboards.NoSuchStatsUserException;

    public com.liferay.portlet.messageboards.model.MBStatsUser findByG_U(
        long groupId, long userId)
        throws com.liferay.portal.SystemException,
            com.liferay.portlet.messageboards.NoSuchStatsUserException;

    public com.liferay.portlet.messageboards.model.MBStatsUser fetchByG_U(
        long groupId, long userId) throws com.liferay.portal.SystemException;

    public com.liferay.portlet.messageboards.model.MBStatsUser fetchByG_U(
        long groupId, long userId, boolean retrieveFromCache)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.liferay.portlet.messageboards.model.MBStatsUser> findByG_M(
        long groupId, int messageCount)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.liferay.portlet.messageboards.model.MBStatsUser> findByG_M(
        long groupId, int messageCount, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.liferay.portlet.messageboards.model.MBStatsUser> findByG_M(
        long groupId, int messageCount, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.liferay.portlet.messageboards.model.MBStatsUser findByG_M_First(
        long groupId, int messageCount,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.liferay.portlet.messageboards.NoSuchStatsUserException;

    public com.liferay.portlet.messageboards.model.MBStatsUser findByG_M_Last(
        long groupId, int messageCount,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.liferay.portlet.messageboards.NoSuchStatsUserException;

    public com.liferay.portlet.messageboards.model.MBStatsUser[] findByG_M_PrevAndNext(
        long statsUserId, long groupId, int messageCount,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.liferay.portlet.messageboards.NoSuchStatsUserException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.liferay.portlet.messageboards.model.MBStatsUser> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.liferay.portlet.messageboards.model.MBStatsUser> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.liferay.portlet.messageboards.model.MBStatsUser> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeByGroupId(long groupId)
        throws com.liferay.portal.SystemException;

    public void removeByUserId(long userId)
        throws com.liferay.portal.SystemException;

    public void removeByG_U(long groupId, long userId)
        throws com.liferay.portal.SystemException,
            com.liferay.portlet.messageboards.NoSuchStatsUserException;

    public void removeByG_M(long groupId, int messageCount)
        throws com.liferay.portal.SystemException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countByGroupId(long groupId)
        throws com.liferay.portal.SystemException;

    public int countByUserId(long userId)
        throws com.liferay.portal.SystemException;

    public int countByG_U(long groupId, long userId)
        throws com.liferay.portal.SystemException;

    public int countByG_M(long groupId, int messageCount)
        throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;
}
