package com.sgs.portlet.pmlstreet.service.persistence;

public class PmlStreetUtil {
    private static PmlStreetPersistence _persistence;

    public static com.sgs.portlet.pmlstreet.model.PmlStreet create(
        java.lang.String streetId) {
        return getPersistence().create(streetId);
    }

    public static com.sgs.portlet.pmlstreet.model.PmlStreet remove(
        java.lang.String streetId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pmlstreet.NoSuchException {
        return getPersistence().remove(streetId);
    }

    public static com.sgs.portlet.pmlstreet.model.PmlStreet remove(
        com.sgs.portlet.pmlstreet.model.PmlStreet pmlStreet)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(pmlStreet);
    }

    /**
     * @deprecated Use <code>update(PmlStreet pmlStreet, boolean merge)</code>.
     */
    public static com.sgs.portlet.pmlstreet.model.PmlStreet update(
        com.sgs.portlet.pmlstreet.model.PmlStreet pmlStreet)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(pmlStreet);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlStreet the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlStreet is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public static com.sgs.portlet.pmlstreet.model.PmlStreet update(
        com.sgs.portlet.pmlstreet.model.PmlStreet pmlStreet, boolean merge)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(pmlStreet, merge);
    }

    public static com.sgs.portlet.pmlstreet.model.PmlStreet updateImpl(
        com.sgs.portlet.pmlstreet.model.PmlStreet pmlStreet, boolean merge)
        throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(pmlStreet, merge);
    }

    public static com.sgs.portlet.pmlstreet.model.PmlStreet findByPrimaryKey(
        java.lang.String streetId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pmlstreet.NoSuchException {
        return getPersistence().findByPrimaryKey(streetId);
    }

    public static com.sgs.portlet.pmlstreet.model.PmlStreet fetchByPrimaryKey(
        java.lang.String streetId) throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(streetId);
    }

    public static java.util.List<com.sgs.portlet.pmlstreet.model.PmlStreet> findByStreetName(
        java.lang.String streetName) throws com.liferay.portal.SystemException {
        return getPersistence().findByStreetName(streetName);
    }

    public static java.util.List<com.sgs.portlet.pmlstreet.model.PmlStreet> findByStreetName(
        java.lang.String streetName, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByStreetName(streetName, start, end);
    }

    public static java.util.List<com.sgs.portlet.pmlstreet.model.PmlStreet> findByStreetName(
        java.lang.String streetName, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByStreetName(streetName, start, end, obc);
    }

    public static com.sgs.portlet.pmlstreet.model.PmlStreet findByStreetName_First(
        java.lang.String streetName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pmlstreet.NoSuchException {
        return getPersistence().findByStreetName_First(streetName, obc);
    }

    public static com.sgs.portlet.pmlstreet.model.PmlStreet findByStreetName_Last(
        java.lang.String streetName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pmlstreet.NoSuchException {
        return getPersistence().findByStreetName_Last(streetName, obc);
    }

    public static com.sgs.portlet.pmlstreet.model.PmlStreet[] findByStreetName_PrevAndNext(
        java.lang.String streetId, java.lang.String streetName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pmlstreet.NoSuchException {
        return getPersistence()
                   .findByStreetName_PrevAndNext(streetId, streetName, obc);
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

    public static java.util.List<com.sgs.portlet.pmlstreet.model.PmlStreet> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.sgs.portlet.pmlstreet.model.PmlStreet> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.sgs.portlet.pmlstreet.model.PmlStreet> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end, obc);
    }

    public static void removeByStreetName(java.lang.String streetName)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByStreetName(streetName);
    }

    public static void removeAll() throws com.liferay.portal.SystemException {
        getPersistence().removeAll();
    }

    public static int countByStreetName(java.lang.String streetName)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByStreetName(streetName);
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

    public static PmlStreetPersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(PmlStreetPersistence persistence) {
        _persistence = persistence;
    }
}
