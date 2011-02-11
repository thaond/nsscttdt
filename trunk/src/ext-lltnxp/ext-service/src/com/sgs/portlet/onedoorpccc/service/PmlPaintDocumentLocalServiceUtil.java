package com.sgs.portlet.onedoorpccc.service;


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
 * <code>com.sgs.portlet.onedoorpccc.service.PmlPaintDocumentLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.onedoorpccc.service.PmlPaintDocumentLocalService
 *
 */
public class PmlPaintDocumentLocalServiceUtil {
    private static PmlPaintDocumentLocalService _service;

    public static com.sgs.portlet.onedoorpccc.model.PmlPaintDocument addPmlPaintDocument(
        com.sgs.portlet.onedoorpccc.model.PmlPaintDocument pmlPaintDocument)
        throws com.liferay.portal.SystemException {
        return getService().addPmlPaintDocument(pmlPaintDocument);
    }

    public static com.sgs.portlet.onedoorpccc.model.PmlPaintDocument createPmlPaintDocument(
        long paintDocumentId) {
        return getService().createPmlPaintDocument(paintDocumentId);
    }

    public static void deletePmlPaintDocument(long paintDocumentId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deletePmlPaintDocument(paintDocumentId);
    }

    public static void deletePmlPaintDocument(
        com.sgs.portlet.onedoorpccc.model.PmlPaintDocument pmlPaintDocument)
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

    public static com.sgs.portlet.onedoorpccc.model.PmlPaintDocument getPmlPaintDocument(
        long paintDocumentId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getPmlPaintDocument(paintDocumentId);
    }

    public static java.util.List<com.sgs.portlet.onedoorpccc.model.PmlPaintDocument> getPmlPaintDocuments(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getPmlPaintDocuments(start, end);
    }

    public static int getPmlPaintDocumentsCount()
        throws com.liferay.portal.SystemException {
        return getService().getPmlPaintDocumentsCount();
    }

    public static com.sgs.portlet.onedoorpccc.model.PmlPaintDocument updatePmlPaintDocument(
        com.sgs.portlet.onedoorpccc.model.PmlPaintDocument pmlPaintDocument)
        throws com.liferay.portal.SystemException {
        return getService().updatePmlPaintDocument(pmlPaintDocument);
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
