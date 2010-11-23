package com.nss.portlet.loai_van_ban.service.base;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.service.base.PrincipalBean;
import com.liferay.portal.util.PortalUtil;

import com.nss.portlet.loai_van_ban.service.LoaiVanBanLocalService;
import com.nss.portlet.loai_van_ban.service.LoaiVanBanService;
import com.nss.portlet.loai_van_ban.service.persistence.LoaiVanBanFinder;
import com.nss.portlet.loai_van_ban.service.persistence.LoaiVanBanPersistence;


public abstract class LoaiVanBanServiceBaseImpl extends PrincipalBean
    implements LoaiVanBanService {
    @BeanReference(name = "com.nss.portlet.loai_van_ban.service.LoaiVanBanLocalService.impl")
    protected LoaiVanBanLocalService loaiVanBanLocalService;
    @BeanReference(name = "com.nss.portlet.loai_van_ban.service.LoaiVanBanService.impl")
    protected LoaiVanBanService loaiVanBanService;
    @BeanReference(name = "com.nss.portlet.loai_van_ban.service.persistence.LoaiVanBanPersistence.impl")
    protected LoaiVanBanPersistence loaiVanBanPersistence;
    @BeanReference(name = "com.nss.portlet.loai_van_ban.service.persistence.LoaiVanBanFinder.impl")
    protected LoaiVanBanFinder loaiVanBanFinder;

    public LoaiVanBanLocalService getLoaiVanBanLocalService() {
        return loaiVanBanLocalService;
    }

    public void setLoaiVanBanLocalService(
        LoaiVanBanLocalService loaiVanBanLocalService) {
        this.loaiVanBanLocalService = loaiVanBanLocalService;
    }

    public LoaiVanBanService getLoaiVanBanService() {
        return loaiVanBanService;
    }

    public void setLoaiVanBanService(LoaiVanBanService loaiVanBanService) {
        this.loaiVanBanService = loaiVanBanService;
    }

    public LoaiVanBanPersistence getLoaiVanBanPersistence() {
        return loaiVanBanPersistence;
    }

    public void setLoaiVanBanPersistence(
        LoaiVanBanPersistence loaiVanBanPersistence) {
        this.loaiVanBanPersistence = loaiVanBanPersistence;
    }

    public LoaiVanBanFinder getLoaiVanBanFinder() {
        return loaiVanBanFinder;
    }

    public void setLoaiVanBanFinder(LoaiVanBanFinder loaiVanBanFinder) {
        this.loaiVanBanFinder = loaiVanBanFinder;
    }

    protected void runSQL(String sql) throws SystemException {
        try {
            PortalUtil.runSQL(sql);
        } catch (Exception e) {
            throw new SystemException(e);
        }
    }
}
