package com.ext.portlet.meetingcalendar.service.persistence;

public interface CarResourcePersistence {
    public com.ext.portlet.meetingcalendar.model.CarResource create(long carId);

    public com.ext.portlet.meetingcalendar.model.CarResource remove(long carId)
        throws com.ext.portlet.meetingcalendar.NoSuchCarResourceException,
            com.liferay.portal.SystemException;

    public com.ext.portlet.meetingcalendar.model.CarResource remove(
        com.ext.portlet.meetingcalendar.model.CarResource carResource)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(CarResource carResource, boolean merge)</code>.
     */
    public com.ext.portlet.meetingcalendar.model.CarResource update(
        com.ext.portlet.meetingcalendar.model.CarResource carResource)
        throws com.liferay.portal.SystemException;

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                carResource the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when carResource is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public com.ext.portlet.meetingcalendar.model.CarResource update(
        com.ext.portlet.meetingcalendar.model.CarResource carResource,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.ext.portlet.meetingcalendar.model.CarResource updateImpl(
        com.ext.portlet.meetingcalendar.model.CarResource carResource,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.ext.portlet.meetingcalendar.model.CarResource findByPrimaryKey(
        long carId)
        throws com.ext.portlet.meetingcalendar.NoSuchCarResourceException,
            com.liferay.portal.SystemException;

    public com.ext.portlet.meetingcalendar.model.CarResource fetchByPrimaryKey(
        long carId) throws com.liferay.portal.SystemException;

    public com.ext.portlet.meetingcalendar.model.CarResource findByC_C(
        java.lang.String carCode, long companyId)
        throws com.ext.portlet.meetingcalendar.NoSuchCarResourceException,
            com.liferay.portal.SystemException;

    public com.ext.portlet.meetingcalendar.model.CarResource fetchByC_C(
        java.lang.String carCode, long companyId)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.ext.portlet.meetingcalendar.model.CarResource> findByCompanyId(
        long companyId) throws com.liferay.portal.SystemException;

    public java.util.List<com.ext.portlet.meetingcalendar.model.CarResource> findByCompanyId(
        long companyId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.ext.portlet.meetingcalendar.model.CarResource> findByCompanyId(
        long companyId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.ext.portlet.meetingcalendar.model.CarResource findByCompanyId_First(
        long companyId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.ext.portlet.meetingcalendar.NoSuchCarResourceException,
            com.liferay.portal.SystemException;

    public com.ext.portlet.meetingcalendar.model.CarResource findByCompanyId_Last(
        long companyId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.ext.portlet.meetingcalendar.NoSuchCarResourceException,
            com.liferay.portal.SystemException;

    public com.ext.portlet.meetingcalendar.model.CarResource[] findByCompanyId_PrevAndNext(
        long carId, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.ext.portlet.meetingcalendar.NoSuchCarResourceException,
            com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.ext.portlet.meetingcalendar.model.CarResource> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.ext.portlet.meetingcalendar.model.CarResource> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.ext.portlet.meetingcalendar.model.CarResource> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeByC_C(java.lang.String carCode, long companyId)
        throws com.ext.portlet.meetingcalendar.NoSuchCarResourceException,
            com.liferay.portal.SystemException;

    public void removeByCompanyId(long companyId)
        throws com.liferay.portal.SystemException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countByC_C(java.lang.String carCode, long companyId)
        throws com.liferay.portal.SystemException;

    public int countByCompanyId(long companyId)
        throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;

    public void registerListener(
        com.liferay.portal.model.ModelListener listener);

    public void unregisterListener(
        com.liferay.portal.model.ModelListener listener);
}
