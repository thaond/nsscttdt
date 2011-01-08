package com.sgs.portlet.position.service.base;

import com.liferay.portal.service.base.PrincipalBean;

import com.sgs.portlet.position.service.PositionLocalService;
import com.sgs.portlet.position.service.PositionService;
import com.sgs.portlet.position.service.persistence.PositionFinder;
import com.sgs.portlet.position.service.persistence.PositionPersistence;


public abstract class PositionServiceBaseImpl extends PrincipalBean
    implements PositionService {
    @javax.annotation.Resource(name = "com.sgs.portlet.position.service.PositionLocalService.impl")
    protected PositionLocalService positionLocalService;
    @javax.annotation.Resource(name = "com.sgs.portlet.position.service.PositionService.impl")
    protected PositionService positionService;
    @javax.annotation.Resource(name = "com.sgs.portlet.position.service.persistence.PositionPersistence.impl")
    protected PositionPersistence positionPersistence;
    @javax.annotation.Resource(name = "com.sgs.portlet.position.service.persistence.PositionFinder.impl")
    protected PositionFinder positionFinder;

    public PositionLocalService getPositionLocalService() {
        return positionLocalService;
    }

    public void setPositionLocalService(
        PositionLocalService positionLocalService) {
        this.positionLocalService = positionLocalService;
    }

    public PositionService getPositionService() {
        return positionService;
    }

    public void setPositionService(PositionService positionService) {
        this.positionService = positionService;
    }

    public PositionPersistence getPositionPersistence() {
        return positionPersistence;
    }

    public void setPositionPersistence(PositionPersistence positionPersistence) {
        this.positionPersistence = positionPersistence;
    }

    public PositionFinder getPositionFinder() {
        return positionFinder;
    }

    public void setPositionFinder(PositionFinder positionFinder) {
        this.positionFinder = positionFinder;
    }
}
