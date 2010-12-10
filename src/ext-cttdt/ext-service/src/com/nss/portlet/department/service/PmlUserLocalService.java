package com.nss.portlet.department.service;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.Isolation;
import com.liferay.portal.kernel.annotation.Propagation;
import com.liferay.portal.kernel.annotation.Transactional;


/**
 * <a href="PmlUserLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.nss.portlet.department.service.impl.PmlUserLocalServiceImpl</code>.
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
 * @see com.nss.portlet.department.service.PmlUserLocalServiceUtil
 *
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
    PortalException.class, SystemException.class}
)
public interface PmlUserLocalService {
    public com.nss.portlet.department.model.PmlUser addPmlUser(
        com.nss.portlet.department.model.PmlUser pmlUser)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.department.model.PmlUser createPmlUser(long userId);

    public void deletePmlUser(long userId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deletePmlUser(com.nss.portlet.department.model.PmlUser pmlUser)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.nss.portlet.department.model.PmlUser getPmlUser(long userId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.nss.portlet.department.model.PmlUser> getPmlUsers(
        int start, int end) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getPmlUsersCount() throws com.liferay.portal.SystemException;

    public com.nss.portlet.department.model.PmlUser updatePmlUser(
        com.nss.portlet.department.model.PmlUser pmlUser)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.department.model.PmlUser updatePmlUser(
        com.nss.portlet.department.model.PmlUser pmlUser, boolean merge)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.department.model.PmlUser> findByPositionId(
        java.lang.String positionId) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.department.model.PmlUser> findUserListByDepartment(
        java.lang.String departmentsId, int start, int end)
        throws com.liferay.portal.SystemException;

    public int countUserListByDepartment(java.lang.String departmentsId)
        throws java.lang.Exception;

    public java.util.List<com.nss.portlet.department.model.PmlUser> findByDepartmentsId_Active(
        java.lang.String departmentsId, boolean active)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.department.model.PmlUser> findByDepartmentsId(
        java.lang.String departmentsId)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.lang.String getFullName(long userId);

    public java.util.List<com.liferay.portal.model.User> listUserTheoDoiHoSo(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public int countUserTheoDoiHoSo() throws com.liferay.portal.SystemException;
}
