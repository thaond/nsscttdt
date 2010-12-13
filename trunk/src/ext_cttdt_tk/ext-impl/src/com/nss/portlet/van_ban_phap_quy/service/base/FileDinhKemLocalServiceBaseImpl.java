package com.nss.portlet.van_ban_phap_quy.service.base;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.util.PortalUtil;

import com.nss.portlet.van_ban_phap_quy.model.FileDinhKem;
import com.nss.portlet.van_ban_phap_quy.service.FileDinhKemLocalService;
import com.nss.portlet.van_ban_phap_quy.service.FileDinhKemService;
import com.nss.portlet.van_ban_phap_quy.service.VanBanPhapQuyLocalService;
import com.nss.portlet.van_ban_phap_quy.service.VanBanPhapQuyService;
import com.nss.portlet.van_ban_phap_quy.service.persistence.FileDinhKemFinder;
import com.nss.portlet.van_ban_phap_quy.service.persistence.FileDinhKemPersistence;
import com.nss.portlet.van_ban_phap_quy.service.persistence.VanBanPhapQuyFinder;
import com.nss.portlet.van_ban_phap_quy.service.persistence.VanBanPhapQuyPersistence;

import java.util.List;


public abstract class FileDinhKemLocalServiceBaseImpl
    implements FileDinhKemLocalService {
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

    public FileDinhKem addFileDinhKem(FileDinhKem fileDinhKem)
        throws SystemException {
        fileDinhKem.setNew(true);

        return fileDinhKemPersistence.update(fileDinhKem, false);
    }

    public FileDinhKem createFileDinhKem(long maFileDinhKem) {
        return fileDinhKemPersistence.create(maFileDinhKem);
    }

    public void deleteFileDinhKem(long maFileDinhKem)
        throws PortalException, SystemException {
        fileDinhKemPersistence.remove(maFileDinhKem);
    }

    public void deleteFileDinhKem(FileDinhKem fileDinhKem)
        throws SystemException {
        fileDinhKemPersistence.remove(fileDinhKem);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return fileDinhKemPersistence.findWithDynamicQuery(dynamicQuery);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery, int start,
        int end) throws SystemException {
        return fileDinhKemPersistence.findWithDynamicQuery(dynamicQuery, start,
            end);
    }

    public FileDinhKem getFileDinhKem(long maFileDinhKem)
        throws PortalException, SystemException {
        return fileDinhKemPersistence.findByPrimaryKey(maFileDinhKem);
    }

    public List<FileDinhKem> getFileDinhKems(int start, int end)
        throws SystemException {
        return fileDinhKemPersistence.findAll(start, end);
    }

    public int getFileDinhKemsCount() throws SystemException {
        return fileDinhKemPersistence.countAll();
    }

    public FileDinhKem updateFileDinhKem(FileDinhKem fileDinhKem)
        throws SystemException {
        fileDinhKem.setNew(false);

        return fileDinhKemPersistence.update(fileDinhKem, true);
    }

    public FileDinhKem updateFileDinhKem(FileDinhKem fileDinhKem, boolean merge)
        throws SystemException {
        fileDinhKem.setNew(false);

        return fileDinhKemPersistence.update(fileDinhKem, merge);
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
