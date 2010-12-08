package com.nss.portlet.filetype.service;


/**
 * <a href="PmlFileAttachedFileLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.nss.portlet.filetype.service.PmlFileAttachedFileLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.filetype.service.PmlFileAttachedFileLocalService
 *
 */
public class PmlFileAttachedFileLocalServiceUtil {
    private static PmlFileAttachedFileLocalService _service;

    public static com.nss.portlet.filetype.model.PmlFileAttachedFile addPmlFileAttachedFile(
        com.nss.portlet.filetype.model.PmlFileAttachedFile pmlFileAttachedFile)
        throws com.liferay.portal.SystemException {
        return getService().addPmlFileAttachedFile(pmlFileAttachedFile);
    }

    public static com.nss.portlet.filetype.model.PmlFileAttachedFile createPmlFileAttachedFile(
        java.lang.String fileAttachedFileId) {
        return getService().createPmlFileAttachedFile(fileAttachedFileId);
    }

    public static void deletePmlFileAttachedFile(
        java.lang.String fileAttachedFileId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deletePmlFileAttachedFile(fileAttachedFileId);
    }

    public static void deletePmlFileAttachedFile(
        com.nss.portlet.filetype.model.PmlFileAttachedFile pmlFileAttachedFile)
        throws com.liferay.portal.SystemException {
        getService().deletePmlFileAttachedFile(pmlFileAttachedFile);
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

    public static com.nss.portlet.filetype.model.PmlFileAttachedFile getPmlFileAttachedFile(
        java.lang.String fileAttachedFileId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getPmlFileAttachedFile(fileAttachedFileId);
    }

    public static java.util.List<com.nss.portlet.filetype.model.PmlFileAttachedFile> getPmlFileAttachedFiles(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getPmlFileAttachedFiles(start, end);
    }

    public static int getPmlFileAttachedFilesCount()
        throws com.liferay.portal.SystemException {
        return getService().getPmlFileAttachedFilesCount();
    }

    public static com.nss.portlet.filetype.model.PmlFileAttachedFile updatePmlFileAttachedFile(
        com.nss.portlet.filetype.model.PmlFileAttachedFile pmlFileAttachedFile)
        throws com.liferay.portal.SystemException {
        return getService().updatePmlFileAttachedFile(pmlFileAttachedFile);
    }

    public static com.nss.portlet.filetype.model.PmlFileAttachedFile updatePmlFileAttachedFile(
        com.nss.portlet.filetype.model.PmlFileAttachedFile pmlFileAttachedFile,
        boolean merge) throws com.liferay.portal.SystemException {
        return getService().updatePmlFileAttachedFile(pmlFileAttachedFile, merge);
    }

    public static java.util.List<com.nss.portlet.filetype.model.PmlFileAttachedFile> findByAttachedFileId(
        java.lang.String attachedFileId)
        throws com.liferay.portal.SystemException {
        return getService().findByAttachedFileId(attachedFileId);
    }

    public static void removeByFileId(java.lang.String fileId)
        throws com.liferay.portal.SystemException {
        getService().removeByFileId(fileId);
    }

    public static java.util.List<com.nss.portlet.filetype.model.PmlFileAttachedFile> findByFileId(
        java.lang.String fileId) throws com.liferay.portal.SystemException {
        return getService().findByFileId(fileId);
    }

    public static PmlFileAttachedFileLocalService getService() {
        if (_service == null) {
            throw new RuntimeException(
                "PmlFileAttachedFileLocalService is not set");
        }

        return _service;
    }

    public void setService(PmlFileAttachedFileLocalService service) {
        _service = service;
    }
}
