package com.sgs.portlet.nation.service.base;

import com.liferay.portal.service.base.PrincipalBean;

import com.sgs.portlet.country.service.CountryLocalService;
import com.sgs.portlet.country.service.CountryService;
import com.sgs.portlet.country.service.persistence.CountryFinder;
import com.sgs.portlet.country.service.persistence.CountryPersistence;
import com.sgs.portlet.nation.service.NationLocalService;
import com.sgs.portlet.nation.service.NationService;
import com.sgs.portlet.nation.service.persistence.NationFinder;
import com.sgs.portlet.nation.service.persistence.NationPersistence;


public abstract class NationServiceBaseImpl extends PrincipalBean
    implements NationService {
    @javax.annotation.Resource(name = "com.sgs.portlet.nation.service.NationLocalService.impl")
    protected NationLocalService nationLocalService;
    @javax.annotation.Resource(name = "com.sgs.portlet.nation.service.NationService.impl")
    protected NationService nationService;
    @javax.annotation.Resource(name = "com.sgs.portlet.nation.service.persistence.NationPersistence.impl")
    protected NationPersistence nationPersistence;
    @javax.annotation.Resource(name = "com.sgs.portlet.nation.service.persistence.NationFinder.impl")
    protected NationFinder nationFinder;
    @javax.annotation.Resource(name = "com.sgs.portlet.country.service.CountryLocalService.impl")
    protected CountryLocalService countryLocalService;
    @javax.annotation.Resource(name = "com.sgs.portlet.country.service.CountryService.impl")
    protected CountryService countryService;
    @javax.annotation.Resource(name = "com.sgs.portlet.country.service.persistence.CountryPersistence.impl")
    protected CountryPersistence countryPersistence;
    @javax.annotation.Resource(name = "com.sgs.portlet.country.service.persistence.CountryFinder.impl")
    protected CountryFinder countryFinder;

    public NationLocalService getNationLocalService() {
        return nationLocalService;
    }

    public void setNationLocalService(NationLocalService nationLocalService) {
        this.nationLocalService = nationLocalService;
    }

    public NationService getNationService() {
        return nationService;
    }

    public void setNationService(NationService nationService) {
        this.nationService = nationService;
    }

    public NationPersistence getNationPersistence() {
        return nationPersistence;
    }

    public void setNationPersistence(NationPersistence nationPersistence) {
        this.nationPersistence = nationPersistence;
    }

    public NationFinder getNationFinder() {
        return nationFinder;
    }

    public void setNationFinder(NationFinder nationFinder) {
        this.nationFinder = nationFinder;
    }

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
