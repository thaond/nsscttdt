package com.sgs.portlet.country.service.base;

import com.liferay.portal.service.base.PrincipalBean;

import com.sgs.portlet.country.service.CountryLocalService;
import com.sgs.portlet.country.service.CountryService;
import com.sgs.portlet.country.service.persistence.CountryFinder;
import com.sgs.portlet.country.service.persistence.CountryPersistence;


public abstract class CountryServiceBaseImpl extends PrincipalBean
    implements CountryService {
    @javax.annotation.Resource(name = "com.sgs.portlet.country.service.CountryLocalService.impl")
    protected CountryLocalService countryLocalService;
    @javax.annotation.Resource(name = "com.sgs.portlet.country.service.CountryService.impl")
    protected CountryService countryService;
    @javax.annotation.Resource(name = "com.sgs.portlet.country.service.persistence.CountryPersistence.impl")
    protected CountryPersistence countryPersistence;
    @javax.annotation.Resource(name = "com.sgs.portlet.country.service.persistence.CountryFinder.impl")
    protected CountryFinder countryFinder;

    public CountryLocalService getCountryLocalService() {
        return countryLocalService;
    }

    public void setCountryLocalService(CountryLocalService countryLocalService) {
        this.countryLocalService = countryLocalService;
    }

    public CountryService getCountryService() {
        return countryService;
    }

    public void setCountryService(CountryService countryService) {
        this.countryService = countryService;
    }

    public CountryPersistence getCountryPersistence() {
        return countryPersistence;
    }

    public void setCountryPersistence(CountryPersistence countryPersistence) {
        this.countryPersistence = countryPersistence;
    }

    public CountryFinder getCountryFinder() {
        return countryFinder;
    }

    public void setCountryFinder(CountryFinder countryFinder) {
        this.countryFinder = countryFinder;
    }
}
