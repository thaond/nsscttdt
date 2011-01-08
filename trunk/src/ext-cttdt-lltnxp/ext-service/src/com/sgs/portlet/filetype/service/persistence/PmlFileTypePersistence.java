package com.sgs.portlet.filetype.service.persistence;

public interface PmlFileTypePersistence {
    public com.sgs.portlet.filetype.model.PmlFileType create(
        java.lang.String fileTypeId);

    public com.sgs.portlet.filetype.model.PmlFileType remove(
        java.lang.String fileTypeId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.filetype.NoSuchPmlFileTypeException;

    public com.sgs.portlet.filetype.model.PmlFileType remove(
        com.sgs.portlet.filetype.model.PmlFileType pmlFileType)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(PmlFileType pmlFileType, boolean merge)</code>.
     */
    public com.sgs.portlet.filetype.model.PmlFileType update(
        com.sgs.portlet.filetype.model.PmlFileType pmlFileType)
        throws com.liferay.portal.SystemException;

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlFileType the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlFileType is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public com.sgs.portlet.filetype.model.PmlFileType update(
        com.sgs.portlet.filetype.model.PmlFileType pmlFileType, boolean merge)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.filetype.model.PmlFileType updateImpl(
        com.sgs.portlet.filetype.model.PmlFileType pmlFileType, boolean merge)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.filetype.model.PmlFileType findByPrimaryKey(
        java.lang.String fileTypeId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.filetype.NoSuchPmlFileTypeException;

    public com.sgs.portlet.filetype.model.PmlFileType fetchByPrimaryKey(
        java.lang.String fileTypeId) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.filetype.model.PmlFileType> findByFileTypeCode(
        java.lang.String fileTypeCode)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.filetype.model.PmlFileType> findByFileTypeCode(
        java.lang.String fileTypeCode, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.filetype.model.PmlFileType> findByFileTypeCode(
        java.lang.String fileTypeCode, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.filetype.model.PmlFileType findByFileTypeCode_First(
        java.lang.String fileTypeCode,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.filetype.NoSuchPmlFileTypeException;

    public com.sgs.portlet.filetype.model.PmlFileType findByFileTypeCode_Last(
        java.lang.String fileTypeCode,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.filetype.NoSuchPmlFileTypeException;

    public com.sgs.portlet.filetype.model.PmlFileType[] findByFileTypeCode_PrevAndNext(
        java.lang.String fileTypeId, java.lang.String fileTypeCode,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.filetype.NoSuchPmlFileTypeException;

    public java.util.List<com.sgs.portlet.filetype.model.PmlFileType> findByFileTypeName(
        java.lang.String fileTypeName)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.filetype.model.PmlFileType> findByFileTypeName(
        java.lang.String fileTypeName, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.filetype.model.PmlFileType> findByFileTypeName(
        java.lang.String fileTypeName, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.filetype.model.PmlFileType findByFileTypeName_First(
        java.lang.String fileTypeName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.filetype.NoSuchPmlFileTypeException;

    public com.sgs.portlet.filetype.model.PmlFileType findByFileTypeName_Last(
        java.lang.String fileTypeName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.filetype.NoSuchPmlFileTypeException;

    public com.sgs.portlet.filetype.model.PmlFileType[] findByFileTypeName_PrevAndNext(
        java.lang.String fileTypeId, java.lang.String fileTypeName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.filetype.NoSuchPmlFileTypeException;

    public java.util.List<com.sgs.portlet.filetype.model.PmlFileType> findByDescription(
        java.lang.String description) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.filetype.model.PmlFileType> findByDescription(
        java.lang.String description, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.filetype.model.PmlFileType> findByDescription(
        java.lang.String description, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.filetype.model.PmlFileType findByDescription_First(
        java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.filetype.NoSuchPmlFileTypeException;

    public com.sgs.portlet.filetype.model.PmlFileType findByDescription_Last(
        java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.filetype.NoSuchPmlFileTypeException;

    public com.sgs.portlet.filetype.model.PmlFileType[] findByDescription_PrevAndNext(
        java.lang.String fileTypeId, java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.filetype.NoSuchPmlFileTypeException;

    public java.util.List<com.sgs.portlet.filetype.model.PmlFileType> findByFieldId(
        java.lang.String fieldId) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.filetype.model.PmlFileType> findByFieldId(
        java.lang.String fieldId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.filetype.model.PmlFileType> findByFieldId(
        java.lang.String fieldId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.filetype.model.PmlFileType findByFieldId_First(
        java.lang.String fieldId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.filetype.NoSuchPmlFileTypeException;

    public com.sgs.portlet.filetype.model.PmlFileType findByFieldId_Last(
        java.lang.String fieldId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.filetype.NoSuchPmlFileTypeException;

    public com.sgs.portlet.filetype.model.PmlFileType[] findByFieldId_PrevAndNext(
        java.lang.String fileTypeId, java.lang.String fieldId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.filetype.NoSuchPmlFileTypeException;

    public java.util.List<com.sgs.portlet.filetype.model.PmlFileType> findByReceiptTemplate(
        java.lang.String receiptTemplate)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.filetype.model.PmlFileType> findByReceiptTemplate(
        java.lang.String receiptTemplate, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.filetype.model.PmlFileType> findByReceiptTemplate(
        java.lang.String receiptTemplate, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.filetype.model.PmlFileType findByReceiptTemplate_First(
        java.lang.String receiptTemplate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.filetype.NoSuchPmlFileTypeException;

    public com.sgs.portlet.filetype.model.PmlFileType findByReceiptTemplate_Last(
        java.lang.String receiptTemplate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.filetype.NoSuchPmlFileTypeException;

    public com.sgs.portlet.filetype.model.PmlFileType[] findByReceiptTemplate_PrevAndNext(
        java.lang.String fileTypeId, java.lang.String receiptTemplate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.filetype.NoSuchPmlFileTypeException;

    public java.util.List<com.sgs.portlet.filetype.model.PmlFileType> findByFileTypeCode_FileTypeName(
        java.lang.String fileTypeCode, java.lang.String fileTypeName)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.filetype.model.PmlFileType> findByFileTypeCode_FileTypeName(
        java.lang.String fileTypeCode, java.lang.String fileTypeName,
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.filetype.model.PmlFileType> findByFileTypeCode_FileTypeName(
        java.lang.String fileTypeCode, java.lang.String fileTypeName,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.filetype.model.PmlFileType findByFileTypeCode_FileTypeName_First(
        java.lang.String fileTypeCode, java.lang.String fileTypeName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.filetype.NoSuchPmlFileTypeException;

    public com.sgs.portlet.filetype.model.PmlFileType findByFileTypeCode_FileTypeName_Last(
        java.lang.String fileTypeCode, java.lang.String fileTypeName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.filetype.NoSuchPmlFileTypeException;

    public com.sgs.portlet.filetype.model.PmlFileType[] findByFileTypeCode_FileTypeName_PrevAndNext(
        java.lang.String fileTypeId, java.lang.String fileTypeCode,
        java.lang.String fileTypeName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.filetype.NoSuchPmlFileTypeException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.filetype.model.PmlFileType> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.filetype.model.PmlFileType> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.filetype.model.PmlFileType> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeByFileTypeCode(java.lang.String fileTypeCode)
        throws com.liferay.portal.SystemException;

    public void removeByFileTypeName(java.lang.String fileTypeName)
        throws com.liferay.portal.SystemException;

    public void removeByDescription(java.lang.String description)
        throws com.liferay.portal.SystemException;

    public void removeByFieldId(java.lang.String fieldId)
        throws com.liferay.portal.SystemException;

    public void removeByReceiptTemplate(java.lang.String receiptTemplate)
        throws com.liferay.portal.SystemException;

    public void removeByFileTypeCode_FileTypeName(
        java.lang.String fileTypeCode, java.lang.String fileTypeName)
        throws com.liferay.portal.SystemException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countByFileTypeCode(java.lang.String fileTypeCode)
        throws com.liferay.portal.SystemException;

    public int countByFileTypeName(java.lang.String fileTypeName)
        throws com.liferay.portal.SystemException;

    public int countByDescription(java.lang.String description)
        throws com.liferay.portal.SystemException;

    public int countByFieldId(java.lang.String fieldId)
        throws com.liferay.portal.SystemException;

    public int countByReceiptTemplate(java.lang.String receiptTemplate)
        throws com.liferay.portal.SystemException;

    public int countByFileTypeCode_FileTypeName(java.lang.String fileTypeCode,
        java.lang.String fileTypeName)
        throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;

    public void registerListener(
        com.liferay.portal.model.ModelListener listener);

    public void unregisterListener(
        com.liferay.portal.model.ModelListener listener);
}
