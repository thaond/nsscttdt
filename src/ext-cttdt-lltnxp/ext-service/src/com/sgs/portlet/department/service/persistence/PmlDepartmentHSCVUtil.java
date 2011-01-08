package com.sgs.portlet.department.service.persistence;

public class PmlDepartmentHSCVUtil {
    private static PmlDepartmentHSCVPersistence _persistence;

    public static com.sgs.portlet.department.model.PmlDepartmentHSCV create(
        long pmlDepartmentHSCVId) {
        return getPersistence().create(pmlDepartmentHSCVId);
    }

    public static com.sgs.portlet.department.model.PmlDepartmentHSCV remove(
        long pmlDepartmentHSCVId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.department.NoSuchPmlDepartmentHSCVException {
        return getPersistence().remove(pmlDepartmentHSCVId);
    }

    public static com.sgs.portlet.department.model.PmlDepartmentHSCV remove(
        com.sgs.portlet.department.model.PmlDepartmentHSCV pmlDepartmentHSCV)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(pmlDepartmentHSCV);
    }

    /**
     * @deprecated Use <code>update(PmlDepartmentHSCV pmlDepartmentHSCV, boolean merge)</code>.
     */
    public static com.sgs.portlet.department.model.PmlDepartmentHSCV update(
        com.sgs.portlet.department.model.PmlDepartmentHSCV pmlDepartmentHSCV)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(pmlDepartmentHSCV);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlDepartmentHSCV the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlDepartmentHSCV is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public static com.sgs.portlet.department.model.PmlDepartmentHSCV update(
        com.sgs.portlet.department.model.PmlDepartmentHSCV pmlDepartmentHSCV,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().update(pmlDepartmentHSCV, merge);
    }

    public static com.sgs.portlet.department.model.PmlDepartmentHSCV updateImpl(
        com.sgs.portlet.department.model.PmlDepartmentHSCV pmlDepartmentHSCV,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(pmlDepartmentHSCV, merge);
    }

    public static com.sgs.portlet.department.model.PmlDepartmentHSCV findByPrimaryKey(
        long pmlDepartmentHSCVId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.department.NoSuchPmlDepartmentHSCVException {
        return getPersistence().findByPrimaryKey(pmlDepartmentHSCVId);
    }

    public static com.sgs.portlet.department.model.PmlDepartmentHSCV fetchByPrimaryKey(
        long pmlDepartmentHSCVId) throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(pmlDepartmentHSCVId);
    }

    public static java.util.List<com.sgs.portlet.department.model.PmlDepartmentHSCV> findByDepartmentsId(
        java.lang.String departmentsId)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByDepartmentsId(departmentsId);
    }

    public static java.util.List<com.sgs.portlet.department.model.PmlDepartmentHSCV> findByDepartmentsId(
        java.lang.String departmentsId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByDepartmentsId(departmentsId, start, end);
    }

    public static java.util.List<com.sgs.portlet.department.model.PmlDepartmentHSCV> findByDepartmentsId(
        java.lang.String departmentsId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDepartmentsId(departmentsId, start, end, obc);
    }

    public static com.sgs.portlet.department.model.PmlDepartmentHSCV findByDepartmentsId_First(
        java.lang.String departmentsId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.department.NoSuchPmlDepartmentHSCVException {
        return getPersistence().findByDepartmentsId_First(departmentsId, obc);
    }

    public static com.sgs.portlet.department.model.PmlDepartmentHSCV findByDepartmentsId_Last(
        java.lang.String departmentsId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.department.NoSuchPmlDepartmentHSCVException {
        return getPersistence().findByDepartmentsId_Last(departmentsId, obc);
    }

    public static com.sgs.portlet.department.model.PmlDepartmentHSCV[] findByDepartmentsId_PrevAndNext(
        long pmlDepartmentHSCVId, java.lang.String departmentsId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.department.NoSuchPmlDepartmentHSCVException {
        return getPersistence()
                   .findByDepartmentsId_PrevAndNext(pmlDepartmentHSCVId,
            departmentsId, obc);
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

    public static java.util.List<com.sgs.portlet.department.model.PmlDepartmentHSCV> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.sgs.portlet.department.model.PmlDepartmentHSCV> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.sgs.portlet.department.model.PmlDepartmentHSCV> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end, obc);
    }

    public static void removeByDepartmentsId(java.lang.String departmentsId)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByDepartmentsId(departmentsId);
    }

    public static void removeAll() throws com.liferay.portal.SystemException {
        getPersistence().removeAll();
    }

    public static int countByDepartmentsId(java.lang.String departmentsId)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByDepartmentsId(departmentsId);
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

    public static PmlDepartmentHSCVPersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(PmlDepartmentHSCVPersistence persistence) {
        _persistence = persistence;
    }
}
