package com.sgs.portlet.document_manager.service;


/**
 * <a href="AttactFileDocumentLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.sgs.portlet.document_manager.service.AttactFileDocumentLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document_manager.service.AttactFileDocumentLocalService
 *
 */
public class AttactFileDocumentLocalServiceUtil {
    private static AttactFileDocumentLocalService _service;

    public static com.sgs.portlet.document_manager.model.AttactFileDocument addAttactFileDocument(
        com.sgs.portlet.document_manager.model.AttactFileDocument attactFileDocument)
        throws com.liferay.portal.SystemException {
        return getService().addAttactFileDocument(attactFileDocument);
    }

    public static com.sgs.portlet.document_manager.model.AttactFileDocument createAttactFileDocument(
        long attactFileDocumentId) {
        return getService().createAttactFileDocument(attactFileDocumentId);
    }

    public static void deleteAttactFileDocument(long attactFileDocumentId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deleteAttactFileDocument(attactFileDocumentId);
    }

    public static void deleteAttactFileDocument(
        com.sgs.portlet.document_manager.model.AttactFileDocument attactFileDocument)
        throws com.liferay.portal.SystemException {
        getService().deleteAttactFileDocument(attactFileDocument);
    }

    public static java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException {
        return getService().dynamicQuery(dynamicQuery);
    }

    public static java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException {
        return getService().dynamicQuery(dynamicQuery, start, end);
    }

    public static com.sgs.portlet.document_manager.model.AttactFileDocument getAttactFileDocument(
        long attactFileDocumentId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getAttactFileDocument(attactFileDocumentId);
    }

    public static java.util.List<com.sgs.portlet.document_manager.model.AttactFileDocument> getAttactFileDocuments(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getAttactFileDocuments(start, end);
    }

    public static int getAttactFileDocumentsCount()
        throws com.liferay.portal.SystemException {
        return getService().getAttactFileDocumentsCount();
    }

    public static com.sgs.portlet.document_manager.model.AttactFileDocument updateAttactFileDocument(
        com.sgs.portlet.document_manager.model.AttactFileDocument attactFileDocument)
        throws com.liferay.portal.SystemException {
        return getService().updateAttactFileDocument(attactFileDocument);
    }

    public static AttactFileDocumentLocalService getService() {
        if (_service == null) {
            throw new RuntimeException(
                "AttactFileDocumentLocalService is not set");
        }

        return _service;
    }

    public void setService(AttactFileDocumentLocalService service) {
        _service = service;
    }
}
