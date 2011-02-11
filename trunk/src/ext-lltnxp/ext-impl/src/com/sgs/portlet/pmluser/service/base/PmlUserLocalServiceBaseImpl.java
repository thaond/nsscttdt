package com.sgs.portlet.pmluser.service.base;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;

import com.sgs.portlet.pmluser.model.PmlUser;
import com.sgs.portlet.pmluser.service.PmlUserLocalService;
import com.sgs.portlet.pmluser.service.PmlUserService;
import com.sgs.portlet.pmluser.service.persistence.PmlUserFinder;
import com.sgs.portlet.pmluser.service.persistence.PmlUserPersistence;

import java.util.List;


public abstract class PmlUserLocalServiceBaseImpl implements PmlUserLocalService {
    @javax.annotation.Resource(name = "com.sgs.portlet.pmluser.service.PmlUserLocalService.impl")
    protected PmlUserLocalService pmlUserLocalService;
    @javax.annotation.Resource(name = "com.sgs.portlet.pmluser.service.PmlUserService.impl")
    protected PmlUserService pmlUserService;
    @javax.annotation.Resource(name = "com.sgs.portlet.pmluser.service.persistence.PmlUserPersistence.impl")
    protected PmlUserPersistence pmlUserPersistence;
    @javax.annotation.Resource(name = "com.sgs.portlet.pmluser.service.persistence.PmlUserFinder.impl")
    protected PmlUserFinder pmlUserFinder;

    public PmlUser addPmlUser(PmlUser pmlUser) throws SystemException {
        pmlUser.setNew(true);

        return pmlUserPersistence.update(pmlUser, false);
    }

    public PmlUser createPmlUser(long userId) {
        return pmlUserPersistence.create(userId);
    }

    public void deletePmlUser(long userId)
        throws PortalException, SystemException {
        pmlUserPersistence.remove(userId);
    }

    public void deletePmlUser(PmlUser pmlUser) throws SystemException {
        pmlUserPersistence.remove(pmlUser);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return pmlUserPersistence.findWithDynamicQuery(dynamicQuery);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery, int start,
        int end) throws SystemException {
        return pmlUserPersistence.findWithDynamicQuery(dynamicQuery, start, end);
    }

    public PmlUser getPmlUser(long userId)
        throws PortalException, SystemException {
        return pmlUserPersistence.findByPrimaryKey(userId);
    }

    public List<PmlUser> getPmlUsers(int start, int end)
        throws SystemException {
        return pmlUserPersistence.findAll(start, end);
    }

    public int getPmlUsersCount() throws SystemException {
        return pmlUserPersistence.countAll();
    }

    public PmlUser updatePmlUser(PmlUser pmlUser) throws SystemException {
        pmlUser.setNew(false);

        return pmlUserPersistence.update(pmlUser, true);
    }

    public PmlUserLocalService getPmlUserLocalService() {
        return pmlUserLocalService;
    }

    public void setPmlUserLocalService(PmlUserLocalService pmlUserLocalService) {
        this.pmlUserLocalService = pmlUserLocalService;
    }

    public PmlUserService getPmlUserService() {
        return pmlUserService;
    }

    public void setPmlUserService(PmlUserService pmlUserService) {
        this.pmlUserService = pmlUserService;
    }

    public PmlUserPersistence getPmlUserPersistence() {
        return pmlUserPersistence;
    }

    public void setPmlUserPersistence(PmlUserPersistence pmlUserPersistence) {
        this.pmlUserPersistence = pmlUserPersistence;
    }

    public PmlUserFinder getPmlUserFinder() {
        return pmlUserFinder;
    }

    public void setPmlUserFinder(PmlUserFinder pmlUserFinder) {
        this.pmlUserFinder = pmlUserFinder;
    }
}
