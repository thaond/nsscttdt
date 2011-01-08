package com.sgs.portlet.document.send.service.base;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;

import com.sgs.portlet.document.send.model.PmlEdmDocumentSend;
import com.sgs.portlet.document.send.service.PmlEdmAnswerDetailLocalService;
import com.sgs.portlet.document.send.service.PmlEdmAnswerDetailService;
import com.sgs.portlet.document.send.service.PmlEdmBookDocumentSendLocalService;
import com.sgs.portlet.document.send.service.PmlEdmBookDocumentSendService;
import com.sgs.portlet.document.send.service.PmlEdmCadreLocalService;
import com.sgs.portlet.document.send.service.PmlEdmCadreService;
import com.sgs.portlet.document.send.service.PmlEdmDocumentSendLocalService;
import com.sgs.portlet.document.send.service.PmlEdmDocumentSendService;
import com.sgs.portlet.document.send.service.PmlEdmWriteDocumentSendLocalService;
import com.sgs.portlet.document.send.service.PmlEdmWriteDocumentSendService;
import com.sgs.portlet.document.send.service.persistence.PmlEdmAnswerDetailPersistence;
import com.sgs.portlet.document.send.service.persistence.PmlEdmBookDocumentSendFinder;
import com.sgs.portlet.document.send.service.persistence.PmlEdmBookDocumentSendPersistence;
import com.sgs.portlet.document.send.service.persistence.PmlEdmCadrePersistence;
import com.sgs.portlet.document.send.service.persistence.PmlEdmDocumentSendFinder;
import com.sgs.portlet.document.send.service.persistence.PmlEdmDocumentSendPersistence;
import com.sgs.portlet.document.send.service.persistence.PmlEdmWriteDocumentSendPersistence;

import java.util.List;


