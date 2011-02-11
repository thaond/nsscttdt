package com.sgs.portlet.document.service.persistence;

public interface PmlEdmDocumentRelationPersistence {
    public com.sgs.portlet.document.model.PmlEdmDocumentRelation create(
        long documentRelationId);

    public com.sgs.portlet.document.model.PmlEdmDocumentRelation remove(
        long documentRelationId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlEdmDocumentRelationException;

    public com.sgs.portlet.document.model.PmlEdmDocumentRelation remove(
        com.sgs.portlet.document.model.PmlEdmDocumentRelation pmlEdmDocumentRelation)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(PmlEdmDocumentRelation pmlEdmDocumentRelation, boolean merge)</code>.
     */
    public com.sgs.portlet.document.model.PmlEdmDocumentRelation update(
        com.sgs.portlet.document.model.PmlEdmDocumentRelation pmlEdmDocumentRelation)
        throws com.liferay.portal.SystemException;

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlEdmDocumentRelation the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlEdmDocumentRelation is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public com.sgs.portlet.document.model.PmlEdmDocumentRelation update(
        com.sgs.portlet.document.model.PmlEdmDocumentRelation pmlEdmDocumentRelation,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlEdmDocumentRelation updateImpl(
        com.sgs.portlet.document.model.PmlEdmDocumentRelation pmlEdmDocumentRelation,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlEdmDocumentRelation findByPrimaryKey(
        long documentRelationId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlEdmDocumentRelationException;

    public com.sgs.portlet.document.model.PmlEdmDocumentRelation fetchByPrimaryKey(
        long documentRelationId) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlEdmDocumentRelation> findByDocLeftId_LeftIsReceipt(
        long docLeftId, boolean leftIsReceipt)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlEdmDocumentRelation> findByDocLeftId_LeftIsReceipt(
        long docLeftId, boolean leftIsReceipt, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlEdmDocumentRelation> findByDocLeftId_LeftIsReceipt(
        long docLeftId, boolean leftIsReceipt, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlEdmDocumentRelation findByDocLeftId_LeftIsReceipt_First(
        long docLeftId, boolean leftIsReceipt,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlEdmDocumentRelationException;

    public com.sgs.portlet.document.model.PmlEdmDocumentRelation findByDocLeftId_LeftIsReceipt_Last(
        long docLeftId, boolean leftIsReceipt,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlEdmDocumentRelationException;

    public com.sgs.portlet.document.model.PmlEdmDocumentRelation[] findByDocLeftId_LeftIsReceipt_PrevAndNext(
        long documentRelationId, long docLeftId, boolean leftIsReceipt,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlEdmDocumentRelationException;

    public java.util.List<com.sgs.portlet.document.model.PmlEdmDocumentRelation> findByDocRightId_RightIsReceipt(
        long docRightId, boolean rightIsReceipt)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlEdmDocumentRelation> findByDocRightId_RightIsReceipt(
        long docRightId, boolean rightIsReceipt, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlEdmDocumentRelation> findByDocRightId_RightIsReceipt(
        long docRightId, boolean rightIsReceipt, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlEdmDocumentRelation findByDocRightId_RightIsReceipt_First(
        long docRightId, boolean rightIsReceipt,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlEdmDocumentRelationException;

    public com.sgs.portlet.document.model.PmlEdmDocumentRelation findByDocRightId_RightIsReceipt_Last(
        long docRightId, boolean rightIsReceipt,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlEdmDocumentRelationException;

    public com.sgs.portlet.document.model.PmlEdmDocumentRelation[] findByDocRightId_RightIsReceipt_PrevAndNext(
        long documentRelationId, long docRightId, boolean rightIsReceipt,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlEdmDocumentRelationException;

    public com.sgs.portlet.document.model.PmlEdmDocumentRelation findByDocLeftId_DocRightId_LeftIsReceipt_RightIsReceipt(
        long docLeftId, long docRightId, boolean leftIsReceipt,
        boolean rightIsReceipt)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlEdmDocumentRelationException;

    public com.sgs.portlet.document.model.PmlEdmDocumentRelation fetchByDocLeftId_DocRightId_LeftIsReceipt_RightIsReceipt(
        long docLeftId, long docRightId, boolean leftIsReceipt,
        boolean rightIsReceipt) throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlEdmDocumentRelation> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlEdmDocumentRelation> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlEdmDocumentRelation> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeByDocLeftId_LeftIsReceipt(long docLeftId,
        boolean leftIsReceipt) throws com.liferay.portal.SystemException;

    public void removeByDocRightId_RightIsReceipt(long docRightId,
        boolean rightIsReceipt) throws com.liferay.portal.SystemException;

    public void removeByDocLeftId_DocRightId_LeftIsReceipt_RightIsReceipt(
        long docLeftId, long docRightId, boolean leftIsReceipt,
        boolean rightIsReceipt)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlEdmDocumentRelationException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countByDocLeftId_LeftIsReceipt(long docLeftId,
        boolean leftIsReceipt) throws com.liferay.portal.SystemException;

    public int countByDocRightId_RightIsReceipt(long docRightId,
        boolean rightIsReceipt) throws com.liferay.portal.SystemException;

    public int countByDocLeftId_DocRightId_LeftIsReceipt_RightIsReceipt(
        long docLeftId, long docRightId, boolean leftIsReceipt,
        boolean rightIsReceipt) throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;

    public void registerListener(
        com.liferay.portal.model.ModelListener listener);

    public void unregisterListener(
        com.liferay.portal.model.ModelListener listener);
}
