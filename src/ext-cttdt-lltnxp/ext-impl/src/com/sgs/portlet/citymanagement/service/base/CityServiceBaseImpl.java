package com.sgs.portlet.citymanagement.service.base;

import com.liferay.portal.service.base.PrincipalBean;

import com.sgs.portlet.citymanagement.service.CityLocalService;
import com.sgs.portlet.citymanagement.service.CityService;
import com.sgs.portlet.citymanagement.service.persistence.CityFinder;
import com.sgs.portlet.citymanagement.service.persistence.CityPersistence;


public abstract class CityServiceBaseImpl extends PrincipalBean
    implements CityService {
    @javax.annotation.Resource(name = "com.sgs.portlet.citymanagement.service.CityLocalService.impl")
    protected CityLocalService cityLocalService;
    @javax.annotation.Resource(name = "com.sgs.portlet.citymanagement.service.CityService.impl")
    protected CityService cityService;
    @javax.annotation.Resource(name = "com.sgs.portlet.citymanagement.service.persistence.CityPersistence.impl")
    protected CityPersistence cityPersistence;
    @javax.annotation.Resource(name = "com.sgs.portlet.citymanagement.service.persistence.CityFinder.impl")
    protected CityFinder cityFinder;

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
