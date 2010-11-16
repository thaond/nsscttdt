package com.nss.portlet.co_quan_ban_hanh.service;


/**
 * <a href="CoQuanBanHanhServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.nss.portlet.co_quan_ban_hanh.service.CoQuanBanHanhService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.co_quan_ban_hanh.service.CoQuanBanHanhService
 *
 */
public class CoQuanBanHanhServiceUtil {
    private static CoQuanBanHanhService _service;

    public static CoQuanBanHanhService getService() {
        if (_service == null) {
            throw new RuntimeException("CoQuanBanHanhService is not set");
        }

        return _service;
    }

    public void setService(CoQuanBanHanhService service) {
        _service = service;
    }
}
