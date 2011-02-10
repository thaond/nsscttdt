package com.sgs.portlet.districtmanagement.service.base;

import com.liferay.portal.service.base.PrincipalBean;

import com.sgs.portlet.districtmanagement.service.DistrictLocalService;
import com.sgs.portlet.districtmanagement.service.DistrictService;
import com.sgs.portlet.districtmanagement.service.persistence.DistrictFinder;
import com.sgs.portlet.districtmanagement.service.persistence.DistrictPersistence;


public abstract class DistrictServiceBaseImpl extends PrincipalBean
    implements DistrictService {
    @javax.annotation.Resource(name = "com.sgs.portlet.districtmanagement.service.DistrictLocalService.impl")
    protected DistrictLocalService districtLocalService;
    @javax.annotation.Resource(name = "com.sgs.portlet.districtmanagement.service.DistrictService.impl")
    protected DistrictService districtService;
    @javax.annotation.Resource(name = "com.sgs.portlet.districtmanagement.service.persistence.DistrictPersistence.impl")
    protected DistrictPersistence districtPersistence;
    @javax.annotation.Resource(name = "com.sgs.portlet.districtmanagement.service.persistence.DistrictFinder.impl")
    protected DistrictFinder districtFinder;

    public DistrictLocalService getDistrictLocalService() {
        return districtLocalService;
    }

    public void setDistrictLocalService(
        DistrictLocalService districtLocalService) {
        this.districtLocalService = districtLocalService;
    }

    public DistrictService getDistrictService() {
        return districtService;
    }

    public void setDistrictService(DistrictService districtService) {
        this.districtService = districtService;
    }

    public DistrictPersistence getDistrictPersistence() {
        return districtPersistence;
    }

    public void setDistrictPersistence(DistrictPersistence districtPersistence) {
        this.districtPersistence = districtPersistence;
    }

    public DistrictFinder getDistrictFinder() {
        return districtFinder;
    }

    public void setDistrictFinder(DistrictFinder districtFinder) {
        this.districtFinder = districtFinder;
    }
}
