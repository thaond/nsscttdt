package com.nss.portlet.phone_book.service.base;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.util.PortalUtil;

import com.nss.portlet.phone_book.model.DetailBook;
import com.nss.portlet.phone_book.service.ContactBookLocalService;
import com.nss.portlet.phone_book.service.ContactBookService;
import com.nss.portlet.phone_book.service.DetailBookLocalService;
import com.nss.portlet.phone_book.service.DetailBookService;
import com.nss.portlet.phone_book.service.persistence.ContactBookPersistence;
import com.nss.portlet.phone_book.service.persistence.DetailBookPersistence;

import java.util.List;


public abstract class DetailBookLocalServiceBaseImpl
    implements DetailBookLocalService {
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

    public DetailBook addDetailBook(DetailBook detailBook)
        throws SystemException {
        detailBook.setNew(true);

        return detailBookPersistence.update(detailBook, false);
    }

    public DetailBook createDetailBook(long detailBookId) {
        return detailBookPersistence.create(detailBookId);
    }

    public void deleteDetailBook(long detailBookId)
        throws PortalException, SystemException {
        detailBookPersistence.remove(detailBookId);
    }

    public void deleteDetailBook(DetailBook detailBook)
        throws SystemException {
        detailBookPersistence.remove(detailBook);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return detailBookPersistence.findWithDynamicQuery(dynamicQuery);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery, int start,
        int end) throws SystemException {
        return detailBookPersistence.findWithDynamicQuery(dynamicQuery, start,
            end);
    }

    public DetailBook getDetailBook(long detailBookId)
        throws PortalException, SystemException {
        return detailBookPersistence.findByPrimaryKey(detailBookId);
    }

    public List<DetailBook> getDetailBooks(int start, int end)
        throws SystemException {
        return detailBookPersistence.findAll(start, end);
    }

    public int getDetailBooksCount() throws SystemException {
        return detailBookPersistence.countAll();
    }

    public DetailBook updateDetailBook(DetailBook detailBook)
        throws SystemException {
        detailBook.setNew(false);

        return detailBookPersistence.update(detailBook, true);
    }

    public DetailBook updateDetailBook(DetailBook detailBook, boolean merge)
        throws SystemException {
        detailBook.setNew(false);

        return detailBookPersistence.update(detailBook, merge);
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
