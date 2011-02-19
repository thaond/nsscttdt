package com.sgs.portlet.pml_ho_so_cong_viec.service;


/**
 * <a href="PmlChiTietHSCVLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.sgs.portlet.pml_ho_so_cong_viec.service.PmlChiTietHSCVLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.pml_ho_so_cong_viec.service.PmlChiTietHSCVLocalService
 *
 */
public class PmlChiTietHSCVLocalServiceUtil {
    private static PmlChiTietHSCVLocalService _service;

    public static com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV addPmlChiTietHSCV(
        com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV pmlChiTietHSCV)
        throws com.liferay.portal.SystemException {
        return getService().addPmlChiTietHSCV(pmlChiTietHSCV);
    }

    public static com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV createPmlChiTietHSCV(
        long idChiTietHSCV) {
        return getService().createPmlChiTietHSCV(idChiTietHSCV);
    }

    public static void deletePmlChiTietHSCV(long idChiTietHSCV)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deletePmlChiTietHSCV(idChiTietHSCV);
    }

    public static void deletePmlChiTietHSCV(
        com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV pmlChiTietHSCV)
        throws com.liferay.portal.SystemException {
        getService().deletePmlChiTietHSCV(pmlChiTietHSCV);
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

    public static com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV getPmlChiTietHSCV(
        long idChiTietHSCV)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getPmlChiTietHSCV(idChiTietHSCV);
    }

    public static java.util.List<com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV> getPmlChiTietHSCVs(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getPmlChiTietHSCVs(start, end);
    }

    public static int getPmlChiTietHSCVsCount()
        throws com.liferay.portal.SystemException {
        return getService().getPmlChiTietHSCVsCount();
    }

    public static com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV updatePmlChiTietHSCV(
        com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV pmlChiTietHSCV)
        throws com.liferay.portal.SystemException {
        return getService().updatePmlChiTietHSCV(pmlChiTietHSCV);
    }

    public static java.util.List<com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV> getByIdHoSoCongViec(
        long idHoSoCongViec) throws com.liferay.portal.SystemException {
        return getService().getByIdHoSoCongViec(idHoSoCongViec);
    }

    public static int countByIdHoSoCongViec(long idHoSoCongViec)
        throws com.liferay.portal.SystemException {
        return getService().countByIdHoSoCongViec(idHoSoCongViec);
    }

    public static int searchChiTietHSCVCVDENCount(long idHoSoCongViec,
        boolean andOperator) throws com.liferay.portal.SystemException {
        return getService()
                   .searchChiTietHSCVCVDENCount(idHoSoCongViec, andOperator);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> findChiTietHSCVCVDEN(
        long idHoSoCongViec, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService().findChiTietHSCVCVDEN(idHoSoCongViec, start, end, obc);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile> findByDocumentReceiptId(
        java.lang.String idDocumentReceipt)
        throws com.liferay.portal.SystemException {
        return getService().findByDocumentReceiptId(idDocumentReceipt);
    }

    public static void removeChiTietHSCVCVDen(long idHoSoCongViec,
        long idCongVanDen)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().removeChiTietHSCVCVDen(idHoSoCongViec, idCongVanDen);
    }

    public static int searchChiTietHSCVCVDICount(long idHoSoCongViec,
        boolean andOperator) throws com.liferay.portal.SystemException {
        return getService()
                   .searchChiTietHSCVCVDICount(idHoSoCongViec, andOperator);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> findChiTietHSCVCVDI(
        long idHoSoCongViec, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService().findChiTietHSCVCVDI(idHoSoCongViec, start, end, obc);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile> findByDocumentReceiptId_Di(
        java.lang.String idDocumentReceipt)
        throws com.liferay.portal.SystemException {
        return getService().findByDocumentReceiptId_Di(idDocumentReceipt);
    }

    public static void removeChiTietHSCVCVDi(long idHoSoCongViec,
        long idCongVanDi)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().removeChiTietHSCVCVDi(idHoSoCongViec, idCongVanDi);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmWriteDocumentSend> findByDateCreateDocumentSend(
        java.lang.String idDocumentSend)
        throws com.liferay.portal.SystemException {
        return getService().findByDateCreateDocumentSend(idDocumentSend);
    }

    public static java.util.List<com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV> findByIdCongVanDen(
        long idCongVanDen, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService().findByIdCongVanDen(idCongVanDen, start, end, obc);
    }

    public static java.util.List<com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV> findByIdCongVanDen(
        long idCongVanDen, int start, int end)
        throws com.liferay.portal.SystemException {
        return getService().findByIdCongVanDen(idCongVanDen, start, end);
    }

    public static java.util.List<com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV> findByIdCongVanDen(
        long idCongVanDen) throws com.liferay.portal.SystemException {
        return getService().findByIdCongVanDen(idCongVanDen);
    }

    public static int countByIdCongVanDen(long idCongVanDen, int start,
        int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService().countByIdCongVanDen(idCongVanDen, start, end, obc);
    }

    public static java.util.List<com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV> findByIdCongVanDi(
        long idCongVanDi, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService().findByIdCongVanDi(idCongVanDi, start, end, obc);
    }

    public static java.util.List<com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV> findByIdCongVanDi(
        long idCongVanDi, int start, int end)
        throws com.liferay.portal.SystemException {
        return getService().findByIdCongVanDi(idCongVanDi, start, end);
    }

    public static java.util.List<com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV> findByIdCongVanDi(
        long idCongVanDi) throws com.liferay.portal.SystemException {
        return getService().findByIdCongVanDi(idCongVanDi);
    }

    public static int countByIdCongVanDi(long idCongVanDi)
        throws com.liferay.portal.SystemException {
        return getService().countByIdCongVanDi(idCongVanDi);
    }

    public static int deletePmlChiTietHSCVByCVDenId(long docRecId) {
        return getService().deletePmlChiTietHSCVByCVDenId(docRecId);
    }

    public static int deletePmlChiTietHSCVByCVDiId(long docSendId) {
        return getService().deletePmlChiTietHSCVByCVDiId(docSendId);
    }

    public static com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV findBy_IdHSCV_CVDen(
        long hoSoCongViecId, long documentReceiptId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pml_ho_so_cong_viec.NoSuchPmlChiTietHSCVException {
        return getService()
                   .findBy_IdHSCV_CVDen(hoSoCongViecId, documentReceiptId);
    }

    public static com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV findBy_IdHSCV_CVDi(
        long hoSoCongViecId, long documentSendId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pml_ho_so_cong_viec.NoSuchPmlChiTietHSCVException {
        return getService().findBy_IdHSCV_CVDi(hoSoCongViecId, documentSendId);
    }

    public static PmlChiTietHSCVLocalService getService() {
        if (_service == null) {
            throw new RuntimeException("PmlChiTietHSCVLocalService is not set");
        }

        return _service;
    }

    public void setService(PmlChiTietHSCVLocalService service) {
        _service = service;
    }
}
