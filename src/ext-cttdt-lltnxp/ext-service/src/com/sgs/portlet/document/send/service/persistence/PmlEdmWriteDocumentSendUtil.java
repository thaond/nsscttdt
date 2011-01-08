package com.sgs.portlet.document.send.service.persistence;

public class PmlEdmWriteDocumentSendUtil {
    private static PmlEdmWriteDocumentSendPersistence _persistence;

    public static com.sgs.portlet.document.send.model.PmlEdmWriteDocumentSend create(
        com.sgs.portlet.document.send.service.persistence.PmlEdmWriteDocumentSendPK pmlEdmWriteDocumentSendPK) {
        return getPersistence().create(pmlEdmWriteDocumentSendPK);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmWriteDocumentSend remove(
        com.sgs.portlet.document.send.service.persistence.PmlEdmWriteDocumentSendPK pmlEdmWriteDocumentSendPK)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmWriteDocumentSendException {
        return getPersistence().remove(pmlEdmWriteDocumentSendPK);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmWriteDocumentSend remove(
        com.sgs.portlet.document.send.model.PmlEdmWriteDocumentSend pmlEdmWriteDocumentSend)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(pmlEdmWriteDocumentSend);
    }

    /**
     * @deprecated Use <code>update(PmlEdmWriteDocumentSend pmlEdmWriteDocumentSend, boolean merge)</code>.
     */
    public static com.sgs.portlet.document.send.model.PmlEdmWriteDocumentSend update(
        com.sgs.portlet.document.send.model.PmlEdmWriteDocumentSend pmlEdmWriteDocumentSend)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(pmlEdmWriteDocumentSend);
    }

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
    public static com.sgs.portlet.document.send.model.PmlEdmWriteDocumentSend update(
        com.sgs.portlet.document.send.model.PmlEdmWriteDocumentSend pmlEdmWriteDocumentSend,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().update(pmlEdmWriteDocumentSend, merge);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmWriteDocumentSend updateImpl(
        com.sgs.portlet.document.send.model.PmlEdmWriteDocumentSend pmlEdmWriteDocumentSend,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(pmlEdmWriteDocumentSend, merge);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmWriteDocumentSend findByPrimaryKey(
        com.sgs.portlet.document.send.service.persistence.PmlEdmWriteDocumentSendPK pmlEdmWriteDocumentSendPK)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmWriteDocumentSendException {
        return getPersistence().findByPrimaryKey(pmlEdmWriteDocumentSendPK);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmWriteDocumentSend fetchByPrimaryKey(
        com.sgs.portlet.document.send.service.persistence.PmlEdmWriteDocumentSendPK pmlEdmWriteDocumentSendPK)
        throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(pmlEdmWriteDocumentSendPK);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmWriteDocumentSend> findByBookDocumentSendId(
        long bookDocumentSendId) throws com.liferay.portal.SystemException {
        return getPersistence().findByBookDocumentSendId(bookDocumentSendId);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmWriteDocumentSend> findByBookDocumentSendId(
        long bookDocumentSendId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByBookDocumentSendId(bookDocumentSendId, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmWriteDocumentSend> findByBookDocumentSendId(
        long bookDocumentSendId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByBookDocumentSendId(bookDocumentSendId, start, end, obc);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmWriteDocumentSend findByBookDocumentSendId_First(
        long bookDocumentSendId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmWriteDocumentSendException {
        return getPersistence()
                   .findByBookDocumentSendId_First(bookDocumentSendId, obc);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmWriteDocumentSend findByBookDocumentSendId_Last(
        long bookDocumentSendId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmWriteDocumentSendException {
        return getPersistence()
                   .findByBookDocumentSendId_Last(bookDocumentSendId, obc);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmWriteDocumentSend[] findByBookDocumentSendId_PrevAndNext(
        com.sgs.portlet.document.send.service.persistence.PmlEdmWriteDocumentSendPK pmlEdmWriteDocumentSendPK,
        long bookDocumentSendId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmWriteDocumentSendException {
        return getPersistence()
                   .findByBookDocumentSendId_PrevAndNext(pmlEdmWriteDocumentSendPK,
            bookDocumentSendId, obc);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmWriteDocumentSend> findByDocumentSendId(
        long documentSendId) throws com.liferay.portal.SystemException {
        return getPersistence().findByDocumentSendId(documentSendId);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmWriteDocumentSend> findByDocumentSendId(
        long documentSendId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByDocumentSendId(documentSendId, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmWriteDocumentSend> findByDocumentSendId(
        long documentSendId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDocumentSendId(documentSendId, start, end, obc);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmWriteDocumentSend findByDocumentSendId_First(
        long documentSendId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmWriteDocumentSendException {
        return getPersistence().findByDocumentSendId_First(documentSendId, obc);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmWriteDocumentSend findByDocumentSendId_Last(
        long documentSendId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmWriteDocumentSendException {
        return getPersistence().findByDocumentSendId_Last(documentSendId, obc);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmWriteDocumentSend[] findByDocumentSendId_PrevAndNext(
        com.sgs.portlet.document.send.service.persistence.PmlEdmWriteDocumentSendPK pmlEdmWriteDocumentSendPK,
        long documentSendId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmWriteDocumentSendException {
        return getPersistence()
                   .findByDocumentSendId_PrevAndNext(pmlEdmWriteDocumentSendPK,
            documentSendId, obc);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmWriteDocumentSend> findByDateCreated(
        java.util.Date dateCreated) throws com.liferay.portal.SystemException {
        return getPersistence().findByDateCreated(dateCreated);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmWriteDocumentSend> findByDateCreated(
        java.util.Date dateCreated, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByDateCreated(dateCreated, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmWriteDocumentSend> findByDateCreated(
        java.util.Date dateCreated, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByDateCreated(dateCreated, start, end, obc);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmWriteDocumentSend findByDateCreated_First(
        java.util.Date dateCreated,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmWriteDocumentSendException {
        return getPersistence().findByDateCreated_First(dateCreated, obc);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmWriteDocumentSend findByDateCreated_Last(
        java.util.Date dateCreated,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmWriteDocumentSendException {
        return getPersistence().findByDateCreated_Last(dateCreated, obc);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmWriteDocumentSend[] findByDateCreated_PrevAndNext(
        com.sgs.portlet.document.send.service.persistence.PmlEdmWriteDocumentSendPK pmlEdmWriteDocumentSendPK,
        java.util.Date dateCreated,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmWriteDocumentSendException {
        return getPersistence()
                   .findByDateCreated_PrevAndNext(pmlEdmWriteDocumentSendPK,
            dateCreated, obc);
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

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmWriteDocumentSend> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmWriteDocumentSend> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmWriteDocumentSend> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end, obc);
    }

    public static void removeByBookDocumentSendId(long bookDocumentSendId)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByBookDocumentSendId(bookDocumentSendId);
    }

    public static void removeByDocumentSendId(long documentSendId)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByDocumentSendId(documentSendId);
    }

    public static void removeByDateCreated(java.util.Date dateCreated)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByDateCreated(dateCreated);
    }

    public static void removeAll() throws com.liferay.portal.SystemException {
        getPersistence().removeAll();
    }

    public static int countByBookDocumentSendId(long bookDocumentSendId)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByBookDocumentSendId(bookDocumentSendId);
    }

    public static int countByDocumentSendId(long documentSendId)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByDocumentSendId(documentSendId);
    }

    public static int countByDateCreated(java.util.Date dateCreated)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByDateCreated(dateCreated);
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

    public static PmlEdmWriteDocumentSendPersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(PmlEdmWriteDocumentSendPersistence persistence) {
        _persistence = persistence;
    }
}
