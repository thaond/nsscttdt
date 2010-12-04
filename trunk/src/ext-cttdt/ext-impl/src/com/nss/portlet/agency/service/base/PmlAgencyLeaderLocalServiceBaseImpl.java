package com.nss.portlet.agency.service.base;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.util.PortalUtil;

import com.nss.portlet.agency.model.PmlAgencyLeader;
import com.nss.portlet.agency.service.AgencyLocalService;
import com.nss.portlet.agency.service.AgencyService;
import com.nss.portlet.agency.service.PmlAgencyLeaderLocalService;
import com.nss.portlet.agency.service.PmlAgencyLeaderService;
import com.nss.portlet.agency.service.persistence.AgencyFinder;
import com.nss.portlet.agency.service.persistence.AgencyPersistence;
import com.nss.portlet.agency.service.persistence.PmlAgencyLeaderPersistence;

import java.util.List;


public abstract class PmlAgencyLeaderLocalServiceBaseImpl
    implements PmlAgencyLeaderLocalService {
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

    public PmlAgencyLeader addPmlAgencyLeader(PmlAgencyLeader pmlAgencyLeader)
        throws SystemException {
        pmlAgencyLeader.setNew(true);

        return pmlAgencyLeaderPersistence.update(pmlAgencyLeader, false);
    }

    public PmlAgencyLeader createPmlAgencyLeader(String agencyId) {
        return pmlAgencyLeaderPersistence.create(agencyId);
    }

    public void deletePmlAgencyLeader(String agencyId)
        throws PortalException, SystemException {
        pmlAgencyLeaderPersistence.remove(agencyId);
    }

    public void deletePmlAgencyLeader(PmlAgencyLeader pmlAgencyLeader)
        throws SystemException {
        pmlAgencyLeaderPersistence.remove(pmlAgencyLeader);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return pmlAgencyLeaderPersistence.findWithDynamicQuery(dynamicQuery);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery, int start,
        int end) throws SystemException {
        return pmlAgencyLeaderPersistence.findWithDynamicQuery(dynamicQuery,
            start, end);
    }

    public PmlAgencyLeader getPmlAgencyLeader(String agencyId)
        throws PortalException, SystemException {
        return pmlAgencyLeaderPersistence.findByPrimaryKey(agencyId);
    }

    public List<PmlAgencyLeader> getPmlAgencyLeaders(int start, int end)
        throws SystemException {
        return pmlAgencyLeaderPersistence.findAll(start, end);
    }

    public int getPmlAgencyLeadersCount() throws SystemException {
        return pmlAgencyLeaderPersistence.countAll();
    }

    public PmlAgencyLeader updatePmlAgencyLeader(
        PmlAgencyLeader pmlAgencyLeader) throws SystemException {
        pmlAgencyLeader.setNew(false);

        return pmlAgencyLeaderPersistence.update(pmlAgencyLeader, true);
    }

    public PmlAgencyLeader updatePmlAgencyLeader(
        PmlAgencyLeader pmlAgencyLeader, boolean merge)
        throws SystemException {
        pmlAgencyLeader.setNew(false);

        return pmlAgencyLeaderPersistence.update(pmlAgencyLeader, merge);
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
