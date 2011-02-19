package com.sgs.portlet.vanbannoibo.service.base;

import com.liferay.portal.service.base.PrincipalBean;

import com.sgs.portlet.vanbannoibo.service.FileDinhKemVanBanNoiBoLocalService;
import com.sgs.portlet.vanbannoibo.service.FileDinhKemVanBanNoiBoService;
import com.sgs.portlet.vanbannoibo.service.LogVanBanNoiBoLocalService;
import com.sgs.portlet.vanbannoibo.service.LogVanBanNoiBoService;
import com.sgs.portlet.vanbannoibo.service.VanBanNoiBoLocalService;
import com.sgs.portlet.vanbannoibo.service.VanBanNoiBoService;
import com.sgs.portlet.vanbannoibo.service.persistence.FileDinhKemVanBanNoiBoPersistence;
import com.sgs.portlet.vanbannoibo.service.persistence.LogVanBanNoiBoPersistence;
import com.sgs.portlet.vanbannoibo.service.persistence.VanBanNoiBoFinder;
import com.sgs.portlet.vanbannoibo.service.persistence.VanBanNoiBoPersistence;


public abstract class FileDinhKemVanBanNoiBoServiceBaseImpl
    extends PrincipalBean implements FileDinhKemVanBanNoiBoService {
    @javax.annotation.Resource(name = "com.sgs.portlet.vanbannoibo.service.VanBanNoiBoLocalService.impl")
    protected VanBanNoiBoLocalService vanBanNoiBoLocalService;
    @javax.annotation.Resource(name = "com.sgs.portlet.vanbannoibo.service.VanBanNoiBoService.impl")
    protected VanBanNoiBoService vanBanNoiBoService;
    @javax.annotation.Resource(name = "com.sgs.portlet.vanbannoibo.service.persistence.VanBanNoiBoPersistence.impl")
    protected VanBanNoiBoPersistence vanBanNoiBoPersistence;
    @javax.annotation.Resource(name = "com.sgs.portlet.vanbannoibo.service.persistence.VanBanNoiBoFinder.impl")
    protected VanBanNoiBoFinder vanBanNoiBoFinder;
    @javax.annotation.Resource(name = "com.sgs.portlet.vanbannoibo.service.FileDinhKemVanBanNoiBoLocalService.impl")
    protected FileDinhKemVanBanNoiBoLocalService fileDinhKemVanBanNoiBoLocalService;
    @javax.annotation.Resource(name = "com.sgs.portlet.vanbannoibo.service.FileDinhKemVanBanNoiBoService.impl")
    protected FileDinhKemVanBanNoiBoService fileDinhKemVanBanNoiBoService;
    @javax.annotation.Resource(name = "com.sgs.portlet.vanbannoibo.service.persistence.FileDinhKemVanBanNoiBoPersistence.impl")
    protected FileDinhKemVanBanNoiBoPersistence fileDinhKemVanBanNoiBoPersistence;
    @javax.annotation.Resource(name = "com.sgs.portlet.vanbannoibo.service.LogVanBanNoiBoLocalService.impl")
    protected LogVanBanNoiBoLocalService logVanBanNoiBoLocalService;
    @javax.annotation.Resource(name = "com.sgs.portlet.vanbannoibo.service.LogVanBanNoiBoService.impl")
    protected LogVanBanNoiBoService logVanBanNoiBoService;
    @javax.annotation.Resource(name = "com.sgs.portlet.vanbannoibo.service.persistence.LogVanBanNoiBoPersistence.impl")
    protected LogVanBanNoiBoPersistence logVanBanNoiBoPersistence;

    public VanBanNoiBoLocalService getVanBanNoiBoLocalService() {
        return vanBanNoiBoLocalService;
    }

    public void setVanBanNoiBoLocalService(
        VanBanNoiBoLocalService vanBanNoiBoLocalService) {
        this.vanBanNoiBoLocalService = vanBanNoiBoLocalService;
    }

    public VanBanNoiBoService getVanBanNoiBoService() {
        return vanBanNoiBoService;
    }

    public void setVanBanNoiBoService(VanBanNoiBoService vanBanNoiBoService) {
        this.vanBanNoiBoService = vanBanNoiBoService;
    }

    public VanBanNoiBoPersistence getVanBanNoiBoPersistence() {
        return vanBanNoiBoPersistence;
    }

    public void setVanBanNoiBoPersistence(
        VanBanNoiBoPersistence vanBanNoiBoPersistence) {
        this.vanBanNoiBoPersistence = vanBanNoiBoPersistence;
    }

    public VanBanNoiBoFinder getVanBanNoiBoFinder() {
        return vanBanNoiBoFinder;
    }

    public void setVanBanNoiBoFinder(VanBanNoiBoFinder vanBanNoiBoFinder) {
        this.vanBanNoiBoFinder = vanBanNoiBoFinder;
    }

    public FileDinhKemVanBanNoiBoLocalService getFileDinhKemVanBanNoiBoLocalService() {
        return fileDinhKemVanBanNoiBoLocalService;
    }

    public void setFileDinhKemVanBanNoiBoLocalService(
        FileDinhKemVanBanNoiBoLocalService fileDinhKemVanBanNoiBoLocalService) {
        this.fileDinhKemVanBanNoiBoLocalService = fileDinhKemVanBanNoiBoLocalService;
    }

    public FileDinhKemVanBanNoiBoService getFileDinhKemVanBanNoiBoService() {
        return fileDinhKemVanBanNoiBoService;
    }

    public void setFileDinhKemVanBanNoiBoService(
        FileDinhKemVanBanNoiBoService fileDinhKemVanBanNoiBoService) {
        this.fileDinhKemVanBanNoiBoService = fileDinhKemVanBanNoiBoService;
    }

    public FileDinhKemVanBanNoiBoPersistence getFileDinhKemVanBanNoiBoPersistence() {
        return fileDinhKemVanBanNoiBoPersistence;
    }

    public void setFileDinhKemVanBanNoiBoPersistence(
        FileDinhKemVanBanNoiBoPersistence fileDinhKemVanBanNoiBoPersistence) {
        this.fileDinhKemVanBanNoiBoPersistence = fileDinhKemVanBanNoiBoPersistence;
    }

    public LogVanBanNoiBoLocalService getLogVanBanNoiBoLocalService() {
        return logVanBanNoiBoLocalService;
    }

    public void setLogVanBanNoiBoLocalService(
        LogVanBanNoiBoLocalService logVanBanNoiBoLocalService) {
        this.logVanBanNoiBoLocalService = logVanBanNoiBoLocalService;
    }

    public LogVanBanNoiBoService getLogVanBanNoiBoService() {
        return logVanBanNoiBoService;
    }

    public void setLogVanBanNoiBoService(
        LogVanBanNoiBoService logVanBanNoiBoService) {
        this.logVanBanNoiBoService = logVanBanNoiBoService;
    }

    public LogVanBanNoiBoPersistence getLogVanBanNoiBoPersistence() {
        return logVanBanNoiBoPersistence;
    }

    public void setLogVanBanNoiBoPersistence(
        LogVanBanNoiBoPersistence logVanBanNoiBoPersistence) {
        this.logVanBanNoiBoPersistence = logVanBanNoiBoPersistence;
    }
}
