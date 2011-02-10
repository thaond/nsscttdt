package com.sgs.portlet.holiday_calendar.service.base;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;

import com.sgs.portlet.holiday_calendar.model.AttactFileHoliday;
import com.sgs.portlet.holiday_calendar.service.AttactFileHolidayLocalService;
import com.sgs.portlet.holiday_calendar.service.AttactFileHolidayService;
import com.sgs.portlet.holiday_calendar.service.HolidayCalendarLocalService;
import com.sgs.portlet.holiday_calendar.service.HolidayCalendarService;
import com.sgs.portlet.holiday_calendar.service.persistence.AttactFileHolidayPersistence;
import com.sgs.portlet.holiday_calendar.service.persistence.HolidayCalendarFinder;
import com.sgs.portlet.holiday_calendar.service.persistence.HolidayCalendarPersistence;

import java.util.List;


public abstract class AttactFileHolidayLocalServiceBaseImpl
    implements AttactFileHolidayLocalService {
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

    public AttactFileHoliday addAttactFileHoliday(
        AttactFileHoliday attactFileHoliday) throws SystemException {
        attactFileHoliday.setNew(true);

        return attactFileHolidayPersistence.update(attactFileHoliday, false);
    }

    public AttactFileHoliday createAttactFileHoliday(long attactFileHolidayId) {
        return attactFileHolidayPersistence.create(attactFileHolidayId);
    }

    public void deleteAttactFileHoliday(long attactFileHolidayId)
        throws PortalException, SystemException {
        attactFileHolidayPersistence.remove(attactFileHolidayId);
    }

    public void deleteAttactFileHoliday(AttactFileHoliday attactFileHoliday)
        throws SystemException {
        attactFileHolidayPersistence.remove(attactFileHoliday);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return attactFileHolidayPersistence.findWithDynamicQuery(dynamicQuery);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery, int start,
        int end) throws SystemException {
        return attactFileHolidayPersistence.findWithDynamicQuery(dynamicQuery,
            start, end);
    }

    public AttactFileHoliday getAttactFileHoliday(long attactFileHolidayId)
        throws PortalException, SystemException {
        return attactFileHolidayPersistence.findByPrimaryKey(attactFileHolidayId);
    }

    public List<AttactFileHoliday> getAttactFileHolidaies(int start, int end)
        throws SystemException {
        return attactFileHolidayPersistence.findAll(start, end);
    }

    public int getAttactFileHolidaiesCount() throws SystemException {
        return attactFileHolidayPersistence.countAll();
    }

    public AttactFileHoliday updateAttactFileHoliday(
        AttactFileHoliday attactFileHoliday) throws SystemException {
        attactFileHoliday.setNew(false);

        return attactFileHolidayPersistence.update(attactFileHoliday, true);
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
