package com.sgs.portlet.document.send.service.persistence;

public class PmlEdmDocumentSendUtil {
    private static PmlEdmDocumentSendPersistence _persistence;

    public static com.sgs.portlet.document.send.model.PmlEdmDocumentSend create(
        long documentSendId) {
        return getPersistence().create(documentSendId);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmDocumentSend remove(
        long documentSendId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmDocumentSendException {
        return getPersistence().remove(documentSendId);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmDocumentSend remove(
        com.sgs.portlet.document.send.model.PmlEdmDocumentSend pmlEdmDocumentSend)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(pmlEdmDocumentSend);
    }

    /**
     * @deprecated Use <code>update(PmlEdmDocumentSend pmlEdmDocumentSend, boolean merge)</code>.
     */
    public static com.sgs.portlet.document.send.model.PmlEdmDocumentSend update(
        com.sgs.portlet.document.send.model.PmlEdmDocumentSend pmlEdmDocumentSend)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(pmlEdmDocumentSend);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlEdmDocumentSend the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlEdmDocumentSend is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public static com.sgs.portlet.document.send.model.PmlEdmDocumentSend update(
        com.sgs.portlet.document.send.model.PmlEdmDocumentSend pmlEdmDocumentSend,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().update(pmlEdmDocumentSend, merge);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmDocumentSend updateImpl(
        com.sgs.portlet.document.send.model.PmlEdmDocumentSend pmlEdmDocumentSend,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(pmlEdmDocumentSend, merge);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmDocumentSend findByPrimaryKey(
        long documentSendId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmDocumentSendException {
        return getPersistence().findByPrimaryKey(documentSendId);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmDocumentSend fetchByPrimaryKey(
        long documentSendId) throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(documentSendId);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> findByDocumentSendCode(
        java.lang.String documentSendCode)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByDocumentSendCode(documentSendCode);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> findByDocumentSendCode(
        java.lang.String documentSendCode, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDocumentSendCode(documentSendCode, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> findByDocumentSendCode(
        java.lang.String documentSendCode, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDocumentSendCode(documentSendCode, start, end, obc);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmDocumentSend findByDocumentSendCode_First(
        java.lang.String documentSendCode,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmDocumentSendException {
        return getPersistence()
                   .findByDocumentSendCode_First(documentSendCode, obc);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmDocumentSend findByDocumentSendCode_Last(
        java.lang.String documentSendCode,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmDocumentSendException {
        return getPersistence()
                   .findByDocumentSendCode_Last(documentSendCode, obc);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmDocumentSend[] findByDocumentSendCode_PrevAndNext(
        long documentSendId, java.lang.String documentSendCode,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmDocumentSendException {
        return getPersistence()
                   .findByDocumentSendCode_PrevAndNext(documentSendId,
            documentSendCode, obc);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> findByNumberPublish(
        java.lang.String numberPublish)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByNumberPublish(numberPublish);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> findByNumberPublish(
        java.lang.String numberPublish, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByNumberPublish(numberPublish, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> findByNumberPublish(
        java.lang.String numberPublish, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByNumberPublish(numberPublish, start, end, obc);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmDocumentSend findByNumberPublish_First(
        java.lang.String numberPublish,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmDocumentSendException {
        return getPersistence().findByNumberPublish_First(numberPublish, obc);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmDocumentSend findByNumberPublish_Last(
        java.lang.String numberPublish,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmDocumentSendException {
        return getPersistence().findByNumberPublish_Last(numberPublish, obc);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmDocumentSend[] findByNumberPublish_PrevAndNext(
        long documentSendId, java.lang.String numberPublish,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmDocumentSendException {
        return getPersistence()
                   .findByNumberPublish_PrevAndNext(documentSendId,
            numberPublish, obc);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> findByNumberPage(
        java.lang.String numberPage) throws com.liferay.portal.SystemException {
        return getPersistence().findByNumberPage(numberPage);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> findByNumberPage(
        java.lang.String numberPage, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByNumberPage(numberPage, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> findByNumberPage(
        java.lang.String numberPage, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByNumberPage(numberPage, start, end, obc);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmDocumentSend findByNumberPage_First(
        java.lang.String numberPage,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmDocumentSendException {
        return getPersistence().findByNumberPage_First(numberPage, obc);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmDocumentSend findByNumberPage_Last(
        java.lang.String numberPage,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmDocumentSendException {
        return getPersistence().findByNumberPage_Last(numberPage, obc);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmDocumentSend[] findByNumberPage_PrevAndNext(
        long documentSendId, java.lang.String numberPage,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmDocumentSendException {
        return getPersistence()
                   .findByNumberPage_PrevAndNext(documentSendId, numberPage, obc);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> findByPosition(
        java.lang.String position) throws com.liferay.portal.SystemException {
        return getPersistence().findByPosition(position);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> findByPosition(
        java.lang.String position, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByPosition(position, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> findByPosition(
        java.lang.String position, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByPosition(position, start, end, obc);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmDocumentSend findByPosition_First(
        java.lang.String position,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmDocumentSendException {
        return getPersistence().findByPosition_First(position, obc);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmDocumentSend findByPosition_Last(
        java.lang.String position,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmDocumentSendException {
        return getPersistence().findByPosition_Last(position, obc);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmDocumentSend[] findByPosition_PrevAndNext(
        long documentSendId, java.lang.String position,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmDocumentSendException {
        return getPersistence()
                   .findByPosition_PrevAndNext(documentSendId, position, obc);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> findBySignerName(
        java.lang.String signerName) throws com.liferay.portal.SystemException {
        return getPersistence().findBySignerName(signerName);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> findBySignerName(
        java.lang.String signerName, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findBySignerName(signerName, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> findBySignerName(
        java.lang.String signerName, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findBySignerName(signerName, start, end, obc);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmDocumentSend findBySignerName_First(
        java.lang.String signerName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmDocumentSendException {
        return getPersistence().findBySignerName_First(signerName, obc);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmDocumentSend findBySignerName_Last(
        java.lang.String signerName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmDocumentSendException {
        return getPersistence().findBySignerName_Last(signerName, obc);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmDocumentSend[] findBySignerName_PrevAndNext(
        long documentSendId, java.lang.String signerName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmDocumentSendException {
        return getPersistence()
                   .findBySignerName_PrevAndNext(documentSendId, signerName, obc);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> findBySendDate(
        java.util.Date sendDate) throws com.liferay.portal.SystemException {
        return getPersistence().findBySendDate(sendDate);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> findBySendDate(
        java.util.Date sendDate, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findBySendDate(sendDate, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> findBySendDate(
        java.util.Date sendDate, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findBySendDate(sendDate, start, end, obc);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmDocumentSend findBySendDate_First(
        java.util.Date sendDate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmDocumentSendException {
        return getPersistence().findBySendDate_First(sendDate, obc);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmDocumentSend findBySendDate_Last(
        java.util.Date sendDate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmDocumentSendException {
        return getPersistence().findBySendDate_Last(sendDate, obc);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmDocumentSend[] findBySendDate_PrevAndNext(
        long documentSendId, java.util.Date sendDate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmDocumentSendException {
        return getPersistence()
                   .findBySendDate_PrevAndNext(documentSendId, sendDate, obc);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> findByDocumentReference(
        java.lang.String documentReference)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByDocumentReference(documentReference);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> findByDocumentReference(
        java.lang.String documentReference, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDocumentReference(documentReference, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> findByDocumentReference(
        java.lang.String documentReference, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDocumentReference(documentReference, start, end, obc);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmDocumentSend findByDocumentReference_First(
        java.lang.String documentReference,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmDocumentSendException {
        return getPersistence()
                   .findByDocumentReference_First(documentReference, obc);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmDocumentSend findByDocumentReference_Last(
        java.lang.String documentReference,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmDocumentSendException {
        return getPersistence()
                   .findByDocumentReference_Last(documentReference, obc);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmDocumentSend[] findByDocumentReference_PrevAndNext(
        long documentSendId, java.lang.String documentReference,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmDocumentSendException {
        return getPersistence()
                   .findByDocumentReference_PrevAndNext(documentSendId,
            documentReference, obc);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> findByEditorId(
        long editorId) throws com.liferay.portal.SystemException {
        return getPersistence().findByEditorId(editorId);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> findByEditorId(
        long editorId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByEditorId(editorId, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> findByEditorId(
        long editorId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByEditorId(editorId, start, end, obc);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmDocumentSend findByEditorId_First(
        long editorId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmDocumentSendException {
        return getPersistence().findByEditorId_First(editorId, obc);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmDocumentSend findByEditorId_Last(
        long editorId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmDocumentSendException {
        return getPersistence().findByEditorId_Last(editorId, obc);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmDocumentSend[] findByEditorId_PrevAndNext(
        long documentSendId, long editorId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmDocumentSendException {
        return getPersistence()
                   .findByEditorId_PrevAndNext(documentSendId, editorId, obc);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> findBySignerId(
        long signerId) throws com.liferay.portal.SystemException {
        return getPersistence().findBySignerId(signerId);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> findBySignerId(
        long signerId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findBySignerId(signerId, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> findBySignerId(
        long signerId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findBySignerId(signerId, start, end, obc);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmDocumentSend findBySignerId_First(
        long signerId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmDocumentSendException {
        return getPersistence().findBySignerId_First(signerId, obc);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmDocumentSend findBySignerId_Last(
        long signerId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmDocumentSendException {
        return getPersistence().findBySignerId_Last(signerId, obc);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmDocumentSend[] findBySignerId_PrevAndNext(
        long documentSendId, long signerId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmDocumentSendException {
        return getPersistence()
                   .findBySignerId_PrevAndNext(documentSendId, signerId, obc);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> findByDocumentTypeId(
        long documentTypeId) throws com.liferay.portal.SystemException {
        return getPersistence().findByDocumentTypeId(documentTypeId);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> findByDocumentTypeId(
        long documentTypeId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByDocumentTypeId(documentTypeId, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> findByDocumentTypeId(
        long documentTypeId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDocumentTypeId(documentTypeId, start, end, obc);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmDocumentSend findByDocumentTypeId_First(
        long documentTypeId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmDocumentSendException {
        return getPersistence().findByDocumentTypeId_First(documentTypeId, obc);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmDocumentSend findByDocumentTypeId_Last(
        long documentTypeId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmDocumentSendException {
        return getPersistence().findByDocumentTypeId_Last(documentTypeId, obc);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmDocumentSend[] findByDocumentTypeId_PrevAndNext(
        long documentSendId, long documentTypeId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmDocumentSendException {
        return getPersistence()
                   .findByDocumentTypeId_PrevAndNext(documentSendId,
            documentTypeId, obc);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> findByPrivilegeLevelId(
        java.lang.String privilegeLevelId)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByPrivilegeLevelId(privilegeLevelId);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> findByPrivilegeLevelId(
        java.lang.String privilegeLevelId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByPrivilegeLevelId(privilegeLevelId, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> findByPrivilegeLevelId(
        java.lang.String privilegeLevelId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByPrivilegeLevelId(privilegeLevelId, start, end, obc);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmDocumentSend findByPrivilegeLevelId_First(
        java.lang.String privilegeLevelId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmDocumentSendException {
        return getPersistence()
                   .findByPrivilegeLevelId_First(privilegeLevelId, obc);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmDocumentSend findByPrivilegeLevelId_Last(
        java.lang.String privilegeLevelId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmDocumentSendException {
        return getPersistence()
                   .findByPrivilegeLevelId_Last(privilegeLevelId, obc);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmDocumentSend[] findByPrivilegeLevelId_PrevAndNext(
        long documentSendId, java.lang.String privilegeLevelId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmDocumentSendException {
        return getPersistence()
                   .findByPrivilegeLevelId_PrevAndNext(documentSendId,
            privilegeLevelId, obc);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> findByConfidentialLevelId(
        java.lang.String confidentialLevelId)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByConfidentialLevelId(confidentialLevelId);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> findByConfidentialLevelId(
        java.lang.String confidentialLevelId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByConfidentialLevelId(confidentialLevelId, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> findByConfidentialLevelId(
        java.lang.String confidentialLevelId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByConfidentialLevelId(confidentialLevelId, start, end,
            obc);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmDocumentSend findByConfidentialLevelId_First(
        java.lang.String confidentialLevelId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmDocumentSendException {
        return getPersistence()
                   .findByConfidentialLevelId_First(confidentialLevelId, obc);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmDocumentSend findByConfidentialLevelId_Last(
        java.lang.String confidentialLevelId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmDocumentSendException {
        return getPersistence()
                   .findByConfidentialLevelId_Last(confidentialLevelId, obc);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmDocumentSend[] findByConfidentialLevelId_PrevAndNext(
        long documentSendId, java.lang.String confidentialLevelId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmDocumentSendException {
        return getPersistence()
                   .findByConfidentialLevelId_PrevAndNext(documentSendId,
            confidentialLevelId, obc);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> findByIssuingDate(
        java.util.Date issuingDate) throws com.liferay.portal.SystemException {
        return getPersistence().findByIssuingDate(issuingDate);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> findByIssuingDate(
        java.util.Date issuingDate, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByIssuingDate(issuingDate, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> findByIssuingDate(
        java.util.Date issuingDate, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByIssuingDate(issuingDate, start, end, obc);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmDocumentSend findByIssuingDate_First(
        java.util.Date issuingDate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmDocumentSendException {
        return getPersistence().findByIssuingDate_First(issuingDate, obc);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmDocumentSend findByIssuingDate_Last(
        java.util.Date issuingDate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmDocumentSendException {
        return getPersistence().findByIssuingDate_Last(issuingDate, obc);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmDocumentSend[] findByIssuingDate_PrevAndNext(
        long documentSendId, java.util.Date issuingDate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmDocumentSendException {
        return getPersistence()
                   .findByIssuingDate_PrevAndNext(documentSendId, issuingDate,
            obc);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> findByStatusId(
        long statusId) throws com.liferay.portal.SystemException {
        return getPersistence().findByStatusId(statusId);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> findByStatusId(
        long statusId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByStatusId(statusId, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> findByStatusId(
        long statusId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByStatusId(statusId, start, end, obc);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmDocumentSend findByStatusId_First(
        long statusId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmDocumentSendException {
        return getPersistence().findByStatusId_First(statusId, obc);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmDocumentSend findByStatusId_Last(
        long statusId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmDocumentSendException {
        return getPersistence().findByStatusId_Last(statusId, obc);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmDocumentSend[] findByStatusId_PrevAndNext(
        long documentSendId, long statusId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmDocumentSendException {
        return getPersistence()
                   .findByStatusId_PrevAndNext(documentSendId, statusId, obc);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> findByIsCongVanPhucDap(
        boolean iscongvanphucdap) throws com.liferay.portal.SystemException {
        return getPersistence().findByIsCongVanPhucDap(iscongvanphucdap);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> findByIsCongVanPhucDap(
        boolean iscongvanphucdap, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByIsCongVanPhucDap(iscongvanphucdap, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> findByIsCongVanPhucDap(
        boolean iscongvanphucdap, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByIsCongVanPhucDap(iscongvanphucdap, start, end, obc);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmDocumentSend findByIsCongVanPhucDap_First(
        boolean iscongvanphucdap,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmDocumentSendException {
        return getPersistence()
                   .findByIsCongVanPhucDap_First(iscongvanphucdap, obc);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmDocumentSend findByIsCongVanPhucDap_Last(
        boolean iscongvanphucdap,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmDocumentSendException {
        return getPersistence()
                   .findByIsCongVanPhucDap_Last(iscongvanphucdap, obc);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmDocumentSend[] findByIsCongVanPhucDap_PrevAndNext(
        long documentSendId, boolean iscongvanphucdap,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmDocumentSendException {
        return getPersistence()
                   .findByIsCongVanPhucDap_PrevAndNext(documentSendId,
            iscongvanphucdap, obc);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> findByOrgExternalId(
        long orgExternalId) throws com.liferay.portal.SystemException {
        return getPersistence().findByOrgExternalId(orgExternalId);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> findByOrgExternalId(
        long orgExternalId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByOrgExternalId(orgExternalId, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> findByOrgExternalId(
        long orgExternalId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByOrgExternalId(orgExternalId, start, end, obc);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmDocumentSend findByOrgExternalId_First(
        long orgExternalId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmDocumentSendException {
        return getPersistence().findByOrgExternalId_First(orgExternalId, obc);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmDocumentSend findByOrgExternalId_Last(
        long orgExternalId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmDocumentSendException {
        return getPersistence().findByOrgExternalId_Last(orgExternalId, obc);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmDocumentSend[] findByOrgExternalId_PrevAndNext(
        long documentSendId, long orgExternalId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmDocumentSendException {
        return getPersistence()
                   .findByOrgExternalId_PrevAndNext(documentSendId,
            orgExternalId, obc);
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

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end, obc);
    }

    public static void removeByDocumentSendCode(
        java.lang.String documentSendCode)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByDocumentSendCode(documentSendCode);
    }

    public static void removeByNumberPublish(java.lang.String numberPublish)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByNumberPublish(numberPublish);
    }

    public static void removeByNumberPage(java.lang.String numberPage)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByNumberPage(numberPage);
    }

    public static void removeByPosition(java.lang.String position)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByPosition(position);
    }

    public static void removeBySignerName(java.lang.String signerName)
        throws com.liferay.portal.SystemException {
        getPersistence().removeBySignerName(signerName);
    }

    public static void removeBySendDate(java.util.Date sendDate)
        throws com.liferay.portal.SystemException {
        getPersistence().removeBySendDate(sendDate);
    }

    public static void removeByDocumentReference(
        java.lang.String documentReference)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByDocumentReference(documentReference);
    }

    public static void removeByEditorId(long editorId)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByEditorId(editorId);
    }

    public static void removeBySignerId(long signerId)
        throws com.liferay.portal.SystemException {
        getPersistence().removeBySignerId(signerId);
    }

    public static void removeByDocumentTypeId(long documentTypeId)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByDocumentTypeId(documentTypeId);
    }

    public static void removeByPrivilegeLevelId(
        java.lang.String privilegeLevelId)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByPrivilegeLevelId(privilegeLevelId);
    }

    public static void removeByConfidentialLevelId(
        java.lang.String confidentialLevelId)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByConfidentialLevelId(confidentialLevelId);
    }

    public static void removeByIssuingDate(java.util.Date issuingDate)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByIssuingDate(issuingDate);
    }

    public static void removeByStatusId(long statusId)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByStatusId(statusId);
    }

    public static void removeByIsCongVanPhucDap(boolean iscongvanphucdap)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByIsCongVanPhucDap(iscongvanphucdap);
    }

    public static void removeByOrgExternalId(long orgExternalId)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByOrgExternalId(orgExternalId);
    }

    public static void removeAll() throws com.liferay.portal.SystemException {
        getPersistence().removeAll();
    }

    public static int countByDocumentSendCode(java.lang.String documentSendCode)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByDocumentSendCode(documentSendCode);
    }

    public static int countByNumberPublish(java.lang.String numberPublish)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByNumberPublish(numberPublish);
    }

    public static int countByNumberPage(java.lang.String numberPage)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByNumberPage(numberPage);
    }

    public static int countByPosition(java.lang.String position)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByPosition(position);
    }

    public static int countBySignerName(java.lang.String signerName)
        throws com.liferay.portal.SystemException {
        return getPersistence().countBySignerName(signerName);
    }

    public static int countBySendDate(java.util.Date sendDate)
        throws com.liferay.portal.SystemException {
        return getPersistence().countBySendDate(sendDate);
    }

    public static int countByDocumentReference(
        java.lang.String documentReference)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByDocumentReference(documentReference);
    }

    public static int countByEditorId(long editorId)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByEditorId(editorId);
    }

    public static int countBySignerId(long signerId)
        throws com.liferay.portal.SystemException {
        return getPersistence().countBySignerId(signerId);
    }

    public static int countByDocumentTypeId(long documentTypeId)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByDocumentTypeId(documentTypeId);
    }

    public static int countByPrivilegeLevelId(java.lang.String privilegeLevelId)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByPrivilegeLevelId(privilegeLevelId);
    }

    public static int countByConfidentialLevelId(
        java.lang.String confidentialLevelId)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByConfidentialLevelId(confidentialLevelId);
    }

    public static int countByIssuingDate(java.util.Date issuingDate)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByIssuingDate(issuingDate);
    }

    public static int countByStatusId(long statusId)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByStatusId(statusId);
    }

    public static int countByIsCongVanPhucDap(boolean iscongvanphucdap)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByIsCongVanPhucDap(iscongvanphucdap);
    }

    public static int countByOrgExternalId(long orgExternalId)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByOrgExternalId(orgExternalId);
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

    public static PmlEdmDocumentSendPersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(PmlEdmDocumentSendPersistence persistence) {
        _persistence = persistence;
    }
}
