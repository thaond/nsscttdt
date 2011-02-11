package com.sgs.portlet.document.receipt.service.persistence;

public interface PmlEdmDocumentReceiptProcessTypePersistence {
    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptProcessType create(
        long docReceiptProcessTypeId);

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptProcessType remove(
        long docReceiptProcessTypeId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptProcessTypeException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptProcessType remove(
        com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptProcessType pmlEdmDocumentReceiptProcessType)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(PmlEdmDocumentReceiptProcessType pmlEdmDocumentReceiptProcessType, boolean merge)</code>.
     */
    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptProcessType update(
        com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptProcessType pmlEdmDocumentReceiptProcessType)
        throws com.liferay.portal.SystemException;

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlEdmDocumentReceiptProcessType the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlEdmDocumentReceiptProcessType is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptProcessType update(
        com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptProcessType pmlEdmDocumentReceiptProcessType,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptProcessType updateImpl(
        com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptProcessType pmlEdmDocumentReceiptProcessType,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptProcessType findByPrimaryKey(
        long docReceiptProcessTypeId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptProcessTypeException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptProcessType fetchByPrimaryKey(
        long docReceiptProcessTypeId) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptProcessType> findByDocumentReceiptId(
        long documentReceiptId) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptProcessType> findByDocumentReceiptId(
        long documentReceiptId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptProcessType> findByDocumentReceiptId(
        long documentReceiptId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptProcessType findByDocumentReceiptId_First(
        long documentReceiptId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptProcessTypeException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptProcessType findByDocumentReceiptId_Last(
        long documentReceiptId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptProcessTypeException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptProcessType[] findByDocumentReceiptId_PrevAndNext(
        long docReceiptProcessTypeId, long documentReceiptId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptProcessTypeException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptProcessType> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptProcessType> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptProcessType> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeByDocumentReceiptId(long documentReceiptId)
        throws com.liferay.portal.SystemException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countByDocumentReceiptId(long documentReceiptId)
        throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;

    public void registerListener(
        com.liferay.portal.model.ModelListener listener);

    public void unregisterListener(
        com.liferay.portal.model.ModelListener listener);
}
