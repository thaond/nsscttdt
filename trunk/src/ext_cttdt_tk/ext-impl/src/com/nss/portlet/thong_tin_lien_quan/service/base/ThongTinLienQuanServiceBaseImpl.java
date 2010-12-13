package com.nss.portlet.thong_tin_lien_quan.service.base;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.service.base.PrincipalBean;
import com.liferay.portal.util.PortalUtil;

import com.nss.portlet.thong_tin_lien_quan.service.ThongTinLienQuanLocalService;
import com.nss.portlet.thong_tin_lien_quan.service.ThongTinLienQuanService;
import com.nss.portlet.thong_tin_lien_quan.service.persistence.ThongTinLienQuanFinder;
import com.nss.portlet.thong_tin_lien_quan.service.persistence.ThongTinLienQuanPersistence;


public abstract class ThongTinLienQuanServiceBaseImpl extends PrincipalBean
    implements ThongTinLienQuanService {
    @BeanReference(name = "com.nss.portlet.thong_tin_lien_quan.service.ThongTinLienQuanLocalService.impl")
    protected ThongTinLienQuanLocalService thongTinLienQuanLocalService;
    @BeanReference(name = "com.nss.portlet.thong_tin_lien_quan.service.ThongTinLienQuanService.impl")
    protected ThongTinLienQuanService thongTinLienQuanService;
    @BeanReference(name = "com.nss.portlet.thong_tin_lien_quan.service.persistence.ThongTinLienQuanPersistence.impl")
    protected ThongTinLienQuanPersistence thongTinLienQuanPersistence;
    @BeanReference(name = "com.nss.portlet.thong_tin_lien_quan.service.persistence.ThongTinLienQuanFinder.impl")
    protected ThongTinLienQuanFinder thongTinLienQuanFinder;

    public ThongTinLienQuanLocalService getThongTinLienQuanLocalService() {
        return thongTinLienQuanLocalService;
    }

    public void setThongTinLienQuanLocalService(
        ThongTinLienQuanLocalService thongTinLienQuanLocalService) {
        this.thongTinLienQuanLocalService = thongTinLienQuanLocalService;
    }

    public ThongTinLienQuanService getThongTinLienQuanService() {
        return thongTinLienQuanService;
    }

    public void setThongTinLienQuanService(
        ThongTinLienQuanService thongTinLienQuanService) {
        this.thongTinLienQuanService = thongTinLienQuanService;
    }

    public ThongTinLienQuanPersistence getThongTinLienQuanPersistence() {
        return thongTinLienQuanPersistence;
    }

    public void setThongTinLienQuanPersistence(
        ThongTinLienQuanPersistence thongTinLienQuanPersistence) {
        this.thongTinLienQuanPersistence = thongTinLienQuanPersistence;
    }

    public ThongTinLienQuanFinder getThongTinLienQuanFinder() {
        return thongTinLienQuanFinder;
    }

    public void setThongTinLienQuanFinder(
        ThongTinLienQuanFinder thongTinLienQuanFinder) {
        this.thongTinLienQuanFinder = thongTinLienQuanFinder;
    }

    protected void runSQL(String sql) throws SystemException {
        try {
            PortalUtil.runSQL(sql);
        } catch (Exception e) {
            throw new SystemException(e);
        }
    }
}
