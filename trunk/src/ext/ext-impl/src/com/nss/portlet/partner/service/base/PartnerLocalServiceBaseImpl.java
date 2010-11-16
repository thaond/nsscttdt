package com.nss.portlet.partner.service.base;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.util.PortalUtil;

import com.nss.portlet.partner.model.Partner;
import com.nss.portlet.partner.service.PartnerLocalService;
import com.nss.portlet.partner.service.PartnerService;
import com.nss.portlet.partner.service.persistence.PartnerFinder;
import com.nss.portlet.partner.service.persistence.PartnerPersistence;

import java.util.List;


public abstract class PartnerLocalServiceBaseImpl implements PartnerLocalService {
    @BeanReference(name = "com.nss.portlet.partner.service.PartnerLocalService.impl")
    protected PartnerLocalService partnerLocalService;
    @BeanReference(name = "com.nss.portlet.partner.service.PartnerService.impl")
    protected PartnerService partnerService;
    @BeanReference(name = "com.nss.portlet.partner.service.persistence.PartnerPersistence.impl")
    protected PartnerPersistence partnerPersistence;
    @BeanReference(name = "com.nss.portlet.partner.service.persistence.PartnerFinder.impl")
    protected PartnerFinder partnerFinder;

    public Partner addPartner(Partner partner) throws SystemException {
        partner.setNew(true);

        return partnerPersistence.update(partner, false);
    }

    public Partner createPartner(long maPartner) {
        return partnerPersistence.create(maPartner);
    }

    public void deletePartner(long maPartner)
        throws PortalException, SystemException {
        partnerPersistence.remove(maPartner);
    }

    public void deletePartner(Partner partner) throws SystemException {
        partnerPersistence.remove(partner);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return partnerPersistence.findWithDynamicQuery(dynamicQuery);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery, int start,
        int end) throws SystemException {
        return partnerPersistence.findWithDynamicQuery(dynamicQuery, start, end);
    }

    public Partner getPartner(long maPartner)
        throws PortalException, SystemException {
        return partnerPersistence.findByPrimaryKey(maPartner);
    }

    public List<Partner> getPartners(int start, int end)
        throws SystemException {
        return partnerPersistence.findAll(start, end);
    }

    public int getPartnersCount() throws SystemException {
        return partnerPersistence.countAll();
    }

    public Partner updatePartner(Partner partner) throws SystemException {
        partner.setNew(false);

        return partnerPersistence.update(partner, true);
    }

    public Partner updatePartner(Partner partner, boolean merge)
        throws SystemException {
        partner.setNew(false);

        return partnerPersistence.update(partner, merge);
    }

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
