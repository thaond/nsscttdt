package com.nss.portlet.phone_book.service;


/**
 * <a href="DetailBookServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.nss.portlet.phone_book.service.DetailBookService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.phone_book.service.DetailBookService
 *
 */
public class DetailBookServiceUtil {
    private static DetailBookService _service;

    public static DetailBookService getService() {
        if (_service == null) {
            throw new RuntimeException("DetailBookService is not set");
        }

        return _service;
    }

    public void setService(DetailBookService service) {
        _service = service;
    }
}
