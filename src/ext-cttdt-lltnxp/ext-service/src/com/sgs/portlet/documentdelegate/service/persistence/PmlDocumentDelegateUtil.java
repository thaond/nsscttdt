package com.sgs.portlet.documentdelegate.service.persistence;

public class PmlDocumentDelegateUtil {
    private static PmlDocumentDelegatePersistence _persistence;

    public static com.sgs.portlet.documentdelegate.model.PmlDocumentDelegate create(
        long documentDelegateId) {
        return getPersistence().create(documentDelegateId);
    }

    public static com.sgs.portlet.documentdelegate.model.PmlDocumentDelegate remove(
        long documentDelegateId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.documentdelegate.NoSuchException {
        return getPersistence().remove(documentDelegateId);
    }

    public static com.sgs.portlet.documentdelegate.model.PmlDocumentDelegate remove(
        com.sgs.portlet.documentdelegate.model.PmlDocumentDelegate pmlDocumentDelegate)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(pmlDocumentDelegate);
    }

    /**
     * @deprecated Use <code>update(PmlDocumentDelegate pmlDocumentDelegate, boolean merge)</code>.
     */
    public static com.sgs.portlet.documentdelegate.model.PmlDocumentDelegate update(
        com.sgs.portlet.documentdelegate.model.PmlDocumentDelegate pmlDocumentDelegate)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(pmlDocumentDelegate);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlDocumentDelegate the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlDocumentDelegate is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public static com.sgs.portlet.documentdelegate.model.PmlDocumentDelegate update(
        com.sgs.portlet.documentdelegate.model.PmlDocumentDelegate pmlDocumentDelegate,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().update(pmlDocumentDelegate, merge);
    }

    public static com.sgs.portlet.documentdelegate.model.PmlDocumentDelegate updateImpl(
        com.sgs.portlet.documentdelegate.model.PmlDocumentDelegate pmlDocumentDelegate,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(pmlDocumentDelegate, merge);
    }

    public static com.sgs.portlet.documentdelegate.model.PmlDocumentDelegate findByPrimaryKey(
        long documentDelegateId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.documentdelegate.NoSuchException {
        return getPersistence().findByPrimaryKey(documentDelegateId);
    }

    public static com.sgs.portlet.documentdelegate.model.PmlDocumentDelegate fetchByPrimaryKey(
        long documentDelegateId) throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(documentDelegateId);
    }

    public static java.util.List<com.sgs.portlet.documentdelegate.model.PmlDocumentDelegate> findByUserIsDelegateId(
        long userIsDelegateId) throws com.liferay.portal.SystemException {
        return getPersistence().findByUserIsDelegateId(userIsDelegateId);
    }

    public static java.util.List<com.sgs.portlet.documentdelegate.model.PmlDocumentDelegate> findByUserIsDelegateId(
        long userIsDelegateId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByUserIsDelegateId(userIsDelegateId, start, end);
    }

    public static java.util.List<com.sgs.portlet.documentdelegate.model.PmlDocumentDelegate> findByUserIsDelegateId(
        long userIsDelegateId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByUserIsDelegateId(userIsDelegateId, start, end, obc);
    }

    public static com.sgs.portlet.documentdelegate.model.PmlDocumentDelegate findByUserIsDelegateId_First(
        long userIsDelegateId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.documentdelegate.NoSuchException {
        return getPersistence()
                   .findByUserIsDelegateId_First(userIsDelegateId, obc);
    }

    public static com.sgs.portlet.documentdelegate.model.PmlDocumentDelegate findByUserIsDelegateId_Last(
        long userIsDelegateId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.documentdelegate.NoSuchException {
        return getPersistence()
                   .findByUserIsDelegateId_Last(userIsDelegateId, obc);
    }

    public static com.sgs.portlet.documentdelegate.model.PmlDocumentDelegate[] findByUserIsDelegateId_PrevAndNext(
        long documentDelegateId, long userIsDelegateId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.documentdelegate.NoSuchException {
        return getPersistence()
                   .findByUserIsDelegateId_PrevAndNext(documentDelegateId,
            userIsDelegateId, obc);
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

    public static java.util.List<com.sgs.portlet.documentdelegate.model.PmlDocumentDelegate> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.sgs.portlet.documentdelegate.model.PmlDocumentDelegate> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.sgs.portlet.documentdelegate.model.PmlDocumentDelegate> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end, obc);
    }

    public static void removeByUserIsDelegateId(long userIsDelegateId)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByUserIsDelegateId(userIsDelegateId);
    }

    public static void removeAll() throws com.liferay.portal.SystemException {
        getPersistence().removeAll();
    }

    public static int countByUserIsDelegateId(long userIsDelegateId)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByUserIsDelegateId(userIsDelegateId);
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

    public static PmlDocumentDelegatePersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(PmlDocumentDelegatePersistence persistence) {
        _persistence = persistence;
    }
}
