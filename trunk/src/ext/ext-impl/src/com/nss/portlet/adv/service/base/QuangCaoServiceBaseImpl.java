package com.nss.portlet.adv.service.base;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.service.base.PrincipalBean;
import com.liferay.portal.util.PortalUtil;

import com.nss.portlet.adv.service.QuangCaoLocalService;
import com.nss.portlet.adv.service.QuangCaoService;
import com.nss.portlet.adv.service.persistence.QuangCaoFinder;
import com.nss.portlet.adv.service.persistence.QuangCaoPersistence;


public abstract class QuangCaoServiceBaseImpl extends PrincipalBean
    implements QuangCaoService {
    @BeanReference(name = "com.nss.portlet.adv.service.QuangCaoLocalService.impl")
    protected QuangCaoLocalService quangCaoLocalService;
    @BeanReference(name = "com.nss.portlet.adv.service.QuangCaoService.impl")
    protected QuangCaoService quangCaoService;
    @BeanReference(name = "com.nss.portlet.adv.service.persistence.QuangCaoPersistence.impl")
    protected QuangCaoPersistence quangCaoPersistence;
    @BeanReference(name = "com.nss.portlet.adv.service.persistence.QuangCaoFinder.impl")
    protected QuangCaoFinder quangCaoFinder;

    public QuangCaoLocalService getQuangCaoLocalService() {
        return quangCaoLocalService;
    }

    public void setQuangCaoLocalService(
        QuangCaoLocalService quangCaoLocalService) {
        this.quangCaoLocalService = quangCaoLocalService;
    }

    public QuangCaoService getQuangCaoService() {
        return quangCaoService;
    }

    public void setQuangCaoService(QuangCaoService quangCaoService) {
        this.quangCaoService = quangCaoService;
    }

    public QuangCaoPersistence getQuangCaoPersistence() {
        return quangCaoPersistence;
    }

    public void setQuangCaoPersistence(QuangCaoPersistence quangCaoPersistence) {
        this.quangCaoPersistence = quangCaoPersistence;
    }

    public QuangCaoFinder getQuangCaoFinder() {
        return quangCaoFinder;
    }

    public void setQuangCaoFinder(QuangCaoFinder quangCaoFinder) {
        this.quangCaoFinder = quangCaoFinder;
    }

    protected void runSQL(String sql) throws SystemException {
        try {
            PortalUtil.runSQL(sql);
        } catch (Exception e) {
            throw new SystemException(e);
        }
    }
}
