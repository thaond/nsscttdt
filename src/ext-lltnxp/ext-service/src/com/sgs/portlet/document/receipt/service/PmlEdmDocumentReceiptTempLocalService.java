package com.sgs.portlet.document.receipt.service;


/**
 * <a href="PmlEdmDocumentReceiptTempLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.sgs.portlet.document.receipt.service.impl.PmlEdmDocumentReceiptTempLocalServiceImpl</code>.
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
 * @see com.sgs.portlet.document.receipt.service.PmlEdmDocumentReceiptTempLocalServiceUtil
 *
 */
public interface PmlEdmDocumentReceiptTempLocalService {
    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp addPmlEdmDocumentReceiptTemp(
        com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp pmlEdmDocumentReceiptTemp)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp createPmlEdmDocumentReceiptTemp(
        long documentReceiptId);

    public void deletePmlEdmDocumentReceiptTemp(long documentReceiptId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deletePmlEdmDocumentReceiptTemp(
        com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp pmlEdmDocumentReceiptTemp)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp getPmlEdmDocumentReceiptTemp(
        long documentReceiptId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp> getPmlEdmDocumentReceiptTemps(
        int start, int end) throws com.liferay.portal.SystemException;

    public int getPmlEdmDocumentReceiptTempsCount()
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp updatePmlEdmDocumentReceiptTemp(
        com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp pmlEdmDocumentReceiptTemp)
        throws com.liferay.portal.SystemException;

    public int countPmlEdmDocumentReceiptTemp(java.lang.String soVBDen,
        java.lang.String soHieuGoc, int loaiSoVanBan,
        java.lang.String issuingplaceId, java.lang.String noiBanHanh,
        java.lang.String trichYeu, java.lang.String tuNgay,
        java.lang.String denNgay) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp> listPmlEdmDocumentReceiptTemp(
        java.lang.String soVBDen, java.lang.String soHieuGoc, int loaiSoVanBan,
        java.lang.String issuingplaceId, java.lang.String noiBanHanh,
        java.lang.String trichYeu, java.lang.String tuNgay,
        java.lang.String denNgay, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp> getAllList(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public int countAllList() throws com.liferay.portal.SystemException;
}
