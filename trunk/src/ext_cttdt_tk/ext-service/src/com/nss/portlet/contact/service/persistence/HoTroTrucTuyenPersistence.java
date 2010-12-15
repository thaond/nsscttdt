package com.nss.portlet.contact.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;


public interface HoTroTrucTuyenPersistence extends BasePersistence {
    public void cacheResult(
        com.nss.portlet.contact.model.HoTroTrucTuyen hoTroTrucTuyen);

    public void cacheResult(
        java.util.List<com.nss.portlet.contact.model.HoTroTrucTuyen> hoTroTrucTuyens);

    public void clearCache();

    public com.nss.portlet.contact.model.HoTroTrucTuyen create(
        int maHoTroTrucTuyen);

    public com.nss.portlet.contact.model.HoTroTrucTuyen remove(
        int maHoTroTrucTuyen)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.contact.NoSuchHoTroTrucTuyenException;

    public com.nss.portlet.contact.model.HoTroTrucTuyen remove(
        com.nss.portlet.contact.model.HoTroTrucTuyen hoTroTrucTuyen)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(HoTroTrucTuyen hoTroTrucTuyen, boolean merge)</code>.
     */
    public com.nss.portlet.contact.model.HoTroTrucTuyen update(
        com.nss.portlet.contact.model.HoTroTrucTuyen hoTroTrucTuyen)
        throws com.liferay.portal.SystemException;

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                hoTroTrucTuyen the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when hoTroTrucTuyen is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public com.nss.portlet.contact.model.HoTroTrucTuyen update(
        com.nss.portlet.contact.model.HoTroTrucTuyen hoTroTrucTuyen,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.nss.portlet.contact.model.HoTroTrucTuyen updateImpl(
        com.nss.portlet.contact.model.HoTroTrucTuyen hoTroTrucTuyen,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.nss.portlet.contact.model.HoTroTrucTuyen findByPrimaryKey(
        int maHoTroTrucTuyen)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.contact.NoSuchHoTroTrucTuyenException;

    public com.nss.portlet.contact.model.HoTroTrucTuyen fetchByPrimaryKey(
        int maHoTroTrucTuyen) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.contact.model.HoTroTrucTuyen> findByActive(
        int active) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.contact.model.HoTroTrucTuyen> findByActive(
        int active, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.contact.model.HoTroTrucTuyen> findByActive(
        int active, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.contact.model.HoTroTrucTuyen findByActive_First(
        int active, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.contact.NoSuchHoTroTrucTuyenException;

    public com.nss.portlet.contact.model.HoTroTrucTuyen findByActive_Last(
        int active, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.contact.NoSuchHoTroTrucTuyenException;

    public com.nss.portlet.contact.model.HoTroTrucTuyen[] findByActive_PrevAndNext(
        int maHoTroTrucTuyen, int active,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.contact.NoSuchHoTroTrucTuyenException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.contact.model.HoTroTrucTuyen> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.contact.model.HoTroTrucTuyen> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.contact.model.HoTroTrucTuyen> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeByActive(int active)
        throws com.liferay.portal.SystemException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countByActive(int active)
        throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;
}
