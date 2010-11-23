package com.nss.portlet.partner.service.base;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.service.base.PrincipalBean;
import com.liferay.portal.util.PortalUtil;

import com.nss.portlet.partner.service.PartnerLocalService;
import com.nss.portlet.partner.service.PartnerService;
import com.nss.portlet.partner.service.persistence.PartnerFinder;
import com.nss.portlet.partner.service.persistence.PartnerPersistence;


public abstract class PartnerServiceBaseImpl extends PrincipalBean
    implements PartnerService {
    @BeanReference(name = "com.nss.portlet.partner.service.PartnerLocalService.impl")
    protected PartnerLocalService partnerLocalService;
    @BeanReference(name = "com.nss.portlet.partner.service.PartnerService.impl")
    protected PartnerService partnerService;
    @BeanReference(name = "com.nss.portlet.partner.service.persistence.PartnerPersistence.impl")
    protected PartnerPersistence partnerPersistence;
    @BeanReference(name = "com.nss.portlet.partner.service.persistence.PartnerFinder.impl")
    protected PartnerFinder partnerFinder;

    public PartnerLocalService getPartnerLocalService() {
        return partnerLocalService;
    }

    public void setPartnerLocalService(PartnerLocalService partnerLocalService) {
        this.partnerLocalService = partnerLocalService;
    }

    public PartnerService getPartnerService() {
        return partnerService;
    }

    public void setPartnerService(PartnerService partnerService) {
        this.partnerService = partnerService;
    }

    public PartnerPersistence getPartnerPersistence() {
        return partnerPersistence;
    }

    public void setPartnerPersistence(PartnerPersistence partnerPersistence) {
        this.partnerPersistence = partnerPersistence;
    }

    public PartnerFinder getPartnerFinder() {
        return partnerFinder;
    }

    public void setPartnerFinder(PartnerFinder partnerFinder) {
        this.partnerFinder = partnerFinder;
    }

    protected void runSQL(String sql) throws SystemException {
        try {
            PortalUtil.runSQL(sql);
        } catch (Exception e) {
            throw new SystemException(e);
        }
    }
}
