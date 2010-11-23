package com.ext.portlet.meetingcalendar.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;


public interface MeetingDetailWeekPersistence extends BasePersistence {
    public void cacheResult(
        com.ext.portlet.meetingcalendar.model.MeetingDetailWeek meetingDetailWeek);

    public void cacheResult(
        java.util.List<com.ext.portlet.meetingcalendar.model.MeetingDetailWeek> meetingDetailWeeks);

    public void clearCache();

    public com.ext.portlet.meetingcalendar.model.MeetingDetailWeek create(
        long mdweekId);

    public com.ext.portlet.meetingcalendar.model.MeetingDetailWeek remove(
        long mdweekId)
        throws com.ext.portlet.meetingcalendar.NoSuchMeetingDetailWeekException,
            com.liferay.portal.SystemException;

    public com.ext.portlet.meetingcalendar.model.MeetingDetailWeek remove(
        com.ext.portlet.meetingcalendar.model.MeetingDetailWeek meetingDetailWeek)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(MeetingDetailWeek meetingDetailWeek, boolean merge)</code>.
     */
    public com.ext.portlet.meetingcalendar.model.MeetingDetailWeek update(
        com.ext.portlet.meetingcalendar.model.MeetingDetailWeek meetingDetailWeek)
        throws com.liferay.portal.SystemException;

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                meetingDetailWeek the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when meetingDetailWeek is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public com.ext.portlet.meetingcalendar.model.MeetingDetailWeek update(
        com.ext.portlet.meetingcalendar.model.MeetingDetailWeek meetingDetailWeek,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.ext.portlet.meetingcalendar.model.MeetingDetailWeek updateImpl(
        com.ext.portlet.meetingcalendar.model.MeetingDetailWeek meetingDetailWeek,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.ext.portlet.meetingcalendar.model.MeetingDetailWeek findByPrimaryKey(
        long mdweekId)
        throws com.ext.portlet.meetingcalendar.NoSuchMeetingDetailWeekException,
            com.liferay.portal.SystemException;

    public com.ext.portlet.meetingcalendar.model.MeetingDetailWeek fetchByPrimaryKey(
        long mdweekId) throws com.liferay.portal.SystemException;

    public com.ext.portlet.meetingcalendar.model.MeetingDetailWeek findBymdweekId(
        long mdweekId)
        throws com.ext.portlet.meetingcalendar.NoSuchMeetingDetailWeekException,
            com.liferay.portal.SystemException;

    public com.ext.portlet.meetingcalendar.model.MeetingDetailWeek fetchBymdweekId(
        long mdweekId) throws com.liferay.portal.SystemException;

    public com.ext.portlet.meetingcalendar.model.MeetingDetailWeek fetchBymdweekId(
        long mdweekId, boolean retrieveFromCache)
        throws com.liferay.portal.SystemException;

    public com.ext.portlet.meetingcalendar.model.MeetingDetailWeek findByW_Y(
        int week, int year)
        throws com.ext.portlet.meetingcalendar.NoSuchMeetingDetailWeekException,
            com.liferay.portal.SystemException;

    public com.ext.portlet.meetingcalendar.model.MeetingDetailWeek fetchByW_Y(
        int week, int year) throws com.liferay.portal.SystemException;

    public com.ext.portlet.meetingcalendar.model.MeetingDetailWeek fetchByW_Y(
        int week, int year, boolean retrieveFromCache)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.ext.portlet.meetingcalendar.model.MeetingDetailWeek> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.ext.portlet.meetingcalendar.model.MeetingDetailWeek> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.ext.portlet.meetingcalendar.model.MeetingDetailWeek> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeBymdweekId(long mdweekId)
        throws com.ext.portlet.meetingcalendar.NoSuchMeetingDetailWeekException,
            com.liferay.portal.SystemException;

    public void removeByW_Y(int week, int year)
        throws com.ext.portlet.meetingcalendar.NoSuchMeetingDetailWeekException,
            com.liferay.portal.SystemException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countBymdweekId(long mdweekId)
        throws com.liferay.portal.SystemException;

    public int countByW_Y(int week, int year)
        throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;
}
