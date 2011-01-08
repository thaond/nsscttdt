package com.sgs.portlet.document.receipt.service.persistence;

public class PmlEdmBookDocumentRecordToUtil {
    private static PmlEdmBookDocumentRecordToPersistence _persistence;

    public static com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo create(
        com.sgs.portlet.document.receipt.service.persistence.PmlEdmBookDocumentRecordToPK pmlEdmBookDocumentRecordToPK) {
        return getPersistence().create(pmlEdmBookDocumentRecordToPK);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo remove(
        com.sgs.portlet.document.receipt.service.persistence.PmlEdmBookDocumentRecordToPK pmlEdmBookDocumentRecordToPK)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmBookDocumentRecordToException {
        return getPersistence().remove(pmlEdmBookDocumentRecordToPK);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo remove(
        com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo pmlEdmBookDocumentRecordTo)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(pmlEdmBookDocumentRecordTo);
    }

    /**
     * @deprecated Use <code>update(PmlEdmBookDocumentRecordTo pmlEdmBookDocumentRecordTo, boolean merge)</code>.
     */
    public static com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo update(
        com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo pmlEdmBookDocumentRecordTo)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(pmlEdmBookDocumentRecordTo);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlEdmBookDocumentRecordTo the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlEdmBookDocumentRecordTo is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public static com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo update(
        com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo pmlEdmBookDocumentRecordTo,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().update(pmlEdmBookDocumentRecordTo, merge);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo updateImpl(
        com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo pmlEdmBookDocumentRecordTo,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(pmlEdmBookDocumentRecordTo, merge);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo findByPrimaryKey(
        com.sgs.portlet.document.receipt.service.persistence.PmlEdmBookDocumentRecordToPK pmlEdmBookDocumentRecordToPK)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmBookDocumentRecordToException {
        return getPersistence().findByPrimaryKey(pmlEdmBookDocumentRecordToPK);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo fetchByPrimaryKey(
        com.sgs.portlet.document.receipt.service.persistence.PmlEdmBookDocumentRecordToPK pmlEdmBookDocumentRecordToPK)
        throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(pmlEdmBookDocumentRecordToPK);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo> findByDocumentReceiptId(
        long documentReceiptId) throws com.liferay.portal.SystemException {
        return getPersistence().findByDocumentReceiptId(documentReceiptId);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo> findByDocumentReceiptId(
        long documentReceiptId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDocumentReceiptId(documentReceiptId, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo> findByDocumentReceiptId(
        long documentReceiptId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDocumentReceiptId(documentReceiptId, start, end, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo findByDocumentReceiptId_First(
        long documentReceiptId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmBookDocumentRecordToException {
        return getPersistence()
                   .findByDocumentReceiptId_First(documentReceiptId, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo findByDocumentReceiptId_Last(
        long documentReceiptId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmBookDocumentRecordToException {
        return getPersistence()
                   .findByDocumentReceiptId_Last(documentReceiptId, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo[] findByDocumentReceiptId_PrevAndNext(
        com.sgs.portlet.document.receipt.service.persistence.PmlEdmBookDocumentRecordToPK pmlEdmBookDocumentRecordToPK,
        long documentReceiptId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmBookDocumentRecordToException {
        return getPersistence()
                   .findByDocumentReceiptId_PrevAndNext(pmlEdmBookDocumentRecordToPK,
            documentReceiptId, obc);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo> findByDocumentRecordToId(
        long documentRecordToId) throws com.liferay.portal.SystemException {
        return getPersistence().findByDocumentRecordToId(documentRecordToId);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo> findByDocumentRecordToId(
        long documentRecordToId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDocumentRecordToId(documentRecordToId, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo> findByDocumentRecordToId(
        long documentRecordToId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDocumentRecordToId(documentRecordToId, start, end, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo findByDocumentRecordToId_First(
        long documentRecordToId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmBookDocumentRecordToException {
        return getPersistence()
                   .findByDocumentRecordToId_First(documentRecordToId, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo findByDocumentRecordToId_Last(
        long documentRecordToId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmBookDocumentRecordToException {
        return getPersistence()
                   .findByDocumentRecordToId_Last(documentRecordToId, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo[] findByDocumentRecordToId_PrevAndNext(
        com.sgs.portlet.document.receipt.service.persistence.PmlEdmBookDocumentRecordToPK pmlEdmBookDocumentRecordToPK,
        long documentRecordToId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmBookDocumentRecordToException {
        return getPersistence()
                   .findByDocumentRecordToId_PrevAndNext(pmlEdmBookDocumentRecordToPK,
            documentRecordToId, obc);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo> findByDateComplete(
        java.util.Date dateComplete) throws com.liferay.portal.SystemException {
        return getPersistence().findByDateComplete(dateComplete);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo> findByDateComplete(
        java.util.Date dateComplete, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByDateComplete(dateComplete, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo> findByDateComplete(
        java.util.Date dateComplete, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByDateComplete(dateComplete, start, end, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo findByDateComplete_First(
        java.util.Date dateComplete,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmBookDocumentRecordToException {
        return getPersistence().findByDateComplete_First(dateComplete, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo findByDateComplete_Last(
        java.util.Date dateComplete,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmBookDocumentRecordToException {
        return getPersistence().findByDateComplete_Last(dateComplete, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo[] findByDateComplete_PrevAndNext(
        com.sgs.portlet.document.receipt.service.persistence.PmlEdmBookDocumentRecordToPK pmlEdmBookDocumentRecordToPK,
        java.util.Date dateComplete,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmBookDocumentRecordToException {
        return getPersistence()
                   .findByDateComplete_PrevAndNext(pmlEdmBookDocumentRecordToPK,
            dateComplete, obc);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo> findByDateCreate(
        java.util.Date dateCreate) throws com.liferay.portal.SystemException {
        return getPersistence().findByDateCreate(dateCreate);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo> findByDateCreate(
        java.util.Date dateCreate, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByDateCreate(dateCreate, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo> findByDateCreate(
        java.util.Date dateCreate, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByDateCreate(dateCreate, start, end, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo findByDateCreate_First(
        java.util.Date dateCreate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmBookDocumentRecordToException {
        return getPersistence().findByDateCreate_First(dateCreate, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo findByDateCreate_Last(
        java.util.Date dateCreate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmBookDocumentRecordToException {
        return getPersistence().findByDateCreate_Last(dateCreate, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo[] findByDateCreate_PrevAndNext(
        com.sgs.portlet.document.receipt.service.persistence.PmlEdmBookDocumentRecordToPK pmlEdmBookDocumentRecordToPK,
        java.util.Date dateCreate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmBookDocumentRecordToException {
        return getPersistence()
                   .findByDateCreate_PrevAndNext(pmlEdmBookDocumentRecordToPK,
            dateCreate, obc);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo> findByDocumentReceiptId_DocumentRecordToId(
        long documentReceiptId, long documentRecordToId)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDocumentReceiptId_DocumentRecordToId(documentReceiptId,
            documentRecordToId);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo> findByDocumentReceiptId_DocumentRecordToId(
        long documentReceiptId, long documentRecordToId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDocumentReceiptId_DocumentRecordToId(documentReceiptId,
            documentRecordToId, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo> findByDocumentReceiptId_DocumentRecordToId(
        long documentReceiptId, long documentRecordToId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDocumentReceiptId_DocumentRecordToId(documentReceiptId,
            documentRecordToId, start, end, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo findByDocumentReceiptId_DocumentRecordToId_First(
        long documentReceiptId, long documentRecordToId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmBookDocumentRecordToException {
        return getPersistence()
                   .findByDocumentReceiptId_DocumentRecordToId_First(documentReceiptId,
            documentRecordToId, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo findByDocumentReceiptId_DocumentRecordToId_Last(
        long documentReceiptId, long documentRecordToId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmBookDocumentRecordToException {
        return getPersistence()
                   .findByDocumentReceiptId_DocumentRecordToId_Last(documentReceiptId,
            documentRecordToId, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo[] findByDocumentReceiptId_DocumentRecordToId_PrevAndNext(
        com.sgs.portlet.document.receipt.service.persistence.PmlEdmBookDocumentRecordToPK pmlEdmBookDocumentRecordToPK,
        long documentReceiptId, long documentRecordToId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmBookDocumentRecordToException {
        return getPersistence()
                   .findByDocumentReceiptId_DocumentRecordToId_PrevAndNext(pmlEdmBookDocumentRecordToPK,
            documentReceiptId, documentRecordToId, obc);
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

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end, obc);
    }

    public static void removeByDocumentReceiptId(long documentReceiptId)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByDocumentReceiptId(documentReceiptId);
    }

    public static void removeByDocumentRecordToId(long documentRecordToId)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByDocumentRecordToId(documentRecordToId);
    }

    public static void removeByDateComplete(java.util.Date dateComplete)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByDateComplete(dateComplete);
    }

    public static void removeByDateCreate(java.util.Date dateCreate)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByDateCreate(dateCreate);
    }

    public static void removeByDocumentReceiptId_DocumentRecordToId(
        long documentReceiptId, long documentRecordToId)
        throws com.liferay.portal.SystemException {
        getPersistence()
            .removeByDocumentReceiptId_DocumentRecordToId(documentReceiptId,
            documentRecordToId);
    }

    public static void removeAll() throws com.liferay.portal.SystemException {
        getPersistence().removeAll();
    }

    public static int countByDocumentReceiptId(long documentReceiptId)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByDocumentReceiptId(documentReceiptId);
    }

    public static int countByDocumentRecordToId(long documentRecordToId)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByDocumentRecordToId(documentRecordToId);
    }

    public static int countByDateComplete(java.util.Date dateComplete)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByDateComplete(dateComplete);
    }

    public static int countByDateCreate(java.util.Date dateCreate)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByDateCreate(dateCreate);
    }

    public static int countByDocumentReceiptId_DocumentRecordToId(
        long documentReceiptId, long documentRecordToId)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .countByDocumentReceiptId_DocumentRecordToId(documentReceiptId,
            documentRecordToId);
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

    public static PmlEdmBookDocumentRecordToPersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(
        PmlEdmBookDocumentRecordToPersistence persistence) {
        _persistence = persistence;
    }
}
