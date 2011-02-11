package com.sgs.portlet.onedoorpccc.service.persistence;

public class PmlFilePCCCAttachedFileUtil {
    private static PmlFilePCCCAttachedFilePersistence _persistence;

    public static com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile create(
        long attachedFileId) {
        return getPersistence().create(attachedFileId);
    }

    public static com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile remove(
        long attachedFileId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchAttachedFileException {
        return getPersistence().remove(attachedFileId);
    }

    public static com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile remove(
        com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile pmlFilePCCCAttachedFile)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(pmlFilePCCCAttachedFile);
    }

    /**
     * @deprecated Use <code>update(PmlFilePCCCAttachedFile pmlFilePCCCAttachedFile, boolean merge)</code>.
     */
    public static com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile update(
        com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile pmlFilePCCCAttachedFile)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(pmlFilePCCCAttachedFile);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlFilePCCCAttachedFile the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlFilePCCCAttachedFile is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public static com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile update(
        com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile pmlFilePCCCAttachedFile,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().update(pmlFilePCCCAttachedFile, merge);
    }

    public static com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile updateImpl(
        com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile pmlFilePCCCAttachedFile,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(pmlFilePCCCAttachedFile, merge);
    }

    public static com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile findByPrimaryKey(
        long attachedFileId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchAttachedFileException {
        return getPersistence().findByPrimaryKey(attachedFileId);
    }

    public static com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile fetchByPrimaryKey(
        long attachedFileId) throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(attachedFileId);
    }

    public static java.util.List<com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile> findByFilePcccId(
        java.lang.String filePcccId) throws com.liferay.portal.SystemException {
        return getPersistence().findByFilePcccId(filePcccId);
    }

    public static java.util.List<com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile> findByFilePcccId(
        java.lang.String filePcccId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByFilePcccId(filePcccId, start, end);
    }

    public static java.util.List<com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile> findByFilePcccId(
        java.lang.String filePcccId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByFilePcccId(filePcccId, start, end, obc);
    }

