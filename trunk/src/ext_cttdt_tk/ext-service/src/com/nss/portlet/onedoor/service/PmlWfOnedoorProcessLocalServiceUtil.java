package com.nss.portlet.onedoor.service;


/**
 * <a href="PmlWfOnedoorProcessLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.nss.portlet.onedoor.service.PmlWfOnedoorProcessLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.onedoor.service.PmlWfOnedoorProcessLocalService
 *
 */
public class PmlWfOnedoorProcessLocalServiceUtil {
    private static PmlWfOnedoorProcessLocalService _service;

    public static com.nss.portlet.onedoor.model.PmlWfOnedoorProcess addPmlWfOnedoorProcess(
        com.nss.portlet.onedoor.model.PmlWfOnedoorProcess pmlWfOnedoorProcess)
        throws com.liferay.portal.SystemException {
        return getService().addPmlWfOnedoorProcess(pmlWfOnedoorProcess);
    }

    public static com.nss.portlet.onedoor.model.PmlWfOnedoorProcess createPmlWfOnedoorProcess(
        java.lang.String fileId) {
        return getService().createPmlWfOnedoorProcess(fileId);
    }

    public static void deletePmlWfOnedoorProcess(java.lang.String fileId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deletePmlWfOnedoorProcess(fileId);
    }

    public static void deletePmlWfOnedoorProcess(
        com.nss.portlet.onedoor.model.PmlWfOnedoorProcess pmlWfOnedoorProcess)
        throws com.liferay.portal.SystemException {
        getService().deletePmlWfOnedoorProcess(pmlWfOnedoorProcess);
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

    public static com.nss.portlet.onedoor.model.PmlWfOnedoorProcess getPmlWfOnedoorProcess(
        java.lang.String fileId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getPmlWfOnedoorProcess(fileId);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlWfOnedoorProcess> getPmlWfOnedoorProcesses(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getPmlWfOnedoorProcesses(start, end);
    }

    public static int getPmlWfOnedoorProcessesCount()
        throws com.liferay.portal.SystemException {
        return getService().getPmlWfOnedoorProcessesCount();
    }

    public static com.nss.portlet.onedoor.model.PmlWfOnedoorProcess updatePmlWfOnedoorProcess(
        com.nss.portlet.onedoor.model.PmlWfOnedoorProcess pmlWfOnedoorProcess)
        throws com.liferay.portal.SystemException {
        return getService().updatePmlWfOnedoorProcess(pmlWfOnedoorProcess);
    }

    public static com.nss.portlet.onedoor.model.PmlWfOnedoorProcess updatePmlWfOnedoorProcess(
        com.nss.portlet.onedoor.model.PmlWfOnedoorProcess pmlWfOnedoorProcess,
        boolean merge) throws com.liferay.portal.SystemException {
        return getService().updatePmlWfOnedoorProcess(pmlWfOnedoorProcess, merge);
    }

    public static PmlWfOnedoorProcessLocalService getService() {
        if (_service == null) {
            throw new RuntimeException(
                "PmlWfOnedoorProcessLocalService is not set");
        }

        return _service;
    }

    public void setService(PmlWfOnedoorProcessLocalService service) {
        _service = service;
    }
}
