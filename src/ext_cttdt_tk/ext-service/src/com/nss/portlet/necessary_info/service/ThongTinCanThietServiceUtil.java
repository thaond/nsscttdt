package com.nss.portlet.necessary_info.service;


/**
 * <a href="ThongTinCanThietServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.nss.portlet.necessary_info.service.ThongTinCanThietService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.necessary_info.service.ThongTinCanThietService
 *
 */
public class ThongTinCanThietServiceUtil {
    private static ThongTinCanThietService _service;

    public static ThongTinCanThietService getService() {
        if (_service == null) {
            throw new RuntimeException("ThongTinCanThietService is not set");
        }

        return _service;
    }

    public void setService(ThongTinCanThietService service) {
        _service = service;
    }
}
