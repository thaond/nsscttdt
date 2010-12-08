package com.nss.portlet.onedoor.service.base;

import com.liferay.counter.service.CounterLocalService;
import com.liferay.counter.service.CounterService;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.service.base.PrincipalBean;
import com.liferay.portal.util.PortalUtil;

import com.nss.portlet.onedoor.service.PmlFilePCCCAttachedFileLocalService;
import com.nss.portlet.onedoor.service.PmlFilePCCCAttachedFileService;
import com.nss.portlet.onedoor.service.PmlFilePCCCLocalService;
import com.nss.portlet.onedoor.service.PmlFilePCCCService;
import com.nss.portlet.onedoor.service.PmlFileReturningInfoLocalService;
import com.nss.portlet.onedoor.service.PmlFileReturningInfoService;
import com.nss.portlet.onedoor.service.PmlFileStatusLocalService;
import com.nss.portlet.onedoor.service.PmlFileStatusService;
import com.nss.portlet.onedoor.service.PmlFileStatusStateProcessLocalService;
import com.nss.portlet.onedoor.service.PmlFileStatusStateProcessService;
import com.nss.portlet.onedoor.service.PmlOneDoorReceiveFileLocalService;
import com.nss.portlet.onedoor.service.PmlOneDoorReceiveFileService;
import com.nss.portlet.onedoor.service.PmlPaintDocumentLocalService;
import com.nss.portlet.onedoor.service.PmlPaintDocumentService;
import com.nss.portlet.onedoor.service.PmlProcessDisposeLocalService;
import com.nss.portlet.onedoor.service.PmlProcessDisposeService;
import com.nss.portlet.onedoor.service.PmlStateProcessLocalService;
import com.nss.portlet.onedoor.service.PmlStateProcessService;
import com.nss.portlet.onedoor.service.PmlStateWorkFlowLocalService;
import com.nss.portlet.onedoor.service.PmlStateWorkFlowService;
import com.nss.portlet.onedoor.service.PmlTransitionLocalService;
import com.nss.portlet.onedoor.service.PmlTransitionService;
import com.nss.portlet.onedoor.service.PmlWfOnedoorProcessLocalService;
import com.nss.portlet.onedoor.service.PmlWorkflowLocalService;
import com.nss.portlet.onedoor.service.PmlWorkflowService;
import com.nss.portlet.onedoor.service.persistence.PmlFilePCCCAttachedFilePersistence;
import com.nss.portlet.onedoor.service.persistence.PmlFilePCCCPersistence;
import com.nss.portlet.onedoor.service.persistence.PmlFileReturningInfoPersistence;
import com.nss.portlet.onedoor.service.persistence.PmlFileStatusFinder;
import com.nss.portlet.onedoor.service.persistence.PmlFileStatusPersistence;
import com.nss.portlet.onedoor.service.persistence.PmlFileStatusStateProcessPersistence;
import com.nss.portlet.onedoor.service.persistence.PmlOneDoorReceiveFileFinder;
import com.nss.portlet.onedoor.service.persistence.PmlOneDoorReceiveFilePersistence;
import com.nss.portlet.onedoor.service.persistence.PmlPaintDocumentPersistence;
import com.nss.portlet.onedoor.service.persistence.PmlProcessDisposePersistence;
import com.nss.portlet.onedoor.service.persistence.PmlStateProcessFinder;
import com.nss.portlet.onedoor.service.persistence.PmlStateProcessPersistence;
import com.nss.portlet.onedoor.service.persistence.PmlStateWorkFlowPersistence;
import com.nss.portlet.onedoor.service.persistence.PmlTransitionPersistence;
import com.nss.portlet.onedoor.service.persistence.PmlWfOnedoorProcessPersistence;
import com.nss.portlet.onedoor.service.persistence.PmlWorkflowFinder;
import com.nss.portlet.onedoor.service.persistence.PmlWorkflowPersistence;


