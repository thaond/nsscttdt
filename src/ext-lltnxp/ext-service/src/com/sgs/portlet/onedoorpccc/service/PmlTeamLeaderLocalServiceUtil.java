package com.sgs.portlet.onedoorpccc.service;


/**
 * <a href="PmlTeamLeaderLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.sgs.portlet.onedoorpccc.service.PmlTeamLeaderLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.onedoorpccc.service.PmlTeamLeaderLocalService
 *
 */
public class PmlTeamLeaderLocalServiceUtil {
    private static PmlTeamLeaderLocalService _service;

    public static com.sgs.portlet.onedoorpccc.model.PmlTeamLeader addPmlTeamLeader(
        com.sgs.portlet.onedoorpccc.model.PmlTeamLeader pmlTeamLeader)
        throws com.liferay.portal.SystemException {
        return getService().addPmlTeamLeader(pmlTeamLeader);
    }

    public static com.sgs.portlet.onedoorpccc.model.PmlTeamLeader createPmlTeamLeader(
        long teamId) {
        return getService().createPmlTeamLeader(teamId);
    }

    public static void deletePmlTeamLeader(long teamId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deletePmlTeamLeader(teamId);
    }

    public static void deletePmlTeamLeader(
        com.sgs.portlet.onedoorpccc.model.PmlTeamLeader pmlTeamLeader)
        throws com.liferay.portal.SystemException {
        getService().deletePmlTeamLeader(pmlTeamLeader);
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

    public static com.sgs.portlet.onedoorpccc.model.PmlTeamLeader getPmlTeamLeader(
        long teamId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getPmlTeamLeader(teamId);
    }

    public static java.util.List<com.sgs.portlet.onedoorpccc.model.PmlTeamLeader> getPmlTeamLeaders(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getPmlTeamLeaders(start, end);
    }

    public static int getPmlTeamLeadersCount()
        throws com.liferay.portal.SystemException {
        return getService().getPmlTeamLeadersCount();
    }

    public static com.sgs.portlet.onedoorpccc.model.PmlTeamLeader updatePmlTeamLeader(
        com.sgs.portlet.onedoorpccc.model.PmlTeamLeader pmlTeamLeader)
        throws com.liferay.portal.SystemException {
        return getService().updatePmlTeamLeader(pmlTeamLeader);
    }

    public static PmlTeamLeaderLocalService getService() {
        if (_service == null) {
            throw new RuntimeException("PmlTeamLeaderLocalService is not set");
        }

        return _service;
    }

    public void setService(PmlTeamLeaderLocalService service) {
        _service = service;
    }
}
