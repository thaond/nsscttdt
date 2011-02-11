package com.sgs.portlet.onedoorpccc.service.persistence;

public interface PmlPaintDocumentPersistence {
    public com.sgs.portlet.onedoorpccc.model.PmlPaintDocument create(
        long paintDocumentId);

    public com.sgs.portlet.onedoorpccc.model.PmlPaintDocument remove(
        long paintDocumentId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchPmlPaintDocumentException;

    public com.sgs.portlet.onedoorpccc.model.PmlPaintDocument remove(
        com.sgs.portlet.onedoorpccc.model.PmlPaintDocument pmlPaintDocument)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(PmlPaintDocument pmlPaintDocument, boolean merge)</code>.
     */
    public com.sgs.portlet.onedoorpccc.model.PmlPaintDocument update(
        com.sgs.portlet.onedoorpccc.model.PmlPaintDocument pmlPaintDocument)
        throws com.liferay.portal.SystemException;

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
    public com.sgs.portlet.onedoorpccc.model.PmlPaintDocument update(
        com.sgs.portlet.onedoorpccc.model.PmlPaintDocument pmlPaintDocument,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.onedoorpccc.model.PmlPaintDocument updateImpl(
        com.sgs.portlet.onedoorpccc.model.PmlPaintDocument pmlPaintDocument,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.onedoorpccc.model.PmlPaintDocument findByPrimaryKey(
        long paintDocumentId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchPmlPaintDocumentException;

    public com.sgs.portlet.onedoorpccc.model.PmlPaintDocument fetchByPrimaryKey(
        long paintDocumentId) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoorpccc.model.PmlPaintDocument> findByQuantity(
        int quantity) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoorpccc.model.PmlPaintDocument> findByQuantity(
        int quantity, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoorpccc.model.PmlPaintDocument> findByQuantity(
        int quantity, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.onedoorpccc.model.PmlPaintDocument findByQuantity_First(
        int quantity, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchPmlPaintDocumentException;

    public com.sgs.portlet.onedoorpccc.model.PmlPaintDocument findByQuantity_Last(
        int quantity, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchPmlPaintDocumentException;

    public com.sgs.portlet.onedoorpccc.model.PmlPaintDocument[] findByQuantity_PrevAndNext(
        long paintDocumentId, int quantity,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchPmlPaintDocumentException;

    public java.util.List<com.sgs.portlet.onedoorpccc.model.PmlPaintDocument> findByFileId(
        java.lang.String fileId) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoorpccc.model.PmlPaintDocument> findByFileId(
        java.lang.String fileId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoorpccc.model.PmlPaintDocument> findByFileId(
        java.lang.String fileId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.onedoorpccc.model.PmlPaintDocument findByFileId_First(
        java.lang.String fileId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchPmlPaintDocumentException;

    public com.sgs.portlet.onedoorpccc.model.PmlPaintDocument findByFileId_Last(
        java.lang.String fileId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchPmlPaintDocumentException;

    public com.sgs.portlet.onedoorpccc.model.PmlPaintDocument[] findByFileId_PrevAndNext(
        long paintDocumentId, java.lang.String fileId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchPmlPaintDocumentException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoorpccc.model.PmlPaintDocument> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoorpccc.model.PmlPaintDocument> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoorpccc.model.PmlPaintDocument> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeByQuantity(int quantity)
        throws com.liferay.portal.SystemException;

    public void removeByFileId(java.lang.String fileId)
        throws com.liferay.portal.SystemException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countByQuantity(int quantity)
        throws com.liferay.portal.SystemException;

    public int countByFileId(java.lang.String fileId)
        throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;

    public void registerListener(
        com.liferay.portal.model.ModelListener listener);

    public void unregisterListener(
        com.liferay.portal.model.ModelListener listener);
}
