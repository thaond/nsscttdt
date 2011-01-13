package com.sgs.portlet.document_manager.service.persistence;

public class AttactFileDocumentUtil {
    private static AttactFileDocumentPersistence _persistence;

    public static com.sgs.portlet.document_manager.model.AttactFileDocument create(
        long attactFileDocumentId) {
        return getPersistence().create(attactFileDocumentId);
    }

    public static com.sgs.portlet.document_manager.model.AttactFileDocument remove(
        long attactFileDocumentId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document_manager.NoSuchAttactFileDocumentException {
        return getPersistence().remove(attactFileDocumentId);
    }

    public static com.sgs.portlet.document_manager.model.AttactFileDocument remove(
        com.sgs.portlet.document_manager.model.AttactFileDocument attactFileDocument)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(attactFileDocument);
    }

    /**
     * @deprecated Use <code>update(AttactFileDocument attactFileDocument, boolean merge)</code>.
     */
    public static com.sgs.portlet.document_manager.model.AttactFileDocument update(
        com.sgs.portlet.document_manager.model.AttactFileDocument attactFileDocument)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(attactFileDocument);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                attactFileDocument the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when attactFileDocument is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public static com.sgs.portlet.document_manager.model.AttactFileDocument update(
        com.sgs.portlet.document_manager.model.AttactFileDocument attactFileDocument,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().update(attactFileDocument, merge);
    }

    public static com.sgs.portlet.document_manager.model.AttactFileDocument updateImpl(
        com.sgs.portlet.document_manager.model.AttactFileDocument attactFileDocument,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(attactFileDocument, merge);
    }

    public static com.sgs.portlet.document_manager.model.AttactFileDocument findByPrimaryKey(
        long attactFileDocumentId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document_manager.NoSuchAttactFileDocumentException {
        return getPersistence().findByPrimaryKey(attactFileDocumentId);
    }

    public static com.sgs.portlet.document_manager.model.AttactFileDocument fetchByPrimaryKey(
        long attactFileDocumentId) throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(attactFileDocumentId);
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

    public static java.util.List<com.sgs.portlet.document_manager.model.AttactFileDocument> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.sgs.portlet.document_manager.model.AttactFileDocument> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.sgs.portlet.document_manager.model.AttactFileDocument> findAll(
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

    public static void registerListener(
        com.liferay.portal.model.ModelListener listener) {
        getPersistence().registerListener(listener);
    }

    public static void unregisterListener(
        com.liferay.portal.model.ModelListener listener) {
        getPersistence().unregisterListener(listener);
    }

    public static AttactFileDocumentPersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(AttactFileDocumentPersistence persistence) {
        _persistence = persistence;
    }
}
