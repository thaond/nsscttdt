package com.sgs.portlet.holiday_calendar.service.base;

import com.liferay.portal.service.base.PrincipalBean;

import com.sgs.portlet.holiday_calendar.service.AttactFileHolidayLocalService;
import com.sgs.portlet.holiday_calendar.service.AttactFileHolidayService;
import com.sgs.portlet.holiday_calendar.service.HolidayCalendarLocalService;
import com.sgs.portlet.holiday_calendar.service.HolidayCalendarService;
import com.sgs.portlet.holiday_calendar.service.persistence.AttactFileHolidayPersistence;
import com.sgs.portlet.holiday_calendar.service.persistence.HolidayCalendarFinder;
import com.sgs.portlet.holiday_calendar.service.persistence.HolidayCalendarPersistence;


public abstract class AttactFileHolidayServiceBaseImpl extends PrincipalBean
    implements AttactFileHolidayService {
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
