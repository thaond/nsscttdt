package com.nss.portlet.link.service.base;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.util.PortalUtil;

import com.nss.portlet.link.model.LoaiWebsite;
import com.nss.portlet.link.service.LienKetWebsiteLocalService;
import com.nss.portlet.link.service.LienKetWebsiteService;
import com.nss.portlet.link.service.LoaiWebsiteLocalService;
import com.nss.portlet.link.service.LoaiWebsiteService;
import com.nss.portlet.link.service.persistence.LienKetWebsiteFinder;
import com.nss.portlet.link.service.persistence.LienKetWebsitePersistence;
import com.nss.portlet.link.service.persistence.LoaiWebsiteFinder;
import com.nss.portlet.link.service.persistence.LoaiWebsitePersistence;

import java.util.List;


public abstract class LoaiWebsiteLocalServiceBaseImpl
    implements LoaiWebsiteLocalService {
    @BeanReference(name = "com.nss.portlet.link.service.LienKetWebsiteLocalService.impl")
    protected LienKetWebsiteLocalService lienKetWebsiteLocalService;
    @BeanReference(name = "com.nss.portlet.link.service.LienKetWebsiteService.impl")
    protected LienKetWebsiteService lienKetWebsiteService;
    @BeanReference(name = "com.nss.portlet.link.service.persistence.LienKetWebsitePersistence.impl")
    protected LienKetWebsitePersistence lienKetWebsitePersistence;
    @BeanReference(name = "com.nss.portlet.link.service.persistence.LienKetWebsiteFinder.impl")
    protected LienKetWebsiteFinder lienKetWebsiteFinder;
    @BeanReference(name = "com.nss.portlet.link.service.LoaiWebsiteLocalService.impl")
    protected LoaiWebsiteLocalService loaiWebsiteLocalService;
    @BeanReference(name = "com.nss.portlet.link.service.LoaiWebsiteService.impl")
    protected LoaiWebsiteService loaiWebsiteService;
    @BeanReference(name = "com.nss.portlet.link.service.persistence.LoaiWebsitePersistence.impl")
    protected LoaiWebsitePersistence loaiWebsitePersistence;
    @BeanReference(name = "com.nss.portlet.link.service.persistence.LoaiWebsiteFinder.impl")
    protected LoaiWebsiteFinder loaiWebsiteFinder;

    public LoaiWebsite addLoaiWebsite(LoaiWebsite loaiWebsite)
        throws SystemException {
        loaiWebsite.setNew(true);

        return loaiWebsitePersistence.update(loaiWebsite, false);
    }

    public LoaiWebsite createLoaiWebsite(long maLoaiWebsite) {
        return loaiWebsitePersistence.create(maLoaiWebsite);
    }

    public void deleteLoaiWebsite(long maLoaiWebsite)
        throws PortalException, SystemException {
        loaiWebsitePersistence.remove(maLoaiWebsite);
    }

    public void deleteLoaiWebsite(LoaiWebsite loaiWebsite)
        throws SystemException {
        loaiWebsitePersistence.remove(loaiWebsite);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return loaiWebsitePersistence.findWithDynamicQuery(dynamicQuery);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery, int start,
        int end) throws SystemException {
        return loaiWebsitePersistence.findWithDynamicQuery(dynamicQuery, start,
            end);
    }

    public LoaiWebsite getLoaiWebsite(long maLoaiWebsite)
        throws PortalException, SystemException {
        return loaiWebsitePersistence.findByPrimaryKey(maLoaiWebsite);
    }

    public List<LoaiWebsite> getLoaiWebsites(int start, int end)
        throws SystemException {
        return loaiWebsitePersistence.findAll(start, end);
    }

    public int getLoaiWebsitesCount() throws SystemException {
        return loaiWebsitePersistence.countAll();
    }

    public LoaiWebsite updateLoaiWebsite(LoaiWebsite loaiWebsite)
        throws SystemException {
        loaiWebsite.setNew(false);

        return loaiWebsitePersistence.update(loaiWebsite, true);
    }

    public LoaiWebsite updateLoaiWebsite(LoaiWebsite loaiWebsite, boolean merge)
        throws SystemException {
        loaiWebsite.setNew(false);

        return loaiWebsitePersistence.update(loaiWebsite, merge);
    }

    public LienKetWebsiteLocalService getLienKetWebsiteLocalService() {
        return lienKetWebsiteLocalService;
    }

    public void setLienKetWebsiteLocalService(
        LienKetWebsiteLocalService lienKetWebsiteLocalService) {
        this.lienKetWebsiteLocalService = lienKetWebsiteLocalService;
    }

    public LienKetWebsiteService getLienKetWebsiteService() {
        return lienKetWebsiteService;
    }

    public void setLienKetWebsiteService(
        LienKetWebsiteService lienKetWebsiteService) {
        this.lienKetWebsiteService = lienKetWebsiteService;
    }

    public LienKetWebsitePersistence getLienKetWebsitePersistence() {
        return lienKetWebsitePersistence;
    }

    public void setLienKetWebsitePersistence(
        LienKetWebsitePersistence lienKetWebsitePersistence) {
        this.lienKetWebsitePersistence = lienKetWebsitePersistence;
    }

    public LienKetWebsiteFinder getLienKetWebsiteFinder() {
        return lienKetWebsiteFinder;
    }

    public void setLienKetWebsiteFinder(
        LienKetWebsiteFinder lienKetWebsiteFinder) {
        this.lienKetWebsiteFinder = lienKetWebsiteFinder;
    }

    public LoaiWebsiteLocalService getLoaiWebsiteLocalService() {
        return loaiWebsiteLocalService;
    }

    public void setLoaiWebsiteLocalService(
        LoaiWebsiteLocalService loaiWebsiteLocalService) {
        this.loaiWebsiteLocalService = loaiWebsiteLocalService;
    }

    public LoaiWebsiteService getLoaiWebsiteService() {
        return loaiWebsiteService;
    }

    public void setLoaiWebsiteService(LoaiWebsiteService loaiWebsiteService) {
        this.loaiWebsiteService = loaiWebsiteService;
    }

    public LoaiWebsitePersistence getLoaiWebsitePersistence() {
        return loaiWebsitePersistence;
    }

    public void setLoaiWebsitePersistence(
        LoaiWebsitePersistence loaiWebsitePersistence) {
        this.loaiWebsitePersistence = loaiWebsitePersistence;
    }

    public LoaiWebsiteFinder getLoaiWebsiteFinder() {
        return loaiWebsiteFinder;
    }

    public void setLoaiWebsiteFinder(LoaiWebsiteFinder loaiWebsiteFinder) {
        this.loaiWebsiteFinder = loaiWebsiteFinder;
    }

    protected void runSQL(String sql) throws SystemException {
        try {
            PortalUtil.runSQL(sql);
        } catch (Exception e) {
            throw new SystemException(e);
        }
    }
}
