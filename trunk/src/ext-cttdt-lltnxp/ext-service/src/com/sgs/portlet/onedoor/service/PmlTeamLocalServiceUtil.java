package com.sgs.portlet.onedoor.service;


/**
 * <a href="PmlTeamLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.sgs.portlet.onedoor.service.PmlTeamLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.onedoor.service.PmlTeamLocalService
 *
 */
public class PmlTeamLocalServiceUtil {
    private static PmlTeamLocalService _service;

    public static com.sgs.portlet.onedoor.model.PmlTeam addPmlTeam(
        com.sgs.portlet.onedoor.model.PmlTeam pmlTeam)
        throws com.liferay.portal.SystemException {
        return getService().addPmlTeam(pmlTeam);
    }

    public static com.sgs.portlet.onedoor.model.PmlTeam createPmlTeam(
        long teamId) {
        return getService().createPmlTeam(teamId);
    }

    public static void deletePmlTeam(long teamId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deletePmlTeam(teamId);
    }

    public static void deletePmlTeam(
        com.sgs.portlet.onedoor.model.PmlTeam pmlTeam)
        throws com.liferay.portal.SystemException {
        getService().deletePmlTeam(pmlTeam);
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

    public static com.sgs.portlet.onedoor.model.PmlTeam getPmlTeam(long teamId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getPmlTeam(teamId);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlTeam> getPmlTeams(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getPmlTeams(start, end);
    }

    public static int getPmlTeamsCount()
        throws com.liferay.portal.SystemException {
        return getService().getPmlTeamsCount();
    }

    public static com.sgs.portlet.onedoor.model.PmlTeam updatePmlTeam(
        com.sgs.portlet.onedoor.model.PmlTeam pmlTeam)
        throws com.liferay.portal.SystemException {
        return getService().updatePmlTeam(pmlTeam);
    }

    public static com.sgs.portlet.onedoor.model.PmlTeam getTeamByDepartmentId_TeamCode(
        java.lang.String departmentId, java.lang.String teamCode) {
        return getService()
                   .getTeamByDepartmentId_TeamCode(departmentId, teamCode);
    }

    public static com.sgs.portlet.pmluser.model.PmlUser getTeamLeaderByDepartmentCode_TeamCode(
        java.lang.String departmentCode, java.lang.String teamCode) {
        return getService()
                   .getTeamLeaderByDepartmentCode_TeamCode(departmentCode,
            teamCode);
    }

    public static java.util.List<com.sgs.portlet.pmluser.model.PmlUser> getTeamMembersByDepartmentCode_TeamCode(
        java.lang.String departmentCode, java.lang.String teamCode) {
        return getService()
                   .getTeamMembersByDepartmentCode_TeamCode(departmentCode,
            teamCode);
    }

    public static PmlTeamLocalService getService() {
        if (_service == null) {
            throw new RuntimeException("PmlTeamLocalService is not set");
        }

        return _service;
    }

    public void setService(PmlTeamLocalService service) {
        _service = service;
    }
}
