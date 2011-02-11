package com.sgs.portlet.pml_ho_so_cong_viec.service.base;

import com.liferay.counter.service.CounterLocalService;
import com.liferay.counter.service.CounterService;

import com.liferay.portal.service.UserLocalService;
import com.liferay.portal.service.UserService;
import com.liferay.portal.service.base.PrincipalBean;
import com.liferay.portal.service.persistence.UserPersistence;

import com.sgs.portlet.pml_ho_so_cong_viec.service.PmlChiTietHSCVLocalService;
import com.sgs.portlet.pml_ho_so_cong_viec.service.PmlChiTietHSCVService;
import com.sgs.portlet.pml_ho_so_cong_viec.service.PmlHoSoCongViecLocalService;
import com.sgs.portlet.pml_ho_so_cong_viec.service.PmlHoSoCongViecService;
import com.sgs.portlet.pml_ho_so_cong_viec.service.persistence.PmlChiTietHSCVFinder;
import com.sgs.portlet.pml_ho_so_cong_viec.service.persistence.PmlChiTietHSCVPersistence;
import com.sgs.portlet.pml_ho_so_cong_viec.service.persistence.PmlHoSoCongViecFinder;
import com.sgs.portlet.pml_ho_so_cong_viec.service.persistence.PmlHoSoCongViecPersistence;


public abstract class PmlHoSoCongViecServiceBaseImpl extends PrincipalBean
    implements PmlHoSoCongViecService {
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
