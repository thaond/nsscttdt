package com.sgs.portlet.document.receipt.service;


/**
 * <a href="PmlEdmDocumentTypeLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.sgs.portlet.document.receipt.service.PmlEdmDocumentTypeLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.receipt.service.PmlEdmDocumentTypeLocalService
 *
 */
public class PmlEdmDocumentTypeLocalServiceUtil {
    private static PmlEdmDocumentTypeLocalService _service;

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentType addPmlEdmDocumentType(
        com.sgs.portlet.document.receipt.model.PmlEdmDocumentType pmlEdmDocumentType)
        throws com.liferay.portal.SystemException {
        return getService().addPmlEdmDocumentType(pmlEdmDocumentType);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentType createPmlEdmDocumentType(
        long documentTypeId) {
        return getService().createPmlEdmDocumentType(documentTypeId);
    }

    public static void deletePmlEdmDocumentType(long documentTypeId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deletePmlEdmDocumentType(documentTypeId);
    }

    public static void deletePmlEdmDocumentType(
        com.sgs.portlet.document.receipt.model.PmlEdmDocumentType pmlEdmDocumentType)
        throws com.liferay.portal.SystemException {
        getService().deletePmlEdmDocumentType(pmlEdmDocumentType);
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

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentType getPmlEdmDocumentType(
        long documentTypeId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getPmlEdmDocumentType(documentTypeId);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentType> getPmlEdmDocumentTypes(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getPmlEdmDocumentTypes(start, end);
    }

    public static int getPmlEdmDocumentTypesCount()
        throws com.liferay.portal.SystemException {
        return getService().getPmlEdmDocumentTypesCount();
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentType updatePmlEdmDocumentType(
        com.sgs.portlet.document.receipt.model.PmlEdmDocumentType pmlEdmDocumentType)
        throws com.liferay.portal.SystemException {
        return getService().updatePmlEdmDocumentType(pmlEdmDocumentType);
    }

    public static int searchCount(java.lang.String keywords)
        throws com.liferay.portal.SystemException {
        return getService().searchCount(keywords);
    }

    public static int searchCount(java.lang.String pmlEdmDocumentTypeName,
        java.lang.String pmlEdmDocumentRecordTypeName, boolean andOperator)
        throws com.liferay.portal.SystemException {
        return getService()
                   .searchCount(pmlEdmDocumentTypeName,
            pmlEdmDocumentRecordTypeName, andOperator);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentType> search(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService().search(keywords, start, end, obc);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentType> search(
        java.lang.String pmlEdmDocumentTypeName,
        java.lang.String pmlEdmDocumentRecordTypeName, boolean andOperator,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService()
                   .search(pmlEdmDocumentTypeName,
            pmlEdmDocumentRecordTypeName, andOperator, start, end, obc);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentType> findByDocumentTypeIds(
        java.util.List<Long> documentTypeIds) throws java.lang.Exception {
        return getService().findByDocumentTypeIds(documentTypeIds);
    }

    public static void removePmlEdmDocumentType(long documentTypeId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().removePmlEdmDocumentType(documentTypeId);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentType> getDocType(
        int get1, int get2) throws com.liferay.portal.SystemException {
        return getService().getDocType(get1, get2);
    }

    public static PmlEdmDocumentTypeLocalService getService() {
        if (_service == null) {
            throw new RuntimeException(
                "PmlEdmDocumentTypeLocalService is not set");
        }

        return _service;
    }

    public void setService(PmlEdmDocumentTypeLocalService service) {
        _service = service;
    }
}
