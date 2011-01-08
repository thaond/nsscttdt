package com.sgs.portlet.department.service.persistence;

public interface DepartmentPersistence {
    public com.sgs.portlet.department.model.Department create(
        java.lang.String departmentsId);

    public com.sgs.portlet.department.model.Department remove(
        java.lang.String departmentsId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.department.NoSuchDepartmentException;

    public com.sgs.portlet.department.model.Department remove(
        com.sgs.portlet.department.model.Department department)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(Department department, boolean merge)</code>.
     */
    public com.sgs.portlet.department.model.Department update(
        com.sgs.portlet.department.model.Department department)
        throws com.liferay.portal.SystemException;

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                department the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when department is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public com.sgs.portlet.department.model.Department update(
        com.sgs.portlet.department.model.Department department, boolean merge)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.department.model.Department updateImpl(
        com.sgs.portlet.department.model.Department department, boolean merge)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.department.model.Department findByPrimaryKey(
        java.lang.String departmentsId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.department.NoSuchDepartmentException;

    public com.sgs.portlet.department.model.Department fetchByPrimaryKey(
        java.lang.String departmentsId)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.department.model.Department> findByActive(
        java.lang.String active) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.department.model.Department> findByActive(
        java.lang.String active, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.department.model.Department> findByActive(
        java.lang.String active, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.department.model.Department findByActive_First(
        java.lang.String active,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.department.NoSuchDepartmentException;

    public com.sgs.portlet.department.model.Department findByActive_Last(
        java.lang.String active,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.department.NoSuchDepartmentException;

    public com.sgs.portlet.department.model.Department[] findByActive_PrevAndNext(
        java.lang.String departmentsId, java.lang.String active,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.department.NoSuchDepartmentException;

    public java.util.List<com.sgs.portlet.department.model.Department> findByDepartmentsParentId(
        java.lang.String departmentsParentId)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.department.model.Department> findByDepartmentsParentId(
        java.lang.String departmentsParentId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.department.model.Department> findByDepartmentsParentId(
        java.lang.String departmentsParentId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.department.model.Department findByDepartmentsParentId_First(
        java.lang.String departmentsParentId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.department.NoSuchDepartmentException;

    public com.sgs.portlet.department.model.Department findByDepartmentsParentId_Last(
        java.lang.String departmentsParentId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.department.NoSuchDepartmentException;

    public com.sgs.portlet.department.model.Department[] findByDepartmentsParentId_PrevAndNext(
        java.lang.String departmentsId, java.lang.String departmentsParentId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.department.NoSuchDepartmentException;

    public java.util.List<com.sgs.portlet.department.model.Department> findByDepartmentsCode_AgencyId(
        java.lang.String departmentsCode, java.lang.String agencyId)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.department.model.Department> findByDepartmentsCode_AgencyId(
        java.lang.String departmentsCode, java.lang.String agencyId, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.department.model.Department> findByDepartmentsCode_AgencyId(
        java.lang.String departmentsCode, java.lang.String agencyId, int start,
        int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.department.model.Department findByDepartmentsCode_AgencyId_First(
        java.lang.String departmentsCode, java.lang.String agencyId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.department.NoSuchDepartmentException;

    public com.sgs.portlet.department.model.Department findByDepartmentsCode_AgencyId_Last(
        java.lang.String departmentsCode, java.lang.String agencyId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.department.NoSuchDepartmentException;

    public com.sgs.portlet.department.model.Department[] findByDepartmentsCode_AgencyId_PrevAndNext(
        java.lang.String departmentsId, java.lang.String departmentsCode,
        java.lang.String agencyId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.department.NoSuchDepartmentException;

    public java.util.List<com.sgs.portlet.department.model.Department> findByDepartmentsCode(
        java.lang.String departmentsCode)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.department.model.Department> findByDepartmentsCode(
        java.lang.String departmentsCode, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.department.model.Department> findByDepartmentsCode(
        java.lang.String departmentsCode, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.department.model.Department findByDepartmentsCode_First(
        java.lang.String departmentsCode,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.department.NoSuchDepartmentException;

    public com.sgs.portlet.department.model.Department findByDepartmentsCode_Last(
        java.lang.String departmentsCode,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.department.NoSuchDepartmentException;

    public com.sgs.portlet.department.model.Department[] findByDepartmentsCode_PrevAndNext(
        java.lang.String departmentsId, java.lang.String departmentsCode,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.department.NoSuchDepartmentException;

    public java.util.List<com.sgs.portlet.department.model.Department> findByRoleId(
        long roleId) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.department.model.Department> findByRoleId(
        long roleId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.department.model.Department> findByRoleId(
        long roleId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.department.model.Department findByRoleId_First(
        long roleId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.department.NoSuchDepartmentException;

    public com.sgs.portlet.department.model.Department findByRoleId_Last(
        long roleId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.department.NoSuchDepartmentException;

    public com.sgs.portlet.department.model.Department[] findByRoleId_PrevAndNext(
        java.lang.String departmentsId, long roleId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.department.NoSuchDepartmentException;

    public java.util.List<com.sgs.portlet.department.model.Department> findByDepartmentsName(
        java.lang.String departmentsName)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.department.model.Department> findByDepartmentsName(
        java.lang.String departmentsName, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.department.model.Department> findByDepartmentsName(
        java.lang.String departmentsName, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.department.model.Department findByDepartmentsName_First(
        java.lang.String departmentsName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.department.NoSuchDepartmentException;

    public com.sgs.portlet.department.model.Department findByDepartmentsName_Last(
        java.lang.String departmentsName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.department.NoSuchDepartmentException;

    public com.sgs.portlet.department.model.Department[] findByDepartmentsName_PrevAndNext(
        java.lang.String departmentsId, java.lang.String departmentsName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.department.NoSuchDepartmentException;

    public java.util.List<com.sgs.portlet.department.model.Department> findByAbbreviateName(
        java.lang.String abbreviateName)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.department.model.Department> findByAbbreviateName(
        java.lang.String abbreviateName, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.department.model.Department> findByAbbreviateName(
        java.lang.String abbreviateName, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.department.model.Department findByAbbreviateName_First(
        java.lang.String abbreviateName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.department.NoSuchDepartmentException;

    public com.sgs.portlet.department.model.Department findByAbbreviateName_Last(
        java.lang.String abbreviateName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.department.NoSuchDepartmentException;

    public com.sgs.portlet.department.model.Department[] findByAbbreviateName_PrevAndNext(
        java.lang.String departmentsId, java.lang.String abbreviateName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.department.NoSuchDepartmentException;

    public java.util.List<com.sgs.portlet.department.model.Department> findByDescription(
        java.lang.String description) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.department.model.Department> findByDescription(
        java.lang.String description, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.department.model.Department> findByDescription(
        java.lang.String description, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.department.model.Department findByDescription_First(
        java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.department.NoSuchDepartmentException;

    public com.sgs.portlet.department.model.Department findByDescription_Last(
        java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.department.NoSuchDepartmentException;

    public com.sgs.portlet.department.model.Department[] findByDescription_PrevAndNext(
        java.lang.String departmentsId, java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.department.NoSuchDepartmentException;

    public java.util.List<com.sgs.portlet.department.model.Department> findByAgencyId(
        java.lang.String agencyId) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.department.model.Department> findByAgencyId(
        java.lang.String agencyId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.department.model.Department> findByAgencyId(
        java.lang.String agencyId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.department.model.Department findByAgencyId_First(
        java.lang.String agencyId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.department.NoSuchDepartmentException;

    public com.sgs.portlet.department.model.Department findByAgencyId_Last(
        java.lang.String agencyId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.department.NoSuchDepartmentException;

    public com.sgs.portlet.department.model.Department[] findByAgencyId_PrevAndNext(
        java.lang.String departmentsId, java.lang.String agencyId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.department.NoSuchDepartmentException;

    public java.util.List<com.sgs.portlet.department.model.Department> findByHasTeam(
        java.lang.String hasTeam) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.department.model.Department> findByHasTeam(
        java.lang.String hasTeam, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.department.model.Department> findByHasTeam(
        java.lang.String hasTeam, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.department.model.Department findByHasTeam_First(
        java.lang.String hasTeam,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.department.NoSuchDepartmentException;

    public com.sgs.portlet.department.model.Department findByHasTeam_Last(
        java.lang.String hasTeam,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.department.NoSuchDepartmentException;

    public com.sgs.portlet.department.model.Department[] findByHasTeam_PrevAndNext(
        java.lang.String departmentsId, java.lang.String hasTeam,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.department.NoSuchDepartmentException;

    public java.util.List<com.sgs.portlet.department.model.Department> findByC_N_D(
        java.lang.String departmentsCode, java.lang.String departmentsName,
        java.lang.String abbreviateName, java.lang.String description)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.department.model.Department> findByC_N_D(
        java.lang.String departmentsCode, java.lang.String departmentsName,
        java.lang.String abbreviateName, java.lang.String description,
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.department.model.Department> findByC_N_D(
        java.lang.String departmentsCode, java.lang.String departmentsName,
        java.lang.String abbreviateName, java.lang.String description,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.department.model.Department findByC_N_D_First(
        java.lang.String departmentsCode, java.lang.String departmentsName,
        java.lang.String abbreviateName, java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.department.NoSuchDepartmentException;

    public com.sgs.portlet.department.model.Department findByC_N_D_Last(
        java.lang.String departmentsCode, java.lang.String departmentsName,
        java.lang.String abbreviateName, java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.department.NoSuchDepartmentException;

    public com.sgs.portlet.department.model.Department[] findByC_N_D_PrevAndNext(
        java.lang.String departmentsId, java.lang.String departmentsCode,
        java.lang.String departmentsName, java.lang.String abbreviateName,
        java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.department.NoSuchDepartmentException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.department.model.Department> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.department.model.Department> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.department.model.Department> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeByActive(java.lang.String active)
        throws com.liferay.portal.SystemException;

    public void removeByDepartmentsParentId(
        java.lang.String departmentsParentId)
        throws com.liferay.portal.SystemException;

    public void removeByDepartmentsCode_AgencyId(
        java.lang.String departmentsCode, java.lang.String agencyId)
        throws com.liferay.portal.SystemException;

    public void removeByDepartmentsCode(java.lang.String departmentsCode)
        throws com.liferay.portal.SystemException;

    public void removeByRoleId(long roleId)
        throws com.liferay.portal.SystemException;

    public void removeByDepartmentsName(java.lang.String departmentsName)
        throws com.liferay.portal.SystemException;

    public void removeByAbbreviateName(java.lang.String abbreviateName)
        throws com.liferay.portal.SystemException;

    public void removeByDescription(java.lang.String description)
        throws com.liferay.portal.SystemException;

    public void removeByAgencyId(java.lang.String agencyId)
        throws com.liferay.portal.SystemException;

    public void removeByHasTeam(java.lang.String hasTeam)
        throws com.liferay.portal.SystemException;

    public void removeByC_N_D(java.lang.String departmentsCode,
        java.lang.String departmentsName, java.lang.String abbreviateName,
        java.lang.String description) throws com.liferay.portal.SystemException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countByActive(java.lang.String active)
        throws com.liferay.portal.SystemException;

    public int countByDepartmentsParentId(java.lang.String departmentsParentId)
        throws com.liferay.portal.SystemException;

    public int countByDepartmentsCode_AgencyId(
        java.lang.String departmentsCode, java.lang.String agencyId)
        throws com.liferay.portal.SystemException;

    public int countByDepartmentsCode(java.lang.String departmentsCode)
        throws com.liferay.portal.SystemException;

    public int countByRoleId(long roleId)
        throws com.liferay.portal.SystemException;

    public int countByDepartmentsName(java.lang.String departmentsName)
        throws com.liferay.portal.SystemException;

    public int countByAbbreviateName(java.lang.String abbreviateName)
        throws com.liferay.portal.SystemException;

    public int countByDescription(java.lang.String description)
        throws com.liferay.portal.SystemException;

    public int countByAgencyId(java.lang.String agencyId)
        throws com.liferay.portal.SystemException;

    public int countByHasTeam(java.lang.String hasTeam)
        throws com.liferay.portal.SystemException;

    public int countByC_N_D(java.lang.String departmentsCode,
        java.lang.String departmentsName, java.lang.String abbreviateName,
        java.lang.String description) throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;

    public void registerListener(
        com.liferay.portal.model.ModelListener listener);

    public void unregisterListener(
        com.liferay.portal.model.ModelListener listener);
}
