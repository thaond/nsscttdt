package com.sgs.portlet.document_manager.service;


/**
 * <a href="AttactFileDocumentLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.sgs.portlet.document_manager.service.impl.AttactFileDocumentLocalServiceImpl</code>.
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
 * @see com.sgs.portlet.document_manager.service.AttactFileDocumentLocalServiceUtil
 *
 */
public interface AttactFileDocumentLocalService {
    public com.sgs.portlet.document_manager.model.AttactFileDocument addAttactFileDocument(
        com.sgs.portlet.document_manager.model.AttactFileDocument attactFileDocument)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document_manager.model.AttactFileDocument createAttactFileDocument(
        long attactFileDocumentId);

    public void deleteAttactFileDocument(long attactFileDocumentId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deleteAttactFileDocument(
        com.sgs.portlet.document_manager.model.AttactFileDocument attactFileDocument)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document_manager.model.AttactFileDocument getAttactFileDocument(
        long attactFileDocumentId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public java.util.List<com.sgs.portlet.document_manager.model.AttactFileDocument> getAttactFileDocuments(
        int start, int end) throws com.liferay.portal.SystemException;

    public int getAttactFileDocumentsCount()
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document_manager.model.AttactFileDocument updateAttactFileDocument(
        com.sgs.portlet.document_manager.model.AttactFileDocument attactFileDocument)
        throws com.liferay.portal.SystemException;
}
