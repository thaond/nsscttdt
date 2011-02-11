package com.sgs.portlet.document.service;


/**
 * <a href="PmlDocumentReceiptWFLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.sgs.portlet.document.service.PmlDocumentReceiptWFLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.service.PmlDocumentReceiptWFLocalService
 *
 */
public class PmlDocumentReceiptWFLocalServiceUtil {
    private static PmlDocumentReceiptWFLocalService _service;

    public static com.sgs.portlet.document.model.PmlDocumentReceiptWF addPmlDocumentReceiptWF(
        com.sgs.portlet.document.model.PmlDocumentReceiptWF pmlDocumentReceiptWF)
        throws com.liferay.portal.SystemException {
        return getService().addPmlDocumentReceiptWF(pmlDocumentReceiptWF);
    }

    public static com.sgs.portlet.document.model.PmlDocumentReceiptWF createPmlDocumentReceiptWF(
        long processId) {
        return getService().createPmlDocumentReceiptWF(processId);
    }

    public static void deletePmlDocumentReceiptWF(long processId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deletePmlDocumentReceiptWF(processId);
    }

    public static void deletePmlDocumentReceiptWF(
        com.sgs.portlet.document.model.PmlDocumentReceiptWF pmlDocumentReceiptWF)
        throws com.liferay.portal.SystemException {
        getService().deletePmlDocumentReceiptWF(pmlDocumentReceiptWF);
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

    public static com.sgs.portlet.document.model.PmlDocumentReceiptWF getPmlDocumentReceiptWF(
        long processId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getPmlDocumentReceiptWF(processId);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptWF> getPmlDocumentReceiptWFs(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getPmlDocumentReceiptWFs(start, end);
    }

    public static int getPmlDocumentReceiptWFsCount()
        throws com.liferay.portal.SystemException {
        return getService().getPmlDocumentReceiptWFsCount();
    }

    public static com.sgs.portlet.document.model.PmlDocumentReceiptWF updatePmlDocumentReceiptWF(
        com.sgs.portlet.document.model.PmlDocumentReceiptWF pmlDocumentReceiptWF)
        throws com.liferay.portal.SystemException {
        return getService().updatePmlDocumentReceiptWF(pmlDocumentReceiptWF);
    }

    public static com.sgs.portlet.document.model.PmlDocumentReceiptWF getPmlDocumentReceiptWFByDocumentReceiptID(
        long documentReceiptId) {
        return getService()
                   .getPmlDocumentReceiptWFByDocumentReceiptID(documentReceiptId);
    }

    public static int deletePmlDocumentReceiptWFByRecId(long documentReceiptId) {
        return getService().deletePmlDocumentReceiptWFByRecId(documentReceiptId);
    }

    public static PmlDocumentReceiptWFLocalService getService() {
        if (_service == null) {
            throw new RuntimeException(
                "PmlDocumentReceiptWFLocalService is not set");
        }

        return _service;
    }

    public void setService(PmlDocumentReceiptWFLocalService service) {
        _service = service;
    }
}
