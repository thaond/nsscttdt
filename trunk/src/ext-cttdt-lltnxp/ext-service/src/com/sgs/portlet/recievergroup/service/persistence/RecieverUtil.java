package com.sgs.portlet.recievergroup.service.persistence;

public class RecieverUtil {
    private static RecieverPersistence _persistence;

    public static com.sgs.portlet.recievergroup.model.Reciever create(
        long recieverId) {
        return getPersistence().create(recieverId);
    }

    public static com.sgs.portlet.recievergroup.model.Reciever remove(
        long recieverId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.recievergroup.NoSuchRecieverException {
        return getPersistence().remove(recieverId);
    }

    public static com.sgs.portlet.recievergroup.model.Reciever remove(
        com.sgs.portlet.recievergroup.model.Reciever reciever)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(reciever);
    }

    /**
     * @deprecated Use <code>update(Reciever reciever, boolean merge)</code>.
     */
    public static com.sgs.portlet.recievergroup.model.Reciever update(
        com.sgs.portlet.recievergroup.model.Reciever reciever)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(reciever);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                reciever the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when reciever is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public static com.sgs.portlet.recievergroup.model.Reciever update(
        com.sgs.portlet.recievergroup.model.Reciever reciever, boolean merge)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(reciever, merge);
    }

    public static com.sgs.portlet.recievergroup.model.Reciever updateImpl(
        com.sgs.portlet.recievergroup.model.Reciever reciever, boolean merge)
        throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(reciever, merge);
    }

    public static com.sgs.portlet.recievergroup.model.Reciever findByPrimaryKey(
        long recieverId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.recievergroup.NoSuchRecieverException {
        return getPersistence().findByPrimaryKey(recieverId);
    }

    public static com.sgs.portlet.recievergroup.model.Reciever fetchByPrimaryKey(
        long recieverId) throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(recieverId);
    }

    public static java.util.List<com.sgs.portlet.recievergroup.model.Reciever> findByUID_Type(
        long userId, int recieverType)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByUID_Type(userId, recieverType);
    }

    public static java.util.List<com.sgs.portlet.recievergroup.model.Reciever> findByUID_Type(
        long userId, int recieverType, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByUID_Type(userId, recieverType, start, end);
    }

    public static java.util.List<com.sgs.portlet.recievergroup.model.Reciever> findByUID_Type(
        long userId, int recieverType, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByUID_Type(userId, recieverType, start, end, obc);
    }

    public static com.sgs.portlet.recievergroup.model.Reciever findByUID_Type_First(
        long userId, int recieverType,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.recievergroup.NoSuchRecieverException {
        return getPersistence().findByUID_Type_First(userId, recieverType, obc);
    }

    public static com.sgs.portlet.recievergroup.model.Reciever findByUID_Type_Last(
        long userId, int recieverType,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.recievergroup.NoSuchRecieverException {
        return getPersistence().findByUID_Type_Last(userId, recieverType, obc);
    }

    public static com.sgs.portlet.recievergroup.model.Reciever[] findByUID_Type_PrevAndNext(
        long recieverId, long userId, int recieverType,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.recievergroup.NoSuchRecieverException {
        return getPersistence()
                   .findByUID_Type_PrevAndNext(recieverId, userId,
            recieverType, obc);
    }

    public static com.sgs.portlet.recievergroup.model.Reciever findByUID_RUID_Type(
        long userId, long recieverUserId, int recieverType)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.recievergroup.NoSuchRecieverException {
        return getPersistence()
                   .findByUID_RUID_Type(userId, recieverUserId, recieverType);
    }

    public static com.sgs.portlet.recievergroup.model.Reciever fetchByUID_RUID_Type(
        long userId, long recieverUserId, int recieverType)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .fetchByUID_RUID_Type(userId, recieverUserId, recieverType);
    }

    public static com.sgs.portlet.recievergroup.model.Reciever findByUID_RCN_Type(
        long userId, java.lang.String recieverUserName, int recieverType)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.recievergroup.NoSuchRecieverException {
        return getPersistence()
                   .findByUID_RCN_Type(userId, recieverUserName, recieverType);
    }

    public static com.sgs.portlet.recievergroup.model.Reciever fetchByUID_RCN_Type(
        long userId, java.lang.String recieverUserName, int recieverType)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .fetchByUID_RCN_Type(userId, recieverUserName, recieverType);
    }

    public static java.util.List<com.sgs.portlet.recievergroup.model.Reciever> findByUCN_Type(
        java.lang.String userName, int recieverType)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByUCN_Type(userName, recieverType);
    }

    public static java.util.List<com.sgs.portlet.recievergroup.model.Reciever> findByUCN_Type(
        java.lang.String userName, int recieverType, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByUCN_Type(userName, recieverType, start, end);
    }

    public static java.util.List<com.sgs.portlet.recievergroup.model.Reciever> findByUCN_Type(
        java.lang.String userName, int recieverType, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByUCN_Type(userName, recieverType, start, end, obc);
    }

    public static com.sgs.portlet.recievergroup.model.Reciever findByUCN_Type_First(
        java.lang.String userName, int recieverType,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.recievergroup.NoSuchRecieverException {
        return getPersistence().findByUCN_Type_First(userName, recieverType, obc);
    }

    public static com.sgs.portlet.recievergroup.model.Reciever findByUCN_Type_Last(
        java.lang.String userName, int recieverType,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.recievergroup.NoSuchRecieverException {
        return getPersistence().findByUCN_Type_Last(userName, recieverType, obc);
    }

    public static com.sgs.portlet.recievergroup.model.Reciever[] findByUCN_Type_PrevAndNext(
        long recieverId, java.lang.String userName, int recieverType,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.recievergroup.NoSuchRecieverException {
        return getPersistence()
                   .findByUCN_Type_PrevAndNext(recieverId, userName,
            recieverType, obc);
    }

    public static com.sgs.portlet.recievergroup.model.Reciever findByUCN_RUID_Type(
        java.lang.String userName, long recieverUserId, int recieverType)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.recievergroup.NoSuchRecieverException {
        return getPersistence()
                   .findByUCN_RUID_Type(userName, recieverUserId, recieverType);
    }

    public static com.sgs.portlet.recievergroup.model.Reciever fetchByUCN_RUID_Type(
        java.lang.String userName, long recieverUserId, int recieverType)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .fetchByUCN_RUID_Type(userName, recieverUserId, recieverType);
    }

    public static com.sgs.portlet.recievergroup.model.Reciever findByUCN_RCN_Type(
        java.lang.String userName, java.lang.String recieverUserName,
        int recieverType)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.recievergroup.NoSuchRecieverException {
        return getPersistence()
                   .findByUCN_RCN_Type(userName, recieverUserName, recieverType);
    }

    public static com.sgs.portlet.recievergroup.model.Reciever fetchByUCN_RCN_Type(
        java.lang.String userName, java.lang.String recieverUserName,
        int recieverType) throws com.liferay.portal.SystemException {
        return getPersistence()
                   .fetchByUCN_RCN_Type(userName, recieverUserName, recieverType);
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

    public static java.util.List<com.sgs.portlet.recievergroup.model.Reciever> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.sgs.portlet.recievergroup.model.Reciever> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.sgs.portlet.recievergroup.model.Reciever> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end, obc);
    }

    public static void removeByUID_Type(long userId, int recieverType)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByUID_Type(userId, recieverType);
    }

    public static void removeByUID_RUID_Type(long userId, long recieverUserId,
        int recieverType)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.recievergroup.NoSuchRecieverException {
        getPersistence()
            .removeByUID_RUID_Type(userId, recieverUserId, recieverType);
    }

    public static void removeByUID_RCN_Type(long userId,
        java.lang.String recieverUserName, int recieverType)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.recievergroup.NoSuchRecieverException {
        getPersistence()
            .removeByUID_RCN_Type(userId, recieverUserName, recieverType);
    }

    public static void removeByUCN_Type(java.lang.String userName,
        int recieverType) throws com.liferay.portal.SystemException {
        getPersistence().removeByUCN_Type(userName, recieverType);
    }

    public static void removeByUCN_RUID_Type(java.lang.String userName,
        long recieverUserId, int recieverType)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.recievergroup.NoSuchRecieverException {
        getPersistence()
            .removeByUCN_RUID_Type(userName, recieverUserId, recieverType);
    }

    public static void removeByUCN_RCN_Type(java.lang.String userName,
        java.lang.String recieverUserName, int recieverType)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.recievergroup.NoSuchRecieverException {
        getPersistence()
            .removeByUCN_RCN_Type(userName, recieverUserName, recieverType);
    }

    public static void removeAll() throws com.liferay.portal.SystemException {
        getPersistence().removeAll();
    }

    public static int countByUID_Type(long userId, int recieverType)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByUID_Type(userId, recieverType);
    }

    public static int countByUID_RUID_Type(long userId, long recieverUserId,
        int recieverType) throws com.liferay.portal.SystemException {
        return getPersistence()
                   .countByUID_RUID_Type(userId, recieverUserId, recieverType);
    }

    public static int countByUID_RCN_Type(long userId,
        java.lang.String recieverUserName, int recieverType)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .countByUID_RCN_Type(userId, recieverUserName, recieverType);
    }

    public static int countByUCN_Type(java.lang.String userName,
        int recieverType) throws com.liferay.portal.SystemException {
        return getPersistence().countByUCN_Type(userName, recieverType);
    }

    public static int countByUCN_RUID_Type(java.lang.String userName,
        long recieverUserId, int recieverType)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .countByUCN_RUID_Type(userName, recieverUserId, recieverType);
    }

    public static int countByUCN_RCN_Type(java.lang.String userName,
        java.lang.String recieverUserName, int recieverType)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .countByUCN_RCN_Type(userName, recieverUserName, recieverType);
    }

    public static int countAll() throws com.liferay.portal.SystemException {
        return getPersistence().countAll();
    }

    public static java.util.List<com.sgs.portlet.recievergroup.model.RecieverGroup> getRecieverGroups(
        long pk) throws com.liferay.portal.SystemException {
        return getPersistence().getRecieverGroups(pk);
    }

    public static java.util.List<com.sgs.portlet.recievergroup.model.RecieverGroup> getRecieverGroups(
        long pk, int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().getRecieverGroups(pk, start, end);
    }

    public static java.util.List<com.sgs.portlet.recievergroup.model.RecieverGroup> getRecieverGroups(
        long pk, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().getRecieverGroups(pk, start, end, obc);
    }

    public static int getRecieverGroupsSize(long pk)
        throws com.liferay.portal.SystemException {
        return getPersistence().getRecieverGroupsSize(pk);
    }

    public static boolean containsRecieverGroup(long pk, long recieverGroupPK)
        throws com.liferay.portal.SystemException {
        return getPersistence().containsRecieverGroup(pk, recieverGroupPK);
    }

    public static boolean containsRecieverGroups(long pk)
        throws com.liferay.portal.SystemException {
        return getPersistence().containsRecieverGroups(pk);
    }

    public static void addRecieverGroup(long pk, long recieverGroupPK)
        throws com.liferay.portal.SystemException {
        getPersistence().addRecieverGroup(pk, recieverGroupPK);
    }

    public static void addRecieverGroup(long pk,
        com.sgs.portlet.recievergroup.model.RecieverGroup recieverGroup)
        throws com.liferay.portal.SystemException {
        getPersistence().addRecieverGroup(pk, recieverGroup);
    }

    public static void addRecieverGroups(long pk, long[] recieverGroupPKs)
        throws com.liferay.portal.SystemException {
        getPersistence().addRecieverGroups(pk, recieverGroupPKs);
    }

    public static void addRecieverGroups(long pk,
        java.util.List<com.sgs.portlet.recievergroup.model.RecieverGroup> recieverGroups)
        throws com.liferay.portal.SystemException {
        getPersistence().addRecieverGroups(pk, recieverGroups);
    }

    public static void clearRecieverGroups(long pk)
        throws com.liferay.portal.SystemException {
        getPersistence().clearRecieverGroups(pk);
    }

    public static void removeRecieverGroup(long pk, long recieverGroupPK)
        throws com.liferay.portal.SystemException {
        getPersistence().removeRecieverGroup(pk, recieverGroupPK);
    }

    public static void removeRecieverGroup(long pk,
        com.sgs.portlet.recievergroup.model.RecieverGroup recieverGroup)
        throws com.liferay.portal.SystemException {
        getPersistence().removeRecieverGroup(pk, recieverGroup);
    }

    public static void removeRecieverGroups(long pk, long[] recieverGroupPKs)
        throws com.liferay.portal.SystemException {
        getPersistence().removeRecieverGroups(pk, recieverGroupPKs);
    }

    public static void removeRecieverGroups(long pk,
        java.util.List<com.sgs.portlet.recievergroup.model.RecieverGroup> recieverGroups)
        throws com.liferay.portal.SystemException {
        getPersistence().removeRecieverGroups(pk, recieverGroups);
    }

    public static void setRecieverGroups(long pk, long[] recieverGroupPKs)
        throws com.liferay.portal.SystemException {
        getPersistence().setRecieverGroups(pk, recieverGroupPKs);
    }

    public static void setRecieverGroups(long pk,
        java.util.List<com.sgs.portlet.recievergroup.model.RecieverGroup> recieverGroups)
        throws com.liferay.portal.SystemException {
        getPersistence().setRecieverGroups(pk, recieverGroups);
    }

    public static void registerListener(
        com.liferay.portal.model.ModelListener listener) {
        getPersistence().registerListener(listener);
    }

    public static void unregisterListener(
        com.liferay.portal.model.ModelListener listener) {
        getPersistence().unregisterListener(listener);
    }

    public static RecieverPersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(RecieverPersistence persistence) {
        _persistence = persistence;
    }
}
