package com.nss.portlet.thu_tuc_hanh_chinh.service.base;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.util.PortalUtil;

import com.nss.portlet.thu_tuc_hanh_chinh.model.ThuTucHanhChinh;
import com.nss.portlet.thu_tuc_hanh_chinh.service.FileDinhKemTTHCLocalService;
import com.nss.portlet.thu_tuc_hanh_chinh.service.FileDinhKemTTHCService;
import com.nss.portlet.thu_tuc_hanh_chinh.service.ThuTucHanhChinhLocalService;
import com.nss.portlet.thu_tuc_hanh_chinh.service.ThuTucHanhChinhService;
import com.nss.portlet.thu_tuc_hanh_chinh.service.persistence.FileDinhKemTTHCFinder;
import com.nss.portlet.thu_tuc_hanh_chinh.service.persistence.FileDinhKemTTHCPersistence;
import com.nss.portlet.thu_tuc_hanh_chinh.service.persistence.ThuTucHanhChinhFinder;
import com.nss.portlet.thu_tuc_hanh_chinh.service.persistence.ThuTucHanhChinhPersistence;

import java.util.List;


public abstract class ThuTucHanhChinhLocalServiceBaseImpl
    implements ThuTucHanhChinhLocalService {
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

    public ThuTucHanhChinh addThuTucHanhChinh(ThuTucHanhChinh thuTucHanhChinh)
        throws SystemException {
        thuTucHanhChinh.setNew(true);

        return thuTucHanhChinhPersistence.update(thuTucHanhChinh, false);
    }

    public ThuTucHanhChinh createThuTucHanhChinh(long maThuTucHanhChinh) {
        return thuTucHanhChinhPersistence.create(maThuTucHanhChinh);
    }

    public void deleteThuTucHanhChinh(long maThuTucHanhChinh)
        throws PortalException, SystemException {
        thuTucHanhChinhPersistence.remove(maThuTucHanhChinh);
    }

    public void deleteThuTucHanhChinh(ThuTucHanhChinh thuTucHanhChinh)
        throws SystemException {
        thuTucHanhChinhPersistence.remove(thuTucHanhChinh);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return thuTucHanhChinhPersistence.findWithDynamicQuery(dynamicQuery);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery, int start,
        int end) throws SystemException {
        return thuTucHanhChinhPersistence.findWithDynamicQuery(dynamicQuery,
            start, end);
    }

    public ThuTucHanhChinh getThuTucHanhChinh(long maThuTucHanhChinh)
        throws PortalException, SystemException {
        return thuTucHanhChinhPersistence.findByPrimaryKey(maThuTucHanhChinh);
    }

    public List<ThuTucHanhChinh> getThuTucHanhChinhs(int start, int end)
        throws SystemException {
        return thuTucHanhChinhPersistence.findAll(start, end);
    }

    public int getThuTucHanhChinhsCount() throws SystemException {
        return thuTucHanhChinhPersistence.countAll();
    }

    public ThuTucHanhChinh updateThuTucHanhChinh(
        ThuTucHanhChinh thuTucHanhChinh) throws SystemException {
        thuTucHanhChinh.setNew(false);

        return thuTucHanhChinhPersistence.update(thuTucHanhChinh, true);
    }

    public ThuTucHanhChinh updateThuTucHanhChinh(
        ThuTucHanhChinh thuTucHanhChinh, boolean merge)
        throws SystemException {
        thuTucHanhChinh.setNew(false);

        return thuTucHanhChinhPersistence.update(thuTucHanhChinh, merge);
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
