package com.nss.portlet.linh_vuc_van_ban.service.base;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.service.base.PrincipalBean;
import com.liferay.portal.util.PortalUtil;

import com.nss.portlet.linh_vuc_van_ban.service.LinhVucVanBanLocalService;
import com.nss.portlet.linh_vuc_van_ban.service.LinhVucVanBanService;
import com.nss.portlet.linh_vuc_van_ban.service.persistence.LinhVucVanBanFinder;
import com.nss.portlet.linh_vuc_van_ban.service.persistence.LinhVucVanBanPersistence;


public abstract class LinhVucVanBanServiceBaseImpl extends PrincipalBean
    implements LinhVucVanBanService {
    @BeanReference(name = "com.nss.portlet.linh_vuc_van_ban.service.LinhVucVanBanLocalService.impl")
    protected LinhVucVanBanLocalService linhVucVanBanLocalService;
    @BeanReference(name = "com.nss.portlet.linh_vuc_van_ban.service.LinhVucVanBanService.impl")
    protected LinhVucVanBanService linhVucVanBanService;
    @BeanReference(name = "com.nss.portlet.linh_vuc_van_ban.service.persistence.LinhVucVanBanPersistence.impl")
    protected LinhVucVanBanPersistence linhVucVanBanPersistence;
    @BeanReference(name = "com.nss.portlet.linh_vuc_van_ban.service.persistence.LinhVucVanBanFinder.impl")
    protected LinhVucVanBanFinder linhVucVanBanFinder;

    public LinhVucVanBanLocalService getLinhVucVanBanLocalService() {
        return linhVucVanBanLocalService;
    }

    public void setLinhVucVanBanLocalService(
        LinhVucVanBanLocalService linhVucVanBanLocalService) {
        this.linhVucVanBanLocalService = linhVucVanBanLocalService;
    }

    public LinhVucVanBanService getLinhVucVanBanService() {
        return linhVucVanBanService;
    }

    public void setLinhVucVanBanService(
        LinhVucVanBanService linhVucVanBanService) {
        this.linhVucVanBanService = linhVucVanBanService;
    }

    public LinhVucVanBanPersistence getLinhVucVanBanPersistence() {
        return linhVucVanBanPersistence;
    }

    public void setLinhVucVanBanPersistence(
        LinhVucVanBanPersistence linhVucVanBanPersistence) {
        this.linhVucVanBanPersistence = linhVucVanBanPersistence;
    }

    public LinhVucVanBanFinder getLinhVucVanBanFinder() {
        return linhVucVanBanFinder;
    }

    public void setLinhVucVanBanFinder(LinhVucVanBanFinder linhVucVanBanFinder) {
        this.linhVucVanBanFinder = linhVucVanBanFinder;
    }

    protected void runSQL(String sql) throws SystemException {
        try {
            PortalUtil.runSQL(sql);
        } catch (Exception e) {
            throw new SystemException(e);
        }
    }
}
