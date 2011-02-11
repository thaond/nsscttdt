package com.sgs.portlet.pml_template.service.persistence;

public class FileTemplateUtil {
    private static FileTemplatePersistence _persistence;

    public static com.sgs.portlet.pml_template.model.FileTemplate create(
        long fileTemplateId) {
        return getPersistence().create(fileTemplateId);
    }

    public static com.sgs.portlet.pml_template.model.FileTemplate remove(
        long fileTemplateId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pml_template.NoSuchFileTemplateException {
        return getPersistence().remove(fileTemplateId);
    }

    public static com.sgs.portlet.pml_template.model.FileTemplate remove(
        com.sgs.portlet.pml_template.model.FileTemplate fileTemplate)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(fileTemplate);
    }

    /**
     * @deprecated Use <code>update(FileTemplate fileTemplate, boolean merge)</code>.
     */
    public static com.sgs.portlet.pml_template.model.FileTemplate update(
        com.sgs.portlet.pml_template.model.FileTemplate fileTemplate)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(fileTemplate);
    }

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
    public static com.sgs.portlet.pml_template.model.FileTemplate update(
        com.sgs.portlet.pml_template.model.FileTemplate fileTemplate,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().update(fileTemplate, merge);
    }

    public static com.sgs.portlet.pml_template.model.FileTemplate updateImpl(
        com.sgs.portlet.pml_template.model.FileTemplate fileTemplate,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(fileTemplate, merge);
    }

    public static com.sgs.portlet.pml_template.model.FileTemplate findByPrimaryKey(
        long fileTemplateId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pml_template.NoSuchFileTemplateException {
        return getPersistence().findByPrimaryKey(fileTemplateId);
    }

    public static com.sgs.portlet.pml_template.model.FileTemplate fetchByPrimaryKey(
        long fileTemplateId) throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(fileTemplateId);
    }

    public static java.util.List<com.sgs.portlet.pml_template.model.FileTemplate> findByTemplateId(
        long templateId) throws com.liferay.portal.SystemException {
        return getPersistence().findByTemplateId(templateId);
    }

    public static java.util.List<com.sgs.portlet.pml_template.model.FileTemplate> findByTemplateId(
        long templateId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByTemplateId(templateId, start, end);
    }

    public static java.util.List<com.sgs.portlet.pml_template.model.FileTemplate> findByTemplateId(
        long templateId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByTemplateId(templateId, start, end, obc);
    }

    public static com.sgs.portlet.pml_template.model.FileTemplate findByTemplateId_First(
        long templateId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pml_template.NoSuchFileTemplateException {
        return getPersistence().findByTemplateId_First(templateId, obc);
    }

    public static com.sgs.portlet.pml_template.model.FileTemplate findByTemplateId_Last(
        long templateId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pml_template.NoSuchFileTemplateException {
        return getPersistence().findByTemplateId_Last(templateId, obc);
    }

    public static com.sgs.portlet.pml_template.model.FileTemplate[] findByTemplateId_PrevAndNext(
        long fileTemplateId, long templateId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pml_template.NoSuchFileTemplateException {
        return getPersistence()
                   .findByTemplateId_PrevAndNext(fileTemplateId, templateId, obc);
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

    public static java.util.List<com.sgs.portlet.pml_template.model.FileTemplate> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.sgs.portlet.pml_template.model.FileTemplate> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.sgs.portlet.pml_template.model.FileTemplate> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end, obc);
    }

    public static void removeByTemplateId(long templateId)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByTemplateId(templateId);
    }

    public static void removeAll() throws com.liferay.portal.SystemException {
        getPersistence().removeAll();
    }

    public static int countByTemplateId(long templateId)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByTemplateId(templateId);
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

    public static FileTemplatePersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(FileTemplatePersistence persistence) {
        _persistence = persistence;
    }
}
