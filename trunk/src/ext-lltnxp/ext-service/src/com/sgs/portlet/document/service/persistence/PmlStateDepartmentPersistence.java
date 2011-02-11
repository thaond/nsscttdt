package com.sgs.portlet.document.service.persistence;

public interface PmlStateDepartmentPersistence {
    public com.sgs.portlet.document.model.PmlStateDepartment create(
        com.sgs.portlet.document.service.persistence.PmlStateDepartmentPK pmlStateDepartmentPK);

    public com.sgs.portlet.document.model.PmlStateDepartment remove(
        com.sgs.portlet.document.service.persistence.PmlStateDepartmentPK pmlStateDepartmentPK)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlStateDepartmentException;

    public com.sgs.portlet.document.model.PmlStateDepartment remove(
        com.sgs.portlet.document.model.PmlStateDepartment pmlStateDepartment)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(PmlStateDepartment pmlStateDepartment, boolean merge)</code>.
     */
    public com.sgs.portlet.document.model.PmlStateDepartment update(
        com.sgs.portlet.document.model.PmlStateDepartment pmlStateDepartment)
        throws com.liferay.portal.SystemException;

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
    public com.sgs.portlet.document.model.PmlStateDepartment update(
        com.sgs.portlet.document.model.PmlStateDepartment pmlStateDepartment,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlStateDepartment updateImpl(
        com.sgs.portlet.document.model.PmlStateDepartment pmlStateDepartment,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlStateDepartment findByPrimaryKey(
        com.sgs.portlet.document.service.persistence.PmlStateDepartmentPK pmlStateDepartmentPK)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlStateDepartmentException;

    public com.sgs.portlet.document.model.PmlStateDepartment fetchByPrimaryKey(
        com.sgs.portlet.document.service.persistence.PmlStateDepartmentPK pmlStateDepartmentPK)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlStateDepartment> findByDepartmentId(
        java.lang.String departmentId)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlStateDepartment> findByDepartmentId(
        java.lang.String departmentId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlStateDepartment> findByDepartmentId(
        java.lang.String departmentId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlStateDepartment findByDepartmentId_First(
        java.lang.String departmentId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlStateDepartmentException;

    public com.sgs.portlet.document.model.PmlStateDepartment findByDepartmentId_Last(
        java.lang.String departmentId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlStateDepartmentException;

    public com.sgs.portlet.document.model.PmlStateDepartment[] findByDepartmentId_PrevAndNext(
        com.sgs.portlet.document.service.persistence.PmlStateDepartmentPK pmlStateDepartmentPK,
        java.lang.String departmentId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlStateDepartmentException;

    public java.util.List<com.sgs.portlet.document.model.PmlStateDepartment> findByStateWfId(
        long stateWfId) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlStateDepartment> findByStateWfId(
        long stateWfId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlStateDepartment> findByStateWfId(
        long stateWfId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlStateDepartment findByStateWfId_First(
        long stateWfId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlStateDepartmentException;

    public com.sgs.portlet.document.model.PmlStateDepartment findByStateWfId_Last(
        long stateWfId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlStateDepartmentException;

    public com.sgs.portlet.document.model.PmlStateDepartment[] findByStateWfId_PrevAndNext(
        com.sgs.portlet.document.service.persistence.PmlStateDepartmentPK pmlStateDepartmentPK,
        long stateWfId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlStateDepartmentException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlStateDepartment> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlStateDepartment> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlStateDepartment> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeByDepartmentId(java.lang.String departmentId)
        throws com.liferay.portal.SystemException;

    public void removeByStateWfId(long stateWfId)
        throws com.liferay.portal.SystemException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countByDepartmentId(java.lang.String departmentId)
        throws com.liferay.portal.SystemException;

    public int countByStateWfId(long stateWfId)
        throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;

    public void registerListener(
        com.liferay.portal.model.ModelListener listener);

    public void unregisterListener(
        com.liferay.portal.model.ModelListener listener);
}
