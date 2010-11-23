package com.nss.portlet.nss_don_vi_thu_tuc.service.base;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.util.PortalUtil;

import com.nss.portlet.nss_don_vi_thu_tuc.model.DonViThuTuc;
import com.nss.portlet.nss_don_vi_thu_tuc.service.DonViThuTucLocalService;
import com.nss.portlet.nss_don_vi_thu_tuc.service.DonViThuTucService;
import com.nss.portlet.nss_don_vi_thu_tuc.service.persistence.DonViThuTucFinder;
import com.nss.portlet.nss_don_vi_thu_tuc.service.persistence.DonViThuTucPersistence;

import java.util.List;


public abstract class DonViThuTucLocalServiceBaseImpl
    implements DonViThuTucLocalService {
    @BeanReference(name = "com.nss.portlet.nss_don_vi_thu_tuc.service.DonViThuTucLocalService.impl")
    protected DonViThuTucLocalService donViThuTucLocalService;
    @BeanReference(name = "com.nss.portlet.nss_don_vi_thu_tuc.service.DonViThuTucService.impl")
    protected DonViThuTucService donViThuTucService;
    @BeanReference(name = "com.nss.portlet.nss_don_vi_thu_tuc.service.persistence.DonViThuTucPersistence.impl")
    protected DonViThuTucPersistence donViThuTucPersistence;
    @BeanReference(name = "com.nss.portlet.nss_don_vi_thu_tuc.service.persistence.DonViThuTucFinder.impl")
    protected DonViThuTucFinder donViThuTucFinder;

    public DonViThuTuc addDonViThuTuc(DonViThuTuc donViThuTuc)
        throws SystemException {
        donViThuTuc.setNew(true);

        return donViThuTucPersistence.update(donViThuTuc, false);
    }

    public DonViThuTuc createDonViThuTuc(long maDonViThuTuc) {
        return donViThuTucPersistence.create(maDonViThuTuc);
    }

    public void deleteDonViThuTuc(long maDonViThuTuc)
        throws PortalException, SystemException {
        donViThuTucPersistence.remove(maDonViThuTuc);
    }

    public void deleteDonViThuTuc(DonViThuTuc donViThuTuc)
        throws SystemException {
        donViThuTucPersistence.remove(donViThuTuc);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return donViThuTucPersistence.findWithDynamicQuery(dynamicQuery);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery, int start,
        int end) throws SystemException {
        return donViThuTucPersistence.findWithDynamicQuery(dynamicQuery, start,
            end);
    }

    public DonViThuTuc getDonViThuTuc(long maDonViThuTuc)
        throws PortalException, SystemException {
        return donViThuTucPersistence.findByPrimaryKey(maDonViThuTuc);
    }

    public List<DonViThuTuc> getDonViThuTucs(int start, int end)
        throws SystemException {
        return donViThuTucPersistence.findAll(start, end);
    }

    public int getDonViThuTucsCount() throws SystemException {
        return donViThuTucPersistence.countAll();
    }

    public DonViThuTuc updateDonViThuTuc(DonViThuTuc donViThuTuc)
        throws SystemException {
        donViThuTuc.setNew(false);

        return donViThuTucPersistence.update(donViThuTuc, true);
    }

    public DonViThuTuc updateDonViThuTuc(DonViThuTuc donViThuTuc, boolean merge)
        throws SystemException {
        donViThuTuc.setNew(false);

        return donViThuTucPersistence.update(donViThuTuc, merge);
    }

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
