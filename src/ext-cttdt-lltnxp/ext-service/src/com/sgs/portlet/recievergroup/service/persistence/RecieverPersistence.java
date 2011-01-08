package com.sgs.portlet.recievergroup.service.persistence;

public interface RecieverPersistence {
    public com.sgs.portlet.recievergroup.model.Reciever create(long recieverId);

    public com.sgs.portlet.recievergroup.model.Reciever remove(long recieverId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.recievergroup.NoSuchRecieverException;

    public com.sgs.portlet.recievergroup.model.Reciever remove(
        com.sgs.portlet.recievergroup.model.Reciever reciever)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(Reciever reciever, boolean merge)</code>.
     */
    public com.sgs.portlet.recievergroup.model.Reciever update(
        com.sgs.portlet.recievergroup.model.Reciever reciever)
        throws com.liferay.portal.SystemException;

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
    public com.sgs.portlet.recievergroup.model.Reciever update(
        com.sgs.portlet.recievergroup.model.Reciever reciever, boolean merge)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.recievergroup.model.Reciever updateImpl(
        com.sgs.portlet.recievergroup.model.Reciever reciever, boolean merge)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.recievergroup.model.Reciever findByPrimaryKey(
        long recieverId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.recievergroup.NoSuchRecieverException;

    public com.sgs.portlet.recievergroup.model.Reciever fetchByPrimaryKey(
        long recieverId) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.recievergroup.model.Reciever> findByUID_Type(
        long userId, int recieverType)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.recievergroup.model.Reciever> findByUID_Type(
        long userId, int recieverType, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.recievergroup.model.Reciever> findByUID_Type(
        long userId, int recieverType, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.recievergroup.model.Reciever findByUID_Type_First(
        long userId, int recieverType,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.recievergroup.NoSuchRecieverException;

    public com.sgs.portlet.recievergroup.model.Reciever findByUID_Type_Last(
        long userId, int recieverType,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.recievergroup.NoSuchRecieverException;

    public com.sgs.portlet.recievergroup.model.Reciever[] findByUID_Type_PrevAndNext(
        long recieverId, long userId, int recieverType,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.recievergroup.NoSuchRecieverException;

    public com.sgs.portlet.recievergroup.model.Reciever findByUID_RUID_Type(
        long userId, long recieverUserId, int recieverType)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.recievergroup.NoSuchRecieverException;

    public com.sgs.portlet.recievergroup.model.Reciever fetchByUID_RUID_Type(
        long userId, long recieverUserId, int recieverType)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.recievergroup.model.Reciever findByUID_RCN_Type(
        long userId, java.lang.String recieverUserName, int recieverType)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.recievergroup.NoSuchRecieverException;

    public com.sgs.portlet.recievergroup.model.Reciever fetchByUID_RCN_Type(
        long userId, java.lang.String recieverUserName, int recieverType)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.recievergroup.model.Reciever> findByUCN_Type(
        java.lang.String userName, int recieverType)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.recievergroup.model.Reciever> findByUCN_Type(
        java.lang.String userName, int recieverType, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.recievergroup.model.Reciever> findByUCN_Type(
        java.lang.String userName, int recieverType, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.recievergroup.model.Reciever findByUCN_Type_First(
        java.lang.String userName, int recieverType,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.recievergroup.NoSuchRecieverException;

    public com.sgs.portlet.recievergroup.model.Reciever findByUCN_Type_Last(
        java.lang.String userName, int recieverType,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.recievergroup.NoSuchRecieverException;

    public com.sgs.portlet.recievergroup.model.Reciever[] findByUCN_Type_PrevAndNext(
        long recieverId, java.lang.String userName, int recieverType,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.recievergroup.NoSuchRecieverException;

    public com.sgs.portlet.recievergroup.model.Reciever findByUCN_RUID_Type(
        java.lang.String userName, long recieverUserId, int recieverType)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.recievergroup.NoSuchRecieverException;

    public com.sgs.portlet.recievergroup.model.Reciever fetchByUCN_RUID_Type(
        java.lang.String userName, long recieverUserId, int recieverType)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.recievergroup.model.Reciever findByUCN_RCN_Type(
        java.lang.String userName, java.lang.String recieverUserName,
        int recieverType)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.recievergroup.NoSuchRecieverException;

    public com.sgs.portlet.recievergroup.model.Reciever fetchByUCN_RCN_Type(
        java.lang.String userName, java.lang.String recieverUserName,
        int recieverType) throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.recievergroup.model.Reciever> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.recievergroup.model.Reciever> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.recievergroup.model.Reciever> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeByUID_Type(long userId, int recieverType)
        throws com.liferay.portal.SystemException;

    public void removeByUID_RUID_Type(long userId, long recieverUserId,
        int recieverType)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.recievergroup.NoSuchRecieverException;

    public void removeByUID_RCN_Type(long userId,
        java.lang.String recieverUserName, int recieverType)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.recievergroup.NoSuchRecieverException;

    public void removeByUCN_Type(java.lang.String userName, int recieverType)
        throws com.liferay.portal.SystemException;

    public void removeByUCN_RUID_Type(java.lang.String userName,
        long recieverUserId, int recieverType)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.recievergroup.NoSuchRecieverException;

    public void removeByUCN_RCN_Type(java.lang.String userName,
        java.lang.String recieverUserName, int recieverType)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.recievergroup.NoSuchRecieverException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countByUID_Type(long userId, int recieverType)
        throws com.liferay.portal.SystemException;

    public int countByUID_RUID_Type(long userId, long recieverUserId,
        int recieverType) throws com.liferay.portal.SystemException;

    public int countByUID_RCN_Type(long userId,
        java.lang.String recieverUserName, int recieverType)
        throws com.liferay.portal.SystemException;

    public int countByUCN_Type(java.lang.String userName, int recieverType)
        throws com.liferay.portal.SystemException;

    public int countByUCN_RUID_Type(java.lang.String userName,
        long recieverUserId, int recieverType)
        throws com.liferay.portal.SystemException;

    public int countByUCN_RCN_Type(java.lang.String userName,
        java.lang.String recieverUserName, int recieverType)
        throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.recievergroup.model.RecieverGroup> getRecieverGroups(
        long pk) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.recievergroup.model.RecieverGroup> getRecieverGroups(
        long pk, int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.recievergroup.model.RecieverGroup> getRecieverGroups(
        long pk, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public int getRecieverGroupsSize(long pk)
        throws com.liferay.portal.SystemException;

    public boolean containsRecieverGroup(long pk, long recieverGroupPK)
        throws com.liferay.portal.SystemException;

    public boolean containsRecieverGroups(long pk)
        throws com.liferay.portal.SystemException;

    public void addRecieverGroup(long pk, long recieverGroupPK)
        throws com.liferay.portal.SystemException;

    public void addRecieverGroup(long pk,
        com.sgs.portlet.recievergroup.model.RecieverGroup recieverGroup)
        throws com.liferay.portal.SystemException;

    public void addRecieverGroups(long pk, long[] recieverGroupPKs)
        throws com.liferay.portal.SystemException;

    public void addRecieverGroups(long pk,
        java.util.List<com.sgs.portlet.recievergroup.model.RecieverGroup> recieverGroups)
        throws com.liferay.portal.SystemException;

    public void clearRecieverGroups(long pk)
        throws com.liferay.portal.SystemException;

    public void removeRecieverGroup(long pk, long recieverGroupPK)
        throws com.liferay.portal.SystemException;

    public void removeRecieverGroup(long pk,
        com.sgs.portlet.recievergroup.model.RecieverGroup recieverGroup)
        throws com.liferay.portal.SystemException;

    public void removeRecieverGroups(long pk, long[] recieverGroupPKs)
        throws com.liferay.portal.SystemException;

    public void removeRecieverGroups(long pk,
        java.util.List<com.sgs.portlet.recievergroup.model.RecieverGroup> recieverGroups)
        throws com.liferay.portal.SystemException;

    public void setRecieverGroups(long pk, long[] recieverGroupPKs)
        throws com.liferay.portal.SystemException;

    public void setRecieverGroups(long pk,
        java.util.List<com.sgs.portlet.recievergroup.model.RecieverGroup> recieverGroups)
        throws com.liferay.portal.SystemException;

    public void registerListener(
        com.liferay.portal.model.ModelListener listener);

    public void unregisterListener(
        com.liferay.portal.model.ModelListener listener);
}
