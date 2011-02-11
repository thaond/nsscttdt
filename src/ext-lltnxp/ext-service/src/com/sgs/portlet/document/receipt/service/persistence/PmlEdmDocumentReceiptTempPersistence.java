package com.sgs.portlet.document.receipt.service.persistence;

public interface PmlEdmDocumentReceiptTempPersistence {
    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp create(
        long documentReceiptId);

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp remove(
        long documentReceiptId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptTempException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp remove(
        com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp pmlEdmDocumentReceiptTemp)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(PmlEdmDocumentReceiptTemp pmlEdmDocumentReceiptTemp, boolean merge)</code>.
     */
    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp update(
        com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp pmlEdmDocumentReceiptTemp)
        throws com.liferay.portal.SystemException;

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlEdmDocumentReceiptTemp the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlEdmDocumentReceiptTemp is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp update(
        com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp pmlEdmDocumentReceiptTemp,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp updateImpl(
        com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp pmlEdmDocumentReceiptTemp,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp findByPrimaryKey(
        long documentReceiptId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptTempException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp fetchByPrimaryKey(
        long documentReceiptId) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp> findByDocumentType(
        java.lang.String documentType)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp> findByDocumentType(
        java.lang.String documentType, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp> findByDocumentType(
        java.lang.String documentType, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp findByDocumentType_First(
        java.lang.String documentType,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptTempException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp findByDocumentType_Last(
        java.lang.String documentType,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptTempException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp[] findByDocumentType_PrevAndNext(
        long documentReceiptId, java.lang.String documentType,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptTempException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp> findByLevelSendId(
        int levelSendId) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp> findByLevelSendId(
        int levelSendId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp> findByLevelSendId(
        int levelSendId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp findByLevelSendId_First(
        int levelSendId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptTempException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp findByLevelSendId_Last(
        int levelSendId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptTempException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp[] findByLevelSendId_PrevAndNext(
        long documentReceiptId, int levelSendId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptTempException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp> findByDocumentTypeId(
        long documentTypeId) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp> findByDocumentTypeId(
        long documentTypeId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp> findByDocumentTypeId(
        long documentTypeId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp findByDocumentTypeId_First(
        long documentTypeId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptTempException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp findByDocumentTypeId_Last(
        long documentTypeId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptTempException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp[] findByDocumentTypeId_PrevAndNext(
        long documentReceiptId, long documentTypeId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptTempException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp> findByIssuingPlaceId(
        java.lang.String issuingPlaceId)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp> findByIssuingPlaceId(
        java.lang.String issuingPlaceId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp> findByIssuingPlaceId(
        java.lang.String issuingPlaceId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp findByIssuingPlaceId_First(
        java.lang.String issuingPlaceId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptTempException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp findByIssuingPlaceId_Last(
        java.lang.String issuingPlaceId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptTempException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp[] findByIssuingPlaceId_PrevAndNext(
        long documentReceiptId, java.lang.String issuingPlaceId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptTempException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp> findByPrivilegeLevelId(
        java.lang.String privilegeLevelId)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp> findByPrivilegeLevelId(
        java.lang.String privilegeLevelId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp> findByPrivilegeLevelId(
        java.lang.String privilegeLevelId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp findByPrivilegeLevelId_First(
        java.lang.String privilegeLevelId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptTempException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp findByPrivilegeLevelId_Last(
        java.lang.String privilegeLevelId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptTempException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp[] findByPrivilegeLevelId_PrevAndNext(
        long documentReceiptId, java.lang.String privilegeLevelId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptTempException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp> findByConfidentialLevelId(
        java.lang.String confidentialLevelId)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp> findByConfidentialLevelId(
        java.lang.String confidentialLevelId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp> findByConfidentialLevelId(
        java.lang.String confidentialLevelId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp findByConfidentialLevelId_First(
        java.lang.String confidentialLevelId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptTempException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp findByConfidentialLevelId_Last(
        java.lang.String confidentialLevelId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptTempException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp[] findByConfidentialLevelId_PrevAndNext(
        long documentReceiptId, java.lang.String confidentialLevelId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptTempException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp> findByNumberLocalDocumentReceipt(
        java.lang.String numberLocalDocumentReceipt)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp> findByNumberLocalDocumentReceipt(
        java.lang.String numberLocalDocumentReceipt, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp> findByNumberLocalDocumentReceipt(
        java.lang.String numberLocalDocumentReceipt, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp findByNumberLocalDocumentReceipt_First(
        java.lang.String numberLocalDocumentReceipt,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptTempException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp findByNumberLocalDocumentReceipt_Last(
        java.lang.String numberLocalDocumentReceipt,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptTempException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp[] findByNumberLocalDocumentReceipt_PrevAndNext(
        long documentReceiptId, java.lang.String numberLocalDocumentReceipt,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptTempException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp> findByStatusId(
        long statusId) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp> findByStatusId(
        long statusId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp> findByStatusId(
        long statusId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp findByStatusId_First(
        long statusId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptTempException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp findByStatusId_Last(
        long statusId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptTempException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp[] findByStatusId_PrevAndNext(
        long documentReceiptId, long statusId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptTempException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp findBySoCongCanDiPhucDap(
        java.lang.String socongvandiphucdap)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptTempException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp fetchBySoCongCanDiPhucDap(
        java.lang.String socongvandiphucdap)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp> findByMainDepartmentProcessId(
        java.lang.String mainDepartmentProcessId)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp> findByMainDepartmentProcessId(
        java.lang.String mainDepartmentProcessId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp> findByMainDepartmentProcessId(
        java.lang.String mainDepartmentProcessId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp findByMainDepartmentProcessId_First(
        java.lang.String mainDepartmentProcessId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptTempException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp findByMainDepartmentProcessId_Last(
        java.lang.String mainDepartmentProcessId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptTempException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp[] findByMainDepartmentProcessId_PrevAndNext(
        long documentReceiptId, java.lang.String mainDepartmentProcessId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptTempException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp> findByMainUserProcessId(
        long mainUserProcessId) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp> findByMainUserProcessId(
        long mainUserProcessId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp> findByMainUserProcessId(
        long mainUserProcessId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp findByMainUserProcessId_First(
        long mainUserProcessId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptTempException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp findByMainUserProcessId_Last(
        long mainUserProcessId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptTempException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp[] findByMainUserProcessId_PrevAndNext(
        long documentReceiptId, long mainUserProcessId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptTempException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp> findByOrgExternalId(
        long orgExternalId) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp> findByOrgExternalId(
        long orgExternalId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp> findByOrgExternalId(
        long orgExternalId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp findByOrgExternalId_First(
        long orgExternalId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptTempException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp findByOrgExternalId_Last(
        long orgExternalId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptTempException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp[] findByOrgExternalId_PrevAndNext(
        long documentReceiptId, long orgExternalId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptTempException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp> findByNumberDocumentReceipt_OrgExternalId(
        java.lang.String numberDocumentReceipt, long orgExternalId)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp> findByNumberDocumentReceipt_OrgExternalId(
        java.lang.String numberDocumentReceipt, long orgExternalId, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp> findByNumberDocumentReceipt_OrgExternalId(
        java.lang.String numberDocumentReceipt, long orgExternalId, int start,
        int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp findByNumberDocumentReceipt_OrgExternalId_First(
        java.lang.String numberDocumentReceipt, long orgExternalId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptTempException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp findByNumberDocumentReceipt_OrgExternalId_Last(
        java.lang.String numberDocumentReceipt, long orgExternalId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptTempException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp[] findByNumberDocumentReceipt_OrgExternalId_PrevAndNext(
        long documentReceiptId, java.lang.String numberDocumentReceipt,
        long orgExternalId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptTempException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp> findAll(
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
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptTempException;

    public void removeByMainDepartmentProcessId(
        java.lang.String mainDepartmentProcessId)
        throws com.liferay.portal.SystemException;

    public void removeByMainUserProcessId(long mainUserProcessId)
        throws com.liferay.portal.SystemException;

    public void removeByOrgExternalId(long orgExternalId)
        throws com.liferay.portal.SystemException;

    public void removeByNumberDocumentReceipt_OrgExternalId(
        java.lang.String numberDocumentReceipt, long orgExternalId)
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

    public int countByNumberDocumentReceipt_OrgExternalId(
        java.lang.String numberDocumentReceipt, long orgExternalId)
        throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;

    public void registerListener(
        com.liferay.portal.model.ModelListener listener);

    public void unregisterListener(
        com.liferay.portal.model.ModelListener listener);
}
