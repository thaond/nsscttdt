package com.sgs.portlet.receivergroup.service.persistence;

public class ReceiverUtil {
    private static ReceiverPersistence _persistence;

    public static com.sgs.portlet.receivergroup.model.Receiver create(
        long receiverId) {
        return getPersistence().create(receiverId);
    }

    public static com.sgs.portlet.receivergroup.model.Receiver remove(
        long receiverId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.receivergroup.NoSuchReceiverException {
        return getPersistence().remove(receiverId);
    }

    public static com.sgs.portlet.receivergroup.model.Receiver remove(
        com.sgs.portlet.receivergroup.model.Receiver receiver)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(receiver);
    }

    /**
     * @deprecated Use <code>update(Receiver receiver, boolean merge)</code>.
     */
    public static com.sgs.portlet.receivergroup.model.Receiver update(
        com.sgs.portlet.receivergroup.model.Receiver receiver)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(receiver);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                receiver the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when receiver is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public static com.sgs.portlet.receivergroup.model.Receiver update(
        com.sgs.portlet.receivergroup.model.Receiver receiver, boolean merge)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(receiver, merge);
    }

    public static com.sgs.portlet.receivergroup.model.Receiver updateImpl(
        com.sgs.portlet.receivergroup.model.Receiver receiver, boolean merge)
        throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(receiver, merge);
    }

    public static com.sgs.portlet.receivergroup.model.Receiver findByPrimaryKey(
        long receiverId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.receivergroup.NoSuchReceiverException {
        return getPersistence().findByPrimaryKey(receiverId);
    }

    public static com.sgs.portlet.receivergroup.model.Receiver fetchByPrimaryKey(
        long receiverId) throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(receiverId);
    }

    public static java.util.List<com.sgs.portlet.receivergroup.model.Receiver> findByUID_Type(
        long userId, int receiverType)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByUID_Type(userId, receiverType);
    }

    public static java.util.List<com.sgs.portlet.receivergroup.model.Receiver> findByUID_Type(
        long userId, int receiverType, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByUID_Type(userId, receiverType, start, end);
    }

    public static java.util.List<com.sgs.portlet.receivergroup.model.Receiver> findByUID_Type(
        long userId, int receiverType, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByUID_Type(userId, receiverType, start, end, obc);
    }

    public static com.sgs.portlet.receivergroup.model.Receiver findByUID_Type_First(
        long userId, int receiverType,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.receivergroup.NoSuchReceiverException {
        return getPersistence().findByUID_Type_First(userId, receiverType, obc);
    }

    public static com.sgs.portlet.receivergroup.model.Receiver findByUID_Type_Last(
        long userId, int receiverType,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.receivergroup.NoSuchReceiverException {
        return getPersistence().findByUID_Type_Last(userId, receiverType, obc);
    }

    public static com.sgs.portlet.receivergroup.model.Receiver[] findByUID_Type_PrevAndNext(
        long receiverId, long userId, int receiverType,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.receivergroup.NoSuchReceiverException {
        return getPersistence()
                   .findByUID_Type_PrevAndNext(receiverId, userId,
            receiverType, obc);
    }

    public static com.sgs.portlet.receivergroup.model.Receiver findByUID_RUID_Type(
        long userId, long receiverUserId, int receiverType)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.receivergroup.NoSuchReceiverException {
        return getPersistence()
                   .findByUID_RUID_Type(userId, receiverUserId, receiverType);
    }

    public static com.sgs.portlet.receivergroup.model.Receiver fetchByUID_RUID_Type(
        long userId, long receiverUserId, int receiverType)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .fetchByUID_RUID_Type(userId, receiverUserId, receiverType);
    }

    public static com.sgs.portlet.receivergroup.model.Receiver findByUID_RCN_Type(
        long userId, java.lang.String receiverUserName, int receiverType)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.receivergroup.NoSuchReceiverException {
        return getPersistence()
                   .findByUID_RCN_Type(userId, receiverUserName, receiverType);
    }

    public static com.sgs.portlet.receivergroup.model.Receiver fetchByUID_RCN_Type(
        long userId, java.lang.String receiverUserName, int receiverType)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .fetchByUID_RCN_Type(userId, receiverUserName, receiverType);
    }

    public static java.util.List<com.sgs.portlet.receivergroup.model.Receiver> findByUCN_Type(
        java.lang.String userName, int receiverType)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByUCN_Type(userName, receiverType);
    }

    public static java.util.List<com.sgs.portlet.receivergroup.model.Receiver> findByUCN_Type(
        java.lang.String userName, int receiverType, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByUCN_Type(userName, receiverType, start, end);
    }

    public static java.util.List<com.sgs.portlet.receivergroup.model.Receiver> findByUCN_Type(
        java.lang.String userName, int receiverType, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByUCN_Type(userName, receiverType, start, end, obc);
    }

    public static com.sgs.portlet.receivergroup.model.Receiver findByUCN_Type_First(
        java.lang.String userName, int receiverType,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.receivergroup.NoSuchReceiverException {
        return getPersistence().findByUCN_Type_First(userName, receiverType, obc);
    }

    public static com.sgs.portlet.receivergroup.model.Receiver findByUCN_Type_Last(
        java.lang.String userName, int receiverType,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.receivergroup.NoSuchReceiverException {
        return getPersistence().findByUCN_Type_Last(userName, receiverType, obc);
    }

    public static com.sgs.portlet.receivergroup.model.Receiver[] findByUCN_Type_PrevAndNext(
        long receiverId, java.lang.String userName, int receiverType,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.receivergroup.NoSuchReceiverException {
        return getPersistence()
                   .findByUCN_Type_PrevAndNext(receiverId, userName,
            receiverType, obc);
    }

    public static com.sgs.portlet.receivergroup.model.Receiver findByUCN_RUID_Type(
        java.lang.String userName, long receiverUserId, int receiverType)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.receivergroup.NoSuchReceiverException {
        return getPersistence()
                   .findByUCN_RUID_Type(userName, receiverUserId, receiverType);
    }

    public static com.sgs.portlet.receivergroup.model.Receiver fetchByUCN_RUID_Type(
        java.lang.String userName, long receiverUserId, int receiverType)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .fetchByUCN_RUID_Type(userName, receiverUserId, receiverType);
    }

    public static com.sgs.portlet.receivergroup.model.Receiver findByUCN_RCN_Type(
        java.lang.String userName, java.lang.String receiverUserName,
        int receiverType)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.receivergroup.NoSuchReceiverException {
        return getPersistence()
                   .findByUCN_RCN_Type(userName, receiverUserName, receiverType);
    }

    public static com.sgs.portlet.receivergroup.model.Receiver fetchByUCN_RCN_Type(
        java.lang.String userName, java.lang.String receiverUserName,
        int receiverType) throws com.liferay.portal.SystemException {
        return getPersistence()
                   .fetchByUCN_RCN_Type(userName, receiverUserName, receiverType);
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

    public static java.util.List<com.sgs.portlet.receivergroup.model.Receiver> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.sgs.portlet.receivergroup.model.Receiver> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.sgs.portlet.receivergroup.model.Receiver> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end, obc);
    }

    public static void removeByUID_Type(long userId, int receiverType)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByUID_Type(userId, receiverType);
    }

    public static void removeByUID_RUID_Type(long userId, long receiverUserId,
        int receiverType)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.receivergroup.NoSuchReceiverException {
        getPersistence()
            .removeByUID_RUID_Type(userId, receiverUserId, receiverType);
    }

    public static void removeByUID_RCN_Type(long userId,
        java.lang.String receiverUserName, int receiverType)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.receivergroup.NoSuchReceiverException {
        getPersistence()
            .removeByUID_RCN_Type(userId, receiverUserName, receiverType);
    }

    public static void removeByUCN_Type(java.lang.String userName,
        int receiverType) throws com.liferay.portal.SystemException {
        getPersistence().removeByUCN_Type(userName, receiverType);
    }

    public static void removeByUCN_RUID_Type(java.lang.String userName,
        long receiverUserId, int receiverType)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.receivergroup.NoSuchReceiverException {
        getPersistence()
            .removeByUCN_RUID_Type(userName, receiverUserId, receiverType);
    }

    public static void removeByUCN_RCN_Type(java.lang.String userName,
        java.lang.String receiverUserName, int receiverType)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.receivergroup.NoSuchReceiverException {
        getPersistence()
            .removeByUCN_RCN_Type(userName, receiverUserName, receiverType);
    }

    public static void removeAll() throws com.liferay.portal.SystemException {
        getPersistence().removeAll();
    }

    public static int countByUID_Type(long userId, int receiverType)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByUID_Type(userId, receiverType);
    }

    public static int countByUID_RUID_Type(long userId, long receiverUserId,
        int receiverType) throws com.liferay.portal.SystemException {
        return getPersistence()
                   .countByUID_RUID_Type(userId, receiverUserId, receiverType);
    }

    public static int countByUID_RCN_Type(long userId,
        java.lang.String receiverUserName, int receiverType)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .countByUID_RCN_Type(userId, receiverUserName, receiverType);
    }

    public static int countByUCN_Type(java.lang.String userName,
        int receiverType) throws com.liferay.portal.SystemException {
        return getPersistence().countByUCN_Type(userName, receiverType);
    }

    public static int countByUCN_RUID_Type(java.lang.String userName,
        long receiverUserId, int receiverType)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .countByUCN_RUID_Type(userName, receiverUserId, receiverType);
    }

    public static int countByUCN_RCN_Type(java.lang.String userName,
        java.lang.String receiverUserName, int receiverType)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .countByUCN_RCN_Type(userName, receiverUserName, receiverType);
    }

    public static int countAll() throws com.liferay.portal.SystemException {
        return getPersistence().countAll();
    }

    public static java.util.List<com.sgs.portlet.receivergroup.model.ReceiverGroup> getReceiverGroups(
        long pk) throws com.liferay.portal.SystemException {
        return getPersistence().getReceiverGroups(pk);
    }

    public static java.util.List<com.sgs.portlet.receivergroup.model.ReceiverGroup> getReceiverGroups(
        long pk, int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().getReceiverGroups(pk, start, end);
    }

    public static java.util.List<com.sgs.portlet.receivergroup.model.ReceiverGroup> getReceiverGroups(
        long pk, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().getReceiverGroups(pk, start, end, obc);
    }

    public static int getReceiverGroupsSize(long pk)
        throws com.liferay.portal.SystemException {
        return getPersistence().getReceiverGroupsSize(pk);
    }

    public static boolean containsReceiverGroup(long pk, long receiverGroupPK)
        throws com.liferay.portal.SystemException {
        return getPersistence().containsReceiverGroup(pk, receiverGroupPK);
    }

    public static boolean containsReceiverGroups(long pk)
        throws com.liferay.portal.SystemException {
        return getPersistence().containsReceiverGroups(pk);
    }

    public static void addReceiverGroup(long pk, long receiverGroupPK)
        throws com.liferay.portal.SystemException {
        getPersistence().addReceiverGroup(pk, receiverGroupPK);
    }

    public static void addReceiverGroup(long pk,
        com.sgs.portlet.receivergroup.model.ReceiverGroup receiverGroup)
        throws com.liferay.portal.SystemException {
        getPersistence().addReceiverGroup(pk, receiverGroup);
    }

    public static void addReceiverGroups(long pk, long[] receiverGroupPKs)
        throws com.liferay.portal.SystemException {
        getPersistence().addReceiverGroups(pk, receiverGroupPKs);
    }

    public static void addReceiverGroups(long pk,
        java.util.List<com.sgs.portlet.receivergroup.model.ReceiverGroup> receiverGroups)
        throws com.liferay.portal.SystemException {
        getPersistence().addReceiverGroups(pk, receiverGroups);
    }

    public static void clearReceiverGroups(long pk)
        throws com.liferay.portal.SystemException {
        getPersistence().clearReceiverGroups(pk);
    }

    public static void removeReceiverGroup(long pk, long receiverGroupPK)
        throws com.liferay.portal.SystemException {
        getPersistence().removeReceiverGroup(pk, receiverGroupPK);
    }

    public static void removeReceiverGroup(long pk,
        com.sgs.portlet.receivergroup.model.ReceiverGroup receiverGroup)
        throws com.liferay.portal.SystemException {
        getPersistence().removeReceiverGroup(pk, receiverGroup);
    }

    public static void removeReceiverGroups(long pk, long[] receiverGroupPKs)
        throws com.liferay.portal.SystemException {
        getPersistence().removeReceiverGroups(pk, receiverGroupPKs);
    }

    public static void removeReceiverGroups(long pk,
        java.util.List<com.sgs.portlet.receivergroup.model.ReceiverGroup> receiverGroups)
        throws com.liferay.portal.SystemException {
        getPersistence().removeReceiverGroups(pk, receiverGroups);
    }

    public static void setReceiverGroups(long pk, long[] receiverGroupPKs)
        throws com.liferay.portal.SystemException {
        getPersistence().setReceiverGroups(pk, receiverGroupPKs);
    }

    public static void setReceiverGroups(long pk,
        java.util.List<com.sgs.portlet.receivergroup.model.ReceiverGroup> receiverGroups)
        throws com.liferay.portal.SystemException {
        getPersistence().setReceiverGroups(pk, receiverGroups);
    }

    public static void registerListener(
        com.liferay.portal.model.ModelListener listener) {
        getPersistence().registerListener(listener);
    }

    public static void unregisterListener(
        com.liferay.portal.model.ModelListener listener) {
        getPersistence().unregisterListener(listener);
    }

    public static ReceiverPersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(ReceiverPersistence persistence) {
        _persistence = persistence;
    }
}
