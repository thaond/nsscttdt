package com.sgs.portlet.department.service;


/**
 * <a href="PmlDepartmentHSCVLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.sgs.portlet.department.service.PmlDepartmentHSCVLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.department.service.PmlDepartmentHSCVLocalService
 *
 */
public class PmlDepartmentHSCVLocalServiceUtil {
    private static PmlDepartmentHSCVLocalService _service;

    public static com.sgs.portlet.department.model.PmlDepartmentHSCV addPmlDepartmentHSCV(
        com.sgs.portlet.department.model.PmlDepartmentHSCV pmlDepartmentHSCV)
        throws com.liferay.portal.SystemException {
        return getService().addPmlDepartmentHSCV(pmlDepartmentHSCV);
    }

    public static com.sgs.portlet.department.model.PmlDepartmentHSCV createPmlDepartmentHSCV(
        long pmlDepartmentHSCVId) {
        return getService().createPmlDepartmentHSCV(pmlDepartmentHSCVId);
    }

    public static void deletePmlDepartmentHSCV(long pmlDepartmentHSCVId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deletePmlDepartmentHSCV(pmlDepartmentHSCVId);
    }

    public static void deletePmlDepartmentHSCV(
        com.sgs.portlet.department.model.PmlDepartmentHSCV pmlDepartmentHSCV)
        throws com.liferay.portal.SystemException {
        getService().deletePmlDepartmentHSCV(pmlDepartmentHSCV);
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

    public static com.sgs.portlet.department.model.PmlDepartmentHSCV getPmlDepartmentHSCV(
        long pmlDepartmentHSCVId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getPmlDepartmentHSCV(pmlDepartmentHSCVId);
    }

    public static java.util.List<com.sgs.portlet.department.model.PmlDepartmentHSCV> getPmlDepartmentHSCVs(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getPmlDepartmentHSCVs(start, end);
    }

    public static int getPmlDepartmentHSCVsCount()
        throws com.liferay.portal.SystemException {
        return getService().getPmlDepartmentHSCVsCount();
    }

    public static com.sgs.portlet.department.model.PmlDepartmentHSCV updatePmlDepartmentHSCV(
        com.sgs.portlet.department.model.PmlDepartmentHSCV pmlDepartmentHSCV)
        throws com.liferay.portal.SystemException {
        return getService().updatePmlDepartmentHSCV(pmlDepartmentHSCV);
    }

    public static PmlDepartmentHSCVLocalService getService() {
        if (_service == null) {
            throw new RuntimeException(
                "PmlDepartmentHSCVLocalService is not set");
        }

        return _service;
    }

    public void setService(PmlDepartmentHSCVLocalService service) {
        _service = service;
    }
}
