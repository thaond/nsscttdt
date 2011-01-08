package com.sgs.portlet.career.service;


/**
 * <a href="CareerServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.sgs.portlet.career.service.CareerService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.career.service.CareerService
 *
 */
public class CareerServiceUtil {
    private static CareerService _service;

    public static CareerService getService() {
        if (_service == null) {
            throw new RuntimeException("CareerService is not set");
        }

        return _service;
    }

    public void setService(CareerService service) {
        _service = service;
    }
}
