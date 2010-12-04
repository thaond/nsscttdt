package com.nss.portlet.attachedfile.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;


public interface AttachedFilePersistence extends BasePersistence {
    public void cacheResult(
        com.nss.portlet.attachedfile.model.AttachedFile attachedFile);

    public void cacheResult(
        java.util.List<com.nss.portlet.attachedfile.model.AttachedFile> attachedFiles);

    public void clearCache();

    public com.nss.portlet.attachedfile.model.AttachedFile create(
        java.lang.String attachedFileId);

    public com.nss.portlet.attachedfile.model.AttachedFile remove(
        java.lang.String attachedFileId)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.attachedfile.NoSuchAttachedFileException;

    public com.nss.portlet.attachedfile.model.AttachedFile remove(
        com.nss.portlet.attachedfile.model.AttachedFile attachedFile)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(AttachedFile attachedFile, boolean merge)</code>.
     */
    public com.nss.portlet.attachedfile.model.AttachedFile update(
        com.nss.portlet.attachedfile.model.AttachedFile attachedFile)
        throws com.liferay.portal.SystemException;

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
    public com.nss.portlet.attachedfile.model.AttachedFile update(
        com.nss.portlet.attachedfile.model.AttachedFile attachedFile,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.nss.portlet.attachedfile.model.AttachedFile updateImpl(
        com.nss.portlet.attachedfile.model.AttachedFile attachedFile,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.nss.portlet.attachedfile.model.AttachedFile findByPrimaryKey(
        java.lang.String attachedFileId)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.attachedfile.NoSuchAttachedFileException;

    public com.nss.portlet.attachedfile.model.AttachedFile fetchByPrimaryKey(
        java.lang.String attachedFileId)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.attachedfile.model.AttachedFile> findByAttachedFileCode(
        java.lang.String attachedFileCode)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.attachedfile.model.AttachedFile> findByAttachedFileCode(
        java.lang.String attachedFileCode, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.attachedfile.model.AttachedFile> findByAttachedFileCode(
        java.lang.String attachedFileCode, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.attachedfile.model.AttachedFile findByAttachedFileCode_First(
        java.lang.String attachedFileCode,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.attachedfile.NoSuchAttachedFileException;

    public com.nss.portlet.attachedfile.model.AttachedFile findByAttachedFileCode_Last(
        java.lang.String attachedFileCode,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.attachedfile.NoSuchAttachedFileException;

    public com.nss.portlet.attachedfile.model.AttachedFile[] findByAttachedFileCode_PrevAndNext(
        java.lang.String attachedFileId, java.lang.String attachedFileCode,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.attachedfile.NoSuchAttachedFileException;

    public java.util.List<com.nss.portlet.attachedfile.model.AttachedFile> findByAttachedFileName(
        java.lang.String attachedFileName)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.attachedfile.model.AttachedFile> findByAttachedFileName(
        java.lang.String attachedFileName, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.attachedfile.model.AttachedFile> findByAttachedFileName(
        java.lang.String attachedFileName, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.attachedfile.model.AttachedFile findByAttachedFileName_First(
        java.lang.String attachedFileName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.attachedfile.NoSuchAttachedFileException;

    public com.nss.portlet.attachedfile.model.AttachedFile findByAttachedFileName_Last(
        java.lang.String attachedFileName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.attachedfile.NoSuchAttachedFileException;

    public com.nss.portlet.attachedfile.model.AttachedFile[] findByAttachedFileName_PrevAndNext(
        java.lang.String attachedFileId, java.lang.String attachedFileName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.attachedfile.NoSuchAttachedFileException;

    public java.util.List<com.nss.portlet.attachedfile.model.AttachedFile> findByDescription(
        java.lang.String description) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.attachedfile.model.AttachedFile> findByDescription(
        java.lang.String description, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.attachedfile.model.AttachedFile> findByDescription(
        java.lang.String description, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.attachedfile.model.AttachedFile findByDescription_First(
        java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.attachedfile.NoSuchAttachedFileException;

    public com.nss.portlet.attachedfile.model.AttachedFile findByDescription_Last(
        java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.attachedfile.NoSuchAttachedFileException;

    public com.nss.portlet.attachedfile.model.AttachedFile[] findByDescription_PrevAndNext(
        java.lang.String attachedFileId, java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.attachedfile.NoSuchAttachedFileException;

    public java.util.List<com.nss.portlet.attachedfile.model.AttachedFile> findByC_N_D(
        java.lang.String attachedFileCode, java.lang.String attachedFileName,
        java.lang.String description) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.attachedfile.model.AttachedFile> findByC_N_D(
        java.lang.String attachedFileCode, java.lang.String attachedFileName,
        java.lang.String description, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.attachedfile.model.AttachedFile> findByC_N_D(
        java.lang.String attachedFileCode, java.lang.String attachedFileName,
        java.lang.String description, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.attachedfile.model.AttachedFile findByC_N_D_First(
        java.lang.String attachedFileCode, java.lang.String attachedFileName,
        java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.attachedfile.NoSuchAttachedFileException;

    public com.nss.portlet.attachedfile.model.AttachedFile findByC_N_D_Last(
        java.lang.String attachedFileCode, java.lang.String attachedFileName,
        java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.attachedfile.NoSuchAttachedFileException;

    public com.nss.portlet.attachedfile.model.AttachedFile[] findByC_N_D_PrevAndNext(
        java.lang.String attachedFileId, java.lang.String attachedFileCode,
        java.lang.String attachedFileName, java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.attachedfile.NoSuchAttachedFileException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.attachedfile.model.AttachedFile> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.attachedfile.model.AttachedFile> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.attachedfile.model.AttachedFile> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeByAttachedFileCode(java.lang.String attachedFileCode)
        throws com.liferay.portal.SystemException;

    public void removeByAttachedFileName(java.lang.String attachedFileName)
        throws com.liferay.portal.SystemException;

    public void removeByDescription(java.lang.String description)
        throws com.liferay.portal.SystemException;

    public void removeByC_N_D(java.lang.String attachedFileCode,
        java.lang.String attachedFileName, java.lang.String description)
        throws com.liferay.portal.SystemException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countByAttachedFileCode(java.lang.String attachedFileCode)
        throws com.liferay.portal.SystemException;

    public int countByAttachedFileName(java.lang.String attachedFileName)
        throws com.liferay.portal.SystemException;

    public int countByDescription(java.lang.String description)
        throws com.liferay.portal.SystemException;

    public int countByC_N_D(java.lang.String attachedFileCode,
        java.lang.String attachedFileName, java.lang.String description)
        throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;
}
