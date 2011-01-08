package com.sgs.portlet.document.send.service.persistence;

public interface PmlEdmDocumentSendPersistence {
    public com.sgs.portlet.document.send.model.PmlEdmDocumentSend create(
        long documentSendId);

    public com.sgs.portlet.document.send.model.PmlEdmDocumentSend remove(
        long documentSendId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmDocumentSendException;

    public com.sgs.portlet.document.send.model.PmlEdmDocumentSend remove(
        com.sgs.portlet.document.send.model.PmlEdmDocumentSend pmlEdmDocumentSend)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(PmlEdmDocumentSend pmlEdmDocumentSend, boolean merge)</code>.
     */
    public com.sgs.portlet.document.send.model.PmlEdmDocumentSend update(
        com.sgs.portlet.document.send.model.PmlEdmDocumentSend pmlEdmDocumentSend)
        throws com.liferay.portal.SystemException;

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
    public com.sgs.portlet.document.send.model.PmlEdmDocumentSend update(
        com.sgs.portlet.document.send.model.PmlEdmDocumentSend pmlEdmDocumentSend,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.send.model.PmlEdmDocumentSend updateImpl(
        com.sgs.portlet.document.send.model.PmlEdmDocumentSend pmlEdmDocumentSend,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.send.model.PmlEdmDocumentSend findByPrimaryKey(
        long documentSendId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmDocumentSendException;

    public com.sgs.portlet.document.send.model.PmlEdmDocumentSend fetchByPrimaryKey(
        long documentSendId) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> findByDocumentSendCode(
        java.lang.String documentSendCode)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> findByDocumentSendCode(
        java.lang.String documentSendCode, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> findByDocumentSendCode(
        java.lang.String documentSendCode, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.send.model.PmlEdmDocumentSend findByDocumentSendCode_First(
        java.lang.String documentSendCode,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmDocumentSendException;

    public com.sgs.portlet.document.send.model.PmlEdmDocumentSend findByDocumentSendCode_Last(
        java.lang.String documentSendCode,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmDocumentSendException;

    public com.sgs.portlet.document.send.model.PmlEdmDocumentSend[] findByDocumentSendCode_PrevAndNext(
        long documentSendId, java.lang.String documentSendCode,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmDocumentSendException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> findByNumberPublish(
        java.lang.String numberPublish)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> findByNumberPublish(
        java.lang.String numberPublish, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> findByNumberPublish(
        java.lang.String numberPublish, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.send.model.PmlEdmDocumentSend findByNumberPublish_First(
        java.lang.String numberPublish,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmDocumentSendException;

    public com.sgs.portlet.document.send.model.PmlEdmDocumentSend findByNumberPublish_Last(
        java.lang.String numberPublish,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmDocumentSendException;

    public com.sgs.portlet.document.send.model.PmlEdmDocumentSend[] findByNumberPublish_PrevAndNext(
        long documentSendId, java.lang.String numberPublish,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmDocumentSendException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> findByNumberPage(
        java.lang.String numberPage) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> findByNumberPage(
        java.lang.String numberPage, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> findByNumberPage(
        java.lang.String numberPage, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.send.model.PmlEdmDocumentSend findByNumberPage_First(
        java.lang.String numberPage,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmDocumentSendException;

    public com.sgs.portlet.document.send.model.PmlEdmDocumentSend findByNumberPage_Last(
        java.lang.String numberPage,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmDocumentSendException;

    public com.sgs.portlet.document.send.model.PmlEdmDocumentSend[] findByNumberPage_PrevAndNext(
        long documentSendId, java.lang.String numberPage,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmDocumentSendException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> findByPosition(
        java.lang.String position) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> findByPosition(
        java.lang.String position, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> findByPosition(
        java.lang.String position, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.send.model.PmlEdmDocumentSend findByPosition_First(
        java.lang.String position,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmDocumentSendException;

    public com.sgs.portlet.document.send.model.PmlEdmDocumentSend findByPosition_Last(
        java.lang.String position,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmDocumentSendException;

    public com.sgs.portlet.document.send.model.PmlEdmDocumentSend[] findByPosition_PrevAndNext(
        long documentSendId, java.lang.String position,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmDocumentSendException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> findBySignerName(
        java.lang.String signerName) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> findBySignerName(
        java.lang.String signerName, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> findBySignerName(
        java.lang.String signerName, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.send.model.PmlEdmDocumentSend findBySignerName_First(
        java.lang.String signerName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmDocumentSendException;

    public com.sgs.portlet.document.send.model.PmlEdmDocumentSend findBySignerName_Last(
        java.lang.String signerName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmDocumentSendException;

    public com.sgs.portlet.document.send.model.PmlEdmDocumentSend[] findBySignerName_PrevAndNext(
        long documentSendId, java.lang.String signerName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmDocumentSendException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> findBySendDate(
        java.util.Date sendDate) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> findBySendDate(
        java.util.Date sendDate, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> findBySendDate(
        java.util.Date sendDate, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.send.model.PmlEdmDocumentSend findBySendDate_First(
        java.util.Date sendDate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmDocumentSendException;

    public com.sgs.portlet.document.send.model.PmlEdmDocumentSend findBySendDate_Last(
        java.util.Date sendDate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmDocumentSendException;

    public com.sgs.portlet.document.send.model.PmlEdmDocumentSend[] findBySendDate_PrevAndNext(
        long documentSendId, java.util.Date sendDate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmDocumentSendException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> findByDocumentReference(
        java.lang.String documentReference)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> findByDocumentReference(
        java.lang.String documentReference, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> findByDocumentReference(
        java.lang.String documentReference, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.send.model.PmlEdmDocumentSend findByDocumentReference_First(
        java.lang.String documentReference,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmDocumentSendException;

    public com.sgs.portlet.document.send.model.PmlEdmDocumentSend findByDocumentReference_Last(
        java.lang.String documentReference,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmDocumentSendException;

    public com.sgs.portlet.document.send.model.PmlEdmDocumentSend[] findByDocumentReference_PrevAndNext(
        long documentSendId, java.lang.String documentReference,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmDocumentSendException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> findByEditorId(
        long editorId) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> findByEditorId(
        long editorId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> findByEditorId(
        long editorId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.send.model.PmlEdmDocumentSend findByEditorId_First(
        long editorId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmDocumentSendException;

    public com.sgs.portlet.document.send.model.PmlEdmDocumentSend findByEditorId_Last(
        long editorId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmDocumentSendException;

    public com.sgs.portlet.document.send.model.PmlEdmDocumentSend[] findByEditorId_PrevAndNext(
        long documentSendId, long editorId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmDocumentSendException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> findBySignerId(
        long signerId) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> findBySignerId(
        long signerId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> findBySignerId(
        long signerId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.send.model.PmlEdmDocumentSend findBySignerId_First(
        long signerId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmDocumentSendException;

    public com.sgs.portlet.document.send.model.PmlEdmDocumentSend findBySignerId_Last(
        long signerId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmDocumentSendException;

    public com.sgs.portlet.document.send.model.PmlEdmDocumentSend[] findBySignerId_PrevAndNext(
        long documentSendId, long signerId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmDocumentSendException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> findByDocumentTypeId(
        long documentTypeId) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> findByDocumentTypeId(
        long documentTypeId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> findByDocumentTypeId(
        long documentTypeId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.send.model.PmlEdmDocumentSend findByDocumentTypeId_First(
        long documentTypeId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmDocumentSendException;

    public com.sgs.portlet.document.send.model.PmlEdmDocumentSend findByDocumentTypeId_Last(
        long documentTypeId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmDocumentSendException;

    public com.sgs.portlet.document.send.model.PmlEdmDocumentSend[] findByDocumentTypeId_PrevAndNext(
        long documentSendId, long documentTypeId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmDocumentSendException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> findByPrivilegeLevelId(
        java.lang.String privilegeLevelId)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> findByPrivilegeLevelId(
        java.lang.String privilegeLevelId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> findByPrivilegeLevelId(
        java.lang.String privilegeLevelId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.send.model.PmlEdmDocumentSend findByPrivilegeLevelId_First(
        java.lang.String privilegeLevelId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmDocumentSendException;

    public com.sgs.portlet.document.send.model.PmlEdmDocumentSend findByPrivilegeLevelId_Last(
        java.lang.String privilegeLevelId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmDocumentSendException;

    public com.sgs.portlet.document.send.model.PmlEdmDocumentSend[] findByPrivilegeLevelId_PrevAndNext(
        long documentSendId, java.lang.String privilegeLevelId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmDocumentSendException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> findByConfidentialLevelId(
        java.lang.String confidentialLevelId)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> findByConfidentialLevelId(
        java.lang.String confidentialLevelId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> findByConfidentialLevelId(
        java.lang.String confidentialLevelId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.send.model.PmlEdmDocumentSend findByConfidentialLevelId_First(
        java.lang.String confidentialLevelId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmDocumentSendException;

    public com.sgs.portlet.document.send.model.PmlEdmDocumentSend findByConfidentialLevelId_Last(
        java.lang.String confidentialLevelId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmDocumentSendException;

    public com.sgs.portlet.document.send.model.PmlEdmDocumentSend[] findByConfidentialLevelId_PrevAndNext(
        long documentSendId, java.lang.String confidentialLevelId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmDocumentSendException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> findByIssuingDate(
        java.util.Date issuingDate) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> findByIssuingDate(
        java.util.Date issuingDate, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> findByIssuingDate(
        java.util.Date issuingDate, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.send.model.PmlEdmDocumentSend findByIssuingDate_First(
        java.util.Date issuingDate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmDocumentSendException;

    public com.sgs.portlet.document.send.model.PmlEdmDocumentSend findByIssuingDate_Last(
        java.util.Date issuingDate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmDocumentSendException;

    public com.sgs.portlet.document.send.model.PmlEdmDocumentSend[] findByIssuingDate_PrevAndNext(
        long documentSendId, java.util.Date issuingDate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmDocumentSendException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> findByStatusId(
        long statusId) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> findByStatusId(
        long statusId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> findByStatusId(
        long statusId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.send.model.PmlEdmDocumentSend findByStatusId_First(
        long statusId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmDocumentSendException;

    public com.sgs.portlet.document.send.model.PmlEdmDocumentSend findByStatusId_Last(
        long statusId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmDocumentSendException;

    public com.sgs.portlet.document.send.model.PmlEdmDocumentSend[] findByStatusId_PrevAndNext(
        long documentSendId, long statusId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmDocumentSendException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> findByIsCongVanPhucDap(
        boolean iscongvanphucdap) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> findByIsCongVanPhucDap(
        boolean iscongvanphucdap, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> findByIsCongVanPhucDap(
        boolean iscongvanphucdap, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.send.model.PmlEdmDocumentSend findByIsCongVanPhucDap_First(
        boolean iscongvanphucdap,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmDocumentSendException;

    public com.sgs.portlet.document.send.model.PmlEdmDocumentSend findByIsCongVanPhucDap_Last(
        boolean iscongvanphucdap,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmDocumentSendException;

    public com.sgs.portlet.document.send.model.PmlEdmDocumentSend[] findByIsCongVanPhucDap_PrevAndNext(
        long documentSendId, boolean iscongvanphucdap,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmDocumentSendException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> findByOrgExternalId(
        long orgExternalId) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> findByOrgExternalId(
        long orgExternalId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> findByOrgExternalId(
        long orgExternalId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.send.model.PmlEdmDocumentSend findByOrgExternalId_First(
        long orgExternalId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmDocumentSendException;

    public com.sgs.portlet.document.send.model.PmlEdmDocumentSend findByOrgExternalId_Last(
        long orgExternalId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmDocumentSendException;

    public com.sgs.portlet.document.send.model.PmlEdmDocumentSend[] findByOrgExternalId_PrevAndNext(
        long documentSendId, long orgExternalId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmDocumentSendException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeByDocumentSendCode(java.lang.String documentSendCode)
        throws com.liferay.portal.SystemException;

    public void removeByNumberPublish(java.lang.String numberPublish)
        throws com.liferay.portal.SystemException;

    public void removeByNumberPage(java.lang.String numberPage)
        throws com.liferay.portal.SystemException;

    public void removeByPosition(java.lang.String position)
        throws com.liferay.portal.SystemException;

    public void removeBySignerName(java.lang.String signerName)
        throws com.liferay.portal.SystemException;

    public void removeBySendDate(java.util.Date sendDate)
        throws com.liferay.portal.SystemException;

    public void removeByDocumentReference(java.lang.String documentReference)
        throws com.liferay.portal.SystemException;

    public void removeByEditorId(long editorId)
        throws com.liferay.portal.SystemException;

    public void removeBySignerId(long signerId)
        throws com.liferay.portal.SystemException;

    public void removeByDocumentTypeId(long documentTypeId)
        throws com.liferay.portal.SystemException;

    public void removeByPrivilegeLevelId(java.lang.String privilegeLevelId)
        throws com.liferay.portal.SystemException;

    public void removeByConfidentialLevelId(
        java.lang.String confidentialLevelId)
        throws com.liferay.portal.SystemException;

    public void removeByIssuingDate(java.util.Date issuingDate)
        throws com.liferay.portal.SystemException;

    public void removeByStatusId(long statusId)
        throws com.liferay.portal.SystemException;

    public void removeByIsCongVanPhucDap(boolean iscongvanphucdap)
        throws com.liferay.portal.SystemException;

    public void removeByOrgExternalId(long orgExternalId)
        throws com.liferay.portal.SystemException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countByDocumentSendCode(java.lang.String documentSendCode)
        throws com.liferay.portal.SystemException;

    public int countByNumberPublish(java.lang.String numberPublish)
        throws com.liferay.portal.SystemException;

    public int countByNumberPage(java.lang.String numberPage)
        throws com.liferay.portal.SystemException;

    public int countByPosition(java.lang.String position)
        throws com.liferay.portal.SystemException;

    public int countBySignerName(java.lang.String signerName)
        throws com.liferay.portal.SystemException;

    public int countBySendDate(java.util.Date sendDate)
        throws com.liferay.portal.SystemException;

    public int countByDocumentReference(java.lang.String documentReference)
        throws com.liferay.portal.SystemException;

    public int countByEditorId(long editorId)
        throws com.liferay.portal.SystemException;

    public int countBySignerId(long signerId)
        throws com.liferay.portal.SystemException;

    public int countByDocumentTypeId(long documentTypeId)
        throws com.liferay.portal.SystemException;

    public int countByPrivilegeLevelId(java.lang.String privilegeLevelId)
        throws com.liferay.portal.SystemException;

    public int countByConfidentialLevelId(java.lang.String confidentialLevelId)
        throws com.liferay.portal.SystemException;

    public int countByIssuingDate(java.util.Date issuingDate)
        throws com.liferay.portal.SystemException;

    public int countByStatusId(long statusId)
        throws com.liferay.portal.SystemException;

    public int countByIsCongVanPhucDap(boolean iscongvanphucdap)
        throws com.liferay.portal.SystemException;

    public int countByOrgExternalId(long orgExternalId)
        throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;

    public void registerListener(
        com.liferay.portal.model.ModelListener listener);

    public void unregisterListener(
        com.liferay.portal.model.ModelListener listener);
}
