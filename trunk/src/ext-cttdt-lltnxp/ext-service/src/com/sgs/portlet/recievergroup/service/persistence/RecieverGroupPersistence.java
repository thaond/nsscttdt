package com.sgs.portlet.recievergroup.service.persistence;

public interface RecieverGroupPersistence {
    public com.sgs.portlet.recievergroup.model.RecieverGroup create(
        long recieverGroupId);

    public com.sgs.portlet.recievergroup.model.RecieverGroup remove(
        long recieverGroupId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.recievergroup.NoSuchException;

    public com.sgs.portlet.recievergroup.model.RecieverGroup remove(
        com.sgs.portlet.recievergroup.model.RecieverGroup recieverGroup)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(RecieverGroup recieverGroup, boolean merge)</code>.
     */
    public com.sgs.portlet.recievergroup.model.RecieverGroup update(
        com.sgs.portlet.recievergroup.model.RecieverGroup recieverGroup)
        throws com.liferay.portal.SystemException;

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
    public com.sgs.portlet.recievergroup.model.RecieverGroup update(
        com.sgs.portlet.recievergroup.model.RecieverGroup recieverGroup,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.recievergroup.model.RecieverGroup updateImpl(
        com.sgs.portlet.recievergroup.model.RecieverGroup recieverGroup,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.recievergroup.model.RecieverGroup findByPrimaryKey(
        long recieverGroupId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.recievergroup.NoSuchException;

    public com.sgs.portlet.recievergroup.model.RecieverGroup fetchByPrimaryKey(
        long recieverGroupId) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.recievergroup.model.RecieverGroup findByUID_Name(
        long userId, java.lang.String recieverGroupName)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.recievergroup.NoSuchException;

    public com.sgs.portlet.recievergroup.model.RecieverGroup fetchByUID_Name(
        long userId, java.lang.String recieverGroupName)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.recievergroup.model.RecieverGroup> findByUserId(
        long userId) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.recievergroup.model.RecieverGroup> findByUserId(
        long userId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.recievergroup.model.RecieverGroup> findByUserId(
        long userId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.recievergroup.model.RecieverGroup findByUserId_First(
        long userId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.recievergroup.NoSuchException;

    public com.sgs.portlet.recievergroup.model.RecieverGroup findByUserId_Last(
        long userId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.recievergroup.NoSuchException;

    public com.sgs.portlet.recievergroup.model.RecieverGroup[] findByUserId_PrevAndNext(
        long recieverGroupId, long userId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.recievergroup.NoSuchException;

    public java.util.List<com.sgs.portlet.recievergroup.model.RecieverGroup> findByUserId_Type(
        long userId, int type) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.recievergroup.model.RecieverGroup> findByUserId_Type(
        long userId, int type, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.recievergroup.model.RecieverGroup> findByUserId_Type(
        long userId, int type, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.recievergroup.model.RecieverGroup findByUserId_Type_First(
        long userId, int type,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.recievergroup.NoSuchException;

    public com.sgs.portlet.recievergroup.model.RecieverGroup findByUserId_Type_Last(
        long userId, int type,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.recievergroup.NoSuchException;

    public com.sgs.portlet.recievergroup.model.RecieverGroup[] findByUserId_Type_PrevAndNext(
        long recieverGroupId, long userId, int type,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.recievergroup.NoSuchException;

    public java.util.List<com.sgs.portlet.recievergroup.model.RecieverGroup> findByUserId_Type_Active(
        long userId, int type, boolean active)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.recievergroup.model.RecieverGroup> findByUserId_Type_Active(
        long userId, int type, boolean active, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.recievergroup.model.RecieverGroup> findByUserId_Type_Active(
        long userId, int type, boolean active, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.recievergroup.model.RecieverGroup findByUserId_Type_Active_First(
        long userId, int type, boolean active,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.recievergroup.NoSuchException;

    public com.sgs.portlet.recievergroup.model.RecieverGroup findByUserId_Type_Active_Last(
        long userId, int type, boolean active,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.recievergroup.NoSuchException;

    public com.sgs.portlet.recievergroup.model.RecieverGroup[] findByUserId_Type_Active_PrevAndNext(
        long recieverGroupId, long userId, int type, boolean active,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.recievergroup.NoSuchException;

    public java.util.List<com.sgs.portlet.recievergroup.model.RecieverGroup> findByUserId_Active(
        long userId, boolean active) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.recievergroup.model.RecieverGroup> findByUserId_Active(
        long userId, boolean active, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.recievergroup.model.RecieverGroup> findByUserId_Active(
        long userId, boolean active, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.recievergroup.model.RecieverGroup findByUserId_Active_First(
        long userId, boolean active,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.recievergroup.NoSuchException;

    public com.sgs.portlet.recievergroup.model.RecieverGroup findByUserId_Active_Last(
        long userId, boolean active,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.recievergroup.NoSuchException;

    public com.sgs.portlet.recievergroup.model.RecieverGroup[] findByUserId_Active_PrevAndNext(
        long recieverGroupId, long userId, boolean active,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.recievergroup.NoSuchException;

    public java.util.List<com.sgs.portlet.recievergroup.model.RecieverGroup> findByUserName(
        java.lang.String userName) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.recievergroup.model.RecieverGroup> findByUserName(
        java.lang.String userName, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.recievergroup.model.RecieverGroup> findByUserName(
        java.lang.String userName, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.recievergroup.model.RecieverGroup findByUserName_First(
        java.lang.String userName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.recievergroup.NoSuchException;

    public com.sgs.portlet.recievergroup.model.RecieverGroup findByUserName_Last(
        java.lang.String userName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.recievergroup.NoSuchException;

    public com.sgs.portlet.recievergroup.model.RecieverGroup[] findByUserName_PrevAndNext(
        long recieverGroupId, java.lang.String userName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.recievergroup.NoSuchException;

    public java.util.List<com.sgs.portlet.recievergroup.model.RecieverGroup> findByUserName_Type(
        java.lang.String userName, int type)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.recievergroup.model.RecieverGroup> findByUserName_Type(
        java.lang.String userName, int type, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.recievergroup.model.RecieverGroup> findByUserName_Type(
        java.lang.String userName, int type, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.recievergroup.model.RecieverGroup findByUserName_Type_First(
        java.lang.String userName, int type,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.recievergroup.NoSuchException;

    public com.sgs.portlet.recievergroup.model.RecieverGroup findByUserName_Type_Last(
        java.lang.String userName, int type,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.recievergroup.NoSuchException;

    public com.sgs.portlet.recievergroup.model.RecieverGroup[] findByUserName_Type_PrevAndNext(
        long recieverGroupId, java.lang.String userName, int type,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.recievergroup.NoSuchException;

    public java.util.List<com.sgs.portlet.recievergroup.model.RecieverGroup> findByUserName_Active(
        java.lang.String userName, boolean active)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.recievergroup.model.RecieverGroup> findByUserName_Active(
        java.lang.String userName, boolean active, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.recievergroup.model.RecieverGroup> findByUserName_Active(
        java.lang.String userName, boolean active, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.recievergroup.model.RecieverGroup findByUserName_Active_First(
        java.lang.String userName, boolean active,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.recievergroup.NoSuchException;

    public com.sgs.portlet.recievergroup.model.RecieverGroup findByUserName_Active_Last(
        java.lang.String userName, boolean active,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.recievergroup.NoSuchException;

    public com.sgs.portlet.recievergroup.model.RecieverGroup[] findByUserName_Active_PrevAndNext(
        long recieverGroupId, java.lang.String userName, boolean active,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.recievergroup.NoSuchException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.recievergroup.model.RecieverGroup> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.recievergroup.model.RecieverGroup> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.recievergroup.model.RecieverGroup> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeByUID_Name(long userId, java.lang.String recieverGroupName)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.recievergroup.NoSuchException;

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

    public int countByUID_Name(long userId, java.lang.String recieverGroupName)
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

    public java.util.List<com.sgs.portlet.recievergroup.model.Reciever> getRecievers(
        long pk) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.recievergroup.model.Reciever> getRecievers(
        long pk, int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.recievergroup.model.Reciever> getRecievers(
        long pk, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public int getRecieversSize(long pk)
        throws com.liferay.portal.SystemException;

    public boolean containsReciever(long pk, long recieverPK)
        throws com.liferay.portal.SystemException;

    public boolean containsRecievers(long pk)
        throws com.liferay.portal.SystemException;

    public void addReciever(long pk, long recieverPK)
        throws com.liferay.portal.SystemException;

    public void addReciever(long pk,
        com.sgs.portlet.recievergroup.model.Reciever reciever)
        throws com.liferay.portal.SystemException;

    public void addRecievers(long pk, long[] recieverPKs)
        throws com.liferay.portal.SystemException;

    public void addRecievers(long pk,
        java.util.List<com.sgs.portlet.recievergroup.model.Reciever> recievers)
        throws com.liferay.portal.SystemException;

    public void clearRecievers(long pk)
        throws com.liferay.portal.SystemException;

    public void removeReciever(long pk, long recieverPK)
        throws com.liferay.portal.SystemException;

    public void removeReciever(long pk,
        com.sgs.portlet.recievergroup.model.Reciever reciever)
        throws com.liferay.portal.SystemException;

    public void removeRecievers(long pk, long[] recieverPKs)
        throws com.liferay.portal.SystemException;

    public void removeRecievers(long pk,
        java.util.List<com.sgs.portlet.recievergroup.model.Reciever> recievers)
        throws com.liferay.portal.SystemException;

    public void setRecievers(long pk, long[] recieverPKs)
        throws com.liferay.portal.SystemException;

    public void setRecievers(long pk,
        java.util.List<com.sgs.portlet.recievergroup.model.Reciever> recievers)
        throws com.liferay.portal.SystemException;

    public void registerListener(
        com.liferay.portal.model.ModelListener listener);

    public void unregisterListener(
        com.liferay.portal.model.ModelListener listener);
}
