package com.sgs.portlet.onedoor.service;


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
 * <code>com.sgs.portlet.onedoor.service.PmlFileAttachedFileLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.onedoor.service.PmlFileAttachedFileLocalService
 *
 */
public class PmlFileAttachedFileLocalServiceUtil {
    private static PmlFileAttachedFileLocalService _service;

    public static com.sgs.portlet.onedoor.model.PmlFileAttachedFile addPmlFileAttachedFile(
        com.sgs.portlet.onedoor.model.PmlFileAttachedFile pmlFileAttachedFile)
        throws com.liferay.portal.SystemException {
        return getService().addPmlFileAttachedFile(pmlFileAttachedFile);
    }

    public static com.sgs.portlet.onedoor.model.PmlFileAttachedFile createPmlFileAttachedFile(
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
        com.sgs.portlet.onedoor.model.PmlFileAttachedFile pmlFileAttachedFile)
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

    public static com.sgs.portlet.onedoor.model.PmlFileAttachedFile getPmlFileAttachedFile(
        java.lang.String fileAttachedFileId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getPmlFileAttachedFile(fileAttachedFileId);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlFileAttachedFile> getPmlFileAttachedFiles(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getPmlFileAttachedFiles(start, end);
    }

    public static int getPmlFileAttachedFilesCount()
        throws com.liferay.portal.SystemException {
        return getService().getPmlFileAttachedFilesCount();
    }

    public static com.sgs.portlet.onedoor.model.PmlFileAttachedFile updatePmlFileAttachedFile(
        com.sgs.portlet.onedoor.model.PmlFileAttachedFile pmlFileAttachedFile)
        throws com.liferay.portal.SystemException {
        return getService().updatePmlFileAttachedFile(pmlFileAttachedFile);
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
