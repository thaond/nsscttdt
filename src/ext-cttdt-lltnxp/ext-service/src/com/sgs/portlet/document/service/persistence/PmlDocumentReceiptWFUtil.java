package com.sgs.portlet.document.service.persistence;

public class PmlDocumentReceiptWFUtil {
    private static PmlDocumentReceiptWFPersistence _persistence;

    public static com.sgs.portlet.document.model.PmlDocumentReceiptWF create(
        long processId) {
        return getPersistence().create(processId);
    }

    public static com.sgs.portlet.document.model.PmlDocumentReceiptWF remove(
        long processId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptWFException {
        return getPersistence().remove(processId);
    }

    public static com.sgs.portlet.document.model.PmlDocumentReceiptWF remove(
        com.sgs.portlet.document.model.PmlDocumentReceiptWF pmlDocumentReceiptWF)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(pmlDocumentReceiptWF);
    }

    /**
     * @deprecated Use <code>update(PmlDocumentReceiptWF pmlDocumentReceiptWF, boolean merge)</code>.
     */
    public static com.sgs.portlet.document.model.PmlDocumentReceiptWF update(
        com.sgs.portlet.document.model.PmlDocumentReceiptWF pmlDocumentReceiptWF)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(pmlDocumentReceiptWF);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlDocumentReceiptWF the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlDocumentReceiptWF is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public static com.sgs.portlet.document.model.PmlDocumentReceiptWF update(
        com.sgs.portlet.document.model.PmlDocumentReceiptWF pmlDocumentReceiptWF,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().update(pmlDocumentReceiptWF, merge);
    }

    public static com.sgs.portlet.document.model.PmlDocumentReceiptWF updateImpl(
        com.sgs.portlet.document.model.PmlDocumentReceiptWF pmlDocumentReceiptWF,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(pmlDocumentReceiptWF, merge);
    }

    public static com.sgs.portlet.document.model.PmlDocumentReceiptWF findByPrimaryKey(
        long processId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptWFException {
        return getPersistence().findByPrimaryKey(processId);
    }

    public static com.sgs.portlet.document.model.PmlDocumentReceiptWF fetchByPrimaryKey(
        long processId) throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(processId);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptWF> findByDocumentReceiptId(
        long documentReceiptId) throws com.liferay.portal.SystemException {
        return getPersistence().findByDocumentReceiptId(documentReceiptId);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptWF> findByDocumentReceiptId(
        long documentReceiptId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDocumentReceiptId(documentReceiptId, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptWF> findByDocumentReceiptId(
        long documentReceiptId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDocumentReceiptId(documentReceiptId, start, end, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentReceiptWF findByDocumentReceiptId_First(
        long documentReceiptId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptWFException {
        return getPersistence()
                   .findByDocumentReceiptId_First(documentReceiptId, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentReceiptWF findByDocumentReceiptId_Last(
        long documentReceiptId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptWFException {
        return getPersistence()
                   .findByDocumentReceiptId_Last(documentReceiptId, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentReceiptWF[] findByDocumentReceiptId_PrevAndNext(
        long processId, long documentReceiptId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptWFException {
        return getPersistence()
                   .findByDocumentReceiptId_PrevAndNext(processId,
            documentReceiptId, obc);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptWF> findByDocumentReceiptIdIsMain(
        long documentReceiptId, java.lang.String isMain)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDocumentReceiptIdIsMain(documentReceiptId, isMain);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptWF> findByDocumentReceiptIdIsMain(
        long documentReceiptId, java.lang.String isMain, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDocumentReceiptIdIsMain(documentReceiptId, isMain,
            start, end);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptWF> findByDocumentReceiptIdIsMain(
        long documentReceiptId, java.lang.String isMain, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDocumentReceiptIdIsMain(documentReceiptId, isMain,
            start, end, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentReceiptWF findByDocumentReceiptIdIsMain_First(
        long documentReceiptId, java.lang.String isMain,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptWFException {
        return getPersistence()
                   .findByDocumentReceiptIdIsMain_First(documentReceiptId,
            isMain, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentReceiptWF findByDocumentReceiptIdIsMain_Last(
        long documentReceiptId, java.lang.String isMain,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptWFException {
        return getPersistence()
                   .findByDocumentReceiptIdIsMain_Last(documentReceiptId,
            isMain, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentReceiptWF[] findByDocumentReceiptIdIsMain_PrevAndNext(
        long processId, long documentReceiptId, java.lang.String isMain,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptWFException {
        return getPersistence()
                   .findByDocumentReceiptIdIsMain_PrevAndNext(processId,
            documentReceiptId, isMain, obc);
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

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptWF> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptWF> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptWF> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end, obc);
    }

    public static void removeByDocumentReceiptId(long documentReceiptId)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByDocumentReceiptId(documentReceiptId);
    }

    public static void removeByDocumentReceiptIdIsMain(long documentReceiptId,
        java.lang.String isMain) throws com.liferay.portal.SystemException {
        getPersistence()
            .removeByDocumentReceiptIdIsMain(documentReceiptId, isMain);
    }

    public static void removeAll() throws com.liferay.portal.SystemException {
        getPersistence().removeAll();
    }

    public static int countByDocumentReceiptId(long documentReceiptId)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByDocumentReceiptId(documentReceiptId);
    }

    public static int countByDocumentReceiptIdIsMain(long documentReceiptId,
        java.lang.String isMain) throws com.liferay.portal.SystemException {
        return getPersistence()
                   .countByDocumentReceiptIdIsMain(documentReceiptId, isMain);
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

    public static PmlDocumentReceiptWFPersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(PmlDocumentReceiptWFPersistence persistence) {
        _persistence = persistence;
    }
}