    public static com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile findByFilePcccId_First(
        java.lang.String filePcccId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchAttachedFileException {
        return getPersistence().findByFilePcccId_First(filePcccId, obc);
    }

    public static com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile findByFilePcccId_Last(
        java.lang.String filePcccId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchAttachedFileException {
        return getPersistence().findByFilePcccId_Last(filePcccId, obc);
    }

    public static com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile[] findByFilePcccId_PrevAndNext(
        long attachedFileId, java.lang.String filePcccId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchAttachedFileException {
        return getPersistence()
                   .findByFilePcccId_PrevAndNext(attachedFileId, filePcccId, obc);
    }

    public static java.util.List<com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile> findByObjectType(
        java.lang.String objectType) throws com.liferay.portal.SystemException {
        return getPersistence().findByObjectType(objectType);
    }

    public static java.util.List<com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile> findByObjectType(
        java.lang.String objectType, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByObjectType(objectType, start, end);
    }

    public static java.util.List<com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile> findByObjectType(
        java.lang.String objectType, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByObjectType(objectType, start, end, obc);
    }

    public static com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile findByObjectType_First(
        java.lang.String objectType,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchAttachedFileException {
        return getPersistence().findByObjectType_First(objectType, obc);
    }

    public static com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile findByObjectType_Last(
        java.lang.String objectType,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchAttachedFileException {
        return getPersistence().findByObjectType_Last(objectType, obc);
    }

    public static com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile[] findByObjectType_PrevAndNext(
        long attachedFileId, java.lang.String objectType,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchAttachedFileException {
        return getPersistence()
                   .findByObjectType_PrevAndNext(attachedFileId, objectType, obc);
    }

    public static java.util.List<com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile> findByAttachedFileName(
        java.lang.String attachedFileName)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByAttachedFileName(attachedFileName);
    }

    public static java.util.List<com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile> findByAttachedFileName(
        java.lang.String attachedFileName, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByAttachedFileName(attachedFileName, start, end);
    }

    public static java.util.List<com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile> findByAttachedFileName(
        java.lang.String attachedFileName, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByAttachedFileName(attachedFileName, start, end, obc);
    }

    public static com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile findByAttachedFileName_First(
        java.lang.String attachedFileName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchAttachedFileException {
        return getPersistence()
                   .findByAttachedFileName_First(attachedFileName, obc);
    }

    public static com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile findByAttachedFileName_Last(
        java.lang.String attachedFileName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchAttachedFileException {
        return getPersistence()
                   .findByAttachedFileName_Last(attachedFileName, obc);
    }

    public static com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile[] findByAttachedFileName_PrevAndNext(
        long attachedFileId, java.lang.String attachedFileName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchAttachedFileException {
        return getPersistence()
                   .findByAttachedFileName_PrevAndNext(attachedFileId,
            attachedFileName, obc);
    }

    public static java.util.List<com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile> findByPath(
        java.lang.String path) throws com.liferay.portal.SystemException {
        return getPersistence().findByPath(path);
    }

    public static java.util.List<com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile> findByPath(
        java.lang.String path, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByPath(path, start, end);
    }

    public static java.util.List<com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile> findByPath(
        java.lang.String path, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByPath(path, start, end, obc);
    }

    public static com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile findByPath_First(
        java.lang.String path,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchAttachedFileException {
        return getPersistence().findByPath_First(path, obc);
    }

    public static com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile findByPath_Last(
        java.lang.String path,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchAttachedFileException {
        return getPersistence().findByPath_Last(path, obc);
    }

    public static com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile[] findByPath_PrevAndNext(
        long attachedFileId, java.lang.String path,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchAttachedFileException {
        return getPersistence().findByPath_PrevAndNext(attachedFileId, path, obc);
    }

    public static java.util.List<com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile> findByDateCreated(
        java.util.Date dateCreated) throws com.liferay.portal.SystemException {
        return getPersistence().findByDateCreated(dateCreated);
    }

    public static java.util.List<com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile> findByDateCreated(
        java.util.Date dateCreated, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByDateCreated(dateCreated, start, end);
    }

    public static java.util.List<com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile> findByDateCreated(
        java.util.Date dateCreated, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByDateCreated(dateCreated, start, end, obc);
    }

    public static com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile findByDateCreated_First(
        java.util.Date dateCreated,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchAttachedFileException {
        return getPersistence().findByDateCreated_First(dateCreated, obc);
    }

    public static com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile findByDateCreated_Last(
        java.util.Date dateCreated,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchAttachedFileException {
        return getPersistence().findByDateCreated_Last(dateCreated, obc);
    }

    public static com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile[] findByDateCreated_PrevAndNext(
        long attachedFileId, java.util.Date dateCreated,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchAttachedFileException {
        return getPersistence()
                   .findByDateCreated_PrevAndNext(attachedFileId, dateCreated,
            obc);
    }

    public static java.util.List<com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile> findByFileType(
        java.lang.String fileType) throws com.liferay.portal.SystemException {
        return getPersistence().findByFileType(fileType);
    }

    public static java.util.List<com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile> findByFileType(
        java.lang.String fileType, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByFileType(fileType, start, end);
    }

    public static java.util.List<com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile> findByFileType(
        java.lang.String fileType, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByFileType(fileType, start, end, obc);
    }

    public static com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile findByFileType_First(
        java.lang.String fileType,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchAttachedFileException {
        return getPersistence().findByFileType_First(fileType, obc);
    }

    public static com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile findByFileType_Last(
        java.lang.String fileType,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchAttachedFileException {
        return getPersistence().findByFileType_Last(fileType, obc);
    }

    public static com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile[] findByFileType_PrevAndNext(
        long attachedFileId, java.lang.String fileType,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchAttachedFileException {
        return getPersistence()
                   .findByFileType_PrevAndNext(attachedFileId, fileType, obc);
    }

    public static java.util.List<com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile> findByFilePcccId_ObjectType(
        java.lang.String filePcccId, java.lang.String objectType)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByFilePcccId_ObjectType(filePcccId, objectType);
    }

    public static java.util.List<com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile> findByFilePcccId_ObjectType(
        java.lang.String filePcccId, java.lang.String objectType, int start,
        int end) throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByFilePcccId_ObjectType(filePcccId, objectType, start,
            end);
    }

    public static java.util.List<com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile> findByFilePcccId_ObjectType(
        java.lang.String filePcccId, java.lang.String objectType, int start,
        int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByFilePcccId_ObjectType(filePcccId, objectType, start,
            end, obc);
    }

    public static com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile findByFilePcccId_ObjectType_First(
        java.lang.String filePcccId, java.lang.String objectType,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchAttachedFileException {
        return getPersistence()
                   .findByFilePcccId_ObjectType_First(filePcccId, objectType,
            obc);
    }

    public static com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile findByFilePcccId_ObjectType_Last(
        java.lang.String filePcccId, java.lang.String objectType,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchAttachedFileException {
        return getPersistence()
                   .findByFilePcccId_ObjectType_Last(filePcccId, objectType, obc);
    }

    public static com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile[] findByFilePcccId_ObjectType_PrevAndNext(
        long attachedFileId, java.lang.String filePcccId,
        java.lang.String objectType,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchAttachedFileException {
        return getPersistence()
                   .findByFilePcccId_ObjectType_PrevAndNext(attachedFileId,
            filePcccId, objectType, obc);
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

    public static java.util.List<com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end, obc);
    }

    public static void removeByFilePcccId(java.lang.String filePcccId)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByFilePcccId(filePcccId);
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

    public static void removeByFilePcccId_ObjectType(
        java.lang.String filePcccId, java.lang.String objectType)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByFilePcccId_ObjectType(filePcccId, objectType);
    }

    public static void removeAll() throws com.liferay.portal.SystemException {
        getPersistence().removeAll();
    }

    public static int countByFilePcccId(java.lang.String filePcccId)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByFilePcccId(filePcccId);
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

    public static int countByFilePcccId_ObjectType(
        java.lang.String filePcccId, java.lang.String objectType)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .countByFilePcccId_ObjectType(filePcccId, objectType);
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

    public static PmlFilePCCCAttachedFilePersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(PmlFilePCCCAttachedFilePersistence persistence) {
        _persistence = persistence;
    }
}
