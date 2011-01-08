package com.sgs.portlet.document.send.service;


/**
 * <a href="PmlEdmWriteDocumentSendLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.sgs.portlet.document.send.service.PmlEdmWriteDocumentSendLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.send.service.PmlEdmWriteDocumentSendLocalService
 *
 */
public class PmlEdmWriteDocumentSendLocalServiceUtil {
    private static PmlEdmWriteDocumentSendLocalService _service;

    public static com.sgs.portlet.document.send.model.PmlEdmWriteDocumentSend addPmlEdmWriteDocumentSend(
        com.sgs.portlet.document.send.model.PmlEdmWriteDocumentSend pmlEdmWriteDocumentSend)
        throws com.liferay.portal.SystemException {
        return getService().addPmlEdmWriteDocumentSend(pmlEdmWriteDocumentSend);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmWriteDocumentSend createPmlEdmWriteDocumentSend(
        com.sgs.portlet.document.send.service.persistence.PmlEdmWriteDocumentSendPK pmlEdmWriteDocumentSendPK) {
        return getService()
                   .createPmlEdmWriteDocumentSend(pmlEdmWriteDocumentSendPK);
    }

    public static void deletePmlEdmWriteDocumentSend(
        com.sgs.portlet.document.send.service.persistence.PmlEdmWriteDocumentSendPK pmlEdmWriteDocumentSendPK)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deletePmlEdmWriteDocumentSend(pmlEdmWriteDocumentSendPK);
    }

    public static void deletePmlEdmWriteDocumentSend(
        com.sgs.portlet.document.send.model.PmlEdmWriteDocumentSend pmlEdmWriteDocumentSend)
        throws com.liferay.portal.SystemException {
        getService().deletePmlEdmWriteDocumentSend(pmlEdmWriteDocumentSend);
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

    public static com.sgs.portlet.document.send.model.PmlEdmWriteDocumentSend getPmlEdmWriteDocumentSend(
        com.sgs.portlet.document.send.service.persistence.PmlEdmWriteDocumentSendPK pmlEdmWriteDocumentSendPK)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getPmlEdmWriteDocumentSend(pmlEdmWriteDocumentSendPK);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmWriteDocumentSend> getPmlEdmWriteDocumentSends(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getPmlEdmWriteDocumentSends(start, end);
    }

    public static int getPmlEdmWriteDocumentSendsCount()
        throws com.liferay.portal.SystemException {
        return getService().getPmlEdmWriteDocumentSendsCount();
    }

    public static com.sgs.portlet.document.send.model.PmlEdmWriteDocumentSend updatePmlEdmWriteDocumentSend(
        com.sgs.portlet.document.send.model.PmlEdmWriteDocumentSend pmlEdmWriteDocumentSend)
        throws com.liferay.portal.SystemException {
        return getService()
                   .updatePmlEdmWriteDocumentSend(pmlEdmWriteDocumentSend);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend getBookDocumentSendByDocumentSend(
        long documentSendId) {
        return getService().getBookDocumentSendByDocumentSend(documentSendId);
    }

    public static int deletePmlEdmWriteDocumentSendBySendId(long documentSendId) {
        return getService().deletePmlEdmWriteDocumentSendBySendId(documentSendId);
    }

    public static PmlEdmWriteDocumentSendLocalService getService() {
        if (_service == null) {
            throw new RuntimeException(
                "PmlEdmWriteDocumentSendLocalService is not set");
        }

        return _service;
    }

    public void setService(PmlEdmWriteDocumentSendLocalService service) {
        _service = service;
    }
}
