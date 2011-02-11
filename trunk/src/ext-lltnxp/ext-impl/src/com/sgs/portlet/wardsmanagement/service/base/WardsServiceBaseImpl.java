package com.sgs.portlet.wardsmanagement.service.base;

import com.liferay.portal.service.base.PrincipalBean;

import com.sgs.portlet.wardsmanagement.service.WardsLocalService;
import com.sgs.portlet.wardsmanagement.service.WardsService;
import com.sgs.portlet.wardsmanagement.service.persistence.WardsFinder;
import com.sgs.portlet.wardsmanagement.service.persistence.WardsPersistence;


public abstract class WardsServiceBaseImpl extends PrincipalBean
    implements WardsService {
    @javax.annotation.Resource(name = "com.sgs.portlet.wardsmanagement.service.WardsLocalService.impl")
    protected WardsLocalService wardsLocalService;
    @javax.annotation.Resource(name = "com.sgs.portlet.wardsmanagement.service.WardsService.impl")
    protected WardsService wardsService;
    @javax.annotation.Resource(name = "com.sgs.portlet.wardsmanagement.service.persistence.WardsPersistence.impl")
    protected WardsPersistence wardsPersistence;
    @javax.annotation.Resource(name = "com.sgs.portlet.wardsmanagement.service.persistence.WardsFinder.impl")
    protected WardsFinder wardsFinder;

    public WardsLocalService getWardsLocalService() {
        return wardsLocalService;
    }

    public void setWardsLocalService(WardsLocalService wardsLocalService) {
        this.wardsLocalService = wardsLocalService;
    }

    public WardsService getWardsService() {
        return wardsService;
    }

    public void setWardsService(WardsService wardsService) {
        this.wardsService = wardsService;
    }

    public WardsPersistence getWardsPersistence() {
        return wardsPersistence;
    }

    public void setWardsPersistence(WardsPersistence wardsPersistence) {
        this.wardsPersistence = wardsPersistence;
    }

    public WardsFinder getWardsFinder() {
        return wardsFinder;
    }

    public void setWardsFinder(WardsFinder wardsFinder) {
        this.wardsFinder = wardsFinder;
    }
}
