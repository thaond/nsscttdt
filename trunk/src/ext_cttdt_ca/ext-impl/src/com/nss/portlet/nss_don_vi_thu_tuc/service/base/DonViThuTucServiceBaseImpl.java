package com.nss.portlet.nss_don_vi_thu_tuc.service.base;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.service.base.PrincipalBean;
import com.liferay.portal.util.PortalUtil;

import com.nss.portlet.nss_don_vi_thu_tuc.service.DonViThuTucLocalService;
import com.nss.portlet.nss_don_vi_thu_tuc.service.DonViThuTucService;
import com.nss.portlet.nss_don_vi_thu_tuc.service.persistence.DonViThuTucFinder;
import com.nss.portlet.nss_don_vi_thu_tuc.service.persistence.DonViThuTucPersistence;


public abstract class DonViThuTucServiceBaseImpl extends PrincipalBean
    implements DonViThuTucService {
    @BeanReference(name = "com.nss.portlet.nss_don_vi_thu_tuc.service.DonViThuTucLocalService.impl")
    protected DonViThuTucLocalService donViThuTucLocalService;
    @BeanReference(name = "com.nss.portlet.nss_don_vi_thu_tuc.service.DonViThuTucService.impl")
    protected DonViThuTucService donViThuTucService;
    @BeanReference(name = "com.nss.portlet.nss_don_vi_thu_tuc.service.persistence.DonViThuTucPersistence.impl")
    protected DonViThuTucPersistence donViThuTucPersistence;
    @BeanReference(name = "com.nss.portlet.nss_don_vi_thu_tuc.service.persistence.DonViThuTucFinder.impl")
    protected DonViThuTucFinder donViThuTucFinder;

    public DonViThuTucLocalService getDonViThuTucLocalService() {
        return donViThuTucLocalService;
    }

    public void setDonViThuTucLocalService(
        DonViThuTucLocalService donViThuTucLocalService) {
        this.donViThuTucLocalService = donViThuTucLocalService;
    }

    public DonViThuTucService getDonViThuTucService() {
        return donViThuTucService;
    }

    public void setDonViThuTucService(DonViThuTucService donViThuTucService) {
        this.donViThuTucService = donViThuTucService;
    }

    public DonViThuTucPersistence getDonViThuTucPersistence() {
        return donViThuTucPersistence;
    }

    public void setDonViThuTucPersistence(
        DonViThuTucPersistence donViThuTucPersistence) {
        this.donViThuTucPersistence = donViThuTucPersistence;
    }

    public DonViThuTucFinder getDonViThuTucFinder() {
        return donViThuTucFinder;
    }

    public void setDonViThuTucFinder(DonViThuTucFinder donViThuTucFinder) {
        this.donViThuTucFinder = donViThuTucFinder;
    }

    protected void runSQL(String sql) throws SystemException {
        try {
            PortalUtil.runSQL(sql);
        } catch (Exception e) {
            throw new SystemException(e);
        }
    }
}
