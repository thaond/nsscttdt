package com.sgs.portlet.document.receipt.service.persistence;

public class PmlEdmProcessDocumentReceiptDetailUtil {
    private static PmlEdmProcessDocumentReceiptDetailPersistence _persistence;

    public static com.sgs.portlet.document.receipt.model.PmlEdmProcessDocumentReceiptDetail create(
        long id) {
        return getPersistence().create(id);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmProcessDocumentReceiptDetail remove(
        long id)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmProcessDocumentReceiptDetailException {
        return getPersistence().remove(id);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmProcessDocumentReceiptDetail remove(
        com.sgs.portlet.document.receipt.model.PmlEdmProcessDocumentReceiptDetail pmlEdmProcessDocumentReceiptDetail)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(pmlEdmProcessDocumentReceiptDetail);
    }

    /**
     * @deprecated Use <code>update(PmlEdmProcessDocumentReceiptDetail pmlEdmProcessDocumentReceiptDetail, boolean merge)</code>.
     */
    public static com.sgs.portlet.document.receipt.model.PmlEdmProcessDocumentReceiptDetail update(
        com.sgs.portlet.document.receipt.model.PmlEdmProcessDocumentReceiptDetail pmlEdmProcessDocumentReceiptDetail)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(pmlEdmProcessDocumentReceiptDetail);
    }

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
    public static com.sgs.portlet.document.receipt.model.PmlEdmProcessDocumentReceiptDetail update(
        com.sgs.portlet.document.receipt.model.PmlEdmProcessDocumentReceiptDetail pmlEdmProcessDocumentReceiptDetail,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().update(pmlEdmProcessDocumentReceiptDetail, merge);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmProcessDocumentReceiptDetail updateImpl(
        com.sgs.portlet.document.receipt.model.PmlEdmProcessDocumentReceiptDetail pmlEdmProcessDocumentReceiptDetail,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence()
                   .updateImpl(pmlEdmProcessDocumentReceiptDetail, merge);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmProcessDocumentReceiptDetail findByPrimaryKey(
        long id)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmProcessDocumentReceiptDetailException {
        return getPersistence().findByPrimaryKey(id);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmProcessDocumentReceiptDetail fetchByPrimaryKey(
        long id) throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(id);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmProcessDocumentReceiptDetail> findByDocumentReceiptId(
        long documentReceiptId) throws com.liferay.portal.SystemException {
        return getPersistence().findByDocumentReceiptId(documentReceiptId);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmProcessDocumentReceiptDetail> findByDocumentReceiptId(
        long documentReceiptId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDocumentReceiptId(documentReceiptId, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmProcessDocumentReceiptDetail> findByDocumentReceiptId(
        long documentReceiptId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDocumentReceiptId(documentReceiptId, start, end, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmProcessDocumentReceiptDetail findByDocumentReceiptId_First(
        long documentReceiptId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmProcessDocumentReceiptDetailException {
        return getPersistence()
                   .findByDocumentReceiptId_First(documentReceiptId, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmProcessDocumentReceiptDetail findByDocumentReceiptId_Last(
        long documentReceiptId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmProcessDocumentReceiptDetailException {
        return getPersistence()
                   .findByDocumentReceiptId_Last(documentReceiptId, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmProcessDocumentReceiptDetail[] findByDocumentReceiptId_PrevAndNext(
        long id, long documentReceiptId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmProcessDocumentReceiptDetailException {
        return getPersistence()
                   .findByDocumentReceiptId_PrevAndNext(id, documentReceiptId,
            obc);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmProcessDocumentReceiptDetail> findByUserId(
        long userId) throws com.liferay.portal.SystemException {
        return getPersistence().findByUserId(userId);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmProcessDocumentReceiptDetail> findByUserId(
        long userId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByUserId(userId, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmProcessDocumentReceiptDetail> findByUserId(
        long userId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByUserId(userId, start, end, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmProcessDocumentReceiptDetail findByUserId_First(
        long userId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmProcessDocumentReceiptDetailException {
        return getPersistence().findByUserId_First(userId, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmProcessDocumentReceiptDetail findByUserId_Last(
        long userId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmProcessDocumentReceiptDetailException {
        return getPersistence().findByUserId_Last(userId, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmProcessDocumentReceiptDetail[] findByUserId_PrevAndNext(
        long id, long userId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmProcessDocumentReceiptDetailException {
        return getPersistence().findByUserId_PrevAndNext(id, userId, obc);
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

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmProcessDocumentReceiptDetail> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmProcessDocumentReceiptDetail> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmProcessDocumentReceiptDetail> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end, obc);
    }

    public static void removeByDocumentReceiptId(long documentReceiptId)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByDocumentReceiptId(documentReceiptId);
    }

    public static void removeByUserId(long userId)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByUserId(userId);
    }

    public static void removeAll() throws com.liferay.portal.SystemException {
        getPersistence().removeAll();
    }

    public static int countByDocumentReceiptId(long documentReceiptId)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByDocumentReceiptId(documentReceiptId);
    }

    public static int countByUserId(long userId)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByUserId(userId);
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

    public static PmlEdmProcessDocumentReceiptDetailPersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(
        PmlEdmProcessDocumentReceiptDetailPersistence persistence) {
        _persistence = persistence;
    }
}
