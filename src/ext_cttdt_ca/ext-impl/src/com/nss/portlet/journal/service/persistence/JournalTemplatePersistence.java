package com.nss.portlet.journal.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;


public interface JournalTemplatePersistence extends BasePersistence {
    public void cacheResult(
        com.nss.portlet.journal.model.JournalTemplate journalTemplate);

    public void cacheResult(
        java.util.List<com.nss.portlet.journal.model.JournalTemplate> journalTemplates);

    public void clearCache();

    public com.nss.portlet.journal.model.JournalTemplate create(long id);

    public com.nss.portlet.journal.model.JournalTemplate remove(long id)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchTemplateException;

    public com.nss.portlet.journal.model.JournalTemplate remove(
        com.nss.portlet.journal.model.JournalTemplate journalTemplate)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(JournalTemplate journalTemplate, boolean merge)</code>.
     */
    public com.nss.portlet.journal.model.JournalTemplate update(
        com.nss.portlet.journal.model.JournalTemplate journalTemplate)
        throws com.liferay.portal.SystemException;

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                journalTemplate the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when journalTemplate is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public com.nss.portlet.journal.model.JournalTemplate update(
        com.nss.portlet.journal.model.JournalTemplate journalTemplate,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.nss.portlet.journal.model.JournalTemplate updateImpl(
        com.nss.portlet.journal.model.JournalTemplate journalTemplate,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.nss.portlet.journal.model.JournalTemplate findByPrimaryKey(
        long id)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchTemplateException;

    public com.nss.portlet.journal.model.JournalTemplate fetchByPrimaryKey(
        long id) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.journal.model.JournalTemplate> findByUuid(
        java.lang.String uuid) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.journal.model.JournalTemplate> findByUuid(
        java.lang.String uuid, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.journal.model.JournalTemplate> findByUuid(
        java.lang.String uuid, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.journal.model.JournalTemplate findByUuid_First(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchTemplateException;

    public com.nss.portlet.journal.model.JournalTemplate findByUuid_Last(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchTemplateException;

    public com.nss.portlet.journal.model.JournalTemplate[] findByUuid_PrevAndNext(
        long id, java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchTemplateException;

    public com.nss.portlet.journal.model.JournalTemplate findByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchTemplateException;

    public com.nss.portlet.journal.model.JournalTemplate fetchByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.journal.model.JournalTemplate fetchByUUID_G(
        java.lang.String uuid, long groupId, boolean retrieveFromCache)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.journal.model.JournalTemplate> findByGroupId(
        long groupId) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.journal.model.JournalTemplate> findByGroupId(
        long groupId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.journal.model.JournalTemplate> findByGroupId(
        long groupId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.journal.model.JournalTemplate findByGroupId_First(
        long groupId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchTemplateException;

    public com.nss.portlet.journal.model.JournalTemplate findByGroupId_Last(
        long groupId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchTemplateException;

    public com.nss.portlet.journal.model.JournalTemplate[] findByGroupId_PrevAndNext(
        long id, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchTemplateException;

    public java.util.List<com.nss.portlet.journal.model.JournalTemplate> findByTemplateId(
        java.lang.String templateId) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.journal.model.JournalTemplate> findByTemplateId(
        java.lang.String templateId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.journal.model.JournalTemplate> findByTemplateId(
        java.lang.String templateId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.journal.model.JournalTemplate findByTemplateId_First(
        java.lang.String templateId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchTemplateException;

    public com.nss.portlet.journal.model.JournalTemplate findByTemplateId_Last(
        java.lang.String templateId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchTemplateException;

    public com.nss.portlet.journal.model.JournalTemplate[] findByTemplateId_PrevAndNext(
        long id, java.lang.String templateId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchTemplateException;

    public com.nss.portlet.journal.model.JournalTemplate findBySmallImageId(
        long smallImageId)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchTemplateException;

    public com.nss.portlet.journal.model.JournalTemplate fetchBySmallImageId(
        long smallImageId) throws com.liferay.portal.SystemException;

    public com.nss.portlet.journal.model.JournalTemplate fetchBySmallImageId(
        long smallImageId, boolean retrieveFromCache)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.journal.model.JournalTemplate findByG_T(
        long groupId, java.lang.String templateId)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchTemplateException;

    public com.nss.portlet.journal.model.JournalTemplate fetchByG_T(
        long groupId, java.lang.String templateId)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.journal.model.JournalTemplate fetchByG_T(
        long groupId, java.lang.String templateId, boolean retrieveFromCache)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.journal.model.JournalTemplate> findByG_S(
        long groupId, java.lang.String structureId)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.journal.model.JournalTemplate> findByG_S(
        long groupId, java.lang.String structureId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.journal.model.JournalTemplate> findByG_S(
        long groupId, java.lang.String structureId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.journal.model.JournalTemplate findByG_S_First(
        long groupId, java.lang.String structureId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchTemplateException;

    public com.nss.portlet.journal.model.JournalTemplate findByG_S_Last(
        long groupId, java.lang.String structureId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchTemplateException;

    public com.nss.portlet.journal.model.JournalTemplate[] findByG_S_PrevAndNext(
        long id, long groupId, java.lang.String structureId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchTemplateException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.journal.model.JournalTemplate> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.journal.model.JournalTemplate> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.journal.model.JournalTemplate> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeByUuid(java.lang.String uuid)
        throws com.liferay.portal.SystemException;

    public void removeByUUID_G(java.lang.String uuid, long groupId)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchTemplateException;

    public void removeByGroupId(long groupId)
        throws com.liferay.portal.SystemException;

    public void removeByTemplateId(java.lang.String templateId)
        throws com.liferay.portal.SystemException;

    public void removeBySmallImageId(long smallImageId)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchTemplateException;

    public void removeByG_T(long groupId, java.lang.String templateId)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchTemplateException;

    public void removeByG_S(long groupId, java.lang.String structureId)
        throws com.liferay.portal.SystemException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countByUuid(java.lang.String uuid)
        throws com.liferay.portal.SystemException;

    public int countByUUID_G(java.lang.String uuid, long groupId)
        throws com.liferay.portal.SystemException;

    public int countByGroupId(long groupId)
        throws com.liferay.portal.SystemException;

    public int countByTemplateId(java.lang.String templateId)
        throws com.liferay.portal.SystemException;

    public int countBySmallImageId(long smallImageId)
        throws com.liferay.portal.SystemException;

    public int countByG_T(long groupId, java.lang.String templateId)
        throws com.liferay.portal.SystemException;

    public int countByG_S(long groupId, java.lang.String structureId)
        throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;
}
