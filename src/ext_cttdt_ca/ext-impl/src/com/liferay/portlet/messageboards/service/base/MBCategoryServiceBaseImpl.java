package com.liferay.portlet.messageboards.service.base;

import com.liferay.counter.service.CounterLocalService;
import com.liferay.counter.service.CounterService;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.service.ResourceLocalService;
import com.liferay.portal.service.ResourceService;
import com.liferay.portal.service.SubscriptionLocalService;
import com.liferay.portal.service.UserLocalService;
import com.liferay.portal.service.UserService;
import com.liferay.portal.service.base.PrincipalBean;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.SubscriptionPersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.messageboards.service.MBBanLocalService;
import com.liferay.portlet.messageboards.service.MBBanService;
import com.liferay.portlet.messageboards.service.MBCategoryLocalService;
import com.liferay.portlet.messageboards.service.MBCategoryService;
import com.liferay.portlet.messageboards.service.MBDiscussionLocalService;
import com.liferay.portlet.messageboards.service.MBMailingListLocalService;
import com.liferay.portlet.messageboards.service.MBMessageFlagLocalService;
import com.liferay.portlet.messageboards.service.MBMessageFlagService;
import com.liferay.portlet.messageboards.service.MBMessageLocalService;
import com.liferay.portlet.messageboards.service.MBMessageService;
import com.liferay.portlet.messageboards.service.MBStatsUserLocalService;
import com.liferay.portlet.messageboards.service.MBThreadLocalService;
import com.liferay.portlet.messageboards.service.MBThreadService;
import com.liferay.portlet.messageboards.service.persistence.MBBanPersistence;
import com.liferay.portlet.messageboards.service.persistence.MBCategoryFinder;
import com.liferay.portlet.messageboards.service.persistence.MBCategoryPersistence;
import com.liferay.portlet.messageboards.service.persistence.MBDiscussionPersistence;
import com.liferay.portlet.messageboards.service.persistence.MBMailingListPersistence;
import com.liferay.portlet.messageboards.service.persistence.MBMessageFinder;
import com.liferay.portlet.messageboards.service.persistence.MBMessageFlagPersistence;
import com.liferay.portlet.messageboards.service.persistence.MBMessagePersistence;
import com.liferay.portlet.messageboards.service.persistence.MBStatsUserPersistence;
import com.liferay.portlet.messageboards.service.persistence.MBThreadFinder;
import com.liferay.portlet.messageboards.service.persistence.MBThreadPersistence;
import com.liferay.portlet.tags.service.TagsEntryLocalService;
import com.liferay.portlet.tags.service.TagsEntryService;
import com.liferay.portlet.tags.service.persistence.TagsEntryPersistence;


