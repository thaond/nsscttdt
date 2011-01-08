package com.sgs.portlet.document.service;


/**
 * <a href="PmlDocumentSendWFLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.sgs.portlet.document.service.PmlDocumentSendWFLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.service.PmlDocumentSendWFLocalService
 *
 */
public class PmlDocumentSendWFLocalServiceUtil {
    private static PmlDocumentSendWFLocalService _service;

    public static com.sgs.portlet.document.model.PmlDocumentSendWF addPmlDocumentSendWF(
        com.sgs.portlet.document.model.PmlDocumentSendWF pmlDocumentSendWF)
        throws com.liferay.portal.SystemException {
        return getService().addPmlDocumentSendWF(pmlDocumentSendWF);
    }

    public static com.sgs.portlet.document.model.PmlDocumentSendWF createPmlDocumentSendWF(
        long documentSendId) {
        return getService().createPmlDocumentSendWF(documentSendId);
    }

    public static void deletePmlDocumentSendWF(long documentSendId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deletePmlDocumentSendWF(documentSendId);
    }

    public static void deletePmlDocumentSendWF(
        com.sgs.portlet.document.model.PmlDocumentSendWF pmlDocumentSendWF)
        throws com.liferay.portal.SystemException {
        getService().deletePmlDocumentSendWF(pmlDocumentSendWF);
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

    public static com.sgs.portlet.document.model.PmlDocumentSendWF getPmlDocumentSendWF(
        long documentSendId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getPmlDocumentSendWF(documentSendId);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentSendWF> getPmlDocumentSendWFs(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getPmlDocumentSendWFs(start, end);
    }

    public static int getPmlDocumentSendWFsCount()
        throws com.liferay.portal.SystemException {
        return getService().getPmlDocumentSendWFsCount();
    }

    public static com.sgs.portlet.document.model.PmlDocumentSendWF updatePmlDocumentSendWF(
        com.sgs.portlet.document.model.PmlDocumentSendWF pmlDocumentSendWF)
        throws com.liferay.portal.SystemException {
        return getService().updatePmlDocumentSendWF(pmlDocumentSendWF);
    }

    public static PmlDocumentSendWFLocalService getService() {
        if (_service == null) {
            throw new RuntimeException(
                "PmlDocumentSendWFLocalService is not set");
        }

        return _service;
    }

    public void setService(PmlDocumentSendWFLocalService service) {
        _service = service;
    }
}
