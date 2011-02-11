package com.sgs.portlet.onedoor.role.service.persistence;

public class PmlRoleUtil {
    private static PmlRolePersistence _persistence;

    public static com.sgs.portlet.onedoor.role.model.PmlRole create(
        java.lang.String roleId) {
        return getPersistence().create(roleId);
    }

    public static com.sgs.portlet.onedoor.role.model.PmlRole remove(
        java.lang.String roleId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.role.NoSuchPmlRoleException {
        return getPersistence().remove(roleId);
    }

    public static com.sgs.portlet.onedoor.role.model.PmlRole remove(
        com.sgs.portlet.onedoor.role.model.PmlRole pmlRole)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(pmlRole);
    }

    /**
     * @deprecated Use <code>update(PmlRole pmlRole, boolean merge)</code>.
     */
    public static com.sgs.portlet.onedoor.role.model.PmlRole update(
        com.sgs.portlet.onedoor.role.model.PmlRole pmlRole)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(pmlRole);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlRole the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlRole is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public static com.sgs.portlet.onedoor.role.model.PmlRole update(
        com.sgs.portlet.onedoor.role.model.PmlRole pmlRole, boolean merge)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(pmlRole, merge);
    }

    public static com.sgs.portlet.onedoor.role.model.PmlRole updateImpl(
        com.sgs.portlet.onedoor.role.model.PmlRole pmlRole, boolean merge)
        throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(pmlRole, merge);
    }

    public static com.sgs.portlet.onedoor.role.model.PmlRole findByPrimaryKey(
        java.lang.String roleId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.role.NoSuchPmlRoleException {
        return getPersistence().findByPrimaryKey(roleId);
    }

    public static com.sgs.portlet.onedoor.role.model.PmlRole fetchByPrimaryKey(
        java.lang.String roleId) throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(roleId);
    }

    public static java.util.List<com.sgs.portlet.onedoor.role.model.PmlRole> findByRoleCode(
        java.lang.String roleCode) throws com.liferay.portal.SystemException {
        return getPersistence().findByRoleCode(roleCode);
    }

    public static java.util.List<com.sgs.portlet.onedoor.role.model.PmlRole> findByRoleCode(
        java.lang.String roleCode, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByRoleCode(roleCode, start, end);
    }

    public static java.util.List<com.sgs.portlet.onedoor.role.model.PmlRole> findByRoleCode(
        java.lang.String roleCode, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByRoleCode(roleCode, start, end, obc);
    }

    public static com.sgs.portlet.onedoor.role.model.PmlRole findByRoleCode_First(
        java.lang.String roleCode,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.role.NoSuchPmlRoleException {
        return getPersistence().findByRoleCode_First(roleCode, obc);
    }

    public static com.sgs.portlet.onedoor.role.model.PmlRole findByRoleCode_Last(
        java.lang.String roleCode,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.role.NoSuchPmlRoleException {
        return getPersistence().findByRoleCode_Last(roleCode, obc);
    }

    public static com.sgs.portlet.onedoor.role.model.PmlRole[] findByRoleCode_PrevAndNext(
        java.lang.String roleId, java.lang.String roleCode,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.role.NoSuchPmlRoleException {
        return getPersistence().findByRoleCode_PrevAndNext(roleId, roleCode, obc);
    }

    public static java.util.List<com.sgs.portlet.onedoor.role.model.PmlRole> findByRoleName(
        java.lang.String roleName) throws com.liferay.portal.SystemException {
        return getPersistence().findByRoleName(roleName);
    }

    public static java.util.List<com.sgs.portlet.onedoor.role.model.PmlRole> findByRoleName(
        java.lang.String roleName, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByRoleName(roleName, start, end);
    }

    public static java.util.List<com.sgs.portlet.onedoor.role.model.PmlRole> findByRoleName(
        java.lang.String roleName, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByRoleName(roleName, start, end, obc);
    }

    public static com.sgs.portlet.onedoor.role.model.PmlRole findByRoleName_First(
        java.lang.String roleName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.role.NoSuchPmlRoleException {
        return getPersistence().findByRoleName_First(roleName, obc);
    }

    public static com.sgs.portlet.onedoor.role.model.PmlRole findByRoleName_Last(
        java.lang.String roleName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.role.NoSuchPmlRoleException {
        return getPersistence().findByRoleName_Last(roleName, obc);
    }

    public static com.sgs.portlet.onedoor.role.model.PmlRole[] findByRoleName_PrevAndNext(
        java.lang.String roleId, java.lang.String roleName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.role.NoSuchPmlRoleException {
        return getPersistence().findByRoleName_PrevAndNext(roleId, roleName, obc);
    }

    public static java.util.List<com.sgs.portlet.onedoor.role.model.PmlRole> findByDescription(
        java.lang.String description) throws com.liferay.portal.SystemException {
        return getPersistence().findByDescription(description);
    }

    public static java.util.List<com.sgs.portlet.onedoor.role.model.PmlRole> findByDescription(
        java.lang.String description, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByDescription(description, start, end);
    }

    public static java.util.List<com.sgs.portlet.onedoor.role.model.PmlRole> findByDescription(
        java.lang.String description, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByDescription(description, start, end, obc);
    }

    public static com.sgs.portlet.onedoor.role.model.PmlRole findByDescription_First(
        java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.role.NoSuchPmlRoleException {
        return getPersistence().findByDescription_First(description, obc);
    }

    public static com.sgs.portlet.onedoor.role.model.PmlRole findByDescription_Last(
        java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.role.NoSuchPmlRoleException {
        return getPersistence().findByDescription_Last(description, obc);
    }

    public static com.sgs.portlet.onedoor.role.model.PmlRole[] findByDescription_PrevAndNext(
        java.lang.String roleId, java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.role.NoSuchPmlRoleException {
        return getPersistence()
                   .findByDescription_PrevAndNext(roleId, description, obc);
    }

    public static java.util.List<com.sgs.portlet.onedoor.role.model.PmlRole> findByC_N_D(
        java.lang.String roleCode, java.lang.String roleName,
        java.lang.String description) throws com.liferay.portal.SystemException {
        return getPersistence().findByC_N_D(roleCode, roleName, description);
    }

    public static java.util.List<com.sgs.portlet.onedoor.role.model.PmlRole> findByC_N_D(
        java.lang.String roleCode, java.lang.String roleName,
        java.lang.String description, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByC_N_D(roleCode, roleName, description, start, end);
    }

    public static java.util.List<com.sgs.portlet.onedoor.role.model.PmlRole> findByC_N_D(
        java.lang.String roleCode, java.lang.String roleName,
        java.lang.String description, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByC_N_D(roleCode, roleName, description, start, end, obc);
    }

    public static com.sgs.portlet.onedoor.role.model.PmlRole findByC_N_D_First(
        java.lang.String roleCode, java.lang.String roleName,
        java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.role.NoSuchPmlRoleException {
        return getPersistence()
                   .findByC_N_D_First(roleCode, roleName, description, obc);
    }

    public static com.sgs.portlet.onedoor.role.model.PmlRole findByC_N_D_Last(
        java.lang.String roleCode, java.lang.String roleName,
        java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.role.NoSuchPmlRoleException {
        return getPersistence()
                   .findByC_N_D_Last(roleCode, roleName, description, obc);
    }

    public static com.sgs.portlet.onedoor.role.model.PmlRole[] findByC_N_D_PrevAndNext(
        java.lang.String roleId, java.lang.String roleCode,
        java.lang.String roleName, java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.role.NoSuchPmlRoleException {
        return getPersistence()
                   .findByC_N_D_PrevAndNext(roleId, roleCode, roleName,
            description, obc);
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

    public static java.util.List<com.sgs.portlet.onedoor.role.model.PmlRole> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.sgs.portlet.onedoor.role.model.PmlRole> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.sgs.portlet.onedoor.role.model.PmlRole> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end, obc);
    }

    public static void removeByRoleCode(java.lang.String roleCode)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByRoleCode(roleCode);
    }

    public static void removeByRoleName(java.lang.String roleName)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByRoleName(roleName);
    }

    public static void removeByDescription(java.lang.String description)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByDescription(description);
    }

    public static void removeByC_N_D(java.lang.String roleCode,
        java.lang.String roleName, java.lang.String description)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByC_N_D(roleCode, roleName, description);
    }

    public static void removeAll() throws com.liferay.portal.SystemException {
        getPersistence().removeAll();
    }

    public static int countByRoleCode(java.lang.String roleCode)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByRoleCode(roleCode);
    }

    public static int countByRoleName(java.lang.String roleName)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByRoleName(roleName);
    }

    public static int countByDescription(java.lang.String description)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByDescription(description);
    }

    public static int countByC_N_D(java.lang.String roleCode,
        java.lang.String roleName, java.lang.String description)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByC_N_D(roleCode, roleName, description);
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

    public static PmlRolePersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(PmlRolePersistence persistence) {
        _persistence = persistence;
    }
}
