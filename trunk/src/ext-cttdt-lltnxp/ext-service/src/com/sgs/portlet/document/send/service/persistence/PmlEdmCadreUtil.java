package com.sgs.portlet.document.send.service.persistence;

public class PmlEdmCadreUtil {
    private static PmlEdmCadrePersistence _persistence;

    public static com.sgs.portlet.document.send.model.PmlEdmCadre create(
        long userId) {
        return getPersistence().create(userId);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmCadre remove(
        long userId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmCadreException {
        return getPersistence().remove(userId);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmCadre remove(
        com.sgs.portlet.document.send.model.PmlEdmCadre pmlEdmCadre)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(pmlEdmCadre);
    }

    /**
     * @deprecated Use <code>update(PmlEdmCadre pmlEdmCadre, boolean merge)</code>.
     */
    public static com.sgs.portlet.document.send.model.PmlEdmCadre update(
        com.sgs.portlet.document.send.model.PmlEdmCadre pmlEdmCadre)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(pmlEdmCadre);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlEdmCadre the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlEdmCadre is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public static com.sgs.portlet.document.send.model.PmlEdmCadre update(
        com.sgs.portlet.document.send.model.PmlEdmCadre pmlEdmCadre,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().update(pmlEdmCadre, merge);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmCadre updateImpl(
        com.sgs.portlet.document.send.model.PmlEdmCadre pmlEdmCadre,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(pmlEdmCadre, merge);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmCadre findByPrimaryKey(
        long userId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmCadreException {
        return getPersistence().findByPrimaryKey(userId);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmCadre fetchByPrimaryKey(
        long userId) throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(userId);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmCadre> findByPositionId(
        java.lang.String positionId) throws com.liferay.portal.SystemException {
        return getPersistence().findByPositionId(positionId);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmCadre> findByPositionId(
        java.lang.String positionId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByPositionId(positionId, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmCadre> findByPositionId(
        java.lang.String positionId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByPositionId(positionId, start, end, obc);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmCadre findByPositionId_First(
        java.lang.String positionId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmCadreException {
        return getPersistence().findByPositionId_First(positionId, obc);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmCadre findByPositionId_Last(
        java.lang.String positionId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmCadreException {
        return getPersistence().findByPositionId_Last(positionId, obc);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmCadre[] findByPositionId_PrevAndNext(
        long userId, java.lang.String positionId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmCadreException {
        return getPersistence()
                   .findByPositionId_PrevAndNext(userId, positionId, obc);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmCadre> findByDepartmentsId(
        java.lang.String departmentsId)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByDepartmentsId(departmentsId);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmCadre> findByDepartmentsId(
        java.lang.String departmentsId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByDepartmentsId(departmentsId, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmCadre> findByDepartmentsId(
        java.lang.String departmentsId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDepartmentsId(departmentsId, start, end, obc);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmCadre findByDepartmentsId_First(
        java.lang.String departmentsId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmCadreException {
        return getPersistence().findByDepartmentsId_First(departmentsId, obc);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmCadre findByDepartmentsId_Last(
        java.lang.String departmentsId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmCadreException {
        return getPersistence().findByDepartmentsId_Last(departmentsId, obc);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmCadre[] findByDepartmentsId_PrevAndNext(
        long userId, java.lang.String departmentsId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmCadreException {
        return getPersistence()
                   .findByDepartmentsId_PrevAndNext(userId, departmentsId, obc);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmCadre> findByHandPhone(
        java.lang.String handPhone) throws com.liferay.portal.SystemException {
        return getPersistence().findByHandPhone(handPhone);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmCadre> findByHandPhone(
        java.lang.String handPhone, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByHandPhone(handPhone, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmCadre> findByHandPhone(
        java.lang.String handPhone, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByHandPhone(handPhone, start, end, obc);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmCadre findByHandPhone_First(
        java.lang.String handPhone,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmCadreException {
        return getPersistence().findByHandPhone_First(handPhone, obc);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmCadre findByHandPhone_Last(
        java.lang.String handPhone,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmCadreException {
        return getPersistence().findByHandPhone_Last(handPhone, obc);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmCadre[] findByHandPhone_PrevAndNext(
        long userId, java.lang.String handPhone,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmCadreException {
        return getPersistence()
                   .findByHandPhone_PrevAndNext(userId, handPhone, obc);
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

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmCadre> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmCadre> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmCadre> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end, obc);
    }

    public static void removeByPositionId(java.lang.String positionId)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByPositionId(positionId);
    }

    public static void removeByDepartmentsId(java.lang.String departmentsId)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByDepartmentsId(departmentsId);
    }

    public static void removeByHandPhone(java.lang.String handPhone)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByHandPhone(handPhone);
    }

    public static void removeAll() throws com.liferay.portal.SystemException {
        getPersistence().removeAll();
    }

    public static int countByPositionId(java.lang.String positionId)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByPositionId(positionId);
    }

    public static int countByDepartmentsId(java.lang.String departmentsId)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByDepartmentsId(departmentsId);
    }

    public static int countByHandPhone(java.lang.String handPhone)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByHandPhone(handPhone);
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

    public static PmlEdmCadrePersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(PmlEdmCadrePersistence persistence) {
        _persistence = persistence;
    }
}
