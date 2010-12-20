package com.liferay.portlet.messageboards.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;


public interface MBBanPersistence extends BasePersistence {
    public void cacheResult(com.liferay.portlet.messageboards.model.MBBan mbBan);

    public void cacheResult(
        java.util.List<com.liferay.portlet.messageboards.model.MBBan> mbBans);

    public void clearCache();

    public com.liferay.portlet.messageboards.model.MBBan create(long banId);

    public com.liferay.portlet.messageboards.model.MBBan remove(long banId)
        throws com.liferay.portal.SystemException,
            com.liferay.portlet.messageboards.NoSuchBanException;

    public com.liferay.portlet.messageboards.model.MBBan remove(
        com.liferay.portlet.messageboards.model.MBBan mbBan)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(MBBan mbBan, boolean merge)</code>.
     */
    public com.liferay.portlet.messageboards.model.MBBan update(
        com.liferay.portlet.messageboards.model.MBBan mbBan)
        throws com.liferay.portal.SystemException;

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                mbBan the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when mbBan is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public com.liferay.portlet.messageboards.model.MBBan update(
        com.liferay.portlet.messageboards.model.MBBan mbBan, boolean merge)
        throws com.liferay.portal.SystemException;

    public com.liferay.portlet.messageboards.model.MBBan updateImpl(
        com.liferay.portlet.messageboards.model.MBBan mbBan, boolean merge)
        throws com.liferay.portal.SystemException;

    public com.liferay.portlet.messageboards.model.MBBan findByPrimaryKey(
        long banId)
        throws com.liferay.portal.SystemException,
            com.liferay.portlet.messageboards.NoSuchBanException;

    public com.liferay.portlet.messageboards.model.MBBan fetchByPrimaryKey(
        long banId) throws com.liferay.portal.SystemException;

    public java.util.List<com.liferay.portlet.messageboards.model.MBBan> findByGroupId(
        long groupId) throws com.liferay.portal.SystemException;

    public java.util.List<com.liferay.portlet.messageboards.model.MBBan> findByGroupId(
        long groupId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.liferay.portlet.messageboards.model.MBBan> findByGroupId(
        long groupId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.liferay.portlet.messageboards.model.MBBan findByGroupId_First(
        long groupId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.liferay.portlet.messageboards.NoSuchBanException;

    public com.liferay.portlet.messageboards.model.MBBan findByGroupId_Last(
        long groupId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.liferay.portlet.messageboards.NoSuchBanException;

    public com.liferay.portlet.messageboards.model.MBBan[] findByGroupId_PrevAndNext(
        long banId, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.liferay.portlet.messageboards.NoSuchBanException;

    public java.util.List<com.liferay.portlet.messageboards.model.MBBan> findByUserId(
        long userId) throws com.liferay.portal.SystemException;

    public java.util.List<com.liferay.portlet.messageboards.model.MBBan> findByUserId(
        long userId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.liferay.portlet.messageboards.model.MBBan> findByUserId(
        long userId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.liferay.portlet.messageboards.model.MBBan findByUserId_First(
        long userId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.liferay.portlet.messageboards.NoSuchBanException;

    public com.liferay.portlet.messageboards.model.MBBan findByUserId_Last(
        long userId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.liferay.portlet.messageboards.NoSuchBanException;

    public com.liferay.portlet.messageboards.model.MBBan[] findByUserId_PrevAndNext(
        long banId, long userId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.liferay.portlet.messageboards.NoSuchBanException;

    public java.util.List<com.liferay.portlet.messageboards.model.MBBan> findByBanUserId(
        long banUserId) throws com.liferay.portal.SystemException;

    public java.util.List<com.liferay.portlet.messageboards.model.MBBan> findByBanUserId(
        long banUserId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.liferay.portlet.messageboards.model.MBBan> findByBanUserId(
        long banUserId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.liferay.portlet.messageboards.model.MBBan findByBanUserId_First(
        long banUserId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.liferay.portlet.messageboards.NoSuchBanException;

    public com.liferay.portlet.messageboards.model.MBBan findByBanUserId_Last(
        long banUserId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.liferay.portlet.messageboards.NoSuchBanException;

    public com.liferay.portlet.messageboards.model.MBBan[] findByBanUserId_PrevAndNext(
        long banId, long banUserId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.liferay.portlet.messageboards.NoSuchBanException;

    public com.liferay.portlet.messageboards.model.MBBan findByG_B(
        long groupId, long banUserId)
        throws com.liferay.portal.SystemException,
            com.liferay.portlet.messageboards.NoSuchBanException;

    public com.liferay.portlet.messageboards.model.MBBan fetchByG_B(
        long groupId, long banUserId) throws com.liferay.portal.SystemException;

    public com.liferay.portlet.messageboards.model.MBBan fetchByG_B(
        long groupId, long banUserId, boolean retrieveFromCache)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.liferay.portlet.messageboards.model.MBBan> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.liferay.portlet.messageboards.model.MBBan> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.liferay.portlet.messageboards.model.MBBan> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeByGroupId(long groupId)
        throws com.liferay.portal.SystemException;

    public void removeByUserId(long userId)
        throws com.liferay.portal.SystemException;

    public void removeByBanUserId(long banUserId)
        throws com.liferay.portal.SystemException;

    public void removeByG_B(long groupId, long banUserId)
        throws com.liferay.portal.SystemException,
            com.liferay.portlet.messageboards.NoSuchBanException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countByGroupId(long groupId)
        throws com.liferay.portal.SystemException;

    public int countByUserId(long userId)
        throws com.liferay.portal.SystemException;

    public int countByBanUserId(long banUserId)
        throws com.liferay.portal.SystemException;

    public int countByG_B(long groupId, long banUserId)
        throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;
}
