package com.sgs.portlet.pmlissuingplace.service.base;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;

import com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace;
import com.sgs.portlet.pmlissuingplace.service.PmlEdmIssuingPlaceLocalService;
import com.sgs.portlet.pmlissuingplace.service.PmlEdmIssuingPlaceService;
import com.sgs.portlet.pmlissuingplace.service.persistence.PmlEdmIssuingPlaceFinder;
import com.sgs.portlet.pmlissuingplace.service.persistence.PmlEdmIssuingPlacePersistence;

import java.util.List;


public abstract class PmlEdmIssuingPlaceLocalServiceBaseImpl
    implements PmlEdmIssuingPlaceLocalService {
    @javax.annotation.Resource(name = "com.sgs.portlet.pmlissuingplace.service.PmlEdmIssuingPlaceLocalService.impl")
    protected PmlEdmIssuingPlaceLocalService pmlEdmIssuingPlaceLocalService;
    @javax.annotation.Resource(name = "com.sgs.portlet.pmlissuingplace.service.PmlEdmIssuingPlaceService.impl")
    protected PmlEdmIssuingPlaceService pmlEdmIssuingPlaceService;
    @javax.annotation.Resource(name = "com.sgs.portlet.pmlissuingplace.service.persistence.PmlEdmIssuingPlacePersistence.impl")
    protected PmlEdmIssuingPlacePersistence pmlEdmIssuingPlacePersistence;
    @javax.annotation.Resource(name = "com.sgs.portlet.pmlissuingplace.service.persistence.PmlEdmIssuingPlaceFinder.impl")
    protected PmlEdmIssuingPlaceFinder pmlEdmIssuingPlaceFinder;

    public PmlEdmIssuingPlace addPmlEdmIssuingPlace(
        PmlEdmIssuingPlace pmlEdmIssuingPlace) throws SystemException {
        pmlEdmIssuingPlace.setNew(true);

        return pmlEdmIssuingPlacePersistence.update(pmlEdmIssuingPlace, false);
    }

    public PmlEdmIssuingPlace createPmlEdmIssuingPlace(String issuingPlaceId) {
        return pmlEdmIssuingPlacePersistence.create(issuingPlaceId);
    }

    public void deletePmlEdmIssuingPlace(String issuingPlaceId)
        throws PortalException, SystemException {
        pmlEdmIssuingPlacePersistence.remove(issuingPlaceId);
    }

    public void deletePmlEdmIssuingPlace(PmlEdmIssuingPlace pmlEdmIssuingPlace)
        throws SystemException {
        pmlEdmIssuingPlacePersistence.remove(pmlEdmIssuingPlace);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return pmlEdmIssuingPlacePersistence.findWithDynamicQuery(dynamicQuery);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery, int start,
        int end) throws SystemException {
        return pmlEdmIssuingPlacePersistence.findWithDynamicQuery(dynamicQuery,
            start, end);
    }

    public PmlEdmIssuingPlace getPmlEdmIssuingPlace(String issuingPlaceId)
        throws PortalException, SystemException {
        return pmlEdmIssuingPlacePersistence.findByPrimaryKey(issuingPlaceId);
    }

    public List<PmlEdmIssuingPlace> getPmlEdmIssuingPlaces(int start, int end)
        throws SystemException {
        return pmlEdmIssuingPlacePersistence.findAll(start, end);
    }

    public int getPmlEdmIssuingPlacesCount() throws SystemException {
        return pmlEdmIssuingPlacePersistence.countAll();
    }

    public PmlEdmIssuingPlace updatePmlEdmIssuingPlace(
        PmlEdmIssuingPlace pmlEdmIssuingPlace) throws SystemException {
        pmlEdmIssuingPlace.setNew(false);

        return pmlEdmIssuingPlacePersistence.update(pmlEdmIssuingPlace, true);
    }

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
