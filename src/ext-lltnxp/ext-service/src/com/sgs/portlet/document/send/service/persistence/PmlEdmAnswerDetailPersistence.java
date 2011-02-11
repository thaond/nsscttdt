package com.sgs.portlet.document.send.service.persistence;

public interface PmlEdmAnswerDetailPersistence {
    public com.sgs.portlet.document.send.model.PmlEdmAnswerDetail create(
        long documentReceiptId);

    public com.sgs.portlet.document.send.model.PmlEdmAnswerDetail remove(
        long documentReceiptId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmAnswerDetailException;

    public com.sgs.portlet.document.send.model.PmlEdmAnswerDetail remove(
        com.sgs.portlet.document.send.model.PmlEdmAnswerDetail pmlEdmAnswerDetail)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(PmlEdmAnswerDetail pmlEdmAnswerDetail, boolean merge)</code>.
     */
    public com.sgs.portlet.document.send.model.PmlEdmAnswerDetail update(
        com.sgs.portlet.document.send.model.PmlEdmAnswerDetail pmlEdmAnswerDetail)
        throws com.liferay.portal.SystemException;

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlEdmAnswerDetail the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlEdmAnswerDetail is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public com.sgs.portlet.document.send.model.PmlEdmAnswerDetail update(
        com.sgs.portlet.document.send.model.PmlEdmAnswerDetail pmlEdmAnswerDetail,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.send.model.PmlEdmAnswerDetail updateImpl(
        com.sgs.portlet.document.send.model.PmlEdmAnswerDetail pmlEdmAnswerDetail,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.send.model.PmlEdmAnswerDetail findByPrimaryKey(
        long documentReceiptId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmAnswerDetailException;

    public com.sgs.portlet.document.send.model.PmlEdmAnswerDetail fetchByPrimaryKey(
        long documentReceiptId) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmAnswerDetail> findByDocumentSendId(
        long documentSendId) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmAnswerDetail> findByDocumentSendId(
        long documentSendId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmAnswerDetail> findByDocumentSendId(
        long documentSendId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.send.model.PmlEdmAnswerDetail findByDocumentSendId_First(
        long documentSendId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmAnswerDetailException;

    public com.sgs.portlet.document.send.model.PmlEdmAnswerDetail findByDocumentSendId_Last(
        long documentSendId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmAnswerDetailException;

    public com.sgs.portlet.document.send.model.PmlEdmAnswerDetail[] findByDocumentSendId_PrevAndNext(
        long documentReceiptId, long documentSendId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmAnswerDetailException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmAnswerDetail> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmAnswerDetail> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmAnswerDetail> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeByDocumentSendId(long documentSendId)
        throws com.liferay.portal.SystemException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countByDocumentSendId(long documentSendId)
        throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;

    public void registerListener(
        com.liferay.portal.model.ModelListener listener);

    public void unregisterListener(
        com.liferay.portal.model.ModelListener listener);
}
