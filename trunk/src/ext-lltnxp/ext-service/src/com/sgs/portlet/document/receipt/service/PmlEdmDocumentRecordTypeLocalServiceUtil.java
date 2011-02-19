package com.sgs.portlet.document.receipt.service;


/**
 * <a href="PmlEdmDocumentRecordTypeLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.sgs.portlet.document.receipt.service.PmlEdmDocumentRecordTypeLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.receipt.service.PmlEdmDocumentRecordTypeLocalService
 *
 */
public class PmlEdmDocumentRecordTypeLocalServiceUtil {
    private static PmlEdmDocumentRecordTypeLocalService _service;

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType addPmlEdmDocumentRecordType(
        com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType pmlEdmDocumentRecordType)
        throws com.liferay.portal.SystemException {
        return getService().addPmlEdmDocumentRecordType(pmlEdmDocumentRecordType);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType createPmlEdmDocumentRecordType(
        int documentRecordTypeId) {
        return getService().createPmlEdmDocumentRecordType(documentRecordTypeId);
    }

    public static void deletePmlEdmDocumentRecordType(int documentRecordTypeId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deletePmlEdmDocumentRecordType(documentRecordTypeId);
    }

    public static void deletePmlEdmDocumentRecordType(
        com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType pmlEdmDocumentRecordType)
        throws com.liferay.portal.SystemException {
        getService().deletePmlEdmDocumentRecordType(pmlEdmDocumentRecordType);
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

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType getPmlEdmDocumentRecordType(
        int documentRecordTypeId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getPmlEdmDocumentRecordType(documentRecordTypeId);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType> getPmlEdmDocumentRecordTypes(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getPmlEdmDocumentRecordTypes(start, end);
    }

    public static int getPmlEdmDocumentRecordTypesCount()
        throws com.liferay.portal.SystemException {
        return getService().getPmlEdmDocumentRecordTypesCount();
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType updatePmlEdmDocumentRecordType(
        com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType pmlEdmDocumentRecordType)
        throws com.liferay.portal.SystemException {
        return getService()
                   .updatePmlEdmDocumentRecordType(pmlEdmDocumentRecordType);
    }

    public static int searchCount(java.lang.String keywords)
        throws com.liferay.portal.SystemException {
        return getService().searchCount(keywords);
    }

    public static int searchCount(
        java.lang.String pmlEdmDocumentRecordTypeCode,
        java.lang.String pmlEdmDocumentRecordTypeName, boolean andOperator)
        throws com.liferay.portal.SystemException {
        return getService()
                   .searchCount(pmlEdmDocumentRecordTypeCode,
            pmlEdmDocumentRecordTypeName, andOperator);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType> search(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService().search(keywords, start, end, obc);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType> search(
        java.lang.String pmlEdmDocumentRecordTypeCode,
        java.lang.String pmlEdmDocumentRecordTypeName, boolean andOperator,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService()
                   .search(pmlEdmDocumentRecordTypeCode,
            pmlEdmDocumentRecordTypeName, andOperator, start, end, obc);
    }

    public static void removePmlEdmDocumentType(int documentRecordTypeId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().removePmlEdmDocumentType(documentRecordTypeId);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType> findByDocumentRecordTypeCode(
        java.lang.String documentRecordTypeCode)
        throws com.liferay.portal.SystemException {
        return getService().findByDocumentRecordTypeCode(documentRecordTypeCode);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType> getDocumentRecordTypeUseForAgency(
        java.lang.String flag, java.lang.String agencyId, int currentYear)
        throws java.lang.Exception {
        return getService()
                   .getDocumentRecordTypeUseForAgency(flag, agencyId,
            currentYear);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType> getDocumentRecordTypeUseForDeparment(
        java.lang.String departmentId, int currentYear)
        throws java.lang.Exception {
        return getService()
                   .getDocumentRecordTypeUseForDeparment(departmentId,
            currentYear);
    }

    public static PmlEdmDocumentRecordTypeLocalService getService() {
        if (_service == null) {
            throw new RuntimeException(
                "PmlEdmDocumentRecordTypeLocalService is not set");
        }

        return _service;
    }

    public void setService(PmlEdmDocumentRecordTypeLocalService service) {
        _service = service;
    }
}
