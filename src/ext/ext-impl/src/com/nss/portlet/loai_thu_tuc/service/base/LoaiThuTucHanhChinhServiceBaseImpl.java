package com.nss.portlet.loai_thu_tuc.service.base;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.service.base.PrincipalBean;
import com.liferay.portal.util.PortalUtil;

import com.nss.portlet.loai_thu_tuc.service.LoaiThuTucHanhChinhLocalService;
import com.nss.portlet.loai_thu_tuc.service.LoaiThuTucHanhChinhService;
import com.nss.portlet.loai_thu_tuc.service.persistence.LoaiThuTucHanhChinhFinder;
import com.nss.portlet.loai_thu_tuc.service.persistence.LoaiThuTucHanhChinhPersistence;


public abstract class LoaiThuTucHanhChinhServiceBaseImpl extends PrincipalBean
    implements LoaiThuTucHanhChinhService {
    @BeanReference(name = "com.nss.portlet.loai_thu_tuc.service.LoaiThuTucHanhChinhLocalService.impl")
    protected LoaiThuTucHanhChinhLocalService loaiThuTucHanhChinhLocalService;
    @BeanReference(name = "com.nss.portlet.loai_thu_tuc.service.LoaiThuTucHanhChinhService.impl")
    protected LoaiThuTucHanhChinhService loaiThuTucHanhChinhService;
    @BeanReference(name = "com.nss.portlet.loai_thu_tuc.service.persistence.LoaiThuTucHanhChinhPersistence.impl")
    protected LoaiThuTucHanhChinhPersistence loaiThuTucHanhChinhPersistence;
    @BeanReference(name = "com.nss.portlet.loai_thu_tuc.service.persistence.LoaiThuTucHanhChinhFinder.impl")
    protected LoaiThuTucHanhChinhFinder loaiThuTucHanhChinhFinder;

    public LoaiThuTucHanhChinhLocalService getLoaiThuTucHanhChinhLocalService() {
        return loaiThuTucHanhChinhLocalService;
    }

    public void setLoaiThuTucHanhChinhLocalService(
        LoaiThuTucHanhChinhLocalService loaiThuTucHanhChinhLocalService) {
        this.loaiThuTucHanhChinhLocalService = loaiThuTucHanhChinhLocalService;
    }

    public LoaiThuTucHanhChinhService getLoaiThuTucHanhChinhService() {
        return loaiThuTucHanhChinhService;
    }

    public void setLoaiThuTucHanhChinhService(
        LoaiThuTucHanhChinhService loaiThuTucHanhChinhService) {
        this.loaiThuTucHanhChinhService = loaiThuTucHanhChinhService;
    }

    public LoaiThuTucHanhChinhPersistence getLoaiThuTucHanhChinhPersistence() {
        return loaiThuTucHanhChinhPersistence;
    }

    public void setLoaiThuTucHanhChinhPersistence(
        LoaiThuTucHanhChinhPersistence loaiThuTucHanhChinhPersistence) {
        this.loaiThuTucHanhChinhPersistence = loaiThuTucHanhChinhPersistence;
    }

    public LoaiThuTucHanhChinhFinder getLoaiThuTucHanhChinhFinder() {
        return loaiThuTucHanhChinhFinder;
    }

    public void setLoaiThuTucHanhChinhFinder(
        LoaiThuTucHanhChinhFinder loaiThuTucHanhChinhFinder) {
        this.loaiThuTucHanhChinhFinder = loaiThuTucHanhChinhFinder;
    }

    protected void runSQL(String sql) throws SystemException {
        try {
            PortalUtil.runSQL(sql);
        } catch (Exception e) {
            throw new SystemException(e);
        }
    }
}
