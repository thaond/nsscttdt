package com.ext.portlet.meetingcalendar.service.base;

import com.ext.portlet.meetingcalendar.service.MeetingCalComponentLocalService;
import com.ext.portlet.meetingcalendar.service.MeetingCalComponentService;
import com.ext.portlet.meetingcalendar.service.MeetingCalendarLocalService;
import com.ext.portlet.meetingcalendar.service.MeetingCalendarService;
import com.ext.portlet.meetingcalendar.service.MeetingDetailWeekLocalService;
import com.ext.portlet.meetingcalendar.service.MeetingDetailWeekService;
import com.ext.portlet.meetingcalendar.service.persistence.MeetingCalComponentFinder;
import com.ext.portlet.meetingcalendar.service.persistence.MeetingCalComponentPersistence;
import com.ext.portlet.meetingcalendar.service.persistence.MeetingCalendarFinder;
import com.ext.portlet.meetingcalendar.service.persistence.MeetingCalendarPersistence;
import com.ext.portlet.meetingcalendar.service.persistence.MeetingDetailWeekPersistence;

import com.liferay.counter.service.CounterLocalService;
import com.liferay.counter.service.CounterService;

import com.liferay.mail.service.MailService;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.service.CompanyLocalService;
import com.liferay.portal.service.CompanyService;
import com.liferay.portal.service.PortletPreferencesLocalService;
import com.liferay.portal.service.PortletPreferencesService;
import com.liferay.portal.service.ResourceLocalService;
import com.liferay.portal.service.ResourceService;
import com.liferay.portal.service.UserLocalService;
import com.liferay.portal.service.UserService;
import com.liferay.portal.service.base.PrincipalBean;
import com.liferay.portal.service.persistence.CompanyPersistence;
import com.liferay.portal.service.persistence.PortletPreferencesPersistence;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.calendar.service.CalEventLocalService;
import com.liferay.portlet.calendar.service.CalEventService;
import com.liferay.portlet.calendar.service.persistence.CalEventPersistence;
import com.liferay.portlet.social.service.SocialActivityLocalService;
import com.liferay.portlet.social.service.persistence.SocialActivityPersistence;


