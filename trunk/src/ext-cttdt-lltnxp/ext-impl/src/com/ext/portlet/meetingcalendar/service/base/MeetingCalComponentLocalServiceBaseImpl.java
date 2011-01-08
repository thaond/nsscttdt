package com.ext.portlet.meetingcalendar.service.base;

import com.ext.portlet.meetingcalendar.model.MeetingCalComponent;
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

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.service.CompanyLocalService;
import com.liferay.portal.service.CompanyService;
import com.liferay.portal.service.OrganizationLocalService;
import com.liferay.portal.service.OrganizationService;
import com.liferay.portal.service.PortletPreferencesLocalService;
import com.liferay.portal.service.PortletPreferencesService;
import com.liferay.portal.service.ResourceLocalService;
import com.liferay.portal.service.ResourceService;
import com.liferay.portal.service.UserLocalService;
import com.liferay.portal.service.UserService;
import com.liferay.portal.service.persistence.CompanyPersistence;
import com.liferay.portal.service.persistence.OrganizationPersistence;
import com.liferay.portal.service.persistence.PortletPreferencesPersistence;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;

import com.liferay.portlet.calendar.service.CalEventLocalService;
import com.liferay.portlet.calendar.service.CalEventService;
import com.liferay.portlet.calendar.service.persistence.CalEventPersistence;
import com.liferay.portlet.social.service.SocialActivityLocalService;
import com.liferay.portlet.social.service.persistence.SocialActivityPersistence;

import java.util.List;


public abstract class MeetingCalComponentLocalServiceBaseImpl
    implements MeetingCalComponentLocalService {
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
    @javax.annotation.Resource(name = "com.liferay.counter.service.CounterLocalService.impl")
    protected CounterLocalService counterLocalService;
    @javax.annotation.Resource(name = "com.liferay.counter.service.CounterService.impl")
    protected CounterService counterService;
    @javax.annotation.Resource(name = "com.liferay.mail.service.MailService.impl")
    protected MailService mailService;
    @javax.annotation.Resource(name = "com.liferay.portal.service.CompanyLocalService.impl")
    protected CompanyLocalService companyLocalService;
    @javax.annotation.Resource(name = "com.liferay.portal.service.CompanyService.impl")
    protected CompanyService companyService;
    @javax.annotation.Resource(name = "com.liferay.portal.service.persistence.CompanyPersistence.impl")
    protected CompanyPersistence companyPersistence;
    @javax.annotation.Resource(name = "com.liferay.portal.service.PortletPreferencesLocalService.impl")
    protected PortletPreferencesLocalService portletPreferencesLocalService;
    @javax.annotation.Resource(name = "com.liferay.portal.service.PortletPreferencesService.impl")
    protected PortletPreferencesService portletPreferencesService;
    @javax.annotation.Resource(name = "com.liferay.portal.service.persistence.PortletPreferencesPersistence.impl")
    protected PortletPreferencesPersistence portletPreferencesPersistence;
    @javax.annotation.Resource(name = "com.liferay.portal.service.ResourceLocalService.impl")
    protected ResourceLocalService resourceLocalService;
    @javax.annotation.Resource(name = "com.liferay.portal.service.ResourceService.impl")
    protected ResourceService resourceService;
    @javax.annotation.Resource(name = "com.liferay.portal.service.persistence.ResourcePersistence.impl")
    protected ResourcePersistence resourcePersistence;
    @javax.annotation.Resource(name = "com.liferay.portlet.social.service.SocialActivityLocalService.impl")
    protected SocialActivityLocalService socialActivityLocalService;
    @javax.annotation.Resource(name = "com.liferay.portlet.social.service.persistence.SocialActivityPersistence.impl")
    protected SocialActivityPersistence socialActivityPersistence;
    @javax.annotation.Resource(name = "com.liferay.portal.service.UserLocalService.impl")
    protected UserLocalService userLocalService;
    @javax.annotation.Resource(name = "com.liferay.portal.service.UserService.impl")
    protected UserService userService;
    @javax.annotation.Resource(name = "com.liferay.portal.service.persistence.UserPersistence.impl")
    protected UserPersistence userPersistence;
    @javax.annotation.Resource(name = "com.liferay.portlet.calendar.service.CalEventLocalService.impl")
    protected CalEventLocalService calEventLocalService;
    @javax.annotation.Resource(name = "com.liferay.portlet.calendar.service.CalEventService.impl")
    protected CalEventService calEventService;
    @javax.annotation.Resource(name = "com.liferay.portlet.calendar.service.persistence.CalEventPersistence.impl")
    protected CalEventPersistence calEventPersistence;
    @javax.annotation.Resource(name = "com.liferay.portal.service.OrganizationLocalService.impl")
    protected OrganizationLocalService organizationLocalService;
    @javax.annotation.Resource(name = "com.liferay.portal.service.OrganizationService.impl")
    protected OrganizationService organizationService;
    @javax.annotation.Resource(name = "com.liferay.portal.service.persistence.OrganizationPersistence.impl")
    protected OrganizationPersistence organizationPersistence;

    public MeetingCalComponent addMeetingCalComponent(
        MeetingCalComponent meetingCalComponent) throws SystemException {
        meetingCalComponent.setNew(true);

        return meetingCalComponentPersistence.update(meetingCalComponent, false);
    }

    public MeetingCalComponent createMeetingCalComponent(long mcalId) {
        return meetingCalComponentPersistence.create(mcalId);
    }

    public void deleteMeetingCalComponent(long mcalId)
        throws PortalException, SystemException {
        meetingCalComponentPersistence.remove(mcalId);
    }

    public void deleteMeetingCalComponent(
        MeetingCalComponent meetingCalComponent) throws SystemException {
        meetingCalComponentPersistence.remove(meetingCalComponent);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return meetingCalComponentPersistence.findWithDynamicQuery(dynamicQuery);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery, int start,
        int end) throws SystemException {
        return meetingCalComponentPersistence.findWithDynamicQuery(dynamicQuery,
            start, end);
    }

    public MeetingCalComponent getMeetingCalComponent(long mcalId)
        throws PortalException, SystemException {
        return meetingCalComponentPersistence.findByPrimaryKey(mcalId);
    }

    public List<MeetingCalComponent> getMeetingCalComponents(int start, int end)
        throws SystemException {
        return meetingCalComponentPersistence.findAll(start, end);
    }

    public int getMeetingCalComponentsCount() throws SystemException {
        return meetingCalComponentPersistence.countAll();
    }

    public MeetingCalComponent updateMeetingCalComponent(
        MeetingCalComponent meetingCalComponent) throws SystemException {
        meetingCalComponent.setNew(false);

        return meetingCalComponentPersistence.update(meetingCalComponent, true);
    }

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

    public OrganizationLocalService getOrganizationLocalService() {
        return organizationLocalService;
    }

    public void setOrganizationLocalService(
        OrganizationLocalService organizationLocalService) {
        this.organizationLocalService = organizationLocalService;
    }

    public OrganizationService getOrganizationService() {
        return organizationService;
    }

    public void setOrganizationService(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    public OrganizationPersistence getOrganizationPersistence() {
        return organizationPersistence;
    }

    public void setOrganizationPersistence(
        OrganizationPersistence organizationPersistence) {
        this.organizationPersistence = organizationPersistence;
    }
}
