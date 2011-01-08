package com.sgs.portlet.onedoor.role.service.persistence;

public interface PmlRolePersistence {
    public com.sgs.portlet.onedoor.role.model.PmlRole create(
        java.lang.String roleId);

    public com.sgs.portlet.onedoor.role.model.PmlRole remove(
        java.lang.String roleId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.role.NoSuchPmlRoleException;

    public com.sgs.portlet.onedoor.role.model.PmlRole remove(
        com.sgs.portlet.onedoor.role.model.PmlRole pmlRole)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(PmlRole pmlRole, boolean merge)</code>.
     */
    public com.sgs.portlet.onedoor.role.model.PmlRole update(
        com.sgs.portlet.onedoor.role.model.PmlRole pmlRole)
        throws com.liferay.portal.SystemException;

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
    public com.sgs.portlet.onedoor.role.model.PmlRole update(
        com.sgs.portlet.onedoor.role.model.PmlRole pmlRole, boolean merge)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.onedoor.role.model.PmlRole updateImpl(
        com.sgs.portlet.onedoor.role.model.PmlRole pmlRole, boolean merge)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.onedoor.role.model.PmlRole findByPrimaryKey(
        java.lang.String roleId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.role.NoSuchPmlRoleException;

    public com.sgs.portlet.onedoor.role.model.PmlRole fetchByPrimaryKey(
        java.lang.String roleId) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.role.model.PmlRole> findByRoleCode(
        java.lang.String roleCode) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.role.model.PmlRole> findByRoleCode(
        java.lang.String roleCode, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.role.model.PmlRole> findByRoleCode(
        java.lang.String roleCode, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.onedoor.role.model.PmlRole findByRoleCode_First(
        java.lang.String roleCode,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.role.NoSuchPmlRoleException;

    public com.sgs.portlet.onedoor.role.model.PmlRole findByRoleCode_Last(
        java.lang.String roleCode,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.role.NoSuchPmlRoleException;

    public com.sgs.portlet.onedoor.role.model.PmlRole[] findByRoleCode_PrevAndNext(
        java.lang.String roleId, java.lang.String roleCode,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.role.NoSuchPmlRoleException;

    public java.util.List<com.sgs.portlet.onedoor.role.model.PmlRole> findByRoleName(
        java.lang.String roleName) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.role.model.PmlRole> findByRoleName(
        java.lang.String roleName, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.role.model.PmlRole> findByRoleName(
        java.lang.String roleName, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.onedoor.role.model.PmlRole findByRoleName_First(
        java.lang.String roleName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.role.NoSuchPmlRoleException;

    public com.sgs.portlet.onedoor.role.model.PmlRole findByRoleName_Last(
        java.lang.String roleName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.role.NoSuchPmlRoleException;

    public com.sgs.portlet.onedoor.role.model.PmlRole[] findByRoleName_PrevAndNext(
        java.lang.String roleId, java.lang.String roleName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.role.NoSuchPmlRoleException;

    public java.util.List<com.sgs.portlet.onedoor.role.model.PmlRole> findByDescription(
        java.lang.String description) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.role.model.PmlRole> findByDescription(
        java.lang.String description, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.role.model.PmlRole> findByDescription(
        java.lang.String description, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.onedoor.role.model.PmlRole findByDescription_First(
        java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.role.NoSuchPmlRoleException;

    public com.sgs.portlet.onedoor.role.model.PmlRole findByDescription_Last(
        java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.role.NoSuchPmlRoleException;

    public com.sgs.portlet.onedoor.role.model.PmlRole[] findByDescription_PrevAndNext(
        java.lang.String roleId, java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.role.NoSuchPmlRoleException;

    public java.util.List<com.sgs.portlet.onedoor.role.model.PmlRole> findByC_N_D(
        java.lang.String roleCode, java.lang.String roleName,
        java.lang.String description) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.role.model.PmlRole> findByC_N_D(
        java.lang.String roleCode, java.lang.String roleName,
        java.lang.String description, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.role.model.PmlRole> findByC_N_D(
        java.lang.String roleCode, java.lang.String roleName,
        java.lang.String description, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.onedoor.role.model.PmlRole findByC_N_D_First(
        java.lang.String roleCode, java.lang.String roleName,
        java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.role.NoSuchPmlRoleException;

    public com.sgs.portlet.onedoor.role.model.PmlRole findByC_N_D_Last(
        java.lang.String roleCode, java.lang.String roleName,
        java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.role.NoSuchPmlRoleException;

    public com.sgs.portlet.onedoor.role.model.PmlRole[] findByC_N_D_PrevAndNext(
        java.lang.String roleId, java.lang.String roleCode,
        java.lang.String roleName, java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.role.NoSuchPmlRoleException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.role.model.PmlRole> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.role.model.PmlRole> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.role.model.PmlRole> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeByRoleCode(java.lang.String roleCode)
        throws com.liferay.portal.SystemException;

    public void removeByRoleName(java.lang.String roleName)
        throws com.liferay.portal.SystemException;

    public void removeByDescription(java.lang.String description)
        throws com.liferay.portal.SystemException;

    public void removeByC_N_D(java.lang.String roleCode,
        java.lang.String roleName, java.lang.String description)
        throws com.liferay.portal.SystemException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countByRoleCode(java.lang.String roleCode)
        throws com.liferay.portal.SystemException;

    public int countByRoleName(java.lang.String roleName)
        throws com.liferay.portal.SystemException;

    public int countByDescription(java.lang.String description)
        throws com.liferay.portal.SystemException;

    public int countByC_N_D(java.lang.String roleCode,
        java.lang.String roleName, java.lang.String description)
        throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;

    public void registerListener(
        com.liferay.portal.model.ModelListener listener);

    public void unregisterListener(
        com.liferay.portal.model.ModelListener listener);
}
