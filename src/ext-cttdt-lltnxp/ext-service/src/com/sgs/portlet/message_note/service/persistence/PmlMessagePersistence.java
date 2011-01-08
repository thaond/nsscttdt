package com.sgs.portlet.message_note.service.persistence;

public interface PmlMessagePersistence {
    public com.sgs.portlet.message_note.model.PmlMessage create(long messageId);

    public com.sgs.portlet.message_note.model.PmlMessage remove(long messageId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.message_note.NoSuchPmlMessageException;

    public com.sgs.portlet.message_note.model.PmlMessage remove(
        com.sgs.portlet.message_note.model.PmlMessage pmlMessage)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(PmlMessage pmlMessage, boolean merge)</code>.
     */
    public com.sgs.portlet.message_note.model.PmlMessage update(
        com.sgs.portlet.message_note.model.PmlMessage pmlMessage)
        throws com.liferay.portal.SystemException;

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlMessage the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlMessage is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public com.sgs.portlet.message_note.model.PmlMessage update(
        com.sgs.portlet.message_note.model.PmlMessage pmlMessage, boolean merge)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.message_note.model.PmlMessage updateImpl(
        com.sgs.portlet.message_note.model.PmlMessage pmlMessage, boolean merge)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.message_note.model.PmlMessage findByPrimaryKey(
        long messageId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.message_note.NoSuchPmlMessageException;

    public com.sgs.portlet.message_note.model.PmlMessage fetchByPrimaryKey(
        long messageId) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.message_note.model.PmlMessage> findByDocumentId(
        long documentId) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.message_note.model.PmlMessage> findByDocumentId(
        long documentId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.message_note.model.PmlMessage> findByDocumentId(
        long documentId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.message_note.model.PmlMessage findByDocumentId_First(
        long documentId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.message_note.NoSuchPmlMessageException;

    public com.sgs.portlet.message_note.model.PmlMessage findByDocumentId_Last(
        long documentId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.message_note.NoSuchPmlMessageException;

    public com.sgs.portlet.message_note.model.PmlMessage[] findByDocumentId_PrevAndNext(
        long messageId, long documentId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.message_note.NoSuchPmlMessageException;

    public java.util.List<com.sgs.portlet.message_note.model.PmlMessage> findByCreateDate(
        java.util.Date createDate) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.message_note.model.PmlMessage> findByCreateDate(
        java.util.Date createDate, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.message_note.model.PmlMessage> findByCreateDate(
        java.util.Date createDate, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.message_note.model.PmlMessage findByCreateDate_First(
        java.util.Date createDate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.message_note.NoSuchPmlMessageException;

    public com.sgs.portlet.message_note.model.PmlMessage findByCreateDate_Last(
        java.util.Date createDate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.message_note.NoSuchPmlMessageException;

    public com.sgs.portlet.message_note.model.PmlMessage[] findByCreateDate_PrevAndNext(
        long messageId, java.util.Date createDate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.message_note.NoSuchPmlMessageException;

    public java.util.List<com.sgs.portlet.message_note.model.PmlMessage> findByFromUserId(
        long fromUserId) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.message_note.model.PmlMessage> findByFromUserId(
        long fromUserId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.message_note.model.PmlMessage> findByFromUserId(
        long fromUserId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.message_note.model.PmlMessage findByFromUserId_First(
        long fromUserId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.message_note.NoSuchPmlMessageException;

    public com.sgs.portlet.message_note.model.PmlMessage findByFromUserId_Last(
        long fromUserId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.message_note.NoSuchPmlMessageException;

    public com.sgs.portlet.message_note.model.PmlMessage[] findByFromUserId_PrevAndNext(
        long messageId, long fromUserId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.message_note.NoSuchPmlMessageException;

    public java.util.List<com.sgs.portlet.message_note.model.PmlMessage> findByToUserId(
        long toUserId) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.message_note.model.PmlMessage> findByToUserId(
        long toUserId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.message_note.model.PmlMessage> findByToUserId(
        long toUserId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.message_note.model.PmlMessage findByToUserId_First(
        long toUserId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.message_note.NoSuchPmlMessageException;

    public com.sgs.portlet.message_note.model.PmlMessage findByToUserId_Last(
        long toUserId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.message_note.NoSuchPmlMessageException;

    public com.sgs.portlet.message_note.model.PmlMessage[] findByToUserId_PrevAndNext(
        long messageId, long toUserId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.message_note.NoSuchPmlMessageException;

    public java.util.List<com.sgs.portlet.message_note.model.PmlMessage> findByDocumentId_FromUserId_ObjectType(
        long documentId, long fromUserId, java.lang.String objectType)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.message_note.model.PmlMessage> findByDocumentId_FromUserId_ObjectType(
        long documentId, long fromUserId, java.lang.String objectType,
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.message_note.model.PmlMessage> findByDocumentId_FromUserId_ObjectType(
        long documentId, long fromUserId, java.lang.String objectType,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.message_note.model.PmlMessage findByDocumentId_FromUserId_ObjectType_First(
        long documentId, long fromUserId, java.lang.String objectType,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.message_note.NoSuchPmlMessageException;

    public com.sgs.portlet.message_note.model.PmlMessage findByDocumentId_FromUserId_ObjectType_Last(
        long documentId, long fromUserId, java.lang.String objectType,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.message_note.NoSuchPmlMessageException;

    public com.sgs.portlet.message_note.model.PmlMessage[] findByDocumentId_FromUserId_ObjectType_PrevAndNext(
        long messageId, long documentId, long fromUserId,
        java.lang.String objectType,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.message_note.NoSuchPmlMessageException;

    public java.util.List<com.sgs.portlet.message_note.model.PmlMessage> findByFromUserId_DocumentId(
        long fromUserId, long documentId)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.message_note.model.PmlMessage> findByFromUserId_DocumentId(
        long fromUserId, long documentId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.message_note.model.PmlMessage> findByFromUserId_DocumentId(
        long fromUserId, long documentId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.message_note.model.PmlMessage findByFromUserId_DocumentId_First(
        long fromUserId, long documentId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.message_note.NoSuchPmlMessageException;

    public com.sgs.portlet.message_note.model.PmlMessage findByFromUserId_DocumentId_Last(
        long fromUserId, long documentId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.message_note.NoSuchPmlMessageException;

    public com.sgs.portlet.message_note.model.PmlMessage[] findByFromUserId_DocumentId_PrevAndNext(
        long messageId, long fromUserId, long documentId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.message_note.NoSuchPmlMessageException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.message_note.model.PmlMessage> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.message_note.model.PmlMessage> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.message_note.model.PmlMessage> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeByDocumentId(long documentId)
        throws com.liferay.portal.SystemException;

    public void removeByCreateDate(java.util.Date createDate)
        throws com.liferay.portal.SystemException;

    public void removeByFromUserId(long fromUserId)
        throws com.liferay.portal.SystemException;

    public void removeByToUserId(long toUserId)
        throws com.liferay.portal.SystemException;

    public void removeByDocumentId_FromUserId_ObjectType(long documentId,
        long fromUserId, java.lang.String objectType)
        throws com.liferay.portal.SystemException;

    public void removeByFromUserId_DocumentId(long fromUserId, long documentId)
        throws com.liferay.portal.SystemException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countByDocumentId(long documentId)
        throws com.liferay.portal.SystemException;

    public int countByCreateDate(java.util.Date createDate)
        throws com.liferay.portal.SystemException;

    public int countByFromUserId(long fromUserId)
        throws com.liferay.portal.SystemException;

    public int countByToUserId(long toUserId)
        throws com.liferay.portal.SystemException;

    public int countByDocumentId_FromUserId_ObjectType(long documentId,
        long fromUserId, java.lang.String objectType)
        throws com.liferay.portal.SystemException;

    public int countByFromUserId_DocumentId(long fromUserId, long documentId)
        throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;

    public void registerListener(
        com.liferay.portal.model.ModelListener listener);

    public void unregisterListener(
        com.liferay.portal.model.ModelListener listener);
}
