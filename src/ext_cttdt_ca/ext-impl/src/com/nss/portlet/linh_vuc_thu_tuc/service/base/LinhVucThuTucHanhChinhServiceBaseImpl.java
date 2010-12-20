package com.nss.portlet.linh_vuc_thu_tuc.service.base;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.service.base.PrincipalBean;
import com.liferay.portal.util.PortalUtil;

import com.nss.portlet.linh_vuc_thu_tuc.service.LinhVucThuTucHanhChinhLocalService;
import com.nss.portlet.linh_vuc_thu_tuc.service.LinhVucThuTucHanhChinhService;
import com.nss.portlet.linh_vuc_thu_tuc.service.persistence.LinhVucThuTucHanhChinhFinder;
import com.nss.portlet.linh_vuc_thu_tuc.service.persistence.LinhVucThuTucHanhChinhPersistence;


public abstract class LinhVucThuTucHanhChinhServiceBaseImpl
    extends PrincipalBean implements LinhVucThuTucHanhChinhService {
    @BeanReference(name = "com.nss.portlet.linh_vuc_thu_tuc.service.LinhVucThuTucHanhChinhLocalService.impl")
    protected LinhVucThuTucHanhChinhLocalService linhVucThuTucHanhChinhLocalService;
    @BeanReference(name = "com.nss.portlet.linh_vuc_thu_tuc.service.LinhVucThuTucHanhChinhService.impl")
    protected LinhVucThuTucHanhChinhService linhVucThuTucHanhChinhService;
    @BeanReference(name = "com.nss.portlet.linh_vuc_thu_tuc.service.persistence.LinhVucThuTucHanhChinhPersistence.impl")
    protected LinhVucThuTucHanhChinhPersistence linhVucThuTucHanhChinhPersistence;
    @BeanReference(name = "com.nss.portlet.linh_vuc_thu_tuc.service.persistence.LinhVucThuTucHanhChinhFinder.impl")
    protected LinhVucThuTucHanhChinhFinder linhVucThuTucHanhChinhFinder;

    public LinhVucThuTucHanhChinhLocalService getLinhVucThuTucHanhChinhLocalService() {
        return linhVucThuTucHanhChinhLocalService;
    }

    public void setLinhVucThuTucHanhChinhLocalService(
        LinhVucThuTucHanhChinhLocalService linhVucThuTucHanhChinhLocalService) {
        this.linhVucThuTucHanhChinhLocalService = linhVucThuTucHanhChinhLocalService;
    }

    public LinhVucThuTucHanhChinhService getLinhVucThuTucHanhChinhService() {
        return linhVucThuTucHanhChinhService;
    }

    public void setLinhVucThuTucHanhChinhService(
        LinhVucThuTucHanhChinhService linhVucThuTucHanhChinhService) {
        this.linhVucThuTucHanhChinhService = linhVucThuTucHanhChinhService;
    }

    public LinhVucThuTucHanhChinhPersistence getLinhVucThuTucHanhChinhPersistence() {
        return linhVucThuTucHanhChinhPersistence;
    }

    public void setLinhVucThuTucHanhChinhPersistence(
        LinhVucThuTucHanhChinhPersistence linhVucThuTucHanhChinhPersistence) {
        this.linhVucThuTucHanhChinhPersistence = linhVucThuTucHanhChinhPersistence;
    }

    public LinhVucThuTucHanhChinhFinder getLinhVucThuTucHanhChinhFinder() {
        return linhVucThuTucHanhChinhFinder;
    }

    public void setLinhVucThuTucHanhChinhFinder(
        LinhVucThuTucHanhChinhFinder linhVucThuTucHanhChinhFinder) {
        this.linhVucThuTucHanhChinhFinder = linhVucThuTucHanhChinhFinder;
    }

    protected void runSQL(String sql) throws SystemException {
        try {
            PortalUtil.runSQL(sql);
        } catch (Exception e) {
            throw new SystemException(e);
        }
    }
}
