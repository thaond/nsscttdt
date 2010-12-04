package com.nss.portlet.filetype.service.persistence;

public class PmlFileTypeAttachedFileUtil {
    private static PmlFileTypeAttachedFilePersistence _persistence;

    public static void cacheResult(
        com.nss.portlet.filetype.model.PmlFileTypeAttachedFile pmlFileTypeAttachedFile) {
        getPersistence().cacheResult(pmlFileTypeAttachedFile);
    }

    public static void cacheResult(
        java.util.List<com.nss.portlet.filetype.model.PmlFileTypeAttachedFile> pmlFileTypeAttachedFiles) {
        getPersistence().cacheResult(pmlFileTypeAttachedFiles);
    }

    public static void clearCache() {
        getPersistence().clearCache();
    }

    public static com.nss.portlet.filetype.model.PmlFileTypeAttachedFile create(
        java.lang.String filetypeAttachedFileId) {
        return getPersistence().create(filetypeAttachedFileId);
    }

    public static com.nss.portlet.filetype.model.PmlFileTypeAttachedFile remove(
        java.lang.String filetypeAttachedFileId)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.filetype.NoSuchPmlFileTypeAttachedFileException {
        return getPersistence().remove(filetypeAttachedFileId);
    }

    public static com.nss.portlet.filetype.model.PmlFileTypeAttachedFile remove(
        com.nss.portlet.filetype.model.PmlFileTypeAttachedFile pmlFileTypeAttachedFile)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(pmlFileTypeAttachedFile);
    }

    /**
     * @deprecated Use <code>update(PmlFileTypeAttachedFile pmlFileTypeAttachedFile, boolean merge)</code>.
     */
    public static com.nss.portlet.filetype.model.PmlFileTypeAttachedFile update(
        com.nss.portlet.filetype.model.PmlFileTypeAttachedFile pmlFileTypeAttachedFile)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(pmlFileTypeAttachedFile);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlFileTypeAttachedFile the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlFileTypeAttachedFile is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public static com.nss.portlet.filetype.model.PmlFileTypeAttachedFile update(
        com.nss.portlet.filetype.model.PmlFileTypeAttachedFile pmlFileTypeAttachedFile,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().update(pmlFileTypeAttachedFile, merge);
    }

    public static com.nss.portlet.filetype.model.PmlFileTypeAttachedFile updateImpl(
        com.nss.portlet.filetype.model.PmlFileTypeAttachedFile pmlFileTypeAttachedFile,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(pmlFileTypeAttachedFile, merge);
    }

    public static com.nss.portlet.filetype.model.PmlFileTypeAttachedFile findByPrimaryKey(
        java.lang.String filetypeAttachedFileId)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.filetype.NoSuchPmlFileTypeAttachedFileException {
        return getPersistence().findByPrimaryKey(filetypeAttachedFileId);
    }

    public static com.nss.portlet.filetype.model.PmlFileTypeAttachedFile fetchByPrimaryKey(
        java.lang.String filetypeAttachedFileId)
        throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(filetypeAttachedFileId);
    }

    public static java.util.List<com.nss.portlet.filetype.model.PmlFileTypeAttachedFile> findByFileTypeId(
        java.lang.String fileTypeId) throws com.liferay.portal.SystemException {
        return getPersistence().findByFileTypeId(fileTypeId);
    }

    public static java.util.List<com.nss.portlet.filetype.model.PmlFileTypeAttachedFile> findByFileTypeId(
        java.lang.String fileTypeId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByFileTypeId(fileTypeId, start, end);
    }

    public static java.util.List<com.nss.portlet.filetype.model.PmlFileTypeAttachedFile> findByFileTypeId(
        java.lang.String fileTypeId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByFileTypeId(fileTypeId, start, end, obc);
    }

    public static com.nss.portlet.filetype.model.PmlFileTypeAttachedFile findByFileTypeId_First(
        java.lang.String fileTypeId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.filetype.NoSuchPmlFileTypeAttachedFileException {
        return getPersistence().findByFileTypeId_First(fileTypeId, obc);
    }

    public static com.nss.portlet.filetype.model.PmlFileTypeAttachedFile findByFileTypeId_Last(
        java.lang.String fileTypeId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.filetype.NoSuchPmlFileTypeAttachedFileException {
        return getPersistence().findByFileTypeId_Last(fileTypeId, obc);
    }

    public static com.nss.portlet.filetype.model.PmlFileTypeAttachedFile[] findByFileTypeId_PrevAndNext(
        java.lang.String filetypeAttachedFileId, java.lang.String fileTypeId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.filetype.NoSuchPmlFileTypeAttachedFileException {
        return getPersistence()
                   .findByFileTypeId_PrevAndNext(filetypeAttachedFileId,
            fileTypeId, obc);
    }

    public static java.util.List<com.nss.portlet.filetype.model.PmlFileTypeAttachedFile> findByAttachedFileId(
        java.lang.String attachedFileId)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByAttachedFileId(attachedFileId);
    }

    public static java.util.List<com.nss.portlet.filetype.model.PmlFileTypeAttachedFile> findByAttachedFileId(
        java.lang.String attachedFileId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByAttachedFileId(attachedFileId, start, end);
    }

    public static java.util.List<com.nss.portlet.filetype.model.PmlFileTypeAttachedFile> findByAttachedFileId(
        java.lang.String attachedFileId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByAttachedFileId(attachedFileId, start, end, obc);
    }

    public static com.nss.portlet.filetype.model.PmlFileTypeAttachedFile findByAttachedFileId_First(
        java.lang.String attachedFileId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.filetype.NoSuchPmlFileTypeAttachedFileException {
        return getPersistence().findByAttachedFileId_First(attachedFileId, obc);
    }

    public static com.nss.portlet.filetype.model.PmlFileTypeAttachedFile findByAttachedFileId_Last(
        java.lang.String attachedFileId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.filetype.NoSuchPmlFileTypeAttachedFileException {
        return getPersistence().findByAttachedFileId_Last(attachedFileId, obc);
    }

    public static com.nss.portlet.filetype.model.PmlFileTypeAttachedFile[] findByAttachedFileId_PrevAndNext(
        java.lang.String filetypeAttachedFileId,
        java.lang.String attachedFileId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.filetype.NoSuchPmlFileTypeAttachedFileException {
        return getPersistence()
                   .findByAttachedFileId_PrevAndNext(filetypeAttachedFileId,
            attachedFileId, obc);
    }

    public static java.util.List<com.nss.portlet.filetype.model.PmlFileTypeAttachedFile> findByAttachedFileName(
        java.lang.String attachedFileName)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByAttachedFileName(attachedFileName);
    }

    public static java.util.List<com.nss.portlet.filetype.model.PmlFileTypeAttachedFile> findByAttachedFileName(
        java.lang.String attachedFileName, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByAttachedFileName(attachedFileName, start, end);
    }

    public static java.util.List<com.nss.portlet.filetype.model.PmlFileTypeAttachedFile> findByAttachedFileName(
        java.lang.String attachedFileName, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByAttachedFileName(attachedFileName, start, end, obc);
    }

    public static com.nss.portlet.filetype.model.PmlFileTypeAttachedFile findByAttachedFileName_First(
        java.lang.String attachedFileName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.filetype.NoSuchPmlFileTypeAttachedFileException {
        return getPersistence()
                   .findByAttachedFileName_First(attachedFileName, obc);
    }

    public static com.nss.portlet.filetype.model.PmlFileTypeAttachedFile findByAttachedFileName_Last(
        java.lang.String attachedFileName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.filetype.NoSuchPmlFileTypeAttachedFileException {
        return getPersistence()
                   .findByAttachedFileName_Last(attachedFileName, obc);
    }

    public static com.nss.portlet.filetype.model.PmlFileTypeAttachedFile[] findByAttachedFileName_PrevAndNext(
        java.lang.String filetypeAttachedFileId,
        java.lang.String attachedFileName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.filetype.NoSuchPmlFileTypeAttachedFileException {
        return getPersistence()
                   .findByAttachedFileName_PrevAndNext(filetypeAttachedFileId,
            attachedFileName, obc);
    }

    public static java.util.List<com.nss.portlet.filetype.model.PmlFileTypeAttachedFile> findByOriginal(
        int original) throws com.liferay.portal.SystemException {
        return getPersistence().findByOriginal(original);
    }

    public static java.util.List<com.nss.portlet.filetype.model.PmlFileTypeAttachedFile> findByOriginal(
        int original, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByOriginal(original, start, end);
    }

    public static java.util.List<com.nss.portlet.filetype.model.PmlFileTypeAttachedFile> findByOriginal(
        int original, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByOriginal(original, start, end, obc);
    }

    public static com.nss.portlet.filetype.model.PmlFileTypeAttachedFile findByOriginal_First(
        int original, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.filetype.NoSuchPmlFileTypeAttachedFileException {
        return getPersistence().findByOriginal_First(original, obc);
    }

    public static com.nss.portlet.filetype.model.PmlFileTypeAttachedFile findByOriginal_Last(
        int original, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.filetype.NoSuchPmlFileTypeAttachedFileException {
        return getPersistence().findByOriginal_Last(original, obc);
    }

    public static com.nss.portlet.filetype.model.PmlFileTypeAttachedFile[] findByOriginal_PrevAndNext(
        java.lang.String filetypeAttachedFileId, int original,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.filetype.NoSuchPmlFileTypeAttachedFileException {
        return getPersistence()
                   .findByOriginal_PrevAndNext(filetypeAttachedFileId,
            original, obc);
    }

    public static java.util.List<com.nss.portlet.filetype.model.PmlFileTypeAttachedFile> findByOriginal_FT(
        int original, java.lang.String fileTypeId)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByOriginal_FT(original, fileTypeId);
    }

    public static java.util.List<com.nss.portlet.filetype.model.PmlFileTypeAttachedFile> findByOriginal_FT(
        int original, java.lang.String fileTypeId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByOriginal_FT(original, fileTypeId, start, end);
    }

    public static java.util.List<com.nss.portlet.filetype.model.PmlFileTypeAttachedFile> findByOriginal_FT(
        int original, java.lang.String fileTypeId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByOriginal_FT(original, fileTypeId, start, end, obc);
    }

    public static com.nss.portlet.filetype.model.PmlFileTypeAttachedFile findByOriginal_FT_First(
        int original, java.lang.String fileTypeId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.filetype.NoSuchPmlFileTypeAttachedFileException {
        return getPersistence()
                   .findByOriginal_FT_First(original, fileTypeId, obc);
    }

    public static com.nss.portlet.filetype.model.PmlFileTypeAttachedFile findByOriginal_FT_Last(
        int original, java.lang.String fileTypeId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.filetype.NoSuchPmlFileTypeAttachedFileException {
        return getPersistence().findByOriginal_FT_Last(original, fileTypeId, obc);
    }

    public static com.nss.portlet.filetype.model.PmlFileTypeAttachedFile[] findByOriginal_FT_PrevAndNext(
        java.lang.String filetypeAttachedFileId, int original,
        java.lang.String fileTypeId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.filetype.NoSuchPmlFileTypeAttachedFileException {
        return getPersistence()
                   .findByOriginal_FT_PrevAndNext(filetypeAttachedFileId,
            original, fileTypeId, obc);
    }

    public static java.util.List<com.nss.portlet.filetype.model.PmlFileTypeAttachedFile> findByCopy_(
        int copy_) throws com.liferay.portal.SystemException {
        return getPersistence().findByCopy_(copy_);
    }

    public static java.util.List<com.nss.portlet.filetype.model.PmlFileTypeAttachedFile> findByCopy_(
        int copy_, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByCopy_(copy_, start, end);
    }

    public static java.util.List<com.nss.portlet.filetype.model.PmlFileTypeAttachedFile> findByCopy_(
        int copy_, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByCopy_(copy_, start, end, obc);
    }

    public static com.nss.portlet.filetype.model.PmlFileTypeAttachedFile findByCopy__First(
        int copy_, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.filetype.NoSuchPmlFileTypeAttachedFileException {
        return getPersistence().findByCopy__First(copy_, obc);
    }

    public static com.nss.portlet.filetype.model.PmlFileTypeAttachedFile findByCopy__Last(
        int copy_, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.filetype.NoSuchPmlFileTypeAttachedFileException {
        return getPersistence().findByCopy__Last(copy_, obc);
    }

    public static com.nss.portlet.filetype.model.PmlFileTypeAttachedFile[] findByCopy__PrevAndNext(
        java.lang.String filetypeAttachedFileId, int copy_,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.filetype.NoSuchPmlFileTypeAttachedFileException {
        return getPersistence()
                   .findByCopy__PrevAndNext(filetypeAttachedFileId, copy_, obc);
    }

    public static java.util.List<com.nss.portlet.filetype.model.PmlFileTypeAttachedFile> findByCopy_FT(
        int copy_, java.lang.String fileTypeId)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByCopy_FT(copy_, fileTypeId);
    }

    public static java.util.List<com.nss.portlet.filetype.model.PmlFileTypeAttachedFile> findByCopy_FT(
        int copy_, java.lang.String fileTypeId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByCopy_FT(copy_, fileTypeId, start, end);
    }

    public static java.util.List<com.nss.portlet.filetype.model.PmlFileTypeAttachedFile> findByCopy_FT(
        int copy_, java.lang.String fileTypeId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByCopy_FT(copy_, fileTypeId, start, end, obc);
    }

    public static com.nss.portlet.filetype.model.PmlFileTypeAttachedFile findByCopy_FT_First(
        int copy_, java.lang.String fileTypeId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.filetype.NoSuchPmlFileTypeAttachedFileException {
        return getPersistence().findByCopy_FT_First(copy_, fileTypeId, obc);
    }

    public static com.nss.portlet.filetype.model.PmlFileTypeAttachedFile findByCopy_FT_Last(
        int copy_, java.lang.String fileTypeId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.filetype.NoSuchPmlFileTypeAttachedFileException {
        return getPersistence().findByCopy_FT_Last(copy_, fileTypeId, obc);
    }

    public static com.nss.portlet.filetype.model.PmlFileTypeAttachedFile[] findByCopy_FT_PrevAndNext(
        java.lang.String filetypeAttachedFileId, int copy_,
        java.lang.String fileTypeId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.filetype.NoSuchPmlFileTypeAttachedFileException {
        return getPersistence()
                   .findByCopy_FT_PrevAndNext(filetypeAttachedFileId, copy_,
            fileTypeId, obc);
    }

    public static java.util.List<com.nss.portlet.filetype.model.PmlFileTypeAttachedFile> findByNote(
        java.lang.String note) throws com.liferay.portal.SystemException {
        return getPersistence().findByNote(note);
    }

    public static java.util.List<com.nss.portlet.filetype.model.PmlFileTypeAttachedFile> findByNote(
        java.lang.String note, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByNote(note, start, end);
    }

    public static java.util.List<com.nss.portlet.filetype.model.PmlFileTypeAttachedFile> findByNote(
        java.lang.String note, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByNote(note, start, end, obc);
    }

    public static com.nss.portlet.filetype.model.PmlFileTypeAttachedFile findByNote_First(
        java.lang.String note,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.filetype.NoSuchPmlFileTypeAttachedFileException {
        return getPersistence().findByNote_First(note, obc);
    }

    public static com.nss.portlet.filetype.model.PmlFileTypeAttachedFile findByNote_Last(
        java.lang.String note,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.filetype.NoSuchPmlFileTypeAttachedFileException {
        return getPersistence().findByNote_Last(note, obc);
    }

    public static com.nss.portlet.filetype.model.PmlFileTypeAttachedFile[] findByNote_PrevAndNext(
        java.lang.String filetypeAttachedFileId, java.lang.String note,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.filetype.NoSuchPmlFileTypeAttachedFileException {
        return getPersistence()
                   .findByNote_PrevAndNext(filetypeAttachedFileId, note, obc);
    }

    public static java.util.List<com.nss.portlet.filetype.model.PmlFileTypeAttachedFile> findByNote_FT(
        java.lang.String note, java.lang.String fileTypeId)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByNote_FT(note, fileTypeId);
    }

    public static java.util.List<com.nss.portlet.filetype.model.PmlFileTypeAttachedFile> findByNote_FT(
        java.lang.String note, java.lang.String fileTypeId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByNote_FT(note, fileTypeId, start, end);
    }

    public static java.util.List<com.nss.portlet.filetype.model.PmlFileTypeAttachedFile> findByNote_FT(
        java.lang.String note, java.lang.String fileTypeId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByNote_FT(note, fileTypeId, start, end, obc);
    }

    public static com.nss.portlet.filetype.model.PmlFileTypeAttachedFile findByNote_FT_First(
        java.lang.String note, java.lang.String fileTypeId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.filetype.NoSuchPmlFileTypeAttachedFileException {
        return getPersistence().findByNote_FT_First(note, fileTypeId, obc);
    }

    public static com.nss.portlet.filetype.model.PmlFileTypeAttachedFile findByNote_FT_Last(
        java.lang.String note, java.lang.String fileTypeId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.filetype.NoSuchPmlFileTypeAttachedFileException {
        return getPersistence().findByNote_FT_Last(note, fileTypeId, obc);
    }

    public static com.nss.portlet.filetype.model.PmlFileTypeAttachedFile[] findByNote_FT_PrevAndNext(
        java.lang.String filetypeAttachedFileId, java.lang.String note,
        java.lang.String fileTypeId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.filetype.NoSuchPmlFileTypeAttachedFileException {
        return getPersistence()
                   .findByNote_FT_PrevAndNext(filetypeAttachedFileId, note,
            fileTypeId, obc);
    }

    public static java.util.List<com.nss.portlet.filetype.model.PmlFileTypeAttachedFile> findByN_O_C_N(
        java.lang.String attachedFileName, int original, int copy_,
        java.lang.String note) throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByN_O_C_N(attachedFileName, original, copy_, note);
    }

    public static java.util.List<com.nss.portlet.filetype.model.PmlFileTypeAttachedFile> findByN_O_C_N(
        java.lang.String attachedFileName, int original, int copy_,
        java.lang.String note, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByN_O_C_N(attachedFileName, original, copy_, note,
            start, end);
    }

    public static java.util.List<com.nss.portlet.filetype.model.PmlFileTypeAttachedFile> findByN_O_C_N(
        java.lang.String attachedFileName, int original, int copy_,
        java.lang.String note, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByN_O_C_N(attachedFileName, original, copy_, note,
            start, end, obc);
    }

    public static com.nss.portlet.filetype.model.PmlFileTypeAttachedFile findByN_O_C_N_First(
        java.lang.String attachedFileName, int original, int copy_,
        java.lang.String note,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.filetype.NoSuchPmlFileTypeAttachedFileException {
        return getPersistence()
                   .findByN_O_C_N_First(attachedFileName, original, copy_,
            note, obc);
    }

    public static com.nss.portlet.filetype.model.PmlFileTypeAttachedFile findByN_O_C_N_Last(
        java.lang.String attachedFileName, int original, int copy_,
        java.lang.String note,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.filetype.NoSuchPmlFileTypeAttachedFileException {
        return getPersistence()
                   .findByN_O_C_N_Last(attachedFileName, original, copy_, note,
            obc);
    }

    public static com.nss.portlet.filetype.model.PmlFileTypeAttachedFile[] findByN_O_C_N_PrevAndNext(
        java.lang.String filetypeAttachedFileId,
        java.lang.String attachedFileName, int original, int copy_,
        java.lang.String note,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.filetype.NoSuchPmlFileTypeAttachedFileException {
        return getPersistence()
                   .findByN_O_C_N_PrevAndNext(filetypeAttachedFileId,
            attachedFileName, original, copy_, note, obc);
    }

    public static java.util.List<com.nss.portlet.filetype.model.PmlFileTypeAttachedFile> findByN_N(
        java.lang.String attachedFileName, java.lang.String note)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByN_N(attachedFileName, note);
    }

    public static java.util.List<com.nss.portlet.filetype.model.PmlFileTypeAttachedFile> findByN_N(
        java.lang.String attachedFileName, java.lang.String note, int start,
        int end) throws com.liferay.portal.SystemException {
        return getPersistence().findByN_N(attachedFileName, note, start, end);
    }

    public static java.util.List<com.nss.portlet.filetype.model.PmlFileTypeAttachedFile> findByN_N(
        java.lang.String attachedFileName, java.lang.String note, int start,
        int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByN_N(attachedFileName, note, start, end, obc);
    }

    public static com.nss.portlet.filetype.model.PmlFileTypeAttachedFile findByN_N_First(
        java.lang.String attachedFileName, java.lang.String note,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.filetype.NoSuchPmlFileTypeAttachedFileException {
        return getPersistence().findByN_N_First(attachedFileName, note, obc);
    }

    public static com.nss.portlet.filetype.model.PmlFileTypeAttachedFile findByN_N_Last(
        java.lang.String attachedFileName, java.lang.String note,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.filetype.NoSuchPmlFileTypeAttachedFileException {
        return getPersistence().findByN_N_Last(attachedFileName, note, obc);
    }

    public static com.nss.portlet.filetype.model.PmlFileTypeAttachedFile[] findByN_N_PrevAndNext(
        java.lang.String filetypeAttachedFileId,
        java.lang.String attachedFileName, java.lang.String note,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.filetype.NoSuchPmlFileTypeAttachedFileException {
        return getPersistence()
                   .findByN_N_PrevAndNext(filetypeAttachedFileId,
            attachedFileName, note, obc);
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

    public static java.util.List<com.nss.portlet.filetype.model.PmlFileTypeAttachedFile> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.nss.portlet.filetype.model.PmlFileTypeAttachedFile> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.nss.portlet.filetype.model.PmlFileTypeAttachedFile> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end, obc);
    }

    public static void removeByFileTypeId(java.lang.String fileTypeId)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByFileTypeId(fileTypeId);
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

    public static void removeByOriginal(int original)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByOriginal(original);
    }

    public static void removeByOriginal_FT(int original,
        java.lang.String fileTypeId) throws com.liferay.portal.SystemException {
        getPersistence().removeByOriginal_FT(original, fileTypeId);
    }

    public static void removeByCopy_(int copy_)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByCopy_(copy_);
    }

    public static void removeByCopy_FT(int copy_, java.lang.String fileTypeId)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByCopy_FT(copy_, fileTypeId);
    }

    public static void removeByNote(java.lang.String note)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByNote(note);
    }

    public static void removeByNote_FT(java.lang.String note,
        java.lang.String fileTypeId) throws com.liferay.portal.SystemException {
        getPersistence().removeByNote_FT(note, fileTypeId);
    }

    public static void removeByN_O_C_N(java.lang.String attachedFileName,
        int original, int copy_, java.lang.String note)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByN_O_C_N(attachedFileName, original, copy_, note);
    }

    public static void removeByN_N(java.lang.String attachedFileName,
        java.lang.String note) throws com.liferay.portal.SystemException {
        getPersistence().removeByN_N(attachedFileName, note);
    }

    public static void removeAll() throws com.liferay.portal.SystemException {
        getPersistence().removeAll();
    }

    public static int countByFileTypeId(java.lang.String fileTypeId)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByFileTypeId(fileTypeId);
    }

    public static int countByAttachedFileId(java.lang.String attachedFileId)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByAttachedFileId(attachedFileId);
    }

    public static int countByAttachedFileName(java.lang.String attachedFileName)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByAttachedFileName(attachedFileName);
    }

    public static int countByOriginal(int original)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByOriginal(original);
    }

    public static int countByOriginal_FT(int original,
        java.lang.String fileTypeId) throws com.liferay.portal.SystemException {
        return getPersistence().countByOriginal_FT(original, fileTypeId);
    }

    public static int countByCopy_(int copy_)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByCopy_(copy_);
    }

    public static int countByCopy_FT(int copy_, java.lang.String fileTypeId)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByCopy_FT(copy_, fileTypeId);
    }

    public static int countByNote(java.lang.String note)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByNote(note);
    }

    public static int countByNote_FT(java.lang.String note,
        java.lang.String fileTypeId) throws com.liferay.portal.SystemException {
        return getPersistence().countByNote_FT(note, fileTypeId);
    }

    public static int countByN_O_C_N(java.lang.String attachedFileName,
        int original, int copy_, java.lang.String note)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .countByN_O_C_N(attachedFileName, original, copy_, note);
    }

    public static int countByN_N(java.lang.String attachedFileName,
        java.lang.String note) throws com.liferay.portal.SystemException {
        return getPersistence().countByN_N(attachedFileName, note);
    }

    public static int countAll() throws com.liferay.portal.SystemException {
        return getPersistence().countAll();
    }

    public static PmlFileTypeAttachedFilePersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(PmlFileTypeAttachedFilePersistence persistence) {
        _persistence = persistence;
    }
}
