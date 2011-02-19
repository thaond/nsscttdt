package com.sgs.portlet.document.service.persistence;

public class PmlDocumentReceiptIssuingPlaceLogUtil {
    private static PmlDocumentReceiptIssuingPlaceLogPersistence _persistence;

    public static com.sgs.portlet.document.model.PmlDocumentReceiptIssuingPlaceLog create(
        long documentReceiptIssuingPlaceLogId) {
        return getPersistence().create(documentReceiptIssuingPlaceLogId);
    }

    public static com.sgs.portlet.document.model.PmlDocumentReceiptIssuingPlaceLog remove(
        long documentReceiptIssuingPlaceLogId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptIssuingPlaceLogException {
        return getPersistence().remove(documentReceiptIssuingPlaceLogId);
    }

    public static com.sgs.portlet.document.model.PmlDocumentReceiptIssuingPlaceLog remove(
        com.sgs.portlet.document.model.PmlDocumentReceiptIssuingPlaceLog pmlDocumentReceiptIssuingPlaceLog)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(pmlDocumentReceiptIssuingPlaceLog);
    }

    /**
     * @deprecated Use <code>update(PmlDocumentReceiptIssuingPlaceLog pmlDocumentReceiptIssuingPlaceLog, boolean merge)</code>.
     */
    public static com.sgs.portlet.document.model.PmlDocumentReceiptIssuingPlaceLog update(
        com.sgs.portlet.document.model.PmlDocumentReceiptIssuingPlaceLog pmlDocumentReceiptIssuingPlaceLog)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(pmlDocumentReceiptIssuingPlaceLog);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlDocumentReceiptIssuingPlaceLog the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlDocumentReceiptIssuingPlaceLog is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public static com.sgs.portlet.document.model.PmlDocumentReceiptIssuingPlaceLog update(
        com.sgs.portlet.document.model.PmlDocumentReceiptIssuingPlaceLog pmlDocumentReceiptIssuingPlaceLog,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().update(pmlDocumentReceiptIssuingPlaceLog, merge);
    }

    public static com.sgs.portlet.document.model.PmlDocumentReceiptIssuingPlaceLog updateImpl(
        com.sgs.portlet.document.model.PmlDocumentReceiptIssuingPlaceLog pmlDocumentReceiptIssuingPlaceLog,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence()
                   .updateImpl(pmlDocumentReceiptIssuingPlaceLog, merge);
    }

