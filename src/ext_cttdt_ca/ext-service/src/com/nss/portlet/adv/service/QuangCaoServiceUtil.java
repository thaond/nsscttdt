package com.nss.portlet.adv.service;


/**
 * <a href="QuangCaoServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.nss.portlet.adv.service.QuangCaoService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.adv.service.QuangCaoService
 *
 */
public class QuangCaoServiceUtil {
    private static QuangCaoService _service;

    public static QuangCaoService getService() {
        if (_service == null) {
            throw new RuntimeException("QuangCaoService is not set");
        }

        return _service;
    }

    public void setService(QuangCaoService service) {
        _service = service;
    }
}
