package com.nss.portlet.van_ban_phap_quy.service.base;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.util.PortalUtil;

import com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy;
import com.nss.portlet.van_ban_phap_quy.service.FileDinhKemLocalService;
import com.nss.portlet.van_ban_phap_quy.service.FileDinhKemService;
import com.nss.portlet.van_ban_phap_quy.service.VanBanPhapQuyLocalService;
import com.nss.portlet.van_ban_phap_quy.service.VanBanPhapQuyService;
import com.nss.portlet.van_ban_phap_quy.service.persistence.FileDinhKemFinder;
import com.nss.portlet.van_ban_phap_quy.service.persistence.FileDinhKemPersistence;
import com.nss.portlet.van_ban_phap_quy.service.persistence.VanBanPhapQuyFinder;
import com.nss.portlet.van_ban_phap_quy.service.persistence.VanBanPhapQuyPersistence;

import java.util.List;


public abstract class VanBanPhapQuyLocalServiceBaseImpl
    implements VanBanPhapQuyLocalService {
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

    public VanBanPhapQuy addVanBanPhapQuy(VanBanPhapQuy vanBanPhapQuy)
        throws SystemException {
        vanBanPhapQuy.setNew(true);

        return vanBanPhapQuyPersistence.update(vanBanPhapQuy, false);
    }

    public VanBanPhapQuy createVanBanPhapQuy(long maVanBanPhapQuy) {
        return vanBanPhapQuyPersistence.create(maVanBanPhapQuy);
    }

    public void deleteVanBanPhapQuy(long maVanBanPhapQuy)
        throws PortalException, SystemException {
        vanBanPhapQuyPersistence.remove(maVanBanPhapQuy);
    }

    public void deleteVanBanPhapQuy(VanBanPhapQuy vanBanPhapQuy)
        throws SystemException {
        vanBanPhapQuyPersistence.remove(vanBanPhapQuy);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return vanBanPhapQuyPersistence.findWithDynamicQuery(dynamicQuery);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery, int start,
        int end) throws SystemException {
        return vanBanPhapQuyPersistence.findWithDynamicQuery(dynamicQuery,
            start, end);
    }

    public VanBanPhapQuy getVanBanPhapQuy(long maVanBanPhapQuy)
        throws PortalException, SystemException {
        return vanBanPhapQuyPersistence.findByPrimaryKey(maVanBanPhapQuy);
    }

    public List<VanBanPhapQuy> getVanBanPhapQuies(int start, int end)
        throws SystemException {
        return vanBanPhapQuyPersistence.findAll(start, end);
    }

    public int getVanBanPhapQuiesCount() throws SystemException {
        return vanBanPhapQuyPersistence.countAll();
    }

    public VanBanPhapQuy updateVanBanPhapQuy(VanBanPhapQuy vanBanPhapQuy)
        throws SystemException {
        vanBanPhapQuy.setNew(false);

        return vanBanPhapQuyPersistence.update(vanBanPhapQuy, true);
    }

    public VanBanPhapQuy updateVanBanPhapQuy(VanBanPhapQuy vanBanPhapQuy,
        boolean merge) throws SystemException {
        vanBanPhapQuy.setNew(false);

        return vanBanPhapQuyPersistence.update(vanBanPhapQuy, merge);
    }

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
