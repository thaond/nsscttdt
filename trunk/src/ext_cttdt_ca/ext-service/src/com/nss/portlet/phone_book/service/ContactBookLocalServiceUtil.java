package com.nss.portlet.phone_book.service;


/**
 * <a href="ContactBookLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.nss.portlet.phone_book.service.ContactBookLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.phone_book.service.ContactBookLocalService
 *
 */
public class ContactBookLocalServiceUtil {
    private static ContactBookLocalService _service;

    public static com.nss.portlet.phone_book.model.ContactBook addContactBook(
        com.nss.portlet.phone_book.model.ContactBook contactBook)
        throws com.liferay.portal.SystemException {
        return getService().addContactBook(contactBook);
    }

    public static com.nss.portlet.phone_book.model.ContactBook createContactBook(
        long contactBookId) {
        return getService().createContactBook(contactBookId);
    }

    public static void deleteContactBook(long contactBookId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deleteContactBook(contactBookId);
    }

    public static void deleteContactBook(
        com.nss.portlet.phone_book.model.ContactBook contactBook)
        throws com.liferay.portal.SystemException {
        getService().deleteContactBook(contactBook);
    }

    public static java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException {
        return getService().dynamicQuery(dynamicQuery);
    }

    public static java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException {
        return getService().dynamicQuery(dynamicQuery, start, end);
    }

    public static com.nss.portlet.phone_book.model.ContactBook getContactBook(
        long contactBookId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getContactBook(contactBookId);
    }

    public static java.util.List<com.nss.portlet.phone_book.model.ContactBook> getContactBooks(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getContactBooks(start, end);
    }

    public static int getContactBooksCount()
        throws com.liferay.portal.SystemException {
        return getService().getContactBooksCount();
    }

    public static com.nss.portlet.phone_book.model.ContactBook updateContactBook(
        com.nss.portlet.phone_book.model.ContactBook contactBook)
        throws com.liferay.portal.SystemException {
        return getService().updateContactBook(contactBook);
    }

    public static com.nss.portlet.phone_book.model.ContactBook updateContactBook(
        com.nss.portlet.phone_book.model.ContactBook contactBook, boolean merge)
        throws com.liferay.portal.SystemException {
        return getService().updateContactBook(contactBook, merge);
    }

    public static int countByKeyword(java.lang.String keywords)
        throws com.liferay.portal.SystemException {
        return getService().countByKeyword(keywords);
    }

    public static java.util.List<com.nss.portlet.phone_book.model.ContactBook> findByKeyword(
        java.lang.String keywords, int start, int end, boolean andOperator,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService().findByKeyword(keywords, start, end, andOperator, obc);
    }

    public static int countContactBook(java.lang.String contactBookCodes,
        java.lang.String contactBookNames,
        java.lang.String contactBookDescriptions, boolean andOperator)
        throws com.liferay.portal.SystemException {
        return getService()
                   .countContactBook(contactBookCodes, contactBookNames,
            contactBookDescriptions, andOperator);
    }

    public static java.util.List<com.nss.portlet.phone_book.model.ContactBook> findContactBook(
        java.lang.String contactBookCodes, java.lang.String contactBookNames,
        java.lang.String contactBookDescriptions, int start, int end,
        boolean andOperator,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService()
                   .findContactBook(contactBookCodes, contactBookNames,
            contactBookDescriptions, start, end, andOperator, obc);
    }

    public static java.util.List<com.nss.portlet.phone_book.model.DetailBook> getDetailBooks(
        long contactBookId) throws com.liferay.portal.SystemException {
        return getService().getDetailBooks(contactBookId);
    }

    public static void reIndex(java.lang.String[] ids)
        throws com.liferay.portal.SystemException {
        getService().reIndex(ids);
    }

    public static void reIndex(long companyId,
        com.nss.portlet.phone_book.model.ContactBook contactBook)
        throws com.liferay.portal.kernel.search.SearchException {
        getService().reIndex(companyId, contactBook);
    }

    public static com.liferay.portal.kernel.search.Hits search(long companyId,
        java.lang.String contactBookCode, java.lang.String contactBookName,
        java.lang.String contactDescription, java.lang.String sortField,
        int sortType, boolean reverse, int start, int end)
        throws com.liferay.portal.SystemException {
        return getService()
                   .search(companyId, contactBookCode, contactBookName,
            contactDescription, sortField, sortType, reverse, start, end);
    }

    public static com.liferay.portal.kernel.search.Hits search(long companyId,
        java.lang.String keywords, java.lang.String sortField, int sortType,
        boolean reverse, int start, int end)
        throws com.liferay.portal.SystemException {
        return getService()
                   .search(companyId, keywords, sortField, sortType, reverse,
            start, end);
    }

    public static com.nss.portlet.phone_book.model.ContactBook addContactBook(
        long companyId, com.nss.portlet.phone_book.model.ContactBook contactBook)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.kernel.search.SearchException {
        return getService().addContactBook(companyId, contactBook);
    }

    public static com.nss.portlet.phone_book.model.ContactBook updateContactBook(
        long companyId, com.nss.portlet.phone_book.model.ContactBook contactBook)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.kernel.search.SearchException {
        return getService().updateContactBook(companyId, contactBook);
    }

    public static void deleteContactBook(long companyId, long contactBookId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.kernel.search.SearchException,
            com.nss.portlet.phone_book.NoSuchContactBookException {
        getService().deleteContactBook(companyId, contactBookId);
    }

    public static void deleteContactBook(long companyId,
        com.nss.portlet.phone_book.model.ContactBook contactBook)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.kernel.search.SearchException {
        getService().deleteContactBook(companyId, contactBook);
    }

    public static ContactBookLocalService getService() {
        if (_service == null) {
            throw new RuntimeException("ContactBookLocalService is not set");
        }

        return _service;
    }

    public void setService(ContactBookLocalService service) {
        _service = service;
    }
}
