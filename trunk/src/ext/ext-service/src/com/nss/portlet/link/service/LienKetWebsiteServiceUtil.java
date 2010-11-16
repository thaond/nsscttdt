package com.nss.portlet.link.service;


/**
 * <a href="LienKetWebsiteServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.nss.portlet.link.service.LienKetWebsiteService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.link.service.LienKetWebsiteService
 *
 */
public class LienKetWebsiteServiceUtil {
    private static LienKetWebsiteService _service;

    public static LienKetWebsiteService getService() {
        if (_service == null) {
            throw new RuntimeException("LienKetWebsiteService is not set");
        }

        return _service;
    }

    public void setService(LienKetWebsiteService service) {
        _service = service;
    }
}
