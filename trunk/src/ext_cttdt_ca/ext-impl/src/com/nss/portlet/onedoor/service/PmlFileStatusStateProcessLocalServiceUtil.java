package com.nss.portlet.onedoor.service;


/**
 * <a href="PmlFileStatusStateProcessLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.nss.portlet.onedoor.service.PmlFileStatusStateProcessLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.onedoor.service.PmlFileStatusStateProcessLocalService
 *
 */
public class PmlFileStatusStateProcessLocalServiceUtil {
    private static PmlFileStatusStateProcessLocalService _service;

    public static com.nss.portlet.onedoor.model.PmlFileStatusStateProcess addPmlFileStatusStateProcess(
        com.nss.portlet.onedoor.model.PmlFileStatusStateProcess pmlFileStatusStateProcess)
        throws com.liferay.portal.SystemException {
        return getService()
                   .addPmlFileStatusStateProcess(pmlFileStatusStateProcess);
    }

    public static com.nss.portlet.onedoor.model.PmlFileStatusStateProcess createPmlFileStatusStateProcess(
        long id) {
        return getService().createPmlFileStatusStateProcess(id);
    }

    public static void deletePmlFileStatusStateProcess(long id)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deletePmlFileStatusStateProcess(id);
    }

    public static void deletePmlFileStatusStateProcess(
        com.nss.portlet.onedoor.model.PmlFileStatusStateProcess pmlFileStatusStateProcess)
        throws com.liferay.portal.SystemException {
        getService().deletePmlFileStatusStateProcess(pmlFileStatusStateProcess);
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

    public static com.nss.portlet.onedoor.model.PmlFileStatusStateProcess getPmlFileStatusStateProcess(
        long id)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getPmlFileStatusStateProcess(id);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlFileStatusStateProcess> getPmlFileStatusStateProcesses(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getPmlFileStatusStateProcesses(start, end);
    }

    public static int getPmlFileStatusStateProcessesCount()
        throws com.liferay.portal.SystemException {
        return getService().getPmlFileStatusStateProcessesCount();
    }

    public static com.nss.portlet.onedoor.model.PmlFileStatusStateProcess updatePmlFileStatusStateProcess(
        com.nss.portlet.onedoor.model.PmlFileStatusStateProcess pmlFileStatusStateProcess)
        throws com.liferay.portal.SystemException {
        return getService()
                   .updatePmlFileStatusStateProcess(pmlFileStatusStateProcess);
    }

    public static com.nss.portlet.onedoor.model.PmlFileStatusStateProcess updatePmlFileStatusStateProcess(
        com.nss.portlet.onedoor.model.PmlFileStatusStateProcess pmlFileStatusStateProcess,
        boolean merge) throws com.liferay.portal.SystemException {
        return getService()
                   .updatePmlFileStatusStateProcess(pmlFileStatusStateProcess,
            merge);
    }

    public static void removeFileStatusStateProcess(
        long filestatusStateProcessId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().removeFileStatusStateProcess(filestatusStateProcessId);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlFileStatusStateProcess> findByFileStatusId(
        long filestatusId) throws com.liferay.portal.SystemException {
        return getService().findByFileStatusId(filestatusId);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlFileStatusStateProcess> findByFileStatus_StateProcess(
        long fileStatusId, long stateProcessIdChooice)
        throws com.liferay.portal.SystemException {
        return getService()
                   .findByFileStatus_StateProcess(fileStatusId,
            stateProcessIdChooice);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlFileStatusStateProcess> findByStateProcessId(
        long stateProcessId) throws com.liferay.portal.SystemException {
        return getService().findByStateProcessId(stateProcessId);
    }

    public static PmlFileStatusStateProcessLocalService getService() {
        if (_service == null) {
            throw new RuntimeException(
                "PmlFileStatusStateProcessLocalService is not set");
        }

        return _service;
    }

    public void setService(PmlFileStatusStateProcessLocalService service) {
        _service = service;
    }
}
