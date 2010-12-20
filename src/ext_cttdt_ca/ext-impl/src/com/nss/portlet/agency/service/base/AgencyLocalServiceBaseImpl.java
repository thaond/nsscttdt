package com.nss.portlet.agency.service.base;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.util.PortalUtil;

import com.nss.portlet.agency.model.Agency;
import com.nss.portlet.agency.service.AgencyLocalService;
import com.nss.portlet.agency.service.AgencyService;
import com.nss.portlet.agency.service.PmlAgencyLeaderLocalService;
import com.nss.portlet.agency.service.PmlAgencyLeaderService;
import com.nss.portlet.agency.service.persistence.AgencyFinder;
import com.nss.portlet.agency.service.persistence.AgencyPersistence;
import com.nss.portlet.agency.service.persistence.PmlAgencyLeaderPersistence;

import java.util.List;


public abstract class AgencyLocalServiceBaseImpl implements AgencyLocalService {
    @BeanReference(name = "com.nss.portlet.agency.service.AgencyLocalService.impl")
    protected AgencyLocalService agencyLocalService;
    @BeanReference(name = "com.nss.portlet.agency.service.AgencyService.impl")
    protected AgencyService agencyService;
    @BeanReference(name = "com.nss.portlet.agency.service.persistence.AgencyPersistence.impl")
    protected AgencyPersistence agencyPersistence;
    @BeanReference(name = "com.nss.portlet.agency.service.persistence.AgencyFinder.impl")
    protected AgencyFinder agencyFinder;
    @BeanReference(name = "com.nss.portlet.agency.service.PmlAgencyLeaderLocalService.impl")
    protected PmlAgencyLeaderLocalService pmlAgencyLeaderLocalService;
    @BeanReference(name = "com.nss.portlet.agency.service.PmlAgencyLeaderService.impl")
    protected PmlAgencyLeaderService pmlAgencyLeaderService;
    @BeanReference(name = "com.nss.portlet.agency.service.persistence.PmlAgencyLeaderPersistence.impl")
    protected PmlAgencyLeaderPersistence pmlAgencyLeaderPersistence;

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

    public Agency updateAgency(Agency agency, boolean merge)
        throws SystemException {
        agency.setNew(false);

        return agencyPersistence.update(agency, merge);
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

    public PmlAgencyLeaderLocalService getPmlAgencyLeaderLocalService() {
        return pmlAgencyLeaderLocalService;
    }

    public void setPmlAgencyLeaderLocalService(
        PmlAgencyLeaderLocalService pmlAgencyLeaderLocalService) {
        this.pmlAgencyLeaderLocalService = pmlAgencyLeaderLocalService;
    }

    public PmlAgencyLeaderService getPmlAgencyLeaderService() {
        return pmlAgencyLeaderService;
    }

    public void setPmlAgencyLeaderService(
        PmlAgencyLeaderService pmlAgencyLeaderService) {
        this.pmlAgencyLeaderService = pmlAgencyLeaderService;
    }

    public PmlAgencyLeaderPersistence getPmlAgencyLeaderPersistence() {
        return pmlAgencyLeaderPersistence;
    }

    public void setPmlAgencyLeaderPersistence(
        PmlAgencyLeaderPersistence pmlAgencyLeaderPersistence) {
        this.pmlAgencyLeaderPersistence = pmlAgencyLeaderPersistence;
    }

    protected void runSQL(String sql) throws SystemException {
        try {
            PortalUtil.runSQL(sql);
        } catch (Exception e) {
            throw new SystemException(e);
        }
    }
}
