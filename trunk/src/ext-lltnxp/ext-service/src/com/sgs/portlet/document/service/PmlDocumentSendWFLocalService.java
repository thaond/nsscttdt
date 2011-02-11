package com.sgs.portlet.document.service;


/**
 * <a href="PmlDocumentSendWFLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.sgs.portlet.document.service.impl.PmlDocumentSendWFLocalServiceImpl</code>.
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
 * @see com.sgs.portlet.document.service.PmlDocumentSendWFLocalServiceUtil
 *
 */
public interface PmlDocumentSendWFLocalService {
    public com.sgs.portlet.document.model.PmlDocumentSendWF addPmlDocumentSendWF(
        com.sgs.portlet.document.model.PmlDocumentSendWF pmlDocumentSendWF)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlDocumentSendWF createPmlDocumentSendWF(
        long documentSendId);

    public void deletePmlDocumentSendWF(long documentSendId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deletePmlDocumentSendWF(
        com.sgs.portlet.document.model.PmlDocumentSendWF pmlDocumentSendWF)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlDocumentSendWF getPmlDocumentSendWF(
        long documentSendId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentSendWF> getPmlDocumentSendWFs(
        int start, int end) throws com.liferay.portal.SystemException;

    public int getPmlDocumentSendWFsCount()
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlDocumentSendWF updatePmlDocumentSendWF(
        com.sgs.portlet.document.model.PmlDocumentSendWF pmlDocumentSendWF)
        throws com.liferay.portal.SystemException;
}
