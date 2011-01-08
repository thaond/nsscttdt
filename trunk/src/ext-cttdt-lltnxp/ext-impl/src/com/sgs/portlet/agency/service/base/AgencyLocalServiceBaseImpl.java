package com.sgs.portlet.agency.service.base;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;

import com.sgs.portlet.agency.model.Agency;
import com.sgs.portlet.agency.service.AgencyLocalService;
import com.sgs.portlet.agency.service.AgencyService;
import com.sgs.portlet.agency.service.persistence.AgencyFinder;
import com.sgs.portlet.agency.service.persistence.AgencyPersistence;

import java.util.List;


public abstract class AgencyLocalServiceBaseImpl implements AgencyLocalService {
    @javax.annotation.Resource(name = "com.sgs.portlet.agency.service.AgencyLocalService.impl")
    protected AgencyLocalService agencyLocalService;
    @javax.annotation.Resource(name = "com.sgs.portlet.agency.service.AgencyService.impl")
    protected AgencyService agencyService;
    @javax.annotation.Resource(name = "com.sgs.portlet.agency.service.persistence.AgencyPersistence.impl")
    protected AgencyPersistence agencyPersistence;
    @javax.annotation.Resource(name = "com.sgs.portlet.agency.service.persistence.AgencyFinder.impl")
    protected AgencyFinder agencyFinder;

    public Agency addAgency(Agency agency) throws SystemException {
        agency.setNew(true);

        return agencyPersistence.update(agency, false);
    }

    public Agency createAgency(String agencyId) {
        return agencyPersistence.create(agencyId);
    }

    public void deleteAgency(String agencyId)
        throws PortalException, SystemException {
        agencyPersistence.remove(agencyId);
    }

    public void deleteAgency(Agency agency) throws SystemException {
        agencyPersistence.remove(agency);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return agencyPersistence.findWithDynamicQuery(dynamicQuery);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery, int start,
        int end) throws SystemException {
        return agencyPersistence.findWithDynamicQuery(dynamicQuery, start, end);
    }

    public Agency getAgency(String agencyId)
        throws PortalException, SystemException {
        return agencyPersistence.findByPrimaryKey(agencyId);
    }

    public List<Agency> getAgencies(int start, int end)
        throws SystemException {
        return agencyPersistence.findAll(start, end);
    }

    public int getAgenciesCount() throws SystemException {
        return agencyPersistence.countAll();
    }

    public Agency updateAgency(Agency agency) throws SystemException {
        agency.setNew(false);

        return agencyPersistence.update(agency, true);
    }

    public AgencyLocalService getAgencyLocalService() {
        return agencyLocalService;
    }

    public void setAgencyLocalService(AgencyLocalService agencyLocalService) {
        this.agencyLocalService = agencyLocalService;
    }

    public AgencyService getAgencyService() {
        return agencyService;
    }

    public void setAgencyService(AgencyService agencyService) {
        this.agencyService = agencyService;
    }

    public AgencyPersistence getAgencyPersistence() {
        return agencyPersistence;
    }

    public void setAgencyPersistence(AgencyPersistence agencyPersistence) {
        this.agencyPersistence = agencyPersistence;
    }

    public AgencyFinder getAgencyFinder() {
        return agencyFinder;
    }

    public void setAgencyFinder(AgencyFinder agencyFinder) {
        this.agencyFinder = agencyFinder;
    }
}
