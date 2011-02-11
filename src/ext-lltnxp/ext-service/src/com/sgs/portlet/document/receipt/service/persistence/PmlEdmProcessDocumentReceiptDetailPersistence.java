package com.sgs.portlet.document.receipt.service.persistence;

public interface PmlEdmProcessDocumentReceiptDetailPersistence {
    public com.sgs.portlet.document.receipt.model.PmlEdmProcessDocumentReceiptDetail create(
        long id);

    public com.sgs.portlet.document.receipt.model.PmlEdmProcessDocumentReceiptDetail remove(
        long id)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmProcessDocumentReceiptDetailException;

    public com.sgs.portlet.document.receipt.model.PmlEdmProcessDocumentReceiptDetail remove(
        com.sgs.portlet.document.receipt.model.PmlEdmProcessDocumentReceiptDetail pmlEdmProcessDocumentReceiptDetail)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(PmlEdmProcessDocumentReceiptDetail pmlEdmProcessDocumentReceiptDetail, boolean merge)</code>.
     */
    public com.sgs.portlet.document.receipt.model.PmlEdmProcessDocumentReceiptDetail update(
        com.sgs.portlet.document.receipt.model.PmlEdmProcessDocumentReceiptDetail pmlEdmProcessDocumentReceiptDetail)
        throws com.liferay.portal.SystemException;

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlEdmProcessDocumentReceiptDetail the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlEdmProcessDocumentReceiptDetail is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public com.sgs.portlet.document.receipt.model.PmlEdmProcessDocumentReceiptDetail update(
        com.sgs.portlet.document.receipt.model.PmlEdmProcessDocumentReceiptDetail pmlEdmProcessDocumentReceiptDetail,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.receipt.model.PmlEdmProcessDocumentReceiptDetail updateImpl(
        com.sgs.portlet.document.receipt.model.PmlEdmProcessDocumentReceiptDetail pmlEdmProcessDocumentReceiptDetail,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.receipt.model.PmlEdmProcessDocumentReceiptDetail findByPrimaryKey(
        long id)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmProcessDocumentReceiptDetailException;

    public com.sgs.portlet.document.receipt.model.PmlEdmProcessDocumentReceiptDetail fetchByPrimaryKey(
        long id) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmProcessDocumentReceiptDetail> findByDocumentReceiptId(
        long documentReceiptId) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmProcessDocumentReceiptDetail> findByDocumentReceiptId(
        long documentReceiptId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmProcessDocumentReceiptDetail> findByDocumentReceiptId(
        long documentReceiptId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.receipt.model.PmlEdmProcessDocumentReceiptDetail findByDocumentReceiptId_First(
        long documentReceiptId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmProcessDocumentReceiptDetailException;

    public com.sgs.portlet.document.receipt.model.PmlEdmProcessDocumentReceiptDetail findByDocumentReceiptId_Last(
        long documentReceiptId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmProcessDocumentReceiptDetailException;

    public com.sgs.portlet.document.receipt.model.PmlEdmProcessDocumentReceiptDetail[] findByDocumentReceiptId_PrevAndNext(
        long id, long documentReceiptId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmProcessDocumentReceiptDetailException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmProcessDocumentReceiptDetail> findByUserId(
        long userId) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmProcessDocumentReceiptDetail> findByUserId(
        long userId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmProcessDocumentReceiptDetail> findByUserId(
        long userId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.receipt.model.PmlEdmProcessDocumentReceiptDetail findByUserId_First(
        long userId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmProcessDocumentReceiptDetailException;

    public com.sgs.portlet.document.receipt.model.PmlEdmProcessDocumentReceiptDetail findByUserId_Last(
        long userId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmProcessDocumentReceiptDetailException;

    public com.sgs.portlet.document.receipt.model.PmlEdmProcessDocumentReceiptDetail[] findByUserId_PrevAndNext(
        long id, long userId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmProcessDocumentReceiptDetailException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmProcessDocumentReceiptDetail> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmProcessDocumentReceiptDetail> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmProcessDocumentReceiptDetail> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeByDocumentReceiptId(long documentReceiptId)
        throws com.liferay.portal.SystemException;

    public void removeByUserId(long userId)
        throws com.liferay.portal.SystemException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countByDocumentReceiptId(long documentReceiptId)
        throws com.liferay.portal.SystemException;

    public int countByUserId(long userId)
        throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;

    public void registerListener(
        com.liferay.portal.model.ModelListener listener);

    public void unregisterListener(
        com.liferay.portal.model.ModelListener listener);
}
