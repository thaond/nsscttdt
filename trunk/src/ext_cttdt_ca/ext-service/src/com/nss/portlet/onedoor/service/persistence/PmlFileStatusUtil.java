package com.nss.portlet.onedoor.service.persistence;

public class PmlFileStatusUtil {
    private static PmlFileStatusPersistence _persistence;

    public static void cacheResult(
        com.nss.portlet.onedoor.model.PmlFileStatus pmlFileStatus) {
        getPersistence().cacheResult(pmlFileStatus);
    }

    public static void cacheResult(
        java.util.List<com.nss.portlet.onedoor.model.PmlFileStatus> pmlFileStatuses) {
        getPersistence().cacheResult(pmlFileStatuses);
    }

    public static void clearCache() {
        getPersistence().clearCache();
    }

    public static com.nss.portlet.onedoor.model.PmlFileStatus create(
        long fileStatusId) {
        return getPersistence().create(fileStatusId);
    }

    public static com.nss.portlet.onedoor.model.PmlFileStatus remove(
        long fileStatusId)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlFileStatusException {
        return getPersistence().remove(fileStatusId);
    }

    public static com.nss.portlet.onedoor.model.PmlFileStatus remove(
        com.nss.portlet.onedoor.model.PmlFileStatus pmlFileStatus)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(pmlFileStatus);
    }

    /**
     * @deprecated Use <code>update(PmlFileStatus pmlFileStatus, boolean merge)</code>.
     */
    public static com.nss.portlet.onedoor.model.PmlFileStatus update(
        com.nss.portlet.onedoor.model.PmlFileStatus pmlFileStatus)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(pmlFileStatus);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlFileStatus the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlFileStatus is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public static com.nss.portlet.onedoor.model.PmlFileStatus update(
        com.nss.portlet.onedoor.model.PmlFileStatus pmlFileStatus, boolean merge)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(pmlFileStatus, merge);
    }

    public static com.nss.portlet.onedoor.model.PmlFileStatus updateImpl(
        com.nss.portlet.onedoor.model.PmlFileStatus pmlFileStatus, boolean merge)
        throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(pmlFileStatus, merge);
    }

    public static com.nss.portlet.onedoor.model.PmlFileStatus findByPrimaryKey(
        long fileStatusId)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlFileStatusException {
        return getPersistence().findByPrimaryKey(fileStatusId);
    }

    public static com.nss.portlet.onedoor.model.PmlFileStatus fetchByPrimaryKey(
        long fileStatusId) throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(fileStatusId);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlFileStatus> findByFileStatusCode(
        java.lang.String fileStatusCode)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByFileStatusCode(fileStatusCode);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlFileStatus> findByFileStatusCode(
        java.lang.String fileStatusCode, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByFileStatusCode(fileStatusCode, start, end);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlFileStatus> findByFileStatusCode(
        java.lang.String fileStatusCode, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByFileStatusCode(fileStatusCode, start, end, obc);
    }

    public static com.nss.portlet.onedoor.model.PmlFileStatus findByFileStatusCode_First(
        java.lang.String fileStatusCode,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlFileStatusException {
        return getPersistence().findByFileStatusCode_First(fileStatusCode, obc);
    }

    public static com.nss.portlet.onedoor.model.PmlFileStatus findByFileStatusCode_Last(
        java.lang.String fileStatusCode,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlFileStatusException {
        return getPersistence().findByFileStatusCode_Last(fileStatusCode, obc);
    }

    public static com.nss.portlet.onedoor.model.PmlFileStatus[] findByFileStatusCode_PrevAndNext(
        long fileStatusId, java.lang.String fileStatusCode,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlFileStatusException {
        return getPersistence()
                   .findByFileStatusCode_PrevAndNext(fileStatusId,
            fileStatusCode, obc);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlFileStatus> findByFileStatusName(
        java.lang.String fileStatusName)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByFileStatusName(fileStatusName);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlFileStatus> findByFileStatusName(
        java.lang.String fileStatusName, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByFileStatusName(fileStatusName, start, end);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlFileStatus> findByFileStatusName(
        java.lang.String fileStatusName, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByFileStatusName(fileStatusName, start, end, obc);
    }

    public static com.nss.portlet.onedoor.model.PmlFileStatus findByFileStatusName_First(
        java.lang.String fileStatusName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlFileStatusException {
        return getPersistence().findByFileStatusName_First(fileStatusName, obc);
    }

    public static com.nss.portlet.onedoor.model.PmlFileStatus findByFileStatusName_Last(
        java.lang.String fileStatusName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlFileStatusException {
        return getPersistence().findByFileStatusName_Last(fileStatusName, obc);
    }

    public static com.nss.portlet.onedoor.model.PmlFileStatus[] findByFileStatusName_PrevAndNext(
        long fileStatusId, java.lang.String fileStatusName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlFileStatusException {
        return getPersistence()
                   .findByFileStatusName_PrevAndNext(fileStatusId,
            fileStatusName, obc);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlFileStatus> findByDescription(
        java.lang.String description) throws com.liferay.portal.SystemException {
        return getPersistence().findByDescription(description);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlFileStatus> findByDescription(
        java.lang.String description, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByDescription(description, start, end);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlFileStatus> findByDescription(
        java.lang.String description, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByDescription(description, start, end, obc);
    }

    public static com.nss.portlet.onedoor.model.PmlFileStatus findByDescription_First(
        java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlFileStatusException {
        return getPersistence().findByDescription_First(description, obc);
    }

    public static com.nss.portlet.onedoor.model.PmlFileStatus findByDescription_Last(
        java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlFileStatusException {
        return getPersistence().findByDescription_Last(description, obc);
    }

    public static com.nss.portlet.onedoor.model.PmlFileStatus[] findByDescription_PrevAndNext(
        long fileStatusId, java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlFileStatusException {
        return getPersistence()
                   .findByDescription_PrevAndNext(fileStatusId, description, obc);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlFileStatus> findByType(
        java.lang.String type) throws com.liferay.portal.SystemException {
        return getPersistence().findByType(type);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlFileStatus> findByType(
        java.lang.String type, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByType(type, start, end);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlFileStatus> findByType(
        java.lang.String type, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByType(type, start, end, obc);
    }

    public static com.nss.portlet.onedoor.model.PmlFileStatus findByType_First(
        java.lang.String type,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlFileStatusException {
        return getPersistence().findByType_First(type, obc);
    }

    public static com.nss.portlet.onedoor.model.PmlFileStatus findByType_Last(
        java.lang.String type,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlFileStatusException {
        return getPersistence().findByType_Last(type, obc);
    }

    public static com.nss.portlet.onedoor.model.PmlFileStatus[] findByType_PrevAndNext(
        long fileStatusId, java.lang.String type,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlFileStatusException {
        return getPersistence().findByType_PrevAndNext(fileStatusId, type, obc);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlFileStatus> findByFileStatusCode_Type(
        java.lang.String fileStatusCode, java.lang.String type)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByFileStatusCode_Type(fileStatusCode, type);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlFileStatus> findByFileStatusCode_Type(
        java.lang.String fileStatusCode, java.lang.String type, int start,
        int end) throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByFileStatusCode_Type(fileStatusCode, type, start, end);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlFileStatus> findByFileStatusCode_Type(
        java.lang.String fileStatusCode, java.lang.String type, int start,
        int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByFileStatusCode_Type(fileStatusCode, type, start, end,
            obc);
    }

    public static com.nss.portlet.onedoor.model.PmlFileStatus findByFileStatusCode_Type_First(
        java.lang.String fileStatusCode, java.lang.String type,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlFileStatusException {
        return getPersistence()
                   .findByFileStatusCode_Type_First(fileStatusCode, type, obc);
    }

    public static com.nss.portlet.onedoor.model.PmlFileStatus findByFileStatusCode_Type_Last(
        java.lang.String fileStatusCode, java.lang.String type,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlFileStatusException {
        return getPersistence()
                   .findByFileStatusCode_Type_Last(fileStatusCode, type, obc);
    }

    public static com.nss.portlet.onedoor.model.PmlFileStatus[] findByFileStatusCode_Type_PrevAndNext(
        long fileStatusId, java.lang.String fileStatusCode,
        java.lang.String type,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlFileStatusException {
        return getPersistence()
                   .findByFileStatusCode_Type_PrevAndNext(fileStatusId,
            fileStatusCode, type, obc);
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

    public static java.util.List<com.nss.portlet.onedoor.model.PmlFileStatus> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlFileStatus> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlFileStatus> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end, obc);
    }

    public static void removeByFileStatusCode(java.lang.String fileStatusCode)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByFileStatusCode(fileStatusCode);
    }

    public static void removeByFileStatusName(java.lang.String fileStatusName)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByFileStatusName(fileStatusName);
    }

    public static void removeByDescription(java.lang.String description)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByDescription(description);
    }

    public static void removeByType(java.lang.String type)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByType(type);
    }

    public static void removeByFileStatusCode_Type(
        java.lang.String fileStatusCode, java.lang.String type)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByFileStatusCode_Type(fileStatusCode, type);
    }

    public static void removeAll() throws com.liferay.portal.SystemException {
        getPersistence().removeAll();
    }

    public static int countByFileStatusCode(java.lang.String fileStatusCode)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByFileStatusCode(fileStatusCode);
    }

    public static int countByFileStatusName(java.lang.String fileStatusName)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByFileStatusName(fileStatusName);
    }

    public static int countByDescription(java.lang.String description)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByDescription(description);
    }

    public static int countByType(java.lang.String type)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByType(type);
    }

    public static int countByFileStatusCode_Type(
        java.lang.String fileStatusCode, java.lang.String type)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByFileStatusCode_Type(fileStatusCode, type);
    }

    public static int countAll() throws com.liferay.portal.SystemException {
        return getPersistence().countAll();
    }

    public static PmlFileStatusPersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(PmlFileStatusPersistence persistence) {
        _persistence = persistence;
    }
}
