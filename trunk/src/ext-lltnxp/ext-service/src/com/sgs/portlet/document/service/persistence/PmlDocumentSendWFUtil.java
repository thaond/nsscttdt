package com.sgs.portlet.document.service.persistence;

public class PmlDocumentSendWFUtil {
    private static PmlDocumentSendWFPersistence _persistence;

    public static com.sgs.portlet.document.model.PmlDocumentSendWF create(
        long documentSendId) {
        return getPersistence().create(documentSendId);
    }

    public static com.sgs.portlet.document.model.PmlDocumentSendWF remove(
        long documentSendId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendWFException {
        return getPersistence().remove(documentSendId);
    }

    public static com.sgs.portlet.document.model.PmlDocumentSendWF remove(
        com.sgs.portlet.document.model.PmlDocumentSendWF pmlDocumentSendWF)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(pmlDocumentSendWF);
    }

    /**
     * @deprecated Use <code>update(PmlDocumentSendWF pmlDocumentSendWF, boolean merge)</code>.
     */
    public static com.sgs.portlet.document.model.PmlDocumentSendWF update(
        com.sgs.portlet.document.model.PmlDocumentSendWF pmlDocumentSendWF)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(pmlDocumentSendWF);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlDocumentSendWF the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlDocumentSendWF is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public static com.sgs.portlet.document.model.PmlDocumentSendWF update(
        com.sgs.portlet.document.model.PmlDocumentSendWF pmlDocumentSendWF,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().update(pmlDocumentSendWF, merge);
    }

    public static com.sgs.portlet.document.model.PmlDocumentSendWF updateImpl(
        com.sgs.portlet.document.model.PmlDocumentSendWF pmlDocumentSendWF,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(pmlDocumentSendWF, merge);
    }

    public static com.sgs.portlet.document.model.PmlDocumentSendWF findByPrimaryKey(
        long documentSendId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendWFException {
        return getPersistence().findByPrimaryKey(documentSendId);
    }

    public static com.sgs.portlet.document.model.PmlDocumentSendWF fetchByPrimaryKey(
        long documentSendId) throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(documentSendId);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentSendWF> findByProcessId(
        long processId) throws com.liferay.portal.SystemException {
        return getPersistence().findByProcessId(processId);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentSendWF> findByProcessId(
        long processId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByProcessId(processId, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentSendWF> findByProcessId(
        long processId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByProcessId(processId, start, end, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentSendWF findByProcessId_First(
        long processId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendWFException {
        return getPersistence().findByProcessId_First(processId, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentSendWF findByProcessId_Last(
        long processId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendWFException {
        return getPersistence().findByProcessId_Last(processId, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentSendWF[] findByProcessId_PrevAndNext(
        long documentSendId, long processId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendWFException {
        return getPersistence()
                   .findByProcessId_PrevAndNext(documentSendId, processId, obc);
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

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentSendWF> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentSendWF> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentSendWF> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end, obc);
    }

    public static void removeByProcessId(long processId)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByProcessId(processId);
    }

    public static void removeAll() throws com.liferay.portal.SystemException {
        getPersistence().removeAll();
    }

    public static int countByProcessId(long processId)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByProcessId(processId);
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

    public static PmlDocumentSendWFPersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(PmlDocumentSendWFPersistence persistence) {
        _persistence = persistence;
    }
}
