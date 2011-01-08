package com.sgs.portlet.onedoorpccc.service.base;

import com.liferay.portal.service.base.PrincipalBean;

import com.sgs.portlet.onedoorpccc.service.PmlFilePCCCAttachedFileLocalService;
import com.sgs.portlet.onedoorpccc.service.PmlFilePCCCAttachedFileService;
import com.sgs.portlet.onedoorpccc.service.PmlFilePCCCLocalService;
import com.sgs.portlet.onedoorpccc.service.PmlFilePCCCService;
import com.sgs.portlet.onedoorpccc.service.PmlFileReturningInfoLocalService;
import com.sgs.portlet.onedoorpccc.service.PmlFileReturningInfoService;
import com.sgs.portlet.onedoorpccc.service.PmlPaintDocumentLocalService;
import com.sgs.portlet.onedoorpccc.service.PmlPaintDocumentService;
import com.sgs.portlet.onedoorpccc.service.PmlTeamLeaderLocalService;
import com.sgs.portlet.onedoorpccc.service.PmlTeamLeaderService;
import com.sgs.portlet.onedoorpccc.service.PmlTransitionLocalService;
import com.sgs.portlet.onedoorpccc.service.PmlTransitionService;
import com.sgs.portlet.onedoorpccc.service.persistence.PmlFilePCCCAttachedFilePersistence;
import com.sgs.portlet.onedoorpccc.service.persistence.PmlFilePCCCPersistence;
import com.sgs.portlet.onedoorpccc.service.persistence.PmlFileReturningInfoPersistence;
import com.sgs.portlet.onedoorpccc.service.persistence.PmlPaintDocumentPersistence;
import com.sgs.portlet.onedoorpccc.service.persistence.PmlTeamLeaderPersistence;
import com.sgs.portlet.onedoorpccc.service.persistence.PmlTransitionPersistence;


public abstract class PmlPaintDocumentServiceBaseImpl extends PrincipalBean
    implements PmlPaintDocumentService {
    @javax.annotation.Resource(name = "com.sgs.portlet.onedoorpccc.service.PmlPaintDocumentLocalService.impl")
    protected PmlPaintDocumentLocalService pmlPaintDocumentLocalService;
    @javax.annotation.Resource(name = "com.sgs.portlet.onedoorpccc.service.PmlPaintDocumentService.impl")
    protected PmlPaintDocumentService pmlPaintDocumentService;
    @javax.annotation.Resource(name = "com.sgs.portlet.onedoorpccc.service.persistence.PmlPaintDocumentPersistence.impl")
    protected PmlPaintDocumentPersistence pmlPaintDocumentPersistence;
    @javax.annotation.Resource(name = "com.sgs.portlet.onedoorpccc.service.PmlFilePCCCLocalService.impl")
    protected PmlFilePCCCLocalService pmlFilePCCCLocalService;
    @javax.annotation.Resource(name = "com.sgs.portlet.onedoorpccc.service.PmlFilePCCCService.impl")
    protected PmlFilePCCCService pmlFilePCCCService;
    @javax.annotation.Resource(name = "com.sgs.portlet.onedoorpccc.service.persistence.PmlFilePCCCPersistence.impl")
    protected PmlFilePCCCPersistence pmlFilePCCCPersistence;
    @javax.annotation.Resource(name = "com.sgs.portlet.onedoorpccc.service.PmlTransitionLocalService.impl")
    protected PmlTransitionLocalService pmlTransitionLocalService;
    @javax.annotation.Resource(name = "com.sgs.portlet.onedoorpccc.service.PmlTransitionService.impl")
    protected PmlTransitionService pmlTransitionService;
    @javax.annotation.Resource(name = "com.sgs.portlet.onedoorpccc.service.persistence.PmlTransitionPersistence.impl")
    protected PmlTransitionPersistence pmlTransitionPersistence;
    @javax.annotation.Resource(name = "com.sgs.portlet.onedoorpccc.service.PmlFileReturningInfoLocalService.impl")
    protected PmlFileReturningInfoLocalService pmlFileReturningInfoLocalService;
    @javax.annotation.Resource(name = "com.sgs.portlet.onedoorpccc.service.PmlFileReturningInfoService.impl")
    protected PmlFileReturningInfoService pmlFileReturningInfoService;
    @javax.annotation.Resource(name = "com.sgs.portlet.onedoorpccc.service.persistence.PmlFileReturningInfoPersistence.impl")
    protected PmlFileReturningInfoPersistence pmlFileReturningInfoPersistence;
    @javax.annotation.Resource(name = "com.sgs.portlet.onedoorpccc.service.PmlFilePCCCAttachedFileLocalService.impl")
    protected PmlFilePCCCAttachedFileLocalService pmlFilePCCCAttachedFileLocalService;
    @javax.annotation.Resource(name = "com.sgs.portlet.onedoorpccc.service.PmlFilePCCCAttachedFileService.impl")
    protected PmlFilePCCCAttachedFileService pmlFilePCCCAttachedFileService;
    @javax.annotation.Resource(name = "com.sgs.portlet.onedoorpccc.service.persistence.PmlFilePCCCAttachedFilePersistence.impl")
    protected PmlFilePCCCAttachedFilePersistence pmlFilePCCCAttachedFilePersistence;
    @javax.annotation.Resource(name = "com.sgs.portlet.onedoorpccc.service.PmlTeamLeaderLocalService.impl")
    protected PmlTeamLeaderLocalService pmlTeamLeaderLocalService;
    @javax.annotation.Resource(name = "com.sgs.portlet.onedoorpccc.service.PmlTeamLeaderService.impl")
    protected PmlTeamLeaderService pmlTeamLeaderService;
    @javax.annotation.Resource(name = "com.sgs.portlet.onedoorpccc.service.persistence.PmlTeamLeaderPersistence.impl")
    protected PmlTeamLeaderPersistence pmlTeamLeaderPersistence;

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

    public PmlTeamLeaderLocalService getPmlTeamLeaderLocalService() {
        return pmlTeamLeaderLocalService;
    }

    public void setPmlTeamLeaderLocalService(
        PmlTeamLeaderLocalService pmlTeamLeaderLocalService) {
        this.pmlTeamLeaderLocalService = pmlTeamLeaderLocalService;
    }

    public PmlTeamLeaderService getPmlTeamLeaderService() {
        return pmlTeamLeaderService;
    }

    public void setPmlTeamLeaderService(
        PmlTeamLeaderService pmlTeamLeaderService) {
        this.pmlTeamLeaderService = pmlTeamLeaderService;
    }

    public PmlTeamLeaderPersistence getPmlTeamLeaderPersistence() {
        return pmlTeamLeaderPersistence;
    }

    public void setPmlTeamLeaderPersistence(
        PmlTeamLeaderPersistence pmlTeamLeaderPersistence) {
        this.pmlTeamLeaderPersistence = pmlTeamLeaderPersistence;
    }
}