public abstract class PmlFileStatusServiceBaseImpl extends PrincipalBean
    implements PmlFileStatusService {
    @BeanReference(name = "com.nss.portlet.onedoor.service.PmlOneDoorReceiveFileLocalService.impl")
    protected PmlOneDoorReceiveFileLocalService pmlOneDoorReceiveFileLocalService;
    @BeanReference(name = "com.nss.portlet.onedoor.service.PmlOneDoorReceiveFileService.impl")
    protected PmlOneDoorReceiveFileService pmlOneDoorReceiveFileService;
    @BeanReference(name = "com.nss.portlet.onedoor.service.persistence.PmlOneDoorReceiveFilePersistence.impl")
    protected PmlOneDoorReceiveFilePersistence pmlOneDoorReceiveFilePersistence;
    @BeanReference(name = "com.nss.portlet.onedoor.service.persistence.PmlOneDoorReceiveFileFinder.impl")
    protected PmlOneDoorReceiveFileFinder pmlOneDoorReceiveFileFinder;
    @BeanReference(name = "com.nss.portlet.onedoor.service.PmlWfOnedoorProcessLocalService.impl")
    protected PmlWfOnedoorProcessLocalService pmlWfOnedoorProcessLocalService;
    @BeanReference(name = "com.nss.portlet.onedoor.service.persistence.PmlWfOnedoorProcessPersistence.impl")
    protected PmlWfOnedoorProcessPersistence pmlWfOnedoorProcessPersistence;
    @BeanReference(name = "com.nss.portlet.onedoor.service.PmlWorkflowLocalService.impl")
    protected PmlWorkflowLocalService pmlWorkflowLocalService;
    @BeanReference(name = "com.nss.portlet.onedoor.service.PmlWorkflowService.impl")
    protected PmlWorkflowService pmlWorkflowService;
    @BeanReference(name = "com.nss.portlet.onedoor.service.persistence.PmlWorkflowPersistence.impl")
    protected PmlWorkflowPersistence pmlWorkflowPersistence;
    @BeanReference(name = "com.nss.portlet.onedoor.service.persistence.PmlWorkflowFinder.impl")
    protected PmlWorkflowFinder pmlWorkflowFinder;
    @BeanReference(name = "com.nss.portlet.onedoor.service.PmlStateProcessLocalService.impl")
    protected PmlStateProcessLocalService pmlStateProcessLocalService;
    @BeanReference(name = "com.nss.portlet.onedoor.service.PmlStateProcessService.impl")
    protected PmlStateProcessService pmlStateProcessService;
    @BeanReference(name = "com.nss.portlet.onedoor.service.persistence.PmlStateProcessPersistence.impl")
    protected PmlStateProcessPersistence pmlStateProcessPersistence;
    @BeanReference(name = "com.nss.portlet.onedoor.service.persistence.PmlStateProcessFinder.impl")
    protected PmlStateProcessFinder pmlStateProcessFinder;
    @BeanReference(name = "com.nss.portlet.onedoor.service.PmlProcessDisposeLocalService.impl")
    protected PmlProcessDisposeLocalService pmlProcessDisposeLocalService;
    @BeanReference(name = "com.nss.portlet.onedoor.service.PmlProcessDisposeService.impl")
    protected PmlProcessDisposeService pmlProcessDisposeService;
    @BeanReference(name = "com.nss.portlet.onedoor.service.persistence.PmlProcessDisposePersistence.impl")
    protected PmlProcessDisposePersistence pmlProcessDisposePersistence;
    @BeanReference(name = "com.nss.portlet.onedoor.service.PmlStateWorkFlowLocalService.impl")
    protected PmlStateWorkFlowLocalService pmlStateWorkFlowLocalService;
    @BeanReference(name = "com.nss.portlet.onedoor.service.PmlStateWorkFlowService.impl")
    protected PmlStateWorkFlowService pmlStateWorkFlowService;
    @BeanReference(name = "com.nss.portlet.onedoor.service.persistence.PmlStateWorkFlowPersistence.impl")
    protected PmlStateWorkFlowPersistence pmlStateWorkFlowPersistence;
    @BeanReference(name = "com.nss.portlet.onedoor.service.PmlTransitionLocalService.impl")
    protected PmlTransitionLocalService pmlTransitionLocalService;
    @BeanReference(name = "com.nss.portlet.onedoor.service.PmlTransitionService.impl")
    protected PmlTransitionService pmlTransitionService;
    @BeanReference(name = "com.nss.portlet.onedoor.service.persistence.PmlTransitionPersistence.impl")
    protected PmlTransitionPersistence pmlTransitionPersistence;
    @BeanReference(name = "com.nss.portlet.onedoor.service.PmlFilePCCCLocalService.impl")
    protected PmlFilePCCCLocalService pmlFilePCCCLocalService;
    @BeanReference(name = "com.nss.portlet.onedoor.service.PmlFilePCCCService.impl")
    protected PmlFilePCCCService pmlFilePCCCService;
    @BeanReference(name = "com.nss.portlet.onedoor.service.persistence.PmlFilePCCCPersistence.impl")
    protected PmlFilePCCCPersistence pmlFilePCCCPersistence;
    @BeanReference(name = "com.nss.portlet.onedoor.service.PmlFilePCCCAttachedFileLocalService.impl")
    protected PmlFilePCCCAttachedFileLocalService pmlFilePCCCAttachedFileLocalService;
    @BeanReference(name = "com.nss.portlet.onedoor.service.PmlFilePCCCAttachedFileService.impl")
    protected PmlFilePCCCAttachedFileService pmlFilePCCCAttachedFileService;
    @BeanReference(name = "com.nss.portlet.onedoor.service.persistence.PmlFilePCCCAttachedFilePersistence.impl")
    protected PmlFilePCCCAttachedFilePersistence pmlFilePCCCAttachedFilePersistence;
    @BeanReference(name = "com.nss.portlet.onedoor.service.PmlFileReturningInfoLocalService.impl")
    protected PmlFileReturningInfoLocalService pmlFileReturningInfoLocalService;
    @BeanReference(name = "com.nss.portlet.onedoor.service.PmlFileReturningInfoService.impl")
    protected PmlFileReturningInfoService pmlFileReturningInfoService;
    @BeanReference(name = "com.nss.portlet.onedoor.service.persistence.PmlFileReturningInfoPersistence.impl")
    protected PmlFileReturningInfoPersistence pmlFileReturningInfoPersistence;
    @BeanReference(name = "com.nss.portlet.onedoor.service.PmlFileStatusLocalService.impl")
    protected PmlFileStatusLocalService pmlFileStatusLocalService;
    @BeanReference(name = "com.nss.portlet.onedoor.service.PmlFileStatusService.impl")
    protected PmlFileStatusService pmlFileStatusService;
    @BeanReference(name = "com.nss.portlet.onedoor.service.persistence.PmlFileStatusPersistence.impl")
    protected PmlFileStatusPersistence pmlFileStatusPersistence;
    @BeanReference(name = "com.nss.portlet.onedoor.service.persistence.PmlFileStatusFinder.impl")
    protected PmlFileStatusFinder pmlFileStatusFinder;
    @BeanReference(name = "com.nss.portlet.onedoor.service.PmlFileStatusStateProcessLocalService.impl")
    protected PmlFileStatusStateProcessLocalService pmlFileStatusStateProcessLocalService;
    @BeanReference(name = "com.nss.portlet.onedoor.service.PmlFileStatusStateProcessService.impl")
    protected PmlFileStatusStateProcessService pmlFileStatusStateProcessService;
    @BeanReference(name = "com.nss.portlet.onedoor.service.persistence.PmlFileStatusStateProcessPersistence.impl")
    protected PmlFileStatusStateProcessPersistence pmlFileStatusStateProcessPersistence;
    @BeanReference(name = "com.nss.portlet.onedoor.service.PmlPaintDocumentLocalService.impl")
    protected PmlPaintDocumentLocalService pmlPaintDocumentLocalService;
    @BeanReference(name = "com.nss.portlet.onedoor.service.PmlPaintDocumentService.impl")
    protected PmlPaintDocumentService pmlPaintDocumentService;
    @BeanReference(name = "com.nss.portlet.onedoor.service.persistence.PmlPaintDocumentPersistence.impl")
    protected PmlPaintDocumentPersistence pmlPaintDocumentPersistence;
    @BeanReference(name = "com.liferay.counter.service.CounterLocalService.impl")
    protected CounterLocalService counterLocalService;
    @BeanReference(name = "com.liferay.counter.service.CounterService.impl")
    protected CounterService counterService;

    public PmlOneDoorReceiveFileLocalService getPmlOneDoorReceiveFileLocalService() {
        return pmlOneDoorReceiveFileLocalService;
    }

    public void setPmlOneDoorReceiveFileLocalService(
        PmlOneDoorReceiveFileLocalService pmlOneDoorReceiveFileLocalService) {
        this.pmlOneDoorReceiveFileLocalService = pmlOneDoorReceiveFileLocalService;
    }

    public PmlOneDoorReceiveFileService getPmlOneDoorReceiveFileService() {
        return pmlOneDoorReceiveFileService;
    }

    public void setPmlOneDoorReceiveFileService(
        PmlOneDoorReceiveFileService pmlOneDoorReceiveFileService) {
        this.pmlOneDoorReceiveFileService = pmlOneDoorReceiveFileService;
    }

    public PmlOneDoorReceiveFilePersistence getPmlOneDoorReceiveFilePersistence() {
        return pmlOneDoorReceiveFilePersistence;
    }

    public void setPmlOneDoorReceiveFilePersistence(
        PmlOneDoorReceiveFilePersistence pmlOneDoorReceiveFilePersistence) {
        this.pmlOneDoorReceiveFilePersistence = pmlOneDoorReceiveFilePersistence;
    }

    public PmlOneDoorReceiveFileFinder getPmlOneDoorReceiveFileFinder() {
        return pmlOneDoorReceiveFileFinder;
    }

    public void setPmlOneDoorReceiveFileFinder(
        PmlOneDoorReceiveFileFinder pmlOneDoorReceiveFileFinder) {
        this.pmlOneDoorReceiveFileFinder = pmlOneDoorReceiveFileFinder;
    }

    public PmlWfOnedoorProcessLocalService getPmlWfOnedoorProcessLocalService() {
        return pmlWfOnedoorProcessLocalService;
    }

    public void setPmlWfOnedoorProcessLocalService(
        PmlWfOnedoorProcessLocalService pmlWfOnedoorProcessLocalService) {
        this.pmlWfOnedoorProcessLocalService = pmlWfOnedoorProcessLocalService;
    }

    public PmlWfOnedoorProcessPersistence getPmlWfOnedoorProcessPersistence() {
        return pmlWfOnedoorProcessPersistence;
    }

    public void setPmlWfOnedoorProcessPersistence(
        PmlWfOnedoorProcessPersistence pmlWfOnedoorProcessPersistence) {
        this.pmlWfOnedoorProcessPersistence = pmlWfOnedoorProcessPersistence;
    }

    public PmlWorkflowLocalService getPmlWorkflowLocalService() {
        return pmlWorkflowLocalService;
    }

    public void setPmlWorkflowLocalService(
        PmlWorkflowLocalService pmlWorkflowLocalService) {
        this.pmlWorkflowLocalService = pmlWorkflowLocalService;
    }

    public PmlWorkflowService getPmlWorkflowService() {
        return pmlWorkflowService;
    }

    public void setPmlWorkflowService(PmlWorkflowService pmlWorkflowService) {
        this.pmlWorkflowService = pmlWorkflowService;
    }

    public PmlWorkflowPersistence getPmlWorkflowPersistence() {
        return pmlWorkflowPersistence;
    }

    public void setPmlWorkflowPersistence(
        PmlWorkflowPersistence pmlWorkflowPersistence) {
        this.pmlWorkflowPersistence = pmlWorkflowPersistence;
    }

    public PmlWorkflowFinder getPmlWorkflowFinder() {
        return pmlWorkflowFinder;
    }

    public void setPmlWorkflowFinder(PmlWorkflowFinder pmlWorkflowFinder) {
        this.pmlWorkflowFinder = pmlWorkflowFinder;
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

    public PmlTransitionLocalService getPmlTransitionLocalService() {
        return pmlTransitionLocalService;
    }

    public void setPmlTransitionLocalService(
        PmlTransitionLocalService pmlTransitionLocalService) {
        this.pmlTransitionLocalService = pmlTransitionLocalService;
    }

    public PmlTransitionService getPmlTransitionService() {
        return pmlTransitionService;
    }

    public void setPmlTransitionService(
        PmlTransitionService pmlTransitionService) {
        this.pmlTransitionService = pmlTransitionService;
    }

    public PmlTransitionPersistence getPmlTransitionPersistence() {
        return pmlTransitionPersistence;
    }

    public void setPmlTransitionPersistence(
        PmlTransitionPersistence pmlTransitionPersistence) {
        this.pmlTransitionPersistence = pmlTransitionPersistence;
    }

    public PmlFilePCCCLocalService getPmlFilePCCCLocalService() {
        return pmlFilePCCCLocalService;
    }

    public void setPmlFilePCCCLocalService(
        PmlFilePCCCLocalService pmlFilePCCCLocalService) {
        this.pmlFilePCCCLocalService = pmlFilePCCCLocalService;
    }

    public PmlFilePCCCService getPmlFilePCCCService() {
        return pmlFilePCCCService;
    }

    public void setPmlFilePCCCService(PmlFilePCCCService pmlFilePCCCService) {
        this.pmlFilePCCCService = pmlFilePCCCService;
    }

    public PmlFilePCCCPersistence getPmlFilePCCCPersistence() {
        return pmlFilePCCCPersistence;
    }

    public void setPmlFilePCCCPersistence(
        PmlFilePCCCPersistence pmlFilePCCCPersistence) {
        this.pmlFilePCCCPersistence = pmlFilePCCCPersistence;
    }

    public PmlFilePCCCAttachedFileLocalService getPmlFilePCCCAttachedFileLocalService() {
        return pmlFilePCCCAttachedFileLocalService;
    }

    public void setPmlFilePCCCAttachedFileLocalService(
        PmlFilePCCCAttachedFileLocalService pmlFilePCCCAttachedFileLocalService) {
        this.pmlFilePCCCAttachedFileLocalService = pmlFilePCCCAttachedFileLocalService;
    }

    public PmlFilePCCCAttachedFileService getPmlFilePCCCAttachedFileService() {
        return pmlFilePCCCAttachedFileService;
    }

    public void setPmlFilePCCCAttachedFileService(
        PmlFilePCCCAttachedFileService pmlFilePCCCAttachedFileService) {
        this.pmlFilePCCCAttachedFileService = pmlFilePCCCAttachedFileService;
    }

    public PmlFilePCCCAttachedFilePersistence getPmlFilePCCCAttachedFilePersistence() {
        return pmlFilePCCCAttachedFilePersistence;
    }

    public void setPmlFilePCCCAttachedFilePersistence(
        PmlFilePCCCAttachedFilePersistence pmlFilePCCCAttachedFilePersistence) {
        this.pmlFilePCCCAttachedFilePersistence = pmlFilePCCCAttachedFilePersistence;
    }

    public PmlFileReturningInfoLocalService getPmlFileReturningInfoLocalService() {
        return pmlFileReturningInfoLocalService;
    }

    public void setPmlFileReturningInfoLocalService(
        PmlFileReturningInfoLocalService pmlFileReturningInfoLocalService) {
        this.pmlFileReturningInfoLocalService = pmlFileReturningInfoLocalService;
    }

    public PmlFileReturningInfoService getPmlFileReturningInfoService() {
        return pmlFileReturningInfoService;
    }

    public void setPmlFileReturningInfoService(
        PmlFileReturningInfoService pmlFileReturningInfoService) {
        this.pmlFileReturningInfoService = pmlFileReturningInfoService;
    }

    public PmlFileReturningInfoPersistence getPmlFileReturningInfoPersistence() {
        return pmlFileReturningInfoPersistence;
    }

    public void setPmlFileReturningInfoPersistence(
        PmlFileReturningInfoPersistence pmlFileReturningInfoPersistence) {
        this.pmlFileReturningInfoPersistence = pmlFileReturningInfoPersistence;
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

    public PmlFileStatusStateProcessLocalService getPmlFileStatusStateProcessLocalService() {
        return pmlFileStatusStateProcessLocalService;
    }

    public void setPmlFileStatusStateProcessLocalService(
        PmlFileStatusStateProcessLocalService pmlFileStatusStateProcessLocalService) {
        this.pmlFileStatusStateProcessLocalService = pmlFileStatusStateProcessLocalService;
    }

    public PmlFileStatusStateProcessService getPmlFileStatusStateProcessService() {
        return pmlFileStatusStateProcessService;
    }

    public void setPmlFileStatusStateProcessService(
        PmlFileStatusStateProcessService pmlFileStatusStateProcessService) {
        this.pmlFileStatusStateProcessService = pmlFileStatusStateProcessService;
    }

    public PmlFileStatusStateProcessPersistence getPmlFileStatusStateProcessPersistence() {
        return pmlFileStatusStateProcessPersistence;
    }

    public void setPmlFileStatusStateProcessPersistence(
        PmlFileStatusStateProcessPersistence pmlFileStatusStateProcessPersistence) {
        this.pmlFileStatusStateProcessPersistence = pmlFileStatusStateProcessPersistence;
    }

    public PmlPaintDocumentLocalService getPmlPaintDocumentLocalService() {
        return pmlPaintDocumentLocalService;
    }

    public void setPmlPaintDocumentLocalService(
        PmlPaintDocumentLocalService pmlPaintDocumentLocalService) {
        this.pmlPaintDocumentLocalService = pmlPaintDocumentLocalService;
    }

    public PmlPaintDocumentService getPmlPaintDocumentService() {
        return pmlPaintDocumentService;
    }

    public void setPmlPaintDocumentService(
        PmlPaintDocumentService pmlPaintDocumentService) {
        this.pmlPaintDocumentService = pmlPaintDocumentService;
    }

    public PmlPaintDocumentPersistence getPmlPaintDocumentPersistence() {
        return pmlPaintDocumentPersistence;
    }

    public void setPmlPaintDocumentPersistence(
        PmlPaintDocumentPersistence pmlPaintDocumentPersistence) {
        this.pmlPaintDocumentPersistence = pmlPaintDocumentPersistence;
    }

    public CounterLocalService getCounterLocalService() {
        return counterLocalService;
    }

    public void setCounterLocalService(CounterLocalService counterLocalService) {
        this.counterLocalService = counterLocalService;
    }

    public CounterService getCounterService() {
        return counterService;
    }

    public void setCounterService(CounterService counterService) {
        this.counterService = counterService;
    }

    protected void runSQL(String sql) throws SystemException {
        try {
            PortalUtil.runSQL(sql);
        } catch (Exception e) {
            throw new SystemException(e);
        }
    }
}