public abstract class PmlEdmDocumentSendLocalServiceBaseImpl
    implements PmlEdmDocumentSendLocalService {
    @javax.annotation.Resource(name = "com.sgs.portlet.document.send.service.PmlEdmBookDocumentSendLocalService.impl")
    protected PmlEdmBookDocumentSendLocalService pmlEdmBookDocumentSendLocalService;
    @javax.annotation.Resource(name = "com.sgs.portlet.document.send.service.PmlEdmBookDocumentSendService.impl")
    protected PmlEdmBookDocumentSendService pmlEdmBookDocumentSendService;
    @javax.annotation.Resource(name = "com.sgs.portlet.document.send.service.persistence.PmlEdmBookDocumentSendPersistence.impl")
    protected PmlEdmBookDocumentSendPersistence pmlEdmBookDocumentSendPersistence;
    @javax.annotation.Resource(name = "com.sgs.portlet.document.send.service.persistence.PmlEdmBookDocumentSendFinder.impl")
    protected PmlEdmBookDocumentSendFinder pmlEdmBookDocumentSendFinder;
    @javax.annotation.Resource(name = "com.sgs.portlet.document.send.service.PmlEdmCadreLocalService.impl")
    protected PmlEdmCadreLocalService pmlEdmCadreLocalService;
    @javax.annotation.Resource(name = "com.sgs.portlet.document.send.service.PmlEdmCadreService.impl")
    protected PmlEdmCadreService pmlEdmCadreService;
    @javax.annotation.Resource(name = "com.sgs.portlet.document.send.service.persistence.PmlEdmCadrePersistence.impl")
    protected PmlEdmCadrePersistence pmlEdmCadrePersistence;
    @javax.annotation.Resource(name = "com.sgs.portlet.document.send.service.PmlEdmWriteDocumentSendLocalService.impl")
    protected PmlEdmWriteDocumentSendLocalService pmlEdmWriteDocumentSendLocalService;
    @javax.annotation.Resource(name = "com.sgs.portlet.document.send.service.PmlEdmWriteDocumentSendService.impl")
    protected PmlEdmWriteDocumentSendService pmlEdmWriteDocumentSendService;
    @javax.annotation.Resource(name = "com.sgs.portlet.document.send.service.persistence.PmlEdmWriteDocumentSendPersistence.impl")
    protected PmlEdmWriteDocumentSendPersistence pmlEdmWriteDocumentSendPersistence;
    @javax.annotation.Resource(name = "com.sgs.portlet.document.send.service.PmlEdmDocumentSendLocalService.impl")
    protected PmlEdmDocumentSendLocalService pmlEdmDocumentSendLocalService;
    @javax.annotation.Resource(name = "com.sgs.portlet.document.send.service.PmlEdmDocumentSendService.impl")
    protected PmlEdmDocumentSendService pmlEdmDocumentSendService;
    @javax.annotation.Resource(name = "com.sgs.portlet.document.send.service.persistence.PmlEdmDocumentSendPersistence.impl")
    protected PmlEdmDocumentSendPersistence pmlEdmDocumentSendPersistence;
    @javax.annotation.Resource(name = "com.sgs.portlet.document.send.service.persistence.PmlEdmDocumentSendFinder.impl")
    protected PmlEdmDocumentSendFinder pmlEdmDocumentSendFinder;
    @javax.annotation.Resource(name = "com.sgs.portlet.document.send.service.PmlEdmAnswerDetailLocalService.impl")
    protected PmlEdmAnswerDetailLocalService pmlEdmAnswerDetailLocalService;
    @javax.annotation.Resource(name = "com.sgs.portlet.document.send.service.PmlEdmAnswerDetailService.impl")
    protected PmlEdmAnswerDetailService pmlEdmAnswerDetailService;
    @javax.annotation.Resource(name = "com.sgs.portlet.document.send.service.persistence.PmlEdmAnswerDetailPersistence.impl")
    protected PmlEdmAnswerDetailPersistence pmlEdmAnswerDetailPersistence;

    public PmlEdmDocumentSend addPmlEdmDocumentSend(
        PmlEdmDocumentSend pmlEdmDocumentSend) throws SystemException {
        pmlEdmDocumentSend.setNew(true);

        return pmlEdmDocumentSendPersistence.update(pmlEdmDocumentSend, false);
    }

    public PmlEdmDocumentSend createPmlEdmDocumentSend(long documentSendId) {
        return pmlEdmDocumentSendPersistence.create(documentSendId);
    }

    public void deletePmlEdmDocumentSend(long documentSendId)
        throws PortalException, SystemException {
        pmlEdmDocumentSendPersistence.remove(documentSendId);
    }

    public void deletePmlEdmDocumentSend(PmlEdmDocumentSend pmlEdmDocumentSend)
        throws SystemException {
        pmlEdmDocumentSendPersistence.remove(pmlEdmDocumentSend);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return pmlEdmDocumentSendPersistence.findWithDynamicQuery(dynamicQuery);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery, int start,
        int end) throws SystemException {
        return pmlEdmDocumentSendPersistence.findWithDynamicQuery(dynamicQuery,
            start, end);
    }

    public PmlEdmDocumentSend getPmlEdmDocumentSend(long documentSendId)
        throws PortalException, SystemException {
        return pmlEdmDocumentSendPersistence.findByPrimaryKey(documentSendId);
    }

    public List<PmlEdmDocumentSend> getPmlEdmDocumentSends(int start, int end)
        throws SystemException {
        return pmlEdmDocumentSendPersistence.findAll(start, end);
    }

    public int getPmlEdmDocumentSendsCount() throws SystemException {
        return pmlEdmDocumentSendPersistence.countAll();
    }

    public PmlEdmDocumentSend updatePmlEdmDocumentSend(
        PmlEdmDocumentSend pmlEdmDocumentSend) throws SystemException {
        pmlEdmDocumentSend.setNew(false);

        return pmlEdmDocumentSendPersistence.update(pmlEdmDocumentSend, true);
    }

    public PmlEdmBookDocumentSendLocalService getPmlEdmBookDocumentSendLocalService() {
        return pmlEdmBookDocumentSendLocalService;
    }

    public void setPmlEdmBookDocumentSendLocalService(
        PmlEdmBookDocumentSendLocalService pmlEdmBookDocumentSendLocalService) {
        this.pmlEdmBookDocumentSendLocalService = pmlEdmBookDocumentSendLocalService;
    }

    public PmlEdmBookDocumentSendService getPmlEdmBookDocumentSendService() {
        return pmlEdmBookDocumentSendService;
    }

    public void setPmlEdmBookDocumentSendService(
        PmlEdmBookDocumentSendService pmlEdmBookDocumentSendService) {
        this.pmlEdmBookDocumentSendService = pmlEdmBookDocumentSendService;
    }

    public PmlEdmBookDocumentSendPersistence getPmlEdmBookDocumentSendPersistence() {
        return pmlEdmBookDocumentSendPersistence;
    }

    public void setPmlEdmBookDocumentSendPersistence(
        PmlEdmBookDocumentSendPersistence pmlEdmBookDocumentSendPersistence) {
        this.pmlEdmBookDocumentSendPersistence = pmlEdmBookDocumentSendPersistence;
    }

    public PmlEdmBookDocumentSendFinder getPmlEdmBookDocumentSendFinder() {
        return pmlEdmBookDocumentSendFinder;
    }

    public void setPmlEdmBookDocumentSendFinder(
        PmlEdmBookDocumentSendFinder pmlEdmBookDocumentSendFinder) {
        this.pmlEdmBookDocumentSendFinder = pmlEdmBookDocumentSendFinder;
    }

    public PmlEdmCadreLocalService getPmlEdmCadreLocalService() {
        return pmlEdmCadreLocalService;
    }

    public void setPmlEdmCadreLocalService(
        PmlEdmCadreLocalService pmlEdmCadreLocalService) {
        this.pmlEdmCadreLocalService = pmlEdmCadreLocalService;
    }

    public PmlEdmCadreService getPmlEdmCadreService() {
        return pmlEdmCadreService;
    }

    public void setPmlEdmCadreService(PmlEdmCadreService pmlEdmCadreService) {
        this.pmlEdmCadreService = pmlEdmCadreService;
    }

    public PmlEdmCadrePersistence getPmlEdmCadrePersistence() {
        return pmlEdmCadrePersistence;
    }

    public void setPmlEdmCadrePersistence(
        PmlEdmCadrePersistence pmlEdmCadrePersistence) {
        this.pmlEdmCadrePersistence = pmlEdmCadrePersistence;
    }

    public PmlEdmWriteDocumentSendLocalService getPmlEdmWriteDocumentSendLocalService() {
        return pmlEdmWriteDocumentSendLocalService;
    }

    public void setPmlEdmWriteDocumentSendLocalService(
        PmlEdmWriteDocumentSendLocalService pmlEdmWriteDocumentSendLocalService) {
        this.pmlEdmWriteDocumentSendLocalService = pmlEdmWriteDocumentSendLocalService;
    }

    public PmlEdmWriteDocumentSendService getPmlEdmWriteDocumentSendService() {
        return pmlEdmWriteDocumentSendService;
    }

    public void setPmlEdmWriteDocumentSendService(
        PmlEdmWriteDocumentSendService pmlEdmWriteDocumentSendService) {
        this.pmlEdmWriteDocumentSendService = pmlEdmWriteDocumentSendService;
    }

    public PmlEdmWriteDocumentSendPersistence getPmlEdmWriteDocumentSendPersistence() {
        return pmlEdmWriteDocumentSendPersistence;
    }

    public void setPmlEdmWriteDocumentSendPersistence(
        PmlEdmWriteDocumentSendPersistence pmlEdmWriteDocumentSendPersistence) {
        this.pmlEdmWriteDocumentSendPersistence = pmlEdmWriteDocumentSendPersistence;
    }

    public PmlEdmDocumentSendLocalService getPmlEdmDocumentSendLocalService() {
        return pmlEdmDocumentSendLocalService;
    }

    public void setPmlEdmDocumentSendLocalService(
        PmlEdmDocumentSendLocalService pmlEdmDocumentSendLocalService) {
        this.pmlEdmDocumentSendLocalService = pmlEdmDocumentSendLocalService;
    }

    public PmlEdmDocumentSendService getPmlEdmDocumentSendService() {
        return pmlEdmDocumentSendService;
    }

    public void setPmlEdmDocumentSendService(
        PmlEdmDocumentSendService pmlEdmDocumentSendService) {
        this.pmlEdmDocumentSendService = pmlEdmDocumentSendService;
    }

    public PmlEdmDocumentSendPersistence getPmlEdmDocumentSendPersistence() {
        return pmlEdmDocumentSendPersistence;
    }

    public void setPmlEdmDocumentSendPersistence(
        PmlEdmDocumentSendPersistence pmlEdmDocumentSendPersistence) {
        this.pmlEdmDocumentSendPersistence = pmlEdmDocumentSendPersistence;
    }

    public PmlEdmDocumentSendFinder getPmlEdmDocumentSendFinder() {
        return pmlEdmDocumentSendFinder;
    }

    public void setPmlEdmDocumentSendFinder(
        PmlEdmDocumentSendFinder pmlEdmDocumentSendFinder) {
        this.pmlEdmDocumentSendFinder = pmlEdmDocumentSendFinder;
    }

    public PmlEdmAnswerDetailLocalService getPmlEdmAnswerDetailLocalService() {
        return pmlEdmAnswerDetailLocalService;
    }

    public void setPmlEdmAnswerDetailLocalService(
        PmlEdmAnswerDetailLocalService pmlEdmAnswerDetailLocalService) {
        this.pmlEdmAnswerDetailLocalService = pmlEdmAnswerDetailLocalService;
    }

    public PmlEdmAnswerDetailService getPmlEdmAnswerDetailService() {
        return pmlEdmAnswerDetailService;
    }

    public void setPmlEdmAnswerDetailService(
        PmlEdmAnswerDetailService pmlEdmAnswerDetailService) {
        this.pmlEdmAnswerDetailService = pmlEdmAnswerDetailService;
    }

    public PmlEdmAnswerDetailPersistence getPmlEdmAnswerDetailPersistence() {
        return pmlEdmAnswerDetailPersistence;
    }

    public void setPmlEdmAnswerDetailPersistence(
        PmlEdmAnswerDetailPersistence pmlEdmAnswerDetailPersistence) {
        this.pmlEdmAnswerDetailPersistence = pmlEdmAnswerDetailPersistence;
    }
}
