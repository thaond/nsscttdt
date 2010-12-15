package com.nss.portlet.position.service.persistence;

public class PositionUtil {
    private static PositionPersistence _persistence;

    public static void cacheResult(
        com.nss.portlet.position.model.Position position) {
        getPersistence().cacheResult(position);
    }

    public static void cacheResult(
        java.util.List<com.nss.portlet.position.model.Position> positions) {
        getPersistence().cacheResult(positions);
    }

    public static void clearCache() {
        getPersistence().clearCache();
    }

    public static com.nss.portlet.position.model.Position create(
        java.lang.String positionId) {
        return getPersistence().create(positionId);
    }

    public static com.nss.portlet.position.model.Position remove(
        java.lang.String positionId)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.position.NoSuchPositionException {
        return getPersistence().remove(positionId);
    }

    public static com.nss.portlet.position.model.Position remove(
        com.nss.portlet.position.model.Position position)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(position);
    }

    /**
     * @deprecated Use <code>update(Position position, boolean merge)</code>.
     */
    public static com.nss.portlet.position.model.Position update(
        com.nss.portlet.position.model.Position position)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(position);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                position the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when position is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public static com.nss.portlet.position.model.Position update(
        com.nss.portlet.position.model.Position position, boolean merge)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(position, merge);
    }

    public static com.nss.portlet.position.model.Position updateImpl(
        com.nss.portlet.position.model.Position position, boolean merge)
        throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(position, merge);
    }

    public static com.nss.portlet.position.model.Position findByPrimaryKey(
        java.lang.String positionId)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.position.NoSuchPositionException {
        return getPersistence().findByPrimaryKey(positionId);
    }

    public static com.nss.portlet.position.model.Position fetchByPrimaryKey(
        java.lang.String positionId) throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(positionId);
    }

    public static java.util.List<com.nss.portlet.position.model.Position> findByPositionCode(
        java.lang.String positionCode)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByPositionCode(positionCode);
    }

    public static java.util.List<com.nss.portlet.position.model.Position> findByPositionCode(
        java.lang.String positionCode, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByPositionCode(positionCode, start, end);
    }

    public static java.util.List<com.nss.portlet.position.model.Position> findByPositionCode(
        java.lang.String positionCode, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByPositionCode(positionCode, start, end, obc);
    }

    public static com.nss.portlet.position.model.Position findByPositionCode_First(
        java.lang.String positionCode,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.position.NoSuchPositionException {
        return getPersistence().findByPositionCode_First(positionCode, obc);
    }

    public static com.nss.portlet.position.model.Position findByPositionCode_Last(
        java.lang.String positionCode,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.position.NoSuchPositionException {
        return getPersistence().findByPositionCode_Last(positionCode, obc);
    }

    public static com.nss.portlet.position.model.Position[] findByPositionCode_PrevAndNext(
        java.lang.String positionId, java.lang.String positionCode,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.position.NoSuchPositionException {
        return getPersistence()
                   .findByPositionCode_PrevAndNext(positionId, positionCode, obc);
    }

    public static java.util.List<com.nss.portlet.position.model.Position> findByPositionName(
        java.lang.String positionName)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByPositionName(positionName);
    }

    public static java.util.List<com.nss.portlet.position.model.Position> findByPositionName(
        java.lang.String positionName, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByPositionName(positionName, start, end);
    }

    public static java.util.List<com.nss.portlet.position.model.Position> findByPositionName(
        java.lang.String positionName, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByPositionName(positionName, start, end, obc);
    }

    public static com.nss.portlet.position.model.Position findByPositionName_First(
        java.lang.String positionName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.position.NoSuchPositionException {
        return getPersistence().findByPositionName_First(positionName, obc);
    }

    public static com.nss.portlet.position.model.Position findByPositionName_Last(
        java.lang.String positionName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.position.NoSuchPositionException {
        return getPersistence().findByPositionName_Last(positionName, obc);
    }

    public static com.nss.portlet.position.model.Position[] findByPositionName_PrevAndNext(
        java.lang.String positionId, java.lang.String positionName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.position.NoSuchPositionException {
        return getPersistence()
                   .findByPositionName_PrevAndNext(positionId, positionName, obc);
    }

    public static java.util.List<com.nss.portlet.position.model.Position> findByDescription(
        java.lang.String description) throws com.liferay.portal.SystemException {
        return getPersistence().findByDescription(description);
    }

    public static java.util.List<com.nss.portlet.position.model.Position> findByDescription(
        java.lang.String description, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByDescription(description, start, end);
    }

    public static java.util.List<com.nss.portlet.position.model.Position> findByDescription(
        java.lang.String description, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByDescription(description, start, end, obc);
    }

    public static com.nss.portlet.position.model.Position findByDescription_First(
        java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.position.NoSuchPositionException {
        return getPersistence().findByDescription_First(description, obc);
    }

    public static com.nss.portlet.position.model.Position findByDescription_Last(
        java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.position.NoSuchPositionException {
        return getPersistence().findByDescription_Last(description, obc);
    }

    public static com.nss.portlet.position.model.Position[] findByDescription_PrevAndNext(
        java.lang.String positionId, java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.position.NoSuchPositionException {
        return getPersistence()
                   .findByDescription_PrevAndNext(positionId, description, obc);
    }

    public static java.util.List<com.nss.portlet.position.model.Position> findByAllfilter(
        java.lang.String positionCode, java.lang.String positionName,
        java.lang.String description) throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByAllfilter(positionCode, positionName, description);
    }

    public static java.util.List<com.nss.portlet.position.model.Position> findByAllfilter(
        java.lang.String positionCode, java.lang.String positionName,
        java.lang.String description, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByAllfilter(positionCode, positionName, description,
            start, end);
    }

    public static java.util.List<com.nss.portlet.position.model.Position> findByAllfilter(
        java.lang.String positionCode, java.lang.String positionName,
        java.lang.String description, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByAllfilter(positionCode, positionName, description,
            start, end, obc);
    }

    public static com.nss.portlet.position.model.Position findByAllfilter_First(
        java.lang.String positionCode, java.lang.String positionName,
        java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.position.NoSuchPositionException {
        return getPersistence()
                   .findByAllfilter_First(positionCode, positionName,
            description, obc);
    }

    public static com.nss.portlet.position.model.Position findByAllfilter_Last(
        java.lang.String positionCode, java.lang.String positionName,
        java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.position.NoSuchPositionException {
        return getPersistence()
                   .findByAllfilter_Last(positionCode, positionName,
            description, obc);
    }

    public static com.nss.portlet.position.model.Position[] findByAllfilter_PrevAndNext(
        java.lang.String positionId, java.lang.String positionCode,
        java.lang.String positionName, java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.position.NoSuchPositionException {
        return getPersistence()
                   .findByAllfilter_PrevAndNext(positionId, positionCode,
            positionName, description, obc);
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

    public static java.util.List<com.nss.portlet.position.model.Position> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.nss.portlet.position.model.Position> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.nss.portlet.position.model.Position> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end, obc);
    }

    public static void removeByPositionCode(java.lang.String positionCode)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByPositionCode(positionCode);
    }

    public static void removeByPositionName(java.lang.String positionName)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByPositionName(positionName);
    }

    public static void removeByDescription(java.lang.String description)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByDescription(description);
    }

    public static void removeByAllfilter(java.lang.String positionCode,
        java.lang.String positionName, java.lang.String description)
        throws com.liferay.portal.SystemException {
        getPersistence()
            .removeByAllfilter(positionCode, positionName, description);
    }

    public static void removeAll() throws com.liferay.portal.SystemException {
        getPersistence().removeAll();
    }

    public static int countByPositionCode(java.lang.String positionCode)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByPositionCode(positionCode);
    }

    public static int countByPositionName(java.lang.String positionName)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByPositionName(positionName);
    }

    public static int countByDescription(java.lang.String description)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByDescription(description);
    }

    public static int countByAllfilter(java.lang.String positionCode,
        java.lang.String positionName, java.lang.String description)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .countByAllfilter(positionCode, positionName, description);
    }

    public static int countAll() throws com.liferay.portal.SystemException {
        return getPersistence().countAll();
    }

    public static PositionPersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(PositionPersistence persistence) {
        _persistence = persistence;
    }
}
