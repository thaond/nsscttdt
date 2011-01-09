package com.sgs.portlet.report_registry_work.service;


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
 * <code>com.sgs.portlet.report_registry_work.service.impl.DepartmentLocalServiceImpl</code>.
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
 * @see com.sgs.portlet.report_registry_work.service.DepartmentLocalServiceUtil
 *
 */
public interface DepartmentLocalService {
    public com.sgs.portlet.report_registry_work.model.Department addDepartment(
        com.sgs.portlet.report_registry_work.model.Department department)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.report_registry_work.model.Department createDepartment(
        long departmentId);

    public void deleteDepartment(long departmentId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deleteDepartment(
        com.sgs.portlet.report_registry_work.model.Department department)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.report_registry_work.model.Department getDepartment(
        long departmentId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public java.util.List<com.sgs.portlet.report_registry_work.model.Department> getDepartments(
        int start, int end) throws com.liferay.portal.SystemException;

    public int getDepartmentsCount() throws com.liferay.portal.SystemException;

    public com.sgs.portlet.report_registry_work.model.Department updateDepartment(
        com.sgs.portlet.report_registry_work.model.Department department)
        throws com.liferay.portal.SystemException;
}
