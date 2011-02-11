package com.sgs.portlet.onedoor.service.persistence;

public class PmlOneDoorReceiveFileUtil {
    private static PmlOneDoorReceiveFilePersistence _persistence;

    public static com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile create(
        java.lang.String fileId) {
        return getPersistence().create(fileId);
    }

    public static com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile remove(
        java.lang.String fileId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlOneDoorReceiveFileException {
        return getPersistence().remove(fileId);
    }

    public static com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile remove(
        com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile pmlOneDoorReceiveFile)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(pmlOneDoorReceiveFile);
    }

    /**
     * @deprecated Use <code>update(PmlOneDoorReceiveFile pmlOneDoorReceiveFile, boolean merge)</code>.
     */
    public static com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile update(
        com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile pmlOneDoorReceiveFile)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(pmlOneDoorReceiveFile);
    }

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
    public static com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile update(
        com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile pmlOneDoorReceiveFile,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().update(pmlOneDoorReceiveFile, merge);
    }

    public static com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile updateImpl(
        com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile pmlOneDoorReceiveFile,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(pmlOneDoorReceiveFile, merge);
    }

    public static com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile findByPrimaryKey(
        java.lang.String fileId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlOneDoorReceiveFileException {
        return getPersistence().findByPrimaryKey(fileId);
    }

    public static com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile fetchByPrimaryKey(
        java.lang.String fileId) throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(fileId);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> findByFileTypeId(
        java.lang.String fileTypeId) throws com.liferay.portal.SystemException {
        return getPersistence().findByFileTypeId(fileTypeId);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> findByFileTypeId(
        java.lang.String fileTypeId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByFileTypeId(fileTypeId, start, end);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> findByFileTypeId(
        java.lang.String fileTypeId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByFileTypeId(fileTypeId, start, end, obc);
    }

    public static com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile findByFileTypeId_First(
        java.lang.String fileTypeId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlOneDoorReceiveFileException {
        return getPersistence().findByFileTypeId_First(fileTypeId, obc);
    }

    public static com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile findByFileTypeId_Last(
        java.lang.String fileTypeId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlOneDoorReceiveFileException {
        return getPersistence().findByFileTypeId_Last(fileTypeId, obc);
    }

    public static com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile[] findByFileTypeId_PrevAndNext(
        java.lang.String fileId, java.lang.String fileTypeId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlOneDoorReceiveFileException {
        return getPersistence()
                   .findByFileTypeId_PrevAndNext(fileId, fileTypeId, obc);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> findByApplicationDate(
        java.util.Date applicationDate)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByApplicationDate(applicationDate);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> findByApplicationDate(
        java.util.Date applicationDate, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByApplicationDate(applicationDate, start, end);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> findByApplicationDate(
        java.util.Date applicationDate, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByApplicationDate(applicationDate, start, end, obc);
    }

    public static com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile findByApplicationDate_First(
        java.util.Date applicationDate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlOneDoorReceiveFileException {
        return getPersistence().findByApplicationDate_First(applicationDate, obc);
    }

    public static com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile findByApplicationDate_Last(
        java.util.Date applicationDate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlOneDoorReceiveFileException {
        return getPersistence().findByApplicationDate_Last(applicationDate, obc);
    }

    public static com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile[] findByApplicationDate_PrevAndNext(
        java.lang.String fileId, java.util.Date applicationDate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlOneDoorReceiveFileException {
        return getPersistence()
                   .findByApplicationDate_PrevAndNext(fileId, applicationDate,
            obc);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> findByApplicantName(
        java.lang.String applicantName)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByApplicantName(applicantName);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> findByApplicantName(
        java.lang.String applicantName, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByApplicantName(applicantName, start, end);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> findByApplicantName(
        java.lang.String applicantName, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByApplicantName(applicantName, start, end, obc);
    }

    public static com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile findByApplicantName_First(
        java.lang.String applicantName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlOneDoorReceiveFileException {
        return getPersistence().findByApplicantName_First(applicantName, obc);
    }

    public static com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile findByApplicantName_Last(
        java.lang.String applicantName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlOneDoorReceiveFileException {
        return getPersistence().findByApplicantName_Last(applicantName, obc);
    }

    public static com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile[] findByApplicantName_PrevAndNext(
        java.lang.String fileId, java.lang.String applicantName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlOneDoorReceiveFileException {
        return getPersistence()
                   .findByApplicantName_PrevAndNext(fileId, applicantName, obc);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> findByOrganization(
        java.lang.String organization)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByOrganization(organization);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> findByOrganization(
        java.lang.String organization, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByOrganization(organization, start, end);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> findByOrganization(
        java.lang.String organization, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByOrganization(organization, start, end, obc);
    }

    public static com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile findByOrganization_First(
        java.lang.String organization,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlOneDoorReceiveFileException {
        return getPersistence().findByOrganization_First(organization, obc);
    }

    public static com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile findByOrganization_Last(
        java.lang.String organization,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlOneDoorReceiveFileException {
        return getPersistence().findByOrganization_Last(organization, obc);
    }

    public static com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile[] findByOrganization_PrevAndNext(
        java.lang.String fileId, java.lang.String organization,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlOneDoorReceiveFileException {
        return getPersistence()
                   .findByOrganization_PrevAndNext(fileId, organization, obc);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> findByPermanentAddress(
        java.lang.String permanentAddress)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByPermanentAddress(permanentAddress);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> findByPermanentAddress(
        java.lang.String permanentAddress, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByPermanentAddress(permanentAddress, start, end);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> findByPermanentAddress(
        java.lang.String permanentAddress, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByPermanentAddress(permanentAddress, start, end, obc);
    }

    public static com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile findByPermanentAddress_First(
        java.lang.String permanentAddress,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlOneDoorReceiveFileException {
        return getPersistence()
                   .findByPermanentAddress_First(permanentAddress, obc);
    }

    public static com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile findByPermanentAddress_Last(
        java.lang.String permanentAddress,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlOneDoorReceiveFileException {
        return getPersistence()
                   .findByPermanentAddress_Last(permanentAddress, obc);
    }

    public static com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile[] findByPermanentAddress_PrevAndNext(
        java.lang.String fileId, java.lang.String permanentAddress,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlOneDoorReceiveFileException {
        return getPersistence()
                   .findByPermanentAddress_PrevAndNext(fileId,
            permanentAddress, obc);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> findByAuthorisedLetter(
        java.lang.String authorisedLetter)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByAuthorisedLetter(authorisedLetter);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> findByAuthorisedLetter(
        java.lang.String authorisedLetter, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByAuthorisedLetter(authorisedLetter, start, end);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> findByAuthorisedLetter(
        java.lang.String authorisedLetter, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByAuthorisedLetter(authorisedLetter, start, end, obc);
    }

    public static com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile findByAuthorisedLetter_First(
        java.lang.String authorisedLetter,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlOneDoorReceiveFileException {
        return getPersistence()
                   .findByAuthorisedLetter_First(authorisedLetter, obc);
    }

    public static com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile findByAuthorisedLetter_Last(
        java.lang.String authorisedLetter,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlOneDoorReceiveFileException {
        return getPersistence()
                   .findByAuthorisedLetter_Last(authorisedLetter, obc);
    }

    public static com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile[] findByAuthorisedLetter_PrevAndNext(
        java.lang.String fileId, java.lang.String authorisedLetter,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlOneDoorReceiveFileException {
        return getPersistence()
                   .findByAuthorisedLetter_PrevAndNext(fileId,
            authorisedLetter, obc);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> findByDateCreated(
        java.util.Date dateCreated) throws com.liferay.portal.SystemException {
        return getPersistence().findByDateCreated(dateCreated);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> findByDateCreated(
        java.util.Date dateCreated, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByDateCreated(dateCreated, start, end);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> findByDateCreated(
        java.util.Date dateCreated, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByDateCreated(dateCreated, start, end, obc);
    }

    public static com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile findByDateCreated_First(
        java.util.Date dateCreated,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlOneDoorReceiveFileException {
        return getPersistence().findByDateCreated_First(dateCreated, obc);
    }

    public static com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile findByDateCreated_Last(
        java.util.Date dateCreated,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlOneDoorReceiveFileException {
        return getPersistence().findByDateCreated_Last(dateCreated, obc);
    }

    public static com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile[] findByDateCreated_PrevAndNext(
        java.lang.String fileId, java.util.Date dateCreated,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlOneDoorReceiveFileException {
        return getPersistence()
                   .findByDateCreated_PrevAndNext(fileId, dateCreated, obc);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> findByFileTypeId_ApplicationDate(
        java.lang.String fileTypeId, java.util.Date applicationDate)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByFileTypeId_ApplicationDate(fileTypeId, applicationDate);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> findByFileTypeId_ApplicationDate(
        java.lang.String fileTypeId, java.util.Date applicationDate, int start,
        int end) throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByFileTypeId_ApplicationDate(fileTypeId,
            applicationDate, start, end);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> findByFileTypeId_ApplicationDate(
        java.lang.String fileTypeId, java.util.Date applicationDate, int start,
        int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByFileTypeId_ApplicationDate(fileTypeId,
            applicationDate, start, end, obc);
    }

    public static com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile findByFileTypeId_ApplicationDate_First(
        java.lang.String fileTypeId, java.util.Date applicationDate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlOneDoorReceiveFileException {
        return getPersistence()
                   .findByFileTypeId_ApplicationDate_First(fileTypeId,
            applicationDate, obc);
    }

    public static com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile findByFileTypeId_ApplicationDate_Last(
        java.lang.String fileTypeId, java.util.Date applicationDate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlOneDoorReceiveFileException {
        return getPersistence()
                   .findByFileTypeId_ApplicationDate_Last(fileTypeId,
            applicationDate, obc);
    }

    public static com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile[] findByFileTypeId_ApplicationDate_PrevAndNext(
        java.lang.String fileId, java.lang.String fileTypeId,
        java.util.Date applicationDate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlOneDoorReceiveFileException {
        return getPersistence()
                   .findByFileTypeId_ApplicationDate_PrevAndNext(fileId,
            fileTypeId, applicationDate, obc);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> findByFileTypeId_ExactReturningDate(
        java.lang.String fileTypeId, java.util.Date exactReturningDate)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByFileTypeId_ExactReturningDate(fileTypeId,
            exactReturningDate);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> findByFileTypeId_ExactReturningDate(
        java.lang.String fileTypeId, java.util.Date exactReturningDate,
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByFileTypeId_ExactReturningDate(fileTypeId,
            exactReturningDate, start, end);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> findByFileTypeId_ExactReturningDate(
        java.lang.String fileTypeId, java.util.Date exactReturningDate,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByFileTypeId_ExactReturningDate(fileTypeId,
            exactReturningDate, start, end, obc);
    }

    public static com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile findByFileTypeId_ExactReturningDate_First(
        java.lang.String fileTypeId, java.util.Date exactReturningDate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlOneDoorReceiveFileException {
        return getPersistence()
                   .findByFileTypeId_ExactReturningDate_First(fileTypeId,
            exactReturningDate, obc);
    }

    public static com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile findByFileTypeId_ExactReturningDate_Last(
        java.lang.String fileTypeId, java.util.Date exactReturningDate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlOneDoorReceiveFileException {
        return getPersistence()
                   .findByFileTypeId_ExactReturningDate_Last(fileTypeId,
            exactReturningDate, obc);
    }

    public static com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile[] findByFileTypeId_ExactReturningDate_PrevAndNext(
        java.lang.String fileId, java.lang.String fileTypeId,
        java.util.Date exactReturningDate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlOneDoorReceiveFileException {
        return getPersistence()
                   .findByFileTypeId_ExactReturningDate_PrevAndNext(fileId,
            fileTypeId, exactReturningDate, obc);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> findByFileType_NumberReceipt(
        java.lang.String fileTypeId, java.lang.String numberReceipt)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByFileType_NumberReceipt(fileTypeId, numberReceipt);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> findByFileType_NumberReceipt(
        java.lang.String fileTypeId, java.lang.String numberReceipt, int start,
        int end) throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByFileType_NumberReceipt(fileTypeId, numberReceipt,
            start, end);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> findByFileType_NumberReceipt(
        java.lang.String fileTypeId, java.lang.String numberReceipt, int start,
        int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByFileType_NumberReceipt(fileTypeId, numberReceipt,
            start, end, obc);
    }

    public static com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile findByFileType_NumberReceipt_First(
        java.lang.String fileTypeId, java.lang.String numberReceipt,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlOneDoorReceiveFileException {
        return getPersistence()
                   .findByFileType_NumberReceipt_First(fileTypeId,
            numberReceipt, obc);
    }

    public static com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile findByFileType_NumberReceipt_Last(
        java.lang.String fileTypeId, java.lang.String numberReceipt,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlOneDoorReceiveFileException {
        return getPersistence()
                   .findByFileType_NumberReceipt_Last(fileTypeId,
            numberReceipt, obc);
    }

    public static com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile[] findByFileType_NumberReceipt_PrevAndNext(
        java.lang.String fileId, java.lang.String fileTypeId,
        java.lang.String numberReceipt,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlOneDoorReceiveFileException {
        return getPersistence()
                   .findByFileType_NumberReceipt_PrevAndNext(fileId,
            fileTypeId, numberReceipt, obc);
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

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end, obc);
    }

    public static void removeByFileTypeId(java.lang.String fileTypeId)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByFileTypeId(fileTypeId);
    }

    public static void removeByApplicationDate(java.util.Date applicationDate)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByApplicationDate(applicationDate);
    }

    public static void removeByApplicantName(java.lang.String applicantName)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByApplicantName(applicantName);
    }

    public static void removeByOrganization(java.lang.String organization)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByOrganization(organization);
    }

    public static void removeByPermanentAddress(
        java.lang.String permanentAddress)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByPermanentAddress(permanentAddress);
    }

    public static void removeByAuthorisedLetter(
        java.lang.String authorisedLetter)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByAuthorisedLetter(authorisedLetter);
    }

    public static void removeByDateCreated(java.util.Date dateCreated)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByDateCreated(dateCreated);
    }

    public static void removeByFileTypeId_ApplicationDate(
        java.lang.String fileTypeId, java.util.Date applicationDate)
        throws com.liferay.portal.SystemException {
        getPersistence()
            .removeByFileTypeId_ApplicationDate(fileTypeId, applicationDate);
    }

    public static void removeByFileTypeId_ExactReturningDate(
        java.lang.String fileTypeId, java.util.Date exactReturningDate)
        throws com.liferay.portal.SystemException {
        getPersistence()
            .removeByFileTypeId_ExactReturningDate(fileTypeId,
            exactReturningDate);
    }

    public static void removeByFileType_NumberReceipt(
        java.lang.String fileTypeId, java.lang.String numberReceipt)
        throws com.liferay.portal.SystemException {
        getPersistence()
            .removeByFileType_NumberReceipt(fileTypeId, numberReceipt);
    }

    public static void removeAll() throws com.liferay.portal.SystemException {
        getPersistence().removeAll();
    }

    public static int countByFileTypeId(java.lang.String fileTypeId)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByFileTypeId(fileTypeId);
    }

    public static int countByApplicationDate(java.util.Date applicationDate)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByApplicationDate(applicationDate);
    }

    public static int countByApplicantName(java.lang.String applicantName)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByApplicantName(applicantName);
    }

    public static int countByOrganization(java.lang.String organization)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByOrganization(organization);
    }

    public static int countByPermanentAddress(java.lang.String permanentAddress)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByPermanentAddress(permanentAddress);
    }

    public static int countByAuthorisedLetter(java.lang.String authorisedLetter)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByAuthorisedLetter(authorisedLetter);
    }

    public static int countByDateCreated(java.util.Date dateCreated)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByDateCreated(dateCreated);
    }

    public static int countByFileTypeId_ApplicationDate(
        java.lang.String fileTypeId, java.util.Date applicationDate)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .countByFileTypeId_ApplicationDate(fileTypeId,
            applicationDate);
    }

    public static int countByFileTypeId_ExactReturningDate(
        java.lang.String fileTypeId, java.util.Date exactReturningDate)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .countByFileTypeId_ExactReturningDate(fileTypeId,
            exactReturningDate);
    }

    public static int countByFileType_NumberReceipt(
        java.lang.String fileTypeId, java.lang.String numberReceipt)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .countByFileType_NumberReceipt(fileTypeId, numberReceipt);
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

    public static PmlOneDoorReceiveFilePersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(PmlOneDoorReceiveFilePersistence persistence) {
        _persistence = persistence;
    }
}
