package com.sgs.portlet.document_manager.service.base;

import com.liferay.portal.service.base.PrincipalBean;

import com.sgs.portlet.document_manager.service.AttactFileDocumentLocalService;
import com.sgs.portlet.document_manager.service.AttactFileDocumentService;
import com.sgs.portlet.document_manager.service.DocumentManagerLocalService;
import com.sgs.portlet.document_manager.service.DocumentManagerService;
import com.sgs.portlet.document_manager.service.persistence.AttactFileDocumentPersistence;
import com.sgs.portlet.document_manager.service.persistence.DocumentManagerFinder;
import com.sgs.portlet.document_manager.service.persistence.DocumentManagerPersistence;


public abstract class DocumentManagerServiceBaseImpl extends PrincipalBean
    implements DocumentManagerService {
    @javax.annotation.Resource(name = "com.sgs.portlet.document_manager.service.DocumentManagerLocalService.impl")
    protected DocumentManagerLocalService documentManagerLocalService;
    @javax.annotation.Resource(name = "com.sgs.portlet.document_manager.service.DocumentManagerService.impl")
    protected DocumentManagerService documentManagerService;
    @javax.annotation.Resource(name = "com.sgs.portlet.document_manager.service.persistence.DocumentManagerPersistence.impl")
    protected DocumentManagerPersistence documentManagerPersistence;
    @javax.annotation.Resource(name = "com.sgs.portlet.document_manager.service.persistence.DocumentManagerFinder.impl")
    protected DocumentManagerFinder documentManagerFinder;
    @javax.annotation.Resource(name = "com.sgs.portlet.document_manager.service.AttactFileDocumentLocalService.impl")
    protected AttactFileDocumentLocalService attactFileDocumentLocalService;
    @javax.annotation.Resource(name = "com.sgs.portlet.document_manager.service.AttactFileDocumentService.impl")
    protected AttactFileDocumentService attactFileDocumentService;
    @javax.annotation.Resource(name = "com.sgs.portlet.document_manager.service.persistence.AttactFileDocumentPersistence.impl")
    protected AttactFileDocumentPersistence attactFileDocumentPersistence;

    public DocumentManagerLocalService getDocumentManagerLocalService() {
        return documentManagerLocalService;
    }

    public void setDocumentManagerLocalService(
        DocumentManagerLocalService documentManagerLocalService) {
        this.documentManagerLocalService = documentManagerLocalService;
    }

    public DocumentManagerService getDocumentManagerService() {
        return documentManagerService;
    }

    public void setDocumentManagerService(
        DocumentManagerService documentManagerService) {
        this.documentManagerService = documentManagerService;
    }

    public DocumentManagerPersistence getDocumentManagerPersistence() {
        return documentManagerPersistence;
    }

    public void setDocumentManagerPersistence(
        DocumentManagerPersistence documentManagerPersistence) {
        this.documentManagerPersistence = documentManagerPersistence;
    }

    public DocumentManagerFinder getDocumentManagerFinder() {
        return documentManagerFinder;
    }

    public void setDocumentManagerFinder(
        DocumentManagerFinder documentManagerFinder) {
        this.documentManagerFinder = documentManagerFinder;
    }

    public AttactFileDocumentLocalService getAttactFileDocumentLocalService() {
        return attactFileDocumentLocalService;
    }

    public void setAttactFileDocumentLocalService(
        AttactFileDocumentLocalService attactFileDocumentLocalService) {
        this.attactFileDocumentLocalService = attactFileDocumentLocalService;
    }

    public AttactFileDocumentService getAttactFileDocumentService() {
        return attactFileDocumentService;
    }

    public void setAttactFileDocumentService(
        AttactFileDocumentService attactFileDocumentService) {
        this.attactFileDocumentService = attactFileDocumentService;
    }

    public AttactFileDocumentPersistence getAttactFileDocumentPersistence() {
        return attactFileDocumentPersistence;
    }

    public void setAttactFileDocumentPersistence(
        AttactFileDocumentPersistence attactFileDocumentPersistence) {
        this.attactFileDocumentPersistence = attactFileDocumentPersistence;
    }
}
