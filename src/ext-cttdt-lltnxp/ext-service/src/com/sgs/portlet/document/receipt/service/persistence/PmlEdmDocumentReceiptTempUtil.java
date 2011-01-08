package com.sgs.portlet.document.receipt.service.persistence;

public class PmlEdmDocumentReceiptTempUtil {
    private static PmlEdmDocumentReceiptTempPersistence _persistence;

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp create(
        long documentReceiptId) {
        return getPersistence().create(documentReceiptId);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp remove(
        long documentReceiptId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptTempException {
        return getPersistence().remove(documentReceiptId);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp remove(
        com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp pmlEdmDocumentReceiptTemp)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(pmlEdmDocumentReceiptTemp);
    }

    /**
     * @deprecated Use <code>update(PmlEdmDocumentReceiptTemp pmlEdmDocumentReceiptTemp, boolean merge)</code>.
     */
    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp update(
        com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp pmlEdmDocumentReceiptTemp)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(pmlEdmDocumentReceiptTemp);
    }

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
    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp update(
        com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp pmlEdmDocumentReceiptTemp,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().update(pmlEdmDocumentReceiptTemp, merge);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp updateImpl(
        com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp pmlEdmDocumentReceiptTemp,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(pmlEdmDocumentReceiptTemp, merge);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp findByPrimaryKey(
        long documentReceiptId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptTempException {
        return getPersistence().findByPrimaryKey(documentReceiptId);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp fetchByPrimaryKey(
        long documentReceiptId) throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(documentReceiptId);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp> findByDocumentType(
        java.lang.String documentType)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByDocumentType(documentType);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp> findByDocumentType(
        java.lang.String documentType, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByDocumentType(documentType, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp> findByDocumentType(
        java.lang.String documentType, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByDocumentType(documentType, start, end, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp findByDocumentType_First(
        java.lang.String documentType,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptTempException {
        return getPersistence().findByDocumentType_First(documentType, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp findByDocumentType_Last(
        java.lang.String documentType,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptTempException {
        return getPersistence().findByDocumentType_Last(documentType, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp[] findByDocumentType_PrevAndNext(
        long documentReceiptId, java.lang.String documentType,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptTempException {
        return getPersistence()
                   .findByDocumentType_PrevAndNext(documentReceiptId,
            documentType, obc);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp> findByLevelSendId(
        int levelSendId) throws com.liferay.portal.SystemException {
        return getPersistence().findByLevelSendId(levelSendId);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp> findByLevelSendId(
        int levelSendId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByLevelSendId(levelSendId, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp> findByLevelSendId(
        int levelSendId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByLevelSendId(levelSendId, start, end, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp findByLevelSendId_First(
        int levelSendId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptTempException {
        return getPersistence().findByLevelSendId_First(levelSendId, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp findByLevelSendId_Last(
        int levelSendId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptTempException {
        return getPersistence().findByLevelSendId_Last(levelSendId, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp[] findByLevelSendId_PrevAndNext(
        long documentReceiptId, int levelSendId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptTempException {
        return getPersistence()
                   .findByLevelSendId_PrevAndNext(documentReceiptId,
            levelSendId, obc);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp> findByDocumentTypeId(
        long documentTypeId) throws com.liferay.portal.SystemException {
        return getPersistence().findByDocumentTypeId(documentTypeId);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp> findByDocumentTypeId(
        long documentTypeId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByDocumentTypeId(documentTypeId, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp> findByDocumentTypeId(
        long documentTypeId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDocumentTypeId(documentTypeId, start, end, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp findByDocumentTypeId_First(
        long documentTypeId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptTempException {
        return getPersistence().findByDocumentTypeId_First(documentTypeId, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp findByDocumentTypeId_Last(
        long documentTypeId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptTempException {
        return getPersistence().findByDocumentTypeId_Last(documentTypeId, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp[] findByDocumentTypeId_PrevAndNext(
        long documentReceiptId, long documentTypeId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptTempException {
        return getPersistence()
                   .findByDocumentTypeId_PrevAndNext(documentReceiptId,
            documentTypeId, obc);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp> findByIssuingPlaceId(
        java.lang.String issuingPlaceId)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByIssuingPlaceId(issuingPlaceId);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp> findByIssuingPlaceId(
        java.lang.String issuingPlaceId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByIssuingPlaceId(issuingPlaceId, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp> findByIssuingPlaceId(
        java.lang.String issuingPlaceId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByIssuingPlaceId(issuingPlaceId, start, end, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp findByIssuingPlaceId_First(
        java.lang.String issuingPlaceId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptTempException {
        return getPersistence().findByIssuingPlaceId_First(issuingPlaceId, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp findByIssuingPlaceId_Last(
        java.lang.String issuingPlaceId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptTempException {
        return getPersistence().findByIssuingPlaceId_Last(issuingPlaceId, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp[] findByIssuingPlaceId_PrevAndNext(
        long documentReceiptId, java.lang.String issuingPlaceId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptTempException {
        return getPersistence()
                   .findByIssuingPlaceId_PrevAndNext(documentReceiptId,
            issuingPlaceId, obc);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp> findByPrivilegeLevelId(
        java.lang.String privilegeLevelId)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByPrivilegeLevelId(privilegeLevelId);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp> findByPrivilegeLevelId(
        java.lang.String privilegeLevelId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByPrivilegeLevelId(privilegeLevelId, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp> findByPrivilegeLevelId(
        java.lang.String privilegeLevelId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByPrivilegeLevelId(privilegeLevelId, start, end, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp findByPrivilegeLevelId_First(
        java.lang.String privilegeLevelId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptTempException {
        return getPersistence()
                   .findByPrivilegeLevelId_First(privilegeLevelId, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp findByPrivilegeLevelId_Last(
        java.lang.String privilegeLevelId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptTempException {
        return getPersistence()
                   .findByPrivilegeLevelId_Last(privilegeLevelId, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp[] findByPrivilegeLevelId_PrevAndNext(
        long documentReceiptId, java.lang.String privilegeLevelId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptTempException {
        return getPersistence()
                   .findByPrivilegeLevelId_PrevAndNext(documentReceiptId,
            privilegeLevelId, obc);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp> findByConfidentialLevelId(
        java.lang.String confidentialLevelId)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByConfidentialLevelId(confidentialLevelId);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp> findByConfidentialLevelId(
        java.lang.String confidentialLevelId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByConfidentialLevelId(confidentialLevelId, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp> findByConfidentialLevelId(
        java.lang.String confidentialLevelId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByConfidentialLevelId(confidentialLevelId, start, end,
            obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp findByConfidentialLevelId_First(
        java.lang.String confidentialLevelId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptTempException {
        return getPersistence()
                   .findByConfidentialLevelId_First(confidentialLevelId, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp findByConfidentialLevelId_Last(
        java.lang.String confidentialLevelId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptTempException {
        return getPersistence()
                   .findByConfidentialLevelId_Last(confidentialLevelId, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp[] findByConfidentialLevelId_PrevAndNext(
        long documentReceiptId, java.lang.String confidentialLevelId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptTempException {
        return getPersistence()
                   .findByConfidentialLevelId_PrevAndNext(documentReceiptId,
            confidentialLevelId, obc);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp> findByNumberLocalDocumentReceipt(
        java.lang.String numberLocalDocumentReceipt)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByNumberLocalDocumentReceipt(numberLocalDocumentReceipt);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp> findByNumberLocalDocumentReceipt(
        java.lang.String numberLocalDocumentReceipt, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByNumberLocalDocumentReceipt(numberLocalDocumentReceipt,
            start, end);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp> findByNumberLocalDocumentReceipt(
        java.lang.String numberLocalDocumentReceipt, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByNumberLocalDocumentReceipt(numberLocalDocumentReceipt,
            start, end, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp findByNumberLocalDocumentReceipt_First(
        java.lang.String numberLocalDocumentReceipt,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptTempException {
        return getPersistence()
                   .findByNumberLocalDocumentReceipt_First(numberLocalDocumentReceipt,
            obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp findByNumberLocalDocumentReceipt_Last(
        java.lang.String numberLocalDocumentReceipt,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptTempException {
        return getPersistence()
                   .findByNumberLocalDocumentReceipt_Last(numberLocalDocumentReceipt,
            obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp[] findByNumberLocalDocumentReceipt_PrevAndNext(
        long documentReceiptId, java.lang.String numberLocalDocumentReceipt,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptTempException {
        return getPersistence()
                   .findByNumberLocalDocumentReceipt_PrevAndNext(documentReceiptId,
            numberLocalDocumentReceipt, obc);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp> findByStatusId(
        long statusId) throws com.liferay.portal.SystemException {
        return getPersistence().findByStatusId(statusId);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp> findByStatusId(
        long statusId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByStatusId(statusId, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp> findByStatusId(
        long statusId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByStatusId(statusId, start, end, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp findByStatusId_First(
        long statusId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptTempException {
        return getPersistence().findByStatusId_First(statusId, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp findByStatusId_Last(
        long statusId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptTempException {
        return getPersistence().findByStatusId_Last(statusId, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp[] findByStatusId_PrevAndNext(
        long documentReceiptId, long statusId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptTempException {
        return getPersistence()
                   .findByStatusId_PrevAndNext(documentReceiptId, statusId, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp findBySoCongCanDiPhucDap(
        java.lang.String socongvandiphucdap)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptTempException {
        return getPersistence().findBySoCongCanDiPhucDap(socongvandiphucdap);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp fetchBySoCongCanDiPhucDap(
        java.lang.String socongvandiphucdap)
        throws com.liferay.portal.SystemException {
        return getPersistence().fetchBySoCongCanDiPhucDap(socongvandiphucdap);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp> findByMainDepartmentProcessId(
        java.lang.String mainDepartmentProcessId)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByMainDepartmentProcessId(mainDepartmentProcessId);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp> findByMainDepartmentProcessId(
        java.lang.String mainDepartmentProcessId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByMainDepartmentProcessId(mainDepartmentProcessId,
            start, end);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp> findByMainDepartmentProcessId(
        java.lang.String mainDepartmentProcessId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByMainDepartmentProcessId(mainDepartmentProcessId,
            start, end, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp findByMainDepartmentProcessId_First(
        java.lang.String mainDepartmentProcessId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptTempException {
        return getPersistence()
                   .findByMainDepartmentProcessId_First(mainDepartmentProcessId,
            obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp findByMainDepartmentProcessId_Last(
        java.lang.String mainDepartmentProcessId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptTempException {
        return getPersistence()
                   .findByMainDepartmentProcessId_Last(mainDepartmentProcessId,
            obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp[] findByMainDepartmentProcessId_PrevAndNext(
        long documentReceiptId, java.lang.String mainDepartmentProcessId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptTempException {
        return getPersistence()
                   .findByMainDepartmentProcessId_PrevAndNext(documentReceiptId,
            mainDepartmentProcessId, obc);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp> findByMainUserProcessId(
        long mainUserProcessId) throws com.liferay.portal.SystemException {
        return getPersistence().findByMainUserProcessId(mainUserProcessId);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp> findByMainUserProcessId(
        long mainUserProcessId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByMainUserProcessId(mainUserProcessId, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp> findByMainUserProcessId(
        long mainUserProcessId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByMainUserProcessId(mainUserProcessId, start, end, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp findByMainUserProcessId_First(
        long mainUserProcessId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptTempException {
        return getPersistence()
                   .findByMainUserProcessId_First(mainUserProcessId, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp findByMainUserProcessId_Last(
        long mainUserProcessId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptTempException {
        return getPersistence()
                   .findByMainUserProcessId_Last(mainUserProcessId, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp[] findByMainUserProcessId_PrevAndNext(
        long documentReceiptId, long mainUserProcessId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptTempException {
        return getPersistence()
                   .findByMainUserProcessId_PrevAndNext(documentReceiptId,
            mainUserProcessId, obc);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp> findByOrgExternalId(
        long orgExternalId) throws com.liferay.portal.SystemException {
        return getPersistence().findByOrgExternalId(orgExternalId);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp> findByOrgExternalId(
        long orgExternalId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByOrgExternalId(orgExternalId, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp> findByOrgExternalId(
        long orgExternalId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByOrgExternalId(orgExternalId, start, end, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp findByOrgExternalId_First(
        long orgExternalId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptTempException {
        return getPersistence().findByOrgExternalId_First(orgExternalId, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp findByOrgExternalId_Last(
        long orgExternalId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptTempException {
        return getPersistence().findByOrgExternalId_Last(orgExternalId, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp[] findByOrgExternalId_PrevAndNext(
        long documentReceiptId, long orgExternalId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptTempException {
        return getPersistence()
                   .findByOrgExternalId_PrevAndNext(documentReceiptId,
            orgExternalId, obc);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp> findByNumberDocumentReceipt_OrgExternalId(
        java.lang.String numberDocumentReceipt, long orgExternalId)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByNumberDocumentReceipt_OrgExternalId(numberDocumentReceipt,
            orgExternalId);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp> findByNumberDocumentReceipt_OrgExternalId(
        java.lang.String numberDocumentReceipt, long orgExternalId, int start,
        int end) throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByNumberDocumentReceipt_OrgExternalId(numberDocumentReceipt,
            orgExternalId, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp> findByNumberDocumentReceipt_OrgExternalId(
        java.lang.String numberDocumentReceipt, long orgExternalId, int start,
        int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByNumberDocumentReceipt_OrgExternalId(numberDocumentReceipt,
            orgExternalId, start, end, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp findByNumberDocumentReceipt_OrgExternalId_First(
        java.lang.String numberDocumentReceipt, long orgExternalId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptTempException {
        return getPersistence()
                   .findByNumberDocumentReceipt_OrgExternalId_First(numberDocumentReceipt,
            orgExternalId, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp findByNumberDocumentReceipt_OrgExternalId_Last(
        java.lang.String numberDocumentReceipt, long orgExternalId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptTempException {
        return getPersistence()
                   .findByNumberDocumentReceipt_OrgExternalId_Last(numberDocumentReceipt,
            orgExternalId, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp[] findByNumberDocumentReceipt_OrgExternalId_PrevAndNext(
        long documentReceiptId, java.lang.String numberDocumentReceipt,
        long orgExternalId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptTempException {
        return getPersistence()
                   .findByNumberDocumentReceipt_OrgExternalId_PrevAndNext(documentReceiptId,
            numberDocumentReceipt, orgExternalId, obc);
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

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end, obc);
    }

    public static void removeByDocumentType(java.lang.String documentType)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByDocumentType(documentType);
    }

    public static void removeByLevelSendId(int levelSendId)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByLevelSendId(levelSendId);
    }

    public static void removeByDocumentTypeId(long documentTypeId)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByDocumentTypeId(documentTypeId);
    }

    public static void removeByIssuingPlaceId(java.lang.String issuingPlaceId)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByIssuingPlaceId(issuingPlaceId);
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

    public static void removeByNumberLocalDocumentReceipt(
        java.lang.String numberLocalDocumentReceipt)
        throws com.liferay.portal.SystemException {
        getPersistence()
            .removeByNumberLocalDocumentReceipt(numberLocalDocumentReceipt);
    }

    public static void removeByStatusId(long statusId)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByStatusId(statusId);
    }

    public static void removeBySoCongCanDiPhucDap(
        java.lang.String socongvandiphucdap)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptTempException {
        getPersistence().removeBySoCongCanDiPhucDap(socongvandiphucdap);
    }

    public static void removeByMainDepartmentProcessId(
        java.lang.String mainDepartmentProcessId)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByMainDepartmentProcessId(mainDepartmentProcessId);
    }

    public static void removeByMainUserProcessId(long mainUserProcessId)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByMainUserProcessId(mainUserProcessId);
    }

    public static void removeByOrgExternalId(long orgExternalId)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByOrgExternalId(orgExternalId);
    }

    public static void removeByNumberDocumentReceipt_OrgExternalId(
        java.lang.String numberDocumentReceipt, long orgExternalId)
        throws com.liferay.portal.SystemException {
        getPersistence()
            .removeByNumberDocumentReceipt_OrgExternalId(numberDocumentReceipt,
            orgExternalId);
    }

    public static void removeAll() throws com.liferay.portal.SystemException {
        getPersistence().removeAll();
    }

    public static int countByDocumentType(java.lang.String documentType)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByDocumentType(documentType);
    }

    public static int countByLevelSendId(int levelSendId)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByLevelSendId(levelSendId);
    }

    public static int countByDocumentTypeId(long documentTypeId)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByDocumentTypeId(documentTypeId);
    }

    public static int countByIssuingPlaceId(java.lang.String issuingPlaceId)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByIssuingPlaceId(issuingPlaceId);
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

    public static int countByNumberLocalDocumentReceipt(
        java.lang.String numberLocalDocumentReceipt)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .countByNumberLocalDocumentReceipt(numberLocalDocumentReceipt);
    }

    public static int countByStatusId(long statusId)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByStatusId(statusId);
    }

    public static int countBySoCongCanDiPhucDap(
        java.lang.String socongvandiphucdap)
        throws com.liferay.portal.SystemException {
        return getPersistence().countBySoCongCanDiPhucDap(socongvandiphucdap);
    }

    public static int countByMainDepartmentProcessId(
        java.lang.String mainDepartmentProcessId)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .countByMainDepartmentProcessId(mainDepartmentProcessId);
    }

    public static int countByMainUserProcessId(long mainUserProcessId)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByMainUserProcessId(mainUserProcessId);
    }

    public static int countByOrgExternalId(long orgExternalId)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByOrgExternalId(orgExternalId);
    }

    public static int countByNumberDocumentReceipt_OrgExternalId(
        java.lang.String numberDocumentReceipt, long orgExternalId)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .countByNumberDocumentReceipt_OrgExternalId(numberDocumentReceipt,
            orgExternalId);
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

    public static PmlEdmDocumentReceiptTempPersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(PmlEdmDocumentReceiptTempPersistence persistence) {
        _persistence = persistence;
    }
}
