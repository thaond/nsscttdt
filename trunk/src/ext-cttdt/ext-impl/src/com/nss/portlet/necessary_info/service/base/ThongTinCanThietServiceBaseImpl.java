package com.nss.portlet.necessary_info.service.base;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.service.base.PrincipalBean;
import com.liferay.portal.util.PortalUtil;

import com.nss.portlet.necessary_info.service.ThongTinCanThietLocalService;
import com.nss.portlet.necessary_info.service.ThongTinCanThietService;
import com.nss.portlet.necessary_info.service.persistence.ThongTinCanThietFinder;
import com.nss.portlet.necessary_info.service.persistence.ThongTinCanThietPersistence;


public abstract class ThongTinCanThietServiceBaseImpl extends PrincipalBean
    implements ThongTinCanThietService {
    @BeanReference(name = "com.nss.portlet.necessary_info.service.ThongTinCanThietLocalService.impl")
    protected ThongTinCanThietLocalService thongTinCanThietLocalService;
    @BeanReference(name = "com.nss.portlet.necessary_info.service.ThongTinCanThietService.impl")
    protected ThongTinCanThietService thongTinCanThietService;
    @BeanReference(name = "com.nss.portlet.necessary_info.service.persistence.ThongTinCanThietPersistence.impl")
    protected ThongTinCanThietPersistence thongTinCanThietPersistence;
    @BeanReference(name = "com.nss.portlet.necessary_info.service.persistence.ThongTinCanThietFinder.impl")
    protected ThongTinCanThietFinder thongTinCanThietFinder;

    public ThongTinCanThietLocalService getThongTinCanThietLocalService() {
        return thongTinCanThietLocalService;
    }

    public void setThongTinCanThietLocalService(
        ThongTinCanThietLocalService thongTinCanThietLocalService) {
        this.thongTinCanThietLocalService = thongTinCanThietLocalService;
    }

    public ThongTinCanThietService getThongTinCanThietService() {
        return thongTinCanThietService;
    }

    public void setThongTinCanThietService(
        ThongTinCanThietService thongTinCanThietService) {
        this.thongTinCanThietService = thongTinCanThietService;
    }

    public ThongTinCanThietPersistence getThongTinCanThietPersistence() {
        return thongTinCanThietPersistence;
    }

    public void setThongTinCanThietPersistence(
        ThongTinCanThietPersistence thongTinCanThietPersistence) {
        this.thongTinCanThietPersistence = thongTinCanThietPersistence;
    }

    public ThongTinCanThietFinder getThongTinCanThietFinder() {
        return thongTinCanThietFinder;
    }

    public void setThongTinCanThietFinder(
        ThongTinCanThietFinder thongTinCanThietFinder) {
        this.thongTinCanThietFinder = thongTinCanThietFinder;
    }

    protected void runSQL(String sql) throws SystemException {
        try {
            PortalUtil.runSQL(sql);
        } catch (Exception e) {
            throw new SystemException(e);
        }
    }
}
