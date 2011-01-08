package com.sgs.portlet.documentdelegate.service.base;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;

import com.sgs.portlet.documentdelegate.model.PmlDocumentDelegate;
import com.sgs.portlet.documentdelegate.service.PmlDocumentDelegateLocalService;
import com.sgs.portlet.documentdelegate.service.PmlDocumentDelegateService;
import com.sgs.portlet.documentdelegate.service.persistence.PmlDocumentDelegateFinder;
import com.sgs.portlet.documentdelegate.service.persistence.PmlDocumentDelegatePersistence;

import java.util.List;


public abstract class PmlDocumentDelegateLocalServiceBaseImpl
    implements PmlDocumentDelegateLocalService {
    @javax.annotation.Resource(name = "com.sgs.portlet.documentdelegate.service.PmlDocumentDelegateLocalService.impl")
    protected PmlDocumentDelegateLocalService pmlDocumentDelegateLocalService;
    @javax.annotation.Resource(name = "com.sgs.portlet.documentdelegate.service.PmlDocumentDelegateService.impl")
    protected PmlDocumentDelegateService pmlDocumentDelegateService;
    @javax.annotation.Resource(name = "com.sgs.portlet.documentdelegate.service.persistence.PmlDocumentDelegatePersistence.impl")
    protected PmlDocumentDelegatePersistence pmlDocumentDelegatePersistence;
    @javax.annotation.Resource(name = "com.sgs.portlet.documentdelegate.service.persistence.PmlDocumentDelegateFinder.impl")
    protected PmlDocumentDelegateFinder pmlDocumentDelegateFinder;

    public PmlDocumentDelegate addPmlDocumentDelegate(
        PmlDocumentDelegate pmlDocumentDelegate) throws SystemException {
        pmlDocumentDelegate.setNew(true);

        return pmlDocumentDelegatePersistence.update(pmlDocumentDelegate, false);
    }

    public PmlDocumentDelegate createPmlDocumentDelegate(
        long documentDelegateId) {
        return pmlDocumentDelegatePersistence.create(documentDelegateId);
    }

    public void deletePmlDocumentDelegate(long documentDelegateId)
        throws PortalException, SystemException {
        pmlDocumentDelegatePersistence.remove(documentDelegateId);
    }

    public void deletePmlDocumentDelegate(
        PmlDocumentDelegate pmlDocumentDelegate) throws SystemException {
        pmlDocumentDelegatePersistence.remove(pmlDocumentDelegate);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return pmlDocumentDelegatePersistence.findWithDynamicQuery(dynamicQuery);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery, int start,
        int end) throws SystemException {
        return pmlDocumentDelegatePersistence.findWithDynamicQuery(dynamicQuery,
            start, end);
    }

    public PmlDocumentDelegate getPmlDocumentDelegate(long documentDelegateId)
        throws PortalException, SystemException {
        return pmlDocumentDelegatePersistence.findByPrimaryKey(documentDelegateId);
    }

    public List<PmlDocumentDelegate> getPmlDocumentDelegates(int start, int end)
        throws SystemException {
        return pmlDocumentDelegatePersistence.findAll(start, end);
    }

    public int getPmlDocumentDelegatesCount() throws SystemException {
        return pmlDocumentDelegatePersistence.countAll();
    }

    public PmlDocumentDelegate updatePmlDocumentDelegate(
        PmlDocumentDelegate pmlDocumentDelegate) throws SystemException {
        pmlDocumentDelegate.setNew(false);

        return pmlDocumentDelegatePersistence.update(pmlDocumentDelegate, true);
    }

    public PmlDocumentDelegateLocalService getPmlDocumentDelegateLocalService() {
        return pmlDocumentDelegateLocalService;
    }

    public void setPmlDocumentDelegateLocalService(
        PmlDocumentDelegateLocalService pmlDocumentDelegateLocalService) {
        this.pmlDocumentDelegateLocalService = pmlDocumentDelegateLocalService;
    }

    public PmlDocumentDelegateService getPmlDocumentDelegateService() {
        return pmlDocumentDelegateService;
    }

    public void setPmlDocumentDelegateService(
        PmlDocumentDelegateService pmlDocumentDelegateService) {
        this.pmlDocumentDelegateService = pmlDocumentDelegateService;
    }

    public PmlDocumentDelegatePersistence getPmlDocumentDelegatePersistence() {
        return pmlDocumentDelegatePersistence;
    }

    public void setPmlDocumentDelegatePersistence(
        PmlDocumentDelegatePersistence pmlDocumentDelegatePersistence) {
        this.pmlDocumentDelegatePersistence = pmlDocumentDelegatePersistence;
    }

    public PmlDocumentDelegateFinder getPmlDocumentDelegateFinder() {
        return pmlDocumentDelegateFinder;
    }

    public void setPmlDocumentDelegateFinder(
        PmlDocumentDelegateFinder pmlDocumentDelegateFinder) {
        this.pmlDocumentDelegateFinder = pmlDocumentDelegateFinder;
    }
}
