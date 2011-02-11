package com.sgs.portlet.document_manager.service.persistence;

public class DocumentManagerUtil {
    private static DocumentManagerPersistence _persistence;

    public static com.sgs.portlet.document_manager.model.DocumentManager create(
        long documentManagerId) {
        return getPersistence().create(documentManagerId);
    }

    public static com.sgs.portlet.document_manager.model.DocumentManager remove(
        long documentManagerId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document_manager.NoSuchException {
        return getPersistence().remove(documentManagerId);
    }

    public static com.sgs.portlet.document_manager.model.DocumentManager remove(
        com.sgs.portlet.document_manager.model.DocumentManager documentManager)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(documentManager);
    }

    /**
     * @deprecated Use <code>update(DocumentManager documentManager, boolean merge)</code>.
     */
    public static com.sgs.portlet.document_manager.model.DocumentManager update(
        com.sgs.portlet.document_manager.model.DocumentManager documentManager)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(documentManager);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                documentManager the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when documentManager is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public static com.sgs.portlet.document_manager.model.DocumentManager update(
        com.sgs.portlet.document_manager.model.DocumentManager documentManager,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().update(documentManager, merge);
    }

    public static com.sgs.portlet.document_manager.model.DocumentManager updateImpl(
        com.sgs.portlet.document_manager.model.DocumentManager documentManager,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(documentManager, merge);
    }

    public static com.sgs.portlet.document_manager.model.DocumentManager findByPrimaryKey(
        long documentManagerId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document_manager.NoSuchException {
        return getPersistence().findByPrimaryKey(documentManagerId);
    }

    public static com.sgs.portlet.document_manager.model.DocumentManager fetchByPrimaryKey(
        long documentManagerId) throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(documentManagerId);
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

    public static java.util.List<com.sgs.portlet.document_manager.model.DocumentManager> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.sgs.portlet.document_manager.model.DocumentManager> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.sgs.portlet.document_manager.model.DocumentManager> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end, obc);
    }

    public static void removeAll() throws com.liferay.portal.SystemException {
        getPersistence().removeAll();
    }

    public static int countAll() throws com.liferay.portal.SystemException {
        return getPersistence().countAll();
    }

    public static java.util.List<com.sgs.portlet.document_manager.model.AttactFileDocument> getAttactFileDocuments(
        long pk) throws com.liferay.portal.SystemException {
        return getPersistence().getAttactFileDocuments(pk);
    }

    public static java.util.List<com.sgs.portlet.document_manager.model.AttactFileDocument> getAttactFileDocuments(
        long pk, int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().getAttactFileDocuments(pk, start, end);
    }

    public static java.util.List<com.sgs.portlet.document_manager.model.AttactFileDocument> getAttactFileDocuments(
        long pk, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().getAttactFileDocuments(pk, start, end, obc);
    }

    public static int getAttactFileDocumentsSize(long pk)
        throws com.liferay.portal.SystemException {
        return getPersistence().getAttactFileDocumentsSize(pk);
    }

    public static boolean containsAttactFileDocument(long pk,
        long attactFileDocumentPK) throws com.liferay.portal.SystemException {
        return getPersistence()
                   .containsAttactFileDocument(pk, attactFileDocumentPK);
    }

    public static boolean containsAttactFileDocuments(long pk)
        throws com.liferay.portal.SystemException {
        return getPersistence().containsAttactFileDocuments(pk);
    }

    public static void registerListener(
        com.liferay.portal.model.ModelListener listener) {
        getPersistence().registerListener(listener);
    }

    public static void unregisterListener(
        com.liferay.portal.model.ModelListener listener) {
        getPersistence().unregisterListener(listener);
    }

    public static DocumentManagerPersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(DocumentManagerPersistence persistence) {
        _persistence = persistence;
    }
}
