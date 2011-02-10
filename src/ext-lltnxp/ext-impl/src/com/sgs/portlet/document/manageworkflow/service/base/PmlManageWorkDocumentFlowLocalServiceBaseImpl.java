package com.sgs.portlet.document.manageworkflow.service.base;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;

import com.sgs.portlet.document.manageworkflow.model.PmlManageWorkDocumentFlow;
import com.sgs.portlet.document.manageworkflow.service.PmlManageWorkDocumentFlowLocalService;
import com.sgs.portlet.document.manageworkflow.service.PmlManageWorkDocumentFlowService;
import com.sgs.portlet.document.manageworkflow.service.persistence.PmlManageWorkDocumentFlowFinder;
import com.sgs.portlet.document.manageworkflow.service.persistence.PmlManageWorkDocumentFlowPersistence;

import java.util.List;


public abstract class PmlManageWorkDocumentFlowLocalServiceBaseImpl
    implements PmlManageWorkDocumentFlowLocalService {
    @javax.annotation.Resource(name = "com.sgs.portlet.document.manageworkflow.service.PmlManageWorkDocumentFlowLocalService.impl")
    protected PmlManageWorkDocumentFlowLocalService pmlManageWorkDocumentFlowLocalService;
    @javax.annotation.Resource(name = "com.sgs.portlet.document.manageworkflow.service.PmlManageWorkDocumentFlowService.impl")
    protected PmlManageWorkDocumentFlowService pmlManageWorkDocumentFlowService;
    @javax.annotation.Resource(name = "com.sgs.portlet.document.manageworkflow.service.persistence.PmlManageWorkDocumentFlowPersistence.impl")
    protected PmlManageWorkDocumentFlowPersistence pmlManageWorkDocumentFlowPersistence;
    @javax.annotation.Resource(name = "com.sgs.portlet.document.manageworkflow.service.persistence.PmlManageWorkDocumentFlowFinder.impl")
    protected PmlManageWorkDocumentFlowFinder pmlManageWorkDocumentFlowFinder;

    public PmlManageWorkDocumentFlow addPmlManageWorkDocumentFlow(
        PmlManageWorkDocumentFlow pmlManageWorkDocumentFlow)
        throws SystemException {
        pmlManageWorkDocumentFlow.setNew(true);

        return pmlManageWorkDocumentFlowPersistence.update(pmlManageWorkDocumentFlow,
            false);
    }

    public PmlManageWorkDocumentFlow createPmlManageWorkDocumentFlow(
        long manageDocumentWorkFlowId) {
        return pmlManageWorkDocumentFlowPersistence.create(manageDocumentWorkFlowId);
    }

    public void deletePmlManageWorkDocumentFlow(long manageDocumentWorkFlowId)
        throws PortalException, SystemException {
        pmlManageWorkDocumentFlowPersistence.remove(manageDocumentWorkFlowId);
    }

    public void deletePmlManageWorkDocumentFlow(
        PmlManageWorkDocumentFlow pmlManageWorkDocumentFlow)
        throws SystemException {
        pmlManageWorkDocumentFlowPersistence.remove(pmlManageWorkDocumentFlow);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return pmlManageWorkDocumentFlowPersistence.findWithDynamicQuery(dynamicQuery);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery, int start,
        int end) throws SystemException {
        return pmlManageWorkDocumentFlowPersistence.findWithDynamicQuery(dynamicQuery,
            start, end);
    }

    public PmlManageWorkDocumentFlow getPmlManageWorkDocumentFlow(
        long manageDocumentWorkFlowId) throws PortalException, SystemException {
        return pmlManageWorkDocumentFlowPersistence.findByPrimaryKey(manageDocumentWorkFlowId);
    }

    public List<PmlManageWorkDocumentFlow> getPmlManageWorkDocumentFlows(
        int start, int end) throws SystemException {
        return pmlManageWorkDocumentFlowPersistence.findAll(start, end);
    }

    public int getPmlManageWorkDocumentFlowsCount() throws SystemException {
        return pmlManageWorkDocumentFlowPersistence.countAll();
    }

    public PmlManageWorkDocumentFlow updatePmlManageWorkDocumentFlow(
        PmlManageWorkDocumentFlow pmlManageWorkDocumentFlow)
        throws SystemException {
        pmlManageWorkDocumentFlow.setNew(false);

        return pmlManageWorkDocumentFlowPersistence.update(pmlManageWorkDocumentFlow,
            true);
    }

    public PmlManageWorkDocumentFlowLocalService getPmlManageWorkDocumentFlowLocalService() {
        return pmlManageWorkDocumentFlowLocalService;
    }

    public void setPmlManageWorkDocumentFlowLocalService(
        PmlManageWorkDocumentFlowLocalService pmlManageWorkDocumentFlowLocalService) {
        this.pmlManageWorkDocumentFlowLocalService = pmlManageWorkDocumentFlowLocalService;
    }

    public PmlManageWorkDocumentFlowService getPmlManageWorkDocumentFlowService() {
        return pmlManageWorkDocumentFlowService;
    }

    public void setPmlManageWorkDocumentFlowService(
        PmlManageWorkDocumentFlowService pmlManageWorkDocumentFlowService) {
        this.pmlManageWorkDocumentFlowService = pmlManageWorkDocumentFlowService;
    }

    public PmlManageWorkDocumentFlowPersistence getPmlManageWorkDocumentFlowPersistence() {
        return pmlManageWorkDocumentFlowPersistence;
    }

    public void setPmlManageWorkDocumentFlowPersistence(
        PmlManageWorkDocumentFlowPersistence pmlManageWorkDocumentFlowPersistence) {
        this.pmlManageWorkDocumentFlowPersistence = pmlManageWorkDocumentFlowPersistence;
    }

    public PmlManageWorkDocumentFlowFinder getPmlManageWorkDocumentFlowFinder() {
        return pmlManageWorkDocumentFlowFinder;
    }

    public void setPmlManageWorkDocumentFlowFinder(
        PmlManageWorkDocumentFlowFinder pmlManageWorkDocumentFlowFinder) {
        this.pmlManageWorkDocumentFlowFinder = pmlManageWorkDocumentFlowFinder;
    }
}
