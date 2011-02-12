package com.sgs.portlet.vanbannoibo.service.base;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;

import com.sgs.portlet.vanbannoibo.model.FileDinhKemVanBanNoiBo;
import com.sgs.portlet.vanbannoibo.service.FileDinhKemVanBanNoiBoLocalService;
import com.sgs.portlet.vanbannoibo.service.FileDinhKemVanBanNoiBoService;
import com.sgs.portlet.vanbannoibo.service.LogVanBanNoiBoLocalService;
import com.sgs.portlet.vanbannoibo.service.LogVanBanNoiBoService;
import com.sgs.portlet.vanbannoibo.service.VanBanNoiBoLocalService;
import com.sgs.portlet.vanbannoibo.service.VanBanNoiBoService;
import com.sgs.portlet.vanbannoibo.service.persistence.FileDinhKemVanBanNoiBoPersistence;
import com.sgs.portlet.vanbannoibo.service.persistence.LogVanBanNoiBoPersistence;
import com.sgs.portlet.vanbannoibo.service.persistence.VanBanNoiBoPersistence;

import java.util.List;


public abstract class FileDinhKemVanBanNoiBoLocalServiceBaseImpl
    implements FileDinhKemVanBanNoiBoLocalService {
    @javax.annotation.Resource(name = "com.sgs.portlet.vanbannoibo.service.VanBanNoiBoLocalService.impl")
    protected VanBanNoiBoLocalService vanBanNoiBoLocalService;
    @javax.annotation.Resource(name = "com.sgs.portlet.vanbannoibo.service.VanBanNoiBoService.impl")
    protected VanBanNoiBoService vanBanNoiBoService;
    @javax.annotation.Resource(name = "com.sgs.portlet.vanbannoibo.service.persistence.VanBanNoiBoPersistence.impl")
    protected VanBanNoiBoPersistence vanBanNoiBoPersistence;
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

    public FileDinhKemVanBanNoiBo addFileDinhKemVanBanNoiBo(
        FileDinhKemVanBanNoiBo fileDinhKemVanBanNoiBo)
        throws SystemException {
        fileDinhKemVanBanNoiBo.setNew(true);

        return fileDinhKemVanBanNoiBoPersistence.update(fileDinhKemVanBanNoiBo,
            false);
    }

    public FileDinhKemVanBanNoiBo createFileDinhKemVanBanNoiBo(
        long fileDinhKemVanBanNoiBoId) {
        return fileDinhKemVanBanNoiBoPersistence.create(fileDinhKemVanBanNoiBoId);
    }

    public void deleteFileDinhKemVanBanNoiBo(long fileDinhKemVanBanNoiBoId)
        throws PortalException, SystemException {
        fileDinhKemVanBanNoiBoPersistence.remove(fileDinhKemVanBanNoiBoId);
    }

    public void deleteFileDinhKemVanBanNoiBo(
        FileDinhKemVanBanNoiBo fileDinhKemVanBanNoiBo)
        throws SystemException {
        fileDinhKemVanBanNoiBoPersistence.remove(fileDinhKemVanBanNoiBo);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return fileDinhKemVanBanNoiBoPersistence.findWithDynamicQuery(dynamicQuery);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery, int start,
        int end) throws SystemException {
        return fileDinhKemVanBanNoiBoPersistence.findWithDynamicQuery(dynamicQuery,
            start, end);
    }

    public FileDinhKemVanBanNoiBo getFileDinhKemVanBanNoiBo(
        long fileDinhKemVanBanNoiBoId) throws PortalException, SystemException {
        return fileDinhKemVanBanNoiBoPersistence.findByPrimaryKey(fileDinhKemVanBanNoiBoId);
    }

    public List<FileDinhKemVanBanNoiBo> getFileDinhKemVanBanNoiBos(int start,
        int end) throws SystemException {
        return fileDinhKemVanBanNoiBoPersistence.findAll(start, end);
    }

    public int getFileDinhKemVanBanNoiBosCount() throws SystemException {
        return fileDinhKemVanBanNoiBoPersistence.countAll();
    }

    public FileDinhKemVanBanNoiBo updateFileDinhKemVanBanNoiBo(
        FileDinhKemVanBanNoiBo fileDinhKemVanBanNoiBo)
        throws SystemException {
        fileDinhKemVanBanNoiBo.setNew(false);

        return fileDinhKemVanBanNoiBoPersistence.update(fileDinhKemVanBanNoiBo,
            true);
    }

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
