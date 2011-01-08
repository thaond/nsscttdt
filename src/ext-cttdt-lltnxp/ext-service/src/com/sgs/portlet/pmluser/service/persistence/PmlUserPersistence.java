package com.sgs.portlet.pmluser.service.persistence;

public interface PmlUserPersistence {
    public com.sgs.portlet.pmluser.model.PmlUser create(long userId);

    public com.sgs.portlet.pmluser.model.PmlUser remove(long userId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pmluser.NoSuchPmlUserException;

    public com.sgs.portlet.pmluser.model.PmlUser remove(
        com.sgs.portlet.pmluser.model.PmlUser pmlUser)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(PmlUser pmlUser, boolean merge)</code>.
     */
    public com.sgs.portlet.pmluser.model.PmlUser update(
        com.sgs.portlet.pmluser.model.PmlUser pmlUser)
        throws com.liferay.portal.SystemException;

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
    public com.sgs.portlet.pmluser.model.PmlUser update(
        com.sgs.portlet.pmluser.model.PmlUser pmlUser, boolean merge)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.pmluser.model.PmlUser updateImpl(
        com.sgs.portlet.pmluser.model.PmlUser pmlUser, boolean merge)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.pmluser.model.PmlUser findByPrimaryKey(long userId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pmluser.NoSuchPmlUserException;

    public com.sgs.portlet.pmluser.model.PmlUser fetchByPrimaryKey(long userId)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pmluser.model.PmlUser> findByPositionId(
        java.lang.String positionId) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pmluser.model.PmlUser> findByPositionId(
        java.lang.String positionId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pmluser.model.PmlUser> findByPositionId(
        java.lang.String positionId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.pmluser.model.PmlUser findByPositionId_First(
        java.lang.String positionId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pmluser.NoSuchPmlUserException;

    public com.sgs.portlet.pmluser.model.PmlUser findByPositionId_Last(
        java.lang.String positionId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pmluser.NoSuchPmlUserException;

    public com.sgs.portlet.pmluser.model.PmlUser[] findByPositionId_PrevAndNext(
        long userId, java.lang.String positionId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pmluser.NoSuchPmlUserException;

    public java.util.List<com.sgs.portlet.pmluser.model.PmlUser> findByTeamId(
        long teamId) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pmluser.model.PmlUser> findByTeamId(
        long teamId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pmluser.model.PmlUser> findByTeamId(
        long teamId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.pmluser.model.PmlUser findByTeamId_First(
        long teamId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pmluser.NoSuchPmlUserException;

    public com.sgs.portlet.pmluser.model.PmlUser findByTeamId_Last(
        long teamId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pmluser.NoSuchPmlUserException;

    public com.sgs.portlet.pmluser.model.PmlUser[] findByTeamId_PrevAndNext(
        long userId, long teamId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pmluser.NoSuchPmlUserException;

    public java.util.List<com.sgs.portlet.pmluser.model.PmlUser> findByDepartmentsId(
        java.lang.String departmentsId)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pmluser.model.PmlUser> findByDepartmentsId(
        java.lang.String departmentsId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pmluser.model.PmlUser> findByDepartmentsId(
        java.lang.String departmentsId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.pmluser.model.PmlUser findByDepartmentsId_First(
        java.lang.String departmentsId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pmluser.NoSuchPmlUserException;

    public com.sgs.portlet.pmluser.model.PmlUser findByDepartmentsId_Last(
        java.lang.String departmentsId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pmluser.NoSuchPmlUserException;

    public com.sgs.portlet.pmluser.model.PmlUser[] findByDepartmentsId_PrevAndNext(
        long userId, java.lang.String departmentsId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pmluser.NoSuchPmlUserException;

    public java.util.List<com.sgs.portlet.pmluser.model.PmlUser> findByRoleId(
        java.lang.String roleId) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pmluser.model.PmlUser> findByRoleId(
        java.lang.String roleId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pmluser.model.PmlUser> findByRoleId(
        java.lang.String roleId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.pmluser.model.PmlUser findByRoleId_First(
        java.lang.String roleId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pmluser.NoSuchPmlUserException;

    public com.sgs.portlet.pmluser.model.PmlUser findByRoleId_Last(
        java.lang.String roleId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pmluser.NoSuchPmlUserException;

    public com.sgs.portlet.pmluser.model.PmlUser[] findByRoleId_PrevAndNext(
        long userId, java.lang.String roleId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pmluser.NoSuchPmlUserException;

    public java.util.List<com.sgs.portlet.pmluser.model.PmlUser> findByHandPhone(
        java.lang.String handPhone) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pmluser.model.PmlUser> findByHandPhone(
        java.lang.String handPhone, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pmluser.model.PmlUser> findByHandPhone(
        java.lang.String handPhone, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.pmluser.model.PmlUser findByHandPhone_First(
        java.lang.String handPhone,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pmluser.NoSuchPmlUserException;

    public com.sgs.portlet.pmluser.model.PmlUser findByHandPhone_Last(
        java.lang.String handPhone,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pmluser.NoSuchPmlUserException;

    public com.sgs.portlet.pmluser.model.PmlUser[] findByHandPhone_PrevAndNext(
        long userId, java.lang.String handPhone,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pmluser.NoSuchPmlUserException;

    public java.util.List<com.sgs.portlet.pmluser.model.PmlUser> findByNote(
        java.lang.String note) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pmluser.model.PmlUser> findByNote(
        java.lang.String note, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pmluser.model.PmlUser> findByNote(
        java.lang.String note, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.pmluser.model.PmlUser findByNote_First(
        java.lang.String note,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pmluser.NoSuchPmlUserException;

    public com.sgs.portlet.pmluser.model.PmlUser findByNote_Last(
        java.lang.String note,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pmluser.NoSuchPmlUserException;

    public com.sgs.portlet.pmluser.model.PmlUser[] findByNote_PrevAndNext(
        long userId, java.lang.String note,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pmluser.NoSuchPmlUserException;

    public java.util.List<com.sgs.portlet.pmluser.model.PmlUser> findByP_D_R(
        java.lang.String positionId, java.lang.String departmentsId,
        java.lang.String roleId) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pmluser.model.PmlUser> findByP_D_R(
        java.lang.String positionId, java.lang.String departmentsId,
        java.lang.String roleId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pmluser.model.PmlUser> findByP_D_R(
        java.lang.String positionId, java.lang.String departmentsId,
        java.lang.String roleId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.pmluser.model.PmlUser findByP_D_R_First(
        java.lang.String positionId, java.lang.String departmentsId,
        java.lang.String roleId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pmluser.NoSuchPmlUserException;

    public com.sgs.portlet.pmluser.model.PmlUser findByP_D_R_Last(
        java.lang.String positionId, java.lang.String departmentsId,
        java.lang.String roleId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pmluser.NoSuchPmlUserException;

    public com.sgs.portlet.pmluser.model.PmlUser[] findByP_D_R_PrevAndNext(
        long userId, java.lang.String positionId,
        java.lang.String departmentsId, java.lang.String roleId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pmluser.NoSuchPmlUserException;

    public java.util.List<com.sgs.portlet.pmluser.model.PmlUser> findByDepartmentsId_Active(
        java.lang.String departmentsId, boolean active)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pmluser.model.PmlUser> findByDepartmentsId_Active(
        java.lang.String departmentsId, boolean active, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pmluser.model.PmlUser> findByDepartmentsId_Active(
        java.lang.String departmentsId, boolean active, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.pmluser.model.PmlUser findByDepartmentsId_Active_First(
        java.lang.String departmentsId, boolean active,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pmluser.NoSuchPmlUserException;

    public com.sgs.portlet.pmluser.model.PmlUser findByDepartmentsId_Active_Last(
        java.lang.String departmentsId, boolean active,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pmluser.NoSuchPmlUserException;

    public com.sgs.portlet.pmluser.model.PmlUser[] findByDepartmentsId_Active_PrevAndNext(
        long userId, java.lang.String departmentsId, boolean active,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pmluser.NoSuchPmlUserException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pmluser.model.PmlUser> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pmluser.model.PmlUser> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pmluser.model.PmlUser> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeByPositionId(java.lang.String positionId)
        throws com.liferay.portal.SystemException;

    public void removeByTeamId(long teamId)
        throws com.liferay.portal.SystemException;

    public void removeByDepartmentsId(java.lang.String departmentsId)
        throws com.liferay.portal.SystemException;

    public void removeByRoleId(java.lang.String roleId)
        throws com.liferay.portal.SystemException;

    public void removeByHandPhone(java.lang.String handPhone)
        throws com.liferay.portal.SystemException;

    public void removeByNote(java.lang.String note)
        throws com.liferay.portal.SystemException;

    public void removeByP_D_R(java.lang.String positionId,
        java.lang.String departmentsId, java.lang.String roleId)
        throws com.liferay.portal.SystemException;

    public void removeByDepartmentsId_Active(java.lang.String departmentsId,
        boolean active) throws com.liferay.portal.SystemException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countByPositionId(java.lang.String positionId)
        throws com.liferay.portal.SystemException;

    public int countByTeamId(long teamId)
        throws com.liferay.portal.SystemException;

    public int countByDepartmentsId(java.lang.String departmentsId)
        throws com.liferay.portal.SystemException;

    public int countByRoleId(java.lang.String roleId)
        throws com.liferay.portal.SystemException;

    public int countByHandPhone(java.lang.String handPhone)
        throws com.liferay.portal.SystemException;

    public int countByNote(java.lang.String note)
        throws com.liferay.portal.SystemException;

    public int countByP_D_R(java.lang.String positionId,
        java.lang.String departmentsId, java.lang.String roleId)
        throws com.liferay.portal.SystemException;

    public int countByDepartmentsId_Active(java.lang.String departmentsId,
        boolean active) throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;

    public void registerListener(
        com.liferay.portal.model.ModelListener listener);

    public void unregisterListener(
        com.liferay.portal.model.ModelListener listener);
}
