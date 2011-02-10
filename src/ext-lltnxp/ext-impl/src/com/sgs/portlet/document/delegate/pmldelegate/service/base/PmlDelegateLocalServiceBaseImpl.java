package com.sgs.portlet.document.delegate.pmldelegate.service.base;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;

import com.sgs.portlet.document.delegate.pmldelegate.model.PmlDelegate;
import com.sgs.portlet.document.delegate.pmldelegate.service.PmlDelegateLocalService;
import com.sgs.portlet.document.delegate.pmldelegate.service.PmlDelegateService;
import com.sgs.portlet.document.delegate.pmldelegate.service.persistence.PmlDelegateFinder;
import com.sgs.portlet.document.delegate.pmldelegate.service.persistence.PmlDelegatePersistence;

import java.util.List;


public abstract class PmlDelegateLocalServiceBaseImpl
    implements PmlDelegateLocalService {
    @javax.annotation.Resource(name = "com.sgs.portlet.document.delegate.pmldelegate.service.PmlDelegateLocalService.impl")
    protected PmlDelegateLocalService pmlDelegateLocalService;
    @javax.annotation.Resource(name = "com.sgs.portlet.document.delegate.pmldelegate.service.PmlDelegateService.impl")
    protected PmlDelegateService pmlDelegateService;
    @javax.annotation.Resource(name = "com.sgs.portlet.document.delegate.pmldelegate.service.persistence.PmlDelegatePersistence.impl")
    protected PmlDelegatePersistence pmlDelegatePersistence;
    @javax.annotation.Resource(name = "com.sgs.portlet.document.delegate.pmldelegate.service.persistence.PmlDelegateFinder.impl")
    protected PmlDelegateFinder pmlDelegateFinder;

    public PmlDelegate addPmlDelegate(PmlDelegate pmlDelegate)
        throws SystemException {
        pmlDelegate.setNew(true);

        return pmlDelegatePersistence.update(pmlDelegate, false);
    }

    public PmlDelegate createPmlDelegate(long delegateId) {
        return pmlDelegatePersistence.create(delegateId);
    }

    public void deletePmlDelegate(long delegateId)
        throws PortalException, SystemException {
        pmlDelegatePersistence.remove(delegateId);
    }

    public void deletePmlDelegate(PmlDelegate pmlDelegate)
        throws SystemException {
        pmlDelegatePersistence.remove(pmlDelegate);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return pmlDelegatePersistence.findWithDynamicQuery(dynamicQuery);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery, int start,
        int end) throws SystemException {
        return pmlDelegatePersistence.findWithDynamicQuery(dynamicQuery, start,
            end);
    }

    public PmlDelegate getPmlDelegate(long delegateId)
        throws PortalException, SystemException {
        return pmlDelegatePersistence.findByPrimaryKey(delegateId);
    }

    public List<PmlDelegate> getPmlDelegates(int start, int end)
        throws SystemException {
        return pmlDelegatePersistence.findAll(start, end);
    }

    public int getPmlDelegatesCount() throws SystemException {
        return pmlDelegatePersistence.countAll();
    }

    public PmlDelegate updatePmlDelegate(PmlDelegate pmlDelegate)
        throws SystemException {
        pmlDelegate.setNew(false);

        return pmlDelegatePersistence.update(pmlDelegate, true);
    }

    public PmlDelegateLocalService getPmlDelegateLocalService() {
        return pmlDelegateLocalService;
    }

    public void setPmlDelegateLocalService(
        PmlDelegateLocalService pmlDelegateLocalService) {
        this.pmlDelegateLocalService = pmlDelegateLocalService;
    }

    public PmlDelegateService getPmlDelegateService() {
        return pmlDelegateService;
    }

    public void setPmlDelegateService(PmlDelegateService pmlDelegateService) {
        this.pmlDelegateService = pmlDelegateService;
    }

    public PmlDelegatePersistence getPmlDelegatePersistence() {
        return pmlDelegatePersistence;
    }

    public void setPmlDelegatePersistence(
        PmlDelegatePersistence pmlDelegatePersistence) {
        this.pmlDelegatePersistence = pmlDelegatePersistence;
    }

    public PmlDelegateFinder getPmlDelegateFinder() {
        return pmlDelegateFinder;
    }

    public void setPmlDelegateFinder(PmlDelegateFinder pmlDelegateFinder) {
        this.pmlDelegateFinder = pmlDelegateFinder;
    }
}
