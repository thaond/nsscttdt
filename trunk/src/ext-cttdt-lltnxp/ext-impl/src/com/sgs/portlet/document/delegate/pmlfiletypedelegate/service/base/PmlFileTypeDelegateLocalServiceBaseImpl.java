package com.sgs.portlet.document.delegate.pmlfiletypedelegate.service.base;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;

import com.sgs.portlet.document.delegate.pmlfiletypedelegate.model.PmlFileTypeDelegate;
import com.sgs.portlet.document.delegate.pmlfiletypedelegate.service.PmlFileTypeDelegateLocalService;
import com.sgs.portlet.document.delegate.pmlfiletypedelegate.service.PmlFileTypeDelegateService;
import com.sgs.portlet.document.delegate.pmlfiletypedelegate.service.persistence.PmlFileTypeDelegatePersistence;

import java.util.List;


public abstract class PmlFileTypeDelegateLocalServiceBaseImpl
    implements PmlFileTypeDelegateLocalService {
    @javax.annotation.Resource(name = "com.sgs.portlet.document.delegate.pmlfiletypedelegate.service.PmlFileTypeDelegateLocalService.impl")
    protected PmlFileTypeDelegateLocalService pmlFileTypeDelegateLocalService;
    @javax.annotation.Resource(name = "com.sgs.portlet.document.delegate.pmlfiletypedelegate.service.PmlFileTypeDelegateService.impl")
    protected PmlFileTypeDelegateService pmlFileTypeDelegateService;
    @javax.annotation.Resource(name = "com.sgs.portlet.document.delegate.pmlfiletypedelegate.service.persistence.PmlFileTypeDelegatePersistence.impl")
    protected PmlFileTypeDelegatePersistence pmlFileTypeDelegatePersistence;

    public PmlFileTypeDelegate addPmlFileTypeDelegate(
        PmlFileTypeDelegate pmlFileTypeDelegate) throws SystemException {
        pmlFileTypeDelegate.setNew(true);

        return pmlFileTypeDelegatePersistence.update(pmlFileTypeDelegate, false);
    }

    public PmlFileTypeDelegate createPmlFileTypeDelegate(
        long fileTypeDelegateId) {
        return pmlFileTypeDelegatePersistence.create(fileTypeDelegateId);
    }

    public void deletePmlFileTypeDelegate(long fileTypeDelegateId)
        throws PortalException, SystemException {
        pmlFileTypeDelegatePersistence.remove(fileTypeDelegateId);
    }

    public void deletePmlFileTypeDelegate(
        PmlFileTypeDelegate pmlFileTypeDelegate) throws SystemException {
        pmlFileTypeDelegatePersistence.remove(pmlFileTypeDelegate);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return pmlFileTypeDelegatePersistence.findWithDynamicQuery(dynamicQuery);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery, int start,
        int end) throws SystemException {
        return pmlFileTypeDelegatePersistence.findWithDynamicQuery(dynamicQuery,
            start, end);
    }

    public PmlFileTypeDelegate getPmlFileTypeDelegate(long fileTypeDelegateId)
        throws PortalException, SystemException {
        return pmlFileTypeDelegatePersistence.findByPrimaryKey(fileTypeDelegateId);
    }

    public List<PmlFileTypeDelegate> getPmlFileTypeDelegates(int start, int end)
        throws SystemException {
        return pmlFileTypeDelegatePersistence.findAll(start, end);
    }

    public int getPmlFileTypeDelegatesCount() throws SystemException {
        return pmlFileTypeDelegatePersistence.countAll();
    }

    public PmlFileTypeDelegate updatePmlFileTypeDelegate(
        PmlFileTypeDelegate pmlFileTypeDelegate) throws SystemException {
        pmlFileTypeDelegate.setNew(false);

        return pmlFileTypeDelegatePersistence.update(pmlFileTypeDelegate, true);
    }

    public PmlFileTypeDelegateLocalService getPmlFileTypeDelegateLocalService() {
        return pmlFileTypeDelegateLocalService;
    }

    public void setPmlFileTypeDelegateLocalService(
        PmlFileTypeDelegateLocalService pmlFileTypeDelegateLocalService) {
        this.pmlFileTypeDelegateLocalService = pmlFileTypeDelegateLocalService;
    }

    public PmlFileTypeDelegateService getPmlFileTypeDelegateService() {
        return pmlFileTypeDelegateService;
    }

    public void setPmlFileTypeDelegateService(
        PmlFileTypeDelegateService pmlFileTypeDelegateService) {
        this.pmlFileTypeDelegateService = pmlFileTypeDelegateService;
    }

    public PmlFileTypeDelegatePersistence getPmlFileTypeDelegatePersistence() {
        return pmlFileTypeDelegatePersistence;
    }

    public void setPmlFileTypeDelegatePersistence(
        PmlFileTypeDelegatePersistence pmlFileTypeDelegatePersistence) {
        this.pmlFileTypeDelegatePersistence = pmlFileTypeDelegatePersistence;
    }
}
