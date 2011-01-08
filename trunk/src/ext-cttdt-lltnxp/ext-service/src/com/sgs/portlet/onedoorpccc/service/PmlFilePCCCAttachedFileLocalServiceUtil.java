package com.sgs.portlet.onedoorpccc.service;


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
 * <code>com.sgs.portlet.onedoorpccc.service.PmlFilePCCCAttachedFileLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.onedoorpccc.service.PmlFilePCCCAttachedFileLocalService
 *
 */
public class PmlFilePCCCAttachedFileLocalServiceUtil {
    private static PmlFilePCCCAttachedFileLocalService _service;

    public static com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile addPmlFilePCCCAttachedFile(
        com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile pmlFilePCCCAttachedFile)
        throws com.liferay.portal.SystemException {
        return getService().addPmlFilePCCCAttachedFile(pmlFilePCCCAttachedFile);
    }

    public static com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile createPmlFilePCCCAttachedFile(
        long attachedFileId) {
        return getService().createPmlFilePCCCAttachedFile(attachedFileId);
    }

    public static void deletePmlFilePCCCAttachedFile(long attachedFileId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deletePmlFilePCCCAttachedFile(attachedFileId);
    }

    public static void deletePmlFilePCCCAttachedFile(
        com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile pmlFilePCCCAttachedFile)
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

    public static com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile getPmlFilePCCCAttachedFile(
        long attachedFileId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getPmlFilePCCCAttachedFile(attachedFileId);
    }

    public static java.util.List<com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile> getPmlFilePCCCAttachedFiles(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getPmlFilePCCCAttachedFiles(start, end);
    }

    public static int getPmlFilePCCCAttachedFilesCount()
        throws com.liferay.portal.SystemException {
        return getService().getPmlFilePCCCAttachedFilesCount();
    }

    public static com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile updatePmlFilePCCCAttachedFile(
        com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile pmlFilePCCCAttachedFile)
        throws com.liferay.portal.SystemException {
        return getService()
                   .updatePmlFilePCCCAttachedFile(pmlFilePCCCAttachedFile);
    }

    public static java.util.List<com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile> getAttachedFilePCCCForUpload(
        java.lang.Class clazz, java.lang.String id) {
        return getService().getAttachedFilePCCCForUpload(clazz, id);
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
