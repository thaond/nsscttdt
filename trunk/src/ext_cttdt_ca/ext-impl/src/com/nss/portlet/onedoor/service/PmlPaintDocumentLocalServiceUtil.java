package com.nss.portlet.onedoor.service;


/**
 * <a href="PmlPaintDocumentLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.nss.portlet.onedoor.service.PmlPaintDocumentLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.onedoor.service.PmlPaintDocumentLocalService
 *
 */
public class PmlPaintDocumentLocalServiceUtil {
    private static PmlPaintDocumentLocalService _service;

    public static com.nss.portlet.onedoor.model.PmlPaintDocument addPmlPaintDocument(
        com.nss.portlet.onedoor.model.PmlPaintDocument pmlPaintDocument)
        throws com.liferay.portal.SystemException {
        return getService().addPmlPaintDocument(pmlPaintDocument);
    }

    public static com.nss.portlet.onedoor.model.PmlPaintDocument createPmlPaintDocument(
        long paintDocumentId) {
        return getService().createPmlPaintDocument(paintDocumentId);
    }

    public static void deletePmlPaintDocument(long paintDocumentId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deletePmlPaintDocument(paintDocumentId);
    }

    public static void deletePmlPaintDocument(
        com.nss.portlet.onedoor.model.PmlPaintDocument pmlPaintDocument)
        throws com.liferay.portal.SystemException {
        getService().deletePmlPaintDocument(pmlPaintDocument);
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

    public static com.nss.portlet.onedoor.model.PmlPaintDocument getPmlPaintDocument(
        long paintDocumentId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getPmlPaintDocument(paintDocumentId);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlPaintDocument> getPmlPaintDocuments(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getPmlPaintDocuments(start, end);
    }

    public static int getPmlPaintDocumentsCount()
        throws com.liferay.portal.SystemException {
        return getService().getPmlPaintDocumentsCount();
    }

    public static com.nss.portlet.onedoor.model.PmlPaintDocument updatePmlPaintDocument(
        com.nss.portlet.onedoor.model.PmlPaintDocument pmlPaintDocument)
        throws com.liferay.portal.SystemException {
        return getService().updatePmlPaintDocument(pmlPaintDocument);
    }

    public static com.nss.portlet.onedoor.model.PmlPaintDocument updatePmlPaintDocument(
        com.nss.portlet.onedoor.model.PmlPaintDocument pmlPaintDocument,
        boolean merge) throws com.liferay.portal.SystemException {
        return getService().updatePmlPaintDocument(pmlPaintDocument, merge);
    }

    public static void removeByFileId(java.lang.String fileId)
        throws com.liferay.portal.SystemException {
        getService().removeByFileId(fileId);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlPaintDocument> findByFileId(
        java.lang.String fileId) throws com.liferay.portal.SystemException {
        return getService().findByFileId(fileId);
    }

    public static PmlPaintDocumentLocalService getService() {
        if (_service == null) {
            throw new RuntimeException(
                "PmlPaintDocumentLocalService is not set");
        }

        return _service;
    }

    public void setService(PmlPaintDocumentLocalService service) {
        _service = service;
    }
}
