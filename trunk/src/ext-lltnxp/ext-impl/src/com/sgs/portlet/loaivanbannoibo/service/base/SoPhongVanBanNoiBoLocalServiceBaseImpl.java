package com.sgs.portlet.loaivanbannoibo.service.base;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;

import com.sgs.portlet.loaivanbannoibo.model.SoPhongVanBanNoiBo;
import com.sgs.portlet.loaivanbannoibo.service.LoaiPhongVanBanNoiBoLocalService;
import com.sgs.portlet.loaivanbannoibo.service.LoaiPhongVanBanNoiBoService;
import com.sgs.portlet.loaivanbannoibo.service.LoaiVanBanNoiBoLocalService;
import com.sgs.portlet.loaivanbannoibo.service.LoaiVanBanNoiBoService;
import com.sgs.portlet.loaivanbannoibo.service.SoLoaiVanBanNoiBoLocalService;
import com.sgs.portlet.loaivanbannoibo.service.SoLoaiVanBanNoiBoService;
import com.sgs.portlet.loaivanbannoibo.service.SoPhongVanBanNoiBoLocalService;
import com.sgs.portlet.loaivanbannoibo.service.SoPhongVanBanNoiBoService;
import com.sgs.portlet.loaivanbannoibo.service.SoVanBanNoiBoLocalService;
import com.sgs.portlet.loaivanbannoibo.service.SoVanBanNoiBoService;
import com.sgs.portlet.loaivanbannoibo.service.persistence.LoaiPhongVanBanNoiBoPersistence;
import com.sgs.portlet.loaivanbannoibo.service.persistence.LoaiVanBanNoiBoFinder;
import com.sgs.portlet.loaivanbannoibo.service.persistence.LoaiVanBanNoiBoPersistence;
import com.sgs.portlet.loaivanbannoibo.service.persistence.SoLoaiVanBanNoiBoPersistence;
import com.sgs.portlet.loaivanbannoibo.service.persistence.SoPhongVanBanNoiBoPK;
import com.sgs.portlet.loaivanbannoibo.service.persistence.SoPhongVanBanNoiBoPersistence;
import com.sgs.portlet.loaivanbannoibo.service.persistence.SoVanBanNoiBoPersistence;

import java.util.List;


