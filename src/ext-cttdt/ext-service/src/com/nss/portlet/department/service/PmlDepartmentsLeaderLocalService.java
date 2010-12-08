package com.nss.portlet.department.service;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.Isolation;
import com.liferay.portal.kernel.annotation.Propagation;
import com.liferay.portal.kernel.annotation.Transactional;


/**
 * <a href="PmlDepartmentsLeaderLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.nss.portlet.department.service.impl.PmlDepartmentsLeaderLocalServiceImpl</code>.
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
 * @see com.nss.portlet.department.service.PmlDepartmentsLeaderLocalServiceUtil
 *
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
    PortalException.class, SystemException.class}
)
public interface PmlDepartmentsLeaderLocalService {
    public com.nss.portlet.department.model.PmlDepartmentsLeader addPmlDepartmentsLeader(
        com.nss.portlet.department.model.PmlDepartmentsLeader pmlDepartmentsLeader)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.department.model.PmlDepartmentsLeader createPmlDepartmentsLeader(
        com.nss.portlet.department.service.persistence.PmlDepartmentsLeaderPK pmlDepartmentsLeaderPK);

    public void deletePmlDepartmentsLeader(
        com.nss.portlet.department.service.persistence.PmlDepartmentsLeaderPK pmlDepartmentsLeaderPK)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deletePmlDepartmentsLeader(
        com.nss.portlet.department.model.PmlDepartmentsLeader pmlDepartmentsLeader)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.nss.portlet.department.model.PmlDepartmentsLeader getPmlDepartmentsLeader(
        com.nss.portlet.department.service.persistence.PmlDepartmentsLeaderPK pmlDepartmentsLeaderPK)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.nss.portlet.department.model.PmlDepartmentsLeader> getPmlDepartmentsLeaders(
        int start, int end) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getPmlDepartmentsLeadersCount()
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.department.model.PmlDepartmentsLeader updatePmlDepartmentsLeader(
        com.nss.portlet.department.model.PmlDepartmentsLeader pmlDepartmentsLeader)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.department.model.PmlDepartmentsLeader updatePmlDepartmentsLeader(
        com.nss.portlet.department.model.PmlDepartmentsLeader pmlDepartmentsLeader,
        boolean merge) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.department.model.PmlDepartmentsLeader> findByDepartmentsId_UserId(
        java.lang.String departmentsId, long userId);

    public java.util.List<com.nss.portlet.department.model.PmlDepartmentsLeader> findByDepartmentsId(
        java.lang.String departmentsId)
        throws com.liferay.portal.SystemException;

    public boolean checkUserIsLeader(java.lang.String userIdString);
}
