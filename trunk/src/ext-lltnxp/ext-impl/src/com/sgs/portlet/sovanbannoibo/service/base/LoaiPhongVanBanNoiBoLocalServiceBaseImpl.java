package com.sgs.portlet.sovanbannoibo.service.base;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;

import com.sgs.portlet.sovanbannoibo.model.LoaiPhongVanBanNoiBo;
import com.sgs.portlet.sovanbannoibo.service.LoaiPhongVanBanNoiBoLocalService;
import com.sgs.portlet.sovanbannoibo.service.LoaiPhongVanBanNoiBoService;
import com.sgs.portlet.sovanbannoibo.service.LoaiVanBanNoiBoCuaSoLocalService;
import com.sgs.portlet.sovanbannoibo.service.LoaiVanBanNoiBoCuaSoService;
import com.sgs.portlet.sovanbannoibo.service.LoaiVanBanNoiBoLocalService;
import com.sgs.portlet.sovanbannoibo.service.LoaiVanBanNoiBoService;
import com.sgs.portlet.sovanbannoibo.service.SoLoaiVanBanNoiBoLocalService;
import com.sgs.portlet.sovanbannoibo.service.SoLoaiVanBanNoiBoService;
import com.sgs.portlet.sovanbannoibo.service.SoPhongVanBanNoiBoLocalService;
import com.sgs.portlet.sovanbannoibo.service.SoPhongVanBanNoiBoService;
import com.sgs.portlet.sovanbannoibo.service.SoVanBanNoiBoLocalService;
import com.sgs.portlet.sovanbannoibo.service.SoVanBanNoiBoService;
import com.sgs.portlet.sovanbannoibo.service.persistence.LoaiPhongVanBanNoiBoPK;
import com.sgs.portlet.sovanbannoibo.service.persistence.LoaiPhongVanBanNoiBoPersistence;
import com.sgs.portlet.sovanbannoibo.service.persistence.LoaiVanBanNoiBoCuaSoFinder;
import com.sgs.portlet.sovanbannoibo.service.persistence.LoaiVanBanNoiBoCuaSoPersistence;
import com.sgs.portlet.sovanbannoibo.service.persistence.LoaiVanBanNoiBoFinder;
import com.sgs.portlet.sovanbannoibo.service.persistence.LoaiVanBanNoiBoPersistence;
import com.sgs.portlet.sovanbannoibo.service.persistence.SoLoaiVanBanNoiBoPersistence;
import com.sgs.portlet.sovanbannoibo.service.persistence.SoPhongVanBanNoiBoPersistence;
import com.sgs.portlet.sovanbannoibo.service.persistence.SoVanBanNoiBoFinder;
import com.sgs.portlet.sovanbannoibo.service.persistence.SoVanBanNoiBoPersistence;

import java.util.List;


