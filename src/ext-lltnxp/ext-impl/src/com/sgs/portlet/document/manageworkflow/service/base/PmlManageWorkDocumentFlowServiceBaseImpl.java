package com.sgs.portlet.document.manageworkflow.service.base;

import com.liferay.portal.service.base.PrincipalBean;

import com.sgs.portlet.document.manageworkflow.service.PmlManageWorkDocumentFlowLocalService;
import com.sgs.portlet.document.manageworkflow.service.PmlManageWorkDocumentFlowService;
import com.sgs.portlet.document.manageworkflow.service.persistence.PmlManageWorkDocumentFlowFinder;
import com.sgs.portlet.document.manageworkflow.service.persistence.PmlManageWorkDocumentFlowPersistence;


public abstract class PmlManageWorkDocumentFlowServiceBaseImpl
    extends PrincipalBean implements PmlManageWorkDocumentFlowService {
    @javax.annotation.Resource(name = "com.sgs.portlet.document.manageworkflow.service.PmlManageWorkDocumentFlowLocalService.impl")
    protected PmlManageWorkDocumentFlowLocalService pmlManageWorkDocumentFlowLocalService;
    @javax.annotation.Resource(name = "com.sgs.portlet.document.manageworkflow.service.PmlManageWorkDocumentFlowService.impl")
    protected PmlManageWorkDocumentFlowService pmlManageWorkDocumentFlowService;
    @javax.annotation.Resource(name = "com.sgs.portlet.document.manageworkflow.service.persistence.PmlManageWorkDocumentFlowPersistence.impl")
    protected PmlManageWorkDocumentFlowPersistence pmlManageWorkDocumentFlowPersistence;
    @javax.annotation.Resource(name = "com.sgs.portlet.document.manageworkflow.service.persistence.PmlManageWorkDocumentFlowFinder.impl")
    protected PmlManageWorkDocumentFlowFinder pmlManageWorkDocumentFlowFinder;

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
