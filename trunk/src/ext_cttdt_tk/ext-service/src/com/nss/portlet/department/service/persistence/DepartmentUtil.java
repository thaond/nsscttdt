package com.nss.portlet.department.service.persistence;

public class DepartmentUtil {
    private static DepartmentPersistence _persistence;

    public static void cacheResult(
        com.nss.portlet.department.model.Department department) {
        getPersistence().cacheResult(department);
    }

    public static void cacheResult(
        java.util.List<com.nss.portlet.department.model.Department> departments) {
        getPersistence().cacheResult(departments);
    }

    public static void clearCache() {
        getPersistence().clearCache();
    }

    public static com.nss.portlet.department.model.Department create(
        java.lang.String departmentsId) {
        return getPersistence().create(departmentsId);
    }

    public static com.nss.portlet.department.model.Department remove(
        java.lang.String departmentsId)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.department.NoSuchDepartmentException {
        return getPersistence().remove(departmentsId);
    }

    public static com.nss.portlet.department.model.Department remove(
        com.nss.portlet.department.model.Department department)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(department);
    }

    /**
     * @deprecated Use <code>update(Department department, boolean merge)</code>.
     */
    public static com.nss.portlet.department.model.Department update(
        com.nss.portlet.department.model.Department department)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(department);
    }

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
    public static com.nss.portlet.department.model.Department update(
        com.nss.portlet.department.model.Department department, boolean merge)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(department, merge);
    }

    public static com.nss.portlet.department.model.Department updateImpl(
        com.nss.portlet.department.model.Department department, boolean merge)
        throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(department, merge);
    }

    public static com.nss.portlet.department.model.Department findByPrimaryKey(
        java.lang.String departmentsId)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.department.NoSuchDepartmentException {
        return getPersistence().findByPrimaryKey(departmentsId);
    }

    public static com.nss.portlet.department.model.Department fetchByPrimaryKey(
        java.lang.String departmentsId)
        throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(departmentsId);
    }

    public static java.util.List<com.nss.portlet.department.model.Department> findByActive(
        java.lang.String active) throws com.liferay.portal.SystemException {
        return getPersistence().findByActive(active);
    }

    public static java.util.List<com.nss.portlet.department.model.Department> findByActive(
        java.lang.String active, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByActive(active, start, end);
    }

    public static java.util.List<com.nss.portlet.department.model.Department> findByActive(
        java.lang.String active, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByActive(active, start, end, obc);
    }

    public static com.nss.portlet.department.model.Department findByActive_First(
        java.lang.String active,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.department.NoSuchDepartmentException {
        return getPersistence().findByActive_First(active, obc);
    }

    public static com.nss.portlet.department.model.Department findByActive_Last(
        java.lang.String active,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.department.NoSuchDepartmentException {
        return getPersistence().findByActive_Last(active, obc);
    }

    public static com.nss.portlet.department.model.Department[] findByActive_PrevAndNext(
        java.lang.String departmentsId, java.lang.String active,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.department.NoSuchDepartmentException {
        return getPersistence()
                   .findByActive_PrevAndNext(departmentsId, active, obc);
    }

    public static java.util.List<com.nss.portlet.department.model.Department> findByDepartmentsParentId(
        java.lang.String departmentsParentId)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByDepartmentsParentId(departmentsParentId);
    }

    public static java.util.List<com.nss.portlet.department.model.Department> findByDepartmentsParentId(
        java.lang.String departmentsParentId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDepartmentsParentId(departmentsParentId, start, end);
    }

    public static java.util.List<com.nss.portlet.department.model.Department> findByDepartmentsParentId(
        java.lang.String departmentsParentId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDepartmentsParentId(departmentsParentId, start, end,
            obc);
    }

    public static com.nss.portlet.department.model.Department findByDepartmentsParentId_First(
        java.lang.String departmentsParentId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.department.NoSuchDepartmentException {
        return getPersistence()
                   .findByDepartmentsParentId_First(departmentsParentId, obc);
    }

    public static com.nss.portlet.department.model.Department findByDepartmentsParentId_Last(
        java.lang.String departmentsParentId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.department.NoSuchDepartmentException {
        return getPersistence()
                   .findByDepartmentsParentId_Last(departmentsParentId, obc);
    }

    public static com.nss.portlet.department.model.Department[] findByDepartmentsParentId_PrevAndNext(
        java.lang.String departmentsId, java.lang.String departmentsParentId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.department.NoSuchDepartmentException {
        return getPersistence()
                   .findByDepartmentsParentId_PrevAndNext(departmentsId,
            departmentsParentId, obc);
    }

    public static java.util.List<com.nss.portlet.department.model.Department> findByDepartmentsCode_AgencyId(
        java.lang.String departmentsCode, java.lang.String agencyId)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDepartmentsCode_AgencyId(departmentsCode, agencyId);
    }

    public static java.util.List<com.nss.portlet.department.model.Department> findByDepartmentsCode_AgencyId(
        java.lang.String departmentsCode, java.lang.String agencyId, int start,
        int end) throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDepartmentsCode_AgencyId(departmentsCode, agencyId,
            start, end);
    }

    public static java.util.List<com.nss.portlet.department.model.Department> findByDepartmentsCode_AgencyId(
        java.lang.String departmentsCode, java.lang.String agencyId, int start,
        int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDepartmentsCode_AgencyId(departmentsCode, agencyId,
            start, end, obc);
    }

    public static com.nss.portlet.department.model.Department findByDepartmentsCode_AgencyId_First(
        java.lang.String departmentsCode, java.lang.String agencyId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.department.NoSuchDepartmentException {
        return getPersistence()
                   .findByDepartmentsCode_AgencyId_First(departmentsCode,
            agencyId, obc);
    }

    public static com.nss.portlet.department.model.Department findByDepartmentsCode_AgencyId_Last(
        java.lang.String departmentsCode, java.lang.String agencyId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.department.NoSuchDepartmentException {
        return getPersistence()
                   .findByDepartmentsCode_AgencyId_Last(departmentsCode,
            agencyId, obc);
    }

    public static com.nss.portlet.department.model.Department[] findByDepartmentsCode_AgencyId_PrevAndNext(
        java.lang.String departmentsId, java.lang.String departmentsCode,
        java.lang.String agencyId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.department.NoSuchDepartmentException {
        return getPersistence()
                   .findByDepartmentsCode_AgencyId_PrevAndNext(departmentsId,
            departmentsCode, agencyId, obc);
    }

    public static java.util.List<com.nss.portlet.department.model.Department> findByDepartmentsCode(
        java.lang.String departmentsCode)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByDepartmentsCode(departmentsCode);
    }

    public static java.util.List<com.nss.portlet.department.model.Department> findByDepartmentsCode(
        java.lang.String departmentsCode, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDepartmentsCode(departmentsCode, start, end);
    }

    public static java.util.List<com.nss.portlet.department.model.Department> findByDepartmentsCode(
        java.lang.String departmentsCode, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDepartmentsCode(departmentsCode, start, end, obc);
    }

    public static com.nss.portlet.department.model.Department findByDepartmentsCode_First(
        java.lang.String departmentsCode,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.department.NoSuchDepartmentException {
        return getPersistence().findByDepartmentsCode_First(departmentsCode, obc);
    }

    public static com.nss.portlet.department.model.Department findByDepartmentsCode_Last(
        java.lang.String departmentsCode,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.department.NoSuchDepartmentException {
        return getPersistence().findByDepartmentsCode_Last(departmentsCode, obc);
    }

    public static com.nss.portlet.department.model.Department[] findByDepartmentsCode_PrevAndNext(
        java.lang.String departmentsId, java.lang.String departmentsCode,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.department.NoSuchDepartmentException {
        return getPersistence()
                   .findByDepartmentsCode_PrevAndNext(departmentsId,
            departmentsCode, obc);
    }

    public static java.util.List<com.nss.portlet.department.model.Department> findByRoleId(
        long roleId) throws com.liferay.portal.SystemException {
        return getPersistence().findByRoleId(roleId);
    }

    public static java.util.List<com.nss.portlet.department.model.Department> findByRoleId(
        long roleId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByRoleId(roleId, start, end);
    }

    public static java.util.List<com.nss.portlet.department.model.Department> findByRoleId(
        long roleId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByRoleId(roleId, start, end, obc);
    }

    public static com.nss.portlet.department.model.Department findByRoleId_First(
        long roleId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.department.NoSuchDepartmentException {
        return getPersistence().findByRoleId_First(roleId, obc);
    }

    public static com.nss.portlet.department.model.Department findByRoleId_Last(
        long roleId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.department.NoSuchDepartmentException {
        return getPersistence().findByRoleId_Last(roleId, obc);
    }

    public static com.nss.portlet.department.model.Department[] findByRoleId_PrevAndNext(
        java.lang.String departmentsId, long roleId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.department.NoSuchDepartmentException {
        return getPersistence()
                   .findByRoleId_PrevAndNext(departmentsId, roleId, obc);
    }

    public static java.util.List<com.nss.portlet.department.model.Department> findByDepartmentsName(
        java.lang.String departmentsName)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByDepartmentsName(departmentsName);
    }

    public static java.util.List<com.nss.portlet.department.model.Department> findByDepartmentsName(
        java.lang.String departmentsName, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDepartmentsName(departmentsName, start, end);
    }

    public static java.util.List<com.nss.portlet.department.model.Department> findByDepartmentsName(
        java.lang.String departmentsName, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDepartmentsName(departmentsName, start, end, obc);
    }

    public static com.nss.portlet.department.model.Department findByDepartmentsName_First(
        java.lang.String departmentsName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.department.NoSuchDepartmentException {
        return getPersistence().findByDepartmentsName_First(departmentsName, obc);
    }

    public static com.nss.portlet.department.model.Department findByDepartmentsName_Last(
        java.lang.String departmentsName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.department.NoSuchDepartmentException {
        return getPersistence().findByDepartmentsName_Last(departmentsName, obc);
    }

    public static com.nss.portlet.department.model.Department[] findByDepartmentsName_PrevAndNext(
        java.lang.String departmentsId, java.lang.String departmentsName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.department.NoSuchDepartmentException {
        return getPersistence()
                   .findByDepartmentsName_PrevAndNext(departmentsId,
            departmentsName, obc);
    }

    public static java.util.List<com.nss.portlet.department.model.Department> findByAbbreviateName(
        java.lang.String abbreviateName)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByAbbreviateName(abbreviateName);
    }

    public static java.util.List<com.nss.portlet.department.model.Department> findByAbbreviateName(
        java.lang.String abbreviateName, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByAbbreviateName(abbreviateName, start, end);
    }

    public static java.util.List<com.nss.portlet.department.model.Department> findByAbbreviateName(
        java.lang.String abbreviateName, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByAbbreviateName(abbreviateName, start, end, obc);
    }

    public static com.nss.portlet.department.model.Department findByAbbreviateName_First(
        java.lang.String abbreviateName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.department.NoSuchDepartmentException {
        return getPersistence().findByAbbreviateName_First(abbreviateName, obc);
    }

    public static com.nss.portlet.department.model.Department findByAbbreviateName_Last(
        java.lang.String abbreviateName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.department.NoSuchDepartmentException {
        return getPersistence().findByAbbreviateName_Last(abbreviateName, obc);
    }

    public static com.nss.portlet.department.model.Department[] findByAbbreviateName_PrevAndNext(
        java.lang.String departmentsId, java.lang.String abbreviateName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.department.NoSuchDepartmentException {
        return getPersistence()
                   .findByAbbreviateName_PrevAndNext(departmentsId,
            abbreviateName, obc);
    }

    public static java.util.List<com.nss.portlet.department.model.Department> findByDescription(
        java.lang.String description) throws com.liferay.portal.SystemException {
        return getPersistence().findByDescription(description);
    }

    public static java.util.List<com.nss.portlet.department.model.Department> findByDescription(
        java.lang.String description, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByDescription(description, start, end);
    }

    public static java.util.List<com.nss.portlet.department.model.Department> findByDescription(
        java.lang.String description, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByDescription(description, start, end, obc);
    }

    public static com.nss.portlet.department.model.Department findByDescription_First(
        java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.department.NoSuchDepartmentException {
        return getPersistence().findByDescription_First(description, obc);
    }

    public static com.nss.portlet.department.model.Department findByDescription_Last(
        java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.department.NoSuchDepartmentException {
        return getPersistence().findByDescription_Last(description, obc);
    }

    public static com.nss.portlet.department.model.Department[] findByDescription_PrevAndNext(
        java.lang.String departmentsId, java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.department.NoSuchDepartmentException {
        return getPersistence()
                   .findByDescription_PrevAndNext(departmentsId, description,
            obc);
    }

    public static java.util.List<com.nss.portlet.department.model.Department> findByAgencyId(
        java.lang.String agencyId) throws com.liferay.portal.SystemException {
        return getPersistence().findByAgencyId(agencyId);
    }

    public static java.util.List<com.nss.portlet.department.model.Department> findByAgencyId(
        java.lang.String agencyId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByAgencyId(agencyId, start, end);
    }

    public static java.util.List<com.nss.portlet.department.model.Department> findByAgencyId(
        java.lang.String agencyId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByAgencyId(agencyId, start, end, obc);
    }

    public static com.nss.portlet.department.model.Department findByAgencyId_First(
        java.lang.String agencyId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.department.NoSuchDepartmentException {
        return getPersistence().findByAgencyId_First(agencyId, obc);
    }

    public static com.nss.portlet.department.model.Department findByAgencyId_Last(
        java.lang.String agencyId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.department.NoSuchDepartmentException {
        return getPersistence().findByAgencyId_Last(agencyId, obc);
    }

    public static com.nss.portlet.department.model.Department[] findByAgencyId_PrevAndNext(
        java.lang.String departmentsId, java.lang.String agencyId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.department.NoSuchDepartmentException {
        return getPersistence()
                   .findByAgencyId_PrevAndNext(departmentsId, agencyId, obc);
    }

    public static java.util.List<com.nss.portlet.department.model.Department> findByHasTeam(
        java.lang.String hasTeam) throws com.liferay.portal.SystemException {
        return getPersistence().findByHasTeam(hasTeam);
    }

    public static java.util.List<com.nss.portlet.department.model.Department> findByHasTeam(
        java.lang.String hasTeam, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByHasTeam(hasTeam, start, end);
    }

    public static java.util.List<com.nss.portlet.department.model.Department> findByHasTeam(
        java.lang.String hasTeam, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByHasTeam(hasTeam, start, end, obc);
    }

    public static com.nss.portlet.department.model.Department findByHasTeam_First(
        java.lang.String hasTeam,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.department.NoSuchDepartmentException {
        return getPersistence().findByHasTeam_First(hasTeam, obc);
    }

    public static com.nss.portlet.department.model.Department findByHasTeam_Last(
        java.lang.String hasTeam,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.department.NoSuchDepartmentException {
        return getPersistence().findByHasTeam_Last(hasTeam, obc);
    }

    public static com.nss.portlet.department.model.Department[] findByHasTeam_PrevAndNext(
        java.lang.String departmentsId, java.lang.String hasTeam,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.department.NoSuchDepartmentException {
        return getPersistence()
                   .findByHasTeam_PrevAndNext(departmentsId, hasTeam, obc);
    }

    public static java.util.List<com.nss.portlet.department.model.Department> findByC_N_D(
        java.lang.String departmentsCode, java.lang.String departmentsName,
        java.lang.String abbreviateName, java.lang.String description)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByC_N_D(departmentsCode, departmentsName,
            abbreviateName, description);
    }

    public static java.util.List<com.nss.portlet.department.model.Department> findByC_N_D(
        java.lang.String departmentsCode, java.lang.String departmentsName,
        java.lang.String abbreviateName, java.lang.String description,
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByC_N_D(departmentsCode, departmentsName,
            abbreviateName, description, start, end);
    }

    public static java.util.List<com.nss.portlet.department.model.Department> findByC_N_D(
        java.lang.String departmentsCode, java.lang.String departmentsName,
        java.lang.String abbreviateName, java.lang.String description,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByC_N_D(departmentsCode, departmentsName,
            abbreviateName, description, start, end, obc);
    }

    public static com.nss.portlet.department.model.Department findByC_N_D_First(
        java.lang.String departmentsCode, java.lang.String departmentsName,
        java.lang.String abbreviateName, java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.department.NoSuchDepartmentException {
        return getPersistence()
                   .findByC_N_D_First(departmentsCode, departmentsName,
            abbreviateName, description, obc);
    }

    public static com.nss.portlet.department.model.Department findByC_N_D_Last(
        java.lang.String departmentsCode, java.lang.String departmentsName,
        java.lang.String abbreviateName, java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.department.NoSuchDepartmentException {
        return getPersistence()
                   .findByC_N_D_Last(departmentsCode, departmentsName,
            abbreviateName, description, obc);
    }

    public static com.nss.portlet.department.model.Department[] findByC_N_D_PrevAndNext(
        java.lang.String departmentsId, java.lang.String departmentsCode,
        java.lang.String departmentsName, java.lang.String abbreviateName,
        java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.department.NoSuchDepartmentException {
        return getPersistence()
                   .findByC_N_D_PrevAndNext(departmentsId, departmentsCode,
            departmentsName, abbreviateName, description, obc);
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

    public static java.util.List<com.nss.portlet.department.model.Department> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.nss.portlet.department.model.Department> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.nss.portlet.department.model.Department> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end, obc);
    }

    public static void removeByActive(java.lang.String active)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByActive(active);
    }

    public static void removeByDepartmentsParentId(
        java.lang.String departmentsParentId)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByDepartmentsParentId(departmentsParentId);
    }

    public static void removeByDepartmentsCode_AgencyId(
        java.lang.String departmentsCode, java.lang.String agencyId)
        throws com.liferay.portal.SystemException {
        getPersistence()
            .removeByDepartmentsCode_AgencyId(departmentsCode, agencyId);
    }

    public static void removeByDepartmentsCode(java.lang.String departmentsCode)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByDepartmentsCode(departmentsCode);
    }

    public static void removeByRoleId(long roleId)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByRoleId(roleId);
    }

    public static void removeByDepartmentsName(java.lang.String departmentsName)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByDepartmentsName(departmentsName);
    }

    public static void removeByAbbreviateName(java.lang.String abbreviateName)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByAbbreviateName(abbreviateName);
    }

    public static void removeByDescription(java.lang.String description)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByDescription(description);
    }

    public static void removeByAgencyId(java.lang.String agencyId)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByAgencyId(agencyId);
    }

    public static void removeByHasTeam(java.lang.String hasTeam)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByHasTeam(hasTeam);
    }

    public static void removeByC_N_D(java.lang.String departmentsCode,
        java.lang.String departmentsName, java.lang.String abbreviateName,
        java.lang.String description) throws com.liferay.portal.SystemException {
        getPersistence()
            .removeByC_N_D(departmentsCode, departmentsName, abbreviateName,
            description);
    }

    public static void removeAll() throws com.liferay.portal.SystemException {
        getPersistence().removeAll();
    }

    public static int countByActive(java.lang.String active)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByActive(active);
    }

    public static int countByDepartmentsParentId(
        java.lang.String departmentsParentId)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByDepartmentsParentId(departmentsParentId);
    }

    public static int countByDepartmentsCode_AgencyId(
        java.lang.String departmentsCode, java.lang.String agencyId)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .countByDepartmentsCode_AgencyId(departmentsCode, agencyId);
    }

    public static int countByDepartmentsCode(java.lang.String departmentsCode)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByDepartmentsCode(departmentsCode);
    }

    public static int countByRoleId(long roleId)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByRoleId(roleId);
    }

    public static int countByDepartmentsName(java.lang.String departmentsName)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByDepartmentsName(departmentsName);
    }

    public static int countByAbbreviateName(java.lang.String abbreviateName)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByAbbreviateName(abbreviateName);
    }

    public static int countByDescription(java.lang.String description)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByDescription(description);
    }

    public static int countByAgencyId(java.lang.String agencyId)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByAgencyId(agencyId);
    }

    public static int countByHasTeam(java.lang.String hasTeam)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByHasTeam(hasTeam);
    }

    public static int countByC_N_D(java.lang.String departmentsCode,
        java.lang.String departmentsName, java.lang.String abbreviateName,
        java.lang.String description) throws com.liferay.portal.SystemException {
        return getPersistence()
                   .countByC_N_D(departmentsCode, departmentsName,
            abbreviateName, description);
    }

    public static int countAll() throws com.liferay.portal.SystemException {
        return getPersistence().countAll();
    }

    public static DepartmentPersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(DepartmentPersistence persistence) {
        _persistence = persistence;
    }
}
