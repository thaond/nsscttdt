package com.sgs.portlet.document.receipt.service.persistence;

public interface PmlEdmBookDocumentRecordToPersistence {
    public com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo create(
        com.sgs.portlet.document.receipt.service.persistence.PmlEdmBookDocumentRecordToPK pmlEdmBookDocumentRecordToPK);

    public com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo remove(
        com.sgs.portlet.document.receipt.service.persistence.PmlEdmBookDocumentRecordToPK pmlEdmBookDocumentRecordToPK)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmBookDocumentRecordToException;

    public com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo remove(
        com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo pmlEdmBookDocumentRecordTo)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(PmlEdmBookDocumentRecordTo pmlEdmBookDocumentRecordTo, boolean merge)</code>.
     */
    public com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo update(
        com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo pmlEdmBookDocumentRecordTo)
        throws com.liferay.portal.SystemException;

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
    public com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo update(
        com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo pmlEdmBookDocumentRecordTo,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo updateImpl(
        com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo pmlEdmBookDocumentRecordTo,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo findByPrimaryKey(
        com.sgs.portlet.document.receipt.service.persistence.PmlEdmBookDocumentRecordToPK pmlEdmBookDocumentRecordToPK)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmBookDocumentRecordToException;

    public com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo fetchByPrimaryKey(
        com.sgs.portlet.document.receipt.service.persistence.PmlEdmBookDocumentRecordToPK pmlEdmBookDocumentRecordToPK)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo> findByDocumentReceiptId(
        long documentReceiptId) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo> findByDocumentReceiptId(
        long documentReceiptId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo> findByDocumentReceiptId(
        long documentReceiptId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo findByDocumentReceiptId_First(
        long documentReceiptId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmBookDocumentRecordToException;

    public com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo findByDocumentReceiptId_Last(
        long documentReceiptId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmBookDocumentRecordToException;

    public com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo[] findByDocumentReceiptId_PrevAndNext(
        com.sgs.portlet.document.receipt.service.persistence.PmlEdmBookDocumentRecordToPK pmlEdmBookDocumentRecordToPK,
        long documentReceiptId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmBookDocumentRecordToException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo> findByDocumentRecordToId(
        long documentRecordToId) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo> findByDocumentRecordToId(
        long documentRecordToId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo> findByDocumentRecordToId(
        long documentRecordToId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo findByDocumentRecordToId_First(
        long documentRecordToId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmBookDocumentRecordToException;

    public com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo findByDocumentRecordToId_Last(
        long documentRecordToId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmBookDocumentRecordToException;

    public com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo[] findByDocumentRecordToId_PrevAndNext(
        com.sgs.portlet.document.receipt.service.persistence.PmlEdmBookDocumentRecordToPK pmlEdmBookDocumentRecordToPK,
        long documentRecordToId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmBookDocumentRecordToException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo> findByDateComplete(
        java.util.Date dateComplete) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo> findByDateComplete(
        java.util.Date dateComplete, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo> findByDateComplete(
        java.util.Date dateComplete, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo findByDateComplete_First(
        java.util.Date dateComplete,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmBookDocumentRecordToException;

    public com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo findByDateComplete_Last(
        java.util.Date dateComplete,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmBookDocumentRecordToException;

    public com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo[] findByDateComplete_PrevAndNext(
        com.sgs.portlet.document.receipt.service.persistence.PmlEdmBookDocumentRecordToPK pmlEdmBookDocumentRecordToPK,
        java.util.Date dateComplete,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmBookDocumentRecordToException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo> findByDateCreate(
        java.util.Date dateCreate) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo> findByDateCreate(
        java.util.Date dateCreate, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo> findByDateCreate(
        java.util.Date dateCreate, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo findByDateCreate_First(
        java.util.Date dateCreate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmBookDocumentRecordToException;

    public com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo findByDateCreate_Last(
        java.util.Date dateCreate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmBookDocumentRecordToException;

    public com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo[] findByDateCreate_PrevAndNext(
        com.sgs.portlet.document.receipt.service.persistence.PmlEdmBookDocumentRecordToPK pmlEdmBookDocumentRecordToPK,
        java.util.Date dateCreate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmBookDocumentRecordToException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo> findByDocumentReceiptId_DocumentRecordToId(
        long documentReceiptId, long documentRecordToId)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo> findByDocumentReceiptId_DocumentRecordToId(
        long documentReceiptId, long documentRecordToId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo> findByDocumentReceiptId_DocumentRecordToId(
        long documentReceiptId, long documentRecordToId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo findByDocumentReceiptId_DocumentRecordToId_First(
        long documentReceiptId, long documentRecordToId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmBookDocumentRecordToException;

    public com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo findByDocumentReceiptId_DocumentRecordToId_Last(
        long documentReceiptId, long documentRecordToId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmBookDocumentRecordToException;

    public com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo[] findByDocumentReceiptId_DocumentRecordToId_PrevAndNext(
        com.sgs.portlet.document.receipt.service.persistence.PmlEdmBookDocumentRecordToPK pmlEdmBookDocumentRecordToPK,
        long documentReceiptId, long documentRecordToId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmBookDocumentRecordToException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeByDocumentReceiptId(long documentReceiptId)
        throws com.liferay.portal.SystemException;

    public void removeByDocumentRecordToId(long documentRecordToId)
        throws com.liferay.portal.SystemException;

    public void removeByDateComplete(java.util.Date dateComplete)
        throws com.liferay.portal.SystemException;

    public void removeByDateCreate(java.util.Date dateCreate)
        throws com.liferay.portal.SystemException;

    public void removeByDocumentReceiptId_DocumentRecordToId(
        long documentReceiptId, long documentRecordToId)
        throws com.liferay.portal.SystemException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countByDocumentReceiptId(long documentReceiptId)
        throws com.liferay.portal.SystemException;

    public int countByDocumentRecordToId(long documentRecordToId)
        throws com.liferay.portal.SystemException;

    public int countByDateComplete(java.util.Date dateComplete)
        throws com.liferay.portal.SystemException;

    public int countByDateCreate(java.util.Date dateCreate)
        throws com.liferay.portal.SystemException;

    public int countByDocumentReceiptId_DocumentRecordToId(
        long documentReceiptId, long documentRecordToId)
        throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;

    public void registerListener(
        com.liferay.portal.model.ModelListener listener);

    public void unregisterListener(
        com.liferay.portal.model.ModelListener listener);
}
