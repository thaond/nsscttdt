package com.sgs.portlet.filetype.service.persistence;

public class PmlFileTypeUtil {
    private static PmlFileTypePersistence _persistence;

    public static com.sgs.portlet.filetype.model.PmlFileType create(
        java.lang.String fileTypeId) {
        return getPersistence().create(fileTypeId);
    }

    public static com.sgs.portlet.filetype.model.PmlFileType remove(
        java.lang.String fileTypeId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.filetype.NoSuchPmlFileTypeException {
        return getPersistence().remove(fileTypeId);
    }

    public static com.sgs.portlet.filetype.model.PmlFileType remove(
        com.sgs.portlet.filetype.model.PmlFileType pmlFileType)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(pmlFileType);
    }

    /**
     * @deprecated Use <code>update(PmlFileType pmlFileType, boolean merge)</code>.
     */
    public static com.sgs.portlet.filetype.model.PmlFileType update(
        com.sgs.portlet.filetype.model.PmlFileType pmlFileType)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(pmlFileType);
    }

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
    public static com.sgs.portlet.filetype.model.PmlFileType update(
        com.sgs.portlet.filetype.model.PmlFileType pmlFileType, boolean merge)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(pmlFileType, merge);
    }

    public static com.sgs.portlet.filetype.model.PmlFileType updateImpl(
        com.sgs.portlet.filetype.model.PmlFileType pmlFileType, boolean merge)
        throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(pmlFileType, merge);
    }

    public static com.sgs.portlet.filetype.model.PmlFileType findByPrimaryKey(
        java.lang.String fileTypeId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.filetype.NoSuchPmlFileTypeException {
        return getPersistence().findByPrimaryKey(fileTypeId);
    }

    public static com.sgs.portlet.filetype.model.PmlFileType fetchByPrimaryKey(
        java.lang.String fileTypeId) throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(fileTypeId);
    }

    public static java.util.List<com.sgs.portlet.filetype.model.PmlFileType> findByFileTypeCode(
        java.lang.String fileTypeCode)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByFileTypeCode(fileTypeCode);
    }

    public static java.util.List<com.sgs.portlet.filetype.model.PmlFileType> findByFileTypeCode(
        java.lang.String fileTypeCode, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByFileTypeCode(fileTypeCode, start, end);
    }

    public static java.util.List<com.sgs.portlet.filetype.model.PmlFileType> findByFileTypeCode(
        java.lang.String fileTypeCode, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByFileTypeCode(fileTypeCode, start, end, obc);
    }

    public static com.sgs.portlet.filetype.model.PmlFileType findByFileTypeCode_First(
        java.lang.String fileTypeCode,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.filetype.NoSuchPmlFileTypeException {
        return getPersistence().findByFileTypeCode_First(fileTypeCode, obc);
    }

    public static com.sgs.portlet.filetype.model.PmlFileType findByFileTypeCode_Last(
        java.lang.String fileTypeCode,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.filetype.NoSuchPmlFileTypeException {
        return getPersistence().findByFileTypeCode_Last(fileTypeCode, obc);
    }

    public static com.sgs.portlet.filetype.model.PmlFileType[] findByFileTypeCode_PrevAndNext(
        java.lang.String fileTypeId, java.lang.String fileTypeCode,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.filetype.NoSuchPmlFileTypeException {
        return getPersistence()
                   .findByFileTypeCode_PrevAndNext(fileTypeId, fileTypeCode, obc);
    }

    public static java.util.List<com.sgs.portlet.filetype.model.PmlFileType> findByFileTypeName(
        java.lang.String fileTypeName)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByFileTypeName(fileTypeName);
    }

    public static java.util.List<com.sgs.portlet.filetype.model.PmlFileType> findByFileTypeName(
        java.lang.String fileTypeName, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByFileTypeName(fileTypeName, start, end);
    }

    public static java.util.List<com.sgs.portlet.filetype.model.PmlFileType> findByFileTypeName(
        java.lang.String fileTypeName, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByFileTypeName(fileTypeName, start, end, obc);
    }

    public static com.sgs.portlet.filetype.model.PmlFileType findByFileTypeName_First(
        java.lang.String fileTypeName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.filetype.NoSuchPmlFileTypeException {
        return getPersistence().findByFileTypeName_First(fileTypeName, obc);
    }

    public static com.sgs.portlet.filetype.model.PmlFileType findByFileTypeName_Last(
        java.lang.String fileTypeName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.filetype.NoSuchPmlFileTypeException {
        return getPersistence().findByFileTypeName_Last(fileTypeName, obc);
    }

    public static com.sgs.portlet.filetype.model.PmlFileType[] findByFileTypeName_PrevAndNext(
        java.lang.String fileTypeId, java.lang.String fileTypeName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.filetype.NoSuchPmlFileTypeException {
        return getPersistence()
                   .findByFileTypeName_PrevAndNext(fileTypeId, fileTypeName, obc);
    }

    public static java.util.List<com.sgs.portlet.filetype.model.PmlFileType> findByDescription(
        java.lang.String description) throws com.liferay.portal.SystemException {
        return getPersistence().findByDescription(description);
    }

    public static java.util.List<com.sgs.portlet.filetype.model.PmlFileType> findByDescription(
        java.lang.String description, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByDescription(description, start, end);
    }

    public static java.util.List<com.sgs.portlet.filetype.model.PmlFileType> findByDescription(
        java.lang.String description, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByDescription(description, start, end, obc);
    }

    public static com.sgs.portlet.filetype.model.PmlFileType findByDescription_First(
        java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.filetype.NoSuchPmlFileTypeException {
        return getPersistence().findByDescription_First(description, obc);
    }

    public static com.sgs.portlet.filetype.model.PmlFileType findByDescription_Last(
        java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.filetype.NoSuchPmlFileTypeException {
        return getPersistence().findByDescription_Last(description, obc);
    }

    public static com.sgs.portlet.filetype.model.PmlFileType[] findByDescription_PrevAndNext(
        java.lang.String fileTypeId, java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.filetype.NoSuchPmlFileTypeException {
        return getPersistence()
                   .findByDescription_PrevAndNext(fileTypeId, description, obc);
    }

    public static java.util.List<com.sgs.portlet.filetype.model.PmlFileType> findByFieldId(
        java.lang.String fieldId) throws com.liferay.portal.SystemException {
        return getPersistence().findByFieldId(fieldId);
    }

    public static java.util.List<com.sgs.portlet.filetype.model.PmlFileType> findByFieldId(
        java.lang.String fieldId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByFieldId(fieldId, start, end);
    }

    public static java.util.List<com.sgs.portlet.filetype.model.PmlFileType> findByFieldId(
        java.lang.String fieldId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByFieldId(fieldId, start, end, obc);
    }

    public static com.sgs.portlet.filetype.model.PmlFileType findByFieldId_First(
        java.lang.String fieldId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.filetype.NoSuchPmlFileTypeException {
        return getPersistence().findByFieldId_First(fieldId, obc);
    }

    public static com.sgs.portlet.filetype.model.PmlFileType findByFieldId_Last(
        java.lang.String fieldId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.filetype.NoSuchPmlFileTypeException {
        return getPersistence().findByFieldId_Last(fieldId, obc);
    }

    public static com.sgs.portlet.filetype.model.PmlFileType[] findByFieldId_PrevAndNext(
        java.lang.String fileTypeId, java.lang.String fieldId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.filetype.NoSuchPmlFileTypeException {
        return getPersistence()
                   .findByFieldId_PrevAndNext(fileTypeId, fieldId, obc);
    }

    public static java.util.List<com.sgs.portlet.filetype.model.PmlFileType> findByReceiptTemplate(
        java.lang.String receiptTemplate)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByReceiptTemplate(receiptTemplate);
    }

    public static java.util.List<com.sgs.portlet.filetype.model.PmlFileType> findByReceiptTemplate(
        java.lang.String receiptTemplate, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByReceiptTemplate(receiptTemplate, start, end);
    }

    public static java.util.List<com.sgs.portlet.filetype.model.PmlFileType> findByReceiptTemplate(
        java.lang.String receiptTemplate, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByReceiptTemplate(receiptTemplate, start, end, obc);
    }

    public static com.sgs.portlet.filetype.model.PmlFileType findByReceiptTemplate_First(
        java.lang.String receiptTemplate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.filetype.NoSuchPmlFileTypeException {
        return getPersistence().findByReceiptTemplate_First(receiptTemplate, obc);
    }

    public static com.sgs.portlet.filetype.model.PmlFileType findByReceiptTemplate_Last(
        java.lang.String receiptTemplate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.filetype.NoSuchPmlFileTypeException {
        return getPersistence().findByReceiptTemplate_Last(receiptTemplate, obc);
    }

    public static com.sgs.portlet.filetype.model.PmlFileType[] findByReceiptTemplate_PrevAndNext(
        java.lang.String fileTypeId, java.lang.String receiptTemplate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.filetype.NoSuchPmlFileTypeException {
        return getPersistence()
                   .findByReceiptTemplate_PrevAndNext(fileTypeId,
            receiptTemplate, obc);
    }

    public static java.util.List<com.sgs.portlet.filetype.model.PmlFileType> findByFileTypeCode_FileTypeName(
        java.lang.String fileTypeCode, java.lang.String fileTypeName)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByFileTypeCode_FileTypeName(fileTypeCode, fileTypeName);
    }

    public static java.util.List<com.sgs.portlet.filetype.model.PmlFileType> findByFileTypeCode_FileTypeName(
        java.lang.String fileTypeCode, java.lang.String fileTypeName,
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByFileTypeCode_FileTypeName(fileTypeCode, fileTypeName,
            start, end);
    }

    public static java.util.List<com.sgs.portlet.filetype.model.PmlFileType> findByFileTypeCode_FileTypeName(
        java.lang.String fileTypeCode, java.lang.String fileTypeName,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByFileTypeCode_FileTypeName(fileTypeCode, fileTypeName,
            start, end, obc);
    }

    public static com.sgs.portlet.filetype.model.PmlFileType findByFileTypeCode_FileTypeName_First(
        java.lang.String fileTypeCode, java.lang.String fileTypeName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.filetype.NoSuchPmlFileTypeException {
        return getPersistence()
                   .findByFileTypeCode_FileTypeName_First(fileTypeCode,
            fileTypeName, obc);
    }

    public static com.sgs.portlet.filetype.model.PmlFileType findByFileTypeCode_FileTypeName_Last(
        java.lang.String fileTypeCode, java.lang.String fileTypeName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.filetype.NoSuchPmlFileTypeException {
        return getPersistence()
                   .findByFileTypeCode_FileTypeName_Last(fileTypeCode,
            fileTypeName, obc);
    }

    public static com.sgs.portlet.filetype.model.PmlFileType[] findByFileTypeCode_FileTypeName_PrevAndNext(
        java.lang.String fileTypeId, java.lang.String fileTypeCode,
        java.lang.String fileTypeName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.filetype.NoSuchPmlFileTypeException {
        return getPersistence()
                   .findByFileTypeCode_FileTypeName_PrevAndNext(fileTypeId,
            fileTypeCode, fileTypeName, obc);
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

    public static java.util.List<com.sgs.portlet.filetype.model.PmlFileType> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.sgs.portlet.filetype.model.PmlFileType> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.sgs.portlet.filetype.model.PmlFileType> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end, obc);
    }

    public static void removeByFileTypeCode(java.lang.String fileTypeCode)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByFileTypeCode(fileTypeCode);
    }

    public static void removeByFileTypeName(java.lang.String fileTypeName)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByFileTypeName(fileTypeName);
    }

    public static void removeByDescription(java.lang.String description)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByDescription(description);
    }

    public static void removeByFieldId(java.lang.String fieldId)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByFieldId(fieldId);
    }

    public static void removeByReceiptTemplate(java.lang.String receiptTemplate)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByReceiptTemplate(receiptTemplate);
    }

    public static void removeByFileTypeCode_FileTypeName(
        java.lang.String fileTypeCode, java.lang.String fileTypeName)
        throws com.liferay.portal.SystemException {
        getPersistence()
            .removeByFileTypeCode_FileTypeName(fileTypeCode, fileTypeName);
    }

    public static void removeAll() throws com.liferay.portal.SystemException {
        getPersistence().removeAll();
    }

    public static int countByFileTypeCode(java.lang.String fileTypeCode)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByFileTypeCode(fileTypeCode);
    }

    public static int countByFileTypeName(java.lang.String fileTypeName)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByFileTypeName(fileTypeName);
    }

    public static int countByDescription(java.lang.String description)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByDescription(description);
    }

    public static int countByFieldId(java.lang.String fieldId)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByFieldId(fieldId);
    }

    public static int countByReceiptTemplate(java.lang.String receiptTemplate)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByReceiptTemplate(receiptTemplate);
    }

    public static int countByFileTypeCode_FileTypeName(
        java.lang.String fileTypeCode, java.lang.String fileTypeName)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .countByFileTypeCode_FileTypeName(fileTypeCode, fileTypeName);
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

    public static PmlFileTypePersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(PmlFileTypePersistence persistence) {
        _persistence = persistence;
    }
}
