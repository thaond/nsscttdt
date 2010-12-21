package com.nss.portlet.permissonuserbyfile.service.persistence;

public class PmlUserFileTypeUtil {
    private static PmlUserFileTypePersistence _persistence;

    public static void cacheResult(
        com.nss.portlet.permissonuserbyfile.model.PmlUserFileType pmlUserFileType) {
        getPersistence().cacheResult(pmlUserFileType);
    }

    public static void cacheResult(
        java.util.List<com.nss.portlet.permissonuserbyfile.model.PmlUserFileType> pmlUserFileTypes) {
        getPersistence().cacheResult(pmlUserFileTypes);
    }

    public static void clearCache() {
        getPersistence().clearCache();
    }

    public static com.nss.portlet.permissonuserbyfile.model.PmlUserFileType create(
        com.nss.portlet.permissonuserbyfile.service.persistence.PmlUserFileTypePK pmlUserFileTypePK) {
        return getPersistence().create(pmlUserFileTypePK);
    }

    public static com.nss.portlet.permissonuserbyfile.model.PmlUserFileType remove(
        com.nss.portlet.permissonuserbyfile.service.persistence.PmlUserFileTypePK pmlUserFileTypePK)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.permissonuserbyfile.NoSuchPmlUserFileTypeException {
        return getPersistence().remove(pmlUserFileTypePK);
    }

    public static com.nss.portlet.permissonuserbyfile.model.PmlUserFileType remove(
        com.nss.portlet.permissonuserbyfile.model.PmlUserFileType pmlUserFileType)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(pmlUserFileType);
    }

    /**
     * @deprecated Use <code>update(PmlUserFileType pmlUserFileType, boolean merge)</code>.
     */
    public static com.nss.portlet.permissonuserbyfile.model.PmlUserFileType update(
        com.nss.portlet.permissonuserbyfile.model.PmlUserFileType pmlUserFileType)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(pmlUserFileType);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlUserFileType the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlUserFileType is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public static com.nss.portlet.permissonuserbyfile.model.PmlUserFileType update(
        com.nss.portlet.permissonuserbyfile.model.PmlUserFileType pmlUserFileType,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().update(pmlUserFileType, merge);
    }

    public static com.nss.portlet.permissonuserbyfile.model.PmlUserFileType updateImpl(
        com.nss.portlet.permissonuserbyfile.model.PmlUserFileType pmlUserFileType,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(pmlUserFileType, merge);
    }

    public static com.nss.portlet.permissonuserbyfile.model.PmlUserFileType findByPrimaryKey(
        com.nss.portlet.permissonuserbyfile.service.persistence.PmlUserFileTypePK pmlUserFileTypePK)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.permissonuserbyfile.NoSuchPmlUserFileTypeException {
        return getPersistence().findByPrimaryKey(pmlUserFileTypePK);
    }

    public static com.nss.portlet.permissonuserbyfile.model.PmlUserFileType fetchByPrimaryKey(
        com.nss.portlet.permissonuserbyfile.service.persistence.PmlUserFileTypePK pmlUserFileTypePK)
        throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(pmlUserFileTypePK);
    }

    public static java.util.List<com.nss.portlet.permissonuserbyfile.model.PmlUserFileType> findByUserId(
        long userId) throws com.liferay.portal.SystemException {
        return getPersistence().findByUserId(userId);
    }

    public static java.util.List<com.nss.portlet.permissonuserbyfile.model.PmlUserFileType> findByUserId(
        long userId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByUserId(userId, start, end);
    }

    public static java.util.List<com.nss.portlet.permissonuserbyfile.model.PmlUserFileType> findByUserId(
        long userId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByUserId(userId, start, end, obc);
    }

    public static com.nss.portlet.permissonuserbyfile.model.PmlUserFileType findByUserId_First(
        long userId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.permissonuserbyfile.NoSuchPmlUserFileTypeException {
        return getPersistence().findByUserId_First(userId, obc);
    }

    public static com.nss.portlet.permissonuserbyfile.model.PmlUserFileType findByUserId_Last(
        long userId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.permissonuserbyfile.NoSuchPmlUserFileTypeException {
        return getPersistence().findByUserId_Last(userId, obc);
    }

    public static com.nss.portlet.permissonuserbyfile.model.PmlUserFileType[] findByUserId_PrevAndNext(
        com.nss.portlet.permissonuserbyfile.service.persistence.PmlUserFileTypePK pmlUserFileTypePK,
        long userId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.permissonuserbyfile.NoSuchPmlUserFileTypeException {
        return getPersistence()
                   .findByUserId_PrevAndNext(pmlUserFileTypePK, userId, obc);
    }

    public static java.util.List<com.nss.portlet.permissonuserbyfile.model.PmlUserFileType> findByFileTypeId(
        java.lang.String fileTypeId) throws com.liferay.portal.SystemException {
        return getPersistence().findByFileTypeId(fileTypeId);
    }

    public static java.util.List<com.nss.portlet.permissonuserbyfile.model.PmlUserFileType> findByFileTypeId(
        java.lang.String fileTypeId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByFileTypeId(fileTypeId, start, end);
    }

    public static java.util.List<com.nss.portlet.permissonuserbyfile.model.PmlUserFileType> findByFileTypeId(
        java.lang.String fileTypeId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByFileTypeId(fileTypeId, start, end, obc);
    }

    public static com.nss.portlet.permissonuserbyfile.model.PmlUserFileType findByFileTypeId_First(
        java.lang.String fileTypeId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.permissonuserbyfile.NoSuchPmlUserFileTypeException {
        return getPersistence().findByFileTypeId_First(fileTypeId, obc);
    }

    public static com.nss.portlet.permissonuserbyfile.model.PmlUserFileType findByFileTypeId_Last(
        java.lang.String fileTypeId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.permissonuserbyfile.NoSuchPmlUserFileTypeException {
        return getPersistence().findByFileTypeId_Last(fileTypeId, obc);
    }

    public static com.nss.portlet.permissonuserbyfile.model.PmlUserFileType[] findByFileTypeId_PrevAndNext(
        com.nss.portlet.permissonuserbyfile.service.persistence.PmlUserFileTypePK pmlUserFileTypePK,
        java.lang.String fileTypeId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.permissonuserbyfile.NoSuchPmlUserFileTypeException {
        return getPersistence()
                   .findByFileTypeId_PrevAndNext(pmlUserFileTypePK, fileTypeId,
            obc);
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

    public static java.util.List<com.nss.portlet.permissonuserbyfile.model.PmlUserFileType> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.nss.portlet.permissonuserbyfile.model.PmlUserFileType> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.nss.portlet.permissonuserbyfile.model.PmlUserFileType> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end, obc);
    }

    public static void removeByUserId(long userId)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByUserId(userId);
    }

    public static void removeByFileTypeId(java.lang.String fileTypeId)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByFileTypeId(fileTypeId);
    }

    public static void removeAll() throws com.liferay.portal.SystemException {
        getPersistence().removeAll();
    }

    public static int countByUserId(long userId)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByUserId(userId);
    }

    public static int countByFileTypeId(java.lang.String fileTypeId)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByFileTypeId(fileTypeId);
    }

    public static int countAll() throws com.liferay.portal.SystemException {
        return getPersistence().countAll();
    }

    public static PmlUserFileTypePersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(PmlUserFileTypePersistence persistence) {
        _persistence = persistence;
    }
}
