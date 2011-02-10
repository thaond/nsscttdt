package com.sgs.portlet.holiday_calendar.service.base;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;

import com.sgs.portlet.holiday_calendar.model.HolidayCalendar;
import com.sgs.portlet.holiday_calendar.service.AttactFileHolidayLocalService;
import com.sgs.portlet.holiday_calendar.service.AttactFileHolidayService;
import com.sgs.portlet.holiday_calendar.service.HolidayCalendarLocalService;
import com.sgs.portlet.holiday_calendar.service.HolidayCalendarService;
import com.sgs.portlet.holiday_calendar.service.persistence.AttactFileHolidayPersistence;
import com.sgs.portlet.holiday_calendar.service.persistence.HolidayCalendarFinder;
import com.sgs.portlet.holiday_calendar.service.persistence.HolidayCalendarPersistence;

import java.util.List;


public abstract class HolidayCalendarLocalServiceBaseImpl
    implements HolidayCalendarLocalService {
    @javax.annotation.Resource(name = "com.sgs.portlet.holiday_calendar.service.HolidayCalendarLocalService.impl")
    protected HolidayCalendarLocalService holidayCalendarLocalService;
    @javax.annotation.Resource(name = "com.sgs.portlet.holiday_calendar.service.HolidayCalendarService.impl")
    protected HolidayCalendarService holidayCalendarService;
    @javax.annotation.Resource(name = "com.sgs.portlet.holiday_calendar.service.persistence.HolidayCalendarPersistence.impl")
    protected HolidayCalendarPersistence holidayCalendarPersistence;
    @javax.annotation.Resource(name = "com.sgs.portlet.holiday_calendar.service.persistence.HolidayCalendarFinder.impl")
    protected HolidayCalendarFinder holidayCalendarFinder;
    @javax.annotation.Resource(name = "com.sgs.portlet.holiday_calendar.service.AttactFileHolidayLocalService.impl")
    protected AttactFileHolidayLocalService attactFileHolidayLocalService;
    @javax.annotation.Resource(name = "com.sgs.portlet.holiday_calendar.service.AttactFileHolidayService.impl")
    protected AttactFileHolidayService attactFileHolidayService;
    @javax.annotation.Resource(name = "com.sgs.portlet.holiday_calendar.service.persistence.AttactFileHolidayPersistence.impl")
    protected AttactFileHolidayPersistence attactFileHolidayPersistence;

    public HolidayCalendar addHolidayCalendar(HolidayCalendar holidayCalendar)
        throws SystemException {
        holidayCalendar.setNew(true);

        return holidayCalendarPersistence.update(holidayCalendar, false);
    }

    public HolidayCalendar createHolidayCalendar(long holidayCalendarId) {
        return holidayCalendarPersistence.create(holidayCalendarId);
    }

    public void deleteHolidayCalendar(long holidayCalendarId)
        throws PortalException, SystemException {
        holidayCalendarPersistence.remove(holidayCalendarId);
    }

    public void deleteHolidayCalendar(HolidayCalendar holidayCalendar)
        throws SystemException {
        holidayCalendarPersistence.remove(holidayCalendar);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return holidayCalendarPersistence.findWithDynamicQuery(dynamicQuery);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery, int start,
        int end) throws SystemException {
        return holidayCalendarPersistence.findWithDynamicQuery(dynamicQuery,
            start, end);
    }

    public HolidayCalendar getHolidayCalendar(long holidayCalendarId)
        throws PortalException, SystemException {
        return holidayCalendarPersistence.findByPrimaryKey(holidayCalendarId);
    }

    public List<HolidayCalendar> getHolidayCalendars(int start, int end)
        throws SystemException {
        return holidayCalendarPersistence.findAll(start, end);
    }

    public int getHolidayCalendarsCount() throws SystemException {
        return holidayCalendarPersistence.countAll();
    }

    public HolidayCalendar updateHolidayCalendar(
        HolidayCalendar holidayCalendar) throws SystemException {
        holidayCalendar.setNew(false);

        return holidayCalendarPersistence.update(holidayCalendar, true);
    }

    public HolidayCalendarLocalService getHolidayCalendarLocalService() {
        return holidayCalendarLocalService;
    }

    public void setHolidayCalendarLocalService(
        HolidayCalendarLocalService holidayCalendarLocalService) {
        this.holidayCalendarLocalService = holidayCalendarLocalService;
    }

    public HolidayCalendarService getHolidayCalendarService() {
        return holidayCalendarService;
    }

    public void setHolidayCalendarService(
        HolidayCalendarService holidayCalendarService) {
        this.holidayCalendarService = holidayCalendarService;
    }

    public HolidayCalendarPersistence getHolidayCalendarPersistence() {
        return holidayCalendarPersistence;
    }

    public void setHolidayCalendarPersistence(
        HolidayCalendarPersistence holidayCalendarPersistence) {
        this.holidayCalendarPersistence = holidayCalendarPersistence;
    }

    public HolidayCalendarFinder getHolidayCalendarFinder() {
        return holidayCalendarFinder;
    }

    public void setHolidayCalendarFinder(
        HolidayCalendarFinder holidayCalendarFinder) {
        this.holidayCalendarFinder = holidayCalendarFinder;
    }

    public AttactFileHolidayLocalService getAttactFileHolidayLocalService() {
        return attactFileHolidayLocalService;
    }

    public void setAttactFileHolidayLocalService(
        AttactFileHolidayLocalService attactFileHolidayLocalService) {
        this.attactFileHolidayLocalService = attactFileHolidayLocalService;
    }

    public AttactFileHolidayService getAttactFileHolidayService() {
        return attactFileHolidayService;
    }

    public void setAttactFileHolidayService(
        AttactFileHolidayService attactFileHolidayService) {
        this.attactFileHolidayService = attactFileHolidayService;
    }

    public AttactFileHolidayPersistence getAttactFileHolidayPersistence() {
        return attactFileHolidayPersistence;
    }

    public void setAttactFileHolidayPersistence(
        AttactFileHolidayPersistence attactFileHolidayPersistence) {
        this.attactFileHolidayPersistence = attactFileHolidayPersistence;
    }
}
