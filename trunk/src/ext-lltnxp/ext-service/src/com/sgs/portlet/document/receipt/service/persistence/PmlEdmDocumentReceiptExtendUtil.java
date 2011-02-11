package com.sgs.portlet.document.receipt.service.persistence;

public class PmlEdmDocumentReceiptExtendUtil {
    private static PmlEdmDocumentReceiptExtendPersistence _persistence;

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptExtend create(
        long documentReceiptExtendId) {
        return getPersistence().create(documentReceiptExtendId);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptExtend remove(
        long documentReceiptExtendId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptExtendException {
        return getPersistence().remove(documentReceiptExtendId);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptExtend remove(
        com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptExtend pmlEdmDocumentReceiptExtend)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(pmlEdmDocumentReceiptExtend);
    }

    /**
     * @deprecated Use <code>update(PmlEdmDocumentReceiptExtend pmlEdmDocumentReceiptExtend, boolean merge)</code>.
     */
    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptExtend update(
        com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptExtend pmlEdmDocumentReceiptExtend)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(pmlEdmDocumentReceiptExtend);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlEdmDocumentReceiptExtend the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlEdmDocumentReceiptExtend is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptExtend update(
        com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptExtend pmlEdmDocumentReceiptExtend,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().update(pmlEdmDocumentReceiptExtend, merge);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptExtend updateImpl(
        com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptExtend pmlEdmDocumentReceiptExtend,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(pmlEdmDocumentReceiptExtend, merge);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptExtend findByPrimaryKey(
        long documentReceiptExtendId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptExtendException {
        return getPersistence().findByPrimaryKey(documentReceiptExtendId);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptExtend fetchByPrimaryKey(
        long documentReceiptExtendId) throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(documentReceiptExtendId);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptExtend> findByDocumentReceiptId(
        long documentReceiptId) throws com.liferay.portal.SystemException {
        return getPersistence().findByDocumentReceiptId(documentReceiptId);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptExtend> findByDocumentReceiptId(
        long documentReceiptId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDocumentReceiptId(documentReceiptId, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptExtend> findByDocumentReceiptId(
        long documentReceiptId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDocumentReceiptId(documentReceiptId, start, end, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptExtend findByDocumentReceiptId_First(
        long documentReceiptId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptExtendException {
        return getPersistence()
                   .findByDocumentReceiptId_First(documentReceiptId, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptExtend findByDocumentReceiptId_Last(
        long documentReceiptId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptExtendException {
        return getPersistence()
                   .findByDocumentReceiptId_Last(documentReceiptId, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptExtend[] findByDocumentReceiptId_PrevAndNext(
        long documentReceiptExtendId, long documentReceiptId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptExtendException {
        return getPersistence()
                   .findByDocumentReceiptId_PrevAndNext(documentReceiptExtendId,
            documentReceiptId, obc);
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

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptExtend> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptExtend> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptExtend> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end, obc);
    }

    public static void removeByDocumentReceiptId(long documentReceiptId)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByDocumentReceiptId(documentReceiptId);
    }

    public static void removeAll() throws com.liferay.portal.SystemException {
        getPersistence().removeAll();
    }

    public static int countByDocumentReceiptId(long documentReceiptId)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByDocumentReceiptId(documentReceiptId);
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

    public static PmlEdmDocumentReceiptExtendPersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(
        PmlEdmDocumentReceiptExtendPersistence persistence) {
        _persistence = persistence;
    }
}
