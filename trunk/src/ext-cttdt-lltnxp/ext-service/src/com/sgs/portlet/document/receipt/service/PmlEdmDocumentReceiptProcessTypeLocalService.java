package com.sgs.portlet.document.receipt.service;


/**
 * <a href="PmlEdmDocumentReceiptProcessTypeLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.sgs.portlet.document.receipt.service.impl.PmlEdmDocumentReceiptProcessTypeLocalServiceImpl</code>.
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
 * @see com.sgs.portlet.document.receipt.service.PmlEdmDocumentReceiptProcessTypeLocalServiceUtil
 *
 */
public interface PmlEdmDocumentReceiptProcessTypeLocalService {
    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptProcessType addPmlEdmDocumentReceiptProcessType(
        com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptProcessType pmlEdmDocumentReceiptProcessType)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptProcessType createPmlEdmDocumentReceiptProcessType(
        long docReceiptProcessTypeId);

    public void deletePmlEdmDocumentReceiptProcessType(
        long docReceiptProcessTypeId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deletePmlEdmDocumentReceiptProcessType(
        com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptProcessType pmlEdmDocumentReceiptProcessType)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptProcessType getPmlEdmDocumentReceiptProcessType(
        long docReceiptProcessTypeId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptProcessType> getPmlEdmDocumentReceiptProcessTypes(
        int start, int end) throws com.liferay.portal.SystemException;

    public int getPmlEdmDocumentReceiptProcessTypesCount()
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptProcessType updatePmlEdmDocumentReceiptProcessType(
        com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptProcessType pmlEdmDocumentReceiptProcessType)
        throws com.liferay.portal.SystemException;
}
