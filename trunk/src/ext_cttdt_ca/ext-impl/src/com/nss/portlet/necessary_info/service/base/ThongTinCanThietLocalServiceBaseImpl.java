package com.nss.portlet.necessary_info.service.base;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.util.PortalUtil;

import com.nss.portlet.necessary_info.model.ThongTinCanThiet;
import com.nss.portlet.necessary_info.service.ThongTinCanThietLocalService;
import com.nss.portlet.necessary_info.service.ThongTinCanThietService;
import com.nss.portlet.necessary_info.service.persistence.ThongTinCanThietFinder;
import com.nss.portlet.necessary_info.service.persistence.ThongTinCanThietPersistence;

import java.util.List;


public abstract class ThongTinCanThietLocalServiceBaseImpl
    implements ThongTinCanThietLocalService {
    @BeanReference(name = "com.nss.portlet.necessary_info.service.ThongTinCanThietLocalService.impl")
    protected ThongTinCanThietLocalService thongTinCanThietLocalService;
    @BeanReference(name = "com.nss.portlet.necessary_info.service.ThongTinCanThietService.impl")
    protected ThongTinCanThietService thongTinCanThietService;
    @BeanReference(name = "com.nss.portlet.necessary_info.service.persistence.ThongTinCanThietPersistence.impl")
    protected ThongTinCanThietPersistence thongTinCanThietPersistence;
    @BeanReference(name = "com.nss.portlet.necessary_info.service.persistence.ThongTinCanThietFinder.impl")
    protected ThongTinCanThietFinder thongTinCanThietFinder;

    public ThongTinCanThiet addThongTinCanThiet(
        ThongTinCanThiet thongTinCanThiet) throws SystemException {
        thongTinCanThiet.setNew(true);

        return thongTinCanThietPersistence.update(thongTinCanThiet, false);
    }

    public ThongTinCanThiet createThongTinCanThiet(long maThongTinCanThiet) {
        return thongTinCanThietPersistence.create(maThongTinCanThiet);
    }

    public void deleteThongTinCanThiet(long maThongTinCanThiet)
        throws PortalException, SystemException {
        thongTinCanThietPersistence.remove(maThongTinCanThiet);
    }

    public void deleteThongTinCanThiet(ThongTinCanThiet thongTinCanThiet)
        throws SystemException {
        thongTinCanThietPersistence.remove(thongTinCanThiet);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return thongTinCanThietPersistence.findWithDynamicQuery(dynamicQuery);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery, int start,
        int end) throws SystemException {
        return thongTinCanThietPersistence.findWithDynamicQuery(dynamicQuery,
            start, end);
    }

    public ThongTinCanThiet getThongTinCanThiet(long maThongTinCanThiet)
        throws PortalException, SystemException {
        return thongTinCanThietPersistence.findByPrimaryKey(maThongTinCanThiet);
    }

    public List<ThongTinCanThiet> getThongTinCanThiets(int start, int end)
        throws SystemException {
        return thongTinCanThietPersistence.findAll(start, end);
    }

    public int getThongTinCanThietsCount() throws SystemException {
        return thongTinCanThietPersistence.countAll();
    }

    public ThongTinCanThiet updateThongTinCanThiet(
        ThongTinCanThiet thongTinCanThiet) throws SystemException {
        thongTinCanThiet.setNew(false);

        return thongTinCanThietPersistence.update(thongTinCanThiet, true);
    }

    public ThongTinCanThiet updateThongTinCanThiet(
        ThongTinCanThiet thongTinCanThiet, boolean merge)
        throws SystemException {
        thongTinCanThiet.setNew(false);

        return thongTinCanThietPersistence.update(thongTinCanThiet, merge);
    }

    public ThongTinCanThietLocalService getThongTinCanThietLocalService() {
        return thongTinCanThietLocalService;
    }

    public void setThongTinCanThietLocalService(
        ThongTinCanThietLocalService thongTinCanThietLocalService) {
        this.thongTinCanThietLocalService = thongTinCanThietLocalService;
    }

    public ThongTinCanThietService getThongTinCanThietService() {
        return thongTinCanThietService;
    }

    public void setThongTinCanThietService(
        ThongTinCanThietService thongTinCanThietService) {
        this.thongTinCanThietService = thongTinCanThietService;
    }

    public ThongTinCanThietPersistence getThongTinCanThietPersistence() {
        return thongTinCanThietPersistence;
    }

    public void setThongTinCanThietPersistence(
        ThongTinCanThietPersistence thongTinCanThietPersistence) {
        this.thongTinCanThietPersistence = thongTinCanThietPersistence;
    }

    public ThongTinCanThietFinder getThongTinCanThietFinder() {
        return thongTinCanThietFinder;
    }

    public void setThongTinCanThietFinder(
        ThongTinCanThietFinder thongTinCanThietFinder) {
        this.thongTinCanThietFinder = thongTinCanThietFinder;
    }

    protected void runSQL(String sql) throws SystemException {
        try {
            PortalUtil.runSQL(sql);
        } catch (Exception e) {
            throw new SystemException(e);
        }
    }
}
