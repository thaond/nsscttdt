package com.sgs.portlet.receivergroup.service.persistence;

public interface ReceiverPersistence {
    public com.sgs.portlet.receivergroup.model.Receiver create(long receiverId);

    public com.sgs.portlet.receivergroup.model.Receiver remove(long receiverId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.receivergroup.NoSuchReceiverException;

    public com.sgs.portlet.receivergroup.model.Receiver remove(
        com.sgs.portlet.receivergroup.model.Receiver receiver)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(Receiver receiver, boolean merge)</code>.
     */
    public com.sgs.portlet.receivergroup.model.Receiver update(
        com.sgs.portlet.receivergroup.model.Receiver receiver)
        throws com.liferay.portal.SystemException;

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
    public com.sgs.portlet.receivergroup.model.Receiver update(
        com.sgs.portlet.receivergroup.model.Receiver receiver, boolean merge)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.receivergroup.model.Receiver updateImpl(
        com.sgs.portlet.receivergroup.model.Receiver receiver, boolean merge)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.receivergroup.model.Receiver findByPrimaryKey(
        long receiverId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.receivergroup.NoSuchReceiverException;

    public com.sgs.portlet.receivergroup.model.Receiver fetchByPrimaryKey(
        long receiverId) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.receivergroup.model.Receiver> findByUID_Type(
        long userId, int receiverType)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.receivergroup.model.Receiver> findByUID_Type(
        long userId, int receiverType, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.receivergroup.model.Receiver> findByUID_Type(
        long userId, int receiverType, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.receivergroup.model.Receiver findByUID_Type_First(
        long userId, int receiverType,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.receivergroup.NoSuchReceiverException;

    public com.sgs.portlet.receivergroup.model.Receiver findByUID_Type_Last(
        long userId, int receiverType,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.receivergroup.NoSuchReceiverException;

    public com.sgs.portlet.receivergroup.model.Receiver[] findByUID_Type_PrevAndNext(
        long receiverId, long userId, int receiverType,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.receivergroup.NoSuchReceiverException;

    public com.sgs.portlet.receivergroup.model.Receiver findByUID_RUID_Type(
        long userId, long receiverUserId, int receiverType)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.receivergroup.NoSuchReceiverException;

    public com.sgs.portlet.receivergroup.model.Receiver fetchByUID_RUID_Type(
        long userId, long receiverUserId, int receiverType)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.receivergroup.model.Receiver findByUID_RCN_Type(
        long userId, java.lang.String receiverUserName, int receiverType)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.receivergroup.NoSuchReceiverException;

    public com.sgs.portlet.receivergroup.model.Receiver fetchByUID_RCN_Type(
        long userId, java.lang.String receiverUserName, int receiverType)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.receivergroup.model.Receiver> findByUCN_Type(
        java.lang.String userName, int receiverType)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.receivergroup.model.Receiver> findByUCN_Type(
        java.lang.String userName, int receiverType, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.receivergroup.model.Receiver> findByUCN_Type(
        java.lang.String userName, int receiverType, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.receivergroup.model.Receiver findByUCN_Type_First(
        java.lang.String userName, int receiverType,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.receivergroup.NoSuchReceiverException;

    public com.sgs.portlet.receivergroup.model.Receiver findByUCN_Type_Last(
        java.lang.String userName, int receiverType,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.receivergroup.NoSuchReceiverException;

    public com.sgs.portlet.receivergroup.model.Receiver[] findByUCN_Type_PrevAndNext(
        long receiverId, java.lang.String userName, int receiverType,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.receivergroup.NoSuchReceiverException;

    public com.sgs.portlet.receivergroup.model.Receiver findByUCN_RUID_Type(
        java.lang.String userName, long receiverUserId, int receiverType)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.receivergroup.NoSuchReceiverException;

    public com.sgs.portlet.receivergroup.model.Receiver fetchByUCN_RUID_Type(
        java.lang.String userName, long receiverUserId, int receiverType)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.receivergroup.model.Receiver findByUCN_RCN_Type(
        java.lang.String userName, java.lang.String receiverUserName,
        int receiverType)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.receivergroup.NoSuchReceiverException;

    public com.sgs.portlet.receivergroup.model.Receiver fetchByUCN_RCN_Type(
        java.lang.String userName, java.lang.String receiverUserName,
        int receiverType) throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.receivergroup.model.Receiver> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.receivergroup.model.Receiver> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.receivergroup.model.Receiver> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeByUID_Type(long userId, int receiverType)
        throws com.liferay.portal.SystemException;

    public void removeByUID_RUID_Type(long userId, long receiverUserId,
        int receiverType)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.receivergroup.NoSuchReceiverException;

    public void removeByUID_RCN_Type(long userId,
        java.lang.String receiverUserName, int receiverType)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.receivergroup.NoSuchReceiverException;

    public void removeByUCN_Type(java.lang.String userName, int receiverType)
        throws com.liferay.portal.SystemException;

    public void removeByUCN_RUID_Type(java.lang.String userName,
        long receiverUserId, int receiverType)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.receivergroup.NoSuchReceiverException;

    public void removeByUCN_RCN_Type(java.lang.String userName,
        java.lang.String receiverUserName, int receiverType)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.receivergroup.NoSuchReceiverException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countByUID_Type(long userId, int receiverType)
        throws com.liferay.portal.SystemException;

    public int countByUID_RUID_Type(long userId, long receiverUserId,
        int receiverType) throws com.liferay.portal.SystemException;

    public int countByUID_RCN_Type(long userId,
        java.lang.String receiverUserName, int receiverType)
        throws com.liferay.portal.SystemException;

    public int countByUCN_Type(java.lang.String userName, int receiverType)
        throws com.liferay.portal.SystemException;

    public int countByUCN_RUID_Type(java.lang.String userName,
        long receiverUserId, int receiverType)
        throws com.liferay.portal.SystemException;

    public int countByUCN_RCN_Type(java.lang.String userName,
        java.lang.String receiverUserName, int receiverType)
        throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.receivergroup.model.ReceiverGroup> getReceiverGroups(
        long pk) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.receivergroup.model.ReceiverGroup> getReceiverGroups(
        long pk, int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.receivergroup.model.ReceiverGroup> getReceiverGroups(
        long pk, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public int getReceiverGroupsSize(long pk)
        throws com.liferay.portal.SystemException;

    public boolean containsReceiverGroup(long pk, long receiverGroupPK)
        throws com.liferay.portal.SystemException;

    public boolean containsReceiverGroups(long pk)
        throws com.liferay.portal.SystemException;

    public void addReceiverGroup(long pk, long receiverGroupPK)
        throws com.liferay.portal.SystemException;

    public void addReceiverGroup(long pk,
        com.sgs.portlet.receivergroup.model.ReceiverGroup receiverGroup)
        throws com.liferay.portal.SystemException;

    public void addReceiverGroups(long pk, long[] receiverGroupPKs)
        throws com.liferay.portal.SystemException;

    public void addReceiverGroups(long pk,
        java.util.List<com.sgs.portlet.receivergroup.model.ReceiverGroup> receiverGroups)
        throws com.liferay.portal.SystemException;

    public void clearReceiverGroups(long pk)
        throws com.liferay.portal.SystemException;

    public void removeReceiverGroup(long pk, long receiverGroupPK)
        throws com.liferay.portal.SystemException;

    public void removeReceiverGroup(long pk,
        com.sgs.portlet.receivergroup.model.ReceiverGroup receiverGroup)
        throws com.liferay.portal.SystemException;

    public void removeReceiverGroups(long pk, long[] receiverGroupPKs)
        throws com.liferay.portal.SystemException;

    public void removeReceiverGroups(long pk,
        java.util.List<com.sgs.portlet.receivergroup.model.ReceiverGroup> receiverGroups)
        throws com.liferay.portal.SystemException;

    public void setReceiverGroups(long pk, long[] receiverGroupPKs)
        throws com.liferay.portal.SystemException;

    public void setReceiverGroups(long pk,
        java.util.List<com.sgs.portlet.receivergroup.model.ReceiverGroup> receiverGroups)
        throws com.liferay.portal.SystemException;

    public void registerListener(
        com.liferay.portal.model.ModelListener listener);

    public void unregisterListener(
        com.liferay.portal.model.ModelListener listener);
}
