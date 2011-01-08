package com.sgs.portlet.onedoorpccc.service.persistence;

public class PmlFileReturningInfoUtil {
    private static PmlFileReturningInfoPersistence _persistence;

    public static com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo create(
        long fileReturningInfoId) {
        return getPersistence().create(fileReturningInfoId);
    }

    public static com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo remove(
        long fileReturningInfoId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchPmlFileReturningInfoException {
        return getPersistence().remove(fileReturningInfoId);
    }

    public static com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo remove(
        com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo pmlFileReturningInfo)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(pmlFileReturningInfo);
    }

    /**
     * @deprecated Use <code>update(PmlFileReturningInfo pmlFileReturningInfo, boolean merge)</code>.
     */
    public static com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo update(
        com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo pmlFileReturningInfo)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(pmlFileReturningInfo);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlFileReturningInfo the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlFileReturningInfo is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public static com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo update(
        com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo pmlFileReturningInfo,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().update(pmlFileReturningInfo, merge);
    }

    public static com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo updateImpl(
        com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo pmlFileReturningInfo,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(pmlFileReturningInfo, merge);
    }

    public static com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo findByPrimaryKey(
        long fileReturningInfoId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchPmlFileReturningInfoException {
        return getPersistence().findByPrimaryKey(fileReturningInfoId);
    }

    public static com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo fetchByPrimaryKey(
        long fileReturningInfoId) throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(fileReturningInfoId);
    }

    public static java.util.List<com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo> findByFileId(
        java.lang.String fileId) throws com.liferay.portal.SystemException {
        return getPersistence().findByFileId(fileId);
    }

    public static java.util.List<com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo> findByFileId(
        java.lang.String fileId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByFileId(fileId, start, end);
    }

    public static java.util.List<com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo> findByFileId(
        java.lang.String fileId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByFileId(fileId, start, end, obc);
    }

