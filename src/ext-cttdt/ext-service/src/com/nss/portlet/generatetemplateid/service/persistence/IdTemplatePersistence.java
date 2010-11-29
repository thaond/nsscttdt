package com.nss.portlet.generatetemplateid.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;


public interface IdTemplatePersistence extends BasePersistence {
    public void cacheResult(
        com.nss.portlet.generatetemplateid.model.IdTemplate idTemplate);

    public void cacheResult(
        java.util.List<com.nss.portlet.generatetemplateid.model.IdTemplate> idTemplates);

    public void clearCache();

    public com.nss.portlet.generatetemplateid.model.IdTemplate create(
        long templateId);

    public com.nss.portlet.generatetemplateid.model.IdTemplate remove(
        long templateId)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.generatetemplateid.NoSuchIdTemplateException;

    public com.nss.portlet.generatetemplateid.model.IdTemplate remove(
        com.nss.portlet.generatetemplateid.model.IdTemplate idTemplate)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(IdTemplate idTemplate, boolean merge)</code>.
     */
    public com.nss.portlet.generatetemplateid.model.IdTemplate update(
        com.nss.portlet.generatetemplateid.model.IdTemplate idTemplate)
        throws com.liferay.portal.SystemException;

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                idTemplate the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when idTemplate is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public com.nss.portlet.generatetemplateid.model.IdTemplate update(
        com.nss.portlet.generatetemplateid.model.IdTemplate idTemplate,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.nss.portlet.generatetemplateid.model.IdTemplate updateImpl(
        com.nss.portlet.generatetemplateid.model.IdTemplate idTemplate,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.nss.portlet.generatetemplateid.model.IdTemplate findByPrimaryKey(
        long templateId)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.generatetemplateid.NoSuchIdTemplateException;

    public com.nss.portlet.generatetemplateid.model.IdTemplate fetchByPrimaryKey(
        long templateId) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.generatetemplateid.model.IdTemplate> findByAllLike(
        java.lang.String format, java.lang.String description)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.generatetemplateid.model.IdTemplate> findByAllLike(
        java.lang.String format, java.lang.String description, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.generatetemplateid.model.IdTemplate> findByAllLike(
        java.lang.String format, java.lang.String description, int start,
        int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.generatetemplateid.model.IdTemplate findByAllLike_First(
        java.lang.String format, java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.generatetemplateid.NoSuchIdTemplateException;

    public com.nss.portlet.generatetemplateid.model.IdTemplate findByAllLike_Last(
        java.lang.String format, java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.generatetemplateid.NoSuchIdTemplateException;

    public com.nss.portlet.generatetemplateid.model.IdTemplate[] findByAllLike_PrevAndNext(
        long templateId, java.lang.String format, java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.generatetemplateid.NoSuchIdTemplateException;

    public java.util.List<com.nss.portlet.generatetemplateid.model.IdTemplate> findByFormat(
        java.lang.String format) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.generatetemplateid.model.IdTemplate> findByFormat(
        java.lang.String format, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.generatetemplateid.model.IdTemplate> findByFormat(
        java.lang.String format, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.generatetemplateid.model.IdTemplate findByFormat_First(
        java.lang.String format,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.generatetemplateid.NoSuchIdTemplateException;

    public com.nss.portlet.generatetemplateid.model.IdTemplate findByFormat_Last(
        java.lang.String format,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.generatetemplateid.NoSuchIdTemplateException;

    public com.nss.portlet.generatetemplateid.model.IdTemplate[] findByFormat_PrevAndNext(
        long templateId, java.lang.String format,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.generatetemplateid.NoSuchIdTemplateException;

    public java.util.List<com.nss.portlet.generatetemplateid.model.IdTemplate> findByFormatLike(
        java.lang.String format) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.generatetemplateid.model.IdTemplate> findByFormatLike(
        java.lang.String format, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.generatetemplateid.model.IdTemplate> findByFormatLike(
        java.lang.String format, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.generatetemplateid.model.IdTemplate findByFormatLike_First(
        java.lang.String format,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.generatetemplateid.NoSuchIdTemplateException;

    public com.nss.portlet.generatetemplateid.model.IdTemplate findByFormatLike_Last(
        java.lang.String format,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.generatetemplateid.NoSuchIdTemplateException;

    public com.nss.portlet.generatetemplateid.model.IdTemplate[] findByFormatLike_PrevAndNext(
        long templateId, java.lang.String format,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.generatetemplateid.NoSuchIdTemplateException;

    public java.util.List<com.nss.portlet.generatetemplateid.model.IdTemplate> findByDescription(
        java.lang.String description) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.generatetemplateid.model.IdTemplate> findByDescription(
        java.lang.String description, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.generatetemplateid.model.IdTemplate> findByDescription(
        java.lang.String description, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.generatetemplateid.model.IdTemplate findByDescription_First(
        java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.generatetemplateid.NoSuchIdTemplateException;

    public com.nss.portlet.generatetemplateid.model.IdTemplate findByDescription_Last(
        java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.generatetemplateid.NoSuchIdTemplateException;

    public com.nss.portlet.generatetemplateid.model.IdTemplate[] findByDescription_PrevAndNext(
        long templateId, java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.generatetemplateid.NoSuchIdTemplateException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.generatetemplateid.model.IdTemplate> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.generatetemplateid.model.IdTemplate> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.generatetemplateid.model.IdTemplate> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeByAllLike(java.lang.String format,
        java.lang.String description) throws com.liferay.portal.SystemException;

    public void removeByFormat(java.lang.String format)
        throws com.liferay.portal.SystemException;

    public void removeByFormatLike(java.lang.String format)
        throws com.liferay.portal.SystemException;

    public void removeByDescription(java.lang.String description)
        throws com.liferay.portal.SystemException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countByAllLike(java.lang.String format,
        java.lang.String description) throws com.liferay.portal.SystemException;

    public int countByFormat(java.lang.String format)
        throws com.liferay.portal.SystemException;

    public int countByFormatLike(java.lang.String format)
        throws com.liferay.portal.SystemException;

    public int countByDescription(java.lang.String description)
        throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;
}
