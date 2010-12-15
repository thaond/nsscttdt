package com.nss.portlet.generatetemplateid.service.persistence;

public class IdTemplateUtil {
    private static IdTemplatePersistence _persistence;

    public static void cacheResult(
        com.nss.portlet.generatetemplateid.model.IdTemplate idTemplate) {
        getPersistence().cacheResult(idTemplate);
    }

    public static void cacheResult(
        java.util.List<com.nss.portlet.generatetemplateid.model.IdTemplate> idTemplates) {
        getPersistence().cacheResult(idTemplates);
    }

    public static void clearCache() {
        getPersistence().clearCache();
    }

    public static com.nss.portlet.generatetemplateid.model.IdTemplate create(
        long templateId) {
        return getPersistence().create(templateId);
    }

    public static com.nss.portlet.generatetemplateid.model.IdTemplate remove(
        long templateId)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.generatetemplateid.NoSuchIdTemplateException {
        return getPersistence().remove(templateId);
    }

    public static com.nss.portlet.generatetemplateid.model.IdTemplate remove(
        com.nss.portlet.generatetemplateid.model.IdTemplate idTemplate)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(idTemplate);
    }

    /**
     * @deprecated Use <code>update(IdTemplate idTemplate, boolean merge)</code>.
     */
    public static com.nss.portlet.generatetemplateid.model.IdTemplate update(
        com.nss.portlet.generatetemplateid.model.IdTemplate idTemplate)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(idTemplate);
    }

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
    public static com.nss.portlet.generatetemplateid.model.IdTemplate update(
        com.nss.portlet.generatetemplateid.model.IdTemplate idTemplate,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().update(idTemplate, merge);
    }

    public static com.nss.portlet.generatetemplateid.model.IdTemplate updateImpl(
        com.nss.portlet.generatetemplateid.model.IdTemplate idTemplate,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(idTemplate, merge);
    }

    public static com.nss.portlet.generatetemplateid.model.IdTemplate findByPrimaryKey(
        long templateId)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.generatetemplateid.NoSuchIdTemplateException {
        return getPersistence().findByPrimaryKey(templateId);
    }

    public static com.nss.portlet.generatetemplateid.model.IdTemplate fetchByPrimaryKey(
        long templateId) throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(templateId);
    }

    public static java.util.List<com.nss.portlet.generatetemplateid.model.IdTemplate> findByAllLike(
        java.lang.String format, java.lang.String description)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByAllLike(format, description);
    }

    public static java.util.List<com.nss.portlet.generatetemplateid.model.IdTemplate> findByAllLike(
        java.lang.String format, java.lang.String description, int start,
        int end) throws com.liferay.portal.SystemException {
        return getPersistence().findByAllLike(format, description, start, end);
    }

    public static java.util.List<com.nss.portlet.generatetemplateid.model.IdTemplate> findByAllLike(
        java.lang.String format, java.lang.String description, int start,
        int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByAllLike(format, description, start, end, obc);
    }

    public static com.nss.portlet.generatetemplateid.model.IdTemplate findByAllLike_First(
        java.lang.String format, java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.generatetemplateid.NoSuchIdTemplateException {
        return getPersistence().findByAllLike_First(format, description, obc);
    }

    public static com.nss.portlet.generatetemplateid.model.IdTemplate findByAllLike_Last(
        java.lang.String format, java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.generatetemplateid.NoSuchIdTemplateException {
        return getPersistence().findByAllLike_Last(format, description, obc);
    }

    public static com.nss.portlet.generatetemplateid.model.IdTemplate[] findByAllLike_PrevAndNext(
        long templateId, java.lang.String format, java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.generatetemplateid.NoSuchIdTemplateException {
        return getPersistence()
                   .findByAllLike_PrevAndNext(templateId, format, description,
            obc);
    }

    public static java.util.List<com.nss.portlet.generatetemplateid.model.IdTemplate> findByFormat(
        java.lang.String format) throws com.liferay.portal.SystemException {
        return getPersistence().findByFormat(format);
    }

    public static java.util.List<com.nss.portlet.generatetemplateid.model.IdTemplate> findByFormat(
        java.lang.String format, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByFormat(format, start, end);
    }

    public static java.util.List<com.nss.portlet.generatetemplateid.model.IdTemplate> findByFormat(
        java.lang.String format, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByFormat(format, start, end, obc);
    }

    public static com.nss.portlet.generatetemplateid.model.IdTemplate findByFormat_First(
        java.lang.String format,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.generatetemplateid.NoSuchIdTemplateException {
        return getPersistence().findByFormat_First(format, obc);
    }

    public static com.nss.portlet.generatetemplateid.model.IdTemplate findByFormat_Last(
        java.lang.String format,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.generatetemplateid.NoSuchIdTemplateException {
        return getPersistence().findByFormat_Last(format, obc);
    }

    public static com.nss.portlet.generatetemplateid.model.IdTemplate[] findByFormat_PrevAndNext(
        long templateId, java.lang.String format,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.generatetemplateid.NoSuchIdTemplateException {
        return getPersistence().findByFormat_PrevAndNext(templateId, format, obc);
    }

    public static java.util.List<com.nss.portlet.generatetemplateid.model.IdTemplate> findByFormatLike(
        java.lang.String format) throws com.liferay.portal.SystemException {
        return getPersistence().findByFormatLike(format);
    }

    public static java.util.List<com.nss.portlet.generatetemplateid.model.IdTemplate> findByFormatLike(
        java.lang.String format, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByFormatLike(format, start, end);
    }

    public static java.util.List<com.nss.portlet.generatetemplateid.model.IdTemplate> findByFormatLike(
        java.lang.String format, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByFormatLike(format, start, end, obc);
    }

    public static com.nss.portlet.generatetemplateid.model.IdTemplate findByFormatLike_First(
        java.lang.String format,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.generatetemplateid.NoSuchIdTemplateException {
        return getPersistence().findByFormatLike_First(format, obc);
    }

    public static com.nss.portlet.generatetemplateid.model.IdTemplate findByFormatLike_Last(
        java.lang.String format,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.generatetemplateid.NoSuchIdTemplateException {
        return getPersistence().findByFormatLike_Last(format, obc);
    }

    public static com.nss.portlet.generatetemplateid.model.IdTemplate[] findByFormatLike_PrevAndNext(
        long templateId, java.lang.String format,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.generatetemplateid.NoSuchIdTemplateException {
        return getPersistence()
                   .findByFormatLike_PrevAndNext(templateId, format, obc);
    }

    public static java.util.List<com.nss.portlet.generatetemplateid.model.IdTemplate> findByDescription(
        java.lang.String description) throws com.liferay.portal.SystemException {
        return getPersistence().findByDescription(description);
    }

    public static java.util.List<com.nss.portlet.generatetemplateid.model.IdTemplate> findByDescription(
        java.lang.String description, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByDescription(description, start, end);
    }

    public static java.util.List<com.nss.portlet.generatetemplateid.model.IdTemplate> findByDescription(
        java.lang.String description, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByDescription(description, start, end, obc);
    }

    public static com.nss.portlet.generatetemplateid.model.IdTemplate findByDescription_First(
        java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.generatetemplateid.NoSuchIdTemplateException {
        return getPersistence().findByDescription_First(description, obc);
    }

    public static com.nss.portlet.generatetemplateid.model.IdTemplate findByDescription_Last(
        java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.generatetemplateid.NoSuchIdTemplateException {
        return getPersistence().findByDescription_Last(description, obc);
    }

    public static com.nss.portlet.generatetemplateid.model.IdTemplate[] findByDescription_PrevAndNext(
        long templateId, java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.generatetemplateid.NoSuchIdTemplateException {
        return getPersistence()
                   .findByDescription_PrevAndNext(templateId, description, obc);
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

    public static java.util.List<com.nss.portlet.generatetemplateid.model.IdTemplate> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.nss.portlet.generatetemplateid.model.IdTemplate> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.nss.portlet.generatetemplateid.model.IdTemplate> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end, obc);
    }

    public static void removeByAllLike(java.lang.String format,
        java.lang.String description) throws com.liferay.portal.SystemException {
        getPersistence().removeByAllLike(format, description);
    }

    public static void removeByFormat(java.lang.String format)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByFormat(format);
    }

    public static void removeByFormatLike(java.lang.String format)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByFormatLike(format);
    }

    public static void removeByDescription(java.lang.String description)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByDescription(description);
    }

    public static void removeAll() throws com.liferay.portal.SystemException {
        getPersistence().removeAll();
    }

    public static int countByAllLike(java.lang.String format,
        java.lang.String description) throws com.liferay.portal.SystemException {
        return getPersistence().countByAllLike(format, description);
    }

    public static int countByFormat(java.lang.String format)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByFormat(format);
    }

    public static int countByFormatLike(java.lang.String format)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByFormatLike(format);
    }

    public static int countByDescription(java.lang.String description)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByDescription(description);
    }

    public static int countAll() throws com.liferay.portal.SystemException {
        return getPersistence().countAll();
    }

    public static IdTemplatePersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(IdTemplatePersistence persistence) {
        _persistence = persistence;
    }
}
