package com.sgs.portlet.document.service.persistence;

public class PmlStateDepartmentUtil {
    private static PmlStateDepartmentPersistence _persistence;

    public static com.sgs.portlet.document.model.PmlStateDepartment create(
        com.sgs.portlet.document.service.persistence.PmlStateDepartmentPK pmlStateDepartmentPK) {
        return getPersistence().create(pmlStateDepartmentPK);
    }

    public static com.sgs.portlet.document.model.PmlStateDepartment remove(
        com.sgs.portlet.document.service.persistence.PmlStateDepartmentPK pmlStateDepartmentPK)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlStateDepartmentException {
        return getPersistence().remove(pmlStateDepartmentPK);
    }

    public static com.sgs.portlet.document.model.PmlStateDepartment remove(
        com.sgs.portlet.document.model.PmlStateDepartment pmlStateDepartment)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(pmlStateDepartment);
    }

    /**
     * @deprecated Use <code>update(PmlStateDepartment pmlStateDepartment, boolean merge)</code>.
     */
    public static com.sgs.portlet.document.model.PmlStateDepartment update(
        com.sgs.portlet.document.model.PmlStateDepartment pmlStateDepartment)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(pmlStateDepartment);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlStateDepartment the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlStateDepartment is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public static com.sgs.portlet.document.model.PmlStateDepartment update(
        com.sgs.portlet.document.model.PmlStateDepartment pmlStateDepartment,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().update(pmlStateDepartment, merge);
    }

    public static com.sgs.portlet.document.model.PmlStateDepartment updateImpl(
        com.sgs.portlet.document.model.PmlStateDepartment pmlStateDepartment,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(pmlStateDepartment, merge);
    }

    public static com.sgs.portlet.document.model.PmlStateDepartment findByPrimaryKey(
        com.sgs.portlet.document.service.persistence.PmlStateDepartmentPK pmlStateDepartmentPK)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlStateDepartmentException {
        return getPersistence().findByPrimaryKey(pmlStateDepartmentPK);
    }

    public static com.sgs.portlet.document.model.PmlStateDepartment fetchByPrimaryKey(
        com.sgs.portlet.document.service.persistence.PmlStateDepartmentPK pmlStateDepartmentPK)
        throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(pmlStateDepartmentPK);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlStateDepartment> findByDepartmentId(
        java.lang.String departmentId)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByDepartmentId(departmentId);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlStateDepartment> findByDepartmentId(
        java.lang.String departmentId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByDepartmentId(departmentId, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlStateDepartment> findByDepartmentId(
        java.lang.String departmentId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByDepartmentId(departmentId, start, end, obc);
    }

    public static com.sgs.portlet.document.model.PmlStateDepartment findByDepartmentId_First(
        java.lang.String departmentId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlStateDepartmentException {
        return getPersistence().findByDepartmentId_First(departmentId, obc);
    }

    public static com.sgs.portlet.document.model.PmlStateDepartment findByDepartmentId_Last(
        java.lang.String departmentId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlStateDepartmentException {
        return getPersistence().findByDepartmentId_Last(departmentId, obc);
    }

    public static com.sgs.portlet.document.model.PmlStateDepartment[] findByDepartmentId_PrevAndNext(
        com.sgs.portlet.document.service.persistence.PmlStateDepartmentPK pmlStateDepartmentPK,
        java.lang.String departmentId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlStateDepartmentException {
        return getPersistence()
                   .findByDepartmentId_PrevAndNext(pmlStateDepartmentPK,
            departmentId, obc);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlStateDepartment> findByStateWfId(
        long stateWfId) throws com.liferay.portal.SystemException {
        return getPersistence().findByStateWfId(stateWfId);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlStateDepartment> findByStateWfId(
        long stateWfId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByStateWfId(stateWfId, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlStateDepartment> findByStateWfId(
        long stateWfId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByStateWfId(stateWfId, start, end, obc);
    }

    public static com.sgs.portlet.document.model.PmlStateDepartment findByStateWfId_First(
        long stateWfId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlStateDepartmentException {
        return getPersistence().findByStateWfId_First(stateWfId, obc);
    }

    public static com.sgs.portlet.document.model.PmlStateDepartment findByStateWfId_Last(
        long stateWfId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlStateDepartmentException {
        return getPersistence().findByStateWfId_Last(stateWfId, obc);
    }

    public static com.sgs.portlet.document.model.PmlStateDepartment[] findByStateWfId_PrevAndNext(
        com.sgs.portlet.document.service.persistence.PmlStateDepartmentPK pmlStateDepartmentPK,
        long stateWfId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlStateDepartmentException {
        return getPersistence()
                   .findByStateWfId_PrevAndNext(pmlStateDepartmentPK,
            stateWfId, obc);
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

    public static java.util.List<com.sgs.portlet.document.model.PmlStateDepartment> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlStateDepartment> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlStateDepartment> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end, obc);
    }

    public static void removeByDepartmentId(java.lang.String departmentId)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByDepartmentId(departmentId);
    }

    public static void removeByStateWfId(long stateWfId)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByStateWfId(stateWfId);
    }

    public static void removeAll() throws com.liferay.portal.SystemException {
        getPersistence().removeAll();
    }

    public static int countByDepartmentId(java.lang.String departmentId)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByDepartmentId(departmentId);
    }

    public static int countByStateWfId(long stateWfId)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByStateWfId(stateWfId);
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

    public static PmlStateDepartmentPersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(PmlStateDepartmentPersistence persistence) {
        _persistence = persistence;
    }
}
