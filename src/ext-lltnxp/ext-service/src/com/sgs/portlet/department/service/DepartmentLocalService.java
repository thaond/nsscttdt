package com.sgs.portlet.department.service;


/**
 * <a href="DepartmentLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.sgs.portlet.department.service.impl.DepartmentLocalServiceImpl</code>.
 * Modify methods in that class and rerun ServiceBuilder to populate this class
 * and all other generated classes.
 * </p>
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.department.service.DepartmentLocalServiceUtil
 *
 */
public interface DepartmentLocalService {
    public com.sgs.portlet.department.model.Department addDepartment(
        com.sgs.portlet.department.model.Department department)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.department.model.Department createDepartment(
        java.lang.String departmentsId);

    public void deleteDepartment(java.lang.String departmentsId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deleteDepartment(
        com.sgs.portlet.department.model.Department department)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.department.model.Department getDepartment(
        java.lang.String departmentsId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public java.util.List<com.sgs.portlet.department.model.Department> getDepartments(
        int start, int end) throws com.liferay.portal.SystemException;

    public int getDepartmentsCount() throws com.liferay.portal.SystemException;

    public com.sgs.portlet.department.model.Department updateDepartment(
        com.sgs.portlet.department.model.Department department)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.department.model.Department> findAll()
        throws com.liferay.portal.SystemException;

    public int searchCount(java.lang.String keywords)
        throws com.liferay.portal.SystemException;

    public int searchCount(java.lang.String pmlDepartmentCode,
        java.lang.String pmlDepartmentName,
        java.lang.String pmlDepartmentAbbreviateName, boolean andOperator)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.department.model.Department> search(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.department.model.Department> search(
        java.lang.String pmlDepartmentCode, java.lang.String pmlDepartmentName,
        java.lang.String pmlDepartmentAbbreviateName, boolean andOperator,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.department.model.Department> findDepartments(
        java.lang.String departmentsId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public int countDepartments(java.lang.String departmentsId)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.department.model.Department> findDepartmentsByDepartmentParentId()
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.department.model.Department getDepartmentByCode(
        java.lang.String departmentCode);

    public java.util.List<com.sgs.portlet.filetype.model.PmlFileType> getListFileTypeByDepartment(
        java.lang.String departmentId, java.util.Date date);

    public java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> getListFileByDepartment_FileType(
        java.lang.String departmentId, java.lang.String fileTypeId,
        java.util.Date date);

    public java.util.List<com.sgs.portlet.department.model.Department> findDepartmentsByDepartmentParentId(
        int start, int end) throws com.liferay.portal.SystemException;

    public int countTinhHinhThuLyCongVanPhongBan() throws java.lang.Exception;

    public void removeDepartment(java.lang.String departmentId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public com.sgs.portlet.department.model.Department addDepartment(
        java.lang.String departmentsCode, java.lang.String departmentsName,
        java.lang.String description, java.lang.String active,
        java.lang.String agencyId, java.lang.String abbreviateName,
        java.lang.String departmentsParentId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;
}
