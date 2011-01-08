package com.sgs.portlet.document.receipt.service;


/**
 * <a href="PmlEdmAttachedFileLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.sgs.portlet.document.receipt.service.PmlEdmAttachedFileLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.receipt.service.PmlEdmAttachedFileLocalService
 *
 */
public class PmlEdmAttachedFileLocalServiceUtil {
    private static PmlEdmAttachedFileLocalService _service;

    public static com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile addPmlEdmAttachedFile(
        com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile pmlEdmAttachedFile)
        throws com.liferay.portal.SystemException {
        return getService().addPmlEdmAttachedFile(pmlEdmAttachedFile);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile createPmlEdmAttachedFile(
        long attachedFileId) {
        return getService().createPmlEdmAttachedFile(attachedFileId);
    }

    public static void deletePmlEdmAttachedFile(long attachedFileId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deletePmlEdmAttachedFile(attachedFileId);
    }

    public static void deletePmlEdmAttachedFile(
        com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile pmlEdmAttachedFile)
        throws com.liferay.portal.SystemException {
        getService().deletePmlEdmAttachedFile(pmlEdmAttachedFile);
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

    public static com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile getPmlEdmAttachedFile(
        long attachedFileId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getPmlEdmAttachedFile(attachedFileId);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile> getPmlEdmAttachedFiles(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getPmlEdmAttachedFiles(start, end);
    }

    public static int getPmlEdmAttachedFilesCount()
        throws com.liferay.portal.SystemException {
        return getService().getPmlEdmAttachedFilesCount();
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile updatePmlEdmAttachedFile(
        com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile pmlEdmAttachedFile)
        throws com.liferay.portal.SystemException {
        return getService().updatePmlEdmAttachedFile(pmlEdmAttachedFile);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile> getAttachedFileForLog(
        java.lang.Class clazz, long id) {
        return getService().getAttachedFileForLog(clazz, id);
    }

    public static int deletePmlEdmAttachedFileByOO(long objectContentId,
        java.lang.String objectType) {
        return getService()
                   .deletePmlEdmAttachedFileByOO(objectContentId, objectType);
    }

    public static PmlEdmAttachedFileLocalService getService() {
        if (_service == null) {
            throw new RuntimeException(
                "PmlEdmAttachedFileLocalService is not set");
        }

        return _service;
    }

    public void setService(PmlEdmAttachedFileLocalService service) {
        _service = service;
    }
}
