package com.nss.portlet.co_quan_ban_hanh.service.base;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.service.base.PrincipalBean;
import com.liferay.portal.util.PortalUtil;

import com.nss.portlet.co_quan_ban_hanh.service.CoQuanBanHanhLocalService;
import com.nss.portlet.co_quan_ban_hanh.service.CoQuanBanHanhService;
import com.nss.portlet.co_quan_ban_hanh.service.persistence.CoQuanBanHanhFinder;
import com.nss.portlet.co_quan_ban_hanh.service.persistence.CoQuanBanHanhPersistence;


public abstract class CoQuanBanHanhServiceBaseImpl extends PrincipalBean
    implements CoQuanBanHanhService {
    @BeanReference(name = "com.nss.portlet.co_quan_ban_hanh.service.CoQuanBanHanhLocalService.impl")
    protected CoQuanBanHanhLocalService coQuanBanHanhLocalService;
    @BeanReference(name = "com.nss.portlet.co_quan_ban_hanh.service.CoQuanBanHanhService.impl")
    protected CoQuanBanHanhService coQuanBanHanhService;
    @BeanReference(name = "com.nss.portlet.co_quan_ban_hanh.service.persistence.CoQuanBanHanhPersistence.impl")
    protected CoQuanBanHanhPersistence coQuanBanHanhPersistence;
    @BeanReference(name = "com.nss.portlet.co_quan_ban_hanh.service.persistence.CoQuanBanHanhFinder.impl")
    protected CoQuanBanHanhFinder coQuanBanHanhFinder;

    public CoQuanBanHanhLocalService getCoQuanBanHanhLocalService() {
        return coQuanBanHanhLocalService;
    }

    public void setCoQuanBanHanhLocalService(
        CoQuanBanHanhLocalService coQuanBanHanhLocalService) {
        this.coQuanBanHanhLocalService = coQuanBanHanhLocalService;
    }

    public CoQuanBanHanhService getCoQuanBanHanhService() {
        return coQuanBanHanhService;
    }

    public void setCoQuanBanHanhService(
        CoQuanBanHanhService coQuanBanHanhService) {
        this.coQuanBanHanhService = coQuanBanHanhService;
    }

    public CoQuanBanHanhPersistence getCoQuanBanHanhPersistence() {
        return coQuanBanHanhPersistence;
    }

    public void setCoQuanBanHanhPersistence(
        CoQuanBanHanhPersistence coQuanBanHanhPersistence) {
        this.coQuanBanHanhPersistence = coQuanBanHanhPersistence;
    }

    public CoQuanBanHanhFinder getCoQuanBanHanhFinder() {
        return coQuanBanHanhFinder;
    }

    public void setCoQuanBanHanhFinder(CoQuanBanHanhFinder coQuanBanHanhFinder) {
        this.coQuanBanHanhFinder = coQuanBanHanhFinder;
    }

    protected void runSQL(String sql) throws SystemException {
        try {
            PortalUtil.runSQL(sql);
        } catch (Exception e) {
            throw new SystemException(e);
        }
    }
}
