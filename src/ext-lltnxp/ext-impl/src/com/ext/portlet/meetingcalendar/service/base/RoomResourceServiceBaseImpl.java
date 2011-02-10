package com.ext.portlet.meetingcalendar.service.base;

import com.ext.portlet.meetingcalendar.service.CarResourceLocalService;
import com.ext.portlet.meetingcalendar.service.CarResourceService;
import com.ext.portlet.meetingcalendar.service.MeetingCalComponentLocalService;
import com.ext.portlet.meetingcalendar.service.MeetingCalComponentService;
import com.ext.portlet.meetingcalendar.service.MeetingCalendarLocalService;
import com.ext.portlet.meetingcalendar.service.MeetingCalendarService;
import com.ext.portlet.meetingcalendar.service.MeetingDetailWeekLocalService;
import com.ext.portlet.meetingcalendar.service.MeetingDetailWeekService;
import com.ext.portlet.meetingcalendar.service.PmlScreenCalendarHeightLocalService;
import com.ext.portlet.meetingcalendar.service.PmlScreenCalendarHeightService;
import com.ext.portlet.meetingcalendar.service.RoomResourceLocalService;
import com.ext.portlet.meetingcalendar.service.RoomResourceService;
import com.ext.portlet.meetingcalendar.service.persistence.CarResourcePersistence;
import com.ext.portlet.meetingcalendar.service.persistence.MeetingCalComponentFinder;
import com.ext.portlet.meetingcalendar.service.persistence.MeetingCalComponentPersistence;
import com.ext.portlet.meetingcalendar.service.persistence.MeetingCalendarFinder;
import com.ext.portlet.meetingcalendar.service.persistence.MeetingCalendarPersistence;
import com.ext.portlet.meetingcalendar.service.persistence.MeetingDetailWeekPersistence;
import com.ext.portlet.meetingcalendar.service.persistence.PmlScreenCalendarHeightPersistence;
import com.ext.portlet.meetingcalendar.service.persistence.RoomResourcePersistence;

import com.liferay.portal.service.base.PrincipalBean;


