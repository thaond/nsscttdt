package com.sgs.portlet.document_manager.service;


/**
 * <a href="DocumentManagerLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.sgs.portlet.document_manager.service.DocumentManagerLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document_manager.service.DocumentManagerLocalService
 *
 */
public class DocumentManagerLocalServiceUtil {
    private static DocumentManagerLocalService _service;

    public static com.sgs.portlet.document_manager.model.DocumentManager addDocumentManager(
        com.sgs.portlet.document_manager.model.DocumentManager documentManager)
        throws com.liferay.portal.SystemException {
        return getService().addDocumentManager(documentManager);
    }

    public static com.sgs.portlet.document_manager.model.DocumentManager createDocumentManager(
        long documentManagerId) {
        return getService().createDocumentManager(documentManagerId);
    }

    public static void deleteDocumentManager(long documentManagerId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deleteDocumentManager(documentManagerId);
    }

    public static void deleteDocumentManager(
        com.sgs.portlet.document_manager.model.DocumentManager documentManager)
        throws com.liferay.portal.SystemException {
        getService().deleteDocumentManager(documentManager);
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

    public static com.sgs.portlet.document_manager.model.DocumentManager getDocumentManager(
        long documentManagerId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getDocumentManager(documentManagerId);
    }

    public static java.util.List<com.sgs.portlet.document_manager.model.DocumentManager> getDocumentManagers(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getDocumentManagers(start, end);
    }

    public static int getDocumentManagersCount()
        throws com.liferay.portal.SystemException {
        return getService().getDocumentManagersCount();
    }

    public static com.sgs.portlet.document_manager.model.DocumentManager updateDocumentManager(
        com.sgs.portlet.document_manager.model.DocumentManager documentManager)
        throws com.liferay.portal.SystemException {
        return getService().updateDocumentManager(documentManager);
    }

    public static java.util.List<com.sgs.portlet.document_manager.model.AttactFileDocument> getAttactFileDocuments(
        long documentManagerId) throws com.liferay.portal.SystemException {
        return getService().getAttactFileDocuments(documentManagerId);
    }

    public static int countDocumentManager(
        java.lang.String documentManagerCodes,
        java.lang.String documentManagerDescriptions,
        java.lang.String documentManagerTitles, boolean andOperator)
        throws com.liferay.portal.SystemException {
        return getService()
                   .countDocumentManager(documentManagerCodes,
            documentManagerDescriptions, documentManagerTitles, andOperator);
    }

    public static java.util.List<com.sgs.portlet.document_manager.model.DocumentManager> findDocumentManager(
        java.lang.String documentManagerCodes,
        java.lang.String documentManagerDescriptions,
        java.lang.String documentManagerTitles, int start, int end,
        boolean andOperator,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService()
                   .findDocumentManager(documentManagerCodes,
            documentManagerDescriptions, documentManagerTitles, start, end,
            andOperator, obc);
    }

    public static DocumentManagerLocalService getService() {
        if (_service == null) {
            throw new RuntimeException("DocumentManagerLocalService is not set");
        }

        return _service;
    }

    public void setService(DocumentManagerLocalService service) {
        _service = service;
    }
}
