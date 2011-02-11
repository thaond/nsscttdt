package com.sgs.portlet.document.send.service.persistence;

public class PmlEdmAnswerDetailUtil {
    private static PmlEdmAnswerDetailPersistence _persistence;

    public static com.sgs.portlet.document.send.model.PmlEdmAnswerDetail create(
        long documentReceiptId) {
        return getPersistence().create(documentReceiptId);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmAnswerDetail remove(
        long documentReceiptId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmAnswerDetailException {
        return getPersistence().remove(documentReceiptId);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmAnswerDetail remove(
        com.sgs.portlet.document.send.model.PmlEdmAnswerDetail pmlEdmAnswerDetail)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(pmlEdmAnswerDetail);
    }

    /**
     * @deprecated Use <code>update(PmlEdmAnswerDetail pmlEdmAnswerDetail, boolean merge)</code>.
     */
    public static com.sgs.portlet.document.send.model.PmlEdmAnswerDetail update(
        com.sgs.portlet.document.send.model.PmlEdmAnswerDetail pmlEdmAnswerDetail)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(pmlEdmAnswerDetail);
    }

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
    public static com.sgs.portlet.document.send.model.PmlEdmAnswerDetail update(
        com.sgs.portlet.document.send.model.PmlEdmAnswerDetail pmlEdmAnswerDetail,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().update(pmlEdmAnswerDetail, merge);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmAnswerDetail updateImpl(
        com.sgs.portlet.document.send.model.PmlEdmAnswerDetail pmlEdmAnswerDetail,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(pmlEdmAnswerDetail, merge);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmAnswerDetail findByPrimaryKey(
        long documentReceiptId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmAnswerDetailException {
        return getPersistence().findByPrimaryKey(documentReceiptId);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmAnswerDetail fetchByPrimaryKey(
        long documentReceiptId) throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(documentReceiptId);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmAnswerDetail> findByDocumentSendId(
        long documentSendId) throws com.liferay.portal.SystemException {
        return getPersistence().findByDocumentSendId(documentSendId);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmAnswerDetail> findByDocumentSendId(
        long documentSendId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByDocumentSendId(documentSendId, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmAnswerDetail> findByDocumentSendId(
        long documentSendId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDocumentSendId(documentSendId, start, end, obc);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmAnswerDetail findByDocumentSendId_First(
        long documentSendId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmAnswerDetailException {
        return getPersistence().findByDocumentSendId_First(documentSendId, obc);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmAnswerDetail findByDocumentSendId_Last(
        long documentSendId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmAnswerDetailException {
        return getPersistence().findByDocumentSendId_Last(documentSendId, obc);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmAnswerDetail[] findByDocumentSendId_PrevAndNext(
        long documentReceiptId, long documentSendId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmAnswerDetailException {
        return getPersistence()
                   .findByDocumentSendId_PrevAndNext(documentReceiptId,
            documentSendId, obc);
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

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmAnswerDetail> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmAnswerDetail> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmAnswerDetail> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end, obc);
    }

    public static void removeByDocumentSendId(long documentSendId)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByDocumentSendId(documentSendId);
    }

    public static void removeAll() throws com.liferay.portal.SystemException {
        getPersistence().removeAll();
    }

    public static int countByDocumentSendId(long documentSendId)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByDocumentSendId(documentSendId);
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

    public static PmlEdmAnswerDetailPersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(PmlEdmAnswerDetailPersistence persistence) {
        _persistence = persistence;
    }
}
