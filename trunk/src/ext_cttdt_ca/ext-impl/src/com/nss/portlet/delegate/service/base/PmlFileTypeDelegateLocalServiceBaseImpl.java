package com.nss.portlet.delegate.service.base;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.util.PortalUtil;

import com.nss.portlet.delegate.model.PmlFileTypeDelegate;
import com.nss.portlet.delegate.service.PmlDelegateLocalService;
import com.nss.portlet.delegate.service.PmlDelegateService;
import com.nss.portlet.delegate.service.PmlFileTypeDelegateLocalService;
import com.nss.portlet.delegate.service.PmlFileTypeDelegateService;
import com.nss.portlet.delegate.service.persistence.PmlDelegatePersistence;
import com.nss.portlet.delegate.service.persistence.PmlFileTypeDelegatePersistence;

import java.util.List;


public abstract class PmlFileTypeDelegateLocalServiceBaseImpl
    implements PmlFileTypeDelegateLocalService {
    @BeanReference(name = "com.nss.portlet.delegate.service.PmlDelegateLocalService.impl")
    protected PmlDelegateLocalService pmlDelegateLocalService;
    @BeanReference(name = "com.nss.portlet.delegate.service.PmlDelegateService.impl")
    protected PmlDelegateService pmlDelegateService;
    @BeanReference(name = "com.nss.portlet.delegate.service.persistence.PmlDelegatePersistence.impl")
    protected PmlDelegatePersistence pmlDelegatePersistence;
    @BeanReference(name = "com.nss.portlet.delegate.service.PmlFileTypeDelegateLocalService.impl")
    protected PmlFileTypeDelegateLocalService pmlFileTypeDelegateLocalService;
    @BeanReference(name = "com.nss.portlet.delegate.service.PmlFileTypeDelegateService.impl")
    protected PmlFileTypeDelegateService pmlFileTypeDelegateService;
    @BeanReference(name = "com.nss.portlet.delegate.service.persistence.PmlFileTypeDelegatePersistence.impl")
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

    public PmlFileTypeDelegate updatePmlFileTypeDelegate(
        PmlFileTypeDelegate pmlFileTypeDelegate, boolean merge)
        throws SystemException {
        pmlFileTypeDelegate.setNew(false);

        return pmlFileTypeDelegatePersistence.update(pmlFileTypeDelegate, merge);
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

    protected void runSQL(String sql) throws SystemException {
        try {
            PortalUtil.runSQL(sql);
        } catch (Exception e) {
            throw new SystemException(e);
        }
    }
}
