package com.nss.portlet.necessary_info.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;


public interface ThongTinCanThietPersistence extends BasePersistence {
    public void cacheResult(
        com.nss.portlet.necessary_info.model.ThongTinCanThiet thongTinCanThiet);

    public void cacheResult(
        java.util.List<com.nss.portlet.necessary_info.model.ThongTinCanThiet> thongTinCanThiets);

    public void clearCache();

    public com.nss.portlet.necessary_info.model.ThongTinCanThiet create(
        long maThongTinCanThiet);

    public com.nss.portlet.necessary_info.model.ThongTinCanThiet remove(
        long maThongTinCanThiet)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.necessary_info.NoSuchThongTinCanThietException;

    public com.nss.portlet.necessary_info.model.ThongTinCanThiet remove(
        com.nss.portlet.necessary_info.model.ThongTinCanThiet thongTinCanThiet)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(ThongTinCanThiet thongTinCanThiet, boolean merge)</code>.
     */
    public com.nss.portlet.necessary_info.model.ThongTinCanThiet update(
        com.nss.portlet.necessary_info.model.ThongTinCanThiet thongTinCanThiet)
        throws com.liferay.portal.SystemException;

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                thongTinCanThiet the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when thongTinCanThiet is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public com.nss.portlet.necessary_info.model.ThongTinCanThiet update(
        com.nss.portlet.necessary_info.model.ThongTinCanThiet thongTinCanThiet,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.nss.portlet.necessary_info.model.ThongTinCanThiet updateImpl(
        com.nss.portlet.necessary_info.model.ThongTinCanThiet thongTinCanThiet,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.nss.portlet.necessary_info.model.ThongTinCanThiet findByPrimaryKey(
        long maThongTinCanThiet)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.necessary_info.NoSuchThongTinCanThietException;

    public com.nss.portlet.necessary_info.model.ThongTinCanThiet fetchByPrimaryKey(
        long maThongTinCanThiet) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.necessary_info.model.ThongTinCanThiet> findByActive(
        int active) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.necessary_info.model.ThongTinCanThiet> findByActive(
        int active, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.necessary_info.model.ThongTinCanThiet> findByActive(
        int active, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.necessary_info.model.ThongTinCanThiet findByActive_First(
        int active, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.necessary_info.NoSuchThongTinCanThietException;

    public com.nss.portlet.necessary_info.model.ThongTinCanThiet findByActive_Last(
        int active, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.necessary_info.NoSuchThongTinCanThietException;

    public com.nss.portlet.necessary_info.model.ThongTinCanThiet[] findByActive_PrevAndNext(
        long maThongTinCanThiet, int active,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.necessary_info.NoSuchThongTinCanThietException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.necessary_info.model.ThongTinCanThiet> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.necessary_info.model.ThongTinCanThiet> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.necessary_info.model.ThongTinCanThiet> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeByActive(int active)
        throws com.liferay.portal.SystemException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countByActive(int active)
        throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;
}
