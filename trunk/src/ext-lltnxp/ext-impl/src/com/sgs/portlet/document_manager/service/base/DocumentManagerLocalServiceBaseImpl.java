package com.sgs.portlet.document_manager.service.base;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;

import com.sgs.portlet.document_manager.model.DocumentManager;
import com.sgs.portlet.document_manager.service.AttactFileDocumentLocalService;
import com.sgs.portlet.document_manager.service.AttactFileDocumentService;
import com.sgs.portlet.document_manager.service.DocumentManagerLocalService;
import com.sgs.portlet.document_manager.service.DocumentManagerService;
import com.sgs.portlet.document_manager.service.persistence.AttactFileDocumentPersistence;
import com.sgs.portlet.document_manager.service.persistence.DocumentManagerFinder;
import com.sgs.portlet.document_manager.service.persistence.DocumentManagerPersistence;

import java.util.List;


public abstract class DocumentManagerLocalServiceBaseImpl
    implements DocumentManagerLocalService {
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

    public DocumentManager addDocumentManager(DocumentManager documentManager)
        throws SystemException {
        documentManager.setNew(true);

        return documentManagerPersistence.update(documentManager, false);
    }

    public DocumentManager createDocumentManager(long documentManagerId) {
        return documentManagerPersistence.create(documentManagerId);
    }

    public void deleteDocumentManager(long documentManagerId)
        throws PortalException, SystemException {
        documentManagerPersistence.remove(documentManagerId);
    }

    public void deleteDocumentManager(DocumentManager documentManager)
        throws SystemException {
        documentManagerPersistence.remove(documentManager);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return documentManagerPersistence.findWithDynamicQuery(dynamicQuery);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery, int start,
        int end) throws SystemException {
        return documentManagerPersistence.findWithDynamicQuery(dynamicQuery,
            start, end);
    }

    public DocumentManager getDocumentManager(long documentManagerId)
        throws PortalException, SystemException {
        return documentManagerPersistence.findByPrimaryKey(documentManagerId);
    }

    public List<DocumentManager> getDocumentManagers(int start, int end)
        throws SystemException {
        return documentManagerPersistence.findAll(start, end);
    }

    public int getDocumentManagersCount() throws SystemException {
        return documentManagerPersistence.countAll();
    }

    public DocumentManager updateDocumentManager(
        DocumentManager documentManager) throws SystemException {
        documentManager.setNew(false);

        return documentManagerPersistence.update(documentManager, true);
    }

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
