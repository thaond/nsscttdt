package com.sgs.portlet.onedoor.service.persistence;

public interface PmlDepartmentsLeaderPersistence {
    public com.sgs.portlet.onedoor.model.PmlDepartmentsLeader create(
        com.sgs.portlet.onedoor.service.persistence.PmlDepartmentsLeaderPK pmlDepartmentsLeaderPK);

    public com.sgs.portlet.onedoor.model.PmlDepartmentsLeader remove(
        com.sgs.portlet.onedoor.service.persistence.PmlDepartmentsLeaderPK pmlDepartmentsLeaderPK)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlDepartmentsLeaderException;

    public com.sgs.portlet.onedoor.model.PmlDepartmentsLeader remove(
        com.sgs.portlet.onedoor.model.PmlDepartmentsLeader pmlDepartmentsLeader)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(PmlDepartmentsLeader pmlDepartmentsLeader, boolean merge)</code>.
     */
    public com.sgs.portlet.onedoor.model.PmlDepartmentsLeader update(
        com.sgs.portlet.onedoor.model.PmlDepartmentsLeader pmlDepartmentsLeader)
        throws com.liferay.portal.SystemException;

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlDepartmentsLeader the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlDepartmentsLeader is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public com.sgs.portlet.onedoor.model.PmlDepartmentsLeader update(
        com.sgs.portlet.onedoor.model.PmlDepartmentsLeader pmlDepartmentsLeader,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.onedoor.model.PmlDepartmentsLeader updateImpl(
        com.sgs.portlet.onedoor.model.PmlDepartmentsLeader pmlDepartmentsLeader,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.onedoor.model.PmlDepartmentsLeader findByPrimaryKey(
        com.sgs.portlet.onedoor.service.persistence.PmlDepartmentsLeaderPK pmlDepartmentsLeaderPK)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlDepartmentsLeaderException;

    public com.sgs.portlet.onedoor.model.PmlDepartmentsLeader fetchByPrimaryKey(
        com.sgs.portlet.onedoor.service.persistence.PmlDepartmentsLeaderPK pmlDepartmentsLeaderPK)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlDepartmentsLeader> findByDepartmentsId(
        java.lang.String departmentsId)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlDepartmentsLeader> findByDepartmentsId(
        java.lang.String departmentsId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlDepartmentsLeader> findByDepartmentsId(
        java.lang.String departmentsId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.onedoor.model.PmlDepartmentsLeader findByDepartmentsId_First(
        java.lang.String departmentsId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlDepartmentsLeaderException;

    public com.sgs.portlet.onedoor.model.PmlDepartmentsLeader findByDepartmentsId_Last(
        java.lang.String departmentsId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlDepartmentsLeaderException;

    public com.sgs.portlet.onedoor.model.PmlDepartmentsLeader[] findByDepartmentsId_PrevAndNext(
        com.sgs.portlet.onedoor.service.persistence.PmlDepartmentsLeaderPK pmlDepartmentsLeaderPK,
        java.lang.String departmentsId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlDepartmentsLeaderException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlDepartmentsLeader> findByUserId(
        long userId) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlDepartmentsLeader> findByUserId(
        long userId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlDepartmentsLeader> findByUserId(
        long userId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.onedoor.model.PmlDepartmentsLeader findByUserId_First(
        long userId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlDepartmentsLeaderException;

    public com.sgs.portlet.onedoor.model.PmlDepartmentsLeader findByUserId_Last(
        long userId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlDepartmentsLeaderException;

    public com.sgs.portlet.onedoor.model.PmlDepartmentsLeader[] findByUserId_PrevAndNext(
        com.sgs.portlet.onedoor.service.persistence.PmlDepartmentsLeaderPK pmlDepartmentsLeaderPK,
        long userId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlDepartmentsLeaderException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlDepartmentsLeader> findByDepartmentsId_UserId(
        java.lang.String departmentsId, long userId)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlDepartmentsLeader> findByDepartmentsId_UserId(
        java.lang.String departmentsId, long userId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlDepartmentsLeader> findByDepartmentsId_UserId(
        java.lang.String departmentsId, long userId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.onedoor.model.PmlDepartmentsLeader findByDepartmentsId_UserId_First(
        java.lang.String departmentsId, long userId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlDepartmentsLeaderException;

    public com.sgs.portlet.onedoor.model.PmlDepartmentsLeader findByDepartmentsId_UserId_Last(
        java.lang.String departmentsId, long userId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlDepartmentsLeaderException;

    public com.sgs.portlet.onedoor.model.PmlDepartmentsLeader[] findByDepartmentsId_UserId_PrevAndNext(
        com.sgs.portlet.onedoor.service.persistence.PmlDepartmentsLeaderPK pmlDepartmentsLeaderPK,
        java.lang.String departmentsId, long userId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlDepartmentsLeaderException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlDepartmentsLeader> findByClericalId(
        long clericalId) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlDepartmentsLeader> findByClericalId(
        long clericalId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlDepartmentsLeader> findByClericalId(
        long clericalId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.onedoor.model.PmlDepartmentsLeader findByClericalId_First(
        long clericalId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlDepartmentsLeaderException;

    public com.sgs.portlet.onedoor.model.PmlDepartmentsLeader findByClericalId_Last(
        long clericalId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlDepartmentsLeaderException;

    public com.sgs.portlet.onedoor.model.PmlDepartmentsLeader[] findByClericalId_PrevAndNext(
        com.sgs.portlet.onedoor.service.persistence.PmlDepartmentsLeaderPK pmlDepartmentsLeaderPK,
        long clericalId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlDepartmentsLeaderException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlDepartmentsLeader> findByDepartmentsId_Main(
        java.lang.String departmentsId, boolean main)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlDepartmentsLeader> findByDepartmentsId_Main(
        java.lang.String departmentsId, boolean main, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlDepartmentsLeader> findByDepartmentsId_Main(
        java.lang.String departmentsId, boolean main, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.onedoor.model.PmlDepartmentsLeader findByDepartmentsId_Main_First(
        java.lang.String departmentsId, boolean main,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlDepartmentsLeaderException;

    public com.sgs.portlet.onedoor.model.PmlDepartmentsLeader findByDepartmentsId_Main_Last(
        java.lang.String departmentsId, boolean main,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlDepartmentsLeaderException;

    public com.sgs.portlet.onedoor.model.PmlDepartmentsLeader[] findByDepartmentsId_Main_PrevAndNext(
        com.sgs.portlet.onedoor.service.persistence.PmlDepartmentsLeaderPK pmlDepartmentsLeaderPK,
        java.lang.String departmentsId, boolean main,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlDepartmentsLeaderException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlDepartmentsLeader> findByMain(
        boolean main) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlDepartmentsLeader> findByMain(
        boolean main, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlDepartmentsLeader> findByMain(
        boolean main, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.onedoor.model.PmlDepartmentsLeader findByMain_First(
        boolean main, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlDepartmentsLeaderException;

    public com.sgs.portlet.onedoor.model.PmlDepartmentsLeader findByMain_Last(
        boolean main, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlDepartmentsLeaderException;

    public com.sgs.portlet.onedoor.model.PmlDepartmentsLeader[] findByMain_PrevAndNext(
        com.sgs.portlet.onedoor.service.persistence.PmlDepartmentsLeaderPK pmlDepartmentsLeaderPK,
        boolean main, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlDepartmentsLeaderException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlDepartmentsLeader> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlDepartmentsLeader> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlDepartmentsLeader> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeByDepartmentsId(java.lang.String departmentsId)
        throws com.liferay.portal.SystemException;

    public void removeByUserId(long userId)
        throws com.liferay.portal.SystemException;

    public void removeByDepartmentsId_UserId(java.lang.String departmentsId,
        long userId) throws com.liferay.portal.SystemException;

    public void removeByClericalId(long clericalId)
        throws com.liferay.portal.SystemException;

    public void removeByDepartmentsId_Main(java.lang.String departmentsId,
        boolean main) throws com.liferay.portal.SystemException;

    public void removeByMain(boolean main)
        throws com.liferay.portal.SystemException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countByDepartmentsId(java.lang.String departmentsId)
        throws com.liferay.portal.SystemException;

    public int countByUserId(long userId)
        throws com.liferay.portal.SystemException;

    public int countByDepartmentsId_UserId(java.lang.String departmentsId,
        long userId) throws com.liferay.portal.SystemException;

    public int countByClericalId(long clericalId)
        throws com.liferay.portal.SystemException;

    public int countByDepartmentsId_Main(java.lang.String departmentsId,
        boolean main) throws com.liferay.portal.SystemException;

    public int countByMain(boolean main)
        throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;

    public void registerListener(
        com.liferay.portal.model.ModelListener listener);

    public void unregisterListener(
        com.liferay.portal.model.ModelListener listener);
}
