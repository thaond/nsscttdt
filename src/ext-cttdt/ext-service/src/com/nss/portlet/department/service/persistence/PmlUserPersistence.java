package com.nss.portlet.department.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;


public interface PmlUserPersistence extends BasePersistence {
    public void cacheResult(com.nss.portlet.department.model.PmlUser pmlUser);

    public void cacheResult(
        java.util.List<com.nss.portlet.department.model.PmlUser> pmlUsers);

    public void clearCache();

    public com.nss.portlet.department.model.PmlUser create(long userId);

    public com.nss.portlet.department.model.PmlUser remove(long userId)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.department.NoSuchPmlUserException;

    public com.nss.portlet.department.model.PmlUser remove(
        com.nss.portlet.department.model.PmlUser pmlUser)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(PmlUser pmlUser, boolean merge)</code>.
     */
    public com.nss.portlet.department.model.PmlUser update(
        com.nss.portlet.department.model.PmlUser pmlUser)
        throws com.liferay.portal.SystemException;

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlUser the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlUser is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public com.nss.portlet.department.model.PmlUser update(
        com.nss.portlet.department.model.PmlUser pmlUser, boolean merge)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.department.model.PmlUser updateImpl(
        com.nss.portlet.department.model.PmlUser pmlUser, boolean merge)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.department.model.PmlUser findByPrimaryKey(
        long userId)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.department.NoSuchPmlUserException;

    public com.nss.portlet.department.model.PmlUser fetchByPrimaryKey(
        long userId) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.department.model.PmlUser> findByDepartmentsId(
        java.lang.String departmentsId)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.department.model.PmlUser> findByDepartmentsId(
        java.lang.String departmentsId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.department.model.PmlUser> findByDepartmentsId(
        java.lang.String departmentsId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.department.model.PmlUser findByDepartmentsId_First(
        java.lang.String departmentsId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.department.NoSuchPmlUserException;

    public com.nss.portlet.department.model.PmlUser findByDepartmentsId_Last(
        java.lang.String departmentsId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.department.NoSuchPmlUserException;

    public com.nss.portlet.department.model.PmlUser[] findByDepartmentsId_PrevAndNext(
        long userId, java.lang.String departmentsId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.department.NoSuchPmlUserException;

    public java.util.List<com.nss.portlet.department.model.PmlUser> findByPositionId(
        java.lang.String positionId) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.department.model.PmlUser> findByPositionId(
        java.lang.String positionId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.department.model.PmlUser> findByPositionId(
        java.lang.String positionId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.department.model.PmlUser findByPositionId_First(
        java.lang.String positionId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.department.NoSuchPmlUserException;

    public com.nss.portlet.department.model.PmlUser findByPositionId_Last(
        java.lang.String positionId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.department.NoSuchPmlUserException;

    public com.nss.portlet.department.model.PmlUser[] findByPositionId_PrevAndNext(
        long userId, java.lang.String positionId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.department.NoSuchPmlUserException;

    public java.util.List<com.nss.portlet.department.model.PmlUser> findByDepartmentsId_PositionId(
        java.lang.String departmentsId, java.lang.String positionId)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.department.model.PmlUser> findByDepartmentsId_PositionId(
        java.lang.String departmentsId, java.lang.String positionId, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.department.model.PmlUser> findByDepartmentsId_PositionId(
        java.lang.String departmentsId, java.lang.String positionId, int start,
        int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.department.model.PmlUser findByDepartmentsId_PositionId_First(
        java.lang.String departmentsId, java.lang.String positionId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.department.NoSuchPmlUserException;

    public com.nss.portlet.department.model.PmlUser findByDepartmentsId_PositionId_Last(
        java.lang.String departmentsId, java.lang.String positionId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.department.NoSuchPmlUserException;

    public com.nss.portlet.department.model.PmlUser[] findByDepartmentsId_PositionId_PrevAndNext(
        long userId, java.lang.String departmentsId,
        java.lang.String positionId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.department.NoSuchPmlUserException;

    public java.util.List<com.nss.portlet.department.model.PmlUser> findByDepartmentsId_Active(
        java.lang.String departmentsId, java.lang.Boolean active)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.department.model.PmlUser> findByDepartmentsId_Active(
        java.lang.String departmentsId, java.lang.Boolean active, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.department.model.PmlUser> findByDepartmentsId_Active(
        java.lang.String departmentsId, java.lang.Boolean active, int start,
        int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.department.model.PmlUser findByDepartmentsId_Active_First(
        java.lang.String departmentsId, java.lang.Boolean active,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.department.NoSuchPmlUserException;

    public com.nss.portlet.department.model.PmlUser findByDepartmentsId_Active_Last(
        java.lang.String departmentsId, java.lang.Boolean active,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.department.NoSuchPmlUserException;

    public com.nss.portlet.department.model.PmlUser[] findByDepartmentsId_Active_PrevAndNext(
        long userId, java.lang.String departmentsId, java.lang.Boolean active,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.department.NoSuchPmlUserException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.department.model.PmlUser> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.department.model.PmlUser> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.department.model.PmlUser> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeByDepartmentsId(java.lang.String departmentsId)
        throws com.liferay.portal.SystemException;

    public void removeByPositionId(java.lang.String positionId)
        throws com.liferay.portal.SystemException;

    public void removeByDepartmentsId_PositionId(
        java.lang.String departmentsId, java.lang.String positionId)
        throws com.liferay.portal.SystemException;

    public void removeByDepartmentsId_Active(java.lang.String departmentsId,
        java.lang.Boolean active) throws com.liferay.portal.SystemException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countByDepartmentsId(java.lang.String departmentsId)
        throws com.liferay.portal.SystemException;

    public int countByPositionId(java.lang.String positionId)
        throws com.liferay.portal.SystemException;

    public int countByDepartmentsId_PositionId(java.lang.String departmentsId,
        java.lang.String positionId) throws com.liferay.portal.SystemException;

    public int countByDepartmentsId_Active(java.lang.String departmentsId,
        java.lang.Boolean active) throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;
}
