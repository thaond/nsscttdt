package com.ext.portlet.meetingcalendar.service.persistence;

public interface RoomResourcePersistence {
    public com.ext.portlet.meetingcalendar.model.RoomResource create(
        long roomId);

    public com.ext.portlet.meetingcalendar.model.RoomResource remove(
        long roomId)
        throws com.ext.portlet.meetingcalendar.NoSuchRoomResourceException,
            com.liferay.portal.SystemException;

    public com.ext.portlet.meetingcalendar.model.RoomResource remove(
        com.ext.portlet.meetingcalendar.model.RoomResource roomResource)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(RoomResource roomResource, boolean merge)</code>.
     */
    public com.ext.portlet.meetingcalendar.model.RoomResource update(
        com.ext.portlet.meetingcalendar.model.RoomResource roomResource)
        throws com.liferay.portal.SystemException;

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                roomResource the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when roomResource is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public com.ext.portlet.meetingcalendar.model.RoomResource update(
        com.ext.portlet.meetingcalendar.model.RoomResource roomResource,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.ext.portlet.meetingcalendar.model.RoomResource updateImpl(
        com.ext.portlet.meetingcalendar.model.RoomResource roomResource,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.ext.portlet.meetingcalendar.model.RoomResource findByPrimaryKey(
        long roomId)
        throws com.ext.portlet.meetingcalendar.NoSuchRoomResourceException,
            com.liferay.portal.SystemException;

    public com.ext.portlet.meetingcalendar.model.RoomResource fetchByPrimaryKey(
        long roomId) throws com.liferay.portal.SystemException;

    public com.ext.portlet.meetingcalendar.model.RoomResource findByN_C(
        java.lang.String roomName, long companyId)
        throws com.ext.portlet.meetingcalendar.NoSuchRoomResourceException,
            com.liferay.portal.SystemException;

    public com.ext.portlet.meetingcalendar.model.RoomResource fetchByN_C(
        java.lang.String roomName, long companyId)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.ext.portlet.meetingcalendar.model.RoomResource> findByCompanyId(
        long companyId) throws com.liferay.portal.SystemException;

    public java.util.List<com.ext.portlet.meetingcalendar.model.RoomResource> findByCompanyId(
        long companyId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.ext.portlet.meetingcalendar.model.RoomResource> findByCompanyId(
        long companyId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.ext.portlet.meetingcalendar.model.RoomResource findByCompanyId_First(
        long companyId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.ext.portlet.meetingcalendar.NoSuchRoomResourceException,
            com.liferay.portal.SystemException;

    public com.ext.portlet.meetingcalendar.model.RoomResource findByCompanyId_Last(
        long companyId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.ext.portlet.meetingcalendar.NoSuchRoomResourceException,
            com.liferay.portal.SystemException;

    public com.ext.portlet.meetingcalendar.model.RoomResource[] findByCompanyId_PrevAndNext(
        long roomId, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.ext.portlet.meetingcalendar.NoSuchRoomResourceException,
            com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.ext.portlet.meetingcalendar.model.RoomResource> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.ext.portlet.meetingcalendar.model.RoomResource> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.ext.portlet.meetingcalendar.model.RoomResource> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeByN_C(java.lang.String roomName, long companyId)
        throws com.ext.portlet.meetingcalendar.NoSuchRoomResourceException,
            com.liferay.portal.SystemException;

    public void removeByCompanyId(long companyId)
        throws com.liferay.portal.SystemException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countByN_C(java.lang.String roomName, long companyId)
        throws com.liferay.portal.SystemException;

    public int countByCompanyId(long companyId)
        throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;

    public void registerListener(
        com.liferay.portal.model.ModelListener listener);

    public void unregisterListener(
        com.liferay.portal.model.ModelListener listener);
}
