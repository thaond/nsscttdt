package com.nss.portlet.van_ban_phap_quy.service.base;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.service.base.PrincipalBean;
import com.liferay.portal.util.PortalUtil;

import com.nss.portlet.van_ban_phap_quy.service.FileDinhKemLocalService;
import com.nss.portlet.van_ban_phap_quy.service.FileDinhKemService;
import com.nss.portlet.van_ban_phap_quy.service.VanBanPhapQuyLocalService;
import com.nss.portlet.van_ban_phap_quy.service.VanBanPhapQuyService;
import com.nss.portlet.van_ban_phap_quy.service.persistence.FileDinhKemFinder;
import com.nss.portlet.van_ban_phap_quy.service.persistence.FileDinhKemPersistence;
import com.nss.portlet.van_ban_phap_quy.service.persistence.VanBanPhapQuyFinder;
import com.nss.portlet.van_ban_phap_quy.service.persistence.VanBanPhapQuyPersistence;


public abstract class VanBanPhapQuyServiceBaseImpl extends PrincipalBean
    implements VanBanPhapQuyService {
    @BeanReference(name = "com.nss.portlet.van_ban_phap_quy.service.VanBanPhapQuyLocalService.impl")
    protected VanBanPhapQuyLocalService vanBanPhapQuyLocalService;
    @BeanReference(name = "com.nss.portlet.van_ban_phap_quy.service.VanBanPhapQuyService.impl")
    protected VanBanPhapQuyService vanBanPhapQuyService;
    @BeanReference(name = "com.nss.portlet.van_ban_phap_quy.service.persistence.VanBanPhapQuyPersistence.impl")
    protected VanBanPhapQuyPersistence vanBanPhapQuyPersistence;
    @BeanReference(name = "com.nss.portlet.van_ban_phap_quy.service.persistence.VanBanPhapQuyFinder.impl")
    protected VanBanPhapQuyFinder vanBanPhapQuyFinder;
    @BeanReference(name = "com.nss.portlet.van_ban_phap_quy.service.FileDinhKemLocalService.impl")
    protected FileDinhKemLocalService fileDinhKemLocalService;
    @BeanReference(name = "com.nss.portlet.van_ban_phap_quy.service.FileDinhKemService.impl")
    protected FileDinhKemService fileDinhKemService;
    @BeanReference(name = "com.nss.portlet.van_ban_phap_quy.service.persistence.FileDinhKemPersistence.impl")
    protected FileDinhKemPersistence fileDinhKemPersistence;
    @BeanReference(name = "com.nss.portlet.van_ban_phap_quy.service.persistence.FileDinhKemFinder.impl")
    protected FileDinhKemFinder fileDinhKemFinder;

    public VanBanPhapQuyLocalService getVanBanPhapQuyLocalService() {
        return vanBanPhapQuyLocalService;
    }

    public void setVanBanPhapQuyLocalService(
        VanBanPhapQuyLocalService vanBanPhapQuyLocalService) {
        this.vanBanPhapQuyLocalService = vanBanPhapQuyLocalService;
    }

    public VanBanPhapQuyService getVanBanPhapQuyService() {
        return vanBanPhapQuyService;
    }

    public void setVanBanPhapQuyService(
        VanBanPhapQuyService vanBanPhapQuyService) {
        this.vanBanPhapQuyService = vanBanPhapQuyService;
    }

    public VanBanPhapQuyPersistence getVanBanPhapQuyPersistence() {
        return vanBanPhapQuyPersistence;
    }

    public void setVanBanPhapQuyPersistence(
        VanBanPhapQuyPersistence vanBanPhapQuyPersistence) {
        this.vanBanPhapQuyPersistence = vanBanPhapQuyPersistence;
    }

    public VanBanPhapQuyFinder getVanBanPhapQuyFinder() {
        return vanBanPhapQuyFinder;
    }

    public void setVanBanPhapQuyFinder(VanBanPhapQuyFinder vanBanPhapQuyFinder) {
        this.vanBanPhapQuyFinder = vanBanPhapQuyFinder;
    }

    public FileDinhKemLocalService getFileDinhKemLocalService() {
        return fileDinhKemLocalService;
    }

    public void setFileDinhKemLocalService(
        FileDinhKemLocalService fileDinhKemLocalService) {
        this.fileDinhKemLocalService = fileDinhKemLocalService;
    }

    public FileDinhKemService getFileDinhKemService() {
        return fileDinhKemService;
    }

    public void setFileDinhKemService(FileDinhKemService fileDinhKemService) {
        this.fileDinhKemService = fileDinhKemService;
    }

    public FileDinhKemPersistence getFileDinhKemPersistence() {
        return fileDinhKemPersistence;
    }

    public void setFileDinhKemPersistence(
        FileDinhKemPersistence fileDinhKemPersistence) {
        this.fileDinhKemPersistence = fileDinhKemPersistence;
    }

    public FileDinhKemFinder getFileDinhKemFinder() {
        return fileDinhKemFinder;
    }

    public void setFileDinhKemFinder(FileDinhKemFinder fileDinhKemFinder) {
        this.fileDinhKemFinder = fileDinhKemFinder;
    }

    protected void runSQL(String sql) throws SystemException {
        try {
            PortalUtil.runSQL(sql);
        } catch (Exception e) {
            throw new SystemException(e);
        }
    }
}
