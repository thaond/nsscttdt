package com.sgs.portlet.pmlstreet.service.base;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;

import com.sgs.portlet.pmlstreet.model.PmlStreet;
import com.sgs.portlet.pmlstreet.service.PmlStreetLocalService;
import com.sgs.portlet.pmlstreet.service.PmlStreetService;
import com.sgs.portlet.pmlstreet.service.persistence.PmlStreetFinder;
import com.sgs.portlet.pmlstreet.service.persistence.PmlStreetPersistence;

import java.util.List;


public abstract class PmlStreetLocalServiceBaseImpl
    implements PmlStreetLocalService {
    @javax.annotation.Resource(name = "com.sgs.portlet.pmlstreet.service.PmlStreetLocalService.impl")
    protected PmlStreetLocalService pmlStreetLocalService;
    @javax.annotation.Resource(name = "com.sgs.portlet.pmlstreet.service.PmlStreetService.impl")
    protected PmlStreetService pmlStreetService;
    @javax.annotation.Resource(name = "com.sgs.portlet.pmlstreet.service.persistence.PmlStreetPersistence.impl")
    protected PmlStreetPersistence pmlStreetPersistence;
    @javax.annotation.Resource(name = "com.sgs.portlet.pmlstreet.service.persistence.PmlStreetFinder.impl")
    protected PmlStreetFinder pmlStreetFinder;

    public PmlStreet addPmlStreet(PmlStreet pmlStreet)
        throws SystemException {
        pmlStreet.setNew(true);

        return pmlStreetPersistence.update(pmlStreet, false);
    }

    public PmlStreet createPmlStreet(String streetId) {
        return pmlStreetPersistence.create(streetId);
    }

    public void deletePmlStreet(String streetId)
        throws PortalException, SystemException {
        pmlStreetPersistence.remove(streetId);
    }

    public void deletePmlStreet(PmlStreet pmlStreet) throws SystemException {
        pmlStreetPersistence.remove(pmlStreet);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return pmlStreetPersistence.findWithDynamicQuery(dynamicQuery);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery, int start,
        int end) throws SystemException {
        return pmlStreetPersistence.findWithDynamicQuery(dynamicQuery, start,
            end);
    }

    public PmlStreet getPmlStreet(String streetId)
        throws PortalException, SystemException {
        return pmlStreetPersistence.findByPrimaryKey(streetId);
    }

    public List<PmlStreet> getPmlStreets(int start, int end)
        throws SystemException {
        return pmlStreetPersistence.findAll(start, end);
    }

    public int getPmlStreetsCount() throws SystemException {
        return pmlStreetPersistence.countAll();
    }

    public PmlStreet updatePmlStreet(PmlStreet pmlStreet)
        throws SystemException {
        pmlStreet.setNew(false);

        return pmlStreetPersistence.update(pmlStreet, true);
    }

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
