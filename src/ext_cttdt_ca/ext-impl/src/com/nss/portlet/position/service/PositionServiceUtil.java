package com.nss.portlet.position.service;


/**
 * <a href="PositionServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.nss.portlet.position.service.PositionService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.position.service.PositionService
 *
 */
public class PositionServiceUtil {
    private static PositionService _service;

    public static PositionService getService() {
        if (_service == null) {
            throw new RuntimeException("PositionService is not set");
        }

        return _service;
    }

    public void setService(PositionService service) {
        _service = service;
    }
}
