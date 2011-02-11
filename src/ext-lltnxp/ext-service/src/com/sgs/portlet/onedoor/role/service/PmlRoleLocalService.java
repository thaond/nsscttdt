package com.sgs.portlet.onedoor.role.service;


/**
 * <a href="PmlRoleLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.sgs.portlet.onedoor.role.service.impl.PmlRoleLocalServiceImpl</code>.
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
 * @see com.sgs.portlet.onedoor.role.service.PmlRoleLocalServiceUtil
 *
 */
public interface PmlRoleLocalService {
    public com.sgs.portlet.onedoor.role.model.PmlRole addPmlRole(
        com.sgs.portlet.onedoor.role.model.PmlRole pmlRole)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.onedoor.role.model.PmlRole createPmlRole(
        java.lang.String roleId);

    public void deletePmlRole(java.lang.String roleId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deletePmlRole(
        com.sgs.portlet.onedoor.role.model.PmlRole pmlRole)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.onedoor.role.model.PmlRole getPmlRole(
        java.lang.String roleId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public java.util.List<com.sgs.portlet.onedoor.role.model.PmlRole> getPmlRoles(
        int start, int end) throws com.liferay.portal.SystemException;

    public int getPmlRolesCount() throws com.liferay.portal.SystemException;

    public com.sgs.portlet.onedoor.role.model.PmlRole updatePmlRole(
        com.sgs.portlet.onedoor.role.model.PmlRole pmlRole)
        throws com.liferay.portal.SystemException;
}
