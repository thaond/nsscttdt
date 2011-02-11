package com.sgs.portlet.attachedfile.service;


/**
 * <a href="AttachedFileLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.sgs.portlet.attachedfile.service.AttachedFileLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.attachedfile.service.AttachedFileLocalService
 *
 */
public class AttachedFileLocalServiceUtil {
    private static AttachedFileLocalService _service;

    public static com.sgs.portlet.attachedfile.model.AttachedFile addAttachedFile(
        com.sgs.portlet.attachedfile.model.AttachedFile attachedFile)
        throws com.liferay.portal.SystemException {
        return getService().addAttachedFile(attachedFile);
    }

    public static com.sgs.portlet.attachedfile.model.AttachedFile createAttachedFile(
        java.lang.String attachedFileId) {
        return getService().createAttachedFile(attachedFileId);
    }

    public static void deleteAttachedFile(java.lang.String attachedFileId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deleteAttachedFile(attachedFileId);
    }

    public static void deleteAttachedFile(
        com.sgs.portlet.attachedfile.model.AttachedFile attachedFile)
        throws com.liferay.portal.SystemException {
        getService().deleteAttachedFile(attachedFile);
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

    public static com.sgs.portlet.attachedfile.model.AttachedFile getAttachedFile(
        java.lang.String attachedFileId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getAttachedFile(attachedFileId);
    }

    public static java.util.List<com.sgs.portlet.attachedfile.model.AttachedFile> getAttachedFiles(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getAttachedFiles(start, end);
    }

    public static int getAttachedFilesCount()
        throws com.liferay.portal.SystemException {
        return getService().getAttachedFilesCount();
    }

    public static com.sgs.portlet.attachedfile.model.AttachedFile updateAttachedFile(
        com.sgs.portlet.attachedfile.model.AttachedFile attachedFile)
        throws com.liferay.portal.SystemException {
        return getService().updateAttachedFile(attachedFile);
    }

    public static java.util.List<com.sgs.portlet.attachedfile.model.AttachedFile> search(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService().search(keywords, start, end, obc);
    }

    public static java.util.List<com.sgs.portlet.attachedfile.model.AttachedFile> search(
        java.lang.String code, java.lang.String name, boolean andOperator,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService().search(code, name, andOperator, start, end, obc);
    }

    public static int searchCount(java.lang.String keywords)
        throws com.liferay.portal.SystemException {
        return getService().searchCount(keywords);
    }

    public static int searchCount(java.lang.String code, java.lang.String name,
        boolean andOperator) throws com.liferay.portal.SystemException {
        return getService().searchCount(code, name, andOperator);
    }

    public static void removeAttachedFile(java.lang.String attachedFileId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().removeAttachedFile(attachedFileId);
    }

    public static com.sgs.portlet.attachedfile.model.AttachedFile addAttachedFile(
        java.lang.String attachedFileCode, java.lang.String attachedFileName,
        java.lang.String description, java.lang.String active)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService()
                   .addAttachedFile(attachedFileCode, attachedFileName,
            description, active);
    }

    public static com.sgs.portlet.attachedfile.model.AttachedFile updateAttachedFile(
        java.lang.String attachedFileId, java.lang.String attachedFileCode,
        java.lang.String attachedFileName, java.lang.String description,
        java.lang.String active)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService()
                   .updateAttachedFile(attachedFileId, attachedFileCode,
            attachedFileName, description, active);
    }

    public static AttachedFileLocalService getService() {
        if (_service == null) {
            throw new RuntimeException("AttachedFileLocalService is not set");
        }

        return _service;
    }

    public void setService(AttachedFileLocalService service) {
        _service = service;
    }
}
