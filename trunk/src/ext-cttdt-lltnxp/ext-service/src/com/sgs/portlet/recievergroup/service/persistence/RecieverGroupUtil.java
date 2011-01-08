package com.sgs.portlet.recievergroup.service.persistence;

public class RecieverGroupUtil {
    private static RecieverGroupPersistence _persistence;

    public static com.sgs.portlet.recievergroup.model.RecieverGroup create(
        long recieverGroupId) {
        return getPersistence().create(recieverGroupId);
    }

    public static com.sgs.portlet.recievergroup.model.RecieverGroup remove(
        long recieverGroupId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.recievergroup.NoSuchException {
        return getPersistence().remove(recieverGroupId);
    }

    public static com.sgs.portlet.recievergroup.model.RecieverGroup remove(
        com.sgs.portlet.recievergroup.model.RecieverGroup recieverGroup)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(recieverGroup);
    }

    /**
     * @deprecated Use <code>update(RecieverGroup recieverGroup, boolean merge)</code>.
     */
    public static com.sgs.portlet.recievergroup.model.RecieverGroup update(
        com.sgs.portlet.recievergroup.model.RecieverGroup recieverGroup)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(recieverGroup);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                recieverGroup the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when recieverGroup is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public static com.sgs.portlet.recievergroup.model.RecieverGroup update(
        com.sgs.portlet.recievergroup.model.RecieverGroup recieverGroup,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().update(recieverGroup, merge);
    }

    public static com.sgs.portlet.recievergroup.model.RecieverGroup updateImpl(
        com.sgs.portlet.recievergroup.model.RecieverGroup recieverGroup,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(recieverGroup, merge);
    }

    public static com.sgs.portlet.recievergroup.model.RecieverGroup findByPrimaryKey(
        long recieverGroupId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.recievergroup.NoSuchException {
        return getPersistence().findByPrimaryKey(recieverGroupId);
    }

    public static com.sgs.portlet.recievergroup.model.RecieverGroup fetchByPrimaryKey(
        long recieverGroupId) throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(recieverGroupId);
    }

    public static com.sgs.portlet.recievergroup.model.RecieverGroup findByUID_Name(
        long userId, java.lang.String recieverGroupName)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.recievergroup.NoSuchException {
        return getPersistence().findByUID_Name(userId, recieverGroupName);
    }

    public static com.sgs.portlet.recievergroup.model.RecieverGroup fetchByUID_Name(
        long userId, java.lang.String recieverGroupName)
        throws com.liferay.portal.SystemException {
        return getPersistence().fetchByUID_Name(userId, recieverGroupName);
    }

    public static java.util.List<com.sgs.portlet.recievergroup.model.RecieverGroup> findByUserId(
        long userId) throws com.liferay.portal.SystemException {
        return getPersistence().findByUserId(userId);
    }

    public static java.util.List<com.sgs.portlet.recievergroup.model.RecieverGroup> findByUserId(
        long userId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByUserId(userId, start, end);
    }

    public static java.util.List<com.sgs.portlet.recievergroup.model.RecieverGroup> findByUserId(
        long userId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByUserId(userId, start, end, obc);
    }

