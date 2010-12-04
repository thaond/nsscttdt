package com.nss.portlet.journal.service.base;

import com.liferay.counter.service.CounterLocalService;
import com.liferay.counter.service.CounterService;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.service.ImageLocalService;
import com.liferay.portal.service.persistence.ImagePersistence;
import com.liferay.portal.util.PortalUtil;

import com.nss.portlet.journal.model.JournalArticleImage;
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


public abstract class JournalArticleImageLocalServiceBaseImpl
    implements JournalArticleImageLocalService {
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
    @BeanReference(name = "com.liferay.portal.service.ImageLocalService.impl")
    protected ImageLocalService imageLocalService;
    @BeanReference(name = "com.liferay.portal.service.persistence.ImagePersistence.impl")
    protected ImagePersistence imagePersistence;

    public JournalArticleImage addJournalArticleImage(
        JournalArticleImage journalArticleImage) throws SystemException {
        journalArticleImage.setNew(true);

        return journalArticleImagePersistence.update(journalArticleImage, false);
    }

    public JournalArticleImage createJournalArticleImage(long articleImageId) {
        return journalArticleImagePersistence.create(articleImageId);
    }

    public void deleteJournalArticleImage(long articleImageId)
        throws PortalException, SystemException {
        journalArticleImagePersistence.remove(articleImageId);
    }

    public void deleteJournalArticleImage(
        JournalArticleImage journalArticleImage) throws SystemException {
        journalArticleImagePersistence.remove(journalArticleImage);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return journalArticleImagePersistence.findWithDynamicQuery(dynamicQuery);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery, int start,
        int end) throws SystemException {
        return journalArticleImagePersistence.findWithDynamicQuery(dynamicQuery,
            start, end);
    }

    public JournalArticleImage getJournalArticleImage(long articleImageId)
        throws PortalException, SystemException {
        return journalArticleImagePersistence.findByPrimaryKey(articleImageId);
    }

    public List<JournalArticleImage> getJournalArticleImages(int start, int end)
        throws SystemException {
        return journalArticleImagePersistence.findAll(start, end);
    }

    public int getJournalArticleImagesCount() throws SystemException {
        return journalArticleImagePersistence.countAll();
    }

    public JournalArticleImage updateJournalArticleImage(
        JournalArticleImage journalArticleImage) throws SystemException {
        journalArticleImage.setNew(false);

        return journalArticleImagePersistence.update(journalArticleImage, true);
    }

    public JournalArticleImage updateJournalArticleImage(
        JournalArticleImage journalArticleImage, boolean merge)
        throws SystemException {
        journalArticleImage.setNew(false);

        return journalArticleImagePersistence.update(journalArticleImage, merge);
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

    public ImageLocalService getImageLocalService() {
        return imageLocalService;
    }

    public void setImageLocalService(ImageLocalService imageLocalService) {
        this.imageLocalService = imageLocalService;
    }

    public ImagePersistence getImagePersistence() {
        return imagePersistence;
    }

    public void setImagePersistence(ImagePersistence imagePersistence) {
        this.imagePersistence = imagePersistence;
    }

    protected void runSQL(String sql) throws SystemException {
        try {
            PortalUtil.runSQL(sql);
        } catch (Exception e) {
            throw new SystemException(e);
        }
    }
}
