package com.sgs.portlet.pml_edm_docconfuser.service.persistence;

public class PmlEdmDocConfUserUtil {
    private static PmlEdmDocConfUserPersistence _persistence;

    public static com.sgs.portlet.pml_edm_docconfuser.model.PmlEdmDocConfUser create(
        long dcuId) {
        return getPersistence().create(dcuId);
    }

    public static com.sgs.portlet.pml_edm_docconfuser.model.PmlEdmDocConfUser remove(
        long dcuId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pml_edm_docconfuser.NoSuchDocConfUserException {
        return getPersistence().remove(dcuId);
    }

    public static com.sgs.portlet.pml_edm_docconfuser.model.PmlEdmDocConfUser remove(
        com.sgs.portlet.pml_edm_docconfuser.model.PmlEdmDocConfUser pmlEdmDocConfUser)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(pmlEdmDocConfUser);
    }

    /**
     * @deprecated Use <code>update(PmlEdmDocConfUser pmlEdmDocConfUser, boolean merge)</code>.
     */
    public static com.sgs.portlet.pml_edm_docconfuser.model.PmlEdmDocConfUser update(
        com.sgs.portlet.pml_edm_docconfuser.model.PmlEdmDocConfUser pmlEdmDocConfUser)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(pmlEdmDocConfUser);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlEdmDocConfUser the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlEdmDocConfUser is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public static com.sgs.portlet.pml_edm_docconfuser.model.PmlEdmDocConfUser update(
        com.sgs.portlet.pml_edm_docconfuser.model.PmlEdmDocConfUser pmlEdmDocConfUser,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().update(pmlEdmDocConfUser, merge);
    }

    public static com.sgs.portlet.pml_edm_docconfuser.model.PmlEdmDocConfUser updateImpl(
        com.sgs.portlet.pml_edm_docconfuser.model.PmlEdmDocConfUser pmlEdmDocConfUser,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(pmlEdmDocConfUser, merge);
    }

    public static com.sgs.portlet.pml_edm_docconfuser.model.PmlEdmDocConfUser findByPrimaryKey(
        long dcuId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pml_edm_docconfuser.NoSuchDocConfUserException {
        return getPersistence().findByPrimaryKey(dcuId);
    }

    public static com.sgs.portlet.pml_edm_docconfuser.model.PmlEdmDocConfUser fetchByPrimaryKey(
        long dcuId) throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(dcuId);
    }

    public static com.sgs.portlet.pml_edm_docconfuser.model.PmlEdmDocConfUser findByUserId(
        long userId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pml_edm_docconfuser.NoSuchDocConfUserException {
        return getPersistence().findByUserId(userId);
    }

    public static com.sgs.portlet.pml_edm_docconfuser.model.PmlEdmDocConfUser fetchByUserId(
        long userId) throws com.liferay.portal.SystemException {
        return getPersistence().fetchByUserId(userId);
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

    public static java.util.List<com.sgs.portlet.pml_edm_docconfuser.model.PmlEdmDocConfUser> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.sgs.portlet.pml_edm_docconfuser.model.PmlEdmDocConfUser> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.sgs.portlet.pml_edm_docconfuser.model.PmlEdmDocConfUser> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end, obc);
    }

    public static void removeByUserId(long userId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pml_edm_docconfuser.NoSuchDocConfUserException {
        getPersistence().removeByUserId(userId);
    }

    public static void removeAll() throws com.liferay.portal.SystemException {
        getPersistence().removeAll();
    }

    public static int countByUserId(long userId)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByUserId(userId);
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

    public static PmlEdmDocConfUserPersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(PmlEdmDocConfUserPersistence persistence) {
        _persistence = persistence;
    }
}
