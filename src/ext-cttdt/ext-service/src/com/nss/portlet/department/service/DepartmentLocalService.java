package com.nss.portlet.department.service;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.Isolation;
import com.liferay.portal.kernel.annotation.Propagation;
import com.liferay.portal.kernel.annotation.Transactional;


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
 * <code>com.nss.portlet.department.service.impl.DepartmentLocalServiceImpl</code>.
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
 * @see com.nss.portlet.department.service.DepartmentLocalServiceUtil
 *
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
    PortalException.class, SystemException.class}
)
public interface DepartmentLocalService {
    public com.nss.portlet.department.model.Department addDepartment(
        com.nss.portlet.department.model.Department department)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.department.model.Department createDepartment(
        java.lang.String departmentsId);

    public void deleteDepartment(java.lang.String departmentsId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deleteDepartment(
        com.nss.portlet.department.model.Department department)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.nss.portlet.department.model.Department getDepartment(
        java.lang.String departmentsId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.nss.portlet.department.model.Department> getDepartments(
        int start, int end) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getDepartmentsCount() throws com.liferay.portal.SystemException;

    public com.nss.portlet.department.model.Department updateDepartment(
        com.nss.portlet.department.model.Department department)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.department.model.Department updateDepartment(
        com.nss.portlet.department.model.Department department, boolean merge)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.department.model.Department> findDepartmentsByDepartmentParentId()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.department.model.Department> findByAgencyId(
        java.lang.String agencyId) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int searchCount(java.lang.String keywords)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int searchCount(java.lang.String pmlDepartmentCode,
        java.lang.String pmlDepartmentName,
        java.lang.String pmlDepartmentAbbreviateName, boolean andOperator)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.nss.portlet.department.model.Department> search(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.nss.portlet.department.model.Department> search(
        java.lang.String pmlDepartmentCode, java.lang.String pmlDepartmentName,
        java.lang.String pmlDepartmentAbbreviateName, boolean andOperator,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.department.model.Department addDepartment(
        java.lang.String departmentsCode, java.lang.String departmentsName,
        java.lang.String description, java.lang.String active,
        java.lang.String agencyId, java.lang.String abbreviateName,
        java.lang.String departmentsParentId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public void removeDepartment(java.lang.String departmentId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.department.model.Department> findByDepartmentsCode(
        java.lang.String departmentCode)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.nss.portlet.department.model.Department> search(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc);
}
