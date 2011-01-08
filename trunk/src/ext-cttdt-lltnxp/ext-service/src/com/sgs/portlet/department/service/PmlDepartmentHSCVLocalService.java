package com.sgs.portlet.department.service;


/**
 * <a href="PmlDepartmentHSCVLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.sgs.portlet.department.service.impl.PmlDepartmentHSCVLocalServiceImpl</code>.
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
 * @see com.sgs.portlet.department.service.PmlDepartmentHSCVLocalServiceUtil
 *
 */
public interface PmlDepartmentHSCVLocalService {
    public com.sgs.portlet.department.model.PmlDepartmentHSCV addPmlDepartmentHSCV(
        com.sgs.portlet.department.model.PmlDepartmentHSCV pmlDepartmentHSCV)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.department.model.PmlDepartmentHSCV createPmlDepartmentHSCV(
        long pmlDepartmentHSCVId);

    public void deletePmlDepartmentHSCV(long pmlDepartmentHSCVId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deletePmlDepartmentHSCV(
        com.sgs.portlet.department.model.PmlDepartmentHSCV pmlDepartmentHSCV)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.department.model.PmlDepartmentHSCV getPmlDepartmentHSCV(
        long pmlDepartmentHSCVId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public java.util.List<com.sgs.portlet.department.model.PmlDepartmentHSCV> getPmlDepartmentHSCVs(
        int start, int end) throws com.liferay.portal.SystemException;

    public int getPmlDepartmentHSCVsCount()
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.department.model.PmlDepartmentHSCV updatePmlDepartmentHSCV(
        com.sgs.portlet.department.model.PmlDepartmentHSCV pmlDepartmentHSCV)
        throws com.liferay.portal.SystemException;
}
