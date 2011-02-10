package com.sgs.portlet.document.service.base;

import com.liferay.portal.service.base.PrincipalBean;

import com.sgs.portlet.document.service.PmlDocumentReceiptIssuingPlaceLogLocalService;
import com.sgs.portlet.document.service.PmlDocumentReceiptIssuingPlaceLogService;
import com.sgs.portlet.document.service.PmlDocumentReceiptLogLocalService;
import com.sgs.portlet.document.service.PmlDocumentReceiptLogService;
import com.sgs.portlet.document.service.PmlDocumentReceiptWFLocalService;
import com.sgs.portlet.document.service.PmlDocumentReceiptWFService;
import com.sgs.portlet.document.service.PmlDocumentSendLogLocalService;
import com.sgs.portlet.document.service.PmlDocumentSendLogService;
import com.sgs.portlet.document.service.PmlDocumentSendWFLocalService;
import com.sgs.portlet.document.service.PmlDocumentSendWFService;
import com.sgs.portlet.document.service.PmlEdmDocumentRelationLocalService;
import com.sgs.portlet.document.service.PmlEdmDocumentRelationService;
import com.sgs.portlet.document.service.PmlFileStatusLocalService;
import com.sgs.portlet.document.service.PmlFileStatusService;
import com.sgs.portlet.document.service.PmlMainSupportLocalService;
import com.sgs.portlet.document.service.PmlMainSupportService;
import com.sgs.portlet.document.service.PmlProcessDisposeLocalService;
import com.sgs.portlet.document.service.PmlProcessDisposeService;
import com.sgs.portlet.document.service.PmlStateDepartmentLocalService;
import com.sgs.portlet.document.service.PmlStateDepartmentService;
import com.sgs.portlet.document.service.PmlStateProcessLocalService;
import com.sgs.portlet.document.service.PmlStateProcessService;
import com.sgs.portlet.document.service.PmlStateWorkFlowLocalService;
import com.sgs.portlet.document.service.PmlStateWorkFlowService;
import com.sgs.portlet.document.service.persistence.PmlDocumentReceiptIssuingPlaceLogPersistence;
import com.sgs.portlet.document.service.persistence.PmlDocumentReceiptLogPersistence;
import com.sgs.portlet.document.service.persistence.PmlDocumentReceiptWFPersistence;
import com.sgs.portlet.document.service.persistence.PmlDocumentSendLogPersistence;
import com.sgs.portlet.document.service.persistence.PmlDocumentSendWFPersistence;
import com.sgs.portlet.document.service.persistence.PmlEdmDocumentRelationPersistence;
import com.sgs.portlet.document.service.persistence.PmlFileStatusFinder;
import com.sgs.portlet.document.service.persistence.PmlFileStatusPersistence;
import com.sgs.portlet.document.service.persistence.PmlMainSupportPersistence;
import com.sgs.portlet.document.service.persistence.PmlProcessDisposePersistence;
import com.sgs.portlet.document.service.persistence.PmlStateDepartmentPersistence;
import com.sgs.portlet.document.service.persistence.PmlStateProcessFinder;
import com.sgs.portlet.document.service.persistence.PmlStateProcessPersistence;
import com.sgs.portlet.document.service.persistence.PmlStateWorkFlowPersistence;


