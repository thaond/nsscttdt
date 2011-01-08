package com.sgs.portlet.pmlstreet.service.base;

import com.liferay.portal.service.base.PrincipalBean;

import com.sgs.portlet.pmlstreet.service.PmlStreetLocalService;
import com.sgs.portlet.pmlstreet.service.PmlStreetService;
import com.sgs.portlet.pmlstreet.service.persistence.PmlStreetFinder;
import com.sgs.portlet.pmlstreet.service.persistence.PmlStreetPersistence;


public abstract class PmlStreetServiceBaseImpl extends PrincipalBean
    implements PmlStreetService {
    @javax.annotation.Resource(name = "com.sgs.portlet.pmlstreet.service.PmlStreetLocalService.impl")
    protected PmlStreetLocalService pmlStreetLocalService;
    @javax.annotation.Resource(name = "com.sgs.portlet.pmlstreet.service.PmlStreetService.impl")
    protected PmlStreetService pmlStreetService;
    @javax.annotation.Resource(name = "com.sgs.portlet.pmlstreet.service.persistence.PmlStreetPersistence.impl")
    protected PmlStreetPersistence pmlStreetPersistence;
    @javax.annotation.Resource(name = "com.sgs.portlet.pmlstreet.service.persistence.PmlStreetFinder.impl")
    protected PmlStreetFinder pmlStreetFinder;

    public PmlStreetLocalService getPmlStreetLocalService() {
        return pmlStreetLocalService;
    }

    public void setPmlStreetLocalService(
        PmlStreetLocalService pmlStreetLocalService) {
        this.pmlStreetLocalService = pmlStreetLocalService;
    }

    public PmlStreetService getPmlStreetService() {
        return pmlStreetService;
    }

    public void setPmlStreetService(PmlStreetService pmlStreetService) {
        this.pmlStreetService = pmlStreetService;
    }

    public PmlStreetPersistence getPmlStreetPersistence() {
        return pmlStreetPersistence;
    }

    public void setPmlStreetPersistence(
        PmlStreetPersistence pmlStreetPersistence) {
        this.pmlStreetPersistence = pmlStreetPersistence;
    }

    public PmlStreetFinder getPmlStreetFinder() {
        return pmlStreetFinder;
    }

    public void setPmlStreetFinder(PmlStreetFinder pmlStreetFinder) {
        this.pmlStreetFinder = pmlStreetFinder;
    }
}
