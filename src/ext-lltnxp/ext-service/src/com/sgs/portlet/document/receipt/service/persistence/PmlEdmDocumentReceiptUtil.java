package com.sgs.portlet.document.receipt.service.persistence;

public class PmlEdmDocumentReceiptUtil {
    private static PmlEdmDocumentReceiptPersistence _persistence;

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt create(
        long documentReceiptId) {
        return getPersistence().create(documentReceiptId);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt remove(
        long documentReceiptId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptException {
        return getPersistence().remove(documentReceiptId);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt remove(
        com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt pmlEdmDocumentReceipt)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(pmlEdmDocumentReceipt);
    }

    /**
     * @deprecated Use <code>update(PmlEdmDocumentReceipt pmlEdmDocumentReceipt, boolean merge)</code>.
     */
    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt update(
        com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt pmlEdmDocumentReceipt)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(pmlEdmDocumentReceipt);
    }

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
    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt update(
        com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt pmlEdmDocumentReceipt,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().update(pmlEdmDocumentReceipt, merge);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt updateImpl(
        com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt pmlEdmDocumentReceipt,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(pmlEdmDocumentReceipt, merge);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt findByPrimaryKey(
        long documentReceiptId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptException {
        return getPersistence().findByPrimaryKey(documentReceiptId);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt fetchByPrimaryKey(
        long documentReceiptId) throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(documentReceiptId);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> findByDocumentType(
        java.lang.String documentType)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByDocumentType(documentType);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> findByDocumentType(
        java.lang.String documentType, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByDocumentType(documentType, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> findByDocumentType(
        java.lang.String documentType, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByDocumentType(documentType, start, end, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt findByDocumentType_First(
        java.lang.String documentType,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptException {
        return getPersistence().findByDocumentType_First(documentType, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt findByDocumentType_Last(
        java.lang.String documentType,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptException {
        return getPersistence().findByDocumentType_Last(documentType, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt[] findByDocumentType_PrevAndNext(
        long documentReceiptId, java.lang.String documentType,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptException {
        return getPersistence()
                   .findByDocumentType_PrevAndNext(documentReceiptId,
            documentType, obc);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> findByLevelSendId(
        int levelSendId) throws com.liferay.portal.SystemException {
        return getPersistence().findByLevelSendId(levelSendId);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> findByLevelSendId(
        int levelSendId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByLevelSendId(levelSendId, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> findByLevelSendId(
        int levelSendId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByLevelSendId(levelSendId, start, end, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt findByLevelSendId_First(
        int levelSendId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptException {
        return getPersistence().findByLevelSendId_First(levelSendId, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt findByLevelSendId_Last(
        int levelSendId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptException {
        return getPersistence().findByLevelSendId_Last(levelSendId, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt[] findByLevelSendId_PrevAndNext(
        long documentReceiptId, int levelSendId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptException {
        return getPersistence()
                   .findByLevelSendId_PrevAndNext(documentReceiptId,
            levelSendId, obc);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> findByDocumentTypeId(
        long documentTypeId) throws com.liferay.portal.SystemException {
        return getPersistence().findByDocumentTypeId(documentTypeId);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> findByDocumentTypeId(
        long documentTypeId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByDocumentTypeId(documentTypeId, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> findByDocumentTypeId(
        long documentTypeId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDocumentTypeId(documentTypeId, start, end, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt findByDocumentTypeId_First(
        long documentTypeId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptException {
        return getPersistence().findByDocumentTypeId_First(documentTypeId, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt findByDocumentTypeId_Last(
        long documentTypeId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptException {
        return getPersistence().findByDocumentTypeId_Last(documentTypeId, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt[] findByDocumentTypeId_PrevAndNext(
        long documentReceiptId, long documentTypeId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptException {
        return getPersistence()
                   .findByDocumentTypeId_PrevAndNext(documentReceiptId,
            documentTypeId, obc);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> findByIssuingPlaceId(
        java.lang.String issuingPlaceId)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByIssuingPlaceId(issuingPlaceId);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> findByIssuingPlaceId(
        java.lang.String issuingPlaceId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByIssuingPlaceId(issuingPlaceId, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> findByIssuingPlaceId(
        java.lang.String issuingPlaceId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByIssuingPlaceId(issuingPlaceId, start, end, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt findByIssuingPlaceId_First(
        java.lang.String issuingPlaceId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptException {
        return getPersistence().findByIssuingPlaceId_First(issuingPlaceId, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt findByIssuingPlaceId_Last(
        java.lang.String issuingPlaceId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptException {
        return getPersistence().findByIssuingPlaceId_Last(issuingPlaceId, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt[] findByIssuingPlaceId_PrevAndNext(
        long documentReceiptId, java.lang.String issuingPlaceId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptException {
        return getPersistence()
                   .findByIssuingPlaceId_PrevAndNext(documentReceiptId,
            issuingPlaceId, obc);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> findByPrivilegeLevelId(
        java.lang.String privilegeLevelId)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByPrivilegeLevelId(privilegeLevelId);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> findByPrivilegeLevelId(
        java.lang.String privilegeLevelId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByPrivilegeLevelId(privilegeLevelId, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> findByPrivilegeLevelId(
        java.lang.String privilegeLevelId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByPrivilegeLevelId(privilegeLevelId, start, end, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt findByPrivilegeLevelId_First(
        java.lang.String privilegeLevelId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptException {
        return getPersistence()
                   .findByPrivilegeLevelId_First(privilegeLevelId, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt findByPrivilegeLevelId_Last(
        java.lang.String privilegeLevelId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptException {
        return getPersistence()
                   .findByPrivilegeLevelId_Last(privilegeLevelId, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt[] findByPrivilegeLevelId_PrevAndNext(
        long documentReceiptId, java.lang.String privilegeLevelId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptException {
        return getPersistence()
                   .findByPrivilegeLevelId_PrevAndNext(documentReceiptId,
            privilegeLevelId, obc);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> findByConfidentialLevelId(
        java.lang.String confidentialLevelId)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByConfidentialLevelId(confidentialLevelId);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> findByConfidentialLevelId(
        java.lang.String confidentialLevelId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByConfidentialLevelId(confidentialLevelId, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> findByConfidentialLevelId(
        java.lang.String confidentialLevelId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByConfidentialLevelId(confidentialLevelId, start, end,
            obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt findByConfidentialLevelId_First(
        java.lang.String confidentialLevelId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptException {
        return getPersistence()
                   .findByConfidentialLevelId_First(confidentialLevelId, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt findByConfidentialLevelId_Last(
        java.lang.String confidentialLevelId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptException {
        return getPersistence()
                   .findByConfidentialLevelId_Last(confidentialLevelId, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt[] findByConfidentialLevelId_PrevAndNext(
        long documentReceiptId, java.lang.String confidentialLevelId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptException {
        return getPersistence()
                   .findByConfidentialLevelId_PrevAndNext(documentReceiptId,
            confidentialLevelId, obc);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> findByNumberLocalDocumentReceipt(
        java.lang.String numberLocalDocumentReceipt)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByNumberLocalDocumentReceipt(numberLocalDocumentReceipt);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> findByNumberLocalDocumentReceipt(
        java.lang.String numberLocalDocumentReceipt, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByNumberLocalDocumentReceipt(numberLocalDocumentReceipt,
            start, end);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> findByNumberLocalDocumentReceipt(
        java.lang.String numberLocalDocumentReceipt, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByNumberLocalDocumentReceipt(numberLocalDocumentReceipt,
            start, end, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt findByNumberLocalDocumentReceipt_First(
        java.lang.String numberLocalDocumentReceipt,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptException {
        return getPersistence()
                   .findByNumberLocalDocumentReceipt_First(numberLocalDocumentReceipt,
            obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt findByNumberLocalDocumentReceipt_Last(
        java.lang.String numberLocalDocumentReceipt,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptException {
        return getPersistence()
                   .findByNumberLocalDocumentReceipt_Last(numberLocalDocumentReceipt,
            obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt[] findByNumberLocalDocumentReceipt_PrevAndNext(
        long documentReceiptId, java.lang.String numberLocalDocumentReceipt,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptException {
        return getPersistence()
                   .findByNumberLocalDocumentReceipt_PrevAndNext(documentReceiptId,
            numberLocalDocumentReceipt, obc);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> findByStatusId(
        long statusId) throws com.liferay.portal.SystemException {
        return getPersistence().findByStatusId(statusId);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> findByStatusId(
        long statusId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByStatusId(statusId, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> findByStatusId(
        long statusId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByStatusId(statusId, start, end, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt findByStatusId_First(
        long statusId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptException {
        return getPersistence().findByStatusId_First(statusId, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt findByStatusId_Last(
        long statusId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptException {
        return getPersistence().findByStatusId_Last(statusId, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt[] findByStatusId_PrevAndNext(
        long documentReceiptId, long statusId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptException {
        return getPersistence()
                   .findByStatusId_PrevAndNext(documentReceiptId, statusId, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt findBySoCongCanDiPhucDap(
        java.lang.String socongvandiphucdap)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptException {
        return getPersistence().findBySoCongCanDiPhucDap(socongvandiphucdap);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt fetchBySoCongCanDiPhucDap(
        java.lang.String socongvandiphucdap)
        throws com.liferay.portal.SystemException {
        return getPersistence().fetchBySoCongCanDiPhucDap(socongvandiphucdap);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> findByMainDepartmentProcessId(
        java.lang.String mainDepartmentProcessId)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByMainDepartmentProcessId(mainDepartmentProcessId);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> findByMainDepartmentProcessId(
        java.lang.String mainDepartmentProcessId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByMainDepartmentProcessId(mainDepartmentProcessId,
            start, end);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> findByMainDepartmentProcessId(
        java.lang.String mainDepartmentProcessId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByMainDepartmentProcessId(mainDepartmentProcessId,
            start, end, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt findByMainDepartmentProcessId_First(
        java.lang.String mainDepartmentProcessId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptException {
        return getPersistence()
                   .findByMainDepartmentProcessId_First(mainDepartmentProcessId,
            obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt findByMainDepartmentProcessId_Last(
        java.lang.String mainDepartmentProcessId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptException {
        return getPersistence()
                   .findByMainDepartmentProcessId_Last(mainDepartmentProcessId,
            obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt[] findByMainDepartmentProcessId_PrevAndNext(
        long documentReceiptId, java.lang.String mainDepartmentProcessId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptException {
        return getPersistence()
                   .findByMainDepartmentProcessId_PrevAndNext(documentReceiptId,
            mainDepartmentProcessId, obc);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> findByMainUserProcessId(
        long mainUserProcessId) throws com.liferay.portal.SystemException {
        return getPersistence().findByMainUserProcessId(mainUserProcessId);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> findByMainUserProcessId(
        long mainUserProcessId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByMainUserProcessId(mainUserProcessId, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> findByMainUserProcessId(
        long mainUserProcessId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByMainUserProcessId(mainUserProcessId, start, end, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt findByMainUserProcessId_First(
        long mainUserProcessId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptException {
        return getPersistence()
                   .findByMainUserProcessId_First(mainUserProcessId, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt findByMainUserProcessId_Last(
        long mainUserProcessId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptException {
        return getPersistence()
                   .findByMainUserProcessId_Last(mainUserProcessId, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt[] findByMainUserProcessId_PrevAndNext(
        long documentReceiptId, long mainUserProcessId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptException {
        return getPersistence()
                   .findByMainUserProcessId_PrevAndNext(documentReceiptId,
            mainUserProcessId, obc);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> findByOrgExternalId(
        long orgExternalId) throws com.liferay.portal.SystemException {
        return getPersistence().findByOrgExternalId(orgExternalId);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> findByOrgExternalId(
        long orgExternalId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByOrgExternalId(orgExternalId, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> findByOrgExternalId(
        long orgExternalId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByOrgExternalId(orgExternalId, start, end, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt findByOrgExternalId_First(
        long orgExternalId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptException {
        return getPersistence().findByOrgExternalId_First(orgExternalId, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt findByOrgExternalId_Last(
        long orgExternalId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptException {
        return getPersistence().findByOrgExternalId_Last(orgExternalId, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt[] findByOrgExternalId_PrevAndNext(
        long documentReceiptId, long orgExternalId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptException {
        return getPersistence()
                   .findByOrgExternalId_PrevAndNext(documentReceiptId,
            orgExternalId, obc);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> findByDocReceiptTempId_OrgExternalId(
        long docReceiptTempId, long orgExternalId)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDocReceiptTempId_OrgExternalId(docReceiptTempId,
            orgExternalId);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> findByDocReceiptTempId_OrgExternalId(
        long docReceiptTempId, long orgExternalId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDocReceiptTempId_OrgExternalId(docReceiptTempId,
            orgExternalId, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> findByDocReceiptTempId_OrgExternalId(
        long docReceiptTempId, long orgExternalId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDocReceiptTempId_OrgExternalId(docReceiptTempId,
            orgExternalId, start, end, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt findByDocReceiptTempId_OrgExternalId_First(
        long docReceiptTempId, long orgExternalId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptException {
        return getPersistence()
                   .findByDocReceiptTempId_OrgExternalId_First(docReceiptTempId,
            orgExternalId, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt findByDocReceiptTempId_OrgExternalId_Last(
        long docReceiptTempId, long orgExternalId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptException {
        return getPersistence()
                   .findByDocReceiptTempId_OrgExternalId_Last(docReceiptTempId,
            orgExternalId, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt[] findByDocReceiptTempId_OrgExternalId_PrevAndNext(
        long documentReceiptId, long docReceiptTempId, long orgExternalId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptException {
        return getPersistence()
                   .findByDocReceiptTempId_OrgExternalId_PrevAndNext(documentReceiptId,
            docReceiptTempId, orgExternalId, obc);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> findByDocReceiptTempId(
        long docReceiptTempId) throws com.liferay.portal.SystemException {
        return getPersistence().findByDocReceiptTempId(docReceiptTempId);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> findByDocReceiptTempId(
        long docReceiptTempId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDocReceiptTempId(docReceiptTempId, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> findByDocReceiptTempId(
        long docReceiptTempId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDocReceiptTempId(docReceiptTempId, start, end, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt findByDocReceiptTempId_First(
        long docReceiptTempId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptException {
        return getPersistence()
                   .findByDocReceiptTempId_First(docReceiptTempId, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt findByDocReceiptTempId_Last(
        long docReceiptTempId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptException {
        return getPersistence()
                   .findByDocReceiptTempId_Last(docReceiptTempId, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt[] findByDocReceiptTempId_PrevAndNext(
        long documentReceiptId, long docReceiptTempId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptException {
        return getPersistence()
                   .findByDocReceiptTempId_PrevAndNext(documentReceiptId,
            docReceiptTempId, obc);
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

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> findAll(
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
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptException {
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

    public static void removeByDocReceiptTempId_OrgExternalId(
        long docReceiptTempId, long orgExternalId)
        throws com.liferay.portal.SystemException {
        getPersistence()
            .removeByDocReceiptTempId_OrgExternalId(docReceiptTempId,
            orgExternalId);
    }

    public static void removeByDocReceiptTempId(long docReceiptTempId)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByDocReceiptTempId(docReceiptTempId);
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

    public static int countByDocReceiptTempId_OrgExternalId(
        long docReceiptTempId, long orgExternalId)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .countByDocReceiptTempId_OrgExternalId(docReceiptTempId,
            orgExternalId);
    }

    public static int countByDocReceiptTempId(long docReceiptTempId)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByDocReceiptTempId(docReceiptTempId);
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

    public static PmlEdmDocumentReceiptPersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(PmlEdmDocumentReceiptPersistence persistence) {
        _persistence = persistence;
    }
}