    public static com.sgs.portlet.recievergroup.model.RecieverGroup findByUserId_First(
        long userId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.recievergroup.NoSuchException {
        return getPersistence().findByUserId_First(userId, obc);
    }

    public static com.sgs.portlet.recievergroup.model.RecieverGroup findByUserId_Last(
        long userId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.recievergroup.NoSuchException {
        return getPersistence().findByUserId_Last(userId, obc);
    }

    public static com.sgs.portlet.recievergroup.model.RecieverGroup[] findByUserId_PrevAndNext(
        long recieverGroupId, long userId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.recievergroup.NoSuchException {
        return getPersistence()
                   .findByUserId_PrevAndNext(recieverGroupId, userId, obc);
    }

    public static java.util.List<com.sgs.portlet.recievergroup.model.RecieverGroup> findByUserId_Type(
        long userId, int type) throws com.liferay.portal.SystemException {
        return getPersistence().findByUserId_Type(userId, type);
    }

    public static java.util.List<com.sgs.portlet.recievergroup.model.RecieverGroup> findByUserId_Type(
        long userId, int type, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByUserId_Type(userId, type, start, end);
    }

    public static java.util.List<com.sgs.portlet.recievergroup.model.RecieverGroup> findByUserId_Type(
        long userId, int type, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByUserId_Type(userId, type, start, end, obc);
    }

    public static com.sgs.portlet.recievergroup.model.RecieverGroup findByUserId_Type_First(
        long userId, int type,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.recievergroup.NoSuchException {
        return getPersistence().findByUserId_Type_First(userId, type, obc);
    }

    public static com.sgs.portlet.recievergroup.model.RecieverGroup findByUserId_Type_Last(
        long userId, int type,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.recievergroup.NoSuchException {
        return getPersistence().findByUserId_Type_Last(userId, type, obc);
    }

    public static com.sgs.portlet.recievergroup.model.RecieverGroup[] findByUserId_Type_PrevAndNext(
        long recieverGroupId, long userId, int type,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.recievergroup.NoSuchException {
        return getPersistence()
                   .findByUserId_Type_PrevAndNext(recieverGroupId, userId,
            type, obc);
    }

    public static java.util.List<com.sgs.portlet.recievergroup.model.RecieverGroup> findByUserId_Type_Active(
        long userId, int type, boolean active)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByUserId_Type_Active(userId, type, active);
    }

    public static java.util.List<com.sgs.portlet.recievergroup.model.RecieverGroup> findByUserId_Type_Active(
        long userId, int type, boolean active, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByUserId_Type_Active(userId, type, active, start, end);
    }

    public static java.util.List<com.sgs.portlet.recievergroup.model.RecieverGroup> findByUserId_Type_Active(
        long userId, int type, boolean active, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByUserId_Type_Active(userId, type, active, start, end,
            obc);
    }

    public static com.sgs.portlet.recievergroup.model.RecieverGroup findByUserId_Type_Active_First(
        long userId, int type, boolean active,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.recievergroup.NoSuchException {
        return getPersistence()
                   .findByUserId_Type_Active_First(userId, type, active, obc);
    }

    public static com.sgs.portlet.recievergroup.model.RecieverGroup findByUserId_Type_Active_Last(
        long userId, int type, boolean active,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.recievergroup.NoSuchException {
        return getPersistence()
                   .findByUserId_Type_Active_Last(userId, type, active, obc);
    }

    public static com.sgs.portlet.recievergroup.model.RecieverGroup[] findByUserId_Type_Active_PrevAndNext(
        long recieverGroupId, long userId, int type, boolean active,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.recievergroup.NoSuchException {
        return getPersistence()
                   .findByUserId_Type_Active_PrevAndNext(recieverGroupId,
            userId, type, active, obc);
    }

    public static java.util.List<com.sgs.portlet.recievergroup.model.RecieverGroup> findByUserId_Active(
        long userId, boolean active) throws com.liferay.portal.SystemException {
        return getPersistence().findByUserId_Active(userId, active);
    }

    public static java.util.List<com.sgs.portlet.recievergroup.model.RecieverGroup> findByUserId_Active(
        long userId, boolean active, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByUserId_Active(userId, active, start, end);
    }

    public static java.util.List<com.sgs.portlet.recievergroup.model.RecieverGroup> findByUserId_Active(
        long userId, boolean active, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByUserId_Active(userId, active, start, end, obc);
    }

    public static com.sgs.portlet.recievergroup.model.RecieverGroup findByUserId_Active_First(
        long userId, boolean active,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.recievergroup.NoSuchException {
        return getPersistence().findByUserId_Active_First(userId, active, obc);
    }

    public static com.sgs.portlet.recievergroup.model.RecieverGroup findByUserId_Active_Last(
        long userId, boolean active,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.recievergroup.NoSuchException {
        return getPersistence().findByUserId_Active_Last(userId, active, obc);
    }

    public static com.sgs.portlet.recievergroup.model.RecieverGroup[] findByUserId_Active_PrevAndNext(
        long recieverGroupId, long userId, boolean active,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.recievergroup.NoSuchException {
        return getPersistence()
                   .findByUserId_Active_PrevAndNext(recieverGroupId, userId,
            active, obc);
    }

    public static java.util.List<com.sgs.portlet.recievergroup.model.RecieverGroup> findByUserName(
        java.lang.String userName) throws com.liferay.portal.SystemException {
        return getPersistence().findByUserName(userName);
    }

    public static java.util.List<com.sgs.portlet.recievergroup.model.RecieverGroup> findByUserName(
        java.lang.String userName, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByUserName(userName, start, end);
    }

    public static java.util.List<com.sgs.portlet.recievergroup.model.RecieverGroup> findByUserName(
        java.lang.String userName, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByUserName(userName, start, end, obc);
    }

    public static com.sgs.portlet.recievergroup.model.RecieverGroup findByUserName_First(
        java.lang.String userName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.recievergroup.NoSuchException {
        return getPersistence().findByUserName_First(userName, obc);
    }

    public static com.sgs.portlet.recievergroup.model.RecieverGroup findByUserName_Last(
        java.lang.String userName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.recievergroup.NoSuchException {
        return getPersistence().findByUserName_Last(userName, obc);
    }

    public static com.sgs.portlet.recievergroup.model.RecieverGroup[] findByUserName_PrevAndNext(
        long recieverGroupId, java.lang.String userName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.recievergroup.NoSuchException {
        return getPersistence()
                   .findByUserName_PrevAndNext(recieverGroupId, userName, obc);
    }

    public static java.util.List<com.sgs.portlet.recievergroup.model.RecieverGroup> findByUserName_Type(
        java.lang.String userName, int type)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByUserName_Type(userName, type);
    }

    public static java.util.List<com.sgs.portlet.recievergroup.model.RecieverGroup> findByUserName_Type(
        java.lang.String userName, int type, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByUserName_Type(userName, type, start, end);
    }

    public static java.util.List<com.sgs.portlet.recievergroup.model.RecieverGroup> findByUserName_Type(
        java.lang.String userName, int type, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByUserName_Type(userName, type, start, end, obc);
    }

    public static com.sgs.portlet.recievergroup.model.RecieverGroup findByUserName_Type_First(
        java.lang.String userName, int type,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.recievergroup.NoSuchException {
        return getPersistence().findByUserName_Type_First(userName, type, obc);
    }

    public static com.sgs.portlet.recievergroup.model.RecieverGroup findByUserName_Type_Last(
        java.lang.String userName, int type,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.recievergroup.NoSuchException {
        return getPersistence().findByUserName_Type_Last(userName, type, obc);
    }

    public static com.sgs.portlet.recievergroup.model.RecieverGroup[] findByUserName_Type_PrevAndNext(
        long recieverGroupId, java.lang.String userName, int type,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.recievergroup.NoSuchException {
        return getPersistence()
                   .findByUserName_Type_PrevAndNext(recieverGroupId, userName,
            type, obc);
    }

    public static java.util.List<com.sgs.portlet.recievergroup.model.RecieverGroup> findByUserName_Active(
        java.lang.String userName, boolean active)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByUserName_Active(userName, active);
    }

    public static java.util.List<com.sgs.portlet.recievergroup.model.RecieverGroup> findByUserName_Active(
        java.lang.String userName, boolean active, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByUserName_Active(userName, active, start, end);
    }

    public static java.util.List<com.sgs.portlet.recievergroup.model.RecieverGroup> findByUserName_Active(
        java.lang.String userName, boolean active, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByUserName_Active(userName, active, start, end, obc);
    }

    public static com.sgs.portlet.recievergroup.model.RecieverGroup findByUserName_Active_First(
        java.lang.String userName, boolean active,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.recievergroup.NoSuchException {
        return getPersistence()
                   .findByUserName_Active_First(userName, active, obc);
    }

    public static com.sgs.portlet.recievergroup.model.RecieverGroup findByUserName_Active_Last(
        java.lang.String userName, boolean active,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.recievergroup.NoSuchException {
        return getPersistence().findByUserName_Active_Last(userName, active, obc);
    }

    public static com.sgs.portlet.recievergroup.model.RecieverGroup[] findByUserName_Active_PrevAndNext(
        long recieverGroupId, java.lang.String userName, boolean active,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.recievergroup.NoSuchException {
        return getPersistence()
                   .findByUserName_Active_PrevAndNext(recieverGroupId,
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

    public static java.util.List<com.sgs.portlet.recievergroup.model.RecieverGroup> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.sgs.portlet.recievergroup.model.RecieverGroup> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.sgs.portlet.recievergroup.model.RecieverGroup> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end, obc);
    }

    public static void removeByUID_Name(long userId,
        java.lang.String recieverGroupName)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.recievergroup.NoSuchException {
        getPersistence().removeByUID_Name(userId, recieverGroupName);
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
        java.lang.String recieverGroupName)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByUID_Name(userId, recieverGroupName);
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

    public static java.util.List<com.sgs.portlet.recievergroup.model.Reciever> getRecievers(
        long pk) throws com.liferay.portal.SystemException {
        return getPersistence().getRecievers(pk);
    }

    public static java.util.List<com.sgs.portlet.recievergroup.model.Reciever> getRecievers(
        long pk, int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().getRecievers(pk, start, end);
    }

    public static java.util.List<com.sgs.portlet.recievergroup.model.Reciever> getRecievers(
        long pk, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().getRecievers(pk, start, end, obc);
    }

    public static int getRecieversSize(long pk)
        throws com.liferay.portal.SystemException {
        return getPersistence().getRecieversSize(pk);
    }

    public static boolean containsReciever(long pk, long recieverPK)
        throws com.liferay.portal.SystemException {
        return getPersistence().containsReciever(pk, recieverPK);
    }

    public static boolean containsRecievers(long pk)
        throws com.liferay.portal.SystemException {
        return getPersistence().containsRecievers(pk);
    }

    public static void addReciever(long pk, long recieverPK)
        throws com.liferay.portal.SystemException {
        getPersistence().addReciever(pk, recieverPK);
    }

    public static void addReciever(long pk,
        com.sgs.portlet.recievergroup.model.Reciever reciever)
        throws com.liferay.portal.SystemException {
        getPersistence().addReciever(pk, reciever);
    }

    public static void addRecievers(long pk, long[] recieverPKs)
        throws com.liferay.portal.SystemException {
        getPersistence().addRecievers(pk, recieverPKs);
    }

    public static void addRecievers(long pk,
        java.util.List<com.sgs.portlet.recievergroup.model.Reciever> recievers)
        throws com.liferay.portal.SystemException {
        getPersistence().addRecievers(pk, recievers);
    }

    public static void clearRecievers(long pk)
        throws com.liferay.portal.SystemException {
        getPersistence().clearRecievers(pk);
    }

    public static void removeReciever(long pk, long recieverPK)
        throws com.liferay.portal.SystemException {
        getPersistence().removeReciever(pk, recieverPK);
    }

    public static void removeReciever(long pk,
        com.sgs.portlet.recievergroup.model.Reciever reciever)
        throws com.liferay.portal.SystemException {
        getPersistence().removeReciever(pk, reciever);
    }

    public static void removeRecievers(long pk, long[] recieverPKs)
        throws com.liferay.portal.SystemException {
        getPersistence().removeRecievers(pk, recieverPKs);
    }

    public static void removeRecievers(long pk,
        java.util.List<com.sgs.portlet.recievergroup.model.Reciever> recievers)
        throws com.liferay.portal.SystemException {
        getPersistence().removeRecievers(pk, recievers);
    }

    public static void setRecievers(long pk, long[] recieverPKs)
        throws com.liferay.portal.SystemException {
        getPersistence().setRecievers(pk, recieverPKs);
    }

    public static void setRecievers(long pk,
        java.util.List<com.sgs.portlet.recievergroup.model.Reciever> recievers)
        throws com.liferay.portal.SystemException {
        getPersistence().setRecievers(pk, recievers);
    }

    public static void registerListener(
        com.liferay.portal.model.ModelListener listener) {
        getPersistence().registerListener(listener);
    }

    public static void unregisterListener(
        com.liferay.portal.model.ModelListener listener) {
        getPersistence().unregisterListener(listener);
    }

    public static RecieverGroupPersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(RecieverGroupPersistence persistence) {
        _persistence = persistence;
    }
}
