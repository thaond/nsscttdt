package com.nss.portlet.journal.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;


public interface JournalArticleImagePersistence extends BasePersistence {
    public void cacheResult(
        com.nss.portlet.journal.model.JournalArticleImage journalArticleImage);

    public void cacheResult(
        java.util.List<com.nss.portlet.journal.model.JournalArticleImage> journalArticleImages);

    public void clearCache();

    public com.nss.portlet.journal.model.JournalArticleImage create(
        long articleImageId);

    public com.nss.portlet.journal.model.JournalArticleImage remove(
        long articleImageId)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchArticleImageException;

    public com.nss.portlet.journal.model.JournalArticleImage remove(
        com.nss.portlet.journal.model.JournalArticleImage journalArticleImage)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(JournalArticleImage journalArticleImage, boolean merge)</code>.
     */
    public com.nss.portlet.journal.model.JournalArticleImage update(
        com.nss.portlet.journal.model.JournalArticleImage journalArticleImage)
        throws com.liferay.portal.SystemException;

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                journalArticleImage the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when journalArticleImage is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public com.nss.portlet.journal.model.JournalArticleImage update(
        com.nss.portlet.journal.model.JournalArticleImage journalArticleImage,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.nss.portlet.journal.model.JournalArticleImage updateImpl(
        com.nss.portlet.journal.model.JournalArticleImage journalArticleImage,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.nss.portlet.journal.model.JournalArticleImage findByPrimaryKey(
        long articleImageId)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchArticleImageException;

    public com.nss.portlet.journal.model.JournalArticleImage fetchByPrimaryKey(
        long articleImageId) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.journal.model.JournalArticleImage> findByGroupId(
        long groupId) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.journal.model.JournalArticleImage> findByGroupId(
        long groupId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.journal.model.JournalArticleImage> findByGroupId(
        long groupId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.journal.model.JournalArticleImage findByGroupId_First(
        long groupId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchArticleImageException;

    public com.nss.portlet.journal.model.JournalArticleImage findByGroupId_Last(
        long groupId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchArticleImageException;

    public com.nss.portlet.journal.model.JournalArticleImage[] findByGroupId_PrevAndNext(
        long articleImageId, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchArticleImageException;

    public java.util.List<com.nss.portlet.journal.model.JournalArticleImage> findByTempImage(
        boolean tempImage) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.journal.model.JournalArticleImage> findByTempImage(
        boolean tempImage, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.journal.model.JournalArticleImage> findByTempImage(
        boolean tempImage, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.journal.model.JournalArticleImage findByTempImage_First(
        boolean tempImage, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchArticleImageException;

    public com.nss.portlet.journal.model.JournalArticleImage findByTempImage_Last(
        boolean tempImage, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchArticleImageException;

    public com.nss.portlet.journal.model.JournalArticleImage[] findByTempImage_PrevAndNext(
        long articleImageId, boolean tempImage,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchArticleImageException;

    public java.util.List<com.nss.portlet.journal.model.JournalArticleImage> findByG_A_V(
        long groupId, java.lang.String articleId, double version)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.journal.model.JournalArticleImage> findByG_A_V(
        long groupId, java.lang.String articleId, double version, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.journal.model.JournalArticleImage> findByG_A_V(
        long groupId, java.lang.String articleId, double version, int start,
        int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.journal.model.JournalArticleImage findByG_A_V_First(
        long groupId, java.lang.String articleId, double version,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchArticleImageException;

    public com.nss.portlet.journal.model.JournalArticleImage findByG_A_V_Last(
        long groupId, java.lang.String articleId, double version,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchArticleImageException;

    public com.nss.portlet.journal.model.JournalArticleImage[] findByG_A_V_PrevAndNext(
        long articleImageId, long groupId, java.lang.String articleId,
        double version, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchArticleImageException;

    public com.nss.portlet.journal.model.JournalArticleImage findByG_A_V_E_E_L(
        long groupId, java.lang.String articleId, double version,
        java.lang.String elInstanceId, java.lang.String elName,
        java.lang.String languageId)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchArticleImageException;

    public com.nss.portlet.journal.model.JournalArticleImage fetchByG_A_V_E_E_L(
        long groupId, java.lang.String articleId, double version,
        java.lang.String elInstanceId, java.lang.String elName,
        java.lang.String languageId) throws com.liferay.portal.SystemException;

    public com.nss.portlet.journal.model.JournalArticleImage fetchByG_A_V_E_E_L(
        long groupId, java.lang.String articleId, double version,
        java.lang.String elInstanceId, java.lang.String elName,
        java.lang.String languageId, boolean retrieveFromCache)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.journal.model.JournalArticleImage> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.journal.model.JournalArticleImage> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.journal.model.JournalArticleImage> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeByGroupId(long groupId)
        throws com.liferay.portal.SystemException;

    public void removeByTempImage(boolean tempImage)
        throws com.liferay.portal.SystemException;

    public void removeByG_A_V(long groupId, java.lang.String articleId,
        double version) throws com.liferay.portal.SystemException;

    public void removeByG_A_V_E_E_L(long groupId, java.lang.String articleId,
        double version, java.lang.String elInstanceId, java.lang.String elName,
        java.lang.String languageId)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchArticleImageException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countByGroupId(long groupId)
        throws com.liferay.portal.SystemException;

    public int countByTempImage(boolean tempImage)
        throws com.liferay.portal.SystemException;

    public int countByG_A_V(long groupId, java.lang.String articleId,
        double version) throws com.liferay.portal.SystemException;

    public int countByG_A_V_E_E_L(long groupId, java.lang.String articleId,
        double version, java.lang.String elInstanceId, java.lang.String elName,
        java.lang.String languageId) throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;
}
