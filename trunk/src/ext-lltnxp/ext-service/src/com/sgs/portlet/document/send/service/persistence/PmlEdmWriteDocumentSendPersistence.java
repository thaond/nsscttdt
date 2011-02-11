package com.sgs.portlet.document.send.service.persistence;

public interface PmlEdmWriteDocumentSendPersistence {
    public com.sgs.portlet.document.send.model.PmlEdmWriteDocumentSend create(
        com.sgs.portlet.document.send.service.persistence.PmlEdmWriteDocumentSendPK pmlEdmWriteDocumentSendPK);

    public com.sgs.portlet.document.send.model.PmlEdmWriteDocumentSend remove(
        com.sgs.portlet.document.send.service.persistence.PmlEdmWriteDocumentSendPK pmlEdmWriteDocumentSendPK)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmWriteDocumentSendException;

    public com.sgs.portlet.document.send.model.PmlEdmWriteDocumentSend remove(
        com.sgs.portlet.document.send.model.PmlEdmWriteDocumentSend pmlEdmWriteDocumentSend)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(PmlEdmWriteDocumentSend pmlEdmWriteDocumentSend, boolean merge)</code>.
     */
    public com.sgs.portlet.document.send.model.PmlEdmWriteDocumentSend update(
        com.sgs.portlet.document.send.model.PmlEdmWriteDocumentSend pmlEdmWriteDocumentSend)
        throws com.liferay.portal.SystemException;

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlEdmWriteDocumentSend the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlEdmWriteDocumentSend is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public com.sgs.portlet.document.send.model.PmlEdmWriteDocumentSend update(
        com.sgs.portlet.document.send.model.PmlEdmWriteDocumentSend pmlEdmWriteDocumentSend,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.send.model.PmlEdmWriteDocumentSend updateImpl(
        com.sgs.portlet.document.send.model.PmlEdmWriteDocumentSend pmlEdmWriteDocumentSend,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.send.model.PmlEdmWriteDocumentSend findByPrimaryKey(
        com.sgs.portlet.document.send.service.persistence.PmlEdmWriteDocumentSendPK pmlEdmWriteDocumentSendPK)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmWriteDocumentSendException;

    public com.sgs.portlet.document.send.model.PmlEdmWriteDocumentSend fetchByPrimaryKey(
        com.sgs.portlet.document.send.service.persistence.PmlEdmWriteDocumentSendPK pmlEdmWriteDocumentSendPK)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmWriteDocumentSend> findByBookDocumentSendId(
        long bookDocumentSendId) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmWriteDocumentSend> findByBookDocumentSendId(
        long bookDocumentSendId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmWriteDocumentSend> findByBookDocumentSendId(
        long bookDocumentSendId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.send.model.PmlEdmWriteDocumentSend findByBookDocumentSendId_First(
        long bookDocumentSendId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmWriteDocumentSendException;

    public com.sgs.portlet.document.send.model.PmlEdmWriteDocumentSend findByBookDocumentSendId_Last(
        long bookDocumentSendId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmWriteDocumentSendException;

    public com.sgs.portlet.document.send.model.PmlEdmWriteDocumentSend[] findByBookDocumentSendId_PrevAndNext(
        com.sgs.portlet.document.send.service.persistence.PmlEdmWriteDocumentSendPK pmlEdmWriteDocumentSendPK,
        long bookDocumentSendId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmWriteDocumentSendException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmWriteDocumentSend> findByDocumentSendId(
        long documentSendId) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmWriteDocumentSend> findByDocumentSendId(
        long documentSendId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmWriteDocumentSend> findByDocumentSendId(
        long documentSendId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.send.model.PmlEdmWriteDocumentSend findByDocumentSendId_First(
        long documentSendId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmWriteDocumentSendException;

    public com.sgs.portlet.document.send.model.PmlEdmWriteDocumentSend findByDocumentSendId_Last(
        long documentSendId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmWriteDocumentSendException;

    public com.sgs.portlet.document.send.model.PmlEdmWriteDocumentSend[] findByDocumentSendId_PrevAndNext(
        com.sgs.portlet.document.send.service.persistence.PmlEdmWriteDocumentSendPK pmlEdmWriteDocumentSendPK,
        long documentSendId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmWriteDocumentSendException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmWriteDocumentSend> findByDateCreated(
        java.util.Date dateCreated) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmWriteDocumentSend> findByDateCreated(
        java.util.Date dateCreated, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmWriteDocumentSend> findByDateCreated(
        java.util.Date dateCreated, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.send.model.PmlEdmWriteDocumentSend findByDateCreated_First(
        java.util.Date dateCreated,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmWriteDocumentSendException;

    public com.sgs.portlet.document.send.model.PmlEdmWriteDocumentSend findByDateCreated_Last(
        java.util.Date dateCreated,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmWriteDocumentSendException;

    public com.sgs.portlet.document.send.model.PmlEdmWriteDocumentSend[] findByDateCreated_PrevAndNext(
        com.sgs.portlet.document.send.service.persistence.PmlEdmWriteDocumentSendPK pmlEdmWriteDocumentSendPK,
        java.util.Date dateCreated,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmWriteDocumentSendException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmWriteDocumentSend> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmWriteDocumentSend> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmWriteDocumentSend> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeByBookDocumentSendId(long bookDocumentSendId)
        throws com.liferay.portal.SystemException;

    public void removeByDocumentSendId(long documentSendId)
        throws com.liferay.portal.SystemException;

    public void removeByDateCreated(java.util.Date dateCreated)
        throws com.liferay.portal.SystemException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countByBookDocumentSendId(long bookDocumentSendId)
        throws com.liferay.portal.SystemException;

    public int countByDocumentSendId(long documentSendId)
        throws com.liferay.portal.SystemException;

    public int countByDateCreated(java.util.Date dateCreated)
        throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;

    public void registerListener(
        com.liferay.portal.model.ModelListener listener);

    public void unregisterListener(
        com.liferay.portal.model.ModelListener listener);
}
