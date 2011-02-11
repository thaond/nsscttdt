package com.sgs.portlet.onedoor.service;


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
 * <code>com.sgs.portlet.onedoor.service.PmlDepartmentsLeaderLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.onedoor.service.PmlDepartmentsLeaderLocalService
 *
 */
public class PmlDepartmentsLeaderLocalServiceUtil {
    private static PmlDepartmentsLeaderLocalService _service;

    public static com.sgs.portlet.onedoor.model.PmlDepartmentsLeader addPmlDepartmentsLeader(
        com.sgs.portlet.onedoor.model.PmlDepartmentsLeader pmlDepartmentsLeader)
        throws com.liferay.portal.SystemException {
        return getService().addPmlDepartmentsLeader(pmlDepartmentsLeader);
    }

    public static com.sgs.portlet.onedoor.model.PmlDepartmentsLeader createPmlDepartmentsLeader(
        com.sgs.portlet.onedoor.service.persistence.PmlDepartmentsLeaderPK pmlDepartmentsLeaderPK) {
        return getService().createPmlDepartmentsLeader(pmlDepartmentsLeaderPK);
    }

    public static void deletePmlDepartmentsLeader(
        com.sgs.portlet.onedoor.service.persistence.PmlDepartmentsLeaderPK pmlDepartmentsLeaderPK)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deletePmlDepartmentsLeader(pmlDepartmentsLeaderPK);
    }

    public static void deletePmlDepartmentsLeader(
        com.sgs.portlet.onedoor.model.PmlDepartmentsLeader pmlDepartmentsLeader)
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

    public static com.sgs.portlet.onedoor.model.PmlDepartmentsLeader getPmlDepartmentsLeader(
        com.sgs.portlet.onedoor.service.persistence.PmlDepartmentsLeaderPK pmlDepartmentsLeaderPK)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getPmlDepartmentsLeader(pmlDepartmentsLeaderPK);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlDepartmentsLeader> getPmlDepartmentsLeaders(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getPmlDepartmentsLeaders(start, end);
    }

    public static int getPmlDepartmentsLeadersCount()
        throws com.liferay.portal.SystemException {
        return getService().getPmlDepartmentsLeadersCount();
    }

    public static com.sgs.portlet.onedoor.model.PmlDepartmentsLeader updatePmlDepartmentsLeader(
        com.sgs.portlet.onedoor.model.PmlDepartmentsLeader pmlDepartmentsLeader)
        throws com.liferay.portal.SystemException {
        return getService().updatePmlDepartmentsLeader(pmlDepartmentsLeader);
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