    public static com.sgs.portlet.document.model.PmlDocumentReceiptIssuingPlaceLog findByPrimaryKey(
        long documentReceiptIssuingPlaceLogId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptIssuingPlaceLogException {
        return getPersistence()
                   .findByPrimaryKey(documentReceiptIssuingPlaceLogId);
    }

    public static com.sgs.portlet.document.model.PmlDocumentReceiptIssuingPlaceLog fetchByPrimaryKey(
        long documentReceiptIssuingPlaceLogId)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .fetchByPrimaryKey(documentReceiptIssuingPlaceLogId);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptIssuingPlaceLog> findByDoc_Proc_Step(
        long documentReceiptId, long processor, int step)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDoc_Proc_Step(documentReceiptId, processor, step);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptIssuingPlaceLog> findByDoc_Proc_Step(
        long documentReceiptId, long processor, int step, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDoc_Proc_Step(documentReceiptId, processor, step,
            start, end);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptIssuingPlaceLog> findByDoc_Proc_Step(
        long documentReceiptId, long processor, int step, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDoc_Proc_Step(documentReceiptId, processor, step,
            start, end, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentReceiptIssuingPlaceLog findByDoc_Proc_Step_First(
        long documentReceiptId, long processor, int step,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptIssuingPlaceLogException {
        return getPersistence()
                   .findByDoc_Proc_Step_First(documentReceiptId, processor,
            step, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentReceiptIssuingPlaceLog findByDoc_Proc_Step_Last(
        long documentReceiptId, long processor, int step,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptIssuingPlaceLogException {
        return getPersistence()
                   .findByDoc_Proc_Step_Last(documentReceiptId, processor,
            step, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentReceiptIssuingPlaceLog[] findByDoc_Proc_Step_PrevAndNext(
        long documentReceiptIssuingPlaceLogId, long documentReceiptId,
        long processor, int step,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptIssuingPlaceLogException {
        return getPersistence()
                   .findByDoc_Proc_Step_PrevAndNext(documentReceiptIssuingPlaceLogId,
            documentReceiptId, processor, step, obc);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptIssuingPlaceLog> findByDoc_Step(
        long documentReceiptId, int step)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByDoc_Step(documentReceiptId, step);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptIssuingPlaceLog> findByDoc_Step(
        long documentReceiptId, int step, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDoc_Step(documentReceiptId, step, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptIssuingPlaceLog> findByDoc_Step(
        long documentReceiptId, int step, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDoc_Step(documentReceiptId, step, start, end, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentReceiptIssuingPlaceLog findByDoc_Step_First(
        long documentReceiptId, int step,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptIssuingPlaceLogException {
        return getPersistence()
                   .findByDoc_Step_First(documentReceiptId, step, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentReceiptIssuingPlaceLog findByDoc_Step_Last(
        long documentReceiptId, int step,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptIssuingPlaceLogException {
        return getPersistence().findByDoc_Step_Last(documentReceiptId, step, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentReceiptIssuingPlaceLog[] findByDoc_Step_PrevAndNext(
        long documentReceiptIssuingPlaceLogId, long documentReceiptId,
        int step, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptIssuingPlaceLogException {
        return getPersistence()
                   .findByDoc_Step_PrevAndNext(documentReceiptIssuingPlaceLogId,
            documentReceiptId, step, obc);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptIssuingPlaceLog> findByDocId(
        long documentReceiptId) throws com.liferay.portal.SystemException {
        return getPersistence().findByDocId(documentReceiptId);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptIssuingPlaceLog> findByDocId(
        long documentReceiptId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByDocId(documentReceiptId, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptIssuingPlaceLog> findByDocId(
        long documentReceiptId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByDocId(documentReceiptId, start, end, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentReceiptIssuingPlaceLog findByDocId_First(
        long documentReceiptId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptIssuingPlaceLogException {
        return getPersistence().findByDocId_First(documentReceiptId, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentReceiptIssuingPlaceLog findByDocId_Last(
        long documentReceiptId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptIssuingPlaceLogException {
        return getPersistence().findByDocId_Last(documentReceiptId, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentReceiptIssuingPlaceLog[] findByDocId_PrevAndNext(
        long documentReceiptIssuingPlaceLogId, long documentReceiptId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptIssuingPlaceLogException {
        return getPersistence()
                   .findByDocId_PrevAndNext(documentReceiptIssuingPlaceLogId,
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

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptIssuingPlaceLog> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptIssuingPlaceLog> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptIssuingPlaceLog> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end, obc);
    }

    public static void removeByDoc_Proc_Step(long documentReceiptId,
        long processor, int step) throws com.liferay.portal.SystemException {
        getPersistence()
            .removeByDoc_Proc_Step(documentReceiptId, processor, step);
    }

    public static void removeByDoc_Step(long documentReceiptId, int step)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByDoc_Step(documentReceiptId, step);
    }

    public static void removeByDocId(long documentReceiptId)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByDocId(documentReceiptId);
    }

    public static void removeAll() throws com.liferay.portal.SystemException {
        getPersistence().removeAll();
    }

    public static int countByDoc_Proc_Step(long documentReceiptId,
        long processor, int step) throws com.liferay.portal.SystemException {
        return getPersistence()
                   .countByDoc_Proc_Step(documentReceiptId, processor, step);
    }

    public static int countByDoc_Step(long documentReceiptId, int step)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByDoc_Step(documentReceiptId, step);
    }

    public static int countByDocId(long documentReceiptId)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByDocId(documentReceiptId);
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

    public static PmlDocumentReceiptIssuingPlaceLogPersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(
        PmlDocumentReceiptIssuingPlaceLogPersistence persistence) {
        _persistence = persistence;
    }
}