public abstract class LoaiPhongVanBanNoiBoLocalServiceBaseImpl
    implements LoaiPhongVanBanNoiBoLocalService {
    @javax.annotation.Resource(name = "com.sgs.portlet.sovanbannoibo.service.LoaiVanBanNoiBoLocalService.impl")
    protected LoaiVanBanNoiBoLocalService loaiVanBanNoiBoLocalService;
    @javax.annotation.Resource(name = "com.sgs.portlet.sovanbannoibo.service.LoaiVanBanNoiBoService.impl")
    protected LoaiVanBanNoiBoService loaiVanBanNoiBoService;
    @javax.annotation.Resource(name = "com.sgs.portlet.sovanbannoibo.service.persistence.LoaiVanBanNoiBoPersistence.impl")
    protected LoaiVanBanNoiBoPersistence loaiVanBanNoiBoPersistence;
    @javax.annotation.Resource(name = "com.sgs.portlet.sovanbannoibo.service.persistence.LoaiVanBanNoiBoFinder.impl")
    protected LoaiVanBanNoiBoFinder loaiVanBanNoiBoFinder;
    @javax.annotation.Resource(name = "com.sgs.portlet.sovanbannoibo.service.LoaiVanBanNoiBoCuaSoLocalService.impl")
    protected LoaiVanBanNoiBoCuaSoLocalService loaiVanBanNoiBoCuaSoLocalService;
    @javax.annotation.Resource(name = "com.sgs.portlet.sovanbannoibo.service.LoaiVanBanNoiBoCuaSoService.impl")
    protected LoaiVanBanNoiBoCuaSoService loaiVanBanNoiBoCuaSoService;
    @javax.annotation.Resource(name = "com.sgs.portlet.sovanbannoibo.service.persistence.LoaiVanBanNoiBoCuaSoPersistence.impl")
    protected LoaiVanBanNoiBoCuaSoPersistence loaiVanBanNoiBoCuaSoPersistence;
    @javax.annotation.Resource(name = "com.sgs.portlet.sovanbannoibo.service.persistence.LoaiVanBanNoiBoCuaSoFinder.impl")
    protected LoaiVanBanNoiBoCuaSoFinder loaiVanBanNoiBoCuaSoFinder;
    @javax.annotation.Resource(name = "com.sgs.portlet.sovanbannoibo.service.SoVanBanNoiBoLocalService.impl")
    protected SoVanBanNoiBoLocalService soVanBanNoiBoLocalService;
    @javax.annotation.Resource(name = "com.sgs.portlet.sovanbannoibo.service.SoVanBanNoiBoService.impl")
    protected SoVanBanNoiBoService soVanBanNoiBoService;
    @javax.annotation.Resource(name = "com.sgs.portlet.sovanbannoibo.service.persistence.SoVanBanNoiBoPersistence.impl")
    protected SoVanBanNoiBoPersistence soVanBanNoiBoPersistence;
    @javax.annotation.Resource(name = "com.sgs.portlet.sovanbannoibo.service.persistence.SoVanBanNoiBoFinder.impl")
    protected SoVanBanNoiBoFinder soVanBanNoiBoFinder;
    @javax.annotation.Resource(name = "com.sgs.portlet.sovanbannoibo.service.SoLoaiVanBanNoiBoLocalService.impl")
    protected SoLoaiVanBanNoiBoLocalService soLoaiVanBanNoiBoLocalService;
    @javax.annotation.Resource(name = "com.sgs.portlet.sovanbannoibo.service.SoLoaiVanBanNoiBoService.impl")
    protected SoLoaiVanBanNoiBoService soLoaiVanBanNoiBoService;
    @javax.annotation.Resource(name = "com.sgs.portlet.sovanbannoibo.service.persistence.SoLoaiVanBanNoiBoPersistence.impl")
    protected SoLoaiVanBanNoiBoPersistence soLoaiVanBanNoiBoPersistence;
    @javax.annotation.Resource(name = "com.sgs.portlet.sovanbannoibo.service.SoPhongVanBanNoiBoLocalService.impl")
    protected SoPhongVanBanNoiBoLocalService soPhongVanBanNoiBoLocalService;
    @javax.annotation.Resource(name = "com.sgs.portlet.sovanbannoibo.service.SoPhongVanBanNoiBoService.impl")
    protected SoPhongVanBanNoiBoService soPhongVanBanNoiBoService;
    @javax.annotation.Resource(name = "com.sgs.portlet.sovanbannoibo.service.persistence.SoPhongVanBanNoiBoPersistence.impl")
    protected SoPhongVanBanNoiBoPersistence soPhongVanBanNoiBoPersistence;
    @javax.annotation.Resource(name = "com.sgs.portlet.sovanbannoibo.service.LoaiPhongVanBanNoiBoLocalService.impl")
    protected LoaiPhongVanBanNoiBoLocalService loaiPhongVanBanNoiBoLocalService;
    @javax.annotation.Resource(name = "com.sgs.portlet.sovanbannoibo.service.LoaiPhongVanBanNoiBoService.impl")
    protected LoaiPhongVanBanNoiBoService loaiPhongVanBanNoiBoService;
    @javax.annotation.Resource(name = "com.sgs.portlet.sovanbannoibo.service.persistence.LoaiPhongVanBanNoiBoPersistence.impl")
    protected LoaiPhongVanBanNoiBoPersistence loaiPhongVanBanNoiBoPersistence;

    public LoaiPhongVanBanNoiBo addLoaiPhongVanBanNoiBo(
        LoaiPhongVanBanNoiBo loaiPhongVanBanNoiBo) throws SystemException {
        loaiPhongVanBanNoiBo.setNew(true);

        return loaiPhongVanBanNoiBoPersistence.update(loaiPhongVanBanNoiBo,
            false);
    }

    public LoaiPhongVanBanNoiBo createLoaiPhongVanBanNoiBo(
        LoaiPhongVanBanNoiBoPK loaiPhongVanBanNoiBoPK) {
        return loaiPhongVanBanNoiBoPersistence.create(loaiPhongVanBanNoiBoPK);
    }

    public void deleteLoaiPhongVanBanNoiBo(
        LoaiPhongVanBanNoiBoPK loaiPhongVanBanNoiBoPK)
        throws PortalException, SystemException {
        loaiPhongVanBanNoiBoPersistence.remove(loaiPhongVanBanNoiBoPK);
    }

    public void deleteLoaiPhongVanBanNoiBo(
        LoaiPhongVanBanNoiBo loaiPhongVanBanNoiBo) throws SystemException {
        loaiPhongVanBanNoiBoPersistence.remove(loaiPhongVanBanNoiBo);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return loaiPhongVanBanNoiBoPersistence.findWithDynamicQuery(dynamicQuery);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery, int start,
        int end) throws SystemException {
        return loaiPhongVanBanNoiBoPersistence.findWithDynamicQuery(dynamicQuery,
            start, end);
    }

    public LoaiPhongVanBanNoiBo getLoaiPhongVanBanNoiBo(
        LoaiPhongVanBanNoiBoPK loaiPhongVanBanNoiBoPK)
        throws PortalException, SystemException {
        return loaiPhongVanBanNoiBoPersistence.findByPrimaryKey(loaiPhongVanBanNoiBoPK);
    }

    public List<LoaiPhongVanBanNoiBo> getLoaiPhongVanBanNoiBos(int start,
        int end) throws SystemException {
        return loaiPhongVanBanNoiBoPersistence.findAll(start, end);
    }

    public int getLoaiPhongVanBanNoiBosCount() throws SystemException {
        return loaiPhongVanBanNoiBoPersistence.countAll();
    }

    public LoaiPhongVanBanNoiBo updateLoaiPhongVanBanNoiBo(
        LoaiPhongVanBanNoiBo loaiPhongVanBanNoiBo) throws SystemException {
        loaiPhongVanBanNoiBo.setNew(false);

        return loaiPhongVanBanNoiBoPersistence.update(loaiPhongVanBanNoiBo, true);
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

    public LoaiVanBanNoiBoCuaSoLocalService getLoaiVanBanNoiBoCuaSoLocalService() {
        return loaiVanBanNoiBoCuaSoLocalService;
    }

    public void setLoaiVanBanNoiBoCuaSoLocalService(
        LoaiVanBanNoiBoCuaSoLocalService loaiVanBanNoiBoCuaSoLocalService) {
        this.loaiVanBanNoiBoCuaSoLocalService = loaiVanBanNoiBoCuaSoLocalService;
    }

    public LoaiVanBanNoiBoCuaSoService getLoaiVanBanNoiBoCuaSoService() {
        return loaiVanBanNoiBoCuaSoService;
    }

    public void setLoaiVanBanNoiBoCuaSoService(
        LoaiVanBanNoiBoCuaSoService loaiVanBanNoiBoCuaSoService) {
        this.loaiVanBanNoiBoCuaSoService = loaiVanBanNoiBoCuaSoService;
    }

    public LoaiVanBanNoiBoCuaSoPersistence getLoaiVanBanNoiBoCuaSoPersistence() {
        return loaiVanBanNoiBoCuaSoPersistence;
    }

    public void setLoaiVanBanNoiBoCuaSoPersistence(
        LoaiVanBanNoiBoCuaSoPersistence loaiVanBanNoiBoCuaSoPersistence) {
        this.loaiVanBanNoiBoCuaSoPersistence = loaiVanBanNoiBoCuaSoPersistence;
    }

    public LoaiVanBanNoiBoCuaSoFinder getLoaiVanBanNoiBoCuaSoFinder() {
        return loaiVanBanNoiBoCuaSoFinder;
    }

    public void setLoaiVanBanNoiBoCuaSoFinder(
        LoaiVanBanNoiBoCuaSoFinder loaiVanBanNoiBoCuaSoFinder) {
        this.loaiVanBanNoiBoCuaSoFinder = loaiVanBanNoiBoCuaSoFinder;
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

    public SoVanBanNoiBoFinder getSoVanBanNoiBoFinder() {
        return soVanBanNoiBoFinder;
    }

    public void setSoVanBanNoiBoFinder(SoVanBanNoiBoFinder soVanBanNoiBoFinder) {
        this.soVanBanNoiBoFinder = soVanBanNoiBoFinder;
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
