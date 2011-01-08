package com.sgs.portlet.onedoor.service.persistence;

public class PmlTeamUtil {
    private static PmlTeamPersistence _persistence;

    public static com.sgs.portlet.onedoor.model.PmlTeam create(long teamId) {
        return getPersistence().create(teamId);
    }

    public static com.sgs.portlet.onedoor.model.PmlTeam remove(long teamId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlTeamException {
        return getPersistence().remove(teamId);
    }

    public static com.sgs.portlet.onedoor.model.PmlTeam remove(
        com.sgs.portlet.onedoor.model.PmlTeam pmlTeam)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(pmlTeam);
    }

    /**
     * @deprecated Use <code>update(PmlTeam pmlTeam, boolean merge)</code>.
     */
    public static com.sgs.portlet.onedoor.model.PmlTeam update(
        com.sgs.portlet.onedoor.model.PmlTeam pmlTeam)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(pmlTeam);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlTeam the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlTeam is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public static com.sgs.portlet.onedoor.model.PmlTeam update(
        com.sgs.portlet.onedoor.model.PmlTeam pmlTeam, boolean merge)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(pmlTeam, merge);
    }

    public static com.sgs.portlet.onedoor.model.PmlTeam updateImpl(
        com.sgs.portlet.onedoor.model.PmlTeam pmlTeam, boolean merge)
        throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(pmlTeam, merge);
    }

    public static com.sgs.portlet.onedoor.model.PmlTeam findByPrimaryKey(
        long teamId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlTeamException {
        return getPersistence().findByPrimaryKey(teamId);
    }

    public static com.sgs.portlet.onedoor.model.PmlTeam fetchByPrimaryKey(
        long teamId) throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(teamId);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlTeam> findByDepartmentId_TeamCode(
        java.lang.String departmentId, java.lang.String teamCode)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDepartmentId_TeamCode(departmentId, teamCode);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlTeam> findByDepartmentId_TeamCode(
        java.lang.String departmentId, java.lang.String teamCode, int start,
        int end) throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDepartmentId_TeamCode(departmentId, teamCode, start,
            end);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlTeam> findByDepartmentId_TeamCode(
        java.lang.String departmentId, java.lang.String teamCode, int start,
        int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDepartmentId_TeamCode(departmentId, teamCode, start,
            end, obc);
    }

    public static com.sgs.portlet.onedoor.model.PmlTeam findByDepartmentId_TeamCode_First(
        java.lang.String departmentId, java.lang.String teamCode,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlTeamException {
        return getPersistence()
                   .findByDepartmentId_TeamCode_First(departmentId, teamCode,
            obc);
    }

    public static com.sgs.portlet.onedoor.model.PmlTeam findByDepartmentId_TeamCode_Last(
        java.lang.String departmentId, java.lang.String teamCode,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlTeamException {
        return getPersistence()
                   .findByDepartmentId_TeamCode_Last(departmentId, teamCode, obc);
    }

    public static com.sgs.portlet.onedoor.model.PmlTeam[] findByDepartmentId_TeamCode_PrevAndNext(
        long teamId, java.lang.String departmentId, java.lang.String teamCode,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlTeamException {
        return getPersistence()
                   .findByDepartmentId_TeamCode_PrevAndNext(teamId,
            departmentId, teamCode, obc);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlTeam> findByDepartmentId(
        java.lang.String departmentId)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByDepartmentId(departmentId);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlTeam> findByDepartmentId(
        java.lang.String departmentId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByDepartmentId(departmentId, start, end);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlTeam> findByDepartmentId(
        java.lang.String departmentId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByDepartmentId(departmentId, start, end, obc);
    }

    public static com.sgs.portlet.onedoor.model.PmlTeam findByDepartmentId_First(
        java.lang.String departmentId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlTeamException {
        return getPersistence().findByDepartmentId_First(departmentId, obc);
    }

    public static com.sgs.portlet.onedoor.model.PmlTeam findByDepartmentId_Last(
        java.lang.String departmentId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlTeamException {
        return getPersistence().findByDepartmentId_Last(departmentId, obc);
    }

    public static com.sgs.portlet.onedoor.model.PmlTeam[] findByDepartmentId_PrevAndNext(
        long teamId, java.lang.String departmentId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlTeamException {
        return getPersistence()
                   .findByDepartmentId_PrevAndNext(teamId, departmentId, obc);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlTeam> findByTeamCode(
        java.lang.String teamCode) throws com.liferay.portal.SystemException {
        return getPersistence().findByTeamCode(teamCode);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlTeam> findByTeamCode(
        java.lang.String teamCode, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByTeamCode(teamCode, start, end);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlTeam> findByTeamCode(
        java.lang.String teamCode, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByTeamCode(teamCode, start, end, obc);
    }

    public static com.sgs.portlet.onedoor.model.PmlTeam findByTeamCode_First(
        java.lang.String teamCode,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlTeamException {
        return getPersistence().findByTeamCode_First(teamCode, obc);
    }

    public static com.sgs.portlet.onedoor.model.PmlTeam findByTeamCode_Last(
        java.lang.String teamCode,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlTeamException {
        return getPersistence().findByTeamCode_Last(teamCode, obc);
    }

    public static com.sgs.portlet.onedoor.model.PmlTeam[] findByTeamCode_PrevAndNext(
        long teamId, java.lang.String teamCode,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlTeamException {
        return getPersistence().findByTeamCode_PrevAndNext(teamId, teamCode, obc);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlTeam> findByTeamName(
        java.lang.String teamName) throws com.liferay.portal.SystemException {
        return getPersistence().findByTeamName(teamName);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlTeam> findByTeamName(
        java.lang.String teamName, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByTeamName(teamName, start, end);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlTeam> findByTeamName(
        java.lang.String teamName, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByTeamName(teamName, start, end, obc);
    }

    public static com.sgs.portlet.onedoor.model.PmlTeam findByTeamName_First(
        java.lang.String teamName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlTeamException {
        return getPersistence().findByTeamName_First(teamName, obc);
    }

    public static com.sgs.portlet.onedoor.model.PmlTeam findByTeamName_Last(
        java.lang.String teamName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlTeamException {
        return getPersistence().findByTeamName_Last(teamName, obc);
    }

    public static com.sgs.portlet.onedoor.model.PmlTeam[] findByTeamName_PrevAndNext(
        long teamId, java.lang.String teamName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlTeamException {
        return getPersistence().findByTeamName_PrevAndNext(teamId, teamName, obc);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlTeam> findByOrganizationId(
        long organizationId) throws com.liferay.portal.SystemException {
        return getPersistence().findByOrganizationId(organizationId);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlTeam> findByOrganizationId(
        long organizationId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByOrganizationId(organizationId, start, end);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlTeam> findByOrganizationId(
        long organizationId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByOrganizationId(organizationId, start, end, obc);
    }

    public static com.sgs.portlet.onedoor.model.PmlTeam findByOrganizationId_First(
        long organizationId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlTeamException {
        return getPersistence().findByOrganizationId_First(organizationId, obc);
    }

    public static com.sgs.portlet.onedoor.model.PmlTeam findByOrganizationId_Last(
        long organizationId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlTeamException {
        return getPersistence().findByOrganizationId_Last(organizationId, obc);
    }

    public static com.sgs.portlet.onedoor.model.PmlTeam[] findByOrganizationId_PrevAndNext(
        long teamId, long organizationId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlTeamException {
        return getPersistence()
                   .findByOrganizationId_PrevAndNext(teamId, organizationId, obc);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlTeam> findByCompanyId(
        long companyId) throws com.liferay.portal.SystemException {
        return getPersistence().findByCompanyId(companyId);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlTeam> findByCompanyId(
        long companyId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByCompanyId(companyId, start, end);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlTeam> findByCompanyId(
        long companyId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByCompanyId(companyId, start, end, obc);
    }

    public static com.sgs.portlet.onedoor.model.PmlTeam findByCompanyId_First(
        long companyId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlTeamException {
        return getPersistence().findByCompanyId_First(companyId, obc);
    }

    public static com.sgs.portlet.onedoor.model.PmlTeam findByCompanyId_Last(
        long companyId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlTeamException {
        return getPersistence().findByCompanyId_Last(companyId, obc);
    }

    public static com.sgs.portlet.onedoor.model.PmlTeam[] findByCompanyId_PrevAndNext(
        long teamId, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlTeamException {
        return getPersistence()
                   .findByCompanyId_PrevAndNext(teamId, companyId, obc);
    }

    public static java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    public static java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlTeam> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlTeam> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlTeam> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end, obc);
    }

    public static void removeByDepartmentId_TeamCode(
        java.lang.String departmentId, java.lang.String teamCode)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByDepartmentId_TeamCode(departmentId, teamCode);
    }

    public static void removeByDepartmentId(java.lang.String departmentId)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByDepartmentId(departmentId);
    }

    public static void removeByTeamCode(java.lang.String teamCode)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByTeamCode(teamCode);
    }

    public static void removeByTeamName(java.lang.String teamName)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByTeamName(teamName);
    }

    public static void removeByOrganizationId(long organizationId)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByOrganizationId(organizationId);
    }

    public static void removeByCompanyId(long companyId)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByCompanyId(companyId);
    }

    public static void removeAll() throws com.liferay.portal.SystemException {
        getPersistence().removeAll();
    }

    public static int countByDepartmentId_TeamCode(
        java.lang.String departmentId, java.lang.String teamCode)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .countByDepartmentId_TeamCode(departmentId, teamCode);
    }

    public static int countByDepartmentId(java.lang.String departmentId)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByDepartmentId(departmentId);
    }

    public static int countByTeamCode(java.lang.String teamCode)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByTeamCode(teamCode);
    }

    public static int countByTeamName(java.lang.String teamName)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByTeamName(teamName);
    }

    public static int countByOrganizationId(long organizationId)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByOrganizationId(organizationId);
    }

    public static int countByCompanyId(long companyId)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByCompanyId(companyId);
    }

    public static int countAll() throws com.liferay.portal.SystemException {
        return getPersistence().countAll();
    }

    public static void registerListener(
        com.liferay.portal.model.ModelListener listener) {
        getPersistence().registerListener(listener);
    }

    public static void unregisterListener(
        com.liferay.portal.model.ModelListener listener) {
        getPersistence().unregisterListener(listener);
    }

    public static PmlTeamPersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(PmlTeamPersistence persistence) {
        _persistence = persistence;
    }
}
