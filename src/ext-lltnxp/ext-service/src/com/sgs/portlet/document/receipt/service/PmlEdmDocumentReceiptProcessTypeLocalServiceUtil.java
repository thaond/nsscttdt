package com.sgs.portlet.document.receipt.service;


/**
 * <a href="PmlEdmDocumentReceiptProcessTypeLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.sgs.portlet.document.receipt.service.PmlEdmDocumentReceiptProcessTypeLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.receipt.service.PmlEdmDocumentReceiptProcessTypeLocalService
 *
 */
public class PmlEdmDocumentReceiptProcessTypeLocalServiceUtil {
    private static PmlEdmDocumentReceiptProcessTypeLocalService _service;

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptProcessType addPmlEdmDocumentReceiptProcessType(
        com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptProcessType pmlEdmDocumentReceiptProcessType)
        throws com.liferay.portal.SystemException {
        return getService()
                   .addPmlEdmDocumentReceiptProcessType(pmlEdmDocumentReceiptProcessType);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptProcessType createPmlEdmDocumentReceiptProcessType(
        long docReceiptProcessTypeId) {
        return getService()
                   .createPmlEdmDocumentReceiptProcessType(docReceiptProcessTypeId);
    }

    public static void deletePmlEdmDocumentReceiptProcessType(
        long docReceiptProcessTypeId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService()
            .deletePmlEdmDocumentReceiptProcessType(docReceiptProcessTypeId);
    }

    public static void deletePmlEdmDocumentReceiptProcessType(
        com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptProcessType pmlEdmDocumentReceiptProcessType)
        throws com.liferay.portal.SystemException {
        getService()
            .deletePmlEdmDocumentReceiptProcessType(pmlEdmDocumentReceiptProcessType);
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

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptProcessType getPmlEdmDocumentReceiptProcessType(
        long docReceiptProcessTypeId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService()
                   .getPmlEdmDocumentReceiptProcessType(docReceiptProcessTypeId);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptProcessType> getPmlEdmDocumentReceiptProcessTypes(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getPmlEdmDocumentReceiptProcessTypes(start, end);
    }

    public static int getPmlEdmDocumentReceiptProcessTypesCount()
        throws com.liferay.portal.SystemException {
        return getService().getPmlEdmDocumentReceiptProcessTypesCount();
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptProcessType updatePmlEdmDocumentReceiptProcessType(
        com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptProcessType pmlEdmDocumentReceiptProcessType)
        throws com.liferay.portal.SystemException {
        return getService()
                   .updatePmlEdmDocumentReceiptProcessType(pmlEdmDocumentReceiptProcessType);
    }

    public static PmlEdmDocumentReceiptProcessTypeLocalService getService() {
        if (_service == null) {
            throw new RuntimeException(
                "PmlEdmDocumentReceiptProcessTypeLocalService is not set");
        }

        return _service;
    }

    public void setService(PmlEdmDocumentReceiptProcessTypeLocalService service) {
        _service = service;
    }
}