public abstract class MeetingCalendarServiceBaseImpl extends PrincipalBean
    implements MeetingCalendarService {
    @BeanReference(name = "com.ext.portlet.meetingcalendar.service.MeetingCalendarLocalService.impl")
    protected MeetingCalendarLocalService meetingCalendarLocalService;
    @BeanReference(name = "com.ext.portlet.meetingcalendar.service.MeetingCalendarService.impl")
    protected MeetingCalendarService meetingCalendarService;
    @BeanReference(name = "com.ext.portlet.meetingcalendar.service.persistence.MeetingCalendarPersistence.impl")
    protected MeetingCalendarPersistence meetingCalendarPersistence;
    @BeanReference(name = "com.ext.portlet.meetingcalendar.service.persistence.MeetingCalendarFinder.impl")
    protected MeetingCalendarFinder meetingCalendarFinder;
    @BeanReference(name = "com.ext.portlet.meetingcalendar.service.MeetingCalComponentLocalService.impl")
    protected MeetingCalComponentLocalService meetingCalComponentLocalService;
    @BeanReference(name = "com.ext.portlet.meetingcalendar.service.MeetingCalComponentService.impl")
    protected MeetingCalComponentService meetingCalComponentService;
    @BeanReference(name = "com.ext.portlet.meetingcalendar.service.persistence.MeetingCalComponentPersistence.impl")
    protected MeetingCalComponentPersistence meetingCalComponentPersistence;
    @BeanReference(name = "com.ext.portlet.meetingcalendar.service.persistence.MeetingCalComponentFinder.impl")
    protected MeetingCalComponentFinder meetingCalComponentFinder;
    @BeanReference(name = "com.ext.portlet.meetingcalendar.service.MeetingDetailWeekLocalService.impl")
    protected MeetingDetailWeekLocalService meetingDetailWeekLocalService;
    @BeanReference(name = "com.ext.portlet.meetingcalendar.service.MeetingDetailWeekService.impl")
    protected MeetingDetailWeekService meetingDetailWeekService;
    @BeanReference(name = "com.ext.portlet.meetingcalendar.service.persistence.MeetingDetailWeekPersistence.impl")
    protected MeetingDetailWeekPersistence meetingDetailWeekPersistence;
    @BeanReference(name = "com.liferay.counter.service.CounterLocalService.impl")
    protected CounterLocalService counterLocalService;
    @BeanReference(name = "com.liferay.counter.service.CounterService.impl")
    protected CounterService counterService;
    @BeanReference(name = "com.liferay.mail.service.MailService.impl")
    protected MailService mailService;
    @BeanReference(name = "com.liferay.portal.service.CompanyLocalService.impl")
    protected CompanyLocalService companyLocalService;
    @BeanReference(name = "com.liferay.portal.service.CompanyService.impl")
    protected CompanyService companyService;
    @BeanReference(name = "com.liferay.portal.service.persistence.CompanyPersistence.impl")
    protected CompanyPersistence companyPersistence;
    @BeanReference(name = "com.liferay.portal.service.PortletPreferencesLocalService.impl")
    protected PortletPreferencesLocalService portletPreferencesLocalService;
    @BeanReference(name = "com.liferay.portal.service.PortletPreferencesService.impl")
    protected PortletPreferencesService portletPreferencesService;
    @BeanReference(name = "com.liferay.portal.service.persistence.PortletPreferencesPersistence.impl")
    protected PortletPreferencesPersistence portletPreferencesPersistence;
    @BeanReference(name = "com.liferay.portal.service.ResourceLocalService.impl")
    protected ResourceLocalService resourceLocalService;
    @BeanReference(name = "com.liferay.portal.service.ResourceService.impl")
    protected ResourceService resourceService;
    @BeanReference(name = "com.liferay.portal.service.persistence.ResourcePersistence.impl")
    protected ResourcePersistence resourcePersistence;
    @BeanReference(name = "com.liferay.portlet.social.service.SocialActivityLocalService.impl")
    protected SocialActivityLocalService socialActivityLocalService;
    @BeanReference(name = "com.liferay.portlet.social.service.persistence.SocialActivityPersistence.impl")
    protected SocialActivityPersistence socialActivityPersistence;
    @BeanReference(name = "com.liferay.portal.service.UserLocalService.impl")
    protected UserLocalService userLocalService;
    @BeanReference(name = "com.liferay.portal.service.UserService.impl")
    protected UserService userService;
    @BeanReference(name = "com.liferay.portal.service.persistence.UserPersistence.impl")
    protected UserPersistence userPersistence;
    @BeanReference(name = "com.liferay.portlet.calendar.service.CalEventLocalService.impl")
    protected CalEventLocalService calEventLocalService;
    @BeanReference(name = "com.liferay.portlet.calendar.service.CalEventService.impl")
    protected CalEventService calEventService;
    @BeanReference(name = "com.liferay.portlet.calendar.service.persistence.CalEventPersistence.impl")
    protected CalEventPersistence calEventPersistence;

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

    public CounterLocalService getCounterLocalService() {
        return counterLocalService;
    }

    public void setCounterLocalService(CounterLocalService counterLocalService) {
        this.counterLocalService = counterLocalService;
    }

    public CounterService getCounterService() {
        return counterService;
    }

    public void setCounterService(CounterService counterService) {
        this.counterService = counterService;
    }

    public MailService getMailService() {
        return mailService;
    }

    public void setMailService(MailService mailService) {
        this.mailService = mailService;
    }

    public CompanyLocalService getCompanyLocalService() {
        return companyLocalService;
    }

    public void setCompanyLocalService(CompanyLocalService companyLocalService) {
        this.companyLocalService = companyLocalService;
    }

    public CompanyService getCompanyService() {
        return companyService;
    }

    public void setCompanyService(CompanyService companyService) {
        this.companyService = companyService;
    }

    public CompanyPersistence getCompanyPersistence() {
        return companyPersistence;
    }

    public void setCompanyPersistence(CompanyPersistence companyPersistence) {
        this.companyPersistence = companyPersistence;
    }

    public PortletPreferencesLocalService getPortletPreferencesLocalService() {
        return portletPreferencesLocalService;
    }

    public void setPortletPreferencesLocalService(
        PortletPreferencesLocalService portletPreferencesLocalService) {
        this.portletPreferencesLocalService = portletPreferencesLocalService;
    }

    public PortletPreferencesService getPortletPreferencesService() {
        return portletPreferencesService;
    }

    public void setPortletPreferencesService(
        PortletPreferencesService portletPreferencesService) {
        this.portletPreferencesService = portletPreferencesService;
    }

    public PortletPreferencesPersistence getPortletPreferencesPersistence() {
        return portletPreferencesPersistence;
    }

    public void setPortletPreferencesPersistence(
        PortletPreferencesPersistence portletPreferencesPersistence) {
        this.portletPreferencesPersistence = portletPreferencesPersistence;
    }

    public ResourceLocalService getResourceLocalService() {
        return resourceLocalService;
    }

    public void setResourceLocalService(
        ResourceLocalService resourceLocalService) {
        this.resourceLocalService = resourceLocalService;
    }

    public ResourceService getResourceService() {
        return resourceService;
    }

    public void setResourceService(ResourceService resourceService) {
        this.resourceService = resourceService;
    }

    public ResourcePersistence getResourcePersistence() {
        return resourcePersistence;
    }

    public void setResourcePersistence(ResourcePersistence resourcePersistence) {
        this.resourcePersistence = resourcePersistence;
    }

    public SocialActivityLocalService getSocialActivityLocalService() {
        return socialActivityLocalService;
    }

    public void setSocialActivityLocalService(
        SocialActivityLocalService socialActivityLocalService) {
        this.socialActivityLocalService = socialActivityLocalService;
    }

    public SocialActivityPersistence getSocialActivityPersistence() {
        return socialActivityPersistence;
    }

    public void setSocialActivityPersistence(
        SocialActivityPersistence socialActivityPersistence) {
        this.socialActivityPersistence = socialActivityPersistence;
    }

    public UserLocalService getUserLocalService() {
        return userLocalService;
    }

    public void setUserLocalService(UserLocalService userLocalService) {
        this.userLocalService = userLocalService;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public UserPersistence getUserPersistence() {
        return userPersistence;
    }

    public void setUserPersistence(UserPersistence userPersistence) {
        this.userPersistence = userPersistence;
    }

    public CalEventLocalService getCalEventLocalService() {
        return calEventLocalService;
    }

    public void setCalEventLocalService(
        CalEventLocalService calEventLocalService) {
        this.calEventLocalService = calEventLocalService;
    }

    public CalEventService getCalEventService() {
        return calEventService;
    }

    public void setCalEventService(CalEventService calEventService) {
        this.calEventService = calEventService;
    }

    public CalEventPersistence getCalEventPersistence() {
        return calEventPersistence;
    }

    public void setCalEventPersistence(CalEventPersistence calEventPersistence) {
        this.calEventPersistence = calEventPersistence;
    }

    protected void runSQL(String sql) throws SystemException {
        try {
            PortalUtil.runSQL(sql);
        } catch (Exception e) {
            throw new SystemException(e);
        }
    }
}
