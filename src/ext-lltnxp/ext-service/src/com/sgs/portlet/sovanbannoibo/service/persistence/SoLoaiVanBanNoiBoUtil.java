package com.sgs.portlet.sovanbannoibo.service.persistence;

public class SoLoaiVanBanNoiBoUtil {
    private static SoLoaiVanBanNoiBoPersistence _persistence;

    public static com.sgs.portlet.sovanbannoibo.model.SoLoaiVanBanNoiBo create(
        com.sgs.portlet.sovanbannoibo.service.persistence.SoLoaiVanBanNoiBoPK soLoaiVanBanNoiBoPK) {
        return getPersistence().create(soLoaiVanBanNoiBoPK);
    }

    public static com.sgs.portlet.sovanbannoibo.model.SoLoaiVanBanNoiBo remove(
        com.sgs.portlet.sovanbannoibo.service.persistence.SoLoaiVanBanNoiBoPK soLoaiVanBanNoiBoPK)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.sovanbannoibo.NoSuchSoLoaiVanBanNoiBoException {
        return getPersistence().remove(soLoaiVanBanNoiBoPK);
    }

    public static com.sgs.portlet.sovanbannoibo.model.SoLoaiVanBanNoiBo remove(
        com.sgs.portlet.sovanbannoibo.model.SoLoaiVanBanNoiBo soLoaiVanBanNoiBo)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(soLoaiVanBanNoiBo);
    }

    /**
     * @deprecated Use <code>update(SoLoaiVanBanNoiBo soLoaiVanBanNoiBo, boolean merge)</code>.
     */
    public static com.sgs.portlet.sovanbannoibo.model.SoLoaiVanBanNoiBo update(
        com.sgs.portlet.sovanbannoibo.model.SoLoaiVanBanNoiBo soLoaiVanBanNoiBo)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(soLoaiVanBanNoiBo);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                soLoaiVanBanNoiBo the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when soLoaiVanBanNoiBo is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public static com.sgs.portlet.sovanbannoibo.model.SoLoaiVanBanNoiBo update(
        com.sgs.portlet.sovanbannoibo.model.SoLoaiVanBanNoiBo soLoaiVanBanNoiBo,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().update(soLoaiVanBanNoiBo, merge);
    }

    public static com.sgs.portlet.sovanbannoibo.model.SoLoaiVanBanNoiBo updateImpl(
        com.sgs.portlet.sovanbannoibo.model.SoLoaiVanBanNoiBo soLoaiVanBanNoiBo,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(soLoaiVanBanNoiBo, merge);
    }

    public static com.sgs.portlet.sovanbannoibo.model.SoLoaiVanBanNoiBo findByPrimaryKey(
        com.sgs.portlet.sovanbannoibo.service.persistence.SoLoaiVanBanNoiBoPK soLoaiVanBanNoiBoPK)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.sovanbannoibo.NoSuchSoLoaiVanBanNoiBoException {
        return getPersistence().findByPrimaryKey(soLoaiVanBanNoiBoPK);
    }

    public static com.sgs.portlet.sovanbannoibo.model.SoLoaiVanBanNoiBo fetchByPrimaryKey(
        com.sgs.portlet.sovanbannoibo.service.persistence.SoLoaiVanBanNoiBoPK soLoaiVanBanNoiBoPK)
        throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(soLoaiVanBanNoiBoPK);
    }

    public static java.util.List<com.sgs.portlet.sovanbannoibo.model.SoLoaiVanBanNoiBo> findBySoVanBanNoiBo(
        long soVanBanNoiBoId) throws com.liferay.portal.SystemException {
        return getPersistence().findBySoVanBanNoiBo(soVanBanNoiBoId);
    }

    public static java.util.List<com.sgs.portlet.sovanbannoibo.model.SoLoaiVanBanNoiBo> findBySoVanBanNoiBo(
        long soVanBanNoiBoId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findBySoVanBanNoiBo(soVanBanNoiBoId, start, end);
    }

    public static java.util.List<com.sgs.portlet.sovanbannoibo.model.SoLoaiVanBanNoiBo> findBySoVanBanNoiBo(
        long soVanBanNoiBoId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findBySoVanBanNoiBo(soVanBanNoiBoId, start, end, obc);
    }

    public static com.sgs.portlet.sovanbannoibo.model.SoLoaiVanBanNoiBo findBySoVanBanNoiBo_First(
        long soVanBanNoiBoId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.sovanbannoibo.NoSuchSoLoaiVanBanNoiBoException {
        return getPersistence().findBySoVanBanNoiBo_First(soVanBanNoiBoId, obc);
    }

    public static com.sgs.portlet.sovanbannoibo.model.SoLoaiVanBanNoiBo findBySoVanBanNoiBo_Last(
        long soVanBanNoiBoId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.sovanbannoibo.NoSuchSoLoaiVanBanNoiBoException {
        return getPersistence().findBySoVanBanNoiBo_Last(soVanBanNoiBoId, obc);
    }

    public static com.sgs.portlet.sovanbannoibo.model.SoLoaiVanBanNoiBo[] findBySoVanBanNoiBo_PrevAndNext(
        com.sgs.portlet.sovanbannoibo.service.persistence.SoLoaiVanBanNoiBoPK soLoaiVanBanNoiBoPK,
        long soVanBanNoiBoId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.sovanbannoibo.NoSuchSoLoaiVanBanNoiBoException {
        return getPersistence()
                   .findBySoVanBanNoiBo_PrevAndNext(soLoaiVanBanNoiBoPK,
            soVanBanNoiBoId, obc);
    }

    public static java.util.List<com.sgs.portlet.sovanbannoibo.model.SoLoaiVanBanNoiBo> findByLoaiVanBanNoiBo(
        long loaiVanBanNoiBoId) throws com.liferay.portal.SystemException {
        return getPersistence().findByLoaiVanBanNoiBo(loaiVanBanNoiBoId);
    }

    public static java.util.List<com.sgs.portlet.sovanbannoibo.model.SoLoaiVanBanNoiBo> findByLoaiVanBanNoiBo(
        long loaiVanBanNoiBoId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByLoaiVanBanNoiBo(loaiVanBanNoiBoId, start, end);
    }

    public static java.util.List<com.sgs.portlet.sovanbannoibo.model.SoLoaiVanBanNoiBo> findByLoaiVanBanNoiBo(
        long loaiVanBanNoiBoId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByLoaiVanBanNoiBo(loaiVanBanNoiBoId, start, end, obc);
    }

    public static com.sgs.portlet.sovanbannoibo.model.SoLoaiVanBanNoiBo findByLoaiVanBanNoiBo_First(
        long loaiVanBanNoiBoId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.sovanbannoibo.NoSuchSoLoaiVanBanNoiBoException {
        return getPersistence()
                   .findByLoaiVanBanNoiBo_First(loaiVanBanNoiBoId, obc);
    }

    public static com.sgs.portlet.sovanbannoibo.model.SoLoaiVanBanNoiBo findByLoaiVanBanNoiBo_Last(
        long loaiVanBanNoiBoId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.sovanbannoibo.NoSuchSoLoaiVanBanNoiBoException {
        return getPersistence()
                   .findByLoaiVanBanNoiBo_Last(loaiVanBanNoiBoId, obc);
    }

    public static com.sgs.portlet.sovanbannoibo.model.SoLoaiVanBanNoiBo[] findByLoaiVanBanNoiBo_PrevAndNext(
        com.sgs.portlet.sovanbannoibo.service.persistence.SoLoaiVanBanNoiBoPK soLoaiVanBanNoiBoPK,
        long loaiVanBanNoiBoId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.sovanbannoibo.NoSuchSoLoaiVanBanNoiBoException {
        return getPersistence()
                   .findByLoaiVanBanNoiBo_PrevAndNext(soLoaiVanBanNoiBoPK,
            loaiVanBanNoiBoId, obc);
    }

    public static java.util.List<com.sgs.portlet.sovanbannoibo.model.SoLoaiVanBanNoiBo> findBySoVanBanNoiBo_LoaiVanBanNoiBo(
        long soVanBanNoiBoId, long loaiVanBanNoiBoId)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findBySoVanBanNoiBo_LoaiVanBanNoiBo(soVanBanNoiBoId,
            loaiVanBanNoiBoId);
    }

    public static java.util.List<com.sgs.portlet.sovanbannoibo.model.SoLoaiVanBanNoiBo> findBySoVanBanNoiBo_LoaiVanBanNoiBo(
        long soVanBanNoiBoId, long loaiVanBanNoiBoId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findBySoVanBanNoiBo_LoaiVanBanNoiBo(soVanBanNoiBoId,
            loaiVanBanNoiBoId, start, end);
    }

    public static java.util.List<com.sgs.portlet.sovanbannoibo.model.SoLoaiVanBanNoiBo> findBySoVanBanNoiBo_LoaiVanBanNoiBo(
        long soVanBanNoiBoId, long loaiVanBanNoiBoId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findBySoVanBanNoiBo_LoaiVanBanNoiBo(soVanBanNoiBoId,
            loaiVanBanNoiBoId, start, end, obc);
    }

    public static com.sgs.portlet.sovanbannoibo.model.SoLoaiVanBanNoiBo findBySoVanBanNoiBo_LoaiVanBanNoiBo_First(
        long soVanBanNoiBoId, long loaiVanBanNoiBoId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.sovanbannoibo.NoSuchSoLoaiVanBanNoiBoException {
        return getPersistence()
                   .findBySoVanBanNoiBo_LoaiVanBanNoiBo_First(soVanBanNoiBoId,
            loaiVanBanNoiBoId, obc);
    }

    public static com.sgs.portlet.sovanbannoibo.model.SoLoaiVanBanNoiBo findBySoVanBanNoiBo_LoaiVanBanNoiBo_Last(
        long soVanBanNoiBoId, long loaiVanBanNoiBoId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.sovanbannoibo.NoSuchSoLoaiVanBanNoiBoException {
        return getPersistence()
                   .findBySoVanBanNoiBo_LoaiVanBanNoiBo_Last(soVanBanNoiBoId,
            loaiVanBanNoiBoId, obc);
    }

    public static com.sgs.portlet.sovanbannoibo.model.SoLoaiVanBanNoiBo[] findBySoVanBanNoiBo_LoaiVanBanNoiBo_PrevAndNext(
        com.sgs.portlet.sovanbannoibo.service.persistence.SoLoaiVanBanNoiBoPK soLoaiVanBanNoiBoPK,
        long soVanBanNoiBoId, long loaiVanBanNoiBoId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.sovanbannoibo.NoSuchSoLoaiVanBanNoiBoException {
        return getPersistence()
                   .findBySoVanBanNoiBo_LoaiVanBanNoiBo_PrevAndNext(soLoaiVanBanNoiBoPK,
            soVanBanNoiBoId, loaiVanBanNoiBoId, obc);
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

    public static java.util.List<com.sgs.portlet.sovanbannoibo.model.SoLoaiVanBanNoiBo> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.sgs.portlet.sovanbannoibo.model.SoLoaiVanBanNoiBo> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.sgs.portlet.sovanbannoibo.model.SoLoaiVanBanNoiBo> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end, obc);
    }

    public static void removeBySoVanBanNoiBo(long soVanBanNoiBoId)
        throws com.liferay.portal.SystemException {
        getPersistence().removeBySoVanBanNoiBo(soVanBanNoiBoId);
    }

    public static void removeByLoaiVanBanNoiBo(long loaiVanBanNoiBoId)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByLoaiVanBanNoiBo(loaiVanBanNoiBoId);
    }

    public static void removeBySoVanBanNoiBo_LoaiVanBanNoiBo(
        long soVanBanNoiBoId, long loaiVanBanNoiBoId)
        throws com.liferay.portal.SystemException {
        getPersistence()
            .removeBySoVanBanNoiBo_LoaiVanBanNoiBo(soVanBanNoiBoId,
            loaiVanBanNoiBoId);
    }

    public static void removeAll() throws com.liferay.portal.SystemException {
        getPersistence().removeAll();
    }

    public static int countBySoVanBanNoiBo(long soVanBanNoiBoId)
        throws com.liferay.portal.SystemException {
        return getPersistence().countBySoVanBanNoiBo(soVanBanNoiBoId);
    }

    public static int countByLoaiVanBanNoiBo(long loaiVanBanNoiBoId)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByLoaiVanBanNoiBo(loaiVanBanNoiBoId);
    }

    public static int countBySoVanBanNoiBo_LoaiVanBanNoiBo(
        long soVanBanNoiBoId, long loaiVanBanNoiBoId)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .countBySoVanBanNoiBo_LoaiVanBanNoiBo(soVanBanNoiBoId,
            loaiVanBanNoiBoId);
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

    public static SoLoaiVanBanNoiBoPersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(SoLoaiVanBanNoiBoPersistence persistence) {
        _persistence = persistence;
    }
}
