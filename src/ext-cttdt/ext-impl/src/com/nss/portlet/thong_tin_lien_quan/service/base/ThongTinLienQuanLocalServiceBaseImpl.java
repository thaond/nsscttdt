package com.nss.portlet.thong_tin_lien_quan.service.base;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.util.PortalUtil;

import com.nss.portlet.thong_tin_lien_quan.model.ThongTinLienQuan;
import com.nss.portlet.thong_tin_lien_quan.service.ThongTinLienQuanLocalService;
import com.nss.portlet.thong_tin_lien_quan.service.ThongTinLienQuanService;
import com.nss.portlet.thong_tin_lien_quan.service.persistence.ThongTinLienQuanFinder;
import com.nss.portlet.thong_tin_lien_quan.service.persistence.ThongTinLienQuanPersistence;

import java.util.List;


public abstract class ThongTinLienQuanLocalServiceBaseImpl
    implements ThongTinLienQuanLocalService {
    @BeanReference(name = "com.nss.portlet.thong_tin_lien_quan.service.ThongTinLienQuanLocalService.impl")
    protected ThongTinLienQuanLocalService thongTinLienQuanLocalService;
    @BeanReference(name = "com.nss.portlet.thong_tin_lien_quan.service.ThongTinLienQuanService.impl")
    protected ThongTinLienQuanService thongTinLienQuanService;
    @BeanReference(name = "com.nss.portlet.thong_tin_lien_quan.service.persistence.ThongTinLienQuanPersistence.impl")
    protected ThongTinLienQuanPersistence thongTinLienQuanPersistence;
    @BeanReference(name = "com.nss.portlet.thong_tin_lien_quan.service.persistence.ThongTinLienQuanFinder.impl")
    protected ThongTinLienQuanFinder thongTinLienQuanFinder;

    public ThongTinLienQuan addThongTinLienQuan(
        ThongTinLienQuan thongTinLienQuan) throws SystemException {
        thongTinLienQuan.setNew(true);

        return thongTinLienQuanPersistence.update(thongTinLienQuan, false);
    }

    public ThongTinLienQuan createThongTinLienQuan(long maThongTinLienQuan) {
        return thongTinLienQuanPersistence.create(maThongTinLienQuan);
    }

    public void deleteThongTinLienQuan(long maThongTinLienQuan)
        throws PortalException, SystemException {
        thongTinLienQuanPersistence.remove(maThongTinLienQuan);
    }

    public void deleteThongTinLienQuan(ThongTinLienQuan thongTinLienQuan)
        throws SystemException {
        thongTinLienQuanPersistence.remove(thongTinLienQuan);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return thongTinLienQuanPersistence.findWithDynamicQuery(dynamicQuery);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery, int start,
        int end) throws SystemException {
        return thongTinLienQuanPersistence.findWithDynamicQuery(dynamicQuery,
            start, end);
    }

    public ThongTinLienQuan getThongTinLienQuan(long maThongTinLienQuan)
        throws PortalException, SystemException {
        return thongTinLienQuanPersistence.findByPrimaryKey(maThongTinLienQuan);
    }

    public List<ThongTinLienQuan> getThongTinLienQuans(int start, int end)
        throws SystemException {
        return thongTinLienQuanPersistence.findAll(start, end);
    }

    public int getThongTinLienQuansCount() throws SystemException {
        return thongTinLienQuanPersistence.countAll();
    }

    public ThongTinLienQuan updateThongTinLienQuan(
        ThongTinLienQuan thongTinLienQuan) throws SystemException {
        thongTinLienQuan.setNew(false);

        return thongTinLienQuanPersistence.update(thongTinLienQuan, true);
    }

    public ThongTinLienQuan updateThongTinLienQuan(
        ThongTinLienQuan thongTinLienQuan, boolean merge)
        throws SystemException {
        thongTinLienQuan.setNew(false);

        return thongTinLienQuanPersistence.update(thongTinLienQuan, merge);
    }

    public ThongTinLienQuanLocalService getThongTinLienQuanLocalService() {
        return thongTinLienQuanLocalService;
    }

    public void setThongTinLienQuanLocalService(
        ThongTinLienQuanLocalService thongTinLienQuanLocalService) {
        this.thongTinLienQuanLocalService = thongTinLienQuanLocalService;
    }

    public ThongTinLienQuanService getThongTinLienQuanService() {
        return thongTinLienQuanService;
    }

    public void setThongTinLienQuanService(
        ThongTinLienQuanService thongTinLienQuanService) {
        this.thongTinLienQuanService = thongTinLienQuanService;
    }

    public ThongTinLienQuanPersistence getThongTinLienQuanPersistence() {
        return thongTinLienQuanPersistence;
    }

    public void setThongTinLienQuanPersistence(
        ThongTinLienQuanPersistence thongTinLienQuanPersistence) {
        this.thongTinLienQuanPersistence = thongTinLienQuanPersistence;
    }

    public ThongTinLienQuanFinder getThongTinLienQuanFinder() {
        return thongTinLienQuanFinder;
    }

    public void setThongTinLienQuanFinder(
        ThongTinLienQuanFinder thongTinLienQuanFinder) {
        this.thongTinLienQuanFinder = thongTinLienQuanFinder;
    }

    protected void runSQL(String sql) throws SystemException {
        try {
            PortalUtil.runSQL(sql);
        } catch (Exception e) {
            throw new SystemException(e);
        }
    }
}