public abstract class SoPhongVanBanNoiBoLocalServiceBaseImpl
    implements SoPhongVanBanNoiBoLocalService {
    @javax.annotation.Resource(name = "com.sgs.portlet.loaivanbannoibo.service.LoaiVanBanNoiBoLocalService.impl")
    protected LoaiVanBanNoiBoLocalService loaiVanBanNoiBoLocalService;
    @javax.annotation.Resource(name = "com.sgs.portlet.loaivanbannoibo.service.LoaiVanBanNoiBoService.impl")
    protected LoaiVanBanNoiBoService loaiVanBanNoiBoService;
    @javax.annotation.Resource(name = "com.sgs.portlet.loaivanbannoibo.service.persistence.LoaiVanBanNoiBoPersistence.impl")
    protected LoaiVanBanNoiBoPersistence loaiVanBanNoiBoPersistence;
    @javax.annotation.Resource(name = "com.sgs.portlet.loaivanbannoibo.service.persistence.LoaiVanBanNoiBoFinder.impl")
    protected LoaiVanBanNoiBoFinder loaiVanBanNoiBoFinder;
    @javax.annotation.Resource(name = "com.sgs.portlet.loaivanbannoibo.service.SoVanBanNoiBoLocalService.impl")
    protected SoVanBanNoiBoLocalService soVanBanNoiBoLocalService;
    @javax.annotation.Resource(name = "com.sgs.portlet.loaivanbannoibo.service.SoVanBanNoiBoService.impl")
    protected SoVanBanNoiBoService soVanBanNoiBoService;
    @javax.annotation.Resource(name = "com.sgs.portlet.loaivanbannoibo.service.persistence.SoVanBanNoiBoPersistence.impl")
    protected SoVanBanNoiBoPersistence soVanBanNoiBoPersistence;
    @javax.annotation.Resource(name = "com.sgs.portlet.loaivanbannoibo.service.SoLoaiVanBanNoiBoLocalService.impl")
    protected SoLoaiVanBanNoiBoLocalService soLoaiVanBanNoiBoLocalService;
    @javax.annotation.Resource(name = "com.sgs.portlet.loaivanbannoibo.service.SoLoaiVanBanNoiBoService.impl")
    protected SoLoaiVanBanNoiBoService soLoaiVanBanNoiBoService;
    @javax.annotation.Resource(name = "com.sgs.portlet.loaivanbannoibo.service.persistence.SoLoaiVanBanNoiBoPersistence.impl")
    protected SoLoaiVanBanNoiBoPersistence soLoaiVanBanNoiBoPersistence;
    @javax.annotation.Resource(name = "com.sgs.portlet.loaivanbannoibo.service.SoPhongVanBanNoiBoLocalService.impl")
    protected SoPhongVanBanNoiBoLocalService soPhongVanBanNoiBoLocalService;
    @javax.annotation.Resource(name = "com.sgs.portlet.loaivanbannoibo.service.SoPhongVanBanNoiBoService.impl")
    protected SoPhongVanBanNoiBoService soPhongVanBanNoiBoService;
    @javax.annotation.Resource(name = "com.sgs.portlet.loaivanbannoibo.service.persistence.SoPhongVanBanNoiBoPersistence.impl")
    protected SoPhongVanBanNoiBoPersistence soPhongVanBanNoiBoPersistence;
    @javax.annotation.Resource(name = "com.sgs.portlet.loaivanbannoibo.service.LoaiPhongVanBanNoiBoLocalService.impl")
    protected LoaiPhongVanBanNoiBoLocalService loaiPhongVanBanNoiBoLocalService;
    @javax.annotation.Resource(name = "com.sgs.portlet.loaivanbannoibo.service.LoaiPhongVanBanNoiBoService.impl")
    protected LoaiPhongVanBanNoiBoService loaiPhongVanBanNoiBoService;
    @javax.annotation.Resource(name = "com.sgs.portlet.loaivanbannoibo.service.persistence.LoaiPhongVanBanNoiBoPersistence.impl")
    protected LoaiPhongVanBanNoiBoPersistence loaiPhongVanBanNoiBoPersistence;

    public SoPhongVanBanNoiBo addSoPhongVanBanNoiBo(
        SoPhongVanBanNoiBo soPhongVanBanNoiBo) throws SystemException {
        soPhongVanBanNoiBo.setNew(true);

        return soPhongVanBanNoiBoPersistence.update(soPhongVanBanNoiBo, false);
    }

    public SoPhongVanBanNoiBo createSoPhongVanBanNoiBo(
        SoPhongVanBanNoiBoPK soPhongVanBanNoiBoPK) {
        return soPhongVanBanNoiBoPersistence.create(soPhongVanBanNoiBoPK);
    }

    public void deleteSoPhongVanBanNoiBo(
        SoPhongVanBanNoiBoPK soPhongVanBanNoiBoPK)
        throws PortalException, SystemException {
        soPhongVanBanNoiBoPersistence.remove(soPhongVanBanNoiBoPK);
    }

    public void deleteSoPhongVanBanNoiBo(SoPhongVanBanNoiBo soPhongVanBanNoiBo)
        throws SystemException {
        soPhongVanBanNoiBoPersistence.remove(soPhongVanBanNoiBo);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return soPhongVanBanNoiBoPersistence.findWithDynamicQuery(dynamicQuery);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery, int start,
        int end) throws SystemException {
        return soPhongVanBanNoiBoPersistence.findWithDynamicQuery(dynamicQuery,
            start, end);
    }

    public SoPhongVanBanNoiBo getSoPhongVanBanNoiBo(
        SoPhongVanBanNoiBoPK soPhongVanBanNoiBoPK)
        throws PortalException, SystemException {
        return soPhongVanBanNoiBoPersistence.findByPrimaryKey(soPhongVanBanNoiBoPK);
    }

    public List<SoPhongVanBanNoiBo> getSoPhongVanBanNoiBos(int start, int end)
        throws SystemException {
        return soPhongVanBanNoiBoPersistence.findAll(start, end);
    }

    public int getSoPhongVanBanNoiBosCount() throws SystemException {
        return soPhongVanBanNoiBoPersistence.countAll();
    }

    public SoPhongVanBanNoiBo updateSoPhongVanBanNoiBo(
        SoPhongVanBanNoiBo soPhongVanBanNoiBo) throws SystemException {
        soPhongVanBanNoiBo.setNew(false);

        return soPhongVanBanNoiBoPersistence.update(soPhongVanBanNoiBo, true);
    }

    public LoaiVanBanNoiBoLocalService getLoaiVanBanNoiBoLocalService() {
        return loaiVanBanNoiBoLocalService;
    }

    public void setLoaiVanBanNoiBoLocalService(
        LoaiVanBanNoiBoLocalService loaiVanBanNoiBoLocalService) {
        this.loaiVanBanNoiBoLocalService = loaiVanBanNoiBoLocalService;
    }

    public LoaiVanBanNoiBoService getLoaiVanBanNoiBoService() {
        return loaiVanBanNoiBoService;
    }

    public void setLoaiVanBanNoiBoService(
        LoaiVanBanNoiBoService loaiVanBanNoiBoService) {
        this.loaiVanBanNoiBoService = loaiVanBanNoiBoService;
    }

    public LoaiVanBanNoiBoPersistence getLoaiVanBanNoiBoPersistence() {
        return loaiVanBanNoiBoPersistence;
    }

    public void setLoaiVanBanNoiBoPersistence(
        LoaiVanBanNoiBoPersistence loaiVanBanNoiBoPersistence) {
        this.loaiVanBanNoiBoPersistence = loaiVanBanNoiBoPersistence;
    }

    public LoaiVanBanNoiBoFinder getLoaiVanBanNoiBoFinder() {
        return loaiVanBanNoiBoFinder;
    }

    public void setLoaiVanBanNoiBoFinder(
        LoaiVanBanNoiBoFinder loaiVanBanNoiBoFinder) {
        this.loaiVanBanNoiBoFinder = loaiVanBanNoiBoFinder;
    }

    public SoVanBanNoiBoLocalService getSoVanBanNoiBoLocalService() {
        return soVanBanNoiBoLocalService;
    }

    public void setSoVanBanNoiBoLocalService(
        SoVanBanNoiBoLocalService soVanBanNoiBoLocalService) {
        this.soVanBanNoiBoLocalService = soVanBanNoiBoLocalService;
    }

    public SoVanBanNoiBoService getSoVanBanNoiBoService() {
        return soVanBanNoiBoService;
    }

    public void setSoVanBanNoiBoService(
        SoVanBanNoiBoService soVanBanNoiBoService) {
        this.soVanBanNoiBoService = soVanBanNoiBoService;
    }

    public SoVanBanNoiBoPersistence getSoVanBanNoiBoPersistence() {
        return soVanBanNoiBoPersistence;
    }

    public void setSoVanBanNoiBoPersistence(
        SoVanBanNoiBoPersistence soVanBanNoiBoPersistence) {
        this.soVanBanNoiBoPersistence = soVanBanNoiBoPersistence;
    }

    public SoLoaiVanBanNoiBoLocalService getSoLoaiVanBanNoiBoLocalService() {
        return soLoaiVanBanNoiBoLocalService;
    }

    public void setSoLoaiVanBanNoiBoLocalService(
        SoLoaiVanBanNoiBoLocalService soLoaiVanBanNoiBoLocalService) {
        this.soLoaiVanBanNoiBoLocalService = soLoaiVanBanNoiBoLocalService;
    }

    public SoLoaiVanBanNoiBoService getSoLoaiVanBanNoiBoService() {
        return soLoaiVanBanNoiBoService;
    }

    public void setSoLoaiVanBanNoiBoService(
        SoLoaiVanBanNoiBoService soLoaiVanBanNoiBoService) {
        this.soLoaiVanBanNoiBoService = soLoaiVanBanNoiBoService;
    }

    public SoLoaiVanBanNoiBoPersistence getSoLoaiVanBanNoiBoPersistence() {
        return soLoaiVanBanNoiBoPersistence;
    }

    public void setSoLoaiVanBanNoiBoPersistence(
        SoLoaiVanBanNoiBoPersistence soLoaiVanBanNoiBoPersistence) {
        this.soLoaiVanBanNoiBoPersistence = soLoaiVanBanNoiBoPersistence;
    }

    public SoPhongVanBanNoiBoLocalService getSoPhongVanBanNoiBoLocalService() {
        return soPhongVanBanNoiBoLocalService;
    }

    public void setSoPhongVanBanNoiBoLocalService(
        SoPhongVanBanNoiBoLocalService soPhongVanBanNoiBoLocalService) {
        this.soPhongVanBanNoiBoLocalService = soPhongVanBanNoiBoLocalService;
    }

    public SoPhongVanBanNoiBoService getSoPhongVanBanNoiBoService() {
        return soPhongVanBanNoiBoService;
    }

    public void setSoPhongVanBanNoiBoService(
        SoPhongVanBanNoiBoService soPhongVanBanNoiBoService) {
        this.soPhongVanBanNoiBoService = soPhongVanBanNoiBoService;
    }

    public SoPhongVanBanNoiBoPersistence getSoPhongVanBanNoiBoPersistence() {
        return soPhongVanBanNoiBoPersistence;
    }

    public void setSoPhongVanBanNoiBoPersistence(
        SoPhongVanBanNoiBoPersistence soPhongVanBanNoiBoPersistence) {
        this.soPhongVanBanNoiBoPersistence = soPhongVanBanNoiBoPersistence;
    }

    public LoaiPhongVanBanNoiBoLocalService getLoaiPhongVanBanNoiBoLocalService() {
        return loaiPhongVanBanNoiBoLocalService;
    }

    public void setLoaiPhongVanBanNoiBoLocalService(
        LoaiPhongVanBanNoiBoLocalService loaiPhongVanBanNoiBoLocalService) {
        this.loaiPhongVanBanNoiBoLocalService = loaiPhongVanBanNoiBoLocalService;
    }

    public LoaiPhongVanBanNoiBoService getLoaiPhongVanBanNoiBoService() {
        return loaiPhongVanBanNoiBoService;
    }

    public void setLoaiPhongVanBanNoiBoService(
        LoaiPhongVanBanNoiBoService loaiPhongVanBanNoiBoService) {
        this.loaiPhongVanBanNoiBoService = loaiPhongVanBanNoiBoService;
    }

    public LoaiPhongVanBanNoiBoPersistence getLoaiPhongVanBanNoiBoPersistence() {
        return loaiPhongVanBanNoiBoPersistence;
    }

    public void setLoaiPhongVanBanNoiBoPersistence(
        LoaiPhongVanBanNoiBoPersistence loaiPhongVanBanNoiBoPersistence) {
        this.loaiPhongVanBanNoiBoPersistence = loaiPhongVanBanNoiBoPersistence;
    }
}
