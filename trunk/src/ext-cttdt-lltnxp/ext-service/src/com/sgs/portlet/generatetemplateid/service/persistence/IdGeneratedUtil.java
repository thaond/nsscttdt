package com.sgs.portlet.generatetemplateid.service.persistence;

public class IdGeneratedUtil {
    private static IdGeneratedPersistence _persistence;

    public static com.sgs.portlet.generatetemplateid.model.IdGenerated create(
        long id) {
        return getPersistence().create(id);
    }

    public static com.sgs.portlet.generatetemplateid.model.IdGenerated remove(
        long id)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.generatetemplateid.NoSuchIdGeneratedException {
        return getPersistence().remove(id);
    }

    public static com.sgs.portlet.generatetemplateid.model.IdGenerated remove(
        com.sgs.portlet.generatetemplateid.model.IdGenerated idGenerated)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(idGenerated);
    }

    /**
     * @deprecated Use <code>update(IdGenerated idGenerated, boolean merge)</code>.
     */
    public static com.sgs.portlet.generatetemplateid.model.IdGenerated update(
        com.sgs.portlet.generatetemplateid.model.IdGenerated idGenerated)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(idGenerated);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                idGenerated the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when idGenerated is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public static com.sgs.portlet.generatetemplateid.model.IdGenerated update(
        com.sgs.portlet.generatetemplateid.model.IdGenerated idGenerated,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().update(idGenerated, merge);
    }

    public static com.sgs.portlet.generatetemplateid.model.IdGenerated updateImpl(
        com.sgs.portlet.generatetemplateid.model.IdGenerated idGenerated,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(idGenerated, merge);
    }

    public static com.sgs.portlet.generatetemplateid.model.IdGenerated findByPrimaryKey(
        long id)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.generatetemplateid.NoSuchIdGeneratedException {
        return getPersistence().findByPrimaryKey(id);
    }

    public static com.sgs.portlet.generatetemplateid.model.IdGenerated fetchByPrimaryKey(
        long id) throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(id);
    }

    public static java.util.List<com.sgs.portlet.generatetemplateid.model.IdGenerated> findByAllLike(
        java.lang.String year, long curValue)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByAllLike(year, curValue);
    }

    public static java.util.List<com.sgs.portlet.generatetemplateid.model.IdGenerated> findByAllLike(
        java.lang.String year, long curValue, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByAllLike(year, curValue, start, end);
    }

    public static java.util.List<com.sgs.portlet.generatetemplateid.model.IdGenerated> findByAllLike(
        java.lang.String year, long curValue, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByAllLike(year, curValue, start, end, obc);
    }

    public static com.sgs.portlet.generatetemplateid.model.IdGenerated findByAllLike_First(
        java.lang.String year, long curValue,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.generatetemplateid.NoSuchIdGeneratedException {
        return getPersistence().findByAllLike_First(year, curValue, obc);
    }

    public static com.sgs.portlet.generatetemplateid.model.IdGenerated findByAllLike_Last(
        java.lang.String year, long curValue,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.generatetemplateid.NoSuchIdGeneratedException {
        return getPersistence().findByAllLike_Last(year, curValue, obc);
    }

    public static com.sgs.portlet.generatetemplateid.model.IdGenerated[] findByAllLike_PrevAndNext(
        long id, java.lang.String year, long curValue,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.generatetemplateid.NoSuchIdGeneratedException {
        return getPersistence()
                   .findByAllLike_PrevAndNext(id, year, curValue, obc);
    }

    public static java.util.List<com.sgs.portlet.generatetemplateid.model.IdGenerated> findByYear(
        java.lang.String year) throws com.liferay.portal.SystemException {
        return getPersistence().findByYear(year);
    }

    public static java.util.List<com.sgs.portlet.generatetemplateid.model.IdGenerated> findByYear(
        java.lang.String year, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByYear(year, start, end);
    }

    public static java.util.List<com.sgs.portlet.generatetemplateid.model.IdGenerated> findByYear(
        java.lang.String year, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByYear(year, start, end, obc);
    }

    public static com.sgs.portlet.generatetemplateid.model.IdGenerated findByYear_First(
        java.lang.String year,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.generatetemplateid.NoSuchIdGeneratedException {
        return getPersistence().findByYear_First(year, obc);
    }

    public static com.sgs.portlet.generatetemplateid.model.IdGenerated findByYear_Last(
        java.lang.String year,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.generatetemplateid.NoSuchIdGeneratedException {
        return getPersistence().findByYear_Last(year, obc);
    }

    public static com.sgs.portlet.generatetemplateid.model.IdGenerated[] findByYear_PrevAndNext(
        long id, java.lang.String year,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.generatetemplateid.NoSuchIdGeneratedException {
        return getPersistence().findByYear_PrevAndNext(id, year, obc);
    }

    public static java.util.List<com.sgs.portlet.generatetemplateid.model.IdGenerated> findByCurValue(
        long curValue) throws com.liferay.portal.SystemException {
        return getPersistence().findByCurValue(curValue);
    }

    public static java.util.List<com.sgs.portlet.generatetemplateid.model.IdGenerated> findByCurValue(
        long curValue, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByCurValue(curValue, start, end);
    }

    public static java.util.List<com.sgs.portlet.generatetemplateid.model.IdGenerated> findByCurValue(
        long curValue, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByCurValue(curValue, start, end, obc);
    }

    public static com.sgs.portlet.generatetemplateid.model.IdGenerated findByCurValue_First(
        long curValue, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.generatetemplateid.NoSuchIdGeneratedException {
        return getPersistence().findByCurValue_First(curValue, obc);
    }

    public static com.sgs.portlet.generatetemplateid.model.IdGenerated findByCurValue_Last(
        long curValue, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.generatetemplateid.NoSuchIdGeneratedException {
        return getPersistence().findByCurValue_Last(curValue, obc);
    }

    public static com.sgs.portlet.generatetemplateid.model.IdGenerated[] findByCurValue_PrevAndNext(
        long id, long curValue,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.generatetemplateid.NoSuchIdGeneratedException {
        return getPersistence().findByCurValue_PrevAndNext(id, curValue, obc);
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

    public static java.util.List<com.sgs.portlet.generatetemplateid.model.IdGenerated> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.sgs.portlet.generatetemplateid.model.IdGenerated> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.sgs.portlet.generatetemplateid.model.IdGenerated> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end, obc);
    }

    public static void removeByAllLike(java.lang.String year, long curValue)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByAllLike(year, curValue);
    }

    public static void removeByYear(java.lang.String year)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByYear(year);
    }

    public static void removeByCurValue(long curValue)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByCurValue(curValue);
    }

    public static void removeAll() throws com.liferay.portal.SystemException {
        getPersistence().removeAll();
    }

    public static int countByAllLike(java.lang.String year, long curValue)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByAllLike(year, curValue);
    }

    public static int countByYear(java.lang.String year)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByYear(year);
    }

    public static int countByCurValue(long curValue)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByCurValue(curValue);
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

    public static IdGeneratedPersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(IdGeneratedPersistence persistence) {
        _persistence = persistence;
    }
}
