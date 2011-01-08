package com.liferay.portlet.messageboards.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;


public interface MBMessageFlagPersistence extends BasePersistence {
    public void cacheResult(
        com.liferay.portlet.messageboards.model.MBMessageFlag mbMessageFlag);

    public void cacheResult(
        java.util.List<com.liferay.portlet.messageboards.model.MBMessageFlag> mbMessageFlags);

    public void clearCache();

    public com.liferay.portlet.messageboards.model.MBMessageFlag create(
        long messageFlagId);

    public com.liferay.portlet.messageboards.model.MBMessageFlag remove(
        long messageFlagId)
        throws com.liferay.portal.SystemException,
            com.liferay.portlet.messageboards.NoSuchMessageFlagException;

    public com.liferay.portlet.messageboards.model.MBMessageFlag remove(
        com.liferay.portlet.messageboards.model.MBMessageFlag mbMessageFlag)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(MBMessageFlag mbMessageFlag, boolean merge)</code>.
     */
    public com.liferay.portlet.messageboards.model.MBMessageFlag update(
        com.liferay.portlet.messageboards.model.MBMessageFlag mbMessageFlag)
        throws com.liferay.portal.SystemException;

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                mbMessageFlag the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when mbMessageFlag is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public com.liferay.portlet.messageboards.model.MBMessageFlag update(
        com.liferay.portlet.messageboards.model.MBMessageFlag mbMessageFlag,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.liferay.portlet.messageboards.model.MBMessageFlag updateImpl(
        com.liferay.portlet.messageboards.model.MBMessageFlag mbMessageFlag,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.liferay.portlet.messageboards.model.MBMessageFlag findByPrimaryKey(
        long messageFlagId)
        throws com.liferay.portal.SystemException,
            com.liferay.portlet.messageboards.NoSuchMessageFlagException;

    public com.liferay.portlet.messageboards.model.MBMessageFlag fetchByPrimaryKey(
        long messageFlagId) throws com.liferay.portal.SystemException;

    public java.util.List<com.liferay.portlet.messageboards.model.MBMessageFlag> findByUserId(
        long userId) throws com.liferay.portal.SystemException;

    public java.util.List<com.liferay.portlet.messageboards.model.MBMessageFlag> findByUserId(
        long userId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.liferay.portlet.messageboards.model.MBMessageFlag> findByUserId(
        long userId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.liferay.portlet.messageboards.model.MBMessageFlag findByUserId_First(
        long userId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.liferay.portlet.messageboards.NoSuchMessageFlagException;

    public com.liferay.portlet.messageboards.model.MBMessageFlag findByUserId_Last(
        long userId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.liferay.portlet.messageboards.NoSuchMessageFlagException;

    public com.liferay.portlet.messageboards.model.MBMessageFlag[] findByUserId_PrevAndNext(
        long messageFlagId, long userId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.liferay.portlet.messageboards.NoSuchMessageFlagException;

    public java.util.List<com.liferay.portlet.messageboards.model.MBMessageFlag> findByThreadId(
        long threadId) throws com.liferay.portal.SystemException;

    public java.util.List<com.liferay.portlet.messageboards.model.MBMessageFlag> findByThreadId(
        long threadId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.liferay.portlet.messageboards.model.MBMessageFlag> findByThreadId(
        long threadId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.liferay.portlet.messageboards.model.MBMessageFlag findByThreadId_First(
        long threadId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.liferay.portlet.messageboards.NoSuchMessageFlagException;

    public com.liferay.portlet.messageboards.model.MBMessageFlag findByThreadId_Last(
        long threadId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.liferay.portlet.messageboards.NoSuchMessageFlagException;

    public com.liferay.portlet.messageboards.model.MBMessageFlag[] findByThreadId_PrevAndNext(
        long messageFlagId, long threadId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.liferay.portlet.messageboards.NoSuchMessageFlagException;

    public java.util.List<com.liferay.portlet.messageboards.model.MBMessageFlag> findByMessageId(
        long messageId) throws com.liferay.portal.SystemException;

    public java.util.List<com.liferay.portlet.messageboards.model.MBMessageFlag> findByMessageId(
        long messageId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.liferay.portlet.messageboards.model.MBMessageFlag> findByMessageId(
        long messageId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.liferay.portlet.messageboards.model.MBMessageFlag findByMessageId_First(
        long messageId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.liferay.portlet.messageboards.NoSuchMessageFlagException;

    public com.liferay.portlet.messageboards.model.MBMessageFlag findByMessageId_Last(
        long messageId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.liferay.portlet.messageboards.NoSuchMessageFlagException;

    public com.liferay.portlet.messageboards.model.MBMessageFlag[] findByMessageId_PrevAndNext(
        long messageFlagId, long messageId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.liferay.portlet.messageboards.NoSuchMessageFlagException;

    public java.util.List<com.liferay.portlet.messageboards.model.MBMessageFlag> findByT_F(
        long threadId, int flag) throws com.liferay.portal.SystemException;

    public java.util.List<com.liferay.portlet.messageboards.model.MBMessageFlag> findByT_F(
        long threadId, int flag, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.liferay.portlet.messageboards.model.MBMessageFlag> findByT_F(
        long threadId, int flag, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.liferay.portlet.messageboards.model.MBMessageFlag findByT_F_First(
        long threadId, int flag,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.liferay.portlet.messageboards.NoSuchMessageFlagException;

    public com.liferay.portlet.messageboards.model.MBMessageFlag findByT_F_Last(
        long threadId, int flag,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.liferay.portlet.messageboards.NoSuchMessageFlagException;

    public com.liferay.portlet.messageboards.model.MBMessageFlag[] findByT_F_PrevAndNext(
        long messageFlagId, long threadId, int flag,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.liferay.portlet.messageboards.NoSuchMessageFlagException;

    public java.util.List<com.liferay.portlet.messageboards.model.MBMessageFlag> findByM_F(
        long messageId, int flag) throws com.liferay.portal.SystemException;

    public java.util.List<com.liferay.portlet.messageboards.model.MBMessageFlag> findByM_F(
        long messageId, int flag, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.liferay.portlet.messageboards.model.MBMessageFlag> findByM_F(
        long messageId, int flag, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.liferay.portlet.messageboards.model.MBMessageFlag findByM_F_First(
        long messageId, int flag,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.liferay.portlet.messageboards.NoSuchMessageFlagException;

    public com.liferay.portlet.messageboards.model.MBMessageFlag findByM_F_Last(
        long messageId, int flag,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.liferay.portlet.messageboards.NoSuchMessageFlagException;

    public com.liferay.portlet.messageboards.model.MBMessageFlag[] findByM_F_PrevAndNext(
        long messageFlagId, long messageId, int flag,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.liferay.portlet.messageboards.NoSuchMessageFlagException;

    public java.util.List<com.liferay.portlet.messageboards.model.MBMessageFlag> findByU_T_F(
        long userId, long threadId, int flag)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.liferay.portlet.messageboards.model.MBMessageFlag> findByU_T_F(
        long userId, long threadId, int flag, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.liferay.portlet.messageboards.model.MBMessageFlag> findByU_T_F(
        long userId, long threadId, int flag, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.liferay.portlet.messageboards.model.MBMessageFlag findByU_T_F_First(
        long userId, long threadId, int flag,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.liferay.portlet.messageboards.NoSuchMessageFlagException;

    public com.liferay.portlet.messageboards.model.MBMessageFlag findByU_T_F_Last(
        long userId, long threadId, int flag,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.liferay.portlet.messageboards.NoSuchMessageFlagException;

    public com.liferay.portlet.messageboards.model.MBMessageFlag[] findByU_T_F_PrevAndNext(
        long messageFlagId, long userId, long threadId, int flag,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.liferay.portlet.messageboards.NoSuchMessageFlagException;

    public com.liferay.portlet.messageboards.model.MBMessageFlag findByU_M_F(
        long userId, long messageId, int flag)
        throws com.liferay.portal.SystemException,
            com.liferay.portlet.messageboards.NoSuchMessageFlagException;

    public com.liferay.portlet.messageboards.model.MBMessageFlag fetchByU_M_F(
        long userId, long messageId, int flag)
        throws com.liferay.portal.SystemException;

    public com.liferay.portlet.messageboards.model.MBMessageFlag fetchByU_M_F(
        long userId, long messageId, int flag, boolean retrieveFromCache)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.liferay.portlet.messageboards.model.MBMessageFlag> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.liferay.portlet.messageboards.model.MBMessageFlag> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.liferay.portlet.messageboards.model.MBMessageFlag> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeByUserId(long userId)
        throws com.liferay.portal.SystemException;

    public void removeByThreadId(long threadId)
        throws com.liferay.portal.SystemException;

    public void removeByMessageId(long messageId)
        throws com.liferay.portal.SystemException;

    public void removeByT_F(long threadId, int flag)
        throws com.liferay.portal.SystemException;

    public void removeByM_F(long messageId, int flag)
        throws com.liferay.portal.SystemException;

    public void removeByU_T_F(long userId, long threadId, int flag)
        throws com.liferay.portal.SystemException;

    public void removeByU_M_F(long userId, long messageId, int flag)
        throws com.liferay.portal.SystemException,
            com.liferay.portlet.messageboards.NoSuchMessageFlagException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countByUserId(long userId)
        throws com.liferay.portal.SystemException;

    public int countByThreadId(long threadId)
        throws com.liferay.portal.SystemException;

    public int countByMessageId(long messageId)
        throws com.liferay.portal.SystemException;

    public int countByT_F(long threadId, int flag)
        throws com.liferay.portal.SystemException;

    public int countByM_F(long messageId, int flag)
        throws com.liferay.portal.SystemException;

    public int countByU_T_F(long userId, long threadId, int flag)
        throws com.liferay.portal.SystemException;

    public int countByU_M_F(long userId, long messageId, int flag)
        throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;
}