package com.sgs.portlet.pml_template.service.persistence;

public interface PmlTemplatePersistence {
    public com.sgs.portlet.pml_template.model.PmlTemplate create(
        long templateId);

    public com.sgs.portlet.pml_template.model.PmlTemplate remove(
        long templateId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pml_template.NoSuchException;

    public com.sgs.portlet.pml_template.model.PmlTemplate remove(
        com.sgs.portlet.pml_template.model.PmlTemplate pmlTemplate)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(PmlTemplate pmlTemplate, boolean merge)</code>.
     */
    public com.sgs.portlet.pml_template.model.PmlTemplate update(
        com.sgs.portlet.pml_template.model.PmlTemplate pmlTemplate)
        throws com.liferay.portal.SystemException;

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlTemplate the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlTemplate is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public com.sgs.portlet.pml_template.model.PmlTemplate update(
        com.sgs.portlet.pml_template.model.PmlTemplate pmlTemplate,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.pml_template.model.PmlTemplate updateImpl(
        com.sgs.portlet.pml_template.model.PmlTemplate pmlTemplate,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.pml_template.model.PmlTemplate findByPrimaryKey(
        long templateId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pml_template.NoSuchException;

    public com.sgs.portlet.pml_template.model.PmlTemplate fetchByPrimaryKey(
        long templateId) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pml_template.model.PmlTemplate> findByDepartmentId(
        java.lang.String departmentId)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pml_template.model.PmlTemplate> findByDepartmentId(
        java.lang.String departmentId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pml_template.model.PmlTemplate> findByDepartmentId(
        java.lang.String departmentId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.pml_template.model.PmlTemplate findByDepartmentId_First(
        java.lang.String departmentId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pml_template.NoSuchException;

    public com.sgs.portlet.pml_template.model.PmlTemplate findByDepartmentId_Last(
        java.lang.String departmentId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pml_template.NoSuchException;

    public com.sgs.portlet.pml_template.model.PmlTemplate[] findByDepartmentId_PrevAndNext(
        long templateId, java.lang.String departmentId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pml_template.NoSuchException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pml_template.model.PmlTemplate> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pml_template.model.PmlTemplate> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pml_template.model.PmlTemplate> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeByDepartmentId(java.lang.String departmentId)
        throws com.liferay.portal.SystemException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countByDepartmentId(java.lang.String departmentId)
        throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;

    public void registerListener(
        com.liferay.portal.model.ModelListener listener);

    public void unregisterListener(
        com.liferay.portal.model.ModelListener listener);
}
