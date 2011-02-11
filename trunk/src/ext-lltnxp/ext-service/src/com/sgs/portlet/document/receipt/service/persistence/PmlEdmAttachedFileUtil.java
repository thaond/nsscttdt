package com.sgs.portlet.document.receipt.service.persistence;

public class PmlEdmAttachedFileUtil {
    private static PmlEdmAttachedFilePersistence _persistence;

    public static com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile create(
        long attachedFileId) {
        return getPersistence().create(attachedFileId);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile remove(
        long attachedFileId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmAttachedFileException {
        return getPersistence().remove(attachedFileId);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile remove(
        com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile pmlEdmAttachedFile)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(pmlEdmAttachedFile);
    }

    /**
     * @deprecated Use <code>update(PmlEdmAttachedFile pmlEdmAttachedFile, boolean merge)</code>.
     */
    public static com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile update(
        com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile pmlEdmAttachedFile)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(pmlEdmAttachedFile);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlEdmAttachedFile the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlEdmAttachedFile is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public static com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile update(
        com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile pmlEdmAttachedFile,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().update(pmlEdmAttachedFile, merge);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile updateImpl(
        com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile pmlEdmAttachedFile,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(pmlEdmAttachedFile, merge);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile findByPrimaryKey(
        long attachedFileId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmAttachedFileException {
        return getPersistence().findByPrimaryKey(attachedFileId);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile fetchByPrimaryKey(
        long attachedFileId) throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(attachedFileId);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile> findByObjectContentId(
        long objectContentId) throws com.liferay.portal.SystemException {
        return getPersistence().findByObjectContentId(objectContentId);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile> findByObjectContentId(
        long objectContentId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByObjectContentId(objectContentId, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile> findByObjectContentId(
        long objectContentId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByObjectContentId(objectContentId, start, end, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile findByObjectContentId_First(
        long objectContentId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmAttachedFileException {
        return getPersistence().findByObjectContentId_First(objectContentId, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile findByObjectContentId_Last(
        long objectContentId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmAttachedFileException {
        return getPersistence().findByObjectContentId_Last(objectContentId, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile[] findByObjectContentId_PrevAndNext(
        long attachedFileId, long objectContentId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmAttachedFileException {
        return getPersistence()
                   .findByObjectContentId_PrevAndNext(attachedFileId,
            objectContentId, obc);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile> findByObjectType(
        java.lang.String objectType) throws com.liferay.portal.SystemException {
        return getPersistence().findByObjectType(objectType);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile> findByObjectType(
        java.lang.String objectType, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByObjectType(objectType, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile> findByObjectType(
        java.lang.String objectType, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByObjectType(objectType, start, end, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile findByObjectType_First(
        java.lang.String objectType,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmAttachedFileException {
        return getPersistence().findByObjectType_First(objectType, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile findByObjectType_Last(
        java.lang.String objectType,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmAttachedFileException {
        return getPersistence().findByObjectType_Last(objectType, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile[] findByObjectType_PrevAndNext(
        long attachedFileId, java.lang.String objectType,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmAttachedFileException {
        return getPersistence()
                   .findByObjectType_PrevAndNext(attachedFileId, objectType, obc);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile> findByAttachedFileName(
        java.lang.String attachedFileName)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByAttachedFileName(attachedFileName);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile> findByAttachedFileName(
        java.lang.String attachedFileName, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByAttachedFileName(attachedFileName, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile> findByAttachedFileName(
        java.lang.String attachedFileName, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByAttachedFileName(attachedFileName, start, end, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile findByAttachedFileName_First(
        java.lang.String attachedFileName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmAttachedFileException {
        return getPersistence()
                   .findByAttachedFileName_First(attachedFileName, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile findByAttachedFileName_Last(
        java.lang.String attachedFileName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmAttachedFileException {
        return getPersistence()
                   .findByAttachedFileName_Last(attachedFileName, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile[] findByAttachedFileName_PrevAndNext(
        long attachedFileId, java.lang.String attachedFileName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmAttachedFileException {
        return getPersistence()
                   .findByAttachedFileName_PrevAndNext(attachedFileId,
            attachedFileName, obc);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile> findByPath(
        java.lang.String path) throws com.liferay.portal.SystemException {
        return getPersistence().findByPath(path);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile> findByPath(
        java.lang.String path, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByPath(path, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile> findByPath(
        java.lang.String path, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByPath(path, start, end, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile findByPath_First(
        java.lang.String path,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmAttachedFileException {
        return getPersistence().findByPath_First(path, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile findByPath_Last(
        java.lang.String path,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmAttachedFileException {
        return getPersistence().findByPath_Last(path, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile[] findByPath_PrevAndNext(
        long attachedFileId, java.lang.String path,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmAttachedFileException {
        return getPersistence().findByPath_PrevAndNext(attachedFileId, path, obc);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile> findByDateCreated(
        java.util.Date dateCreated) throws com.liferay.portal.SystemException {
        return getPersistence().findByDateCreated(dateCreated);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile> findByDateCreated(
        java.util.Date dateCreated, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByDateCreated(dateCreated, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile> findByDateCreated(
        java.util.Date dateCreated, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByDateCreated(dateCreated, start, end, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile findByDateCreated_First(
        java.util.Date dateCreated,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmAttachedFileException {
        return getPersistence().findByDateCreated_First(dateCreated, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile findByDateCreated_Last(
        java.util.Date dateCreated,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmAttachedFileException {
        return getPersistence().findByDateCreated_Last(dateCreated, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile[] findByDateCreated_PrevAndNext(
        long attachedFileId, java.util.Date dateCreated,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmAttachedFileException {
        return getPersistence()
                   .findByDateCreated_PrevAndNext(attachedFileId, dateCreated,
            obc);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile> findByFileType(
        java.lang.String fileType) throws com.liferay.portal.SystemException {
        return getPersistence().findByFileType(fileType);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile> findByFileType(
        java.lang.String fileType, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByFileType(fileType, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile> findByFileType(
        java.lang.String fileType, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByFileType(fileType, start, end, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile findByFileType_First(
        java.lang.String fileType,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmAttachedFileException {
        return getPersistence().findByFileType_First(fileType, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile findByFileType_Last(
        java.lang.String fileType,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmAttachedFileException {
        return getPersistence().findByFileType_Last(fileType, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile[] findByFileType_PrevAndNext(
        long attachedFileId, java.lang.String fileType,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmAttachedFileException {
        return getPersistence()
                   .findByFileType_PrevAndNext(attachedFileId, fileType, obc);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile> findByFileId(
        int fileId) throws com.liferay.portal.SystemException {
        return getPersistence().findByFileId(fileId);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile> findByFileId(
        int fileId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByFileId(fileId, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile> findByFileId(
        int fileId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByFileId(fileId, start, end, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile findByFileId_First(
        int fileId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmAttachedFileException {
        return getPersistence().findByFileId_First(fileId, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile findByFileId_Last(
        int fileId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmAttachedFileException {
        return getPersistence().findByFileId_Last(fileId, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile[] findByFileId_PrevAndNext(
        long attachedFileId, int fileId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmAttachedFileException {
        return getPersistence()
                   .findByFileId_PrevAndNext(attachedFileId, fileId, obc);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile> findByObjectContentId_ObjectType(
        long objectContentId, java.lang.String objectType)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByObjectContentId_ObjectType(objectContentId, objectType);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile> findByObjectContentId_ObjectType(
        long objectContentId, java.lang.String objectType, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByObjectContentId_ObjectType(objectContentId,
            objectType, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile> findByObjectContentId_ObjectType(
        long objectContentId, java.lang.String objectType, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByObjectContentId_ObjectType(objectContentId,
            objectType, start, end, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile findByObjectContentId_ObjectType_First(
        long objectContentId, java.lang.String objectType,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmAttachedFileException {
        return getPersistence()
                   .findByObjectContentId_ObjectType_First(objectContentId,
            objectType, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile findByObjectContentId_ObjectType_Last(
        long objectContentId, java.lang.String objectType,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmAttachedFileException {
        return getPersistence()
                   .findByObjectContentId_ObjectType_Last(objectContentId,
            objectType, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile[] findByObjectContentId_ObjectType_PrevAndNext(
        long attachedFileId, long objectContentId, java.lang.String objectType,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmAttachedFileException {
        return getPersistence()
                   .findByObjectContentId_ObjectType_PrevAndNext(attachedFileId,
            objectContentId, objectType, obc);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile> findByObjectContentId_ObjectType_D_OR_H(
        long objectContentId, java.lang.String objectType,
        boolean displayOrHidden) throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByObjectContentId_ObjectType_D_OR_H(objectContentId,
            objectType, displayOrHidden);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile> findByObjectContentId_ObjectType_D_OR_H(
        long objectContentId, java.lang.String objectType,
        boolean displayOrHidden, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByObjectContentId_ObjectType_D_OR_H(objectContentId,
            objectType, displayOrHidden, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile> findByObjectContentId_ObjectType_D_OR_H(
        long objectContentId, java.lang.String objectType,
        boolean displayOrHidden, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByObjectContentId_ObjectType_D_OR_H(objectContentId,
            objectType, displayOrHidden, start, end, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile findByObjectContentId_ObjectType_D_OR_H_First(
        long objectContentId, java.lang.String objectType,
        boolean displayOrHidden,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmAttachedFileException {
        return getPersistence()
                   .findByObjectContentId_ObjectType_D_OR_H_First(objectContentId,
            objectType, displayOrHidden, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile findByObjectContentId_ObjectType_D_OR_H_Last(
        long objectContentId, java.lang.String objectType,
        boolean displayOrHidden,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmAttachedFileException {
        return getPersistence()
                   .findByObjectContentId_ObjectType_D_OR_H_Last(objectContentId,
            objectType, displayOrHidden, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile[] findByObjectContentId_ObjectType_D_OR_H_PrevAndNext(
        long attachedFileId, long objectContentId, java.lang.String objectType,
        boolean displayOrHidden,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmAttachedFileException {
        return getPersistence()
                   .findByObjectContentId_ObjectType_D_OR_H_PrevAndNext(attachedFileId,
            objectContentId, objectType, displayOrHidden, obc);
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

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end, obc);
    }

    public static void removeByObjectContentId(long objectContentId)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByObjectContentId(objectContentId);
    }

    public static void removeByObjectType(java.lang.String objectType)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByObjectType(objectType);
    }

    public static void removeByAttachedFileName(
        java.lang.String attachedFileName)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByAttachedFileName(attachedFileName);
    }

    public static void removeByPath(java.lang.String path)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByPath(path);
    }

    public static void removeByDateCreated(java.util.Date dateCreated)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByDateCreated(dateCreated);
    }

    public static void removeByFileType(java.lang.String fileType)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByFileType(fileType);
    }

    public static void removeByFileId(int fileId)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByFileId(fileId);
    }

    public static void removeByObjectContentId_ObjectType(
        long objectContentId, java.lang.String objectType)
        throws com.liferay.portal.SystemException {
        getPersistence()
            .removeByObjectContentId_ObjectType(objectContentId, objectType);
    }

    public static void removeByObjectContentId_ObjectType_D_OR_H(
        long objectContentId, java.lang.String objectType,
        boolean displayOrHidden) throws com.liferay.portal.SystemException {
        getPersistence()
            .removeByObjectContentId_ObjectType_D_OR_H(objectContentId,
            objectType, displayOrHidden);
    }

    public static void removeAll() throws com.liferay.portal.SystemException {
        getPersistence().removeAll();
    }

    public static int countByObjectContentId(long objectContentId)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByObjectContentId(objectContentId);
    }

    public static int countByObjectType(java.lang.String objectType)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByObjectType(objectType);
    }

    public static int countByAttachedFileName(java.lang.String attachedFileName)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByAttachedFileName(attachedFileName);
    }

    public static int countByPath(java.lang.String path)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByPath(path);
    }

    public static int countByDateCreated(java.util.Date dateCreated)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByDateCreated(dateCreated);
    }

    public static int countByFileType(java.lang.String fileType)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByFileType(fileType);
    }

    public static int countByFileId(int fileId)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByFileId(fileId);
    }

    public static int countByObjectContentId_ObjectType(long objectContentId,
        java.lang.String objectType) throws com.liferay.portal.SystemException {
        return getPersistence()
                   .countByObjectContentId_ObjectType(objectContentId,
            objectType);
    }

    public static int countByObjectContentId_ObjectType_D_OR_H(
        long objectContentId, java.lang.String objectType,
        boolean displayOrHidden) throws com.liferay.portal.SystemException {
        return getPersistence()
                   .countByObjectContentId_ObjectType_D_OR_H(objectContentId,
            objectType, displayOrHidden);
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

    public static PmlEdmAttachedFilePersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(PmlEdmAttachedFilePersistence persistence) {
        _persistence = persistence;
    }
}
