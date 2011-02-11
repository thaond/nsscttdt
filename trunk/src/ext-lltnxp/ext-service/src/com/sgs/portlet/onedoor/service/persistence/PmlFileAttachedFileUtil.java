package com.sgs.portlet.onedoor.service.persistence;

public class PmlFileAttachedFileUtil {
    private static PmlFileAttachedFilePersistence _persistence;

    public static com.sgs.portlet.onedoor.model.PmlFileAttachedFile create(
        java.lang.String fileAttachedFileId) {
        return getPersistence().create(fileAttachedFileId);
    }

    public static com.sgs.portlet.onedoor.model.PmlFileAttachedFile remove(
        java.lang.String fileAttachedFileId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchAttachedFileException {
        return getPersistence().remove(fileAttachedFileId);
    }

    public static com.sgs.portlet.onedoor.model.PmlFileAttachedFile remove(
        com.sgs.portlet.onedoor.model.PmlFileAttachedFile pmlFileAttachedFile)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(pmlFileAttachedFile);
    }

    /**
     * @deprecated Use <code>update(PmlFileAttachedFile pmlFileAttachedFile, boolean merge)</code>.
     */
    public static com.sgs.portlet.onedoor.model.PmlFileAttachedFile update(
        com.sgs.portlet.onedoor.model.PmlFileAttachedFile pmlFileAttachedFile)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(pmlFileAttachedFile);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlFileAttachedFile the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlFileAttachedFile is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public static com.sgs.portlet.onedoor.model.PmlFileAttachedFile update(
        com.sgs.portlet.onedoor.model.PmlFileAttachedFile pmlFileAttachedFile,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().update(pmlFileAttachedFile, merge);
    }

    public static com.sgs.portlet.onedoor.model.PmlFileAttachedFile updateImpl(
        com.sgs.portlet.onedoor.model.PmlFileAttachedFile pmlFileAttachedFile,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(pmlFileAttachedFile, merge);
    }

    public static com.sgs.portlet.onedoor.model.PmlFileAttachedFile findByPrimaryKey(
        java.lang.String fileAttachedFileId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchAttachedFileException {
        return getPersistence().findByPrimaryKey(fileAttachedFileId);
    }

    public static com.sgs.portlet.onedoor.model.PmlFileAttachedFile fetchByPrimaryKey(
        java.lang.String fileAttachedFileId)
        throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(fileAttachedFileId);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlFileAttachedFile> findByFileId(
        java.lang.String fileId) throws com.liferay.portal.SystemException {
        return getPersistence().findByFileId(fileId);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlFileAttachedFile> findByFileId(
        java.lang.String fileId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByFileId(fileId, start, end);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlFileAttachedFile> findByFileId(
        java.lang.String fileId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByFileId(fileId, start, end, obc);
    }

    public static com.sgs.portlet.onedoor.model.PmlFileAttachedFile findByFileId_First(
        java.lang.String fileId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchAttachedFileException {
        return getPersistence().findByFileId_First(fileId, obc);
    }

    public static com.sgs.portlet.onedoor.model.PmlFileAttachedFile findByFileId_Last(
        java.lang.String fileId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchAttachedFileException {
        return getPersistence().findByFileId_Last(fileId, obc);
    }

    public static com.sgs.portlet.onedoor.model.PmlFileAttachedFile[] findByFileId_PrevAndNext(
        java.lang.String fileAttachedFileId, java.lang.String fileId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchAttachedFileException {
        return getPersistence()
                   .findByFileId_PrevAndNext(fileAttachedFileId, fileId, obc);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlFileAttachedFile> findByAttachedFileId(
        java.lang.String attachedFileId)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByAttachedFileId(attachedFileId);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlFileAttachedFile> findByAttachedFileId(
        java.lang.String attachedFileId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByAttachedFileId(attachedFileId, start, end);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlFileAttachedFile> findByAttachedFileId(
        java.lang.String attachedFileId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByAttachedFileId(attachedFileId, start, end, obc);
    }

    public static com.sgs.portlet.onedoor.model.PmlFileAttachedFile findByAttachedFileId_First(
        java.lang.String attachedFileId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchAttachedFileException {
        return getPersistence().findByAttachedFileId_First(attachedFileId, obc);
    }

    public static com.sgs.portlet.onedoor.model.PmlFileAttachedFile findByAttachedFileId_Last(
        java.lang.String attachedFileId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchAttachedFileException {
        return getPersistence().findByAttachedFileId_Last(attachedFileId, obc);
    }

    public static com.sgs.portlet.onedoor.model.PmlFileAttachedFile[] findByAttachedFileId_PrevAndNext(
        java.lang.String fileAttachedFileId, java.lang.String attachedFileId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchAttachedFileException {
        return getPersistence()
                   .findByAttachedFileId_PrevAndNext(fileAttachedFileId,
            attachedFileId, obc);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlFileAttachedFile> findByAttachedFileName(
        java.lang.String attachedFileName)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByAttachedFileName(attachedFileName);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlFileAttachedFile> findByAttachedFileName(
        java.lang.String attachedFileName, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByAttachedFileName(attachedFileName, start, end);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlFileAttachedFile> findByAttachedFileName(
        java.lang.String attachedFileName, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByAttachedFileName(attachedFileName, start, end, obc);
    }

    public static com.sgs.portlet.onedoor.model.PmlFileAttachedFile findByAttachedFileName_First(
        java.lang.String attachedFileName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchAttachedFileException {
        return getPersistence()
                   .findByAttachedFileName_First(attachedFileName, obc);
    }

    public static com.sgs.portlet.onedoor.model.PmlFileAttachedFile findByAttachedFileName_Last(
        java.lang.String attachedFileName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchAttachedFileException {
        return getPersistence()
                   .findByAttachedFileName_Last(attachedFileName, obc);
    }

    public static com.sgs.portlet.onedoor.model.PmlFileAttachedFile[] findByAttachedFileName_PrevAndNext(
        java.lang.String fileAttachedFileId, java.lang.String attachedFileName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchAttachedFileException {
        return getPersistence()
                   .findByAttachedFileName_PrevAndNext(fileAttachedFileId,
            attachedFileName, obc);
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

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlFileAttachedFile> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlFileAttachedFile> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlFileAttachedFile> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end, obc);
    }

    public static void removeByFileId(java.lang.String fileId)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByFileId(fileId);
    }

    public static void removeByAttachedFileId(java.lang.String attachedFileId)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByAttachedFileId(attachedFileId);
    }

    public static void removeByAttachedFileName(
        java.lang.String attachedFileName)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByAttachedFileName(attachedFileName);
    }

    public static void removeAll() throws com.liferay.portal.SystemException {
        getPersistence().removeAll();
    }

    public static int countByFileId(java.lang.String fileId)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByFileId(fileId);
    }

    public static int countByAttachedFileId(java.lang.String attachedFileId)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByAttachedFileId(attachedFileId);
    }

    public static int countByAttachedFileName(java.lang.String attachedFileName)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByAttachedFileName(attachedFileName);
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

    public static PmlFileAttachedFilePersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(PmlFileAttachedFilePersistence persistence) {
        _persistence = persistence;
    }
}
