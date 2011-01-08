package com.sgs.portlet.pmllevelsend.service.base;

import com.liferay.portal.service.base.PrincipalBean;

import com.sgs.portlet.pmllevelsend.service.PmlEdmLevelSendLocalService;
import com.sgs.portlet.pmllevelsend.service.PmlEdmLevelSendService;
import com.sgs.portlet.pmllevelsend.service.persistence.PmlEdmLevelSendFinder;
import com.sgs.portlet.pmllevelsend.service.persistence.PmlEdmLevelSendPersistence;


public abstract class PmlEdmLevelSendServiceBaseImpl extends PrincipalBean
    implements PmlEdmLevelSendService {
    @javax.annotation.Resource(name = "com.sgs.portlet.pmllevelsend.service.PmlEdmLevelSendLocalService.impl")
    protected PmlEdmLevelSendLocalService pmlEdmLevelSendLocalService;
    @javax.annotation.Resource(name = "com.sgs.portlet.pmllevelsend.service.PmlEdmLevelSendService.impl")
    protected PmlEdmLevelSendService pmlEdmLevelSendService;
    @javax.annotation.Resource(name = "com.sgs.portlet.pmllevelsend.service.persistence.PmlEdmLevelSendPersistence.impl")
    protected PmlEdmLevelSendPersistence pmlEdmLevelSendPersistence;
    @javax.annotation.Resource(name = "com.sgs.portlet.pmllevelsend.service.persistence.PmlEdmLevelSendFinder.impl")
    protected PmlEdmLevelSendFinder pmlEdmLevelSendFinder;

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
