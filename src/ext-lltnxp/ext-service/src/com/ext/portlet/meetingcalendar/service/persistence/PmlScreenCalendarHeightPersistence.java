package com.ext.portlet.meetingcalendar.service.persistence;

public interface PmlScreenCalendarHeightPersistence {
    public com.ext.portlet.meetingcalendar.model.PmlScreenCalendarHeight create(
        long screenCalendarHeightId);

    public com.ext.portlet.meetingcalendar.model.PmlScreenCalendarHeight remove(
        long screenCalendarHeightId)
        throws com.ext.portlet.meetingcalendar.NoSuchPmlScreenCalendarHeightException,
            com.liferay.portal.SystemException;

    public com.ext.portlet.meetingcalendar.model.PmlScreenCalendarHeight remove(
        com.ext.portlet.meetingcalendar.model.PmlScreenCalendarHeight pmlScreenCalendarHeight)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(PmlScreenCalendarHeight pmlScreenCalendarHeight, boolean merge)</code>.
     */
    public com.ext.portlet.meetingcalendar.model.PmlScreenCalendarHeight update(
        com.ext.portlet.meetingcalendar.model.PmlScreenCalendarHeight pmlScreenCalendarHeight)
        throws com.liferay.portal.SystemException;

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlScreenCalendarHeight the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlScreenCalendarHeight is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public com.ext.portlet.meetingcalendar.model.PmlScreenCalendarHeight update(
        com.ext.portlet.meetingcalendar.model.PmlScreenCalendarHeight pmlScreenCalendarHeight,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.ext.portlet.meetingcalendar.model.PmlScreenCalendarHeight updateImpl(
        com.ext.portlet.meetingcalendar.model.PmlScreenCalendarHeight pmlScreenCalendarHeight,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.ext.portlet.meetingcalendar.model.PmlScreenCalendarHeight findByPrimaryKey(
        long screenCalendarHeightId)
        throws com.ext.portlet.meetingcalendar.NoSuchPmlScreenCalendarHeightException,
            com.liferay.portal.SystemException;

    public com.ext.portlet.meetingcalendar.model.PmlScreenCalendarHeight fetchByPrimaryKey(
        long screenCalendarHeightId) throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.ext.portlet.meetingcalendar.model.PmlScreenCalendarHeight> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.ext.portlet.meetingcalendar.model.PmlScreenCalendarHeight> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.ext.portlet.meetingcalendar.model.PmlScreenCalendarHeight> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;

    public void registerListener(
        com.liferay.portal.model.ModelListener listener);

    public void unregisterListener(
        com.liferay.portal.model.ModelListener listener);
}
