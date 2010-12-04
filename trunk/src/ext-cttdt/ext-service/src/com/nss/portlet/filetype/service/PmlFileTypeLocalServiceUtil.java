package com.nss.portlet.filetype.service;


/**
 * <a href="PmlFileTypeLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.nss.portlet.filetype.service.PmlFileTypeLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.filetype.service.PmlFileTypeLocalService
 *
 */
public class PmlFileTypeLocalServiceUtil {
    private static PmlFileTypeLocalService _service;

    public static com.nss.portlet.filetype.model.PmlFileType addPmlFileType(
        com.nss.portlet.filetype.model.PmlFileType pmlFileType)
        throws com.liferay.portal.SystemException {
        return getService().addPmlFileType(pmlFileType);
    }

    public static com.nss.portlet.filetype.model.PmlFileType createPmlFileType(
        java.lang.String fileTypeId) {
        return getService().createPmlFileType(fileTypeId);
    }

    public static void deletePmlFileType(java.lang.String fileTypeId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deletePmlFileType(fileTypeId);
    }

    public static void deletePmlFileType(
        com.nss.portlet.filetype.model.PmlFileType pmlFileType)
        throws com.liferay.portal.SystemException {
        getService().deletePmlFileType(pmlFileType);
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

    public static com.nss.portlet.filetype.model.PmlFileType getPmlFileType(
        java.lang.String fileTypeId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getPmlFileType(fileTypeId);
    }

    public static java.util.List<com.nss.portlet.filetype.model.PmlFileType> getPmlFileTypes(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getPmlFileTypes(start, end);
    }

    public static int getPmlFileTypesCount()
        throws com.liferay.portal.SystemException {
        return getService().getPmlFileTypesCount();
    }

    public static com.nss.portlet.filetype.model.PmlFileType updatePmlFileType(
        com.nss.portlet.filetype.model.PmlFileType pmlFileType)
        throws com.liferay.portal.SystemException {
        return getService().updatePmlFileType(pmlFileType);
    }

    public static com.nss.portlet.filetype.model.PmlFileType updatePmlFileType(
        com.nss.portlet.filetype.model.PmlFileType pmlFileType, boolean merge)
        throws com.liferay.portal.SystemException {
        return getService().updatePmlFileType(pmlFileType, merge);
    }

    public static int searchCount(java.lang.String keywords)
        throws com.liferay.portal.SystemException {
        return getService().searchCount(keywords);
    }

    public static int searchCount(java.lang.String fileTypeCode,
        java.lang.String fileTypeName, boolean andOperator)
        throws com.liferay.portal.SystemException {
        return getService().searchCount(fileTypeCode, fileTypeName, andOperator);
    }

    public static java.util.List<com.nss.portlet.filetype.model.PmlFileType> search(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService().search(keywords, start, end, obc);
    }

    public static java.util.List<com.nss.portlet.filetype.model.PmlFileType> search(
        java.lang.String fileTypeCode, java.lang.String fileTypeName,
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService()
                   .search(fileTypeCode, fileTypeName, andOperator, start, end,
            obc);
    }

    public static void removePmlFileType(java.lang.String fileTypeId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().removePmlFileType(fileTypeId);
    }

    public static com.nss.portlet.filetype.model.PmlFileType addFileType(
        java.lang.String fileTypeCode, java.lang.String fileTypeName,
        java.lang.String fieldId, java.lang.String processTime,
        java.lang.String description, java.lang.String active,
        java.lang.String currentReceiptNumber,
        java.lang.String receiptTemplate, java.lang.String templateId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService()
                   .addFileType(fileTypeCode, fileTypeName, fieldId,
            processTime, description, active, currentReceiptNumber,
            receiptTemplate, templateId);
    }

    public static com.nss.portlet.filetype.model.PmlFileType updateFileType(
        java.lang.String fileTypeId, java.lang.String fileTypeCode,
        java.lang.String fileTypeName, java.lang.String fieldId,
        java.lang.String processTime, java.lang.String description,
        java.lang.String active, java.lang.String currentReceiptNumber,
        java.lang.String receiptTemplate, java.lang.String templateId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService()
                   .updateFileType(fileTypeId, fileTypeCode, fileTypeName,
            fieldId, processTime, description, active, currentReceiptNumber,
            receiptTemplate, templateId);
    }

    public static PmlFileTypeLocalService getService() {
        if (_service == null) {
            throw new RuntimeException("PmlFileTypeLocalService is not set");
        }

        return _service;
    }

    public void setService(PmlFileTypeLocalService service) {
        _service = service;
    }
}