public abstract class PmlDocumentSendWFServiceBaseImpl extends PrincipalBean
    implements PmlDocumentSendWFService {
    @javax.annotation.Resource(name = "com.sgs.portlet.document.service.PmlDocumentReceiptWFLocalService.impl")
    protected PmlDocumentReceiptWFLocalService pmlDocumentReceiptWFLocalService;
    @javax.annotation.Resource(name = "com.sgs.portlet.document.service.PmlDocumentReceiptWFService.impl")
    protected PmlDocumentReceiptWFService pmlDocumentReceiptWFService;
    @javax.annotation.Resource(name = "com.sgs.portlet.document.service.persistence.PmlDocumentReceiptWFPersistence.impl")
    protected PmlDocumentReceiptWFPersistence pmlDocumentReceiptWFPersistence;
    @javax.annotation.Resource(name = "com.sgs.portlet.document.service.PmlDocumentSendWFLocalService.impl")
    protected PmlDocumentSendWFLocalService pmlDocumentSendWFLocalService;
    @javax.annotation.Resource(name = "com.sgs.portlet.document.service.PmlDocumentSendWFService.impl")
    protected PmlDocumentSendWFService pmlDocumentSendWFService;
    @javax.annotation.Resource(name = "com.sgs.portlet.document.service.persistence.PmlDocumentSendWFPersistence.impl")
    protected PmlDocumentSendWFPersistence pmlDocumentSendWFPersistence;
    @javax.annotation.Resource(name = "com.sgs.portlet.document.service.PmlMainSupportLocalService.impl")
    protected PmlMainSupportLocalService pmlMainSupportLocalService;
    @javax.annotation.Resource(name = "com.sgs.portlet.document.service.PmlMainSupportService.impl")
    protected PmlMainSupportService pmlMainSupportService;
    @javax.annotation.Resource(name = "com.sgs.portlet.document.service.persistence.PmlMainSupportPersistence.impl")
    protected PmlMainSupportPersistence pmlMainSupportPersistence;
    @javax.annotation.Resource(name = "com.sgs.portlet.document.service.PmlFileStatusLocalService.impl")
    protected PmlFileStatusLocalService pmlFileStatusLocalService;
    @javax.annotation.Resource(name = "com.sgs.portlet.document.service.PmlFileStatusService.impl")
    protected PmlFileStatusService pmlFileStatusService;
    @javax.annotation.Resource(name = "com.sgs.portlet.document.service.persistence.PmlFileStatusPersistence.impl")
    protected PmlFileStatusPersistence pmlFileStatusPersistence;
    @javax.annotation.Resource(name = "com.sgs.portlet.document.service.persistence.PmlFileStatusFinder.impl")
    protected PmlFileStatusFinder pmlFileStatusFinder;
    @javax.annotation.Resource(name = "com.sgs.portlet.document.service.PmlStateProcessLocalService.impl")
    protected PmlStateProcessLocalService pmlStateProcessLocalService;
    @javax.annotation.Resource(name = "com.sgs.portlet.document.service.PmlStateProcessService.impl")
    protected PmlStateProcessService pmlStateProcessService;
    @javax.annotation.Resource(name = "com.sgs.portlet.document.service.persistence.PmlStateProcessPersistence.impl")
    protected PmlStateProcessPersistence pmlStateProcessPersistence;
    @javax.annotation.Resource(name = "com.sgs.portlet.document.service.persistence.PmlStateProcessFinder.impl")
    protected PmlStateProcessFinder pmlStateProcessFinder;
    @javax.annotation.Resource(name = "com.sgs.portlet.document.service.PmlProcessDisposeLocalService.impl")
    protected PmlProcessDisposeLocalService pmlProcessDisposeLocalService;
    @javax.annotation.Resource(name = "com.sgs.portlet.document.service.PmlProcessDisposeService.impl")
    protected PmlProcessDisposeService pmlProcessDisposeService;
    @javax.annotation.Resource(name = "com.sgs.portlet.document.service.persistence.PmlProcessDisposePersistence.impl")
    protected PmlProcessDisposePersistence pmlProcessDisposePersistence;
    @javax.annotation.Resource(name = "com.sgs.portlet.document.service.PmlStateWorkFlowLocalService.impl")
    protected PmlStateWorkFlowLocalService pmlStateWorkFlowLocalService;
    @javax.annotation.Resource(name = "com.sgs.portlet.document.service.PmlStateWorkFlowService.impl")
    protected PmlStateWorkFlowService pmlStateWorkFlowService;
    @javax.annotation.Resource(name = "com.sgs.portlet.document.service.persistence.PmlStateWorkFlowPersistence.impl")
    protected PmlStateWorkFlowPersistence pmlStateWorkFlowPersistence;
    @javax.annotation.Resource(name = "com.sgs.portlet.document.service.PmlStateDepartmentLocalService.impl")
    protected PmlStateDepartmentLocalService pmlStateDepartmentLocalService;
    @javax.annotation.Resource(name = "com.sgs.portlet.document.service.PmlStateDepartmentService.impl")
    protected PmlStateDepartmentService pmlStateDepartmentService;
    @javax.annotation.Resource(name = "com.sgs.portlet.document.service.persistence.PmlStateDepartmentPersistence.impl")
    protected PmlStateDepartmentPersistence pmlStateDepartmentPersistence;
    @javax.annotation.Resource(name = "com.sgs.portlet.document.service.PmlDocumentReceiptLogLocalService.impl")
    protected PmlDocumentReceiptLogLocalService pmlDocumentReceiptLogLocalService;
    @javax.annotation.Resource(name = "com.sgs.portlet.document.service.PmlDocumentReceiptLogService.impl")
    protected PmlDocumentReceiptLogService pmlDocumentReceiptLogService;
    @javax.annotation.Resource(name = "com.sgs.portlet.document.service.persistence.PmlDocumentReceiptLogPersistence.impl")
    protected PmlDocumentReceiptLogPersistence pmlDocumentReceiptLogPersistence;
    @javax.annotation.Resource(name = "com.sgs.portlet.document.service.PmlDocumentReceiptIssuingPlaceLogLocalService.impl")
    protected PmlDocumentReceiptIssuingPlaceLogLocalService pmlDocumentReceiptIssuingPlaceLogLocalService;
    @javax.annotation.Resource(name = "com.sgs.portlet.document.service.PmlDocumentReceiptIssuingPlaceLogService.impl")
    protected PmlDocumentReceiptIssuingPlaceLogService pmlDocumentReceiptIssuingPlaceLogService;
    @javax.annotation.Resource(name = "com.sgs.portlet.document.service.persistence.PmlDocumentReceiptIssuingPlaceLogPersistence.impl")
    protected PmlDocumentReceiptIssuingPlaceLogPersistence pmlDocumentReceiptIssuingPlaceLogPersistence;
    @javax.annotation.Resource(name = "com.sgs.portlet.document.service.PmlDocumentSendLogLocalService.impl")
    protected PmlDocumentSendLogLocalService pmlDocumentSendLogLocalService;
    @javax.annotation.Resource(name = "com.sgs.portlet.document.service.PmlDocumentSendLogService.impl")
    protected PmlDocumentSendLogService pmlDocumentSendLogService;
    @javax.annotation.Resource(name = "com.sgs.portlet.document.service.persistence.PmlDocumentSendLogPersistence.impl")
    protected PmlDocumentSendLogPersistence pmlDocumentSendLogPersistence;
    @javax.annotation.Resource(name = "com.sgs.portlet.document.service.PmlEdmDocumentRelationLocalService.impl")
    protected PmlEdmDocumentRelationLocalService pmlEdmDocumentRelationLocalService;
    @javax.annotation.Resource(name = "com.sgs.portlet.document.service.PmlEdmDocumentRelationService.impl")
    protected PmlEdmDocumentRelationService pmlEdmDocumentRelationService;
    @javax.annotation.Resource(name = "com.sgs.portlet.document.service.persistence.PmlEdmDocumentRelationPersistence.impl")
    protected PmlEdmDocumentRelationPersistence pmlEdmDocumentRelationPersistence;

    public PmlDocumentReceiptWFLocalService getPmlDocumentReceiptWFLocalService() {
        return pmlDocumentReceiptWFLocalService;
    }

    public void setPmlDocumentReceiptWFLocalService(
        PmlDocumentReceiptWFLocalService pmlDocumentReceiptWFLocalService) {
        this.pmlDocumentReceiptWFLocalService = pmlDocumentReceiptWFLocalService;
    }

    public PmlDocumentReceiptWFService getPmlDocumentReceiptWFService() {
        return pmlDocumentReceiptWFService;
    }

    public void setPmlDocumentReceiptWFService(
        PmlDocumentReceiptWFService pmlDocumentReceiptWFService) {
        this.pmlDocumentReceiptWFService = pmlDocumentReceiptWFService;
    }

    public PmlDocumentReceiptWFPersistence getPmlDocumentReceiptWFPersistence() {
        return pmlDocumentReceiptWFPersistence;
    }

    public void setPmlDocumentReceiptWFPersistence(
        PmlDocumentReceiptWFPersistence pmlDocumentReceiptWFPersistence) {
        this.pmlDocumentReceiptWFPersistence = pmlDocumentReceiptWFPersistence;
    }

    public PmlDocumentSendWFLocalService getPmlDocumentSendWFLocalService() {
        return pmlDocumentSendWFLocalService;
    }

    public void setPmlDocumentSendWFLocalService(
        PmlDocumentSendWFLocalService pmlDocumentSendWFLocalService) {
        this.pmlDocumentSendWFLocalService = pmlDocumentSendWFLocalService;
    }

    public PmlDocumentSendWFService getPmlDocumentSendWFService() {
        return pmlDocumentSendWFService;
    }

    public void setPmlDocumentSendWFService(
        PmlDocumentSendWFService pmlDocumentSendWFService) {
        this.pmlDocumentSendWFService = pmlDocumentSendWFService;
    }

    public PmlDocumentSendWFPersistence getPmlDocumentSendWFPersistence() {
        return pmlDocumentSendWFPersistence;
    }

    public void setPmlDocumentSendWFPersistence(
        PmlDocumentSendWFPersistence pmlDocumentSendWFPersistence) {
        this.pmlDocumentSendWFPersistence = pmlDocumentSendWFPersistence;
    }

    public PmlMainSupportLocalService getPmlMainSupportLocalService() {
        return pmlMainSupportLocalService;
    }

    public void setPmlMainSupportLocalService(
        PmlMainSupportLocalService pmlMainSupportLocalService) {
        this.pmlMainSupportLocalService = pmlMainSupportLocalService;
    }

    public PmlMainSupportService getPmlMainSupportService() {
        return pmlMainSupportService;
    }

    public void setPmlMainSupportService(
        PmlMainSupportService pmlMainSupportService) {
        this.pmlMainSupportService = pmlMainSupportService;
    }

    public PmlMainSupportPersistence getPmlMainSupportPersistence() {
        return pmlMainSupportPersistence;
    }

    public void setPmlMainSupportPersistence(
        PmlMainSupportPersistence pmlMainSupportPersistence) {
        this.pmlMainSupportPersistence = pmlMainSupportPersistence;
    }

    public PmlFileStatusLocalService getPmlFileStatusLocalService() {
        return pmlFileStatusLocalService;
    }

    public void setPmlFileStatusLocalService(
        PmlFileStatusLocalService pmlFileStatusLocalService) {
        this.pmlFileStatusLocalService = pmlFileStatusLocalService;
    }

    public PmlFileStatusService getPmlFileStatusService() {
        return pmlFileStatusService;
    }

    public void setPmlFileStatusService(
        PmlFileStatusService pmlFileStatusService) {
        this.pmlFileStatusService = pmlFileStatusService;
    }

    public PmlFileStatusPersistence getPmlFileStatusPersistence() {
        return pmlFileStatusPersistence;
    }

    public void setPmlFileStatusPersistence(
        PmlFileStatusPersistence pmlFileStatusPersistence) {
        this.pmlFileStatusPersistence = pmlFileStatusPersistence;
    }

    public PmlFileStatusFinder getPmlFileStatusFinder() {
        return pmlFileStatusFinder;
    }

    public void setPmlFileStatusFinder(PmlFileStatusFinder pmlFileStatusFinder) {
        this.pmlFileStatusFinder = pmlFileStatusFinder;
    }

    public PmlStateProcessLocalService getPmlStateProcessLocalService() {
        return pmlStateProcessLocalService;
    }

    public void setPmlStateProcessLocalService(
        PmlStateProcessLocalService pmlStateProcessLocalService) {
        this.pmlStateProcessLocalService = pmlStateProcessLocalService;
    }

    public PmlStateProcessService getPmlStateProcessService() {
        return pmlStateProcessService;
    }

    public void setPmlStateProcessService(
        PmlStateProcessService pmlStateProcessService) {
        this.pmlStateProcessService = pmlStateProcessService;
    }

    public PmlStateProcessPersistence getPmlStateProcessPersistence() {
        return pmlStateProcessPersistence;
    }

    public void setPmlStateProcessPersistence(
        PmlStateProcessPersistence pmlStateProcessPersistence) {
        this.pmlStateProcessPersistence = pmlStateProcessPersistence;
    }

    public PmlStateProcessFinder getPmlStateProcessFinder() {
        return pmlStateProcessFinder;
    }

    public void setPmlStateProcessFinder(
        PmlStateProcessFinder pmlStateProcessFinder) {
        this.pmlStateProcessFinder = pmlStateProcessFinder;
    }

    public PmlProcessDisposeLocalService getPmlProcessDisposeLocalService() {
        return pmlProcessDisposeLocalService;
    }

    public void setPmlProcessDisposeLocalService(
        PmlProcessDisposeLocalService pmlProcessDisposeLocalService) {
        this.pmlProcessDisposeLocalService = pmlProcessDisposeLocalService;
    }

    public PmlProcessDisposeService getPmlProcessDisposeService() {
        return pmlProcessDisposeService;
    }

    public void setPmlProcessDisposeService(
        PmlProcessDisposeService pmlProcessDisposeService) {
        this.pmlProcessDisposeService = pmlProcessDisposeService;
    }

    public PmlProcessDisposePersistence getPmlProcessDisposePersistence() {
        return pmlProcessDisposePersistence;
    }

    public void setPmlProcessDisposePersistence(
        PmlProcessDisposePersistence pmlProcessDisposePersistence) {
        this.pmlProcessDisposePersistence = pmlProcessDisposePersistence;
    }

    public PmlStateWorkFlowLocalService getPmlStateWorkFlowLocalService() {
        return pmlStateWorkFlowLocalService;
    }

    public void setPmlStateWorkFlowLocalService(
        PmlStateWorkFlowLocalService pmlStateWorkFlowLocalService) {
        this.pmlStateWorkFlowLocalService = pmlStateWorkFlowLocalService;
    }

    public PmlStateWorkFlowService getPmlStateWorkFlowService() {
        return pmlStateWorkFlowService;
    }

    public void setPmlStateWorkFlowService(
        PmlStateWorkFlowService pmlStateWorkFlowService) {
        this.pmlStateWorkFlowService = pmlStateWorkFlowService;
    }

    public PmlStateWorkFlowPersistence getPmlStateWorkFlowPersistence() {
        return pmlStateWorkFlowPersistence;
    }

    public void setPmlStateWorkFlowPersistence(
        PmlStateWorkFlowPersistence pmlStateWorkFlowPersistence) {
        this.pmlStateWorkFlowPersistence = pmlStateWorkFlowPersistence;
    }

    public PmlStateDepartmentLocalService getPmlStateDepartmentLocalService() {
        return pmlStateDepartmentLocalService;
    }

    public void setPmlStateDepartmentLocalService(
        PmlStateDepartmentLocalService pmlStateDepartmentLocalService) {
        this.pmlStateDepartmentLocalService = pmlStateDepartmentLocalService;
    }

    public PmlStateDepartmentService getPmlStateDepartmentService() {
        return pmlStateDepartmentService;
    }

    public void setPmlStateDepartmentService(
        PmlStateDepartmentService pmlStateDepartmentService) {
        this.pmlStateDepartmentService = pmlStateDepartmentService;
    }

    public PmlStateDepartmentPersistence getPmlStateDepartmentPersistence() {
        return pmlStateDepartmentPersistence;
    }

    public void setPmlStateDepartmentPersistence(
        PmlStateDepartmentPersistence pmlStateDepartmentPersistence) {
        this.pmlStateDepartmentPersistence = pmlStateDepartmentPersistence;
    }

    public PmlDocumentReceiptLogLocalService getPmlDocumentReceiptLogLocalService() {
        return pmlDocumentReceiptLogLocalService;
    }

    public void setPmlDocumentReceiptLogLocalService(
        PmlDocumentReceiptLogLocalService pmlDocumentReceiptLogLocalService) {
        this.pmlDocumentReceiptLogLocalService = pmlDocumentReceiptLogLocalService;
    }

    public PmlDocumentReceiptLogService getPmlDocumentReceiptLogService() {
        return pmlDocumentReceiptLogService;
    }

    public void setPmlDocumentReceiptLogService(
        PmlDocumentReceiptLogService pmlDocumentReceiptLogService) {
        this.pmlDocumentReceiptLogService = pmlDocumentReceiptLogService;
    }

    public PmlDocumentReceiptLogPersistence getPmlDocumentReceiptLogPersistence() {
        return pmlDocumentReceiptLogPersistence;
    }

    public void setPmlDocumentReceiptLogPersistence(
        PmlDocumentReceiptLogPersistence pmlDocumentReceiptLogPersistence) {
        this.pmlDocumentReceiptLogPersistence = pmlDocumentReceiptLogPersistence;
    }

    public PmlDocumentReceiptIssuingPlaceLogLocalService getPmlDocumentReceiptIssuingPlaceLogLocalService() {
        return pmlDocumentReceiptIssuingPlaceLogLocalService;
    }

    public void setPmlDocumentReceiptIssuingPlaceLogLocalService(
        PmlDocumentReceiptIssuingPlaceLogLocalService pmlDocumentReceiptIssuingPlaceLogLocalService) {
        this.pmlDocumentReceiptIssuingPlaceLogLocalService = pmlDocumentReceiptIssuingPlaceLogLocalService;
    }

    public PmlDocumentReceiptIssuingPlaceLogService getPmlDocumentReceiptIssuingPlaceLogService() {
        return pmlDocumentReceiptIssuingPlaceLogService;
    }

    public void setPmlDocumentReceiptIssuingPlaceLogService(
        PmlDocumentReceiptIssuingPlaceLogService pmlDocumentReceiptIssuingPlaceLogService) {
        this.pmlDocumentReceiptIssuingPlaceLogService = pmlDocumentReceiptIssuingPlaceLogService;
    }

    public PmlDocumentReceiptIssuingPlaceLogPersistence getPmlDocumentReceiptIssuingPlaceLogPersistence() {
        return pmlDocumentReceiptIssuingPlaceLogPersistence;
    }

    public void setPmlDocumentReceiptIssuingPlaceLogPersistence(
        PmlDocumentReceiptIssuingPlaceLogPersistence pmlDocumentReceiptIssuingPlaceLogPersistence) {
        this.pmlDocumentReceiptIssuingPlaceLogPersistence = pmlDocumentReceiptIssuingPlaceLogPersistence;
    }

    public PmlDocumentSendLogLocalService getPmlDocumentSendLogLocalService() {
        return pmlDocumentSendLogLocalService;
    }

    public void setPmlDocumentSendLogLocalService(
        PmlDocumentSendLogLocalService pmlDocumentSendLogLocalService) {
        this.pmlDocumentSendLogLocalService = pmlDocumentSendLogLocalService;
    }

    public PmlDocumentSendLogService getPmlDocumentSendLogService() {
        return pmlDocumentSendLogService;
    }

    public void setPmlDocumentSendLogService(
        PmlDocumentSendLogService pmlDocumentSendLogService) {
        this.pmlDocumentSendLogService = pmlDocumentSendLogService;
    }

    public PmlDocumentSendLogPersistence getPmlDocumentSendLogPersistence() {
        return pmlDocumentSendLogPersistence;
    }

    public void setPmlDocumentSendLogPersistence(
        PmlDocumentSendLogPersistence pmlDocumentSendLogPersistence) {
        this.pmlDocumentSendLogPersistence = pmlDocumentSendLogPersistence;
    }

    public PmlEdmDocumentRelationLocalService getPmlEdmDocumentRelationLocalService() {
        return pmlEdmDocumentRelationLocalService;
    }

    public void setPmlEdmDocumentRelationLocalService(
        PmlEdmDocumentRelationLocalService pmlEdmDocumentRelationLocalService) {
        this.pmlEdmDocumentRelationLocalService = pmlEdmDocumentRelationLocalService;
    }

    public PmlEdmDocumentRelationService getPmlEdmDocumentRelationService() {
        return pmlEdmDocumentRelationService;
    }

    public void setPmlEdmDocumentRelationService(
        PmlEdmDocumentRelationService pmlEdmDocumentRelationService) {
        this.pmlEdmDocumentRelationService = pmlEdmDocumentRelationService;
    }

    public PmlEdmDocumentRelationPersistence getPmlEdmDocumentRelationPersistence() {
        return pmlEdmDocumentRelationPersistence;
    }

    public void setPmlEdmDocumentRelationPersistence(
        PmlEdmDocumentRelationPersistence pmlEdmDocumentRelationPersistence) {
        this.pmlEdmDocumentRelationPersistence = pmlEdmDocumentRelationPersistence;
    }
}
