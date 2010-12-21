package com.nss.portlet.attachedfile.service.persistence;

public class AttachedFileUtil {
    private static AttachedFilePersistence _persistence;

    public static void cacheResult(
        com.nss.portlet.attachedfile.model.AttachedFile attachedFile) {
        getPersistence().cacheResult(attachedFile);
    }

    public static void cacheResult(
        java.util.List<com.nss.portlet.attachedfile.model.AttachedFile> attachedFiles) {
        getPersistence().cacheResult(attachedFiles);
    }

    public static void clearCache() {
        getPersistence().clearCache();
    }

    public static com.nss.portlet.attachedfile.model.AttachedFile create(
        java.lang.String attachedFileId) {
        return getPersistence().create(attachedFileId);
    }

    public static com.nss.portlet.attachedfile.model.AttachedFile remove(
        java.lang.String attachedFileId)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.attachedfile.NoSuchAttachedFileException {
        return getPersistence().remove(attachedFileId);
    }

    public static com.nss.portlet.attachedfile.model.AttachedFile remove(
        com.nss.portlet.attachedfile.model.AttachedFile attachedFile)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(attachedFile);
    }

    /**
     * @deprecated Use <code>update(AttachedFile attachedFile, boolean merge)</code>.
     */
    public static com.nss.portlet.attachedfile.model.AttachedFile update(
        com.nss.portlet.attachedfile.model.AttachedFile attachedFile)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(attachedFile);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                attachedFile the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when attachedFile is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public static com.nss.portlet.attachedfile.model.AttachedFile update(
        com.nss.portlet.attachedfile.model.AttachedFile attachedFile,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().update(attachedFile, merge);
    }

    public static com.nss.portlet.attachedfile.model.AttachedFile updateImpl(
        com.nss.portlet.attachedfile.model.AttachedFile attachedFile,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(attachedFile, merge);
    }

    public static com.nss.portlet.attachedfile.model.AttachedFile findByPrimaryKey(
        java.lang.String attachedFileId)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.attachedfile.NoSuchAttachedFileException {
        return getPersistence().findByPrimaryKey(attachedFileId);
    }

    public static com.nss.portlet.attachedfile.model.AttachedFile fetchByPrimaryKey(
        java.lang.String attachedFileId)
        throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(attachedFileId);
    }

    public static java.util.List<com.nss.portlet.attachedfile.model.AttachedFile> findByAttachedFileCode(
        java.lang.String attachedFileCode)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByAttachedFileCode(attachedFileCode);
    }

    public static java.util.List<com.nss.portlet.attachedfile.model.AttachedFile> findByAttachedFileCode(
        java.lang.String attachedFileCode, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByAttachedFileCode(attachedFileCode, start, end);
    }

    public static java.util.List<com.nss.portlet.attachedfile.model.AttachedFile> findByAttachedFileCode(
        java.lang.String attachedFileCode, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByAttachedFileCode(attachedFileCode, start, end, obc);
    }

    public static com.nss.portlet.attachedfile.model.AttachedFile findByAttachedFileCode_First(
        java.lang.String attachedFileCode,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.attachedfile.NoSuchAttachedFileException {
        return getPersistence()
                   .findByAttachedFileCode_First(attachedFileCode, obc);
    }

    public static com.nss.portlet.attachedfile.model.AttachedFile findByAttachedFileCode_Last(
        java.lang.String attachedFileCode,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.attachedfile.NoSuchAttachedFileException {
        return getPersistence()
                   .findByAttachedFileCode_Last(attachedFileCode, obc);
    }

    public static com.nss.portlet.attachedfile.model.AttachedFile[] findByAttachedFileCode_PrevAndNext(
        java.lang.String attachedFileId, java.lang.String attachedFileCode,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.attachedfile.NoSuchAttachedFileException {
        return getPersistence()
                   .findByAttachedFileCode_PrevAndNext(attachedFileId,
            attachedFileCode, obc);
    }

    public static java.util.List<com.nss.portlet.attachedfile.model.AttachedFile> findByAttachedFileName(
        java.lang.String attachedFileName)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByAttachedFileName(attachedFileName);
    }

    public static java.util.List<com.nss.portlet.attachedfile.model.AttachedFile> findByAttachedFileName(
        java.lang.String attachedFileName, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByAttachedFileName(attachedFileName, start, end);
    }

    public static java.util.List<com.nss.portlet.attachedfile.model.AttachedFile> findByAttachedFileName(
        java.lang.String attachedFileName, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByAttachedFileName(attachedFileName, start, end, obc);
    }

    public static com.nss.portlet.attachedfile.model.AttachedFile findByAttachedFileName_First(
        java.lang.String attachedFileName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.attachedfile.NoSuchAttachedFileException {
        return getPersistence()
                   .findByAttachedFileName_First(attachedFileName, obc);
    }

    public static com.nss.portlet.attachedfile.model.AttachedFile findByAttachedFileName_Last(
        java.lang.String attachedFileName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.attachedfile.NoSuchAttachedFileException {
        return getPersistence()
                   .findByAttachedFileName_Last(attachedFileName, obc);
    }

    public static com.nss.portlet.attachedfile.model.AttachedFile[] findByAttachedFileName_PrevAndNext(
        java.lang.String attachedFileId, java.lang.String attachedFileName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.attachedfile.NoSuchAttachedFileException {
        return getPersistence()
                   .findByAttachedFileName_PrevAndNext(attachedFileId,
            attachedFileName, obc);
    }

    public static java.util.List<com.nss.portlet.attachedfile.model.AttachedFile> findByDescription(
        java.lang.String description) throws com.liferay.portal.SystemException {
        return getPersistence().findByDescription(description);
    }

    public static java.util.List<com.nss.portlet.attachedfile.model.AttachedFile> findByDescription(
        java.lang.String description, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByDescription(description, start, end);
    }

    public static java.util.List<com.nss.portlet.attachedfile.model.AttachedFile> findByDescription(
        java.lang.String description, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByDescription(description, start, end, obc);
    }

    public static com.nss.portlet.attachedfile.model.AttachedFile findByDescription_First(
        java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.attachedfile.NoSuchAttachedFileException {
        return getPersistence().findByDescription_First(description, obc);
    }

    public static com.nss.portlet.attachedfile.model.AttachedFile findByDescription_Last(
        java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.attachedfile.NoSuchAttachedFileException {
        return getPersistence().findByDescription_Last(description, obc);
    }

    public static com.nss.portlet.attachedfile.model.AttachedFile[] findByDescription_PrevAndNext(
        java.lang.String attachedFileId, java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.attachedfile.NoSuchAttachedFileException {
        return getPersistence()
                   .findByDescription_PrevAndNext(attachedFileId, description,
            obc);
    }

    public static java.util.List<com.nss.portlet.attachedfile.model.AttachedFile> findByC_N_D(
        java.lang.String attachedFileCode, java.lang.String attachedFileName,
        java.lang.String description) throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByC_N_D(attachedFileCode, attachedFileName, description);
    }

    public static java.util.List<com.nss.portlet.attachedfile.model.AttachedFile> findByC_N_D(
        java.lang.String attachedFileCode, java.lang.String attachedFileName,
        java.lang.String description, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByC_N_D(attachedFileCode, attachedFileName,
            description, start, end);
    }

    public static java.util.List<com.nss.portlet.attachedfile.model.AttachedFile> findByC_N_D(
        java.lang.String attachedFileCode, java.lang.String attachedFileName,
        java.lang.String description, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByC_N_D(attachedFileCode, attachedFileName,
            description, start, end, obc);
    }

    public static com.nss.portlet.attachedfile.model.AttachedFile findByC_N_D_First(
        java.lang.String attachedFileCode, java.lang.String attachedFileName,
        java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.attachedfile.NoSuchAttachedFileException {
        return getPersistence()
                   .findByC_N_D_First(attachedFileCode, attachedFileName,
            description, obc);
    }

    public static com.nss.portlet.attachedfile.model.AttachedFile findByC_N_D_Last(
        java.lang.String attachedFileCode, java.lang.String attachedFileName,
        java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.attachedfile.NoSuchAttachedFileException {
        return getPersistence()
                   .findByC_N_D_Last(attachedFileCode, attachedFileName,
            description, obc);
    }

    public static com.nss.portlet.attachedfile.model.AttachedFile[] findByC_N_D_PrevAndNext(
        java.lang.String attachedFileId, java.lang.String attachedFileCode,
        java.lang.String attachedFileName, java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.attachedfile.NoSuchAttachedFileException {
        return getPersistence()
                   .findByC_N_D_PrevAndNext(attachedFileId, attachedFileCode,
            attachedFileName, description, obc);
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

    public static java.util.List<com.nss.portlet.attachedfile.model.AttachedFile> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.nss.portlet.attachedfile.model.AttachedFile> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.nss.portlet.attachedfile.model.AttachedFile> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end, obc);
    }

    public static void removeByAttachedFileCode(
        java.lang.String attachedFileCode)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByAttachedFileCode(attachedFileCode);
    }

    public static void removeByAttachedFileName(
        java.lang.String attachedFileName)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByAttachedFileName(attachedFileName);
    }

    public static void removeByDescription(java.lang.String description)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByDescription(description);
    }

    public static void removeByC_N_D(java.lang.String attachedFileCode,
        java.lang.String attachedFileName, java.lang.String description)
        throws com.liferay.portal.SystemException {
        getPersistence()
            .removeByC_N_D(attachedFileCode, attachedFileName, description);
    }

    public static void removeAll() throws com.liferay.portal.SystemException {
        getPersistence().removeAll();
    }

    public static int countByAttachedFileCode(java.lang.String attachedFileCode)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByAttachedFileCode(attachedFileCode);
    }

    public static int countByAttachedFileName(java.lang.String attachedFileName)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByAttachedFileName(attachedFileName);
    }

    public static int countByDescription(java.lang.String description)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByDescription(description);
    }

    public static int countByC_N_D(java.lang.String attachedFileCode,
        java.lang.String attachedFileName, java.lang.String description)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .countByC_N_D(attachedFileCode, attachedFileName, description);
    }

    public static int countAll() throws com.liferay.portal.SystemException {
        return getPersistence().countAll();
    }

    public static AttachedFilePersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(AttachedFilePersistence persistence) {
        _persistence = persistence;
    }
}