    public static com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo findByFileId_First(
        java.lang.String fileId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchPmlFileReturningInfoException {
        return getPersistence().findByFileId_First(fileId, obc);
    }

    public static com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo findByFileId_Last(
        java.lang.String fileId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchPmlFileReturningInfoException {
        return getPersistence().findByFileId_Last(fileId, obc);
    }

    public static com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo[] findByFileId_PrevAndNext(
        long fileReturningInfoId, java.lang.String fileId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchPmlFileReturningInfoException {
        return getPersistence()
                   .findByFileId_PrevAndNext(fileReturningInfoId, fileId, obc);
    }

    public static java.util.List<com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo> findByFileSender(
        java.lang.String fileSender) throws com.liferay.portal.SystemException {
        return getPersistence().findByFileSender(fileSender);
    }

    public static java.util.List<com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo> findByFileSender(
        java.lang.String fileSender, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByFileSender(fileSender, start, end);
    }

    public static java.util.List<com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo> findByFileSender(
        java.lang.String fileSender, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByFileSender(fileSender, start, end, obc);
    }

    public static com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo findByFileSender_First(
        java.lang.String fileSender,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchPmlFileReturningInfoException {
        return getPersistence().findByFileSender_First(fileSender, obc);
    }

    public static com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo findByFileSender_Last(
        java.lang.String fileSender,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchPmlFileReturningInfoException {
        return getPersistence().findByFileSender_Last(fileSender, obc);
    }

    public static com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo[] findByFileSender_PrevAndNext(
        long fileReturningInfoId, java.lang.String fileSender,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchPmlFileReturningInfoException {
        return getPersistence()
                   .findByFileSender_PrevAndNext(fileReturningInfoId,
            fileSender, obc);
    }

    public static java.util.List<com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo> findByLicenseNumber(
        java.lang.String licenseNumber)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByLicenseNumber(licenseNumber);
    }

    public static java.util.List<com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo> findByLicenseNumber(
        java.lang.String licenseNumber, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByLicenseNumber(licenseNumber, start, end);
    }

    public static java.util.List<com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo> findByLicenseNumber(
        java.lang.String licenseNumber, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByLicenseNumber(licenseNumber, start, end, obc);
    }

    public static com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo findByLicenseNumber_First(
        java.lang.String licenseNumber,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchPmlFileReturningInfoException {
        return getPersistence().findByLicenseNumber_First(licenseNumber, obc);
    }

    public static com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo findByLicenseNumber_Last(
        java.lang.String licenseNumber,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchPmlFileReturningInfoException {
        return getPersistence().findByLicenseNumber_Last(licenseNumber, obc);
    }

    public static com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo[] findByLicenseNumber_PrevAndNext(
        long fileReturningInfoId, java.lang.String licenseNumber,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchPmlFileReturningInfoException {
        return getPersistence()
                   .findByLicenseNumber_PrevAndNext(fileReturningInfoId,
            licenseNumber, obc);
    }

    public static java.util.List<com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo> findByIssuingDateLicense(
        java.util.Date issuingDateLicense)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByIssuingDateLicense(issuingDateLicense);
    }

    public static java.util.List<com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo> findByIssuingDateLicense(
        java.util.Date issuingDateLicense, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByIssuingDateLicense(issuingDateLicense, start, end);
    }

    public static java.util.List<com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo> findByIssuingDateLicense(
        java.util.Date issuingDateLicense, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByIssuingDateLicense(issuingDateLicense, start, end, obc);
    }

    public static com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo findByIssuingDateLicense_First(
        java.util.Date issuingDateLicense,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchPmlFileReturningInfoException {
        return getPersistence()
                   .findByIssuingDateLicense_First(issuingDateLicense, obc);
    }

    public static com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo findByIssuingDateLicense_Last(
        java.util.Date issuingDateLicense,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchPmlFileReturningInfoException {
        return getPersistence()
                   .findByIssuingDateLicense_Last(issuingDateLicense, obc);
    }

    public static com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo[] findByIssuingDateLicense_PrevAndNext(
        long fileReturningInfoId, java.util.Date issuingDateLicense,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchPmlFileReturningInfoException {
        return getPersistence()
                   .findByIssuingDateLicense_PrevAndNext(fileReturningInfoId,
            issuingDateLicense, obc);
    }

    public static java.util.List<com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo> findByReceiveLicenseDate(
        java.util.Date receiveLicenseDate)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByReceiveLicenseDate(receiveLicenseDate);
    }

    public static java.util.List<com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo> findByReceiveLicenseDate(
        java.util.Date receiveLicenseDate, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByReceiveLicenseDate(receiveLicenseDate, start, end);
    }

    public static java.util.List<com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo> findByReceiveLicenseDate(
        java.util.Date receiveLicenseDate, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByReceiveLicenseDate(receiveLicenseDate, start, end, obc);
    }

    public static com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo findByReceiveLicenseDate_First(
        java.util.Date receiveLicenseDate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchPmlFileReturningInfoException {
        return getPersistence()
                   .findByReceiveLicenseDate_First(receiveLicenseDate, obc);
    }

    public static com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo findByReceiveLicenseDate_Last(
        java.util.Date receiveLicenseDate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchPmlFileReturningInfoException {
        return getPersistence()
                   .findByReceiveLicenseDate_Last(receiveLicenseDate, obc);
    }

    public static com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo[] findByReceiveLicenseDate_PrevAndNext(
        long fileReturningInfoId, java.util.Date receiveLicenseDate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchPmlFileReturningInfoException {
        return getPersistence()
                   .findByReceiveLicenseDate_PrevAndNext(fileReturningInfoId,
            receiveLicenseDate, obc);
    }

    public static java.util.List<com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo> findByDocumentNumber(
        java.lang.String documentNumber)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByDocumentNumber(documentNumber);
    }

    public static java.util.List<com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo> findByDocumentNumber(
        java.lang.String documentNumber, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByDocumentNumber(documentNumber, start, end);
    }

    public static java.util.List<com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo> findByDocumentNumber(
        java.lang.String documentNumber, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDocumentNumber(documentNumber, start, end, obc);
    }

    public static com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo findByDocumentNumber_First(
        java.lang.String documentNumber,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchPmlFileReturningInfoException {
        return getPersistence().findByDocumentNumber_First(documentNumber, obc);
    }

    public static com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo findByDocumentNumber_Last(
        java.lang.String documentNumber,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchPmlFileReturningInfoException {
        return getPersistence().findByDocumentNumber_Last(documentNumber, obc);
    }

    public static com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo[] findByDocumentNumber_PrevAndNext(
        long fileReturningInfoId, java.lang.String documentNumber,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchPmlFileReturningInfoException {
        return getPersistence()
                   .findByDocumentNumber_PrevAndNext(fileReturningInfoId,
            documentNumber, obc);
    }

    public static java.util.List<com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo> findByBillNumber(
        java.lang.String billNumber) throws com.liferay.portal.SystemException {
        return getPersistence().findByBillNumber(billNumber);
    }

    public static java.util.List<com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo> findByBillNumber(
        java.lang.String billNumber, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByBillNumber(billNumber, start, end);
    }

    public static java.util.List<com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo> findByBillNumber(
        java.lang.String billNumber, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByBillNumber(billNumber, start, end, obc);
    }

    public static com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo findByBillNumber_First(
        java.lang.String billNumber,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchPmlFileReturningInfoException {
        return getPersistence().findByBillNumber_First(billNumber, obc);
    }

    public static com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo findByBillNumber_Last(
        java.lang.String billNumber,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchPmlFileReturningInfoException {
        return getPersistence().findByBillNumber_Last(billNumber, obc);
    }

    public static com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo[] findByBillNumber_PrevAndNext(
        long fileReturningInfoId, java.lang.String billNumber,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchPmlFileReturningInfoException {
        return getPersistence()
                   .findByBillNumber_PrevAndNext(fileReturningInfoId,
            billNumber, obc);
    }

    public static java.util.List<com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo> findByNumberMoney(
        long numberMoney) throws com.liferay.portal.SystemException {
        return getPersistence().findByNumberMoney(numberMoney);
    }

    public static java.util.List<com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo> findByNumberMoney(
        long numberMoney, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByNumberMoney(numberMoney, start, end);
    }

    public static java.util.List<com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo> findByNumberMoney(
        long numberMoney, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByNumberMoney(numberMoney, start, end, obc);
    }

    public static com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo findByNumberMoney_First(
        long numberMoney, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchPmlFileReturningInfoException {
        return getPersistence().findByNumberMoney_First(numberMoney, obc);
    }

    public static com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo findByNumberMoney_Last(
        long numberMoney, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchPmlFileReturningInfoException {
        return getPersistence().findByNumberMoney_Last(numberMoney, obc);
    }

    public static com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo[] findByNumberMoney_PrevAndNext(
        long fileReturningInfoId, long numberMoney,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchPmlFileReturningInfoException {
        return getPersistence()
                   .findByNumberMoney_PrevAndNext(fileReturningInfoId,
            numberMoney, obc);
    }

    public static java.util.List<com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo> findByNote(
        java.lang.String note) throws com.liferay.portal.SystemException {
        return getPersistence().findByNote(note);
    }

    public static java.util.List<com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo> findByNote(
        java.lang.String note, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByNote(note, start, end);
    }

    public static java.util.List<com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo> findByNote(
        java.lang.String note, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByNote(note, start, end, obc);
    }

    public static com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo findByNote_First(
        java.lang.String note,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchPmlFileReturningInfoException {
        return getPersistence().findByNote_First(note, obc);
    }

    public static com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo findByNote_Last(
        java.lang.String note,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchPmlFileReturningInfoException {
        return getPersistence().findByNote_Last(note, obc);
    }

    public static com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo[] findByNote_PrevAndNext(
        long fileReturningInfoId, java.lang.String note,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchPmlFileReturningInfoException {
        return getPersistence()
                   .findByNote_PrevAndNext(fileReturningInfoId, note, obc);
    }

    public static java.util.List<com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo> findByConclude(
        java.lang.String conclude) throws com.liferay.portal.SystemException {
        return getPersistence().findByConclude(conclude);
    }

    public static java.util.List<com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo> findByConclude(
        java.lang.String conclude, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByConclude(conclude, start, end);
    }

    public static java.util.List<com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo> findByConclude(
        java.lang.String conclude, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByConclude(conclude, start, end, obc);
    }

    public static com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo findByConclude_First(
        java.lang.String conclude,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchPmlFileReturningInfoException {
        return getPersistence().findByConclude_First(conclude, obc);
    }

    public static com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo findByConclude_Last(
        java.lang.String conclude,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchPmlFileReturningInfoException {
        return getPersistence().findByConclude_Last(conclude, obc);
    }

    public static com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo[] findByConclude_PrevAndNext(
        long fileReturningInfoId, java.lang.String conclude,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchPmlFileReturningInfoException {
        return getPersistence()
                   .findByConclude_PrevAndNext(fileReturningInfoId, conclude,
            obc);
    }

    public static com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo findByFileReturningInfoIdFileId(
        java.lang.String fileId, long fileReturningInfoId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchPmlFileReturningInfoException {
        return getPersistence()
                   .findByFileReturningInfoIdFileId(fileId, fileReturningInfoId);
    }

    public static com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo fetchByFileReturningInfoIdFileId(
        java.lang.String fileId, long fileReturningInfoId)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .fetchByFileReturningInfoIdFileId(fileId, fileReturningInfoId);
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

    public static java.util.List<com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end, obc);
    }

    public static void removeByFileId(java.lang.String fileId)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByFileId(fileId);
    }

    public static void removeByFileSender(java.lang.String fileSender)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByFileSender(fileSender);
    }

    public static void removeByLicenseNumber(java.lang.String licenseNumber)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByLicenseNumber(licenseNumber);
    }

    public static void removeByIssuingDateLicense(
        java.util.Date issuingDateLicense)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByIssuingDateLicense(issuingDateLicense);
    }

    public static void removeByReceiveLicenseDate(
        java.util.Date receiveLicenseDate)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByReceiveLicenseDate(receiveLicenseDate);
    }

    public static void removeByDocumentNumber(java.lang.String documentNumber)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByDocumentNumber(documentNumber);
    }

    public static void removeByBillNumber(java.lang.String billNumber)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByBillNumber(billNumber);
    }

    public static void removeByNumberMoney(long numberMoney)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByNumberMoney(numberMoney);
    }

    public static void removeByNote(java.lang.String note)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByNote(note);
    }

    public static void removeByConclude(java.lang.String conclude)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByConclude(conclude);
    }

    public static void removeByFileReturningInfoIdFileId(
        java.lang.String fileId, long fileReturningInfoId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchPmlFileReturningInfoException {
        getPersistence()
            .removeByFileReturningInfoIdFileId(fileId, fileReturningInfoId);
    }

    public static void removeAll() throws com.liferay.portal.SystemException {
        getPersistence().removeAll();
    }

    public static int countByFileId(java.lang.String fileId)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByFileId(fileId);
    }

    public static int countByFileSender(java.lang.String fileSender)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByFileSender(fileSender);
    }

    public static int countByLicenseNumber(java.lang.String licenseNumber)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByLicenseNumber(licenseNumber);
    }

    public static int countByIssuingDateLicense(
        java.util.Date issuingDateLicense)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByIssuingDateLicense(issuingDateLicense);
    }

    public static int countByReceiveLicenseDate(
        java.util.Date receiveLicenseDate)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByReceiveLicenseDate(receiveLicenseDate);
    }

    public static int countByDocumentNumber(java.lang.String documentNumber)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByDocumentNumber(documentNumber);
    }

    public static int countByBillNumber(java.lang.String billNumber)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByBillNumber(billNumber);
    }

    public static int countByNumberMoney(long numberMoney)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByNumberMoney(numberMoney);
    }

    public static int countByNote(java.lang.String note)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByNote(note);
    }

    public static int countByConclude(java.lang.String conclude)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByConclude(conclude);
    }

    public static int countByFileReturningInfoIdFileId(
        java.lang.String fileId, long fileReturningInfoId)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .countByFileReturningInfoIdFileId(fileId, fileReturningInfoId);
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

    public static PmlFileReturningInfoPersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(PmlFileReturningInfoPersistence persistence) {
        _persistence = persistence;
    }
}
