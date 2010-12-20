package com.nss.portlet.onedoor.service;


/**
 * <a href="PmlStateProcessLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.nss.portlet.onedoor.service.PmlStateProcessLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.onedoor.service.PmlStateProcessLocalService
 *
 */
public class PmlStateProcessLocalServiceUtil {
    private static PmlStateProcessLocalService _service;

    public static com.nss.portlet.onedoor.model.PmlStateProcess addPmlStateProcess(
        com.nss.portlet.onedoor.model.PmlStateProcess pmlStateProcess)
        throws com.liferay.portal.SystemException {
        return getService().addPmlStateProcess(pmlStateProcess);
    }

    public static com.nss.portlet.onedoor.model.PmlStateProcess createPmlStateProcess(
        long stateProcessId) {
        return getService().createPmlStateProcess(stateProcessId);
    }

    public static void deletePmlStateProcess(long stateProcessId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deletePmlStateProcess(stateProcessId);
    }

    public static void deletePmlStateProcess(
        com.nss.portlet.onedoor.model.PmlStateProcess pmlStateProcess)
        throws com.liferay.portal.SystemException {
        getService().deletePmlStateProcess(pmlStateProcess);
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

    public static com.nss.portlet.onedoor.model.PmlStateProcess getPmlStateProcess(
        long stateProcessId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getPmlStateProcess(stateProcessId);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlStateProcess> getPmlStateProcesses(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getPmlStateProcesses(start, end);
    }

    public static int getPmlStateProcessesCount()
        throws com.liferay.portal.SystemException {
        return getService().getPmlStateProcessesCount();
    }

    public static com.nss.portlet.onedoor.model.PmlStateProcess updatePmlStateProcess(
        com.nss.portlet.onedoor.model.PmlStateProcess pmlStateProcess)
        throws com.liferay.portal.SystemException {
        return getService().updatePmlStateProcess(pmlStateProcess);
    }

    public static com.nss.portlet.onedoor.model.PmlStateProcess updatePmlStateProcess(
        com.nss.portlet.onedoor.model.PmlStateProcess pmlStateProcess,
        boolean merge) throws com.liferay.portal.SystemException {
        return getService().updatePmlStateProcess(pmlStateProcess, merge);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlStateProcess> findByStateProcessIds(
        java.util.List<Long> stateProcessIds) throws java.lang.Exception {
        return getService().findByStateProcessIds(stateProcessIds);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlStateProcess> findByStateProcessCode(
        java.lang.String stateProcessCode)
        throws com.liferay.portal.SystemException {
        return getService().findByStateProcessCode(stateProcessCode);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlStateProcess> findByStateProcessCode_Name(
        java.lang.String stateProcessCode, java.lang.String typeWorkflow)
        throws com.liferay.portal.SystemException {
        return getService()
                   .findByStateProcessCode_Name(stateProcessCode, typeWorkflow);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlStateProcess> findByStateProcessName(
        java.lang.String typeWorkflow)
        throws com.liferay.portal.SystemException {
        return getService().findByStateProcessName(typeWorkflow);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlStateProcess> findByFileStatusId(
        long fileStatusId) {
        return getService().findByFileStatusId(fileStatusId);
    }

    public static PmlStateProcessLocalService getService() {
        if (_service == null) {
            throw new RuntimeException("PmlStateProcessLocalService is not set");
        }

        return _service;
    }

    public void setService(PmlStateProcessLocalService service) {
        _service = service;
    }
}
