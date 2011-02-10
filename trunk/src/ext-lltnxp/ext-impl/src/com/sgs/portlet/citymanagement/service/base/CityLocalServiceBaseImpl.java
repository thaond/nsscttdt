package com.sgs.portlet.citymanagement.service.base;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;

import com.sgs.portlet.citymanagement.model.City;
import com.sgs.portlet.citymanagement.service.CityLocalService;
import com.sgs.portlet.citymanagement.service.CityService;
import com.sgs.portlet.citymanagement.service.persistence.CityFinder;
import com.sgs.portlet.citymanagement.service.persistence.CityPersistence;

import java.util.List;


public abstract class CityLocalServiceBaseImpl implements CityLocalService {
    @javax.annotation.Resource(name = "com.sgs.portlet.citymanagement.service.CityLocalService.impl")
    protected CityLocalService cityLocalService;
    @javax.annotation.Resource(name = "com.sgs.portlet.citymanagement.service.CityService.impl")
    protected CityService cityService;
    @javax.annotation.Resource(name = "com.sgs.portlet.citymanagement.service.persistence.CityPersistence.impl")
    protected CityPersistence cityPersistence;
    @javax.annotation.Resource(name = "com.sgs.portlet.citymanagement.service.persistence.CityFinder.impl")
    protected CityFinder cityFinder;

    public City addCity(City city) throws SystemException {
        city.setNew(true);

        return cityPersistence.update(city, false);
    }

    public City createCity(String cityID) {
        return cityPersistence.create(cityID);
    }

    public void deleteCity(String cityID)
        throws PortalException, SystemException {
        cityPersistence.remove(cityID);
    }

    public void deleteCity(City city) throws SystemException {
        cityPersistence.remove(city);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return cityPersistence.findWithDynamicQuery(dynamicQuery);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery, int start,
        int end) throws SystemException {
        return cityPersistence.findWithDynamicQuery(dynamicQuery, start, end);
    }

    public City getCity(String cityID) throws PortalException, SystemException {
        return cityPersistence.findByPrimaryKey(cityID);
    }

    public List<City> getCities(int start, int end) throws SystemException {
        return cityPersistence.findAll(start, end);
    }

    public int getCitiesCount() throws SystemException {
        return cityPersistence.countAll();
    }

    public City updateCity(City city) throws SystemException {
        city.setNew(false);

        return cityPersistence.update(city, true);
    }

    public CityLocalService getCityLocalService() {
        return cityLocalService;
    }

    public void setCityLocalService(CityLocalService cityLocalService) {
        this.cityLocalService = cityLocalService;
    }

    public CityService getCityService() {
        return cityService;
    }

    public void setCityService(CityService cityService) {
        this.cityService = cityService;
    }

    public CityPersistence getCityPersistence() {
        return cityPersistence;
    }

    public void setCityPersistence(CityPersistence cityPersistence) {
        this.cityPersistence = cityPersistence;
    }

    public CityFinder getCityFinder() {
        return cityFinder;
    }

    public void setCityFinder(CityFinder cityFinder) {
        this.cityFinder = cityFinder;
    }
}
