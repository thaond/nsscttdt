package com.sgs.portlet.onedoor.service;


/**
 * <a href="PmlTeamLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.sgs.portlet.onedoor.service.impl.PmlTeamLocalServiceImpl</code>.
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
 * @see com.sgs.portlet.onedoor.service.PmlTeamLocalServiceUtil
 *
 */
public interface PmlTeamLocalService {
    public com.sgs.portlet.onedoor.model.PmlTeam addPmlTeam(
        com.sgs.portlet.onedoor.model.PmlTeam pmlTeam)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.onedoor.model.PmlTeam createPmlTeam(long teamId);

    public void deletePmlTeam(long teamId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deletePmlTeam(com.sgs.portlet.onedoor.model.PmlTeam pmlTeam)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.onedoor.model.PmlTeam getPmlTeam(long teamId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlTeam> getPmlTeams(
        int start, int end) throws com.liferay.portal.SystemException;

    public int getPmlTeamsCount() throws com.liferay.portal.SystemException;

    public com.sgs.portlet.onedoor.model.PmlTeam updatePmlTeam(
        com.sgs.portlet.onedoor.model.PmlTeam pmlTeam)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.onedoor.model.PmlTeam getTeamByDepartmentId_TeamCode(
        java.lang.String departmentId, java.lang.String teamCode);

    public com.sgs.portlet.pmluser.model.PmlUser getTeamLeaderByDepartmentCode_TeamCode(
        java.lang.String departmentCode, java.lang.String teamCode);

    public java.util.List<com.sgs.portlet.pmluser.model.PmlUser> getTeamMembersByDepartmentCode_TeamCode(
        java.lang.String departmentCode, java.lang.String teamCode);
}
