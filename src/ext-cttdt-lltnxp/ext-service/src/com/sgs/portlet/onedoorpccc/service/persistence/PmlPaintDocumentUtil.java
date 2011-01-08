package com.sgs.portlet.onedoorpccc.service.persistence;

public class PmlPaintDocumentUtil {
    private static PmlPaintDocumentPersistence _persistence;

    public static com.sgs.portlet.onedoorpccc.model.PmlPaintDocument create(
        long paintDocumentId) {
        return getPersistence().create(paintDocumentId);
    }

    public static com.sgs.portlet.onedoorpccc.model.PmlPaintDocument remove(
        long paintDocumentId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchPmlPaintDocumentException {
        return getPersistence().remove(paintDocumentId);
    }

    public static com.sgs.portlet.onedoorpccc.model.PmlPaintDocument remove(
        com.sgs.portlet.onedoorpccc.model.PmlPaintDocument pmlPaintDocument)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(pmlPaintDocument);
    }

    /**
     * @deprecated Use <code>update(PmlPaintDocument pmlPaintDocument, boolean merge)</code>.
     */
    public static com.sgs.portlet.onedoorpccc.model.PmlPaintDocument update(
        com.sgs.portlet.onedoorpccc.model.PmlPaintDocument pmlPaintDocument)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(pmlPaintDocument);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlPaintDocument the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlPaintDocument is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public static com.sgs.portlet.onedoorpccc.model.PmlPaintDocument update(
        com.sgs.portlet.onedoorpccc.model.PmlPaintDocument pmlPaintDocument,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().update(pmlPaintDocument, merge);
    }

    public static com.sgs.portlet.onedoorpccc.model.PmlPaintDocument updateImpl(
        com.sgs.portlet.onedoorpccc.model.PmlPaintDocument pmlPaintDocument,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(pmlPaintDocument, merge);
    }

    public static com.sgs.portlet.onedoorpccc.model.PmlPaintDocument findByPrimaryKey(
        long paintDocumentId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchPmlPaintDocumentException {
        return getPersistence().findByPrimaryKey(paintDocumentId);
    }

    public static com.sgs.portlet.onedoorpccc.model.PmlPaintDocument fetchByPrimaryKey(
        long paintDocumentId) throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(paintDocumentId);
    }

    public static java.util.List<com.sgs.portlet.onedoorpccc.model.PmlPaintDocument> findByQuantity(
        int quantity) throws com.liferay.portal.SystemException {
        return getPersistence().findByQuantity(quantity);
    }

    public static java.util.List<com.sgs.portlet.onedoorpccc.model.PmlPaintDocument> findByQuantity(
        int quantity, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByQuantity(quantity, start, end);
    }

    public static java.util.List<com.sgs.portlet.onedoorpccc.model.PmlPaintDocument> findByQuantity(
        int quantity, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByQuantity(quantity, start, end, obc);
    }

    public static com.sgs.portlet.onedoorpccc.model.PmlPaintDocument findByQuantity_First(
        int quantity, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchPmlPaintDocumentException {
        return getPersistence().findByQuantity_First(quantity, obc);
    }

    public static com.sgs.portlet.onedoorpccc.model.PmlPaintDocument findByQuantity_Last(
        int quantity, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchPmlPaintDocumentException {
        return getPersistence().findByQuantity_Last(quantity, obc);
    }

    public static com.sgs.portlet.onedoorpccc.model.PmlPaintDocument[] findByQuantity_PrevAndNext(
        long paintDocumentId, int quantity,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchPmlPaintDocumentException {
        return getPersistence()
                   .findByQuantity_PrevAndNext(paintDocumentId, quantity, obc);
    }

    public static java.util.List<com.sgs.portlet.onedoorpccc.model.PmlPaintDocument> findByFileId(
        java.lang.String fileId) throws com.liferay.portal.SystemException {
        return getPersistence().findByFileId(fileId);
    }

    public static java.util.List<com.sgs.portlet.onedoorpccc.model.PmlPaintDocument> findByFileId(
        java.lang.String fileId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByFileId(fileId, start, end);
    }

    public static java.util.List<com.sgs.portlet.onedoorpccc.model.PmlPaintDocument> findByFileId(
        java.lang.String fileId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByFileId(fileId, start, end, obc);
    }

    public static com.sgs.portlet.onedoorpccc.model.PmlPaintDocument findByFileId_First(
        java.lang.String fileId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchPmlPaintDocumentException {
        return getPersistence().findByFileId_First(fileId, obc);
    }

    public static com.sgs.portlet.onedoorpccc.model.PmlPaintDocument findByFileId_Last(
        java.lang.String fileId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchPmlPaintDocumentException {
        return getPersistence().findByFileId_Last(fileId, obc);
    }

    public static com.sgs.portlet.onedoorpccc.model.PmlPaintDocument[] findByFileId_PrevAndNext(
        long paintDocumentId, java.lang.String fileId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchPmlPaintDocumentException {
        return getPersistence()
                   .findByFileId_PrevAndNext(paintDocumentId, fileId, obc);
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

    public static java.util.List<com.sgs.portlet.onedoorpccc.model.PmlPaintDocument> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.sgs.portlet.onedoorpccc.model.PmlPaintDocument> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.sgs.portlet.onedoorpccc.model.PmlPaintDocument> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end, obc);
    }

    public static void removeByQuantity(int quantity)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByQuantity(quantity);
    }

    public static void removeByFileId(java.lang.String fileId)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByFileId(fileId);
    }

    public static void removeAll() throws com.liferay.portal.SystemException {
        getPersistence().removeAll();
    }

    public static int countByQuantity(int quantity)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByQuantity(quantity);
    }

    public static int countByFileId(java.lang.String fileId)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByFileId(fileId);
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

    public static PmlPaintDocumentPersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(PmlPaintDocumentPersistence persistence) {
        _persistence = persistence;
    }
}
