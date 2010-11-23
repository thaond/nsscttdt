package com.ext.portlet.meetingcalendar.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;


public interface MeetingCalComponentPersistence extends BasePersistence {
    public void cacheResult(
        com.ext.portlet.meetingcalendar.model.MeetingCalComponent meetingCalComponent);

    public void cacheResult(
        java.util.List<com.ext.portlet.meetingcalendar.model.MeetingCalComponent> meetingCalComponents);

    public void clearCache();

    public com.ext.portlet.meetingcalendar.model.MeetingCalComponent create(
        long mcalId);

    public com.ext.portlet.meetingcalendar.model.MeetingCalComponent remove(
        long mcalId)
        throws com.ext.portlet.meetingcalendar.NoSuchComponentException,
            com.liferay.portal.SystemException;

    public com.ext.portlet.meetingcalendar.model.MeetingCalComponent remove(
        com.ext.portlet.meetingcalendar.model.MeetingCalComponent meetingCalComponent)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(MeetingCalComponent meetingCalComponent, boolean merge)</code>.
     */
    public com.ext.portlet.meetingcalendar.model.MeetingCalComponent update(
        com.ext.portlet.meetingcalendar.model.MeetingCalComponent meetingCalComponent)
        throws com.liferay.portal.SystemException;

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                meetingCalComponent the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when meetingCalComponent is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public com.ext.portlet.meetingcalendar.model.MeetingCalComponent update(
        com.ext.portlet.meetingcalendar.model.MeetingCalComponent meetingCalComponent,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.ext.portlet.meetingcalendar.model.MeetingCalComponent updateImpl(
        com.ext.portlet.meetingcalendar.model.MeetingCalComponent meetingCalComponent,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.ext.portlet.meetingcalendar.model.MeetingCalComponent findByPrimaryKey(
        long mcalId)
        throws com.ext.portlet.meetingcalendar.NoSuchComponentException,
            com.liferay.portal.SystemException;

    public com.ext.portlet.meetingcalendar.model.MeetingCalComponent fetchByPrimaryKey(
        long mcalId) throws com.liferay.portal.SystemException;

    public com.ext.portlet.meetingcalendar.model.MeetingCalComponent findBymcalId(
        long mcalId)
        throws com.ext.portlet.meetingcalendar.NoSuchComponentException,
            com.liferay.portal.SystemException;

    public com.ext.portlet.meetingcalendar.model.MeetingCalComponent fetchBymcalId(
        long mcalId) throws com.liferay.portal.SystemException;

    public com.ext.portlet.meetingcalendar.model.MeetingCalComponent fetchBymcalId(
        long mcalId, boolean retrieveFromCache)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.ext.portlet.meetingcalendar.model.MeetingCalComponent> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.ext.portlet.meetingcalendar.model.MeetingCalComponent> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.ext.portlet.meetingcalendar.model.MeetingCalComponent> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeBymcalId(long mcalId)
        throws com.ext.portlet.meetingcalendar.NoSuchComponentException,
            com.liferay.portal.SystemException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countBymcalId(long mcalId)
        throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;
}
