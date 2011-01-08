package com.sgs.portlet.document.receipt.service;


/**
 * <a href="PmlEdmBookDocumentRecordToLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.sgs.portlet.document.receipt.service.impl.PmlEdmBookDocumentRecordToLocalServiceImpl</code>.
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
 * @see com.sgs.portlet.document.receipt.service.PmlEdmBookDocumentRecordToLocalServiceUtil
 *
 */
public interface PmlEdmBookDocumentRecordToLocalService {
    public com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo addPmlEdmBookDocumentRecordTo(
        com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo pmlEdmBookDocumentRecordTo)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo createPmlEdmBookDocumentRecordTo(
        com.sgs.portlet.document.receipt.service.persistence.PmlEdmBookDocumentRecordToPK pmlEdmBookDocumentRecordToPK);

    public void deletePmlEdmBookDocumentRecordTo(
        com.sgs.portlet.document.receipt.service.persistence.PmlEdmBookDocumentRecordToPK pmlEdmBookDocumentRecordToPK)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deletePmlEdmBookDocumentRecordTo(
        com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo pmlEdmBookDocumentRecordTo)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo getPmlEdmBookDocumentRecordTo(
        com.sgs.portlet.document.receipt.service.persistence.PmlEdmBookDocumentRecordToPK pmlEdmBookDocumentRecordToPK)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo> getPmlEdmBookDocumentRecordTos(
        int start, int end) throws com.liferay.portal.SystemException;

    public int getPmlEdmBookDocumentRecordTosCount()
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo updatePmlEdmBookDocumentRecordTo(
        com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo pmlEdmBookDocumentRecordTo)
        throws com.liferay.portal.SystemException;

    public int deletePmdEdmBookDocumentRecordToByRecId(long documentReceiptId);
}
