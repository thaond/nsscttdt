package com.sgs.portlet.pml_ho_so_cong_viec.service.base;

import com.liferay.counter.service.CounterLocalService;
import com.liferay.counter.service.CounterService;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.service.UserLocalService;
import com.liferay.portal.service.UserService;
import com.liferay.portal.service.persistence.UserPersistence;

import com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec;
import com.sgs.portlet.pml_ho_so_cong_viec.service.PmlChiTietHSCVLocalService;
import com.sgs.portlet.pml_ho_so_cong_viec.service.PmlChiTietHSCVService;
import com.sgs.portlet.pml_ho_so_cong_viec.service.PmlHoSoCongViecLocalService;
import com.sgs.portlet.pml_ho_so_cong_viec.service.PmlHoSoCongViecService;
import com.sgs.portlet.pml_ho_so_cong_viec.service.persistence.PmlChiTietHSCVFinder;
import com.sgs.portlet.pml_ho_so_cong_viec.service.persistence.PmlChiTietHSCVPersistence;
import com.sgs.portlet.pml_ho_so_cong_viec.service.persistence.PmlHoSoCongViecFinder;
import com.sgs.portlet.pml_ho_so_cong_viec.service.persistence.PmlHoSoCongViecPersistence;

import java.util.List;


public abstract class PmlHoSoCongViecLocalServiceBaseImpl
    implements PmlHoSoCongViecLocalService {
    @javax.annotation.Resource(name = "com.sgs.portlet.pml_ho_so_cong_viec.service.PmlHoSoCongViecLocalService.impl")
    protected PmlHoSoCongViecLocalService pmlHoSoCongViecLocalService;
    @javax.annotation.Resource(name = "com.sgs.portlet.pml_ho_so_cong_viec.service.PmlHoSoCongViecService.impl")
    protected PmlHoSoCongViecService pmlHoSoCongViecService;
    @javax.annotation.Resource(name = "com.sgs.portlet.pml_ho_so_cong_viec.service.persistence.PmlHoSoCongViecPersistence.impl")
    protected PmlHoSoCongViecPersistence pmlHoSoCongViecPersistence;
    @javax.annotation.Resource(name = "com.sgs.portlet.pml_ho_so_cong_viec.service.persistence.PmlHoSoCongViecFinder.impl")
    protected PmlHoSoCongViecFinder pmlHoSoCongViecFinder;
    @javax.annotation.Resource(name = "com.sgs.portlet.pml_ho_so_cong_viec.service.PmlChiTietHSCVLocalService.impl")
    protected PmlChiTietHSCVLocalService pmlChiTietHSCVLocalService;
    @javax.annotation.Resource(name = "com.sgs.portlet.pml_ho_so_cong_viec.service.PmlChiTietHSCVService.impl")
    protected PmlChiTietHSCVService pmlChiTietHSCVService;
    @javax.annotation.Resource(name = "com.sgs.portlet.pml_ho_so_cong_viec.service.persistence.PmlChiTietHSCVPersistence.impl")
    protected PmlChiTietHSCVPersistence pmlChiTietHSCVPersistence;
    @javax.annotation.Resource(name = "com.sgs.portlet.pml_ho_so_cong_viec.service.persistence.PmlChiTietHSCVFinder.impl")
    protected PmlChiTietHSCVFinder pmlChiTietHSCVFinder;
    @javax.annotation.Resource(name = "com.liferay.counter.service.CounterLocalService.impl")
    protected CounterLocalService counterLocalService;
    @javax.annotation.Resource(name = "com.liferay.counter.service.CounterService.impl")
    protected CounterService counterService;
    @javax.annotation.Resource(name = "com.liferay.portal.service.UserLocalService.impl")
    protected UserLocalService userLocalService;
    @javax.annotation.Resource(name = "com.liferay.portal.service.UserService.impl")
    protected UserService userService;
    @javax.annotation.Resource(name = "com.liferay.portal.service.persistence.UserPersistence.impl")
    protected UserPersistence userPersistence;

    public PmlHoSoCongViec addPmlHoSoCongViec(PmlHoSoCongViec pmlHoSoCongViec)
        throws SystemException {
        pmlHoSoCongViec.setNew(true);

        return pmlHoSoCongViecPersistence.update(pmlHoSoCongViec, false);
    }

    public PmlHoSoCongViec createPmlHoSoCongViec(long idHoSoCongViec) {
        return pmlHoSoCongViecPersistence.create(idHoSoCongViec);
    }

    public void deletePmlHoSoCongViec(long idHoSoCongViec)
        throws PortalException, SystemException {
        pmlHoSoCongViecPersistence.remove(idHoSoCongViec);
    }

    public void deletePmlHoSoCongViec(PmlHoSoCongViec pmlHoSoCongViec)
        throws SystemException {
        pmlHoSoCongViecPersistence.remove(pmlHoSoCongViec);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return pmlHoSoCongViecPersistence.findWithDynamicQuery(dynamicQuery);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery, int start,
        int end) throws SystemException {
        return pmlHoSoCongViecPersistence.findWithDynamicQuery(dynamicQuery,
            start, end);
    }

    public PmlHoSoCongViec getPmlHoSoCongViec(long idHoSoCongViec)
        throws PortalException, SystemException {
        return pmlHoSoCongViecPersistence.findByPrimaryKey(idHoSoCongViec);
    }

    public List<PmlHoSoCongViec> getPmlHoSoCongViecs(int start, int end)
        throws SystemException {
        return pmlHoSoCongViecPersistence.findAll(start, end);
    }

    public int getPmlHoSoCongViecsCount() throws SystemException {
        return pmlHoSoCongViecPersistence.countAll();
    }

    public PmlHoSoCongViec updatePmlHoSoCongViec(
        PmlHoSoCongViec pmlHoSoCongViec) throws SystemException {
        pmlHoSoCongViec.setNew(false);

        return pmlHoSoCongViecPersistence.update(pmlHoSoCongViec, true);
    }

    public PmlHoSoCongViecLocalService getPmlHoSoCongViecLocalService() {
        return pmlHoSoCongViecLocalService;
    }

    public void setPmlHoSoCongViecLocalService(
        PmlHoSoCongViecLocalService pmlHoSoCongViecLocalService) {
        this.pmlHoSoCongViecLocalService = pmlHoSoCongViecLocalService;
    }

    public PmlHoSoCongViecService getPmlHoSoCongViecService() {
        return pmlHoSoCongViecService;
    }

    public void setPmlHoSoCongViecService(
        PmlHoSoCongViecService pmlHoSoCongViecService) {
        this.pmlHoSoCongViecService = pmlHoSoCongViecService;
    }

    public PmlHoSoCongViecPersistence getPmlHoSoCongViecPersistence() {
        return pmlHoSoCongViecPersistence;
    }

    public void setPmlHoSoCongViecPersistence(
        PmlHoSoCongViecPersistence pmlHoSoCongViecPersistence) {
        this.pmlHoSoCongViecPersistence = pmlHoSoCongViecPersistence;
    }

    public PmlHoSoCongViecFinder getPmlHoSoCongViecFinder() {
        return pmlHoSoCongViecFinder;
    }

    public void setPmlHoSoCongViecFinder(
        PmlHoSoCongViecFinder pmlHoSoCongViecFinder) {
        this.pmlHoSoCongViecFinder = pmlHoSoCongViecFinder;
    }

    public PmlChiTietHSCVLocalService getPmlChiTietHSCVLocalService() {
        return pmlChiTietHSCVLocalService;
    }

    public void setPmlChiTietHSCVLocalService(
        PmlChiTietHSCVLocalService pmlChiTietHSCVLocalService) {
        this.pmlChiTietHSCVLocalService = pmlChiTietHSCVLocalService;
    }

    public PmlChiTietHSCVService getPmlChiTietHSCVService() {
        return pmlChiTietHSCVService;
    }

    public void setPmlChiTietHSCVService(
        PmlChiTietHSCVService pmlChiTietHSCVService) {
        this.pmlChiTietHSCVService = pmlChiTietHSCVService;
    }

    public PmlChiTietHSCVPersistence getPmlChiTietHSCVPersistence() {
        return pmlChiTietHSCVPersistence;
    }

    public void setPmlChiTietHSCVPersistence(
        PmlChiTietHSCVPersistence pmlChiTietHSCVPersistence) {
        this.pmlChiTietHSCVPersistence = pmlChiTietHSCVPersistence;
    }

    public PmlChiTietHSCVFinder getPmlChiTietHSCVFinder() {
        return pmlChiTietHSCVFinder;
    }

    public void setPmlChiTietHSCVFinder(
        PmlChiTietHSCVFinder pmlChiTietHSCVFinder) {
        this.pmlChiTietHSCVFinder = pmlChiTietHSCVFinder;
    }

    public CounterLocalService getCounterLocalService() {
        return counterLocalService;
    }

    public void setCounterLocalService(CounterLocalService counterLocalService) {
        this.counterLocalService = counterLocalService;
    }

    public CounterService getCounterService() {
        return counterService;
    }

    public void setCounterService(CounterService counterService) {
        this.counterService = counterService;
    }

    public UserLocalService getUserLocalService() {
        return userLocalService;
    }

    public void setUserLocalService(UserLocalService userLocalService) {
        this.userLocalService = userLocalService;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public UserPersistence getUserPersistence() {
        return userPersistence;
    }

    public void setUserPersistence(UserPersistence userPersistence) {
        this.userPersistence = userPersistence;
    }
}
