package com.sgs.portlet.document.receipt.service;


/**
 * <a href="PmlEdmDocumentReceiptExtendLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.sgs.portlet.document.receipt.service.impl.PmlEdmDocumentReceiptExtendLocalServiceImpl</code>.
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
 * @see com.sgs.portlet.document.receipt.service.PmlEdmDocumentReceiptExtendLocalServiceUtil
 *
 */
public interface PmlEdmDocumentReceiptExtendLocalService {
    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptExtend addPmlEdmDocumentReceiptExtend(
        com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptExtend pmlEdmDocumentReceiptExtend)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptExtend createPmlEdmDocumentReceiptExtend(
        long documentReceiptExtendId);

    public void deletePmlEdmDocumentReceiptExtend(long documentReceiptExtendId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deletePmlEdmDocumentReceiptExtend(
        com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptExtend pmlEdmDocumentReceiptExtend)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptExtend getPmlEdmDocumentReceiptExtend(
        long documentReceiptExtendId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptExtend> getPmlEdmDocumentReceiptExtends(
        int start, int end) throws com.liferay.portal.SystemException;

    public int getPmlEdmDocumentReceiptExtendsCount()
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptExtend updatePmlEdmDocumentReceiptExtend(
        com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptExtend pmlEdmDocumentReceiptExtend)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptExtend addDocumentReceiptExtend(
        long documentReceiptId, long documentReceiptLogId,
        java.util.Date startProcessDate, int numDayProcessBef,
        java.util.Date limitDateBef, java.lang.String extendReason,
        int numDayProcessAft, java.util.Date limitDateAft,
        boolean leanOnLimitDate, long extendUserId,
        java.lang.String extendDepartmentId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;
}
