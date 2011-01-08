package com.sgs.portlet.document.receipt.service;


/**
 * <a href="PmlEdmDocumentReceiptTempLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.sgs.portlet.document.receipt.service.PmlEdmDocumentReceiptTempLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.receipt.service.PmlEdmDocumentReceiptTempLocalService
 *
 */
public class PmlEdmDocumentReceiptTempLocalServiceUtil {
    private static PmlEdmDocumentReceiptTempLocalService _service;

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp addPmlEdmDocumentReceiptTemp(
        com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp pmlEdmDocumentReceiptTemp)
        throws com.liferay.portal.SystemException {
        return getService()
                   .addPmlEdmDocumentReceiptTemp(pmlEdmDocumentReceiptTemp);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp createPmlEdmDocumentReceiptTemp(
        long documentReceiptId) {
        return getService().createPmlEdmDocumentReceiptTemp(documentReceiptId);
    }

    public static void deletePmlEdmDocumentReceiptTemp(long documentReceiptId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deletePmlEdmDocumentReceiptTemp(documentReceiptId);
    }

    public static void deletePmlEdmDocumentReceiptTemp(
        com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp pmlEdmDocumentReceiptTemp)
        throws com.liferay.portal.SystemException {
        getService().deletePmlEdmDocumentReceiptTemp(pmlEdmDocumentReceiptTemp);
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

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp getPmlEdmDocumentReceiptTemp(
        long documentReceiptId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getPmlEdmDocumentReceiptTemp(documentReceiptId);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp> getPmlEdmDocumentReceiptTemps(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getPmlEdmDocumentReceiptTemps(start, end);
    }

    public static int getPmlEdmDocumentReceiptTempsCount()
        throws com.liferay.portal.SystemException {
        return getService().getPmlEdmDocumentReceiptTempsCount();
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp updatePmlEdmDocumentReceiptTemp(
        com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp pmlEdmDocumentReceiptTemp)
        throws com.liferay.portal.SystemException {
        return getService()
                   .updatePmlEdmDocumentReceiptTemp(pmlEdmDocumentReceiptTemp);
    }

    public static int countPmlEdmDocumentReceiptTemp(java.lang.String soVBDen,
        java.lang.String soHieuGoc, int loaiSoVanBan,
        java.lang.String issuingplaceId, java.lang.String noiBanHanh,
        java.lang.String trichYeu, java.lang.String tuNgay,
        java.lang.String denNgay) throws com.liferay.portal.SystemException {
        return getService()
                   .countPmlEdmDocumentReceiptTemp(soVBDen, soHieuGoc,
            loaiSoVanBan, issuingplaceId, noiBanHanh, trichYeu, tuNgay, denNgay);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp> listPmlEdmDocumentReceiptTemp(
        java.lang.String soVBDen, java.lang.String soHieuGoc, int loaiSoVanBan,
        java.lang.String issuingplaceId, java.lang.String noiBanHanh,
        java.lang.String trichYeu, java.lang.String tuNgay,
        java.lang.String denNgay, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService()
                   .listPmlEdmDocumentReceiptTemp(soVBDen, soHieuGoc,
            loaiSoVanBan, issuingplaceId, noiBanHanh, trichYeu, tuNgay,
            denNgay, start, end, obc);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp> getAllList(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService().getAllList(start, end, obc);
    }

    public static int countAllList() throws com.liferay.portal.SystemException {
        return getService().countAllList();
    }

    public static PmlEdmDocumentReceiptTempLocalService getService() {
        if (_service == null) {
            throw new RuntimeException(
                "PmlEdmDocumentReceiptTempLocalService is not set");
        }

        return _service;
    }

    public void setService(PmlEdmDocumentReceiptTempLocalService service) {
        _service = service;
    }
}
