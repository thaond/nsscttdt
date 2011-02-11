package com.sgs.portlet.pml_template.service.persistence;

public interface FileTemplatePersistence {
    public com.sgs.portlet.pml_template.model.FileTemplate create(
        long fileTemplateId);

    public com.sgs.portlet.pml_template.model.FileTemplate remove(
        long fileTemplateId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pml_template.NoSuchFileTemplateException;

    public com.sgs.portlet.pml_template.model.FileTemplate remove(
        com.sgs.portlet.pml_template.model.FileTemplate fileTemplate)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(FileTemplate fileTemplate, boolean merge)</code>.
     */
    public com.sgs.portlet.pml_template.model.FileTemplate update(
        com.sgs.portlet.pml_template.model.FileTemplate fileTemplate)
        throws com.liferay.portal.SystemException;

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                fileTemplate the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when fileTemplate is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public com.sgs.portlet.pml_template.model.FileTemplate update(
        com.sgs.portlet.pml_template.model.FileTemplate fileTemplate,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.pml_template.model.FileTemplate updateImpl(
        com.sgs.portlet.pml_template.model.FileTemplate fileTemplate,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.pml_template.model.FileTemplate findByPrimaryKey(
        long fileTemplateId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pml_template.NoSuchFileTemplateException;

    public com.sgs.portlet.pml_template.model.FileTemplate fetchByPrimaryKey(
        long fileTemplateId) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pml_template.model.FileTemplate> findByTemplateId(
        long templateId) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pml_template.model.FileTemplate> findByTemplateId(
        long templateId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pml_template.model.FileTemplate> findByTemplateId(
        long templateId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.pml_template.model.FileTemplate findByTemplateId_First(
        long templateId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pml_template.NoSuchFileTemplateException;

    public com.sgs.portlet.pml_template.model.FileTemplate findByTemplateId_Last(
        long templateId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pml_template.NoSuchFileTemplateException;

    public com.sgs.portlet.pml_template.model.FileTemplate[] findByTemplateId_PrevAndNext(
        long fileTemplateId, long templateId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pml_template.NoSuchFileTemplateException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pml_template.model.FileTemplate> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pml_template.model.FileTemplate> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pml_template.model.FileTemplate> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeByTemplateId(long templateId)
        throws com.liferay.portal.SystemException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countByTemplateId(long templateId)
        throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;

    public void registerListener(
        com.liferay.portal.model.ModelListener listener);

    public void unregisterListener(
        com.liferay.portal.model.ModelListener listener);
}