public abstract class RoomResourceServiceBaseImpl extends PrincipalBean
    implements RoomResourceService {
    @javax.annotation.Resource(name = "com.ext.portlet.meetingcalendar.service.MeetingCalendarLocalService.impl")
    protected MeetingCalendarLocalService meetingCalendarLocalService;
    @javax.annotation.Resource(name = "com.ext.portlet.meetingcalendar.service.MeetingCalendarService.impl")
    protected MeetingCalendarService meetingCalendarService;
    @javax.annotation.Resource(name = "com.ext.portlet.meetingcalendar.service.persistence.MeetingCalendarPersistence.impl")
    protected MeetingCalendarPersistence meetingCalendarPersistence;
    @javax.annotation.Resource(name = "com.ext.portlet.meetingcalendar.service.persistence.MeetingCalendarFinder.impl")
    protected MeetingCalendarFinder meetingCalendarFinder;
    @javax.annotation.Resource(name = "com.ext.portlet.meetingcalendar.service.MeetingCalComponentLocalService.impl")
    protected MeetingCalComponentLocalService meetingCalComponentLocalService;
    @javax.annotation.Resource(name = "com.ext.portlet.meetingcalendar.service.MeetingCalComponentService.impl")
    protected MeetingCalComponentService meetingCalComponentService;
    @javax.annotation.Resource(name = "com.ext.portlet.meetingcalendar.service.persistence.MeetingCalComponentPersistence.impl")
    protected MeetingCalComponentPersistence meetingCalComponentPersistence;
    @javax.annotation.Resource(name = "com.ext.portlet.meetingcalendar.service.persistence.MeetingCalComponentFinder.impl")
    protected MeetingCalComponentFinder meetingCalComponentFinder;
    @javax.annotation.Resource(name = "com.ext.portlet.meetingcalendar.service.MeetingDetailWeekLocalService.impl")
    protected MeetingDetailWeekLocalService meetingDetailWeekLocalService;
    @javax.annotation.Resource(name = "com.ext.portlet.meetingcalendar.service.MeetingDetailWeekService.impl")
    protected MeetingDetailWeekService meetingDetailWeekService;
    @javax.annotation.Resource(name = "com.ext.portlet.meetingcalendar.service.persistence.MeetingDetailWeekPersistence.impl")
    protected MeetingDetailWeekPersistence meetingDetailWeekPersistence;
    @javax.annotation.Resource(name = "com.ext.portlet.meetingcalendar.service.PmlScreenCalendarHeightLocalService.impl")
    protected PmlScreenCalendarHeightLocalService pmlScreenCalendarHeightLocalService;
    @javax.annotation.Resource(name = "com.ext.portlet.meetingcalendar.service.PmlScreenCalendarHeightService.impl")
    protected PmlScreenCalendarHeightService pmlScreenCalendarHeightService;
    @javax.annotation.Resource(name = "com.ext.portlet.meetingcalendar.service.persistence.PmlScreenCalendarHeightPersistence.impl")
    protected PmlScreenCalendarHeightPersistence pmlScreenCalendarHeightPersistence;
    @javax.annotation.Resource(name = "com.ext.portlet.meetingcalendar.service.RoomResourceLocalService.impl")
    protected RoomResourceLocalService roomResourceLocalService;
    @javax.annotation.Resource(name = "com.ext.portlet.meetingcalendar.service.RoomResourceService.impl")
    protected RoomResourceService roomResourceService;
    @javax.annotation.Resource(name = "com.ext.portlet.meetingcalendar.service.persistence.RoomResourcePersistence.impl")
    protected RoomResourcePersistence roomResourcePersistence;
    @javax.annotation.Resource(name = "com.ext.portlet.meetingcalendar.service.CarResourceLocalService.impl")
    protected CarResourceLocalService carResourceLocalService;
    @javax.annotation.Resource(name = "com.ext.portlet.meetingcalendar.service.CarResourceService.impl")
    protected CarResourceService carResourceService;
    @javax.annotation.Resource(name = "com.ext.portlet.meetingcalendar.service.persistence.CarResourcePersistence.impl")
    protected CarResourcePersistence carResourcePersistence;

    public MeetingCalendarLocalService getMeetingCalendarLocalService() {
        return meetingCalendarLocalService;
    }

    public void setMeetingCalendarLocalService(
        MeetingCalendarLocalService meetingCalendarLocalService) {
        this.meetingCalendarLocalService = meetingCalendarLocalService;
    }

    public MeetingCalendarService getMeetingCalendarService() {
        return meetingCalendarService;
    }

    public void setMeetingCalendarService(
        MeetingCalendarService meetingCalendarService) {
        this.meetingCalendarService = meetingCalendarService;
    }

    public MeetingCalendarPersistence getMeetingCalendarPersistence() {
        return meetingCalendarPersistence;
    }

    public void setMeetingCalendarPersistence(
        MeetingCalendarPersistence meetingCalendarPersistence) {
        this.meetingCalendarPersistence = meetingCalendarPersistence;
    }

    public MeetingCalendarFinder getMeetingCalendarFinder() {
        return meetingCalendarFinder;
    }

    public void setMeetingCalendarFinder(
        MeetingCalendarFinder meetingCalendarFinder) {
        this.meetingCalendarFinder = meetingCalendarFinder;
    }

    public MeetingCalComponentLocalService getMeetingCalComponentLocalService() {
        return meetingCalComponentLocalService;
    }

    public void setMeetingCalComponentLocalService(
        MeetingCalComponentLocalService meetingCalComponentLocalService) {
        this.meetingCalComponentLocalService = meetingCalComponentLocalService;
    }

    public MeetingCalComponentService getMeetingCalComponentService() {
        return meetingCalComponentService;
    }

    public void setMeetingCalComponentService(
        MeetingCalComponentService meetingCalComponentService) {
        this.meetingCalComponentService = meetingCalComponentService;
    }

    public MeetingCalComponentPersistence getMeetingCalComponentPersistence() {
        return meetingCalComponentPersistence;
    }

    public void setMeetingCalComponentPersistence(
        MeetingCalComponentPersistence meetingCalComponentPersistence) {
        this.meetingCalComponentPersistence = meetingCalComponentPersistence;
    }

    public MeetingCalComponentFinder getMeetingCalComponentFinder() {
        return meetingCalComponentFinder;
    }

    public void setMeetingCalComponentFinder(
        MeetingCalComponentFinder meetingCalComponentFinder) {
        this.meetingCalComponentFinder = meetingCalComponentFinder;
    }

    public MeetingDetailWeekLocalService getMeetingDetailWeekLocalService() {
        return meetingDetailWeekLocalService;
    }

    public void setMeetingDetailWeekLocalService(
        MeetingDetailWeekLocalService meetingDetailWeekLocalService) {
        this.meetingDetailWeekLocalService = meetingDetailWeekLocalService;
    }

    public MeetingDetailWeekService getMeetingDetailWeekService() {
        return meetingDetailWeekService;
    }

    public void setMeetingDetailWeekService(
        MeetingDetailWeekService meetingDetailWeekService) {
        this.meetingDetailWeekService = meetingDetailWeekService;
    }

    public MeetingDetailWeekPersistence getMeetingDetailWeekPersistence() {
        return meetingDetailWeekPersistence;
    }

    public void setMeetingDetailWeekPersistence(
        MeetingDetailWeekPersistence meetingDetailWeekPersistence) {
        this.meetingDetailWeekPersistence = meetingDetailWeekPersistence;
    }

    public PmlScreenCalendarHeightLocalService getPmlScreenCalendarHeightLocalService() {
        return pmlScreenCalendarHeightLocalService;
    }

    public void setPmlScreenCalendarHeightLocalService(
        PmlScreenCalendarHeightLocalService pmlScreenCalendarHeightLocalService) {
        this.pmlScreenCalendarHeightLocalService = pmlScreenCalendarHeightLocalService;
    }

    public PmlScreenCalendarHeightService getPmlScreenCalendarHeightService() {
        return pmlScreenCalendarHeightService;
    }

    public void setPmlScreenCalendarHeightService(
        PmlScreenCalendarHeightService pmlScreenCalendarHeightService) {
        this.pmlScreenCalendarHeightService = pmlScreenCalendarHeightService;
    }

    public PmlScreenCalendarHeightPersistence getPmlScreenCalendarHeightPersistence() {
        return pmlScreenCalendarHeightPersistence;
    }

    public void setPmlScreenCalendarHeightPersistence(
        PmlScreenCalendarHeightPersistence pmlScreenCalendarHeightPersistence) {
        this.pmlScreenCalendarHeightPersistence = pmlScreenCalendarHeightPersistence;
    }

    public RoomResourceLocalService getRoomResourceLocalService() {
        return roomResourceLocalService;
    }

    public void setRoomResourceLocalService(
        RoomResourceLocalService roomResourceLocalService) {
        this.roomResourceLocalService = roomResourceLocalService;
    }

    public RoomResourceService getRoomResourceService() {
        return roomResourceService;
    }

    public void setRoomResourceService(RoomResourceService roomResourceService) {
        this.roomResourceService = roomResourceService;
    }

    public RoomResourcePersistence getRoomResourcePersistence() {
        return roomResourcePersistence;
    }

    public void setRoomResourcePersistence(
        RoomResourcePersistence roomResourcePersistence) {
        this.roomResourcePersistence = roomResourcePersistence;
    }

    public CarResourceLocalService getCarResourceLocalService() {
        return carResourceLocalService;
    }

    public void setCarResourceLocalService(
        CarResourceLocalService carResourceLocalService) {
        this.carResourceLocalService = carResourceLocalService;
    }

    public CarResourceService getCarResourceService() {
        return carResourceService;
    }

    public void setCarResourceService(CarResourceService carResourceService) {
        this.carResourceService = carResourceService;
    }

    public CarResourcePersistence getCarResourcePersistence() {
        return carResourcePersistence;
    }

    public void setCarResourcePersistence(
        CarResourcePersistence carResourcePersistence) {
        this.carResourcePersistence = carResourcePersistence;
    }
}
