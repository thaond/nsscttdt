package com.sgs.portlet.career.service.persistence;

public class CareerUtil {
    private static CareerPersistence _persistence;

    public static com.sgs.portlet.career.model.Career create(
        java.lang.String careerId) {
        return getPersistence().create(careerId);
    }

    public static com.sgs.portlet.career.model.Career remove(
        java.lang.String careerId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.career.NoSuchCareerException {
        return getPersistence().remove(careerId);
    }

    public static com.sgs.portlet.career.model.Career remove(
        com.sgs.portlet.career.model.Career career)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(career);
    }

    /**
     * @deprecated Use <code>update(Career career, boolean merge)</code>.
     */
    public static com.sgs.portlet.career.model.Career update(
        com.sgs.portlet.career.model.Career career)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(career);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                career the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when career is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public static com.sgs.portlet.career.model.Career update(
        com.sgs.portlet.career.model.Career career, boolean merge)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(career, merge);
    }

    public static com.sgs.portlet.career.model.Career updateImpl(
        com.sgs.portlet.career.model.Career career, boolean merge)
        throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(career, merge);
    }

    public static com.sgs.portlet.career.model.Career findByPrimaryKey(
        java.lang.String careerId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.career.NoSuchCareerException {
        return getPersistence().findByPrimaryKey(careerId);
    }

    public static com.sgs.portlet.career.model.Career fetchByPrimaryKey(
        java.lang.String careerId) throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(careerId);
    }

    public static java.util.List<com.sgs.portlet.career.model.Career> findByCareerCode(
        java.lang.String careerCode) throws com.liferay.portal.SystemException {
        return getPersistence().findByCareerCode(careerCode);
    }

    public static java.util.List<com.sgs.portlet.career.model.Career> findByCareerCode(
        java.lang.String careerCode, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByCareerCode(careerCode, start, end);
    }

    public static java.util.List<com.sgs.portlet.career.model.Career> findByCareerCode(
        java.lang.String careerCode, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByCareerCode(careerCode, start, end, obc);
    }

    public static com.sgs.portlet.career.model.Career findByCareerCode_First(
        java.lang.String careerCode,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.career.NoSuchCareerException {
        return getPersistence().findByCareerCode_First(careerCode, obc);
    }

    public static com.sgs.portlet.career.model.Career findByCareerCode_Last(
        java.lang.String careerCode,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.career.NoSuchCareerException {
        return getPersistence().findByCareerCode_Last(careerCode, obc);
    }

    public static com.sgs.portlet.career.model.Career[] findByCareerCode_PrevAndNext(
        java.lang.String careerId, java.lang.String careerCode,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.career.NoSuchCareerException {
        return getPersistence()
                   .findByCareerCode_PrevAndNext(careerId, careerCode, obc);
    }

    public static java.util.List<com.sgs.portlet.career.model.Career> findByCareerName(
        java.lang.String careerName) throws com.liferay.portal.SystemException {
        return getPersistence().findByCareerName(careerName);
    }

    public static java.util.List<com.sgs.portlet.career.model.Career> findByCareerName(
        java.lang.String careerName, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByCareerName(careerName, start, end);
    }

    public static java.util.List<com.sgs.portlet.career.model.Career> findByCareerName(
        java.lang.String careerName, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByCareerName(careerName, start, end, obc);
    }

    public static com.sgs.portlet.career.model.Career findByCareerName_First(
        java.lang.String careerName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.career.NoSuchCareerException {
        return getPersistence().findByCareerName_First(careerName, obc);
    }

    public static com.sgs.portlet.career.model.Career findByCareerName_Last(
        java.lang.String careerName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.career.NoSuchCareerException {
        return getPersistence().findByCareerName_Last(careerName, obc);
    }

    public static com.sgs.portlet.career.model.Career[] findByCareerName_PrevAndNext(
        java.lang.String careerId, java.lang.String careerName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.career.NoSuchCareerException {
        return getPersistence()
                   .findByCareerName_PrevAndNext(careerId, careerName, obc);
    }

    public static java.util.List<com.sgs.portlet.career.model.Career> findByDescription(
        java.lang.String description) throws com.liferay.portal.SystemException {
        return getPersistence().findByDescription(description);
    }

    public static java.util.List<com.sgs.portlet.career.model.Career> findByDescription(
        java.lang.String description, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByDescription(description, start, end);
    }

    public static java.util.List<com.sgs.portlet.career.model.Career> findByDescription(
        java.lang.String description, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByDescription(description, start, end, obc);
    }

    public static com.sgs.portlet.career.model.Career findByDescription_First(
        java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.career.NoSuchCareerException {
        return getPersistence().findByDescription_First(description, obc);
    }

    public static com.sgs.portlet.career.model.Career findByDescription_Last(
        java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.career.NoSuchCareerException {
        return getPersistence().findByDescription_Last(description, obc);
    }

    public static com.sgs.portlet.career.model.Career[] findByDescription_PrevAndNext(
        java.lang.String careerId, java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.career.NoSuchCareerException {
        return getPersistence()
                   .findByDescription_PrevAndNext(careerId, description, obc);
    }

    public static java.util.List<com.sgs.portlet.career.model.Career> findByC_N_D(
        java.lang.String careerCode, java.lang.String careerName,
        java.lang.String description) throws com.liferay.portal.SystemException {
        return getPersistence().findByC_N_D(careerCode, careerName, description);
    }

    public static java.util.List<com.sgs.portlet.career.model.Career> findByC_N_D(
        java.lang.String careerCode, java.lang.String careerName,
        java.lang.String description, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByC_N_D(careerCode, careerName, description, start, end);
    }

    public static java.util.List<com.sgs.portlet.career.model.Career> findByC_N_D(
        java.lang.String careerCode, java.lang.String careerName,
        java.lang.String description, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByC_N_D(careerCode, careerName, description, start,
            end, obc);
    }

    public static com.sgs.portlet.career.model.Career findByC_N_D_First(
        java.lang.String careerCode, java.lang.String careerName,
        java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.career.NoSuchCareerException {
        return getPersistence()
                   .findByC_N_D_First(careerCode, careerName, description, obc);
    }

    public static com.sgs.portlet.career.model.Career findByC_N_D_Last(
        java.lang.String careerCode, java.lang.String careerName,
        java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.career.NoSuchCareerException {
        return getPersistence()
                   .findByC_N_D_Last(careerCode, careerName, description, obc);
    }

    public static com.sgs.portlet.career.model.Career[] findByC_N_D_PrevAndNext(
        java.lang.String careerId, java.lang.String careerCode,
        java.lang.String careerName, java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.career.NoSuchCareerException {
        return getPersistence()
                   .findByC_N_D_PrevAndNext(careerId, careerCode, careerName,
            description, obc);
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

    public static java.util.List<com.sgs.portlet.career.model.Career> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.sgs.portlet.career.model.Career> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.sgs.portlet.career.model.Career> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end, obc);
    }

    public static void removeByCareerCode(java.lang.String careerCode)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByCareerCode(careerCode);
    }

    public static void removeByCareerName(java.lang.String careerName)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByCareerName(careerName);
    }

    public static void removeByDescription(java.lang.String description)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByDescription(description);
    }

    public static void removeByC_N_D(java.lang.String careerCode,
        java.lang.String careerName, java.lang.String description)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByC_N_D(careerCode, careerName, description);
    }

    public static void removeAll() throws com.liferay.portal.SystemException {
        getPersistence().removeAll();
    }

    public static int countByCareerCode(java.lang.String careerCode)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByCareerCode(careerCode);
    }

    public static int countByCareerName(java.lang.String careerName)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByCareerName(careerName);
    }

    public static int countByDescription(java.lang.String description)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByDescription(description);
    }

    public static int countByC_N_D(java.lang.String careerCode,
        java.lang.String careerName, java.lang.String description)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByC_N_D(careerCode, careerName, description);
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

    public static CareerPersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(CareerPersistence persistence) {
        _persistence = persistence;
    }
}
