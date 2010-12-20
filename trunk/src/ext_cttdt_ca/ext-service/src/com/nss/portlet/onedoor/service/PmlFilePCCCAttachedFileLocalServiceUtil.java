package com.nss.portlet.onedoor.service;


/**
 * <a href="PmlFilePCCCAttachedFileLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.nss.portlet.onedoor.service.PmlFilePCCCAttachedFileLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.onedoor.service.PmlFilePCCCAttachedFileLocalService
 *
 */
public class PmlFilePCCCAttachedFileLocalServiceUtil {
    private static PmlFilePCCCAttachedFileLocalService _service;

    public static com.nss.portlet.onedoor.model.PmlFilePCCCAttachedFile addPmlFilePCCCAttachedFile(
        com.nss.portlet.onedoor.model.PmlFilePCCCAttachedFile pmlFilePCCCAttachedFile)
        throws com.liferay.portal.SystemException {
        return getService().addPmlFilePCCCAttachedFile(pmlFilePCCCAttachedFile);
    }

    public static com.nss.portlet.onedoor.model.PmlFilePCCCAttachedFile createPmlFilePCCCAttachedFile(
        long attachedFileId) {
        return getService().createPmlFilePCCCAttachedFile(attachedFileId);
    }

    public static void deletePmlFilePCCCAttachedFile(long attachedFileId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deletePmlFilePCCCAttachedFile(attachedFileId);
    }

    public static void deletePmlFilePCCCAttachedFile(
        com.nss.portlet.onedoor.model.PmlFilePCCCAttachedFile pmlFilePCCCAttachedFile)
        throws com.liferay.portal.SystemException {
        getService().deletePmlFilePCCCAttachedFile(pmlFilePCCCAttachedFile);
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

    public static com.nss.portlet.onedoor.model.PmlFilePCCCAttachedFile getPmlFilePCCCAttachedFile(
        long attachedFileId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getPmlFilePCCCAttachedFile(attachedFileId);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlFilePCCCAttachedFile> getPmlFilePCCCAttachedFiles(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getPmlFilePCCCAttachedFiles(start, end);
    }

    public static int getPmlFilePCCCAttachedFilesCount()
        throws com.liferay.portal.SystemException {
        return getService().getPmlFilePCCCAttachedFilesCount();
    }

    public static com.nss.portlet.onedoor.model.PmlFilePCCCAttachedFile updatePmlFilePCCCAttachedFile(
        com.nss.portlet.onedoor.model.PmlFilePCCCAttachedFile pmlFilePCCCAttachedFile)
        throws com.liferay.portal.SystemException {
        return getService()
                   .updatePmlFilePCCCAttachedFile(pmlFilePCCCAttachedFile);
    }

    public static com.nss.portlet.onedoor.model.PmlFilePCCCAttachedFile updatePmlFilePCCCAttachedFile(
        com.nss.portlet.onedoor.model.PmlFilePCCCAttachedFile pmlFilePCCCAttachedFile,
        boolean merge) throws com.liferay.portal.SystemException {
        return getService()
                   .updatePmlFilePCCCAttachedFile(pmlFilePCCCAttachedFile, merge);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlFilePCCCAttachedFile> findByFilePcccId(
        java.lang.String fileId) throws com.liferay.portal.SystemException {
        return getService().findByFilePcccId(fileId);
    }

    public static PmlFilePCCCAttachedFileLocalService getService() {
        if (_service == null) {
            throw new RuntimeException(
                "PmlFilePCCCAttachedFileLocalService is not set");
        }

        return _service;
    }

    public void setService(PmlFilePCCCAttachedFileLocalService service) {
        _service = service;
    }
}
