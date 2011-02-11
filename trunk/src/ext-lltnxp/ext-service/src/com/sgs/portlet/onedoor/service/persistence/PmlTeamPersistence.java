package com.sgs.portlet.onedoor.service.persistence;

public interface PmlTeamPersistence {
    public com.sgs.portlet.onedoor.model.PmlTeam create(long teamId);

    public com.sgs.portlet.onedoor.model.PmlTeam remove(long teamId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlTeamException;

    public com.sgs.portlet.onedoor.model.PmlTeam remove(
        com.sgs.portlet.onedoor.model.PmlTeam pmlTeam)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(PmlTeam pmlTeam, boolean merge)</code>.
     */
    public com.sgs.portlet.onedoor.model.PmlTeam update(
        com.sgs.portlet.onedoor.model.PmlTeam pmlTeam)
        throws com.liferay.portal.SystemException;

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
    public com.sgs.portlet.onedoor.model.PmlTeam update(
        com.sgs.portlet.onedoor.model.PmlTeam pmlTeam, boolean merge)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.onedoor.model.PmlTeam updateImpl(
        com.sgs.portlet.onedoor.model.PmlTeam pmlTeam, boolean merge)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.onedoor.model.PmlTeam findByPrimaryKey(long teamId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlTeamException;

    public com.sgs.portlet.onedoor.model.PmlTeam fetchByPrimaryKey(long teamId)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlTeam> findByDepartmentId_TeamCode(
        java.lang.String departmentId, java.lang.String teamCode)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlTeam> findByDepartmentId_TeamCode(
        java.lang.String departmentId, java.lang.String teamCode, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlTeam> findByDepartmentId_TeamCode(
        java.lang.String departmentId, java.lang.String teamCode, int start,
        int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.onedoor.model.PmlTeam findByDepartmentId_TeamCode_First(
        java.lang.String departmentId, java.lang.String teamCode,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlTeamException;

    public com.sgs.portlet.onedoor.model.PmlTeam findByDepartmentId_TeamCode_Last(
        java.lang.String departmentId, java.lang.String teamCode,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlTeamException;

    public com.sgs.portlet.onedoor.model.PmlTeam[] findByDepartmentId_TeamCode_PrevAndNext(
        long teamId, java.lang.String departmentId, java.lang.String teamCode,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlTeamException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlTeam> findByDepartmentId(
        java.lang.String departmentId)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlTeam> findByDepartmentId(
        java.lang.String departmentId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlTeam> findByDepartmentId(
        java.lang.String departmentId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.onedoor.model.PmlTeam findByDepartmentId_First(
        java.lang.String departmentId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlTeamException;

    public com.sgs.portlet.onedoor.model.PmlTeam findByDepartmentId_Last(
        java.lang.String departmentId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlTeamException;

    public com.sgs.portlet.onedoor.model.PmlTeam[] findByDepartmentId_PrevAndNext(
        long teamId, java.lang.String departmentId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlTeamException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlTeam> findByTeamCode(
        java.lang.String teamCode) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlTeam> findByTeamCode(
        java.lang.String teamCode, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlTeam> findByTeamCode(
        java.lang.String teamCode, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.onedoor.model.PmlTeam findByTeamCode_First(
        java.lang.String teamCode,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlTeamException;

    public com.sgs.portlet.onedoor.model.PmlTeam findByTeamCode_Last(
        java.lang.String teamCode,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlTeamException;

    public com.sgs.portlet.onedoor.model.PmlTeam[] findByTeamCode_PrevAndNext(
        long teamId, java.lang.String teamCode,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlTeamException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlTeam> findByTeamName(
        java.lang.String teamName) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlTeam> findByTeamName(
        java.lang.String teamName, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlTeam> findByTeamName(
        java.lang.String teamName, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.onedoor.model.PmlTeam findByTeamName_First(
        java.lang.String teamName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlTeamException;

    public com.sgs.portlet.onedoor.model.PmlTeam findByTeamName_Last(
        java.lang.String teamName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlTeamException;

    public com.sgs.portlet.onedoor.model.PmlTeam[] findByTeamName_PrevAndNext(
        long teamId, java.lang.String teamName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlTeamException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlTeam> findByOrganizationId(
        long organizationId) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlTeam> findByOrganizationId(
        long organizationId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlTeam> findByOrganizationId(
        long organizationId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.onedoor.model.PmlTeam findByOrganizationId_First(
        long organizationId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlTeamException;

    public com.sgs.portlet.onedoor.model.PmlTeam findByOrganizationId_Last(
        long organizationId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlTeamException;

    public com.sgs.portlet.onedoor.model.PmlTeam[] findByOrganizationId_PrevAndNext(
        long teamId, long organizationId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlTeamException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlTeam> findByCompanyId(
        long companyId) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlTeam> findByCompanyId(
        long companyId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlTeam> findByCompanyId(
        long companyId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.onedoor.model.PmlTeam findByCompanyId_First(
        long companyId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlTeamException;

    public com.sgs.portlet.onedoor.model.PmlTeam findByCompanyId_Last(
        long companyId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlTeamException;

    public com.sgs.portlet.onedoor.model.PmlTeam[] findByCompanyId_PrevAndNext(
        long teamId, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlTeamException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlTeam> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlTeam> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlTeam> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeByDepartmentId_TeamCode(java.lang.String departmentId,
        java.lang.String teamCode) throws com.liferay.portal.SystemException;

    public void removeByDepartmentId(java.lang.String departmentId)
        throws com.liferay.portal.SystemException;

    public void removeByTeamCode(java.lang.String teamCode)
        throws com.liferay.portal.SystemException;

    public void removeByTeamName(java.lang.String teamName)
        throws com.liferay.portal.SystemException;

    public void removeByOrganizationId(long organizationId)
        throws com.liferay.portal.SystemException;

    public void removeByCompanyId(long companyId)
        throws com.liferay.portal.SystemException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countByDepartmentId_TeamCode(java.lang.String departmentId,
        java.lang.String teamCode) throws com.liferay.portal.SystemException;

    public int countByDepartmentId(java.lang.String departmentId)
        throws com.liferay.portal.SystemException;

    public int countByTeamCode(java.lang.String teamCode)
        throws com.liferay.portal.SystemException;

    public int countByTeamName(java.lang.String teamName)
        throws com.liferay.portal.SystemException;

    public int countByOrganizationId(long organizationId)
        throws com.liferay.portal.SystemException;

    public int countByCompanyId(long companyId)
        throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;

    public void registerListener(
        com.liferay.portal.model.ModelListener listener);

    public void unregisterListener(
        com.liferay.portal.model.ModelListener listener);
}
