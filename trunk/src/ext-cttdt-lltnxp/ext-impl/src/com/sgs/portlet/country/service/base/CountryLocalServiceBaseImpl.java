package com.sgs.portlet.country.service.base;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;

import com.sgs.portlet.country.model.Country;
import com.sgs.portlet.country.service.CountryLocalService;
import com.sgs.portlet.country.service.CountryService;
import com.sgs.portlet.country.service.persistence.CountryFinder;
import com.sgs.portlet.country.service.persistence.CountryPersistence;

import java.util.List;


public abstract class CountryLocalServiceBaseImpl implements CountryLocalService {
    @javax.annotation.Resource(name = "com.sgs.portlet.country.service.CountryLocalService.impl")
    protected CountryLocalService countryLocalService;
    @javax.annotation.Resource(name = "com.sgs.portlet.country.service.CountryService.impl")
    protected CountryService countryService;
    @javax.annotation.Resource(name = "com.sgs.portlet.country.service.persistence.CountryPersistence.impl")
    protected CountryPersistence countryPersistence;
    @javax.annotation.Resource(name = "com.sgs.portlet.country.service.persistence.CountryFinder.impl")
    protected CountryFinder countryFinder;

    public Country addCountry(Country country) throws SystemException {
        country.setNew(true);

        return countryPersistence.update(country, false);
    }

    public Country createCountry(String countryId) {
        return countryPersistence.create(countryId);
    }

    public void deleteCountry(String countryId)
        throws PortalException, SystemException {
        countryPersistence.remove(countryId);
    }

    public void deleteCountry(Country country) throws SystemException {
        countryPersistence.remove(country);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return countryPersistence.findWithDynamicQuery(dynamicQuery);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery, int start,
        int end) throws SystemException {
        return countryPersistence.findWithDynamicQuery(dynamicQuery, start, end);
    }

    public Country getCountry(String countryId)
        throws PortalException, SystemException {
        return countryPersistence.findByPrimaryKey(countryId);
    }

    public List<Country> getCountries(int start, int end)
        throws SystemException {
        return countryPersistence.findAll(start, end);
    }

    public int getCountriesCount() throws SystemException {
        return countryPersistence.countAll();
    }

    public Country updateCountry(Country country) throws SystemException {
        country.setNew(false);

        return countryPersistence.update(country, true);
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
