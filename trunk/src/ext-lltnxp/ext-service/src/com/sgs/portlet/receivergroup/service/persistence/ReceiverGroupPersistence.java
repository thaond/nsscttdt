package com.sgs.portlet.receivergroup.service.persistence;

public interface ReceiverGroupPersistence {
    public com.sgs.portlet.receivergroup.model.ReceiverGroup create(
        long receiverGroupId);

    public com.sgs.portlet.receivergroup.model.ReceiverGroup remove(
        long receiverGroupId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.receivergroup.NoSuchException;

    public com.sgs.portlet.receivergroup.model.ReceiverGroup remove(
        com.sgs.portlet.receivergroup.model.ReceiverGroup receiverGroup)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(ReceiverGroup receiverGroup, boolean merge)</code>.
     */
    public com.sgs.portlet.receivergroup.model.ReceiverGroup update(
        com.sgs.portlet.receivergroup.model.ReceiverGroup receiverGroup)
        throws com.liferay.portal.SystemException;

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
    public com.sgs.portlet.receivergroup.model.ReceiverGroup update(
        com.sgs.portlet.receivergroup.model.ReceiverGroup receiverGroup,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.receivergroup.model.ReceiverGroup updateImpl(
        com.sgs.portlet.receivergroup.model.ReceiverGroup receiverGroup,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.receivergroup.model.ReceiverGroup findByPrimaryKey(
        long receiverGroupId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.receivergroup.NoSuchException;

    public com.sgs.portlet.receivergroup.model.ReceiverGroup fetchByPrimaryKey(
        long receiverGroupId) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.receivergroup.model.ReceiverGroup findByUID_Name(
        long userId, java.lang.String receiverGroupName)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.receivergroup.NoSuchException;

    public com.sgs.portlet.receivergroup.model.ReceiverGroup fetchByUID_Name(
        long userId, java.lang.String receiverGroupName)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.receivergroup.model.ReceiverGroup> findByUserId(
        long userId) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.receivergroup.model.ReceiverGroup> findByUserId(
        long userId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.receivergroup.model.ReceiverGroup> findByUserId(
        long userId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.receivergroup.model.ReceiverGroup findByUserId_First(
        long userId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.receivergroup.NoSuchException;

    public com.sgs.portlet.receivergroup.model.ReceiverGroup findByUserId_Last(
        long userId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.receivergroup.NoSuchException;

    public com.sgs.portlet.receivergroup.model.ReceiverGroup[] findByUserId_PrevAndNext(
        long receiverGroupId, long userId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.receivergroup.NoSuchException;

    public java.util.List<com.sgs.portlet.receivergroup.model.ReceiverGroup> findByUserId_Type(
        long userId, int type) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.receivergroup.model.ReceiverGroup> findByUserId_Type(
        long userId, int type, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.receivergroup.model.ReceiverGroup> findByUserId_Type(
        long userId, int type, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.receivergroup.model.ReceiverGroup findByUserId_Type_First(
        long userId, int type,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.receivergroup.NoSuchException;

    public com.sgs.portlet.receivergroup.model.ReceiverGroup findByUserId_Type_Last(
        long userId, int type,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.receivergroup.NoSuchException;

    public com.sgs.portlet.receivergroup.model.ReceiverGroup[] findByUserId_Type_PrevAndNext(
        long receiverGroupId, long userId, int type,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.receivergroup.NoSuchException;

    public java.util.List<com.sgs.portlet.receivergroup.model.ReceiverGroup> findByUserId_Type_Active(
        long userId, int type, boolean active)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.receivergroup.model.ReceiverGroup> findByUserId_Type_Active(
        long userId, int type, boolean active, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.receivergroup.model.ReceiverGroup> findByUserId_Type_Active(
        long userId, int type, boolean active, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.receivergroup.model.ReceiverGroup findByUserId_Type_Active_First(
        long userId, int type, boolean active,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.receivergroup.NoSuchException;

    public com.sgs.portlet.receivergroup.model.ReceiverGroup findByUserId_Type_Active_Last(
        long userId, int type, boolean active,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.receivergroup.NoSuchException;

    public com.sgs.portlet.receivergroup.model.ReceiverGroup[] findByUserId_Type_Active_PrevAndNext(
        long receiverGroupId, long userId, int type, boolean active,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.receivergroup.NoSuchException;

    public java.util.List<com.sgs.portlet.receivergroup.model.ReceiverGroup> findByUserId_Active(
        long userId, boolean active) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.receivergroup.model.ReceiverGroup> findByUserId_Active(
        long userId, boolean active, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.receivergroup.model.ReceiverGroup> findByUserId_Active(
        long userId, boolean active, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.receivergroup.model.ReceiverGroup findByUserId_Active_First(
        long userId, boolean active,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.receivergroup.NoSuchException;

    public com.sgs.portlet.receivergroup.model.ReceiverGroup findByUserId_Active_Last(
        long userId, boolean active,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.receivergroup.NoSuchException;

    public com.sgs.portlet.receivergroup.model.ReceiverGroup[] findByUserId_Active_PrevAndNext(
        long receiverGroupId, long userId, boolean active,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.receivergroup.NoSuchException;

    public java.util.List<com.sgs.portlet.receivergroup.model.ReceiverGroup> findByUserName(
        java.lang.String userName) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.receivergroup.model.ReceiverGroup> findByUserName(
        java.lang.String userName, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.receivergroup.model.ReceiverGroup> findByUserName(
        java.lang.String userName, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.receivergroup.model.ReceiverGroup findByUserName_First(
        java.lang.String userName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.receivergroup.NoSuchException;

    public com.sgs.portlet.receivergroup.model.ReceiverGroup findByUserName_Last(
        java.lang.String userName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.receivergroup.NoSuchException;

    public com.sgs.portlet.receivergroup.model.ReceiverGroup[] findByUserName_PrevAndNext(
        long receiverGroupId, java.lang.String userName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.receivergroup.NoSuchException;

    public java.util.List<com.sgs.portlet.receivergroup.model.ReceiverGroup> findByUserName_Type(
        java.lang.String userName, int type)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.receivergroup.model.ReceiverGroup> findByUserName_Type(
        java.lang.String userName, int type, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.receivergroup.model.ReceiverGroup> findByUserName_Type(
        java.lang.String userName, int type, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.receivergroup.model.ReceiverGroup findByUserName_Type_First(
        java.lang.String userName, int type,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.receivergroup.NoSuchException;

    public com.sgs.portlet.receivergroup.model.ReceiverGroup findByUserName_Type_Last(
        java.lang.String userName, int type,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.receivergroup.NoSuchException;

    public com.sgs.portlet.receivergroup.model.ReceiverGroup[] findByUserName_Type_PrevAndNext(
        long receiverGroupId, java.lang.String userName, int type,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.receivergroup.NoSuchException;

    public java.util.List<com.sgs.portlet.receivergroup.model.ReceiverGroup> findByUserName_Active(
        java.lang.String userName, boolean active)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.receivergroup.model.ReceiverGroup> findByUserName_Active(
        java.lang.String userName, boolean active, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.receivergroup.model.ReceiverGroup> findByUserName_Active(
        java.lang.String userName, boolean active, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.receivergroup.model.ReceiverGroup findByUserName_Active_First(
        java.lang.String userName, boolean active,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.receivergroup.NoSuchException;

    public com.sgs.portlet.receivergroup.model.ReceiverGroup findByUserName_Active_Last(
        java.lang.String userName, boolean active,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.receivergroup.NoSuchException;

    public com.sgs.portlet.receivergroup.model.ReceiverGroup[] findByUserName_Active_PrevAndNext(
        long receiverGroupId, java.lang.String userName, boolean active,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.receivergroup.NoSuchException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.receivergroup.model.ReceiverGroup> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.receivergroup.model.ReceiverGroup> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.receivergroup.model.ReceiverGroup> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeByUID_Name(long userId, java.lang.String receiverGroupName)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.receivergroup.NoSuchException;

    public void removeByUserId(long userId)
        throws com.liferay.portal.SystemException;

    public void removeByUserId_Type(long userId, int type)
        throws com.liferay.portal.SystemException;

    public void removeByUserId_Type_Active(long userId, int type, boolean active)
        throws com.liferay.portal.SystemException;

    public void removeByUserId_Active(long userId, boolean active)
        throws com.liferay.portal.SystemException;

    public void removeByUserName(java.lang.String userName)
        throws com.liferay.portal.SystemException;

    public void removeByUserName_Type(java.lang.String userName, int type)
        throws com.liferay.portal.SystemException;

    public void removeByUserName_Active(java.lang.String userName,
        boolean active) throws com.liferay.portal.SystemException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countByUID_Name(long userId, java.lang.String receiverGroupName)
        throws com.liferay.portal.SystemException;

    public int countByUserId(long userId)
        throws com.liferay.portal.SystemException;

    public int countByUserId_Type(long userId, int type)
        throws com.liferay.portal.SystemException;

    public int countByUserId_Type_Active(long userId, int type, boolean active)
        throws com.liferay.portal.SystemException;

    public int countByUserId_Active(long userId, boolean active)
        throws com.liferay.portal.SystemException;

    public int countByUserName(java.lang.String userName)
        throws com.liferay.portal.SystemException;

    public int countByUserName_Type(java.lang.String userName, int type)
        throws com.liferay.portal.SystemException;

    public int countByUserName_Active(java.lang.String userName, boolean active)
        throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.receivergroup.model.Receiver> getReceivers(
        long pk) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.receivergroup.model.Receiver> getReceivers(
        long pk, int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.receivergroup.model.Receiver> getReceivers(
        long pk, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public int getReceiversSize(long pk)
        throws com.liferay.portal.SystemException;

    public boolean containsReceiver(long pk, long receiverPK)
        throws com.liferay.portal.SystemException;

    public boolean containsReceivers(long pk)
        throws com.liferay.portal.SystemException;

    public void addReceiver(long pk, long receiverPK)
        throws com.liferay.portal.SystemException;

    public void addReceiver(long pk,
        com.sgs.portlet.receivergroup.model.Receiver receiver)
        throws com.liferay.portal.SystemException;

    public void addReceivers(long pk, long[] receiverPKs)
        throws com.liferay.portal.SystemException;

    public void addReceivers(long pk,
        java.util.List<com.sgs.portlet.receivergroup.model.Receiver> receivers)
        throws com.liferay.portal.SystemException;

    public void clearReceivers(long pk)
        throws com.liferay.portal.SystemException;

    public void removeReceiver(long pk, long receiverPK)
        throws com.liferay.portal.SystemException;

    public void removeReceiver(long pk,
        com.sgs.portlet.receivergroup.model.Receiver receiver)
        throws com.liferay.portal.SystemException;

    public void removeReceivers(long pk, long[] receiverPKs)
        throws com.liferay.portal.SystemException;

    public void removeReceivers(long pk,
        java.util.List<com.sgs.portlet.receivergroup.model.Receiver> receivers)
        throws com.liferay.portal.SystemException;

    public void setReceivers(long pk, long[] receiverPKs)
        throws com.liferay.portal.SystemException;

    public void setReceivers(long pk,
        java.util.List<com.sgs.portlet.receivergroup.model.Receiver> receivers)
        throws com.liferay.portal.SystemException;

    public void registerListener(
        com.liferay.portal.model.ModelListener listener);

    public void unregisterListener(
        com.liferay.portal.model.ModelListener listener);
}
