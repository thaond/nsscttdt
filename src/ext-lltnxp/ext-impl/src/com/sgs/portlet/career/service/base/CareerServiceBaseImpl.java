package com.sgs.portlet.career.service.base;

import com.liferay.portal.service.base.PrincipalBean;

import com.sgs.portlet.career.service.CareerLocalService;
import com.sgs.portlet.career.service.CareerService;
import com.sgs.portlet.career.service.persistence.CareerFinder;
import com.sgs.portlet.career.service.persistence.CareerPersistence;


public abstract class CareerServiceBaseImpl extends PrincipalBean
    implements CareerService {
    @javax.annotation.Resource(name = "com.sgs.portlet.career.service.CareerLocalService.impl")
    protected CareerLocalService careerLocalService;
    @javax.annotation.Resource(name = "com.sgs.portlet.career.service.CareerService.impl")
    protected CareerService careerService;
    @javax.annotation.Resource(name = "com.sgs.portlet.career.service.persistence.CareerPersistence.impl")
    protected CareerPersistence careerPersistence;
    @javax.annotation.Resource(name = "com.sgs.portlet.career.service.persistence.CareerFinder.impl")
    protected CareerFinder careerFinder;

    public CareerLocalService getCareerLocalService() {
        return careerLocalService;
    }

    public void setCareerLocalService(CareerLocalService careerLocalService) {
        this.careerLocalService = careerLocalService;
    }

    public CareerService getCareerService() {
        return careerService;
    }

    public void setCareerService(CareerService careerService) {
        this.careerService = careerService;
    }

    public CareerPersistence getCareerPersistence() {
        return careerPersistence;
    }

    public void setCareerPersistence(CareerPersistence careerPersistence) {
        this.careerPersistence = careerPersistence;
    }

    public CareerFinder getCareerFinder() {
        return careerFinder;
    }

    public void setCareerFinder(CareerFinder careerFinder) {
        this.careerFinder = careerFinder;
    }
}
