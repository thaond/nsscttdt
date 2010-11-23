package com.nss.portlet.link.service;


/**
 * <a href="LoaiWebsiteServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.nss.portlet.link.service.LoaiWebsiteService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.link.service.LoaiWebsiteService
 *
 */
public class LoaiWebsiteServiceUtil {
    private static LoaiWebsiteService _service;

    public static LoaiWebsiteService getService() {
        if (_service == null) {
            throw new RuntimeException("LoaiWebsiteService is not set");
        }

        return _service;
    }

    public void setService(LoaiWebsiteService service) {
        _service = service;
    }
}
