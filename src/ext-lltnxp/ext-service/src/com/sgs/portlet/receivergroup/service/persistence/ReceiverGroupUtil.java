package com.sgs.portlet.receivergroup.service.persistence;

public class ReceiverGroupUtil {
    private static ReceiverGroupPersistence _persistence;

    public static com.sgs.portlet.receivergroup.model.ReceiverGroup create(
        long receiverGroupId) {
        return getPersistence().create(receiverGroupId);
    }

    public static com.sgs.portlet.receivergroup.model.ReceiverGroup remove(
        long receiverGroupId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.receivergroup.NoSuchException {
        return getPersistence().remove(receiverGroupId);
    }

    public static com.sgs.portlet.receivergroup.model.ReceiverGroup remove(
        com.sgs.portlet.receivergroup.model.ReceiverGroup receiverGroup)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(receiverGroup);
    }

    /**
     * @deprecated Use <code>update(ReceiverGroup receiverGroup, boolean merge)</code>.
     */
    public static com.sgs.portlet.receivergroup.model.ReceiverGroup update(
        com.sgs.portlet.receivergroup.model.ReceiverGroup receiverGroup)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(receiverGroup);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                receiverGroup the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when receiverGroup is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public static com.sgs.portlet.receivergroup.model.ReceiverGroup update(
        com.sgs.portlet.receivergroup.model.ReceiverGroup receiverGroup,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().update(receiverGroup, merge);
    }

    public static com.sgs.portlet.receivergroup.model.ReceiverGroup updateImpl(
        com.sgs.portlet.receivergroup.model.ReceiverGroup receiverGroup,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(receiverGroup, merge);
    }

    public static com.sgs.portlet.receivergroup.model.ReceiverGroup findByPrimaryKey(
        long receiverGroupId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.receivergroup.NoSuchException {
        return getPersistence().findByPrimaryKey(receiverGroupId);
    }

    public static com.sgs.portlet.receivergroup.model.ReceiverGroup fetchByPrimaryKey(
        long receiverGroupId) throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(receiverGroupId);
    }

    public static com.sgs.portlet.receivergroup.model.ReceiverGroup findByUID_Name(
        long userId, java.lang.String receiverGroupName)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.receivergroup.NoSuchException {
        return getPersistence().findByUID_Name(userId, receiverGroupName);
    }

    public static com.sgs.portlet.receivergroup.model.ReceiverGroup fetchByUID_Name(
        long userId, java.lang.String receiverGroupName)
        throws com.liferay.portal.SystemException {
        return getPersistence().fetchByUID_Name(userId, receiverGroupName);
    }

    public static java.util.List<com.sgs.portlet.receivergroup.model.ReceiverGroup> findByUserId(
        long userId) throws com.liferay.portal.SystemException {
        return getPersistence().findByUserId(userId);
    }

    public static java.util.List<com.sgs.portlet.receivergroup.model.ReceiverGroup> findByUserId(
        long userId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByUserId(userId, start, end);
    }

    public static java.util.List<com.sgs.portlet.receivergroup.model.ReceiverGroup> findByUserId(
        long userId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByUserId(userId, start, end, obc);
    }

