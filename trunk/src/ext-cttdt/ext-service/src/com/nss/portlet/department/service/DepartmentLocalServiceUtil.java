package com.nss.portlet.department.service;


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
 * <code>com.nss.portlet.department.service.DepartmentLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.department.service.DepartmentLocalService
 *
 */
public class DepartmentLocalServiceUtil {
    private static DepartmentLocalService _service;

    public static com.nss.portlet.department.model.Department addDepartment(
        com.nss.portlet.department.model.Department department)
        throws com.liferay.portal.SystemException {
        return getService().addDepartment(department);
    }

    public static com.nss.portlet.department.model.Department createDepartment(
        java.lang.String departmentsId) {
        return getService().createDepartment(departmentsId);
    }

    public static void deleteDepartment(java.lang.String departmentsId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deleteDepartment(departmentsId);
    }

    public static void deleteDepartment(
        com.nss.portlet.department.model.Department department)
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

    public static com.nss.portlet.department.model.Department getDepartment(
        java.lang.String departmentsId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getDepartment(departmentsId);
    }

    public static java.util.List<com.nss.portlet.department.model.Department> getDepartments(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getDepartments(start, end);
    }

    public static int getDepartmentsCount()
        throws com.liferay.portal.SystemException {
        return getService().getDepartmentsCount();
    }

    public static com.nss.portlet.department.model.Department updateDepartment(
        com.nss.portlet.department.model.Department department)
        throws com.liferay.portal.SystemException {
        return getService().updateDepartment(department);
    }

    public static com.nss.portlet.department.model.Department updateDepartment(
        com.nss.portlet.department.model.Department department, boolean merge)
        throws com.liferay.portal.SystemException {
        return getService().updateDepartment(department, merge);
    }

    public static java.util.List<com.nss.portlet.department.model.Department> findDepartmentsByDepartmentParentId()
        throws com.liferay.portal.SystemException {
        return getService().findDepartmentsByDepartmentParentId();
    }

    public static java.util.List<com.nss.portlet.department.model.Department> findByAgencyId(
        java.lang.String agencyId) throws com.liferay.portal.SystemException {
        return getService().findByAgencyId(agencyId);
    }

    public static int searchCount(java.lang.String keywords)
        throws com.liferay.portal.SystemException {
        return getService().searchCount(keywords);
    }

    public static int searchCount(java.lang.String pmlDepartmentCode,
        java.lang.String pmlDepartmentName,
        java.lang.String pmlDepartmentAbbreviateName, boolean andOperator)
        throws com.liferay.portal.SystemException {
        return getService()
                   .searchCount(pmlDepartmentCode, pmlDepartmentName,
            pmlDepartmentAbbreviateName, andOperator);
    }

    public static java.util.List<com.nss.portlet.department.model.Department> search(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService().search(keywords, start, end, obc);
    }

    public static java.util.List<com.nss.portlet.department.model.Department> search(
        java.lang.String pmlDepartmentCode, java.lang.String pmlDepartmentName,
        java.lang.String pmlDepartmentAbbreviateName, boolean andOperator,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService()
                   .search(pmlDepartmentCode, pmlDepartmentName,
            pmlDepartmentAbbreviateName, andOperator, start, end, obc);
    }

    public static com.nss.portlet.department.model.Department addDepartment(
        java.lang.String departmentsCode, java.lang.String departmentsName,
        java.lang.String description, java.lang.String active,
        java.lang.String agencyId, java.lang.String abbreviateName,
        java.lang.String departmentsParentId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService()
                   .addDepartment(departmentsCode, departmentsName,
            description, active, agencyId, abbreviateName, departmentsParentId);
    }

    public static void removeDepartment(java.lang.String departmentId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().removeDepartment(departmentId);
    }

    public static java.util.List<com.nss.portlet.department.model.Department> findByDepartmentsCode(
        java.lang.String departmentCode)
        throws com.liferay.portal.SystemException {
        return getService().findByDepartmentsCode(departmentCode);
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
