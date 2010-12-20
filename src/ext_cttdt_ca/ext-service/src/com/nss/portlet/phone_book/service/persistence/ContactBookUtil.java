package com.nss.portlet.phone_book.service.persistence;

public class ContactBookUtil {
    private static ContactBookPersistence _persistence;

    public static void cacheResult(
        com.nss.portlet.phone_book.model.ContactBook contactBook) {
        getPersistence().cacheResult(contactBook);
    }

    public static void cacheResult(
        java.util.List<com.nss.portlet.phone_book.model.ContactBook> contactBooks) {
        getPersistence().cacheResult(contactBooks);
    }

    public static void clearCache() {
        getPersistence().clearCache();
    }

    public static com.nss.portlet.phone_book.model.ContactBook create(
        long contactBookId) {
        return getPersistence().create(contactBookId);
    }

    public static com.nss.portlet.phone_book.model.ContactBook remove(
        long contactBookId)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.phone_book.NoSuchContactBookException {
        return getPersistence().remove(contactBookId);
    }

    public static com.nss.portlet.phone_book.model.ContactBook remove(
        com.nss.portlet.phone_book.model.ContactBook contactBook)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(contactBook);
    }

    /**
     * @deprecated Use <code>update(ContactBook contactBook, boolean merge)</code>.
     */
    public static com.nss.portlet.phone_book.model.ContactBook update(
        com.nss.portlet.phone_book.model.ContactBook contactBook)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(contactBook);
    }

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
    public static com.nss.portlet.phone_book.model.ContactBook update(
        com.nss.portlet.phone_book.model.ContactBook contactBook, boolean merge)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(contactBook, merge);
    }

    public static com.nss.portlet.phone_book.model.ContactBook updateImpl(
        com.nss.portlet.phone_book.model.ContactBook contactBook, boolean merge)
        throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(contactBook, merge);
    }

    public static com.nss.portlet.phone_book.model.ContactBook findByPrimaryKey(
        long contactBookId)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.phone_book.NoSuchContactBookException {
        return getPersistence().findByPrimaryKey(contactBookId);
    }

    public static com.nss.portlet.phone_book.model.ContactBook fetchByPrimaryKey(
        long contactBookId) throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(contactBookId);
    }

    public static java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    public static java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    public static java.util.List<com.nss.portlet.phone_book.model.ContactBook> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.nss.portlet.phone_book.model.ContactBook> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.nss.portlet.phone_book.model.ContactBook> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end, obc);
    }

    public static void removeAll() throws com.liferay.portal.SystemException {
        getPersistence().removeAll();
    }

    public static int countAll() throws com.liferay.portal.SystemException {
        return getPersistence().countAll();
    }

    public static java.util.List<com.nss.portlet.phone_book.model.DetailBook> getDetailBooks(
        long pk) throws com.liferay.portal.SystemException {
        return getPersistence().getDetailBooks(pk);
    }

    public static java.util.List<com.nss.portlet.phone_book.model.DetailBook> getDetailBooks(
        long pk, int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().getDetailBooks(pk, start, end);
    }

    public static java.util.List<com.nss.portlet.phone_book.model.DetailBook> getDetailBooks(
        long pk, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().getDetailBooks(pk, start, end, obc);
    }

    public static int getDetailBooksSize(long pk)
        throws com.liferay.portal.SystemException {
        return getPersistence().getDetailBooksSize(pk);
    }

    public static boolean containsDetailBook(long pk, long detailBookPK)
        throws com.liferay.portal.SystemException {
        return getPersistence().containsDetailBook(pk, detailBookPK);
    }

    public static boolean containsDetailBooks(long pk)
        throws com.liferay.portal.SystemException {
        return getPersistence().containsDetailBooks(pk);
    }

    public static ContactBookPersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(ContactBookPersistence persistence) {
        _persistence = persistence;
    }
}
