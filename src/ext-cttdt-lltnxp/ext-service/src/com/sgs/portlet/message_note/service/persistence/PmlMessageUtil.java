package com.sgs.portlet.message_note.service.persistence;

public class PmlMessageUtil {
    private static PmlMessagePersistence _persistence;

    public static com.sgs.portlet.message_note.model.PmlMessage create(
        long messageId) {
        return getPersistence().create(messageId);
    }

    public static com.sgs.portlet.message_note.model.PmlMessage remove(
        long messageId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.message_note.NoSuchPmlMessageException {
        return getPersistence().remove(messageId);
    }

    public static com.sgs.portlet.message_note.model.PmlMessage remove(
        com.sgs.portlet.message_note.model.PmlMessage pmlMessage)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(pmlMessage);
    }

    /**
     * @deprecated Use <code>update(PmlMessage pmlMessage, boolean merge)</code>.
     */
    public static com.sgs.portlet.message_note.model.PmlMessage update(
        com.sgs.portlet.message_note.model.PmlMessage pmlMessage)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(pmlMessage);
    }

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
    public static com.sgs.portlet.message_note.model.PmlMessage update(
        com.sgs.portlet.message_note.model.PmlMessage pmlMessage, boolean merge)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(pmlMessage, merge);
    }

    public static com.sgs.portlet.message_note.model.PmlMessage updateImpl(
        com.sgs.portlet.message_note.model.PmlMessage pmlMessage, boolean merge)
        throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(pmlMessage, merge);
    }

    public static com.sgs.portlet.message_note.model.PmlMessage findByPrimaryKey(
        long messageId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.message_note.NoSuchPmlMessageException {
        return getPersistence().findByPrimaryKey(messageId);
    }

    public static com.sgs.portlet.message_note.model.PmlMessage fetchByPrimaryKey(
        long messageId) throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(messageId);
    }

    public static java.util.List<com.sgs.portlet.message_note.model.PmlMessage> findByDocumentId(
        long documentId) throws com.liferay.portal.SystemException {
        return getPersistence().findByDocumentId(documentId);
    }

    public static java.util.List<com.sgs.portlet.message_note.model.PmlMessage> findByDocumentId(
        long documentId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByDocumentId(documentId, start, end);
    }

    public static java.util.List<com.sgs.portlet.message_note.model.PmlMessage> findByDocumentId(
        long documentId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByDocumentId(documentId, start, end, obc);
    }

    public static com.sgs.portlet.message_note.model.PmlMessage findByDocumentId_First(
        long documentId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.message_note.NoSuchPmlMessageException {
        return getPersistence().findByDocumentId_First(documentId, obc);
    }

    public static com.sgs.portlet.message_note.model.PmlMessage findByDocumentId_Last(
        long documentId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.message_note.NoSuchPmlMessageException {
        return getPersistence().findByDocumentId_Last(documentId, obc);
    }

    public static com.sgs.portlet.message_note.model.PmlMessage[] findByDocumentId_PrevAndNext(
        long messageId, long documentId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.message_note.NoSuchPmlMessageException {
        return getPersistence()
                   .findByDocumentId_PrevAndNext(messageId, documentId, obc);
    }

    public static java.util.List<com.sgs.portlet.message_note.model.PmlMessage> findByCreateDate(
        java.util.Date createDate) throws com.liferay.portal.SystemException {
        return getPersistence().findByCreateDate(createDate);
    }

    public static java.util.List<com.sgs.portlet.message_note.model.PmlMessage> findByCreateDate(
        java.util.Date createDate, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByCreateDate(createDate, start, end);
    }

    public static java.util.List<com.sgs.portlet.message_note.model.PmlMessage> findByCreateDate(
        java.util.Date createDate, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByCreateDate(createDate, start, end, obc);
    }

    public static com.sgs.portlet.message_note.model.PmlMessage findByCreateDate_First(
        java.util.Date createDate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.message_note.NoSuchPmlMessageException {
        return getPersistence().findByCreateDate_First(createDate, obc);
    }

    public static com.sgs.portlet.message_note.model.PmlMessage findByCreateDate_Last(
        java.util.Date createDate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.message_note.NoSuchPmlMessageException {
        return getPersistence().findByCreateDate_Last(createDate, obc);
    }

    public static com.sgs.portlet.message_note.model.PmlMessage[] findByCreateDate_PrevAndNext(
        long messageId, java.util.Date createDate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.message_note.NoSuchPmlMessageException {
        return getPersistence()
                   .findByCreateDate_PrevAndNext(messageId, createDate, obc);
    }

    public static java.util.List<com.sgs.portlet.message_note.model.PmlMessage> findByFromUserId(
        long fromUserId) throws com.liferay.portal.SystemException {
        return getPersistence().findByFromUserId(fromUserId);
    }

    public static java.util.List<com.sgs.portlet.message_note.model.PmlMessage> findByFromUserId(
        long fromUserId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByFromUserId(fromUserId, start, end);
    }

    public static java.util.List<com.sgs.portlet.message_note.model.PmlMessage> findByFromUserId(
        long fromUserId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByFromUserId(fromUserId, start, end, obc);
    }

    public static com.sgs.portlet.message_note.model.PmlMessage findByFromUserId_First(
        long fromUserId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.message_note.NoSuchPmlMessageException {
        return getPersistence().findByFromUserId_First(fromUserId, obc);
    }

    public static com.sgs.portlet.message_note.model.PmlMessage findByFromUserId_Last(
        long fromUserId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.message_note.NoSuchPmlMessageException {
        return getPersistence().findByFromUserId_Last(fromUserId, obc);
    }

    public static com.sgs.portlet.message_note.model.PmlMessage[] findByFromUserId_PrevAndNext(
        long messageId, long fromUserId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.message_note.NoSuchPmlMessageException {
        return getPersistence()
                   .findByFromUserId_PrevAndNext(messageId, fromUserId, obc);
    }

    public static java.util.List<com.sgs.portlet.message_note.model.PmlMessage> findByToUserId(
        long toUserId) throws com.liferay.portal.SystemException {
        return getPersistence().findByToUserId(toUserId);
    }

    public static java.util.List<com.sgs.portlet.message_note.model.PmlMessage> findByToUserId(
        long toUserId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByToUserId(toUserId, start, end);
    }

    public static java.util.List<com.sgs.portlet.message_note.model.PmlMessage> findByToUserId(
        long toUserId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByToUserId(toUserId, start, end, obc);
    }

    public static com.sgs.portlet.message_note.model.PmlMessage findByToUserId_First(
        long toUserId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.message_note.NoSuchPmlMessageException {
        return getPersistence().findByToUserId_First(toUserId, obc);
    }

    public static com.sgs.portlet.message_note.model.PmlMessage findByToUserId_Last(
        long toUserId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.message_note.NoSuchPmlMessageException {
        return getPersistence().findByToUserId_Last(toUserId, obc);
    }

    public static com.sgs.portlet.message_note.model.PmlMessage[] findByToUserId_PrevAndNext(
        long messageId, long toUserId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.message_note.NoSuchPmlMessageException {
        return getPersistence()
                   .findByToUserId_PrevAndNext(messageId, toUserId, obc);
    }

    public static java.util.List<com.sgs.portlet.message_note.model.PmlMessage> findByDocumentId_FromUserId_ObjectType(
        long documentId, long fromUserId, java.lang.String objectType)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDocumentId_FromUserId_ObjectType(documentId,
            fromUserId, objectType);
    }

    public static java.util.List<com.sgs.portlet.message_note.model.PmlMessage> findByDocumentId_FromUserId_ObjectType(
        long documentId, long fromUserId, java.lang.String objectType,
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDocumentId_FromUserId_ObjectType(documentId,
            fromUserId, objectType, start, end);
    }

    public static java.util.List<com.sgs.portlet.message_note.model.PmlMessage> findByDocumentId_FromUserId_ObjectType(
        long documentId, long fromUserId, java.lang.String objectType,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDocumentId_FromUserId_ObjectType(documentId,
            fromUserId, objectType, start, end, obc);
    }

    public static com.sgs.portlet.message_note.model.PmlMessage findByDocumentId_FromUserId_ObjectType_First(
        long documentId, long fromUserId, java.lang.String objectType,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.message_note.NoSuchPmlMessageException {
        return getPersistence()
                   .findByDocumentId_FromUserId_ObjectType_First(documentId,
            fromUserId, objectType, obc);
    }

    public static com.sgs.portlet.message_note.model.PmlMessage findByDocumentId_FromUserId_ObjectType_Last(
        long documentId, long fromUserId, java.lang.String objectType,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.message_note.NoSuchPmlMessageException {
        return getPersistence()
                   .findByDocumentId_FromUserId_ObjectType_Last(documentId,
            fromUserId, objectType, obc);
    }

    public static com.sgs.portlet.message_note.model.PmlMessage[] findByDocumentId_FromUserId_ObjectType_PrevAndNext(
        long messageId, long documentId, long fromUserId,
        java.lang.String objectType,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.message_note.NoSuchPmlMessageException {
        return getPersistence()
                   .findByDocumentId_FromUserId_ObjectType_PrevAndNext(messageId,
            documentId, fromUserId, objectType, obc);
    }

    public static java.util.List<com.sgs.portlet.message_note.model.PmlMessage> findByFromUserId_DocumentId(
        long fromUserId, long documentId)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByFromUserId_DocumentId(fromUserId, documentId);
    }

    public static java.util.List<com.sgs.portlet.message_note.model.PmlMessage> findByFromUserId_DocumentId(
        long fromUserId, long documentId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByFromUserId_DocumentId(fromUserId, documentId, start,
            end);
    }

    public static java.util.List<com.sgs.portlet.message_note.model.PmlMessage> findByFromUserId_DocumentId(
        long fromUserId, long documentId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByFromUserId_DocumentId(fromUserId, documentId, start,
            end, obc);
    }

    public static com.sgs.portlet.message_note.model.PmlMessage findByFromUserId_DocumentId_First(
        long fromUserId, long documentId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.message_note.NoSuchPmlMessageException {
        return getPersistence()
                   .findByFromUserId_DocumentId_First(fromUserId, documentId,
            obc);
    }

    public static com.sgs.portlet.message_note.model.PmlMessage findByFromUserId_DocumentId_Last(
        long fromUserId, long documentId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.message_note.NoSuchPmlMessageException {
        return getPersistence()
                   .findByFromUserId_DocumentId_Last(fromUserId, documentId, obc);
    }

    public static com.sgs.portlet.message_note.model.PmlMessage[] findByFromUserId_DocumentId_PrevAndNext(
        long messageId, long fromUserId, long documentId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.message_note.NoSuchPmlMessageException {
        return getPersistence()
                   .findByFromUserId_DocumentId_PrevAndNext(messageId,
            fromUserId, documentId, obc);
    }

    public static java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    public static java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    public static java.util.List<com.sgs.portlet.message_note.model.PmlMessage> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.sgs.portlet.message_note.model.PmlMessage> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.sgs.portlet.message_note.model.PmlMessage> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end, obc);
    }

    public static void removeByDocumentId(long documentId)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByDocumentId(documentId);
    }

    public static void removeByCreateDate(java.util.Date createDate)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByCreateDate(createDate);
    }

    public static void removeByFromUserId(long fromUserId)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByFromUserId(fromUserId);
    }

    public static void removeByToUserId(long toUserId)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByToUserId(toUserId);
    }

    public static void removeByDocumentId_FromUserId_ObjectType(
        long documentId, long fromUserId, java.lang.String objectType)
        throws com.liferay.portal.SystemException {
        getPersistence()
            .removeByDocumentId_FromUserId_ObjectType(documentId, fromUserId,
            objectType);
    }

    public static void removeByFromUserId_DocumentId(long fromUserId,
        long documentId) throws com.liferay.portal.SystemException {
        getPersistence().removeByFromUserId_DocumentId(fromUserId, documentId);
    }

    public static void removeAll() throws com.liferay.portal.SystemException {
        getPersistence().removeAll();
    }

    public static int countByDocumentId(long documentId)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByDocumentId(documentId);
    }

    public static int countByCreateDate(java.util.Date createDate)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByCreateDate(createDate);
    }

    public static int countByFromUserId(long fromUserId)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByFromUserId(fromUserId);
    }

    public static int countByToUserId(long toUserId)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByToUserId(toUserId);
    }

    public static int countByDocumentId_FromUserId_ObjectType(long documentId,
        long fromUserId, java.lang.String objectType)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .countByDocumentId_FromUserId_ObjectType(documentId,
            fromUserId, objectType);
    }

    public static int countByFromUserId_DocumentId(long fromUserId,
        long documentId) throws com.liferay.portal.SystemException {
        return getPersistence()
                   .countByFromUserId_DocumentId(fromUserId, documentId);
    }

    public static int countAll() throws com.liferay.portal.SystemException {
        return getPersistence().countAll();
    }

    public static void registerListener(
        com.liferay.portal.model.ModelListener listener) {
        getPersistence().registerListener(listener);
    }

    public static void unregisterListener(
        com.liferay.portal.model.ModelListener listener) {
        getPersistence().unregisterListener(listener);
    }

    public static PmlMessagePersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(PmlMessagePersistence persistence) {
        _persistence = persistence;
    }
}
