package com.sgs.portlet.document.service.persistence;

public class PmlEdmDocumentRelationUtil {
    private static PmlEdmDocumentRelationPersistence _persistence;

    public static com.sgs.portlet.document.model.PmlEdmDocumentRelation create(
        long documentRelationId) {
        return getPersistence().create(documentRelationId);
    }

    public static com.sgs.portlet.document.model.PmlEdmDocumentRelation remove(
        long documentRelationId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlEdmDocumentRelationException {
        return getPersistence().remove(documentRelationId);
    }

    public static com.sgs.portlet.document.model.PmlEdmDocumentRelation remove(
        com.sgs.portlet.document.model.PmlEdmDocumentRelation pmlEdmDocumentRelation)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(pmlEdmDocumentRelation);
    }

    /**
     * @deprecated Use <code>update(PmlEdmDocumentRelation pmlEdmDocumentRelation, boolean merge)</code>.
     */
    public static com.sgs.portlet.document.model.PmlEdmDocumentRelation update(
        com.sgs.portlet.document.model.PmlEdmDocumentRelation pmlEdmDocumentRelation)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(pmlEdmDocumentRelation);
    }

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
    public static com.sgs.portlet.document.model.PmlEdmDocumentRelation update(
        com.sgs.portlet.document.model.PmlEdmDocumentRelation pmlEdmDocumentRelation,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().update(pmlEdmDocumentRelation, merge);
    }

    public static com.sgs.portlet.document.model.PmlEdmDocumentRelation updateImpl(
        com.sgs.portlet.document.model.PmlEdmDocumentRelation pmlEdmDocumentRelation,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(pmlEdmDocumentRelation, merge);
    }

    public static com.sgs.portlet.document.model.PmlEdmDocumentRelation findByPrimaryKey(
        long documentRelationId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlEdmDocumentRelationException {
        return getPersistence().findByPrimaryKey(documentRelationId);
    }

    public static com.sgs.portlet.document.model.PmlEdmDocumentRelation fetchByPrimaryKey(
        long documentRelationId) throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(documentRelationId);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlEdmDocumentRelation> findByDocLeftId_LeftIsReceipt(
        long docLeftId, boolean leftIsReceipt)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDocLeftId_LeftIsReceipt(docLeftId, leftIsReceipt);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlEdmDocumentRelation> findByDocLeftId_LeftIsReceipt(
        long docLeftId, boolean leftIsReceipt, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDocLeftId_LeftIsReceipt(docLeftId, leftIsReceipt,
            start, end);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlEdmDocumentRelation> findByDocLeftId_LeftIsReceipt(
        long docLeftId, boolean leftIsReceipt, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDocLeftId_LeftIsReceipt(docLeftId, leftIsReceipt,
            start, end, obc);
    }

    public static com.sgs.portlet.document.model.PmlEdmDocumentRelation findByDocLeftId_LeftIsReceipt_First(
        long docLeftId, boolean leftIsReceipt,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlEdmDocumentRelationException {
        return getPersistence()
                   .findByDocLeftId_LeftIsReceipt_First(docLeftId,
            leftIsReceipt, obc);
    }

    public static com.sgs.portlet.document.model.PmlEdmDocumentRelation findByDocLeftId_LeftIsReceipt_Last(
        long docLeftId, boolean leftIsReceipt,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlEdmDocumentRelationException {
        return getPersistence()
                   .findByDocLeftId_LeftIsReceipt_Last(docLeftId,
            leftIsReceipt, obc);
    }

    public static com.sgs.portlet.document.model.PmlEdmDocumentRelation[] findByDocLeftId_LeftIsReceipt_PrevAndNext(
        long documentRelationId, long docLeftId, boolean leftIsReceipt,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlEdmDocumentRelationException {
        return getPersistence()
                   .findByDocLeftId_LeftIsReceipt_PrevAndNext(documentRelationId,
            docLeftId, leftIsReceipt, obc);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlEdmDocumentRelation> findByDocRightId_RightIsReceipt(
        long docRightId, boolean rightIsReceipt)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDocRightId_RightIsReceipt(docRightId, rightIsReceipt);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlEdmDocumentRelation> findByDocRightId_RightIsReceipt(
        long docRightId, boolean rightIsReceipt, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDocRightId_RightIsReceipt(docRightId, rightIsReceipt,
            start, end);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlEdmDocumentRelation> findByDocRightId_RightIsReceipt(
        long docRightId, boolean rightIsReceipt, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDocRightId_RightIsReceipt(docRightId, rightIsReceipt,
            start, end, obc);
    }

    public static com.sgs.portlet.document.model.PmlEdmDocumentRelation findByDocRightId_RightIsReceipt_First(
        long docRightId, boolean rightIsReceipt,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlEdmDocumentRelationException {
        return getPersistence()
                   .findByDocRightId_RightIsReceipt_First(docRightId,
            rightIsReceipt, obc);
    }

    public static com.sgs.portlet.document.model.PmlEdmDocumentRelation findByDocRightId_RightIsReceipt_Last(
        long docRightId, boolean rightIsReceipt,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlEdmDocumentRelationException {
        return getPersistence()
                   .findByDocRightId_RightIsReceipt_Last(docRightId,
            rightIsReceipt, obc);
    }

    public static com.sgs.portlet.document.model.PmlEdmDocumentRelation[] findByDocRightId_RightIsReceipt_PrevAndNext(
        long documentRelationId, long docRightId, boolean rightIsReceipt,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlEdmDocumentRelationException {
        return getPersistence()
                   .findByDocRightId_RightIsReceipt_PrevAndNext(documentRelationId,
            docRightId, rightIsReceipt, obc);
    }

    public static com.sgs.portlet.document.model.PmlEdmDocumentRelation findByDocLeftId_DocRightId_LeftIsReceipt_RightIsReceipt(
        long docLeftId, long docRightId, boolean leftIsReceipt,
        boolean rightIsReceipt)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlEdmDocumentRelationException {
        return getPersistence()
                   .findByDocLeftId_DocRightId_LeftIsReceipt_RightIsReceipt(docLeftId,
            docRightId, leftIsReceipt, rightIsReceipt);
    }

    public static com.sgs.portlet.document.model.PmlEdmDocumentRelation fetchByDocLeftId_DocRightId_LeftIsReceipt_RightIsReceipt(
        long docLeftId, long docRightId, boolean leftIsReceipt,
        boolean rightIsReceipt) throws com.liferay.portal.SystemException {
        return getPersistence()
                   .fetchByDocLeftId_DocRightId_LeftIsReceipt_RightIsReceipt(docLeftId,
            docRightId, leftIsReceipt, rightIsReceipt);
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

    public static java.util.List<com.sgs.portlet.document.model.PmlEdmDocumentRelation> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlEdmDocumentRelation> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlEdmDocumentRelation> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end, obc);
    }

    public static void removeByDocLeftId_LeftIsReceipt(long docLeftId,
        boolean leftIsReceipt) throws com.liferay.portal.SystemException {
        getPersistence()
            .removeByDocLeftId_LeftIsReceipt(docLeftId, leftIsReceipt);
    }

    public static void removeByDocRightId_RightIsReceipt(long docRightId,
        boolean rightIsReceipt) throws com.liferay.portal.SystemException {
        getPersistence()
            .removeByDocRightId_RightIsReceipt(docRightId, rightIsReceipt);
    }

    public static void removeByDocLeftId_DocRightId_LeftIsReceipt_RightIsReceipt(
        long docLeftId, long docRightId, boolean leftIsReceipt,
        boolean rightIsReceipt)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlEdmDocumentRelationException {
        getPersistence()
            .removeByDocLeftId_DocRightId_LeftIsReceipt_RightIsReceipt(docLeftId,
            docRightId, leftIsReceipt, rightIsReceipt);
    }

    public static void removeAll() throws com.liferay.portal.SystemException {
        getPersistence().removeAll();
    }

    public static int countByDocLeftId_LeftIsReceipt(long docLeftId,
        boolean leftIsReceipt) throws com.liferay.portal.SystemException {
        return getPersistence()
                   .countByDocLeftId_LeftIsReceipt(docLeftId, leftIsReceipt);
    }

    public static int countByDocRightId_RightIsReceipt(long docRightId,
        boolean rightIsReceipt) throws com.liferay.portal.SystemException {
        return getPersistence()
                   .countByDocRightId_RightIsReceipt(docRightId, rightIsReceipt);
    }

    public static int countByDocLeftId_DocRightId_LeftIsReceipt_RightIsReceipt(
        long docLeftId, long docRightId, boolean leftIsReceipt,
        boolean rightIsReceipt) throws com.liferay.portal.SystemException {
        return getPersistence()
                   .countByDocLeftId_DocRightId_LeftIsReceipt_RightIsReceipt(docLeftId,
            docRightId, leftIsReceipt, rightIsReceipt);
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

    public static PmlEdmDocumentRelationPersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(PmlEdmDocumentRelationPersistence persistence) {
        _persistence = persistence;
    }
}
