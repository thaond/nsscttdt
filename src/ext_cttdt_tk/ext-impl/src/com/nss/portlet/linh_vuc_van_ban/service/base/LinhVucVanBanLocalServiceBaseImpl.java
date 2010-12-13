package com.nss.portlet.linh_vuc_van_ban.service.base;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.util.PortalUtil;

import com.nss.portlet.linh_vuc_van_ban.model.LinhVucVanBan;
import com.nss.portlet.linh_vuc_van_ban.service.LinhVucVanBanLocalService;
import com.nss.portlet.linh_vuc_van_ban.service.LinhVucVanBanService;
import com.nss.portlet.linh_vuc_van_ban.service.persistence.LinhVucVanBanFinder;
import com.nss.portlet.linh_vuc_van_ban.service.persistence.LinhVucVanBanPersistence;

import java.util.List;


public abstract class LinhVucVanBanLocalServiceBaseImpl
    implements LinhVucVanBanLocalService {
    @BeanReference(name = "com.nss.portlet.linh_vuc_van_ban.service.LinhVucVanBanLocalService.impl")
    protected LinhVucVanBanLocalService linhVucVanBanLocalService;
    @BeanReference(name = "com.nss.portlet.linh_vuc_van_ban.service.LinhVucVanBanService.impl")
    protected LinhVucVanBanService linhVucVanBanService;
    @BeanReference(name = "com.nss.portlet.linh_vuc_van_ban.service.persistence.LinhVucVanBanPersistence.impl")
    protected LinhVucVanBanPersistence linhVucVanBanPersistence;
    @BeanReference(name = "com.nss.portlet.linh_vuc_van_ban.service.persistence.LinhVucVanBanFinder.impl")
    protected LinhVucVanBanFinder linhVucVanBanFinder;

    public LinhVucVanBan addLinhVucVanBan(LinhVucVanBan linhVucVanBan)
        throws SystemException {
        linhVucVanBan.setNew(true);

        return linhVucVanBanPersistence.update(linhVucVanBan, false);
    }

    public LinhVucVanBan createLinhVucVanBan(long maLinhVucVanBan) {
        return linhVucVanBanPersistence.create(maLinhVucVanBan);
    }

    public void deleteLinhVucVanBan(long maLinhVucVanBan)
        throws PortalException, SystemException {
        linhVucVanBanPersistence.remove(maLinhVucVanBan);
    }

    public void deleteLinhVucVanBan(LinhVucVanBan linhVucVanBan)
        throws SystemException {
        linhVucVanBanPersistence.remove(linhVucVanBan);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return linhVucVanBanPersistence.findWithDynamicQuery(dynamicQuery);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery, int start,
        int end) throws SystemException {
        return linhVucVanBanPersistence.findWithDynamicQuery(dynamicQuery,
            start, end);
    }

    public LinhVucVanBan getLinhVucVanBan(long maLinhVucVanBan)
        throws PortalException, SystemException {
        return linhVucVanBanPersistence.findByPrimaryKey(maLinhVucVanBan);
    }

    public List<LinhVucVanBan> getLinhVucVanBans(int start, int end)
        throws SystemException {
        return linhVucVanBanPersistence.findAll(start, end);
    }

    public int getLinhVucVanBansCount() throws SystemException {
        return linhVucVanBanPersistence.countAll();
    }

    public LinhVucVanBan updateLinhVucVanBan(LinhVucVanBan linhVucVanBan)
        throws SystemException {
        linhVucVanBan.setNew(false);

        return linhVucVanBanPersistence.update(linhVucVanBan, true);
    }

    public LinhVucVanBan updateLinhVucVanBan(LinhVucVanBan linhVucVanBan,
        boolean merge) throws SystemException {
        linhVucVanBan.setNew(false);

        return linhVucVanBanPersistence.update(linhVucVanBan, merge);
    }

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
