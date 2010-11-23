package com.nss.portlet.link.service.base;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.util.PortalUtil;

import com.nss.portlet.link.model.LienKetWebsite;
import com.nss.portlet.link.service.LienKetWebsiteLocalService;
import com.nss.portlet.link.service.LienKetWebsiteService;
import com.nss.portlet.link.service.LoaiWebsiteLocalService;
import com.nss.portlet.link.service.LoaiWebsiteService;
import com.nss.portlet.link.service.persistence.LienKetWebsiteFinder;
import com.nss.portlet.link.service.persistence.LienKetWebsitePersistence;
import com.nss.portlet.link.service.persistence.LoaiWebsiteFinder;
import com.nss.portlet.link.service.persistence.LoaiWebsitePersistence;

import java.util.List;


public abstract class LienKetWebsiteLocalServiceBaseImpl
    implements LienKetWebsiteLocalService {
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

    public LienKetWebsite addLienKetWebsite(LienKetWebsite lienKetWebsite)
        throws SystemException {
        lienKetWebsite.setNew(true);

        return lienKetWebsitePersistence.update(lienKetWebsite, false);
    }

    public LienKetWebsite createLienKetWebsite(long maWebsite) {
        return lienKetWebsitePersistence.create(maWebsite);
    }

    public void deleteLienKetWebsite(long maWebsite)
        throws PortalException, SystemException {
        lienKetWebsitePersistence.remove(maWebsite);
    }

    public void deleteLienKetWebsite(LienKetWebsite lienKetWebsite)
        throws SystemException {
        lienKetWebsitePersistence.remove(lienKetWebsite);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return lienKetWebsitePersistence.findWithDynamicQuery(dynamicQuery);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery, int start,
        int end) throws SystemException {
        return lienKetWebsitePersistence.findWithDynamicQuery(dynamicQuery,
            start, end);
    }

    public LienKetWebsite getLienKetWebsite(long maWebsite)
        throws PortalException, SystemException {
        return lienKetWebsitePersistence.findByPrimaryKey(maWebsite);
    }

    public List<LienKetWebsite> getLienKetWebsites(int start, int end)
        throws SystemException {
        return lienKetWebsitePersistence.findAll(start, end);
    }

    public int getLienKetWebsitesCount() throws SystemException {
        return lienKetWebsitePersistence.countAll();
    }

    public LienKetWebsite updateLienKetWebsite(LienKetWebsite lienKetWebsite)
        throws SystemException {
        lienKetWebsite.setNew(false);

        return lienKetWebsitePersistence.update(lienKetWebsite, true);
    }

    public LienKetWebsite updateLienKetWebsite(LienKetWebsite lienKetWebsite,
        boolean merge) throws SystemException {
        lienKetWebsite.setNew(false);

        return lienKetWebsitePersistence.update(lienKetWebsite, merge);
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
