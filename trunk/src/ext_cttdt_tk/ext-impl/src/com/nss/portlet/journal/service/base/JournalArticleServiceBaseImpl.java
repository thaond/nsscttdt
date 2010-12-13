package com.nss.portlet.journal.service.base;

import com.liferay.counter.service.CounterLocalService;
import com.liferay.counter.service.CounterService;

import com.liferay.mail.service.MailService;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.service.CompanyLocalService;
import com.liferay.portal.service.CompanyService;
import com.liferay.portal.service.ImageLocalService;
import com.liferay.portal.service.PortletPreferencesLocalService;
import com.liferay.portal.service.PortletPreferencesService;
import com.liferay.portal.service.ResourceLocalService;
import com.liferay.portal.service.ResourceService;
import com.liferay.portal.service.UserLocalService;
import com.liferay.portal.service.UserService;
import com.liferay.portal.service.base.PrincipalBean;
import com.liferay.portal.service.persistence.CompanyPersistence;
import com.liferay.portal.service.persistence.ImagePersistence;
import com.liferay.portal.service.persistence.PortletPreferencesPersistence;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.service.ExpandoValueLocalService;
import com.liferay.portlet.expando.service.ExpandoValueService;
import com.liferay.portlet.expando.service.persistence.ExpandoValuePersistence;
import com.liferay.portlet.messageboards.service.MBMessageLocalService;
import com.liferay.portlet.messageboards.service.MBMessageService;
import com.liferay.portlet.messageboards.service.persistence.MBMessageFinder;
import com.liferay.portlet.messageboards.service.persistence.MBMessagePersistence;
import com.liferay.portlet.ratings.service.RatingsStatsLocalService;
import com.liferay.portlet.ratings.service.persistence.RatingsStatsPersistence;
import com.liferay.portlet.tags.service.TagsAssetLocalService;
import com.liferay.portlet.tags.service.TagsAssetService;
import com.liferay.portlet.tags.service.TagsEntryLocalService;
import com.liferay.portlet.tags.service.TagsEntryService;
import com.liferay.portlet.tags.service.persistence.TagsAssetPersistence;
import com.liferay.portlet.tags.service.persistence.TagsEntryPersistence;

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


