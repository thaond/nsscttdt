package com.nss.portlet.chat.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;


public interface EntryPersistence extends BasePersistence {
    public void cacheResult(com.nss.portlet.chat.model.Entry entry);

    public void cacheResult(
        java.util.List<com.nss.portlet.chat.model.Entry> entries);

    public void clearCache();

    public com.nss.portlet.chat.model.Entry create(long entryId);

    public com.nss.portlet.chat.model.Entry remove(long entryId)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.chat.NoSuchEntryException;

    public com.nss.portlet.chat.model.Entry remove(
        com.nss.portlet.chat.model.Entry entry)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(Entry entry, boolean merge)</code>.
     */
    public com.nss.portlet.chat.model.Entry update(
        com.nss.portlet.chat.model.Entry entry)
        throws com.liferay.portal.SystemException;

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                entry the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when entry is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public com.nss.portlet.chat.model.Entry update(
        com.nss.portlet.chat.model.Entry entry, boolean merge)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.chat.model.Entry updateImpl(
        com.nss.portlet.chat.model.Entry entry, boolean merge)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.chat.model.Entry findByPrimaryKey(long entryId)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.chat.NoSuchEntryException;

    public com.nss.portlet.chat.model.Entry fetchByPrimaryKey(long entryId)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.chat.model.Entry> findByCreateDate(
        long createDate) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.chat.model.Entry> findByCreateDate(
        long createDate, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.chat.model.Entry> findByCreateDate(
        long createDate, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.chat.model.Entry findByCreateDate_First(
        long createDate, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.chat.NoSuchEntryException;

    public com.nss.portlet.chat.model.Entry findByCreateDate_Last(
        long createDate, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.chat.NoSuchEntryException;

    public com.nss.portlet.chat.model.Entry[] findByCreateDate_PrevAndNext(
        long entryId, long createDate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.chat.NoSuchEntryException;

    public java.util.List<com.nss.portlet.chat.model.Entry> findByFromUserId(
        long fromUserId) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.chat.model.Entry> findByFromUserId(
        long fromUserId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.chat.model.Entry> findByFromUserId(
        long fromUserId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.chat.model.Entry findByFromUserId_First(
        long fromUserId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.chat.NoSuchEntryException;

    public com.nss.portlet.chat.model.Entry findByFromUserId_Last(
        long fromUserId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.chat.NoSuchEntryException;

    public com.nss.portlet.chat.model.Entry[] findByFromUserId_PrevAndNext(
        long entryId, long fromUserId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.chat.NoSuchEntryException;

    public java.util.List<com.nss.portlet.chat.model.Entry> findByToUserId(
        long toUserId) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.chat.model.Entry> findByToUserId(
        long toUserId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.chat.model.Entry> findByToUserId(
        long toUserId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.chat.model.Entry findByToUserId_First(
        long toUserId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.chat.NoSuchEntryException;

    public com.nss.portlet.chat.model.Entry findByToUserId_Last(long toUserId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.chat.NoSuchEntryException;

    public com.nss.portlet.chat.model.Entry[] findByToUserId_PrevAndNext(
        long entryId, long toUserId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.chat.NoSuchEntryException;

    public java.util.List<com.nss.portlet.chat.model.Entry> findByC_F(
        long createDate, long fromUserId)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.chat.model.Entry> findByC_F(
        long createDate, long fromUserId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.chat.model.Entry> findByC_F(
        long createDate, long fromUserId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.chat.model.Entry findByC_F_First(long createDate,
        long fromUserId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.chat.NoSuchEntryException;

    public com.nss.portlet.chat.model.Entry findByC_F_Last(long createDate,
        long fromUserId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.chat.NoSuchEntryException;

    public com.nss.portlet.chat.model.Entry[] findByC_F_PrevAndNext(
        long entryId, long createDate, long fromUserId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.chat.NoSuchEntryException;

    public java.util.List<com.nss.portlet.chat.model.Entry> findByC_T(
        long createDate, long toUserId)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.chat.model.Entry> findByC_T(
        long createDate, long toUserId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.chat.model.Entry> findByC_T(
        long createDate, long toUserId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.chat.model.Entry findByC_T_First(long createDate,
        long toUserId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.chat.NoSuchEntryException;

    public com.nss.portlet.chat.model.Entry findByC_T_Last(long createDate,
        long toUserId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.chat.NoSuchEntryException;

    public com.nss.portlet.chat.model.Entry[] findByC_T_PrevAndNext(
        long entryId, long createDate, long toUserId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.chat.NoSuchEntryException;

    public java.util.List<com.nss.portlet.chat.model.Entry> findByC_F_T(
        long createDate, long fromUserId, long toUserId)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.chat.model.Entry> findByC_F_T(
        long createDate, long fromUserId, long toUserId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.chat.model.Entry> findByC_F_T(
        long createDate, long fromUserId, long toUserId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.chat.model.Entry findByC_F_T_First(long createDate,
        long fromUserId, long toUserId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.chat.NoSuchEntryException;

    public com.nss.portlet.chat.model.Entry findByC_F_T_Last(long createDate,
        long fromUserId, long toUserId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.chat.NoSuchEntryException;

    public com.nss.portlet.chat.model.Entry[] findByC_F_T_PrevAndNext(
        long entryId, long createDate, long fromUserId, long toUserId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.chat.NoSuchEntryException;

    public java.util.List<com.nss.portlet.chat.model.Entry> findByF_T_C(
        long fromUserId, long toUserId, java.lang.String content)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.chat.model.Entry> findByF_T_C(
        long fromUserId, long toUserId, java.lang.String content, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.chat.model.Entry> findByF_T_C(
        long fromUserId, long toUserId, java.lang.String content, int start,
        int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.chat.model.Entry findByF_T_C_First(long fromUserId,
        long toUserId, java.lang.String content,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.chat.NoSuchEntryException;

    public com.nss.portlet.chat.model.Entry findByF_T_C_Last(long fromUserId,
        long toUserId, java.lang.String content,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.chat.NoSuchEntryException;

    public com.nss.portlet.chat.model.Entry[] findByF_T_C_PrevAndNext(
        long entryId, long fromUserId, long toUserId, java.lang.String content,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.chat.NoSuchEntryException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.chat.model.Entry> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.chat.model.Entry> findAll(int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.chat.model.Entry> findAll(int start,
        int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeByCreateDate(long createDate)
        throws com.liferay.portal.SystemException;

    public void removeByFromUserId(long fromUserId)
        throws com.liferay.portal.SystemException;

    public void removeByToUserId(long toUserId)
        throws com.liferay.portal.SystemException;

    public void removeByC_F(long createDate, long fromUserId)
        throws com.liferay.portal.SystemException;

    public void removeByC_T(long createDate, long toUserId)
        throws com.liferay.portal.SystemException;

    public void removeByC_F_T(long createDate, long fromUserId, long toUserId)
        throws com.liferay.portal.SystemException;

    public void removeByF_T_C(long fromUserId, long toUserId,
        java.lang.String content) throws com.liferay.portal.SystemException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countByCreateDate(long createDate)
        throws com.liferay.portal.SystemException;

    public int countByFromUserId(long fromUserId)
        throws com.liferay.portal.SystemException;

    public int countByToUserId(long toUserId)
        throws com.liferay.portal.SystemException;

    public int countByC_F(long createDate, long fromUserId)
        throws com.liferay.portal.SystemException;

    public int countByC_T(long createDate, long toUserId)
        throws com.liferay.portal.SystemException;

    public int countByC_F_T(long createDate, long fromUserId, long toUserId)
        throws com.liferay.portal.SystemException;

    public int countByF_T_C(long fromUserId, long toUserId,
        java.lang.String content) throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;
}
