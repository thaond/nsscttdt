package com.sgs.portlet.pml_template.service.persistence;

public class PmlTemplateUtil {
    private static PmlTemplatePersistence _persistence;

    public static com.sgs.portlet.pml_template.model.PmlTemplate create(
        long templateId) {
        return getPersistence().create(templateId);
    }

    public static com.sgs.portlet.pml_template.model.PmlTemplate remove(
        long templateId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pml_template.NoSuchException {
        return getPersistence().remove(templateId);
    }

    public static com.sgs.portlet.pml_template.model.PmlTemplate remove(
        com.sgs.portlet.pml_template.model.PmlTemplate pmlTemplate)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(pmlTemplate);
    }

    /**
     * @deprecated Use <code>update(PmlTemplate pmlTemplate, boolean merge)</code>.
     */
    public static com.sgs.portlet.pml_template.model.PmlTemplate update(
        com.sgs.portlet.pml_template.model.PmlTemplate pmlTemplate)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(pmlTemplate);
    }

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
    public static com.sgs.portlet.pml_template.model.PmlTemplate update(
        com.sgs.portlet.pml_template.model.PmlTemplate pmlTemplate,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().update(pmlTemplate, merge);
    }

    public static com.sgs.portlet.pml_template.model.PmlTemplate updateImpl(
        com.sgs.portlet.pml_template.model.PmlTemplate pmlTemplate,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(pmlTemplate, merge);
    }

    public static com.sgs.portlet.pml_template.model.PmlTemplate findByPrimaryKey(
        long templateId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pml_template.NoSuchException {
        return getPersistence().findByPrimaryKey(templateId);
    }

    public static com.sgs.portlet.pml_template.model.PmlTemplate fetchByPrimaryKey(
        long templateId) throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(templateId);
    }

    public static java.util.List<com.sgs.portlet.pml_template.model.PmlTemplate> findByDepartmentId(
        java.lang.String departmentId)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByDepartmentId(departmentId);
    }

    public static java.util.List<com.sgs.portlet.pml_template.model.PmlTemplate> findByDepartmentId(
        java.lang.String departmentId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByDepartmentId(departmentId, start, end);
    }

    public static java.util.List<com.sgs.portlet.pml_template.model.PmlTemplate> findByDepartmentId(
        java.lang.String departmentId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByDepartmentId(departmentId, start, end, obc);
    }

    public static com.sgs.portlet.pml_template.model.PmlTemplate findByDepartmentId_First(
        java.lang.String departmentId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pml_template.NoSuchException {
        return getPersistence().findByDepartmentId_First(departmentId, obc);
    }

    public static com.sgs.portlet.pml_template.model.PmlTemplate findByDepartmentId_Last(
        java.lang.String departmentId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pml_template.NoSuchException {
        return getPersistence().findByDepartmentId_Last(departmentId, obc);
    }

    public static com.sgs.portlet.pml_template.model.PmlTemplate[] findByDepartmentId_PrevAndNext(
        long templateId, java.lang.String departmentId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pml_template.NoSuchException {
        return getPersistence()
                   .findByDepartmentId_PrevAndNext(templateId, departmentId, obc);
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

    public static java.util.List<com.sgs.portlet.pml_template.model.PmlTemplate> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.sgs.portlet.pml_template.model.PmlTemplate> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.sgs.portlet.pml_template.model.PmlTemplate> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end, obc);
    }

    public static void removeByDepartmentId(java.lang.String departmentId)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByDepartmentId(departmentId);
    }

    public static void removeAll() throws com.liferay.portal.SystemException {
        getPersistence().removeAll();
    }

    public static int countByDepartmentId(java.lang.String departmentId)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByDepartmentId(departmentId);
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

    public static PmlTemplatePersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(PmlTemplatePersistence persistence) {
        _persistence = persistence;
    }
}
