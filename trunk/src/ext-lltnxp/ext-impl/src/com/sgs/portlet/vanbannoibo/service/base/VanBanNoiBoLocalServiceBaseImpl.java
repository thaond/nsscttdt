package com.sgs.portlet.vanbannoibo.service.base;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;

import com.sgs.portlet.vanbannoibo.model.VanBanNoiBo;
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


public abstract class VanBanNoiBoLocalServiceBaseImpl
    implements VanBanNoiBoLocalService {
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

    public VanBanNoiBo addVanBanNoiBo(VanBanNoiBo vanBanNoiBo)
        throws SystemException {
        vanBanNoiBo.setNew(true);

        return vanBanNoiBoPersistence.update(vanBanNoiBo, false);
    }

    public VanBanNoiBo createVanBanNoiBo(long vanBanNoiBoId) {
        return vanBanNoiBoPersistence.create(vanBanNoiBoId);
    }

    public void deleteVanBanNoiBo(long vanBanNoiBoId)
        throws PortalException, SystemException {
        vanBanNoiBoPersistence.remove(vanBanNoiBoId);
    }

    public void deleteVanBanNoiBo(VanBanNoiBo vanBanNoiBo)
        throws SystemException {
        vanBanNoiBoPersistence.remove(vanBanNoiBo);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return vanBanNoiBoPersistence.findWithDynamicQuery(dynamicQuery);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery, int start,
        int end) throws SystemException {
        return vanBanNoiBoPersistence.findWithDynamicQuery(dynamicQuery, start,
            end);
    }

    public VanBanNoiBo getVanBanNoiBo(long vanBanNoiBoId)
        throws PortalException, SystemException {
        return vanBanNoiBoPersistence.findByPrimaryKey(vanBanNoiBoId);
    }

    public List<VanBanNoiBo> getVanBanNoiBos(int start, int end)
        throws SystemException {
        return vanBanNoiBoPersistence.findAll(start, end);
    }

    public int getVanBanNoiBosCount() throws SystemException {
        return vanBanNoiBoPersistence.countAll();
    }

    public VanBanNoiBo updateVanBanNoiBo(VanBanNoiBo vanBanNoiBo)
        throws SystemException {
        vanBanNoiBo.setNew(false);

        return vanBanNoiBoPersistence.update(vanBanNoiBo, true);
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
