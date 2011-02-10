package com.sgs.portlet.career.service.base;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;

import com.sgs.portlet.career.model.Career;
import com.sgs.portlet.career.service.CareerLocalService;
import com.sgs.portlet.career.service.CareerService;
import com.sgs.portlet.career.service.persistence.CareerFinder;
import com.sgs.portlet.career.service.persistence.CareerPersistence;

import java.util.List;


public abstract class CareerLocalServiceBaseImpl implements CareerLocalService {
    @javax.annotation.Resource(name = "com.sgs.portlet.career.service.CareerLocalService.impl")
    protected CareerLocalService careerLocalService;
    @javax.annotation.Resource(name = "com.sgs.portlet.career.service.CareerService.impl")
    protected CareerService careerService;
    @javax.annotation.Resource(name = "com.sgs.portlet.career.service.persistence.CareerPersistence.impl")
    protected CareerPersistence careerPersistence;
    @javax.annotation.Resource(name = "com.sgs.portlet.career.service.persistence.CareerFinder.impl")
    protected CareerFinder careerFinder;

    public Career addCareer(Career career) throws SystemException {
        career.setNew(true);

        return careerPersistence.update(career, false);
    }

    public Career createCareer(String careerId) {
        return careerPersistence.create(careerId);
    }

    public void deleteCareer(String careerId)
        throws PortalException, SystemException {
        careerPersistence.remove(careerId);
    }

    public void deleteCareer(Career career) throws SystemException {
        careerPersistence.remove(career);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return careerPersistence.findWithDynamicQuery(dynamicQuery);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery, int start,
        int end) throws SystemException {
        return careerPersistence.findWithDynamicQuery(dynamicQuery, start, end);
    }

    public Career getCareer(String careerId)
        throws PortalException, SystemException {
        return careerPersistence.findByPrimaryKey(careerId);
    }

    public List<Career> getCareers(int start, int end)
        throws SystemException {
        return careerPersistence.findAll(start, end);
    }

    public int getCareersCount() throws SystemException {
        return careerPersistence.countAll();
    }

    public Career updateCareer(Career career) throws SystemException {
        career.setNew(false);

        return careerPersistence.update(career, true);
    }

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
