package com.sgs.portlet.document.receipt.service.base;

import com.liferay.portal.service.base.PrincipalBean;

import com.sgs.portlet.document.receipt.service.PmlEdmAttachedFileLocalService;
import com.sgs.portlet.document.receipt.service.PmlEdmAttachedFileService;
import com.sgs.portlet.document.receipt.service.PmlEdmBookDocumentRecordToLocalService;
import com.sgs.portlet.document.receipt.service.PmlEdmBookDocumentRecordToService;
import com.sgs.portlet.document.receipt.service.PmlEdmConfidentialLevelLocalService;
import com.sgs.portlet.document.receipt.service.PmlEdmConfidentialLevelService;
import com.sgs.portlet.document.receipt.service.PmlEdmDocumentReceiptExtendLocalService;
import com.sgs.portlet.document.receipt.service.PmlEdmDocumentReceiptExtendService;
import com.sgs.portlet.document.receipt.service.PmlEdmDocumentReceiptLocalService;
import com.sgs.portlet.document.receipt.service.PmlEdmDocumentReceiptProcessTypeLocalService;
import com.sgs.portlet.document.receipt.service.PmlEdmDocumentReceiptProcessTypeService;
import com.sgs.portlet.document.receipt.service.PmlEdmDocumentReceiptService;
import com.sgs.portlet.document.receipt.service.PmlEdmDocumentReceiptTempLocalService;
import com.sgs.portlet.document.receipt.service.PmlEdmDocumentReceiptTempService;
import com.sgs.portlet.document.receipt.service.PmlEdmDocumentRecordToLocalService;
import com.sgs.portlet.document.receipt.service.PmlEdmDocumentRecordToService;
import com.sgs.portlet.document.receipt.service.PmlEdmDocumentRecordTypeLocalService;
import com.sgs.portlet.document.receipt.service.PmlEdmDocumentRecordTypeService;
import com.sgs.portlet.document.receipt.service.PmlEdmDocumentTypeLocalService;
import com.sgs.portlet.document.receipt.service.PmlEdmDocumentTypeService;
import com.sgs.portlet.document.receipt.service.PmlEdmLevelSendDetailLocalService;
import com.sgs.portlet.document.receipt.service.PmlEdmLevelSendDetailService;
import com.sgs.portlet.document.receipt.service.PmlEdmPrivilegeLevelLocalService;
import com.sgs.portlet.document.receipt.service.PmlEdmPrivilegeLevelService;
import com.sgs.portlet.document.receipt.service.PmlEdmProcessDocumentReceiptDetailLocalService;
import com.sgs.portlet.document.receipt.service.PmlEdmProcessDocumentReceiptDetailService;
import com.sgs.portlet.document.receipt.service.PmlFileStatusStateProcessLocalService;
import com.sgs.portlet.document.receipt.service.PmlFileStatusStateProcessService;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmAttachedFilePersistence;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmBookDocumentRecordToPersistence;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmConfidentialLevelFinder;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmConfidentialLevelPersistence;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentReceiptExtendFinder;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentReceiptExtendPersistence;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentReceiptFinder;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentReceiptPersistence;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentReceiptProcessTypePersistence;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentReceiptTempFinder;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentReceiptTempPersistence;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentRecordToFinder;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentRecordToPersistence;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentRecordTypeFinder;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentRecordTypePersistence;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentTypeFinder;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentTypePersistence;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmLevelSendDetailFinder;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmLevelSendDetailPersistence;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmPrivilegeLevelFinder;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmPrivilegeLevelPersistence;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmProcessDocumentReceiptDetailPersistence;
import com.sgs.portlet.document.receipt.service.persistence.PmlFileStatusStateProcessPersistence;


