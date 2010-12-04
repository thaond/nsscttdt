package com.nss.portlet.journal.service.base;

import com.liferay.counter.service.CounterLocalService;
import com.liferay.counter.service.CounterService;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.util.PortalUtil;

import com.nss.portlet.journal.model.JournalArticleResource;
import com.nss.portlet.journal.service.JournalArticleImageLocalService;
import com.nss.portlet.journal.service.JournalArticleLocalService;
import com.nss.portlet.journal.service.JournalArticleResourceLocalService;
import com.nss.portlet.journal.service.JournalArticleService;
import com.nss.portlet.journal.service.JournalContentSearchLocalService;
import com.nss.portlet.journal.service.JournalFeedLocalService;
import com.nss.portlet.journal.service.JournalFeedService;
import com.nss.portlet.journal.service.JournalStructureLocalService;
import com.nss.portlet.journal.service.JournalStructureService;
import com.nss.portlet.journal.service.JournalTemplateLocalService;
import com.nss.portlet.journal.service.JournalTemplateService;
import com.nss.portlet.journal.service.persistence.JournalArticleFinder;
import com.nss.portlet.journal.service.persistence.JournalArticleImagePersistence;
import com.nss.portlet.journal.service.persistence.JournalArticlePersistence;
import com.nss.portlet.journal.service.persistence.JournalArticleResourcePersistence;
import com.nss.portlet.journal.service.persistence.JournalContentSearchPersistence;
import com.nss.portlet.journal.service.persistence.JournalFeedFinder;
import com.nss.portlet.journal.service.persistence.JournalFeedPersistence;
import com.nss.portlet.journal.service.persistence.JournalStructureFinder;
import com.nss.portlet.journal.service.persistence.JournalStructurePersistence;
import com.nss.portlet.journal.service.persistence.JournalTemplateFinder;
import com.nss.portlet.journal.service.persistence.JournalTemplatePersistence;

import java.util.List;


