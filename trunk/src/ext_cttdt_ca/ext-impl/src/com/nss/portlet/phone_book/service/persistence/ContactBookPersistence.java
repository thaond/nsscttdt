package com.nss.portlet.phone_book.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;


public interface ContactBookPersistence extends BasePersistence {
    public void cacheResult(
        com.nss.portlet.phone_book.model.ContactBook contactBook);

    public void cacheResult(
        java.util.List<com.nss.portlet.phone_book.model.ContactBook> contactBooks);

    public void clearCache();

    public com.nss.portlet.phone_book.model.ContactBook create(
        long contactBookId);

    public com.nss.portlet.phone_book.model.ContactBook remove(
        long contactBookId)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.phone_book.NoSuchContactBookException;

    public com.nss.portlet.phone_book.model.ContactBook remove(
        com.nss.portlet.phone_book.model.ContactBook contactBook)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(ContactBook contactBook, boolean merge)</code>.
     */
    public com.nss.portlet.phone_book.model.ContactBook update(
        com.nss.portlet.phone_book.model.ContactBook contactBook)
        throws com.liferay.portal.SystemException;

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                contactBook the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when contactBook is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public com.nss.portlet.phone_book.model.ContactBook update(
        com.nss.portlet.phone_book.model.ContactBook contactBook, boolean merge)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.phone_book.model.ContactBook updateImpl(
        com.nss.portlet.phone_book.model.ContactBook contactBook, boolean merge)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.phone_book.model.ContactBook findByPrimaryKey(
        long contactBookId)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.phone_book.NoSuchContactBookException;

    public com.nss.portlet.phone_book.model.ContactBook fetchByPrimaryKey(
        long contactBookId) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.phone_book.model.ContactBook> findByCompanyid(
        long companyid) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.phone_book.model.ContactBook> findByCompanyid(
        long companyid, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.phone_book.model.ContactBook> findByCompanyid(
        long companyid, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.phone_book.model.ContactBook findByCompanyid_First(
        long companyid, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.phone_book.NoSuchContactBookException;

    public com.nss.portlet.phone_book.model.ContactBook findByCompanyid_Last(
        long companyid, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.phone_book.NoSuchContactBookException;

    public com.nss.portlet.phone_book.model.ContactBook[] findByCompanyid_PrevAndNext(
        long contactBookId, long companyid,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.phone_book.NoSuchContactBookException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.phone_book.model.ContactBook> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.phone_book.model.ContactBook> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.phone_book.model.ContactBook> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeByCompanyid(long companyid)
        throws com.liferay.portal.SystemException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countByCompanyid(long companyid)
        throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.phone_book.model.DetailBook> getDetailBooks(
        long pk) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.phone_book.model.DetailBook> getDetailBooks(
        long pk, int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.phone_book.model.DetailBook> getDetailBooks(
        long pk, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public int getDetailBooksSize(long pk)
        throws com.liferay.portal.SystemException;

    public boolean containsDetailBook(long pk, long detailBookPK)
        throws com.liferay.portal.SystemException;

    public boolean containsDetailBooks(long pk)
        throws com.liferay.portal.SystemException;
}
