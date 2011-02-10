package com.sgs.portlet.holiday.service.base;

import com.liferay.portal.service.base.PrincipalBean;

import com.sgs.portlet.holiday.service.PmlHolidayLocalService;
import com.sgs.portlet.holiday.service.PmlHolidayService;
import com.sgs.portlet.holiday.service.persistence.PmlHolidayFinder;
import com.sgs.portlet.holiday.service.persistence.PmlHolidayPersistence;


public abstract class PmlHolidayServiceBaseImpl extends PrincipalBean
    implements PmlHolidayService {
    @javax.annotation.Resource(name = "com.sgs.portlet.holiday.service.PmlHolidayLocalService.impl")
    protected PmlHolidayLocalService pmlHolidayLocalService;
    @javax.annotation.Resource(name = "com.sgs.portlet.holiday.service.PmlHolidayService.impl")
    protected PmlHolidayService pmlHolidayService;
    @javax.annotation.Resource(name = "com.sgs.portlet.holiday.service.persistence.PmlHolidayPersistence.impl")
    protected PmlHolidayPersistence pmlHolidayPersistence;
    @javax.annotation.Resource(name = "com.sgs.portlet.holiday.service.persistence.PmlHolidayFinder.impl")
    protected PmlHolidayFinder pmlHolidayFinder;

    public PmlHolidayLocalService getPmlHolidayLocalService() {
        return pmlHolidayLocalService;
    }

    public void setPmlHolidayLocalService(
        PmlHolidayLocalService pmlHolidayLocalService) {
        this.pmlHolidayLocalService = pmlHolidayLocalService;
    }

    public PmlHolidayService getPmlHolidayService() {
        return pmlHolidayService;
    }

    public void setPmlHolidayService(PmlHolidayService pmlHolidayService) {
        this.pmlHolidayService = pmlHolidayService;
    }

    public PmlHolidayPersistence getPmlHolidayPersistence() {
        return pmlHolidayPersistence;
    }

    public void setPmlHolidayPersistence(
        PmlHolidayPersistence pmlHolidayPersistence) {
        this.pmlHolidayPersistence = pmlHolidayPersistence;
    }

    public PmlHolidayFinder getPmlHolidayFinder() {
        return pmlHolidayFinder;
    }

    public void setPmlHolidayFinder(PmlHolidayFinder pmlHolidayFinder) {
        this.pmlHolidayFinder = pmlHolidayFinder;
    }
}
