package com.sgs.portlet.agency.service.base;

import com.liferay.portal.service.base.PrincipalBean;

import com.sgs.portlet.agency.service.AgencyLocalService;
import com.sgs.portlet.agency.service.AgencyService;
import com.sgs.portlet.agency.service.persistence.AgencyFinder;
import com.sgs.portlet.agency.service.persistence.AgencyPersistence;


public abstract class AgencyServiceBaseImpl extends PrincipalBean
    implements AgencyService {
    @javax.annotation.Resource(name = "com.sgs.portlet.agency.service.AgencyLocalService.impl")
    protected AgencyLocalService agencyLocalService;
    @javax.annotation.Resource(name = "com.sgs.portlet.agency.service.AgencyService.impl")
    protected AgencyService agencyService;
    @javax.annotation.Resource(name = "com.sgs.portlet.agency.service.persistence.AgencyPersistence.impl")
    protected AgencyPersistence agencyPersistence;
    @javax.annotation.Resource(name = "com.sgs.portlet.agency.service.persistence.AgencyFinder.impl")
    protected AgencyFinder agencyFinder;

    public AgencyLocalService getAgencyLocalService() {
        return agencyLocalService;
    }

    public void setAgencyLocalService(AgencyLocalService agencyLocalService) {
        this.agencyLocalService = agencyLocalService;
    }

    public AgencyService getAgencyService() {
        return agencyService;
    }

    public void setAgencyService(AgencyService agencyService) {
        this.agencyService = agencyService;
    }

    public AgencyPersistence getAgencyPersistence() {
        return agencyPersistence;
    }

    public void setAgencyPersistence(AgencyPersistence agencyPersistence) {
        this.agencyPersistence = agencyPersistence;
    }

    public AgencyFinder getAgencyFinder() {
        return agencyFinder;
    }

    public void setAgencyFinder(AgencyFinder agencyFinder) {
        this.agencyFinder = agencyFinder;
    }
}
