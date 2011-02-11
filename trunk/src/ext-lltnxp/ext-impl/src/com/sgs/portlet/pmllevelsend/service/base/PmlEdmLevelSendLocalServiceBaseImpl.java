package com.sgs.portlet.pmllevelsend.service.base;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;

import com.sgs.portlet.pmllevelsend.model.PmlEdmLevelSend;
import com.sgs.portlet.pmllevelsend.service.PmlEdmLevelSendLocalService;
import com.sgs.portlet.pmllevelsend.service.PmlEdmLevelSendService;
import com.sgs.portlet.pmllevelsend.service.persistence.PmlEdmLevelSendFinder;
import com.sgs.portlet.pmllevelsend.service.persistence.PmlEdmLevelSendPersistence;

import java.util.List;


public abstract class PmlEdmLevelSendLocalServiceBaseImpl
    implements PmlEdmLevelSendLocalService {
    @javax.annotation.Resource(name = "com.sgs.portlet.pmllevelsend.service.PmlEdmLevelSendLocalService.impl")
    protected PmlEdmLevelSendLocalService pmlEdmLevelSendLocalService;
    @javax.annotation.Resource(name = "com.sgs.portlet.pmllevelsend.service.PmlEdmLevelSendService.impl")
    protected PmlEdmLevelSendService pmlEdmLevelSendService;
    @javax.annotation.Resource(name = "com.sgs.portlet.pmllevelsend.service.persistence.PmlEdmLevelSendPersistence.impl")
    protected PmlEdmLevelSendPersistence pmlEdmLevelSendPersistence;
    @javax.annotation.Resource(name = "com.sgs.portlet.pmllevelsend.service.persistence.PmlEdmLevelSendFinder.impl")
    protected PmlEdmLevelSendFinder pmlEdmLevelSendFinder;

    public PmlEdmLevelSend addPmlEdmLevelSend(PmlEdmLevelSend pmlEdmLevelSend)
        throws SystemException {
        pmlEdmLevelSend.setNew(true);

        return pmlEdmLevelSendPersistence.update(pmlEdmLevelSend, false);
    }

    public PmlEdmLevelSend createPmlEdmLevelSend(int levelSendId) {
        return pmlEdmLevelSendPersistence.create(levelSendId);
    }

    public void deletePmlEdmLevelSend(int levelSendId)
        throws PortalException, SystemException {
        pmlEdmLevelSendPersistence.remove(levelSendId);
    }

    public void deletePmlEdmLevelSend(PmlEdmLevelSend pmlEdmLevelSend)
        throws SystemException {
        pmlEdmLevelSendPersistence.remove(pmlEdmLevelSend);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return pmlEdmLevelSendPersistence.findWithDynamicQuery(dynamicQuery);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery, int start,
        int end) throws SystemException {
        return pmlEdmLevelSendPersistence.findWithDynamicQuery(dynamicQuery,
            start, end);
    }

    public PmlEdmLevelSend getPmlEdmLevelSend(int levelSendId)
        throws PortalException, SystemException {
        return pmlEdmLevelSendPersistence.findByPrimaryKey(levelSendId);
    }

    public List<PmlEdmLevelSend> getPmlEdmLevelSends(int start, int end)
        throws SystemException {
        return pmlEdmLevelSendPersistence.findAll(start, end);
    }

    public int getPmlEdmLevelSendsCount() throws SystemException {
        return pmlEdmLevelSendPersistence.countAll();
    }

    public PmlEdmLevelSend updatePmlEdmLevelSend(
        PmlEdmLevelSend pmlEdmLevelSend) throws SystemException {
        pmlEdmLevelSend.setNew(false);

        return pmlEdmLevelSendPersistence.update(pmlEdmLevelSend, true);
    }

    public PmlEdmLevelSendLocalService getPmlEdmLevelSendLocalService() {
        return pmlEdmLevelSendLocalService;
    }

    public void setPmlEdmLevelSendLocalService(
        PmlEdmLevelSendLocalService pmlEdmLevelSendLocalService) {
        this.pmlEdmLevelSendLocalService = pmlEdmLevelSendLocalService;
    }

    public PmlEdmLevelSendService getPmlEdmLevelSendService() {
        return pmlEdmLevelSendService;
    }

    public void setPmlEdmLevelSendService(
        PmlEdmLevelSendService pmlEdmLevelSendService) {
        this.pmlEdmLevelSendService = pmlEdmLevelSendService;
    }

    public PmlEdmLevelSendPersistence getPmlEdmLevelSendPersistence() {
        return pmlEdmLevelSendPersistence;
    }

    public void setPmlEdmLevelSendPersistence(
        PmlEdmLevelSendPersistence pmlEdmLevelSendPersistence) {
        this.pmlEdmLevelSendPersistence = pmlEdmLevelSendPersistence;
    }

    public PmlEdmLevelSendFinder getPmlEdmLevelSendFinder() {
        return pmlEdmLevelSendFinder;
    }

    public void setPmlEdmLevelSendFinder(
        PmlEdmLevelSendFinder pmlEdmLevelSendFinder) {
        this.pmlEdmLevelSendFinder = pmlEdmLevelSendFinder;
    }
}
