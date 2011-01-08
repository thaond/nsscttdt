package com.sgs.portlet.document.service;


/**
 * <a href="PmlDocumentReceiptWFLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.sgs.portlet.document.service.impl.PmlDocumentReceiptWFLocalServiceImpl</code>.
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
 * @see com.sgs.portlet.document.service.PmlDocumentReceiptWFLocalServiceUtil
 *
 */
public interface PmlDocumentReceiptWFLocalService {
    public com.sgs.portlet.document.model.PmlDocumentReceiptWF addPmlDocumentReceiptWF(
        com.sgs.portlet.document.model.PmlDocumentReceiptWF pmlDocumentReceiptWF)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlDocumentReceiptWF createPmlDocumentReceiptWF(
        long processId);

    public void deletePmlDocumentReceiptWF(long processId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deletePmlDocumentReceiptWF(
        com.sgs.portlet.document.model.PmlDocumentReceiptWF pmlDocumentReceiptWF)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlDocumentReceiptWF getPmlDocumentReceiptWF(
        long processId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptWF> getPmlDocumentReceiptWFs(
        int start, int end) throws com.liferay.portal.SystemException;

    public int getPmlDocumentReceiptWFsCount()
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlDocumentReceiptWF updatePmlDocumentReceiptWF(
        com.sgs.portlet.document.model.PmlDocumentReceiptWF pmlDocumentReceiptWF)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlDocumentReceiptWF getPmlDocumentReceiptWFByDocumentReceiptID(
        long documentReceiptId);

    public int deletePmlDocumentReceiptWFByRecId(long documentReceiptId);
}
