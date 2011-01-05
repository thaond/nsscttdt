package com.nss.portlet.phone_book.service.base;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.service.base.PrincipalBean;
import com.liferay.portal.util.PortalUtil;

import com.nss.portlet.phone_book.service.ContactBookLocalService;
import com.nss.portlet.phone_book.service.ContactBookService;
import com.nss.portlet.phone_book.service.DetailBookLocalService;
import com.nss.portlet.phone_book.service.DetailBookService;
import com.nss.portlet.phone_book.service.persistence.ContactBookFinder;
import com.nss.portlet.phone_book.service.persistence.ContactBookPersistence;
import com.nss.portlet.phone_book.service.persistence.DetailBookFinder;
import com.nss.portlet.phone_book.service.persistence.DetailBookPersistence;


public abstract class DetailBookServiceBaseImpl extends PrincipalBean
    implements DetailBookService {
    @BeanReference(name = "com.nss.portlet.phone_book.service.ContactBookLocalService.impl")
    protected ContactBookLocalService contactBookLocalService;
    @BeanReference(name = "com.nss.portlet.phone_book.service.ContactBookService.impl")
    protected ContactBookService contactBookService;
    @BeanReference(name = "com.nss.portlet.phone_book.service.persistence.ContactBookPersistence.impl")
    protected ContactBookPersistence contactBookPersistence;
    @BeanReference(name = "com.nss.portlet.phone_book.service.persistence.ContactBookFinder.impl")
    protected ContactBookFinder contactBookFinder;
    @BeanReference(name = "com.nss.portlet.phone_book.service.DetailBookLocalService.impl")
    protected DetailBookLocalService detailBookLocalService;
    @BeanReference(name = "com.nss.portlet.phone_book.service.DetailBookService.impl")
    protected DetailBookService detailBookService;
    @BeanReference(name = "com.nss.portlet.phone_book.service.persistence.DetailBookPersistence.impl")
    protected DetailBookPersistence detailBookPersistence;
    @BeanReference(name = "com.nss.portlet.phone_book.service.persistence.DetailBookFinder.impl")
    protected DetailBookFinder detailBookFinder;

    public ContactBookLocalService getContactBookLocalService() {
        return contactBookLocalService;
    }

    public void setContactBookLocalService(
        ContactBookLocalService contactBookLocalService) {
        this.contactBookLocalService = contactBookLocalService;
    }

    public ContactBookService getContactBookService() {
        return contactBookService;
    }

    public void setContactBookService(ContactBookService contactBookService) {
        this.contactBookService = contactBookService;
    }

    public ContactBookPersistence getContactBookPersistence() {
        return contactBookPersistence;
    }

    public void setContactBookPersistence(
        ContactBookPersistence contactBookPersistence) {
        this.contactBookPersistence = contactBookPersistence;
    }

    public ContactBookFinder getContactBookFinder() {
        return contactBookFinder;
    }

    public void setContactBookFinder(ContactBookFinder contactBookFinder) {
        this.contactBookFinder = contactBookFinder;
    }

    public DetailBookLocalService getDetailBookLocalService() {
        return detailBookLocalService;
    }

    public void setDetailBookLocalService(
        DetailBookLocalService detailBookLocalService) {
        this.detailBookLocalService = detailBookLocalService;
    }

    public DetailBookService getDetailBookService() {
        return detailBookService;
    }

    public void setDetailBookService(DetailBookService detailBookService) {
        this.detailBookService = detailBookService;
    }

    public DetailBookPersistence getDetailBookPersistence() {
        return detailBookPersistence;
    }

    public void setDetailBookPersistence(
        DetailBookPersistence detailBookPersistence) {
        this.detailBookPersistence = detailBookPersistence;
    }

    public DetailBookFinder getDetailBookFinder() {
        return detailBookFinder;
    }

    public void setDetailBookFinder(DetailBookFinder detailBookFinder) {
        this.detailBookFinder = detailBookFinder;
    }

    protected void runSQL(String sql) throws SystemException {
        try {
            PortalUtil.runSQL(sql);
        } catch (Exception e) {
            throw new SystemException(e);
        }
    }
}
