package com.sgs.portlet.document.service;


/**
 * <a href="PmlMainSupportLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.sgs.portlet.document.service.PmlMainSupportLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.service.PmlMainSupportLocalService
 *
 */
public class PmlMainSupportLocalServiceUtil {
    private static PmlMainSupportLocalService _service;

    public static com.sgs.portlet.document.model.PmlMainSupport addPmlMainSupport(
        com.sgs.portlet.document.model.PmlMainSupport pmlMainSupport)
        throws com.liferay.portal.SystemException {
        return getService().addPmlMainSupport(pmlMainSupport);
    }

    public static com.sgs.portlet.document.model.PmlMainSupport createPmlMainSupport(
        long processId) {
        return getService().createPmlMainSupport(processId);
    }

    public static void deletePmlMainSupport(long processId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deletePmlMainSupport(processId);
    }

    public static void deletePmlMainSupport(
        com.sgs.portlet.document.model.PmlMainSupport pmlMainSupport)
        throws com.liferay.portal.SystemException {
        getService().deletePmlMainSupport(pmlMainSupport);
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

    public static com.sgs.portlet.document.model.PmlMainSupport getPmlMainSupport(
        long processId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getPmlMainSupport(processId);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlMainSupport> getPmlMainSupports(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getPmlMainSupports(start, end);
    }

    public static int getPmlMainSupportsCount()
        throws com.liferay.portal.SystemException {
        return getService().getPmlMainSupportsCount();
    }

    public static com.sgs.portlet.document.model.PmlMainSupport updatePmlMainSupport(
        com.sgs.portlet.document.model.PmlMainSupport pmlMainSupport)
        throws com.liferay.portal.SystemException {
        return getService().updatePmlMainSupport(pmlMainSupport);
    }

    public static PmlMainSupportLocalService getService() {
        if (_service == null) {
            throw new RuntimeException("PmlMainSupportLocalService is not set");
        }

        return _service;
    }

    public void setService(PmlMainSupportLocalService service) {
        _service = service;
    }
}
