package com.sgs.portlet.department.service.persistence;

public interface PmlDepartmentHSCVPersistence {
    public com.sgs.portlet.department.model.PmlDepartmentHSCV create(
        long pmlDepartmentHSCVId);

    public com.sgs.portlet.department.model.PmlDepartmentHSCV remove(
        long pmlDepartmentHSCVId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.department.NoSuchPmlDepartmentHSCVException;

    public com.sgs.portlet.department.model.PmlDepartmentHSCV remove(
        com.sgs.portlet.department.model.PmlDepartmentHSCV pmlDepartmentHSCV)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(PmlDepartmentHSCV pmlDepartmentHSCV, boolean merge)</code>.
     */
    public com.sgs.portlet.department.model.PmlDepartmentHSCV update(
        com.sgs.portlet.department.model.PmlDepartmentHSCV pmlDepartmentHSCV)
        throws com.liferay.portal.SystemException;

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
    public com.sgs.portlet.department.model.PmlDepartmentHSCV update(
        com.sgs.portlet.department.model.PmlDepartmentHSCV pmlDepartmentHSCV,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.department.model.PmlDepartmentHSCV updateImpl(
        com.sgs.portlet.department.model.PmlDepartmentHSCV pmlDepartmentHSCV,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.department.model.PmlDepartmentHSCV findByPrimaryKey(
        long pmlDepartmentHSCVId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.department.NoSuchPmlDepartmentHSCVException;

    public com.sgs.portlet.department.model.PmlDepartmentHSCV fetchByPrimaryKey(
        long pmlDepartmentHSCVId) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.department.model.PmlDepartmentHSCV> findByDepartmentsId(
        java.lang.String departmentsId)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.department.model.PmlDepartmentHSCV> findByDepartmentsId(
        java.lang.String departmentsId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.department.model.PmlDepartmentHSCV> findByDepartmentsId(
        java.lang.String departmentsId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.department.model.PmlDepartmentHSCV findByDepartmentsId_First(
        java.lang.String departmentsId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.department.NoSuchPmlDepartmentHSCVException;

    public com.sgs.portlet.department.model.PmlDepartmentHSCV findByDepartmentsId_Last(
        java.lang.String departmentsId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.department.NoSuchPmlDepartmentHSCVException;

    public com.sgs.portlet.department.model.PmlDepartmentHSCV[] findByDepartmentsId_PrevAndNext(
        long pmlDepartmentHSCVId, java.lang.String departmentsId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.department.NoSuchPmlDepartmentHSCVException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.department.model.PmlDepartmentHSCV> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.department.model.PmlDepartmentHSCV> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.department.model.PmlDepartmentHSCV> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeByDepartmentsId(java.lang.String departmentsId)
        throws com.liferay.portal.SystemException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countByDepartmentsId(java.lang.String departmentsId)
        throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;

    public void registerListener(
        com.liferay.portal.model.ModelListener listener);

    public void unregisterListener(
        com.liferay.portal.model.ModelListener listener);
}
