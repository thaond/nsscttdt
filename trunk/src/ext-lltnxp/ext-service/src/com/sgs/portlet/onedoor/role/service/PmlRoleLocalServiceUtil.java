package com.sgs.portlet.onedoor.role.service;


/**
 * <a href="PmlRoleLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.sgs.portlet.onedoor.role.service.PmlRoleLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.onedoor.role.service.PmlRoleLocalService
 *
 */
public class PmlRoleLocalServiceUtil {
    private static PmlRoleLocalService _service;

    public static com.sgs.portlet.onedoor.role.model.PmlRole addPmlRole(
        com.sgs.portlet.onedoor.role.model.PmlRole pmlRole)
        throws com.liferay.portal.SystemException {
        return getService().addPmlRole(pmlRole);
    }

    public static com.sgs.portlet.onedoor.role.model.PmlRole createPmlRole(
        java.lang.String roleId) {
        return getService().createPmlRole(roleId);
    }

    public static void deletePmlRole(java.lang.String roleId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deletePmlRole(roleId);
    }

    public static void deletePmlRole(
        com.sgs.portlet.onedoor.role.model.PmlRole pmlRole)
        throws com.liferay.portal.SystemException {
        getService().deletePmlRole(pmlRole);
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

    public static com.sgs.portlet.onedoor.role.model.PmlRole getPmlRole(
        java.lang.String roleId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getPmlRole(roleId);
    }

    public static java.util.List<com.sgs.portlet.onedoor.role.model.PmlRole> getPmlRoles(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getPmlRoles(start, end);
    }

    public static int getPmlRolesCount()
        throws com.liferay.portal.SystemException {
        return getService().getPmlRolesCount();
    }

    public static com.sgs.portlet.onedoor.role.model.PmlRole updatePmlRole(
        com.sgs.portlet.onedoor.role.model.PmlRole pmlRole)
        throws com.liferay.portal.SystemException {
        return getService().updatePmlRole(pmlRole);
    }

    public static PmlRoleLocalService getService() {
        if (_service == null) {
            throw new RuntimeException("PmlRoleLocalService is not set");
        }

        return _service;
    }

    public void setService(PmlRoleLocalService service) {
        _service = service;
    }
}
