package com.nss.portlet.co_quan_ban_hanh.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;


public interface CoQuanBanHanhPersistence extends BasePersistence {
    public void cacheResult(
        com.nss.portlet.co_quan_ban_hanh.model.CoQuanBanHanh coQuanBanHanh);

    public void cacheResult(
        java.util.List<com.nss.portlet.co_quan_ban_hanh.model.CoQuanBanHanh> coQuanBanHanhs);

    public void clearCache();

    public com.nss.portlet.co_quan_ban_hanh.model.CoQuanBanHanh create(
        long maCoQuanBanHanh);

    public com.nss.portlet.co_quan_ban_hanh.model.CoQuanBanHanh remove(
        long maCoQuanBanHanh)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.co_quan_ban_hanh.NoSuchCoQuanBanHanhException;

    public com.nss.portlet.co_quan_ban_hanh.model.CoQuanBanHanh remove(
        com.nss.portlet.co_quan_ban_hanh.model.CoQuanBanHanh coQuanBanHanh)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(CoQuanBanHanh coQuanBanHanh, boolean merge)</code>.
     */
    public com.nss.portlet.co_quan_ban_hanh.model.CoQuanBanHanh update(
        com.nss.portlet.co_quan_ban_hanh.model.CoQuanBanHanh coQuanBanHanh)
        throws com.liferay.portal.SystemException;

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                coQuanBanHanh the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when coQuanBanHanh is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public com.nss.portlet.co_quan_ban_hanh.model.CoQuanBanHanh update(
        com.nss.portlet.co_quan_ban_hanh.model.CoQuanBanHanh coQuanBanHanh,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.nss.portlet.co_quan_ban_hanh.model.CoQuanBanHanh updateImpl(
        com.nss.portlet.co_quan_ban_hanh.model.CoQuanBanHanh coQuanBanHanh,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.nss.portlet.co_quan_ban_hanh.model.CoQuanBanHanh findByPrimaryKey(
        long maCoQuanBanHanh)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.co_quan_ban_hanh.NoSuchCoQuanBanHanhException;

    public com.nss.portlet.co_quan_ban_hanh.model.CoQuanBanHanh fetchByPrimaryKey(
        long maCoQuanBanHanh) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.co_quan_ban_hanh.model.CoQuanBanHanh> findByActive(
        int active) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.co_quan_ban_hanh.model.CoQuanBanHanh> findByActive(
        int active, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.co_quan_ban_hanh.model.CoQuanBanHanh> findByActive(
        int active, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.co_quan_ban_hanh.model.CoQuanBanHanh findByActive_First(
        int active, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.co_quan_ban_hanh.NoSuchCoQuanBanHanhException;

    public com.nss.portlet.co_quan_ban_hanh.model.CoQuanBanHanh findByActive_Last(
        int active, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.co_quan_ban_hanh.NoSuchCoQuanBanHanhException;

    public com.nss.portlet.co_quan_ban_hanh.model.CoQuanBanHanh[] findByActive_PrevAndNext(
        long maCoQuanBanHanh, int active,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.co_quan_ban_hanh.NoSuchCoQuanBanHanhException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.co_quan_ban_hanh.model.CoQuanBanHanh> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.co_quan_ban_hanh.model.CoQuanBanHanh> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.co_quan_ban_hanh.model.CoQuanBanHanh> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeByActive(int active)
        throws com.liferay.portal.SystemException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countByActive(int active)
        throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;
}