public abstract class JournalArticleServiceBaseImpl extends PrincipalBean
    implements JournalArticleService {
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
    @BeanReference(name = "com.liferay.mail.service.MailService.impl")
    protected MailService mailService;
    @BeanReference(name = "com.liferay.portal.service.CompanyLocalService.impl")
    protected CompanyLocalService companyLocalService;
    @BeanReference(name = "com.liferay.portal.service.CompanyService.impl")
    protected CompanyService companyService;
    @BeanReference(name = "com.liferay.portal.service.persistence.CompanyPersistence.impl")
    protected CompanyPersistence companyPersistence;
    @BeanReference(name = "com.liferay.portal.service.ImageLocalService.impl")
    protected ImageLocalService imageLocalService;
    @BeanReference(name = "com.liferay.portal.service.persistence.ImagePersistence.impl")
    protected ImagePersistence imagePersistence;
    @BeanReference(name = "com.liferay.portal.service.PortletPreferencesLocalService.impl")
    protected PortletPreferencesLocalService portletPreferencesLocalService;
    @BeanReference(name = "com.liferay.portal.service.PortletPreferencesService.impl")
    protected PortletPreferencesService portletPreferencesService;
    @BeanReference(name = "com.liferay.portal.service.persistence.PortletPreferencesPersistence.impl")
    protected PortletPreferencesPersistence portletPreferencesPersistence;
    @BeanReference(name = "com.liferay.portal.service.ResourceLocalService.impl")
    protected ResourceLocalService resourceLocalService;
    @BeanReference(name = "com.liferay.portal.service.ResourceService.impl")
    protected ResourceService resourceService;
    @BeanReference(name = "com.liferay.portal.service.persistence.ResourcePersistence.impl")
    protected ResourcePersistence resourcePersistence;
    @BeanReference(name = "com.liferay.portal.service.UserLocalService.impl")
    protected UserLocalService userLocalService;
    @BeanReference(name = "com.liferay.portal.service.UserService.impl")
    protected UserService userService;
    @BeanReference(name = "com.liferay.portal.service.persistence.UserPersistence.impl")
    protected UserPersistence userPersistence;
    @BeanReference(name = "com.liferay.portlet.expando.service.ExpandoValueLocalService.impl")
    protected ExpandoValueLocalService expandoValueLocalService;
    @BeanReference(name = "com.liferay.portlet.expando.service.ExpandoValueService.impl")
    protected ExpandoValueService expandoValueService;
    @BeanReference(name = "com.liferay.portlet.expando.service.persistence.ExpandoValuePersistence.impl")
    protected ExpandoValuePersistence expandoValuePersistence;
    @BeanReference(name = "com.liferay.portlet.messageboards.service.MBMessageLocalService.impl")
    protected MBMessageLocalService mbMessageLocalService;
    @BeanReference(name = "com.liferay.portlet.messageboards.service.MBMessageService.impl")
    protected MBMessageService mbMessageService;
    @BeanReference(name = "com.liferay.portlet.messageboards.service.persistence.MBMessagePersistence.impl")
    protected MBMessagePersistence mbMessagePersistence;
    @BeanReference(name = "com.liferay.portlet.messageboards.service.persistence.MBMessageFinder.impl")
    protected MBMessageFinder mbMessageFinder;
    @BeanReference(name = "com.liferay.portlet.ratings.service.RatingsStatsLocalService.impl")
    protected RatingsStatsLocalService ratingsStatsLocalService;
    @BeanReference(name = "com.liferay.portlet.ratings.service.persistence.RatingsStatsPersistence.impl")
    protected RatingsStatsPersistence ratingsStatsPersistence;
    @BeanReference(name = "com.liferay.portlet.tags.service.TagsAssetLocalService.impl")
    protected TagsAssetLocalService tagsAssetLocalService;
    @BeanReference(name = "com.liferay.portlet.tags.service.TagsAssetService.impl")
    protected TagsAssetService tagsAssetService;
    @BeanReference(name = "com.liferay.portlet.tags.service.persistence.TagsAssetPersistence.impl")
    protected TagsAssetPersistence tagsAssetPersistence;
    @BeanReference(name = "com.liferay.portlet.tags.service.TagsEntryLocalService.impl")
    protected TagsEntryLocalService tagsEntryLocalService;
    @BeanReference(name = "com.liferay.portlet.tags.service.TagsEntryService.impl")
    protected TagsEntryService tagsEntryService;
    @BeanReference(name = "com.liferay.portlet.tags.service.persistence.TagsEntryPersistence.impl")
    protected TagsEntryPersistence tagsEntryPersistence;

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

    public MailService getMailService() {
        return mailService;
    }

    public void setMailService(MailService mailService) {
        this.mailService = mailService;
    }

    public CompanyLocalService getCompanyLocalService() {
        return companyLocalService;
    }

    public void setCompanyLocalService(CompanyLocalService companyLocalService) {
        this.companyLocalService = companyLocalService;
    }

    public CompanyService getCompanyService() {
        return companyService;
    }

    public void setCompanyService(CompanyService companyService) {
        this.companyService = companyService;
    }

    public CompanyPersistence getCompanyPersistence() {
        return companyPersistence;
    }

    public void setCompanyPersistence(CompanyPersistence companyPersistence) {
        this.companyPersistence = companyPersistence;
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

    public PortletPreferencesLocalService getPortletPreferencesLocalService() {
        return portletPreferencesLocalService;
    }

    public void setPortletPreferencesLocalService(
        PortletPreferencesLocalService portletPreferencesLocalService) {
        this.portletPreferencesLocalService = portletPreferencesLocalService;
    }

    public PortletPreferencesService getPortletPreferencesService() {
        return portletPreferencesService;
    }

    public void setPortletPreferencesService(
        PortletPreferencesService portletPreferencesService) {
        this.portletPreferencesService = portletPreferencesService;
    }

    public PortletPreferencesPersistence getPortletPreferencesPersistence() {
        return portletPreferencesPersistence;
    }

    public void setPortletPreferencesPersistence(
        PortletPreferencesPersistence portletPreferencesPersistence) {
        this.portletPreferencesPersistence = portletPreferencesPersistence;
    }

    public ResourceLocalService getResourceLocalService() {
        return resourceLocalService;
    }

    public void setResourceLocalService(
        ResourceLocalService resourceLocalService) {
        this.resourceLocalService = resourceLocalService;
    }

    public ResourceService getResourceService() {
        return resourceService;
    }

    public void setResourceService(ResourceService resourceService) {
        this.resourceService = resourceService;
    }

    public ResourcePersistence getResourcePersistence() {
        return resourcePersistence;
    }

    public void setResourcePersistence(ResourcePersistence resourcePersistence) {
        this.resourcePersistence = resourcePersistence;
    }

    public UserLocalService getUserLocalService() {
        return userLocalService;
    }

    public void setUserLocalService(UserLocalService userLocalService) {
        this.userLocalService = userLocalService;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public UserPersistence getUserPersistence() {
        return userPersistence;
    }

    public void setUserPersistence(UserPersistence userPersistence) {
        this.userPersistence = userPersistence;
    }

    public ExpandoValueLocalService getExpandoValueLocalService() {
        return expandoValueLocalService;
    }

    public void setExpandoValueLocalService(
        ExpandoValueLocalService expandoValueLocalService) {
        this.expandoValueLocalService = expandoValueLocalService;
    }

    public ExpandoValueService getExpandoValueService() {
        return expandoValueService;
    }

    public void setExpandoValueService(ExpandoValueService expandoValueService) {
        this.expandoValueService = expandoValueService;
    }

    public ExpandoValuePersistence getExpandoValuePersistence() {
        return expandoValuePersistence;
    }

    public void setExpandoValuePersistence(
        ExpandoValuePersistence expandoValuePersistence) {
        this.expandoValuePersistence = expandoValuePersistence;
    }

    public MBMessageLocalService getMBMessageLocalService() {
        return mbMessageLocalService;
    }

    public void setMBMessageLocalService(
        MBMessageLocalService mbMessageLocalService) {
        this.mbMessageLocalService = mbMessageLocalService;
    }

    public MBMessageService getMBMessageService() {
        return mbMessageService;
    }

    public void setMBMessageService(MBMessageService mbMessageService) {
        this.mbMessageService = mbMessageService;
    }

    public MBMessagePersistence getMBMessagePersistence() {
        return mbMessagePersistence;
    }

    public void setMBMessagePersistence(
        MBMessagePersistence mbMessagePersistence) {
        this.mbMessagePersistence = mbMessagePersistence;
    }

    public MBMessageFinder getMBMessageFinder() {
        return mbMessageFinder;
    }

    public void setMBMessageFinder(MBMessageFinder mbMessageFinder) {
        this.mbMessageFinder = mbMessageFinder;
    }

    public RatingsStatsLocalService getRatingsStatsLocalService() {
        return ratingsStatsLocalService;
    }

    public void setRatingsStatsLocalService(
        RatingsStatsLocalService ratingsStatsLocalService) {
        this.ratingsStatsLocalService = ratingsStatsLocalService;
    }

    public RatingsStatsPersistence getRatingsStatsPersistence() {
        return ratingsStatsPersistence;
    }

    public void setRatingsStatsPersistence(
        RatingsStatsPersistence ratingsStatsPersistence) {
        this.ratingsStatsPersistence = ratingsStatsPersistence;
    }

    public TagsAssetLocalService getTagsAssetLocalService() {
        return tagsAssetLocalService;
    }

    public void setTagsAssetLocalService(
        TagsAssetLocalService tagsAssetLocalService) {
        this.tagsAssetLocalService = tagsAssetLocalService;
    }

    public TagsAssetService getTagsAssetService() {
        return tagsAssetService;
    }

    public void setTagsAssetService(TagsAssetService tagsAssetService) {
        this.tagsAssetService = tagsAssetService;
    }

    public TagsAssetPersistence getTagsAssetPersistence() {
        return tagsAssetPersistence;
    }

    public void setTagsAssetPersistence(
        TagsAssetPersistence tagsAssetPersistence) {
        this.tagsAssetPersistence = tagsAssetPersistence;
    }

    public TagsEntryLocalService getTagsEntryLocalService() {
        return tagsEntryLocalService;
    }

    public void setTagsEntryLocalService(
        TagsEntryLocalService tagsEntryLocalService) {
        this.tagsEntryLocalService = tagsEntryLocalService;
    }

    public TagsEntryService getTagsEntryService() {
        return tagsEntryService;
    }

    public void setTagsEntryService(TagsEntryService tagsEntryService) {
        this.tagsEntryService = tagsEntryService;
    }

    public TagsEntryPersistence getTagsEntryPersistence() {
        return tagsEntryPersistence;
    }

    public void setTagsEntryPersistence(
        TagsEntryPersistence tagsEntryPersistence) {
        this.tagsEntryPersistence = tagsEntryPersistence;
    }

    protected void runSQL(String sql) throws SystemException {
        try {
            PortalUtil.runSQL(sql);
        } catch (Exception e) {
            throw new SystemException(e);
        }
    }
}
