package com.sgs.portlet.document.receipt.service;


/**
 * <a href="PmlEdmProcessDocumentReceiptDetailLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.sgs.portlet.document.receipt.service.PmlEdmProcessDocumentReceiptDetailLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.receipt.service.PmlEdmProcessDocumentReceiptDetailLocalService
 *
 */
public class PmlEdmProcessDocumentReceiptDetailLocalServiceUtil {
    private static PmlEdmProcessDocumentReceiptDetailLocalService _service;

    public static com.sgs.portlet.document.receipt.model.PmlEdmProcessDocumentReceiptDetail addPmlEdmProcessDocumentReceiptDetail(
        com.sgs.portlet.document.receipt.model.PmlEdmProcessDocumentReceiptDetail pmlEdmProcessDocumentReceiptDetail)
        throws com.liferay.portal.SystemException {
        return getService()
                   .addPmlEdmProcessDocumentReceiptDetail(pmlEdmProcessDocumentReceiptDetail);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmProcessDocumentReceiptDetail createPmlEdmProcessDocumentReceiptDetail(
        long id) {
        return getService().createPmlEdmProcessDocumentReceiptDetail(id);
    }

    public static void deletePmlEdmProcessDocumentReceiptDetail(long id)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deletePmlEdmProcessDocumentReceiptDetail(id);
    }

    public static void deletePmlEdmProcessDocumentReceiptDetail(
        com.sgs.portlet.document.receipt.model.PmlEdmProcessDocumentReceiptDetail pmlEdmProcessDocumentReceiptDetail)
        throws com.liferay.portal.SystemException {
        getService()
            .deletePmlEdmProcessDocumentReceiptDetail(pmlEdmProcessDocumentReceiptDetail);
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

    public static com.sgs.portlet.document.receipt.model.PmlEdmProcessDocumentReceiptDetail getPmlEdmProcessDocumentReceiptDetail(
        long id)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getPmlEdmProcessDocumentReceiptDetail(id);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmProcessDocumentReceiptDetail> getPmlEdmProcessDocumentReceiptDetails(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getPmlEdmProcessDocumentReceiptDetails(start, end);
    }

    public static int getPmlEdmProcessDocumentReceiptDetailsCount()
        throws com.liferay.portal.SystemException {
        return getService().getPmlEdmProcessDocumentReceiptDetailsCount();
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmProcessDocumentReceiptDetail updatePmlEdmProcessDocumentReceiptDetail(
        com.sgs.portlet.document.receipt.model.PmlEdmProcessDocumentReceiptDetail pmlEdmProcessDocumentReceiptDetail)
        throws com.liferay.portal.SystemException {
        return getService()
                   .updatePmlEdmProcessDocumentReceiptDetail(pmlEdmProcessDocumentReceiptDetail);
    }

    public static PmlEdmProcessDocumentReceiptDetailLocalService getService() {
        if (_service == null) {
            throw new RuntimeException(
                "PmlEdmProcessDocumentReceiptDetailLocalService is not set");
        }

        return _service;
    }

    public void setService(
        PmlEdmProcessDocumentReceiptDetailLocalService service) {
        _service = service;
    }
}
