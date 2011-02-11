package com.sgs.portlet.pml_edm_docconfuser.service.base;

import com.liferay.counter.service.CounterLocalService;
import com.liferay.counter.service.CounterService;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.service.UserLocalService;
import com.liferay.portal.service.UserService;
import com.liferay.portal.service.persistence.UserPersistence;

import com.sgs.portlet.pml_edm_docconfuser.model.PmlEdmDocConfUser;
import com.sgs.portlet.pml_edm_docconfuser.service.PmlEdmDocConfUserLocalService;
import com.sgs.portlet.pml_edm_docconfuser.service.PmlEdmDocConfUserService;
import com.sgs.portlet.pml_edm_docconfuser.service.persistence.PmlEdmDocConfUserFinder;
import com.sgs.portlet.pml_edm_docconfuser.service.persistence.PmlEdmDocConfUserPersistence;

import java.util.List;


public abstract class PmlEdmDocConfUserLocalServiceBaseImpl
    implements PmlEdmDocConfUserLocalService {
    @javax.annotation.Resource(name = "com.sgs.portlet.pml_edm_docconfuser.service.PmlEdmDocConfUserLocalService.impl")
    protected PmlEdmDocConfUserLocalService pmlEdmDocConfUserLocalService;
    @javax.annotation.Resource(name = "com.sgs.portlet.pml_edm_docconfuser.service.PmlEdmDocConfUserService.impl")
    protected PmlEdmDocConfUserService pmlEdmDocConfUserService;
    @javax.annotation.Resource(name = "com.sgs.portlet.pml_edm_docconfuser.service.persistence.PmlEdmDocConfUserPersistence.impl")
    protected PmlEdmDocConfUserPersistence pmlEdmDocConfUserPersistence;
    @javax.annotation.Resource(name = "com.sgs.portlet.pml_edm_docconfuser.service.persistence.PmlEdmDocConfUserFinder.impl")
    protected PmlEdmDocConfUserFinder pmlEdmDocConfUserFinder;
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

    public PmlEdmDocConfUser addPmlEdmDocConfUser(
        PmlEdmDocConfUser pmlEdmDocConfUser) throws SystemException {
        pmlEdmDocConfUser.setNew(true);

        return pmlEdmDocConfUserPersistence.update(pmlEdmDocConfUser, false);
    }

    public PmlEdmDocConfUser createPmlEdmDocConfUser(long dcuId) {
        return pmlEdmDocConfUserPersistence.create(dcuId);
    }

    public void deletePmlEdmDocConfUser(long dcuId)
        throws PortalException, SystemException {
        pmlEdmDocConfUserPersistence.remove(dcuId);
    }

    public void deletePmlEdmDocConfUser(PmlEdmDocConfUser pmlEdmDocConfUser)
        throws SystemException {
        pmlEdmDocConfUserPersistence.remove(pmlEdmDocConfUser);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return pmlEdmDocConfUserPersistence.findWithDynamicQuery(dynamicQuery);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery, int start,
        int end) throws SystemException {
        return pmlEdmDocConfUserPersistence.findWithDynamicQuery(dynamicQuery,
            start, end);
    }

    public PmlEdmDocConfUser getPmlEdmDocConfUser(long dcuId)
        throws PortalException, SystemException {
        return pmlEdmDocConfUserPersistence.findByPrimaryKey(dcuId);
    }

    public List<PmlEdmDocConfUser> getPmlEdmDocConfUsers(int start, int end)
        throws SystemException {
        return pmlEdmDocConfUserPersistence.findAll(start, end);
    }

    public int getPmlEdmDocConfUsersCount() throws SystemException {
        return pmlEdmDocConfUserPersistence.countAll();
    }

    public PmlEdmDocConfUser updatePmlEdmDocConfUser(
        PmlEdmDocConfUser pmlEdmDocConfUser) throws SystemException {
        pmlEdmDocConfUser.setNew(false);

        return pmlEdmDocConfUserPersistence.update(pmlEdmDocConfUser, true);
    }

    public PmlEdmDocConfUserLocalService getPmlEdmDocConfUserLocalService() {
        return pmlEdmDocConfUserLocalService;
    }

    public void setPmlEdmDocConfUserLocalService(
        PmlEdmDocConfUserLocalService pmlEdmDocConfUserLocalService) {
        this.pmlEdmDocConfUserLocalService = pmlEdmDocConfUserLocalService;
    }

    public PmlEdmDocConfUserService getPmlEdmDocConfUserService() {
        return pmlEdmDocConfUserService;
    }

    public void setPmlEdmDocConfUserService(
        PmlEdmDocConfUserService pmlEdmDocConfUserService) {
        this.pmlEdmDocConfUserService = pmlEdmDocConfUserService;
    }

    public PmlEdmDocConfUserPersistence getPmlEdmDocConfUserPersistence() {
        return pmlEdmDocConfUserPersistence;
    }

    public void setPmlEdmDocConfUserPersistence(
        PmlEdmDocConfUserPersistence pmlEdmDocConfUserPersistence) {
        this.pmlEdmDocConfUserPersistence = pmlEdmDocConfUserPersistence;
    }

    public PmlEdmDocConfUserFinder getPmlEdmDocConfUserFinder() {
        return pmlEdmDocConfUserFinder;
    }

    public void setPmlEdmDocConfUserFinder(
        PmlEdmDocConfUserFinder pmlEdmDocConfUserFinder) {
        this.pmlEdmDocConfUserFinder = pmlEdmDocConfUserFinder;
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
