package com.sgs.portlet.document.receipt.service.persistence;

public interface PmlEdmDocumentTypePersistence {
    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentType create(
        long documentTypeId);

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentType remove(
        long documentTypeId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentTypeException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentType remove(
        com.sgs.portlet.document.receipt.model.PmlEdmDocumentType pmlEdmDocumentType)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(PmlEdmDocumentType pmlEdmDocumentType, boolean merge)</code>.
     */
    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentType update(
        com.sgs.portlet.document.receipt.model.PmlEdmDocumentType pmlEdmDocumentType)
        throws com.liferay.portal.SystemException;

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
    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentType update(
        com.sgs.portlet.document.receipt.model.PmlEdmDocumentType pmlEdmDocumentType,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentType updateImpl(
        com.sgs.portlet.document.receipt.model.PmlEdmDocumentType pmlEdmDocumentType,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentType findByPrimaryKey(
        long documentTypeId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentTypeException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentType fetchByPrimaryKey(
        long documentTypeId) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentType> findByDocumentTypeName(
        java.lang.String documentTypeName)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentType> findByDocumentTypeName(
        java.lang.String documentTypeName, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentType> findByDocumentTypeName(
        java.lang.String documentTypeName, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentType findByDocumentTypeName_First(
        java.lang.String documentTypeName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentTypeException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentType findByDocumentTypeName_Last(
        java.lang.String documentTypeName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentTypeException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentType[] findByDocumentTypeName_PrevAndNext(
        long documentTypeId, java.lang.String documentTypeName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentTypeException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentType> findByDocumentSymbol(
        java.lang.String documentSymbol)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentType> findByDocumentSymbol(
        java.lang.String documentSymbol, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentType> findByDocumentSymbol(
        java.lang.String documentSymbol, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentType findByDocumentSymbol_First(
        java.lang.String documentSymbol,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentTypeException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentType findByDocumentSymbol_Last(
        java.lang.String documentSymbol,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentTypeException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentType[] findByDocumentSymbol_PrevAndNext(
        long documentTypeId, java.lang.String documentSymbol,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentTypeException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentType> findByDocumentRecordTypeId(
        int documentRecordTypeId) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentType> findByDocumentRecordTypeId(
        int documentRecordTypeId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentType> findByDocumentRecordTypeId(
        int documentRecordTypeId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentType findByDocumentRecordTypeId_First(
        int documentRecordTypeId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentTypeException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentType findByDocumentRecordTypeId_Last(
        int documentRecordTypeId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentTypeException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentType[] findByDocumentRecordTypeId_PrevAndNext(
        long documentTypeId, int documentRecordTypeId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentTypeException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentType> findBySendReceiptDistinction(
        int sendReceiptDistinction) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentType> findBySendReceiptDistinction(
        int sendReceiptDistinction, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentType> findBySendReceiptDistinction(
        int sendReceiptDistinction, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentType findBySendReceiptDistinction_First(
        int sendReceiptDistinction,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentTypeException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentType findBySendReceiptDistinction_Last(
        int sendReceiptDistinction,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentTypeException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentType[] findBySendReceiptDistinction_PrevAndNext(
        long documentTypeId, int sendReceiptDistinction,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentTypeException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentType> findByHaveDepartExtends(
        boolean HaveDepartExtends) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentType> findByHaveDepartExtends(
        boolean HaveDepartExtends, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentType> findByHaveDepartExtends(
        boolean HaveDepartExtends, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentType findByHaveDepartExtends_First(
        boolean HaveDepartExtends,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentTypeException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentType findByHaveDepartExtends_Last(
        boolean HaveDepartExtends,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentTypeException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentType[] findByHaveDepartExtends_PrevAndNext(
        long documentTypeId, boolean HaveDepartExtends,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentTypeException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentType> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentType> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentType> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeByDocumentTypeName(java.lang.String documentTypeName)
        throws com.liferay.portal.SystemException;

    public void removeByDocumentSymbol(java.lang.String documentSymbol)
        throws com.liferay.portal.SystemException;

    public void removeByDocumentRecordTypeId(int documentRecordTypeId)
        throws com.liferay.portal.SystemException;

    public void removeBySendReceiptDistinction(int sendReceiptDistinction)
        throws com.liferay.portal.SystemException;

    public void removeByHaveDepartExtends(boolean HaveDepartExtends)
        throws com.liferay.portal.SystemException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countByDocumentTypeName(java.lang.String documentTypeName)
        throws com.liferay.portal.SystemException;

    public int countByDocumentSymbol(java.lang.String documentSymbol)
        throws com.liferay.portal.SystemException;

    public int countByDocumentRecordTypeId(int documentRecordTypeId)
        throws com.liferay.portal.SystemException;

    public int countBySendReceiptDistinction(int sendReceiptDistinction)
        throws com.liferay.portal.SystemException;

    public int countByHaveDepartExtends(boolean HaveDepartExtends)
        throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;

    public void registerListener(
        com.liferay.portal.model.ModelListener listener);

    public void unregisterListener(
        com.liferay.portal.model.ModelListener listener);
}
