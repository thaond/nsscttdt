package com.ext.portlet.meetingcalendar.service.persistence;

public interface MeetingCalendarPersistence {
    public com.ext.portlet.meetingcalendar.model.MeetingCalendar create(
        long mcalId);

    public com.ext.portlet.meetingcalendar.model.MeetingCalendar remove(
        long mcalId)
        throws com.ext.portlet.meetingcalendar.NoSuchendarException,
            com.liferay.portal.SystemException;

    public com.ext.portlet.meetingcalendar.model.MeetingCalendar remove(
        com.ext.portlet.meetingcalendar.model.MeetingCalendar meetingCalendar)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(MeetingCalendar meetingCalendar, boolean merge)</code>.
     */
    public com.ext.portlet.meetingcalendar.model.MeetingCalendar update(
        com.ext.portlet.meetingcalendar.model.MeetingCalendar meetingCalendar)
        throws com.liferay.portal.SystemException;

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                meetingCalendar the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when meetingCalendar is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public com.ext.portlet.meetingcalendar.model.MeetingCalendar update(
        com.ext.portlet.meetingcalendar.model.MeetingCalendar meetingCalendar,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.ext.portlet.meetingcalendar.model.MeetingCalendar updateImpl(
        com.ext.portlet.meetingcalendar.model.MeetingCalendar meetingCalendar,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.ext.portlet.meetingcalendar.model.MeetingCalendar findByPrimaryKey(
        long mcalId)
        throws com.ext.portlet.meetingcalendar.NoSuchendarException,
            com.liferay.portal.SystemException;

    public com.ext.portlet.meetingcalendar.model.MeetingCalendar fetchByPrimaryKey(
        long mcalId) throws com.liferay.portal.SystemException;

    public java.util.List<com.ext.portlet.meetingcalendar.model.MeetingCalendar> findByUuid(
        java.lang.String uuid) throws com.liferay.portal.SystemException;

    public java.util.List<com.ext.portlet.meetingcalendar.model.MeetingCalendar> findByUuid(
        java.lang.String uuid, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.ext.portlet.meetingcalendar.model.MeetingCalendar> findByUuid(
        java.lang.String uuid, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.ext.portlet.meetingcalendar.model.MeetingCalendar findByUuid_First(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.ext.portlet.meetingcalendar.NoSuchendarException,
            com.liferay.portal.SystemException;

    public com.ext.portlet.meetingcalendar.model.MeetingCalendar findByUuid_Last(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.ext.portlet.meetingcalendar.NoSuchendarException,
            com.liferay.portal.SystemException;

    public com.ext.portlet.meetingcalendar.model.MeetingCalendar[] findByUuid_PrevAndNext(
        long mcalId, java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.ext.portlet.meetingcalendar.NoSuchendarException,
            com.liferay.portal.SystemException;

    public com.ext.portlet.meetingcalendar.model.MeetingCalendar findByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.ext.portlet.meetingcalendar.NoSuchendarException,
            com.liferay.portal.SystemException;

    public com.ext.portlet.meetingcalendar.model.MeetingCalendar fetchByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.ext.portlet.meetingcalendar.model.MeetingCalendar> findByGroupId(
        long groupId) throws com.liferay.portal.SystemException;

    public java.util.List<com.ext.portlet.meetingcalendar.model.MeetingCalendar> findByGroupId(
        long groupId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.ext.portlet.meetingcalendar.model.MeetingCalendar> findByGroupId(
        long groupId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.ext.portlet.meetingcalendar.model.MeetingCalendar findByGroupId_First(
        long groupId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.ext.portlet.meetingcalendar.NoSuchendarException,
            com.liferay.portal.SystemException;

    public com.ext.portlet.meetingcalendar.model.MeetingCalendar findByGroupId_Last(
        long groupId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.ext.portlet.meetingcalendar.NoSuchendarException,
            com.liferay.portal.SystemException;

    public com.ext.portlet.meetingcalendar.model.MeetingCalendar[] findByGroupId_PrevAndNext(
        long mcalId, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.ext.portlet.meetingcalendar.NoSuchendarException,
            com.liferay.portal.SystemException;

    public java.util.List<com.ext.portlet.meetingcalendar.model.MeetingCalendar> findByG_State(
        long groupId, int state) throws com.liferay.portal.SystemException;

    public java.util.List<com.ext.portlet.meetingcalendar.model.MeetingCalendar> findByG_State(
        long groupId, int state, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.ext.portlet.meetingcalendar.model.MeetingCalendar> findByG_State(
        long groupId, int state, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.ext.portlet.meetingcalendar.model.MeetingCalendar findByG_State_First(
        long groupId, int state,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.ext.portlet.meetingcalendar.NoSuchendarException,
            com.liferay.portal.SystemException;

    public com.ext.portlet.meetingcalendar.model.MeetingCalendar findByG_State_Last(
        long groupId, int state,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.ext.portlet.meetingcalendar.NoSuchendarException,
            com.liferay.portal.SystemException;

    public com.ext.portlet.meetingcalendar.model.MeetingCalendar[] findByG_State_PrevAndNext(
        long mcalId, long groupId, int state,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.ext.portlet.meetingcalendar.NoSuchendarException,
            com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.ext.portlet.meetingcalendar.model.MeetingCalendar> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.ext.portlet.meetingcalendar.model.MeetingCalendar> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.ext.portlet.meetingcalendar.model.MeetingCalendar> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeByUuid(java.lang.String uuid)
        throws com.liferay.portal.SystemException;

    public void removeByUUID_G(java.lang.String uuid, long groupId)
        throws com.ext.portlet.meetingcalendar.NoSuchendarException,
            com.liferay.portal.SystemException;

    public void removeByGroupId(long groupId)
        throws com.liferay.portal.SystemException;

    public void removeByG_State(long groupId, int state)
        throws com.liferay.portal.SystemException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countByUuid(java.lang.String uuid)
        throws com.liferay.portal.SystemException;

    public int countByUUID_G(java.lang.String uuid, long groupId)
        throws com.liferay.portal.SystemException;

    public int countByGroupId(long groupId)
        throws com.liferay.portal.SystemException;

    public int countByG_State(long groupId, int state)
        throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;

    public void registerListener(
        com.liferay.portal.model.ModelListener listener);

    public void unregisterListener(
        com.liferay.portal.model.ModelListener listener);
}
