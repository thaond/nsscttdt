package com.sgs.portlet.document.send.service;


/**
 * <a href="PmlEdmWriteDocumentSendLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.sgs.portlet.document.send.service.impl.PmlEdmWriteDocumentSendLocalServiceImpl</code>.
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
 * @see com.sgs.portlet.document.send.service.PmlEdmWriteDocumentSendLocalServiceUtil
 *
 */
public interface PmlEdmWriteDocumentSendLocalService {
    public com.sgs.portlet.document.send.model.PmlEdmWriteDocumentSend addPmlEdmWriteDocumentSend(
        com.sgs.portlet.document.send.model.PmlEdmWriteDocumentSend pmlEdmWriteDocumentSend)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.send.model.PmlEdmWriteDocumentSend createPmlEdmWriteDocumentSend(
        com.sgs.portlet.document.send.service.persistence.PmlEdmWriteDocumentSendPK pmlEdmWriteDocumentSendPK);

    public void deletePmlEdmWriteDocumentSend(
        com.sgs.portlet.document.send.service.persistence.PmlEdmWriteDocumentSendPK pmlEdmWriteDocumentSendPK)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deletePmlEdmWriteDocumentSend(
        com.sgs.portlet.document.send.model.PmlEdmWriteDocumentSend pmlEdmWriteDocumentSend)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.send.model.PmlEdmWriteDocumentSend getPmlEdmWriteDocumentSend(
        com.sgs.portlet.document.send.service.persistence.PmlEdmWriteDocumentSendPK pmlEdmWriteDocumentSendPK)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmWriteDocumentSend> getPmlEdmWriteDocumentSends(
        int start, int end) throws com.liferay.portal.SystemException;

    public int getPmlEdmWriteDocumentSendsCount()
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.send.model.PmlEdmWriteDocumentSend updatePmlEdmWriteDocumentSend(
        com.sgs.portlet.document.send.model.PmlEdmWriteDocumentSend pmlEdmWriteDocumentSend)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend getBookDocumentSendByDocumentSend(
        long documentSendId);

    public int deletePmlEdmWriteDocumentSendBySendId(long documentSendId);
}