    public static com.sgs.portlet.receivergroup.model.ReceiverGroup findByUserId_First(
        long userId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.receivergroup.NoSuchException {
        return getPersistence().findByUserId_First(userId, obc);
    }

    public static com.sgs.portlet.receivergroup.model.ReceiverGroup findByUserId_Last(
        long userId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.receivergroup.NoSuchException {
        return getPersistence().findByUserId_Last(userId, obc);
    }

    public static com.sgs.portlet.receivergroup.model.ReceiverGroup[] findByUserId_PrevAndNext(
        long receiverGroupId, long userId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.receivergroup.NoSuchException {
        return getPersistence()
                   .findByUserId_PrevAndNext(receiverGroupId, userId, obc);
    }

    public static java.util.List<com.sgs.portlet.receivergroup.model.ReceiverGroup> findByUserId_Type(
        long userId, int type) throws com.liferay.portal.SystemException {
        return getPersistence().findByUserId_Type(userId, type);
    }

    public static java.util.List<com.sgs.portlet.receivergroup.model.ReceiverGroup> findByUserId_Type(
        long userId, int type, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByUserId_Type(userId, type, start, end);
    }

    public static java.util.List<com.sgs.portlet.receivergroup.model.ReceiverGroup> findByUserId_Type(
        long userId, int type, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByUserId_Type(userId, type, start, end, obc);
    }

    public static com.sgs.portlet.receivergroup.model.ReceiverGroup findByUserId_Type_First(
        long userId, int type,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.receivergroup.NoSuchException {
        return getPersistence().findByUserId_Type_First(userId, type, obc);
    }

    public static com.sgs.portlet.receivergroup.model.ReceiverGroup findByUserId_Type_Last(
        long userId, int type,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.receivergroup.NoSuchException {
        return getPersistence().findByUserId_Type_Last(userId, type, obc);
    }

    public static com.sgs.portlet.receivergroup.model.ReceiverGroup[] findByUserId_Type_PrevAndNext(
        long receiverGroupId, long userId, int type,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.receivergroup.NoSuchException {
        return getPersistence()
                   .findByUserId_Type_PrevAndNext(receiverGroupId, userId,
            type, obc);
    }

    public static java.util.List<com.sgs.portlet.receivergroup.model.ReceiverGroup> findByUserId_Type_Active(
        long userId, int type, boolean active)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByUserId_Type_Active(userId, type, active);
    }

    public static java.util.List<com.sgs.portlet.receivergroup.model.ReceiverGroup> findByUserId_Type_Active(
        long userId, int type, boolean active, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByUserId_Type_Active(userId, type, active, start, end);
    }

    public static java.util.List<com.sgs.portlet.receivergroup.model.ReceiverGroup> findByUserId_Type_Active(
        long userId, int type, boolean active, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByUserId_Type_Active(userId, type, active, start, end,
            obc);
    }

    public static com.sgs.portlet.receivergroup.model.ReceiverGroup findByUserId_Type_Active_First(
        long userId, int type, boolean active,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.receivergroup.NoSuchException {
        return getPersistence()
                   .findByUserId_Type_Active_First(userId, type, active, obc);
    }

    public static com.sgs.portlet.receivergroup.model.ReceiverGroup findByUserId_Type_Active_Last(
        long userId, int type, boolean active,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.receivergroup.NoSuchException {
        return getPersistence()
                   .findByUserId_Type_Active_Last(userId, type, active, obc);
    }

    public static com.sgs.portlet.receivergroup.model.ReceiverGroup[] findByUserId_Type_Active_PrevAndNext(
        long receiverGroupId, long userId, int type, boolean active,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.receivergroup.NoSuchException {
        return getPersistence()
                   .findByUserId_Type_Active_PrevAndNext(receiverGroupId,
            userId, type, active, obc);
    }

    public static java.util.List<com.sgs.portlet.receivergroup.model.ReceiverGroup> findByUserId_Active(
        long userId, boolean active) throws com.liferay.portal.SystemException {
        return getPersistence().findByUserId_Active(userId, active);
    }

    public static java.util.List<com.sgs.portlet.receivergroup.model.ReceiverGroup> findByUserId_Active(
        long userId, boolean active, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByUserId_Active(userId, active, start, end);
    }

    public static java.util.List<com.sgs.portlet.receivergroup.model.ReceiverGroup> findByUserId_Active(
        long userId, boolean active, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByUserId_Active(userId, active, start, end, obc);
    }

    public static com.sgs.portlet.receivergroup.model.ReceiverGroup findByUserId_Active_First(
        long userId, boolean active,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.receivergroup.NoSuchException {
        return getPersistence().findByUserId_Active_First(userId, active, obc);
    }

    public static com.sgs.portlet.receivergroup.model.ReceiverGroup findByUserId_Active_Last(
        long userId, boolean active,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.receivergroup.NoSuchException {
        return getPersistence().findByUserId_Active_Last(userId, active, obc);
    }

    public static com.sgs.portlet.receivergroup.model.ReceiverGroup[] findByUserId_Active_PrevAndNext(
        long receiverGroupId, long userId, boolean active,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.receivergroup.NoSuchException {
        return getPersistence()
                   .findByUserId_Active_PrevAndNext(receiverGroupId, userId,
            active, obc);
    }

    public static java.util.List<com.sgs.portlet.receivergroup.model.ReceiverGroup> findByUserName(
        java.lang.String userName) throws com.liferay.portal.SystemException {
        return getPersistence().findByUserName(userName);
    }

    public static java.util.List<com.sgs.portlet.receivergroup.model.ReceiverGroup> findByUserName(
        java.lang.String userName, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByUserName(userName, start, end);
    }

    public static java.util.List<com.sgs.portlet.receivergroup.model.ReceiverGroup> findByUserName(
        java.lang.String userName, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByUserName(userName, start, end, obc);
    }

    public static com.sgs.portlet.receivergroup.model.ReceiverGroup findByUserName_First(
        java.lang.String userName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.receivergroup.NoSuchException {
        return getPersistence().findByUserName_First(userName, obc);
    }

    public static com.sgs.portlet.receivergroup.model.ReceiverGroup findByUserName_Last(
        java.lang.String userName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.receivergroup.NoSuchException {
        return getPersistence().findByUserName_Last(userName, obc);
    }

    public static com.sgs.portlet.receivergroup.model.ReceiverGroup[] findByUserName_PrevAndNext(
        long receiverGroupId, java.lang.String userName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.receivergroup.NoSuchException {
        return getPersistence()
                   .findByUserName_PrevAndNext(receiverGroupId, userName, obc);
    }

    public static java.util.List<com.sgs.portlet.receivergroup.model.ReceiverGroup> findByUserName_Type(
        java.lang.String userName, int type)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByUserName_Type(userName, type);
    }

    public static java.util.List<com.sgs.portlet.receivergroup.model.ReceiverGroup> findByUserName_Type(
        java.lang.String userName, int type, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByUserName_Type(userName, type, start, end);
    }

    public static java.util.List<com.sgs.portlet.receivergroup.model.ReceiverGroup> findByUserName_Type(
        java.lang.String userName, int type, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByUserName_Type(userName, type, start, end, obc);
    }

    public static com.sgs.portlet.receivergroup.model.ReceiverGroup findByUserName_Type_First(
        java.lang.String userName, int type,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.receivergroup.NoSuchException {
        return getPersistence().findByUserName_Type_First(userName, type, obc);
    }

    public static com.sgs.portlet.receivergroup.model.ReceiverGroup findByUserName_Type_Last(
        java.lang.String userName, int type,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.receivergroup.NoSuchException {
        return getPersistence().findByUserName_Type_Last(userName, type, obc);
    }

    public static com.sgs.portlet.receivergroup.model.ReceiverGroup[] findByUserName_Type_PrevAndNext(
        long receiverGroupId, java.lang.String userName, int type,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.receivergroup.NoSuchException {
        return getPersistence()
                   .findByUserName_Type_PrevAndNext(receiverGroupId, userName,
            type, obc);
    }

    public static java.util.List<com.sgs.portlet.receivergroup.model.ReceiverGroup> findByUserName_Active(
        java.lang.String userName, boolean active)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByUserName_Active(userName, active);
    }

    public static java.util.List<com.sgs.portlet.receivergroup.model.ReceiverGroup> findByUserName_Active(
        java.lang.String userName, boolean active, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByUserName_Active(userName, active, start, end);
    }

    public static java.util.List<com.sgs.portlet.receivergroup.model.ReceiverGroup> findByUserName_Active(
        java.lang.String userName, boolean active, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByUserName_Active(userName, active, start, end, obc);
    }

    public static com.sgs.portlet.receivergroup.model.ReceiverGroup findByUserName_Active_First(
        java.lang.String userName, boolean active,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.receivergroup.NoSuchException {
        return getPersistence()
                   .findByUserName_Active_First(userName, active, obc);
    }

    public static com.sgs.portlet.receivergroup.model.ReceiverGroup findByUserName_Active_Last(
        java.lang.String userName, boolean active,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.receivergroup.NoSuchException {
        return getPersistence().findByUserName_Active_Last(userName, active, obc);
    }

    public static com.sgs.portlet.receivergroup.model.ReceiverGroup[] findByUserName_Active_PrevAndNext(
        long receiverGroupId, java.lang.String userName, boolean active,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.receivergroup.NoSuchException {
        return getPersistence()
                   .findByUserName_Active_PrevAndNext(receiverGroupId,
            userName, active, obc);
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

    public static java.util.List<com.sgs.portlet.receivergroup.model.ReceiverGroup> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.sgs.portlet.receivergroup.model.ReceiverGroup> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.sgs.portlet.receivergroup.model.ReceiverGroup> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end, obc);
    }

    public static void removeByUID_Name(long userId,
        java.lang.String receiverGroupName)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.receivergroup.NoSuchException {
        getPersistence().removeByUID_Name(userId, receiverGroupName);
    }

    public static void removeByUserId(long userId)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByUserId(userId);
    }

    public static void removeByUserId_Type(long userId, int type)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByUserId_Type(userId, type);
    }

    public static void removeByUserId_Type_Active(long userId, int type,
        boolean active) throws com.liferay.portal.SystemException {
        getPersistence().removeByUserId_Type_Active(userId, type, active);
    }

    public static void removeByUserId_Active(long userId, boolean active)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByUserId_Active(userId, active);
    }

    public static void removeByUserName(java.lang.String userName)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByUserName(userName);
    }

    public static void removeByUserName_Type(java.lang.String userName, int type)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByUserName_Type(userName, type);
    }

    public static void removeByUserName_Active(java.lang.String userName,
        boolean active) throws com.liferay.portal.SystemException {
        getPersistence().removeByUserName_Active(userName, active);
    }

    public static void removeAll() throws com.liferay.portal.SystemException {
        getPersistence().removeAll();
    }

    public static int countByUID_Name(long userId,
        java.lang.String receiverGroupName)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByUID_Name(userId, receiverGroupName);
    }

    public static int countByUserId(long userId)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByUserId(userId);
    }

    public static int countByUserId_Type(long userId, int type)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByUserId_Type(userId, type);
    }

    public static int countByUserId_Type_Active(long userId, int type,
        boolean active) throws com.liferay.portal.SystemException {
        return getPersistence().countByUserId_Type_Active(userId, type, active);
    }

    public static int countByUserId_Active(long userId, boolean active)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByUserId_Active(userId, active);
    }

    public static int countByUserName(java.lang.String userName)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByUserName(userName);
    }

    public static int countByUserName_Type(java.lang.String userName, int type)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByUserName_Type(userName, type);
    }

    public static int countByUserName_Active(java.lang.String userName,
        boolean active) throws com.liferay.portal.SystemException {
        return getPersistence().countByUserName_Active(userName, active);
    }

    public static int countAll() throws com.liferay.portal.SystemException {
        return getPersistence().countAll();
    }

    public static java.util.List<com.sgs.portlet.receivergroup.model.Receiver> getReceivers(
        long pk) throws com.liferay.portal.SystemException {
        return getPersistence().getReceivers(pk);
    }

    public static java.util.List<com.sgs.portlet.receivergroup.model.Receiver> getReceivers(
        long pk, int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().getReceivers(pk, start, end);
    }

    public static java.util.List<com.sgs.portlet.receivergroup.model.Receiver> getReceivers(
        long pk, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().getReceivers(pk, start, end, obc);
    }

    public static int getReceiversSize(long pk)
        throws com.liferay.portal.SystemException {
        return getPersistence().getReceiversSize(pk);
    }

    public static boolean containsReceiver(long pk, long receiverPK)
        throws com.liferay.portal.SystemException {
        return getPersistence().containsReceiver(pk, receiverPK);
    }

    public static boolean containsReceivers(long pk)
        throws com.liferay.portal.SystemException {
        return getPersistence().containsReceivers(pk);
    }

    public static void addReceiver(long pk, long receiverPK)
        throws com.liferay.portal.SystemException {
        getPersistence().addReceiver(pk, receiverPK);
    }

    public static void addReceiver(long pk,
        com.sgs.portlet.receivergroup.model.Receiver receiver)
        throws com.liferay.portal.SystemException {
        getPersistence().addReceiver(pk, receiver);
    }

    public static void addReceivers(long pk, long[] receiverPKs)
        throws com.liferay.portal.SystemException {
        getPersistence().addReceivers(pk, receiverPKs);
    }

    public static void addReceivers(long pk,
        java.util.List<com.sgs.portlet.receivergroup.model.Receiver> receivers)
        throws com.liferay.portal.SystemException {
        getPersistence().addReceivers(pk, receivers);
    }

    public static void clearReceivers(long pk)
        throws com.liferay.portal.SystemException {
        getPersistence().clearReceivers(pk);
    }

    public static void removeReceiver(long pk, long receiverPK)
        throws com.liferay.portal.SystemException {
        getPersistence().removeReceiver(pk, receiverPK);
    }

    public static void removeReceiver(long pk,
        com.sgs.portlet.receivergroup.model.Receiver receiver)
        throws com.liferay.portal.SystemException {
        getPersistence().removeReceiver(pk, receiver);
    }

    public static void removeReceivers(long pk, long[] receiverPKs)
        throws com.liferay.portal.SystemException {
        getPersistence().removeReceivers(pk, receiverPKs);
    }

    public static void removeReceivers(long pk,
        java.util.List<com.sgs.portlet.receivergroup.model.Receiver> receivers)
        throws com.liferay.portal.SystemException {
        getPersistence().removeReceivers(pk, receivers);
    }

    public static void setReceivers(long pk, long[] receiverPKs)
        throws com.liferay.portal.SystemException {
        getPersistence().setReceivers(pk, receiverPKs);
    }

    public static void setReceivers(long pk,
        java.util.List<com.sgs.portlet.receivergroup.model.Receiver> receivers)
        throws com.liferay.portal.SystemException {
        getPersistence().setReceivers(pk, receivers);
    }

    public static void registerListener(
        com.liferay.portal.model.ModelListener listener) {
        getPersistence().registerListener(listener);
    }

    public static void unregisterListener(
        com.liferay.portal.model.ModelListener listener) {
        getPersistence().unregisterListener(listener);
    }

    public static ReceiverGroupPersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(ReceiverGroupPersistence persistence) {
        _persistence = persistence;
    }
}
