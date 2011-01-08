package com.sgs.portlet.document.receipt.service.persistence;

public interface PmlEdmDocumentReceiptPersistence {
    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt create(
        long documentReceiptId);

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt remove(
        long documentReceiptId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt remove(
        com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt pmlEdmDocumentReceipt)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(PmlEdmDocumentReceipt pmlEdmDocumentReceipt, boolean merge)</code>.
     */
    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt update(
        com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt pmlEdmDocumentReceipt)
        throws com.liferay.portal.SystemException;

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlEdmDocumentReceipt the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlEdmDocumentReceipt is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt update(
        com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt pmlEdmDocumentReceipt,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt updateImpl(
        com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt pmlEdmDocumentReceipt,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt findByPrimaryKey(
        long documentReceiptId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt fetchByPrimaryKey(
        long documentReceiptId) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> findByDocumentType(
        java.lang.String documentType)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> findByDocumentType(
        java.lang.String documentType, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> findByDocumentType(
        java.lang.String documentType, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt findByDocumentType_First(
        java.lang.String documentType,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt findByDocumentType_Last(
        java.lang.String documentType,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt[] findByDocumentType_PrevAndNext(
        long documentReceiptId, java.lang.String documentType,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> findByLevelSendId(
        int levelSendId) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> findByLevelSendId(
        int levelSendId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> findByLevelSendId(
        int levelSendId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt findByLevelSendId_First(
        int levelSendId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt findByLevelSendId_Last(
        int levelSendId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt[] findByLevelSendId_PrevAndNext(
        long documentReceiptId, int levelSendId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> findByDocumentTypeId(
        long documentTypeId) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> findByDocumentTypeId(
        long documentTypeId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> findByDocumentTypeId(
        long documentTypeId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt findByDocumentTypeId_First(
        long documentTypeId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt findByDocumentTypeId_Last(
        long documentTypeId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt[] findByDocumentTypeId_PrevAndNext(
        long documentReceiptId, long documentTypeId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> findByIssuingPlaceId(
        java.lang.String issuingPlaceId)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> findByIssuingPlaceId(
        java.lang.String issuingPlaceId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> findByIssuingPlaceId(
        java.lang.String issuingPlaceId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt findByIssuingPlaceId_First(
        java.lang.String issuingPlaceId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt findByIssuingPlaceId_Last(
        java.lang.String issuingPlaceId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt[] findByIssuingPlaceId_PrevAndNext(
        long documentReceiptId, java.lang.String issuingPlaceId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> findByPrivilegeLevelId(
        java.lang.String privilegeLevelId)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> findByPrivilegeLevelId(
        java.lang.String privilegeLevelId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> findByPrivilegeLevelId(
        java.lang.String privilegeLevelId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt findByPrivilegeLevelId_First(
        java.lang.String privilegeLevelId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt findByPrivilegeLevelId_Last(
        java.lang.String privilegeLevelId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt[] findByPrivilegeLevelId_PrevAndNext(
        long documentReceiptId, java.lang.String privilegeLevelId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> findByConfidentialLevelId(
        java.lang.String confidentialLevelId)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> findByConfidentialLevelId(
        java.lang.String confidentialLevelId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> findByConfidentialLevelId(
        java.lang.String confidentialLevelId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt findByConfidentialLevelId_First(
        java.lang.String confidentialLevelId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt findByConfidentialLevelId_Last(
        java.lang.String confidentialLevelId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt[] findByConfidentialLevelId_PrevAndNext(
        long documentReceiptId, java.lang.String confidentialLevelId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> findByNumberLocalDocumentReceipt(
        java.lang.String numberLocalDocumentReceipt)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> findByNumberLocalDocumentReceipt(
        java.lang.String numberLocalDocumentReceipt, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> findByNumberLocalDocumentReceipt(
        java.lang.String numberLocalDocumentReceipt, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt findByNumberLocalDocumentReceipt_First(
        java.lang.String numberLocalDocumentReceipt,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt findByNumberLocalDocumentReceipt_Last(
        java.lang.String numberLocalDocumentReceipt,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt[] findByNumberLocalDocumentReceipt_PrevAndNext(
        long documentReceiptId, java.lang.String numberLocalDocumentReceipt,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> findByStatusId(
        long statusId) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> findByStatusId(
        long statusId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> findByStatusId(
        long statusId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt findByStatusId_First(
        long statusId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt findByStatusId_Last(
        long statusId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt[] findByStatusId_PrevAndNext(
        long documentReceiptId, long statusId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt findBySoCongCanDiPhucDap(
        java.lang.String socongvandiphucdap)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt fetchBySoCongCanDiPhucDap(
        java.lang.String socongvandiphucdap)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> findByMainDepartmentProcessId(
        java.lang.String mainDepartmentProcessId)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> findByMainDepartmentProcessId(
        java.lang.String mainDepartmentProcessId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> findByMainDepartmentProcessId(
        java.lang.String mainDepartmentProcessId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt findByMainDepartmentProcessId_First(
        java.lang.String mainDepartmentProcessId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt findByMainDepartmentProcessId_Last(
        java.lang.String mainDepartmentProcessId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt[] findByMainDepartmentProcessId_PrevAndNext(
        long documentReceiptId, java.lang.String mainDepartmentProcessId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> findByMainUserProcessId(
        long mainUserProcessId) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> findByMainUserProcessId(
        long mainUserProcessId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> findByMainUserProcessId(
        long mainUserProcessId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt findByMainUserProcessId_First(
        long mainUserProcessId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt findByMainUserProcessId_Last(
        long mainUserProcessId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt[] findByMainUserProcessId_PrevAndNext(
        long documentReceiptId, long mainUserProcessId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> findByOrgExternalId(
        long orgExternalId) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> findByOrgExternalId(
        long orgExternalId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> findByOrgExternalId(
        long orgExternalId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt findByOrgExternalId_First(
        long orgExternalId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt findByOrgExternalId_Last(
        long orgExternalId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt[] findByOrgExternalId_PrevAndNext(
        long documentReceiptId, long orgExternalId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> findByDocReceiptTempId_OrgExternalId(
        long docReceiptTempId, long orgExternalId)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> findByDocReceiptTempId_OrgExternalId(
        long docReceiptTempId, long orgExternalId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> findByDocReceiptTempId_OrgExternalId(
        long docReceiptTempId, long orgExternalId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt findByDocReceiptTempId_OrgExternalId_First(
        long docReceiptTempId, long orgExternalId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt findByDocReceiptTempId_OrgExternalId_Last(
        long docReceiptTempId, long orgExternalId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt[] findByDocReceiptTempId_OrgExternalId_PrevAndNext(
        long documentReceiptId, long docReceiptTempId, long orgExternalId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> findByDocReceiptTempId(
        long docReceiptTempId) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> findByDocReceiptTempId(
        long docReceiptTempId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> findByDocReceiptTempId(
        long docReceiptTempId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt findByDocReceiptTempId_First(
        long docReceiptTempId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt findByDocReceiptTempId_Last(
        long docReceiptTempId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt[] findByDocReceiptTempId_PrevAndNext(
        long documentReceiptId, long docReceiptTempId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeByDocumentType(java.lang.String documentType)
        throws com.liferay.portal.SystemException;

    public void removeByLevelSendId(int levelSendId)
        throws com.liferay.portal.SystemException;

    public void removeByDocumentTypeId(long documentTypeId)
        throws com.liferay.portal.SystemException;

    public void removeByIssuingPlaceId(java.lang.String issuingPlaceId)
        throws com.liferay.portal.SystemException;

    public void removeByPrivilegeLevelId(java.lang.String privilegeLevelId)
        throws com.liferay.portal.SystemException;

    public void removeByConfidentialLevelId(
        java.lang.String confidentialLevelId)
        throws com.liferay.portal.SystemException;

    public void removeByNumberLocalDocumentReceipt(
        java.lang.String numberLocalDocumentReceipt)
        throws com.liferay.portal.SystemException;

    public void removeByStatusId(long statusId)
        throws com.liferay.portal.SystemException;

    public void removeBySoCongCanDiPhucDap(java.lang.String socongvandiphucdap)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptException;

    public void removeByMainDepartmentProcessId(
        java.lang.String mainDepartmentProcessId)
        throws com.liferay.portal.SystemException;

    public void removeByMainUserProcessId(long mainUserProcessId)
        throws com.liferay.portal.SystemException;

    public void removeByOrgExternalId(long orgExternalId)
        throws com.liferay.portal.SystemException;

    public void removeByDocReceiptTempId_OrgExternalId(long docReceiptTempId,
        long orgExternalId) throws com.liferay.portal.SystemException;

    public void removeByDocReceiptTempId(long docReceiptTempId)
        throws com.liferay.portal.SystemException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countByDocumentType(java.lang.String documentType)
        throws com.liferay.portal.SystemException;

    public int countByLevelSendId(int levelSendId)
        throws com.liferay.portal.SystemException;

    public int countByDocumentTypeId(long documentTypeId)
        throws com.liferay.portal.SystemException;

    public int countByIssuingPlaceId(java.lang.String issuingPlaceId)
        throws com.liferay.portal.SystemException;

    public int countByPrivilegeLevelId(java.lang.String privilegeLevelId)
        throws com.liferay.portal.SystemException;

    public int countByConfidentialLevelId(java.lang.String confidentialLevelId)
        throws com.liferay.portal.SystemException;

    public int countByNumberLocalDocumentReceipt(
        java.lang.String numberLocalDocumentReceipt)
        throws com.liferay.portal.SystemException;

    public int countByStatusId(long statusId)
        throws com.liferay.portal.SystemException;

    public int countBySoCongCanDiPhucDap(java.lang.String socongvandiphucdap)
        throws com.liferay.portal.SystemException;

    public int countByMainDepartmentProcessId(
        java.lang.String mainDepartmentProcessId)
        throws com.liferay.portal.SystemException;

    public int countByMainUserProcessId(long mainUserProcessId)
        throws com.liferay.portal.SystemException;

    public int countByOrgExternalId(long orgExternalId)
        throws com.liferay.portal.SystemException;

    public int countByDocReceiptTempId_OrgExternalId(long docReceiptTempId,
        long orgExternalId) throws com.liferay.portal.SystemException;

    public int countByDocReceiptTempId(long docReceiptTempId)
        throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;

    public void registerListener(
        com.liferay.portal.model.ModelListener listener);

    public void unregisterListener(
        com.liferay.portal.model.ModelListener listener);
}
