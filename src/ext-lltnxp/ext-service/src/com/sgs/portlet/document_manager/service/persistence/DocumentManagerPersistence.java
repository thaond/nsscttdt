package com.sgs.portlet.document_manager.service.persistence;

public interface DocumentManagerPersistence {
    public com.sgs.portlet.document_manager.model.DocumentManager create(
        long documentManagerId);

    public com.sgs.portlet.document_manager.model.DocumentManager remove(
        long documentManagerId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document_manager.NoSuchException;

    public com.sgs.portlet.document_manager.model.DocumentManager remove(
        com.sgs.portlet.document_manager.model.DocumentManager documentManager)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(DocumentManager documentManager, boolean merge)</code>.
     */
    public com.sgs.portlet.document_manager.model.DocumentManager update(
        com.sgs.portlet.document_manager.model.DocumentManager documentManager)
        throws com.liferay.portal.SystemException;

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
    public com.sgs.portlet.document_manager.model.DocumentManager update(
        com.sgs.portlet.document_manager.model.DocumentManager documentManager,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document_manager.model.DocumentManager updateImpl(
        com.sgs.portlet.document_manager.model.DocumentManager documentManager,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document_manager.model.DocumentManager findByPrimaryKey(
        long documentManagerId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document_manager.NoSuchException;

    public com.sgs.portlet.document_manager.model.DocumentManager fetchByPrimaryKey(
        long documentManagerId) throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document_manager.model.DocumentManager> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document_manager.model.DocumentManager> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document_manager.model.DocumentManager> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document_manager.model.AttactFileDocument> getAttactFileDocuments(
        long pk) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document_manager.model.AttactFileDocument> getAttactFileDocuments(
        long pk, int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document_manager.model.AttactFileDocument> getAttactFileDocuments(
        long pk, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public int getAttactFileDocumentsSize(long pk)
        throws com.liferay.portal.SystemException;

    public boolean containsAttactFileDocument(long pk, long attactFileDocumentPK)
        throws com.liferay.portal.SystemException;

    public boolean containsAttactFileDocuments(long pk)
        throws com.liferay.portal.SystemException;

    public void registerListener(
        com.liferay.portal.model.ModelListener listener);

    public void unregisterListener(
        com.liferay.portal.model.ModelListener listener);
}
