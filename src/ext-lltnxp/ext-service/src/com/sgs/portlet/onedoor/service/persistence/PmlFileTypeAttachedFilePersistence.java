package com.sgs.portlet.onedoor.service.persistence;

public interface PmlFileTypeAttachedFilePersistence {
    public com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile create(
        java.lang.String filetypeAttachedFileId);

    public com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile remove(
        java.lang.String filetypeAttachedFileId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchTypeAttachedFileException;

    public com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile remove(
        com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile pmlFileTypeAttachedFile)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(PmlFileTypeAttachedFile pmlFileTypeAttachedFile, boolean merge)</code>.
     */
    public com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile update(
        com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile pmlFileTypeAttachedFile)
        throws com.liferay.portal.SystemException;

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
    public com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile update(
        com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile pmlFileTypeAttachedFile,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile updateImpl(
        com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile pmlFileTypeAttachedFile,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile findByPrimaryKey(
        java.lang.String filetypeAttachedFileId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchTypeAttachedFileException;

    public com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile fetchByPrimaryKey(
        java.lang.String filetypeAttachedFileId)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile> findByFileTypeId(
        java.lang.String fileTypeId) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile> findByFileTypeId(
        java.lang.String fileTypeId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile> findByFileTypeId(
        java.lang.String fileTypeId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile findByFileTypeId_First(
        java.lang.String fileTypeId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchTypeAttachedFileException;

    public com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile findByFileTypeId_Last(
        java.lang.String fileTypeId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchTypeAttachedFileException;

    public com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile[] findByFileTypeId_PrevAndNext(
        java.lang.String filetypeAttachedFileId, java.lang.String fileTypeId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchTypeAttachedFileException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile> findByAttachedFileId(
        java.lang.String attachedFileId)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile> findByAttachedFileId(
        java.lang.String attachedFileId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile> findByAttachedFileId(
        java.lang.String attachedFileId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile findByAttachedFileId_First(
        java.lang.String attachedFileId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchTypeAttachedFileException;

    public com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile findByAttachedFileId_Last(
        java.lang.String attachedFileId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchTypeAttachedFileException;

    public com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile[] findByAttachedFileId_PrevAndNext(
        java.lang.String filetypeAttachedFileId,
        java.lang.String attachedFileId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchTypeAttachedFileException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile> findByAttachedFileName(
        java.lang.String attachedFileName)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile> findByAttachedFileName(
        java.lang.String attachedFileName, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile> findByAttachedFileName(
        java.lang.String attachedFileName, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile findByAttachedFileName_First(
        java.lang.String attachedFileName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchTypeAttachedFileException;

    public com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile findByAttachedFileName_Last(
        java.lang.String attachedFileName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchTypeAttachedFileException;

    public com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile[] findByAttachedFileName_PrevAndNext(
        java.lang.String filetypeAttachedFileId,
        java.lang.String attachedFileName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchTypeAttachedFileException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile> findByOriginal(
        int original) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile> findByOriginal(
        int original, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile> findByOriginal(
        int original, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile findByOriginal_First(
        int original, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchTypeAttachedFileException;

    public com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile findByOriginal_Last(
        int original, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchTypeAttachedFileException;

    public com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile[] findByOriginal_PrevAndNext(
        java.lang.String filetypeAttachedFileId, int original,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchTypeAttachedFileException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile> findByOriginal_FT(
        int original, java.lang.String fileTypeId)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile> findByOriginal_FT(
        int original, java.lang.String fileTypeId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile> findByOriginal_FT(
        int original, java.lang.String fileTypeId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile findByOriginal_FT_First(
        int original, java.lang.String fileTypeId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchTypeAttachedFileException;

    public com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile findByOriginal_FT_Last(
        int original, java.lang.String fileTypeId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchTypeAttachedFileException;

    public com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile[] findByOriginal_FT_PrevAndNext(
        java.lang.String filetypeAttachedFileId, int original,
        java.lang.String fileTypeId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchTypeAttachedFileException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile> findByCopy_(
        int copy_) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile> findByCopy_(
        int copy_, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile> findByCopy_(
        int copy_, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile findByCopy__First(
        int copy_, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchTypeAttachedFileException;

    public com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile findByCopy__Last(
        int copy_, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchTypeAttachedFileException;

    public com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile[] findByCopy__PrevAndNext(
        java.lang.String filetypeAttachedFileId, int copy_,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchTypeAttachedFileException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile> findByCopy_FT(
        int copy_, java.lang.String fileTypeId)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile> findByCopy_FT(
        int copy_, java.lang.String fileTypeId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile> findByCopy_FT(
        int copy_, java.lang.String fileTypeId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile findByCopy_FT_First(
        int copy_, java.lang.String fileTypeId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchTypeAttachedFileException;

    public com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile findByCopy_FT_Last(
        int copy_, java.lang.String fileTypeId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchTypeAttachedFileException;

    public com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile[] findByCopy_FT_PrevAndNext(
        java.lang.String filetypeAttachedFileId, int copy_,
        java.lang.String fileTypeId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchTypeAttachedFileException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile> findByNote(
        java.lang.String note) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile> findByNote(
        java.lang.String note, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile> findByNote(
        java.lang.String note, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile findByNote_First(
        java.lang.String note,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchTypeAttachedFileException;

    public com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile findByNote_Last(
        java.lang.String note,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchTypeAttachedFileException;

    public com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile[] findByNote_PrevAndNext(
        java.lang.String filetypeAttachedFileId, java.lang.String note,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchTypeAttachedFileException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile> findByNote_FT(
        java.lang.String note, java.lang.String fileTypeId)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile> findByNote_FT(
        java.lang.String note, java.lang.String fileTypeId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile> findByNote_FT(
        java.lang.String note, java.lang.String fileTypeId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile findByNote_FT_First(
        java.lang.String note, java.lang.String fileTypeId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchTypeAttachedFileException;

    public com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile findByNote_FT_Last(
        java.lang.String note, java.lang.String fileTypeId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchTypeAttachedFileException;

    public com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile[] findByNote_FT_PrevAndNext(
        java.lang.String filetypeAttachedFileId, java.lang.String note,
        java.lang.String fileTypeId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchTypeAttachedFileException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile> findByN_O_C_N(
        java.lang.String attachedFileName, int original, int copy_,
        java.lang.String note) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile> findByN_O_C_N(
        java.lang.String attachedFileName, int original, int copy_,
        java.lang.String note, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile> findByN_O_C_N(
        java.lang.String attachedFileName, int original, int copy_,
        java.lang.String note, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile findByN_O_C_N_First(
        java.lang.String attachedFileName, int original, int copy_,
        java.lang.String note,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchTypeAttachedFileException;

    public com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile findByN_O_C_N_Last(
        java.lang.String attachedFileName, int original, int copy_,
        java.lang.String note,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchTypeAttachedFileException;

    public com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile[] findByN_O_C_N_PrevAndNext(
        java.lang.String filetypeAttachedFileId,
        java.lang.String attachedFileName, int original, int copy_,
        java.lang.String note,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchTypeAttachedFileException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile> findByN_N(
        java.lang.String attachedFileName, java.lang.String note)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile> findByN_N(
        java.lang.String attachedFileName, java.lang.String note, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile> findByN_N(
        java.lang.String attachedFileName, java.lang.String note, int start,
        int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile findByN_N_First(
        java.lang.String attachedFileName, java.lang.String note,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchTypeAttachedFileException;

    public com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile findByN_N_Last(
        java.lang.String attachedFileName, java.lang.String note,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchTypeAttachedFileException;

    public com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile[] findByN_N_PrevAndNext(
        java.lang.String filetypeAttachedFileId,
        java.lang.String attachedFileName, java.lang.String note,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchTypeAttachedFileException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeByFileTypeId(java.lang.String fileTypeId)
        throws com.liferay.portal.SystemException;

    public void removeByAttachedFileId(java.lang.String attachedFileId)
        throws com.liferay.portal.SystemException;

    public void removeByAttachedFileName(java.lang.String attachedFileName)
        throws com.liferay.portal.SystemException;

    public void removeByOriginal(int original)
        throws com.liferay.portal.SystemException;

    public void removeByOriginal_FT(int original, java.lang.String fileTypeId)
        throws com.liferay.portal.SystemException;

    public void removeByCopy_(int copy_)
        throws com.liferay.portal.SystemException;

    public void removeByCopy_FT(int copy_, java.lang.String fileTypeId)
        throws com.liferay.portal.SystemException;

    public void removeByNote(java.lang.String note)
        throws com.liferay.portal.SystemException;

    public void removeByNote_FT(java.lang.String note,
        java.lang.String fileTypeId) throws com.liferay.portal.SystemException;

    public void removeByN_O_C_N(java.lang.String attachedFileName,
        int original, int copy_, java.lang.String note)
        throws com.liferay.portal.SystemException;

    public void removeByN_N(java.lang.String attachedFileName,
        java.lang.String note) throws com.liferay.portal.SystemException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countByFileTypeId(java.lang.String fileTypeId)
        throws com.liferay.portal.SystemException;

    public int countByAttachedFileId(java.lang.String attachedFileId)
        throws com.liferay.portal.SystemException;

    public int countByAttachedFileName(java.lang.String attachedFileName)
        throws com.liferay.portal.SystemException;

    public int countByOriginal(int original)
        throws com.liferay.portal.SystemException;

    public int countByOriginal_FT(int original, java.lang.String fileTypeId)
        throws com.liferay.portal.SystemException;

    public int countByCopy_(int copy_)
        throws com.liferay.portal.SystemException;

    public int countByCopy_FT(int copy_, java.lang.String fileTypeId)
        throws com.liferay.portal.SystemException;

    public int countByNote(java.lang.String note)
        throws com.liferay.portal.SystemException;

    public int countByNote_FT(java.lang.String note, java.lang.String fileTypeId)
        throws com.liferay.portal.SystemException;

    public int countByN_O_C_N(java.lang.String attachedFileName, int original,
        int copy_, java.lang.String note)
        throws com.liferay.portal.SystemException;

    public int countByN_N(java.lang.String attachedFileName,
        java.lang.String note) throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;

    public void registerListener(
        com.liferay.portal.model.ModelListener listener);

    public void unregisterListener(
        com.liferay.portal.model.ModelListener listener);
}
