package com.sgs.portlet.agency.service;


/**
 * <a href="AgencyServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.sgs.portlet.agency.service.AgencyService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.agency.service.AgencyService
 *
 */
public class AgencyServiceUtil {
    private static AgencyService _service;

    public static AgencyService getService() {
        if (_service == null) {
            throw new RuntimeException("AgencyService is not set");
        }

        return _service;
    }

    public void setService(AgencyService service) {
        _service = service;
    }
}
