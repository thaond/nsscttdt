package com.sgs.portlet.onedoor.service.persistence;

public class PmlDepartmentsLeaderUtil {
    private static PmlDepartmentsLeaderPersistence _persistence;

    public static com.sgs.portlet.onedoor.model.PmlDepartmentsLeader create(
        com.sgs.portlet.onedoor.service.persistence.PmlDepartmentsLeaderPK pmlDepartmentsLeaderPK) {
        return getPersistence().create(pmlDepartmentsLeaderPK);
    }

    public static com.sgs.portlet.onedoor.model.PmlDepartmentsLeader remove(
        com.sgs.portlet.onedoor.service.persistence.PmlDepartmentsLeaderPK pmlDepartmentsLeaderPK)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlDepartmentsLeaderException {
        return getPersistence().remove(pmlDepartmentsLeaderPK);
    }

    public static com.sgs.portlet.onedoor.model.PmlDepartmentsLeader remove(
        com.sgs.portlet.onedoor.model.PmlDepartmentsLeader pmlDepartmentsLeader)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(pmlDepartmentsLeader);
    }

    /**
     * @deprecated Use <code>update(PmlDepartmentsLeader pmlDepartmentsLeader, boolean merge)</code>.
     */
    public static com.sgs.portlet.onedoor.model.PmlDepartmentsLeader update(
        com.sgs.portlet.onedoor.model.PmlDepartmentsLeader pmlDepartmentsLeader)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(pmlDepartmentsLeader);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlDepartmentsLeader the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlDepartmentsLeader is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public static com.sgs.portlet.onedoor.model.PmlDepartmentsLeader update(
        com.sgs.portlet.onedoor.model.PmlDepartmentsLeader pmlDepartmentsLeader,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().update(pmlDepartmentsLeader, merge);
    }

    public static com.sgs.portlet.onedoor.model.PmlDepartmentsLeader updateImpl(
        com.sgs.portlet.onedoor.model.PmlDepartmentsLeader pmlDepartmentsLeader,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(pmlDepartmentsLeader, merge);
    }

    public static com.sgs.portlet.onedoor.model.PmlDepartmentsLeader findByPrimaryKey(
        com.sgs.portlet.onedoor.service.persistence.PmlDepartmentsLeaderPK pmlDepartmentsLeaderPK)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlDepartmentsLeaderException {
        return getPersistence().findByPrimaryKey(pmlDepartmentsLeaderPK);
    }

    public static com.sgs.portlet.onedoor.model.PmlDepartmentsLeader fetchByPrimaryKey(
        com.sgs.portlet.onedoor.service.persistence.PmlDepartmentsLeaderPK pmlDepartmentsLeaderPK)
        throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(pmlDepartmentsLeaderPK);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlDepartmentsLeader> findByDepartmentsId(
        java.lang.String departmentsId)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByDepartmentsId(departmentsId);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlDepartmentsLeader> findByDepartmentsId(
        java.lang.String departmentsId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByDepartmentsId(departmentsId, start, end);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlDepartmentsLeader> findByDepartmentsId(
        java.lang.String departmentsId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDepartmentsId(departmentsId, start, end, obc);
    }

    public static com.sgs.portlet.onedoor.model.PmlDepartmentsLeader findByDepartmentsId_First(
        java.lang.String departmentsId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlDepartmentsLeaderException {
        return getPersistence().findByDepartmentsId_First(departmentsId, obc);
    }

    public static com.sgs.portlet.onedoor.model.PmlDepartmentsLeader findByDepartmentsId_Last(
        java.lang.String departmentsId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlDepartmentsLeaderException {
        return getPersistence().findByDepartmentsId_Last(departmentsId, obc);
    }

    public static com.sgs.portlet.onedoor.model.PmlDepartmentsLeader[] findByDepartmentsId_PrevAndNext(
        com.sgs.portlet.onedoor.service.persistence.PmlDepartmentsLeaderPK pmlDepartmentsLeaderPK,
        java.lang.String departmentsId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlDepartmentsLeaderException {
        return getPersistence()
                   .findByDepartmentsId_PrevAndNext(pmlDepartmentsLeaderPK,
            departmentsId, obc);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlDepartmentsLeader> findByUserId(
        long userId) throws com.liferay.portal.SystemException {
        return getPersistence().findByUserId(userId);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlDepartmentsLeader> findByUserId(
        long userId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByUserId(userId, start, end);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlDepartmentsLeader> findByUserId(
        long userId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByUserId(userId, start, end, obc);
    }

    public static com.sgs.portlet.onedoor.model.PmlDepartmentsLeader findByUserId_First(
        long userId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlDepartmentsLeaderException {
        return getPersistence().findByUserId_First(userId, obc);
    }

    public static com.sgs.portlet.onedoor.model.PmlDepartmentsLeader findByUserId_Last(
        long userId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlDepartmentsLeaderException {
        return getPersistence().findByUserId_Last(userId, obc);
    }

    public static com.sgs.portlet.onedoor.model.PmlDepartmentsLeader[] findByUserId_PrevAndNext(
        com.sgs.portlet.onedoor.service.persistence.PmlDepartmentsLeaderPK pmlDepartmentsLeaderPK,
        long userId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlDepartmentsLeaderException {
        return getPersistence()
                   .findByUserId_PrevAndNext(pmlDepartmentsLeaderPK, userId, obc);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlDepartmentsLeader> findByDepartmentsId_UserId(
        java.lang.String departmentsId, long userId)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByDepartmentsId_UserId(departmentsId, userId);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlDepartmentsLeader> findByDepartmentsId_UserId(
        java.lang.String departmentsId, long userId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDepartmentsId_UserId(departmentsId, userId, start, end);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlDepartmentsLeader> findByDepartmentsId_UserId(
        java.lang.String departmentsId, long userId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDepartmentsId_UserId(departmentsId, userId, start,
            end, obc);
    }

    public static com.sgs.portlet.onedoor.model.PmlDepartmentsLeader findByDepartmentsId_UserId_First(
        java.lang.String departmentsId, long userId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlDepartmentsLeaderException {
        return getPersistence()
                   .findByDepartmentsId_UserId_First(departmentsId, userId, obc);
    }

    public static com.sgs.portlet.onedoor.model.PmlDepartmentsLeader findByDepartmentsId_UserId_Last(
        java.lang.String departmentsId, long userId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlDepartmentsLeaderException {
        return getPersistence()
                   .findByDepartmentsId_UserId_Last(departmentsId, userId, obc);
    }

    public static com.sgs.portlet.onedoor.model.PmlDepartmentsLeader[] findByDepartmentsId_UserId_PrevAndNext(
        com.sgs.portlet.onedoor.service.persistence.PmlDepartmentsLeaderPK pmlDepartmentsLeaderPK,
        java.lang.String departmentsId, long userId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlDepartmentsLeaderException {
        return getPersistence()
                   .findByDepartmentsId_UserId_PrevAndNext(pmlDepartmentsLeaderPK,
            departmentsId, userId, obc);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlDepartmentsLeader> findByClericalId(
        long clericalId) throws com.liferay.portal.SystemException {
        return getPersistence().findByClericalId(clericalId);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlDepartmentsLeader> findByClericalId(
        long clericalId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByClericalId(clericalId, start, end);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlDepartmentsLeader> findByClericalId(
        long clericalId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByClericalId(clericalId, start, end, obc);
    }

    public static com.sgs.portlet.onedoor.model.PmlDepartmentsLeader findByClericalId_First(
        long clericalId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlDepartmentsLeaderException {
        return getPersistence().findByClericalId_First(clericalId, obc);
    }

    public static com.sgs.portlet.onedoor.model.PmlDepartmentsLeader findByClericalId_Last(
        long clericalId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlDepartmentsLeaderException {
        return getPersistence().findByClericalId_Last(clericalId, obc);
    }

    public static com.sgs.portlet.onedoor.model.PmlDepartmentsLeader[] findByClericalId_PrevAndNext(
        com.sgs.portlet.onedoor.service.persistence.PmlDepartmentsLeaderPK pmlDepartmentsLeaderPK,
        long clericalId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlDepartmentsLeaderException {
        return getPersistence()
                   .findByClericalId_PrevAndNext(pmlDepartmentsLeaderPK,
            clericalId, obc);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlDepartmentsLeader> findByDepartmentsId_Main(
        java.lang.String departmentsId, boolean main)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByDepartmentsId_Main(departmentsId, main);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlDepartmentsLeader> findByDepartmentsId_Main(
        java.lang.String departmentsId, boolean main, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDepartmentsId_Main(departmentsId, main, start, end);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlDepartmentsLeader> findByDepartmentsId_Main(
        java.lang.String departmentsId, boolean main, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDepartmentsId_Main(departmentsId, main, start, end,
            obc);
    }

    public static com.sgs.portlet.onedoor.model.PmlDepartmentsLeader findByDepartmentsId_Main_First(
        java.lang.String departmentsId, boolean main,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlDepartmentsLeaderException {
        return getPersistence()
                   .findByDepartmentsId_Main_First(departmentsId, main, obc);
    }

    public static com.sgs.portlet.onedoor.model.PmlDepartmentsLeader findByDepartmentsId_Main_Last(
        java.lang.String departmentsId, boolean main,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlDepartmentsLeaderException {
        return getPersistence()
                   .findByDepartmentsId_Main_Last(departmentsId, main, obc);
    }

    public static com.sgs.portlet.onedoor.model.PmlDepartmentsLeader[] findByDepartmentsId_Main_PrevAndNext(
        com.sgs.portlet.onedoor.service.persistence.PmlDepartmentsLeaderPK pmlDepartmentsLeaderPK,
        java.lang.String departmentsId, boolean main,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlDepartmentsLeaderException {
        return getPersistence()
                   .findByDepartmentsId_Main_PrevAndNext(pmlDepartmentsLeaderPK,
            departmentsId, main, obc);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlDepartmentsLeader> findByMain(
        boolean main) throws com.liferay.portal.SystemException {
        return getPersistence().findByMain(main);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlDepartmentsLeader> findByMain(
        boolean main, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByMain(main, start, end);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlDepartmentsLeader> findByMain(
        boolean main, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByMain(main, start, end, obc);
    }

    public static com.sgs.portlet.onedoor.model.PmlDepartmentsLeader findByMain_First(
        boolean main, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlDepartmentsLeaderException {
        return getPersistence().findByMain_First(main, obc);
    }

    public static com.sgs.portlet.onedoor.model.PmlDepartmentsLeader findByMain_Last(
        boolean main, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlDepartmentsLeaderException {
        return getPersistence().findByMain_Last(main, obc);
    }

    public static com.sgs.portlet.onedoor.model.PmlDepartmentsLeader[] findByMain_PrevAndNext(
        com.sgs.portlet.onedoor.service.persistence.PmlDepartmentsLeaderPK pmlDepartmentsLeaderPK,
        boolean main, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlDepartmentsLeaderException {
        return getPersistence()
                   .findByMain_PrevAndNext(pmlDepartmentsLeaderPK, main, obc);
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

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlDepartmentsLeader> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlDepartmentsLeader> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlDepartmentsLeader> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end, obc);
    }

    public static void removeByDepartmentsId(java.lang.String departmentsId)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByDepartmentsId(departmentsId);
    }

    public static void removeByUserId(long userId)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByUserId(userId);
    }

    public static void removeByDepartmentsId_UserId(
        java.lang.String departmentsId, long userId)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByDepartmentsId_UserId(departmentsId, userId);
    }

    public static void removeByClericalId(long clericalId)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByClericalId(clericalId);
    }

    public static void removeByDepartmentsId_Main(
        java.lang.String departmentsId, boolean main)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByDepartmentsId_Main(departmentsId, main);
    }

    public static void removeByMain(boolean main)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByMain(main);
    }

    public static void removeAll() throws com.liferay.portal.SystemException {
        getPersistence().removeAll();
    }

    public static int countByDepartmentsId(java.lang.String departmentsId)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByDepartmentsId(departmentsId);
    }

    public static int countByUserId(long userId)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByUserId(userId);
    }

    public static int countByDepartmentsId_UserId(
        java.lang.String departmentsId, long userId)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .countByDepartmentsId_UserId(departmentsId, userId);
    }

    public static int countByClericalId(long clericalId)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByClericalId(clericalId);
    }

    public static int countByDepartmentsId_Main(
        java.lang.String departmentsId, boolean main)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByDepartmentsId_Main(departmentsId, main);
    }

    public static int countByMain(boolean main)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByMain(main);
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

    public static PmlDepartmentsLeaderPersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(PmlDepartmentsLeaderPersistence persistence) {
        _persistence = persistence;
    }
}
