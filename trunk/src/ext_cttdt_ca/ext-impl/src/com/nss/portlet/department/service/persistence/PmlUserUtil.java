package com.nss.portlet.department.service.persistence;

public class PmlUserUtil {
    private static PmlUserPersistence _persistence;

    public static void cacheResult(
        com.nss.portlet.department.model.PmlUser pmlUser) {
        getPersistence().cacheResult(pmlUser);
    }

    public static void cacheResult(
        java.util.List<com.nss.portlet.department.model.PmlUser> pmlUsers) {
        getPersistence().cacheResult(pmlUsers);
    }

    public static void clearCache() {
        getPersistence().clearCache();
    }

    public static com.nss.portlet.department.model.PmlUser create(long userId) {
        return getPersistence().create(userId);
    }

    public static com.nss.portlet.department.model.PmlUser remove(long userId)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.department.NoSuchPmlUserException {
        return getPersistence().remove(userId);
    }

    public static com.nss.portlet.department.model.PmlUser remove(
        com.nss.portlet.department.model.PmlUser pmlUser)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(pmlUser);
    }

    /**
     * @deprecated Use <code>update(PmlUser pmlUser, boolean merge)</code>.
     */
    public static com.nss.portlet.department.model.PmlUser update(
        com.nss.portlet.department.model.PmlUser pmlUser)
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
    public static com.nss.portlet.department.model.PmlUser update(
        com.nss.portlet.department.model.PmlUser pmlUser, boolean merge)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(pmlUser, merge);
    }

    public static com.nss.portlet.department.model.PmlUser updateImpl(
        com.nss.portlet.department.model.PmlUser pmlUser, boolean merge)
        throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(pmlUser, merge);
    }

    public static com.nss.portlet.department.model.PmlUser findByPrimaryKey(
        long userId)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.department.NoSuchPmlUserException {
        return getPersistence().findByPrimaryKey(userId);
    }

    public static com.nss.portlet.department.model.PmlUser fetchByPrimaryKey(
        long userId) throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(userId);
    }

    public static java.util.List<com.nss.portlet.department.model.PmlUser> findByDepartmentsId(
        java.lang.String departmentsId)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByDepartmentsId(departmentsId);
    }

    public static java.util.List<com.nss.portlet.department.model.PmlUser> findByDepartmentsId(
        java.lang.String departmentsId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByDepartmentsId(departmentsId, start, end);
    }

    public static java.util.List<com.nss.portlet.department.model.PmlUser> findByDepartmentsId(
        java.lang.String departmentsId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDepartmentsId(departmentsId, start, end, obc);
    }

    public static com.nss.portlet.department.model.PmlUser findByDepartmentsId_First(
        java.lang.String departmentsId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.department.NoSuchPmlUserException {
        return getPersistence().findByDepartmentsId_First(departmentsId, obc);
    }

    public static com.nss.portlet.department.model.PmlUser findByDepartmentsId_Last(
        java.lang.String departmentsId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.department.NoSuchPmlUserException {
        return getPersistence().findByDepartmentsId_Last(departmentsId, obc);
    }

    public static com.nss.portlet.department.model.PmlUser[] findByDepartmentsId_PrevAndNext(
        long userId, java.lang.String departmentsId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.department.NoSuchPmlUserException {
        return getPersistence()
                   .findByDepartmentsId_PrevAndNext(userId, departmentsId, obc);
    }

    public static java.util.List<com.nss.portlet.department.model.PmlUser> findByPositionId(
        java.lang.String positionId) throws com.liferay.portal.SystemException {
        return getPersistence().findByPositionId(positionId);
    }

    public static java.util.List<com.nss.portlet.department.model.PmlUser> findByPositionId(
        java.lang.String positionId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByPositionId(positionId, start, end);
    }

    public static java.util.List<com.nss.portlet.department.model.PmlUser> findByPositionId(
        java.lang.String positionId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByPositionId(positionId, start, end, obc);
    }

    public static com.nss.portlet.department.model.PmlUser findByPositionId_First(
        java.lang.String positionId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.department.NoSuchPmlUserException {
        return getPersistence().findByPositionId_First(positionId, obc);
    }

    public static com.nss.portlet.department.model.PmlUser findByPositionId_Last(
        java.lang.String positionId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.department.NoSuchPmlUserException {
        return getPersistence().findByPositionId_Last(positionId, obc);
    }

    public static com.nss.portlet.department.model.PmlUser[] findByPositionId_PrevAndNext(
        long userId, java.lang.String positionId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.department.NoSuchPmlUserException {
        return getPersistence()
                   .findByPositionId_PrevAndNext(userId, positionId, obc);
    }

    public static java.util.List<com.nss.portlet.department.model.PmlUser> findByDepartmentsId_PositionId(
        java.lang.String departmentsId, java.lang.String positionId)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDepartmentsId_PositionId(departmentsId, positionId);
    }

    public static java.util.List<com.nss.portlet.department.model.PmlUser> findByDepartmentsId_PositionId(
        java.lang.String departmentsId, java.lang.String positionId, int start,
        int end) throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDepartmentsId_PositionId(departmentsId, positionId,
            start, end);
    }

    public static java.util.List<com.nss.portlet.department.model.PmlUser> findByDepartmentsId_PositionId(
        java.lang.String departmentsId, java.lang.String positionId, int start,
        int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDepartmentsId_PositionId(departmentsId, positionId,
            start, end, obc);
    }

    public static com.nss.portlet.department.model.PmlUser findByDepartmentsId_PositionId_First(
        java.lang.String departmentsId, java.lang.String positionId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.department.NoSuchPmlUserException {
        return getPersistence()
                   .findByDepartmentsId_PositionId_First(departmentsId,
            positionId, obc);
    }

    public static com.nss.portlet.department.model.PmlUser findByDepartmentsId_PositionId_Last(
        java.lang.String departmentsId, java.lang.String positionId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.department.NoSuchPmlUserException {
        return getPersistence()
                   .findByDepartmentsId_PositionId_Last(departmentsId,
            positionId, obc);
    }

    public static com.nss.portlet.department.model.PmlUser[] findByDepartmentsId_PositionId_PrevAndNext(
        long userId, java.lang.String departmentsId,
        java.lang.String positionId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.department.NoSuchPmlUserException {
        return getPersistence()
                   .findByDepartmentsId_PositionId_PrevAndNext(userId,
            departmentsId, positionId, obc);
    }

    public static java.util.List<com.nss.portlet.department.model.PmlUser> findByDepartmentsId_Active(
        java.lang.String departmentsId, java.lang.Boolean active)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByDepartmentsId_Active(departmentsId, active);
    }

    public static java.util.List<com.nss.portlet.department.model.PmlUser> findByDepartmentsId_Active(
        java.lang.String departmentsId, java.lang.Boolean active, int start,
        int end) throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDepartmentsId_Active(departmentsId, active, start, end);
    }

    public static java.util.List<com.nss.portlet.department.model.PmlUser> findByDepartmentsId_Active(
        java.lang.String departmentsId, java.lang.Boolean active, int start,
        int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDepartmentsId_Active(departmentsId, active, start,
            end, obc);
    }

    public static com.nss.portlet.department.model.PmlUser findByDepartmentsId_Active_First(
        java.lang.String departmentsId, java.lang.Boolean active,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.department.NoSuchPmlUserException {
        return getPersistence()
                   .findByDepartmentsId_Active_First(departmentsId, active, obc);
    }

    public static com.nss.portlet.department.model.PmlUser findByDepartmentsId_Active_Last(
        java.lang.String departmentsId, java.lang.Boolean active,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.department.NoSuchPmlUserException {
        return getPersistence()
                   .findByDepartmentsId_Active_Last(departmentsId, active, obc);
    }

    public static com.nss.portlet.department.model.PmlUser[] findByDepartmentsId_Active_PrevAndNext(
        long userId, java.lang.String departmentsId, java.lang.Boolean active,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.department.NoSuchPmlUserException {
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

    public static java.util.List<com.nss.portlet.department.model.PmlUser> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.nss.portlet.department.model.PmlUser> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.nss.portlet.department.model.PmlUser> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end, obc);
    }

    public static void removeByDepartmentsId(java.lang.String departmentsId)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByDepartmentsId(departmentsId);
    }

    public static void removeByPositionId(java.lang.String positionId)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByPositionId(positionId);
    }

    public static void removeByDepartmentsId_PositionId(
        java.lang.String departmentsId, java.lang.String positionId)
        throws com.liferay.portal.SystemException {
        getPersistence()
            .removeByDepartmentsId_PositionId(departmentsId, positionId);
    }

    public static void removeByDepartmentsId_Active(
        java.lang.String departmentsId, java.lang.Boolean active)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByDepartmentsId_Active(departmentsId, active);
    }

    public static void removeAll() throws com.liferay.portal.SystemException {
        getPersistence().removeAll();
    }

    public static int countByDepartmentsId(java.lang.String departmentsId)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByDepartmentsId(departmentsId);
    }

    public static int countByPositionId(java.lang.String positionId)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByPositionId(positionId);
    }

    public static int countByDepartmentsId_PositionId(
        java.lang.String departmentsId, java.lang.String positionId)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .countByDepartmentsId_PositionId(departmentsId, positionId);
    }

    public static int countByDepartmentsId_Active(
        java.lang.String departmentsId, java.lang.Boolean active)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .countByDepartmentsId_Active(departmentsId, active);
    }

    public static int countAll() throws com.liferay.portal.SystemException {
        return getPersistence().countAll();
    }

    public static PmlUserPersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(PmlUserPersistence persistence) {
        _persistence = persistence;
    }
}