public abstract class PmlFileStatusStateProcessServiceBaseImpl
    extends PrincipalBean implements PmlFileStatusStateProcessService {
    @javax.annotation.Resource(name = "com.sgs.portlet.document.receipt.service.PmlEdmBookDocumentRecordToLocalService.impl")
    protected PmlEdmBookDocumentRecordToLocalService pmlEdmBookDocumentRecordToLocalService;
    @javax.annotation.Resource(name = "com.sgs.portlet.document.receipt.service.PmlEdmBookDocumentRecordToService.impl")
    protected PmlEdmBookDocumentRecordToService pmlEdmBookDocumentRecordToService;
    @javax.annotation.Resource(name = "com.sgs.portlet.document.receipt.service.persistence.PmlEdmBookDocumentRecordToPersistence.impl")
    protected PmlEdmBookDocumentRecordToPersistence pmlEdmBookDocumentRecordToPersistence;
    @javax.annotation.Resource(name = "com.sgs.portlet.document.receipt.service.PmlEdmLevelSendDetailLocalService.impl")
    protected PmlEdmLevelSendDetailLocalService pmlEdmLevelSendDetailLocalService;
    @javax.annotation.Resource(name = "com.sgs.portlet.document.receipt.service.PmlEdmLevelSendDetailService.impl")
    protected PmlEdmLevelSendDetailService pmlEdmLevelSendDetailService;
    @javax.annotation.Resource(name = "com.sgs.portlet.document.receipt.service.persistence.PmlEdmLevelSendDetailPersistence.impl")
    protected PmlEdmLevelSendDetailPersistence pmlEdmLevelSendDetailPersistence;
    @javax.annotation.Resource(name = "com.sgs.portlet.document.receipt.service.persistence.PmlEdmLevelSendDetailFinder.impl")
    protected PmlEdmLevelSendDetailFinder pmlEdmLevelSendDetailFinder;
    @javax.annotation.Resource(name = "com.sgs.portlet.document.receipt.service.PmlEdmDocumentRecordToLocalService.impl")
    protected PmlEdmDocumentRecordToLocalService pmlEdmDocumentRecordToLocalService;
    @javax.annotation.Resource(name = "com.sgs.portlet.document.receipt.service.PmlEdmDocumentRecordToService.impl")
    protected PmlEdmDocumentRecordToService pmlEdmDocumentRecordToService;
    @javax.annotation.Resource(name = "com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentRecordToPersistence.impl")
    protected PmlEdmDocumentRecordToPersistence pmlEdmDocumentRecordToPersistence;
    @javax.annotation.Resource(name = "com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentRecordToFinder.impl")
    protected PmlEdmDocumentRecordToFinder pmlEdmDocumentRecordToFinder;
    @javax.annotation.Resource(name = "com.sgs.portlet.document.receipt.service.PmlEdmDocumentRecordTypeLocalService.impl")
    protected PmlEdmDocumentRecordTypeLocalService pmlEdmDocumentRecordTypeLocalService;
    @javax.annotation.Resource(name = "com.sgs.portlet.document.receipt.service.PmlEdmDocumentRecordTypeService.impl")
    protected PmlEdmDocumentRecordTypeService pmlEdmDocumentRecordTypeService;
    @javax.annotation.Resource(name = "com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentRecordTypePersistence.impl")
    protected PmlEdmDocumentRecordTypePersistence pmlEdmDocumentRecordTypePersistence;
    @javax.annotation.Resource(name = "com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentRecordTypeFinder.impl")
    protected PmlEdmDocumentRecordTypeFinder pmlEdmDocumentRecordTypeFinder;
    @javax.annotation.Resource(name = "com.sgs.portlet.document.receipt.service.PmlEdmDocumentReceiptLocalService.impl")
    protected PmlEdmDocumentReceiptLocalService pmlEdmDocumentReceiptLocalService;
    @javax.annotation.Resource(name = "com.sgs.portlet.document.receipt.service.PmlEdmDocumentReceiptService.impl")
    protected PmlEdmDocumentReceiptService pmlEdmDocumentReceiptService;
    @javax.annotation.Resource(name = "com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentReceiptPersistence.impl")
    protected PmlEdmDocumentReceiptPersistence pmlEdmDocumentReceiptPersistence;
    @javax.annotation.Resource(name = "com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentReceiptFinder.impl")
    protected PmlEdmDocumentReceiptFinder pmlEdmDocumentReceiptFinder;
    @javax.annotation.Resource(name = "com.sgs.portlet.document.receipt.service.PmlEdmDocumentReceiptTempLocalService.impl")
    protected PmlEdmDocumentReceiptTempLocalService pmlEdmDocumentReceiptTempLocalService;
    @javax.annotation.Resource(name = "com.sgs.portlet.document.receipt.service.PmlEdmDocumentReceiptTempService.impl")
    protected PmlEdmDocumentReceiptTempService pmlEdmDocumentReceiptTempService;
    @javax.annotation.Resource(name = "com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentReceiptTempPersistence.impl")
    protected PmlEdmDocumentReceiptTempPersistence pmlEdmDocumentReceiptTempPersistence;
    @javax.annotation.Resource(name = "com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentReceiptTempFinder.impl")
    protected PmlEdmDocumentReceiptTempFinder pmlEdmDocumentReceiptTempFinder;
    @javax.annotation.Resource(name = "com.sgs.portlet.document.receipt.service.PmlEdmDocumentReceiptExtendLocalService.impl")
    protected PmlEdmDocumentReceiptExtendLocalService pmlEdmDocumentReceiptExtendLocalService;
    @javax.annotation.Resource(name = "com.sgs.portlet.document.receipt.service.PmlEdmDocumentReceiptExtendService.impl")
    protected PmlEdmDocumentReceiptExtendService pmlEdmDocumentReceiptExtendService;
    @javax.annotation.Resource(name = "com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentReceiptExtendPersistence.impl")
    protected PmlEdmDocumentReceiptExtendPersistence pmlEdmDocumentReceiptExtendPersistence;
    @javax.annotation.Resource(name = "com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentReceiptExtendFinder.impl")
    protected PmlEdmDocumentReceiptExtendFinder pmlEdmDocumentReceiptExtendFinder;
    @javax.annotation.Resource(name = "com.sgs.portlet.document.receipt.service.PmlEdmDocumentTypeLocalService.impl")
    protected PmlEdmDocumentTypeLocalService pmlEdmDocumentTypeLocalService;
    @javax.annotation.Resource(name = "com.sgs.portlet.document.receipt.service.PmlEdmDocumentTypeService.impl")
    protected PmlEdmDocumentTypeService pmlEdmDocumentTypeService;
    @javax.annotation.Resource(name = "com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentTypePersistence.impl")
    protected PmlEdmDocumentTypePersistence pmlEdmDocumentTypePersistence;
    @javax.annotation.Resource(name = "com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentTypeFinder.impl")
    protected PmlEdmDocumentTypeFinder pmlEdmDocumentTypeFinder;
    @javax.annotation.Resource(name = "com.sgs.portlet.document.receipt.service.PmlEdmProcessDocumentReceiptDetailLocalService.impl")
    protected PmlEdmProcessDocumentReceiptDetailLocalService pmlEdmProcessDocumentReceiptDetailLocalService;
    @javax.annotation.Resource(name = "com.sgs.portlet.document.receipt.service.PmlEdmProcessDocumentReceiptDetailService.impl")
    protected PmlEdmProcessDocumentReceiptDetailService pmlEdmProcessDocumentReceiptDetailService;
    @javax.annotation.Resource(name = "com.sgs.portlet.document.receipt.service.persistence.PmlEdmProcessDocumentReceiptDetailPersistence.impl")
    protected PmlEdmProcessDocumentReceiptDetailPersistence pmlEdmProcessDocumentReceiptDetailPersistence;
    @javax.annotation.Resource(name = "com.sgs.portlet.document.receipt.service.PmlEdmConfidentialLevelLocalService.impl")
    protected PmlEdmConfidentialLevelLocalService pmlEdmConfidentialLevelLocalService;
    @javax.annotation.Resource(name = "com.sgs.portlet.document.receipt.service.PmlEdmConfidentialLevelService.impl")
    protected PmlEdmConfidentialLevelService pmlEdmConfidentialLevelService;
    @javax.annotation.Resource(name = "com.sgs.portlet.document.receipt.service.persistence.PmlEdmConfidentialLevelPersistence.impl")
    protected PmlEdmConfidentialLevelPersistence pmlEdmConfidentialLevelPersistence;
    @javax.annotation.Resource(name = "com.sgs.portlet.document.receipt.service.persistence.PmlEdmConfidentialLevelFinder.impl")
    protected PmlEdmConfidentialLevelFinder pmlEdmConfidentialLevelFinder;
    @javax.annotation.Resource(name = "com.sgs.portlet.document.receipt.service.PmlEdmPrivilegeLevelLocalService.impl")
    protected PmlEdmPrivilegeLevelLocalService pmlEdmPrivilegeLevelLocalService;
    @javax.annotation.Resource(name = "com.sgs.portlet.document.receipt.service.PmlEdmPrivilegeLevelService.impl")
    protected PmlEdmPrivilegeLevelService pmlEdmPrivilegeLevelService;
    @javax.annotation.Resource(name = "com.sgs.portlet.document.receipt.service.persistence.PmlEdmPrivilegeLevelPersistence.impl")
    protected PmlEdmPrivilegeLevelPersistence pmlEdmPrivilegeLevelPersistence;
    @javax.annotation.Resource(name = "com.sgs.portlet.document.receipt.service.persistence.PmlEdmPrivilegeLevelFinder.impl")
    protected PmlEdmPrivilegeLevelFinder pmlEdmPrivilegeLevelFinder;
    @javax.annotation.Resource(name = "com.sgs.portlet.document.receipt.service.PmlEdmAttachedFileLocalService.impl")
    protected PmlEdmAttachedFileLocalService pmlEdmAttachedFileLocalService;
    @javax.annotation.Resource(name = "com.sgs.portlet.document.receipt.service.PmlEdmAttachedFileService.impl")
    protected PmlEdmAttachedFileService pmlEdmAttachedFileService;
    @javax.annotation.Resource(name = "com.sgs.portlet.document.receipt.service.persistence.PmlEdmAttachedFilePersistence.impl")
    protected PmlEdmAttachedFilePersistence pmlEdmAttachedFilePersistence;
    @javax.annotation.Resource(name = "com.sgs.portlet.document.receipt.service.PmlFileStatusStateProcessLocalService.impl")
    protected PmlFileStatusStateProcessLocalService pmlFileStatusStateProcessLocalService;
    @javax.annotation.Resource(name = "com.sgs.portlet.document.receipt.service.PmlFileStatusStateProcessService.impl")
    protected PmlFileStatusStateProcessService pmlFileStatusStateProcessService;
    @javax.annotation.Resource(name = "com.sgs.portlet.document.receipt.service.persistence.PmlFileStatusStateProcessPersistence.impl")
    protected PmlFileStatusStateProcessPersistence pmlFileStatusStateProcessPersistence;
    @javax.annotation.Resource(name = "com.sgs.portlet.document.receipt.service.PmlEdmDocumentReceiptProcessTypeLocalService.impl")
    protected PmlEdmDocumentReceiptProcessTypeLocalService pmlEdmDocumentReceiptProcessTypeLocalService;
    @javax.annotation.Resource(name = "com.sgs.portlet.document.receipt.service.PmlEdmDocumentReceiptProcessTypeService.impl")
    protected PmlEdmDocumentReceiptProcessTypeService pmlEdmDocumentReceiptProcessTypeService;
    @javax.annotation.Resource(name = "com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentReceiptProcessTypePersistence.impl")
    protected PmlEdmDocumentReceiptProcessTypePersistence pmlEdmDocumentReceiptProcessTypePersistence;

    public PmlEdmBookDocumentRecordToLocalService getPmlEdmBookDocumentRecordToLocalService() {
        return pmlEdmBookDocumentRecordToLocalService;
    }

    public void setPmlEdmBookDocumentRecordToLocalService(
        PmlEdmBookDocumentRecordToLocalService pmlEdmBookDocumentRecordToLocalService) {
        this.pmlEdmBookDocumentRecordToLocalService = pmlEdmBookDocumentRecordToLocalService;
    }

    public PmlEdmBookDocumentRecordToService getPmlEdmBookDocumentRecordToService() {
        return pmlEdmBookDocumentRecordToService;
    }

    public void setPmlEdmBookDocumentRecordToService(
        PmlEdmBookDocumentRecordToService pmlEdmBookDocumentRecordToService) {
        this.pmlEdmBookDocumentRecordToService = pmlEdmBookDocumentRecordToService;
    }

    public PmlEdmBookDocumentRecordToPersistence getPmlEdmBookDocumentRecordToPersistence() {
        return pmlEdmBookDocumentRecordToPersistence;
    }

    public void setPmlEdmBookDocumentRecordToPersistence(
        PmlEdmBookDocumentRecordToPersistence pmlEdmBookDocumentRecordToPersistence) {
        this.pmlEdmBookDocumentRecordToPersistence = pmlEdmBookDocumentRecordToPersistence;
    }

    public PmlEdmLevelSendDetailLocalService getPmlEdmLevelSendDetailLocalService() {
        return pmlEdmLevelSendDetailLocalService;
    }

    public void setPmlEdmLevelSendDetailLocalService(
        PmlEdmLevelSendDetailLocalService pmlEdmLevelSendDetailLocalService) {
        this.pmlEdmLevelSendDetailLocalService = pmlEdmLevelSendDetailLocalService;
    }

    public PmlEdmLevelSendDetailService getPmlEdmLevelSendDetailService() {
        return pmlEdmLevelSendDetailService;
    }

    public void setPmlEdmLevelSendDetailService(
        PmlEdmLevelSendDetailService pmlEdmLevelSendDetailService) {
        this.pmlEdmLevelSendDetailService = pmlEdmLevelSendDetailService;
    }

    public PmlEdmLevelSendDetailPersistence getPmlEdmLevelSendDetailPersistence() {
        return pmlEdmLevelSendDetailPersistence;
    }

    public void setPmlEdmLevelSendDetailPersistence(
        PmlEdmLevelSendDetailPersistence pmlEdmLevelSendDetailPersistence) {
        this.pmlEdmLevelSendDetailPersistence = pmlEdmLevelSendDetailPersistence;
    }

    public PmlEdmLevelSendDetailFinder getPmlEdmLevelSendDetailFinder() {
        return pmlEdmLevelSendDetailFinder;
    }

    public void setPmlEdmLevelSendDetailFinder(
        PmlEdmLevelSendDetailFinder pmlEdmLevelSendDetailFinder) {
        this.pmlEdmLevelSendDetailFinder = pmlEdmLevelSendDetailFinder;
    }

    public PmlEdmDocumentRecordToLocalService getPmlEdmDocumentRecordToLocalService() {
        return pmlEdmDocumentRecordToLocalService;
    }

    public void setPmlEdmDocumentRecordToLocalService(
        PmlEdmDocumentRecordToLocalService pmlEdmDocumentRecordToLocalService) {
        this.pmlEdmDocumentRecordToLocalService = pmlEdmDocumentRecordToLocalService;
    }

    public PmlEdmDocumentRecordToService getPmlEdmDocumentRecordToService() {
        return pmlEdmDocumentRecordToService;
    }

    public void setPmlEdmDocumentRecordToService(
        PmlEdmDocumentRecordToService pmlEdmDocumentRecordToService) {
        this.pmlEdmDocumentRecordToService = pmlEdmDocumentRecordToService;
    }

    public PmlEdmDocumentRecordToPersistence getPmlEdmDocumentRecordToPersistence() {
        return pmlEdmDocumentRecordToPersistence;
    }

    public void setPmlEdmDocumentRecordToPersistence(
        PmlEdmDocumentRecordToPersistence pmlEdmDocumentRecordToPersistence) {
        this.pmlEdmDocumentRecordToPersistence = pmlEdmDocumentRecordToPersistence;
    }

    public PmlEdmDocumentRecordToFinder getPmlEdmDocumentRecordToFinder() {
        return pmlEdmDocumentRecordToFinder;
    }

    public void setPmlEdmDocumentRecordToFinder(
        PmlEdmDocumentRecordToFinder pmlEdmDocumentRecordToFinder) {
        this.pmlEdmDocumentRecordToFinder = pmlEdmDocumentRecordToFinder;
    }

    public PmlEdmDocumentRecordTypeLocalService getPmlEdmDocumentRecordTypeLocalService() {
        return pmlEdmDocumentRecordTypeLocalService;
    }

    public void setPmlEdmDocumentRecordTypeLocalService(
        PmlEdmDocumentRecordTypeLocalService pmlEdmDocumentRecordTypeLocalService) {
        this.pmlEdmDocumentRecordTypeLocalService = pmlEdmDocumentRecordTypeLocalService;
    }

    public PmlEdmDocumentRecordTypeService getPmlEdmDocumentRecordTypeService() {
        return pmlEdmDocumentRecordTypeService;
    }

    public void setPmlEdmDocumentRecordTypeService(
        PmlEdmDocumentRecordTypeService pmlEdmDocumentRecordTypeService) {
        this.pmlEdmDocumentRecordTypeService = pmlEdmDocumentRecordTypeService;
    }

    public PmlEdmDocumentRecordTypePersistence getPmlEdmDocumentRecordTypePersistence() {
        return pmlEdmDocumentRecordTypePersistence;
    }

    public void setPmlEdmDocumentRecordTypePersistence(
        PmlEdmDocumentRecordTypePersistence pmlEdmDocumentRecordTypePersistence) {
        this.pmlEdmDocumentRecordTypePersistence = pmlEdmDocumentRecordTypePersistence;
    }

    public PmlEdmDocumentRecordTypeFinder getPmlEdmDocumentRecordTypeFinder() {
        return pmlEdmDocumentRecordTypeFinder;
    }

    public void setPmlEdmDocumentRecordTypeFinder(
        PmlEdmDocumentRecordTypeFinder pmlEdmDocumentRecordTypeFinder) {
        this.pmlEdmDocumentRecordTypeFinder = pmlEdmDocumentRecordTypeFinder;
    }

    public PmlEdmDocumentReceiptLocalService getPmlEdmDocumentReceiptLocalService() {
        return pmlEdmDocumentReceiptLocalService;
    }

    public void setPmlEdmDocumentReceiptLocalService(
        PmlEdmDocumentReceiptLocalService pmlEdmDocumentReceiptLocalService) {
        this.pmlEdmDocumentReceiptLocalService = pmlEdmDocumentReceiptLocalService;
    }

    public PmlEdmDocumentReceiptService getPmlEdmDocumentReceiptService() {
        return pmlEdmDocumentReceiptService;
    }

    public void setPmlEdmDocumentReceiptService(
        PmlEdmDocumentReceiptService pmlEdmDocumentReceiptService) {
        this.pmlEdmDocumentReceiptService = pmlEdmDocumentReceiptService;
    }

    public PmlEdmDocumentReceiptPersistence getPmlEdmDocumentReceiptPersistence() {
        return pmlEdmDocumentReceiptPersistence;
    }

    public void setPmlEdmDocumentReceiptPersistence(
        PmlEdmDocumentReceiptPersistence pmlEdmDocumentReceiptPersistence) {
        this.pmlEdmDocumentReceiptPersistence = pmlEdmDocumentReceiptPersistence;
    }

    public PmlEdmDocumentReceiptFinder getPmlEdmDocumentReceiptFinder() {
        return pmlEdmDocumentReceiptFinder;
    }

    public void setPmlEdmDocumentReceiptFinder(
        PmlEdmDocumentReceiptFinder pmlEdmDocumentReceiptFinder) {
        this.pmlEdmDocumentReceiptFinder = pmlEdmDocumentReceiptFinder;
    }

    public PmlEdmDocumentReceiptTempLocalService getPmlEdmDocumentReceiptTempLocalService() {
        return pmlEdmDocumentReceiptTempLocalService;
    }

    public void setPmlEdmDocumentReceiptTempLocalService(
        PmlEdmDocumentReceiptTempLocalService pmlEdmDocumentReceiptTempLocalService) {
        this.pmlEdmDocumentReceiptTempLocalService = pmlEdmDocumentReceiptTempLocalService;
    }

    public PmlEdmDocumentReceiptTempService getPmlEdmDocumentReceiptTempService() {
        return pmlEdmDocumentReceiptTempService;
    }

    public void setPmlEdmDocumentReceiptTempService(
        PmlEdmDocumentReceiptTempService pmlEdmDocumentReceiptTempService) {
        this.pmlEdmDocumentReceiptTempService = pmlEdmDocumentReceiptTempService;
    }

    public PmlEdmDocumentReceiptTempPersistence getPmlEdmDocumentReceiptTempPersistence() {
        return pmlEdmDocumentReceiptTempPersistence;
    }

    public void setPmlEdmDocumentReceiptTempPersistence(
        PmlEdmDocumentReceiptTempPersistence pmlEdmDocumentReceiptTempPersistence) {
        this.pmlEdmDocumentReceiptTempPersistence = pmlEdmDocumentReceiptTempPersistence;
    }

    public PmlEdmDocumentReceiptTempFinder getPmlEdmDocumentReceiptTempFinder() {
        return pmlEdmDocumentReceiptTempFinder;
    }

    public void setPmlEdmDocumentReceiptTempFinder(
        PmlEdmDocumentReceiptTempFinder pmlEdmDocumentReceiptTempFinder) {
        this.pmlEdmDocumentReceiptTempFinder = pmlEdmDocumentReceiptTempFinder;
    }

    public PmlEdmDocumentReceiptExtendLocalService getPmlEdmDocumentReceiptExtendLocalService() {
        return pmlEdmDocumentReceiptExtendLocalService;
    }

    public void setPmlEdmDocumentReceiptExtendLocalService(
        PmlEdmDocumentReceiptExtendLocalService pmlEdmDocumentReceiptExtendLocalService) {
        this.pmlEdmDocumentReceiptExtendLocalService = pmlEdmDocumentReceiptExtendLocalService;
    }

    public PmlEdmDocumentReceiptExtendService getPmlEdmDocumentReceiptExtendService() {
        return pmlEdmDocumentReceiptExtendService;
    }

    public void setPmlEdmDocumentReceiptExtendService(
        PmlEdmDocumentReceiptExtendService pmlEdmDocumentReceiptExtendService) {
        this.pmlEdmDocumentReceiptExtendService = pmlEdmDocumentReceiptExtendService;
    }

    public PmlEdmDocumentReceiptExtendPersistence getPmlEdmDocumentReceiptExtendPersistence() {
        return pmlEdmDocumentReceiptExtendPersistence;
    }

    public void setPmlEdmDocumentReceiptExtendPersistence(
        PmlEdmDocumentReceiptExtendPersistence pmlEdmDocumentReceiptExtendPersistence) {
        this.pmlEdmDocumentReceiptExtendPersistence = pmlEdmDocumentReceiptExtendPersistence;
    }

    public PmlEdmDocumentReceiptExtendFinder getPmlEdmDocumentReceiptExtendFinder() {
        return pmlEdmDocumentReceiptExtendFinder;
    }

    public void setPmlEdmDocumentReceiptExtendFinder(
        PmlEdmDocumentReceiptExtendFinder pmlEdmDocumentReceiptExtendFinder) {
        this.pmlEdmDocumentReceiptExtendFinder = pmlEdmDocumentReceiptExtendFinder;
    }

    public PmlEdmDocumentTypeLocalService getPmlEdmDocumentTypeLocalService() {
        return pmlEdmDocumentTypeLocalService;
    }

    public void setPmlEdmDocumentTypeLocalService(
        PmlEdmDocumentTypeLocalService pmlEdmDocumentTypeLocalService) {
        this.pmlEdmDocumentTypeLocalService = pmlEdmDocumentTypeLocalService;
    }

    public PmlEdmDocumentTypeService getPmlEdmDocumentTypeService() {
        return pmlEdmDocumentTypeService;
    }

    public void setPmlEdmDocumentTypeService(
        PmlEdmDocumentTypeService pmlEdmDocumentTypeService) {
        this.pmlEdmDocumentTypeService = pmlEdmDocumentTypeService;
    }

    public PmlEdmDocumentTypePersistence getPmlEdmDocumentTypePersistence() {
        return pmlEdmDocumentTypePersistence;
    }

    public void setPmlEdmDocumentTypePersistence(
        PmlEdmDocumentTypePersistence pmlEdmDocumentTypePersistence) {
        this.pmlEdmDocumentTypePersistence = pmlEdmDocumentTypePersistence;
    }

    public PmlEdmDocumentTypeFinder getPmlEdmDocumentTypeFinder() {
        return pmlEdmDocumentTypeFinder;
    }

    public void setPmlEdmDocumentTypeFinder(
        PmlEdmDocumentTypeFinder pmlEdmDocumentTypeFinder) {
        this.pmlEdmDocumentTypeFinder = pmlEdmDocumentTypeFinder;
    }

    public PmlEdmProcessDocumentReceiptDetailLocalService getPmlEdmProcessDocumentReceiptDetailLocalService() {
        return pmlEdmProcessDocumentReceiptDetailLocalService;
    }

    public void setPmlEdmProcessDocumentReceiptDetailLocalService(
        PmlEdmProcessDocumentReceiptDetailLocalService pmlEdmProcessDocumentReceiptDetailLocalService) {
        this.pmlEdmProcessDocumentReceiptDetailLocalService = pmlEdmProcessDocumentReceiptDetailLocalService;
    }

    public PmlEdmProcessDocumentReceiptDetailService getPmlEdmProcessDocumentReceiptDetailService() {
        return pmlEdmProcessDocumentReceiptDetailService;
    }

    public void setPmlEdmProcessDocumentReceiptDetailService(
        PmlEdmProcessDocumentReceiptDetailService pmlEdmProcessDocumentReceiptDetailService) {
        this.pmlEdmProcessDocumentReceiptDetailService = pmlEdmProcessDocumentReceiptDetailService;
    }

    public PmlEdmProcessDocumentReceiptDetailPersistence getPmlEdmProcessDocumentReceiptDetailPersistence() {
        return pmlEdmProcessDocumentReceiptDetailPersistence;
    }

    public void setPmlEdmProcessDocumentReceiptDetailPersistence(
        PmlEdmProcessDocumentReceiptDetailPersistence pmlEdmProcessDocumentReceiptDetailPersistence) {
        this.pmlEdmProcessDocumentReceiptDetailPersistence = pmlEdmProcessDocumentReceiptDetailPersistence;
    }

    public PmlEdmConfidentialLevelLocalService getPmlEdmConfidentialLevelLocalService() {
        return pmlEdmConfidentialLevelLocalService;
    }

    public void setPmlEdmConfidentialLevelLocalService(
        PmlEdmConfidentialLevelLocalService pmlEdmConfidentialLevelLocalService) {
        this.pmlEdmConfidentialLevelLocalService = pmlEdmConfidentialLevelLocalService;
    }

    public PmlEdmConfidentialLevelService getPmlEdmConfidentialLevelService() {
        return pmlEdmConfidentialLevelService;
    }

    public void setPmlEdmConfidentialLevelService(
        PmlEdmConfidentialLevelService pmlEdmConfidentialLevelService) {
        this.pmlEdmConfidentialLevelService = pmlEdmConfidentialLevelService;
    }

    public PmlEdmConfidentialLevelPersistence getPmlEdmConfidentialLevelPersistence() {
        return pmlEdmConfidentialLevelPersistence;
    }

    public void setPmlEdmConfidentialLevelPersistence(
        PmlEdmConfidentialLevelPersistence pmlEdmConfidentialLevelPersistence) {
        this.pmlEdmConfidentialLevelPersistence = pmlEdmConfidentialLevelPersistence;
    }

    public PmlEdmConfidentialLevelFinder getPmlEdmConfidentialLevelFinder() {
        return pmlEdmConfidentialLevelFinder;
    }

    public void setPmlEdmConfidentialLevelFinder(
        PmlEdmConfidentialLevelFinder pmlEdmConfidentialLevelFinder) {
        this.pmlEdmConfidentialLevelFinder = pmlEdmConfidentialLevelFinder;
    }

    public PmlEdmPrivilegeLevelLocalService getPmlEdmPrivilegeLevelLocalService() {
        return pmlEdmPrivilegeLevelLocalService;
    }

    public void setPmlEdmPrivilegeLevelLocalService(
        PmlEdmPrivilegeLevelLocalService pmlEdmPrivilegeLevelLocalService) {
        this.pmlEdmPrivilegeLevelLocalService = pmlEdmPrivilegeLevelLocalService;
    }

    public PmlEdmPrivilegeLevelService getPmlEdmPrivilegeLevelService() {
        return pmlEdmPrivilegeLevelService;
    }

    public void setPmlEdmPrivilegeLevelService(
        PmlEdmPrivilegeLevelService pmlEdmPrivilegeLevelService) {
        this.pmlEdmPrivilegeLevelService = pmlEdmPrivilegeLevelService;
    }

    public PmlEdmPrivilegeLevelPersistence getPmlEdmPrivilegeLevelPersistence() {
        return pmlEdmPrivilegeLevelPersistence;
    }

    public void setPmlEdmPrivilegeLevelPersistence(
        PmlEdmPrivilegeLevelPersistence pmlEdmPrivilegeLevelPersistence) {
        this.pmlEdmPrivilegeLevelPersistence = pmlEdmPrivilegeLevelPersistence;
    }

    public PmlEdmPrivilegeLevelFinder getPmlEdmPrivilegeLevelFinder() {
        return pmlEdmPrivilegeLevelFinder;
    }

    public void setPmlEdmPrivilegeLevelFinder(
        PmlEdmPrivilegeLevelFinder pmlEdmPrivilegeLevelFinder) {
        this.pmlEdmPrivilegeLevelFinder = pmlEdmPrivilegeLevelFinder;
    }

    public PmlEdmAttachedFileLocalService getPmlEdmAttachedFileLocalService() {
        return pmlEdmAttachedFileLocalService;
    }

    public void setPmlEdmAttachedFileLocalService(
        PmlEdmAttachedFileLocalService pmlEdmAttachedFileLocalService) {
        this.pmlEdmAttachedFileLocalService = pmlEdmAttachedFileLocalService;
    }

    public PmlEdmAttachedFileService getPmlEdmAttachedFileService() {
        return pmlEdmAttachedFileService;
    }

    public void setPmlEdmAttachedFileService(
        PmlEdmAttachedFileService pmlEdmAttachedFileService) {
        this.pmlEdmAttachedFileService = pmlEdmAttachedFileService;
    }

    public PmlEdmAttachedFilePersistence getPmlEdmAttachedFilePersistence() {
        return pmlEdmAttachedFilePersistence;
    }

    public void setPmlEdmAttachedFilePersistence(
        PmlEdmAttachedFilePersistence pmlEdmAttachedFilePersistence) {
        this.pmlEdmAttachedFilePersistence = pmlEdmAttachedFilePersistence;
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

    public PmlEdmDocumentReceiptProcessTypeLocalService getPmlEdmDocumentReceiptProcessTypeLocalService() {
        return pmlEdmDocumentReceiptProcessTypeLocalService;
    }

    public void setPmlEdmDocumentReceiptProcessTypeLocalService(
        PmlEdmDocumentReceiptProcessTypeLocalService pmlEdmDocumentReceiptProcessTypeLocalService) {
        this.pmlEdmDocumentReceiptProcessTypeLocalService = pmlEdmDocumentReceiptProcessTypeLocalService;
    }

    public PmlEdmDocumentReceiptProcessTypeService getPmlEdmDocumentReceiptProcessTypeService() {
        return pmlEdmDocumentReceiptProcessTypeService;
    }

    public void setPmlEdmDocumentReceiptProcessTypeService(
        PmlEdmDocumentReceiptProcessTypeService pmlEdmDocumentReceiptProcessTypeService) {
        this.pmlEdmDocumentReceiptProcessTypeService = pmlEdmDocumentReceiptProcessTypeService;
    }

    public PmlEdmDocumentReceiptProcessTypePersistence getPmlEdmDocumentReceiptProcessTypePersistence() {
        return pmlEdmDocumentReceiptProcessTypePersistence;
    }

    public void setPmlEdmDocumentReceiptProcessTypePersistence(
        PmlEdmDocumentReceiptProcessTypePersistence pmlEdmDocumentReceiptProcessTypePersistence) {
        this.pmlEdmDocumentReceiptProcessTypePersistence = pmlEdmDocumentReceiptProcessTypePersistence;
    }
}
