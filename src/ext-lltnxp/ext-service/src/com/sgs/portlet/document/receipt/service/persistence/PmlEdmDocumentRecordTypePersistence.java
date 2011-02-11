package com.sgs.portlet.document.receipt.service.persistence;

public interface PmlEdmDocumentRecordTypePersistence {
    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType create(
        int documentRecordTypeId);

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType remove(
        int documentRecordTypeId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentRecordTypeException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType remove(
        com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType pmlEdmDocumentRecordType)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(PmlEdmDocumentRecordType pmlEdmDocumentRecordType, boolean merge)</code>.
     */
    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType update(
        com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType pmlEdmDocumentRecordType)
        throws com.liferay.portal.SystemException;

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlEdmDocumentRecordType the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlEdmDocumentRecordType is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType update(
        com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType pmlEdmDocumentRecordType,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType updateImpl(
        com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType pmlEdmDocumentRecordType,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType findByPrimaryKey(
        int documentRecordTypeId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentRecordTypeException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType fetchByPrimaryKey(
        int documentRecordTypeId) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType> findByDocumentRecordTypeCode(
        java.lang.String documentRecordTypeCode)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType> findByDocumentRecordTypeCode(
        java.lang.String documentRecordTypeCode, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType> findByDocumentRecordTypeCode(
        java.lang.String documentRecordTypeCode, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType findByDocumentRecordTypeCode_First(
        java.lang.String documentRecordTypeCode,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentRecordTypeException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType findByDocumentRecordTypeCode_Last(
        java.lang.String documentRecordTypeCode,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentRecordTypeException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType[] findByDocumentRecordTypeCode_PrevAndNext(
        int documentRecordTypeId, java.lang.String documentRecordTypeCode,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentRecordTypeException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType> findByDocumentRecordTypeName(
        java.lang.String documentRecordTypeName)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType> findByDocumentRecordTypeName(
        java.lang.String documentRecordTypeName, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType> findByDocumentRecordTypeName(
        java.lang.String documentRecordTypeName, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType findByDocumentRecordTypeName_First(
        java.lang.String documentRecordTypeName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentRecordTypeException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType findByDocumentRecordTypeName_Last(
        java.lang.String documentRecordTypeName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentRecordTypeException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType[] findByDocumentRecordTypeName_PrevAndNext(
        int documentRecordTypeId, java.lang.String documentRecordTypeName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentRecordTypeException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeByDocumentRecordTypeCode(
        java.lang.String documentRecordTypeCode)
        throws com.liferay.portal.SystemException;

    public void removeByDocumentRecordTypeName(
        java.lang.String documentRecordTypeName)
        throws com.liferay.portal.SystemException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countByDocumentRecordTypeCode(
        java.lang.String documentRecordTypeCode)
        throws com.liferay.portal.SystemException;

    public int countByDocumentRecordTypeName(
        java.lang.String documentRecordTypeName)
        throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;

    public void registerListener(
        com.liferay.portal.model.ModelListener listener);

    public void unregisterListener(
        com.liferay.portal.model.ModelListener listener);
}
