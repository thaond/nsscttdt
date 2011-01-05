package com.nss.portlet.phone_book.service.base;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.util.PortalUtil;

import com.nss.portlet.phone_book.model.ContactBook;
import com.nss.portlet.phone_book.service.ContactBookLocalService;
import com.nss.portlet.phone_book.service.ContactBookService;
import com.nss.portlet.phone_book.service.DetailBookLocalService;
import com.nss.portlet.phone_book.service.DetailBookService;
import com.nss.portlet.phone_book.service.persistence.ContactBookFinder;
import com.nss.portlet.phone_book.service.persistence.ContactBookPersistence;
import com.nss.portlet.phone_book.service.persistence.DetailBookFinder;
import com.nss.portlet.phone_book.service.persistence.DetailBookPersistence;

import java.util.List;


public abstract class ContactBookLocalServiceBaseImpl
    implements ContactBookLocalService {
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

    public ContactBook addContactBook(ContactBook contactBook)
        throws SystemException {
        contactBook.setNew(true);

        return contactBookPersistence.update(contactBook, false);
    }

    public ContactBook createContactBook(long contactBookId) {
        return contactBookPersistence.create(contactBookId);
    }

    public void deleteContactBook(long contactBookId)
        throws PortalException, SystemException {
        contactBookPersistence.remove(contactBookId);
    }

    public void deleteContactBook(ContactBook contactBook)
        throws SystemException {
        contactBookPersistence.remove(contactBook);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return contactBookPersistence.findWithDynamicQuery(dynamicQuery);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery, int start,
        int end) throws SystemException {
        return contactBookPersistence.findWithDynamicQuery(dynamicQuery, start,
            end);
    }

    public ContactBook getContactBook(long contactBookId)
        throws PortalException, SystemException {
        return contactBookPersistence.findByPrimaryKey(contactBookId);
    }

    public List<ContactBook> getContactBooks(int start, int end)
        throws SystemException {
        return contactBookPersistence.findAll(start, end);
    }

    public int getContactBooksCount() throws SystemException {
        return contactBookPersistence.countAll();
    }

    public ContactBook updateContactBook(ContactBook contactBook)
        throws SystemException {
        contactBook.setNew(false);

        return contactBookPersistence.update(contactBook, true);
    }

    public ContactBook updateContactBook(ContactBook contactBook, boolean merge)
        throws SystemException {
        contactBook.setNew(false);

        return contactBookPersistence.update(contactBook, merge);
    }

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
