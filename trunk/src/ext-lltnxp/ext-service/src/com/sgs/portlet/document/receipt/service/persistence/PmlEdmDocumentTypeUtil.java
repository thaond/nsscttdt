package com.sgs.portlet.document.receipt.service.persistence;

public class PmlEdmDocumentTypeUtil {
    private static PmlEdmDocumentTypePersistence _persistence;

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentType create(
        long documentTypeId) {
        return getPersistence().create(documentTypeId);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentType remove(
        long documentTypeId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentTypeException {
        return getPersistence().remove(documentTypeId);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentType remove(
        com.sgs.portlet.document.receipt.model.PmlEdmDocumentType pmlEdmDocumentType)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(pmlEdmDocumentType);
    }

    /**
     * @deprecated Use <code>update(PmlEdmDocumentType pmlEdmDocumentType, boolean merge)</code>.
     */
    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentType update(
        com.sgs.portlet.document.receipt.model.PmlEdmDocumentType pmlEdmDocumentType)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(pmlEdmDocumentType);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlEdmDocumentType the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlEdmDocumentType is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentType update(
        com.sgs.portlet.document.receipt.model.PmlEdmDocumentType pmlEdmDocumentType,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().update(pmlEdmDocumentType, merge);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentType updateImpl(
        com.sgs.portlet.document.receipt.model.PmlEdmDocumentType pmlEdmDocumentType,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(pmlEdmDocumentType, merge);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentType findByPrimaryKey(
        long documentTypeId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentTypeException {
        return getPersistence().findByPrimaryKey(documentTypeId);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentType fetchByPrimaryKey(
        long documentTypeId) throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(documentTypeId);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentType> findByDocumentTypeName(
        java.lang.String documentTypeName)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByDocumentTypeName(documentTypeName);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentType> findByDocumentTypeName(
        java.lang.String documentTypeName, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDocumentTypeName(documentTypeName, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentType> findByDocumentTypeName(
        java.lang.String documentTypeName, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDocumentTypeName(documentTypeName, start, end, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentType findByDocumentTypeName_First(
        java.lang.String documentTypeName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentTypeException {
        return getPersistence()
                   .findByDocumentTypeName_First(documentTypeName, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentType findByDocumentTypeName_Last(
        java.lang.String documentTypeName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentTypeException {
        return getPersistence()
                   .findByDocumentTypeName_Last(documentTypeName, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentType[] findByDocumentTypeName_PrevAndNext(
        long documentTypeId, java.lang.String documentTypeName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentTypeException {
        return getPersistence()
                   .findByDocumentTypeName_PrevAndNext(documentTypeId,
            documentTypeName, obc);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentType> findByDocumentSymbol(
        java.lang.String documentSymbol)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByDocumentSymbol(documentSymbol);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentType> findByDocumentSymbol(
        java.lang.String documentSymbol, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByDocumentSymbol(documentSymbol, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentType> findByDocumentSymbol(
        java.lang.String documentSymbol, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDocumentSymbol(documentSymbol, start, end, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentType findByDocumentSymbol_First(
        java.lang.String documentSymbol,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentTypeException {
        return getPersistence().findByDocumentSymbol_First(documentSymbol, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentType findByDocumentSymbol_Last(
        java.lang.String documentSymbol,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentTypeException {
        return getPersistence().findByDocumentSymbol_Last(documentSymbol, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentType[] findByDocumentSymbol_PrevAndNext(
        long documentTypeId, java.lang.String documentSymbol,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentTypeException {
        return getPersistence()
                   .findByDocumentSymbol_PrevAndNext(documentTypeId,
            documentSymbol, obc);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentType> findByDocumentRecordTypeId(
        int documentRecordTypeId) throws com.liferay.portal.SystemException {
        return getPersistence().findByDocumentRecordTypeId(documentRecordTypeId);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentType> findByDocumentRecordTypeId(
        int documentRecordTypeId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDocumentRecordTypeId(documentRecordTypeId, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentType> findByDocumentRecordTypeId(
        int documentRecordTypeId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDocumentRecordTypeId(documentRecordTypeId, start,
            end, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentType findByDocumentRecordTypeId_First(
        int documentRecordTypeId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentTypeException {
        return getPersistence()
                   .findByDocumentRecordTypeId_First(documentRecordTypeId, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentType findByDocumentRecordTypeId_Last(
        int documentRecordTypeId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentTypeException {
        return getPersistence()
                   .findByDocumentRecordTypeId_Last(documentRecordTypeId, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentType[] findByDocumentRecordTypeId_PrevAndNext(
        long documentTypeId, int documentRecordTypeId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentTypeException {
        return getPersistence()
                   .findByDocumentRecordTypeId_PrevAndNext(documentTypeId,
            documentRecordTypeId, obc);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentType> findBySendReceiptDistinction(
        int sendReceiptDistinction) throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findBySendReceiptDistinction(sendReceiptDistinction);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentType> findBySendReceiptDistinction(
        int sendReceiptDistinction, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findBySendReceiptDistinction(sendReceiptDistinction, start,
            end);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentType> findBySendReceiptDistinction(
        int sendReceiptDistinction, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findBySendReceiptDistinction(sendReceiptDistinction, start,
            end, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentType findBySendReceiptDistinction_First(
        int sendReceiptDistinction,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentTypeException {
        return getPersistence()
                   .findBySendReceiptDistinction_First(sendReceiptDistinction,
            obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentType findBySendReceiptDistinction_Last(
        int sendReceiptDistinction,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentTypeException {
        return getPersistence()
                   .findBySendReceiptDistinction_Last(sendReceiptDistinction,
            obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentType[] findBySendReceiptDistinction_PrevAndNext(
        long documentTypeId, int sendReceiptDistinction,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentTypeException {
        return getPersistence()
                   .findBySendReceiptDistinction_PrevAndNext(documentTypeId,
            sendReceiptDistinction, obc);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentType> findByHaveDepartExtends(
        boolean HaveDepartExtends) throws com.liferay.portal.SystemException {
        return getPersistence().findByHaveDepartExtends(HaveDepartExtends);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentType> findByHaveDepartExtends(
        boolean HaveDepartExtends, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByHaveDepartExtends(HaveDepartExtends, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentType> findByHaveDepartExtends(
        boolean HaveDepartExtends, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByHaveDepartExtends(HaveDepartExtends, start, end, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentType findByHaveDepartExtends_First(
        boolean HaveDepartExtends,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentTypeException {
        return getPersistence()
                   .findByHaveDepartExtends_First(HaveDepartExtends, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentType findByHaveDepartExtends_Last(
        boolean HaveDepartExtends,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentTypeException {
        return getPersistence()
                   .findByHaveDepartExtends_Last(HaveDepartExtends, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentType[] findByHaveDepartExtends_PrevAndNext(
        long documentTypeId, boolean HaveDepartExtends,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentTypeException {
        return getPersistence()
                   .findByHaveDepartExtends_PrevAndNext(documentTypeId,
            HaveDepartExtends, obc);
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

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentType> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentType> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentType> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end, obc);
    }

    public static void removeByDocumentTypeName(
        java.lang.String documentTypeName)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByDocumentTypeName(documentTypeName);
    }

    public static void removeByDocumentSymbol(java.lang.String documentSymbol)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByDocumentSymbol(documentSymbol);
    }

    public static void removeByDocumentRecordTypeId(int documentRecordTypeId)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByDocumentRecordTypeId(documentRecordTypeId);
    }

    public static void removeBySendReceiptDistinction(
        int sendReceiptDistinction) throws com.liferay.portal.SystemException {
        getPersistence().removeBySendReceiptDistinction(sendReceiptDistinction);
    }

    public static void removeByHaveDepartExtends(boolean HaveDepartExtends)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByHaveDepartExtends(HaveDepartExtends);
    }

    public static void removeAll() throws com.liferay.portal.SystemException {
        getPersistence().removeAll();
    }

    public static int countByDocumentTypeName(java.lang.String documentTypeName)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByDocumentTypeName(documentTypeName);
    }

    public static int countByDocumentSymbol(java.lang.String documentSymbol)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByDocumentSymbol(documentSymbol);
    }

    public static int countByDocumentRecordTypeId(int documentRecordTypeId)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByDocumentRecordTypeId(documentRecordTypeId);
    }

    public static int countBySendReceiptDistinction(int sendReceiptDistinction)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .countBySendReceiptDistinction(sendReceiptDistinction);
    }

    public static int countByHaveDepartExtends(boolean HaveDepartExtends)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByHaveDepartExtends(HaveDepartExtends);
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

    public static PmlEdmDocumentTypePersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(PmlEdmDocumentTypePersistence persistence) {
        _persistence = persistence;
    }
}
