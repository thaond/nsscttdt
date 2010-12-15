package com.nss.portlet.phone_book.service;


/**
 * <a href="DetailBookLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.nss.portlet.phone_book.service.DetailBookLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.phone_book.service.DetailBookLocalService
 *
 */
public class DetailBookLocalServiceUtil {
    private static DetailBookLocalService _service;

    public static com.nss.portlet.phone_book.model.DetailBook addDetailBook(
        com.nss.portlet.phone_book.model.DetailBook detailBook)
        throws com.liferay.portal.SystemException {
        return getService().addDetailBook(detailBook);
    }

    public static com.nss.portlet.phone_book.model.DetailBook createDetailBook(
        long detailBookId) {
        return getService().createDetailBook(detailBookId);
    }

    public static void deleteDetailBook(long detailBookId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deleteDetailBook(detailBookId);
    }

    public static void deleteDetailBook(
        com.nss.portlet.phone_book.model.DetailBook detailBook)
        throws com.liferay.portal.SystemException {
        getService().deleteDetailBook(detailBook);
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

    public static com.nss.portlet.phone_book.model.DetailBook getDetailBook(
        long detailBookId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getDetailBook(detailBookId);
    }

    public static java.util.List<com.nss.portlet.phone_book.model.DetailBook> getDetailBooks(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getDetailBooks(start, end);
    }

    public static int getDetailBooksCount()
        throws com.liferay.portal.SystemException {
        return getService().getDetailBooksCount();
    }

    public static com.nss.portlet.phone_book.model.DetailBook updateDetailBook(
        com.nss.portlet.phone_book.model.DetailBook detailBook)
        throws com.liferay.portal.SystemException {
        return getService().updateDetailBook(detailBook);
    }

    public static com.nss.portlet.phone_book.model.DetailBook updateDetailBook(
        com.nss.portlet.phone_book.model.DetailBook detailBook, boolean merge)
        throws com.liferay.portal.SystemException {
        return getService().updateDetailBook(detailBook, merge);
    }

    public static DetailBookLocalService getService() {
        if (_service == null) {
            throw new RuntimeException("DetailBookLocalService is not set");
        }

        return _service;
    }

    public void setService(DetailBookLocalService service) {
        _service = service;
    }
}