public abstract class MBCategoryServiceBaseImpl extends PrincipalBean
    implements MBCategoryService {
    @BeanReference(name = "com.liferay.portlet.messageboards.service.MBCategoryLocalService.impl")
    protected MBCategoryLocalService mbCategoryLocalService;
    @BeanReference(name = "com.liferay.portlet.messageboards.service.MBCategoryService.impl")
    protected MBCategoryService mbCategoryService;
    @BeanReference(name = "com.liferay.portlet.messageboards.service.persistence.MBCategoryPersistence.impl")
    protected MBCategoryPersistence mbCategoryPersistence;
    @BeanReference(name = "com.liferay.portlet.messageboards.service.persistence.MBCategoryFinder.impl")
    protected MBCategoryFinder mbCategoryFinder;
    @BeanReference(name = "com.liferay.portlet.messageboards.service.MBMailingListLocalService.impl")
    protected MBMailingListLocalService mbMailingListLocalService;
    @BeanReference(name = "com.liferay.portlet.messageboards.service.persistence.MBMailingListPersistence.impl")
    protected MBMailingListPersistence mbMailingListPersistence;
    @BeanReference(name = "com.liferay.portlet.messageboards.service.MBMessageLocalService.impl")
    protected MBMessageLocalService mbMessageLocalService;
    @BeanReference(name = "com.liferay.portlet.messageboards.service.MBMessageService.impl")
    protected MBMessageService mbMessageService;
    @BeanReference(name = "com.liferay.portlet.messageboards.service.persistence.MBMessagePersistence.impl")
    protected MBMessagePersistence mbMessagePersistence;
    @BeanReference(name = "com.liferay.portlet.messageboards.service.persistence.MBMessageFinder.impl")
    protected MBMessageFinder mbMessageFinder;
    @BeanReference(name = "com.liferay.portlet.messageboards.service.MBThreadLocalService.impl")
    protected MBThreadLocalService mbThreadLocalService;
    @BeanReference(name = "com.liferay.portlet.messageboards.service.MBThreadService.impl")
    protected MBThreadService mbThreadService;
    @BeanReference(name = "com.liferay.portlet.messageboards.service.persistence.MBThreadPersistence.impl")
    protected MBThreadPersistence mbThreadPersistence;
    @BeanReference(name = "com.liferay.portlet.messageboards.service.persistence.MBThreadFinder.impl")
    protected MBThreadFinder mbThreadFinder;
    @BeanReference(name = "com.liferay.portlet.messageboards.service.MBBanLocalService.impl")
    protected MBBanLocalService mbBanLocalService;
    @BeanReference(name = "com.liferay.portlet.messageboards.service.MBBanService.impl")
    protected MBBanService mbBanService;
    @BeanReference(name = "com.liferay.portlet.messageboards.service.persistence.MBBanPersistence.impl")
    protected MBBanPersistence mbBanPersistence;
    @BeanReference(name = "com.liferay.portlet.messageboards.service.MBDiscussionLocalService.impl")
    protected MBDiscussionLocalService mbDiscussionLocalService;
    @BeanReference(name = "com.liferay.portlet.messageboards.service.persistence.MBDiscussionPersistence.impl")
    protected MBDiscussionPersistence mbDiscussionPersistence;
    @BeanReference(name = "com.liferay.portlet.messageboards.service.MBMessageFlagLocalService.impl")
    protected MBMessageFlagLocalService mbMessageFlagLocalService;
    @BeanReference(name = "com.liferay.portlet.messageboards.service.MBMessageFlagService.impl")
    protected MBMessageFlagService mbMessageFlagService;
    @BeanReference(name = "com.liferay.portlet.messageboards.service.persistence.MBMessageFlagPersistence.impl")
    protected MBMessageFlagPersistence mbMessageFlagPersistence;
    @BeanReference(name = "com.liferay.portlet.messageboards.service.MBStatsUserLocalService.impl")
    protected MBStatsUserLocalService mbStatsUserLocalService;
    @BeanReference(name = "com.liferay.portlet.messageboards.service.persistence.MBStatsUserPersistence.impl")
    protected MBStatsUserPersistence mbStatsUserPersistence;
    @BeanReference(name = "com.liferay.counter.service.CounterLocalService.impl")
    protected CounterLocalService counterLocalService;
    @BeanReference(name = "com.liferay.counter.service.CounterService.impl")
    protected CounterService counterService;
    @BeanReference(name = "com.liferay.portal.service.ResourceLocalService.impl")
    protected ResourceLocalService resourceLocalService;
    @BeanReference(name = "com.liferay.portal.service.ResourceService.impl")
    protected ResourceService resourceService;
    @BeanReference(name = "com.liferay.portal.service.persistence.ResourcePersistence.impl")
    protected ResourcePersistence resourcePersistence;
    @BeanReference(name = "com.liferay.portal.service.SubscriptionLocalService.impl")
    protected SubscriptionLocalService subscriptionLocalService;
    @BeanReference(name = "com.liferay.portal.service.persistence.SubscriptionPersistence.impl")
    protected SubscriptionPersistence subscriptionPersistence;
    @BeanReference(name = "com.liferay.portal.service.UserLocalService.impl")
    protected UserLocalService userLocalService;
    @BeanReference(name = "com.liferay.portal.service.UserService.impl")
    protected UserService userService;
    @BeanReference(name = "com.liferay.portal.service.persistence.UserPersistence.impl")
    protected UserPersistence userPersistence;
    @BeanReference(name = "com.liferay.portlet.tags.service.TagsEntryLocalService.impl")
    protected TagsEntryLocalService tagsEntryLocalService;
    @BeanReference(name = "com.liferay.portlet.tags.service.TagsEntryService.impl")
    protected TagsEntryService tagsEntryService;
    @BeanReference(name = "com.liferay.portlet.tags.service.persistence.TagsEntryPersistence.impl")
    protected TagsEntryPersistence tagsEntryPersistence;

    public MBCategoryLocalService getMBCategoryLocalService() {
        return mbCategoryLocalService;
    }

    public void setMBCategoryLocalService(
        MBCategoryLocalService mbCategoryLocalService) {
        this.mbCategoryLocalService = mbCategoryLocalService;
    }

    public MBCategoryService getMBCategoryService() {
        return mbCategoryService;
    }

    public void setMBCategoryService(MBCategoryService mbCategoryService) {
        this.mbCategoryService = mbCategoryService;
    }

    public MBCategoryPersistence getMBCategoryPersistence() {
        return mbCategoryPersistence;
    }

    public void setMBCategoryPersistence(
        MBCategoryPersistence mbCategoryPersistence) {
        this.mbCategoryPersistence = mbCategoryPersistence;
    }

    public MBCategoryFinder getMBCategoryFinder() {
        return mbCategoryFinder;
    }

    public void setMBCategoryFinder(MBCategoryFinder mbCategoryFinder) {
        this.mbCategoryFinder = mbCategoryFinder;
    }

    public MBMailingListLocalService getMBMailingListLocalService() {
        return mbMailingListLocalService;
    }

    public void setMBMailingListLocalService(
        MBMailingListLocalService mbMailingListLocalService) {
        this.mbMailingListLocalService = mbMailingListLocalService;
    }

    public MBMailingListPersistence getMBMailingListPersistence() {
        return mbMailingListPersistence;
    }

    public void setMBMailingListPersistence(
        MBMailingListPersistence mbMailingListPersistence) {
        this.mbMailingListPersistence = mbMailingListPersistence;
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

    public MBThreadLocalService getMBThreadLocalService() {
        return mbThreadLocalService;
    }

    public void setMBThreadLocalService(
        MBThreadLocalService mbThreadLocalService) {
        this.mbThreadLocalService = mbThreadLocalService;
    }

    public MBThreadService getMBThreadService() {
        return mbThreadService;
    }

    public void setMBThreadService(MBThreadService mbThreadService) {
        this.mbThreadService = mbThreadService;
    }

    public MBThreadPersistence getMBThreadPersistence() {
        return mbThreadPersistence;
    }

    public void setMBThreadPersistence(MBThreadPersistence mbThreadPersistence) {
        this.mbThreadPersistence = mbThreadPersistence;
    }

    public MBThreadFinder getMBThreadFinder() {
        return mbThreadFinder;
    }

    public void setMBThreadFinder(MBThreadFinder mbThreadFinder) {
        this.mbThreadFinder = mbThreadFinder;
    }

    public MBBanLocalService getMBBanLocalService() {
        return mbBanLocalService;
    }

    public void setMBBanLocalService(MBBanLocalService mbBanLocalService) {
        this.mbBanLocalService = mbBanLocalService;
    }

    public MBBanService getMBBanService() {
        return mbBanService;
    }

    public void setMBBanService(MBBanService mbBanService) {
        this.mbBanService = mbBanService;
    }

    public MBBanPersistence getMBBanPersistence() {
        return mbBanPersistence;
    }

    public void setMBBanPersistence(MBBanPersistence mbBanPersistence) {
        this.mbBanPersistence = mbBanPersistence;
    }

    public MBDiscussionLocalService getMBDiscussionLocalService() {
        return mbDiscussionLocalService;
    }

    public void setMBDiscussionLocalService(
        MBDiscussionLocalService mbDiscussionLocalService) {
        this.mbDiscussionLocalService = mbDiscussionLocalService;
    }

    public MBDiscussionPersistence getMBDiscussionPersistence() {
        return mbDiscussionPersistence;
    }

    public void setMBDiscussionPersistence(
        MBDiscussionPersistence mbDiscussionPersistence) {
        this.mbDiscussionPersistence = mbDiscussionPersistence;
    }

    public MBMessageFlagLocalService getMBMessageFlagLocalService() {
        return mbMessageFlagLocalService;
    }

    public void setMBMessageFlagLocalService(
        MBMessageFlagLocalService mbMessageFlagLocalService) {
        this.mbMessageFlagLocalService = mbMessageFlagLocalService;
    }

    public MBMessageFlagService getMBMessageFlagService() {
        return mbMessageFlagService;
    }

    public void setMBMessageFlagService(
        MBMessageFlagService mbMessageFlagService) {
        this.mbMessageFlagService = mbMessageFlagService;
    }

    public MBMessageFlagPersistence getMBMessageFlagPersistence() {
        return mbMessageFlagPersistence;
    }

    public void setMBMessageFlagPersistence(
        MBMessageFlagPersistence mbMessageFlagPersistence) {
        this.mbMessageFlagPersistence = mbMessageFlagPersistence;
    }

    public MBStatsUserLocalService getMBStatsUserLocalService() {
        return mbStatsUserLocalService;
    }

    public void setMBStatsUserLocalService(
        MBStatsUserLocalService mbStatsUserLocalService) {
        this.mbStatsUserLocalService = mbStatsUserLocalService;
    }

    public MBStatsUserPersistence getMBStatsUserPersistence() {
        return mbStatsUserPersistence;
    }

    public void setMBStatsUserPersistence(
        MBStatsUserPersistence mbStatsUserPersistence) {
        this.mbStatsUserPersistence = mbStatsUserPersistence;
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

    public SubscriptionLocalService getSubscriptionLocalService() {
        return subscriptionLocalService;
    }

    public void setSubscriptionLocalService(
        SubscriptionLocalService subscriptionLocalService) {
        this.subscriptionLocalService = subscriptionLocalService;
    }

    public SubscriptionPersistence getSubscriptionPersistence() {
        return subscriptionPersistence;
    }

    public void setSubscriptionPersistence(
        SubscriptionPersistence subscriptionPersistence) {
        this.subscriptionPersistence = subscriptionPersistence;
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
