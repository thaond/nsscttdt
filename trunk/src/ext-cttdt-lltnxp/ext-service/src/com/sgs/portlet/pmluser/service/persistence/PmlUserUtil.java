package com.sgs.portlet.pmluser.service.persistence;

public class PmlUserUtil {
    private static PmlUserPersistence _persistence;

    public static com.sgs.portlet.pmluser.model.PmlUser create(long userId) {
        return getPersistence().create(userId);
    }

    public static com.sgs.portlet.pmluser.model.PmlUser remove(long userId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pmluser.NoSuchPmlUserException {
        return getPersistence().remove(userId);
    }

    public static com.sgs.portlet.pmluser.model.PmlUser remove(
        com.sgs.portlet.pmluser.model.PmlUser pmlUser)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(pmlUser);
    }

    /**
     * @deprecated Use <code>update(PmlUser pmlUser, boolean merge)</code>.
     */
    public static com.sgs.portlet.pmluser.model.PmlUser update(
        com.sgs.portlet.pmluser.model.PmlUser pmlUser)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(pmlUser);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlUser the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlUser is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public static com.sgs.portlet.pmluser.model.PmlUser update(
        com.sgs.portlet.pmluser.model.PmlUser pmlUser, boolean merge)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(pmlUser, merge);
    }

    public static com.sgs.portlet.pmluser.model.PmlUser updateImpl(
        com.sgs.portlet.pmluser.model.PmlUser pmlUser, boolean merge)
        throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(pmlUser, merge);
    }

    public static com.sgs.portlet.pmluser.model.PmlUser findByPrimaryKey(
        long userId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pmluser.NoSuchPmlUserException {
        return getPersistence().findByPrimaryKey(userId);
    }

    public static com.sgs.portlet.pmluser.model.PmlUser fetchByPrimaryKey(
        long userId) throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(userId);
    }

    public static java.util.List<com.sgs.portlet.pmluser.model.PmlUser> findByPositionId(
        java.lang.String positionId) throws com.liferay.portal.SystemException {
        return getPersistence().findByPositionId(positionId);
    }

    public static java.util.List<com.sgs.portlet.pmluser.model.PmlUser> findByPositionId(
        java.lang.String positionId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByPositionId(positionId, start, end);
    }

    public static java.util.List<com.sgs.portlet.pmluser.model.PmlUser> findByPositionId(
        java.lang.String positionId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByPositionId(positionId, start, end, obc);
    }

    public static com.sgs.portlet.pmluser.model.PmlUser findByPositionId_First(
        java.lang.String positionId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pmluser.NoSuchPmlUserException {
        return getPersistence().findByPositionId_First(positionId, obc);
    }

    public static com.sgs.portlet.pmluser.model.PmlUser findByPositionId_Last(
        java.lang.String positionId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pmluser.NoSuchPmlUserException {
        return getPersistence().findByPositionId_Last(positionId, obc);
    }

    public static com.sgs.portlet.pmluser.model.PmlUser[] findByPositionId_PrevAndNext(
        long userId, java.lang.String positionId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pmluser.NoSuchPmlUserException {
        return getPersistence()
                   .findByPositionId_PrevAndNext(userId, positionId, obc);
    }

    public static java.util.List<com.sgs.portlet.pmluser.model.PmlUser> findByTeamId(
        long teamId) throws com.liferay.portal.SystemException {
        return getPersistence().findByTeamId(teamId);
    }

    public static java.util.List<com.sgs.portlet.pmluser.model.PmlUser> findByTeamId(
        long teamId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByTeamId(teamId, start, end);
    }

    public static java.util.List<com.sgs.portlet.pmluser.model.PmlUser> findByTeamId(
        long teamId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByTeamId(teamId, start, end, obc);
    }

    public static com.sgs.portlet.pmluser.model.PmlUser findByTeamId_First(
        long teamId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pmluser.NoSuchPmlUserException {
        return getPersistence().findByTeamId_First(teamId, obc);
    }

    public static com.sgs.portlet.pmluser.model.PmlUser findByTeamId_Last(
        long teamId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pmluser.NoSuchPmlUserException {
        return getPersistence().findByTeamId_Last(teamId, obc);
    }

    public static com.sgs.portlet.pmluser.model.PmlUser[] findByTeamId_PrevAndNext(
        long userId, long teamId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pmluser.NoSuchPmlUserException {
        return getPersistence().findByTeamId_PrevAndNext(userId, teamId, obc);
    }

    public static java.util.List<com.sgs.portlet.pmluser.model.PmlUser> findByDepartmentsId(
        java.lang.String departmentsId)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByDepartmentsId(departmentsId);
    }

    public static java.util.List<com.sgs.portlet.pmluser.model.PmlUser> findByDepartmentsId(
        java.lang.String departmentsId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByDepartmentsId(departmentsId, start, end);
    }

    public static java.util.List<com.sgs.portlet.pmluser.model.PmlUser> findByDepartmentsId(
        java.lang.String departmentsId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDepartmentsId(departmentsId, start, end, obc);
    }

    public static com.sgs.portlet.pmluser.model.PmlUser findByDepartmentsId_First(
        java.lang.String departmentsId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pmluser.NoSuchPmlUserException {
        return getPersistence().findByDepartmentsId_First(departmentsId, obc);
    }

    public static com.sgs.portlet.pmluser.model.PmlUser findByDepartmentsId_Last(
        java.lang.String departmentsId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pmluser.NoSuchPmlUserException {
        return getPersistence().findByDepartmentsId_Last(departmentsId, obc);
    }

    public static com.sgs.portlet.pmluser.model.PmlUser[] findByDepartmentsId_PrevAndNext(
        long userId, java.lang.String departmentsId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pmluser.NoSuchPmlUserException {
        return getPersistence()
                   .findByDepartmentsId_PrevAndNext(userId, departmentsId, obc);
    }

    public static java.util.List<com.sgs.portlet.pmluser.model.PmlUser> findByRoleId(
        java.lang.String roleId) throws com.liferay.portal.SystemException {
        return getPersistence().findByRoleId(roleId);
    }

    public static java.util.List<com.sgs.portlet.pmluser.model.PmlUser> findByRoleId(
        java.lang.String roleId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByRoleId(roleId, start, end);
    }

    public static java.util.List<com.sgs.portlet.pmluser.model.PmlUser> findByRoleId(
        java.lang.String roleId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByRoleId(roleId, start, end, obc);
    }

    public static com.sgs.portlet.pmluser.model.PmlUser findByRoleId_First(
        java.lang.String roleId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pmluser.NoSuchPmlUserException {
        return getPersistence().findByRoleId_First(roleId, obc);
    }

    public static com.sgs.portlet.pmluser.model.PmlUser findByRoleId_Last(
        java.lang.String roleId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pmluser.NoSuchPmlUserException {
        return getPersistence().findByRoleId_Last(roleId, obc);
    }

    public static com.sgs.portlet.pmluser.model.PmlUser[] findByRoleId_PrevAndNext(
        long userId, java.lang.String roleId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pmluser.NoSuchPmlUserException {
        return getPersistence().findByRoleId_PrevAndNext(userId, roleId, obc);
    }

    public static java.util.List<com.sgs.portlet.pmluser.model.PmlUser> findByHandPhone(
        java.lang.String handPhone) throws com.liferay.portal.SystemException {
        return getPersistence().findByHandPhone(handPhone);
    }

    public static java.util.List<com.sgs.portlet.pmluser.model.PmlUser> findByHandPhone(
        java.lang.String handPhone, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByHandPhone(handPhone, start, end);
    }

    public static java.util.List<com.sgs.portlet.pmluser.model.PmlUser> findByHandPhone(
        java.lang.String handPhone, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByHandPhone(handPhone, start, end, obc);
    }

    public static com.sgs.portlet.pmluser.model.PmlUser findByHandPhone_First(
        java.lang.String handPhone,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pmluser.NoSuchPmlUserException {
        return getPersistence().findByHandPhone_First(handPhone, obc);
    }

    public static com.sgs.portlet.pmluser.model.PmlUser findByHandPhone_Last(
        java.lang.String handPhone,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pmluser.NoSuchPmlUserException {
        return getPersistence().findByHandPhone_Last(handPhone, obc);
    }

    public static com.sgs.portlet.pmluser.model.PmlUser[] findByHandPhone_PrevAndNext(
        long userId, java.lang.String handPhone,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pmluser.NoSuchPmlUserException {
        return getPersistence()
                   .findByHandPhone_PrevAndNext(userId, handPhone, obc);
    }

    public static java.util.List<com.sgs.portlet.pmluser.model.PmlUser> findByNote(
        java.lang.String note) throws com.liferay.portal.SystemException {
        return getPersistence().findByNote(note);
    }

    public static java.util.List<com.sgs.portlet.pmluser.model.PmlUser> findByNote(
        java.lang.String note, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByNote(note, start, end);
    }

    public static java.util.List<com.sgs.portlet.pmluser.model.PmlUser> findByNote(
        java.lang.String note, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByNote(note, start, end, obc);
    }

    public static com.sgs.portlet.pmluser.model.PmlUser findByNote_First(
        java.lang.String note,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pmluser.NoSuchPmlUserException {
        return getPersistence().findByNote_First(note, obc);
    }

    public static com.sgs.portlet.pmluser.model.PmlUser findByNote_Last(
        java.lang.String note,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pmluser.NoSuchPmlUserException {
        return getPersistence().findByNote_Last(note, obc);
    }

    public static com.sgs.portlet.pmluser.model.PmlUser[] findByNote_PrevAndNext(
        long userId, java.lang.String note,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pmluser.NoSuchPmlUserException {
        return getPersistence().findByNote_PrevAndNext(userId, note, obc);
    }

    public static java.util.List<com.sgs.portlet.pmluser.model.PmlUser> findByP_D_R(
        java.lang.String positionId, java.lang.String departmentsId,
        java.lang.String roleId) throws com.liferay.portal.SystemException {
        return getPersistence().findByP_D_R(positionId, departmentsId, roleId);
    }

    public static java.util.List<com.sgs.portlet.pmluser.model.PmlUser> findByP_D_R(
        java.lang.String positionId, java.lang.String departmentsId,
        java.lang.String roleId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByP_D_R(positionId, departmentsId, roleId, start, end);
    }

    public static java.util.List<com.sgs.portlet.pmluser.model.PmlUser> findByP_D_R(
        java.lang.String positionId, java.lang.String departmentsId,
        java.lang.String roleId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByP_D_R(positionId, departmentsId, roleId, start, end,
            obc);
    }

    public static com.sgs.portlet.pmluser.model.PmlUser findByP_D_R_First(
        java.lang.String positionId, java.lang.String departmentsId,
        java.lang.String roleId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pmluser.NoSuchPmlUserException {
        return getPersistence()
                   .findByP_D_R_First(positionId, departmentsId, roleId, obc);
    }

    public static com.sgs.portlet.pmluser.model.PmlUser findByP_D_R_Last(
        java.lang.String positionId, java.lang.String departmentsId,
        java.lang.String roleId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pmluser.NoSuchPmlUserException {
        return getPersistence()
                   .findByP_D_R_Last(positionId, departmentsId, roleId, obc);
    }

    public static com.sgs.portlet.pmluser.model.PmlUser[] findByP_D_R_PrevAndNext(
        long userId, java.lang.String positionId,
        java.lang.String departmentsId, java.lang.String roleId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pmluser.NoSuchPmlUserException {
        return getPersistence()
                   .findByP_D_R_PrevAndNext(userId, positionId, departmentsId,
            roleId, obc);
    }

    public static java.util.List<com.sgs.portlet.pmluser.model.PmlUser> findByDepartmentsId_Active(
        java.lang.String departmentsId, boolean active)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByDepartmentsId_Active(departmentsId, active);
    }

    public static java.util.List<com.sgs.portlet.pmluser.model.PmlUser> findByDepartmentsId_Active(
        java.lang.String departmentsId, boolean active, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDepartmentsId_Active(departmentsId, active, start, end);
    }

    public static java.util.List<com.sgs.portlet.pmluser.model.PmlUser> findByDepartmentsId_Active(
        java.lang.String departmentsId, boolean active, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDepartmentsId_Active(departmentsId, active, start,
            end, obc);
    }

    public static com.sgs.portlet.pmluser.model.PmlUser findByDepartmentsId_Active_First(
        java.lang.String departmentsId, boolean active,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pmluser.NoSuchPmlUserException {
        return getPersistence()
                   .findByDepartmentsId_Active_First(departmentsId, active, obc);
    }

    public static com.sgs.portlet.pmluser.model.PmlUser findByDepartmentsId_Active_Last(
        java.lang.String departmentsId, boolean active,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pmluser.NoSuchPmlUserException {
        return getPersistence()
                   .findByDepartmentsId_Active_Last(departmentsId, active, obc);
    }

    public static com.sgs.portlet.pmluser.model.PmlUser[] findByDepartmentsId_Active_PrevAndNext(
        long userId, java.lang.String departmentsId, boolean active,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pmluser.NoSuchPmlUserException {
        return getPersistence()
                   .findByDepartmentsId_Active_PrevAndNext(userId,
            departmentsId, active, obc);
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

    public static java.util.List<com.sgs.portlet.pmluser.model.PmlUser> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.sgs.portlet.pmluser.model.PmlUser> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.sgs.portlet.pmluser.model.PmlUser> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end, obc);
    }

    public static void removeByPositionId(java.lang.String positionId)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByPositionId(positionId);
    }

    public static void removeByTeamId(long teamId)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByTeamId(teamId);
    }

    public static void removeByDepartmentsId(java.lang.String departmentsId)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByDepartmentsId(departmentsId);
    }

    public static void removeByRoleId(java.lang.String roleId)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByRoleId(roleId);
    }

    public static void removeByHandPhone(java.lang.String handPhone)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByHandPhone(handPhone);
    }

    public static void removeByNote(java.lang.String note)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByNote(note);
    }

    public static void removeByP_D_R(java.lang.String positionId,
        java.lang.String departmentsId, java.lang.String roleId)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByP_D_R(positionId, departmentsId, roleId);
    }

    public static void removeByDepartmentsId_Active(
        java.lang.String departmentsId, boolean active)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByDepartmentsId_Active(departmentsId, active);
    }

    public static void removeAll() throws com.liferay.portal.SystemException {
        getPersistence().removeAll();
    }

    public static int countByPositionId(java.lang.String positionId)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByPositionId(positionId);
    }

    public static int countByTeamId(long teamId)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByTeamId(teamId);
    }

    public static int countByDepartmentsId(java.lang.String departmentsId)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByDepartmentsId(departmentsId);
    }

    public static int countByRoleId(java.lang.String roleId)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByRoleId(roleId);
    }

    public static int countByHandPhone(java.lang.String handPhone)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByHandPhone(handPhone);
    }

    public static int countByNote(java.lang.String note)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByNote(note);
    }

    public static int countByP_D_R(java.lang.String positionId,
        java.lang.String departmentsId, java.lang.String roleId)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByP_D_R(positionId, departmentsId, roleId);
    }

    public static int countByDepartmentsId_Active(
        java.lang.String departmentsId, boolean active)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .countByDepartmentsId_Active(departmentsId, active);
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

    public static PmlUserPersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(PmlUserPersistence persistence) {
        _persistence = persistence;
    }
}
