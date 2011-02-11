package com.sgs.portlet.onedoorpccc.service.persistence;

public interface PmlFilePCCCAttachedFilePersistence {
    public com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile create(
        long attachedFileId);

    public com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile remove(
        long attachedFileId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchAttachedFileException;

    public com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile remove(
        com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile pmlFilePCCCAttachedFile)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(PmlFilePCCCAttachedFile pmlFilePCCCAttachedFile, boolean merge)</code>.
     */
    public com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile update(
        com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile pmlFilePCCCAttachedFile)
        throws com.liferay.portal.SystemException;

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
    public com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile update(
        com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile pmlFilePCCCAttachedFile,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile updateImpl(
        com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile pmlFilePCCCAttachedFile,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile findByPrimaryKey(
        long attachedFileId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchAttachedFileException;

    public com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile fetchByPrimaryKey(
        long attachedFileId) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile> findByFilePcccId(
        java.lang.String filePcccId) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile> findByFilePcccId(
        java.lang.String filePcccId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile> findByFilePcccId(
        java.lang.String filePcccId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile findByFilePcccId_First(
        java.lang.String filePcccId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchAttachedFileException;

    public com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile findByFilePcccId_Last(
        java.lang.String filePcccId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchAttachedFileException;

    public com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile[] findByFilePcccId_PrevAndNext(
        long attachedFileId, java.lang.String filePcccId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchAttachedFileException;

    public java.util.List<com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile> findByObjectType(
        java.lang.String objectType) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile> findByObjectType(
        java.lang.String objectType, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile> findByObjectType(
        java.lang.String objectType, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile findByObjectType_First(
        java.lang.String objectType,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchAttachedFileException;

    public com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile findByObjectType_Last(
        java.lang.String objectType,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchAttachedFileException;

    public com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile[] findByObjectType_PrevAndNext(
        long attachedFileId, java.lang.String objectType,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchAttachedFileException;

    public java.util.List<com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile> findByAttachedFileName(
        java.lang.String attachedFileName)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile> findByAttachedFileName(
        java.lang.String attachedFileName, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile> findByAttachedFileName(
        java.lang.String attachedFileName, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile findByAttachedFileName_First(
        java.lang.String attachedFileName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchAttachedFileException;

    public com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile findByAttachedFileName_Last(
        java.lang.String attachedFileName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchAttachedFileException;

    public com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile[] findByAttachedFileName_PrevAndNext(
        long attachedFileId, java.lang.String attachedFileName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchAttachedFileException;

    public java.util.List<com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile> findByPath(
        java.lang.String path) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile> findByPath(
        java.lang.String path, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile> findByPath(
        java.lang.String path, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile findByPath_First(
        java.lang.String path,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchAttachedFileException;

    public com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile findByPath_Last(
        java.lang.String path,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchAttachedFileException;

    public com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile[] findByPath_PrevAndNext(
        long attachedFileId, java.lang.String path,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchAttachedFileException;

    public java.util.List<com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile> findByDateCreated(
        java.util.Date dateCreated) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile> findByDateCreated(
        java.util.Date dateCreated, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile> findByDateCreated(
        java.util.Date dateCreated, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile findByDateCreated_First(
        java.util.Date dateCreated,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchAttachedFileException;

    public com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile findByDateCreated_Last(
        java.util.Date dateCreated,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchAttachedFileException;

    public com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile[] findByDateCreated_PrevAndNext(
        long attachedFileId, java.util.Date dateCreated,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchAttachedFileException;

    public java.util.List<com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile> findByFileType(
        java.lang.String fileType) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile> findByFileType(
        java.lang.String fileType, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile> findByFileType(
        java.lang.String fileType, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile findByFileType_First(
        java.lang.String fileType,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchAttachedFileException;

    public com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile findByFileType_Last(
        java.lang.String fileType,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchAttachedFileException;

    public com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile[] findByFileType_PrevAndNext(
        long attachedFileId, java.lang.String fileType,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchAttachedFileException;

    public java.util.List<com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile> findByFilePcccId_ObjectType(
        java.lang.String filePcccId, java.lang.String objectType)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile> findByFilePcccId_ObjectType(
        java.lang.String filePcccId, java.lang.String objectType, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile> findByFilePcccId_ObjectType(
        java.lang.String filePcccId, java.lang.String objectType, int start,
        int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile findByFilePcccId_ObjectType_First(
        java.lang.String filePcccId, java.lang.String objectType,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchAttachedFileException;

    public com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile findByFilePcccId_ObjectType_Last(
        java.lang.String filePcccId, java.lang.String objectType,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchAttachedFileException;

    public com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile[] findByFilePcccId_ObjectType_PrevAndNext(
        long attachedFileId, java.lang.String filePcccId,
        java.lang.String objectType,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchAttachedFileException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeByFilePcccId(java.lang.String filePcccId)
        throws com.liferay.portal.SystemException;

    public void removeByObjectType(java.lang.String objectType)
        throws com.liferay.portal.SystemException;

    public void removeByAttachedFileName(java.lang.String attachedFileName)
        throws com.liferay.portal.SystemException;

    public void removeByPath(java.lang.String path)
        throws com.liferay.portal.SystemException;

    public void removeByDateCreated(java.util.Date dateCreated)
        throws com.liferay.portal.SystemException;

    public void removeByFileType(java.lang.String fileType)
        throws com.liferay.portal.SystemException;

    public void removeByFilePcccId_ObjectType(java.lang.String filePcccId,
        java.lang.String objectType) throws com.liferay.portal.SystemException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countByFilePcccId(java.lang.String filePcccId)
        throws com.liferay.portal.SystemException;

    public int countByObjectType(java.lang.String objectType)
        throws com.liferay.portal.SystemException;

    public int countByAttachedFileName(java.lang.String attachedFileName)
        throws com.liferay.portal.SystemException;

    public int countByPath(java.lang.String path)
        throws com.liferay.portal.SystemException;

    public int countByDateCreated(java.util.Date dateCreated)
        throws com.liferay.portal.SystemException;

    public int countByFileType(java.lang.String fileType)
        throws com.liferay.portal.SystemException;

    public int countByFilePcccId_ObjectType(java.lang.String filePcccId,
        java.lang.String objectType) throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;

    public void registerListener(
        com.liferay.portal.model.ModelListener listener);

    public void unregisterListener(
        com.liferay.portal.model.ModelListener listener);
}
