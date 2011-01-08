package com.sgs.portlet.pml_ho_so_cong_viec.service;


/**
 * <a href="PmlChiTietHSCVLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.sgs.portlet.pml_ho_so_cong_viec.service.impl.PmlChiTietHSCVLocalServiceImpl</code>.
 * Modify methods in that class and rerun ServiceBuilder to populate this class
 * and all other generated classes.
 * </p>
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.pml_ho_so_cong_viec.service.PmlChiTietHSCVLocalServiceUtil
 *
 */
public interface PmlChiTietHSCVLocalService {
    public com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV addPmlChiTietHSCV(
        com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV pmlChiTietHSCV)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV createPmlChiTietHSCV(
        long idChiTietHSCV);

    public void deletePmlChiTietHSCV(long idChiTietHSCV)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deletePmlChiTietHSCV(
        com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV pmlChiTietHSCV)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV getPmlChiTietHSCV(
        long idChiTietHSCV)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public java.util.List<com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV> getPmlChiTietHSCVs(
        int start, int end) throws com.liferay.portal.SystemException;

    public int getPmlChiTietHSCVsCount()
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV updatePmlChiTietHSCV(
        com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV pmlChiTietHSCV)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV> getByIdHoSoCongViec(
        long idHoSoCongViec) throws com.liferay.portal.SystemException;

    public int countByIdHoSoCongViec(long idHoSoCongViec)
        throws com.liferay.portal.SystemException;

    public int searchChiTietHSCVCVDENCount(long idHoSoCongViec,
        boolean andOperator) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> findChiTietHSCVCVDEN(
        long idHoSoCongViec, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile> findByDocumentReceiptId(
        java.lang.String idDocumentReceipt)
        throws com.liferay.portal.SystemException;

    public void removeChiTietHSCVCVDen(long idHoSoCongViec, long idCongVanDen)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public int searchChiTietHSCVCVDICount(long idHoSoCongViec,
        boolean andOperator) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> findChiTietHSCVCVDI(
        long idHoSoCongViec, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile> findByDocumentReceiptId_Di(
        java.lang.String idDocumentReceipt)
        throws com.liferay.portal.SystemException;

    public void removeChiTietHSCVCVDi(long idHoSoCongViec, long idCongVanDi)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmWriteDocumentSend> findByDateCreateDocumentSend(
        java.lang.String idDocumentSend)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV> findByIdCongVanDen(
        long idCongVanDen, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV> findByIdCongVanDen(
        long idCongVanDen, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV> findByIdCongVanDen(
        long idCongVanDen) throws com.liferay.portal.SystemException;

    public int countByIdCongVanDen(long idCongVanDen, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV> findByIdCongVanDi(
        long idCongVanDi, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV> findByIdCongVanDi(
        long idCongVanDi, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV> findByIdCongVanDi(
        long idCongVanDi) throws com.liferay.portal.SystemException;

    public int countByIdCongVanDi(long idCongVanDi)
        throws com.liferay.portal.SystemException;

    public int deletePmlChiTietHSCVByCVDenId(long docRecId);

    public int deletePmlChiTietHSCVByCVDiId(long docSendId);
}
