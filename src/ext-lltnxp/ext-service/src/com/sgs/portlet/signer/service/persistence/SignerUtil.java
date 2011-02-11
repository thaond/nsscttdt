package com.sgs.portlet.signer.service.persistence;

public class SignerUtil {
    private static SignerPersistence _persistence;

    public static com.sgs.portlet.signer.model.Signer create(long signerId) {
        return getPersistence().create(signerId);
    }

    public static com.sgs.portlet.signer.model.Signer remove(long signerId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.signer.NoSuchSignerException {
        return getPersistence().remove(signerId);
    }

    public static com.sgs.portlet.signer.model.Signer remove(
        com.sgs.portlet.signer.model.Signer signer)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(signer);
    }

    /**
     * @deprecated Use <code>update(Signer signer, boolean merge)</code>.
     */
    public static com.sgs.portlet.signer.model.Signer update(
        com.sgs.portlet.signer.model.Signer signer)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(signer);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                signer the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when signer is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public static com.sgs.portlet.signer.model.Signer update(
        com.sgs.portlet.signer.model.Signer signer, boolean merge)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(signer, merge);
    }

    public static com.sgs.portlet.signer.model.Signer updateImpl(
        com.sgs.portlet.signer.model.Signer signer, boolean merge)
        throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(signer, merge);
    }

    public static com.sgs.portlet.signer.model.Signer findByPrimaryKey(
        long signerId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.signer.NoSuchSignerException {
        return getPersistence().findByPrimaryKey(signerId);
    }

    public static com.sgs.portlet.signer.model.Signer fetchByPrimaryKey(
        long signerId) throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(signerId);
    }

    public static com.sgs.portlet.signer.model.Signer findByUserId(long userId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.signer.NoSuchSignerException {
        return getPersistence().findByUserId(userId);
    }

    public static com.sgs.portlet.signer.model.Signer fetchByUserId(long userId)
        throws com.liferay.portal.SystemException {
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

    public static java.util.List<com.sgs.portlet.signer.model.Signer> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.sgs.portlet.signer.model.Signer> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.sgs.portlet.signer.model.Signer> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end, obc);
    }

    public static void removeByUserId(long userId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.signer.NoSuchSignerException {
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

    public static SignerPersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(SignerPersistence persistence) {
        _persistence = persistence;
    }
}
