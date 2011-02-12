package com.sgs.portlet.vanbannoibo.service;


/**
 * <a href="LogVanBanNoiBoLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.sgs.portlet.vanbannoibo.service.LogVanBanNoiBoLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.vanbannoibo.service.LogVanBanNoiBoLocalService
 *
 */
public class LogVanBanNoiBoLocalServiceUtil {
    private static LogVanBanNoiBoLocalService _service;

    public static com.sgs.portlet.vanbannoibo.model.LogVanBanNoiBo addLogVanBanNoiBo(
        com.sgs.portlet.vanbannoibo.model.LogVanBanNoiBo logVanBanNoiBo)
        throws com.liferay.portal.SystemException {
        return getService().addLogVanBanNoiBo(logVanBanNoiBo);
    }

    public static com.sgs.portlet.vanbannoibo.model.LogVanBanNoiBo createLogVanBanNoiBo(
        long logVanBanNoiBoId) {
        return getService().createLogVanBanNoiBo(logVanBanNoiBoId);
    }

    public static void deleteLogVanBanNoiBo(long logVanBanNoiBoId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deleteLogVanBanNoiBo(logVanBanNoiBoId);
    }

    public static void deleteLogVanBanNoiBo(
        com.sgs.portlet.vanbannoibo.model.LogVanBanNoiBo logVanBanNoiBo)
        throws com.liferay.portal.SystemException {
        getService().deleteLogVanBanNoiBo(logVanBanNoiBo);
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

    public static com.sgs.portlet.vanbannoibo.model.LogVanBanNoiBo getLogVanBanNoiBo(
        long logVanBanNoiBoId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getLogVanBanNoiBo(logVanBanNoiBoId);
    }

    public static java.util.List<com.sgs.portlet.vanbannoibo.model.LogVanBanNoiBo> getLogVanBanNoiBos(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getLogVanBanNoiBos(start, end);
    }

    public static int getLogVanBanNoiBosCount()
        throws com.liferay.portal.SystemException {
        return getService().getLogVanBanNoiBosCount();
    }

    public static com.sgs.portlet.vanbannoibo.model.LogVanBanNoiBo updateLogVanBanNoiBo(
        com.sgs.portlet.vanbannoibo.model.LogVanBanNoiBo logVanBanNoiBo)
        throws com.liferay.portal.SystemException {
        return getService().updateLogVanBanNoiBo(logVanBanNoiBo);
    }

    public static LogVanBanNoiBoLocalService getService() {
        if (_service == null) {
            throw new RuntimeException("LogVanBanNoiBoLocalService is not set");
        }

        return _service;
    }

    public void setService(LogVanBanNoiBoLocalService service) {
        _service = service;
    }
}
