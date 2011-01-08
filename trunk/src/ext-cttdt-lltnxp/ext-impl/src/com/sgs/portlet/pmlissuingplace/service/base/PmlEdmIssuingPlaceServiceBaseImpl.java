package com.sgs.portlet.pmlissuingplace.service.base;

import com.liferay.portal.service.base.PrincipalBean;

import com.sgs.portlet.pmlissuingplace.service.PmlEdmIssuingPlaceLocalService;
import com.sgs.portlet.pmlissuingplace.service.PmlEdmIssuingPlaceService;
import com.sgs.portlet.pmlissuingplace.service.persistence.PmlEdmIssuingPlaceFinder;
import com.sgs.portlet.pmlissuingplace.service.persistence.PmlEdmIssuingPlacePersistence;


public abstract class PmlEdmIssuingPlaceServiceBaseImpl extends PrincipalBean
    implements PmlEdmIssuingPlaceService {
    @javax.annotation.Resource(name = "com.sgs.portlet.pmlissuingplace.service.PmlEdmIssuingPlaceLocalService.impl")
    protected PmlEdmIssuingPlaceLocalService pmlEdmIssuingPlaceLocalService;
    @javax.annotation.Resource(name = "com.sgs.portlet.pmlissuingplace.service.PmlEdmIssuingPlaceService.impl")
    protected PmlEdmIssuingPlaceService pmlEdmIssuingPlaceService;
    @javax.annotation.Resource(name = "com.sgs.portlet.pmlissuingplace.service.persistence.PmlEdmIssuingPlacePersistence.impl")
    protected PmlEdmIssuingPlacePersistence pmlEdmIssuingPlacePersistence;
    @javax.annotation.Resource(name = "com.sgs.portlet.pmlissuingplace.service.persistence.PmlEdmIssuingPlaceFinder.impl")
    protected PmlEdmIssuingPlaceFinder pmlEdmIssuingPlaceFinder;

    public PmlEdmIssuingPlaceLocalService getPmlEdmIssuingPlaceLocalService() {
        return pmlEdmIssuingPlaceLocalService;
    }

    public void setPmlEdmIssuingPlaceLocalService(
        PmlEdmIssuingPlaceLocalService pmlEdmIssuingPlaceLocalService) {
        this.pmlEdmIssuingPlaceLocalService = pmlEdmIssuingPlaceLocalService;
    }

    public PmlEdmIssuingPlaceService getPmlEdmIssuingPlaceService() {
        return pmlEdmIssuingPlaceService;
    }

    public void setPmlEdmIssuingPlaceService(
        PmlEdmIssuingPlaceService pmlEdmIssuingPlaceService) {
        this.pmlEdmIssuingPlaceService = pmlEdmIssuingPlaceService;
    }

    public PmlEdmIssuingPlacePersistence getPmlEdmIssuingPlacePersistence() {
        return pmlEdmIssuingPlacePersistence;
    }

    public void setPmlEdmIssuingPlacePersistence(
        PmlEdmIssuingPlacePersistence pmlEdmIssuingPlacePersistence) {
        this.pmlEdmIssuingPlacePersistence = pmlEdmIssuingPlacePersistence;
    }

    public PmlEdmIssuingPlaceFinder getPmlEdmIssuingPlaceFinder() {
        return pmlEdmIssuingPlaceFinder;
    }

    public void setPmlEdmIssuingPlaceFinder(
        PmlEdmIssuingPlaceFinder pmlEdmIssuingPlaceFinder) {
        this.pmlEdmIssuingPlaceFinder = pmlEdmIssuingPlaceFinder;
    }
}
