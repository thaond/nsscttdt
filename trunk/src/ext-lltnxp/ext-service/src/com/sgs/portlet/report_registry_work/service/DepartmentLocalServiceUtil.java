package com.sgs.portlet.report_registry_work.service;


/**
 * <a href="DepartmentLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.sgs.portlet.report_registry_work.service.DepartmentLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.report_registry_work.service.DepartmentLocalService
 *
 */
public class DepartmentLocalServiceUtil {
    private static DepartmentLocalService _service;

    public static com.sgs.portlet.report_registry_work.model.Department addDepartment(
        com.sgs.portlet.report_registry_work.model.Department department)
        throws com.liferay.portal.SystemException {
        return getService().addDepartment(department);
    }

    public static com.sgs.portlet.report_registry_work.model.Department createDepartment(
        long departmentId) {
        return getService().createDepartment(departmentId);
    }

    public static void deleteDepartment(long departmentId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deleteDepartment(departmentId);
    }

    public static void deleteDepartment(
        com.sgs.portlet.report_registry_work.model.Department department)
        throws com.liferay.portal.SystemException {
        getService().deleteDepartment(department);
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

    public static com.sgs.portlet.report_registry_work.model.Department getDepartment(
        long departmentId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getDepartment(departmentId);
    }

    public static java.util.List<com.sgs.portlet.report_registry_work.model.Department> getDepartments(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getDepartments(start, end);
    }

    public static int getDepartmentsCount()
        throws com.liferay.portal.SystemException {
        return getService().getDepartmentsCount();
    }

    public static com.sgs.portlet.report_registry_work.model.Department updateDepartment(
        com.sgs.portlet.report_registry_work.model.Department department)
        throws com.liferay.portal.SystemException {
        return getService().updateDepartment(department);
    }

    public static java.util.List<com.sgs.portlet.report_registry_work.model.ReportRegistry> getReportRegistries(
        long departmentId) throws com.liferay.portal.SystemException {
        return getService().getReportRegistries(departmentId);
    }

    public static int countByKeyword(java.lang.String keywords)
        throws com.liferay.portal.SystemException {
        return getService().countByKeyword(keywords);
    }

    public static java.util.List<com.sgs.portlet.report_registry_work.model.Department> findByKeyword(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService().findByKeyword(keywords, start, end, obc);
    }

    public static int countDepartment(java.lang.String departmentCodes,
        java.lang.String departmentNames,
        java.lang.String departmentDescriptions, boolean andOperator)
        throws com.liferay.portal.SystemException {
        return getService()
                   .countDepartment(departmentCodes, departmentNames,
            departmentDescriptions, andOperator);
    }

    public static java.util.List<com.sgs.portlet.report_registry_work.model.Department> findDepartment(
        java.lang.String departmentCodes, java.lang.String departmentNames,
        java.lang.String departmentDescriptions, int start, int end,
        boolean andOperator,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService()
                   .findDepartment(departmentCodes, departmentNames,
            departmentDescriptions, start, end, andOperator, obc);
    }

    public static DepartmentLocalService getService() {
        if (_service == null) {
            throw new RuntimeException("DepartmentLocalService is not set");
        }

        return _service;
    }

    public void setService(DepartmentLocalService service) {
        _service = service;
    }
}
