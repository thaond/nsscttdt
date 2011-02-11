package com.sgs.portlet.document.receipt.service;


/**
 * <a href="PmlEdmProcessDocumentReceiptDetailLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.sgs.portlet.document.receipt.service.impl.PmlEdmProcessDocumentReceiptDetailLocalServiceImpl</code>.
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
 * @see com.sgs.portlet.document.receipt.service.PmlEdmProcessDocumentReceiptDetailLocalServiceUtil
 *
 */
public interface PmlEdmProcessDocumentReceiptDetailLocalService {
    public com.sgs.portlet.document.receipt.model.PmlEdmProcessDocumentReceiptDetail addPmlEdmProcessDocumentReceiptDetail(
        com.sgs.portlet.document.receipt.model.PmlEdmProcessDocumentReceiptDetail pmlEdmProcessDocumentReceiptDetail)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.receipt.model.PmlEdmProcessDocumentReceiptDetail createPmlEdmProcessDocumentReceiptDetail(
        long id);

    public void deletePmlEdmProcessDocumentReceiptDetail(long id)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deletePmlEdmProcessDocumentReceiptDetail(
        com.sgs.portlet.document.receipt.model.PmlEdmProcessDocumentReceiptDetail pmlEdmProcessDocumentReceiptDetail)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.receipt.model.PmlEdmProcessDocumentReceiptDetail getPmlEdmProcessDocumentReceiptDetail(
        long id)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmProcessDocumentReceiptDetail> getPmlEdmProcessDocumentReceiptDetails(
        int start, int end) throws com.liferay.portal.SystemException;

    public int getPmlEdmProcessDocumentReceiptDetailsCount()
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.receipt.model.PmlEdmProcessDocumentReceiptDetail updatePmlEdmProcessDocumentReceiptDetail(
        com.sgs.portlet.document.receipt.model.PmlEdmProcessDocumentReceiptDetail pmlEdmProcessDocumentReceiptDetail)
        throws com.liferay.portal.SystemException;
}
