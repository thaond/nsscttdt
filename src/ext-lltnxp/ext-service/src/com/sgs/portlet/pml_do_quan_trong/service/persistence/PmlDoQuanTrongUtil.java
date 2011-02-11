package com.sgs.portlet.pml_do_quan_trong.service.persistence;

public class PmlDoQuanTrongUtil {
    private static PmlDoQuanTrongPersistence _persistence;

    public static com.sgs.portlet.pml_do_quan_trong.model.PmlDoQuanTrong create(
        long idDoQuanTrong) {
        return getPersistence().create(idDoQuanTrong);
    }

    public static com.sgs.portlet.pml_do_quan_trong.model.PmlDoQuanTrong remove(
        long idDoQuanTrong)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pml_do_quan_trong.NoSuchPmlDoQuanTrongException {
        return getPersistence().remove(idDoQuanTrong);
    }

    public static com.sgs.portlet.pml_do_quan_trong.model.PmlDoQuanTrong remove(
        com.sgs.portlet.pml_do_quan_trong.model.PmlDoQuanTrong pmlDoQuanTrong)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(pmlDoQuanTrong);
    }

    /**
     * @deprecated Use <code>update(PmlDoQuanTrong pmlDoQuanTrong, boolean merge)</code>.
     */
    public static com.sgs.portlet.pml_do_quan_trong.model.PmlDoQuanTrong update(
        com.sgs.portlet.pml_do_quan_trong.model.PmlDoQuanTrong pmlDoQuanTrong)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(pmlDoQuanTrong);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlDoQuanTrong the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlDoQuanTrong is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public static com.sgs.portlet.pml_do_quan_trong.model.PmlDoQuanTrong update(
        com.sgs.portlet.pml_do_quan_trong.model.PmlDoQuanTrong pmlDoQuanTrong,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().update(pmlDoQuanTrong, merge);
    }

    public static com.sgs.portlet.pml_do_quan_trong.model.PmlDoQuanTrong updateImpl(
        com.sgs.portlet.pml_do_quan_trong.model.PmlDoQuanTrong pmlDoQuanTrong,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(pmlDoQuanTrong, merge);
    }

    public static com.sgs.portlet.pml_do_quan_trong.model.PmlDoQuanTrong findByPrimaryKey(
        long idDoQuanTrong)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pml_do_quan_trong.NoSuchPmlDoQuanTrongException {
        return getPersistence().findByPrimaryKey(idDoQuanTrong);
    }

    public static com.sgs.portlet.pml_do_quan_trong.model.PmlDoQuanTrong fetchByPrimaryKey(
        long idDoQuanTrong) throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(idDoQuanTrong);
    }

    public static java.util.List<com.sgs.portlet.pml_do_quan_trong.model.PmlDoQuanTrong> findByTenDoQuanTrong(
        java.lang.String tenDoQuanTrong)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByTenDoQuanTrong(tenDoQuanTrong);
    }

    public static java.util.List<com.sgs.portlet.pml_do_quan_trong.model.PmlDoQuanTrong> findByTenDoQuanTrong(
        java.lang.String tenDoQuanTrong, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByTenDoQuanTrong(tenDoQuanTrong, start, end);
    }

    public static java.util.List<com.sgs.portlet.pml_do_quan_trong.model.PmlDoQuanTrong> findByTenDoQuanTrong(
        java.lang.String tenDoQuanTrong, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByTenDoQuanTrong(tenDoQuanTrong, start, end, obc);
    }

    public static com.sgs.portlet.pml_do_quan_trong.model.PmlDoQuanTrong findByTenDoQuanTrong_First(
        java.lang.String tenDoQuanTrong,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pml_do_quan_trong.NoSuchPmlDoQuanTrongException {
        return getPersistence().findByTenDoQuanTrong_First(tenDoQuanTrong, obc);
    }

    public static com.sgs.portlet.pml_do_quan_trong.model.PmlDoQuanTrong findByTenDoQuanTrong_Last(
        java.lang.String tenDoQuanTrong,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pml_do_quan_trong.NoSuchPmlDoQuanTrongException {
        return getPersistence().findByTenDoQuanTrong_Last(tenDoQuanTrong, obc);
    }

    public static com.sgs.portlet.pml_do_quan_trong.model.PmlDoQuanTrong[] findByTenDoQuanTrong_PrevAndNext(
        long idDoQuanTrong, java.lang.String tenDoQuanTrong,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pml_do_quan_trong.NoSuchPmlDoQuanTrongException {
        return getPersistence()
                   .findByTenDoQuanTrong_PrevAndNext(idDoQuanTrong,
            tenDoQuanTrong, obc);
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

    public static java.util.List<com.sgs.portlet.pml_do_quan_trong.model.PmlDoQuanTrong> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.sgs.portlet.pml_do_quan_trong.model.PmlDoQuanTrong> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.sgs.portlet.pml_do_quan_trong.model.PmlDoQuanTrong> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end, obc);
    }

    public static void removeByTenDoQuanTrong(java.lang.String tenDoQuanTrong)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByTenDoQuanTrong(tenDoQuanTrong);
    }

    public static void removeAll() throws com.liferay.portal.SystemException {
        getPersistence().removeAll();
    }

    public static int countByTenDoQuanTrong(java.lang.String tenDoQuanTrong)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByTenDoQuanTrong(tenDoQuanTrong);
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

    public static PmlDoQuanTrongPersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(PmlDoQuanTrongPersistence persistence) {
        _persistence = persistence;
    }
}
