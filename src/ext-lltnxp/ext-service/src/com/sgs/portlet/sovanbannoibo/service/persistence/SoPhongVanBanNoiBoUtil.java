package com.sgs.portlet.sovanbannoibo.service.persistence;

public class SoPhongVanBanNoiBoUtil {
    private static SoPhongVanBanNoiBoPersistence _persistence;

    public static com.sgs.portlet.sovanbannoibo.model.SoPhongVanBanNoiBo create(
        com.sgs.portlet.sovanbannoibo.service.persistence.SoPhongVanBanNoiBoPK soPhongVanBanNoiBoPK) {
        return getPersistence().create(soPhongVanBanNoiBoPK);
    }

    public static com.sgs.portlet.sovanbannoibo.model.SoPhongVanBanNoiBo remove(
        com.sgs.portlet.sovanbannoibo.service.persistence.SoPhongVanBanNoiBoPK soPhongVanBanNoiBoPK)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.sovanbannoibo.NoSuchSoPhongVanBanNoiBoException {
        return getPersistence().remove(soPhongVanBanNoiBoPK);
    }

    public static com.sgs.portlet.sovanbannoibo.model.SoPhongVanBanNoiBo remove(
        com.sgs.portlet.sovanbannoibo.model.SoPhongVanBanNoiBo soPhongVanBanNoiBo)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(soPhongVanBanNoiBo);
    }

    /**
     * @deprecated Use <code>update(SoPhongVanBanNoiBo soPhongVanBanNoiBo, boolean merge)</code>.
     */
    public static com.sgs.portlet.sovanbannoibo.model.SoPhongVanBanNoiBo update(
        com.sgs.portlet.sovanbannoibo.model.SoPhongVanBanNoiBo soPhongVanBanNoiBo)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(soPhongVanBanNoiBo);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                soPhongVanBanNoiBo the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when soPhongVanBanNoiBo is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public static com.sgs.portlet.sovanbannoibo.model.SoPhongVanBanNoiBo update(
        com.sgs.portlet.sovanbannoibo.model.SoPhongVanBanNoiBo soPhongVanBanNoiBo,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().update(soPhongVanBanNoiBo, merge);
    }

    public static com.sgs.portlet.sovanbannoibo.model.SoPhongVanBanNoiBo updateImpl(
        com.sgs.portlet.sovanbannoibo.model.SoPhongVanBanNoiBo soPhongVanBanNoiBo,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(soPhongVanBanNoiBo, merge);
    }

    public static com.sgs.portlet.sovanbannoibo.model.SoPhongVanBanNoiBo findByPrimaryKey(
        com.sgs.portlet.sovanbannoibo.service.persistence.SoPhongVanBanNoiBoPK soPhongVanBanNoiBoPK)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.sovanbannoibo.NoSuchSoPhongVanBanNoiBoException {
        return getPersistence().findByPrimaryKey(soPhongVanBanNoiBoPK);
    }

    public static com.sgs.portlet.sovanbannoibo.model.SoPhongVanBanNoiBo fetchByPrimaryKey(
        com.sgs.portlet.sovanbannoibo.service.persistence.SoPhongVanBanNoiBoPK soPhongVanBanNoiBoPK)
        throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(soPhongVanBanNoiBoPK);
    }

    public static java.util.List<com.sgs.portlet.sovanbannoibo.model.SoPhongVanBanNoiBo> findBySoVanBanNoiBo(
        long soVanBanNoiBoId) throws com.liferay.portal.SystemException {
        return getPersistence().findBySoVanBanNoiBo(soVanBanNoiBoId);
    }

    public static java.util.List<com.sgs.portlet.sovanbannoibo.model.SoPhongVanBanNoiBo> findBySoVanBanNoiBo(
        long soVanBanNoiBoId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findBySoVanBanNoiBo(soVanBanNoiBoId, start, end);
    }

    public static java.util.List<com.sgs.portlet.sovanbannoibo.model.SoPhongVanBanNoiBo> findBySoVanBanNoiBo(
        long soVanBanNoiBoId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findBySoVanBanNoiBo(soVanBanNoiBoId, start, end, obc);
    }

    public static com.sgs.portlet.sovanbannoibo.model.SoPhongVanBanNoiBo findBySoVanBanNoiBo_First(
        long soVanBanNoiBoId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.sovanbannoibo.NoSuchSoPhongVanBanNoiBoException {
        return getPersistence().findBySoVanBanNoiBo_First(soVanBanNoiBoId, obc);
    }

    public static com.sgs.portlet.sovanbannoibo.model.SoPhongVanBanNoiBo findBySoVanBanNoiBo_Last(
        long soVanBanNoiBoId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.sovanbannoibo.NoSuchSoPhongVanBanNoiBoException {
        return getPersistence().findBySoVanBanNoiBo_Last(soVanBanNoiBoId, obc);
    }

    public static com.sgs.portlet.sovanbannoibo.model.SoPhongVanBanNoiBo[] findBySoVanBanNoiBo_PrevAndNext(
        com.sgs.portlet.sovanbannoibo.service.persistence.SoPhongVanBanNoiBoPK soPhongVanBanNoiBoPK,
        long soVanBanNoiBoId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.sovanbannoibo.NoSuchSoPhongVanBanNoiBoException {
        return getPersistence()
                   .findBySoVanBanNoiBo_PrevAndNext(soPhongVanBanNoiBoPK,
            soVanBanNoiBoId, obc);
    }

    public static java.util.List<com.sgs.portlet.sovanbannoibo.model.SoPhongVanBanNoiBo> findByPhongVanBanNoiBo(
        java.lang.String phongVanBanNoiBoId)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByPhongVanBanNoiBo(phongVanBanNoiBoId);
    }

    public static java.util.List<com.sgs.portlet.sovanbannoibo.model.SoPhongVanBanNoiBo> findByPhongVanBanNoiBo(
        java.lang.String phongVanBanNoiBoId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByPhongVanBanNoiBo(phongVanBanNoiBoId, start, end);
    }

    public static java.util.List<com.sgs.portlet.sovanbannoibo.model.SoPhongVanBanNoiBo> findByPhongVanBanNoiBo(
        java.lang.String phongVanBanNoiBoId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByPhongVanBanNoiBo(phongVanBanNoiBoId, start, end, obc);
    }

    public static com.sgs.portlet.sovanbannoibo.model.SoPhongVanBanNoiBo findByPhongVanBanNoiBo_First(
        java.lang.String phongVanBanNoiBoId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.sovanbannoibo.NoSuchSoPhongVanBanNoiBoException {
        return getPersistence()
                   .findByPhongVanBanNoiBo_First(phongVanBanNoiBoId, obc);
    }

    public static com.sgs.portlet.sovanbannoibo.model.SoPhongVanBanNoiBo findByPhongVanBanNoiBo_Last(
        java.lang.String phongVanBanNoiBoId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.sovanbannoibo.NoSuchSoPhongVanBanNoiBoException {
        return getPersistence()
                   .findByPhongVanBanNoiBo_Last(phongVanBanNoiBoId, obc);
    }

    public static com.sgs.portlet.sovanbannoibo.model.SoPhongVanBanNoiBo[] findByPhongVanBanNoiBo_PrevAndNext(
        com.sgs.portlet.sovanbannoibo.service.persistence.SoPhongVanBanNoiBoPK soPhongVanBanNoiBoPK,
        java.lang.String phongVanBanNoiBoId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.sovanbannoibo.NoSuchSoPhongVanBanNoiBoException {
        return getPersistence()
                   .findByPhongVanBanNoiBo_PrevAndNext(soPhongVanBanNoiBoPK,
            phongVanBanNoiBoId, obc);
    }

    public static java.util.List<com.sgs.portlet.sovanbannoibo.model.SoPhongVanBanNoiBo> findBySoVanBanNoiBo_PhongVanBanNoiBo(
        long soVanBanNoiBoId, java.lang.String phongVanBanNoiBoId)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findBySoVanBanNoiBo_PhongVanBanNoiBo(soVanBanNoiBoId,
            phongVanBanNoiBoId);
    }

    public static java.util.List<com.sgs.portlet.sovanbannoibo.model.SoPhongVanBanNoiBo> findBySoVanBanNoiBo_PhongVanBanNoiBo(
        long soVanBanNoiBoId, java.lang.String phongVanBanNoiBoId, int start,
        int end) throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findBySoVanBanNoiBo_PhongVanBanNoiBo(soVanBanNoiBoId,
            phongVanBanNoiBoId, start, end);
    }

    public static java.util.List<com.sgs.portlet.sovanbannoibo.model.SoPhongVanBanNoiBo> findBySoVanBanNoiBo_PhongVanBanNoiBo(
        long soVanBanNoiBoId, java.lang.String phongVanBanNoiBoId, int start,
        int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findBySoVanBanNoiBo_PhongVanBanNoiBo(soVanBanNoiBoId,
            phongVanBanNoiBoId, start, end, obc);
    }

    public static com.sgs.portlet.sovanbannoibo.model.SoPhongVanBanNoiBo findBySoVanBanNoiBo_PhongVanBanNoiBo_First(
        long soVanBanNoiBoId, java.lang.String phongVanBanNoiBoId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.sovanbannoibo.NoSuchSoPhongVanBanNoiBoException {
        return getPersistence()
                   .findBySoVanBanNoiBo_PhongVanBanNoiBo_First(soVanBanNoiBoId,
            phongVanBanNoiBoId, obc);
    }

    public static com.sgs.portlet.sovanbannoibo.model.SoPhongVanBanNoiBo findBySoVanBanNoiBo_PhongVanBanNoiBo_Last(
        long soVanBanNoiBoId, java.lang.String phongVanBanNoiBoId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.sovanbannoibo.NoSuchSoPhongVanBanNoiBoException {
        return getPersistence()
                   .findBySoVanBanNoiBo_PhongVanBanNoiBo_Last(soVanBanNoiBoId,
            phongVanBanNoiBoId, obc);
    }

    public static com.sgs.portlet.sovanbannoibo.model.SoPhongVanBanNoiBo[] findBySoVanBanNoiBo_PhongVanBanNoiBo_PrevAndNext(
        com.sgs.portlet.sovanbannoibo.service.persistence.SoPhongVanBanNoiBoPK soPhongVanBanNoiBoPK,
        long soVanBanNoiBoId, java.lang.String phongVanBanNoiBoId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.sovanbannoibo.NoSuchSoPhongVanBanNoiBoException {
        return getPersistence()
                   .findBySoVanBanNoiBo_PhongVanBanNoiBo_PrevAndNext(soPhongVanBanNoiBoPK,
            soVanBanNoiBoId, phongVanBanNoiBoId, obc);
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

    public static java.util.List<com.sgs.portlet.sovanbannoibo.model.SoPhongVanBanNoiBo> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.sgs.portlet.sovanbannoibo.model.SoPhongVanBanNoiBo> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.sgs.portlet.sovanbannoibo.model.SoPhongVanBanNoiBo> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end, obc);
    }

    public static void removeBySoVanBanNoiBo(long soVanBanNoiBoId)
        throws com.liferay.portal.SystemException {
        getPersistence().removeBySoVanBanNoiBo(soVanBanNoiBoId);
    }

    public static void removeByPhongVanBanNoiBo(
        java.lang.String phongVanBanNoiBoId)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByPhongVanBanNoiBo(phongVanBanNoiBoId);
    }

    public static void removeBySoVanBanNoiBo_PhongVanBanNoiBo(
        long soVanBanNoiBoId, java.lang.String phongVanBanNoiBoId)
        throws com.liferay.portal.SystemException {
        getPersistence()
            .removeBySoVanBanNoiBo_PhongVanBanNoiBo(soVanBanNoiBoId,
            phongVanBanNoiBoId);
    }

    public static void removeAll() throws com.liferay.portal.SystemException {
        getPersistence().removeAll();
    }

    public static int countBySoVanBanNoiBo(long soVanBanNoiBoId)
        throws com.liferay.portal.SystemException {
        return getPersistence().countBySoVanBanNoiBo(soVanBanNoiBoId);
    }

    public static int countByPhongVanBanNoiBo(
        java.lang.String phongVanBanNoiBoId)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByPhongVanBanNoiBo(phongVanBanNoiBoId);
    }

    public static int countBySoVanBanNoiBo_PhongVanBanNoiBo(
        long soVanBanNoiBoId, java.lang.String phongVanBanNoiBoId)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .countBySoVanBanNoiBo_PhongVanBanNoiBo(soVanBanNoiBoId,
            phongVanBanNoiBoId);
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

    public static SoPhongVanBanNoiBoPersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(SoPhongVanBanNoiBoPersistence persistence) {
        _persistence = persistence;
    }
}
