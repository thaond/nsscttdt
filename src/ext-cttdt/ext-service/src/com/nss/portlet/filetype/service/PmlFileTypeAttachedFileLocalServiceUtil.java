package com.nss.portlet.filetype.service;


/**
 * <a href="PmlFileTypeAttachedFileLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.nss.portlet.filetype.service.PmlFileTypeAttachedFileLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.filetype.service.PmlFileTypeAttachedFileLocalService
 *
 */
public class PmlFileTypeAttachedFileLocalServiceUtil {
    private static PmlFileTypeAttachedFileLocalService _service;

    public static com.nss.portlet.filetype.model.PmlFileTypeAttachedFile addPmlFileTypeAttachedFile(
        com.nss.portlet.filetype.model.PmlFileTypeAttachedFile pmlFileTypeAttachedFile)
        throws com.liferay.portal.SystemException {
        return getService().addPmlFileTypeAttachedFile(pmlFileTypeAttachedFile);
    }

    public static com.nss.portlet.filetype.model.PmlFileTypeAttachedFile createPmlFileTypeAttachedFile(
        java.lang.String filetypeAttachedFileId) {
        return getService().createPmlFileTypeAttachedFile(filetypeAttachedFileId);
    }

    public static void deletePmlFileTypeAttachedFile(
        java.lang.String filetypeAttachedFileId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deletePmlFileTypeAttachedFile(filetypeAttachedFileId);
    }

    public static void deletePmlFileTypeAttachedFile(
        com.nss.portlet.filetype.model.PmlFileTypeAttachedFile pmlFileTypeAttachedFile)
        throws com.liferay.portal.SystemException {
        getService().deletePmlFileTypeAttachedFile(pmlFileTypeAttachedFile);
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

    public static com.nss.portlet.filetype.model.PmlFileTypeAttachedFile getPmlFileTypeAttachedFile(
        java.lang.String filetypeAttachedFileId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getPmlFileTypeAttachedFile(filetypeAttachedFileId);
    }

    public static java.util.List<com.nss.portlet.filetype.model.PmlFileTypeAttachedFile> getPmlFileTypeAttachedFiles(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getPmlFileTypeAttachedFiles(start, end);
    }

    public static int getPmlFileTypeAttachedFilesCount()
        throws com.liferay.portal.SystemException {
        return getService().getPmlFileTypeAttachedFilesCount();
    }

    public static com.nss.portlet.filetype.model.PmlFileTypeAttachedFile updatePmlFileTypeAttachedFile(
        com.nss.portlet.filetype.model.PmlFileTypeAttachedFile pmlFileTypeAttachedFile)
        throws com.liferay.portal.SystemException {
        return getService()
                   .updatePmlFileTypeAttachedFile(pmlFileTypeAttachedFile);
    }

    public static com.nss.portlet.filetype.model.PmlFileTypeAttachedFile updatePmlFileTypeAttachedFile(
        com.nss.portlet.filetype.model.PmlFileTypeAttachedFile pmlFileTypeAttachedFile,
        boolean merge) throws com.liferay.portal.SystemException {
        return getService()
                   .updatePmlFileTypeAttachedFile(pmlFileTypeAttachedFile, merge);
    }

    public static java.util.List<com.nss.portlet.filetype.model.PmlFileTypeAttachedFile> findByAttachedFileId(
        java.lang.String attachedFileId)
        throws com.liferay.portal.SystemException {
        return getService().findByAttachedFileId(attachedFileId);
    }

    public static java.util.List<com.nss.portlet.filetype.model.PmlFileTypeAttachedFile> findByFileTypeId(
        java.lang.String fileTypeId) throws com.liferay.portal.SystemException {
        return getService().findByFileTypeId(fileTypeId);
    }

    public static PmlFileTypeAttachedFileLocalService getService() {
        if (_service == null) {
            throw new RuntimeException(
                "PmlFileTypeAttachedFileLocalService is not set");
        }

        return _service;
    }

    public void setService(PmlFileTypeAttachedFileLocalService service) {
        _service = service;
    }
}
