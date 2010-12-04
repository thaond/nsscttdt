package com.nss.portlet.department.service;


/**
 * <a href="PmlUserLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.nss.portlet.department.service.PmlUserLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.department.service.PmlUserLocalService
 *
 */
public class PmlUserLocalServiceUtil {
    private static PmlUserLocalService _service;

    public static com.nss.portlet.department.model.PmlUser addPmlUser(
        com.nss.portlet.department.model.PmlUser pmlUser)
        throws com.liferay.portal.SystemException {
        return getService().addPmlUser(pmlUser);
    }

    public static com.nss.portlet.department.model.PmlUser createPmlUser(
        long userId) {
        return getService().createPmlUser(userId);
    }

    public static void deletePmlUser(long userId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deletePmlUser(userId);
    }

    public static void deletePmlUser(
        com.nss.portlet.department.model.PmlUser pmlUser)
        throws com.liferay.portal.SystemException {
        getService().deletePmlUser(pmlUser);
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

    public static com.nss.portlet.department.model.PmlUser getPmlUser(
        long userId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getPmlUser(userId);
    }

    public static java.util.List<com.nss.portlet.department.model.PmlUser> getPmlUsers(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getPmlUsers(start, end);
    }

    public static int getPmlUsersCount()
        throws com.liferay.portal.SystemException {
        return getService().getPmlUsersCount();
    }

    public static com.nss.portlet.department.model.PmlUser updatePmlUser(
        com.nss.portlet.department.model.PmlUser pmlUser)
        throws com.liferay.portal.SystemException {
        return getService().updatePmlUser(pmlUser);
    }

    public static com.nss.portlet.department.model.PmlUser updatePmlUser(
        com.nss.portlet.department.model.PmlUser pmlUser, boolean merge)
        throws com.liferay.portal.SystemException {
        return getService().updatePmlUser(pmlUser, merge);
    }

    public static java.util.List<com.nss.portlet.department.model.PmlUser> findByPositionId(
        java.lang.String positionId) throws com.liferay.portal.SystemException {
        return getService().findByPositionId(positionId);
    }

    public static java.util.List<com.nss.portlet.department.model.PmlUser> findUserListByDepartment(
        java.lang.String departmentsId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getService().findUserListByDepartment(departmentsId, start, end);
    }

    public static int countUserListByDepartment(java.lang.String departmentsId)
        throws java.lang.Exception {
        return getService().countUserListByDepartment(departmentsId);
    }

    public static java.util.List<com.nss.portlet.department.model.PmlUser> findByDepartmentsId_Active(
        java.lang.String departmentsId, boolean active)
        throws com.liferay.portal.SystemException {
        return getService().findByDepartmentsId_Active(departmentsId, active);
    }

    public static java.util.List<com.nss.portlet.department.model.PmlUser> findByDepartmentsId(
        java.lang.String departmentsId)
        throws com.liferay.portal.SystemException {
        return getService().findByDepartmentsId(departmentsId);
    }

    public static PmlUserLocalService getService() {
        if (_service == null) {
            throw new RuntimeException("PmlUserLocalService is not set");
        }

        return _service;
    }

    public void setService(PmlUserLocalService service) {
        _service = service;
    }
}
