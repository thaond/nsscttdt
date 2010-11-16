package com.nss.portlet.thu_tuc_hanh_chinh.service.base;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.util.PortalUtil;

import com.nss.portlet.thu_tuc_hanh_chinh.model.FileDinhKemTTHC;
import com.nss.portlet.thu_tuc_hanh_chinh.service.FileDinhKemTTHCLocalService;
import com.nss.portlet.thu_tuc_hanh_chinh.service.FileDinhKemTTHCService;
import com.nss.portlet.thu_tuc_hanh_chinh.service.ThuTucHanhChinhLocalService;
import com.nss.portlet.thu_tuc_hanh_chinh.service.ThuTucHanhChinhService;
import com.nss.portlet.thu_tuc_hanh_chinh.service.persistence.FileDinhKemTTHCFinder;
import com.nss.portlet.thu_tuc_hanh_chinh.service.persistence.FileDinhKemTTHCPersistence;
import com.nss.portlet.thu_tuc_hanh_chinh.service.persistence.ThuTucHanhChinhFinder;
import com.nss.portlet.thu_tuc_hanh_chinh.service.persistence.ThuTucHanhChinhPersistence;

import java.util.List;


public abstract class FileDinhKemTTHCLocalServiceBaseImpl
    implements FileDinhKemTTHCLocalService {
    @BeanReference(name = "com.nss.portlet.thu_tuc_hanh_chinh.service.ThuTucHanhChinhLocalService.impl")
    protected ThuTucHanhChinhLocalService thuTucHanhChinhLocalService;
    @BeanReference(name = "com.nss.portlet.thu_tuc_hanh_chinh.service.ThuTucHanhChinhService.impl")
    protected ThuTucHanhChinhService thuTucHanhChinhService;
    @BeanReference(name = "com.nss.portlet.thu_tuc_hanh_chinh.service.persistence.ThuTucHanhChinhPersistence.impl")
    protected ThuTucHanhChinhPersistence thuTucHanhChinhPersistence;
    @BeanReference(name = "com.nss.portlet.thu_tuc_hanh_chinh.service.persistence.ThuTucHanhChinhFinder.impl")
    protected ThuTucHanhChinhFinder thuTucHanhChinhFinder;
    @BeanReference(name = "com.nss.portlet.thu_tuc_hanh_chinh.service.FileDinhKemTTHCLocalService.impl")
    protected FileDinhKemTTHCLocalService fileDinhKemTTHCLocalService;
    @BeanReference(name = "com.nss.portlet.thu_tuc_hanh_chinh.service.FileDinhKemTTHCService.impl")
    protected FileDinhKemTTHCService fileDinhKemTTHCService;
    @BeanReference(name = "com.nss.portlet.thu_tuc_hanh_chinh.service.persistence.FileDinhKemTTHCPersistence.impl")
    protected FileDinhKemTTHCPersistence fileDinhKemTTHCPersistence;
    @BeanReference(name = "com.nss.portlet.thu_tuc_hanh_chinh.service.persistence.FileDinhKemTTHCFinder.impl")
    protected FileDinhKemTTHCFinder fileDinhKemTTHCFinder;

    public FileDinhKemTTHC addFileDinhKemTTHC(FileDinhKemTTHC fileDinhKemTTHC)
        throws SystemException {
        fileDinhKemTTHC.setNew(true);

        return fileDinhKemTTHCPersistence.update(fileDinhKemTTHC, false);
    }

    public FileDinhKemTTHC createFileDinhKemTTHC(long maFileDinhKemTTHC) {
        return fileDinhKemTTHCPersistence.create(maFileDinhKemTTHC);
    }

    public void deleteFileDinhKemTTHC(long maFileDinhKemTTHC)
        throws PortalException, SystemException {
        fileDinhKemTTHCPersistence.remove(maFileDinhKemTTHC);
    }

    public void deleteFileDinhKemTTHC(FileDinhKemTTHC fileDinhKemTTHC)
        throws SystemException {
        fileDinhKemTTHCPersistence.remove(fileDinhKemTTHC);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return fileDinhKemTTHCPersistence.findWithDynamicQuery(dynamicQuery);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery, int start,
        int end) throws SystemException {
        return fileDinhKemTTHCPersistence.findWithDynamicQuery(dynamicQuery,
            start, end);
    }

    public FileDinhKemTTHC getFileDinhKemTTHC(long maFileDinhKemTTHC)
        throws PortalException, SystemException {
        return fileDinhKemTTHCPersistence.findByPrimaryKey(maFileDinhKemTTHC);
    }

    public List<FileDinhKemTTHC> getFileDinhKemTTHCs(int start, int end)
        throws SystemException {
        return fileDinhKemTTHCPersistence.findAll(start, end);
    }

    public int getFileDinhKemTTHCsCount() throws SystemException {
        return fileDinhKemTTHCPersistence.countAll();
    }

    public FileDinhKemTTHC updateFileDinhKemTTHC(
        FileDinhKemTTHC fileDinhKemTTHC) throws SystemException {
        fileDinhKemTTHC.setNew(false);

        return fileDinhKemTTHCPersistence.update(fileDinhKemTTHC, true);
    }

    public FileDinhKemTTHC updateFileDinhKemTTHC(
        FileDinhKemTTHC fileDinhKemTTHC, boolean merge)
        throws SystemException {
        fileDinhKemTTHC.setNew(false);

        return fileDinhKemTTHCPersistence.update(fileDinhKemTTHC, merge);
    }

    public ThuTucHanhChinhLocalService getThuTucHanhChinhLocalService() {
        return thuTucHanhChinhLocalService;
    }

    public void setThuTucHanhChinhLocalService(
        ThuTucHanhChinhLocalService thuTucHanhChinhLocalService) {
        this.thuTucHanhChinhLocalService = thuTucHanhChinhLocalService;
    }

    public ThuTucHanhChinhService getThuTucHanhChinhService() {
        return thuTucHanhChinhService;
    }

    public void setThuTucHanhChinhService(
        ThuTucHanhChinhService thuTucHanhChinhService) {
        this.thuTucHanhChinhService = thuTucHanhChinhService;
    }

    public ThuTucHanhChinhPersistence getThuTucHanhChinhPersistence() {
        return thuTucHanhChinhPersistence;
    }

    public void setThuTucHanhChinhPersistence(
        ThuTucHanhChinhPersistence thuTucHanhChinhPersistence) {
        this.thuTucHanhChinhPersistence = thuTucHanhChinhPersistence;
    }

    public ThuTucHanhChinhFinder getThuTucHanhChinhFinder() {
        return thuTucHanhChinhFinder;
    }

    public void setThuTucHanhChinhFinder(
        ThuTucHanhChinhFinder thuTucHanhChinhFinder) {
        this.thuTucHanhChinhFinder = thuTucHanhChinhFinder;
    }

    public FileDinhKemTTHCLocalService getFileDinhKemTTHCLocalService() {
        return fileDinhKemTTHCLocalService;
    }

    public void setFileDinhKemTTHCLocalService(
        FileDinhKemTTHCLocalService fileDinhKemTTHCLocalService) {
        this.fileDinhKemTTHCLocalService = fileDinhKemTTHCLocalService;
    }

    public FileDinhKemTTHCService getFileDinhKemTTHCService() {
        return fileDinhKemTTHCService;
    }

    public void setFileDinhKemTTHCService(
        FileDinhKemTTHCService fileDinhKemTTHCService) {
        this.fileDinhKemTTHCService = fileDinhKemTTHCService;
    }

    public FileDinhKemTTHCPersistence getFileDinhKemTTHCPersistence() {
        return fileDinhKemTTHCPersistence;
    }

    public void setFileDinhKemTTHCPersistence(
        FileDinhKemTTHCPersistence fileDinhKemTTHCPersistence) {
        this.fileDinhKemTTHCPersistence = fileDinhKemTTHCPersistence;
    }

    public FileDinhKemTTHCFinder getFileDinhKemTTHCFinder() {
        return fileDinhKemTTHCFinder;
    }

    public void setFileDinhKemTTHCFinder(
        FileDinhKemTTHCFinder fileDinhKemTTHCFinder) {
        this.fileDinhKemTTHCFinder = fileDinhKemTTHCFinder;
    }

    protected void runSQL(String sql) throws SystemException {
        try {
            PortalUtil.runSQL(sql);
        } catch (Exception e) {
            throw new SystemException(e);
        }
    }
}
