package com.nss.portlet.loai_van_ban.service.base;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.util.PortalUtil;

import com.nss.portlet.loai_van_ban.model.LoaiVanBan;
import com.nss.portlet.loai_van_ban.service.LoaiVanBanLocalService;
import com.nss.portlet.loai_van_ban.service.LoaiVanBanService;
import com.nss.portlet.loai_van_ban.service.persistence.LoaiVanBanFinder;
import com.nss.portlet.loai_van_ban.service.persistence.LoaiVanBanPersistence;

import java.util.List;


public abstract class LoaiVanBanLocalServiceBaseImpl
    implements LoaiVanBanLocalService {
    @BeanReference(name = "com.nss.portlet.loai_van_ban.service.LoaiVanBanLocalService.impl")
    protected LoaiVanBanLocalService loaiVanBanLocalService;
    @BeanReference(name = "com.nss.portlet.loai_van_ban.service.LoaiVanBanService.impl")
    protected LoaiVanBanService loaiVanBanService;
    @BeanReference(name = "com.nss.portlet.loai_van_ban.service.persistence.LoaiVanBanPersistence.impl")
    protected LoaiVanBanPersistence loaiVanBanPersistence;
    @BeanReference(name = "com.nss.portlet.loai_van_ban.service.persistence.LoaiVanBanFinder.impl")
    protected LoaiVanBanFinder loaiVanBanFinder;

    public LoaiVanBan addLoaiVanBan(LoaiVanBan loaiVanBan)
        throws SystemException {
        loaiVanBan.setNew(true);

        return loaiVanBanPersistence.update(loaiVanBan, false);
    }

    public LoaiVanBan createLoaiVanBan(long maLoaiVanBan) {
        return loaiVanBanPersistence.create(maLoaiVanBan);
    }

    public void deleteLoaiVanBan(long maLoaiVanBan)
        throws PortalException, SystemException {
        loaiVanBanPersistence.remove(maLoaiVanBan);
    }

    public void deleteLoaiVanBan(LoaiVanBan loaiVanBan)
        throws SystemException {
        loaiVanBanPersistence.remove(loaiVanBan);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return loaiVanBanPersistence.findWithDynamicQuery(dynamicQuery);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery, int start,
        int end) throws SystemException {
        return loaiVanBanPersistence.findWithDynamicQuery(dynamicQuery, start,
            end);
    }

    public LoaiVanBan getLoaiVanBan(long maLoaiVanBan)
        throws PortalException, SystemException {
        return loaiVanBanPersistence.findByPrimaryKey(maLoaiVanBan);
    }

    public List<LoaiVanBan> getLoaiVanBans(int start, int end)
        throws SystemException {
        return loaiVanBanPersistence.findAll(start, end);
    }

    public int getLoaiVanBansCount() throws SystemException {
        return loaiVanBanPersistence.countAll();
    }

    public LoaiVanBan updateLoaiVanBan(LoaiVanBan loaiVanBan)
        throws SystemException {
        loaiVanBan.setNew(false);

        return loaiVanBanPersistence.update(loaiVanBan, true);
    }

    public LoaiVanBan updateLoaiVanBan(LoaiVanBan loaiVanBan, boolean merge)
        throws SystemException {
        loaiVanBan.setNew(false);

        return loaiVanBanPersistence.update(loaiVanBan, merge);
    }

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
