package com.sgs.portlet.onedoor.service.persistence;

public interface PmlOneDoorReceiveFilePersistence {
    public com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile create(
        java.lang.String fileId);

    public com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile remove(
        java.lang.String fileId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlOneDoorReceiveFileException;

    public com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile remove(
        com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile pmlOneDoorReceiveFile)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(PmlOneDoorReceiveFile pmlOneDoorReceiveFile, boolean merge)</code>.
     */
    public com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile update(
        com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile pmlOneDoorReceiveFile)
        throws com.liferay.portal.SystemException;

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlOneDoorReceiveFile the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlOneDoorReceiveFile is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile update(
        com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile pmlOneDoorReceiveFile,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile updateImpl(
        com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile pmlOneDoorReceiveFile,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile findByPrimaryKey(
        java.lang.String fileId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlOneDoorReceiveFileException;

    public com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile fetchByPrimaryKey(
        java.lang.String fileId) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> findByFileTypeId(
        java.lang.String fileTypeId) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> findByFileTypeId(
        java.lang.String fileTypeId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> findByFileTypeId(
        java.lang.String fileTypeId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile findByFileTypeId_First(
        java.lang.String fileTypeId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlOneDoorReceiveFileException;

    public com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile findByFileTypeId_Last(
        java.lang.String fileTypeId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlOneDoorReceiveFileException;

    public com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile[] findByFileTypeId_PrevAndNext(
        java.lang.String fileId, java.lang.String fileTypeId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlOneDoorReceiveFileException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> findByApplicationDate(
        java.util.Date applicationDate)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> findByApplicationDate(
        java.util.Date applicationDate, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> findByApplicationDate(
        java.util.Date applicationDate, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile findByApplicationDate_First(
        java.util.Date applicationDate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlOneDoorReceiveFileException;

    public com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile findByApplicationDate_Last(
        java.util.Date applicationDate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlOneDoorReceiveFileException;

    public com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile[] findByApplicationDate_PrevAndNext(
        java.lang.String fileId, java.util.Date applicationDate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlOneDoorReceiveFileException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> findByApplicantName(
        java.lang.String applicantName)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> findByApplicantName(
        java.lang.String applicantName, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> findByApplicantName(
        java.lang.String applicantName, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile findByApplicantName_First(
        java.lang.String applicantName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlOneDoorReceiveFileException;

    public com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile findByApplicantName_Last(
        java.lang.String applicantName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlOneDoorReceiveFileException;

    public com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile[] findByApplicantName_PrevAndNext(
        java.lang.String fileId, java.lang.String applicantName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlOneDoorReceiveFileException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> findByOrganization(
        java.lang.String organization)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> findByOrganization(
        java.lang.String organization, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> findByOrganization(
        java.lang.String organization, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile findByOrganization_First(
        java.lang.String organization,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlOneDoorReceiveFileException;

    public com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile findByOrganization_Last(
        java.lang.String organization,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlOneDoorReceiveFileException;

    public com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile[] findByOrganization_PrevAndNext(
        java.lang.String fileId, java.lang.String organization,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlOneDoorReceiveFileException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> findByPermanentAddress(
        java.lang.String permanentAddress)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> findByPermanentAddress(
        java.lang.String permanentAddress, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> findByPermanentAddress(
        java.lang.String permanentAddress, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile findByPermanentAddress_First(
        java.lang.String permanentAddress,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlOneDoorReceiveFileException;

    public com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile findByPermanentAddress_Last(
        java.lang.String permanentAddress,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlOneDoorReceiveFileException;

    public com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile[] findByPermanentAddress_PrevAndNext(
        java.lang.String fileId, java.lang.String permanentAddress,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlOneDoorReceiveFileException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> findByAuthorisedLetter(
        java.lang.String authorisedLetter)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> findByAuthorisedLetter(
        java.lang.String authorisedLetter, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> findByAuthorisedLetter(
        java.lang.String authorisedLetter, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile findByAuthorisedLetter_First(
        java.lang.String authorisedLetter,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlOneDoorReceiveFileException;

    public com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile findByAuthorisedLetter_Last(
        java.lang.String authorisedLetter,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlOneDoorReceiveFileException;

    public com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile[] findByAuthorisedLetter_PrevAndNext(
        java.lang.String fileId, java.lang.String authorisedLetter,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlOneDoorReceiveFileException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> findByDateCreated(
        java.util.Date dateCreated) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> findByDateCreated(
        java.util.Date dateCreated, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> findByDateCreated(
        java.util.Date dateCreated, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile findByDateCreated_First(
        java.util.Date dateCreated,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlOneDoorReceiveFileException;

    public com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile findByDateCreated_Last(
        java.util.Date dateCreated,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlOneDoorReceiveFileException;

    public com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile[] findByDateCreated_PrevAndNext(
        java.lang.String fileId, java.util.Date dateCreated,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlOneDoorReceiveFileException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> findByFileTypeId_ApplicationDate(
        java.lang.String fileTypeId, java.util.Date applicationDate)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> findByFileTypeId_ApplicationDate(
        java.lang.String fileTypeId, java.util.Date applicationDate, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> findByFileTypeId_ApplicationDate(
        java.lang.String fileTypeId, java.util.Date applicationDate, int start,
        int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile findByFileTypeId_ApplicationDate_First(
        java.lang.String fileTypeId, java.util.Date applicationDate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlOneDoorReceiveFileException;

    public com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile findByFileTypeId_ApplicationDate_Last(
        java.lang.String fileTypeId, java.util.Date applicationDate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlOneDoorReceiveFileException;

    public com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile[] findByFileTypeId_ApplicationDate_PrevAndNext(
        java.lang.String fileId, java.lang.String fileTypeId,
        java.util.Date applicationDate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlOneDoorReceiveFileException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> findByFileTypeId_ExactReturningDate(
        java.lang.String fileTypeId, java.util.Date exactReturningDate)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> findByFileTypeId_ExactReturningDate(
        java.lang.String fileTypeId, java.util.Date exactReturningDate,
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> findByFileTypeId_ExactReturningDate(
        java.lang.String fileTypeId, java.util.Date exactReturningDate,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile findByFileTypeId_ExactReturningDate_First(
        java.lang.String fileTypeId, java.util.Date exactReturningDate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlOneDoorReceiveFileException;

    public com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile findByFileTypeId_ExactReturningDate_Last(
        java.lang.String fileTypeId, java.util.Date exactReturningDate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlOneDoorReceiveFileException;

    public com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile[] findByFileTypeId_ExactReturningDate_PrevAndNext(
        java.lang.String fileId, java.lang.String fileTypeId,
        java.util.Date exactReturningDate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlOneDoorReceiveFileException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> findByFileType_NumberReceipt(
        java.lang.String fileTypeId, java.lang.String numberReceipt)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> findByFileType_NumberReceipt(
        java.lang.String fileTypeId, java.lang.String numberReceipt, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> findByFileType_NumberReceipt(
        java.lang.String fileTypeId, java.lang.String numberReceipt, int start,
        int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile findByFileType_NumberReceipt_First(
        java.lang.String fileTypeId, java.lang.String numberReceipt,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlOneDoorReceiveFileException;

    public com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile findByFileType_NumberReceipt_Last(
        java.lang.String fileTypeId, java.lang.String numberReceipt,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlOneDoorReceiveFileException;

    public com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile[] findByFileType_NumberReceipt_PrevAndNext(
        java.lang.String fileId, java.lang.String fileTypeId,
        java.lang.String numberReceipt,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlOneDoorReceiveFileException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeByFileTypeId(java.lang.String fileTypeId)
        throws com.liferay.portal.SystemException;

    public void removeByApplicationDate(java.util.Date applicationDate)
        throws com.liferay.portal.SystemException;

    public void removeByApplicantName(java.lang.String applicantName)
        throws com.liferay.portal.SystemException;

    public void removeByOrganization(java.lang.String organization)
        throws com.liferay.portal.SystemException;

    public void removeByPermanentAddress(java.lang.String permanentAddress)
        throws com.liferay.portal.SystemException;

    public void removeByAuthorisedLetter(java.lang.String authorisedLetter)
        throws com.liferay.portal.SystemException;

    public void removeByDateCreated(java.util.Date dateCreated)
        throws com.liferay.portal.SystemException;

    public void removeByFileTypeId_ApplicationDate(
        java.lang.String fileTypeId, java.util.Date applicationDate)
        throws com.liferay.portal.SystemException;

    public void removeByFileTypeId_ExactReturningDate(
        java.lang.String fileTypeId, java.util.Date exactReturningDate)
        throws com.liferay.portal.SystemException;

    public void removeByFileType_NumberReceipt(java.lang.String fileTypeId,
        java.lang.String numberReceipt)
        throws com.liferay.portal.SystemException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countByFileTypeId(java.lang.String fileTypeId)
        throws com.liferay.portal.SystemException;

    public int countByApplicationDate(java.util.Date applicationDate)
        throws com.liferay.portal.SystemException;

    public int countByApplicantName(java.lang.String applicantName)
        throws com.liferay.portal.SystemException;

    public int countByOrganization(java.lang.String organization)
        throws com.liferay.portal.SystemException;

    public int countByPermanentAddress(java.lang.String permanentAddress)
        throws com.liferay.portal.SystemException;

    public int countByAuthorisedLetter(java.lang.String authorisedLetter)
        throws com.liferay.portal.SystemException;

    public int countByDateCreated(java.util.Date dateCreated)
        throws com.liferay.portal.SystemException;

    public int countByFileTypeId_ApplicationDate(java.lang.String fileTypeId,
        java.util.Date applicationDate)
        throws com.liferay.portal.SystemException;

    public int countByFileTypeId_ExactReturningDate(
        java.lang.String fileTypeId, java.util.Date exactReturningDate)
        throws com.liferay.portal.SystemException;

    public int countByFileType_NumberReceipt(java.lang.String fileTypeId,
        java.lang.String numberReceipt)
        throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;

    public void registerListener(
        com.liferay.portal.model.ModelListener listener);

    public void unregisterListener(
        com.liferay.portal.model.ModelListener listener);
}
