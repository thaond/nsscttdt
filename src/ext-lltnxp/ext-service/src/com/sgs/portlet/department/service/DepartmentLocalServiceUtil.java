package com.sgs.portlet.department.service;


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
 * <code>com.sgs.portlet.department.service.DepartmentLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.department.service.DepartmentLocalService
 *
 */
public class DepartmentLocalServiceUtil {
    private static DepartmentLocalService _service;

    public static com.sgs.portlet.department.model.Department addDepartment(
        com.sgs.portlet.department.model.Department department)
        throws com.liferay.portal.SystemException {
        return getService().addDepartment(department);
    }

    public static com.sgs.portlet.department.model.Department createDepartment(
        java.lang.String departmentsId) {
        return getService().createDepartment(departmentsId);
    }

    public static void deleteDepartment(java.lang.String departmentsId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deleteDepartment(departmentsId);
    }

    public static void deleteDepartment(
        com.sgs.portlet.department.model.Department department)
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

    public static com.sgs.portlet.department.model.Department getDepartment(
        java.lang.String departmentsId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getDepartment(departmentsId);
    }

    public static java.util.List<com.sgs.portlet.department.model.Department> getDepartments(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getDepartments(start, end);
    }

    public static int getDepartmentsCount()
        throws com.liferay.portal.SystemException {
        return getService().getDepartmentsCount();
    }

    public static com.sgs.portlet.department.model.Department updateDepartment(
        com.sgs.portlet.department.model.Department department)
        throws com.liferay.portal.SystemException {
        return getService().updateDepartment(department);
    }

    public static java.util.List<com.sgs.portlet.department.model.Department> findAll()
        throws com.liferay.portal.SystemException {
        return getService().findAll();
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

    public static java.util.List<com.sgs.portlet.department.model.Department> search(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService().search(keywords, start, end, obc);
    }

    public static java.util.List<com.sgs.portlet.department.model.Department> search(
        java.lang.String pmlDepartmentCode, java.lang.String pmlDepartmentName,
        java.lang.String pmlDepartmentAbbreviateName, boolean andOperator,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService()
                   .search(pmlDepartmentCode, pmlDepartmentName,
            pmlDepartmentAbbreviateName, andOperator, start, end, obc);
    }

    public static java.util.List<com.sgs.portlet.department.model.Department> findDepartments(
        java.lang.String departmentsId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService().findDepartments(departmentsId, start, end, obc);
    }

    public static int countDepartments(java.lang.String departmentsId)
        throws com.liferay.portal.SystemException {
        return getService().countDepartments(departmentsId);
    }

    public static java.util.List<com.sgs.portlet.department.model.Department> findDepartmentsByDepartmentParentId()
        throws com.liferay.portal.SystemException {
        return getService().findDepartmentsByDepartmentParentId();
    }

    public static com.sgs.portlet.department.model.Department getDepartmentByCode(
        java.lang.String departmentCode) {
        return getService().getDepartmentByCode(departmentCode);
    }

    public static java.util.List<com.sgs.portlet.filetype.model.PmlFileType> getListFileTypeByDepartment(
        java.lang.String departmentId, java.util.Date date) {
        return getService().getListFileTypeByDepartment(departmentId, date);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> getListFileByDepartment_FileType(
        java.lang.String departmentId, java.lang.String fileTypeId,
        java.util.Date date) {
        return getService()
                   .getListFileByDepartment_FileType(departmentId, fileTypeId,
            date);
    }

    public static java.util.List<com.sgs.portlet.department.model.Department> findDepartmentsByDepartmentParentId(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().findDepartmentsByDepartmentParentId(start, end);
    }

    public static int countTinhHinhThuLyCongVanPhongBan()
        throws java.lang.Exception {
        return getService().countTinhHinhThuLyCongVanPhongBan();
    }

    public static void removeDepartment(java.lang.String departmentId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().removeDepartment(departmentId);
    }

    public static com.sgs.portlet.department.model.Department addDepartment(
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
