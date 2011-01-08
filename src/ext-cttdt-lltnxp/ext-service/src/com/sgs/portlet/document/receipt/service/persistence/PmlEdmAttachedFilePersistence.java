package com.sgs.portlet.document.receipt.service.persistence;

public interface PmlEdmAttachedFilePersistence {
    public com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile create(
        long attachedFileId);

    public com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile remove(
        long attachedFileId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmAttachedFileException;

    public com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile remove(
        com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile pmlEdmAttachedFile)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(PmlEdmAttachedFile pmlEdmAttachedFile, boolean merge)</code>.
     */
    public com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile update(
        com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile pmlEdmAttachedFile)
        throws com.liferay.portal.SystemException;

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
    public com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile update(
        com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile pmlEdmAttachedFile,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile updateImpl(
        com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile pmlEdmAttachedFile,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile findByPrimaryKey(
        long attachedFileId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmAttachedFileException;

    public com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile fetchByPrimaryKey(
        long attachedFileId) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile> findByObjectContentId(
        long objectContentId) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile> findByObjectContentId(
        long objectContentId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile> findByObjectContentId(
        long objectContentId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile findByObjectContentId_First(
        long objectContentId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmAttachedFileException;

    public com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile findByObjectContentId_Last(
        long objectContentId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmAttachedFileException;

    public com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile[] findByObjectContentId_PrevAndNext(
        long attachedFileId, long objectContentId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmAttachedFileException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile> findByObjectType(
        java.lang.String objectType) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile> findByObjectType(
        java.lang.String objectType, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile> findByObjectType(
        java.lang.String objectType, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile findByObjectType_First(
        java.lang.String objectType,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmAttachedFileException;

    public com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile findByObjectType_Last(
        java.lang.String objectType,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmAttachedFileException;

    public com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile[] findByObjectType_PrevAndNext(
        long attachedFileId, java.lang.String objectType,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmAttachedFileException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile> findByAttachedFileName(
        java.lang.String attachedFileName)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile> findByAttachedFileName(
        java.lang.String attachedFileName, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile> findByAttachedFileName(
        java.lang.String attachedFileName, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile findByAttachedFileName_First(
        java.lang.String attachedFileName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmAttachedFileException;

    public com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile findByAttachedFileName_Last(
        java.lang.String attachedFileName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmAttachedFileException;

    public com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile[] findByAttachedFileName_PrevAndNext(
        long attachedFileId, java.lang.String attachedFileName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmAttachedFileException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile> findByPath(
        java.lang.String path) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile> findByPath(
        java.lang.String path, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile> findByPath(
        java.lang.String path, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile findByPath_First(
        java.lang.String path,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmAttachedFileException;

    public com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile findByPath_Last(
        java.lang.String path,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmAttachedFileException;

    public com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile[] findByPath_PrevAndNext(
        long attachedFileId, java.lang.String path,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmAttachedFileException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile> findByDateCreated(
        java.util.Date dateCreated) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile> findByDateCreated(
        java.util.Date dateCreated, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile> findByDateCreated(
        java.util.Date dateCreated, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile findByDateCreated_First(
        java.util.Date dateCreated,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmAttachedFileException;

    public com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile findByDateCreated_Last(
        java.util.Date dateCreated,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmAttachedFileException;

    public com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile[] findByDateCreated_PrevAndNext(
        long attachedFileId, java.util.Date dateCreated,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmAttachedFileException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile> findByFileType(
        java.lang.String fileType) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile> findByFileType(
        java.lang.String fileType, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile> findByFileType(
        java.lang.String fileType, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile findByFileType_First(
        java.lang.String fileType,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmAttachedFileException;

    public com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile findByFileType_Last(
        java.lang.String fileType,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmAttachedFileException;

    public com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile[] findByFileType_PrevAndNext(
        long attachedFileId, java.lang.String fileType,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmAttachedFileException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile> findByFileId(
        int fileId) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile> findByFileId(
        int fileId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile> findByFileId(
        int fileId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile findByFileId_First(
        int fileId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmAttachedFileException;

    public com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile findByFileId_Last(
        int fileId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmAttachedFileException;

    public com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile[] findByFileId_PrevAndNext(
        long attachedFileId, int fileId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmAttachedFileException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile> findByObjectContentId_ObjectType(
        long objectContentId, java.lang.String objectType)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile> findByObjectContentId_ObjectType(
        long objectContentId, java.lang.String objectType, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile> findByObjectContentId_ObjectType(
        long objectContentId, java.lang.String objectType, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile findByObjectContentId_ObjectType_First(
        long objectContentId, java.lang.String objectType,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmAttachedFileException;

    public com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile findByObjectContentId_ObjectType_Last(
        long objectContentId, java.lang.String objectType,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmAttachedFileException;

    public com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile[] findByObjectContentId_ObjectType_PrevAndNext(
        long attachedFileId, long objectContentId, java.lang.String objectType,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmAttachedFileException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile> findByObjectContentId_ObjectType_D_OR_H(
        long objectContentId, java.lang.String objectType,
        boolean displayOrHidden) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile> findByObjectContentId_ObjectType_D_OR_H(
        long objectContentId, java.lang.String objectType,
        boolean displayOrHidden, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile> findByObjectContentId_ObjectType_D_OR_H(
        long objectContentId, java.lang.String objectType,
        boolean displayOrHidden, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile findByObjectContentId_ObjectType_D_OR_H_First(
        long objectContentId, java.lang.String objectType,
        boolean displayOrHidden,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmAttachedFileException;

    public com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile findByObjectContentId_ObjectType_D_OR_H_Last(
        long objectContentId, java.lang.String objectType,
        boolean displayOrHidden,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmAttachedFileException;

    public com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile[] findByObjectContentId_ObjectType_D_OR_H_PrevAndNext(
        long attachedFileId, long objectContentId, java.lang.String objectType,
        boolean displayOrHidden,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmAttachedFileException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeByObjectContentId(long objectContentId)
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

    public void removeByFileId(int fileId)
        throws com.liferay.portal.SystemException;

    public void removeByObjectContentId_ObjectType(long objectContentId,
        java.lang.String objectType) throws com.liferay.portal.SystemException;

    public void removeByObjectContentId_ObjectType_D_OR_H(
        long objectContentId, java.lang.String objectType,
        boolean displayOrHidden) throws com.liferay.portal.SystemException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countByObjectContentId(long objectContentId)
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

    public int countByFileId(int fileId)
        throws com.liferay.portal.SystemException;

    public int countByObjectContentId_ObjectType(long objectContentId,
        java.lang.String objectType) throws com.liferay.portal.SystemException;

    public int countByObjectContentId_ObjectType_D_OR_H(long objectContentId,
        java.lang.String objectType, boolean displayOrHidden)
        throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;

    public void registerListener(
        com.liferay.portal.model.ModelListener listener);

    public void unregisterListener(
        com.liferay.portal.model.ModelListener listener);
}
