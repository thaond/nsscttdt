package com.nss.portlet.journal.service.persistence;

public class JournalArticleImageUtil {
    private static JournalArticleImagePersistence _persistence;

    public static void cacheResult(
        com.nss.portlet.journal.model.JournalArticleImage journalArticleImage) {
        getPersistence().cacheResult(journalArticleImage);
    }

    public static void cacheResult(
        java.util.List<com.nss.portlet.journal.model.JournalArticleImage> journalArticleImages) {
        getPersistence().cacheResult(journalArticleImages);
    }

    public static void clearCache() {
        getPersistence().clearCache();
    }

    public static com.nss.portlet.journal.model.JournalArticleImage create(
        long articleImageId) {
        return getPersistence().create(articleImageId);
    }

    public static com.nss.portlet.journal.model.JournalArticleImage remove(
        long articleImageId)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchArticleImageException {
        return getPersistence().remove(articleImageId);
    }

    public static com.nss.portlet.journal.model.JournalArticleImage remove(
        com.nss.portlet.journal.model.JournalArticleImage journalArticleImage)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(journalArticleImage);
    }

    /**
     * @deprecated Use <code>update(JournalArticleImage journalArticleImage, boolean merge)</code>.
     */
    public static com.nss.portlet.journal.model.JournalArticleImage update(
        com.nss.portlet.journal.model.JournalArticleImage journalArticleImage)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(journalArticleImage);
    }

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
    public static com.nss.portlet.journal.model.JournalArticleImage update(
        com.nss.portlet.journal.model.JournalArticleImage journalArticleImage,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().update(journalArticleImage, merge);
    }

    public static com.nss.portlet.journal.model.JournalArticleImage updateImpl(
        com.nss.portlet.journal.model.JournalArticleImage journalArticleImage,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(journalArticleImage, merge);
    }

    public static com.nss.portlet.journal.model.JournalArticleImage findByPrimaryKey(
        long articleImageId)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchArticleImageException {
        return getPersistence().findByPrimaryKey(articleImageId);
    }

    public static com.nss.portlet.journal.model.JournalArticleImage fetchByPrimaryKey(
        long articleImageId) throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(articleImageId);
    }

    public static java.util.List<com.nss.portlet.journal.model.JournalArticleImage> findByGroupId(
        long groupId) throws com.liferay.portal.SystemException {
        return getPersistence().findByGroupId(groupId);
    }

    public static java.util.List<com.nss.portlet.journal.model.JournalArticleImage> findByGroupId(
        long groupId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByGroupId(groupId, start, end);
    }

    public static java.util.List<com.nss.portlet.journal.model.JournalArticleImage> findByGroupId(
        long groupId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByGroupId(groupId, start, end, obc);
    }

    public static com.nss.portlet.journal.model.JournalArticleImage findByGroupId_First(
        long groupId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchArticleImageException {
        return getPersistence().findByGroupId_First(groupId, obc);
    }

    public static com.nss.portlet.journal.model.JournalArticleImage findByGroupId_Last(
        long groupId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchArticleImageException {
        return getPersistence().findByGroupId_Last(groupId, obc);
    }

    public static com.nss.portlet.journal.model.JournalArticleImage[] findByGroupId_PrevAndNext(
        long articleImageId, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchArticleImageException {
        return getPersistence()
                   .findByGroupId_PrevAndNext(articleImageId, groupId, obc);
    }

    public static java.util.List<com.nss.portlet.journal.model.JournalArticleImage> findByTempImage(
        boolean tempImage) throws com.liferay.portal.SystemException {
        return getPersistence().findByTempImage(tempImage);
    }

    public static java.util.List<com.nss.portlet.journal.model.JournalArticleImage> findByTempImage(
        boolean tempImage, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByTempImage(tempImage, start, end);
    }

    public static java.util.List<com.nss.portlet.journal.model.JournalArticleImage> findByTempImage(
        boolean tempImage, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByTempImage(tempImage, start, end, obc);
    }

    public static com.nss.portlet.journal.model.JournalArticleImage findByTempImage_First(
        boolean tempImage, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchArticleImageException {
        return getPersistence().findByTempImage_First(tempImage, obc);
    }

    public static com.nss.portlet.journal.model.JournalArticleImage findByTempImage_Last(
        boolean tempImage, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchArticleImageException {
        return getPersistence().findByTempImage_Last(tempImage, obc);
    }

    public static com.nss.portlet.journal.model.JournalArticleImage[] findByTempImage_PrevAndNext(
        long articleImageId, boolean tempImage,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchArticleImageException {
        return getPersistence()
                   .findByTempImage_PrevAndNext(articleImageId, tempImage, obc);
    }

    public static java.util.List<com.nss.portlet.journal.model.JournalArticleImage> findByG_A_V(
        long groupId, java.lang.String articleId, double version)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByG_A_V(groupId, articleId, version);
    }

    public static java.util.List<com.nss.portlet.journal.model.JournalArticleImage> findByG_A_V(
        long groupId, java.lang.String articleId, double version, int start,
        int end) throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByG_A_V(groupId, articleId, version, start, end);
    }

    public static java.util.List<com.nss.portlet.journal.model.JournalArticleImage> findByG_A_V(
        long groupId, java.lang.String articleId, double version, int start,
        int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByG_A_V(groupId, articleId, version, start, end, obc);
    }

    public static com.nss.portlet.journal.model.JournalArticleImage findByG_A_V_First(
        long groupId, java.lang.String articleId, double version,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchArticleImageException {
        return getPersistence()
                   .findByG_A_V_First(groupId, articleId, version, obc);
    }

    public static com.nss.portlet.journal.model.JournalArticleImage findByG_A_V_Last(
        long groupId, java.lang.String articleId, double version,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchArticleImageException {
        return getPersistence()
                   .findByG_A_V_Last(groupId, articleId, version, obc);
    }

    public static com.nss.portlet.journal.model.JournalArticleImage[] findByG_A_V_PrevAndNext(
        long articleImageId, long groupId, java.lang.String articleId,
        double version, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchArticleImageException {
        return getPersistence()
                   .findByG_A_V_PrevAndNext(articleImageId, groupId, articleId,
            version, obc);
    }

    public static com.nss.portlet.journal.model.JournalArticleImage findByG_A_V_E_E_L(
        long groupId, java.lang.String articleId, double version,
        java.lang.String elInstanceId, java.lang.String elName,
        java.lang.String languageId)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchArticleImageException {
        return getPersistence()
                   .findByG_A_V_E_E_L(groupId, articleId, version,
            elInstanceId, elName, languageId);
    }

    public static com.nss.portlet.journal.model.JournalArticleImage fetchByG_A_V_E_E_L(
        long groupId, java.lang.String articleId, double version,
        java.lang.String elInstanceId, java.lang.String elName,
        java.lang.String languageId) throws com.liferay.portal.SystemException {
        return getPersistence()
                   .fetchByG_A_V_E_E_L(groupId, articleId, version,
            elInstanceId, elName, languageId);
    }

    public static com.nss.portlet.journal.model.JournalArticleImage fetchByG_A_V_E_E_L(
        long groupId, java.lang.String articleId, double version,
        java.lang.String elInstanceId, java.lang.String elName,
        java.lang.String languageId, boolean retrieveFromCache)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .fetchByG_A_V_E_E_L(groupId, articleId, version,
            elInstanceId, elName, languageId, retrieveFromCache);
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

    public static java.util.List<com.nss.portlet.journal.model.JournalArticleImage> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.nss.portlet.journal.model.JournalArticleImage> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.nss.portlet.journal.model.JournalArticleImage> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end, obc);
    }

    public static void removeByGroupId(long groupId)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByGroupId(groupId);
    }

    public static void removeByTempImage(boolean tempImage)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByTempImage(tempImage);
    }

    public static void removeByG_A_V(long groupId, java.lang.String articleId,
        double version) throws com.liferay.portal.SystemException {
        getPersistence().removeByG_A_V(groupId, articleId, version);
    }

    public static void removeByG_A_V_E_E_L(long groupId,
        java.lang.String articleId, double version,
        java.lang.String elInstanceId, java.lang.String elName,
        java.lang.String languageId)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchArticleImageException {
        getPersistence()
            .removeByG_A_V_E_E_L(groupId, articleId, version, elInstanceId,
            elName, languageId);
    }

    public static void removeAll() throws com.liferay.portal.SystemException {
        getPersistence().removeAll();
    }

    public static int countByGroupId(long groupId)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByGroupId(groupId);
    }

    public static int countByTempImage(boolean tempImage)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByTempImage(tempImage);
    }

    public static int countByG_A_V(long groupId, java.lang.String articleId,
        double version) throws com.liferay.portal.SystemException {
        return getPersistence().countByG_A_V(groupId, articleId, version);
    }

    public static int countByG_A_V_E_E_L(long groupId,
        java.lang.String articleId, double version,
        java.lang.String elInstanceId, java.lang.String elName,
        java.lang.String languageId) throws com.liferay.portal.SystemException {
        return getPersistence()
                   .countByG_A_V_E_E_L(groupId, articleId, version,
            elInstanceId, elName, languageId);
    }

    public static int countAll() throws com.liferay.portal.SystemException {
        return getPersistence().countAll();
    }

    public static JournalArticleImagePersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(JournalArticleImagePersistence persistence) {
        _persistence = persistence;
    }
}
