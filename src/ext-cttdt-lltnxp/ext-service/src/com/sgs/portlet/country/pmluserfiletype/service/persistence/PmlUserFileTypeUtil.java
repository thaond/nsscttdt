package com.sgs.portlet.country.pmluserfiletype.service.persistence;

public class PmlUserFileTypeUtil {
    private static PmlUserFileTypePersistence _persistence;

    public static com.sgs.portlet.country.pmluserfiletype.model.PmlUserFileType create(
        com.sgs.portlet.country.pmluserfiletype.service.persistence.PmlUserFileTypePK pmlUserFileTypePK) {
        return getPersistence().create(pmlUserFileTypePK);
    }

    public static com.sgs.portlet.country.pmluserfiletype.model.PmlUserFileType remove(
        com.sgs.portlet.country.pmluserfiletype.service.persistence.PmlUserFileTypePK pmlUserFileTypePK)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.country.pmluserfiletype.NoSuchException {
        return getPersistence().remove(pmlUserFileTypePK);
    }

    public static com.sgs.portlet.country.pmluserfiletype.model.PmlUserFileType remove(
        com.sgs.portlet.country.pmluserfiletype.model.PmlUserFileType pmlUserFileType)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(pmlUserFileType);
    }

    /**
     * @deprecated Use <code>update(PmlUserFileType pmlUserFileType, boolean merge)</code>.
     */
    public static com.sgs.portlet.country.pmluserfiletype.model.PmlUserFileType update(
        com.sgs.portlet.country.pmluserfiletype.model.PmlUserFileType pmlUserFileType)
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
    public static com.sgs.portlet.country.pmluserfiletype.model.PmlUserFileType update(
        com.sgs.portlet.country.pmluserfiletype.model.PmlUserFileType pmlUserFileType,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().update(pmlUserFileType, merge);
    }

    public static com.sgs.portlet.country.pmluserfiletype.model.PmlUserFileType updateImpl(
        com.sgs.portlet.country.pmluserfiletype.model.PmlUserFileType pmlUserFileType,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(pmlUserFileType, merge);
    }

    public static com.sgs.portlet.country.pmluserfiletype.model.PmlUserFileType findByPrimaryKey(
        com.sgs.portlet.country.pmluserfiletype.service.persistence.PmlUserFileTypePK pmlUserFileTypePK)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.country.pmluserfiletype.NoSuchException {
        return getPersistence().findByPrimaryKey(pmlUserFileTypePK);
    }

    public static com.sgs.portlet.country.pmluserfiletype.model.PmlUserFileType fetchByPrimaryKey(
        com.sgs.portlet.country.pmluserfiletype.service.persistence.PmlUserFileTypePK pmlUserFileTypePK)
        throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(pmlUserFileTypePK);
    }

    public static java.util.List<com.sgs.portlet.country.pmluserfiletype.model.PmlUserFileType> findByUserId(
        long userId) throws com.liferay.portal.SystemException {
        return getPersistence().findByUserId(userId);
    }

    public static java.util.List<com.sgs.portlet.country.pmluserfiletype.model.PmlUserFileType> findByUserId(
        long userId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByUserId(userId, start, end);
    }

    public static java.util.List<com.sgs.portlet.country.pmluserfiletype.model.PmlUserFileType> findByUserId(
        long userId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByUserId(userId, start, end, obc);
    }

    public static com.sgs.portlet.country.pmluserfiletype.model.PmlUserFileType findByUserId_First(
        long userId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.country.pmluserfiletype.NoSuchException {
        return getPersistence().findByUserId_First(userId, obc);
    }

    public static com.sgs.portlet.country.pmluserfiletype.model.PmlUserFileType findByUserId_Last(
        long userId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.country.pmluserfiletype.NoSuchException {
        return getPersistence().findByUserId_Last(userId, obc);
    }

    public static com.sgs.portlet.country.pmluserfiletype.model.PmlUserFileType[] findByUserId_PrevAndNext(
        com.sgs.portlet.country.pmluserfiletype.service.persistence.PmlUserFileTypePK pmlUserFileTypePK,
        long userId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.country.pmluserfiletype.NoSuchException {
        return getPersistence()
                   .findByUserId_PrevAndNext(pmlUserFileTypePK, userId, obc);
    }

    public static java.util.List<com.sgs.portlet.country.pmluserfiletype.model.PmlUserFileType> findByFileTypeId(
        java.lang.String fileTypeId) throws com.liferay.portal.SystemException {
        return getPersistence().findByFileTypeId(fileTypeId);
    }

    public static java.util.List<com.sgs.portlet.country.pmluserfiletype.model.PmlUserFileType> findByFileTypeId(
        java.lang.String fileTypeId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByFileTypeId(fileTypeId, start, end);
    }

    public static java.util.List<com.sgs.portlet.country.pmluserfiletype.model.PmlUserFileType> findByFileTypeId(
        java.lang.String fileTypeId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByFileTypeId(fileTypeId, start, end, obc);
    }

    public static com.sgs.portlet.country.pmluserfiletype.model.PmlUserFileType findByFileTypeId_First(
        java.lang.String fileTypeId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.country.pmluserfiletype.NoSuchException {
        return getPersistence().findByFileTypeId_First(fileTypeId, obc);
    }

    public static com.sgs.portlet.country.pmluserfiletype.model.PmlUserFileType findByFileTypeId_Last(
        java.lang.String fileTypeId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.country.pmluserfiletype.NoSuchException {
        return getPersistence().findByFileTypeId_Last(fileTypeId, obc);
    }

    public static com.sgs.portlet.country.pmluserfiletype.model.PmlUserFileType[] findByFileTypeId_PrevAndNext(
        com.sgs.portlet.country.pmluserfiletype.service.persistence.PmlUserFileTypePK pmlUserFileTypePK,
        java.lang.String fileTypeId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.country.pmluserfiletype.NoSuchException {
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

    public static java.util.List<com.sgs.portlet.country.pmluserfiletype.model.PmlUserFileType> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.sgs.portlet.country.pmluserfiletype.model.PmlUserFileType> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.sgs.portlet.country.pmluserfiletype.model.PmlUserFileType> findAll(
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

    public static void registerListener(
        com.liferay.portal.model.ModelListener listener) {
        getPersistence().registerListener(listener);
    }

    public static void unregisterListener(
        com.liferay.portal.model.ModelListener listener) {
        getPersistence().unregisterListener(listener);
    }

    public static PmlUserFileTypePersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(PmlUserFileTypePersistence persistence) {
        _persistence = persistence;
    }
}
