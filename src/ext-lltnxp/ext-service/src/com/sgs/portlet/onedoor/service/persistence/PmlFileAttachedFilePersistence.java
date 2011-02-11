package com.sgs.portlet.onedoor.service.persistence;

public interface PmlFileAttachedFilePersistence {
    public com.sgs.portlet.onedoor.model.PmlFileAttachedFile create(
        java.lang.String fileAttachedFileId);

    public com.sgs.portlet.onedoor.model.PmlFileAttachedFile remove(
        java.lang.String fileAttachedFileId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchAttachedFileException;

    public com.sgs.portlet.onedoor.model.PmlFileAttachedFile remove(
        com.sgs.portlet.onedoor.model.PmlFileAttachedFile pmlFileAttachedFile)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(PmlFileAttachedFile pmlFileAttachedFile, boolean merge)</code>.
     */
    public com.sgs.portlet.onedoor.model.PmlFileAttachedFile update(
        com.sgs.portlet.onedoor.model.PmlFileAttachedFile pmlFileAttachedFile)
        throws com.liferay.portal.SystemException;

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
    public com.sgs.portlet.onedoor.model.PmlFileAttachedFile update(
        com.sgs.portlet.onedoor.model.PmlFileAttachedFile pmlFileAttachedFile,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.onedoor.model.PmlFileAttachedFile updateImpl(
        com.sgs.portlet.onedoor.model.PmlFileAttachedFile pmlFileAttachedFile,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.onedoor.model.PmlFileAttachedFile findByPrimaryKey(
        java.lang.String fileAttachedFileId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchAttachedFileException;

    public com.sgs.portlet.onedoor.model.PmlFileAttachedFile fetchByPrimaryKey(
        java.lang.String fileAttachedFileId)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlFileAttachedFile> findByFileId(
        java.lang.String fileId) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlFileAttachedFile> findByFileId(
        java.lang.String fileId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlFileAttachedFile> findByFileId(
        java.lang.String fileId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.onedoor.model.PmlFileAttachedFile findByFileId_First(
        java.lang.String fileId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchAttachedFileException;

    public com.sgs.portlet.onedoor.model.PmlFileAttachedFile findByFileId_Last(
        java.lang.String fileId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchAttachedFileException;

    public com.sgs.portlet.onedoor.model.PmlFileAttachedFile[] findByFileId_PrevAndNext(
        java.lang.String fileAttachedFileId, java.lang.String fileId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchAttachedFileException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlFileAttachedFile> findByAttachedFileId(
        java.lang.String attachedFileId)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlFileAttachedFile> findByAttachedFileId(
        java.lang.String attachedFileId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlFileAttachedFile> findByAttachedFileId(
        java.lang.String attachedFileId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.onedoor.model.PmlFileAttachedFile findByAttachedFileId_First(
        java.lang.String attachedFileId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchAttachedFileException;

    public com.sgs.portlet.onedoor.model.PmlFileAttachedFile findByAttachedFileId_Last(
        java.lang.String attachedFileId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchAttachedFileException;

    public com.sgs.portlet.onedoor.model.PmlFileAttachedFile[] findByAttachedFileId_PrevAndNext(
        java.lang.String fileAttachedFileId, java.lang.String attachedFileId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchAttachedFileException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlFileAttachedFile> findByAttachedFileName(
        java.lang.String attachedFileName)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlFileAttachedFile> findByAttachedFileName(
        java.lang.String attachedFileName, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlFileAttachedFile> findByAttachedFileName(
        java.lang.String attachedFileName, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.onedoor.model.PmlFileAttachedFile findByAttachedFileName_First(
        java.lang.String attachedFileName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchAttachedFileException;

    public com.sgs.portlet.onedoor.model.PmlFileAttachedFile findByAttachedFileName_Last(
        java.lang.String attachedFileName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchAttachedFileException;

    public com.sgs.portlet.onedoor.model.PmlFileAttachedFile[] findByAttachedFileName_PrevAndNext(
        java.lang.String fileAttachedFileId, java.lang.String attachedFileName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchAttachedFileException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlFileAttachedFile> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlFileAttachedFile> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlFileAttachedFile> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeByFileId(java.lang.String fileId)
        throws com.liferay.portal.SystemException;

    public void removeByAttachedFileId(java.lang.String attachedFileId)
        throws com.liferay.portal.SystemException;

    public void removeByAttachedFileName(java.lang.String attachedFileName)
        throws com.liferay.portal.SystemException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countByFileId(java.lang.String fileId)
        throws com.liferay.portal.SystemException;

    public int countByAttachedFileId(java.lang.String attachedFileId)
        throws com.liferay.portal.SystemException;

    public int countByAttachedFileName(java.lang.String attachedFileName)
        throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;

    public void registerListener(
        com.liferay.portal.model.ModelListener listener);

    public void unregisterListener(
        com.liferay.portal.model.ModelListener listener);
}
