package com.nss.portlet.department.service;


/**
 * <a href="PmlDepartmentsLeaderLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.nss.portlet.department.service.PmlDepartmentsLeaderLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.department.service.PmlDepartmentsLeaderLocalService
 *
 */
public class PmlDepartmentsLeaderLocalServiceUtil {
    private static PmlDepartmentsLeaderLocalService _service;

    public static com.nss.portlet.department.model.PmlDepartmentsLeader addPmlDepartmentsLeader(
        com.nss.portlet.department.model.PmlDepartmentsLeader pmlDepartmentsLeader)
        throws com.liferay.portal.SystemException {
        return getService().addPmlDepartmentsLeader(pmlDepartmentsLeader);
    }

    public static com.nss.portlet.department.model.PmlDepartmentsLeader createPmlDepartmentsLeader(
        com.nss.portlet.department.service.persistence.PmlDepartmentsLeaderPK pmlDepartmentsLeaderPK) {
        return getService().createPmlDepartmentsLeader(pmlDepartmentsLeaderPK);
    }

    public static void deletePmlDepartmentsLeader(
        com.nss.portlet.department.service.persistence.PmlDepartmentsLeaderPK pmlDepartmentsLeaderPK)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deletePmlDepartmentsLeader(pmlDepartmentsLeaderPK);
    }

    public static void deletePmlDepartmentsLeader(
        com.nss.portlet.department.model.PmlDepartmentsLeader pmlDepartmentsLeader)
        throws com.liferay.portal.SystemException {
        getService().deletePmlDepartmentsLeader(pmlDepartmentsLeader);
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

    public static com.nss.portlet.department.model.PmlDepartmentsLeader getPmlDepartmentsLeader(
        com.nss.portlet.department.service.persistence.PmlDepartmentsLeaderPK pmlDepartmentsLeaderPK)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getPmlDepartmentsLeader(pmlDepartmentsLeaderPK);
    }

    public static java.util.List<com.nss.portlet.department.model.PmlDepartmentsLeader> getPmlDepartmentsLeaders(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getPmlDepartmentsLeaders(start, end);
    }

    public static int getPmlDepartmentsLeadersCount()
        throws com.liferay.portal.SystemException {
        return getService().getPmlDepartmentsLeadersCount();
    }

    public static com.nss.portlet.department.model.PmlDepartmentsLeader updatePmlDepartmentsLeader(
        com.nss.portlet.department.model.PmlDepartmentsLeader pmlDepartmentsLeader)
        throws com.liferay.portal.SystemException {
        return getService().updatePmlDepartmentsLeader(pmlDepartmentsLeader);
    }

    public static com.nss.portlet.department.model.PmlDepartmentsLeader updatePmlDepartmentsLeader(
        com.nss.portlet.department.model.PmlDepartmentsLeader pmlDepartmentsLeader,
        boolean merge) throws com.liferay.portal.SystemException {
        return getService()
                   .updatePmlDepartmentsLeader(pmlDepartmentsLeader, merge);
    }

    public static java.util.List<com.nss.portlet.department.model.PmlDepartmentsLeader> findByDepartmentsId_UserId(
        java.lang.String departmentsId, long userId) {
        return getService().findByDepartmentsId_UserId(departmentsId, userId);
    }

    public static java.util.List<com.nss.portlet.department.model.PmlDepartmentsLeader> findByDepartmentsId(
        java.lang.String departmentsId)
        throws com.liferay.portal.SystemException {
        return getService().findByDepartmentsId(departmentsId);
    }

    public static boolean checkUserIsLeader(java.lang.String userIdString) {
        return getService().checkUserIsLeader(userIdString);
    }

    public static PmlDepartmentsLeaderLocalService getService() {
        if (_service == null) {
            throw new RuntimeException(
                "PmlDepartmentsLeaderLocalService is not set");
        }

        return _service;
    }

    public void setService(PmlDepartmentsLeaderLocalService service) {
        _service = service;
    }
}
