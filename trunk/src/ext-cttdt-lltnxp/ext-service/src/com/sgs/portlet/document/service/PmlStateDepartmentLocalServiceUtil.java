package com.sgs.portlet.document.service;


/**
 * <a href="PmlStateDepartmentLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.sgs.portlet.document.service.PmlStateDepartmentLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.service.PmlStateDepartmentLocalService
 *
 */
public class PmlStateDepartmentLocalServiceUtil {
    private static PmlStateDepartmentLocalService _service;

    public static com.sgs.portlet.document.model.PmlStateDepartment addPmlStateDepartment(
        com.sgs.portlet.document.model.PmlStateDepartment pmlStateDepartment)
        throws com.liferay.portal.SystemException {
        return getService().addPmlStateDepartment(pmlStateDepartment);
    }

    public static com.sgs.portlet.document.model.PmlStateDepartment createPmlStateDepartment(
        com.sgs.portlet.document.service.persistence.PmlStateDepartmentPK pmlStateDepartmentPK) {
        return getService().createPmlStateDepartment(pmlStateDepartmentPK);
    }

    public static void deletePmlStateDepartment(
        com.sgs.portlet.document.service.persistence.PmlStateDepartmentPK pmlStateDepartmentPK)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deletePmlStateDepartment(pmlStateDepartmentPK);
    }

    public static void deletePmlStateDepartment(
        com.sgs.portlet.document.model.PmlStateDepartment pmlStateDepartment)
        throws com.liferay.portal.SystemException {
        getService().deletePmlStateDepartment(pmlStateDepartment);
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

    public static com.sgs.portlet.document.model.PmlStateDepartment getPmlStateDepartment(
        com.sgs.portlet.document.service.persistence.PmlStateDepartmentPK pmlStateDepartmentPK)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getPmlStateDepartment(pmlStateDepartmentPK);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlStateDepartment> getPmlStateDepartments(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getPmlStateDepartments(start, end);
    }

    public static int getPmlStateDepartmentsCount()
        throws com.liferay.portal.SystemException {
        return getService().getPmlStateDepartmentsCount();
    }

    public static com.sgs.portlet.document.model.PmlStateDepartment updatePmlStateDepartment(
        com.sgs.portlet.document.model.PmlStateDepartment pmlStateDepartment)
        throws com.liferay.portal.SystemException {
        return getService().updatePmlStateDepartment(pmlStateDepartment);
    }

    public static PmlStateDepartmentLocalService getService() {
        if (_service == null) {
            throw new RuntimeException(
                "PmlStateDepartmentLocalService is not set");
        }

        return _service;
    }

    public void setService(PmlStateDepartmentLocalService service) {
        _service = service;
    }
}
