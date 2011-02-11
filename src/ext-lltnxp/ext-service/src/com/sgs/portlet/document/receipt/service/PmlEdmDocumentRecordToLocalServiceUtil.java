package com.sgs.portlet.document.receipt.service;


/**
 * <a href="PmlEdmDocumentRecordToLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.sgs.portlet.document.receipt.service.PmlEdmDocumentRecordToLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.receipt.service.PmlEdmDocumentRecordToLocalService
 *
 */
public class PmlEdmDocumentRecordToLocalServiceUtil {
    private static PmlEdmDocumentRecordToLocalService _service;

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo addPmlEdmDocumentRecordTo(
        com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo pmlEdmDocumentRecordTo)
        throws com.liferay.portal.SystemException {
        return getService().addPmlEdmDocumentRecordTo(pmlEdmDocumentRecordTo);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo createPmlEdmDocumentRecordTo(
        long documentRecordToId) {
        return getService().createPmlEdmDocumentRecordTo(documentRecordToId);
    }

    public static void deletePmlEdmDocumentRecordTo(long documentRecordToId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deletePmlEdmDocumentRecordTo(documentRecordToId);
    }

    public static void deletePmlEdmDocumentRecordTo(
        com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo pmlEdmDocumentRecordTo)
        throws com.liferay.portal.SystemException {
        getService().deletePmlEdmDocumentRecordTo(pmlEdmDocumentRecordTo);
    }

    public static java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException {
        return getService().dynamicQuery(dynamicQuery);
    }

    public static java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException {
        return getService().dynamicQuery(dynamicQuery, start, end);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo getPmlEdmDocumentRecordTo(
        long documentRecordToId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getPmlEdmDocumentRecordTo(documentRecordToId);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo> getPmlEdmDocumentRecordTos(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getPmlEdmDocumentRecordTos(start, end);
    }

    public static int getPmlEdmDocumentRecordTosCount()
        throws com.liferay.portal.SystemException {
        return getService().getPmlEdmDocumentRecordTosCount();
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo updatePmlEdmDocumentRecordTo(
        com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo pmlEdmDocumentRecordTo)
        throws com.liferay.portal.SystemException {
        return getService().updatePmlEdmDocumentRecordTo(pmlEdmDocumentRecordTo);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo getDocumentRecordTo(
        java.lang.String yearInUse, java.lang.String departmentsId,
        int documentRecordTypeId) {
        return getService()
                   .getDocumentRecordTo(yearInUse, departmentsId,
            documentRecordTypeId);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo getDocumentRecordToBy_YearInUse_AgencyId_DocumentRecordTypeId(
        java.lang.String yearInUse, java.lang.String agencyId,
        int documentRecordTypeId) {
        return getService()
                   .getDocumentRecordToBy_YearInUse_AgencyId_DocumentRecordTypeId(yearInUse,
            agencyId, documentRecordTypeId);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo getDocumentRecordTo(
        java.lang.String departmentsId, int documentRecordTypeId,
        java.lang.String agencyId) {
        return getService()
                   .getDocumentRecordTo(departmentsId, documentRecordTypeId,
            agencyId);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo getDocumentRecordToByDocumentReceipt(
        long documentReceiptId) {
        return getService()
                   .getDocumentRecordToByDocumentReceipt(documentReceiptId);
    }

    public static int getDocumentRecordTypeIdByDocumentReceipt(
        long documentReceiptId) {
        return getService()
                   .getDocumentRecordTypeIdByDocumentReceipt(documentReceiptId);
    }

    public static java.lang.String getDepartmentIdByUserId(long userId) {
        return getService().getDepartmentIdByUserId(userId);
    }

    public static boolean addBookDocumentRecordTo(
        com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo bookDocumentRecordTo) {
        return getService().addBookDocumentRecordTo(bookDocumentRecordTo);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo getDocumentRecordToBy_DocumentType_AgencyId(
        long documentTypeId, java.lang.String agencyId) {
        return getService()
                   .getDocumentRecordToBy_DocumentType_AgencyId(documentTypeId,
            agencyId);
    }

    public static java.lang.String getAgencyIdByDepartment(
        com.sgs.portlet.department.model.Department department) {
        return getService().getAgencyIdByDepartment(department);
    }

    public static int searchCountSoCongVanDenSo(java.lang.String keywords)
        throws com.liferay.portal.SystemException {
        return getService().searchCountSoCongVanDenSo(keywords);
    }

    public static int searchCountSoCongVanDenSo(java.lang.String loaiSoCVs,
        java.lang.String so, boolean andOperator)
        throws com.liferay.portal.SystemException {
        return getService().searchCountSoCongVanDenSo(loaiSoCVs, so, andOperator);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo> searchSoCongVanDenSo(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService().searchSoCongVanDenSo(keywords, start, end, obc);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo> searchSoCongVanDenSo(
        java.lang.String loaiSoCVs, java.lang.String so, boolean andOperator,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService()
                   .searchSoCongVanDenSo(loaiSoCVs, so, andOperator, start,
            end, obc);
    }

    public static int searchCountSoCongVanDenPB(java.lang.String keywords)
        throws com.liferay.portal.SystemException {
        return getService().searchCountSoCongVanDenPB(keywords);
    }

    public static int searchCountSoCongVanDenPB(java.lang.String loaiSoCVs,
        java.lang.String phongBan, boolean andOperator)
        throws com.liferay.portal.SystemException {
        return getService()
                   .searchCountSoCongVanDenPB(loaiSoCVs, phongBan, andOperator);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo> searchSoCongVanDenPB(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService().searchSoCongVanDenPB(keywords, start, end, obc);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo> searchSoCongVanDenPB(
        java.lang.String loaiSoCVs, java.lang.String phongBan,
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService()
                   .searchSoCongVanDenPB(loaiSoCVs, phongBan, andOperator,
            start, end, obc);
    }

    public static void removePmlEdmPrivilegeLevel(long documentRecordToId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().removePmlEdmPrivilegeLevel(documentRecordToId);
    }

    public static PmlEdmDocumentRecordToLocalService getService() {
        if (_service == null) {
            throw new RuntimeException(
                "PmlEdmDocumentRecordToLocalService is not set");
        }

        return _service;
    }

    public void setService(PmlEdmDocumentRecordToLocalService service) {
        _service = service;
    }
}
