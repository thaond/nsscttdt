package com.nss.portlet.phone_book.service.base;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.service.base.PrincipalBean;
import com.liferay.portal.util.PortalUtil;

import com.nss.portlet.phone_book.service.ContactBookLocalService;
import com.nss.portlet.phone_book.service.ContactBookService;
import com.nss.portlet.phone_book.service.DetailBookLocalService;
import com.nss.portlet.phone_book.service.DetailBookService;
import com.nss.portlet.phone_book.service.persistence.ContactBookPersistence;
import com.nss.portlet.phone_book.service.persistence.DetailBookPersistence;


public abstract class ContactBookServiceBaseImpl extends PrincipalBean
    implements ContactBookService {
    @BeanReference(name = "com.nss.portlet.phone_book.service.ContactBookLocalService.impl")
    protected ContactBookLocalService contactBookLocalService;
    @BeanReference(name = "com.nss.portlet.phone_book.service.ContactBookService.impl")
    protected ContactBookService contactBookService;
    @BeanReference(name = "com.nss.portlet.phone_book.service.persistence.ContactBookPersistence.impl")
    protected ContactBookPersistence contactBookPersistence;
    @BeanReference(name = "com.nss.portlet.phone_book.service.DetailBookLocalService.impl")
    protected DetailBookLocalService detailBookLocalService;
    @BeanReference(name = "com.nss.portlet.phone_book.service.DetailBookService.impl")
    protected DetailBookService detailBookService;
    @BeanReference(name = "com.nss.portlet.phone_book.service.persistence.DetailBookPersistence.impl")
    protected DetailBookPersistence detailBookPersistence;

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

    protected void runSQL(String sql) throws SystemException {
        try {
            PortalUtil.runSQL(sql);
        } catch (Exception e) {
            throw new SystemException(e);
        }
    }
}
