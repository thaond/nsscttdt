package com.nss.portlet.phone_book.service;


/**
 * <a href="ContactBookServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.nss.portlet.phone_book.service.ContactBookService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.phone_book.service.ContactBookService
 *
 */
public class ContactBookServiceUtil {
    private static ContactBookService _service;

    public static ContactBookService getService() {
        if (_service == null) {
            throw new RuntimeException("ContactBookService is not set");
        }

        return _service;
    }

    public void setService(ContactBookService service) {
        _service = service;
    }
}