public abstract class JournalArticleResourceLocalServiceBaseImpl
    implements JournalArticleResourceLocalService {
    @BeanReference(name = "com.nss.portlet.journal.service.JournalArticleLocalService.impl")
    protected JournalArticleLocalService journalArticleLocalService;
    @BeanReference(name = "com.nss.portlet.journal.service.JournalArticleService.impl")
    protected JournalArticleService journalArticleService;
    @BeanReference(name = "com.nss.portlet.journal.service.persistence.JournalArticlePersistence.impl")
    protected JournalArticlePersistence journalArticlePersistence;
    @BeanReference(name = "com.nss.portlet.journal.service.persistence.JournalArticleFinder.impl")
    protected JournalArticleFinder journalArticleFinder;
    @BeanReference(name = "com.nss.portlet.journal.service.JournalArticleImageLocalService.impl")
    protected JournalArticleImageLocalService journalArticleImageLocalService;
    @BeanReference(name = "com.nss.portlet.journal.service.persistence.JournalArticleImagePersistence.impl")
    protected JournalArticleImagePersistence journalArticleImagePersistence;
    @BeanReference(name = "com.nss.portlet.journal.service.JournalArticleResourceLocalService.impl")
    protected JournalArticleResourceLocalService journalArticleResourceLocalService;
    @BeanReference(name = "com.nss.portlet.journal.service.persistence.JournalArticleResourcePersistence.impl")
    protected JournalArticleResourcePersistence journalArticleResourcePersistence;
    @BeanReference(name = "com.nss.portlet.journal.service.JournalContentSearchLocalService.impl")
    protected JournalContentSearchLocalService journalContentSearchLocalService;
    @BeanReference(name = "com.nss.portlet.journal.service.persistence.JournalContentSearchPersistence.impl")
    protected JournalContentSearchPersistence journalContentSearchPersistence;
    @BeanReference(name = "com.nss.portlet.journal.service.JournalFeedLocalService.impl")
    protected JournalFeedLocalService journalFeedLocalService;
    @BeanReference(name = "com.nss.portlet.journal.service.JournalFeedService.impl")
    protected JournalFeedService journalFeedService;
    @BeanReference(name = "com.nss.portlet.journal.service.persistence.JournalFeedPersistence.impl")
    protected JournalFeedPersistence journalFeedPersistence;
    @BeanReference(name = "com.nss.portlet.journal.service.persistence.JournalFeedFinder.impl")
    protected JournalFeedFinder journalFeedFinder;
    @BeanReference(name = "com.nss.portlet.journal.service.JournalStructureLocalService.impl")
    protected JournalStructureLocalService journalStructureLocalService;
    @BeanReference(name = "com.nss.portlet.journal.service.JournalStructureService.impl")
    protected JournalStructureService journalStructureService;
    @BeanReference(name = "com.nss.portlet.journal.service.persistence.JournalStructurePersistence.impl")
    protected JournalStructurePersistence journalStructurePersistence;
    @BeanReference(name = "com.nss.portlet.journal.service.persistence.JournalStructureFinder.impl")
    protected JournalStructureFinder journalStructureFinder;
    @BeanReference(name = "com.nss.portlet.journal.service.JournalTemplateLocalService.impl")
    protected JournalTemplateLocalService journalTemplateLocalService;
    @BeanReference(name = "com.nss.portlet.journal.service.JournalTemplateService.impl")
    protected JournalTemplateService journalTemplateService;
    @BeanReference(name = "com.nss.portlet.journal.service.persistence.JournalTemplatePersistence.impl")
    protected JournalTemplatePersistence journalTemplatePersistence;
    @BeanReference(name = "com.nss.portlet.journal.service.persistence.JournalTemplateFinder.impl")
    protected JournalTemplateFinder journalTemplateFinder;
    @BeanReference(name = "com.liferay.counter.service.CounterLocalService.impl")
    protected CounterLocalService counterLocalService;
    @BeanReference(name = "com.liferay.counter.service.CounterService.impl")
    protected CounterService counterService;

    public JournalArticleResource addJournalArticleResource(
        JournalArticleResource journalArticleResource)
        throws SystemException {
        journalArticleResource.setNew(true);

        return journalArticleResourcePersistence.update(journalArticleResource,
            false);
    }

    public JournalArticleResource createJournalArticleResource(
        long resourcePrimKey) {
        return journalArticleResourcePersistence.create(resourcePrimKey);
    }

    public void deleteJournalArticleResource(long resourcePrimKey)
        throws PortalException, SystemException {
        journalArticleResourcePersistence.remove(resourcePrimKey);
    }

    public void deleteJournalArticleResource(
        JournalArticleResource journalArticleResource)
        throws SystemException {
        journalArticleResourcePersistence.remove(journalArticleResource);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return journalArticleResourcePersistence.findWithDynamicQuery(dynamicQuery);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery, int start,
        int end) throws SystemException {
        return journalArticleResourcePersistence.findWithDynamicQuery(dynamicQuery,
            start, end);
    }

    public JournalArticleResource getJournalArticleResource(
        long resourcePrimKey) throws PortalException, SystemException {
        return journalArticleResourcePersistence.findByPrimaryKey(resourcePrimKey);
    }

    public List<JournalArticleResource> getJournalArticleResources(int start,
        int end) throws SystemException {
        return journalArticleResourcePersistence.findAll(start, end);
    }

    public int getJournalArticleResourcesCount() throws SystemException {
        return journalArticleResourcePersistence.countAll();
    }

    public JournalArticleResource updateJournalArticleResource(
        JournalArticleResource journalArticleResource)
        throws SystemException {
        journalArticleResource.setNew(false);

        return journalArticleResourcePersistence.update(journalArticleResource,
            true);
    }

    public JournalArticleResource updateJournalArticleResource(
        JournalArticleResource journalArticleResource, boolean merge)
        throws SystemException {
        journalArticleResource.setNew(false);

        return journalArticleResourcePersistence.update(journalArticleResource,
            merge);
    }

    public JournalArticleLocalService getJournalArticleLocalService() {
        return journalArticleLocalService;
    }

    public void setJournalArticleLocalService(
        JournalArticleLocalService journalArticleLocalService) {
        this.journalArticleLocalService = journalArticleLocalService;
    }

    public JournalArticleService getJournalArticleService() {
        return journalArticleService;
    }

    public void setJournalArticleService(
        JournalArticleService journalArticleService) {
        this.journalArticleService = journalArticleService;
    }

    public JournalArticlePersistence getJournalArticlePersistence() {
        return journalArticlePersistence;
    }

    public void setJournalArticlePersistence(
        JournalArticlePersistence journalArticlePersistence) {
        this.journalArticlePersistence = journalArticlePersistence;
    }

    public JournalArticleFinder getJournalArticleFinder() {
        return journalArticleFinder;
    }

    public void setJournalArticleFinder(
        JournalArticleFinder journalArticleFinder) {
        this.journalArticleFinder = journalArticleFinder;
    }

    public JournalArticleImageLocalService getJournalArticleImageLocalService() {
        return journalArticleImageLocalService;
    }

    public void setJournalArticleImageLocalService(
        JournalArticleImageLocalService journalArticleImageLocalService) {
        this.journalArticleImageLocalService = journalArticleImageLocalService;
    }

    public JournalArticleImagePersistence getJournalArticleImagePersistence() {
        return journalArticleImagePersistence;
    }

    public void setJournalArticleImagePersistence(
        JournalArticleImagePersistence journalArticleImagePersistence) {
        this.journalArticleImagePersistence = journalArticleImagePersistence;
    }

    public JournalArticleResourceLocalService getJournalArticleResourceLocalService() {
        return journalArticleResourceLocalService;
    }

    public void setJournalArticleResourceLocalService(
        JournalArticleResourceLocalService journalArticleResourceLocalService) {
        this.journalArticleResourceLocalService = journalArticleResourceLocalService;
    }

    public JournalArticleResourcePersistence getJournalArticleResourcePersistence() {
        return journalArticleResourcePersistence;
    }

    public void setJournalArticleResourcePersistence(
        JournalArticleResourcePersistence journalArticleResourcePersistence) {
        this.journalArticleResourcePersistence = journalArticleResourcePersistence;
    }

    public JournalContentSearchLocalService getJournalContentSearchLocalService() {
        return journalContentSearchLocalService;
    }

    public void setJournalContentSearchLocalService(
        JournalContentSearchLocalService journalContentSearchLocalService) {
        this.journalContentSearchLocalService = journalContentSearchLocalService;
    }

    public JournalContentSearchPersistence getJournalContentSearchPersistence() {
        return journalContentSearchPersistence;
    }

    public void setJournalContentSearchPersistence(
        JournalContentSearchPersistence journalContentSearchPersistence) {
        this.journalContentSearchPersistence = journalContentSearchPersistence;
    }

    public JournalFeedLocalService getJournalFeedLocalService() {
        return journalFeedLocalService;
    }

    public void setJournalFeedLocalService(
        JournalFeedLocalService journalFeedLocalService) {
        this.journalFeedLocalService = journalFeedLocalService;
    }

    public JournalFeedService getJournalFeedService() {
        return journalFeedService;
    }

    public void setJournalFeedService(JournalFeedService journalFeedService) {
        this.journalFeedService = journalFeedService;
    }

    public JournalFeedPersistence getJournalFeedPersistence() {
        return journalFeedPersistence;
    }

    public void setJournalFeedPersistence(
        JournalFeedPersistence journalFeedPersistence) {
        this.journalFeedPersistence = journalFeedPersistence;
    }

    public JournalFeedFinder getJournalFeedFinder() {
        return journalFeedFinder;
    }

    public void setJournalFeedFinder(JournalFeedFinder journalFeedFinder) {
        this.journalFeedFinder = journalFeedFinder;
    }

    public JournalStructureLocalService getJournalStructureLocalService() {
        return journalStructureLocalService;
    }

    public void setJournalStructureLocalService(
        JournalStructureLocalService journalStructureLocalService) {
        this.journalStructureLocalService = journalStructureLocalService;
    }

    public JournalStructureService getJournalStructureService() {
        return journalStructureService;
    }

    public void setJournalStructureService(
        JournalStructureService journalStructureService) {
        this.journalStructureService = journalStructureService;
    }

    public JournalStructurePersistence getJournalStructurePersistence() {
        return journalStructurePersistence;
    }

    public void setJournalStructurePersistence(
        JournalStructurePersistence journalStructurePersistence) {
        this.journalStructurePersistence = journalStructurePersistence;
    }

    public JournalStructureFinder getJournalStructureFinder() {
        return journalStructureFinder;
    }

    public void setJournalStructureFinder(
        JournalStructureFinder journalStructureFinder) {
        this.journalStructureFinder = journalStructureFinder;
    }

    public JournalTemplateLocalService getJournalTemplateLocalService() {
        return journalTemplateLocalService;
    }

    public void setJournalTemplateLocalService(
        JournalTemplateLocalService journalTemplateLocalService) {
        this.journalTemplateLocalService = journalTemplateLocalService;
    }

    public JournalTemplateService getJournalTemplateService() {
        return journalTemplateService;
    }

    public void setJournalTemplateService(
        JournalTemplateService journalTemplateService) {
        this.journalTemplateService = journalTemplateService;
    }

    public JournalTemplatePersistence getJournalTemplatePersistence() {
        return journalTemplatePersistence;
    }

    public void setJournalTemplatePersistence(
        JournalTemplatePersistence journalTemplatePersistence) {
        this.journalTemplatePersistence = journalTemplatePersistence;
    }

    public JournalTemplateFinder getJournalTemplateFinder() {
        return journalTemplateFinder;
    }

    public void setJournalTemplateFinder(
        JournalTemplateFinder journalTemplateFinder) {
        this.journalTemplateFinder = journalTemplateFinder;
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
