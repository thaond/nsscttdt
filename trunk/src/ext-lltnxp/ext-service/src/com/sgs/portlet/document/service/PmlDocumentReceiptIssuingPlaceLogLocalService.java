package com.sgs.portlet.document.service;


/**
 * <a href="PmlDocumentReceiptIssuingPlaceLogLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.sgs.portlet.document.service.impl.PmlDocumentReceiptIssuingPlaceLogLocalServiceImpl</code>.
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
 * @see com.sgs.portlet.document.service.PmlDocumentReceiptIssuingPlaceLogLocalServiceUtil
 *
 */
public interface PmlDocumentReceiptIssuingPlaceLogLocalService {
    public com.sgs.portlet.document.model.PmlDocumentReceiptIssuingPlaceLog addPmlDocumentReceiptIssuingPlaceLog(
        com.sgs.portlet.document.model.PmlDocumentReceiptIssuingPlaceLog pmlDocumentReceiptIssuingPlaceLog)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlDocumentReceiptIssuingPlaceLog createPmlDocumentReceiptIssuingPlaceLog(
        long documentReceiptIssuingPlaceLogId);

    public void deletePmlDocumentReceiptIssuingPlaceLog(
        long documentReceiptIssuingPlaceLogId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deletePmlDocumentReceiptIssuingPlaceLog(
        com.sgs.portlet.document.model.PmlDocumentReceiptIssuingPlaceLog pmlDocumentReceiptIssuingPlaceLog)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlDocumentReceiptIssuingPlaceLog getPmlDocumentReceiptIssuingPlaceLog(
        long documentReceiptIssuingPlaceLogId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptIssuingPlaceLog> getPmlDocumentReceiptIssuingPlaceLogs(
        int start, int end) throws com.liferay.portal.SystemException;

    public int getPmlDocumentReceiptIssuingPlaceLogsCount()
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlDocumentReceiptIssuingPlaceLog updatePmlDocumentReceiptIssuingPlaceLog(
        com.sgs.portlet.document.model.PmlDocumentReceiptIssuingPlaceLog pmlDocumentReceiptIssuingPlaceLog)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlDocumentReceiptIssuingPlaceLog addPmlDocumentReceiptIssuingPlaceLog(
        long documentReceiptId, java.util.Date dateProcess, long processor,
        long directProcessorId, java.lang.String processInfomation,
        java.lang.String receiver, int step)
        throws com.liferay.portal.SystemException;
}
